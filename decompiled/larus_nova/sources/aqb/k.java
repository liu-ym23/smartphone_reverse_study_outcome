package aqb;

import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class k {
    public k() {
    }

    public void a(Chat r100) {
        throw null;
    }

    public void b(Chat r100) {
        throw null;
    }

    public void c(Chat r100, Map<String, ? extends Chatter> r101) {
        throw null;
    }

    public void d(g1 r100) {
        throw null;
    }

    public void e(MessageInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "preMessageInfo");
    }

    public void f(PushMessageReactions r100) {
        throw null;
    }

    public void g(PushMessageReadStates r100) {
        Intrinsics.checkNotNullParameter(r100, "readStates");
    }

    public void h(ThreadTopic r100) {
        Intrinsics.checkNotNullParameter(r100, "threadTopic");
    }
}
