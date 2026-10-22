package androidx.room;

import B9.Q;
import C7.r;
import D6.i;
import D7.v;
import D7.w;
import H7.f;
import H7.h;
import S7.n;
import Z7.d;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.concurrent.CloseBarrier;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.support.AutoCloser;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.room.support.AutoClosingRoomOpenHelperFactory;
import androidx.room.support.PrePackagedCopyOpenHelper;
import androidx.room.support.PrePackagedCopyOpenHelperFactory;
import androidx.room.support.QueryInterceptorOpenHelperFactory;
import androidx.room.util.DBUtil;
import androidx.room.util.KClassUtil;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.driver.SupportSQLiteConnection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1702U;
import m9.AbstractC1729v;
import m9.ExecutorC1690H;
import m9.InterfaceC1733z;
import m9.b0;
import m9.c0;
import m9.r0;
import s9.C1923c;

@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u0000 ·\u00012\u00020\u0001:\u000e¸\u0001¹\u0001º\u0001»\u0001¼\u0001½\u0001·\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\u0007\u0010\nJ#\u0010\u0010\u001a\u00020\r2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\f\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u001a\u0010\u001b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0005\u0012\u0004\u0012\u00020\u001a0\u0019H\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u001a\u0010\u001b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\t\u0012\u0004\u0012\u00020\u001a0\u0019H\u0017¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u0011H\u0015¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0015¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H$¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0007¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u00020.H\u0000¢\u0006\u0004\b1\u00100J)\u00103\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u001c0\u0019H\u0015¢\u0006\u0004\b3\u00104J)\u00105\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u001c0\u0019H\u0015¢\u0006\u0004\b5\u00104J\u001d\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u000506H\u0017¢\u0006\u0004\b7\u00108J\u001d\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\t06H\u0017¢\u0006\u0004\b9\u00108J\u000f\u0010:\u001a\u00020\rH'¢\u0006\u0004\b:\u0010\u0003J+\u0010@\u001a\u00020\r2\u0006\u0010<\u001a\u00020;2\u0012\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0=\"\u00020>H\u0005¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\rH\u0016¢\u0006\u0004\bB\u0010\u0003J\u000f\u0010C\u001a\u00020\rH\u0017¢\u0006\u0004\bC\u0010\u0003J\u000f\u0010D\u001a\u00020\rH\u0017¢\u0006\u0004\bD\u0010\u0003JB\u0010K\u001a\u00028\u0000\"\u0004\b\u0000\u0010E2\u0006\u0010F\u001a\u00020;2\"\u0010J\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000I\u0012\u0006\u0012\u0004\u0018\u00010\u00010GH\u0087@¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020;H\u0007¢\u0006\u0004\bM\u0010NJ+\u0010O\u001a\u00020Q2\u0006\u0010O\u001a\u00020>2\u0012\u0010P\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010=H\u0016¢\u0006\u0004\bO\u0010RJ#\u0010O\u001a\u00020Q2\u0006\u0010O\u001a\u00020S2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010TH\u0017¢\u0006\u0004\bO\u0010VJ\u0017\u0010Y\u001a\u00020X2\u0006\u0010W\u001a\u00020>H\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\rH\u0017¢\u0006\u0004\b[\u0010\u0003J\u000f\u0010\\\u001a\u00020\rH\u0017¢\u0006\u0004\b\\\u0010\u0003J\u000f\u0010]\u001a\u00020\rH\u0017¢\u0006\u0004\b]\u0010\u0003J\u0017\u0010`\u001a\u00020\r2\u0006\u0010_\u001a\u00020^H\u0016¢\u0006\u0004\b`\u0010aJ#\u0010`\u001a\u00028\u0000\"\u0004\b\u0000\u0010b2\f\u0010_\u001a\b\u0012\u0004\u0012\u00028\u00000cH\u0016¢\u0006\u0004\b`\u0010dJ\u0017\u0010g\u001a\u00020\r2\u0006\u0010f\u001a\u00020eH\u0015¢\u0006\u0004\bg\u0010hJ\u0017\u0010g\u001a\u00020\r2\u0006\u0010j\u001a\u00020iH\u0005¢\u0006\u0004\bg\u0010kJ\u000f\u0010l\u001a\u00020;H\u0016¢\u0006\u0004\bl\u0010NJ(\u0010n\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\"2\b\u0010m\u001a\u0004\u0018\u00010\"H\u0082\b¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020\rH\u0002¢\u0006\u0004\bp\u0010\u0003J\u000f\u0010q\u001a\u00020\rH\u0002¢\u0006\u0004\bq\u0010\u0003J\u000f\u0010r\u001a\u00020\rH\u0002¢\u0006\u0004\br\u0010\u0003J#\u0010`\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010_\u001a\b\u0012\u0004\u0012\u00028\u00000sH\u0002¢\u0006\u0004\b`\u0010tR\u001e\u0010u\u001a\u0004\u0018\u00010e8\u0004@\u0004X\u0085\u000e¢\u0006\f\n\u0004\bu\u0010v\u0012\u0004\bw\u0010\u0003R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010xR\u0016\u0010y\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010{\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010~\u001a\u00020}8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010\u007fR\u0019\u0010\u0081\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0083\u0001\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008a\u0001\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R)\u0010\u008d\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u001c8\u0004@\u0004X\u0085\u000e¢\u0006\u000f\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u0012\u0005\b\u008f\u0001\u0010\u0003R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R#\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020.0\u0093\u00018G¢\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R(\u0010\u0099\u0001\u001a\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R(\u0010\u009b\u0001\u001a\u00020;8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u009b\u0001\u0010\u008b\u0001\u001a\u0005\b\u009c\u0001\u0010N\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0016\u0010¡\u0001\u001a\u0004\u0018\u00010>8G¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0017\u0010¤\u0001\u001a\u00020}8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010¦\u0001\u001a\u00020}8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¥\u0001\u0010£\u0001R\u0016\u0010m\u001a\u00020\"8VX\u0096\u0004¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R\u0015\u0010¬\u0001\u001a\u00030©\u00018G¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0016\u0010®\u0001\u001a\u00020(8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u00ad\u0001\u0010*R0\u0010°\u0001\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u001c0\u00198@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¯\u0001\u00104R\u0016\u0010±\u0001\u001a\u00020;8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b±\u0001\u0010NR\u0016\u0010³\u0001\u001a\u00020;8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010NR\u0016\u0010µ\u0001\u001a\u00020;8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010NR\u0016\u0010¶\u0001\u001a\u00020;8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010N¨\u0006¾\u0001"}, d2 = {"Landroidx/room/RoomDatabase;", "", AppAgent.CONSTRUCT, "()V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "klass", "getTypeConverter", "(Ljava/lang/Class;)Ljava/lang/Object;", "LZ7/d;", "(LZ7/d;)Ljava/lang/Object;", "kclass", "converter", "LC7/r;", "addTypeConverter$room_runtime", "(LZ7/d;Ljava/lang/Object;)V", "addTypeConverter", "Landroidx/room/DatabaseConfiguration;", "configuration", "init", "(Landroidx/room/DatabaseConfiguration;)V", "Landroidx/room/RoomConnectionManager;", "createConnectionManager$room_runtime", "(Landroidx/room/DatabaseConfiguration;)Landroidx/room/RoomConnectionManager;", "createConnectionManager", "", "Landroidx/room/migration/AutoMigrationSpec;", "autoMigrationSpecs", "", "Landroidx/room/migration/Migration;", "getAutoMigrations", "(Ljava/util/Map;)Ljava/util/List;", "createAutoMigrations", "config", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "createOpenHelper", "(Landroidx/room/DatabaseConfiguration;)Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/RoomOpenDelegateMarker;", "createOpenDelegate", "()Landroidx/room/RoomOpenDelegateMarker;", "Landroidx/room/InvalidationTracker;", "createInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "Lm9/z;", "getCoroutineScope", "()Lm9/z;", "LH7/h;", "getQueryContext", "()LH7/h;", "getTransactionContext$room_runtime", "getTransactionContext", "getRequiredTypeConverters", "()Ljava/util/Map;", "getRequiredTypeConverterClasses", "", "getRequiredAutoMigrationSpecs", "()Ljava/util/Set;", "getRequiredAutoMigrationSpecClasses", "clearAllTables", "", "hasForeignKeys", "", "", "tableNames", "performClear", "(Z[Ljava/lang/String;)V", "close", "assertNotMainThread", "assertNotSuspendingTransaction", "R", "isReadOnly", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "LH7/c;", "block", "useConnection", "(ZLS7/n;LH7/c;)Ljava/lang/Object;", "inCompatibilityMode", "()Z", "query", "args", "Landroid/database/Cursor;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroid/os/CancellationSignal;", "signal", "(Landroidx/sqlite/db/SupportSQLiteQuery;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "sql", "Landroidx/sqlite/db/SupportSQLiteStatement;", "compileStatement", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteStatement;", "beginTransaction", "endTransaction", "setTransactionSuccessful", "Ljava/lang/Runnable;", "body", "runInTransaction", "(Ljava/lang/Runnable;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "internalInitInvalidationTracker", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "connection", "(Landroidx/sqlite/SQLiteConnection;)V", "inTransaction", "openHelper", "unwrapOpenHelper", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;)Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "onClosed", "internalBeginTransaction", "internalEndTransaction", "Lkotlin/Function0;", "(LS7/a;)Ljava/lang/Object;", "mDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getMDatabase$annotations", "Landroidx/room/DatabaseConfiguration;", "coroutineScope", "Lm9/z;", "transactionContext", "LH7/h;", "Ljava/util/concurrent/Executor;", "internalQueryExecutor", "Ljava/util/concurrent/Executor;", "internalTransactionExecutor", "connectionManager", "Landroidx/room/RoomConnectionManager;", "internalTracker", "Landroidx/room/InvalidationTracker;", "Landroidx/room/concurrent/CloseBarrier;", "closeBarrier", "Landroidx/room/concurrent/CloseBarrier;", "getCloseBarrier$room_runtime", "()Landroidx/room/concurrent/CloseBarrier;", "allowMainThreadQueries", "Z", "Landroidx/room/RoomDatabase$Callback;", "mCallbacks", "Ljava/util/List;", "getMCallbacks$annotations", "Landroidx/room/support/AutoCloser;", "autoCloser", "Landroidx/room/support/AutoCloser;", "Ljava/lang/ThreadLocal;", "suspendingTransactionContext", "Ljava/lang/ThreadLocal;", "getSuspendingTransactionContext", "()Ljava/lang/ThreadLocal;", "", "typeConverters", "Ljava/util/Map;", "useTempTrackingTable", "getUseTempTrackingTable$room_runtime", "setUseTempTrackingTable$room_runtime", "(Z)V", "getPath", "()Ljava/lang/String;", SingleFileBundle.KEY_PATH, "getQueryExecutor", "()Ljava/util/concurrent/Executor;", "queryExecutor", "getTransactionExecutor", "transactionExecutor", "getOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/sqlite/SQLiteDriver;", "getDriver", "()Landroidx/sqlite/SQLiteDriver;", "driver", "getInvalidationTracker", "invalidationTracker", "getRequiredTypeConverterClassesMap$room_runtime", "requiredTypeConverterClassesMap", "isOpen", "isOpenInternal$room_runtime", "isOpenInternal", "isMainThread$room_runtime", "isMainThread", "isThreadInSuspendingTransaction", "Companion", "JournalMode", "Builder", "MigrationContainer", "Callback", "PrepackagedDatabaseCallback", "QueryCallback", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RoomDatabase {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;
    private DatabaseConfiguration configuration;
    private RoomConnectionManager connectionManager;
    private InterfaceC1733z coroutineScope;
    private Executor internalQueryExecutor;
    private InvalidationTracker internalTracker;
    private Executor internalTransactionExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected List<? extends Callback> mCallbacks;
    protected volatile SupportSQLiteDatabase mDatabase;
    private h transactionContext;
    private final CloseBarrier closeBarrier = new CloseBarrier(new RoomDatabase$closeBarrier$1(this));
    private final ThreadLocal<h> suspendingTransactionContext = new ThreadLocal<>();
    private final Map<d, Object> typeConverters = new LinkedHashMap();
    private boolean useTempTrackingTable = true;

    @Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0010\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B9\b\u0011\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB)\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0011\u0010\u0015J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0018\u0010\u001aJ#\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u001e\u0010 J\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\t\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b\"\u0010#J)\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0$\"\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016¢\u0006\u0004\b-\u0010.J\u001d\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u001d\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u001d\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b7\u00106J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016¢\u0006\u0004\b8\u0010.J\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010:\u001a\u000209H\u0017¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0017¢\u0006\u0004\b=\u0010.J\u001b\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b=\u0010@J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0017¢\u0006\u0004\bA\u0010.J\u001b\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010?\u001a\u00020>¢\u0006\u0004\bA\u0010@J!\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010D\u001a\u00020B\"\u00020CH\u0017¢\u0006\u0004\bE\u0010FJ)\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010?\u001a\u00020>2\n\u0010D\u001a\u00020B\"\u00020CH\u0016¢\u0006\u0004\bE\u0010GJ\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0014\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ%\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010L\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\bM\u0010NJ#\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000b\u001a\u00020O2\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010PJ\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Q\u001a\u00020\u0003H\u0016¢\u0006\u0004\bR\u0010SJ'\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010U\u001a\u00020T2\u0006\u0010W\u001a\u00020VH\u0017¢\u0006\u0004\bX\u0010YJ\u001b\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010[\u001a\u00020Z¢\u0006\u0004\b\\\u0010]J\u001b\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000b\u001a\u00020O¢\u0006\u0004\b^\u0010_J\u001d\u0010a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010`\u001a\u00020>H\u0007¢\u0006\u0004\ba\u0010@J\u000f\u0010b\u001a\u00028\u0000H\u0016¢\u0006\u0004\bb\u0010cR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010dR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010fR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010gR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020H0h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010mR\u0018\u0010n\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010p\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00030h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010jR\u0018\u0010s\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010oR\u0018\u0010t\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010oR\u0018\u0010u\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010-\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010wR\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010xR\u0018\u0010y\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010{R\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010|R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR \u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020C0\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001e\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020C0\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0082\u0001R\u001c\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020)0h8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010jR\u0018\u0010\u0085\u0001\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010wR\u0018\u0010\u0086\u0001\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010wR\u0018\u0010\u0087\u0001\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010wR\u001a\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010fR\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R!\u0010\u008b\u0001\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0019\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b[\u0010\u008d\u0001R\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010qR\u0018\u0010\u008f\u0001\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010w¨\u0006\u0090\u0001"}, d2 = {"Landroidx/room/RoomDatabase$Builder;", "Landroidx/room/RoomDatabase;", ExifInterface.GPS_DIRECTION_TRUE, "", "LZ7/d;", "klass", "", HintConstants.AUTOFILL_HINT_NAME, "Lkotlin/Function0;", "factory", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(LZ7/d;Ljava/lang/String;LS7/a;Landroid/content/Context;)V", "Ljava/lang/Class;", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)V", "databaseFilePath", "createFromAsset", "(Ljava/lang/String;)Landroidx/room/RoomDatabase$Builder;", "Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "callback", "(Ljava/lang/String;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;)Landroidx/room/RoomDatabase$Builder;", "Ljava/io/File;", "databaseFile", "createFromFile", "(Ljava/io/File;)Landroidx/room/RoomDatabase$Builder;", "(Ljava/io/File;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;)Landroidx/room/RoomDatabase$Builder;", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "inputStreamCallable", "createFromInputStream", "(Ljava/util/concurrent/Callable;)Landroidx/room/RoomDatabase$Builder;", "(Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;)Landroidx/room/RoomDatabase$Builder;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "openHelperFactory", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;)Landroidx/room/RoomDatabase$Builder;", "", "Landroidx/room/migration/Migration;", "migrations", "addMigrations", "([Landroidx/room/migration/Migration;)Landroidx/room/RoomDatabase$Builder;", "Landroidx/room/migration/AutoMigrationSpec;", "autoMigrationSpec", "addAutoMigrationSpec", "(Landroidx/room/migration/AutoMigrationSpec;)Landroidx/room/RoomDatabase$Builder;", "allowMainThreadQueries", "()Landroidx/room/RoomDatabase$Builder;", "Landroidx/room/RoomDatabase$JournalMode;", "journalMode", "setJournalMode", "(Landroidx/room/RoomDatabase$JournalMode;)Landroidx/room/RoomDatabase$Builder;", "Ljava/util/concurrent/Executor;", "executor", "setQueryExecutor", "(Ljava/util/concurrent/Executor;)Landroidx/room/RoomDatabase$Builder;", "setTransactionExecutor", "enableMultiInstanceInvalidation", "Landroid/content/Intent;", "invalidationServiceIntent", "setMultiInstanceInvalidationServiceIntent", "(Landroid/content/Intent;)Landroidx/room/RoomDatabase$Builder;", "fallbackToDestructiveMigration", "", "dropAllTables", "(Z)Landroidx/room/RoomDatabase$Builder;", "fallbackToDestructiveMigrationOnDowngrade", "", "", "startVersions", "fallbackToDestructiveMigrationFrom", "([I)Landroidx/room/RoomDatabase$Builder;", "(Z[I)Landroidx/room/RoomDatabase$Builder;", "Landroidx/room/RoomDatabase$Callback;", "addCallback", "(Landroidx/room/RoomDatabase$Callback;)Landroidx/room/RoomDatabase$Builder;", "Landroidx/room/RoomDatabase$QueryCallback;", "queryCallback", "setQueryCallback", "(Landroidx/room/RoomDatabase$QueryCallback;Ljava/util/concurrent/Executor;)Landroidx/room/RoomDatabase$Builder;", "LH7/h;", "(LH7/h;Landroidx/room/RoomDatabase$QueryCallback;)Landroidx/room/RoomDatabase$Builder;", "typeConverter", "addTypeConverter", "(Ljava/lang/Object;)Landroidx/room/RoomDatabase$Builder;", "", "autoCloseTimeout", "Ljava/util/concurrent/TimeUnit;", "autoCloseTimeUnit", "setAutoCloseTimeout", "(JLjava/util/concurrent/TimeUnit;)Landroidx/room/RoomDatabase$Builder;", "Landroidx/sqlite/SQLiteDriver;", "driver", "setDriver", "(Landroidx/sqlite/SQLiteDriver;)Landroidx/room/RoomDatabase$Builder;", "setQueryCoroutineContext", "(LH7/h;)Landroidx/room/RoomDatabase$Builder;", "inMemory", "setInMemoryTrackingMode", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Landroidx/room/RoomDatabase;", "LZ7/d;", "Landroid/content/Context;", "Ljava/lang/String;", "LS7/a;", "", "callbacks", "Ljava/util/List;", "prepackagedDatabaseCallback", "Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "Landroidx/room/RoomDatabase$QueryCallback;", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallbackCoroutineContext", "LH7/h;", "typeConverters", "queryExecutor", "transactionExecutor", "supportOpenHelperFactory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "Z", "Landroidx/room/RoomDatabase$JournalMode;", "multiInstanceInvalidationIntent", "Landroid/content/Intent;", "J", "Ljava/util/concurrent/TimeUnit;", "Landroidx/room/RoomDatabase$MigrationContainer;", "migrationContainer", "Landroidx/room/RoomDatabase$MigrationContainer;", "", "migrationsNotRequiredFrom", "Ljava/util/Set;", "migrationStartAndEndVersions", "autoMigrationSpecs", "requireMigration", "allowDestructiveMigrationOnDowngrade", "allowDestructiveMigrationForAllTables", "copyFromAssetPath", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Landroidx/sqlite/SQLiteDriver;", "queryCoroutineContext", "inMemoryTrackingTableMode", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Builder<T extends RoomDatabase> {
        private boolean allowDestructiveMigrationForAllTables;
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout;
        private final List<AutoMigrationSpec> autoMigrationSpecs;
        private final List<Callback> callbacks;
        private final Context context;
        private String copyFromAssetPath;
        private File copyFromFile;
        private Callable<InputStream> copyFromInputStream;
        private SQLiteDriver driver;
        private final S7.a factory;
        private boolean inMemoryTrackingTableMode;
        private JournalMode journalMode;
        private final d klass;
        private final MigrationContainer migrationContainer;
        private final Set<Integer> migrationStartAndEndVersions;
        private Set<Integer> migrationsNotRequiredFrom;
        private Intent multiInstanceInvalidationIntent;
        private final String name;
        private PrepackagedDatabaseCallback prepackagedDatabaseCallback;
        private QueryCallback queryCallback;
        private h queryCallbackCoroutineContext;
        private Executor queryCallbackExecutor;
        private h queryCoroutineContext;
        private Executor queryExecutor;
        private boolean requireMigration;
        private SupportSQLiteOpenHelper.Factory supportOpenHelperFactory;
        private Executor transactionExecutor;
        private final List<Object> typeConverters;

        public Builder(d klass, String str, S7.a aVar, Context context) {
            k.f(klass, "klass");
            k.f(context, "context");
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.autoCloseTimeout = -1L;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
            this.migrationStartAndEndVersions = new LinkedHashSet();
            this.autoMigrationSpecs = new ArrayList();
            this.requireMigration = true;
            this.inMemoryTrackingTableMode = true;
            this.klass = klass;
            this.context = context;
            this.name = str;
            this.factory = aVar;
        }

        public Builder<T> addAutoMigrationSpec(AutoMigrationSpec autoMigrationSpec) {
            k.f(autoMigrationSpec, "autoMigrationSpec");
            this.autoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        public Builder<T> addCallback(Callback callback) {
            k.f(callback, "callback");
            this.callbacks.add(callback);
            return this;
        }

        public Builder<T> addMigrations(Migration... migrations) {
            k.f(migrations, "migrations");
            for (Migration migration : migrations) {
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrations, migrations.length));
            return this;
        }

        public Builder<T> addTypeConverter(Object typeConverter) {
            k.f(typeConverter, "typeConverter");
            this.typeConverters.add(typeConverter);
            return this;
        }

        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        public T build() {
            SupportSQLiteOpenHelper.Factory queryInterceptorOpenHelperFactory;
            SupportSQLiteOpenHelper.Factory factory;
            T t9;
            h hVarH;
            Executor executor = this.queryExecutor;
            if (executor == null && this.transactionExecutor == null) {
                Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                this.transactionExecutor = iOThreadExecutor;
                this.queryExecutor = iOThreadExecutor;
            } else if (executor != null && this.transactionExecutor == null) {
                this.transactionExecutor = executor;
            } else if (executor == null) {
                this.queryExecutor = this.transactionExecutor;
            }
            RoomDatabaseKt.validateMigrationsNotRequired(this.migrationStartAndEndVersions, this.migrationsNotRequiredFrom);
            SQLiteDriver sQLiteDriver = this.driver;
            if (sQLiteDriver == null && this.supportOpenHelperFactory == null) {
                queryInterceptorOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            } else if (sQLiteDriver == null) {
                queryInterceptorOpenHelperFactory = this.supportOpenHelperFactory;
            } else {
                if (this.supportOpenHelperFactory != null) {
                    throw new IllegalArgumentException("A RoomDatabase cannot be configured with both a SQLiteDriver and a SupportOpenHelper.Factory.");
                }
                queryInterceptorOpenHelperFactory = null;
            }
            boolean z10 = this.autoCloseTimeout > 0;
            boolean z11 = (this.copyFromAssetPath == null && this.copyFromFile == null && this.copyFromInputStream == null) ? false : true;
            boolean z12 = this.queryCallback != null;
            if (queryInterceptorOpenHelperFactory != null) {
                if (z10) {
                    if (this.name == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                    long j5 = this.autoCloseTimeout;
                    TimeUnit timeUnit = this.autoCloseTimeUnit;
                    if (timeUnit == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    queryInterceptorOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(queryInterceptorOpenHelperFactory, new AutoCloser(j5, timeUnit, null, 4, null));
                }
                if (z11) {
                    if (this.name == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                    String str = this.copyFromAssetPath;
                    int i = str == null ? 0 : 1;
                    File file = this.copyFromFile;
                    int i6 = file == null ? 0 : 1;
                    Callable<InputStream> callable = this.copyFromInputStream;
                    if (i + i6 + (callable != null ? 1 : 0) != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                    }
                    queryInterceptorOpenHelperFactory = new PrePackagedCopyOpenHelperFactory(str, file, callable, queryInterceptorOpenHelperFactory);
                }
                if (z12) {
                    Executor executor2 = this.queryCallbackExecutor;
                    if (executor2 != null) {
                        hVarH = AbstractC1683A.h(executor2);
                    } else {
                        hVarH = this.queryCallbackCoroutineContext;
                        if (hVarH == null) {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                    }
                    C1923c c1923cB = AbstractC1683A.b(hVarH);
                    QueryCallback queryCallback = this.queryCallback;
                    if (queryCallback == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    queryInterceptorOpenHelperFactory = new QueryInterceptorOpenHelperFactory(queryInterceptorOpenHelperFactory, c1923cB, queryCallback);
                }
                factory = queryInterceptorOpenHelperFactory;
            } else {
                factory = null;
            }
            if (factory == null) {
                if (z10) {
                    throw new IllegalArgumentException("Auto Closing Database is not supported when an SQLiteDriver is configured.");
                }
                if (z11) {
                    throw new IllegalArgumentException("Pre-Package Database is not supported when an SQLiteDriver is configured.");
                }
                if (z12) {
                    throw new IllegalArgumentException("Query Callback is not supported when an SQLiteDriver is configured.");
                }
            }
            Context context = this.context;
            String str2 = this.name;
            MigrationContainer migrationContainer = this.migrationContainer;
            List<Callback> list = this.callbacks;
            boolean z13 = this.allowMainThreadQueries;
            JournalMode journalModeResolve$room_runtime = this.journalMode.resolve$room_runtime(context);
            Executor executor3 = this.queryExecutor;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Executor executor4 = this.transactionExecutor;
            if (executor4 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, str2, factory, migrationContainer, list, z13, journalModeResolve$room_runtime, executor3, executor4, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, this.typeConverters, this.autoMigrationSpecs, this.allowDestructiveMigrationForAllTables, this.driver, this.queryCoroutineContext);
            databaseConfiguration.setUseTempTrackingTable$room_runtime(this.inMemoryTrackingTableMode);
            S7.a aVar = this.factory;
            if (aVar == null || (t9 = (T) aVar.invoke()) == null) {
                t9 = (T) KClassUtil.findAndInstantiateDatabaseImpl$default(M.a.Z(this.klass), null, 2, null);
            }
            t9.init(databaseConfiguration);
            return t9;
        }

        public Builder<T> createFromAsset(String databaseFilePath) {
            k.f(databaseFilePath, "databaseFilePath");
            this.copyFromAssetPath = databaseFilePath;
            return this;
        }

        public Builder<T> createFromFile(File databaseFile) {
            k.f(databaseFile, "databaseFile");
            this.copyFromFile = databaseFile;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromInputStream(Callable<InputStream> inputStreamCallable) {
            k.f(inputStreamCallable, "inputStreamCallable");
            this.copyFromInputStream = inputStreamCallable;
            return this;
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            this.multiInstanceInvalidationIntent = this.name != null ? new Intent(this.context, (Class<?>) MultiInstanceInvalidationService.class) : null;
            return this;
        }

        @C7.c
        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @C7.c
        public Builder<T> fallbackToDestructiveMigrationFrom(int... startVersions) {
            k.f(startVersions, "startVersions");
            for (int i : startVersions) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(i));
            }
            return this;
        }

        @C7.c
        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory factory) {
            this.supportOpenHelperFactory = factory;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) long autoCloseTimeout, TimeUnit autoCloseTimeUnit) {
            k.f(autoCloseTimeUnit, "autoCloseTimeUnit");
            if (autoCloseTimeout < 0) {
                throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
            }
            this.autoCloseTimeout = autoCloseTimeout;
            this.autoCloseTimeUnit = autoCloseTimeUnit;
            return this;
        }

        public final Builder<T> setDriver(SQLiteDriver driver) {
            k.f(driver, "driver");
            this.driver = driver;
            return this;
        }

        @ExperimentalRoomApi
        public final Builder<T> setInMemoryTrackingMode(boolean inMemory) {
            this.inMemoryTrackingTableMode = inMemory;
            return this;
        }

        public Builder<T> setJournalMode(JournalMode journalMode) {
            k.f(journalMode, "journalMode");
            this.journalMode = journalMode;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(Intent invalidationServiceIntent) {
            k.f(invalidationServiceIntent, "invalidationServiceIntent");
            if (this.name == null) {
                invalidationServiceIntent = null;
            }
            this.multiInstanceInvalidationIntent = invalidationServiceIntent;
            return this;
        }

        public Builder<T> setQueryCallback(QueryCallback queryCallback, Executor executor) {
            k.f(queryCallback, "queryCallback");
            k.f(executor, "executor");
            this.queryCallback = queryCallback;
            this.queryCallbackExecutor = executor;
            this.queryCallbackCoroutineContext = null;
            return this;
        }

        public final Builder<T> setQueryCoroutineContext(h context) {
            k.f(context, "context");
            if (this.queryExecutor != null || this.transactionExecutor != null) {
                throw new IllegalArgumentException("This builder has already been configured with an Executor. A RoomDatabase canonly be configured with either an Executor or a CoroutineContext.");
            }
            if (context.get(H7.d.f758a) == null) {
                throw new IllegalArgumentException("It is required that the coroutine context contain a dispatcher.");
            }
            this.queryCoroutineContext = context;
            return this;
        }

        public Builder<T> setQueryExecutor(Executor executor) {
            k.f(executor, "executor");
            if (this.queryCoroutineContext != null) {
                throw new IllegalArgumentException("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
            }
            this.queryExecutor = executor;
            return this;
        }

        public Builder<T> setTransactionExecutor(Executor executor) {
            k.f(executor, "executor");
            if (this.queryCoroutineContext != null) {
                throw new IllegalArgumentException("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
            }
            this.transactionExecutor = executor;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromAsset(String databaseFilePath, PrepackagedDatabaseCallback callback) {
            k.f(databaseFilePath, "databaseFilePath");
            k.f(callback, "callback");
            this.prepackagedDatabaseCallback = callback;
            this.copyFromAssetPath = databaseFilePath;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        public Builder<T> createFromFile(File databaseFile, PrepackagedDatabaseCallback callback) {
            k.f(databaseFile, "databaseFile");
            k.f(callback, "callback");
            this.prepackagedDatabaseCallback = callback;
            this.copyFromFile = databaseFile;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        public Builder<T> createFromInputStream(Callable<InputStream> inputStreamCallable, PrepackagedDatabaseCallback callback) {
            k.f(inputStreamCallable, "inputStreamCallable");
            k.f(callback, "callback");
            this.prepackagedDatabaseCallback = callback;
            this.copyFromInputStream = inputStreamCallable;
            return this;
        }

        public final Builder<T> fallbackToDestructiveMigration(boolean dropAllTables) {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            this.allowDestructiveMigrationForAllTables = dropAllTables;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(boolean dropAllTables, int... startVersions) {
            k.f(startVersions, "startVersions");
            for (int i : startVersions) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(i));
            }
            this.allowDestructiveMigrationForAllTables = dropAllTables;
            return this;
        }

        public final Builder<T> fallbackToDestructiveMigrationOnDowngrade(boolean dropAllTables) {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            this.allowDestructiveMigrationForAllTables = dropAllTables;
            return this;
        }

        public final Builder<T> setQueryCallback(h context, QueryCallback queryCallback) {
            k.f(context, "context");
            k.f(queryCallback, "queryCallback");
            this.queryCallback = queryCallback;
            this.queryCallbackExecutor = null;
            this.queryCallbackCoroutineContext = context;
            return this;
        }

        public Builder(Context context, Class<T> klass, String str) {
            k.f(context, "context");
            k.f(klass, "klass");
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.autoCloseTimeout = -1L;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
            this.migrationStartAndEndVersions = new LinkedHashSet();
            this.autoMigrationSpecs = new ArrayList();
            this.requireMigration = true;
            this.inMemoryTrackingTableMode = true;
            this.klass = M.a.c0(klass);
            this.context = context;
            this.name = str;
            this.factory = null;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/room/RoomDatabase$Callback;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "LC7/r;", AppAgent.ON_CREATE, "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "connection", "(Landroidx/sqlite/SQLiteConnection;)V", "onDestructiveMigration", "onOpen", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class Callback {
        public void onCreate(SupportSQLiteDatabase db) {
            k.f(db, "db");
        }

        public void onDestructiveMigration(SupportSQLiteDatabase db) {
            k.f(db, "db");
        }

        public void onOpen(SupportSQLiteDatabase db) {
            k.f(db, "db");
        }

        public void onCreate(SQLiteConnection connection) {
            k.f(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                onCreate(((SupportSQLiteConnection) connection).getDb());
            }
        }

        public void onDestructiveMigration(SQLiteConnection connection) {
            k.f(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                onDestructiveMigration(((SupportSQLiteConnection) connection).getDb());
            }
        }

        public void onOpen(SQLiteConnection connection) {
            k.f(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                onOpen(((SupportSQLiteConnection) connection).getDb());
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000b"}, d2 = {"Landroidx/room/RoomDatabase$JournalMode;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "AUTOMATIC", "TRUNCATE", "WRITE_AHEAD_LOGGING", "resolve", "context", "Landroid/content/Context;", "resolve$room_runtime", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class JournalMode {
        private static final /* synthetic */ K7.a $ENTRIES;
        private static final /* synthetic */ JournalMode[] $VALUES;
        public static final JournalMode AUTOMATIC = new JournalMode("AUTOMATIC", 0);
        public static final JournalMode TRUNCATE = new JournalMode("TRUNCATE", 1);
        public static final JournalMode WRITE_AHEAD_LOGGING = new JournalMode("WRITE_AHEAD_LOGGING", 2);

        private static final /* synthetic */ JournalMode[] $values() {
            return new JournalMode[]{AUTOMATIC, TRUNCATE, WRITE_AHEAD_LOGGING};
        }

        static {
            JournalMode[] journalModeArr$values = $values();
            $VALUES = journalModeArr$values;
            $ENTRIES = kotlin.enums.a.a(journalModeArr$values);
        }

        private JournalMode(String str, int i) {
        }

        public static K7.a getEntries() {
            return $ENTRIES;
        }

        public static JournalMode valueOf(String str) {
            return (JournalMode) Enum.valueOf(JournalMode.class, str);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        public final JournalMode resolve$room_runtime(Context context) {
            k.f(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || activityManager.isLowRamDevice()) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "LC7/r;", "onOpenPrepackagedDatabase", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase db) {
            k.f(db, "db");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/room/RoomDatabase$QueryCallback;", "", "", "sqlQuery", "", "bindArgs", "LC7/r;", "onQuery", "(Ljava/lang/String;Ljava/util/List;)V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface QueryCallback {
        void onQuery(String sqlQuery, List<? extends Object> bindArgs);
    }

    @J7.c(c = "androidx.room.RoomDatabase$performClear$1", f = "RoomDatabase.android.kt", l = {531}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.RoomDatabase$performClear$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ boolean $hasForeignKeys;
        final /* synthetic */ String[] $tableNames;
        int label;

        @J7.c(c = "androidx.room.RoomDatabase$performClear$1$1", f = "RoomDatabase.android.kt", l = {532, 533, 535, 541, 542, 543}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/room/Transactor;", "connection", "LC7/r;", "<anonymous>", "(Landroidx/room/Transactor;)V"}, k = 3, mv = {2, 1, 0})
        /* renamed from: androidx.room.RoomDatabase$performClear$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01291 extends SuspendLambda implements n {
            final /* synthetic */ boolean $hasForeignKeys;
            final /* synthetic */ String[] $tableNames;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ RoomDatabase this$0;

            @J7.c(c = "androidx.room.RoomDatabase$performClear$1$1$1", f = "RoomDatabase.android.kt", l = {537, 539}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/room/TransactionScope;", "LC7/r;", "<anonymous>", "(Landroidx/room/TransactionScope;)V"}, k = 3, mv = {2, 1, 0})
            /* renamed from: androidx.room.RoomDatabase$performClear$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01301 extends SuspendLambda implements n {
                final /* synthetic */ boolean $hasForeignKeys;
                final /* synthetic */ String[] $tableNames;
                int I$0;
                int I$1;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01301(boolean z10, String[] strArr, H7.c<? super C01301> cVar) {
                    super(2, cVar);
                    this.$hasForeignKeys = z10;
                    this.$tableNames = strArr;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    C01301 c01301 = new C01301(this.$hasForeignKeys, this.$tableNames, cVar);
                    c01301.L$0 = obj;
                    return c01301;
                }

                @Override // S7.n
                public final Object invoke(TransactionScope<r> transactionScope, H7.c<? super r> cVar) {
                    return ((C01301) create(transactionScope, cVar)).invokeSuspend(r.f317a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
                
                    if (androidx.room.TransactorKt.execSQL(r1, "PRAGMA defer_foreign_keys = TRUE", r9) == r0) goto L19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
                
                    if (androidx.room.TransactorKt.execSQL(r6, r10, r9) == r0) goto L19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0067 -> B:20:0x006a). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                    /*
                        r9 = this;
                        kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                        int r1 = r9.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L2c
                        if (r1 == r3) goto L24
                        if (r1 != r2) goto L1c
                        int r1 = r9.I$1
                        int r4 = r9.I$0
                        java.lang.Object r5 = r9.L$1
                        java.lang.String[] r5 = (java.lang.String[]) r5
                        java.lang.Object r6 = r9.L$0
                        androidx.room.TransactionScope r6 = (androidx.room.TransactionScope) r6
                        kotlin.b.b(r10)
                        goto L6a
                    L1c:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L24:
                        java.lang.Object r1 = r9.L$0
                        androidx.room.TransactionScope r1 = (androidx.room.TransactionScope) r1
                        kotlin.b.b(r10)
                        goto L45
                    L2c:
                        kotlin.b.b(r10)
                        java.lang.Object r10 = r9.L$0
                        r1 = r10
                        androidx.room.TransactionScope r1 = (androidx.room.TransactionScope) r1
                        boolean r10 = r9.$hasForeignKeys
                        if (r10 == 0) goto L45
                        r9.L$0 = r1
                        r9.label = r3
                        java.lang.String r10 = "PRAGMA defer_foreign_keys = TRUE"
                        java.lang.Object r10 = androidx.room.TransactorKt.execSQL(r1, r10, r9)
                        if (r10 != r0) goto L45
                        goto L69
                    L45:
                        java.lang.String[] r10 = r9.$tableNames
                        int r4 = r10.length
                        r5 = 0
                        r6 = r1
                        r1 = r4
                        r4 = r5
                        r5 = r10
                    L4d:
                        if (r4 >= r1) goto L6c
                        r10 = r5[r4]
                        java.lang.String r7 = "DELETE FROM `"
                        r8 = 96
                        java.lang.String r10 = androidx.compose.foundation.b.m(r8, r7, r10)
                        r9.L$0 = r6
                        r9.L$1 = r5
                        r9.I$0 = r4
                        r9.I$1 = r1
                        r9.label = r2
                        java.lang.Object r10 = androidx.room.TransactorKt.execSQL(r6, r10, r9)
                        if (r10 != r0) goto L6a
                    L69:
                        return r0
                    L6a:
                        int r4 = r4 + r3
                        goto L4d
                    L6c:
                        C7.r r9 = C7.r.f317a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.AnonymousClass1.C01291.C01301.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01291(RoomDatabase roomDatabase, boolean z10, String[] strArr, H7.c<? super C01291> cVar) {
                super(2, cVar);
                this.this$0 = roomDatabase;
                this.$hasForeignKeys = z10;
                this.$tableNames = strArr;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C01291 c01291 = new C01291(this.this$0, this.$hasForeignKeys, this.$tableNames, cVar);
                c01291.L$0 = obj;
                return c01291;
            }

            @Override // S7.n
            public final Object invoke(Transactor transactor, H7.c<? super r> cVar) {
                return ((C01291) create(transactor, cVar)).invokeSuspend(r.f317a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
            
                if (androidx.room.TransactorKt.execSQL(r1, "VACUUM", r7) != r0) goto L35;
             */
            /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[PHI: r1
              0x006f: PHI (r1v7 androidx.room.Transactor) = (r1v4 androidx.room.Transactor), (r1v4 androidx.room.Transactor), (r1v9 androidx.room.Transactor) binds: [B:17:0x005b, B:19:0x006c, B:10:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[PHI: r1
              0x0086: PHI (r1v10 androidx.room.Transactor) = (r1v7 androidx.room.Transactor), (r1v12 androidx.room.Transactor) binds: [B:22:0x0083, B:9:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0092 A[PHI: r1 r8
              0x0092: PHI (r1v13 androidx.room.Transactor) = (r1v10 androidx.room.Transactor), (r1v15 androidx.room.Transactor) binds: [B:25:0x008f, B:8:0x001e] A[DONT_GENERATE, DONT_INLINE]
              0x0092: PHI (r8v14 java.lang.Object) = (r8v13 java.lang.Object), (r8v0 java.lang.Object) binds: [B:25:0x008f, B:8:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r1 = r7.label
                    r2 = 0
                    switch(r1) {
                        case 0: goto L3f;
                        case 1: goto L37;
                        case 2: goto L2f;
                        case 3: goto L27;
                        case 4: goto L1e;
                        case 5: goto L15;
                        case 6: goto L10;
                        default: goto L8;
                    }
                L8:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L10:
                    kotlin.b.b(r8)
                    goto Lb6
                L15:
                    java.lang.Object r1 = r7.L$0
                    androidx.room.Transactor r1 = (androidx.room.Transactor) r1
                    kotlin.b.b(r8)
                    goto La8
                L1e:
                    java.lang.Object r1 = r7.L$0
                    androidx.room.Transactor r1 = (androidx.room.Transactor) r1
                    kotlin.b.b(r8)
                    goto L92
                L27:
                    java.lang.Object r1 = r7.L$0
                    androidx.room.Transactor r1 = (androidx.room.Transactor) r1
                    kotlin.b.b(r8)
                    goto L86
                L2f:
                    java.lang.Object r1 = r7.L$0
                    androidx.room.Transactor r1 = (androidx.room.Transactor) r1
                    kotlin.b.b(r8)
                    goto L6f
                L37:
                    java.lang.Object r1 = r7.L$0
                    androidx.room.Transactor r1 = (androidx.room.Transactor) r1
                    kotlin.b.b(r8)
                    goto L55
                L3f:
                    kotlin.b.b(r8)
                    java.lang.Object r8 = r7.L$0
                    androidx.room.Transactor r8 = (androidx.room.Transactor) r8
                    r7.L$0 = r8
                    r1 = 1
                    r7.label = r1
                    java.lang.Object r1 = r8.inTransaction(r7)
                    if (r1 != r0) goto L52
                    goto Lb5
                L52:
                    r6 = r1
                    r1 = r8
                    r8 = r6
                L55:
                    java.lang.Boolean r8 = (java.lang.Boolean) r8
                    boolean r8 = r8.booleanValue()
                    if (r8 != 0) goto L6f
                    androidx.room.RoomDatabase r8 = r7.this$0
                    androidx.room.InvalidationTracker r8 = r8.getInvalidationTracker()
                    r7.L$0 = r1
                    r3 = 2
                    r7.label = r3
                    java.lang.Object r8 = r8.sync$room_runtime(r7)
                    if (r8 != r0) goto L6f
                    goto Lb5
                L6f:
                    androidx.room.Transactor$SQLiteTransactionType r8 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE
                    androidx.room.RoomDatabase$performClear$1$1$1 r3 = new androidx.room.RoomDatabase$performClear$1$1$1
                    boolean r4 = r7.$hasForeignKeys
                    java.lang.String[] r5 = r7.$tableNames
                    r3.<init>(r4, r5, r2)
                    r7.L$0 = r1
                    r4 = 3
                    r7.label = r4
                    java.lang.Object r8 = r1.withTransaction(r8, r3, r7)
                    if (r8 != r0) goto L86
                    goto Lb5
                L86:
                    r7.L$0 = r1
                    r8 = 4
                    r7.label = r8
                    java.lang.Object r8 = r1.inTransaction(r7)
                    if (r8 != r0) goto L92
                    goto Lb5
                L92:
                    java.lang.Boolean r8 = (java.lang.Boolean) r8
                    boolean r8 = r8.booleanValue()
                    if (r8 != 0) goto Lbf
                    r7.L$0 = r1
                    r8 = 5
                    r7.label = r8
                    java.lang.String r8 = "PRAGMA wal_checkpoint(FULL)"
                    java.lang.Object r8 = androidx.room.TransactorKt.execSQL(r1, r8, r7)
                    if (r8 != r0) goto La8
                    goto Lb5
                La8:
                    r7.L$0 = r2
                    r8 = 6
                    r7.label = r8
                    java.lang.String r8 = "VACUUM"
                    java.lang.Object r8 = androidx.room.TransactorKt.execSQL(r1, r8, r7)
                    if (r8 != r0) goto Lb6
                Lb5:
                    return r0
                Lb6:
                    androidx.room.RoomDatabase r7 = r7.this$0
                    androidx.room.InvalidationTracker r7 = r7.getInvalidationTracker()
                    r7.refreshAsync()
                Lbf:
                    C7.r r7 = C7.r.f317a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.AnonymousClass1.C01291.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z10, String[] strArr, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$hasForeignKeys = z10;
            this.$tableNames = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return RoomDatabase.this.new AnonymousClass1(this.$hasForeignKeys, this.$tableNames, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                RoomConnectionManager roomConnectionManager = RoomDatabase.this.connectionManager;
                if (roomConnectionManager == null) {
                    k.n("connectionManager");
                    throw null;
                }
                C01291 c01291 = new C01291(RoomDatabase.this, this.$hasForeignKeys, this.$tableNames, null);
                this.label = 1;
                if (roomConnectionManager.useConnection(false, c01291, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportSQLiteOpenHelper createConnectionManager$lambda$2(RoomDatabase roomDatabase, DatabaseConfiguration config) {
        k.f(config, "config");
        return roomDatabase.createOpenHelper(config);
    }

    @C7.c
    public static /* synthetic */ void getMCallbacks$annotations() {
    }

    @C7.c
    public static /* synthetic */ void getMDatabase$annotations() {
    }

    private final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        if (!writableDatabase.inTransaction()) {
            getInvalidationTracker().syncBlocking$room_runtime();
        }
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    private final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (inTransaction()) {
            return;
        }
        getInvalidationTracker().refreshVersionsAsync();
    }

    private final boolean isThreadInSuspendingTransaction() {
        h hVar = this.suspendingTransactionContext.get();
        return (hVar != null ? (TransactionElement) hVar.get(TransactionElement.INSTANCE) : null) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosed() {
        InterfaceC1733z interfaceC1733z = this.coroutineScope;
        if (interfaceC1733z == null) {
            k.n("coroutineScope");
            throw null;
        }
        AbstractC1683A.e(interfaceC1733z, null);
        getInvalidationTracker().stop$room_runtime();
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager != null) {
            roomConnectionManager.close();
        } else {
            k.n("connectionManager");
            throw null;
        }
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i & 2) != 0) {
            cancellationSignal = null;
        }
        return roomDatabase.query(supportSQLiteQuery, cancellationSignal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r runInTransaction$lambda$10(Runnable runnable) {
        runnable.run();
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object runInTransaction$lambda$12(S7.a aVar, SQLiteConnection it) {
        k.f(it, "it");
        return aVar.invoke();
    }

    private final <T extends SupportSQLiteOpenHelper> T unwrapOpenHelper(SupportSQLiteOpenHelper openHelper) {
        if (openHelper == null) {
            return null;
        }
        k.m();
        throw null;
    }

    public final void addTypeConverter$room_runtime(d kclass, Object converter) {
        k.f(kclass, "kclass");
        k.f(converter, "converter");
        this.typeConverters.put(kclass, converter);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (!this.allowMainThreadQueries && isMainThread$room_runtime()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotSuspendingTransaction() {
        if (inCompatibilityMode() && !inTransaction() && isThreadInSuspendingTransaction()) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @C7.c
    public void beginTransaction() {
        assertNotMainThread();
        internalBeginTransaction();
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        this.closeBarrier.close$room_runtime();
    }

    public SupportSQLiteStatement compileStatement(String sql) {
        k.f(sql, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(sql);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public List<Migration> createAutoMigrations(Map<d, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        k.f(autoMigrationSpecs, "autoMigrationSpecs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.a.P(autoMigrationSpecs.size()));
        Iterator<T> it = autoMigrationSpecs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(M.a.Z((d) entry.getKey()), entry.getValue());
        }
        return getAutoMigrations(linkedHashMap);
    }

    public final RoomConnectionManager createConnectionManager$room_runtime(DatabaseConfiguration configuration) {
        RoomOpenDelegate roomOpenDelegate;
        k.f(configuration, "configuration");
        try {
            RoomOpenDelegateMarker roomOpenDelegateMarkerCreateOpenDelegate = createOpenDelegate();
            k.d(roomOpenDelegateMarkerCreateOpenDelegate, "null cannot be cast to non-null type androidx.room.RoomOpenDelegate");
            roomOpenDelegate = (RoomOpenDelegate) roomOpenDelegateMarkerCreateOpenDelegate;
        } catch (NotImplementedError unused) {
            roomOpenDelegate = null;
        }
        return roomOpenDelegate == null ? new RoomConnectionManager(configuration, new Q(this, 19), new RoomDatabase$createConnectionManager$2(this)) : new RoomConnectionManager(configuration, roomOpenDelegate, new RoomDatabase$createConnectionManager$3(this));
    }

    public abstract InvalidationTracker createInvalidationTracker();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RoomOpenDelegateMarker createOpenDelegate() {
        throw new NotImplementedError();
    }

    @C7.c
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        k.f(config, "config");
        throw new NotImplementedError();
    }

    @C7.c
    public void endTransaction() {
        internalEndTransaction();
    }

    @C7.c
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        k.f(autoMigrationSpecs, "autoMigrationSpecs");
        return EmptyList.f4893a;
    }

    /* renamed from: getCloseBarrier$room_runtime, reason: from getter */
    public final CloseBarrier getCloseBarrier() {
        return this.closeBarrier;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final InterfaceC1733z getCoroutineScope() {
        InterfaceC1733z interfaceC1733z = this.coroutineScope;
        if (interfaceC1733z != null) {
            return interfaceC1733z;
        }
        k.n("coroutineScope");
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SQLiteDriver getDriver() {
        DatabaseConfiguration databaseConfiguration = this.configuration;
        if (databaseConfiguration == null) {
            k.n("configuration");
            throw null;
        }
        SQLiteDriver sQLiteDriver = databaseConfiguration.sqliteDriver;
        if (sQLiteDriver != null) {
            return sQLiteDriver;
        }
        throw new IllegalStateException("No SQLiteDriver was configured with Room.");
    }

    public InvalidationTracker getInvalidationTracker() {
        InvalidationTracker invalidationTracker = this.internalTracker;
        if (invalidationTracker != null) {
            return invalidationTracker;
        }
        k.n("internalTracker");
        throw null;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            k.n("connectionManager");
            throw null;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime = roomConnectionManager.getSupportOpenHelper();
        if (supportOpenHelper$room_runtime != null) {
            return supportOpenHelper$room_runtime;
        }
        throw new IllegalStateException("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getPath() {
        DatabaseConfiguration databaseConfiguration = this.configuration;
        if (databaseConfiguration == null) {
            k.n("configuration");
            throw null;
        }
        String str = databaseConfiguration.name;
        if (str == null) {
            return null;
        }
        if (databaseConfiguration != null) {
            return databaseConfiguration.context.getDatabasePath(str).getPath();
        }
        k.n("configuration");
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final h getQueryContext() {
        InterfaceC1733z interfaceC1733z = this.coroutineScope;
        if (interfaceC1733z != null) {
            return interfaceC1733z.getCoroutineContext();
        }
        k.n("coroutineScope");
        throw null;
    }

    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor != null) {
            return executor;
        }
        k.n("internalQueryExecutor");
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Set<d> getRequiredAutoMigrationSpecClasses() {
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        ArrayList arrayList = new ArrayList(w.c0(requiredAutoMigrationSpecs, 10));
        Iterator<T> it = requiredAutoMigrationSpecs.iterator();
        while (it.hasNext()) {
            arrayList.add(M.a.c0((Class) it.next()));
        }
        return v.j1(arrayList);
    }

    @C7.c
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return EmptySet.f4895a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Map<d, List<d>> getRequiredTypeConverterClasses() {
        Set<Map.Entry<Class<?>, List<Class<?>>>> setEntrySet = getRequiredTypeConverters().entrySet();
        int iP = kotlin.collections.a.P(w.c0(setEntrySet, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Class cls = (Class) entry.getKey();
            List list = (List) entry.getValue();
            d dVarC0 = M.a.c0(cls);
            List list2 = list;
            ArrayList arrayList = new ArrayList(w.c0(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(M.a.c0((Class) it2.next()));
            }
            linkedHashMap.put(dVarC0, arrayList);
        }
        return linkedHashMap;
    }

    public final Map<d, List<d>> getRequiredTypeConverterClassesMap$room_runtime() {
        return getRequiredTypeConverterClasses();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return kotlin.collections.a.M();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ThreadLocal<h> getSuspendingTransactionContext() {
        return this.suspendingTransactionContext;
    }

    public final h getTransactionContext$room_runtime() {
        h hVar = this.transactionContext;
        if (hVar != null) {
            return hVar;
        }
        k.n("transactionContext");
        throw null;
    }

    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        k.n("internalTransactionExecutor");
        throw null;
    }

    @C7.c
    public <T> T getTypeConverter(Class<T> klass) {
        k.f(klass, "klass");
        return (T) this.typeConverters.get(M.a.c0(klass));
    }

    /* renamed from: getUseTempTrackingTable$room_runtime, reason: from getter */
    public final boolean getUseTempTrackingTable() {
        return this.useTempTrackingTable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean inCompatibilityMode() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager != null) {
            return roomConnectionManager.getSupportOpenHelper() != null;
        }
        k.n("connectionManager");
        throw null;
    }

    public boolean inTransaction() {
        return isOpenInternal$room_runtime() && getOpenHelper().getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(DatabaseConfiguration configuration) {
        Executor executorC1690H;
        h coroutineContext;
        k.f(configuration, "configuration");
        this.configuration = configuration;
        this.useTempTrackingTable = configuration.getUseTempTrackingTable();
        this.connectionManager = createConnectionManager$room_runtime(configuration);
        this.internalTracker = createInvalidationTracker();
        RoomDatabaseKt.validateAutoMigrations(this, configuration);
        RoomDatabaseKt.validateTypeConverters(this, configuration);
        h hVar = configuration.queryCoroutineContext;
        if (hVar != null) {
            f fVar = hVar.get(H7.d.f758a);
            k.d(fVar, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
            AbstractC1729v abstractC1729v = (AbstractC1729v) fVar;
            AbstractC1702U abstractC1702U = abstractC1729v instanceof AbstractC1702U ? (AbstractC1702U) abstractC1729v : null;
            if (abstractC1702U == null || (executorC1690H = abstractC1702U.E()) == null) {
                executorC1690H = new ExecutorC1690H(abstractC1729v);
            }
            this.internalQueryExecutor = executorC1690H;
            this.internalTransactionExecutor = new TransactionExecutor(executorC1690H);
            this.coroutineScope = AbstractC1683A.b(configuration.queryCoroutineContext.plus(new r0((c0) configuration.queryCoroutineContext.get(b0.f5325a))));
            if (inCompatibilityMode()) {
                InterfaceC1733z interfaceC1733z = this.coroutineScope;
                if (interfaceC1733z == null) {
                    k.n("coroutineScope");
                    throw null;
                }
                coroutineContext = interfaceC1733z.getCoroutineContext().plus(abstractC1729v.limitedParallelism(1));
            } else {
                InterfaceC1733z interfaceC1733z2 = this.coroutineScope;
                if (interfaceC1733z2 == null) {
                    k.n("coroutineScope");
                    throw null;
                }
                coroutineContext = interfaceC1733z2.getCoroutineContext();
            }
            this.transactionContext = coroutineContext;
        } else {
            this.internalQueryExecutor = configuration.queryExecutor;
            this.internalTransactionExecutor = new TransactionExecutor(configuration.transactionExecutor);
            Executor executor = this.internalQueryExecutor;
            if (executor == null) {
                k.n("internalQueryExecutor");
                throw null;
            }
            C1923c c1923cB = AbstractC1683A.b(AbstractC1683A.h(executor).plus(AbstractC1683A.c()));
            this.coroutineScope = c1923cB;
            h hVar2 = c1923cB.f5997a;
            Executor executor2 = this.internalTransactionExecutor;
            if (executor2 == null) {
                k.n("internalTransactionExecutor");
                throw null;
            }
            this.transactionContext = hVar2.plus(AbstractC1683A.h(executor2));
        }
        this.allowMainThreadQueries = configuration.allowMainThreadQueries;
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            k.n("connectionManager");
            throw null;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime = roomConnectionManager.getSupportOpenHelper();
        if (supportOpenHelper$room_runtime != null) {
            while (!(supportOpenHelper$room_runtime instanceof PrePackagedCopyOpenHelper)) {
                if (!(supportOpenHelper$room_runtime instanceof DelegatingOpenHelper)) {
                    supportOpenHelper$room_runtime = null;
                    break;
                }
                supportOpenHelper$room_runtime = ((DelegatingOpenHelper) supportOpenHelper$room_runtime).getDelegate();
            }
        } else {
            supportOpenHelper$room_runtime = null;
            break;
        }
        PrePackagedCopyOpenHelper prePackagedCopyOpenHelper = (PrePackagedCopyOpenHelper) supportOpenHelper$room_runtime;
        if (prePackagedCopyOpenHelper != null) {
            prePackagedCopyOpenHelper.setDatabaseConfiguration(configuration);
        }
        RoomConnectionManager roomConnectionManager2 = this.connectionManager;
        if (roomConnectionManager2 == null) {
            k.n("connectionManager");
            throw null;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime2 = roomConnectionManager2.getSupportOpenHelper();
        if (supportOpenHelper$room_runtime2 != null) {
            while (!(supportOpenHelper$room_runtime2 instanceof AutoClosingRoomOpenHelper)) {
                if (!(supportOpenHelper$room_runtime2 instanceof DelegatingOpenHelper)) {
                    supportOpenHelper$room_runtime2 = null;
                    break;
                }
                supportOpenHelper$room_runtime2 = ((DelegatingOpenHelper) supportOpenHelper$room_runtime2).getDelegate();
            }
        } else {
            supportOpenHelper$room_runtime2 = null;
            break;
        }
        AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) supportOpenHelper$room_runtime2;
        if (autoClosingRoomOpenHelper != null) {
            this.autoCloser = autoClosingRoomOpenHelper.getAutoCloser();
            AutoCloser autoCloser = autoClosingRoomOpenHelper.getAutoCloser();
            InterfaceC1733z interfaceC1733z3 = this.coroutineScope;
            if (interfaceC1733z3 == null) {
                k.n("coroutineScope");
                throw null;
            }
            autoCloser.initCoroutineScope(interfaceC1733z3);
            getInvalidationTracker().setAutoCloser$room_runtime(autoClosingRoomOpenHelper.getAutoCloser());
        }
        if (configuration.multiInstanceInvalidationServiceIntent != null) {
            if (configuration.name == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            getInvalidationTracker().initMultiInstanceInvalidation$room_runtime(configuration.context, configuration.name, configuration.multiInstanceInvalidationServiceIntent);
        }
    }

    @C7.c
    public void internalInitInvalidationTracker(SupportSQLiteDatabase db) {
        k.f(db, "db");
        internalInitInvalidationTracker(new SupportSQLiteConnection(db));
    }

    public final boolean isMainThread$room_runtime() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public boolean isOpen() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            return autoCloser.isActive();
        }
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager != null) {
            return roomConnectionManager.isSupportDatabaseOpen();
        }
        k.n("connectionManager");
        throw null;
    }

    public final boolean isOpenInternal$room_runtime() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            SupportSQLiteDatabase delegateDatabase$room_runtime = autoCloser.getDelegateDatabase();
            if (delegateDatabase$room_runtime != null) {
                return delegateDatabase$room_runtime.isOpen();
            }
            return false;
        }
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager != null) {
            return roomConnectionManager.isSupportDatabaseOpen();
        }
        k.n("connectionManager");
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void performClear(boolean hasForeignKeys, String... tableNames) {
        k.f(tableNames, "tableNames");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new AnonymousClass1(hasForeignKeys, tableNames, null));
    }

    public final Cursor query(SupportSQLiteQuery query) {
        k.f(query, "query");
        return query$default(this, query, null, 2, null);
    }

    public void runInTransaction(Runnable body) {
        k.f(body, "body");
        runInTransaction(new i(body, 11));
    }

    @C7.c
    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    public final void setUseTempTrackingTable$room_runtime(boolean z10) {
        this.useTempTrackingTable = z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <R> Object useConnection(boolean z10, n nVar, H7.c<? super R> cVar) {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager != null) {
            return roomConnectionManager.useConnection(z10, nVar, cVar);
        }
        k.n("connectionManager");
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final <T> T getTypeConverter(d klass) {
        k.f(klass, "klass");
        T t9 = (T) this.typeConverters.get(klass);
        k.d(t9, "null cannot be cast to non-null type T of androidx.room.RoomDatabase.getTypeConverter");
        return t9;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final void internalInitInvalidationTracker(SQLiteConnection connection) {
        k.f(connection, "connection");
        getInvalidationTracker().internalInit$room_runtime(connection);
    }

    public Cursor query(String query, Object[] args) {
        k.f(query, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().query(new SimpleSQLiteQuery(query, args));
    }

    public <V> V runInTransaction(Callable<V> body) {
        k.f(body, "body");
        return (V) runInTransaction(new i(body, 12));
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000f0\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010!\u001a\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001e\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u001f\u0010 J7\u0010#\u001a\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001e\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\"\u0010 R,\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010&¨\u0006'"}, d2 = {"Landroidx/room/RoomDatabase$MigrationContainer;", "", AppAgent.CONSTRUCT, "()V", "", "Landroidx/room/migration/Migration;", "migrations", "LC7/r;", "addMigrations", "([Landroidx/room/migration/Migration;)V", "", "(Ljava/util/List;)V", "migration", "addMigration", "(Landroidx/room/migration/Migration;)V", "", "", "getMigrations", "()Ljava/util/Map;", "start", "end", "findMigrationPath", "(II)Ljava/util/List;", "startVersion", "endVersion", "", "contains", "(II)Z", "migrationStart", "Lkotlin/Pair;", "", "getSortedNodes$room_runtime", "(I)Lkotlin/Pair;", "getSortedNodes", "getSortedDescendingNodes$room_runtime", "getSortedDescendingNodes", "", "Ljava/util/TreeMap;", "Ljava/util/Map;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class MigrationContainer {
        private final Map<Integer, TreeMap<Integer, Migration>> migrations = new LinkedHashMap();

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void addMigration(Migration migration) {
            k.f(migration, "migration");
            int i = migration.startVersion;
            int i6 = migration.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> map = this.migrations;
            Integer numValueOf = Integer.valueOf(i);
            TreeMap<Integer, Migration> treeMap = map.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                map.put(numValueOf, treeMap);
            }
            TreeMap<Integer, Migration> treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i6))) {
                Log.w(Room.LOG_TAG, "Overriding migration " + treeMap2.get(Integer.valueOf(i6)) + " with " + migration);
            }
            treeMap2.put(Integer.valueOf(i6), migration);
        }

        public void addMigrations(List<? extends Migration> migrations) {
            k.f(migrations, "migrations");
            Iterator<T> it = migrations.iterator();
            while (it.hasNext()) {
                addMigration((Migration) it.next());
            }
        }

        public final boolean contains(int startVersion, int endVersion) {
            return MigrationUtil.contains(this, startVersion, endVersion);
        }

        public List<Migration> findMigrationPath(int start, int end) {
            return MigrationUtil.findMigrationPath(this, start, end);
        }

        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }

        public final Pair<Map<Integer, Migration>, Iterable<Integer>> getSortedDescendingNodes$room_runtime(int migrationStart) {
            TreeMap<Integer, Migration> treeMap = this.migrations.get(Integer.valueOf(migrationStart));
            if (treeMap == null) {
                return null;
            }
            return new Pair<>(treeMap, treeMap.descendingKeySet());
        }

        public final Pair<Map<Integer, Migration>, Iterable<Integer>> getSortedNodes$room_runtime(int migrationStart) {
            TreeMap<Integer, Migration> treeMap = this.migrations.get(Integer.valueOf(migrationStart));
            if (treeMap == null) {
                return null;
            }
            return new Pair<>(treeMap, treeMap.keySet());
        }

        public void addMigrations(Migration... migrations) {
            k.f(migrations, "migrations");
            for (Migration migration : migrations) {
                addMigration(migration);
            }
        }
    }

    private final <T> T runInTransaction(S7.a body) {
        if (inCompatibilityMode()) {
            beginTransaction();
            try {
                T t9 = (T) body.invoke();
                setTransactionSuccessful();
                return t9;
            } finally {
                endTransaction();
            }
        }
        return (T) DBUtil.performBlocking(this, false, true, new c(0, body));
    }

    public Cursor query(SupportSQLiteQuery query, CancellationSignal signal) {
        k.f(query, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (signal != null) {
            return getOpenHelper().getWritableDatabase().query(query, signal);
        }
        return getOpenHelper().getWritableDatabase().query(query);
    }
}
