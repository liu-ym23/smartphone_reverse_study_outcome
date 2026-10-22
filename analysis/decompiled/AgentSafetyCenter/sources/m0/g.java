package m0;

import gc.l;
import jb.v;
import p.r0;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends pb.h implements p {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8161f;

    /* renamed from: g, reason: collision with root package name */
    public long[] f8162g;

    /* renamed from: h, reason: collision with root package name */
    public int f8163h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f8164j;

    /* renamed from: k, reason: collision with root package name */
    public int f8165k;

    /* renamed from: l, reason: collision with root package name */
    public long f8166l;

    /* renamed from: m, reason: collision with root package name */
    public int f8167m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f8168n;

    /* renamed from: o, reason: collision with root package name */
    public Object f8169o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f8170p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Object obj, nb.c cVar, int i) {
        super(cVar);
        this.f8161f = i;
        this.f8170p = obj;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8161f) {
            case 0:
                g gVar = new g((h) this.f8170p, cVar, 0);
                gVar.f8168n = obj;
                return gVar;
            case 1:
                g gVar2 = new g((p.g) this.f8170p, cVar, 1);
                gVar2.f8168n = obj;
                return gVar2;
            case 2:
                g gVar3 = new g((p.g) this.f8170p, cVar, 2);
                gVar3.f8168n = obj;
                return gVar3;
            default:
                g gVar4 = new g((r0) this.f8170p, cVar, 3);
                gVar4.f8168n = obj;
                return gVar4;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        l lVar = (l) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f8161f) {
        }
        return ((g) create(lVar, cVar)).invokeSuspend(v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x028d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x006d -> B:22:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x006f -> B:15:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0084 -> B:19:0x00a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0104 -> B:43:0x0146). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0106 -> B:36:0x0117). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x011d -> B:40:0x013d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x019b -> B:64:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x019d -> B:57:0x01af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01b5 -> B:61:0x01e9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0249 -> B:85:0x028b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x024b -> B:78:0x025c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0262 -> B:82:0x0282). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
