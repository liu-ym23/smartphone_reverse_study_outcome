package com.bytedance.android.livesdk.performance;

import com.bytedance.android.livesdkapi.service.ICleanScreenManager;

/* JADX INFO: loaded from: classes11.dex */
public class LiveCleanScreenManager implements ICleanScreenManager {
    public LiveCleanScreenManager() {
    }

    @Override // com.bytedance.android.livesdkapi.service.ICleanScreenManager
    public void enterCleanScreen(int r100) {
        if (r100 == 10) goto L13;
        switch(r100) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L22;
        };
    L6:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(true, 32));
        return;
    L7:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(true, 16));
        return;
    L8:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(true, 8));
        return;
    L9:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(true, 4));
        return;
    L10:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(true, 2));
        return;
    L11:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(true, 1));
        return;
    L12:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(true, 0));
        return;
    L22:
        return;
    L13:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(true, 1024));
    }

    @Override // com.bytedance.android.livesdkapi.service.ICleanScreenManager
    public void exitCleanScreen(int r100) {
        switch(r100) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L19;
        };
    L5:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(false, 32));
        return;
    L6:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(false, 16));
        return;
    L7:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(false, 8));
        return;
    L8:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(false, 4));
        return;
    L9:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(false, 2));
        return;
    L10:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(false, 1));
        return;
    L11:
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(false, 0));
        return;
    }
}
