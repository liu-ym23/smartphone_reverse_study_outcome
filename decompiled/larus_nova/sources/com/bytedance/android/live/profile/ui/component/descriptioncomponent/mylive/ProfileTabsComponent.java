package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.base.model.user.MyLiveTab;
import com.bytedance.android.live.base.model.user.MyLiveTabs;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.utils.TabDataHelper;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class ProfileTabsComponent extends com.bytedance.android.live.profile.ui.base.k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f86573m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f86574n = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<b> f86575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f86576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f86577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TabLayout f86578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f86579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewPager2 f86580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f86581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f86582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f86583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f86584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.profile.ui.base.h f86585l;

    public static final class a {
    }

    public interface b {
        void a(int r100, boolean r101);
    }

    public static final class c implements m.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashSet<Integer> f86586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProfileTabsComponent f86587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TabLayout f86588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f86589d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ MyLiveTabs f86590e;

        public final int c() {
            List<MyLiveTab> r100 = this.f86590e.getTabs();
            if (r100 == null) goto L14;
            Iterator<T> r101 = r100.iterator();
            int r102 = 0;
        L6:
            if (r101.hasNext() == false) goto L18;
            Object r103 = r101.next();
            int r104 = r102 + 1;
            if (r102 >= 0) goto L11;
            CollectionsKt.throwIndexOverflow();
        L11:
            if (Intrinsics.areEqual(((MyLiveTab) r103).getBizName(), this.f86590e.getDefaultTab()) == true) goto L12;
            r102 = r104;
            goto L6
        L12:
            return r102;
        L18:
            return -1;
        L14:
            return -1;
        }

        @Override // com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.m.b
        public final void b(int r100) {
            List<b> r101 = this.f86587b.f86575b;
            if (r101 == null) goto L8;
            Iterator r102 = ((ArrayList) r101).iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            ((b) r102.next()).a(r100, !this.f86586a.contains(Integer.valueOf(r100)));
        L8:
            this.f86586a.add(Integer.valueOf(r100));
            int r103 = this.f86588c.getTabCount();
            int r104 = 0;
        L9:
            if (r104 >= r103) goto L31;
            TabLayout.Tab r105 = this.f86588c.getTabAt(r104);
            View r106 = null;
            if (r105 == null) goto L13;
            View r107 = r105.getCustomView();
        L15:
            if ((r107 instanceof TextView) == false) goto L18;
            r106 = r107;
        L18:
            TextView r108 = (TextView) r106;
            if (r105 != null) goto L21;
        L26:
            if (r108 == null) goto L28;
            r108.setTextColor(ProfileTabsComponent.f86573m);
        L28:
            if (r108 == null) goto L30;
            r108.setTypeface(Typeface.defaultFromStyle(0));
        L30:
            r104 = r104 + 1;
            goto L9
        L21:
            if (r105.getPosition() != r100) goto L26;
            if (r108 == null) goto L24;
            r108.setTextColor(ProfileTabsComponent.f86574n);
        L24:
            if (r108 == null) goto L30;
            r108.setTypeface(Typeface.defaultFromStyle(1));
            goto L30
        L13:
            r107 = null;
            goto L15
        L31:
            ProfileTabsComponent r109 = this.f86587b;
            String r110 = "";
            if (r109.f86583j < 0) goto L49;
            List<MyLiveTab> r111 = this.f86590e.getTabs();
            if (r111 == null) goto L39;
            MyLiveTab r112 = (MyLiveTab) CollectionsKt.getOrNull(r111, this.f86587b.f86583j);
            if (r112 == null) goto L39;
            String r113 = r112.getBizName();
            if (r113 == null) goto L39;
        L40:
            List<MyLiveTab> r114 = this.f86590e.getTabs();
            if (r114 == null) goto L48;
            MyLiveTab r115 = (MyLiveTab) CollectionsKt.getOrNull(r114, r100);
            if (r115 == null) goto L48;
            String r116 = r115.getBizName();
            if (r116 == null) goto L48;
            r110 = r116;
        L48:
            ProfileTabsComponent.j(r109, r113, r110);
        L58:
            this.f86587b.f86583j = r100;
            return;
        L39:
            r113 = "";
            goto L40
        L49:
            List<MyLiveTab> r117 = this.f86590e.getTabs();
            if (r117 == null) goto L57;
            MyLiveTab r118 = (MyLiveTab) CollectionsKt.getOrNull(r117, r100);
            if (r118 == null) goto L57;
            String r119 = r118.getBizName();
            if (r119 == null) goto L57;
            r110 = r119;
        L57:
            ProfileTabsComponent.j(r109, "my_live", r110);
            goto L58
        }

        @Override // com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.m.b
        public final void a(TabLayout.Tab r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "tab");
            TextView r102 = new TextView(this.f86588c.getContext());
            String r103 = (String) CollectionsKt.getOrNull(this.f86589d, r101);
            if (r103 != null) goto L6;
            r103 = "";
        L6:
            r102.setText(r103);
            r102.setGravity(17);
            r102.setTextColor(ProfileTabsComponent.f86573m);
            r102.setTextSize(1, 15.0f);
            r100.setCustomView(r102);
        }

        public c(ProfileTabsComponent r100, TabLayout r101, List r102, MyLiveTabs r103) {
            this.f86587b = r100;
            this.f86588c = r101;
            this.f86589d = r102;
            this.f86590e = r103;
            this.f86586a = new HashSet();
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "newUser");
    }

    static {
        f86573m = ColorProtector.parseColor("#99161823");
        f86574n = ColorProtector.parseColor("#161823");
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        m r100 = this.f86581h;
        if (r100 == null) goto L8;
        RecyclerView.Adapter<?> r101 = r100.f86642d;
        if (r101 == null) goto L7;
        r101.unregisterAdapterDataObserver(r100.f86646h);
        r100.f86646h = null;
    L7:
        r100.f86639a.removeOnTabSelectedListener(r100.f86645g);
        r100.f86640b.unregisterOnPageChangeCallback(r100.f86644f);
        r100.f86645g = null;
        r100.f86644f = null;
        r100.f86642d = null;
        r100.f86643e = false;
    L8:
        this.f86583j = -1;
        com.bytedance.android.live.profile.ui.base.m r102 = com.bytedance.android.live.profile.ui.base.i.n(this.f86585l);
        if (r102 == null) goto L11;
        r102.a(this.f86584k);
    L11:
        List<b> r103 = this.f86575b;
        if (r103 == null) goto L14;
        ((ArrayList) r103).clear();
    L14:
        this.f86582i.clear();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.TabsComponent.INSTANCE;
    }

    public ProfileTabsComponent(com.bytedance.android.live.profile.profilecontext.a r100) {
        Intrinsics.checkNotNullParameter(r100, "profileContext");
        this.f86585l = r100;
        this.f86582i = new CompositeDisposable();
        this.f86583j = -1;
        this.f86584k = new h(this);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r100) {
        ((com.bytedance.android.live.profile.ui.base.e) r100).f(R.layout.ttlive_profile_tabs_component_layout, true);
        this.f86576c = i(R.id.my_live_tabs_error_container);
        this.f86577d = i(R.id.my_live_tabs_container);
        this.f86578e = (TabLayout) i(R.id.tab_layout);
        this.f86579f = i(R.id.tab_layout_container_dress_bg);
        ViewPager2 r101 = (ViewPager2) i(R.id.view_pager);
        this.f86580g = r101;
        if (r101 == null) goto L6;
        int r102 = com.bytedance.android.live.profile.ui.base.i.a(this.f86585l) - UtilityKotlinExtentionsKt.i(40);
        int r103 = com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.a.f86610i;
        a1.k(r101, r102 - UtilityKotlinExtentionsKt.i(52));
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.viewpager2.widget.ViewPager2] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r110) {
        Intrinsics.checkNotNullParameter(r110, "user");
        ProfileOpenArea r100 = r110.openArea;
        String r101 = null;
        if (r100 == null) goto L5;
        final MyLiveTabs r102 = r100.myLiveTabs;
    L7:
        if (r102 != null) goto L15;
        View r111 = this.f86576c;
        if (r111 == null) goto L11;
        r111.setVisibility(0);
    L11:
        View r112 = this.f86577d;
        if (r112 == null) goto L81;
        r112.setVisibility(8);
        return;
    L81:
        return;
    L15:
        View r103 = this.f86576c;
        if (r103 == null) goto L18;
        r103.setVisibility(8);
    L18:
        View r104 = this.f86577d;
        if (r104 == null) goto L21;
        r104.setVisibility(0);
    L21:
        final TabLayout r105 = this.f86578e;
        if (r105 != null) goto L24;
        return;
    L24:
        ?? r106 = this.f86580g;
        if (r106 != 0) goto L27;
        return;
    L27:
        List<MyLiveTab> r107 = r102.getTabs();
        if (r107 == null) goto L35;
        ?? r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L31:
        if (r109.hasNext() == false) goto L36;
        String r113 = ((MyLiveTab) r109.next()).getTitle();
        if (r113 == null) goto L31;
        r108.add(r113);
    L36:
        TabAdapter r114 = new TabAdapter(this.f86585l.getRoomDataCenter(), this.f86585l, this);
        r114.f86592b = new ProfileTabsComponent$bindUserData$$inlined$apply$lambda$1(this, r105, r102);
        List<MyLiveTab> r115 = r102.getTabs();
        if (r115 != null) goto L39;
        r115 = CollectionsKt.emptyList();
    L39:
        Intrinsics.checkNotNullParameter(r115, "tabs");
        Iterator r116 = ((ArrayList) r114.f86591a).iterator();
    L41:
        if (r116.hasNext() == false) goto L43;
        ((TabDataHelper) r116.next()).getClass();
        goto L41
    L43:
        ((ArrayList) r114.f86591a).clear();
        Iterator r117 = r115.iterator();
    L45:
        if (r117.hasNext() == false) goto L47;
        MyLiveTab r118 = (MyLiveTab) r117.next();
        ((ArrayList) r114.f86591a).add(new TabDataHelper(r118));
        goto L45
    L47:
        r114.notifyDataSetChanged();
        Unit r119 = Unit.INSTANCE;
        r106.setAdapter(r114);
        c r120 = new c(this, r105, r108, r102);
        m r121 = new m(r105, r106, r120);
        if (r121.f86643e == true) goto L73;
        RecyclerView.Adapter<?> r122 = r106.getAdapter();
        r121.f86642d = r122;
        if (r122 == null) goto L71;
        r121.f86643e = true;
        m.c r123 = new m.c(r121.f86639a, r121.f86641c);
        r121.f86644f = r123;
        r106.registerOnPageChangeCallback(r123);
        m.d r124 = new m.d(r106, true);
        r121.f86645g = r124;
        r105.addOnTabSelectedListener(r124);
        m.a r125 = new m.a(r121);
        r121.f86646h = r125;
        r121.f86642d.registerAdapterDataObserver(r125);
        r121.a();
        int r126 = r120.c();
        if (r126 < 0) goto L54;
        r106.setCurrentItem(r126, false);
    L54:
        r105.setScrollPosition(r106.getCurrentItem(), 0.0f, true);
        this.f86581h = r121;
        ProfileSkin r127 = r110.mProfileSkin;
        if (r127 == null) goto L63;
        ProfileCustomSkin r128 = r127.skin;
        if (r128 == null) goto L63;
        ProfileCustomSkin.BgUI r129 = r128.bgSkin;
        if (r129 == null) goto L63;
        ProfileCustomSkin.GradientColor r130 = r129.bgColor;
        if (r130 == null) goto L63;
        r101 = r130.from;
    L63:
        View r131 = this.f86579f;
        if (r131 == null) goto L66;
        com.bytedance.android.live.profile.ui.util.m.f(r131, r101);
    L66:
        com.bytedance.android.live.profile.ui.base.m r132 = com.bytedance.android.live.profile.ui.base.i.n(this.f86585l);
        if (r132 == null) goto L82;
        r132.d(this.f86584k);
        return;
    L82:
        return;
    L71:
        throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
    L73:
        throw new IllegalStateException("TabLayoutMediator is already attached");
    L35:
        r108 = CollectionsKt.emptyList();
        goto L36
    L5:
        r102 = null;
        goto L7
    }

    public static final void j(ProfileTabsComponent r100, String r101, String r102) {
        r100.getClass();
        LinkedHashMap r103 = new LinkedHashMap();
        IMiddlewareUserService r104 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r104 == null) goto L8;
        com.bytedance.android.livesdk.user.e r105 = r104.user();
        if (r105 == null) goto L8;
        String r106 = r105.n();
        if (r106 == null) goto L8;
    L9:
        r103.put("user_id", r106);
        r103.put("previous_page", r101);
        r103.put(CheckPointType.ENTER_PAGE, r102);
        j0.l().sendLog("livesdk_my_live_my_page_enter", r103, new Object[0]);
        return;
    L8:
        r106 = "0";
        goto L9
    }
}
