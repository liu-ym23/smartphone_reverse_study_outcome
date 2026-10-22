package aqb;

import com.bytedance.lark.pb.im.v1.DoubaoTyping;
import com.bytedance.lark.pb.im.v1.PushDoubaoSmartReply;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import m6b.o;

/* JADX INFO: loaded from: classes36.dex */
public class a implements o {
    public a() {
    }

    @Override // m6b.o
    public void a(g1 r100) {
        Intrinsics.checkNotNullParameter(r100, "pushMessageDTO");
    }

    @Override // m6b.o
    public void b(PushMessageReadStates r100) {
        Intrinsics.checkNotNullParameter(r100, "readStates");
    }

    @Override // m6b.o
    public void c(MessageInfo r100) {
    }

    @Override // m6b.o
    public void e(DoubaoTyping r100) {
        Intrinsics.checkNotNullParameter(r100, "doubaoTyping");
    }

    @Override // m6b.o
    public void f(PushMessageReactions r100) {
        Intrinsics.checkNotNullParameter(r100, "reactions");
    }

    @Override // m6b.o
    public void g(Chat r100, Map<String, ? extends Chatter> r101) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        Intrinsics.checkNotNullParameter(r101, "chatterMap");
    }

    @Override // m6b.o
    public void h(Chat r100, Map<String, ? extends Chatter> r101) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        Intrinsics.checkNotNullParameter(r101, "chatterMap");
    }

    @Override // m6b.o
    public void i(Chat r100, Map<String, ? extends Chatter> r101) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        Intrinsics.checkNotNullParameter(r101, "chatterMap");
    }

    @Override // m6b.o
    public void onPushChat(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "chat");
    }

    @Override // m6b.o
    public void onPushChatRemoveMe(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "chat");
    }

    @Override // m6b.o
    public void onPushThreadTopic(ThreadTopic r100) {
        Intrinsics.checkNotNullParameter(r100, "threadTopic");
    }

    @Override // m6b.o
    public void d(PushDoubaoSmartReply r100) {
        Intrinsics.checkNotNullParameter(r100, "push");
    }
}
