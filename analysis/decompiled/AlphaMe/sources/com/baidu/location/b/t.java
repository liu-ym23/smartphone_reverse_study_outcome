package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.net.SyslogConstants;
import com.alibaba.fastjson.asm.Opcodes;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static final double[] f5458a = {1999.0d, 8.0d, 22.0d, 0.0d, 0.0d, 0.0d};

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, c> f5459b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f5460c = new HashMap<>();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static t f5461a = new t();
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f5462a = 0;

        /* renamed from: b, reason: collision with root package name */
        double f5463b = 0.0d;

        public b() {
        }
    }

    public class c {

        /* renamed from: b, reason: collision with root package name */
        private boolean f5466b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5467c;

        /* renamed from: d, reason: collision with root package name */
        private long f5468d;

        /* renamed from: e, reason: collision with root package name */
        private int f5469e;

        /* renamed from: f, reason: collision with root package name */
        private int f5470f;

        /* renamed from: g, reason: collision with root package name */
        private ArrayList<String> f5471g;

        /* renamed from: h, reason: collision with root package name */
        private ArrayList<Integer> f5472h;

        /* renamed from: i, reason: collision with root package name */
        private int f5473i;

        /* renamed from: j, reason: collision with root package name */
        private double f5474j;

        /* renamed from: k, reason: collision with root package name */
        private double f5475k;

        /* renamed from: l, reason: collision with root package name */
        private double f5476l;

        /* renamed from: m, reason: collision with root package name */
        private int f5477m;

        /* renamed from: n, reason: collision with root package name */
        private int f5478n;

        /* renamed from: o, reason: collision with root package name */
        private b f5479o;

        public c(int i4, int i5) {
            a(i4, i5);
            this.f5473i = 0;
            this.f5474j = 0.0d;
            this.f5475k = 0.0d;
            this.f5476l = 0.0d;
            this.f5477m = 0;
            this.f5478n = 0;
            this.f5479o = t.this.new b();
        }

        private b a(int i4, double d4) {
            b bVarA = a(t.f5458a);
            if (d4 < -1.0E9d || 1.0E9d < d4) {
                d4 = 0.0d;
            }
            int i5 = (int) d4;
            bVarA.f5462a = (i4 * 604800) + i5 + bVarA.f5462a;
            bVarA.f5463b = d4 - i5;
            return bVarA;
        }

        @TargetApi(24)
        private String b(GnssNavigationMessage gnssNavigationMessage) {
            StringBuilder sb = new StringBuilder();
            byte[] data = gnssNavigationMessage.getData();
            int length = data.length;
            for (int i4 = 0; i4 < length; i4++) {
                String strReplace = String.format("%8s", Integer.toBinaryString(data[i4] & UByte.MAX_VALUE)).replace(' ', '0');
                if (i4 % 4 == 0) {
                    strReplace = strReplace.substring(2, 8);
                }
                sb.append(strReplace);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String c() {
            StringBuilder sb = new StringBuilder();
            if (!this.f5467c) {
                return sb.toString();
            }
            if (this.f5470f == 1537) {
                d();
            }
            sb.append(this.f5479o.f5462a);
            sb.append('|');
            boolean z4 = true;
            for (int i4 = 0; i4 < this.f5471g.size(); i4++) {
                if (z4) {
                    z4 = false;
                } else {
                    sb.append(',');
                }
                sb.append(this.f5471g.get(i4));
            }
            this.f5466b = true;
            return sb.toString();
        }

        private void d() {
            int i4;
            b bVarA = a(this.f5473i, this.f5474j);
            double d4 = ((r1.f5462a - bVarA.f5462a) + a(this.f5473i, this.f5475k).f5463b) - bVarA.f5463b;
            if (d4 <= 302400.0d) {
                if (d4 < -302400.0d) {
                    i4 = this.f5473i + 1;
                }
                this.f5479o = a(this.f5473i, this.f5476l);
                this.f5478n = this.f5473i + 1024;
            }
            i4 = this.f5473i - 1;
            this.f5473i = i4;
            this.f5479o = a(this.f5473i, this.f5476l);
            this.f5478n = this.f5473i + 1024;
        }

        private void e(String str) {
            this.f5477m = Integer.parseInt(str.substring(42, 46), 2);
        }

        private b a(double[] dArr) {
            int[] iArr = {1, 32, 60, 91, 121, SyslogConstants.LOG_LOCAL3, Opcodes.INVOKEVIRTUAL, 213, 244, 274, 305, 335};
            b bVar = t.this.new b();
            int i4 = (int) dArr[0];
            int i5 = (int) dArr[1];
            int i6 = (int) dArr[2];
            if (i4 >= 1970 && 2099 >= i4 && i5 >= 1 && 12 >= i5) {
                int i7 = ((((((i4 - 1969) / 4) + ((i4 - 1970) * 365)) + iArr[i5 - 1]) + i6) - 2) + ((i4 % 4 != 0 || i5 < 3) ? 0 : 1);
                int iFloor = (int) Math.floor(dArr[5]);
                bVar.f5462a = (((int) dArr[4]) * 60) + (((int) dArr[3]) * 3600) + (i7 * 86400) + iFloor;
                bVar.f5463b = dArr[5] - iFloor;
            }
            return bVar;
        }

        private void b(String str) {
            this.f5473i = Integer.parseInt(str.substring(96, 108), 2);
            this.f5474j = Long.parseLong(str.substring(108, 128), 2);
        }

        private void c(String str) {
            this.f5475k = Long.parseLong(str.substring(16, 30), 2) * 60.0d;
        }

        private void d(String str) {
            this.f5476l = Long.parseLong(str.substring(54, 68), 2) * 60;
        }

        @TargetApi(24)
        private String a(GnssNavigationMessage gnssNavigationMessage) {
            StringBuilder sb = new StringBuilder();
            for (byte b4 : gnssNavigationMessage.getData()) {
                sb.append(String.format("%8s", Integer.toBinaryString(b4 & UByte.MAX_VALUE)).replace(' ', '0'));
            }
            return sb.toString();
        }

        private boolean b() {
            if (this.f5472h == null) {
                return false;
            }
            for (int i4 = 0; i4 < this.f5472h.size(); i4++) {
                if (this.f5472h.get(i4).intValue() != i4) {
                    return false;
                }
            }
            return true;
        }

        private void a() {
            if (this.f5471g.size() != 0) {
                for (int i4 = 0; i4 < this.f5471g.size(); i4++) {
                    if (!this.f5471g.get(i4).contains("None")) {
                    }
                }
                this.f5467c = true;
                return;
            }
            this.f5467c = false;
        }

        private void a(int i4, int i5) {
            int i6 = this.f5470f;
            int i7 = 5;
            if (i6 != 257 && i6 != 769) {
                i7 = i6 != 1537 ? i6 != 1281 ? i6 != 1282 ? 0 : 10 : 3 : 6;
            }
            ArrayList<String> arrayList = this.f5471g;
            if (arrayList != null) {
                arrayList.clear();
            } else {
                this.f5471g = new ArrayList<>();
            }
            ArrayList<Integer> arrayList2 = this.f5472h;
            if (arrayList2 != null) {
                arrayList2.clear();
            } else {
                this.f5472h = new ArrayList<>();
            }
            for (int i8 = 0; i8 < i7; i8++) {
                this.f5471g.add("None");
            }
            this.f5469e = i4;
            this.f5470f = i5;
            this.f5466b = false;
            this.f5467c = false;
            this.f5468d = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(24)
        public void a(GnssNavigationMessage gnssNavigationMessage, long j4) throws NumberFormatException {
            int type = gnssNavigationMessage.getType();
            int svid = gnssNavigationMessage.getSvid();
            int submessageId = gnssNavigationMessage.getSubmessageId();
            byte[] data = gnssNavigationMessage.getData();
            if (j4 - this.f5468d > 1200 || this.f5466b || this.f5471g.size() == 0 || type != this.f5470f || svid != this.f5469e) {
                a(svid, type);
            }
            if ((type == 1282 || type == 1281) && !b()) {
                a(svid, type);
            }
            if (this.f5471g.size() == 0) {
                return;
            }
            int i4 = this.f5470f;
            boolean z4 = true;
            int i5 = i4 == 1537 ? 0 : 1;
            if (i4 == 1282) {
                if (submessageId != 1) {
                    return;
                }
                e(b(gnssNavigationMessage));
                submessageId = this.f5477m;
            }
            int i6 = submessageId - i5;
            if (i6 >= this.f5471g.size()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b4 : data) {
                if (z4) {
                    z4 = false;
                } else {
                    sb.append(',');
                }
                sb.append((int) b4);
            }
            this.f5471g.set(i6, sb.toString());
            if (type == 1281 || type == 1282) {
                this.f5472h.add(Integer.valueOf(i6));
            }
            if (this.f5470f == 1537) {
                a(a(gnssNavigationMessage));
            }
            a();
            this.f5468d = j4;
        }

        private void a(String str) throws NumberFormatException {
            StringBuilder sb;
            int i4;
            char cCharAt = str.charAt(0);
            char cCharAt2 = str.charAt(SyslogConstants.LOG_CLOCK);
            if (cCharAt == '1' && cCharAt2 == '0') {
                sb = new StringBuilder();
                sb.append(str.substring(2, 18));
                i4 = 234;
            } else {
                if (cCharAt != '0' || cCharAt2 != '1') {
                    return;
                }
                sb = new StringBuilder();
                sb.append(str.substring(2, 114));
                i4 = 138;
            }
            sb.append(str.substring(122, i4));
            String string = sb.toString();
            int i5 = Integer.parseInt(string.substring(0, 6), 2);
            if (i5 == 0) {
                b(string);
            } else if (i5 == 1) {
                c(string);
            } else if (i5 == 4) {
                d(string);
            }
        }
    }

    public static t a() {
        return a.f5461a;
    }

    public ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, c> entry : this.f5459b.entrySet()) {
            String key = entry.getKey();
            String strC = entry.getValue().c();
            if (strC != null && strC.length() != 0) {
                if (this.f5460c.containsKey(key)) {
                    if (strC.substring(0, 100).equals(this.f5460c.get(key).substring(0, 100))) {
                    }
                } else {
                    this.f5460c.put(key, strC);
                }
                arrayList.add(key + '|' + strC);
            }
        }
        return arrayList;
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j4) throws NumberFormatException {
        HashMap<String, c> map;
        int svid = gnssNavigationMessage.getSvid();
        int type = gnssNavigationMessage.getType();
        String str = (type != 257 ? type != 769 ? type != 1537 ? type != 1281 ? type != 1282 ? SchedulerSupport.NONE : "CT" : "CO" : ExifInterface.LONGITUDE_EAST : "R" : "G") + svid;
        if (str.contains(SchedulerSupport.NONE) || (map = this.f5459b) == null) {
            return;
        }
        if (!map.containsKey(str)) {
            this.f5459b.put(str, new c(svid, type));
        }
        this.f5459b.get(str).a(gnssNavigationMessage, j4);
    }
}
