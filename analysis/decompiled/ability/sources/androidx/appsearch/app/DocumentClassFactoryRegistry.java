package androidx.appsearch.app;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class DocumentClassFactoryRegistry {
    private static final String GEN_CLASS_PREFIX = "$$__AppSearch__";
    private static volatile DocumentClassFactoryRegistry sInstance;
    private final Map<Class<?>, DocumentClassFactory<?>> mFactories = new HashMap();

    private DocumentClassFactoryRegistry() {
    }

    public static DocumentClassFactoryRegistry getInstance() {
        if (sInstance == null) {
            synchronized (DocumentClassFactoryRegistry.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new DocumentClassFactoryRegistry();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private DocumentClassFactory<?> loadFactoryByReflection(Class<?> cls) throws AppSearchException {
        String str;
        Package r02 = cls.getPackage();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new AppSearchException(2, "Failed to find simple name for document class \"" + cls + "\". Perhaps it is anonymous?");
        }
        if (r02 != null) {
            str = r02.getName() + ".";
            canonicalName = canonicalName.substring(str.length()).replace(".", "$$__");
        } else {
            str = "";
        }
        String strB = B7.a.B(str, GEN_CLASS_PREFIX, canonicalName);
        try {
            try {
                return (DocumentClassFactory) Class.forName(strB).getDeclaredConstructor(null).newInstance(null);
            } catch (Exception e) {
                throw new AppSearchException(2, B7.a.m("Failed to construct document class converter \"", strB, "\""), e);
            }
        } catch (ClassNotFoundException e6) {
            Class<? super Object> superclass = cls.getSuperclass();
            Class<?>[] interfaces = cls.getInterfaces();
            Class<? super Object> cls2 = superclass != Object.class ? superclass : null;
            int length = interfaces.length;
            if (cls2 != null) {
                length++;
            }
            if (length == 1) {
                return cls2 != null ? this.loadFactoryByReflection(cls2) : this.loadFactoryByReflection(interfaces[0]);
            }
            String strM = B7.a.m("Failed to find document class converter \"", strB, "\". Perhaps the annotation processor was not run or the class was proguarded out?");
            if (length > 1) {
                strM = androidx.appfunctions.metadata.a.l(strM, " Or, this class may not have been annotated with @Document, and there is an ambiguity to determine a unique @Document annotated parent class/interface.");
            }
            throw new AppSearchException(2, strM, e6);
        }
    }

    public <T> DocumentClassFactory<T> getOrCreateFactory(Class<T> cls) throws AppSearchException {
        DocumentClassFactory<T> documentClassFactory;
        Preconditions.checkNotNull(cls);
        synchronized (this) {
            documentClassFactory = (DocumentClassFactory) this.mFactories.get(cls);
        }
        if (documentClassFactory != null) {
            return documentClassFactory;
        }
        DocumentClassFactory<?> documentClassFactory2 = (DocumentClassFactory<T>) loadFactoryByReflection(cls);
        synchronized (this) {
            try {
                DocumentClassFactory<?> documentClassFactory3 = this.mFactories.get(cls);
                if (documentClassFactory3 == null) {
                    this.mFactories.put(cls, documentClassFactory2);
                } else {
                    documentClassFactory2 = (DocumentClassFactory<T>) documentClassFactory3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return (DocumentClassFactory<T>) documentClassFactory2;
    }

    public <T> DocumentClassFactory<T> getOrCreateFactory(T t9) throws AppSearchException {
        Preconditions.checkNotNull(t9);
        return getOrCreateFactory((Class) t9.getClass());
    }
}
