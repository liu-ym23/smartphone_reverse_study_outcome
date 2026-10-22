package androidx.emoji2.text;

import android.text.TextPaint;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements f {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f598b = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f599a;

    public c() {
        TextPaint textPaint = new TextPaint();
        this.f599a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
