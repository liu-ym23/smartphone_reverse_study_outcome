package a2b;

import android.content.Context;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.s;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public interface o {
    void H8(Context r100, AtUserGroupInfo r101);

    void La(Message r100);

    void c6(RichText r100, String r101);

    boolean isEnabled();

    void pe(Map<Long, UserGroupEntity> r100);

    void w9(s.c r100);

    void z1(s.c r100);
}
