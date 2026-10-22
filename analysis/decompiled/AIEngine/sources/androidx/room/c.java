package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import y1.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2526a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2527b;

    /* renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0177c f2528c;

    /* renamed from: d, reason: collision with root package name */
    public final RoomDatabase.c f2529d;

    /* renamed from: e, reason: collision with root package name */
    public final List<RoomDatabase.b> f2530e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2531f;

    /* renamed from: g, reason: collision with root package name */
    public final RoomDatabase.JournalMode f2532g;
    public final Executor h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f2533i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2534j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f2535k;

    /* renamed from: l, reason: collision with root package name */
    public final Set<Integer> f2536l;

    /* renamed from: m, reason: collision with root package name */
    public final List<Object> f2537m;

    /* renamed from: n, reason: collision with root package name */
    public final List<Object> f2538n;

    @SuppressLint({"LambdaLast"})
    public c(Context context, String str, c.InterfaceC0177c interfaceC0177c, RoomDatabase.c migrationContainer, ArrayList arrayList, boolean z, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean z3, boolean z10, LinkedHashSet linkedHashSet, ArrayList typeConverters, ArrayList autoMigrationSpecs) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(migrationContainer, "migrationContainer");
        kotlin.jvm.internal.g.f(queryExecutor, "queryExecutor");
        kotlin.jvm.internal.g.f(transactionExecutor, "transactionExecutor");
        kotlin.jvm.internal.g.f(typeConverters, "typeConverters");
        kotlin.jvm.internal.g.f(autoMigrationSpecs, "autoMigrationSpecs");
        this.f2526a = context;
        this.f2527b = str;
        this.f2528c = interfaceC0177c;
        this.f2529d = migrationContainer;
        this.f2530e = arrayList;
        this.f2531f = z;
        this.f2532g = journalMode;
        this.h = queryExecutor;
        this.f2533i = transactionExecutor;
        this.f2534j = z3;
        this.f2535k = z10;
        this.f2536l = linkedHashSet;
        this.f2537m = typeConverters;
        this.f2538n = autoMigrationSpecs;
    }
}
