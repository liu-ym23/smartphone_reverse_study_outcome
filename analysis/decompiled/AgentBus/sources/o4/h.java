package o4;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class h extends LinkedHashMap {
    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        return super.size() > 200;
    }
}
