package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: SavedStateViewModelFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ag extends am.d implements am.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f2004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am.b f2005b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f2006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f2007e;
    private androidx.savedstate.a f;

    public ag() {
        this.f2005b = (am.b) ZeusTransformUtils.preCheckCast(new am.a(), am.b.class, "com.obric.aiagent.plugin");
    }

    public ag(Application r3, androidx.savedstate.c r4, Bundle r5) {
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        androidx.savedstate.c r7 = (androidx.savedstate.c) ZeusTransformUtils.wrapperContextForParams(r4, androidx.savedstate.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "owner");
        this.f = r7.getSavedStateRegistry();
        this.f2007e = r7.getLifecycle();
        this.f2006d = r5;
        this.f2004a = r6;
        if (r6 == null) goto L5;
        am.b r8 = (am.b) ZeusTransformUtils.preCheckCast(am.a.f2028a.a(r6), am.b.class, "com.obric.aiagent.plugin");
    L6:
        this.f2005b = r8;
        return;
    L5:
        r8 = (am.b) ZeusTransformUtils.preCheckCast(new am.a(), am.b.class, "com.obric.aiagent.plugin");
        goto L6
    }

    @Override // androidx.lifecycle.am.b
    public <T extends aj> T a(Class<T> r5, androidx.lifecycle.a.a r6) {
        d.h.b.o.e(r5, "modelClass");
        d.h.b.o.e(r6, "extras");
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.a(am.c.f2035e), String.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L28;
        if (r6.a(ad.f1994a) == null) goto L22;
        if (r6.a(ad.f1995b) == null) goto L22;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(r6.a(am.a.f2029b), Application.class, "com.obric.aiagent.plugin");
        boolean r2 = a.class.isAssignableFrom(r5);
        if (r2 == false) goto L12;
        if (r1 == null) goto L12;
        Constructor r3 = ah.a(r5, ah.a());
    L13:
        if (r3 != null) goto L17;
        return (T) this.f2005b.a(r5, r6);
    L17:
        if (r2 == false) goto L30;
        if (r1 == null) goto L30;
        return (T) ah.a(r5, r3, new Object[]{r1, ad.a(r6)});
    L30:
        return (T) ah.a(r5, r3, new Object[]{ad.a(r6)});
    L12:
        r3 = ah.a(r5, ah.b());
    L22:
        if (this.f2007e == null) goto L26;
        return (T) a(r0, r5);
    L26:
        throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
    L28:
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    public final <T extends aj> T a(String r6, Class<T> r7) {
        d.h.b.o.e(r6, "key");
        d.h.b.o.e(r7, "modelClass");
        i r0 = this.f2007e;
        if (r0 == null) goto L25;
        boolean r1 = a.class.isAssignableFrom(r7);
        if (r1 == true) goto L7;
    L9:
        Constructor r2 = ah.a(r7, ah.b());
    L10:
        if (r2 == null) goto L12;
        androidx.savedstate.a r3 = this.f;
        d.h.b.o.a(r3);
        SavedStateHandleController r8 = h.a(r3, r0, r6, this.f2006d);
        if (r1 == false) goto L21;
        Application r5 = this.f2004a;
        if (r5 == null) goto L21;
        d.h.b.o.a(r5);
        T r9 = (T) ah.a(r7, r2, new Object[]{r5, r8.a()});
    L22:
        r9.a("androidx.lifecycle.savedstate.vm.tag", r8);
        return r9;
    L21:
        r9 = (T) ah.a(r7, r2, new Object[]{r8.a()});
        goto L22
    L12:
        if (this.f2004a == null) goto L15;
        return (T) this.f2005b.a(r7);
    L15:
        return (T) am.c.f2034d.a().a(r7);
    L7:
        if (this.f2004a == null) goto L9;
        r2 = ah.a(r7, ah.a());
        goto L10
    L25:
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.am.b
    public <T extends aj> T a(Class<T> r2) {
        d.h.b.o.e(r2, "modelClass");
        String r0 = r2.getCanonicalName();
        if (r0 == null) goto L7;
        return (T) a(r0, r2);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.am.d
    public void a(aj r2) {
        d.h.b.o.e(r2, "viewModel");
        if (this.f2007e == null) goto L6;
        androidx.savedstate.a r0 = this.f;
        d.h.b.o.a(r0);
        i r1 = this.f2007e;
        d.h.b.o.a(r1);
        h.a(r2, r0, r1);
        return;
    }
}
