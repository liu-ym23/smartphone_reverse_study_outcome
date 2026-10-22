package com.obric.common.upgrade;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import androidx.lifecycle.k;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import java.io.File;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: AppUpgradeHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f32609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f32610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private VersionCheckResponse f32611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32612d;

    /* JADX INFO: compiled from: AppUpgradeHelper.kt */
    public static final class a implements com.obric.common.upgrade.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Boolean, x> f32613a;

        a(d.h.a.b<? super Boolean, x> r3) {
            this.f32613a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.common.upgrade.c.a
        public void a() {
            this.f32613a.invoke(true);
        }

        @Override // com.obric.common.upgrade.c.a
        public void b() {
            Loog.INSTANCE.i("OAppUpgrade", "缺少应用安装权限");
        }
    }

    /* JADX INFO: compiled from: AppUpgradeHelper.kt */
    public static final class b implements com.obric.common.upgrade.c.a {
        @Override // com.obric.common.upgrade.c.a
        public void b() {
        }

        b() {
        }

        @Override // com.obric.common.upgrade.c.a
        public void a() {
            Loog.INSTANCE.i("OAppUpgrade", "用户去掉安装权限设置界面后，回来还是没有安装权限");
        }
    }

    /* JADX INFO: compiled from: AppUpgradeHelper.kt */
    @d.c.b.a.f(b = "AppUpgradeHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.common.upgrade.AppUpgradeHelper$onStartInstallResult$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f32615b;

        c(d r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32615b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f32615b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f32614a != 0) goto L7;
            o.a(r5);
            Toast.makeText((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(this.f32615b), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(this.f32615b), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_upgrade_enable_unknown_app_installs, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_upgrade_enable_unknown_app_installs")), CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.common.upgrade.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppUpgradeHelper.kt */
    public static final class C0894d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f32616a;

        C0894d(d r1) {
            this.f32616a = r1;
        }

        @Override // com.obric.common.upgrade.g
        public void a(int r1, long r2, long r4, String r6) {
            Loog.INSTANCE.d("OAppUpgrade", "下载进度: " + r1 + '%');
        }

        @Override // com.obric.common.upgrade.g
        public void a(VersionCheckResponse r4) {
            d.h.b.o.e(r4, "response");
            Loog.INSTANCE.i("OAppUpgrade", "下载完成了 " + r4.getApkPath());
            this.f32616a.a(r4);
            this.f32616a.b();
        }

        @Override // com.obric.common.upgrade.g
        public void a(int r4, String r5) {
            d.h.b.o.e(r5, "errorMsg");
            Loog.INSTANCE.i("OAppUpgrade", "下载失败 " + r4 + ". " + r5);
            this.f32616a.a(null);
        }
    }

    /* JADX INFO: compiled from: AppUpgradeHelper.kt */
    @d.c.b.a.f(b = "AppUpgradeHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.common.upgrade.AppUpgradeHelper$showUpgradeUI$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f32618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ VersionCheckResponse f32619c;

        e(d r3, VersionCheckResponse r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32618b = r3;
            this.f32619c = r4;
            super(2, r6);
        }

        /* JADX INFO: renamed from: lambda$H5_IX-XbolE_qWuCJI172bE6JZs, reason: not valid java name */
        public static /* synthetic */ x m937lambda$H5_IXXbolE_qWuCJI172bE6JZs(d r0, boolean r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ x lambda$ZrpMwR5mOXaFsZQFhPKufjFowdk(d r0, DialogInterface r1, int r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ x lambda$aBkjSXVONCvoX5GRfH5gqbl_6Vk(d r0, VersionCheckResponse r1, DialogInterface r2, int r3) {
            return a(r0, r1, r2, r3);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f32618b, this.f32619c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f32617a != 0) goto L7;
            o.a(r9);
            Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(this.f32618b), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.a(r0, "null cannot be cast to non-null type android.app.Activity");
            com.obric.oui.dialog.v2.alert.a r10 = com.obric.oui.dialog.v2.alert.a.a(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(this.f32618b), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_upgrade_found_new_version, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_upgrade_found_new_version"), new Object[]{this.f32619c.getVersionName()}), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(this.f32619c.getUpgradeInfo()), CharSequence.class, "com.obric.aiagent.plugin")), false, 1, null);
            String r1 = ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(this.f32618b), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_upgrade_action_upgrade, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_upgrade_action_upgrade"));
            d.h.b.o.c(r1, "getString(...)");
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
            final d r3 = this.f32618b;
            final VersionCheckResponse r5 = this.f32619c;
            com.obric.oui.dialog.v2.alert.a r11 = r10.a(r2, new $$Lambda$d$e$aBkjSXVONCvoX5GRfH5gqbl_6Vk(r3, r5));
            String r4 = ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(this.f32618b), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_upgrade_action_later, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_upgrade_action_later"));
            d.h.b.o.c(r4, "getString(...)");
            CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
            final d r8 = this.f32618b;
            com.obric.oui.dialog.v2.alert.a r12 = r11.b(r6, new $$Lambda$d$e$ZrpMwR5mOXaFsZQFhPKufjFowdk(r8));
            com.obric.common.upgrade.e.f32625a.a().c();
            r12.h();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final x a(final d r1, VersionCheckResponse r2, DialogInterface r3, int r4) {
            DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
            String r6 = r2.getApkPath();
            d.h.b.o.a(r6);
            d.a(r1, r6, new $$Lambda$d$e$H5_IXXbolE_qWuCJI172bE6JZs(r1));
            r5.dismiss();
            return x.f38692a;
        }

        private static final x a(d r0, boolean r1) {
            r0.b(r1);
            return x.f38692a;
        }

        private static final x a(d r1, DialogInterface r2, int r3) {
            ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin")).dismiss();
            r1.a(null);
            r1.a(false);
            Loog.INSTANCE.i("OAppUpgrade", "用户取消了升级");
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: lambda$3IG-kChWP3_zCsw6gpAVmK7mzPs, reason: not valid java name */
    public static /* synthetic */ x m936lambda$3IGkChWP3_zCsw6gpAVmK7mzPs(d r0, VersionCheckResponse r1) {
        return a(r0, r1);
    }

    public d(Activity r3, k r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "activity");
        d.h.b.o.e(r4, "lifecycleScope");
        this.f32609a = ZeusTransformUtils.wrapperContext2Activity(r5, "com.obric.aiagent.plugin");
        this.f32610b = r4;
    }

    public static final /* synthetic */ Activity a(d r0) {
        return r0.f32609a;
    }

    public static final /* synthetic */ void a(d r2, String r3, d.h.a.b r4) {
        r2.a(r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void a(VersionCheckResponse r1) {
        this.f32611c = r1;
    }

    public final void a(boolean r1) {
        this.f32612d = r1;
    }

    public final void a() {
        if (com.obric.common.upgrade.e.f32625a.b() == true) goto L7;
        Loog.INSTANCE.i("OAppUpgrade", "还未完成初始化，本次请求return");
        return;
    L7:
        if (this.f32612d == false) goto L10;
        Loog.INSTANCE.i("OAppUpgrade", "mRequestingPermission为true，不再重复请求和弹窗了");
        return;
    L10:
        com.obric.common.upgrade.e.f32625a.a().a(true, new $$Lambda$d$3IGkChWP3_zCsw6gpAVmK7mzPs(this));
    }

    private static final x a(d r1, VersionCheckResponse r2) {
        d.h.b.o.e(r2, "response");
        r1.b(r2);
        return x.f38692a;
    }

    private final void b(VersionCheckResponse r6) {
        if (r6.getHasNewVersion() == false) goto L5;
        Loog.INSTANCE.i("OAppUpgrade", "有新版本，版本号: " + r6.getVersionCode() + ", 下载url: " + r6.getApkUrl() + ", md5: " + r6.getMd5() + ", 升级模式" + r6.getUpgradeMode());
        com.obric.common.upgrade.e.f32625a.a().a(true, r6, (g) ZeusTransformUtils.preCheckCast(new C0894d(this), g.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        Loog.INSTANCE.i("OAppUpgrade", "没有新版本");
    }

    public final void b() {
        if (com.obric.common.upgrade.e.f32625a.b() == true) goto L5;
        return;
    L5:
        Activity r0 = this.f32609a;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isFinishing() == true) goto L28;
        VersionCheckResponse r1 = this.f32611c;
        if (r1 != null) goto L13;
        return;
    L13:
        d.h.b.o.a(r1);
        if (r1.getHasNewVersion() == false) goto L27;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1.getApkPath(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L18;
    L21:
        boolean r3 = true;
    L22:
        if (r3 == true) goto L29;
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(this.f32610b, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new e(this, r1, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    L29:
        return;
    L18:
        if (r2.length() == 0) goto L21;
        r3 = false;
        goto L22
    L27:
        return;
    }

    public final void b(boolean r9) {
        if (r9 == true) goto L5;
        Loog.INSTANCE.i("OAppUpgrade", "has no permission");
        this.f32612d = true;
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(this.f32610b, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        com.obric.common.upgrade.e r10 = com.obric.common.upgrade.e.f32625a.a();
        Activity r8 = this.f32609a;
        d.h.b.o.a(r8, "null cannot be cast to non-null type android.app.Activity");
        r10.a(r8, 100);
        return;
    }

    private final void a(String r4, d.h.a.b<? super Boolean, x> r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.common.upgrade.e r0 = com.obric.common.upgrade.e.f32625a.a();
        Activity r3 = this.f32609a;
        d.h.b.o.a(r3, "null cannot be cast to non-null type android.app.Activity");
        if (r0.a((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin")) == false) goto L5;
        Loog.INSTANCE.i("OAppUpgrade", "用App安装权限，开始抛intent安装");
        File r7 = new File(r4);
        com.obric.common.upgrade.e.f32625a.a().a(r7, (com.obric.common.upgrade.c.a) ZeusTransformUtils.preCheckCast(new a(r6), com.obric.common.upgrade.c.a.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r6.invoke(false);
    }

    public final void c() {
        if (com.obric.common.upgrade.e.f32625a.b() == true) goto L5;
        return;
    L5:
        if (this.f32612d == true) goto L7;
        return;
    L7:
        if (this.f32611c == null) goto L14;
        com.obric.common.upgrade.e r0 = com.obric.common.upgrade.e.f32625a.a();
        Activity r1 = this.f32609a;
        d.h.b.o.a(r1, "null cannot be cast to non-null type android.app.Activity");
        if (r0.a((Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.aiagent.plugin")) == false) goto L15;
        this.f32612d = false;
        com.obric.common.upgrade.e r2 = com.obric.common.upgrade.e.f32625a.a();
        VersionCheckResponse r4 = this.f32611c;
        d.h.b.o.a(r4);
        r2.a(new File(r4.getApkPath()), (com.obric.common.upgrade.c.a) ZeusTransformUtils.preCheckCast(new b(), com.obric.common.upgrade.c.a.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        return;
    }
}
