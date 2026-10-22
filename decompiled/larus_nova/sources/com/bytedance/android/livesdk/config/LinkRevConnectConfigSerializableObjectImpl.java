package com.bytedance.android.livesdk.config;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/LinkRevConnectConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/v01;", "", "inviteTimeoutDuration", "J", "D0", "()J", "applyTimeoutDuration", DevicePlans.DEVICE_PLAN_OPPO2, "beInviteTimeoutDuration", ExifInterface.LATITUDE_SOUTH, "multiInviteWaitExtra", "O1", "<init>", "()V", "Adapter", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRevConnectConfigSerializableObjectImpl implements v01 {

    @SerializedName("apply_timeout_duration")
    private final long applyTimeoutDuration;

    @SerializedName("be_invite_timeout_duration")
    private final long beInviteTimeoutDuration;

    @SerializedName("invite_timeout_duration")
    private final long inviteTimeoutDuration;

    @SerializedName("multi_invite_wait_extra")
    private final long multiInviteWaitExtra;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/LinkRevConnectConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkRevConnectConfigSerializableObjectImpl.class);
        }
    }

    public LinkRevConnectConfigSerializableObjectImpl() {
        this.inviteTimeoutDuration = 20;
        this.applyTimeoutDuration = 20;
        this.beInviteTimeoutDuration = 35;
        this.multiInviteWaitExtra = 10;
    }

    @Override // com.bytedance.android.livesdk.config.v01
    public final long D0() {
        return this.inviteTimeoutDuration;
    }

    @Override // com.bytedance.android.livesdk.config.v01
    public final long O1() {
        return this.multiInviteWaitExtra;
    }

    @Override // com.bytedance.android.livesdk.config.v01
    public final long S() {
        return this.beInviteTimeoutDuration;
    }

    @Override // com.bytedance.android.livesdk.config.v01
    public final long o2() {
        return this.applyTimeoutDuration;
    }
}
