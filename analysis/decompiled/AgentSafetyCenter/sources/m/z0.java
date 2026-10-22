package m;

import android.content.Context;
import android.graphics.RectF;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public int f8143a;

    /* renamed from: b, reason: collision with root package name */
    public float f8144b;

    /* renamed from: c, reason: collision with root package name */
    public float f8145c;

    /* renamed from: d, reason: collision with root package name */
    public float f8146d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f8147e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8148f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f8149g;

    /* renamed from: h, reason: collision with root package name */
    public Context f8150h;

    static {
        new RectF();
        new ConcurrentHashMap();
    }

    public static int[] a(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i : iArr) {
                if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i3 = 0; i3 < size; i3++) {
                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public final boolean b() {
        return !(this.f8149g instanceof u);
    }
}
