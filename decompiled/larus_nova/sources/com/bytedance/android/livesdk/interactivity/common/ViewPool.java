package com.bytedance.android.livesdk.interactivity.common;

import android.widget.ImageView;
import androidx.core.util.Pools;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/ViewPool;", "Landroidx/core/util/Pools$Pool;", "Landroid/widget/ImageView;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewPool implements Pools.Pool<ImageView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f136307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView[] f136308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f136309c;

    public final ImageView a() {
        int r100 = this.f136309c;
        if (r100 <= 0) goto L9;
        int r101 = r100 - 1;
        if (r101 < this.f136307a) goto L7;
        return null;
    L7:
        ImageView[] r102 = this.f136308b;
        ImageView r103 = r102[r101];
        r102[r101] = null;
        this.f136309c = r100 - 1;
        return r103;
    L9:
        return null;
    }

    @Override // androidx.core.util.Pools.Pool
    public final /* bridge */ /* synthetic */ ImageView acquire() {
        return a();
    }

    public ViewPool(int r100) {
        this.f136307a = r100;
        this.f136308b = new ImageView[r100];
    }

    public final boolean b(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        int r101 = this.f136309c;
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L9;
        if (this.f136308b[r102] == r100) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return false;
    L12:
        int r104 = this.f136309c;
        if (r104 >= this.f136307a) goto L16;
        this.f136308b[r104] = r100;
        this.f136309c = r104 + 1;
        r100.setVisibility(8);
        return true;
    L16:
        return false;
    L9:
        r103 = false;
        goto L10
    }

    @Override // androidx.core.util.Pools.Pool
    public final /* bridge */ /* synthetic */ boolean release(ImageView r100) {
        return b(r100);
    }
}
