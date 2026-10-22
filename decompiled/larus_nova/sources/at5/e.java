package at5;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.larkwebview.bridge.Message;
import com.bytedance.ee.larkwebview.bridge.Status;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class e {
    public e() {
    }

    public l a(Status r100, String r101, Object r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "callbackId");
        Intrinsics.checkNotNullParameter(r103, "extraStr");
        return null;
    }

    public Message b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return (Message) JSON.parseObject(r100, Message.class);
    }
}
