package w1;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f6139a;

    /* renamed from: b, reason: collision with root package name */
    public final o f6140b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f6141c;
    public final CheckableImageButton d;

    public p(o oVar) {
        this.f6139a = oVar.f6118a;
        this.f6140b = oVar;
        this.f6141c = oVar.getContext();
        this.d = oVar.f6123g;
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public AccessibilityManager.TouchExplorationStateChangeListener h() {
        return null;
    }

    public boolean i(int i8) {
        return true;
    }

    public boolean j() {
        return this instanceof l;
    }

    public boolean k() {
        return false;
    }

    public final void p() {
        this.f6140b.f(false);
    }

    public void a() {
    }

    public void b() {
    }

    public void q() {
    }

    public void r() {
    }

    public void l(EditText editText) {
    }

    public void m(f0.g gVar) {
    }

    public void n(AccessibilityEvent accessibilityEvent) {
    }

    public void o(boolean z) {
    }
}
