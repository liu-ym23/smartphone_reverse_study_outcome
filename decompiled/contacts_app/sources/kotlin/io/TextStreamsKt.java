package kotlin.io;

import androidx.exifinterface.media.ExifInterface;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: ReadWrite.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001a5\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TextStreamsKt {
    static /* synthetic */ BufferedReader buffered$default(Reader r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if ((r0 instanceof BufferedReader) == false) goto L9;
        return (BufferedReader) r0;
    L9:
        return new BufferedReader(r0, r1);
    }

    private static final BufferedReader buffered(Reader r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r1;
    L6:
        return new BufferedReader(r1, r2);
    }

    static /* synthetic */ BufferedWriter buffered$default(Writer r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if ((r0 instanceof BufferedWriter) == false) goto L9;
        return (BufferedWriter) r0;
    L9:
        return new BufferedWriter(r0, r1);
    }

    private static final BufferedWriter buffered(Writer r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r1;
    L6:
        return new BufferedWriter(r1, r2);
    }

    public static final List<String> readLines(Reader r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        final ArrayList r0 = new ArrayList();
        forEachLine(r2, new AnonymousClass1(r0));
        return r0;
    }

    public static final <T> T useLines(Reader r3, Function1<? super Sequence<String>, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        if ((r3 instanceof BufferedReader) == false) goto L5;
        BufferedReader r5 = (BufferedReader) r3;
    L6:
        BufferedReader r6 = r5;
        T r7 = r4.invoke(lineSequence(r6));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r6, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r7;
    L11:
        r6.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L25;
        CloseableKt.closeFinally(r6, th);
    L22:
        InlineMarker.finallyEnd(1);
        throw th;
    L25:
        r6.close();     // Catch: Throwable -> L24
        goto L22
    L5:
        r5 = new BufferedReader(r3, 8192);
        goto L6
    }

    private static final StringReader reader(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new StringReader(r1);
    }

    public static final Sequence<String> lineSequence(BufferedReader r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SequencesKt.constrainOnce(new LinesSequence(r1));
    }

    public static final String readText(Reader r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StringWriter r0 = new StringWriter();
        copyTo$default(r5, r0, 0, 2, null);
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }

    public static /* synthetic */ long copyTo$default(Reader r0, Writer r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 8192;
    L6:
        return copyTo(r0, r1, r2);
    }

    public static final long copyTo(Reader r5, Writer r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "out");
        char[] r8 = new char[r7];
        int r0 = r5.read(r8);
        long r1 = 0;
    L3:
        if (r0 < 0) goto L5;
        r6.write(r8, 0, r0);
        r1 = r1 + ((long) r0);
        r0 = r5.read(r8);
        goto L3
    L5:
        return r1;
    }

    private static final String readText(URL r1, Charset r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        return new String(readBytes(r1), r2);
    }

    static /* synthetic */ String readText$default(URL r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        return new String(readBytes(r0), r1);
    }

    public static final byte[] readBytes(URL r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        InputStream r3 = r2.openStream();
        InputStream r0 = r3;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L6
        byte[] r1 = ByteStreamsKt.readBytes(r0);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r3, null);
        return r1;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    public static final void forEachLine(Reader r2, Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        if ((r2 instanceof BufferedReader) == false) goto L5;
        BufferedReader r4 = (BufferedReader) r2;
    L6:
        BufferedReader r5 = r4;
        Iterator<String> r0 = lineSequence(r5).iterator();     // Catch: Throwable -> L14
    L9:
        if (r0.hasNext() == false) goto L11;
        r3.invoke(r0.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r5, null);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L5:
        r4 = new BufferedReader(r2, 8192);
        goto L6
    }
}
