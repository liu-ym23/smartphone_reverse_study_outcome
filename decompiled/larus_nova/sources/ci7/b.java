package ci7;

import com.bytedance.ug.sdk.deeplink.CallBackForAppLink;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements CallBackForAppLink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f23857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f23858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f23859c;

    @Override // com.bytedance.ug.sdk.deeplink.CallBackForAppLink
    public final void dealWithSchemaIsEmpty() {
        mi7.c.c(10003, "Can not get scheme from zlink.", this.f23857a, this.f23859c);
        fi7.d.c(null, 10003, "Can not get scheme from zlink.");
    }

    @Override // com.bytedance.ug.sdk.deeplink.CallBackForAppLink
    public final List<String> getHostList() {
        return new ArrayList();
    }

    @Override // com.bytedance.ug.sdk.deeplink.CallBackForAppLink
    public final boolean dealWithSchema(String r100) {
        if (r100 != null) goto L5;
    L10:
        mi7.c.c(10003, "Can not get scheme from zlink.", this.f23857a, this.f23859c);
        fi7.d.c(null, 10003, "Can not get scheme from zlink.");
    L11:
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        int r102 = c.f23860a;
        c.a(this.f23857a, r100, this.f23858b, null);
        goto L11
    L7:
        r101 = false;
        goto L8
    }

    public b(String r100, boolean r101, fi7.b r102, String r103) {
        this.f23857a = r100;
        this.f23858b = r101;
        this.f23859c = r103;
    }
}
