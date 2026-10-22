package cf9;

import com.larus.im.internal.rtcsdk.MessageSendErrorCode;
import com.larus.im.internal.rtcsdk.MessageSendType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f23547a = 0;

    static {
    }

    public static d a(MessageSendErrorCode r100, MessageSendType r101) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r101, "type");
        return new d(r100.getCode(), r101);
    }
}
