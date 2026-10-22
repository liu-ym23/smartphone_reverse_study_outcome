package kotlin.io.encoding;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: Base64JVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a5\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a%\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a%\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b¨\u0006\u000e"}, d2 = {"platformCharsToBytes", "", "Lkotlin/io/encoding/Base64;", "source", "", "startIndex", "", "endIndex", "platformEncodeIntoByteArray", "destination", "destinationOffset", "platformEncodeToByteArray", "platformEncodeToString", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class Base64JVMKt {
    private static final byte[] platformCharsToBytes(Base64 r1, CharSequence r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "source");
        if ((r2 instanceof String) == false) goto L6;
        r1.checkSourceBounds$kotlin_stdlib(r2.length(), r3, r4);
        String r5 = ((String) r2).substring(r3, r4);
        Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
        Charset r6 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.String");
        byte[] r7 = r5.getBytes(r6);
        Intrinsics.checkNotNullExpressionValue(r7, "getBytes(...)");
        return r7;
    L6:
        return r1.charsToBytesImpl$kotlin_stdlib(r2, r3, r4);
    }

    private static final String platformEncodeToString(Base64 r1, byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "source");
        return new String(r1.encodeToByteArrayImpl$kotlin_stdlib(r2, r3, r4), Charsets.ISO_8859_1);
    }

    private static final int platformEncodeIntoByteArray(Base64 r1, byte[] r2, byte[] r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "destination");
        return r1.encodeIntoByteArrayImpl$kotlin_stdlib(r2, r3, r4, r5, r6);
    }

    private static final byte[] platformEncodeToByteArray(Base64 r1, byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "source");
        return r1.encodeToByteArrayImpl$kotlin_stdlib(r2, r3, r4);
    }
}
