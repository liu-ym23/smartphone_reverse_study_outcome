package androidx.room;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f4618a = null;

    static {
        f4618a = new n0();
    }

    public n0() {
    }

    public static final RoomDatabase.a a(Context r10, Class r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "klass");
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L13;
        return new RoomDatabase.a(r10, r11, r12);
    L13:
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    L5:
        if (kotlin.text.o.r(r12) == true) goto L8;
        r13 = false;
        goto L9
    }

    public static final Object b(Class r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "klass");
        kotlin.jvm.internal.q.g(r11, "suffix");
        Package r12 = r10.getPackage();
        kotlin.jvm.internal.q.d(r12);
        String r13 = r12.getName();
        String r14 = r10.getCanonicalName();
        kotlin.jvm.internal.q.d(r14);
        kotlin.jvm.internal.q.f(r13, "fullPackage");
        if (r13.length() == 0) goto L6;
        r14 = r14.substring(r13.length() + 1);
        kotlin.jvm.internal.q.f(r14, "this as java.lang.String).substring(startIndex)");
    L6:
        String r15 = kotlin.text.o.w(r14, '.', '_', false, 4, null) + r11;
        if (r13.length() != 0) goto L10;
        String r16 = r15;
    L11:
        Class<?> r17 = Class.forName(r16, true, r10.getClassLoader());     // Catch: InstantiationException -> L13 IllegalAccessException -> L15 ClassNotFoundException -> L17
        kotlin.jvm.internal.q.e(r17, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");     // Catch: InstantiationException -> L13 IllegalAccessException -> L15 ClassNotFoundException -> L17
        return r17.getDeclaredConstructor(null).newInstance(null);
    L10:
        r16 = r13 + '.' + r15;     // Catch: InstantiationException -> L13 IllegalAccessException -> L15 ClassNotFoundException -> L17
    L18:
        throw new RuntimeException("Cannot find implementation for " + r10.getCanonicalName() + ". " + r15 + " does not exist");
    L16:
        throw new RuntimeException("Cannot access the constructor " + r10.getCanonicalName());
    L14:
        throw new RuntimeException("Failed to create an instance of " + r10.getCanonicalName());
    }

    public static final RoomDatabase.a c(Context r10, Class r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "klass");
        return new RoomDatabase.a(r10, r11, null);
    }
}
