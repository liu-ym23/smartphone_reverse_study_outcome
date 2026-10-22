package bi7;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements com.bytedance.applog.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f19148a;

    public e() {
    }

    @Override // com.bytedance.applog.h
    public final void a(boolean r100, JSONObject r101) {
    }

    public static e b() {
        if (f19148a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f19148a != null) goto L9;
        f19148a = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f19148a;
    }

    @Override // com.bytedance.applog.h
    public final void onIdLoaded(String r100, String r101, String r102) {
        mi7.e.c("DataObserver", "SchemeClipboardChecker doReCheck onIdLoaded");
        h.g().f(h.f19153a, h.f19154b, true);
    }

    @Override // com.bytedance.applog.h
    public final void onRemoteIdGet(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        if (r100 == false) goto L5;
        mi7.e.c("DataObserver", "SchemeClipboardChecker doReCheck onRemoteIdGet");
        h.g().f(h.f19153a, h.f19154b, true);
        return;
    }
}
