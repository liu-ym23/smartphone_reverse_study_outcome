package com.bytedance.android.livesdk.verify;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/verify/VerifyErrorExtra;", "Ljava/io/Serializable;", "", "", "toMap", "", "liveAgreement", "Ljava/lang/Boolean;", "getLiveAgreement", "()Ljava/lang/Boolean;", "setLiveAgreement", "(Ljava/lang/Boolean;)V", "", "realNameVerify", "Ljava/lang/Integer;", "getRealNameVerify", "()Ljava/lang/Integer;", "setRealNameVerify", "(Ljava/lang/Integer;)V", "isPhoneBound", "setPhoneBound", "liveAnswer", "getLiveAnswer", "setLiveAnswer", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerifyErrorExtra implements Serializable {
    public static final a Companion = null;
    public static final String KEY_IS_PHONE_BIND = "is_phone_binded";
    public static final String KEY_LIVE_AGREEMENT = "live_agreement";
    public static final String KEY_LIVE_ANSWER = "live_answer";
    public static final String KEY_REALNAME = "realname_verify";
    public static final long serialVersionUID = 1;

    @SerializedName(KEY_IS_PHONE_BIND)
    private Boolean isPhoneBound;

    @SerializedName(KEY_LIVE_AGREEMENT)
    private Boolean liveAgreement;

    @SerializedName(KEY_LIVE_ANSWER)
    private Boolean liveAnswer;

    @SerializedName(KEY_REALNAME)
    private Integer realNameVerify;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public VerifyErrorExtra() {
    }

    public final Map<String, String> toMap() {
        Pair[] r100 = new Pair[4];
        r100[0] = TuplesKt.to(KEY_REALNAME, String.valueOf(this.realNameVerify));
        Boolean r101 = this.isPhoneBound;
        Boolean r102 = Boolean.TRUE;
        String r103 = "1";
        if (Intrinsics.areEqual(r101, r102) == false) goto L5;
        Object r104 = "1";
    L6:
        r100[1] = TuplesKt.to(KEY_IS_PHONE_BIND, r104);
        if (Intrinsics.areEqual(this.liveAnswer, r102) == false) goto L9;
        Object r105 = "1";
    L10:
        r100[2] = TuplesKt.to(KEY_LIVE_ANSWER, r105);
        if (Intrinsics.areEqual(this.liveAgreement, r102) == true) goto L14;
        r103 = "0";
    L14:
        r100[3] = TuplesKt.to(KEY_LIVE_AGREEMENT, r103);
        return MapsKt.mapOf(r100);
    L9:
        r105 = "0";
        goto L10
    L5:
        r104 = "0";
        goto L6
    }

    public final Boolean getLiveAgreement() {
        return this.liveAgreement;
    }

    public final Boolean getLiveAnswer() {
        return this.liveAnswer;
    }

    public final Integer getRealNameVerify() {
        return this.realNameVerify;
    }

    public final Boolean isPhoneBound() {
        return this.isPhoneBound;
    }

    public final void setLiveAgreement(Boolean r100) {
        this.liveAgreement = r100;
    }

    public final void setLiveAnswer(Boolean r100) {
        this.liveAnswer = r100;
    }

    public final void setPhoneBound(Boolean r100) {
        this.isPhoneBound = r100;
    }

    public final void setRealNameVerify(Integer r100) {
        this.realNameVerify = r100;
    }
}
