package com.bytedance.android.live.profit.lottery;

import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public interface i extends dy0.d {
    public static final a B0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f88110a = null;

        public a() {
        }

        static {
            f88110a = new a();
        }
    }

    static {
        B0 = a.f88110a;
    }

    com.bytedance.live.datacontext.m<? extends ParticipateStatus> getCurCandidateState();

    com.bytedance.live.datacontext.n<? extends g> getCurrentLottery();

    o getLotteryPluginStore();

    com.bytedance.live.datacontext.k<LotteryState.b> getOnFinish();

    com.bytedance.live.datacontext.k<Unit> getOnHidePanel();

    com.bytedance.live.datacontext.k<Integer> getOnIconClick();

    com.bytedance.live.datacontext.k<JSONObject> getOnPopupSchemaFailed();

    com.bytedance.live.datacontext.k<Unit> getOnToolbarButtonClick();
}
