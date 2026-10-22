package com.android.contacts.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.AsyncQueryHandler;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.editor.Editor;
import com.android.contacts.editor.ViewIdGenerator;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityDeltaList;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.DialogManager;
import com.android.contacts.util.EmptyService;
import com.android.contacts.util.UiUtils;
import com.android.contacts.widget.ProgressDialog;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class ConfirmAddDetailActivity extends Activity implements DialogManager.DialogShowingViewActivity {
    private static final String LEGACY_CONTACTS_AUTHORITY = "contacts";
    private static final String TAG = "ConfirmAddDetailActivity";
    private static final int TOKEN_CONTACT_INFO = 0;
    private static final int TOKEN_DISAMBIGUATION_QUERY = 2;
    private static final int TOKEN_EXTRA_INFO_QUERY = 3;
    private static final int TOKEN_PHOTO_QUERY = 1;
    private static final String[] sMimeTypePriorityList = null;
    private static WeakReference<ProgressDialog> sProgressDialog;
    private AccountTypeManager mAccountTypeManager;
    private final View.OnClickListener mCancelButtonClickListener;
    private long mContactId;
    private Uri mContactUri;
    private ContentResolver mContentResolver;
    private final View.OnClickListener mDetailsButtonClickListener;
    private final DialogManager mDialogManager;
    private String mDisplayName;
    private TextView mDisplayNameView;
    private final View.OnClickListener mDoneButtonClickListener;
    private AccountType mEditableAccountType;
    private FrameLayout mEditorContainerView;
    private EntityDeltaList mEntityDeltaList;
    private LayoutInflater mInflater;
    private boolean mIsReadyOnly;
    private String mMimetype;
    private ImageView mPhotoView;
    private QueryHandler mQueryHandler;
    private TextView mReadOnlyWarningView;
    private View mRootView;
    private EntityDelta mState;

    private interface ContactQuery {
        public static final String[] COLUMNS = null;
        public static final int DISPLAY_NAME = 3;
        public static final int LOOKUP_KEY = 1;
        public static final int PHOTO_ID = 2;
        public static final int _ID = 0;

        static {
            COLUMNS = new String[]{"_id", "lookup", "photo_id", "display_name"};
        }
    }

    private interface ExtraInfoQuery {
        public static final String[] COLUMNS = null;
        public static final int CONTACT_ID = 0;
        public static final int DATA1 = 2;
        public static final int MIMETYPE = 1;

        static {
            COLUMNS = new String[]{"contact_id", "mimetype", "data1"};
        }
    }

    public static class PersistTask extends AsyncTask<EntityDeltaList, Void, Integer> {
        private static final int PERSIST_TRIES = 3;
        private static final int RESULT_FAILURE = 2;
        private static final int RESULT_SUCCESS = 1;
        private static final int RESULT_UNCHANGED = 0;
        private ConfirmAddDetailActivity activityTarget;
        private AccountTypeManager mAccountTypeManager;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Integer doInBackground(EntityDeltaList[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Integer r1) {
            onPostExecute2(r1);
        }

        public PersistTask(ConfirmAddDetailActivity r1, AccountTypeManager r2) {
            this.activityTarget = r1;
            this.mAccountTypeManager = r2;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            ProgressDialog r0 = new ProgressDialog(this.activityTarget);
            r0.setMessage(this.activityTarget.getText(R.string.savingContact));
            r0.show();
            ConfirmAddDetailActivity.access$1502(new WeakReference(r0));
            ConfirmAddDetailActivity r3 = this.activityTarget;
            r3.startService(new Intent(r3, EmptyService.class));
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Integer doInBackground2(EntityDeltaList... r5) {
            ContentResolver r1 = this.activityTarget.getContentResolver();
            int r2 = 0;
            EntityDeltaList r6 = r5[0];
            int r3 = 2;
            if (r6 != null) goto L5;
            return r3;
        L5:
            EntityModifier.trimEmpty(r6, this.mAccountTypeManager);
            ArrayList<ContentProviderOperation> r4 = r6.buildDiff();     // Catch: OperationApplicationException -> L14 RemoteException -> L16
            if (r4.isEmpty() == true) goto L10;
            r1.applyBatch("com.android.contacts", r4);     // Catch: OperationApplicationException -> L14 RemoteException -> L16
        L10:
            if (r4.size() <= 0) goto L12;
            r2 = 1;
        L12:
        L22:
            return Integer.valueOf(r2);
        L14:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ConfirmAddDetailActivity.TAG, "Version consistency failed", e);
            return r3;
        L16:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ConfirmAddDetailActivity.TAG, "Problem persisting user edits", e);
            return r3;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Integer r6) {
            ConfirmAddDetailActivity r0 = this.activityTarget;
            ConfirmAddDetailActivity.access$1600();
            boolean r3 = true;
            if (r6.intValue() != 1) goto L6;
        L8:
            r0.stopService(new Intent(r0, EmptyService.class));
            ConfirmAddDetailActivity r5 = this.activityTarget;
            if (r6.intValue() != 2) goto L12;
            r3 = false;
        L12:
            ConfirmAddDetailActivity.access$100(r5, r3);
            return;
        L6:
            if (r6.intValue() != 2) goto L8;
            Toast.makeText(r0, R.string.contactSavedErrorToast, 1).show();
            goto L8
        }
    }

    private interface PhotoQuery {
        public static final String[] COLUMNS = null;
        public static final int PHOTO = 0;

        static {
            COLUMNS = new String[]{BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG};
        }
    }

    private static class QueryEntitiesTask extends AsyncTask<Intent, Void, EntityDeltaList> {
        private ConfirmAddDetailActivity activityTarget;
        private String mSelection;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ EntityDeltaList doInBackground(Intent[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(EntityDeltaList r1) {
            onPostExecute2(r1);
        }

        public QueryEntitiesTask(ConfirmAddDetailActivity r1) {
            this.activityTarget = r1;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected EntityDeltaList doInBackground2(Intent... r7) {
            Intent r8 = r7[0];
            ContentResolver r1 = this.activityTarget.getContentResolver();
            Uri r2 = r8.getData();
            String r3 = r2.getAuthority();
            String r9 = r8.resolveType(r1);
            this.mSelection = "0";
            if ("com.android.contacts".equals(r3) == false) goto L11;
            if ("vnd.android.cursor.item/contact".equals(r9) == false) goto L8;
            String r10 = String.valueOf(ContentUris.parseId(r2));
            this.mSelection = "contact_id=?";
        L15:
            return EntityDeltaList.fromQuery(ContactsContract.RawContactsEntity.CONTENT_URI, this.activityTarget.getContentResolver(), this.mSelection, new String[]{r10}, null);
        L8:
            if ("vnd.android.cursor.item/raw_contact".equals(r9) == false) goto L13;
            r10 = String.valueOf(queryForContactId(r1, ContentUris.parseId(r2)));
            this.mSelection = "contact_id=?";
        L13:
            r10 = null;
            goto L15
        L11:
            if ("contacts".equals(r3) == false) goto L13;
            r10 = String.valueOf(ContentUris.parseId(r2));
            this.mSelection = "raw_contact_id=?";
            goto L15
        }

        private static long queryForContactId(ContentResolver r7, long r8) {
            Cursor r0 = null;
            r0 = r7.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"contact_id"}, "_id=?", new String[]{String.valueOf(r8)}, null);     // Catch: Throwable -> L13
            if (r0 != null) goto L6;
        L9:
            long r9 = -1;
        L10:
            if (r0 == null) goto L12;
            r0.close();
        L12:
            return r9;
        L6:
            if (r0.moveToFirst() == false) goto L9;
            r9 = r0.getLong(0);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            if (r0 == null) goto L16;
            r0.close();
        L16:
            throw th;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(EntityDeltaList r2) {
            if (this.activityTarget.isFinishing() == false) goto L5;
            return;
        L5:
            this.activityTarget.setEntityDeltaList(r2);
            this.activityTarget.findEditableRawContact();
            this.activityTarget.parseExtras();
            ConfirmAddDetailActivity.access$300(this.activityTarget);
        }
    }

    private class QueryHandler extends AsyncQueryHandler {
        final /* synthetic */ ConfirmAddDetailActivity this$0;

        public QueryHandler(ConfirmAddDetailActivity r1, ContentResolver r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r6, Object r7, Cursor r8) {
        L67:
            th = move-exception;
            if (r8 == null) goto L70;
            r8.close();
        L70:
            throw th;
        L3:
            if (this == ConfirmAddDetailActivity.access$400(this.this$0)) goto L11;
            if (ContactsUtils.DEBUG == false) goto L7;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ConfirmAddDetailActivity.TAG, "onQueryComplete: discard result, the query handler is reset!");     // Catch: Throwable -> L67
        L7:
            if (r8 == null) goto L78;
            r8.close();
            return;
        L78:
            return;
        L11:
            if (this.this$0.isFinishing() == false) goto L15;
            if (r8 == null) goto L79;
            r8.close();
            return;
        L79:
            return;
        L15:
            int r2 = 0;
            if (r6 == 0) goto L57;
            if (r6 == 1) goto L48;
            if (r6 == 2) goto L43;
            if (r6 != 3) goto L64;
            if (r8 == null) goto L64;
            if (r8.moveToFirst() == false) goto L64;
            HashMap r9 = new HashMap();     // Catch: Throwable -> L67
        L26:
            if (r8.isAfterLast() == true) goto L36;
            String r10 = r8.getString(1);     // Catch: Throwable -> L67
            if (TextUtils.isEmpty(r10) == true) goto L35;
            String r3 = r8.getString(2);     // Catch: Throwable -> L67
            if (TextUtils.isEmpty(r3) == true) goto L35;
            if ("vnd.android.cursor.item/phone_v2".equals(r10) == false) goto L34;
            r3 = PhoneNumberUtils.formatNumber(r3);     // Catch: Throwable -> L67
        L34:
            r9.put(r10, r3);     // Catch: Throwable -> L67
        L35:
            r8.moveToNext();     // Catch: Throwable -> L67
            goto L26
        L36:
            String[] r11 = ConfirmAddDetailActivity.access$1300();     // Catch: Throwable -> L67
            int r0 = r11.length;     // Catch: Throwable -> L67
        L37:
            if (r2 >= r0) goto L42;
            String r1 = r11[r2];     // Catch: Throwable -> L67
            if (r9.containsKey(r1) == true) goto L40;
            r2 = r2 + 1;     // Catch: Throwable -> L67
            goto L37
        L40:
            ConfirmAddDetailActivity.access$1000(this.this$0);     // Catch: Throwable -> L67
            ConfirmAddDetailActivity.access$1400(this.this$0, (String) r9.get(r1));     // Catch: Throwable -> L67
        L42:
            ConfirmAddDetailActivity.access$1100(this.this$0);     // Catch: Throwable -> L67
        L64:
            if (r8 == null) goto L80;
            r8.close();
            return;
        L80:
            return;
        L43:
            if (r8 != null) goto L45;
        L47:
            ConfirmAddDetailActivity.access$1000(this.this$0);     // Catch: Throwable -> L67
            ConfirmAddDetailActivity.access$1100(this.this$0);     // Catch: Throwable -> L67
            goto L64
        L45:
            if (r8.getCount() <= 0) goto L47;
            ConfirmAddDetailActivity.access$1200(this.this$0);     // Catch: Throwable -> L67
            goto L64
        L48:
            Bitmap r12 = null;
            if (r8 != null) goto L51;
        L55:
            if (r12 == null) goto L64;
            ConfirmAddDetailActivity.access$500(this.this$0).setImageBitmap(r12);     // Catch: Throwable -> L67
            goto L64
        L51:
            if (r8.moveToFirst() == false) goto L55;
            if (r8.isNull(0) == true) goto L55;
            byte[] r13 = r8.getBlob(0);     // Catch: Throwable -> L67
            r12 = BitmapFactory.decodeByteArray(r13, 0, r13.length, null);     // Catch: Throwable -> L67
            goto L55
        L57:
            if (r8 == null) goto L64;
            if (r8.moveToFirst() == false) goto L64;
            ConfirmAddDetailActivity.access$602(this.this$0, r8.getString(3));     // Catch: Throwable -> L67
            long r14 = r8.getLong(2);     // Catch: Throwable -> L67
            if (r14 != 0) goto L63;
            ConfirmAddDetailActivity.access$702(this.this$0, r8.getLong(0));     // Catch: Throwable -> L67
            ConfirmAddDetailActivity r5 = this.this$0;     // Catch: Throwable -> L67
            ConfirmAddDetailActivity.access$800(r5, ConfirmAddDetailActivity.access$600(r5));     // Catch: Throwable -> L67
            goto L64
        L63:
            Uri r4 = ContactsContract.Contacts.getLookupUri(ConfirmAddDetailActivity.access$700(this.this$0), r8.getString(1));     // Catch: Throwable -> L67
            ConfirmAddDetailActivity.access$900(this.this$0, r14, r4, false);     // Catch: Throwable -> L67
            ConfirmAddDetailActivity.access$1000(this.this$0);     // Catch: Throwable -> L67
            ConfirmAddDetailActivity.access$1100(this.this$0);     // Catch: Throwable -> L67
            goto L64
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_activities_ConfirmAddDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ConfirmAddDetailActivity() {
        this.mMimetype = "vnd.android.cursor.item/phone_v2";
        this.mDialogManager = new DialogManager(this);
        this.mDetailsButtonClickListener = new AnonymousClass1(this);
        this.mDoneButtonClickListener = new AnonymousClass2(this);
        this.mCancelButtonClickListener = new AnonymousClass3(this);
    }

    static /* synthetic */ boolean access$000(ConfirmAddDetailActivity r0) {
        return r0.mIsReadyOnly;
    }

    static /* synthetic */ void access$100(ConfirmAddDetailActivity r0, boolean r1) {
        r0.onSaveCompleted(r1);
    }

    static /* synthetic */ void access$1000(ConfirmAddDetailActivity r0) {
        r0.setDisplayName();
    }

    static /* synthetic */ void access$1100(ConfirmAddDetailActivity r0) {
        r0.onLoadDataFinished();
    }

    static /* synthetic */ void access$1200(ConfirmAddDetailActivity r0) {
        r0.startExtraInfoQuery();
    }

    static /* synthetic */ String[] access$1300() {
        return sMimeTypePriorityList;
    }

    static /* synthetic */ void access$1400(ConfirmAddDetailActivity r0, String r1) {
        r0.setExtraInfoField(r1);
    }

    static /* synthetic */ WeakReference access$1502(WeakReference r0) {
        sProgressDialog = r0;
        return r0;
    }

    static /* synthetic */ void access$1600() {
        dismissProgressDialog();
    }

    static /* synthetic */ void access$200(ConfirmAddDetailActivity r0) {
        r0.doSaveAction();
    }

    static /* synthetic */ void access$300(ConfirmAddDetailActivity r0) {
        r0.bindEditor();
    }

    static /* synthetic */ QueryHandler access$400(ConfirmAddDetailActivity r0) {
        return r0.mQueryHandler;
    }

    static /* synthetic */ ImageView access$500(ConfirmAddDetailActivity r0) {
        return r0.mPhotoView;
    }

    static /* synthetic */ String access$600(ConfirmAddDetailActivity r0) {
        return r0.mDisplayName;
    }

    static /* synthetic */ String access$602(ConfirmAddDetailActivity r0, String r1) {
        r0.mDisplayName = r1;
        return r1;
    }

    static /* synthetic */ long access$700(ConfirmAddDetailActivity r2) {
        return r2.mContactId;
    }

    static /* synthetic */ long access$702(ConfirmAddDetailActivity r0, long r1) {
        r0.mContactId = r1;
        return r1;
    }

    static /* synthetic */ void access$800(ConfirmAddDetailActivity r0, String r1) {
        r0.startDisambiguationQuery(r1);
    }

    static /* synthetic */ void access$900(ConfirmAddDetailActivity r0, long r1, Uri r3, boolean r4) {
        r0.startPhotoQuery(r1, r3, r4);
    }

    static {
        sMimeTypePriorityList = new String[]{"vnd.android.cursor.item/nickname", "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/im", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/phone_v2"};
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        UiUtils.setWindowColorStatusBar(this);
        this.mInflater = (LayoutInflater) getSystemService("layout_inflater");
        this.mContentResolver = getContentResolver();
        Intent r5 = getIntent();
        Uri r0 = r5.getData();
        this.mContactUri = r0;
        if (r0 != null) goto L5;
        setResult(0);
        finish();
    L5:
        Bundle r1 = r5.getExtras();
        if (r1 != null) goto L8;
    L15:
        this.mAccountTypeManager = AccountTypeManager.getInstance(this);
        setContentView(R.layout.confirm_add_detail_activity);
        this.mRootView = findViewById(R.id.root_view);
        this.mReadOnlyWarningView = (TextView) findViewById(R.id.read_only_warning);
        findViewById(R.id.open_details_push_layer).setOnClickListener(this.mDetailsButtonClickListener);
        findViewById(R.id.btn_done).setOnClickListener(this.mDoneButtonClickListener);
        findViewById(R.id.btn_cancel).setOnClickListener(this.mCancelButtonClickListener);
        this.mDisplayNameView = (TextView) findViewById(R.id.name);
        this.mPhotoView = (ImageView) findViewById(R.id.photo);
        this.mEditorContainerView = (FrameLayout) findViewById(R.id.editor_container);
        startContactQuery(this.mContactUri, true);
        new QueryEntitiesTask(this).execute(new Intent[]{r5});
        return;
    L8:
        if (r1.containsKey("phone") == false) goto L11;
        this.mMimetype = "vnd.android.cursor.item/phone_v2";
        goto L15
    L11:
        if (r1.containsKey("email") == false) goto L14;
        this.mMimetype = "vnd.android.cursor.item/email_v2";
        goto L15
    L14:
        throw new IllegalStateException("Error: No valid mimetype found in intent extras");
    }

    @Override // com.android.contacts.util.DialogManager.DialogShowingViewActivity
    public DialogManager getDialogManager() {
        return this.mDialogManager;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r2, Bundle r3) {
        if (DialogManager.isManagedId(r2) == true) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Unknown dialog requested, id: " + r2 + ", args: " + r3);
        return null;
    L5:
        return this.mDialogManager.onCreateDialog(r2, r3);
    }

    private void resetAsyncQueryHandler() {
        this.mQueryHandler = new QueryHandler(this, this.mContentResolver);
    }

    private void startContactQuery(Uri r9, boolean r10) {
        if (r10 == false) goto L4;
        resetAsyncQueryHandler();
    L4:
        this.mQueryHandler.startQuery(0, r9, r9, ContactQuery.COLUMNS, null, null, null);
    }

    private void startPhotoQuery(long r9, Uri r11, boolean r12) {
        if (r12 == false) goto L4;
        resetAsyncQueryHandler();
    L4:
        this.mQueryHandler.startQuery(1, r11, ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r9), PhotoQuery.COLUMNS, null, null, null);
    }

    private void startDisambiguationQuery(String r13) {
        Uri.Builder r0 = ContactsContract.Contacts.CONTENT_URI.buildUpon();
        r0.appendQueryParameter("limit", String.valueOf(1));
        this.mQueryHandler.startQuery(2, null, r0.build(), new String[]{"_id"}, "display_name = ? and photo_id is null and _id <> ?", new String[]{r13, String.valueOf(this.mContactId)}, null);
    }

    private void startExtraInfoQuery() {
        this.mQueryHandler.startQuery(3, null, ContactsContract.Data.CONTENT_URI, ExtraInfoQuery.COLUMNS, "contact_id = ?", new String[]{String.valueOf(this.mContactId)}, null);
    }

    public void setEntityDeltaList(EntityDeltaList r1) {
        this.mEntityDeltaList = r1;
    }

    public void findEditableRawContact() {
        EntityDeltaList r0 = this.mEntityDeltaList;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<EntityDelta> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L15;
        EntityDelta r2 = r1.next();
        String r3 = r2.getValues().getAsString("account_type");
        String r4 = r2.getValues().getAsString("data_set");
        AccountType r5 = this.mAccountTypeManager.getAccountType(r3, r4);
        if (r5.areContactsWritable() == false) goto L7;
        this.mEditableAccountType = r5;
        this.mState = r2;
        return;
    }

    public void parseExtras() {
        if (this.mEditableAccountType != null) goto L5;
        return;
    L5:
        if (this.mState == null) goto L16;
        Bundle r0 = getIntent().getExtras();
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.size() <= 0) goto L15;
        EntityModifier.parseExtras(this, this.mEditableAccountType, this.mState, r0);
        return;
    L15:
        return;
    }

    private void bindEditor() {
        if (this.mEntityDeltaList != null) goto L5;
        return;
    L5:
        AccountType r0 = this.mEditableAccountType;
        if (r0 != null) goto L9;
        this.mIsReadyOnly = true;
        this.mReadOnlyWarningView.setText(getString(R.string.contact_read_only));
        this.mReadOnlyWarningView.setVisibility(0);
        this.mEditorContainerView.setVisibility(8);
        findViewById(R.id.btn_done).setVisibility(8);
        onLoadDataFinished();
        return;
    L9:
        Iterator<DataKind> r1 = r0.getSortedDataKinds().iterator();
    L11:
        if (r1.hasNext() == false) goto L39;
        DataKind r2 = r1.next();
        if (r2.editable == false) goto L11;
        if (this.mMimetype.equals(r2.mimeType) == false) goto L11;
        Iterator<EntityDelta.ValuesDelta> r3 = this.mState.getMimeEntries(this.mMimetype).iterator();
    L19:
        if (r3.hasNext() == false) goto L11;
        EntityDelta.ValuesDelta r4 = r3.next();
        if (r4.isVisible() == false) goto L19;
        if (r4.isInsert() == false) goto L19;
        inflateEditorView(r2, r4, this.mState);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void inflateEditorView(DataKind r11, EntityDelta.ValuesDelta r12, EntityDelta r13) {
        View r0 = this.mInflater.inflate(r11.editorLayoutResourceId, this.mEditorContainerView, false);
        if ((r0 instanceof Editor) == false) goto L5;
        Editor r4 = (Editor) r0;
        r4.setDeletable(false);
        r4.setValues(r11, r12, r13, false, new ViewIdGenerator());
    L5:
        this.mEditorContainerView.addView(r0);
    }

    private void setDisplayName() {
        this.mDisplayNameView.setText(this.mDisplayName);
    }

    private void setExtraInfoField(String r2) {
        TextView r1 = (TextView) findViewById(R.id.extra_info);
        r1.setVisibility(0);
        r1.setText(r2);
    }

    private void onLoadDataFinished() {
        this.mRootView.setVisibility(0);
    }

    private void doSaveAction() {
        new PersistTask(this, this.mAccountTypeManager).execute(new EntityDeltaList[]{this.mEntityDeltaList});
    }

    public void com_android_contacts_activities_ConfirmAddDetailActivity__onStop$___twin___() {
        super.onStop();
        dismissProgressDialog();
    }

    private static void dismissProgressDialog() {
        WeakReference<ProgressDialog> r0 = sProgressDialog;
        if (r0 != null) goto L5;
        ProgressDialog r1 = null;
    L6:
        if (r1 == null) goto L8;
        r1.dismiss();
    L8:
        sProgressDialog = null;
        return;
    L5:
        r1 = r0.get();
        goto L6
    }

    private void onSaveCompleted(boolean r3) {
        if (r3 == false) goto L4;
        Intent r4 = new Intent("android.intent.action.VIEW", this.mContactUri);
        r4.setPackage("com.android.contacts");
        setResult(-1, r4);
    L5:
        finish();
        return;
    L4:
        setResult(0);
        goto L5
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_ConfirmAddDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ConfirmAddDetailActivity r1) {
        r1.com_android_contacts_activities_ConfirmAddDetailActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
