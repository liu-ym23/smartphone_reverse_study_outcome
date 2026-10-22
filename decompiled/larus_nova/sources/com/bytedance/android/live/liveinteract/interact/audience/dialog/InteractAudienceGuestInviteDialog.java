package com.bytedance.android.live.liveinteract.interact.audience.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.c8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/InteractAudienceGuestInviteDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceGuestInviteDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f73634m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f73635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animation f73636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animation f73637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animation f73638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f73639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IRoom f73640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z0 f73641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f73642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IMessageBoardInfo f73643l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractAudienceGuestInviteDialog f73644a;

        public b(InteractAudienceGuestInviteDialog r100) {
            this.f73644a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            InteractAudienceGuestInviteDialog r101 = this.f73644a;
            int r102 = InteractAudienceGuestInviteDialog.f73634m;
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

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractAudienceGuestInviteDialog f73645a;

        public c(InteractAudienceGuestInviteDialog r100) {
            this.f73645a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            InteractAudienceGuestInviteDialog r101 = this.f73645a;
            IRoom r102 = r101.f73640i;
            if (r102 == null) goto L17;
            z0 r103 = r101.f73641j;
            if (r103 == null) goto L17;
            com.bytedance.android.live.liveinteract.plantform.base.e.f75489l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r104 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r104 == null) goto L17;
            long r105 = r102.getId();
            String r106 = r103.getSecFromUserId();
            if (r106 != null) goto L11;
            String r107 = "";
        L12:
            String r108 = r103.getFromUserIdStr();
            if (r108 != null) goto L15;
            String r109 = "";
        L16:
            r104.X3(r105, r107, r109, ReplyType.Reject.ordinal());
            goto L17
        L15:
            r109 = r108;
            goto L16
        L11:
            r107 = r106;
        L17:
            com.bytedance.android.live.liveinteract.utils.d r110 = jf0.c.f498873a;
            jf0.c.m("oneself", this.f73645a.f73643l);
            this.f73645a.dismiss();     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r111 = DialogFragmentLancet.sLastShowStack;
            if (r111 == null) goto L27;
            com.bytedance.crash.d.d(r111, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractAudienceGuestInviteDialog f73646a;

        public d(InteractAudienceGuestInviteDialog r100) {
            this.f73646a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            InteractAudienceGuestInviteDialog r101 = this.f73646a;
            IRoom r102 = r101.f73640i;
            if (r102 == null) goto L25;
            z0 r103 = r101.f73641j;
            if (r103 == null) goto L25;
            com.bytedance.android.live.liveinteract.plantform.base.e.f75489l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r104 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r104 == null) goto L25;
            long r105 = r102.getId();
            String r106 = r103.getSecFromUserId();
            if (r106 != null) goto L11;
            String r107 = "";
        L12:
            String r108 = r103.getFromUserIdStr();
            if (r108 != null) goto L15;
            String r109 = "";
        L16:
            r104.X3(r105, r107, r109, ReplyType.Agree.ordinal());
            goto L25
        L15:
            r109 = r108;
            goto L16
        L11:
            r107 = r106;
        L25:
            this.f73646a.dismiss();     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r110 = DialogFragmentLancet.sLastShowStack;
            if (r110 == null) goto L27;
            com.bytedance.crash.d.d(r110, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractAudienceGuestInviteDialog f73647a;

        public e(InteractAudienceGuestInviteDialog r100) {
            this.f73647a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Long r101 = (Long) r100;
            Intrinsics.checkNotNullParameter(r101, "sec");
            return Long.valueOf(((long) this.f73647a.f73642k) - r101.longValue());
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractAudienceGuestInviteDialog f73648a;

        public f(InteractAudienceGuestInviteDialog r100) {
            this.f73648a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ((TextView) this.f73648a.S90(R.id.refuse)).setText(s1.C(R.string.ttlive_interact_refuse_time, new Object[]{Integer.valueOf((int) r101.longValue())}));
            if (r101.longValue() != 0) goto L29;
            InteractAudienceGuestInviteDialog r102 = this.f73648a;
            IRoom r103 = r102.f73640i;
            if (r103 == null) goto L19;
            z0 r104 = r102.f73641j;
            if (r104 == null) goto L19;
            com.bytedance.android.live.liveinteract.plantform.base.e.f75489l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r105 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r105 == null) goto L19;
            long r106 = r103.getId();
            String r107 = r104.getSecFromUserId();
            if (r107 != null) goto L13;
            String r108 = "";
        L14:
            String r109 = r104.getFromUserIdStr();
            if (r109 != null) goto L17;
            String r110 = "";
        L18:
            r105.X3(r106, r108, r110, ReplyType.Reject.ordinal());
            goto L19
        L17:
            r110 = r109;
            goto L18
        L13:
            r108 = r107;
        L19:
            com.bytedance.android.live.liveinteract.utils.d r111 = jf0.c.f498873a;
            jf0.c.m("overtime", this.f73648a.f73643l);
            this.f73648a.dismiss();     // Catch: Exception -> L22
            return;
        L22:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r112 = DialogFragmentLancet.sLastShowStack;
            if (r112 == null) goto L30;
            com.bytedance.crash.d.d(r112, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L30:
            return;
        }
    }

    static {
    }

    public InteractAudienceGuestInviteDialog() {
        this.f73635d = new LinkedHashMap();
        this.f73639h = new CompositeDisposable();
        this.f73642k = 9;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f73639h.dispose();
        Animation r100 = this.f73637f;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        Animation r101 = this.f73638g;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        Animation r102 = this.f73636e;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        ((LinkedHashMap) this.f73635d).clear();
    }

    public final View S90(int r100) {
        if (this.f73635d != null) goto L5;
        this.f73635d = new LinkedHashMap();
    L5:
        View r101 = this.f73635d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f73635d.put(Integer.valueOf(r100), r103);
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
        this.f73636e = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_video_talk_beinvited);
        this.f73637f = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_video_talk_beinvited_user);
        this.f73638g = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_video_talk_beinvited_user_out);
        Animation r101 = this.f73637f;
        if (r101 == null) goto L5;
        r101.setRepeatCount(-1);
    L5:
        Animation r102 = this.f73636e;
        if (r102 == null) goto L8;
        r102.setInterpolator(new LinearInterpolator());
    L8:
        Animation r103 = this.f73637f;
        if (r103 == null) goto L12;
        r103.setInterpolator(new LinearInterpolator());
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnCancelListener(new b(this));
        r101.setCanceledOnTouchOutside(false);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        z0 r102 = this.f73641j;
        if (r102 == null) goto L25;
        IRoom r103 = this.f73640i;
        if (r103 == null) goto L8;
        String r104 = r103.getOwnerUserIdString();
        if (r104 == null) goto L8;
    L10:
        if (r102.isFromUser(r104) == true) goto L12;
        ((TextView) S90(R.id.invite_description_tv)).setText(R.string.ttlive_interact_video_talk_admin_invite);
    L17:
        ImageView r105 = (ImageView) S90(R.id.head);
        c8 r106 = r102.getInvitorInfo();
        String r107 = null;
        if (r106 == null) goto L20;
        k r108 = r106.getInvitorAvatar();
    L21:
        a1.v(r105, r108, R.drawable.ttlive_img_avatar_empty);
        TextView r109 = (TextView) S90(R.id.name);
        c8 r110 = r102.getInvitorInfo();
        if (r110 == null) goto L24;
        r107 = r110.getInvitorNickName();
    L24:
        r109.setText(r107);
        this.f73643l = r102.getMessageBoardInfo();
        goto L25
    L20:
        r108 = null;
        goto L21
    L12:
        TextView r111 = (TextView) S90(R.id.invite_description_tv);
        if (fj0.e.i() == false) goto L15;
        int r112 = R.string.ttlive_interact_video_talk_anchor_paid_invite;
    L16:
        r111.setText(r112);
        goto L17
    L15:
        r112 = R.string.ttlive_interact_video_talk_anchor_invite;
    L8:
        r104 = "";
    L25:
        Animation r113 = this.f73637f;
        if (r113 == null) goto L28;
        r113.setAnimationListener(new com.bytedance.android.live.liveinteract.interact.audience.dialog.a(this));
    L28:
        Animation r114 = this.f73638g;
        if (r114 == null) goto L31;
        r114.setAnimationListener(new com.bytedance.android.live.liveinteract.interact.audience.dialog.b(this));
    L31:
        Animation r115 = this.f73636e;
        if (r115 == null) goto L36;
        View r116 = S90(R.id.anim1);
        if (r116 == null) goto L36;
        r116.startAnimation(r115);
    L36:
        Animation r117 = this.f73637f;
        if (r117 == null) goto L41;
        HSImageView r118 = (HSImageView) S90(R.id.head);
        if (r118 == null) goto L41;
        r118.startAnimation(r117);
    L41:
        ((TextView) S90(R.id.refuse)).setOnClickListener(new c(this));
        ((TextView) S90(R.id.accept)).setOnClickListener(new d(this));
        ((TextView) S90(R.id.refuse)).setText(s1.C(R.string.ttlive_interact_refuse_time, new Object[]{Integer.valueOf(this.f73642k)}));
        this.f73639h.add(du2.a.d(1, TimeUnit.SECONDS).take(this.f73642k + 1).map(new e(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this)));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_interact_audience_invited, r101, false);
    }
}
