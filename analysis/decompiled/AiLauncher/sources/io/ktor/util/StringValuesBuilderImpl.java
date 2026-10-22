package io.ktor.util;

import Y8.t;
import Z8.A;
import Z8.F;
import Z8.Y;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00180\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u0015J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010\"\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#J%\u0010\"\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0%H\u0016¢\u0006\u0004\b\"\u0010'J%\u0010$\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0%H\u0016¢\u0006\u0004\b$\u0010'J\u0017\u0010(\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u001aH\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010(\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010,\u001a\u00020\u001aH\u0016¢\u0006\u0004\b,\u0010+J\u000f\u0010-\u001a\u00020 H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b/\u0010)J\u0017\u00100\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\bH\u0014¢\u0006\u0004\b0\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u0017R,\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b&\u00104\u001a\u0004\b5\u00106¨\u00067"}, d2 = {"Lio/ktor/util/StringValuesBuilderImpl;", "Lio/ktor/util/StringValuesBuilder;", "", "caseInsensitiveName", "", ContentDisposition.Parameters.Size, "<init>", "(ZI)V", "", "name", "", "ensureListForKey", "(Ljava/lang/String;)Ljava/util/List;", "", "getAll", "contains", "(Ljava/lang/String;)Z", UxipConstants.f30680s, "(Ljava/lang/String;Ljava/lang/String;)Z", "", "names", "()Ljava/util/Set;", "isEmpty", "()Z", "", "entries", "LY8/t;", "set", "(Ljava/lang/String;Ljava/lang/String;)V", "get", "(Ljava/lang/String;)Ljava/lang/String;", "append", "Lio/ktor/util/StringValues;", "stringValues", "appendAll", "(Lio/ktor/util/StringValues;)V", "appendMissing", "", "values", "(Ljava/lang/String;Ljava/lang/Iterable;)V", "remove", "(Ljava/lang/String;)V", "removeKeysWithNoEntries", "()V", "clear", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lio/ktor/util/StringValues;", "validateName", "validateValue", "Z", "getCaseInsensitiveName", "", "Ljava/util/Map;", "getValues", "()Ljava/util/Map;", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StringValuesBuilderImpl implements StringValuesBuilder {
    private final boolean caseInsensitiveName;
    private final Map<String, List<String>> values;

    /* JADX WARN: Multi-variable type inference failed */
    public StringValuesBuilderImpl() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t appendAll$lambda$0(StringValuesBuilderImpl stringValuesBuilderImpl, String name, List values) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(values, "values");
        stringValuesBuilderImpl.appendAll(name, values);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t appendMissing$lambda$1(StringValuesBuilderImpl stringValuesBuilderImpl, String name, List values) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(values, "values");
        stringValuesBuilderImpl.appendMissing(name, values);
        return t.f7040a;
    }

    private final List<String> ensureListForKey(String name) {
        List<String> list = this.values.get(name);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        validateName(name);
        this.values.put(name, arrayList);
        return arrayList;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void append(String name, String value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        validateValue(value);
        ensureListForKey(name).add(value);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(StringValues stringValues) {
        kotlin.jvm.internal.p.i(stringValues, "stringValues");
        stringValues.forEach(new p9.p() { // from class: io.ktor.util.o
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return StringValuesBuilderImpl.appendAll$lambda$0(this.f33507a, (String) obj, (List) obj2);
            }
        });
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(StringValues stringValues) {
        kotlin.jvm.internal.p.i(stringValues, "stringValues");
        stringValues.forEach(new p9.p() { // from class: io.ktor.util.n
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return StringValuesBuilderImpl.appendMissing$lambda$1(this.f33506a, (String) obj, (List) obj2);
            }
        });
    }

    @Override // io.ktor.util.StringValuesBuilder
    public StringValues build() {
        return new StringValues(this.caseInsensitiveName, this.values);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void clear() {
        this.values.clear();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return this.values.containsKey(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<Map.Entry<String, List<String>>> entries() {
        return CollectionsJvmKt.unmodifiable(this.values.entrySet());
    }

    @Override // io.ktor.util.StringValuesBuilder
    public String get(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        List<String> all = getAll(name);
        if (all != null) {
            return (String) F.s0(all);
        }
        return null;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public List<String> getAll(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return this.values.get(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public final Map<String, List<String>> getValues() {
        return this.values;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<String> names() {
        return this.values.keySet();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void remove(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        this.values.remove(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void removeKeysWithNoEntries() {
        Map<String, List<String>> map = this.values;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            remove((String) ((Map.Entry) it.next()).getKey());
        }
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void set(String name, String value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        validateValue(value);
        List<String> listEnsureListForKey = ensureListForKey(name);
        listEnsureListForKey.clear();
        listEnsureListForKey.add(value);
    }

    public void validateName(String name) {
        kotlin.jvm.internal.p.i(name, "name");
    }

    public void validateValue(String value) {
        kotlin.jvm.internal.p.i(value, "value");
    }

    public StringValuesBuilderImpl(boolean z10, int i10) {
        this.caseInsensitiveName = z10;
        this.values = z10 ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap<>(i10);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(String name, Iterable<String> values) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(values, "values");
        List<String> listEnsureListForKey = ensureListForKey(name);
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            validateValue(it.next());
        }
        A.E(listEnsureListForKey, values);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(String name, Iterable<String> values) {
        Set setE;
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(values, "values");
        List<String> list = this.values.get(name);
        if (list == null || (setE = F.r1(list)) == null) {
            setE = Y.e();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : values) {
            if (!setE.contains(str)) {
                arrayList.add(str);
            }
        }
        appendAll(name, arrayList);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name, String value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        List<String> list = this.values.get(name);
        if (list != null) {
            return list.contains(value);
        }
        return false;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean remove(String name, String value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        List<String> list = this.values.get(name);
        if (list != null) {
            return list.remove(value);
        }
        return false;
    }

    public /* synthetic */ StringValuesBuilderImpl(boolean z10, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? 8 : i10);
    }
}
