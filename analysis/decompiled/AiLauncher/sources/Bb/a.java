package Bb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"LBb/a;", "", "Lokio/ByteString;", "name", UxipConstants.f30680s, "<init>", "(Lokio/ByteString;Lokio/ByteString;)V", "", "(Ljava/lang/String;Ljava/lang/String;)V", "(Lokio/ByteString;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Lokio/ByteString;", Const.INTENT_KEY_PKGNAME, "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lokio/ByteString;", "c", "I", "hpackSize", Const.INTENT_KEY_UMID, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class a {

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f1480e;

    /* renamed from: f, reason: collision with root package name */
    public static final ByteString f1481f;

    /* renamed from: g, reason: collision with root package name */
    public static final ByteString f1482g;

    /* renamed from: h, reason: collision with root package name */
    public static final ByteString f1483h;

    /* renamed from: i, reason: collision with root package name */
    public static final ByteString f1484i;

    /* renamed from: j, reason: collision with root package name */
    public static final ByteString f1485j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ByteString name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ByteString value;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int hpackSize;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f1480e = companion.d(ServerSentEventKt.COLON);
        f1481f = companion.d(":status");
        f1482g = companion.d(":method");
        f1483h = companion.d(":path");
        f1484i = companion.d(":scheme");
        f1485j = companion.d(":authority");
    }

    public a(ByteString name, ByteString value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = name.K() + 32 + value.K();
    }

    /* renamed from: a, reason: from getter */
    public final ByteString getName() {
        return this.name;
    }

    /* renamed from: b, reason: from getter */
    public final ByteString getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        return kotlin.jvm.internal.p.d(this.name, aVar.name) && kotlin.jvm.internal.p.d(this.value, aVar.value);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return this.name.Q() + ": " + this.value.Q();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(String name, String value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        ByteString.Companion companion = ByteString.INSTANCE;
        this(companion.d(name), companion.d(value));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(ByteString name, String value) {
        this(name, ByteString.INSTANCE.d(value));
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
    }
}
