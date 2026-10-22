package com.tencent.bugly.proguard;

import V7.a;
import Z7.C1130b;
import Z7.C1131c;
import Z7.C1133e;
import Z7.C1136h;
import Z7.C1139k;
import Z7.C1140l;
import Z7.C1143o;
import Z7.C1145q;
import Z7.InterfaceC1135g;
import Z7.O;
import Z7.V;
import Z7.X;
import Z7.r;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class as {

    /* renamed from: e, reason: collision with root package name */
    public static int f31557e;

    /* renamed from: f, reason: collision with root package name */
    public static final Map<Integer, Pair<String, String>> f31558f = new HashMap<Integer, Pair<String, String>>() { // from class: com.tencent.bugly.proguard.as.1
        {
            put(3, new Pair("203", "103"));
            put(7, new Pair("208", "108"));
            put(0, new Pair("200", "100"));
            put(1, new Pair("201", "101"));
            put(2, new Pair("202", "102"));
            put(4, new Pair("204", "104"));
            put(6, new Pair("206", "106"));
            put(5, new Pair("207", "107"));
        }
    };

    /* renamed from: g, reason: collision with root package name */
    public static final ArrayList<b> f31559g = new ArrayList<b>() { // from class: com.tencent.bugly.proguard.as.2
        {
            byte b10 = 0;
            add(new c(b10));
            add(new d(b10));
            add(new e(b10));
            add(new f(b10));
            add(new i(b10));
            add(new j(b10));
            add(new g(b10));
            add(new h(b10));
        }
    };

    /* renamed from: h, reason: collision with root package name */
    public static final Map<Integer, Integer> f31560h = new HashMap<Integer, Integer>() { // from class: com.tencent.bugly.proguard.as.3
        {
            put(3, 4);
            put(7, 7);
            put(2, 1);
            put(0, 0);
            put(1, 2);
            put(4, 3);
            put(5, 5);
            put(6, 6);
        }
    };

    /* renamed from: i, reason: collision with root package name */
    public static final Map<Integer, String> f31561i = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.as.4
        {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    };

    /* renamed from: j, reason: collision with root package name */
    public static final Map<Integer, String> f31562j = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.as.5
        {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Context f31563a;

    /* renamed from: b, reason: collision with root package name */
    public final C1136h f31564b;

    /* renamed from: c, reason: collision with root package name */
    public final V f31565c;

    /* renamed from: d, reason: collision with root package name */
    public final C1131c f31566d;

    public class a implements InterfaceC1135g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f31567a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f31568b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f31569c;

        public a(long j10, List list, boolean z10) {
            this.f31567a = j10;
            this.f31568b = list;
            this.f31569c = z10;
        }

        @Override // Z7.InterfaceC1135g
        public final void a(boolean z10, String str) {
            as.s(this.f31568b, z10, System.currentTimeMillis() - this.f31567a, this.f31569c ? "realtime" : "cache", str);
            as.u(z10, this.f31568b);
        }
    }

    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f31571a;

        public /* synthetic */ b(int i10, byte b10) {
            this(i10);
        }

        public b(int i10) {
            this.f31571a = i10;
        }
    }

    public static class c extends b {
        public /* synthetic */ c(byte b10) {
            this();
        }

        public c() {
            super(3, (byte) 0);
        }
    }

    public static class d extends b {
        public /* synthetic */ d(byte b10) {
            this();
        }

        public d() {
            super(7, (byte) 0);
        }
    }

    public static class e extends b {
        public /* synthetic */ e(byte b10) {
            this();
        }

        public e() {
            super(2, (byte) 0);
        }
    }

    public static class f extends b {
        public /* synthetic */ f(byte b10) {
            this();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public f() {
            byte b10 = 0;
            super(b10, b10);
        }
    }

    public static class g extends b {
        public /* synthetic */ g(byte b10) {
            this();
        }

        public g() {
            super(5, (byte) 0);
        }
    }

    public static class h extends b {
        public /* synthetic */ h(byte b10) {
            this();
        }

        public h() {
            super(6, (byte) 0);
        }
    }

    public static class i extends b {
        public /* synthetic */ i(byte b10) {
            this();
        }

        public i() {
            super(1, (byte) 0);
        }
    }

    public static class j extends b {
        public /* synthetic */ j(byte b10) {
            this();
        }

        public j() {
            super(4, (byte) 0);
        }
    }

    public as(Context context, C1136h c1136h, V v10, C1131c c1131c, a.C0112a c0112a) {
        f31557e = 1004;
        this.f31563a = context;
        this.f31564b = c1136h;
        this.f31565c = v10;
        this.f31566d = c1131c;
    }

    public static void B(CrashDetailBean crashDetailBean, List<C1145q> list) {
        StringBuilder sb2 = new StringBuilder(64);
        for (C1145q c1145q : list) {
            if (!c1145q.f7578e && !c1145q.f7577d) {
                String str = crashDetailBean.f31515s;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(c1145q.f7575b);
                if (!str.contains(sb3.toString())) {
                    crashDetailBean.f31516t++;
                    sb2.append(c1145q.f7575b);
                    sb2.append("\n");
                }
            }
        }
        crashDetailBean.f31515s += sb2.toString();
    }

    public static void D(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        String str;
        if (crashDetailBean.f31498b == 1 && (str = crashDetailBean.f31518v) != null) {
            try {
                bn bnVarC = c("tomb.zip", context, str);
                if (bnVarC != null) {
                    C1139k.h("attach tombs", new Object[0]);
                    arrayList.add(bnVarC);
                }
            } catch (Exception e10) {
                C1139k.e(e10);
            }
        }
    }

    public static void E(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e10) {
                e10.printStackTrace();
                C1139k.e(e10);
            }
        }
    }

    public static void F(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            arrayList.add(new bn((byte) 1, "userExtraByteData", bArr));
            C1139k.h("attach extraData", new Object[0]);
        } catch (Exception e10) {
            C1139k.e(e10);
        }
    }

    public static void G(List<C1145q> list) {
        List<CrashDetailBean> listJ = J(list);
        if (listJ == null || listJ.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : listJ) {
            String str = f31562j.get(Integer.valueOf(crashDetailBean.f31498b));
            if (!TextUtils.isEmpty(str)) {
                C1139k.h("find expired data,crashId:%s eventType:%s", crashDetailBean.f31499c, str);
                arrayList.add(new a.d(crashDetailBean.f31499c, str, crashDetailBean.f31514r, false, 0L, "expired", null));
            }
        }
        a.b.f31543a.d(arrayList);
    }

    public static ContentValues I(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = crashDetailBean.f31496a;
            if (j10 > 0) {
                contentValues.put(StepOSRecipientEmailHistory._ID, Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f31514r));
            contentValues.put("_s1", crashDetailBean.f31517u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f31500d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.f31506j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f31508l));
            contentValues.put("_dt", C1143o.w(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static List<CrashDetailBean> J(List<C1145q> list) {
        Cursor cursorJ;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id in (");
        Iterator<C1145q> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().f7574a);
            sb2.append(Const.STR_MART_COMMA);
        }
        if (sb2.toString().contains(Const.STR_MART_COMMA)) {
            sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(Const.STR_MART_COMMA)));
        }
        sb2.append(")");
        String string = sb2.toString();
        sb2.setLength(0);
        try {
            cursorJ = V.f().j("t_cr", null, string);
            if (cursorJ == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb2.append("_id in (");
                int i10 = 0;
                while (cursorJ.moveToNext()) {
                    CrashDetailBean crashDetailBeanA = a(cursorJ);
                    if (crashDetailBeanA != null) {
                        arrayList.add(crashDetailBeanA);
                    } else {
                        try {
                            sb2.append(cursorJ.getLong(cursorJ.getColumnIndex(StepOSRecipientEmailHistory._ID)));
                            sb2.append(Const.STR_MART_COMMA);
                            i10++;
                        } catch (Throwable unused) {
                            C1139k.i("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb2.toString().contains(Const.STR_MART_COMMA)) {
                    sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(Const.STR_MART_COMMA)));
                }
                sb2.append(")");
                String string2 = sb2.toString();
                if (i10 > 0) {
                    C1139k.i("deleted %s illegal data %d", "t_cr", Integer.valueOf(V.f().b("t_cr", string2)));
                }
                cursorJ.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C1139k.e(th)) {
                        th.printStackTrace();
                    }
                    if (cursorJ != null) {
                        cursorJ.close();
                    }
                    return null;
                } finally {
                    if (cursorJ != null) {
                        cursorJ.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorJ = null;
        }
    }

    public static void K(ArrayList<bn> arrayList, String str) {
        if (C1143o.G(str)) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
            C1139k.h("attach crash infos", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e10) {
            e10.printStackTrace();
            C1139k.e(e10);
        }
    }

    public static void L(List<C1145q> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id in (");
        Iterator<C1145q> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().f7574a);
            sb2.append(Const.STR_MART_COMMA);
        }
        StringBuilder sb3 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(Const.STR_MART_COMMA)));
        sb3.append(")");
        String string = sb3.toString();
        sb3.setLength(0);
        try {
            C1139k.h("deleted %s data %d", "t_cr", Integer.valueOf(V.f().b("t_cr", string)));
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static String N(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = f31558f.get(Integer.valueOf(crashDetailBean.f31498b));
            if (pair != null) {
                return crashDetailBean.f31506j ? (String) pair.first : (String) pair.second;
            }
            C1139k.j("crash type error! %d", Integer.valueOf(crashDetailBean.f31498b));
            return "";
        } catch (Exception e10) {
            C1139k.e(e10);
            return "";
        }
    }

    public static void O(List<CrashDetailBean> list) {
        try {
            if (list.size() == 0) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            for (CrashDetailBean crashDetailBean : list) {
                sb2.append(" or _id = ");
                sb2.append(crashDetailBean.f31496a);
            }
            String string = sb2.toString();
            if (string.length() > 0) {
                string = string.substring(4);
            }
            sb2.setLength(0);
            C1139k.h("deleted %s data %d", "t_cr", Integer.valueOf(V.f().b("t_cr", string)));
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j10 = cursor.getLong(cursor.getColumnIndex(StepOSRecipientEmailHistory._ID));
            CrashDetailBean crashDetailBean = (CrashDetailBean) C1143o.e(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean == null) {
                return crashDetailBean;
            }
            crashDetailBean.f31496a = j10;
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static CrashDetailBean b(List<C1145q> list, CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2;
        List<CrashDetailBean> listJ;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        ArrayList arrayList = new ArrayList(10);
        for (C1145q c1145q : list) {
            if (c1145q.f7578e) {
                arrayList.add(c1145q);
            }
        }
        if (arrayList.isEmpty() || (listJ = J(arrayList)) == null || listJ.isEmpty()) {
            crashDetailBean2 = null;
        } else {
            Collections.sort(listJ);
            crashDetailBean2 = listJ.get(0);
            j(crashDetailBean2, listJ);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f31506j = true;
            crashDetailBean.f31516t = 0;
            crashDetailBean.f31515s = "";
            crashDetailBean2 = crashDetailBean;
        }
        B(crashDetailBean2, list);
        if (crashDetailBean2.f31514r != crashDetailBean.f31514r) {
            String str = crashDetailBean2.f31515s;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f31514r);
            if (!str.contains(sb2.toString())) {
                crashDetailBean2.f31516t++;
                crashDetailBean2.f31515s += crashDetailBean.f31514r + "\n";
            }
        }
        return crashDetailBean2;
    }

    public static bn c(String str, Context context, String str2) throws IOException {
        FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            C1139k.i("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        C1139k.h("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (!C1143o.u(file, file2)) {
            C1139k.i("zip fail!", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file2);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i10 = fileInputStream.read(bArr);
                if (i10 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i10);
                byteArrayOutputStream.flush();
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            C1139k.h("read bytes :%d", Integer.valueOf(byteArray.length));
            bn bnVar = new bn((byte) 2, file2.getName(), byteArray);
            try {
                fileInputStream.close();
            } catch (IOException e10) {
                if (!C1139k.e(e10)) {
                    e10.printStackTrace();
                }
            }
            if (file2.exists()) {
                C1139k.h("del tmp", new Object[0]);
                file2.delete();
            }
            return bnVar;
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e11) {
                        if (!C1139k.e(e11)) {
                            e11.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    C1139k.h("del tmp", new Object[0]);
                    file2.delete();
                }
                return null;
            } catch (Throwable th3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e12) {
                        if (!C1139k.e(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    C1139k.h("del tmp", new Object[0]);
                    file2.delete();
                }
                throw th3;
            }
        }
    }

    public static bo d(Context context, CrashDetailBean crashDetailBean, C1130b c1130b) {
        ArrayList<bl> arrayList = null;
        if (context == null || crashDetailBean == null || c1130b == null) {
            C1139k.i("enExp args == null", new Object[0]);
            return null;
        }
        bo boVar = new bo();
        boVar.f31592a = N(crashDetailBean);
        boVar.f31593b = crashDetailBean.f31514r;
        boVar.f31594c = crashDetailBean.f31510n;
        boVar.f31595d = crashDetailBean.f31511o;
        boVar.f31596e = crashDetailBean.f31512p;
        boVar.f31598g = crashDetailBean.f31513q;
        boVar.f31599h = crashDetailBean.f31522z;
        boVar.f31600i = crashDetailBean.f31499c;
        boVar.f31601j = null;
        boVar.f31603l = crashDetailBean.f31509m;
        boVar.f31604m = crashDetailBean.f31501e;
        boVar.f31597f = crashDetailBean.f31471B;
        boVar.f31605n = null;
        Map<String, PlugInBean> map = crashDetailBean.f31504h;
        if (map != null && !map.isEmpty()) {
            arrayList = new ArrayList<>(crashDetailBean.f31504h.size());
            for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f31504h.entrySet()) {
                bl blVar = new bl();
                blVar.f31572a = entry.getValue().f31444a;
                blVar.f31574c = entry.getValue().f31446c;
                blVar.f31576e = entry.getValue().f31445b;
                arrayList.add(blVar);
            }
        }
        boVar.f31607p = arrayList;
        C1139k.h("libInfo %s", boVar.f31606o);
        ArrayList<bn> arrayList2 = new ArrayList<>(20);
        l(arrayList2, crashDetailBean);
        n(arrayList2, crashDetailBean.f31519w);
        E(arrayList2, crashDetailBean.f31520x);
        K(arrayList2, crashDetailBean.f31495Z);
        o(arrayList2, crashDetailBean.f31497aa, context);
        q(arrayList2, crashDetailBean.f31521y);
        m(arrayList2, crashDetailBean, context);
        D(arrayList2, crashDetailBean, context);
        p(arrayList2, c1130b.f7460h0);
        F(arrayList2, crashDetailBean.f31494Y);
        boVar.f31608q = arrayList2;
        if (crashDetailBean.f31506j) {
            boVar.f31602k = crashDetailBean.f31516t;
        }
        boVar.f31609r = h(crashDetailBean, c1130b);
        boVar.f31610s = new HashMap();
        Map<String, String> map2 = crashDetailBean.f31488S;
        if (map2 != null && map2.size() > 0) {
            boVar.f31610s.putAll(crashDetailBean.f31488S);
            C1139k.d("setted message size %d", Integer.valueOf(boVar.f31610s.size()));
        }
        Map<String, String> map3 = boVar.f31610s;
        C1139k.h("pss:" + crashDetailBean.f31478I + " vss:" + crashDetailBean.f31479J + " javaHeap:" + crashDetailBean.f31480K, new Object[0]);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(crashDetailBean.f31478I);
        map3.put("SDK_UPLOAD_U1", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(crashDetailBean.f31479J);
        map3.put("SDK_UPLOAD_U2", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(crashDetailBean.f31480K);
        map3.put("SDK_UPLOAD_U3", sb4.toString());
        C1139k.h("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", crashDetailBean.f31510n, crashDetailBean.f31499c, c1130b.p(), Long.valueOf((crashDetailBean.f31514r - crashDetailBean.f31486Q) / 1000), Boolean.valueOf(crashDetailBean.f31507k), Boolean.valueOf(crashDetailBean.f31487R), Boolean.valueOf(crashDetailBean.f31506j), Boolean.valueOf(crashDetailBean.f31498b == 1), Integer.valueOf(crashDetailBean.f31516t), crashDetailBean.f31515s, Boolean.valueOf(crashDetailBean.f31500d), Integer.valueOf(boVar.f31609r.size()));
        return boVar;
    }

    public static bp e(Context context, List<CrashDetailBean> list, C1130b c1130b) {
        if (context == null || list == null || list.size() == 0 || c1130b == null) {
            C1139k.i("enEXPPkg args == null!", new Object[0]);
            return null;
        }
        bp bpVar = new bp();
        bpVar.f31614a = new ArrayList<>();
        Iterator<CrashDetailBean> it = list.iterator();
        while (it.hasNext()) {
            bpVar.f31614a.add(d(context, it.next(), c1130b));
        }
        return bpVar;
    }

    public static List<CrashDetailBean> f() {
        StrategyBean strategyBeanI = C1131c.a().i();
        if (strategyBeanI == null) {
            C1139k.i("have not synced remote!", new Object[0]);
            return null;
        }
        if (!strategyBeanI.f31452f) {
            C1139k.i("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            C1139k.f("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jZ = C1143o.z();
        List<C1145q> listZ = z();
        C1139k.h("Size of crash list loaded from DB: %s", Integer.valueOf(listZ.size()));
        if (listZ.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.addAll(g(listZ));
        listZ.removeAll(arrayList);
        Iterator<C1145q> it = listZ.iterator();
        while (it.hasNext()) {
            C1145q next = it.next();
            long j10 = next.f7575b;
            if (j10 < jZ - r.f7587q) {
                arrayList2.add(next);
                it.remove();
                arrayList.add(next);
            } else if (next.f7577d) {
                if (j10 >= jCurrentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f7578e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f7579f >= 3 && j10 < jCurrentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        G(arrayList2);
        if (arrayList.size() > 0) {
            L(arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        List<CrashDetailBean> listJ = J(listZ);
        if (listJ != null && listJ.size() > 0) {
            String str = C1130b.l().f7422D;
            Iterator<CrashDetailBean> it2 = listJ.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f31502f)) {
                    it2.remove();
                    arrayList3.add(next2);
                }
            }
        }
        if (arrayList3.size() > 0) {
            O(arrayList3);
        }
        return listJ;
    }

    public static List<C1145q> g(List<C1145q> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (C1145q c1145q : list) {
            if (c1145q.f7577d && c1145q.f7575b <= jCurrentTimeMillis - 86400000) {
                arrayList.add(c1145q);
            }
        }
        return arrayList;
    }

    public static Map<String, String> h(CrashDetailBean crashDetailBean, C1130b c1130b) {
        HashMap map = new HashMap(30);
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f31472C);
            map.put("A9", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.f31473D);
            map.put("A11", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(crashDetailBean.f31474E);
            map.put("A10", sb4.toString());
            map.put("A23", crashDetailBean.f31502f);
            StringBuilder sb5 = new StringBuilder();
            c1130b.getClass();
            map.put("A7", sb5.toString());
            map.put("A6", C1130b.B());
            map.put("A5", c1130b.A());
            map.put("A22", c1130b.u());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.f31476G);
            map.put("A2", sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.f31475F);
            map.put("A1", sb7.toString());
            map.put("A24", c1130b.f7471n);
            StringBuilder sb8 = new StringBuilder();
            sb8.append(crashDetailBean.f31477H);
            map.put("A17", sb8.toString());
            map.put("A25", c1130b.u());
            map.put("A15", c1130b.E());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(c1130b.F());
            map.put("A13", sb9.toString());
            map.put("A34", crashDetailBean.f31470A);
            if (c1130b.f7450c0 != null) {
                map.put("productIdentify", c1130b.f7450c0);
            }
            map.put("A26", URLEncoder.encode(crashDetailBean.f31481L, "utf-8"));
            if (crashDetailBean.f31498b == 1) {
                map.put("A27", crashDetailBean.f31484O);
                map.put("A28", crashDetailBean.f31483N);
                StringBuilder sb10 = new StringBuilder();
                sb10.append(crashDetailBean.f31507k);
                map.put("A29", sb10.toString());
            }
            map.put("A30", crashDetailBean.f31485P);
            StringBuilder sb11 = new StringBuilder();
            sb11.append(crashDetailBean.f31486Q);
            map.put("A18", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(true ^ crashDetailBean.f31487R);
            map.put("A36", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(c1130b.f7440V);
            map.put("F02", sb13.toString());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(c1130b.f7441W);
            map.put("F03", sb14.toString());
            map.put("F04", c1130b.p());
            StringBuilder sb15 = new StringBuilder();
            sb15.append(c1130b.f7442X);
            map.put("F05", sb15.toString());
            map.put("F06", c1130b.f7439U);
            map.put("F08", c1130b.f7446a0);
            map.put("F09", c1130b.f7448b0);
            StringBuilder sb16 = new StringBuilder();
            sb16.append(c1130b.f7443Y);
            map.put("F10", sb16.toString());
            t(map, crashDetailBean);
            return map;
        } catch (Exception e10) {
            e10.printStackTrace();
            C1139k.e(e10);
            return map;
        }
    }

    public static void j(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] strArrSplit;
        StringBuilder sb2 = new StringBuilder(128);
        for (int i10 = 1; i10 < list.size(); i10++) {
            String str = list.get(i10).f31515s;
            if (str != null && (strArrSplit = str.split("\n")) != null) {
                for (String str2 : strArrSplit) {
                    if (!crashDetailBean.f31515s.contains(str2)) {
                        crashDetailBean.f31516t++;
                        sb2.append(str2);
                        sb2.append("\n");
                    }
                }
            }
        }
        crashDetailBean.f31515s += sb2.toString();
    }

    public static void k(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        C1130b c1130bL = C1130b.l();
        if (c1130bL == null) {
            return;
        }
        C1139k.j("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        C1139k.j("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        C1139k.j("# PKG NAME: %s", c1130bL.f7453e);
        C1139k.j("# APP VER: %s", c1130bL.f7422D);
        C1139k.j("# SDK VER: %s", c1130bL.f7463j);
        C1139k.j("# LAUNCH TIME: %s", C1143o.m(new Date(C1130b.l().f7449c)));
        C1139k.j("# CRASH TYPE: %s", str);
        C1139k.j("# CRASH TIME: %s", str2);
        C1139k.j("# CRASH PROCESS: %s", str3);
        C1139k.j("# CRASH FOREGROUND: %s", Boolean.valueOf(c1130bL.k()));
        C1139k.j("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            C1139k.j("# REPORT ID: %s", crashDetailBean.f31499c);
            C1139k.j("# CRASH DEVICE: %s %s", c1130bL.v(), c1130bL.F().booleanValue() ? "ROOTED" : "UNROOT");
            C1139k.j("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f31472C), Long.valueOf(crashDetailBean.f31473D), Long.valueOf(crashDetailBean.f31474E));
            C1139k.j("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f31475F), Long.valueOf(crashDetailBean.f31476G), Long.valueOf(crashDetailBean.f31477H));
            if (!C1143o.G(crashDetailBean.f31484O)) {
                C1139k.j("# EXCEPTION FIRED BY %s %s", crashDetailBean.f31484O, crashDetailBean.f31483N);
            } else if (crashDetailBean.f31498b == 3) {
                if (crashDetailBean.f31489T == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.f31489T.get("BUGLY_CR_01");
                }
                C1139k.j("# EXCEPTION ANR MESSAGE:\n %s", str6);
            }
        }
        if (!C1143o.G(str5)) {
            C1139k.j("# CRASH STACK: ", new Object[0]);
            C1139k.j(str5, new Object[0]);
        }
        C1139k.j("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    public static void l(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean) {
        String str;
        if (crashDetailBean.f31506j && (str = crashDetailBean.f31515s) != null && str.length() > 0) {
            try {
                arrayList.add(new bn((byte) 1, "alltimes.txt", crashDetailBean.f31515s.getBytes("utf-8")));
            } catch (Exception e10) {
                e10.printStackTrace();
                C1139k.e(e10);
            }
        }
    }

    public static void m(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        bn bnVarC;
        if (crashDetailBean.f31498b != 3) {
            return;
        }
        C1139k.h("crashBean.anrMessages:%s", crashDetailBean.f31489T);
        try {
            Map<String, String> map = crashDetailBean.f31489T;
            if (map != null && map.containsKey("BUGLY_CR_01")) {
                if (!TextUtils.isEmpty(crashDetailBean.f31489T.get("BUGLY_CR_01"))) {
                    arrayList.add(new bn((byte) 1, "anrMessage.txt", crashDetailBean.f31489T.get("BUGLY_CR_01").getBytes("utf-8")));
                    C1139k.h("attach anr message", new Object[0]);
                }
                crashDetailBean.f31489T.remove("BUGLY_CR_01");
            }
            String str = crashDetailBean.f31518v;
            if (str == null || (bnVarC = c("trace.zip", context, str)) == null) {
                return;
            }
            C1139k.h("attach traces", new Object[0]);
            arrayList.add(bnVarC);
        } catch (Exception e10) {
            e10.printStackTrace();
            C1139k.e(e10);
        }
    }

    public static void n(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e10) {
                e10.printStackTrace();
                C1139k.e(e10);
            }
        }
    }

    public static void o(ArrayList<bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                bn bnVarC = c("backupRecord.zip", context, str);
                if (bnVarC != null) {
                    C1139k.h("attach backup record", new Object[0]);
                    arrayList.add(bnVarC);
                }
            } catch (Exception e10) {
                C1139k.e(e10);
            }
        }
    }

    public static void p(ArrayList<bn> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
        }
        try {
            arrayList.add(new bn((byte) 1, "martianlog.txt", sb2.toString().getBytes("utf-8")));
            C1139k.h("attach pageTracingList", new Object[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void q(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 2, "buglylog.zip", bArr);
            C1139k.h("attach user log", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e10) {
            C1139k.e(e10);
        }
    }

    public static /* synthetic */ void s(List list, boolean z10, long j10, String str, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
            String str3 = f31562j.get(Integer.valueOf(crashDetailBean.f31498b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new a.d(crashDetailBean.f31499c, str3, crashDetailBean.f31514r, z10, j10, str, str2));
            }
        }
        a.b.f31543a.d(arrayList);
    }

    public static void t(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.f31490U >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f31490U);
            map.put("C01", sb2.toString());
        }
        if (crashDetailBean.f31491V >= 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.f31491V);
            map.put("C02", sb3.toString());
        }
        Map<String, String> map2 = crashDetailBean.f31492W;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.f31492W.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.f31493X;
        if (map3 == null || map3.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.f31493X.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }

    public static void u(boolean z10, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            C1139k.h("up finish update state %b", Boolean.valueOf(z10));
            for (CrashDetailBean crashDetailBean : list) {
                C1139k.h("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f31499c, Integer.valueOf(crashDetailBean.f31508l), Boolean.valueOf(crashDetailBean.f31500d), Boolean.valueOf(crashDetailBean.f31506j));
                int i10 = crashDetailBean.f31508l + 1;
                crashDetailBean.f31508l = i10;
                crashDetailBean.f31500d = z10;
                C1139k.h("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f31499c, Integer.valueOf(i10), Boolean.valueOf(crashDetailBean.f31500d), Boolean.valueOf(crashDetailBean.f31506j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                r.a().d(it.next());
            }
            C1139k.h("update state size %d", Integer.valueOf(list.size()));
        }
        if (z10) {
            return;
        }
        C1139k.f("[crash] upload fail.", new Object[0]);
    }

    public static boolean v(CrashDetailBean crashDetailBean, List<C1145q> list, List<C1145q> list2) {
        boolean z10 = false;
        for (C1145q c1145q : list) {
            if (crashDetailBean.f31517u.equals(c1145q.f7576c)) {
                if (c1145q.f7578e) {
                    z10 = true;
                }
                list2.add(c1145q);
            }
        }
        return z10;
    }

    public static boolean x(String str) {
        String str2 = r.f7595y;
        if (str2 != null && !str2.isEmpty()) {
            try {
                C1139k.h("Crash regular filter for crash stack is: %s", r.f7595y);
                if (Pattern.compile(r.f7595y).matcher(str).find()) {
                    C1139k.i("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e10) {
                C1139k.e(e10);
                C1139k.i("Failed to compile " + r.f7595y, new Object[0]);
            }
        }
        return false;
    }

    public static C1145q y(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C1145q c1145q = new C1145q();
            c1145q.f7574a = cursor.getLong(cursor.getColumnIndex(StepOSRecipientEmailHistory._ID));
            c1145q.f7575b = cursor.getLong(cursor.getColumnIndex("_tm"));
            c1145q.f7576c = cursor.getString(cursor.getColumnIndex("_s1"));
            c1145q.f7577d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            c1145q.f7578e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            c1145q.f7579f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return c1145q;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static List<C1145q> z() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor cursorJ = V.f().j("t_cr", new String[]{StepOSRecipientEmailHistory._ID, "_tm", "_s1", "_up", "_me", "_uc"}, null);
            if (cursorJ == null) {
                if (cursorJ != null) {
                    cursorJ.close();
                }
                return null;
            }
            try {
                if (cursorJ.getCount() <= 0) {
                    cursorJ.close();
                    return arrayList;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_id in (");
                int i10 = 0;
                while (cursorJ.moveToNext()) {
                    C1145q c1145qY = y(cursorJ);
                    if (c1145qY != null) {
                        arrayList.add(c1145qY);
                    } else {
                        try {
                            sb2.append(cursorJ.getLong(cursorJ.getColumnIndex(StepOSRecipientEmailHistory._ID)));
                            sb2.append(Const.STR_MART_COMMA);
                            i10++;
                        } catch (Throwable unused) {
                            C1139k.i("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb2.toString().contains(Const.STR_MART_COMMA)) {
                    sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(Const.STR_MART_COMMA)));
                }
                sb2.append(")");
                String string = sb2.toString();
                sb2.setLength(0);
                if (i10 > 0) {
                    C1139k.i("deleted %s illegal data %d", "t_cr", Integer.valueOf(V.f().b("t_cr", string)));
                }
                cursorJ.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = cursorJ;
                try {
                    if (!C1139k.e(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void A(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues contentValuesI = I(crashDetailBean);
        if (contentValuesI != null) {
            long jE = V.f().e("t_cr", contentValuesI, null);
            if (jE >= 0) {
                C1139k.h("insert %s success!", "t_cr");
                crashDetailBean.f31496a = jE;
            }
        }
        if (r.f7589s) {
            M(crashDetailBean);
        }
    }

    public final void C(CrashDetailBean crashDetailBean, boolean z10) {
        if (!r.f7592v) {
            C1139k.d("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
            return;
        }
        C1139k.d("try to upload right now", new Object[0]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(crashDetailBean);
        r(arrayList, 3000L, z10, crashDetailBean.f31498b == 7, z10);
    }

    public final boolean H(CrashDetailBean crashDetailBean, List<C1145q> list, List<C1145q> list2) {
        int i10 = crashDetailBean.f31498b;
        if (!(!O.f7341c ? ((i10 == 3) || (i10 == 0 || i10 == 1)) ? r.f7583m : true : false)) {
            return false;
        }
        ArrayList<C1145q> arrayList = new ArrayList(10);
        if (!v(crashDetailBean, list, arrayList)) {
            try {
                if (arrayList.size() >= r.f7582l) {
                }
            } catch (Exception e10) {
                C1139k.e(e10);
                C1139k.i("Failed to merge crash.", new Object[0]);
            }
            return false;
        }
        C1139k.d("same crash occur too much do merged!", new Object[0]);
        CrashDetailBean crashDetailBeanB = b(arrayList, crashDetailBean);
        for (C1145q c1145q : arrayList) {
            if (c1145q.f7574a != crashDetailBeanB.f31496a) {
                list2.add(c1145q);
            }
        }
        A(crashDetailBeanB);
        L(list2);
        C1139k.f("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
        return true;
    }

    public final boolean M(CrashDetailBean crashDetailBean) {
        String absolutePath;
        try {
            C1139k.h("save eup logs", new Object[0]);
            C1130b c1130bL = C1130b.l();
            String str = "#--------\npackage:" + c1130bL.r() + "\nversion:" + c1130bL.f7422D + "\nsdk:" + c1130bL.f7463j + "\nprocess:" + crashDetailBean.f31470A + "\ndate:" + C1143o.m(new Date(crashDetailBean.f31514r)) + "\ntype:" + crashDetailBean.f31510n + "\nmessage:" + crashDetailBean.f31511o + "\nstack:\n" + crashDetailBean.f31513q + "\neupID:" + crashDetailBean.f31499c + "\n";
            if (r.f7590t != null) {
                File file = new File(r.f7590t);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                absolutePath = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.f31563a.getPackageName();
            } else {
                absolutePath = null;
            }
            C1140l.f(absolutePath + "/euplog.txt", str, r.f7591u);
            return true;
        } catch (Throwable th) {
            C1139k.i("rqdp{  save error} %s", th.toString());
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final void i(CrashDetailBean crashDetailBean) {
        int i10 = crashDetailBean.f31498b;
        if (i10 == 0) {
            r.a().i();
        } else if (i10 == 1) {
            r.a().i();
        } else {
            if (i10 != 3) {
                return;
            }
            r.a().j();
        }
    }

    public final void r(List<CrashDetailBean> list, long j10, boolean z10, boolean z11, boolean z12) {
        if (!C1130b.h(this.f31563a).f7459h) {
            C1139k.i("warn: not upload process", new Object[0]);
            return;
        }
        C1136h c1136h = this.f31564b;
        if (c1136h == null) {
            C1139k.i("warn: upload manager is null", new Object[0]);
            return;
        }
        if (!z12 && !c1136h.r(r.f7580j)) {
            C1139k.i("warn: not crashHappen or not should upload", new Object[0]);
            return;
        }
        StrategyBean strategyBeanI = this.f31566d.i();
        if (!strategyBeanI.f31452f) {
            C1139k.i("remote report is disable!", new Object[0]);
            C1139k.f("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            return;
        }
        if (list == null || list.size() == 0) {
            C1139k.i("warn: crashList is null or crashList num is 0", new Object[0]);
            return;
        }
        try {
            String str = strategyBeanI.f31464r;
            String str2 = StrategyBean.f31448b;
            bp bpVarE = e(this.f31563a, list, C1130b.l());
            if (bpVarE == null) {
                C1139k.i("create eupPkg fail!", new Object[0]);
                return;
            }
            byte[] bArrE = C1133e.e(bpVarE);
            if (bArrE == null) {
                C1139k.i("send encode fail!", new Object[0]);
                return;
            }
            bq bqVarA = C1133e.a(this.f31563a, 830, bArrE);
            if (bqVarA == null) {
                C1139k.i("request package is null.", new Object[0]);
                return;
            }
            a aVar = new a(System.currentTimeMillis(), list, z10);
            if (z10) {
                this.f31564b.h(f31557e, bqVarA, str, str2, aVar, j10, z11);
            } else {
                this.f31564b.i(f31557e, bqVarA, str, str2, aVar, false);
            }
        } catch (Throwable th) {
            C1139k.j("req cr error %s", th.toString());
            if (C1139k.g(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final boolean w(CrashDetailBean crashDetailBean, boolean z10) {
        if (crashDetailBean == null) {
            C1139k.i("CrashBean is null, won't handle.", new Object[0]);
            return true;
        }
        A(crashDetailBean);
        if (!ab.u()) {
            crashDetailBean.f31519w = C1143o.g(r.f7584n, r.f7588r);
        }
        String str = crashDetailBean.f31513q;
        String str2 = r.f7594x;
        if (str2 != null && !str2.isEmpty()) {
            C1139k.h("Crash filter for crash stack is: %s", r.f7594x);
            if (str.contains(r.f7594x)) {
                C1139k.i("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (x(crashDetailBean.f31513q)) {
            return true;
        }
        if (crashDetailBean.f31498b != 2) {
            X x10 = new X();
            x10.f7409b = 1;
            x10.f7410c = crashDetailBean.f31470A;
            x10.f7411d = crashDetailBean.f31471B;
            x10.f7412e = crashDetailBean.f31514r;
            V.f().x(1);
            V.f().v(x10);
            C1139k.f("[crash] a crash occur, handling...", new Object[0]);
        } else {
            C1139k.f("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<C1145q> listZ = z();
        List<C1145q> arrayList = new ArrayList<>(10);
        if (listZ != null && listZ.size() > 0) {
            arrayList.addAll(g(listZ));
            listZ.removeAll(arrayList);
            if (listZ.size() > 20) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_id in (");
                sb2.append("SELECT _id FROM t_cr order by _id limit 5");
                sb2.append(")");
                String string = sb2.toString();
                sb2.setLength(0);
                try {
                    C1139k.h("deleted first record %s data %d", "t_cr", Integer.valueOf(V.f().b("t_cr", string)));
                } catch (Throwable th) {
                    if (!C1139k.e(th)) {
                        th.printStackTrace();
                    }
                }
            }
            if (H(crashDetailBean, listZ, arrayList)) {
                return true;
            }
        }
        A(crashDetailBean);
        String str3 = f31561i.get(Integer.valueOf(crashDetailBean.f31498b));
        if (!TextUtils.isEmpty(str3)) {
            a.b.f31543a.c(new a.d(crashDetailBean.f31499c, str3, crashDetailBean.f31514r, true, 0L, "realtime", null));
        }
        L(arrayList);
        C1139k.f("[crash] save crash success", new Object[0]);
        return false;
    }
}
