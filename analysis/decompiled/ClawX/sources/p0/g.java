package p0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import k4.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends z {

    /* renamed from: b, reason: collision with root package name */
    public final TextView f4654b;

    /* renamed from: c, reason: collision with root package name */
    public final e f4655c;
    public boolean d = true;

    public g(TextView textView) {
        this.f4654b = textView;
        this.f4655c = new e(textView);
    }

    @Override // k4.z
    public final void G(boolean z) {
        if (z) {
            L();
        }
    }

    @Override // k4.z
    public final void H(boolean z) {
        this.d = z;
        L();
        TextView textView = this.f4654b;
        textView.setFilters(v(textView.getFilters()));
    }

    public final void L() {
        TextView textView = this.f4654b;
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (this.d) {
            if (!(transformationMethod instanceof k) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                transformationMethod = new k(transformationMethod);
            }
        } else if (transformationMethod instanceof k) {
            transformationMethod = ((k) transformationMethod).f4661a;
        }
        textView.setTransformationMethod(transformationMethod);
    }

    @Override // k4.z
    public final InputFilter[] v(InputFilter[] inputFilterArr) {
        if (!this.d) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i8 = 0; i8 < inputFilterArr.length; i8++) {
                InputFilter inputFilter = inputFilterArr[i8];
                if (inputFilter instanceof e) {
                    sparseArray.put(i8, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i9 = 0;
            for (int i10 = 0; i10 < length; i10++) {
                if (sparseArray.indexOfKey(i10) < 0) {
                    inputFilterArr2[i9] = inputFilterArr[i10];
                    i9++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i11 = 0;
        while (true) {
            e eVar = this.f4655c;
            if (i11 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = eVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i11] == eVar) {
                return inputFilterArr;
            }
            i11++;
        }
    }
}
