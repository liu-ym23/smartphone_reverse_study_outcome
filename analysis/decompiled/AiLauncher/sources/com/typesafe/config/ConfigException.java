package com.typesafe.config;

import b8.k;
import com.typesafe.config.impl.C3904j;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public abstract class ConfigException extends RuntimeException implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final transient k f31714a;

    public static class BadPath extends ConfigException {
        /* JADX WARN: Illegal instructions before constructor call */
        public BadPath(k kVar, String str, String str2, Throwable th) {
            if (str != null) {
                str2 = "Invalid path '" + str + "': " + str2;
            }
            super(kVar, str2, th);
        }

        public BadPath(k kVar, String str, String str2) {
            this(kVar, str, str2, null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public BadPath(String str, String str2, Throwable th) {
            if (str != null) {
                str2 = "Invalid path '" + str + "': " + str2;
            }
            super(str2, th);
        }

        public BadPath(String str, String str2) {
            this(str, str2, (Throwable) null);
        }
    }

    public static class BugOrBroken extends ConfigException {
        public BugOrBroken(String str, Throwable th) {
            super(str, th);
        }

        public BugOrBroken(String str) {
            this(str, null);
        }
    }

    public static class Generic extends ConfigException {
        public Generic(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class IO extends ConfigException {
        public IO(k kVar, String str, Throwable th) {
            super(kVar, str, th);
        }
    }

    public static class Missing extends ConfigException {
        public Missing(k kVar, String str) {
            this(kVar, "No configuration setting found for key '" + str + "'", null);
        }

        public Missing(k kVar, String str, Throwable th) {
            super(kVar, str, th);
        }
    }

    public static class NotResolved extends BugOrBroken {
        public NotResolved(String str, Throwable th) {
            super(str, th);
        }

        public NotResolved(String str) {
            this(str, null);
        }
    }

    public static class Null extends Missing {
        public Null(k kVar, String str, String str2, Throwable th) {
            super(kVar, c(str, str2), th);
        }

        public static String c(String str, String str2) {
            if (str2 == null) {
                return "Configuration key '" + str + "' is null";
            }
            return "Configuration key '" + str + "' is set to null but expected " + str2;
        }

        public Null(k kVar, String str, String str2) {
            this(kVar, str, str2, null);
        }
    }

    public static class Parse extends ConfigException {
        public Parse(k kVar, String str, Throwable th) {
            super(kVar, str, th);
        }

        public Parse(k kVar, String str) {
            this(kVar, str, null);
        }
    }

    public static class WrongType extends ConfigException {
        public WrongType(k kVar, String str, String str2, String str3, Throwable th) {
            super(kVar, str + " has type " + str3 + " rather than " + str2, th);
        }

        public WrongType(k kVar, String str, String str2, String str3) {
            this(kVar, str, str2, str3, null);
        }

        public WrongType(k kVar, String str) {
            super(kVar, str, null);
        }
    }

    public ConfigException(k kVar, String str, Throwable th) {
        super(kVar.description() + ": " + str, th);
        this.f31714a = kVar;
    }

    public static <T> void b(T t10, Class<T> cls, k kVar) throws IllegalAccessException, NoSuchFieldException, SecurityException, IOException, IllegalArgumentException {
        try {
            Field declaredField = cls.getDeclaredField("origin");
            declaredField.setAccessible(true);
            try {
                declaredField.set(t10, kVar);
            } catch (IllegalAccessException e10) {
                throw new IOException("unable to set origin field", e10);
            } catch (IllegalArgumentException e11) {
                throw new IOException("unable to set origin field", e11);
            }
        } catch (NoSuchFieldException e12) {
            throw new IOException(cls.getSimpleName() + " has no origin field?", e12);
        } catch (SecurityException e13) {
            throw new IOException("unable to fill out origin field in " + cls.getSimpleName(), e13);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IOException, SecurityException, IllegalArgumentException {
        objectInputStream.defaultReadObject();
        b(this, ConfigException.class, C3904j.f(objectInputStream));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        C3904j.m(objectOutputStream, this.f31714a);
    }

    public k a() {
        return this.f31714a;
    }

    public static class UnresolvedSubstitution extends Parse {

        /* renamed from: b, reason: collision with root package name */
        public final String f31715b;

        public UnresolvedSubstitution(k kVar, String str, Throwable th) {
            super(kVar, "Could not resolve substitution to a value: " + str, th);
            this.f31715b = str;
        }

        public UnresolvedSubstitution c(String str) {
            return new UnresolvedSubstitution(this, a(), String.format(str, this.f31715b));
        }

        public UnresolvedSubstitution(k kVar, String str) {
            this(kVar, str, (Throwable) null);
        }

        public UnresolvedSubstitution(UnresolvedSubstitution unresolvedSubstitution, k kVar, String str) {
            super(kVar, str, unresolvedSubstitution);
            this.f31715b = unresolvedSubstitution.f31715b;
        }
    }

    public ConfigException(String str, Throwable th) {
        super(str, th);
        this.f31714a = null;
    }
}
