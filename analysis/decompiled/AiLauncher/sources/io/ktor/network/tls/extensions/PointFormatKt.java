package io.ktor.network.tls.extensions;

import Z8.C1173v;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Lio/ktor/network/tls/extensions/PointFormat;", "SupportedPointFormats", "Ljava/util/List;", "getSupportedPointFormats", "()Ljava/util/List;", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PointFormatKt {
    private static final List<PointFormat> SupportedPointFormats = C1173v.p(PointFormat.UNCOMPRESSED, PointFormat.ANSIX962_COMPRESSED_PRIME, PointFormat.ANSIX962_COMPRESSED_CHAR2);

    public static final List<PointFormat> getSupportedPointFormats() {
        return SupportedPointFormats;
    }
}
