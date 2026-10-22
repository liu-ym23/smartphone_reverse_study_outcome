package S1;

import android.text.Editable;
import android.text.TextWatcher;

/* loaded from: classes.dex */
public class b implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    private final Q1.b<Editable> f5229a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Q1.b<Editable> f5230a;

        /* JADX WARN: Multi-variable type inference failed */
        public b a() {
            return new b(null, 0 == true ? 1 : 0, this.f5230a);
        }

        public a b(Q1.b<Editable> bVar) {
            this.f5230a = bVar;
            return this;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Q1.b<Editable> bVar = this.f5229a;
        if (bVar != null) {
            bVar.accept(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    private b(Q1.a<CharSequence, Integer, Integer, Integer> aVar, Q1.a<CharSequence, Integer, Integer, Integer> aVar2, Q1.b<Editable> bVar) {
        this.f5229a = bVar;
    }
}
