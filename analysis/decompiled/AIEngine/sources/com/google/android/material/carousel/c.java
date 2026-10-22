package com.google.android.material.carousel;

import com.google.android.material.carousel.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n4.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f4834a;

    /* renamed from: b, reason: collision with root package name */
    public final List<b> f4835b;

    /* renamed from: c, reason: collision with root package name */
    public final List<b> f4836c;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f4837d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f4838e;

    /* renamed from: f, reason: collision with root package name */
    public final float f4839f;

    /* renamed from: g, reason: collision with root package name */
    public final float f4840g;

    public c(b bVar, ArrayList arrayList, ArrayList arrayList2) {
        this.f4834a = bVar;
        this.f4835b = Collections.unmodifiableList(arrayList);
        this.f4836c = Collections.unmodifiableList(arrayList2);
        float f8 = ((b) arrayList.get(arrayList.size() - 1)).b().f4827a - bVar.b().f4827a;
        this.f4839f = f8;
        float f9 = bVar.d().f4827a - ((b) arrayList2.get(arrayList2.size() - 1)).d().f4827a;
        this.f4840g = f9;
        this.f4837d = d(f8, arrayList, true);
        this.f4838e = d(f9, arrayList2, false);
    }

    public static float[] d(float f8, ArrayList arrayList, boolean z) {
        int size = arrayList.size();
        float[] fArr = new float[size];
        int i10 = 1;
        while (i10 < size) {
            int i11 = i10 - 1;
            b bVar = (b) arrayList.get(i11);
            b bVar2 = (b) arrayList.get(i10);
            fArr[i10] = i10 == size + (-1) ? 1.0f : fArr[i11] + ((z ? bVar2.b().f4827a - bVar.b().f4827a : bVar.d().f4827a - bVar2.d().f4827a) / f8);
            i10++;
        }
        return fArr;
    }

    public static b e(b bVar, int i10, int i11, float f8, int i12, int i13, int i14) {
        ArrayList arrayList = new ArrayList(bVar.f4815c);
        arrayList.add(i11, (b.C0035b) arrayList.remove(i10));
        b.a aVar = new b.a(bVar.f4813a, i14);
        float f9 = f8;
        int i15 = 0;
        while (i15 < arrayList.size()) {
            b.C0035b c0035b = (b.C0035b) arrayList.get(i15);
            float f10 = c0035b.f4830d;
            aVar.b((f10 / 2.0f) + f9, c0035b.f4829c, f10, i15 >= i12 && i15 <= i13, c0035b.f4831e, c0035b.f4832f, 0.0f, 0.0f);
            f9 += c0035b.f4830d;
            i15++;
        }
        return aVar.d();
    }

    public static b f(b bVar, float f8, int i10, boolean z, float f9) {
        int i11;
        List<b.C0035b> list = bVar.f4815c;
        ArrayList arrayList = new ArrayList(list);
        float f10 = bVar.f4813a;
        b.a aVar = new b.a(f10, i10);
        Iterator<b.C0035b> it = list.iterator();
        int i12 = 0;
        while (it.hasNext()) {
            if (it.next().f4831e) {
                i12++;
            }
        }
        float size = f8 / (list.size() - i12);
        float f11 = z ? f8 : 0.0f;
        int i13 = 0;
        while (i13 < arrayList.size()) {
            b.C0035b c0035b = (b.C0035b) arrayList.get(i13);
            if (c0035b.f4831e) {
                i11 = i13;
                aVar.b(c0035b.f4828b, c0035b.f4829c, c0035b.f4830d, false, true, c0035b.f4832f, 0.0f, 0.0f);
            } else {
                i11 = i13;
                boolean z3 = i11 >= bVar.f4816d && i11 <= bVar.f4817e;
                float f12 = c0035b.f4830d - size;
                float fA = g.a(f12, f10, f9);
                float f13 = (f12 / 2.0f) + f11;
                float fAbs = Math.abs(f13 - c0035b.f4828b);
                float f14 = c0035b.f4832f;
                float f15 = fAbs;
                if (!z) {
                    fAbs = 0.0f;
                }
                if (z) {
                    f15 = 0.0f;
                }
                aVar.b(f13, fA, f12, z3, false, f14, fAbs, f15);
                f11 += f12;
            }
            i13 = i11 + 1;
        }
        return aVar.d();
    }

    public final b a() {
        return this.f4836c.get(r1.size() - 1);
    }

    public final b b(float f8, float f9, float f10) {
        float fB;
        List<b> list;
        float[] fArr;
        float[] fArr2;
        float f11 = this.f4839f;
        float f12 = f9 + f11;
        float f13 = this.f4840g;
        float f14 = f10 - f13;
        float f15 = c().a().f4833g;
        float f16 = a().a().h;
        if (f11 == f15) {
            f12 += f15;
        }
        if (f13 == f16) {
            f14 -= f16;
        }
        if (f8 < f12) {
            fB = l4.a.b(1.0f, 0.0f, f9, f12, f8);
            list = this.f4835b;
            fArr = this.f4837d;
        } else {
            if (f8 <= f14) {
                return this.f4834a;
            }
            fB = l4.a.b(0.0f, 1.0f, f14, f10, f8);
            list = this.f4836c;
            fArr = this.f4838e;
        }
        int size = list.size();
        float f17 = fArr[0];
        int i10 = 1;
        while (true) {
            if (i10 >= size) {
                fArr2 = new float[]{0.0f, 0.0f, 0.0f};
                break;
            }
            float f18 = fArr[i10];
            if (fB <= f18) {
                fArr2 = new float[]{l4.a.b(0.0f, 1.0f, f17, f18, fB), i10 - 1, i10};
                break;
            }
            i10++;
            f17 = f18;
        }
        b bVar = list.get((int) fArr2[1]);
        b bVar2 = list.get((int) fArr2[2]);
        float f19 = fArr2[0];
        float f20 = bVar.f4813a;
        List<b.C0035b> list2 = bVar.f4815c;
        if (f20 != bVar2.f4813a) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<b.C0035b> list3 = bVar2.f4815c;
        if (list2.size() != list3.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list2.size(); i11++) {
            b.C0035b c0035b = list2.get(i11);
            b.C0035b c0035b2 = list3.get(i11);
            arrayList.add(new b.C0035b(l4.a.a(c0035b.f4827a, c0035b2.f4827a, f19), l4.a.a(c0035b.f4828b, c0035b2.f4828b, f19), l4.a.a(c0035b.f4829c, c0035b2.f4829c, f19), l4.a.a(c0035b.f4830d, c0035b2.f4830d, f19), false, 0.0f, 0.0f, 0.0f));
        }
        return new b(bVar.f4813a, arrayList, l4.a.c(f19, bVar.f4816d, bVar2.f4816d), l4.a.c(f19, bVar.f4817e, bVar2.f4817e), bVar.f4818f);
    }

    public final b c() {
        return this.f4835b.get(r1.size() - 1);
    }
}
