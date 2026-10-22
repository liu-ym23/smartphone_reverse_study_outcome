package c4;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends ac.a {

    /* renamed from: g, reason: collision with root package name */
    public TextView f2199g;

    /* renamed from: h, reason: collision with root package name */
    public d f2200h;
    public boolean i;

    @Override // ac.a
    public final boolean B() {
        return this.i;
    }

    @Override // ac.a
    public final void S(boolean z10) {
        if (z10) {
            TextView textView = this.f2199g;
            textView.setTransformationMethod(k0(textView.getTransformationMethod()));
        }
    }

    @Override // ac.a
    public final void T(boolean z10) {
        this.i = z10;
        TextView textView = this.f2199g;
        textView.setTransformationMethod(k0(textView.getTransformationMethod()));
        textView.setFilters(w(textView.getFilters()));
    }

    @Override // ac.a
    public final TransformationMethod k0(TransformationMethod transformationMethod) {
        if (!this.i) {
            return transformationMethod instanceof j ? ((j) transformationMethod).f2206c : transformationMethod;
        }
        if ((transformationMethod instanceof j) || (transformationMethod instanceof PasswordTransformationMethod)) {
            return transformationMethod;
        }
        j jVar = new j();
        jVar.f2206c = transformationMethod;
        VarHandle.storeStoreFence();
        return jVar;
    }

    @Override // ac.a
    public final InputFilter[] w(InputFilter[] inputFilterArr) {
        if (this.i) {
            d dVar = this.f2200h;
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == dVar) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = dVar;
            return inputFilterArr2;
        }
        SparseArray sparseArray = new SparseArray(1);
        for (int i = 0; i < inputFilterArr.length; i++) {
            InputFilter inputFilter2 = inputFilterArr[i];
            if (inputFilter2 instanceof d) {
                sparseArray.put(i, inputFilter2);
            }
        }
        if (sparseArray.size() == 0) {
            return inputFilterArr;
        }
        int length2 = inputFilterArr.length;
        InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length - sparseArray.size()];
        int i3 = 0;
        for (int i10 = 0; i10 < length2; i10++) {
            if (sparseArray.indexOfKey(i10) < 0) {
                inputFilterArr3[i3] = inputFilterArr[i10];
                i3++;
            }
        }
        return inputFilterArr3;
    }
}
