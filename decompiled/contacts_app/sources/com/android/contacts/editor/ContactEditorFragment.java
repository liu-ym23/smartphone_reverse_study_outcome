package com.android.contacts.editor;

import android.accounts.Account;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Entity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.Collapser;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.activities.GroupEditorActivity;
import com.android.contacts.activities.RingtoneSettingsActivity;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.detail.PhotoSelectionHandler;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityDeltaList;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.model.GoogleAccountType;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.ContactPhotoUtils;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.UriUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.account.LocalAccountContactsUtils;
import com.obric.contacts.Constants;
import com.obric.contactsdk.loader.ContractKt;
import com.obric.immersive.Immersive;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.privacy.PermissionUtils;
import com.obric.privacy.PrivacyConstantsKt;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import com.obric.utils.NewContactsTraceLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import obric.app.MenuDialog;
import obric.app.MenuDialogListAdapter;
import obric.app.tracker.Agent;
import obric.util.CancellableTask;
import obric.util.NavigationBarHelper;

/* JADX INFO: loaded from: classes.dex */
public class ContactEditorFragment extends AbstractFragment implements SplitContactConfirmationDialogFragment.Listener, AggregationSuggestionEngine.Listener, RawContactReadOnlyEditorView.Listener {
    public static final String EXTRA_ADD_STRANGE_NUMBER = "isAddStrangeNumberToContact";
    public static final String INTENT_EXTRA_ADD_TO_DEFAULT_DIRECTORY = "addToDefaultDirectory";
    public static final String INTENT_EXTRA_FROM_BUSINESS_CARD = "fromBCR";
    public static final String INTENT_EXTRA_NEW_LOCAL_PROFILE = "newLocalProfile";
    private static final String INTENT_RESOLVER_PACKAGE_NAME = "com.android.intentresolver";
    private static final String KEY_ACTION = "action";
    private static final String KEY_CONTACT_ID_FOR_JOIN = "contactidforjoin";
    private static final String KEY_CONTACT_WRITABLE_FOR_JOIN = "contactwritableforjoin";
    private static final String KEY_CURRENT_PHOTO_URI = "currentphotouri";
    private static final String KEY_EDIT_STATE = "state";
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_IS_USER_PROFILE = "isUserProfile";
    private static final String KEY_NEW_LOCAL_PROFILE = "newLocalProfile";
    private static final String KEY_RAW_CONTACT_ID_REQUESTING_PHOTO = "photorequester";
    private static final String KEY_SHOW_JOIN_SUGGESTIONS = "showJoinSuggestions";
    private static final String KEY_STATUS = "status";
    private static final String KEY_UPDATED_PHOTOS = "updatedPhotos";
    private static final String KEY_URI = "uri";
    private static final String KEY_VIEW_ID_GENERATOR = "viewidgenerator";
    private static final String KYE_CUSTOM_RINGTONE = "customRingtone";
    private static final int LOADER_DATA = 1;
    private static final int LOADER_GROUPS = 2;
    private static final File PHOTO_DIR = null;
    public static final int REQUEST_CODE_ADDED_NEW_GROUP = 10;
    public static final int REQUEST_CODE_CAMERA_WITH_DATA = 1;
    public static final int REQUEST_CODE_JOIN = 0;
    public static final int REQUEST_CODE_PHOTO_PICKED_WITH_DATA = 2;
    private static final int REQUEST_CODE_PICK_RINGTONE = 4;
    private static final int REQUEST_CODE_SCAN_BARCODE = 5;
    public static final String SAVE_MODE_EXTRA_KEY = "saveMode";
    private static final String TAG = "ContactEditorFragment";
    private static String TEMP_PHOTO_NAME;
    private boolean hasIncomingState;
    public AccountType mAType;
    private String mAccountName;
    private String mAccountType;
    private AccountTypeManager mAccountTypeManager;
    private String mAction;
    private boolean mAddStrangeNumber;
    private AggregationSuggestionEngine mAggregationSuggestionEngine;
    private OPopover mAggregationSuggestionPopup;
    private View mAggregationSuggestionView;
    private long mAggregationSuggestionsRawContactId;
    private boolean mAutoAddToDefaultGroup;
    private ArrayList<Long> mCardIDsList;
    private final EntityDeltaComparator mComparator;
    private long mContactIdForJoin;
    private boolean mContactWritableForJoin;
    private LinearLayout mContent;
    private Context mContext;
    private PhotoHandler mCurrentPhotoHandler;
    private Uri mCurrentPhotoUri;
    private Uri mCustomRingtone;
    private final LoaderManager.LoaderCallbacks<ContactLoader.Result> mDataLoaderListener;
    private String mDataSet;
    private boolean mDelayUpdateTitle;
    private final Editor.EditorListener mDoneButtonStateListener;
    private ContactEditorUtils mEditorUtils;
    private boolean mEnabled;
    private boolean mFromBusinessCard;
    private final LoaderManager.LoaderCallbacks<Cursor> mGroupLoaderListener;
    private Cursor mGroupMetaData;
    private Bundle mIntentExtras;
    private boolean mIsFirstLoad;
    public boolean mIsInsert;
    private boolean mIsUserProfile;
    private Listener mListener;
    private long mLoaderStartTime;
    private Uri mLookupUri;
    private TextFieldsEditorView mNameEditor;
    private final NameModifyTimeComparator mNameModifyTimeComparator;
    private Observer<Integer> mNavigationBarObserver;
    private String mNewEmergencyNumber;
    private boolean mNewLocalProfile;
    private final CancellableTask mPendingShowPhotoActionTask;
    private Bitmap mPhoto;
    RawContactEditorView mRawContactEditor;
    private RawContactEditorLisnter mRawContactEditorLisnter;
    private long mRawContactIdRequestingPhoto;
    private boolean mRequestFocus;
    private boolean mRingtoneChanged;
    private TextView mRingtoneTitle;
    private ONestedScrollView mRoot;
    private Runnable mShowSoftInputRunnable;
    private boolean mSoftInmputShowing;
    private EntityDeltaList mState;
    private int mStatus;
    private Bundle mUpdatedPhotos;
    private ViewIdGenerator mViewIdGenerator;

    public interface CardClickCallback {
        void onCardClickCallback(String r1);

        void onEvent2Occurred(int r1);
    }

    private class EntityDeltaComparator implements Comparator<EntityDelta> {
        final /* synthetic */ ContactEditorFragment this$0;

        private EntityDeltaComparator(ContactEditorFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EntityDeltaComparator(ContactEditorFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(EntityDelta r1, EntityDelta r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(EntityDelta r7, EntityDelta r8) {
            boolean r1 = false;
            if (r7.equals(r8) == false) goto L5;
            return 0;
        L5:
            AccountTypeManager r6 = AccountTypeManager.getInstance(ContactEditorFragment.access$800(this.this$0));
            AccountType r0 = r6.getAccountType(r7.getValues().getAsString("account_type"), r7.getValues().getAsString("data_set"));
            AccountType r9 = r6.getAccountType(r8.getValues().getAsString("account_type"), r8.getValues().getAsString("data_set"));
            if (r0.areContactsWritable() == true) goto L11;
            if (r9.areContactsWritable() == false) goto L11;
            return 1;
        L11:
            if (r0.areContactsWritable() == true) goto L13;
        L15:
            boolean r2 = r0 instanceof GoogleAccountType;
            boolean r5 = r9 instanceof GoogleAccountType;
            if (r2 == false) goto L19;
            if (r5 == true) goto L19;
            return -1;
        L19:
            if (r2 == true) goto L22;
            if (r5 == false) goto L22;
            return 1;
        L22:
            if (r2 == false) goto L25;
            if (r5 == false) goto L25;
            r1 = true;
        L25:
            if (r1 == false) goto L27;
        L40:
            EntityDelta.ValuesDelta r10 = r7.getValues();
            String r3 = r10.getAsString("account_name");
            String r4 = "";
            if (r3 != null) goto L43;
            r3 = "";
        L43:
            EntityDelta.ValuesDelta r11 = r8.getValues();
            String r12 = r11.getAsString("account_name");
            if (r12 == null) goto L47;
            r4 = r12;
        L47:
            int r13 = r3.compareTo(r4);
            if (r13 == 0) goto L50;
            return r13;
        L50:
            Long r14 = r10.getAsLong("_id");
            Long r15 = r11.getAsLong("_id");
            if (r14 != null) goto L53;
            return -1;
        L53:
            if (r15 != null) goto L56;
            return 1;
        L56:
            return (int) (r14.longValue() - r15.longValue());
        L27:
            if (r0.accountType != null) goto L29;
            return 1;
        L29:
            int r16 = r0.accountType.compareTo(r9.accountType);
            if (r16 == 0) goto L33;
            return r16;
        L33:
            if (r0.dataSet == null) goto L38;
            int r17 = r0.dataSet.compareTo(r9.dataSet);
            if (r17 == 0) goto L40;
            return r17;
        L38:
            if (r9.dataSet == null) goto L40;
            return 1;
        L13:
            if (r9.areContactsWritable() == true) goto L15;
            return -1;
        }
    }

    public static class JoinSuggestedContactDialogFragment extends DialogFragment {
        public JoinSuggestedContactDialogFragment() {
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r3) {
            return new OAlertDialogBuilder(getActivity()).title(R.string.common_merge_contacts).message(R.string.aggregation_suggestion_join_dialog_message).horizontalButton().positiveButton(R.string.common_ok, new AnonymousClass2(this)).negativeButton(R.string.common_cancel, new AnonymousClass1(this)).build();
        }
    }

    public interface Listener {
        void bindAccountTitleByEntityDeltas(ArrayList<AccountWithDataSet> r1, int r2);

        void bindAccountTitleByInsertContact(AccountWithDataSet r1, AccountType r2);

        void bindAccountTitleWithOutAccount(boolean r1);

        void onContactNotFound();

        void onContactSplit(Uri r1);

        void onCustomCreateContactActivityRequested(AccountWithDataSet r1, Bundle r2);

        void onCustomEditContactActivityRequested(AccountWithDataSet r1, Uri r2, Bundle r3, boolean r4);

        void onEditOtherContactRequested(Uri r1, ArrayList<ContentValues> r2);

        void onReverted();

        void onSaveFinished(Intent r1);

        void setDoneButtonEnabled(boolean r1);
    }

    private class LoadRawContactsNameRunnable implements Runnable {
        private Activity mContext;
        final /* synthetic */ ContactEditorFragment this$0;

        public LoadRawContactsNameRunnable(ContactEditorFragment r1, Activity r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Collections.sort(ContactEditorFragment.access$900(this.this$0), ContactEditorFragment.access$1000(this.this$0));
            int r1 = ContactEditorFragment.access$900(this.this$0).size();
            final ArrayList r2 = new ArrayList();
            int r4 = 0;
        L3:
            if (r4 >= r1) goto L32;
            EntityDelta r5 = ContactEditorFragment.access$900(this.this$0).get(r4);
            if (ContactEditorFragment.access$900(this.this$0).getRawContactId(r4) == null) goto L31;
            long r6 = ContactEditorFragment.access$900(this.this$0).getRawContactId(r4).longValue();
            EntityDelta.ValuesDelta r8 = r5.getValues();
            String r9 = r8.getAsString("account_type");
            String r10 = r8.getAsString("account_name");
            Cursor r11 = null;
            AccountWithDataSet r12 = null;
            r12 = null;
            r12 = null;
            if (TextUtils.isEmpty(ContactsUtils.getAccountName(this.mContext, r9, r10)) == false) goto L29;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactEditorFragment.TAG, "load rawContacts name account name is empty!");
            ArrayList<ContentValues> r7 = r5.getContentValues();
            if (r7 == null) goto L31;
            if (r7.size() == 0) goto L31;
            Cursor r13 = this.mContext.getContentResolver().query(ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r6), new String[]{"display_name"}, null, null, null);     // Catch: Throwable -> L25
            if (r13 != null) goto L36;
        L23:
            if (r13 == null) goto L30;
            r13.close();
        L30:
            r2.add(r12);
            goto L31
        L36:
        L21:
            th = th;
            r11 = r13;
        L26:
            if (r11 == null) goto L28;
            r11.close();
        L28:
            throw th;
        L16:
            if (r13.moveToFirst() == false) goto L23;
            String r14 = r13.getString(0);     // Catch: Throwable -> L21
            if (TextUtils.isEmpty(r14) == true) goto L23;
            r12 = new AccountWithDataSet(r14, this.mContext.getResources().getString(R.string.local_contact), null);     // Catch: Throwable -> L21
        L25:
            th = th;
            goto L26
        L29:
            r12 = new AccountWithDataSet(r10, r9, null);
        L31:
            r4 = r4 + 1;
            goto L3
        L32:
            this.mContext.runOnUiThread(new AnonymousClass1(this, r2));
        }
    }

    private class NameModifyTimeComparator implements Comparator<EntityDelta> {
        final /* synthetic */ ContactEditorFragment this$0;

        private NameModifyTimeComparator(ContactEditorFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ NameModifyTimeComparator(ContactEditorFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(EntityDelta r1, EntityDelta r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(EntityDelta r7, EntityDelta r8) {
            if (r7 == null) goto L33;
            if (r8 == null) goto L33;
            EntityDelta.ValuesDelta r1 = r7.getValues();
            String r3 = r1.getAsString("account_type");
            String r2 = r1.getAsString("data_set");
            AccountType r4 = ContactEditorFragment.access$1300(this.this$0).getAccountType(r3, r2);
            EntityDelta.ValuesDelta r5 = r8.getValues();
            String r6 = r5.getAsString("account_type");
            String r9 = r5.getAsString("data_set");
            int r10 = getAccountWeight(ContactEditorFragment.access$1300(this.this$0).getAccountType(r6, r9), r6) - getAccountWeight(r4, r3);
            if (r10 == 0) goto L8;
            return r10;
        L8:
            ArrayList<EntityDelta.ValuesDelta> r11 = r7.getMimeEntries("vnd.android.cursor.item/name");
            ArrayList<EntityDelta.ValuesDelta> r12 = r8.getMimeEntries("vnd.android.cursor.item/name");
            if (r11 == null) goto L33;
            if (r12 == null) goto L33;
            if (r11.size() != 1) goto L33;
            if (r12.size() != 1) goto L33;
            EntityDelta.ValuesDelta r13 = r11.get(0);
            EntityDelta.ValuesDelta r14 = r12.get(0);
            if (r13 == null) goto L18;
            Long r15 = r13.getAsLong(Constants.get_LAST_MODIFY_TIME());
        L19:
            if (r14 == null) goto L21;
            Long r16 = r14.getAsLong(Constants.get_LAST_MODIFY_TIME());
        L22:
            if (r15 != null) goto L24;
            r15 = 0L;
        L24:
            if (r16 != null) goto L27;
            r16 = 0L;
        L27:
            if (r15.longValue() <= r16.longValue()) goto L30;
            return 1;
        L30:
            if (r15.longValue() >= r16.longValue()) goto L33;
            return -1;
        L21:
            r16 = 0L;
            goto L22
        L18:
            r15 = 0L;
        L33:
            return 0;
        }

        private int getAccountWeight(AccountType r1, String r2) {
            if (r1.areContactsWritable() == true) goto L5;
            return 0;
        L5:
            if (com.android.contacts.util.Constants.LOCAL_MIXED_ACCOUNT_TYPE.equals(r2) == false) goto L7;
            return 2;
        L7:
            return 1;
        }
    }

    private final class PhotoHandler extends PhotoSelectionHandler {
        private final boolean mAccountWritable;
        private final BaseRawContactEditorView mEditor;
        private final PhotoSelectionHandler.PhotoActionListener mPhotoEditorListener;
        final long mRawContactId;
        final /* synthetic */ ContactEditorFragment this$0;

        private final class PhotoEditorListener extends PhotoSelectionHandler.PhotoActionListener implements Editor.EditorListener {
            final /* synthetic */ PhotoHandler this$1;

            @Override // com.android.contacts.editor.Editor.EditorListener
            public void onDeleteRequested(Editor r1) {
            }

            @Override // com.android.contacts.detail.PhotoSelectionHandler.PhotoActionListener
            public void onPhotoSelectionDismissed() {
            }

            private PhotoEditorListener(PhotoHandler r1) {
                this.this$1 = r1;
                super(r1);
            }

            /* synthetic */ PhotoEditorListener(PhotoHandler r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // com.android.contacts.editor.Editor.EditorListener
            public void onRequest(int r5) {
                if (ContactEditorFragment.access$2900(this.this$1.this$0) == true) goto L5;
                return;
            L5:
                final int r0 = 1;
                if (r5 == 1) goto L8;
                return;
            L8:
                if (PhotoHandler.access$3000(this.this$1) == false) goto L17;
                if (PhotoHandler.access$3100(this.this$1).hasSetPhoto() == true) goto L12;
                r0 = 0;
            L20:
                ContactEditorFragment.access$400(this.this$1.this$0);
                new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(this, r0), 300);
                return;
            L12:
                if (ContactEditorFragment.access$3200(this.this$1.this$0) == false) goto L14;
                r0 = 3;
                goto L20
            L14:
                r0 = 2;
                goto L20
            L17:
                if (PhotoHandler.access$3100(this.this$1).hasSetPhoto() == true) goto L19;
                return;
            L19:
                if (ContactEditorFragment.access$3200(this.this$1.this$0) == true) goto L20;
            }

            @Override // com.android.contacts.detail.PhotoSelectionHandler.PhotoActionListener, com.android.contacts.editor.PhotoActionPopup.Listener
            public void onUseAsPrimaryChosen() {
                int r0 = ContactEditorFragment.access$3400(this.this$1.this$0).getChildCount();
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L12;
                View r3 = ContactEditorFragment.access$3400(this.this$1.this$0).getChildAt(r2);
                if ((r3 instanceof BaseRawContactEditorView) == false) goto L11;
                BaseRawContactEditorView r4 = (BaseRawContactEditorView) r3;
                PhotoEditorView r5 = r4.getPhotoEditor();
                if (r4 != PhotoHandler.access$3100(this.this$1)) goto L9;
                boolean r6 = true;
            L10:
                r5.setSuperPrimary(r6);
                goto L11
            L9:
                r6 = false;
            L11:
                r2 = r2 + 1;
                goto L3
            L12:
                ContactPhotoManager.getInstance(this.this$1.this$0.getActivity()).refreshCache();
            }

            @Override // com.android.contacts.detail.PhotoSelectionHandler.PhotoActionListener, com.android.contacts.editor.PhotoActionPopup.Listener
            public void onRemovePictureChosen() {
                BaseRawContactEditorView r0 = PhotoHandler.access$3100(this.this$1);
                if (this.this$1.mRawContactId != (-115)) goto L5;
                boolean r1 = true;
            L6:
                r0.setPhotoBitmap(null, r1);
                ContactEditorFragment.access$3500(this.this$1.this$0).remove(String.valueOf(this.this$1.mRawContactId));
                FragmentActivity r5 = this.this$1.this$0.getActivity();
                if (r5 == null) goto L10;
                ContactPhotoManager.getInstance(r5).refreshCache();
                return;
            L10:
                return;
            L5:
                r1 = false;
                goto L6
            }

            @Override // com.android.contacts.detail.PhotoSelectionHandler.PhotoActionListener, com.android.contacts.editor.PhotoActionPopup.Listener
            public void onPickFromGalleryChosen() {
                if (ContactEditorFragment.access$3600(this.this$1.this$0) == false) goto L5;
                PhotoHandler r2 = this.this$1;
                PhotoHandler.access$3800(r2, PhotoHandler.access$3700(r2));
                return;
            L5:
                ContactEditorFragment.access$3300(this.this$1.this$0).prepare(new AnonymousClass2(this));
            }

            @Override // com.android.contacts.detail.PhotoSelectionHandler.PhotoActionListener
            public void onPhotoSelected(Uri r5) throws FileNotFoundException {
                Bitmap r0 = ContactPhotoUtils.getBitmapFromUri(PhotoHandler.access$4100(this.this$1), r5);
                ContactEditorFragment.access$4200(this.this$1.this$0, this.this$1.mRawContactId, r0, r5);
                FragmentActivity r4 = this.this$1.this$0.getActivity();
                if (r4 != null) goto L5;
                return;
            L5:
                ContactPhotoManager.getInstance(r4).refreshCache();
            }

            @Override // com.android.contacts.detail.PhotoSelectionHandler.PhotoActionListener
            public Uri getCurrentPhotoUri() {
                return ContactEditorFragment.access$2800(this.this$1.this$0);
            }
        }

        static /* synthetic */ boolean access$3000(PhotoHandler r0) {
            return r0.mAccountWritable;
        }

        static /* synthetic */ BaseRawContactEditorView access$3100(PhotoHandler r0) {
            return r0.mEditor;
        }

        static /* synthetic */ Uri access$3700(PhotoHandler r0) {
            return r0.mTempPhotoUri;
        }

        static /* synthetic */ void access$3800(PhotoHandler r0, Uri r1) {
            r0.startPickFromGalleryActivity(r1);
        }

        static /* synthetic */ Uri access$3900(PhotoHandler r0) {
            return r0.mTempPhotoUri;
        }

        static /* synthetic */ void access$4000(PhotoHandler r0, Uri r1) {
            r0.startPickFromGalleryActivity(r1);
        }

        static /* synthetic */ Context access$4100(PhotoHandler r0) {
            return r0.mContext;
        }

        public PhotoHandler(ContactEditorFragment r2, Context r3, BaseRawContactEditorView r4, EntityDeltaList r5, boolean r6) {
            this.this$0 = r2;
            super(r3, r4.getPhotoEditor(), false, r5);
            this.mEditor = r4;
            this.mRawContactId = r4.getRawContactId();
            this.mPhotoEditorListener = new PhotoEditorListener(this, null);
            this.mAccountWritable = r6;
        }

        @Override // com.android.contacts.detail.PhotoSelectionHandler
        public PhotoSelectionHandler.PhotoActionListener getListener() {
            return this.mPhotoEditorListener;
        }

        @Override // com.android.contacts.detail.PhotoSelectionHandler
        public void startPhotoActivity(Intent r6, int r7, Uri r8) {
            if (ContactsUtils.DEBUG == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactEditorFragment.TAG, "startPhotoActivity == " + r8 + SimContactsConstants.EMAIL_SEP + r7);
        L6:
            if (ContactsUtils.isFeaturePhoneMode() == false) goto L8;
            ContactsApplication.showToast(ContactsUtils.getFeaturePhoneModeHintId(), 1);
            return;
        L8:
            ContactEditorFragment.access$2602(this.this$0, this.mEditor.getRawContactId());
            ContactEditorFragment.access$2702(this.this$0, this);
            ContactEditorFragment.access$2102(this.this$0, 4);
            ContactEditorFragment.access$2802(this.this$0, r8);
            if (ContactEditorFragment.access$2800(this.this$0) == null) goto L16;
            this.mContext.grantUriPermission(ContactEditorFragment.INTENT_RESOLVER_PACKAGE_NAME, ContactEditorFragment.access$2800(this.this$0), 1);
        L16:
            this.this$0.startActivityForResult(Intent.createChooser(r6, null), r7);     // Catch: Exception -> L13
            AnimationUtil.switchActivityAnimation(this.this$0.getActivity(), 1);     // Catch: Exception -> L13
            return;
        L13:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactEditorFragment.TAG, "startPhotoActivity failed", e);
            ContactEditorFragment.access$2102(this.this$0, 1);
            Toast.makeText(this.mContext, R.string.photoPickerNotFoundText, 1).show();
        }
    }

    private final class RawContactEditorLisnter implements BaseRawContactEditorView.Listener {
        final /* synthetic */ ContactEditorFragment this$0;

        private RawContactEditorLisnter(ContactEditorFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ RawContactEditorLisnter(ContactEditorFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.contacts.editor.BaseRawContactEditorView.Listener
        public ContactEditorFragment getContactEditorFragment() {
            return this.this$0;
        }

        @Override // com.android.contacts.editor.BaseRawContactEditorView.Listener
        public String getAction() {
            return ContactEditorFragment.access$600(this.this$0);
        }
    }

    public interface SaveMode {
        public static final int CLOSE = 0;
        public static final int HOME = 4;
        public static final int JOIN = 3;
        public static final int RELOAD = 1;
        public static final int SPLIT = 2;
    }

    private interface Status {
        public static final int CLOSING = 3;
        public static final int EDITING = 1;
        public static final int LOADING = 0;
        public static final int SAVING = 2;
        public static final int SUB_ACTIVITY = 4;
    }

    public static class SuggestionEditConfirmationDialogFragment extends DialogFragment {
        public SuggestionEditConfirmationDialogFragment() {
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r3) {
            return new OAlertDialogBuilder(getActivity()).title(R.string.aggregation_suggestion_edit_dialog_title).message(R.string.aggregation_suggestion_edit_dialog_message).horizontalButton().positiveButton(R.string.common_ok, new AnonymousClass2(this)).negativeButton(R.string.common_cancel, new AnonymousClass1(this)).build();
        }
    }

    public void setAggregationSuggestionViewEnabled(boolean r1) {
    }

    static /* synthetic */ NameModifyTimeComparator access$1000(ContactEditorFragment r0) {
        return r0.mNameModifyTimeComparator;
    }

    static /* synthetic */ void access$1100(ContactEditorFragment r0, EntityDelta r1) {
        r0.bindEditorByEntityDelta(r1);
    }

    static /* synthetic */ Listener access$1200(ContactEditorFragment r0) {
        return r0.mListener;
    }

    static /* synthetic */ AccountTypeManager access$1300(ContactEditorFragment r0) {
        return r0.mAccountTypeManager;
    }

    static /* synthetic */ void access$1400(ContactEditorFragment r0) {
        r0.doRevertAction();
    }

    static /* synthetic */ void access$1500(ContactEditorFragment r0) {
        r0.saveContact();
    }

    static /* synthetic */ String access$1602(ContactEditorFragment r0, String r1) {
        r0.mNewEmergencyNumber = r1;
        return r1;
    }

    static /* synthetic */ void access$1700(ContactEditorFragment r0, AggregationSuggestionEngine.Suggestion r1, boolean r2) {
        r0.handleAggregationSuggestionClick(r1, r2);
    }

    static /* synthetic */ OPopover access$1800(ContactEditorFragment r0) {
        return r0.mAggregationSuggestionPopup;
    }

    static /* synthetic */ OPopover access$1802(ContactEditorFragment r0, OPopover r1) {
        r0.mAggregationSuggestionPopup = r1;
        return r1;
    }

    static /* synthetic */ long access$1902(ContactEditorFragment r0, long r1) {
        r0.mLoaderStartTime = r1;
        return r1;
    }

    static /* synthetic */ ONestedScrollView access$200(ContactEditorFragment r0) {
        return r0.mRoot;
    }

    static /* synthetic */ Uri access$2000(ContactEditorFragment r0) {
        return r0.mLookupUri;
    }

    static /* synthetic */ Uri access$2002(ContactEditorFragment r0, Uri r1) {
        r0.mLookupUri = r1;
        return r1;
    }

    static /* synthetic */ int access$2102(ContactEditorFragment r0, int r1) {
        r0.mStatus = r1;
        return r1;
    }

    static /* synthetic */ void access$2200(ContactEditorFragment r0, ContactLoader.Result r1) {
        r0.setData(r1);
    }

    static /* synthetic */ Cursor access$2302(ContactEditorFragment r0, Cursor r1) {
        r0.mGroupMetaData = r1;
        return r1;
    }

    static /* synthetic */ void access$2400(ContactEditorFragment r0) {
        r0.bindGroupMetaData();
    }

    static /* synthetic */ long access$2602(ContactEditorFragment r0, long r1) {
        r0.mRawContactIdRequestingPhoto = r1;
        return r1;
    }

    static /* synthetic */ PhotoHandler access$2702(ContactEditorFragment r0, PhotoHandler r1) {
        r0.mCurrentPhotoHandler = r1;
        return r1;
    }

    static /* synthetic */ Uri access$2800(ContactEditorFragment r0) {
        return r0.mCurrentPhotoUri;
    }

    static /* synthetic */ Uri access$2802(ContactEditorFragment r0, Uri r1) {
        r0.mCurrentPhotoUri = r1;
        return r1;
    }

    static /* synthetic */ boolean access$2900(ContactEditorFragment r0) {
        return r0.hasValidState();
    }

    static /* synthetic */ boolean access$300(ContactEditorFragment r0) {
        return r0.mSoftInmputShowing;
    }

    static /* synthetic */ boolean access$302(ContactEditorFragment r0, boolean r1) {
        r0.mSoftInmputShowing = r1;
        return r1;
    }

    static /* synthetic */ boolean access$3200(ContactEditorFragment r0) {
        return r0.hasMoreThanOnePhoto();
    }

    static /* synthetic */ CancellableTask access$3300(ContactEditorFragment r0) {
        return r0.mPendingShowPhotoActionTask;
    }

    static /* synthetic */ LinearLayout access$3400(ContactEditorFragment r0) {
        return r0.mContent;
    }

    static /* synthetic */ Bundle access$3500(ContactEditorFragment r0) {
        return r0.mUpdatedPhotos;
    }

    static /* synthetic */ boolean access$3600(ContactEditorFragment r0) {
        return r0.hasPhotoPermission();
    }

    static /* synthetic */ void access$400(ContactEditorFragment r0) {
        r0.hideSoftKeyboard();
    }

    static /* synthetic */ void access$4200(ContactEditorFragment r0, long r1, Bitmap r3, Uri r4) {
        r0.setPhoto(r1, r3, r4);
    }

    static /* synthetic */ String access$600(ContactEditorFragment r0) {
        return r0.mAction;
    }

    static /* synthetic */ void access$700(ContactEditorFragment r0) {
        r0.updateDoneButtonEnabled();
    }

    static /* synthetic */ Context access$800(ContactEditorFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ EntityDeltaList access$900(ContactEditorFragment r0) {
        return r0.mState;
    }

    public ArrayList<Long> getmCardIDsList() {
        return this.mCardIDsList;
    }

    static {
        PHOTO_DIR = new File(Environment.getExternalStorageDirectory() + "/DCIM/Camera");
        TEMP_PHOTO_NAME = "temp_photo.jpg";
    }

    public EntityDeltaList getmState() {
        return this.mState;
    }

    public void setmState(EntityDeltaList r1) {
        this.mState = r1;
        bindEditors();
    }

    public ContactEditorFragment() {
        AnonymousClass1 r0 = null;
        this.mCustomRingtone = null;
        this.mCardIDsList = new ArrayList();
        this.mPhoto = null;
        this.mRawContactIdRequestingPhoto = -1;
        this.mComparator = new EntityDeltaComparator(this, r0);
        this.mNameModifyTimeComparator = new NameModifyTimeComparator(this, r0);
        this.mIsInsert = false;
        this.mDelayUpdateTitle = false;
        this.mPendingShowPhotoActionTask = new CancellableTask(true);
        this.mNavigationBarObserver = new AnonymousClass1(this);
        this.mEnabled = true;
        this.mNewLocalProfile = false;
        this.mIsUserProfile = false;
        this.mSoftInmputShowing = false;
        this.mRawContactEditorLisnter = new RawContactEditorLisnter(this, r0);
        this.mIsFirstLoad = false;
        this.mDoneButtonStateListener = new AnonymousClass4(this);
        this.mAddStrangeNumber = false;
        this.mDataLoaderListener = new AnonymousClass16(this);
        this.mGroupLoaderListener = new AnonymousClass17(this);
        this.mUpdatedPhotos = new Bundle();
    }

    public void setEnabled(boolean r4) {
        if (this.mEnabled == r4) goto L9;
        this.mEnabled = r4;
        LinearLayout r0 = this.mContent;
        if (r0 == null) goto L11;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        this.mContent.getChildAt(r2).setEnabled(r4);
        r2 = r2 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.mContext = r1;
        this.mAccountTypeManager = AccountTypeManager.getInstance(r1);
        this.mEditorUtils = ContactEditorUtils.getInstance(this.mContext);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        AggregationSuggestionEngine r0 = this.mAggregationSuggestionEngine;
        if (r0 == null) goto L5;
        r0.quit();
    L5:
        getActivity().isChangingConfigurations();
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PhotoHandler r0 = this.mCurrentPhotoHandler;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(R.layout.contact_editor_fragment, r3, false);
        this.mRoot = (ONestedScrollView) r5.findViewById(R.id.root);
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().observeForever(this.mNavigationBarObserver);
        this.mContent = (LinearLayout) r5.findViewById(R.id.editors);
        this.mRoot.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2(this));
        this.mRoot.setOnTouchListener(new AnonymousClass3(this));
        if ("android.intent.action.INSERT".equals(this.mAction) == false) goto L6;
        this.mIsInsert = true;
    L6:
        if (this.mState == null) goto L8;
        bindEditors();
    L8:
        return r5;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().removeObserver(this.mNavigationBarObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        if (r3 == null) goto L5;
        boolean r4 = true;
    L6:
        this.hasIncomingState = r4;
        this.mIsFirstLoad = true;
        if (this.mDelayUpdateTitle == true) goto L9;
        return;
    L9:
        if (this.mListener == null) goto L13;
        bindAccountTitle();
        this.mDelayUpdateTitle = false;
        return;
    L13:
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mIsFirstLoad == false) goto L6;
        init();
        this.mIsFirstLoad = false;
        return;
    }

    private void showSoftInput(final View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Runnable r0 = this.mShowSoftInputRunnable;
        if (r0 == null) goto L7;
        r4.removeCallbacks(r0);
    L7:
        Runnable r1 = new AnonymousClass5(this, r4);
        this.mShowSoftInputRunnable = r1;
        r4.postDelayed(r1, 300);
    }

    public void init() {
        if (this.hasIncomingState == false) goto L5;
        return;
    L5:
        if ("android.intent.action.EDIT".equals(this.mAction) == false) goto L8;
        getLoaderManager().initLoader(1, null, this.mDataLoaderListener);
        return;
    L8:
        if ("android.intent.action.INSERT".equals(this.mAction) == false) goto L38;
        this.mIsInsert = true;
        Bundle r0 = this.mIntentExtras;
        if (r0 != null) goto L12;
        Account r1 = null;
    L13:
        Bundle r3 = this.mIntentExtras;
        if (r3 != null) goto L16;
        String r4 = null;
    L17:
        if (r1 == null) goto L19;
        createContact(new AccountWithDataSet(r1.name, r1.type, r4));
        return;
    L19:
        List<AccountWithDataSet> r2 = this.mAccountTypeManager.getAccounts(true);
        if (r2 == null) goto L27;
        if (r2.size() != 1) goto L27;
        if (r2.get(0).type == "com.android.sim") goto L27;
        createContact(r2.get(0));
        return;
    L27:
        if (this.mNewLocalProfile == false) goto L30;
        createContact(null);
        return;
    L30:
        if (r2 == null) goto L34;
        if (r2.size() == 0) goto L34;
    L36:
        selectAccountAndCreateContact(this.mFromBusinessCard);
        return;
    L34:
        if (LocalAccountContactsUtils.isLocalAccount(this.mEditorUtils.getDefaultAccount()) == false) goto L36;
        createContact(LocalAccountContactsUtils.getLocalAccountContacts(null));
        return;
    L16:
        r4 = r3.getString(Constants.get_INSERT_DATA_SET());
        goto L17
    L12:
        r1 = (Account) r0.getParcelable(Constants.get_INSERT_ACCOUNT());
        goto L13
    L38:
        if (ContactEditorActivity.ACTION_SAVE_COMPLETED.equals(this.mAction) == true) goto L48;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unknown Action String " + this.mAction + ". Only support android.intent.action.EDIT or android.intent.action.INSERT");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        getLoaderManager().initLoader(2, null, this.mGroupLoaderListener);
        super.onStart();
    }

    public void load(String r2, Uri r3, Bundle r4) {
        this.mAction = r2;
        this.mLookupUri = r3;
        this.mIntentExtras = r4;
        boolean r5 = true;
        if (r4 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        this.mAutoAddToDefaultGroup = r6;
        Bundle r7 = this.mIntentExtras;
        if (r7 != null) goto L11;
    L13:
        boolean r8 = false;
    L14:
        this.mNewLocalProfile = r8;
        Bundle r9 = this.mIntentExtras;
        if (r9 != null) goto L17;
    L19:
        r5 = false;
    L20:
        this.mFromBusinessCard = r5;
        return;
    L17:
        if (r9.getBoolean(INTENT_EXTRA_FROM_BUSINESS_CARD) == false) goto L19;
    L11:
        if (r7.getBoolean("newLocalProfile") == false) goto L13;
        r8 = true;
        goto L14
    L5:
        if (r4.containsKey(INTENT_EXTRA_ADD_TO_DEFAULT_DIRECTORY) == false) goto L7;
        r6 = true;
        goto L8
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        if (r3 == null) goto L4;
        this.mLookupUri = (Uri) r3.getParcelable(KEY_URI);
        this.mAction = r3.getString("action");
    L4:
        super.onCreate(r3);
        if (r3 != null) goto L7;
        this.mViewIdGenerator = new ViewIdGenerator();
        return;
    L7:
        this.mState = (EntityDeltaList) r3.getParcelable("state");
        this.mRawContactIdRequestingPhoto = r3.getLong(KEY_RAW_CONTACT_ID_REQUESTING_PHOTO);
        this.mViewIdGenerator = (ViewIdGenerator) r3.getParcelable(KEY_VIEW_ID_GENERATOR);
        this.mCurrentPhotoUri = (Uri) r3.getParcelable(KEY_CURRENT_PHOTO_URI);
        this.mContactIdForJoin = r3.getLong(KEY_CONTACT_ID_FOR_JOIN);
        this.mContactWritableForJoin = r3.getBoolean(KEY_CONTACT_WRITABLE_FOR_JOIN);
        this.mAggregationSuggestionsRawContactId = r3.getLong(KEY_SHOW_JOIN_SUGGESTIONS);
        this.mEnabled = r3.getBoolean(KEY_ENABLED);
        this.mStatus = r3.getInt("status");
        this.mNewLocalProfile = r3.getBoolean("newLocalProfile");
        this.mIsUserProfile = r3.getBoolean(KEY_IS_USER_PROFILE);
        this.mCustomRingtone = (Uri) r3.getParcelable("customRingtone");
        this.mUpdatedPhotos = (Bundle) r3.getParcelable("updatedPhotos");
    }

    private void setData(ContactLoader.Result r8) {
        if (this.mState == null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "Ignoring background change. This will have to be rebased later");
        return;
    L6:
        ArrayList<Entity> r0 = r8.getEntities();
        if (r0.size() != 1) goto L16;
        ContentValues r1 = r0.get(0).getEntityValues();
        String r2 = r1.getAsString("account_type");
        String r3 = r1.getAsString("data_set");
        AccountType r4 = this.mAccountTypeManager.getAccountType(r2, r3);
        if (r4.getEditContactActivityClassName() == null) goto L16;
        if (r4.areContactsWritable() == true) goto L16;
        if (this.mListener == null) goto L18;
        String r9 = r1.getAsString("account_name");
        long r5 = r1.getAsLong("_id").longValue();
        this.mListener.onCustomEditContactActivityRequested(new AccountWithDataSet(r9, r2, r3), ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r5), this.mIntentExtras, true);
        return;
    L18:
        return;
    L16:
        bindEditorsForExistingContact(r8);
    }

    @Override // com.android.contacts.editor.RawContactReadOnlyEditorView.Listener
    public void onExternalEditorRequest(AccountWithDataSet r3, Uri r4) {
        this.mListener.onCustomEditContactActivityRequested(r3, r4, null, false);
    }

    private void bindEditorsForExistingContact(ContactLoader.Result r3) {
        setEnabled(true);
        this.mState = EntityDeltaList.fromIterator(r3.getEntities().iterator());
        addMixedEntityDelta(r3);
        setIntentExtras(this.mIntentExtras);
        boolean r0 = r3.isUserProfile();
        this.mIsUserProfile = r0;
        if (r0 == false) goto L8;
        Iterator<EntityDelta> r1 = this.mState.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().setProfileQueryUri();
    L8:
        String r4 = r3.getCustomRingtone();
        if (TextUtils.isEmpty(r4) == true) goto L11;
        this.mCustomRingtone = Uri.parse(r4);
    L12:
        initCardIDs(this.mState);
        bindEditors();
        return;
    L11:
        this.mCustomRingtone = null;
        goto L12
    }

    private void initCardIDs(EntityDeltaList r7) {
        Iterator<EntityDelta> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L16;
        ArrayList<EntityDelta.ValuesDelta> r0 = r8.next().getMimeEntries("vnd.android.cursor.item/card_id");
        if (r0 == null) goto L4;
        Iterator<EntityDelta.ValuesDelta> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L4;
        Long r2 = r1.next().getAsLong(DBHelper.COL_DATA3);
        if (r2 == null) goto L10;
        if (r2.longValue() == (-1)) goto L10;
        this.mCardIDsList.add(r2);
        goto L10
    }

    private void addMixedEntityDelta(ContactLoader.Result r29) {
        ArrayList<Entity> r1 = r29.getEntities();
        if (r1.size() > 1) goto L5;
        return;
    L5:
        Iterator<Entity> r2 = r1.iterator();
        int r4 = 0;
    L6:
        String r6 = "data_set";
        String r7 = "account_type";
        if (r2.hasNext() == false) goto L11;
        ContentValues r5 = r2.next().getEntityValues();
        if (this.mAccountTypeManager.getAccountType(r5.getAsString("account_type"), r5.getAsString("data_set")).areContactsWritable() == false) goto L6;
        r4 = r4 + 1;
        goto L6
    L11:
        if (r4 > 1) goto L13;
        return;
    L13:
        HashMap r3 = new HashMap();
        long r8 = r29.getNameRawContactId();
        ArrayList<EntityDelta.ValuesDelta> r9 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r10 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r11 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r12 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r13 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r14 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r15 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r16 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r17 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r18 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r19 = r13;
        ArrayList<EntityDelta.ValuesDelta> r110 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r111 = r17;
        ArrayList<EntityDelta.ValuesDelta> r112 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r113 = r110;
        ArrayList<EntityDelta.ValuesDelta> r114 = new ArrayList();
        Iterator<EntityDelta> r115 = this.mState.iterator();
        EntityDelta.ValuesDelta r21 = null;
    L14:
        ArrayList<EntityDelta.ValuesDelta> r22 = r112;
        ArrayList<EntityDelta.ValuesDelta> r23 = r16;
        if (r115.hasNext() == false) goto L77;
        r115 = r115;
        EntityDelta r116 = r115.next();
        ArrayList<EntityDelta.ValuesDelta> r20 = r14;
        EntityDelta.ValuesDelta r117 = r116.getValues();
        ArrayList<EntityDelta.ValuesDelta> r25 = r18;
        String r24 = r117.getAsString(r7);
        r7 = r7;
        String r26 = r117.getAsString(r6);
        r6 = r6;
        if (this.mAccountTypeManager.getAccountType(r24, r26).areContactsWritable() == false) goto L18;
        String r27 = r117.getAsString("account_name");
        long r118 = r117.getAsLong("_id").longValue();
        if (r27 != null) goto L22;
        r27 = "default";
    L22:
        if (r24 != null) goto L24;
        r24 = ContactsUtils.LOCAL_ACCOUNT_TYPE;
    L24:
        r3.put(Long.valueOf(r118), new AccountWithDataSet(r27, r24, r26));
        if (r118 != r8) goto L30;
        if (r116.hasMimeEntries("vnd.android.cursor.item/name") == false) goto L30;
        r21 = r116.getMimeEntries("vnd.android.cursor.item/name").get(0);
    L30:
        if (r116.hasMimeEntries("vnd.android.cursor.item/photo") == false) goto L33;
        r9.addAll(r116.getMimeEntries("vnd.android.cursor.item/photo"));
    L33:
        if (r116.hasMimeEntries("vnd.android.cursor.item/phone_v2") == false) goto L36;
        r11.addAll(r116.getMimeEntries("vnd.android.cursor.item/phone_v2"));
    L36:
        if (r116.hasMimeEntries("vnd.android.cursor.item/email_v2") == false) goto L39;
        r12.addAll(r116.getMimeEntries("vnd.android.cursor.item/email_v2"));
    L39:
        if (r116.hasMimeEntries("vnd.android.cursor.item/nickname") == false) goto L42;
        r15.addAll(r116.getMimeEntries("vnd.android.cursor.item/nickname"));
    L42:
        if (r116.hasMimeEntries("vnd.android.cursor.item/organization") == false) goto L45;
        r10.addAll(r116.getMimeEntries("vnd.android.cursor.item/organization"));
    L45:
        if (r116.hasMimeEntries("vnd.android.cursor.item/note") == false) goto L47;
        ArrayList<EntityDelta.ValuesDelta> r28 = r25;
        r28.addAll(r116.getMimeEntries("vnd.android.cursor.item/note"));
    L49:
        if (r116.hasMimeEntries("vnd.android.cursor.item/im") == false) goto L51;
        ArrayList<EntityDelta.ValuesDelta> r30 = r20;
        r30.addAll(r116.getMimeEntries("vnd.android.cursor.item/im"));
    L53:
        if (r116.hasMimeEntries("vnd.android.cursor.item/group_membership") == false) goto L55;
        ArrayList<EntityDelta.ValuesDelta> r119 = r23;
        r119.addAll(r116.getMimeEntries("vnd.android.cursor.item/group_membership"));
    L57:
        if (r116.hasMimeEntries("vnd.android.cursor.item/sip_address") == false) goto L59;
        ArrayList<EntityDelta.ValuesDelta> r120 = r22;
        r120.addAll(r116.getMimeEntries("vnd.android.cursor.item/sip_address"));
    L61:
        if (r116.hasMimeEntries("vnd.android.cursor.item/website") == false) goto L63;
        ArrayList<EntityDelta.ValuesDelta> r121 = r113;
        r121.addAll(r116.getMimeEntries("vnd.android.cursor.item/website"));
    L65:
        if (r116.hasMimeEntries("vnd.android.cursor.item/contact_event") == false) goto L67;
        ArrayList<EntityDelta.ValuesDelta> r31 = r114;
        r31.addAll(r116.getMimeEntries("vnd.android.cursor.item/contact_event"));
    L69:
        if (r116.hasMimeEntries("vnd.android.cursor.item/relation") == false) goto L71;
        ArrayList<EntityDelta.ValuesDelta> r32 = r111;
        r32.addAll(r116.getMimeEntries("vnd.android.cursor.item/relation"));
    L73:
        if (r116.hasMimeEntries("vnd.android.cursor.item/postal-address_v2") == false) goto L75;
        Collection<? extends EntityDelta.ValuesDelta> r33 = r116.getMimeEntries("vnd.android.cursor.item/postal-address_v2");
        ArrayList<EntityDelta.ValuesDelta> r122 = r19;
        r122.addAll(r33);
    L76:
        r114 = r31;
        r111 = r32;
        r18 = r28;
        r19 = r122;
        r113 = r121;
        r8 = r8;
        r112 = r120;
        r16 = r119;
        r14 = r30;
        goto L14
    L75:
        r122 = r19;
        goto L76
    L71:
        r32 = r111;
        goto L73
    L67:
        r31 = r114;
        goto L69
    L63:
        r121 = r113;
        goto L65
    L59:
        r120 = r22;
        goto L61
    L55:
        r119 = r23;
        goto L57
    L51:
        r30 = r20;
        goto L53
    L47:
        r28 = r25;
        goto L49
    L18:
        r14 = r20;
        r112 = r22;
        r16 = r23;
        r18 = r25;
        goto L14
    L77:
        ArrayList<EntityDelta.ValuesDelta> r34 = r18;
        String r210 = r7;
        ArrayList<EntityDelta.ValuesDelta> r35 = r14;
        ArrayList<EntityDelta.ValuesDelta> r123 = r19;
        ArrayList<EntityDelta.ValuesDelta> r36 = r111;
        Collapser.collapseList(r11);
        Collapser.collapseList(r12);
        Collapser.collapseList(r123);
        Collapser.collapseList(r35);
        Collapser.collapseList(r15);
        Collapser.collapseList(r23);
        Collapser.collapseList(r36);
        Collapser.collapseList(r113);
        Collapser.collapseList(r22);
        Collapser.collapseList(r114);
        EntityDelta.ValuesDelta r37 = this.mState.get(0).getValues();
        if (r37 != null) goto L80;
        long r211 = -1;
    L81:
        ContentValues r38 = new ContentValues();
        r38.put("_id", -115L);
        r38.put("account_name", com.android.contacts.util.Constants.LOCAL_MIXED_ACCOUNT_NAME);
        r38.put(r210, com.android.contacts.util.Constants.LOCAL_MIXED_ACCOUNT_TYPE);
        r38.put("contact_id", Long.valueOf(r211));
        EntityDelta r39 = new EntityDelta(EntityDelta.ValuesDelta.fromBefore(r38));
        r39.addRefRawContacts(r3);
        EntityDelta.ValuesDelta r40 = r21;
        if (r40 == null) goto L84;
        r39.addEntry(r40);
    L84:
        EntityDelta.ValuesDelta r41 = getPhotoValuesDelta(r9, r29.getPhotoId());
        if (r41 == null) goto L87;
        r39.addEntry(r41);
    L87:
        EntityDelta.ValuesDelta r42 = getOrganizationValuesDelta(r10);
        if (r42 == null) goto L90;
        r39.addEntry(r42);
    L90:
        EntityDelta.ValuesDelta r43 = getNoteValuesDelta(r34);
        if (r43 == null) goto L93;
        r39.addEntry(r43);
    L93:
        addValuesDelta(r39, r11);
        addValuesDelta(r39, r12);
        addValuesDelta(r39, r123);
        addValuesDelta(r39, r35);
        addValuesDelta(r39, r15);
        addValuesDelta(r39, r23);
        addValuesDelta(r39, r36);
        addValuesDelta(r39, r113);
        addValuesDelta(r39, r22);
        addValuesDelta(r39, r114);
        this.mState.add(0, r39);
        return;
    L80:
        r211 = r37.getAsLong("contact_id").longValue();
        goto L81
    }

    private void addValuesDelta(EntityDelta r2, ArrayList<EntityDelta.ValuesDelta> r3) {
        Iterator<EntityDelta.ValuesDelta> r1 = r3.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        EntityDelta.ValuesDelta r0 = r1.next();
        if (r0 == null) goto L4;
        r2.addEntry(r0);
        goto L4
    L8:
        r3.clear();
    }

    private EntityDelta.ValuesDelta getPhotoValuesDelta(ArrayList<EntityDelta.ValuesDelta> r5, long r6) {
        ArrayList r4 = new ArrayList();
        Iterator<EntityDelta.ValuesDelta> r7 = r5.iterator();
        EntityDelta.ValuesDelta r0 = null;
    L4:
        if (r7.hasNext() == false) goto L9;
        EntityDelta.ValuesDelta r1 = r7.next();
        if (r1.getId().longValue() == r6) goto L7;
        r4.add(r1);
        goto L4
    L7:
        r0 = r1;
        goto L4
    L9:
        if (r0 == null) goto L14;
        Iterator r8 = r4.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r0.addRefValuesDelta((EntityDelta.ValuesDelta) r8.next());
    L14:
        return r0;
    }

    private EntityDelta.ValuesDelta getOrganizationValuesDelta(ArrayList<EntityDelta.ValuesDelta> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == true) goto L14;
        EntityDelta.ValuesDelta r2 = r3.get(0);
        int r0 = 1;
    L8:
        if (r0 >= r3.size()) goto L10;
        r2.addRefValuesDelta(r3.get(r0));
        r0 = r0 + 1;
        goto L8
    L10:
        return r2;
    L14:
        return null;
    }

    private EntityDelta.ValuesDelta getNoteValuesDelta(ArrayList<EntityDelta.ValuesDelta> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == true) goto L14;
        EntityDelta.ValuesDelta r2 = r3.get(0);
        int r0 = 1;
    L8:
        if (r0 >= r3.size()) goto L10;
        r2.addRefValuesDelta(r3.get(r0));
        r0 = r0 + 1;
        goto L8
    L10:
        return r2;
    L14:
        return null;
    }

    public EntityDeltaList getEntityDeltaList() {
        return this.mState;
    }

    public void setIntentExtras(Bundle r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.size() != 0) goto L7;
        return;
    L7:
        if (this.mIntentExtras == r6) goto L9;
        this.mIntentExtras = r6;
    L9:
        this.mAddStrangeNumber = r6.getBoolean(EXTRA_ADD_STRANGE_NUMBER);
        if (this.mState.size() <= 1) goto L12;
        Collections.sort(this.mState, this.mNameModifyTimeComparator);
    L12:
        Iterator<EntityDelta> r0 = this.mState.iterator();
    L14:
        if (r0.hasNext() == false) goto L24;
        EntityDelta r1 = r0.next();
        String r2 = r1.getValues().getAsString("account_type");
        String r3 = r1.getValues().getAsString("data_set");
        AccountType r4 = this.mAccountTypeManager.getAccountType(r2, r3);
        if (r4.areContactsWritable() == false) goto L14;
        EntityModifier.parseExtras(this.mContext, r4, r1, r6);
        return;
    }

    private void setIntentExtrasToStateByPosition(Bundle r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.size() == 0) goto L19;
        if (r5 >= 0) goto L7;
        return;
    L7:
        if (this.mState == null) goto L23;
        this.mAddStrangeNumber = r4.getBoolean(EXTRA_ADD_STRANGE_NUMBER);
        if (r5 < this.mState.size()) goto L12;
        return;
    L12:
        EntityDelta r6 = this.mState.get(r5);
        if (r6 == null) goto L21;
        String r0 = r6.getValues().getAsString("account_type");
        String r1 = r6.getValues().getAsString("data_set");
        AccountType r2 = this.mAccountTypeManager.getAccountType(r0, r1);
        if (r2.areContactsWritable() == false) goto L22;
        EntityModifier.parseExtras(this.mContext, r2, r6, r4);
        return;
    L22:
        return;
    L21:
        return;
    L23:
        return;
    }

    private void selectAccountAndCreateContact(boolean r4) {
        AccountWithDataSet r5 = new AccountWithDataSet("default", ContactsUtils.LOCAL_ACCOUNT_TYPE, null);
        this.mEditorUtils.saveDefaultAndAllAccounts(r5);
        createContact(r5);
    }

    private void createContact() {
        List<AccountWithDataSet> r0 = AccountTypeManager.getInstance(this.mContext).getAccounts(true);
        if (r0.isEmpty() == false) goto L6;
        createContact(null);
        return;
    L6:
        createContact(r0.get(0));
    }

    public void createContact(AccountWithDataSet r5) {
        AccountTypeManager r0 = this.mAccountTypeManager;
        if (r5 == null) goto L5;
        String r2 = r5.type;
    L6:
        if (r5 == null) goto L8;
        String r3 = r5.dataSet;
    L9:
        AccountType r1 = r0.getAccountType(r2, r3);
        if (r1.getCreateContactActivityClassName() == null) goto L15;
        Listener r4 = this.mListener;
        if (r4 == null) goto L17;
        if (r5 == null) goto L18;
        r4.onCustomCreateContactActivityRequested(r5, this.mIntentExtras);
        return;
    L18:
        return;
    L17:
        return;
    L15:
        bindEditorsForNewContact(r5, r1, null, null);
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public void createContact(AccountWithDataSet r5, AccountWithDataSet r6) {
        AccountTypeManager r0 = this.mAccountTypeManager;
        String r1 = null;
        if (r5 == null) goto L5;
        String r2 = r5.type;
    L6:
        if (r5 == null) goto L8;
        String r3 = r5.dataSet;
    L9:
        AccountType r4 = r0.getAccountType(r2, r3);
        AccountTypeManager r7 = this.mAccountTypeManager;
        if (r6 == null) goto L12;
        String r8 = r6.type;
    L13:
        if (r6 == null) goto L15;
        r1 = r6.dataSet;
    L15:
        AccountType r9 = r7.getAccountType(r8, r1);
        if (r4.getCreateContactActivityClassName() == null) goto L20;
        clearState();
        Listener r10 = this.mListener;
        if (r10 == null) goto L22;
        r10.onCustomCreateContactActivityRequested(r5, this.mIntentExtras);
        return;
    L22:
        return;
    L20:
        EntityDeltaList r11 = EntityDeltaList.fromSingle(this.mState.get(0));
        clearState();
        bindEditorsForNewContact(r5, r4, r11.get(0), r9);
        return;
    L12:
        r8 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    private void bindEditorsForNewContact(AccountWithDataSet r7, AccountType r8, EntityDelta r9, AccountType r10) {
        this.mStatus = 1;
        ContentValues r1 = new ContentValues();
        if (r7 == null) goto L5;
        r1.put("account_name", r7.name);
        r1.put("account_type", r7.type);
        r1.put("data_set", r7.dataSet);
    L6:
        EntityDelta r11 = new EntityDelta(EntityDelta.ValuesDelta.fromAfter(r1));
        if (r9 != null) goto L9;
        EntityModifier.parseExtras(this.mContext, r8, r11, this.mIntentExtras);
    L10:
        EntityModifier.ensureKindExists(r11, r8, "vnd.android.cursor.item/phone_v2");
        if (this.mNewLocalProfile == true) goto L14;
        EntityModifier.ensureKindExists(r11, r8, "vnd.android.cursor.item/group");
    L14:
        if (this.mNewLocalProfile == false) goto L16;
        r11.setProfileQueryUri();
    L16:
        EntityDeltaList r12 = this.mState;
        if (r12 != null) goto L19;
        this.mState = EntityDeltaList.fromSingle(r11);
    L20:
        this.mRequestFocus = true;
        bindEditors();
        return;
    L19:
        r12.add(r11);
        goto L20
    L9:
        EntityModifier.migrateStateForNewContact(this.mContext, r9, r11, r10, r8);
        goto L10
    L5:
        r1.putNull("account_name");
        r1.putNull("account_type");
        r1.putNull("data_set");
        goto L6
    }

    private void bindEditors() {
        this.mContent.removeAllViews();
        if (this.mState.size() != 1) goto L10;
        if (this.mListener == null) goto L7;
        bindAccountTitle();
    L8:
        bindEditorByEntityDelta(this.mState.get(0));
        return;
    L7:
        this.mDelayUpdateTitle = true;
        goto L8
    L10:
        if (getActivity() == null) goto L14;
        new Thread(new LoadRawContactsNameRunnable(this, getActivity())).start();
        return;
    }

    private void bindAccountTitle() {
        EntityDelta.ValuesDelta r0 = this.mState.get(0).getValues();
        String r2 = r0.getAsString("account_type");
        String r3 = r0.getAsString("account_name");
        String r1 = r0.getAsString("data_set");
        if (isEditingUserProfile() == false) goto L6;
        this.mListener.bindAccountTitleWithOutAccount(this.mIsInsert);
        return;
    L6:
        if (r2 != null) goto L18;
        boolean r4 = true;
        if (r3 != null) goto L10;
        boolean r5 = true;
    L11:
        if (r1 == null) goto L15;
        r4 = false;
    L15:
        if ((r4 & r5) == false) goto L18;
        this.mListener.bindAccountTitleWithOutAccount(this.mIsInsert);
        return;
    L10:
        r5 = false;
    L18:
        if (this.mIsInsert == false) goto L20;
        this.mListener.bindAccountTitleByInsertContact(new AccountWithDataSet(r3, r2, r1), this.mAccountTypeManager.getAccountType(r2, r1));
        return;
    L20:
        ArrayList<AccountWithDataSet> r6 = new ArrayList();
        r6.add(new AccountWithDataSet(r3, r2, r1));
        this.mListener.bindAccountTitleByEntityDeltas(r6, 0);
    }

    public void bindEditorByEntityDelta(int r2) {
        this.mContent.removeAllViews();
        this.mRequestFocus = true;
        setIntentExtrasToStateByPosition(this.mIntentExtras, r2);
        bindEditorByEntityDelta(this.mState.get(r2));
    }

    private void bindEditorByEntityDelta(EntityDelta r19) {
        EntityDelta.ValuesDelta r1 = r19.getValues();
        LayoutInflater r2 = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        String r4 = r1.getAsString("account_type");
        String r6 = r1.getAsString("account_name");
        if (this.mIsInsert == false) goto L6;
        r6 = "default";
        r4 = ContactsUtils.LOCAL_ACCOUNT_TYPE;
    L6:
        if ("com.android.sim".equals(r4) == false) goto L12;
        if (MoreContactUtils.canSaveEmail(MoreContactUtils.getSubscription(r4, r6)) == false) goto L10;
        String r8 = "USIM";
    L15:
        r1.put("account_type", r4);
        r1.put("account_name", r6);
        r1.put("data_set", r8);
        AccountType r3 = this.mAccountTypeManager.getAccountType(r4, r8);
        this.mAType = r3;
        long r9 = r1.getAsLong("_id").longValue();
        if (r3.areContactsWritable() == true) goto L29;
        BaseRawContactEditorView r5 = (BaseRawContactEditorView) r2.inflate(R.layout.raw_contact_readonly_editor_view, this.mContent, false);
        TextView r7 = (TextView) r5.findViewById(R.id.read_only_notice);
        View r10 = r5.findViewById(R.id.read_only_divider);
        String r12 = getString(R.string.read_only_description, new Object[]{(String) r3.getDisplayLabel(this.mContext)});
        if (com.android.contacts.util.Constants.WEIXIN_PACKAGE_NAME.equals(r3.resPackageName) == false) goto L21;
        Drawable r11 = getActivity().getResources().getDrawable(R.drawable.weixin_icon);
        r11.setBounds(0, 0, r11.getIntrinsicWidth(), r11.getIntrinsicHeight());
        r7.setCompoundDrawables(r11, null, null, null);
        r7.setText(r12);
    L27:
        ((RawContactReadOnlyEditorView) r5).setListener(this);
        hideSoftKeyboard();
        BaseRawContactEditorView r13 = r5;
    L32:
        boolean r14 = r13 instanceof RawContactEditorView;
        if (r14 == false) goto L35;
        ((RawContactEditorView) r13).setExternalEditorListener(this.mDoneButtonStateListener);
    L35:
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(r13);
        r13.setEnabled(this.mEnabled);
        if (this.mIsInsert == false) goto L38;
    L39:
        OCardListItem r15 = (OCardListItem) r13.findViewById(R.id.Button_remove_contact);
        if (r15 == null) goto L42;
        r15.setVisibility(8);
        ((OCardListItem) r13.findViewById(R.id.add_field_container)).setCardPosition(0);
    L42:
        this.mContent.addView(r13);
        if (com.android.contacts.util.Constants.LOCAL_MIXED_ACCOUNT_TYPE.equals(r4) == false) goto L46;
        if (r14 == false) goto L46;
        ((RawContactEditorView) r13).setState(r19, r3, getMixedAccountTypeList(), this.mViewIdGenerator, isEditingUserProfile());
    L47:
        bindPhotoHandler(r13, r3, this.mState);
        Bitmap r16 = updatedBitmapForRawContact(r9);
        if (r16 == null) goto L51;
        r13.setPhotoBitmap(r16);
    L51:
        if (r14 == false) goto L79;
        RawContactEditorView r17 = (RawContactEditorView) r13;
        this.mRawContactEditor = r17;
        this.mAccountType = r4;
        this.mAccountName = r6;
        this.mDataSet = r8;
        r17.setContactEditorFragment(this);
        Editor.EditorListener r18 = new AnonymousClass6(this);
        this.mRawContactEditor.setListener(this.mRawContactEditorLisnter);
        TextFieldsEditorView r20 = this.mRawContactEditor.getNameEditor();
        this.mNameEditor = r20;
        if (r20 == null) goto L63;
        if (this.mRequestFocus == false) goto L63;
        if (this.mAddStrangeNumber == true) goto L63;
        r20.requestFocusForFirstEditField();
        if ("android.intent.action.INSERT".equals(this.mAction) == false) goto L61;
        showSoftInput(this.mNameEditor);
    L61:
        this.mRequestFocus = false;
    L63:
        if (getResources().getBoolean(R.bool.support_add_contact_by_qrcode) == true) goto L65;
    L71:
        TextFieldsEditorView r21 = this.mNameEditor;
        if (r21 == null) goto L74;
        r21.setEditorListener(r18);
    L74:
        this.mRawContactEditor.setAutoAddToDefaultGroup(this.mAutoAddToDefaultGroup);
        if (r9 != this.mAggregationSuggestionsRawContactId) goto L77;
        acquireAggregationSuggestions(this.mRawContactEditor);
    L77:
        this.mRingtoneTitle = this.mRawContactEditor.getRingtoneTextView();
        setRingtoneTitle(this.mCustomRingtone);
    L89:
        this.mRequestFocus = false;
        if (isEditingUserProfile() == true) goto L92;
        bindGroupMetaData();
    L92:
        this.mContent.setVisibility(0);
        updateDoneButtonEnabled();
        LinearLayout r22 = this.mContent;
        if (r22 == null) goto L96;
        r22.post(new AnonymousClass7(this));
        return;
    L96:
        return;
    L65:
        if ("android.intent.action.INSERT".equals(this.mAction) == false) goto L71;
        Bundle r23 = this.mIntentExtras;
        if (r23 == null) goto L71;
        if (r23.getBoolean("scan_barcode", false) == false) goto L71;
        setupBarcodeForNameEditor();
        goto L71
    L79:
        if ((r13 instanceof SimRawContactEditorView) == false) goto L89;
        TextFieldsEditorView r24 = ((SimRawContactEditorView) r13).getNameEditor();
        if (r24 == null) goto L89;
        if (this.mRequestFocus == false) goto L89;
        if (this.mAddStrangeNumber == true) goto L89;
        r24.requestFocusForFirstEditField();
        if ("android.intent.action.INSERT".equals(this.mAction) == false) goto L89;
        showSoftInput(r24);
    L46:
        r13.setState(r19, r3, this.mViewIdGenerator, isEditingUserProfile());
        goto L47
    L38:
        if (this.mNewLocalProfile == false) goto L42;
    L21:
        if ("com.tencent.mobileqq".equals(r3.resPackageName) == false) goto L24;
        Drawable r25 = getActivity().getResources().getDrawable(R.drawable.qq_icon);
        r25.setBounds(0, 0, r25.getIntrinsicWidth(), r25.getIntrinsicHeight());
        r7.setCompoundDrawables(r25, null, null, null);
        r7.setText(r12);
        goto L27
    L24:
        if ("com.kingsoft.email".equals(r3.resPackageName) == false) goto L26;
        Drawable r26 = getActivity().getResources().getDrawable(R.drawable.wps_icon);
        r26.setBounds(0, 0, r26.getIntrinsicWidth(), r26.getIntrinsicHeight());
        r7.setCompoundDrawables(r26, null, null, null);
        r7.setText(r12);
        goto L27
    L26:
        r10.setVisibility(4);
        r7.setVisibility(4);
        goto L27
    L29:
        if ("com.android.sim".equals(r3.accountType) == false) goto L31;
        SimRawContactEditorView r27 = (SimRawContactEditorView) r2.inflate(R.layout.sim_raw_contact_editor_view, this.mContent, false);
        r27.setListener(this.mRawContactEditorLisnter);
        r13 = r27;
        goto L32
    L31:
        r13 = (RawContactEditorView) r2.inflate(R.layout.raw_contact_editor_view, this.mContent, false);
        goto L32
    L10:
        r8 = SimContactsConstants.SIM_NAME;
        goto L15
    L12:
        if (ContactsUtils.LOCAL_ACCOUNT_TYPE.equals(r4) == false) goto L14;
        r8 = null;
        goto L15
    L14:
        r8 = r1.getAsString("data_set");
        goto L15
    }

    private void updateData(String r1, EntityDelta r2, DataKind r3, String r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        ArrayList<EntityDelta.ValuesDelta> r0 = r2.getMimeEntries(r1);
        if (r0 == null) goto L8;
        r0.get(0).put(r4, r5);
        return;
    L8:
        EntityModifier.insertChild(r2, r3).put(r4, r5);
    }

    private boolean isContainDataKind(ArrayList<DataKind> r3, DataKind r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<DataKind> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L15;
        if (r5.next().mimeType.equals(r4.mimeType) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private List<AccountType> getMixedAccountTypeList() {
        if (this.mState != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<EntityDelta> r1 = this.mState.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        EntityDelta.ValuesDelta r2 = r1.next().getValues();
        String r3 = r2.getAsString("account_type");
        String r4 = r2.getAsString("data_set");
        if (com.android.contacts.util.Constants.LOCAL_MIXED_ACCOUNT_TYPE.equals(r3) == true) goto L8;
        r0.add(this.mAccountTypeManager.getAccountType(r3, r4));
        goto L8
    L12:
        return r0;
    }

    private void bindGroupMetaData() {
        if (this.mGroupMetaData != null) goto L5;
        return;
    L5:
        int r0 = this.mContent.getChildCount();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        BaseRawContactEditorView r2 = (BaseRawContactEditorView) this.mContent.getChildAt(r1);
        if (r2 == null) goto L10;
        r2.setGroupMetaData(this.mGroupMetaData);
    L10:
        r1 = r1 + 1;
        goto L6
    }

    private void saveDefaultAccountIfNecessary() {
        if (this.mIsInsert == false) goto L5;
    L9:
        EntityDelta.ValuesDelta r0 = this.mState.get(0).getValues();
        String r1 = r0.getAsString("account_name");
        String r2 = r0.getAsString("account_type");
        String r3 = r0.getAsString("data_set");
        if (r1 == null) goto L14;
        if (r2 == null) goto L14;
        AccountWithDataSet r4 = new AccountWithDataSet(r1, r2, r3);
    L15:
        this.mEditorUtils.saveDefaultAndAllAccounts(r4);
        return;
    L14:
        r4 = null;
        goto L15
    L5:
        if (this.mState.size() != 1) goto L9;
        if (isEditingUserProfile() == true) goto L9;
    }

    private void disableAccountSwitcher(BaseRawContactEditorView r1) {
        View r0 = r1.findViewById(R.id.account);
        r0.setBackgroundDrawable(null);
        r0.setEnabled(false);
    }

    private boolean doSplitContactAction() {
        if (hasValidState() == true) goto L5;
        return false;
    L5:
        SplitContactConfirmationDialogFragment r0 = new SplitContactConfirmationDialogFragment();
        r0.setTargetFragment(this, 0);
        r0.show(getParentFragmentManager(), SplitContactConfirmationDialogFragment.TAG);
        return true;
    }

    private boolean doJoinContactAction() {
        if (hasValidState() == true) goto L6;
        return false;
    L6:
        if (this.mState.size() != 1) goto L14;
        if (this.mState.get(0).isContactInsert() == false) goto L14;
        if (hasChanges() == true) goto L14;
        Toast.makeText(getActivity(), R.string.toast_join_with_empty_contact, 1).show();
        return true;
    L14:
        return save(3);
    }

    private boolean hasValidState() {
        EntityDeltaList r0 = this.mState;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.size() <= 0) goto L7;
        return true;
    }

    public static String getPhotoFileName(Context r3) {
        File r0 = new File(r3.getExternalCacheDir(), ".nomedia");
        if (r0.exists() == true) goto L9;
        r0.createNewFile();     // Catch: IOException -> L6
    L6:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Can't create the nomedia, e:" + e);
    L9:
        return r3.getExternalCacheDir() + LibrarianImpl.Constants.SEPARATOR + TEMP_PHOTO_NAME;
    }

    public static Intent getTakePickIntent(File r3) {
        Intent r0 = new Intent("android.media.action.IMAGE_CAPTURE", null);
        r0.putExtra("output", Uri.fromFile(r3));
        r0.setPackage(com.android.contacts.util.Constants.PACKAGE_NAME_GALLERY);
        return r0;
    }

    protected void doCropPhoto(File r6) {
        String[] r4 = (String[]) null;     // Catch: Exception -> L5
        MediaScannerConnection.scanFile(this.mContext, new String[]{r6.getAbsolutePath()}, null, null);     // Catch: Exception -> L5
        Intent r7 = ContactsIntentUtils.getCropImageIntent(Uri.fromFile(r6));     // Catch: Exception -> L5
        this.mStatus = 4;     // Catch: Exception -> L5
        startActivityForResult(r7, 2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot crop image", e);
        Toast.makeText(this.mContext, R.string.photoPickerNotFoundText, 1).show();
    }

    public boolean save(int r13) {
        if (getActivity() != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "host activity was destroyed, just return");
        return false;
    L7:
        if (hasValidState() == true) goto L9;
    L42:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "state is valid: " + this.mStatus);
        return false;
    L9:
        if (this.mStatus != 1) goto L42;
        if (r13 == 0) goto L14;
        if (r13 == 2) goto L14;
    L15:
        this.mStatus = 2;
        if (hasChanges() == true) goto L23;
        Uri r0 = this.mLookupUri;
        if (r0 == null) goto L20;
        boolean r4 = true;
    L21:
        onSaveCompleted(false, r13, r4, r0);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "has no change, just return");
        return true;
    L20:
        r4 = false;
        goto L21
    L23:
        NewContactsTraceLog.INSTANCE.onNewContactsPageLog("Contact Editor saveMode=" + r13);
        saveDefaultAccountIfNecessary();
        if (this.mIsInsert == false) goto L27;
        this.mState.get(0).addEntry(EntityDelta.ValuesDelta.fromAfter(getAddTimeValues()));
    L27:
        if (this.mIsInsert == true) goto L29;
    L36:
        Intent r14 = ContactSaveService.createSaveContactIntent(getActivity(), this.mState, "saveMode", r13, isEditingUserProfile(), getActivity().getClass(), ContactEditorActivity.ACTION_SAVE_COMPLETED, this.mUpdatedPhotos);
    L37:
        getActivity().startService(r14);
        setEnabled(false);
        AggregationSuggestionEngine r15 = this.mAggregationSuggestionEngine;
        if (r15 == null) goto L40;
        r15.quit();
    L40:
        this.mUpdatedPhotos = new Bundle();
        return true;
    L29:
        if (isEditSimContacts() == true) goto L36;
        if (ContactEditorCache.getInstance().getResult() == null) goto L36;
        if (ContactsUtils.DEBUG == false) goto L35;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "save dummy contacts...");
    L35:
        r14 = ContactSaveService.createSaveContactIntent(getActivity(), this.mState, "saveMode", r13, isEditingUserProfile(), null, null, this.mUpdatedPhotos);
        onSaveCompleted(true, 0, true, null);
    L14:
        getLoaderManager().destroyLoader(1);
        goto L15
    }

    private ContentValues getAddTimeValues() {
        ContentValues r0 = new ContentValues();
        r0.put("data1", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        r0.put(DBHelper.COL_DATA2, "0");
        r0.put(DBHelper.COL_DATA3, "added time");
        if (this.mFromBusinessCard == false) goto L5;
        r0.put("data4", 1);
    L5:
        r0.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, String.valueOf(System.currentTimeMillis()));
        r0.put("is_read_only", 0);
        r0.put("is_primary", 0);
        r0.put("is_super_primary", 0);
        r0.put("data_version", 0);
        r0.put("mimetype", "vnd.android.cursor.item/added_time");
        return r0;
    }

    private boolean revert() {
        if (this.mState != null) goto L5;
    L8:
        doRevertAction();
        return true;
    L5:
        if (hasChanges() == false) goto L8;
        showSheet();
        return true;
    }

    private void showSheet() {
        OInsetSheet r0 = new OInsetSheet(this.mContext);
        r0.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        r0.setHeaderView(genHeaderView(r0));
        r0.setContainerView(genContentView());
        r0.setFooterView(null);
        r0.show();
    }

    private View genHeaderView(final OInsetSheet r4) {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(this.mContext);
        r0.setShowLeftBack(false);
        r0.setTitleText(getString(R.string.cancel_confirmation_dialog_message));
        OButton r1 = r0.createNeutralButton(this.mContext, r0.mRightContainer);
        r1.setButtonSourceBitmap(R.drawable.o_ic_close);
        r1.setOnClickListener(new AnonymousClass8(this, r4));
        return r0;
    }

    private View genContentView() {
        LinearLayout r0 = new LinearLayout(this.mContext);
        r0.setOrientation(1);
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(this.mContext, 5.0d));
        OButton r1 = (OButton) LayoutInflater.from(this.mContext).inflate(R.layout.sheet_button_center_red, null);
        r1.setText(R.string.common_ok);
        r1.setOnClickListener(new AnonymousClass9(this));
        r1.setWidth(ContactsUtils.dipTopx(this.mContext, 296.0d));
        r1.setHeight(ContactsUtils.dipTopx(this.mContext, 56.0d));
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        r4.gravity = 17;
        r4.bottomMargin = ContactsUtils.dipTopx(this.mContext, 5.0d);
        r0.addView(r1, r4);
        return r0;
    }

    public boolean hasChanges() {
        EntityDeltaList r0 = this.mState;
        if (r0 != null) goto L7;
        return false;
    L7:
        return EntityModifier.hasChanges(r0, this.mAccountTypeManager);
    }

    public boolean hasRingtoneChanged() {
        return this.mRingtoneChanged;
    }

    private void doRevertAction() {
        this.mStatus = 3;
        Listener r1 = this.mListener;
        if (r1 == null) goto L6;
        r1.onReverted();
        return;
    }

    public void clearState() {
        EntityDeltaList r0 = this.mState;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public void revertChanges(int r4) {
        EntityDelta r5 = this.mState.get(r4);
        EntityDelta.ValuesDelta r0 = r5.getValues();
        String r1 = r0.getAsString("account_type");
        String r2 = r0.getAsString("data_set");
        EntityModifier.revertChanges(r5, this.mAccountTypeManager.getAccountType(r1, r2));
    }

    private EntityDelta getChangteDeltaList(EntityDeltaList r5) {
        Iterator<EntityDelta> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        EntityDelta r0 = r6.next();
        EntityDelta.ValuesDelta r1 = r0.getValues();
        String r2 = r1.getAsString("account_type");
        String r3 = r1.getAsString("data_set");
        if (EntityModifier.hasChanges(r0, this.mAccountTypeManager.getAccountType(r2, r3)) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    public void doSaveAction() {
        NewContactsTraceLog.INSTANCE.onNewContactsPageLog("Contact Editor doSaveAction");
        EntityDeltaList r1 = this.mState;
        if (r1 != null) goto L5;
        EntityDelta r2 = null;
    L6:
        if (r2 == null) goto L48;
        ArrayList<EntityDelta.ValuesDelta> r3 = r2.getMimeEntries("vnd.android.cursor.item/phone_v2");
        ArrayList<EntityDelta.ValuesDelta> r4 = new ArrayList();
        ArrayList<EntityDelta.ValuesDelta> r5 = new ArrayList();
        boolean r6 = false;
        if (r3 == null) goto L37;
        Uri r7 = ContactsUtils.getEmergencyContactPhoneUri(this.mContext);
        int r8 = 0;
        boolean r9 = false;
        boolean r10 = false;
        boolean r11 = false;
    L11:
        if (r8 >= r3.size()) goto L36;
        EntityDelta.ValuesDelta r12 = r3.get(r8);
        if (TextUtils.isEmpty(r12.getCompleteValues().getAsString("data1")) == true) goto L35;
        if (r12.isDelete() == false) goto L21;
        if (r7 == null) goto L21;
        if (ContentUris.parseId(r7) != r12.getId().longValue()) goto L21;
        r11 = true;
    L23:
        if (r12.getCompleteValues().containsKey(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG) == true) goto L25;
    L27:
        boolean r13 = false;
    L29:
        if (r12.isDelete() == false) goto L32;
        if (r13 == false) goto L35;
        r9 = true;
        goto L35
    L32:
        if (r13 == true) goto L35;
        r4.add(r3.get(r8));
        r10 = true;
        goto L35
    L25:
        if (r12.getCompleteValues().getAsString(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG).equals("1") == false) goto L27;
        r13 = true;
    L21:
        r5.add(r12);
    L35:
        r8 = r8 + 1;
        goto L11
    L36:
        r6 = r9;
    L39:
        if (r4.size() <= 0) goto L43;
        if (r6 == false) goto L43;
        if (r10 == false) goto L43;
        saveContactWithFavConfirm(r4);
        return;
    L43:
        if (r11 == true) goto L45;
    L47:
        saveContact();
        return;
    L45:
        if (r5.size() <= 0) goto L47;
        saveContactWithEmergencyConfirm(r5);
        return;
    L37:
        r10 = false;
        r11 = false;
        goto L39
    L48:
        saveContact();
        return;
    L5:
        r2 = getChangteDeltaList(r1);
        goto L6
    }

    private void saveContactWithFavConfirm(final ArrayList<EntityDelta.ValuesDelta> r8) {
        ArrayList<String> r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        final int r2 = 0;
    L4:
        if (r2 >= r8.size()) goto L10;
        EntityDelta.ValuesDelta r3 = r8.get(r2);
        StringBuilder r4 = new StringBuilder().append(r3.getCompleteValues().getAsString("data1"));
        if (r3.isInsert() == false) goto L8;
        String r5 = getResources().getString(R.string.dialog_favorite_change_item_info);
    L9:
        r0.add(r4.append(r5).toString());
        r1.add(new AnonymousClass10(this, r2, r8));
        r2 = r2 + 1;
        goto L4
    L8:
        r5 = "";
        goto L9
    L10:
        OInsetSheet r9 = new OInsetSheet(this.mContext);
        r9.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        r9.setHeaderView(getStartHeaderView(r9));
        r9.setContainerView(getStartContentView(r0, r1));
        r9.setFooterView(null);
        r9.show();
    }

    private View getStartContentView(ArrayList<String> r11, List<View.OnClickListener> r12) {
        LinearLayout r0 = new LinearLayout(this.mContext);
        r0.setOrientation(1);
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(this.mContext, 5.0d));
        int r1 = Math.min(r11.size(), r12.size());
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L5;
        OButton r6 = (OButton) LayoutInflater.from(this.mContext).inflate(R.layout.sheet_button_left_center_black, null);
        r6.setText(r11.get(r5));
        r6.setOnClickListener(r12.get(r5));
        r6.setWidth(ContactsUtils.dipTopx(this.mContext, 296.0d));
        r6.setHeight(ContactsUtils.dipTopx(this.mContext, 56.0d));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        r7.gravity = 17;
        r7.bottomMargin = ContactsUtils.dipTopx(this.mContext, 5.0d);
        r0.addView(r6, r7);
        r5 = r5 + 1;
        goto L3
    L5:
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(this.mContext, 15.0d));
        return r0;
    }

    private View getStartHeaderView(final OInsetSheet r4) {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(this.mContext);
        r0.setShowLeftBack(false);
        r0.setTitleText(getString(R.string.dialog_favorite_change_title));
        OButton r1 = r0.createNeutralButton(this.mContext, r0.mRightContainer);
        r1.setButtonSourceBitmap(R.drawable.o_ic_close);
        r1.setOnClickListener(new AnonymousClass11(this, r4));
        return r0;
    }

    private void saveContactWithEmergencyConfirm(final ArrayList<EntityDelta.ValuesDelta> r8) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        final int r2 = 0;
    L4:
        if (r2 >= r8.size()) goto L10;
        EntityDelta.ValuesDelta r3 = r8.get(r2);
        StringBuilder r4 = new StringBuilder().append(r3.getCompleteValues().getAsString("data1"));
        if (r3.isInsert() == false) goto L8;
        String r5 = getResources().getString(R.string.dialog_favorite_change_item_info);
    L9:
        r0.add(r4.append(r5).toString());
        r1.add(new AnonymousClass12(this, r2, r8));
        r2 = r2 + 1;
        goto L4
    L8:
        r5 = "";
        goto L9
    L10:
        MenuDialogListAdapter r9 = new MenuDialogListAdapter(getActivity(), r0, r1);
        MenuDialog r6 = new MenuDialog(getActivity());
        r6.setTitle(new String(getResources().getString(R.string.dialog_emergency_contact_change_title)));
        r6.setAdapter(r9);
        DialogInterface.OnCancelListener r10 = new AnonymousClass13(this);
        r6.setNegativeButton(R.string.dialog_favorite_change_done_button, new AnonymousClass14(this));
        r6.setOnCancelListener(r10);
        r6.setCanceledOnTouchOutside(true);
        r6.show();
    }

    private void saveContact() {
        save(0);
    }

    public void onJoinCompleted(Uri r4) {
        if (r4 == null) goto L5;
        boolean r2 = true;
    L6:
        onSaveCompleted(false, 1, r2, r4);
        return;
    L5:
        r2 = false;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onSaveCompleted(boolean r5, int r6, boolean r7, Uri r8) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onSaveCompleted(" + r6 + ", " + r8);
    L6:
        if (r5 == true) goto L8;
    L14:
        Intent r2 = null;
        String r3 = null;
        r2 = null;
        if (r6 == 0) goto L35;
        if (r6 != 1) goto L18;
    L29:
        if (r7 == false) goto L62;
        if (r8 == null) goto L63;
        if (r6 != 3) goto L33;
        showJoinAggregateActivity(r8);
    L33:
        this.mState = null;
        load("android.intent.action.EDIT", r8, null);
        this.mStatus = 0;
        getLoaderManager().restartLoader(1, null, this.mDataLoaderListener);
        return;
    L63:
        return;
    L62:
        return;
    L18:
        if (r6 == 2) goto L23;
        if (r6 == 3) goto L29;
        if (r6 == 4) goto L35;
        return;
    L23:
        this.mStatus = 3;
        Listener r4 = this.mListener;
        if (r4 == null) goto L27;
        r4.onContactSplit(r8);
        return;
    L27:
        if (ContactsUtils.DEBUG == false) goto L60;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "No listener registered, can not call onSplitFinished");
        return;
    L60:
        return;
    L35:
        if (r7 == false) goto L51;
        if (r8 == null) goto L51;
        Uri r9 = this.mLookupUri;
        if (r9 == null) goto L41;
        r3 = r9.getAuthority();
    L41:
        Intent r10 = new Intent();
        r10.setPackage("com.android.contacts");
        r10.setAction("android.intent.action.VIEW");
        if (ContractKt.PARAM_ACTION_DOMAIN_CONTACTS.equals(r3) == false) goto L46;
        Uri r11 = ContactsContract.Contacts.lookupContact(this.mContext.getContentResolver(), r8);
        if (r11 == null) goto L47;
        r10.setData(ContentUris.withAppendedId(Uri.parse("content://contacts/people"), ContentUris.parseId(r11)));
    L47:
        this.mLookupUri = r8;
        handleRingtonePicked(this.mCustomRingtone);
        if (TextUtils.isEmpty(this.mNewEmergencyNumber) == true) goto L50;
        processEmergencyNumber();
    L50:
        r2 = r10;
    L55:
        this.mStatus = 3;
        Listener r12 = this.mListener;
        if (r12 == null) goto L65;
        r12.onSaveFinished(r2);
        return;
    L65:
        return;
    L46:
        r10.setData(r8);
    L51:
        if (r7 == false) goto L55;
        if (ContactEditorCache.getInstance().getResult() == null) goto L55;
        r2 = new Intent();
        r2.setPackage("com.android.contacts");
        r2.setAction("android.intent.action.VIEW");
        r2.setData(ContactsContract.Contacts.getLookupUri(0, com.android.contacts.util.Constants.DUMMY_LOOKUP_KEY_PREFIX + System.currentTimeMillis()));
        ContactEditorCache.getInstance().setRingtone(this.mCustomRingtone);
        goto L55
    L8:
        if (getActivity() == null) goto L14;
        if (getActivity().isFinishing() == true) goto L14;
        if (r7 == true) goto L14;
        Toast.makeText(this.mContext, R.string.contactSavedErrorToast, 1).show();
        goto L14
    }

    private void showJoinAggregateActivity(Uri r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (isAdded() == false) goto L9;
        this.mContactIdForJoin = ContentUris.parseId(r4);
        this.mContactWritableForJoin = isContactWritable();
        Intent r5 = new Intent("com.android.contacts.action.JOIN_CONTACT");
        r5.putExtra("com.android.contacts.action.CONTACT_ID", this.mContactIdForJoin);
        startActivityForResult(r5, 0);
        return;
    }

    private void joinAggregate(long r9) {
        Intent r10 = ContactSaveService.createJoinContactsIntent(this.mContext, this.mContactIdForJoin, r9, this.mContactWritableForJoin, ContactEditorActivity.class, ContactEditorActivity.ACTION_JOIN_COMPLETED);
        this.mContext.startService(r10);
    }

    private boolean isContactWritable() {
        int r0 = this.mState.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        EntityDelta.ValuesDelta r3 = this.mState.get(r2).getValues();
        if (this.mAccountTypeManager.getAccountType(r3.getAsString("account_type"), r3.getAsString("data_set")).areContactsWritable() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean isEditSimContacts() {
        EntityDeltaList r0 = this.mState;
        if (r0 != null) goto L5;
        return false;
    L5:
        int r1 = r0.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L14;
        EntityDelta.ValuesDelta r3 = this.mState.get(r2).getValues();
        if (MoreContactUtils.getSubscription(r3.getAsString("account_type"), r3.getAsString("account_name")) == (-1)) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L12;
        r2 = r2 + 1;
        goto L6
    L12:
        return true;
    L10:
        r4 = false;
        goto L11
    L14:
        return false;
    }

    public boolean isEditingUserProfile() {
        if (this.mNewLocalProfile == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsUserProfile == true) goto L8;
        return false;
    }

    private void updateDoneButtonEnabled() {
        if (this.mListener != null) goto L5;
        return;
    L5:
        if (getView() == null) goto L10;
        this.mListener.setDoneButtonEnabled(hasAnyVisibleNonEmptyInput());
        return;
    }

    private boolean hasAnyVisibleNonEmptyInput() {
        LinearLayout r0 = this.mContent;
        if (r0 != null) goto L7;
        return false;
    L7:
        return hasAnyVisibleNonEmptyInput(r0);
    }

    private boolean hasAnyVisibleNonEmptyInput(View r5) {
        if (r5 != null) goto L5;
    L37:
        return false;
    L5:
        if (r5.getVisibility() != 0) goto L37;
        if ((r5 instanceof OCardListItem) == false) goto L13;
        if (hasAnyVisibleNonEmptyInput(((OCardListItem) r5).getCustomStartView()) == false) goto L13;
        return true;
    L13:
        if ((r5 instanceof GroupMembershipView) == false) goto L17;
        return ((GroupMembershipView) r5).hasSelectedGroup();
    L17:
        if ((r5 instanceof GenderSelectView) == false) goto L21;
        return ((GenderSelectView) r5).hasSelectedGender();
    L21:
        if ((r5 instanceof EditText) == false) goto L29;
        Editable r4 = ((EditText) r5).getText();
        if (r4 != null) goto L25;
        return false;
    L25:
        if (r4.toString().trim().isEmpty() == false) goto L27;
        return false;
    L27:
        return true;
    L29:
        if ((r5 instanceof ViewGroup) == false) goto L37;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = 0;
    L32:
        if (r1 >= r6.getChildCount()) goto L37;
        if (hasAnyVisibleNonEmptyInput(r6.getChildAt(r1)) == true) goto L35;
        r1 = r1 + 1;
        goto L32
    L35:
        return true;
    }

    public long getContactId() {
        EntityDeltaList r2 = this.mState;
        if (r2 == null) goto L11;
        Iterator<EntityDelta> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        Long r0 = r3.next().getValues().getAsLong("contact_id");
        if (r0 == null) goto L6;
        return r0.longValue();
    L16:
        return 0;
    L11:
        return 0;
    }

    public void acquireAggregationSuggestions(RawContactEditorView r5) {
        long r0 = r5.getRawContactId();
        if (this.mAggregationSuggestionsRawContactId == r0) goto L7;
        View r2 = this.mAggregationSuggestionView;
        if (r2 == null) goto L7;
        r2.setVisibility(8);
        this.mAggregationSuggestionView = null;
        this.mAggregationSuggestionEngine.reset();
    L7:
        this.mAggregationSuggestionsRawContactId = r0;
        if (this.mAggregationSuggestionEngine != null) goto L10;
        AggregationSuggestionEngine r1 = new AggregationSuggestionEngine(getActivity());
        this.mAggregationSuggestionEngine = r1;
        r1.setListener(this);
        this.mAggregationSuggestionEngine.start();
    L10:
        this.mAggregationSuggestionEngine.setContactId(getContactId());
        TextFieldsEditorView r6 = r5.getNameEditor();
        this.mAggregationSuggestionEngine.onNameChange(r6.getValues());
    }

    @Override // com.android.contacts.editor.AggregationSuggestionEngine.Listener
    public void onAggregationSuggestionChange() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (this.mState != null) goto L7;
        return;
    L7:
        if (this.mStatus != 1) goto L41;
        OPopover r1 = this.mAggregationSuggestionPopup;
        if (r1 == null) goto L15;
        if (r1.isShowing() == false) goto L15;
        this.mAggregationSuggestionPopup.dismiss();
    L15:
        if (this.mAggregationSuggestionEngine.getSuggestedContactCount() != 0) goto L17;
        return;
    L17:
        RawContactEditorView r2 = (RawContactEditorView) getRawContactEditorView(this.mAggregationSuggestionsRawContactId);
        if (r2 != null) goto L20;
        return;
    L20:
        TextFieldsEditorView r3 = r2.getNameEditor();
        if (r3 != null) goto L24;
        return;
    L24:
        if (this.mState.size() == 1) goto L26;
    L28:
        final boolean r4 = false;
    L29:
        List<AggregationSuggestionEngine.Suggestion> r5 = this.mAggregationSuggestionEngine.getSuggestions();
        ArrayList r6 = new ArrayList();
        Iterator<AggregationSuggestionEngine.Suggestion> r7 = r5.iterator();
    L31:
        if (r7.hasNext() == false) goto L33;
        final AggregationSuggestionEngine.Suggestion r8 = r7.next();
        r6.add(new MenuItemData(ItemType.TEXT, null, null, null, r8.name, getAggregationSuggestionSubTitle(r8), null, null, null, new AnonymousClass15(this, r8, r4)));
        goto L31
    L33:
        this.mAggregationSuggestionPopup = OUIPopoverHelper.genPopover(getActivity(), r6, false);
        int[] r9 = new int[2];
        r3.getLocationOnScreen(r9);
        EditText r10 = r3.getFirstFocusedEditText();
        if (r10 == null) goto L36;
        int[] r11 = new int[2];
        r10.getLocationOnScreen(r11);
        r9[0] = r11[0] + r10.getCompoundPaddingLeft();
    L36:
        r9[1] = r9[1] + r3.getHeight();
        this.mAggregationSuggestionPopup.showAtLocation(getActivity().getWindow().getDecorView(), 51, r9[0], r9[1]);
        return;
    L26:
        if (this.mState.get(0).isContactInsert() == false) goto L28;
        r4 = true;
        goto L29
    }

    public void doPickRingtone() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("0102750", "doPickRingtone");
        hideSoftKeyboard();
        Intent r0 = new Intent(getActivity(), RingtoneSettingsActivity.class);
        r0.setFlags(67108864);
        if (this.mCustomRingtone != null) goto L5;
        Uri r1 = RingtoneManager.getDefaultUri(1);
    L9:
        r0.putExtra("android.intent.extra.ringtone.EXISTING_URI", r1);
        startActivityForResult(r0, 4);
        return;
    L5:
        if (ContactsUtils.existMediaStoreRingtone(getActivity(), this.mCustomRingtone, ContactsUtils.getRingTongTitle(getActivity(), this.mCustomRingtone)) == false) goto L7;
        r1 = this.mCustomRingtone;
        goto L9
    L7:
        r1 = RingtoneManager.getDefaultUri(1);
        goto L9
    }

    private void hideSoftKeyboard() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getWindow() != null) goto L7;
        return;
    L7:
        if (getActivity().getWindow().getDecorView() != null) goto L9;
        return;
    L9:
        if (getActivity().getWindow().getDecorView().getWindowToken() == null) goto L15;
        ContactsUtils.hideInputMethod(this.mContext, getActivity().getWindow().getDecorView().getWindowToken());
        return;
    }

    private String getAggregationSuggestionSubTitle(AggregationSuggestionEngine.Suggestion r1) {
        if (r1.nickname == null) goto L7;
        return r1.nickname;
    L7:
        if (r1.emailAddress == null) goto L11;
        return r1.emailAddress;
    L11:
        if (r1.phoneNumber != null) goto L13;
        return null;
    L13:
        return ContactsUtils.formatNumber(r1.phoneNumber);
    }

    private boolean canEditAggregationSuggestion(AggregationSuggestionEngine.Suggestion r4, boolean r5) {
        if (r5 == true) goto L5;
        return false;
    L5:
        AccountTypeManager r3 = AccountTypeManager.getInstance(getContext());
        Iterator<AggregationSuggestionEngine.RawContact> r6 = r4.rawContacts.iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        AggregationSuggestionEngine.RawContact r7 = r6.next();
        String r1 = r7.accountType;
        String r8 = r7.dataSet;
        if (r1 == null) goto L10;
        if (r3.getAccountType(r1, r8).areContactsWritable() == false) goto L7;
        return true;
    L10:
        return true;
    L14:
        return false;
    }

    private void handleAggregationSuggestionClick(AggregationSuggestionEngine.Suggestion r4, boolean r5) {
        if (canEditAggregationSuggestion(r4, r5) == false) goto L6;
        onEditAction(ContactsContract.Contacts.getLookupUri(r4.contactId, r4.lookupKey));
        return;
    L6:
        ArrayList r6 = new ArrayList();
        Iterator<AggregationSuggestionEngine.RawContact> r0 = r4.rawContacts.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        r6.add(Long.valueOf(r0.next().rawContactId));
        goto L8
    L10:
        onJoinAction(r4.contactId, r6);
    }

    public void onJoinAction(long r5, List<Long> r7) {
        int r6 = r7.size();
        long[] r8 = new long[r6];
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        r8[r1] = r7.get(r1).longValue();
        r1 = r1 + 1;
        goto L3
    L5:
        JoinSuggestedContactDialogFragment r9 = new JoinSuggestedContactDialogFragment();
        Bundle r10 = new Bundle();
        r10.putLongArray("rawContactIds", r8);
        r9.setArguments(r10);
        r9.setTargetFragment(this, 0);
        r9.show(getFragmentManager(), "join");     // Catch: Exception -> L8
        return;
    }

    protected void doJoinSuggestedContact(long[] r3) {
        if (hasValidState() == true) goto L5;
        return;
    L5:
        if (this.mStatus != 1) goto L10;
        this.mState.setJoinWithRawContacts(r3);
        save(1);
        return;
    }

    public void onEditAction(Uri r4) {
        SuggestionEditConfirmationDialogFragment r0 = new SuggestionEditConfirmationDialogFragment();
        Bundle r1 = new Bundle();
        r1.putParcelable("contactUri", r4);
        r0.setArguments(r1);
        r0.setTargetFragment(this, 0);
        r0.show(getFragmentManager(), "edit");
    }

    protected void doEditSuggestedContact(Uri r3) {
        Listener r0 = this.mListener;
        if (r0 == null) goto L6;
        this.mStatus = 3;
        r0.onEditOtherContactRequested(r3, this.mState.get(0).getContentValues());
        return;
    }

    private Rect getRelativeBounds(View r5, View r6) {
        Rect r4 = new Rect();
        r4.set(r6.getLeft(), r6.getTop(), r6.getRight(), r6.getBottom());
        View r7 = (View) r6.getParent();
    L3:
        if (r7 == r5) goto L5;
        r4.offset(r7.getLeft(), r7.getTop());
        r7 = (View) r7.getParent();
        goto L3
    L5:
        return r4;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r4) {
        r4.putParcelable(KEY_URI, this.mLookupUri);
        r4.putString("action", this.mAction);
        if (hasValidState() == false) goto L5;
        r4.putParcelable("state", this.mState);
    L5:
        r4.putLong(KEY_RAW_CONTACT_ID_REQUESTING_PHOTO, this.mRawContactIdRequestingPhoto);
        r4.putParcelable(KEY_VIEW_ID_GENERATOR, this.mViewIdGenerator);
        r4.putParcelable(KEY_CURRENT_PHOTO_URI, this.mCurrentPhotoUri);
        r4.putLong(KEY_CONTACT_ID_FOR_JOIN, this.mContactIdForJoin);
        r4.putBoolean(KEY_CONTACT_WRITABLE_FOR_JOIN, this.mContactWritableForJoin);
        r4.putLong(KEY_SHOW_JOIN_SUGGESTIONS, this.mAggregationSuggestionsRawContactId);
        r4.putBoolean(KEY_ENABLED, this.mEnabled);
        r4.putBoolean("newLocalProfile", this.mNewLocalProfile);
        r4.putBoolean(KEY_IS_USER_PROFILE, this.mIsUserProfile);
        r4.putInt("status", this.mStatus);
        r4.putParcelable("customRingtone", this.mCustomRingtone);
        r4.putParcelable("updatedPhotos", this.mUpdatedPhotos);
        super.onSaveInstanceState(r4);
    }

    private void handleRingtonePicked(Uri r4) {
        if (this.mLookupUri == null) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("handleRingtonePicked", "handleRingtonePicked" + this.mLookupUri.toString());
    L6:
        Context r0 = this.mContext;
        Uri r1 = this.mLookupUri;
        if (r4 != null) goto L9;
        String r5 = null;
    L10:
        this.mContext.startService(ContactSaveService.createSetRingtone(r0, r1, r5));
        return;
    L9:
        r5 = r4.toString();
        goto L10
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("handleRingtonePicked", "handleRingtonePicked lookup null");
        goto L6
    }

    private void saveContactLocation(Uri r2) {
        if (r2 == null) goto L5;
        Intent r3 = ContactSaveService.createSetLocation(this.mContext, r2);
        this.mContext.startService(r3);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r8, int r9, Intent r10) {
        if (this.mStatus != 4) goto L5;
        this.mStatus = 1;
    L5:
        PhotoHandler r0 = this.mCurrentPhotoHandler;
        if (r0 == null) goto L11;
        if (r0.handlePhotoActivityResult(r8, r9, r10) == false) goto L11;
        return;
    L11:
        if (r8 != 0) goto L13;
        if (r9 == (-1)) goto L34;
        return;
    L34:
        if (r10 == null) goto L46;
        joinAggregate(ContentUris.parseId(r10.getData()));
        return;
    L46:
        return;
    L13:
        if (r8 == 10) goto L27;
        if (r8 != 4) goto L16;
        if (r10 == null) goto L42;
        Uri r11 = this.mCustomRingtone;
        Uri r12 = r10.getData();
        this.mCustomRingtone = r12;
        this.mRingtoneChanged = !UriUtils.areEqual(r11, r12);
        setRingtoneTitle(this.mCustomRingtone);
        updateDoneButtonEnabled();
        return;
    L42:
        return;
    L16:
        if (r8 != 5) goto L47;
        if (r9 != (-1)) goto L40;
        Iterator<EntityDelta> r13 = this.mState.iterator();
    L21:
        if (r13.hasNext() == false) goto L48;
        EntityDelta r14 = r13.next();
        String r1 = r14.getValues().getAsString("account_type");
        String r2 = r14.getValues().getAsString("account_name");
        String r15 = r14.getValues().getAsString("data_set");
        AccountType r5 = this.mAccountTypeManager.getAccountType(r1, r15);
        if (r5.areContactsWritable() == false) goto L21;
        ContentValues r16 = new ContentValues();
        r16.put("account_name", r2);
        r16.put("account_type", r1);
        r16.put("data_set", r15);
        EntityDelta r17 = new EntityDelta(EntityDelta.ValuesDelta.fromAfter(r16));
        EntityModifier.parseExtras(this.mContext, r5, r17, r10.getExtras());
        this.mState = EntityDeltaList.fromSingle(r17);
        bindEditors();
        return;
    L48:
        return;
    L40:
        return;
    L47:
        return;
    L27:
        if (r9 == (-1)) goto L29;
        return;
    L29:
        String r18 = r10.getStringExtra(ContactSaveService.EXTRA_GROUP_LABEL);
        if (r18 == null) goto L44;
        this.mRawContactEditor.setGroupNameToAdd(r18);
        return;
    }

    public void createNewGroup() {
        Agent.getInstance().onClick(TAG, com.android.contacts.util.Constants.ContactsTracker.EVENT_NEW_GROUP);
        Intent r0 = new Intent(this.mContext, GroupEditorActivity.class);
        r0.setAction("android.intent.action.INSERT");
        r0.putExtra(Constants.get_INSERT_ACCOUNT(), new AccountWithDataSet(this.mAccountName, this.mAccountType, this.mDataSet));
        r0.putExtra(Constants.get_INSERT_DATA_SET(), this.mDataSet);
        startActivityForResult(r0, 10);
    }

    public void createNewGroup(AccountWithDataSet r4) {
        Intent r0 = new Intent(this.mContext, GroupEditorActivity.class);
        r0.setAction("android.intent.action.INSERT");
        r0.putExtra(Constants.get_INSERT_ACCOUNT(), r4);
        r0.putExtra(Constants.get_INSERT_DATA_SET(), r4.dataSet);
        startActivityForResult(r0, 10);
    }

    private void setPhoto(long r4, Bitmap r6, Uri r7) {
        BaseRawContactEditorView r0 = getRawContactEditorView(r4);
        if (r0 == null) goto L12;
        if (r6 == null) goto L12;
        if (r6.isRecycled() == true) goto L12;
        if (r4 != (-115)) goto L10;
        boolean r1 = true;
    L11:
        r0.setPhotoBitmap(r6, r1);
    L13:
        this.mUpdatedPhotos.putParcelable(String.valueOf(r4), r7);
        return;
    L10:
        r1 = false;
    L12:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "The contact that requested the photo is no longer present.");
        goto L13
    }

    public BaseRawContactEditorView getRawContactEditorView(long r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mContent.getChildCount()) goto L11;
        View r1 = this.mContent.getChildAt(r0);
        if ((r1 instanceof BaseRawContactEditorView) == false) goto L10;
        BaseRawContactEditorView r2 = (BaseRawContactEditorView) r1;
        if (r2.getRawContactId() != r5) goto L10;
        return r2;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return null;
    }

    private boolean hasMoreThanOnePhoto() {
        int r0 = this.mContent.getChildCount();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L12;
        View r4 = this.mContent.getChildAt(r2);
        if ((r4 instanceof BaseRawContactEditorView) == false) goto L11;
        if (((BaseRawContactEditorView) r4).hasSetPhoto() == false) goto L11;
        r3 = r3 + 1;
        if (r3 <= 1) goto L11;
        return true;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return false;
    }

    @Override // com.android.contacts.editor.SplitContactConfirmationDialogFragment.Listener
    public void onSplitContactConfirmed() {
        EntityDeltaList r0 = this.mState;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "mState became null during the user's confirming split action. Cannot perform the save action.");
        return;
    L6:
        r0.markRawContactsForSplitting();
        save(2);
    }

    private void setRingtoneTitle(Uri r4) {
        TextView r0 = this.mRingtoneTitle;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        r0.setText(R.string.default_ringtone);
        this.mRingtoneTitle.setTextColor(getResources().getColor(R.color.oui_basic_text_3));
        return;
    L7:
        if (RingtoneManager.isDefault(r4) == false) goto L9;
        this.mRingtoneTitle.setText(R.string.default_ringtone);
        this.mRingtoneTitle.setTextColor(getResources().getColor(R.color.oui_basic_text_3));
        return;
    L9:
        this.mRingtoneTitle.setText(ContactsUtils.getContactRingtoneTitle(this.mContext, r4));
        this.mRingtoneTitle.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
    }

    private Bitmap updatedBitmapForRawContact(long r1) {
        return BitmapFactory.decodeFile(this.mUpdatedPhotos.getString(String.valueOf(r1)));
    }

    private void bindPhotoHandler(BaseRawContactEditorView r8, AccountType r9, EntityDeltaList r10) {
        PhotoHandler r6 = new PhotoHandler(this, this.mContext, r8, r10, r9.areContactsWritable());
        if ("com.android.sim".equals(r9.accountType) == true) goto L13;
        PhotoHandler.PhotoEditorListener r11 = (PhotoHandler.PhotoEditorListener) r6.getListener();
        r8.getPhotoEditor().setEditorListener(r11);
        Bundle r12 = this.mIntentExtras;
        if (r12 == null) goto L13;
        if (r12.getParcelable(ContactsUtils.EXTRA_PUBLIC_LOGO) == null) goto L13;
        r11.onPhotoSelected((Uri) this.mIntentExtras.getParcelable(ContactsUtils.EXTRA_PUBLIC_LOGO));     // Catch: FileNotFoundException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L13:
        if (this.mRawContactIdRequestingPhoto != r8.getRawContactId()) goto L18;
        this.mCurrentPhotoHandler = r6;
        return;
    }

    private boolean hasPhotoPermission() {
        return PermissionUtils.checkPermission(this, 12, (String[]) PrivacyConstantsKt.PERMS_FOR_PHOTO.toArray(new String[0]), getString(R.string.permission_guide_photo_msg), null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int r1, String[] r2, int[] r3) {
        super.onRequestPermissionsResult(r1, r2, r3);
        if (r1 != 12) goto L9;
        PermissionUtils.setPermsUserSet(getContext(), r1);
        if (PermissionUtils.granted(r3) == false) goto L7;
        this.mPendingShowPhotoActionTask.run();
        return;
    L7:
        this.mPendingShowPhotoActionTask.cancel();
        return;
    }

    public void collectContactCache() {
        EntityDeltaList r0 = this.mState;
        if (r0 != null) goto L5;
    L15:
        ContactEditorCache.getInstance().clear();
        return;
    L5:
        if (r0.isEmpty() == true) goto L15;
        EntityDeltaList r1 = EntityDeltaList.mergeAfter(null, this.mState);
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L10;
        EntityModifier.trimEmpty(r1, AccountTypeManager.getInstance(r2));
    L10:
        ContactLoader.Result r3 = r1.buildContactResult();
        if (r3 == null) goto L13;
        ContactEditorCache.getInstance().setCache(r3);
        return;
    L13:
        ContactEditorCache.getInstance().setCache(null);
    }

    private void processEmergencyNumber() {
        if (this.mLookupUri != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mNewEmergencyNumber) == true) goto L10;
        final String r0 = ContactsUtils.formatNumber(this.mNewEmergencyNumber);
        final long r1 = ContentUris.parseId(this.mLookupUri);
        new Thread(new AnonymousClass18(this, r1, r0)).start();
        return;
    }

    private void setupBarcodeForNameEditor() {
        final EditText r0 = this.mNameEditor.getFirstFocusedEditText();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.postDelayed(new AnonymousClass19(this, r0), 500);
    }
}
