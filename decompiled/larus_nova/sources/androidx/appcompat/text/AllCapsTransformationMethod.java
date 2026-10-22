package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class AllCapsTransformationMethod implements TransformationMethod {
    private Locale mLocale;

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View r100, CharSequence r101, boolean r102, int r103, Rect r104) {
    }

    public AllCapsTransformationMethod(Context r100) {
        this.mLocale = r100.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r100, View r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.toString().toUpperCase(this.mLocale);
    }
}
