package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkResultDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkResultDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f71928k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f71929l = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f71930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f71931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f71932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f71933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f71934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f71935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BannerWidget.a f71936j;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LinkResultDialogFragment a(g1 r100, BannerWidget.a r101) {
            Intrinsics.checkNotNullParameter(r100, "leaveChannelRsp");
            String r102 = LinkResultDialogFragment.f71928k;
            StringCompanionObject r103 = StringCompanionObject.INSTANCE;
            ALogger.d(r102, String.format("newInstance, leaveChannelRsp: %s", Arrays.copyOf(new Object[]{r100}, 1)));
            LinkResultDialogFragment r104 = new LinkResultDialogFragment();
            Bundle r105 = new Bundle();
            r105.putLong("KEY_LINK_DURATION", r100.getLink_duration());
            u1 r106 = r100.getUserInfoDuringLinkmic();
            long r107 = 0;
            if (r106 == null) goto L5;
            long r108 = r106.getAddFollowerCount();
        L6:
            r105.putLong("KEY_ADD_FOLLOWER_COUNT", r108);
            u1 r109 = r100.getUserInfoDuringLinkmic();
            if (r109 == null) goto L9;
            r107 = r109.getScoreBeyond();
        L9:
            r105.putLong("KEY_SCORE_BEYOND", r107);
            u1 r110 = r100.getUserInfoDuringLinkmic();
            if (r110 == null) goto L13;
            String r111 = r110.getFanTicket();
            if (r111 == null) goto L13;
        L14:
            r105.putString("KEY_FAN_TICKET", r111);
            r104.setArguments(r105);
            r104.f71936j = r101;
            return r104;
        L13:
            r111 = "0";
            goto L14
        L5:
            r108 = 0;
            goto L6
        }
    }

    static {
        f71929l = new a();
        f71928k = "LinkResultDialogFragment";
    }

    public LinkResultDialogFragment() {
        this.f71930d = new LinkedHashMap();
        this.f71931e = new CompositeDisposable();
        this.f71935i = "0";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f71931e.clear();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f71930d).clear();
    }

    public final View S90(int r100) {
        if (this.f71930d != null) goto L5;
        this.f71930d = new LinkedHashMap();
    L5:
        View r101 = this.f71930d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f71930d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L13;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L14;
        View r103 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L11:
        r103.setPadding(0, 0, 0, 0);
        r102.setLayout(-1, -1);
        r102.setGravity(80);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setSoftInputMode(48);
        c1.b(r102, 0, 14);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_live_interact_dialog);
        Bundle r101 = getArguments();
        long r102 = 0;
        if (r101 == null) goto L5;
        long r103 = r101.getLong("KEY_LINK_DURATION", 0);
    L6:
        this.f71932f = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L9;
        long r105 = r104.getLong("KEY_ADD_FOLLOWER_COUNT", 0);
    L10:
        this.f71933g = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L13;
        r102 = r106.getLong("KEY_SCORE_BEYOND", 0);
    L13:
        this.f71934h = r102;
        Bundle r107 = getArguments();
        if (r107 == null) goto L17;
        String r108 = r107.getString("KEY_FAN_TICKET", "0");
        if (r108 == null) goto L17;
    L18:
        this.f71935i = r108;
        if (TextUtils.isEmpty(r108) == false) goto L22;
        this.f71935i = "0";
        return;
    L22:
        return;
    L17:
        r108 = "0";
        goto L18
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        WidgetManager r112 = WidgetManager.of(this, getView());
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L5;
        IRoom r101 = r100.getValue();
    L6:
        r112.load(R.id.fl_banner_lynx_container, new BannerWidget(r101, 25, "chat_effect_feedback_panel", S90(R.id.tv_tips_banner_link_result), this.f71936j));
        int r102 = 0;
        if (this.f71933g <= 0) goto L9;
    L11:
        SpannableStringBuilder r113 = new SpannableStringBuilder();
        String r114 = s1.B(R.string.ttlive_link_result_dialog_profit_tips_prefix);
        String r103 = s1.B(R.string.ttlive_link_result_dialog_profit_tips_postfix);
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        String r105 = String.format("%s%%", Arrays.copyOf(new Object[]{String.valueOf(this.f71934h)}, 1));
        r113.append(r114).append(r105).append(r103);
        r113.setSpan(new ForegroundColorSpan(s1.h(R.color.ttlive_link_result_dialog_profit_color)), r114.length(), r114.length() + r105.length(), 17);
        ((TextView) S90(R.id.tv_tips_link_result)).setText(r113);
    L12:
        long r106 = 60;
        if (this.f71932f >= r106) goto L15;
        ((TextView) S90(R.id.tv_link_duration_value)).setText(String.valueOf(this.f71932f));
        ((TextView) S90(R.id.tv_link_duration_label)).setText(R.string.ttlive_link_result_dialog_label_link_duration_in_second);
    L19:
        ((TextView) S90(R.id.tv_fan_ticket_value)).setText(this.f71935i);
        ((TextView) S90(R.id.tv_add_follower_count_value)).setText(String.valueOf(this.f71933g));
        ((TextView) S90(R.id.tv_feedback)).setOnClickListener(new q(this));
        RxUtilKt.c(xs2.b.a().b(hk0.b.class).subscribe(new o(this), p.f72055a), this.f71931e);
        return;
    L15:
        TextView r115 = (TextView) S90(R.id.tv_link_duration_value);
        long r107 = this.f71932f;
        long r108 = r107 / r106;
        if ((r107 % r106) <= 0) goto L18;
        r102 = 1;
    L18:
        r115.setText(String.valueOf(r108 + ((long) r102)));
        ((TextView) S90(R.id.tv_link_duration_label)).setText(R.string.ttlive_link_result_dialog_label_link_duration_in_minute);
        goto L19
    L9:
        if (TextUtils.equals(this.f71935i, "0") == false) goto L11;
        ((TextView) S90(R.id.tv_tips_link_result)).setText(s1.B(R.string.ttlive_link_result_dialog_normal_tips));
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_link_result, r101, false);
    }
}
