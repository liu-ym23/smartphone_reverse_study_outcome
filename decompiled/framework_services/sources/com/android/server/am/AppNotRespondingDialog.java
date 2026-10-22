package com.android.server.am;

import android.R;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.pico.utils.ExtImplFactory;
import android.text.BidiFormatter;
import android.util.Utils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
final class AppNotRespondingDialog extends BaseErrorDialog implements View.OnClickListener {
    public static final int ALREADY_SHOWING = -2;
    public static final int CANT_SHOW = -1;
    static final int FORCE_CLOSE = 1;
    private static final String TAG = "AppNotRespondingDialog";
    static final int WAIT = 2;
    static final int WAIT_AND_REPORT = 3;
    private final Data mData;
    private IExtSystemServerDialogHelper mExt;
    private final Handler mHandler;
    private boolean mIsXtsApp;
    private final ProcessRecord mProc;
    private final ActivityManagerService mService;
    private String mTitle;

    static class Data {
        final ApplicationInfo aInfo;
        final boolean aboveSystem;
        final boolean isContinuousAnr;
        final ProcessRecord proc;

        Data(ProcessRecord proc, ApplicationInfo aInfo, boolean aboveSystem, boolean isContinuousAnr) {
            this.proc = proc;
            this.aInfo = aInfo;
            this.aboveSystem = aboveSystem;
            this.isContinuousAnr = isContinuousAnr;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmData, reason: not valid java name */
    static /* bridge */ /* synthetic */ Data m1311$$Nest$fgetmData(AppNotRespondingDialog r0) {
        return r0.mData;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProc, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProcessRecord m1312$$Nest$fgetmProc(AppNotRespondingDialog r0) {
        return r0.mProc;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m1313$$Nest$fgetmService(AppNotRespondingDialog r0) {
        return r0.mService;
    }

    public AppNotRespondingDialog(ActivityManagerService service, Context context, Data data) {
        super(context);
        this.mIsXtsApp = false;
        this.mHandler = new AnonymousClass1(this);
        this.mExt = (IExtSystemServerDialogHelper) ExtImplFactory.getImpl(IExtSystemServerDialogHelper.class, new Object[]{this});
        this.mService = service;
        this.mProc = data.proc;
        this.mData = data;
        Resources res = context.getResources();
        if (this.mProc != null) goto L5;
    L7:
        setCancelable(false);
        if (data.aInfo == null) goto L10;
        CharSequence name1 = data.aInfo.loadLabel(context.getPackageManager());
    L11:
        CharSequence name2 = null;
        if (this.mProc.getPkgList().size() != 1) goto L18;
        CharSequence r3 = context.getPackageManager().getApplicationLabel(this.mProc.info);
        name2 = r3;
        if (r3 == null) goto L18;
        if (name1 == null) goto L17;
        int resid = R.string.app_streaming_blocked_title_for_camera_dialog;
    L21:
        BidiFormatter bidi = BidiFormatter.getInstance();
        if (this.mIsXtsApp == false) goto L27;
        if (name2 == null) goto L25;
        String r5 = res.getString(resid, new Object[]{bidi.unicodeWrap(name1.toString()), bidi.unicodeWrap(name2.toString())});
    L26:
        setTitle(r5);
    L32:
        if (data.aboveSystem == false) goto L34;
        getWindow().setType(2010);
    L34:
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.setTitle("Application Not Responding: " + this.mProc.info.processName);
        attrs.privateFlags = 272;
        getWindow().setAttributes(attrs);
        return;
    L25:
        r5 = res.getString(resid, new Object[]{bidi.unicodeWrap(name1.toString())});
        goto L26
    L27:
        if (name2 == null) goto L29;
        String r6 = res.getString(resid, new Object[]{bidi.unicodeWrap(name1.toString()), bidi.unicodeWrap(name2.toString())});
    L30:
        this.mTitle = r6;
        goto L32
    L29:
        r6 = res.getString(resid, new Object[]{bidi.unicodeWrap(name1.toString())});
        goto L30
    L17:
        name1 = name2;
        name2 = this.mProc.processName;
        resid = R.string.app_streaming_blocked_title_for_microphone_dialog;
    L18:
        if (name1 == null) goto L20;
        name2 = this.mProc.processName;
        resid = R.string.app_streaming_blocked_title_for_fingerprint_dialog;
        goto L21
    L20:
        name1 = this.mProc.processName;
        resid = R.string.app_streaming_blocked_title_for_permission_dialog;
        goto L21
    L10:
        name1 = null;
        goto L11
    L5:
        if (this.mProc.getApplicationInfo() == null) goto L7;
        this.mIsXtsApp = Utils.isXtsPkg(this.mProc.getApplicationInfo().packageName);
        goto L7
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.mIsXtsApp == false) goto L12;
        FrameLayout frame = (FrameLayout) findViewById(R.id.custom);
        Context context = getContext();
        boolean hasReceiver = true;
        LayoutInflater.from(context).inflate(R.layout.app_language_picker_system_current, frame, true);
        TextView report = (TextView) findViewById(R.id.aerr_report);
        report.setOnClickListener(this);
        if (this.mProc.mErrorState.getErrorReportReceiver() != null) goto L8;
        hasReceiver = false;
    L8:
        if (hasReceiver == false) goto L10;
        int r4 = 0;
    L11:
        report.setVisibility(r4);
        TextView close = (TextView) findViewById(R.id.aerr_close);
        close.setOnClickListener(this);
        TextView wait = (TextView) findViewById(R.id.aerr_wait);
        wait.setOnClickListener(this);
        findViewById(R.id.edit_query).setVisibility(0);
        return;
    L10:
        r4 = 8;
        goto L11
    L12:
        View customView = getExt().getAppNotRespondingDialog(getContext(), this.mTitle, this);
        applyObricModalMaterial(customView, TAG);
        setContentView(customView);
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.width = -1;
        attrs.gravity = 80;
        int offSet = getContext().getResources().getDimensionPixelOffset(R.dimen.keyguard_avatar_name_size);
        attrs.y = offSet;
        attrs.flags |= 512;
        attrs.setFitInsetsSides(0);
        getWindow().setAttributes(attrs);
        getWindow().setBackgroundDrawableResource(R.drawable.switch_bg_focused_holo_dark);
        getWindow().getDecorView().setSystemUiVisibility(4866);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch(v.getId()) {
            case 16908794: goto L7;
            case 16908795: goto L11;
            case 16908796: goto L6;
            case 16908797: goto L11;
            case 16908798: goto L5;
            default: goto L11;
        };
    L5:
        this.mHandler.obtainMessage(2).sendToTarget();
        return;
    L6:
        this.mHandler.obtainMessage(3).sendToTarget();
        return;
    L7:
        this.mHandler.obtainMessage(1).sendToTarget();
        return;
    }

    @Override // com.android.server.am.BaseErrorDialog
    protected void closeDialog() {
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    public IExtSystemServerDialogHelper getExt() {
        return this.mExt;
    }
}
