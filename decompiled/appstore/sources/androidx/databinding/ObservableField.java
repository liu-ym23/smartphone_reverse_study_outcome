package androidx.databinding;

import androidx.annotation.Nullable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableField<T> extends b implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField(T r10) {
        this.mValue = r10;
    }

    @Nullable
    public T get() {
        return this.mValue;
    }

    public void set(T r10) {
        if (r10 == this.mValue) goto L6;
        this.mValue = r10;
        notifyChange();
        return;
    }

    public ObservableField() {
    }

    public ObservableField(Observable... r10) {
        super(r10);
    }
}
