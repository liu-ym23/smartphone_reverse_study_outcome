package com.stepos.core.strategy;

import com.stepos.core.data.base.Content;
import com.stepos.core.transport.channel.ChannelType;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/core/strategy/InferChannelRoutingStrategy;", "Lcom/stepos/core/strategy/RoutingStrategy;", "<init>", "()V", "Lcom/stepos/core/data/base/Content;", "input", "Lcom/stepos/core/transport/channel/ChannelType;", "selectChannel", "(Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/transport/channel/ChannelType;", "Lcom/stepos/core/strategy/RoutingConfig;", "config", "LY8/t;", "updateConfig", "(Lcom/stepos/core/strategy/RoutingConfig;)V", "Lcom/stepos/core/strategy/RoutingConfig;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InferChannelRoutingStrategy implements RoutingStrategy {
    private RoutingConfig config = new RoutingConfig(0, 0, false, false, 15, null);

    @Override // com.stepos.core.strategy.RoutingStrategy
    public ChannelType selectChannel(Content input) {
        p.i(input, "input");
        return ChannelType.PURE_BINDER;
    }

    @Override // com.stepos.core.strategy.RoutingStrategy
    public void updateConfig(RoutingConfig config) {
        p.i(config, "config");
        this.config = config;
    }
}
