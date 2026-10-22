package com.bytedance.android.live.liveinteract.plantform.dynamicframe.context;

import com.bytedance.android.live.liveinteract.plantform.multiroom.e;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.nb0;
import com.bytedance.android.livesdk.config.oa1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/context/MultiLinkDynamicContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/context/b;", "Lcom/bytedance/live/datacontext/i;", "", "isFeed$delegate", "Lcom/bytedance/live/datacontext/p;", "isFeed", "()Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/live/datacontext/n;", "Lih0/b;", "serviceMutable$delegate", "getServiceMutable", "()Lcom/bytedance/live/datacontext/n;", "serviceMutable", "Lnh0/p;", "preLayoutConfigState", "Lnh0/p;", "getPreLayoutConfigState", "()Lnh0/p;", "setPreLayoutConfigState", "(Lnh0/p;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkDynamicContext extends DataContext implements b {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG_FOR_FEED = "MultiLinkDynamicFeedContext";
    public static final String TAG_FOR_LIVE = "MultiLinkDynamicContext";
    private final p isFeed$delegate;
    private nh0.p preLayoutConfigState;
    private final p serviceMutable$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final MultiLinkDynamicContext getContext(Long r100) {
            DataContext r101 = null;
            if (oa1.f120889a.getValue().booleanValue() == false) goto L41;
            DataContext r102 = d.d("MultiLinkDynamicContext");
            if ((r102 instanceof MultiLinkDynamicContext) == true) goto L7;
            r102 = null;
        L7:
            MultiLinkDynamicContext r103 = (MultiLinkDynamicContext) r102;
            if (nb0.f120819a.getValue().booleanValue() == false) goto L13;
            if (r100 == null) goto L13;
            if (r100.longValue() <= 0) goto L13;
            String r104 = "MultiLinkDynamicFeedContext_" + r100;
        L14:
            DataContext r105 = d.d(r104);
            if (r105 != null) goto L18;
            r105 = d.d("MultiLinkDynamicFeedContext");
        L18:
            if ((r105 instanceof MultiLinkDynamicContext) == true) goto L20;
            r105 = null;
        L20:
            MultiLinkDynamicContext r106 = (MultiLinkDynamicContext) r105;
            if (r103 == null) goto L27;
            i<Boolean> r107 = r103.isFeed();
            if (r107 == null) goto L27;
            if (r107.getValue().booleanValue() == true) goto L27;
            return r103;
        L27:
            if (r106 == null) goto L40;
            i<Boolean> r108 = r106.isFeed();
            if (r108 == null) goto L40;
            if (r108.getValue().booleanValue() != true) goto L40;
            o r109 = IRoomContextService.a.a((IRoomContextService) k.n(IRoomContextService.class), null, 0, 3);
            if (r109 == null) goto L37;
            n<IRoom> r110 = r109.getInteractionDataPrepared();
            if (r110 == null) goto L37;
            IRoom r111 = r110.getValue();
        L38:
            if (r111 != null) goto L40;
            return r106;
        L37:
            r111 = null;
        L40:
            return null;
        L13:
            r104 = "MultiLinkDynamicFeedContext";
            goto L14
        L41:
            DataContext r112 = d.d(b.class);
            if ((r112 instanceof MultiLinkDynamicContext) == false) goto L46;
            r101 = r112;
        L46:
            return (MultiLinkDynamicContext) r101;
        }

        public final ih0.b a(DataCenter r100, Long r101) {
            ih0.b r102 = null;
            if (MultiLinkLoadWidgetUtils.g() == false) goto L5;
            ih0.b r103 = e.b(r100);
        L6:
            if (r103 != null) goto L14;
            MultiLinkDynamicContext r104 = getContext(r101);
            if (r104 == null) goto L13;
            n<ih0.b> r105 = r104.getServiceMutable();
            if (r105 == null) goto L13;
            r102 = r105.getValue();
        L13:
            return r102;
        L14:
            return r103;
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiLinkDynamicContext.class, "isFeed", "isFeed()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiLinkDynamicContext.class, "serviceMutable", "getServiceMutable()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final MultiLinkDynamicContext getContext(Long r100) {
        return Companion.getContext(r100);
    }

    public final n<ih0.b> getServiceMutable() {
        return (n) this.serviceMutable$delegate.a(this, $$delegatedProperties[1]);
    }

    public final i<Boolean> isFeed() {
        return (i) this.isFeed$delegate.a(this, $$delegatedProperties[0]);
    }

    public MultiLinkDynamicContext() {
        this.isFeed$delegate = ConstantKt.d(this, Boolean.FALSE);
        this.serviceMutable$delegate = q.c(this);
    }

    public final nh0.p getPreLayoutConfigState() {
        return this.preLayoutConfigState;
    }

    public final void setPreLayoutConfigState(nh0.p r100) {
        this.preLayoutConfigState = r100;
    }
}
