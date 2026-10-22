package com.bytedanceos.common.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.StatusBarHelper;
import com.bytedanceos.common.ui.utils.ViewPagerIndexPool;
import com.bytedanceos.common.ui.utils.ViewPagerRecycledPool;
import com.bytedanceos.common.utils.ReflectTool;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StatusBarActivity extends BasicActivity implements CommonConfirmDialog.DialogOnClickListener {
    public static final String EXTRA_HAS_ANIM = "extra_has_anim";
    protected View header;
    protected IntentFilter mFilter;
    protected AtomicBoolean mHasExitAnimation;
    protected boolean mIsRefresh;
    protected BroadcastReceiver mNetworkReceiver;
    private OnNetworkChangedListener mOnNetworkChangedListener;
    private int mStatusLeveral;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.StatusBarActivity$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class NetworkReceiver extends BroadcastReceiver {
        final /* synthetic */ StatusBarActivity this$0;

        private NetworkReceiver(StatusBarActivity r10) {
            this.this$0 = r10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            AsyncTask.execute(new AnonymousClass1(this));
        }

        public /* synthetic */ NetworkReceiver(StatusBarActivity r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public interface OnNetworkChangedListener {
        void onChanged(boolean r10);
    }

    public StatusBarActivity() {
        this.mStatusLeveral = -1;
        this.mHasExitAnimation = new AtomicBoolean(true);
        this.mIsRefresh = false;
    }

    public static /* synthetic */ OnNetworkChangedListener access$100(StatusBarActivity r10) {
        return r10.mOnNetworkChangedListener;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (getIntent() != null) goto L5;
    L21:
        overridePendingTransition(0, 0);
        return;
    L5:
        if (getIntent().getBooleanExtra("extra_has_anim", true) == false) goto L21;
        String r10 = ReflectTool.getIntentSmtExtraName("get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID", new Class[0]);
        if (TextUtils.isEmpty(r10) == false) goto L24;
    L15:
        AtomicBoolean r11 = this.mHasExitAnimation;
        if (r11 != null) goto L18;
        return;
    L18:
        if (r11.get() == false) goto L27;
        overridePendingTransition(R$anim.slide_in_from_left, R$anim.slide_out_to_right);
        return;
    L27:
        return;
    L24:
        int[] r12 = getIntent().getIntArrayExtra(r10);     // Catch: Exception -> L23
        if (r12 == null) goto L15;
        if (r12.length != 2) goto L15;
        overridePendingTransition(r12[0], r12[1]);     // Catch: Exception -> L23
    }

    public abstract View initHeaderView();

    public void onButtonClick(int r10, int r11, boolean r12, Bundle r13) {
        if (r10 == 26) goto L6;
        return;
    L6:
        if (r11 != (-1)) goto L8;
        boolean r14 = r13.getBoolean(CommonConfirmDialog.ARGS_DIALOG_USE_OAUTH);
        AppInfo r15 = (AppInfo) r13.getSerializable(CommonConfirmDialog.ARGS_DIALOG_APP);
        com.bytedanceos.common.toolbox.e.J0(this, null, r14);
        return;
    L8:
        com.bytedanceos.common.toolbox.j.e("cancel login dialog");
    }

    @Override // com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        BaseApplication.u(getClass().getSimpleName(), false);
    }

    @Override // com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ViewPagerRecycledPool.getInstance().clear();
        ViewPagerIndexPool.getInstance().clear(toString());
        BaseApplication.u(getClass().getSimpleName(), true);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        com.bytedanceos.common.toolbox.j.n("keyCode = " + r10);
        boolean r12 = super.onKeyDown(r10, r11);
        com.bytedanceos.common.toolbox.j.n("KeyEvent = " + r11.toString());
        return r12;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.bytedanceos.common.toolbox.j.a(getClass().getName());
        super.onPause();
        d9.b.b().h();
        ViewPagerRecycledPool.getInstance().clear();
        unregisterReceiver(this.mNetworkReceiver);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.bytedanceos.common.toolbox.j.a(getClass().getName());
        super.onResume();
        AnonymousClass1 r10 = null;
        if (useEdgeToEdgeStatusBar() == false) goto L5;
    L8:
        d9.b.b().i();
        if (this.mNetworkReceiver != null) goto L12;
        this.mNetworkReceiver = new NetworkReceiver(this, r10);
    L12:
        if (this.mFilter != null) goto L14;
        IntentFilter r11 = new IntentFilter();
        this.mFilter = r11;
        r11.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    L14:
        registerReceiver(this.mNetworkReceiver, this.mFilter);
        return;
    L5:
        if (this.mStatusLeveral != (-1)) goto L7;
        this.mStatusLeveral = StatusBarHelper.a().d(this, getWindow(), this.header, null);
        goto L8
    L7:
        this.mStatusLeveral = StatusBarHelper.a().e(this, getWindow(), this.header, this.mStatusLeveral, null);
        goto L8
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r10) {
        super.setContentView(r10);
        View r11 = initHeaderView();
        this.header = r11;
        if (r11 != null) goto L6;
        finish();
        return;
    }

    public void setOnNetworkChangedListener(OnNetworkChangedListener r10) {
        this.mOnNetworkChangedListener = r10;
    }

    public void updateTitle(int r10, String... r11) {
    }

    public boolean useEdgeToEdgeStatusBar() {
        return false;
    }
}
