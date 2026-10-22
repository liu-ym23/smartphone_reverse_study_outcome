package com.bytedance.android.livesdk.performance.aapleasure;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/performance/aapleasure/StrategyScene;", "", "Lcom/bytedance/android/livesdk/performance/aapleasure/Level;", "level", "", "setActiveLevel", "getActiveLevel", "", "permission", "setPermission", "getPermission", "", "label", "type", "", "checkPermission", "activeLevel", "Lcom/bytedance/android/livesdk/performance/aapleasure/Level;", "I", BuyNowCloseMethod.MASK, "Ljava/lang/String;", "getMask", "()Ljava/lang/String;", "preview", "experience", BatteryTypeInf.BATTERY_POWER_LOCK, "enhance", "shell_temperature", "sleep_mode", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StrategyScene extends Enum<StrategyScene> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StrategyScene[] f154413a = null;
    public static final StrategyScene enhance = null;
    public static final StrategyScene experience = null;
    public static final StrategyScene power = null;
    public static final StrategyScene preview = null;
    public static final StrategyScene shell_temperature = null;
    public static final StrategyScene sleep_mode = null;
    private Level activeLevel;
    private final String mask;
    private int permission;

    static {
        StrategyScene r100 = new StrategyScene("preview", 0, "preview");
        preview = r100;
        StrategyScene r101 = new StrategyScene("experience", 1, "experience");
        experience = r101;
        StrategyScene r102 = new StrategyScene(BatteryTypeInf.BATTERY_POWER_LOCK, 2, BatteryTypeInf.BATTERY_POWER_LOCK);
        power = r102;
        StrategyScene r103 = new StrategyScene("enhance", 3, "enhance");
        enhance = r103;
        StrategyScene r104 = new StrategyScene("shell_temperature", 4, "shell_temperature");
        shell_temperature = r104;
        StrategyScene r105 = new StrategyScene("sleep_mode", 5, "sleep_mode");
        sleep_mode = r105;
        f154413a = new StrategyScene[]{r100, r101, r102, r103, r104, r105};
    }

    public static StrategyScene valueOf(String r100) {
        return (StrategyScene) r27.a.a(StrategyScene.class, r100);
    }

    public static StrategyScene[] values() {
        return (StrategyScene[]) f154413a.clone();
    }

    public final Level getActiveLevel() {
        return this.activeLevel;
    }

    public final String getMask() {
        return this.mask;
    }

    public final int getPermission() {
        return this.permission;
    }

    public final void setActiveLevel(Level r100) {
        Intrinsics.checkNotNullParameter(r100, "level");
        this.activeLevel = r100;
    }

    public final void setPermission(int r100) {
        this.permission = r100;
    }

    public final boolean checkPermission(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "label");
        if (Intrinsics.areEqual(this.mask, "experience") == true) goto L7;
        if (Intrinsics.areEqual(this.mask, "shell_temperature") == true) goto L7;
    L35:
        return true;
    L7:
        if ("2".equals(r101) == false) goto L9;
        return true;
    L9:
        int r102 = this.permission;
        if (r102 != 0) goto L12;
        return false;
    L12:
        if (r102 != 1) goto L15;
        return true;
    L15:
        if (r102 != 2) goto L21;
        if ("1".equals(r101) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (r102 != 3) goto L27;
        if ("3".equals(r101) == false) goto L25;
        return false;
    L25:
        return true;
    L27:
        if (r102 != 4) goto L35;
        if ("1".equals(r101) == false) goto L31;
    L34:
        return false;
    L31:
        if ("3".equals(r101) == true) goto L34;
        return true;
    }

    public StrategyScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.mask = r102;
        this.activeLevel = Level.Normal;
        this.permission = 1;
    }
}
