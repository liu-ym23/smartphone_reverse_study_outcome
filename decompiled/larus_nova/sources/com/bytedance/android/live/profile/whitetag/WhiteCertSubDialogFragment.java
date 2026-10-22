package com.bytedance.android.live.profile.whitetag;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.WhiteCategoryCert;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profile/whitetag/WhiteCertSubDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WhiteCertSubDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f87057j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f87058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WhiteCategoryCert.SubCertInfo f87059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f87060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataCenter f87061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public NewProfileUser f87062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f87063i;

    public static final class a {
        public static void a(Context r100, WhiteCategoryCert.SubCertInfo r101, boolean r102, DataCenter r103, NewProfileUser r104) {
            FragmentActivity r105 = ContextUtil.contextToFragmentActivity(r100);
            if (r105 == null) goto L13;
            WhiteCertSubDialogFragment r106 = new WhiteCertSubDialogFragment();
            r106.f87059e = r101;
            r106.f87060f = r102;
            r106.f87061g = r103;
            r106.f87062h = r104;
            FragmentManager r107 = r105.getSupportFragmentManager();
            LandscapeRestrictionOperation r108 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r106, "WhiteCertSubDialogFragment", r108);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r107, r106, r108) == true) goto L14;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
        L8:
            r106.show(r107, "WhiteCertSubDialogFragment");
            return;
        L14:
            return;
        }
    }

    static {
    }

    public final void T90() {
        WhiteCategoryCert.SubCertInfo r100 = this.f87059e;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.schema;
    L7:
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L17;
        ALogger.e("WhiteCertSubDialogFragment", "schema is null or empty");
        return;
    L17:
        if (S90() == false) goto L24;
        IBaseLiveActionHandler r104 = (IBaseLiveActionHandler) k.f(IBaseLiveActionHandler.class);
        if (r104 == null) goto L38;
        Context r105 = getContext();
        WhiteCategoryCert.SubCertInfo r106 = this.f87059e;
        if (r106 == null) goto L23;
        r101 = r106.schema;
    L23:
        r104.handle(r105, r101);
    L38:
        dismiss();     // Catch: Exception -> L33
        return;
    L33:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r107 = DialogFragmentLancet.sLastShowStack;
        if (r107 == null) goto L40;
        d.d(r107, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L40:
        return;
    L24:
        DataCenter r108 = this.f87061g;
        if (r108 == null) goto L30;
        WhiteCategoryCert.SubCertInfo r109 = this.f87059e;
        if (r109 == null) goto L29;
        r101 = r109.schema;
    L29:
        r108.put("data_white_cert_schema", r101);
    L30:
        xs2.b.a().post(new HorizontalPlayEvent(1));
        goto L38
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    public final boolean S90() {
        Context r100 = getContext();
        if (r100 == null) goto L11;
        Resources r101 = r100.getResources();
        if (r101 == null) goto L11;
        Configuration r102 = r101.getConfiguration();
        if (r102 == null) goto L11;
        if (r102.orientation != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public WhiteCertSubDialogFragment() {
    }

    public final void U90(View r100) {
        TextView r101 = (TextView) r100.findViewById(R.id.button);
        if (r101 != null) goto L5;
        return;
    L5:
        WhiteCategoryCert.SubCertInfo r102 = this.f87059e;
        if (r102 == null) goto L12;
        if (r102.certStatus != 1) goto L12;
        r101.setVisibility(8);
        return;
    L12:
        if (this.f87060f == false) goto L17;
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(0);
        r103.setCornerRadius(UtilityKotlinExtentionsKt.h(2.0f));
        r103.setColor(-1);
        r101.setBackground(r103);
        r101.setText(s1.B(R.string.ttlive_profile_white_cert_no_cert_for_anchor));
        r101.setTextColor(s1.h(R.color.ttlive_color_57_161823));
        r101.setTextSize(1, 13.0f);
        Drawable r104 = s1.m(R.drawable.ttlive_white_cert_no_cert_icon);
        if (r104 == null) goto L16;
        r104.setBounds(0, 0, UtilityKotlinExtentionsKt.i(14), UtilityKotlinExtentionsKt.i(14));
    L16:
        r101.setCompoundDrawables(r104, null, null, null);
        r101.setCompoundDrawablePadding(UtilityKotlinExtentionsKt.i(2));
        a1.p(r101, -2);
        return;
    L17:
        GradientDrawable r105 = new GradientDrawable();
        r105.setShape(0);
        r105.setCornerRadius(UtilityKotlinExtentionsKt.h(2.0f));
        r105.setColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        r101.setBackground(r105);
        r101.setText(s1.B(R.string.ttlive_profile_white_cert_go_to_cert));
        r101.setTextColor(-1);
        r101.setTextSize(1, 15.0f);
        r101.setOnClickListener(new c(new WhiteCertSubDialogFragment$setButtonForAudience$1(this)));
    }

    public final void V90(View r100) {
        HSImageView r101 = (HSImageView) r100.findViewById(R.id.background_icon);
        TextView r102 = (TextView) r100.findViewById(R.id.cert_name);
        HSImageView r103 = (HSImageView) r100.findViewById(R.id.cert_icon);
        TextView r104 = (TextView) r100.findViewById(R.id.cert_short_desc);
        if (S90() == false) goto L5;
        int r105 = s1.y();
    L6:
        int r106 = 0;
        if (r101 == null) goto L9;
        int r107 = a1.f(r101);
    L10:
        int r108 = r105 - r107;
        if (r101 == null) goto L13;
        r106 = a1.g(r101);
    L13:
        int r109 = r108 - r106;
        int r110 = (int) (((double) r109) * 0.21574344023323616d);
        if (r101 == null) goto L16;
        a1.p(r101, r109);
    L16:
        if (r101 == null) goto L18;
        a1.k(r101, r110);
    L18:
        WhiteCategoryCert.SubCertInfo r111 = this.f87059e;
        String r112 = null;
        if (r111 == null) goto L21;
        py.k r113 = r111.background;
    L22:
        ImageLoader.bindImage(r101, r113, r109, r110);
        if (r102 == null) goto L29;
        WhiteCategoryCert.SubCertInfo r114 = this.f87059e;
        if (r114 == null) goto L27;
        String r115 = r114.name;
    L28:
        r102.setText(r115);
        goto L29
    L27:
        r115 = null;
    L29:
        WhiteCategoryCert.SubCertInfo r116 = this.f87059e;
        if (r116 == null) goto L32;
        py.k r117 = r116.smallIcon;
    L33:
        ImageLoader.bindImage(r103, r117);
        if (r104 == null) goto L40;
        WhiteCategoryCert.SubCertInfo r118 = this.f87059e;
        if (r118 == null) goto L38;
        r112 = r118.smallIconDesc;
    L38:
        r104.setText(r112);
        return;
    L40:
        return;
    L32:
        r117 = null;
        goto L33
    L21:
        r113 = null;
        goto L22
    L9:
        r107 = 0;
        goto L10
    L5:
        r105 = UtilityKotlinExtentionsKt.i(340);
        goto L6
    }

    public final void W90(View r110) {
        GradientDrawable r100 = new GradientDrawable();
        r100.setShape(0);
        if (S90() == false) goto L5;
        float r111 = 8;
        float[] r101 = {UtilityKotlinExtentionsKt.h(r111), UtilityKotlinExtentionsKt.h(r111), UtilityKotlinExtentionsKt.h(r111), UtilityKotlinExtentionsKt.h(r111), 0.0f, 0.0f, 0.0f, 0.0f};
    L6:
        r100.setCornerRadii(r101);
        r100.setColor(-1);
        View r112 = r110.findViewById(R.id.root);
        if (r112 == null) goto L10;
        r112.setBackground(r100);
        return;
    L10:
        return;
    L5:
        float r113 = 8;
        r101 = new float[]{UtilityKotlinExtentionsKt.h(r113), UtilityKotlinExtentionsKt.h(r113), UtilityKotlinExtentionsKt.h(r113), UtilityKotlinExtentionsKt.h(r113), UtilityKotlinExtentionsKt.h(r113), UtilityKotlinExtentionsKt.h(r113), UtilityKotlinExtentionsKt.h(r113), UtilityKotlinExtentionsKt.h(r113)};
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L11;
        Window r102 = r101.getWindow();
        if (r102 != null) goto L8;
        return;
    L8:
        if (S90() == true) goto L12;
        r102.setType(1000);
        r102.addFlags(1024);
        r102.setLayout(UtilityKotlinExtentionsKt.i(352), -2);
        r102.setGravity(VideoPlayDataContext.PLAYING_GRAVITY);
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        ALogger.e("WhiteCertSubDialogFragment", "onConfigurationChanged");
        if (S90() == false) goto L30;
        View r101 = this.f87058d;
        if (r101 == null) goto L14;
        W90(r101);
        V90(r101);
        TextView r102 = (TextView) r101.findViewById(R.id.cert_desc);
        if (r102 == null) goto L13;
        WhiteCategoryCert.SubCertInfo r103 = this.f87059e;
        if (r103 == null) goto L11;
        String r104 = r103.desc;
    L12:
        r102.setText(r104);
        goto L13
    L11:
        r104 = null;
    L13:
        U90(r101);
    L14:
        Dialog r105 = getDialog();
        if (r105 == null) goto L31;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L34;
        r106.setLayout(-1, -1);
        r106.setGravity(80);
        View r107 = this.f87058d;
        if (r107 == null) goto L24;
        View r108 = r107.findViewById(R.id.land_root_container);
        if (r108 == null) goto L24;
        a1.p(r108, -1);
    L24:
        View r109 = this.f87058d;
        if (r109 == null) goto L32;
        View r110 = r109.findViewById(R.id.root);
        if (r110 == null) goto L33;
        a1.l(r110, 0);
        a1.n(r110, 0);
        a1.p(r110, -1);
        return;
    L33:
        return;
    L32:
        return;
    L34:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (S90() == false) goto L5;
        int r101 = R.style.ttlive_CommonBottomDialogFast;
    L6:
        setStyle(1, r101);
        return;
    L5:
        r101 = R.style.ttlivebase_ttlive_NewProfileRightDialog;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        W90(r100);
        V90(r100);
        TextView r102 = (TextView) r100.findViewById(R.id.cert_desc);
        String r103 = null;
        if (r102 == null) goto L9;
        WhiteCategoryCert.SubCertInfo r104 = this.f87059e;
        if (r104 == null) goto L7;
        String r105 = r104.desc;
    L8:
        r102.setText(r105);
        goto L9
    L7:
        r105 = null;
    L9:
        U90(r100);
        LinkedHashMap r106 = new LinkedHashMap();
        NewProfileUser r107 = this.f87062h;
        if (r107 == null) goto L14;
        BaseProfileInfo r108 = r107.baseProfileInfo;
        if (r108 == null) goto L14;
        r103 = r108.getIdStr();
    L14:
        r106.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(r103));
        WhiteCategoryCert.SubCertInfo r109 = this.f87059e;
        String r110 = "0";
        if (r109 != null) goto L17;
    L19:
        String r111 = "0";
    L20:
        r106.put("tag_show_user_verify_status", r111);
        IMiddlewareUserService r112 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r112 == null) goto L27;
        e r113 = r112.user();
        if (r113 == null) goto L27;
        String r114 = r113.n();
        if (r114 == null) goto L27;
        r110 = r114;
    L27:
        r106.put("user_id", r110);
        j0.l().sendLog("livesdk_profile_card_vertical_tag_verify_encouragement_show", r106, new Object[]{IRoom.class});
        return;
    L17:
        if (r109.certStatus != 1) goto L19;
        r111 = "1";
        goto L20
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_dialog_profile_white_cert_detail, r101, false);
        this.f87058d = r103;
        return r103;
    }
}
