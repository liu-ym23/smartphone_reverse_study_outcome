package androidx.fragment.app;

import androidx.lifecycle.aj;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    static final class a extends d.h.b.p implements d.h.a.a<am.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f1879a;

        a(Fragment r1) {
            this.f1879a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ am.b invoke() {
            return a();
        }

        public final am.b a() {
            return this.f1879a.getDefaultViewModelProviderFactory();
        }
    }

    public static final <VM extends aj> d.f<VM> a(Fragment r2, d.m.c<VM> r3, d.h.a.a<? extends ao> r4, d.h.a.a<? extends am.b> r5) {
        d.m.c r6 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r3, d.m.c.class, "com.obric.aiagent.plugin");
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "$this$createViewModelLazy");
        d.h.b.o.e(r6, "viewModelClass");
        d.h.b.o.e(r7, "storeProducer");
        if (r8 != null) goto L7;
        r8 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r2), d.h.a.a.class, "com.obric.aiagent.plugin");
    L7:
        return (d.f) ZeusTransformUtils.preCheckCast(new al(r6, r7, r8), d.f.class, "com.obric.aiagent.plugin");
    }
}
