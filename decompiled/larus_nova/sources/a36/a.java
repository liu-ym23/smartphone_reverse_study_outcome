package a36;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.share.panel.ShareChannel;
import com.lynx.devtoolwrapper.ScreenshotMode;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends c {
    @Override // a36.c
    public final KitType c() {
        String r100 = this.f1577a.getScheme();
        if (r100 == null) goto L24;
        int r101 = r100.hashCode();
        if (r101 == (-1772600516)) goto L20;
        if (r101 == 3213448) goto L16;
        if (r101 != 99617003) goto L24;
        if (r100.equals("https") == false) goto L24;
        return KitType.WEB;
    L16:
        if (r100.equals("http") == false) goto L24;
        return KitType.WEB;
    L20:
        if (r100.equals(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L24;
        return KitType.LYNX;
    L24:
        return KitType.UNKNOWN;
    }

    @Override // a36.c
    public final String b() {
    L18:
        e = move-exception;
        ExecutorService r100 = BulletLogger.f247763a;
        BulletLogger.l(e, "BulletLoadUriIdentifier schema", "Monitor");
        String r101 = "";
    L21:
        if (TextUtils.isEmpty(r101) == true) goto L23;
        return r101;
    L23:
        return this.f1577a.toString();
    L3:
        if (c() != KitType.LYNX) goto L11;
        if (Intrinsics.areEqual(this.f1577a.getAuthority(), "channel") == false) goto L11;
        Uri r102 = this.f1577a;     // Catch: Exception -> L18
        String r103 = b.b(r102);     // Catch: Exception -> L18
        if (r103 == null) goto L9;
        r102 = UriProtector.parse(r103);     // Catch: Exception -> L18
    L9:
        r101 = b.d(r102);     // Catch: Exception -> L18
    L11:
        if (Intrinsics.areEqual(this.f1577a.getScheme(), AppConstants.SCHEME_SS_LOCAL) == false) goto L13;
    L16:
        r101 = this.f1577a.toString();     // Catch: Exception -> L18
        goto L21
    L13:
        if (Intrinsics.areEqual(this.f1577a.getScheme(), ShareChannel.DOUYIN) == true) goto L16;
        r101 = new Uri.Builder().scheme(this.f1577a.getScheme()).authority(this.f1577a.getAuthority()).path(this.f1577a.getPath()).build().toString();     // Catch: Exception -> L18
        goto L21
    }

    public a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        super(r100);
    }
}
