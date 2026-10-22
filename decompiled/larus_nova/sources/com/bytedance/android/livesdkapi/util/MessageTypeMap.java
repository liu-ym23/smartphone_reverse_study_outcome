package com.bytedance.android.livesdkapi.util;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\t\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0003H\u0096\u0001J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0003J\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u0003¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\u0019H\u0096\u0001J\u001a\u0010\"\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\u001f\u0010#\u001a\u00020\u00172\u0014\u0010$\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030%H\u0096\u0001J\u0013\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0001R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t0\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u0002X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/MessageTypeMap;", "", "", "", "actualMap", "Ljava/util/concurrent/ConcurrentHashMap;", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "messageTypeIntTypeMap", "size", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "containsKey", "", "key", "containsValue", "value", MonitorConstants.CONNECT_TYPE_GET, "getMessageIntType", "messageMethod", "(Ljava/lang/String;)Ljava/lang/Integer;", "isEmpty", "put", "putAll", "from", "", "remove", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MessageTypeMap implements Map<Integer, String>, KMutableMap {
    private final ConcurrentHashMap<Integer, String> actualMap;
    private final ConcurrentHashMap<String, Integer> messageTypeIntTypeMap;

    @Override // java.util.Map
    public void clear() {
        this.actualMap.clear();
    }

    public boolean containsKey(int r100) {
        return this.actualMap.containsKey(Integer.valueOf(r100));
    }

    public boolean containsValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return this.actualMap.containsValue(r100);
    }

    public String get(int r100) {
        return this.actualMap.get(Integer.valueOf(r100));
    }

    public Set<Map.Entry<Integer, String>> getEntries() {
        return this.actualMap.entrySet();
    }

    public Set<Integer> getKeys() {
        return this.actualMap.keySet();
    }

    public int getSize() {
        return this.actualMap.size();
    }

    public Collection<String> getValues() {
        return this.actualMap.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.actualMap.isEmpty();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Integer, ? extends String> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.actualMap.putAll(r100);
    }

    public String remove(int r100) {
        return this.actualMap.remove(Integer.valueOf(r100));
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<Integer, String>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Integer> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<String> values() {
        return getValues();
    }

    public MessageTypeMap(ConcurrentHashMap<Integer, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "actualMap");
        this.actualMap = r100;
        this.messageTypeIntTypeMap = new ConcurrentHashMap();
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof Integer) == true) goto L7;
        return false;
    L7:
        return containsKey(((Number) r100).intValue());
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsValue((String) r100);
    }

    @Override // java.util.Map
    public final /* bridge */ String get(Object r100) {
        if ((r100 instanceof Integer) == true) goto L7;
        return null;
    L7:
        return get(((Number) r100).intValue());
    }

    public final Integer getMessageIntType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageMethod");
        return this.messageTypeIntTypeMap.get(r100);
    }

    @Override // java.util.Map
    public final /* bridge */ String remove(Object r100) {
        if ((r100 instanceof Integer) == true) goto L7;
        return null;
    L7:
        return remove(((Number) r100).intValue());
    }

    public String put(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        this.messageTypeIntTypeMap.put(r101, Integer.valueOf(r100));
        return this.actualMap.put(Integer.valueOf(r100), r101);
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ String put(Integer r100, String r101) {
        return put(r100.intValue(), r101);
    }
}
