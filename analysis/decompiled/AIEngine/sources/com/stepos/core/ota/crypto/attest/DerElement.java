package com.stepos.core.ota.crypto.attest;

import ai.onnxruntime.providers.a;
import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DerElement {
    private final boolean constructed;
    private final byte[] content;
    private final int tagClass;
    private final int tagNumber;

    public DerElement(int i10, boolean z, int i11, byte[] content) {
        g.f(content, "content");
        this.tagClass = i10;
        this.constructed = z;
        this.tagNumber = i11;
        this.content = content;
    }

    private static final CharSequence hex$lambda$2(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    public final boolean asBoolean() {
        byte[] bArr = this.content;
        if (bArr.length == 1) {
            return bArr[0] != 0;
        }
        throw new IllegalStateException(a.a(bArr.length, "boolean length ").toString());
    }

    public final long asLong() {
        byte[] bArr = this.content;
        if (bArr.length == 0) {
            throw new IllegalStateException("empty integer");
        }
        long j10 = 0;
        for (byte b10 : bArr) {
            j10 = (j10 << 8) | (b10 & 255);
        }
        return j10;
    }

    public final String asUtf8() {
        return new String(this.content, gc.a.f9106b);
    }

    public final boolean getConstructed() {
        return this.constructed;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final int getTagClass() {
        return this.tagClass;
    }

    public final int getTagNumber() {
        return this.tagNumber;
    }

    public final String hex() {
        byte[] bArr = this.content;
        g.f(bArr, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int i10 = 0;
        for (byte b10 : bArr) {
            i10++;
            if (i10 > 1) {
                sb2.append((CharSequence) "");
            }
            sb2.append(hex$lambda$2(b10));
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    public final boolean isContext() {
        return this.tagClass == 2;
    }

    public final boolean isUniversal() {
        return this.tagClass == 0;
    }

    public final DerReader reader() {
        return new DerReader(this.content, 0, 0, 6, null);
    }

    public final DerElement unwrapExplicit() {
        return reader().next();
    }
}
