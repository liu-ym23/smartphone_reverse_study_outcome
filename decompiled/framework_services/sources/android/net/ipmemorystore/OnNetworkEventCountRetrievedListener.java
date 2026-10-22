package android.net.ipmemorystore;

/* JADX INFO: loaded from: classes.dex */
public interface OnNetworkEventCountRetrievedListener {
    void onNetworkEventCountRetrieved(Status r1, int[] r2);

    static IOnNetworkEventCountRetrievedListener toAIDL(final OnNetworkEventCountRetrievedListener listener) {
        return new AnonymousClass1(listener);
    }
}
