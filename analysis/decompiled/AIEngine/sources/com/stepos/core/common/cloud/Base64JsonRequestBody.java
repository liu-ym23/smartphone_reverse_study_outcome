package com.stepos.core.common.cloud;

import ad.l;
import ad.s;
import android.util.Base64;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Base64JsonRequestBody extends s {
    private static final int CHUNK_BYTES = 49152;
    public static final Companion Companion = new Companion(null);
    private static final l JSON_MEDIA_TYPE = bd.d.a("application/json; charset=utf-8");
    private final byte[] payload;
    private final String prefix;
    private final String suffix;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final int base64LengthOf(int i10) {
            return ((i10 + 2) / 3) * 4;
        }

        private Companion() {
        }
    }

    public Base64JsonRequestBody(String prefix, byte[] payload, String suffix) {
        kotlin.jvm.internal.g.f(prefix, "prefix");
        kotlin.jvm.internal.g.f(payload, "payload");
        kotlin.jvm.internal.g.f(suffix, "suffix");
        this.prefix = prefix;
        this.payload = payload;
        this.suffix = suffix;
    }

    @Override // ad.s
    public long contentLength() {
        String str = this.prefix;
        Charset charset = gc.a.f9106b;
        kotlin.jvm.internal.g.e(str.getBytes(charset), "getBytes(...)");
        long length = r0.length + Companion.base64LengthOf(this.payload.length);
        kotlin.jvm.internal.g.e(this.suffix.getBytes(charset), "getBytes(...)");
        return length + r7.length;
    }

    @Override // ad.s
    public l contentType() {
        return JSON_MEDIA_TYPE;
    }

    @Override // ad.s
    public boolean isOneShot() {
        return false;
    }

    @Override // ad.s
    public void writeTo(sd.g sink) {
        kotlin.jvm.internal.g.f(sink, "sink");
        sink.D(this.prefix);
        int i10 = 0;
        while (true) {
            byte[] bArr = this.payload;
            if (i10 >= bArr.length) {
                sink.D(this.suffix);
                return;
            }
            int iMin = Math.min(CHUNK_BYTES, bArr.length - i10);
            byte[] bArrEncode = Base64.encode(this.payload, i10, iMin, 2);
            kotlin.jvm.internal.g.e(bArrEncode, "encode(...)");
            sink.write(bArrEncode);
            i10 += iMin;
        }
    }
}
