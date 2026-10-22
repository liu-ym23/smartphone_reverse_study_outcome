package c4;

import b5.a0;
import h5.i;
import io.ktor.utils.io.d0;
import io.ktor.utils.io.r0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.KSerializer;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1063a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1064b;

    /* renamed from: c, reason: collision with root package name */
    public int f1065c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1066e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1067f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1068g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, Object obj2, f5.c cVar, int i8) {
        super(2, cVar);
        this.f1063a = i8;
        this.f1067f = obj;
        this.f1068g = obj2;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        switch (this.f1063a) {
            case 0:
                a aVar = new a((d) this.f1067f, (b) this.f1068g, cVar, 0);
                aVar.f1064b = obj;
                return aVar;
            case 1:
                a aVar2 = new a((List) this.f1067f, (ArrayList) this.f1068g, cVar, 1);
                aVar2.f1066e = obj;
                return aVar2;
            default:
                a aVar3 = new a((q4.i) this.d, this.f1066e, (KSerializer) this.f1067f, (Charset) this.f1068g, cVar);
                aVar3.f1064b = obj;
                return aVar3;
        }
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1063a) {
            case 0:
                return ((a) create((r0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 1:
                return ((a) create(obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            default:
                return ((a) create((d0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:86:0x0198
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:63:0x013c, B:66:0x014d], limit reached: 90 */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f A[PHI: r4 r6 r15
      0x010f: PHI (r4v4 io.ktor.utils.io.r0) = (r4v7 io.ktor.utils.io.r0), (r4v18 io.ktor.utils.io.r0) binds: [B:67:0x015f, B:53:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x010f: PHI (r6v2 java.lang.Object) = (r6v3 java.lang.Object), (r6v10 java.lang.Object) binds: [B:67:0x015f, B:53:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x010f: PHI (r15v5 java.lang.Object) = (r15v12 java.lang.Object), (r15v0 java.lang.Object) binds: [B:67:0x015f, B:53:0x010c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0134 A[Catch: all -> 0x00e8, TryCatch #1 {all -> 0x00e8, blocks: (B:43:0x00e3, B:78:0x0198, B:59:0x012c, B:61:0x0134, B:63:0x013c, B:66:0x014d, B:69:0x0162, B:70:0x0165, B:72:0x016f, B:75:0x0184, B:79:0x01aa, B:81:0x01b2, B:83:0x01c1, B:50:0x00fe, B:53:0x010c, B:56:0x011a), top: B:87:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016f A[Catch: all -> 0x00e8, Exception -> 0x0198, TryCatch #0 {Exception -> 0x0198, blocks: (B:43:0x00e3, B:70:0x0165, B:72:0x016f, B:75:0x0184, B:50:0x00fe), top: B:87:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01aa A[Catch: all -> 0x00e8, TryCatch #1 {all -> 0x00e8, blocks: (B:43:0x00e3, B:78:0x0198, B:59:0x012c, B:61:0x0134, B:63:0x013c, B:66:0x014d, B:69:0x0162, B:70:0x0165, B:72:0x016f, B:75:0x0184, B:79:0x01aa, B:81:0x01b2, B:83:0x01c1, B:50:0x00fe, B:53:0x010c, B:56:0x011a), top: B:87:0x00cd }] */
    /* JADX WARN: Type inference failed for: r15v27, types: [j6.a] */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v22, types: [j6.j] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6, types: [j6.j, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v9, types: [j6.d, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x016d -> B:78:0x0198). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0194 -> B:78:0x0198). Please report as a decompilation issue!!! */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(q4.i iVar, Object obj, KSerializer kSerializer, Charset charset, f5.c cVar) {
        super(2, cVar);
        this.f1063a = 2;
        this.d = iVar;
        this.f1066e = obj;
        this.f1067f = kSerializer;
        this.f1068g = charset;
    }
}
