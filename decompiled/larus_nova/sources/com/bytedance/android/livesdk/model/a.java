package com.bytedance.android.livesdk.model;

import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends BaseEmoji {
    public a(boolean r100) {
        setType(BaseEmoji.Type.DeleteEmoji);
        if (r100 == false) goto L5;
        setIconId(R.drawable.ttlive_emoji_vs_ic_input_delete);
        return;
    L5:
        setIconId(R.drawable.ttlive_emoji_ic_input_delete);
    }
}
