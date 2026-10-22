package android.ss.com.vboost.i;

import android.ss.com.vboost.FrequencyLevel;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f4693g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f4695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrequencyLevel f4697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4699f;

    static {
        f4693g = FrequencyLevel.LEVEL_6.ordinal();
    }

    public d(int r100, int r101, g r102, FrequencyLevel r103) {
        this.f4698e = 1000;
        this.f4699f = f4693g;
        this.f4694a = r100;
        this.f4695b = r102;
        this.f4696c = r101;
        this.f4697d = r103;
    }

    public boolean a(FrequencyLevel r100, int r101) {
        if ((r101 - this.f4696c) > this.f4698e) goto L5;
    L7:
        return false;
    L5:
        if (r100.ordinal() <= this.f4699f) goto L7;
        return true;
    }
}
