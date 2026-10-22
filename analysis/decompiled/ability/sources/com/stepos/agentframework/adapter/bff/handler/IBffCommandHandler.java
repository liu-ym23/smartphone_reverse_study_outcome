package com.stepos.agentframework.adapter.bff.handler;

import com.google.protobuf.ByteString;
import com.stepos.agentframework.adapter.bff.CacheBean;
import kotlin.Metadata;
import r7.f;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/handler/IBffCommandHandler;", "", "Lr7/f;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/CacheBean;", "cacheBean", "LC7/r;", "handle", "(Lr7/f;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/CacheBean;)V", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IBffCommandHandler {
    void handle(f head, ByteString bodyRaw, CacheBean cacheBean);
}
