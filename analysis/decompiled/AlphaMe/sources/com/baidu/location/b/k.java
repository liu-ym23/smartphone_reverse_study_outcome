package com.baidu.location.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import androidx.room.AbstractC0351g;
import com.baidu.location.Jni;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k {

    /* renamed from: d, reason: collision with root package name */
    private static k f5325d;

    /* renamed from: c, reason: collision with root package name */
    private static Object f5324c = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static final String f5326e = com.baidu.location.e.h.g() + "/hst.db";

    /* renamed from: f, reason: collision with root package name */
    private SQLiteDatabase f5329f = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5330g = false;

    /* renamed from: a, reason: collision with root package name */
    a f5327a = null;

    /* renamed from: b, reason: collision with root package name */
    a f5328b = null;

    /* renamed from: h, reason: collision with root package name */
    private String f5331h = null;

    /* renamed from: i, reason: collision with root package name */
    private int f5332i = -2;

    public class a extends com.baidu.location.e.f {

        /* renamed from: b, reason: collision with root package name */
        private String f5334b = null;

        /* renamed from: c, reason: collision with root package name */
        private String f5335c = null;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5336d = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f5337e = false;

        public a() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            this.ei = 1;
            String strQ = com.baidu.location.c.f.a().q();
            if (strQ != null) {
                this.er = Jni.encodeTp4(strQ);
            }
            String strEncodeTp4 = Jni.encodeTp4(this.f5335c);
            this.f5335c = null;
            this.el.put("bloc", strEncodeTp4);
        }

        public void a(String str, String str2) {
            if (k.this.f5330g) {
                return;
            }
            k.this.f5330g = true;
            this.f5334b = str;
            if (n.a().b()) {
                this.f5335c = AbstractC0351g.p(str2, "&enc=2");
            } else {
                this.f5335c = str2;
            }
            ExecutorService executorServiceC = x.a().c();
            if (executorServiceC != null) {
                a(executorServiceC, com.baidu.location.e.d.f5843e);
            } else {
                b(com.baidu.location.e.d.f5843e);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
        
            r12 = r11.ej;
         */
        @Override // com.baidu.location.e.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(boolean r12) throws org.json.JSONException, java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 266
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.k.a.a(boolean):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        a(bundle);
    }

    public void b() {
        try {
            File file = new File(f5326e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.f5329f = sQLiteDatabaseOpenOrCreateDatabase;
                sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f5329f.setVersion(1);
            }
        } catch (Exception unused) {
            this.f5329f = null;
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase = this.f5329f;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f5329f = null;
                throw th;
            }
            this.f5329f = null;
        }
    }

    public synchronized int d() {
        int i4;
        int i5 = -3;
        if (this.f5330g) {
            return -3;
        }
        try {
            if (com.baidu.location.c.f.a().l() && this.f5329f != null) {
                WifiInfo wifiInfoP = com.baidu.location.c.f.a().p();
                Cursor cursorRawQuery = null;
                String strA = com.baidu.location.c.f.a().a(wifiInfoP, (String) null);
                if (wifiInfoP != null && strA != null) {
                    String strReplace = strA.replace(AwarenessDataItem.USERID_SPLITTER, "");
                    Long lEncode3 = Jni.encode3(strReplace);
                    String str = this.f5331h;
                    if (str == null || !strReplace.equals(str) || (i4 = this.f5332i) <= -2) {
                        try {
                            cursorRawQuery = this.f5329f.rawQuery("select * from hstdata where id = ?", new String[]{String.valueOf(lEncode3)});
                            if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                                i5 = -2;
                            } else {
                                i5 = cursorRawQuery.getInt(1);
                                this.f5331h = strReplace;
                                this.f5332i = i5;
                            }
                        } catch (Exception unused) {
                            if (cursorRawQuery != null) {
                            }
                        } catch (Throwable th) {
                            if (cursorRawQuery != null) {
                                try {
                                    cursorRawQuery.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } else {
                        i5 = i4;
                    }
                }
            }
        } catch (Exception unused3) {
        }
        this.f5332i = i5;
        return i5;
    }

    public void e() {
        WifiInfo wifiInfoP;
        if (this.f5330g) {
            return;
        }
        try {
            if (!com.baidu.location.c.f.a().l() || this.f5329f == null || (wifiInfoP = com.baidu.location.c.f.a().p()) == null || wifiInfoP.getBSSID() == null) {
                f();
                return;
            }
            String strReplace = wifiInfoP.getBSSID().replace(AwarenessDataItem.USERID_SPLITTER, "");
            Cursor cursorRawQuery = null;
            try {
                try {
                    boolean z4 = false;
                    cursorRawQuery = this.f5329f.rawQuery("select * from hstdata where id = ?", new String[]{String.valueOf(Jni.encode3(strReplace))});
                    if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                        z4 = true;
                    } else {
                        int i4 = cursorRawQuery.getInt(1);
                        if ((System.currentTimeMillis() / 1000) - cursorRawQuery.getInt(2) > 259200) {
                            z4 = true;
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putByteArray("mac", strReplace.getBytes());
                            bundle.putInt("hotspot", i4);
                            a(bundle);
                        }
                    }
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (z4) {
                        if (this.f5327a == null) {
                            this.f5327a = new a();
                        }
                        a aVar = this.f5327a;
                        if (aVar != null) {
                            aVar.a(strReplace, a(true));
                        }
                    }
                } catch (Exception unused2) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
        }
    }

    public static k a() {
        k kVar;
        synchronized (f5324c) {
            try {
                if (f5325d == null) {
                    f5325d = new k();
                }
                kVar = f5325d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(boolean r7) {
        /*
            r6 = this;
            com.baidu.location.c.f r6 = com.baidu.location.c.f.a()
            com.baidu.location.c.a r6 = r6.f()
            com.baidu.location.c.f r0 = com.baidu.location.c.f.a()
            com.baidu.location.c.k r0 = r0.r()
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r2 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2)
            if (r6 == 0) goto L2a
            boolean r2 = r6.b()
            if (r2 == 0) goto L2a
            com.baidu.location.c.f r2 = com.baidu.location.c.f.a()
            java.lang.String r6 = r2.b(r6)
            r1.append(r6)
        L2a:
            r6 = 1
            r2 = 0
            if (r0 == 0) goto L44
            int r3 = r0.a()
            if (r3 <= r6) goto L44
            com.baidu.location.c.f r3 = com.baidu.location.c.f.a()
            r4 = 15
            int r5 = com.baidu.location.e.h.ay
            java.lang.String r0 = r3.a(r4, r2, r0, r5)
        L40:
            r1.append(r0)
            goto L4f
        L44:
            com.baidu.location.c.f r0 = com.baidu.location.c.f.a()
            java.lang.String r0 = r0.o()
            if (r0 == 0) goto L4f
            goto L40
        L4f:
            if (r7 == 0) goto L56
            java.lang.String r7 = "&imo=1"
            r1.append(r7)
        L56:
            com.baidu.location.c.d r7 = com.baidu.location.c.d.a()
            java.lang.String r7 = r7.m()
            r1.append(r7)
            com.baidu.location.e.b r7 = com.baidu.location.e.b.a()
            java.lang.String r7 = r7.a(r2)
            r1.append(r7)
            com.baidu.location.b.b r7 = com.baidu.location.b.b.a()
            java.lang.String r7 = r7.c()
            r1.append(r7)
            com.baidu.location.b.e r7 = com.baidu.location.b.e.a()
            java.lang.String r7 = r7.c()
            r1.append(r7)
            android.content.Context r7 = com.baidu.location.f.getServiceContext()
            java.lang.String r7 = com.baidu.location.e.h.d(r7)
            r1.append(r7)
            android.content.Context r7 = com.baidu.location.f.getServiceContext()
            int r7 = com.baidu.location.e.h.b(r7)
            if (r7 < 0) goto L9f
            java.lang.String r0 = "&lmd="
            r1.append(r0)
            r1.append(r7)
        L9f:
            java.lang.String r7 = "&cnloc="
            r1.append(r7)
            com.baidu.location.b.l r7 = com.baidu.location.b.l.a()
            int r7 = r7.b()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            int r0 = r7.length()
            int r1 = com.baidu.location.e.h.aN
            if (r0 <= r1) goto Lf6
            java.lang.String r0 = "&cl_list="
            java.lang.String[] r0 = r7.split(r0)
            int r1 = r0.length
            r3 = 2
            if (r1 != r3) goto Lf6
            r7 = r0[r6]
            java.lang.String r1 = "&"
            java.lang.String[] r7 = r7.split(r1, r3)
            int r1 = r7.length
            if (r1 != r3) goto Le9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r0 = r0[r2]
            r1.append(r0)
            java.lang.String r0 = "&cl_list=null&"
            r1.append(r0)
            r6 = r7[r6]
            r1.append(r6)
            java.lang.String r7 = r1.toString()
            goto Lf6
        Le9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r7 = r0[r2]
            java.lang.String r0 = "&cl_list=null"
            java.lang.String r7 = B0.g.r(r6, r7, r0)
        Lf6:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.k.a(boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        b.a().a(bundle, 406);
    }

    public void a(String str) throws JSONException, NumberFormatException {
        if (this.f5330g) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
            if (jSONObject2 == null || !jSONObject2.has("imo")) {
                return;
            }
            Long lValueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
            int i4 = jSONObject2.getJSONObject("imo").getInt("mv");
            ContentValues contentValues = new ContentValues();
            contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            contentValues.put("hst", Integer.valueOf(i4));
            if (this.f5329f.update("hstdata", contentValues, "id = \"" + lValueOf + "\"", null) <= 0) {
                contentValues.put("id", lValueOf);
                this.f5329f.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }
}
