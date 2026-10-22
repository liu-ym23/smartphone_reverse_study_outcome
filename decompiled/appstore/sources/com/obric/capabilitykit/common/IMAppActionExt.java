package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004R(\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/common/IMAppActionExt;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/io/Serializable;", "()V", CommonKey.KEY_VALUE, "actionDetailExtras", "getActionDetailExtras", "()Ljava/lang/String;", "setActionDetailExtras", "(Ljava/lang/String;)V", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IMAppActionExt extends ConcurrentHashMap<String, String> implements Serializable {
    public IMAppActionExt() {
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r10);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsValue((String) r10);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
        return getEntries();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    @Nullable
    public final String getActionDetailExtras() {
        return (String) get("action_detail_extras");
    }

    public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, (String) r11);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<String> getValues() {
        return super.values();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    public final void setActionDetailExtras(@Nullable String r10) {
        if (r10 != null) goto L5;
        remove("action_detail_extras");
        return;
    L5:
        put("action_detail_extras", r10);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<String> values() {
        return getValues();
    }

    public /* bridge */ boolean containsKey(String r10) {
        return super.containsKey(r10);
    }

    public /* bridge */ boolean containsValue(String r10) {
        return super.containsValue(r10);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ String get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    public final /* bridge */ String getOrDefault(Object r10, String r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, r11);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ String remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    public /* bridge */ String get(String r10) {
        return (String) super.get(r10);
    }

    public /* bridge */ String getOrDefault(String r10, String r11) {
        return (String) super.getOrDefault(r10, r11);
    }

    public /* bridge */ String remove(String r10) {
        return (String) super.remove(r10);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* bridge */ boolean remove(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r11 instanceof String) == true) goto L9;
        return false;
    L9:
        return remove((String) r10, (String) r11);
    }

    public /* bridge */ boolean remove(String r10, String r11) {
        return super.remove(r10, r11);
    }
}
