package com.obric.oui.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.d.c;
import com.obric.oui.divider.ODivider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OBottomActionBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OBottomActionBar extends FrameLayout {
    private final String TAG;
    private List<OButton> actionButtons;
    private View contentView;
    private final ODivider dividerView;
    private b onClickListener;
    private final LinearLayout rootView;

    /* JADX INFO: compiled from: OBottomActionBar.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f33931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f33932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f33933c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<String> f33934d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<Integer> f33935e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f33931a == r6.f33931a) goto L12;
            return false;
        L12:
            if (this.f33932b == r6.f33932b) goto L15;
            return false;
        L15:
            if (o.a(this.f33933c, r6.f33933c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f33934d, r6.f33934d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f33935e, r6.f33935e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        public int hashCode() {
            boolean r0 = this.f33931a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f33932b;
            if (r4 == true) goto L9;
            r1 = r4;
        L9:
            int r5 = (((r3 + r1) * 31) + this.f33933c.hashCode()) * 31;
            List<String> r6 = this.f33934d;
            int r7 = 0;
            if (r6 != null) goto L12;
            int r8 = 0;
        L13:
            int r9 = (r5 + r8) * 31;
            List<Integer> r10 = this.f33935e;
            if (r10 == null) goto L18;
            r7 = r10.hashCode();
        L18:
            return r9 + r7;
        L12:
            r8 = r6.hashCode();
            goto L13
        }

        public String toString() {
            return "OBABConfig(hasDivider=" + this.f33931a + ", lastPrimary=" + this.f33932b + ", buttonStyle=" + this.f33933c + ", buttonTexts=" + this.f33934d + ", buttonImgIds=" + this.f33935e + ')';
        }

        public a(boolean r3, boolean r4, String r5, List<String> r6, List<Integer> r7) {
            List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            List<Integer> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            o.e(r5, "buttonStyle");
            this.f33931a = r3;
            this.f33932b = r4;
            this.f33933c = r5;
            this.f33934d = r8;
            this.f33935e = r9;
        }

        public final boolean a() {
            return this.f33931a;
        }

        public final boolean b() {
            return this.f33932b;
        }

        public final String c() {
            return this.f33933c;
        }

        public final List<String> d() {
            return this.f33934d;
        }

        public final List<Integer> e() {
            return this.f33935e;
        }
    }

    /* JADX INFO: compiled from: OBottomActionBar.kt */
    public interface b {
        void a(View r1, int r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomActionBar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ void lambda$AVt0uajSpV2z2hEdH8NbIdtXcec(OBottomActionBar r0, int r1, View r2) {
        m966initNormalButton$lambda1(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$d8lQHxT26kpIR7xpDnys7ydIoHE(OBottomActionBar r0, int r1, View r2) {
        m965initImgButton$lambda2(r0, r1, r2);
    }

    public /* synthetic */ OBottomActionBar(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OBottomActionBar(Context r11, AttributeSet r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        super(r13, r14);
        this.TAG = "OBottomActionBar";
        FrameLayout.inflate(r13, ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar, "layout", "o_widget_bottom_action_bar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setBackgroundColor(androidx.core.content.a.c(r13, ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent")));
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.root_layout, DbHelper.COL_ID, "root_layout"));
        o.c(r0, "findViewById(R.id.root_layout)");
        this.rootView = (LinearLayout) ZeusTransformUtils.preCheckCast(r0, LinearLayout.class, "com.obric.aiagent.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.top_divider, DbHelper.COL_ID, "top_divider"));
        o.c(r1, "findViewById(R.id.top_divider)");
        this.dividerView = (ODivider) ZeusTransformUtils.preCheckCast(r1, ODivider.class, "com.obric.aiagent.plugin");
        TypedArray r15 = r13.getTheme().obtainStyledAttributes(r14, R.styleable.OBottomActionBar, 0, 0);
        boolean r5 = r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_hasDivider, "styleable", "OBottomActionBar_oui_hasDivider"), true);
        boolean r6 = r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_buttonLastPrimary, "styleable", "OBottomActionBar_oui_buttonLastPrimary"), false);
        String r16 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_buttonStyle, "styleable", "OBottomActionBar_oui_buttonStyle"));
        int r3 = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_buttonTexts, "styleable", "OBottomActionBar_oui_buttonTexts"), 0);
        int r2 = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_buttonImgIds, "styleable", "OBottomActionBar_oui_buttonImgIds"), 0);
        if (r3 != 0) goto L5;
        List r8 = null;
    L6:
        if (r2 != 0) goto L8;
        List r9 = null;
    L12:
        if (r16 != null) goto L14;
        r16 = "l1";
    L14:
        a r17 = new a(r5, r6, r16, r8, r9);
        r15.recycle();
        initButtons(r17);
        return;
    L8:
        TypedArray r4 = ZeusTransformUtils.getResources(r15, "com.obric.aiagent.plugin").obtainTypedArray(r2);
        o.c(r4, "resources.obtainTypedArray(buttonImg)");
        ArrayList r7 = new ArrayList();
        int r10 = r4.length();
        int r18 = 0;
    L9:
        if (r18 >= r10) goto L11;
        r7.add(Integer.valueOf(r4.getResourceId(r18, 0)));
        r18 = r18 + 1;
        goto L9
    L11:
        List r19 = p.g((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin"));
        r4.recycle();
        r9 = r19;
        goto L12
    L5:
        String[] r20 = ZeusTransformUtils.getResources(r15, "com.obric.aiagent.plugin").getStringArray(r3);
        o.c(r20, "resources.getStringArray(buttonResourceId)");
        r8 = i.h(r20);
        goto L6
    }

    private final void initButtons(a r20) {
        String r2 = r20.c();
        int r3 = r2.hashCode();
        if (r3 != (-1612256902)) goto L5;
        Object r17 = "img";
        if (r2.equals("l1-primary") == false) goto L40;
        this.contentView = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_l1_primary, "layout", "o_widget_bottom_action_bar_l1_primary"), null);
        this.rootView.addView(this.contentView, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_L1_primary, DbHelper.COL_ID, "action_button_L1_primary"));
        o.c(r4, "findViewById(R.id.action_button_L1_primary)");
        this.actionButtons = p.c(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r4, OButton.class, "com.obric.aiagent.plugin")});
    L40:
        if (r20.c().compareTo(r17) != 0) goto L42;
        initImgButton(this.actionButtons, r20);
    L44:
        if (r20.a() == false) goto L46;
        this.dividerView.setVisibility(0);
        return;
    L46:
        this.dividerView.setVisibility(8);
        return;
    L42:
        initNormalButton(this.actionButtons, r20);
        goto L44
    L5:
        if (r3 == 3397) goto L31;
        r17 = "img";
        if (r3 == 104387) goto L28;
        if (r3 == 678742426) goto L24;
        if (r3 == 3428) goto L20;
        if (r3 != 3429) goto L40;
        if (r2.equals("m2") == false) goto L40;
        this.contentView = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_m2, "layout", "o_widget_bottom_action_bar_m2"), null);
        this.rootView.addView(this.contentView, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_m20, DbHelper.COL_ID, "action_button_m20"));
        o.c(r5, "findViewById(R.id.action_button_m20)");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_m21, DbHelper.COL_ID, "action_button_m21"));
        o.c(r6, "findViewById(R.id.action_button_m21)");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_m22, DbHelper.COL_ID, "action_button_m22"));
        o.c(r7, "findViewById(R.id.action_button_m22)");
        this.actionButtons = p.c(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r5, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r6, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r7, OButton.class, "com.obric.aiagent.plugin")});
        goto L40
    L20:
        if (r2.equals("m1") == false) goto L40;
        this.contentView = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_m1, "layout", "o_widget_bottom_action_bar_m1"), null);
        this.rootView.addView(this.contentView, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_0, DbHelper.COL_ID, "action_button_0"));
        o.c(r8, "findViewById(R.id.action_button_0)");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_1, DbHelper.COL_ID, "action_button_1"));
        o.c(r1, "findViewById(R.id.action_button_1)");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_2, DbHelper.COL_ID, "action_button_2"));
        o.c(r9, "findViewById(R.id.action_button_2)");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_3, DbHelper.COL_ID, "action_button_3"));
        o.c(r10, "findViewById(R.id.action_button_3)");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_4, DbHelper.COL_ID, "action_button_4"));
        o.c(r11, "findViewById(R.id.action_button_4)");
        this.actionButtons = p.c(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r1, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r10, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r11, OButton.class, "com.obric.aiagent.plugin")});
        goto L40
    L24:
        if (r2.equals("m2-primary") == false) goto L40;
        this.contentView = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_m2_primary, "layout", "o_widget_bottom_action_bar_m2_primary"), null);
        this.rootView.addView(this.contentView, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_m2_primary0, DbHelper.COL_ID, "action_button_m2_primary0"));
        o.c(r12, "findViewById(R.id.action_button_m2_primary0)");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_m2_primary1, DbHelper.COL_ID, "action_button_m2_primary1"));
        o.c(r13, "findViewById(R.id.action_button_m2_primary1)");
        this.actionButtons = p.c(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r12, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r13, OButton.class, "com.obric.aiagent.plugin")});
        goto L40
    L28:
        if (r2.equals(r17) == true) goto L30;
        r17 = r17;
        goto L40
    L30:
        r17 = r17;
        this.contentView = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_img, "layout", "o_widget_bottom_action_bar_img"), null);
        this.rootView.addView(this.contentView, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_0, DbHelper.COL_ID, "action_button_0"));
        o.c(r14, "findViewById(R.id.action_button_0)");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_1, DbHelper.COL_ID, "action_button_1"));
        o.c(r15, "findViewById(R.id.action_button_1)");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_2, DbHelper.COL_ID, "action_button_2"));
        o.c(r16, "findViewById(R.id.action_button_2)");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_3, DbHelper.COL_ID, "action_button_3"));
        o.c(r18, "findViewById(R.id.action_button_3)");
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_4, DbHelper.COL_ID, "action_button_4"));
        o.c(r19, "findViewById(R.id.action_button_4)");
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_5, DbHelper.COL_ID, "action_button_5"));
        o.c(r21, "findViewById(R.id.action_button_5)");
        this.actionButtons = p.c(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r14, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r15, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r16, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r18, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r19, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r21, OButton.class, "com.obric.aiagent.plugin")});
        goto L40
    L31:
        r17 = "img";
        if (r2.equals("l1") == false) goto L40;
        this.contentView = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_l1, "layout", "o_widget_bottom_action_bar_l1"), null);
        this.rootView.addView(this.contentView, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_L10, DbHelper.COL_ID, "action_button_L10"));
        o.c(r22, "findViewById(R.id.action_button_L10)");
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_L11, DbHelper.COL_ID, "action_button_L11"));
        o.c(r23, "findViewById(R.id.action_button_L11)");
        this.actionButtons = p.c(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r22, OButton.class, "com.obric.aiagent.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r23, OButton.class, "com.obric.aiagent.plugin")});
        goto L40
    }

    private final void initNormalButton(List<OButton> r10, a r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L5;
        return;
    L5:
        final int r3 = 0;
        if (r11.d() == null) goto L13;
        int r0 = Math.min(r11.d().size(), r12.size());
        if (r11.d().size() <= r12.size()) goto L10;
        INVOKESTATIC_com_obric_oui_actionbar_OBottomActionBar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.TAG, o.a("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r12.size())));
    L10:
        int r4 = r0 - 1;
        int r5 = 0;
    L11:
        if (r5 >= r0) goto L14;
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r5), OButton.class, "com.obric.aiagent.plugin")).setVisibility(0);
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r5), OButton.class, "com.obric.aiagent.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(r11.d().get(r5), CharSequence.class, "com.obric.aiagent.plugin"));
        r5 = r5 + 1;
    L14:
        if (r4 != (-1)) goto L17;
        r4 = r12.size() - 1;
    L17:
        if (r11.b() == false) goto L27;
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r4), OButton.class, "com.obric.aiagent.plugin")).setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_accent_bg_high_contrast, "color", "oui_accent_bg_high_contrast")));
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r4), OButton.class, "com.obric.aiagent.plugin")).setTextColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_on_accent_default, "color", "oui_on_accent_default")));
        c r13 = c.f35012a;
        Object r14 = r12.get(r4);
        if (r14 != null) goto L22;
    L20:
        r14 = null;
    L23:
        com.obric.oui.common.style.a r15 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r14, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L27;
        r15.refreshColors(this.TAG);
        goto L27
    L22:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.oui.common.style.a.class) == false) goto L20;
    L27:
        if (r4 < 0) goto L32;
    L28:
        int r16 = r3 + 1;
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r3), OButton.class, "com.obric.aiagent.plugin")).setOnClickListener(new $$Lambda$OBottomActionBar$AVt0uajSpV2z2hEdH8NbIdtXcec(this, r3));
        if (r3 == r4) goto L35;
        r3 = r16;
        goto L28
    L35:
        return;
    L32:
        return;
    L13:
        r4 = -1;
        goto L14
    }

    /* JADX INFO: renamed from: initNormalButton$lambda-1, reason: not valid java name */
    private static final void m966initNormalButton$lambda1(OBottomActionBar r1, int r2, View r3) {
        o.e(r1, "this$0");
        o.c(r3, "it");
        r1.performButtonClick(r3, r2);
    }

    private final void initImgButton(List<OButton> r10, a r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L5;
        return;
    L5:
        final int r3 = 0;
        if (r11.e() == null) goto L13;
        int r0 = Math.min(r11.e().size(), r12.size());
        if (r11.e().size() <= r12.size()) goto L10;
        INVOKESTATIC_com_obric_oui_actionbar_OBottomActionBar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.TAG, o.a("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r12.size())));
    L10:
        int r4 = r0 - 1;
        int r5 = 0;
    L11:
        if (r5 >= r0) goto L14;
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r5), OButton.class, "com.obric.aiagent.plugin")).setVisibility(0);
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r5), OButton.class, "com.obric.aiagent.plugin")).setButtonSourceBitmap(((Number) ZeusTransformUtils.preCheckCast(r11.e().get(r5), Number.class, "com.obric.aiagent.plugin")).intValue());
        r5 = r5 + 1;
    L14:
        if (r4 != (-1)) goto L16;
        r4 = r12.size() - 1;
    L16:
        if (r4 < 0) goto L21;
    L17:
        int r13 = r3 + 1;
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r3), OButton.class, "com.obric.aiagent.plugin")).setOnClickListener(new $$Lambda$OBottomActionBar$d8lQHxT26kpIR7xpDnys7ydIoHE(this, r3));
        if (r3 == r4) goto L24;
        r3 = r13;
        goto L17
    L24:
        return;
    L21:
        return;
    L13:
        r4 = -1;
        goto L14
    }

    /* JADX INFO: renamed from: initImgButton$lambda-2, reason: not valid java name */
    private static final void m965initImgButton$lambda2(OBottomActionBar r1, int r2, View r3) {
        o.e(r1, "this$0");
        o.c(r3, "it");
        r1.performButtonClick(r3, r2);
    }

    private final void performButtonClick(View r1, int r2) {
        b r0 = this.onClickListener;
        if (r0 == null) goto L7;
        r0.a(r1, r2);
        return;
    }

    public final void setBottomButtonClickListener(b r3) {
        this.onClickListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    public final void updateStyle(boolean r8, String r9, boolean r10, String[] r11, Integer[] r12) {
        o.e(r9, "buttonStyle");
        resetLayoutStatus();
        if (r11 != null) goto L5;
        List r5 = null;
    L6:
        if (r12 != null) goto L8;
        List r6 = null;
    L9:
        initButtons(new a(r8, r10, r9, r5, r6));
        return;
    L8:
        r6 = i.h(r12);
        goto L9
    L5:
        r5 = i.h(r11);
        goto L6
    }

    public final OButton getButton(int r4) {
        List<OButton> r0 = this.actionButtons;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0 != null) goto L7;
        int r1 = 0;
    L9:
        if (r4 >= r1) goto L15;
        List<OButton> r3 = this.actionButtons;
        if (r3 != null) goto L16;
        return null;
    L16:
        return (OButton) ZeusTransformUtils.preCheckCast(r3.get(r4), OButton.class, "com.obric.aiagent.plugin");
    L15:
        return (OButton) ZeusTransformUtils.preCheckCast(null, OButton.class, "com.obric.aiagent.plugin");
    L7:
        r1 = r0.size();
        goto L9
    }

    private final void resetLayoutStatus() {
        View r0 = this.contentView;
        if (r0 == null) goto L6;
        this.rootView.removeView(r0);
        this.contentView = null;
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_actionbar_OBottomActionBar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
