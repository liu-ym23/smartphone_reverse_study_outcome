package n8;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

/* loaded from: classes4.dex */
public final class n extends p {

    /* renamed from: a, reason: collision with root package name */
    public final Field f5361a;

    public n(Field member) {
        kotlin.jvm.internal.k.f(member, "member");
        this.f5361a = member;
    }

    @Override // n8.p
    public final Member b() {
        return this.f5361a;
    }
}
