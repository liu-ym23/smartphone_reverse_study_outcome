package com.bytedance.android.live.core.tetris.layer.core.tetris;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.tetris.priority.PriorityTetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import h70.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t70.d;
import u70.c;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LivePriorityTetris;", "Lh70/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityTetris;", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LivePriorityTetris<T extends b> extends PriorityTetris<T> {
    public LivePriorityTetris() {
    }

    public static Element a0(LivePriorityTetris r100, LiveRecyclableWidget r101, c r102, boolean r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "widget");
        Intrinsics.checkNotNullParameter(r102, "priorityItemInfo");
        return r100.P(new d(r103, r101), r102);
    }

    public static Element b0(LivePriorityTetris r100, Class r101, c r102, boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r103 = true;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "widgetClass");
        Intrinsics.checkNotNullParameter(r102, "priorityItemInfo");
        return r100.P(new t70.c(r103, r101), r102);
    }
}
