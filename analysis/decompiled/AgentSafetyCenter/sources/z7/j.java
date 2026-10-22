package z7;

import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements d {

    /* renamed from: a, reason: collision with root package name */
    public String f16479a;

    /* renamed from: b, reason: collision with root package name */
    public Pattern f16480b;

    /* renamed from: c, reason: collision with root package name */
    public String f16481c;

    @Override // z7.d
    public final String a() {
        return this.f16481c;
    }

    @Override // z7.d
    public final String getName() {
        return this.f16479a;
    }

    @Override // z7.d
    public final boolean matches(String str) {
        return this.f16480b.matcher(str).matches();
    }
}
