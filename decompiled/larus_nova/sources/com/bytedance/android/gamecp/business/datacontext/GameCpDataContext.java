package com.bytedance.android.gamecp.business.datacontext;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/datacontext/GameCpDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "", "miniPlayStatus$delegate", "Lcom/bytedance/live/datacontext/p;", "getMiniPlayStatus", "()Lcom/bytedance/live/datacontext/m;", "miniPlayStatus", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameCpDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p miniPlayStatus$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GameCpDataContext.class, "miniPlayStatus", "getMiniPlayStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<String> getMiniPlayStatus() {
        return (m) this.miniPlayStatus$delegate.a(this, $$delegatedProperties[0]);
    }

    public GameCpDataContext() {
        this.miniPlayStatus$delegate = q.d(this, EventVerify.TYPE_LAUNCH);
    }
}
