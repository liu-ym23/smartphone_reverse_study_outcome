package k2;

import android.text.Layout;
import android.text.TextPaint;
import d2.l0;
import d2.s;
import java.lang.invoke.VarHandle;
import java.text.BreakIterator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import k0.r2;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements s {

    /* renamed from: a, reason: collision with root package name */
    public final String f7180a;

    /* renamed from: b, reason: collision with root package name */
    public final l0 f7181b;

    /* renamed from: c, reason: collision with root package name */
    public final List f7182c;

    /* renamed from: d, reason: collision with root package name */
    public final List f7183d;

    /* renamed from: e, reason: collision with root package name */
    public final g2.d f7184e;

    /* renamed from: f, reason: collision with root package name */
    public final o2.c f7185f;

    /* renamed from: g, reason: collision with root package name */
    public final f f7186g;

    /* renamed from: h, reason: collision with root package name */
    public final CharSequence f7187h;
    public final e2.e i;

    /* renamed from: j, reason: collision with root package name */
    public m f7188j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f7189k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7190l;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0704  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x074d  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x076e  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x078e  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x07ce  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x07f4  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0805  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x081a  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0843  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0894  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x08be A[LOOP:6: B:410:0x08bc->B:411:0x08be, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:414:0x08cf  */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v61, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(java.lang.String r43, d2.l0 r44, java.util.List r45, java.util.List r46, g2.d r47, o2.c r48) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.d.<init>(java.lang.String, d2.l0, java.util.List, java.util.List, g2.d, o2.c):void");
    }

    @Override // d2.s
    public final boolean a() {
        m mVar = this.f7188j;
        if (mVar != null ? mVar.H() : false) {
            return true;
        }
        if (!this.f7189k) {
            a2.i iVar = j.f7205a;
            a2.i iVar2 = j.f7205a;
            r2 r2VarY = (r2) iVar2.f49f;
            if (r2VarY == null) {
                if (a4.j.c()) {
                    r2VarY = iVar2.y();
                    iVar2.f49f = r2VarY;
                } else {
                    r2VarY = k.f7206a;
                }
            }
            if (((Boolean) r2VarY.getValue()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // d2.s
    public final float b() {
        return this.i.b();
    }

    public final float c() {
        e2.e eVar = this.i;
        float f5 = eVar.f3427e;
        TextPaint textPaint = eVar.f3424b;
        if (!Float.isNaN(f5)) {
            return eVar.f3427e;
        }
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        CharSequence charSequence = eVar.f3423a;
        int length = charSequence.length();
        e2.a aVar = new e2.a();
        aVar.f3415c = charSequence;
        aVar.f3416f = length;
        int i = 0;
        aVar.f3417g = 0;
        VarHandle.storeStoreFence();
        lineInstance.setText(aVar);
        PriorityQueue priorityQueue = new PriorityQueue(10, new e2.d(i));
        int next = lineInstance.next();
        while (true) {
            int i3 = next;
            int i10 = i;
            i = i3;
            if (i == -1) {
                break;
            }
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new jb.g(Integer.valueOf(i10), Integer.valueOf(i)));
            } else {
                jb.g gVar = (jb.g) priorityQueue.peek();
                if (gVar != null && ((Number) gVar.f6760f).intValue() - ((Number) gVar.f6759c).intValue() < i - i10) {
                    priorityQueue.poll();
                    priorityQueue.add(new jb.g(Integer.valueOf(i10), Integer.valueOf(i)));
                }
            }
            next = lineInstance.next();
        }
        float desiredWidth = 0.0f;
        if (!priorityQueue.isEmpty()) {
            Iterator it = priorityQueue.iterator();
            if (!it.hasNext()) {
                g5.f.k();
                return 0.0f;
            }
            jb.g gVar2 = (jb.g) it.next();
            desiredWidth = Layout.getDesiredWidth(eVar.a(), ((Number) gVar2.f6759c).intValue(), ((Number) gVar2.f6760f).intValue(), textPaint);
            while (it.hasNext()) {
                jb.g gVar3 = (jb.g) it.next();
                desiredWidth = Math.max(desiredWidth, Layout.getDesiredWidth(eVar.a(), ((Number) gVar3.f6759c).intValue(), ((Number) gVar3.f6760f).intValue(), textPaint));
            }
        }
        eVar.f3427e = desiredWidth;
        return desiredWidth;
    }
}
