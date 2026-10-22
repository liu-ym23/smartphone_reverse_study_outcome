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
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OInfoPanelSingleBtnActionView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OInfoPanelSingleBtnActionView extends LinearLayout implements com.obric.oui.infopanel.action.a {
    private final OButton showingBtn;

    /* JADX INFO: compiled from: OInfoPanelSingleBtnActionView.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35405a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f35406b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f35407c = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f35405a, f35406b};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f35407c.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f35405a = new a("PRIMARY", 0);
            f35406b = new a("SECONDARY", 1);
            f35407c = a();
        }
    }

    public OInfoPanelSingleBtnActionView(Context r7, a r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r8, "style");
        this(r1, r8, null, 4, null);
    }

    public /* synthetic */ OInfoPanelSingleBtnActionView(Context r2, a r3, AttributeSet r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r8 = null;
    L5:
        this(r7, r3, r8);
    }

    public OInfoPanelSingleBtnActionView(Context r4, a r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r5, "style");
        super(r7, r8);
        LinearLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_info_panel_action_single_btn, "layout", "o_info_panel_action_single_btn"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setOrientation(1);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        int r9 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
        int r10 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        setPadding(r9, r10, r9, r10);
        if (r5 != a.f35405a) goto L5;
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_primary, DbHelper.COL_ID, "btn_primary"));
        o.c(r11, "{\n            findViewBy…id.btn_primary)\n        }");
        OButton r12 = (OButton) ZeusTransformUtils.preCheckCast(r11, OButton.class, "com.obric.aiagent.plugin");
    L6:
        this.showingBtn = r12;
        k.a((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_secondary, DbHelper.COL_ID, "btn_secondary"));
        o.c(r13, "{\n            findViewBy….btn_secondary)\n        }");
        r12 = (OButton) ZeusTransformUtils.preCheckCast(r13, OButton.class, "com.obric.aiagent.plugin");
        goto L6
    }

    public final void setBtnText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "text");
        this.showingBtn.setText(r4);
    }

    public final void setBtnOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.showingBtn.setOnClickListener(r4);
    }

    @Override // com.obric.oui.infopanel.action.a
    public View getView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }
}
