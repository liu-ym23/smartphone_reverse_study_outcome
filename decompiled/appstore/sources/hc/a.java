package hc;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20397a = null;

    static {
        f20397a = new a();
    }

    public a() {
    }

    public final JSONObject a(String r10) {
        if (r10 == null) goto L10;
        if (r10.length() == 0) goto L10;
        return new JSONObject(r10);
    L13:
        return new JSONObject();
    L10:
        return new JSONObject();
    }
}
