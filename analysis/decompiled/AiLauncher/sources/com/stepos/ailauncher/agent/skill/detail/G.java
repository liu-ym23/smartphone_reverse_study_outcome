package com.stepos.ailauncher.agent.skill.detail;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/F;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/agent/skill/detail/F;)Ljava/lang/String;", "displayVersion", "agent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G {
    public static final String a(SkillDetailDto skillDetailDto) {
        kotlin.jvm.internal.p.i(skillDetailDto, "<this>");
        String installVersion = skillDetailDto.getInstallVersion();
        if (installVersion != null) {
            if (La.H.x0(installVersion)) {
                installVersion = null;
            }
            if (installVersion != null) {
                return installVersion;
            }
        }
        String version = skillDetailDto.getVersion();
        if (version == null || La.H.x0(version)) {
            return null;
        }
        return version;
    }
}
