package com.bytedance.android.livesdk.castscreen.views.actionsheet;

import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/actionsheet/VideoCastScreenActionSheet;", "Lcom/bytedance/android/livesdk/castscreen/views/actionsheet/CastScreenActionSheet;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCastScreenActionSheet extends CastScreenActionSheet {
    @Override // com.bytedance.android.livesdk.castscreen.views.actionsheet.CastScreenActionSheet
    public final CastScreenActionSheet.ActionSheetAdapter S90() {
        return new VideoCastScreenActionSheetAdapter(this);
    }

    @Override // com.bytedance.android.livesdk.castscreen.views.actionsheet.CastScreenActionSheet
    public final int getLayoutId() {
        if (PadConfigUtils.c() == false) goto L6;
        PadConfigUtils.c();
    L10:
        return super.getLayoutId();
    L6:
        if (isVertical() == true) goto L10;
        return R.layout.ttlive_cast_screen_resolution_action_sheet;
    }

    public VideoCastScreenActionSheet() {
    }
}
