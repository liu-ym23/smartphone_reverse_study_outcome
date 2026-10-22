package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.RectF;
import android.widget.TextView;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.appcompat.widget.j0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0208j0 {

    /* renamed from: a, reason: collision with root package name */
    public int f3106a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3107b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f3108c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f3109d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f3110e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f3111f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f3112g = false;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f3113h;

    /* renamed from: i, reason: collision with root package name */
    public final Context f3114i;

    static {
        new RectF();
        new ConcurrentHashMap();
    }

    public C0208j0(TextView textView) {
        this.f3113h = textView;
        this.f3114i = textView.getContext();
        new C0204h0();
    }

    public static int[] a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i4 : iArr) {
            if (i4 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i4)) < 0) {
                arrayList.add(Integer.valueOf(i4));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr2[i5] = ((Integer) arrayList.get(i5)).intValue();
        }
        return iArr2;
    }

    public final boolean b() {
        if (d() && this.f3106a == 1) {
            if (!this.f3112g || this.f3111f.length == 0) {
                int iFloor = ((int) Math.floor((this.f3110e - this.f3109d) / this.f3108c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i4 = 0; i4 < iFloor; i4++) {
                    iArr[i4] = Math.round((i4 * this.f3108c) + this.f3109d);
                }
                this.f3111f = a(iArr);
            }
            this.f3107b = true;
        } else {
            this.f3107b = false;
        }
        return this.f3107b;
    }

    public final boolean c() {
        boolean z4 = this.f3111f.length > 0;
        this.f3112g = z4;
        if (z4) {
            this.f3106a = 1;
            this.f3109d = r0[0];
            this.f3110e = r0[r1 - 1];
            this.f3108c = -1.0f;
        }
        return z4;
    }

    public final boolean d() {
        return !(this.f3113h instanceof C);
    }

    public final void e(float f4, float f5, float f6) {
        if (f4 <= Property.DEFAULT_FLOAT_VALUE) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f4 + "px) is less or equal to (0px)");
        }
        if (f5 <= f4) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f5 + "px) is less or equal to minimum auto-size text size (" + f4 + "px)");
        }
        if (f6 <= Property.DEFAULT_FLOAT_VALUE) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f6 + "px) is less or equal to (0px)");
        }
        this.f3106a = 1;
        this.f3109d = f4;
        this.f3110e = f5;
        this.f3108c = f6;
        this.f3112g = false;
    }
}
