package G0;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.v;
import com.airbnb.lottie.z;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class h implements e, H0.a, k {

    /* renamed from: a, reason: collision with root package name */
    public final String f508a;

    /* renamed from: b, reason: collision with root package name */
    public final M0.b f509b;

    /* renamed from: c, reason: collision with root package name */
    public final q.i f510c = new q.i();

    /* renamed from: d, reason: collision with root package name */
    public final q.i f511d = new q.i();

    /* renamed from: e, reason: collision with root package name */
    public final Matrix f512e = new Matrix();

    /* renamed from: f, reason: collision with root package name */
    public final Path f513f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f514g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f515h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f516i;

    /* renamed from: j, reason: collision with root package name */
    public final L0.f f517j;

    /* renamed from: k, reason: collision with root package name */
    public final H0.b f518k;

    /* renamed from: l, reason: collision with root package name */
    public final H0.b f519l;

    /* renamed from: m, reason: collision with root package name */
    public final H0.b f520m;

    /* renamed from: n, reason: collision with root package name */
    public final H0.b f521n;

    /* renamed from: o, reason: collision with root package name */
    public H0.j f522o;

    /* renamed from: p, reason: collision with root package name */
    public final v f523p;

    /* renamed from: q, reason: collision with root package name */
    public final int f524q;

    public h(v vVar, M0.b bVar, L0.d dVar) {
        Path path = new Path();
        this.f513f = path;
        this.f514g = new Paint(1);
        this.f515h = new RectF();
        this.f516i = new ArrayList();
        this.f509b = bVar;
        int i4 = dVar.f1153a;
        this.f508a = dVar.f1154b;
        this.f523p = vVar;
        this.f517j = (L0.f) dVar.f1157e;
        path.setFillType((Path.FillType) dVar.f1158f);
        this.f524q = (int) (vVar.f4575b.getDuration() / 32.0f);
        H0.b bVarC = ((K0.a) dVar.f1159g).c();
        this.f518k = bVarC;
        bVarC.a(this);
        bVar.c(bVarC);
        H0.b bVarC2 = ((K0.a) dVar.f1160h).c();
        this.f519l = bVarC2;
        bVarC2.a(this);
        bVar.c(bVarC2);
        H0.b bVarC3 = ((K0.a) dVar.f1161i).c();
        this.f520m = bVarC3;
        bVarC3.a(this);
        bVar.c(bVarC3);
        H0.b bVarC4 = ((K0.a) dVar.f1162j).c();
        this.f521n = bVarC4;
        bVarC4.a(this);
        bVar.c(bVarC4);
    }

    @Override // H0.a
    public final void a() {
        this.f523p.invalidateSelf();
    }

    @Override // G0.c
    public final void b(List list, List list2) {
        for (int i4 = 0; i4 < list2.size(); i4++) {
            c cVar = (c) list2.get(i4);
            if (cVar instanceof m) {
                this.f516i.add((m) cVar);
            }
        }
    }

    public final int c() {
        float f4 = this.f520m.f690d;
        int i4 = this.f524q;
        int iRound = Math.round(f4 * i4);
        int iRound2 = Math.round(this.f521n.f690d * i4);
        int iRound3 = Math.round(this.f518k.f690d * i4);
        int i5 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i5 = i5 * 31 * iRound2;
        }
        return iRound3 != 0 ? i5 * 31 * iRound3 : i5;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v3 ??, still in use, count: 1, list:
          (r3v3 ?? I:java.lang.Object) from 0x00b9: INVOKE (r9v0 ?? I:q.i), (r4v5 ?? I:long), (r3v3 ?? I:java.lang.Object) VIRTUAL call: q.i.f(long, java.lang.Object):void A[MD:(long, java.lang.Object):void (m)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @Override // G0.e
    public final void d(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v3 ??, still in use, count: 1, list:
          (r3v3 ?? I:java.lang.Object) from 0x00b9: INVOKE (r9v0 ?? I:q.i), (r4v5 ?? I:long), (r3v3 ?? I:java.lang.Object) VIRTUAL call: q.i.f(long, java.lang.Object):void A[MD:(long, java.lang.Object):void (m)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r21v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    @Override // J0.f
    public final void f(Object obj, Q0.b bVar) {
        if (obj == z.f4607t) {
            if (bVar == null) {
                this.f522o = null;
                return;
            }
            H0.j jVar = new H0.j(bVar);
            this.f522o = jVar;
            jVar.a(this);
            this.f509b.c(this.f522o);
        }
    }

    @Override // J0.f
    public final void g(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        AbstractC0557a.X(eVar, i4, arrayList, eVar2, this);
    }

    @Override // G0.c
    public final String getName() {
        return this.f508a;
    }

    @Override // G0.e
    public final void h(RectF rectF, Matrix matrix) {
        Path path = this.f513f;
        path.reset();
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f516i;
            if (i4 >= arrayList.size()) {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            } else {
                path.addPath(((m) arrayList.get(i4)).e(), matrix);
                i4++;
            }
        }
    }
}
