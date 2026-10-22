package android.net.ipmemorystore;

/* JADX INFO: loaded from: classes.dex */
public interface OnL2KeyResponseListener {
    void onL2KeyResponse(Status r1, String r2);

    static IOnL2KeyResponseListener toAIDL(final OnL2KeyResponseListener listener) {
        return new AnonymousClass1(listener);
    }
}
