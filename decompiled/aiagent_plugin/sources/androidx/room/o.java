package androidx.room;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Room.java */
/* JADX INFO: loaded from: classes.dex */
public class o {
    public static <T extends p> p.a<T> a(Context r2, Class<T> r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        if (r4.trim().length() == 0) goto L9;
        return new p.a(r5, r3, r4);
    L9:
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    public static <T, C> T a(Class<C> r6, String r7) {
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
        r2 = r0 + "." + r8;     // Catch: InstantiationException -> L13 IllegalAccessException -> L15 ClassNotFoundException -> L17
    L18:
        throw new RuntimeException("cannot find implementation for " + r6.getCanonicalName() + ". " + r8 + " does not exist");
    L16:
        throw new RuntimeException("Cannot access the constructor" + r6.getCanonicalName());
    L14:
        throw new RuntimeException("Failed to create an instance of " + r6.getCanonicalName());
    }
}
