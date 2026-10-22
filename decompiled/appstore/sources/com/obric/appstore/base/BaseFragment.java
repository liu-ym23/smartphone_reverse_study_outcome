package com.obric.appstore.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.R;
import com.obric.appstore.util.s;
import com.obric.oui.button.OButton;
import com.obric.oui.status.OPageStatus;
import java.util.Collection;
import java.util.Locale;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.q;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\"\u0010 J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u001dH\u0016¢\u0006\u0004\b$\u0010 R\u001a\u0010)\u001a\u00020%8UX\u0094\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b'\u0010(R(\u0010/\u001a\u0004\u0018\u00010\r2\b\u0010*\u001a\u0004\u0018\u00010\r8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001a\u00103\u001a\u00020\u00138\u0014X\u0094D¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u001cR\u001c\u00107\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003048$X¤\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/obric/appstore/base/BaseFragment;", "Lcom/obric/appstore/base/e;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", "Lcom/obric/appstore/util/s;", "P", "(Landroid/view/View;)Lcom/obric/appstore/util/s;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "hidden", "onHiddenChanged", "(Z)V", "onPause", "onDestroyView", "N", "M", "L", "()Z", "Lcom/obric/oui/status/OPageStatus;", "empty", "Q", "(Lcom/obric/oui/status/OPageStatus;)V", "retry", "S", "loading", "R", "", "h", "I", "()I", "stateLayoutId", "<set-?>", "i", "Lcom/obric/appstore/util/s;", "J", "()Lcom/obric/appstore/util/s;", "statusCtl", "j", "Z", "H", "showLoadingWhenEmpty", "Lcom/obric/appstore/base/ILoadViewModel;", "K", "()Lcom/obric/appstore/base/ILoadViewModel;", "vm", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseFragment extends e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s f10538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f10539j;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f10540a;

        public a(Function1 r10) {
            q.g(r10, "function");
            this.f10540a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f10540a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f10540a.invoke(r10);
        }
    }

    public BaseFragment() {
        this.f10537h = R.layout.common_state_view;
        this.f10539j = true;
    }

    public static /* synthetic */ void F(BaseFragment r10, View r11) {
        T(r10, r11);
    }

    public static /* synthetic */ void G(BaseFragment r10, Locale r11) {
        O(r10, r11);
    }

    public static final void O(BaseFragment r10, Locale r11) {
        q.g(r10, "this$0");
        q.g(r11, "locale");
        com.bytedanceos.common.toolbox.j.n("BaseFragment localeChangeAware " + r11 + TokenParser.SP + r10.getClass().getName());
        ILoadViewModel.s(r10.K(), true, false, 2, null);
    }

    public static final void T(BaseFragment r10, View r11) {
        q.g(r10, "this$0");
        ILoadViewModel.s(r10.K(), false, true, 1, null);
    }

    @Override // com.obric.appstore.base.e
    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        if (I() == 0) goto L6;
        this.f10538i = P(r10);
        return;
    }

    public boolean H() {
        return this.f10539j;
    }

    public int I() {
        return this.f10537h;
    }

    public final s J() {
        return this.f10538i;
    }

    public abstract ILoadViewModel K();

    public boolean L() {
        Object r10 = K().k().e();
        if (r10 != null) goto L7;
        return true;
    L7:
        if ((r10 instanceof Collection) == true) goto L9;
        return false;
    L9:
        return ((Collection) r10).isEmpty();
    }

    public void M() {
    }

    public void N() {
        K().m().i(getViewLifecycleOwner(), new a(new BaseFragment$observeState$1(this)));
    }

    public s P(View r10) {
        q.g(r10, ServerElements.CONTENT);
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L5;
        ViewGroup r12 = (ViewGroup) r11;
    L6:
        sa.c r13 = sa.c.c(LayoutInflater.from(requireActivity()), r12, false);
        q.f(r13, "inflate(...)");
        if (r12 == null) goto L9;
        r12.addView(r13.b());
    L9:
        s r14 = new s(this, r13, r10);
        r14.p();
        return r14;
    L5:
        r12 = null;
        goto L6
    }

    public void Q(OPageStatus r10) {
        q.g(r10, "empty");
        FragmentActivity r11 = getActivity();
        if (r11 != null) goto L5;
        return;
    L5:
        r10.setMessage(r11.getString(R.string.load_empty));
    }

    public void R(OPageStatus r10) {
        q.g(r10, "loading");
        FragmentActivity r11 = getActivity();
        if (r11 != null) goto L5;
        return;
    L5:
        r10.d(true);
        r10.setMessage(r11.getString(R.string.obric_loading));
    }

    public void S(OPageStatus r10) {
        q.g(r10, "retry");
        FragmentActivity r11 = getActivity();
        if (r11 != null) goto L5;
        return;
    L5:
        r10.setType(0);
        r10.setTitle(r11.getString(R.string.load_error_title));
        r10.setMessage(r11.getString(R.string.load_error));
        r10.c(true);
        OButton r12 = r10.getButton();
        r12.setText(r11.getString(R.string.load_retry));
        r12.setOnClickListener(new h(this));
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        M();
        LocaleChangeAwareKt.a(this, new g(this));
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        s r10 = this.f10538i;
        if (r10 == null) goto L5;
        r10.n();
    L5:
        s r11 = this.f10538i;
        if (r11 == null) goto L8;
        r11.j();
    L8:
        super.onDestroyView();
        this.f10538i = null;
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r10) {
        super.onHiddenChanged(r10);
        if (r10 == false) goto L8;
        s r11 = this.f10538i;
        if (r11 == null) goto L9;
        r11.n();
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        s r10 = this.f10538i;
        if (r10 == null) goto L6;
        r10.n();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        N();
        s r12 = this.f10538i;
        if (r12 == null) goto L6;
        r12.h(r10);
        return;
    }
}
