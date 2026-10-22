package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes17.dex */
public class FloatValueHolder {
    private float mValue;

    public FloatValueHolder() {
        this.mValue = 0.0f;
    }

    public float getValue() {
        return this.mValue;
    }

    public FloatValueHolder(float r100) {
        this.mValue = 0.0f;
        setValue(r100);
    }

    public void setValue(float r100) {
        this.mValue = r100;
    }
}
