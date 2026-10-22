package com.obric.aiagent.skill.manager.impl.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.impl.dw;
import com.obric.aiagent.skill.manager.impl.dy;
import com.obric.aiagent.skill.manager.impl.dz;
import com.obric.aiagent.skill.manager.impl.ea;
import com.obric.aiagent.skill.manager.impl.eb;
import com.obric.aiagent.skill.manager.impl.ee;
import com.obric.aiagent.skill.manager.impl.ft;
import com.obric.aiagent.skill.manager.impl.hd;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.cx;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillCollectionDetailActivity extends SkillGatedActivity {
    private static final long ACTION_SUCCEED_DURATION_MS = 1000;
    public static final d Companion = null;
    private static final float EXAMPLE_ITEM_HORIZONTAL_MARGIN_DP = 12.0f;
    private static final float EXAMPLE_ITEM_SPACING_DP = 8.0f;
    private static final float EXAMPLE_SECTION_BOTTOM_PADDING_DP = 16.0f;
    private static final String EXTRA_COLLECTION_SLUG = "collection_slug";
    private static final float SKILL_COVER_RADIUS_DP = 14.0f;
    private static final float SOURCE_ICON_RADIUS_DP = 7.0f;
    private static final int VIEW_TYPE_EMPTY = 4;
    private static final int VIEW_TYPE_EXAMPLE = 3;
    private static final int VIEW_TYPE_EXAMPLE_HEADER = 2;
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_SKILL = 1;
    private b adapter;
    private List<com.obric.aiagent.skill.manager.api.e> collectionSkills;
    private String collectionSlug;
    private final HashSet<String> completedSkillSlugs;
    private final kotlinx.coroutines.am ioScope;
    private final ArrayList<com.obric.aiagent.skill.manager.api.e> latestInstalledSkills;
    private RecyclerView list;
    private kotlinx.coroutines.ca loadJob;
    private final kotlinx.coroutines.am mainScope;
    private final HashSet<String> processingSkillSlugs;
    private final ft shopRepository;
    private ISkillManagerService skillManager;
    private kotlinx.coroutines.ca skillStateJob;
    private OFloatingTitleBar titleBar;
    private final hd trackingReporter;

    /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20175a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f20176b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f20177c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f20178d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f20179e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f20175a, f20176b, f20177c, f20178d};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f20175a = new a("BUTTON_ADD", 0);
            f20176b = new a("PROGRESSING", 1);
            f20177c = new a("SUCCEED_CHECK", 2);
            f20178d = new a("BUTTON_USE", 3);
            a[] r0 = a();
            f20179e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f20179e.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
    private final class b extends RecyclerView.a<RecyclerView.v> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkillCollectionDetailActivity f20180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<c> f20181b;

        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        private final class a extends RecyclerView.v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f20182a;
            private final TextView s;

            public a(b r2, View r3) {
                d.h.b.o.e(r3, "itemView");
                this.f20182a = r2;
                super(r3);
                this.s = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin");
            }

            public final void a(String r3) {
                d.h.b.o.e(r3, "value");
                this.s.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        private final class C0422b extends RecyclerView.v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f20183a;
            private final TextView s;
            private final View t;

            public C0422b(b r5, View r6) {
                d.h.b.o.e(r6, "itemView");
                this.f20183a = r5;
                super(r6);
                View r7 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.collection_description, DbHelper.COL_ID, "collection_description"));
                d.h.b.o.c(r7, "findViewById(...)");
                this.s = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin");
                View r8 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.collection_skill_section_title, DbHelper.COL_ID, "collection_skill_section_title"));
                d.h.b.o.c(r8, "findViewById(...)");
                this.t = r8;
            }

            public final void a(c.d r5) {
                d.h.b.o.e(r5, "row");
                this.s.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.aiagent.plugin"));
                View r4 = this.t;
                if (r5.b() == false) goto L5;
                int r6 = 0;
            L6:
                r4.setVisibility(r6);
                return;
            L5:
                r6 = 8;
                goto L6
            }
        }

        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        private final class c extends RecyclerView.v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f20184a;
            private final OCardListItem s;
            private final SimpleDraweeView t;
            private final TextView u;
            private final TextView v;
            private final SimpleDraweeView w;
            private final TextView x;
            private final OButton y;
            private final ODownloadProgressView z;

            /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f20185a = null;

                static {
                    int[] r0 = new int[a.values().length];
                    r0[a.f20175a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r0[a.f20178d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r0[a.f20176b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r0[a.f20177c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    f20185a = r0;
                }
            }

            /* JADX INFO: renamed from: lambda$4S_RYLPy4C23EY0GlqT-naxWaPo, reason: not valid java name */
            public static /* synthetic */ void m288lambda$4S_RYLPy4C23EY0GlqTnaxWaPo(SkillCollectionDetailActivity r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
                a(r0, r1, r2);
            }

            /* JADX INFO: renamed from: lambda$Hy2zym13QMlMr1A2_-PywL6nE9c, reason: not valid java name */
            public static /* synthetic */ void m289lambda$Hy2zym13QMlMr1A2_PywL6nE9c(SkillCollectionDetailActivity r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
                c(r0, r1, r2);
            }

            public static /* synthetic */ void lambda$YRzWeIcEBxLqCTLyL_zzRMulXsU(SkillCollectionDetailActivity r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
                b(r0, r1, r2);
            }

            public c(b r6, View r7) {
                d.h.b.o.e(r7, "itemView");
                this.f20184a = r6;
                super(r7);
                OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r7, OCardListItem.class, "com.obric.aiagent.plugin");
                this.s = r8;
                View r1 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_icon, DbHelper.COL_ID, "skill_icon"));
                d.h.b.o.c(r1, "findViewById(...)");
                this.t = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r1, SimpleDraweeView.class, "com.obric.aiagent.plugin");
                View r2 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_name, DbHelper.COL_ID, "skill_name"));
                d.h.b.o.c(r2, "findViewById(...)");
                this.u = (TextView) ZeusTransformUtils.preCheckCast(r2, TextView.class, "com.obric.aiagent.plugin");
                View r3 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_description, DbHelper.COL_ID, "skill_description"));
                d.h.b.o.c(r3, "findViewById(...)");
                this.v = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin");
                View r4 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_source_avatar, DbHelper.COL_ID, "skill_source_avatar"));
                d.h.b.o.c(r4, "findViewById(...)");
                this.w = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r4, SimpleDraweeView.class, "com.obric.aiagent.plugin");
                View r5 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_source, DbHelper.COL_ID, "skill_source"));
                d.h.b.o.c(r5, "findViewById(...)");
                this.x = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.aiagent.plugin");
                View r9 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_action, DbHelper.COL_ID, "skill_action"));
                d.h.b.o.c(r9, "findViewById(...)");
                this.y = (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.aiagent.plugin");
                View r10 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_action_progress, DbHelper.COL_ID, "skill_action_progress"));
                d.h.b.o.c(r10, "findViewById(...)");
                this.z = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r10, ODownloadProgressView.class, "com.obric.aiagent.plugin");
                q.a(r8);
            }

            public final void a(final com.obric.aiagent.skill.manager.api.e r9, int r10, int r11) {
                d.h.b.o.e(r9, "skill");
                q.a(this.s, r10, r11);
                boolean r12 = SkillCollectionDetailActivity.access$getProcessingSkillSlugs$p(this.f20184a.f20180a).contains(r9.a());
                boolean r13 = SkillCollectionDetailActivity.access$getCompletedSkillSlugs$p(this.f20184a.f20180a).contains(r9.a());
                s.a(s.f20812a, this.t, r9.f(), 14.0f, true, null, 16, null);
                ch.f20743a.a(this.w, this.x, com.obric.aiagent.skill.manager.impl.az.f(r9), SkillCollectionDetailActivity.SOURCE_ICON_RADIUS_DP);
                this.u.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.az.d(r9), CharSequence.class, "com.obric.aiagent.plugin"));
                this.v.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.az.e(r9), CharSequence.class, "com.obric.aiagent.plugin"));
                this.x.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.az.g(r9), CharSequence.class, "com.obric.aiagent.plugin"));
                if (r12 == false) goto L5;
                a r14 = a.f20176b;
            L21:
                OCardListItem r15 = this.s;
                final SkillCollectionDetailActivity r0 = this.f20184a.f20180a;
                r15.setOnContentClickListener(new $$Lambda$SkillCollectionDetailActivity$b$c$4S_RYLPy4C23EY0GlqTnaxWaPo(r0, r9));
                a(r9, r14);
                return;
            L5:
                if (r13 == false) goto L7;
                r14 = a.f20177c;
                goto L21
            L7:
                Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(SkillCollectionDetailActivity.access$getLatestInstalledSkills$p(this.f20184a.f20180a), Iterable.class, "com.obric.aiagent.plugin");
                boolean r1 = false;
                if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L10;
            L12:
                Iterator r17 = r16.iterator();
            L14:
                if (r17.hasNext() == false) goto L18;
                if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r9.a()) == false) goto L14;
                r1 = true;
            L18:
                if (r1 == false) goto L20;
                r14 = a.f20178d;
                goto L21
            L20:
                r14 = a.f20175a;
                goto L21
            L10:
                if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L12;
                goto L12
            }

            private static final void a(SkillCollectionDetailActivity r1, com.obric.aiagent.skill.manager.api.e r2, View r3) {
                SkillCollectionDetailActivity.access$openSkillDetail((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin"), r2);
            }

            private final void a(final com.obric.aiagent.skill.manager.api.e r4, a r5) {
                this.z.setVisibility(8);
                this.y.setVisibility(8);
                this.y.setEnabled(true);
                this.y.setOnClickListener(null);
                int r6 = a.f20185a[r5.ordinal()];
                if (r6 != 1) goto L5;
                this.y.setVisibility(0);
                bj.a(this.y);
                this.y.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_common_add, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_add"));
                OButton r7 = this.y;
                final SkillCollectionDetailActivity r3 = this.f20184a.f20180a;
                r7.setOnClickListener(new $$Lambda$SkillCollectionDetailActivity$b$c$YRzWeIcEBxLqCTLyL_zzRMulXsU(r3, r4));
                return;
            L5:
                if (r6 != 2) goto L7;
                this.y.setVisibility(0);
                bj.b(this.y);
                this.y.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_common_use, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_use"));
                OButton r8 = this.y;
                final SkillCollectionDetailActivity r9 = this.f20184a.f20180a;
                r8.setOnClickListener(new $$Lambda$SkillCollectionDetailActivity$b$c$Hy2zym13QMlMr1A2_PywL6nE9c(r9, r4));
                return;
            L7:
                if (r6 != 3) goto L9;
                this.z.setVisibility(0);
                this.z.setCurrentState(0);
                return;
            L9:
                if (r6 != 4) goto L12;
                this.z.setVisibility(0);
                this.z.setCurrentState(4);
                return;
            L12:
                throw new d.k();
            }

            private static final void b(SkillCollectionDetailActivity r1, com.obric.aiagent.skill.manager.api.e r2, View r3) {
                SkillCollectionDetailActivity.access$installSkill((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin"), r2);
            }

            private static final void c(SkillCollectionDetailActivity r1, com.obric.aiagent.skill.manager.api.e r2, View r3) {
                SkillCollectionDetailActivity.access$useSkill((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin"), r2);
            }
        }

        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        private final class d extends RecyclerView.v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f20186a;

            public d(b r2, View r3) {
                d.h.b.o.e(r3, "itemView");
                this.f20186a = r2;
                super(r3);
            }
        }

        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        /* synthetic */ class e extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.manager.impl.ui.e, d.x> {
            e(Object r8) {
                super(1, r8, SkillCollectionDetailActivity.class, "openUsageExample", "openUsageExample(Lcom/obric/aiagent/skill/manager/impl/ui/FormattedUsageExample;)V", 0);
            }

            public final void a(com.obric.aiagent.skill.manager.impl.ui.e r3) {
                d.h.b.o.e(r3, "p0");
                SkillCollectionDetailActivity.access$openUsageExample((SkillCollectionDetailActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin"), r3);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(com.obric.aiagent.skill.manager.impl.ui.e r3) {
                a((com.obric.aiagent.skill.manager.impl.ui.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.impl.ui.e.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        public b(SkillCollectionDetailActivity r3) {
            this.f20180a = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
            this.f20181b = new ArrayList();
        }

        public final void a(String r9, List<com.obric.aiagent.skill.manager.api.e> r10, List<String> r11, String r12) {
            List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r9, "descriptionText");
            d.h.b.o.e(r13, "skills");
            d.h.b.o.e(r14, "examples");
            this.f20181b.clear();
            ((Collection) ZeusTransformUtils.preCheckCast(this.f20181b, Collection.class, "com.obric.aiagent.plugin")).add(new c.d(r9, !((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty()));
            Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            int r0 = 0;
            int r2 = 0;
        L4:
            if (r15.hasNext() == false) goto L10;
            Object r3 = r15.next();
            int r4 = r2 + 1;
            if (r2 >= 0) goto L8;
            d.a.p.c();
        L8:
            ((Collection) ZeusTransformUtils.preCheckCast(this.f20181b, Collection.class, "com.obric.aiagent.plugin")).add(new c.e((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), r2, r13.size()));
            r2 = r4;
            goto L4
        L10:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L18;
            ((Collection) ZeusTransformUtils.preCheckCast(this.f20181b, Collection.class, "com.obric.aiagent.plugin")).add(c.b.f20188a);
            Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L13:
            if (r16.hasNext() == false) goto L18;
            Object r17 = r16.next();
            int r5 = r0 + 1;
            if (r0 >= 0) goto L17;
            d.a.p.c();
        L17:
            ((Collection) ZeusTransformUtils.preCheckCast(this.f20181b, Collection.class, "com.obric.aiagent.plugin")).add(new c.C0423c((String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.aiagent.plugin"), r0, r14.size()));
            r0 = r5;
        L18:
            if (r12 == null) goto L20;
            ((Collection) ZeusTransformUtils.preCheckCast(this.f20181b, Collection.class, "com.obric.aiagent.plugin")).add(new c.a(r12));
        L20:
            g();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
        public int a(int r2) {
            c r1 = (c) ZeusTransformUtils.preCheckCast(this.f20181b.get(r2), c.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r1, c.d.class) == false) goto L6;
            return 0;
        L6:
            if (ZeusTransformUtils.instanceOf(r1, c.e.class) == false) goto L9;
            return 1;
        L9:
            if (d.h.b.o.a(r1, c.b.f20188a) == false) goto L12;
            return 2;
        L12:
            if (ZeusTransformUtils.instanceOf(r1, c.C0423c.class) == false) goto L15;
            return 3;
        L15:
            if (ZeusTransformUtils.instanceOf(r1, c.a.class) == false) goto L19;
            return 4;
        L19:
            throw new d.k();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
        public RecyclerView.v b(ViewGroup r8, int r9) {
            d.h.b.o.e(r8, "parent");
            LayoutInflater r0 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            if (r9 != 0) goto L5;
            View r10 = ZeusTransformUtils.inflate(r0, ZeusTransformUtils.mapRes(R.layout.item_skill_collection_header, "layout", "item_skill_collection_header"), r8, false, "com.obric.aiagent.plugin");
            d.h.b.o.c(r10, "inflate(...)");
            return (RecyclerView.v) ZeusTransformUtils.preCheckCast(new C0422b(this, r10), RecyclerView.v.class, "com.obric.aiagent.plugin");
        L5:
            if (r9 != 1) goto L7;
            View r11 = ZeusTransformUtils.inflate(r0, ZeusTransformUtils.mapRes(R.layout.item_skill_discovery, "layout", "item_skill_discovery"), r8, false, "com.obric.aiagent.plugin");
            d.h.b.o.c(r11, "inflate(...)");
            return (RecyclerView.v) ZeusTransformUtils.preCheckCast(new c(this, r11), RecyclerView.v.class, "com.obric.aiagent.plugin");
        L7:
            if (r9 != 2) goto L9;
            View r12 = ZeusTransformUtils.inflate(r0, ZeusTransformUtils.mapRes(R.layout.item_skill_collection_example_header, "layout", "item_skill_collection_example_header"), r8, false, "com.obric.aiagent.plugin");
            d.h.b.o.c(r12, "inflate(...)");
            return (RecyclerView.v) ZeusTransformUtils.preCheckCast(new d(this, r12), RecyclerView.v.class, "com.obric.aiagent.plugin");
        L9:
            if (r9 == 3) goto L11;
            View r13 = ZeusTransformUtils.inflate(r0, ZeusTransformUtils.mapRes(R.layout.item_skill_collection_empty, "layout", "item_skill_collection_empty"), r8, false, "com.obric.aiagent.plugin");
            d.h.b.o.c(r13, "inflate(...)");
            return (RecyclerView.v) ZeusTransformUtils.preCheckCast(new a(this, r13), RecyclerView.v.class, "com.obric.aiagent.plugin");
        L11:
            View r14 = ZeusTransformUtils.inflate(r0, ZeusTransformUtils.mapRes(R.layout.item_skill_usage_example, "layout", "item_skill_usage_example"), r8, false, "com.obric.aiagent.plugin");
            d.h.b.o.c(r14, "inflate(...)");
            return (RecyclerView.v) ZeusTransformUtils.preCheckCast(new cp.a(r14, (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(this.f20180a), d.h.a.b.class, "com.obric.aiagent.plugin")), RecyclerView.v.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
        public void a(RecyclerView.v r9, int r10) {
            d.h.b.o.e(r9, "holder");
            c r11 = this.f20181b.get(r10);
            d.h.b.o.c(r11, "get(...)");
            c r12 = (c) ZeusTransformUtils.preCheckCast(r11, c.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r12, c.d.class) == false) goto L6;
            ((C0422b) ZeusTransformUtils.preCheckCast(r9, C0422b.class, "com.obric.aiagent.plugin")).a((c.d) ZeusTransformUtils.preCheckCast(r12, c.d.class, "com.obric.aiagent.plugin"));
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r12, c.e.class) == false) goto L9;
            ((c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin")).a(SkillCollectionDetailActivity.access$withLatestInstalledState(this.f20180a, ((c.e) ZeusTransformUtils.preCheckCast(r12, c.e.class, "com.obric.aiagent.plugin")).a()), ((c.e) ZeusTransformUtils.preCheckCast(r12, c.e.class, "com.obric.aiagent.plugin")).b(), ((c.e) ZeusTransformUtils.preCheckCast(r12, c.e.class, "com.obric.aiagent.plugin")).c());
            return;
        L9:
            if (d.h.b.o.a(r12, c.b.f20188a) == false) goto L11;
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(r12, c.C0423c.class) == false) goto L22;
            SkillCollectionDetailActivity r2 = this.f20180a;
            View r3 = r9.f35660b;
            d.h.b.o.c(r3, "itemView");
            if (((c.C0423c) ZeusTransformUtils.preCheckCast(r12, c.C0423c.class, "com.obric.aiagent.plugin")).b() != 0) goto L15;
            float r5 = 0.0f;
        L17:
            if (((c.C0423c) ZeusTransformUtils.preCheckCast(r12, c.C0423c.class, "com.obric.aiagent.plugin")).b() != (((c.C0423c) ZeusTransformUtils.preCheckCast(r12, c.C0423c.class, "com.obric.aiagent.plugin")).c() - 1)) goto L19;
            float r7 = 16.0f;
        L20:
            SkillCollectionDetailActivity.access$setCollectionItemMargins(r2, r3, 12.0f, r5, 12.0f, r7);
            ((cp.a) ZeusTransformUtils.preCheckCast(r9, cp.a.class, "com.obric.aiagent.plugin")).a(((c.C0423c) ZeusTransformUtils.preCheckCast(r12, c.C0423c.class, "com.obric.aiagent.plugin")).a());
            return;
        L19:
            r7 = 0.0f;
            goto L20
        L15:
            r5 = 8.0f;
            goto L17
        L22:
            if (ZeusTransformUtils.instanceOf(r12, c.a.class) == false) goto L25;
            ((a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin")).a(((c.a) ZeusTransformUtils.preCheckCast(r12, c.a.class, "com.obric.aiagent.plugin")).a());
            return;
        L25:
            throw new d.k();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
        public int a() {
            return this.f20181b.size();
        }
    }

    /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
    private static abstract class c {

        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f20187a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f20187a, r6.f20187a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f20187a.hashCode();
            }

            public String toString() {
                return "Empty(message=" + this.f20187a + ')';
            }

            public final String a() {
                return this.f20187a;
            }

            public a(String r2) {
                d.h.b.o.e(r2, "message");
                super(null);
                this.f20187a = r2;
            }
        }

        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f20188a = null;

            static {
                f20188a = new b();
            }

            private b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        public static final class C0423c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f20189a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f20190b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final int f20191c;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0423c.class) == true) goto L8;
                return false;
            L8:
                C0423c r6 = (C0423c) ZeusTransformUtils.preCheckCast(r5, C0423c.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f20189a, r6.f20189a) == true) goto L12;
                return false;
            L12:
                if (this.f20190b == r6.f20190b) goto L15;
                return false;
            L15:
                if (this.f20191c == r6.f20191c) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f20189a.hashCode() * 31) + Integer.hashCode(this.f20190b)) * 31) + Integer.hashCode(this.f20191c);
            }

            public String toString() {
                return "ExampleItem(example=" + this.f20189a + ", position=" + this.f20190b + ", itemCount=" + this.f20191c + ')';
            }

            public final String a() {
                return this.f20189a;
            }

            public final int b() {
                return this.f20190b;
            }

            public final int c() {
                return this.f20191c;
            }

            public C0423c(String r2, int r3, int r4) {
                d.h.b.o.e(r2, "example");
                super(null);
                this.f20189a = r2;
                this.f20190b = r3;
                this.f20191c = r4;
            }
        }

        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f20192a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final boolean f20193b;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
                return false;
            L8:
                d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f20192a, r6.f20192a) == true) goto L12;
                return false;
            L12:
                if (this.f20193b == r6.f20193b) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f20192a.hashCode() * 31) + Boolean.hashCode(this.f20193b);
            }

            public String toString() {
                return "Header(description=" + this.f20192a + ", hasSkills=" + this.f20193b + ')';
            }

            public final String a() {
                return this.f20192a;
            }

            public final boolean b() {
                return this.f20193b;
            }

            public d(String r2, boolean r3) {
                d.h.b.o.e(r2, "description");
                super(null);
                this.f20192a = r2;
                this.f20193b = r3;
            }
        }

        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        public static final class e extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.aiagent.skill.manager.api.e f20194a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f20195b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final int f20196c;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
                return false;
            L8:
                e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f20194a, r6.f20194a) == true) goto L12;
                return false;
            L12:
                if (this.f20195b == r6.f20195b) goto L15;
                return false;
            L15:
                if (this.f20196c == r6.f20196c) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f20194a.hashCode() * 31) + Integer.hashCode(this.f20195b)) * 31) + Integer.hashCode(this.f20196c);
            }

            public String toString() {
                return "SkillItem(skill=" + this.f20194a + ", position=" + this.f20195b + ", itemCount=" + this.f20196c + ')';
            }

            public final com.obric.aiagent.skill.manager.api.e a() {
                return this.f20194a;
            }

            public final int b() {
                return this.f20195b;
            }

            public final int c() {
                return this.f20196c;
            }

            public e(com.obric.aiagent.skill.manager.api.e r2, int r3, int r4) {
                d.h.b.o.e(r2, "skill");
                super(null);
                this.f20194a = r2;
                this.f20195b = r3;
                this.f20196c = r4;
            }
        }

        public /* synthetic */ c(d.h.b.h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
    public static final class d {
        public /* synthetic */ d(d.h.b.h r1) {
            this();
        }

        private d() {
        }

        public final Intent a(Context r2, String r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "context");
            d.h.b.o.e(r3, "collectionSlug");
            Intent r4 = new Intent(r1, SkillCollectionDetailActivity.class);
            r4.putExtra(SkillCollectionDetailActivity.EXTRA_COLLECTION_SLUG, r3);
            return r4;
        }
    }

    /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
    @d.c.b.a.f(b = "SkillCollectionDetailActivity.kt", c = {245}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$ensureSkillObserverStarted$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> f20198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SkillCollectionDetailActivity f20199c;

        e(kotlinx.coroutines.b.ak<? extends List<com.obric.aiagent.skill.manager.api.e>> r3, SkillCollectionDetailActivity r4, d.c.d<? super e> r5) {
            kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r6 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
            SkillCollectionDetailActivity r7 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20198b = r6;
            this.f20199c = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f20198b, this.f20199c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20197a;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L6;
            d.o.a(r6);     // Catch: Exception -> L9 CancellationException -> L11
        L18:
            throw new d.d();     // Catch: Exception -> L9 CancellationException -> L11
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r6);
            kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r7 = this.f20198b;     // Catch: Exception -> L9 CancellationException -> L11
            final SkillCollectionDetailActivity r4 = this.f20199c;     // Catch: Exception -> L9 CancellationException -> L11
            kotlinx.coroutines.b.i<? super List<com.obric.aiagent.skill.manager.api.e>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9 CancellationException -> L11
            d.c.d<?> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9 CancellationException -> L11
            this.f20197a = 1;     // Catch: Exception -> L9 CancellationException -> L11
            if (r7.collect(r2, r5) != r0) goto L18;
            return r0;
        L11:
            e = move-exception;
            throw e;
        L9:
            e = move-exception;
            ee.f19808a.a("SkillManager", "Observe installed skills failed on collection detail", "Observe installed skills failed on collection detail: collectionSlug=" + SkillCollectionDetailActivity.access$getCollectionSlug$p(this.f20199c), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
    @d.c.b.a.f(b = "SkillCollectionDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$installSkill$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillCollectionDetailActivity f20207d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$f$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        @d.c.b.a.f(b = "SkillCollectionDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$installSkill$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20208a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillCollectionDetailActivity f20209b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20210c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20211d;

            AnonymousClass1(SkillCollectionDetailActivity r3, com.obric.aiagent.skill.manager.api.e r4, com.obric.aiagent.skill.manager.api.e r5, d.c.d<? super AnonymousClass1> r6) {
                SkillCollectionDetailActivity r7 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20209b = r7;
                this.f20210c = r4;
                this.f20211d = r5;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20209b, this.f20210c, this.f20211d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20208a != 0) goto L14;
                d.o.a(r4);
                SkillCollectionDetailActivity.access$upsertLatestInstalledSkill(this.f20209b, this.f20210c);
                SkillCollectionDetailActivity.access$getCompletedSkillSlugs$p(this.f20209b).add(this.f20211d.a());
                cm r5 = cm.f20758a;
                Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this.f20209b, Activity.class, "com.obric.aiagent.plugin");
                if (this.f20210c.l() == false) goto L7;
                cm.a r1 = cm.a.f20760a;
            L8:
                r5.a(r0, r1);
                SkillCollectionDetailActivity.access$getProcessingSkillSlugs$p(this.f20209b).remove(this.f20211d.a());
                b r6 = SkillCollectionDetailActivity.access$getAdapter$p(this.f20209b);
                if (r6 != null) goto L11;
                d.h.b.o.c("adapter");
                r6 = null;
            L11:
                r6.g();
                SkillCollectionDetailActivity.access$refreshListInstalledState(this.f20209b);
                SkillCollectionDetailActivity.access$scheduleCompletionClear(this.f20209b, this.f20211d.a());
                return d.x.f38692a;
            L7:
                r1 = cm.a.g;
                goto L8
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$f$2, reason: invalid class name */
        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        @d.c.b.a.f(b = "SkillCollectionDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$installSkill$1$2")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20212a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillCollectionDetailActivity f20213b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20214c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Exception f20215d;

            AnonymousClass2(SkillCollectionDetailActivity r3, com.obric.aiagent.skill.manager.api.e r4, Exception r5, d.c.d<? super AnonymousClass2> r6) {
                SkillCollectionDetailActivity r7 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20213b = r7;
                this.f20214c = r4;
                this.f20215d = r5;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20213b, this.f20214c, this.f20215d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20212a != 0) goto L13;
                d.o.a(r4);
                SkillCollectionDetailActivity.access$getProcessingSkillSlugs$p(this.f20213b).remove(this.f20214c.a());
                SkillCollectionDetailActivity.access$getCompletedSkillSlugs$p(this.f20213b).remove(this.f20214c.a());
                cl.a("SkillManager", "install skill", (Throwable) ZeusTransformUtils.preCheckCast(this.f20215d, Throwable.class, "com.obric.aiagent.plugin"));
                b r5 = SkillCollectionDetailActivity.access$getAdapter$p(this.f20213b);
                if (r5 != null) goto L7;
                d.h.b.o.c("adapter");
                r5 = null;
            L7:
                r5.g();
                cm.a r6 = cl.a((Throwable) ZeusTransformUtils.preCheckCast(this.f20215d, Throwable.class, "com.obric.aiagent.plugin"));
                if (r6 == null) goto L11;
                SkillCollectionDetailActivity r3 = this.f20213b;
                cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.aiagent.plugin"), r6);
            L11:
                return d.x.f38692a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        @d.c.b.a.f(b = "SkillCollectionDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$installSkill$1$installed$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20216a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillCollectionDetailActivity f20217b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20218c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> f20219d;

            a(SkillCollectionDetailActivity r3, com.obric.aiagent.skill.manager.api.e r4, com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r5, d.c.d<? super a> r6) {
                SkillCollectionDetailActivity r7 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r8 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20217b = r7;
                this.f20218c = r4;
                this.f20219d = r8;
                super(2, r9);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f20217b, this.f20218c, this.f20219d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20216a != 0) goto L13;
                d.o.a(r4);
                SkillCollectionDetailActivity.access$getProcessingSkillSlugs$p(this.f20217b).remove(this.f20218c.a());
                SkillCollectionDetailActivity.access$getCompletedSkillSlugs$p(this.f20217b).remove(this.f20218c.a());
                a("SkillManager", "install skill failed: code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(this.f20219d, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());
                b r5 = SkillCollectionDetailActivity.access$getAdapter$p(this.f20217b);
                if (r5 != null) goto L7;
                d.h.b.o.c("adapter");
                r5 = null;
            L7:
                r5.g();
                cm.a r6 = cl.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(this.f20219d, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin"));
                if (r6 == null) goto L11;
                cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20217b, Activity.class, "com.obric.aiagent.plugin"), r6);
            L11:
                return d.x.f38692a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int a(String r1, String r2) {
                if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                return 0;
            L5:
                return Log.w(r1, r2);
            }
        }

        f(ISkillManagerService r3, com.obric.aiagent.skill.manager.api.e r4, SkillCollectionDetailActivity r5, d.c.d<? super f> r6) {
            ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
            SkillCollectionDetailActivity r8 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r5, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20205b = r7;
            this.f20206c = r4;
            this.f20207d = r8;
            super(2, r9);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f20205b, this.f20206c, this.f20207d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f20204a != 0) goto L21;
            d.o.a(r10);
            com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r1 = this.f20205b.installSkill(this.f20206c.a(), this.f20206c.d(), com.obric.aiagent.skill.manager.api.au.f19238e);     // Catch: Exception -> L14 CancellationException -> L18
            if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L9;
            com.obric.aiagent.skill.manager.api.e r2 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14 CancellationException -> L18
            kotlinx.coroutines.i.a(SkillCollectionDetailActivity.access$getMainScope$p(this.f20207d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20207d, r2, this.f20206c, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L14 CancellationException -> L18
        L17:
            return d.x.f38692a;
        L9:
            if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L13;
            kotlinx.coroutines.i.a(SkillCollectionDetailActivity.access$getMainScope$p(this.f20207d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f20207d, this.f20206c, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L14 CancellationException -> L18
            return d.x.f38692a;
        L13:
            throw new d.k();     // Catch: Exception -> L14 CancellationException -> L18
        L18:
            e = move-exception;
            throw e;
        L14:
            e = move-exception;
            kotlinx.coroutines.i.a(SkillCollectionDetailActivity.access$getMainScope$p(this.f20207d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20207d, this.f20206c, e, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            goto L17
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
    @d.c.b.a.f(b = "SkillCollectionDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$loadCollection$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillCollectionDetailActivity f20221b;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$g$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        @d.c.b.a.f(b = "SkillCollectionDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$loadCollection$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20222a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillCollectionDetailActivity f20223b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ List<com.obric.aiagent.skill.manager.api.e> f20224c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.impl.al f20225d;

            AnonymousClass1(SkillCollectionDetailActivity r3, List<com.obric.aiagent.skill.manager.api.e> r4, com.obric.aiagent.skill.manager.impl.al r5, d.c.d<? super AnonymousClass1> r6) {
                SkillCollectionDetailActivity r7 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
                List<com.obric.aiagent.skill.manager.api.e> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20223b = r7;
                this.f20224c = r8;
                this.f20225d = r5;
                super(2, r9);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20223b, this.f20224c, this.f20225d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20222a != 0) goto L7;
                d.o.a(r4);
                SkillCollectionDetailActivity.access$getLatestInstalledSkills$p(this.f20223b).clear();
                SkillCollectionDetailActivity.access$getLatestInstalledSkills$p(this.f20223b).addAll((Collection) ZeusTransformUtils.preCheckCast(this.f20224c, Collection.class, "com.obric.aiagent.plugin"));
                SkillCollectionDetailActivity.access$renderCollection(this.f20223b, this.f20225d);
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$g$2, reason: invalid class name */
        /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
        @d.c.b.a.f(b = "SkillCollectionDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$loadCollection$1$2")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20226a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Exception f20227b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SkillCollectionDetailActivity f20228c;

            AnonymousClass2(Exception r3, SkillCollectionDetailActivity r4, d.c.d<? super AnonymousClass2> r5) {
                SkillCollectionDetailActivity r6 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20227b = r3;
                this.f20228c = r6;
                super(2, r7);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20227b, this.f20228c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                d.c.a.b.a();
                if (this.f20226a != 0) goto L7;
                d.o.a(r6);
                cl.a("SkillManager", "load collection", (Throwable) ZeusTransformUtils.preCheckCast(this.f20227b, Throwable.class, "com.obric.aiagent.plugin"));
                SkillCollectionDetailActivity r7 = this.f20228c;
                String r0 = r7.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_load_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_load_failed"));
                d.h.b.o.c(r0, "getString(...)");
                String r5 = this.f20228c.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_retry_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_retry_message"));
                d.h.b.o.c(r5, "getString(...)");
                SkillCollectionDetailActivity.access$renderError(r7, r0, r5);
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        g(SkillCollectionDetailActivity r3, d.c.d<? super g> r4) {
            SkillCollectionDetailActivity r5 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20221b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f20221b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r26) {
            d.c.a.b.a();
            if (this.f20220a != 0) goto L31;
            d.o.a(r26);
            d.c.d r15 = null;
            ea r19 = new ea(dy.q, SkillCollectionDetailActivity.access$getTrackingReporter$p(this.f20221b), null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
            com.obric.aiagent.skill.manager.impl.al r0 = SkillCollectionDetailActivity.access$getShopRepository$p(this.f20221b).b(SkillCollectionDetailActivity.access$getCollectionSlug$p(this.f20221b));     // Catch: Exception -> L22 CancellationException -> L27
            if (r0 == null) goto L19;
            ISkillManagerService r5 = SkillCollectionDetailActivity.access$getSkillManager$p(this.f20221b);     // Catch: Exception -> L22 CancellationException -> L27
            if (r5 == null) goto L12;
            com.obric.aiagent.skill.manager.api.u<List<com.obric.aiagent.skill.manager.api.e>> r6 = r5.getInstalledSkills();     // Catch: Exception -> L22 CancellationException -> L27
            if (r6 == null) goto L12;
            List r7 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r6), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22 CancellationException -> L27
        L13:
            if (r7 != null) goto L15;
            r7 = d.a.p.b();     // Catch: Exception -> L22 CancellationException -> L27
        L15:
            List r14 = r7;
            ea.a(r19, dz.f19791a, null, null, null, null, null, null, null, null, null, d.a.ao.a(new d.m[]{d.s.a("page_type", "collection"), d.s.a("item_count", d.c.b.a.b.a(r0.c().size()))}), DownloadErrorCode.ERROR_NO_CONNECTION, null);     // Catch: Exception -> L22 CancellationException -> L27
            kotlinx.coroutines.i.a(SkillCollectionDetailActivity.access$getMainScope$p(this.f20221b), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20221b, r14, r0, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L20 CancellationException -> L27
        L26:
            return d.x.f38692a;
        L12:
            r7 = null;
            goto L13
        L19:
            throw new IllegalArgumentException("Collection not found: " + SkillCollectionDetailActivity.access$getCollectionSlug$p(this.f20221b));     // Catch: Exception -> L20 CancellationException -> L27
        L20:
            e = e;
        L24:
            ea.a(r19, dz.f19792b, null, null, null, null, null, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), "collection_request", d.c.b.a.b.a(true), null, d.a.ao.a(d.s.a("page_type", "collection")), 574, null);
            kotlinx.coroutines.i.a(SkillCollectionDetailActivity.access$getMainScope$p(this.f20221b), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(e, this.f20221b, r15), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        L27:
            e = move-exception;
            ea.a(r19, dz.f19793c, null, null, null, null, null, dw.n, "page_destroyed", null, null, d.a.ao.a(d.s.a("page_type", "collection")), 830, null);
            throw e;
        L22:
            e = e;
            r15 = null;
            goto L24
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
    /* synthetic */ class h extends d.h.b.l implements d.h.a.b<ISkillManagerService, d.x> {
        h(Object r8) {
            super(1, r8, SkillCollectionDetailActivity.class, "initializeSkillPage", "initializeSkillPage(Lcom/obric/aiagent/skill/manager/api/ISkillManagerService;)V", 0);
        }

        public final void a(ISkillManagerService r3) {
            ISkillManagerService r4 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "p0");
            SkillCollectionDetailActivity.access$initializeSkillPage((SkillCollectionDetailActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(ISkillManagerService r3) {
            a((ISkillManagerService) ZeusTransformUtils.preCheckCast(r3, ISkillManagerService.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillCollectionDetailActivity.kt */
    @d.c.b.a.f(b = "SkillCollectionDetailActivity.kt", c = {335}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailActivity$scheduleCompletionClear$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillCollectionDetailActivity f20230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20231c;

        i(SkillCollectionDetailActivity r3, String r4, d.c.d<? super i> r5) {
            SkillCollectionDetailActivity r6 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20230b = r6;
            this.f20231c = r4;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f20230b, this.f20231c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20229a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            if (SkillCollectionDetailActivity.access$getCompletedSkillSlugs$p(this.f20230b).remove(this.f20231c) == false) goto L18;
            b r5 = SkillCollectionDetailActivity.access$getAdapter$p(this.f20230b);
            if (r5 != null) goto L16;
            d.h.b.o.c("adapter");
            r5 = null;
        L16:
            r5.g();
        L18:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20229a = 1;
            if (kotlinx.coroutines.ax.a(1000, r7) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new d(null);
    }

    public static final Intent createIntent(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return Companion.a(r4, r3);
    }

    public static /* synthetic */ void lambda$3sNYViC1URztcx_37aYwRB9lvkg(SkillCollectionDetailActivity r0, View r1) {
        bindViews$lambda$1(r0, r1);
    }

    public static /* synthetic */ androidx.core.view.al lambda$8zz0nYLWakT51IPXtN091scZIRs(View r0, androidx.core.view.al r1) {
        return onCreate$lambda$0(r0, r1);
    }

    public static /* synthetic */ d.x lambda$c3Aa94ZqGY0cJCYwVhW3ZT9JfZg(SkillCollectionDetailActivity r0, String r1) {
        return openUsageExample$lambda$7(r0, r1);
    }

    public static /* synthetic */ d.x lambda$iIs5dw4H9ZRrowvE2wa77vU14Ag(com.obric.aiagent.skill.manager.api.e r0, SkillCollectionDetailActivity r1) {
        return useSkill$lambda$6(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$qR-KFGWpnLLi7jHnXse0nMpx8Uk, reason: not valid java name */
    public static /* synthetic */ d.x m287lambda$qRKFGWpnLLi7jHnXse0nMpx8Uk(SkillCollectionDetailActivity r0, String r1) {
        return useSkill$lambda$6$lambda$5(r0, r1);
    }

    public SkillCollectionDetailActivity() {
        this.ioScope = kotlinx.coroutines.an.a(kotlinx.coroutines.bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin")));
        this.mainScope = kotlinx.coroutines.an.a();
        this.shopRepository = new ft();
        this.trackingReporter = new hd(null, null, null, 7, null);
        this.processingSkillSlugs = new HashSet();
        this.completedSkillSlugs = new HashSet();
        this.latestInstalledSkills = new ArrayList();
        this.collectionSlug = "";
        this.collectionSkills = d.a.p.b();
    }

    public static final /* synthetic */ b access$getAdapter$p(SkillCollectionDetailActivity r2) {
        return ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).adapter;
    }

    public static final /* synthetic */ String access$getCollectionSlug$p(SkillCollectionDetailActivity r2) {
        return ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).collectionSlug;
    }

    public static final /* synthetic */ HashSet access$getCompletedSkillSlugs$p(SkillCollectionDetailActivity r2) {
        return ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).completedSkillSlugs;
    }

    public static final /* synthetic */ ArrayList access$getLatestInstalledSkills$p(SkillCollectionDetailActivity r2) {
        return ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).latestInstalledSkills;
    }

    public static final /* synthetic */ kotlinx.coroutines.am access$getMainScope$p(SkillCollectionDetailActivity r2) {
        return ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).mainScope;
    }

    public static final /* synthetic */ HashSet access$getProcessingSkillSlugs$p(SkillCollectionDetailActivity r2) {
        return ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).processingSkillSlugs;
    }

    public static final /* synthetic */ ft access$getShopRepository$p(SkillCollectionDetailActivity r2) {
        return ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).shopRepository;
    }

    public static final /* synthetic */ ISkillManagerService access$getSkillManager$p(SkillCollectionDetailActivity r2) {
        return ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).skillManager;
    }

    public static final /* synthetic */ hd access$getTrackingReporter$p(SkillCollectionDetailActivity r2) {
        return ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).trackingReporter;
    }

    public static final /* synthetic */ void access$initializeSkillPage(SkillCollectionDetailActivity r2, ISkillManagerService r3) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).initializeSkillPage((ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$installSkill(SkillCollectionDetailActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).installSkill(r3);
    }

    public static final /* synthetic */ void access$openSkillDetail(SkillCollectionDetailActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).openSkillDetail(r3);
    }

    public static final /* synthetic */ void access$openUsageExample(SkillCollectionDetailActivity r2, com.obric.aiagent.skill.manager.impl.ui.e r3) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).openUsageExample(r3);
    }

    public static final /* synthetic */ void access$refreshListInstalledState(SkillCollectionDetailActivity r2) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).refreshListInstalledState();
    }

    public static final /* synthetic */ void access$renderCollection(SkillCollectionDetailActivity r2, com.obric.aiagent.skill.manager.impl.al r3) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).renderCollection(r3);
    }

    public static final /* synthetic */ void access$renderError(SkillCollectionDetailActivity r2, String r3, String r4) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).renderError(r3, r4);
    }

    public static final /* synthetic */ void access$scheduleCompletionClear(SkillCollectionDetailActivity r2, String r3) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).scheduleCompletionClear(r3);
    }

    public static final /* synthetic */ void access$setCollectionItemMargins(SkillCollectionDetailActivity r6, View r7, float r8, float r9, float r10, float r11) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r6, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).setCollectionItemMargins(r7, r8, r9, r10, r11);
    }

    public static final /* synthetic */ void access$upsertLatestInstalledSkill(SkillCollectionDetailActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).upsertLatestInstalledSkill(r3);
    }

    public static final /* synthetic */ void access$useSkill(SkillCollectionDetailActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).useSkill(r3);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.e access$withLatestInstalledState(SkillCollectionDetailActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        return ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).withLatestInstalledState(r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        configureSystemBars();
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_skill_collection_detail, "layout", "activity_skill_collection_detail"));
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_navigation_bar_surface, DbHelper.COL_ID, "skill_navigation_bar_surface"));
        ViewCompat.a(r5, $$Lambda$SkillCollectionDetailActivity$8zz0nYLWakT51IPXtN091scZIRs.INSTANCE);
        ViewCompat.u(r5);
        String r6 = getIntent().getStringExtra(EXTRA_COLLECTION_SLUG);
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        this.collectionSlug = r6;
        installSkillPageGuard(ZeusTransformUtils.mapRes(R.id.skill_collection_detail_root, DbHelper.COL_ID, "skill_collection_detail_root"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new h(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private static final androidx.core.view.al onCreate$lambda$0(View r3, androidx.core.view.al r4) {
        d.h.b.o.e(r3, "view");
        d.h.b.o.e(r4, "insets");
        int r0 = bh.a(r4);
        ViewGroup.LayoutParams r1 = r3.getLayoutParams();
        if (r1.height == r0) goto L5;
        r1.height = r0;
        r3.setLayoutParams(r1);
    L5:
        return r4;
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity
    public OFloatingTitleBar getFloatingTitleBar() {
        OFloatingTitleBar r1 = this.titleBar;
        if (r1 == null) goto L7;
        if (r1 != null) goto L8;
        d.h.b.o.c("titleBar");
        goto L7
    L8:
        return r1;
    L7:
        return null;
    }

    private final void initializeSkillPage(ISkillManagerService r3) {
        this.skillManager = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
        bindViews();
        ensureSkillObserverStarted();
        loadCollection();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        kotlinx.coroutines.ca r0 = this.loadJob;
        if (r0 == null) goto L5;
        kotlinx.coroutines.ca.a.a(r0, null, 1, null);
    L5:
        kotlinx.coroutines.ca r1 = this.skillStateJob;
        if (r1 == null) goto L8;
        kotlinx.coroutines.ca.a.a(r1, null, 1, null);
    L8:
        kotlinx.coroutines.an.a(this.ioScope, null, 1, null);
        kotlinx.coroutines.an.a(this.mainScope, null, 1, null);
        super.onDestroy();
    }

    private final void configureSystemBars() {
        bh.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 0, false, 6, null);
    }

    private final void bindViews() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.collection_title_bar, DbHelper.COL_ID, "collection_title_bar"));
        d.h.b.o.c(r0, "findViewById(...)");
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r0, OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        this.titleBar = r1;
        b r5 = null;
        if (r1 != null) goto L5;
        d.h.b.o.c("titleBar");
        r1 = null;
    L5:
        r1.setFloatingTransitionEnabled(true);
        OFloatingTitleBar r2 = this.titleBar;
        if (r2 != null) goto L8;
        d.h.b.o.c("titleBar");
        r2 = null;
    L8:
        r2.addStartAction(ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$SkillCollectionDetailActivity$3sNYViC1URztcx_37aYwRB9lvkg(this)).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_back, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_back")), CharSequence.class, "com.obric.aiagent.plugin"));
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.collection_list, DbHelper.COL_ID, "collection_list"));
        d.h.b.o.c(r3, "findViewById(...)");
        RecyclerView r4 = (RecyclerView) ZeusTransformUtils.preCheckCast(r3, RecyclerView.class, "com.obric.aiagent.plugin");
        this.list = r4;
        if (r4 != null) goto L11;
        d.h.b.o.c("list");
        r4 = null;
    L11:
        bh.a(r4, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.skill_navigation_list_extra_bottom, "dimen", "skill_navigation_list_extra_bottom")));
        RecyclerView r6 = this.list;
        if (r6 != null) goto L14;
        d.h.b.o.c("list");
        r6 = null;
    L14:
        r6.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        RecyclerView r7 = this.list;
        if (r7 != null) goto L17;
        d.h.b.o.c("list");
        r7 = null;
    L17:
        r7.setHasFixedSize(false);
        this.adapter = new b(this);
        RecyclerView r8 = this.list;
        if (r8 != null) goto L20;
        d.h.b.o.c("list");
        r8 = null;
    L20:
        b r9 = this.adapter;
        if (r9 != null) goto L23;
        d.h.b.o.c("adapter");
    L24:
        r8.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(r5, RecyclerView.a.class, "com.obric.aiagent.plugin"));
        return;
    L23:
        r5 = r9;
        goto L24
    }

    private static final void bindViews$lambda$1(SkillCollectionDetailActivity r1, View r2) {
        ((SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private final void loadCollection() {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.collectionSlug, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_collection_not_found_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_collection_not_found_title"));
        d.h.b.o.c(r0, "getString(...)");
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_collection_not_found_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_collection_not_found_message"));
        d.h.b.o.c(r1, "getString(...)");
        renderError(r0, r1);
        return;
    L6:
        renderLoading();
        kotlinx.coroutines.ca r2 = this.loadJob;
        if (r2 == null) goto L9;
        kotlinx.coroutines.ca.a.a(r2, null, 1, null);
    L9:
        this.loadJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void renderLoading() {
        this.collectionSkills = d.a.p.b();
        OFloatingTitleBar r0 = this.titleBar;
        if (r0 != null) goto L5;
        d.h.b.o.c("titleBar");
        r0 = null;
    L5:
        r0.setCenterTitle("");
        b r4 = this.adapter;
        if (r4 != null) goto L8;
        d.h.b.o.c("adapter");
        r4 = null;
    L8:
        r4.a("", d.a.p.b(), d.a.p.b(), null);
    }

    private final void renderError(String r3, String r4) {
        this.collectionSkills = d.a.p.b();
        OFloatingTitleBar r0 = this.titleBar;
        b r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("titleBar");
        r0 = null;
    L5:
        r0.setCenterTitle(r3);
        b r2 = this.adapter;
        if (r2 != null) goto L8;
        d.h.b.o.c("adapter");
    L9:
        r1.a(r4, d.a.p.b(), d.a.p.b(), r4);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void renderCollection(com.obric.aiagent.skill.manager.impl.al r8) {
        OFloatingTitleBar r0 = this.titleBar;
        String r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("titleBar");
        r0 = null;
    L5:
        r0.setCenterTitle(valueOrDash(r8.a()));
        List<com.obric.aiagent.skill.manager.api.e> r2 = r8.c();
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r8.d(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L17;
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == true) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L7;
        r4.add(r6);
        goto L7
    L11:
        r7 = false;
        goto L12
    L17:
        List<String> r9 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        this.collectionSkills = r2;
        b r10 = this.adapter;
        if (r10 != null) goto L20;
        d.h.b.o.c("adapter");
        r10 = null;
    L20:
        String r11 = valueOrDash(r8.b());
        if (r2.isEmpty() == true) goto L23;
    L25:
        r10.a(r11, r2, r9, r1);
        return;
    L23:
        if (r9.isEmpty() == false) goto L25;
        r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_no_content, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_no_content"));
        goto L25
    }

    private final void ensureSkillObserverStarted() {
        ISkillManagerService r0 = this.skillManager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.skillStateJob == null) goto L8;
        return;
    L8:
        kotlinx.coroutines.b.ak r1 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r0.observeInstalledSkills()), kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L11;
        return;
    L11:
        this.skillStateJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r1, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void installSkill(com.obric.aiagent.skill.manager.api.e r11) {
        ISkillManagerService r0 = this.skillManager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return;
    L9:
        if (this.processingSkillSlugs.add(r11.a()) == true) goto L11;
        return;
    L11:
        this.completedSkillSlugs.remove(r11.a());
        b r1 = this.adapter;
        if (r1 != null) goto L14;
        d.h.b.o.c("adapter");
        r1 = null;
    L14:
        r1.g();
        kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r0, r11, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void scheduleCompletionClear(String r7) {
        kotlinx.coroutines.i.a(this.mainScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void upsertLatestInstalledSkill(com.obric.aiagent.skill.manager.api.e r6) {
        Iterator r0 = ((List) ZeusTransformUtils.preCheckCast(this.latestInstalledSkills, List.class, "com.obric.aiagent.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r6.a()) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < 0) goto L12;
        this.latestInstalledSkills.set(r1, r6);
        return;
    L12:
        ((Collection) ZeusTransformUtils.preCheckCast(this.latestInstalledSkills, Collection.class, "com.obric.aiagent.plugin")).add(r6);
        return;
    L9:
        r1 = -1;
        goto L10
    }

    private final void refreshListInstalledState() {
        b r0 = this.adapter;
        if (r0 != null) goto L5;
        d.h.b.o.c("adapter");
        r0 = null;
    L5:
        r0.g();
    }

    private final void openSkillDetail(com.obric.aiagent.skill.manager.api.e r5) {
        launchFloatingActivity(SkillDetailPreviewActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r5.a(), r5.d(), br.f20662a.b()));
    }

    private final void useSkill(final com.obric.aiagent.skill.manager.api.e r3) {
        co.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), r3, new $$Lambda$SkillCollectionDetailActivity$iIs5dw4H9ZRrowvE2wa77vU14Ag(r3, this));
    }

    private static final d.x useSkill$lambda$6(com.obric.aiagent.skill.manager.api.e r8, SkillCollectionDetailActivity r9) {
        final SkillCollectionDetailActivity r10 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r9, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
        if (r8.l() == true) goto L7;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r10, Activity.class, "com.obric.aiagent.plugin"), cm.a.i);
        return d.x.f38692a;
    L7:
        if (r.a(r.f20808a, (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin"), r10.skillManager, r8.a(), null, new $$Lambda$SkillCollectionDetailActivity$qRKFGWpnLLi7jHnXse0nMpx8Uk(r10), 8, null) == false) goto L10;
        r10.finish();
    L10:
        return d.x.f38692a;
    }

    private static final d.x useSkill$lambda$6$lambda$5(SkillCollectionDetailActivity r2, String r3) {
        SkillCollectionDetailActivity r4 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "message");
        r4.showUseError(r3);
        return d.x.f38692a;
    }

    private final void showUseError(String r3) {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L6;
        ee.f19808a.c("SkillManager", "Open collection skill chat failed", "Open collection skill chat failed: " + r3);
        return;
    }

    private final void openUsageExample(com.obric.aiagent.skill.manager.impl.ui.e r11) {
        r.a(r.f20808a, (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), this.skillManager, r11, null, this.collectionSkills, new $$Lambda$SkillCollectionDetailActivity$c3Aa94ZqGY0cJCYwVhW3ZT9JfZg(this), null, 64, null);
    }

    private static final d.x openUsageExample$lambda$7(SkillCollectionDetailActivity r2, String r3) {
        SkillCollectionDetailActivity r4 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "message");
        r4.showUseError(r3);
        return d.x.f38692a;
    }

    private final String valueOrDash(String r2) {
        if (r2 != null) goto L4;
    L8:
        return "-";
    L4:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L8;
        return r2;
    }

    static /* synthetic */ void setCollectionItemMargins$default(SkillCollectionDetailActivity r6, View r7, float r8, float r9, float r10, float r11, int r12, Object r13) {
        SkillCollectionDetailActivity r0 = (SkillCollectionDetailActivity) ZeusTransformUtils.wrapperContextForParams(r6, SkillCollectionDetailActivity.class, "com.obric.aiagent.plugin");
        if ((r12 & 2) == 0) goto L5;
        float r3 = 0.0f;
    L7:
        if ((r12 & 8) == 0) goto L9;
        float r5 = 0.0f;
    L10:
        r0.setCollectionItemMargins(r7, r8, r3, r10, r5);
        return;
    L9:
        r5 = r11;
        goto L10
    L5:
        r3 = r9;
        goto L7
    }

    private final void setCollectionItemMargins(View r4, float r5, float r6, float r7, float r8) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        int r9 = dp(r5);
        int r10 = dp(r6);
        int r11 = dp(r7);
        int r3 = dp(r8);
        if (r1.getMarginStart() == r9) goto L11;
    L17:
        r1.setMarginStart(r9);
        r1.topMargin = r10;
        r1.setMarginEnd(r11);
        r1.bottomMargin = r3;
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        if (r1.topMargin != r10) goto L17;
        if (r1.getMarginEnd() != r11) goto L17;
        if (r1.bottomMargin != r3) goto L17;
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final int dp(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private final com.obric.aiagent.skill.manager.api.e withInstalledState(com.obric.aiagent.skill.manager.api.e r1, com.obric.aiagent.skill.manager.api.e r2) {
        return new p(r1, r2).a();
    }

    private final com.obric.aiagent.skill.manager.api.e withLatestInstalledState(com.obric.aiagent.skill.manager.api.e r6) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.latestInstalledSkills, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r6.a()) == false) goto L4;
    L10:
        return withInstalledState(r6, (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"));
    L8:
        r1 = null;
        goto L10
    }
}
