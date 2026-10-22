package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import fd2.w;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\fR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/video/VideoChorusDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/i;", "", "isFeed$delegate", "Lcom/bytedance/live/datacontext/p;", "isFeed", "()Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/live/datacontext/j;", "Lfd2/w;", "service$delegate", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/android/livesdk/ktvimpl/crossplatform/player/c;", "musicPlayerProxy$delegate", "getMusicPlayerProxy", "musicPlayerProxy", "Lfd2/d;", "chorusBizProxy$delegate", "getChorusBizProxy", "chorusBizProxy", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoChorusDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG_FOR_FEED = "VideoChorusFeedDataContext";
    public static final String TAG_FOR_LIVE = "VideoChorusDataContext";
    private final p chorusBizProxy$delegate;
    private final p isFeed$delegate;
    private final p musicPlayerProxy$delegate;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        public final VideoChorusDataContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(VideoChorusDataContext.TAG_FOR_LIVE);
            if ((r100 instanceof VideoChorusDataContext) == true) goto L5;
            r100 = null;
        L5:
            VideoChorusDataContext r101 = (VideoChorusDataContext) r100;
            DataContext r102 = com.bytedance.live.datacontext.d.d(VideoChorusDataContext.TAG_FOR_FEED);
            if ((r102 instanceof VideoChorusDataContext) == true) goto L8;
            r102 = null;
        L8:
            VideoChorusDataContext r103 = (VideoChorusDataContext) r102;
            if (r101 != null) goto L11;
        L13:
            if (r103 != null) goto L15;
        L22:
            return null;
        L15:
            if (r103.isFeed().getValue().booleanValue() == false) goto L22;
            n<IRoom> r104 = IRoomContextService.a.a((IRoomContextService) jc1.k.n(IRoomContextService.class), null, 0, 3).getInteractionDataPrepared();
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

        public final com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c a() {
            VideoChorusDataContext r100 = getContext();
            if (r100 == null) goto L7;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c> r101 = r100.getMusicPlayerProxy();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(VideoChorusDataContext.class, "isFeed", "isFeed()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VideoChorusDataContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(VideoChorusDataContext.class, "musicPlayerProxy", "getMusicPlayerProxy()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(VideoChorusDataContext.class, "chorusBizProxy", "getChorusBizProxy()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.j<fd2.d> getChorusBizProxy() {
        return (com.bytedance.live.datacontext.j) this.chorusBizProxy$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c> getMusicPlayerProxy() {
        return (com.bytedance.live.datacontext.j) this.musicPlayerProxy$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.j<w> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.i<Boolean> isFeed() {
        return (com.bytedance.live.datacontext.i) this.isFeed$delegate.a(this, $$delegatedProperties[0]);
    }

    public VideoChorusDataContext() {
        this.isFeed$delegate = ConstantKt.d(this, Boolean.FALSE);
        this.service$delegate = ConstantKt.c(this);
        this.musicPlayerProxy$delegate = ConstantKt.c(this);
        this.chorusBizProxy$delegate = ConstantKt.c(this);
    }
}
