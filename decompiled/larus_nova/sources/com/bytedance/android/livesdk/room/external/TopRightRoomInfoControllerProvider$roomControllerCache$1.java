package com.bytedance.android.livesdk.room.external;

import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/bytedance/android/livesdk/room/external/TopRightRoomInfoControllerProvider$roomControllerCache$1", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomController;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class TopRightRoomInfoControllerProvider$roomControllerCache$1 extends LinkedHashMap<String, ILiveRoomController> {
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, ILiveRoomController>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<ILiveRoomController> values() {
        return getValues();
    }

    public TopRightRoomInfoControllerProvider$roomControllerCache$1() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof ILiveRoomController) == true) goto L7;
        return false;
    L7:
        return containsValue((ILiveRoomController) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, ILiveRoomController> r100) {
        if (size() <= 3) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(ILiveRoomController r100) {
        return super.containsValue(r100);
    }

    public /* bridge */ ILiveRoomController get(String r100) {
        return (ILiveRoomController) super.get(r100);
    }

    public /* bridge */ ILiveRoomController remove(String r100) {
        return (ILiveRoomController) super.remove(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, (ILiveRoomController) r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L5;
        return false;
    L5:
        if ((r101 instanceof ILiveRoomController) == true) goto L8;
        return false;
    L8:
        return remove((String) r100, (ILiveRoomController) r101);
    }

    public /* bridge */ ILiveRoomController getOrDefault(String r100, ILiveRoomController r101) {
        return (ILiveRoomController) super.getOrDefault(r100, r101);
    }

    public /* bridge */ boolean remove(String r100, ILiveRoomController r101) {
        return super.remove(r100, r101);
    }
}
