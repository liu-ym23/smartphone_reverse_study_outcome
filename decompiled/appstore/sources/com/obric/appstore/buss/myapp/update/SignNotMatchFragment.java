package com.obric.appstore.buss.myapp.update;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseListFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.base.LocaleChangeAwareKt;
import com.obric.appstore.buss.apps.AppCallback;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.appstore.buss.detail.o;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.appstore.ui.menu.PopMenu;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0005R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001b8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010*\u001a\u00020%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R \u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000204038TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/obric/appstore/buss/myapp/update/SignNotMatchFragment;", "Lcom/obric/appstore/base/BaseListFragment;", "Lcom/obric/appstore/buss/myapp/update/e;", "Lcom/obric/appstore/buss/apps/AppCallback;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/obric/oui/status/OPageStatus;", "empty", "Q", "(Lcom/obric/oui/status/OPageStatus;)V", "onDestroy", "onAppUpdate", "Lcom/obric/appstore/buss/myapp/update/UpdateVM;", "o", "Lkotlin/Lazy;", "i0", "()Lcom/obric/appstore/buss/myapp/update/UpdateVM;", "updateVM", "Lcom/obric/appstore/buss/myapp/update/UpdateUIAdapter;", "p", "Lcom/obric/appstore/buss/myapp/update/UpdateUIAdapter;", "f0", "()Lcom/obric/appstore/buss/myapp/update/UpdateUIAdapter;", "adapter", "Lcom/obric/appstore/ui/menu/PopMenu;", "q", "Lcom/obric/appstore/ui/menu/PopMenu;", "popMenu", "Lcom/obric/appstore/buss/myapp/update/f;", "r", "Lcom/obric/appstore/buss/myapp/update/f;", "g0", "()Lcom/obric/appstore/buss/myapp/update/f;", "diffCallback", "Lbb/a;", "s", "Lbb/a;", "blockTouchAfterLongClick", "Lbb/c;", "t", "Lbb/c;", "downTrackingClick", "Lcom/obric/appstore/base/k;", "", "h0", "()Lcom/obric/appstore/base/k;", "listVM", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSignNotMatchFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SignNotMatchFragment.kt\ncom/obric/appstore/buss/myapp/update/SignNotMatchFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,127:1\n106#2,15:128\n*S KotlinDebug\n*F\n+ 1 SignNotMatchFragment.kt\ncom/obric/appstore/buss/myapp/update/SignNotMatchFragment\n*L\n28#1:128,15\n*E\n"})
public final class SignNotMatchFragment extends BaseListFragment<e> implements AppCallback {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f10736o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final UpdateUIAdapter f10737p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final PopMenu f10738q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f f10739r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final bb.a f10740s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final bb.c f10741t;

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.SignNotMatchFragment$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "position", "Landroid/view/View;", "view", "Lcom/obric/appstore/buss/myapp/update/e;", "appInfo", "", "invoke", "(ILandroid/view/View;Lcom/obric/appstore/buss/myapp/update/e;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass2 extends Lambda implements Function3<Integer, View, e, Unit> {
        final /* synthetic */ SignNotMatchFragment this$0;

        public AnonymousClass2(SignNotMatchFragment r10) {
            this.this$0 = r10;
            super(3);
        }

        public static /* synthetic */ boolean a(SignNotMatchFragment r10, View r11, e r12, View r13) {
            return invoke$lambda$1(r10, r11, r12, r13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final boolean invoke$lambda$1(final SignNotMatchFragment r10, View r11, final e r12, View r13) {
            q.g(r10, "this$0");
            q.g(r11, "$view");
            q.g(r12, "$appInfo");
            SignNotMatchFragment.b0(r10).a(r11);
            if ((r11 instanceof IOUIAlpha) == false) goto L5;
            IOUIAlpha r14 = (IOUIAlpha) r11;
        L7:
            if (r14 == null) goto L9;
            r14.setChangeAlphaWhenSelected(true);
        L9:
            r11.setSelected(false);
            int r15 = R.drawable.oui_icon_ignore_update;
            String r16 = r10.getString(R.string.app_manage_menu_ignore_update);
            q.f(r16, "getString(...)");
            List r17 = s.e(new com.obric.appstore.ui.menu.b(0, r15, r16));
            SignNotMatchFragment.d0(r10).e(r11, SignNotMatchFragment.c0(r10).a(), r17, new SignNotMatchFragment$onCreate$2$1$2(r10, r12));
            return true;
        L5:
            r14 = null;
            goto L7
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer r10, View r11, e r12) {
            invoke(r10.intValue(), r11, r12);
            return Unit.f21064a;
        }

        public final void invoke(int r10, @NotNull final View r11, @NotNull final e r12) {
            q.g(r11, "view");
            q.g(r12, "appInfo");
            r11.setOnTouchListener(new bb.b(t.l(new View.OnTouchListener[]{SignNotMatchFragment.c0(this.this$0), SignNotMatchFragment.b0(this.this$0)})));
            final SignNotMatchFragment r13 = this.this$0;
            r11.setOnLongClickListener(new d(r13, r11, r12));
        }
    }

    public SignNotMatchFragment() {
        final Function0<Fragment> r10 = new SignNotMatchFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new SignNotMatchFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10736o = FragmentViewModelLazyKt.c(this, u.b(UpdateVM.class), new SignNotMatchFragment$special$$inlined$viewModels$default$3(r11), new SignNotMatchFragment$special$$inlined$viewModels$default$4(r12, r11), new SignNotMatchFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f10737p = new UpdateUIAdapter();
        this.f10738q = new PopMenu();
        this.f10739r = new f();
        this.f10740s = new bb.a();
        this.f10741t = new bb.c();
    }

    public static /* synthetic */ void a0(Locale r10) {
        j0(r10);
    }

    public static final /* synthetic */ bb.a b0(SignNotMatchFragment r10) {
        return r10.f10740s;
    }

    public static final /* synthetic */ bb.c c0(SignNotMatchFragment r10) {
        return r10.f10741t;
    }

    public static final /* synthetic */ PopMenu d0(SignNotMatchFragment r10) {
        return r10.f10738q;
    }

    public static final /* synthetic */ UpdateVM e0(SignNotMatchFragment r10) {
        return r10.i0();
    }

    private final UpdateVM i0() {
        return (UpdateVM) this.f10736o.getValue();
    }

    private static final void j0(Locale r10) {
        q.g(r10, "it");
        BaseApplication.c().b().A0();
    }

    @Override // com.obric.appstore.base.BaseFragment
    public void Q(OPageStatus r10) {
        q.g(r10, "empty");
        if (getView() == null) goto L6;
        r10.setType(0);
        r10.setTitle(getString(R.string.obric_empty_apps));
        return;
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return f0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ DiffUtil.ItemCallback V() {
        return g0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ ILoadViewModel X() {
        return h0();
    }

    public UpdateUIAdapter f0() {
        return this.f10737p;
    }

    public f g0() {
        return this.f10739r;
    }

    public com.obric.appstore.base.k h0() {
        return i0();
    }

    @Override // com.obric.appstore.buss.apps.AppCallback
    public void onAppUpdate() {
        ILoadViewModel.s(i0(), false, false, 3, null);
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r13) {
        super.onCreate(r13);
        LocaleChangeAwareKt.a(this, new c());
        BaseApplication.c().b().A0();
        f0().addItemProvider(new ItemAppProvider(getPageSource(), false, false, new AnonymousClass2(this), null, false, false, 0.0f, 176, null));
        i0().D(UpdateVM.LoadType.SIGN_NOT_MATCH);
        AppsManager.f10585a.j(this);
        ILoadViewModel.s(i0(), false, false, 3, null);
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AppsManager.f10585a.l(this);
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        OFloatingTitleBar r12 = y();
        if (r12 == null) goto L5;
        r12.setCenterTitle(getString(R.string.confirm_for_update));
        r12.setMaskBlurRadius(8.0f);
        o(r12);
    L5:
        final RecyclerView r13 = Y();
        if (r13 == null) goto L9;
        ActivityUtilKt.b(r13, new SignNotMatchFragment$onViewCreated$2$1(r13));
        r13.setClipToPadding(false);
        r13.addItemDecoration(new bb.e(o.c(), o.b(), o.c(), false, 0, 0, 48, null));
        return;
    }
}
