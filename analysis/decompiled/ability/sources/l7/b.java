package l7;

/* loaded from: classes3.dex */
public interface b {
    void onBindFailed(String str);

    void onConnected();

    void onDisconnected();

    default void onRetrying(int i, int i6) {
    }
}
