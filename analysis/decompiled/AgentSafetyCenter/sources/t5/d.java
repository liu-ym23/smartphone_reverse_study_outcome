package t5;

import a2.i;
import a4.n;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.io.File;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;
import kc.e0;
import od.o;
import od.z;
import w5.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13179c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ n f13180f;

    public /* synthetic */ d(int i) {
        this.f13179c = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xb.a
    public final Object invoke() {
        int i;
        i iVar;
        int largeMemoryClass;
        h hVarA;
        int i3 = this.f13179c;
        n nVar = this.f13180f;
        switch (i3) {
            case 0:
                Context context = nVar.f190a;
                Bitmap.Config config = i6.d.f5804a;
                double d7 = 0.2d;
                try {
                    Object systemService = context.getSystemService((Class<Object>) ActivityManager.class);
                    systemService.getClass();
                    if (((ActivityManager) systemService).isLowRamDevice()) {
                        d7 = 0.15d;
                    }
                } catch (Exception unused) {
                }
                wd.a aVar = new wd.a(1);
                aVar.f15390g = new LinkedHashMap();
                VarHandle.storeStoreFence();
                if (d7 > 0.0d) {
                    Bitmap.Config config2 = i6.d.f5804a;
                    try {
                        Object systemService2 = context.getSystemService((Class<Object>) ActivityManager.class);
                        systemService2.getClass();
                        ActivityManager activityManager = (ActivityManager) systemService2;
                        largeMemoryClass = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                    } catch (Exception unused2) {
                        largeMemoryClass = ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH;
                    }
                    double d10 = 1024;
                    i = (int) (d7 * largeMemoryClass * d10 * d10);
                } else {
                    i = 0;
                }
                if (i > 0) {
                    n6.a aVar2 = new n6.a();
                    aVar2.f8776c = aVar;
                    aVar2.f8777f = new c6.e(i, aVar2);
                    VarHandle.storeStoreFence();
                    iVar = aVar2;
                } else {
                    i iVar2 = new i(3);
                    iVar2.f49f = aVar;
                    VarHandle.storeStoreFence();
                    iVar = iVar2;
                }
                c6.c cVar = new c6.c();
                cVar.f2211a = iVar;
                cVar.f2212b = aVar;
                VarHandle.storeStoreFence();
                return cVar;
            default:
                i6.e eVar = i6.e.f5806a;
                Context context2 = nVar.f190a;
                synchronized (eVar) {
                    try {
                        hVarA = i6.e.f5807b;
                        if (hVarA == null) {
                            w5.a aVar3 = new w5.a();
                            aVar3.f15229b = o.f9478a;
                            aVar3.f15230c = 0.02d;
                            aVar3.f15231d = 10485760L;
                            aVar3.f15232e = 262144000L;
                            rc.e eVar2 = e0.f7430a;
                            aVar3.f15233f = rc.d.f10552f;
                            Bitmap.Config config3 = i6.d.f5804a;
                            File cacheDir = context2.getCacheDir();
                            if (cacheDir == null) {
                                throw new IllegalStateException("cacheDir == null");
                            }
                            cacheDir.mkdirs();
                            File fileO = ub.h.o(cacheDir);
                            String str = z.f9497f;
                            aVar3.f15228a = f8.b.o(fileO);
                            hVarA = aVar3.a();
                            i6.e.f5807b = hVarA;
                        }
                    } finally {
                    }
                }
                return hVarA;
        }
    }
}
