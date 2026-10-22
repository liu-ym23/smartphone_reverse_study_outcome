package com.stepos.familyguard.ui.usage;

import android.text.TextUtils;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.familyguard.ui.usage.z;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class A extends z {

    /* renamed from: f, reason: collision with root package name */
    private String f14861f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.lifecycle.B<List<z.c>> f14862g = new androidx.lifecycle.B<>();

    /* renamed from: h, reason: collision with root package name */
    private final androidx.lifecycle.B<List<z.a>> f14863h = new androidx.lifecycle.B<>();

    private void k0() {
        List<z.c> listE = d0().e();
        List<z.a> listE2 = e0().e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!TextUtils.isEmpty(this.f14861f)) {
            if (listE != null) {
                for (z.c cVar : listE) {
                    String str = cVar.f15175c;
                    if (str != null && str.contains(this.f14861f)) {
                        arrayList.add(cVar);
                    }
                }
            }
            if (listE2 != null) {
                for (z.a aVar : listE2) {
                    String str2 = aVar.f15172c;
                    if (str2 != null && str2.contains(this.f14861f)) {
                        arrayList2.add(aVar);
                    }
                }
            }
        }
        this.f14863h.k(arrayList2);
        this.f14862g.k(arrayList);
    }

    @Override // com.stepos.familyguard.ui.usage.z
    protected void f0(x xVar) {
        super.f0(xVar);
        k0();
    }

    public AbstractC0545z<List<z.a>> g0() {
        return this.f14863h;
    }

    public AbstractC0545z<List<z.c>> h0() {
        return this.f14862g;
    }

    public String i0() {
        return this.f14861f;
    }

    public void j0(String str) {
        this.f14861f = str;
        k0();
    }
}
