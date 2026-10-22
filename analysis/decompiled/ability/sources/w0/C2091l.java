package w0;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.slardar.config.IConfigManager;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r0.AbstractC1874a;
import x0.C2112a;

/* renamed from: w0.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2091l extends AbstractC2080a {

    /* renamed from: A, reason: collision with root package name */
    public static long f6815A;

    /* renamed from: B, reason: collision with root package name */
    public static long f6816B;

    /* renamed from: w, reason: collision with root package name */
    public static String f6817w;

    /* renamed from: x, reason: collision with root package name */
    public static String f6818x;
    public static String y;

    /* renamed from: z, reason: collision with root package name */
    public static String f6819z;
    public boolean g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public long f6820j;
    public long k;
    public int l;
    public long m;
    public boolean n;
    public ArrayList o;
    public ArrayList p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f6821q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f6822r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f6823s;

    /* renamed from: t, reason: collision with root package name */
    public B1.b f6824t;
    public B1.b u;

    /* renamed from: v, reason: collision with root package name */
    public B1.b f6825v;

    public static long l(File file) {
        long jL = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                for (File file2 : fileArrListFiles) {
                    jL += file2.isDirectory() ? l(file2) : file2.length();
                }
            }
            return jL;
        } catch (Exception e) {
            e.printStackTrace();
            return jL;
        }
    }

    @Override // w0.AbstractC2080a
    public final void b(JSONObject jSONObject) {
        this.h = jSONObject.optBoolean("dump_switch", true);
        this.i = jSONObject.optBoolean("enable_upload", true);
        if (this.h) {
            long jCurrentTimeMillis = System.currentTimeMillis() - ((SharedPreferences) AbstractC1874a.f5670a.b).getLong("check_disk_last_time", 0L);
            if (jCurrentTimeMillis < CalendarModelKt.MillisecondsIn24Hours && jCurrentTimeMillis > 0) {
                this.g = true;
            }
            if (jSONObject.optInt("dump_threshold") > 0) {
                this.f6820j = jSONObject.optInt("dump_threshold") * 1048576;
            }
            if (jSONObject.optInt("abnormal_folder_size") > 0) {
                this.k = jSONObject.optInt("abnormal_folder_size") * 1048576;
            }
            if (jSONObject.optInt("dump_top_count") > 0) {
                this.l = jSONObject.optInt("dump_top_count");
            }
            if (jSONObject.optInt("outdated_days") > 0) {
                this.m = jSONObject.optInt("outdated_days") * CalendarModelKt.MillisecondsIn24Hours;
            }
            ArrayList arrayList = null;
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("disk_customed_paths");
                if (!S0.b.E0(jSONObjectOptJSONObject)) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (jSONObjectOptJSONObject.optInt(next) == 1) {
                            arrayList2.add(next);
                        }
                    }
                    arrayList = arrayList2;
                }
            } catch (Exception unused) {
            }
            this.p = arrayList;
            this.f6821q = S0.b.t("ignored_relative_paths", jSONObject);
        }
    }

    @Override // w0.AbstractC2080a
    public final boolean h() {
        return true;
    }

    @Override // w0.AbstractC2080a
    public final void j() {
        C2091l c2091l;
        ArrayList arrayList = this.f6823s;
        ArrayList arrayList2 = this.f6822r;
        if (H.h.b) {
            Log.i("DiskMonitor", U7.a.e(new String[]{"Storage onStart"}));
        }
        boolean z10 = this.b;
        boolean z11 = H.h.b;
        if (!z11 && (this.g || !z10)) {
            if (z11) {
                Log.i("DiskMonitor", U7.a.e(new String[]{"mHasUploadUsedStorage：" + this.g + " background：" + z10 + " return"}));
                return;
            }
            return;
        }
        if (!this.i && !this.h) {
            if (z11) {
                StringBuilder sb = new StringBuilder("isIndicatorSwitch:");
                sb.append(this.i);
                sb.append(" isExceptionDiskSwitch:");
                Log.i("DiskMonitor", U7.a.e(new String[]{B7.a.s(sb, this.h, " return")}));
                return;
            }
            return;
        }
        if (f6817w == null) {
            Application application = H.h.f711a;
            try {
                application.getPackageName();
                f6817w = application.getFilesDir().getParent();
                f6818x = application.getCacheDir().getAbsolutePath();
                y = application.getExternalFilesDir(null).getParentFile().getAbsolutePath();
                File externalCacheDir = application.getExternalCacheDir();
                if (externalCacheDir != null) {
                    f6819z = externalCacheDir.getAbsolutePath();
                }
                ArrayList arrayList3 = this.f6821q;
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (str.contains("internal")) {
                            arrayList2.add(str.replace("internal", f6817w));
                        } else if (str.contains("external")) {
                            arrayList2.add(str.replace("external", y));
                        }
                    }
                }
                ArrayList<String> arrayList4 = this.p;
                if (arrayList4 != null) {
                    for (String str2 : arrayList4) {
                        if (str2.contains("internal")) {
                            arrayList.add(str2.replace("internal", f6817w));
                        } else if (str2.contains("external")) {
                            arrayList.add(str2.replace("external", y));
                        }
                    }
                }
            } catch (Exception e) {
                this.n = true;
                if (H.h.b) {
                    Log.i("DiskMonitor", U7.a.e(new String[]{"mInitException:" + this.n + " exception:" + e.getMessage()}));
                }
            }
        }
        if (this.n) {
            this.g = true;
            return;
        }
        try {
            p();
            ArrayList arrayList5 = this.o;
            long j5 = 0;
            if (arrayList5 != null && !arrayList5.isEmpty()) {
                Iterator it2 = this.o.iterator();
                while (it2.hasNext()) {
                    j5 += ((C2087h) it2.next()).b;
                }
            }
            long j6 = j5;
            ArrayList arrayList6 = this.o;
            if (arrayList6 != null && !arrayList6.isEmpty()) {
                Iterator it3 = this.o.iterator();
                while (it3.hasNext()) {
                    C2087h c2087h = (C2087h) it3.next();
                    c2087h.a();
                    c2087h.c();
                }
            }
            c2091l = this;
            try {
                c2091l.n(j6, f6816B + f6815A, Environment.getRootDirectory().getTotalSpace() + Environment.getDataDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());
                ((SharedPreferences) AbstractC1874a.f5670a.b).edit().putLong("check_disk_last_time", System.currentTimeMillis()).apply();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            c2091l = this;
        }
        c2091l.g = true;
        if (H.h.b) {
            Log.i("DiskMonitor", U7.a.e(new String[]{B7.a.s(new StringBuilder("mHasUploadUsedStorage:"), c2091l.g, " finish")}));
        }
        if (c2091l.d) {
            c2091l.d = false;
            L0.f fVar = L0.d.f925a;
            fVar.getClass();
            try {
                fVar.f.remove(c2091l);
            } catch (Throwable unused3) {
            }
        }
        ActivityLifeObserver.getInstance().unregister(c2091l);
        ((IConfigManager) L2.a.a(IConfigManager.class)).unregisterConfigListener(c2091l);
    }

    @Override // w0.AbstractC2080a
    public final long k() {
        return 120000L;
    }

    public final void m(int i, String str, long j5, long j6) {
        if (j5 < 102400 || j5 > 68719476736L) {
            return;
        }
        if (this.f6825v == null) {
            this.f6825v = new B1.b(this.l);
        }
        B1.b bVar = this.f6825v;
        C2090k c2090k = new C2090k();
        c2090k.d = str;
        c2090k.e = j5;
        c2090k.f = i;
        c2090k.g = j6;
        bVar.g(c2090k);
    }

    public final void n(long j5, long j6, long j10, long j11) {
        JSONObject jSONObject;
        try {
            if (H.h.b) {
                Log.i("DiskMonitor", U7.a.e(new String[]{"disk: data: " + j5 + " , cache: " + j6 + " , total: " + j10 + " , free: " + j11}));
            }
            long j12 = 68719476736L;
            long j13 = j5 > 68719476736L ? 68719476736L : j5;
            if (j6 <= 68719476736L) {
                j12 = j6;
            }
            JSONObject jSONObject2 = new JSONObject();
            if (j5 > 0) {
                jSONObject2.put(SettingsConfig.KEY_DATA, j13);
            }
            if (j6 > 0) {
                jSONObject2.put("cache", j12);
            }
            if (j10 > 0) {
                long j14 = j10 / 1073741824;
                if (j14 > 1024) {
                    j14 = 0;
                }
                jSONObject2.put("total", j14);
            }
            if (j11 > 0) {
                long j15 = j11 / 1073741824;
                if (j15 > 1024) {
                    j15 = 0;
                }
                jSONObject2.put("rom_free", j15);
            }
            JSONObject jSONObject3 = new JSONObject();
            ArrayList arrayList = this.o;
            if (arrayList != null && !arrayList.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.o.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((C2087h) it.next()).b(new BigDecimal(j13)));
                }
                jSONObject3.put("disk_info", jSONArray);
            }
            JSONObject jSONObject4 = null;
            this.o = null;
            if (this.h && j13 > this.f6820j) {
                if (this.f6824t != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    B1.b bVar = this.f6824t;
                    bVar.getClass();
                    ArrayList arrayList2 = new ArrayList((PriorityQueue) bVar.c);
                    Collections.sort(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        JSONObject jSONObjectA = ((C2088i) it2.next()).a();
                        if (jSONObjectA != null) {
                            jSONArray2.put(jSONObjectA);
                        }
                    }
                    jSONObject3.put("top_usage", jSONArray2);
                }
                if (this.u != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    B1.b bVar2 = this.u;
                    bVar2.getClass();
                    ArrayList arrayList3 = new ArrayList((PriorityQueue) bVar2.c);
                    Collections.sort(arrayList3);
                    Iterator it3 = arrayList3.iterator();
                    while (it3.hasNext()) {
                        JSONObject jSONObjectA2 = ((C2088i) it3.next()).a();
                        if (jSONObjectA2 != null) {
                            jSONArray3.put(jSONObjectA2);
                        }
                    }
                    jSONObject3.put("exception_folders", jSONArray3);
                }
                if (this.f6825v != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    B1.b bVar3 = this.f6825v;
                    bVar3.getClass();
                    ArrayList arrayList4 = new ArrayList((PriorityQueue) bVar3.c);
                    Collections.sort(arrayList4);
                    Iterator it4 = arrayList4.iterator();
                    while (it4.hasNext()) {
                        JSONObject jSONObjectA3 = ((C2090k) it4.next()).a();
                        if (jSONObjectA3 != null) {
                            jSONArray4.put(jSONObjectA3);
                        }
                    }
                    jSONObject3.put("outdated_files", jSONArray4);
                }
                this.f6824t = null;
                this.u = null;
                this.f6825v = null;
            }
            P.e eVar = new P.e();
            eVar.f1057a = "disk";
            eVar.b = "storageUsed";
            eVar.c = "";
            eVar.d = jSONObject2;
            eVar.e = null;
            eVar.g = jSONObject3;
            a(eVar);
            if (H.h.b) {
                Log.d("ApmInsight", U7.a.e(new String[]{"Receive:DiskData"}));
                Log.i("DiskMonitor", U7.a.e(new String[]{"extraValues: " + jSONObject2.toString() + " extraLog:" + jSONObject3.toString()}));
            }
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("log_type", "performance_monitor");
                jSONObject5.put(NotificationCompat.CATEGORY_SERVICE, "disk");
                if (!S0.b.s0(jSONObject2)) {
                    jSONObject5.put("extra_values", jSONObject2);
                }
                if (TextUtils.equals("start", "disk") && TextUtils.equals(TypedValues.TransitionType.S_FROM, jSONObject5.optString("monitor-plugin"))) {
                    jSONObject = new JSONObject();
                    jSONObject.put("start_mode", H.h.i);
                } else {
                    jSONObject = null;
                }
                if (!S0.b.s0(jSONObject)) {
                    jSONObject5.put("extra_status", jSONObject);
                }
                jSONObject4 = jSONObject5;
            } catch (JSONException unused) {
            }
            if (jSONObject4 != null) {
                C2112a.c.a(jSONObject4.toString());
            }
        } catch (Throwable unused2) {
        }
    }

    public final void o(File file, int i, boolean z10, ArrayList arrayList) {
        File[] fileArr;
        ArrayList arrayList2 = this.f6822r;
        int i6 = 4;
        if (i > 4 || !file.exists() || arrayList2.contains(file.getAbsolutePath())) {
            return;
        }
        int i10 = 0;
        if (!file.isDirectory()) {
            C2087h c2087h = new C2087h();
            c2087h.d = false;
            c2087h.f6812a = file.getAbsolutePath();
            c2087h.b = file.length();
            if (!z10) {
                c2087h.e = "custom";
            }
            arrayList.add(c2087h);
            return;
        }
        if (!z10) {
            C2087h c2087h2 = new C2087h();
            c2087h2.d = true;
            c2087h2.e = "custom";
            c2087h2.f6812a = file.getAbsolutePath();
            c2087h2.b = l(file);
            arrayList.add(c2087h2);
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        int length = fileArrListFiles.length;
        int i11 = 0;
        while (i10 < length) {
            File file2 = fileArrListFiles[i10];
            if (i11 >= 50) {
                return;
            }
            i11++;
            if (file2 == null || !file2.exists() || arrayList2.contains(file2.getAbsolutePath())) {
                fileArr = fileArrListFiles;
            } else {
                C2087h c2087h3 = new C2087h();
                c2087h3.d = file2.isDirectory();
                c2087h3.f6812a = file2.getAbsolutePath();
                if (file2.isDirectory()) {
                    ArrayList arrayList3 = new ArrayList();
                    c2087h3.f = arrayList3;
                    if (i == i6) {
                        c2087h3.b = l(file2);
                    }
                    int i12 = i + 1;
                    o(file2, i12, z10, arrayList3);
                    if (i12 <= i6) {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            c2087h3.b += ((C2087h) it.next()).b;
                            fileArrListFiles = fileArrListFiles;
                        }
                    }
                    fileArr = fileArrListFiles;
                    arrayList.add(c2087h3);
                } else {
                    fileArr = fileArrListFiles;
                    c2087h3.b = file2.length();
                    arrayList.add(c2087h3);
                }
            }
            i10++;
            fileArrListFiles = fileArr;
            i6 = 4;
        }
    }

    public final void p() {
        LinkedList linkedList;
        LinkedList linkedList2;
        long j5;
        ArrayList arrayList = this.f6823s;
        String[] strArr = {f6817w, y};
        this.o = new ArrayList();
        int i = 0;
        while (true) {
            int i6 = 1;
            if (i >= 2) {
                break;
            }
            String str = strArr[i];
            o(new File(str), 1, true, this.o);
            File file = new File(str);
            C2089j c2089j = new C2089j(this);
            c2089j.f6814a = str;
            c2089j.b = new C2089j(this);
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                c2089j.d = fileArrListFiles.length;
                LinkedList linkedList3 = new LinkedList();
                linkedList3.offer(c2089j);
                while (!linkedList3.isEmpty()) {
                    int size = linkedList3.size();
                    int i10 = 0;
                    while (i10 < size) {
                        C2089j c2089j2 = (C2089j) linkedList3.poll();
                        if (c2089j2 == null) {
                            linkedList = linkedList3;
                        } else {
                            String str2 = c2089j2.f6814a;
                            File file2 = new File(str2);
                            if (!file2.exists() || this.f6822r.contains(str2)) {
                                linkedList = linkedList3;
                                c2089j2.b.d--;
                            } else {
                                if (file2.isFile()) {
                                    long length = file2.length();
                                    if (length <= 0 || length > 68719476736L) {
                                        j5 = 62899200000L;
                                    } else {
                                        j5 = 62899200000L;
                                        if (this.f6824t == null) {
                                            this.f6824t = new B1.b(this.l);
                                        }
                                        this.f6824t.g(new C2088i(str2, length, i6));
                                    }
                                    C2089j c2089j3 = c2089j2.b;
                                    if (c2089j3 != null) {
                                        c2089j3.a(length);
                                        if (!c2089j2.b.f) {
                                            long jCurrentTimeMillis = System.currentTimeMillis() - file2.lastModified();
                                            long j6 = (jCurrentTimeMillis < this.m || jCurrentTimeMillis >= j5) ? 0L : jCurrentTimeMillis;
                                            if (j6 > 0) {
                                                m(0, str2, length, j6);
                                            }
                                        }
                                    }
                                } else {
                                    File[] fileArrListFiles2 = file2.listFiles();
                                    if (fileArrListFiles2 == null || fileArrListFiles2.length == 0) {
                                        linkedList = linkedList3;
                                        c2089j2.b.a(0L);
                                    } else {
                                        c2089j2.d = fileArrListFiles2.length;
                                        int length2 = fileArrListFiles2.length;
                                        int i11 = 0;
                                        while (i11 < length2) {
                                            File file3 = fileArrListFiles2[i11];
                                            C2089j c2089j4 = new C2089j(this);
                                            c2089j4.b = c2089j2;
                                            c2089j4.f6814a = file3.getAbsolutePath();
                                            if (!file3.isDirectory() || c2089j2.f) {
                                                linkedList2 = linkedList3;
                                            } else {
                                                long jCurrentTimeMillis2 = System.currentTimeMillis() - file3.lastModified();
                                                linkedList2 = linkedList3;
                                                long j10 = (jCurrentTimeMillis2 < this.m || jCurrentTimeMillis2 >= 62899200000L) ? 0L : jCurrentTimeMillis2;
                                                if (j10 > 0) {
                                                    c2089j4.f = true;
                                                    c2089j4.g = j10;
                                                }
                                            }
                                            linkedList2.offer(c2089j4);
                                            i11++;
                                            linkedList3 = linkedList2;
                                        }
                                    }
                                }
                                linkedList = linkedList3;
                            }
                        }
                        i10++;
                        linkedList3 = linkedList;
                        i6 = 1;
                    }
                }
            }
            i++;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            o(new File((String) it.next()), 1, false, this.o);
        }
    }
}
