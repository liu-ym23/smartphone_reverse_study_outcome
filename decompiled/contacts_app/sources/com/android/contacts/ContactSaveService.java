package com.android.contacts;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.SimContactsOperation;
import com.android.contacts.common.reflection.IIccPhoneBookUtil;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityDeltaList;
import com.android.contacts.obricsync.LocalToSyncUtils;
import com.android.contacts.obricsync.SyncContractKt;
import com.android.contacts.obricsync.SyncToLocalUtils;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.ContactPhotoUtils;
import com.android.contacts.util.MemoryCardUtil;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.android.collect.Lists;
import com.google.android.collect.Sets;
import com.obric.contactsdk.loader.ContractKt;
import com.obric.privacyhook.BaseIntentService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ContactSaveService extends BaseIntentService {
    public static final String ACTION_CLEAR_PRIMARY = "clearPrimary";
    public static final String ACTION_CREATE_GROUP = "createGroup";
    public static final String ACTION_DELETE_CONTACT = "delete";
    public static final String ACTION_DELETE_GROUP = "deleteGroup";
    public static final String ACTION_DELETE_MULTI_CONTACTS = "delete_multi_contacts";
    public static final String ACTION_DELETE_RAW_CONTACT = "delete_raw_contact";
    public static final String ACTION_JOIN_CONTACTS = "joinContacts";
    public static final String ACTION_NEW_RAW_CONTACT = "newRawContact";
    public static final String ACTION_RENAME_GROUP = "renameGroup";
    public static final String ACTION_SAVE_CONTACT = "saveContact";
    public static final String ACTION_SET_LOCATION = "setLocation";
    public static final String ACTION_SET_PHONE_STARRED = "setPhoneStarred";
    public static final String ACTION_SET_RINGTONE = "setRingtone";
    public static final String ACTION_SET_SEND_TO_VOICEMAIL = "sendToVoicemail";
    public static final String ACTION_SET_STARRED = "setStarred";
    public static final String ACTION_SET_SUPER_PRIMARY = "setSuperPrimary";
    public static final String ACTION_UPDATE_CONTACT_GROUPS = "updateContactGroups";
    public static final String ACTION_UPDATE_CONTACT_GROUPS_WITH_GROUPNAME = "updateContactGroupsWithGroupName";
    public static final String ACTION_UPDATE_GROUP = "updateGroup";
    private static final HashSet<String> ALLOWED_DATA_COLUMNS = null;
    private static final boolean DEBUG = false;
    public static final String EXTRA_ACCOUNT_NAME = "accountName";
    public static final String EXTRA_ACCOUNT_TYPE = "accountType";
    public static final String EXTRA_CALLBACK_INTENT = "callbackIntent";
    public static final String EXTRA_CONTACTS_IDS = "contactsIds";
    public static final String EXTRA_CONTACT_ID = "contactId";
    public static final String EXTRA_CONTACT_ID1 = "contactId1";
    public static final String EXTRA_CONTACT_ID2 = "contactId2";
    public static final String EXTRA_CONTACT_STATE = "state";
    public static final String EXTRA_CONTACT_URI = "contactUri";
    public static final String EXTRA_CONTACT_WRITABLE = "contactWritable";
    public static final String EXTRA_CONTENT_VALUES = "contentValues";
    public static final String EXTRA_CUSTOM_RINGTONE = "customRingtone";
    public static final String EXTRA_DATA_ID = "dataId";
    public static final String EXTRA_DATA_SET = "dataSet";
    public static final String EXTRA_GROUP_ID = "groupId";
    public static final String EXTRA_GROUP_IDS_TO_ADD = "groupIdsToAdd";
    public static final String EXTRA_GROUP_IDS_TO_REMOVE = "groupIdsToRemove";
    public static final String EXTRA_GROUP_LABEL = "groupLabel";
    public static final String EXTRA_LOCATION_COORDINATES = "LocationCoordinates";
    public static final String EXTRA_PHONE_NUMBER = "phoneNumber";
    public static final String EXTRA_RAW_CONTACTS_TO_ADD = "rawContactsToAdd";
    public static final String EXTRA_RAW_CONTACTS_TO_REMOVE = "rawContactsToRemove";
    public static final String EXTRA_RAW_CONTACT_ID = "rawContactId";
    public static final String EXTRA_RAW_CONTACT_URI = "rawContactUri";
    public static final String EXTRA_SAVE_IS_INSERT = "saveIsInsert";
    public static final String EXTRA_SAVE_IS_PROFILE = "saveIsProfile";
    public static final String EXTRA_SAVE_MODE = "saveMode";
    public static final String EXTRA_SAVE_SUCCEEDED = "saveSucceeded";
    public static final String EXTRA_SEND_TO_VOICEMAIL_FLAG = "sendToVoicemailFlag";
    public static final String EXTRA_STARRED_FLAG = "starred";
    public static final String EXTRA_UPDATED_PHOTOS = "updatedPhotos";
    private static final int MAX_OPERATIONS_PER_YIELD_POINT = 500;
    private static final int MAX_REQUEST_LOCATION_TIMES = 3;
    private static final int PERSIST_TRIES = 3;
    private static final int REQUEST_LOCATION_DELAY = 3000;
    public static final String REQUEST_LOCATION_TIMES = "requestLocationTimes";
    public static final int RESULT_AIR_PLANE_MODE = 10;
    public static final int RESULT_EMAIL_FAILURE = 5;
    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_MEMORY_FULL_FAILURE = 11;
    public static final int RESULT_NO_NUMBER_AND_EMAIL = 3;
    public static final int RESULT_NO_SIM_FAILURE = 13;
    public static final int RESULT_NUMBER_ANR_FAILURE = 6;
    public static final int RESULT_NUMBER_INVALID = 9;
    public static final int RESULT_NUMBER_TYPE_FAILURE = 12;
    public static final int RESULT_SIM_FAILURE = 4;
    public static final int RESULT_SIM_FULL_FAILURE = 7;
    public static final int RESULT_SUCCESS = 1;
    public static final int RESULT_TAG_FAILURE = 8;
    public static final int RESULT_UNCHANGED = 0;
    public static final String SAVE_CONTACT_RESULT = "saveResult";
    private static final String TAG = "ContactSaveService";
    private static final int TWO_MINUTES = 120000;
    private static int count = 0;
    public static boolean mIsPhoneStarChang = false;
    public static SimContactsOperation mSimContactsOperation;
    private static int[] mSimMaxCount;
    private static final CopyOnWriteArrayList<Listener> sListeners = null;
    private final int MAX_CH_LENGTH;
    private final int MAX_EMAIL_LENGTH;
    private final int MAX_EN_LENGTH;
    private final int MAX_NUM_LENGTH;
    private Handler mMainHandler;

    public static final enum FavoriteAction extends Enum<FavoriteAction> {
        private static final /* synthetic */ FavoriteAction[] $VALUES = null;
        public static final FavoriteAction ADD = null;
        public static final FavoriteAction REMOVE = null;
        public static final FavoriteAction RESET = null;

        private static /* synthetic */ FavoriteAction[] $values() {
            return new FavoriteAction[]{ADD, REMOVE, RESET};
        }

        private FavoriteAction(String r1, int r2) {
            super(r1, r2);
        }

        public static FavoriteAction valueOf(String r1) {
            return (FavoriteAction) Enum.valueOf(FavoriteAction.class, r1);
        }

        public static FavoriteAction[] values() {
            return (FavoriteAction[]) $VALUES.clone();
        }

        static {
            ADD = new FavoriteAction("ADD", 0);
            REMOVE = new FavoriteAction("REMOVE", 1);
            RESET = new FavoriteAction("RESET", 2);
            $VALUES = $values();
        }
    }

    private interface JoinContactQuery {
        public static final int CONTACT_ID = 1;
        public static final int DISPLAY_NAME_SOURCE = 2;
        public static final String[] PROJECTION = null;
        public static final String SELECTION = "contact_id=? OR contact_id=?";
        public static final int _ID = 0;

        static {
            PROJECTION = new String[]{"_id", "contact_id", "display_name_source"};
        }
    }

    public interface Listener {
        void onServiceCompleted(Intent r1);
    }

    static {
        DEBUG = ContactsUtils.DEBUG;
        ALLOWED_DATA_COLUMNS = Sets.newHashSet(new String[]{"mimetype", "is_primary", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME, BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN, "data14", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG});
        int r0 = DSUtils.getPhoneCount();
        count = r0;
        mSimMaxCount = new int[r0];
        sListeners = new CopyOnWriteArrayList();
    }

    @Override // com.obric.privacyhook.BaseIntentService
    protected void handleAction(String r2, Intent r3) {
        if (ACTION_NEW_RAW_CONTACT.equals(r2) == false) goto L6;
        createRawContact(r3);
        return;
    L6:
        if (ACTION_SAVE_CONTACT.equals(r2) == false) goto L9;
        saveContact(r3);
        return;
    L9:
        if (ACTION_UPDATE_CONTACT_GROUPS.equals(r2) == false) goto L12;
        updateContactGroupsData(r3);
        return;
    L12:
        if (ACTION_UPDATE_CONTACT_GROUPS_WITH_GROUPNAME.equals(r2) == false) goto L15;
        updateContactGroupsDataWithGroupName(r3);
        return;
    L15:
        if (ACTION_CREATE_GROUP.equals(r2) == false) goto L18;
        createGroup(r3);
        return;
    L18:
        if (ACTION_RENAME_GROUP.equals(r2) == false) goto L21;
        renameGroup(r3);
        return;
    L21:
        if (ACTION_DELETE_GROUP.equals(r2) == false) goto L24;
        deleteGroup(r3);
        return;
    L24:
        if (ACTION_UPDATE_GROUP.equals(r2) == false) goto L27;
        updateGroup(r3);
        return;
    L27:
        if (ACTION_SET_STARRED.equals(r2) == false) goto L30;
        setStarred(r3);
        return;
    L30:
        if (ACTION_SET_PHONE_STARRED.equals(r2) == false) goto L33;
        setPhoneStarred(r3);
        return;
    L33:
        if (ACTION_SET_SUPER_PRIMARY.equals(r2) == false) goto L36;
        setSuperPrimary(r3);
        return;
    L36:
        if (ACTION_CLEAR_PRIMARY.equals(r2) == false) goto L39;
        clearPrimary(r3);
        return;
    L39:
        if ("delete".equals(r2) == false) goto L42;
        deleteContact(r3);
        return;
    L42:
        if (ACTION_DELETE_RAW_CONTACT.equals(r2) == false) goto L45;
        deleteRawContact(r3);
        return;
    L45:
        if (ACTION_JOIN_CONTACTS.equals(r2) == false) goto L48;
        joinContacts(r3);
        return;
    L48:
        if (ACTION_SET_SEND_TO_VOICEMAIL.equals(r2) == false) goto L51;
        setSendToVoicemail(r3);
        return;
    L51:
        if (ACTION_SET_RINGTONE.equals(r2) == false) goto L54;
        setRingtone(r3);
        return;
    L54:
        if (ACTION_SET_LOCATION.endsWith(r2) == false) goto L57;
        requestLocation(r3);
        return;
    L57:
        if (ACTION_DELETE_MULTI_CONTACTS.equals(r2) == false) goto L78;
        deleteMultiContacts(r3);
        return;
    }

    public ContactSaveService() {
        super(TAG);
        this.MAX_NUM_LENGTH = 20;
        this.MAX_EMAIL_LENGTH = 40;
        this.MAX_EN_LENGTH = 14;
        this.MAX_CH_LENGTH = 6;
        setIntentRedelivery(true);
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    public static void registerListener(Listener r2) {
        if ((r2 instanceof Activity) == false) goto L7;
        sListeners.add(0, r2);
        return;
    L7:
        throw new ClassCastException("Only activities can be registered to receive callback from " + ContactSaveService.class.getName());
    }

    public static void unregisterListener(Listener r1) {
        sListeners.remove(r1);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r2) {
        Object r0 = super.getSystemService(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getApplicationContext().getSystemService(r2);
    }

    private int getSimCardMaxCount() {
        int r2 = mSimMaxCount[0];
        if (r2 == 0) goto L5;
        return r2;
    L5:
        List<?> r3 = IIccPhoneBookUtil.getAdnRecordsInEf(IIccPhoneBookUtil.EF_ADN);
        if (r3 == null) goto L9;
        mSimMaxCount[0] = r3.size();
    L9:
        return mSimMaxCount[0];
    }

    public static Intent createNewRawContactIntent(Context r3, ArrayList<ContentValues> r4, AccountWithDataSet r5, Class<?> r6, String r7) {
        Intent r0 = new Intent(r3, ContactSaveService.class);
        r0.setAction(ACTION_NEW_RAW_CONTACT);
        if (r5 == null) goto L5;
        r0.putExtra(EXTRA_ACCOUNT_NAME, r5.name);
        r0.putExtra(EXTRA_ACCOUNT_TYPE, r5.type);
        r0.putExtra(EXTRA_DATA_SET, r5.dataSet);
    L5:
        r0.putParcelableArrayListExtra(EXTRA_CONTENT_VALUES, r4);
        Intent r8 = new Intent(r3, r6);
        r8.setAction(r7);
        r0.putExtra(EXTRA_CALLBACK_INTENT, r8);
        return r0;
    }

    private void createRawContact(Intent r9) {
        String r0 = r9.getStringExtra(EXTRA_ACCOUNT_NAME);
        String r1 = r9.getStringExtra(EXTRA_ACCOUNT_TYPE);
        String r2 = r9.getStringExtra(EXTRA_DATA_SET);
        ArrayList r3 = r9.getParcelableArrayListExtra(EXTRA_CONTENT_VALUES);
        Intent r10 = (Intent) r9.getParcelableExtra(EXTRA_CALLBACK_INTENT);
        ArrayList<ContentProviderOperation> r4 = new ArrayList();
        r4.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_name", r0).withValue("account_type", r1).withValue("data_set", r2).build());
        int r5 = r3.size();
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L5;
        ContentValues r7 = (ContentValues) r3.get(r6);
        r7.keySet().retainAll(ALLOWED_DATA_COLUMNS);
        r4.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0).withValues(r7).build());
        r6 = r6 + 1;
        goto L3
    L5:
        ContentResolver r8 = getContentResolver();
        Uri r11 = r8.applyBatch("com.android.contacts", r4)[0].uri;
        if (r10 == null) goto L17;
        r10.setData(ContactsContract.RawContacts.getContactLookupUri(r8, r11));
        deliverCallback(r10);
        return;
    L17:
        return;
    L11:
        e = move-exception;
        throw new RuntimeException("Failed to store new contact", e);
    }

    public static Intent CreateUpdateContactGroupDatas(Context r2, long r3, long[] r5, long[] r6, String r7, String r8) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_UPDATE_CONTACT_GROUPS);
        r0.putExtra(EXTRA_RAW_CONTACT_ID, r3);
        r0.putExtra(EXTRA_GROUP_IDS_TO_ADD, r5);
        r0.putExtra(EXTRA_GROUP_IDS_TO_REMOVE, r6);
        r0.putExtra(EXTRA_ACCOUNT_NAME, r7);
        r0.putExtra(EXTRA_ACCOUNT_TYPE, r8);
        return r0;
    }

    private void updateContactGroupsData(Intent r5) {
        long r0 = r5.getLongExtra(EXTRA_RAW_CONTACT_ID, -1);
        long[] r2 = r5.getLongArrayExtra(EXTRA_GROUP_IDS_TO_ADD);
        long[] r6 = r5.getLongArrayExtra(EXTRA_GROUP_IDS_TO_REMOVE);
        addContactToGroup(r0, r2);
        removeContactFromGroup(r0, r6);
    }

    public static Intent CreateUpdateContactGroupDatasWithGroupName(Context r2, long r3, String r5, String r6, String r7) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_UPDATE_CONTACT_GROUPS_WITH_GROUPNAME);
        r0.putExtra(EXTRA_RAW_CONTACT_ID, r3);
        r0.putExtra(EXTRA_GROUP_LABEL, r5);
        r0.putExtra(EXTRA_ACCOUNT_NAME, r6);
        r0.putExtra(EXTRA_ACCOUNT_TYPE, r7);
        return r0;
    }

    private void updateContactGroupsDataWithGroupName(Intent r12) {
        String r0 = r12.getStringExtra(EXTRA_ACCOUNT_NAME);
        String r1 = r12.getStringExtra(EXTRA_ACCOUNT_TYPE);
        long r2 = r12.getLongExtra(EXTRA_RAW_CONTACT_ID, -1);
        Cursor r13 = getContentResolver().query(ContactsContract.Groups.CONTENT_URI, new String[]{"_id"}, "account_name=? AND account_type=? AND auto_add=0 AND favorites=0 AND deleted=0 AND title=? ", new String[]{r0, r1, r12.getStringExtra(EXTRA_GROUP_LABEL)}, null);
        if (r13 != null) goto L15;
    L12:
        if (r13 == null) goto L17;
        r13.close();
        return;
    L17:
        return;
    L15:
    L8:
        th = move-exception;
        if (r13 == null) goto L11;
        r13.close();
    L11:
        throw th;
    L5:
        if (r13.moveToFirst() == false) goto L12;
        addContactToGroup(r2, r13.getLong(0));     // Catch: Throwable -> L8
        goto L12
    }

    private void removeContactFromGroup(long r11, long[] r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        ArrayList<ContentProviderOperation> r0 = new ArrayList();
        int r1 = r13.length;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L8;
        r0.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id =? AND mimetype =? AND data1 =?", new String[]{String.valueOf(r11), "vnd.android.cursor.item/group_membership", String.valueOf(r13[r3])}).build());
        r3 = r3 + 1;
        goto L5
    L8:
        if (r0.size() > 0) goto L15;
        return;
    L15:
        getContentResolver().applyBatch("com.android.contacts", r0);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        throw new RuntimeException("Failed to remove group data", e);
    }

    private void addContactToGroup(long r9, long[] r11) {
        ArrayList<ContentProviderOperation> r0 = new ArrayList();
        int r1 = r11.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        long r3 = r11[r2];
        r0.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r9)).withValue("data1", Long.valueOf(r3)).withValue("mimetype", "vnd.android.cursor.item/group_membership").build());
        r2 = r2 + 1;
        goto L3
    L6:
        if (r0.size() > 0) goto L13;
        return;
    L13:
        getContentResolver().applyBatch("com.android.contacts", r0);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        throw new RuntimeException("Failed to insert group data", e);
    }

    private void addContactToGroup(long r3, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r3));
        r0.put("data1", Long.valueOf(r5));
        r0.put("mimetype", "vnd.android.cursor.item/group_membership");
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, r0);
    }

    public static Intent createSaveContactIntent(Context r8, EntityDeltaList r9, String r10, int r11, boolean r12, Class<? extends Activity> r13, String r14, long r15, Uri r17) {
        Bundle r7 = new Bundle();
        r7.putParcelable(String.valueOf(r15), r17);
        return createSaveContactIntent(r8, r9, r10, r11, r12, r13, r14, r7);
    }

    public static Intent createSaveContactIntent(Context r2, EntityDeltaList r3, String r4, int r5, boolean r6, Class<?> r7, String r8, Bundle r9) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_SAVE_CONTACT);
        r0.putExtra("state", r3);
        r0.putExtra(EXTRA_SAVE_IS_PROFILE, r6);
        if (r7 == null) goto L5;
        Intent r10 = new Intent(r2, r7);
        r10.putExtra(r4, r5);
        r10.setAction(r8);
        r0.putExtra(EXTRA_CALLBACK_INTENT, r10);
        r0.setFlags(1048576);
    L5:
        if (r9 == null) goto L7;
        r0.putExtra(EXTRA_UPDATED_PHOTOS, r9);
    L7:
        return r0;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 13211. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private void saveContact(android.content.Intent r35) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE (r0v1 ?? I:android.os.Parcelable) = (r35v0 ?? I:android.content.Intent), ("state") VIRTUAL call: android.content.Intent.getParcelableExtra(java.lang.String):android.os.Parcelable A[DECLARE_VAR, MD:<T extends android.os.Parcelable>:(java.lang.String):T extends android.os.Parcelable (c)] (LINE:564) in method: com.android.contacts.ContactSaveService.saveContact(android.content.Intent):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.ContactSaveService.saveContact(android.content.Intent):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void collectModifiedDatas(EntityDeltaList r12, Uri r13, String r14) {
        ArrayList<String> r7 = new ArrayList();
        Iterator<EntityDelta> r15 = r12.iterator();
        boolean r0 = 0;
    L4:
        if (r15.hasNext() == false) goto L19;
        EntityDelta r1 = r15.next();
        boolean r8 = r1.isContactInsert();
        Iterator<ArrayList<EntityDelta.ValuesDelta>> r9 = r1.getEntries().values().iterator();
    L7:
        if (r9.hasNext() == false) goto L18;
        Iterator<EntityDelta.ValuesDelta> r10 = r9.next().iterator();
    L10:
        if (r10.hasNext() == false) goto L7;
        EntityDelta.ValuesDelta r2 = r10.next();
        String r3 = r2.getMimetype();
        if (r2.isInsert() == true) goto L17;
        if (r2.isDelete() == true) goto L17;
        if (r2.isUpdate() == false) goto L10;
    L17:
        mimeTypeToString(r7, r3, "update", false, false, 0);
        goto L10
    L18:
        r0 = r8;
        goto L4
    L19:
        Intent r16 = new Intent("com.android.contact.update");
        r16.setPackage("com.obric.memory");
        r16.putExtra("opType", !r0);
        if (r14 != null) goto L23;
        r14 = getResources().getString(R.string.missing_name);
    L23:
        r16.putExtra("name", r14);
        r16.putExtra("uri", r13);
        r16.putStringArrayListExtra("update", r7);
        getBaseContext().sendBroadcast(r16);
        Iterator<String> r11 = r7.iterator();
    L25:
        if (r11.hasNext() == false) goto L27;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r11.next() + " modify");
        goto L25
    }

    private ArrayList<String> mimeTypeToString(ArrayList<String> r1, String r2, String r3, boolean r4, boolean r5, int r6) {
        if (r2.equals("vnd.android.cursor.item/name") == false) goto L8;
        if (r1.contains("name") == true) goto L52;
        r1.add("name");
    L52:
        return r1;
    L8:
        if (r2.equals("vnd.android.cursor.item/phone_v2") == false) goto L13;
        if (r1.contains("phone") == true) goto L52;
        r1.add("phone");
        goto L52
    L13:
        if (r2.equals("vnd.android.cursor.item/email_v2") == false) goto L18;
        if (r1.contains("email") == true) goto L52;
        r1.add("email");
        goto L52
    L18:
        if (r2.equals("vnd.android.cursor.item/postal-address_v2") == false) goto L23;
        if (r1.contains("postalAddress") == true) goto L52;
        r1.add("postalAddress");
        goto L52
    L23:
        if (r2.equals("vnd.android.cursor.item/im") == false) goto L28;
        if (r1.contains(SyncContractKt.COLUMN_IM) == true) goto L52;
        r1.add(SyncContractKt.COLUMN_IM);
        goto L52
    L28:
        if (r2.equals("vnd.android.cursor.item/organization") == false) goto L33;
        if (r1.contains("organization") == true) goto L52;
        r1.add("organization");
        goto L52
    L33:
        if (r2.equals("vnd.android.cursor.item/photo") == false) goto L38;
        if (r1.contains(BlackListQueryHandler.KEY_PHOTO) == true) goto L52;
        r1.add(BlackListQueryHandler.KEY_PHOTO);
        goto L52
    L38:
        if (r2.equals("vnd.android.cursor.item/note") == false) goto L43;
        if (r1.contains(SyncContractKt.COLUMN_NOTE) == true) goto L52;
        r1.add(SyncContractKt.COLUMN_NOTE);
        goto L52
    L43:
        if (r2.equals("vnd.android.cursor.item/website") == false) goto L48;
        if (r1.contains(SyncContractKt.COLUMN_WEBSITE) == true) goto L52;
        r1.add(SyncContractKt.COLUMN_WEBSITE);
        goto L52
    L48:
        if (r2.equals("vnd.android.cursor.item/sip_address") == false) goto L52;
        if (r1.contains("sipAddress") == true) goto L52;
        r1.add("sipAddress");
        goto L52
    }

    private boolean saveUpdatedPhoto(long r2, Uri r4) {
        return ContactPhotoUtils.savePhotoFromUriToUri(this, r4, Uri.withAppendedPath(ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r2), "display_photo"), true);
    }

    private Integer doSaveToSimCard(EntityDelta r17, ContentResolver r18, int r19) {
        if (MoreContactUtils.isAPMOnAndSIMPowerDown(getApplicationContext()) == true) goto L5;
        boolean r2 = r17.isContactInsert();
        mSimContactsOperation = new SimContactsOperation(this);
        ContentValues r4 = r17.buildSimDiff();
        if (r2 == false) goto L9;
        String r6 = r4.getAsString(SimContactsConstants.STR_TAG);
        String r7 = r4.getAsString("number");
        String r8 = r4.getAsString(SimContactsConstants.STR_ANRS);
        String r9 = r4.getAsString(SimContactsConstants.STR_EMAILS);
    L10:
        if (r2 == true) goto L14;
        if (TextUtils.isEmpty(r6) == true) goto L14;
    L22:
        if (TextUtils.isEmpty(r7) == false) goto L24;
    L31:
        int r14 = 0;
        if (TextUtils.isEmpty(r8) == true) goto L47;
        String[] r5 = r8.split(SimContactsConstants.EMAIL_SEP);
        if (r5 == null) goto L47;
        if (r5.length > MoreContactUtils.getOneSimAnrCount(r19)) goto L38;
        int r10 = r5.length;
        int r11 = 0;
    L40:
        if (r11 >= r10) goto L47;
        if (r5[r11].length() > 20) goto L44;
        r11 = r11 + 1;
        goto L40
    L44:
        return 6;
    L38:
        return 12;
    L47:
        if (TextUtils.isEmpty(r7) == true) goto L53;
        if (TextUtils.isEmpty(PhoneNumberUtils.stripSeparators(r7)) == false) goto L53;
        return 9;
    L53:
        if (TextUtils.isEmpty(r9) == true) goto L64;
        String[] r12 = r9.split(SimContactsConstants.EMAIL_SEP);
        int r13 = r12.length;
        int r15 = 0;
    L55:
        if (r15 >= r13) goto L64;
        String r16 = r12[r15];
        if (r16 == null) goto L62;
        if (r16.length() <= 40) goto L62;
        return 5;
    L62:
        r15 = r15 + 1;
    L64:
        if (TextUtils.isEmpty(r6) == true) goto L76;
        if (hasChinese(r6) == true) goto L72;
        if (r6.length() <= 14) goto L76;
        return 8;
    L72:
        if (r6.length() <= 6) goto L76;
        return 8;
    L76:
        if (r17.isContactInsert() == false) goto L109;
        if (DSUtils.isMultiSimEnabled() == true) goto L80;
        Uri r20 = Uri.parse(SimContactsConstants.SIM_URI);
    L123:
        Cursor r21 = r18.query(r20, null, null, null, null);     // Catch: Throwable -> L103
        if (r21 != null) goto L125;
    L88:
        if (r21 == null) goto L91;
        r21.close();
    L91:
        if (DSUtils.isMultiSimEnabled() == true) goto L97;
        if (r14 != getSimCardMaxCount()) goto L109;
        return 7;
    L97:
        if (r14 != ReflectUtils.getMSimCardMaxCount(r19)) goto L109;
        if (r14 != 0) goto L102;
        return 13;
    L102:
        return 7;
    L125:
        r14 = r21.getCount();     // Catch: Throwable -> L86
    L86:
        th = th;
    L105:
        if (r21 == null) goto L107;
        r21.close();
    L107:
        throw th;
    L103:
        th = th;
        r21 = null;
        goto L105
    L80:
        r20 = DSUtils.getSimContactsQueryUri(r19);
    L109:
        if (r2 == false) goto L117;
        if (ContactsUtils.DEBUG == false) goto L114;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Insert " + r4 + " to subscription " + r19);
    L114:
        if (mSimContactsOperation.insert(r4, r19) != null) goto L134;
        return 4;
    L134:
        return 1;
    L117:
        if (ContactsUtils.DEBUG == false) goto L120;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Update " + r4 + " to subscription " + r19);
    L120:
        if (mSimContactsOperation.update(r4, r19) == 1) goto L122;
        return 4;
    L122:
        return 1;
    L24:
        if (r7.length() <= 20) goto L28;
        return 6;
    L28:
        if (r7.contains(SimContactsConstants.STR_ANRS) == false) goto L31;
        return 12;
    L14:
        if (TextUtils.isEmpty(r7) == false) goto L22;
        if (TextUtils.isEmpty(r8) == false) goto L22;
        if (TextUtils.isEmpty(r9) == false) goto L22;
        return 3;
    L9:
        r6 = r4.getAsString(SimContactsConstants.STR_NEW_TAG);
        r7 = r4.getAsString(SimContactsConstants.STR_NEW_NUMBER);
        r8 = r4.getAsString(SimContactsConstants.STR_NEW_ANRS);
        r9 = r4.getAsString(SimContactsConstants.STR_NEW_EMAILS);
        goto L10
    L5:
        return 10;
    }

    private boolean hasChinese(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.getBytes().length <= r1.length()) goto L6;
        return true;
    }

    private long getInsertedRawContactId(ArrayList<ContentProviderOperation> r5, ContentProviderResult[] r6) {
        int r4 = r5.size();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L11;
        ContentProviderOperation r1 = r5.get(r0);
        if (r1.getType() != 1) goto L10;
        if (r1.getUri().getEncodedPath().contains(ContactsContract.RawContacts.CONTENT_URI.getEncodedPath()) == false) goto L10;
        return ContentUris.parseId(r6[r0].uri);
    L10:
        r0 = r0 + 1;
        goto L3
    L11:
        return -1;
    }

    private long getRawContactId(EntityDeltaList r6, ArrayList<ContentProviderOperation> r7, ContentProviderResult[] r8) {
        long r5 = r6.findRawContactId();
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r9 = r7.size();
        int r10 = 0;
    L6:
        if (r10 >= r9) goto L14;
        ContentProviderOperation r2 = r7.get(r10);
        if (r2.getType() != 1) goto L13;
        if (r2.getUri().getEncodedPath().contains(ContactsContract.RawContacts.CONTENT_URI.getEncodedPath()) == false) goto L13;
        return ContentUris.parseId(r8[r10].uri);
    L13:
        r10 = r10 + 1;
        goto L6
    L14:
        return -1;
    }

    public static Intent createNewGroupIntent(Context r3, AccountWithDataSet r4, String r5, long[] r6, Class<?> r7, String r8) {
        Intent r0 = new Intent(r3, ContactSaveService.class);
        r0.setAction(ACTION_CREATE_GROUP);
        r0.putExtra(EXTRA_ACCOUNT_TYPE, r4.type);
        r0.putExtra(EXTRA_ACCOUNT_NAME, r4.name);
        r0.putExtra(EXTRA_DATA_SET, r4.dataSet);
        r0.putExtra(EXTRA_GROUP_LABEL, r5);
        r0.putExtra(EXTRA_RAW_CONTACTS_TO_ADD, r6);
        Intent r9 = new Intent(r3, r7);
        r9.setAction(r8);
        r0.putExtra(EXTRA_CALLBACK_INTENT, r9);
        return r0;
    }

    private void createGroup(Intent r8) {
        String r0 = r8.getStringExtra(EXTRA_ACCOUNT_TYPE);
        String r1 = r8.getStringExtra(EXTRA_ACCOUNT_NAME);
        String r2 = r8.getStringExtra(EXTRA_DATA_SET);
        String r3 = r8.getStringExtra(EXTRA_GROUP_LABEL);
        long[] r4 = r8.getLongArrayExtra(EXTRA_RAW_CONTACTS_TO_ADD);
        ContentValues r5 = new ContentValues();
        r5.put("account_type", r0);
        r5.put("account_name", r1);
        r5.put("data_set", r2);
        r5.put("title", r3);
        ContentResolver r6 = getContentResolver();
        Uri r7 = r6.insert(ContactsContract.Groups.CONTENT_URI, r5);
        if (r7 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Couldn't create group with label " + r3);
        return;
    L6:
        addMembersToGroup(r6, r4, ContentUris.parseId(r7));
        r5.clear();
        r5.put("mimetype", "vnd.android.cursor.item/group_membership");
        r5.put("data1", Long.valueOf(ContentUris.parseId(r7)));
        Intent r9 = (Intent) r8.getParcelableExtra(EXTRA_CALLBACK_INTENT);
        r9.setData(r7);
        r9.putExtra("data", Lists.newArrayList(new ContentValues[]{r5}));
        deliverCallback(r9);
    }

    public static Intent createGroupRenameIntent(Context r2, long r3, String r5, Class<?> r6, String r7) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_RENAME_GROUP);
        r0.putExtra("groupId", r3);
        r0.putExtra(EXTRA_GROUP_LABEL, r5);
        Intent r4 = new Intent(r2, r6);
        r4.setAction(r7);
        r0.putExtra(EXTRA_CALLBACK_INTENT, r4);
        return r0;
    }

    private void renameGroup(Intent r6) {
        long r3 = r6.getLongExtra("groupId", -1);
        String r0 = r6.getStringExtra(EXTRA_GROUP_LABEL);
        if (r3 != (-1)) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for renameGroup request");
        return;
    L6:
        ContentValues r1 = new ContentValues();
        r1.put("title", r0);
        Uri r2 = ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, r3);
        getContentResolver().update(r2, r1, null, null);
        Intent r7 = (Intent) r6.getParcelableExtra(EXTRA_CALLBACK_INTENT);
        r7.setData(r2);
        deliverCallback(r7);
    }

    public static Intent createGroupDeletionIntent(Context r2, long[] r3) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_DELETE_GROUP);
        r0.putExtra("groupId", r3);
        return r0;
    }

    private void deleteGroup(Intent r9) {
        long[] r10 = r9.getLongArrayExtra("groupId");
        if (r10.length > 0) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for deleteGroup request");
        return;
    L6:
        int r4 = 0;
        if (r10.length >= 500) goto L18;
        ArrayList<ContentProviderOperation> r0 = new ArrayList();
        int r1 = r10.length;
    L9:
        if (r4 >= r1) goto L12;
        long r5 = r10[r4];
        r0.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, r5)).build());
        r4 = r4 + 1;
        goto L9
    L12:
        if (r0.size() > 0) goto L33;
        return;
    L33:
        getContentResolver().applyBatch("com.android.contacts", r0);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        throw new RuntimeException("Failed to delete groups", e);
    L18:
        ArrayList<ContentProviderOperation> r2 = new ArrayList();
    L20:
        if (r4 >= r10.length) goto L26;
        long r6 = r10[r4];
        r4 = r4 + 1;
        if ((r4 % 499) == 0) goto L23;
        r2.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, r6)).build());
        goto L20
    L23:
        r2.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, r6)).withYieldAllowed(true).build());
        goto L20
    L26:
        if (r2.size() <= 0) goto L44;
        getContentResolver().applyBatch("com.android.contacts", r2);     // Catch: Exception -> L29
        return;
    L29:
        e = move-exception;
        throw new RuntimeException("Failed to delete groups", e);
    }

    public static Intent createGroupUpdateIntent(Context r2, long r3, String r5, long[] r6, long[] r7, Class<?> r8, String r9) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_UPDATE_GROUP);
        r0.putExtra("groupId", r3);
        r0.putExtra(EXTRA_GROUP_LABEL, r5);
        r0.putExtra(EXTRA_RAW_CONTACTS_TO_ADD, r6);
        r0.putExtra(EXTRA_RAW_CONTACTS_TO_REMOVE, r7);
        if (r8 == null) goto L5;
        Intent r4 = new Intent(r2, r8);
        r4.setAction(r9);
        r0.putExtra(EXTRA_CALLBACK_INTENT, r4);
    L5:
        return r0;
    }

    private void updateGroup(Intent r11) {
        long r3 = r11.getLongExtra("groupId", -1);
        String r0 = r11.getStringExtra(EXTRA_GROUP_LABEL);
        long[] r5 = r11.getLongArrayExtra(EXTRA_RAW_CONTACTS_TO_ADD);
        long[] r6 = r11.getLongArrayExtra(EXTRA_RAW_CONTACTS_TO_REMOVE);
        if (r3 != (-1)) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for updateGroup request");
        return;
    L6:
        ContentResolver r1 = getContentResolver();
        Uri r2 = ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, r3);
        if (r0 == null) goto L9;
        ContentValues r8 = new ContentValues();
        r8.put("title", r0);
        r1.update(r2, r8, null, null);
    L10:
        addMembersToGroupWithoutQuery(r1, r5, r3);
        removeMembersFromGroup(r1, r6, r3);
        Intent r12 = (Intent) r11.getParcelableExtra(EXTRA_CALLBACK_INTENT);
        if (r12 == null) goto L14;
        r12.setData(r2);
        deliverCallback(r12);
        return;
    L14:
        return;
    L9:
        r1.update(r2, new ContentValues(), null, null);
        goto L10
    }

    private void addMembersToGroup(ContentResolver r15, long[] r16, long r17) {
        if (r16 != null) goto L5;
        return;
    L5:
        int r4 = r16.length;
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L32;
        long r7 = r16[r6];
        ArrayList<ContentProviderOperation> r0 = new ArrayList();     // Catch: OperationApplicationException -> L25 RemoteException -> L28
        ContentProviderOperation.Builder r9 = ContentProviderOperation.newAssertQuery(ContactsContract.Data.CONTENT_URI);     // Catch: OperationApplicationException -> L25 RemoteException -> L28
        r9.withSelection("raw_contact_id=? AND mimetype=? AND data1=?", new String[]{String.valueOf(r7), "vnd.android.cursor.item/group_membership", String.valueOf(r17)});     // Catch: OperationApplicationException -> L25 RemoteException -> L28
        r9.withExpectedCount(0);     // Catch: OperationApplicationException -> L25 RemoteException -> L28
        r0.add(r9.build());     // Catch: OperationApplicationException -> L25 RemoteException -> L28
        ContentProviderOperation.Builder r10 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);     // Catch: OperationApplicationException -> L25 RemoteException -> L28
        r10.withValue(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r7));     // Catch: OperationApplicationException -> L25 RemoteException -> L28
        r10.withValue("mimetype", "vnd.android.cursor.item/group_membership");     // Catch: OperationApplicationException -> L25 RemoteException -> L28
        r10.withValue("data1", Long.valueOf(r17));     // Catch: OperationApplicationException -> L25 RemoteException -> L28
        r0.add(r10.build());     // Catch: OperationApplicationException -> L25 RemoteException -> L28
        if (DEBUG == false) goto L15;
        Iterator<ContentProviderOperation> r11 = r0.iterator();     // Catch: OperationApplicationException -> L25 RemoteException -> L28
    L12:
        if (r11.hasNext() == false) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, r11.next().toString());     // Catch: OperationApplicationException -> L25 RemoteException -> L28
    L15:
        if (r0.isEmpty() == true) goto L31;
        r15.applyBatch("com.android.contacts", r0);     // Catch: OperationApplicationException -> L20 RemoteException -> L22
    L20:
        e = e;
    L27:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Assert failed in adding raw contact ID " + String.valueOf(r7) + ". Already exists in group " + String.valueOf(r17), e);
    L22:
        e = e;
    L30:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Problem persisting user edits for raw contact ID " + String.valueOf(r7), e);
    L31:
        r6 = r6 + 1;
        goto L6
    L25:
        e = e;
    L28:
        e = e;
        goto L30
    }

    private void addMembersToGroupWithoutQuery(ContentResolver r16, long[] r17, long r18) {
        if (r17 != null) goto L5;
        return;
    L5:
        HashSet r2 = new HashSet();
        StringBuilder r3 = new StringBuilder("mimetype = 'vnd.android.cursor.item/group_membership'");
        r3.append(" AND data1 = " + r18);
        r3.append(" AND raw_contact_id IN (");
        int r4 = r17.length;
        boolean r7 = true;
        int r8 = 0;
        boolean r10 = true;
        int r9 = 0;
    L6:
        if (r9 >= r4) goto L12;
        long r11 = r17[r9];
        if (r10 == false) goto L10;
        r10 = false;
    L11:
        r3.append(r11);
        r9 = r9 + 1;
        goto L6
    L10:
        r3.append(SimContactsConstants.EMAIL_SEP);
        goto L11
    L12:
        r3.append(")");
        Cursor r5 = null;
        r5 = getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{GroupSelectionActivity.EXTRA_RAW_CONTACT_ID}, r3.toString(), null, null);     // Catch: Throwable -> L38
        if (r5 != null) goto L16;
    L19:
        if (r5 == null) goto L22;
        r5.close();
    L22:
        if (r2.size() > 0) goto L25;
        r7 = false;
    L25:
        ArrayList r6 = new ArrayList();
        int r12 = r17.length;
    L26:
        if (r8 >= r12) goto L35;
        long r13 = r17[r8];
        if (r7 == true) goto L30;
    L32:
        ContentProviderOperation.Builder r14 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r14.withValue(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r13));
        r14.withValue("mimetype", "vnd.android.cursor.item/group_membership");
        r14.withValue("data1", Long.valueOf(r18));
        r6.add(r14.build());
    L33:
        r8 = r8 + 1;
        goto L26
    L30:
        if (r2.contains(Long.valueOf(r13)) == false) goto L32;
    L35:
        if (r6.size() <= 0) goto L52;
        ContactsUtils.runApplyBatch(r16, "com.android.contacts", r6);
        return;
    L52:
        return;
    L16:
        if (r5.moveToFirst() == false) goto L19;
    L17:
        r2.add(Long.valueOf(r5.getLong(0)));     // Catch: Throwable -> L38
        if (r5.moveToNext() == true) goto L17;
    L38:
        th = move-exception;
        if (r5 == null) goto L41;
        r5.close();
    L41:
        throw th;
    }

    private void removeMembersFromGroup(ContentResolver r8, long[] r9, long r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        ArrayList r7 = new ArrayList();
        int r0 = r9.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L8;
        r7.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=? AND data1=?", new String[]{String.valueOf(r9[r2]), "vnd.android.cursor.item/group_membership", String.valueOf(r10)}).build());
        r2 = r2 + 1;
        goto L5
    L8:
        if (r7.size() <= 0) goto L12;
        ContactsUtils.runApplyBatch(r8, "com.android.contacts", r7);
        return;
    }

    public static Intent createSetStarredIntent(Context r2, Uri r3, boolean r4) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_SET_STARRED);
        r0.putExtra("contactUri", r3);
        r0.putExtra(EXTRA_STARRED_FLAG, r4);
        return r0;
    }

    private void setStarred(Intent r5) {
        Uri r0 = (Uri) r5.getParcelableExtra("contactUri");
        boolean r6 = r5.getBooleanExtra(EXTRA_STARRED_FLAG, false);
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for setStarred request");
        return;
    L6:
        ContentValues r1 = new ContentValues(1);
        r1.put(EXTRA_STARRED_FLAG, Boolean.valueOf(r6));
        getContentResolver().update(r0, r1, null, null);
    }

    public static Intent createSetPhoneStarredIntent(Context r3, long r4, String[] r6, boolean r7) {
        Intent r0 = new Intent(r3, ContactSaveService.class);
        r0.setAction(ACTION_SET_PHONE_STARRED);
        r0.putExtra(EXTRA_CONTACT_ID, r4);
        r0.putExtra("phoneNumber", r6);
        r0.putExtra(EXTRA_STARRED_FLAG, r7);
        Intent r5 = new Intent(r3.getApplicationContext(), DialtactsActivity.class);
        r5.setAction(ACTION_SET_PHONE_STARRED);
        r0.putExtra(EXTRA_CALLBACK_INTENT, r5);
        return r0;
    }

    private void setPhoneStarred(Intent r6) {
        long r0 = r6.getLongExtra(EXTRA_CONTACT_ID, 0);
        String[] r2 = r6.getStringArrayExtra("phoneNumber");
        if (r6.getBooleanExtra(EXTRA_STARRED_FLAG, true) == false) goto L5;
        FavoriteAction r3 = FavoriteAction.ADD;
    L6:
        setPhoneStarted(getBaseContext(), r0, r2, r3);
        Intent r7 = (Intent) r6.getParcelableExtra(EXTRA_CALLBACK_INTENT);
        if (r7 == null) goto L10;
        deliverCallback(r7);
        return;
    L10:
        return;
    L5:
        r3 = FavoriteAction.REMOVE;
        goto L6
    }

    public static ContentProviderResult[] removePhoneStarted(Context r2, String[] r3) {
        return removePhoneStarted(r2, 0, r3);
    }

    public static ContentProviderResult[] removePhoneStarted(Context r8, long[] r9, String[] r10) {
        if (r9 == null) goto L13;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r9.length != r10.length) goto L17;
        ContentValues r0 = new ContentValues();
        r0.put("data14", "");
        r0.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, "");
        ArrayList r1 = new ArrayList();
        int r3 = 0;
    L9:
        if (r3 >= r9.length) goto L12;
        r1.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withValues(r0).withSelection("mimetype =? AND contact_id =? AND PHONE_NUMBERS_EQUAL(data1, ?)", new String[]{"vnd.android.cursor.item/phone_v2", String.valueOf(r9[r3]), r10[r3]}).build());
        r3 = r3 + 1;
        goto L9
    L12:
        return ContactsUtils.runApplyBatch(r8.getContentResolver(), "com.android.contacts", r1);
    L17:
        return null;
    L13:
        return null;
    }

    private static ContentProviderResult[] removePhoneStarted(Context r5, long r6, String[] r8) {
        StringBuilder r0 = new StringBuilder("mimetype = 'vnd.android.cursor.item/phone_v2' AND ");
        if (r6 <= 0) goto L5;
        r0.append("contact_id = ").append(r6).append(" AND ");
    L5:
        r0.append("(");
        int r7 = r8.length;
        boolean r1 = true;
        int r2 = 0;
    L6:
        if (r2 >= r7) goto L12;
        String r3 = r8[r2];
        if (r1 == false) goto L10;
        r1 = false;
    L11:
        r0.append("PHONE_NUMBERS_EQUAL(data1, '");
        r0.append(r3);
        r0.append("' )");
        r2 = r2 + 1;
        goto L6
    L10:
        r0.append(" OR ");
        goto L11
    L12:
        r0.append(")");
        ContentValues r9 = new ContentValues();
        r9.put("data14", "");
        r9.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, "");
        String[] r4 = (String[]) null;
        r5.getContentResolver().update(ContactsContract.Data.CONTENT_URI, r9, r0.toString(), null);
        return null;
    }

    public static ContentProviderResult[] setPhoneStarted(Context r2, String[] r3, FavoriteAction r4) {
        return setPhoneStarted(r2, 0, r3, r4);
    }

    private static ContentProviderResult[] setPhoneStarted(Context r14, long r15, String[] r17, FavoriteAction r18) {
        if (r17 != null) goto L7;
        return null;
    L7:
        if (r18 != FavoriteAction.REMOVE) goto L11;
        return removePhoneStarted(r14, r15, r17);
    L11:
        if (r18 != FavoriteAction.ADD) goto L13;
        int r2 = ContactsUtils.getFavoriteLastIndex(r14);
    L14:
        ArrayList r4 = new ArrayList();
        if (r15 <= 0) goto L17;
        String r6 = "mimetype =? AND contact_id =? AND ";
    L18:
        String r7 = r6 + " PHONE_NUMBERS_EQUAL(data1, ?)";
        int r8 = 0;
    L20:
        if (r8 >= r17.length) goto L33;
        String r9 = r17[r8];
        ContentProviderOperation.Builder r10 = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI);
        if (r18 != FavoriteAction.ADD) goto L25;
        r2 = r2 + 1;
        r10.withValue("data14", Integer.valueOf(r2));
        r10.withValue(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, "1");
    L28:
        if (r15 <= 0) goto L30;
        String[] r13 = {"vnd.android.cursor.item/phone_v2", String.valueOf(r15), r9};
    L31:
        r10.withSelection(r7, r13);
        r4.add(r10.build());
        r8 = r8 + 1;
        goto L20
    L30:
        r13 = new String[]{"vnd.android.cursor.item/phone_v2", r9};
        goto L31
    L25:
        if (r18 != FavoriteAction.RESET) goto L28;
        r2 = r2 + 1;
        r10.withValue("data14", Integer.valueOf(r2));
        goto L28
    L33:
        return ContactsUtils.runApplyBatch(r14.getContentResolver(), "com.android.contacts", r4);
    L17:
        r6 = "mimetype =? AND ";
        goto L18
    L13:
        r2 = 0;
        goto L14
    }

    public static Intent createSetSendToVoicemail(Context r2, Uri r3, boolean r4) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_SET_SEND_TO_VOICEMAIL);
        r0.putExtra("contactUri", r3);
        r0.putExtra(EXTRA_SEND_TO_VOICEMAIL_FLAG, r4);
        return r0;
    }

    private void setSendToVoicemail(Intent r4) {
        Uri r0 = (Uri) r4.getParcelableExtra("contactUri");
        boolean r5 = r4.getBooleanExtra(EXTRA_SEND_TO_VOICEMAIL_FLAG, false);
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for setRedirectToVoicemail");
        return;
    L6:
        ContentValues r1 = new ContentValues(1);
        r1.put("send_to_voicemail", Boolean.valueOf(r5));
        getContentResolver().update(r0, r1, null, null);
    }

    public static Intent createSetRingtone(Context r2, Uri r3, String r4) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_SET_RINGTONE);
        r0.putExtra("contactUri", r3);
        r0.putExtra(EXTRA_CUSTOM_RINGTONE, r4);
        return r0;
    }

    private void setRingtone(Intent r4) {
        Uri r0 = (Uri) r4.getParcelableExtra("contactUri");
        String r5 = r4.getStringExtra(EXTRA_CUSTOM_RINGTONE);
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for setRingtone");
        return;
    L6:
        ContentValues r1 = new ContentValues(1);
        r1.put("custom_ringtone", r5);
        getContentResolver().update(r0, r1, null, null);
    }

    public static Intent createSetLocation(Context r2, Uri r3) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_SET_LOCATION);
        r0.putExtra("contactUri", r3);
        return r0;
    }

    private void requestLocation(final Intent r4) {
        final int r0 = r4.getIntExtra(REQUEST_LOCATION_TIMES, 0);
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "requestTimes contact:" + r4.getParcelableExtra("contactUri") + "; requestTimes:" + r0);
    L5:
        Location r1 = requestUpdatesFromProvider("gps");
        Location r2 = requestUpdatesFromProvider("network");
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        r1 = getBetterLocation(r1, r2);
    L14:
        if (r1 == null) goto L16;
        r4.putExtra(EXTRA_LOCATION_COORDINATES, r1);
        setLocation(r4);
        return;
    L16:
        if (r0 >= 3) goto L20;
        this.mMainHandler.postDelayed(new AnonymousClass1(this, r4, r0), WsConstants.EXIT_DELAY_TIME);
        return;
    L20:
        return;
    L9:
        if (r1 != null) goto L14;
        if (r2 == null) goto L13;
        r1 = r2;
        goto L14
    L13:
        r1 = null;
        goto L14
    }

    private Location getBetterLocation(Location r9, Location r10) {
        if (r10 != null) goto L4;
        return r9;
    L4:
        long r0 = r9.getTime() - r10.getTime();
        boolean r3 = true;
        if (r0 <= 120000) goto L7;
        boolean r2 = true;
    L9:
        if (r0 >= (-120000)) goto L11;
        boolean r5 = true;
    L13:
        if (r0 <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r2 == false) goto L18;
        return r9;
    L18:
        if (r5 == false) goto L20;
        return r10;
    L20:
        int r4 = (int) (r9.getAccuracy() - r10.getAccuracy());
        if (r4 <= 0) goto L23;
        boolean r6 = true;
    L24:
        if (r4 >= 0) goto L26;
        boolean r7 = true;
    L28:
        if (r4 > 200) goto L31;
        r3 = false;
    L31:
        boolean r8 = isSameProvider(r9.getProvider(), r10.getProvider());
        if (r7 == false) goto L34;
        return r9;
    L34:
        if (r1 == false) goto L37;
        if (r6 == true) goto L37;
        return r9;
    L37:
        if (r1 == false) goto L41;
        if (r3 == true) goto L41;
        if (r8 == false) goto L41;
        return r9;
    L41:
        return r10;
    L26:
        r7 = false;
        goto L28
    L23:
        r6 = false;
        goto L24
    L15:
        r1 = false;
        goto L16
    L11:
        r5 = false;
        goto L13
    L7:
        r2 = false;
        goto L9
    }

    private boolean isSameProvider(String r1, String r2) {
        if (r1 != null) goto L8;
        if (r2 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r1.equals(r2);
    }

    private Location requestUpdatesFromProvider(String r2) {
        LocationManager r1 = (LocationManager) getSystemService(BatteryTypeInf.BATTERY_LOC_API);
        if (r1.isProviderEnabled(r2) == true) goto L7;
        return null;
    L7:
        return r1.getLastKnownLocation(r2);
    }

    private void setLocation(Intent r5) {
        Uri r0 = (Uri) r5.getParcelableExtra("contactUri");
        Location r6 = (Location) r5.getExtras().getParcelable(EXTRA_LOCATION_COORDINATES);
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for setRingtone");
        return;
    L6:
        ContentValues r1 = new ContentValues();
        r1.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r0.getLastPathSegment());
        r1.put("mimetype", ContactsUtils.CONTACT_LOCATION_MIMETYPE);
        r1.put("data1", Double.valueOf(r6.getLongitude()));
        r1.put(DBHelper.COL_DATA2, Double.valueOf(r6.getLatitude()));
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, r1);
    }

    public static Intent createSetSuperPrimaryIntent(Context r2, long r3) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_SET_SUPER_PRIMARY);
        r0.putExtra(EXTRA_DATA_ID, r3);
        return r0;
    }

    private void setSuperPrimary(Intent r6) {
        long r3 = r6.getLongExtra(EXTRA_DATA_ID, -1);
        if (r3 != (-1)) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for setSuperPrimary request");
        return;
    L6:
        ContentValues r7 = new ContentValues(1);
        r7.put("is_super_primary", 1);
        r7.put("is_primary", 1);
        getContentResolver().update(ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r3), r7, null, null);
    }

    public static Intent createClearPrimaryIntent(Context r2, long r3) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_CLEAR_PRIMARY);
        r0.putExtra(EXTRA_DATA_ID, r3);
        return r0;
    }

    private void clearPrimary(Intent r6) {
        long r3 = r6.getLongExtra(EXTRA_DATA_ID, -1);
        if (r3 != (-1)) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for clearPrimary request");
        return;
    L6:
        ContentValues r7 = new ContentValues(1);
        r7.put("is_super_primary", 0);
        r7.put("is_primary", 0);
        getContentResolver().update(ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r3), r7, null, null);
    }

    public static Intent createDeleteContactIntent(Context r2, Uri r3) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction("delete");
        r0.putExtra("contactUri", r3);
        return r0;
    }

    private void deleteContact(Intent r8) {
        Uri r9 = (Uri) r8.getParcelableExtra("contactUri");
        mSimContactsOperation = new SimContactsOperation(this);
        if (r9 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for deleteContact request");
        return;
    L6:
        ArrayList r0 = new ArrayList();
        r0.add(getDisplayNameFromLookupUri(getContentResolver(), r9));
        List<String> r1 = r9.getPathSegments();
        if (r1 == null) goto L9;
        long r2 = Long.parseLong(r1.get(3));
    L10:
        int r3 = SimContactsOperation.getSimSubscription(r2);
        if (r3 == (-1)) goto L15;
        ContentValues r4 = SimContactsOperation.getSimAccountValues(r2);
        if (mSimContactsOperation.delete(r4, r3) != 1) goto L16;
        getContentResolver().delete(r9, null, null);
    L16:
        ArrayList r5 = new ArrayList();
        r5.add(r9.toString());
        sendDeleteContactsBroadCast(getBaseContext(), r5, r0);
        LocalToSyncUtils.delete2Sync(this, Collections.singletonList(Long.valueOf(r2)));
        return;
    L15:
        getContentResolver().delete(r9, null, null);
        goto L16
    L9:
        r2 = 0;
        goto L10
    }

    public static Intent createDeleteRawContactIntent(Context r2, Uri r3) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_DELETE_RAW_CONTACT);
        r0.putExtra(EXTRA_RAW_CONTACT_URI, r3);
        return r0;
    }

    public void deleteRawContact(Intent r8) {
        Uri r9 = (Uri) r8.getParcelableExtra(EXTRA_RAW_CONTACT_URI);
        if (r9 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for deleteRawContact request");
        return;
    L6:
        long r1 = ContentUris.parseId(r9);
        long r3 = SyncToLocalUtils.queryContactIdByRawContactId(this, r1);
        getContentResolver().delete(r9, null, null);
        if (r3 <= 0) goto L9;
        r1 = r3;
    L9:
        LocalToSyncUtils.delete2Sync(this, Collections.singletonList(Long.valueOf(r1)));
        Uri r10 = ContactsUtils.getContactUriFromRawContactUri(getApplicationContext(), r9);     // Catch: Exception -> L15
        if (r10.toString().contains(ContractKt.IM_CUSTOM) == false) goto L13;
        return;
    L13:
        Uri r2 = ContactsContract.Contacts.getLookupUri(getContentResolver(), r10);     // Catch: Exception -> L15
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L15
        r4.add(r2.toString());     // Catch: Exception -> L15
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L15
        r5.add(getDisplayNameFromLookupUri(getContentResolver(), r2));     // Catch: Exception -> L15
        MemoryCardUtil.deleteCardWithContactUri(getApplicationContext(), r10);     // Catch: Exception -> L15
        sendDeleteContactsBroadCast(getBaseContext(), r4, r5);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "deleteRawContact: ", e);
    }

    public static Intent createDeleteMultiContactsIntent(Context r2, long[] r3) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_DELETE_MULTI_CONTACTS);
        r0.putExtra(EXTRA_CONTACTS_IDS, r3);
        return r0;
    }

    private void deleteMultiContacts(Intent r9) {
        long[] r10 = r9.getLongArrayExtra(EXTRA_CONTACTS_IDS);
        int r0 = r10.length;
        ArrayList r1 = new ArrayList(r0);
        int r2 = r10.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r1.add(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, r10[r4]));
        r4 = r4 + 1;
        goto L3
    L5:
        ArrayList r5 = new ArrayList(r0);
        Iterator r6 = r1.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r5.add(ContentProviderOperation.newDelete((Uri) r6.next()).build());
        goto L7
    L9:
        ContactsUtils.runApplyBatch(getContentResolver(), "com.android.contacts", r5);
        ArrayList r7 = new ArrayList(r10.length);
        int r8 = r10.length;
    L10:
        if (r3 >= r8) goto L12;
        r7.add(Long.valueOf(r10[r3]));
        r3 = r3 + 1;
        goto L10
    L12:
        LocalToSyncUtils.delete2Sync(this, r7);
    }

    public static String getDisplayNameFromLookupUri(ContentResolver r8, Uri r9) {
        String r1 = "";
        Cursor r10 = r8.query(r9, new String[]{"display_name"}, null, null, null);     // Catch: Throwable -> L9
        if (r10 != null) goto L6;
        return "";
    L6:
        if (r10.moveToFirst() == false) goto L15;
        r1 = r10.getString(r10.getColumnIndex("display_name"));     // Catch: Throwable -> L9
        r10.close();     // Catch: Throwable -> L9
        return r1;
    L15:
        return "";
    L9:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getDisplayNameFromLookupUri error:" + th);
        return r1;
    }

    public static void sendDeleteContactsBroadCast(Context r7, ArrayList<String> r8, ArrayList<String> r9) {
        int r0 = r8.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r1 + 200;
        int r3 = Math.min(r2, r0);
        List<String> r4 = r8.subList(r1, r3);
        List<String> r5 = r9.subList(r1, r3);
        Intent r6 = new Intent("com.android.contact.update");
        r6.setPackage("com.obric.memory");
        r6.putExtra("opType", 2);
        r6.putStringArrayListExtra("deleteUris", new ArrayList(r4));
        r6.putStringArrayListExtra("displayNames", new ArrayList(r5));
        r7.sendBroadcast(r6);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "send delete contact broadcast: " + r4);
        r1 = r2;
        goto L3
    }

    public static Intent createJoinContactsIntent(Context r2, long r3, long r5, boolean r7, Class<?> r8, String r9) {
        Intent r0 = new Intent(r2, ContactSaveService.class);
        r0.setAction(ACTION_JOIN_CONTACTS);
        r0.putExtra(EXTRA_CONTACT_ID1, r3);
        r0.putExtra(EXTRA_CONTACT_ID2, r5);
        r0.putExtra(EXTRA_CONTACT_WRITABLE, r7);
        Intent r4 = new Intent(r2, r8);
        r4.setAction(r9);
        r0.putExtra(EXTRA_CALLBACK_INTENT, r4);
        return r0;
    }

    private void joinContacts(Intent r20) {
        long r3 = r20.getLongExtra(EXTRA_CONTACT_ID1, -1);
        long r5 = r20.getLongExtra(EXTRA_CONTACT_ID2, -1);
        int r10 = 0;
        r20.getBooleanExtra(EXTRA_CONTACT_WRITABLE, false);
        if (r3 != (-1)) goto L5;
    L39:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for joinContacts request");
        return;
    L5:
        if (r5 == (-1)) goto L39;
        ContentResolver r2 = getContentResolver();
        boolean r18 = true;
        Cursor r1 = r2.query(ContactsContract.RawContacts.CONTENT_URI, JoinContactQuery.PROJECTION, JoinContactQuery.SELECTION, new String[]{String.valueOf(r3), String.valueOf(r5)}, null);
        int r12 = r1.getCount();     // Catch: Throwable -> L36
        long[] r13 = new long[r12];     // Catch: Throwable -> L36
        int r4 = -1;
        int r6 = 0;
    L9:
        if (r6 >= r12) goto L14;
        r1.moveToPosition(r6);     // Catch: Throwable -> L36
        r13[r6] = r1.getLong(0);     // Catch: Throwable -> L36
        int r7 = r1.getInt(2);     // Catch: Throwable -> L36
        if (r7 <= r4) goto L13;
        r4 = r7;
    L13:
        r6 = r6 + 1;
        goto L9
    L14:
        r1.close();
        ArrayList<ContentProviderOperation> r0 = new ArrayList();
        int r14 = 0;
    L15:
        if (r14 >= r12) goto L23;
        int r15 = r10;
    L17:
        if (r15 >= r12) goto L22;
        if (r14 == r15) goto L21;
        buildJoinContactDiff(r0, r13[r14], r13[r15]);
    L21:
        r15 = r15 + 1;
        r2 = r2;
        goto L17
    L22:
        r14 = r14 + 1;
        r10 = 0;
        goto L15
    L23:
        ContentResolver r11 = r2;
        r11.applyBatch("com.android.contacts", r0);     // Catch: OperationApplicationException -> L26 RemoteException -> L28
        showToast(R.string.contactsJoinedMessage);     // Catch: OperationApplicationException -> L26 RemoteException -> L28
    L31:
        Intent r8 = (Intent) r20.getParcelableExtra(EXTRA_CALLBACK_INTENT);
        if (r18 == false) goto L34;
        r8.setData(ContactsContract.RawContacts.getContactLookupUri(r11, ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r13[0])));
    L34:
        deliverCallback(r8);
        return;
    L26:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to apply aggregation exception batch", e);
        showToast(R.string.contactSavedErrorToast);
    L30:
        r18 = false;
    L28:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to apply aggregation exception batch", e);
        showToast(R.string.contactSavedErrorToast);
    L36:
        th = move-exception;
        r1.close();
        throw th;
    }

    private void buildJoinContactDiff(ArrayList<ContentProviderOperation> r3, long r4, long r6) {
        ContentProviderOperation.Builder r2 = ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI);
        r2.withValue("type", 1);
        r2.withValue("raw_contact_id1", Long.valueOf(r4));
        r2.withValue("raw_contact_id2", Long.valueOf(r6));
        r3.add(r2.build());
    }

    private void showToast(final int r3) {
        this.mMainHandler.post(new AnonymousClass2(this, r3));
    }

    private void showToast(final String r3) {
        this.mMainHandler.post(new AnonymousClass3(this, r3));
    }

    private void deliverCallback(final Intent r3) {
        this.mMainHandler.post(new AnonymousClass4(this, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    void deliverCallbackOnUiThread(Intent r4) {
        Iterator<Listener> r3 = sListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        Listener r0 = r3.next();
        if (r4.getComponent().equals(((Activity) r0).getIntent().getComponent()) == false) goto L4;
        r0.onServiceCompleted(r4);
        return;
    }
}
