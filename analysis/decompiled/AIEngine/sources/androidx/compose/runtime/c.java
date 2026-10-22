package androidx.compose.runtime;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface c {
    int getIntValue();

    default Integer getValue() {
        return Integer.valueOf(getIntValue());
    }

    void setIntValue(int i10);

    /* bridge */ /* synthetic */ default void setValue(Object obj) {
        setValue(((Number) obj).intValue());
    }

    default void setValue(int i10) {
        setIntValue(i10);
    }
}
