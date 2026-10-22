package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.FeedbackApi;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/TalkRoomFeedbackDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TalkRoomFeedbackDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f71958r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f71959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f71960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IRoom f71961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f71962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f71963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f71964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.rank.model.g f71965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f71966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public gd0.c f71967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f71968m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f71969n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public n f71970o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f71971p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Object f71972q;

    public static final class a {
        public a() {
        }

        public static TalkRoomFeedbackDialog a(int r100, boolean r101, String r102, com.bytedance.android.live.liveinteract.service.n r103, boolean r104, n r105, Integer r106, zi0.d.a r110, int r111) {
            int r107 = TalkRoomFeedbackDialog.f71958r;
            if ((r111 & 16) == 0) goto L6;
            r103 = null;
        L6:
            if ((r111 & 64) == 0) goto L9;
            r104 = false;
        L9:
            if ((r111 & 128) == 0) goto L12;
            r105 = null;
        L12:
            if ((r111 & 256) == 0) goto L15;
            r106 = null;
        L15:
            if ((r111 & 512) == 0) goto L17;
            r110 = null;
        L17:
            Intrinsics.checkNotNullParameter(r102, "requestPage");
            TalkRoomFeedbackDialog r112 = new TalkRoomFeedbackDialog();
            r112.f71961f = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            r112.f71962g = r101;
            r112.f71963h = r100;
            r112.f71966k = r102;
            r112.setCancelable(false);
            if (r103 == null) goto L20;
            r112.f71967l = r103;
        L20:
            r112.f71968m = r104;
            r112.f71970o = r105;
            r112.f71971p = r106;
            r112.f71972q = r110;
            return r112;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TalkRoomFeedbackDialog f71973a;

        public b(TalkRoomFeedbackDialog r100) {
            this.f71973a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            if (r101 == null) goto L24;
            com.bytedance.android.livesdk.rank.model.g r102 = (com.bytedance.android.livesdk.rank.model.g) r101.data;
            if (r102 == null) goto L26;
            TalkRoomFeedbackDialog r103 = this.f71973a;
            r103.f71965j = r102;
            if (r103.isViewValid() == false) goto L29;
            com.bytedance.android.livesdk.rank.model.g r104 = r103.f71965j;
            if (r104 != null) goto L12;
            return;
        L12:
            if (r103.f71968m == false) goto L14;
        L17:
            ((TalkRoomFeedbackView) r103.S90(R.id.feedback_view)).setVisibility(0);
        L18:
            ((TextView) r103.S90(R.id.net_error)).setVisibility(8);
            TalkRoomFeedbackView r105 = (TalkRoomFeedbackView) r103.S90(R.id.feedback_view);
            r105.getClass();
            Intrinsics.checkNotNullParameter(r104, "issues");
            r105.f72475b = r104;
            ((LinearLayout) r105.a(R.id.tag_container)).setVisibility(0);
            List<com.bytedance.android.livesdk.rank.model.b> r106 = r104.getIssueCategories();
            if (r106 == null) goto L28;
            Iterator<com.bytedance.android.livesdk.rank.model.b> r107 = r106.iterator();
        L22:
            if (r107.hasNext() == false) goto L30;
            TextView r108 = r105.b(r107.next().getCategory());
            r108.setOnClickListener(r105.f72482i);
            ViewGroup.LayoutParams r109 = new ViewGroup.LayoutParams(-2, -2);
            ((WrapLineFlowLayout) r105.a(R.id.tags_random)).addView(r108, r109);
            goto L22
        L30:
            return;
        L28:
            return;
        L14:
            if (r103.f71969n == false) goto L17;
            ((TalkRoomFeedbackView) r103.S90(R.id.feedback_view)).setVisibility(8);
            goto L18
        L29:
            return;
        L26:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TalkRoomFeedbackDialog f71974a;

        public c(TalkRoomFeedbackDialog r100) {
            this.f71974a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            TalkRoomFeedbackDialog r102 = this.f71974a;
            int r103 = TalkRoomFeedbackDialog.f71958r;
            if (r102.isViewValid() == false) goto L7;
            ((TalkRoomFeedbackView) r102.S90(R.id.feedback_view)).setVisibility(8);
            ((TextView) r102.S90(R.id.net_error)).setVisibility(0);
            return;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TalkRoomFeedbackDialog f71975a;

        public d(TalkRoomFeedbackDialog r100) {
            this.f71975a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            TalkRoomFeedbackDialog r101 = this.f71975a;
            int r102 = TalkRoomFeedbackDialog.f71958r;
            r101.Z90();
        }
    }

    static {
        new a();
    }

    public final int Y90() {
        if (this.f71962g == true) goto L5;
        return 0;
    L5:
        int r100 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r100, 32) == false) goto L14;
        rj0.k.f537953m2.getClass();
        rj0.k r101 = rj0.k.a.a();
        if (r101 == null) goto L21;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r102 = r101.getLinkUserInfoCenter();
        if (r102 != null) goto L12;
        return 0;
    L12:
        return r102.b();
    L21:
        return 0;
    L14:
        if (gd0.v.a(r100, 8) == false) goto L23;
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r103 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r103 == null) goto L24;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r104 = r103.getLinkUserInfoCenter();
        if (r104 != null) goto L20;
        return 0;
    L20:
        return r104.b();
    L24:
        return 0;
    L23:
        return 0;
    }

    public final void initData() {
        IRoom r100 = this.f71961f;
        if (r100 == null) goto L6;
        ((FeedbackApi) com.bytedance.android.live.network.c.b().e(FeedbackApi.class)).getFeedbackType(r100.getId(), r100.getId(), this.f71963h, this.f71964i, this.f71971p).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        return;
    }

    public TalkRoomFeedbackDialog() {
        this.f71959d = new LinkedHashMap();
        this.f71960e = 1000;
        this.f71964i = "";
        this.f71966k = "";
        this.f71969n = ((Boolean) vm2.h.f556209p6.getValue(null, vm2.h.f556082a[378(0x17a, float:5.3E-43)])).booleanValue();
    }

    public final void Z90() {
        Dialog r100 = getDialog();
        Context r101 = getContext();
        if (r100 == null) goto L18;
        if (r101 == null) goto L20;
        Object r102 = r101.getSystemService("input_method");
        if (r102 == null) goto L17;
        InputMethodManager r103 = (InputMethodManager) r102;
        if (r103.isActive() == false) goto L19;
        TalkRoomFeedbackView r104 = (TalkRoomFeedbackView) S90(R.id.feedback_view);
        if (r104 == null) goto L13;
        IBinder r105 = r104.getWindowToken();
    L14:
        r103.hideSoftInputFromWindow(r105, 0);
        return;
    L13:
        r105 = null;
        goto L14
    L19:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L20:
        return;
    }

    public final void aa0() {
        TextView r100 = (TextView) S90(R.id.sub_title);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L5;
    L8:
        String r101 = s1.B(R.string.ttlive_talk_room_feedback_sub_title2);
    L9:
        r100.setText(r101);
        TextView r102 = (TextView) S90(R.id.tag_title_tv);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L12;
    L15:
        String r103 = s1.B(R.string.ttlive_talk_room_feedback_tag_title2);
    L16:
        r102.setText(r103);
        return;
    L12:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L15;
        r103 = s1.B(R.string.ttlive_talk_room_feedback_tag_title);
        goto L16
    L5:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L8;
        r101 = s1.B(R.string.ttlive_talk_room_feedback_sub_title);
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f71967l = null;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f71959d.clear();
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Integer r100 = this.f71971p;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.intValue() != 16) goto L9;
        g2 r101 = zi0.d.f572224b;
        Object r102 = this.f71972q;
        LinkedHashMap r103 = new LinkedHashMap();
        zi0.d.a(r103, r102);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_grouppk_breakoff_quest_show", r103, new Object[]{am2.x.class, IRoom.class});
        return;
    }

    public static final boolean T90(TalkRoomFeedbackDialog r100) {
        String r101 = ((TalkRoomFeedbackView) r100.S90(R.id.feedback_view)).getSelectedSubTag();
        if (r101 == null) goto L10;
        if (StringsKt.trim(r101).toString().length() <= r100.f71960e) goto L7;
        f2.b(R.string.ttlive_talk_room_feedback_content_size_limit, 0);
        return false;
    L7:
        return true;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final void X90(TalkRoomFeedbackDialog r110) {
        r110.getClass();
        LinkedHashMap r100 = new LinkedHashMap();
        tc0.c r101 = tc0.c.h();
        String r102 = ((TalkRoomFeedbackView) r110.S90(R.id.feedback_view)).getSelectedTag();
        String r103 = ((TalkRoomFeedbackView) r110.S90(R.id.feedback_view)).getSelectedSubTag();
        boolean r104 = false;
        if (r110.f71969n == true) goto L5;
    L7:
        IRoom r105 = r110.f71961f;
        long r106 = 0;
        if (r105 == null) goto L10;
        long r107 = r105.getId();
    L11:
        r100.put("room_id", Long.valueOf(r107));
        IRoom r108 = r110.f71961f;
        if (r108 == null) goto L14;
        r106 = r108.getId();
    L14:
        r100.put("channel_id", Long.valueOf(r106));
        String r109 = "";
        if (r102 != null) goto L17;
        String r111 = "";
    L18:
        r100.put("issue_category", r111);
        r100.put("issue_content", r103);
        r100.put("scene", Integer.valueOf(r110.f71963h));
        r100.put(Constants.OperatorKey.KEY_VENDOR, 4);
        IRoom r112 = r110.f71961f;
        if (r112 == null) goto L24;
        String r113 = r112.getOwnerUserIdString();
        if (r113 == null) goto L24;
        r109 = r113;
    L24:
        r100.put("anchor_id", r109);
        r100.put("self_id", ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n());
        Integer r114 = r110.f71971p;
        if (r114 == null) goto L28;
        r100.put(FastStartLiveConfig.PLAY_MODE, String.valueOf(r114.intValue()));
    L28:
        if (r110.f71964i.length() <= 0) goto L30;
        boolean r115 = true;
    L31:
        if (r115 == false) goto L33;
        r100.put("third_party_scene", r110.f71964i);
    L33:
        JSONObject r116 = new JSONObject();
        int r117 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        r116.put("link_mode", r117);
        if (r117 != 0) goto L36;
        String r118 = "none";
    L46:
        r116.put("link_type", r118);
        if (r110.f71962g == true) goto L49;
    L52:
        r116.put("link_mic_str", r101.f545349f);
        r100.put("extra_str", r116.toString());
        ((ObservableSubscribeProxy) ((FeedbackApi) com.bytedance.android.live.network.c.b().e(FeedbackApi.class)).feedback(r100).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r110.getActivity()))).subscribe(new n0(r110, r102, r103), o0.f72054a);
        return;
    L49:
        if (r101.f545364u != 1) goto L51;
        r104 = true;
    L51:
        r116.put("is_client_mixstream", r104);
        goto L52
    L36:
        if (r117 != 2) goto L38;
        r118 = "video_audience";
        goto L46
    L38:
        if (r117 != 8) goto L40;
        r118 = "audio_talk";
        goto L46
    L40:
        if (r117 == 32) goto L42;
        r118 = "other";
        goto L46
    L42:
        r118 = LinkConstant.VIDEO_TALK;
        goto L46
    L30:
        r115 = false;
        goto L31
    L17:
        r111 = r102;
        goto L18
    L10:
        r107 = 0;
        goto L11
    L5:
        if (mz.c.b(r103) == false) goto L7;
        f2.b(R.string.ttlive_ktv_feedback_submit_success_toast, 0);
    }

    public final View S90(int r100) {
        if (this.f71959d != null) goto L5;
        this.f71959d = new LinkedHashMap();
    L5:
        View r101 = this.f71959d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f71959d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.width = -1;
        r103.height = -1;
        r102.setAttributes(r103);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setGravity(80);
        c1.b(r102, 0, 14);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_live_interact_dialog);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnCancelListener(new d(this));
        r101.setCanceledOnTouchOutside(true);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setLayout(-1, -1);
        r102.setSoftInputMode(32);
    L5:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        Z90();     // Catch: Throwable -> L5
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

    public static final void U90(TalkRoomFeedbackDialog r100, boolean r101) {
        String r102 = r100.f71966k;
        int r103 = r102.hashCode();
        if (r103 == (-1383228885)) goto L11;
        if (r103 == 3526149) goto L8;
    L13:
        int r104 = 200;
    L14:
        int r105 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r105, 32) == false) goto L25;
        if (r100.f71962g == false) goto L21;
        rj0.k.f537953m2.getClass();
        rj0.k r106 = rj0.k.a.a();
        if (r106 == null) goto L35;
        rj0.k.b.a(r106);
        return;
    L35:
        return;
    L21:
        rj0.l.f537955n2.getClass();
        rj0.l r107 = rj0.l.a.a();
        if (r107 == null) goto L37;
        rj0.l.b.d(r107, r104, !r101, false, 12);
        return;
    L37:
        return;
    L25:
        if (gd0.v.a(r105, 8) == true) goto L27;
        return;
    L27:
        if (r100.f71962g == false) goto L31;
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r108 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r108 == null) goto L40;
        r108.finishAudioTalk(r100.f71966k);
        return;
    L40:
        return;
    L31:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r109 = IVoiceChatGuestService.a.a();
        if (r109 == null) goto L42;
        IVoiceChatGuestService.b.b(r109, r104, false, !r101, false, 24);
        return;
    L42:
        return;
    L8:
        if (r102.equals("seat") == false) goto L13;
        r104 = 201;
        goto L14
    L11:
        if (r102.equals("bottom") == false) goto L13;
        r104 = 202;
        goto L14
    }

    public static final void V90(TalkRoomFeedbackDialog r100, String r101) {
        Integer r102 = r100.f71971p;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.intValue() != 16) goto L9;
        g2 r103 = zi0.d.f572224b;
        Object r104 = r100.f71972q;
        Intrinsics.checkNotNullParameter(r101, "clickType");
        LinkedHashMap r105 = new LinkedHashMap();
        zi0.d.a(r105, r104);
        r105.put("click_type", r101);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_grouppk_breakoff_quest_click", r105, new Object[]{am2.x.class, IRoom.class});
        return;
    }

    public static final void W90(TalkRoomFeedbackDialog r100, String r101) {
        Integer r102 = r100.f71971p;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.intValue() != 16) goto L9;
        g2 r103 = zi0.d.f572224b;
        Object r104 = r100.f71972q;
        Intrinsics.checkNotNullParameter(r101, "overType");
        LinkedHashMap r105 = new LinkedHashMap();
        zi0.d.a(r105, r104);
        r105.put("over_type", r101);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_grouppk_breakoff_quest_over", r105, new Object[]{am2.x.class, IRoom.class});
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        if (this.f71962g == false) goto L31;
        TextView r112 = (TextView) S90(R.id.title);
        if (Intrinsics.areEqual(this.f71966k, "scene_panel") == false) goto L7;
    L10:
        boolean r100 = true;
    L12:
        if (r100 == false) goto L18;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 29) goto L16;
        String r101 = s1.B(R.string.ttlive_talk_room_feedback_title2);
    L24:
        r112.setText(r101);
        aa0();
        if (je0.d.O() == true) goto L27;
    L29:
        ((Button) S90(R.id.ttlive_finish)).setText(s1.B(R.string.ttlive_talk_room_feedback_submit));
    L40:
        if (this.f71963h != 10) goto L43;
        ((TalkRoomFeedbackView) S90(R.id.feedback_view)).setTagTitleText(s1.B(R.string.ttlive_short_video_room_feedback_tag_title));
    L43:
        S90(R.id.ttlive_mask_view).setOnClickListener(new i0(this));
        ((Button) S90(R.id.ttlive_finish)).setOnClickListener(new j0(this));
        ((Button) S90(R.id.ttlive_cancel)).setOnClickListener(new k0(this));
        ((TextView) S90(R.id.net_error)).setOnClickListener(new l0(this));
        ((TalkRoomFeedbackView) S90(R.id.feedback_view)).setListener(new m0(this));
        if (this.f71968m == false) goto L89;
        if (this.f71970o == null) goto L73;
        TextView r113 = (TextView) S90(R.id.title);
        if (r113 == null) goto L56;
        n r102 = this.f71970o;
        if (r102 == null) goto L54;
        String r103 = r102.f72047a;
        if (r103 == null) goto L54;
    L55:
        r113.setText(r103);
    L54:
        r103 = s1.B(R.string.ttlive_talkroom_feedback_dialog_title);
    L56:
        n r114 = this.f71970o;
        if (r114 == null) goto L66;
        String r115 = r114.f72048b;
        if (r115 == null) goto L66;
        TextView r104 = (TextView) S90(R.id.sub_title);
        if (r104 == null) goto L63;
        r104.setText(r115);
    L63:
        TextView r116 = (TextView) S90(R.id.sub_title);
        if (r116 == null) goto L66;
        r116.setTextColor(ColorProtector.parseColor("#A3A3A3"));
    L66:
        n r117 = this.f71970o;
        if (r117 == null) goto L76;
        String r118 = r117.f72049c;
        if (r118 == null) goto L76;
        TalkRoomFeedbackView r105 = (TalkRoomFeedbackView) S90(R.id.feedback_view);
        if (r105 == null) goto L76;
        r105.setTagTitleText(r118);
    L76:
        LinearLayout r119 = (LinearLayout) S90(R.id.finish);
        if (r119 == null) goto L79;
        r119.setVisibility(8);
    L79:
        Button r106 = (Button) S90(R.id.ttlive_submit);
        if (r106 == null) goto L82;
        r106.setVisibility(0);
    L82:
        Button r107 = (Button) S90(R.id.ttlive_submit);
        if (r107 == null) goto L85;
        r107.setAlpha(0.34f);
    L85:
        ((TalkRoomFeedbackView) S90(R.id.feedback_view)).setListener(new g0(this));
        Button r120 = (Button) S90(R.id.ttlive_submit);
        if (r120 == null) goto L91;
        r120.setOnClickListener(new h0(this));
    L91:
        initData();
        LinkedHashMap r121 = new LinkedHashMap();
        if (this.f71962g == false) goto L94;
        String r108 = "anchor";
    L95:
        r121.put("user_type", r108);
        int r109 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.I0(r121, r109);
        TalkRoomLogUtils.B0(r121, Integer.valueOf(r109), null, 4);
        TalkRoomLogUtils.Q0(r121);
        r121.put("is_ksong", "0");
        if (this.f71962g == true) goto L98;
    L102:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_chat_feedback_show", r121, new Object[]{am2.x.class, IRoom.class});
        return;
    L98:
        if (Y90() <= 0) goto L100;
        String r122 = "end_ahead";
    L101:
        r121.put("request_page", r122);
        goto L102
    L100:
        r122 = "normal";
        goto L101
    L94:
        r108 = "guest";
        goto L95
    L73:
        TextView r123 = (TextView) S90(R.id.title);
        if (r123 == null) goto L76;
        r123.setText(s1.B(R.string.ttlive_talkroom_feedback_dialog_title));
        goto L76
    L89:
        if (this.f71969n == false) goto L91;
        ((TextView) S90(R.id.tv_feedback_exhibition)).setVisibility(0);
        ((TextView) S90(R.id.tv_feedback_exhibition)).setOnClickListener(new e0(this));
        ((TalkRoomFeedbackView) S90(R.id.feedback_view)).setSubitemSelectCountListener(new f0(this));
        goto L91
    L27:
        if (je0.d.F() == false) goto L29;
        ((TextView) S90(R.id.sub_title)).setText(s1.B(R.string.ttlive_talk_room_feedback_anchor_silence_sub_title));
        ((TextView) S90(R.id.sub_title)).setTextColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        goto L29
    L16:
        r101 = s1.B(R.string.ttlive_live_voice_chat_switch_to_radio_hint);
        goto L24
    L18:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L20;
    L23:
        r101 = s1.B(R.string.ttlive_talk_room_feedback_title2);
        goto L24
    L20:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L23;
        r101 = s1.B(R.string.ttlive_talk_room_feedback_title);
        goto L24
    L7:
        if (Intrinsics.areEqual(this.f71966k, "link_panel") == true) goto L10;
        r100 = false;
        goto L12
    L31:
        if (this.f71963h == 10) goto L37;
        TextView r124 = (TextView) S90(R.id.title);
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 29) goto L35;
        String r125 = s1.B(R.string.ttlive_talk_room_feedback_title3);
    L36:
        r124.setText(r125);
    L38:
        aa0();
        ((Button) S90(R.id.ttlive_finish)).setText(s1.B(R.string.ttlive_talk_room_feedback_submit_for_guest));
        goto L40
    L35:
        r125 = s1.B(R.string.ttlive_talk_room_feedback_title);
        goto L36
    L37:
        ((TextView) S90(R.id.title)).setText(s1.B(R.string.ttlive_short_video_room_feedback_title_for_guest));
        ((TextView) S90(R.id.sub_title)).setText(s1.B(R.string.ttlive_short_video_room_feedback_sub_title));
        goto L38
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_talk_room_feedback, r101, false);
    }
}
