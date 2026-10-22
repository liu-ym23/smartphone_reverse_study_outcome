package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class X implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f3039a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Typeface f3040b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3041c;

    public X(TextView textView, Typeface typeface, int i4) {
        this.f3039a = textView;
        this.f3040b = typeface;
        this.f3041c = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3039a.setTypeface(this.f3040b, this.f3041c);
    }
}
