package com.bytedance.android.livesdk.ktvimpl.crossplatform;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/crossplatform/KtvJsbDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/i;", "", "isFeed$delegate", "Lcom/bytedance/live/datacontext/p;", "isFeed", "()Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/ktvimpl/crossplatform/jsb/a;", "service$delegate", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvJsbDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG_FOR_FEED = "KtvJsbFeedDataContext";
    public static final String TAG_FOR_LIVE = "KtvJsbDataContext";
    private final p isFeed$delegate;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        public final KtvJsbDataContext getContext() {
            DataContext r100 = d.d(KtvJsbDataContext.TAG_FOR_LIVE);
            if ((r100 instanceof KtvJsbDataContext) == true) goto L5;
            r100 = null;
        L5:
            KtvJsbDataContext r101 = (KtvJsbDataContext) r100;
            DataContext r102 = d.d(KtvJsbDataContext.TAG_FOR_FEED);
            if ((r102 instanceof KtvJsbDataContext) == true) goto L8;
            r102 = null;
        L8:
            KtvJsbDataContext r103 = (KtvJsbDataContext) r102;
            if (r101 != null) goto L11;
        L13:
            if (r103 != null) goto L15;
        L22:
            return null;
        L15:
            if (r103.isFeed().getValue().booleanValue() == false) goto L22;
            n<IRoom> r104 = IRoomContextService.a.a((IRoomContextService) k.n(IRoomContextService.class), null, 0, 3).getInteractionDataPrepared();
            if (r104 == null) goto L19;
            IRoom r105 = r104.getValue();
        L20:
            if (r105 != null) goto L22;
            return r103;
        L19:
            r105 = null;
            goto L20
        L11:
            if (r101.isFeed().getValue().booleanValue() == true) goto L13;
            return r101;
        }

        public static com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a a(boolean r100) {
            if (r100 == false) goto L8;
            DataContext r101 = d.d(KtvJsbDataContext.TAG_FOR_FEED);
            if ((r101 instanceof KtvJsbDataContext) == true) goto L7;
            r101 = null;
        L7:
            KtvJsbDataContext r102 = (KtvJsbDataContext) r101;
        L12:
            if (r102 == null) goto L17;
            j<com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a> r103 = r102.getService();
            if (r103 != null) goto L16;
            return null;
        L16:
            return r103.getValue();
        L17:
            return null;
        L8:
            DataContext r104 = d.d(KtvJsbDataContext.TAG_FOR_LIVE);
            if ((r104 instanceof KtvJsbDataContext) == true) goto L11;
            r104 = null;
        L11:
            r102 = (KtvJsbDataContext) r104;
            goto L12
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvJsbDataContext.class, "isFeed", "isFeed()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvJsbDataContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final j<com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[1]);
    }

    public final i<Boolean> isFeed() {
        return (i) this.isFeed$delegate.a(this, $$delegatedProperties[0]);
    }

    public KtvJsbDataContext() {
        this.isFeed$delegate = ConstantKt.d(this, Boolean.FALSE);
        this.service$delegate = ConstantKt.c(this);
    }
}
