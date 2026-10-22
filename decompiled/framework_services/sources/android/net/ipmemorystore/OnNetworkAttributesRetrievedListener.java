package android.net.ipmemorystore;

/* JADX INFO: loaded from: classes.dex */
public interface OnNetworkAttributesRetrievedListener {
    void onNetworkAttributesRetrieved(Status r1, String r2, NetworkAttributes r3);

    static IOnNetworkAttributesRetrievedListener toAIDL(final OnNetworkAttributesRetrievedListener listener) {
        return new AnonymousClass1(listener);
    }
}
