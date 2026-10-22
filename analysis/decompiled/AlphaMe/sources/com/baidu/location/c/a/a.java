package com.baidu.location.c.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.baidu.location.c.g;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.Consts;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class a implements com.baidu.location.c.b.a {

    /* renamed from: b, reason: collision with root package name */
    public static int f5558b;

    /* renamed from: w, reason: collision with root package name */
    private static Class<?> f5559w;

    /* renamed from: t, reason: collision with root package name */
    private C0010a f5585t;

    /* renamed from: u, reason: collision with root package name */
    private b f5586u;

    /* renamed from: v, reason: collision with root package name */
    private c f5587v;

    /* renamed from: x, reason: collision with root package name */
    private Context f5588x;

    /* renamed from: e, reason: collision with root package name */
    private int f5570e = 30;

    /* renamed from: f, reason: collision with root package name */
    private int f5571f = -1;

    /* renamed from: g, reason: collision with root package name */
    private AtomicInteger f5572g = new AtomicInteger(0);

    /* renamed from: h, reason: collision with root package name */
    private float f5573h = 0.2f;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5574i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5575j = false;

    /* renamed from: k, reason: collision with root package name */
    private TelephonyManager f5576k = null;

    /* renamed from: l, reason: collision with root package name */
    private TelephonyManager f5577l = null;

    /* renamed from: m, reason: collision with root package name */
    private TelephonyManager f5578m = null;

    /* renamed from: n, reason: collision with root package name */
    private SubscriptionManager f5579n = null;

    /* renamed from: o, reason: collision with root package name */
    private com.baidu.location.c.a f5580o = new com.baidu.location.c.a();

    /* renamed from: p, reason: collision with root package name */
    private com.baidu.location.c.a f5581p = null;

    /* renamed from: q, reason: collision with root package name */
    private List<com.baidu.location.c.a> f5582q = null;

    /* renamed from: r, reason: collision with root package name */
    private Executor f5583r = null;

    /* renamed from: s, reason: collision with root package name */
    private d f5584s = null;

    /* renamed from: y, reason: collision with root package name */
    private boolean f5589y = false;

    /* renamed from: a, reason: collision with root package name */
    public int f5569a = 0;

    /* renamed from: z, reason: collision with root package name */
    private boolean f5590z = false;

    /* renamed from: A, reason: collision with root package name */
    private long f5560A = 0;

    /* renamed from: B, reason: collision with root package name */
    private long f5561B = 0;

    /* renamed from: C, reason: collision with root package name */
    private boolean f5562C = false;

    /* renamed from: D, reason: collision with root package name */
    private boolean f5563D = true;

    /* renamed from: E, reason: collision with root package name */
    private boolean f5564E = false;

    /* renamed from: F, reason: collision with root package name */
    private Handler f5565F = null;

    /* renamed from: G, reason: collision with root package name */
    private int f5566G = -1;

    /* renamed from: H, reason: collision with root package name */
    private int f5567H = -1;

    /* renamed from: I, reason: collision with root package name */
    private final Object f5568I = new Object();

    /* renamed from: com.baidu.location.c.a.a$a, reason: collision with other inner class name */
    public class C0010a extends TelephonyManager.CellInfoCallback {
        private C0010a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            if (!com.baidu.location.c.b.a.f5617d || g.h().a(list)) {
                a.this.i();
            }
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onError(int i4, Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                g.h().a("cell onError = " + i4);
            }
        }
    }

    public class b extends TelephonyManager.CellInfoCallback {
        private b() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            boolean z4 = com.baidu.location.c.b.a.f5616c;
            if (z4 && com.baidu.location.c.b.a.f5617d) {
                g.h().a("onCellInfo");
            }
            if (list == null) {
                return;
            }
            boolean z5 = com.baidu.location.c.b.a.f5617d;
            if (!z5 || g.h().a(list)) {
                if (z4 && z5) {
                    g.h().a("request sim1 cellInfo");
                }
                if (a.this.f5562C) {
                    a.this.f5563D = !r4.f5563D;
                }
                if (!a.this.f5562C || a.this.f5563D) {
                    a.this.i();
                }
            }
        }
    }

    public class c extends TelephonyManager.CellInfoCallback {
        private c() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            boolean z4 = com.baidu.location.c.b.a.f5617d;
            if (!z4 || g.h().a(list)) {
                if (com.baidu.location.c.b.a.f5616c && z4) {
                    g.h().a("request sim2 cellInfo");
                }
                if (a.this.f5562C) {
                    a.this.f5563D = !r3.f5563D;
                }
                if (!a.this.f5562C || a.this.f5563D) {
                    a.this.i();
                }
            }
        }
    }

    public class d extends PhoneStateListener {
        public d() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            a.this.f5565F.post(new Runnable() { // from class: com.baidu.location.c.a.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                            g.h().a("cell received cellinfo change");
                        }
                        a.this.f();
                    } catch (Exception e4) {
                        if (com.baidu.location.c.b.a.f5616c) {
                            e4.printStackTrace();
                        }
                    }
                }
            });
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            com.baidu.location.c.a aVar;
            int cdmaDbm;
            if (a.this.f5580o != null) {
                if (a.this.f5580o.f5549i != 'g') {
                    if (a.this.f5580o.f5549i == 'c') {
                        aVar = a.this.f5580o;
                        cdmaDbm = signalStrength.getCdmaDbm();
                    }
                    if (com.baidu.location.c.b.a.f5616c || !com.baidu.location.c.b.a.f5617d) {
                    }
                    g.h().a("cell strength===== cell singal strength changed : " + a.this.f5580o.f5548h);
                    return;
                }
                aVar = a.this.f5580o;
                cdmaDbm = signalStrength.getGsmSignalStrength();
                aVar.f5548h = cdmaDbm;
                if (com.baidu.location.c.b.a.f5616c) {
                }
            }
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static a f5597a = new a();
    }

    private static int a(CellIdentityNr cellIdentityNr) {
        try {
            int iA = com.baidu.location.c.b.b.a(cellIdentityNr, "getHwTac");
            if (!com.baidu.location.c.b.a.f5616c || !com.baidu.location.c.b.a.f5617d) {
                return iA;
            }
            g.h().a(" get hw tac = " + iA);
            return iA;
        } catch (Throwable th) {
            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                g.h().a(" get hw tac exception !" + th);
            }
            return -1;
        }
    }

    private static int b(String str) {
        if (str == null || !str.contains("mNrTac")) {
            return -1;
        }
        Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(AwarenessDataItem.PERMISSION_SPLITTER, ""));
        while (true) {
            int i4 = -1;
            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    String strGroup = matcher.group(1);
                    if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                        g.h().a(" pasrse mnrtac = " + strGroup);
                    }
                    try {
                        i4 = Integer.parseInt(strGroup);
                    } catch (Throwable th) {
                        if (com.baidu.location.c.b.a.f5616c) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            return i4;
        }
    }

    private static int d(int i4) {
        if (i4 == Integer.MAX_VALUE) {
            return -1;
        }
        return i4;
    }

    private void h() throws IOException {
        List<com.baidu.location.c.a> list = this.f5582q;
        if (list == null && this.f5581p == null) {
            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                g.h().a("cellbuffer mTrackList == null");
                return;
            }
            return;
        }
        if (list == null && this.f5581p != null) {
            LinkedList linkedList = new LinkedList();
            this.f5582q = linkedList;
            linkedList.add(this.f5581p);
        }
        String strA = com.baidu.location.c.b.b.a(this.f5588x);
        if (strA == null || this.f5582q == null) {
            return;
        }
        File file = new File(B0.g.r(B0.g.s(strA), File.separator, "lcvif2.dat"));
        int size = this.f5582q.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(this.f5582q.get(size - 1).f5547g);
            randomAccessFile.writeInt(size);
            for (int i4 = 0; i4 < 3 - size; i4++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeLong(-1L);
                randomAccessFile.writeInt(2);
            }
            for (int i5 = 0; i5 < size; i5++) {
                randomAccessFile.writeLong(this.f5582q.get(i5).f5547g);
                randomAccessFile.writeInt(this.f5582q.get(i5).f5543c);
                randomAccessFile.writeInt(this.f5582q.get(i5).f5544d);
                randomAccessFile.writeInt(this.f5582q.get(i5).f5541a);
                randomAccessFile.writeLong(this.f5582q.get(i5).f5542b);
                if (this.f5582q.get(i5).f5549i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.f5582q.get(i5).f5549i == 'c') {
                    randomAccessFile.writeInt(2);
                } else {
                    randomAccessFile.writeInt(3);
                }
            }
            randomAccessFile.close();
        } catch (Exception e4) {
            if (com.baidu.location.c.b.a.f5616c) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f5565F.post(new Runnable() { // from class: com.baidu.location.c.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f();
                    synchronized (a.this.f5568I) {
                        try {
                            a.this.f5568I.notifyAll();
                            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                                g.h().a("update mCellInfo completed");
                            }
                        } finally {
                        }
                    }
                } catch (Exception e4) {
                    if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                        g.h().a("handleCellInfo error = " + e4);
                    }
                }
            }
        });
    }

    public com.baidu.location.c.a c(int i4) {
        com.baidu.location.c.a aVar;
        if (this.f5576k != null) {
            try {
                f();
                boolean z4 = com.baidu.location.c.b.a.f5616c;
                if (z4 && com.baidu.location.c.b.a.f5617d) {
                    g.h().a(" lastDiffTime = " + this.f5561B + ", diffTime = " + i4);
                }
                if (this.f5590z) {
                    if (i4 < Integer.MAX_VALUE) {
                        long j4 = i4;
                        if (j4 == this.f5561B) {
                            if (System.currentTimeMillis() - this.f5560A > j4) {
                                if (z4 && com.baidu.location.c.b.a.f5617d) {
                                    g.h().a(" over diff time");
                                }
                            }
                        } else if (z4 && com.baidu.location.c.b.a.f5617d) {
                            g.h().a("diff time is changed");
                        }
                        d();
                    }
                    this.f5561B = i4;
                }
            } catch (Exception e4) {
                if (com.baidu.location.c.b.a.f5616c) {
                    e4.printStackTrace();
                }
            }
        }
        com.baidu.location.c.a aVar2 = this.f5580o;
        if (aVar2 != null && aVar2.e()) {
            this.f5581p = null;
            this.f5581p = new com.baidu.location.c.a(this.f5580o);
        }
        com.baidu.location.c.a aVar3 = this.f5580o;
        if (aVar3 != null && aVar3.d() && (aVar = this.f5581p) != null) {
            com.baidu.location.c.a aVar4 = this.f5580o;
            if (aVar4.f5549i == 'g') {
                aVar4.f5544d = aVar.f5544d;
                aVar4.f5543c = aVar.f5543c;
            }
        }
        return this.f5580o;
    }

    private int a(String str) {
        if (str == null || !str.contains("cl_s2")) {
            return -1;
        }
        try {
            Matcher matcher = Pattern.compile("cl_s2=[0-9]{1,}").matcher(str);
            if (!matcher.find()) {
                return -1;
            }
            String strGroup = matcher.group();
            return Integer.parseInt(strGroup.substring(strGroup.indexOf("cl_s2=") + 6, strGroup.length()));
        } catch (Exception e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0115  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String d(com.baidu.location.c.a r13) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a.d(com.baidu.location.c.a):java.lang.String");
    }

    private String e(com.baidu.location.c.a aVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(aVar.f5549i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d&clp2=%d&cl_t2=%d", Integer.valueOf(aVar.f5543c), Integer.valueOf(aVar.f5544d), Integer.valueOf(aVar.f5541a), Long.valueOf(aVar.f5542b), Integer.valueOf(aVar.f5548h), Integer.valueOf(aVar.f5552l), Long.valueOf(aVar.f5547g)));
        if (aVar.f5550j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(aVar.f5550j);
        }
        if (aVar.f5556p != null) {
            stringBuffer.append("&clnrs2=");
            stringBuffer.append(aVar.f5556p);
        }
        return stringBuffer.toString();
    }

    private String f(com.baidu.location.c.a aVar) {
        return String.format(Locale.CHINA, "%d|%d|%d|%d", Integer.valueOf(aVar.f5543c), Integer.valueOf(aVar.f5544d), Integer.valueOf(aVar.f5541a), Long.valueOf(aVar.f5542b));
    }

    private void g() throws IOException {
        com.baidu.location.c.e eVarH;
        String str;
        String strA = com.baidu.location.c.b.b.a(this.f5588x);
        if (strA == null) {
            return;
        }
        File file = new File(B0.g.r(B0.g.s(strA), File.separator, "lcvif2.dat"));
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                long j4 = randomAccessFile.readLong();
                if (System.currentTimeMillis() - j4 > 60000) {
                    if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                        g.h().a("cellbuffer System.currentTimeMillis() - time > 1 *60 *1000" + j4);
                    }
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                for (int i4 = 0; i4 < 3; i4++) {
                    long j5 = randomAccessFile.readLong();
                    int i5 = randomAccessFile.readInt();
                    int i6 = randomAccessFile.readInt();
                    int i7 = randomAccessFile.readInt();
                    long j6 = randomAccessFile.readLong();
                    int i8 = randomAccessFile.readInt();
                    boolean z4 = com.baidu.location.c.b.a.f5616c;
                    if (z4 && com.baidu.location.c.b.a.f5617d) {
                        g.h().a("cellbuffer cell info = " + j5 + AwarenessDataItem.PERMISSION_SPLITTER + i5 + AwarenessDataItem.PERMISSION_SPLITTER + i6 + AwarenessDataItem.PERMISSION_SPLITTER + i7 + AwarenessDataItem.PERMISSION_SPLITTER + j6 + AwarenessDataItem.PERMISSION_SPLITTER + i8);
                    }
                    char c4 = i8 == 1 ? 'g' : (char) 0;
                    if (i8 == 2) {
                        c4 = 'c';
                    }
                    char c5 = c4;
                    if (j5 != 0) {
                        com.baidu.location.c.a aVar = new com.baidu.location.c.a(i7, j6, i5, i6, 0, c5, -1);
                        aVar.f5547g = j5;
                        if (aVar.b()) {
                            this.f5564E = true;
                            this.f5582q.add(aVar);
                        }
                        if (z4 && com.baidu.location.c.b.a.f5617d) {
                            eVarH = g.h();
                            str = "loc cell " + b(aVar);
                            eVarH.a(str);
                        }
                    } else if (z4 && com.baidu.location.c.b.a.f5617d) {
                        eVarH = g.h();
                        str = "loc cell time1 == 0";
                        eVarH.a(str);
                    }
                }
                randomAccessFile.close();
            } catch (Exception e4) {
                if (com.baidu.location.c.b.a.f5616c) {
                    e4.printStackTrace();
                }
                file.delete();
            }
        }
    }

    public com.baidu.location.c.a b(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        return a(aVar, telephonyManager);
    }

    public HashSet<String> c(com.baidu.location.c.a aVar) {
        com.baidu.location.c.a aVarA;
        StringBuilder sb;
        HashSet<String> hashSet = new HashSet<>();
        try {
            List<CellInfo> allCellInfo = this.f5576k.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                for (CellInfo cellInfo : allCellInfo) {
                    if (!cellInfo.isRegistered() && (aVarA = a(cellInfo, this.f5580o, this.f5576k)) != null) {
                        int i4 = aVarA.f5541a;
                        String string = "";
                        if (i4 != -1 && aVarA.f5542b != -1) {
                            if (aVar.f5541a != i4) {
                                sb = new StringBuilder();
                                sb.append(aVarA.f5541a);
                                sb.append(Consts.SPLITTER_DETAIL);
                                sb.append(aVarA.f5542b);
                            } else {
                                sb = new StringBuilder();
                                sb.append(aVarA.f5542b);
                                sb.append("");
                            }
                            string = sb.toString();
                        }
                        hashSet.add(string);
                    }
                }
            } else if (com.baidu.location.c.b.a.f5616c) {
                Log.d("getAllCellInfo", "=null");
            }
        } catch (Exception | NoSuchMethodError e4) {
            e4.printStackTrace();
        }
        return hashSet;
    }

    public static a a() {
        return e.f5597a;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1 A[Catch: Exception -> 0x0023, TryCatch #2 {Exception -> 0x0023, blocks: (B:6:0x0012, B:8:0x0016, B:11:0x0026, B:13:0x0036, B:15:0x0039, B:18:0x003f, B:20:0x0042, B:21:0x0044, B:23:0x004a, B:25:0x0050, B:27:0x0055, B:29:0x0059, B:31:0x005d, B:32:0x008c, B:34:0x0093, B:36:0x0097, B:37:0x009d, B:41:0x00ad, B:43:0x00b1, B:44:0x00b8, B:46:0x00bc, B:48:0x00c0, B:50:0x00c9, B:52:0x00cf, B:54:0x00d3, B:55:0x00d9, B:59:0x00e9, B:61:0x00ed, B:62:0x00f4, B:64:0x00f8, B:66:0x00fc, B:68:0x0105, B:56:0x00dc, B:58:0x00e0, B:67:0x0103, B:38:0x00a0, B:40:0x00a4, B:49:0x00c7, B:26:0x0053), top: B:100:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ed A[Catch: Exception -> 0x0023, TryCatch #2 {Exception -> 0x0023, blocks: (B:6:0x0012, B:8:0x0016, B:11:0x0026, B:13:0x0036, B:15:0x0039, B:18:0x003f, B:20:0x0042, B:21:0x0044, B:23:0x004a, B:25:0x0050, B:27:0x0055, B:29:0x0059, B:31:0x005d, B:32:0x008c, B:34:0x0093, B:36:0x0097, B:37:0x009d, B:41:0x00ad, B:43:0x00b1, B:44:0x00b8, B:46:0x00bc, B:48:0x00c0, B:50:0x00c9, B:52:0x00cf, B:54:0x00d3, B:55:0x00d9, B:59:0x00e9, B:61:0x00ed, B:62:0x00f4, B:64:0x00f8, B:66:0x00fc, B:68:0x0105, B:56:0x00dc, B:58:0x00e0, B:67:0x0103, B:38:0x00a0, B:40:0x00a4, B:49:0x00c7, B:26:0x0053), top: B:100:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a.d():void");
    }

    private void e() {
        if (this.f5585t == null) {
            this.f5585t = new C0010a();
        }
        Executor executor = this.f5583r;
        if (executor != null) {
            this.f5576k.requestCellInfoUpdate(executor, this.f5585t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        CellLocation cellLocation;
        try {
            com.baidu.location.c.a aVarA = a(this.f5580o, this.f5576k);
            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d && aVarA != null) {
                g.h().a("new cell api = " + f(aVarA));
            }
            if (aVarA != null) {
                g(aVarA);
            }
            int i4 = this.f5571f;
            if (i4 < 0 || Build.VERSION.SDK_INT <= i4) {
                if (aVarA == null || !aVarA.b()) {
                    try {
                        cellLocation = this.f5576k.getCellLocation();
                    } catch (Throwable unused) {
                        cellLocation = null;
                    }
                    com.baidu.location.c.a aVarA2 = cellLocation != null ? a(cellLocation) : null;
                    if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d && aVarA2 != null) {
                        g.h().a(" old cell api = " + f(aVarA2));
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String b(com.baidu.location.c.a aVar) {
        int i4;
        if (aVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.f5549i);
        Locale locale = Locale.CHINA;
        stringBuffer.append(String.format(locale, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.f5543c), Integer.valueOf(aVar.f5544d), Integer.valueOf(aVar.f5541a), Long.valueOf(aVar.f5542b), Integer.valueOf(aVar.f5548h)));
        if (aVar.f5545e < Integer.MAX_VALUE && (i4 = aVar.f5546f) < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(locale, "&cdmall=%.6f|%.6f", Double.valueOf(i4 / 14400.0d), Double.valueOf(aVar.f5545e / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.f5547g);
        stringBuffer.append("&cl_api=");
        stringBuffer.append(aVar.f5553m);
        stringBuffer.append("&clp=");
        stringBuffer.append(aVar.f5552l);
        if (aVar.f5556p != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(aVar.f5556p);
        }
        if (aVar.f5550j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(aVar.f5550j);
        }
        try {
            List<com.baidu.location.c.a> list = this.f5582q;
            if (list != null && list.size() > 0) {
                int size = this.f5582q.size();
                stringBuffer.append("&clt=");
                for (int i5 = 0; i5 < size; i5++) {
                    com.baidu.location.c.a aVar2 = this.f5582q.get(i5);
                    if (aVar2 != null) {
                        int i6 = aVar2.f5543c;
                        if (i6 != aVar.f5543c) {
                            stringBuffer.append(i6);
                        }
                        stringBuffer.append(Consts.SPLITTER_DETAIL);
                        int i7 = aVar2.f5544d;
                        if (i7 != aVar.f5544d) {
                            stringBuffer.append(i7);
                        }
                        stringBuffer.append(Consts.SPLITTER_DETAIL);
                        int i8 = aVar2.f5541a;
                        if (i8 != aVar.f5541a) {
                            stringBuffer.append(i8);
                        }
                        stringBuffer.append(Consts.SPLITTER_DETAIL);
                        long j4 = aVar2.f5542b;
                        if (j4 != aVar.f5542b) {
                            stringBuffer.append(j4);
                        }
                        stringBuffer.append(Consts.SPLITTER_DETAIL);
                        stringBuffer.append((System.currentTimeMillis() - aVar2.f5547g) / 1000);
                        stringBuffer.append(";");
                    }
                }
            }
        } catch (Exception e4) {
            if (com.baidu.location.c.b.a.f5616c) {
                e4.printStackTrace();
            }
        }
        if (this.f5569a > 100) {
            this.f5569a = 0;
        }
        int i9 = this.f5569a + (f5558b << 8);
        boolean z4 = com.baidu.location.c.b.a.f5616c;
        if (z4 && com.baidu.location.c.b.a.f5617d) {
            g.h().a("sim state:" + this.f5569a + "," + i9);
        }
        stringBuffer.append("&cs=" + i9);
        String str = aVar.f5554n;
        if (str != null) {
            stringBuffer.append(str);
        }
        if (z4 && com.baidu.location.c.b.a.f5617d) {
            g.h().a("cell sb.toString() = " + stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    public boolean c() {
        return this.f5564E;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|2|(3:4|(1:8)|9)(2:12|(15:14|(1:18)|19|(3:214|29|(3:42|(2:44|(2:48|28))|11)(4:35|(0)|(0)|11))(3:23|(2:27|28)|11)|(4:203|59|(3:61|(1:65)|68)(6:70|(7:72|(1:76)|77|(2:204|79)|85|(2:199|87)|93)(2:94|(7:206|96|(1:100)|104|106|(1:110)|(16:112|(2:208|114)|120|(2:201|122)|128|129|(4:210|131|(1:135)|138)|143|144|(4:197|146|(1:150)|153)|158|(1:162)|163|(1:165)|166|(1:168))))|66|67|170|(1:172))|69)|173|(1:175)|212|176|(1:180)|183|(1:185)|191|(1:195)|196)(2:49|(3:51|(1:55)|56)(12:57|(0)|173|(0)|212|176|(2:178|180)|183|(0)|191|(2:193|195)|196)))|10|11|(0)|173|(0)|212|176|(0)|183|(0)|191|(0)|196) */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x04b5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x04d8, code lost:
    
        if (com.baidu.location.c.b.a.f5616c != false) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x04da, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x04dd, code lost:
    
        r10.f5547g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x046f A[Catch: Error -> 0x04b5, TryCatch #8 {Error -> 0x04b5, blocks: (B:176:0x0462, B:178:0x046f, B:180:0x0473, B:183:0x04b7, B:185:0x04c0), top: B:212:0x0462 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04c0 A[Catch: Error -> 0x04b5, TRY_LEAVE, TryCatch #8 {Error -> 0x04b5, blocks: (B:176:0x0462, B:178:0x046f, B:180:0x0473, B:183:0x04b7, B:185:0x04c0), top: B:212:0x0462 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x01cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.baidu.location.c.a a(android.telephony.CellInfo r20, com.baidu.location.c.a r21, android.telephony.TelephonyManager r22) {
        /*
            Method dump skipped, instructions count: 1375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a.a(android.telephony.CellInfo, com.baidu.location.c.a, android.telephony.TelephonyManager):com.baidu.location.c.a");
    }

    public void b() {
        TelephonyManager telephonyManager;
        if (this.f5589y) {
            try {
                d dVar = this.f5584s;
                if (dVar != null && (telephonyManager = this.f5576k) != null) {
                    telephonyManager.listen(dVar, 0);
                }
                this.f5584s = null;
                this.f5576k = null;
                this.f5577l = null;
                this.f5578m = null;
                List<com.baidu.location.c.a> list = this.f5582q;
                if (list != null) {
                    list.clear();
                    this.f5582q = null;
                }
                if (this.f5575j) {
                    h();
                }
            } catch (Exception e4) {
                if (com.baidu.location.c.b.a.f5616c) {
                    e4.printStackTrace();
                }
            }
            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                g.h().a("cell manager stop ...");
            }
            this.f5589y = false;
        }
    }

    private com.baidu.location.c.a a(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    public void b(int i4) {
        this.f5570e = i4;
    }

    private com.baidu.location.c.a a(CellLocation cellLocation, boolean z4) throws IOException {
        int iIntValue;
        if (cellLocation == null || this.f5576k == null) {
            return null;
        }
        if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
            g.h().a("set cell info..");
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
        aVar.f5553m = 1;
        if (z4) {
            aVar.f5557q = true;
        }
        aVar.f5547g = System.currentTimeMillis();
        try {
            String networkOperator = this.f5576k.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    iIntValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.f5543c = iIntValue < 0 ? this.f5580o.f5543c : iIntValue;
                } else {
                    iIntValue = -1;
                }
                String strSubstring = networkOperator.substring(3);
                if (strSubstring != null) {
                    char[] charArray = strSubstring.toCharArray();
                    int i4 = 0;
                    while (i4 < charArray.length && Character.isDigit(charArray[i4])) {
                        i4++;
                    }
                    iIntValue = Integer.valueOf(strSubstring.substring(0, i4)).intValue();
                }
                if (iIntValue < 0) {
                    iIntValue = this.f5580o.f5544d;
                }
                aVar.f5544d = iIntValue;
            }
            this.f5569a = this.f5576k.getSimState();
            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                g.h().a("sim state:" + this.f5569a);
            }
        } catch (Exception e4) {
            if (com.baidu.location.c.b.a.f5616c) {
                e4.printStackTrace();
            }
            f5558b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.f5541a = ((GsmCellLocation) cellLocation).getLac();
            aVar.f5542b = r10.getCid();
            aVar.f5549i = 'g';
            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                g.h().a("bslocation mNetworkType = 'g'");
            }
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.f5549i = 'c';
            boolean z5 = com.baidu.location.c.b.a.f5616c;
            if (z5 && com.baidu.location.c.b.a.f5617d) {
                g.h().a("bslocation mNetworkType = 'c'");
            }
            if (f5559w == null) {
                try {
                    f5559w = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused) {
                    f5559w = null;
                    return aVar;
                }
            }
            Class<?> cls = f5559w;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.f5580o.f5544d;
                    }
                    aVar.f5544d = systemId;
                    aVar.f5542b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.f5541a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (z5 && com.baidu.location.c.b.a.f5617d) {
                        g.h().a("bslocation lat " + (baseStationLatitude / 14400.0d));
                    }
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.f5545e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (z5 && com.baidu.location.c.b.a.f5617d) {
                        g.h().a("bslocation lon" + (baseStationLongitude / 14400.0d));
                    }
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f5546f = baseStationLongitude;
                    }
                } catch (Exception e5) {
                    if (com.baidu.location.c.b.a.f5616c) {
                        e5.printStackTrace();
                    }
                    f5558b = 3;
                    return aVar;
                }
            }
        }
        g(aVar);
        return aVar;
    }

    public void b(boolean z4) {
        this.f5575j = z4;
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        try {
            this.f5569a = telephonyManager.getSimState();
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                if (!com.baidu.location.c.b.a.f5616c || !com.baidu.location.c.b.a.f5617d) {
                    return null;
                }
                g.h().a("getAllCellInfo=null");
                return null;
            }
            com.baidu.location.c.a aVar2 = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z4 = aVar2 != null;
                    com.baidu.location.c.a aVarA = a(cellInfo, aVar, telephonyManager);
                    if (aVarA != null) {
                        if (aVarA.b()) {
                            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                                g.h().a(" cell res.isValid() = " + f(aVarA));
                            }
                            if (z4 && aVar2 != null) {
                                aVar2.f5554n = e(aVarA);
                                aVar2.f5555o = f(aVarA);
                            }
                        } else {
                            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                                g.h().a("res.isValid()");
                            }
                            aVarA = null;
                        }
                        if (aVar2 == null) {
                            aVar2 = aVarA;
                        }
                    }
                }
            }
            return aVar2;
        } catch (Throwable th) {
            if (com.baidu.location.c.b.a.f5616c) {
                th.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public String a(com.baidu.location.c.a aVar) {
        try {
            String strD = d(aVar);
            if (strD == null || "".equals(strD)) {
                return strD;
            }
            "&nc=".equals(strD);
            return strD;
        } catch (Throwable th) {
            th.printStackTrace();
            if ("&nc=".equals("")) {
                return null;
            }
            return "";
        }
    }

    public void a(int i4) {
        this.f5572g.set(i4);
    }

    public void a(Context context) {
        d dVar;
        if (this.f5589y) {
            return;
        }
        this.f5588x = context;
        this.f5576k = (TelephonyManager) context.getSystemService("phone");
        this.f5582q = new LinkedList();
        if (Looper.myLooper() != null) {
            this.f5584s = new d();
        }
        if (this.f5565F == null) {
            this.f5565F = new Handler(Looper.getMainLooper());
        }
        if (this.f5575j) {
            g();
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= this.f5570e) {
            if (this.f5583r == null) {
                this.f5583r = this.f5588x.getMainExecutor();
            }
            this.f5590z = com.baidu.location.c.b.b.a("android.telephony.TelephonyManager$CellInfoCallback");
            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                g.h().a("isCellinfoCallbackExist = " + this.f5590z);
            }
        }
        TelephonyManager telephonyManager = this.f5576k;
        if (telephonyManager == null || (dVar = this.f5584s) == null) {
            return;
        }
        if (i4 < this.f5570e || !this.f5590z) {
            try {
                telephonyManager.listen(dVar, 1280);
            } catch (Exception unused) {
            }
        }
        if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
            g.h().a("cell manager start...");
        }
        this.f5589y = true;
    }

    private void g(com.baidu.location.c.a aVar) throws IOException {
        com.baidu.location.c.a aVar2;
        com.baidu.location.c.a aVar3 = this.f5580o;
        if (aVar.b() && ((aVar2 = this.f5580o) == null || !aVar2.a(aVar) || a(this.f5580o, aVar))) {
            this.f5580o = aVar;
        }
        if (aVar.b()) {
            if (aVar3 == null || !aVar3.a(aVar)) {
                if (!aVar.b()) {
                    List<com.baidu.location.c.a> list = this.f5582q;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.f5582q.size();
                com.baidu.location.c.a aVar4 = size == 0 ? null : this.f5582q.get(size - 1);
                if (aVar4 != null) {
                    long j4 = aVar4.f5542b;
                    com.baidu.location.c.a aVar5 = this.f5580o;
                    if (j4 == aVar5.f5542b && aVar4.f5541a == aVar5.f5541a) {
                        return;
                    }
                }
                this.f5582q.add(this.f5580o);
                if (this.f5582q.size() > 3) {
                    this.f5582q.remove(0);
                }
                if (this.f5575j) {
                    h();
                }
                this.f5564E = false;
            }
        }
    }

    public void a(boolean z4) {
        this.f5574i = z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(com.baidu.location.c.a r9, com.baidu.location.c.a r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L6
            if (r10 != 0) goto L6
            return r0
        L6:
            r1 = 1
            if (r9 == 0) goto Lad
            if (r10 != 0) goto Ld
            goto Lad
        Ld:
            int r2 = r9.f5548h
            int r3 = r10.f5548h
            int r2 = r2 - r3
            int r2 = java.lang.Math.abs(r2)
            float r2 = (float) r2
            int r3 = r9.f5548h
            r4 = -1
            if (r3 == 0) goto L1d
            goto L1e
        L1d:
            r3 = r4
        L1e:
            float r3 = (float) r3
            float r2 = r2 / r3
            boolean r3 = com.baidu.location.c.b.a.f5616c
            if (r3 == 0) goto L5e
            boolean r5 = com.baidu.location.c.b.a.f5617d
            if (r5 == 0) goto L5e
            com.baidu.location.c.e r5 = com.baidu.location.c.g.h()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "cl-cache, str, old:"
            r6.<init>(r7)
            int r7 = r9.f5548h
            r6.append(r7)
            java.lang.String r7 = " new:"
            r6.append(r7)
            int r7 = r10.f5548h
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.a(r6)
            com.baidu.location.c.e r5 = com.baidu.location.c.g.h()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "cl-cache, str, diffRate:"
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            r5.a(r6)
        L5e:
            java.lang.String r9 = r9.f5554n
            if (r9 == 0) goto L87
            java.lang.String r5 = r10.f5554n
            if (r5 == 0) goto L87
            int r9 = r8.a(r9)
            java.lang.String r10 = r10.f5554n
            int r10 = r8.a(r10)
            int r10 = r9 - r10
            int r10 = java.lang.Math.abs(r10)
            if (r9 == 0) goto L79
            r4 = r9
        L79:
            int r10 = r10 / r4
            int r9 = java.lang.Math.abs(r10)
            float r9 = (float) r9
            float r10 = r8.f5573h
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L87
            r9 = r1
            goto L88
        L87:
            r9 = r0
        L88:
            if (r3 == 0) goto La3
            boolean r10 = com.baidu.location.c.b.a.f5617d
            if (r10 == 0) goto La3
            com.baidu.location.c.e r10 = com.baidu.location.c.g.h()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "cl-cache, isStrengthChange2:"
            r3.<init>(r4)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            r10.a(r3)
        La3:
            float r8 = r8.f5573h
            int r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r8 > 0) goto Lab
            if (r9 == 0) goto Lac
        Lab:
            r0 = r1
        Lac:
            return r0
        Lad:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a.a(com.baidu.location.c.a, com.baidu.location.c.a):boolean");
    }
}
