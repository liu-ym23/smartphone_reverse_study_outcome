package q4;

import android.text.TextUtils;
import com.bytedanceos.common.ad.param.AdReportParam;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f23541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f23542d;

    static {
    }

    public g(String r10, String r11, String r12, String r13) {
        this.f23541c = AdReportParam.ClickPosType.SKIP;
        this.f23542d = AdReportParam.ClickPosType.SKIP;
        this.f23539a = r10;
        this.f23540b = r11;
        if (TextUtils.isEmpty(r12) == true) goto L6;
        this.f23541c = r12;
    L6:
        if (TextUtils.isEmpty(r13) == true) goto L9;
        this.f23542d = r13;
        return;
    }
}
