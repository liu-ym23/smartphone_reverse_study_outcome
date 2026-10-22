package com.fasterxml.jackson.core.type;

import com.fasterxml.jackson.core.JsonToken;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WritableTypeId {

    /* renamed from: a, reason: collision with root package name */
    public Object f3619a;

    /* renamed from: b, reason: collision with root package name */
    public Class<?> f3620b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3621c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f3622d;

    /* renamed from: e, reason: collision with root package name */
    public Inclusion f3623e;

    /* renamed from: f, reason: collision with root package name */
    public final JsonToken f3624f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3625g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Inclusion {

        /* renamed from: a, reason: collision with root package name */
        public static final Inclusion f3626a;

        /* renamed from: b, reason: collision with root package name */
        public static final Inclusion f3627b;

        /* renamed from: c, reason: collision with root package name */
        public static final Inclusion f3628c;

        /* renamed from: d, reason: collision with root package name */
        public static final Inclusion f3629d;

        /* renamed from: e, reason: collision with root package name */
        public static final Inclusion f3630e;
        public static final /* synthetic */ Inclusion[] h;

        static {
            Inclusion inclusion = new Inclusion("WRAPPER_ARRAY", 0);
            f3626a = inclusion;
            Inclusion inclusion2 = new Inclusion("WRAPPER_OBJECT", 1);
            f3627b = inclusion2;
            Inclusion inclusion3 = new Inclusion("METADATA_PROPERTY", 2);
            f3628c = inclusion3;
            Inclusion inclusion4 = new Inclusion("PAYLOAD_PROPERTY", 3);
            f3629d = inclusion4;
            Inclusion inclusion5 = new Inclusion("PARENT_PROPERTY", 4);
            f3630e = inclusion5;
            h = new Inclusion[]{inclusion, inclusion2, inclusion3, inclusion4, inclusion5};
        }

        public Inclusion() {
            throw null;
        }

        public static Inclusion valueOf(String str) {
            return (Inclusion) Enum.valueOf(Inclusion.class, str);
        }

        public static Inclusion[] values() {
            return (Inclusion[]) h.clone();
        }
    }

    public WritableTypeId(JsonToken jsonToken, Object obj) {
        this.f3619a = obj;
        this.f3624f = jsonToken;
    }
}
