package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LuckyBoxMessage.Extra")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R0\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/jj;", "Lcom/bytedance/android/live/base/model/Extra;", "", "", "allDesc", "Ljava/util/Map;", "getAllDesc", "()Ljava/util/Map;", "setAllDesc", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "allImage", "getAllImage", "setAllImage", "", "currentRound", "I", "getCurrentRound", "()I", "setCurrentRound", "(I)V", "percent", "getPercent", "setPercent", "", "", "roundTarget", "Ljava/util/List;", "getRoundTarget", "()Ljava/util/List;", "setRoundTarget", "(Ljava/util/List;)V", "rushCondition", "getRushCondition", "setRushCondition", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class jj extends Extra implements vh7.h {

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

    @IgnoreProtoFieldCheck
    @SerializedName("rush_condition")
    private int rushCondition;

    public jj() {
    }

    public jj(am3.g r110) {
        this.allDesc = new HashMap();
        this.allImage = new HashMap();
        this.roundTarget = new ArrayList();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L50;
        String r102 = null;
        if (r101 == 1) goto L34;
        if (r101 != 2) goto L9;
        long r103 = r110.c();
        Object r104 = null;
    L19:
        int r111 = r110.f();
        if (r111 == (-1)) goto L26;
        if (r111 != 1) goto L22;
        r102 = am3.h.c(r110);
        goto L19
    L22:
        if (r111 != 2) goto L23;
        r104 = com.bytedance.android.live.base.model.x.a(r110);
        goto L19
    L23:
        am3.h.e(r110);
        goto L19
    L26:
        r110.d(r103);
        Map r105 = this.allImage;
        if (r102 == null) goto L33;
        if (r104 == null) goto L31;
    L45:
        r105.put(r102, r104);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L9:
        if (r101 != 3) goto L11;
        this.currentRound = r110.i();
        goto L3
    L11:
        if (r101 != 4) goto L13;
        this.percent = r110.i();
        goto L3
    L13:
        if (r101 != 5) goto L14;
        this.roundTarget.add(Long.valueOf(r110.j()));
        goto L3
    L14:
        am3.h.e(r110);
        goto L3
    L34:
        long r106 = r110.c();
        r104 = null;
    L35:
        int r112 = r110.f();
        if (r112 == (-1)) goto L42;
        if (r112 != 1) goto L38;
        r102 = am3.h.c(r110);
        goto L35
    L38:
        if (r112 != 2) goto L39;
        r104 = am3.h.c(r110);
        goto L35
    L39:
        am3.h.e(r110);
        goto L35
    L42:
        r110.d(r106);
        r105 = this.allDesc;
        if (r102 == null) goto L49;
        if (r104 != null) goto L45;
        throw new IllegalStateException("Value must not be null");
    L49:
        throw new IllegalStateException("Key must not be null");
    L50:
        r110.d(r100);
    }
}
