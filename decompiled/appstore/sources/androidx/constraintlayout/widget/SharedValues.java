package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SharedValues {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseIntArray f2385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap f2386b;

    public interface SharedValuesListener {
        void onNewValue(int r10, int r11, int r12);
    }

    public SharedValues() {
        this.f2385a = new SparseIntArray();
        this.f2386b = new HashMap();
    }

    public void a(int r10, SharedValuesListener r11) {
        HashSet r12 = (HashSet) this.f2386b.get(Integer.valueOf(r10));
        if (r12 != null) goto L5;
        r12 = new HashSet();
        this.f2386b.put(Integer.valueOf(r10), r12);
    L5:
        r12.add(new WeakReference(r11));
    }

    public void b(int r10, SharedValuesListener r11) {
        HashSet r12 = (HashSet) this.f2386b.get(Integer.valueOf(r10));
        if (r12 != null) goto L5;
        return;
    L5:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L12;
        WeakReference r15 = (WeakReference) r14.next();
        SharedValuesListener r16 = (SharedValuesListener) r15.get();
        if (r16 == null) goto L11;
        if (r16 != r11) goto L7;
    L11:
        r13.add(r15);
        goto L7
    L12:
        r12.removeAll(r13);
    }
}
