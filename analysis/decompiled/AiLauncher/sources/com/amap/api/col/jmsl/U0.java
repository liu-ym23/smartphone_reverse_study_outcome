package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class U0 extends AbstractC1619w1 {

    /* renamed from: c, reason: collision with root package name */
    public Context f16361c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16362d;

    /* renamed from: e, reason: collision with root package name */
    public int f16363e;

    /* renamed from: f, reason: collision with root package name */
    public int f16364f;

    /* renamed from: b, reason: collision with root package name */
    public String f16360b = "iKey";

    /* renamed from: g, reason: collision with root package name */
    public int f16365g = 0;

    public U0(Context context, boolean z10, int i10, int i11, String str, int i12) {
        f(context, z10, i10, i11, str, i12);
    }

    @Override // com.amap.api.col.jmsl.AbstractC1619w1
    public int a() {
        int i10;
        if ((S0.s(this.f16361c) == 1 || (i10 = this.f16363e) <= 0) && ((i10 = this.f16365g) <= 0 || i10 >= Integer.MAX_VALUE)) {
            i10 = Integer.MAX_VALUE;
        }
        AbstractC1619w1 abstractC1619w1 = this.f17018a;
        return abstractC1619w1 != null ? Math.max(i10, abstractC1619w1.a()) : i10;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1619w1
    public void b(int i10) {
        if (S0.s(this.f16361c) == 1) {
            return;
        }
        String strA = C1604s2.a(System.currentTimeMillis(), "yyyyMMdd");
        String strF = D1.f(this.f16361c, this.f16360b);
        if (!TextUtils.isEmpty(strF)) {
            String[] strArrSplit = strF.split("\\|");
            if (strArrSplit == null || strArrSplit.length < 2) {
                Context context = this.f16361c;
                String str = this.f16360b;
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
                editorEdit.remove(str);
                editorEdit.apply();
            } else if (strA.equals(strArrSplit[0])) {
                i10 += Integer.parseInt(strArrSplit[1]);
            }
        }
        Context context2 = this.f16361c;
        String str2 = this.f16360b;
        String str3 = strA + "|" + i10;
        SharedPreferences.Editor editorEdit2 = context2.getSharedPreferences("AMSKLG_CFG", 0).edit();
        editorEdit2.putString(str2, str3);
        editorEdit2.apply();
    }

    @Override // com.amap.api.col.jmsl.AbstractC1619w1
    public boolean e() {
        if (S0.s(this.f16361c) == 1) {
            return true;
        }
        if (!this.f16362d) {
            return false;
        }
        String strF = D1.f(this.f16361c, this.f16360b);
        if (TextUtils.isEmpty(strF)) {
            return true;
        }
        String[] strArrSplit = strF.split("\\|");
        if (strArrSplit != null && strArrSplit.length >= 2) {
            return !C1604s2.a(System.currentTimeMillis(), "yyyyMMdd").equals(strArrSplit[0]) || Integer.parseInt(strArrSplit[1]) < this.f16364f;
        }
        Context context = this.f16361c;
        String str = this.f16360b;
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        editorEdit.remove(str);
        editorEdit.apply();
        return true;
    }

    public final void f(Context context, boolean z10, int i10, int i11, String str, int i12) {
        this.f16361c = context;
        this.f16362d = z10;
        this.f16363e = i10;
        this.f16364f = i11;
        this.f16360b = str;
        this.f16365g = i12;
    }
}
