package com.bytedance.android.gamecp.business.download;

import com.ss.android.download.api.model.DownloadShortInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f52531h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f52532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f52533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f52534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f52535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f52536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f52537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f52538g;

    public static final class a {
        public static b a(DownloadShortInfo r110) {
            if (r110 != null) goto L6;
            return null;
        L6:
            return new b(r110.f408261id, r110.totalBytes, r110.fileName, r110.realCurrentBytes, r110.callScene, r110.extra, r110.downloadUrl);
        }
    }

    static {
    }

    public b(long r100, long r101, String r102, long r103, int r104, JSONObject r105, String r110) {
        this.f52532a = r100;
        this.f52533b = r101;
        this.f52534c = r102;
        this.f52535d = r103;
        this.f52536e = r104;
        this.f52537f = r105;
        this.f52538g = r110;
    }
}
