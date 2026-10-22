package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class Resources {

    public static final class UrlByteSource extends ByteSource {
        private final URL url;

        public /* synthetic */ UrlByteSource(URL r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return this.url.openStream();
        }

        public String toString() {
            return "Resources.asByteSource(" + this.url + ")";
        }

        private UrlByteSource(URL r10) {
            this.url = (URL) Preconditions.checkNotNull(r10);
        }
    }

    private Resources() {
    }

    public static ByteSource asByteSource(URL r10) {
        return new UrlByteSource(r10, null);
    }

    public static CharSource asCharSource(URL r10, Charset r11) {
        return asByteSource(r10).asCharSource(r11);
    }

    public static void copy(URL r10, OutputStream r11) throws IOException {
        asByteSource(r10).copyTo(r11);
    }

    @CanIgnoreReturnValue
    public static URL getResource(String r10) {
        URL r11 = ((ClassLoader) MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(r10);
        if (r11 == null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "resource %s not found.", r10);
        return r11;
    L5:
        r12 = false;
        goto L6
    }

    @CanIgnoreReturnValue
    public static <T> T readLines(URL r10, Charset r11, LineProcessor<T> r12) throws IOException {
        return (T) asCharSource(r10, r11).readLines(r12);
    }

    public static byte[] toByteArray(URL r10) throws IOException {
        return asByteSource(r10).read();
    }

    public static String toString(URL r10, Charset r11) throws IOException {
        return asCharSource(r10, r11).read();
    }

    public static List<String> readLines(URL r10, Charset r11) throws IOException {
        return (List) readLines(r10, r11, new AnonymousClass1());
    }

    public static URL getResource(Class<?> r10, String r11) {
        URL r12 = r10.getResource(r11);
        if (r12 == null) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "resource %s relative to %s not found.", r11, r10.getName());
        return r12;
    L5:
        r13 = false;
        goto L6
    }
}
