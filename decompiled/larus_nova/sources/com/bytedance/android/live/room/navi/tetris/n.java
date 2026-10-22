package com.bytedance.android.live.room.navi.tetris;

import android.widget.TextView;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeRoomNavigatorTetris f99778a;

    public n(LandscapeRoomNavigatorTetris r100) {
        this.f99778a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LandscapeRoomNavigatorTetris r102 = this.f99778a;
        String r103 = r102.V();
        MarqueeTextView r104 = r102.f99744s;
        if (r104 == null) goto L5;
        String r105 = r104.getOriginText();
    L7:
        if (r103.equals(r105) == true) goto L17;
        MarqueeTextView r106 = r102.f99744s;
        if (r106 == null) goto L12;
        r106.setTextWithEllipsisImmediately(r102.V());
    L12:
        TextView r107 = r102.f99742q;
        if (r107 == null) goto L16;
        r107.setText(r102.V());
        return;
    L16:
        return;
    L17:
        return;
    L5:
        r105 = null;
        goto L7
    }
}
