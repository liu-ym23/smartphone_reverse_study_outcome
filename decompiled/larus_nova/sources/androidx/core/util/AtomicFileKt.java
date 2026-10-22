package androidx.core.util;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a0\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0086\b\u001a\u0012\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u001c\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0013"}, d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", Argument.OUT, "writeBytes", "array", "writeText", "text", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AtomicFileKt {
    public static final byte[] readBytes(android.util.AtomicFile r100) {
        return r100.readFully();
    }

    public static final String readText(android.util.AtomicFile r100, Charset r101) {
        return new String(r100.readFully(), r101);
    }

    public static final void tryWrite(android.util.AtomicFile r100, Function1<? super FileOutputStream, Unit> r101) {
        FileOutputStream r102 = r100.startWrite();
        r101.invoke(r102);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.finishWrite(r102);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.failWrite(r102);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void writeBytes(android.util.AtomicFile r100, byte[] r101) {
        FileOutputStream r102 = r100.startWrite();
        r102.write(r101);     // Catch: Throwable -> L6
        r100.finishWrite(r102);
        return;
    L6:
        th = move-exception;
        r100.failWrite(r102);
        throw th;
    }

    public static final void writeText(android.util.AtomicFile r100, String r101, Charset r102) {
        writeBytes(r100, r101.getBytes(r102));
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Charsets.UTF_8;
    L6:
        return readText(r100, r101);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile r100, String r101, Charset r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = Charsets.UTF_8;
    L5:
        writeText(r100, r101, r102);
    }
}
