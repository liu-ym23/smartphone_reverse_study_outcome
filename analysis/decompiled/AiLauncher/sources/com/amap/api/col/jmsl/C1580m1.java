package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Vector;

/* renamed from: com.amap.api.col.jmsl.m1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1580m1 extends AbstractC1619w1 {

    /* renamed from: b, reason: collision with root package name */
    public int f16743b;

    /* renamed from: c, reason: collision with root package name */
    public long f16744c;

    /* renamed from: d, reason: collision with root package name */
    public String f16745d;

    /* renamed from: e, reason: collision with root package name */
    public Context f16746e;

    public C1580m1(Context context, int i10, String str, AbstractC1619w1 abstractC1619w1) {
        super(abstractC1619w1);
        this.f16743b = i10;
        this.f16745d = str;
        this.f16746e = context;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1619w1
    public void c(boolean z10) {
        AbstractC1619w1 abstractC1619w1 = this.f17018a;
        if (abstractC1619w1 != null) {
            abstractC1619w1.c(z10);
        }
        if (z10) {
            String str = this.f16745d;
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f16744c = jCurrentTimeMillis;
            Context context = this.f16746e;
            String strValueOf = String.valueOf(jCurrentTimeMillis);
            Vector<C1569j2> vector = D1.f15990b;
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
            editorEdit.putString(str, strValueOf);
            editorEdit.apply();
        }
    }

    @Override // com.amap.api.col.jmsl.AbstractC1619w1
    public boolean e() {
        if (this.f16744c == 0) {
            String strF = D1.f(this.f16746e, this.f16745d);
            this.f16744c = TextUtils.isEmpty(strF) ? 0L : Long.parseLong(strF);
        }
        return System.currentTimeMillis() - this.f16744c >= ((long) this.f16743b);
    }
}
