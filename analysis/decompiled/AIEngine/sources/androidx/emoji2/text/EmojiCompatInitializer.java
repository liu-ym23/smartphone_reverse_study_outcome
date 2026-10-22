package androidx.emoji2.text;

import android.content.Context;
import android.os.Trace;
import androidx.emoji2.text.d;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.q;
import com.stepos.core.model.manager.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class EmojiCompatInitializer implements b2.b<Boolean> {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends d.c {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final Context f1922a;

        public b(Context context) {
            this.f1922a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.d.h
        public final void a(d.i iVar) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new android.llama.cpp.a("EmojiCompatInitializer", 2));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutor.execute(new i(this, iVar, threadPoolExecutor, 5));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (d.f1927k != null) {
                    d.a().c();
                }
            } finally {
                Trace.endSection();
            }
        }
    }

    @Override // b2.b
    public final List<Class<? extends b2.b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // b2.b
    public final Boolean b(Context context) {
        Object objB;
        a aVar = new a(new b(context));
        aVar.f1940b = 1;
        if (d.f1927k == null) {
            synchronized (d.f1926j) {
                try {
                    if (d.f1927k == null) {
                        d.f1927k = new d(aVar);
                    }
                } finally {
                }
            }
        }
        b2.a aVarC = b2.a.c(context);
        aVarC.getClass();
        synchronized (b2.a.f3037e) {
            try {
                objB = aVarC.f3038a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = aVarC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        Lifecycle lifecycle = ((q) objB).getLifecycle();
        lifecycle.a(new i1.b(this, lifecycle));
        return Boolean.TRUE;
    }
}
