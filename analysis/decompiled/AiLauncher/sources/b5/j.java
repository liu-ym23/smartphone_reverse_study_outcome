package b5;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0015\u0010\r\u001a\u00020\n*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"", "", "c", "(J)Ljava/lang/String;", UxipConstants.f30680s, "unit", "suffix", Const.INTENT_KEY_APIKEY, "(JJLjava/lang/String;)Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)Z", ModelFlowMeta.KEY_HAS_UPDATE, "agent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    public static final String a(long j10, long j11, String str) {
        long j12 = j10 / (j11 / 10);
        if (j12 >= 100) {
            return (j10 / j11) + str;
        }
        long j13 = j12 / 10;
        long j14 = j12 % 10;
        if (j14 == 0) {
            return j13 + str;
        }
        return j13 + "." + j14 + str;
    }

    public static final boolean b(SkillItem skillItem) {
        p.i(skillItem, "<this>");
        return skillItem.getNeedUpdate() == 1;
    }

    public static final String c(long j10) {
        return j10 < 1000 ? String.valueOf(j10) : j10 < 1000000 ? a(j10, 1000L, "K") : j10 < 1000000000 ? a(j10, 1000000L, "M") : a(j10, 1000000000L, "B");
    }
}
