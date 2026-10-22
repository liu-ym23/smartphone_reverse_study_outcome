package com.bytedance.android.debug;

import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: classes43.dex */
public final class h implements l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DebugGiftPreviewDebugWidget f42621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f42622b;

    @Override // com.bytedance.android.debug.l.a
    public final void a() {
    }

    @Override // com.bytedance.android.debug.l.a
    public final void b() {
    }

    @Override // com.bytedance.android.debug.l.a
    public final void onEnd() {
        HSImageView r100 = this.f42621a.f42581g;
        if (r100 == null) goto L5;
        UtilityKotlinExtentionsKt.u(r100);
    L5:
        LinearLayout r101 = this.f42621a.f42582h;
        if (r101 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r101);
        return;
    }

    @Override // com.bytedance.android.debug.l.a
    public final void onStart() {
        if (this.f42622b == null) goto L7;
        HSImageView r100 = this.f42621a.f42581g;
        if (r100 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r100);
    L7:
        LinearLayout r101 = this.f42621a.f42582h;
        if (r101 == null) goto L11;
        UtilityKotlinExtentionsKt.u(r101);
        return;
    }

    @Override // com.bytedance.android.debug.l.a
    public final void onStop() {
        LinearLayout r100 = this.f42621a.f42582h;
        if (r100 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r100);
        return;
    }

    public h(DebugGiftPreviewDebugWidget r100, String r101) {
        this.f42621a = r100;
        this.f42622b = r101;
    }
}
