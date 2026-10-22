package c4;

import a1.w;
import a6.f0;
import b5.a0;
import h5.i;
import io.ktor.utils.io.r0;
import j0.c0;
import j0.n0;
import java.util.List;
import kotlin.jvm.internal.y;
import n4.e;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1072a;

    /* renamed from: b, reason: collision with root package name */
    public int f1073b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1074c;
    public final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, int i8, f5.c cVar) {
        super(2, cVar);
        this.f1072a = i8;
        this.d = obj;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [h5.i, p5.p] */
    /* JADX WARN: Type inference failed for: r2v14, types: [h5.i, p5.p] */
    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        switch (this.f1072a) {
            case 0:
                c cVar2 = new c((y) this.d, 0, cVar);
                cVar2.f1074c = obj;
                return cVar2;
            case 1:
                c cVar3 = new c((d6.c) this.d, 1, cVar);
                cVar3.f1074c = obj;
                return cVar3;
            case 2:
                c cVar4 = new c((List) this.d, 2, cVar);
                cVar4.f1074c = obj;
                return cVar4;
            case 3:
                return new c((p) this.f1074c, (j0.c) this.d, cVar);
            case 4:
                c cVar5 = new c((c0) this.d, 4, cVar);
                cVar5.f1074c = obj;
                return cVar5;
            case 5:
                return new c((w) this.d, 5, cVar);
            case 6:
                c cVar6 = new c((i) this.d, cVar);
                cVar6.f1074c = obj;
                return cVar6;
            case 7:
                c cVar7 = new c((p) this.d, 7, cVar);
                cVar7.f1074c = obj;
                return cVar7;
            case 8:
                return new c((w3.b) this.f1074c, (f4.d) this.d, cVar);
            default:
                c cVar8 = new c((e) this.d, 9, cVar);
                cVar8.f1074c = obj;
                return cVar8;
        }
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1072a) {
            case 0:
                return ((c) create((r0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 1:
                return ((c) create(obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 2:
                return ((c) create((j0.i) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 3:
                return ((c) create((f0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 4:
                return ((c) create((n0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 5:
                return ((c) create((f0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 6:
                return ((c) create((m0.e) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 7:
                return ((c) create((m0.e) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 8:
                return ((c) create((f0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            default:
                return ((c) create((r0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0170  */
    /* JADX WARN: Type inference failed for: r1v24, types: [h5.i, p5.p] */
    /* JADX WARN: Type inference failed for: r7v18, types: [h5.i, p5.p] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x015f -> B:70:0x0162). Please report as a decompilation issue!!! */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(p pVar, f5.c cVar) {
        super(2, cVar);
        this.f1072a = 6;
        this.d = (i) pVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(p pVar, j0.c cVar, f5.c cVar2) {
        super(2, cVar2);
        this.f1072a = 3;
        this.f1074c = (i) pVar;
        this.d = cVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(w3.b bVar, f4.d dVar, f5.c cVar) {
        super(2, cVar);
        this.f1072a = 8;
        this.f1074c = bVar;
        this.d = dVar;
    }
}
