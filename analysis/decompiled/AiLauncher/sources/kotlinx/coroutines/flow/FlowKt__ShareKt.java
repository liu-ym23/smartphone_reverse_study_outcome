package kotlinx.coroutines.flow;

import Ua.C1056g;
import Ua.M;
import Xa.b;
import Xa.j;
import Xa.k;
import Xa.l;
import Xa.m;
import Xa.o;
import Xa.r;
import Xa.t;
import Xa.u;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\r\u001aM\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", "LUa/M;", "scope", "Lkotlinx/coroutines/flow/a;", RobotInfo.STATUS_STARTED, "", "replay", "LXa/o;", "e", "(LXa/b;LUa/M;Lkotlinx/coroutines/flow/a;I)LXa/o;", "LXa/r;", "c", "(LXa/b;I)LXa/r;", "Lkotlin/coroutines/d;", "context", "upstream", "LXa/j;", "shared", "initialValue", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_UMID, "(LUa/M;Lkotlin/coroutines/d;LXa/b;LXa/j;Lkotlinx/coroutines/flow/a;Ljava/lang/Object;)Lkotlinx/coroutines/g;", "LXa/t;", "f", "(LXa/b;LUa/M;Lkotlinx/coroutines/flow/a;Ljava/lang/Object;)LXa/t;", Const.INTENT_KEY_APIKEY, "(LXa/j;)LXa/o;", "LXa/k;", Const.INTENT_KEY_PKGNAME, "(LXa/k;)LXa/t;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__ShareKt {
    public static final <T> o<T> a(j<T> jVar) {
        return new l(jVar, null);
    }

    public static final <T> t<T> b(k<T> kVar) {
        return new m(kVar, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> Xa.r<T> c(Xa.b<? extends T> r7, int r8) {
        /*
            Wa.g$a r0 = Wa.g.INSTANCE
            int r0 = r0.a()
            int r0 = v9.C5685n.f(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r1 == 0) goto L3c
            r1 = r7
            kotlinx.coroutines.flow.internal.ChannelFlow r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
            Xa.b r2 = r1.k()
            if (r2 == 0) goto L3c
            Xa.r r7 = new Xa.r
            int r3 = r1.capacity
            r4 = -3
            if (r3 == r4) goto L26
            r4 = -2
            if (r3 == r4) goto L26
            if (r3 == 0) goto L26
            r0 = r3
            goto L34
        L26:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.onBufferOverflow
            kotlinx.coroutines.channels.BufferOverflow r5 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            r6 = 0
            if (r4 != r5) goto L31
            if (r3 != 0) goto L34
        L2f:
            r0 = r6
            goto L34
        L31:
            if (r8 != 0) goto L2f
            r0 = 1
        L34:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.onBufferOverflow
            kotlin.coroutines.d r1 = r1.context
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3c:
            Xa.r r8 = new Xa.r
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.f34779a
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.c(Xa.b, int):Xa.r");
    }

    public static final <T> g d(M m10, d dVar, b<? extends T> bVar, j<T> jVar, a aVar, T t10) {
        return C1056g.c(m10, dVar, p.d(aVar, a.INSTANCE.c()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new FlowKt__ShareKt$launchSharing$1(aVar, bVar, jVar, t10, null));
    }

    public static final <T> o<T> e(b<? extends T> bVar, M m10, a aVar, int i10) {
        r rVarC = c(bVar, i10);
        j jVarA = Xa.p.a(i10, rVarC.extraBufferCapacity, rVarC.onBufferOverflow);
        return new l(jVarA, d(m10, rVarC.context, rVarC.upstream, jVarA, aVar, Xa.p.f6900a));
    }

    public static final <T> t<T> f(b<? extends T> bVar, M m10, a aVar, T t10) {
        r rVarC = c(bVar, 1);
        k kVarA = u.a(t10);
        return new m(kVarA, d(m10, rVarC.context, rVarC.upstream, kVarA, aVar, t10));
    }
}
