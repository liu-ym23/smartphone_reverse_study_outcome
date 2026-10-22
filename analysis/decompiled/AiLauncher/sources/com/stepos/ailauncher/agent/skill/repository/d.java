package com.stepos.ailauncher.agent.skill.repository;

import Z8.C1174w;
import b5.PagedSkillResponse;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.InstallKind;
import com.stepos.ailauncher.agent.skill.InstallSource;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lb5/d;", Const.INTENT_KEY_PKGNAME, "(Lb5/d;)Lb5/d;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "c", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)Lcom/stepos/ailauncher/agent/skill/SkillItem;", "", "TAG", "Ljava/lang/String;", "agent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private static final String TAG = "SkillApi";

    public static final PagedSkillResponse b(PagedSkillResponse pagedSkillResponse) {
        ArrayList arrayList;
        p.i(pagedSkillResponse, "<this>");
        List<SkillItem> listD = pagedSkillResponse.d();
        if (listD != null) {
            List<SkillItem> list = listD;
            arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(c((SkillItem) it.next()));
            }
        } else {
            arrayList = null;
        }
        return PagedSkillResponse.b(pagedSkillResponse, arrayList, 0, false, null, 14, null);
    }

    public static final SkillItem c(SkillItem skillItem) {
        InstallKind installKind = skillItem.getInstallKind();
        if (installKind == null) {
            installKind = InstallKind.SKILL;
        }
        InstallKind installKind2 = installKind;
        InstallSource installSource = skillItem.getInstallSource();
        if (installSource == null) {
            installSource = InstallSource.CLOUD;
        }
        InstallSource installSource2 = installSource;
        SkillStatus status = skillItem.getStatus();
        if (status == null) {
            status = SkillStatus.UNINSTALLED;
        }
        return SkillItem.copy$default(skillItem, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, status, null, installSource2, installKind2, null, Integer.MAX_VALUE, 9, null);
    }
}
