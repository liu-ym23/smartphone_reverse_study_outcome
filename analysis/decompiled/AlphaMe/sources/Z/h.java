package Z;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class h extends y1.f {

    /* renamed from: c, reason: collision with root package name */
    public final TextView f2138c;

    /* renamed from: d, reason: collision with root package name */
    public final f f2139d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2140e;

    public h(TextView textView) {
        super(20);
        this.f2138c = textView;
        this.f2140e = true;
        this.f2139d = new f(textView);
    }

    @Override // y1.f
    public final InputFilter[] h(InputFilter[] inputFilterArr) {
        if (!this.f2140e) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i4 = 0; i4 < inputFilterArr.length; i4++) {
                InputFilter inputFilter = inputFilterArr[i4];
                if (inputFilter instanceof f) {
                    sparseArray.put(i4, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (sparseArray.indexOfKey(i6) < 0) {
                    inputFilterArr2[i5] = inputFilterArr[i6];
                    i5++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i7 = 0;
        while (true) {
            f fVar = this.f2139d;
            if (i7 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = fVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i7] == fVar) {
                return inputFilterArr;
            }
            i7++;
        }
    }

    @Override // y1.f
    public final boolean k() {
        return this.f2140e;
    }

    @Override // y1.f
    public final void m(boolean z4) {
        if (z4) {
            TextView textView = this.f2138c;
            textView.setTransformationMethod(q(textView.getTransformationMethod()));
        }
    }

    @Override // y1.f
    public final void n(boolean z4) {
        this.f2140e = z4;
        TextView textView = this.f2138c;
        textView.setTransformationMethod(q(textView.getTransformationMethod()));
        textView.setFilters(h(textView.getFilters()));
    }

    @Override // y1.f
    public final TransformationMethod q(TransformationMethod transformationMethod) {
        return this.f2140e ? ((transformationMethod instanceof k) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new k(transformationMethod) : transformationMethod instanceof k ? ((k) transformationMethod).f2146a : transformationMethod;
    }
}
