package androidx.room;

import Ua.C1071n0;
import Ua.I;
import Ua.L0;
import Ua.M;
import Z8.C1173v;
import Z8.C1174w;
import Z8.Q;
import Z8.Y;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.support.AutoCloser;
import androidx.room.support.AutoClosingRoomOpenHelper;
import b1.C1442a;
import com.autonavi.aps.amapapi.config.Const;
import d1.AbstractC3942a;
import e9.InterfaceC4014c;
import f1.C4031a;
import f1.C4035e;
import f1.C4037g;
import h9.InterfaceC4149a;
import i1.InterfaceC4160b;
import i1.InterfaceC4161c;
import j1.InterfaceC4756c;
import j1.InterfaceC4757d;
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
import k.C4794c;
import k1.C4806h;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.coroutines.d;
import o9.C5013a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u001d\b&\u0018\u0000 \u008c\u00012\u00020\u0001:\u000b\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0010\u0091\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J#\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\u00042\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000f\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u001a\u0010\u001b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\u0012\u0004\u0012\u00020\u00010\u0019H\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u001a\u0010\u001b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\u0004\u0012\u00020\u00010\u0019H\u0017¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u0012H\u0015¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0015¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H$¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0007¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020.H\u0000¢\u0006\u0004\b1\u00100J)\u00102\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u001c0\u0019H\u0015¢\u0006\u0004\b2\u00103J)\u00104\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001c0\u0019H\u0015¢\u0006\u0004\b4\u00103J\u001d\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a05H\u0017¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r05H\u0017¢\u0006\u0004\b8\u00107J\u000f\u00109\u001a\u00020\u0004H\u0016¢\u0006\u0004\b9\u0010\u0003J\u000f\u0010:\u001a\u00020\u0004H\u0017¢\u0006\u0004\b:\u0010\u0003J\u000f\u0010;\u001a\u00020\u0004H\u0017¢\u0006\u0004\b;\u0010\u0003JB\u0010C\u001a\u00028\u0000\"\u0004\b\u0000\u0010<2\u0006\u0010>\u001a\u00020=2\"\u0010B\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000A\u0012\u0006\u0012\u0004\u0018\u00010\u00010?H\u0087@¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020=H\u0007¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0004H\u0017¢\u0006\u0004\bG\u0010\u0003J\u000f\u0010H\u001a\u00020\u0004H\u0017¢\u0006\u0004\bH\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010J\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJ\u0017\u0010N\u001a\u00020\u00042\u0006\u0010M\u001a\u00020LH\u0005¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020=H\u0016¢\u0006\u0004\bP\u0010FR\u001e\u0010R\u001a\u0004\u0018\u00010Q8\u0004@\u0004X\u0085\u000e¢\u0006\f\n\u0004\bR\u0010S\u0012\u0004\bT\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010UR\u0016\u0010V\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b]\u0010\\R\u0016\u0010^\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b`\u0010aR\u001a\u0010c\u001a\u00020b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0016\u0010g\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR$\u0010j\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010\u001c8\u0004@\u0004X\u0085\u000e¢\u0006\f\n\u0004\bj\u0010k\u0012\u0004\bl\u0010\u0003R\u0018\u0010n\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u001d\u0010q\u001a\b\u0012\u0004\u0012\u00020.0p8G¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR$\u0010v\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\"\u0010x\u001a\u00020=8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bx\u0010h\u001a\u0004\by\u0010F\"\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010FR\u0015\u0010\u0080\u0001\u001a\u00020Z8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0017\u0010\u0083\u0001\u001a\u00020\"8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0085\u0001\u001a\u00020(8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010*R0\u0010\u0087\u0001\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001c0\u00198@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u00103R\u0016\u0010\u0089\u0001\u001a\u00020=8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010FR\u0016\u0010\u008b\u0001\u001a\u00020=8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010F¨\u0006\u0092\u0001"}, d2 = {"Landroidx/room/RoomDatabase;", "", "<init>", "()V", "LY8/t;", "O", "I", "J", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "body", "P", "(Lp9/a;)Ljava/lang/Object;", "Lw9/d;", "kclass", "converter", "e", "(Lw9/d;Ljava/lang/Object;)V", "Landroidx/room/c;", "configuration", "H", "(Landroidx/room/c;)V", "Landroidx/room/o;", "l", "(Landroidx/room/c;)Landroidx/room/o;", "", "Ljava/lang/Class;", "autoMigrationSpecs", "", "Ld1/a;", "q", "(Ljava/util/Map;)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "config", "Lj1/d;", "o", "(Landroidx/room/c;)Lj1/d;", "Landroidx/room/x;", "n", "()Landroidx/room/x;", "Landroidx/room/InvalidationTracker;", "m", "()Landroidx/room/InvalidationTracker;", "LUa/M;", "s", "()LUa/M;", "Lkotlin/coroutines/d;", "v", "()Lkotlin/coroutines/d;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/Map;", "y", "", "x", "()Ljava/util/Set;", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "R", "", "isReadOnly", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Le9/c;", "block", "U", "(ZLp9/p;Le9/c;)Ljava/lang/Object;", "F", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "p", "Ljava/lang/Runnable;", "Q", "(Ljava/lang/Runnable;)V", "Li1/b;", "connection", "K", "(Li1/b;)V", "G", "Lj1/c;", "mDatabase", "Lj1/c;", "getMDatabase$annotations", "Landroidx/room/c;", "coroutineScope", "LUa/M;", "transactionContext", "Lkotlin/coroutines/d;", "Ljava/util/concurrent/Executor;", "internalQueryExecutor", "Ljava/util/concurrent/Executor;", "internalTransactionExecutor", "connectionManager", "Landroidx/room/o;", "internalTracker", "Landroidx/room/InvalidationTracker;", "Lb1/a;", "closeBarrier", "Lb1/a;", "r", "()Lb1/a;", "allowMainThreadQueries", "Z", "Landroidx/room/RoomDatabase$b;", "mCallbacks", "Ljava/util/List;", "getMCallbacks$annotations", "Landroidx/room/support/AutoCloser;", "autoCloser", "Landroidx/room/support/AutoCloser;", "Ljava/lang/ThreadLocal;", "suspendingTransactionContext", "Ljava/lang/ThreadLocal;", "B", "()Ljava/lang/ThreadLocal;", "", "typeConverters", "Ljava/util/Map;", "useTempTrackingTable", ExifInterface.LONGITUDE_EAST, "setUseTempTrackingTable$room_runtime", "(Z)V", "N", "isThreadInSuspendingTransaction", "D", "()Ljava/util/concurrent/Executor;", "transactionExecutor", "u", "()Lj1/d;", "openHelper", "t", "invalidationTracker", "z", "requiredTypeConverterClassesMap", "M", "isOpenInternal", "L", "isMainThread", "Companion", "JournalMode", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "c", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RoomDatabase {
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;
    private C1407c configuration;
    private o connectionManager;
    private M coroutineScope;
    private Executor internalQueryExecutor;
    private InvalidationTracker internalTracker;
    private Executor internalTransactionExecutor;
    protected List<? extends b> mCallbacks;
    protected volatile InterfaceC4756c mDatabase;
    private kotlin.coroutines.d transactionContext;
    private final C1442a closeBarrier = new C1442a(new RoomDatabase$closeBarrier$1(this));
    private final ThreadLocal<kotlin.coroutines.d> suspendingTransactionContext = new ThreadLocal<>();
    private final Map<InterfaceC5745d<?>, Object> typeConverters = new LinkedHashMap();
    private boolean useTempTrackingTable = true;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000b"}, d2 = {"Landroidx/room/RoomDatabase$JournalMode;", "", "<init>", "(Ljava/lang/String;I)V", "AUTOMATIC", "TRUNCATE", "WRITE_AHEAD_LOGGING", "resolve", "context", "Landroid/content/Context;", "resolve$room_runtime", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class JournalMode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
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

        private JournalMode(String str, int i10) {
        }

        public static InterfaceC4149a<JournalMode> getEntries() {
            return $ENTRIES;
        }

        public static JournalMode valueOf(String str) {
            return (JournalMode) Enum.valueOf(JournalMode.class, str);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        public final JournalMode resolve$room_runtime(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || activityManager.isLowRamDevice()) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    @Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B)\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010%R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010&R\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010*R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00105\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020L0K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020L0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010NR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00030)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010*R\u0016\u0010U\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u00107R\u0016\u0010W\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u00107R\u0016\u0010Y\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u00107R\u0018\u0010[\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010&R\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u001e\u0010d\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u00107¨\u0006o"}, d2 = {"Landroidx/room/RoomDatabase$a;", "Landroidx/room/RoomDatabase;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "klass", "", "name", "<init>", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)V", "Lj1/d$c;", "factory", "e", "(Lj1/d$c;)Landroidx/room/RoomDatabase$a;", "", "Ld1/a;", "migrations", Const.INTENT_KEY_PKGNAME, "([Ld1/a;)Landroidx/room/RoomDatabase$a;", "Landroidx/room/RoomDatabase$JournalMode;", "journalMode", "f", "(Landroidx/room/RoomDatabase$JournalMode;)Landroidx/room/RoomDatabase$a;", "", "dropAllTables", Const.INTENT_KEY_UMID, "(Z)Landroidx/room/RoomDatabase$a;", "Landroidx/room/RoomDatabase$b;", "callback", Const.INTENT_KEY_APIKEY, "(Landroidx/room/RoomDatabase$b;)Landroidx/room/RoomDatabase$a;", "c", "()Landroidx/room/RoomDatabase;", "Lw9/d;", "Lw9/d;", "Landroid/content/Context;", "Ljava/lang/String;", "Lkotlin/Function0;", "Lp9/a;", "", "Ljava/util/List;", "callbacks", "typeConverters", "Ljava/util/concurrent/Executor;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/concurrent/Executor;", "queryExecutor", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "transactionExecutor", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lj1/d$c;", "supportOpenHelperFactory", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Z", "allowMainThreadQueries", "k", "Landroidx/room/RoomDatabase$JournalMode;", "Landroid/content/Intent;", "l", "Landroid/content/Intent;", "multiInstanceInvalidationIntent", "", "m", "J", "autoCloseTimeout", "Ljava/util/concurrent/TimeUnit;", "n", "Ljava/util/concurrent/TimeUnit;", "autoCloseTimeUnit", "Landroidx/room/RoomDatabase$d;", "o", "Landroidx/room/RoomDatabase$d;", "migrationContainer", "", "", "p", "Ljava/util/Set;", "migrationsNotRequiredFrom", "q", "migrationStartAndEndVersions", "r", "autoMigrationSpecs", "s", "requireMigration", "t", "allowDestructiveMigrationOnDowngrade", "u", "allowDestructiveMigrationForAllTables", "v", "copyFromAssetPath", "Ljava/io/File;", "w", "Ljava/io/File;", "copyFromFile", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "x", "Ljava/util/concurrent/Callable;", "copyFromInputStream", "Li1/c;", "y", "Li1/c;", "driver", "Lkotlin/coroutines/d;", "z", "Lkotlin/coroutines/d;", "queryCoroutineContext", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "inMemoryTrackingTableMode", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class a<T extends RoomDatabase> {

        /* renamed from: A, reason: collision with root package name and from kotlin metadata */
        public boolean inMemoryTrackingTableMode;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5745d<T> klass;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Context context;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final String name;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5063a<T> factory;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final List<b> callbacks;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final List<Object> typeConverters;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public Executor queryExecutor;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public Executor transactionExecutor;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public InterfaceC4757d.c supportOpenHelperFactory;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public boolean allowMainThreadQueries;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public JournalMode journalMode;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public Intent multiInstanceInvalidationIntent;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        public long autoCloseTimeout;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        public TimeUnit autoCloseTimeUnit;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        public final d migrationContainer;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        public Set<Integer> migrationsNotRequiredFrom;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        public final Set<Integer> migrationStartAndEndVersions;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        public final List<Object> autoMigrationSpecs;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        public boolean requireMigration;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        public boolean allowDestructiveMigrationOnDowngrade;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        public boolean allowDestructiveMigrationForAllTables;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        public String copyFromAssetPath;

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        public File copyFromFile;

        /* renamed from: x, reason: collision with root package name and from kotlin metadata */
        public Callable<InputStream> copyFromInputStream;

        /* renamed from: y, reason: collision with root package name and from kotlin metadata */
        public InterfaceC4161c driver;

        /* renamed from: z, reason: collision with root package name and from kotlin metadata */
        public kotlin.coroutines.d queryCoroutineContext;

        public a(Context context, Class<T> klass, String str) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(klass, "klass");
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.autoCloseTimeout = -1L;
            this.migrationContainer = new d();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
            this.migrationStartAndEndVersions = new LinkedHashSet();
            this.autoMigrationSpecs = new ArrayList();
            this.requireMigration = true;
            this.inMemoryTrackingTableMode = true;
            this.klass = C5013a.e(klass);
            this.context = context;
            this.name = str;
            this.factory = null;
        }

        public a<T> a(b callback) {
            kotlin.jvm.internal.p.i(callback, "callback");
            this.callbacks.add(callback);
            return this;
        }

        public a<T> b(AbstractC3942a... migrations) {
            kotlin.jvm.internal.p.i(migrations, "migrations");
            for (AbstractC3942a abstractC3942a : migrations) {
                this.migrationStartAndEndVersions.add(Integer.valueOf(abstractC3942a.startVersion));
                this.migrationStartAndEndVersions.add(Integer.valueOf(abstractC3942a.endVersion));
            }
            this.migrationContainer.b((AbstractC3942a[]) Arrays.copyOf(migrations, migrations.length));
            return this;
        }

        public T c() {
            InterfaceC4757d.c hVar;
            InterfaceC4757d.c cVar;
            T tInvoke;
            Executor executor = this.queryExecutor;
            if (executor == null && this.transactionExecutor == null) {
                Executor executorF = C4794c.f();
                this.transactionExecutor = executorF;
                this.queryExecutor = executorF;
            } else if (executor != null && this.transactionExecutor == null) {
                this.transactionExecutor = executor;
            } else if (executor == null) {
                this.queryExecutor = this.transactionExecutor;
            }
            s.c(this.migrationStartAndEndVersions, this.migrationsNotRequiredFrom);
            InterfaceC4161c interfaceC4161c = this.driver;
            if (interfaceC4161c == null && this.supportOpenHelperFactory == null) {
                hVar = new C4806h();
            } else if (interfaceC4161c == null) {
                hVar = this.supportOpenHelperFactory;
            } else {
                if (this.supportOpenHelperFactory != null) {
                    throw new IllegalArgumentException("A RoomDatabase cannot be configured with both a SQLiteDriver and a SupportOpenHelper.Factory.");
                }
                hVar = null;
            }
            boolean z10 = this.autoCloseTimeout > 0;
            boolean z11 = (this.copyFromAssetPath == null && this.copyFromFile == null && this.copyFromInputStream == null) ? false : true;
            if (hVar != null) {
                if (z10) {
                    if (this.name == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                    long j10 = this.autoCloseTimeout;
                    TimeUnit timeUnit = this.autoCloseTimeUnit;
                    if (timeUnit == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    hVar = new e1.f(hVar, new AutoCloser(j10, timeUnit, null, 4, null));
                }
                if (z11) {
                    if (this.name == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                    String str = this.copyFromAssetPath;
                    int i10 = str == null ? 0 : 1;
                    File file = this.copyFromFile;
                    int i11 = file == null ? 0 : 1;
                    Callable<InputStream> callable = this.copyFromInputStream;
                    if (i10 + i11 + (callable != null ? 1 : 0) != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                    }
                    hVar = new e1.h(str, file, callable, hVar);
                }
                cVar = hVar;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                if (z10) {
                    throw new IllegalArgumentException("Auto Closing Database is not supported when an SQLiteDriver is configured.");
                }
                if (z11) {
                    throw new IllegalArgumentException("Pre-Package Database is not supported when an SQLiteDriver is configured.");
                }
            }
            Context context = this.context;
            String str2 = this.name;
            d dVar = this.migrationContainer;
            List<b> list = this.callbacks;
            boolean z12 = this.allowMainThreadQueries;
            JournalMode journalModeResolve$room_runtime = this.journalMode.resolve$room_runtime(context);
            Executor executor2 = this.queryExecutor;
            if (executor2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Executor executor3 = this.transactionExecutor;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            C1407c c1407c = new C1407c(context, str2, cVar, dVar, list, z12, journalModeResolve$room_runtime, executor2, executor3, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, null, this.typeConverters, this.autoMigrationSpecs, this.allowDestructiveMigrationForAllTables, this.driver, this.queryCoroutineContext);
            c1407c.g(this.inMemoryTrackingTableMode);
            InterfaceC5063a<T> interfaceC5063a = this.factory;
            if (interfaceC5063a == null || (tInvoke = interfaceC5063a.invoke()) == null) {
                tInvoke = (T) C4035e.b(C5013a.b(this.klass), null, 2, null);
            }
            tInvoke.H(c1407c);
            return tInvoke;
        }

        public final a<T> d(boolean dropAllTables) {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            this.allowDestructiveMigrationForAllTables = dropAllTables;
            return this;
        }

        public a<T> e(InterfaceC4757d.c factory) {
            this.supportOpenHelperFactory = factory;
            return this;
        }

        public a<T> f(JournalMode journalMode) {
            kotlin.jvm.internal.p.i(journalMode, "journalMode");
            this.journalMode = journalMode;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Landroidx/room/RoomDatabase$b;", "", "<init>", "()V", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "Li1/b;", "connection", Const.INTENT_KEY_APIKEY, "(Li1/b;)V", Const.INTENT_KEY_UMID, "c", "f", "e", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class b {
        public void a(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            if (connection instanceof androidx.sqlite.driver.a) {
                b(((androidx.sqlite.driver.a) connection).getDb());
            }
        }

        public void b(InterfaceC4756c db2) {
            kotlin.jvm.internal.p.i(db2, "db");
        }

        public void c(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            if (connection instanceof androidx.sqlite.driver.a) {
                d(((androidx.sqlite.driver.a) connection).getDb());
            }
        }

        public void d(InterfaceC4756c db2) {
            kotlin.jvm.internal.p.i(db2, "db");
        }

        public void e(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            if (connection instanceof androidx.sqlite.driver.a) {
                f(((androidx.sqlite.driver.a) connection).getDb());
            }
        }

        public void f(InterfaceC4756c db2) {
            kotlin.jvm.internal.p.i(db2, "db");
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\u001e\u001a\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001d\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010 \u001a\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001d\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u000eH\u0000¢\u0006\u0004\b \u0010\u001fR,\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010#¨\u0006$"}, d2 = {"Landroidx/room/RoomDatabase$d;", "", "<init>", "()V", "", "Ld1/a;", "migrations", "LY8/t;", Const.INTENT_KEY_PKGNAME, "([Ld1/a;)V", "migration", Const.INTENT_KEY_APIKEY, "(Ld1/a;)V", "", "", "e", "()Ljava/util/Map;", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "", Const.INTENT_KEY_UMID, "(II)Ljava/util/List;", "startVersion", "endVersion", "", "c", "(II)Z", "migrationStart", "Lkotlin/Pair;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Lkotlin/Pair;", "f", "", "Ljava/util/TreeMap;", "Ljava/util/Map;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Map<Integer, TreeMap<Integer, AbstractC3942a>> migrations = new LinkedHashMap();

        public final void a(AbstractC3942a migration) {
            kotlin.jvm.internal.p.i(migration, "migration");
            int i10 = migration.startVersion;
            int i11 = migration.endVersion;
            Map<Integer, TreeMap<Integer, AbstractC3942a>> map = this.migrations;
            Integer numValueOf = Integer.valueOf(i10);
            TreeMap<Integer, AbstractC3942a> treeMap = map.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                map.put(numValueOf, treeMap);
            }
            TreeMap<Integer, AbstractC3942a> treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i11))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i11)) + " with " + migration);
            }
            treeMap2.put(Integer.valueOf(i11), migration);
        }

        public void b(AbstractC3942a... migrations) {
            kotlin.jvm.internal.p.i(migrations, "migrations");
            for (AbstractC3942a abstractC3942a : migrations) {
                a(abstractC3942a);
            }
        }

        public final boolean c(int startVersion, int endVersion) {
            return C4037g.a(this, startVersion, endVersion);
        }

        public List<AbstractC3942a> d(int start, int end) {
            return C4037g.b(this, start, end);
        }

        public Map<Integer, Map<Integer, AbstractC3942a>> e() {
            return this.migrations;
        }

        public final Pair<Map<Integer, AbstractC3942a>, Iterable<Integer>> f(int migrationStart) {
            TreeMap<Integer, AbstractC3942a> treeMap = this.migrations.get(Integer.valueOf(migrationStart));
            if (treeMap == null) {
                return null;
            }
            return Y8.j.a(treeMap, treeMap.descendingKeySet());
        }

        public final Pair<Map<Integer, AbstractC3942a>, Iterable<Integer>> g(int migrationStart) {
            TreeMap<Integer, AbstractC3942a> treeMap = this.migrations.get(Integer.valueOf(migrationStart));
            if (treeMap == null) {
                return null;
            }
            return Y8.j.a(treeMap, treeMap.keySet());
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/room/RoomDatabase$e;", "", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class e {
    }

    public static final Y8.t R(Runnable runnable) {
        runnable.run();
        return Y8.t.f7040a;
    }

    public static final Object S(InterfaceC5063a interfaceC5063a, InterfaceC4160b it) {
        kotlin.jvm.internal.p.i(it, "it");
        return interfaceC5063a.invoke();
    }

    public static final InterfaceC4757d k(RoomDatabase roomDatabase, C1407c config) {
        kotlin.jvm.internal.p.i(config, "config");
        return roomDatabase.o(config);
    }

    public Map<Class<?>, List<Class<?>>> A() {
        return kotlin.collections.a.i();
    }

    public final ThreadLocal<kotlin.coroutines.d> B() {
        return this.suspendingTransactionContext;
    }

    public final kotlin.coroutines.d C() {
        kotlin.coroutines.d dVar = this.transactionContext;
        if (dVar != null) {
            return dVar;
        }
        kotlin.jvm.internal.p.A("transactionContext");
        return null;
    }

    public Executor D() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        kotlin.jvm.internal.p.A("internalTransactionExecutor");
        return null;
    }

    /* renamed from: E, reason: from getter */
    public final boolean getUseTempTrackingTable() {
        return this.useTempTrackingTable;
    }

    public final boolean F() {
        o oVar = this.connectionManager;
        if (oVar == null) {
            kotlin.jvm.internal.p.A("connectionManager");
            oVar = null;
        }
        return oVar.getSupportOpenHelper() != null;
    }

    public boolean G() {
        return M() && u().getWritableDatabase().inTransaction();
    }

    public void H(C1407c configuration) {
        kotlin.coroutines.d coroutineContext;
        kotlin.jvm.internal.p.i(configuration, "configuration");
        this.configuration = configuration;
        this.useTempTrackingTable = configuration.getUseTempTrackingTable();
        this.connectionManager = l(configuration);
        this.internalTracker = m();
        s.b(this, configuration);
        s.d(this, configuration);
        kotlin.coroutines.d dVar = configuration.queryCoroutineContext;
        M m10 = null;
        if (dVar != null) {
            d.b bVar = dVar.get(kotlin.coroutines.c.INSTANCE);
            kotlin.jvm.internal.p.g(bVar, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
            I i10 = (I) bVar;
            Executor executorA = C1071n0.a(i10);
            this.internalQueryExecutor = executorA;
            if (executorA == null) {
                kotlin.jvm.internal.p.A("internalQueryExecutor");
                executorA = null;
            }
            this.internalTransactionExecutor = new A(executorA);
            this.coroutineScope = kotlinx.coroutines.d.a(configuration.queryCoroutineContext.plus(L0.a((kotlinx.coroutines.g) configuration.queryCoroutineContext.get(kotlinx.coroutines.g.INSTANCE))));
            if (F()) {
                M m11 = this.coroutineScope;
                if (m11 == null) {
                    kotlin.jvm.internal.p.A("coroutineScope");
                    m11 = null;
                }
                coroutineContext = m11.getCoroutineContext().plus(i10.m1(1));
            } else {
                M m12 = this.coroutineScope;
                if (m12 == null) {
                    kotlin.jvm.internal.p.A("coroutineScope");
                    m12 = null;
                }
                coroutineContext = m12.getCoroutineContext();
            }
            this.transactionContext = coroutineContext;
        } else {
            this.internalQueryExecutor = configuration.queryExecutor;
            this.internalTransactionExecutor = new A(configuration.transactionExecutor);
            Executor executor = this.internalQueryExecutor;
            if (executor == null) {
                kotlin.jvm.internal.p.A("internalQueryExecutor");
                executor = null;
            }
            M mA = kotlinx.coroutines.d.a(C1071n0.b(executor).plus(L0.b(null, 1, null)));
            this.coroutineScope = mA;
            if (mA == null) {
                kotlin.jvm.internal.p.A("coroutineScope");
                mA = null;
            }
            kotlin.coroutines.d coroutineContext2 = mA.getCoroutineContext();
            Executor executor2 = this.internalTransactionExecutor;
            if (executor2 == null) {
                kotlin.jvm.internal.p.A("internalTransactionExecutor");
                executor2 = null;
            }
            this.transactionContext = coroutineContext2.plus(C1071n0.b(executor2));
        }
        this.allowMainThreadQueries = configuration.allowMainThreadQueries;
        o oVar = this.connectionManager;
        if (oVar == null) {
            kotlin.jvm.internal.p.A("connectionManager");
            oVar = null;
        }
        InterfaceC4757d interfaceC4757dG = oVar.getSupportOpenHelper();
        if (interfaceC4757dG != null) {
            while (!(interfaceC4757dG instanceof e1.g)) {
                if (!(interfaceC4757dG instanceof InterfaceC1408d)) {
                    interfaceC4757dG = null;
                    break;
                }
                interfaceC4757dG = ((InterfaceC1408d) interfaceC4757dG).getDelegate();
            }
        } else {
            interfaceC4757dG = null;
            break;
        }
        e1.g gVar = (e1.g) interfaceC4757dG;
        if (gVar != null) {
            gVar.g(configuration);
        }
        o oVar2 = this.connectionManager;
        if (oVar2 == null) {
            kotlin.jvm.internal.p.A("connectionManager");
            oVar2 = null;
        }
        InterfaceC4757d interfaceC4757dG2 = oVar2.getSupportOpenHelper();
        if (interfaceC4757dG2 != null) {
            while (!(interfaceC4757dG2 instanceof AutoClosingRoomOpenHelper)) {
                if (!(interfaceC4757dG2 instanceof InterfaceC1408d)) {
                    interfaceC4757dG2 = null;
                    break;
                }
                interfaceC4757dG2 = ((InterfaceC1408d) interfaceC4757dG2).getDelegate();
            }
        } else {
            interfaceC4757dG2 = null;
            break;
        }
        AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) interfaceC4757dG2;
        if (autoClosingRoomOpenHelper != null) {
            this.autoCloser = autoClosingRoomOpenHelper.getAutoCloser();
            AutoCloser autoCloserB = autoClosingRoomOpenHelper.getAutoCloser();
            M m13 = this.coroutineScope;
            if (m13 == null) {
                kotlin.jvm.internal.p.A("coroutineScope");
            } else {
                m10 = m13;
            }
            autoCloserB.k(m10);
            t().y(autoClosingRoomOpenHelper.getAutoCloser());
        }
        if (configuration.multiInstanceInvalidationServiceIntent != null) {
            if (configuration.name == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            t().n(configuration.context, configuration.name, configuration.multiInstanceInvalidationServiceIntent);
        }
    }

    public final void I() {
        f();
        InterfaceC4756c writableDatabase = u().getWritableDatabase();
        if (!writableDatabase.inTransaction()) {
            t().B();
        }
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    public final void J() {
        u().getWritableDatabase().endTransaction();
        if (G()) {
            return;
        }
        t().v();
    }

    public final void K(InterfaceC4160b connection) {
        kotlin.jvm.internal.p.i(connection, "connection");
        t().o(connection);
    }

    public final boolean L() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final boolean M() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            InterfaceC4756c interfaceC4756cI = autoCloser.getDelegateDatabase();
            if (interfaceC4756cI != null) {
                return interfaceC4756cI.isOpen();
            }
            return false;
        }
        o oVar = this.connectionManager;
        if (oVar == null) {
            kotlin.jvm.internal.p.A("connectionManager");
            oVar = null;
        }
        return oVar.J();
    }

    public final boolean N() {
        kotlin.coroutines.d dVar = this.suspendingTransactionContext.get();
        return (dVar != null ? (y) dVar.get(y.INSTANCE) : null) != null;
    }

    public final void O() {
        M m10 = this.coroutineScope;
        o oVar = null;
        if (m10 == null) {
            kotlin.jvm.internal.p.A("coroutineScope");
            m10 = null;
        }
        kotlinx.coroutines.d.e(m10, null, 1, null);
        t().z();
        o oVar2 = this.connectionManager;
        if (oVar2 == null) {
            kotlin.jvm.internal.p.A("connectionManager");
        } else {
            oVar = oVar2;
        }
        oVar.F();
    }

    public final <T> T P(final InterfaceC5063a<? extends T> body) {
        if (!F()) {
            return (T) C4031a.c(this, false, true, new InterfaceC5074l() { // from class: androidx.room.r
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return RoomDatabase.S(body, (InterfaceC4160b) obj);
                }
            });
        }
        h();
        try {
            T tInvoke = body.invoke();
            T();
            return tInvoke;
        } finally {
            p();
        }
    }

    public void Q(final Runnable body) {
        kotlin.jvm.internal.p.i(body, "body");
        P(new InterfaceC5063a() { // from class: androidx.room.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RoomDatabase.R(body);
            }
        });
    }

    public void T() {
        u().getWritableDatabase().setTransactionSuccessful();
    }

    public final <R> Object U(boolean z10, p9.p<? super Transactor, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c) {
        o oVar = this.connectionManager;
        if (oVar == null) {
            kotlin.jvm.internal.p.A("connectionManager");
            oVar = null;
        }
        return oVar.K(z10, pVar, interfaceC4014c);
    }

    public final void e(InterfaceC5745d<?> kclass, Object converter) {
        kotlin.jvm.internal.p.i(kclass, "kclass");
        kotlin.jvm.internal.p.i(converter, "converter");
        this.typeConverters.put(kclass, converter);
    }

    public void f() {
        if (!this.allowMainThreadQueries && L()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void g() {
        if (F() && !G() && N()) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public void h() {
        f();
        I();
    }

    public void i() {
        this.closeBarrier.b();
    }

    public List<AbstractC3942a> j(Map<InterfaceC5745d<Object>, Object> autoMigrationSpecs) {
        kotlin.jvm.internal.p.i(autoMigrationSpecs, "autoMigrationSpecs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(Q.e(autoMigrationSpecs.size()));
        Iterator<T> it = autoMigrationSpecs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(C5013a.b((InterfaceC5745d) entry.getKey()), entry.getValue());
        }
        return q(linkedHashMap);
    }

    public final o l(C1407c configuration) {
        w wVar;
        kotlin.jvm.internal.p.i(configuration, "configuration");
        try {
            x xVarN = n();
            kotlin.jvm.internal.p.g(xVarN, "null cannot be cast to non-null type androidx.room.RoomOpenDelegate");
            wVar = (w) xVarN;
        } catch (NotImplementedError unused) {
            wVar = null;
        }
        return wVar == null ? new o(configuration, (InterfaceC5074l<? super C1407c, ? extends InterfaceC4757d>) new InterfaceC5074l() { // from class: androidx.room.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoomDatabase.k(this.f14812a, (C1407c) obj);
            }
        }, new RoomDatabase$createConnectionManager$2(this)) : new o(configuration, wVar, new RoomDatabase$createConnectionManager$3(this));
    }

    public abstract InvalidationTracker m();

    public x n() {
        throw new NotImplementedError(null, 1, null);
    }

    public InterfaceC4757d o(C1407c config) {
        kotlin.jvm.internal.p.i(config, "config");
        throw new NotImplementedError(null, 1, null);
    }

    public void p() {
        J();
    }

    public List<AbstractC3942a> q(Map<Class<Object>, Object> autoMigrationSpecs) {
        kotlin.jvm.internal.p.i(autoMigrationSpecs, "autoMigrationSpecs");
        return C1173v.m();
    }

    /* renamed from: r, reason: from getter */
    public final C1442a getCloseBarrier() {
        return this.closeBarrier;
    }

    public final M s() {
        M m10 = this.coroutineScope;
        if (m10 != null) {
            return m10;
        }
        kotlin.jvm.internal.p.A("coroutineScope");
        return null;
    }

    public InvalidationTracker t() {
        InvalidationTracker invalidationTracker = this.internalTracker;
        if (invalidationTracker != null) {
            return invalidationTracker;
        }
        kotlin.jvm.internal.p.A("internalTracker");
        return null;
    }

    public InterfaceC4757d u() {
        o oVar = this.connectionManager;
        if (oVar == null) {
            kotlin.jvm.internal.p.A("connectionManager");
            oVar = null;
        }
        InterfaceC4757d interfaceC4757dG = oVar.getSupportOpenHelper();
        if (interfaceC4757dG != null) {
            return interfaceC4757dG;
        }
        throw new IllegalStateException("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
    }

    public final kotlin.coroutines.d v() {
        M m10 = this.coroutineScope;
        if (m10 == null) {
            kotlin.jvm.internal.p.A("coroutineScope");
            m10 = null;
        }
        return m10.getCoroutineContext();
    }

    public Set<InterfaceC5745d<Object>> w() {
        Set<Class<Object>> setX = x();
        ArrayList arrayList = new ArrayList(C1174w.x(setX, 10));
        Iterator<T> it = setX.iterator();
        while (it.hasNext()) {
            arrayList.add(C5013a.e((Class) it.next()));
        }
        return Z8.F.r1(arrayList);
    }

    public Set<Class<Object>> x() {
        return Y.e();
    }

    public Map<InterfaceC5745d<?>, List<InterfaceC5745d<?>>> y() {
        Set<Map.Entry<Class<?>, List<Class<?>>>> setEntrySet = A().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Class cls = (Class) entry.getKey();
            List list = (List) entry.getValue();
            InterfaceC5745d interfaceC5745dE = C5013a.e(cls);
            List list2 = list;
            ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(C5013a.e((Class) it2.next()));
            }
            Pair pairA = Y8.j.a(interfaceC5745dE, arrayList);
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    public final Map<InterfaceC5745d<?>, List<InterfaceC5745d<?>>> z() {
        return y();
    }
}
