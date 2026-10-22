package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemMediaLayer f169691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f169692b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x
    public final void onStartPlay() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x
    public final void a() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.f169210d == false) goto L14;
        ItemMediaLayer r100 = this.f169691a;
        int r101 = this.f169692b;
        Integer r102 = r100.f169659a;
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L15;
        this.f169691a.C(false);
        return;
    L15:
        return;
    L8:
        if (r101 != r102.intValue()) goto L10;
        r103 = true;
        goto L11
    }

    public g(ItemMediaLayer r100, int r101) {
        this.f169691a = r100;
        this.f169692b = r101;
    }
}
