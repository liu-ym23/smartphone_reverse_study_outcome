package androidx.room;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/room/ObservedTableVersions;", "", "", ContentDisposition.Parameters.Size, "<init>", "(I)V", "", "tableIds", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Set;)V", "LXa/c;", "", "collector", "", Const.INTENT_KEY_APIKEY, "(LXa/c;Le9/c;)Ljava/lang/Object;", "LXa/k;", "LXa/k;", "versions", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ObservedTableVersions {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<int[]> versions;

    public ObservedTableVersions(int i10) {
        this.versions = Xa.u.a(new int[i10]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(Xa.c<? super int[]> r5, e9.InterfaceC4014c<?> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.room.ObservedTableVersions$collect$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.ObservedTableVersions$collect$1 r0 = (androidx.room.ObservedTableVersions$collect$1) r0
            int r1 = r0.f14502c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14502c = r1
            goto L18
        L13:
            androidx.room.ObservedTableVersions$collect$1 r0 = new androidx.room.ObservedTableVersions$collect$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f14500a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f14502c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            kotlin.C4849c.b(r6)
            goto L3f
        L31:
            kotlin.C4849c.b(r6)
            Xa.k<int[]> r4 = r4.versions
            r0.f14502c = r3
            java.lang.Object r4 = r4.collect(r5, r0)
            if (r4 != r1) goto L3f
            return r1
        L3f:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableVersions.a(Xa.c, e9.c):java.lang.Object");
    }

    public final void b(Set<Integer> tableIds) {
        int[] value;
        int[] iArr;
        kotlin.jvm.internal.p.i(tableIds, "tableIds");
        if (tableIds.isEmpty()) {
            return;
        }
        Xa.k<int[]> kVar = this.versions;
        do {
            value = kVar.getValue();
            int[] iArr2 = value;
            int length = iArr2.length;
            iArr = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = tableIds.contains(Integer.valueOf(i10)) ? iArr2[i10] + 1 : iArr2[i10];
            }
        } while (!kVar.d(value, iArr));
    }
}
