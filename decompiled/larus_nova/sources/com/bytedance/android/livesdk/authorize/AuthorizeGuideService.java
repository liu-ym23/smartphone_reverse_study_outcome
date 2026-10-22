package com.bytedance.android.livesdk.authorize;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.bytedance.android.live.BaseDialogFragmentV2;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.MaybeSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.user.VcdAuthorizationSource;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.SingleSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class AuthorizeGuideService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static VcdAuthorizationSource f104092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SingleSubject<Boolean> f104093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AuthorizeGuideDialog f104094c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/authorize/AuthorizeGuideService$AuthorizeGuideDialog;", "Lcom/bytedance/android/live/BaseDialogFragmentV2;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AuthorizeGuideDialog extends BaseDialogFragmentV2 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<Integer, View> f104095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AuthorizeGuideViewModel f104096e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.bytedance.android.livesdk.authorize.k f104097f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.bytedance.android.livesdk.authorize.g f104098g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public r f104099h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f104100i;

        public static final class a {
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideDialog f104101a;

            public b(AuthorizeGuideDialog r100) {
                this.f104101a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                AuthorizeGuideViewModel.g r101 = (AuthorizeGuideViewModel.g) r100;
                if (r101 == null) goto L7;
                String r102 = r101.f104141a;
                if (r102 == null) goto L7;
                ((TextView) this.f104101a.S90(R.id.authorize_title)).setText(r102);
            L7:
                if (r101 == null) goto L12;
                String r103 = r101.f104142b;
                if (r103 == null) goto L13;
                ((TextView) this.f104101a.S90(R.id.authorize_content)).setText(r103);
                return;
            L13:
                return;
            }
        }

        public static final class c<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideDialog f104102a;

            public c(AuthorizeGuideDialog r100) {
                this.f104102a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Integer r101 = (Integer) r100;
                View r102 = this.f104102a.getView();
                if (r102 == null) goto L34;
                TransitionManager.beginDelayedTransition((ViewGroup) r102, new AutoTransition().setDuration(200));
                LinearLayout r103 = (LinearLayout) this.f104102a.S90(R.id.retry_container);
                int r104 = 8;
                if (r101 != null) goto L8;
            L10:
                int r105 = 8;
            L11:
                r103.setVisibility(r105);
                LinearLayout r106 = (LinearLayout) this.f104102a.S90(R.id.normal_container);
                if (r101 != null) goto L15;
            L16:
                int r107 = 0;
            L18:
                r106.setVisibility(r107);
                ProgressBar r108 = (ProgressBar) this.f104102a.S90(R.id.progress_bar);
                if (r101 != null) goto L22;
            L24:
                int r109 = 8;
            L25:
                r108.setVisibility(r109);
                LinearLayout r110 = (LinearLayout) this.f104102a.S90(R.id.item_container);
                if (r101 != null) goto L29;
            L31:
                r110.setVisibility(r104);
                return;
            L29:
                if (r101.intValue() != 3) goto L31;
                r104 = 0;
                goto L31
            L22:
                if (r101.intValue() != 1) goto L24;
                r109 = 0;
                goto L25
            L15:
                if (r101.intValue() != 2) goto L16;
                r107 = 8;
                goto L18
            L8:
                if (r101.intValue() != 2) goto L10;
                r105 = 0;
                goto L11
            L34:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }

        public static final class d<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideViewModel f104103a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideDialog f104104b;

            public d(AuthorizeGuideViewModel r100, AuthorizeGuideDialog r101) {
                this.f104103a = r100;
                this.f104104b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                gc1.a r101 = (gc1.a) r100;
                if (r101.c() == false) goto L18;
                AuthorizeGuideDialog r102 = this.f104104b;
                com.bytedance.android.livesdk.authorize.k r103 = r102.f104097f;
                if (r103 != null) goto L16;
                r103 = new com.bytedance.android.livesdk.authorize.k(this.f104103a, r102);
                ((LinearLayout) this.f104104b.S90(R.id.item_container)).addView(r103.c(this.f104104b.getLayoutInflater(), (ViewGroup) this.f104104b.S90(R.id.item_container)));
                this.f104104b.f104097f = r103;
                String r104 = r101.d();
                if (r104 == null) goto L11;
                TextView r105 = r103.f104206b;
                if (r105 == null) goto L11;
                r105.setText(r104);
            L11:
                String r106 = r101.a();
                if (r106 == null) goto L16;
                TextView r107 = r103.f104207c;
                if (r107 == null) goto L16;
                r107.setText(r106);
            L16:
                r103.h(r101.e());
                return;
            }
        }

        public static final class e<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideViewModel f104105a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideDialog f104106b;

            public e(AuthorizeGuideViewModel r100, AuthorizeGuideDialog r101) {
                this.f104105a = r100;
                this.f104106b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                gc1.b r101 = (gc1.b) r100;
                if (r101.c() == false) goto L18;
                AuthorizeGuideDialog r102 = this.f104106b;
                com.bytedance.android.livesdk.authorize.g r103 = r102.f104098g;
                if (r103 != null) goto L16;
                r103 = new com.bytedance.android.livesdk.authorize.g(this.f104105a, r102);
                ((LinearLayout) this.f104106b.S90(R.id.item_container)).addView(r103.c(this.f104106b.getLayoutInflater(), (ViewGroup) this.f104106b.S90(R.id.item_container)));
                this.f104106b.f104098g = r103;
                String r104 = r101.d();
                if (r104 == null) goto L11;
                TextView r105 = r103.f104206b;
                if (r105 == null) goto L11;
                r105.setText(r104);
            L11:
                String r106 = r101.a();
                if (r106 == null) goto L16;
                TextView r107 = r103.f104207c;
                if (r107 == null) goto L16;
                r107.setText(r106);
            L16:
                r103.h(r101.e());
                return;
            }
        }

        public static final class f<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideViewModel f104107a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideDialog f104108b;

            public f(AuthorizeGuideViewModel r100, AuthorizeGuideDialog r101) {
                this.f104107a = r100;
                this.f104108b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                gc1.c r101 = (gc1.c) r100;
                if (r101.c() == false) goto L18;
                AuthorizeGuideDialog r102 = this.f104108b;
                r r103 = r102.f104099h;
                if (r103 != null) goto L16;
                r103 = new r(this.f104107a, r102);
                ((LinearLayout) this.f104108b.S90(R.id.item_container)).addView(r103.c(this.f104108b.getLayoutInflater(), (ViewGroup) this.f104108b.S90(R.id.item_container)));
                this.f104108b.f104099h = r103;
                String r104 = r101.d();
                if (r104 == null) goto L11;
                TextView r105 = r103.f104206b;
                if (r105 == null) goto L11;
                r105.setText(r104);
            L11:
                String r106 = r101.a();
                if (r106 == null) goto L16;
                TextView r107 = r103.f104207c;
                if (r107 == null) goto L16;
                r107.setText(r106);
            L16:
                r103.h(r101.e());
                return;
            }
        }

        public static final class g<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideDialog f104109a;

            public g(AuthorizeGuideDialog r100) {
                this.f104109a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Boolean r101 = (Boolean) r100;
                ((TextView) this.f104109a.S90(R.id.apply_button)).setActivated(r101.booleanValue());
                AuthorizeGuideDialog r102 = this.f104109a;
                r102.f104100i = r101.booleanValue();
            }
        }

        public static final class h<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideDialog f104110a;

            public h(AuthorizeGuideDialog r100) {
                this.f104110a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                String r101 = ((AuthorizeGuideViewModel.h) r100).f104143a;
                if (r101 == null) goto L13;
                f2.c(r101, 0);
            L13:
                this.f104110a.dismissAllowingStateLoss();     // Catch: Exception -> L8
                return;
            L8:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
                Throwable r102 = DialogFragmentLancet.sLastShowStack;
                if (r102 == null) goto L15;
                com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            }
        }

        public static final class i implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideDialog f104111a;

            public i(AuthorizeGuideDialog r100) {
                this.f104111a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f104111a.dismissAllowingStateLoss();     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
                Throwable r101 = DialogFragmentLancet.sLastShowStack;
                if (r101 == null) goto L12;
                com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            }
        }

        public static final class j implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideDialog f104112a;

            public j(AuthorizeGuideDialog r100) {
                this.f104112a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                AuthorizeGuideViewModel r101 = this.f104112a.f104096e;
                if (r101 == null) goto L6;
                r101.refreshStateIfNeeded();
                return;
            }
        }

        public static final class k implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AuthorizeGuideDialog f104113a;

            public k(AuthorizeGuideDialog r100) {
                this.f104113a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                String r101 = null;
                if (r100.isActivated() == false) goto L26;
                VcdAuthorizationSource r102 = AuthorizeGuideService.f104092a;
                SingleSubject<Boolean> r103 = AuthorizeGuideService.f104093b;
                if (r103 == null) goto L7;
                r103.onSuccess(Boolean.valueOf(this.f104113a.f104100i));
            L7:
                AuthorizeGuideViewModel r104 = this.f104113a.f104096e;
                if (r104 == null) goto L14;
                com.bytedance.android.livesdk.log.g r105 = com.bytedance.android.livesdk.log.u.l();
                Pair[] r106 = new Pair[3];
                r106[0] = TuplesKt.to("user_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
                r106[1] = TuplesKt.to("scene_type", r104.f104133o);
                if (Intrinsics.areEqual(r104.f104124f.getValue(), Boolean.TRUE) == false) goto L12;
                String r107 = BdpAppEventConstant.YES;
            L13:
                r106[2] = TuplesKt.to("is_relation", r107);
                r105.sendLog("authorize_button_submit_success", MapsKt.mapOf(r106), new Object[0]);
                goto L14
            L12:
                r107 = BdpAppEventConstant.NO;
            L14:
                AuthorizeGuideViewModel r108 = this.f104113a.f104096e;
                if (r108 == null) goto L46;
                Boolean r109 = r108.f104126h.getValue();
                Boolean r110 = Boolean.TRUE;
                if ((true ^ Intrinsics.areEqual(r109, r110)) == false) goto L20;
            L24:
                if (r101 == null) goto L47;
                f2.c(r101, 0);
                return;
            L47:
                return;
            L20:
                if (Intrinsics.areEqual(r108.f104124f.getValue(), r110) == false) goto L22;
                String r111 = s1.B(R.string.ttlive_authorize_all_succeed);
            L23:
                r101 = r111;
                goto L24
            L22:
                r111 = s1.B(R.string.ttlive_authorize_content_succeed);
                goto L23
            L46:
                return;
            L26:
                AuthorizeGuideViewModel r112 = this.f104113a.f104096e;
                if (r112 == null) goto L49;
                Boolean r113 = r112.f104126h.getValue();
                Boolean r114 = Boolean.TRUE;
                if (Intrinsics.areEqual(r113, r114) == true) goto L43;
                Boolean r115 = r112.f104122d.getValue();
                Boolean r116 = Boolean.FALSE;
                if (Intrinsics.areEqual(r115, r116) == false) goto L41;
                if (Intrinsics.areEqual(r112.f104132n, VcdAuthorizationSource.LINK_IN_ROOM.getSource()) == false) goto L41;
                if (Intrinsics.areEqual(r112.f104123e.getValue(), r114) == false) goto L38;
                String r117 = s1.B(R.string.ttlive_authorize_name_verify_required);
            L39:
                r101 = r117;
                goto L43
            L38:
                r117 = s1.B(R.string.ttlive_authorize_name_verify_and_content_required);
            L41:
                if (Intrinsics.areEqual(r112.f104123e.getValue(), r116) == false) goto L43;
                r101 = s1.B(R.string.ttlive_authorize_content_required);
            L43:
                if (r101 == null) goto L50;
                f2.c(r101, 0);
                return;
            L50:
                return;
            }
        }

        public static final class l<T> implements Predicate {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final l f104114a = null;

            static {
                f104114a = new l();
            }

            public l() {
            }

            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object r100) {
                Boolean r101 = (Boolean) r100;
                Intrinsics.checkNotNullParameter(r101, "it");
                return r101.booleanValue();
            }
        }

        public static final class m<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final m f104115a = null;

            static {
                f104115a = new m();
            }

            public m() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Boolean r101 = (Boolean) r100;
                SingleSubject<Boolean> r102 = AuthorizeGuideService.f104093b;
                if (r102 == null) goto L6;
                r102.onSuccess(r101);
                return;
            }
        }

        public static final class n<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final n f104116a = null;

            static {
                f104116a = new n();
            }

            public n() {
            }

            @Override // io.reactivex.functions.Consumer
            public final /* bridge */ /* synthetic */ void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
            }
        }

        static {
        }

        public AuthorizeGuideDialog() {
            this.f104095d = new LinkedHashMap();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public final void onDestroyView() {
            super.onDestroyView();
            ((LinkedHashMap) this.f104095d).clear();
        }

        public final View S90(int r100) {
            if (this.f104095d != null) goto L5;
            this.f104095d = new LinkedHashMap();
        L5:
            View r101 = this.f104095d.get(Integer.valueOf(r100));
            if (r101 != null) goto L14;
            View r102 = getView();
            if (r102 == null) goto L12;
            View r103 = r102.findViewById(r100);
            if (r103 == null) goto L12;
            this.f104095d.put(Integer.valueOf(r100), r103);
            return r103;
        L12:
            return null;
        L14:
            return r101;
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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
        L7:
            Bundle r104 = getArguments();
            if (r104 == null) goto L11;
            String r105 = r104.getString("source");
            if (r105 == null) goto L11;
        L12:
            S90(R.id.outside_area).setOnClickListener(new i(this));
            ((TextView) S90(R.id.retry_text)).setOnClickListener(new j(this));
            ((TextView) S90(R.id.apply_button)).setOnClickListener(new k(this));
            FragmentActivity r106 = getActivity();
            Intrinsics.checkNotNull(r106);
            AuthorizeGuideViewModel r107 = new AuthorizeGuideViewModel(r105, r105, this, r106);
            AuthorizeGuideViewModel.e r108 = AuthorizeGuideViewModel.f104118s;
            ((ObservableSubscribeProxy) AuthorizeGuideViewModel.e.a(r108, r107.f104128j).as(AutoDispose.bind(this))).subscribe(new b(this));
            ((ObservableSubscribeProxy) AuthorizeGuideViewModel.e.a(r108, r107.f104125g).as(AutoDispose.bind(this))).subscribe(new c(this));
            ((ObservableSubscribeProxy) AuthorizeGuideViewModel.e.a(r108, r107.f104119a).as(AutoDispose.bind(this))).subscribe(new d(r107, this));
            ((ObservableSubscribeProxy) AuthorizeGuideViewModel.e.a(r108, r107.f104120b).as(AutoDispose.bind(this))).subscribe(new e(r107, this));
            ((ObservableSubscribeProxy) AuthorizeGuideViewModel.e.a(r108, r107.f104121c).as(AutoDispose.bind(this))).subscribe(new f(r107, this));
            ((ObservableSubscribeProxy) AuthorizeGuideViewModel.e.a(r108, r107.f104126h).as(AutoDispose.bind(this))).subscribe(new g(this));
            ((MaybeSubscribeProxy) AuthorizeGuideViewModel.e.a(r108, r107.f104126h).firstOrError().filter(l.f104114a).as(AutoDispose.bind(this))).subscribe(m.f104115a, n.f104116a);
            ((ObservableSubscribeProxy) AuthorizeGuideViewModel.e.a(r108, r107.f104127i).as(AutoDispose.bind(this))).subscribe(new h(this));
            Unit r109 = Unit.INSTANCE;
            this.f104096e = r107;
            return;
        L11:
            r105 = "";
            goto L12
        }

        @Override // androidx.fragment.app.DialogFragment
        public final Dialog onCreateDialog(Bundle r100) {
            Dialog r101 = super.onCreateDialog(r100);
            r101.requestWindowFeature(1);
            Window r102 = r101.getWindow();
            if (r102 == null) goto L5;
            WindowManager.LayoutParams r103 = r102.getAttributes();
            r103.windowAnimations = R.style.ttlive_webview_dialog_bottom_popup_anim_vertical;
            r102.setAttributes(r103);
        L5:
            return r101;
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L11
            super.onDismiss(r100);     // Catch: Throwable -> L11
            SingleSubject<Boolean> r101 = AuthorizeGuideService.f104093b;     // Catch: Throwable -> L11
            if (r101 != null) goto L5;
        L9:
            LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
            PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
            LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
            return;
        L5:
            if (r101.hasValue() == true) goto L9;
            SingleSubject<Boolean> r102 = AuthorizeGuideService.f104093b;     // Catch: Throwable -> L11
            if (r102 == null) goto L9;
            r102.onSuccess(Boolean.FALSE);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
            PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
            LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
            throw th;
        }

        @Override // androidx.fragment.app.Fragment
        public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r100, "inflater");
            return r100.inflate(R.layout.ttlive_dialog_authorize_guide, r101, false);
        }
    }

    public AuthorizeGuideService() {
    }

    public static final void a() {
        AuthorizeGuideDialog r100 = f104094c;
        if (r100 != null) goto L12;
    L10:
        f104094c = null;
        f104093b = null;
        f104092a = null;
        return;
    L12:
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L10;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    static {
    }

    public static SingleSubject b(VcdAuthorizationSource r100) {
        f104092a = r100;
        AuthorizeGuideDialog r101 = new AuthorizeGuideDialog();
        Bundle r102 = new Bundle();
        r102.putString("source", r100.getSource());
        Unit r103 = Unit.INSTANCE;
        r101.setArguments(r102);
        f104094c = r101;
        SingleSubject<Boolean> r104 = SingleSubject.create();
        f104093b = r104;
        return r104;
    }

    public static Single c(SingleSubject r100, FragmentActivity r101) {
        AuthorizeGuideDialog r102 = f104094c;
        if (r102 == null) goto L10;
        FragmentManager r103 = r101.getSupportFragmentManager();
        String r104 = AuthorizeGuideDialog.class.getName();
        LandscapeRestrictionOperation r105 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, r104, r105);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r103, r102, r105) == true) goto L10;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L8:
        r102.showNow(r103, r104);
    L10:
        return r100.doOnDispose(c.f104202a).doOnSuccess(d.f104203a).doOnError(e.f104204a).observeOn(AndroidSchedulers.mainThread());
    }
}
