package I7;

import Y8.j;
import com.autonavi.aps.amapapi.config.Const;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.C5528A;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011¨\u0006\u0013"}, d2 = {"LI7/e;", "LI7/c;", "", "appId", "appSecret", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Ltb/A;", "request", "", Const.INTENT_KEY_APIKEY, "(Ltb/A;)Ljava/util/Map;", "c", "()Ljava/lang/String;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastTimestampMs", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String appSecret;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AtomicLong lastTimestampMs;

    public e(String appId, String appSecret) {
        p.i(appId, "appId");
        p.i(appSecret, "appSecret");
        this.appId = appId;
        this.appSecret = appSecret;
        this.lastTimestampMs = new AtomicLong(0L);
    }

    public static final long d(long j10, long j11) {
        return Math.max(j10, j11 + 1);
    }

    @Override // I7.c
    public Map<String, String> a(C5528A request) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        p.i(request, "request");
        String strC = c();
        return kotlin.collections.a.m(j.a("zy-app-id", this.appId), j.a("zy-nonce", strC), j.a("zy-timestamp", strC), j.a("zy-sign", b.f3385a.b(this.appId + strC + strC + this.appSecret, this.appSecret)));
    }

    public final String c() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        return String.valueOf(this.lastTimestampMs.updateAndGet(new LongUnaryOperator() { // from class: I7.d
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j10) {
                return e.d(jCurrentTimeMillis, j10);
            }
        }));
    }
}
