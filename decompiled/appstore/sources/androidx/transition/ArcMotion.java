package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f4892g = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f4893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f4894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f4895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f4896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f4897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f4898f;

    static {
        f4892g = (float) Math.tan(Math.toRadians(35.0d));
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
        this.f4893a = 0.0f;
        this.f4894b = 0.0f;
        this.f4895c = 70.0f;
        this.f4896d = 0.0f;
        this.f4897e = 0.0f;
        this.f4898f = f4892g;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.f5003j);
        XmlPullParser r13 = (XmlPullParser) r11;
        c(n.g.b(r12, r13, "minimumVerticalAngle", 1, 0.0f));
        b(n.g.b(r12, r13, "minimumHorizontalAngle", 0, 0.0f));
        a(n.g.b(r12, r13, "maximumAngle", 2, 70.0f));
        r12.recycle();
    }

    public static float d(float r10) {
        if (r10 < 0.0f) goto L9;
        if (r10 > 90.0f) goto L9;
        return (float) Math.tan(Math.toRadians(r10 / 2.0f));
    L9:
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public void a(float r10) {
        this.f4895c = r10;
        this.f4898f = d(r10);
    }

    public void b(float r10) {
        this.f4893a = r10;
        this.f4896d = d(r10);
    }

    public void c(float r10) {
        this.f4894b = r10;
        this.f4897e = d(r10);
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float r12, float r13, float r14, float r15) {
        Path r10 = new Path();
        r10.moveTo(r12, r13);
        float r11 = r14 - r12;
        float r16 = r15 - r13;
        float r17 = (r11 * r11) + (r16 * r16);
        float r18 = (r12 + r14) / 2.0f;
        float r19 = (r13 + r15) / 2.0f;
        float r20 = 0.25f * r17;
        if (r13 <= r15) goto L5;
        boolean r21 = true;
    L7:
        if (Math.abs(r11) >= Math.abs(r16)) goto L14;
        float r22 = Math.abs(r17 / (r16 * 2.0f));
        if (r21 == false) goto L11;
        float r23 = r22 + r15;
        float r24 = r14;
    L12:
        float r25 = this.f4897e;
    L13:
        float r26 = (r20 * r25) * r25;
        float r27 = r18 - r24;
        float r28 = r19 - r23;
        float r29 = (r27 * r27) + (r28 * r28);
        float r110 = this.f4898f;
        float r30 = (r20 * r110) * r110;
        if (r29 < r26) goto L27;
        if (r29 <= r30) goto L25;
        r26 = r30;
        goto L27
    L25:
        r26 = 0.0f;
    L27:
        if (r26 == 0.0f) goto L29;
        float r111 = (float) Math.sqrt(r26 / r29);
        r24 = ((r24 - r18) * r111) + r18;
        r23 = r19 + (r111 * (r23 - r19));
    L29:
        r10.cubicTo((r12 + r24) / 2.0f, (r13 + r23) / 2.0f, (r24 + r14) / 2.0f, (r23 + r15) / 2.0f, r14, r15);
        return r10;
    L11:
        r23 = r22 + r13;
        r24 = r12;
        goto L12
    L14:
        float r31 = r17 / (r11 * 2.0f);
        if (r21 == false) goto L17;
        r23 = r13;
        r24 = r31 + r12;
    L18:
        r25 = this.f4896d;
        goto L13
    L17:
        r24 = r14 - r31;
        r23 = r15;
        goto L18
    L5:
        r21 = false;
        goto L7
    }
}
