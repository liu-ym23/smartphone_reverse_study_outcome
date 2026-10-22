package io.ktor.network.tls;

import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lio/ktor/network/tls/TLSRecordType;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "getCode", "()I", "Companion", "ChangeCipherSpec", "Alert", "Handshake", "ApplicationData", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSRecordType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TLSRecordType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final TLSRecordType[] byCode;
    private final int code;
    public static final TLSRecordType ChangeCipherSpec = new TLSRecordType("ChangeCipherSpec", 0, 20);
    public static final TLSRecordType Alert = new TLSRecordType("Alert", 1, 21);
    public static final TLSRecordType Handshake = new TLSRecordType("Handshake", 2, 22);
    public static final TLSRecordType ApplicationData = new TLSRecordType("ApplicationData", 3, 23);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/network/tls/TLSRecordType$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/network/tls/TLSRecordType;", "byCode", "(I)Lio/ktor/network/tls/TLSRecordType;", "", "[Lio/ktor/network/tls/TLSRecordType;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final TLSRecordType byCode(int code) {
            TLSRecordType tLSRecordType = (code < 0 || code >= 256) ? null : TLSRecordType.byCode[code];
            if (tLSRecordType != null) {
                return tLSRecordType;
            }
            throw new IllegalArgumentException("Invalid TLS record type code: " + code);
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TLSRecordType[] $values() {
        return new TLSRecordType[]{ChangeCipherSpec, Alert, Handshake, ApplicationData};
    }

    static {
        TLSRecordType next;
        TLSRecordType[] tLSRecordTypeArr$values = $values();
        $VALUES = tLSRecordTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(tLSRecordTypeArr$values);
        INSTANCE = new Companion(null);
        TLSRecordType[] tLSRecordTypeArr = new TLSRecordType[256];
        for (int i10 = 0; i10 < 256; i10++) {
            Iterator<TLSRecordType> it = getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (next.code == i10) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            tLSRecordTypeArr[i10] = next;
        }
        byCode = tLSRecordTypeArr;
    }

    private TLSRecordType(String str, int i10, int i11) {
        this.code = i11;
    }

    public static InterfaceC4149a<TLSRecordType> getEntries() {
        return $ENTRIES;
    }

    public static TLSRecordType valueOf(String str) {
        return (TLSRecordType) Enum.valueOf(TLSRecordType.class, str);
    }

    public static TLSRecordType[] values() {
        return (TLSRecordType[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
