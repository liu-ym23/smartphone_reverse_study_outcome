package l8;

import java.lang.reflect.Member;

/* loaded from: classes.dex */
public final /* synthetic */ class l extends q7.h implements p7.k {

    /* renamed from: n, reason: collision with root package name */
    public static final l f5875n = new l(1);

    @Override // q7.c
    public final String A() {
        return "isSynthetic()Z";
    }

    @Override // q7.c, w7.c
    public final String getName() {
        return "isSynthetic";
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        Member member = (Member) obj;
        q7.k.e(member, "p0");
        return Boolean.valueOf(member.isSynthetic());
    }

    @Override // q7.c
    public final w7.f y() {
        return q7.w.f8821a.b(Member.class);
    }
}
