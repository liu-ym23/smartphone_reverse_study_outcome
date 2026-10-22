package h3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import k3.InterfaceC0696k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class c0 extends Reader {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0696k f12879a;

    /* renamed from: b, reason: collision with root package name */
    public final Charset f12880b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12881c;

    /* renamed from: d, reason: collision with root package name */
    public InputStreamReader f12882d;

    public c0(InterfaceC0696k source, Charset charset) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.f12879a = source;
        this.f12880b = charset;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Unit unit;
        this.f12881c = true;
        InputStreamReader inputStreamReader = this.f12882d;
        if (inputStreamReader == null) {
            unit = null;
        } else {
            inputStreamReader.close();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.f12879a.close();
        }
    }

    @Override // java.io.Reader
    public final int read(char[] cbuf, int i4, int i5) throws IOException {
        Intrinsics.checkNotNullParameter(cbuf, "cbuf");
        if (this.f12881c) {
            throw new IOException("Stream closed");
        }
        InputStreamReader inputStreamReader = this.f12882d;
        if (inputStreamReader == null) {
            InterfaceC0696k interfaceC0696k = this.f12879a;
            inputStreamReader = new InputStreamReader(interfaceC0696k.M(), Util.readBomAsCharset(interfaceC0696k, this.f12880b));
            this.f12882d = inputStreamReader;
        }
        return inputStreamReader.read(cbuf, i4, i5);
    }
}
