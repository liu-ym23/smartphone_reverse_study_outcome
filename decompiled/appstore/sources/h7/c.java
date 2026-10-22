package h7;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedanceos.appstore.buss.AppStoreActivity;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.appstore.buss.utilities.n;
import com.bytedanceos.appstore.buss.utilities.t;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.R;
import com.obric.oui.titlebar.OCTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.q;
import x7.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H$¢\u0006\u0004\b\u0015\u0010\u0003J\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0004¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0006H$¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H$¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010%\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020!H\u0004¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u0004\u0018\u00010\u0006H\u0004¢\u0006\u0004\b'\u0010(J1\u0010,\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010)\u001a\u00020!2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010!2\b\b\u0003\u0010+\u001a\u00020\u001fH\u0004¢\u0006\u0004\b,\u0010-J\u0011\u0010.\u001a\u0004\u0018\u00010\u0006H\u0004¢\u0006\u0004\b.\u0010(J1\u00104\u001a\u0004\u0018\u0001032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010!2\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u000200H\u0004¢\u0006\u0004\b4\u00105R\u001a\u0010:\u001a\u0002008\u0014X\u0094D¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0016\u0010<\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00107R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR$\u0010J\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u000bR\u0014\u0010O\u001a\u00020\u001f8eX¤\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u001c\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010P8$X¤\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bU\u0010V¨\u0006X"}, d2 = {"Lh7/c;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "s", "()Landroid/view/View;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "E", "k", "initData", "F", "t", "onDestroyView", "Lcom/bytedanceos/appstore/buss/network/h$a;", "error", "D", "(Lcom/bytedanceos/appstore/buss/network/h$a;)Lkotlin/Unit;", "", "errorIcon", "", "retryTitle", "retrySubTitle", "retryBtnText", "C", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlin/Unit;", "B", "()Lkotlin/Unit;", "emptyText", "emptyDescText", "emptyIcon", "z", "(Ljava/lang/String;Ljava/lang/String;I)Lkotlin/Unit;", "r", "title", "", "showHomeAsUp", "showLeftCancel", "Lcom/obric/oui/titlebar/OCTitleBar;", "v", "(Ljava/lang/String;ZZ)Lcom/obric/oui/titlebar/OCTitleBar;", "a", "Z", "q", "()Z", "showHeader", "b", "isFirstShow", "Lcom/bytedanceos/appstore/buss/utilities/n;", "c", "Lcom/bytedanceos/appstore/buss/utilities/n;", "statusUtil", "d", "Landroid/view/View;", "contentView", "e", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "pageTitle", "m", "bindingContentView", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lcom/bytedanceos/appstore/buss/base/BaseActivity;", "l", "()Lcom/bytedanceos/appstore/buss/base/BaseActivity;", "baseActivity", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class c extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f20373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f20374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f20375e;

    public c() {
        this.f20371a = true;
        this.f20372b = true;
        this.f20375e = "";
    }

    public static /* synthetic */ Unit A(c r10, String r11, String r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L15;
        if ((r14 & 1) == 0) goto L7;
        r11 = BaseApplication.c().getString(R.string.tv_state_empty_default_text);
        q.f(r11, "getString(...)");
    L7:
        if ((r14 & 2) == 0) goto L10;
        r12 = null;
    L10:
        if ((r14 & 4) == 0) goto L13;
        r13 = R.drawable.buy_empty;
    L13:
        return r10.z(r11, r12, r13);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showEmptyView");
    }

    public static /* synthetic */ void i(c r10, View r11) {
        x(r10, r11);
    }

    public static /* synthetic */ void j(c r10, View r11) {
        y(r10, r11);
    }

    public static /* synthetic */ OCTitleBar w(c r10, String r11, boolean r12, boolean r13, int r14, Object r15) {
        if (r15 != null) goto L15;
        if ((r14 & 1) == 0) goto L7;
        r11 = "";
    L7:
        if ((r14 & 2) == 0) goto L10;
        r12 = false;
    L10:
        if ((r14 & 4) == 0) goto L13;
        r13 = false;
    L13:
        return r10.v(r11, r12, r13);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setToolBar");
    }

    public static final void x(c r10, View r11) {
        q.g(r10, "this$0");
        Context r12 = r10.getContext();
        if ((r12 instanceof AppStoreActivity) == true) goto L5;
        return;
    L5:
        r10.getParentFragmentManager().f1();
        AppStoreActivity r13 = (AppStoreActivity) r12;
        FragmentManager r14 = r10.getFragmentManager();
        if (r14 == null) goto L8;
        Fragment r15 = r14.h0(R.id.ll_container);
    L9:
        r13.R(r15);
        return;
    L8:
        r15 = null;
        goto L9
    }

    public static final void y(c r10, View r11) {
        q.g(r10, "this$0");
        Context r12 = r10.getContext();
        if ((r12 instanceof AppStoreActivity) == true) goto L5;
        return;
    L5:
        ((AppStoreActivity) r12).K();
    }

    public final Unit B() {
        n r10 = this.f20373c;
        if (r10 == null) goto L5;
        r10.f();
        return Unit.f21064a;
    L5:
        return null;
    }

    public final Unit C(int r10, String r11, String r12, String r13) {
        q.g(r11, "retryTitle");
        q.g(r12, "retrySubTitle");
        q.g(r13, "retryBtnText");
        n r14 = this.f20373c;
        if (r14 == null) goto L5;
        r14.g(r10, r11, r12, r13);
        return Unit.f21064a;
    L5:
        return null;
    }

    public final Unit D(h.a r10) {
        q.g(r10, "error");
        n r11 = this.f20373c;
        if (r11 == null) goto L5;
        n.h(r11, 0, null, r10.toString(), null, 11, null);
        return Unit.f21064a;
    L5:
        return null;
    }

    public abstract void E();

    public abstract void F();

    public abstract void initData();

    public final void k(Bundle r10) {
    }

    public final BaseActivity l() {
        FragmentActivity r10 = requireActivity();
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.base.BaseActivity");
        return (BaseActivity) r10;
    }

    public final View m() {
        View r10 = this.f20374d;
        if (r10 != null) goto L6;
        View r11 = requireView();
        q.f(r11, "requireView(...)");
        return r11;
    L6:
        return r10;
    }

    public abstract int n();

    public abstract Function0 o();

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        q.g(r10, "inflater");
        View r13 = r10.inflate(R.layout.fragment_base_view, r11, false);
        q.e(r13, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r14 = (ViewGroup) r13;
        j r15 = j.a(r14);
        q.f(r15, "bind(...)");
        View r16 = View.inflate(r14.getContext(), n(), null);
        q.e(r16, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r17 = (ViewGroup) r16;
        this.f20374d = r17;
        if (q() == false) goto L5;
        r15.f25616c.addView(s());
    L5:
        FrameLayout r18 = r15.f25615b;
        q.f(r18, "flBaseContent");
        r18.addView(r17);
        n r19 = new n(r18);
        this.f20373c = r19;
        r19.c(o());
        B();
        E();
        if (this.f20372b == true) goto L8;
        F();
    L8:
        k(r12);
        return r14;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f20374d = null;
        this.f20373c = null;
        ImageUtilKt.a();
        this.f20372b = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        initData();
        t();
    }

    public final String p() {
        return this.f20375e;
    }

    public boolean q() {
        return this.f20371a;
    }

    public final Unit r() {
        n r10 = this.f20373c;
        if (r10 == null) goto L5;
        r10.b();
        return Unit.f21064a;
    L5:
        return null;
    }

    public View s() {
        View r10 = LayoutInflater.from(getContext()).inflate(R.layout.tv_common_toolbar, null, false);
        q.f(r10, "inflate(...)");
        return r10;
    }

    public abstract void t();

    public final void u(String r10) {
        this.f20375e = r10;
    }

    public final OCTitleBar v(String r10, boolean r11, boolean r12) {
        View r13 = getView();
        if (r13 == null) goto L5;
        OCTitleBar r14 = (OCTitleBar) r13.findViewById(R.id.toolbar);
    L6:
        if (r14 == null) goto L15;
        r14.setTitleText(r10);
        if (r11 == false) goto L10;
        t.f8878a.a(r14, new a(this));
    L10:
        if (r12 == false) goto L12;
        t.f8878a.c(r14, new b(this));
    L12:
        Context r15 = getContext();
        if ((r15 instanceof AppStoreActivity) == false) goto L15;
        ((AppStoreActivity) r15).N();
    L15:
        return r14;
    L5:
        r14 = null;
        goto L6
    }

    public final Unit z(String r10, String r11, int r12) {
        q.g(r10, "emptyText");
        n r13 = this.f20373c;
        if (r13 == null) goto L5;
        r13.d(r10, r11, r12);
        return Unit.f21064a;
    L5:
        return null;
    }
}
