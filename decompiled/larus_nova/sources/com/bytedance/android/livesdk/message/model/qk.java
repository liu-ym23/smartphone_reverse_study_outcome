package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomTicketMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0002DEB\u0007¢\u0006\u0004\bA\u0010BJ\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J-\u0010\r\u001a\u00028\u0000\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010 \u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R$\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010 \u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\"\u0010,\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R$\u0010/\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010 \u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0012\u001a\u0004\b:\u0010\u0014\"\u0004\b;\u0010\u0016R \u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020<8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/qk;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/e4;", "Lvh7/c$a;", "", "getOwnerIdStr", "ownerIdStr", "", "setOwnerIdStr", "Lvh7/e;", "R", "Ljava/lang/Class;", "aClass", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", ReportConstant.COMMON_ACTION_TYPE, "I", "getActionType", "()I", "setActionType", "(I)V", "", "ticketId", "J", "getTicketId", "()J", "setTicketId", "(J)V", "_ownerId", "_ownerOpenId", "Ljava/lang/String;", "ticketPanelJumpUrl", "getTicketPanelJumpUrl", "()Ljava/lang/String;", "setTicketPanelJumpUrl", "(Ljava/lang/String;)V", "ticketPanelJumpUrlV2", "getTicketPanelJumpUrlV2", "setTicketPanelJumpUrlV2", "ticketPanelJumpUrlV3", "getTicketPanelJumpUrlV3", "setTicketPanelJumpUrlV3", "cardDuration", "getCardDuration", "setCardDuration", "cardUrl", "getCardUrl", "setCardUrl", "Lcom/bytedance/android/livesdk/message/model/qk$b;", "productList", "Lcom/bytedance/android/livesdk/message/model/qk$b;", "getProductList", "()Lcom/bytedance/android/livesdk/message/model/qk$b;", "setProductList", "(Lcom/bytedance/android/livesdk/message/model/qk$b;)V", "bringProductStatus", "getBringProductStatus", "setBringProductStatus", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class qk extends o0 implements com.bytedance.android.live.base.model.message.e4, vh7.c.a<com.bytedance.android.live.base.model.message.e4>, vh7.h {
    public static final int ACTION_TYPE_BIND_COMPONENT = 1;
    public static final int ACTION_TYPE_HIDE_CARD = 4;
    public static final int ACTION_TYPE_SHOW_CARD = 3;
    public static final int ACTION_TYPE_UNBIND_COMPONENT = 2;
    public static final int ACTION_TYPE_UPDATE = 5;
    public static final a Companion = null;

    @SerializedName("owner_id")
    protected long _ownerId;

    @SerializedName("owner_open_id")
    protected String _ownerOpenId;

    @SerializedName("action_type")
    protected int actionType;

    @SerializedName("bring_product_switch_status")
    protected int bringProductStatus;

    @SerializedName("last_duration")
    protected int cardDuration;

    @SerializedName("ticket_explanation_card_jump_url")
    protected String cardUrl;
    private final transient FlexModelDelegate<com.bytedance.android.live.base.model.message.e4> delegate;

    @SerializedName("product_list_tool_bar")
    protected b productList;

    @SerializedName("ticket_id")
    protected long ticketId;

    @SerializedName("ticket_panel_jump_url")
    protected String ticketPanelJumpUrl;

    @IgnoreProtoFieldCheck
    @SerializedName("ticket_panel_6_jump_url")
    protected String ticketPanelJumpUrlV2;

    @IgnoreProtoFieldCheck
    @SerializedName("ticket_panel_9_jump_url")
    protected String ticketPanelJumpUrlV3;

    public static final class a {
        public a() {
        }
    }

    @ProtoMessage("webcast.im.RoomTicketMessage.ToolBar")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/qk$b;", "", "", "panelJumpUrl", "Ljava/lang/String;", "getPanelJumpUrl", "()Ljava/lang/String;", "setPanelJumpUrl", "(Ljava/lang/String;)V", "sixJumpUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setSixJumpUrl", "nineJumpUrl", "getNineJumpUrl", "setNineJumpUrl", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("nine_jump_url")
        protected String nineJumpUrl;

        @SerializedName("panel_jump_url")
        protected String panelJumpUrl;

        @SerializedName("six_jump_url")
        protected String sixJumpUrl;

        public b() {
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.panelJumpUrl = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.sixJumpUrl = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.nineJumpUrl = am3.h.c(r100);
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }

        public final String a() {
            return this.sixJumpUrl;
        }
    }

    static {
        Companion = new a();
    }

    public final String getOwnerIdStr() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this._ownerId);
        String r102 = this._ownerOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    public qk() {
        this.delegate = new FlexModelDelegate(com.bytedance.android.live.base.model.message.e4.class, this);
        this.type = MessageType.ROOM_TICKET_MESSAGE;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final int getBringProductStatus() {
        return this.bringProductStatus;
    }

    public final int getCardDuration() {
        return this.cardDuration;
    }

    public final String getCardUrl() {
        return this.cardUrl;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<com.bytedance.android.live.base.model.message.e4> getDelegate() {
        return this.delegate;
    }

    public final b getProductList() {
        return this.productList;
    }

    public final long getTicketId() {
        return this.ticketId;
    }

    public final String getTicketPanelJumpUrl() {
        return this.ticketPanelJumpUrl;
    }

    public final String getTicketPanelJumpUrlV2() {
        return this.ticketPanelJumpUrlV2;
    }

    public final String getTicketPanelJumpUrlV3() {
        return this.ticketPanelJumpUrlV3;
    }

    public qk(am3.g r100) {
        this.delegate = new FlexModelDelegate(com.bytedance.android.live.base.model.message.e4.class, this);
        getDelegate().setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = getDelegate().decodeExtensionFields(r102, r100);
        if (r102 != 5000) goto L7;
        this._ownerOpenId = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            default: goto L8;
        };
    L9:
        this.bringProductStatus = r100.i();
        goto L3
    L10:
        this.productList = new b(r100);
        goto L3
    L11:
        this._ownerId = r100.j();
        goto L3
    L12:
        this.ticketPanelJumpUrlV3 = am3.h.c(r100);
        goto L3
    L13:
        this.ticketPanelJumpUrlV2 = am3.h.c(r100);
        goto L3
    L14:
        this.ticketPanelJumpUrl = am3.h.c(r100);
        goto L3
    L15:
        this.cardUrl = am3.h.c(r100);
        goto L3
    L16:
        this.ticketId = r100.j();
        goto L3
    L17:
        this.cardDuration = r100.i();
        goto L3
    L18:
        this.actionType = r100.i();
        goto L3
    L19:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        getDelegate().setThreadSafe(true);
        this.type = MessageType.ROOM_TICKET_MESSAGE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.base.model.message.e4, vh7.c
    public <R extends vh7.e<com.bytedance.android.live.base.model.message.e4>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.base.model.message.e4, vh7.c
    public <R extends vh7.e<com.bytedance.android.live.base.model.message.e4>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castToOrNull(r100);
    }

    public final void setActionType(int r100) {
        this.actionType = r100;
    }

    public final void setBringProductStatus(int r100) {
        this.bringProductStatus = r100;
    }

    public final void setCardDuration(int r100) {
        this.cardDuration = r100;
    }

    public final void setCardUrl(String r100) {
        this.cardUrl = r100;
    }

    public final void setOwnerIdStr(String r100) {
        com.bytedance.android.live.base.model.user.o0.f58946a.getClass();
        this._ownerId = 0;
        this._ownerOpenId = r100;
    }

    public final void setProductList(b r100) {
        this.productList = r100;
    }

    public final void setTicketId(long r100) {
        this.ticketId = r100;
    }

    public final void setTicketPanelJumpUrl(String r100) {
        this.ticketPanelJumpUrl = r100;
    }

    public final void setTicketPanelJumpUrlV2(String r100) {
        this.ticketPanelJumpUrlV2 = r100;
    }

    public final void setTicketPanelJumpUrlV3(String r100) {
        this.ticketPanelJumpUrlV3 = r100;
    }
}
