package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.TopTip")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/TopTip;", "", "", "topContent", "Ljava/lang/String;", "getTopContent", "()Ljava/lang/String;", "setTopContent", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "topImg", "Lcom/bytedance/android/live/base/model/ImageModel;", "getTopImg", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setTopImg", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "topTipType", "J", "getTopTipType", "()J", "setTopTipType", "(J)V", "schemeUrl", "getSchemeUrl", "setSchemeUrl", "<init>", "()V", "TopTipType", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopTip implements vh7.h {

    @SerializedName("scheme_url")
    protected String schemeUrl;

    @SerializedName("content")
    protected String topContent;

    @SerializedName("img")
    protected ImageModel topImg;

    @SerializedName("top_tip_type")
    protected long topTipType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/TopTip$TopTipType;", "", "TopTipUndefined", "TopTipTeamTask", "TopTipPunish", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TopTipType extends Enum<TopTipType> {
        public static final TopTipType TopTipPunish = null;
        public static final TopTipType TopTipTeamTask = null;
        public static final TopTipType TopTipUndefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TopTipType[] f106757a = null;

        static {
            TopTipType r100 = new TopTipType("TopTipUndefined", 0);
            TopTipUndefined = r100;
            TopTipType r101 = new TopTipType("TopTipTeamTask", 1);
            TopTipTeamTask = r101;
            TopTipType r102 = new TopTipType("TopTipPunish", 2);
            TopTipPunish = r102;
            f106757a = new TopTipType[]{r100, r101, r102};
        }

        public static TopTipType valueOf(String r100) {
            return (TopTipType) r27.a.a(TopTipType.class, r100);
        }

        public static TopTipType[] values() {
            return (TopTipType[]) f106757a.clone();
        }

        public TopTipType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TopTip() {
    }

    public TopTip(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.topContent = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.topImg = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.topTipType = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.schemeUrl = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
