package z1;

import android.text.Layout;
import android.text.TextPaint;
import b0.b3;
import b0.q;
import java.text.BreakIterator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import o4.d0;
import s1.h0;
import s1.o;
import s1.s;

/* loaded from: classes.dex */
public final class d implements o {

    /* renamed from: f, reason: collision with root package name */
    public final String f11758f;

    /* renamed from: g, reason: collision with root package name */
    public final h0 f11759g;

    /* renamed from: h, reason: collision with root package name */
    public final List f11760h;

    /* renamed from: i, reason: collision with root package name */
    public final List f11761i;

    /* renamed from: j, reason: collision with root package name */
    public final v1.d f11762j;

    /* renamed from: k, reason: collision with root package name */
    public final d2.c f11763k;

    /* renamed from: l, reason: collision with root package name */
    public final e f11764l;

    /* renamed from: m, reason: collision with root package name */
    public final CharSequence f11765m;

    /* renamed from: n, reason: collision with root package name */
    public final t1.d f11766n;

    /* renamed from: o, reason: collision with root package name */
    public u5.h f11767o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f11768p;

    /* renamed from: q, reason: collision with root package name */
    public final int f11769q;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x07c8  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0900  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0929  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0985  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x09af A[LOOP:8: B:497:0x09ad->B:498:0x09af, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:501:0x09c0  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x09ea  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, z1.d] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v30, types: [java.lang.CharSequence, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(java.lang.String r39, s1.h0 r40, java.util.List r41, java.util.List r42, v1.d r43, d2.c r44) {
        /*
            Method dump skipped, instructions count: 2571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.d.<init>(java.lang.String, s1.h0, java.util.List, java.util.List, v1.d, d2.c):void");
    }

    public final float a() {
        float f10;
        t1.d dVar = this.f11766n;
        float f11 = dVar.f9680e;
        TextPaint textPaint = dVar.f9677b;
        if (!Float.isNaN(f11)) {
            return dVar.f9680e;
        }
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        CharSequence charSequence = dVar.f9676a;
        lineInstance.setText(new t1.a(charSequence, charSequence.length()));
        PriorityQueue priorityQueue = new PriorityQueue(10, new q(3));
        int i2 = 0;
        for (int next = lineInstance.next(); next != -1; next = lineInstance.next()) {
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new c7.j(Integer.valueOf(i2), Integer.valueOf(next)));
            } else {
                c7.j jVar = (c7.j) priorityQueue.peek();
                if (jVar != null && ((Number) jVar.f1974g).intValue() - ((Number) jVar.f1973f).intValue() < next - i2) {
                    priorityQueue.poll();
                    priorityQueue.add(new c7.j(Integer.valueOf(i2), Integer.valueOf(next)));
                }
            }
            i2 = next;
        }
        if (priorityQueue.isEmpty()) {
            f10 = 0.0f;
        } else {
            Iterator it = priorityQueue.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            c7.j jVar2 = (c7.j) it.next();
            float desiredWidth = Layout.getDesiredWidth(dVar.b(), ((Number) jVar2.f1973f).intValue(), ((Number) jVar2.f1974g).intValue(), textPaint);
            while (it.hasNext()) {
                c7.j jVar3 = (c7.j) it.next();
                desiredWidth = Math.max(desiredWidth, Layout.getDesiredWidth(dVar.b(), ((Number) jVar3.f1973f).intValue(), ((Number) jVar3.f1974g).intValue(), textPaint));
            }
            f10 = desiredWidth;
        }
        dVar.f9680e = f10;
        return f10;
    }

    @Override // s1.o
    public final boolean c() {
        u5.h hVar = this.f11767o;
        if (hVar != null ? hVar.d() : false) {
            return true;
        }
        if (!this.f11768p) {
            s sVar = this.f11759g.f9274c;
            d0 d0Var = i.f11783a;
            d0 d0Var2 = i.f11783a;
            b3 b3VarK = (b3) d0Var2.f7326g;
            if (b3VarK == null) {
                if (x2.g.f11112k != null) {
                    b3VarK = d0Var2.K();
                    d0Var2.f7326g = b3VarK;
                } else {
                    b3VarK = j.f11784a;
                }
            }
            if (((Boolean) b3VarK.getValue()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // s1.o
    public final float d() {
        return this.f11766n.c();
    }
}
