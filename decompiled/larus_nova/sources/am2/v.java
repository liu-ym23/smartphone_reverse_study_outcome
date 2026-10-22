package am2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class v {

    @SerializedName("enable_log_dump")
    private boolean dumpEnv;

    @SerializedName("enable_all_log")
    private boolean enable;

    @SerializedName("enable_log_network_details")
    private boolean enableNetworkDetails;

    @SerializedName("enable_log_lifecycle")
    private boolean lifecycle;

    @SerializedName("enable_log_message")
    private boolean message;

    @SerializedName("enable_log_network")
    private boolean network;

    @SerializedName("enable_log_settings")
    private boolean settings;

    public static v e() {
        v r100 = new v();
        r100.enable = true;
        r100.network = true;
        r100.lifecycle = true;
        r100.dumpEnv = true;
        r100.settings = false;
        r100.message = true;
        r100.enableNetworkDetails = true;
        return r100;
    }

    public static v f() {
        v r100 = new v();
        r100.enable = true;
        r100.network = true;
        r100.lifecycle = true;
        r100.dumpEnv = true;
        r100.settings = false;
        r100.message = true;
        r100.enableNetworkDetails = true;
        return r100;
    }

    public final boolean b() {
        return this.enable & this.message;
    }

    public final boolean c() {
        return this.enable & this.network;
    }

    public v() {
        this.enable = false;
        this.network = false;
        this.lifecycle = false;
        this.dumpEnv = false;
        this.settings = false;
        this.message = false;
        this.enableNetworkDetails = false;
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean d() {
        return this.enableNetworkDetails;
    }
}
