package h3;

import com.stepos.alphame.app.AppEventDataItem;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import k3.C0694i;
import k3.InterfaceC0696k;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class f0 implements Closeable {

    @NotNull
    public static final e0 Companion = new e0();

    @Nullable
    private Reader reader;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    @NotNull
    public static final f0 create(@Nullable M m4, long j4, @NotNull InterfaceC0696k content) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        return e0.b(content, m4, j4);
    }

    @NotNull
    public final InputStream byteStream() {
        return source().M();
    }

    @NotNull
    public final k3.l byteString() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(Intrinsics.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        InterfaceC0696k interfaceC0696kSource = source();
        try {
            k3.l lVarH = interfaceC0696kSource.h();
            CloseableKt.closeFinally(interfaceC0696kSource, null);
            int iC = lVarH.c();
            if (jContentLength == -1 || jContentLength == iC) {
                return lVarH;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iC + ") disagree");
        } finally {
        }
    }

    @NotNull
    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(Intrinsics.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        InterfaceC0696k interfaceC0696kSource = source();
        try {
            byte[] bArrO = interfaceC0696kSource.o();
            CloseableKt.closeFinally(interfaceC0696kSource, null);
            int length = bArrO.length;
            if (jContentLength == -1 || jContentLength == length) {
                return bArrO;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    @NotNull
    public final Reader charStream() {
        Reader c0Var = this.reader;
        if (c0Var == null) {
            InterfaceC0696k interfaceC0696kSource = source();
            M mContentType = contentType();
            Charset charsetA = mContentType == null ? null : mContentType.a(Charsets.UTF_8);
            if (charsetA == null) {
                charsetA = Charsets.UTF_8;
            }
            c0Var = new c0(interfaceC0696kSource, charsetA);
            this.reader = c0Var;
        }
        return c0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract M contentType();

    public abstract InterfaceC0696k source();

    @NotNull
    public final String string() throws IOException {
        InterfaceC0696k interfaceC0696kSource = source();
        try {
            M mContentType = contentType();
            Charset charsetA = mContentType == null ? null : mContentType.a(Charsets.UTF_8);
            if (charsetA == null) {
                charsetA = Charsets.UTF_8;
            }
            String strK = interfaceC0696kSource.K(Util.readBomAsCharset(interfaceC0696kSource, charsetA));
            CloseableKt.closeFinally(interfaceC0696kSource, null);
            return strK;
        } finally {
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    @NotNull
    public static final f0 create(@Nullable M m4, @NotNull String content) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        return e0.a(content, m4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    @NotNull
    public static final f0 create(@Nullable M m4, @NotNull k3.l content) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(content, "<this>");
        C0694i c0694i = new C0694i();
        c0694i.T(content);
        return e0.b(c0694i, m4, content.c());
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    @NotNull
    public static final f0 create(@Nullable M m4, @NotNull byte[] content) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        return e0.c(content, m4);
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    public static final f0 create(@NotNull String str, @Nullable M m4) {
        Companion.getClass();
        return e0.a(str, m4);
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    public static final f0 create(@NotNull InterfaceC0696k interfaceC0696k, @Nullable M m4, long j4) {
        Companion.getClass();
        return e0.b(interfaceC0696k, m4, j4);
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    public static final f0 create(@NotNull k3.l lVar, @Nullable M m4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        C0694i c0694i = new C0694i();
        c0694i.T(lVar);
        return e0.b(c0694i, m4, lVar.c());
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    public static final f0 create(@NotNull byte[] bArr, @Nullable M m4) {
        Companion.getClass();
        return e0.c(bArr, m4);
    }
}
