package br1;

import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SparseArray<b> f20120d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<View.OnTouchListener> f20121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<br1.a> f20122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0344b f20123c;

    public static final class a {
        public static b a(DataCenter r100) {
            Intrinsics.checkNotNullParameter(r100, "dataCenter");
            SparseArray<b> r101 = b.f20120d;
            b r102 = r101.get(r100.hashCode());
            if (r102 == null) goto L5;
            return r102;
        L5:
            b r103 = new b();
            r101.put(r100.hashCode(), r103);
            return r103;
        }
    }

    /* JADX INFO: renamed from: br1.b$b, reason: collision with other inner class name */
    public static final class C0344b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0344b f20124a = null;

        static {
            f20124a = new C0344b();
        }

        public C0344b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            br1.a r102 = (br1.a) r100;
            br1.a r103 = (br1.a) r101;
            if (r102.a() <= r103.a()) goto L6;
            return -1;
        L6:
            if (r102.a() >= r103.a()) goto L8;
            return 1;
        L8:
            return 0;
        }
    }

    static {
        f20120d = new SparseArray();
    }

    public b() {
        this.f20121a = new LinkedList();
        this.f20122b = new ArrayList();
        this.f20123c = C0344b.f20124a;
    }
}
