package os.teatracker;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: AppState.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("appstate_type")
    @Expose
    String f40683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("display_name")
    @Expose
    String f40684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(WsConstants.KEY_APP_VERSION)
    @Expose
    String f40685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("app_version_code")
    @Expose
    String f40686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("app_start_time")
    @Expose
    long f40687e;

    @SerializedName("package_name")
    @Expose
    String f;

    @SerializedName("app_duration")
    @Expose
    int g;

    @SerializedName("app_next_pkg")
    @Expose
    String h;

    @SerializedName("app_next_name")
    @Expose
    String i;
    String j;

    public a() {
    }

    public void a(String r1) {
        this.j = r1;
    }

    public String toString() {
        return "AppState{stateType='" + this.f40683a + "', appName='" + this.f40684b + "', versionName='" + this.f40685c + "', versionCode='" + this.f40686d + "', startTime=" + this.f40687e + ", packageName='" + this.f + "', duration=" + this.g + ", nextPackage='" + this.h + "', nextAppName='" + this.i + "', params='" + this.j + "'}";
    }
}
