package com.stepos.core.transport.channel;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.core.ability.IAIAbility;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.data.base.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\u000e\u001a\u00020\r\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/core/transport/channel/BinderChannel;", "Lcom/stepos/core/transport/channel/BaseInferenceChannel;", "Lcom/stepos/core/ability/IAIAbility;", "proxy", "<init>", "(Lcom/stepos/core/ability/IAIAbility;)V", "Lcom/stepos/core/data/base/Content;", ExifInterface.GPS_DIRECTION_TRUE, "", "inferId", "input", "Lcom/stepos/core/callback/IInferenceCallback;", "callback", "", "sendInferRequest", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;Lcom/stepos/core/callback/IInferenceCallback;)Z", "isAvailable", "()Z", "Lcom/stepos/core/transport/channel/ChannelType;", "getChannelType", "()Lcom/stepos/core/transport/channel/ChannelType;", "LY8/t;", "release", "()V", "Lcom/stepos/core/ability/IAIAbility;", "TAG", "Ljava/lang/String;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BinderChannel implements BaseInferenceChannel {
    private final String TAG;
    private final IAIAbility proxy;

    public BinderChannel(IAIAbility proxy) {
        p.i(proxy, "proxy");
        this.proxy = proxy;
        this.TAG = "BinderChannel";
    }

    @Override // com.stepos.core.transport.channel.BaseInferenceChannel
    public ChannelType getChannelType() {
        return ChannelType.PURE_BINDER;
    }

    @Override // com.stepos.core.transport.channel.BaseInferenceChannel
    public boolean isAvailable() {
        try {
            return this.proxy.asBinder().isBinderAlive();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.stepos.core.transport.channel.BaseInferenceChannel
    public void release() {
    }

    @Override // com.stepos.core.transport.channel.BaseInferenceChannel
    public <T extends Content> boolean sendInferRequest(String inferId, T input, IInferenceCallback callback) {
        p.i(inferId, "inferId");
        p.i(input, "input");
        try {
            this.proxy.infer(inferId, input, callback);
            return true;
        } catch (Exception e10) {
            Log.e(this.TAG, "Failed to send infer request via Binder", e10);
            return false;
        }
    }
}
