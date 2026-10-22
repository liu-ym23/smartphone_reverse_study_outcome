package x5;

import java.util.regex.Matcher;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class k extends kotlin.jvm.internal.n implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public static final k f6300a = new k(1, j.class, "next", "next()Lkotlin/text/MatchResult;", 0);

    @Override // p5.l
    public final Object invoke(Object obj) {
        j p02 = (j) obj;
        kotlin.jvm.internal.p.e(p02, "p0");
        CharSequence charSequence = p02.f6298b;
        Matcher matcher = p02.f6297a;
        int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        if (iEnd > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        kotlin.jvm.internal.p.d(matcher2, "matcher(...)");
        return x.e.a(matcher2, iEnd, charSequence);
    }
}
