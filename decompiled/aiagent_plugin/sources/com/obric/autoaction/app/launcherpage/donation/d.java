package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.an;
import com.obric.autoaction.app.launcherpage.a.ar;
import com.obric.autoaction.app.launcherpage.donation.model.Question;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: DonationTaskRecordAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends q<com.obric.autoaction.app.launcherpage.donation.e.a, a<? extends com.obric.autoaction.app.launcherpage.donation.e.a>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f23732b = null;

    /* JADX INFO: compiled from: DonationTaskRecordAdapter.kt */
    public static class a<T extends com.obric.autoaction.app.launcherpage.donation.e.a> extends RecyclerView.u {
        public void a(T r1) {
            o.e(r1, "cell");
        }

        public a(View r2) {
            o.e(r2, "itemView");
            super(r2);
        }
    }

    /* JADX INFO: compiled from: DonationTaskRecordAdapter.kt */
    public static final class b {

        /* JADX INFO: compiled from: DonationTaskRecordAdapter.kt */
        public static abstract class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f23733a;

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.d$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: DonationTaskRecordAdapter.kt */
            public static final class C0533a extends a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0533a f23734a = null;

                static {
                    f23734a = new C0533a();
                }

                private C0533a() {
                    super(0, null);
                }
            }

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.d$b$a$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: DonationTaskRecordAdapter.kt */
            public static final class C0534b extends a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0534b f23735a = null;

                static {
                    f23735a = new C0534b();
                }

                private C0534b() {
                    super(1, null);
                }
            }

            public /* synthetic */ a(int r1, d.h.b.h r2) {
                this(r1);
            }

            private a(int r1) {
                this.f23733a = r1;
            }

            public final int getType() {
                return this.f23733a;
            }
        }

        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: DonationTaskRecordAdapter.kt */
    public static final class c extends a<com.obric.autoaction.app.launcherpage.donation.e.b> {
        private final an r;

        @Override // com.obric.autoaction.app.launcherpage.donation.d.a
        public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.donation.e.a r3) {
            a((com.obric.autoaction.app.launcherpage.donation.e.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.donation.e.b.class, "com.obric.aiagent.plugin"));
        }

        public c(ViewGroup r4) {
            o.e(r4, "parent");
            OTextView r5 = an.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false).b();
            o.c(r5, "getRoot(...)");
            super((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
            an r6 = an.a(this.f2390a);
            o.c(r6, "bind(...)");
            this.r = r6;
        }

        public void a(com.obric.autoaction.app.launcherpage.donation.e.b r5) {
            o.e(r5, "cell");
            OTextView r4 = this.r.f22757a;
            r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.aiagent.plugin"));
            o.a(r4);
            View r6 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
            ViewGroup.LayoutParams r0 = r6.getLayoutParams();
            Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            r0.height = d.i.a.a(TypedValue.applyDimension(1, 28, Resources.getSystem().getDisplayMetrics()));
            r4.setGravity(16);
            r6.setLayoutParams(r0);
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DonationTaskRecordAdapter.kt */
    public static final class C0535d extends androidx.recyclerview.widget.j.e<com.obric.autoaction.app.launcherpage.donation.e.a> {
        public C0535d() {
        }

        @Override // androidx.recyclerview.widget.j.e
        public /* synthetic */ boolean a(com.obric.autoaction.app.launcherpage.donation.e.a r3, com.obric.autoaction.app.launcherpage.donation.e.a r4) {
            return a2((com.obric.autoaction.app.launcherpage.donation.e.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.donation.e.a.class, "com.obric.aiagent.plugin"), (com.obric.autoaction.app.launcherpage.donation.e.a) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.donation.e.a.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.recyclerview.widget.j.e
        public /* synthetic */ boolean b(com.obric.autoaction.app.launcherpage.donation.e.a r3, com.obric.autoaction.app.launcherpage.donation.e.a r4) {
            return b2((com.obric.autoaction.app.launcherpage.donation.e.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.donation.e.a.class, "com.obric.aiagent.plugin"), (com.obric.autoaction.app.launcherpage.donation.e.a) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.donation.e.a.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(com.obric.autoaction.app.launcherpage.donation.e.a r1, com.obric.autoaction.app.launcherpage.donation.e.a r2) {
            o.e(r1, "oldItem");
            o.e(r2, "newItem");
            return o.a(r1, r2);
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(com.obric.autoaction.app.launcherpage.donation.e.a r3, com.obric.autoaction.app.launcherpage.donation.e.a r4) {
            o.e(r3, "oldItem");
            o.e(r4, "newItem");
            if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.app.launcherpage.donation.e.b.class) == false) goto L9;
            if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.donation.e.b.class) == false) goto L9;
            if (o.a(((com.obric.autoaction.app.launcherpage.donation.e.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.donation.e.b.class, "com.obric.aiagent.plugin")).a(), ((com.obric.autoaction.app.launcherpage.donation.e.b) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.donation.e.b.class, "com.obric.aiagent.plugin")).a()) == false) goto L9;
        L14:
            return true;
        L9:
            if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.app.launcherpage.donation.e.c.class) == true) goto L11;
        L15:
            return false;
        L11:
            if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.donation.e.c.class) == false) goto L15;
            if (o.a(((com.obric.autoaction.app.launcherpage.donation.e.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.donation.e.c.class, "com.obric.aiagent.plugin")).a(), ((com.obric.autoaction.app.launcherpage.donation.e.c) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.donation.e.c.class, "com.obric.aiagent.plugin")).a()) == false) goto L15;
            goto L14
        }
    }

    /* JADX INFO: compiled from: DonationTaskRecordAdapter.kt */
    public static final class e extends a<com.obric.autoaction.app.launcherpage.donation.e.c> {
        private final ar r;

        public static /* synthetic */ void lambda$Hv7UkSf9H_ufxEFrl1QMOyeHoNQ(e r0, com.obric.autoaction.app.launcherpage.donation.e.c r1, View r2) {
            a(r0, r1, r2);
        }

        @Override // com.obric.autoaction.app.launcherpage.donation.d.a
        public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.donation.e.a r3) {
            a((com.obric.autoaction.app.launcherpage.donation.e.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.donation.e.c.class, "com.obric.aiagent.plugin"));
        }

        public e(ViewGroup r4) {
            o.e(r4, "parent");
            OCardListItem r5 = ar.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false).b();
            o.c(r5, "getRoot(...)");
            super((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
            ar r6 = ar.a(this.f2390a);
            o.c(r6, "bind(...)");
            this.r = r6;
        }

        public void a(final com.obric.autoaction.app.launcherpage.donation.e.c r9) {
            o.e(r9, "cell");
            OCardListItem r0 = this.r.f22771a;
            Question r1 = r9.a().c();
            OTextView r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.getName();
        L6:
            r0.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
            r0.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r9.a().b(), CharSequence.class, "com.obric.aiagent.plugin"));
            OCardListItem.setCardPosition$default(r0, r9.b(), false, 2, null);
            r0.showSubTitle(true);
            OTextView r6 = r0.getTitleView();
            r6.setMaxLines(2);
            r6.setEllipsize(TextUtils.TruncateAt.END);
            r0.showCustomEnd(true);
            r0.setDefaultTailIcon(0);
            r0.showTailIcon(true);
            OCardListItem.setEndDetailText$default(r0, (CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(m.f23777a.a(r9.a().e()).b()), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
            View r4 = r0.getCustomEndView();
            if (ZeusTransformUtils.instanceOf(r4, OTextView.class) == false) goto L9;
            r2 = (OTextView) ZeusTransformUtils.preCheckCast(r4, OTextView.class, "com.obric.aiagent.plugin");
        L9:
            if (r2 == null) goto L18;
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            if (r9.a().e() != m.a.C0537a.f23786a.a()) goto L14;
            int r7 = ZeusTransformUtils.mapRes(R.color.oui_b_blue_bg, "color", "oui_b_blue_bg");
        L17:
            r2.setTextColor(r5.getColor(r7));
            goto L18
        L14:
            if (r9.a().e() != m.a.d.f23789a.a()) goto L16;
            r7 = ZeusTransformUtils.mapRes(R.color.oui_functional_red_7, "color", "oui_functional_red_7");
            goto L17
        L16:
            r7 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3");
        L18:
            r0.setOnContentClickListener(new $$Lambda$d$e$Hv7UkSf9H_ufxEFrl1QMOyeHoNQ(this, r9));
            return;
        L5:
            r3 = null;
            goto L6
        }

        private static final void a(e r8, com.obric.autoaction.app.launcherpage.donation.e.c r9, View r10) {
            RecordDataListActivity.a r0 = RecordDataListActivity.Companion;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            r0.a(r1, r9.a().c(), r9.a().b(), r9.a().d(), r9.a().e(), r9.a().g(), r9.a().a());
        }
    }

    static {
        f23732b = new b(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return (RecyclerView.u) ZeusTransformUtils.preCheckCast(c(r1, r2), RecyclerView.u.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
    }

    public d() {
        super((androidx.recyclerview.widget.j.e) ZeusTransformUtils.preCheckCast(new C0535d(), androidx.recyclerview.widget.j.e.class, "com.obric.aiagent.plugin"));
    }

    public void a(a<? extends com.obric.autoaction.app.launcherpage.donation.e.a> r2, int r3) {
        o.e(r2, "holder");
        com.obric.autoaction.app.launcherpage.donation.e.a r1 = (com.obric.autoaction.app.launcherpage.donation.e.a) ZeusTransformUtils.preCheckCast(c(r3), com.obric.autoaction.app.launcherpage.donation.e.a.class, "com.obric.aiagent.plugin");
        o.a(r1);
        r2.a(r1);
    }

    public a<? extends com.obric.autoaction.app.launcherpage.donation.e.a> c(ViewGroup r2, int r3) {
        o.e(r2, "parent");
        if (r3 != b.a.C0533a.f23734a.getType()) goto L6;
        return (a) ZeusTransformUtils.preCheckCast(new c(r2), a.class, "com.obric.aiagent.plugin");
    L6:
        if (r3 != b.a.C0534b.f23735a.getType()) goto L10;
        return (a) ZeusTransformUtils.preCheckCast(new e(r2), a.class, "com.obric.aiagent.plugin");
    L10:
        throw new IllegalArgumentException("Unknown view type: " + r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a(int r2) {
        com.obric.autoaction.app.launcherpage.donation.e.a r1 = (com.obric.autoaction.app.launcherpage.donation.e.a) ZeusTransformUtils.preCheckCast(c(r2), com.obric.autoaction.app.launcherpage.donation.e.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.autoaction.app.launcherpage.donation.e.b.class) == false) goto L6;
        return b.a.C0533a.f23734a.getType();
    L6:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.autoaction.app.launcherpage.donation.e.c.class) == false) goto L9;
        return b.a.C0534b.f23735a.getType();
    L9:
        return b.a.C0534b.f23735a.getType();
    }
}
