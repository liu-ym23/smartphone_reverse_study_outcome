package ai5;

import by4.d;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements a {
    public b() {
    }

    @Override // ai5.a
    public final boolean b() {
        int r100 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        boolean r101 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.all.web.co_avatar_switch");
        tt5.a.h("PermFGUtils", "showAvatar()...enable = " + r101);
        return r101;
    }

    @Override // ai5.a
    public final boolean a(String r100, vo5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        if (r101 == null) goto L10;
        d r102 = (d) r101.a(d.class);
        if (r102 == null) goto L11;
        com.ss.android.lark.storage.kv.repo.a r103 = r102.b("platform");
        if (r103 != null) goto L9;
        return false;
    L9:
        return r103.getBoolean(r100, false);
    L11:
        return false;
    L10:
        return false;
    }

    @Override // ai5.a
    public final void c(String r100, boolean r101, vo5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        if (r102 == null) goto L10;
        d r103 = (d) r102.a(d.class);
        if (r103 == null) goto L11;
        com.ss.android.lark.storage.kv.repo.a r104 = r103.b("platform");
        if (r104 == null) goto L12;
        r104.putBoolean(r100, r101);
        return;
    L12:
        return;
    L11:
        return;
    }
}
