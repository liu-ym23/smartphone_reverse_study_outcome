package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes13.dex */
public final class s extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f168715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h83.g f168716d;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.c, com.bytedance.android.shopping.anchorv4.voavhs.head.base.i
    public final void b(int r100) {
        r r101 = this.f168715c;
        h83.g r102 = this.f168716d;
        r101.getClass();
        if (r102 == null) goto L11;
        boolean r103 = true;
        if (r102.f484099i != true) goto L11;
        if (r102.f484100j == null) goto L11;
        if (r102.f484102l == true) goto L11;
    L12:
        if (r103 == false) goto L24;
        Context r104 = this.f168715c.getContext();
        String r105 = null;
        if ((r104 instanceof Activity) == true) goto L16;
        r104 = null;
    L16:
        Activity r106 = (Activity) r104;
        if (r106 == null) goto L26;
        com.bytedance.android.ec.sdk.helper.p r107 = com.bytedance.android.ec.sdk.helper.p.f48130a;
        h83.g r108 = this.f168716d;
        if (r108 == null) goto L23;
        h83.a r109 = r108.f484100j;
        if (r109 == null) goto L23;
        r105 = r109.f484069b;
    L23:
        r107.d(r105, r106);
        return;
    L26:
        return;
    L24:
        super.b(r100);
        return;
    L11:
        r103 = false;
        goto L12
    }

    public s(r r100, h83.g r101, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r102, Integer r103) {
        this.f168715c = r100;
        this.f168716d = r101;
        super(r102, r103);
    }
}
