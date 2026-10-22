package com.bytedance.android.livesdk.interactivity.publicscreen.panel;

import com.bytedance.android.live.base.model.data.b;
import com.bytedance.android.live.base.model.message.a6;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004B-\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0005H\u0014J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u001e\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\r\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0016J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/panel/ChatLikeLinkedHashMap;", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/android/live/base/model/data/b;", "Lkotlin/collections/LinkedHashMap;", "", "eldest", "", "removeEldestEntry", "key", "value", "put", "", "from", "", "putAll", "msgid", "Lcom/bytedance/android/live/base/model/message/a6;", "newLikeCount", "putLikeCount", "", "maxCapacity", "I", "initialCapacity", "", "loadFactor", "accessOrder", "<init>", "(IIFZ)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatLikeLinkedHashMap extends LinkedHashMap<Long, b> {
    private final int maxCapacity;

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<Long, b>> entrySet() {
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
    public final /* bridge */ Set<Long> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<b> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof Long) == true) goto L7;
        return false;
    L7:
        return containsKey((Long) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof b) == true) goto L7;
        return false;
    L7:
        return containsValue((b) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r100) {
        if ((r100 instanceof Long) == true) goto L7;
        return null;
    L7:
        return get((Long) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends Long, ? extends b> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Iterator<Map.Entry<? extends Long, ? extends b>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends Long, ? extends b> r102 = r101.next();
        put(r102.getKey().longValue(), r102.getValue());
        goto L4
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object r100) {
        if ((r100 instanceof Long) == true) goto L7;
        return null;
    L7:
        return remove((Long) r100);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<Long, b> r100) {
        Intrinsics.checkNotNullParameter(r100, "eldest");
        if (size() <= this.maxCapacity) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(Long r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(b r100) {
        return super.containsValue(r100);
    }

    public /* bridge */ b get(Long r100) {
        return (b) super.get(r100);
    }

    public /* bridge */ b remove(Long r100) {
        return (b) super.remove(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof Long) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((Long) r100, (b) r101);
    }

    public b put(long r100, b r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        if (containsKey(Long.valueOf(r100)) == false) goto L10;
        b r102 = (b) get(Long.valueOf(r100));
        if (r102 == null) goto L7;
        long r103 = r102.c();
    L9:
        if (r103 < r101.c()) goto L10;
        return null;
    L7:
        r103 = 0;
    L10:
        super.put(Long.valueOf(r100), r101);
        return null;
    }

    public final void putLikeCount(long r100, a6 r110) {
        Intrinsics.checkNotNullParameter(r110, "newLikeCount");
        long r101 = 0;
        if (containsKey(Long.valueOf(r100)) == true) goto L12;
        b r102 = new b();
        Long r103 = r110.a();
        if (r103 == null) goto L7;
        long r104 = r103.longValue();
    L8:
        r102.g(r104);
        Long r111 = r110.b();
        if (r111 == null) goto L11;
        r101 = r111.longValue();
    L11:
        r102.h(r101);
        super.put(Long.valueOf(r100), r102);
        return;
    L7:
        r104 = 0;
        goto L8
    L12:
        Long r105 = r110.b();
        if (r105 == null) goto L15;
        long r106 = r105.longValue();
    L16:
        b r107 = (b) get(Long.valueOf(r100));
        if (r107 == null) goto L19;
        long r108 = r107.c();
    L21:
        if (r106 <= r108) goto L37;
        b r109 = (b) get(Long.valueOf(r100));
        if (r109 == null) goto L29;
        Long r112 = r110.a();
        if (r112 == null) goto L27;
        long r113 = r112.longValue();
    L28:
        r109.g(r113);
        goto L29
    L27:
        r113 = 0;
    L29:
        b r114 = (b) get(Long.valueOf(r100));
        if (r114 == null) goto L38;
        Long r115 = r110.b();
        if (r115 == null) goto L34;
        r101 = r115.longValue();
    L34:
        r114.h(r101);
        return;
    L38:
        return;
    L37:
        return;
    L19:
        r108 = 0;
        goto L21
    L15:
        r106 = 0;
        goto L16
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof Long) == true) goto L5;
        return false;
    L5:
        if ((r101 instanceof b) == true) goto L8;
        return false;
    L8:
        return remove((Long) r100, (b) r101);
    }

    public /* bridge */ b getOrDefault(Long r100, b r101) {
        return (b) super.getOrDefault(r100, r101);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r100, Object r101) {
        return put(((Number) r100).longValue(), (b) r101);
    }

    public /* bridge */ boolean remove(Long r100, b r101) {
        return super.remove(r100, r101);
    }

    public ChatLikeLinkedHashMap(int r100, int r101, float r102, boolean r103) {
        super(r101, r102, r103);
        this.maxCapacity = r100;
    }

    public /* synthetic */ ChatLikeLinkedHashMap(int r100, int r101, float r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = 10;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0.75f;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = true;
    L11:
        this(r100, r101, r102, r103);
    }
}
