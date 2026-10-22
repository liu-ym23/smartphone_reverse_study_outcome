package com.bytedance.android.live.liveinteract.voicechat.interactacting;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/interactacting/InteractActingContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lmf0/a;", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/liveinteract/voicechat/interactacting/InteractActingStatus;", "status$delegate", "Lcom/bytedance/live/datacontext/p;", "getStatus", "()Lcom/bytedance/live/datacontext/m;", "status", "", "openSource$delegate", "getOpenSource", "openSource", "", "startTime$delegate", "getStartTime", DyPayConstant.KEY_START_TIME, "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractActingContext extends DataContext implements mf0.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "InteractActingContext";
    private final p openSource$delegate;
    private final p startTime$delegate;
    private final p status$delegate;

    public static final class a {
        public a() {
        }

        public final InteractActingContext getContext() {
            DataContext r100 = d.d(mf0.a.class);
            if ((r100 instanceof InteractActingContext) == true) goto L6;
            r100 = null;
        L6:
            return (InteractActingContext) r100;
        }

        public final boolean a() {
            InteractActingContext r100 = getContext();
            if (r100 == null) goto L7;
            m<InteractActingStatus> r101 = r100.getStatus();
            if (r101 == null) goto L7;
            InteractActingStatus r102 = r101.getValue();
        L9:
            if (r102 != InteractActingStatus.START) goto L11;
            return true;
        L11:
            return false;
        L7:
            r102 = null;
            goto L9
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(InteractActingContext.class, "status", "getStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractActingContext.class, "openSource", "getOpenSource()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractActingContext.class, DyPayConstant.KEY_START_TIME, "getStartTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final m<String> getOpenSource() {
        return (m) this.openSource$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Long> getStartTime() {
        return (m) this.startTime$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<InteractActingStatus> getStatus() {
        return (m) this.status$delegate.a(this, $$delegatedProperties[0]);
    }

    public InteractActingContext() {
        this.status$delegate = q.d(this, InteractActingStatus.UNKNOWN);
        this.openSource$delegate = q.d(this, "");
        this.startTime$delegate = q.d(this, 0L);
    }
}
