package c87;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class a {

    @SerializedName("enable_vv_un_doze")
    public boolean enableVvUnDoze;

    @SerializedName("opt_terminate_report")
    public boolean optTerminateReport;

    @SerializedName("process_settings")
    public Map<String, C0415a> unDozeProcessSettings;

    /* JADX INFO: renamed from: c87.a$a, reason: collision with other inner class name */
    public static class C0415a {

        @SerializedName("enable_vv_un_doze")
        public boolean enableVvUnDoze;

        @SerializedName("un_doze_time")
        public long unDozeTime;

        public C0415a() {
        }
    }

    public a() {
    }
}
