package com.stepos.core.transport.channel;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.data.base.Content;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/core/transport/channel/BaseInferenceChannel;", "", "Lcom/stepos/core/data/base/Content;", ExifInterface.GPS_DIRECTION_TRUE, "", "inferId", "input", "Lcom/stepos/core/callback/IInferenceCallback;", "callback", "", "sendInferRequest", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;Lcom/stepos/core/callback/IInferenceCallback;)Z", "isAvailable", "()Z", "Lcom/stepos/core/transport/channel/ChannelType;", "getChannelType", "()Lcom/stepos/core/transport/channel/ChannelType;", "LY8/t;", "release", "()V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BaseInferenceChannel {
    ChannelType getChannelType();

    boolean isAvailable();

    void release();

    <T extends Content> boolean sendInferRequest(String inferId, T input, IInferenceCallback callback);
}
