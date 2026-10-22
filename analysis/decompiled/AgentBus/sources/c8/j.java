package c8;

import java.util.Set;

/* loaded from: classes.dex */
public enum j {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");


    /* renamed from: f, reason: collision with root package name */
    public final e9.f f2016f;

    /* renamed from: g, reason: collision with root package name */
    public final e9.f f2017g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f2018h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f2019i;

    /* renamed from: j, reason: collision with root package name */
    public static final Set f2006j = d7.n.x0(new j[]{CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE});

    j(String str) {
        this.f2016f = e9.f.e(str);
        this.f2017g = e9.f.e(str.concat("Array"));
        c7.h hVar = c7.h.f1970f;
        this.f2018h = s7.a.G(hVar, new i(this, 1));
        this.f2019i = s7.a.G(hVar, new i(this, 0));
    }
}
