package com.obric.appstore.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.apache.http.message.TokenParser;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0003J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u00020\u0006*\u00020\u0017¢\u0006\u0004\b'\u0010\u001aJ\u0011\u0010(\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u00020\u0006*\u00020\u0017¢\u0006\u0004\b*\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001a\u00102\u001a\u00020\u001f8\u0016X\u0096D¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010&R(\u00109\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001038\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u0010?\u001a\u00020:8UX\u0094\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010B\u001a\u00020\u001f8\u0014X\u0094D¢\u0006\f\n\u0004\b@\u00100\u001a\u0004\bA\u0010&R(\u0010G\u001a\u0004\u0018\u00010\u00172\b\u00104\u001a\u0004\u0018\u00010\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR$\u0010M\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010\u001dR\u0016\u0010Q\u001a\u0004\u0018\u00010N8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010S\u001a\u00020:8eX¤\u0004¢\u0006\u0006\u001a\u0004\bR\u0010>¨\u0006T"}, d2 = {"Lcom/obric/appstore/base/e;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "pageSource", "", "q", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/widget/FrameLayout;", "C", "(Landroid/widget/FrameLayout;)V", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "toolBar", "D", "(Lcom/obric/oui/titlebar/OFloatingTitleBar;)V", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", "onResume", "", "hidden", "onHiddenChanged", "(Z)V", "onDestroyView", "onDestroy", "z", "()Z", "m", FixCard.FixStyle.KEY_X, "()Landroid/os/Bundle;", "o", "a", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "b", "Z", "t", "enableEventBus", "Lsa/a;", "<set-?>", "c", "Lsa/a;", "s", "()Lsa/a;", "binding", "", "d", "I", "v", "()I", "headerLayoutId", "e", "u", "fullContent", "f", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", FixCard.FixStyle.KEY_Y, "()Lcom/obric/oui/titlebar/OFloatingTitleBar;", "toolbar", "g", "Landroid/view/View;", "getSearchBtn", "()Landroid/view/View;", "setSearchBtn", "searchBtn", "Landroid/content/Intent;", "r", "()Landroid/content/Intent;", "activityIntent", "w", "layoutId", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAbsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsFragment.kt\ncom/obric/appstore/base/AbsFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,183:1\n329#2,4:184\n*S KotlinDebug\n*F\n+ 1 AbsFragment.kt\ncom/obric/appstore/base/AbsFragment\n*L\n94#1:184,4\n*E\n"})
public abstract class e extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public sa.a f10566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OFloatingTitleBar f10569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f10570g;

    public e() {
        String r10 = getClass().getSimpleName();
        q.f(r10, "getSimpleName(...)");
        this.f10564a = r10;
        this.f10567d = R.layout.common_toolbar_o;
    }

    public static final void A(e r10, Locale r11) {
        q.g(r10, "this$0");
        q.g(r11, "locale");
        com.bytedanceos.common.toolbox.j.n("AbsFragment localeChangeAware " + r11 + TokenParser.SP + r10.getClass().getName());
    }

    public static final void E(e r10, View r11) {
        q.g(r10, "this$0");
        FragmentActivity r12 = r10.getActivity();
        if (r12 != null) goto L6;
        return;
    L6:
        if (r10.getParentFragmentManager().q0() <= 0) goto L8;
        r10.getParentFragmentManager().f1();
        return;
    L8:
        r12.finish();
    }

    public static /* synthetic */ void i(e r10, Locale r11) {
        A(r10, r11);
    }

    public static /* synthetic */ void j(e r10, View r11) {
        E(r10, r11);
    }

    public static /* synthetic */ void k(e r10, View r11) {
        p(r10, r11);
    }

    public static /* synthetic */ void l(e r10, View r11) {
        n(r10, r11);
    }

    public static final void n(e r10, View r11) {
        q.g(r10, "this$0");
        com.obric.appstore.util.n.m(com.obric.appstore.util.n.f11086a, r10.getActivity(), null, 0, r10.x(), 6, null);
    }

    public static final void p(e r10, View r11) {
        q.g(r10, "this$0");
        com.obric.appstore.util.n.f11086a.n(r10.getActivity());
    }

    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
    }

    public void C(FrameLayout r10) {
        q.g(r10, "container");
    }

    public void D(OFloatingTitleBar r10) {
        q.g(r10, "toolBar");
    }

    public String getPageSource() {
        return this.f10564a;
    }

    public final void m(OFloatingTitleBar r10) {
        q.g(r10, "<this>");
        this.f10570g = r10.h(R.drawable.oui_title_bar_search, -1, new b(this));
    }

    public final void o(OFloatingTitleBar r10) {
        q.g(r10, "<this>");
        r10.h(R.drawable.oui_icon_setting, -1, new c(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        setHasOptionsMenu(false);
        if (t() == false) goto L5;
        EventBus.getDefault().register(this);
    L5:
        LocaleChangeAwareKt.a(this, new d(this));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        q.g(r10, "inflater");
        sa.a r13 = sa.a.c(r10, r11, false);
        this.f10566c = r13;
        r13.b().setClickable(true);
        if (v() == 0) goto L10;
        r13.f24561c.addView(r10.inflate(v(), r13.f24561c, false));
        OFloatingTitleBar r14 = (OFloatingTitleBar) r13.f24561c.findViewById(R.id.toolbar);
        if (r14 == null) goto L7;
        q.d(r14);
        r14.k(R.drawable.oui_title_bar_back, -1, new a(this));
        D(r14);
    L8:
        this.f10569f = r14;
        goto L10
    L7:
        r14 = null;
    L10:
        if (w() == 0) goto L13;
        View r15 = r10.inflate(w(), r13.f24560b, false);
        r13.f24560b.addView(r15);
        q.d(r15);
        B(r15);
    L13:
        if (u() == false) goto L19;
        FrameLayout r16 = r13.f24560b;
        q.f(r16, "flBaseContent");
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L18;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
        r18.f2205j = -1;
        r18.f2203i = 0;
        r16.setLayoutParams(r18);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L19:
        FrameLayout r19 = r13.f24562d;
        q.f(r19, "flBaseNotify");
        C(r19);
        return r13.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (t() == false) goto L6;
        EventBus.getDefault().unregister(this);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10569f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r10) {
        super.onHiddenChanged(r10);
        if (r10 == true) goto L6;
        q(getPageSource());
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isHidden() == true) goto L6;
        q(getPageSource());
        return;
    }

    public final void q(String r10) {
        com.bytedanceos.common.toolbox.j.e("BaseFragment pageSource " + r10);
    }

    public final Intent r() {
        FragmentActivity r10 = getActivity();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getIntent();
    }

    public final sa.a s() {
        return this.f10566c;
    }

    public boolean t() {
        return this.f10565b;
    }

    public boolean u() {
        return this.f10568e;
    }

    public int v() {
        return this.f10567d;
    }

    public abstract int w();

    public Bundle x() {
        return null;
    }

    public final OFloatingTitleBar y() {
        return this.f10569f;
    }

    public boolean z() {
        return false;
    }
}
