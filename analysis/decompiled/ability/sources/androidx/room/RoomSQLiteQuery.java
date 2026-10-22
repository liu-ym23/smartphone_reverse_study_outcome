package androidx.room;

import B9.Q;
import C7.r;
import D7.q;
import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0002HGB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0015¢\u0006\u0004\b\u0013\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0006J\u001f\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010!J\u001f\u0010$\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\u000eJ\u0015\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0000¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\nH\u0016¢\u0006\u0004\b*\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010+\u001a\u0004\b,\u0010-R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010.R\u001a\u00100\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u00101\u0012\u0004\b2\u0010\u000eR\u001a\u00104\u001a\u0002038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u0012\u0004\b6\u0010\u000eR\"\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u00109\u0012\u0004\b:\u0010\u000eR\"\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010<\u0012\u0004\b=\u0010\u000eR\u001a\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b?\u0010@\u0012\u0004\bA\u0010\u000eR$\u0010B\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bB\u0010+\u001a\u0004\bC\u0010-R\u0014\u0010F\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006I"}, d2 = {"Landroidx/room/RoomSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "", "capacity", AppAgent.CONSTRUCT, "(I)V", "", "query", "initArgCount", "LC7/r;", "init", "(Ljava/lang/String;I)V", "release", "()V", "Landroidx/room/RoomRawQuery;", "toRoomRawQuery", "()Landroidx/room/RoomRawQuery;", "statement", "bindTo", "(Landroidx/sqlite/db/SupportSQLiteProgram;)V", "Landroidx/sqlite/SQLiteStatement;", "(Landroidx/sqlite/SQLiteStatement;)V", "index", "bindNull", "", "value", "bindLong", "(IJ)V", "", "bindDouble", "(ID)V", "bindString", "(ILjava/lang/String;)V", "bindText", "", "bindBlob", "(I[B)V", "close", "other", "copyArgumentsFrom", "(Landroidx/room/RoomSQLiteQuery;)V", "clearBindings", "I", "getCapacity", "()I", "Ljava/lang/String;", "", "longBindings", "[J", "getLongBindings$annotations", "", "doubleBindings", "[D", "getDoubleBindings$annotations", "", "stringBindings", "[Ljava/lang/String;", "getStringBindings$annotations", "blobBindings", "[[B", "getBlobBindings$annotations", "", "bindingTypes", "[I", "getBindingTypes$annotations", "argCount", "getArgCount", "getSql", "()Ljava/lang/String;", "sql", "Companion", "Binding", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"WrongConstant"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;

    @VisibleForTesting
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Binding;", "", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface Binding {
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0003R\u001a\u0010\u0012\u001a\u00020\u000b8\u0006X\u0087T¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0003R\u001a\u0010\u0015\u001a\u00020\u000b8\u0006X\u0087T¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u0012\u0004\b\u0016\u0010\u0003R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001a\u0010\u0003R\u0014\u0010\u001b\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0014\u0010\u001d\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0014\u0010\u001f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0013¨\u0006 "}, d2 = {"Landroidx/room/RoomSQLiteQuery$Companion;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/sqlite/db/SupportSQLiteQuery;", "supportSQLiteQuery", "Landroidx/room/RoomSQLiteQuery;", "copyFrom", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Landroidx/room/RoomSQLiteQuery;", "", "query", "", "argumentCount", "acquire", "(Ljava/lang/String;I)Landroidx/room/RoomSQLiteQuery;", "LC7/r;", "prunePoolLocked$room_runtime", "prunePoolLocked", "POOL_LIMIT", "I", "getPOOL_LIMIT$annotations", "DESIRED_POOL_SIZE", "getDESIRED_POOL_SIZE$annotations", "Ljava/util/TreeMap;", "queryPool", "Ljava/util/TreeMap;", "getQueryPool$annotations", "NULL", "LONG", "DOUBLE", "STRING", "BLOB", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getQueryPool$annotations() {
        }

        public final RoomSQLiteQuery acquire(String query, int argumentCount) {
            k.f(query, "query");
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(argumentCount));
                if (entryCeilingEntry == null) {
                    RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(argumentCount, null);
                    roomSQLiteQuery.init(query, argumentCount);
                    return roomSQLiteQuery;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                RoomSQLiteQuery value = entryCeilingEntry.getValue();
                value.init(query, argumentCount);
                return value;
            }
        }

        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
            k.f(supportSQLiteQuery, "supportSQLiteQuery");
            final RoomSQLiteQuery roomSQLiteQueryAcquire = acquire(supportSQLiteQuery.getQuery(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery$Companion$copyFrom$1
                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindBlob(int index, byte[] value) {
                    k.f(value, "value");
                    roomSQLiteQueryAcquire.bindBlob(index, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindDouble(int index, double value) {
                    roomSQLiteQueryAcquire.bindDouble(index, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindLong(int index, long value) {
                    roomSQLiteQueryAcquire.bindLong(index, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindNull(int index) {
                    roomSQLiteQueryAcquire.bindNull(index);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindString(int index, String value) {
                    k.f(value, "value");
                    roomSQLiteQueryAcquire.bindString(index, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void clearBindings() {
                    roomSQLiteQueryAcquire.clearBindings();
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    roomSQLiteQueryAcquire.close();
                }
            });
            return roomSQLiteQueryAcquire;
        }

        public final void prunePoolLocked$room_runtime() {
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            k.e(it, "iterator(...)");
            while (true) {
                int i = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i;
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ RoomSQLiteQuery(int i, e eVar) {
        this(i);
    }

    public static final RoomSQLiteQuery acquire(String str, int i) {
        return INSTANCE.acquire(str, i);
    }

    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        return INSTANCE.copyFrom(supportSQLiteQuery);
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLongBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStringBindings$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r toRoomRawQuery$lambda$1(RoomSQLiteQuery roomSQLiteQuery, SQLiteStatement it) {
        k.f(it, "it");
        roomSQLiteQuery.bindTo(it);
        return r.f317a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int index, byte[] value) {
        k.f(value, "value");
        this.bindingTypes[index] = 5;
        this.blobBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int index, double value) {
        this.bindingTypes[index] = 3;
        this.doubleBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int index, long value) {
        this.bindingTypes[index] = 2;
        this.longBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int index) {
        this.bindingTypes[index] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int index, String value) {
        k.f(value, "value");
        this.bindingTypes[index] = 4;
        this.stringBindings[index] = value;
    }

    public final void bindText(int index, String value) {
        k.f(value, "value");
        bindString(index, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram statement) {
        k.f(statement, "statement");
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i = 1;
        while (true) {
            int i6 = this.bindingTypes[i];
            if (i6 == 1) {
                statement.bindNull(i);
            } else if (i6 == 2) {
                statement.bindLong(i, this.longBindings[i]);
            } else if (i6 == 3) {
                statement.bindDouble(i, this.doubleBindings[i]);
            } else if (i6 == 4) {
                String str = this.stringBindings[i];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.bindString(i, str);
            } else if (i6 == 5) {
                byte[] bArr = this.blobBindings[i];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.bindBlob(i, bArr);
            }
            if (i == argCount) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        q.g0(this.bindingTypes, 1, 0, 6);
        String[] strArr = this.stringBindings;
        q.f0(null, 0, strArr, strArr.length);
        byte[][] bArr = this.blobBindings;
        q.f0(null, 0, bArr, bArr.length);
        this.query = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery other) {
        k.f(other, "other");
        int argCount = other.getArgCount() + 1;
        System.arraycopy(other.bindingTypes, 0, this.bindingTypes, 0, argCount);
        System.arraycopy(other.longBindings, 0, this.longBindings, 0, argCount);
        System.arraycopy(other.stringBindings, 0, this.stringBindings, 0, argCount);
        System.arraycopy(other.blobBindings, 0, this.blobBindings, 0, argCount);
        System.arraycopy(other.doubleBindings, 0, this.doubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    /* renamed from: getSql */
    public String getQuery() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void init(String query, int initArgCount) {
        k.f(query, "query");
        this.query = query;
        this.argCount = initArgCount;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            INSTANCE.prunePoolLocked$room_runtime();
        }
    }

    public final RoomRawQuery toRoomRawQuery() {
        return new RoomRawQuery(getQuery(), new Q(this, 20));
    }

    private RoomSQLiteQuery(int i) {
        this.capacity = i;
        int i6 = i + 1;
        this.bindingTypes = new int[i6];
        this.longBindings = new long[i6];
        this.doubleBindings = new double[i6];
        this.stringBindings = new String[i6];
        this.blobBindings = new byte[i6][];
    }

    public final void bindTo(SQLiteStatement statement) {
        k.f(statement, "statement");
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i = 1;
        while (true) {
            int i6 = this.bindingTypes[i];
            if (i6 == 1) {
                statement.mo7171bindNull(i);
            } else if (i6 == 2) {
                statement.mo7170bindLong(i, this.longBindings[i]);
            } else if (i6 == 3) {
                statement.mo7169bindDouble(i, this.doubleBindings[i]);
            } else if (i6 == 4) {
                String str = this.stringBindings[i];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.mo7172bindText(i, str);
            } else if (i6 == 5) {
                byte[] bArr = this.blobBindings[i];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.mo7168bindBlob(i, bArr);
            }
            if (i == argCount) {
                return;
            } else {
                i++;
            }
        }
    }
}
