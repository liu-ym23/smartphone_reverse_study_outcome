package androidx.compose.runtime;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface a {
    double getDoubleValue();

    default Double getValue() {
        return Double.valueOf(getDoubleValue());
    }

    void setDoubleValue(double d8);

    /* bridge */ /* synthetic */ default void setValue(Object obj) {
        setValue(((Number) obj).doubleValue());
    }

    default void setValue(double d8) {
        setDoubleValue(d8);
    }
}
