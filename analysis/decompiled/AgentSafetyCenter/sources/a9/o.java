package a9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.fasterxml.jackson.core.JsonPointer;
import d2.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jb.v;
import kb.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final List f293b = ac.a.E("com.stepos.filemanager");

    /* renamed from: a, reason: collision with root package name */
    public List f294a;

    static {
        id.k.n(null);
    }

    public static void a(l lVar) {
        Object objL;
        String str = lVar.f288f;
        String str2 = lVar.f284b;
        if (!new File(str).exists()) {
            Log.w("GarbageStore", "Garbage database missing while cleaning restored record: ".concat(str));
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null);
            try {
                sQLiteDatabaseOpenOrCreateDatabase.getClass();
                sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS GARBAGE (\n    _id INTEGER PRIMARY KEY,\n    _original_path TEXT,\n    _garbage_path TEXT,\n    _display_name TEXT,\n    _deleted_time INTEGER,\n    _length INTEGER,\n    _mime_type TEXT\n)");
                if (sQLiteDatabaseOpenOrCreateDatabase.delete("GARBAGE", "_id = ? AND _original_path = ?", new String[]{String.valueOf(lVar.f283a), str2}) <= 0) {
                    Log.w("GarbageStore", "Garbage record already missing while cleaning restored record: ".concat(str2));
                }
                sQLiteDatabaseOpenOrCreateDatabase.close();
                objL = v.f6774a;
            } finally {
            }
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        Throwable thB = jb.i.b(objL);
        if (thB != null) {
            Log.w("GarbageStore", "Failed to clean restored garbage record: ".concat(str2), thB);
        }
    }

    public static long d(long j10, long j11, String str, String str2, String str3, String str4, String str5) throws IOException {
        File parentFile = new File(str).getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null);
        try {
            sQLiteDatabaseOpenOrCreateDatabase.getClass();
            sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS GARBAGE (\n    _id INTEGER PRIMARY KEY,\n    _original_path TEXT,\n    _garbage_path TEXT,\n    _display_name TEXT,\n    _deleted_time INTEGER,\n    _length INTEGER,\n    _mime_type TEXT\n)");
            ContentValues contentValues = new ContentValues();
            contentValues.put("_original_path", str2);
            contentValues.put("_garbage_path", str3);
            contentValues.put("_display_name", str4);
            contentValues.put("_deleted_time", Long.valueOf(j10));
            contentValues.put("_length", Long.valueOf(j11));
            contentValues.put("_mime_type", str5);
            long jInsert = sQLiteDatabaseOpenOrCreateDatabase.insert("GARBAGE", null, contentValues);
            if (jInsert == -1) {
                throw new IllegalStateException("Failed to insert garbage record for: ".concat(str2).toString());
            }
            sQLiteDatabaseOpenOrCreateDatabase.close();
            return jInsert;
        } finally {
        }
    }

    public static boolean f(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        String canonicalPath2 = new File(str2).getCanonicalPath();
        if (!yb.k.a(canonicalPath, canonicalPath2)) {
            canonicalPath.getClass();
            canonicalPath2.getClass();
            if (!hc.o.U(canonicalPath, hc.h.x0(canonicalPath2, JsonPointer.SEPARATOR) + "/", false)) {
                return false;
            }
        }
        return true;
    }

    public static void g(File file, File file2) throws IOException {
        if (file2.exists()) {
            ad.o.m(file2.getAbsolutePath(), "Target already exists: ");
            return;
        }
        if (file.renameTo(file2)) {
            return;
        }
        if (!file.exists()) {
            throw new ub.a(file, null, "The source file doesn't exist.");
        }
        if (file2.exists()) {
            throw new ub.a(file, file2, "The destination file already exists.");
        }
        if (!file.isDirectory()) {
            File parentFile = file2.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    t.n.f(fileInputStream, fileOutputStream);
                    fileOutputStream.close();
                    fileInputStream.close();
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    t.o.d(fileInputStream, th);
                    throw th2;
                }
            }
        } else if (!file2.mkdirs()) {
            throw new androidx.datastore.preferences.protobuf.k(file, file2, "Failed to create target directory.");
        }
        if (file.delete()) {
            return;
        }
        file2.delete();
        ad.o.m(file.getAbsolutePath(), "Failed to remove source file: ");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [jb.h] */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.util.ArrayList] */
    public static List h(String str, String str2, boolean z10) {
        s sVarL;
        String str3;
        boolean zExists = new File(str).exists();
        s sVar = s.f7404c;
        if (!zExists) {
            return sVar;
        }
        try {
            SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null);
            try {
                sQLiteDatabaseOpenOrCreateDatabase.getClass();
                sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS GARBAGE (\n    _id INTEGER PRIMARY KEY,\n    _original_path TEXT,\n    _garbage_path TEXT,\n    _display_name TEXT,\n    _deleted_time INTEGER,\n    _length INTEGER,\n    _mime_type TEXT\n)");
                String str4 = z10 ? "_original_path = ?" : "_original_path LIKE ? ESCAPE '\\'";
                int i = 0;
                if (z10) {
                    str3 = str2;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    for (int i3 = 0; i3 < str2.length(); i3++) {
                        char cCharAt = str2.charAt(i3);
                        if (cCharAt == '%' || cCharAt == '\\' || cCharAt == '_') {
                            sb2.append('\\');
                        }
                        sb2.append(cCharAt);
                    }
                    str3 = sb2.toString() + "%";
                }
                Cursor cursorQuery = sQLiteDatabaseOpenOrCreateDatabase.query("GARBAGE", new String[]{"_id", "_original_path", "_garbage_path", "_display_name", "_deleted_time", "_mime_type"}, str4, new String[]{str3}, null, null, "_deleted_time DESC, _id DESC");
                try {
                    ?? arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        long j10 = cursorQuery.getLong(i);
                        String string = cursorQuery.getString(1);
                        string.getClass();
                        String string2 = cursorQuery.getString(2);
                        string2.getClass();
                        String string3 = cursorQuery.getString(3);
                        string3.getClass();
                        long j11 = cursorQuery.getLong(4);
                        String string4 = cursorQuery.getString(5);
                        if (string4 == null) {
                            string4 = "application/octet-stream";
                        }
                        int i10 = i;
                        arrayList.add(new l(j10, j11, string, string2, string3, str, string4));
                        i = i10;
                    }
                    cursorQuery.close();
                    sQLiteDatabaseOpenOrCreateDatabase.close();
                    sVarL = arrayList;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    t.o.d(sQLiteDatabaseOpenOrCreateDatabase, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            sVarL = id.c.l(th3);
        }
        Throwable thB = jb.i.b(sVarL);
        if (thB == null) {
            sVar = sVarL;
        } else {
            Log.w("GarbageStore", "Failed to read garbage store: ".concat(str), thB);
        }
        return sVar;
    }

    public static Object i(l lVar, boolean z10) {
        String str = lVar.f284b;
        String str2 = lVar.f285c;
        try {
            File file = new File(str2);
            File file2 = new File(str);
            if (lVar.f289g.equals("inode/directory")) {
                if (file2.exists() && (!z10 || !file2.isDirectory())) {
                    c cVar = c.f246f;
                    throw new IllegalStateException("TARGET_EXISTS");
                }
                if (!file2.exists() && !file2.mkdirs()) {
                    throw new IllegalStateException("Failed to restore directory: ".concat(str).toString());
                }
                file.delete();
                a(lVar);
            } else {
                if (!file.exists()) {
                    throw new IllegalStateException("Garbage file missing: ".concat(str2).toString());
                }
                if (file2.exists()) {
                    c cVar2 = c.f246f;
                    throw new IllegalStateException("TARGET_EXISTS");
                }
                File parentFile = file2.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                g(file, file2);
                a(lVar);
            }
            return v.f6774a;
        } catch (Throwable th) {
            return id.c.l(th);
        }
    }

    public static String j(File file, String str) {
        if (!new File(file, str).exists()) {
            return str;
        }
        int iH0 = hc.h.h0(str, '.', 0, 6);
        String strSubstring = iH0 > 0 ? str.substring(0, iH0) : str;
        String strSubstring2 = iH0 > 0 ? str.substring(iH0) : "";
        int i = 1;
        while (true) {
            String str2 = strSubstring + "(" + i + ")" + strSubstring2;
            if (!new File(file, str2).exists()) {
                return str2;
            }
            i++;
        }
    }

    public final List b(String str) {
        List list = this.f294a;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kb.q.p0(h(((m) it.next()).f291b, hc.h.x0(str, JsonPointer.SEPARATOR) + "/", false), arrayList);
        }
        return kb.l.I0(arrayList, new n(0));
    }

    public final l c(String str) {
        Object obj;
        gc.n nVarR0 = kb.l.r0(this.f294a);
        k kVar = new k(0);
        kVar.f282f = str;
        VarHandle.storeStoreFence();
        gc.i iVar = new gc.i(2);
        iVar.f4694b = nVarR0;
        iVar.f4695c = kVar;
        gc.g gVar = (gc.g) new gc.h(iVar, false, new y(13)).iterator();
        if (gVar.hasNext()) {
            Object next = gVar.next();
            if (gVar.hasNext()) {
                long j10 = ((l) next).f287e;
                do {
                    Object next2 = gVar.next();
                    long j11 = ((l) next2).f287e;
                    if (j10 < j11) {
                        next = next2;
                        j10 = j11;
                    }
                } while (gVar.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (l) obj;
    }

    public final boolean e(String str) {
        str.getClass();
        List<m> list = this.f294a;
        if (list.isEmpty()) {
            return false;
        }
        for (m mVar : list) {
            if (f(str, mVar.f290a) || f(str, mVar.f291b)) {
                return true;
            }
        }
        return false;
    }
}
