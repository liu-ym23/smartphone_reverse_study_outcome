package com.bytedanceos.appstore.buss.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.network.core.ImageLoader;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.obric.appstore.R;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\u0005J\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0005J)\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0015\u0010\u0005J\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001d\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0006¢\u0006\u0004\b#\u0010\u0005J\r\u0010$\u001a\u00020\u0006¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\u0005R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010<\u001a\u00020\r8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001c\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010=8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010>¨\u0006B"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/UserInfoFragment;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "Ljava/util/Observer;", "<init>", "()V", "", "O", "N", "P", "E", "initData", "M", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "F", "t", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "Ljava/util/Observable;", "o", "", "update", "(Ljava/util/Observable;Ljava/lang/Object;)V", "", "message", "Q", "(Ljava/lang/String;)V", "L", "R", "onDestroyView", "Lcom/bytedanceos/common/toolbox/cache/AccountDataCache;", "f", "Lcom/bytedanceos/common/toolbox/cache/AccountDataCache;", "mAccountCache", "Lm8/a;", "g", "Lm8/a;", "mAccountRequestHelper", "Landroid/app/AlertDialog;", "h", "Landroid/app/AlertDialog;", "mNoNetWorkDialog", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "mHandler", "Lx7/a0;", "K", "()Lx7/a0;", "fragmentTvUserInfoBinding", "n", "()I", "layoutId", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "j", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UserInfoFragment extends h7.c implements View.OnClickListener, Observer {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f8687j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AccountDataCache f8688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m8.a f8689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AlertDialog f8690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f8691i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a() {
            return new UserInfoFragment();
        }

        public a() {
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserInfoFragment f8692a;

        public b(UserInfoFragment r10) {
            this.f8692a = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            kotlin.jvm.internal.q.g(r10, "msg");
            switch(r10.what) {
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L5;
                default: goto L16;
            };
        L5:
            this.f8692a.L();
            int r11 = BaseApplication.c().getResources().getDimensionPixelOffset(R.dimen.user_account_icon);
            com.bytedanceos.common.toolbox.e.R0(AccountDataCache.b().d(), r11, r11);
            Object r12 = r10.obj;
            kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlin.String");
            String r13 = (String) r12;
            ImageView r14 = UserInfoFragment.H(this.f8692a).f25490d;
            kotlin.jvm.internal.q.f(r14, "ivIcon");
            ImageUtilKt.e(r14, r13);
            AccountDataCache r15 = UserInfoFragment.I(this.f8692a);
            kotlin.jvm.internal.q.d(r15);
            r15.q(r13);
            m8.a r16 = UserInfoFragment.J(this.f8692a);
            if (r16 == null) goto L8;
            r16.j();
        L8:
            com.bytedanceos.common.toolbox.e0.e(R.string.modify_success);
            return;
        L9:
            this.f8692a.R();
            return;
        L10:
            this.f8692a.L();
            return;
        L11:
            UserInfoFragment r17 = this.f8692a;
            Object r18 = r10.obj;
            kotlin.jvm.internal.q.e(r18, "null cannot be cast to non-null type kotlin.Int");
            String r19 = r17.getString(((Integer) r18).intValue());
            kotlin.jvm.internal.q.f(r19, "getString(...)");
            r17.Q(r19);
            return;
        }
    }

    static {
        f8687j = new a(null);
    }

    public UserInfoFragment() {
        this.f8691i = new b(this);
    }

    public static /* synthetic */ void G(DialogInterface r10, int r11) {
        S(r10, r11);
    }

    public static final /* synthetic */ x7.a0 H(UserInfoFragment r10) {
        return r10.K();
    }

    public static final /* synthetic */ AccountDataCache I(UserInfoFragment r10) {
        return r10.f8688f;
    }

    public static final /* synthetic */ m8.a J(UserInfoFragment r10) {
        return r10.f8689g;
    }

    private final void N() {
        StrictMode.VmPolicy.Builder r10 = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(r10.build());
        r10.detectFileUriExposure();
    }

    private final void O() {
        this.f8688f = AccountDataCache.b();
        m8.a r10 = m8.a.i();
        this.f8689g = r10;
        if (r10 == null) goto L5;
        r10.addObserver(this);
    L5:
        ImageLoader.l(getResources().getDimensionPixelOffset(R.dimen.account_icon_width) / 2.0f);
        FrameLayout r11 = K().f25489c;
        AccountDataCache r12 = this.f8688f;
        String r13 = null;
        if (r12 == null) goto L8;
        String r14 = r12.j();
    L9:
        int r15 = 0;
        if (TextUtils.isEmpty(r14) == true) goto L12;
        int r16 = 8;
    L13:
        r11.setVisibility(r16);
        FrameLayout r17 = K().f25491e;
        AccountDataCache r18 = this.f8688f;
        if (r18 == null) goto L16;
        String r19 = r18.j();
    L18:
        if (TextUtils.isEmpty(r19) == true) goto L20;
        r15 = 8;
    L20:
        r17.setVisibility(r15);
        AccountDataCache r20 = this.f8688f;
        if (r20 == null) goto L23;
        String r21 = r20.l();
    L25:
        if (TextUtils.isEmpty(r21) == false) goto L27;
        K().f25492f.setText("");
    L28:
        AccountDataCache r22 = this.f8688f;
        if (r22 == null) goto L32;
        r13 = r22.d();
    L32:
        if (TextUtils.isEmpty(r13) == false) goto L34;
        ImageView r23 = K().f25490d;
        kotlin.jvm.internal.q.f(r23, "ivIcon");
        ImageUtilKt.e(r23, "");
    L35:
        M();
        return;
    L34:
        ImageView r24 = K().f25490d;
        kotlin.jvm.internal.q.f(r24, "ivIcon");
        ImageUtilKt.e(r24, r13);
        goto L35
    L27:
        K().f25492f.setText(r21);
        goto L28
    L23:
        r21 = null;
        goto L25
    L16:
        r19 = null;
        goto L18
    L12:
        r16 = 0;
        goto L13
    L8:
        r14 = null;
        goto L9
    }

    private final void P() {
    }

    public static final void S(DialogInterface r10, int r11) {
        r10.dismiss();
    }

    @Override // h7.c
    public void E() {
    }

    @Override // h7.c
    public void F() {
    }

    public final x7.a0 K() {
        x7.a0 r10 = x7.a0.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final void L() {
        com.bytedanceos.common.toolbox.j.a("hideLoadingDialog()");
    }

    public final void M() {
    }

    public final void Q(String r10) {
        kotlin.jvm.internal.q.g(r10, "message");
        com.bytedanceos.common.toolbox.j.a("showLoadingDialog() message=" + r10);
    }

    public final void R() {
        if (com.bytedanceos.common.toolbox.e.A0(getContext()) == true) goto L19;
        AlertDialog r10 = this.f8690h;
        if (r10 == null) goto L13;
        if (r10 == null) goto L8;
        Boolean r11 = Boolean.valueOf(r10.isShowing());
    L9:
        kotlin.jvm.internal.q.d(r11);
        if (r11.booleanValue() == false) goto L13;
        return;
    L8:
        r11 = null;
    L13:
        if (this.f8690h != null) goto L15;
        this.f8690h = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.AppStoreDialogTheme)).setMessage(R.string.no_network_retry).setTitle(R.string.no_network).setPositiveButton(R.string.done, new p1()).create();
    L15:
        AlertDialog r12 = this.f8690h;
        if (r12 == null) goto L20;
        r12.show();
        return;
    L20:
        return;
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, getString(R.string.personal_account_title), true, false, 4, null);
        K().f25489c.setOnClickListener(this);
        K().f25491e.setOnClickListener(this);
        K().f25488b.setOnClickListener(this);
        O();
        N();
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_user_info;
    }

    @Override // h7.c
    public Function0 o() {
        return UserInfoFragment$onRetryListener$1.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        m8.a r10 = this.f8689g;
        if (r10 == null) goto L6;
        r10.deleteObserver(this);
        return;
    }

    @Override // h7.c
    public void t() {
        r();
        P();
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
    }
}
