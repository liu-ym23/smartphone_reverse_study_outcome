package k0;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p2 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7014c = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f7015f;

    /* renamed from: g, reason: collision with root package name */
    public Object f7016g;

    /* renamed from: h, reason: collision with root package name */
    public Object f7017h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public Object f7018j;

    /* renamed from: k, reason: collision with root package name */
    public Object f7019k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f7020l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f7021m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(z5.f fVar, e6.i iVar, Object obj, e6.m mVar, t5.c cVar, c6.a aVar, z5.h hVar, nb.c cVar2) {
        super(2, cVar2);
        this.f7017h = fVar;
        this.i = iVar;
        this.f7016g = obj;
        this.f7018j = mVar;
        this.f7019k = cVar;
        this.f7020l = aVar;
        this.f7021m = hVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f7014c) {
            case 0:
                p2 p2Var = new p2((xb.a) this.f7021m, cVar);
                p2Var.f7020l = obj;
                return p2Var;
            case 1:
                p2 p2Var2 = new p2((ContentResolver) this.i, (Uri) this.f7018j, (i9.o) this.f7019k, (mc.e) this.f7020l, (Context) this.f7021m, cVar);
                p2Var2.f7016g = obj;
                return p2Var2;
            case 2:
                return new p2((z5.f) this.f7017h, (yb.u) this.i, (yb.u) this.f7018j, (e6.i) this.f7019k, this.f7016g, (yb.u) this.f7020l, (t5.c) this.f7021m, cVar);
            default:
                return new p2((z5.f) this.f7017h, (e6.i) this.i, this.f7016g, (e6.m) this.f7018j, (t5.c) this.f7019k, (c6.a) this.f7020l, (z5.h) this.f7021m, cVar);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f7014c) {
            case 0:
                ((p2) create((nc.h) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
                break;
        }
        return ((p2) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x01dd, code lost:
    
        if (r6.emit(r9, r5) == r0) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02f0 A[Catch: all -> 0x0219, TryCatch #3 {all -> 0x0219, blocks: (B:99:0x020f, B:123:0x02d5, B:126:0x02eb, B:128:0x02f0, B:130:0x02fd, B:132:0x030e, B:134:0x031c, B:136:0x0326, B:150:0x0358, B:154:0x0362, B:157:0x0369, B:161:0x0385, B:163:0x038e, B:175:0x03b9, B:176:0x03bc, B:140:0x0337, B:146:0x0349, B:105:0x0239, B:108:0x0256, B:115:0x02a4, B:119:0x02bb, B:184:0x03d3, B:185:0x03d6, B:158:0x037a, B:160:0x0382, B:173:0x03b5, B:174:0x03b8, B:159:0x037e, B:116:0x02b0, B:118:0x02b8, B:182:0x03cf, B:183:0x03d2), top: B:197:0x01f1, inners: #0, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0360 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03c0 A[LOOP:0: B:127:0x02ee->B:178:0x03c0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0367 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ad A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01bb A[Catch: all -> 0x0174, TRY_LEAVE, TryCatch #2 {all -> 0x0174, blocks: (B:70:0x016b, B:80:0x01a1, B:84:0x01b3, B:86:0x01bb, B:76:0x0185, B:79:0x0199), top: B:195:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:167:0x03a5 -> B:168:0x03a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x01dd -> B:71:0x016e). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.p2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(xb.a aVar, nb.c cVar) {
        super(2, cVar);
        this.f7021m = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(ContentResolver contentResolver, Uri uri, i9.o oVar, mc.e eVar, Context context, nb.c cVar) {
        super(2, cVar);
        this.i = contentResolver;
        this.f7018j = uri;
        this.f7019k = oVar;
        this.f7020l = eVar;
        this.f7021m = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(z5.f fVar, yb.u uVar, yb.u uVar2, e6.i iVar, Object obj, yb.u uVar3, t5.c cVar, nb.c cVar2) {
        super(2, cVar2);
        this.f7017h = fVar;
        this.i = uVar;
        this.f7018j = uVar2;
        this.f7019k = iVar;
        this.f7016g = obj;
        this.f7020l = uVar3;
        this.f7021m = cVar;
    }
}
