package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.Team")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/Team;", "", "()V", CommonConstant.KEY_COUNTRY_CODE, "", ForwardDependency$ForwardLocation.FLAG, a.KEY_SCORE, "", "scoreAddition", "teamName", "teamd", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Team implements h {

    @SerializedName("country_code")
    public String countryCode;

    @SerializedName(ForwardDependency$ForwardLocation.FLAG)
    public String flag;

    @SerializedName(a.KEY_SCORE)
    public int score;

    @SerializedName("score_addition")
    public int scoreAddition;

    @SerializedName("team_name")
    public String teamName;

    @SerializedName("team_id")
    public String teamd;

    public Team() {
    }

    public Team(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.scoreAddition = r100.i();
        goto L3
    L8:
        this.teamd = am3.h.c(r100);
        goto L3
    L9:
        this.flag = am3.h.c(r100);
        goto L3
    L10:
        this.score = r100.i();
        goto L3
    L11:
        this.countryCode = am3.h.c(r100);
        goto L3
    L12:
        this.teamName = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
