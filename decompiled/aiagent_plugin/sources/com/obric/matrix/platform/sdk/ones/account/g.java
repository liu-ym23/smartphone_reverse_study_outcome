package com.obric.matrix.platform.sdk.ones.account;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SecureAccountStatusListener.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g implements com.obric.matrix.platform.sdk.ones.account.a.c {
    private static final String TAG = "AccountSDK_SecureAccountStatusListener";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f33627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PluginBroadcastReceiver f33628b;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.account.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: SecureAccountStatusListener.java */
    class AnonymousClass1 extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f33629a;

        public static /* synthetic */ void lambda$Dby0vKLupPP585DkIffC80mjXTk(AnonymousClass1 r0, Intent r1) {
            r0.a(r1);
        }

        AnonymousClass1(g r1) {
            this.f33629a = r1;
        }

        public void onReceive(Context r3, final Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this.f33629a.a(new $$Lambda$g$1$Dby0vKLupPP585DkIffC80mjXTk(this, r4));
        }

        private /* synthetic */ void a(Intent r3) {
            a(g.TAG, "onReceive action = " + r3.getAction());
            if (r3.getAction() != null) goto L6;
            return;
        L6:
            if (r3.getAction().equals("obric.intent.action.account.SECURE_LOGIN") == false) goto L9;
            this.f33629a.b();
            return;
        L9:
            if (r3.getAction().equals("obric.intent.action.account.SECURE_LOGOUT") == false) goto L12;
            this.f33629a.a(r3.getIntExtra("obric.intent.extra.account.LOGOUT_SCENE", 0));
            return;
        L12:
            if (r3.getAction().equals("obric.intent.action.account.SECURE_ACCOUNT_INFO_UPDATE") == false) goto L17;
            this.f33629a.a();
            return;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }
    }

    public void a(Runnable r2) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
    }

    public g() {
        this.f33628b = new AnonymousClass1(this);
        this.f33627a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f33619a.b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public void c() {
        b(TAG, "startListen");
        IntentFilter r4 = new IntentFilter();
        r4.addAction("obric.intent.action.account.SECURE_LOGIN");
        r4.addAction("obric.intent.action.account.SECURE_LOGOUT");
        r4.addAction("obric.intent.action.account.SECURE_ACCOUNT_INFO_UPDATE");
        if (Build.VERSION.SDK_INT < 33) goto L5;
        ZeusTransformUtils.registerReceiver(this.f33627a, this.f33628b, r4, "com.obric.account.permission.ACCOUNT_STATUS", null, 2, "com.obric.aiagent.plugin");
        return;
    L5:
        ZeusTransformUtils.registerReceiver(this.f33627a, this.f33628b, r4, "com.obric.account.permission.ACCOUNT_STATUS", null, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.c
    public void b() {
        com.obric.matrix.platform.sdk.ones.account.b.a.a(TAG, "onAccountLogin");
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.c
    public void a(int r2) {
        com.obric.matrix.platform.sdk.ones.account.b.a.a(TAG, "onAccountLogout logoutScene = " + r2);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.c
    public void a() {
        com.obric.matrix.platform.sdk.ones.account.b.a.a(TAG, "onAccountInfoUpdate");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
