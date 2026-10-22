package m2;

import androidx.room.z;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final z f13574a = new z(2);

    public static f a(Object obj) {
        z zVar = f13574a;
        zVar.getClass();
        Class<?> cls = obj.getClass();
        return zVar.c(cls.getClassLoader(), cls.getName());
    }

    public static f b(String str) {
        z zVar = f13574a;
        zVar.getClass();
        return zVar.c(z.class.getClassLoader(), str);
    }
}
