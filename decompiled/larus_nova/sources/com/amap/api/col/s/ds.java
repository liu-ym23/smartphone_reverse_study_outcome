package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes28.dex */
public final class ds extends dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f26592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f26593b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f26595e;

    @Override // com.amap.api.col.s.dt
    public final boolean a() {
        long r100 = 0;
        if (this.f26593b != 0) goto L10;
        String r101 = ce.a(this.f26595e, this.f26594d);
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r100 = CastLongProtector.parseLong(r101);
    L8:
        this.f26593b = r100;
    L10:
        if ((System.currentTimeMillis() - this.f26593b) >= this.f26592a) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.amap.api.col.s.dt
    public final void a(boolean r100) {
        super.a(r100);
        if (r100 == false) goto L6;
        String r101 = this.f26594d;
        long r102 = System.currentTimeMillis();
        this.f26593b = r102;
        ce.a(this.f26595e, r101, String.valueOf(r102));
        return;
    }

    public ds(Context r100, int r101, String r102, dt r103) {
        super(r103);
        this.f26592a = r101;
        this.f26594d = r102;
        this.f26595e = r100;
    }
}
