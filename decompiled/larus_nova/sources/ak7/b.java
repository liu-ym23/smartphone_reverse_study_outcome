package ak7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010#\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0018\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001c¨\u00065"}, d2 = {"Lak7/b;", "", "", "accessKey", "Ljava/lang/String;", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "onlineAccessKey", "getOnlineAccessKey", "setOnlineAccessKey", "debugAccessKey", "getDebugAccessKey", "setDebugAccessKey", "", "offlinePrefix", "Ljava/util/List;", "getOfflinePrefix", "()Ljava/util/List;", "setOfflinePrefix", "(Ljava/util/List;)V", "", "enableGecko", "Z", "getEnableGecko", "()Z", "setEnableGecko", "(Z)V", "enableBuildIn", "getEnableBuildIn", "setEnableBuildIn", "enableGeckoTemplate", "getEnableGeckoTemplate", "setEnableGeckoTemplate", "enableBuildInTemplate", "getEnableBuildInTemplate", "setEnableBuildInTemplate", "defaultGroup", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDefaultGroup", "", "priority", "I", "getPriority", "()I", "setPriority", "(I)V", "useLuckyBusinessVersion", "getUseLuckyBusinessVersion", "setUseLuckyBusinessVersion", "<init>", "()V", "luckycat-api_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    @SerializedName("access_key")
    private String accessKey;

    @SerializedName("debug_access_key")
    private String debugAccessKey;

    @SerializedName("default_group")
    private String defaultGroup;

    @SerializedName("enable_buildin")
    private boolean enableBuildIn;

    @SerializedName("enable_buildin_template")
    private boolean enableBuildInTemplate;

    @SerializedName("enable_gecko")
    private boolean enableGecko;

    @SerializedName("enable_gecko_template")
    private boolean enableGeckoTemplate;

    @SerializedName("offline_prefix")
    private List<String> offlinePrefix;

    @SerializedName("online_access_key")
    private String onlineAccessKey;

    @SerializedName("priority")
    private int priority;

    @SerializedName("use_lucky_business_version")
    private boolean useLuckyBusinessVersion;

    public b() {
        this.accessKey = "";
        this.onlineAccessKey = "";
        this.debugAccessKey = "";
        this.enableGecko = true;
        this.enableBuildIn = true;
        this.enableGeckoTemplate = true;
        this.enableBuildInTemplate = true;
        this.defaultGroup = "default";
        this.priority = -1;
        this.useLuckyBusinessVersion = true;
    }

    public final String a() {
        return this.defaultGroup;
    }
}
