package com.bytedance.android.shopping.slice;

import com.bytedance.android.ecom.arch.slice.render.e;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class SlcScaleProvider implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f183219a;

    public SlcScaleProvider() {
        this.f183219a = LazyKt.lazy(SlcScaleProvider$expSwitch$2.INSTANCE);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.e
    public final float a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "customScaleKey");
        if (((Number) this.f183219a.getValue()).intValue() == 1) goto L5;
    L10:
        return 0.0f;
    L5:
        if (r100.hashCode() != (-1986907590)) goto L10;
        if (r100.equals("original_view_no_extra_large") == false) goto L10;
        return RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a());
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.e
    public final float b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "customScaleKey");
        if (((Number) this.f183219a.getValue()).intValue() != 1) goto L15;
        int r101 = r100.hashCode();
        if (r101 == (-1986907590)) goto L13;
        if (r101 != 1863443539) goto L15;
        if (r100.equals("original_view") == false) goto L15;
    L14:
        return 1.0f;
    L13:
        if (r100.equals("original_view_no_extra_large") == true) goto L14;
    L15:
        return 0.0f;
    }
}
