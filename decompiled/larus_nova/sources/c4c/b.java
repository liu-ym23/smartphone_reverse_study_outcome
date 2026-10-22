package c4c;

import com.bytedance.lark.pb.search.v1.TimeZone;
import com.bytedance.lark.pb.search.v2.BotMeta;
import com.bytedance.lark.pb.search.v2.SimpleP2PChatInfo;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public b() {
    }

    public static SearchChatterInfo a(BotMeta r100) {
        if (r100 == null) goto L10;
        SearchChatterInfo r101 = new SearchChatterInfo();
        r101.setChatterType(Chatter.ChatterType.BOT);
        r101.setChatterDescription(new ChatterDescription(r100.description, ChatterDescription.Type.valueOf(r100.description_flag.getValue())));
        SimpleP2PChatInfo r102 = r100.p2p_chat_info;
        if (r102 == null) goto L6;
        r101.setRemind(r102.is_remind.booleanValue());
        r101.setP2pChatId(r102.chat_id);
    L6:
        r101.setTenantId(r100.tenant_id);
        TimeZone r103 = r100.timezone;
        if (r103 == null) goto L9;
        r101.setTimeZoneId(r103.name);
    L9:
        r101.setBotId(r100.f253701id);
        r101.setBotExtType(r100.bot_ext_type.intValue());
        r101.setAgent(r100.is_agent.booleanValue());
        return r101;
    L10:
        return null;
    }
}
