package com.bytedance.android.anniex.scene.data;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001c\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0005H\u0014¨\u0006\t"}, d2 = {"com/bytedance/android/anniex/scene/data/SceneDbManager$sceneCountMap$1", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/android/anniex/scene/data/SceneDbManager$b;", "Lkotlin/collections/LinkedHashMap;", "", "eldest", "", "removeEldestEntry", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class SceneDbManager$sceneCountMap$1 extends LinkedHashMap<String, SceneDbManager.b> {
    final /* synthetic */ SceneDbManager this$0;

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, SceneDbManager.b>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, SceneDbManager.b>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<SceneDbManager.b> getValues() {
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
    public final /* bridge */ Collection<SceneDbManager.b> values() {
        return getValues();
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
        if ((r100 instanceof SceneDbManager.b) == true) goto L7;
        return false;
    L7:
        return containsValue((SceneDbManager.b) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ SceneDbManager.b get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ SceneDbManager.b remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, SceneDbManager.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "eldest");
        if (size() <= this.this$0.f41170k) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(SceneDbManager.b r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ SceneDbManager.b get(String r100) {
        return (SceneDbManager.b) super.get(r100);
    }

    public /* bridge */ SceneDbManager.b remove(String r100) {
        return (SceneDbManager.b) super.remove(r100);
    }

    public SceneDbManager$sceneCountMap$1(SceneDbManager r100, int r101) {
        this.this$0 = r100;
        super(r101, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, (SceneDbManager.b) r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r101 instanceof SceneDbManager.b) == true) goto L9;
        return false;
    L9:
        return remove((String) r100, (SceneDbManager.b) r101);
    }

    public final /* bridge */ SceneDbManager.b getOrDefault(Object r100, SceneDbManager.b r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, r101);
    }

    public /* bridge */ boolean remove(String r100, SceneDbManager.b r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ SceneDbManager.b getOrDefault(String r100, SceneDbManager.b r101) {
        return (SceneDbManager.b) super.getOrDefault(r100, r101);
    }
}
