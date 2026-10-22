package p1;

import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public float f4718c;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f4719e;

    /* renamed from: f, reason: collision with root package name */
    public r1.d f4720f;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f4716a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final l1.b f4717b = new l1.b(1, this);
    public boolean d = true;

    public i(l1.f fVar) {
        this.f4719e = new WeakReference(null);
        this.f4719e = new WeakReference(fVar);
    }

    public final float a(String str) {
        if (!this.d) {
            return this.f4718c;
        }
        TextPaint textPaint = this.f4716a;
        this.f4718c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        if (str != null) {
            Math.abs(textPaint.getFontMetrics().ascent);
        }
        this.d = false;
        return this.f4718c;
    }
}
