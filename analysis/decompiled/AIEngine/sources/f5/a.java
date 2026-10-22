package f5;

import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Type, d5.k<?>> f8732a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8733b;

    /* renamed from: c, reason: collision with root package name */
    public final List<ReflectionAccessFilter> f8734c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: f5.a$a, reason: collision with other inner class name */
    public class C0080a<T> implements g<T> {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d5.k f8735g;

        public C0080a(d5.k kVar, Type type) {
            this.f8735g = kVar;
        }

        @Override // f5.g
        public final T c() {
            return (T) this.f8735g.a();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b<T> implements g<T> {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d5.k f8736g;

        public b(d5.k kVar, Type type) {
            this.f8736g = kVar;
        }

        @Override // f5.g
        public final T c() {
            return (T) this.f8736g.a();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c<T> implements g<T> {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f8737g;

        public c(String str) {
            this.f8737g = str;
        }

        @Override // f5.g
        public final T c() {
            throw new JsonIOException(this.f8737g);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d<T> implements g<T> {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f8738g;

        public d(String str) {
            this.f8738g = str;
        }

        @Override // f5.g
        public final T c() {
            throw new JsonIOException(this.f8738g);
        }
    }

    public a(Map<Type, d5.k<?>> map, boolean z, List<ReflectionAccessFilter> list) {
        this.f8732a = map;
        this.f8733b = z;
        this.f8734c = list;
    }

    public static String a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("r8-abstract-class");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> f5.g<T> b(com.google.gson.reflect.TypeToken<T> r9) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.a.b(com.google.gson.reflect.TypeToken):f5.g");
    }

    public final String toString() {
        return this.f8732a.toString();
    }
}
