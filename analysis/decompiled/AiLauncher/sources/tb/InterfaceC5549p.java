package tb;

import com.autonavi.aps.amapapi.config.Const;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltb/p;", "", "", "hostname", "", "Ljava/net/InetAddress;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/util/List;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.p, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5549p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f42230a;

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC5549p f42229b = new Companion.C0532a();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0001¨\u0006\b"}, d2 = {"Ltb/p$a;", "", "<init>", "()V", "Ltb/p;", "SYSTEM", "Ltb/p;", Const.INTENT_KEY_APIKEY, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.p$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f42230a = new Companion();

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltb/p$a$a;", "Ltb/p;", "<init>", "()V", "", "hostname", "", "Ljava/net/InetAddress;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/util/List;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: tb.p$a$a, reason: collision with other inner class name */
        public static final class C0532a implements InterfaceC5549p {
            @Override // tb.InterfaceC5549p
            public List<InetAddress> a(String hostname) throws UnknownHostException {
                kotlin.jvm.internal.p.i(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    kotlin.jvm.internal.p.h(allByName, "getAllByName(...)");
                    return Z8.r.T0(allByName);
                } catch (NullPointerException e10) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + hostname);
                    unknownHostException.initCause(e10);
                    throw unknownHostException;
                }
            }
        }
    }

    List<InetAddress> a(String hostname) throws UnknownHostException;
}
