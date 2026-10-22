package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import x31.u;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkUserBanSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkUserBanSettingDialog extends LiveDialogFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f95486m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f95487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u f95488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f95489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f95490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f95491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IRoom f95492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f95493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f95494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f2 f95495l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkUserBanSettingDialog f95496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f95497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HashMap f95498c;

        public b(PkUserBanSettingDialog r100, View r101, HashMap r102) {
            this.f95496a = r100;
            this.f95497b = r101;
            this.f95498c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            View r102 = this.f95497b;
            Object r103 = null;
            if (r102 == null) goto L5;
            Integer r104 = Integer.valueOf(r102.getId());
        L6:
            int r105 = r104.intValue();
            if (r105 != R.id.ll_add_push_container) goto L10;
            ((ImageView) this.f95496a.S90(R.id.iv_add_push)).setVisibility(0);
        L15:
            Object r106 = this.f95498c.get("increase_or_decrease_invite");
            if ((r106 instanceof Integer) == true) goto L18;
            r106 = null;
        L18:
            Integer r107 = (Integer) r106;
            if (r107 == null) goto L28;
            u r108 = this.f95496a.f95488e;
            if (r108 == null) goto L24;
            r108.f562343b = r107.intValue();
        L24:
            if (r107.intValue() != 1) goto L45;
            u r109 = this.f95496a.f95488e;
            if (r109 == null) goto L45;
            r109.f562344c = false;
        L45:
            ToastUtil.a(R.string.ttlive_interact_pk_ban_feedback_success, 0);
            this.f95496a.dismiss();     // Catch: Exception -> L48
            return;
        L48:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r110 = DialogFragmentLancet.sLastShowStack;
            if (r110 == null) goto L55;
            com.bytedance.crash.d.d(r110, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L55:
            return;
        L28:
            Object r111 = this.f95498c.get("invite_reject_permanent");
            if ((r111 instanceof Boolean) == false) goto L32;
            r103 = r111;
        L32:
            Boolean r112 = (Boolean) r103;
            if (r112 == null) goto L45;
            u r113 = this.f95496a.f95488e;
            if (r113 == null) goto L38;
            r113.f562344c = r112.booleanValue();
        L38:
            if (r112.booleanValue() == false) goto L42;
            u r114 = this.f95496a.f95488e;
            if (r114 == null) goto L45;
            r114.f562343b = 2;
            goto L45
        L42:
            u r115 = this.f95496a.f95488e;
            if (r115 == null) goto L45;
            r115.f562343b = 0;
            goto L45
        L10:
            if (r105 != R.id.ll_sub_push_container) goto L13;
            ((ImageView) this.f95496a.S90(R.id.iv_sub_push)).setVisibility(0);
            goto L15
        L13:
            if (r105 != R.id.ll_not_push_container) goto L15;
            ((ImageView) this.f95496a.S90(R.id.iv_not_push)).setVisibility(0);
            goto L15
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f95499a = null;

        static {
            f95499a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            r101.printStackTrace();
            ToastUtil.a(R.string.ttlive_interact_pk_ban_feedback_fail, 0);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkUserBanSettingDialog f95500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f2 f95501b;

        public d(PkUserBanSettingDialog r100, f2 r101) {
            this.f95500a = r100;
            this.f95501b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Context r101 = this.f95500a.getContext();
            if (r101 != null) goto L5;
            return;
        L5:
            IBattleUserInfo r102 = this.f95501b.getBattleUserInfo();
            if (r102 == null) goto L24;
            k0 r103 = r102.getUserInfo();
            if (r103 == null) goto L25;
            final String r104 = r103.getUserId();
            if (r104 == null) goto L27;
            PkUserBanSettingDialog r105 = this.f95500a;
            if (r105.f95493j == true) goto L28;
            r105.f95493j = true;
            if (((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).isLogin() == true) goto L18;
            com.bytedance.android.livesdk.revenue.service.user.a r106 = (com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
            ds2.e r107 = ((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).Je();
            r107.setMessage(s1.B(R.string.ttlive_core_login_dialog_2_1_follow));
            r107.f469856e = -1;
            Intrinsics.checkNotNullParameter(PbRequest.SwitchType.PK, "<set-?>");
            r107.f469853b = PbRequest.SwitchType.PK;
            Intrinsics.checkNotNullParameter("guest", "<set-?>");
            r107.f469854c = "guest";
            Unit r108 = Unit.INSTANCE;
            r106.g2(r101, r107).subscribe(new com.bytedance.android.livesdk.user.h());
            r105.f95493j = false;
            return;
        L18:
            final com.bytedance.android.livesdk.revenue.service.user.a r109 = (com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
            Disposable r110 = r109.om(null, null, new ds2.c(new PkUserBanSettingDialog$follow$params$1(r104, r109))).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(r105), new r(r105, r101));
            r105.f95494k.add(r110);
            mz0.n r111 = new mz0.n();
            Map<String, String> r112 = r111.f516447a;
            Intrinsics.checkNotNullParameter(r112, "map");
            HashMap<String, String> r113 = r105.T90();
            Intrinsics.checkNotNullParameter(r113, "map");
            r112.putAll(r113);
            if (r105.f95489f != 3) goto L21;
            String r114 = "2";
        L22:
            Intrinsics.checkNotNullParameter("click_options", "key");
            Intrinsics.checkNotNullParameter(r114, "value");
            r112.put("click_options", r114);
            mz0.m r115 = new mz0.m();
            r115.b(LogCommon.ROOM);
            List<Object> r116 = r111.f516448b;
            ArrayList r117 = (ArrayList) r116;
            r117.addAll(r115.f516446a);
            cy0.e.f465759a.getClass();
            cy0.j r118 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r119 = com.bytedance.android.scope.m.b(r118).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r119);
            ((mz0.i) ((f80.a) r119)).w3("livesdk_pk_record_anchor_feedback_click", r111.f516447a, r111.f516448b);
            return;
        L21:
            r114 = "1";
            goto L22
        L28:
            return;
        L27:
            return;
        L25:
            return;
        }
    }

    static {
    }

    public final HashMap<String, String> T90() {
        HashMap<String, String> r100 = new HashMap();
        f2 r101 = this.f95495l;
        if (r101 == null) goto L11;
        IBattleUserInfo r102 = r101.getBattleUserInfo();
        if (r102 == null) goto L11;
        k0 r103 = r102.getUserInfo();
        if (r103 == null) goto L11;
        String r104 = r103.getUserId();
        if (r104 == null) goto L11;
        r100.put("feedback_anchor_id", r104);
    L11:
        int r105 = this.f95489f;
        if (r105 != 1) goto L14;
        r100.put("follow_status", "follow");
    L21:
        return r100;
    L14:
        if (r105 != 2) goto L16;
        r100.put("follow_status", "mutual");
        goto L21
    L16:
        if (r105 == 3) goto L18;
        r100.put("follow_status", "irrelevant");
        goto L21
    L18:
        r100.put("follow_status", "followed");
        goto L21
    }

    public PkUserBanSettingDialog() {
        this.f95487d = new LinkedHashMap();
        this.f95494k = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f95493j = false;
        this.f95494k.dispose();
        ((LinkedHashMap) this.f95487d).clear();
    }

    public final View S90(int r100) {
        if (this.f95487d != null) goto L5;
        this.f95487d = new LinkedHashMap();
    L5:
        View r101 = this.f95487d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f95487d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void U90(Integer r100) {
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        if (r100 != null) goto L16;
    L18:
        ((TextView) S90(R.id.tv_follow_tag)).setVisibility(8);
        ((TextView) S90(R.id.tv_profile_follow)).setVisibility(0);
        return;
    L16:
        if (r100.intValue() != 3) goto L18;
        ((TextView) S90(R.id.tv_profile_follow)).setVisibility(0);
        ((TextView) S90(R.id.tv_profile_follow)).setText("回关");
        return;
    L11:
        if (r100.intValue() != 2) goto L13;
        ((TextView) S90(R.id.tv_follow_tag)).setVisibility(0);
        ((TextView) S90(R.id.tv_follow_tag)).setText("好友");
        ((TextView) S90(R.id.tv_profile_follow)).setVisibility(8);
        return;
    L6:
        if (r100.intValue() != 1) goto L8;
        ((TextView) S90(R.id.tv_follow_tag)).setVisibility(0);
        ((TextView) S90(R.id.tv_follow_tag)).setText("已关注");
        ((TextView) S90(R.id.tv_profile_follow)).setVisibility(8);
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
        return;
    L14:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        f2 r100 = this.f95495l;
        if (r100 != null) goto L7;
        return;
    L7:
        IRoom r101 = this.f95492i;
        if (r101 != null) goto L10;
        return;
    L10:
        HashMap<String, String> r102 = T90();
        HashMap r103 = new HashMap();
        IBattleUserInfo r104 = r100.getBattleUserInfo();
        if (r104 == null) goto L17;
        k0 r105 = r104.getUserInfo();
        if (r105 == null) goto L17;
        String r106 = r105.getUserId();
        if (r106 == null) goto L17;
        r103.put("rival_anchor_id", r106);
    L17:
        int r107 = Integer.valueOf(r110.getId()).intValue();
        if (r107 != R.id.ll_add_push_container) goto L29;
        int r108 = this.f95490g;
        if (r108 == 0) goto L26;
        if (r108 == 1) goto L25;
        if (r108 != 2) goto L27;
        r103.put("increase_or_decrease_invite", 1);
    L27:
        r102.put("click_options", "3");
    L39:
        int r109 = 10;
    L45:
        if ((!r103.isEmpty()) == false) goto L58;
        if (r109 < 0) goto L58;
        r31.a r111 = r31.b.a(r31.a.f535859a);
        long r112 = r101.getId();
        IBaseUser r113 = r101.getOwner();
        if (r113 == null) goto L50;
        Intrinsics.checkNotNullParameter(r113, "$this$secUidExt");
        String r114 = r113.getCastSecUid();
    L51:
        Observable<ExtraResponse<Object, Extra>> r115 = r111.N(r112, r114, r109, r103);
        if (r115 == null) goto L58;
        Observable<R> r116 = r115.compose(RxUtil.rxSchedulerHelper());
        if (r116 == 0) goto L58;
        Disposable r117 = r116.subscribe(new b(this, r110, r103), c.f95499a);
        if (r117 == null) goto L58;
        this.f95494k.add(r117);
        goto L58
    L50:
        r114 = null;
    L58:
        mz0.n r118 = new mz0.n();
        Map<String, String> r119 = r118.f516447a;
        Intrinsics.checkNotNullParameter(r119, "map");
        Intrinsics.checkNotNullParameter(r102, "map");
        r119.putAll(r102);
        mz0.m r120 = new mz0.m();
        r120.b(LogCommon.ROOM);
        ((ArrayList) r118.f516448b).addAll(r120.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r121 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r122 = com.bytedance.android.scope.m.b(r121).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r122);
        ((mz0.i) ((f80.a) r122)).w3("livesdk_pk_record_anchor_feedback_click", r118.f516447a, r118.f516448b);
        return;
    L25:
        r103.put("increase_or_decrease_invite", 0);
        goto L27
    L26:
        r103.put("increase_or_decrease_invite", 1);
        goto L27
    L29:
        if (r107 != R.id.ll_sub_push_container) goto L41;
        int r123 = this.f95490g;
        if (r123 == 0) goto L37;
        if (r123 == 1) goto L36;
        if (r123 != 2) goto L38;
        r103.put("increase_or_decrease_invite", 0);
    L38:
        r102.put("click_options", "4");
        goto L39
    L36:
        r103.put("increase_or_decrease_invite", 2);
        goto L38
    L37:
        r103.put("increase_or_decrease_invite", 2);
        goto L38
    L41:
        if (r107 != R.id.ll_not_push_container) goto L43;
        r103.put("invite_reject_permanent", Boolean.valueOf(!this.f95491h));
        r102.put("click_options", "5");
        r109 = 12;
        goto L45
    L43:
        r109 = -1;
        goto L45
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_live_pk_userbansetting_dialog);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (r101 == null) goto L5;
        r101.setCanceledOnTouchOutside(true);
    L5:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        f2 r112 = this.f95495l;
        if (r112 != null) goto L5;
        return;
    L5:
        ImageView r100 = (ImageView) S90(R.id.head_view);
        IBattleUserInfo r101 = r112.getBattleUserInfo();
        String r102 = null;
        if (r101 == null) goto L10;
        k0 r103 = r101.getUserInfo();
        if (r103 == null) goto L10;
        py.k r104 = r103.getAvatarThumb();
    L11:
        a1.x(r100, r104, ((VHeadView) S90(R.id.head_view)).getWidth(), ((VHeadView) S90(R.id.head_view)).getHeight(), R.drawable.ttlive_ic_default_head_small);
        TextView r113 = (TextView) S90(R.id.tv_nick_name);
        IBattleUserInfo r105 = r112.getBattleUserInfo();
        if (r105 == null) goto L16;
        k0 r106 = r105.getUserInfo();
        if (r106 == null) goto L16;
        String r107 = r106.getNickName();
    L17:
        r113.setText(r107);
        U90(Integer.valueOf(this.f95489f));
        ((TextView) S90(R.id.tv_profile_follow)).setOnClickListener(new d(this, r112));
        long r108 = (r112.getAllCount() - r112.getWinCount()) - r112.getLoseCount();
        TextView r114 = (TextView) S90(R.id.tv_pk_info);
        StringCompanionObject r109 = StringCompanionObject.INSTANCE;
        Object[] r115 = new Object[4];
        r115[0] = Long.valueOf(r112.getAllCount());
        r115[1] = Long.valueOf(r112.getWinCount());
        r115[2] = Long.valueOf(r112.getLoseCount());
        if (r108 >= 0) goto L21;
        r108 = 0;
    L21:
        r115[3] = Long.valueOf(r108);
        r114.setText(String.format("与Ta共PK过%d场，%s胜-%s负-%s平", Arrays.copyOf(r115, 4)));
        IBattleUserInfo r116 = r112.getBattleUserInfo();
        if (r116 == null) goto L26;
        k0 r117 = r116.getUserInfo();
        if (r117 == null) goto L26;
        Integer r118 = Integer.valueOf(r117.getGender());
    L28:
        if (r118 != null) goto L31;
    L33:
        if (r118 != null) goto L36;
    L38:
        ((VHeadView) S90(R.id.gender_view)).setVisibility(8);
    L40:
        if (r112.getRivalLivingRoomId() == 0) goto L42;
        ((ImageView) S90(R.id.circle_living_view)).setVisibility(0);
        ((HSImageView) S90(R.id.living_view)).setVisibility(0);
        ((HSImageView) S90(R.id.living_view)).setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_item_rank_top_on_going_hd.webp").setAutoPlayAnimations(true).build());
    L44:
        if (this.f95491h == false) goto L50;
        TextView r119 = (TextView) S90(R.id.tv_not_push);
        StringBuilder r120 = new StringBuilder("取消");
        Context r121 = getContext();
        if (r121 == null) goto L48;
        String r122 = r121.getString(R.string.ttlive_interact_pk_ban_setting_not);
    L49:
        r120.append(r122);
        r119.setText(r120.toString());
        goto L50
    L48:
        r122 = null;
    L50:
        int r123 = this.f95490g;
        if (r123 == 0) goto L73;
        if (r123 == 1) goto L64;
        if (r123 != 2) goto L82;
        TextView r124 = (TextView) S90(R.id.tv_add_push);
        Context r125 = getContext();
        if (r125 == null) goto L58;
        String r126 = r125.getString(R.string.ttlive_interact_pk_ban_setting_add);
    L59:
        r124.setText(r126);
        TextView r127 = (TextView) S90(R.id.tv_sub_push);
        StringBuilder r128 = new StringBuilder("取消");
        Context r129 = getContext();
        if (r129 == null) goto L62;
        String r130 = r129.getString(R.string.ttlive_interact_pk_ban_setting_sub);
    L63:
        r128.append(r130);
        r127.setText(r128.toString());
        goto L82
    L62:
        r130 = null;
        goto L63
    L58:
        r126 = null;
    L82:
        ((FrameLayout) S90(R.id.ll_add_push_container)).setOnClickListener(this);
        ((FrameLayout) S90(R.id.ll_sub_push_container)).setOnClickListener(this);
        ((FrameLayout) S90(R.id.ll_not_push_container)).setOnClickListener(this);
        HashMap r131 = new HashMap();
        IBattleUserInfo r132 = r112.getBattleUserInfo();
        if (r132 == null) goto L87;
        k0 r133 = r132.getUserInfo();
        if (r133 == null) goto L87;
        r102 = r133.getUserId();
    L87:
        r131.put("feedback_anchor_id", String.valueOf(r102));
        mz0.n r134 = new mz0.n();
        Map<String, String> r135 = r134.f516447a;
        Intrinsics.checkNotNullParameter(r135, "map");
        Intrinsics.checkNotNullParameter(r131, "map");
        r135.putAll(r131);
        mz0.m r136 = new mz0.m();
        r136.b(LogCommon.ROOM);
        ((ArrayList) r134.f516448b).addAll(r136.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r137 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r138 = com.bytedance.android.scope.m.b(r137).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r138);
        ((mz0.i) ((f80.a) r138)).w3("livesdk_pk_record_anchor_feedback_show", r134.f516447a, r134.f516448b);
        return;
    L64:
        TextView r139 = (TextView) S90(R.id.tv_add_push);
        StringBuilder r140 = new StringBuilder("取消");
        Context r141 = getContext();
        if (r141 == null) goto L67;
        String r142 = r141.getString(R.string.ttlive_interact_pk_ban_setting_add);
    L68:
        r140.append(r142);
        r139.setText(r140.toString());
        TextView r143 = (TextView) S90(R.id.tv_sub_push);
        Context r144 = getContext();
        if (r144 == null) goto L71;
        String r145 = r144.getString(R.string.ttlive_interact_pk_ban_setting_sub);
    L72:
        r143.setText(r145);
        goto L82
    L71:
        r145 = null;
        goto L72
    L67:
        r142 = null;
        goto L68
    L73:
        TextView r146 = (TextView) S90(R.id.tv_add_push);
        Context r147 = getContext();
        if (r147 == null) goto L76;
        String r148 = r147.getString(R.string.ttlive_interact_pk_ban_setting_add);
    L77:
        r146.setText(r148);
        TextView r149 = (TextView) S90(R.id.tv_sub_push);
        Context r150 = getContext();
        if (r150 == null) goto L80;
        String r151 = r150.getString(R.string.ttlive_interact_pk_ban_setting_sub);
    L81:
        r149.setText(r151);
        goto L82
    L80:
        r151 = null;
        goto L81
    L76:
        r148 = null;
        goto L77
    L42:
        ((ImageView) S90(R.id.circle_living_view)).setVisibility(8);
        ((HSImageView) S90(R.id.living_view)).setVisibility(8);
        goto L44
    L36:
        if (r118.intValue() != 2) goto L38;
        ((VHeadView) S90(R.id.gender_view)).setImageResource(R.drawable.ttlive_gender_female_icon);
        ((VHeadView) S90(R.id.gender_view)).setVisibility(0);
        goto L40
    L31:
        if (r118.intValue() != 1) goto L33;
        ((VHeadView) S90(R.id.gender_view)).setImageResource(R.drawable.ttlive_gender_male_icon);
        ((VHeadView) S90(R.id.gender_view)).setVisibility(0);
    L26:
        r118 = null;
    L16:
        r107 = null;
    L10:
        r104 = null;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_pk_ban_user_setting, r101, false);
    }
}
