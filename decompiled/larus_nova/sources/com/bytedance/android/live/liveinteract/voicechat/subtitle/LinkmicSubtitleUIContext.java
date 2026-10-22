package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleUIContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lnj0/e;", "Lcom/bytedance/live/datacontext/j;", "Lnj0/f;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicSubtitleUIContext extends DataContext implements nj0.e {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final com.bytedance.live.datacontext.p service$delegate;

    public static final class a {
        public a() {
        }

        public final LinkmicSubtitleUIContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(nj0.e.class);
            if ((r100 instanceof LinkmicSubtitleUIContext) == true) goto L6;
            r100 = null;
        L6:
            return (LinkmicSubtitleUIContext) r100;
        }

        public final nj0.f a() {
            LinkmicSubtitleUIContext r100 = getContext();
            if (r100 == null) goto L7;
            com.bytedance.live.datacontext.j<nj0.f> r101 = r100.getService();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkmicSubtitleUIContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.j<nj0.f> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public LinkmicSubtitleUIContext() {
        this.service$delegate = ConstantKt.c(this);
    }
}
