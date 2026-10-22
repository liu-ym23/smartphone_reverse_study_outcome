package com.stepos.familyguard.ui.usage;

import androidx.lifecycle.AbstractC0545z;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.WhitelistAppInfo;
import com.stepos.familyguard.ui.usage.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class z extends C0610t {

    /* renamed from: d, reason: collision with root package name */
    private final androidx.lifecycle.B<List<c>> f15169d = new androidx.lifecycle.B<>();

    /* renamed from: e, reason: collision with root package name */
    private final androidx.lifecycle.B<List<a>> f15170e = new androidx.lifecycle.B<>();

    public static class a extends b {

        /* renamed from: b, reason: collision with root package name */
        int f15171b;

        /* renamed from: c, reason: collision with root package name */
        String f15172c;

        public String toString() {
            return "CategoryLimitData{categoryId=" + this.f15171b + ", label='" + this.f15172c + "', limited=" + this.f15173a + '}';
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        boolean f15173a;
    }

    public static class c extends b {

        /* renamed from: b, reason: collision with root package name */
        String f15174b;

        /* renamed from: c, reason: collision with root package name */
        String f15175c;

        public String toString() {
            return "PackageLimitData{packageName='" + this.f15174b + "', label='" + this.f15175c + "', limited=" + this.f15173a + '}';
        }
    }

    @Override // com.stepos.familyguard.ui.usage.C0610t, androidx.lifecycle.T
    protected void J() {
        super.J();
        T().l(new y(this));
    }

    @Override // com.stepos.familyguard.ui.usage.C0610t
    public void c0(v2.e eVar) {
        super.c0(eVar);
        T().h(new y(this));
    }

    public AbstractC0545z<List<c>> d0() {
        return this.f15169d;
    }

    public AbstractC0545z<List<a>> e0() {
        return this.f15170e;
    }

    protected void f0(x xVar) {
        List<x.b> listE = xVar.e();
        List<x.a> listB = xVar.b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (xVar.h() != null) {
            Iterator<WhitelistAppInfo> it = xVar.h().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next().getPackageName());
            }
        }
        for (x.b bVar : listE) {
            c cVar = new c();
            String str = bVar.f15165a;
            cVar.f15174b = str;
            if (!arrayList3.contains(str)) {
                cVar.f15175c = bVar.f15166b;
                cVar.f15173a = bVar.f15167c;
                arrayList.add(cVar);
            }
        }
        for (x.a aVar : listB) {
            a aVar2 = new a();
            aVar2.f15171b = aVar.f15161a;
            aVar2.f15172c = aVar.f15162b;
            aVar2.f15173a = aVar.f15164d;
            arrayList2.add(aVar2);
        }
        this.f15169d.n(arrayList);
        this.f15170e.n(arrayList2);
    }

    @Override // com.stepos.familyguard.ui.usage.C0610t, w2.V0
    public void q(DataToken dataToken) {
        super.q(dataToken);
    }
}
