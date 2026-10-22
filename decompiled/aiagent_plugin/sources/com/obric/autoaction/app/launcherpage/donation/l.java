package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.aw;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ad;
import d.h.b.o;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: RecordDataListHeaderAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.obric.autoaction.app.launcherpage.donation.model.c> f23775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23776d;

    /* JADX INFO: compiled from: RecordDataListHeaderAdapter.kt */
    public final class a extends RecyclerView.u {
        final /* synthetic */ l r;
        private final aw s;

        public a(l r2, View r3) {
            o.e(r3, "itemView");
            this.r = r2;
            super(r3);
            aw r4 = aw.a(r3);
            o.c(r4, "bind(...)");
            this.s = r4;
        }

        public final void E() {
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            OSectionTitleBar r3 = this.s.f22790b;
            int r4 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3");
            o.a(r1);
            r3.setTitleTextColor(p.b(r4, r1, null, 2, null));
            this.s.f22790b.setTitleTextSize(12.0f);
            OCardListItem r5 = this.s.f22789a;
            l r6 = this.r;
            r5.setTitleColor(p.b(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"), r1, null, 2, null), p.b(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"), r1, null, 2, null));
            r5.getTitleView().setTextAppearance(ZeusTransformUtils.mapRes(R.style.Body_1_Regular, "style", "Body_1_Regular"));
            r5.getSubTitleView().setTextAppearance(ZeusTransformUtils.mapRes(R.style.Subtitle_2_Regular, "style", "Subtitle_2_Regular"));
            p.a((View) ZeusTransformUtils.preCheckCast(r5.getSubTitleView(), View.class, "com.obric.aiagent.plugin"), 0, d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())), 0, 0, 13, null);
            float r7 = 10;
            r5.getCardContainer().setPadding(d.i.a.a(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())));
            r5.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r6.g(), CharSequence.class, "com.obric.aiagent.plugin"));
            int r8 = r6.h();
            if (r8 != m.a.f.f23791a.a()) goto L6;
            OTextView r9 = r5.getSubTitleView();
            r9.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1.getString(m.a.f.f23791a.b()), CharSequence.class, "com.obric.aiagent.plugin"));
            r9.setTextColor(r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
        L23:
            r5.showSubTitle(true);
            OUILinearLayout r0 = this.s.b();
            o.c(r0, "getRoot(...)");
            com.obric.oui.indicator.d.b((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
            return;
        L6:
            if (r8 != m.a.e.f23790a.a()) goto L9;
            OTextView r10 = r5.getSubTitleView();
            r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1.getString(m.a.e.f23790a.b()), CharSequence.class, "com.obric.aiagent.plugin"));
            r10.setTextColor(r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
            goto L23
        L9:
            if (r8 != m.a.d.f23789a.a()) goto L12;
            OTextView r11 = r5.getSubTitleView();
            r11.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1.getString(m.a.d.f23789a.b()), CharSequence.class, "com.obric.aiagent.plugin"));
            r11.setTextColor(r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_7, "color", "oui_functional_red_7")));
            goto L23
        L12:
            if (r8 != m.a.C0537a.f23786a.a()) goto L15;
            OTextView r12 = r5.getSubTitleView();
            r12.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1.getString(m.a.C0537a.f23786a.b()), CharSequence.class, "com.obric.aiagent.plugin"));
            r12.setTextColor(r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_b_blue_bg, "color", "oui_b_blue_bg")));
            r12.setVisibility(0);
            goto L23
        L15:
            if (r8 != m.a.c.f23788a.a()) goto L20;
            OTextView r13 = r5.getSubTitleView();
            r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1.getString(m.a.c.f23788a.b()), CharSequence.class, "com.obric.aiagent.plugin"));
            r13.setTextColor(r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
            String r14 = r6.j();
            if (r14 == null) goto L23;
            r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1.getString(ZeusTransformUtils.mapRes(R.string.donation_reject_reason_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "donation_reject_reason_format"), new Object[]{r14}), CharSequence.class, "com.obric.aiagent.plugin"));
            goto L23
        L20:
            if (r8 != m.a.b.f23787a.a()) goto L22;
            OTextView r15 = r5.getSubTitleView();
            r15.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1.getString(m.a.b.f23787a.b()), CharSequence.class, "com.obric.aiagent.plugin"));
            r15.setTextColor(r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
            goto L23
        L22:
            OTextView r2 = r5.getSubTitleView();
            ad r16 = ad.f38485a;
            String r17 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.data_donation_step_count, WsChannelMultiProcessSharedProvider.STRING_TYPE, "data_donation_step_count"));
            o.c(r17, "getString(...)");
            String r18 = String.format(r17, Arrays.copyOf(new Object[]{Integer.valueOf(r6.i().size())}, 1));
            o.c(r18, "format(...)");
            r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"));
            goto L23
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return (RecyclerView.u) ZeusTransformUtils.preCheckCast(c(r1, r2), RecyclerView.u.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
    }

    public final String g() {
        return this.f23773a;
    }

    public final int h() {
        return this.f23774b;
    }

    public final List<com.obric.autoaction.app.launcherpage.donation.model.c> i() {
        return this.f23775c;
    }

    public final String j() {
        return this.f23776d;
    }

    public l(String r3, int r4, List<com.obric.autoaction.app.launcherpage.donation.model.c> r5, String r6) {
        List<com.obric.autoaction.app.launcherpage.donation.model.c> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "operations");
        this.f23773a = r3;
        this.f23774b = r4;
        this.f23775c = r7;
        this.f23776d = r6;
    }

    public a c(ViewGroup r3, int r4) {
        o.e(r3, "parent");
        aw r5 = aw.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r3, false);
        o.c(r5, "inflate(...)");
        OUILinearLayout r6 = r5.b();
        o.c(r6, "getRoot(...)");
        return new a(this, (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
    }

    public void a(a r1, int r2) {
        o.e(r1, "holder");
        r1.E();
    }
}
