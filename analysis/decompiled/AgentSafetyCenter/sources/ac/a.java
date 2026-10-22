package ac;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.perfbinder.client.PerfBinderClient;
import d2.l0;
import g5.u;
import g9.j;
import h5.p;
import hc.h;
import i1.f;
import id.c;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import k8.a0;
import k8.b0;
import k8.c0;
import k8.d;
import k8.d0;
import k8.w;
import k8.y;
import k8.z;
import kb.i;
import kb.s;
import kb.t;
import kc.n;
import n3.p0;
import nb.e;
import nb.g;
import od.b;
import od.g0;
import od.h0;
import od.k0;
import od.l;
import od.x;
import pc.q;
import r.j0;
import r.o0;
import r.q0;
import s.h1;
import w0.m;
import yb.k;
import yb.v;

/* loaded from: classes.dex */
public abstract class a implements p0 {

    /* renamed from: c, reason: collision with root package name */
    public static f f419c;

    /* renamed from: f, reason: collision with root package name */
    public static f f420f;

    public static final boolean A(AssertionError assertionError) {
        Logger logger = x.f9494a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? h.X(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    public static final Boolean C() {
        try {
            Bundle bundleSafeIpcRequest = PerfBinderClient.INSTANCE.safeIpcRequest("com.stepos.appplatform", "com.stepos.appplatform.agentsafetycenter.AgentSafetySettingsSystem", "isLockPasswordEnabled", new Bundle());
            if (bundleSafeIpcRequest.getBoolean("RESULT", false)) {
                return Boolean.valueOf(bundleSafeIpcRequest.getBoolean("VALUE", false));
            }
            return null;
        } catch (Exception e10) {
            Log.w("AscPerfBinder", "isLockPasswordEnabled failed", e10);
            return null;
        }
    }

    public static List E(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        listSingletonList.getClass();
        return listSingletonList;
    }

    public static List F(Object... objArr) {
        if (objArr.length <= 0) {
            return s.f7404c;
        }
        List listAsList = Arrays.asList(objArr);
        listAsList.getClass();
        return listAsList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Object, java.util.Map] */
    public static final void G(Context context) {
        LinkedHashMap linkedHashMap;
        context.getClass();
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        databasePath.getClass();
        if (databasePath.exists()) {
            u.d().a(p.f5363a, "Migrating WorkDatabase to the no-backup directory");
            File databasePath2 = context.getDatabasePath("androidx.work.workdb");
            databasePath2.getClass();
            File noBackupFilesDir = context.getNoBackupFilesDir();
            noBackupFilesDir.getClass();
            File file = new File(noBackupFilesDir, "androidx.work.workdb");
            String[] strArr = p.f5364b;
            int iL = kb.x.L(strArr.length);
            if (iL < 16) {
                iL = 16;
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(iL);
            for (String str : strArr) {
                linkedHashMap2.put(new File(databasePath2.getPath() + str), new File(file.getPath() + str));
            }
            if (linkedHashMap2.isEmpty()) {
                ?? SingletonMap = Collections.singletonMap(databasePath2, file);
                SingletonMap.getClass();
                linkedHashMap = SingletonMap;
            } else {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(linkedHashMap2);
                linkedHashMap3.put(databasePath2, file);
                linkedHashMap = linkedHashMap3;
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                File file2 = (File) entry.getKey();
                File file3 = (File) entry.getValue();
                if (file2.exists()) {
                    if (file3.exists()) {
                        u.d().g(p.f5363a, "Over-writing contents of " + file3);
                    }
                    u.d().a(p.f5363a, file2.renameTo(file3) ? "Migrated " + file2 + "to " + file3 : "Renaming " + file2 + " to " + file3 + " failed");
                }
            }
        }
    }

    public static g H(e eVar, nb.f fVar) {
        fVar.getClass();
        return k.a(eVar.getKey(), fVar) ? nb.h.f8811c : eVar;
    }

    public static ArrayList I(Object... objArr) {
        if (objArr.length == 0) {
            return new ArrayList();
        }
        i iVar = new i();
        iVar.f7397c = objArr;
        iVar.f7398f = true;
        VarHandle.storeStoreFence();
        return new ArrayList(iVar);
    }

    public static final int J(d0 d0Var) {
        if (d0Var.equals(k8.x.f7359a)) {
            return 0;
        }
        if ((d0Var instanceof w) || d0Var.equals(z.f7361a) || d0Var.equals(a0.f7278a) || d0Var.equals(y.f7360a)) {
            return 1;
        }
        if (d0Var.equals(b0.f7283a)) {
            return 2;
        }
        if (d0Var instanceof c0) {
            return ((c0) d0Var).f7289c instanceof w ? 2 : 1;
        }
        g5.f.a();
        return 0;
    }

    public static void K(InputConnection inputConnection, EditorInfo editorInfo, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static final List L(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : E(list.get(0)) : s.f7404c;
    }

    public static String M(X509Certificate x509Certificate) {
        StringBuilder sb2 = new StringBuilder("sha256/");
        l lVar = l.f9459h;
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        encoded.getClass();
        int length = encoded.length;
        int i = 0;
        a.a.m(encoded.length, 0, length);
        a.a.n(length, encoded.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(encoded, 0, length);
        bArrCopyOfRange.getClass();
        l lVar2 = new l();
        lVar2.f9460c = bArrCopyOfRange;
        byte[] bArr = lVar2.b("SHA-256").f9460c;
        byte[] bArr2 = od.a.f9412a;
        bArr2.getClass();
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length2 = bArr.length - (bArr.length % 3);
        int i3 = 0;
        while (i < length2) {
            byte b10 = bArr[i];
            int i10 = i + 2;
            byte b11 = bArr[i + 1];
            i += 3;
            byte b12 = bArr[i10];
            bArr3[i3] = bArr2[(b10 & 255) >> 2];
            bArr3[i3 + 1] = bArr2[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i11 = i3 + 3;
            bArr3[i3 + 2] = bArr2[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i3 += 4;
            bArr3[i11] = bArr2[b12 & 63];
        }
        int length3 = bArr.length - length2;
        if (length3 == 1) {
            byte b13 = bArr[i];
            bArr3[i3] = bArr2[(b13 & 255) >> 2];
            bArr3[i3 + 1] = bArr2[(b13 & 3) << 4];
            bArr3[i3 + 2] = 61;
            bArr3[i3 + 3] = 61;
        } else if (length3 == 2) {
            int i12 = i + 1;
            byte b14 = bArr[i];
            byte b15 = bArr[i12];
            bArr3[i3] = bArr2[(b14 & 255) >> 2];
            bArr3[i3 + 1] = bArr2[((b14 & 3) << 4) | ((b15 & 255) >> 4)];
            bArr3[i3 + 2] = bArr2[(b15 & 15) << 2];
            bArr3[i3 + 3] = 61;
        }
        sb2.append(new String(bArr3, hc.a.f5448a));
        return sb2.toString();
    }

    public static g N(e eVar, g gVar) {
        gVar.getClass();
        return gVar == nb.h.f8811c ? eVar : (g) gVar.fold(eVar, new d(7));
    }

    public static final void O(HashMap map, xb.l lVar) {
        int i;
        map.getClass();
        HashMap map2 = new HashMap(999);
        loop0: while (true) {
            i = 0;
            for (Object obj : map.keySet()) {
                obj.getClass();
                map2.put(obj, map.get(obj));
                i++;
                if (i == 999) {
                    break;
                }
            }
            lVar.invoke(map2);
            map2.clear();
        }
        if (i > 0) {
            lVar.invoke(map2);
        }
    }

    public static int P(double d7) {
        if (Double.isNaN(d7)) {
            g5.f.s("Cannot round NaN value.");
            return 0;
        }
        if (d7 > 2.147483647E9d) {
            return Reader.READ_DONE;
        }
        if (d7 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d7);
    }

    public static int Q(float f5) {
        if (!Float.isNaN(f5)) {
            return Math.round(f5);
        }
        g5.f.s("Cannot round NaN value.");
        return 0;
    }

    public static long R(double d7) {
        if (!Double.isNaN(d7)) {
            return Math.round(d7);
        }
        g5.f.s("Cannot round NaN value.");
        return 0L;
    }

    public static final b U(Socket socket) throws IOException {
        Logger logger = x.f9494a;
        h0 h0Var = new h0();
        h0Var.f9452m = socket;
        VarHandle.storeStoreFence();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.getClass();
        b bVar = new b(1);
        bVar.f9419f = outputStream;
        bVar.f9420g = h0Var;
        VarHandle.storeStoreFence();
        b bVar2 = new b(0);
        bVar2.f9419f = h0Var;
        bVar2.f9420g = bVar;
        VarHandle.storeStoreFence();
        return bVar2;
    }

    public static r.h0 V() {
        d2.y yVar = new d2.y(20);
        h1 h1VarN = s.d.n(320, 6, null);
        n6.a aVar = r.c0.f10254a;
        return new r.h0(new q0((j0) null, new o0(new r.b0(yVar, 0), h1VarN), (c) null, (id.k) null, (LinkedHashMap) null, 61)).a(r.c0.a(s.d.n(280, 6, null), 2));
    }

    public static final od.c W(InputStream inputStream) {
        Logger logger = x.f9494a;
        inputStream.getClass();
        return new od.c(inputStream, new k0());
    }

    public static final od.c X(Socket socket) throws IOException {
        Logger logger = x.f9494a;
        h0 h0Var = new h0();
        h0Var.f9452m = socket;
        VarHandle.storeStoreFence();
        InputStream inputStream = socket.getInputStream();
        inputStream.getClass();
        od.c cVar = new od.c(inputStream, h0Var);
        od.c cVar2 = new od.c();
        cVar2.f9425f = h0Var;
        cVar2.f9426g = cVar;
        VarHandle.storeStoreFence();
        return cVar2;
    }

    public static final Object Y(q qVar, q qVar2, xb.p pVar) {
        Object nVar;
        Object objP;
        try {
            yb.x.c(2, pVar);
            nVar = pVar.invoke(qVar2, qVar);
        } catch (Throwable th) {
            nVar = new n(th, false);
        }
        ob.a aVar = ob.a.f9351c;
        if (nVar == aVar || (objP = qVar.P(nVar)) == kc.w.f7493e) {
            return aVar;
        }
        if (objP instanceof n) {
            throw ((n) objP).f7461a;
        }
        return kc.w.C(objP);
    }

    public static void Z() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void a0() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final long b(int i, int i3) {
        return (i3 & 4294967295L) | (i << 32);
    }

    public static final Bundle b0(j jVar) {
        jVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putInt("code", jVar.f4489a);
        bundle.putString("message", jVar.f4490b);
        bundle.putInt("schema_version", 1);
        bundle.putLong("updated_at_ms", jVar.f4491c);
        bundle.putBoolean("from_cache", jVar.f4492d);
        bundle.putBoolean("stale", jVar.f4493e);
        bundle.putString("payload_json", jVar.f4494f);
        return bundle;
    }

    public static byte[] c0(g5.h hVar) throws IOException {
        hVar.getClass();
        HashMap map = hVar.f4319a;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(-21521);
                dataOutputStream.writeShort(1);
                dataOutputStream.writeInt(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    d0(dataOutputStream, (String) entry.getKey(), entry.getValue());
                }
                dataOutputStream.flush();
                if (dataOutputStream.size() > 10240) {
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                dataOutputStream.close();
                byteArray.getClass();
                return byteArray;
            } finally {
            }
        } catch (IOException e10) {
            u.d().c(g5.i.f4320a, "Error in Data#toByteArray: ", e10);
            return new byte[0];
        }
    }

    public static final void d0(DataOutputStream dataOutputStream, String str, Object obj) throws IOException {
        int i;
        if (obj == null) {
            dataOutputStream.writeByte(0);
        } else if (obj instanceof Boolean) {
            dataOutputStream.writeByte(1);
            dataOutputStream.writeBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            dataOutputStream.writeByte(2);
            dataOutputStream.writeByte(((Number) obj).byteValue());
        } else if (obj instanceof Integer) {
            dataOutputStream.writeByte(3);
            dataOutputStream.writeInt(((Number) obj).intValue());
        } else if (obj instanceof Long) {
            dataOutputStream.writeByte(4);
            dataOutputStream.writeLong(((Number) obj).longValue());
        } else if (obj instanceof Float) {
            dataOutputStream.writeByte(5);
            dataOutputStream.writeFloat(((Number) obj).floatValue());
        } else if (obj instanceof Double) {
            dataOutputStream.writeByte(6);
            dataOutputStream.writeDouble(((Number) obj).doubleValue());
        } else if (obj instanceof String) {
            dataOutputStream.writeByte(7);
            dataOutputStream.writeUTF((String) obj);
        } else {
            if (!(obj instanceof Object[])) {
                g5.f.f(v.a(obj.getClass()).c(), "Unsupported value type ");
                return;
            }
            Object[] objArr = (Object[]) obj;
            yb.e eVarA = v.a(objArr.getClass());
            if (eVarA.equals(v.a(Boolean[].class))) {
                i = 8;
            } else if (eVarA.equals(v.a(Byte[].class))) {
                i = 9;
            } else if (eVarA.equals(v.a(Integer[].class))) {
                i = 10;
            } else if (eVarA.equals(v.a(Long[].class))) {
                i = 11;
            } else if (eVarA.equals(v.a(Float[].class))) {
                i = 12;
            } else if (eVarA.equals(v.a(Double[].class))) {
                i = 13;
            } else {
                if (!eVarA.equals(v.a(String[].class))) {
                    g5.f.f(v.a(objArr.getClass()).b(), "Unsupported value type ");
                    return;
                }
                i = 14;
            }
            dataOutputStream.writeByte(i);
            dataOutputStream.writeInt(objArr.length);
            for (Object obj2 : objArr) {
                if (i == 8) {
                    Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
                    dataOutputStream.writeBoolean(bool != null ? bool.booleanValue() : false);
                } else if (i == 9) {
                    Byte b10 = obj2 instanceof Byte ? (Byte) obj2 : null;
                    dataOutputStream.writeByte(b10 != null ? b10.byteValue() : (byte) 0);
                } else if (i == 10) {
                    Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
                    dataOutputStream.writeInt(num != null ? num.intValue() : 0);
                } else if (i == 11) {
                    Long l2 = obj2 instanceof Long ? (Long) obj2 : null;
                    dataOutputStream.writeLong(l2 != null ? l2.longValue() : 0L);
                } else if (i == 12) {
                    Float f5 = obj2 instanceof Float ? (Float) obj2 : null;
                    dataOutputStream.writeFloat(f5 != null ? f5.floatValue() : 0.0f);
                } else if (i == 13) {
                    Double d7 = obj2 instanceof Double ? (Double) obj2 : null;
                    dataOutputStream.writeDouble(d7 != null ? d7.doubleValue() : 0.0d);
                } else if (i == 14) {
                    String str2 = obj2 instanceof String ? (String) obj2 : null;
                    if (str2 == null) {
                        str2 = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d";
                    }
                    dataOutputStream.writeUTF(str2);
                }
            }
        }
        dataOutputStream.writeUTF(str);
    }

    public static d2.a e(String str, l0 l0Var, long j10, o2.c cVar, g2.d dVar, int i) {
        s sVar = s.f7404c;
        return new d2.a(new k2.d(str, l0Var, sVar, sVar, dVar, cVar), i, 1, j10);
    }

    public static final b9.b e0(a9.j jVar) {
        List listE = E(jVar.b());
        Map mapSingletonMap = Collections.singletonMap("display_text", jVar.a());
        mapSingletonMap.getClass();
        b9.b bVar = new b9.b();
        bVar.f2046a = listE;
        bVar.f2047b = mapSingletonMap;
        VarHandle.storeStoreFence();
        return bVar;
    }

    public static byte[] f(String str) {
        try {
            return str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            throw new Error("HttpClient requires ASCII support");
        }
    }

    public static final long f0(long j10, ic.c cVar) {
        ic.c cVar2 = ic.c.f5941f;
        TimeUnit timeUnit = cVar.f5944c;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long jConvert = timeUnit.convert(4611686018426999999L, timeUnit2);
        if ((-jConvert) > j10 || j10 > jConvert) {
            ic.c cVar3 = ic.c.f5941f;
            return r(p5.f.r(TimeUnit.MILLISECONDS.convert(j10, timeUnit), -4611686018427387903L, 4611686018427387903L));
        }
        long jConvert2 = timeUnit2.convert(j10, timeUnit) << 1;
        int i = ic.a.f5939g;
        int i3 = ic.b.f5940a;
        return jConvert2;
    }

    public static final m g(m mVar, float f5) {
        return f5 == 1.0f ? mVar : androidx.compose.ui.graphics.a.d(mVar, f5, null, 520187);
    }

    public static final List g0(ArrayList arrayList) {
        int size = arrayList.size();
        return size != 0 ? size != 1 ? Collections.unmodifiableList(new ArrayList(arrayList)) : Collections.singletonList(kb.l.w0(arrayList)) : s.f7404c;
    }

    public static ArrayList h(Object... objArr) {
        if (objArr.length == 0) {
            return new ArrayList();
        }
        i iVar = new i();
        iVar.f7397c = objArr;
        iVar.f7398f = true;
        VarHandle.storeStoreFence();
        return new ArrayList(iVar);
    }

    public static final Map h0(Map map) {
        int size = map.size();
        if (size == 0) {
            return t.f7405c;
        }
        if (size != 1) {
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) kb.l.v0(map.entrySet());
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }

    public static int i(ArrayList arrayList, Comparable comparable) {
        int size = arrayList.size();
        arrayList.getClass();
        int size2 = arrayList.size();
        int i = 0;
        if (size < 0) {
            throw new IllegalArgumentException("fromIndex (0) is greater than toIndex (" + size + ").");
        }
        if (size > size2) {
            throw new IndexOutOfBoundsException("toIndex (" + size + ") is greater than size (" + size2 + ").");
        }
        int i3 = size - 1;
        while (i <= i3) {
            int i10 = (i + i3) >>> 1;
            int iJ = com.stepos.statsrpk.h.j((Comparable) arrayList.get(i10), comparable);
            if (iJ < 0) {
                i = i10 + 1;
            } else {
                if (iJ <= 0) {
                    return i10;
                }
                i3 = i10 - 1;
            }
        }
        return -(i + 1);
    }

    public static final long i0(long j10) {
        return (Float.floatToRawIntBits((int) (j10 & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits((int) (j10 >> 32)) << 32);
    }

    public static final od.b0 j(g0 g0Var) {
        g0Var.getClass();
        od.b0 b0Var = new od.b0();
        b0Var.f9421c = g0Var;
        b0Var.f9422f = new od.i();
        VarHandle.storeStoreFence();
        return b0Var;
    }

    public static final void j0(int i, int i3) {
        if (i > 0 && i3 > 0) {
            if (i <= i3) {
                return;
            }
            od.f.c(androidx.activity.b.i("minLines ", i, " must be less than or equal to maxLines ", i3));
        } else {
            throw new IllegalArgumentException(("both minLines " + i + " and maxLines " + i3 + " must be greater than zero").toString());
        }
    }

    public static lb.c k(lb.c cVar) {
        cVar.f();
        cVar.f7833g = true;
        return cVar.f7832f > 0 ? cVar : lb.c.f7830h;
    }

    public static int l(Context context, String str) {
        int iNoteProxyOpNoThrow;
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) != -1) {
            String strPermissionToOp = AppOpsManager.permissionToOp(str);
            if (strPermissionToOp != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                int iMyUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                if (iMyUid2 == iMyUid && Objects.equals(packageName2, packageName)) {
                    AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                    iNoteProxyOpNoThrow = appOpsManager == null ? 1 : appOpsManager.checkOpNoThrow(strPermissionToOp, Binder.getCallingUid(), packageName);
                    if (iNoteProxyOpNoThrow == 0) {
                        iNoteProxyOpNoThrow = appOpsManager != null ? appOpsManager.checkOpNoThrow(strPermissionToOp, iMyUid, context.getOpPackageName()) : 1;
                    }
                } else {
                    iNoteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, packageName);
                }
                if (iNoteProxyOpNoThrow != 0) {
                    return -2;
                }
            }
            return 0;
        }
        return -1;
    }

    public static final boolean l0(boolean z10, String str, Long l2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("SCREEN_PERCEPTION_ENABLED", z10);
            bundle.putString("SCREEN_PERCEPTION_SCOPE", str);
            String string = null;
            if (l2 != null) {
                if (l2.longValue() <= 0) {
                    l2 = null;
                }
                if (l2 != null) {
                    string = l2.toString();
                }
            }
            if (string == null) {
                string = "";
            }
            bundle.putString("SCREEN_PERCEPTION_DEADLINE_EPOCH_MS", string);
            return PerfBinderClient.INSTANCE.safeIpcRequest("com.stepos.appplatform", "com.stepos.appplatform.agentsafetycenter.AgentSafetySettingsSystem", "writeScreenPerceptionGlobalPolicy", bundle).getBoolean("RESULT", false);
        } catch (Exception e10) {
            Log.w("AscPerfBinder", "writeScreenPerceptionGlobalPolicy failed", e10);
            return false;
        }
    }

    public static void m(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            File file2 = new File(file.getParentFile(), file.getName() + ".dead." + System.nanoTime());
            if (file.renameTo(file2)) {
                file2.delete();
            } else {
                od.f.l(w2.c.b("unable to clear existing enc file: ", file.getAbsolutePath()));
            }
        }
    }

    public static float[] n(float[] fArr, int i) {
        if (i < 0) {
            od.f.b();
            return null;
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i, length);
        float[] fArr2 = new float[i];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    public static lb.c o() {
        return new lb.c(10);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:44:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static f3.c[] p(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ac.a.p(java.lang.String):f3.c[]");
    }

    public static f3.c[] q(f3.c[] cVarArr) {
        f3.c[] cVarArr2 = new f3.c[cVarArr.length];
        for (int i = 0; i < cVarArr.length; i++) {
            f3.c cVar = cVarArr[i];
            f3.c cVar2 = new f3.c();
            cVar2.f3904a = cVar.f3904a;
            float[] fArr = cVar.f3905b;
            cVar2.f3905b = n(fArr, fArr.length);
            cVarArr2[i] = cVar2;
        }
        return cVarArr2;
    }

    public static final long r(long j10) {
        long j11 = (j10 << 1) + 1;
        int i = ic.a.f5939g;
        int i3 = ic.b.f5940a;
        return j11;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Serializable, java.lang.Double[]] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Serializable, java.lang.Float[]] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Serializable, java.lang.Long[]] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Serializable, java.lang.Integer[]] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Serializable, java.lang.Byte[]] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Serializable, java.lang.Boolean[]] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.Serializable, java.lang.String[]] */
    public static final Serializable s(DataInputStream dataInputStream, byte b10) throws IOException {
        if (b10 == 0) {
            return null;
        }
        if (b10 == 1) {
            return Boolean.valueOf(dataInputStream.readBoolean());
        }
        if (b10 == 2) {
            return Byte.valueOf(dataInputStream.readByte());
        }
        if (b10 == 3) {
            return Integer.valueOf(dataInputStream.readInt());
        }
        if (b10 == 4) {
            return Long.valueOf(dataInputStream.readLong());
        }
        if (b10 == 5) {
            return Float.valueOf(dataInputStream.readFloat());
        }
        if (b10 == 6) {
            return Double.valueOf(dataInputStream.readDouble());
        }
        if (b10 == 7) {
            return dataInputStream.readUTF();
        }
        int i = 0;
        if (b10 == 8) {
            int i3 = dataInputStream.readInt();
            ?? r02 = new Boolean[i3];
            while (i < i3) {
                r02[i] = Boolean.valueOf(dataInputStream.readBoolean());
                i++;
            }
            return r02;
        }
        if (b10 == 9) {
            int i10 = dataInputStream.readInt();
            ?? r03 = new Byte[i10];
            while (i < i10) {
                r03[i] = Byte.valueOf(dataInputStream.readByte());
                i++;
            }
            return r03;
        }
        if (b10 == 10) {
            int i11 = dataInputStream.readInt();
            ?? r04 = new Integer[i11];
            while (i < i11) {
                r04[i] = Integer.valueOf(dataInputStream.readInt());
                i++;
            }
            return r04;
        }
        if (b10 == 11) {
            int i12 = dataInputStream.readInt();
            ?? r05 = new Long[i12];
            while (i < i12) {
                r05[i] = Long.valueOf(dataInputStream.readLong());
                i++;
            }
            return r05;
        }
        if (b10 == 12) {
            int i13 = dataInputStream.readInt();
            ?? r06 = new Float[i13];
            while (i < i13) {
                r06[i] = Float.valueOf(dataInputStream.readFloat());
                i++;
            }
            return r06;
        }
        if (b10 == 13) {
            int i14 = dataInputStream.readInt();
            ?? r07 = new Double[i14];
            while (i < i14) {
                r07[i] = Double.valueOf(dataInputStream.readDouble());
                i++;
            }
            return r07;
        }
        if (b10 != 14) {
            od.f.e(k0.a.j(b10, "Unsupported type "));
            return null;
        }
        int i15 = dataInputStream.readInt();
        ?? r12 = new String[i15];
        while (i < i15) {
            String utf = dataInputStream.readUTF();
            if (k.a(utf, "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d")) {
                utf = null;
            }
            r12[i] = utf;
            i++;
        }
        return r12;
    }

    public static e t(e eVar, nb.f fVar) {
        fVar.getClass();
        if (k.a(eVar.getKey(), fVar)) {
            return eVar;
        }
        return null;
    }

    public static int x(List list) {
        list.getClass();
        return list.size() - 1;
    }

    public static final boolean z(d2.g gVar) {
        int length = gVar.f3101f.length();
        List list = gVar.f3100c;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                d2.e eVar = (d2.e) list.get(i);
                if ((eVar.f3077a instanceof d2.m) && d2.h.b(0, length, eVar.f3078b, eVar.f3079c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract boolean B();

    public abstract boolean D(Class cls);

    public abstract void S(boolean z10);

    public abstract void T(boolean z10);

    public abstract TransformationMethod k0(TransformationMethod transformationMethod);

    public abstract Method u(Class cls, Field field);

    public abstract Constructor v(Class cls);

    public abstract InputFilter[] w(InputFilter[] inputFilterArr);

    public abstract String[] y(Class cls);

    @Override // n3.p0
    public void a() {
    }

    @Override // n3.p0
    public void c() {
    }
}
