package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0012\fB\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel$Code;", "b", "(Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel$Code;)V", "Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel$a;", "data", "Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel$a;", "c", "(Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel$a;)V", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class GetDeviceStatsResultModel implements e7.k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements e7.j0 {
        public static final Code Failed = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f38463a = null;
        private final int value;

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f38463a.clone();
        }

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            f38463a = new Code[]{r100, r101};
        }

        @Override // e7.j0
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/GetDeviceStatsResultModel$a;", "", "", "memory_rest", "Ljava/lang/Number;", "getMemory_rest", "()Ljava/lang/Number;", "d", "(Ljava/lang/Number;)V", "cpu_usage", "getCpu_usage", "b", IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, "getTemperature", "e", "fps", "getFps", "c", "batteryLevel", "getBatteryLevel", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("batteryLevel")
        private Number batteryLevel;

        @SerializedName("cpu_usage")
        private Number cpu_usage;

        @SerializedName("fps")
        private Number fps;

        @SerializedName("memory_rest")
        private Number memory_rest;

        @SerializedName(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE)
        private Number temperature;

        public a() {
        }

        public final void a(Number r100) {
            this.batteryLevel = r100;
        }

        public final void b(Number r100) {
            this.cpu_usage = r100;
        }

        public final void c(Number r100) {
            this.fps = r100;
        }

        public final void d(Number r100) {
            this.memory_rest = r100;
        }

        public final void e(Number r100) {
            this.temperature = r100;
        }
    }

    public GetDeviceStatsResultModel() {
    }

    public final a a() {
        return this.data;
    }

    public final void b(Code r100) {
        this.code = r100;
    }

    public final void c(a r100) {
        this.data = r100;
    }
}
