package k9;

import com.obric.oui.animation.engine.b;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f21035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.oui.animation.easy.a f21036b;

    public a(b r10, com.obric.oui.animation.easy.a r11) {
        q.g(r10, "animation");
        q.g(r11, "config");
        this.f21035a = r10;
        this.f21036b = r11;
    }

    public final void a() {
        this.f21036b.a(this.f21035a);
        this.f21035a.o();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (q.b(this.f21035a, r11.f21035a) == true) goto L12;
        return false;
    L12:
        if (q.b(this.f21036b, r11.f21036b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f21035a.hashCode() * 31) + this.f21036b.hashCode();
    }

    public String toString() {
        return "SpringAnimationHolder(animation=" + this.f21035a + ", config=" + this.f21036b + ')';
    }
}
