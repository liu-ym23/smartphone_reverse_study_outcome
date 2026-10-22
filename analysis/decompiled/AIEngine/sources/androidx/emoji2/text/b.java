package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements d.e {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f1923b = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f1924a;

    public b() {
        TextPaint textPaint = new TextPaint();
        this.f1924a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
