package com.bytedance.android.live.browser.jsbridge.protobuf;

import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes45.dex */
public final class ExternalProtobufShrinkConfigs {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f63838b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Config> f63839a;

    public static final class Companion extends AbstractChanneledRepo<ExternalProtobufShrinkConfigs> {
        public Companion() {
            super("protobuf/shrink_config.json", "", AnonymousClass1.INSTANCE);
        }
    }

    public static final class Config {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f63840e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, a<?>> f63841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f63842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<String> f63843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Config> f63844d;

        public static final class Companion {
            public static Config a(String r100, JsonObject r101) {
                Intrinsics.checkNotNullParameter(r100, "name");
                Intrinsics.checkNotNullParameter(r101, "jsonObject");
                JsonElement r102 = r101.get("keep");
                if (r102 == null) goto L12;
                JsonArray r103 = r102.getAsJsonArray();
                if (r103 == null) goto L12;
                Sequence r104 = CollectionsKt.asSequence(r103);
                if (r104 == null) goto L12;
                Sequence r105 = SequencesKt.map(r104, ExternalProtobufShrinkConfigs$Config$Companion$fromJsonObject$1.INSTANCE);
                if (r105 == null) goto L12;
                Set r106 = SequencesKt.toSet(r105);
                if (r106 == null) goto L12;
            L13:
                JsonElement r107 = r101.get("children");
                if (r107 == null) goto L19;
                final JsonObject r108 = r107.getAsJsonObject();
                if (r108 == null) goto L19;
                Map r109 = MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(r108.keySet()), new ExternalProtobufShrinkConfigs$Config$Companion$$special$$inlined$shallowToMap$1(r108)));
                if (r109 == null) goto L19;
            L20:
                int r110 = a.f63845a;
                Intrinsics.checkNotNullParameter(r101, "jsonObject");
                a[] r111 = new a[4];
                JsonElement r112 = r101.get("length");
                a.d r113 = null;
                if (r112 == null) goto L23;
                a.b r114 = new a.b(r112.getAsInt());
            L24:
                r111[0] = r114;
                JsonElement r115 = r101.get("config");
                if (r115 == null) goto L29;
                String r116 = r115.getAsString();
                if (r116 == null) goto L29;
                a.e r117 = new a.e(r116);
            L30:
                r111[1] = r117;
                JsonElement r118 = r101.get("map_keys");
                if (r118 == null) goto L35;
                JsonObject r119 = r118.getAsJsonObject();
                if (r119 == null) goto L35;
                int r120 = Config.f63840e;
                a.c r121 = new a.c(a("__map_key", r119));
            L36:
                r111[2] = r121;
                JsonElement r122 = r101.get("map_values");
                if (r122 == null) goto L41;
                JsonObject r123 = r122.getAsJsonObject();
                if (r123 == null) goto L41;
                int r124 = Config.f63840e;
                r113 = new a.d(a("__map_value", r123));
            L41:
                r111[3] = r113;
                return new Config(r100, r106, r109, SequencesKt.toSet(SequencesKt.filterNotNull(SequencesKt.sequenceOf(r111))));
            L35:
                r121 = null;
            L29:
                r117 = null;
                goto L30
            L23:
                r114 = null;
            L19:
                r109 = MapsKt.emptyMap();
            L12:
                r106 = SetsKt.emptySet();
                goto L13
            }
        }

        static {
        }

        public Config(String r100, Set<String> r101, Map<String, Config> r102, Collection<? extends a<?>> r103) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "keeps");
            Intrinsics.checkNotNullParameter(r102, "children");
            Intrinsics.checkNotNullParameter(r103, "options");
            this.f63842b = r100;
            this.f63843c = r101;
            this.f63844d = r102;
            if (r103.isEmpty() == false) goto L5;
            Map<Class<?>, a<?>> r104 = MapsKt.emptyMap();
        L10:
            this.f63841a = r104;
            return;
        L5:
            Collection<? extends a<?>> r105 = r103;
            LinkedHashMap r106 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r105, 10)), 16));
            Iterator<T> r107 = r105.iterator();
        L7:
            if (r107.hasNext() == false) goto L9;
            Object r108 = r107.next();
            r106.put(((a) r108).getClass(), r108);
            goto L7
        L9:
            r104 = r106;
            goto L10
        }
    }

    public static abstract class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f63845a = 0;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufShrinkConfigs$a$a, reason: collision with other inner class name */
        public static final class C1047a {
        }

        public static final class b extends a<Integer> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f63846b;

            public b(int r100) {
                this.f63846b = r100;
            }
        }

        public static final class c extends a<Config> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Config f63847b;

            public c(Config r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                this.f63847b = r100;
            }
        }

        public static final class d extends a<Config> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Config f63848b;

            public d(Config r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                this.f63848b = r100;
            }
        }

        public static final class e extends a<String> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f63849b;

            public e(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                this.f63849b = r100;
            }
        }

        static {
        }

        public a() {
        }
    }

    static {
        f63838b = new Companion();
    }

    public ExternalProtobufShrinkConfigs(BufferedReader r100) {
        final JsonObject r101 = GsonHelper.parser().parse(r100).getAsJsonObject();
        Map<String, Config> r102 = MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(r101.keySet()), new ExternalProtobufShrinkConfigs$$special$$inlined$shallowToMap$1(r101)));
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<T> r104 = r102.values().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        a((Config) r104.next(), r102, r103, true);
        goto L4
    L6:
        this.f63839a = r103;
    }

    public final Config a(final Config r100, final Map<String, Config> r101, final Map<String, Config> r110, boolean r111) {
        Function1<Sequence<? extends Map.Entry<? extends String, ? extends Config>>, Sequence<? extends Pair<? extends String, ? extends Config>>> r102 = new ExternalProtobufShrinkConfigs$mergedConfigs$1(this, r101, r110);
        Function1<Sequence<? extends Map.Entry<? extends Class<?>, ? extends a<?>>>, Sequence<? extends a<?>>> r103 = new ExternalProtobufShrinkConfigs$mergedConfigs$2(this, r101, r110);
        a.e r104 = (a.e) r100.f63841a.get(a.e.class);
        if (r104 == null) goto L5;
        Config r105 = r110.get(r104.f63849b);
        if (r105 != null) goto L20;
        Config r106 = r101.get(r104.f63849b);
        if (r106 == null) goto L19;
        r105 = a(r106, r101, r110, true);
        goto L20
    L19:
        throw new IllegalArgumentException(("failed to find [" + r104.f63849b + ']').toString());
    L20:
        Config r107 = new Config(r100.f63842b, SetsKt.plus(r100.f63843c, r105.f63843c), MapsKt.toMap(r102.invoke2(SequencesKt.plus(MapsKt.asSequence(r100.f63844d), SequencesKt.filterNot(MapsKt.asSequence(r105.f63844d), new ExternalProtobufShrinkConfigs$mergedConfigs$children$1(r100))))), SequencesKt.toSet(r103.invoke2(SequencesKt.filterNot(CollectionsKt.asSequence(r105.f63841a.entrySet()), new ExternalProtobufShrinkConfigs$mergedConfigs$options$1(r100)))));
        if (r111 == false) goto L23;
        r110.put(r107.f63842b, r107);
    L23:
        return r107;
    L5:
        if (r100.f63844d.isEmpty() == true) goto L7;
    L9:
        r100 = new Config(r100.f63842b, r100.f63843c, MapsKt.toMap(r102.invoke2(MapsKt.asSequence(r100.f63844d))), SequencesKt.toSet(r103.invoke2(MapsKt.asSequence(r100.f63841a))));
    L10:
        if (r111 == false) goto L12;
        r110.put(r100.f63842b, r100);
    L12:
        return r100;
    L7:
        if (r100.f63841a.isEmpty() == false) goto L9;
        goto L9
    }
}
