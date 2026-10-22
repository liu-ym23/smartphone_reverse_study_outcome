package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x0 extends IllegalArgumentException {
    public x0(x1 x1Var) {
        super("'" + x1Var + "' is not an absolute name");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(String message) {
        super(message);
        kotlin.jvm.internal.p.e(message, "message");
    }
}
