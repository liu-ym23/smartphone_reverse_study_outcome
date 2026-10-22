package com.bytedance.android.live.liveinteract.voicechat.match.view;

import am2.x;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.plantform.model.ListUserTag;
import com.bytedance.android.live.liveinteract.voicechat.match.logger.ChatMatchFailReason;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.bytedance.android.livesdk.chatroom.model.c1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.i6;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.desc.CountDownWithDescTextView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/match/view/ChatMatchDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatMatchDialog extends LiveDialogFragment {
    public static final /* synthetic */ int V = 0;
    public HSImageView A;
    public ImageView B;
    public CountDownWithDescTextView C;
    public TextView D;
    public TextView E;
    public LinearLayout F;
    public FrameLayout G;
    public TextView H;
    public HSImageView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public HSImageView f80329J;
    public LinearLayout K;
    public View L;
    public TextView M;
    public CountDownWithDescTextView N;
    public LinearLayout O;
    public TextView P;
    public HSImageView Q;
    public TextView R;
    public TextView S;
    public RecyclerView T;
    public final b U;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f80330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f80331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f80332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IRoom f80333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ChatMatchViewModel f80334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DataCenter f80335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a5 f80336j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f80337k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f80338l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public gk0.a f80339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f80340n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ik0.g f80341o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f80342p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f80343q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f80344r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ek0.c f80345s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f80346t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinearLayout f80347u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f80348v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImageView f80349w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f80350x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f80351y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ConstraintLayout f80352z;

    public static final class a {
        public static ChatMatchDialog a(IRoom r100, DataCenter r101, a5 r102, boolean r103, ChatMatchViewModel r104, Boolean r105) {
            ChatMatchDialog r106 = new ChatMatchDialog();
            r106.f80333g = r100;
            r106.f80335i = r101;
            r106.f80336j = r102;
            r106.f80337k = r103;
            if (r104 != null) goto L5;
            String r107 = ChatMatchWidget.f80417o;
            r104 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        L5:
            r106.f80334h = r104;
            r106.f80338l = Intrinsics.areEqual(r105, Boolean.TRUE);
            return r106;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatMatchDialog f80353a;

        public b(ChatMatchDialog r100) {
            this.f80353a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.intValue() != 2) goto L23;
            ChatMatchViewModel r102 = this.f80353a.f80334h;
            if (r102 == null) goto L11;
            MutableLiveData<Boolean> r103 = r102.getMatchingState();
            if (r103 == null) goto L11;
            Boolean r104 = r103.getValue();
        L13:
            if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L19;
            ChatMatchDialog r105 = this.f80353a;
            ChatMatchViewModel r106 = r105.f80334h;
            if (r106 == null) goto L19;
            gk0.a r107 = r105.f80339m;
            if (r107 == null) goto L19;
            gk0.a.C6033a r108 = gk0.a.f481528b;
            Integer r109 = r106.getMatchType().getValue();
            Boolean r110 = r106.getRematch().getValue();
            r108.getClass();
            r107.b(gk0.a.C6033a.b(r109, r110).getValue(), ChatMatchFailReason.OCCUPATION.getValue());
        L19:
            ChatMatchViewModel r111 = this.f80353a.f80334h;
            if (r111 == null) goto L22;
            r111.release();
        L22:
            this.f80353a.U90();
        L11:
            r104 = null;
        L23:
            ChatMatchDialog r112 = this.f80353a;
            int r113 = r101.intValue();
            int r114 = ChatMatchDialog.V;
            r112.Z90(r113);
        }
    }

    public static final class c implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f80354a = null;

        static {
            f80354a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatMatchDialog f80355a;

        public d(ChatMatchDialog r100) {
            this.f80355a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            ChatMatchDialog r101 = this.f80355a;
            int r102 = ChatMatchDialog.V;
            Dialog r103 = r101.getDialog();
            Context r104 = r101.getContext();
            if (r103 == null) goto L18;
            if (r104 == null) goto L21;
            Dialog r105 = r101.getDialog();
            if (r105 == null) goto L9;
            View r106 = r105.getCurrentFocus();
        L10:
            if (r106 == null) goto L22;
            InputMethodManager r107 = (InputMethodManager) r104.getSystemService("input_method");
            if (r107 != null) goto L15;
            return;
        L15:
            if (r107.isActive() == false) goto L20;
            r107.hideSoftInputFromWindow(r106.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L9:
            r106 = null;
            goto L10
        L21:
            return;
        }
    }

    static {
    }

    public ChatMatchDialog() {
        this.f80330d = new LinkedHashMap();
        this.f80331e = 1;
        this.f80332f = 2;
        this.f80341o = new ik0.g();
        this.f80343q = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/fast_match_icon_style_v2.webp";
        this.f80344r = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_multi_link_fast_match_avatar_animation.webp";
        this.U = new b(this);
    }

    public final void U90() {
        if (isShowing() == false) goto L13;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L14;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public final void W90() {
        if (vm2.d.e().e() == false) goto L7;
        AbstractDraweeController r100 = Fresco.newDraweeControllerBuilder().setUri(this.f80343q).setAutoPlayAnimations(true).build();
        HSImageView r101 = this.A;
        if (r101 == null) goto L11;
        r101.setController(r100);
        return;
    L11:
        return;
    L7:
        HSImageView r102 = this.A;
        if (r102 == null) goto L13;
        r102.setImageResource(R.drawable.ttlive_interact_icon_match_head_old);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X90() {
        if (hd0.c.f().j() == false) goto L5;
        Integer r100 = (Integer) hd0.c.f().f481009b;
    L6:
        Z90(r100.intValue());
        final ChatMatchViewModel r101 = this.f80334h;
        if (r101 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r101.getMatchingState().getValue(), Boolean.TRUE) == false) goto L12;
        return;
    L12:
        if (getContext() == null) goto L14;
        int r102 = ik0.g.f490176b;
        Y90(0);
    L16:
        if (r101.getWaitingCount().getValue() == null) goto L20;
        View r103 = getView();
        if (r103 == null) goto L23;
        r103.post(new ChatMatchDialog$startMatchForShake$$inlined$let$lambda$1(r101, this));
        return;
    L23:
        return;
    L20:
        ChatMatchViewModel.startMatch$default(r101, this.f80333g, false, 1, 2, null);
        return;
    L14:
        this.f80342p = true;
        goto L16
    L5:
        r100 = -1;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ValueAnimator r100 = this.f80340n;
        if (r100 != null) goto L5;
    L7:
        hd0.c.f().e(this.U);
        ik0.g r101 = this.f80341o;
        Vibrator r102 = r101.f490177a;
        if (r102 == null) goto L11;
        r102.cancel();
        r101.f490177a = null;
    L11:
        ChatMatchViewModel r103 = this.f80334h;
        if (r103 == null) goto L15;
        r103.release();
        return;
    L15:
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        r100.removeAllListeners();
        r100.removeAllUpdateListeners();
        r100.cancel();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f80330d.clear();
    }

    public final View S90(int r100) {
        if (this.f80330d != null) goto L5;
        this.f80330d = new LinkedHashMap();
    L5:
        View r101 = this.f80330d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f80330d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void Y90(int r100) {
        int r101 = 1;
        if (vm2.h.b0().c() == 1) goto L5;
        return;
    L5:
        ik0.g r102 = this.f80341o;
        Context r103 = getContext();
        r102.getClass();
        int r104 = 255;
        if (r100 != 2) goto L8;
        long r105 = 400;
        int r106 = 255;
    L11:
        if (r103 != null) goto L14;
        return;
    L14:
        if (r102.f490177a != null) goto L20;
        Object r107 = r103.getSystemService("vibrator");
        if (r107 == null) goto L19;
        r102.f490177a = (Vibrator) r107;
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    L20:
        Vibrator r108 = r102.f490177a;
        if (r108 == null) goto L25;
        r108.cancel();
    L25:
        if (Build.VERSION.SDK_INT >= 26) goto L29;
        Vibrator r109 = r102.f490177a;
        if (r109 == null) goto L42;
        r109.vibrate(r105);
        return;
    L42:
        return;
    L29:
        if (r106 <= 0) goto L32;
        r101 = r106;
    L32:
        if (r101 > 255) goto L36;
        r104 = r101;
    L36:
        if (r105 > 0) goto L38;
        r105 = 1;
    L38:
        VibrationEffect r110 = VibrationEffect.createOneShot(r105, r104);
        Vibrator r111 = r102.f490177a;
        if (r111 == null) goto L44;
        r111.vibrate(r110);
        return;
    L44:
        return;
    L8:
        if (r100 != 1) goto L10;
        r106 = 120;
        r105 = 250;
        goto L11
    L10:
        r106 = 10;
        r105 = 110;
        goto L11
    }

    public final void Z90(int r100) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (this.f80337k == false) goto L11;
        ca0(8);
        ConstraintLayout r101 = this.f80352z;
        if (r101 == null) goto L38;
        r101.setBackgroundResource(0);
        return;
    L38:
        return;
    L11:
        if (r100 != 0) goto L22;
        ca0(0);
        TextView r102 = this.f80351y;
        if (r102 == null) goto L15;
        r102.setText(s1.B(R.string.ttlive_interact_apply_link));
    L15:
        TextView r103 = this.f80350x;
        if (r103 == null) goto L18;
        r103.setText(s1.B(R.string.ttlive_interact_apply_canceled));
    L18:
        ImageView r104 = this.f80349w;
        if (r104 == null) goto L39;
        r104.setVisibility(8);
        return;
    L39:
        return;
    L22:
        if (r100 != 1) goto L34;
        ca0(0);
        TextView r105 = this.f80351y;
        if (r105 == null) goto L26;
        r105.setText(s1.B(R.string.ttlive_interact_anchor_link_cancel_apply));
    L26:
        a5 r106 = this.f80336j;
        if (r106 == null) goto L31;
        TextView r107 = this.f80350x;
        if (r107 == null) goto L31;
        r107.setText(sb2.a.h(r106, "", false));
    L31:
        ImageView r108 = this.f80349w;
        if (r108 == null) goto L41;
        r108.setVisibility(0);
        return;
    L41:
        return;
    L34:
        ca0(8);
        ConstraintLayout r109 = this.f80352z;
        if (r109 == null) goto L43;
        r109.setBackgroundResource(0);
        return;
    }

    public final void aa0(b1 r110) {
        HSImageView r100 = this.I;
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        HSImageView r101 = this.f80329J;
        if (r101 == null) goto L9;
        r101.setVisibility(0);
    L9:
        if (r110.getMatchedRoomId() > 0) goto L11;
        return;
    L11:
        if (r110.getMatchedUser() == null) goto L254;
        ImageUtil.loadRoundImage(this.I, r110.getMatchedUser().getAvatarThumbKt());
        HSImageView r102 = this.f80329J;
        if (r102 == null) goto L15;
        r102.setVisibility(0);
    L15:
        int r103 = r110.getMatchedUser().getGender();
        if (r103 != this.f80331e) goto L21;
        HSImageView r104 = this.f80329J;
        if (r104 == null) goto L28;
        r104.setImageResource(R.drawable.ttlive_gender_male_icon);
    L28:
        LiveMode r105 = null;
        String r106 = "";
        if (((Boolean) vm2.h.R5.getValue(null, vm2.h.f556082a[354(0x162, float:4.96E-43)])).booleanValue() == false) goto L55;
        IBaseUser r107 = r110.getMatchedUser();
        String r108 = r110.getRoomTitle();
        if (vm2.h.U().f() == true) goto L33;
    L35:
        TextView r109 = (TextView) S90(R.id.avatar_name_view);
        Object[] r111 = new Object[1];
        String r112 = r107.getRealNickName();
        if (r112 != null) goto L38;
        r112 = "";
    L38:
        r111[0] = i6.a(r112, 12);
        r109.setText(s1.C(R.string.ttlive_interact_target_room, r111));
    L39:
        CountDownWithDescTextView r113 = this.N;
        if (r113 == null) goto L42;
        r113.setCountDownViewWidth(s1.f(36.0f));
    L42:
        ChatMatchViewModel r114 = this.f80334h;
        if (r114 == null) goto L49;
        MutableLiveData<b1> r115 = r114.getMatchData();
        if (r115 == null) goto L49;
        b1 r116 = r115.getValue();
        if (r116 == null) goto L49;
        int r117 = r116.getScene();
    L50:
        ChatMatchViewModel r118 = this.f80334h;
        if (r118 == null) goto L81;
        MutableLiveData<Integer> r119 = r118.getWaitingCount();
        if (r119 == null) goto L81;
        r119.observe(this, new com.bytedance.android.live.liveinteract.voicechat.match.view.c(this, r117));
    L81:
        if (vm2.h.U().f() == false) goto L135;
        HSImageView r120 = this.Q;
        if (r120 == null) goto L85;
        r120.setController(Fresco.newDraweeControllerBuilder().setUri(this.f80344r).setAutoPlayAnimations(true).build());
    L85:
        RecyclerView r121 = this.T;
        if (r121 == null) goto L105;
        List r122 = jm2.a.c(r110.getLinkedUser());
        V90(r110, r122);
        if (r122.isEmpty() == false) goto L97;
        UtilityKotlinExtentionsKt.t(r121);
        TextView r123 = this.P;
        if (r123 == null) goto L93;
        UtilityKotlinExtentionsKt.t(r123);
    L93:
        if (r2.a(r110.getText()) == false) goto L105;
        TextView r124 = this.P;
        if (r124 == null) goto L105;
        r124.setVisibility(0);
        r124.setText(r110.getText());
        goto L105
    L97:
        UtilityKotlinExtentionsKt.w(r121);
        LinearLayoutManager r125 = new LinearLayoutManager(getContext());
        r125.setOrientation(0);
        Unit r126 = Unit.INSTANCE;
        r121.setLayoutManager(r125);
        r121.setAdapter(new ChatMatchGuestAvatarAdapter(s1.getContext(), r122));
        TextView r127 = this.P;
        if (r127 == null) goto L101;
        UtilityKotlinExtentionsKt.w(r127);
    L101:
        if (r2.a(r110.getText()) == false) goto L105;
        TextView r128 = this.P;
        if (r128 == null) goto L105;
        r128.setText(r110.getText());
    L105:
        TextView r129 = this.R;
        if (r129 != null) goto L242;
    L216:
        gk0.a r130 = this.f80339m;
        if (r130 == null) goto L219;
        r130.c(LinkMatchType.TRY_AGAIN.getValue());
    L219:
        HashMap r131 = new HashMap();
        r131.put("room_id", String.valueOf(r110.getMatchedRoomId()));
        IBaseUser r132 = r110.getMatchedUser();
        if (r132 == null) goto L225;
        String r133 = r132.getIdString();
        if (r133 == null) goto L225;
        r106 = r133;
    L225:
        r131.put("anchor_id", r106);
        r131.put("enter_from_merge", "live_detail");
        ChatMatchViewModel r134 = this.f80334h;
        if (r134 == null) goto L230;
        MutableLiveData<Integer> r135 = r134.getMatchType();
        if (r135 == null) goto L230;
        Integer r136 = r135.getValue();
    L231:
        if (r136 != null) goto L234;
    L236:
        String r137 = "match";
    L237:
        r131.put("enter_method", r137);
        r131.put("action_type", "click");
        IRoom r138 = this.f80333g;
        if (r138 == null) goto L240;
        r105 = r138.getStreamType();
    L240:
        int r139 = h1.f66189a;
        r131.put("live_type", i1.a(r105));
        j0.l().sendLog("livesdk_live_show", r131, new Object[]{x.class, PadLoggerData.class});
        return;
    L234:
        if (r136.intValue() != 1) goto L236;
        r137 = ChatMatchViewModel.ENTER_METHOD_SHAKE;
    L230:
        r136 = null;
        goto L231
    L242:
        ListUserTag r140 = r110.getTag();     // Catch: IllegalArgumentException -> L126
        if (r140 == null) goto L124;
        r129.setVisibility(0);     // Catch: IllegalArgumentException -> L126
        String r141 = r140.getTextColor();     // Catch: IllegalArgumentException -> L126
        if (r141 != null) goto L112;
        r141 = "#80161823";
    L112:
        Long r142 = r140.getBgRadius();     // Catch: IllegalArgumentException -> L126
        if (r142 == null) goto L115;
        float r143 = r142.longValue();     // Catch: IllegalArgumentException -> L126
    L116:
        String r144 = r140.getBgColor();     // Catch: IllegalArgumentException -> L126
        if (r144 != null) goto L119;
        r144 = "#0D161823";
    L119:
        GradientDrawable r145 = new GradientDrawable();     // Catch: IllegalArgumentException -> L126
        r145.setCornerRadius(r143);     // Catch: IllegalArgumentException -> L126
        r145.setColor(Color.parseColor(r144));     // Catch: IllegalArgumentException -> L126
        r129.setBackground(r145);     // Catch: IllegalArgumentException -> L126
        r129.setText(r140.getContent());     // Catch: IllegalArgumentException -> L126
        Long r146 = r140.getTextSize();     // Catch: IllegalArgumentException -> L126
        if (r146 == null) goto L122;
        float r147 = r146.longValue();     // Catch: IllegalArgumentException -> L126
    L123:
        r129.setTextSize(r147);     // Catch: IllegalArgumentException -> L126
        r129.setTextColor(Color.parseColor(r141));     // Catch: IllegalArgumentException -> L126
        goto L216
    L122:
        r147 = 9.0f;
        goto L123
    L115:
        r143 = 2.0f;
        goto L116
    L124:
        r129.setVisibility(8);     // Catch: IllegalArgumentException -> L126
    L126:
        StringBuilder r148 = new StringBuilder("Invalid color, bgColor=");
        ListUserTag r149 = r110.getTag();
        if (r149 == null) goto L129;
        String r150 = r149.getBgColor();
    L130:
        r148.append(r150);
        r148.append(", textColor=");
        ListUserTag r151 = r110.getTag();
        if (r151 == null) goto L133;
        String r152 = r151.getTextColor();
    L134:
        r148.append(r152);
        ALogger.i("ChatMatchDialog", r148.toString());
        goto L216
    L133:
        r152 = null;
        goto L134
    L129:
        r150 = null;
        goto L130
    L135:
        LinearLayout r153 = this.K;
        if (r153 == null) goto L169;
        TextView r154 = this.E;
        if (r154 == null) goto L140;
        UtilityKotlinExtentionsKt.t(r154);
    L140:
        r153.removeAllViews();
        List<c1> r155 = r110.getResultTagList();
        if (r155 != null) goto L143;
    L146:
        boolean r156 = true;
    L147:
        if (r156 == false) goto L149;
        UtilityKotlinExtentionsKt.t(r153);
        goto L169
    L149:
        UtilityKotlinExtentionsKt.w(r153);
        Iterator<c1> r157 = r110.getResultTagList().iterator();
    L151:
        if (r157.hasNext() == false) goto L169;
        String r158 = r157.next().getValue();
        if (TextUtils.isEmpty(r158) == true) goto L151;
        FastMatchTopicItemView r159 = new FastMatchTopicItemView(s1.getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter(r158, SocialConstants.PARAM_APP_DESC);
        if (TextUtils.isEmpty(r158) == false) goto L159;
    L168:
        r153.addView(r159);
        goto L151
    L159:
        if (r159.f80364a != null) goto L161;
        r159.f80364a = new LinkedHashMap();
    L161:
        View r160 = (View) ((LinkedHashMap) r159.f80364a).get(Integer.valueOf(R.id.topic_content));
        if (r160 != null) goto L167;
        r160 = r159.findViewById(R.id.topic_content);
        if (r160 == null) goto L166;
        r159.f80364a.put(Integer.valueOf(R.id.topic_content), r160);
        goto L167
    L166:
        r160 = null;
    L167:
        ((TextView) r160).setText(i6.a(r158, 5));
        goto L168
    L143:
        if (r155.isEmpty() == true) goto L146;
        r156 = false;
    L169:
        LinearLayout r161 = this.O;
        if (r161 == null) goto L216;
        r161.removeAllViews();
        List r162 = jm2.a.c(r110.getLinkedUser());
        V90(r110, r162);
        List r163 = r162;
        if (r163.isEmpty() == false) goto L176;
        UtilityKotlinExtentionsKt.t(r161);
        TextView r164 = this.P;
        if (r164 == null) goto L216;
        UtilityKotlinExtentionsKt.t(r164);
        goto L216
    L176:
        UtilityKotlinExtentionsKt.w(r161);
        int r165 = r163.size();
        int r166 = 0;
    L177:
        if (r166 >= r165) goto L210;
        if (r166 >= 3) goto L210;
        HSImageView r167 = new HSImageView(s1.getContext());
        r167.setLayoutParams(new LinearLayout.LayoutParams((int) s1.e(20.0f), (int) s1.e(20.0f)));
        r167.setPadding(0, 0, (int) s1.e(4.0f), 0);
        IBaseUser r168 = ((com.bytedance.android.livesdk.link.model.bridge.k) ListProtector.get(r162, r166)).getUser();
        if (r168 == null) goto L184;
        py.k r169 = r168.getAvatarThumbKt();
    L186:
        if (r169 == null) goto L208;
        if (r168 == null) goto L191;
        py.k r170 = r168.getAvatarThumbKt();
        if (r170 == null) goto L191;
        List<String> r171 = r170.getUrls();
    L193:
        if (CollectionUtils.isEmpty(r171) == true) goto L208;
        if (r167.getTag(R.id.ttlive_tag_image_request) == null) goto L203;
        Object r172 = r167.getTag(R.id.ttlive_tag_image_request);
        py.k r173 = r168.getAvatarThumbKt();
        if (r173 == null) goto L200;
        List<String> r174 = r173.getUrls();
    L202:
        if ((!Intrinsics.areEqual(r172, r174)) == true) goto L203;
    L209:
        r161.addView(r167);
        r166 = r166 + 1;
        goto L177
    L200:
        r174 = null;
    L203:
        py.k r175 = r168.getAvatarThumbKt();
        if (r175 == null) goto L206;
        List<String> r176 = r175.getUrls();
    L207:
        r167.setTag(R.id.ttlive_tag_image_request, r176);
        a1.v(r167, r168.getAvatarThumbKt(), R.drawable.ttlive_img_avatar_empty);
        goto L209
    L206:
        r176 = null;
    L191:
        r171 = null;
    L208:
        ImageUtil.loadRoundResource(r167, R.drawable.ttlive_img_avatar_empty, -1, -1);
        goto L209
    L184:
        r169 = null;
    L210:
        TextView r177 = this.P;
        if (r177 == null) goto L213;
        UtilityKotlinExtentionsKt.w(r177);
    L213:
        TextView r178 = this.P;
        if (r178 == null) goto L216;
        r178.setText(s1.C(R.string.ttlive_fast_match_result_link_num, new Object[]{Integer.valueOf(r162.size())}));
    L49:
        r117 = 5;
        goto L50
    L33:
        if (r2.a(r108) == false) goto L35;
        ((TextView) S90(R.id.avatar_name_view)).setText(r108);
        goto L39
    L55:
        IBaseUser r179 = r110.getMatchedUser();
        String r180 = r110.getRoomTitle();
        if (vm2.h.U().f() == true) goto L58;
    L60:
        TextView r181 = (TextView) S90(R.id.avatar_name_view);
        Object[] r182 = new Object[1];
        String r183 = r179.getRealNickName();
        if (r183 != null) goto L63;
        r183 = "";
    L63:
        r182[0] = i6.a(r183, 12);
        r181.setText(s1.C(R.string.ttlive_interact_target_room, r182));
    L64:
        ChatMatchViewModel r184 = this.f80334h;
        if (r184 == null) goto L71;
        MutableLiveData<b1> r185 = r184.getMatchData();
        if (r185 == null) goto L71;
        b1 r186 = r185.getValue();
        if (r186 == null) goto L71;
        int r187 = r186.getScene();
    L73:
        if (r187 != 9) goto L77;
        CountDownWithDescTextView r188 = this.N;
        if (r188 == null) goto L81;
        r188.setDescText(s1.B(R.string.ttlive_interact_match_ktv_go));
        goto L81
    L77:
        CountDownWithDescTextView r189 = this.N;
        if (r189 == null) goto L81;
        r189.setDescText(s1.B(R.string.ttlive_interact_match_chat_go));
    L71:
        r187 = 5;
        goto L73
    L58:
        if (r2.a(r180) == false) goto L60;
        ((TextView) S90(R.id.avatar_name_view)).setText(r180);
        goto L64
    L21:
        if (r103 != this.f80332f) goto L25;
        HSImageView r190 = this.f80329J;
        if (r190 == null) goto L28;
        r190.setImageResource(R.drawable.ttlive_gender_female_icon);
        goto L28
    L25:
        HSImageView r191 = this.f80329J;
        if (r191 == null) goto L28;
        r191.setVisibility(4);
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void ba0(boolean r100) {
        TextView r101 = this.E;
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r101);
    L5:
        LinearLayout r102 = this.F;
        if (r102 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r102);
    L8:
        if (r100 == false) goto L27;
        TextView r103 = this.D;
        if (r103 == null) goto L12;
        r103.setText(s1.B(R.string.ttlive_interact_chat_matching));
    L12:
        TextView r104 = this.E;
        if (r104 == null) goto L15;
        r104.setText(s1.B(R.string.ttlive_interact_chat_matching_des));
    L15:
        String r105 = s1.B(R.string.ttlive_cancel);
        int r106 = s1.h(R.color.ttlive_black);
        CountDownWithDescTextView r107 = this.C;
        if (r107 == null) goto L18;
        r107.setDescText(r105);
    L18:
        CountDownWithDescTextView r108 = this.C;
        if (r108 == null) goto L21;
        r108.setContainerBackgroundResource(R.drawable.ttlive_btn_unmatch_chat);
    L21:
        CountDownWithDescTextView r109 = this.C;
        if (r109 == null) goto L24;
        r109.setTextColor(r106);
    L24:
        Dialog r110 = getDialog();
        if (r110 == null) goto L54;
        r110.setCanceledOnTouchOutside(!this.f80346t);
        return;
    L54:
        return;
    L27:
        Integer r111 = (Integer) hd0.c.f().f481009b;
        if (r111 != null) goto L31;
    L38:
        TextView r112 = this.D;
        if (r112 == null) goto L41;
        r112.setText(s1.B(R.string.ttlive_interact_match_guide));
    L41:
        TextView r113 = this.E;
        if (r113 == null) goto L44;
        r113.setText(s1.B(R.string.ttlive_interact_match_guide_des));
    L44:
        String r114 = s1.B(R.string.ttlive_interact_match_oneclick);
        int r115 = s1.h(R.color.ttlive_white);
        CountDownWithDescTextView r116 = this.C;
        if (r116 == null) goto L47;
        r116.setDescText(r114);
    L47:
        CountDownWithDescTextView r117 = this.C;
        if (r117 == null) goto L50;
        r117.setContainerBackgroundResource(R.drawable.ttlive_btn_match_chat);
    L50:
        CountDownWithDescTextView r118 = this.C;
        if (r118 == null) goto L56;
        r118.setTextColor(r115);
        return;
    L56:
        return;
    L31:
        if (r111.intValue() != 2) goto L38;
        TextView r119 = this.D;
        if (r119 == null) goto L35;
        r119.setText(s1.B(R.string.ttlive_interact_match_guide_online));
    L35:
        TextView r120 = this.E;
        if (r120 == null) goto L44;
        r120.setText(s1.B(R.string.ttlive_interact_match_guide_des_online));
        goto L44
    }

    public final void ca0(int r100) {
        if (r100 != 8) goto L5;
        UIUtils.updateLayoutMargin(this.f80352z, -3, 0, -3, 0);
    L6:
        LinearLayout r101 = this.f80347u;
        if (r101 == null) goto L10;
        r101.setVisibility(r100);
        return;
    L10:
        return;
    L5:
        UIUtils.updateLayoutMargin(this.f80352z, -3, s1.j(R.dimen.ttlive_fast_match_search_container_margin), -3, s1.j(R.dimen.ttlive_fast_match_search_container_margin));
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.width = -1;
        r103.height = -1;
        r102.setAttributes(r103);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setGravity(80);
    L7:
        setBottomSheetSlideProcessor(c.f80354a);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        IRoom r101 = this.f80333g;
        if (r101 == null) goto L5;
        this.f80339m = new gk0.a(r101);
    L5:
        ChatMatchViewModel r102 = this.f80334h;
        if (r102 == null) goto L8;
        this.f80345s = new ek0.c(getContext(), this.f80335i, r102);
    L8:
        setStyle(1, R.style.ttlive_live_interact_dialog);
        DataCenter r103 = this.f80335i;
        if (r103 == null) goto L11;
        Boolean r104 = (Boolean) r103.get("data_is_anchor", Boolean.FALSE);
    L12:
        this.f80346t = Intrinsics.areEqual(r104, Boolean.TRUE);
        return;
    L11:
        r104 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnCancelListener(new d(this));
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        ChatMatchViewModel r101 = this.f80334h;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.setHasMatchSuccessOrFail(false);     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static void V90(b1 r100, List r101) {
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        com.bytedance.android.livesdk.link.model.bridge.k r103 = (com.bytedance.android.livesdk.link.model.bridge.k) r102.next();
        String r104 = r100.getMatchedUser().getIdString();
        IBaseUser r105 = r103.getUser();
        if (r105 == null) goto L8;
        String r106 = r105.getIdString();
    L10:
        if (Intrinsics.areEqual(r104, r106) == false) goto L4;
        r102.remove();
        goto L4
    L8:
        r106 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Integer r102 = (Integer) hd0.c.f().f481009b;
        if (r102 != null) goto L6;
    L7:
        hd0.c.f().c(this.U);
    L9:
        if (vm2.h.U().f() == false) goto L11;
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_chat_match_result_v3, (ViewGroup) S90(R.id.body_with_rematch));
    L12:
        ConstraintLayout r103 = (ConstraintLayout) r100.findViewById(R.id.chat_match_container);
        this.f80347u = (LinearLayout) r100.findViewById(R.id.topView);
        this.f80348v = r100.findViewById(R.id.split_line);
        this.f80349w = (ImageView) r100.findViewById(R.id.ivSuccess);
        this.f80350x = (TextView) r100.findViewById(R.id.tvMatchTitle);
        this.f80351y = (TextView) r100.findViewById(R.id.tvCancel);
        this.f80352z = (ConstraintLayout) r100.findViewById(R.id.body);
        this.A = (HSImageView) r100.findViewById(R.id.ivHead);
        TextView r104 = (TextView) r100.findViewById(R.id.fast_match_tip_tv);
        this.B = (ImageView) r100.findViewById(R.id.ivGender);
        this.C = (CountDownWithDescTextView) r100.findViewById(R.id.btn);
        this.D = (TextView) r100.findViewById(R.id.tvBodyTitle);
        this.E = (TextView) r100.findViewById(R.id.tvBodyDes);
        this.F = (LinearLayout) r100.findViewById(R.id.topicListBody);
        FrameLayout r105 = (FrameLayout) r100.findViewById(R.id.body_with_rematch);
        this.G = r105;
        if (r105 == null) goto L19;
        if (vm2.h.U().f() == false) goto L17;
        this.H = (TextView) r105.findViewById(R.id.cancel_btn);
        this.I = (HSImageView) r105.findViewById(R.id.ttlive_avatar_view);
        this.Q = (HSImageView) r105.findViewById(R.id.ttlive_avatar_anim);
        TextView r106 = (TextView) r105.findViewById(R.id.avatar_name_view);
        this.R = (TextView) r105.findViewById(R.id.avatar_tag);
        this.O = (LinearLayout) r105.findViewById(R.id.avatar_list_view);
        this.P = (TextView) r105.findViewById(R.id.link_guest_num);
        this.S = (TextView) r105.findViewById(R.id.more_room_btn);
        this.N = (CountDownWithDescTextView) r105.findViewById(R.id.match_go_btn);
        this.T = (RecyclerView) r105.findViewById(R.id.avatar_rv);
        goto L19
    L17:
        this.H = (TextView) r105.findViewById(R.id.cancel_btn);
        this.I = (HSImageView) r105.findViewById(R.id.ttlive_avatar_view);
        this.f80329J = (HSImageView) r105.findViewById(R.id.avatar_gender_view);
        TextView r107 = (TextView) r105.findViewById(R.id.avatar_name_view);
        this.K = (LinearLayout) r105.findViewById(R.id.avatar_topic_list_view);
        this.L = r105.findViewById(R.id.center_guideline);
        this.M = (TextView) r105.findViewById(R.id.rematch_btn);
        this.N = (CountDownWithDescTextView) r105.findViewById(R.id.match_go_btn);
        this.O = (LinearLayout) r105.findViewById(R.id.avatar_list_view);
        this.P = (TextView) r105.findViewById(R.id.link_guest_num);
    L19:
        if (this.f80338l == false) goto L26;
        int r108 = us1.g.f551445a;
        DataCenter r109 = this.f80335i;
        if (r109 == null) goto L23;
        Boolean r110 = (Boolean) r109.get("data_room_video_talk_integration_audience_has_send_prepare_apply_flag", Boolean.FALSE);
    L24:
        Z90(Intrinsics.areEqual(r110, Boolean.TRUE) ? 1 : 0);
    L30:
        ChatMatchViewModel r111 = this.f80334h;
        if (r111 == null) goto L48;
        MutableLiveData<Boolean> r112 = r111.getMatchingState();
        if (r112 == null) goto L48;
        if (Intrinsics.areEqual(r112.getValue(), Boolean.FALSE) == false) goto L39;
        gk0.a r113 = this.f80339m;
        if (r113 == null) goto L39;
        r113.c(LinkMatchType.MATCH.getValue());
    L39:
        Boolean r114 = r112.getValue();
        Boolean r115 = Boolean.TRUE;
        ba0(Intrinsics.areEqual(r114, r115));
        if (Intrinsics.areEqual(r112.getValue(), r115) == false) goto L44;
        ImageView r116 = this.f80349w;
        if (r116 == null) goto L47;
        r116.setVisibility(8);
    L47:
        r112.observe(this, new l(this));
        goto L48
    L44:
        ImageView r117 = this.f80349w;
        if (r117 == null) goto L47;
        r117.setVisibility(0);
    L48:
        ChatMatchViewModel r118 = this.f80334h;
        if (r118 == null) goto L56;
        MutableLiveData<b1> r119 = r118.getMatchData();
        if (r119 == null) goto L56;
        b1 r120 = r119.getValue();
        if (r120 == null) goto L55;
        aa0(r120);
    L55:
        r119.observe(this, new k(this));
    L56:
        ChatMatchViewModel r121 = this.f80334h;
        if (r121 == null) goto L61;
        MutableLiveData<a5> r122 = r121.getDisplayText();
        if (r122 == null) goto L61;
        r122.observe(this, new com.bytedance.android.live.liveinteract.voicechat.match.view.d(this));
    L61:
        ChatMatchViewModel r123 = this.f80334h;
        if (r123 == null) goto L66;
        MutableLiveData<Boolean> r124 = r123.isPrepareApplySuccess();
        if (r124 == null) goto L66;
        r124.observe(this, new n(this));
    L66:
        ChatMatchViewModel r125 = this.f80334h;
        if (r125 == null) goto L71;
        MutableLiveData<Boolean> r126 = r125.getPrepareApplyCancel();
        if (r126 == null) goto L71;
        r126.observe(this, new m(this));
    L71:
        W90();
        IRoom r127 = this.f80333g;
        if (r127 != null) goto L74;
    L86:
        TextView r128 = this.f80351y;
        if (r128 == null) goto L89;
        r128.setOnClickListener(new e(this));
    L89:
        CountDownWithDescTextView r129 = this.C;
        if (r129 == null) goto L92;
        r129.setOnClickListener(new f(this));
    L92:
        TextView r130 = this.H;
        if (r130 == null) goto L95;
        r130.setOnClickListener(new g(this));
    L95:
        TextView r131 = this.M;
        if (r131 == null) goto L99;
        r131.setOnClickListener(new ChatMatchDialog$initOnClickListener$4(this));
    L99:
        if (vm2.h.U().f() == false) goto L106;
        TextView r132 = this.S;
        if (r132 == null) goto L103;
        r132.setOnClickListener(new h(this));
    L103:
        HSImageView r133 = this.I;
        if (r133 == null) goto L106;
        r133.setOnClickListener(new i(this));
    L106:
        CountDownWithDescTextView r134 = this.N;
        if (r134 == null) goto L110;
        r134.setOnClickListener(new j(this));
    L110:
        if (this.f80342p == false) goto L113;
        this.f80342p = false;
        int r135 = ik0.g.f490176b;
        Y90(0);
        return;
    L113:
        return;
    L74:
        if (this.f80336j != null) goto L86;
        Integer r136 = (Integer) hd0.c.f().f481009b;
        if (r136 != null) goto L79;
    L80:
        ImageView r137 = this.f80349w;
        if (r137 == null) goto L83;
        r137.setVisibility(8);
    L83:
        ChatMatchViewModel r138 = this.f80334h;
        if (r138 == null) goto L86;
        r138.getUserWaitingRankPosition(r127);
        goto L86
    L79:
        if (r136.intValue() == 2) goto L86;
    L23:
        r110 = null;
        goto L24
    L26:
        if (hd0.c.f().j() == false) goto L28;
        Integer r139 = (Integer) hd0.c.f().f481009b;
    L29:
        Z90(r139.intValue());
        goto L30
    L28:
        r139 = -1;
        goto L29
    L11:
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_chat_match_result_v2, (ViewGroup) S90(R.id.body_with_rematch));
        goto L12
    L6:
        if (r102.intValue() == 2) goto L9;
        goto L7
    }

    public static final void T90(ChatMatchDialog r100, b1 r110, Function0 r111) {
        r100.getClass();
        if (vm2.d.e().b() == true) goto L5;
        r111.invoke();
        return;
    L5:
        boolean r101 = hd0.c.f().j();
        if (r100.f80337k == true) goto L10;
        if (r101 == false) goto L10;
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        int r103 = s1.j(R.dimen.ttlive_fast_match_search_container_height);
    L16:
        if (vm2.h.U().f() == false) goto L19;
        int r104 = s1.j(R.dimen.ttlive_fast_match_result_v3_container_height);
    L18:
        int r105 = r104;
        ValueAnimator r106 = r100.f80340n;
        if (r106 != null) goto L29;
    L31:
        float[] r107 = {1.0f, 0.0f};
        if (r110 == null) goto L35;
        r107 = {x00c4: FILL_ARRAY_DATA  (LINE:50331844), data: [0, 1065353216} // fill-array;
    L35:
        ValueAnimator r108 = ValueAnimator.ofFloat(r107);
        r100.f80340n = r108;
        if (r108 == null) goto L38;
        r108.addUpdateListener(new com.bytedance.android.live.liveinteract.voicechat.match.view.a(r100, r105, r103, r102));
    L38:
        ValueAnimator r109 = r100.f80340n;
        if (r109 == null) goto L41;
        r109.addListener(new com.bytedance.android.live.liveinteract.voicechat.match.view.b(r100, r110, r105, r102, r111));
    L41:
        ValueAnimator r112 = r100.f80340n;
        if (r112 == null) goto L44;
        r112.setDuration(200);
    L44:
        ValueAnimator r113 = r100.f80340n;
        if (r113 == null) goto L49;
        r113.start();
        return;
    L49:
        return;
    L29:
        if (r106.isRunning() == false) goto L31;
        r106.cancel();
        goto L31
    L19:
        if (r110 == null) goto L25;
        List<String> r114 = r110.getTopicStrList();
        if (r114 == null) goto L25;
        if ((!r114.isEmpty()) != true) goto L25;
        r104 = s1.j(R.dimen.ttlive_fast_match_result_v2_container_height);
    L25:
        r104 = s1.j(R.dimen.ttlive_fast_match_result_v2_container_height_no_topic);
        goto L18
    L14:
        r103 = (s1.j(R.dimen.ttlive_fast_match_search_container_margin) * 2) + (s1.j(R.dimen.ttlive_fast_match_title_container_height) + s1.j(R.dimen.ttlive_fast_match_search_container_height));
    L10:
        r102 = true;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_chat_match, r101);
    }
}
