package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public SparseIntArray f12863a = new SparseIntArray();

    /* renamed from: b, reason: collision with root package name */
    public HashMap<Integer, HashSet<WeakReference<a>>> f12864b = new HashMap<>();

    public interface a {
    }

    public void a(int i10, a aVar) {
        HashSet<WeakReference<a>> hashSet = this.f12864b.get(Integer.valueOf(i10));
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f12864b.put(Integer.valueOf(i10), hashSet);
        }
        hashSet.add(new WeakReference<>(aVar));
    }
}
