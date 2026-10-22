package g;

import android.content.Context;
import android.graphics.RectF;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public int f2764a = 0;

    /* renamed from: b, reason: collision with root package name */
    public float f2765b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    public float f2766c = -1.0f;
    public float d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public int[] f2767e = new int[0];

    /* renamed from: f, reason: collision with root package name */
    public boolean f2768f = false;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f2769g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f2770h;

    static {
        new RectF();
        new ConcurrentHashMap();
    }

    public k0(TextView textView) {
        this.f2769g = textView;
        this.f2770h = textView.getContext();
        new i0();
    }

    public static int[] a(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i8 : iArr) {
                if (i8 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i8)) < 0) {
                    arrayList.add(Integer.valueOf(i8));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i9 = 0; i9 < size; i9++) {
                    iArr2[i9] = ((Integer) arrayList.get(i9)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public final boolean b() {
        return !(this.f2769g instanceof t);
    }
}
