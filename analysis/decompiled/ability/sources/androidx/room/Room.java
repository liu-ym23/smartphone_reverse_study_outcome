package androidx.room;

import android.content.Context;
import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\b\n\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0013JE\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u000e\b\n\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\r8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Landroidx/room/Room;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/room/RoomDatabase;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Context;", "context", "Ljava/lang/Class;", "klass", "Landroidx/room/RoomDatabase$Builder;", "inMemoryDatabaseBuilder", "(Landroid/content/Context;Ljava/lang/Class;)Landroidx/room/RoomDatabase$Builder;", "", HintConstants.AUTOFILL_HINT_NAME, "databaseBuilder", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)Landroidx/room/RoomDatabase$Builder;", "Lkotlin/Function0;", "factory", "(Landroid/content/Context;LS7/a;)Landroidx/room/RoomDatabase$Builder;", "(Landroid/content/Context;Ljava/lang/String;LS7/a;)Landroidx/room/RoomDatabase$Builder;", "LOG_TAG", "Ljava/lang/String;", "MASTER_TABLE_NAME", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Room {
    public static final Room INSTANCE = new Room();
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: androidx.room.Room$databaseBuilder$3, reason: invalid class name */
    public static final class AnonymousClass3 implements S7.a {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            k.m();
            throw null;
        }

        @Override // S7.a
        public final RoomDatabase invoke() {
            k.m();
            throw null;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: androidx.room.Room$inMemoryDatabaseBuilder$1, reason: invalid class name */
    public static final class AnonymousClass1 implements S7.a {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            k.m();
            throw null;
        }

        @Override // S7.a
        public final RoomDatabase invoke() {
            k.m();
            throw null;
        }
    }

    private Room() {
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, Class<T> klass, String name) {
        k.f(context, "context");
        k.f(klass, "klass");
        if (name == null || m.s0(name)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        if (k.b(name, ":memory:")) {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new RoomDatabase.Builder<>(context, klass, name);
    }

    public static RoomDatabase.Builder databaseBuilder$default(Room room, Context context, String name, S7.a factory, int i, Object obj) {
        if ((i & 4) != 0) {
            k.m();
            throw null;
        }
        k.f(context, "context");
        k.f(name, "name");
        k.f(factory, "factory");
        if (m.s0(name)) {
            throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
        if (name.equals(":memory:")) {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
        k.m();
        throw null;
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> klass) {
        k.f(context, "context");
        k.f(klass, "klass");
        return new RoomDatabase.Builder<>(context, klass, null);
    }

    public static RoomDatabase.Builder inMemoryDatabaseBuilder$default(Room room, Context context, S7.a factory, int i, Object obj) {
        if ((i & 2) != 0) {
            k.m();
            throw null;
        }
        k.f(context, "context");
        k.f(factory, "factory");
        k.m();
        throw null;
    }

    public final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, S7.a factory) {
        k.f(context, "context");
        k.f(factory, "factory");
        k.m();
        throw null;
    }

    public final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, String name, S7.a factory) {
        k.f(context, "context");
        k.f(name, "name");
        k.f(factory, "factory");
        if (!m.s0(name)) {
            if (name.equals(":memory:")) {
                throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
            }
            k.m();
            throw null;
        }
        throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
    }
}
