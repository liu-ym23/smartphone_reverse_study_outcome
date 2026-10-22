package com.bytedance.apm.e;

import com.bytedance.apm.battery.dao.DBHelper;
import org.json.JSONObject;

/* JADX INFO: compiled from: BatteryLogEntity.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4586e;
    private String f;
    private long g;
    private String h;
    private long i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;

    public a(boolean r1, long r2, String r4, boolean r5, long r6, String r8) {
        this.f4585d = r1;
        this.f4582a = r2;
        this.f4583b = r4;
        this.f4586e = r5;
        this.g = r6;
        this.f = r8;
    }

    public a(boolean r1, long r2, String r4, boolean r5, long r6, String r8, String r9) {
        this.f4585d = r1;
        this.f4582a = r2;
        this.f4583b = r4;
        this.f4586e = r5;
        this.g = r6;
        this.f = r8;
        this.h = r9;
    }

    public void a(String r1) {
        this.f = r1;
    }

    public boolean a() {
        return this.f4585d;
    }

    public boolean b() {
        return !this.f4585d;
    }

    public boolean c() {
        return this.f4586e;
    }

    public long d() {
        return this.g;
    }

    public long e() {
        return this.f4582a;
    }

    public String getType() {
        return this.f4583b;
    }

    public boolean f() {
        return this.f4586e;
    }

    public void a(boolean r1) {
        this.f4586e = r1;
    }

    public String g() {
        return this.f;
    }

    public String h() {
        return this.h;
    }

    public void a(long r1) {
        this.i = r1;
    }

    public long i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public void b(String r1) {
        this.j = r1;
    }

    public boolean k() {
        return this.k;
    }

    public void b(boolean r1) {
        this.k = r1;
    }

    public String l() {
        return this.l;
    }

    public void c(String r1) {
        this.l = r1;
    }

    public long m() {
        return this.f4584c;
    }

    public void b(long r1) {
        this.f4584c = r1;
    }

    public String toString() {
        return "BatteryLogEntity{id=" + this.f4584c + ", front=" + this.f4585d + ", time=" + this.f4582a + ", type='" + this.f4583b + "', status=" + this.f4586e + ", scene='" + this.f + "', accumulation=" + this.g + ", source='" + this.h + "', versionId=" + this.i + ", processName='" + this.j + "', mainProcess=" + this.k + ", startUuid='" + this.l + "', deleteFlag=" + this.m + '}';
    }

    public JSONObject n() {
        JSONObject r0 = new JSONObject();
        r0.put(DBHelper.COL_FRONT, this.f4585d);
        r0.put("time", this.f4582a);
        r0.put("type", this.f4583b);
        r0.put(DBHelper.BATTERY_COL_SCENE, this.f);
        r0.put("processName", this.j);
        return r0;
    }
}
