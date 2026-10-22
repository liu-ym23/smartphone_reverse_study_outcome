package android.net.ipmemorystore;

/* JADX INFO: loaded from: classes.dex */
public interface OnSameL3NetworkResponseListener {
    void onSameL3NetworkResponse(Status r1, SameL3NetworkResponse r2);

    static IOnSameL3NetworkResponseListener toAIDL(final OnSameL3NetworkResponseListener listener) {
        return new AnonymousClass1(listener);
    }
}
