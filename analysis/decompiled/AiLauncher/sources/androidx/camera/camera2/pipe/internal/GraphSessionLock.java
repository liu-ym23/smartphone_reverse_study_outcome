package androidx.camera.camera2.pipe.internal;

import Ua.C1056g;
import Ua.C1086v0;
import Ua.InterfaceC1089x;
import Ua.M;
import Ua.Q;
import Y8.t;
import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g;
import p9.InterfaceC5074l;
import p9.p;
import z.z;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006JM\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u00072\u0006\u0010\t\u001a\u00020\b2(\u0010\r\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u00072\u0006\u0010\t\u001a\u00020\b2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ>\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0007*\u00020\u00042\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "", "<init>", "()V", "Lz/z;", Const.INTENT_KEY_UMID, "(Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "scope", "Lkotlin/Function2;", "Le9/c;", "LUa/Q;", "action", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LUa/M;Lp9/p;)LUa/Q;", "block", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lz/z;Lp9/p;Le9/c;)Ljava/lang/Object;", "Leb/a;", Const.INTENT_KEY_APIKEY, "Leb/a;", "mutex", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphSessionLock {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4021a mutex = eb.f.b(false, 1, null);

    public static final t f(InterfaceC1089x interfaceC1089x, Throwable th) {
        interfaceC1089x.complete();
        return t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(e9.InterfaceC4014c<? super z.z> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.camera.camera2.pipe.internal.GraphSessionLock$acquireToken$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.camera.camera2.pipe.internal.GraphSessionLock$acquireToken$1 r0 = (androidx.camera.camera2.pipe.internal.GraphSessionLock$acquireToken$1) r0
            int r1 = r0.f10991d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10991d = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.internal.GraphSessionLock$acquireToken$1 r0 = new androidx.camera.camera2.pipe.internal.GraphSessionLock$acquireToken$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f10989b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10991d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f10988a
            eb.a r4 = (eb.InterfaceC4021a) r4
            kotlin.C4849c.b(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            eb.a r4 = r4.mutex
            r0.f10988a = r4
            r0.f10991d = r3
            r5 = 0
            java.lang.Object r5 = eb.InterfaceC4021a.C0398a.a(r4, r5, r0, r3, r5)
            if (r5 != r1) goto L46
            return r1
        L46:
            z.l r5 = new z.l
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.internal.GraphSessionLock.d(e9.c):java.lang.Object");
    }

    public final <T> Q<T> e(M scope, p<? super M, ? super InterfaceC4014c<? super T>, ? extends Object> block) {
        final InterfaceC1089x interfaceC1089xA = C1086v0.a((g) scope.getCoroutineContext().get(g.INSTANCE));
        Q<T> qA = C1056g.a(scope, scope.getCoroutineContext().plus(interfaceC1089xA), CoroutineStart.UNDISPATCHED, new GraphSessionLock$asyncUndispatched$result$1(block, null));
        qA.J(new InterfaceC5074l() { // from class: B.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return GraphSessionLock.f(interfaceC1089xA, (Throwable) obj);
            }
        });
        return qA;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object g(z.z r5, p9.p<? super z.z, ? super e9.InterfaceC4014c<? super T>, ? extends java.lang.Object> r6, e9.InterfaceC4014c<? super T> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.camera.camera2.pipe.internal.GraphSessionLock$use$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.camera.camera2.pipe.internal.GraphSessionLock$use$1 r0 = (androidx.camera.camera2.pipe.internal.GraphSessionLock$use$1) r0
            int r1 = r0.f10998d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10998d = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.internal.GraphSessionLock$use$1 r0 = new androidx.camera.camera2.pipe.internal.GraphSessionLock$use$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r4 = r0.f10996b
            java.lang.Object r7 = f9.C4063a.g()
            int r1 = r0.f10998d
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r5 = r0.f10995a
            z.z r5 = (z.z) r5
            kotlin.C4849c.b(r4)     // Catch: java.lang.Throwable -> L2d
            goto L45
        L2d:
            r4 = move-exception
            goto L49
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.C4849c.b(r4)
            r0.f10995a = r5     // Catch: java.lang.Throwable -> L2d
            r0.f10998d = r2     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r4 = r6.invoke(r5, r0)     // Catch: java.lang.Throwable -> L2d
            if (r4 != r7) goto L45
            return r7
        L45:
            r5.release()
            return r4
        L49:
            r5.release()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.internal.GraphSessionLock.g(z.z, p9.p, e9.c):java.lang.Object");
    }

    public final <T> Q<T> h(M scope, p<? super z, ? super InterfaceC4014c<? super Q<? extends T>>, ? extends Object> action) {
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(action, "action");
        return e(scope, new GraphSessionLock$withTokenInAsync$1(this, action, null));
    }
}
