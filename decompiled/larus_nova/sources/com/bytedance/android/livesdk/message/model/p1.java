package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CNYATaskMessage")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0014\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/message/model/p1;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "watchDuration", "I", "getWatchDuration", "()I", "setWatchDuration", "(I)V", "watchTotal", "getWatchTotal", "setWatchTotal", "", "", "allDesc", "Ljava/util/Map;", "getAllDesc", "()Ljava/util/Map;", "setAllDesc", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "allImage", "getAllImage", "setAllImage", "currentRound", "getCurrentRound", "setCurrentRound", "percent", "getPercent", "setPercent", "", "", "roundTarget", "Ljava/util/List;", "getRoundTarget", "()Ljava/util/List;", "setRoundTarget", "(Ljava/util/List;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p1 extends o0 implements vh7.h {

    @SerializedName("all_desc")
    protected Map<String, String> allDesc;

    @SerializedName("all_image")
    protected Map<String, ? extends ImageModel> allImage;

    @SerializedName("current_round")
    protected int currentRound;

    @SerializedName("pct")
    protected int percent;

    @SerializedName("round_target")
    protected List<Long> roundTarget;

    @SerializedName(PortraitEngine.LABEL_WATCH_DURATION)
    protected int watchDuration;

    @SerializedName("watch_total")
    protected int watchTotal;

    public p1() {
        setType(MessageType.CNY_A_TASK_MESSAGE);
    }

    public p1(am3.g r110) {
        this.allDesc = new HashMap();
        this.allImage = new HashMap();
        this.roundTarget = new ArrayList();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L52;
        if (r101 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.watchDuration = (int) r110.j();
        goto L3
    L10:
        if (r101 != 3) goto L11;
        this.watchTotal = (int) r110.j();
        goto L3
    L11:
        String r102 = null;
        switch(r101) {
            case 7: goto L48;
            case 8: goto L47;
            case 9: goto L46;
            case 10: goto L30;
            case 11: goto L14;
            default: goto L13;
        };
    L14:
        long r103 = r110.c();
        Object r104 = null;
    L15:
        int r111 = r110.f();
        if (r111 == (-1)) goto L22;
        if (r111 != 1) goto L18;
        r102 = am3.h.c(r110);
        goto L15
    L18:
        if (r111 != 2) goto L19;
        r104 = com.bytedance.android.live.base.model.x.a(r110);
        goto L15
    L19:
        am3.h.e(r110);
        goto L15
    L22:
        r110.d(r103);
        Map r105 = this.allImage;
        if (r102 == null) goto L29;
        if (r104 == null) goto L27;
    L41:
        r105.put(r102, r104);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L30:
        long r106 = r110.c();
        r104 = null;
    L31:
        int r112 = r110.f();
        if (r112 == (-1)) goto L38;
        if (r112 != 1) goto L34;
        r102 = am3.h.c(r110);
        goto L31
    L34:
        if (r112 != 2) goto L35;
        r104 = am3.h.c(r110);
        goto L31
    L35:
        am3.h.e(r110);
        goto L31
    L38:
        r110.d(r106);
        r105 = this.allDesc;
        if (r102 == null) goto L45;
        if (r104 != null) goto L41;
        throw new IllegalStateException("Value must not be null");
    L45:
        throw new IllegalStateException("Key must not be null");
    L46:
        this.roundTarget.add(Long.valueOf(r110.j()));
        goto L3
    L47:
        this.percent = r110.i();
        goto L3
    L48:
        this.currentRound = r110.i();
        goto L3
    L13:
        am3.h.e(r110);
        goto L3
    L52:
        r110.d(r100);
        setType(MessageType.CNY_A_TASK_MESSAGE);
    }
}
