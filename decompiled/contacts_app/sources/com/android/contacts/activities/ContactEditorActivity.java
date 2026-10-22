package com.android.contacts.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.core.view.WindowInsetsCompat;
import com.GlobalProxyLancet;
import com.android.contacts.CallDetailActivity;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.editor.ContactEditorUtils;
import com.android.contacts.editor.EditContactsAccountPopWindowAdapter;
import com.android.contacts.editor.InsertContactAccountPopWindowAdapter;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityDeltaList;
import com.android.contacts.util.DialogManager;
import com.android.contacts.util.IntentUtils;
import com.android.contacts.util.MemoryCardUtil;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.util.UiUtils;
import com.android.contacts.widget.RoundCornerListView;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactPageShowEvent;
import com.obric.ui.OFloatingTitleBarHolder;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class ContactEditorActivity extends ContactsActivity implements DialogManager.DialogShowingViewActivity {
    public static final String ACTION_JOIN_COMPLETED = "joinCompleted";
    public static final String ACTION_SAVE_COMPLETED = "saveCompleted";
    private static final int DIALOG_NO_SAVE_EDIT_OTHER = 3;
    private static final int DIALOG_NO_SAVE_INSERT_OTHER = 2;
    private static final int DIALOG_YES_NO_SAVE = 1;
    public static final String INTENT_KEY_FINISH_ACTIVITY_ON_SAVE_COMPLETED = "finishActivityOnSaveCompleted";
    private static final String POSITION = "position";
    private static final String TAG = "ContactEditorActivity";
    private final int OPTYPE_DELETE;
    private final int OPTYPE_INSERT;
    private final int OPTYPE_UPDATE;
    OButtonGroup endButtonGroup;
    private String enter_from;
    private RoundCornerListView mAccountListView;
    private PopupWindow mAccountPopupWindow;
    private AccountTypeManager mAccountTypeManager;
    private AccountWithDataSet mDefalutAccount;
    private int mDefalutPosition;
    private DialogManager mDialogManager;
    private View mDoneButton;
    private EditContactsAccountPopWindowAdapter mEditContactsAccountAdapter;
    private ContactEditorUtils mEditorUtils;
    private boolean mFinishActivityOnSaveCompleted;
    private boolean mFinishAfterDialogDismiss;
    private ContactEditorFragment mFragment;
    private final ContactEditorFragment.Listener mFragmentListener;
    private long[] mIds;
    private InsertContactAccountPopWindowAdapter mInsertContactAccountAdapter;
    private OFloatingTitleBar mTitleBar;
    private OAlertDialog oAlertDialog;

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_android_contacts_activities_ContactEditorActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_contacts_activities_ContactEditorActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_activities_ContactEditorActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        com_android_contacts_activities_ContactEditorActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_contacts_activities_ContactEditorActivity_com_obric_privacyhook_PrivacyHook_onPause(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    public ContactEditorActivity() {
        this.mDialogManager = new DialogManager(this);
        this.OPTYPE_INSERT = 0;
        this.OPTYPE_UPDATE = 1;
        this.OPTYPE_DELETE = 2;
        this.mDefalutPosition = -1;
        this.enter_from = "";
        this.mFragmentListener = new AnonymousClass7(this);
    }

    static /* synthetic */ ContactEditorFragment access$000(ContactEditorActivity r0) {
        return r0.mFragment;
    }

    static /* synthetic */ void access$100(ContactEditorActivity r0) {
        r0.hideSoftKeyboard();
    }

    static /* synthetic */ View access$1000(ContactEditorActivity r0) {
        return r0.mDoneButton;
    }

    static /* synthetic */ long[] access$1100(ContactEditorActivity r0) {
        return r0.mIds;
    }

    static /* synthetic */ boolean access$1200(ContactEditorActivity r0) {
        return r0.mFinishActivityOnSaveCompleted;
    }

    static /* synthetic */ AccountTypeManager access$1300(ContactEditorActivity r0) {
        return r0.mAccountTypeManager;
    }

    static /* synthetic */ String access$1400(ContactEditorActivity r0, boolean r1, boolean r2) {
        return r0.setTitleByType(r1, r2);
    }

    static /* synthetic */ AccountWithDataSet access$1500(ContactEditorActivity r0) {
        return r0.mDefalutAccount;
    }

    static /* synthetic */ boolean access$200(ContactEditorActivity r0) {
        return r0.mFinishAfterDialogDismiss;
    }

    static /* synthetic */ boolean access$202(ContactEditorActivity r0, boolean r1) {
        r0.mFinishAfterDialogDismiss = r1;
        return r1;
    }

    static /* synthetic */ InsertContactAccountPopWindowAdapter access$300(ContactEditorActivity r0) {
        return r0.mInsertContactAccountAdapter;
    }

    static /* synthetic */ OFloatingTitleBar access$400(ContactEditorActivity r0) {
        return r0.mTitleBar;
    }

    static /* synthetic */ PopupWindow access$500(ContactEditorActivity r0) {
        return r0.mAccountPopupWindow;
    }

    static /* synthetic */ ContactEditorUtils access$600(ContactEditorActivity r0) {
        return r0.mEditorUtils;
    }

    static /* synthetic */ EditContactsAccountPopWindowAdapter access$700(ContactEditorActivity r0) {
        return r0.mEditContactsAccountAdapter;
    }

    static /* synthetic */ EditContactsAccountPopWindowAdapter access$702(ContactEditorActivity r0, EditContactsAccountPopWindowAdapter r1) {
        r0.mEditContactsAccountAdapter = r1;
        return r1;
    }

    static /* synthetic */ int access$800(ContactEditorActivity r0) {
        return r0.mDefalutPosition;
    }

    static /* synthetic */ int access$802(ContactEditorActivity r0, int r1) {
        r0.mDefalutPosition = r1;
        return r1;
    }

    static /* synthetic */ OAlertDialog access$902(ContactEditorActivity r0, OAlertDialog r1) {
        r0.oAlertDialog = r1;
        return r1;
    }

    public void com_android_contacts_activities_ContactEditorActivity__onCreate$___twin___(Bundle r7) {
        if (r7 != null) goto L4;
        TransitionAnimHelper.overrideEnterAnim(this, TransitionAnimStyle.Modal);
    L4:
        super.onCreate(r7);
        final Intent r8 = getIntent();
        String r0 = r8.getAction();
        this.mAccountTypeManager = AccountTypeManager.getInstance(this);
        this.mEditorUtils = ContactEditorUtils.getInstance(this);
        this.mIds = IntentUtils.getLongArrayExtra(r8, CallDetailActivity.EXTRA_CALL_LOG_IDS);
        this.mFinishActivityOnSaveCompleted = r8.getBooleanExtra(INTENT_KEY_FINISH_ACTIVITY_ON_SAVE_COMPLETED, false);
        this.enter_from = r8.getStringExtra("enter_from");
        if (ACTION_JOIN_COMPLETED.equals(r0) == false) goto L7;
    L21:
        finish();
        return;
    L7:
        if (ACTION_SAVE_COMPLETED.equals(r0) == true) goto L21;
        requestWindowFeature(1);
        setContentView(R.layout.contact_editor_activity);
        getImmersive().setTypeMask(getImmersive().getTypeMask() | WindowInsetsCompat.Type.ime());
        UiUtils.setWindowColorStatusBar(this);
        this.mTitleBar = (OFloatingTitleBar) findViewById(R.id.otitlebar);
        OFloatingTitleBarHolder r1 = new OFloatingTitleBarHolder(this.mTitleBar);
        this.mDoneButton = r1.addEndAction("rightButton", R.drawable.standard_icon_complete_selector_22_white, new AnonymousClass1(this));
        this.endButtonGroup = r1.getEndButtonGroup();
        if ("android.intent.action.INSERT".equals(r0) == false) goto L15;
        OButtonGroup r3 = this.endButtonGroup;
        if (r3 == null) goto L14;
        r3.setEnabled(false);
    L14:
        this.mDoneButton.setClickable(false);
    L15:
        this.mTitleBar.setEndButtonGroupStyle(2131952329);
        r1.addStartAction("leftButton", R.drawable.icon_cancel_22_22, new AnonymousClass2(this, r8));
        ContactEditorFragment r2 = (ContactEditorFragment) getSupportFragmentManager().findFragmentById(R.id.contact_editor_fragment);
        this.mFragment = r2;
        r2.setListener(this.mFragmentListener);
        if ("android.intent.action.EDIT".equals(r0) == false) goto L18;
        Uri r4 = r8.getData();
    L19:
        this.mFragment.load(r0, r4, r8.getExtras());
        EventTrackerManager.INSTANCE.track(new ContactPageShowEvent(this.enter_from, TAG, "", ""));
        return;
    L18:
        r4 = null;
        goto L19
    }

    private void initAccountPopupWindow() {
        if (this.mAccountPopupWindow != null) goto L6;
        View r0 = LayoutInflater.from(this).inflate(R.layout.contact_edit_title_accounts_popup_window, null);
        RoundCornerListView r1 = (RoundCornerListView) r0.findViewById(R.id.listview);
        this.mAccountListView = r1;
        r1.setParentBackgroundResource(R.drawable.edit_account_popup_normal, R.drawable.edit_account_popup_pressed);
        PopupWindow r2 = new PopupWindow(r0, -1, -2);
        this.mAccountPopupWindow = r2;
        r2.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        this.mAccountPopupWindow.setOutsideTouchable(true);
        this.mAccountPopupWindow.setFocusable(true);
        return;
    }

    public void com_android_contacts_activities_ContactEditorActivity__finish$___twin___() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Modal);
    }

    public void com_android_contacts_activities_ContactEditorActivity__onNewIntent$___twin___(Intent r4) {
        super.onNewIntent(r4);
        if (this.mFragment != null) goto L5;
        return;
    L5:
        this.mIds = getIntent().getLongArrayExtra(CallDetailActivity.EXTRA_CALL_LOG_IDS);
        String r0 = r4.getAction();
        if ("android.intent.action.EDIT".equals(r0) == false) goto L9;
        this.mFragment.setIntentExtras(r4.getExtras());
        return;
    L9:
        if (ACTION_SAVE_COMPLETED.equals(r0) == false) goto L12;
        this.mFragment.onSaveCompleted(true, r4.getIntExtra("saveMode", 0), r4.getBooleanExtra(ContactSaveService.EXTRA_SAVE_SUCCEEDED, false), r4.getData());
        return;
    L12:
        if (ACTION_JOIN_COMPLETED.equals(r0) == false) goto L17;
        this.mFragment.onJoinCompleted(r4.getData());
        return;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r4, Bundle r5) {
        if (r5 == null) goto L5;
        int r1 = r5.getInt(POSITION);
    L7:
        if (DialogManager.isManagedId(r4) == false) goto L11;
        return this.mDialogManager.onCreateDialog(r4, r5);
    L11:
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L21;
        if (r4 == 3) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Unknown dialog requested, id: " + r4 + ", args: " + r5);
        return null;
    L19:
        return getNoSaveDialog(3, r1);
    L21:
        return getNoSaveDialog(2, r1);
    L23:
        return getNoSaveDialog(1, -1);
    L5:
        r1 = -1;
        goto L7
    }

    private Dialog getNoSaveDialog(int r12, final int r13) {
        if (r12 != 1) goto L7;
        String r14 = getString(R.string.cancel_confirmation_dialog_message);
        String r15 = getString(R.string.common_ok);
        String r0 = getString(R.string.common_cancel);
        DialogInterface.OnClickListener r1 = new AnonymousClass3(this);
        String r3 = r14;
        String r5 = r15;
        String r8 = r0;
    L5:
        DialogInterface.OnClickListener r6 = r1;
    L14:
        OAlertDialog r16 = OAlertDialogUtils.showConfirmationDialog(this, r3, null, r5, r6, ButtonStyleController.TextColorType.Negative, r8, null, null);
        this.oAlertDialog = r16;
        r16.setOnDismissListener(new AnonymousClass6(this));
        return this.oAlertDialog;
    L7:
        if (r12 != 2) goto L11;
        String r17 = getString(R.string.cancel_confirmation_dialog_message);
        String r2 = getString(R.string.common_ok);
        String r4 = getString(R.string.common_cancel);
        DialogInterface.OnClickListener r7 = new AnonymousClass4(this, r13);
    L9:
        r3 = r17;
        r5 = r2;
        r8 = r4;
        r6 = r7;
        goto L14
    L11:
        if (r12 != 3) goto L13;
        r17 = getString(R.string.cancel_confirmation_dialog_message);
        r2 = getString(R.string.common_ok);
        r4 = getString(R.string.common_cancel);
        r7 = new AnonymousClass5(this, r13);
        goto L9
    L13:
        r1 = null;
        r3 = "";
        r5 = r3;
        r8 = r5;
        goto L5
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mFragment.hasChanges() == false) goto L5;
    L8:
        showDialog(1);
        return;
    L5:
        if (this.mFragment.hasRingtoneChanged() == true) goto L8;
        super.onBackPressed();
    }

    private String setTitleByType(boolean r1, boolean r2) {
        if (r2 == false) goto L7;
        if (r1 == false) goto L6;
        return getResources().getString(R.string.new_profile);
    L6:
        return getResources().getString(R.string.edit_profile);
    L7:
        if (r1 == false) goto L10;
        return getResources().getString(R.string.new_local_contact);
    L10:
        return getResources().getString(R.string.edit_local_contact);
    }

    @Override // com.android.contacts.util.DialogManager.DialogShowingViewActivity
    public DialogManager getDialogManager() {
        return this.mDialogManager;
    }

    private void showInsertAccountList(View r3, final InsertContactAccountPopWindowAdapter r4) {
        initAccountPopupWindow();
        this.mAccountListView.setAdapter(r4);
        this.mAccountListView.setOnItemClickListener(new AnonymousClass8(this, r4));
        this.mAccountPopupWindow.showAsDropDown(r3, 0, -ContactsUtils.dipTopx(this, 6.0d));
        hideSoftKeyboard();
    }

    private void showEditAccountsList(View r3, EditContactsAccountPopWindowAdapter r4) {
        initAccountPopupWindow();
        this.mAccountListView.setAdapter(r4);
        this.mAccountListView.setOnItemClickListener(new AnonymousClass9(this));
        this.mAccountPopupWindow.showAsDropDown(r3, 0, -ContactsUtils.dipTopx(this, 6.0d));
        hideSoftKeyboard();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        if (r10 == 7) goto L17;
        if (r10 == 1002) goto L8;
        return;
    L8:
        if (r12 == null) goto L14;
        int r6 = r12.getIntExtra("opType", -1);
        long r4 = r12.getLongExtra("id", -1);
        int r3 = r12.getIntExtra("type", -1);
        String r13 = r12.getStringExtra("value");
        long r7 = r12.getLongExtra("entryContactId", -1);
        if (r13 != null) goto L13;
        r13 = "";
    L13:
        String r2 = r13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "memory wallet opType: " + r6 + " id:" + r4 + " type: " + r3 + " number: " + r2 + "entryContactId" + r7);
        updateCardViewState(r2, r3, r4, r6, r7);
        return;
    L14:
        if (r11 != (-1)) goto L25;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "memory wallet data is null, resultCode: " + r11);
        Toast.makeText(this, getString(R.string.composer_failed_to_get_database_infomation), 0).show();
        return;
    L25:
        return;
    L17:
        if (getWindow() != null) goto L19;
        return;
    L19:
        if (getWindow().getDecorView() != null) goto L21;
        return;
    L21:
        if (getWindow().getDecorView().getWindowToken() == null) goto L29;
        ContactsUtils.hideInputMethod(this, getWindow().getDecorView().getWindowToken());
        return;
    }

    private void updateCardViewState(String r7, int r8, long r9, int r11, long r12) {
        EntityDeltaList r0 = this.mFragment.getmState();
        EntityDelta r1 = r0.get(0);
        if (r11 != 0) goto L5;
    L18:
        Iterator<EntityDelta.ValuesDelta> r13 = r1.getMimeEntries("vnd.android.cursor.item/card_id").iterator();
    L20:
        if (r13.hasNext() == false) goto L36;
        EntityDelta.ValuesDelta r2 = r13.next();
        if (r12 != r2.getId().longValue()) goto L20;
        r2.put("data1", r7);
        r2.put(DBHelper.COL_DATA2, r8);
        r2.put(DBHelper.COL_DATA3, r9);
        this.mFragment.setmState(r0);
        return;
    L36:
        return;
    L5:
        if (r11 == 1) goto L18;
        if (r11 != 2) goto L34;
        Iterator<EntityDelta.ValuesDelta> r10 = r1.getMimeEntries("vnd.android.cursor.item/card_id").iterator();
    L11:
        if (r10.hasNext() == false) goto L35;
        EntityDelta.ValuesDelta r14 = r10.next();
        Long r15 = r14.getAsLong(DBHelper.COL_DATA3);
        if (r15 == null) goto L11;
        if (r15.longValue() != r9) goto L11;
        r14.put(DBHelper.COL_DATA3, -1);
        MemoryCardUtil.deleteCard(this, r15, r7, this.mFragment.getmCardIDsList());
        this.mFragment.setmState(r0);
        return;
    L35:
        return;
    }

    private void hideSoftKeyboard() {
        InputMethodManager r0 = (InputMethodManager) getSystemService("input_method");
        if (r0 == null) goto L11;
        View r2 = getWindow().getDecorView();
        if (r2.isInTouchMode() == true) goto L8;
        return;
    L8:
        if ((r2 instanceof ViewGroup) == false) goto L12;
        r0.hideSoftInputFromWindow(r2.getWindowToken(), 0);
        return;
    L12:
        return;
    }

    public void com_android_contacts_activities_ContactEditorActivity__onPause$___twin___() {
        super.onPause();
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onPause called~~");
        return;
    }

    public void com_android_contacts_activities_ContactEditorActivity__onDestroy$___twin___() {
        this.mFinishAfterDialogDismiss = false;
        OAlertDialog r0 = this.oAlertDialog;
        if (r0 == null) goto L8;
        r0.setOnDismissListener(null);
        if (this.oAlertDialog.isShowing() == false) goto L7;
        this.oAlertDialog.originDismiss();
    L7:
        this.oAlertDialog = null;
    L8:
        super.onDestroy();
        if (ContactsUtils.DEBUG == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onDestroy called~~");
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_ContactEditorActivity_com_obric_privacyhook_PrivacyHook_onCreate(ContactEditorActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_ContactEditorActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public static void com_android_contacts_activities_ContactEditorActivity_com_obric_privacyhook_PrivacyHook_onPause(ContactEditorActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r2.com_android_contacts_activities_ContactEditorActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_activities_ContactEditorActivity_com_obric_privacyhook_PrivacyHook_onDestroy(ContactEditorActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_activities_ContactEditorActivity__onDestroy$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_activities_ContactEditorActivity_com_obric_privacyhook_PrivacyHook_finish(ContactEditorActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_activities_ContactEditorActivity__finish$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onNewIntent")
    public static void com_android_contacts_activities_ContactEditorActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(ContactEditorActivity r2, Intent r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r3);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_ContactEditorActivity__onNewIntent$___twin___(r3);
    }
}
