package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements LiveBottomSheetDialog.m {
    public g() {
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
    public final boolean disableDragDown() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
    public final boolean shouldInterceptSlide(int r100) {
        return false;
    }
}
