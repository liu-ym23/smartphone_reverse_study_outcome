package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/m1;", "Lvh7/c;", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m1 extends vh7.c<m1> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ String getThemeDescription();

    /* synthetic */ long getThemeId();

    /* synthetic */ String getThemeTitle();

    /* synthetic */ int getThemeType();

    /* synthetic */ void setThemeDescription(String r100);

    /* synthetic */ void setThemeId(long r100);

    /* synthetic */ void setThemeTitle(String r100);

    /* synthetic */ void setThemeType(int r100);
}
