package com.obric.capabilitykit.entity;

import androidx.annotation.Keep;
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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.u;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "Companion", "ExtraEntityTypeAdapter", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExtraTypeAdapterFactory implements TypeAdapterFactory {

    @NotNull
    public static final a Companion = null;

    @NotNull
    private static final String KEY = "key";

    @NotNull
    private static final String KEY_DATA_TYPE = "data_type";

    @NotNull
    private static final String VALUE = "value";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b extends TypeAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Gson f11319c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TypeAdapter f11320d;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/entity/ExtraTypeAdapterFactory$ExtraEntityTypeAdapter$read$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/google/gson/JsonElement;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<List<? extends JsonElement>> {
            public a() {
            }
        }

        public b(Gson r10, TypeAdapter r11) {
            q.g(r10, "gson");
            q.g(r11, "delegate");
            this.f11319c = r10;
            this.f11320d = r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList, java.util.Collection] */
        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader r10) {
            q.g(r10, "in");
            JsonObject r11 = new JsonParser().parse(r10).getAsJsonObject();
            JsonElement r12 = r11.get("value");
            r11.add("value", null);
            Object r13 = this.f11320d.fromJsonTree(r11);
            if ((r13 instanceof ExtraEntity) == true) goto L5;
        L14:
            return r13;
        L5:
            if ((r12 instanceof JsonObject) == false) goto L14;
            JsonObject r14 = (JsonObject) r12;
            String r15 = r14.get(ExtraTypeAdapterFactory.KEY_DATA_TYPE).getAsString();
            JsonElement r16 = r14.get("value");
            ExtraEntity r17 = (ExtraEntity) r13;
            if (List.class.isAssignableFrom(Class.forName(r15)) == false) goto L12;
            Type r18 = new a().getType();
            List r19 = (List) this.f11319c.fromJson(r16, r18);
            q.f(r19, "jsonList");
            Object r20 = new ArrayList(u.r(r19, 10));
            Iterator r21 = r19.iterator();
        L10:
            if (r21.hasNext() == false) goto L13;
            JsonElement r22 = (JsonElement) r21.next();
            String r23 = r22.getAsJsonObject().get(ExtraTypeAdapterFactory.KEY_DATA_TYPE).getAsString();
            r20.add(this.f11319c.fromJson(r22.getAsJsonObject().get("value"), Class.forName(r23)));
        L13:
            r17.setValue(r20);
            goto L14
        L12:
            r20 = this.f11319c.fromJson(r16, Class.forName(r15));
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
        public void write(JsonWriter r10, Object r11) {
            q.g(r10, "out");
            JsonObject r12 = this.f11320d.toJsonTree(r11).getAsJsonObject();
            if ((r11 instanceof ExtraEntity) == false) goto L19;
            ExtraEntity r13 = (ExtraEntity) r11;
            if (r13.getValue() == null) goto L19;
            JsonObject r14 = new JsonObject();
            Object r15 = r13.getValue();
            q.d(r15);
            r14.add(ExtraTypeAdapterFactory.KEY_DATA_TYPE, new JsonPrimitive(r15.getClass().getName()));
            if ((r13.getValue() instanceof List) == false) goto L17;
            JsonArray r16 = new JsonArray();
            Object r17 = r13.getValue();
            q.e(r17, "null cannot be cast to non-null type kotlin.collections.List<*>");
            Iterator r18 = ((List) r17).iterator();
        L10:
            if (r18.hasNext() == false) goto L16;
            Object r19 = r18.next();
            JsonObject r20 = new JsonObject();
            if (r19 == null) goto L14;
            String r21 = r19.getClass().getName();
        L15:
            r20.add(ExtraTypeAdapterFactory.KEY_DATA_TYPE, new JsonPrimitive(r21));
            r20.add("value", this.f11319c.toJsonTree(r19));
            r16.add(r20);
            goto L10
        L14:
            r21 = null;
            goto L15
        L16:
            r14.add("value", r16);
        L18:
            r12.add("value", r14);
            goto L19
        L17:
            r14.add("value", this.f11319c.toJsonTree(r13.getValue()));
        L19:
            this.f11319c.toJson(r12, r10);
        }
    }

    static {
        Companion = new a(null);
    }

    public ExtraTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    @Nullable
    public <T> TypeAdapter<T> create(@NotNull Gson r10, @NotNull TypeToken<T> r11) {
        q.g(r10, "gson");
        q.g(r11, "type");
        if (q.b(r11.getRawType(), ExtraEntity.class) == false) goto L5;
        TypeAdapter<T> r12 = r10.getDelegateAdapter(this, r11);
        q.f(r12, "delegate");
        return new b(r10, r12);
    L5:
        return null;
    }
}
