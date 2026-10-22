package androidx.webkit.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;

/* JADX INFO: compiled from: ProfileStoreImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements androidx.webkit.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static androidx.webkit.b f2987b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileStoreBoundaryInterface f2988a;

    private j(ProfileStoreBoundaryInterface r3) {
        this.f2988a = (ProfileStoreBoundaryInterface) ZeusTransformUtils.wrapperContextForParams(r3, ProfileStoreBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    private j() {
        this.f2988a = null;
    }

    public static androidx.webkit.b b() {
        if (f2987b != null) goto L6;
        f2987b = new j(q.a().e());
    L6:
        return f2987b;
    }

    @Override // androidx.webkit.b
    public androidx.webkit.a a(String r3) {
        if (p.ac.d() == false) goto L7;
        return new i((ProfileBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(ProfileBoundaryInterface.class, this.f2988a.getOrCreateProfile(r3)), ProfileBoundaryInterface.class, "com.obric.aiagent.plugin"));
    L7:
        throw p.a();
    }
}
