package com.obric.capabilitykit.common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32058a = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TypeAdapter<T> f32059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Gson f32060b;

        public b(TypeAdapter<T> r1, Gson r2) {
            this.f32059a = r1;
            this.f32060b = r2;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r9) {
            d.h.b.o.e(r9, "input");
            JsonObject r10 = new JsonParser().parse(r9).getAsJsonObject();
            String r1 = r10.get("createTime").getAsString();
            String r3 = r10.get("lastModifiedTime").getAsString();
            SimpleDateFormat r4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Long r7 = null;
            if (r10.has("createTimeStamp") == false) goto L7;
            long r5 = r10.get("createTimeStamp").getAsLong();
        L5:
            Long r2 = Long.valueOf(r5);
        L6:
            r10.addProperty("createTime", r2);
            if (r10.has("lastModifiedTimeStamp") == false) goto L14;
            r10.addProperty("lastModifiedTime", Long.valueOf(r10.get("lastModifiedTimeStamp").getAsLong()));
        L19:
            return this.f32059a.fromJsonTree(r10);
        L14:
            Date r0 = r4.parse(r3);
            if (r0 == null) goto L17;
            r7 = Long.valueOf(r0.getTime());
        L17:
            r10.addProperty("lastModifiedTime", r7);
            goto L19
        L7:
            Date r6 = r4.parse(r1);
            if (r6 == null) goto L10;
            r5 = r6.getTime();
            goto L5
        L10:
            r2 = null;
            goto L6
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r8, T r9) {
            d.h.b.o.e(r8, "out");
            JsonObject r0 = this.f32059a.toJsonTree(r9).getAsJsonObject();
            d.h.b.o.a(r9, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AppEntity");
            AppEntity r10 = (AppEntity) ZeusTransformUtils.preCheckCast(r9, AppEntity.class, "com.obric.aiagent.plugin");
            long r1 = r10.getCreateTime();
            long r3 = r10.getLastModifiedTime();
            SimpleDateFormat r11 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            r0.addProperty("createTime", r11.format(new Date(r1)));
            r0.addProperty("createTimeStamp", Long.valueOf(r1));
            r0.addProperty("lastModifiedTime", r11.format(new Date(r3)));
            r0.addProperty("lastModifiedTimeStamp", Long.valueOf(r3));
            this.f32060b.toJson(r0, r8);
        }
    }

    static {
        f32058a = new a(null);
    }

    public k() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r2, TypeToken<T> r3) {
        d.h.b.o.e(r2, "gson");
        d.h.b.o.e(r3, "type");
        TypeAdapter<T> r1 = r2.getDelegateAdapter(this, r3);
        if (AppEntity.class.isAssignableFrom(r3.getRawType()) == true) goto L5;
        return null;
    L5:
        return new b(r1, r2).nullSafe();
    }
}
