package com.bytedance.android.livesdkapi.thirdrow;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/thirdrow/ThirdRowContentCount;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "", "shortTouchCount$delegate", "Lcom/bytedance/live/datacontext/p;", "getShortTouchCount", "()Lcom/bytedance/live/datacontext/m;", "shortTouchCount", "normalBannerCount$delegate", "getNormalBannerCount", "normalBannerCount", "activityBannerCount$delegate", "getActivityBannerCount", "activityBannerCount", "<init>", "()V", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ThirdRowContentCount extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p activityBannerCount$delegate;
    private final p normalBannerCount$delegate;
    private final p shortTouchCount$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ThirdRowContentCount.class, "shortTouchCount", "getShortTouchCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ThirdRowContentCount.class, "normalBannerCount", "getNormalBannerCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ThirdRowContentCount.class, "activityBannerCount", "getActivityBannerCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Integer> getActivityBannerCount() {
        return (m) this.activityBannerCount$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Integer> getNormalBannerCount() {
        return (m) this.normalBannerCount$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Integer> getShortTouchCount() {
        return (m) this.shortTouchCount$delegate.a(this, $$delegatedProperties[0]);
    }

    public ThirdRowContentCount() {
        this.shortTouchCount$delegate = q.d(this, 0);
        this.normalBannerCount$delegate = q.d(this, 0);
        this.activityBannerCount$delegate = q.d(this, 0);
    }
}
