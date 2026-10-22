package bc2;

import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tlc.f;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final f b(LiveWsMessage r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        ArrayList r100 = new ArrayList();
        if (r110.getMsgHeaders() == null) goto L12;
        Iterator<LiveWsMessage.MsgHeader> r101 = r110.getMsgHeaders().iterator();
    L9:
        if (r101.hasNext() == false) goto L12;
        LiveWsMessage.MsgHeader r102 = r101.next();
        r100.add(new com.ss.ugc.live.sdk.msg.network.d(r102.getKey(), r102.getValue()));
    L12:
        return new f(r110.getService(), r110.getMethod(), r110.getPayloadType(), r110.getPayloadEncoding(), r110.getPayload(), r100, r110.getLogId(), r110.getSeqId());
    }

    public static tlc.d a(vlc.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getLatestWRDSMessage");
        Intrinsics.checkNotNullParameter(r101, "messageMethod");
        if ((r100 instanceof xlc.a) == true) goto L5;
        r100 = null;
    L5:
        xlc.a r102 = (xlc.a) r100;
        if (r102 == null) goto L8;
        tlc.d r103 = r102.e(r101, null);
    L10:
        if ((r103 instanceof tlc.d) == true) goto L13;
        return null;
    L13:
        return r103;
    L8:
        r103 = null;
        goto L10
    }
}
