package com.android.ttcjpaysdk.base;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/OuterSource;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NATIVE", "JSAPI", "SCHEME", "JSAPIMINIAPP", "SCHEMEAPP", "SCHEMEH5", "SCAN", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OuterSource extends Enum<OuterSource> {
    private static final /* synthetic */ OuterSource[] $VALUES = null;
    public static final Companion Companion = null;
    public static final OuterSource JSAPI = null;
    public static final OuterSource JSAPIMINIAPP = null;
    public static final OuterSource NATIVE = null;
    public static final OuterSource SCAN = null;

    @Deprecated(message = "this enum is deprecated!")
    public static final OuterSource SCHEME = null;
    public static final OuterSource SCHEMEAPP = null;
    public static final OuterSource SCHEMEH5 = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/OuterSource$Companion;", "", "()V", "fromValue", "Lcom/android/ttcjpaysdk/base/OuterSource;", "value", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final OuterSource fromValue(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            OuterSource[] r101 = OuterSource.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            OuterSource r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return OuterSource.NATIVE;
        L8:
            r104 = null;
            goto L9
        }
    }

    private static final /* synthetic */ OuterSource[] $values() {
        return new OuterSource[]{NATIVE, JSAPI, SCHEME, JSAPIMINIAPP, SCHEMEAPP, SCHEMEH5, SCAN};
    }

    public static OuterSource valueOf(String r100) {
        return (OuterSource) r27.a.a(OuterSource.class, r100);
    }

    public static OuterSource[] values() {
        return (OuterSource[]) $VALUES.clone();
    }

    static {
        NATIVE = new OuterSource("NATIVE", 0, "NATIVE");
        JSAPI = new OuterSource("JSAPI", 1, "JSAPI");
        SCHEME = new OuterSource("SCHEME", 2, "SCHEME");
        JSAPIMINIAPP = new OuterSource("JSAPIMINIAPP", 3, "JSAPI-MINIAPP");
        SCHEMEAPP = new OuterSource("SCHEMEAPP", 4, "SCHEME-APP");
        SCHEMEH5 = new OuterSource("SCHEMEH5", 5, "SCHEME-H5");
        SCAN = new OuterSource("SCAN", 6, "SCAN");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getValue() {
        return this.value;
    }

    private OuterSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
