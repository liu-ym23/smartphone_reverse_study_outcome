package k1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final b f9848a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f9849a;

        /* renamed from: b, reason: collision with root package name */
        public final d f9850b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f9851c = true;

        public a(TextView textView) {
            this.f9849a = textView;
            this.f9850b = new d(textView);
        }

        @Override // k1.f.b
        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.f9851c) {
                SparseArray sparseArray = new SparseArray(1);
                for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                    InputFilter inputFilter = inputFilterArr[i10];
                    if (inputFilter instanceof d) {
                        sparseArray.put(i10, inputFilter);
                    }
                }
                if (sparseArray.size() == 0) {
                    return inputFilterArr;
                }
                int length = inputFilterArr.length;
                InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
                int i11 = 0;
                for (int i12 = 0; i12 < length; i12++) {
                    if (sparseArray.indexOfKey(i12) < 0) {
                        inputFilterArr2[i11] = inputFilterArr[i12];
                        i11++;
                    }
                }
                return inputFilterArr2;
            }
            int length2 = inputFilterArr.length;
            int i13 = 0;
            while (true) {
                d dVar = this.f9850b;
                if (i13 >= length2) {
                    InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                    System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                    inputFilterArr3[length2] = dVar;
                    return inputFilterArr3;
                }
                if (inputFilterArr[i13] == dVar) {
                    return inputFilterArr;
                }
                i13++;
            }
        }

        @Override // k1.f.b
        public final boolean b() {
            return this.f9851c;
        }

        @Override // k1.f.b
        public final void c(boolean z) {
            if (z) {
                TextView textView = this.f9849a;
                textView.setTransformationMethod(e(textView.getTransformationMethod()));
            }
        }

        @Override // k1.f.b
        public final void d(boolean z) {
            this.f9851c = z;
            TextView textView = this.f9849a;
            textView.setTransformationMethod(e(textView.getTransformationMethod()));
            textView.setFilters(a(textView.getFilters()));
        }

        @Override // k1.f.b
        public final TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f9851c ? ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod) : transformationMethod instanceof h ? ((h) transformationMethod).f9857a : transformationMethod;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public void c(boolean z) {
            throw null;
        }

        public void d(boolean z) {
            throw null;
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            throw null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        public final a f9852a;

        public c(TextView textView) {
            this.f9852a = new a(textView);
        }

        @Override // k1.f.b
        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            return !(androidx.emoji2.text.d.f1927k != null) ? inputFilterArr : this.f9852a.a(inputFilterArr);
        }

        @Override // k1.f.b
        public final boolean b() {
            return this.f9852a.f9851c;
        }

        @Override // k1.f.b
        public final void c(boolean z) {
            if (androidx.emoji2.text.d.f1927k != null) {
                this.f9852a.c(z);
            }
        }

        @Override // k1.f.b
        public final void d(boolean z) {
            a aVar = this.f9852a;
            if (androidx.emoji2.text.d.f1927k != null) {
                aVar.d(z);
            } else {
                aVar.f9851c = z;
            }
        }

        @Override // k1.f.b
        public final TransformationMethod e(TransformationMethod transformationMethod) {
            return !(androidx.emoji2.text.d.f1927k != null) ? transformationMethod : this.f9852a.e(transformationMethod);
        }
    }

    public f(TextView textView) {
        this.f9848a = new c(textView);
    }
}
