package androidx.core.content;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: PackageManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static String a(PackageManager r5) {
        String r3 = null;
        Iterator<ResolveInfo> r0 = r5.queryIntentActivities(new Intent("android.intent.action.AUTO_REVOKE_PERMISSIONS").setData(Uri.fromParts("package", "com.example", null)), 0).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r0.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).activityInfo.packageName;
        if (r5.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", r1) != 0) goto L4;
        if (r3 != null) goto L9;
        r3 = r1;
        goto L4
    L9:
        return r3;
    L11:
        return r3;
    }
}
