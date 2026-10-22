package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.ap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FragmentController.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e<?> f1800a;

    public static d a(e<?> r3) {
        return new d((e) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r3, "callbacks == null"), e.class, "com.obric.aiagent.plugin"));
    }

    private d(e<?> r1) {
        this.f1800a = r1;
    }

    public FragmentManager a() {
        return this.f1800a.f1802b;
    }

    public void a(Fragment r2) {
        FragmentManager r0 = this.f1800a.f1802b;
        e<?> r1 = this.f1800a;
        r0.a(r1, r1, r2);
    }

    public View a(View r3, String r4, Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        return this.f1800a.f1802b.H().onCreateView(r3, r4, r7, r8);
    }

    public void b() {
        this.f1800a.f1802b.p();
    }

    public Parcelable c() {
        return this.f1800a.f1802b.k();
    }

    public void a(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(this.f1800a, ap.class) == false) goto L7;
        this.f1800a.f1802b.a(r4);
        return;
    L7:
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public void d() {
        this.f1800a.f1802b.r();
    }

    public void e() {
        this.f1800a.f1802b.t();
    }

    public void f() {
        this.f1800a.f1802b.u();
    }

    public void g() {
        this.f1800a.f1802b.v();
    }

    public void h() {
        this.f1800a.f1802b.w();
    }

    public void i() {
        this.f1800a.f1802b.x();
    }

    public void j() {
        this.f1800a.f1802b.z();
    }

    public void a(boolean r1) {
        this.f1800a.f1802b.b(r1);
    }

    public void b(boolean r1) {
        this.f1800a.f1802b.c(r1);
    }

    public void a(Configuration r1) {
        this.f1800a.f1802b.a(r1);
    }

    public void k() {
        this.f1800a.f1802b.A();
    }

    public boolean a(Menu r3, MenuInflater r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.aiagent.plugin");
        return this.f1800a.f1802b.a(r5, r4);
    }

    public boolean a(Menu r3) {
        Menu r4 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.aiagent.plugin");
        return this.f1800a.f1802b.a(r4);
    }

    public boolean a(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.aiagent.plugin");
        return this.f1800a.f1802b.a(r4);
    }

    public boolean b(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.aiagent.plugin");
        return this.f1800a.f1802b.b(r4);
    }

    public void b(Menu r3) {
        Menu r4 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.aiagent.plugin");
        this.f1800a.f1802b.b(r4);
    }

    public boolean l() {
        return this.f1800a.f1802b.a(true);
    }
}
