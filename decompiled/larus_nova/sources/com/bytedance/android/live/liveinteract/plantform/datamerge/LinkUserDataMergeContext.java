package com.bytedance.android.live.liveinteract.plantform.datamerge;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/datamerge/LinkUserDataMergeContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "share", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/d;", "dataMergeCenter$delegate", "Lcom/bytedance/live/datacontext/p;", "getDataMergeCenter", "()Lcom/bytedance/live/datacontext/j;", "dataMergeCenter", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/b;", "linkRoomFightDataMergeCenter$delegate", "getLinkRoomFightDataMergeCenter", "linkRoomFightDataMergeCenter", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/handler/d;", "dynamicHandler$delegate", "getDynamicHandler", "dynamicHandler", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkUserDataMergeContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p dataMergeCenter$delegate;
    private final p dynamicHandler$delegate;
    private final p linkRoomFightDataMergeCenter$delegate;

    public static final class a {
        public a() {
        }

        public static /* synthetic */ LinkUserDataMergeContext a(a r100, DataCenter r101) {
            return r100.getContext(r101, "");
        }

        public static d b(a r100, DataCenter r101) {
            LinkUserDataMergeContext r102 = r100.getContext(r101, "");
            if (r102 == null) goto L7;
            com.bytedance.live.datacontext.j<d> r103 = r102.getDataMergeCenter();
            if (r103 == null) goto L7;
            return r103.getValue();
        L7:
            return null;
        }

        public final LinkUserDataMergeContext getContext(DataCenter r100, String r101) {
            StringBuilder r102 = new StringBuilder("LinkUserDataMergeContext_");
            DataContext r103 = null;
            if (r100 == null) goto L5;
            Integer r104 = Integer.valueOf(r100.hashCode());
        L6:
            r102.append(r104);
            DataContext r105 = com.bytedance.live.datacontext.d.d(r102.toString());
            if ((r105 instanceof LinkUserDataMergeContext) == true) goto L9;
            r105 = null;
        L9:
            LinkUserDataMergeContext r106 = (LinkUserDataMergeContext) r105;
            if (r106 != null) goto L15;
            DataContext r107 = com.bytedance.live.datacontext.d.d("LinkUserDataMergeContext_" + r101);
            if ((r107 instanceof LinkUserDataMergeContext) == true) goto L14;
            r107 = null;
        L14:
            r106 = (LinkUserDataMergeContext) r107;
        L15:
            if (r106 != null) goto L25;
            StringBuilder r108 = new StringBuilder("LinkUserDataMergeContext_");
            if (r100 == null) goto L19;
            String r109 = (String) r100.get("data_room_unique_id", "");
        L20:
            r108.append(r109);
            DataContext r110 = com.bytedance.live.datacontext.d.d(r108.toString());
            if ((r110 instanceof LinkUserDataMergeContext) == false) goto L24;
            r103 = r110;
        L24:
            r106 = (LinkUserDataMergeContext) r103;
            goto L25
        L19:
            r109 = null;
        L25:
            if (r106 != null) goto L27;
            com.bytedance.live.datacontext.d.d(LinkUserDataMergeContext.class);
        L27:
            return r106;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkUserDataMergeContext.class, "dataMergeCenter", "getDataMergeCenter()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkUserDataMergeContext.class, "linkRoomFightDataMergeCenter", "getLinkRoomFightDataMergeCenter()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkUserDataMergeContext.class, "dynamicHandler", "getDynamicHandler()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.j<d> getDataMergeCenter() {
        return (com.bytedance.live.datacontext.j) this.dataMergeCenter$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d> getDynamicHandler() {
        return (com.bytedance.live.datacontext.j) this.dynamicHandler$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.j<b> getLinkRoomFightDataMergeCenter() {
        return (com.bytedance.live.datacontext.j) this.linkRoomFightDataMergeCenter$delegate.a(this, $$delegatedProperties[1]);
    }

    public LinkUserDataMergeContext() {
        this.dataMergeCenter$delegate = ConstantKt.c(this);
        this.linkRoomFightDataMergeCenter$delegate = ConstantKt.c(this);
        this.dynamicHandler$delegate = ConstantKt.c(this);
    }

    public final void share(DataCenter r100) {
        com.bytedance.live.datacontext.b.a(this, LinkUserDataMergeContext.class);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.b.a(this, "LinkUserDataMergeContext_" + r100.hashCode());
        String r101 = (String) r100.get("data_room_unique_id", "");
        if (ln1.a.C6715a.a(r101) == false) goto L9;
        com.bytedance.live.datacontext.b.a(this, "LinkUserDataMergeContext_" + r101);
        return;
    L9:
        return;
    }
}
