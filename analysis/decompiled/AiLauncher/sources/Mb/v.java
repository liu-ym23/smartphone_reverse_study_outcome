package Mb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\u000f\u001a\u00020\u0001*\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0011\u001a\u00020\u0005*\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Ljava/io/OutputStream;", "LMb/G;", "c", "(Ljava/io/OutputStream;)LMb/G;", "Ljava/io/InputStream;", "LMb/I;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/io/InputStream;)LMb/I;", "Ljava/net/Socket;", "LMb/H;", "e", "(Ljava/net/Socket;)LMb/H;", "Ljava/io/File;", "", "append", Const.INTENT_KEY_PKGNAME, "(Ljava/io/File;Z)LMb/G;", "f", "(Ljava/io/File;)LMb/I;", "okio"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "okio/Okio")
/* loaded from: classes5.dex */
public final /* synthetic */ class v {
    public static final G a(File file) throws FileNotFoundException {
        kotlin.jvm.internal.p.i(file, "<this>");
        return d(file, false, 1, null);
    }

    public static final G b(File file, boolean z10) throws FileNotFoundException {
        kotlin.jvm.internal.p.i(file, "<this>");
        return u.h(new FileOutputStream(file, z10));
    }

    public static final G c(OutputStream outputStream) {
        kotlin.jvm.internal.p.i(outputStream, "<this>");
        return new sink(outputStream, new J());
    }

    public static /* synthetic */ G d(File file, boolean z10, int i10, Object obj) throws FileNotFoundException {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return u.g(file, z10);
    }

    public static final H e(Socket socket) {
        kotlin.jvm.internal.p.i(socket, "<this>");
        return new Nb.h(socket);
    }

    public static final I f(File file) throws FileNotFoundException {
        kotlin.jvm.internal.p.i(file, "<this>");
        return new source(new FileInputStream(file), J.f4694f);
    }

    public static final I g(InputStream inputStream) {
        kotlin.jvm.internal.p.i(inputStream, "<this>");
        return new source(inputStream, new J());
    }
}
