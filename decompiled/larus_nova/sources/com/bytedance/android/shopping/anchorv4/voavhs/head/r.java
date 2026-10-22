package com.bytedance.android.shopping.anchorv4.voavhs.head;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public final class r implements com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Integer> f168811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SlidesAndIndicatorV4Component f168812b;

    public r(SlidesAndIndicatorV4Component r100) {
        this.f168812b = r100;
        this.f168811a = new LinkedHashSet();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.j
    public final void a(int r100, String r101, String r102) {
        if (this.f168811a.contains(Integer.valueOf(r100)) == true) goto L6;
        this.f168811a.add(Integer.valueOf(r100));
        this.f168812b.f168471y.t(r100, null, null);
        return;
    }
}
