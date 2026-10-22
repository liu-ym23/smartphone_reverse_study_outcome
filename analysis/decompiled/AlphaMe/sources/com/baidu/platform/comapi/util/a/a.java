package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.vi.VIContext;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f9284a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f9285b = -1;

    /* renamed from: c, reason: collision with root package name */
    private float f9286c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private int f9287d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f9288e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f9289f = -1;

    /* renamed from: g, reason: collision with root package name */
    private double f9290g = -1.0d;

    public void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i4 = displayMetrics.widthPixels;
        this.f9284a = i4;
        int i5 = displayMetrics.heightPixels;
        this.f9285b = i5;
        if (i4 <= 0 || i5 <= 0) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            this.f9284a = displayMetrics.widthPixels;
            this.f9285b = displayMetrics.heightPixels;
        }
        this.f9286c = displayMetrics.density;
        this.f9287d = (int) displayMetrics.xdpi;
        this.f9288e = (int) displayMetrics.ydpi;
        int i6 = displayMetrics.densityDpi;
        this.f9289f = i6;
        if (i6 < 240) {
            this.f9289f = i6;
        }
        if (this.f9289f == 0) {
            this.f9289f = 160;
        }
        this.f9290g = this.f9289f / 240.0d;
    }

    public int b() {
        if (this.f9289f == -1) {
            a(VIContext.getContext());
        }
        return this.f9289f;
    }

    public int c() {
        if (this.f9285b == -1) {
            a(VIContext.getContext());
        }
        return this.f9285b;
    }

    public int d() {
        if (this.f9284a == -1) {
            a(VIContext.getContext());
        }
        return this.f9284a;
    }

    public float a() {
        if (this.f9286c == -1.0f) {
            a(VIContext.getContext());
        }
        return this.f9286c;
    }
}
