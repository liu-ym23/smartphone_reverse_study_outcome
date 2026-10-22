package u1;

import F8.f;
import Q8.o;
import Va.i;
import Va.l;
import Va.n;
import W8.k;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import j9.t;
import java.lang.reflect.Type;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import m8.C1682b;
import qa.C1856h;
import qa.InterfaceC1854f;
import qa.v;
import stepos.support.v7.app.AbstractC1975y;
import stepos.support.v7.app.WebViewActivity;
import t8.C2027d;
import u8.p;
import u8.u;

/* renamed from: u1.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2031a implements k, com.google.android.material.button.b, InterfaceC1854f, l, OnApplyWindowInsetsListener {
    public static final String[] b = {"_id", "value", "type", "timestamp", "retry_count", "retry_time"};
    public static C2031a c;
    public static C2031a d;

    /* renamed from: a, reason: collision with root package name */
    public Object f6686a;

    public /* synthetic */ C2031a(Object obj) {
        this.f6686a = obj;
    }

    public static void c(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    public synchronized long a(String str, byte[] bArr) {
        if (d() && bArr != null && bArr.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", bArr);
            contentValues.put("type", str);
            contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("retry_count", (Integer) 0);
            contentValues.put("retry_time", (Long) 0L);
            return ((SQLiteDatabase) this.f6686a).insert("queue", null, contentValues);
        }
        return -1L;
    }

    public synchronized void b(int i, String str, long j5) {
        String str2;
        String[] strArr;
        try {
            if (d()) {
                long jCurrentTimeMillis = System.currentTimeMillis() - j5;
                if (TextUtils.isEmpty(str)) {
                    str2 = "timestamp <= ? ";
                    strArr = new String[]{String.valueOf(jCurrentTimeMillis)};
                } else {
                    str2 = "(timestamp <= ? OR retry_count > " + i + ") and type = ?";
                    strArr = new String[]{String.valueOf(jCurrentTimeMillis), str};
                }
                try {
                    ((SQLiteDatabase) this.f6686a).delete("queue", str2, strArr);
                } catch (Exception e) {
                    e.toString();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean d() {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f6686a;
        if (sQLiteDatabase != null) {
            if (sQLiteDatabase.isOpen()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, stepos.support.v7.app.l] */
    @Override // Va.l
    public boolean e(n nVar, MenuItem menuItem) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) this.f6686a;
        ?? r1 = abstractC1975y.e;
        if (abstractC1975y.o || !(menuItem instanceof i)) {
            return false;
        }
        return r1.onBottomItemSelected((i) menuItem);
    }

    public synchronized boolean f(boolean z10, long j5, long j6, int i) {
        if (d() && j5 > 0) {
            String[] strArr = {String.valueOf(j5)};
            if (!z10) {
                Cursor cursorQuery = null;
                try {
                    try {
                        cursorQuery = ((SQLiteDatabase) this.f6686a).query("queue", new String[]{"timestamp", "retry_count"}, "_id = ?", strArr, null, null, null);
                        if (!cursorQuery.moveToNext()) {
                            c(cursorQuery);
                            return false;
                        }
                        long j10 = cursorQuery.getLong(0);
                        int i6 = cursorQuery.getInt(1);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - j10 < j6 && i6 < i) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("retry_count", Integer.valueOf(i6 + 1));
                            contentValues.put("retry_time", Long.valueOf(jCurrentTimeMillis));
                            ((SQLiteDatabase) this.f6686a).update("queue", contentValues, "_id = ?", strArr);
                            c(cursorQuery);
                            return true;
                        }
                        c(cursorQuery);
                    } catch (Throwable th) {
                        c(cursorQuery);
                        throw th;
                    }
                } catch (Exception e) {
                    e.toString();
                    c(cursorQuery);
                    return false;
                }
            }
            try {
                ((SQLiteDatabase) this.f6686a).delete("queue", "_id = ?", strArr);
            } catch (Throwable unused) {
            }
            return false;
        }
        return false;
    }

    public synchronized void g() {
        if (d()) {
            try {
                ((SQLiteDatabase) this.f6686a).execSQL("DROP TABLE IF EXISTS queue");
                ((SQLiteDatabase) this.f6686a).execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");
            } catch (Exception e) {
                e.toString();
            }
        }
    }

    @Override // qa.InterfaceC1854f
    public Type h() {
        return (Type) this.f6686a;
    }

    @Override // qa.InterfaceC1854f
    public Object i(v vVar) {
        C1856h c1856h = new C1856h(vVar);
        vVar.g(new B1.c(c1856h));
        return c1856h;
    }

    public Q.a j(G8.b classId, f jvmMetadataVersion) {
        C1682b c1682bT;
        kotlin.jvm.internal.k.f(classId, "classId");
        kotlin.jvm.internal.k.f(jvmMetadataVersion, "jvmMetadataVersion");
        String strB0 = t.b0(classId.b.b(), '.', '$');
        G8.c cVar = classId.f687a;
        if (!cVar.d()) {
            strB0 = cVar + '.' + strB0;
        }
        Class clsY = U7.a.Y((ClassLoader) this.f6686a, strB0);
        if (clsY == null || (c1682bT = Z6.k.t(clsY)) == null) {
            return null;
        }
        return new Q.a(c1682bT, 13);
    }

    @Override // Va.l
    public void k(n nVar) {
    }

    public InterfaceC1522e l(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a javaClass) {
        p pVar;
        kotlin.jvm.internal.k.f(javaClass, "javaClass");
        G8.c cVarD = javaClass.d();
        if (cVarD != null) {
            LightClassOriginKind[] lightClassOriginKindArr = LightClassOriginKind.f5003a;
        }
        Class<?> declaringClass = javaClass.f4985a.getDeclaringClass();
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a aVar = declaringClass != null ? new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a(declaringClass) : null;
        if (aVar != null) {
            InterfaceC1522e interfaceC1522eL = l(aVar);
            o oVarO = interfaceC1522eL != null ? interfaceC1522eL.O() : null;
            InterfaceC1524g interfaceC1524gB = oVarO != null ? oVarO.b(javaClass.f(), NoLookupLocation.h) : null;
            if (interfaceC1524gB instanceof InterfaceC1522e) {
                return (InterfaceC1522e) interfaceC1524gB;
            }
        } else if (cVarD != null && (pVar = (p) D7.v.C0(H4.o.M(((C2027d) this.f6686a).c(cVarD.e())))) != null) {
            u uVar = pVar.f6732j.d;
            uVar.getClass();
            return uVar.u(javaClass.f(), javaClass);
        }
        return null;
    }

    @Override // W8.k
    public void lock() {
        ((ReentrantLock) this.f6686a).lock();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(0, windowInsetsCompat.getSystemWindowInsetTop(), 0, 0);
        ((WebViewActivity) this.f6686a).f6239a = windowInsetsCompat.getSystemWindowInsetBottom();
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    @Override // W8.k
    public void unlock() {
        ((ReentrantLock) this.f6686a).unlock();
    }

    public C2031a() {
        this.f6686a = new Object();
        new Handler(Looper.getMainLooper(), new f3.f(this));
    }
}
