package com.bytedanceos.common.toolbox;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f10040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f10041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f10042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f10043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f10044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f10045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f10046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f10047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f10048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f10049j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f10050k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f10051l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f10052m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f10053n;

    public g(InputStream r10) {
        byte[] r11 = new byte[16];
        this.f10040a = r11;
        this.f10041b = new byte[2];
        this.f10042c = new byte[2];
        this.f10043d = new byte[4];
        this.f10044e = new byte[4];
        this.f10045f = new byte[4];
        this.f10046g = new byte[4];
        this.f10047h = new byte[4];
        this.f10048i = new byte[2];
        this.f10049j = new byte[2];
        this.f10050k = new byte[2];
        this.f10051l = new byte[2];
        this.f10052m = new byte[2];
        this.f10053n = new byte[2];
        r10.read(r11);
        r10.read(this.f10041b);
        r10.read(this.f10042c);
        r10.read(this.f10043d);
        r10.read(this.f10044e);
        r10.read(this.f10045f);
        r10.read(this.f10046g);
        r10.read(this.f10047h);
        r10.read(this.f10048i);
        r10.read(this.f10049j);
        r10.read(this.f10050k);
        r10.read(this.f10051l);
        r10.read(this.f10052m);
        r10.read(this.f10053n);
    }

    public static String a(byte[] r10) {
        String r11 = "";
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L9;
        String r13 = Integer.toHexString(r10[r12] & UnsignedBytes.MAX_VALUE);
        if (r13.length() != 1) goto L8;
        r13 = '0' + r13;
    L8:
        r11 = r11 + r13.toUpperCase() + " ";
        r12 = r12 + 1;
        goto L4
    L9:
        return r11;
    }

    public String toString() {
        return "magic : " + a(this.f10040a) + "\ne_type : " + a(this.f10041b) + "\ne_machine : " + a(this.f10042c) + "\ne_version : " + a(this.f10043d) + "\ne_entry : " + a(this.f10044e) + "\ne_phoff : " + a(this.f10045f) + "\ne_shoff : " + a(this.f10046g) + "\ne_flags : " + a(this.f10047h) + "\ne_ehsize : " + a(this.f10048i) + "\ne_phentsize : " + a(this.f10049j) + "\ne_phnum : " + a(this.f10050k) + "\ne_shentsize : " + a(this.f10051l) + "\ne_shnum : " + a(this.f10052m) + "\ne_shstrndx : " + a(this.f10053n);
    }
}
