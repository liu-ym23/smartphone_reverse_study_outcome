package com.bytedance.android.livesdkapi.depend.message.wrds;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorPointItem;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PreviewPromotionSyncData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010;\u001a\u00020)H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/PreviewPromotionSyncData;", "", "()V", "fansRedPacket", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/FansRedPacket;", "getFansRedPacket", "()Lcom/bytedance/android/livesdkapi/depend/message/wrds/FansRedPacket;", "setFansRedPacket", "(Lcom/bytedance/android/livesdkapi/depend/message/wrds/FansRedPacket;)V", "hotCommentList", "Ljava/util/LinkedList;", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/AbsPreviewComment;", "getHotCommentList", "()Ljava/util/LinkedList;", "setHotCommentList", "(Ljava/util/LinkedList;)V", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "luckyBag", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/LuckyBag;", "getLuckyBag", "()Lcom/bytedance/android/livesdkapi/depend/message/wrds/LuckyBag;", "setLuckyBag", "(Lcom/bytedance/android/livesdkapi/depend/message/wrds/LuckyBag;)V", "multiLinkAnchorPoint", "Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorPointItem;", "getMultiLinkAnchorPoint", "()Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorPointItem;", "setMultiLinkAnchorPoint", "(Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorPointItem;)V", "redPacket", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/RedPacket;", "getRedPacket", "()Lcom/bytedance/android/livesdkapi/depend/message/wrds/RedPacket;", "setRedPacket", "(Lcom/bytedance/android/livesdkapi/depend/message/wrds/RedPacket;)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "tickleUser", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/TickleUser;", "getTickleUser", "()Lcom/bytedance/android/livesdkapi/depend/message/wrds/TickleUser;", "setTickleUser", "(Lcom/bytedance/android/livesdkapi/depend/message/wrds/TickleUser;)V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "toString", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewPromotionSyncData implements h {
    public static final int COMMENT = 3;
    public static final Companion Companion = null;
    public static final int EXHIBITION = 998;
    public static final int FANS_RED_PACKET = 4;
    public static final String FANS_RED_PACKET_TYPE_DIAMOND = "Diamond";
    public static final String FANS_RED_PACKET_TYPE_MONEY = "CNY";
    public static final int LUCKY_BAG = 1;
    public static final int NULL_TYPE = 0;
    public static final int PK = 999;
    public static final int POKE = 5;
    public static final int RED_PACKET = 2;
    public static final int TOPIC_CHAT = 6;
    private FansRedPacket fansRedPacket;
    private LinkedList<AbsPreviewComment> hotCommentList;

    @SerializedName("icon")
    protected ImageModel icon;

    @SerializedName("lucky_bag")
    protected LuckyBag luckyBag;
    private AnchorPointItem multiLinkAnchorPoint;

    @SerializedName("lucky_money")
    protected RedPacket redPacket;

    @SerializedName("text")
    protected String text;

    @IgnoreProtoFieldCheck
    @SerializedName("tickle_user")
    protected TickleUser tickleUser;

    @SerializedName("type")
    protected Integer type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/PreviewPromotionSyncData$Companion;", "", "()V", "COMMENT", "", "EXHIBITION", "FANS_RED_PACKET", "FANS_RED_PACKET_TYPE_DIAMOND", "", "FANS_RED_PACKET_TYPE_MONEY", "LUCKY_BAG", "NULL_TYPE", "PK", "POKE", "RED_PACKET", "TOPIC_CHAT", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public String toString() {
        Integer r100 = this.type;
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        return "";
    L11:
        if (r100.intValue() != 1) goto L13;
        return "福袋：" + this.luckyBag;
    L6:
        if (r100.intValue() != 2) goto L8;
        return "红包：" + this.redPacket;
    }

    public PreviewPromotionSyncData() {
        this.type = 0;
    }

    public final FansRedPacket getFansRedPacket() {
        return this.fansRedPacket;
    }

    public final LinkedList<AbsPreviewComment> getHotCommentList() {
        return this.hotCommentList;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final LuckyBag getLuckyBag() {
        return this.luckyBag;
    }

    public final AnchorPointItem getMultiLinkAnchorPoint() {
        return this.multiLinkAnchorPoint;
    }

    public final RedPacket getRedPacket() {
        return this.redPacket;
    }

    public final String getText() {
        return this.text;
    }

    public final TickleUser getTickleUser() {
        return this.tickleUser;
    }

    public final Integer getType() {
        return this.type;
    }

    public PreviewPromotionSyncData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.icon = x.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.text = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.luckyBag = new LuckyBag(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.type = Integer.valueOf((int) r100.j());
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.redPacket = new RedPacket(r100);
        goto L3
    L16:
        if (r102 != 9) goto L17;
        this.tickleUser = new TickleUser(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.type != null) goto L49;
        this.type = 0;
        return;
    }

    public final void setFansRedPacket(FansRedPacket r100) {
        this.fansRedPacket = r100;
    }

    public final void setHotCommentList(LinkedList<AbsPreviewComment> r100) {
        this.hotCommentList = r100;
    }

    public final void setIcon(ImageModel r100) {
        this.icon = r100;
    }

    public final void setLuckyBag(LuckyBag r100) {
        this.luckyBag = r100;
    }

    public final void setMultiLinkAnchorPoint(AnchorPointItem r100) {
        this.multiLinkAnchorPoint = r100;
    }

    public final void setRedPacket(RedPacket r100) {
        this.redPacket = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTickleUser(TickleUser r100) {
        this.tickleUser = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
