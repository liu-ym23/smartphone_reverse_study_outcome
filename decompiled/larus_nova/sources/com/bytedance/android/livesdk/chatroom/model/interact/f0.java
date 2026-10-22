package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface f0 extends vh7.c<f0> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "cur_grade")
    z getCurGrade();

    @FieldName(name = "next_grade")
    z getNextGrade();

    @FieldName(name = "upgrade_score")
    long getUpgradeScore();

    @FieldName(name = "upgrade_score_str")
    String getUpgradeScoreStr();
}
