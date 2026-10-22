package v;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f24954a;

    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f24955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f24956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f24957c;

        public a(TextView r10) {
            this.f24955a = r10;
            this.f24957c = true;
            this.f24956b = new d(r10);
        }

        @Override // v.f.b
        public InputFilter[] a(InputFilter[] r10) {
            if (this.f24957c == true) goto L7;
            return h(r10);
        L7:
            return f(r10);
        }

        @Override // v.f.b
        public boolean b() {
            return this.f24957c;
        }

        @Override // v.f.b
        public void c(boolean r10) {
            if (r10 == false) goto L5;
            l();
            return;
        }

        @Override // v.f.b
        public void d(boolean r10) {
            this.f24957c = r10;
            l();
            k();
        }

        @Override // v.f.b
        public TransformationMethod e(TransformationMethod r10) {
            if (this.f24957c == false) goto L7;
            return m(r10);
        L7:
            return j(r10);
        }

        public final InputFilter[] f(InputFilter[] r10) {
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L8;
            if (r10[r12] == this.f24956b) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return r10;
        L8:
            InputFilter[] r13 = new InputFilter[r10.length + 1];
            System.arraycopy(r10, 0, r13, 0, r11);
            r13[r11] = this.f24956b;
            return r13;
        }

        public final SparseArray g(InputFilter[] r10) {
            SparseArray r11 = new SparseArray(1);
            int r12 = 0;
        L4:
            if (r12 >= r10.length) goto L9;
            InputFilter r13 = r10[r12];
            if ((r13 instanceof d) == false) goto L8;
            r11.put(r12, r13);
        L8:
            r12 = r12 + 1;
            goto L4
        L9:
            return r11;
        }

        public final InputFilter[] h(InputFilter[] r10) {
            SparseArray r11 = g(r10);
            if (r11.size() != 0) goto L5;
            return r10;
        L5:
            int r12 = r10.length;
            InputFilter[] r13 = new InputFilter[r10.length - r11.size()];
            int r14 = 0;
            int r15 = 0;
        L6:
            if (r14 >= r12) goto L11;
            if (r11.indexOfKey(r14) >= 0) goto L10;
            r13[r15] = r10[r14];
            r15 = r15 + 1;
        L10:
            r14 = r14 + 1;
            goto L6
        L11:
            return r13;
        }

        public void i(boolean r10) {
            this.f24957c = r10;
        }

        public final TransformationMethod j(TransformationMethod r10) {
            if ((r10 instanceof h) == true) goto L5;
            return r10;
        L5:
            return ((h) r10).a();
        }

        public final void k() {
            InputFilter[] r10 = this.f24955a.getFilters();
            this.f24955a.setFilters(a(r10));
        }

        public void l() {
            TransformationMethod r10 = e(this.f24955a.getTransformationMethod());
            this.f24955a.setTransformationMethod(r10);
        }

        public final TransformationMethod m(TransformationMethod r10) {
            if ((r10 instanceof h) == false) goto L6;
            return r10;
        L6:
            if ((r10 instanceof PasswordTransformationMethod) == false) goto L9;
            return r10;
        L9:
            return new h(r10);
        }
    }

    public static class b {
        public b() {
        }

        public abstract InputFilter[] a(InputFilter[] r10);

        public abstract boolean b();

        public abstract void c(boolean r10);

        public abstract void d(boolean r10);

        public abstract TransformationMethod e(TransformationMethod r10);
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f24958a;

        public c(TextView r10) {
            this.f24958a = new a(r10);
        }

        @Override // v.f.b
        public InputFilter[] a(InputFilter[] r10) {
            if (f() == false) goto L6;
            return r10;
        L6:
            return this.f24958a.a(r10);
        }

        @Override // v.f.b
        public boolean b() {
            return this.f24958a.b();
        }

        @Override // v.f.b
        public void c(boolean r10) {
            if (f() == false) goto L5;
            return;
        L5:
            this.f24958a.c(r10);
        }

        @Override // v.f.b
        public void d(boolean r10) {
            if (f() == false) goto L5;
            this.f24958a.i(r10);
            return;
        L5:
            this.f24958a.d(r10);
        }

        @Override // v.f.b
        public TransformationMethod e(TransformationMethod r10) {
            if (f() == false) goto L6;
            return r10;
        L6:
            return this.f24958a.e(r10);
        }

        public final boolean f() {
            return !EmojiCompat.h();
        }
    }

    public f(TextView r10, boolean r11) {
        androidx.core.util.e.h(r10, "textView cannot be null");
        if (r11 == true) goto L5;
        this.f24954a = new c(r10);
        return;
    L5:
        this.f24954a = new a(r10);
    }

    public InputFilter[] a(InputFilter[] r10) {
        return this.f24954a.a(r10);
    }

    public boolean b() {
        return this.f24954a.b();
    }

    public void c(boolean r10) {
        this.f24954a.c(r10);
    }

    public void d(boolean r10) {
        this.f24954a.d(r10);
    }

    public TransformationMethod e(TransformationMethod r10) {
        return this.f24954a.e(r10);
    }
}
