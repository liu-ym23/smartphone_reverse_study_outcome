package b4;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class a extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String message, int i8) {
        super("Bad Content-Type format: ".concat(message));
        switch (i8) {
            case 2:
                p.e(message, "message");
                super(message);
                break;
            default:
                p.e(message, "value");
                break;
        }
    }
}
