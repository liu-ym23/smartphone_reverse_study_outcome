package R;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final b f4951a;

    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f4952a;

        /* renamed from: b, reason: collision with root package name */
        private final d f4953b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4954c = true;

        a(TextView textView) {
            this.f4952a = textView;
            this.f4953b = new d(textView);
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f4953b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f4953b;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> g(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i5 = 0; i5 < inputFilterArr.length; i5++) {
                InputFilter inputFilter = inputFilterArr[i5];
                if (inputFilter instanceof d) {
                    sparseArray.put(i5, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArrayG = g(inputFilterArr);
            if (sparseArrayG.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayG.size()];
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (sparseArrayG.indexOfKey(i6) < 0) {
                    inputFilterArr2[i5] = inputFilterArr[i6];
                    i5++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        private void k() {
            this.f4952a.setFilters(a(this.f4952a.getFilters()));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }

        @Override // R.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f4954c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // R.f.b
        public boolean b() {
            return this.f4954c;
        }

        @Override // R.f.b
        void c(boolean z5) {
            if (z5) {
                l();
            }
        }

        @Override // R.f.b
        void d(boolean z5) {
            this.f4954c = z5;
            l();
            k();
        }

        @Override // R.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f4954c ? m(transformationMethod) : j(transformationMethod);
        }

        void i(boolean z5) {
            this.f4954c = z5;
        }

        void l() {
            this.f4952a.setTransformationMethod(e(this.f4952a.getTransformationMethod()));
        }
    }

    static class b {
        b() {
        }

        InputFilter[] a(InputFilter[] inputFilterArr) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        void c(boolean z5) {
            throw null;
        }

        void d(boolean z5) {
            throw null;
        }

        TransformationMethod e(TransformationMethod transformationMethod) {
            throw null;
        }
    }

    private static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final a f4955a;

        c(TextView textView) {
            this.f4955a = new a(textView);
        }

        private boolean f() {
            return !androidx.emoji2.text.e.i();
        }

        @Override // R.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f4955a.a(inputFilterArr);
        }

        @Override // R.f.b
        public boolean b() {
            return this.f4955a.b();
        }

        @Override // R.f.b
        void c(boolean z5) {
            if (f()) {
                return;
            }
            this.f4955a.c(z5);
        }

        @Override // R.f.b
        void d(boolean z5) {
            if (f()) {
                this.f4955a.i(z5);
            } else {
                this.f4955a.d(z5);
            }
        }

        @Override // R.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f4955a.e(transformationMethod);
        }
    }

    public f(TextView textView, boolean z5) {
        D.h.f(textView, "textView cannot be null");
        if (z5) {
            this.f4951a = new a(textView);
        } else {
            this.f4951a = new c(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f4951a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f4951a.b();
    }

    public void c(boolean z5) {
        this.f4951a.c(z5);
    }

    public void d(boolean z5) {
        this.f4951a.d(z5);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f4951a.e(transformationMethod);
    }
}
