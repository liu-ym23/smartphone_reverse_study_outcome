package io.ktor.http;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/ktor/http/CookieEncoding;", "", "<init>", "(Ljava/lang/String;I)V", "RAW", "DQUOTES", "URI_ENCODING", "BASE64_ENCODING", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CookieEncoding {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ CookieEncoding[] $VALUES;
    public static final CookieEncoding RAW = new CookieEncoding("RAW", 0);
    public static final CookieEncoding DQUOTES = new CookieEncoding("DQUOTES", 1);
    public static final CookieEncoding URI_ENCODING = new CookieEncoding("URI_ENCODING", 2);
    public static final CookieEncoding BASE64_ENCODING = new CookieEncoding("BASE64_ENCODING", 3);

    private static final /* synthetic */ CookieEncoding[] $values() {
        return new CookieEncoding[]{RAW, DQUOTES, URI_ENCODING, BASE64_ENCODING};
    }

    static {
        CookieEncoding[] cookieEncodingArr$values = $values();
        $VALUES = cookieEncodingArr$values;
        $ENTRIES = kotlin.enums.a.a(cookieEncodingArr$values);
    }

    private CookieEncoding(String str, int i10) {
    }

    public static InterfaceC4149a<CookieEncoding> getEntries() {
        return $ENTRIES;
    }

    public static CookieEncoding valueOf(String str) {
        return (CookieEncoding) Enum.valueOf(CookieEncoding.class, str);
    }

    public static CookieEncoding[] values() {
        return (CookieEncoding[]) $VALUES.clone();
    }
}
