package com.android.server.appop;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.server.BasePermissionDialog;

/* JADX INFO: loaded from: classes.dex */
public class SmtPermissionDialog extends BasePermissionDialog {
    static final int ACTION_ALLOWED = 2;
    static final int ACTION_ASK_ALLOWED = 16;
    static final int ACTION_ASK_DENIED = 32;
    static final int ACTION_ASK_INUSE = 48;
    static final int ACTION_IGNORED = 4;
    static final int ACTION_IGNORED_TIMEOUT = 8;
    static final int ACTION_INUSE = 64;
    static final int ACTION_TIMEOUT = 80;
    static final float MAX_SIZE_MEDIUM_TEXT = 60.0f;
    static final float MAX_SIZE_SMALL_TEXT = 42.0f;
    static final long MS_DISMISS_INTERVAL = 1000;
    static final long MS_DISMISS_TIMEOUT = 15000;
    private static final String TAG = "SmtPermissionDialog";
    private Button mAllowBtn;
    private DialogInterface.OnClickListener mAllowListener;
    private Button mCancelBtn;
    private final int mCode;
    private Context mContext;
    private DialogInterface.OnClickListener mDenyListener;
    private final Handler mHandler;
    private DialogInterface.OnClickListener mInuseListener;
    private final int mLastMode;
    final CharSequence[] mOpLabels;
    private final String mPackageName;
    private int mPid;
    private final SmtOpsService mService;
    private final String mTargetPackage;
    private int mUid;
    private Resources res;
    CountDownTimer timer;

    class AppInfo {
        Drawable icon;
        String label;

        AppInfo(SmtPermissionDialog this$0) {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCode, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1827$$Nest$fgetmCode(SmtPermissionDialog r0) {
        return r0.mCode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m1828$$Nest$fgetmHandler(SmtPermissionDialog r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1829$$Nest$fgetmLastMode(SmtPermissionDialog r0) {
        return r0.mLastMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m1830$$Nest$fgetmPackageName(SmtPermissionDialog r0) {
        return r0.mPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1831$$Nest$fgetmPid(SmtPermissionDialog r0) {
        return r0.mPid;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ SmtOpsService m1832$$Nest$fgetmService(SmtPermissionDialog r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1833$$Nest$fgetmUid(SmtPermissionDialog r0) {
        return r0.mUid;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetres, reason: not valid java name */
    static /* bridge */ /* synthetic */ Resources m1834$$Nest$fgetres(SmtPermissionDialog r0) {
        return r0.res;
    }

    public SmtPermissionDialog(Context context, SmtOpsService service, int code, int pid, int uid, String packageName, int lastMode, String targetPackage) {
        super(context);
        this.mPid = -1;
        this.mHandler = new AnonymousClass1(this);
        this.mDenyListener = new AnonymousClass4(this);
        this.mAllowListener = new AnonymousClass5(this);
        this.mInuseListener = new AnonymousClass6(this);
        final long r3 = MS_DISMISS_TIMEOUT;
        final long r5 = 1000;
        this.timer = new AnonymousClass7(this, r3, r5);
        this.mContext = context;
        this.res = context.getResources();
        this.mService = service;
        this.mCode = code;
        this.mPackageName = packageName;
        this.mTargetPackage = targetPackage;
        this.mUid = uid;
        this.mPid = pid;
        this.mOpLabels = this.res.getTextArray(17236297);
        this.mLastMode = lastMode;
        setCancelable(false);
        setupViews(context, this.res);
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.setTitle("SmtOps info: " + this.mPackageName + "-" + this.mCode + "");
        attrs.privateFlags = attrs.privateFlags | 272;
        getWindow().setAttributes(attrs);
    }

    private AppInfo getAppInfo(String packageName, Resources res) {
        AppInfo info = new AppInfo(this);
        PackageManager pm = this.mContext.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L5
        ApplicationInfo appInfo = pm.getApplicationInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L5
        info.label = (String) pm.getApplicationLabel(appInfo);     // Catch: PackageManager.NameNotFoundException -> L5
        info.icon = pm.getApplicationIcon(appInfo);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (info.label != null) goto L9;
    L10:
        info.label = res.getString(17042269) + packageName;
    L12:
        if (info.icon != null) goto L14;
        info.icon = Resources.getSystem().getDrawable(17305306);
    L14:
        return info;
    L9:
        if (info.label.length() != 0) goto L12;
        goto L10
    }

    private void setupViews(Context context, Resources res) {
        boolean isInLandscape = isInLandscape(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.date_picker_legacy, null);
        TextView detail = (TextView) layout.findViewById(R.id.fade_in_out);
        TextView name = (TextView) layout.findViewById(R.id.permission_group);
        TextView waring = (TextView) layout.findViewById(R.id.arc);
        if (isInLandscape == false) goto L5;
        detail.getSmtEx().setMaxTextSize(60.0f);
        name.getSmtEx().setMaxTextSize(60.0f);
        waring.getSmtEx().setMaxTextSize(MAX_SIZE_SMALL_TEXT);
    L5:
        ImageView icon = (ImageView) layout.findViewById(R.id.icon);
        AppInfo info = getAppInfo(this.mPackageName, res);
        name.setText(info.label);
        icon.setImageDrawable(info.icon);
        detail.setText(this.mOpLabels[this.mCode].toString());
        if (this.mLastMode == 2) goto L8;
        TextView hint = (TextView) layout.findViewById(R.id.arc);
        hint.setVisibility(0);
    L8:
        setTitle(res.getString(R.string.dialog_alert_title));
        setButton(-1, res.getString(R.string.app_category_audio), new AnonymousClass2(this));
        setButton(-2, res.getString(R.string.elapsed_time_short_format_mm_ss), new AnonymousClass3(this));
        setView(layout);
    }

    private boolean isInLandscape(Context context) {
        Configuration mConfiguration = context.getResources().getConfiguration();
        int ori = mConfiguration.orientation;
        if (ori != 2) goto L6;
        return true;
    L6:
        return false;
    }

    private void setButtonsForGps(Resources res) {
        setButton(-2, res.getString(R.string.imProtocolNetMeeting), this.mDenyListener);
        setButton(-3, res.getString(R.string.whichOpenLinksWithApp), this.mAllowListener);
        setButton(-1, res.getString(R.string.lockscreen_glogin_account_recovery_hint), this.mInuseListener);
    }

    private void setButtonsForNormal(Resources res) {
        setButton(-1, res.getString(R.string.app_category_audio), this.mAllowListener);
        setButton(-2, res.getString(R.string.elapsed_time_short_format_mm_ss), this.mDenyListener);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.timer.start();
    }
}
