package com.bytedance.android.livesdk.dsl.api;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class NativeWidgetMap_tetris {
    public NativeWidgetMap_tetris() {
    }

    public static Map<String, Class> collectWidgetClassMap() {
        HashMap r100 = new HashMap();
        r100.put("LiveRecyclableWidget", LiveRecyclableWidget.class);
        r100.put("LiveWidget", LiveWidget.class);
        return r100;
    }
}
