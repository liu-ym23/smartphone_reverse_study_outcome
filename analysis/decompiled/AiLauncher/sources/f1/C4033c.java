package f1;

import android.annotation.SuppressLint;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljava/nio/channels/ReadableByteChannel;", "input", "Ljava/nio/channels/FileChannel;", "output", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/channels/FileChannel;)V", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: f1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4033c {
    @SuppressLint({"LambdaLast"})
    public static final void a(ReadableByteChannel input, FileChannel output) throws IOException {
        p.i(input, "input");
        p.i(output, "output");
        try {
            output.transferFrom(input, 0L, Long.MAX_VALUE);
            output.force(false);
        } finally {
            input.close();
            output.close();
        }
    }
}
