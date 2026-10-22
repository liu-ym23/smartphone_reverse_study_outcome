package com.bytedance.android.live.effect.beauty.body;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBodyBeautyAdapter.b f67185a;

    public d(LiveBodyBeautyAdapter.b r100) {
        this.f67185a = r100;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        r101.setCheckable(false);
        r101.setContentDescription(((TextView) this.f67185a.itemView.findViewById(R.id.switch_text)).getText());
    }
}
