package v;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes.dex */
public class h implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransformationMethod f24966a;

    public h(TransformationMethod r10) {
        this.f24966a = r10;
    }

    public TransformationMethod a() {
        return this.f24966a;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r10, View r11) {
        if (r11.isInEditMode() == false) goto L5;
        return r10;
    L5:
        TransformationMethod r12 = this.f24966a;
        if (r12 == null) goto L8;
        r10 = r12.getTransformation(r10, r11);
    L8:
        if (r10 != null) goto L10;
    L14:
        return r10;
    L10:
        if (EmojiCompat.b().d() != 1) goto L14;
        return EmojiCompat.b().o(r10);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View r10, CharSequence r11, boolean r12, int r13, Rect r14) {
        TransformationMethod r15 = this.f24966a;
        if (r15 == null) goto L6;
        r15.onFocusChanged(r10, r11, r12, r13, r14);
        return;
    }
}
