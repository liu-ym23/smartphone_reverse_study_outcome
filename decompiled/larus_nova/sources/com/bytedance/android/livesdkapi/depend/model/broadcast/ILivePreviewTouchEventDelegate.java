package com.bytedance.android.livesdkapi.depend.model.broadcast;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\bf\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J0\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILivePreviewTouchEventDelegate;", "", "processAmazingTouchEvent", "", "pointerId", "", "eventType", "x", "", "y", "force", "majorRadius", "pointerCount", "processDoubleClickEvent", "processLongPressEvent", "processPanEvent", "dx", "dy", "factor", "processRotationEvent", "rotation", "processScaleEvent", "scale", "processTouchDownEvent", "processTouchEvent", "processTouchUpEvent", "Companion", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewTouchEventDelegate {
    public static final Companion Companion = null;
    public static final int TOUCH_TYPE_DOWN = 0;
    public static final int TOUCH_TYPE_LONG_PRESS = 3;
    public static final int TOUCH_TYPE_MOVE = 1;
    public static final int TOUCH_TYPE_UP = 2;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILivePreviewTouchEventDelegate$Companion;", "", "()V", "TOUCH_TYPE_DOWN", "", "TOUCH_TYPE_LONG_PRESS", "TOUCH_TYPE_MOVE", "TOUCH_TYPE_UP", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int TOUCH_TYPE_DOWN = 0;
        public static final int TOUCH_TYPE_LONG_PRESS = 3;
        public static final int TOUCH_TYPE_MOVE = 1;
        public static final int TOUCH_TYPE_UP = 2;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void processAmazingTouchEvent(int r100, int r101, float r102, float r103, float r104, float r105, int r106);

    void processDoubleClickEvent(float r100, float r101);

    void processLongPressEvent(float r100, float r101);

    void processPanEvent(float r100, float r101, float r102, float r103, float r104);

    void processRotationEvent(float r100, float r101);

    void processScaleEvent(float r100, float r101);

    void processTouchDownEvent(float r100, float r101);

    void processTouchEvent(float r100, float r101);

    void processTouchUpEvent(float r100, float r101);
}
