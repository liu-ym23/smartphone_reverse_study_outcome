package q1;

import com.bytedance.apm.impl.DefaultTTNetImpl;
import com.bytedance.apm.impl.RetrofitMonitorService;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.t;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.bytedance.ttnet.utils.RetrofitUtils;
import f6.f;
import h6.g;
import h6.h;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements IMultipartUploader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f23498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f23499e;

    public d(String r10, String r11, boolean r12, Map r13) {
        this.f23499e = new HashMap();
        this.f23495a = r10;
        this.f23498d = r13;
        this.f23496b = r11;
        this.f23497c = r12;
    }

    public final i6.c a(String r10, Map r11, Map r12) {
        RetrofitMonitorService r13 = (RetrofitMonitorService) RetrofitUtils.f(r10, RetrofitMonitorService.class);
        HashMap r14 = new HashMap();
        f r15 = r13.uploadFiles(r10, r11, DefaultTTNetImpl.convertHeaderMap(r12)).execute();     // Catch: Throwable -> L9
        byte[] r16 = DefaultTTNetImpl.toByteArray(((TypedInput) r15.a()).in());     // Catch: Throwable -> L9
        List r17 = r15.d();     // Catch: Throwable -> L9
        if (ListUtils.b(r17) == true) goto L11;
        Iterator r18 = r17.iterator();     // Catch: Throwable -> L9
    L7:
        if (r18.hasNext() == false) goto L11;
        g6.a r19 = (g6.a) r18.next();     // Catch: Throwable -> L9
        r14.put(r19.a(), r19.b());     // Catch: Throwable -> L9
    L11:
        int r20 = r15.b();     // Catch: Throwable -> L9
    L20:
        return new i6.c(r20, r14, r16);
    L9:
        th = move-exception;
        th.printStackTrace();
        JSONObject r21 = new JSONObject();
        r21.put("exception", th.getMessage() + t.a(th));     // Catch: Exception -> L16
        r21.put("exception_object", th.toString());     // Catch: Exception -> L16
    L18:
        r16 = r21.toString().getBytes();
        r20 = 100001;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r10, File r11, String r12, Map r13) {
        this.f23499e.put(r10, new c(r13, new g(null, r11)));
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFormField(String r10, String r11) {
        this.f23499e.put(r10, new h(r11));
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public i6.c finish() {
        return a(this.f23495a, this.f23499e, this.f23498d);
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r10, String r11, String r12, Map r13) {
        this.f23499e.put(r10, new b(r10, r11, r13));
    }
}
