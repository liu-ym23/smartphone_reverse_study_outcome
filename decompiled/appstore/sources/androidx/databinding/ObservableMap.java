package androidx.databinding;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ObservableMap<K, V> extends Map<K, V> {

    public static abstract class a {
        public a() {
        }
    }

    void addOnMapChangedCallback(a r10);

    void removeOnMapChangedCallback(a r10);
}
