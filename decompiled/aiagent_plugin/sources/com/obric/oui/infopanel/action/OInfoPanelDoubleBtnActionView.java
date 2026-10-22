package com.obric.oui.infopanel.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OInfoPanelDoubleBtnActionView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OInfoPanelDoubleBtnActionView extends LinearLayout implements com.obric.oui.infopanel.action.a {
    private final OButton leftBtn;
    private final OButton rightBtn;

    /* JADX INFO: compiled from: OInfoPanelDoubleBtnActionView.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35402a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f35403b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f35404c = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f35402a, f35403b};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f35404c.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f35402a = new a("PRIMARY_SECONDARY", 0);
            f35403b = new a("ONLY_SECONDARY", 1);
            f35404c = a();
        }
    }

    public OInfoPanelDoubleBtnActionView(Context r7, a r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r8, "style");
        this(r1, r8, null, 4, null);
    }

    public /* synthetic */ OInfoPanelDoubleBtnActionView(Context r2, a r3, AttributeSet r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r8 = null;
    L5:
        this(r7, r3, r8);
    }

    public OInfoPanelDoubleBtnActionView(Context r3, a r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, "style");
        super(r6, r7);
        if (r4 != a.f35402a) goto L5;
        int r8 = ZeusTransformUtils.mapRes(R.layout.o_info_panel_action_double_btn_primary_or_secondary, "layout", "o_info_panel_action_double_btn_primary_or_secondary");
    L6:
        LinearLayout.inflate(r6, r8, (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setOrientation(0);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        int r9 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
        int r10 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        setPadding(r9, r10, r9, r10);
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_secondary, DbHelper.COL_ID, "btn_secondary"));
        o.c(r11, "findViewById(R.id.btn_secondary)");
        this.leftBtn = (OButton) ZeusTransformUtils.preCheckCast(r11, OButton.class, "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_primary, DbHelper.COL_ID, "btn_primary"));
        o.c(r12, "findViewById(R.id.btn_primary)");
        this.rightBtn = (OButton) ZeusTransformUtils.preCheckCast(r12, OButton.class, "com.obric.aiagent.plugin");
        return;
    L5:
        r8 = ZeusTransformUtils.mapRes(R.layout.o_info_panel_action_double_btn, "layout", "o_info_panel_action_double_btn");
        goto L6
    }

    public final void configLeftBtn(CharSequence r3, View.OnClickListener r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r5, "text");
        o.e(r6, "listener");
        this.leftBtn.setText(r5);
        this.leftBtn.setOnClickListener(r6);
    }

    public final void configRightBtn(CharSequence r3, View.OnClickListener r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r5, "text");
        o.e(r6, "listener");
        this.rightBtn.setText(r5);
        this.rightBtn.setOnClickListener(r6);
    }

    @Override // com.obric.oui.infopanel.action.a
    public View getView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }
}
