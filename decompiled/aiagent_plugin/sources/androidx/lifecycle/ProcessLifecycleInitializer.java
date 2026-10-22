package androidx.lifecycle;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ProcessLifecycleInitializer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements androidx.startup.b<p> {
    public ProcessLifecycleInitializer() {
    }

    @Override // androidx.startup.b
    public /* synthetic */ p c(Context r3) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        androidx.startup.a r0 = androidx.startup.a.a(r4);
        d.h.b.o.c(r0, "getInstance(context)");
        if (r0.b(getClass()) == false) goto L7;
        LifecycleDispatcher.a(r4);
        aa.f1972a.a(r4);
        return aa.f1972a.a();
    L7:
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }

    @Override // androidx.startup.b
    public List<Class<? extends androidx.startup.b<?>>> b() {
        return d.a.p.b();
    }
}
