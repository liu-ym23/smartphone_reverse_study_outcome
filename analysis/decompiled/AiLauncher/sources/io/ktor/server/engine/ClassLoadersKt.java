package io.ktor.server.engine;

import Z8.Y;
import Z8.Z;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005*\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\u0007\u001a\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ljava/lang/ClassLoader;", "", "Ljava/net/URL;", "allURLs", "(Ljava/lang/ClassLoader;)Ljava/util/Set;", "", "urlClassPath", "(Ljava/lang/ClassLoader;)Ljava/util/List;", "urlClassPathByPackagesList", "Ljava/lang/Class;", "Ljava/lang/reflect/Field;", "findURLClassPathField", "(Ljava/lang/Class;)Ljava/lang/reflect/Field;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClassLoadersKt {
    public static final Set<URL> allURLs(ClassLoader classLoader) {
        Set<URL> setE;
        kotlin.jvm.internal.p.i(classLoader, "<this>");
        ClassLoader parent = classLoader.getParent();
        if (parent == null || (setE = allURLs(parent)) == null) {
            setE = Y.e();
        }
        if (!(classLoader instanceof URLClassLoader)) {
            List<URL> listUrlClassPath = urlClassPath(classLoader);
            return listUrlClassPath == null ? setE : Z.o(setE, listUrlClassPath);
        }
        URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
        kotlin.jvm.internal.p.h(uRLs, "getURLs(...)");
        return Z.o(Z8.F.r1(Z8.r.V(uRLs)), setE);
    }

    private static final Field findURLClassPathField(Class<?> cls) {
        Field field;
        Field fieldFindURLClassPathField;
        Field[] declaredFields = cls.getDeclaredFields();
        kotlin.jvm.internal.p.h(declaredFields, "getDeclaredFields(...)");
        int length = declaredFields.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                field = null;
                break;
            }
            field = declaredFields[i10];
            if (kotlin.jvm.internal.p.d(field.getName(), "ucp") && kotlin.jvm.internal.p.d(field.getType().getSimpleName(), "URLClassPath")) {
                break;
            }
            i10++;
        }
        if (field != null) {
            return field;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || (fieldFindURLClassPathField = findURLClassPathField(superclass)) == null) {
            return null;
        }
        return fieldFindURLClassPathField;
    }

    private static final List<URL> urlClassPath(ClassLoader classLoader) {
        Method method;
        try {
            try {
                Field fieldFindURLClassPathField = findURLClassPathField(classLoader.getClass());
                if (fieldFindURLClassPathField == null) {
                    return null;
                }
                fieldFindURLClassPathField.setAccessible(true);
                Object obj = fieldFindURLClassPathField.get(classLoader);
                if (obj == null || (method = obj.getClass().getMethod("getURLs", null)) == null) {
                    return null;
                }
                method.setAccessible(true);
                URL[] urlArr = (URL[]) method.invoke(obj, null);
                if (urlArr != null) {
                    return Z8.r.T0(urlArr);
                }
                return null;
            } catch (Throwable unused) {
                return urlClassPathByPackagesList(classLoader);
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List<java.net.URL> urlClassPathByPackagesList(java.lang.ClassLoader r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.ClassLoadersKt.urlClassPathByPackagesList(java.lang.ClassLoader):java.util.List");
    }
}
