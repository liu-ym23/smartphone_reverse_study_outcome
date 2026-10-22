package com.bytedance.android.livesdk.interactivity.medialink.contract;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/contract/MediaLinkContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/interactivity/medialink/contract/b;", "linkService$delegate", "Lcom/bytedance/live/datacontext/p;", "getLinkService", "()Lcom/bytedance/live/datacontext/j;", "linkService", "Lcom/bytedance/live/datacontext/i;", "Lw82/a;", "logParams$delegate", "getLogParams", "()Lcom/bytedance/live/datacontext/i;", "logParams", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MediaLinkContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p linkService$delegate;
    private final p logParams$delegate;

    public static final class a {
        @JvmStatic
        public final MediaLinkContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(MediaLinkContext.class);
            if ((r100 instanceof MediaLinkContext) == true) goto L6;
            r100 = null;
        L6:
            return (MediaLinkContext) r100;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MediaLinkContext.class, "linkService", "getLinkService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MediaLinkContext.class, "logParams", "getLogParams()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final MediaLinkContext getContext() {
        return Companion.getContext();
    }

    public final j<b> getLinkService() {
        return (j) this.linkService$delegate.a(this, $$delegatedProperties[0]);
    }

    public final i<w82.a> getLogParams() {
        return (i) this.logParams$delegate.a(this, $$delegatedProperties[1]);
    }

    public MediaLinkContext() {
        this.linkService$delegate = ConstantKt.c(this);
        this.logParams$delegate = ConstantKt.d(this, new w82.a(0));
    }
}
