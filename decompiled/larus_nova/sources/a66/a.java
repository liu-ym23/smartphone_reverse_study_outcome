package a66;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.ies.xbridge.utils.g;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "x.publishEvent")
public final class a extends z56.a implements h {
    public a() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, v56.a r101, XBridgePlatformType r110) {
        z56.a.b r102 = (z56.a.b) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        String r111 = r102.getEventName();
        Map<String, ? extends Object> r103 = r102.getParams();
        Boolean r104 = r102.isBroadcast();
        boolean r105 = false;
        if (r104 == null) goto L5;
        boolean r106 = r104.booleanValue();
    L6:
        if (r111 != null) goto L8;
    L9:
        r105 = true;
    L11:
        if (r105 == false) goto L13;
        CompletionBlock.a.a(r101, -3, null, null, 6);
        return;
    L13:
        Number r107 = r102.getTimestamp();
        if ((r107 instanceof Number) == false) goto L17;
        double r108 = v56.c.c(r102.getTimestamp());
    L19:
        Event r109 = new Event(r111, (long) r108, null);
        r109.setMapParams(r103);
        r109.setBroadcast(r106);
        EventCenter.enqueueEvent(r109);
        int r112 = g.f249558a;
        r101.onSuccess((XBaseResultModel) g.c(z56.a.c.class), "");
        return;
    L17:
        if ((r107 instanceof Integer) == false) goto L20;
        r108 = v56.c.c(r102.getTimestamp());
        goto L19
    L20:
        CompletionBlock.a.a(r101, -3, null, null, 6);
        return;
    L8:
        if (r111.length() != 0) goto L11;
    L5:
        r106 = false;
        goto L6
    }
}
