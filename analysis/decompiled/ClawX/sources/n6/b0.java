package n6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b0 {
    public abstract void onClosed(a0 a0Var, int i8, String str);

    public void onClosing(a0 webSocket, int i8, String reason) {
        kotlin.jvm.internal.p.e(webSocket, "webSocket");
        kotlin.jvm.internal.p.e(reason, "reason");
    }

    public abstract void onFailure(a0 a0Var, Throwable th, u uVar);

    public void onMessage(a0 webSocket, c7.i bytes) {
        kotlin.jvm.internal.p.e(webSocket, "webSocket");
        kotlin.jvm.internal.p.e(bytes, "bytes");
    }

    public abstract void onMessage(a0 a0Var, String str);

    public abstract void onOpen(a0 a0Var, u uVar);
}
