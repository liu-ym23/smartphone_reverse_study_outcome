package androidx.recyclerview.widget;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ListUpdateCallback {
    void onChanged(int i10, int i11, Object obj);

    void onInserted(int i10, int i11);

    void onMoved(int i10, int i11);

    void onRemoved(int i10, int i11);
}
