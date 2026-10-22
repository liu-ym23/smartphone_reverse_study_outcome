package k1;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements TransformationMethod {

    /* renamed from: a, reason: collision with root package name */
    public final TransformationMethod f9857a;

    public h(TransformationMethod transformationMethod) {
        this.f9857a = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f9857a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || androidx.emoji2.text.d.a().b() != 1) {
            return charSequence;
        }
        androidx.emoji2.text.d dVarA = androidx.emoji2.text.d.a();
        dVarA.getClass();
        return dVarA.e(charSequence, 0, charSequence.length());
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z, int i10, Rect rect) {
        TransformationMethod transformationMethod = this.f9857a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z, i10, rect);
        }
    }
}
