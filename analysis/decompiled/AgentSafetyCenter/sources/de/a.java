package de;

import yd.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: c, reason: collision with root package name */
    public final String f3319c;

    /* renamed from: f, reason: collision with root package name */
    public final int f3320f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3321g;

    public a(int i, int i3, String str) {
        super(str);
        this.f3319c = "'reader'";
        this.f3320f = i3;
        this.f3321g = i;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        int i = this.f3320f;
        StringBuilder sbO = androidx.activity.b.o("unacceptable code point '", new String(Character.toChars(i)), "' (0x");
        sbO.append(Integer.toHexString(i).toUpperCase());
        sbO.append(") ");
        sbO.append(getMessage());
        sbO.append("\nin \"");
        sbO.append(this.f3319c);
        sbO.append("\", position ");
        sbO.append(this.f3321g);
        return sbO.toString();
    }
}
