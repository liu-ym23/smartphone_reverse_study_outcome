package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0007\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00060\tR\u00020\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/i2;", "", "", "enable", "Z", "getEnable", "()Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Z)V", "Lcom/bytedance/android/livesdk/gift/configmodel/i2$b;", PbRequest.SwitchType.GIFT, "Lcom/bytedance/android/livesdk/gift/configmodel/i2$b;", "getGift", "()Lcom/bytedance/android/livesdk/gift/configmodel/i2$b;", "setGift", "(Lcom/bytedance/android/livesdk/gift/configmodel/i2$b;)V", "<init>", "()V", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i2 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName(PbRequest.SwitchType.GIFT)
    private b gift;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/i2$b;", "", "", "isVisible", "Z", "()Z", "setVisible", "(Z)V", "", "order", "I", "getOrder", "()I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class b {

        @SerializedName("isVisible")
        private boolean isVisible;

        @SerializedName("order")
        private int order;

        public final void a() {
            this.order = 2;
        }

        public b() {
            this.isVisible = true;
        }
    }

    static {
    }

    public final void a() {
        this.enable = true;
    }

    public i2() {
        b r100 = new b();
        r100.a();
        Unit r101 = Unit.INSTANCE;
        this.gift = r100;
    }
}
