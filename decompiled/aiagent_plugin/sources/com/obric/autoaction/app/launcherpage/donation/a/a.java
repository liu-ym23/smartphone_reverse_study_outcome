package com.obric.autoaction.app.launcherpage.donation.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: DonationHeaderAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends RecyclerView.a<C0531a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f23723a;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DonationHeaderAdapter.kt */
    public static final class C0531a extends RecyclerView.u {
        private final View r;

        public C0531a(View r4) {
            o.e(r4, "itemView");
            super(r4);
            View r5 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.desc, DbHelper.COL_ID, "desc"));
            o.c(r5, "findViewById(...)");
            this.r = r5;
        }

        public final void E() {
            this.r.setVisibility(0);
            OTextView r0 = (OTextView) ZeusTransformUtils.preCheckCast(this.f2390a.findViewById(ZeusTransformUtils.mapRes(R.id.sub_title, DbHelper.COL_ID, "sub_title")), OTextView.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L5;
            r0.setVisibility(0);
        L5:
            OTextView r1 = (OTextView) ZeusTransformUtils.preCheckCast(this.r.findViewById(ZeusTransformUtils.mapRes(R.id.tv_desc, DbHelper.COL_ID, "tv_desc")), OTextView.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L8;
            int r2 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1");
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r5, "getContext(...)");
            r1.setTextColor(p.b(r2, r5, null, 2, null));
            r1.setTextSize(1, 14.0f);
        L8:
            ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(this.r.findViewById(ZeusTransformUtils.mapRes(R.id.iv_multi_icon, DbHelper.COL_ID, "iv_multi_icon")), ImageView.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L12;
            View r9 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
            ViewGroup.LayoutParams r3 = r9.getLayoutParams();
            Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            float r4 = 24;
            r3.height = d.i.a.a(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics()));
            r3.width = d.i.a.a(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics()));
            r9.setLayoutParams(r3);
            return;
        }
    }

    public a() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return (RecyclerView.u) ZeusTransformUtils.preCheckCast(c(r1, r2), RecyclerView.u.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((C0531a) ZeusTransformUtils.preCheckCast(r3, C0531a.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void b(boolean r2) {
        if (this.f23723a != r2) goto L5;
        return;
    L5:
        this.f23723a = r2;
        d();
    }

    public C0531a c(ViewGroup r4, int r5) {
        o.e(r4, "parent");
        View r3 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.data_donation_header, "layout", "data_donation_header"), r4, false, "com.obric.aiagent.plugin");
        o.a(r3);
        return new C0531a(r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f23723a ? 1 : 0;
    }

    public void a(C0531a r1, int r2) {
        o.e(r1, "holder");
        r1.E();
    }
}
