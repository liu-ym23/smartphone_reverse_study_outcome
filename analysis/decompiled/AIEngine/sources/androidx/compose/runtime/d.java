package androidx.compose.runtime;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface d {
    long getLongValue();

    default Long getValue() {
        return Long.valueOf(getLongValue());
    }

    void setLongValue(long j10);

    /* bridge */ /* synthetic */ default void setValue(Object obj) {
        setValue(((Number) obj).longValue());
    }

    default void setValue(long j10) {
        setLongValue(j10);
    }
}
