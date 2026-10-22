package com.bytedanceos.common;

import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00182\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004:\u0001\u0019B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u000f\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedanceos/common/AppInfoCache;", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedanceos/common/model/AppInfo;", "Lkotlin/collections/LinkedHashMap;", "name", "<init>", "(Ljava/lang/String;)V", "key", CommonKey.KEY_VALUE, "put", "(Ljava/lang/String;Lcom/bytedanceos/common/model/AppInfo;)Lcom/bytedanceos/common/model/AppInfo;", "remove", "(Ljava/lang/String;)Lcom/bytedanceos/common/model/AppInfo;", "", "from", "", "putAll", "(Ljava/util/Map;)V", "clear", "()V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Companion", "a", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppInfoCache extends LinkedHashMap<String, AppInfo> {

    @NotNull
    public static final a Companion = null;

    @NotNull
    public static final String TAG = "AppInfoCache";

    @NotNull
    private final String name;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public AppInfoCache(@NotNull String r10) {
        q.g(r10, "name");
        this.name = r10;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (j.f(3) == false) goto L5;
        j.a("AppInfoCache " + this.name + " clear");
    L5:
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r10);
    }

    public /* bridge */ boolean containsValue(AppInfo r10) {
        return super.containsValue(r10);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, AppInfo>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ AppInfo get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    public /* bridge */ Set<Map.Entry<String, AppInfo>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final /* bridge */ AppInfo getOrDefault(Object r10, AppInfo r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, r11);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<AppInfo> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r10, Object r11) {
        return put((String) r10, (AppInfo) r11);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(@NotNull Map<? extends String, ? extends AppInfo> r12) {
        q.g(r12, "from");
        if (j.f(3) == false) goto L5;
        j.a("AppInfoCache " + this.name + " putAll " + b0.h0(r12.keySet(), ",", null, null, 0, null, null, 62, null));
    L5:
        super.putAll(r12);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ AppInfo remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<AppInfo> values() {
        return getValues();
    }

    public /* bridge */ boolean containsKey(String r10) {
        return super.containsKey(r10);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r10) {
        if ((r10 instanceof AppInfo) == true) goto L7;
        return false;
    L7:
        return containsValue((AppInfo) r10);
    }

    public /* bridge */ AppInfo get(String r10) {
        return (AppInfo) super.get(r10);
    }

    public /* bridge */ AppInfo getOrDefault(String r10, AppInfo r11) {
        return (AppInfo) super.getOrDefault(r10, r11);
    }

    @Nullable
    public AppInfo put(@NotNull String r10, @NotNull AppInfo r11) {
        q.g(r10, "key");
        q.g(r11, CommonKey.KEY_VALUE);
        if (j.f(3) == false) goto L6;
        j.a("AppInfoCache " + this.name + " put " + r10);
    L6:
        return (AppInfo) super.put(r10, r11);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, (AppInfo) r11);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r11 instanceof AppInfo) == true) goto L9;
        return false;
    L9:
        return remove((String) r10, (AppInfo) r11);
    }

    public /* bridge */ boolean remove(String r10, AppInfo r11) {
        return super.remove(r10, r11);
    }

    @Nullable
    public AppInfo remove(@NotNull String r10) {
        q.g(r10, "key");
        if (j.f(3) == false) goto L6;
        j.a("AppInfoCache " + this.name + " remove " + r10);
    L6:
        return (AppInfo) super.remove(r10);
    }
}
