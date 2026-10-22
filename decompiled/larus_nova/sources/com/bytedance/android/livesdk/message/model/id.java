package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/id;", "", "", "ktvChallengeType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setKtvChallengeType", "(Ljava/lang/Integer;)V", "", "lowerScoreLimit", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "setLowerScoreLimit", "(Ljava/lang/Long;)V", "upperScoreLimit", "d", "setUpperScoreLimit", "", "challengeScoreList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setChallengeScoreList", "(Ljava/util/List;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class id implements vh7.h {

    @SerializedName("challenge_score_list")
    protected List<Long> challengeScoreList;

    @SerializedName("ktv_challenge_type")
    protected Integer ktvChallengeType;

    @SerializedName("lower_score_limit")
    protected Long lowerScoreLimit;

    @SerializedName("upper_score_limit")
    protected Long upperScoreLimit;

    public id() {
    }

    public final List<Long> a() {
        return this.challengeScoreList;
    }

    public final Integer b() {
        return this.ktvChallengeType;
    }

    public final Long c() {
        return this.lowerScoreLimit;
    }

    public final Long d() {
        return this.upperScoreLimit;
    }

    public id(am3.g r100) {
        this.challengeScoreList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.ktvChallengeType = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.lowerScoreLimit = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.upperScoreLimit = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.challengeScoreList.add(Long.valueOf(r100.j()));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
