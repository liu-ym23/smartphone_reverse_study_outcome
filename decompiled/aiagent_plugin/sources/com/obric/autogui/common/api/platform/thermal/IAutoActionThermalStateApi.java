package com.obric.autogui.common.api.platform.thermal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IAutoActionThermalStateApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionThermalStateApi {

    /* JADX INFO: compiled from: IAutoActionThermalStateApi.kt */
    public static final class ThermalLevelState {
        private final long enteredTimestampMillis;
        private final AOThermalLevel level;

        public static /* synthetic */ ThermalLevelState copy$default(ThermalLevelState r0, AOThermalLevel r1, long r2, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.level;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.enteredTimestampMillis;
        L9:
            return r0.copy(r1, r2);
        }

        public final AOThermalLevel component1() {
            return this.level;
        }

        public final long component2() {
            return this.enteredTimestampMillis;
        }

        public final ThermalLevelState copy(AOThermalLevel r1, long r2) {
            o.e(r1, "level");
            return new ThermalLevelState(r1, r2);
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, ThermalLevelState.class) == true) goto L8;
            return false;
        L8:
            ThermalLevelState r8 = (ThermalLevelState) ZeusTransformUtils.preCheckCast(r7, ThermalLevelState.class, "com.obric.aiagent.plugin");
            if (this.level == r8.level) goto L12;
            return false;
        L12:
            if (this.enteredTimestampMillis == r8.enteredTimestampMillis) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.level.hashCode() * 31) + Long.hashCode(this.enteredTimestampMillis);
        }

        public String toString() {
            return "ThermalLevelState(level=" + this.level + ", enteredTimestampMillis=" + this.enteredTimestampMillis + ')';
        }

        public ThermalLevelState(AOThermalLevel r2, long r3) {
            o.e(r2, "level");
            this.level = r2;
            this.enteredTimestampMillis = r3;
        }

        public final AOThermalLevel getLevel() {
            return this.level;
        }

        public final long getEnteredTimestampMillis() {
            return this.enteredTimestampMillis;
        }
    }

    ThermalLevelState getThermalLevelState();

    void initThermalStateMonitor();

    void resetThermalState();
}
