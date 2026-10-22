package com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode;

import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewHolderBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Float> f168859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f168860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HeadViewHolderBuilder f168861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HeadViewHolderBuilder f168862d;

    public c(HeadViewHolderBuilder r100) {
        this.f168861c = r100;
        this.f168862d = null;
        this.f168859a = new ArrayList();
        int r101 = r100.c();
        this.f168860b = r101;
        ArrayList r102 = new ArrayList(r101);
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102.add(Float.valueOf(0.0f));
        r103 = r103 + 1;
        goto L3
    L5:
        this.f168859a = r102;
    }

    public final void a(int r100, float r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.f168860b) goto L17;
        int r102 = ((ArrayList) this.f168859a).size();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L18;
        List<Float> r104 = this.f168859a;
        if (r103 != r100) goto L11;
        float r105 = r101;
    L12:
        ListProtector.set(r104, r100, Float.valueOf(r105));
        r103 = r103 + 1;
        goto L7
    L11:
        r105 = 0.0f;
        goto L12
    L18:
        return;
    }
}
