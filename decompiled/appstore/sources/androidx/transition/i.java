package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Matrix f5068a = null;

    public class a extends Matrix {
        public a() {
        }

        public void a() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix r10) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float r10, float r11, float r12) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float r10, float r11, float r12, float r13) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float r10, float r11, float r12, float r13) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float r10, float r11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix r10) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float r10, float r11, float r12) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float r10, float r11, float r12, float r13) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float r10, float r11, float r12, float r13) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float r10, float r11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            a();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix r10) {
            a();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix r10, Matrix r11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] r10, int r11, float[] r12, int r13, int r14) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF r10, RectF r11, Matrix.ScaleToFit r12) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float r10, float r11, float r12) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float r10, float r11, float r12, float r13) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float r10, float r11, float r12, float r13) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float r10, float r11, float r12, float r13) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float r10, float r11) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] r10) {
            a();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float r10) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float r10, float r11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float r10, float r11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float r10) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float r10, float r11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float r10, float r11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float r10) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float r10, float r11) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float r10, float r11) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float r10, float r11) {
            a();
        }
    }

    static {
        f5068a = new a();
    }
}
