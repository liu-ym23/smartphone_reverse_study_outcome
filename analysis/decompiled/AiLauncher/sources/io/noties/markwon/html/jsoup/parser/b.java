package io.noties.markwon.html.jsoup.parser;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f34246a;

    /* renamed from: b, reason: collision with root package name */
    public String f34247b;

    public b(int i10, String str) {
        this.f34246a = i10;
        this.f34247b = str;
    }

    public String toString() {
        return this.f34246a + ": " + this.f34247b;
    }

    public b(int i10, String str, Object... objArr) {
        this.f34247b = String.format(str, objArr);
        this.f34246a = i10;
    }
}
