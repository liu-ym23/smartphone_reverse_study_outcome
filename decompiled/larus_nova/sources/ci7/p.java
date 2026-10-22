package ci7;

import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.ZlinkDependAbility;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ZlinkDependAbility f23879a;

    public static IZlinkDepend a() {
        ZlinkDependAbility r100 = f23879a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getZlinkDepend();
    }
}
