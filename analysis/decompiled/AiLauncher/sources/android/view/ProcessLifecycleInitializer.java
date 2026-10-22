package android.view;

import Z8.C1173v;
import android.content.Context;
import android.view.C;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import n1.C4935a;
import n1.b;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleInitializer;", "Ln1/b;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "Landroid/content/Context;", "context", "c", "(Landroid/content/Context;)Landroidx/lifecycle/LifecycleOwner;", "", "Ljava/lang/Class;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements b<LifecycleOwner> {
    @Override // n1.b
    public List<Class<? extends b<?>>> a() {
        return C1173v.m();
    }

    @Override // n1.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public LifecycleOwner b(Context context) {
        p.i(context, "context");
        C4935a c4935aE = C4935a.e(context);
        p.h(c4935aE, "getInstance(...)");
        if (!c4935aE.g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        C1394l.a(context);
        C.Companion companion = C.INSTANCE;
        companion.b(context);
        return companion.a();
    }
}
