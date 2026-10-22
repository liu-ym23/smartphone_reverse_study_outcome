package f;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class a implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Locale f19429a;

    public a(Context r10) {
        this.f19429a = r10.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r10, View r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.toString().toUpperCase(this.f19429a);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View r10, CharSequence r11, boolean r12, int r13, Rect r14) {
    }
}
