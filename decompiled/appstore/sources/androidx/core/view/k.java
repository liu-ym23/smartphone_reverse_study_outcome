package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointerIcon f2783a;

    public static class a {
        @DoNotInline
        public static PointerIcon a(Bitmap r10, float r11, float r12) {
            return PointerIcon.create(r10, r11, r12);
        }

        @DoNotInline
        public static PointerIcon b(Context r10, int r11) {
            return PointerIcon.getSystemIcon(r10, r11);
        }

        @DoNotInline
        public static PointerIcon c(Resources r10, int r11) {
            return PointerIcon.load(r10, r11);
        }
    }

    public k(PointerIcon r10) {
        this.f2783a = r10;
    }

    public static k b(Context r10, int r11) {
        return new k(a.b(r10, r11));
    }

    public Object a() {
        return this.f2783a;
    }
}
