package com.stepos.agentframework.uikit;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ScrollView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00021\u001cB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 R*\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\"R\u0016\u0010.\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/stepos/agentframework/uikit/AgentMarkdownCodeScrollView;", "Landroid/widget/ScrollView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "LY8/t;", "onMeasure", "(II)V", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "dispatchTouchEvent", "", "dx", "dy", Const.INTENT_KEY_UMID, "(FF)V", Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_APIKEY, "(F)Z", UxipConstants.f30680s, "c", "(I)I", "maxHeightPx", "I", "getMaxHeightPx", "()I", "setMaxHeightPx", "(I)V", "downX", "F", "downY", "Lcom/stepos/agentframework/uikit/AgentMarkdownCodeScrollView$GestureAxis;", "gestureAxis", "Lcom/stepos/agentframework/uikit/AgentMarkdownCodeScrollView$GestureAxis;", "touchSlop", "handedOffVerticalToList", "Z", "Companion", "GestureAxis", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentMarkdownCodeScrollView extends ScrollView {
    private static final int DEFAULT_MAX_HEIGHT_DP = 244;
    private float downX;
    private float downY;
    private GestureAxis gestureAxis;
    private boolean handedOffVerticalToList;
    private int maxHeightPx;
    private final int touchSlop;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/uikit/AgentMarkdownCodeScrollView$GestureAxis;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "HORIZONTAL", "VERTICAL", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class GestureAxis {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ GestureAxis[] $VALUES;
        public static final GestureAxis UNKNOWN = new GestureAxis("UNKNOWN", 0);
        public static final GestureAxis HORIZONTAL = new GestureAxis("HORIZONTAL", 1);
        public static final GestureAxis VERTICAL = new GestureAxis("VERTICAL", 2);

        private static final /* synthetic */ GestureAxis[] $values() {
            return new GestureAxis[]{UNKNOWN, HORIZONTAL, VERTICAL};
        }

        static {
            GestureAxis[] gestureAxisArr$values = $values();
            $VALUES = gestureAxisArr$values;
            $ENTRIES = kotlin.enums.a.a(gestureAxisArr$values);
        }

        private GestureAxis(String str, int i10) {
        }

        public static InterfaceC4149a<GestureAxis> getEntries() {
            return $ENTRIES;
        }

        public static GestureAxis valueOf(String str) {
            return (GestureAxis) Enum.valueOf(GestureAxis.class, str);
        }

        public static GestureAxis[] values() {
            return (GestureAxis[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GestureAxis.values().length];
            try {
                iArr[GestureAxis.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GestureAxis.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GestureAxis.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AgentMarkdownCodeScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final boolean a(float dy) {
        return canScrollVertically(dy < 0.0f ? 1 : -1);
    }

    public final boolean b() {
        return canScrollVertically(1) || canScrollVertically(-1);
    }

    public final int c(int value) {
        return (int) TypedValue.applyDimension(1, value, getResources().getDisplayMetrics());
    }

    public final void d(float dx, float dy) {
        if (this.gestureAxis != GestureAxis.UNKNOWN) {
            return;
        }
        if (Math.abs(dx) > this.touchSlop && Math.abs(dx) > Math.abs(dy)) {
            this.gestureAxis = GestureAxis.HORIZONTAL;
        } else {
            if (Math.abs(dy) <= this.touchSlop || Math.abs(dy) < Math.abs(dx)) {
                return;
            }
            this.gestureAxis = GestureAxis.VERTICAL;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r8, r0)
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L85
            if (r0 == r2) goto L71
            r3 = 3
            r4 = 2
            if (r0 == r4) goto L17
            if (r0 == r3) goto L71
            goto La6
        L17:
            float r0 = r8.getX()
            float r5 = r7.downX
            float r0 = r0 - r5
            float r5 = r8.getY()
            float r6 = r7.downY
            float r5 = r5 - r6
            r7.d(r0, r5)
            com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView$GestureAxis r0 = r7.gestureAxis
            int[] r6 = com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView.b.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r6[r0]
            if (r0 == r2) goto L67
            if (r0 == r4) goto L4e
            if (r0 != r3) goto L48
            boolean r0 = r7.b()
            if (r0 == 0) goto La6
            android.view.ViewParent r0 = r7.getParent()
            if (r0 == 0) goto La6
            r0.requestDisallowInterceptTouchEvent(r2)
            goto La6
        L48:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L4e:
            boolean r0 = r7.a(r5)
            if (r0 == 0) goto L5e
            android.view.ViewParent r0 = r7.getParent()
            if (r0 == 0) goto La6
            r0.requestDisallowInterceptTouchEvent(r2)
            goto La6
        L5e:
            r7.handedOffVerticalToList = r2
            r7.stopNestedScroll()
            com.stepos.agentframework.uikit.h0.a(r7)
            goto La6
        L67:
            android.view.ViewParent r0 = r7.getParent()
            if (r0 == 0) goto La6
            r0.requestDisallowInterceptTouchEvent(r1)
            goto La6
        L71:
            com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView$GestureAxis r0 = com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView.GestureAxis.UNKNOWN
            r7.gestureAxis = r0
            boolean r0 = r7.handedOffVerticalToList
            if (r0 != 0) goto L82
            android.view.ViewParent r0 = r7.getParent()
            if (r0 == 0) goto L82
            r0.requestDisallowInterceptTouchEvent(r1)
        L82:
            r7.handedOffVerticalToList = r1
            goto La6
        L85:
            float r0 = r8.getX()
            r7.downX = r0
            float r0 = r8.getY()
            r7.downY = r0
            com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView$GestureAxis r0 = com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView.GestureAxis.UNKNOWN
            r7.gestureAxis = r0
            r7.handedOffVerticalToList = r1
            boolean r0 = r7.b()
            if (r0 == 0) goto La6
            android.view.ViewParent r0 = r7.getParent()
            if (r0 == 0) goto La6
            r0.requestDisallowInterceptTouchEvent(r2)
        La6:
            boolean r7 = super.dispatchTouchEvent(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final int getMaxHeightPx() {
        return this.maxHeightPx;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (a(r8.getY() - r7.downY) == false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    @Override // android.widget.ScrollView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r8, r0)
            int r0 = r8.getActionMasked()
            r1 = 0
            if (r0 == 0) goto L58
            r2 = 1
            if (r0 == r2) goto L53
            r3 = 3
            r4 = 2
            if (r0 == r4) goto L16
            if (r0 == r3) goto L53
            goto L6f
        L16:
            boolean r0 = r7.b()
            if (r0 != 0) goto L1d
            return r1
        L1d:
            float r0 = r8.getX()
            float r5 = r7.downX
            float r0 = r0 - r5
            float r5 = r8.getY()
            float r6 = r7.downY
            float r5 = r5 - r6
            r7.d(r0, r5)
            com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView$GestureAxis r0 = r7.gestureAxis
            int[] r5 = com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView.b.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r5[r0]
            if (r0 == r2) goto L52
            if (r0 == r4) goto L45
            if (r0 != r3) goto L3f
            goto L6f
        L3f:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L45:
            float r0 = r8.getY()
            float r2 = r7.downY
            float r0 = r0 - r2
            boolean r0 = r7.a(r0)
            if (r0 != 0) goto L6f
        L52:
            return r1
        L53:
            com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView$GestureAxis r0 = com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView.GestureAxis.UNKNOWN
            r7.gestureAxis = r0
            goto L6f
        L58:
            float r0 = r8.getX()
            r7.downX = r0
            float r0 = r8.getY()
            r7.downY = r0
            com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView$GestureAxis r0 = com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView.GestureAxis.UNKNOWN
            r7.gestureAxis = r0
            boolean r0 = r7.b()
            if (r0 != 0) goto L6f
            return r1
        L6f:
            boolean r7 = super.onInterceptTouchEvent(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i10 = this.maxHeightPx;
        if (i10 <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE));
        }
    }

    public final void setMaxHeightPx(int i10) {
        if (this.maxHeightPx != i10) {
            this.maxHeightPx = i10;
            requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarkdownCodeScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.maxHeightPx = c(DEFAULT_MAX_HEIGHT_DP);
        this.gestureAxis = GestureAxis.UNKNOWN;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setVerticalScrollBarEnabled(true);
        setOverScrollMode(2);
        setNestedScrollingEnabled(false);
    }

    public /* synthetic */ AgentMarkdownCodeScrollView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
