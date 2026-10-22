package androidx.lifecycle;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: LegacySavedStateHandleController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f2050a = null;

    /* JADX INFO: compiled from: LegacySavedStateHandleController.kt */
    public static final class a implements androidx.savedstate.a.InterfaceC0075a {
        public a() {
        }

        @Override // androidx.savedstate.a.InterfaceC0075a
        public void a(androidx.savedstate.c r6) {
            androidx.savedstate.c r5 = (androidx.savedstate.c) ZeusTransformUtils.wrapperContextForParams(r6, androidx.savedstate.c.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "owner");
            if (ZeusTransformUtils.instanceOf(r5, ap.class) == false) goto L13;
            ao r7 = ((ap) ZeusTransformUtils.preCheckCast(r5, ap.class, "com.obric.aiagent.plugin")).getViewModelStore();
            androidx.savedstate.a r1 = r5.getSavedStateRegistry();
            Iterator<String> r2 = r7.a().iterator();
        L6:
            if (r2.hasNext() == false) goto L9;
            aj r3 = r7.a((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin"));
            d.h.b.o.a(r3);
            h.a(r3, r1, r5.getLifecycle());
            goto L6
        L9:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r7.a(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L15;
            r1.a(a.class);
            return;
        L15:
            return;
        L13:
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    static {
        f2050a = new h();
    }

    private h() {
    }

    public static final SavedStateHandleController a(androidx.savedstate.a r2, i r3, String r4, Bundle r5) {
        d.h.b.o.e(r2, "registry");
        d.h.b.o.e(r3, "lifecycle");
        d.h.b.o.a(r4);
        Bundle r0 = r2.a(r4);
        SavedStateHandleController r1 = new SavedStateHandleController(r4, ac.f1989a.a(r0, r5));
        r1.a(r2, r3);
        f2050a.a(r2, r3);
        return r1;
    }

    public static final void a(aj r2, androidx.savedstate.a r3, i r4) {
        d.h.b.o.e(r2, "viewModel");
        d.h.b.o.e(r3, "registry");
        d.h.b.o.e(r4, "lifecycle");
        SavedStateHandleController r5 = (SavedStateHandleController) ZeusTransformUtils.preCheckCast(r2.b("androidx.lifecycle.savedstate.vm.tag"), SavedStateHandleController.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.b() == true) goto L9;
        r5.a(r3, r4);
        f2050a.a(r3, r4);
        return;
    }

    private final void a(final androidx.savedstate.a r2, final i r3) {
        i.b r1 = r3.b();
        if (r1 != i.b.f2055b) goto L5;
    L8:
        r2.a(a.class);
        return;
    L5:
        if (r1.a(i.b.f2057d) == true) goto L8;
        r3.a((o) ZeusTransformUtils.preCheckCast(new LegacySavedStateHandleController$tryToAddRecreator$1(r3, r2), o.class, "com.obric.aiagent.plugin"));
    }
}
