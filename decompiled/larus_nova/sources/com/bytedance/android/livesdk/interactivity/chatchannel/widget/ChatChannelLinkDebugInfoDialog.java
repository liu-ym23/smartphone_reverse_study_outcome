package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.os.Bundle;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelLinkDebugInfoDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelLinkDebugInfoDialog extends CommonStandardBottomDialog {
    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_room_channel_link_debug_info;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ((TextView) findViewById(R.id.debug_info)).setText(null);
    }
}
