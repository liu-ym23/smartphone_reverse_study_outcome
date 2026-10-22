package com.bytedanceos.appstore.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.s;
import com.bytedanceos.appstore.download.service.AppsInstallService;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.download.AppsDownloadService;
import com.bytedanceos.common.f;
import com.bytedanceos.common.privacy.PrivacyChecker;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.utils.PermissionUtil;
import com.bytedanceos.common.utils.c;
import com.obric.appstore.R;
import com.obric.appstore.buss.recommend.RecommendFragment;
import com.obric.appstore.util.m;
import com.obric.appstore.util.n;
import com.obric.appstore.util.q;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u0004J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u000eJ\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b¨\u0006 "}, d2 = {"Lcom/bytedanceos/appstore/ui/MainActivity;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/bytedanceos/common/privacy/PrivacyChecker$Observer;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onPrivacyAgreed", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "onPause", "onDestroy", FixCard.FixStyle.KEY_Y, FixCard.FixStyle.KEY_X, "u", "z", "v", "w", "checkShouldShowPrivacyDialog", "", "a", "Z", "shouldCountLaunchForAutoUpdatePrompt", "b", "didProcessAutoUpdatePromptForThisCreate", "c", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\ncom/bytedanceos/appstore/ui/MainActivity\n+ 2 FragmentManager.kt\nandroidx/fragment/app/FragmentManagerKt\n+ 3 FragmentTransaction.kt\nandroidx/fragment/app/FragmentTransactionKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,282:1\n28#2,6:283\n34#2,6:294\n39#3,5:289\n1#4:300\n*S KotlinDebug\n*F\n+ 1 MainActivity.kt\ncom/bytedanceos/appstore/ui/MainActivity\n*L\n69#1:283,6\n69#1:294,6\n70#1:289,5\n*E\n"})
public final class MainActivity extends FragmentActivity implements PrivacyChecker.Observer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9436c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f9437d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9439b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final boolean a() {
            return MainActivity.s();
        }

        public final void b(boolean r10) {
            MainActivity.t(r10);
        }

        public a() {
        }
    }

    static {
        f9436c = new a(null);
    }

    public MainActivity() {
        super(R.layout.activity_main);
    }

    public static final /* synthetic */ boolean s() {
        return f9437d;
    }

    public static final /* synthetic */ void t(boolean r10) {
        f9437d = r10;
    }

    public final void checkShouldShowPrivacyDialog() {
        PrivacyUtils.h(PrivacyUtils.f9901a, this, this, null, 4, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        cc.a.C0070a r11 = cc.a.f6118j;
        r11.a().h("main_act_create");
        super.onCreate(r10);
        q.a(this);
        q.a(this);
        if (r10 != null) goto L5;
        boolean r12 = true;
    L6:
        this.f9438a = r12;
        this.f9439b = false;
        if (r10 != null) goto L9;
        FragmentManager r13 = getSupportFragmentManager();
        kotlin.jvm.internal.q.f(r13, "getSupportFragmentManager(...)");
        FragmentTransaction r14 = r13.o();
        kotlin.jvm.internal.q.f(r14, "beginTransaction()");
        kotlin.jvm.internal.q.f(r14.c(R.id.nav_host_fragment, RecommendFragment.class, null, null), "add(containerViewId, F::class.java, args, tag)");
        r14.j();
    L9:
        checkShouldShowPrivacyDialog();
        r11.a().g("main_act_create");
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Intent r10 = new Intent(this, AppsInstallService.class);
        r10.putExtra("message_what", 49);
        startService(r10);
        e.h0();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent r10) {
        kotlin.jvm.internal.q.g(r10, MemorySourceLinkType.INTENT);
        super.onNewIntent(r10);
        setIntent(r10);
        checkShouldShowPrivacyDialog();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BaseApplication.c().w(false);
    }

    @Override // com.bytedanceos.common.privacy.PrivacyChecker.Observer
    public void onPrivacyAgreed() {
        Intent r10 = getIntent();
        kotlin.jvm.internal.q.f(r10, "getIntent(...)");
        z(r10);
        u(getIntent());
        PermissionUtil.requestNotificationPermission(this);
        m.a("appstore_setting_value", new AnonymousClass1(this));
        x();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        cc.a.C0070a r10 = cc.a.f6118j;
        r10.a().h("main_act_resume");
        super.onResume();
        BaseApplication.c().w(true);
        com.bytedanceos.appstore.datacache.a.N0().z0();
        BaseApplication.c().b().P();
        Intent r11 = getIntent();
        if (r11 == null) goto L5;
        v(r11);
    L5:
        r10.a().g("main_act_resume");
    }

    public final void u(Intent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Bundle r11 = r10.getExtras();
        if (r11 == null) goto L7;
        Object r12 = r11.get("notification_param_key");
    L8:
        if (r12 != null) goto L10;
        w(r10);
        return;
    L10:
        if (kotlin.jvm.internal.q.b("myapp_tab", r12) == false) goto L13;
        n.f11086a.d(this, f.f9823a.a());
        return;
    L13:
        Bundle r13 = r10.getExtras();
        if (r13 == null) goto L20;
        String r14 = r13.getString("Action");
        if (r14 == null) goto L21;
        r10.setClass(BaseApplication.c(), AppsDownloadService.class);
        r10.setAction(r14);
        BaseApplication.c().startService(r10);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r12 = null;
        goto L8
    }

    public final void v(Intent r10) {
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L5
        if (TextUtils.equals("bytedanceos.appstore.recommend.app.detail.internal", r10.getAction()) == false) goto L7;
        c.p(this, r10);     // Catch: Throwable -> L5
        r10.setAction(null);     // Catch: Throwable -> L5
    L7:
        Object r12 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L5
    L10:
        Throwable r13 = Result.m38exceptionOrNullimpl(r12);
        if (r13 == null) goto L16;
        r13.printStackTrace();
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.a r14 = Result.Companion;
        r12 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L10
    }

    public final void w(Intent r10) {
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L10
        String r12 = r10.getAction();     // Catch: Throwable -> L10
        if (r12 != null) goto L5;
    L22:
        Object r13 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L10
    L25:
        Throwable r14 = Result.m38exceptionOrNullimpl(r13);
        if (r14 == null) goto L31;
        r14.printStackTrace();
        return;
    L31:
        return;
    L5:
        switch(r12.hashCode()) {
            case -1440625748: goto L20;
            case 34760579: goto L16;
            case 540402861: goto L13;
            case 1762905888: goto L8;
            default: goto L22;
        };     // Catch: Throwable -> L10
    L8:
        if (r12.equals("com.bytedanceos.common.update") == false) goto L22;
    L21:
        n.f11086a.d(this, f.f9823a.c());     // Catch: Throwable -> L10
        goto L22
    L13:
        if (r12.equals("bytedanceos.appstore.recommend.app.detail.internal.update_all") == true) goto L21;
    L16:
        if (r12.equals("com.bytedanceos.common.my") == false) goto L22;
        n.f11086a.d(this, f.f9823a.a());     // Catch: Throwable -> L10
        goto L22
    L20:
        if (r12.equals("bytedanceos.appstore.recommend.app.detail.internal") == false) goto L22;
    L10:
        th = move-exception;
        Result.a r15 = Result.Companion;
        r13 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L25
    }

    public final void x() {
        if (this.f9439b == false) goto L5;
        return;
    L5:
        this.f9439b = true;
        if (this.f9438a == true) goto L8;
        return;
    L8:
        this.f9438a = false;
        Context r10 = getApplicationContext();
        h.d(s.a(this), null, null, new MainActivity$maybeShowAutoUpdatePrompt$1(r10, this, null), 3, null);
    }

    public final void y() {
    }

    public final void z(Intent r10) {
        h.d(s.a(this), null, null, new MainActivity$startStore$1(this, null), 3, null);
    }
}
