package com.obric.oui.common.debug;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.oui.common.util.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: DebugFrameLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DebugFrameLayout extends FrameLayout {
    public static final a Companion = null;
    public static final String TAG = "DebugFrameLayout";

    /* JADX INFO: compiled from: DebugFrameLayout.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DebugFrameLayout(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ DebugFrameLayout(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public DebugFrameLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r0 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        int r1 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        int r2 = getMeasuredWidth();
        int r9 = getMeasuredHeight();
        String r3 = "UNKNOWN";
        if (r0 == Integer.MIN_VALUE) goto L9;
        if (r0 == 0) goto L8;
        if (r0 == 1073741824) goto L7;
        String r4 = "UNKNOWN";
    L10:
        if (r1 == Integer.MIN_VALUE) goto L16;
        if (r1 == 0) goto L15;
        if (r1 != 1073741824) goto L17;
        r3 = "EXACTLY";
    L17:
        e.f34568a.a("DebugFrameLayout onMeasure", "Width mode: " + r4 + ", width size: " + r12 + ", measured width: " + r2);
        e.f34568a.a("DebugFrameLayout onMeasure", "Height mode: " + r3 + ", height size: " + r13 + ", measured height: " + r9);
        return;
    L15:
        r3 = "UNSPECIFIED";
        goto L17
    L16:
        r3 = "AT_MOST";
        goto L17
    L7:
        r4 = "EXACTLY";
        goto L10
    L8:
        r4 = "UNSPECIFIED";
        goto L10
    L9:
        r4 = "AT_MOST";
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        super.onLayout(r4, r5, r6, r7, r8);
        int r3 = r7 - r5;
        e.f34568a.a("DebugFrameLayout onLayout", "Layout left: " + r5 + ", top: " + r6 + ", right: " + r7 + ", bottom: " + r8);
        e.f34568a.a("DebugFrameLayout onLayout", new StringBuilder().append("Layout width: ").append(r3).append(", height: ").append(r8 - r6).toString());
    }
}
