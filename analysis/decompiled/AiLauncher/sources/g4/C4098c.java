package g4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R6\u0010)\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00066"}, d2 = {"Lg4/c;", "", "<init>", "()V", "", "bot_id", "Ljava/lang/String;", "getBot_id", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "", "stream", "Z", "getStream", "()Z", "setStream", "(Z)V", "user_id", "getUser_id", "e", "auto_save_history", "Ljava/lang/Boolean;", "getAuto_save_history", "()Ljava/lang/Boolean;", "setAuto_save_history", "(Ljava/lang/Boolean;)V", "enable_card", "getEnable_card", "setEnable_card", "", "Lg4/i;", "additional_messages", "Ljava/util/List;", "getAdditional_messages", "()Ljava/util/List;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "Ljava/util/ArrayList;", "Lg4/k;", "Lkotlin/collections/ArrayList;", "tool_outputs", "Ljava/util/ArrayList;", "getTool_outputs", "()Ljava/util/ArrayList;", Const.INTENT_KEY_UMID, "(Ljava/util/ArrayList;)V", "Lg4/j;", SpriteEventAction.AGENT_THINKING_START, "Lg4/j;", "getThinking", "()Lg4/j;", "c", "(Lg4/j;)V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: g4.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4098c {
    private List<i> additional_messages;
    private Boolean enable_card;
    private Thinking thinking;
    private ArrayList<k> tool_outputs;
    private String bot_id = "";
    private boolean stream = true;
    private String user_id = "";
    private Boolean auto_save_history = Boolean.TRUE;

    public final void a(List<i> list) {
        this.additional_messages = list;
    }

    public final void b(String str) {
        this.bot_id = str;
    }

    public final void c(Thinking thinking) {
        this.thinking = thinking;
    }

    public final void d(ArrayList<k> arrayList) {
        this.tool_outputs = arrayList;
    }

    public final void e(String str) {
        this.user_id = str;
    }
}
