package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/animation/InteractAnimationContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/animation/InteractAnimationController;", "controller$delegate", "Lcom/bytedance/live/datacontext/p;", "getController", "()Lcom/bytedance/live/datacontext/j;", "controller", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAnimationContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final com.bytedance.live.datacontext.p controller$delegate;

    public static final class a {
        public a() {
        }

        public final InteractAnimationContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(InteractAnimationContext.class);
            if ((r100 instanceof InteractAnimationContext) == true) goto L6;
            r100 = null;
        L6:
            return (InteractAnimationContext) r100;
        }

        public final InteractAnimationController a() {
            InteractAnimationContext r100 = getContext();
            if (r100 == null) goto L7;
            com.bytedance.live.datacontext.j<InteractAnimationController> r101 = r100.getController();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(InteractAnimationContext.class, "controller", "getController()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.j<InteractAnimationController> getController() {
        return (com.bytedance.live.datacontext.j) this.controller$delegate.a(this, $$delegatedProperties[0]);
    }

    public InteractAnimationContext() {
        this.controller$delegate = ConstantKt.c(this);
    }
}
