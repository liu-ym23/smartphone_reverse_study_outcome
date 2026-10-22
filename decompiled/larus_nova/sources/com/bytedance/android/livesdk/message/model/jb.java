package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.linker.BattleStarActivityGradeMedal;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001!R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/message/model/jb;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getGiftAssetId", "()I", "giftAssetId", "", "getEffectOpen", "()Z", "effectOpen", "getRankType", "rankType", "getRank", "rank", "", "getScheme", "()Ljava/lang/String;", "scheme", "Lpy/k;", "getAssetImage", "()Lpy/k;", "assetImage", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BattleStarActivityGradeMedal;", "getGradeMedal", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BattleStarActivityGradeMedal;", "gradeMedal", "Lcom/bytedance/android/live/base/model/message/a5;", "getText", "()Lcom/bytedance/android/live/base/model/message/a5;", "text", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface jb extends vh7.c<jb>, yh6.c {
    public static final a Companion = null;
    public static final int FANS_RANK_LIST_AWARD = 100;
    public static final int HOUR_AWARD = 12;
    public static final int HOUR_CHALLENGE_AWARD = 10000;
    public static final int PK_ACTIVITY_AWARD = 101;
    public static final int REGION_AWARD = 18;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153658a = null;

        public a() {
        }

        static {
            f153658a = new a();
        }
    }

    static {
        Companion = a.f153658a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    py.k getAssetImage();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    boolean getEffectOpen();

    int getGiftAssetId();

    BattleStarActivityGradeMedal getGradeMedal();

    int getRank();

    int getRankType();

    String getScheme();

    com.bytedance.android.live.base.model.message.a5 getText();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
