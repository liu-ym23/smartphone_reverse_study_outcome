package com.obric.matrix.platform.sdk.ones.account;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AccountStatusListener.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d implements com.obric.matrix.platform.sdk.ones.account.a.c {
    private static final String TAG = "AccountSDK_AccountStatusListener";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f33616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PluginBroadcastReceiver f33617b;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.account.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: AccountStatusListener.java */
    class AnonymousClass1 extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f33618a;

        public static /* synthetic */ void lambda$R9vIGnShb44OtMqkxKrq2ovVzuI(AnonymousClass1 r0, Intent r1) {
            r0.a(r1);
        }

        AnonymousClass1(d r1) {
            this.f33618a = r1;
        }

        public void onReceive(Context r3, final Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this.f33618a.a(new $$Lambda$d$1$R9vIGnShb44OtMqkxKrq2ovVzuI(this, r4));
        }

        private /* synthetic */ void a(Intent r3) {
            if (r3.getAction().equals("obric.intent.action.account.LOGIN") == false) goto L6;
            this.f33618a.b();
            return;
        L6:
            if (r3.getAction().equals("obric.intent.action.account.LOGOUT") == false) goto L9;
            int r4 = r3.getIntExtra("obric.intent.extra.account.LOGOUT_SCENE", 0);
            this.f33618a.a(r4);
            return;
        L9:
            if (r3.getAction().equals("obric.intent.action.account.ACCOUNT_INFO_UPDATE") == false) goto L14;
            this.f33618a.a();
            return;
        }
    }

    public void a(Runnable r2) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
    }

    public d() {
        this.f33617b = new AnonymousClass1(this);
        this.f33616a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f33619a.b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public void c() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("obric.intent.action.account.LOGIN");
        r0.addAction("obric.intent.action.account.LOGOUT");
        r0.addAction("obric.intent.action.account.ACCOUNT_INFO_UPDATE");
        if (Build.VERSION.SDK_INT < 33) goto L5;
        ZeusTransformUtils.registerReceiver(this.f33616a, this.f33617b, r0, 2, "com.obric.aiagent.plugin");
        return;
    L5:
        ZeusTransformUtils.registerReceiver(this.f33616a, this.f33617b, r0, "com.obric.aiagent.plugin");
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
}
