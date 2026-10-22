package com.bytedanceos.common.privacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.i;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.oui.privacy.e;
import com.obric.oui.window.permission.PrivacyStatementActivity;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes2.dex */
public final class PrivacyUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PrivacyUtils f9901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f9902b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f9903c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f9904d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f9905e = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedanceos.common.privacy.PrivacyUtils$a$a, reason: collision with other inner class name */
        public static final class C0130a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0130a f9906a = null;

            static {
                f9906a = new C0130a();
            }

            public C0130a() {
                super(null);
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f9907a = null;

            static {
                f9907a = new b();
            }

            public b() {
                super(null);
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends PrivacyStatementActivity.a.AbstractC0212a {
        public b() {
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.a.AbstractC0212a
        public void a(Intent r10) {
            q.g(r10, MemorySourceLinkType.INTENT);
            a7.a.f("PrivacyUtils", "modifyStartIntent()");
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.a.AbstractC0212a
        public void b(Activity r10) {
            q.g(r10, "activity");
            a7.a.f("PrivacyUtils", "onActivityCreated()");
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.a.AbstractC0212a
        public void c(Activity r10) {
            q.g(r10, "activity");
            a7.a.f("PrivacyUtils", "onActivityDestroy()");
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.a.AbstractC0212a
        public void d(Activity r10) {
            q.g(r10, "activity");
            a7.a.f("PrivacyUtils", "onActivityPause()");
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.a.AbstractC0212a
        public void e(Activity r10) {
            q.g(r10, "activity");
            a7.a.f("PrivacyUtils", "onActivityResume()");
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.a.AbstractC0212a
        public void f(Activity r10) {
            q.g(r10, "activity");
            a7.a.f("PrivacyUtils", "onActivityStart()");
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.a.AbstractC0212a
        public void g(Activity r10) {
            q.g(r10, "activity");
            a7.a.f("PrivacyUtils", "onActivityStop()");
        }
    }

    public static final class c implements DefaultLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrivacyChecker.Observer f9908a;

        public c(PrivacyChecker.Observer r10) {
            this.f9908a = r10;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(LifecycleOwner r10) {
            q.g(r10, "owner");
            PrivacyChecker.f9899a.c(this.f9908a);
        }
    }

    public static final class d implements PrivacyStatementActivity.PrivacyConsentCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f9909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f9910b;

        public d(WeakReference r10, WeakReference r11) {
            this.f9909a = r10;
            this.f9910b = r11;
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.PrivacyConsentCallback
        public boolean onAgree(Activity r10) {
            return PrivacyStatementActivity.PrivacyConsentCallback.a.a(this, r10);
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.PrivacyConsentCallback
        public void onCancel() {
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.PrivacyConsentCallback
        public void onAgree() {
            PrivacyUtils r10 = PrivacyUtils.f9901a;
            PrivacyUtils.c(r10).tryEmit(a.C0130a.f9906a);
            Context r11 = (ComponentActivity) this.f9909a.get();
            if (r11 != null) goto L5;
            r11 = BaseApplication.c();
        L5:
            q.d(r11);
            PrivacyUtils.d(r10, r11);
            PrivacyChecker.f9899a.b();
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.PrivacyConsentCallback
        public boolean onCancel(Activity r10) {
            q.g(r10, "activity");
            ComponentActivity r11 = (ComponentActivity) this.f9909a.get();
            if (r11 == null) goto L5;
            r11.finishAndRemoveTask();
        L5:
            r10.finish();
            PrivacyChecker.Observer r12 = (PrivacyChecker.Observer) this.f9910b.get();
            if (r12 == null) goto L8;
            PrivacyChecker.f9899a.c(r12);
        L8:
            PrivacyUtils.c(PrivacyUtils.f9901a).tryEmit(a.b.f9907a);
            return true;
        }
    }

    static {
        f9901a = new PrivacyUtils();
        f9902b = kotlin.b.b(PrivacyUtils$_privacyPolicyUserAgreed$2.INSTANCE);
        f9903c = kotlin.b.b(PrivacyUtils$privacyPolicyUserAgreed$2.INSTANCE);
        f9904d = kotlin.b.b(PrivacyUtils$_privacyPolicyUserInteraction$2.INSTANCE);
        f9905e = kotlin.b.b(PrivacyUtils$privacyPolicyUserInteraction$2.INSTANCE);
    }

    public PrivacyUtils() {
    }

    public static final /* synthetic */ boolean a(PrivacyUtils r10, Context r11) {
        return r10.k(r11);
    }

    public static final /* synthetic */ MutableStateFlow b(PrivacyUtils r10) {
        return r10.m();
    }

    public static final /* synthetic */ MutableSharedFlow c(PrivacyUtils r10) {
        return r10.n();
    }

    public static final /* synthetic */ void d(PrivacyUtils r10, Context r11) {
        r10.o(r11);
    }

    public static /* synthetic */ void h(PrivacyUtils r10, ComponentActivity r11, PrivacyChecker.Observer r12, TransitionAnimStyle r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = null;
    L5:
        r10.g(r11, r12, r13);
    }

    public final List e(Context r10) {
        String r11 = r10.getString(R$string.privacy_permission_info);
        q.f(r11, "getString(...)");
        return s.e(new e.a(r11, t.l(new String[]{r10.getString(R$string.privacy_permission_info_item1), r10.getString(R$string.privacy_permission_info_item2), r10.getString(R$string.privacy_permission_info_item3), r10.getString(R$string.privacy_permission_info_item4)})));
    }

    public final PrivacyStatementActivity.a.AbstractC0212a f() {
        return new b();
    }

    public final void g(ComponentActivity r10, PrivacyChecker.Observer r11, TransitionAnimStyle r12) {
        q.g(r10, "activity");
        q.g(r11, "observer");
        PrivacyChecker r13 = PrivacyChecker.f9899a;
        r13.a(r11);
        r10.getLifecycle().a(new c(r11));
        boolean r14 = k(r10);
        i.e("PrivacyUtils", "agreed=" + r14);
        if (r14 == true) goto L7;
        String r15 = r10.getPackageName();
        WeakReference r16 = new WeakReference(r10);
        WeakReference r17 = new WeakReference(r11);
        PrivacyStatementActivity.a.b r18 = new PrivacyStatementActivity.a.b(r10);
        q.d(r15);
        PrivacyStatementActivity.a.b r19 = r18.k(i(r10, r15));
        String r20 = r10.getString(R$string.privacy_sub_title);
        q.f(r20, "getString(...)");
        PrivacyStatementActivity.a.b r21 = r19.e(r20).i(new String[]{"https://os.obriccloud.com/agreement/appstore_privacy", "https://os.obriccloud.com/agreement/appstore_user_agreement"});
        String r22 = r10.getString(R$string.privacy_action_text);
        q.f(r22, "getString(...)");
        PrivacyStatementActivity.a.b r23 = r21.h(r22);
        String r24 = r10.getString(R$string.privacy_action_privacy_policy);
        q.f(r24, "getString(...)");
        String r25 = r10.getString(R$string.privacy_action_user_agreement);
        q.f(r25, "getString(...)");
        PrivacyStatementActivity.a.b r26 = r23.g(t.g(new String[]{r24, r25}));
        String r27 = r10.getString(com.obric.common.oui.R$string.oui_exit);
        q.f(r27, "getString(...)");
        PrivacyStatementActivity.a.b r28 = r26.b(r27);
        String r29 = r10.getString(com.obric.common.oui.R$string.oui_agree);
        q.f(r29, "getString(...)");
        r28.a(r29).j(true).l().d(r15).c(new d(r16, r17)).f(e(r10)).m(f());
        if (r12 == null) goto L9;
        xb.b.a(r10, r12);
        return;
    L9:
        return;
    L7:
        r13.b();
        r13.c(r11);
    }

    public final String i(Context r10, String r11) {
        PackageManager r12 = r10.getPackageManager();
        ApplicationInfo r13 = r12.getApplicationInfo(r11, 0);     // Catch: PackageManager.NameNotFoundException -> L5
        q.f(r13, "getApplicationInfo(...)");     // Catch: PackageManager.NameNotFoundException -> L5
        String r14 = r12.getApplicationLabel(r13).toString();     // Catch: PackageManager.NameNotFoundException -> L5
        a7.a.b("PrivacyUtils", "AppLabel: " + r14);     // Catch: PackageManager.NameNotFoundException -> L5
        return r14;
    L5:
        a7.a.d("PrivacyUtils", "Get app label failed");
        String r15 = r10.getString(R$string.app_name);
        q.f(r15, "getString(...)");
        return r15;
    }

    public final StateFlow j() {
        return (StateFlow) f9903c.getValue();
    }

    public final boolean k(Context r10) {
        return !b0.n().m("is_first", null, r10, true).booleanValue();
    }

    public final SharedFlow l() {
        return (SharedFlow) f9905e.getValue();
    }

    public final MutableStateFlow m() {
        return (MutableStateFlow) f9902b.getValue();
    }

    public final MutableSharedFlow n() {
        return (MutableSharedFlow) f9904d.getValue();
    }

    public final void o(Context r10) {
        b0.n().C("is_first", false, null, r10);
        m().setValue(Boolean.TRUE);
    }
}
