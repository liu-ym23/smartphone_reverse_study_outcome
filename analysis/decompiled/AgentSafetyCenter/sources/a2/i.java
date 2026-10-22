package a2;

import ad.h0;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import b8.d0;
import com.google.android.material.behavior.SwipeDismissBehavior;
import h0.a1;
import h0.c1;
import h0.f0;
import ie.o0;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import k0.k1;
import k0.r2;
import n3.k0;
import n3.m1;
import s.l1;
import stepos.support.v7.widget.StepOSAppBarLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements c6.g, n3.s, d1.q, ie.f, ie.l, n3.c, l.j, y4.e, o3.o, s.o, l1 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f48c;

    /* renamed from: f, reason: collision with root package name */
    public Object f49f;

    public i() {
        this.f48c = 1;
        TimeUnit.MINUTES.getClass();
        dd.d dVar = dd.d.f3311h;
        dVar.getClass();
        d0 d0Var = new d0();
        d0Var.f1946c = 300000000000L;
        d0Var.f1947f = dVar.e();
        d0Var.f1948g = new dd.b(d0Var, androidx.activity.b.n(new StringBuilder(), bd.b.f2080g, " ConnectionPool"));
        d0Var.f1949h = new ConcurrentLinkedQueue();
        VarHandle.storeStoreFence();
        this.f49f = d0Var;
    }

    public static void w(z4.c cVar) throws SQLException {
        SQLiteDatabase sQLiteDatabase = cVar.f16385c;
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `trace_tag` TEXT, `required_network_type` INTEGER NOT NULL, `required_network_request` BLOB NOT NULL DEFAULT x'', `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        sQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '86254750241babac4b8d52996a675549')");
    }

    public static androidx.room.v z(z4.c cVar) {
        HashMap map = new HashMap(2);
        map.put("work_spec_id", new s4.e("work_spec_id", "TEXT", true, 1, null, 1));
        map.put("prerequisite_id", new s4.e("prerequisite_id", "TEXT", true, 2, null, 1));
        HashSet hashSet = new HashSet(2);
        hashSet.add(new s4.f("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        hashSet.add(new s4.f("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(new s4.g("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        hashSet2.add(new s4.g("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
        s4.h hVar = new s4.h("Dependency", map, hashSet, hashSet2);
        s4.h hVarA = s4.h.a(cVar, "Dependency");
        if (!hVar.equals(hVarA)) {
            return new androidx.room.v("Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + hVar + "\n Found:\n" + hVarA, false);
        }
        HashMap map2 = new HashMap(32);
        map2.put("id", new s4.e("id", "TEXT", true, 1, null, 1));
        map2.put("state", new s4.e("state", "INTEGER", true, 0, null, 1));
        map2.put("worker_class_name", new s4.e("worker_class_name", "TEXT", true, 0, null, 1));
        map2.put("input_merger_class_name", new s4.e("input_merger_class_name", "TEXT", true, 0, null, 1));
        map2.put("input", new s4.e("input", "BLOB", true, 0, null, 1));
        map2.put("output", new s4.e("output", "BLOB", true, 0, null, 1));
        map2.put("initial_delay", new s4.e("initial_delay", "INTEGER", true, 0, null, 1));
        map2.put("interval_duration", new s4.e("interval_duration", "INTEGER", true, 0, null, 1));
        map2.put("flex_duration", new s4.e("flex_duration", "INTEGER", true, 0, null, 1));
        map2.put("run_attempt_count", new s4.e("run_attempt_count", "INTEGER", true, 0, null, 1));
        map2.put("backoff_policy", new s4.e("backoff_policy", "INTEGER", true, 0, null, 1));
        map2.put("backoff_delay_duration", new s4.e("backoff_delay_duration", "INTEGER", true, 0, null, 1));
        map2.put("last_enqueue_time", new s4.e("last_enqueue_time", "INTEGER", true, 0, "-1", 1));
        map2.put("minimum_retention_duration", new s4.e("minimum_retention_duration", "INTEGER", true, 0, null, 1));
        map2.put("schedule_requested_at", new s4.e("schedule_requested_at", "INTEGER", true, 0, null, 1));
        map2.put("run_in_foreground", new s4.e("run_in_foreground", "INTEGER", true, 0, null, 1));
        map2.put("out_of_quota_policy", new s4.e("out_of_quota_policy", "INTEGER", true, 0, null, 1));
        map2.put("period_count", new s4.e("period_count", "INTEGER", true, 0, "0", 1));
        map2.put("generation", new s4.e("generation", "INTEGER", true, 0, "0", 1));
        map2.put("next_schedule_time_override", new s4.e("next_schedule_time_override", "INTEGER", true, 0, "9223372036854775807", 1));
        map2.put("next_schedule_time_override_generation", new s4.e("next_schedule_time_override_generation", "INTEGER", true, 0, "0", 1));
        map2.put("stop_reason", new s4.e("stop_reason", "INTEGER", true, 0, "-256", 1));
        map2.put("trace_tag", new s4.e("trace_tag", "TEXT", false, 0, null, 1));
        map2.put("required_network_type", new s4.e("required_network_type", "INTEGER", true, 0, null, 1));
        map2.put("required_network_request", new s4.e("required_network_request", "BLOB", true, 0, "x''", 1));
        map2.put("requires_charging", new s4.e("requires_charging", "INTEGER", true, 0, null, 1));
        map2.put("requires_device_idle", new s4.e("requires_device_idle", "INTEGER", true, 0, null, 1));
        map2.put("requires_battery_not_low", new s4.e("requires_battery_not_low", "INTEGER", true, 0, null, 1));
        map2.put("requires_storage_not_low", new s4.e("requires_storage_not_low", "INTEGER", true, 0, null, 1));
        map2.put("trigger_content_update_delay", new s4.e("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
        map2.put("trigger_max_content_delay", new s4.e("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
        map2.put("content_uri_triggers", new s4.e("content_uri_triggers", "BLOB", true, 0, null, 1));
        HashSet hashSet3 = new HashSet(0);
        HashSet hashSet4 = new HashSet(2);
        hashSet4.add(new s4.g("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
        hashSet4.add(new s4.g("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
        s4.h hVar2 = new s4.h("WorkSpec", map2, hashSet3, hashSet4);
        s4.h hVarA2 = s4.h.a(cVar, "WorkSpec");
        if (!hVar2.equals(hVarA2)) {
            return new androidx.room.v("WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + hVar2 + "\n Found:\n" + hVarA2, false);
        }
        HashMap map3 = new HashMap(2);
        map3.put("tag", new s4.e("tag", "TEXT", true, 1, null, 1));
        map3.put("work_spec_id", new s4.e("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet5 = new HashSet(1);
        hashSet5.add(new s4.f("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet6 = new HashSet(1);
        hashSet6.add(new s4.g("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        s4.h hVar3 = new s4.h("WorkTag", map3, hashSet5, hashSet6);
        s4.h hVarA3 = s4.h.a(cVar, "WorkTag");
        if (!hVar3.equals(hVarA3)) {
            return new androidx.room.v("WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + hVar3 + "\n Found:\n" + hVarA3, false);
        }
        HashMap map4 = new HashMap(3);
        map4.put("work_spec_id", new s4.e("work_spec_id", "TEXT", true, 1, null, 1));
        map4.put("generation", new s4.e("generation", "INTEGER", true, 2, "0", 1));
        map4.put("system_id", new s4.e("system_id", "INTEGER", true, 0, null, 1));
        HashSet hashSet7 = new HashSet(1);
        hashSet7.add(new s4.f("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        s4.h hVar4 = new s4.h("SystemIdInfo", map4, hashSet7, new HashSet(0));
        s4.h hVarA4 = s4.h.a(cVar, "SystemIdInfo");
        if (!hVar4.equals(hVarA4)) {
            return new androidx.room.v("SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + hVar4 + "\n Found:\n" + hVarA4, false);
        }
        HashMap map5 = new HashMap(2);
        map5.put("name", new s4.e("name", "TEXT", true, 1, null, 1));
        map5.put("work_spec_id", new s4.e("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet8 = new HashSet(1);
        hashSet8.add(new s4.f("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet9 = new HashSet(1);
        hashSet9.add(new s4.g("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        s4.h hVar5 = new s4.h("WorkName", map5, hashSet8, hashSet9);
        s4.h hVarA5 = s4.h.a(cVar, "WorkName");
        if (!hVar5.equals(hVarA5)) {
            return new androidx.room.v("WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + hVar5 + "\n Found:\n" + hVarA5, false);
        }
        HashMap map6 = new HashMap(2);
        map6.put("work_spec_id", new s4.e("work_spec_id", "TEXT", true, 1, null, 1));
        map6.put("progress", new s4.e("progress", "BLOB", true, 0, null, 1));
        HashSet hashSet10 = new HashSet(1);
        hashSet10.add(new s4.f("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        s4.h hVar6 = new s4.h("WorkProgress", map6, hashSet10, new HashSet(0));
        s4.h hVarA6 = s4.h.a(cVar, "WorkProgress");
        if (!hVar6.equals(hVarA6)) {
            return new androidx.room.v("WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + hVar6 + "\n Found:\n" + hVarA6, false);
        }
        HashMap map7 = new HashMap(2);
        map7.put("key", new s4.e("key", "TEXT", true, 1, null, 1));
        map7.put("long_value", new s4.e("long_value", "INTEGER", false, 0, null, 1));
        s4.h hVar7 = new s4.h("Preference", map7, new HashSet(0), new HashSet(0));
        s4.h hVarA7 = s4.h.a(cVar, "Preference");
        if (hVar7.equals(hVarA7)) {
            return new androidx.room.v(null, true);
        }
        return new androidx.room.v("Preference(androidx.work.impl.model.Preference).\n Expected:\n" + hVar7 + "\n Found:\n" + hVarA7, false);
    }

    public ma.a A(n6.a aVar, v1.t tVar) {
        int i;
        long jE;
        long j10;
        boolean z10;
        p.n nVar = (p.n) this.f49f;
        ArrayList arrayList = (ArrayList) aVar.f8776c;
        p.n nVar2 = new p.n(arrayList.size());
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            o1.u uVar = (o1.u) arrayList.get(i3);
            long j11 = uVar.f9088a;
            long j12 = uVar.f9089b;
            o1.t tVar2 = (o1.t) nVar.c(j11);
            if (tVar2 == null) {
                i = i3;
                j10 = j12;
                jE = uVar.f9091d;
                z10 = false;
            } else {
                long j13 = tVar2.f9085a;
                boolean z11 = tVar2.f9087c;
                i = i3;
                jE = tVar.E(tVar2.f9086b);
                j10 = j13;
                z10 = z11;
            }
            long j14 = uVar.f9088a;
            ArrayList arrayList2 = arrayList;
            int i10 = size;
            nVar2.e(new o1.s(j14, uVar.f9089b, uVar.f9091d, uVar.f9092e, uVar.f9093f, j10, jE, z10, uVar.f9094g, uVar.i, uVar.f9096j, uVar.f9097k), j14);
            boolean z12 = uVar.f9092e;
            if (z12) {
                long j15 = uVar.f9090c;
                o1.t tVar3 = new o1.t();
                tVar3.f9085a = j12;
                tVar3.f9086b = j15;
                tVar3.f9087c = z12;
                VarHandle.storeStoreFence();
                nVar.e(tVar3, j11);
            } else {
                nVar.f(j11);
            }
            i3 = i + 1;
            arrayList = arrayList2;
            size = i10;
        }
        ma.a aVar2 = new ma.a();
        aVar2.f8533b = nVar2;
        aVar2.f8534c = aVar;
        VarHandle.storeStoreFence();
        return aVar2;
    }

    @Override // s.l1, s.j1
    public boolean a() {
        ((p5.i) this.f49f).getClass();
        return false;
    }

    @Override // s.j1
    public long b(s.n nVar, s.n nVar2, s.n nVar3) {
        return ((p5.i) this.f49f).b(nVar, nVar2, nVar3);
    }

    @Override // o3.o
    public boolean c(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f49f;
        if (!swipeDismissBehavior.c()) {
            return false;
        }
        boolean z10 = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.f2406d;
        int width = (!(i == 0 && z10) && (i != 1 || z10)) ? view.getWidth() : -view.getWidth();
        WeakHashMap weakHashMap = k0.f8724a;
        view.offsetLeftAndRight(width);
        view.setAlpha(0.0f);
        return true;
    }

    @Override // ie.l
    public Object convert(Object obj) {
        return Optional.ofNullable(((ie.l) this.f49f).convert((h0) obj));
    }

    @Override // c6.g
    public void d(c6.a aVar, Bitmap bitmap, Map map) {
        ((wd.a) this.f49f).i(aVar, bitmap, map, a.a.z(bitmap));
    }

    @Override // d1.q
    public long e() {
        h0.h0 h0Var = (h0.h0) this.f49f;
        long jE = h0Var.f4995x.e();
        if (jE != 16) {
            return jE;
        }
        a1 a1Var = (a1) u1.f.h(h0Var, c1.f4929b);
        if (a1Var != null) {
            long j10 = a1Var.f4916a;
            if (j10 != 16) {
                return j10;
            }
        }
        return ((d1.p) u1.f.h(h0Var, f0.f4961a)).f3026a;
    }

    @Override // l.j
    public void f(l.l lVar) {
        switch (this.f48c) {
            case 17:
                i iVar = ((ActionMenuView) this.f49f).f797y;
                if (iVar != null) {
                    iVar.f(lVar);
                    break;
                }
                break;
            default:
                Toolbar toolbar = (Toolbar) this.f49f;
                m.k kVar = toolbar.f804c.f796x;
                if (kVar == null || !kVar.h()) {
                    toolbar.K.c();
                    break;
                }
                break;
        }
    }

    @Override // y4.e
    public void g(y4.d dVar) {
        p4.e eVar = (p4.e) this.f49f;
        int length = eVar.f9704h.length;
        for (int i = 1; i < length; i++) {
            int i3 = eVar.f9704h[i];
            if (i3 == 1) {
                dVar.c(i, eVar.i[i]);
            } else if (i3 == 2) {
                dVar.j(i, eVar.f9705j[i]);
            } else if (i3 == 3) {
                String str = eVar.f9706k[i];
                str.getClass();
                dVar.h(i, str);
            } else if (i3 == 4) {
                byte[] bArr = eVar.f9707l[i];
                bArr.getClass();
                dVar.s(i, bArr);
            } else if (i3 == 5) {
                dVar.B(i);
            }
        }
    }

    @Override // s.o
    public s.y get(int i) {
        return (s.z) this.f49f;
    }

    @Override // s.j1
    public s.n h(long j10, s.n nVar, s.n nVar2, s.n nVar3) {
        return ((p5.i) this.f49f).h(j10, nVar, nVar2, nVar3);
    }

    @Override // c6.g
    public c6.b i(c6.a aVar) {
        return null;
    }

    @Override // l.j
    public boolean j(l.l lVar, MenuItem menuItem) {
        switch (this.f48c) {
            case 17:
                m.n nVar = ((ActionMenuView) this.f49f).D;
                if (nVar != null) {
                    ((Toolbar) ((a1.g) nVar).f19f).K.b();
                    break;
                }
                break;
        }
        return false;
    }

    @Override // s.j1
    public s.n k(long j10, s.n nVar, s.n nVar2, s.n nVar3) {
        return ((p5.i) this.f49f).k(j10, nVar, nVar2, nVar3);
    }

    @Override // ie.f
    public void l(ie.c cVar, o0 o0Var) {
        kc.g gVar = (kc.g) this.f49f;
        if (!o0Var.f6056a.e()) {
            gVar.resumeWith(id.c.l(new androidx.fragment.app.d(o0Var)));
            return;
        }
        Object obj = o0Var.f6057b;
        if (obj != null) {
            gVar.resumeWith(obj);
            return;
        }
        ad.z zVarO = cVar.o();
        zVarO.getClass();
        Object objCast = ie.p.class.cast(((Map) zVarO.f641f).get(ie.p.class));
        if (objCast == null) {
            jb.c cVar2 = new jb.c();
            yb.k.e(cVar2, yb.k.class.getName());
            throw cVar2;
        }
        Method method = ((ie.p) objCast).f6058a;
        StringBuilder sb2 = new StringBuilder("Response from ");
        Class<?> declaringClass = method.getDeclaringClass();
        declaringClass.getClass();
        sb2.append(declaringClass.getName());
        sb2.append('.');
        sb2.append(method.getName());
        sb2.append(" was null but response body type was declared as non-null");
        gVar.resumeWith(id.c.l(new jb.c(sb2.toString())));
    }

    @Override // n3.c
    public void m() {
        l.l lVar = ((l.n) this.f49f).f7622n;
        lVar.f7590h = true;
        lVar.p(true);
    }

    @Override // y4.e
    public String n() {
        return ((p4.e) this.f49f).f9711f;
    }

    @Override // n3.s
    public m1 p(View view, m1 m1Var) {
        StepOSAppBarLayout stepOSAppBarLayout = (StepOSAppBarLayout) this.f49f;
        m1 m1Var2 = stepOSAppBarLayout.getFitsSystemWindows() ? m1Var : null;
        if (!Objects.equals(stepOSAppBarLayout.f2350k, m1Var2)) {
            stepOSAppBarLayout.f2350k = m1Var2;
            stepOSAppBarLayout.setWillNotDraw(!(stepOSAppBarLayout.B != null && stepOSAppBarLayout.getTopInset() > 0));
            stepOSAppBarLayout.requestLayout();
        }
        return m1Var;
    }

    @Override // s.j1
    public s.n s(s.n nVar, s.n nVar2, s.n nVar3) {
        return ((p5.i) this.f49f).s(nVar, nVar2, nVar3);
    }

    @Override // ie.f
    public void t(ie.c cVar, Throwable th) {
        ((kc.g) this.f49f).resumeWith(id.c.l(th));
    }

    public String u(Context context) {
        if (((ta.a) this.f49f) == null) {
            this.f49f = new ta.a(context, "com.stepos.statsapp.v3.umid");
        }
        String string = ((ta.a) this.f49f).f13291a.getString("UMID", "");
        ua.c.a("UmidFetcher", "getLocalUmId umId:" + string);
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String v(android.content.Context r12) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.i.v(android.content.Context):java.lang.String");
    }

    public void x() {
        ((k0.v) this.f49f).getClass();
    }

    public r2 y() {
        a4.j jVarA = a4.j.a();
        if (jVarA.b() == 1) {
            return new k2.l(true);
        }
        k1 k1VarV = k0.z.v(Boolean.FALSE);
        k2.h hVar = new k2.h();
        hVar.f7202c = k1VarV;
        hVar.f7203f = this;
        VarHandle.storeStoreFence();
        jVarA.g(hVar);
        return k1VarV;
    }

    @Override // c6.g
    public void q(int i) {
    }

    public /* synthetic */ i(int i) {
        this.f48c = i;
    }
}
