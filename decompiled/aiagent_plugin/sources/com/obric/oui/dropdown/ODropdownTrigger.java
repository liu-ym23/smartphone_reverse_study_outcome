package com.obric.oui.dropdown;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.e;
import com.obric.oui.common.util.g;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.p;
import d.h.b.r;
import d.h.b.s;
import d.m.h;
import d.x;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ODropdownTrigger.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ODropdownTrigger extends OUILinearLayout {
    static final /* synthetic */ h<Object>[] $$delegatedProperties = null;
    private final d.j.c active$delegate;
    private final int backgroundOff;
    private final int backgroundOn;
    private com.obric.oui.dropdown.b dropdown;
    private final ImageView icon;
    private final int iconOff;
    private final int iconOn;
    private WeakReference<Activity> reference;
    private final TextView value;

    /* JADX INFO: compiled from: ODropdownTrigger.kt */
    static final class a extends p implements d.h.a.b<CharSequence, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODropdownTrigger f35234a;

        a(ODropdownTrigger r1) {
            this.f35234a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(CharSequence r3) {
            a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            this.f35234a.getValue().setText(r4);
        }
    }

    /* JADX INFO: compiled from: Delegates.kt */
    public static final class b extends d.j.b<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODropdownTrigger f35235a;

        public b(Object r1, ODropdownTrigger r2) {
            this.f35235a = r2;
            super(r1);
        }

        @Override // d.j.b
        public void a(h<?> r3, Boolean r4, Boolean r5) {
            o.e((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin"), "property");
            boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == r6) goto L10;
            if (r6 == false) goto L7;
            this.f35235a.turnOn();
            return;
        L7:
            this.f35235a.turnOff();
            return;
        }
    }

    public ODropdownTrigger(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ODropdownTrigger(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$7UaMnwmxmHUjMtl6zO8LgfrPFm8(ODropdownTrigger r0, View r1) {
        m1059_init_$lambda1(r0, r1);
    }

    public /* synthetic */ ODropdownTrigger(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
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

    public ODropdownTrigger(Context r12, AttributeSet r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r15, "context");
        super(r15, r16, r14, null, 8, null);
        d.j.a r17 = d.j.a.f38510a;
        this.active$delegate = (d.j.c) ZeusTransformUtils.preCheckCast(new b(false, this), d.j.c.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Activity.class) == false) goto L5;
        setDropdownActivity((Activity) ZeusTransformUtils.preCheckCast(r15, Activity.class, "com.obric.aiagent.plugin"));
    L5:
        TypedArray r18 = r15.getTheme().obtainStyledAttributes(r16, R.styleable.ODropdownTrigger, 0, 0);
        o.c(r18, "context.theme.obtainStyl…           0, 0\n        )");
        this.backgroundOff = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_backgroundOff, "styleable", "ODropdownTrigger_oui_backgroundOff"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, "color", "oui_fill_element_2"), r15.getTheme()));
        this.backgroundOn = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_backgroundOn, "styleable", "ODropdownTrigger_oui_backgroundOn"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_active, "color", "oui_fill_active"), r15.getTheme()));
        this.iconOff = r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_iconOff, "styleable", "ODropdownTrigger_oui_iconOff"), ZeusTransformUtils.mapRes(R.drawable.dropdown_default_off, "drawable", "dropdown_default_off"));
        this.iconOn = r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_iconOn, "styleable", "ODropdownTrigger_oui_iconOn"), ZeusTransformUtils.mapRes(R.drawable.dropdown_default_on, "drawable", "dropdown_default_on"));
        TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(new OBaseTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r15, r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_textStyle, "styleable", "ODropdownTrigger_oui_textStyle"), ZeusTransformUtils.mapRes(R.style.ODropdownTriggerText, "style", "ODropdownTriggerText"))), Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null), TextView.class, "com.obric.aiagent.plugin");
        this.value = r0;
        addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(((OBaseTextView) ZeusTransformUtils.preCheckCast(r0, OBaseTextView.class, "com.obric.aiagent.plugin")).getLayoutParams());
        r3.weight = 1.0f;
        r3.rightMargin = r18.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_midMargin, "styleable", "ODropdownTrigger_oui_midMargin"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0));
        ((OBaseTextView) ZeusTransformUtils.preCheckCast(r0, OBaseTextView.class, "com.obric.aiagent.plugin")).setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        ImageView r19 = new ImageView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r15, r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_imageStyle, "styleable", "ODropdownTrigger_oui_imageStyle"), ZeusTransformUtils.mapRes(R.style.ODropdownTriggerIcon, "style", "ODropdownTriggerIcon"))), Context.class, "com.obric.aiagent.plugin"));
        this.icon = r19;
        addView((View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.aiagent.plugin"));
        turnOff();
        setOnClickListener(new $$Lambda$ODropdownTrigger$7UaMnwmxmHUjMtl6zO8LgfrPFm8(this));
    }

    public final TextView getValue() {
        return this.value;
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    static {
        $$delegatedProperties = new h[]{(h) ZeusTransformUtils.preCheckCast(aa.a((r) ZeusTransformUtils.preCheckCast(new s(ODropdownTrigger.class, "active", "getActive()Z", 0), r.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")};
    }

    public final boolean getActive() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.active$delegate.getValue(this, $$delegatedProperties[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public final void setActive(boolean r4) {
        this.active$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(r4));
    }

    public final Activity getDropdownActivity() {
        WeakReference<Activity> r2 = this.reference;
        if (r2 != null) goto L6;
        o.c("reference");
        r2 = null;
    L6:
        return (Activity) ZeusTransformUtils.preCheckCast(r2.get(), Activity.class, "com.obric.aiagent.plugin");
    }

    public final void setDropdownActivity(Activity r3) {
        this.reference = new WeakReference((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final void m1059_init_$lambda1(ODropdownTrigger r0, View r1) {
        o.e(r0, "this$0");
        r0.showPopup();
    }

    public static /* synthetic */ void init$default(ODropdownTrigger r2, com.obric.oui.dropdown.b r3, CharSequence r4, int r5, Object r6) {
        com.obric.oui.dropdown.b r7 = (com.obric.oui.dropdown.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dropdown.b.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r8 = null;
    L7:
        r2.init(r7, r8);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }

    public final void init(com.obric.oui.dropdown.b r3, CharSequence r4) {
        com.obric.oui.dropdown.b r5 = (com.obric.oui.dropdown.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dropdown.b.class, "com.obric.aiagent.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r5, "popup");
        this.dropdown = r5;
        this.value.setText(r6);
    }

    public void showPopup() {
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getDropdownActivity(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")) != null) goto L6;
        e.a(e.f34568a, "ODropdownTrigger", "no activity for popup showing", null, 4, null);
        return;
    L6:
        Activity r4 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getDropdownActivity(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L15;
        com.obric.oui.dropdown.b r2 = this.dropdown;
        if (r2 == null) goto L13;
        com.obric.oui.dropdown.b.a.a(r2, this, r4, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this), d.h.a.b.class, "com.obric.aiagent.plugin"), 4, null);
        x r0 = x.f38692a;
    L13:
        setActive(true);
        return;
    }

    public void turnOn() {
        this.icon.setImageResource(this.iconOn);
        setBackgroundColor(this.backgroundOn);
    }

    public void turnOff() {
        this.icon.setImageResource(this.iconOff);
        setBackgroundColor(this.backgroundOff);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
