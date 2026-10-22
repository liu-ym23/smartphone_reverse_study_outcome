package com.stepos.net.cache;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¢\u0006\u0004\b\f\u0010\rR&\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/net/cache/CacheTagStore;", "", "<init>", "()V", "", "url", "", "tags", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/Collection;)V", "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Set;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "tagToUrls", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CacheTagStore {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<String, Set<String>> tagToUrls = new ConcurrentHashMap<>();

    public final void a(String url, Collection<String> tags) {
        Set<String> setPutIfAbsent;
        p.i(url, "url");
        p.i(tags, "tags");
        for (String str : SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(F.d0(tags), CacheTagStore$bind$1.f30243a), CacheTagStore$bind$2.f30244a)) {
            ConcurrentHashMap<String, Set<String>> concurrentHashMap = this.tagToUrls;
            Set<String> setB = concurrentHashMap.get(str);
            if (setB == null && (setPutIfAbsent = concurrentHashMap.putIfAbsent(str, (setB = b()))) != null) {
                setB = setPutIfAbsent;
            }
            setB.add(url);
        }
    }

    public final Set<String> b() {
        Set<String> setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        p.h(setNewSetFromMap, "newSetFromMap(...)");
        return setNewSetFromMap;
    }
}
