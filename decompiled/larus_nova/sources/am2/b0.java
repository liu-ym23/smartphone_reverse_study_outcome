package am2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4270f;

    public final Map<String, String> a() {
        HashMap r100 = new HashMap();
        boolean r101 = true;
        if (this.f4265a.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        r100.put("enter_from_merge", this.f4265a);
    L9:
        if (this.f4266b.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        r100.put("enter_method", this.f4266b);
    L15:
        if (TextUtils.isEmpty(this.f4269e) == true) goto L21;
        String r104 = this.f4269e;
        if (r104 != null) goto L19;
        r104 = "";
    L19:
        r100.put("video_id", r104);
    L21:
        if (TextUtils.isEmpty(this.f4267c) == true) goto L24;
        r100.put("request_id", this.f4267c);
    L24:
        if (TextUtils.isEmpty(this.f4268d) == true) goto L26;
        r100.put("log_pb", this.f4268d);
    L26:
        r100.put("is_vs", "1");
        r100.put("action_type", "click");
        if (this.f4270f.length() > 0) goto L30;
        r101 = false;
    L30:
        if (r101 == false) goto L32;
        r100.put("search_params", this.f4270f);
    L32:
        return r100;
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    public b0() {
        this.f4265a = "";
        this.f4266b = "";
        this.f4267c = "";
        this.f4268d = "";
        this.f4270f = "";
    }
}
