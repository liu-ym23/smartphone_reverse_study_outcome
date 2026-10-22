package androidx.lifecycle;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.ScrollCaptureSession;
import com.stepos.agentsafetycenter.MainActivity;
import g9.f1;
import g9.o1;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1395c;

    /* renamed from: f, reason: collision with root package name */
    public int f1396f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1397g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f1398h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1399j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(Object obj, Object obj2, Object obj3, Object obj4, nb.c cVar, int i) {
        super(2, cVar);
        this.f1395c = i;
        this.f1397g = obj;
        this.f1398h = obj2;
        this.i = obj3;
        this.f1399j = obj4;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f1395c) {
            case 0:
                return new i0((sc.a) this.f1398h, (xb.p) this.f1399j, cVar);
            case 1:
                i0 i0Var = new i0((androidx.room.n0) this.f1398h, (int[]) this.i, (String[]) this.f1399j, cVar, 1);
                i0Var.f1397g = obj;
                return i0Var;
            case 2:
                return new i0((MainActivity) this.f1397g, (k0.c1) this.f1398h, (k0.c1) this.i, (k0.c1) this.f1399j, cVar, 2);
            case 3:
                return new i0((m8.k0) this.f1398h, (String) this.i, (Resources) this.f1399j, cVar, 3);
            case 4:
                i0 i0Var2 = new i0((m8.k0) this.i, (s8.d1) this.f1399j, cVar, 4);
                i0Var2.f1398h = obj;
                return i0Var2;
            case 5:
                i0 i0Var3 = new i0((nc.g) this.f1398h, (nc.t0) this.i, (Float) this.f1399j, cVar, 5);
                i0Var3.f1397g = obj;
                return i0Var3;
            case 6:
                return new i0((nc.q0) this.f1397g, (nc.g) this.f1398h, (nc.t0) this.i, (Float) this.f1399j, cVar, 6);
            case 7:
                i0 i0Var4 = new i0((k0.c1) this.i, (s.e0) this.f1399j, cVar, 7);
                i0Var4.f1398h = obj;
                return i0Var4;
            case 8:
                return new i0((g9.p0) this.f1397g, (o1) this.f1398h, (g9.z0) this.i, (f1) this.f1399j, cVar, 8);
            case 9:
                i0 i0Var5 = new i0((u.i) this.f1398h, (u.o1) this.i, (u.d) this.f1399j, cVar, 9);
                i0Var5.f1397g = obj;
                return i0Var5;
            default:
                return new i0((z1.d) this.f1397g, (ScrollCaptureSession) this.f1398h, (Rect) this.i, (Consumer) this.f1399j, cVar, 10);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f1395c) {
            case 1:
                ((i0) create((nc.h) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
                break;
            case 7:
                ((i0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
                break;
        }
        return ((i0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:165:0x03a9, code lost:
    
        if (r3 == r2) goto L166;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:72:0x01b9, B:79:0x01ed], limit reached: 456 */
    /* JADX WARN: Path cross not found for [B:79:0x01ed, B:72:0x01b9], limit reached: 456 */
    /* JADX WARN: Removed duplicated region for block: B:164:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0524 A[PHI: r0
      0x0524: PHI (r0v52 java.util.List) = (r0v40 java.util.List), (r0v45 java.util.List) binds: [B:229:0x0522, B:238:0x053c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0874 A[Catch: all -> 0x07fe, PHI: r3
      0x0874: PHI (r3v9 nc.h) = (r3v7 nc.h), (r3v8 nc.h), (r3v14 nc.h) binds: [B:356:0x084e, B:361:0x0870, B:343:0x0801] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x07fe, blocks: (B:339:0x07f5, B:340:0x07fd, B:363:0x0874), top: B:424:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:446:0x05c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0210  */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v6, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20, types: [int] */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x01eb -> B:72:0x01b9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x020c -> B:72:0x01b9). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r42) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.i0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(Object obj, Object obj2, Object obj3, nb.c cVar, int i) {
        super(2, cVar);
        this.f1395c = i;
        this.f1398h = obj;
        this.i = obj2;
        this.f1399j = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(Object obj, Object obj2, nb.c cVar, int i) {
        super(2, cVar);
        this.f1395c = i;
        this.i = obj;
        this.f1399j = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(sc.a aVar, xb.p pVar, nb.c cVar) {
        super(2, cVar);
        this.f1395c = 0;
        this.f1398h = aVar;
        this.f1399j = pVar;
    }
}
