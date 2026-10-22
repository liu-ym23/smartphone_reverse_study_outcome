package c32;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.a5;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Spannable f22267a;

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("association_display_text")
    public a5 associationDisplayText;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f22270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22271e;

    @SerializedName("extra_map")
    public Map<String, String> extraMap;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    public String schemaUrl;

    @SerializedName("tracking_info")
    public Map<String, String> trackMap;

    public final String a() {
        Map<String, String> r100 = this.extraMap;
        if (r100 != null) goto L5;
        return "";
    L5:
        String r101 = r100.get("result_type");
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    }

    public d() {
        this.f22268b = false;
        this.f22269c = null;
        this.f22270d = 0;
        this.f22271e = false;
    }
}
