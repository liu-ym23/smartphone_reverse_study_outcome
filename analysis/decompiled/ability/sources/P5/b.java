package P5;

import W5.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
import z2.l;

/* loaded from: classes3.dex */
public final class b {
    public static b i;

    /* renamed from: j, reason: collision with root package name */
    public static final Object f1090j = new Object();

    /* renamed from: a, reason: collision with root package name */
    public byte[] f1091a;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public byte[] e;
    public X509Certificate f;
    public final V5.a g;
    public long h = 0;

    public b(Context context) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        V5.a aVar = new V5.a(context, "com.stepos.statsapp.v3.httpkey");
        this.g = aVar;
        c.a("HttpKeyMgr", "loadKeys");
        SharedPreferences sharedPreferences = aVar.f1385a;
        String string = sharedPreferences.getString("sKey64", "");
        c.a("HttpKeyMgr", "saved sKey64: " + string);
        if (!TextUtils.isEmpty(string)) {
            this.e = string.getBytes();
        }
        String string2 = sharedPreferences.getString("aKey64", "");
        c.a("HttpKeyMgr", "saved aKey64: " + string2);
        if (!TextUtils.isEmpty(string2)) {
            byte[] bytes = string2.getBytes();
            this.d = bytes;
            this.b = Base64.decode(bytes, 2);
        }
        String string3 = sharedPreferences.getString("rKey64", "");
        c.a("HttpKeyMgr", "saved rKey64: " + string3);
        if (!TextUtils.isEmpty(string3)) {
            byte[] bytes2 = string3.getBytes();
            this.c = bytes2;
            this.f1091a = Base64.decode(bytes2, 2);
        }
        byte[] bArr = this.f1091a;
        if (bArr == null || bArr.length == 0) {
            f();
            if (this.f != null) {
                g();
                return;
            } else {
                sharedPreferences.edit().clear().commit();
                return;
            }
        }
        byte[] bArr2 = this.b;
        if (bArr2 == null || bArr2.length == 0) {
            f();
            if (this.f != null) {
                a();
            }
        }
    }

    public static void c(String str) {
        c.b("HttpKeyMgr", str);
    }

    public static String h(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : new String(Base64.encode(bArr, 0));
    }

    public static b i() {
        b bVar = i;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    public final void a() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f.getPublicKey());
            byte[] bArrDoFinal = cipher.doFinal(this.f1091a);
            this.b = bArrDoFinal;
            byte[] bArrEncode = Base64.encode(bArrDoFinal, 2);
            this.d = bArrEncode;
            c.a("HttpKeyMgr", "***** aKey64: ".concat(new String(bArrEncode)));
            this.g.a("aKey64", new String(this.d));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e6) {
            e6.printStackTrace();
        } catch (BadPaddingException e9) {
            e9.printStackTrace();
        } catch (IllegalBlockSizeException e10) {
            e10.printStackTrace();
        } catch (NoSuchPaddingException e11) {
            e11.printStackTrace();
        }
    }

    public final void b(ByteArrayInputStream byteArrayInputStream) throws IOException {
        c.a("HttpKeyMgr", "loadAvailableCertWithoutVerify");
        try {
            Collection<? extends Certificate> collectionGenerateCertificates = CertificateFactory.getInstance("X509").generateCertificates(byteArrayInputStream);
            this.f = ((X509Certificate[]) collectionGenerateCertificates.toArray(new X509Certificate[collectionGenerateCertificates.size()]))[0];
            c.a("HttpKeyMgr", "***** AVAILABLE CERTIFICATE:");
            c.a("HttpKeyMgr", "***** --------------------");
            c.a("HttpKeyMgr", "***** Subject DN: " + this.f.getSubjectDN());
            c.a("HttpKeyMgr", "***** Signature Algorithm: " + this.f.getSigAlgName());
            c.a("HttpKeyMgr", "***** Valid from: " + this.f.getNotBefore());
            c.a("HttpKeyMgr", "***** Valid until: " + this.f.getNotAfter());
            c.a("HttpKeyMgr", "***** Issuer: " + this.f.getIssuerDN());
            c.a("HttpKeyMgr", "***** PublicKey: " + this.f.getPublicKey());
        } finally {
            l.o(byteArrayInputStream);
        }
    }

    public final byte[] d(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = this.f1091a;
        if (bArr2 == null || bArr2.length == 0) {
            c("rKey null!");
            return null;
        }
        if (bArr.length == 0) {
            c("input null!");
            return null;
        }
        c.a("HttpKeyMgr", ">>>>>>>>>> decrypt input >>>>>>>>>>\n".concat(h(bArr)));
        c.a("HttpKeyMgr", "<<<<<<<<<< decrypt input <<<<<<<<<<");
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(this.f1091a, "AES"));
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            c.a("HttpKeyMgr", ">>>>>>>>>> decrypt output >>>>>>>>>>\n".concat(h(bArrDoFinal)));
            c.a("HttpKeyMgr", "<<<<<<<<<< decrypt output <<<<<<<<<<");
            return bArrDoFinal;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e6) {
            e6.printStackTrace();
            return null;
        } catch (BadPaddingException e9) {
            e9.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e10) {
            e10.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final byte[] e(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = this.f1091a;
        if (bArr2 == null || bArr2.length == 0) {
            c("rKey null!");
            return null;
        }
        if (bArr == null || bArr.length == 0) {
            c("input null!");
            return null;
        }
        c.a("HttpKeyMgr", ">>>>>>>>>> encrypt input >>>>>>>>>>\n".concat(h(bArr)));
        c.a("HttpKeyMgr", "<<<<<<<<<< encrypt input <<<<<<<<<<");
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(this.f1091a, "AES"));
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            c.a("HttpKeyMgr", ">>>>>>>>>> encrypt output >>>>>>>>>>\n".concat(h(bArrDoFinal)));
            c.a("HttpKeyMgr", "<<<<<<<<<< encrypt output <<<<<<<<<<");
            return bArrDoFinal;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e6) {
            e6.printStackTrace();
            return null;
        } catch (BadPaddingException e9) {
            e9.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e10) {
            e10.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final void f() throws IOException {
        c.a("HttpKeyMgr", "load certs from preference");
        if (this.f == null) {
            try {
                c.a("HttpKeyMgr", "load certs from uxipcerts.java");
                b(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIIGSDCCBTCgAwIBAgIMDUX09j4kqVqy1yLPMA0GCSqGSIb3DQEBCwUAMFMxCzAJ\nBgNVBAYTAkJFMRkwFwYDVQQKExBHbG9iYWxTaWduIG52LXNhMSkwJwYDVQQDEyBH\nbG9iYWxTaWduIEdDQyBSMyBEViBUTFMgQ0EgMjAyMDAeFw0yMzEwMjMwODAyMzFa\nFw0yNDExMjMwODAyMzBaMBYxFDASBgNVBAMMCyoubWVpenUuY29tMIIBIjANBgkq\nhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAraZypZBv9NB67i76opaDGtnmtlfM5Cmr\nUjfgRQGdvBsfrGlbe1M6JKVFppNXT+sqQs/9HtykMQE5XaBDNlO7rRpZ798E86Ru\nHk/27OmgoQ1U71l+g1nZkoboj4yZ08aEcVMYw0Q3bOAIDtf6TReO7o5Ugp8GF237\n/+RP2hrZ6H8JrmTbfLSUH7vSwPTDcIluxH8XJsFSY8UEY6Xa7GBtHmwQJuk+Vq0N\nlvSl0C07Hr7xY31EL2NERP/OhlEMex5wNWabMiFS7HvH01f9+N/cstD2LBd4HUE8\nkhz4n3p3Z5FORMNJl/eZHiShjU4N51ucEPaNn39rXlpWpGeNMGP8KwIDAQABo4ID\nVzCCA1MwDgYDVR0PAQH/BAQDAgWgMAwGA1UdEwEB/wQCMAAwgZMGCCsGAQUFBwEB\nBIGGMIGDMEYGCCsGAQUFBzAChjpodHRwOi8vc2VjdXJlLmdsb2JhbHNpZ24uY29t\nL2NhY2VydC9nc2djY3IzZHZ0bHNjYTIwMjAuY3J0MDkGCCsGAQUFBzABhi1odHRw\nOi8vb2NzcC5nbG9iYWxzaWduLmNvbS9nc2djY3IzZHZ0bHNjYTIwMjAwVgYDVR0g\nBE8wTTBBBgkrBgEEAaAyAQowNDAyBggrBgEFBQcCARYmaHR0cHM6Ly93d3cuZ2xv\nYmFsc2lnbi5jb20vcmVwb3NpdG9yeS8wCAYGZ4EMAQIBMEEGA1UdHwQ6MDgwNqA0\noDKGMGh0dHA6Ly9jcmwuZ2xvYmFsc2lnbi5jb20vZ3NnY2NyM2R2dGxzY2EyMDIw\nLmNybDAhBgNVHREEGjAYggsqLm1laXp1LmNvbYIJbWVpenUuY29tMB0GA1UdJQQW\nMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAfBgNVHSMEGDAWgBQNmMBzf6u9vdlHS0mt\nCkoMrD7HfDAdBgNVHQ4EFgQUGvk2gJEYD3KVUtMJ2uscjZdVYCQwggF+BgorBgEE\nAdZ5AgQCBIIBbgSCAWoBaAB2AO7N0GTV2xrOxVy3nbTNE6Iyh0Z8vOzew1FIWUZx\nH7WbAAABi1uOlykAAAQDAEcwRQIgFOhcxieK7YVYoV6RAHEYSd5LEIHT36s0t8dv\nmyLUyw8CIQCq1a7k8FNKGj0yv+DC2Q5mKywAh3oc3fBVbV46O9rlqgB3AEiw42va\npkc0D+VqAvqdMOscUgHLVt0sgdm7v6s52IRzAAABi1uOlzwAAAQDAEgwRgIhALQT\nYsSKd3Oi3lhN3vXAE4wUAb4Gklw492+9k1keIoPVAiEAiuSPVNe4Db5cPTRIY9fQ\nxAFXeiZy0omrmq029/jUzmcAdQDatr9rP7W2Ip+bwrtca+hwkXFsu1GEhTS9pD0w\nSNf7qwAAAYtbjpd6AAAEAwBGMEQCICwko0e3AW25gHhGeScb6vwEUBrVSUR4WiNa\nvUyjvFwpAiAKFQ9oL0eNw+GgCfMj+T5ryb8ymVMVpkO87/K18i25VTANBgkqhkiG\n9w0BAQsFAAOCAQEAYbVWJ93RDB/hktLQszU/I81dMYt2DEnLxkTl75E+AE5ZhGYS\nJ+MiXxRYCMOsb79Fqmm2AnytQB82453GtBB+5BceCtEx2mZ21arzWH0CBY6act1l\nMCXf3p1/vI9BzZnpB5S29sPXxN3TdYIeevcdEWfQS0yfFZw0Wr6OK7ISp5la1HWR\nd8SyfA51QKcWpTck268lyNcuiFMqHgDWJfFzotrBQtafhcvl5+DX3h6HmC7QKT/l\nX8g+EviwT4ZYOGFzCD+K3eBBjnKZF9pknsgJCrfYW8OlmFBqGO+DQNRk3oJAs8/g\nWASi3ASDXoSWHM/t58QtUxc4vAJfRAOOj2RTpg==\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\nMIIEsDCCA5igAwIBAgIQd70OB0LV2enQSdd00CpvmjANBgkqhkiG9w0BAQsFADBM\nMSAwHgYDVQQLExdHbG9iYWxTaWduIFJvb3QgQ0EgLSBSMzETMBEGA1UEChMKR2xv\nYmFsU2lnbjETMBEGA1UEAxMKR2xvYmFsU2lnbjAeFw0yMDA3MjgwMDAwMDBaFw0y\nOTAzMTgwMDAwMDBaMFMxCzAJBgNVBAYTAkJFMRkwFwYDVQQKExBHbG9iYWxTaWdu\nIG52LXNhMSkwJwYDVQQDEyBHbG9iYWxTaWduIEdDQyBSMyBEViBUTFMgQ0EgMjAy\nMDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKxnlJV/de+OpwyvCXAJ\nIcxPCqkFPh1lttW2oljS3oUqPKq8qX6m7K0OVKaKG3GXi4CJ4fHVUgZYE6HRdjqj\nhhnuHY6EBCBegcUFgPG0scB12Wi8BHm9zKjWxo3Y2bwhO8Fvr8R42pW0eINc6OTb\nQXC0VWFCMVzpcqgz6X49KMZowAMFV6XqtItcG0cMS//9dOJs4oBlpuqX9INxMTGp\n6EASAF9cnlAGy/RXkVS9nOLCCa7pCYV+WgDKLTF+OK2Vxw3RUJ/p8009lQeUARv2\nUCcNNPCifYX1xIspvarkdjzLwzOdLahDdQbJON58zN4V+lMj0msg+c0KnywPIRp3\nBMkCAwEAAaOCAYUwggGBMA4GA1UdDwEB/wQEAwIBhjAdBgNVHSUEFjAUBggrBgEF\nBQcDAQYIKwYBBQUHAwIwEgYDVR0TAQH/BAgwBgEB/wIBADAdBgNVHQ4EFgQUDZjA\nc3+rvb3ZR0tJrQpKDKw+x3wwHwYDVR0jBBgwFoAUj/BLf6guRSSuTVD6Y5qL3uLd\nG7wwewYIKwYBBQUHAQEEbzBtMC4GCCsGAQUFBzABhiJodHRwOi8vb2NzcDIuZ2xv\nYmFsc2lnbi5jb20vcm9vdHIzMDsGCCsGAQUFBzAChi9odHRwOi8vc2VjdXJlLmds\nb2JhbHNpZ24uY29tL2NhY2VydC9yb290LXIzLmNydDA2BgNVHR8ELzAtMCugKaAn\nhiVodHRwOi8vY3JsLmdsb2JhbHNpZ24uY29tL3Jvb3QtcjMuY3JsMEcGA1UdIARA\nMD4wPAYEVR0gADA0MDIGCCsGAQUFBwIBFiZodHRwczovL3d3dy5nbG9iYWxzaWdu\nLmNvbS9yZXBvc2l0b3J5LzANBgkqhkiG9w0BAQsFAAOCAQEAy8j/c550ea86oCkf\nr2W+ptTCYe6iVzvo7H0V1vUEADJOWelTv07Obf+YkEatdN1Jg09ctgSNv2h+LMTk\nKRZdAXmsE3N5ve+z1Oa9kuiu7284LjeS09zHJQB4DJJJkvtIbjL/ylMK1fbMHhAW\ni0O194TWvH3XWZGXZ6ByxTUIv1+kAIql/Mt29PmKraTT5jrzcVzQ5A9jw16yysuR\nXRrLODlkS1hyBjsfyTNZrmL1h117IFgntBA5SQNVl9ckedq5r4RSAU85jV8XK5UL\nREjRZt2I6M9Po9QL7guFLu4sPFJpwR1sPJvubS2THeo7SxYoNDtdyBHs7euaGcMa\nD/fayQ==\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\nMIIETjCCAzagAwIBAgINAe5fFp3/lzUrZGXWajANBgkqhkiG9w0BAQsFADBXMQsw\nCQYDVQQGEwJCRTEZMBcGA1UEChMQR2xvYmFsU2lnbiBudi1zYTEQMA4GA1UECxMH\nUm9vdCBDQTEbMBkGA1UEAxMSR2xvYmFsU2lnbiBSb290IENBMB4XDTE4MDkxOTAw\nMDAwMFoXDTI4MDEyODEyMDAwMFowTDEgMB4GA1UECxMXR2xvYmFsU2lnbiBSb290\nIENBIC0gUjMxEzARBgNVBAoTCkdsb2JhbFNpZ24xEzARBgNVBAMTCkdsb2JhbFNp\nZ24wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDMJXaQeQZ4Ihb1wIO2\nhMoonv0FdhHFrYhy/EYCQ8eyip0EXyTLLkvhYIJG4VKrDIFHcGzdZNHr9SyjD4I9\nDCuul9e2FIYQebs7E4B3jAjhSdJqYi8fXvqWaN+JJ5U4nwbXPsnLJlkNc96wyOkm\nDoMVxu9bi9IEYMpJpij2aTv2y8gokeWdimFXN6x0FNx04Druci8unPvQu7/1PQDh\nBjPogiuuU6Y6FnOM3UEOIDrAtKeh6bJPkC4yYOlXy7kEkmho5TgmYHWyn3f/kRTv\nriBJ/K1AFUjRAjFhGV64l++td7dkmnq/X8ET75ti+w1s4FRpFqkD2m7pg5NxdsZp\nhYIXAgMBAAGjggEiMIIBHjAOBgNVHQ8BAf8EBAMCAQYwDwYDVR0TAQH/BAUwAwEB\n/zAdBgNVHQ4EFgQUj/BLf6guRSSuTVD6Y5qL3uLdG7wwHwYDVR0jBBgwFoAUYHtm\nGkUNl8qJUC99BM00qP/8/UswPQYIKwYBBQUHAQEEMTAvMC0GCCsGAQUFBzABhiFo\ndHRwOi8vb2NzcC5nbG9iYWxzaWduLmNvbS9yb290cjEwMwYDVR0fBCwwKjAooCag\nJIYiaHR0cDovL2NybC5nbG9iYWxzaWduLmNvbS9yb290LmNybDBHBgNVHSAEQDA+\nMDwGBFUdIAAwNDAyBggrBgEFBQcCARYmaHR0cHM6Ly93d3cuZ2xvYmFsc2lnbi5j\nb20vcmVwb3NpdG9yeS8wDQYJKoZIhvcNAQELBQADggEBACNw6c/ivvVZrpRCb8RD\nM6rNPzq5ZBfyYgZLSPFAiAYXof6r0V88xjPy847dHx0+zBpgmYILrMf8fpqHKqV9\nD6ZX7qw7aoXW3r1AY/itpsiIsBL89kHfDwmXHjjqU5++BfQ+6tOfUBJ2vgmLwgtI\nfR4uUfaNU9OrH0Abio7tfftPeVZwXwzTjhuzp3ANNyuXlava4BJrHEDOxcd+7cJi\nWOx37XMiwor1hkOIreoTbv3Y/kIvuX1erRjvlJDKPSerJpSZdcfL03v3ykzTr1Eh\nkluEfSufFT90y1HonoMOFm8b50bOI7355KKL0jlrqnkckSziYSQtjipIcJDEHsXo\n4HA=\n-----END CERTIFICATE-----\n".getBytes()));
            } catch (InvalidKeyException e) {
                c("load Certificates from asset Exception, " + e.getMessage());
            } catch (NoSuchAlgorithmException e6) {
                c("load Certificates from asset Exception, " + e6.getMessage());
            } catch (NoSuchProviderException e9) {
                c("load Certificates from asset Exception, " + e9.getMessage());
            } catch (SignatureException e10) {
                c("load Certificates from asset Exception, " + e10.getMessage());
            } catch (CertificateException e11) {
                c("load Certificates from asset Exception, " + e11.getMessage());
            }
        }
    }

    public final void g() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bytes = UUID.randomUUID().toString().substring(0, 16).getBytes();
        this.f1091a = bytes;
        byte[] bArrEncode = Base64.encode(bytes, 2);
        this.c = bArrEncode;
        c.a("HttpKeyMgr", "***** rKey64: ".concat(new String(bArrEncode)));
        this.g.a("rKey64", new String(this.c));
        a();
    }

    public final synchronized void j() {
        try {
            c.a("HttpKeyMgr", "reInitKeys");
            if (this.h == 0 || System.currentTimeMillis() - this.h > 180000) {
                this.g.f1385a.edit().clear().commit();
                this.h = System.currentTimeMillis();
                if (this.f != null) {
                    g();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
