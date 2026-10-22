package com.baidu.b.c.d;

import B0.g;
import androidx.room.AbstractC0351g;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f4849a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private int f4850b;

    /* renamed from: d, reason: collision with root package name */
    private f f4852d;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f4854f;

    /* renamed from: g, reason: collision with root package name */
    private int f4855g;

    /* renamed from: h, reason: collision with root package name */
    private int f4856h;

    /* renamed from: i, reason: collision with root package name */
    private d f4857i;

    /* renamed from: e, reason: collision with root package name */
    private OAEPParameterSpec f4853e = null;

    /* renamed from: j, reason: collision with root package name */
    private String f4858j = "SHA-1";

    /* renamed from: c, reason: collision with root package name */
    private String f4851c = "PKCS1Padding";

    private void b(byte[] bArr, int i4, int i5) {
        int length;
        if (i5 == 0 || bArr == null) {
            return;
        }
        int i6 = this.f4855g;
        int i7 = i6 + i5;
        byte[] bArr2 = this.f4854f;
        if (i7 > bArr2.length) {
            length = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i4, bArr2, i6, i5);
            length = this.f4855g + i5;
        }
        this.f4855g = length;
    }

    public void a(int i4, d dVar, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            a(i4, dVar, secureRandom, null);
        } catch (InvalidAlgorithmParameterException e4) {
            InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
            invalidKeyException.initCause(e4);
            throw invalidKeyException;
        }
    }

    private void a(int i4, d dVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        boolean z4;
        OAEPParameterSpec oAEPParameterSpec;
        if (i4 == 1) {
            z4 = true;
        } else {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        throw new InvalidKeyException(AbstractC0351g.m("Unknown mode: ", i4));
                    }
                }
                z4 = true;
            }
            z4 = false;
        }
        if (!(dVar instanceof d)) {
            throw new InvalidKeyException("only support helios key");
        }
        this.f4850b = z4 ? 1 : 4;
        this.f4857i = dVar;
        int iA = b.a(dVar.a());
        this.f4856h = iA;
        this.f4855g = 0;
        String str = this.f4851c;
        if (str == "NoPadding") {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            this.f4852d = f.a(3, iA, secureRandom);
            this.f4854f = new byte[iA];
            return;
        }
        if (str == "PKCS1Padding") {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            f fVarA = f.a(this.f4850b > 2 ? 1 : 2, iA, secureRandom);
            this.f4852d = fVarA;
            if (z4) {
                this.f4854f = new byte[fVarA.a()];
                return;
            } else {
                this.f4854f = new byte[iA];
                return;
            }
        }
        int i5 = this.f4850b;
        if (i5 == 3 || i5 == 4) {
            throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
        }
        if (algorithmParameterSpec == null) {
            oAEPParameterSpec = new OAEPParameterSpec(this.f4858j, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
        } else {
            if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
            }
            oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
        }
        f fVarA2 = f.a(4, iA, secureRandom, oAEPParameterSpec);
        this.f4852d = fVarA2;
        if (z4) {
            this.f4854f = new byte[fVarA2.a()];
        } else {
            this.f4854f = new byte[iA];
        }
    }

    public void a(String str) throws NoSuchPaddingException {
        String str2 = "NoPadding";
        if (!str.equalsIgnoreCase("NoPadding")) {
            str2 = "PKCS1Padding";
            if (!str.equalsIgnoreCase("PKCS1Padding")) {
                String lowerCase = str.toLowerCase(Locale.ENGLISH);
                if (lowerCase.equals("oaeppadding")) {
                    this.f4851c = "OAEP";
                    return;
                } else {
                    if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                        throw new NoSuchPaddingException(g.n("Padding ", str, " not supported"));
                    }
                    this.f4851c = "OAEP";
                    this.f4858j = str.substring(8, str.length() - 14);
                    throw new NoSuchPaddingException("MessageDigest not available for ".concat(str));
                }
            }
        }
        this.f4851c = str2;
    }

    private byte[] a() throws BadPaddingException, IllegalBlockSizeException {
        int i4 = this.f4855g;
        byte[] bArr = this.f4854f;
        if (i4 > bArr.length) {
            throw new IllegalBlockSizeException(AbstractC0831a.d(new StringBuilder("Data must not be longer than "), this.f4854f.length, " bytes"));
        }
        try {
            int i5 = this.f4850b;
            if (i5 == 1) {
                return b.a(this.f4852d.a(bArr, 0, i4), this.f4857i);
            }
            if (i5 == 2) {
                throw new UnsupportedOperationException("only verify supported");
            }
            if (i5 == 3) {
                throw new UnsupportedOperationException("only verify supported");
            }
            if (i5 != 4) {
                throw new AssertionError("Internal error");
            }
            return this.f4852d.b(b.a(b.a(bArr, 0, i4), this.f4857i));
        } finally {
            this.f4855g = 0;
        }
    }

    public byte[] a(byte[] bArr, int i4, int i5) throws BadPaddingException, IllegalBlockSizeException {
        b(bArr, i4, i5);
        return a();
    }
}
