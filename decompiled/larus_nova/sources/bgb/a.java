package bgb;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.k1;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.thread.TopicGroup;
import com.ss.android.lark.flow.bottomsheet.biz.replyinthread.ReplyInThreadFrameFragment;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements com.ss.android.lark.bottomsheet.fragment.a.c {
    public a() {
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final void a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final String clazz() {
        return FlowReplyInThreadActivity.class.getName();
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final com.ss.android.lark.bottomsheet.fragment.a.b config() {
        return new com.ss.android.lark.bottomsheet.fragment.a.b(false);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final BottomSheetFrameFragment f() {
        return new ReplyInThreadFrameFragment();
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final Integer b() {
        return Integer.valueOf(R.color.flow_ud_static_black_transparent_1);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final void c(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        l1.a r102 = new l1.a();
        r102.f410298e = r101.getString("key_params_thread_id");
        r102.f410301h = (ThreadTopic) r101.getSerializable("key_params_thread");
        r102.f410296c = (Chat) r101.getSerializable("key_params_thread_chat");
        r102.f410294a = r101.getString("key_params_thread_source");
        r102.f410302i = (TopicGroup) r101.getSerializable("key_params_topic_group");
        r102.f410299f = r101.getInt("key_params_jump_position");
        r102.f410305l = r101.getString("key_params_chat_id");
        r102.f410306m = r101.getBoolean("key_params_is_from_card", false);
        String r103 = "";
        r102.f410303j = r101.getString("key_params_from", "");
        r102.f410307n = r101.getBoolean("key_params_has_create_thread", true);
        r102.f410308o = r101.getBoolean("key_params_show_chat_name", true);
        r102.f410309p = r101.getString("key_params_origin_merge_forward_message_id");
        r102.f410310q = r101.getInt("key_params_merge_forward_from_type", 0);
        r102.f410314u = r101.getString("key_params_root_message_id");
        r102.f410315v = r101.getString("key_params_auto_translate_target_lang_by_card", "");
        r102.f410316w = Boolean.valueOf(r101.getBoolean("key_bottom_sheet_container_start", false));
        r102.f410318y = r101.getString("key_params_preview_id");
        r102.f410319z = r101.getString("key_params_msg_link_token");
        r102.A = r101.getString("key_params_thread_source_type");
        r102.B = r101.getBoolean("is_embedded", false);
        Map<String, Message> r104 = k1.f410262a;
        String r105 = r101.getString("key_params_merge_forward_message_id");
        Map<String, Message> r106 = k1.f410262a;
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r102.f410311r = r106.remove(r105);
        String r107 = r101.getString("key_params_parent_message_content");
        Map<String, MergeForwardContent> r108 = k1.f410264c;
        if (r107 != null) goto L8;
        r107 = "";
    L8:
        r102.f410313t = r108.remove(r107);
        String r109 = r101.getString("key_params_root_message_id");
        Map<String, MessageInfo> r110 = k1.f410265d;
        if (r109 == null) goto L12;
        r103 = r109;
    L12:
        r102.f410317x = r110.remove(r103);
        whb.d.b(r100, null, new l1(r102));
    }
}
