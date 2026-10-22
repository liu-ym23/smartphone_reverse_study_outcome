package com.stepos.ailauncher.task.common;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import coil.a;
import coil.c;
import coil.decode.i;
import coil.memory.MemoryCache;
import com.stepos.ailauncher.common.utils.C3197a;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/task/common/h;", "", "<init>", "()V", "Lcoil/c;", "instance$delegate", "LY8/h;", "c", "()Lcoil/c;", "instance", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    public static final h INSTANCE = new h();

    /* renamed from: instance$delegate, reason: from kotlin metadata */
    private static final Y8.h instance = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.common.f
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return h.d();
        }
    });

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/task/common/h$a", "Landroid/content/ComponentCallbacks2;", "", "level", "LY8/t;", "onTrimMemory", "(I)V", "onLowMemory", "()V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements ComponentCallbacks2 {
        final /* synthetic */ coil.c $loader;

        public a(coil.c cVar) {
            this.$loader = cVar;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            p.i(newConfig, "newConfig");
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            MemoryCache memoryCacheB = this.$loader.b();
            if (memoryCacheB != null) {
                memoryCacheB.clear();
            }
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int level) {
            MemoryCache memoryCacheB;
            if (level < 20 || (memoryCacheB = this.$loader.b()) == null) {
                return;
            }
            memoryCacheB.clear();
        }
    }

    public static final coil.c d() {
        final Application applicationA = C3197a.INSTANCE.a();
        c.a aVarD = new c.a(applicationA).d(false);
        a.C0194a c0194a = new a.C0194a();
        c0194a.a(new i.b(false, 1, null));
        coil.c cVarE = aVarD.i(c0194a.e()).j(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.common.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return h.e(applicationA);
            }
        }).e();
        applicationA.registerComponentCallbacks(new a(cVarE));
        return cVarE;
    }

    public static final MemoryCache e(Application application) {
        return new MemoryCache.a(application).b(0.12d).a();
    }

    public final coil.c c() {
        return (coil.c) instance.getValue();
    }
}
