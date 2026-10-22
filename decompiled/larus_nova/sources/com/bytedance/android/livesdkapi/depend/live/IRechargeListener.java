package com.bytedance.android.livesdkapi.depend.live;

/* JADX INFO: loaded from: classes12.dex */
public interface IRechargeListener {
    public static final String KEY_CHARGE_REASON = "KEY_CHARGE_REASON";
    public static final String KEY_CHARGE_SCENE = "KEY_CHARGE_SCENE";
    public static final String KEY_FLAME_FROM = "flame_from";
    public static final String KEY_FULL_SCREEN = "KEY_FULL_SCREEN";
    public static final String KEY_REQUEST_PAGE = "KEY_REQUEST_PAGE";
    public static final String KEY_SHOW_TYPE = "KEY_SHOW_TYPE";
    public static final int RECHARGE_STATE_CANCEL = -1;
    public static final int RECHARGE_STATE_FAIL = 0;
    public static final int RECHARGE_STATE_SUCCESS = 1;

    void onRechargeState(int r100, int r101, long r102, Throwable r103);
}
