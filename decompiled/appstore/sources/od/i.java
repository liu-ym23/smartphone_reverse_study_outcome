package od;

import com.obric.oui.texteffects.core.EffectProperty;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EffectProperty f22584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f22585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f22586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f22587d;

    public i(EffectProperty r10, List r11, a r12, j r13) {
        q.g(r10, "property");
        q.g(r11, "keyframes");
        q.g(r12, "easing");
        q.g(r13, "selector");
        this.f22584a = r10;
        this.f22585b = r11;
        this.f22586c = r12;
        this.f22587d = r13;
    }

    public final a a() {
        return this.f22586c;
    }

    public final List b() {
        return this.f22585b;
    }

    public final EffectProperty c() {
        return this.f22584a;
    }

    public final j d() {
        return this.f22587d;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i) == true) goto L8;
        return false;
    L8:
        i r11 = (i) r10;
        if (this.f22584a == r11.f22584a) goto L12;
        return false;
    L12:
        if (q.b(this.f22585b, r11.f22585b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f22586c, r11.f22586c) == true) goto L18;
        return false;
    L18:
        if (q.b(this.f22587d, r11.f22587d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f22584a.hashCode() * 31) + this.f22585b.hashCode()) * 31) + this.f22586c.hashCode()) * 31) + this.f22587d.hashCode();
    }

    public String toString() {
        return "PropertyTrack(property=" + this.f22584a + ", keyframes=" + this.f22585b + ", easing=" + this.f22586c + ", selector=" + this.f22587d + ')';
    }

    public /* synthetic */ i(EffectProperty r10, List r11, a r12, j r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = a.c.f22556a;
    L6:
        if ((r14 & 8) == 0) goto L8;
        r13 = j.a.f22588a;
    L8:
        this(r10, r11, r12, r13);
    }
}
