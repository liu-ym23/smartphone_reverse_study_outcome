package com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewAddCouponLayout;
import com.bytedance.crash.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import eh2.e;
import eh2.f;
import eh2.g;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.lang.ref.WeakReference;
import si2.p;
import vi2.h;
import vi2.j;

/* JADX INFO: loaded from: classes10.dex */
public class ECBindCouponFragment extends ECBaseDialogFragment<ECBindCouponViewModel> {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f147654y = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f147655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public EditText f147656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f147657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f147658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f147659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ECNewAddCouponLayout f147660n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayout f147661o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f147662p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f147663q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f147664r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RelativeLayout f147665s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f147666t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f147667u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ViewGroup f147668v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public p f147669w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public WeakReference<dh2.a.InterfaceC5668a> f147670x;

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECBindCouponFragment f147671a;

        public a(ECBindCouponFragment r100) {
            this.f147671a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECBindCouponFragment f147672a;

        @Override // java.lang.Runnable
        public final void run() {
            ECBindCouponFragment.ia0(this.f147672a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ECBindCouponFragment r100) {
            this.f147672a = r100;
        }
    }

    public interface c {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int Y90() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void da0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void ea0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void fa0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int getLayoutId() {
        return R.layout.ec_fragment_bind_coupon;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, (int) (ECDisplayUtils.a(getContext()) * 0.73f));
        r100.gravity = 80;
        return r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        if (getContext() == null) goto L15;
        Context r100 = getContext();
        EditText r101 = this.f147656j;
        Handler r102 = k.f153092a;
        if (r100 == null) goto L9;
        InputMethodManager r103 = (InputMethodManager) r100.getSystemService("input_method");
        if (r103 == null) goto L9;
        boolean r104 = r103.isActive(r101);
    L10:
        if (r104 == false) goto L15;
        Context r105 = getContext();
        EditText r106 = this.f147656j;
        InputMethodManager r107 = (InputMethodManager) r105.getSystemService("input_method");
        if (r107 == null) goto L14;
        r107.hideSoftInputFromWindow(r106.getWindowToken(), 0);
        r106.clearFocus();
    L14:
        new Handler().postDelayed(new b(this), 200);
        return;
    L9:
        r104 = false;
    L15:
        ia0(this);
    }

    public ECBindCouponFragment() {
    }

    public static void ia0(ECBaseDialogFragment r100) {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void aa0(Bundle r100) {
        if (r100 == null) goto L5;
        this.f147663q = r100.getString("anchor_id");
        this.f147662p = r100.getString("room_id");
        this.f147666t = r100.getString("cipher_text");
        this.f147667u = r100.getString("bind_notice");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ECBottomDialog ca0(Bundle r100) {
        return super.ca0(r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        ((ECBindCouponViewModel) this.f147650g).init(this.f147662p);
        View r101 = getView();
        if (r101 != null) goto L6;
    L22:
        ((ECBindCouponViewModel) this.f147650g).start();
        return;
    L6:
        if (getContext() == null) goto L22;
        View r102 = getView();
        View r103 = null;
        if (r102 == null) goto L11;
        View r104 = r102.findViewById(R.id.rl_edit_region);
    L12:
        this.f147665s = (RelativeLayout) r104;
        View r105 = getView();
        if (r105 == null) goto L15;
        r103 = r105.findViewById(R.id.tv_delete_text);
    L15:
        this.f147664r = r103;
        this.f147655i = (ImageView) r101.findViewById(R.id.iv_back);
        EditText r106 = (EditText) r101.findViewById(R.id.et_input_coupon);
        this.f147656j = r106;
        String r107 = this.f147666t;
        if (r107 == null) goto L18;
        r106.setHint(r107);
    L18:
        this.f147657k = (TextView) r101.findViewById(R.id.tv_confirm);
        this.f147658l = (TextView) r101.findViewById(R.id.tv_prompt_msg_text);
        this.f147659m = (ViewGroup) r101.findViewById(R.id.tv_no_coupon_layout);
        ImageView r108 = (ImageView) r101.findViewById(R.id.ec_coupon_host);
        String r109 = this.f147667u;
        if (r109 == null) goto L21;
        this.f147658l.setText(r109);
    L21:
        this.f147661o = (LinearLayout) r101.findViewById(R.id.ll_coupon_layout);
        this.f147660n = (ECNewAddCouponLayout) r101.findViewById(R.id.hcdl_coupon_layout);
        this.f147657k.setTextColor(th.a.a(getContext(), R.color.ec_color_unable_text));
        this.f147657k.setEnabled(false);
        this.f147655i.setOnClickListener(this);
        this.f147657k.setOnClickListener(this);
        this.f147664r.setOnClickListener(this);
        this.f147664r.setVisibility(8);
        this.f147659m.setVisibility(8);
        this.f147657k.setTextSize(1, 16.0f);
        ViewGroup r110 = (ViewGroup) r101.findViewById(R.id.ec_edit_wrapper);
        this.f147668v = r110;
        r110.setVisibility(0);
        this.f147656j.addTextChangedListener(new e(this));
        this.f147656j.setOnTouchListener(new f(this));
        this.f147656j.postDelayed(new g(this), 300);
        goto L22
    L11:
        r104 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, android.view.View.OnClickListener
    public final void onClick(View r100) {
        super.onClick(r100);
        if (r100 != this.f147655i) goto L11;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L27;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L27:
        return;
    L11:
        if (r100 != this.f147657k) goto L22;
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L29;
        String r103 = this.f147656j.getEditableText().toString().replace(" ", "");
        if (TextUtils.isEmpty(r103) == false) goto L17;
        return;
    L17:
        final a r104 = new a(this);
        String r105 = h.f555073a;
        String r106 = h.d(si2.g.f542169s);
        h.e(null, null, r106, new j(r103, r106)).observeOn(AndroidSchedulers.mainThread()).subscribe(new eh2.a(this, r104), new eh2.b(this));
        this.f147668v.setVisibility(8);
        EditText r107 = this.f147656j;
        Handler r108 = k.f153092a;
        InputMethodManager r109 = (InputMethodManager) r102.getSystemService("input_method");
        if (r109 == null) goto L20;
        r109.hideSoftInputFromWindow(r107.getWindowToken(), 0);
        r107.clearFocus();
    L20:
        this.f147665s.requestFocus();
        return;
    L29:
        return;
    L22:
        if (r100 != this.f147664r) goto L31;
        this.f147656j.setText("");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        return super.ca0(r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
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
}
