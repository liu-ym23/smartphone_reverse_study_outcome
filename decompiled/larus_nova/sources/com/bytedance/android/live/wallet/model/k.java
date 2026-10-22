package com.bytedance.android.live.wallet.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/wallet/model/k;", "", "", "scene", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", BytedCertConstant.CertKey.FLOW, "c", "setFlow", "ticket", "e", "setTicket", "displayTitle", "b", "setDisplayTitle", "displayBody", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDisplayBody", "", "verificationScene", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "setVerificationScene", "(Ljava/lang/Integer;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k {

    @SerializedName("display_body")
    private String displayBody;

    @SerializedName("display_title")
    private String displayTitle;

    @SerializedName(BytedCertConstant.CertKey.FLOW)
    private String flow;

    @SerializedName("scene")
    private String scene;

    @SerializedName("ticket")
    private String ticket;

    @SerializedName("verification_scene")
    private Integer verificationScene;

    public k() {
    }

    public final String a() {
        return this.displayBody;
    }

    public final String b() {
        return this.displayTitle;
    }

    public final String c() {
        return this.flow;
    }

    public final String d() {
        return this.scene;
    }

    public final String e() {
        return this.ticket;
    }

    public final Integer f() {
        return this.verificationScene;
    }
}
