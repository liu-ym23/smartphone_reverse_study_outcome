package a8;

import android.util.Log;
import com.google.crypto.tink.shaded.protobuf.l;
import kotlin.jvm.internal.z;
import kotlinx.serialization.json.JsonElement;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static void A(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static byte[] B(ASN1Sequence aSN1Sequence, int i8) {
        return ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i8)).getOctets();
    }

    public static int C(int i8, int i9, int i10) {
        return (Integer.hashCode(i8) + i9) * i10;
    }

    public static int D(int i8, int i9, int i10, int i11) {
        return i8 + i9 + i10 + i11;
    }

    public static final boolean a(int i8) {
        return !c2.a.a();
    }

    public static final boolean b(int i8) {
        Boolean bool;
        if (c2.a.a()) {
            try {
                bool = (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
            } catch (Exception unused) {
                c2.a.f1061a.info("Conscrypt is not available or does not support checking for FIPS build.");
                bool = Boolean.FALSE;
            }
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static int c(int i8, int i9, int i10) {
        return l.Z(i8) + i9 + i10;
    }

    public static int d(int i8, int i9, int i10, int i11) {
        return l.a0(i8) + i9 + i10 + i11;
    }

    public static int e(int i8, int i9, long j4) {
        return (Long.hashCode(j4) + i8) * i9;
    }

    public static int f(int i8, int i9, String str) {
        return (str.hashCode() + i8) * i9;
    }

    public static int g(int i8, int i9, boolean z) {
        return (Boolean.hashCode(z) + i8) * i9;
    }

    public static long h(long j4, long j8, long j9, long j10) {
        return (j4 * j8) + j9 + j10;
    }

    public static String i(int i8, int i9, String str, String str2) {
        return str + i8 + str2 + i9;
    }

    public static String j(int i8, String str) {
        return str + i8;
    }

    public static String k(int i8, String str, String str2) {
        return str + i8 + str2;
    }

    public static String l(long j4, String str) {
        return str + j4;
    }

    public static String m(Object obj, String str) {
        return str + obj;
    }

    public static String n(String str, String str2) {
        return str + str2;
    }

    public static String o(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String p(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String q(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String r(StringBuilder sb, long j4, String str) {
        sb.append(j4);
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder s(int i8, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i8);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder t(String str, int i8, String str2, int i9, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i8);
        sb.append(str2);
        sb.append(i9);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder u(String str, int i8, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(i8);
        sb.append(str4);
        return sb;
    }

    public static StringBuilder v(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static void w(Class cls, StringBuilder sb, String str, JsonElement jsonElement, String str2) {
        sb.append(z.a(cls).b());
        sb.append(str);
        sb.append(z.a(jsonElement.getClass()).b());
        sb.append(str2);
    }

    public static /* synthetic */ void x(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void y(String str, String str2, String str3) {
        Log.w(str3, str + str2);
    }

    public static void z(StringBuilder sb, int i8, String str, int i9, String str2) {
        sb.append(i8);
        sb.append(str);
        sb.append(i9);
        sb.append(str2);
    }
}
