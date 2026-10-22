package com.bytedance.retrofit2.e;

import android.text.TextUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: TypedByteArray.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends a implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9542e;
    private byte[] f;
    private final String g;

    public g(String r2, byte[] r3, String... r4) {
        if (r4 != null) goto L5;
    L7:
        String r5 = null;
    L8:
        if (r2 == null) goto L10;
    L13:
        Objects.requireNonNull(r3, "bytes null");
        this.f9542e = r2;
        this.f = r3;
        this.g = r5;
        return;
    L10:
        if (TextUtils.isEmpty(r5) == false) goto L12;
        r2 = "application/unknown";
        goto L13
    L12:
        r2 = "application/octet-stream";
        goto L13
    L5:
        if (r4.length <= 0) goto L7;
        r5 = r4[0];
        goto L8
    }

    public byte[] i() {
        return this.f;
    }

    @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
    public String a() {
        if (TextUtils.isEmpty(this.g) == false) goto L7;
        return null;
    L7:
        return this.g;
    }

    @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
    public String b() {
        return this.f9542e;
    }

    @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
    public long c() {
        return this.f.length;
    }

    @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
    public void a(OutputStream r1) {
        r1.write(this.f);
    }

    @Override // com.bytedance.retrofit2.e.i
    public InputStream e_() {
        return new ByteArrayInputStream(this.f);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (Arrays.equals(this.f, r6.f) == true) goto L14;
        return false;
    L14:
        if (this.f9542e.equals(r6.f9542e) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public int hashCode() {
        return (this.f9542e.hashCode() * 31) + Arrays.hashCode(this.f);
    }

    public String toString() {
        return "TypedByteArray[length=" + c() + "]";
    }

    @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
    public String d() {
        byte[] r0 = this.f;
        if (r0 != null) goto L6;
        return null;
    L6:
        this.f9508c = b.a(r0);
        return this.f9508c;
    }

    @Override // com.bytedance.retrofit2.e.a
    public boolean e() {
        byte[] r0 = this.f;
        if (r0 != null) goto L5;
    L12:
        return false;
    L5:
        if (r0.length > 102400) goto L12;
        byte[] r1 = EncryptorUtil.a(r0, r0.length);
        if (r1 != null) goto L10;
        return false;
    L10:
        this.f = r1;
        this.f9506a = true;
        return true;
    }

    @Override // com.bytedance.retrofit2.e.a
    public f.b a(String r3, String r4, boolean r5) {
        byte[] r0 = this.f;
        if (r0 != null) goto L6;
        return null;
    L6:
        f.b r6 = f.a(r0, r0.length, r3, r4, r5);
        if (r6 != null) goto L9;
    L12:
        return r6;
    L9:
        if (r6.f9527a == null) goto L12;
        this.f9509d = this.f.length;
        this.f = r6.f9527a;
        this.f9507b = r6.f9529c;
        goto L12
    }
}
