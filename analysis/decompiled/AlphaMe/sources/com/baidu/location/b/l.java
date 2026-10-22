package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.a.a;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import h3.InterfaceC0615y;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5338a;

    /* renamed from: b, reason: collision with root package name */
    private long f5339b;

    /* renamed from: c, reason: collision with root package name */
    private Context f5340c;

    /* renamed from: d, reason: collision with root package name */
    private com.baidu.a.a f5341d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final l f5342a = new l();
    }

    public static class b implements InterfaceC0615y {

        /* renamed from: a, reason: collision with root package name */
        private static b f5343a;

        /* renamed from: b, reason: collision with root package name */
        private com.baidu.a.a f5344b;

        private b(com.baidu.a.a aVar) {
            this.f5344b = aVar;
        }

        public static b a(com.baidu.a.a aVar) {
            if (f5343a == null) {
                f5343a = new b(aVar);
            }
            return f5343a;
        }

        @Override // h3.InterfaceC0615y
        public List<InetAddress> lookup(String hostname) throws UnknownHostException {
            if (!com.baidu.location.e.d.f5839a.equals(hostname)) {
                Intrinsics.checkNotNullParameter(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    Intrinsics.checkNotNullExpressionValue(allByName, "getAllByName(hostname)");
                    return ArraysKt.toList(allByName);
                } catch (NullPointerException e4) {
                    UnknownHostException unknownHostException = new UnknownHostException(Intrinsics.stringPlus("Broken system behaviour for dns lookup of ", hostname));
                    unknownHostException.initCause(e4);
                    throw unknownHostException;
                }
            }
            com.baidu.a.b bVarA = this.f5344b.a(hostname, true);
            ArrayList<String> arrayListD = bVarA.d();
            ArrayList<String> arrayListC = bVarA.c();
            String strR = (arrayListD == null || arrayListD.isEmpty()) ? (arrayListC == null || arrayListC.isEmpty()) ? null : arrayListC.get(0) : B0.g.r(new StringBuilder("["), arrayListD.get(0), "]");
            if (strR != null) {
                return Arrays.asList(InetAddress.getAllByName(strR));
            }
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            try {
                InetAddress[] allByName2 = InetAddress.getAllByName(hostname);
                Intrinsics.checkNotNullExpressionValue(allByName2, "getAllByName(hostname)");
                return ArraysKt.toList(allByName2);
            } catch (NullPointerException e5) {
                UnknownHostException unknownHostException2 = new UnknownHostException(Intrinsics.stringPlus("Broken system behaviour for dns lookup of ", hostname));
                unknownHostException2.initCause(e5);
                throw unknownHostException2;
            }
        }
    }

    private l() {
        this.f5338a = true;
        this.f5339b = 0L;
    }

    public static l a() {
        return a.f5342a;
    }

    public int b() {
        return this.f5338a ? 1 : 0;
    }

    public InterfaceC0615y c() {
        return this.f5338a ? InterfaceC0615y.f12992d0 : b.a(this.f5341d);
    }

    public void a(Context context) {
        if (c.b().eb == 0) {
            return;
        }
        this.f5340c = context;
        this.f5338a = s.a(context).getBoolean("IsDomestic", true);
        this.f5339b = s.a(context).getLong("update_result_time", 0L);
        if (this.f5338a) {
            com.baidu.location.e.d.a();
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("loc.map.baidu.com"));
        com.baidu.a.a aVarA = com.baidu.a.a.a(context);
        this.f5341d = aVarA;
        try {
            aVarA.a("110001");
            this.f5341d.b("nHpsFU98hcqhzFWY17Ht");
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
        }
        this.f5341d.a(true);
        this.f5341d.a(true, true);
        this.f5341d.a(a.EnumC0003a.POLICY_TOLERANT);
        this.f5341d.a(arrayList);
    }

    public String b(String str) throws UnknownHostException {
        String str2;
        if (this.f5338a) {
            return str;
        }
        try {
            String host = new URL(str).getHost();
            if (host != null && !host.isEmpty()) {
                com.baidu.a.b bVarA = this.f5341d.a(host, true);
                ArrayList<String> arrayListD = bVarA.d();
                ArrayList<String> arrayListC = bVarA.c();
                if (arrayListD == null || arrayListD.isEmpty()) {
                    str2 = (arrayListC == null || arrayListC.isEmpty()) ? null : arrayListC.get(0);
                } else {
                    str2 = "[" + arrayListD.get(0) + "]";
                }
                return str2 != null ? str.replaceFirst(host, str2) : str;
            }
            return str;
        } catch (MalformedURLException e4) {
            e4.printStackTrace();
            return str;
        }
    }

    public void a(BDLocation bDLocation) {
        if (c.b().eb != 1 || bDLocation.getLongitude() == Double.MIN_VALUE || bDLocation.getLatitude() == Double.MIN_VALUE || System.currentTimeMillis() - this.f5339b <= c.b().ec) {
            return;
        }
        a(bDLocation, this.f5340c);
    }

    private void a(BDLocation bDLocation, Context context) {
        double longitude;
        double latitude;
        String str;
        double[] dArrCoorEncrypt = new double[2];
        String coorType = bDLocation.getCoorType();
        if ("wgs84".equals(coorType)) {
            dArrCoorEncrypt[0] = bDLocation.getLongitude();
            dArrCoorEncrypt[1] = bDLocation.getLatitude();
        } else {
            double[] dArrCoorEncrypt2 = new double[2];
            if ("bd09ll".equals(coorType)) {
                longitude = bDLocation.getLongitude();
                latitude = bDLocation.getLatitude();
                str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
            } else if ("bd09".equals(coorType)) {
                longitude = bDLocation.getLongitude();
                latitude = bDLocation.getLatitude();
                str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
            } else {
                dArrCoorEncrypt2[0] = bDLocation.getLongitude();
                dArrCoorEncrypt2[1] = bDLocation.getLatitude();
                dArrCoorEncrypt = Jni.coorEncrypt(dArrCoorEncrypt2[0], dArrCoorEncrypt2[1], "gcj2wgs");
            }
            dArrCoorEncrypt2 = Jni.coorEncrypt(longitude, latitude, str);
            dArrCoorEncrypt = Jni.coorEncrypt(dArrCoorEncrypt2[0], dArrCoorEncrypt2[1], "gcj2wgs");
        }
        boolean zA = com.baidu.location.e.e.a().a(dArrCoorEncrypt[0], dArrCoorEncrypt[1]);
        try {
            this.f5339b = System.currentTimeMillis();
            SharedPreferences sharedPreferencesA = s.a(context);
            if (sharedPreferencesA != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                editorEdit.putBoolean("IsDomestic", zA);
                editorEdit.putLong("update_result_time", this.f5339b);
                editorEdit.apply();
            }
        } catch (Exception unused) {
        }
    }

    public boolean a(String str) {
        try {
            String host = new URL(str).getHost();
            if (this.f5338a) {
                return false;
            }
            return com.baidu.location.e.d.f5839a.equals(host);
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
