package com.bytedance.android.annie.protobuf;

import android.util.SparseArray;
import com.amap.api.col.s.ce;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ExternalProtobufMessageDefinitions {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f39738b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Message> f39739a;

    public static final class Companion extends AbstractChanneledRepo<ExternalProtobufMessageDefinitions> {
        public Companion() {
            super("protobuf/definitions.json", "protobuf/definitions_v2.json", AnonymousClass1.INSTANCE);
        }
    }

    public static final class Message {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f39740a;

        public Message() {
            throw null;
        }

        public Message(String r110, final JsonObject r111) {
            Intrinsics.checkNotNullParameter(r110, "fqName");
            Intrinsics.checkNotNullParameter(r111, "jsonObject");
            SparseArray<a> r100 = new SparseArray(r111.size());
            Iterator r112 = SequencesKt.map(CollectionsKt.asSequence(r111.keySet()), new ExternalProtobufMessageDefinitions$Message$1$1(r111)).iterator();
        L4:
            if (r112.hasNext() == false) goto L25;
            Pair r101 = (Pair) r112.next();
            String r102 = (String) r101.component1();
            JsonObject r103 = (JsonObject) r101.component2();
            int r104 = a.f39741g;
            Intrinsics.checkNotNullParameter(r102, "name");
            Intrinsics.checkNotNullParameter(r103, "jsonObject");
            int r105 = r103.get(RXScreenCaptureService.KEY_INDEX).getAsInt();
            int r106 = r103.get("t").getAsInt();
            JsonElement r107 = r103.get("r");
            if (r107 == null) goto L8;
            boolean r108 = r107.getAsBoolean();
        L9:
            Pair r109 = null;
            if (r106 != 20) goto L12;
            String r113 = r103.get("fq").getAsString();
        L24:
            a r114 = new a(r102, r105, r106, r108, r113, r109);
            r100.put(r114.f39743b, r114);
            goto L4
        L12:
            if (r106 == 21) goto L14;
            r113 = null;
            goto L24
        L14:
            JsonObject r115 = r103.get(ce.f26396k).getAsJsonObject();
            int r116 = r115.get("t").getAsInt();
            JsonElement r117 = r115.get("fq");
            if (r117 == null) goto L17;
            String r118 = r117.getAsString();
        L18:
            a.b r119 = new a.b(r116, r118);
            JsonObject r120 = r103.get(BaseSwitches.V).getAsJsonObject();
            int r121 = r120.get("t").getAsInt();
            JsonElement r122 = r120.get("fq");
            if (r122 == null) goto L21;
            String r123 = r122.getAsString();
        L22:
            r113 = null;
            r109 = new Pair(r119, new a.c(r121, r123));
            goto L24
        L21:
            r123 = null;
            goto L22
        L17:
            r118 = null;
            goto L18
        L8:
            r108 = false;
            goto L9
        L25:
            Unit r124 = Unit.INSTANCE;
            this.f39740a = r100;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f39741g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f39743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f39744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f39745d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f39746e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Pair<b, c> f39747f;

        /* JADX INFO: renamed from: com.bytedance.android.annie.protobuf.ExternalProtobufMessageDefinitions$a$a, reason: collision with other inner class name */
        public static final class C0740a {
        }

        public static final class b extends a {
            public b(int r100, String r101) {
                super("_map_key", 1, r100, r101);
            }
        }

        public static final class c extends a {
            public c(int r100, String r101) {
                super("_map_value", 2, r100, r101);
            }
        }

        static {
        }

        public final int getType() {
            return this.f39744c;
        }

        public /* synthetic */ a(String r100, int r101, int r110, String r111) {
            this(r100, r101, r110, false, r111, null);
        }

        public a(String r100, int r101, int r102, boolean r103, String r104, Pair<b, c> r105) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f39742a = r100;
            this.f39743b = r101;
            this.f39744c = r102;
            this.f39745d = r103;
            this.f39746e = r104;
            this.f39747f = r105;
        }
    }

    static {
        f39738b = new Companion();
    }

    public final Message a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        return this.f39739a.get(r100);
    }

    public ExternalProtobufMessageDefinitions(String r100, final JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "defJson");
        this.f39739a = MapsKt.toMutableMap(MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(r101.keySet()), new ExternalProtobufMessageDefinitions$special$$inlined$shallowToMap$1(r101))));
    }
}
