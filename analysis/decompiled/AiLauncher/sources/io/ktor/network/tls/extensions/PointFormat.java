package io.ktor.network.tls.extensions;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0005\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lio/ktor/network/tls/extensions/PointFormat;", "", "", "code", "<init>", "(Ljava/lang/String;IB)V", "B", "getCode", "()B", "UNCOMPRESSED", "ANSIX962_COMPRESSED_PRIME", "ANSIX962_COMPRESSED_CHAR2", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PointFormat {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PointFormat[] $VALUES;
    private final byte code;
    public static final PointFormat UNCOMPRESSED = new PointFormat("UNCOMPRESSED", 0, (byte) 0);
    public static final PointFormat ANSIX962_COMPRESSED_PRIME = new PointFormat("ANSIX962_COMPRESSED_PRIME", 1, (byte) 1);
    public static final PointFormat ANSIX962_COMPRESSED_CHAR2 = new PointFormat("ANSIX962_COMPRESSED_CHAR2", 2, (byte) 2);

    private static final /* synthetic */ PointFormat[] $values() {
        return new PointFormat[]{UNCOMPRESSED, ANSIX962_COMPRESSED_PRIME, ANSIX962_COMPRESSED_CHAR2};
    }

    static {
        PointFormat[] pointFormatArr$values = $values();
        $VALUES = pointFormatArr$values;
        $ENTRIES = a.a(pointFormatArr$values);
    }

    private PointFormat(String str, int i10, byte b10) {
        this.code = b10;
    }

    public static InterfaceC4149a<PointFormat> getEntries() {
        return $ENTRIES;
    }

    public static PointFormat valueOf(String str) {
        return (PointFormat) Enum.valueOf(PointFormat.class, str);
    }

    public static PointFormat[] values() {
        return (PointFormat[]) $VALUES.clone();
    }

    public final byte getCode() {
        return this.code;
    }
}
