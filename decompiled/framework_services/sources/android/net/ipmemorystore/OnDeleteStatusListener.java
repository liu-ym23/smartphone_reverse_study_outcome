package android.net.ipmemorystore;

/* JADX INFO: loaded from: classes.dex */
public interface OnDeleteStatusListener {
    void onComplete(Status r1, int r2);

    static IOnStatusAndCountListener toAIDL(final OnDeleteStatusListener listener) {
        return new AnonymousClass1(listener);
    }
}
