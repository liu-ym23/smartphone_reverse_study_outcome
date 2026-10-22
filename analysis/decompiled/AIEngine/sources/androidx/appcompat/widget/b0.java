package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.RectF;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public int f754a = 0;

    /* renamed from: b, reason: collision with root package name */
    public float f755b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    public float f756c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f757d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public int[] f758e = new int[0];

    /* renamed from: f, reason: collision with root package name */
    public boolean f759f = false;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f760g;
    public final Context h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends c {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c {
    }

    static {
        new RectF();
        new ConcurrentHashMap();
    }

    public b0(TextView textView) {
        this.f760g = textView;
        this.h = textView.getContext();
        new b();
    }

    public static int[] a(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i10 : iArr) {
                if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i11 = 0; i11 < size; i11++) {
                    iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public final boolean b() {
        return !(this.f760g instanceof k);
    }
}
