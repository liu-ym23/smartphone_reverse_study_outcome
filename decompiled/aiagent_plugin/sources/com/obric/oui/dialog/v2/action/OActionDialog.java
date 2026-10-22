package com.obric.oui.dialog.v2.action;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import java.util.Objects;

/* JADX INFO: compiled from: OActionDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OActionDialog extends OBaseDialog {
    public static final a Companion = null;
    private static final String TAG = "OActionDialog";
    private final f bodyContainerView$delegate;
    private final b modifier;
    private final f subtitleTextView$delegate;
    private final f titleTextView$delegate;

    /* JADX INFO: compiled from: OActionDialog.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OActionDialog.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f35108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f35109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.h.a.b<ViewGroup, View> f35110c;

        public final CharSequence a() {
            return this.f35108a;
        }

        public final CharSequence b() {
            return this.f35109b;
        }

        public final d.h.a.b<ViewGroup, View> c() {
            return this.f35110c;
        }
    }

    /* JADX INFO: compiled from: OActionDialog.kt */
    static final class c extends p implements d.h.a.a<ViewGroup> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OActionDialog f35111a;

        c(OActionDialog r1) {
            this.f35111a = r1;
            super(0);
        }

        public final ViewGroup a() {
            return (ViewGroup) ZeusTransformUtils.preCheckCast(this.f35111a.findViewById(ZeusTransformUtils.mapRes(R.id.action_dialog_body_container, DbHelper.COL_ID, "action_dialog_body_container")), ViewGroup.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ ViewGroup invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OActionDialog.kt */
    static final class d extends p implements d.h.a.a<OTextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OActionDialog f35112a;

        d(OActionDialog r1) {
            this.f35112a = r1;
            super(0);
        }

        public final OTextView a() {
            return (OTextView) ZeusTransformUtils.preCheckCast(this.f35112a.findViewById(ZeusTransformUtils.mapRes(R.id.action_dialog_sub_title, DbHelper.COL_ID, "action_dialog_sub_title")), OTextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OTextView invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OActionDialog.kt */
    static final class e extends p implements d.h.a.a<OTextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OActionDialog f35113a;

        e(OActionDialog r1) {
            this.f35113a = r1;
            super(0);
        }

        public final OTextView a() {
            return (OTextView) ZeusTransformUtils.preCheckCast(this.f35113a.findViewById(ZeusTransformUtils.mapRes(R.id.action_dialog_title, DbHelper.COL_ID, "action_dialog_title")), OTextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OTextView invoke() {
            return a();
        }
    }

    static {
        Companion = new a(null);
    }

    public OActionDialog(Context r3, b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "modifier");
        super(r5);
        this.modifier = r4;
        this.titleTextView$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.subtitleTextView$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.bodyContainerView$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        getTitleTextView().setIncludeFontPadding(true);
        getSubtitleTextView().setIncludeFontPadding(true);
        setTitleText(r4.a());
        setSubtitleText(r4.b());
        initBody();
        setAutoDismiss(true);
    }

    public final b getModifier() {
        return this.modifier;
    }

    public final OTextView getTitleTextView() {
        Object r2 = this.titleTextView$delegate.b();
        o.c(r2, "<get-titleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin");
    }

    public final OTextView getSubtitleTextView() {
        Object r2 = this.subtitleTextView$delegate.b();
        o.c(r2, "<get-subtitleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin");
    }

    private final ViewGroup getBodyContainerView() {
        Object r2 = this.bodyContainerView$delegate.b();
        o.c(r2, "<get-bodyContainerView>(...)");
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int getLayout() {
        return ZeusTransformUtils.mapRes(R.layout.o_action_dialog, "layout", "o_action_dialog");
    }

    public final void setTitleText(CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r7, DBDefinition.TITLE);
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        getTitleTextView().setVisibility(8);
        ViewGroup.LayoutParams r5 = getSubtitleTextView().getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).topMargin = 0;
        return;
    L9:
        OTextView r1 = getTitleTextView();
        r1.setVisibility(0);
        r1.setText(r7);
        OTextView r8 = getSubtitleTextView();
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).topMargin = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 8);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void setSubtitleText(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r5, "message");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        getSubtitleTextView().setVisibility(8);
        return;
    L8:
        OTextView r3 = getSubtitleTextView();
        r3.setVisibility(0);
        r3.setText(r5);
        com.obric.oui.dialog.b.a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setContainerView(View r2) {
        o.e(r2, "view");
        getBodyContainerView().removeAllViews();
        getBodyContainerView().addView(r2);
    }

    private final void initBody() {
        if (this.modifier.c() == null) goto L6;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.modifier.c().invoke(getBodyContainerView()), View.class, "com.obric.aiagent.plugin");
        getBodyContainerView().removeAllViews();
        getBodyContainerView().addView(r0);
        return;
    }
}
