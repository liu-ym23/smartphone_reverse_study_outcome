package x3;

import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class i implements d {

    /* renamed from: a, reason: collision with root package name */
    public final String f6879a;
    public final Pattern b;
    public final String c;

    public i(String str, String str2, String str3) {
        this.f6879a = str;
        this.c = str3;
        this.b = Pattern.compile(str2);
    }

    @Override // x3.d
    public final String a() {
        return this.c;
    }

    @Override // x3.d
    public final String getName() {
        return this.f6879a;
    }

    @Override // x3.d
    public final boolean matches(String str) {
        return this.b.matcher(str).matches();
    }
}
