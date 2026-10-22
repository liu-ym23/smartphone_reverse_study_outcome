package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class PolymorphicTypeValidator implements Serializable {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class Base extends PolymorphicTypeValidator implements Serializable {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Validity {

        /* renamed from: a, reason: collision with root package name */
        public static final Validity f4238a;

        /* renamed from: b, reason: collision with root package name */
        public static final Validity f4239b;

        /* renamed from: c, reason: collision with root package name */
        public static final Validity f4240c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ Validity[] f4241d;

        static {
            Validity validity = new Validity("ALLOWED", 0);
            f4238a = validity;
            Validity validity2 = new Validity("DENIED", 1);
            f4239b = validity2;
            Validity validity3 = new Validity("INDETERMINATE", 2);
            f4240c = validity3;
            f4241d = new Validity[]{validity, validity2, validity3};
        }

        public Validity() {
            throw null;
        }

        public static Validity valueOf(String str) {
            return (Validity) Enum.valueOf(Validity.class, str);
        }

        public static Validity[] values() {
            return (Validity[]) f4241d.clone();
        }
    }

    public abstract Validity a(JavaType javaType);

    public abstract Validity b();
}
