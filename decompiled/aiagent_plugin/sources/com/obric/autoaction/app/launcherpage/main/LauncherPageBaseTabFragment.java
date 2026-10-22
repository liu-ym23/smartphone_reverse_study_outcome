package com.obric.autoaction.app.launcherpage.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.r;
import androidx.lifecycle.ao;
import androidx.lifecycle.w;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.base.TaskBaseFragment;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.i;
import d.h.b.o;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: LauncherPageBaseTabFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class LauncherPageBaseTabFragment extends TaskBaseFragment {
    public static final a Companion = null;
    private static final String TAG = "LauncherPageBaseTabFragment";
    private final f mainViewModel$delegate;

    /* JADX INFO: compiled from: LauncherPageBaseTabFragment.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: LauncherPageBaseTabFragment.kt */
    static final class b implements w, i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ d.h.a.b f23955a;

        b(d.h.a.b r3) {
            d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r4, "function");
            this.f23955a = r4;
        }

        @Override // d.h.b.i
        public final d.c<?> a() {
            return (d.c) ZeusTransformUtils.preCheckCast(this.f23955a, d.c.class, "com.obric.aiagent.plugin");
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, w.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, i.class) == true) goto L7;
            return false;
        L7:
            return o.a(((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).a(), ((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin")).a());
        }

        public final int hashCode() {
            return ((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).a().hashCode();
        }

        @Override // androidx.lifecycle.w
        public final /* synthetic */ void onChanged(Object r1) {
            this.f23955a.invoke(r1);
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class c extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f23956a;

        public c(Fragment r1) {
            this.f23956a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23956a.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
            o.b(r2, "requireActivity()");
            ao r3 = r2.getViewModelStore();
            o.b(r3, "requireActivity().viewModelStore");
            return r3;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$jOInpa20DAolJAKQR6IKA8esFoU(LauncherPageBaseTabFragment r0, OFloatingTitleBar r1, int r2) {
        return onAttach$lambda$2$lambda$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$q6EJpr-nqmCDfOX3u1c-6qh_WDw, reason: not valid java name */
    public static /* synthetic */ x m532lambda$q6EJprnqmCDfOX3u1c6qh_WDw(LauncherPageBaseTabFragment r0, Integer r1) {
        return onViewCreated$lambda$0(r0, r1);
    }

    public LauncherPageBaseTabFragment() {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        this.mainViewModel$delegate = r.a(r0, aa.b(com.obric.autoaction.app.launcherpage.main.a.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r0), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
    }

    private final com.obric.autoaction.app.launcherpage.main.a getMainViewModel() {
        return (com.obric.autoaction.app.launcherpage.main.a) ZeusTransformUtils.preCheckCast(this.mainViewModel$delegate.b(), com.obric.autoaction.app.launcherpage.main.a.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        o.e(r3, "view");
        super.onViewCreated(r3, r4);
        getMainViewModel().c().a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin"), (w) ZeusTransformUtils.preCheckCast(new b(new $$Lambda$LauncherPageBaseTabFragment$q6EJprnqmCDfOX3u1c6qh_WDw(this)), w.class, "com.obric.aiagent.plugin"));
    }

    private static final x onViewCreated$lambda$0(LauncherPageBaseTabFragment r0, Integer r1) {
        o.a(r1);
        r0.updateTopPadding(r1.intValue());
        return x.f38692a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super.onAttach(r6);
        final OFloatingTitleBar r7 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar")), OFloatingTitleBar.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        if (r7 == null) goto L14;
        View r0 = getView();     // Catch: Exception -> L9
        if (r0 == null) goto L15;
        com.obric.autoaction.app.launcherpage.utils.p.a(r0, r7, new $$Lambda$LauncherPageBaseTabFragment$jOInpa20DAolJAKQR6IKA8esFoU(this, r7));     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        Loog.INSTANCE.d(TAG, "updateTopPadding fail: " + e);
    }

    private static final x onAttach$lambda$2$lambda$1(LauncherPageBaseTabFragment r4, OFloatingTitleBar r5, int r6) {
        if (o.a(r4.getMainViewModel().b().a(), true) == false) goto L9;
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r4.getMainViewModel().c().a(), Integer.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L7;
        int r8 = r7.intValue();
    L8:
        int r9 = r8 + d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
    L10:
        r4.applyTopInset(r9 + com.obric.autoaction.app.launcherpage.utils.p.a(r5, false, 1, null));
        return x.f38692a;
    L7:
        r8 = 0;
        goto L8
    L9:
        r9 = 0;
        goto L10
    }

    public void applyTopInset(int r4) {
        View r3 = getView();
        if (r3 == null) goto L6;
        r3.setPadding(r3.getPaddingLeft(), r4, r3.getPaddingRight(), r3.getPaddingBottom());
        return;
    }

    private final void updateTopPadding(int r7) {
        OFloatingTitleBar r0 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar")), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r7 != 0) goto L7;
        applyTopInset(com.obric.autoaction.app.launcherpage.utils.p.a(r0, false, 1, null));
        return;
    L7:
        applyTopInset((r7 + d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()))) + com.obric.autoaction.app.launcherpage.utils.p.a(r0, false, 1, null));
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment
    public String getPageEnterFrom() {
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        Intent r3 = r2.getIntent();
        if (r3 == null) goto L8;
        String r4 = r3.getStringExtra("launcher_page_enter_from");
        if (r4 == null) goto L8;
        return r4;
    L8:
        return DownloadSettingKeys.BugFix.DEFAULT;
    }
}
