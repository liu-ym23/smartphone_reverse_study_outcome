package com.bytedance.android.live.liveinteract.linkcast;

import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkcast/LinkCastAnchorDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lvf0/a;", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "mLinkCastInfo$delegate", "Lcom/bytedance/live/datacontext/p;", "getMLinkCastInfo", "()Lcom/bytedance/live/datacontext/n;", "mLinkCastInfo", "Lcom/bytedance/android/live/liveinteract/model/LinkScreenCastType;", "mCurrentScreenType$delegate", "getMCurrentScreenType", "mCurrentScreenType", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkCastAnchorDataContext extends DataContext implements vf0.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p mCurrentScreenType$delegate;
    private final p mLinkCastInfo$delegate;

    public static final class a {
        public final LinkCastAnchorDataContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(vf0.a.class);
            if ((r100 instanceof LinkCastAnchorDataContext) == true) goto L6;
            r100 = null;
        L6:
            return (LinkCastAnchorDataContext) r100;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkCastAnchorDataContext.class, "mLinkCastInfo", "getMLinkCastInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkCastAnchorDataContext.class, "mCurrentScreenType", "getMCurrentScreenType()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public final n<LinkScreenCastType> getMCurrentScreenType() {
        return (n) this.mCurrentScreenType$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<s0> getMLinkCastInfo() {
        return (n) this.mLinkCastInfo$delegate.a(this, $$delegatedProperties[0]);
    }

    public LinkCastAnchorDataContext() {
        this.mLinkCastInfo$delegate = q.c(this);
        this.mCurrentScreenType$delegate = q.c(this);
    }
}
