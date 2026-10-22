package com.stepos.statsrpk;

import android.content.Context;
import android.text.TextUtils;
import f3.C0720b;
import g3.C0742e;
import java.util.HashMap;
import java.util.Map;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private d f15974a;

    /* renamed from: b, reason: collision with root package name */
    private b f15975b;

    /* renamed from: c, reason: collision with root package name */
    private C0720b f15976c;

    /* renamed from: d, reason: collision with root package name */
    private f f15977d;

    public h(Context context, d dVar, b bVar) {
        this.f15974a = dVar;
        this.f15975b = bVar;
        this.f15976c = new C0720b(context, "statsrpk_config_" + bVar.f15938a);
        C0742e.k("RpkTracker", "RpkTracker created successfully.");
    }

    private int a(String str) throws NumberFormatException {
        String strM = this.f15976c.m("event_filters", BuildConfig.FLAVOR);
        if (!TextUtils.isEmpty(strM)) {
            for (String str2 : strM.split(",")) {
                String str3 = str2.split(":")[0];
                int i5 = Integer.parseInt(str2.split(":")[1]);
                if (str3.equals(str)) {
                    return i5;
                }
            }
        }
        return 1;
    }

    void b(f fVar) {
        this.f15977d = fVar;
    }

    public void c(String str, long j5, long j6, long j7) {
        if (this.f15976c.n("active", true) && a(str) != -1) {
            a aVar = new a();
            aVar.f15933a = "page";
            aVar.f15934b = str;
            aVar.f15935c = str;
            HashMap map = new HashMap();
            map.put("start", String.valueOf(j5));
            map.put("end", String.valueOf(j6));
            map.put("duration2", String.valueOf(j7));
            aVar.f15936d = map;
            aVar.f15937e = this.f15977d.b().f();
            this.f15974a.d(aVar, this.f15975b);
        }
    }

    public void d(String str, String str2, Map map) {
        if (this.f15976c.n("active", true) && a(str) != 0) {
            a aVar = new a();
            aVar.f15933a = "action_x";
            aVar.f15934b = str;
            aVar.f15935c = str2;
            aVar.f15936d = map;
            aVar.f15937e = this.f15977d.b().f();
            this.f15974a.d(aVar, this.f15975b);
        }
    }
}
