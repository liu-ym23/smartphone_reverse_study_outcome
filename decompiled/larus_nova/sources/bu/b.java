package bu;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GameGiftInfo")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0016\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lbu/b;", "", "", "giftName", "Ljava/lang/String;", "giftId", "giftImage", "propItems", "", "codeType", "Ljava/lang/Long;", "giftCount", "J", "useDescription", "", "hasReceive", "Z", "gameCode", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "codeStatus", "Lbu/a;", "playInfo", "Lbu/a;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("status")
    public long codeStatus;

    @SerializedName("code_type")
    public Long codeType;

    @SerializedName("effective_end_time")
    public long expireTime;

    @SerializedName("game_code")
    public String gameCode;

    @SerializedName("gift_count")
    public long giftCount;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    public String giftId;

    @SerializedName("gift_image")
    public String giftImage;

    @SerializedName("gift_name")
    public String giftName;

    @SerializedName("has_receive")
    public boolean hasReceive;

    @SerializedName("play_info")
    public a playInfo;

    @SerializedName("prop_items")
    public String propItems;

    @SerializedName("use_description")
    public String useDescription;

    public b() {
        this.codeStatus = 1;
    }

    public b(g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 14) goto L7;
        this.playInfo = new a(r100);
        goto L3
    L7:
        switch(r103) {
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
        this.codeStatus = r100.j();
        r102 = r102 | true;
        goto L3
    L10:
        this.expireTime = r100.j();
        goto L3
    L11:
        this.gameCode = am3.h.c(r100);
        goto L3
    L12:
        this.hasReceive = am3.h.a(r100);
        goto L3
    L13:
        this.useDescription = am3.h.c(r100);
        goto L3
    L14:
        this.giftCount = r100.j();
        goto L3
    L15:
        this.codeType = Long.valueOf(r100.j());
        goto L3
    L16:
        this.propItems = am3.h.c(r100);
        goto L3
    L17:
        this.giftImage = am3.h.c(r100);
        goto L3
    L18:
        this.giftId = am3.h.c(r100);
        goto L3
    L19:
        this.giftName = am3.h.c(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if ((r102 & true) == true) goto L54;
        this.codeStatus = 1;
        return;
    }
}
