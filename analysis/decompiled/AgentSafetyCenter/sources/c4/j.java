package c4;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements TransformationMethod {

    /* renamed from: c, reason: collision with root package name */
    public TransformationMethod f2206c;

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f2206c;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || a4.j.a().b() != 1) {
            return charSequence;
        }
        a4.j jVarA = a4.j.a();
        jVarA.getClass();
        return jVarA.f(0, charSequence.length(), 0, charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z10, int i, Rect rect) {
        TransformationMethod transformationMethod = this.f2206c;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z10, i, rect);
        }
    }
}
