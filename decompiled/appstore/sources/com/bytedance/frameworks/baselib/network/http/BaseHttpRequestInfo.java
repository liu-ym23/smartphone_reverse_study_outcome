package com.bytedance.frameworks.baselib.network.http;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BaseHttpRequestInfo {
    public static ICreate L;
    public boolean A;
    public String B;
    public String C;
    public long D;
    public long E;
    public long F;
    public boolean G;
    public long H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public volatile AtomicBoolean f7161J;
    public String K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o4.a f7163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f7164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f7165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f7168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f7169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f7171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f7172k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f7173l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f7174m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f7175n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f7176o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7177p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f7178q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f7179r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f7180s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f7181t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f7182u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7183v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7184w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f7185x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f7186y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public JSONObject f7187z;

    public interface ICreate {
        BaseHttpRequestInfo create();
    }

    public static class a implements ICreate {
        public a() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo.ICreate
        public BaseHttpRequestInfo create() {
            return new BaseHttpRequestInfo();
        }
    }

    static {
        L = new a();
    }

    public BaseHttpRequestInfo() {
        this.f7183v = -1;
        this.f7184w = -1;
        this.f7185x = "";
        this.A = false;
        this.G = false;
        this.H = -1;
        this.I = false;
        this.f7161J = new AtomicBoolean(false);
        this.K = "";
    }

    public static BaseHttpRequestInfo a() {
        return L.create();
    }

    public static JSONObject b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        String[] r11 = r10.split(",");
        JSONArray r12 = new JSONArray();
        int r13 = r11.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r12.put(r11[r14]);
        r14 = r14 + 1;
        goto L7
    L9:
        JSONObject r15 = new JSONObject();
        r15.put("hit", r12);     // Catch: JSONException -> L12
    L14:
        return r15;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static void c(ICreate r10) {
        if (r10 == null) goto L5;
        L = r10;
        return;
    }
}
