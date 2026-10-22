package com.bytedance.android.live.livepkaudience.dialog;

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
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.message.model.InvitorInfo;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
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

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkAudienceGuestInviteDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkAudienceGuestInviteDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f81653m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f81654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animation f81655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animation f81656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animation f81657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f81658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Room f81659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public xe f81660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f81661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MessageBoardInfo f81662l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkAudienceGuestInviteDialog f81663a;

        public b(PkAudienceGuestInviteDialog r100) {
            this.f81663a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            PkAudienceGuestInviteDialog r101 = this.f81663a;
            int r102 = PkAudienceGuestInviteDialog.f81653m;
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
        public final /* synthetic */ PkAudienceGuestInviteDialog f81664a;

        public c(PkAudienceGuestInviteDialog r100) {
            this.f81664a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PkAudienceGuestInviteDialog r101 = this.f81664a;
            Room r102 = r101.f81659i;
            if (r102 == null) goto L9;
            xe r103 = r101.f81660j;
            if (r103 == null) goto L9;
            com.bytedance.android.live.livepkaudience.service.d.f82252x0.getClass();
            com.bytedance.android.live.livepkaudience.service.d r104 = com.bytedance.android.live.livepkaudience.service.d.a.a();
            if (r104 == null) goto L9;
            r104.Rc(r102.f162599id, r103.getSecFromUserId(), ReplyType.Reject.ordinal());
        L9:
            int r105 = al0.c.f4120b;
            al0.c.i("oneself", this.f81664a.f81662l);
            this.f81664a.dismiss();     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r106 = DialogFragmentLancet.sLastShowStack;
            if (r106 == null) goto L19;
            com.bytedance.crash.d.d(r106, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkAudienceGuestInviteDialog f81665a;

        public d(PkAudienceGuestInviteDialog r100) {
            this.f81665a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PkAudienceGuestInviteDialog r101 = this.f81665a;
            Room r102 = r101.f81659i;
            if (r102 == null) goto L17;
            xe r103 = r101.f81660j;
            if (r103 == null) goto L17;
            com.bytedance.android.live.livepkaudience.service.d.f82252x0.getClass();
            com.bytedance.android.live.livepkaudience.service.d r104 = com.bytedance.android.live.livepkaudience.service.d.a.a();
            if (r104 == null) goto L17;
            r104.Rc(r102.f162599id, r103.getSecFromUserId(), ReplyType.Agree.ordinal());
        L17:
            this.f81665a.dismiss();     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r105 = DialogFragmentLancet.sLastShowStack;
            if (r105 == null) goto L19;
            com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkAudienceGuestInviteDialog f81666a;

        public e(PkAudienceGuestInviteDialog r100) {
            this.f81666a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Long r101 = (Long) r100;
            Intrinsics.checkNotNullParameter(r101, "sec");
            return Long.valueOf(((long) this.f81666a.f81661k) - r101.longValue());
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkAudienceGuestInviteDialog f81667a;

        public f(PkAudienceGuestInviteDialog r100) {
            this.f81667a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ((TextView) this.f81667a.S90(R.id.refuse)).setText(s1.C(R.string.ttlive_interact_refuse_time, new Object[]{Integer.valueOf((int) r101.longValue())}));
            if (r101.longValue() != 0) goto L21;
            PkAudienceGuestInviteDialog r102 = this.f81667a;
            Room r103 = r102.f81659i;
            if (r103 == null) goto L11;
            xe r104 = r102.f81660j;
            if (r104 == null) goto L11;
            com.bytedance.android.live.livepkaudience.service.d.f82252x0.getClass();
            com.bytedance.android.live.livepkaudience.service.d r105 = com.bytedance.android.live.livepkaudience.service.d.a.a();
            if (r105 == null) goto L11;
            r105.Rc(r103.f162599id, r104.getSecFromUserId(), ReplyType.Reject.ordinal());
        L11:
            int r106 = al0.c.f4120b;
            al0.c.i("overtime", this.f81667a.f81662l);
            this.f81667a.dismiss();     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r107 = DialogFragmentLancet.sLastShowStack;
            if (r107 == null) goto L22;
            com.bytedance.crash.d.d(r107, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L22:
            return;
        }
    }

    static {
    }

    public PkAudienceGuestInviteDialog() {
        this.f81654d = new LinkedHashMap();
        this.f81658h = new CompositeDisposable();
        this.f81661k = 9;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f81658h.dispose();
        Animation r100 = this.f81656f;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        Animation r101 = this.f81657g;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        Animation r102 = this.f81655e;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        ((LinkedHashMap) this.f81654d).clear();
    }

    public final View S90(int r100) {
        if (this.f81654d != null) goto L5;
        this.f81654d = new LinkedHashMap();
    L5:
        View r101 = this.f81654d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f81654d.put(Integer.valueOf(r100), r103);
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
        this.f81655e = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_pk_audience_beinvited);
        this.f81656f = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_pk_audience_beinvited_user);
        this.f81657g = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_pk_audience_beinvited_user_out);
        Animation r101 = this.f81656f;
        if (r101 == null) goto L5;
        r101.setRepeatCount(-1);
    L5:
        Animation r102 = this.f81655e;
        if (r102 == null) goto L8;
        r102.setInterpolator(new LinearInterpolator());
    L8:
        Animation r103 = this.f81656f;
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
        xe r102 = this.f81660j;
        if (r102 == null) goto L25;
        Room r103 = this.f81659i;
        MessageBoardInfo r104 = null;
        if (r103 == null) goto L7;
        String r105 = r103.getOwnerUserIdString();
    L9:
        if ((!Intrinsics.areEqual(r105, r102.getFromUserIdStr())) == false) goto L11;
        ((TextView) S90(R.id.invite_description_tv)).setText(R.string.ttlive_interact_video_talk_admin_invite);
    L12:
        ImageView r106 = (ImageView) S90(R.id.head);
        InvitorInfo r107 = r102.getInvitorInfo();
        if (r107 == null) goto L15;
        py.k r108 = r107.getInvitorAvatar();
    L16:
        a1.v(r106, r108, R.drawable.ttlive_img_avatar_empty);
        TextView r109 = (TextView) S90(R.id.name);
        InvitorInfo r110 = r102.getInvitorInfo();
        if (r110 == null) goto L19;
        String r111 = r110.getInvitorNickName();
    L20:
        r109.setText(r111);
        MessageBoardInfo r112 = r102.getMessageBoardInfo();
        if ((r112 instanceof MessageBoardInfo) == false) goto L24;
        r104 = r112;
    L24:
        this.f81662l = r104;
        goto L25
    L19:
        r111 = null;
        goto L20
    L15:
        r108 = null;
        goto L16
    L11:
        ((TextView) S90(R.id.invite_description_tv)).setText(R.string.ttlive_interact_video_talk_anchor_invite);
        goto L12
    L7:
        r105 = null;
    L25:
        Animation r113 = this.f81656f;
        if (r113 == null) goto L28;
        r113.setAnimationListener(new j(this));
    L28:
        Animation r114 = this.f81657g;
        if (r114 == null) goto L31;
        r114.setAnimationListener(new k(this));
    L31:
        Animation r115 = this.f81655e;
        if (r115 == null) goto L36;
        View r116 = S90(R.id.anim1);
        if (r116 == null) goto L36;
        r116.startAnimation(r115);
    L36:
        Animation r117 = this.f81656f;
        if (r117 == null) goto L41;
        HSImageView r118 = (HSImageView) S90(R.id.head);
        if (r118 == null) goto L41;
        r118.startAnimation(r117);
    L41:
        ((TextView) S90(R.id.refuse)).setOnClickListener(new c(this));
        ((TextView) S90(R.id.accept)).setOnClickListener(new d(this));
        ((TextView) S90(R.id.refuse)).setText(s1.C(R.string.ttlive_interact_refuse_time, new Object[]{Integer.valueOf(this.f81661k)}));
        this.f81658h.add(du2.a.d(1, TimeUnit.SECONDS).take(this.f81661k + 1).map(new e(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this)));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_pk_audience_invited, r101, false);
    }
}
