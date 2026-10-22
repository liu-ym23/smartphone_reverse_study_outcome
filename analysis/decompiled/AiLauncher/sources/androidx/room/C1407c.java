package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import f1.C4037g;
import i1.InterfaceC4161c;
import io.requery.android.database.sqlite.SQLiteDatabase;
import j1.InterfaceC4757d;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b8\b\u0016\u0018\u00002\u00020\u0001Bí\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010%\u001a\u00020\r\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0019H\u0016¢\u0006\u0004\b.\u0010/J\u009f\u0002\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010%\u001a\u00020\r2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(H\u0007¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u00102R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b.\u0010;R\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u0013\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010\u0016\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010;R\u0014\u0010\u0017\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bD\u0010;R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\b5\u0010GR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bH\u00104R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010:R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bN\u0010:R\u0014\u0010%\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010;R\u0016\u0010'\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010)\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010;R\"\u0010Y\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bV\u0010;\u001a\u0004\b9\u0010W\"\u0004\b<\u0010XR\"\u0010_\u001a\u00020\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b7\u0010\\\"\u0004\b]\u0010^¨\u0006`"}, d2 = {"Landroidx/room/c;", "", "Landroid/content/Context;", "context", "", "name", "Lj1/d$c;", "sqliteOpenHelperFactory", "Landroidx/room/RoomDatabase$d;", "migrationContainer", "", "Landroidx/room/RoomDatabase$b;", "callbacks", "", "allowMainThreadQueries", "Landroidx/room/RoomDatabase$JournalMode;", "journalMode", "Ljava/util/concurrent/Executor;", "queryExecutor", "transactionExecutor", "Landroid/content/Intent;", "multiInstanceInvalidationServiceIntent", "requireMigration", "allowDestructiveMigrationOnDowngrade", "", "", "migrationNotRequiredFrom", "copyFromAssetPath", "Ljava/io/File;", "copyFromFile", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "copyFromInputStream", "Landroidx/room/RoomDatabase$e;", "prepackagedDatabaseCallback", "typeConverters", "autoMigrationSpecs", "allowDestructiveMigrationForAllTables", "Li1/c;", "sqliteDriver", "Lkotlin/coroutines/d;", "queryCoroutineContext", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lj1/d$c;Landroidx/room/RoomDatabase$d;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/content/Intent;ZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$e;Ljava/util/List;Ljava/util/List;ZLi1/c;Lkotlin/coroutines/d;)V", "fromVersion", "toVersion", "f", "(II)Z", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;Lj1/d$c;Landroidx/room/RoomDatabase$d;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/content/Intent;ZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$e;Ljava/util/List;Ljava/util/List;ZLi1/c;Lkotlin/coroutines/d;)Landroidx/room/c;", "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Lj1/d$c;", Const.INTENT_KEY_UMID, "Landroidx/room/RoomDatabase$d;", "e", "Ljava/util/List;", "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/room/RoomDatabase$JournalMode;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/concurrent/Executor;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/content/Intent;", "k", "l", "m", "Ljava/util/Set;", "()Ljava/util/Set;", "n", "o", "Ljava/io/File;", "p", "Ljava/util/concurrent/Callable;", "q", "r", "s", "t", "Li1/c;", "u", "Lkotlin/coroutines/d;", "v", "multiInstanceInvalidation", "w", "()Z", "(Z)V", "useTempTrackingTable", "x", "I", "()I", "setPreparedStatementCacheSize$room_runtime", "(I)V", "preparedStatementCacheSize", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: androidx.room.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1407c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4757d.c sqliteOpenHelperFactory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final RoomDatabase.d migrationContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final List<RoomDatabase.b> callbacks;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final boolean allowMainThreadQueries;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final RoomDatabase.JournalMode journalMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Executor queryExecutor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Executor transactionExecutor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Intent multiInstanceInvalidationServiceIntent;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final boolean requireMigration;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final boolean allowDestructiveMigrationOnDowngrade;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final Set<Integer> migrationNotRequiredFrom;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final String copyFromAssetPath;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final File copyFromFile;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final Callable<InputStream> copyFromInputStream;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final List<Object> typeConverters;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final List<Object> autoMigrationSpecs;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final boolean allowDestructiveMigrationForAllTables;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4161c sqliteDriver;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public final kotlin.coroutines.d queryCoroutineContext;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public final boolean multiInstanceInvalidation;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public boolean useTempTrackingTable;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public int preparedStatementCacheSize;

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"LambdaLast"})
    public C1407c(Context context, String str, InterfaceC4757d.c cVar, RoomDatabase.d migrationContainer, List<? extends RoomDatabase.b> list, boolean z10, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, Intent intent, boolean z11, boolean z12, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.e eVar, List<? extends Object> typeConverters, List<Object> autoMigrationSpecs, boolean z13, InterfaceC4161c interfaceC4161c, kotlin.coroutines.d dVar) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(migrationContainer, "migrationContainer");
        kotlin.jvm.internal.p.i(journalMode, "journalMode");
        kotlin.jvm.internal.p.i(queryExecutor, "queryExecutor");
        kotlin.jvm.internal.p.i(transactionExecutor, "transactionExecutor");
        kotlin.jvm.internal.p.i(typeConverters, "typeConverters");
        kotlin.jvm.internal.p.i(autoMigrationSpecs, "autoMigrationSpecs");
        this.context = context;
        this.name = str;
        this.sqliteOpenHelperFactory = cVar;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z10;
        this.journalMode = journalMode;
        this.queryExecutor = queryExecutor;
        this.transactionExecutor = transactionExecutor;
        this.multiInstanceInvalidationServiceIntent = intent;
        this.requireMigration = z11;
        this.allowDestructiveMigrationOnDowngrade = z12;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.typeConverters = typeConverters;
        this.autoMigrationSpecs = autoMigrationSpecs;
        this.allowDestructiveMigrationForAllTables = z13;
        this.sqliteDriver = interfaceC4161c;
        this.queryCoroutineContext = dVar;
        this.multiInstanceInvalidation = intent != null;
        this.useTempTrackingTable = true;
        this.preparedStatementCacheSize = 25;
    }

    public static /* synthetic */ C1407c b(C1407c c1407c, Context context, String str, InterfaceC4757d.c cVar, RoomDatabase.d dVar, List list, boolean z10, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z11, boolean z12, Set set, String str2, File file, Callable callable, RoomDatabase.e eVar, List list2, List list3, boolean z13, InterfaceC4161c interfaceC4161c, kotlin.coroutines.d dVar2, int i10, Object obj) {
        RoomDatabase.e eVar2;
        kotlin.coroutines.d dVar3;
        InterfaceC4161c interfaceC4161c2;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        Context context2 = (i10 & 1) != 0 ? c1407c.context : context;
        String str3 = (i10 & 2) != 0 ? c1407c.name : str;
        InterfaceC4757d.c cVar2 = (i10 & 4) != 0 ? c1407c.sqliteOpenHelperFactory : cVar;
        RoomDatabase.d dVar4 = (i10 & 8) != 0 ? c1407c.migrationContainer : dVar;
        List list4 = (i10 & 16) != 0 ? c1407c.callbacks : list;
        boolean z14 = (i10 & 32) != 0 ? c1407c.allowMainThreadQueries : z10;
        RoomDatabase.JournalMode journalMode2 = (i10 & 64) != 0 ? c1407c.journalMode : journalMode;
        Executor executor3 = (i10 & 128) != 0 ? c1407c.queryExecutor : executor;
        Executor executor4 = (i10 & 256) != 0 ? c1407c.transactionExecutor : executor2;
        Intent intent2 = (i10 & 512) != 0 ? c1407c.multiInstanceInvalidationServiceIntent : intent;
        boolean z15 = (i10 & 1024) != 0 ? c1407c.requireMigration : z11;
        boolean z16 = (i10 & 2048) != 0 ? c1407c.allowDestructiveMigrationOnDowngrade : z12;
        Set set2 = (i10 & 4096) != 0 ? c1407c.migrationNotRequiredFrom : set;
        String str4 = (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? c1407c.copyFromAssetPath : str2;
        Context context3 = context2;
        File file2 = (i10 & 16384) != 0 ? c1407c.copyFromFile : file;
        Callable callable2 = (i10 & 32768) != 0 ? c1407c.copyFromInputStream : callable;
        if ((i10 & 65536) != 0) {
            c1407c.getClass();
            eVar2 = null;
        } else {
            eVar2 = eVar;
        }
        Callable callable3 = callable2;
        List list5 = (i10 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? c1407c.typeConverters : list2;
        List list6 = (i10 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? c1407c.autoMigrationSpecs : list3;
        boolean z17 = (i10 & 524288) != 0 ? c1407c.allowDestructiveMigrationForAllTables : z13;
        InterfaceC4161c interfaceC4161c3 = (i10 & 1048576) != 0 ? c1407c.sqliteDriver : interfaceC4161c;
        if ((i10 & 2097152) != 0) {
            interfaceC4161c2 = interfaceC4161c3;
            dVar3 = c1407c.queryCoroutineContext;
        } else {
            dVar3 = dVar2;
            interfaceC4161c2 = interfaceC4161c3;
        }
        return c1407c.a(context3, str3, cVar2, dVar4, list4, z14, journalMode2, executor3, executor4, intent2, z15, z16, set2, str4, file2, callable3, eVar2, list5, list6, z17, interfaceC4161c2, dVar3);
    }

    public final C1407c a(Context context, String name, InterfaceC4757d.c sqliteOpenHelperFactory, RoomDatabase.d migrationContainer, List<? extends RoomDatabase.b> callbacks, boolean allowMainThreadQueries, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, Intent multiInstanceInvalidationServiceIntent, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, Set<Integer> migrationNotRequiredFrom, String copyFromAssetPath, File copyFromFile, Callable<InputStream> copyFromInputStream, RoomDatabase.e prepackagedDatabaseCallback, List<? extends Object> typeConverters, List<Object> autoMigrationSpecs, boolean allowDestructiveMigrationForAllTables, InterfaceC4161c sqliteDriver, kotlin.coroutines.d queryCoroutineContext) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(migrationContainer, "migrationContainer");
        kotlin.jvm.internal.p.i(journalMode, "journalMode");
        kotlin.jvm.internal.p.i(queryExecutor, "queryExecutor");
        kotlin.jvm.internal.p.i(transactionExecutor, "transactionExecutor");
        kotlin.jvm.internal.p.i(typeConverters, "typeConverters");
        kotlin.jvm.internal.p.i(autoMigrationSpecs, "autoMigrationSpecs");
        C1407c c1407c = new C1407c(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, transactionExecutor, multiInstanceInvalidationServiceIntent, requireMigration, allowDestructiveMigrationOnDowngrade, migrationNotRequiredFrom, copyFromAssetPath, copyFromFile, copyFromInputStream, prepackagedDatabaseCallback, typeConverters, autoMigrationSpecs, allowDestructiveMigrationForAllTables, sqliteDriver, queryCoroutineContext);
        c1407c.useTempTrackingTable = this.useTempTrackingTable;
        c1407c.preparedStatementCacheSize = this.preparedStatementCacheSize;
        return c1407c;
    }

    public final Set<Integer> c() {
        return this.migrationNotRequiredFrom;
    }

    /* renamed from: d, reason: from getter */
    public final int getPreparedStatementCacheSize() {
        return this.preparedStatementCacheSize;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getUseTempTrackingTable() {
        return this.useTempTrackingTable;
    }

    public boolean f(int fromVersion, int toVersion) {
        return C4037g.d(this, fromVersion, toVersion);
    }

    public final void g(boolean z10) {
        this.useTempTrackingTable = z10;
    }
}
