package com.bytedance.android.livesdk.utils.landscape;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u001a\u0010\u001a\u001a\u00020\u00118\u0006X\u0087D¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/utils/landscape/g;", "", "", "style", "I", "d", "()I", "setStyle", "(I)V", "", "", "supportEntrances", "Ljava/util/List;", "e", "()Ljava/util/List;", "setSupportEntrances", "(Ljava/util/List;)V", "", "optDuplicate", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setOptDuplicate", "(Z)V", "passLinkScene", "c", "optErrorRet", "b", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("opt_duplicate")
    private boolean optDuplicate;

    @SerializedName("opt_error_ret")
    private final boolean optErrorRet;

    @SerializedName("pass_link_scene")
    private final List<String> passLinkScene;

    @SerializedName("style")
    private int style;

    @SerializedName("support_entrances")
    private List<String> supportEntrances;

    public g() {
        this.supportEntrances = CollectionsKt.emptyList();
        this.optDuplicate = true;
        this.passLinkScene = CollectionsKt.listOf(Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        this.optErrorRet = true;
    }

    public final boolean a() {
        return this.optDuplicate;
    }

    public final boolean b() {
        return this.optErrorRet;
    }

    public final List<String> c() {
        return this.passLinkScene;
    }

    public final int d() {
        return this.style;
    }

    public final List<String> e() {
        return this.supportEntrances;
    }
}
