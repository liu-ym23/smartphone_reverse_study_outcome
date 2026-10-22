package com.android.server.policy;

import android.R;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.Vibrator;
import android.provider.Settings;
import android.service.dreams.IDreamManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.android.internal.app.AlertController;
import com.android.internal.globalactions.Action;
import com.android.internal.globalactions.ActionsAdapter;
import com.android.internal.globalactions.ActionsDialog;
import com.android.internal.globalactions.LongPressAction;
import com.android.internal.globalactions.SinglePressAction;
import com.android.internal.globalactions.ToggleAction;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.EmergencyAffordanceManager;
import com.android.server.autofill.HintsHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class LegacyGlobalActions implements DialogInterface.OnDismissListener, DialogInterface.OnClickListener {
    private static final int DIALOG_DISMISS_DELAY = 300;
    private static final String GLOBAL_ACTION_KEY_AIRPLANE = "airplane";
    private static final String GLOBAL_ACTION_KEY_ASSIST = "assist";
    private static final String GLOBAL_ACTION_KEY_BUGREPORT = "bugreport";
    private static final String GLOBAL_ACTION_KEY_LOCKDOWN = "lockdown";
    private static final String GLOBAL_ACTION_KEY_POWER = "power";
    private static final String GLOBAL_ACTION_KEY_RESTART = "restart";
    private static final String GLOBAL_ACTION_KEY_SETTINGS = "settings";
    private static final String GLOBAL_ACTION_KEY_SILENT = "silent";
    private static final String GLOBAL_ACTION_KEY_USERS = "users";
    private static final String GLOBAL_ACTION_KEY_VOICEASSIST = "voiceassist";
    private static final int MESSAGE_DISMISS = 0;
    private static final int MESSAGE_REFRESH = 1;
    private static final int MESSAGE_SHOW = 2;
    private static final boolean SHOW_SILENT_TOGGLE = true;
    private static final String TAG = "LegacyGlobalActions";
    private ActionsAdapter mAdapter;
    private ContentObserver mAirplaneModeObserver;
    private ToggleAction mAirplaneModeOn;
    private ToggleAction.State mAirplaneState;
    private final AudioManager mAudioManager;
    private BroadcastReceiver mBroadcastReceiver;
    private final Context mContext;
    private boolean mDeviceProvisioned;
    private ActionsDialog mDialog;
    private final IDreamManager mDreamManager;
    private final EmergencyAffordanceManager mEmergencyAffordanceManager;
    private Handler mHandler;
    private final boolean mHasTelephony;
    private boolean mHasVibrator;
    private boolean mIsWaitingForEcmExit;
    private ArrayList<Action> mItems;
    private boolean mKeyguardShowing;
    private final Runnable mOnDismiss;
    PhoneStateListener mPhoneStateListener;
    private BroadcastReceiver mRingerModeReceiver;
    private final boolean mShowSilentToggle;
    private Action mSilentModeAction;
    private final WindowManagerPolicy.WindowManagerFuncs mWindowManagerFuncs;

    private class BugReportAction extends SinglePressAction implements LongPressAction {
        final /* synthetic */ LegacyGlobalActions this$0;

        public BugReportAction(LegacyGlobalActions r2) {
            this.this$0 = r2;
            super(R.drawable.jog_tab_right_pressed, R.string.choose_account_label);
        }

        public void onPress() {
            if (ActivityManager.isUserAMonkey() == false) goto L5;
            return;
        L5:
            LegacyGlobalActions.m7141$$Nest$fgetmHandler(this.this$0).postDelayed(new AnonymousClass1(this), 500);
        }

        public boolean onLongPress() {
            if (ActivityManager.isUserAMonkey() == false) goto L9;
            return false;
        L9:
            MetricsLogger.action(LegacyGlobalActions.m7138$$Nest$fgetmContext(this.this$0), 293);     // Catch: RemoteException -> L7
            ActivityManager.getService().requestFullBugReport();     // Catch: RemoteException -> L7
        L8:
            return false;
        }

        public boolean showDuringKeyguard() {
            return true;
        }

        public boolean showBeforeProvisioning() {
            return false;
        }

        public String getStatus() {
            return LegacyGlobalActions.m7138$$Nest$fgetmContext(this.this$0).getString(R.string.chooseUsbActivity, new Object[]{Build.VERSION.RELEASE_OR_CODENAME, Build.ID});
        }
    }

    private class SilentModeToggleAction extends ToggleAction {
        final /* synthetic */ LegacyGlobalActions this$0;

        public SilentModeToggleAction(LegacyGlobalActions r7) {
            this.this$0 = r7;
            super(R.drawable.ic_restart, R.drawable.ic_refresh, R.string.indeterminate_progress_33, R.string.indeterminate_progress_31, R.string.indeterminate_progress_30);
        }

        public void onToggle(boolean on) {
            if (on == false) goto L4;
            LegacyGlobalActions.m7137$$Nest$fgetmAudioManager(this.this$0).setRingerMode(0);
            return;
        L4:
            LegacyGlobalActions.m7137$$Nest$fgetmAudioManager(this.this$0).setRingerMode(2);
        }

        public boolean showDuringKeyguard() {
            return true;
        }

        public boolean showBeforeProvisioning() {
            return false;
        }
    }

    private static class SilentModeTriStateAction implements Action, View.OnClickListener {
        private final int[] ITEM_IDS;
        private final AudioManager mAudioManager;
        private final Context mContext;
        private final Handler mHandler;

        SilentModeTriStateAction(Context context, AudioManager audioManager, Handler handler) {
            this.ITEM_IDS = new int[]{R.id.right_container, R.id.right_icon, R.id.right_to_left};
            this.mAudioManager = audioManager;
            this.mHandler = handler;
            this.mContext = context;
        }

        private int ringerModeToIndex(int ringerMode) {
            return ringerMode;
        }

        private int indexToRingerMode(int index) {
            return index;
        }

        public CharSequence getLabelForAccessibility(Context context) {
            return null;
        }

        public View create(Context context, View convertView, ViewGroup parent, LayoutInflater inflater) {
            View v = inflater.inflate(R.layout.notification_2025_reply_history_container, parent, false);
            int selectedIndex = ringerModeToIndex(this.mAudioManager.getRingerMode());
            int i = 0;
        L4:
            if (i >= 3) goto L11;
            View itemView = v.findViewById(this.ITEM_IDS[i]);
            if (selectedIndex != i) goto L8;
            boolean r5 = true;
        L9:
            itemView.setSelected(r5);
            itemView.setTag(Integer.valueOf(i));
            itemView.setOnClickListener(this);
            i = i + 1;
            goto L4
        L8:
            r5 = false;
            goto L9
        L11:
            return v;
        }

        public void onPress() {
        }

        public boolean showDuringKeyguard() {
            return true;
        }

        public boolean showBeforeProvisioning() {
            return false;
        }

        public boolean isEnabled() {
            return true;
        }

        void willCreate() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if ((v.getTag() instanceof Integer) == true) goto L5;
            return;
        L5:
            int index = ((Integer) v.getTag()).intValue();
            this.mAudioManager.setRingerMode(indexToRingerMode(index));
            this.mHandler.sendEmptyMessageDelayed(0, 300);
        }
    }

    public static /* synthetic */ boolean $r8$lambda$pob7l4aPDN16MeR45QSA3Pp_D9w(LegacyGlobalActions r0) {
        return r0.lambda$createDialog$0();
    }

    public static /* synthetic */ boolean $r8$lambda$vZ24ykyuYvuVico_ZaD4S6MH1e0(LegacyGlobalActions r0) {
        return r0.lambda$createDialog$1();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdapter, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActionsAdapter m7134$$Nest$fgetmAdapter(LegacyGlobalActions r0) {
        return r0.mAdapter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAirplaneModeOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ ToggleAction m7135$$Nest$fgetmAirplaneModeOn(LegacyGlobalActions r0) {
        return r0.mAirplaneModeOn;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAirplaneState, reason: not valid java name */
    static /* bridge */ /* synthetic */ ToggleAction.State m7136$$Nest$fgetmAirplaneState(LegacyGlobalActions r0) {
        return r0.mAirplaneState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioManager m7137$$Nest$fgetmAudioManager(LegacyGlobalActions r0) {
        return r0.mAudioManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7138$$Nest$fgetmContext(LegacyGlobalActions r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDialog, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActionsDialog m7139$$Nest$fgetmDialog(LegacyGlobalActions r0) {
        return r0.mDialog;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEmergencyAffordanceManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ EmergencyAffordanceManager m7140$$Nest$fgetmEmergencyAffordanceManager(LegacyGlobalActions r0) {
        return r0.mEmergencyAffordanceManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7141$$Nest$fgetmHandler(LegacyGlobalActions r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHasTelephony, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7142$$Nest$fgetmHasTelephony(LegacyGlobalActions r0) {
        return r0.mHasTelephony;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsWaitingForEcmExit, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7143$$Nest$fgetmIsWaitingForEcmExit(LegacyGlobalActions r0) {
        return r0.mIsWaitingForEcmExit;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAirplaneState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7144$$Nest$fputmAirplaneState(LegacyGlobalActions r0, ToggleAction.State r1) {
        r0.mAirplaneState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDialog, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7145$$Nest$fputmDialog(LegacyGlobalActions r0, ActionsDialog r1) {
        r0.mDialog = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsWaitingForEcmExit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7146$$Nest$fputmIsWaitingForEcmExit(LegacyGlobalActions r0, boolean r1) {
        r0.mIsWaitingForEcmExit = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mchangeAirplaneModeSystemSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7147$$Nest$mchangeAirplaneModeSystemSetting(LegacyGlobalActions r0, boolean r1) {
        r0.changeAirplaneModeSystemSetting(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleShow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7148$$Nest$mhandleShow(LegacyGlobalActions r0) {
        r0.handleShow();
    }

    /* JADX INFO: renamed from: -$$Nest$monAirplaneModeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7149$$Nest$monAirplaneModeChanged(LegacyGlobalActions r0) {
        r0.onAirplaneModeChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$mrefreshSilentMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7150$$Nest$mrefreshSilentMode(LegacyGlobalActions r0) {
        r0.refreshSilentMode();
    }

    public LegacyGlobalActions(Context context, WindowManagerPolicy.WindowManagerFuncs windowManagerFuncs, Runnable onDismiss) {
        boolean r0 = false;
        this.mKeyguardShowing = false;
        this.mDeviceProvisioned = false;
        this.mAirplaneState = ToggleAction.State.Off;
        this.mIsWaitingForEcmExit = false;
        this.mBroadcastReceiver = new AnonymousClass9(this);
        this.mPhoneStateListener = new AnonymousClass10(this);
        this.mRingerModeReceiver = new AnonymousClass11(this);
        final Handler r2 = new Handler();
        this.mAirplaneModeObserver = new AnonymousClass12(this, r2);
        this.mHandler = new AnonymousClass13(this);
        this.mContext = context;
        this.mWindowManagerFuncs = windowManagerFuncs;
        this.mOnDismiss = onDismiss;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mDreamManager = IDreamManager.Stub.asInterface(ServiceManager.getService("dreams"));
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.EMERGENCY_CALLBACK_MODE_CHANGED");
        context.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, filter, null, null, 2);
        this.mHasTelephony = context.getPackageManager().hasSystemFeature("android.hardware.telephony");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
        telephonyManager.listen(this.mPhoneStateListener, 1);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("airplane_mode_on"), true, this.mAirplaneModeObserver);
        Vibrator vibrator = (Vibrator) this.mContext.getSystemService("vibrator");
        if (vibrator != null) goto L5;
    L7:
        this.mHasVibrator = r0;
        this.mShowSilentToggle = !this.mContext.getResources().getBoolean(R.bool.config_use_strict_phone_number_comparation_for_russia);
        this.mEmergencyAffordanceManager = new EmergencyAffordanceManager(context);
        return;
    L5:
        if (vibrator.hasVibrator() == false) goto L7;
        r0 = true;
        goto L7
    }

    public void showDialog(boolean keyguardShowing, boolean isDeviceProvisioned) {
        this.mKeyguardShowing = keyguardShowing;
        this.mDeviceProvisioned = isDeviceProvisioned;
        if (this.mDialog == null) goto L5;
        this.mDialog.dismiss();
        this.mDialog = null;
        this.mHandler.sendEmptyMessage(2);
        return;
    L5:
        handleShow();
    }

    private void awakenIfNecessary() {
        if (this.mDreamManager != null) goto L12;
        return;
    L12:
        if (this.mDreamManager.isDreaming() == false) goto L15;
        this.mDreamManager.awaken();     // Catch: RemoteException -> L8
        return;
    L15:
        return;
    }

    private void handleShow() {
        awakenIfNecessary();
        this.mDialog = createDialog();
        prepareDialog();
        if (this.mAdapter.getCount() != 1) goto L10;
        if ((this.mAdapter.getItem(0) instanceof SinglePressAction) == false) goto L10;
        if ((this.mAdapter.getItem(0) instanceof LongPressAction) == true) goto L10;
        this.mAdapter.getItem(0).onPress();
        return;
    L10:
        if (this.mDialog == null) goto L14;
        WindowManager.LayoutParams attrs = this.mDialog.getWindow().getAttributes();
        attrs.setTitle(TAG);
        this.mDialog.getWindow().setAttributes(attrs);
        this.mDialog.show();
        this.mDialog.getWindow().getDecorView().setSystemUiVisibility(65536);
        return;
    }

    private ActionsDialog createDialog() {
        if (this.mHasVibrator == true) goto L5;
        this.mSilentModeAction = new SilentModeToggleAction(this);
    L6:
        final int r9 = R.string.indeterminate_progress_37;
        final int r10 = R.string.indeterminate_progress_36;
        final int r6 = R.drawable.jog_tab_right_confirm_yellow;
        final int r7 = R.drawable.jog_tab_right_generic;
        final int r8 = R.string.indeterminate_progress_38;
        this.mAirplaneModeOn = new AnonymousClass1(this, r6, r7, r8, r9, r10);
        onAirplaneModeChanged();
        this.mItems = new ArrayList();
        String[] defaultActions = this.mContext.getResources().getStringArray(R.array.config_lteDbmThresholds);
        ArraySet<String> addedKeys = new ArraySet();
        int i = 0;
    L8:
        if (i >= defaultActions.length) goto L54;
        String actionKey = defaultActions[i];
        if (addedKeys.contains(actionKey) == true) goto L52;
        if (GLOBAL_ACTION_KEY_POWER.equals(actionKey) == false) goto L16;
        this.mItems.add(new PowerAction(this.mContext, this.mWindowManagerFuncs));
    L51:
        addedKeys.add(actionKey);
        goto L52
    L16:
        if (GLOBAL_ACTION_KEY_AIRPLANE.equals(actionKey) == false) goto L19;
        this.mItems.add(this.mAirplaneModeOn);
        goto L51
    L19:
        if (GLOBAL_ACTION_KEY_BUGREPORT.equals(actionKey) == false) goto L26;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "bugreport_in_power_menu", 0, this.mContext.getUserId()) == 0) goto L51;
        if (isCurrentUserAdmin() == false) goto L51;
        this.mItems.add(new BugReportAction(this));
        goto L51
    L26:
        if (GLOBAL_ACTION_KEY_SILENT.equals(actionKey) == false) goto L31;
        if (this.mShowSilentToggle == false) goto L51;
        this.mItems.add(this.mSilentModeAction);
        goto L51
    L31:
        if ("users".equals(actionKey) == false) goto L36;
        if (SystemProperties.getBoolean("fw.power_user_switcher", false) == false) goto L51;
        addUsersToMenu(this.mItems);
        goto L51
    L36:
        if ("settings".equals(actionKey) == false) goto L39;
        this.mItems.add(getSettingsAction());
        goto L51
    L39:
        if (GLOBAL_ACTION_KEY_LOCKDOWN.equals(actionKey) == false) goto L42;
        this.mItems.add(getLockdownAction());
        goto L51
    L42:
        if (GLOBAL_ACTION_KEY_VOICEASSIST.equals(actionKey) == false) goto L45;
        this.mItems.add(getVoiceAssistAction());
        goto L51
    L45:
        if ("assist".equals(actionKey) == false) goto L48;
        this.mItems.add(getAssistAction());
        goto L51
    L48:
        if ("restart".equals(actionKey) == false) goto L50;
        this.mItems.add(new RestartAction(this.mContext, this.mWindowManagerFuncs));
        goto L51
    L50:
        Log.e(TAG, "Invalid global action key " + actionKey);
    L52:
        i = i + 1;
        goto L8
    L54:
        if (this.mEmergencyAffordanceManager.needsEmergencyAffordance() == false) goto L56;
        this.mItems.add(getEmergencyAction());
    L56:
        this.mAdapter = new ActionsAdapter(this.mContext, this.mItems, new LegacyGlobalActions$$ExternalSyntheticLambda0(this), new LegacyGlobalActions$$ExternalSyntheticLambda1(this));
        AlertController.AlertParams params = new AlertController.AlertParams(this.mContext);
        params.mAdapter = this.mAdapter;
        params.mOnClickListener = this;
        params.mForceInverseBackground = true;
        ActionsDialog dialog = new ActionsDialog(this.mContext, params);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getListView().setItemsCanFocus(true);
        dialog.getListView().setLongClickable(true);
        dialog.getListView().setOnItemLongClickListener(new AnonymousClass2(this));
        dialog.getWindow().setType(2009);
        dialog.getWindow().setFlags(131072, 131072);
        dialog.setOnDismissListener(this);
        return dialog;
    L5:
        this.mSilentModeAction = new SilentModeTriStateAction(this.mContext, this.mAudioManager, this.mHandler);
        goto L6
    }

    private /* synthetic */ boolean lambda$createDialog$0() {
        return this.mDeviceProvisioned;
    }

    private /* synthetic */ boolean lambda$createDialog$1() {
        return this.mKeyguardShowing;
    }

    private Action getSettingsAction() {
        final int r1 = R.drawable.pointer_wait_6;
        final int r2 = R.string.indeterminate_progress_29;
        return new AnonymousClass3(this, r1, r2);
    }

    private Action getEmergencyAction() {
        final int r1 = R.drawable.ic_media_route_connected_light_30_mtrl;
        final int r2 = R.string.indeterminate_progress_21;
        return new AnonymousClass4(this, r1, r2);
    }

    private Action getAssistAction() {
        final int r1 = R.drawable.ic_plus;
        final int r2 = R.string.indeterminate_progress_19;
        return new AnonymousClass5(this, r1, r2);
    }

    private Action getVoiceAssistAction() {
        final int r1 = R.drawable.pointer_wait_vector_30;
        final int r2 = R.string.indeterminate_progress_34;
        return new AnonymousClass6(this, r1, r2);
    }

    private Action getLockdownAction() {
        final int r1 = R.drawable.ic_lock_lock;
        final int r2 = R.string.indeterminate_progress_23;
        return new AnonymousClass7(this, r1, r2);
    }

    private UserInfo getCurrentUser() {
        return ActivityManager.getService().getCurrentUser();
    L5:
        return null;
    }

    private boolean isCurrentUserAdmin() {
        UserInfo currentUser = getCurrentUser();
        if (currentUser != null) goto L5;
    L7:
        return false;
    L5:
        if (currentUser.isAdmin() == false) goto L7;
        return true;
    }

    private void addUsersToMenu(ArrayList<Action> items) {
        UserManager um = (UserManager) this.mContext.getSystemService("user");
        if (um.isUserSwitcherEnabled() == false) goto L31;
        List<UserInfo> users = um.getUsers();
        UserInfo currentUser = getCurrentUser();
        Iterator<UserInfo> r3 = users.iterator();
    L6:
        if (r3.hasNext() == false) goto L37;
        final UserInfo user = r3.next();
        if (user.supportsSwitchToByUser() == false) goto L6;
        boolean isCurrentUser = false;
        if (currentUser != null) goto L15;
        if (user.id != 0) goto L18;
    L13:
        isCurrentUser = true;
    L18:
        if (user.iconPath == null) goto L20;
        final Drawable icon = Drawable.createFromPath(user.iconPath);
    L21:
        StringBuilder r6 = new StringBuilder();
        if (user.name == null) goto L24;
        String r7 = user.name;
    L25:
        r6.append(r7);
        if (isCurrentUser == false) goto L28;
        String r8 = " ✔";
    L29:
        r6.append(r8);
        final String r9 = r6.toString();
        final int r10 = R.drawable.pointer_arrow_vector;
        SinglePressAction switchToUser = new AnonymousClass8(this, r10, icon, r9, user);
        items.add(switchToUser);
        goto L6
    L28:
        r8 = "";
        goto L29
    L24:
        r7 = "Primary";
        goto L25
    L20:
        icon = null;
        goto L21
    L15:
        if (currentUser.id != user.id) goto L18;
    L37:
        return;
    }

    private void prepareDialog() {
        refreshSilentMode();
        this.mAirplaneModeOn.updateState(this.mAirplaneState);
        this.mAdapter.notifyDataSetChanged();
        this.mDialog.getWindow().setType(2009);
        if (this.mShowSilentToggle == false) goto L6;
        IntentFilter filter = new IntentFilter("android.media.RINGER_MODE_CHANGED");
        this.mContext.registerReceiver(this.mRingerModeReceiver, filter);
        return;
    }

    private void refreshSilentMode() {
        if (this.mHasVibrator == false) goto L5;
        return;
    L5:
        if (this.mAudioManager.getRingerMode() == 2) goto L7;
        boolean silentModeOn = true;
    L8:
        ToggleAction r1 = this.mSilentModeAction;
        if (silentModeOn == false) goto L11;
        ToggleAction.State r2 = ToggleAction.State.On;
    L12:
        r1.updateState(r2);
        return;
    L11:
        r2 = ToggleAction.State.Off;
        goto L12
    L7:
        silentModeOn = false;
        goto L8
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        if (this.mOnDismiss == null) goto L6;
        this.mOnDismiss.run();
    L6:
        if (this.mShowSilentToggle == false) goto L14;
        this.mContext.unregisterReceiver(this.mRingerModeReceiver);     // Catch: IllegalArgumentException -> L9
        return;
    L9:
        ie = move-exception;
        Log.w(TAG, ie);
        return;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        if ((this.mAdapter.getItem(which) instanceof SilentModeTriStateAction) == true) goto L5;
        dialog.dismiss();
    L5:
        this.mAdapter.getItem(which).onPress();
    }

    private void onAirplaneModeChanged() {
        if (this.mHasTelephony == false) goto L5;
        return;
    L5:
        boolean airplaneModeOn = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) != 1) goto L8;
        airplaneModeOn = true;
    L8:
        if (airplaneModeOn == false) goto L10;
        ToggleAction.State r0 = ToggleAction.State.On;
    L11:
        this.mAirplaneState = r0;
        this.mAirplaneModeOn.updateState(this.mAirplaneState);
        return;
    L10:
        r0 = ToggleAction.State.Off;
        goto L11
    }

    private void changeAirplaneModeSystemSetting(boolean r4) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "airplane_mode_on", r4 ? 1 : 0);
        Intent r0 = new Intent("android.intent.action.AIRPLANE_MODE");
        r0.addFlags(536870912);
        r0.putExtra("state", r4);
        this.mContext.sendBroadcastAsUser(r0, UserHandle.ALL);
        if (this.mHasTelephony == true) goto L9;
        if (r4 == false) goto L6;
        ToggleAction.State r1 = ToggleAction.State.On;
    L7:
        this.mAirplaneState = r1;
        return;
    L6:
        r1 = ToggleAction.State.Off;
        goto L7
    }
}
