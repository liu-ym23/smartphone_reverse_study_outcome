package androidx.camera.view.impl;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0003-./B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010(\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0007R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u00060"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "spanSlop", "", "minSpan", "listener", "Landroidx/camera/view/impl/ZoomGestureDetector$OnZoomGestureListener;", "(Landroid/content/Context;IILandroidx/camera/view/impl/ZoomGestureDetector$OnZoomGestureListener;)V", "anchoredZoomMode", "anchoredZoomStartX", "", "anchoredZoomStartY", "currentSpan", "currentSpanX", "currentSpanY", "eventBeforeOrAboveStartingGestureEvent", "", "eventTime", "", "focusX", "focusY", "gestureDetector", "Landroid/view/GestureDetector;", "initialSpan", "isInProgress", "isQuickZoomEnabled", "()Z", "setQuickZoomEnabled", "(Z)V", "isStylusZoomEnabled", "setStylusZoomEnabled", "prevTime", "previousSpan", "previousSpanX", "previousSpanY", "timeDelta", "getTimeDelta", "()J", "getIncrementalScaleFactor", "inAnchoredZoomMode", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "OnZoomGestureListener", "ZoomEvent", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ZoomGestureDetector {
    private static final int ANCHORED_ZOOM_MODE_DOUBLE_TAP = 1;
    private static final int ANCHORED_ZOOM_MODE_NONE = 0;
    private static final int ANCHORED_ZOOM_MODE_STYLUS = 2;
    public static final Companion Companion = null;
    private static final int DEFAULT_MIN_SPAN = 0;
    private static final float SCALE_FACTOR = 0.5f;
    private int anchoredZoomMode;
    private float anchoredZoomStartX;
    private float anchoredZoomStartY;
    private final Context context;
    private float currentSpan;
    private float currentSpanX;
    private float currentSpanY;
    private boolean eventBeforeOrAboveStartingGestureEvent;
    private long eventTime;
    private int focusX;
    private int focusY;
    private GestureDetector gestureDetector;
    private float initialSpan;
    private boolean isInProgress;
    private boolean isQuickZoomEnabled;
    private boolean isStylusZoomEnabled;
    private final OnZoomGestureListener listener;
    private final int minSpan;
    private long prevTime;
    private float previousSpan;
    private float previousSpanX;
    private float previousSpanY;
    private final int spanSlop;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$Companion;", "", "()V", "ANCHORED_ZOOM_MODE_DOUBLE_TAP", "", "ANCHORED_ZOOM_MODE_NONE", "ANCHORED_ZOOM_MODE_STYLUS", "DEFAULT_MIN_SPAN", "SCALE_FACTOR", "", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$OnZoomGestureListener;", "", "onZoomEvent", "", "zoomEvent", "Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent;", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnZoomGestureListener {
        boolean onZoomEvent(ZoomEvent r100);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB%\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0010"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent;", "", "eventTime", "", "focusX", "", "focusY", "(JII)V", "getEventTime", "()J", "getFocusX", "()I", "getFocusY", "Begin", "End", "Move", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class ZoomEvent {
        private final long eventTime;
        private final int focusX;
        private final int focusY;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent$Begin;", "Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent;", "eventTime", "", "focusX", "", "focusY", "(JII)V", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Begin extends ZoomEvent {
            public Begin(long r100, int r101, int r110) {
                super(r100, r101, r110, null);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent$End;", "Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent;", "eventTime", "", "focusX", "", "focusY", "incrementalScaleFactor", "", "(JIIF)V", "getIncrementalScaleFactor", "()F", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class End extends ZoomEvent {
            private final float incrementalScaleFactor;

            public final float getIncrementalScaleFactor() {
                return this.incrementalScaleFactor;
            }

            public End(long r100, int r101, int r110, float r111) {
                super(r100, r101, r110, null);
                this.incrementalScaleFactor = r111;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent$Move;", "Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent;", "eventTime", "", "focusX", "", "focusY", "incrementalScaleFactor", "", "(JIIF)V", "getIncrementalScaleFactor", "()F", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Move extends ZoomEvent {
            private final float incrementalScaleFactor;

            public final float getIncrementalScaleFactor() {
                return this.incrementalScaleFactor;
            }

            public Move(long r100, int r101, int r110, float r111) {
                super(r100, r101, r110, null);
                this.incrementalScaleFactor = r111;
            }
        }

        public /* synthetic */ ZoomEvent(long r100, int r101, int r102, DefaultConstructorMarker r103) {
            this(r100, r101, r102);
        }

        public final long getEventTime() {
            return this.eventTime;
        }

        public final int getFocusX() {
            return this.focusX;
        }

        public final int getFocusY() {
            return this.focusY;
        }

        private ZoomEvent(long r100, int r101, int r102) {
            this.eventTime = r100;
            this.focusX = r101;
            this.focusY = r102;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ZoomGestureDetector(Context r100, int r110, OnZoomGestureListener r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "listener");
        this(r100, r110, 0, r111, 4, null);
    }

    public ZoomGestureDetector(Context r100, OnZoomGestureListener r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "listener");
        this(r100, 0, 0, r110, 6, null);
    }

    private final boolean inAnchoredZoomMode() {
        if (this.anchoredZoomMode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getTimeDelta() {
        return this.eventTime - this.prevTime;
    }

    private final float getIncrementalScaleFactor() {
        if (inAnchoredZoomMode() == false) goto L20;
        boolean r100 = this.eventBeforeOrAboveStartingGestureEvent;
        if (r100 == true) goto L7;
    L8:
        if (r100 == false) goto L10;
    L12:
        boolean r101 = false;
    L13:
        float r102 = Math.abs(1 - (this.currentSpan / this.previousSpan)) * 0.5f;
        if (this.previousSpan <= this.spanSlop) goto L25;
        if (r101 == false) goto L19;
        return 1.0f + r102;
    L19:
        return 1.0f - r102;
    L25:
        return 1.0f;
    L10:
        if (this.currentSpan <= this.previousSpan) goto L12;
    L11:
        r101 = true;
        goto L13
    L7:
        if (this.currentSpan < this.previousSpan) goto L11;
    L20:
        float r103 = this.previousSpan;
        if (r103 > 0.0f) goto L23;
        return 1.0f;
    L23:
        return this.currentSpan / r103;
    }

    public final boolean isQuickZoomEnabled() {
        return this.isQuickZoomEnabled;
    }

    public final boolean isStylusZoomEnabled() {
        return this.isStylusZoomEnabled;
    }

    public final boolean onTouchEvent(MotionEvent r210) {
        Intrinsics.checkNotNullParameter(r210, "event");
        this.eventTime = r210.getEventTime();
        int r100 = r210.getActionMasked();
        if (this.isQuickZoomEnabled == false) goto L5;
        this.gestureDetector.onTouchEvent(r210);
    L5:
        int r101 = r210.getPointerCount();
        if ((r210.getButtonState() & 32) == 0) goto L8;
        boolean r102 = true;
    L10:
        if (this.anchoredZoomMode != 2) goto L13;
        if (r102 == true) goto L13;
        boolean r103 = true;
    L14:
        if (r100 != 1) goto L16;
    L20:
        boolean r104 = true;
    L21:
        float r110 = 0.0f;
        if (r100 == 0) goto L25;
        if (r104 == true) goto L25;
    L35:
        if (this.isInProgress == true) goto L44;
        if (this.isStylusZoomEnabled == false) goto L44;
        if (inAnchoredZoomMode() == true) goto L44;
        if (r104 == true) goto L44;
        if (r102 == false) goto L44;
        this.anchoredZoomStartX = r210.getX();
        this.anchoredZoomStartY = r210.getY();
        this.anchoredZoomMode = 2;
        this.initialSpan = 0.0f;
    L44:
        if (r100 == 0) goto L51;
        if (r100 == 6) goto L51;
        if (r100 == 5) goto L51;
        if (r103 == true) goto L51;
        boolean r105 = false;
    L52:
        if (r100 != 6) goto L54;
        boolean r106 = true;
    L55:
        if (r106 == false) goto L57;
        int r107 = r210.getActionIndex();
    L58:
        if (r106 == false) goto L60;
        int r108 = r101 - 1;
    L62:
        if (inAnchoredZoomMode() == false) goto L68;
        float r109 = this.anchoredZoomStartX;
        float r111 = this.anchoredZoomStartY;
        if (r210.getY() >= r111) goto L66;
        boolean r112 = true;
    L67:
        this.eventBeforeOrAboveStartingGestureEvent = r112;
    L74:
        float r113 = 0.0f;
        int r114 = 0;
    L75:
        if (r114 >= r101) goto L79;
        if (r107 == r114) goto L78;
        r110 = r110 + Math.abs(r210.getX(r114) - r109);
        r113 = r113 + Math.abs(r210.getY(r114) - r111);
    L78:
        r114 = r114 + 1;
        goto L75
    L79:
        float r115 = r108;
        float r116 = 2;
        float r117 = (r110 / r115) * r116;
        float r118 = (r113 / r115) * r116;
        if (inAnchoredZoomMode() == false) goto L82;
        float r119 = r118;
    L83:
        boolean r120 = this.isInProgress;
        this.focusX = MathKt.roundToInt(r109);
        this.focusY = MathKt.roundToInt(r111);
        if (inAnchoredZoomMode() == false) goto L86;
    L91:
        if (r105 == false) goto L94;
        this.currentSpanX = r117;
        this.previousSpanX = r117;
        this.currentSpanY = r118;
        this.previousSpanY = r118;
        this.currentSpan = r119;
        this.previousSpan = r119;
        this.initialSpan = r119;
    L94:
        if (inAnchoredZoomMode() == false) goto L96;
        int r121 = this.spanSlop;
    L98:
        if (this.isInProgress == true) goto L106;
        if (r119 < r121) goto L106;
        if (r120 == false) goto L103;
    L104:
        this.currentSpanX = r117;
        this.previousSpanX = r117;
        this.currentSpanY = r118;
        this.previousSpanY = r118;
        this.currentSpan = r119;
        this.previousSpan = r119;
        long r122 = this.eventTime;
        this.prevTime = r122;
        this.isInProgress = this.listener.onZoomEvent(new ZoomEvent.Begin(r122, this.focusX, this.focusY));
        goto L106
    L103:
        if (Math.abs(r119 - this.initialSpan) > this.spanSlop) goto L104;
    L106:
        if (r100 != 2) goto L121;
        this.currentSpanX = r117;
        this.currentSpanY = r118;
        this.currentSpan = r119;
        if (this.isInProgress == false) goto L110;
        boolean r123 = this.listener.onZoomEvent(new ZoomEvent.Move(this.eventTime, this.focusX, this.focusY, getIncrementalScaleFactor()));
    L111:
        if (r123 == false) goto L122;
        this.previousSpanX = this.currentSpanX;
        this.previousSpanY = this.currentSpanY;
        this.previousSpan = this.currentSpan;
        this.prevTime = this.eventTime;
        return true;
    L122:
        return true;
    L110:
        r123 = true;
        goto L111
    L121:
        return true;
    L96:
        r121 = this.minSpan;
        goto L98
    L86:
        if (this.isInProgress == false) goto L91;
        if (r119 < this.minSpan) goto L90;
        if (r105 == false) goto L91;
    L90:
        this.listener.onZoomEvent(new ZoomEvent.End(this.eventTime, this.focusX, this.focusY, getIncrementalScaleFactor()));
        this.isInProgress = false;
        this.initialSpan = r119;
        goto L91
    L82:
        r119 = (float) Math.hypot(r117, r118);
        goto L83
    L66:
        r112 = false;
        goto L67
    L68:
        int r124 = 0;
        float r125 = 0.0f;
        float r126 = 0.0f;
    L69:
        if (r124 >= r101) goto L73;
        if (r107 == r124) goto L72;
        r125 = r125 + r210.getX(r124);
        r126 = r126 + r210.getY(r124);
    L72:
        r124 = r124 + 1;
        goto L69
    L73:
        float r127 = r108;
        float r128 = r125 / r127;
        r111 = r126 / r127;
        r109 = r128;
        goto L74
    L60:
        r108 = r101;
        goto L62
    L57:
        r107 = -1;
        goto L58
    L54:
        r106 = false;
    L51:
        r105 = true;
    L25:
        if (this.isInProgress == false) goto L28;
        this.listener.onZoomEvent(new ZoomEvent.End(this.eventTime, this.focusX, this.focusY, getIncrementalScaleFactor()));
        this.isInProgress = false;
        this.initialSpan = 0.0f;
        this.anchoredZoomMode = 0;
    L31:
        if (r104 == false) goto L35;
        return true;
    L28:
        if (inAnchoredZoomMode() == false) goto L31;
        if (r104 == false) goto L31;
        this.isInProgress = false;
        this.initialSpan = 0.0f;
        this.anchoredZoomMode = 0;
        goto L31
    L16:
        if (r100 == 3) goto L20;
        if (r103 == true) goto L20;
        r104 = false;
    L13:
        r103 = false;
        goto L14
    L8:
        r102 = false;
        goto L10
    }

    public final void setQuickZoomEnabled(boolean r100) {
        this.isQuickZoomEnabled = r100;
    }

    public final void setStylusZoomEnabled(boolean r100) {
        this.isStylusZoomEnabled = r100;
    }

    public static final /* synthetic */ void access$setAnchoredZoomMode$p(ZoomGestureDetector r100, int r101) {
        r100.anchoredZoomMode = r101;
    }

    public static final /* synthetic */ void access$setAnchoredZoomStartX$p(ZoomGestureDetector r100, float r101) {
        r100.anchoredZoomStartX = r101;
    }

    public static final /* synthetic */ void access$setAnchoredZoomStartY$p(ZoomGestureDetector r100, float r101) {
        r100.anchoredZoomStartY = r101;
    }

    public ZoomGestureDetector(Context r100, int r101, int r102, OnZoomGestureListener r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "listener");
        this.context = r100;
        this.spanSlop = r101;
        this.minSpan = r102;
        this.listener = r103;
        this.isQuickZoomEnabled = true;
        this.isStylusZoomEnabled = true;
        this.gestureDetector = new GestureDetector(r100, new ZoomGestureDetector$gestureDetector$1(this));
    }

    public /* synthetic */ ZoomGestureDetector(Context r100, int r101, int r102, OnZoomGestureListener r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = ViewConfiguration.get(r100).getScaledTouchSlop() * 2;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102, r103);
    }
}
