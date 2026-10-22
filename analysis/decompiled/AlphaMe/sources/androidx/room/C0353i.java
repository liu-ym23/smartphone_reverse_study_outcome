package androidx.room;

import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.room.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0353i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4205a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4206b;

    /* renamed from: c, reason: collision with root package name */
    public final k0.f f4207c;

    /* renamed from: d, reason: collision with root package name */
    public final z f4208d;

    /* renamed from: e, reason: collision with root package name */
    public final List f4209e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4210f;

    /* renamed from: g, reason: collision with root package name */
    public final y f4211g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f4212h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f4213i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f4214j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f4215k;

    /* renamed from: l, reason: collision with root package name */
    public final Set f4216l;

    /* renamed from: m, reason: collision with root package name */
    public final List f4217m;

    /* renamed from: n, reason: collision with root package name */
    public final List f4218n;

    public C0353i(Context context, String str, k0.f sqliteOpenHelperFactory, z migrationContainer, ArrayList arrayList, boolean z4, y journalMode, Executor queryExecutor, Executor transactionExecutor, boolean z5, boolean z6, LinkedHashSet linkedHashSet, ArrayList typeConverters, ArrayList autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(migrationContainer, "migrationContainer");
        Intrinsics.checkNotNullParameter(journalMode, "journalMode");
        Intrinsics.checkNotNullParameter(queryExecutor, "queryExecutor");
        Intrinsics.checkNotNullParameter(transactionExecutor, "transactionExecutor");
        Intrinsics.checkNotNullParameter(typeConverters, "typeConverters");
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        this.f4205a = context;
        this.f4206b = str;
        this.f4207c = sqliteOpenHelperFactory;
        this.f4208d = migrationContainer;
        this.f4209e = arrayList;
        this.f4210f = z4;
        this.f4211g = journalMode;
        this.f4212h = queryExecutor;
        this.f4213i = transactionExecutor;
        this.f4214j = z5;
        this.f4215k = z6;
        this.f4216l = linkedHashSet;
        this.f4217m = typeConverters;
        this.f4218n = autoMigrationSpecs;
    }
}
