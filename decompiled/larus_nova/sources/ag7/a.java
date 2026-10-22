package ag7;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class a {

    @SerializedName("data")
    private String data;

    @SerializedName("msg")
    private String msg;

    @SerializedName("status_code")
    private int statusCode;

    public a() {
    }

    public final String a() {
        return this.msg;
    }

    public final int b() {
        return this.statusCode;
    }
}
