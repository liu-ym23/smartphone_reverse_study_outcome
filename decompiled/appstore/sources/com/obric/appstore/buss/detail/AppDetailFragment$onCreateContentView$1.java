package com.obric.appstore.buss.detail;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppScreenShotsKt;
import com.bytedanceos.common.model.Category;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.obric.appstore.R;
import com.obric.appstore.ui.adapter.HorGridAppsItemProvider;
import com.obric.appstore.util.ViewUtilsKt;
import com.obric.oui.chip.OChipGroup;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/appstore/buss/detail/a;", "it", "", "invoke", "(Lcom/obric/appstore/buss/detail/a;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAppDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDetailFragment.kt\ncom/obric/appstore/buss/detail/AppDetailFragment$onCreateContentView$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,573:1\n40#2:574\n56#2:575\n304#2,2:576\n304#2,2:578\n304#2,2:582\n304#2,2:587\n283#2,2:589\n304#2,2:591\n304#2,2:593\n283#2,2:595\n304#2,2:597\n1#3:580\n1855#4:581\n1856#4:584\n37#5,2:585\n*S KotlinDebug\n*F\n+ 1 AppDetailFragment.kt\ncom/obric/appstore/buss/detail/AppDetailFragment$onCreateContentView$1\n*L\n284#1:574\n284#1:575\n327#1:576,2\n330#1:578,2\n356#1:582,2\n394#1:587,2\n430#1:589,2\n434#1:591,2\n438#1:593,2\n443#1:595,2\n446#1:597,2\n355#1:581\n355#1:584\n390#1:585,2\n*E\n"})
public final class AppDetailFragment$onCreateContentView$1 extends Lambda implements Function1<com.obric.appstore.buss.detail.a, Unit> {
    final /* synthetic */ sa.p $binding;
    final /* synthetic */ AppDetailFragment this$0;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sa.p f10625a;

        public a(sa.p r10) {
            this.f10625a = r10;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
            q.g(r10, "view");
            r10.removeOnLayoutChangeListener(this);
            this.f10625a.f24648m.setMinimumHeight(r10.getMeasuredHeight());
        }
    }

    public AppDetailFragment$onCreateContentView$1(AppDetailFragment r10, sa.p r11) {
        this.this$0 = r10;
        this.$binding = r11;
        super(1);
    }

    public static /* synthetic */ void a(AppInfo r10, AppDetailFragment r11, View r12) {
        invoke$lambda$11$lambda$0(r10, r11, r12);
    }

    public static /* synthetic */ void b(AppDetailFragment r10, sa.p r11, AppInfo r12, View r13) {
        invoke$lambda$11$lambda$1(r10, r11, r12, r13);
    }

    public static /* synthetic */ void c(Category r10, AppDetailFragment r11, Category r12, View r13) {
        invoke$lambda$21$lambda$20$lambda$19$lambda$18(r10, r11, r12, r13);
    }

    public static /* synthetic */ void d(AppInfo r10, AppDetailFragment r11, View r12) {
        invoke$lambda$11$lambda$3(r10, r11, r12);
    }

    public static /* synthetic */ void e(AppDetailFragment r10, AppInfo r11, sa.p r12, View r13) {
        invoke$lambda$11$lambda$7$lambda$6(r10, r11, r12, r13);
    }

    public static /* synthetic */ void f(AppDetailFragment r10, AppInfo r11, View r12) {
        invoke$lambda$11$lambda$8(r10, r11, r12);
    }

    private static final void invoke$lambda$11$lambda$0(AppInfo r10, AppDetailFragment r11, View r12) {
        q.g(r10, "$appInfo");
        q.g(r11, "this$0");
        String r13 = r10.appDeveloperId;
        q.f(r13, "appDeveloperId");
        if (r13.length() <= 0) goto L6;
        com.obric.appstore.util.n r14 = com.obric.appstore.util.n.f11086a;
        FragmentActivity r15 = r11.getActivity();
        String r16 = r10.appDeveloperId;
        q.f(r16, "appDeveloperId");
        String r17 = r10.appDeveloper;
        q.f(r17, "appDeveloper");
        r14.g(r15, r16, r17);
        return;
    }

    private static final void invoke$lambda$11$lambda$1(AppDetailFragment r10, sa.p r11, AppInfo r12, View r13) {
        q.g(r10, "this$0");
        q.g(r11, "$binding");
        q.g(r12, "$appInfo");
        l8.a.a(r10.getActivity(), r11.f24642g, r12, r10.getPageSource());
    }

    private static final void invoke$lambda$11$lambda$3(AppInfo r10, AppDetailFragment r11, View r12) {
        q.g(r10, "$appInfo");
        q.g(r11, "this$0");
        String r13 = r10.appDeveloperId;
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.length() == 0) goto L10;
        com.obric.appstore.util.n r14 = com.obric.appstore.util.n.f11086a;
        FragmentActivity r15 = r11.getActivity();
        String r16 = r10.appDeveloperId;
        q.f(r16, "appDeveloperId");
        r14.g(r15, r16, p.c(r10));
        return;
    }

    private static final void invoke$lambda$11$lambda$7$lambda$6(AppDetailFragment r10, AppInfo r11, sa.p r12, View r13) {
        q.g(r10, "this$0");
        q.g(r11, "$appInfo");
        q.g(r12, "$binding");
        com.obric.appstore.util.n.f11086a.c(r10.getActivity(), r11, r12.f24657v.indexOfChild(r13));
    }

    private static final void invoke$lambda$11$lambda$8(AppDetailFragment r10, AppInfo r11, View r12) {
        q.g(r10, "this$0");
        q.g(r11, "$appInfo");
        com.obric.appstore.util.n.f11086a.b(r10.getActivity(), r11);
    }

    private static final void invoke$lambda$21$lambda$20$lambda$19$lambda$18(Category r10, AppDetailFragment r11, Category r12, View r13) {
        q.g(r11, "this$0");
        if (r10 == null) goto L5;
        com.obric.appstore.util.n r14 = com.obric.appstore.util.n.f11086a;
        FragmentActivity r15 = r11.getActivity();
        String r16 = r10.getName();
        q.f(r16, "getName(...)");
        String r17 = r10.getId();
        q.f(r17, "getId(...)");
        String r18 = r12.getId();
        q.f(r18, "getId(...)");
        r14.f(r15, r16, r17, r18);
        return;
    L5:
        com.obric.appstore.util.n r19 = com.obric.appstore.util.n.f11086a;
        FragmentActivity r20 = r11.getActivity();
        String r21 = r12.getName();
        q.f(r21, "getName(...)");
        String r22 = r12.getId();
        q.f(r22, "getId(...)");
        r19.f(r20, r21, r22, "");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.obric.appstore.buss.detail.a r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable com.obric.appstore.buss.detail.a r29) {
        Context r10 = this.this$0.getContext();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r29 == null) goto L10;
        AppInfo r11 = r29.a();
        if (r11 == null) goto L10;
        List r12 = p.a(r11);
        if (r12 == null) goto L10;
    L11:
        boolean r13 = true;
        final Category r14 = null;
        Object r15 = null;
        r14 = null;
        if (r29 == null) goto L67;
        final AppInfo r16 = r29.a();
        if (r16 == null) goto L67;
        final sa.p r17 = this.$binding;
        final AppDetailFragment r18 = this.this$0;
        r17.f24642g.setBriefOnClickListener(new g(r16, r18));
        r17.f24642g.setBtnOnClickListener(new h(r18, r17, r16));
        r17.f24642g.i(r16, r18.getPageSource());
        r17.f24641f.e(r16.appIcon, tc.f.i(32));
        r17.f24643h.setText(r16.appName);
        r17.f24655t.setText(r16.appName);
        r17.f24655t.setTextSize(14.0f);
        r17.f24644i.setText(r16.appName);
        TextView r19 = r17.f24645j;
        SizeConverter r110 = SizeConverter.BTrim;
        r19.setText(r110.convert(r16.appBytes));
        r17.f24656u.setText(r110.convert(r16.appBytes));
        ConstraintLayout r111 = r17.f24660y;
        q.f(r111, "shrinkLocator");
        r111.addOnLayoutChangeListener(new a(r17));
        OTextView r112 = r17.f24640e;
        if (r112 != null) goto L19;
        r112 = null;
    L19:
        if (r112 == null) goto L21;
        r112.setChangeAlphaWhenPress(true);
    L21:
        r17.f24640e.setText(p.b(r16));
        r17.f24640e.setOnClickListener(new i(r16, r18));
        OChipGroup r113 = r17.f24651p;
        q.f(r113, "categoryContainer");
        ViewUtilsKt.a(r113, r12, new AppDetailFragment$onCreateContentView$1$1$5(r18), new AppDetailFragment$onCreateContentView$1$1$6(r18, r12));
        OChipGroup r114 = r17.f24651p;
        q.f(r114, "categoryContainer");
        if (r12.isEmpty() == false) goto L24;
        int r115 = 8;
    L25:
        r114.setVisibility(r115);
        r17.f24657v.removeAllViews();
        LinearLayout r116 = r17.f24657v;
        q.f(r116, "imagesContainer");
        r116.setVisibility(8);
        Map<String, List<String>> r117 = r16.appScreenShotsBySize;
        if (r117 == null) goto L34;
        List<String> r118 = r117.get(AppScreenShotsKt.Size540);
        if (r118 == null) goto L34;
        if (r118.isEmpty() == false) goto L33;
        r118 = null;
    L33:
        if (r118 == null) goto L34;
    L44:
        if (r118 != null) goto L46;
        r118 = t.i();
    L46:
        Iterator<T> r119 = r118.iterator();
    L48:
        if (r119.hasNext() == false) goto L50;
        String r120 = (String) r119.next();
        LinearLayout r121 = r17.f24657v;
        q.f(r121, "imagesContainer");
        r121.setVisibility(0);
        sa.k r122 = sa.k.c(r18.getLayoutInflater(), r17.f24657v, false);
        q.f(r122, "inflate(...)");
        r17.f24657v.addView(r122.b());
        r122.f24598b.setDefaultImageResId(R.drawable.screenshot_default);
        r122.f24598b.setImageUrl(r120);
        r122.b().setOnClickListener(new j(r18, r16, r17));
        goto L48
    L50:
        r17.f24638c.setOnClickListener(new k(r18, r16));
        TextView r20 = r17.f24637b;
        String r123 = r16.recmd_brief;
        if (r123 == null) goto L60;
        q.d(r123);
        if (r123.length() <= 0) goto L55;
        Object[] r124 = true;
    L56:
        if (r124 == true) goto L59;
        r123 = null;
    L59:
        if (r123 == null) goto L60;
    L61:
        if (r123 != null) goto L63;
        r123 = "";
    L63:
        String r125 = kotlin.text.o.x(kotlin.text.o.x(r123, "\n", "", false, 4, null), "<br/>", "", false, 4, null);
        if (r125.length() != 0) goto L66;
        r125 = r18.getString(R.string.appinfo_tab_left_name);
        q.f(r125, "getString(...)");
    L66:
        r20.setText(r125);
        r17.f24646k.updateDownloadStatus(r16);
        r17.B.setText(r10.getString(R.string.app_detail_label_version, new Object[]{r16.appVersionName}));
        goto L67
    L55:
        r124 = false;
    L60:
        r123 = r16.appBrief;
    L34:
        Map<String, List<String>> r126 = r16.appScreenShotsBySize;
        if (r126 == null) goto L41;
        r118 = r126.get(AppScreenShotsKt.Size1080);
        if (r118 == null) goto L41;
        if (r118.isEmpty() == true) goto L41;
    L42:
        if (r118 != null) goto L44;
        r118 = r16.appScreenSnaps;
    L41:
        r118 = null;
        goto L42
    L24:
        r115 = 0;
    L67:
        List r21 = t.n(new String[]{this.this$0.getString(R.string.appinfo_tab_left_name)});
        if (r29 == null) goto L72;
        RelationApps r22 = r29.c();
        if (r22 == null) goto L72;
        r21.add(r22.d());
    L72:
        if (r29 == null) goto L76;
        ClassicApps r23 = r29.b();
        if (r23 == null) goto L76;
        r21.add(r23.c());
    L76:
        this.$binding.f24650o.n((String[]) r21.toArray(new String[0]), null);
        if (r29 == null) goto L85;
        ClassicApps r24 = r29.b();
        if (r24 == null) goto L85;
        List r25 = r24.a();
        if (r25 == null) goto L85;
        if ((!r25.isEmpty()) != true) goto L85;
    L87:
        if (r29 == null) goto L115;
        RelationApps r26 = r29.c();
        if (r26 == null) goto L115;
        sa.p r127 = this.$binding;
        final AppDetailFragment r128 = this.this$0;
        LinearLayout r129 = r127.f24659x.b();
        q.f(r129, "getRoot(...)");
        r129.setVisibility(0);
        HorGridAppsItemProvider.a r130 = HorGridAppsItemProvider.f11014d;
        sa.b r131 = r127.f24659x;
        q.f(r131, "relationApps");
        r130.b(r131);
        String r132 = r128.getString(R.string.app_detail_relation_title, new Object[]{r26.c()});
        q.f(r132, "getString(...)");
        sa.b r27 = r127.f24659x;
        q.f(r27, "relationApps");
        r130.a(r27, r128.getPageSource(), r132, r26.a());
        String r28 = r26.b();
        Iterator r30 = r12.iterator();
    L92:
        if (r30.hasNext() == false) goto L96;
        Object r133 = r30.next();
        if (q.b(((Category) r133).getId(), r28) == false) goto L92;
    L97:
        final Category r134 = (Category) r133;
        if (r134 == null) goto L108;
        String r31 = r134.getParent_id();
        if (r31 == null) goto L108;
        q.d(r31);
        Iterator r32 = r12.iterator();
    L103:
        if (r32.hasNext() == false) goto L107;
        Object r33 = r32.next();
        if (q.b(((Category) r33).getId(), r31) == false) goto L103;
        r15 = r33;
    L107:
        r14 = (Category) r15;
    L108:
        if (r134 == null) goto L110;
        sa.l r34 = sa.l.c(r128.getLayoutInflater());
        r34.b().setOnClickListener(new l(r14, r128, r134));
        q.f(r34, "apply(...)");
        OPanelTitleBar r35 = r127.f24659x.f24566d;
        q.f(r35, "pagerTitle");
        LinearLayout r36 = r34.b();
        q.f(r36, "getRoot(...)");
        AppDetailFragment.c0(r128, r35, r36);
        r127.f24659x.f24566d.setActionView(r34.b());
    L110:
        View r37 = r127.f24659x.f24564b;
        q.f(r37, "divider");
        if (r13 == true) goto L113;
        int r38 = 4;
    L114:
        r37.setVisibility(r38);
    L116:
        if (r29 == null) goto L120;
        ClassicApps r39 = r29.b();
        if (r39 == null) goto L120;
        sa.p r40 = this.$binding;
        AppDetailFragment r41 = this.this$0;
        LinearLayout r42 = r40.f24652q.b();
        q.f(r42, "getRoot(...)");
        r42.setVisibility(0);
        HorGridAppsItemProvider.a r43 = HorGridAppsItemProvider.f11014d;
        sa.b r44 = r40.f24652q;
        q.f(r44, "classicApps");
        r43.b(r44);
        sa.b r45 = r40.f24652q;
        q.f(r45, "classicApps");
        r43.a(r45, r41.getPageSource(), r39.b(), r39.a());
        View r46 = r40.f24652q.f24564b;
        q.f(r46, "divider");
        r46.setVisibility(4);
        return;
    L120:
        LinearLayout r47 = this.$binding.f24652q.b();
        q.f(r47, "getRoot(...)");
        r47.setVisibility(8);
        return;
    L113:
        r38 = 0;
        goto L114
    L96:
        r133 = null;
    L115:
        LinearLayout r48 = this.$binding.f24659x.b();
        q.f(r48, "getRoot(...)");
        r48.setVisibility(8);
    L85:
        r13 = false;
    L10:
        r12 = t.i();
        goto L11
    }
}
