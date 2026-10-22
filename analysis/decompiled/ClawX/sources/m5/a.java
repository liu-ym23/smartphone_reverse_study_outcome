package m5;

import java.io.File;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends androidx.datastore.preferences.protobuf.k {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(File file) {
        super(file, null, "Cannot list files in a directory");
        p.e(file, "file");
    }
}
