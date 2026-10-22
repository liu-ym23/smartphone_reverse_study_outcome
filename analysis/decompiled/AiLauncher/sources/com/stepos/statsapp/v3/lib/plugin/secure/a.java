package com.stepos.statsapp.v3.lib.plugin.secure;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.stepos.statsapp.v3.utils.CommonUtils;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: k, reason: collision with root package name */
    private static final String f30924k = "HttpKeyMgr";

    /* renamed from: l, reason: collision with root package name */
    private static a f30925l;

    /* renamed from: m, reason: collision with root package name */
    private static final Object f30926m = new Object();

    /* renamed from: a, reason: collision with root package name */
    private byte[] f30927a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f30928b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f30929c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f30930d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f30931e;

    /* renamed from: f, reason: collision with root package name */
    private X509Certificate f30932f;

    /* renamed from: g, reason: collision with root package name */
    private SharedPreferencesHelper f30933g;

    /* renamed from: h, reason: collision with root package name */
    private final String f30934h = "com.stepos.statsapp.v3.httpkey";

    /* renamed from: i, reason: collision with root package name */
    private long f30935i = 0;

    /* renamed from: j, reason: collision with root package name */
    private Context f30936j;

    private a(Context context) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        this.f30936j = context;
        this.f30933g = new SharedPreferencesHelper(context, "com.stepos.statsapp.v3.httpkey");
        g();
        byte[] bArr = this.f30927a;
        if (bArr == null || bArr.length == 0) {
            b(this.f30936j);
            if (this.f30932f != null) {
                b();
                return;
            } else {
                this.f30933g.commitClear();
                return;
            }
        }
        byte[] bArr2 = this.f30928b;
        if (bArr2 == null || bArr2.length == 0) {
            b(this.f30936j);
            if (this.f30932f != null) {
                a();
            }
        }
    }

    public static void a(Context context) {
        if (f30925l == null) {
            synchronized (f30926m) {
                try {
                    if (f30925l == null) {
                        f30925l = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void b(Context context) throws IOException {
        Logger.d(f30924k, "load certs from preference");
        if (this.f30932f == null) {
            try {
                Logger.d(f30924k, "load certs from uxipcerts.java");
                a(new ByteArrayInputStream(b.f30937a.getBytes()));
            } catch (InvalidKeyException e10) {
                a("load Certificates from asset Exception, " + e10.getMessage());
            } catch (NoSuchAlgorithmException e11) {
                a("load Certificates from asset Exception, " + e11.getMessage());
            } catch (NoSuchProviderException e12) {
                a("load Certificates from asset Exception, " + e12.getMessage());
            } catch (SignatureException e13) {
                a("load Certificates from asset Exception, " + e13.getMessage());
            } catch (CertificateException e14) {
                a("load Certificates from asset Exception, " + e14.getMessage());
            }
        }
    }

    private void c() {
        byte[] bytes = UUID.randomUUID().toString().substring(0, 16).getBytes();
        this.f30927a = bytes;
        this.f30929c = Base64.encode(bytes, 2);
        Logger.d(f30924k, "***** rKey64: " + new String(this.f30929c));
        this.f30933g.commitConfig("rKey64", new String(this.f30929c));
    }

    public static a d() {
        a aVar = f30925l;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    private void g() {
        Logger.d(f30924k, "loadKeys");
        String config = this.f30933g.getConfig("sKey64", "");
        Logger.d(f30924k, "saved sKey64: " + config);
        if (!TextUtils.isEmpty(config)) {
            this.f30931e = config.getBytes();
        }
        String config2 = this.f30933g.getConfig("aKey64", "");
        Logger.d(f30924k, "saved aKey64: " + config2);
        if (!TextUtils.isEmpty(config2)) {
            byte[] bytes = config2.getBytes();
            this.f30930d = bytes;
            this.f30928b = Base64.decode(bytes, 2);
        }
        String config3 = this.f30933g.getConfig("rKey64", "");
        Logger.d(f30924k, "saved rKey64: " + config3);
        if (TextUtils.isEmpty(config3)) {
            return;
        }
        byte[] bytes2 = config3.getBytes();
        this.f30929c = bytes2;
        this.f30927a = Base64.decode(bytes2, 2);
    }

    public byte[] e() {
        return this.f30930d;
    }

    public byte[] f() {
        return this.f30931e;
    }

    public synchronized void h() {
        try {
            Logger.d(f30924k, "reInitKeys");
            if (this.f30935i == 0 || System.currentTimeMillis() - this.f30935i > 180000) {
                this.f30933g.commitClear();
                this.f30935i = System.currentTimeMillis();
                if (this.f30932f != null) {
                    b();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private String c(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            return new String(Base64.encode(bArr, 0));
        }
        return "";
    }

    private void a(InputStream inputStream) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CertificateException, NoSuchProviderException {
        Logger.d(f30924k, "loadAvailableCertWithoutVerify");
        try {
            Collection<? extends Certificate> collectionGenerateCertificates = CertificateFactory.getInstance("X509").generateCertificates(inputStream);
            this.f30932f = ((X509Certificate[]) collectionGenerateCertificates.toArray(new X509Certificate[collectionGenerateCertificates.size()]))[0];
            Logger.d(f30924k, "***** AVAILABLE CERTIFICATE:");
            Logger.d(f30924k, "***** --------------------");
            Logger.d(f30924k, "***** Subject DN: " + this.f30932f.getSubjectDN());
            Logger.d(f30924k, "***** Signature Algorithm: " + this.f30932f.getSigAlgName());
            Logger.d(f30924k, "***** Valid from: " + this.f30932f.getNotBefore());
            Logger.d(f30924k, "***** Valid until: " + this.f30932f.getNotAfter());
            Logger.d(f30924k, "***** Issuer: " + this.f30932f.getIssuerDN());
            Logger.d(f30924k, "***** PublicKey: " + this.f30932f.getPublicKey());
        } finally {
            CommonUtils.closeQuietly(inputStream);
        }
    }

    private void b() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        c();
        a();
    }

    public byte[] b(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = this.f30927a;
        if (bArr2 != null && bArr2.length != 0) {
            if (bArr != null && bArr.length != 0) {
                Logger.d(f30924k, ">>>>>>>>>> encrypt input >>>>>>>>>>\n" + c(bArr));
                Logger.d(f30924k, "<<<<<<<<<< encrypt input <<<<<<<<<<");
                try {
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(1, new SecretKeySpec(this.f30927a, "AES"));
                    byte[] bArrDoFinal = cipher.doFinal(bArr);
                    Logger.d(f30924k, ">>>>>>>>>> encrypt output >>>>>>>>>>\n" + c(bArrDoFinal));
                    Logger.d(f30924k, "<<<<<<<<<< encrypt output <<<<<<<<<<");
                    return bArrDoFinal;
                } catch (InvalidKeyException e10) {
                    e10.printStackTrace();
                    return null;
                } catch (NoSuchAlgorithmException e11) {
                    e11.printStackTrace();
                    return null;
                } catch (BadPaddingException e12) {
                    e12.printStackTrace();
                    return null;
                } catch (IllegalBlockSizeException e13) {
                    e13.printStackTrace();
                    return null;
                } catch (NoSuchPaddingException e14) {
                    e14.printStackTrace();
                    return null;
                }
            }
            a("input null!");
            return null;
        }
        a("rKey null!");
        return null;
    }

    private void a() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f30932f.getPublicKey());
            byte[] bArrDoFinal = cipher.doFinal(this.f30927a);
            this.f30928b = bArrDoFinal;
            this.f30930d = Base64.encode(bArrDoFinal, 2);
            Logger.d(f30924k, "***** aKey64: " + new String(this.f30930d));
            this.f30933g.commitConfig("aKey64", new String(this.f30930d));
        } catch (InvalidKeyException e10) {
            e10.printStackTrace();
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
        } catch (BadPaddingException e12) {
            e12.printStackTrace();
        } catch (IllegalBlockSizeException e13) {
            e13.printStackTrace();
        } catch (NoSuchPaddingException e14) {
            e14.printStackTrace();
        }
    }

    public void b(String str) {
        byte[] bytes = str.getBytes();
        this.f30931e = bytes;
        this.f30933g.commitConfig("sKey64", new String(bytes));
    }

    public byte[] a(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = this.f30927a;
        if (bArr2 != null && bArr2.length != 0) {
            if (bArr != null && bArr.length != 0) {
                Logger.d(f30924k, ">>>>>>>>>> decrypt input >>>>>>>>>>\n" + c(bArr));
                Logger.d(f30924k, "<<<<<<<<<< decrypt input <<<<<<<<<<");
                try {
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(2, new SecretKeySpec(this.f30927a, "AES"));
                    byte[] bArrDoFinal = cipher.doFinal(bArr);
                    Logger.d(f30924k, ">>>>>>>>>> decrypt output >>>>>>>>>>\n" + c(bArrDoFinal));
                    Logger.d(f30924k, "<<<<<<<<<< decrypt output <<<<<<<<<<");
                    return bArrDoFinal;
                } catch (InvalidKeyException e10) {
                    e10.printStackTrace();
                    return null;
                } catch (NoSuchAlgorithmException e11) {
                    e11.printStackTrace();
                    return null;
                } catch (BadPaddingException e12) {
                    e12.printStackTrace();
                    return null;
                } catch (IllegalBlockSizeException e13) {
                    e13.printStackTrace();
                    return null;
                } catch (NoSuchPaddingException e14) {
                    e14.printStackTrace();
                    return null;
                }
            }
            a("input null!");
            return null;
        }
        a("rKey null!");
        return null;
    }

    private void a(String str) {
        Logger.e(f30924k, str);
    }
}
