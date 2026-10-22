package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.common.MarqueeTextView;

/* JADX INFO: loaded from: classes8.dex */
public final class VSAnchorInfoWidget$timerListener$1 implements d9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSAnchorInfoWidget f118736a;

    @Override // com.bytedance.android.livesdk.chatroom.ui.d9.b
    public final String getTag() {
        return "VSAnchorInfoWidget";
    }

    public VSAnchorInfoWidget$timerListener$1(VSAnchorInfoWidget r100) {
        this.f118736a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.d9.b
    public final boolean a(long r100, long r101, int r102) {
        long r103 = r100 * r101;
        if (r103 < 10000) goto L10;
        if (r102 != 0) goto L10;
        MarqueeTextView r104 = this.f118736a.f118724j;
        if (r104 == null) goto L8;
        r104.startMarqueeIfNeed(new VSAnchorInfoWidget$timerListener$1$onTick$1(this));
    L8:
        return true;
    L10:
        if (r103 < 110000) goto L16;
        if (r102 != 1) goto L18;
        MarqueeTextView r105 = this.f118736a.f118724j;
        if (r105 == null) goto L15;
        r105.startMarqueeIfNeed(new VSAnchorInfoWidget$timerListener$1$onTick$2(this));
    L15:
        return true;
    L18:
        return false;
    L16:
        return false;
    }
}
