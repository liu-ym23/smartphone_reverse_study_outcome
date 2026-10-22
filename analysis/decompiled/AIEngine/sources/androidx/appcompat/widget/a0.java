package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f747a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Typeface f748b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f749c;

    public a0(TextView textView, Typeface typeface, int i10) {
        this.f747a = textView;
        this.f748b = typeface;
        this.f749c = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f747a.setTypeface(this.f748b, this.f749c);
    }
}
