package baseverify;

import com.dtf.face.network.APICallback;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class i implements APICallback<Map<String, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f18510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f18511b;

    @Override // com.dtf.face.network.APICallback
    public void onSuccess(Map<String, Object> r100) {
        APICallback r101 = (APICallback) this.f18510a.get("logCallback");
        if (r101 == null) goto L6;
        r101.onSuccess(this.f18511b);
        return;
    }

    public i(Map r100, String r101) {
        this.f18510a = r100;
        this.f18511b = r101;
    }

    @Override // com.dtf.face.network.APICallback
    public void onError(String r100, String r101, String r102) {
        APICallback r103 = (APICallback) this.f18510a.get("logCallback");
        if (r103 == null) goto L6;
        r103.onError(r100, this.f18511b, r102);
        return;
    }
}
