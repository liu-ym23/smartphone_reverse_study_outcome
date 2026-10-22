package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class k implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f4550a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4551b;

    public k(Context context, int i4) {
        this.f4550a = context;
        this.f4551b = i4;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Resources.NotFoundException {
        Context context = this.f4550a;
        int i4 = this.f4551b;
        try {
            return m.b(context.getResources().openRawResource(i4), "rawRes_" + i4, true);
        } catch (Resources.NotFoundException e4) {
            return new A(e4);
        }
    }
}
