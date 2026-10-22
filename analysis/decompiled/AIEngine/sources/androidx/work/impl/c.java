package androidx.work.impl;

import android.content.Context;
import android.content.res.Resources;
import androidx.datastore.preferences.protobuf.b1;
import androidx.room.RoomDatabase;
import androidx.room.j;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.stepos.aiengine.R;
import i2.s;
import i2.t;
import kotlin.jvm.internal.g;
import mb.m;
import o2.n;
import r2.h;
import r2.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {
    public static final b a(Context context, androidx.work.a configuration) throws Resources.NotFoundException {
        RoomDatabase.a aVarA;
        g.f(context, "context");
        g.f(configuration, "configuration");
        s2.c cVar = new s2.c(configuration.f2816c);
        Context applicationContext = context.getApplicationContext();
        g.e(applicationContext, "context.applicationContext");
        k kVar = cVar.f11878a;
        g.e(kVar, "workTaskExecutor.serialTaskExecutor");
        b1 clock = configuration.f2817d;
        boolean z = context.getResources().getBoolean(R.bool.workmanager_test_configuration);
        g.f(clock, "clock");
        if (z) {
            aVarA = new RoomDatabase.a(applicationContext, WorkDatabase.class, null);
            aVarA.f2513j = true;
        } else {
            aVarA = j.a(applicationContext, WorkDatabase.class, "androidx.work.workdb");
            aVarA.f2512i = new com.google.android.material.button.a(applicationContext);
        }
        aVarA.f2511g = kVar;
        aVarA.f2508d.add(new i2.a(clock));
        aVarA.a(i2.c.f9452f);
        aVarA.a(new i2.g(applicationContext, 2, 3));
        aVarA.a(i2.e.f9460c);
        aVarA.a(i2.d.f9457f);
        aVarA.a(new i2.g(applicationContext, 5, 6));
        aVarA.a(i2.c.f9453g);
        aVarA.a(i2.d.f9458g);
        aVarA.a(i2.c.h);
        aVarA.a(new t(applicationContext));
        aVarA.a(new i2.g(applicationContext, 10, 11));
        aVarA.a(i2.c.f9450d);
        aVarA.a(i2.d.f9455d);
        aVarA.a(i2.c.f9451e);
        aVarA.a(i2.d.f9456e);
        aVarA.a(new i2.g(applicationContext, 21, 22));
        aVarA.f2515l = false;
        aVarA.f2516m = true;
        WorkDatabase workDatabase = (WorkDatabase) aVarA.b();
        Context applicationContext2 = context.getApplicationContext();
        g.e(applicationContext2, "context.applicationContext");
        n nVar = new n(applicationContext2, cVar);
        a aVar = new a(context.getApplicationContext(), configuration, cVar, workDatabase);
        WorkManagerImplExtKt$WorkManagerImpl$1 schedulersCreator = WorkManagerImplExtKt$WorkManagerImpl$1.f2843a;
        g.f(schedulersCreator, "schedulersCreator");
        String str = i2.j.f9469a;
        l2.c cVar2 = new l2.c(context, workDatabase, configuration);
        h.a(context, SystemJobService.class, true);
        h2.j.d().a(i2.j.f9469a, "Created SystemJobScheduler and enabled SystemJobService");
        return new b(context.getApplicationContext(), configuration, cVar, workDatabase, m.b0(cVar2, new j2.c(context, configuration, nVar, aVar, new s(aVar, cVar), cVar)), aVar, nVar);
    }
}
