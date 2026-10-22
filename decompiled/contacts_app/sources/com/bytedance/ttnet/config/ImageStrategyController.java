package com.bytedance.ttnet.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.NetworkUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ImageStrategyController implements IImageStrategy {
    private static final String IMAGE_OPT_BLACK_INTERVAL = "image_opt_black_interval";
    private static final String IMAGE_OPT_FAILED_TIMES = "image_opt_failed_times";
    private static final String IMAGE_OPT_LIMIT_COUNT = "image_opt_limit_count";
    private static final String IMAGE_OPT_SWITCH = "image_opt_switch";
    private static final String IMAGE_SP_TABLE = "image_opt_table";
    private static final Object mLock = null;
    private static volatile ImageStrategyController sIns;
    private static volatile SharedPreferences sSP;
    private volatile long mBlackInterval;
    private volatile Context mContext;
    private volatile int mFailedTimes;
    private volatile int mLimitImageNumber;
    private volatile int mSwitch;

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public List<String> getUrlListForUrl(String r1) {
        return null;
    }

    static {
        mLock = new Object();
    }

    public static ImageStrategyController Init(Context r2) {
        if (sIns != null) goto L15;
        Object r0 = mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sIns != null) goto L9;
        sIns = new ImageStrategyController(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return sIns;
    }

    private ImageStrategyController(Context r1) {
        if (r1 == null) goto L5;
        this.mContext = r1.getApplicationContext();
    L5:
        initConfig();
    }

    public static ImageStrategyController getInstance() {
        return sIns;
    }

    private void initConfig() {
        SharedPreferences r0 = getSP();     // Catch: Throwable -> L4
        this.mSwitch = r0.getInt(IMAGE_OPT_SWITCH, 0);     // Catch: Throwable -> L4
        this.mBlackInterval = r0.getLong(IMAGE_OPT_BLACK_INTERVAL, 0);     // Catch: Throwable -> L4
        this.mFailedTimes = r0.getInt(IMAGE_OPT_FAILED_TIMES, 0);     // Catch: Throwable -> L4
        this.mLimitImageNumber = r0.getInt(IMAGE_OPT_LIMIT_COUNT, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void updateConfig(JSONObject r12) {
        if (r12 == null) goto L26;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r12.length() <= 0) goto L27;
        int r5 = r12.optInt(IMAGE_OPT_SWITCH, 0);     // Catch: Throwable -> L21
        long r6 = r12.optLong(IMAGE_OPT_BLACK_INTERVAL, 0);     // Catch: Throwable -> L21
        int r8 = r12.optInt(IMAGE_OPT_FAILED_TIMES, 0);     // Catch: Throwable -> L21
        int r13 = r12.optInt(IMAGE_OPT_LIMIT_COUNT, 0);     // Catch: Throwable -> L21
        SharedPreferences.Editor r4 = getSP().edit();     // Catch: Throwable -> L21
        if (r5 == this.mSwitch) goto L11;
        r4.putInt(IMAGE_OPT_SWITCH, r5);     // Catch: Throwable -> L21
    L11:
        if (r6 == this.mBlackInterval) goto L14;
        r4.putLong(IMAGE_OPT_BLACK_INTERVAL, r6);     // Catch: Throwable -> L21
    L14:
        if (r8 == this.mFailedTimes) goto L17;
        r4.putInt(IMAGE_OPT_FAILED_TIMES, r8);     // Catch: Throwable -> L21
    L17:
        if (r13 == this.mLimitImageNumber) goto L19;
        r4.putInt(IMAGE_OPT_LIMIT_COUNT, r13);     // Catch: Throwable -> L21
    L19:
        r4.apply();     // Catch: Throwable -> L21
        this.mSwitch = r5;     // Catch: Throwable -> L21
        this.mBlackInterval = r6;     // Catch: Throwable -> L21
        this.mFailedTimes = r8;     // Catch: Throwable -> L21
        this.mLimitImageNumber = r13;     // Catch: Throwable -> L21
        return;
    L27:
        return;
    }

    private SharedPreferences getSP() {
        if (sSP != null) goto L6;
        sSP = this.mContext.getSharedPreferences(IMAGE_SP_TABLE, 0);
    L6:
        return sSP;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getSwitch() {
        return this.mSwitch;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public long getHostInBlackInterval() {
        return this.mBlackInterval;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getFailedTimes() {
        return this.mFailedTimes;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getLimitImageNumbers() {
        return this.mLimitImageNumber;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public NetworkUtils.NetworkType getNetWorkType() {
        return NetworkUtils.getNetworkType(this.mContext);
    }
}
