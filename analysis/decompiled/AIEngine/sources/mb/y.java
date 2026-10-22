package mb;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.aiengine.R;
import com.tonyodev.fetch2.Error;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import kotlin.collections.builders.SetBuilder;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.JsonEncodingException;
import okio.SegmentedByteString;
import ua.b;
import v0.i0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class y implements i0 {
    public static final Bundle A(Bundle bundle, String key) {
        kotlin.jvm.internal.g.f(key, "key");
        Bundle bundle2 = bundle.getBundle(key);
        if (bundle2 != null) {
            return bundle2;
        }
        throw new IllegalArgumentException(a0.a.k("No valid saved state was found for the key '", key, "'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly."));
    }

    public static final int B(p.b bVar, Object obj, int i10) {
        int i11 = bVar.f11354c;
        if (i11 == 0) {
            return -1;
        }
        try {
            int iA = q.a.a(i11, i10, bVar.f11352a);
            if (iA < 0 || kotlin.jvm.internal.g.b(obj, bVar.f11353b[iA])) {
                return iA;
            }
            int i12 = iA + 1;
            while (i12 < i11 && bVar.f11352a[i12] == i10) {
                if (kotlin.jvm.internal.g.b(obj, bVar.f11353b[i12])) {
                    return i12;
                }
                i12++;
            }
            for (int i13 = iA - 1; i13 >= 0 && bVar.f11352a[i13] == i10; i13--) {
                if (kotlin.jvm.internal.g.b(obj, bVar.f11353b[i13])) {
                    return i13;
                }
            }
            return ~i12;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int C(int i10, int i11) {
        return (i10 >> i11) & 31;
    }

    public static final void D(vc.m mVar, String str) {
        mVar.m(mVar.f13515a - 1, "Trailing comma before the end of JSON ".concat(str), "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static /* synthetic */ void E(vc.m mVar) {
        D(mVar, "object");
        throw null;
    }

    public static final CharSequence F(CharSequence charSequence, int i10) {
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            if (i10 != -1) {
                int i11 = i10 - 30;
                int i12 = i10 + 30;
                String str = i11 <= 0 ? "" : ".....";
                String str2 = i12 >= charSequence.length() ? "" : ".....";
                StringBuilder sbB = v1.d.b(str);
                if (i11 < 0) {
                    i11 = 0;
                }
                int length = charSequence.length();
                if (i12 > length) {
                    i12 = length;
                }
                sbB.append(charSequence.subSequence(i11, i12).toString());
                sbB.append(str2);
                return sbB.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static byte[] G(InputStream inputStream, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int i12 = inputStream.read(bArr, i11, i10 - i11);
            if (i12 < 0) {
                throw new IllegalStateException(ai.onnxruntime.providers.a.a(i10, "Not enough bytes to read: "));
            }
            i11 += i12;
        }
        return bArr;
    }

    public static byte[] H(FileInputStream fileInputStream, int i10, int i11) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i11];
            byte[] bArr2 = new byte[2048];
            int i12 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i12 < i10) {
                int i13 = fileInputStream.read(bArr2);
                if (i13 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i10 + " bytes");
                }
                inflater.setInput(bArr2, 0, i13);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i11 - iInflate);
                    i12 += i13;
                } catch (DataFormatException e10) {
                    throw new IllegalStateException(e10.getMessage());
                }
            }
            if (i12 == i10) {
                if (inflater.finished()) {
                    return bArr;
                }
                throw new IllegalStateException("Inflater did not finish");
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i10 + " actual=" + i12);
        } finally {
            inflater.end();
        }
    }

    public static long I(InputStream inputStream, int i10) throws IOException {
        byte[] bArrG = G(inputStream, i10);
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 += (bArrG[i11] & 255) << (i11 * 8);
        }
        return j10;
    }

    public static final void J(Object[] objArr, int i10, int i11) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        while (i10 < i11) {
            objArr[i10] = null;
            i10++;
        }
    }

    public static final int K(SegmentedByteString segmentedByteString, int i10) {
        int i11;
        int[] iArr = segmentedByteString.h;
        int i12 = i10 + 1;
        int length = segmentedByteString.f11316e.length;
        kotlin.jvm.internal.g.f(iArr, "<this>");
        int i13 = length - 1;
        int i14 = 0;
        while (true) {
            if (i14 <= i13) {
                i11 = (i14 + i13) >>> 1;
                int i15 = iArr[i11];
                if (i15 >= i12) {
                    if (i15 <= i12) {
                        break;
                    }
                    i13 = i11 - 1;
                } else {
                    i14 = i11 + 1;
                }
            } else {
                i11 = (-i14) - 1;
                break;
            }
        }
        return i11 >= 0 ? i11 : ~i11;
    }

    public static final void L(View view, w1.d dVar) {
        kotlin.jvm.internal.g.f(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, dVar);
    }

    public static Set M(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        kotlin.jvm.internal.g.e(setSingleton, "singleton(...)");
        return setSingleton;
    }

    public static pb.a N(String str, zb.a aVar, int i10) {
        boolean z = (i10 & 1) != 0;
        boolean z3 = (i10 & 2) == 0;
        pb.a aVar2 = new pb.a(aVar);
        if (z3) {
            aVar2.setDaemon(true);
        }
        aVar2.setName(str);
        if (z) {
            aVar2.start();
        }
        return aVar2;
    }

    public static final void O(vc.m mVar, Number number) {
        vc.m.n(mVar, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, 2);
        throw null;
    }

    public static final void P(int i10, int i11, rc.e descriptor) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i12 = (~i10) & i11;
        for (int i13 = 0; i13 < 32; i13++) {
            if ((i12 & 1) != 0) {
                arrayList.add(descriptor.f(i13));
            }
            i12 >>>= 1;
        }
        String serialName = descriptor.i();
        kotlin.jvm.internal.g.f(serialName, "serialName");
        throw new MissingFieldException(arrayList, arrayList.size() == 1 ? com.stepos.core.ota.d.j(new StringBuilder("Field '"), (String) arrayList.get(0), "' is required for type with serial name '", serialName, "', but it was missing") : "Fields " + arrayList + " are required for type with serial name '" + serialName + "', but they were missing", null);
    }

    public static final String Q(byte b10) {
        return b10 == 1 ? "quotation mark '\"'" : b10 == 2 ? "string escape sequence '\\'" : b10 == 4 ? "comma ','" : b10 == 5 ? "colon ':'" : b10 == 6 ? "start of the object '{'" : b10 == 7 ? "end of the object '}'" : b10 == 8 ? "start of the array '['" : b10 == 9 ? "end of the array ']'" : b10 == 10 ? "end of the input" : b10 == 127 ? "invalid token" : "valid token";
    }

    public static void R(ByteArrayOutputStream byteArrayOutputStream, long j10, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) ((j10 >> (i11 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void S(ByteArrayOutputStream byteArrayOutputStream, int i10) throws IOException {
        R(byteArrayOutputStream, i10, 2);
    }

    public static final JsonEncodingException a(Number number, String output) {
        kotlin.jvm.internal.g.f(output, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) F(output, -1)));
    }

    public static final JsonDecodingException b(int i10, CharSequence input, String message) {
        kotlin.jvm.internal.g.f(message, "message");
        kotlin.jvm.internal.g.f(input, "input");
        String message2 = message + "\nJSON input: " + ((Object) F(input, i10));
        kotlin.jvm.internal.g.f(message2, "message");
        if (i10 >= 0) {
            message2 = a0.a.g("Unexpected JSON token at offset ", i10, ": ", message2);
        }
        kotlin.jvm.internal.g.f(message2, "message");
        return new JsonDecodingException(message2);
    }

    public static final Object[] f(Object[] objArr, int i10, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        b1.t(objArr, objArr2, 0, i10, 6);
        b1.q(objArr, objArr2, i10 + 2, i10, objArr.length);
        objArr2[i10] = obj;
        objArr2[i10 + 1] = obj2;
        return objArr2;
    }

    public static final Object[] g(Object[] objArr, int i10) {
        Object[] objArr2 = new Object[objArr.length - 2];
        b1.t(objArr, objArr2, 0, i10, 6);
        b1.q(objArr, objArr2, i10, i10 + 2, objArr.length);
        return objArr2;
    }

    public static final Object[] h(Object[] objArr, int i10) {
        Object[] objArr2 = new Object[objArr.length - 1];
        b1.t(objArr, objArr2, 0, i10, 6);
        b1.q(objArr, objArr2, i10, i10 + 1, objArr.length);
        return objArr2;
    }

    public static final String i(Object[] objArr, int i10, int i11, f fVar) {
        StringBuilder sb2 = new StringBuilder((i11 * 3) + 2);
        sb2.append("[");
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            Object obj = objArr[i10 + i12];
            if (obj == fVar) {
                sb2.append("(this Collection)");
            } else {
                sb2.append(obj);
            }
        }
        sb2.append("]");
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public static SetBuilder j(SetBuilder setBuilder) {
        setBuilder.f10050a.b();
        return setBuilder.size() > 0 ? setBuilder : SetBuilder.f10049b;
    }

    public static final byte k(char c9) {
        if (c9 < '~') {
            return vc.c.f13495b[c9];
        }
        return (byte) 0;
    }

    public static void l(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void m(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void n(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static float o(float f8, float f9, float f10) {
        return f8 < f9 ? f9 : f8 > f10 ? f10 : f8;
    }

    public static int p(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    public static final void q(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                jd.b.c(th, th2);
            }
        }
    }

    public static byte[] r(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static String s(String str, vd.a aVar, Map map, Map map2) {
        String string;
        if (s3.a.a(str)) {
            return str;
        }
        List<String> listA = ((g4.a) aVar.f13522a).a(str);
        List list = t3.a.f12936a;
        if (listA == null || listA.isEmpty()) {
            return str;
        }
        a4.a aVar2 = (a4.a) aVar.f13524c;
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : listA) {
            aVar2.getClass();
            List list2 = (List) map.get(str2);
            if (list2 == null || list2.isEmpty()) {
                char[] charArray = str2.toCharArray();
                StringBuilder sb3 = new StringBuilder();
                for (char c9 : charArray) {
                    String string2 = Character.toString(c9);
                    List list3 = (List) map2.get(string2);
                    String str3 = !(list3 == null || list3.isEmpty()) ? (String) list3.get(0) : string2;
                    if (str3.length() == 1) {
                        sb3.append(str3);
                    } else {
                        sb3.append(string2);
                    }
                }
                string = sb3.toString();
            } else {
                string = (String) list2.get(0);
            }
            sb2.append(string);
        }
        return sb2.toString();
    }

    public static final q2.k t(q2.p pVar) {
        kotlin.jvm.internal.g.f(pVar, "<this>");
        return new q2.k(pVar.f11505a, pVar.f11522t);
    }

    public static String u(String str) {
        try {
            b.a.f13191a.getClass();
            Class clsA = ua.b.a("android.os.SystemProperties");
            return (String) ua.b.b(clsA, String.class).invoke(clsA, str);
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String v(String str, String str2) {
        try {
            b.a.f13191a.getClass();
            Class clsA = ua.b.a("android.os.SystemProperties");
            return (String) ua.b.b(clsA, String.class, String.class).invoke(clsA, str, str2);
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static Account w(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.stepos.account");
        Log.e("[Cloud]Account.SDK", "getAccount length: " + accountsByType.length);
        if (accountsByType.length <= 0) {
            return null;
        }
        if (accountsByType.length != 1) {
            Log.e("[Cloud]Account.SDK", "more than 1 stepos account : " + accountsByType.length);
        }
        return accountsByType[0];
    }

    public static final Error x(String str) {
        return (str == null || str.length() == 0) ? Error.f8154c : (str.equalsIgnoreCase("request_with_file_path_already_exist") || gc.q.l0(str, "UNIQUE constraint failed: requests._file (code 2067)", true)) ? Error.f8166t : gc.q.l0(str, "UNIQUE constraint failed: requests._id", false) ? Error.f8165s : gc.q.l0(str, "empty_response_body", true) ? Error.f8162o : (str.equalsIgnoreCase("FNC") || str.equalsIgnoreCase("open failed: ENOENT (No such file or directory)")) ? Error.f8156e : (gc.q.l0(str, "recvfrom failed: ETIMEDOUT (Connection timed out)", true) || gc.q.l0(str, "timeout", true) || gc.q.l0(str, "Software caused connection abort", true) || gc.q.l0(str, "Read timed out at", true)) ? Error.h : (str.equalsIgnoreCase("java.io.IOException: 404") || gc.q.l0(str, "No address associated with hostname", false)) ? Error.f8158k : gc.q.l0(str, "Unable to resolve host", false) ? Error.f8157j : str.equalsIgnoreCase("open failed: EACCES (Permission denied)") ? Error.f8159l : (str.equalsIgnoreCase("write failed: ENOSPC (No space left on device)") || str.equalsIgnoreCase("database or disk is full (code 13)")) ? Error.f8160m : str.equalsIgnoreCase("UNIQUE constraint failed: requests._id (code 1555)") ? Error.f8163p : str.equalsIgnoreCase("fetch download not found") ? Error.f8164q : str.equalsIgnoreCase("Fetch data base error") ? Error.r : (gc.q.l0(str, "request_not_successful", true) || gc.q.l0(str, "Failed to connect", true)) ? Error.f8167u : gc.q.l0(str, "invalid content hash", true) ? Error.f8171y : gc.q.l0(str, "download_incomplete", true) ? Error.f8168v : gc.q.l0(str, "failed_to_update_request", true) ? Error.z : gc.q.l0(str, "failed_to_add_completed_download", true) ? Error.A : gc.q.l0(str, "fetch_file_server_invalid_response_type", true) ? Error.B : gc.q.l0(str, "request_does_not_exist", true) ? Error.C : gc.q.l0(str, "no_network_connection", true) ? Error.f8161n : gc.q.l0(str, "file_not_found", true) ? Error.f8169w : gc.q.l0(str, "fetch_file_server_url_invalid", true) ? Error.f8170x : gc.q.l0(str, "request_list_not_distinct", true) ? Error.F : gc.q.l0(str, "enqueue_not_successful", true) ? Error.D : gc.q.l0(str, "cannot rename file associated with incomplete download", true) ? Error.G : gc.q.l0(str, "file_cannot_be_renamed", true) ? Error.H : gc.q.l0(str, "file_allocation_error", true) ? Error.I : gc.q.l0(str, "Cleartext HTTP traffic to", true) ? Error.J : Error.f8154c;
    }

    public static final Error y(Exception exc) {
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        boolean z = exc instanceof SocketTimeoutException;
        if (z && message.length() == 0) {
            message = "timeout";
        }
        Error errorX = x(message);
        Error error = Error.f8154c;
        return (errorX == error && z) ? Error.h : (errorX == error && (exc instanceof IOException)) ? Error.f8168v : errorX;
    }

    public static final int z(int i10, int i11, int i12) {
        if (i12 > 0) {
            if (i10 < i11) {
                int i13 = i11 % i12;
                if (i13 < 0) {
                    i13 += i12;
                }
                int i14 = i10 % i12;
                if (i14 < 0) {
                    i14 += i12;
                }
                int i15 = (i13 - i14) % i12;
                if (i15 < 0) {
                    i15 += i12;
                }
                return i11 - i15;
            }
        } else {
            if (i12 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i10 > i11) {
                int i16 = -i12;
                int i17 = i10 % i16;
                if (i17 < 0) {
                    i17 += i16;
                }
                int i18 = i11 % i16;
                if (i18 < 0) {
                    i18 += i16;
                }
                int i19 = (i17 - i18) % i16;
                if (i19 < 0) {
                    i19 += i16;
                }
                return i19 + i11;
            }
        }
        return i11;
    }

    @Override // v0.i0
    public void c() {
    }

    @Override // v0.i0
    public void d(View view) {
    }

    @Override // v0.i0
    public void e(View view) {
    }
}
