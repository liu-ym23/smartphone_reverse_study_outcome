package Z2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import f3.C0719a;
import f3.C0720b;
import g3.C0742e;
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
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class b {

    /* renamed from: k, reason: collision with root package name */
    private static b f6636k;

    /* renamed from: l, reason: collision with root package name */
    private static final Object f6637l = new Object();

    /* renamed from: a, reason: collision with root package name */
    private byte[] f6638a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f6639b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f6640c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f6641d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f6642e;

    /* renamed from: f, reason: collision with root package name */
    private X509Certificate f6643f;

    /* renamed from: g, reason: collision with root package name */
    private C0720b f6644g;

    /* renamed from: h, reason: collision with root package name */
    private final String f6645h = "com.stepos.statsapp.v3.httpkey";

    /* renamed from: i, reason: collision with root package name */
    private long f6646i = 0;

    /* renamed from: j, reason: collision with root package name */
    private Context f6647j;

    private b(Context context) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        this.f6647j = context;
        this.f6644g = new C0720b(context, "com.stepos.statsapp.v3.httpkey");
        o();
        byte[] bArr = this.f6638a;
        if (bArr == null || bArr.length == 0) {
            g(this.f6647j);
            if (this.f6643f != null) {
                f();
                return;
            } else {
                this.f6644g.c();
                return;
            }
        }
        byte[] bArr2 = this.f6639b;
        if (bArr2 == null || bArr2.length == 0) {
            g(this.f6647j);
            if (this.f6643f != null) {
                a();
            }
        }
    }

    private void a() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f6643f.getPublicKey());
            byte[] bArrDoFinal = cipher.doFinal(this.f6638a);
            this.f6639b = bArrDoFinal;
            this.f6641d = Base64.encode(bArrDoFinal, 2);
            C0742e.c("HttpKeyMgr", "***** aKey64: " + new String(this.f6641d));
            this.f6644g.e("aKey64", new String(this.f6641d));
        } catch (InvalidKeyException e6) {
            e6.printStackTrace();
        } catch (NoSuchAlgorithmException e7) {
            e7.printStackTrace();
        } catch (BadPaddingException e8) {
            e8.printStackTrace();
        } catch (IllegalBlockSizeException e9) {
            e9.printStackTrace();
        } catch (NoSuchPaddingException e10) {
            e10.printStackTrace();
        }
    }

    public static void b(Context context) {
        if (f6636k == null) {
            synchronized (f6637l) {
                try {
                    if (f6636k == null) {
                        f6636k = new b(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void c(InputStream inputStream) throws IOException {
        C0742e.c("HttpKeyMgr", "loadAvailableCertWithoutVerify");
        try {
            Collection<? extends Certificate> collectionGenerateCertificates = CertificateFactory.getInstance("X509").generateCertificates(inputStream);
            this.f6643f = ((X509Certificate[]) collectionGenerateCertificates.toArray(new X509Certificate[collectionGenerateCertificates.size()]))[0];
            C0742e.c("HttpKeyMgr", "***** AVAILABLE CERTIFICATE:");
            C0742e.c("HttpKeyMgr", "***** --------------------");
            C0742e.c("HttpKeyMgr", "***** Subject DN: " + this.f6643f.getSubjectDN());
            C0742e.c("HttpKeyMgr", "***** Signature Algorithm: " + this.f6643f.getSigAlgName());
            C0742e.c("HttpKeyMgr", "***** Valid from: " + this.f6643f.getNotBefore());
            C0742e.c("HttpKeyMgr", "***** Valid until: " + this.f6643f.getNotAfter());
            C0742e.c("HttpKeyMgr", "***** Issuer: " + this.f6643f.getIssuerDN());
            C0742e.c("HttpKeyMgr", "***** PublicKey: " + this.f6643f.getPublicKey());
        } finally {
            C0719a.a(inputStream);
        }
    }

    private void d(String str) {
        C0742e.d("HttpKeyMgr", str);
    }

    private void f() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        k();
        a();
    }

    private void g(Context context) throws IOException {
        C0742e.c("HttpKeyMgr", "load certs from preference");
        if (this.f6643f == null) {
            try {
                C0742e.c("HttpKeyMgr", "load certs from uxipcerts.java");
                c(new ByteArrayInputStream(c.f6648a.getBytes()));
            } catch (InvalidKeyException e6) {
                d("load Certificates from asset Exception, " + e6.getMessage());
            } catch (NoSuchAlgorithmException e7) {
                d("load Certificates from asset Exception, " + e7.getMessage());
            } catch (NoSuchProviderException e8) {
                d("load Certificates from asset Exception, " + e8.getMessage());
            } catch (SignatureException e9) {
                d("load Certificates from asset Exception, " + e9.getMessage());
            } catch (CertificateException e10) {
                d("load Certificates from asset Exception, " + e10.getMessage());
            }
        }
    }

    private String j(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? BuildConfig.FLAVOR : new String(Base64.encode(bArr, 0));
    }

    private void k() {
        byte[] bytes = UUID.randomUUID().toString().substring(0, 16).getBytes();
        this.f6638a = bytes;
        this.f6640c = Base64.encode(bytes, 2);
        C0742e.c("HttpKeyMgr", "***** rKey64: " + new String(this.f6640c));
        this.f6644g.e("rKey64", new String(this.f6640c));
    }

    public static b l() {
        b bVar = f6636k;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    private void o() {
        C0742e.c("HttpKeyMgr", "loadKeys");
        String strM = this.f6644g.m("sKey64", BuildConfig.FLAVOR);
        C0742e.c("HttpKeyMgr", "saved sKey64: " + strM);
        if (!TextUtils.isEmpty(strM)) {
            this.f6642e = strM.getBytes();
        }
        String strM2 = this.f6644g.m("aKey64", BuildConfig.FLAVOR);
        C0742e.c("HttpKeyMgr", "saved aKey64: " + strM2);
        if (!TextUtils.isEmpty(strM2)) {
            byte[] bytes = strM2.getBytes();
            this.f6641d = bytes;
            this.f6639b = Base64.decode(bytes, 2);
        }
        String strM3 = this.f6644g.m("rKey64", BuildConfig.FLAVOR);
        C0742e.c("HttpKeyMgr", "saved rKey64: " + strM3);
        if (TextUtils.isEmpty(strM3)) {
            return;
        }
        byte[] bytes2 = strM3.getBytes();
        this.f6640c = bytes2;
        this.f6638a = Base64.decode(bytes2, 2);
    }

    public byte[] e(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = this.f6638a;
        if (bArr2 == null || bArr2.length == 0) {
            d("rKey null!");
            return null;
        }
        if (bArr == null || bArr.length == 0) {
            d("input null!");
            return null;
        }
        C0742e.c("HttpKeyMgr", ">>>>>>>>>> decrypt input >>>>>>>>>>\n" + j(bArr));
        C0742e.c("HttpKeyMgr", "<<<<<<<<<< decrypt input <<<<<<<<<<");
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(this.f6638a, "AES"));
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            C0742e.c("HttpKeyMgr", ">>>>>>>>>> decrypt output >>>>>>>>>>\n" + j(bArrDoFinal));
            C0742e.c("HttpKeyMgr", "<<<<<<<<<< decrypt output <<<<<<<<<<");
            return bArrDoFinal;
        } catch (InvalidKeyException e6) {
            e6.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e7) {
            e7.printStackTrace();
            return null;
        } catch (BadPaddingException e8) {
            e8.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e9) {
            e9.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public void h(String str) {
        byte[] bytes = str.getBytes();
        this.f6642e = bytes;
        this.f6644g.e("sKey64", new String(bytes));
    }

    public byte[] i(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = this.f6638a;
        if (bArr2 == null || bArr2.length == 0) {
            d("rKey null!");
            return null;
        }
        if (bArr == null || bArr.length == 0) {
            d("input null!");
            return null;
        }
        C0742e.c("HttpKeyMgr", ">>>>>>>>>> encrypt input >>>>>>>>>>\n" + j(bArr));
        C0742e.c("HttpKeyMgr", "<<<<<<<<<< encrypt input <<<<<<<<<<");
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(this.f6638a, "AES"));
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            C0742e.c("HttpKeyMgr", ">>>>>>>>>> encrypt output >>>>>>>>>>\n" + j(bArrDoFinal));
            C0742e.c("HttpKeyMgr", "<<<<<<<<<< encrypt output <<<<<<<<<<");
            return bArrDoFinal;
        } catch (InvalidKeyException e6) {
            e6.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e7) {
            e7.printStackTrace();
            return null;
        } catch (BadPaddingException e8) {
            e8.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e9) {
            e9.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public byte[] m() {
        return this.f6641d;
    }

    public byte[] n() {
        return this.f6642e;
    }

    public synchronized void p() {
        try {
            C0742e.c("HttpKeyMgr", "reInitKeys");
            if (this.f6646i == 0 || System.currentTimeMillis() - this.f6646i > 180000) {
                this.f6644g.c();
                this.f6646i = System.currentTimeMillis();
                if (this.f6643f != null) {
                    f();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
