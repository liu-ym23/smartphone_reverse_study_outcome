package androidx.room;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public Room() {
    }

    public static <T, C> T getGeneratedImplementation(Class<C> r100, String r101) {
        String r102 = r100.getPackage().getName();
        String r103 = r100.getCanonicalName();
        if (r102.isEmpty() == true) goto L6;
        r103 = r103.substring(r102.length() + 1);
    L6:
        String r104 = r103.replace('.', '_') + r101;
        if (r102.isEmpty() == false) goto L10;
        String r105 = r104;
    L11:
        return (T) INVOKESTATIC_androidx_room_Room_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r105, true, r100.getClassLoader()).newInstance();
    L10:
        r105 = r102 + "." + r104;     // Catch: InstantiationException -> L13 IllegalAccessException -> L15 ClassNotFoundException -> L17
    L18:
        throw new RuntimeException("cannot find implementation for " + r100.getCanonicalName() + ". " + r104 + " does not exist");
    L16:
        throw new RuntimeException("Cannot access the constructor" + r100.getCanonicalName());
    L14:
        throw new RuntimeException("Failed to create an instance of " + r100.getCanonicalName());
    }

    public static <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context r100, Class<T> r101) {
        return new RoomDatabase.Builder(r100, r101, null);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_room_Room_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context r100, Class<T> r101, String r102) {
        if (r102 == null) goto L8;
        if (r102.trim().length() == 0) goto L8;
        return new RoomDatabase.Builder(r100, r101, r102);
    L8:
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }
}
