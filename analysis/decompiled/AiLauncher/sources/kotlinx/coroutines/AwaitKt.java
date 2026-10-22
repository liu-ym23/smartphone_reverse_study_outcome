package kotlinx.coroutines;

import Ua.C1050d;
import Ua.Q;
import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001a\u0010\b\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0086@¢\u0006\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "LUa/Q;", "", Const.INTENT_KEY_APIKEY, "(Ljava/util/Collection;Le9/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/g;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AwaitKt {
    public static final <T> Object a(Collection<? extends Q<? extends T>> collection, InterfaceC4014c<? super List<? extends T>> interfaceC4014c) {
        return collection.isEmpty() ? C1173v.m() : new C1050d((Q[]) collection.toArray(new Q[0])).c(interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.util.Collection<? extends kotlinx.coroutines.g> r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.AwaitKt$joinAll$3
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = (kotlinx.coroutines.AwaitKt$joinAll$3) r0
            int r1 = r0.f36225i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36225i = r1
            goto L18
        L13:
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = new kotlinx.coroutines.AwaitKt$joinAll$3
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f36224h
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36225i
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 != r4) goto L3e
            int r9 = r0.f36222f
            java.lang.Object r2 = r0.f36221e
            kotlinx.coroutines.g r2 = (kotlinx.coroutines.g) r2
            java.lang.Object r2 = r0.f36219c
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.f36218b
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.Object r6 = r0.f36217a
            java.util.Collection r6 = (java.util.Collection) r6
            kotlin.C4849c.b(r10)
            r10 = r9
            r9 = r6
            goto L52
        L3e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L46:
            kotlin.C4849c.b(r10)
            r10 = r9
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r2 = r10.iterator()
            r5 = r10
            r10 = r3
        L52:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L86
            java.lang.Object r6 = r2.next()
            r7 = r6
            kotlinx.coroutines.g r7 = (kotlinx.coroutines.g) r7
            java.lang.Object r8 = g9.h.a(r9)
            r0.f36217a = r8
            java.lang.Object r8 = g9.h.a(r5)
            r0.f36218b = r8
            r0.f36219c = r2
            java.lang.Object r6 = g9.h.a(r6)
            r0.f36220d = r6
            java.lang.Object r6 = g9.h.a(r7)
            r0.f36221e = r6
            r0.f36222f = r10
            r0.f36223g = r3
            r0.f36225i = r4
            java.lang.Object r6 = r7.T0(r0)
            if (r6 != r1) goto L52
            return r1
        L86:
            Y8.t r9 = Y8.t.f7040a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.b(java.util.Collection, e9.c):java.lang.Object");
    }
}
