package okhttp3.logging;

import La.D;
import Z8.A;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import h9.InterfaceC4149a;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import tb.C5530C;
import tb.u;
import tb.v;
import tb.w;
import tb.x;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0003.\u0012\u000eB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,\"\u0004\b(\u0010-¨\u0006/"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Ltb/w;", "Lokhttp3/logging/HttpLoggingInterceptor$b;", "logger", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$b;)V", "Ltb/u;", "headers", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LY8/t;", Const.INTENT_KEY_UMID, "(Ltb/u;I)V", "", Const.INTENT_KEY_APIKEY, "(Ltb/u;)Z", "Ltb/C;", UxipConstants.f30685x, Const.INTENT_KEY_PKGNAME, "(Ltb/C;)Z", "", "name", "e", "(Ljava/lang/String;)V", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;", "Ltb/w$a;", "chain", "intercept", "(Ltb/w$a;)Ltb/C;", "Ltb/v;", "url", "f", "(Ltb/v;)Ljava/lang/String;", "Lokhttp3/logging/HttpLoggingInterceptor$b;", "", "Ljava/util/Set;", "headersToRedact", "c", "queryParamsNameToRedact", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "Level", "logging-interceptor"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HttpLoggingInterceptor implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final b logger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile Set<String> headersToRedact;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public volatile Set<String> queryParamsNameToRedact;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile Level level;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "BASIC", "HEADERS", "BODY", "logging-interceptor"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Level {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        public static final Level NONE = new Level(ModelFlowMeta.PLAN_NONE, 0);
        public static final Level BASIC = new Level("BASIC", 1);
        public static final Level HEADERS = new Level("HEADERS", 2);
        public static final Level BODY = new Level("BODY", 3);

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{NONE, BASIC, HEADERS, BODY};
        }

        static {
            Level[] levelArr$values = $values();
            $VALUES = levelArr$values;
            $ENTRIES = a.a(levelArr$values);
        }

        private Level(String str, int i10) {
        }

        public static InterfaceC4149a<Level> getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$b;", "", "", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "logging-interceptor"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        void a(String message);
    }

    public HttpLoggingInterceptor(b logger) {
        p.i(logger, "logger");
        this.logger = logger;
        this.headersToRedact = Y.e();
        this.queryParamsNameToRedact = Y.e();
        this.level = Level.NONE;
    }

    private final boolean a(u headers) {
        String strB = headers.b(e.f30849h);
        return (strB == null || D.L(strB, e.f30860s, true) || D.L(strB, "gzip", true)) ? false : true;
    }

    private final boolean b(C5530C response) {
        x mediaType = response.getBody().getMediaType();
        return mediaType != null && p.d(mediaType.getType(), "text") && p.d(mediaType.getSubtype(), "event-stream");
    }

    private final void d(u headers, int i10) {
        String strK = this.headersToRedact.contains(headers.f(i10)) ? "██" : headers.k(i10);
        this.logger.a(headers.f(i10) + ": " + strK);
    }

    public final void c(Level level) {
        p.i(level, "<set-?>");
        this.level = level;
    }

    public final void e(String name) {
        p.i(name, "name");
        TreeSet treeSet = new TreeSet(D.M(y.f34840a));
        A.E(treeSet, this.headersToRedact);
        treeSet.add(name);
        this.headersToRedact = treeSet;
    }

    public final String f(v url) {
        p.i(url, "url");
        if (this.queryParamsNameToRedact.isEmpty() || url.q() == 0) {
            return url.getUrl();
        }
        v.a aVarQ = url.j().q(null);
        int iQ = url.q();
        for (int i10 = 0; i10 < iQ; i10++) {
            String strO = url.o(i10);
            aVarQ.a(strO, this.queryParamsNameToRedact.contains(strO) ? "██" : url.p(i10));
        }
        return aVarQ.toString();
    }

    public final HttpLoggingInterceptor g(Level level) {
        p.i(level, "level");
        this.level = level;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x010b A[LOOP:0: B:42:0x0109->B:43:0x010b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0117  */
    @Override // tb.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public tb.C5530C intercept(tb.w.a r23) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(tb.w$a):tb.C");
    }
}
