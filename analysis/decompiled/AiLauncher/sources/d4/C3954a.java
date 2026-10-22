package d4;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.chatcore.session.AgentFrameworkConfig;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.agentframework.chatui.ToolNameMapping;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ld4/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatcore/session/a;", "config", "", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "apiTypes", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lcom/stepos/agentframework/chatcore/session/a;Ljava/util/List;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: d4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3954a {
    public static final C3954a INSTANCE = new C3954a();

    public final void a(Context context, AgentFrameworkConfig config, List<? extends ApiType> apiTypes) {
        p.i(context, "context");
        p.i(config, "config");
        p.i(apiTypes, "apiTypes");
        ChatCoreSdk.INSTANCE.e(context, config, apiTypes);
        ToolNameMapping.INSTANCE.f();
        A4.b.INSTANCE.a().i();
        ApiManager.INSTANCE.s0();
        O6.a.INSTANCE.d(context);
    }
}
