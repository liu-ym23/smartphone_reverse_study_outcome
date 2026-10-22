package androidx.lifecycle;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SavedStateHandleSupport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.lifecycle.a.a.b<androidx.savedstate.c> f1994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final androidx.lifecycle.a.a.b<ap> f1995b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final androidx.lifecycle.a.a.b<Bundle> f1996c = null;

    /* JADX INFO: compiled from: SavedStateHandleSupport.kt */
    public static final class a implements androidx.lifecycle.a.a.b<Bundle> {
        a() {
        }
    }

    /* JADX INFO: compiled from: SavedStateHandleSupport.kt */
    public static final class b implements androidx.lifecycle.a.a.b<androidx.savedstate.c> {
        b() {
        }
    }

    /* JADX INFO: compiled from: SavedStateHandleSupport.kt */
    public static final class c implements androidx.lifecycle.a.a.b<ap> {
        c() {
        }
    }

    /* JADX INFO: compiled from: SavedStateHandleSupport.kt */
    static final class d extends d.h.b.p implements d.h.a.b<androidx.lifecycle.a.a, af> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f1997a = null;

        static {
            f1997a = new d();
        }

        d() {
            super(1);
        }

        public final af a(androidx.lifecycle.a.a r1) {
            d.h.b.o.e(r1, "$this$initializer");
            return new af();
        }

        @Override // d.h.a.b
        public /* synthetic */ af invoke(androidx.lifecycle.a.a r3) {
            return a((androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r3, androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final <T extends androidx.savedstate.c & ap> void a(T r5) {
        androidx.savedstate.c r6 = (androidx.savedstate.c) ZeusTransformUtils.wrapperContextForParams(r5, androidx.savedstate.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        i.b r0 = r6.getLifecycle().b();
        if (r0 != i.b.f2055b) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L15;
        if (r6.getSavedStateRegistry().b("androidx.lifecycle.internal.SavedStateHandlesProvider") != null) goto L16;
        ae r2 = new ae(r6.getSavedStateRegistry(), (ap) ZeusTransformUtils.preCheckCast(r6, ap.class, "com.obric.aiagent.plugin"));
        r6.getSavedStateRegistry().a("androidx.lifecycle.internal.SavedStateHandlesProvider", (androidx.savedstate.a.c) ZeusTransformUtils.preCheckCast(r2, androidx.savedstate.a.c.class, "com.obric.aiagent.plugin"));
        r6.getLifecycle().a((o) ZeusTransformUtils.preCheckCast(new SavedStateHandleAttacher(r2), o.class, "com.obric.aiagent.plugin"));
        return;
    L16:
        return;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r0 == i.b.f2056c) goto L8;
        r1 = false;
        goto L9
    }

    private static final ac a(androidx.savedstate.c r3, ap r4, String r5, Bundle r6) {
        androidx.savedstate.c r7 = (androidx.savedstate.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.savedstate.c.class, "com.obric.aiagent.plugin");
        ap r8 = (ap) ZeusTransformUtils.wrapperContextForParams(r4, ap.class, "com.obric.aiagent.plugin");
        ae r9 = b(r7);
        af r10 = a(r8);
        ac r0 = (ac) ZeusTransformUtils.preCheckCast(r10.b().get(r5), ac.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        ac r1 = ac.f1989a.a(r9.a(r5), r6);
        r10.b().put(r5, r1);
        return r1;
    L6:
        return r0;
    }

    public static final ac a(androidx.lifecycle.a.a r5) {
        d.h.b.o.e(r5, "<this>");
        androidx.savedstate.c r0 = (androidx.savedstate.c) ZeusTransformUtils.preCheckCast(r5.a(f1994a), androidx.savedstate.c.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L15;
        ap r1 = (ap) ZeusTransformUtils.preCheckCast(r5.a(f1995b), ap.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        Bundle r3 = (Bundle) ZeusTransformUtils.preCheckCast(r5.a(f1996c), Bundle.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.a(am.c.f2035e), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L11;
        return a(r0, r1, r6, r3);
    L11:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    L13:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
    L15:
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final ae b(androidx.savedstate.c r2) {
        androidx.savedstate.c r3 = (androidx.savedstate.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.savedstate.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        androidx.savedstate.a.c r4 = r3.getSavedStateRegistry().b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        if (ZeusTransformUtils.instanceOf(r4, ae.class) == false) goto L5;
        ae r5 = (ae) ZeusTransformUtils.preCheckCast(r4, ae.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 == null) goto L9;
        return r5;
    L9:
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    L5:
        r5 = null;
        goto L6
    }

    static {
        f1994a = (androidx.lifecycle.a.a.b) ZeusTransformUtils.preCheckCast(new b(), androidx.lifecycle.a.a.b.class, "com.obric.aiagent.plugin");
        f1995b = (androidx.lifecycle.a.a.b) ZeusTransformUtils.preCheckCast(new c(), androidx.lifecycle.a.a.b.class, "com.obric.aiagent.plugin");
        f1996c = (androidx.lifecycle.a.a.b) ZeusTransformUtils.preCheckCast(new a(), androidx.lifecycle.a.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final af a(ap r4) {
        ap r5 = (ap) ZeusTransformUtils.wrapperContextForParams(r4, ap.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        androidx.lifecycle.a.c r0 = new androidx.lifecycle.a.c();
        d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.preCheckCast(d.f1997a, d.h.a.b.class, "com.obric.aiagent.plugin");
        r0.a(d.h.b.aa.b(af.class), r2);
        return (af) ZeusTransformUtils.preCheckCast(new am(r5, r0.a()).a("androidx.lifecycle.internal.SavedStateHandlesVM", af.class), af.class, "com.obric.aiagent.plugin");
    }
}
