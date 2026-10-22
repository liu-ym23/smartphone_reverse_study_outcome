package la;

import android.graphics.Rect;
import android.view.ScrollCaptureSession;
import b0.f1;
import com.stepos.agentbus.config.OpenClawCloudUpstream;
import java.util.ArrayList;
import java.util.function.Consumer;
import o4.t1;
import o4.t2;
import p.g1;

/* loaded from: classes.dex */
public final class a0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5898f;

    /* renamed from: g, reason: collision with root package name */
    public int f5899g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5900h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f5901i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f5902j;

    /* renamed from: k, reason: collision with root package name */
    public Object f5903k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(f1 f1Var, n.d0 d0Var, g7.d dVar) {
        super(2, dVar);
        this.f5898f = 2;
        this.f5900h = f1Var;
        this.f5901i = d0Var;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [la.c0, ma.b] */
    /* JADX WARN: Type inference failed for: r5v1, types: [la.c0, ma.b] */
    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f5898f) {
            case 0:
                a0 a0Var = new a0((j) this.f5900h, (ma.b) this.f5901i, this.f5903k, dVar);
                a0Var.f5902j = obj;
                return a0Var;
            case 1:
                return new a0((o0) this.f5903k, (j) this.f5900h, (c0) this.f5901i, this.f5902j, dVar);
            case 2:
                a0 a0Var2 = new a0((f1) this.f5900h, (n.d0) this.f5901i, dVar);
                a0Var2.f5902j = obj;
                return a0Var2;
            case 3:
                return new a0((o1.d) this.f5902j, (ScrollCaptureSession) this.f5903k, (Rect) this.f5900h, (Consumer) this.f5901i, dVar, 3);
            case 4:
                return new a0((o4.f1) this.f5902j, (String) this.f5903k, (t1) this.f5900h, (ia.s) this.f5901i, dVar, 4);
            case 5:
                return new a0((t1) this.f5902j, (String) this.f5903k, (o4.k0) this.f5900h, (o4.f1) this.f5901i, dVar, 5);
            case 6:
                a0 a0Var3 = new a0((ArrayList) this.f5903k, (ra.j) this.f5900h, (t2) this.f5901i, dVar, 6);
                a0Var3.f5902j = obj;
                return a0Var3;
            case 7:
                a0 a0Var4 = new a0((d5.e) this.f5903k, (c5.b) this.f5900h, (o5.e) this.f5901i, dVar, 7);
                a0Var4.f5902j = obj;
                return a0Var4;
            case 8:
                a0 a0Var5 = new a0((p.i) this.f5903k, (g1) this.f5900h, (p.d) this.f5901i, dVar, 8);
                a0Var5.f5902j = obj;
                return a0Var5;
            case 9:
                a0 a0Var6 = new a0((y4.m) this.f5903k, (o4.k0) this.f5900h, (d5.e) this.f5901i, dVar, 9);
                a0Var6.f5902j = obj;
                return a0Var6;
            default:
                a0 a0Var7 = new a0((OpenClawCloudUpstream) this.f5903k, (y4.m) this.f5900h, (t1) this.f5901i, dVar, 10);
                a0Var7.f5902j = obj;
                return a0Var7;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f5898f) {
            case 0:
                return ((a0) create((m0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 1:
                return ((a0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 2:
                ((a0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
                return h7.a.f4212f;
            case 3:
                return ((a0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 4:
                return ((a0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 5:
                return ((a0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 6:
                return ((a0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 7:
                return ((a0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 8:
                return ((a0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 9:
                return ((a0) create((String) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            default:
                return ((a0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:199|(2:201|(2:203|(2:205|513)(2:206|207))(1:208))(4:209|(1:211)|377|514)|212|(1:214)(1:215)|216|486|217|221|(1:223)|224|(2:229|(2:231|(2:233|(3:239|(1:242)|(5:245|(1:247)(1:249)|248|250|(2:253|(3:(2:268|(1:275))(6:496|259|263|(1:265)|266|(0)(3:269|(1:271)(0)|(2:273|275)))|377|514)(2:276|(3:326|(1:328)|329)(6:474|281|285|(1:287)|288|(5:291|(1:294)|(8:302|304|(4:306|(1:308)(1:309)|(1:311)(1:312)|313)(1:314)|315|(3:317|(1:319)(1:320)|321)|322|(1:324)|325)(2:296|(10:298|(1:300)(1:301)|302|304|(0)(0)|315|(0)|322|(0)|325)(8:303|304|(0)(0)|315|(0)|322|(0)|325))|377|514)))))))(2:330|(3:333|(1:336)|(7:339|(1:341)(1:343)|342|344|(3:346|(1:353)|354)(1:355)|356|(1:358)(1:359)))))(2:360|(3:363|(1:366)|(3:369|(1:371)(1:372)|(1:375)))))|226|(2:378|379)|377|514) */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x04d1, code lost:
    
        if (o4.f1.d(r0, r6, r13, r3, r4, r40) == r6) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
    
        if (r6 == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x058e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x058f, code lost:
    
        r0 = w7.e0.n(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b0, code lost:
    
        if (r4 != r0) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:403:0x092d, B:410:0x0963], limit reached: 483 */
    /* JADX WARN: Path cross not found for [B:410:0x0963, B:403:0x092d], limit reached: 483 */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0457 A[Catch: all -> 0x0441, TryCatch #1 {all -> 0x0441, blocks: (B:180:0x0453, B:182:0x0457, B:184:0x0481, B:185:0x0486, B:187:0x048a, B:188:0x04a9, B:189:0x04bf, B:174:0x0430, B:176:0x0438, B:179:0x0446), top: B:476:0x0430 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x094d  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0963  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0988  */
    /* JADX WARN: Type inference failed for: r1v2, types: [la.c0, la.k, ma.b] */
    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object, p7.n] */
    /* JADX WARN: Type inference failed for: r3v8, types: [la.c0, la.k, ma.b] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:409:0x0961 -> B:403:0x092d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:411:0x0985 -> B:403:0x092d). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: la.a0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(Object obj, Object obj2, Object obj3, g7.d dVar, int i2) {
        super(2, dVar);
        this.f5898f = i2;
        this.f5903k = obj;
        this.f5900h = obj2;
        this.f5901i = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(Object obj, Object obj2, Object obj3, Object obj4, g7.d dVar, int i2) {
        super(2, dVar);
        this.f5898f = i2;
        this.f5902j = obj;
        this.f5903k = obj2;
        this.f5900h = obj3;
        this.f5901i = obj4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a0(j jVar, c0 c0Var, Object obj, g7.d dVar) {
        super(2, dVar);
        this.f5898f = 0;
        this.f5900h = jVar;
        this.f5901i = (ma.b) c0Var;
        this.f5903k = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a0(o0 o0Var, j jVar, c0 c0Var, Object obj, g7.d dVar) {
        super(2, dVar);
        this.f5898f = 1;
        this.f5903k = o0Var;
        this.f5900h = jVar;
        this.f5901i = (ma.b) c0Var;
        this.f5902j = obj;
    }
}
