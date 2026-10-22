package com.obric.oui.popover.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: PopoverMenuLinearLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public class PopoverMenuLinearLayout extends LinearLayout {
    private boolean forceDark;
    private a indexPos;
    private m<? super Boolean, ? super Integer, x> notifyPressedCallback;
    private int pressedColor;
    private float pressedCornerRadius;
    private GradientDrawable stateBackground;

    /* JADX INFO: compiled from: PopoverMenuLinearLayout.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f36031a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f36032b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f36033c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f36034d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f36035e = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f36031a, f36032b, f36033c, f36034d};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f36035e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f36031a = new a("FIRST", 0);
            f36032b = new a("LAST", 1);
            f36033c = new a("OTHER", 2);
            f36034d = new a("ONLY_ONE", 3);
            f36035e = a();
        }
    }

    public PopoverMenuLinearLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public PopoverMenuLinearLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ PopoverMenuLinearLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public PopoverMenuLinearLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.pressedCornerRadius = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
        this.indexPos = a.f36033c;
        this.pressedColor = androidx.core.content.a.c(r6, ZeusTransformUtils.mapRes(R.color.oui_state_overlay_pressed, "color", "oui_state_overlay_pressed"));
    }

    public final float getPressedCornerRadius() {
        return this.pressedCornerRadius;
    }

    public final void setPressedCornerRadius(float r1) {
        this.pressedCornerRadius = r1;
    }

    public final a getIndexPos() {
        return this.indexPos;
    }

    public final void setIndexPos(a r2) {
        o.e(r2, "<set-?>");
        this.indexPos = r2;
    }

    public final m<Boolean, Integer, x> getNotifyPressedCallback() {
        return this.notifyPressedCallback;
    }

    public final void setNotifyPressedCallback(m<? super Boolean, ? super Integer, x> r3) {
        this.notifyPressedCallback = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
    }

    public final GradientDrawable getStateBackground() {
        return this.stateBackground;
    }

    public final void setStateBackground(GradientDrawable r1) {
        this.stateBackground = r1;
    }

    public final boolean getForceDark() {
        return this.forceDark;
    }

    public final void setForceDark(boolean r8) {
        GradientDrawable r0 = null;
        if (r8 == false) goto L8;
        this.pressedColor = Color.parseColor("#1affffff");
        Drawable r1 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_pop_list_item_dark, "drawable", "o_pop_list_item_dark"));
        if (ZeusTransformUtils.instanceOf(r1, GradientDrawable.class) == false) goto L7;
        r0 = (GradientDrawable) ZeusTransformUtils.preCheckCast(r1, GradientDrawable.class, "com.obric.aiagent.plugin");
    L7:
        this.stateBackground = r0;
    L12:
        GradientDrawable r2 = this.stateBackground;
        if (r2 == null) goto L16;
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r2, Drawable.class, "com.obric.aiagent.plugin"));
    L16:
        this.forceDark = r8;
        return;
    L8:
        this.pressedColor = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_state_overlay_pressed, "color", "oui_state_overlay_pressed"));
        Drawable r3 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_pop_list_item, "drawable", "o_pop_list_item"));
        if (ZeusTransformUtils.instanceOf(r3, GradientDrawable.class) == false) goto L11;
        r0 = (GradientDrawable) ZeusTransformUtils.preCheckCast(r3, GradientDrawable.class, "com.obric.aiagent.plugin");
    L11:
        this.stateBackground = r0;
        goto L12
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        m<? super Boolean, ? super Integer, x> r0 = this.notifyPressedCallback;
        if (r0 == null) goto L7;
        r0.invoke(Boolean.valueOf(r2), Integer.valueOf(this.pressedColor));
        return;
    }
}
