package com.fasterxml.jackson.core;

import a3.j;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.io.StringReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import v2.c;
import v2.e;
import z2.a;
import z2.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class JsonFactory extends TokenStreamFactory implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final int f3523l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f3524m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f3525n;

    /* renamed from: o, reason: collision with root package name */
    public static final SerializedString f3526o;

    /* renamed from: a, reason: collision with root package name */
    public final transient b f3527a;

    /* renamed from: b, reason: collision with root package name */
    public final transient a f3528b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3529c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3530d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3531e;
    public c h;

    /* renamed from: j, reason: collision with root package name */
    public final e f3532j;

    /* renamed from: k, reason: collision with root package name */
    public final char f3533k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Feature implements a3.e {

        /* renamed from: a, reason: collision with root package name */
        public static final Feature f3534a;

        /* renamed from: b, reason: collision with root package name */
        public static final Feature f3535b;

        /* renamed from: c, reason: collision with root package name */
        public static final Feature f3536c;

        /* renamed from: d, reason: collision with root package name */
        public static final Feature f3537d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Feature[] f3538e;

        static {
            Feature feature = new Feature("INTERN_FIELD_NAMES", 0);
            f3534a = feature;
            Feature feature2 = new Feature("CANONICALIZE_FIELD_NAMES", 1);
            f3535b = feature2;
            Feature feature3 = new Feature("FAIL_ON_SYMBOL_HASH_OVERFLOW", 2);
            f3536c = feature3;
            Feature feature4 = new Feature("USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING", 3);
            f3537d = feature4;
            f3538e = new Feature[]{feature, feature2, feature3, feature4};
        }

        public static Feature valueOf(String str) {
            return (Feature) Enum.valueOf(Feature.class, str);
        }

        public static Feature[] values() {
            return (Feature[]) f3538e.clone();
        }

        @Override // a3.e
        public final boolean a() {
            return true;
        }

        @Override // a3.e
        public final int b() {
            return 1 << ordinal();
        }

        public final boolean c(int i10) {
            return (b() & i10) != 0;
        }
    }

    static {
        int iB = 0;
        for (Feature feature : Feature.values()) {
            feature.getClass();
            iB |= feature.b();
        }
        f3523l = iB;
        int i10 = 0;
        for (JsonParser.Feature feature2 : JsonParser.Feature.values()) {
            if (feature2.f3572a) {
                i10 |= feature2.f3573b;
            }
        }
        f3524m = i10;
        int i11 = 0;
        for (JsonGenerator.Feature feature3 : JsonGenerator.Feature.values()) {
            if (feature3.f3550a) {
                i11 |= feature3.f3551b;
            }
        }
        f3525n = i11;
        f3526o = DefaultPrettyPrinter.f3635k;
    }

    public JsonFactory() {
        this(null);
    }

    public final a3.a a() {
        SoftReference<a3.a> softReference;
        if (!Feature.f3537d.c(this.f3529c)) {
            return new a3.a();
        }
        ThreadLocal<SoftReference<a3.a>> threadLocal = a3.b.f13b;
        SoftReference<a3.a> softReference2 = threadLocal.get();
        a3.a aVar = softReference2 == null ? null : softReference2.get();
        if (aVar == null) {
            aVar = new a3.a();
            j jVar = a3.b.f12a;
            if (jVar != null) {
                ReferenceQueue<a3.a> referenceQueue = jVar.f35b;
                softReference = new SoftReference<>(aVar, referenceQueue);
                ConcurrentHashMap concurrentHashMap = jVar.f34a;
                concurrentHashMap.put(softReference, Boolean.TRUE);
                while (true) {
                    SoftReference softReference3 = (SoftReference) referenceQueue.poll();
                    if (softReference3 == null) {
                        break;
                    }
                    concurrentHashMap.remove(softReference3);
                }
            } else {
                softReference = new SoftReference<>(aVar);
            }
            threadLocal.set(softReference);
        }
        return aVar;
    }

    public final y2.e b(String str) {
        int length = str.length();
        int i10 = this.f3529c;
        b bVar = this.f3527a;
        if (length > 32768) {
            StringReader stringReader = new StringReader(str);
            return new y2.e(new x2.b(a(), stringReader, false), this.f3530d, stringReader, this.h, new b(bVar, i10, bVar.f14241c, bVar.f14240b.get()));
        }
        a3.a aVarA = a();
        x2.b bVar2 = new x2.b(aVarA, str, true);
        x2.b.a(bVar2.h);
        char[] cArrB = aVarA.b(0, length);
        bVar2.h = cArrB;
        str.getChars(0, length, cArrB, 0);
        return new y2.e(bVar2, this.f3530d, this.h, new b(bVar, i10, bVar.f14241c, bVar.f14240b.get()), cArrB, length);
    }

    public Object readResolve() {
        return new JsonFactory(this, this.h);
    }

    public JsonFactory(ObjectMapper objectMapper) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f3527a = new b((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        this.f3528b = new a((((int) jCurrentTimeMillis2) + ((int) (jCurrentTimeMillis2 >>> 32))) | 1);
        this.f3529c = f3523l;
        this.f3530d = f3524m;
        this.f3531e = f3525n;
        this.f3532j = f3526o;
        this.h = objectMapper;
        this.f3533k = '\"';
    }

    public JsonFactory(JsonFactory jsonFactory, c cVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f3527a = new b((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        this.f3528b = new a((((int) jCurrentTimeMillis2) + ((int) (jCurrentTimeMillis2 >>> 32))) | 1);
        this.f3529c = f3523l;
        this.f3530d = f3524m;
        this.f3531e = f3525n;
        this.f3532j = f3526o;
        this.h = cVar;
        this.f3529c = jsonFactory.f3529c;
        this.f3530d = jsonFactory.f3530d;
        this.f3531e = jsonFactory.f3531e;
        this.f3532j = jsonFactory.f3532j;
        this.f3533k = jsonFactory.f3533k;
    }
}
