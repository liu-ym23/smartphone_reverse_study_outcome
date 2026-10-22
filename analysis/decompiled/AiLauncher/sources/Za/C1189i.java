package Za;

import Ua.AbstractC1053e0;
import Ua.O0;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.coroutines.DispatchException;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a-\u0010\u0010\u001a\u00020\u0006\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0013\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\"\u0014\u0010\u0019\u001a\u00020\u00158\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017¨\u0006\u001a"}, d2 = {"LUa/I;", "Lkotlin/coroutines/d;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "runnable", "LY8/t;", "c", "(LUa/I;Lkotlin/coroutines/d;Ljava/lang/Runnable;)V", "", Const.INTENT_KEY_UMID, "(LUa/I;Lkotlin/coroutines/d;)Z", ExifInterface.GPS_DIRECTION_TRUE, "Le9/c;", "Lkotlin/Result;", "result", Const.INTENT_KEY_PKGNAME, "(Le9/c;Ljava/lang/Object;)V", "LZa/h;", "e", "(LZa/h;)Z", "LZa/C;", Const.INTENT_KEY_APIKEY, "LZa/C;", "UNDEFINED", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1189i {

    /* renamed from: a, reason: collision with root package name */
    public static final C f7735a = new C("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    public static final C f7736b = new C("REUSABLE_CLAIMED");

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[Catch: all -> 0x0067, DONT_GENERATE, TryCatch #0 {all -> 0x0067, blocks: (B:11:0x003e, B:13:0x004c, B:15:0x0052, B:28:0x0091, B:18:0x0069, B:20:0x0079, B:25:0x0088, B:27:0x008e, B:33:0x009e, B:36:0x00a7, B:35:0x00a4, B:23:0x007f), top: B:45:0x003e, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> void b(e9.InterfaceC4014c<? super T> r6, java.lang.Object r7) {
        /*
            boolean r0 = r6 instanceof Za.C1188h
            if (r0 == 0) goto Lb2
            Za.h r6 = (Za.C1188h) r6
            java.lang.Object r0 = Ua.A.b(r7)
            Ua.I r1 = r6.dispatcher
            kotlin.coroutines.d r2 = r6.getContext()
            boolean r1 = d(r1, r2)
            r2 = 1
            if (r1 == 0) goto L26
            r6._state = r0
            r6.resumeMode = r2
            Ua.I r7 = r6.dispatcher
            kotlin.coroutines.d r0 = r6.getContext()
            c(r7, r0, r6)
            goto Lac
        L26:
            Ua.O0 r1 = Ua.O0.f6339a
            Ua.e0 r1 = r1.b()
            boolean r3 = r1.B1()
            if (r3 == 0) goto L3b
            r6._state = r0
            r6.resumeMode = r2
            r1.x1(r6)
            goto Lac
        L3b:
            r1.z1(r2)
            kotlin.coroutines.d r3 = r6.getContext()     // Catch: java.lang.Throwable -> L67
            kotlinx.coroutines.g$b r4 = kotlinx.coroutines.g.INSTANCE     // Catch: java.lang.Throwable -> L67
            kotlin.coroutines.d$b r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L67
            kotlinx.coroutines.g r3 = (kotlinx.coroutines.g) r3     // Catch: java.lang.Throwable -> L67
            if (r3 == 0) goto L69
            boolean r4 = r3.b()     // Catch: java.lang.Throwable -> L67
            if (r4 != 0) goto L69
            java.util.concurrent.CancellationException r7 = r3.G()     // Catch: java.lang.Throwable -> L67
            r6.a(r0, r7)     // Catch: java.lang.Throwable -> L67
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L67
            java.lang.Object r7 = kotlin.C4849c.a(r7)     // Catch: java.lang.Throwable -> L67
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L67
            r6.resumeWith(r7)     // Catch: java.lang.Throwable -> L67
            goto L91
        L67:
            r7 = move-exception
            goto La8
        L69:
            e9.c<T> r0 = r6.continuation     // Catch: java.lang.Throwable -> L67
            java.lang.Object r3 = r6.countOrElement     // Catch: java.lang.Throwable -> L67
            kotlin.coroutines.d r4 = r0.getContext()     // Catch: java.lang.Throwable -> L67
            java.lang.Object r3 = Za.J.i(r4, r3)     // Catch: java.lang.Throwable -> L67
            Za.C r5 = Za.J.f7710a     // Catch: java.lang.Throwable -> L67
            if (r3 == r5) goto L7e
            Ua.S0 r0 = Ua.G.m(r0, r4, r3)     // Catch: java.lang.Throwable -> L67
            goto L7f
        L7e:
            r0 = 0
        L7f:
            e9.c<T> r5 = r6.continuation     // Catch: java.lang.Throwable -> L9b
            r5.resumeWith(r7)     // Catch: java.lang.Throwable -> L9b
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto L8e
            boolean r7 = r0.c1()     // Catch: java.lang.Throwable -> L67
            if (r7 == 0) goto L91
        L8e:
            Za.J.f(r4, r3)     // Catch: java.lang.Throwable -> L67
        L91:
            boolean r7 = r1.E1()     // Catch: java.lang.Throwable -> L67
            if (r7 != 0) goto L91
        L97:
            r1.u1(r2)
            goto Lac
        L9b:
            r7 = move-exception
            if (r0 == 0) goto La4
            boolean r0 = r0.c1()     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto La7
        La4:
            Za.J.f(r4, r3)     // Catch: java.lang.Throwable -> L67
        La7:
            throw r7     // Catch: java.lang.Throwable -> L67
        La8:
            r6.f(r7)     // Catch: java.lang.Throwable -> Lad
            goto L97
        Lac:
            return
        Lad:
            r6 = move-exception
            r1.u1(r2)
            throw r6
        Lb2:
            r6.resumeWith(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Za.C1189i.b(e9.c, java.lang.Object):void");
    }

    public static final void c(Ua.I i10, kotlin.coroutines.d dVar, Runnable runnable) {
        try {
            i10.h1(dVar, runnable);
        } catch (Throwable th) {
            throw new DispatchException(th, i10, dVar);
        }
    }

    public static final boolean d(Ua.I i10, kotlin.coroutines.d dVar) throws DispatchException {
        try {
            return i10.l1(dVar);
        } catch (Throwable th) {
            throw new DispatchException(th, i10, dVar);
        }
    }

    public static final boolean e(C1188h<? super Y8.t> c1188h) {
        Y8.t tVar = Y8.t.f7040a;
        AbstractC1053e0 abstractC1053e0B = O0.f6339a.b();
        if (abstractC1053e0B.C1()) {
            return false;
        }
        if (abstractC1053e0B.B1()) {
            c1188h._state = tVar;
            c1188h.resumeMode = 1;
            abstractC1053e0B.x1(c1188h);
            return true;
        }
        abstractC1053e0B.z1(true);
        try {
            c1188h.run();
            do {
            } while (abstractC1053e0B.E1());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
