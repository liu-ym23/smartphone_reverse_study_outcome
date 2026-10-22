package d5;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.skill.feishu.C2311g;
import com.stepos.ailauncher.agent.aispace.skill.wecom.C2331b;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.adapter.DisplayScope;
import com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity;
import h8.C4148a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Ld5/e;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "", "testing", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "sourceScope", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lcom/stepos/ailauncher/agent/skill/SkillItem;ZLcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;)V", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "", "lastClickTsMs", "J", "Companion", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    private static final long MIN_CLICK_INTERVAL_MS = 500;
    private final String TAG = "JumpHelper";
    private long lastClickTsMs;

    public static /* synthetic */ void b(e eVar, Context context, SkillItem skillItem, boolean z10, DisplayScope displayScope, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            displayScope = null;
        }
        eVar.a(context, skillItem, z10, displayScope);
    }

    public final void a(Context context, SkillItem item, boolean testing, DisplayScope sourceScope) {
        p.i(context, "context");
        p.i(item, "item");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = jCurrentTimeMillis - this.lastClickTsMs;
        if (j10 < 500) {
            C4148a.d(this.TAG, "clickCard blocked by debounce dt=" + j10 + "ms id=" + item.getIdentifier(), false, 4, null);
            return;
        }
        this.lastClickTsMs = jCurrentTimeMillis;
        String identifier = item.getIdentifier();
        if (p.d(identifier, "lark-cli")) {
            C4148a.d(this.TAG, "onCardClick feishu cli", false, 4, null);
            C2311g.INSTANCE.c(context);
        } else {
            if (!p.d(identifier, "wecom-cli")) {
                SkillDetailActivity.INSTANCE.a(context, item.getIdentifier(), item.getDisplayName(), item.getSummary(), item, testing, sourceScope);
                return;
            }
            String str = this.TAG;
            y yVar = y.f34840a;
            String str2 = String.format("onCardClick wecom cli status=%s", Arrays.copyOf(new Object[]{item.getStatus()}, 1));
            p.h(str2, "format(...)");
            C4148a.d(str, str2, false, 4, null);
            C2331b.INSTANCE.c(context, item.getStatus());
        }
    }
}
