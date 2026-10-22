package p5;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import b8.r0;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import h.e0;
import ie.v;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import k0.i2;
import l.a0;
import l0.j0;
import n3.k0;
import n3.o0;
import p.p0;
import stepos.support.v7.app.n0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements r0, ie.e, j0, r3.f {

    /* renamed from: c, reason: collision with root package name */
    public Object f9738c;

    /* renamed from: f, reason: collision with root package name */
    public Object f9739f;

    public static byte[] f(Context context, String str, int i) {
        ua.c.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.simple_crypto_AES");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.simple_crypto_AES", 0);
        ua.c.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.simple_crypto_AES structure complete");
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            byte[] bArrDecode = Base64.decode(string, 2);
            if (bArrDecode.length == i) {
                return bArrDecode;
            }
        }
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        sharedPreferences.edit().putString(str, Base64.encodeToString(bArr, 2)).commit();
        return bArr;
    }

    public static String j(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '%' || cCharAt == '\\' || cCharAt == '_') {
                sb2.append('\\');
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public void A(String str, long j10) throws IOException {
        str.getClass();
        File fileI = i(j10);
        File parentFile = fileI.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        e eVar = (e) this.f9739f;
        Charset charset = StandardCharsets.UTF_8;
        charset.getClass();
        byte[] bytes = str.getBytes(charset);
        bytes.getClass();
        synchronized (eVar.f9723g) {
            try {
                File parentFile2 = fileI.getParentFile();
                if (parentFile2 != null) {
                    parentFile2.mkdirs();
                }
                int i = 0;
                IOException e10 = null;
                while (i < 3) {
                    ac.a.m(fileI);
                    try {
                        w4.c cVarF = eVar.f(fileI).f();
                        try {
                            cVarF.write(bytes);
                            cVarF.close();
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                t.o.d(cVarF, th);
                                throw th2;
                            }
                        }
                    } catch (IOException e11) {
                        e10 = e11;
                        String message = e10.getMessage();
                        if (message == null || !hc.h.X(message, "already exists", true) || i == 2) {
                            throw e10;
                        }
                        i++;
                        Log.w("EncPayloadCipher", "enc write race on " + fileI.getName() + ", retry attempt=" + i, e10);
                    }
                }
                if (e10 != null) {
                    throw e10;
                }
                throw new IOException("enc write failed: " + fileI.getAbsolutePath());
            } catch (Throwable th3) {
                throw th3;
            }
        }
        try {
            m(j10).delete();
        } catch (Throwable th4) {
            id.c.l(th4);
        }
    }

    @Override // ie.e
    public Type a() {
        return (Type) this.f9738c;
    }

    @Override // r3.f
    public void b(NestedScrollView nestedScrollView) {
        n0.r(nestedScrollView, (View) this.f9738c, (View) this.f9739f);
    }

    @Override // l0.j0
    public List c(Integer num) {
        List listC = ((j0) this.f9738c).c(null);
        i2 i2Var = (i2) this.f9739f;
        int i = i2Var.f6958v;
        return i < 0 ? listC : kb.l.F0(t2.a.c(i2Var, num, i, Integer.valueOf(i2Var.D(i2Var.f6939b, i))), listC);
    }

    @Override // ie.e
    public Object d(v vVar) {
        Executor executor = (Executor) this.f9739f;
        return executor == null ? vVar : new ie.m(executor, vVar);
    }

    public SecretKeySpec e() {
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec("262t1#x23&^ya1bk".toCharArray(), (byte[]) this.f9738c, 100, ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH)).getEncoded(), "AES");
        } catch (Exception e10) {
            od.f.g("Deal with exceptions properly!", e10);
            return null;
        }
    }

    public void g(long j10) {
        try {
            i(j10).delete();
        } catch (Throwable th) {
            id.c.l(th);
        }
        try {
            m(j10).delete();
        } catch (Throwable th2) {
            id.c.l(th2);
        }
    }

    public void h(String str, long j10) {
        Object objL;
        File file = (File) this.f9739f;
        if (file.exists()) {
            try {
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file.getAbsolutePath(), (SQLiteDatabase.CursorFactory) null);
                try {
                    sQLiteDatabaseOpenOrCreateDatabase.getClass();
                    sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS MEDIA_GARBAGE (\n    _id INTEGER PRIMARY KEY,\n    original_path TEXT,\n    media_id INTEGER,\n    media_type INTEGER,\n    deleted_time INTEGER\n)");
                    int iDelete = sQLiteDatabaseOpenOrCreateDatabase.delete("MEDIA_GARBAGE", "original_path = ? AND media_id = ?", new String[]{str, String.valueOf(j10)});
                    sQLiteDatabaseOpenOrCreateDatabase.close();
                    objL = Integer.valueOf(iDelete);
                } finally {
                }
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            Throwable thB = jb.i.b(objL);
            if (thB != null) {
                Log.w("MediaStoreTrash", "Failed to clean MediaStore trash record: " + str, thB);
            }
        }
    }

    public File i(long j10) {
        return new File(new File((File) this.f9738c, "dashboard_days"), j10 + ".enc");
    }

    @Override // b8.r0
    public String k() {
        return (String) this.f9739f;
    }

    public void l(a9.p pVar, String str) throws IOException {
        File file = (File) this.f9739f;
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file.getAbsolutePath(), (SQLiteDatabase.CursorFactory) null);
        try {
            sQLiteDatabaseOpenOrCreateDatabase.getClass();
            sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS MEDIA_GARBAGE (\n    _id INTEGER PRIMARY KEY,\n    original_path TEXT,\n    media_id INTEGER,\n    media_type INTEGER,\n    deleted_time INTEGER\n)");
            sQLiteDatabaseOpenOrCreateDatabase.delete("MEDIA_GARBAGE", "original_path = ?", new String[]{str});
            ContentValues contentValues = new ContentValues();
            contentValues.put("original_path", str);
            contentValues.put("media_id", Long.valueOf(pVar.f295a));
            contentValues.put("media_type", Integer.valueOf(pVar.f296b));
            contentValues.put("deleted_time", Long.valueOf(System.currentTimeMillis()));
            if (sQLiteDatabaseOpenOrCreateDatabase.insert("MEDIA_GARBAGE", null, contentValues) == -1) {
                throw new IllegalStateException("Failed to insert MediaStore trash record for: ".concat(str).toString());
            }
            sQLiteDatabaseOpenOrCreateDatabase.close();
        } finally {
        }
    }

    public File m(long j10) {
        return new File(new File((File) this.f9738c, "dashboard_days"), j10 + ".json");
    }

    public void n(k.a aVar) {
        k.e eVar = (k.e) this.f9738c;
        eVar.f6810c.onDestroyActionMode(eVar.a(aVar));
        e0 e0Var = (e0) this.f9739f;
        if (e0Var.f4806x != null) {
            e0Var.f4795m.getDecorView().removeCallbacks(e0Var.f4807y);
        }
        if (e0Var.f4805w != null) {
            o0 o0Var = e0Var.f4808z;
            if (o0Var != null) {
                o0Var.b();
            }
            o0 o0VarA = k0.a(e0Var.f4805w);
            o0VarA.a(0.0f);
            e0Var.f4808z = o0VarA;
            h.u uVar = new h.u(2);
            uVar.f4896h = this;
            VarHandle.storeStoreFence();
            o0VarA.e(uVar);
        }
        e0Var.f4804v = null;
        ViewGroup viewGroup = e0Var.C;
        WeakHashMap weakHashMap = k0.f8724a;
        viewGroup.requestApplyInsets();
        e0Var.G();
    }

    @Override // b8.r0
    public boolean o(JsonNode jsonNode) {
        JsonNode jsonNode2 = (JsonNode) this.f9738c;
        if (jsonNode2.isDouble() && jsonNode2.doubleValue() == Double.NEGATIVE_INFINITY) {
            return false;
        }
        if (jsonNode2.isDouble() && jsonNode2.doubleValue() == Double.POSITIVE_INFINITY) {
            return true;
        }
        if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.NEGATIVE_INFINITY) {
            return true;
        }
        if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.POSITIVE_INFINITY) {
            return false;
        }
        int iCompareTo = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.f9739f));
        return iCompareTo < 0 || iCompareTo == 0;
    }

    public boolean p(k.a aVar, Menu menu) {
        ViewGroup viewGroup = ((e0) this.f9739f).C;
        WeakHashMap weakHashMap = k0.f8724a;
        viewGroup.requestApplyInsets();
        k.e eVar = (k.e) this.f9738c;
        ActionMode.Callback callback = eVar.f6810c;
        k.f fVarA = eVar.a(aVar);
        p0 p0Var = eVar.f6813h;
        Menu a0Var = (Menu) p0Var.get(menu);
        if (a0Var == null) {
            a0Var = new a0(eVar.f6811f, (h3.a) menu);
            p0Var.put(menu, a0Var);
        }
        return callback.onPrepareActionMode(fVarA, a0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0205, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x010c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0105 A[Catch: IOException -> 0x008d, XmlPullParserException -> 0x0090, TryCatch #2 {IOException -> 0x008d, XmlPullParserException -> 0x0090, blocks: (B:19:0x005e, B:96:0x0205, B:27:0x0070, B:28:0x007e, B:30:0x0083, B:37:0x0093, B:45:0x00ad, B:40:0x009c, B:43:0x00a5, B:46:0x00bb, B:50:0x00ca, B:52:0x00d2, B:53:0x00dc, B:62:0x0105, B:63:0x010c, B:64:0x0124, B:56:0x00e5, B:58:0x00ed, B:59:0x00fb, B:65:0x0125, B:67:0x012d, B:68:0x013b, B:71:0x0145, B:72:0x0150, B:73:0x0168, B:74:0x0169, B:77:0x0173, B:78:0x017e, B:79:0x0196, B:80:0x0197, B:82:0x019f, B:83:0x01a8, B:86:0x01b2, B:87:0x01bc, B:88:0x01d4, B:89:0x01d5, B:92:0x01df, B:93:0x01e9, B:94:0x0201, B:95:0x0202), top: B:104:0x005e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(android.content.Context r10, android.content.res.XmlResourceParser r11) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.l.q(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public List r(String str, String[] strArr, int i) throws IOException {
        Bundle bundle = new Bundle();
        bundle.putString("android:query-arg-sql-selection", str);
        bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
        bundle.putInt("android:query-arg-match-trashed", i);
        ArrayList arrayList = null;
        Cursor cursorQuery = ((ContentResolver) this.f9738c).query(MediaStore.Files.getContentUri("external"), new String[]{"_id", "media_type", "is_trashed", "_data"}, bundle, null);
        if (cursorQuery != null) {
            try {
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("media_type");
                int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("is_trashed");
                int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("_data");
                ArrayList arrayList2 = new ArrayList();
                while (cursorQuery.moveToNext()) {
                    int i3 = cursorQuery.getInt(columnIndexOrThrow2);
                    boolean z10 = true;
                    if (i3 != 1 && i3 != 3) {
                        z10 = false;
                    }
                    if (z10) {
                        long j10 = cursorQuery.getLong(columnIndexOrThrow);
                        int i10 = cursorQuery.getInt(columnIndexOrThrow3);
                        String string = cursorQuery.getString(columnIndexOrThrow4);
                        string.getClass();
                        arrayList2.add(new a9.p(i3, i10, j10, string));
                    }
                }
                cursorQuery.close();
                arrayList = arrayList2;
            } finally {
            }
        }
        return arrayList == null ? kb.s.f7404c : arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [jb.h] */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.util.ArrayList] */
    public List s(String str, boolean z10) {
        kb.s sVarL;
        SQLiteDatabase sQLiteDatabaseOpenDatabase;
        Cursor cursorQuery;
        File file = (File) this.f9739f;
        boolean zExists = file.exists();
        kb.s sVar = kb.s.f7404c;
        if (!zExists) {
            return sVar;
        }
        try {
            sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(file.getAbsolutePath(), null, 1);
            String str2 = z10 ? "original_path = ?" : "original_path LIKE ? ESCAPE '\\'";
            if (!z10) {
                try {
                    str = j(str).concat("%");
                } finally {
                }
            }
            cursorQuery = sQLiteDatabaseOpenDatabase.query("MEDIA_GARBAGE", new String[]{"_id", "original_path", "media_id", "media_type", "deleted_time"}, str2, new String[]{str}, null, null, "deleted_time DESC, _id DESC");
        } catch (Throwable th) {
            sVarL = id.c.l(th);
        }
        try {
            ?? arrayList = new ArrayList();
            while (cursorQuery.moveToNext()) {
                long j10 = cursorQuery.getLong(0);
                String string = cursorQuery.getString(1);
                string.getClass();
                long j11 = cursorQuery.getLong(2);
                int i = cursorQuery.getInt(3);
                long j12 = cursorQuery.getLong(4);
                a9.q qVar = new a9.q();
                qVar.f299a = j10;
                qVar.f300b = string;
                qVar.f301c = j11;
                qVar.f302d = i;
                qVar.f303e = j12;
                VarHandle.storeStoreFence();
                arrayList.add(qVar);
            }
            cursorQuery.close();
            sQLiteDatabaseOpenDatabase.close();
            sVarL = arrayList;
            Throwable thB = jb.i.b(sVarL);
            if (thB == null) {
                sVar = sVarL;
            } else {
                Log.w("MediaStoreTrash", "Failed to read MediaStore trash records: " + file.getAbsolutePath(), thB);
            }
            return sVar;
        } finally {
        }
    }

    public a9.p t(String str) {
        Object next;
        a9.p pVar = (a9.p) kb.l.x0(r("_data = ? AND is_trashed = ?", new String[]{str, "1"}, 3));
        if (pVar != null) {
            return pVar;
        }
        Iterator it = s(str, true).iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long j10 = ((a9.q) next).f303e;
                do {
                    Object next2 = it.next();
                    long j11 = ((a9.q) next2).f303e;
                    if (j10 < j11) {
                        next = next2;
                        j10 = j11;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        a9.q qVar = (a9.q) next;
        if (qVar == null) {
            return null;
        }
        String str2 = qVar.f300b;
        long j12 = qVar.f301c;
        a9.p pVar2 = (a9.p) kb.l.x0(r("_id = ?", new String[]{String.valueOf(j12)}, 1));
        if (pVar2 != null && pVar2.f297c == 0) {
            h(str2, j12);
            return null;
        }
        if (pVar2 != null) {
            return a9.p.a(pVar2, str2);
        }
        return new a9.p(qVar.f302d, 1, qVar.f301c, qVar.f300b);
    }

    public ArrayList u(String str) throws IOException {
        a9.p pVarA;
        int i = 0;
        String strN = k0.a.n(hc.h.x0(str, JsonPointer.SEPARATOR), "/");
        List listR = r("_data LIKE ? ESCAPE '\\' AND is_trashed = ?", new String[]{j(strN).concat("%"), "1"}, 3);
        List<a9.q> listI0 = kb.l.I0(s(strN, false), new a9.n(1));
        ArrayList arrayList = new ArrayList();
        for (a9.q qVar : listI0) {
            long j10 = qVar.f301c;
            String str2 = qVar.f300b;
            a9.p pVar = (a9.p) kb.l.x0(r("_id = ?", new String[]{String.valueOf(j10)}, 1));
            if (pVar == null || pVar.f297c != 0) {
                pVarA = pVar != null ? a9.p.a(pVar, str2) : new a9.p(qVar.f302d, 1, qVar.f301c, qVar.f300b);
            } else {
                h(str2, qVar.f301c);
                pVarA = null;
            }
            if (pVarA != null) {
                arrayList.add(pVarA);
            }
        }
        ArrayList arrayListF0 = kb.l.F0(listR, arrayList);
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayListF0.size();
        while (i < size) {
            Object obj = arrayListF0.get(i);
            i++;
            if (hashSet.add(Long.valueOf(((a9.p) obj).f295a))) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public String v(long j10) {
        Object objL;
        File fileI = i(j10);
        if (fileI.isFile()) {
            try {
                objL = ((e) this.f9739f).p(fileI);
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            if (objL instanceof jb.h) {
                objL = null;
            }
            byte[] bArr = (byte[]) objL;
            if (bArr != null) {
                Charset charset = StandardCharsets.UTF_8;
                charset.getClass();
                String str = new String(bArr, charset);
                if (hc.h.g0(str)) {
                    return null;
                }
                return str;
            }
        }
        return null;
    }

    public String w(String str, long j10) {
        Object objL;
        str.getClass();
        String strV = v(j10);
        if (strV != null) {
            return strV;
        }
        if (!hc.h.g0(str) && !str.equals("{}")) {
            return str;
        }
        File fileM = m(j10);
        String str2 = null;
        if (fileM.isFile()) {
            try {
                StandardCharsets.UTF_8.getClass();
                objL = ub.h.n(fileM);
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            if (objL instanceof jb.h) {
                objL = null;
            }
            String str3 = (String) objL;
            if (str3 != null && !hc.h.g0(str3)) {
                str2 = str3;
            }
        }
        if (str2 != null) {
            return str2;
        }
        if (hc.h.g0(str)) {
            str = "{}";
        }
        return str;
    }

    public boolean x(a9.p pVar) {
        pVar.getClass();
        String str = pVar.f298d;
        int i = pVar.f296b;
        if ((i == 1 || i == 3) && y(pVar)) {
            File file = new File(str);
            for (int i3 = 0; i3 < 20; i3++) {
                if (file.exists()) {
                    h(str, pVar.f295a);
                    return true;
                }
                Thread.sleep(50L);
            }
        }
        return false;
    }

    public boolean y(a9.p pVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_trashed", (Integer) 0);
        return ((ContentResolver) this.f9738c).update(MediaStore.Files.getContentUri("external", pVar.f295a), contentValues, null, null) > 0;
    }

    public boolean z(a9.p pVar, String str) {
        Object objL;
        int i = pVar.f296b;
        if (i != 1 && i != 3) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_trashed", (Integer) 1);
        if (((ContentResolver) this.f9738c).update(MediaStore.Files.getContentUri("external", pVar.f295a), contentValues, null, null) <= 0) {
            return false;
        }
        try {
            l(pVar, str);
            objL = jb.v.f6774a;
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        if (!(objL instanceof jb.h)) {
            return true;
        }
        Log.w("MediaStoreTrash", "Failed to record MediaStore trash entry; rolling back: ".concat(str), jb.i.b(objL));
        y(pVar);
        return false;
    }
}
