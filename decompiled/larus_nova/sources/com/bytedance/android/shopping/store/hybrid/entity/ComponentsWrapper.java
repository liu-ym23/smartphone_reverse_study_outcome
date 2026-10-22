package com.bytedance.android.shopping.store.hybrid.entity;

import com.bytedance.android.shopping.extensions.k;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BE\u00120\b\u0002\u0010\u000f\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J1\u0010\f\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003JG\u0010\u0011\u001a\u00020\u000020\b\u0002\u0010\u000f\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\rHÆ\u0001J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\nHÖ\u0003R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bRB\u0010\u000f\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/ComponentsWrapper;", "Ljava/io/Serializable;", "Lorg/json/JSONObject;", "blockJSONObject", "", "hasComponents", "hasISVComponent", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "component1", "Lcom/google/gson/JsonObject;", "component2", "components", "block", "copy", "toString", "", "hashCode", "other", "equals", "Lcom/google/gson/JsonArray;", "moduleWrapperList$delegate", "Lkotlin/Lazy;", "getModuleWrapperList", "()Lcom/google/gson/JsonArray;", "moduleWrapperList", "Ljava/util/List;", "getComponents", "()Ljava/util/List;", "Lcom/google/gson/JsonObject;", "getBlock", "()Lcom/google/gson/JsonObject;", "<init>", "(Ljava/util/List;Lcom/google/gson/JsonObject;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentsWrapper implements Serializable {

    @SerializedName("block")
    private final JsonObject block;

    @SerializedName("components")
    private final List<HashMap<String, Object>> components;
    private final Lazy moduleWrapperList$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentsWrapper() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ComponentsWrapper copy$default(ComponentsWrapper r100, List r101, JsonObject r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.components;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.block;
    L9:
        return r100.copy(r101, r102);
    }

    public final JSONObject blockJSONObject() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        JsonObject r102 = this.block;     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
        String r103 = r102.toString();     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        JSONObject r104 = new JSONObject(r103);     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == true) goto L18;
        r100 = r105;
    L18:
        return (JSONObject) r100;
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final List<HashMap<String, Object>> component1() {
        return this.components;
    }

    public final JsonObject component2() {
        return this.block;
    }

    public final ComponentsWrapper copy(List<? extends HashMap<String, Object>> r100, JsonObject r101) {
        return new ComponentsWrapper(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ComponentsWrapper) == false) goto L10;
        ComponentsWrapper r101 = (ComponentsWrapper) r100;
        if (Intrinsics.areEqual(this.components, r101.components) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.block, r101.block) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<HashMap<String, Object>> r100 = this.components;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.block;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ComponentsWrapper(components=" + this.components + ", block=" + this.block + ")";
    }

    public final boolean hasComponents() {
        List<HashMap<String, Object>> r100 = this.components;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L19;
        JsonArray r102 = (JsonArray) this.moduleWrapperList$delegate.getValue();
        if (r102 == null) goto L13;
        Integer r103 = Integer.valueOf(r102.size());
    L15:
        if (k.g(r103, 0) > 0) goto L20;
        return false;
    L20:
        return true;
    L13:
        r103 = null;
        goto L15
    L19:
        return true;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean hasISVComponent() {
        List<HashMap<String, Object>> r100 = this.components;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        Object r102 = null;
        if (r101 == false) goto L46;
        JsonArray r103 = (JsonArray) this.moduleWrapperList$delegate.getValue();
        if (r103 == null) goto L44;
        List r104 = CollectionsKt.toList(r103);
        if (r104 == null) goto L44;
        Iterator r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L43;
        Object r106 = r105.next();
        JsonElement r107 = (JsonElement) r106;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L34
        if ((r107 instanceof JsonObject) == true) goto L22;
        r107 = null;
    L22:
        JsonObject r109 = (JsonObject) r107;     // Catch: Throwable -> L34
        if (r109 == null) goto L31;
        JsonObject r110 = r109.getAsJsonObject("decoration_module");     // Catch: Throwable -> L34
        if (r110 == null) goto L31;
        JsonElement r111 = r110.get("component_type");     // Catch: Throwable -> L34
        if (r111 == null) goto L31;
        if (r111.getAsInt() != 1) goto L31;
        boolean r112 = true;
    L32:
        Object r113 = Result.m9449constructorimpl(Boolean.valueOf(r112));     // Catch: Throwable -> L34
    L37:
        if (Result.m9452exceptionOrNullimpl(r113) == null) goto L41;
        r113 = Boolean.FALSE;
    L41:
        if (((Boolean) r113).booleanValue() == false) goto L17;
        r102 = r106;
    L31:
        r112 = false;
    L34:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L43:
        r102 = (JsonElement) r102;
    L44:
        if (r102 == null) goto L73;
    L61:
        return true;
    L73:
        return false;
    L46:
        Iterator<T> r115 = this.components.iterator();
    L48:
        if (r115.hasNext() == false) goto L60;
        Object r116 = r115.next();
        Object r117 = ((HashMap) r116).get("component_type");
        if ((r117 instanceof Number) == true) goto L52;
        r117 = null;
    L52:
        Number r118 = (Number) r117;
        if (r118 != null) goto L55;
    L57:
        boolean r119 = false;
    L58:
        if (r119 == false) goto L48;
        r102 = r116;
        goto L60
    L55:
        if (r118.intValue() != 1) goto L57;
        r119 = true;
    L60:
        if (r102 != null) goto L61;
        return false;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final JsonObject getBlock() {
        return this.block;
    }

    public final List<HashMap<String, Object>> getComponents() {
        return this.components;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentsWrapper(List<? extends HashMap<String, Object>> r100, JsonObject r101) {
        this.components = r100;
        this.block = r101;
        this.moduleWrapperList$delegate = LazyKt.lazy(new ComponentsWrapper$moduleWrapperList$2(this));
    }

    public /* synthetic */ ComponentsWrapper(List r100, JsonObject r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
