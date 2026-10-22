package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: PathReadWrite.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a:\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0015\u001a:\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00010\u001bH\u0087\bø\u0001\u0000\u001a&\u0010 \u001a\u00020!*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020$*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0004*\u00020\u0002H\u0087\b\u001a\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0016\u0010)\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a0\u0010*\u001a\u00020+*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010,\u001a?\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000b\u0012\u0004\u0012\u0002H.0\u001bH\u0087\bø\u0001\u0000¢\u0006\u0002\u00100\u001a.\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00102\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00104\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00105\u001a7\u00106\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u00107\u001a0\u00108\u001a\u000209*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"appendBytes", "", "Ljava/nio/file/Path;", "array", "", "appendLines", "lines", "", "", "charset", "Ljava/nio/charset/Charset;", "Lkotlin/sequences/Sequence;", "appendText", "text", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "forEachLine", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "writeLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "writeText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathReadWriteKt {
    public PathsKt__PathReadWriteKt() {
    }

    static /* synthetic */ InputStreamReader reader$default(Path r0, Charset r1, OpenOption[] r2, int r3, Object r4) throws IOException {
        if ((r3 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        Intrinsics.checkNotNullParameter(r2, "options");
        return new InputStreamReader(Files.newInputStream(r0, (OpenOption[]) Arrays.copyOf(r2, r2.length)), r1);
    }

    private static final InputStreamReader reader(Path r2, Charset r3, OpenOption... r4) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r4, "options");
        return new InputStreamReader(Files.newInputStream(r2, (OpenOption[]) Arrays.copyOf(r4, r4.length)), r3);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(Path r1, Charset r2, int r3, OpenOption[] r4, int r5, Object r6) throws IOException {
        if ((r5 & 1) == 0) goto L6;
        r2 = Charsets.UTF_8;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Intrinsics.checkNotNullParameter(r4, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(r1, (OpenOption[]) Arrays.copyOf(r4, r4.length)), r2), r3);
    }

    private static final BufferedReader bufferedReader(Path r3, Charset r4, int r5, OpenOption... r6) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r6, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(r3, (OpenOption[]) Arrays.copyOf(r6, r6.length)), r4), r5);
    }

    static /* synthetic */ OutputStreamWriter writer$default(Path r0, Charset r1, OpenOption[] r2, int r3, Object r4) throws IOException {
        if ((r3 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        Intrinsics.checkNotNullParameter(r2, "options");
        return new OutputStreamWriter(Files.newOutputStream(r0, (OpenOption[]) Arrays.copyOf(r2, r2.length)), r1);
    }

    private static final OutputStreamWriter writer(Path r2, Charset r3, OpenOption... r4) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r4, "options");
        return new OutputStreamWriter(Files.newOutputStream(r2, (OpenOption[]) Arrays.copyOf(r4, r4.length)), r3);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(Path r1, Charset r2, int r3, OpenOption[] r4, int r5, Object r6) throws IOException {
        if ((r5 & 1) == 0) goto L6;
        r2 = Charsets.UTF_8;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Intrinsics.checkNotNullParameter(r4, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(r1, (OpenOption[]) Arrays.copyOf(r4, r4.length)), r2), r3);
    }

    private static final BufferedWriter bufferedWriter(Path r3, Charset r4, int r5, OpenOption... r6) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r6, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(r3, (OpenOption[]) Arrays.copyOf(r6, r6.length)), r4), r5);
    }

    private static final byte[] readBytes(Path r1) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        byte[] r2 = Files.readAllBytes(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "readAllBytes(...)");
        return r2;
    }

    private static final void writeBytes(Path r1, byte[] r2, OpenOption... r3) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "array");
        Intrinsics.checkNotNullParameter(r3, "options");
        Files.write(r1, r2, (OpenOption[]) Arrays.copyOf(r3, r3.length));
    }

    private static final void appendBytes(Path r3, byte[] r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "array");
        Files.write(r3, r4, new OpenOption[]{StandardOpenOption.APPEND});
    }

    public static /* synthetic */ String readText$default(Path r0, Charset r1, int r2, Object r3) throws IOException {
        if ((r2 & 1) == 0) goto L6;
        r1 = Charsets.UTF_8;
    L6:
        return PathsKt.readText(r0, r1);
    }

    public static final String readText(Path r3, Charset r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        InputStreamReader r2 = new InputStreamReader(Files.newInputStream(r3, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), r4);
        String r5 = TextStreamsKt.readText(r2);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r2, null);
        return r5;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    public static /* synthetic */ void writeText$default(Path r0, CharSequence r1, Charset r2, OpenOption[] r3, int r4, Object r5) throws IOException {
        if ((r4 & 2) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        PathsKt.writeText(r0, r1, r2, r3);
    }

    public static final void writeText(Path r1, CharSequence r2, Charset r3, OpenOption... r4) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r4, "options");
        OutputStream r5 = Files.newOutputStream(r1, (OpenOption[]) Arrays.copyOf(r4, r4.length));
        Intrinsics.checkNotNullExpressionValue(r5, "newOutputStream(...)");
        OutputStreamWriter r6 = new OutputStreamWriter(r5, r3);
        r6.append(r2);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r6, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    }

    public static /* synthetic */ void appendText$default(Path r0, CharSequence r1, Charset r2, int r3, Object r4) throws IOException {
        if ((r3 & 2) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        PathsKt.appendText(r0, r1, r2);
    }

    public static final void appendText(Path r3, CharSequence r4, Charset r5) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "charset");
        OutputStream r6 = Files.newOutputStream(r3, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r6, "newOutputStream(...)");
        OutputStreamWriter r0 = new OutputStreamWriter(r6, r5);
        r0.append(r4);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r0, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    static /* synthetic */ void forEachLine$default(Path r1, Charset r2, Function1 r3, int r4, Object r5) throws IOException {
        if ((r4 & 1) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Intrinsics.checkNotNullParameter(r3, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        BufferedReader r6 = Files.newBufferedReader(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r6, "newBufferedReader(...)");
        BufferedReader r7 = r6;
        Iterator<String> r8 = TextStreamsKt.lineSequence(r7).iterator();     // Catch: Throwable -> L17
    L8:
        if (r8.hasNext() == false) goto L10;
        r3.invoke(r8.next());     // Catch: Throwable -> L17
        goto L8
    L10:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L14;
        CloseableKt.closeFinally(r7, null);
    L15:
        InlineMarker.finallyEnd(1);
        return;
    L14:
        r7.close();
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L32;
        CloseableKt.closeFinally(r7, th);
    L25:
        InlineMarker.finallyEnd(1);
        throw th;
    L32:
        r7.close();     // Catch: Throwable -> L27
        goto L25
    }

    private static final void forEachLine(Path r3, Charset r4, Function1<? super String, Unit> r5) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r5, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        BufferedReader r6 = Files.newBufferedReader(r3, r4);
        Intrinsics.checkNotNullExpressionValue(r6, "newBufferedReader(...)");
        BufferedReader r7 = r6;
        Iterator<String> r1 = TextStreamsKt.lineSequence(r7).iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L7;
        r5.invoke(r1.next());     // Catch: Throwable -> L14
        goto L5
    L7:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r7, null);
    L12:
        InlineMarker.finallyEnd(1);
        return;
    L11:
        r7.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L29;
        CloseableKt.closeFinally(r7, th);
    L22:
        InlineMarker.finallyEnd(1);
        throw th;
    L29:
        r7.close();     // Catch: Throwable -> L24
        goto L22
    }

    private static final InputStream inputStream(Path r1, OpenOption... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        InputStream r3 = Files.newInputStream(r1, (OpenOption[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "newInputStream(...)");
        return r3;
    }

    private static final OutputStream outputStream(Path r1, OpenOption... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        OutputStream r3 = Files.newOutputStream(r1, (OpenOption[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "newOutputStream(...)");
        return r3;
    }

    static /* synthetic */ List readLines$default(Path r0, Charset r1, int r2, Object r3) throws IOException {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        List<String> r4 = Files.readAllLines(r0, r1);
        Intrinsics.checkNotNullExpressionValue(r4, "readAllLines(...)");
        return r4;
    }

    private static final List<String> readLines(Path r1, Charset r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        List<String> r3 = Files.readAllLines(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "readAllLines(...)");
        return r3;
    }

    static /* synthetic */ Object useLines$default(Path r0, Charset r1, Function1 r2, int r3, Object r4) throws IOException {
        if ((r3 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        Intrinsics.checkNotNullParameter(r2, "block");
        BufferedReader r5 = Files.newBufferedReader(r0, r1);
        BufferedReader r6 = r5;     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L14
        Object r7 = r2.invoke(TextStreamsKt.lineSequence(r6));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L10;
        CloseableKt.closeFinally(r5, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r7;
    L10:
        if (r5 == null) goto L12;
        r5.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L22;
        if (r5 != null) goto L30;
    L23:
        InlineMarker.finallyEnd(1);
        throw th;
    L30:
        r5.close();     // Catch: Throwable -> L25
        goto L23
    L22:
        CloseableKt.closeFinally(r5, th);
        goto L23
    }

    private static final <T> T useLines(Path r2, Charset r3, Function1<? super Sequence<String>, ? extends T> r4) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r4, "block");
        BufferedReader r5 = Files.newBufferedReader(r2, r3);
        BufferedReader r1 = r5;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L11
        T r6 = r4.invoke(TextStreamsKt.lineSequence(r1));     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        CloseableKt.closeFinally(r5, null);
    L9:
        InlineMarker.finallyEnd(1);
        return r6;
    L7:
        if (r5 == null) goto L9;
        r5.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L19;
        if (r5 != null) goto L23;
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L23:
        r5.close();     // Catch: Throwable -> L22
        goto L20
    L19:
        CloseableKt.closeFinally(r5, th);
        goto L20
    }

    static /* synthetic */ Path writeLines$default(Path r0, Iterable r1, Charset r2, OpenOption[] r3, int r4, Object r5) throws IOException {
        if ((r4 & 2) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "lines");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Intrinsics.checkNotNullParameter(r3, "options");
        Path r6 = Files.write(r0, r1, r2, (OpenOption[]) Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r6, "write(...)");
        return r6;
    }

    private static final Path writeLines(Path r1, Iterable<? extends CharSequence> r2, Charset r3, OpenOption... r4) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "lines");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r4, "options");
        Path r5 = Files.write(r1, r2, r3, (OpenOption[]) Arrays.copyOf(r4, r4.length));
        Intrinsics.checkNotNullExpressionValue(r5, "write(...)");
        return r5;
    }

    static /* synthetic */ Path writeLines$default(Path r0, Sequence r1, Charset r2, OpenOption[] r3, int r4, Object r5) throws IOException {
        if ((r4 & 2) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "lines");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Intrinsics.checkNotNullParameter(r3, "options");
        Path r6 = Files.write(r0, SequencesKt.asIterable(r1), r2, (OpenOption[]) Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r6, "write(...)");
        return r6;
    }

    private static final Path writeLines(Path r1, Sequence<? extends CharSequence> r2, Charset r3, OpenOption... r4) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "lines");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r4, "options");
        Path r5 = Files.write(r1, SequencesKt.asIterable(r2), r3, (OpenOption[]) Arrays.copyOf(r4, r4.length));
        Intrinsics.checkNotNullExpressionValue(r5, "write(...)");
        return r5;
    }

    static /* synthetic */ Path appendLines$default(Path r1, Iterable r2, Charset r3, int r4, Object r5) throws IOException {
        if ((r4 & 2) == 0) goto L5;
        r3 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "lines");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Path r6 = Files.write(r1, r2, r3, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r6, "write(...)");
        return r6;
    }

    private static final Path appendLines(Path r3, Iterable<? extends CharSequence> r4, Charset r5) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "lines");
        Intrinsics.checkNotNullParameter(r5, "charset");
        Path r6 = Files.write(r3, r4, r5, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r6, "write(...)");
        return r6;
    }

    static /* synthetic */ Path appendLines$default(Path r1, Sequence r2, Charset r3, int r4, Object r5) throws IOException {
        if ((r4 & 2) == 0) goto L5;
        r3 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "lines");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Path r6 = Files.write(r1, SequencesKt.asIterable(r2), r3, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r6, "write(...)");
        return r6;
    }

    private static final Path appendLines(Path r3, Sequence<? extends CharSequence> r4, Charset r5) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "lines");
        Intrinsics.checkNotNullParameter(r5, "charset");
        Path r6 = Files.write(r3, SequencesKt.asIterable(r4), r5, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r6, "write(...)");
        return r6;
    }
}
