package io.ktor.http.auth;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/auth/HeaderValueEncoding;", "", "<init>", "(Ljava/lang/String;I)V", "QUOTED_WHEN_REQUIRED", "QUOTED_ALWAYS", "URI_ENCODE", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HeaderValueEncoding {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ HeaderValueEncoding[] $VALUES;
    public static final HeaderValueEncoding QUOTED_WHEN_REQUIRED = new HeaderValueEncoding("QUOTED_WHEN_REQUIRED", 0);
    public static final HeaderValueEncoding QUOTED_ALWAYS = new HeaderValueEncoding("QUOTED_ALWAYS", 1);
    public static final HeaderValueEncoding URI_ENCODE = new HeaderValueEncoding("URI_ENCODE", 2);

    private static final /* synthetic */ HeaderValueEncoding[] $values() {
        return new HeaderValueEncoding[]{QUOTED_WHEN_REQUIRED, QUOTED_ALWAYS, URI_ENCODE};
    }

    static {
        HeaderValueEncoding[] headerValueEncodingArr$values = $values();
        $VALUES = headerValueEncodingArr$values;
        $ENTRIES = a.a(headerValueEncodingArr$values);
    }

    private HeaderValueEncoding(String str, int i10) {
    }

    public static InterfaceC4149a<HeaderValueEncoding> getEntries() {
        return $ENTRIES;
    }

    public static HeaderValueEncoding valueOf(String str) {
        return (HeaderValueEncoding) Enum.valueOf(HeaderValueEncoding.class, str);
    }

    public static HeaderValueEncoding[] values() {
        return (HeaderValueEncoding[]) $VALUES.clone();
    }
}
