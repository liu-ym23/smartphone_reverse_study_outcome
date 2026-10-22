package ag7;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    @SerializedName("business")
    private final long business;

    @SerializedName("deviceid")
    private String did;

    @SerializedName("topic")
    private final String topic;

    @SerializedName("secuid")
    private String uid;

    public final String toString() {
        return "Topic{topic='" + this.topic + "', business=" + this.business + ", did='" + this.did + "', uid='" + this.uid + "'}";
    }

    public final long a() {
        return this.business;
    }

    public final String b() {
        return this.did;
    }

    public final String c() {
        return this.uid;
    }

    public final void d(String r100) {
        this.did = r100;
    }

    public final void e(String r100) {
        this.uid = r100;
    }
}
