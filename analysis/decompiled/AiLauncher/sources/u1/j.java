package u1;

import Mb.InterfaceC0968f;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007\"\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lu1/c;", "LMb/f;", "source", "", Const.INTENT_KEY_APIKEY, "(Lu1/c;LMb/f;)Z", "Lokio/ByteString;", "Lokio/ByteString;", "SVG_TAG", Const.INTENT_KEY_PKGNAME, "LEFT_ANGLE_BRACKET", "coil-svg_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f42417a;

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f42418b;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f42417a = companion.d("<svg");
        f42418b = companion.d("<");
    }

    public static final boolean a(c cVar, InterfaceC0968f interfaceC0968f) {
        return interfaceC0968f.P(0L, f42418b) && F1.i.a(interfaceC0968f, f42417a, 0L, 1024L) != -1;
    }
}
