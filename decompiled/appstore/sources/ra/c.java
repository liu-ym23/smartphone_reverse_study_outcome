package ra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.f;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.widget.oui.ViewExtKt;
import com.obric.appstore.R;
import com.obric.appstore.base.LocaleChangeAwareKt;
import com.obric.appstore.base.e;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.appstore.util.n;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00108\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014¨\u0006\u001e"}, d2 = {"Lra/c;", "Lcom/obric/appstore/base/e;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "h", "I", "w", "()I", "layoutId", "", "i", "Ljava/util/List;", "titles", "H", "currTab", "j", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class c extends e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f23816j = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f23817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f23818i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements OTabLayoutBase.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f23819a;

        public b(ViewPager2 r10) {
            this.f23819a = r10;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabReselected(OTabLayoutBase.h r10) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabSelected(OTabLayoutBase.h r10) {
            if (r10 == null) goto L5;
            int r11 = r10.d();
            this.f23819a.j(r11, true);
            return;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabUnselected(OTabLayoutBase.h r10) {
        }
    }

    /* JADX INFO: renamed from: ra.c$c, reason: collision with other inner class name */
    public static final class C0350c extends ViewPager2.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OTabLayout f23820a;

        public C0350c(OTabLayout r10) {
            this.f23820a = r10;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.h
        public void onPageSelected(int r10) {
            this.f23820a.X(r10);
        }
    }

    static {
        f23816j = new a(null);
    }

    public c() {
        this.f23817h = R.layout.obric_fragment_appmanager_container;
        f r10 = f.f9823a;
        this.f23818i = t.l(new Integer[]{Integer.valueOf(r10.c()), Integer.valueOf(r10.a()), Integer.valueOf(r10.b())});
    }

    public static /* synthetic */ void F(Locale r10) {
        I(r10);
    }

    public static /* synthetic */ void G(c r10, View r11) {
        J(r10, r11);
    }

    public static final void I(Locale r10) {
        q.g(r10, "it");
        BaseApplication.c().b().A0();
    }

    public static final void J(c r10, View r11) {
        q.g(r10, "this$0");
        n.f11086a.n(r10.getActivity());
    }

    @Override // com.obric.appstore.base.e
    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        OTabLayout r11 = (OTabLayout) ViewExtKt.findView(r10, R.id.app_manager_tab_layout);
        ViewPager2 r12 = (ViewPager2) ViewExtKt.findView(r10, R.id.view_pager);
        r12.setUserInputEnabled(false);
        r11.addOnTabSelectedListener(new b(r12));
        r12.g(new C0350c(r11));
        r12.setAdapter(new d(this, this.f23818i));
        Intent r13 = r();
        if (r13 == null) goto L5;
        int r14 = r13.getIntExtra("__extra_tab_title", f.f9823a.c());
    L6:
        int r15 = this.f23818i.indexOf(Integer.valueOf(r14));
        if (r15 == (-1)) goto L10;
        r12.j(r15, true);
        return;
    L10:
        return;
    L5:
        r14 = f.f9823a.c();
        goto L6
    }

    public final int H() {
        View r10 = getView();
        if (r10 == null) goto L8;
        OTabLayout r11 = (OTabLayout) ViewExtKt.findView(r10, R.id.app_manager_tab_layout);
        Integer r12 = (Integer) b0.a0(this.f23818i, r11.getSelectedTabPosition());
        if (r12 == null) goto L8;
        return r12.intValue();
    L8:
        return f.f9823a.c();
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        AppsManager r11 = AppsManager.f10585a;
        FragmentActivity r12 = requireActivity();
        q.f(r12, "requireActivity(...)");
        r11.k(r12);
        LocaleChangeAwareKt.a(this, new ra.b());
        BaseApplication.c().b().A0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        OFloatingTitleBar r12 = y();
        if (r12 == null) goto L6;
        r12.setCenterTitle(getString(R.string.myapp));
        r12.h(R.drawable.oui_app_store_manager_icon, -1, new ra.a(this));
        return;
    }

    @Override // com.obric.appstore.base.e
    public int w() {
        return this.f23817h;
    }
}
