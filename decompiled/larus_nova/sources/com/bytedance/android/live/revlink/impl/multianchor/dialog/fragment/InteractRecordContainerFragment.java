package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractLinkRecordFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkRecordFragment;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdk.widget.LinkNoScrollViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/InteractRecordContainerFragment;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/RevInteractDialogFragmentBaseContract$View;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/g;", "Lcom/bytedance/android/livesdk/widget/LinkNoScrollViewPager$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractRecordContainerFragment extends RevInteractDialogFragmentBaseContract$View<com.bytedance.android.live.revlink.impl.control.dialog.g<?>> implements LinkNoScrollViewPager.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f93429o = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, View> f93430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DataCenter f93431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InteractPkRecordFragment f93432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public InteractLinkRecordFragment f93433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f93434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f93435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f93436m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f93437n;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.InteractRecordContainerFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/InteractRecordContainerFragment$onViewCreated$1", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class AnonymousClass1 extends FragmentStatePagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractRecordContainerFragment f93438a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.f93438a.f93434k;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public final Fragment getItem(int r110) {
            if (r110 == 0) goto L5;
            boolean r111 = true;
        L6:
            String r100 = "pk_banner";
            Integer r101 = null;
            if (r111 == false) goto L30;
            InteractRecordContainerFragment r112 = this.f93438a;
            InteractPkRecordFragment r102 = r112.f93432i;
            if (r102 != null) goto L52;
            int r103 = InteractPkRecordFragment.E;
            com.bytedance.android.live.revlink.impl.control.dialog.r r104 = r112.f92314d;
            DataCenter r113 = r112.f93431h;
            Intrinsics.checkNotNull(r113);
            int r105 = this.f93438a.f93435l;
            Intrinsics.checkNotNullParameter(r113, "dataCenter");
            Intrinsics.checkNotNullParameter("", "activityName");
            InteractPkRecordFragment r106 = new InteractPkRecordFragment();
            r106.f92316f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.o(r106);
            r106.f92314d = r104;
            yz0.k r107 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
            if (r107 == null) goto L13;
            IRoom r108 = r107.getRoom();
        L14:
            r106.f95735j = r108;
            r106.f95741p = new com.bytedance.android.live.revlink.impl.pk.utils.m();
            r106.f95739n = r105;
            r106.f95738m = false;
            r106.f95745t = false;
            r106.f95746u = "";
            r106.f95747v = null;
            r106.f95748w = null;
            r106.B = true;
            r106.C = false;
            Function1<CharSequence, Unit> r114 = new InteractRecordContainerFragment$onViewCreated$1$getItem$1(this);
            Intrinsics.checkNotNullParameter(r114, "onFilterSelect");
            r106.f95750y = r114;
            InteractRecordContainerFragment r115 = this.f93438a;
            if (r115.f93436m == true) goto L18;
            r100 = "link_banner";
        L18:
            r106.f95733h = r100;
            LinkNoScrollViewPager r116 = (LinkNoScrollViewPager) r115.ba0(R.id.record_vp);
            if (r116 != null) goto L21;
        L28:
            this.f93438a.f93432i = r106;
            Fragment r109 = r106;
        L53:
            return r109;
        L21:
            if (r116.getCurrentItem() != 1) goto L28;
            if (r106.D == true) goto L28;
            Function1<? super CharSequence, Unit> r117 = r106.f95750y;
            if (r117 == null) goto L27;
            Unit r118 = r117.invoke(r106.f95749x);
        L27:
            r106.ha0();
            r106.D = true;
            goto L28
        L13:
            r108 = null;
            goto L14
        L52:
            return r102;
        L30:
            InteractRecordContainerFragment r119 = this.f93438a;
            InteractLinkRecordFragment r120 = r119.f93433j;
            if (r120 != null) goto L54;
            int r121 = InteractLinkRecordFragment.A;
            com.bytedance.android.live.revlink.impl.control.dialog.r r122 = r119.f92314d;
            DataCenter r123 = r119.f93431h;
            Intrinsics.checkNotNull(r123);
            int r124 = this.f93438a.f93435l;
            Intrinsics.checkNotNullParameter(r123, "dataCenter");
            InteractLinkRecordFragment r125 = new InteractLinkRecordFragment();
            r125.f92316f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.b(r125);
            r125.f92314d = r122;
            r125.f95616i = r123;
            yz0.k r126 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
            if (r126 == null) goto L35;
            IRoom r127 = r126.getRoom();
        L36:
            r125.f95617j = r127;
            r125.f95622o = new com.bytedance.android.live.revlink.impl.pk.utils.m();
            r125.f95620m = r124;
            r125.f95626s = false;
            r125.f95631x = true;
            r125.f95632y = false;
            Function1<CharSequence, Unit> r128 = new InteractRecordContainerFragment$onViewCreated$1$getItem$2(this);
            Intrinsics.checkNotNullParameter(r128, "onFilterSelect");
            r125.f95628u = r128;
            InteractRecordContainerFragment r129 = this.f93438a;
            if (r129.f93436m == true) goto L40;
            r100 = "link_banner";
        L40:
            r125.f95615h = r100;
            LinkNoScrollViewPager r130 = (LinkNoScrollViewPager) r129.ba0(R.id.record_vp);
            if (r130 == null) goto L44;
            r101 = Integer.valueOf(r130.getCurrentItem());
        L44:
            if (r101.intValue() == 0) goto L46;
        L51:
            this.f93438a.f93433j = r125;
            r109 = r125;
            goto L53
        L46:
            if (r125.f95633z == true) goto L51;
            Function1<? super CharSequence, Unit> r131 = r125.f95628u;
            if (r131 == null) goto L50;
            Unit r132 = r131.invoke(r125.f95627t);
        L50:
            r125.ha0();
            r125.f95633z = true;
            goto L51
        L35:
            r127 = null;
            goto L36
        L54:
            return r120;
        L5:
            r111 = false;
            goto L6
        }

        public AnonymousClass1(InteractRecordContainerFragment r100, FragmentManager r101) {
            this.f93438a = r100;
            super(r101);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.widget.LinkNoScrollViewPager.a
    public final boolean rB() {
        return true;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        r11.p r100 = b51.b.f17721c0.j();
        if (r100.getEnable() == true) goto L5;
        return 432.0f;
    L5:
        return t6.d(s1.getContext(), t6.b(s1.getContext()) * r11.q.a(r100)) - 48;
    }

    public InteractRecordContainerFragment() {
        this.f93430g = new LinkedHashMap();
        this.f93434k = 2;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f93430g).clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        return this.f93437n;
    }

    public final View ba0(int r100) {
        if (this.f93430g != null) goto L5;
        this.f93430g = new LinkedHashMap();
    L5:
        View r101 = this.f93430g.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f93430g.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public static final void ca0(InteractRecordContainerFragment r100, int r101) {
        LinkNoScrollViewPager r102 = (LinkNoScrollViewPager) r100.ba0(R.id.record_vp);
        if (r102 != null) goto L5;
    L6:
        LinkNoScrollViewPager r103 = (LinkNoScrollViewPager) r100.ba0(R.id.record_vp);
        if (r103 == null) goto L11;
        r103.setCurrentItem(r101);
        return;
    L11:
        return;
    L5:
        if (r102.getCurrentItem() != r101) goto L6;
    }

    public final void da0(TabLayout.Tab r100, boolean r110) {
        if (r100 == null) goto L4;
        CharSequence r101 = r100.getText();
    L5:
        String r102 = String.valueOf(r101);
        int r103 = r102.length() - 1;
        int r104 = 0;
        boolean r105 = false;
    L6:
        if (r104 > r103) goto L21;
        if (r105 == true) goto L9;
        int r106 = r104;
    L11:
        if (Intrinsics.compare(r102.charAt(r106), 32) > 0) goto L13;
        boolean r107 = true;
    L14:
        if (r105 == false) goto L15;
        if (r107 == false) goto L21;
        r103 = r103 - 1;
        goto L6
    L15:
        if (r107 == false) goto L16;
        r104 = r104 + 1;
        goto L6
    L16:
        r105 = true;
        goto L6
    L13:
        r107 = false;
        goto L14
    L9:
        r106 = r103;
    L21:
        String r108 = r102.subSequence(r104, r103 + 1).toString();
        SpannableString r109 = new SpannableString(r108);
        r109.setSpan(new StyleSpan(r110 ? 1 : 0), 0, r108.length(), 17);
        if (r100 == null) goto L35;
        r100.setText(r109);
        return;
    L35:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        ((LinkNoScrollViewPager) ba0(R.id.record_vp)).setScrollEnable(this);
        ((LinkNoScrollViewPager) ba0(R.id.record_vp)).setOffscreenPageLimit(this.f93434k);
        FragmentManager r111 = getFragmentManager();
        if (r111 == null) goto L5;
        ((LinkNoScrollViewPager) ba0(R.id.record_vp)).setAdapter(new AnonymousClass1(this, r111));
    L5:
        ba0(R.id.view_line).setBackgroundColor(-1);
        ViewGroup r112 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_interact_record_container_top, null);
        this.f93437n = r112;
        if (r112 == null) goto L56;
        TabLayout r101 = (TabLayout) r112.findViewById(R.id.tab);
        int r102 = this.f93434k;
    L9:
        int r103 = r102 - 1;
        if (r102 <= 0) goto L14;
        if (r101 == null) goto L13;
        r101.addTab(r101.newTab());
    L13:
        r102 = r103;
        goto L9
    L14:
        TabLayout r104 = (TabLayout) r112.findViewById(R.id.tab);
        if (r104 == null) goto L17;
        r104.setupWithViewPager((ViewPager) ba0(R.id.record_vp));
    L17:
        TabLayout r105 = (TabLayout) r112.findViewById(R.id.tab);
        if (r105 == null) goto L22;
        TabLayout.Tab r106 = r105.getTabAt(0);
        if (r106 == null) goto L22;
        r106.setText(s1.B(R.string.ttlive_interact_link_record));
    L22:
        TabLayout r107 = (TabLayout) r112.findViewById(R.id.tab);
        if (r107 == null) goto L27;
        TabLayout.Tab r108 = r107.getTabAt(1);
        if (r108 == null) goto L27;
        r108.setText(s1.B(R.string.ttlive_interact_pk_record));
    L27:
        TabLayout r109 = (TabLayout) r112.findViewById(R.id.tab);
        if (r109 == null) goto L30;
        r109.addOnTabSelectedListener(new x(this));
    L30:
        TabLayout r113 = (TabLayout) r112.findViewById(R.id.tab);
        if (r113 == null) goto L40;
        TabLayout.Tab r114 = r113.getTabAt(0);
        if (r114 == null) goto L40;
        Object r115 = JavaCalls.getField(r114, "view");
        if ((r115 instanceof View) == true) goto L37;
        r115 = null;
    L37:
        View r116 = (View) r115;
        if (r116 == null) goto L40;
        r116.setOnClickListener(new y(this, r112));
    L40:
        TabLayout r117 = (TabLayout) r112.findViewById(R.id.tab);
        if (r117 == null) goto L50;
        TabLayout.Tab r118 = r117.getTabAt(1);
        if (r118 == null) goto L50;
        Object r119 = JavaCalls.getField(r118, "view");
        if ((r119 instanceof View) == true) goto L47;
        r119 = null;
    L47:
        View r120 = (View) r119;
        if (r120 == null) goto L50;
        r120.setOnClickListener(new z(this, r112));
    L50:
        TabLayout r121 = (TabLayout) r112.findViewById(R.id.tab);
        if (r121 == null) goto L53;
        r121.setSelectedTabIndicatorColor(0);
    L53:
        TabLayout r122 = (TabLayout) r112.findViewById(R.id.tab);
        if (r122 == null) goto L56;
        r122.setSelectedTabIndicatorHeight(0);
    L56:
        ViewGroup r123 = this.f93437n;
        if (r123 == null) goto L59;
        View r124 = r123.findViewById(R.id.iv_back);
    L60:
        ImageView r125 = (ImageView) r124;
        if (r125 == null) goto L63;
        r125.setOnClickListener(new a0(this));
    L63:
        ViewGroup r126 = this.f93437n;
        if (r126 == null) goto L66;
        View r127 = r126.findViewById(R.id.tv_filter);
    L67:
        TextView r128 = (TextView) r127;
        if (r128 == null) goto L70;
        r128.setOnClickListener(new b0(this));
    L70:
        ((LinkNoScrollViewPager) ba0(R.id.record_vp)).addOnPageChangeListener(new AnonymousClass2(this));
        if (this.f93436m == false) goto L73;
        ((LinkNoScrollViewPager) ba0(R.id.record_vp)).setCurrentItem(1);
    L74:
        int r129 = this.f93434k;
        int r130 = 0;
    L75:
        if (r130 >= r129) goto L97;
        if (r130 != ((LinkNoScrollViewPager) ba0(R.id.record_vp)).getCurrentItem()) goto L87;
        ViewGroup r131 = this.f93437n;
        if (r131 == null) goto L81;
        View r132 = r131.findViewById(R.id.tab);
    L82:
        TabLayout r133 = (TabLayout) r132;
        if (r133 == null) goto L85;
        TabLayout.Tab r134 = r133.getTabAt(r130);
    L86:
        da0(r134, true);
    L96:
        r130 = r130 + 1;
        goto L75
    L85:
        r134 = null;
        goto L86
    L81:
        r132 = null;
        goto L82
    L87:
        ViewGroup r135 = this.f93437n;
        if (r135 == null) goto L90;
        View r136 = r135.findViewById(R.id.tab);
    L91:
        TabLayout r137 = (TabLayout) r136;
        if (r137 == null) goto L94;
        TabLayout.Tab r138 = r137.getTabAt(r130);
    L95:
        da0(r138, false);
        goto L96
    L94:
        r138 = null;
        goto L95
    L90:
        r136 = null;
        goto L91
    L97:
        p11.d r139 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getPerfManager();
        if (r139 == null) goto L100;
        r139.b();
    L100:
        ((com.bytedance.android.livesdk.revenue.service.room.a) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.a.class)).checkDegradeForNative("anchor_invite_panel");
        return;
    L73:
        ((LinkNoScrollViewPager) ba0(R.id.record_vp)).setCurrentItem(0);
        goto L74
    L66:
        r127 = null;
        goto L67
    L59:
        r124 = null;
        goto L60
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_interact_record_container, r101, false);
    }
}
