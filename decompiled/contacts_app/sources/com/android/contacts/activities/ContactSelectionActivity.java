package com.android.contacts.activities;

import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.common.list.ContactEntryListFragment;
import com.android.contacts.detail.ContactDetailCallLogView;
import com.android.contacts.list.ContactsIntentResolver;
import com.android.contacts.list.ContactsRequest;
import com.android.contacts.list.EmailAddressPickerFragment;
import com.android.contacts.list.OnContactPickerActionListener;
import com.android.contacts.list.OnDataPickerActionListener;
import com.android.contacts.list.OnEmailAddressPickerActionListener;
import com.android.contacts.list.OnPostalAddressPickerActionListener;
import com.android.contacts.list.PostalAddressPickerFragment;
import com.android.contacts.list.SamContact;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.pick.CreateShortCallPhonePickerFragment;
import com.android.contacts.pick.CreateShortCutContactPickerFragment;
import com.android.contacts.pick.CreateShortSmsPhonePickerFragment;
import com.android.contacts.pick.InsertOrEditContactFragment;
import com.android.contacts.pick.MultiCalllogsPickerFragment;
import com.android.contacts.pick.MultiContactsPickerFragment;
import com.android.contacts.pick.MultiEmailsPickerFragment;
import com.android.contacts.pick.MultiPhonesPickerFragment;
import com.android.contacts.pick.MultiRawContactsPickerFragment;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.pick.SingleAddressPickerFragment;
import com.android.contacts.pick.SingleCalllogPickerFragment;
import com.android.contacts.pick.SingleContactPickerFragment;
import com.android.contacts.pick.SingleEmailPickerFragment;
import com.android.contacts.pick.SinglePhonePickerFragment;
import com.android.contacts.pick.UnFavoritedPhonesPickerFragment;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.UiUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.DialogUtils;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.CallScreenShowEvent;
import com.obric.tracker.event.ContactPageShowEvent;
import com.obric.utils.ViewAnimationUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.api.ContactContantsSmt;

/* JADX INFO: loaded from: classes.dex */
public class ContactSelectionActivity extends ContactsActivity implements View.OnCreateContextMenuListener, SearchView.OnQueryTextListener, View.OnClickListener, SearchView.OnCloseListener, View.OnFocusChangeListener {
    public static final String ACTION_BYTEDANCE_INSERT_OR_EDIT = "com.android.contact.activities.ContactSelectionActivity.bytedanceInsertOrEdit";
    public static final String ACTION_GET_PHONE_NUMS = "com.android.contact.activities.ContactSelectionActivity.getphoneNumbers";
    public static final String ACTION_PICK_EMAILS = "com.android.contact.activities.ContactSelectionActivity.pickEmails";
    public static final String ACTION_PICK_EMAILS_EXCEPT_SELECTED = "com.android.contact.activities.ContactSelectionActivity.pickEmailsExceptSelected";
    public static final String ACTION_PICK_UNFAVORITE_NUMS = "com.android.contact.activities.ContactSelectionActivity.pickNumbers";
    private static final String ACTIVITY_OPTS = "activity_options";
    private static final int DEFAULT_DIRECTORY_RESULT_LIMIT = 20;
    private static final int FOCUS_DELAY = 200;
    public static final String INTENT_EXTRA_RESULT_CODE = "contact_selection_intent_extra_result_code";
    private static final String KEY_ACTION_CODE = "actionCode";
    public static final int SUBACTIVITY_ADD_TO_EXISTING_CONTACT = 0;
    private static final int SUBACTIVITY_EDIT_GROUP = 2;
    private static final String TAG = "ContactSelectionActivity";
    private final int CONTEXTMENU_COPYTEXT;
    private String enter_from;
    private boolean isFinish;
    private boolean isFromSearch;
    private int mActionCode;
    private View mActionsViewContainer;
    private String mBroadcastAction;
    private OListItemGeneral mBtnAddNewContact;
    private OListItemGeneral mBtnAddToContact;
    private RelativeLayout mBtnCall;
    private OButton mBtnDone;
    private FrameLayout mBtnMakeCall;
    private FrameLayout mBtnSendMes;
    private ContactDetailCallLogView mCallloogFrame;
    private TextView mData;
    private ViewGroup mFlagActionView;
    private ViewGroup mFlagView;
    private RelativeLayout mInfoView;
    private ViewStub mInfoViewViewStub;
    private Intent mIntent;
    private ContactsIntentResolver mIntentResolver;
    private boolean mIsNum;
    protected ContactEntryListFragment<?> mListFragment;
    private TextView mName;
    String mNum;
    PickerFragment mPickerFragment;
    private PreferencesCallback mPreferencesCallback;
    private ContactsRequest mRequest;
    private SearchView mSearchView;
    private ArrayList<SamContact> mSecletedContacts;
    private ArrayList<Long> mSecletedPhoneIds;
    private TextView mType;

    private final class ContactPickerActionListener implements OnContactPickerActionListener {
        final /* synthetic */ ContactSelectionActivity this$0;

        private ContactPickerActionListener(ContactSelectionActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ContactPickerActionListener(ContactSelectionActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.contacts.list.OnContactPickerActionListener
        public void onCreateNewContactAction() {
            ContactSelectionActivity.access$900(this.this$0);
        }

        @Override // com.android.contacts.list.OnContactPickerActionListener
        public void onEditContactAction(Uri r5) {
            Bundle r0 = this.this$0.getIntent().getExtras();
            if (launchAddToContactDialog(r0) == false) goto L8;
            Intent r1 = new Intent(this.this$0, ConfirmAddDetailActivity.class);
            r1.setData(r5);
            if (r0 == null) goto L7;
            r1.putExtras(r0);
        L7:
            this.this$0.startActivityForResult(r1, 0);
            return;
        L8:
            this.this$0.startActivityAndForwardResult(new Intent("android.intent.action.EDIT", r5));
        }

        @Override // com.android.contacts.list.OnContactPickerActionListener
        public void onPickContactAction(Uri r1) {
            this.this$0.returnPickerResult(r1);
        }

        @Override // com.android.contacts.list.OnContactPickerActionListener
        public void onShortcutIntentCreated(Intent r1) {
            this.this$0.returnPickerResult(r1);
        }

        private boolean launchAddToContactDialog(Bundle r6) {
            if (r6 != null) goto L5;
            return false;
        L5:
            Set<String> r7 = r6.keySet();
            int r0 = r7.size();
            if (r0 == 2) goto L8;
            if (r0 == 1) goto L25;
            return false;
        L25:
            if (r7.contains("phone") == true) goto L29;
            if (r7.contains("email") == true) goto L29;
            return false;
        L29:
            return true;
        L8:
            if (r7.contains("phone") == true) goto L10;
        L12:
            boolean r1 = false;
        L14:
            if (r7.contains("email") == true) goto L16;
        L18:
            boolean r8 = false;
        L19:
            if (r1 == true) goto L22;
            if (r8 == true) goto L22;
            return false;
        L22:
            return true;
        L16:
            if (r7.contains("email_type") == false) goto L18;
            r8 = true;
            goto L19
        L10:
            if (r7.contains("phone_type") == false) goto L12;
            r1 = true;
            goto L14
        }
    }

    private final class EmailAddressPickerActionListener implements OnEmailAddressPickerActionListener {
        final /* synthetic */ ContactSelectionActivity this$0;

        private EmailAddressPickerActionListener(ContactSelectionActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EmailAddressPickerActionListener(ContactSelectionActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.contacts.list.OnEmailAddressPickerActionListener
        public void onPickEmailAddressAction(Uri r1) {
            this.this$0.returnPickerResult(r1);
        }
    }

    private final class PhoneNumbersPickerActionListener implements OnDataPickerActionListener {
        final /* synthetic */ ContactSelectionActivity this$0;

        private PhoneNumbersPickerActionListener(ContactSelectionActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PhoneNumbersPickerActionListener(ContactSelectionActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.contacts.list.OnDataPickerActionListener
        public void onPickDataAction(Uri r1) {
            this.this$0.returnPickerResult(r1);
        }

        @Override // com.android.contacts.list.OnDataPickerActionListener
        public void onShortcutIntentCreated(Intent r1) {
            this.this$0.returnPickerResult(r1);
        }

        @Override // com.android.contacts.list.OnDataPickerActionListener
        public void onHomeInActionBarSelected() {
            this.this$0.onBackPressed();
        }

        @Override // com.android.contacts.list.OnDataPickerActionListener
        public void onPickDatasAction(Uri r1, ArrayList<Long> r2) {
            this.this$0.returnPickerResult(r1, r2);
        }

        @Override // com.android.contacts.list.OnDataPickerActionListener
        public void onPickunStarredNumsAction(ArrayList<String> r3) {
            Intent r0 = new Intent();
            r0.putStringArrayListExtra("com.android.contacts.extra.PHONE_URIS", r3);
            this.this$0.returnPickerResult(r0);
        }

        @Override // com.android.contacts.list.OnDataPickerActionListener
        public void onPickNumberArray(String[] r1) {
            this.this$0.returnPickerNumberArray(r1);
        }
    }

    private final class PostalAddressPickerActionListener implements OnPostalAddressPickerActionListener {
        final /* synthetic */ ContactSelectionActivity this$0;

        private PostalAddressPickerActionListener(ContactSelectionActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PostalAddressPickerActionListener(ContactSelectionActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.contacts.list.OnPostalAddressPickerActionListener
        public void onPickPostalAddressAction(Uri r1) {
            this.this$0.returnPickerResult(r1);
        }
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_android_contacts_activities_ContactSelectionActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_ContactSelectionActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_activities_ContactSelectionActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String r1) {
        return false;
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_contacts_activities_ContactSelectionActivity_com_obric_privacyhook_PrivacyHook_onStart(this);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_contacts_activities_ContactSelectionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    static /* synthetic */ boolean access$1002(ContactSelectionActivity r0, boolean r1) {
        r0.isFinish = r1;
        return r1;
    }

    static /* synthetic */ int access$200(ContactSelectionActivity r0) {
        return r0.mDisplayOrder;
    }

    static /* synthetic */ int access$300(ContactSelectionActivity r0) {
        return r0.mSortOrder;
    }

    static /* synthetic */ TextView access$400(ContactSelectionActivity r0) {
        return r0.mData;
    }

    static /* synthetic */ void access$500(ContactSelectionActivity r0, String r1) {
        r0.copyToClipboard(r1);
    }

    static /* synthetic */ TextView access$600(ContactSelectionActivity r0) {
        return r0.mType;
    }

    static /* synthetic */ void access$900(ContactSelectionActivity r0) {
        r0.startCreateNewContactActivity();
    }

    public ContactSelectionActivity() {
        this.mActionCode = -1;
        this.mSecletedContacts = new ArrayList();
        this.mSecletedPhoneIds = new ArrayList();
        this.mInfoView = null;
        this.mInfoViewViewStub = null;
        this.mIsNum = true;
        this.CONTEXTMENU_COPYTEXT = 0;
        this.isFromSearch = false;
        this.mPreferencesCallback = new AnonymousClass1(this);
        this.isFinish = false;
        this.mIntentResolver = new ContactsIntentResolver(this);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment r2) {
        if ((r2 instanceof ContactEntryListFragment) == false) goto L6;
        this.mListFragment = (ContactEntryListFragment) r2;
        setupActionListener();
        return;
    }

    public void com_android_contacts_activities_ContactSelectionActivity__onCreate$___twin___(Bundle r5) {
        overridePendingTransition(0, 0);
        super.onCreate(r5);
        if (r5 == null) goto L5;
        this.mActionCode = r5.getInt(KEY_ACTION_CODE);
    L5:
        this.mRequest = this.mIntentResolver.resolveIntent(getIntent());
        Intent r6 = getIntent();
        this.mIntent = r6;
        this.mBroadcastAction = r6.getStringExtra("broadcast_action");
        this.enter_from = this.mIntent.getStringExtra("enter_from");
        if (this.mRequest.isValid() == true) goto L9;
        setResult(0);
        finish();
        return;
    L9:
        Intent r7 = this.mRequest.getRedirectIntent();
        if (r7 == null) goto L13;
        startActivity(r7);
        finish();
        return;
    L13:
        configureActivityTitle();
        setContentView(R.layout.contact_picker);
        UiUtils.setWindowColorStatusBar(this);
        setInfoView();
        this.mActionCode = this.mRequest.getActionCode();
        if (ContactsUtils.DEBUG == false) goto L28;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "mActionCode: " + this.mActionCode);
    L28:
        configureListFragment();     // Catch: Exception -> L18
    L20:
        Intent r8 = getIntent();
        if (r8 == null) goto L23;
        this.isFromSearch = r8.getBooleanExtra("from_search", false);
    L23:
        DialogUtils.clearDimBeforeDialogShow(this);
        this.mFlagView = (ViewGroup) findViewById(R.id.contact_flag_view);
        this.mFlagActionView = (ViewGroup) findViewById(R.id.contacts_flag_action_container);
        if (OMaterialHelper.isMaterialEffectEnabled(this) == false) goto L26;
        OMaterialHelper.setMaterialsFromWindow(this.mFlagActionView, MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!isDarkTheme())));
        this.mFlagActionView.setBackgroundColor(0);
    L26:
        ViewAnimationUtils.INSTANCE.showPageAnimationWithBGAlpha(this.mFlagView, this.mFlagActionView, ContextCompat.getColor(getBaseContext(), R.color.oui_advanced_scrim_sheet));
        EventTrackerManager.INSTANCE.track(new ContactPageShowEvent(this.enter_from, "ContactPicker", "", ""));
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        finish();
        goto L20
    }

    public boolean isFromSearch() {
        return this.isFromSearch;
    }

    public void com_android_contacts_activities_ContactSelectionActivity__onStart$___twin___() {
        super.onStart();
        if (isPreferencesChanged() == false) goto L8;
        PickerFragment r1 = this.mPickerFragment;
        if (r1 == null) goto L9;
        r1.onPreferencesChanged();
        return;
    L9:
        return;
    }

    private boolean shouldShowCreateNewContactButton() {
        int r0 = this.mActionCode;
        if (r0 != 80) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 70) goto L7;
    L9:
        return false;
    L7:
        if (this.mRequest.isSearchMode() == true) goto L9;
        goto L9
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putInt(KEY_ACTION_CODE, this.mActionCode);
    }

    private void configureActivityTitle() {
        if (this.mRequest.getActivityTitle() == null) goto L6;
        setTitle(this.mRequest.getActivityTitle());
        return;
    L6:
        int r0 = this.mRequest.getActionCode();
        if (r0 != 60) goto L9;
        setTitle(R.string.contactPickerActivityTitle);
        return;
    L9:
        if (r0 != 70) goto L11;
        setTitle(R.string.contactPickerActivityTitle);
        return;
    L11:
        if (r0 != 80) goto L13;
        setTitle(R.string.contactPickerActivityTitle);
        return;
    L13:
        if (r0 != 90) goto L15;
        setTitle(R.string.contactPickerActivityTitle);
        return;
    L15:
        if (r0 != 100) goto L17;
        setTitle(R.string.contactPickerActivityTitle);
        return;
    L17:
        if (r0 != 105) goto L19;
        setTitle(R.string.contactPickerActivityTitle);
        return;
    L19:
        if (r0 != 110) goto L21;
        setTitle(R.string.shortcutActivityTitle);
        return;
    L21:
        if (r0 != 120) goto L23;
        setTitle(R.string.callShortcutActivityTitle);
        return;
    L23:
        if (r0 == 130) goto L25;
        setTitle(R.string.contactPickerActivityTitle);
        return;
    L25:
        setTitle(R.string.messageShortcutActivityTitle);
    }

    public void configureListFragment() {
        int r0 = this.mActionCode;
        AnonymousClass1 r3 = null;
        if (r0 != 10) goto L5;
        this.mPickerFragment = new SingleContactPickerFragment();
        Intent r1 = getIntent();
        if (r1 == null) goto L78;
        r1.putExtra(INTENT_EXTRA_RESULT_CODE, 10);
        this.mPickerFragment.setBundle(r1.getExtras());
    L78:
        this.mPickerFragment.setContactPickerActionListener(new ContactPickerActionListener(this, r3));
    L79:
        PickerFragment r2 = this.mPickerFragment;
        if (r2 == null) goto L82;
        r2.setLegacyCompatibilityMode(this.mRequest.isLegacyCompatibilityMode());
        getSupportFragmentManager().beginTransaction().replace(R.id.list_container, this.mPickerFragment).commit();
    L82:
        PickerFragment r4 = this.mPickerFragment;
        if (r4 == null) goto L86;
        r4.setPrefsCallback(this.mPreferencesCallback);
        this.mPickerFragment.getView().setBackgroundColor(0);
        return;
    L86:
        return;
    L5:
        if (r0 != 65) goto L7;
        UnFavoritedPhonesPickerFragment r5 = new UnFavoritedPhonesPickerFragment();
        this.mPickerFragment = r5;
        r5.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        goto L79
    L7:
        if (r0 != 70) goto L9;
        SingleContactPickerFragment r6 = new SingleContactPickerFragment();
        this.mPickerFragment = r6;
        r6.setContactPickerActionListener(new ContactPickerActionListener(this, r3));
        goto L79
    L9:
        if (r0 != 80) goto L11;
        InsertOrEditContactFragment r7 = new InsertOrEditContactFragment();
        r7.setCreateContactEnabled(true);
        this.mPickerFragment = r7;
        r7.setBundle(getIntent().getExtras());
        this.mPickerFragment.setContactPickerActionListener(new ContactPickerActionListener(this, r3));
        goto L79
    L11:
        if (r0 != 90) goto L13;
        SinglePhonePickerFragment r8 = new SinglePhonePickerFragment();
        this.mPickerFragment = r8;
        r8.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        goto L79
    L13:
        if (r0 != 105) goto L15;
        SingleEmailPickerFragment r9 = new SingleEmailPickerFragment();
        this.mPickerFragment = r9;
        r9.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        goto L79
    L15:
        if (r0 != 110) goto L17;
        this.mPickerFragment = new CreateShortCutContactPickerFragment();
        goto L79
    L17:
        if (r0 == 117) goto L66;
        if (r0 != 120) goto L21;
        this.mPickerFragment = new CreateShortCallPhonePickerFragment();
        goto L79
    L21:
        if (r0 != 130) goto L23;
        this.mPickerFragment = new CreateShortSmsPhonePickerFragment();
        goto L79
    L23:
        if (r0 != 95) goto L25;
        MultiPhonesPickerFragment r10 = new MultiPhonesPickerFragment();
        this.mPickerFragment = r10;
        r10.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        goto L79
    L25:
        if (r0 != 96) goto L27;
        MultiPhonesPickerFragment r11 = new MultiPhonesPickerFragment();
        this.mPickerFragment = r11;
        r11.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        if (getIntent().getExtras() == null) goto L79;
        ArrayList r12 = (ArrayList) getIntent().getExtra("com.android.contacts.extra.PHONE_IDS");
        if (r12 == null) goto L79;
        this.mPickerFragment.getSelectedIds().addAll(r12);
        goto L79
    L27:
        if (r0 != 150) goto L29;
        MultiCalllogsPickerFragment r13 = new MultiCalllogsPickerFragment();
        this.mPickerFragment = r13;
        r13.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        goto L79
    L29:
        if (r0 == 151) goto L55;
        switch(r0) {
            case 60: goto L54;
            case 61: goto L49;
            case 62: goto L48;
            default: goto L31;
        };
    L31:
        switch(r0) {
            case 100: goto L47;
            case 101: goto L42;
            case 102: goto L35;
            default: goto L33;
        };
    L42:
        MultiEmailsPickerFragment r14 = new MultiEmailsPickerFragment();
        this.mPickerFragment = r14;
        r14.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        if (getIntent().getExtras() == null) goto L79;
        ArrayList r15 = (ArrayList) getIntent().getExtra("com.android.contacts.extra.PHONE_IDS");
        if (r15 == null) goto L79;
        this.mPickerFragment.getSelectedIds().addAll(r15);
        goto L79
    L47:
        SingleAddressPickerFragment r16 = new SingleAddressPickerFragment();
        this.mPickerFragment = r16;
        r16.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        goto L79
    L33:
        throw new IllegalStateException("Invalid action code: " + this.mActionCode);
    L35:
        if (getIntent().getExtras() == null) goto L40;
        ArrayList r17 = (ArrayList) getIntent().getExtra("com.android.contacts.extra.PHONE_IDS");
        ArrayList r18 = new ArrayList();
        if (r17 == null) goto L39;
        r18.addAll(r17);
    L39:
        this.mPickerFragment = new MultiEmailsPickerFragment(r18);
    L41:
        this.mPickerFragment.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        goto L79
    L40:
        this.mPickerFragment = new MultiEmailsPickerFragment();
        goto L41
    L48:
        MultiRawContactsPickerFragment r19 = new MultiRawContactsPickerFragment(getIntent());
        this.mPickerFragment = r19;
        r19.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        goto L79
    L49:
        MultiContactsPickerFragment r20 = new MultiContactsPickerFragment();
        this.mPickerFragment = r20;
        r20.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        if (getIntent().getExtras() == null) goto L79;
        ArrayList r21 = (ArrayList) getIntent().getExtra("com.android.contacts.extra.PHONE_IDS");
        if (r21 == null) goto L79;
        this.mPickerFragment.getSelectedIds().addAll(r21);
        goto L79
    L54:
        SingleContactPickerFragment r22 = new SingleContactPickerFragment();
        this.mPickerFragment = r22;
        r22.setContactPickerActionListener(new ContactPickerActionListener(this, r3));
        goto L79
    L55:
        SingleCalllogPickerFragment r23 = new SingleCalllogPickerFragment();
        this.mPickerFragment = r23;
        r23.setOnPhoneNumberPickerActionListener(new PhoneNumbersPickerActionListener(this, r3));
        goto L79
    L66:
        if (this.mInfoView != null) goto L68;
        initInfoView();
    L68:
        this.mInfoView.setVisibility(0);
        setupInfoData();
        goto L79
    }

    public void com_android_contacts_activities_ContactSelectionActivity__onStop$___twin___() {
        super.onStop();
        PickerFragment r0 = this.mPickerFragment;
        if (r0 != null) goto L5;
    L18:
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        if ("com.obric.nodisturb".equals(getCallingPackage()) == false) goto L10;
    L13:
        finish();     // Catch: Exception -> L15
        return;
    L10:
        if (getCallingActivity() != null) goto L12;
        return;
    L12:
        if (getCallingActivity().getClassName() != null) goto L13;
        return;
    L5:
        if (r0.isSearch() == false) goto L18;
        this.mPickerFragment.cancelSearch(false);
        goto L18
    }

    private void initInfoView() {
        if (this.mInfoView != null) goto L6;
        this.mInfoViewViewStub.inflate();
        this.mInfoView = (RelativeLayout) findViewById(R.id.info_view);
        this.mActionsViewContainer = findViewById(R.id.primary_action_view);
        this.mInfoView.setVisibility(8);
        ContactDetailCallLogView r0 = (ContactDetailCallLogView) findViewById(R.id.detail_call_log_view);
        this.mCallloogFrame = r0;
        r0.setVisibility(8);
        this.mName = (TextView) findViewById(R.id.name);
        this.mData = (TextView) findViewById(R.id.data);
        this.mType = (TextView) findViewById(R.id.type);
        OButton r1 = ((OCTitleBar) findViewById(R.id.otitlebar)).mLeftActionBack;
        this.mBtnDone = r1;
        r1.setOnClickListener(new AnonymousClass2(this));
        RelativeLayout r2 = (RelativeLayout) findViewById(R.id.actions_view_container);
        this.mBtnCall = r2;
        r2.setOnClickListener(this);
        this.mBtnCall.setBackgroundResource(R.drawable.o_background_list_item);
        this.mBtnCall.setOnLongClickListener(new AnonymousClass3(this));
        FrameLayout r3 = (FrameLayout) findViewById(R.id.secondary_action_view_container);
        this.mBtnSendMes = r3;
        r3.setOnClickListener(this);
        FrameLayout r4 = (FrameLayout) findViewById(R.id.thirdly_action_view_container);
        this.mBtnMakeCall = r4;
        r4.setOnClickListener(this);
        OListItemGeneral r5 = (OListItemGeneral) findViewById(R.id.btn_add_new_contact);
        this.mBtnAddNewContact = r5;
        r5.setOnClickListener(this);
        OListItemGeneral r6 = (OListItemGeneral) findViewById(R.id.btn_add_to_contacts);
        this.mBtnAddToContact = r6;
        r6.setOnClickListener(this);
        return;
    }

    public void setInfoView() {
        this.mInfoViewViewStub = (ViewStub) findViewById(R.id.info_view_stubview);
    }

    public void setupInfoData() {
        this.mNum = this.mIntent.getStringExtra("phone");
        String r0 = this.mIntent.getStringExtra("name");
        if (TextUtils.isEmpty(r0) == false) goto L5;
        r0 = this.mNum;
    L5:
        this.mIsNum = !Telephony.Mms.isEmailAddress(this.mNum);
        this.mName.setText(r0);
        if (this.mIsNum == false) goto L8;
        NumberInfosManager.getInstance().getBaseAndMarkInfosAsync(this.mNum, new AnonymousClass4(this));
    L9:
        this.mData.setText(this.mNum);
        return;
    L8:
        this.mType.setVisibility(8);
        this.mBtnSendMes.setVisibility(8);
        this.mBtnMakeCall.setVisibility(8);
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) this.mActionsViewContainer.getLayoutParams();
        r1.width = -1;
        r1.rightMargin = (int) getResources().getDimension(R.dimen.detail_sparator_title_margin_left);
        goto L9
    }

    private void copyToClipboard(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return;
    L6:
        if (this.mIsNum == false) goto L8;
        String[] r0 = {"vnd.android.cursor.item/phone_v2"};
    L9:
        ContactsUtils.showCopyToClipboardDialog(this, null, r0, r4, false);
        return;
    L8:
        r0 = new String[]{"vnd.android.cursor.item/email_v2"};
        goto L9
    }

    public void setupActionListener() {
        ContactEntryListFragment<?> r0 = this.mListFragment;
        AnonymousClass1 r2 = null;
        if ((r0 instanceof PostalAddressPickerFragment) == false) goto L6;
        ((PostalAddressPickerFragment) r0).setOnPostalAddressPickerActionListener(new PostalAddressPickerActionListener(this, r2));
        return;
    L6:
        if ((r0 instanceof EmailAddressPickerFragment) == false) goto L10;
        ((EmailAddressPickerFragment) r0).setOnEmailAddressPickerActionListener(new EmailAddressPickerActionListener(this, r2));
        return;
    L10:
        throw new IllegalStateException("Unsupported list fragment type: " + this.mListFragment);
    }

    public void startActivityAndForwardResult(Intent r2) {
        r2.setFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        Bundle r0 = getIntent().getExtras();
        checkTypeError(r0);
        if (r0 == null) goto L5;
        r2.putExtras(r0);
    L5:
        startActivity(r2);
        finish();
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String r2) {
        this.mListFragment.setQueryString(r2, true);
        return false;
    }

    @Override // android.widget.SearchView.OnCloseListener
    public boolean onClose() {
        if (TextUtils.isEmpty(this.mSearchView.getQuery()) == true) goto L5;
        this.mSearchView.setQuery(null, true);
    L5:
        return true;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View r2, boolean r3) {
        if (r2.getId() != R.id.search_view) goto L9;
        if (r3 == false) goto L8;
        showInputMethod(this.mSearchView.findFocus());
        return;
    L8:
        return;
    }

    public void returnPickerResult(Uri r2) {
        Intent r0 = new Intent();
        r0.setData(r2);
        if (TextUtils.isEmpty(this.mBroadcastAction) == true) goto L5;
        r0.setAction(this.mBroadcastAction);
        sendBroadcast(r0);
        return;
    L5:
        returnPickerResult(r0);
    }

    public void returnPickerResult(Uri r3, ArrayList<Long> r4) {
        Intent r0 = new Intent();
        r0.putExtra("com.android.contacts.extra.PHONE_IDS", r4);
        r0.putExtra(ContactContantsSmt.BASE_URI, r3.toString());
        returnPickerResult(r0);
    }

    public void returnPickerNumberArray(String[] r3) {
        Intent r0 = new Intent();
        r0.putExtra("com.android.contacts.extra.PHONE_URIS", r3);
        returnPickerResult(r0);
    }

    public void returnPickerResult(Intent r2) {
        r2.setFlags(1);
        setResult(-1, r2);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        AnonymousClass1 r0 = null;
        switch(r6.getId()) {
            case 2131361943: goto L13;
            case 2131362097: goto L11;
            case 2131362099: goto L7;
            case 2131362103: goto L6;
            case 2131363531: goto L5;
            case 2131363787: goto L13;
            default: goto L26;
        };
    L5:
        startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + this.mNum)));
        AnimationUtil.switchActivityAnimation(this, 1);
        return;
    L6:
        finish();
        return;
    L7:
        Bundle r7 = getIntent().getExtras();
        checkTypeError(r7);
        RelativeLayout r1 = this.mInfoView;
        if (r1 == null) goto L10;
        r1.setVisibility(8);
    L10:
        InsertOrEditContactFragment r2 = new InsertOrEditContactFragment();
        this.mPickerFragment = r2;
        r2.setBundle(r7);
        this.mPickerFragment.setContactPickerActionListener(new ContactPickerActionListener(this, r0));
        getSupportFragmentManager().beginTransaction().replace(R.id.list_container, this.mPickerFragment).commitAllowingStateLoss();
        return;
    L11:
        startCreateNewContactActivity();
        return;
    L26:
        return;
    L13:
        if (this.mIsNum == true) goto L15;
        Intent r8 = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", this.mNum, null));
        r8.setPackage(Constants.EMAIL_PACKAGE_NAME);
        startActivity(r8);
        AnimationUtil.switchActivityAnimation(this, 0);
        return;
    L15:
        if (DSUtils.useDSFeature() == false) goto L17;
        Intent r9 = DSUtils.getCallIntent(this, this.mNum, -1);
    L18:
        startActivity(r9);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
        AnimationUtil.switchActivityAnimation(this, 0);
        return;
    L17:
        r9 = ContactsIntentUtils.newDialNumberIntent(this.mNum);
        goto L18
    }

    private void startCreateNewContactActivity() {
        Intent r0 = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        r0.setPackage("com.android.contacts");
        startActivityAndForwardResult(r0);
        AnimationUtil.switchActivityAnimation(this, 5);
    }

    private void showInputMethod(View r2) {
        InputMethodManager r1 = (InputMethodManager) getSystemService("input_method");
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.showSoftInput(r2, 0) == true) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed to show soft input method.");
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 0) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L11;
        if (r3 == null) goto L8;
        startActivity(r3);
    L8:
        finish();
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PickerFragment r0 = this.mPickerFragment;
        if (r0 != null) goto L5;
    L7:
        super.onBackPressed();
        return;
    L5:
        if (r0.back() == false) goto L7;
    }

    private void checkTypeError(Bundle r3) {
        if (r3 == null) goto L7;
        String r0 = r3.getString("phone");
        if (Telephony.Mms.isEmailAddress(r0) == false) goto L8;
        r3.remove("phone");
        r3.putString("email", r0);
        return;
    L8:
        return;
    }

    public void com_android_contacts_activities_ContactSelectionActivity__finish$___twin___() {
        if (this.isFinish == false) goto L5;
        super.finish();
        overridePendingTransition(0, 0);
        return;
    L5:
        ViewAnimationUtils.INSTANCE.hidePageAnimationWithBGAlpha(this.mFlagView, this.mFlagActionView, ContextCompat.getColor(getBaseContext(), R.color.oui_advanced_scrim_sheet), new AnonymousClass5(this));
    }

    public void finishWithoutAnimation() {
        super.finish();
    }

    public void com_android_contacts_activities_ContactSelectionActivity__onDestroy$___twin___() {
        super.onDestroy();
        cleanupClipboardManagerListeners();
    }

    private void cleanupClipboardManagerListeners() {
        ClipboardManager r2 = (ClipboardManager) getApplicationContext().getSystemService("clipboard");     // Catch: Exception -> L18
        if (r2 != null) goto L5;
        return;
    L5:
        Field r0 = ClipboardManager.class.getDeclaredField("mPrimaryClipChangedListeners");     // Catch: Exception -> L18
        r0.setAccessible(true);     // Catch: Exception -> L18
        Set r3 = (Set) r0.get(r2);     // Catch: Exception -> L18
        if (r3 != null) goto L8;
        return;
    L8:
        Iterator r4 = r3.iterator();     // Catch: Exception -> L18
    L9:
        if (r4.hasNext() == false) goto L27;
        String r1 = ((ClipboardManager.OnPrimaryClipChangedListener) r4.next()).getClass().getName();     // Catch: Exception -> L18
        if (r1.contains("ViewRootImpl") == true) goto L15;
        if (r1.contains("AiWritingController") == false) goto L9;
    L15:
        r4.remove();     // Catch: Exception -> L18
        goto L9
    L27:
        return;
    }

    private boolean isDarkTheme() {
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_ContactSelectionActivity_com_obric_privacyhook_PrivacyHook_onCreate(ContactSelectionActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactSelectionActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_ContactSelectionActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_ContactSelectionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ContactSelectionActivity r1) {
        com_android_contacts_activities_ContactSelectionActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStart")
    public static void com_android_contacts_activities_ContactSelectionActivity_com_obric_privacyhook_PrivacyHook_onStart(ContactSelectionActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactSelectionActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r2.com_android_contacts_activities_ContactSelectionActivity__onStart$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_ContactSelectionActivity_com_obric_privacyhook_PrivacyHook_onStop(ContactSelectionActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactSelectionActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_ContactSelectionActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_activities_ContactSelectionActivity_com_obric_privacyhook_PrivacyHook_onDestroy(ContactSelectionActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactSelectionActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_activities_ContactSelectionActivity__onDestroy$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_activities_ContactSelectionActivity_com_obric_privacyhook_PrivacyHook_finish(ContactSelectionActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactSelectionActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_activities_ContactSelectionActivity__finish$___twin___();
    }
}
