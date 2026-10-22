package com.android.contacts.group;

import android.accounts.Account;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import com.GlobalProxyLancet;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.activities.GroupEditorActivity;
import com.android.contacts.editor.SelectAccountDialogFragment;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.util.AccountsListAdapter;
import com.google.common.base.Objects;
import com.obric.contacts.Constants;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.ui.dialog.OUIDialogHelper;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public class GroupEditorFragment extends Fragment implements SelectAccountDialogFragment.Listener {
    public static final String ACTION_INSERT_GROUP_IN_CONTACT_EDITOR = "com.android.contacts.GroupEditorFragment.action_insert";
    protected static final int CONTACT_CHAT_CAPABILITY_COLUMN_INDEX = 6;
    protected static final int CONTACT_DISPLAY_NAME_ALTERNATIVE_COLUMN_INDEX = 2;
    protected static final int CONTACT_DISPLAY_NAME_PRIMARY_COLUMN_INDEX = 1;
    protected static final int CONTACT_HAS_PHONE_COLUMN_INDEX = 11;
    protected static final int CONTACT_ID_COLUMN_INDEX = 0;
    protected static final int CONTACT_IS_USER_PROFILE = 12;
    protected static final int CONTACT_LOOKUP_KEY_COLUMN_INDEX = 9;
    protected static final int CONTACT_PHONETIC_NAME_COLUMN_INDEX = 10;
    protected static final int CONTACT_PHOTO_ID_COLUMN_INDEX = 7;
    protected static final int CONTACT_PHOTO_URI_COLUMN_INDEX = 8;
    protected static final int CONTACT_PRESENCE_STATUS_COLUMN_INDEX = 5;
    protected static final int CONTACT_SORT_KEY_PRIMARY_COLUMN_INDEX = 3;
    protected static final int CONTACT_STARRED_COLUMN_INDEX = 4;
    private static final String CURRENT_EDITOR_TAG = "currentEditorForAccount";
    private static final int DELAY_SHOW_DIALOG_MS = 50;
    private static final String KEY_ACCOUNT_NAME = "accountName";
    private static final String KEY_ACCOUNT_TYPE = "accountType";
    private static final String KEY_ACTION = "action";
    private static final String KEY_CURRENT_GROUP_NAME = "currentGroupName";
    private static final String KEY_DATA_SET = "dataSet";
    private static final String KEY_GROUP_ID = "groupId";
    private static final String KEY_GROUP_NAME_IS_READ_ONLY = "groupNameIsReadOnly";
    private static final String KEY_GROUP_URI = "groupUri";
    private static final String KEY_MEMBERS_TO_ADD = "membersToAdd";
    private static final String KEY_MEMBERS_TO_DISPLAY = "membersToDisplay";
    private static final String KEY_MEMBERS_TO_REMOVE = "membersToRemove";
    private static final String KEY_ORIGINAL_GROUP_NAME = "originalGroupName";
    private static final String KEY_STATUS = "status";
    private static final String LEGACY_CONTACTS_AUTHORITY = "contacts";
    private static final int LOADER_GROUP_METADATA = 1;
    private static final int LOADER_NEW_GROUP_MEMBER = 3;
    private static final String MEMBER_LOOKUP_URI_KEY = "memberLookupUri";
    private static final String MEMBER_RAW_CONTACT_ID_KEY = "rawContactId";
    protected static final String[] PROJECTION_CONTACT = null;
    public static final String SAVE_MODE_EXTRA_KEY = "saveMode";
    private static final String TAG = "GroupEditorFragment";
    private String mAccountName;
    private String mAccountType;
    private String mAction;
    private OButton mBtnCancel;
    private OButton mBtnDone;
    private final LoaderManager.LoaderCallbacks<Cursor> mContactLoaderListener;
    private Context mContext;
    private String mCurrentGroupName;
    private String mDataSet;
    private OSimpleFormDialog mFormDialog;
    private long mGroupId;
    private final LoaderManager.LoaderCallbacks<Cursor> mGroupMetaDataLoaderListener;
    private boolean mGroupNameIsReadOnly;
    private EditText mGroupNameView;
    private Uri mGroupUri;
    private boolean mHasRestoredGroupName;
    private Bundle mIntentExtras;
    private int mLastGroupEditorId;
    private LayoutInflater mLayoutInflater;
    private Listener mListener;
    private String mOriginalGroupName;
    private ContactPhotoManager mPhotoManager;
    private ViewGroup mRootView;
    private final Runnable mShowFormDialogRunnable;
    private Status mStatus;
    private final Handler mUiHandler;

    public interface Listener {
        void onAccountsNotFound();

        void onGroupNotFound();

        void onReverted();

        void onSaveFinished(int r1, Intent r2);
    }

    public static class Member implements Parcelable {
        public static final Parcelable.Creator<Member> CREATOR = null;
        private static final Member[] EMPTY_ARRAY = null;
        private final long mContactId;
        private final String mDisplayName;
        private final Uri mLookupUri;
        private final Uri mPhotoUri;
        private final long mRawContactId;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* synthetic */ Member(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        static {
            EMPTY_ARRAY = new Member[0];
            CREATOR = new AnonymousClass1();
        }

        public Member(long r1, String r3, long r4, String r6, String r7) {
            this.mRawContactId = r1;
            this.mContactId = r4;
            this.mLookupUri = ContactsContract.Contacts.getLookupUri(r4, r3);
            this.mDisplayName = r6;
            if (r7 == null) goto L5;
            Uri r2 = Uri.parse(r7);
        L6:
            this.mPhotoUri = r2;
            return;
        L5:
            r2 = null;
            goto L6
        }

        public long getRawContactId() {
            return this.mRawContactId;
        }

        public long getContactId() {
            return this.mContactId;
        }

        public Uri getLookupUri() {
            return this.mLookupUri;
        }

        public String getDisplayName() {
            return this.mDisplayName;
        }

        public Uri getPhotoUri() {
            return this.mPhotoUri;
        }

        public boolean equals(Object r3) {
            if ((r3 instanceof Member) == false) goto L10;
            Member r4 = (Member) r3;
            if (r4 != null) goto L7;
            return false;
        L7:
            if (Objects.equal(this.mLookupUri, r4.getLookupUri()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            r3.writeLong(this.mRawContactId);
            r3.writeLong(this.mContactId);
            r3.writeParcelable(this.mLookupUri, r4);
            r3.writeString(this.mDisplayName);
            r3.writeParcelable(this.mPhotoUri, r4);
        }

        private Member(Parcel r3) {
            this.mRawContactId = r3.readLong();
            this.mContactId = r3.readLong();
            this.mLookupUri = (Uri) r3.readParcelable(getClass().getClassLoader());
            this.mDisplayName = r3.readString();
            this.mPhotoUri = (Uri) r3.readParcelable(getClass().getClassLoader());
        }
    }

    public interface RefreshActivityListener {
        void setUIEnable(boolean r1);
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status CLOSING = null;
        public static final Status EDITING = null;
        public static final Status LOADING = null;
        public static final Status SAVING = null;
        public static final Status SELECTING_ACCOUNT = null;

        private static /* synthetic */ Status[] $values() {
            return new Status[]{SELECTING_ACCOUNT, LOADING, EDITING, SAVING, CLOSING};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r1) {
            return (Status) Enum.valueOf(Status.class, r1);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        static {
            SELECTING_ACCOUNT = new Status("SELECTING_ACCOUNT", 0);
            LOADING = new Status("LOADING", 1);
            EDITING = new Status("EDITING", 2);
            SAVING = new Status("SAVING", 3);
            CLOSING = new Status("CLOSING", 4);
            $VALUES = $values();
        }
    }

    static /* synthetic */ Unit lambda$setupEditorForAccount$1() {
        return null;
    }

    static /* synthetic */ void access$000(GroupEditorFragment r0) {
        r0.showFormDialogIfNeeded();
    }

    static /* synthetic */ String access$102(GroupEditorFragment r0, String r1) {
        r0.mCurrentGroupName = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(GroupEditorFragment r0, boolean r1) {
        r0.mHasRestoredGroupName = r1;
        return r1;
    }

    static /* synthetic */ OButton access$300(GroupEditorFragment r0) {
        return r0.mBtnDone;
    }

    static /* synthetic */ void access$400(GroupEditorFragment r0, CharSequence r1) {
        r0.updateDoneButtonEnabled(r1);
    }

    static /* synthetic */ void access$500(GroupEditorFragment r0) {
        r0.doRevertAction();
    }

    static /* synthetic */ Context access$600(GroupEditorFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ Uri access$700(GroupEditorFragment r0) {
        return r0.mGroupUri;
    }

    static /* synthetic */ void access$800(GroupEditorFragment r0, Cursor r1) {
        r0.bindGroupMetaData(r1);
    }

    static {
        PROJECTION_CONTACT = new String[]{"_id", "display_name", "display_name_alt", PickerFragment.CONTACT_SORT_CNAME, ContactSaveService.EXTRA_STARRED_FLAG, "contact_presence", "contact_chat_capability", "photo_id", "photo_thumb_uri", "lookup", "phonetic_name", "has_phone_number", "is_user_profile"};
    }

    public GroupEditorFragment() {
        this.mOriginalGroupName = "";
        this.mCurrentGroupName = "";
        this.mHasRestoredGroupName = false;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mShowFormDialogRunnable = new AnonymousClass1(this);
        this.mGroupMetaDataLoaderListener = new AnonymousClass5(this);
        this.mContactLoaderListener = new AnonymousClass6(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mLayoutInflater = r2;
        ViewGroup r5 = (ViewGroup) r2.inflate(R.layout.group_editor_fragment, r3, false);
        this.mRootView = r5;
        return r5;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.mContext = r1;
        this.mPhotoManager = ContactPhotoManager.getInstance(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        if (r3 == null) goto L12;
        onRestoreInstanceState(r3);
        if (this.mStatus != Status.SELECTING_ACCOUNT) goto L8;
        return;
    L8:
        if (this.mStatus != Status.LOADING) goto L10;
        startGroupMetaDataLoader();
        return;
    L10:
        setupEditorForAccount();
        return;
    L12:
        if ("android.intent.action.EDIT".equals(this.mAction) == false) goto L14;
        startGroupMetaDataLoader();
        return;
    L14:
        String r0 = null;
        if ("android.intent.action.INSERT".equals(this.mAction) == false) goto L28;
        Bundle r4 = this.mIntentExtras;
        if (r4 != null) goto L19;
        Account r5 = null;
    L20:
        Bundle r1 = this.mIntentExtras;
        if (r1 == null) goto L24;
        r0 = r1.getString(Constants.get_INSERT_DATA_SET());
    L24:
        if (r5 == null) goto L26;
        this.mAccountName = r5.name;
        this.mAccountType = r5.type;
        this.mDataSet = r0;
        setupEditorForAccount();
        return;
    L26:
        selectAccountAndCreateGroup();
        return;
    L19:
        r5 = (Account) r4.getParcelable(Constants.get_INSERT_ACCOUNT());
        goto L20
    L28:
        if (ACTION_INSERT_GROUP_IN_CONTACT_EDITOR.equals(this.mAction) == false) goto L40;
        Bundle r6 = this.mIntentExtras;
        if (r6 != null) goto L32;
        Account r7 = null;
    L33:
        Bundle r2 = this.mIntentExtras;
        if (r2 == null) goto L37;
        r0 = r2.getString(Constants.get_INSERT_DATA_SET());
    L37:
        if (r7 == null) goto L39;
        this.mAccountName = r7.name;
        this.mAccountType = r7.type;
        this.mDataSet = r0;
        setupEditorForAccount();
        return;
    L39:
        selectAccountAndCreateGroup();
        return;
    L32:
        r7 = (Account) r6.getParcelable(Constants.get_INSERT_ACCOUNT());
        goto L33
    L40:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unknown Action String " + this.mAction + ". Only support android.intent.action.EDIT or android.intent.action.INSERT");
    }

    private void startGroupMetaDataLoader() {
        this.mStatus = Status.LOADING;
        getLoaderManager().initLoader(1, null, this.mGroupMetaDataLoaderListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r4) {
        super.onSaveInstanceState(r4);
        r4.putString("action", this.mAction);
        r4.putParcelable(KEY_GROUP_URI, this.mGroupUri);
        r4.putLong("groupId", this.mGroupId);
        r4.putSerializable("status", this.mStatus);
        r4.putString("accountName", this.mAccountName);
        r4.putString("accountType", this.mAccountType);
        r4.putString("dataSet", this.mDataSet);
        r4.putBoolean(KEY_GROUP_NAME_IS_READ_ONLY, this.mGroupNameIsReadOnly);
        r4.putString(KEY_ORIGINAL_GROUP_NAME, this.mOriginalGroupName);
        EditText r3 = this.mGroupNameView;
        if (r3 == null) goto L6;
        r4.putString(KEY_CURRENT_GROUP_NAME, r3.getText().toString());
        return;
    }

    private void onRestoreInstanceState(Bundle r4) {
        this.mAction = r4.getString("action");
        this.mGroupUri = (Uri) r4.getParcelable(KEY_GROUP_URI);
        this.mGroupId = r4.getLong("groupId");
        this.mStatus = (Status) r4.getSerializable("status");
        this.mAccountName = r4.getString("accountName");
        this.mAccountType = r4.getString("accountType");
        this.mDataSet = r4.getString("dataSet");
        this.mGroupNameIsReadOnly = r4.getBoolean(KEY_GROUP_NAME_IS_READ_ONLY);
        this.mOriginalGroupName = r4.getString(KEY_ORIGINAL_GROUP_NAME);
        if (r4.containsKey(KEY_CURRENT_GROUP_NAME) == false) goto L5;
        this.mCurrentGroupName = r4.getString(KEY_CURRENT_GROUP_NAME, "");
        this.mHasRestoredGroupName = true;
        return;
    L5:
        this.mCurrentGroupName = "";
        this.mHasRestoredGroupName = false;
    }

    private void selectAccountAndCreateGroup() {
        List<AccountWithDataSet> r0 = AccountTypeManager.getInstance(this.mContext).getAccounts(true);
        if (r0.isEmpty() == false) goto L9;
        Listener r4 = this.mListener;
        if (r4 == null) goto L14;
        r4.onAccountsNotFound();
        return;
    L14:
        return;
    L9:
        if (r0.size() != 1) goto L12;
        this.mAccountName = r0.get(0).name;
        this.mAccountType = r0.get(0).type;
        this.mDataSet = r0.get(0).dataSet;
        setupEditorForAccount();
        return;
    L12:
        this.mStatus = Status.SELECTING_ACCOUNT;
        SelectAccountDialogFragment.show(getParentFragmentManager(), this, R.string.dialog_new_group_account, AccountsListAdapter.AccountListFilter.ACCOUNTS_GROUP_WRITABLE, null);
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountChosen(AccountWithDataSet r1, Bundle r2) {
        this.mAccountName = r1.name;
        this.mAccountType = r1.type;
        this.mDataSet = r1.dataSet;
        setupEditorForAccount();
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountSelectorCancelled() {
        Listener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onGroupNotFound();
        return;
    }

    private AccountType getAccountType() {
        return AccountTypeManager.getInstance(this.mContext).getAccountType(this.mAccountType, this.mDataSet);
    }

    private boolean isGroupMembershipEditable() {
        if (this.mAccountType != null) goto L7;
        return false;
    L7:
        return getAccountType().isGroupMembershipEditable();
    }

    private void setupEditorForAccount() {
        getAccountType();
        OSimpleFormDialog r0 = this.mFormDialog;
        if (r0 != null) goto L5;
    L7:
        Context r1 = this.mContext;
        if ("android.intent.action.EDIT".equals(this.mAction) == false) goto L10;
        int r2 = R.string.rename_group_message;
    L11:
        GroupEditorFormDialog r3 = OUIDialogHelper.getGroupEditorFormDialog(r1, r1.getString(r2), this.mContext.getString(R.string.new_group_message), this.mContext.getString(R.string.common_ok), this.mContext.getString(R.string.common_cancel), this.mContext.getString(R.string.group_name_hint), "", false, new GroupEditorFragment$$ExternalSyntheticLambda0(this), new GroupEditorFragment$$ExternalSyntheticLambda1(), new GroupEditorFragment$$ExternalSyntheticLambda2(this));
        this.mFormDialog = r3;
        r3.setAutoDismiss(true);
        this.mFormDialog.setCancelable(true);
        OInputLayout r4 = this.mFormDialog.getInputView1();
        r4.getVInput().setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        r4.getVInput().addTextChangedListener(new AnonymousClass2(this));
        OEditText r5 = r4.getVInput();
        this.mGroupNameView = r5;
        if (this.mHasRestoredGroupName == false) goto L14;
        r5.setText(this.mCurrentGroupName);
        EditText r6 = this.mGroupNameView;
        r6.setSelection(r6.getText().length());
    L14:
        this.mBtnDone = this.mFormDialog.getPositiveButton();
        this.mBtnCancel = this.mFormDialog.getNegativeButton();
        updateDoneButtonEnabled(this.mGroupNameView.getText());
        scheduleShowFormDialog();
        this.mStatus = Status.EDITING;
        return;
    L10:
        r2 = R.string.menu_newGroup;
        goto L11
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mFormDialog.dismiss();
        goto L7
    }

    /* JADX INFO: renamed from: lambda$setupEditorForAccount$0$com-android-contacts-group-GroupEditorFragment, reason: not valid java name */
    /* synthetic */ Unit m193x83524b05() {
        onDoneClicked();
        return null;
    }

    /* JADX INFO: renamed from: lambda$setupEditorForAccount$2$com-android-contacts-group-GroupEditorFragment, reason: not valid java name */
    /* synthetic */ Unit m194xf6e78ec3() {
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.isFinishing() == true) goto L10;
        r1.finish();
        return null;
    L10:
        return null;
    }

    private String getGroupNameViewText() {
        EditText r0 = this.mGroupNameView;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getText().toString().trim();
    }

    public void load(String r1, Uri r2, Bundle r3) {
        this.mAction = r1;
        this.mGroupUri = r2;
        if (r2 == null) goto L5;
        long r4 = ContentUris.parseId(r2);
    L6:
        this.mGroupId = r4;
        this.mIntentExtras = r3;
        return;
    L5:
        r4 = 0;
        goto L6
    }

    private void bindGroupMetaData(Cursor r4) {
        if (r4.moveToFirst() == true) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Group not found with URI: " + this.mGroupUri + " Closing activity now.");
        Listener r3 = this.mListener;
        if (r3 == null) goto L29;
        r3.onGroupNotFound();
        return;
    L29:
        return;
    L8:
        this.mOriginalGroupName = r4.getString(4);
        boolean r0 = false;
        this.mAccountName = r4.getString(0);
        this.mAccountType = r4.getString(1);
        this.mDataSet = r4.getString(2);
        if (r4.getInt(7) != 1) goto L11;
        r0 = true;
    L11:
        this.mGroupNameIsReadOnly = r0;
        setupEditorForAccount();
        if (this.mHasRestoredGroupName == true) goto L17;
        if (TextUtils.isEmpty(getGroupNameViewText()) == false) goto L17;
        this.mGroupNameView.setText(this.mOriginalGroupName);
    L17:
        if (this.mGroupNameView.isFocused() == true) goto L20;
        this.mGroupNameView.requestFocus();
    L20:
        if (this.mGroupNameView.isFocusable() == true) goto L22;
        this.mGroupNameView.setFocusable(true);
    L22:
        this.mGroupNameView.selectAll();
        Object r5 = this.mContext.getSystemService("input_method");
        if (r5 != null) goto L26;
        return;
    L26:
        if (((InputMethodManager) r5).isActive() == true) goto L30;
        ContactsUtils.toggleInputMethod(getActivity(), this.mGroupNameView);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mStatus != Status.EDITING) goto L6;
        scheduleShowFormDialog();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mUiHandler.removeCallbacks(this.mShowFormDialogRunnable);
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    public void onDoneClicked() {
        save(0);
    }

    private boolean revert() {
        if (hasNameChange() == true) goto L5;
        doRevertAction();
        return true;
    L5:
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
        r1.setOnClickListener(new AnonymousClass3(this, r4));
        return r0;
    }

    private View genContentView() {
        LinearLayout r0 = new LinearLayout(this.mContext);
        r0.setOrientation(1);
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(this.mContext, 5.0d));
        OButton r1 = (OButton) LayoutInflater.from(this.mContext).inflate(R.layout.sheet_button_center_red, null);
        r1.setText(R.string.common_ok);
        r1.setOnClickListener(new AnonymousClass4(this));
        r1.setWidth(ContactsUtils.dipTopx(this.mContext, 296.0d));
        r1.setHeight(ContactsUtils.dipTopx(this.mContext, 56.0d));
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        r4.gravity = 17;
        r4.bottomMargin = ContactsUtils.dipTopx(this.mContext, 5.0d);
        r0.addView(r1, r4);
        return r0;
    }

    private void doRevertAction() {
        this.mStatus = Status.CLOSING;
        Listener r1 = this.mListener;
        if (r1 == null) goto L6;
        r1.onReverted();
        return;
    }

    public boolean save(int r13) {
        if (hasValidGroupName() == true) goto L5;
    L26:
        return false;
    L5:
        if (this.mStatus != Status.EDITING) goto L26;
        if (hasNameChange() == true) goto L11;
        onSaveCompleted(false, 0, this.mGroupUri);
        return true;
    L11:
        this.mStatus = Status.SAVING;
        FragmentActivity r14 = getActivity();
        if (r14 != null) goto L15;
        return false;
    L15:
        if ("android.intent.action.INSERT".equals(this.mAction) == false) goto L18;
        Intent r0 = ContactSaveService.createNewGroupIntent(r14, new AccountWithDataSet(this.mAccountName, this.mAccountType, this.mDataSet), getGroupNameViewText(), null, r14.getClass(), GroupEditorActivity.ACTION_SAVE_COMPLETED);
        Intent r2 = new Intent();
        r2.putExtra(ContactSaveService.EXTRA_GROUP_LABEL, getGroupNameViewText());
        r2.putExtra("accountName", this.mAccountName);
        r2.putExtra("accountType", this.mAccountType);
        getActivity().setResult(-1, r2);
        r14.startService(r0);
    L23:
        return true;
    L18:
        if ("android.intent.action.EDIT".equals(this.mAction) == false) goto L21;
        Intent r1 = ContactSaveService.createGroupUpdateIntent(r14, this.mGroupId, getUpdatedName(), null, null, r14.getClass(), GroupEditorActivity.ACTION_SAVE_COMPLETED);
        Intent r3 = new Intent();
        r3.putExtra(ContactSaveService.EXTRA_GROUP_LABEL, getUpdatedName());
        getActivity().setResult(-1, r3);
        r14.startService(r1);
        goto L23
    L21:
        if (ACTION_INSERT_GROUP_IN_CONTACT_EDITOR.equals(this.mAction) == false) goto L25;
        r14.startService(ContactSaveService.createNewGroupIntent(r14, new AccountWithDataSet(this.mAccountName, this.mAccountType, this.mDataSet), getGroupNameViewText(), null, r14.getClass(), "android.intent.action.EDIT"));
        r14.finish();
        goto L23
    L25:
        throw new IllegalStateException("Invalid intent action type " + this.mAction);
    }

    public void onSaveCompleted(boolean r6, int r7, Uri r8) {
        int r0 = 0;
        if (r8 == null) goto L5;
        boolean r1 = true;
    L7:
        if (ContactsUtils.DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onSaveCompleted(" + r7 + ", " + r8 + ")");
    L9:
        if (r6 == false) goto L22;
        boolean r9 = "android.intent.action.INSERT".equals(this.mAction);
        int r2 = R.string.common_group_saved;
        if (r9 == false) goto L17;
        Context r10 = this.mContext;
        if (r1 == true) goto L16;
        r2 = R.string.groupSavedErrorToast;
    L16:
        Toast.makeText(r10, r2, 0).show();
        goto L22
    L17:
        Context r11 = this.mContext;
        if (r1 == true) goto L21;
        r2 = R.string.groupSavedErrorToast;
    L21:
        Toast.makeText(r11, r2, 0).show();
    L22:
        if (r7 == 0) goto L29;
        if (r7 == 4) goto L29;
        throw new IllegalStateException("Unsupported save mode " + r7);
    L29:
        if (r1 == false) goto L35;
        String r12 = r8.getAuthority();
        Intent r3 = new Intent();
        if ("contacts".equals(r12) == false) goto L33;
        r3.setData(ContentUris.withAppendedId(Uri.parse("content://contacts/groups"), ContentUris.parseId(r8)));
    L34:
        r0 = -1;
        Intent r13 = r3;
    L36:
        this.mStatus = Status.CLOSING;
        if (this.mFormDialog == null) goto L43;
        FragmentActivity r14 = getActivity();
        if (r14 == null) goto L48;
        r14.setResult(r0, r13);
    L48:
        this.mFormDialog.dismiss();     // Catch: Exception -> L47
    L42:
        this.mFormDialog = null;
        return;
    L43:
        Listener r5 = this.mListener;
        if (r5 == null) goto L51;
        r5.onSaveFinished(r0, r13);
        return;
    L51:
        return;
    L33:
        r3.setData(r8);
        goto L34
    L35:
        r13 = null;
        goto L36
    L5:
        r1 = false;
        goto L7
    }

    private boolean hasValidGroupName() {
        return !TextUtils.isEmpty(getGroupNameViewText());
    }

    private boolean hasNameChange() {
        return !getGroupNameViewText().equals(this.mOriginalGroupName);
    }

    private String getUpdatedName() {
        String r0 = getGroupNameViewText();
        if (r0.equals(this.mOriginalGroupName) == false) goto L6;
        return null;
    L6:
        return r0;
    }

    private static long[] convertToArray(List<Member> r5) {
        int r0 = r5.size();
        long[] r1 = new long[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = r5.get(r2).getRawContactId();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public void setUIEnable(boolean r1) {
        OButton r0 = this.mBtnDone;
        if (r0 == null) goto L6;
        r0.setEnabled(r1);
        return;
    }

    private void updateDoneButtonEnabled(CharSequence r1) {
        OButton r0 = this.mBtnDone;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        r0.setEnabled(r2);
        return;
    L7:
        if (r1.toString().trim().isEmpty() == true) goto L9;
        r2 = true;
        goto L10
    }

    private void scheduleShowFormDialog() {
        this.mUiHandler.removeCallbacks(this.mShowFormDialogRunnable);
        this.mUiHandler.post(this.mShowFormDialogRunnable);
    }

    private void showFormDialogIfNeeded() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == false) goto L7;
        return;
    L7:
        if (isAdded() == false) goto L22;
        OSimpleFormDialog r1 = this.mFormDialog;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.isShowing() == false) goto L15;
        return;
    L15:
        if (r0.hasWindowFocus() == true) goto L18;
        this.mUiHandler.postDelayed(this.mShowFormDialogRunnable, 50);
        return;
    L18:
        this.mGroupNameView.setFocusable(!this.mGroupNameIsReadOnly);
        this.mGroupNameView.setFocusableInTouchMode(!this.mGroupNameIsReadOnly);
        this.mFormDialog.show();
        return;
    }
}
