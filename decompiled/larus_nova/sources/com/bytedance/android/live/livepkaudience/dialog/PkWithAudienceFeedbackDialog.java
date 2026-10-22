package com.bytedance.android.live.livepkaudience.dialog;

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
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.FeedbackApi;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.livepkaudience.view.PkWithAudienceFeedbackView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.badger.collect.impl.constants.Constants;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkWithAudienceFeedbackDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkWithAudienceFeedbackDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f81743m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f81744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f81745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Room f81746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f81747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f81748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f81749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.rank.model.g f81750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public gd0.c f81751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f81752l;

    public static final class a {
        public a() {
        }

        public static PkWithAudienceFeedbackDialog a(int r100, boolean r101, String r102) {
            int r103 = PkWithAudienceFeedbackDialog.f81743m;
            Intrinsics.checkNotNullParameter(r102, "requestPage");
            PkWithAudienceFeedbackDialog r104 = new PkWithAudienceFeedbackDialog();
            r104.f81746f = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
            r104.f81747g = r101;
            r104.f81748h = r100;
            r104.setCancelable(false);
            r104.f81752l = false;
            return r104;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkWithAudienceFeedbackDialog f81753a;

        public b(PkWithAudienceFeedbackDialog r100) {
            this.f81753a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            if (r101 == null) goto L17;
            com.bytedance.android.livesdk.rank.model.g r102 = (com.bytedance.android.livesdk.rank.model.g) r101.data;
            if (r102 == null) goto L19;
            PkWithAudienceFeedbackDialog r103 = this.f81753a;
            r103.f81750j = r102;
            if (r103.isViewValid() == false) goto L22;
            com.bytedance.android.livesdk.rank.model.g r104 = r103.f81750j;
            if (r104 == null) goto L20;
            ((PkWithAudienceFeedbackView) r103.S90(R.id.feedback_view)).setVisibility(0);
            ((TextView) r103.S90(R.id.net_error)).setVisibility(8);
            PkWithAudienceFeedbackView r105 = (PkWithAudienceFeedbackView) r103.S90(R.id.feedback_view);
            r105.getClass();
            Intrinsics.checkNotNullParameter(r104, "issues");
            r105.f82312b = r104;
            ((LinearLayout) r105.a(R.id.tag_container)).setVisibility(0);
            List<com.bytedance.android.livesdk.rank.model.b> r106 = r104.getIssueCategories();
            if (r106 == null) goto L21;
            Iterator<com.bytedance.android.livesdk.rank.model.b> r107 = r106.iterator();
        L15:
            if (r107.hasNext() == false) goto L23;
            TextView r108 = r105.b(r107.next().getCategory());
            r108.setOnClickListener(r105.f82318h);
            ViewGroup.LayoutParams r109 = new ViewGroup.LayoutParams(-2, -2);
            ((WrapLineFlowLayout) r105.a(R.id.tags_random)).addView(r108, r109);
            goto L15
        L23:
            return;
        L21:
            return;
        L20:
            return;
        L22:
            return;
        L19:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkWithAudienceFeedbackDialog f81754a;

        public c(PkWithAudienceFeedbackDialog r100) {
            this.f81754a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            PkWithAudienceFeedbackDialog r102 = this.f81754a;
            int r103 = PkWithAudienceFeedbackDialog.f81743m;
            if (r102.isViewValid() == false) goto L7;
            ((PkWithAudienceFeedbackView) r102.S90(R.id.feedback_view)).setVisibility(8);
            ((TextView) r102.S90(R.id.net_error)).setVisibility(0);
            return;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkWithAudienceFeedbackDialog f81755a;

        public d(PkWithAudienceFeedbackDialog r100) {
            this.f81755a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            PkWithAudienceFeedbackDialog r101 = this.f81755a;
            int r102 = PkWithAudienceFeedbackDialog.f81743m;
            r101.W90();
        }
    }

    static {
        new a();
    }

    public final void initData() {
        Room r100 = this.f81746f;
        if (r100 == null) goto L6;
        FeedbackApi r101 = (FeedbackApi) com.bytedance.android.live.network.c.b().e(FeedbackApi.class);
        long r102 = r100.f162599id;
        FeedbackApi.a.a(r101, r102, r102, 8, this.f81749i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        return;
    }

    public PkWithAudienceFeedbackDialog() {
        this.f81744d = new LinkedHashMap();
        this.f81745e = 1000;
        this.f81749i = "";
    }

    public final void W90() {
        Dialog r100 = getDialog();
        Context r101 = getContext();
        if (r100 == null) goto L18;
        if (r101 == null) goto L20;
        Object r102 = r101.getSystemService("input_method");
        if (r102 == null) goto L17;
        InputMethodManager r103 = (InputMethodManager) r102;
        if (r103.isActive() == false) goto L19;
        PkWithAudienceFeedbackView r104 = (PkWithAudienceFeedbackView) S90(R.id.feedback_view);
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

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f81751k = null;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f81744d).clear();
    }

    public static final boolean T90(PkWithAudienceFeedbackDialog r100) {
        String r101 = ((PkWithAudienceFeedbackView) r100.S90(R.id.feedback_view)).getSelectedSubTag();
        if (r101 == null) goto L10;
        if (StringsKt.trim(r101).toString().length() <= r100.f81745e) goto L7;
        f2.b(R.string.ttlive_talk_room_feedback_content_size_limit, 0);
        return false;
    L7:
        return true;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final void U90(PkWithAudienceFeedbackDialog r100) {
        if (r100.f81747g == false) goto L7;
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r101 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r101 == null) goto L11;
        r101.finishInteract("stop_normally");
        return;
    L11:
        return;
    L7:
        com.bytedance.android.live.livepkaudience.service.d.f82252x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r102 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r102 == null) goto L13;
        com.bytedance.android.live.livepkaudience.service.d.b.b(r102);
        return;
    }

    public static final void V90(PkWithAudienceFeedbackDialog r100) {
        r100.getClass();
        LinkedHashMap r101 = new LinkedHashMap();
        tc0.c r102 = tc0.c.h();
        String r103 = ((PkWithAudienceFeedbackView) r100.S90(R.id.feedback_view)).getSelectedTag();
        String r104 = ((PkWithAudienceFeedbackView) r100.S90(R.id.feedback_view)).getSelectedSubTag();
        Room r105 = r100.f81746f;
        long r106 = 0;
        if (r105 == null) goto L5;
        long r107 = r105.f162599id;
    L6:
        r101.put("room_id", Long.valueOf(r107));
        Room r108 = r100.f81746f;
        if (r108 == null) goto L9;
        r106 = r108.f162599id;
    L9:
        r101.put("channel_id", Long.valueOf(r106));
        if (r103 != null) goto L12;
        String r109 = "";
    L13:
        r101.put("issue_category", r109);
        r101.put("issue_content", r104);
        r101.put("scene", 8);
        r101.put(Constants.OperatorKey.KEY_VENDOR, "byte");
        Room r110 = r100.f81746f;
        if (r110 == null) goto L17;
        String r111 = r110.getOwnerUserIdString();
        if (r111 == null) goto L17;
    L18:
        r101.put("anchor_id", r111);
        r101.put("self_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
        boolean r112 = false;
        if (r100.f81749i.length() <= 0) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == false) goto L24;
        r101.put("third_party_scene", r100.f81749i);
    L24:
        JSONObject r114 = new JSONObject();
        int r115 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        r114.put("link_mode", r115);
        if (r115 != 0) goto L27;
        String r116 = "none";
    L34:
        r114.put("link_type", r116);
        if (r100.f81747g == true) goto L37;
    L40:
        r114.put("link_mic_str", r102.f545349f);
        r101.put("extra_str", r114.toString());
        ((ObservableSubscribeProxy) ((FeedbackApi) com.bytedance.android.live.network.c.b().e(FeedbackApi.class)).feedback(r101).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r100.getActivity()))).subscribe(new z(r100, r103, r104), a0.f81799a);
        return;
    L37:
        if (r102.f545364u != 1) goto L39;
        r112 = true;
    L39:
        r114.put("is_client_mixstream", r112);
        goto L40
    L27:
        if (r115 != 4) goto L29;
        r116 = "video_audience";
        goto L34
    L29:
        if (r115 == 32) goto L31;
        r116 = "other";
        goto L34
    L31:
        r116 = LinkConstant.VIDEO_TALK;
        goto L34
    L21:
        r113 = false;
    L17:
        r111 = "0";
        goto L18
    L12:
        r109 = r103;
        goto L13
    L5:
        r107 = 0;
        goto L6
    }

    public final View S90(int r100) {
        if (this.f81744d != null) goto L5;
        this.f81744d = new LinkedHashMap();
    L5:
        View r101 = this.f81744d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f81744d.put(Integer.valueOf(r100), r103);
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
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.width = -1;
        r103.height = -1;
        r102.setAttributes(r103);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setGravity(80);
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
        W90();     // Catch: Throwable -> L5
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
        if (this.f81747g == false) goto L5;
        ((TextView) S90(R.id.title)).setText(s1.B(R.string.ttlive_talk_room_feedback_title2));
        ((TextView) S90(R.id.sub_title)).setText(s1.B(R.string.ttlive_talk_room_feedback_sub_title2));
        ((Button) S90(R.id.ttlive_finish)).setText(s1.B(R.string.ttlive_talk_room_feedback_submit));
    L6:
        S90(R.id.ttlive_mask_view).setOnClickListener(new u(this));
        ((Button) S90(R.id.ttlive_finish)).setOnClickListener(new v(this));
        ((Button) S90(R.id.ttlive_cancel)).setOnClickListener(new w(this));
        ((TextView) S90(R.id.net_error)).setOnClickListener(new x(this));
        ((PkWithAudienceFeedbackView) S90(R.id.feedback_view)).setListener(new y(this));
        if (this.f81752l == false) goto L23;
        TextView r102 = (TextView) S90(R.id.title);
        if (r102 == null) goto L11;
        r102.setText(s1.B(R.string.ttlive_talkroom_feedback_dialog_title));
    L11:
        LinearLayout r103 = (LinearLayout) S90(R.id.finish);
        if (r103 == null) goto L14;
        r103.setVisibility(8);
    L14:
        Button r104 = (Button) S90(R.id.ttlive_submit);
        if (r104 == null) goto L17;
        r104.setVisibility(0);
    L17:
        Button r105 = (Button) S90(R.id.ttlive_submit);
        if (r105 == null) goto L20;
        r105.setAlpha(0.34f);
    L20:
        ((PkWithAudienceFeedbackView) S90(R.id.feedback_view)).setListener(new s(this));
        Button r106 = (Button) S90(R.id.ttlive_submit);
        if (r106 == null) goto L23;
        r106.setOnClickListener(new t(this));
    L23:
        initData();
        LinkedHashMap r107 = new LinkedHashMap();
        if (this.f81747g == false) goto L26;
        String r108 = "anchor";
    L27:
        r107.put("user_type", r108);
        int r109 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        el0.j.l(r107, r109);
        el0.j.j(r107, Integer.valueOf(r109));
        el0.j.o(r107);
        r107.put("is_ksong", "0");
        boolean r110 = this.f81747g;
        if (r110 == false) goto L41;
        if (r110 == false) goto L36;
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r111 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r111 == null) goto L36;
        com.bytedance.android.live.livepkaudience.base.i r112 = r111.getLinkUserCenter();
        if (r112 == null) goto L36;
        int r113 = r112.b();
    L37:
        if (r113 <= 0) goto L39;
        String r114 = "end_ahead";
    L40:
        r107.put("request_page", r114);
        goto L41
    L39:
        r114 = "normal";
    L36:
        r113 = 0;
    L41:
        el0.j.n(r107, Integer.valueOf(r109));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_chat_feedback_show", r107, new Object[]{am2.x.class, Room.class});
        return;
    L26:
        r108 = "guest";
        goto L27
    L5:
        ((TextView) S90(R.id.title)).setText(s1.B(R.string.ttlive_talk_room_feedback_title2));
        ((Button) S90(R.id.ttlive_finish)).setText(s1.B(R.string.ttlive_talk_room_feedback_submit_for_guest));
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_pk_with_audience_feedback, r101, false);
    }
}
