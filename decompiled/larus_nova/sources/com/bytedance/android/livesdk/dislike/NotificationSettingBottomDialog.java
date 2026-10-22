package com.bytedance.android.livesdk.dislike;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.dislike.layout.NotificationSettingItemLayout;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/NotificationSettingBottomDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NotificationSettingBottomDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f122014u = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionsManager f122015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<w> f122016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f122017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f122018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HSImageView f122019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f122020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f122021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f122022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f122023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f122024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f122025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f122026o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Long f122027p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f122028q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageModel f122029r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f122030s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f122031t;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f122032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f122033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f122034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f122035d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ImageModel f122036e;

        public a() {
        }

        public final NotificationSettingBottomDialog a() {
            int r100 = NotificationSettingBottomDialog.f122014u;
            Intrinsics.checkNotNullParameter(this, "builder");
            NotificationSettingBottomDialog r101 = new NotificationSettingBottomDialog();
            r101.f122028q = this.f122035d;
            r101.f122025n = this.f122032a;
            r101.f122027p = this.f122034c;
            r101.f122026o = this.f122033b;
            r101.f122029r = this.f122036e;
            return r101;
        }
    }

    public interface b {
        void onFailure();

        void onSuccess(String r100, long r101);
    }

    public static final class c {
    }

    public static final class d implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationSettingBottomDialog f122037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f122038b;

        @Override // com.bytedance.android.livesdk.dislike.m
        public final /* synthetic */ String a() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final /* synthetic */ void b() {
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final /* synthetic */ boolean c() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final /* synthetic */ void refreshData() {
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void dismiss() {
            this.f122037a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r100 = DialogFragmentLancet.sLastShowStack;
            if (r100 == null) goto L12;
            com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public Context getContext() {
            return this.f122038b.getContext();
        }

        public d(NotificationSettingBottomDialog r100, View r101) {
            this.f122037a = r100;
            this.f122038b = r101;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationSettingBottomDialog f122039a;

        public e(NotificationSettingBottomDialog r100) {
            this.f122039a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f122039a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public NotificationSettingBottomDialog() {
        this.f122016e = new ArrayList();
        this.f122030s = 44.0f;
        this.f122031t = 40.0f;
        setNoTitleAndCancelOutside(true);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled() == true) goto L11;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L16;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L16:
        return;
    L11:
        if (TTLiveSDK.hostService().hostBusiness().isLivePushOpen() == true) goto L18;
        TTLiveSDK.hostService().hostBusiness().updateLivePushOpen();
        f2.i(getContext(), s1.B(R.string.ttlive_notificaton_live_setting_push_is_open), 0);
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 != null) goto L5;
        return;
    L5:
        if (getActivity() != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(this.f122025n, "setting") == false) goto L9;
    L10:
        Window r101 = r100.getWindow();
        if (r101 == null) goto L13;
        r101.setBackgroundDrawableResource(android.R.color.transparent);
    L13:
        Window r102 = r100.getWindow();
        if (r102 == null) goto L16;
        WindowManager.LayoutParams r103 = r102.getAttributes();
    L17:
        if (r103 == null) goto L19;
        r103.dimAmount = 0.6f;
    L19:
        Window r104 = r100.getWindow();
        if (r104 == null) goto L26;
        r104.setAttributes(r103);
        return;
    L26:
        return;
    L16:
        r103 = null;
        goto L17
    L9:
        if (Intrinsics.areEqual(this.f122025n, "others_homepage") == true) goto L10;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setBackgroundDrawable(new ColorDrawable(s1.h(R.color.ttlive_color_00_000000)));
        r102.setGravity(80);
        r102.setLayout(-1, -2);
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.dimAmount = 0.0f;
        r102.setAttributes(r103);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_CommonBottomDialog);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        d r100 = new d(this, r110);
        Room r101 = null;
        String r102 = this.f122025n;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this.f122015d = new ActionsManager(r100, r101, r102, "", Boolean.FALSE, 32);
        LinearLayout r112 = (LinearLayout) r110.findViewById(R.id.setting_item_layout);
        this.f122017f = (LinearLayout) r110.findViewById(R.id.user_info);
        this.f122020i = (TextView) r110.findViewById(R.id.user_name);
        this.f122019h = (HSImageView) r110.findViewById(R.id.user_avatar);
        this.f122021j = (ImageView) r110.findViewById(R.id.setting_cancel);
        this.f122023l = r110.findViewById(R.id.tips_layout);
        this.f122022k = (TextView) r110.findViewById(R.id.notification_setting_title);
        this.f122018g = (FrameLayout) r110.findViewById(R.id.notification_setting_layout);
        String r113 = this.f122025n;
        boolean r103 = true;
        if (r113 == null) goto L55;
        int r104 = r113.hashCode();
        if (r104 == (-326696768)) goto L42;
        if (r104 == 809483594) goto L37;
        if (r104 != 1985941072) goto L55;
        if (r113.equals("setting") == false) goto L55;
        View r114 = this.f122023l;
        if (r114 == null) goto L20;
        r114.setVisibility(8);
    L20:
        LinearLayout r115 = this.f122017f;
        if (r115 == null) goto L23;
        r115.setVisibility(0);
    L23:
        LinearLayout r116 = this.f122017f;
        if (r116 == null) goto L28;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117 == null) goto L28;
        r117.height = (int) UIUtils.dip2Px(getContext(), this.f122030s);
    L28:
        FrameLayout r118 = this.f122018g;
        if (r118 == null) goto L33;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if (r119 == null) goto L33;
        r119.height = (int) UIUtils.dip2Px(getContext(), this.f122031t);
    L33:
        TextView r120 = this.f122022k;
        if (r120 == null) goto L55;
        r120.setText(s1.B(R.string.ttlive_notification_setting_aweme));
        goto L55
    L37:
        if (r113.equals("others_homepage") == false) goto L55;
        TextView r121 = this.f122022k;
        if (r121 == null) goto L55;
        r121.setText(s1.B(R.string.ttlive_notification_setting_aweme));
        goto L55
    L42:
        if (r113.equals(com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK) == false) goto L55;
        ImageView r122 = this.f122021j;
        if (r122 == null) goto L46;
        r122.setVisibility(8);
    L46:
        TextView r123 = this.f122022k;
        if (r123 == null) goto L49;
        a1.j(r123, 1);
    L49:
        TextView r124 = this.f122022k;
        if (r124 == null) goto L52;
        a1.m(r124, 0);
    L52:
        TextView r125 = this.f122022k;
        if (r125 == null) goto L55;
        r125.setText(s1.B(R.string.ttlive_notification_setting));
    L55:
        ImageView r126 = this.f122021j;
        if (r126 == null) goto L58;
        r126.setOnClickListener(new e(this));
    L58:
        String r127 = this.f122028q;
        if (r127 == null) goto L63;
        TextView r105 = this.f122020i;
        if (r105 == null) goto L63;
        r105.setText(r127);
    L63:
        ImageModel r128 = this.f122029r;
        if (r128 == null) goto L69;
        HSImageView r106 = this.f122019h;
        if (j40.k.f497248a.getValue().booleanValue() == false) goto L68;
        ImageLoader.bindImage(r106, r128, R.drawable.ttlive_img_avatar_empty);
        goto L69
    L68:
        com.bytedance.android.livesdk.chatroom.utils.a1.v(r106, r128, R.drawable.ttlive_img_avatar_empty);
    L69:
        List<w> r129 = this.f122016e;
        Long r107 = this.f122027p;
        if (r107 != null) goto L73;
    L75:
        boolean r108 = false;
    L76:
        nt1.b r109 = new nt1.b(R.drawable.ttlive_notification_setting_push_all_push_icon_light, R.string.ttlive_notification_setting_all_push, r108);
        ActionsManager r130 = this.f122015d;
        if (r130 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mActionsManager");
    L79:
        com.bytedance.android.livesdk.dislike.action.c r131 = new com.bytedance.android.livesdk.dislike.action.c(r130, this.f122026o, this.f122024m);
        ItemType r132 = ItemType.LIVE_NOTIFICATION;
        ArrayList r133 = (ArrayList) r129;
        r133.add(new w(r109, r131, r132));
        if (((IHostBusiness) jc1.k.n(IHostBusiness.class)).isEnablePersonalRecommend() == false) goto L92;
        List<w> r134 = this.f122016e;
        Long r135 = this.f122027p;
        if (r135 != null) goto L85;
    L87:
        boolean r136 = false;
    L88:
        nt1.b r137 = new nt1.b(R.drawable.ttlive_notification_setting_personalise_push_icon_light, R.string.ttlive_notification_setting_personalise_push, r136);
        ActionsManager r138 = this.f122015d;
        if (r138 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("mActionsManager");
    L91:
        ArrayList r139 = (ArrayList) r134;
        r139.add(new w(r137, new com.bytedance.android.livesdk.dislike.action.t(r138, this.f122026o, this.f122024m), r132));
        goto L92
    L85:
        if (r135.longValue() != 2) goto L87;
        r136 = true;
    L92:
        List<w> r140 = this.f122016e;
        Long r141 = this.f122027p;
        if (r141 != null) goto L96;
    L98:
        r103 = false;
    L99:
        nt1.b r142 = new nt1.b(R.drawable.ttlive_notification_setting_push_no_push_icon_light, R.string.ttlive_notification_setting_no_push, r103);
        ActionsManager r143 = this.f122015d;
        if (r143 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("mActionsManager");
    L102:
        ArrayList r144 = (ArrayList) r140;
        r144.add(new w(r142, new com.bytedance.android.livesdk.dislike.action.q(r143, this.f122026o, this.f122024m), r132));
        Iterator r145 = ((ArrayList) this.f122016e).iterator();
    L104:
        if (r145.hasNext() == false) goto L108;
        w r146 = (w) r145.next();
        Context r147 = getContext();
        if (r147 == null) goto L104;
        NotificationSettingItemLayout r148 = new NotificationSettingItemLayout(r147);
        r148.setOnClickListener(new v(r146));
        r148.update(r146.f122239c);
        r112.addView(r148);
        goto L104
    L108:
        return;
    L96:
        if (r141.longValue() != 3) goto L98;
    L73:
        if (r107.longValue() != 1) goto L75;
        r108 = true;
        goto L76
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_notification_setting_bottom_options, r101, false);
    }
}
