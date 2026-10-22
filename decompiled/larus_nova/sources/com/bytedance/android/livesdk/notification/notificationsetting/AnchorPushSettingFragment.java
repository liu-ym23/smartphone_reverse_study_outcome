package com.bytedance.android.livesdk.notification.notificationsetting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import bn2.d;
import bn2.e;
import bn2.f;
import bn2.g;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.livesdk.dynamic.util.OffsetLinearLayoutManager;
import com.bytedance.android.livesdk.notification.notificationsetting.viewbinder.AnchorNotificationFooterViewBinder;
import com.bytedance.android.livesdk.notification.notificationsetting.viewbinder.AnchorNotificationTitleViewBinder;
import com.bytedance.android.livesdk.notification.notificationsetting.viewbinder.AnchorNotifyViewBinder;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import fz.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/notification/notificationsetting/AnchorPushSettingFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lbn2/d$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPushSettingFragment extends BaseFragment implements d.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f154091t = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f154092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f154093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f154094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f154095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MultiTypeAdapter f154096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f154097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f154098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f154099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Toolbar f154100l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f154101m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f154102n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f154103o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f154104p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f154105q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f154106r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f154107s;

    public static final class a {
    }

    static {
    }

    public AnchorPushSettingFragment() {
        this.f154107s = fm3.d.b();
    }

    @Override // bn2.d.a
    public final void eD(boolean r100) {
        this.f154093e = r100;
        this.f154092d = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        IESStatusBarUtil.transparencyBar(getActivity());
        if (this.f154107s == false) goto L6;
        IESStatusBarUtil.statusBarLightMode(getActivity());
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Intrinsics.checkNotNullParameter(r100, "view");
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.recycler_view);
        this.f154095g = r102;
        if (r102 == null) goto L5;
        r102.setLayoutManager(new OffsetLinearLayoutManager(getActivity()));
    L5:
        this.f154098j = (ImageView) r100.findViewById(R.id.back_pre_iv);
        this.f154094f = r100.findViewById(R.id.root_view);
        this.f154099k = (TextView) r100.findViewById(R.id.title_tv);
        this.f154100l = (Toolbar) r100.findViewById(R.id.toolbar);
        this.f154101m = (LinearLayout) r100.findViewById(R.id.network_error_layout);
        this.f154102n = (TextView) r100.findViewById(R.id.retry_button);
        this.f154103o = (TextView) r100.findViewById(R.id.tv_desc);
        this.f154104p = (TextView) r100.findViewById(R.id.tv_title);
        this.f154105q = (ImageView) r100.findViewById(R.id.iv_empty);
        this.f154106r = r100.findViewById(R.id.toolbar_line);
        TextView r103 = this.f154103o;
        if (r103 == null) goto L8;
        r103.setText(s1.B(R.string.ttlive_notification_setting_retry_tip));
    L8:
        TextView r104 = this.f154104p;
        if (r104 == null) goto L12;
        r104.setText(s1.B(R.string.ttlive_notification_setting_network_error));
    L12:
        if (this.f154107s == false) goto L43;
        TextView r105 = this.f154099k;
        if (r105 == null) goto L16;
        r105.setTextColor(s1.h(R.color.ttlive_color_161823));
    L16:
        Toolbar r106 = this.f154100l;
        if (r106 == null) goto L19;
        r106.setBackgroundColor(s1.h(R.color.ttlive_notification_backbround_light));
    L19:
        ImageView r107 = this.f154098j;
        if (r107 == null) goto L22;
        r107.setImageResource(R.drawable.ttlive_dynamic_back_light);
    L22:
        View r108 = this.f154094f;
        if (r108 == null) goto L25;
        r108.setBackgroundColor(s1.h(R.color.ttlive_notification_backbround_light));
    L25:
        TextView r109 = this.f154102n;
        if (r109 == null) goto L28;
        r109.setTextColor(s1.h(R.color.ttlive_color_161823));
    L28:
        ImageView r110 = this.f154105q;
        if (r110 == null) goto L31;
        r110.setImageResource(R.drawable.ttlive_bg_live_loading_error);
    L31:
        TextView r111 = this.f154104p;
        if (r111 == null) goto L34;
        r111.setTextColor(s1.h(R.color.ttlive_color_161823));
    L34:
        TextView r112 = this.f154103o;
        if (r112 == null) goto L37;
        r112.setTextColor(s1.h(R.color.ttlive_color_99_161823));
    L37:
        TextView r113 = this.f154102n;
        if (r113 == null) goto L40;
        r113.setBackgroundResource(R.drawable.ttlive_notify_setting_network_error_retry_light);
    L40:
        View r114 = this.f154106r;
        if (r114 == null) goto L73;
        r114.setBackgroundColor(s1.h(R.color.ttlive_notification_setting_control_line_light));
    L73:
        ImageView r115 = this.f154098j;
        if (r115 == null) goto L76;
        r115.setOnClickListener(new f(this));
    L76:
        TextView r116 = this.f154102n;
        if (r116 == null) goto L79;
        r116.setOnClickListener(new g(this));
    L79:
        RecyclerView r117 = this.f154095g;
        if (r117 == null) goto L82;
        r117.addOnScrollListener(new AnchorPushSettingFragment$initView$3(this));
    L82:
        d r118 = new d(new bn2.a(), this);
        this.f154097i = r118;
        r118.f19718b = getContext();
        d r119 = this.f154097i;
        if (r119 == null) goto L91;
        boolean r120 = this.f154107s;
        MultiTypeAdapter r121 = new MultiTypeAdapter();
        r119.f19717a = r121;
        r121.z2(AnchorNotificationFooterViewBinder.a.class, new AnchorNotificationFooterViewBinder(r120));
        MultiTypeAdapter r122 = r119.f19717a;
        if (r122 == null) goto L87;
        r122.z2(b.class, new AnchorNotificationTitleViewBinder(r120));
    L87:
        MultiTypeAdapter r123 = r119.f19717a;
        if (r123 == null) goto L90;
        r123.z2(cn2.a.class, new AnchorNotifyViewBinder(r120, new e(r119)));
    L90:
        MultiTypeAdapter r124 = r119.f19717a;
    L92:
        this.f154096h = r124;
        RecyclerView r125 = this.f154095g;
        if (r125 == null) goto L95;
        r125.setAdapter(r124);
    L95:
        d r126 = this.f154097i;
        if (r126 == null) goto L99;
        r126.c();
        return;
    L99:
        return;
    L91:
        r124 = null;
        goto L92
    L43:
        TextView r127 = this.f154099k;
        if (r127 == null) goto L46;
        r127.setTextColor(s1.h(R.color.ttlive_color_FFFFFF));
    L46:
        Toolbar r128 = this.f154100l;
        if (r128 == null) goto L49;
        r128.setBackgroundColor(s1.h(R.color.ttlive_notification_background_black));
    L49:
        ImageView r129 = this.f154098j;
        if (r129 == null) goto L52;
        r129.setImageResource(R.drawable.ttlive_dynamic_back);
    L52:
        View r130 = this.f154094f;
        if (r130 == null) goto L55;
        r130.setBackgroundColor(s1.h(R.color.ttlive_notification_background_black));
    L55:
        TextView r131 = this.f154102n;
        if (r131 == null) goto L58;
        r131.setTextColor(s1.h(R.color.ttlive_color_E6_FFFFFF));
    L58:
        ImageView r132 = this.f154105q;
        if (r132 == null) goto L61;
        r132.setImageResource(R.drawable.ttlive_bg_network_error);
    L61:
        TextView r133 = this.f154104p;
        if (r133 == null) goto L64;
        r133.setTextColor(s1.h(R.color.ttlive_color_E6_FFFFFF));
    L64:
        TextView r134 = this.f154103o;
        if (r134 == null) goto L67;
        r134.setTextColor(s1.h(R.color.ttlive_color_80_FFFFFF));
    L67:
        TextView r135 = this.f154102n;
        if (r135 == null) goto L70;
        r135.setBackgroundResource(R.drawable.ttlive_notify_setting_network_error_retry);
    L70:
        View r136 = this.f154106r;
        if (r136 == null) goto L73;
        r136.setBackgroundColor(s1.h(R.color.ttlive_notification_setting_control_line));
        goto L73
    }

    @Override // bn2.d.a
    public final void uf(boolean r100, boolean r101) {
        this.f154093e = r100;
        this.f154092d = false;
        if (r101 == true) goto L8;
        LinearLayout r102 = this.f154101m;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_fragment_live_push_notification_setting, r101, false);
    }
}
