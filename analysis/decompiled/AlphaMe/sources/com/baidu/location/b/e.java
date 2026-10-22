package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Base64;
import com.baidu.location.BDLocation;
import com.stepos.alphame.utils.Consts;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import net.sourceforge.jeval.EvaluationConstants;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f5211a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5212b = false;

    /* renamed from: c, reason: collision with root package name */
    private Deque<String> f5213c = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    private Deque<String> f5214d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    private Deque<String> f5215e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    private int f5216f = 5;

    /* renamed from: g, reason: collision with root package name */
    private int f5217g = 5;

    /* renamed from: h, reason: collision with root package name */
    private int f5218h = 1;

    /* renamed from: i, reason: collision with root package name */
    private int f5219i = 1;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static e f5220a = new e();
    }

    public static e a() {
        return a.f5220a;
    }

    public String b() {
        return a(this.f5219i, this.f5218h);
    }

    public synchronized String c() {
        return a(this.f5219i, this.f5218h);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(int r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            r1 = 1
            if (r4 != r1) goto L18
            java.util.Deque<java.lang.String> r4 = r3.f5215e
            java.lang.String r4 = r3.c(r4)
            boolean r2 = r0.equals(r4)
            if (r2 != 0) goto L18
            java.lang.String r2 = "&ll_pre="
            java.lang.String r4 = B0.g.m(r2, r4)
            goto L19
        L18:
            r4 = r0
        L19:
            if (r5 != r1) goto L3f
            java.util.Deque<java.lang.String> r5 = r3.f5213c
            java.lang.String r5 = r3.b(r5)
            boolean r1 = r0.equals(r5)
            if (r1 != 0) goto L2d
            java.lang.String r1 = "&cl_pre="
            java.lang.String r4 = androidx.room.AbstractC0351g.q(r4, r1, r5)
        L2d:
            java.util.Deque<java.lang.String> r5 = r3.f5214d
            java.lang.String r3 = r3.b(r5)
            boolean r5 = r0.equals(r3)
            if (r5 != 0) goto L3f
            java.lang.String r5 = "&wf_pre="
            java.lang.String r4 = androidx.room.AbstractC0351g.q(r4, r5, r3)
        L3f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.e.a(int, int):java.lang.String");
    }

    private String b(Deque<String> deque) {
        if (deque == null || deque.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String strPeekFirst = deque.peekFirst();
        if (strPeekFirst != null) {
            try {
                String[] strArrSplit = strPeekFirst.split(",");
                int i4 = 0;
                for (String str : deque) {
                    if (strArrSplit.length != 3) {
                        break;
                    }
                    String[] strArrSplit2 = str.split(",");
                    if (i4 == 0) {
                        sb.append(strPeekFirst);
                    } else if (strArrSplit2.length != 3) {
                        i4++;
                    } else {
                        try {
                            sb.append((int) ((Double.parseDouble(strArrSplit[0]) - Double.parseDouble(strArrSplit2[0])) * Math.pow(10.0d, 6.0d)));
                            sb.append(",");
                            sb.append((int) ((Double.parseDouble(strArrSplit[1]) - Double.parseDouble(strArrSplit2[1])) * Math.pow(10.0d, 6.0d)));
                            sb.append(",");
                            sb.append(Long.parseLong(strArrSplit[2]) - Long.parseLong(strArrSplit2[2]));
                        } catch (Exception unused) {
                        }
                    }
                    if (i4 != deque.size() - 1) {
                        sb.append(Consts.SPLITTER_DETAIL);
                    }
                    i4++;
                }
            } catch (Exception unused2) {
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0103 A[Catch: Exception -> 0x010d, TRY_LEAVE, TryCatch #1 {Exception -> 0x010d, blocks: (B:9:0x0019, B:10:0x0023, B:12:0x0029, B:15:0x0035, B:17:0x003c, B:25:0x00fc, B:27:0x0103, B:19:0x0042), top: B:38:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String c(java.util.Deque<java.lang.String> r18) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.e.c(java.util.Deque):java.lang.String");
    }

    private void b(String str, Deque<String> deque) {
        if (str == null || "".equals(str)) {
            return;
        }
        deque.addAll(Arrays.asList(new String(Base64.decode(str.getBytes(), 0)).split("\\|")));
    }

    public void a(Context context) {
        if (this.f5211a == null) {
            this.f5211a = s.a().b(context);
        }
        SharedPreferences sharedPreferences = this.f5211a;
        if (sharedPreferences == null || this.f5212b) {
            return;
        }
        try {
            String string = sharedPreferences.getString("cl_pre", "");
            String string2 = this.f5211a.getString("wf_pre", "");
            String string3 = this.f5211a.getString("ll_pre", "");
            a(string, this.f5213c);
            a(string2, this.f5214d);
            b(string3, this.f5215e);
        } catch (Exception unused) {
        }
        this.f5212b = true;
    }

    public synchronized void a(BDLocation bDLocation, String str, Location location) {
        Deque<String> deque;
        String str2;
        if (bDLocation != null) {
            if ("gcj02".equals(str)) {
                String networkLocationType = bDLocation.getNetworkLocationType();
                int locType = bDLocation.getLocType();
                if (locType == 61 || locType == 161) {
                    if (networkLocationType == null) {
                        networkLocationType = "null";
                    }
                    if (networkLocationType.contains("wf") && this.f5218h == 1) {
                        this.f5214d.offerFirst(bDLocation.getLongitude() + "," + bDLocation.getLatitude() + "," + com.baidu.location.e.h.c(bDLocation.getTime()));
                        deque = this.f5214d;
                        str2 = "wf";
                    } else {
                        if (!networkLocationType.contains("cl") || this.f5218h != 1) {
                            if (locType == 61 && this.f5219i == 1 && location != null) {
                                int radius = (int) bDLocation.getRadius();
                                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                                DecimalFormat decimalFormat2 = new DecimalFormat(EvaluationConstants.BOOLEAN_STRING_FALSE);
                                DecimalFormat decimalFormat3 = new DecimalFormat("0.000000");
                                this.f5215e.offerFirst(bDLocation.getSatelliteNumber() + "," + radius + "," + decimalFormat.format(bDLocation.getAltitude()) + "," + com.baidu.location.e.h.c(bDLocation.getTime()) + "," + decimalFormat2.format(bDLocation.getSpeed()) + "," + decimalFormat3.format(location.getLongitude()) + "," + decimalFormat3.format(location.getLatitude()));
                                a(this.f5215e);
                            }
                        }
                        this.f5213c.offerFirst(bDLocation.getLongitude() + "," + bDLocation.getLatitude() + "," + com.baidu.location.e.h.c(bDLocation.getTime()));
                        deque = this.f5213c;
                        str2 = "cl";
                    }
                    a(deque, str2);
                }
            }
        }
    }

    private void a(String str, Deque<String> deque) {
        if (str == null || "".equals(str)) {
            return;
        }
        deque.addAll(Arrays.asList(new String(Base64.decode(str.getBytes(), 0)).split("\\|")));
    }

    private void a(Deque<String> deque) {
        if (deque == null || deque.isEmpty()) {
            return;
        }
        while (deque.size() > this.f5217g) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = deque.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            if (i4 != deque.size() - 1) {
                sb.append(Consts.SPLITTER_DETAIL);
            }
            i4++;
        }
        try {
            String str = new String(Base64.encode(sb.toString().getBytes(), 0));
            SharedPreferences.Editor editorEdit = this.f5211a.edit();
            editorEdit.putString("ll_pre", str);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    private void a(Deque<String> deque, String str) {
        if (deque == null || deque.isEmpty()) {
            return;
        }
        while (deque.size() > this.f5216f) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = deque.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            if (i4 != deque.size() - 1) {
                sb.append(Consts.SPLITTER_DETAIL);
            }
            i4++;
        }
        try {
            String str2 = new String(Base64.encode(sb.toString().getBytes(), 0));
            SharedPreferences.Editor editorEdit = this.f5211a.edit();
            editorEdit.putString(str + "_pre", str2);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }
}
