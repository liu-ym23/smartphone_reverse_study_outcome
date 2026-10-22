package com.obric.autoaction.app.launcherpage.discovery.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import com.obric.autoaction.app.launcherpage.a.p;
import com.obric.oui.common.util.g;
import com.obric.oui.orecyclerview.widget.GridLayoutManager;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.status.OPageStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: DiscoveryList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DiscoveryList extends FrameLayout {
    public static final b Companion = null;
    private static final int SPAN_COUNT = 2;
    private final p binding;
    private final com.obric.autoaction.app.launcherpage.ui.d<com.obric.autoaction.app.launcherpage.discovery.a.b> mRvAdapter;

    /* JADX INFO: compiled from: DiscoveryList.kt */
    public static final class a extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DiscoveryList f23665a;

        a(DiscoveryList r1) {
            this.f23665a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.GridLayoutManager.b
        public int a(int r2) {
            com.obric.autoaction.app.launcherpage.discovery.a.b r1 = (com.obric.autoaction.app.launcherpage.discovery.a.b) ZeusTransformUtils.preCheckCast(DiscoveryList.access$getMRvAdapter$p(this.f23665a).b(r2), com.obric.autoaction.app.launcherpage.discovery.a.b.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r1, com.obric.autoaction.app.launcherpage.discovery.a.b.c.class) == false) goto L5;
        L8:
            return 1;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, com.obric.autoaction.app.launcherpage.discovery.a.b.a.class) == true) goto L8;
            return 2;
        }
    }

    /* JADX INFO: compiled from: DiscoveryList.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    static {
        Companion = new b(null);
    }

    public DiscoveryList(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public DiscoveryList(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ al lambda$Pb1KIeJiPYmgJKGLoKAz0fLhNjA(int r0, View r1, al r2) {
        return applyBottomNavInsetPadding$lambda$1(r0, r1, r2);
    }

    public /* synthetic */ DiscoveryList(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.d access$getMRvAdapter$p(DiscoveryList r0) {
        return r0.mRvAdapter;
    }

    public static final /* synthetic */ void access$refreshEmptyView(DiscoveryList r0) {
        r0.refreshEmptyView();
    }

    public DiscoveryList(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        super(r12, r13, r11);
        p r14 = p.a(LayoutInflater.from(r12), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true);
        o.c(r14, "inflate(...)");
        this.binding = r14;
        RecyclerView r2 = r14.f22848b;
        o.c(r2, "rvDiscoveryList");
        com.obric.autoaction.app.launcherpage.ui.d<com.obric.autoaction.app.launcherpage.discovery.a.b> r15 = new com.obric.autoaction.app.launcherpage.ui.d(r2, false, 2, null);
        this.mRvAdapter = r15;
        r14.f22848b.setOverScrollMode(0);
        RecyclerView r3 = r14.f22848b;
        com.obric.autoaction.app.launcherpage.ui.p r5 = new com.obric.autoaction.app.launcherpage.ui.p(r12, 2);
        r5.a((GridLayoutManager.b) ZeusTransformUtils.preCheckCast(new a(this), GridLayoutManager.b.class, "com.obric.aiagent.plugin"));
        r3.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r5, RecyclerView.h.class, "com.obric.aiagent.plugin"));
        r14.f22848b.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new c(g.a(r12, 8), 2), RecyclerView.g.class, "com.obric.aiagent.plugin"));
        r15.a(new Class[]{d.class, com.obric.autoaction.app.launcherpage.discovery.view.a.class, e.class});
        r15.a((RecyclerView.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), RecyclerView.b.class, "com.obric.aiagent.plugin"));
    }

    public final void submitList(List<? extends com.obric.autoaction.app.launcherpage.discovery.a.b> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "list");
        com.obric.autoaction.app.launcherpage.ui.d.a(this.mRvAdapter, r4, null, 2, null);
    }

    public final void setContentTopPadding(int r5) {
        RecyclerView r4 = this.binding.f22848b;
        o.c(r4, "rvDiscoveryList");
        if (r4.getPaddingTop() != r5) goto L5;
        return;
    L5:
        boolean r0 = !r4.canScrollVertically(-1);
        r4.setPadding(r4.getPaddingLeft(), r5, r4.getPaddingRight(), r4.getPaddingBottom());
        if (r0 == false) goto L14;
        RecyclerView.h r6 = r4.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r6, LinearLayoutManager.class) == false) goto L10;
        LinearLayoutManager r7 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r6, LinearLayoutManager.class, "com.obric.aiagent.plugin");
    L11:
        if (r7 == null) goto L15;
        r7.b(0, 0);
        return;
    L15:
        return;
    L10:
        r7 = null;
        goto L11
    }

    public final void addControl(com.obric.autoaction.app.launcherpage.discovery.view.b r4) {
        com.obric.autoaction.app.launcherpage.discovery.view.b r5 = (com.obric.autoaction.app.launcherpage.discovery.view.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.discovery.view.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "control");
        com.obric.autoaction.app.launcherpage.ui.g r3 = this.mRvAdapter.b();
        if (r3.a().containsKey(com.obric.autoaction.app.launcherpage.discovery.view.b.class) == true) goto L7;
        r3.a().put(com.obric.autoaction.app.launcherpage.discovery.view.b.class, (com.obric.autoaction.app.launcherpage.ui.c) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.ui.c.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        throw new RuntimeException("already contains control type :" + com.obric.autoaction.app.launcherpage.discovery.view.b.class);
    }

    public final void applyBottomNavInsetPadding() {
        RecyclerView r4 = this.binding.f22848b;
        o.c(r4, "rvDiscoveryList");
        final int r0 = r4.getPaddingBottom();
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), new $$Lambda$DiscoveryList$Pb1KIeJiPYmgJKGLoKAz0fLhNjA(r0));
        ViewCompat.u((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
    }

    private static final al applyBottomNavInsetPadding$lambda$1(int r4, View r5, al r6) {
        o.e(r5, "view");
        o.e(r6, "insets");
        androidx.core.graphics.g r0 = r6.a(al.m.b());
        o.c(r0, "getInsets(...)");
        androidx.core.graphics.g r2 = r6.a(al.m.e());
        o.c(r2, "getInsets(...)");
        int r1 = Math.max(r0.f1213e, r2.f1213e);
        r5.setPadding(r5.getPaddingLeft(), r5.getPaddingTop(), r5.getPaddingRight(), r4 + r1);
        return r6;
    }

    private final void refreshEmptyView() {
        OPageStatus r0 = this.binding.f22847a;
        if (this.mRvAdapter.a() != 0) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }
}
