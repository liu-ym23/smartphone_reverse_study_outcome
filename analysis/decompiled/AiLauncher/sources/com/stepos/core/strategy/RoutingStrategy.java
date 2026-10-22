package com.stepos.core.strategy;

import com.stepos.core.data.base.Content;
import com.stepos.core.transport.channel.ChannelType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/core/strategy/RoutingStrategy;", "", "Lcom/stepos/core/data/base/Content;", "input", "Lcom/stepos/core/transport/channel/ChannelType;", "selectChannel", "(Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/transport/channel/ChannelType;", "Lcom/stepos/core/strategy/RoutingConfig;", "config", "LY8/t;", "updateConfig", "(Lcom/stepos/core/strategy/RoutingConfig;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RoutingStrategy {
    ChannelType selectChannel(Content input);

    void updateConfig(RoutingConfig config);
}
