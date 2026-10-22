package c12;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n extends e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f22052q;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.e
    public final String toString() {
        StringBuilder r100 = new StringBuilder("TTMD5ResourceRequest{mId=");
        r100.append(this.f129099i);
        r100.append(", mUrls='");
        String[] r101 = this.f129100j;
        r100.append(GsonProtectorUtils.toJson(l97.a.f508113a, r101));
        r100.append("', mMd5='");
        r100.append(this.f129101k);
        r100.append("', mSourceFrom='");
        r100.append(this.f129102l);
        r100.append("', mNeedToUnzip=");
        r100.append(this.f129103m);
        r100.append(", mTTMD5=");
        String r102 = this.f22052q;
        if (r102 != null) goto L5;
        r102 = "null";
    L5:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    }

    public n(long r110, String[] r111, String r112, String r113, long r114, GiftResourceFileCacheService r115) {
        Intrinsics.checkNotNullParameter(r111, "urls");
        Intrinsics.checkNotNullParameter(r112, "md5");
        Intrinsics.checkNotNullParameter(r115, "fileCacheService");
        super(r110, r111, r112, r114, r115);
        this.f22052q = r113;
    }
}
