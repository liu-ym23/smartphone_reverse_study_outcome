package android.net.ipmemorystore;

/* JADX INFO: loaded from: classes.dex */
public interface OnStatusListener {
    void onComplete(Status r1);

    static IOnStatusListener toAIDL(final OnStatusListener listener) {
        return new AnonymousClass1(listener);
    }
}
