package androidx.room;

import android.content.Context;
import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes.dex */
public class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    public static <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, Class<T> klass, String name) {
        if (name == null) goto L8;
        if (name.trim().length() == 0) goto L8;
        return new RoomDatabase.Builder(context, klass, name);
    L8:
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    public static <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> klass) {
        return new RoomDatabase.Builder(context, klass, null);
    }

    static <T, C> T getGeneratedImplementation(Class<C> r6, String r7) {
        String r0 = r6.getPackage().getName();
        String r1 = r6.getCanonicalName();
        if (r0.isEmpty() == true) goto L6;
        r1 = r1.substring(r0.length() + 1);
    L6:
        String r8 = r1.replace('.', '_') + r7;
        if (r0.isEmpty() == false) goto L10;
        String r2 = r8;
    L11:
        return (T) Class.forName(r2, true, r6.getClassLoader()).newInstance();
    L10:
        r2 = r0 + LibrarianImpl.Constants.DOT + r8;     // Catch: InstantiationException -> L13 IllegalAccessException -> L15 ClassNotFoundException -> L17
    L18:
        throw new RuntimeException("cannot find implementation for " + r6.getCanonicalName() + ". " + r8 + " does not exist");
    L16:
        throw new RuntimeException("Cannot access the constructor" + r6.getCanonicalName());
    L14:
        throw new RuntimeException("Failed to create an instance of " + r6.getCanonicalName());
    }

    @Deprecated
    public Room() {
    }
}
