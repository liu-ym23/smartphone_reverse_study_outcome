package j1;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class s1 implements i1.l1 {

    /* renamed from: f, reason: collision with root package name */
    public final int f5324f;

    /* renamed from: g, reason: collision with root package name */
    public final List f5325g;

    /* renamed from: h, reason: collision with root package name */
    public Float f5326h = null;

    /* renamed from: i, reason: collision with root package name */
    public Float f5327i = null;

    /* renamed from: j, reason: collision with root package name */
    public p1.g f5328j = null;

    /* renamed from: k, reason: collision with root package name */
    public p1.g f5329k = null;

    public s1(int i2, ArrayList arrayList) {
        this.f5324f = i2;
        this.f5325g = arrayList;
    }

    @Override // i1.l1
    public final boolean p() {
        return this.f5325g.contains(this);
    }
}
