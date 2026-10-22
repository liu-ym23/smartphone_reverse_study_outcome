package com.bytedance.android.shopping.store.tabkit.monitor;

import com.bytedance.apm.constant.UploadTypeInf;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J!\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J!\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/monitor/TabkitFramePref;", "Ljava/util/HashMap;", "", "", "()V", "map", "", "(Ljava/util/Map;)V", UploadTypeInf.TIMER, "Ljava/util/Timer;", "getTimer", "()Ljava/util/Timer;", "recordEvent", "", "key", "value", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "(Ljava/lang/String;Ljava/lang/Long;)V", "recordTime", "tick", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class TabkitFramePref extends HashMap<String, Long> {
    private final Timer timer;

    public TabkitFramePref() {
        this.timer = new PthreadTimer("TabkitFramePref");
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Long>> entrySet() {
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

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Long> values() {
        return getValues();
    }

    public final Timer getTimer() {
        return this.timer;
    }

    public TabkitFramePref(Map<String, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this();
        putAll(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof Long) == true) goto L7;
        return false;
    L7:
        return containsValue((Long) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
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

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(Long r100) {
        return super.containsValue(r100);
    }

    public /* bridge */ Long get(String r100) {
        return (Long) super.get(r100);
    }

    public /* bridge */ Long remove(String r100) {
        return (Long) super.remove(r100);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
        if (r100 == null) goto L4;
        boolean r102 = r100 instanceof String;
    L5:
        if (r102 == true) goto L8;
        return r101;
    L8:
        return getOrDefault((String) r100, (Long) r101);
    L4:
        r102 = true;
        goto L5
    }

    public void recordEvent(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (containsKey(r100) == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L8;
        long r102 = 1;
    L9:
        put(r100, Long.valueOf(r102));
        return;
    L8:
        r102 = 0;
        goto L9
    }

    public void recordTime(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (containsKey(r100) == false) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        put(r100, Long.valueOf(r102));
        return;
    L7:
        r102 = System.currentTimeMillis();
        goto L8
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        boolean r102 = true;
        if (r100 == null) goto L5;
        boolean r103 = r100 instanceof String;
    L6:
        if (r103 == false) goto L13;
        if (r101 == null) goto L9;
        r102 = r101 instanceof Long;
    L9:
        if (r102 == true) goto L12;
        return false;
    L12:
        return remove((String) r100, (Long) r101);
    L13:
        return false;
    L5:
        r103 = true;
        goto L6
    }

    public /* bridge */ Long getOrDefault(String r100, Long r101) {
        return (Long) super.getOrDefault(r100, r101);
    }

    public void recordEvent(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (containsKey(r100) == false) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        put(r100, Long.valueOf(r102));
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public /* bridge */ boolean remove(String r100, Long r101) {
        return super.remove(r100, r101);
    }

    public static /* synthetic */ void recordEvent$default(TabkitFramePref r100, String r101, Boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.recordEvent(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordEvent");
    }

    public static /* synthetic */ void recordTime$default(TabkitFramePref r100, String r101, Long r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.recordTime(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordTime");
    }

    public static /* synthetic */ void recordEvent$default(TabkitFramePref r100, String r101, Long r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.recordEvent(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordEvent");
    }
}
