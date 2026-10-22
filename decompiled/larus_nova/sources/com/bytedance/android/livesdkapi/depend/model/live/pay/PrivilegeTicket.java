package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.EntityProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeTicket;", "", "()V", "privilegeConf", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeTicket$PrivilegeConfigure;", "privilegeHasPaid", "", "skuId", "", "EntityType", "PrivilegeConfigure", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivilegeTicket implements h {
    public static final int Camera = 1;
    public static final int Clarity = 2;
    public static final EntityType EntityType = null;
    public static final int ExclusivePhotos = 5;
    public static final int ExclusiveVideos = 6;
    public static final int Liuyan = 3;
    public static final int PhysicalGoods = 4;
    public static final int Room = 0;

    @SerializedName("privilege_conf")
    public List<PrivilegeConfigure> privilegeConf;

    @SerializedName("privilege_has_paid")
    public boolean privilegeHasPaid;

    @SerializedName(a.KEY_SKU_ID)
    public List<String> skuId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeTicket$EntityType;", "", "()V", "Camera", "", "Clarity", "ExclusivePhotos", "ExclusiveVideos", "Liuyan", "PhysicalGoods", LogFilterName.ROOM, "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EntityType {
        private EntityType() {
        }

        public /* synthetic */ EntityType(DefaultConstructorMarker r100) {
            this();
        }
    }

    @ForMain
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeTicket$PrivilegeConfigure;", "", "Lpy/k;", "icon", "Lpy/k;", "", "name", "Ljava/lang/String;", "", "entityType", "I", "", "privilegeTabKey", "J", "privilegeType", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PrivilegeConfigure implements h {

        @SerializedName(EntityProvider.KEY_ENTITY_TYPE)
        public int entityType;

        @SerializedName("icon")
        public k icon;

        @SerializedName("name")
        public String name;

        @SerializedName("privilege_tab_key")
        public long privilegeTabKey;

        @SerializedName("privilege_type")
        public int privilegeType;

        public PrivilegeConfigure() {
        }

        /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
        public PrivilegeConfigure(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            if (r102 != 1) goto L8;
            this.icon = f.a(r100, k.class);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.name = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.entityType = r100.i();
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.privilegeTabKey = r100.j();
            goto L3
        L14:
            if (r102 != 5) goto L15;
            this.privilegeType = r100.i();
            goto L3
        L15:
            am3.h.e(r100);
            goto L3
        L21:
            r100.d(r101);
        }
    }

    static {
        EntityType = new EntityType(null);
    }

    public PrivilegeTicket() {
    }

    public PrivilegeTicket(g r100) {
        this.skuId = new ArrayList();
        this.privilegeConf = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        if (r102 == 1) goto L14;
        if (r102 != 2) goto L10;
        List r103 = this.privilegeConf;
        Object r104 = new PrivilegeConfigure(r100);
    L15:
        r103.add(r104);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.privilegeHasPaid = am3.h.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L14:
        r103 = this.skuId;
        r104 = am3.h.c(r100);
        goto L15
    L16:
        r100.d(r101);
    }
}
