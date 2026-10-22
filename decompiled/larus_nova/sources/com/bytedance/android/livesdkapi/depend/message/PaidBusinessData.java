package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PaidBusinessData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/PaidBusinessData;", "", "()V", "delivery", "", "duration", "", "entityRels", "", "id", "idType", "parentTicketId", "purchasePaidLiveType", "purchaseType", "retType", "rightType", "ticketId", "ticketSkuId", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidBusinessData implements h {
    public static final Companion Companion = null;
    public static final int PaidLiveType_Camera = 3;
    public static final int PaidLiveType_Clarity = 4;
    public static final int PaidLiveType_Liuyan = 5;
    public static final int PaidLiveType_Room = 1;
    public static final int PaidLiveType_UnKnow = 0;

    @SerializedName("delivery")
    public int delivery;

    @SerializedName("duration")
    public long duration;

    @SerializedName("entity_rels")
    public Map<Long, Integer> entityRels;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f162572id;

    @SerializedName("id_type")
    public int idType;

    @SerializedName("parent_ticket_id")
    public long parentTicketId;

    @SerializedName("purchase_paid_live_type")
    public int purchasePaidLiveType;

    @SerializedName("purchase_type")
    public long purchaseType;

    @SerializedName("ret_type")
    public int retType;

    @SerializedName("right_type")
    public int rightType;

    @SerializedName("ticket_id")
    public long ticketId;

    @SerializedName("ticket_sku_id")
    public long ticketSkuId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/PaidBusinessData$Companion;", "", "()V", "PaidLiveType_Camera", "", "PaidLiveType_Clarity", "PaidLiveType_Liuyan", "PaidLiveType_Room", "PaidLiveType_UnKnow", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PaidBusinessData() {
    }

    public PaidBusinessData(g r110) {
        this.entityRels = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L36;
        switch(r101) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            case 7: goto L29;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L6;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        this.rightType = r110.i();
        goto L3
    L8:
        this.purchaseType = r110.i();
        goto L3
    L9:
        this.parentTicketId = r110.j();
        goto L3
    L10:
        this.purchasePaidLiveType = r110.i();
        goto L3
    L11:
        long r102 = r110.c();
        Long r103 = null;
        Integer r104 = null;
    L12:
        int r105 = r110.f();
        if (r105 == (-1)) goto L21;
        if (r105 != 1) goto L17;
        r103 = Long.valueOf(r110.j());
        goto L12
    L17:
        if (r105 != 2) goto L18;
        r104 = Integer.valueOf(r110.i());
        goto L12
    L18:
        am3.h.e(r110);
        goto L12
    L21:
        r110.d(r102);
        Map<Long, Integer> r106 = this.entityRels;
        if (r103 == null) goto L28;
        if (r104 == null) goto L26;
        r106.put(r103, r104);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L29:
        this.ticketSkuId = r110.j();
        goto L3
    L30:
        this.ticketId = r110.j();
        goto L3
    L31:
        this.idType = r110.i();
        goto L3
    L32:
        this.f162572id = r110.j();
        goto L3
    L33:
        this.delivery = r110.i();
        goto L3
    L34:
        this.duration = r110.j();
        goto L3
    L35:
        this.retType = (int) r110.j();
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L36:
        r110.d(r100);
    }
}
