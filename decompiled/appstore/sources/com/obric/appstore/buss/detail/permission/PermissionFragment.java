package com.obric.appstore.buss.detail.permission;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.base.k;
import com.obric.appstore.buss.detail.o;
import com.obric.appstore.common.core.ui.view.AppItemViewStyle;
import com.obric.appstore.common.core.ui.view.AppStatusBtnStyle;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.appstore.util.n;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.io.Serializable;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import sa.s;
import u8.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/obric/appstore/buss/detail/permission/PermissionFragment;", "Lcom/obric/appstore/base/BaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "toolBar", "D", "(Lcom/obric/oui/titlebar/OFloatingTitleBar;)V", "Lcom/obric/appstore/buss/detail/permission/PermissionVM;", "k", "Lkotlin/Lazy;", "V", "()Lcom/obric/appstore/buss/detail/permission/PermissionVM;", "permissionVM", "Lcom/bytedanceos/common/model/AppInfo;", "l", "Lcom/bytedanceos/common/model/AppInfo;", "appInfo", "Lcom/obric/appstore/base/k;", "W", "()Lcom/obric/appstore/base/k;", "vm", "", "w", "()I", "layoutId", "m", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPermissionFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionFragment.kt\ncom/obric/appstore/buss/detail/permission/PermissionFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,95:1\n106#2,15:96\n*S KotlinDebug\n*F\n+ 1 PermissionFragment.kt\ncom/obric/appstore/buss/detail/permission/PermissionFragment\n*L\n32#1:96,15\n*E\n"})
public final class PermissionFragment extends BaseFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f10690m = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f10691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AppInfo f10692l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f10693a;

        public b(Function1 r10) {
            q.g(r10, "function");
            this.f10693a = r10;
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
            return this.f10693a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f10693a.invoke(r10);
        }
    }

    static {
        f10690m = new a(null);
    }

    public PermissionFragment() {
        final Function0<Fragment> r10 = new PermissionFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new PermissionFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10691k = FragmentViewModelLazyKt.c(this, u.b(PermissionVM.class), new PermissionFragment$special$$inlined$viewModels$default$3(r11), new PermissionFragment$special$$inlined$viewModels$default$4(r12, r11), new PermissionFragment$special$$inlined$viewModels$default$5(this, r11));
    }

    public static /* synthetic */ void U(AppInfo r10, PermissionFragment r11, View r12) {
        X(r10, r11, r12);
    }

    public static final void X(AppInfo r10, PermissionFragment r11, View r12) {
        q.g(r10, "$appInfo");
        q.g(r11, "this$0");
        String r13 = r10.appDeveloperId;
        q.f(r13, "appDeveloperId");
        if (r13.length() <= 0) goto L6;
        n r14 = n.f11086a;
        FragmentActivity r15 = r11.getActivity();
        String r16 = r10.appDeveloperId;
        q.f(r16, "appDeveloperId");
        String r17 = r10.appDeveloper;
        q.f(r17, "appDeveloper");
        r14.g(r15, r16, r17);
        return;
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e
    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        final s r11 = s.a(r10);
        final AppInfo r12 = this.f10692l;
        if (r12 == null) goto L7;
        r11.f24674b.getAppStatusView().v(AppStatusBtnStyle.DETAIL);
        r11.f24674b.showLine(false);
        r11.f24674b.p(AppItemViewStyle.APP_INFO);
        ObricAppItemView r13 = r11.f24674b;
        q.f(r13, "appinfoItem");
        o.d(r13);
        r11.f24674b.setBriefOnClickListener(new com.obric.appstore.buss.detail.permission.b(r12, this));
        ItemAppProvider.a r14 = ItemAppProvider.f11017k;
        FragmentActivity r15 = requireActivity();
        q.f(r15, "requireActivity(...)");
        ObricAppItemView r16 = r11.f24674b;
        q.f(r16, "appinfoItem");
        r14.d(r15, r16, r12, getPageSource());
        V().k().i(getViewLifecycleOwner(), new b(new PermissionFragment$onCreateContentView$1$2(r11, this)));
        ScrollView r17 = r11.f24677e;
        q.f(r17, "scrollview");
        c.c(r17, PermissionFragment$onCreateContentView$1$3.INSTANCE);
        return;
    }

    @Override // com.obric.appstore.base.e
    public void D(OFloatingTitleBar r10) {
        q.g(r10, "toolBar");
        super.D(r10);
        r10.setCenterTitle(getString(R.string.permission_detail));
        r10.setMaskBlurRadius(8.0f);
    }

    @Override // com.obric.appstore.base.BaseFragment
    public /* bridge */ /* synthetic */ ILoadViewModel K() {
        return W();
    }

    public final PermissionVM V() {
        return (PermissionVM) this.f10691k.getValue();
    }

    public k W() {
        return V();
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        Intent r11 = r();
        if (r11 == null) goto L5;
        Serializable r12 = r11.getSerializableExtra("__extra_app_info");
    L7:
        if ((r12 instanceof AppInfo) == false) goto L9;
        AppInfo r13 = (AppInfo) r12;
    L10:
        this.f10692l = r13;
        PermissionVM r14 = V();
        AppInfo r15 = this.f10692l;
        if (r15 == null) goto L13;
        String r16 = r15.appPackageName;
    L14:
        if (r16 != null) goto L17;
        r16 = "";
    L17:
        if (r16.length() != 0) goto L20;
        requireActivity().finish();
        return;
    L20:
        r14.w(r16);
        ILoadViewModel.s(V(), false, false, 3, null);
        return;
    L13:
        r16 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r12 = null;
        goto L7
    }

    @Override // com.obric.appstore.base.e
    public int w() {
        return R.layout.obric_framgent_app_perms;
    }
}
