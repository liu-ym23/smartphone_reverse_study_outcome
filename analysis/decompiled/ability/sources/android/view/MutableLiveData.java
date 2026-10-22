package android.view;

/* loaded from: classes2.dex */
public class MutableLiveData<T> extends LiveData<T> {
    public MutableLiveData(T t9) {
        super(t9);
    }

    @Override // android.view.LiveData
    public void postValue(T t9) {
        super.postValue(t9);
    }

    @Override // android.view.LiveData
    public void setValue(T t9) {
        super.setValue(t9);
    }

    public MutableLiveData() {
    }
}
