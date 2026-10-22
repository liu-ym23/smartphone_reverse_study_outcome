package androidx.lifecycle;

import W3.C0403n;
import android.content.Context;
import androidx.lifecycle.F;
import f0.InterfaceC0693a;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements InterfaceC0693a<InterfaceC0539t> {
    @Override // f0.InterfaceC0693a
    public List<Class<? extends InterfaceC0693a<?>>> a() {
        return C0403n.h();
    }

    @Override // f0.InterfaceC0693a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC0539t b(Context context) {
        j4.k.g(context, "context");
        androidx.startup.a aVarE = androidx.startup.a.e(context);
        j4.k.f(aVarE, "getInstance(context)");
        if (!aVarE.g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        C0536p.a(context);
        F.b bVar = F.f10795i;
        bVar.b(context);
        return bVar.a();
    }
}
