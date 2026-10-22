package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends f {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f7482x = "e";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f7483p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f7484q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f7485r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f7486s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f7487t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7488u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7489v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7490w;

    static {
    }

    public e() {
        this.f7488u = false;
        this.f7489v = 100;
        this.f7490w = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.f
    public BaseDispatchAction.DispatchResultEnum q(String r10, List r11) {
        String r12 = f7482x;
        Logger.d(r12, "tc action");
        if (this.f7490w == false) goto L6;
        r11.set(0, r10);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L6:
        r11.set(0, r10);
        Uri r13 = Uri.parse(r10);
        if (this.f7488u == false) goto L17;
        Logger.d(r12, "drop action");
        if (w() == false) goto L15;
        if (i(r13) == false) goto L15;
        r11.set(0, "");
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP;
    L15:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L17:
        if (this.f7484q.isEmpty() == false) goto L46;
        if (this.f7483p.isEmpty() == false) goto L46;
        if (this.f7485r.isEmpty() == false) goto L46;
        Logger.d(r12, "tc full url change");
        if (this.f7462f.size() == 1) goto L28;
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L28:
        if (this.f7487t.isEmpty() == true) goto L36;
        if (r13.getPath() == null) goto L36;
        if (r13.getPath().contains(this.f7487t) == true) goto L36;
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L36:
        if (TextUtils.isEmpty(this.f7486s) == true) goto L38;
        String r14 = r10.replaceAll((String) this.f7462f.get(0), this.f7486s);
    L40:
        if (r14.equals(r10) == true) goto L42;
        r11.set(0, r14);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
    L42:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L38:
        r14 = r10;
    L46:
        if (i(r13) == false) goto L65;
        if (r13.getScheme() == null) goto L53;
        if (v(r13.getScheme(), this.f7483p) == false) goto L53;
        r10 = r10.replaceFirst(r13.getScheme(), this.f7483p);
    L53:
        if (r13.getHost() == null) goto L58;
        if (TextUtils.isEmpty(this.f7484q) == true) goto L58;
        r10 = r10.replaceFirst(r13.getHost(), this.f7484q);
    L58:
        if (r13.getPath() != null) goto L60;
    L62:
        r11.set(0, r10);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
    L60:
        if (TextUtils.isEmpty(this.f7485r) == true) goto L62;
        r10 = r10.replaceFirst(r13.getPath(), this.f7485r);
        goto L62
    L65:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.f
    public int r() {
        return -1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.f
    public boolean s(JSONObject r10, List r11, String r12, long r13) {
        j(r10);
        this.f7467k = r10.optString("service_name");
        this.f7483p = r10.optString("scheme_replace");
        this.f7484q = r10.optString("host_replace");
        this.f7485r = r10.optString("path_replace");
        this.f7487t = r10.optString("url_contain");
        this.f7486s = r10.optString("replace");
        if (r10.optInt("drop") != 1) goto L5;
        boolean r14 = true;
    L6:
        this.f7488u = r14;
        int r15 = r10.optInt("possibility", 100);
        if (r15 < 0) goto L11;
        if (r15 > 100) goto L11;
        this.f7489v = r15;
    L11:
        if (this.f7458b.isEmpty() == false) goto L21;
        if (this.f7459c.isEmpty() == false) goto L21;
        if (this.f7460d.isEmpty() == false) goto L21;
        if (this.f7461e.isEmpty() == false) goto L21;
        if (this.f7462f.isEmpty() == false) goto L21;
    L30:
        this.f7490w = true;
    L31:
        r11.set(0, Boolean.FALSE);
        return true;
    L21:
        if (this.f7488u == true) goto L31;
        if (this.f7483p.isEmpty() == false) goto L31;
        if (this.f7484q.isEmpty() == false) goto L31;
        if (this.f7485r.isEmpty() == false) goto L31;
        if (this.f7486s.isEmpty() == false) goto L31;
    L5:
        r14 = false;
        goto L6
    }

    public final boolean v(String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return false;
    L6:
        if (r10.equals(r11) == false) goto L9;
        return true;
    L9:
        if (r10.equals(HttpHost.DEFAULT_SCHEME_NAME) == true) goto L13;
        if (r10.equals("https") == true) goto L13;
    L18:
        if (r10.equals("ws") == true) goto L22;
        if (r10.equals("wss") == true) goto L22;
    L26:
        return false;
    L22:
        if (r11.equals("ws") == false) goto L24;
    L27:
        return true;
    L24:
        if (r11.equals("wss") == false) goto L26;
    L13:
        if (r11.equals(HttpHost.DEFAULT_SCHEME_NAME) == true) goto L27;
        if (r11.equals("https") == false) goto L18;
        goto L27
    }

    public final boolean w() {
        int r10 = this.f7489v;
        if (r10 < 100) goto L6;
        return true;
    L6:
        if (r10 > 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(100) >= this.f7489v) goto L11;
        return true;
    L11:
        Logger.d(f7482x, "tc drop action was probabilistic discard");
        return false;
    }
}
