package com.obric.oui.popover;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: FakeAnchorView.kt */
/* JADX INFO: loaded from: classes4.dex */
public class FakeAnchorView extends FrameLayout {
    public static final a Companion = null;
    private static final String TAG = "FakeAnchorView";

    /* JADX INFO: compiled from: FakeAnchorView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final View a(Activity r10, int r11, int r12, int r13, int r14) {
            Activity r15 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.aiagent.plugin");
            o.e(r15, "activity");
            ViewGroup r6 = com.obric.oui.d.h.f35017a.a(r15);
            if (r6 == null) goto L7;
            return (View) ZeusTransformUtils.preCheckCast(a((Context) ZeusTransformUtils.preCheckCast(r15, Context.class, "com.obric.aiagent.plugin"), r13, r14, r6, r11, r12), View.class, "com.obric.aiagent.plugin");
        L7:
            throw new Exception("rootView is null");
        }

        public final View a(Dialog r9, int r10, int r11, int r12, int r13) {
            o.e(r9, "dialog");
            ViewGroup r5 = com.obric.oui.d.h.f35017a.a(r9);
            if (r5 == null) goto L7;
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r2, "dialog.context");
            return (View) ZeusTransformUtils.preCheckCast(a(r2, r12, r13, r5, r10, r11), View.class, "com.obric.aiagent.plugin");
        L7:
            throw new Exception("rootView is null");
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final FakeAnchorView a(Context r6, int r7, int r8, ViewGroup r9, int r10, int r11) {
            FakeAnchorView r12 = new FakeAnchorView((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), null, 2, 0 == true ? 1 : 0);
            r12.setBackgroundColor(0);
            r12.setAlpha(0.0f);
            r9.addView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(r7, r8), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            int[] r0 = new int[2];
            r9.getLocationOnScreen(r0);
            int r13 = r10 - r0[0];
            int r14 = r11 - r0[1];
            r12.setX(r13);
            r12.setY(r14);
            r12.measure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), View.MeasureSpec.makeMeasureSpec(r8, 1073741824));
            r12.layout(0, 0, r7, r8);
            com.obric.oui.d.a.b.b(FakeAnchorView.TAG, "w: " + r12.getMeasuredWidth() + ", h: " + r12.getMeasuredHeight());
            return r12;
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FakeAnchorView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ FakeAnchorView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public FakeAnchorView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
    }
}
