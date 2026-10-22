package com.obric.capabilitykit.common;

import com.bytedance.apm.constant.CommonKey;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "T", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "type", "Lcom/google/gson/TypeAdapter;", "create", "(Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f11276a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f11277b = "yyyy-MM-dd HH:mm:ss";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String f11278c = "createTime";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f11279d = "lastModifiedTime";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f11280e = "createTimeStamp";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f11281f = "lastModifiedTimeStamp";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityTypeAdapterFactory$Companion;", "", "()V", "KEY_CREATE_TIME", "", "KEY_CREATE_TIME_STAMP", "KEY_LAST_MODIFIED_TIME", "KEY_LAST_MODIFIED_TIME_STAMP", "TIME_FORMAT", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/obric/capabilitykit/entity/EntityTypeAdapterFactory$create$1", "Lcom/google/gson/TypeAdapter;", "read", "input", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", CommonKey.KEY_VALUE, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TypeAdapter<T> f11282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Gson f11283b;

        public b(TypeAdapter<T> r10, Gson r11) {
            this.f11282a = r10;
            this.f11283b = r11;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(@NotNull JsonReader r10) {
            kotlin.jvm.internal.q.g(r10, "input");
            JsonObject r11 = new JsonParser().parse(r10).getAsJsonObject();
            String r12 = r11.get(g.f11278c).getAsString();
            String r13 = r11.get(g.f11279d).getAsString();
            SimpleDateFormat r14 = new SimpleDateFormat(g.f11277b, Locale.getDefault());
            Long r15 = null;
            if (r11.has(g.f11280e) == false) goto L7;
            long r16 = r11.get(g.f11280e).getAsLong();
        L5:
            Long r17 = Long.valueOf(r16);
        L6:
            r11.addProperty(g.f11278c, r17);
            if (r11.has(g.f11281f) == false) goto L14;
            r11.addProperty(g.f11279d, Long.valueOf(r11.get(g.f11281f).getAsLong()));
        L19:
            return this.f11282a.fromJsonTree(r11);
        L14:
            Date r18 = r14.parse(r13);
            if (r18 == null) goto L17;
            r15 = Long.valueOf(r18.getTime());
        L17:
            r11.addProperty(g.f11279d, r15);
            goto L19
        L7:
            Date r19 = r14.parse(r12);
            if (r19 == null) goto L10;
            r16 = r19.getTime();
            goto L5
        L10:
            r17 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        public void write(@NotNull JsonWriter r10, T r11) {
            kotlin.jvm.internal.q.g(r10, "out");
            JsonObject r12 = this.f11282a.toJsonTree(r11).getAsJsonObject();
            kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AppEntity");
            AppEntity r13 = (AppEntity) r11;
            long r14 = r13.getCreateTime();
            long r15 = r13.getLastModifiedTime();
            SimpleDateFormat r16 = new SimpleDateFormat(g.f11277b, Locale.getDefault());
            r12.addProperty(g.f11278c, r16.format(new Date(r14)));
            r12.addProperty(g.f11280e, Long.valueOf(r14));
            r12.addProperty(g.f11279d, r16.format(new Date(r15)));
            r12.addProperty(g.f11281f, Long.valueOf(r15));
            this.f11283b.toJson(r12, r10);
        }
    }

    static {
        f11276a = new a(null);
    }

    public g() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    @Nullable
    public <T> TypeAdapter<T> create(@NotNull Gson r10, @NotNull TypeToken<T> r11) {
        kotlin.jvm.internal.q.g(r10, "gson");
        kotlin.jvm.internal.q.g(r11, "type");
        TypeAdapter<T> r12 = r10.getDelegateAdapter(this, r11);
        if (AppEntity.class.isAssignableFrom(r11.getRawType()) == true) goto L5;
        return null;
    L5:
        return new b(r12, r10).nullSafe();
    }
}
