package com.android.ttcjpaysdk.base.utils;

import com.android.ttcjpaysdk.base.timer.CJPayTimer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayCountDownTimeUtil {
    private static CJPayCountDownTimeUtil instance;
    private Map<String, CJPayTimer> countDownTimerMap;

    public interface OnTickListener {
        void notContain();

        void onFinish();

        void onTick(long r100);
    }

    static {
        instance = new CJPayCountDownTimeUtil();
    }

    private CJPayCountDownTimeUtil() {
        this.countDownTimerMap = new HashMap();
    }

    public static CJPayCountDownTimeUtil getInstance() {
        return instance;
    }

    public static /* synthetic */ Map access$000(CJPayCountDownTimeUtil r100) {
        return r100.countDownTimerMap;
    }

    public void cancel(String r100) {
        if (this.countDownTimerMap.containsKey(r100) == false) goto L6;
        this.countDownTimerMap.get(r100).cancel();
        this.countDownTimerMap.remove(r100);
        return;
    }

    public boolean checkCountDownTimer(final String r100, final OnTickListener r101) {
        if (this.countDownTimerMap.containsKey(r100) == false) goto L7;
        if (r101 == null) goto L6;
        this.countDownTimerMap.get(r100).setTickListener(new AnonymousClass2(this, r101, r100));
    L6:
        return true;
    L7:
        if (r101 == null) goto L9;
        r101.notContain();
    L9:
        return false;
    }

    public CJPayTimer putCountDownTimer(final String r100, long r101, long r102, final OnTickListener r103) {
        CJPayTimer r104 = new CJPayTimer(r101, r102);
        this.countDownTimerMap.put(r100, r104);
        r104.start();
        r104.setTickListener(new AnonymousClass1(this, r103, r100));
        return r104;
    }
}
