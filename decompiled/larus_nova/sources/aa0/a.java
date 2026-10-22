package aa0;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Laa0/a;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "", "publishPointSupportList", "[Ljava/lang/String;", "b", "()[Ljava/lang/String;", "setPublishPointSupportList", "([Ljava/lang/String;)V", "<init>", "()V", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("support_list")
    private String[] publishPointSupportList;

    public a() {
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("LiveParseBusinessTypeConfig(enable=");
        r100.append(this.enable);
        r100.append(", publishPointSupportList=");
        String[] r101 = this.publishPointSupportList;
        if (r101 == null) goto L5;
        String r102 = Arrays.toString(r101);
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final boolean a() {
        return this.enable;
    }

    public final String[] b() {
        return this.publishPointSupportList;
    }
}
