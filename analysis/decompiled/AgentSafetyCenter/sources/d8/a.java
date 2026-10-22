package d8;

import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public Pattern f3290a;

    @Override // d8.c
    public final boolean matches(String str) {
        return this.f3290a.matcher(str).find();
    }
}
