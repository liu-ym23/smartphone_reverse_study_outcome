package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.os.Bundle;
import android.view.ViewStructure;

/* JADX INFO: loaded from: classes17.dex */
public class ViewStructureCompat {
    private final Object mWrappedObj;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Bundle getExtras(ViewStructure r100) {
            return r100.getExtras();
        }

        public static void setClassName(ViewStructure r100, String r101) {
            r100.setClassName(r101);
        }

        public static void setContentDescription(ViewStructure r100, CharSequence r101) {
            r100.setContentDescription(r101);
        }

        public static void setText(ViewStructure r100, CharSequence r101) {
            r100.setText(r101);
        }

        public static void setId(ViewStructure r100, int r101, String r102, String r103, String r104) {
            r100.setId(r101, r102, r103, r104);
        }

        public static void setTextStyle(ViewStructure r100, float r101, int r102, int r103, int r104) {
            r100.setTextStyle(r101, r102, r103, r104);
        }

        public static void setDimens(ViewStructure r100, int r101, int r102, int r103, int r104, int r105, int r106) {
            r100.setDimens(r101, r102, r103, r104, r105, r106);
        }
    }

    public Bundle getExtras() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return null;
    L5:
        return Api23Impl.getExtras((ViewStructure) this.mWrappedObj);
    }

    public ViewStructure toViewStructure() {
        return (ViewStructure) this.mWrappedObj;
    }

    private ViewStructureCompat(ViewStructure r100) {
        this.mWrappedObj = r100;
    }

    public static ViewStructureCompat toViewStructureCompat(ViewStructure r100) {
        return new ViewStructureCompat(r100);
    }

    public void setClassName(String r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setClassName((ViewStructure) this.mWrappedObj, r100);
        return;
    }

    public void setContentDescription(CharSequence r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setContentDescription((ViewStructure) this.mWrappedObj, r100);
        return;
    }

    public void setText(CharSequence r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setText((ViewStructure) this.mWrappedObj, r100);
        return;
    }

    public void setId(int r100, String r101, String r102, String r103) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setId((ViewStructure) this.mWrappedObj, r100, r101, r102, r103);
        return;
    }

    public void setTextStyle(float r100, int r101, int r102, int r103) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setTextStyle((ViewStructure) this.mWrappedObj, r100, r101, r102, r103);
        return;
    }

    public void setDimens(int r100, int r110, int r111, int r112, int r113, int r114) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setDimens((ViewStructure) this.mWrappedObj, r100, r110, r111, r112, r113, r114);
        return;
    }
}
