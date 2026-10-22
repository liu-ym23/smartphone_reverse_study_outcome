package com.obric.aiagent.skill.manager.impl.ui;

import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillCardListItemBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public static final void a(OCardListItem r7) {
        d.h.b.o.e(r7, "<this>");
        int[] r1 = {ZeusTransformUtils.mapRes(R.id.skill_item_content, DbHelper.COL_ID, "skill_item_content"), ZeusTransformUtils.mapRes(R.id.skill_icon_box, DbHelper.COL_ID, "skill_icon_box"), ZeusTransformUtils.mapRes(R.id.skill_texts, DbHelper.COL_ID, "skill_texts"), ZeusTransformUtils.mapRes(R.id.skill_source_row, DbHelper.COL_ID, "skill_source_row"), ZeusTransformUtils.mapRes(R.id.skill_source_avatar_box, DbHelper.COL_ID, "skill_source_avatar_box"), ZeusTransformUtils.mapRes(R.id.skill_action_slot, DbHelper.COL_ID, "skill_action_slot")};
        int r2 = 0;
    L3:
        if (r2 >= 6) goto L11;
        View r3 = r7.findViewById(r1[r2]);
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.common.style.a.class) == false) goto L7;
        com.obric.oui.common.style.a r4 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
    L8:
        if (r4 == null) goto L10;
        r4.setChangeAlphaWhenPress(false);
    L10:
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = null;
        goto L8
    }

    public static final void a(OCardListItem r5, int r6, int r7) {
        d.h.b.o.e(r5, "<this>");
        r5.customDivider(a(r5, 76.0f), a(r5, 20.0f));
        boolean r1 = false;
        if (r7 > 1) goto L5;
        int r3 = 0;
    L11:
        OCardListItem.setCardPosition$default(r5, r3, false, 2, null);
        if (r7 > 1) goto L14;
    L16:
        r5.showDivider(r1);
        return;
    L14:
        if (r6 >= (r7 - 1)) goto L16;
        r1 = true;
        goto L16
    L5:
        if (r6 != 0) goto L8;
        r3 = 1;
        goto L11
    L8:
        if (r6 != (r7 - 1)) goto L10;
        r3 = 3;
        goto L11
    L10:
        r3 = 2;
        goto L11
    }

    private static final int a(OCardListItem r1, float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f);
    }
}
