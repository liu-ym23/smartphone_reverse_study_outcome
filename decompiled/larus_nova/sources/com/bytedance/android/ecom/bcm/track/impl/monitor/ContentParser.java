package com.bytedance.android.ecom.bcm.track.impl.monitor;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public interface ContentParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f51090a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Lazy f51091a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f51092b = null;

        public Companion() {
        }

        static {
            f51092b = new Companion();
            f51091a = LazyKt.lazy(ContentParser$Companion$parser$2.INSTANCE);
        }
    }

    public static final class Form implements ContentParser {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Form f51093b = null;

        public Form() {
        }

        static {
            f51093b = new Form();
        }

        public static JsonObject d(String r100) {
            JsonObject r101 = new JsonObject();
            Iterator r102 = SequencesKt.map(CollectionsKt.asSequence(StringsKt.split$default(r100, new String[]{"&"}, false, 0, 6, null)), ContentParser$Form$process$1.INSTANCE).iterator();
        L4:
            if (r102.hasNext() == false) goto L13;
            List r103 = (List) r102.next();
            String r104 = (String) CollectionsKt.getOrNull(r103, 1);
            if (r104 == null) goto L4;
            String r105 = URLDecoder.decode(r104, "UTF-8");
            if (r105 == null) goto L4;
            String r106 = (String) ListProtector.get(r103, 0);
            ContentParser.f51090a.getClass();     // Catch: Exception -> L12
            r101.add(r106, ((JsonParser) Companion.f51091a.getValue()).parse(r105));     // Catch: Exception -> L12
        L12:
            r101.addProperty(r106, r105);
            goto L4
        L13:
            return r101;
        }

        @Override // com.bytedance.android.ecom.bcm.track.impl.monitor.ContentParser
        public final boolean a(String r100) {
            return StringsKt.contains$default(r100, "application/x-www-form-urlencoded", false, 2, null);
        }

        public final /* bridge */ /* synthetic */ JsonElement c(String r100) {
            return d(r100);
        }

        @Override // com.bytedance.android.ecom.bcm.track.impl.monitor.ContentParser
        public final JsonElement b(TypedOutput r100, String r101) {
            ByteArrayOutputStream r102 = new ByteArrayOutputStream();
            r100.writeTo(r102);
            return c(r102.toString(r101));
        }
    }

    public static final class a implements ContentParser {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f51094b = null;

        public a() {
        }

        static {
            f51094b = new a();
        }

        @Override // com.bytedance.android.ecom.bcm.track.impl.monitor.ContentParser
        public final boolean a(String r100) {
            return StringsKt.contains$default(r100, "application/json", false, 2, null);
        }

        public final JsonElement c(String r100) {
            ContentParser.f51090a.getClass();
            return GsonProtectorUtils.parse((JsonParser) Companion.f51091a.getValue(), r100);
        }

        @Override // com.bytedance.android.ecom.bcm.track.impl.monitor.ContentParser
        public final JsonElement b(TypedOutput r100, String r101) {
            ByteArrayOutputStream r102 = new ByteArrayOutputStream();
            r100.writeTo(r102);
            return c(r102.toString(r101));
        }
    }

    static {
        f51090a = Companion.f51092b;
    }

    boolean a(String r100);

    JsonElement b(TypedOutput r100, String r101);
}
