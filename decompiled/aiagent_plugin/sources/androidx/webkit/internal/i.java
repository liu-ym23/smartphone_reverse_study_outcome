package androidx.webkit.internal;

import android.webkit.CookieManager;
import android.webkit.WebStorage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;

/* JADX INFO: compiled from: ProfileImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements androidx.webkit.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileBoundaryInterface f2986a;

    i(ProfileBoundaryInterface r3) {
        this.f2986a = (ProfileBoundaryInterface) ZeusTransformUtils.wrapperContextForParams(r3, ProfileBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    private i() {
        this.f2986a = null;
    }

    @Override // androidx.webkit.a
    public String a() {
        if (p.ac.d() == false) goto L7;
        return this.f2986a.getName();
    L7:
        throw p.a();
    }

    @Override // androidx.webkit.a
    public CookieManager b() {
        if (p.ac.d() == false) goto L7;
        return this.f2986a.getCookieManager();
    L7:
        throw p.a();
    }

    @Override // androidx.webkit.a
    public WebStorage c() {
        if (p.ac.d() == false) goto L7;
        return this.f2986a.getWebStorage();
    L7:
        throw p.a();
    }
}
