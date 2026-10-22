package com.stepos.ailauncher.chat.fragment;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)Ljava/lang/String;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E0 {
    public static final String b(SkillItemBrief skillItemBrief) {
        String id = skillItemBrief.getId();
        if (id != null) {
            if (La.H.x0(id)) {
                id = null;
            }
            if (id != null) {
                return id;
            }
        }
        String name = skillItemBrief.getName();
        return name == null ? "" : name;
    }
}
