package k9;

import La.MatchGroup;
import com.autonavi.aps.amapapi.config.Const;
import j9.C4788a;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.random.Random;
import u9.C5590a;
import v9.C5680i;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lk9/a;", "Lj9/a;", "<init>", "()V", "Ljava/util/regex/MatchResult;", "matchResult", "", "name", "LLa/j;", "c", "(Ljava/util/regex/MatchResult;Ljava/lang/String;)LLa/j;", "Lkotlin/random/Random;", Const.INTENT_KEY_PKGNAME, "()Lkotlin/random/Random;", "LMa/a;", Const.INTENT_KEY_UMID, "()LMa/a;", "", "version", "", "e", "(I)Z", Const.INTENT_KEY_APIKEY, "kotlin-stdlib-jdk8"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: k9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4820a extends C4788a {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lk9/a$a;", "", "<init>", "()V", "", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Integer;", "sdkVersion", "kotlin-stdlib-jdk8"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: k9.a$a, reason: collision with other inner class name */
    public static final class C0428a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0428a f34641a = new C0428a();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Integer sdkVersion;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            sdkVersion = num;
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"k9/a$b", "LMa/a;", "kotlin-stdlib-jdk8"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: k9.a$b */
    public static final class b implements Ma.a {
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"k9/a$c", "LMa/a;", "kotlin-stdlib-jdk8"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: k9.a$c */
    public static final class c implements Ma.a {
    }

    @Override // i9.C4178a
    public Random b() {
        return e(34) ? new C5590a() : super.b();
    }

    @Override // i9.C4178a
    public MatchGroup c(MatchResult matchResult, String name) {
        p.i(matchResult, "matchResult");
        p.i(name, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        C5680i c5680i = new C5680i(matcher.start(name), matcher.end(name) - 1);
        if (c5680i.l().intValue() < 0) {
            return null;
        }
        String strGroup = matcher.group(name);
        p.h(strGroup, "group(...)");
        return new MatchGroup(strGroup, c5680i);
    }

    @Override // i9.C4178a
    public Ma.a d() {
        return e(26) ? new b() : new c();
    }

    public final boolean e(int version) {
        Integer num = C0428a.sdkVersion;
        return num == null || num.intValue() >= version;
    }
}
