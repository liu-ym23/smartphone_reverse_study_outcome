package com.bm.badgervi;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.m.u.i;
import com.bytedance.badger.network.e0;
import com.bytedance.badger.network.f0;
import com.bytedance.badger.network.g0;
import com.bytedance.badger.network.l0;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import me.ele.lancet.base.annotations.Skip;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.json.JSONObject;
import v64.c;

/* JADX INFO: loaded from: classes39.dex */
public final class b {
    public static String c(String r100) {
        if (r100.isEmpty() == false) goto L6;
        return "";
    L6:
        String[] r101 = r100.split("-");
        StringBuilder r102 = new StringBuilder(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L10;
        r102.append((char) (((CastIntegerProtector.parseInt(r101[r104], 16) - 3) ^ 90) & 255));
        r104 = r104 + 1;
        goto L7
    L10:
        return r102.toString();
    }

    public static ASN1Sequence d(ASN1InputStream r100) {
        ASN1Primitive r101 = r100.readObject();
        if ((r101 instanceof ASN1OctetString) == false) goto L21;
        ASN1InputStream r102 = new ASN1InputStream(((ASN1OctetString) r101).getOctets());
        ASN1Primitive r103 = r102.readObject();     // Catch: Throwable -> L12
        if ((r103 instanceof ASN1Sequence) == false) goto L11;
        ASN1Sequence r104 = (ASN1Sequence) r103;     // Catch: Throwable -> L12
        r102.close();
        return r104;
    L11:
        throw new CertificateParsingException("Expected sequence, found ".concat(r103.getClass().getName()));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L21:
        throw new CertificateParsingException("Expected octet stream, found ".concat(r101.getClass().getName()));
    }

    public static JSONObject e(X509Certificate r100) {
        byte[] r101 = r100.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        if (r101 == null) goto L22;
        if (r101.length == 0) goto L22;
        byte r102 = "{".getBytes()[0];
        byte r103 = i.f25855d.getBytes()[0];
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r104 >= r101.length) goto L15;
        byte r107 = r101[r104];
        if (r107 != r102) goto L12;
        r105 = r104;
    L14:
        r104 = r104 + 1;
        goto L8
    L12:
        if (r107 != r103) goto L14;
        r106 = r104;
        goto L14
    L15:
        if (r105 <= 0) goto L19;
        if (r105 >= r106) goto L27;
        byte r108 = r101[r105 - 1];
        int r109 = (r106 - r105) + 1;
        byte[] r110 = new byte[r109];
        System.arraycopy(r101, r105, r110, 0, r109);
        return new JSONObject(new String(r110));
    L27:
        return null;
    L19:
        return null;
    L22:
        throw new Exception("Couldn't find the keystore attestation extension data.");
    }

    public static final JSONObject f(Pair... r100) {
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Pair r104 = r100[r103];
        r101.put((String) r104.component1(), r104.component2());
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.android.id.impl.IdProviderImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.android.id.impl.IdProviderImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.android.id.impl.IdProviderImpl");
    }

    public static final int b(l0 r100) {
        if ((r100 instanceof f0) == false) goto L6;
        return 0;
    L6:
        if ((r100 instanceof g0) == false) goto L9;
        return ((g0) r100).f199105b;
    L9:
        if ((r100 instanceof e0) == false) goto L13;
        e0 r101 = (e0) r100;
        int r102 = r101.f199097b;
        return r101.f199098c + r102;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static c g(Context r110) {
        c r100 = new c();
        if (r110 != null) goto L5;
        return r100;
    L5:
        long r101 = SystemClock.elapsedRealtime();
        boolean r102 = true;
        Class r103 = a();     // Catch: Exception -> L15
    L13:
        e = e;
    L17:
        String r104 = "error:" + e;
    L35:
        if (r103 == null) goto L28;
        Object r111 = r103.getMethod("checkSelfOAIDPermission", new Class[]{Context.class}).invoke(null, new Object[]{r110});     // Catch: Exception -> L29
        if (r111 != null) goto L23;
    L31:
        r100.f553400d = SystemClock.elapsedRealtime() - r101;
        r100.f553401e = "reflect";
        r100.f553399c = r104;
        return r100;
    L23:
        if (((Integer) r111).intValue() == (-1)) goto L26;
        r102 = false;
    L26:
        r100.f553398b = r102;     // Catch: Exception -> L29
        goto L31
    L28:
        throw new RuntimeException("class is null");     // Catch: Exception -> L29
    L29:
        e = move-exception;
        r104 = r104 + "," + e;
        goto L31
    L9:
        Object r105 = r103.getMethod("getOUID", new Class[]{Context.class}).invoke(r103.newInstance(), new Object[]{r110});     // Catch: Exception -> L13
        if (r105 == null) goto L12;
        r100.f553397a = (String) r105;     // Catch: Exception -> L13
    L12:
        r104 = "";
    L15:
        e = e;
        r103 = null;
        goto L17
    }

    public static byte[] h(X509Certificate r100) {
        byte[] r101 = r100.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        if (r101 == null) goto L29;
        if (r101.length == 0) goto L29;
        ASN1InputStream r102 = new ASN1InputStream(r101);     // Catch: IOException -> L25
        ASN1Sequence r103 = d(r102);     // Catch: Throwable -> L17
        r102.close();     // Catch: IOException -> L25
        ASN1Encodable r104 = r103.getObjectAt(4);
        if (r104 == null) goto L16;
        if ((r104 instanceof DEROctetString) == false) goto L16;
        return ((ASN1OctetString) r104).getOctets();
    L16:
        throw new CertificateParsingException("Expected DEROctetString");
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: IOException -> L25
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L25
    L25:
        e = move-exception;
        throw new CertificateParsingException("Failed to parse SEQUENCE", e);
    L29:
        throw new CertificateParsingException("Did not find extension with OID 1.3.6.1.4.1.11129.2.1.17");
    }
}
