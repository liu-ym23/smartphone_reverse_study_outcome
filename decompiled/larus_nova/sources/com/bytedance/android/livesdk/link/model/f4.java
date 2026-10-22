package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/f4;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/link/model/g4;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f4 extends vh7.c<f4>, g4 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ py.k getBarAuraIcon();

    /* synthetic */ py.k getBarIcon();

    /* synthetic */ py.k getBarMinIcon();

    /* synthetic */ String getEffectName();

    /* synthetic */ IBaseUser getEffectSender();

    /* synthetic */ int getEffectSource();

    /* synthetic */ int getEffectType();

    /* synthetic */ long getEndTime();

    /* synthetic */ long getInsertTime();

    /* synthetic */ long getStartTime();

    /* synthetic */ String getString();

    /* synthetic */ void setEffectName(String r100);
}
