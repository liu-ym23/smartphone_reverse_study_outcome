package b0;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class i2 extends i7.i implements p7.o {

    /* renamed from: f, reason: collision with root package name */
    public List f1189f;

    /* renamed from: g, reason: collision with root package name */
    public List f1190g;

    /* renamed from: h, reason: collision with root package name */
    public List f1191h;

    /* renamed from: i, reason: collision with root package name */
    public k.b0 f1192i;

    /* renamed from: j, reason: collision with root package name */
    public k.b0 f1193j;

    /* renamed from: k, reason: collision with root package name */
    public k.b0 f1194k;

    /* renamed from: l, reason: collision with root package name */
    public Set f1195l;

    /* renamed from: m, reason: collision with root package name */
    public k.b0 f1196m;

    /* renamed from: n, reason: collision with root package name */
    public int f1197n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ c1 f1198o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ j2 f1199p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i2(j2 j2Var, g7.d dVar) {
        super(3, dVar);
        this.f1199p = j2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(b0.j2 r22, java.util.List r23, java.util.List r24, java.util.List r25, k.b0 r26, k.b0 r27, k.b0 r28, k.b0 r29) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.i2.d(b0.j2, java.util.List, java.util.List, java.util.List, k.b0, k.b0, k.b0, k.b0):void");
    }

    public static final void i(List list, j2 j2Var) {
        list.clear();
        synchronized (j2Var.f1207b) {
            try {
                ArrayList arrayList = j2Var.f1215j;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    list.add((e1) arrayList.get(i2));
                }
                j2Var.f1215j.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0099 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0130 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0123 -> B:44:0x012b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x01c7 -> B:12:0x0094). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.i2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        i2 i2Var = new i2(this.f1199p, (g7.d) obj3);
        i2Var.f1198o = (c1) obj2;
        i2Var.invokeSuspend(c7.r.f1986a);
        return h7.a.f4212f;
    }
}
