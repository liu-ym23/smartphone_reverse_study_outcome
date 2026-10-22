package kotlin.text;

import La.m;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements InterfaceC5074l<m, m> {

    /* renamed from: a, reason: collision with root package name */
    public static final Regex$findAll$2 f36179a = new Regex$findAll$2();

    public Regex$findAll$2() {
        super(1, m.class, "next", "next()Lkotlin/text/MatchResult;", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final m invoke(m p02) {
        p.i(p02, "p0");
        return p02.next();
    }
}
