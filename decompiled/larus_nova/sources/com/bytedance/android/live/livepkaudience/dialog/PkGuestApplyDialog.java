package com.bytedance.android.live.livepkaudience.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.livepkaudience.vm.PkGuestApplyViewModel;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkGuestApplyDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkGuestApplyDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f81707t = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Room f81708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f81709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MultiTypeAdapter f81710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f81711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f81712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f81713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f81714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HSImageView f81715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f81716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f81717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f81718n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f81719o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f81720p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f81721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f81722r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f81723s;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkGuestApplyDialog f81724a;

        public b(PkGuestApplyDialog r100) {
            this.f81724a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.intValue() != 0) goto L11;
            TextView r102 = this.f81724a.f81718n;
            if (r102 == null) goto L9;
            r102.setText(s1.B(R.string.ttlive_interact_apply_again));
        L9:
            this.f81724a.T90(null);
            return;
        L11:
            if (r101.intValue() != 1) goto L16;
            TextView r103 = this.f81724a.f81718n;
            if (r103 == null) goto L29;
            r103.setText(s1.B(R.string.ttlive_anchor_link_cancel_apply));
            return;
        L29:
            return;
        L16:
            if (r101.intValue() == 2) goto L25;
            return;
        L25:
            this.f81724a.dismiss();     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r104 = DialogFragmentLancet.sLastShowStack;
            if (r104 == null) goto L32;
            com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f81725a = null;

        static {
            f81725a = new c();
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
        public final /* synthetic */ PkGuestApplyDialog f81726a;

        public d(PkGuestApplyDialog r100) {
            this.f81726a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            PkGuestApplyDialog r101 = this.f81726a;
            int r102 = PkGuestApplyDialog.f81707t;
            Dialog r103 = r101.getDialog();
            Context r104 = r101.getContext();
            if (r103 == null) goto L17;
            if (r104 == null) goto L21;
            Dialog r105 = r101.getDialog();
            if (r105 == null) goto L18;
            View r106 = r105.getCurrentFocus();
            if (r106 == null) goto L22;
            InputMethodManager r107 = (InputMethodManager) r104.getSystemService("input_method");
            if (r107 != null) goto L14;
            return;
        L14:
            if (r107.isActive() == false) goto L20;
            r107.hideSoftInputFromWindow(r106.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L18:
            return;
        L21:
            return;
        }
    }

    public static final class e<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkGuestApplyDialog f81727a;

        public e(PkGuestApplyDialog r100) {
            this.f81727a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 == null) goto L10;
            int r102 = r101.intValue();
            if (r102 == this.f81727a.f81722r) goto L9;
            if (r102 == 41) goto L9;
            com.bytedance.android.livesdk.sharedpref.e<Integer> r103 = com.bytedance.android.livesdk.sharedpref.c.f158319x1;
            r103.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r103, 40);
        L9:
            com.bytedance.android.livesdk.sharedpref.e<Integer> r104 = com.bytedance.android.livesdk.sharedpref.c.f158319x1;
            r104.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r104, 41);
        L10:
            if (r101 != null) goto L13;
            com.bytedance.android.livesdk.sharedpref.e<Integer> r105 = com.bytedance.android.livesdk.sharedpref.c.f158319x1;
            r105.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r105, 40);
            return;
        }
    }

    public static final class f<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkGuestApplyDialog f81728a;

        public f(PkGuestApplyDialog r100) {
            this.f81728a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            PkGuestApplyDialog r101 = this.f81728a;
            r101.T90((Text) r100);
        }
    }

    public static final class g<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkGuestApplyDialog f81729a;

        public g(PkGuestApplyDialog r100) {
            this.f81729a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            WaitingListUser r111 = (WaitingListUser) r110;
            if (r111 == null) goto L59;
            PkGuestApplyDialog r100 = this.f81729a;
            int r101 = PkGuestApplyDialog.f81707t;
            r100.getClass();
            IBaseUser r102 = r111.getUserFlex();
            String r103 = null;
            if (r102 == null) goto L7;
            py.k r104 = r102.getAvatarThumbKt();
        L8:
            boolean r105 = false;
            PipelineDraweeControllerBuilder r106 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r104, -1)).setAutoPlayAnimations(false);
            HSImageView r107 = r100.f81715k;
            if (r107 == null) goto L11;
            DraweeController r108 = r107.getController();
        L12:
            AbstractDraweeController r109 = r106.setOldController(r108).build();
            HSImageView r112 = r100.f81715k;
            if (r112 == null) goto L15;
            r112.setController(r109);
        L15:
            TextView r113 = r100.f81716l;
            if (r113 == null) goto L20;
            if (r102 == null) goto L19;
            r103 = r102.getNickName();
        L19:
            r113.setText(r103);
        L20:
            String r114 = "-";
            if (hd0.c.f().j() == false) goto L52;
            long r115 = r111.getOffset();
            TextView r116 = r100.f81714j;
            if (r116 != null) goto L25;
        L32:
            TextView r117 = r100.f81717m;
            if (r117 == null) goto L35;
            r117.setVisibility(0);
        L35:
            Integer r118 = com.bytedance.android.livesdk.sharedpref.c.f158319x1.getValue();
            if (r118 != null) goto L39;
        L51:
            tc0.c.h().P = r111;
            return;
        L39:
            if (r118.intValue() != 41) goto L51;
            TextView r119 = r100.f81717m;
            if (r119 == null) goto L51;
            String r120 = r111.getFanTicket();
            if (r120 != null) goto L45;
        L46:
            r105 = true;
        L47:
            if (r105 == false) goto L49;
            String r121 = "0";
        L50:
            r119.setText(r121);
            goto L51
        L49:
            r121 = r111.getFanTicket();
            goto L50
        L45:
            if (StringsKt.isBlank(r120) == false) goto L47;
        L25:
            if (r115 < 100) goto L28;
            r114 = "99+";
        L31:
            r116.setText(r114);
            goto L32
        L28:
            if (r115 == 0) goto L31;
            r114 = String.valueOf(r115);
            goto L31
        L52:
            TextView r122 = r100.f81714j;
            if (r122 == null) goto L55;
            r122.setText("-");
        L55:
            TextView r123 = r100.f81717m;
            if (r123 == null) goto L61;
            r123.setVisibility(8);
            return;
        L61:
            return;
        L11:
            r108 = null;
            goto L12
        L7:
            r104 = null;
            goto L8
        }
    }

    public static final class h<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkGuestApplyDialog f81730a;

        public h(PkGuestApplyDialog r100) {
            this.f81730a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            List<?> r101 = (List) r100;
            if (r101 != null) goto L5;
            FrameLayout r102 = this.f81730a.f81713i;
            if (r102 == null) goto L28;
            r102.setVisibility(0);
        L28:
            RecyclerView r103 = this.f81730a.f81712h;
            if (r103 == null) goto L34;
            r103.setVisibility(4);
            return;
        L34:
            return;
        L5:
            if (r101.isEmpty() == false) goto L9;
            FrameLayout r104 = this.f81730a.f81713i;
            if (r104 == null) goto L15;
            r104.setVisibility(0);
        L15:
            PkGuestApplyDialog r105 = this.f81730a;
            r105.f81710f.f513437a = r101;
            RecyclerView r106 = r105.f81712h;
            if (r106 != null) goto L18;
        L24:
            new Handler(Looper.getMainLooper()).post(new o(this, r101));
            return;
        L18:
            if (r106.isComputingLayout() == true) goto L24;
            RecyclerView r107 = this.f81730a.f81712h;
            if (r107 == null) goto L24;
            if (r107.getScrollState() != 0) goto L24;
            this.f81730a.f81710f.notifyDataSetChanged();
            return;
        L9:
            FrameLayout r108 = this.f81730a.f81713i;
            if (r108 == null) goto L12;
            r108.setVisibility(8);
        L12:
            RecyclerView r109 = this.f81730a.f81712h;
            if (r109 == null) goto L15;
            r109.setVisibility(0);
            goto L15
        }
    }

    public static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkGuestApplyDialog f81731a;

        public i(PkGuestApplyDialog r100) {
            this.f81731a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PkGuestApplyDialog r101 = this.f81731a;
            int r102 = PkGuestApplyDialog.f81707t;
            PkGuestApplyViewModel r103 = r101.S90();
            if (r103 == null) goto L22;
            LiveData<WaitingListUser> r104 = r103.getUserWaitingData();
            if (r104 == null) goto L23;
            WaitingListUser r105 = r104.getValue();
            if (r105 == null) goto L24;
            IBaseUser r106 = r105.getUserFlex();
            if (r106 == null) goto L25;
            PkGuestApplyViewModel r107 = this.f81731a.S90();
            if (r107 == null) goto L20;
            LiveData<WaitingListUser> r108 = r107.getUserWaitingData();
            if (r108 == null) goto L20;
            WaitingListUser r109 = r108.getValue();
            if (r109 == null) goto L20;
            if (r109.isAnonymous() != true) goto L20;
            ALogger.i("PkGuestApplyDialog", "click on the anonymous user avatar for apply , do not pull up the profile card");
            f2.c(s1.B(R.string.ttlive_live_current_user_not_support_open_profile_tips), 0);
            return;
        L20:
            xs2.b.a().post(new UserProfileEvent(r106));
            return;
        L25:
            return;
        L24:
            return;
        L23:
            return;
        }
    }

    static {
    }

    public final PkGuestApplyViewModel S90() {
        return (PkGuestApplyViewModel) this.f81709e.getValue();
    }

    public PkGuestApplyDialog() {
        this.f81709e = InfraKotlinExtsKt.mainThreadLazy(PkGuestApplyDialog$vm$2.INSTANCE);
        this.f81710f = new MultiTypeAdapter();
        this.f81721q = WaitingListType.UNKNOWN.ordinal();
        this.f81722r = 71;
        this.f81723s = new b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        hd0.c.f().e(this.f81723s);
    }

    public final void T90(Text r100) {
        if (r100 == null) goto L4;
        TextView r101 = this.f81711g;
        if (r101 == null) goto L15;
        r101.setText(sb2.a.h(r100, "", false));
        return;
    L15:
        return;
    L4:
        if (hd0.c.f().g() == false) goto L12;
        TextView r102 = this.f81711g;
        if (r102 == null) goto L13;
        r102.setText(s1.B(R.string.ttlive_interact_apply_canceled));
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L12;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L12;
        View r103 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L11:
        r103.setPadding(0, 0, 0, 0);
        r102.setLayout(-1, -1);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setGravity(80);
        r102.setSoftInputMode(48);
    L12:
        setBottomSheetSlideProcessor(c.f81725a);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_live_interact_dialog);
        int r101 = el0.j.f473003b;
        String r102 = this.f81720p;
        LinkedHashMap r103 = new LinkedHashMap();
        el0.j.m(r103);
        el0.j.k(r103);
        el0.j.i(r103);
        if (r102 == null) goto L5;
        r103.put("request_page", r102);
    L5:
        el0.j.n(r103, Integer.valueOf(dl0.n.a()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_guest_connection_apply_page_show", r103, new Object[]{Room.class});
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
        this.f81719o = false;     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        PkGuestApplyViewModel r101 = S90();     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.release();     // Catch: Throwable -> L7
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        WidgetManager.of(this, r100).load(R.id.fl_banner_lynx_container, new BannerWidget(this.f81708d));
        this.f81721q = WaitingListType.UNKNOWN.ordinal();
        this.f81711g = (TextView) r100.findViewById(R.id.tv_title);
        this.f81712h = (RecyclerView) r100.findViewById(R.id.waiting_list_rlv);
        this.f81713i = (FrameLayout) r100.findViewById(R.id.waiting_list_empty_tips);
        this.f81714j = (TextView) r100.findViewById(R.id.tv_current_position);
        this.f81715k = (HSImageView) r100.findViewById(R.id.iv_avatar);
        this.f81716l = (TextView) r100.findViewById(R.id.tv_user_name);
        this.f81717m = (TextView) r100.findViewById(R.id.tv_user_info);
        this.f81718n = (TextView) r100.findViewById(R.id.tv_cancel_or_apply);
        if (com.bytedance.live.datacontext.d.d(PkGuestApplyViewModel.TAG) != null) goto L5;
        return;
    L5:
        Integer r101 = (Integer) hd0.c.f().f481009b;
        if (r101 != null) goto L9;
    L10:
        hd0.c.f().c(this.f81723s);
    L11:
        this.f81710f.z2(WaitingListUser.class, new com.bytedance.android.live.livepkaudience.list.q(new AnonymousClass1(this)));
        this.f81710f.z2(com.bytedance.android.live.livepkaudience.list.l.a.class, new com.bytedance.android.live.livepkaudience.list.l(null, null));
        this.f81710f.z2(com.bytedance.android.live.livepkaudience.list.a.class, new com.bytedance.android.live.livepkaudience.list.r());
        RecyclerView r102 = this.f81712h;
        if (r102 == null) goto L14;
        r102.setAdapter(this.f81710f);
        r102.setLayoutManager(new LinearLayoutManager(r102.getContext()));
        r102.addOnScrollListener(new PkGuestApplyDialog$onViewCreated$$inlined$apply$lambda$1(this));
    L14:
        PkGuestApplyViewModel r103 = S90();
        if (r103 == null) goto L19;
        LiveData<Integer> r104 = r103.getSortTypeLiveData();
        if (r104 == null) goto L19;
        r104.observe(this, new e(this));
    L19:
        PkGuestApplyViewModel r105 = S90();
        if (r105 == null) goto L24;
        LiveData<Text> r106 = r105.getWaitingTitleData();
        if (r106 == null) goto L24;
        r106.observe(this, new f(this));
    L24:
        PkGuestApplyViewModel r107 = S90();
        if (r107 == null) goto L29;
        LiveData<WaitingListUser> r108 = r107.getUserWaitingData();
        if (r108 == null) goto L29;
        r108.observe(this, new g(this));
    L29:
        PkGuestApplyViewModel r109 = S90();
        if (r109 == null) goto L34;
        MutableLiveData<Integer> r111 = r109.getWaitingListType();
        if (r111 == null) goto L34;
        r111.observe(this, new n(this));
    L34:
        PkGuestApplyViewModel r112 = S90();
        if (r112 == null) goto L39;
        LiveData<List<Object>> r113 = r112.getWaitingListData();
        if (r113 == null) goto L39;
        r113.observe(this, new h(this));
    L39:
        PkGuestApplyViewModel r114 = S90();
        if (r114 == null) goto L42;
        PkGuestApplyViewModel.fetchList$default(r114, true, this.f81708d, null, this.f81721q, 0, 20, null);
    L42:
        TextView r115 = this.f81718n;
        if (r115 == null) goto L45;
        r115.setOnClickListener(x0.a(new AnonymousClass7(this)));
    L45:
        HSImageView r116 = this.f81715k;
        if (r116 == null) goto L49;
        r116.setOnClickListener(new i(this));
        return;
    L49:
        return;
    L9:
        if (r101.intValue() == 2) goto L11;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_pk_guest_apply, r101);
    }
}
