package com.bytedance.android.livesdk.vscore_api.paidlive.model;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.replay.paid.ReplayUpdatePaidData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/paidlive/model/PaidScopeContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdkapi/replay/paid/ReplayUpdatePaidData;", "updatePaidInfo", "Landroidx/lifecycle/MutableLiveData;", "getUpdatePaidInfo", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/live/datacontext/m;", "", "paidCardLoadAction$delegate", "Lcom/bytedance/live/datacontext/p;", "getPaidCardLoadAction", "()Lcom/bytedance/live/datacontext/m;", "paidCardLoadAction", "<init>", "()V", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidScopeContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p paidCardLoadAction$delegate;
    private final MutableLiveData<ReplayUpdatePaidData> updatePaidInfo;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PaidScopeContext.class, "paidCardLoadAction", "getPaidCardLoadAction()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Boolean> getPaidCardLoadAction() {
        return (m) this.paidCardLoadAction$delegate.a(this, $$delegatedProperties[0]);
    }

    public PaidScopeContext() {
        MutableLiveData<ReplayUpdatePaidData> r100 = new MutableLiveData();
        r100.setValue(null);
        Unit r101 = Unit.INSTANCE;
        this.updatePaidInfo = r100;
        this.paidCardLoadAction$delegate = q.d(this, Boolean.FALSE);
    }

    public final MutableLiveData<ReplayUpdatePaidData> getUpdatePaidInfo() {
        return this.updatePaidInfo;
    }
}
