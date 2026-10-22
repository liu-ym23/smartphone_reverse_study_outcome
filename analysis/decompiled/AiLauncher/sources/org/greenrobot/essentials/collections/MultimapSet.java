package org.greenrobot.essentials.collections;

import ic.AbstractC4197a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class MultimapSet<K, V> extends AbstractC4197a<K, V, Set<V>> {

    /* renamed from: b, reason: collision with root package name */
    public final SetType f37808b;

    public enum SetType {
        REGULAR,
        THREAD_SAFE
    }

    public MultimapSet(Map<K, Set<V>> map, SetType setType) {
        super(map);
        this.f37808b = setType;
    }

    public static <K, V> MultimapSet<K, V> e(SetType setType) {
        return new MultimapSet<>(new HashMap(), setType);
    }
}
