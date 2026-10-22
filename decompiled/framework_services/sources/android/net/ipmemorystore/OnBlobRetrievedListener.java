package android.net.ipmemorystore;

/* JADX INFO: loaded from: classes.dex */
public interface OnBlobRetrievedListener {
    void onBlobRetrieved(Status r1, String r2, String r3, Blob r4);

    static IOnBlobRetrievedListener toAIDL(final OnBlobRetrievedListener listener) {
        return new AnonymousClass1(listener);
    }
}
