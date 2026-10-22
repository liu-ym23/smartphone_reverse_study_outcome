package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/m1;", "", "", "type", "Ljava/lang/Integer;", "priority", "Lcom/bytedance/android/livesdk/message/model/e3;", "combineType", "Lcom/bytedance/android/livesdk/message/model/e3;", "Lcom/bytedance/android/livesdk/message/model/u1;", "cardDisplayInfo", "Lcom/bytedance/android/livesdk/message/model/u1;", "mockType", "Lcom/bytedance/android/livesdk/message/model/u;", "animConfig", "Lcom/bytedance/android/livesdk/message/model/u;", "", "isPreloadingNeeded", "Ljava/lang/Boolean;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m1 implements vh7.h {

    @SerializedName("anim_config")
    public u animConfig;

    @SerializedName("card_display_info")
    public u1 cardDisplayInfo;

    @SerializedName("combine_type")
    public e3 combineType;

    @SerializedName("is_preloading")
    public Boolean isPreloadingNeeded;

    @SerializedName(BasicTestActionHandler.MOCK_TYPE)
    public Integer mockType;

    @SerializedName("priority")
    public Integer priority;

    @SerializedName("type")
    public Integer type;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("BottomRightCardArea(type=");
        r100.append(this.type);
        r100.append(", priority=");
        r100.append(this.priority);
        r100.append(", content=");
        u1 r101 = this.cardDisplayInfo;
        if (r101 == null) goto L5;
        String r102 = r101.containerPayload;
    L6:
        r100.append(String.valueOf(r102));
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public m1() {
        this.type = 0;
        this.animConfig = new u();
        this.isPreloadingNeeded = Boolean.FALSE;
    }

    public m1(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L27;
        if (r102 != 1) goto L8;
        this.type = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.priority = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.combineType = new e3(r100);
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.cardDisplayInfo = new u1(r100);
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.mockType = Integer.valueOf(r100.i());
        goto L3
    L16:
        if (r102 != 61) goto L18;
        this.animConfig = new u(r100);
        goto L3
    L18:
        if (r102 != 62) goto L19;
        this.isPreloadingNeeded = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L19:
        am3.h.e(r100);
        goto L3
    L27:
        r100.d(r101);
        if (this.type != null) goto L31;
        this.type = 0;
    L31:
        if (this.animConfig != null) goto L34;
        this.animConfig = new u();
    L34:
        if (this.isPreloadingNeeded != null) goto L61;
        this.isPreloadingNeeded = Boolean.FALSE;
        return;
    }
}
