package com.squareup.moshi.kotlin.reflect;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.internal.Util;
import d7.i;
import d7.t;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import m.x;
import q7.k;
import w7.g;
import w7.j;
import w7.m;
import w7.s;
import z7.u0;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002%&BW\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u001c\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0005\u0012\u001a\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR-\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R+\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b!\u0010 R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "Lw7/g;", "constructor", "", "Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "", "allBindings", "nonIgnoredBindings", "Lcom/squareup/moshi/JsonReader$Options;", "options", "<init>", "(Lw7/g;Ljava/util/List;Ljava/util/List;Lcom/squareup/moshi/JsonReader$Options;)V", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Ljava/lang/Object;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value", "Lc7/r;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Lw7/g;", "getConstructor", "()Lw7/g;", "Ljava/util/List;", "getAllBindings", "()Ljava/util/List;", "getNonIgnoredBindings", "Lcom/squareup/moshi/JsonReader$Options;", "getOptions", "()Lcom/squareup/moshi/JsonReader$Options;", "Binding", "IndexedParameterMap", "moshi-kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KotlinJsonAdapter<T> extends JsonAdapter<T> {
    private final List<Binding<T, Object>> allBindings;
    private final g constructor;
    private final List<Binding<T, Object>> nonIgnoredBindings;
    private final JsonReader.Options options;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u0003BC\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00028\u00022\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00028\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u001f\u0010 Jb\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00062\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b#\u0010\u0018J\u0010\u0010$\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b$\u0010 J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010\u0018R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010\u001aR#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010-\u001a\u0004\b.\u0010\u001cR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b0\u0010\u001eR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b2\u0010 ¨\u00063"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "K", "P", "", "", "jsonName", "Lcom/squareup/moshi/JsonAdapter;", "adapter", "Lw7/s;", "property", "Lw7/m;", "parameter", "", "propertyIndex", "<init>", "(Ljava/lang/String;Lcom/squareup/moshi/JsonAdapter;Lw7/s;Lw7/m;I)V", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "result", "Lc7/r;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/squareup/moshi/JsonAdapter;", "component3", "()Lw7/s;", "component4", "()Lw7/m;", "component5", "()I", "copy", "(Ljava/lang/String;Lcom/squareup/moshi/JsonAdapter;Lw7/s;Lw7/m;I)Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getJsonName", "Lcom/squareup/moshi/JsonAdapter;", "getAdapter", "Lw7/s;", "getProperty", "Lw7/m;", "getParameter", "I", "getPropertyIndex", "moshi-kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Binding<K, P> {
        private final JsonAdapter<P> adapter;
        private final String jsonName;
        private final m parameter;
        private final s property;
        private final int propertyIndex;

        public Binding(String str, JsonAdapter<P> jsonAdapter, s sVar, m mVar, int i2) {
            k.e(str, "jsonName");
            k.e(jsonAdapter, "adapter");
            k.e(sVar, "property");
            this.jsonName = str;
            this.adapter = jsonAdapter;
            this.property = sVar;
            this.parameter = mVar;
            this.propertyIndex = i2;
        }

        public static /* synthetic */ Binding copy$default(Binding binding, String str, JsonAdapter jsonAdapter, s sVar, m mVar, int i2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = binding.jsonName;
            }
            if ((i10 & 2) != 0) {
                jsonAdapter = binding.adapter;
            }
            if ((i10 & 4) != 0) {
                sVar = binding.property;
            }
            if ((i10 & 8) != 0) {
                mVar = binding.parameter;
            }
            if ((i10 & 16) != 0) {
                i2 = binding.propertyIndex;
            }
            int i11 = i2;
            s sVar2 = sVar;
            return binding.copy(str, jsonAdapter, sVar2, mVar, i11);
        }

        /* renamed from: component1, reason: from getter */
        public final String getJsonName() {
            return this.jsonName;
        }

        public final JsonAdapter<P> component2() {
            return this.adapter;
        }

        /* renamed from: component3, reason: from getter */
        public final s getProperty() {
            return this.property;
        }

        /* renamed from: component4, reason: from getter */
        public final m getParameter() {
            return this.parameter;
        }

        /* renamed from: component5, reason: from getter */
        public final int getPropertyIndex() {
            return this.propertyIndex;
        }

        public final Binding<K, P> copy(String jsonName, JsonAdapter<P> adapter, s property, m parameter, int propertyIndex) {
            k.e(jsonName, "jsonName");
            k.e(adapter, "adapter");
            k.e(property, "property");
            return new Binding<>(jsonName, adapter, property, parameter, propertyIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Binding)) {
                return false;
            }
            Binding binding = (Binding) other;
            return k.a(this.jsonName, binding.jsonName) && k.a(this.adapter, binding.adapter) && k.a(this.property, binding.property) && k.a(this.parameter, binding.parameter) && this.propertyIndex == binding.propertyIndex;
        }

        public final P get(K value) {
            return (P) this.property.get(value);
        }

        public final JsonAdapter<P> getAdapter() {
            return this.adapter;
        }

        public final String getJsonName() {
            return this.jsonName;
        }

        public final m getParameter() {
            return this.parameter;
        }

        public final s getProperty() {
            return this.property;
        }

        public final int getPropertyIndex() {
            return this.propertyIndex;
        }

        public int hashCode() {
            int iHashCode = (this.property.hashCode() + ((this.adapter.hashCode() + (this.jsonName.hashCode() * 31)) * 31)) * 31;
            m mVar = this.parameter;
            return Integer.hashCode(this.propertyIndex) + ((iHashCode + (mVar == null ? 0 : mVar.hashCode())) * 31);
        }

        public final void set(K result, P value) {
            if (value != KotlinJsonAdapterKt.ABSENT_VALUE) {
                s sVar = this.property;
                k.c(sVar, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty1<K of com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding, P of com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding>");
                ((j) sVar).e(result, value);
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Binding(jsonName=");
            sb2.append(this.jsonName);
            sb2.append(", adapter=");
            sb2.append(this.adapter);
            sb2.append(", property=");
            sb2.append(this.property);
            sb2.append(", parameter=");
            sb2.append(this.parameter);
            sb2.append(", propertyIndex=");
            return x.m(sb2, this.propertyIndex, ')');
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B%\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R(\u0010\u0019\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$IndexedParameterMap;", "Ld7/i;", "Lw7/m;", "", "", "parameterKeys", "", "parameterValues", "<init>", "(Ljava/util/List;[Ljava/lang/Object;)V", "key", "value", "put", "(Lw7/m;Ljava/lang/Object;)Ljava/lang/Object;", "", "containsKey", "(Lw7/m;)Z", "get", "(Lw7/m;)Ljava/lang/Object;", "Ljava/util/List;", "[Ljava/lang/Object;", "", "", "getEntries", "()Ljava/util/Set;", "entries", "moshi-kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class IndexedParameterMap extends i {
        private final List<m> parameterKeys;
        private final Object[] parameterValues;

        /* JADX WARN: Multi-variable type inference failed */
        public IndexedParameterMap(List<? extends m> list, Object[] objArr) {
            k.e(list, "parameterKeys");
            k.e(objArr, "parameterValues");
            this.parameterKeys = list;
            this.parameterValues = objArr;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof m) {
                return containsKey((m) obj);
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof m) {
                return get((m) obj);
            }
            return null;
        }

        @Override // d7.i
        public Set<Map.Entry<m, Object>> getEntries() {
            List<m> list = this.parameterKeys;
            ArrayList arrayList = new ArrayList(t.A0(list, 10));
            int i2 = 0;
            for (T t2 : list) {
                int i10 = i2 + 1;
                if (i2 < 0) {
                    d7.s.z0();
                    throw null;
                }
                arrayList.add(new AbstractMap.SimpleEntry((m) t2, this.parameterValues[i2]));
                i2 = i10;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t10 : arrayList) {
                if (((AbstractMap.SimpleEntry) t10).getValue() != KotlinJsonAdapterKt.ABSENT_VALUE) {
                    linkedHashSet.add(t10);
                }
            }
            return linkedHashSet;
        }

        @Override // java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof m) ? obj2 : getOrDefault((m) obj, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(m key, Object value) {
            k.e(key, "key");
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof m) {
                return remove((m) obj);
            }
            return null;
        }

        public boolean containsKey(m key) {
            k.e(key, "key");
            return this.parameterValues[((u0) key).f11963g] != KotlinJsonAdapterKt.ABSENT_VALUE;
        }

        public Object get(m key) {
            k.e(key, "key");
            Object obj = this.parameterValues[((u0) key).f11963g];
            if (obj != KotlinJsonAdapterKt.ABSENT_VALUE) {
                return obj;
            }
            return null;
        }

        public /* bridge */ Object getOrDefault(m mVar, Object obj) {
            return super.getOrDefault((Object) mVar, (m) obj);
        }

        public /* bridge */ Object remove(m mVar) {
            return super.remove((Object) mVar);
        }

        @Override // java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if (obj instanceof m) {
                return remove((m) obj, obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(m mVar, Object obj) {
            return super.remove((Object) mVar, obj);
        }
    }

    public KotlinJsonAdapter(g gVar, List<Binding<T, Object>> list, List<Binding<T, Object>> list2, JsonReader.Options options) {
        k.e(gVar, "constructor");
        k.e(list, "allBindings");
        k.e(list2, "nonIgnoredBindings");
        k.e(options, "options");
        this.constructor = gVar;
        this.allBindings = list;
        this.nonIgnoredBindings = list2;
        this.options = options;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public T fromJson(JsonReader reader) {
        k.e(reader, "reader");
        int size = this.constructor.getParameters().size();
        int size2 = this.allBindings.size();
        Object[] objArr = new Object[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            objArr[i2] = KotlinJsonAdapterKt.ABSENT_VALUE;
        }
        reader.beginObject();
        while (reader.hasNext()) {
            int iSelectName = reader.selectName(this.options);
            if (iSelectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else {
                Binding<T, Object> binding = this.nonIgnoredBindings.get(iSelectName);
                int propertyIndex = binding.getPropertyIndex();
                if (objArr[propertyIndex] != KotlinJsonAdapterKt.ABSENT_VALUE) {
                    throw new JsonDataException("Multiple values for '" + binding.getProperty().getName() + "' at " + reader.getPath());
                }
                Object objFromJson = binding.getAdapter().fromJson(reader);
                objArr[propertyIndex] = objFromJson;
                if (objFromJson == null && !binding.getProperty().f().p()) {
                    JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull(binding.getProperty().getName(), binding.getJsonName(), reader);
                    k.d(jsonDataExceptionUnexpectedNull, "unexpectedNull(\n        …         reader\n        )");
                    throw jsonDataExceptionUnexpectedNull;
                }
            }
        }
        reader.endObject();
        boolean z4 = this.allBindings.size() == size;
        for (int i10 = 0; i10 < size; i10++) {
            if (objArr[i10] == KotlinJsonAdapterKt.ABSENT_VALUE) {
                if (((u0) ((m) this.constructor.getParameters().get(i10))).j()) {
                    z4 = false;
                } else {
                    if (!((u0) ((m) this.constructor.getParameters().get(i10))).c().f11908f.F0()) {
                        String name = ((u0) ((m) this.constructor.getParameters().get(i10))).getName();
                        Binding<T, Object> binding2 = this.allBindings.get(i10);
                        JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty(name, binding2 != null ? binding2.getJsonName() : null, reader);
                        k.d(jsonDataExceptionMissingProperty, "missingProperty(\n       …       reader\n          )");
                        throw jsonDataExceptionMissingProperty;
                    }
                    objArr[i10] = null;
                }
            }
        }
        T t2 = z4 ? (T) this.constructor.h(Arrays.copyOf(objArr, size2)) : (T) this.constructor.n(new IndexedParameterMap(this.constructor.getParameters(), objArr));
        int size3 = this.allBindings.size();
        while (size < size3) {
            Binding<T, Object> binding3 = this.allBindings.get(size);
            k.b(binding3);
            binding3.set(t2, objArr[size]);
            size++;
        }
        return t2;
    }

    public final List<Binding<T, Object>> getAllBindings() {
        return this.allBindings;
    }

    public final g getConstructor() {
        return this.constructor;
    }

    public final List<Binding<T, Object>> getNonIgnoredBindings() {
        return this.nonIgnoredBindings;
    }

    public final JsonReader.Options getOptions() {
        return this.options;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, T value) {
        k.e(writer, "writer");
        if (value == null) {
            throw new NullPointerException("value == null");
        }
        writer.beginObject();
        for (Binding<T, Object> binding : this.allBindings) {
            if (binding != null) {
                writer.name(binding.getJsonName());
                binding.getAdapter().toJson(writer, (JsonWriter) binding.get(value));
            }
        }
        writer.endObject();
    }

    public String toString() {
        return "KotlinJsonAdapter(" + this.constructor.f() + ')';
    }
}
