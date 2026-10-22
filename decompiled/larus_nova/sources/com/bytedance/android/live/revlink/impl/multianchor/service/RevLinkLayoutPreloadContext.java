package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/service/RevLinkLayoutPreloadContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/f;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/android/live/revlink/impl/preload/a;", "anchorService$delegate", "getAnchorService", "anchorService", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkLayoutPreloadContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "RevLinkLayoutPreloadContext";
    private final p anchorService$delegate;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        public final RevLinkLayoutPreloadContext getContext(Long r100) {
            DataContext r101 = null;
            if (r100 != null) goto L9;
            IRoom r102 = ((com.bytedance.android.livesdk.revenue.service.room.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class)).getRoom();
            if (r102 == null) goto L7;
            r100 = Long.valueOf(r102.getRoomId());
            goto L9
        L7:
            r100 = null;
        L9:
            if (r100 == null) goto L11;
            long r103 = r100.longValue();
        L13:
            if (r103 != 0) goto L15;
            return null;
        L15:
            DataContext r104 = com.bytedance.live.datacontext.d.d("RevLinkLayoutPreloadContext_" + r103);
            if ((r104 instanceof RevLinkLayoutPreloadContext) == false) goto L20;
            r101 = r104;
        L20:
            return (RevLinkLayoutPreloadContext) r101;
        L11:
            r103 = 0;
            goto L13
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RevLinkLayoutPreloadContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RevLinkLayoutPreloadContext.class, "anchorService", "getAnchorService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.preload.a> getAnchorService() {
        return (com.bytedance.live.datacontext.j) this.anchorService$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.j<f> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public RevLinkLayoutPreloadContext() {
        this.service$delegate = ConstantKt.c(this);
        this.anchorService$delegate = ConstantKt.c(this);
    }
}
