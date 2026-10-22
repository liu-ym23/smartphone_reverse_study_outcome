package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.event.AutoTrackEventType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class n4 extends e4 {
    public int A;
    public String B;
    public List<l4> s;
    public List<h4> t;
    public List<o4> u;
    public List<m4> v;
    public List<r4> w;
    public List<s4> x;
    public JSONObject y;
    public byte[] z;

    @Override // com.bytedance.bdtracker.e4
    public int a(Cursor cursor) {
        this.b = cursor.getLong(0);
        this.c = cursor.getLong(1);
        this.z = cursor.getBlob(2);
        this.A = cursor.getInt(3);
        this.l = cursor.getInt(4);
        this.m = cursor.getString(5);
        this.B = cursor.getString(6);
        this.e = "";
        return 7;
    }

    @Override // com.bytedance.bdtracker.e4
    public e4 a(JSONObject jSONObject) {
        d().error(4, this.a, "Not allowed", new Object[0]);
        return null;
    }

    public final JSONArray a(Set<String> set) {
        d dVarA = b.a(this.m);
        JSONArray jSONArray = new JSONArray();
        if (dVarA == null || !dVarA.isBavEnabled()) {
            List<o4> list = this.u;
            if (list != null) {
                for (o4 o4Var : list) {
                    if (o4Var.C) {
                        jSONArray.put(o4Var.h());
                        if (set != null) {
                            set.add(o4Var.p);
                        }
                    }
                }
            }
        } else if (this.u != null && (dVarA.getInitConfig() == null || AutoTrackEventType.a(dVarA.getInitConfig().getAutoTrackEventType(), 2))) {
            for (o4 o4Var2 : this.u) {
                jSONArray.put(o4Var2.h());
                if (set != null) {
                    set.add(o4Var2.p);
                }
            }
        }
        List<l4> list2 = this.s;
        if (list2 != null && !list2.isEmpty()) {
            for (l4 l4Var : this.s) {
                jSONArray.put(l4Var.h());
                if (set != null) {
                    set.add(l4Var.p);
                }
            }
        }
        List<s4> list3 = this.x;
        if (list3 != null && !list3.isEmpty()) {
            for (s4 s4Var : this.x) {
                jSONArray.put(s4Var.h());
                if (set != null) {
                    set.add(s4Var.p);
                }
            }
        }
        return jSONArray;
    }

    @Override // com.bytedance.bdtracker.e4
    public List<String> b() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", "integer", "_data", "blob", "_fail", "integer", "event_type", "integer", "_app_id", "varchar", "e_ids", "varchar");
    }

    @Override // com.bytedance.bdtracker.e4
    public void b(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.c));
        contentValues.put("_data", o());
        contentValues.put("event_type", Integer.valueOf(this.l));
        contentValues.put("_app_id", this.m);
        contentValues.put("e_ids", this.B);
    }

    @Override // com.bytedance.bdtracker.e4
    public void b(JSONObject jSONObject) {
        d().error(4, this.a, "Not allowed", new Object[0]);
    }

    @Override // com.bytedance.bdtracker.e4
    public String c() {
        return String.valueOf(this.b);
    }

    @Override // com.bytedance.bdtracker.e4
    public String f() {
        return "packV2";
    }

    @Override // com.bytedance.bdtracker.e4
    public JSONObject i() throws JSONException {
        int i;
        d dVarA = b.a(this.m);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.y);
        jSONObject.put("time_sync", z3.d);
        HashSet hashSet = new HashSet();
        List<m4> list = this.v;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (m4 m4Var : this.v) {
                jSONArray.put(m4Var.h());
                hashSet.add(m4Var.p);
            }
            jSONObject.put("launch", jSONArray);
        }
        List<r4> list2 = this.w;
        if (list2 != null && !list2.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<r4> it = this.w.iterator();
            while (it.hasNext()) {
                r4 next = it.next();
                JSONObject jSONObjectH = next.h();
                if (dVarA != null && (i = dVarA.l) > 0) {
                    jSONObjectH.put("launch_from", i);
                    dVarA.l = 0;
                }
                if (this.u != null) {
                    ArrayList arrayList = new ArrayList();
                    for (o4 o4Var : this.u) {
                        if (r.a(o4Var.e, next.e)) {
                            arrayList.add(o4Var);
                        }
                    }
                    if (arrayList.size() != 0) {
                        int size = arrayList.size();
                        JSONArray jSONArray3 = new JSONArray();
                        long j = 0;
                        int i2 = 0;
                        while (i2 < size) {
                            o4 o4Var2 = (o4) arrayList.get(i2);
                            JSONArray jSONArray4 = new JSONArray();
                            d dVar = dVarA;
                            Iterator<r4> it2 = it;
                            jSONArray4.put(0, o4Var2.u);
                            r4 r4Var = next;
                            jSONArray4.put(1, (o4Var2.s + 999) / 1000);
                            jSONArray3.put(jSONArray4);
                            long j2 = o4Var2.c;
                            if (j2 > j) {
                                jSONObjectH.put("$page_title", r.a((Object) o4Var2.v));
                                jSONObjectH.put("$page_key", r.a((Object) o4Var2.u));
                                j = j2;
                            }
                            i2++;
                            dVarA = dVar;
                            it = it2;
                            next = r4Var;
                        }
                        jSONObjectH.put("activites", jSONArray3);
                        jSONArray2.put(jSONObjectH);
                        hashSet.add(next.p);
                        dVarA = dVarA;
                    }
                }
            }
            jSONObject.put("terminate", jSONArray2);
        }
        JSONArray jSONArrayA = a(hashSet);
        if (jSONArrayA.length() > 0) {
            jSONObject.put("event_v3", jSONArrayA);
        }
        List<h4> list3 = this.t;
        if (list3 != null && !list3.isEmpty()) {
            HashMap map = new HashMap();
            for (h4 h4Var : this.t) {
                JSONArray jSONArray5 = (JSONArray) map.get(h4Var.s);
                if (jSONArray5 == null) {
                    jSONArray5 = new JSONArray();
                    map.put(h4Var.s, jSONArray5);
                }
                jSONArray5.put(h4Var.h());
                hashSet.add(h4Var.p);
            }
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        this.B = TextUtils.join(",", hashSet);
        d().debug(4, this.a, "Pack success ts:{}", Long.valueOf(this.c));
        return jSONObject;
    }

    public int k() {
        List<o4> list;
        List<m4> list2 = this.v;
        int size = list2 != null ? 200 - list2.size() : 200;
        List<r4> list3 = this.w;
        if (list3 != null) {
            size -= list3.size();
        }
        d dVarA = b.a(this.m);
        return (dVarA == null || !dVarA.isBavEnabled() || (list = this.u) == null) ? size : size - list.size();
    }

    public Set<String> l() {
        HashSet hashSet = new HashSet();
        if (TextUtils.isEmpty(this.B)) {
            return hashSet;
        }
        hashSet.addAll(Arrays.asList(this.B.split(",")));
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:6:0x000b, B:8:0x000f, B:9:0x0013, B:11:0x0019, B:13:0x0027, B:14:0x002b, B:16:0x002f, B:18:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x004b, B:24:0x0050, B:26:0x0054, B:27:0x0058, B:29:0x005e, B:31:0x006c, B:32:0x0071, B:34:0x0075, B:35:0x0079, B:37:0x007f, B:39:0x008d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:6:0x000b, B:8:0x000f, B:9:0x0013, B:11:0x0019, B:13:0x0027, B:14:0x002b, B:16:0x002f, B:18:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x004b, B:24:0x0050, B:26:0x0054, B:27:0x0058, B:29:0x005e, B:31:0x006c, B:32:0x0071, B:34:0x0075, B:35:0x0079, B:37:0x007f, B:39:0x008d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:6:0x000b, B:8:0x000f, B:9:0x0013, B:11:0x0019, B:13:0x0027, B:14:0x002b, B:16:0x002f, B:18:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x004b, B:24:0x0050, B:26:0x0054, B:27:0x0058, B:29:0x005e, B:31:0x006c, B:32:0x0071, B:34:0x0075, B:35:0x0079, B:37:0x007f, B:39:0x008d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0071 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:6:0x000b, B:8:0x000f, B:9:0x0013, B:11:0x0019, B:13:0x0027, B:14:0x002b, B:16:0x002f, B:18:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x004b, B:24:0x0050, B:26:0x0054, B:27:0x0058, B:29:0x005e, B:31:0x006c, B:32:0x0071, B:34:0x0075, B:35:0x0079, B:37:0x007f, B:39:0x008d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:6:0x000b, B:8:0x000f, B:9:0x0013, B:11:0x0019, B:13:0x0027, B:14:0x002b, B:16:0x002f, B:18:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x004b, B:24:0x0050, B:26:0x0054, B:27:0x0058, B:29:0x005e, B:31:0x006c, B:32:0x0071, B:34:0x0075, B:35:0x0079, B:37:0x007f, B:39:0x008d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m() {
        /*
            r7 = this;
            org.json.JSONObject r0 = r7.y
            if (r0 != 0) goto L6
            goto La3
        L6:
            java.lang.String r1 = "ssid"
            r0.remove(r1)
            java.util.List<com.bytedance.bdtracker.m4> r0 = r7.v     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L2f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L92
        L13:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L2f
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L92
            com.bytedance.bdtracker.m4 r2 = (com.bytedance.bdtracker.m4) r2     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = r2.i     // Catch: java.lang.Throwable -> L92
            boolean r3 = com.bytedance.bdtracker.r.d(r3)     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L13
            org.json.JSONObject r0 = r7.y     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r2.i     // Catch: java.lang.Throwable -> L92
        L2b:
            r0.put(r1, r2)     // Catch: java.lang.Throwable -> L92
            return
        L2f:
            java.util.List<com.bytedance.bdtracker.o4> r0 = r7.u     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L50
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L92
        L37:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L50
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L92
            com.bytedance.bdtracker.o4 r2 = (com.bytedance.bdtracker.o4) r2     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = r2.i     // Catch: java.lang.Throwable -> L92
            boolean r3 = com.bytedance.bdtracker.r.d(r3)     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L37
            org.json.JSONObject r0 = r7.y     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r2.i     // Catch: java.lang.Throwable -> L92
            goto L2b
        L50:
            java.util.List<com.bytedance.bdtracker.h4> r0 = r7.t     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L92
        L58:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L71
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L92
            com.bytedance.bdtracker.h4 r2 = (com.bytedance.bdtracker.h4) r2     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = r2.i     // Catch: java.lang.Throwable -> L92
            boolean r3 = com.bytedance.bdtracker.r.d(r3)     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L58
            org.json.JSONObject r0 = r7.y     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r2.i     // Catch: java.lang.Throwable -> L92
            goto L2b
        L71:
            java.util.List<com.bytedance.bdtracker.l4> r0 = r7.s     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto La3
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L92
        L79:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto La3
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L92
            com.bytedance.bdtracker.l4 r2 = (com.bytedance.bdtracker.l4) r2     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = r2.i     // Catch: java.lang.Throwable -> L92
            boolean r3 = com.bytedance.bdtracker.r.d(r3)     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L79
            org.json.JSONObject r0 = r7.y     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r2.i     // Catch: java.lang.Throwable -> L92
            goto L2b
        L92:
            r0 = move-exception
            r5 = r0
            com.bytedance.applog.log.IAppLogLogger r1 = r7.d()
            java.util.List<java.lang.String> r3 = r7.a
            r7 = 0
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r2 = 4
            java.lang.String r4 = "Reload ssid from event failed"
            r1.error(r2, r3, r4, r5, r6)
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.n4.m():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:6:0x000b, B:8:0x000f, B:9:0x0013, B:11:0x0019, B:13:0x0027, B:14:0x002b, B:16:0x002f, B:18:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x004b, B:24:0x0050, B:26:0x0054, B:27:0x0058, B:29:0x005e, B:31:0x006c, B:32:0x0071, B:34:0x0075, B:35:0x0079, B:37:0x007f, B:39:0x008d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:6:0x000b, B:8:0x000f, B:9:0x0013, B:11:0x0019, B:13:0x0027, B:14:0x002b, B:16:0x002f, B:18:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x004b, B:24:0x0050, B:26:0x0054, B:27:0x0058, B:29:0x005e, B:31:0x006c, B:32:0x0071, B:34:0x0075, B:35:0x0079, B:37:0x007f, B:39:0x008d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:6:0x000b, B:8:0x000f, B:9:0x0013, B:11:0x0019, B:13:0x0027, B:14:0x002b, B:16:0x002f, B:18:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x004b, B:24:0x0050, B:26:0x0054, B:27:0x0058, B:29:0x005e, B:31:0x006c, B:32:0x0071, B:34:0x0075, B:35:0x0079, B:37:0x007f, B:39:0x008d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0071 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:6:0x000b, B:8:0x000f, B:9:0x0013, B:11:0x0019, B:13:0x0027, B:14:0x002b, B:16:0x002f, B:18:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x004b, B:24:0x0050, B:26:0x0054, B:27:0x0058, B:29:0x005e, B:31:0x006c, B:32:0x0071, B:34:0x0075, B:35:0x0079, B:37:0x007f, B:39:0x008d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:6:0x000b, B:8:0x000f, B:9:0x0013, B:11:0x0019, B:13:0x0027, B:14:0x002b, B:16:0x002f, B:18:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x004b, B:24:0x0050, B:26:0x0054, B:27:0x0058, B:29:0x005e, B:31:0x006c, B:32:0x0071, B:34:0x0075, B:35:0x0079, B:37:0x007f, B:39:0x008d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n() {
        /*
            r7 = this;
            org.json.JSONObject r0 = r7.y
            if (r0 != 0) goto L6
            goto La3
        L6:
            java.lang.String r1 = "user_unique_id_type"
            r0.remove(r1)
            java.util.List<com.bytedance.bdtracker.m4> r0 = r7.v     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L2f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L92
        L13:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L2f
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L92
            com.bytedance.bdtracker.m4 r2 = (com.bytedance.bdtracker.m4) r2     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = r2.h     // Catch: java.lang.Throwable -> L92
            boolean r3 = com.bytedance.bdtracker.r.d(r3)     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L13
            org.json.JSONObject r0 = r7.y     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r2.h     // Catch: java.lang.Throwable -> L92
        L2b:
            r0.put(r1, r2)     // Catch: java.lang.Throwable -> L92
            return
        L2f:
            java.util.List<com.bytedance.bdtracker.o4> r0 = r7.u     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L50
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L92
        L37:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L50
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L92
            com.bytedance.bdtracker.o4 r2 = (com.bytedance.bdtracker.o4) r2     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = r2.h     // Catch: java.lang.Throwable -> L92
            boolean r3 = com.bytedance.bdtracker.r.d(r3)     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L37
            org.json.JSONObject r0 = r7.y     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r2.h     // Catch: java.lang.Throwable -> L92
            goto L2b
        L50:
            java.util.List<com.bytedance.bdtracker.h4> r0 = r7.t     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L92
        L58:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L71
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L92
            com.bytedance.bdtracker.h4 r2 = (com.bytedance.bdtracker.h4) r2     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = r2.h     // Catch: java.lang.Throwable -> L92
            boolean r3 = com.bytedance.bdtracker.r.d(r3)     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L58
            org.json.JSONObject r0 = r7.y     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r2.h     // Catch: java.lang.Throwable -> L92
            goto L2b
        L71:
            java.util.List<com.bytedance.bdtracker.l4> r0 = r7.s     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto La3
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L92
        L79:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto La3
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L92
            com.bytedance.bdtracker.l4 r2 = (com.bytedance.bdtracker.l4) r2     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = r2.h     // Catch: java.lang.Throwable -> L92
            boolean r3 = com.bytedance.bdtracker.r.d(r3)     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L79
            org.json.JSONObject r0 = r7.y     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r2.h     // Catch: java.lang.Throwable -> L92
            goto L2b
        L92:
            r0 = move-exception
            r5 = r0
            com.bytedance.applog.log.IAppLogLogger r1 = r7.d()
            java.util.List<java.lang.String> r3 = r7.a
            r7 = 0
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r2 = 4
            java.lang.String r4 = "Reload uuid type from event failed"
            r1.error(r2, r3, r4, r5, r6)
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.n4.n():void");
    }

    public final byte[] o() {
        try {
            return h().toString().getBytes("UTF-8");
        } catch (Throwable th) {
            this.d().error(4, this.a, "Convert json to bytes failed", th, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.bdtracker.e4
    public String toString() {
        StringBuilder sb = new StringBuilder("Pack detail:");
        List<l4> list = this.s;
        int size = list != null ? list.size() : 0;
        List<h4> list2 = this.t;
        if (list2 != null) {
            size += list2.size();
        }
        if (size > 0) {
            sb.append("\teventCount=");
            sb.append(size);
        }
        List<o4> list3 = this.u;
        if (list3 != null && !list3.isEmpty()) {
            sb.append("\tpageCount=");
            sb.append(this.u.size());
        }
        List<m4> list4 = this.v;
        if (list4 != null && !list4.isEmpty()) {
            sb.append("\tlaunchCount=");
            sb.append(this.v.size());
        }
        List<r4> list5 = this.w;
        if (list5 != null && !list5.isEmpty()) {
            sb.append("\tterminateCount=");
            sb.append(this.w.size());
        }
        List<s4> list6 = this.x;
        if (list6 != null && !list6.isEmpty()) {
            sb.append("\ttraceCount=");
            sb.append(this.x.size());
        }
        if (this.A > 0) {
            sb.append("\tfailCount=");
            sb.append(this.A);
        }
        return sb.toString();
    }
}
