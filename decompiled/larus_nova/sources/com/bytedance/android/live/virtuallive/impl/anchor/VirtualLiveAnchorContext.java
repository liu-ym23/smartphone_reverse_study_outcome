package com.bytedance.android.live.virtuallive.impl.anchor;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/virtuallive/impl/anchor/VirtualLiveAnchorContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Ltc1/a;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/virtuallive/impl/anchor/a;", "widget$delegate", "Lcom/bytedance/live/datacontext/p;", "getWidget", "()Lcom/bytedance/live/datacontext/j;", "widget", "", "isInVideoPreview", "Z", "()Z", "setInVideoPreview", "(Z)V", "isVideoPreviewing", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VirtualLiveAnchorContext extends DataContext implements tc1.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private boolean isInVideoPreview;
    private final p widget$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final VirtualLiveAnchorContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(tc1.a.class);
            if ((r100 instanceof VirtualLiveAnchorContext) == true) goto L6;
            r100 = null;
        L6:
            return (VirtualLiveAnchorContext) r100;
        }

        @JvmStatic
        public final boolean a() {
            VirtualLiveAnchorContext r100 = getContext();
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.isInVideoPreview() != true) goto L7;
            return true;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(VirtualLiveAnchorContext.class, "widget", "getWidget()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final VirtualLiveAnchorContext getContext() {
        return Companion.getContext();
    }

    @JvmStatic
    public static final boolean isViewPreviewing() {
        return Companion.a();
    }

    /* JADX INFO: renamed from: getWidget, reason: collision with other method in class */
    public final j<com.bytedance.android.live.virtuallive.impl.anchor.a> m8224getWidget() {
        return (j) this.widget$delegate.a(this, $$delegatedProperties[0]);
    }

    @JvmStatic
    public static final com.bytedance.android.live.virtuallive.impl.anchor.a getWidget() {
        VirtualLiveAnchorContext r100 = Companion.getContext();
        if (r100 == null) goto L7;
        j<com.bytedance.android.live.virtuallive.impl.anchor.a> r101 = r100.m8224getWidget();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    public boolean isVideoPreviewing() {
        return Companion.a();
    }

    public VirtualLiveAnchorContext() {
        this.widget$delegate = ConstantKt.c(this);
    }

    public final boolean isInVideoPreview() {
        return this.isInVideoPreview;
    }

    public final void setInVideoPreview(boolean r100) {
        this.isInVideoPreview = r100;
    }
}
