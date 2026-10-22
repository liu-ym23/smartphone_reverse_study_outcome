package com.obric.capabilitykit.entity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ExtraTypeAdapterFactory implements TypeAdapterFactory {
    public static final a Companion = null;
    private static final String KEY = "key";
    private static final String KEY_DATA_TYPE = "data_type";
    private static final String VALUE = "value";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    public static final class b<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Gson f32087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TypeAdapter<T> f32088b;

        public static final class a extends TypeToken<List<? extends JsonElement>> {
            public a() {
            }
        }

        public b(Gson r2, TypeAdapter<T> r3) {
            o.e(r2, "gson");
            o.e(r3, "delegate");
            this.f32087a = r2;
            this.f32088b = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v8, types: [java.util.ArrayList, java.util.Collection] */
        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r10) {
            o.e(r10, "in");
            JsonObject r11 = new JsonParser().parse(r10).getAsJsonObject();
            JsonElement r1 = r11.get(ExtraTypeAdapterFactory.VALUE);
            r11.add(ExtraTypeAdapterFactory.VALUE, null);
            T r12 = this.f32088b.fromJsonTree(r11);
            if (ZeusTransformUtils.instanceOf(r12, ExtraEntity.class) == true) goto L5;
        L14:
            return r12;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, JsonObject.class) == false) goto L14;
            JsonObject r2 = (JsonObject) ZeusTransformUtils.preCheckCast(r1, JsonObject.class, "com.obric.aiagent.plugin");
            String r4 = r2.get(ExtraTypeAdapterFactory.KEY_DATA_TYPE).getAsString();
            JsonElement r3 = r2.get(ExtraTypeAdapterFactory.VALUE);
            ExtraEntity r5 = (ExtraEntity) ZeusTransformUtils.preCheckCast(r12, ExtraEntity.class, "com.obric.aiagent.plugin");
            if (List.class.isAssignableFrom(ZeusTransformUtils.forName(r4, "com.obric.aiagent.plugin")) == false) goto L12;
            Type r6 = new a().getType();
            List r7 = (List) ZeusTransformUtils.preCheckCast(this.f32087a.fromJson(r3, r6), List.class, "com.obric.aiagent.plugin");
            o.c(r7, "jsonList");
            Object r8 = new ArrayList(p.a(r7, 10));
            Iterator<T> r9 = r7.iterator();
        L10:
            if (r9.hasNext() == false) goto L13;
            JsonElement r13 = (JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.aiagent.plugin");
            String r14 = r13.getAsJsonObject().get(ExtraTypeAdapterFactory.KEY_DATA_TYPE).getAsString();
            r8.add(this.f32087a.fromJson(r13.getAsJsonObject().get(ExtraTypeAdapterFactory.VALUE), ZeusTransformUtils.forName(r14, "com.obric.aiagent.plugin")));
        L13:
            r5.setValue(r8);
            goto L14
        L12:
            r8 = this.f32087a.fromJson(r3, ZeusTransformUtils.forName(r4, "com.obric.aiagent.plugin"));
            goto L13
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r10, T r11) {
            o.e(r10, "out");
            JsonObject r0 = this.f32088b.toJsonTree(r11).getAsJsonObject();
            if (ZeusTransformUtils.instanceOf(r11, ExtraEntity.class) == false) goto L21;
            ExtraEntity r12 = (ExtraEntity) ZeusTransformUtils.preCheckCast(r11, ExtraEntity.class, "com.obric.aiagent.plugin");
            if (r12.getValue() == null) goto L21;
            JsonObject r1 = new JsonObject();
            Object r4 = r12.getValue();
            o.a(r4);
            r1.add(ExtraTypeAdapterFactory.KEY_DATA_TYPE, new JsonPrimitive(r4.getClass().getName()));
            if (ZeusTransformUtils.instanceOf(r12.getValue(), List.class) == false) goto L19;
            JsonArray r3 = new JsonArray();
            Object r13 = r12.getValue();
            o.a(r13, "null cannot be cast to non-null type kotlin.collections.List<*>");
            Iterator<T> r14 = ((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin")).iterator();
        L10:
            if (r14.hasNext() == false) goto L18;
            T r2 = r14.next();
            JsonObject r6 = new JsonObject();
            if (r2 == null) goto L16;
            Class<?> r8 = r2.getClass();
            if (r8 == null) goto L16;
            String r9 = r8.getName();
        L17:
            r6.add(ExtraTypeAdapterFactory.KEY_DATA_TYPE, new JsonPrimitive(r9));
            r6.add(ExtraTypeAdapterFactory.VALUE, this.f32087a.toJsonTree(r2));
            r3.add(r6);
        L16:
            r9 = null;
            goto L17
        L18:
            r1.add(ExtraTypeAdapterFactory.VALUE, r3);
        L20:
            r0.add(ExtraTypeAdapterFactory.VALUE, r1);
            goto L21
        L19:
            r1.add(ExtraTypeAdapterFactory.VALUE, this.f32087a.toJsonTree(r12.getValue()));
        L21:
            this.f32087a.toJson(r0, r10);
        }
    }

    static {
        Companion = new a(null);
    }

    public ExtraTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r3, TypeToken<T> r4) {
        o.e(r3, "gson");
        o.e(r4, "type");
        if (o.a(r4.getRawType(), ExtraEntity.class) == false) goto L5;
        TypeAdapter<T> r2 = r3.getDelegateAdapter(this, r4);
        o.c(r2, "delegate");
        return new b(r3, r2);
    L5:
        return null;
    }
}
