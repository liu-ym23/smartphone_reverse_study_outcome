package d8;

import java.util.function.IntUnaryOperator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class j0 implements IntUnaryOperator {
    @Override // java.util.function.IntUnaryOperator
    public final int applyAsInt(int i8) {
        if (i8 > 0) {
            return (int) Math.log(i8);
        }
        return 0;
    }
}
