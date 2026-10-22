package g;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2839a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.emoji2.text.m f2840b;

    public u(TextView textView) {
        this.f2839a = textView;
        androidx.emoji2.text.m mVar = new androidx.emoji2.text.m();
        mVar.f621a = new p0.h(textView);
        this.f2840b = mVar;
    }

    public final void a(AttributeSet attributeSet, int i8) {
        TypedArray typedArrayObtainStyledAttributes = this.f2839a.getContext().obtainStyledAttributes(attributeSet, c.a.f1019g, i8, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            ((k4.z) this.f2840b.f621a).H(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
