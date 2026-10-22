package androidx.work.impl;

import B0.a;
import B0.c;
import B0.d;
import B0.e;
import B0.f;
import B0.h;
import B0.i;
import B0.l;
import B0.m;
import B0.n;
import B0.p;
import B0.r;
import B0.u;
import B0.v;
import B0.w;
import E3.b;
import androidx.annotation.RestrictTo;
import androidx.room.A;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.TypeConverters;
import e.EnumC0546d;
import kotlin.Metadata;
import s0.C0850h;

@TypeConverters({C0850h.class, f.class})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/work/impl/WorkDatabase;", "Landroidx/room/A;", "<init>", "()V", "E3/b", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@Database(autoMigrations = {@AutoMigration(from = 13, to = 14), @AutoMigration(from = 14, spec = b.class, to = 15), @AutoMigration(from = 16, to = 17), @AutoMigration(from = 17, to = 18), @AutoMigration(from = 18, to = 19), @AutoMigration(from = 19, spec = b.class, to = 20)}, entities = {a.class, r.class, v.class, h.class, l.class, n.class, d.class}, version = 20)
@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public abstract class WorkDatabase extends A {
    public abstract c b();

    public abstract e c();

    public abstract i d();

    public abstract m e();

    public abstract p f();

    public abstract u g();

    public abstract w h();
}
