package com.bytedance.android.livesdk.chatroom.danmaku;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/danmaku/VSDanmakuContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "", "isDanmakuHandlePopupShow$delegate", "Lcom/bytedance/live/datacontext/p;", "isDanmakuHandlePopupShow", "()Lcom/bytedance/live/datacontext/m;", "<init>", "()V", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSDanmakuContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p isDanmakuHandlePopupShow$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(VSDanmakuContext.class, "isDanmakuHandlePopupShow", "isDanmakuHandlePopupShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Boolean> isDanmakuHandlePopupShow() {
        return (m) this.isDanmakuHandlePopupShow$delegate.a(this, $$delegatedProperties[0]);
    }

    public VSDanmakuContext() {
        this.isDanmakuHandlePopupShow$delegate = q.d(this, Boolean.FALSE);
    }
}
