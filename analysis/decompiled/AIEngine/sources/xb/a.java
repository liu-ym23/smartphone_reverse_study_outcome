package xb;

import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewParent;
import com.stepos.core.ota.d;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.exception.IPCException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import jd.b;
import kotlin.jvm.internal.g;
import y4.e;
import y4.g;
import y4.i;
import y4.m;
import z9.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a {
    public static final void a(AutoCloseable autoCloseable, Throwable th) {
        boolean zIsTerminated;
        if (autoCloseable != null) {
            if (th != null) {
                try {
                    d.q(autoCloseable);
                    return;
                } catch (Throwable th2) {
                    b.c(th, th2);
                    return;
                }
            }
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
                return;
            }
            if (!(autoCloseable instanceof ExecutorService)) {
                if (!(autoCloseable instanceof TypedArray)) {
                    throw new IllegalArgumentException();
                }
                ((TypedArray) autoCloseable).recycle();
                return;
            }
            ExecutorService executorService = (ExecutorService) autoCloseable;
            if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
                return;
            }
            executorService.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        executorService.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static a b(int i10) {
        return i10 != 0 ? i10 != 1 ? new i() : new e() : new i();
    }

    public static z9.a c(Call call) {
        g.f(call, "call");
        int type = call.getServiceWrapper().getType();
        if (type == 0) {
            return new z9.d(call);
        }
        if (type == 1) {
            return new z9.b(call);
        }
        if (type == 3 || type == 4) {
            return new c(call);
        }
        throw new IPCException(13, "Type " + call.getServiceWrapper().getType() + " is not supported.");
    }

    public static final Class e(kotlin.jvm.internal.c cVar) {
        Class<?> clsA = cVar.a();
        g.d(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsA;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class f(ec.c cVar) {
        g.f(cVar, "<this>");
        Class<?> clsA = ((kotlin.jvm.internal.b) cVar).a();
        if (clsA.isPrimitive()) {
            String name = clsA.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsA;
    }

    public static void g(View view, y4.g gVar) {
        s4.a aVar = gVar.f14023b.f14046c;
        if (aVar == null || !aVar.f11884a) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ((View) parent).getElevation();
        }
        g.c cVar = gVar.f14023b;
        if (cVar.f14055m != elevation) {
            cVar.f14055m = elevation;
            gVar.s();
        }
    }

    public void d(m mVar, float f8, float f9) {
        throw null;
    }
}
