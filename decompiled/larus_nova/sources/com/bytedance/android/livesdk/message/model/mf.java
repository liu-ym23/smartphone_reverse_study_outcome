package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/mf;", "", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "I", "getScore", "()I", "setScore", "(I)V", "", "eggId", "Ljava/lang/String;", "getEggId", "()Ljava/lang/String;", "setEggId", "(Ljava/lang/String;)V", "teamId", "getTeamId", "setTeamId", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class mf implements vh7.h {

    @SerializedName("egg_id")
    protected String eggId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected int score;

    @SerializedName("team_id")
    protected String teamId;

    public mf() {
        this.eggId = "";
        this.teamId = "";
    }

    public mf(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.score = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.eggId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.teamId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.eggId != null) goto L19;
        this.eggId = "";
    L19:
        if (this.teamId != null) goto L34;
        this.teamId = "";
        return;
    }
}
