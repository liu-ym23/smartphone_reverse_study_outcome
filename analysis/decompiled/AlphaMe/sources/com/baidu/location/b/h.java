package com.baidu.location.b;

import android.location.Location;
import android.os.Bundle;
import ch.qos.logback.core.joran.action.ActionConst;
import com.baidu.location.e.b.b;
import com.stepos.alphame.utils.Consts;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    private static String f5258b = "NULL";

    /* renamed from: a, reason: collision with root package name */
    private boolean f5259a = false;

    /* renamed from: c, reason: collision with root package name */
    private long f5260c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f5261d = -1;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final h f5262a = new h();
    }

    private String b(Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append(location.getAccuracy());
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(com.baidu.location.c.d.f5634a);
        sb.append(Consts.SPLITTER_DETAIL);
        Bundle extras = location.getExtras();
        if (extras == null || !extras.containsKey("meanCn0")) {
            sb.append("-1|");
        } else {
            sb.append(extras.get("meanCn0"));
            sb.append(Consts.SPLITTER_DETAIL);
        }
        if (extras == null || !extras.containsKey("SourceType")) {
            sb.append("-1|");
        } else {
            sb.append(extras.get("SourceType"));
            sb.append(Consts.SPLITTER_DETAIL);
        }
        sb.append(f5258b);
        return sb.toString();
    }

    private void d() {
        String strA = com.baidu.location.e.b.b.a().a(b.EnumC0016b.GPS_CHECKER_STATUS);
        if (strA != null && d.a(strA, c.b().ca) == 0) {
            this.f5259a = true;
        }
    }

    public int a(Location location) {
        if (location == null) {
            return -1;
        }
        this.f5260c = System.currentTimeMillis() / 1000;
        if (!b()) {
            d();
        }
        int iA = b() ? a(b(location)) : -1;
        this.f5261d = iA;
        return iA;
    }

    public void c() {
        d.b();
        this.f5259a = false;
        f5258b = "";
        this.f5260c = -1L;
        this.f5261d = -1;
    }

    private int a(String str) {
        return d.a(str);
    }

    public boolean b() {
        return this.f5259a;
    }

    public static h a() {
        return a.f5262a;
    }

    public void a(ArrayList<ArrayList<Float>> arrayList) {
        String string;
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() == 0) {
            string = ActionConst.NULL;
        } else {
            Iterator<ArrayList<Float>> it = arrayList.iterator();
            boolean z4 = true;
            while (it.hasNext()) {
                ArrayList<Float> next = it.next();
                if (next.size() == 6) {
                    if (z4) {
                        z4 = false;
                    } else {
                        sb.append(";");
                    }
                    sb.append(String.format("%.1f,", next.get(2)));
                    sb.append(String.format("%.0f", next.get(3)));
                }
            }
            string = sb.toString();
        }
        f5258b = string;
    }
}
