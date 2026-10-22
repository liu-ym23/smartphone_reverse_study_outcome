package com.bytedance.android.ec.opt.session.settings;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/opt/session/settings/ParamsExtractRule;", "Ljava/io/Serializable;", "keyPath", "", "redirectName", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "addCommonParams", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAddCommonParams", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getKeyPath", "()Ljava/lang/String;", "getRedirectName", "getStrategy", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public final class ParamsExtractRule implements Serializable {

    @SerializedName("add_common_params")
    private final Integer addCommonParams;

    @SerializedName("key_path")
    private final String keyPath;

    @SerializedName("redirect_name")
    private final String redirectName;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private final String strategy;

    public ParamsExtractRule() {
        this(null, null, null, null, 15, null);
    }

    public final Integer getAddCommonParams() {
        return this.addCommonParams;
    }

    public final String getKeyPath() {
        return this.keyPath;
    }

    public final String getRedirectName() {
        return this.redirectName;
    }

    public final String getStrategy() {
        return this.strategy;
    }

    public ParamsExtractRule(String r100, String r101, String r102, Integer r103) {
        this.keyPath = r100;
        this.redirectName = r101;
        this.strategy = r102;
        this.addCommonParams = r103;
    }

    public /* synthetic */ ParamsExtractRule(String r100, String r101, String r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "default";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
