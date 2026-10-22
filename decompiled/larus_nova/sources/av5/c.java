package av5;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
    public static String a(String r100, String r101) {
        URI r102 = new URI(r100);     // Catch: Exception -> L8
        String r103 = r102.getQuery();     // Catch: Exception -> L8
        if (r103 == null) goto L6;
        r101 = r103 + "&" + r101;     // Catch: Exception -> L8
    L6:
        URI r104 = new URI(r102.getScheme(), r102.getAuthority(), r102.getPath(), r101, r102.getFragment());     // Catch: Exception -> L8
    L10:
        if (r104 != null) goto L12;
        return r100;
    L12:
        return r104.toString();
    L8:
        e = move-exception;
        tt5.a.d("UrlUtil", "add query error:" + e);
        r104 = null;
        goto L10
    }

    public static String b(String r100, Map<String, String> r101, boolean r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (r101 != null) goto L8;
    L27:
        return r100;
    L8:
        if (r101.isEmpty() == true) goto L27;
        Uri r103 = UriProtector.parse(r100);     // Catch: Exception -> L26
        Set<String> r104 = UriProtector.getQueryParameterNames(r103);     // Catch: Exception -> L26
        Uri.Builder r105 = r103.buildUpon();     // Catch: Exception -> L26
        Iterator<Map.Entry<String, String>> r106 = r101.entrySet().iterator();     // Catch: Exception -> L26
    L12:
        if (r106.hasNext() == false) goto L19;
        Map.Entry<String, String> r107 = r106.next();     // Catch: Exception -> L26
        String r108 = r107.getKey();     // Catch: Exception -> L26
        if (r104.contains(r108) == true) goto L15;
        r105.appendQueryParameter(r108, r107.getValue());     // Catch: Exception -> L26
        goto L12
    L15:
        if (r102 == false) goto L12;
        r105 = UriProtector.parse(r105.toString().replaceAll("(" + r108 + "=[^&]*)", r108 + ContainerUtils.KEY_VALUE_DELIMITER + r107.getValue())).buildUpon();     // Catch: Exception -> L26
        goto L12
    L19:
        if (TextUtils.isEmpty(r103.getFragment()) == true) goto L25;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.docx.synced_block.separate_page_mobile") == false) goto L25;
        r105.fragment(r103.getFragment());     // Catch: Exception -> L26
        r105.encodedFragment(r103.getEncodedFragment());     // Catch: Exception -> L26
        return r105.build().toString();
    L25:
        return r105.toString();
    L26:
        tt5.a.c("parse url error: " + r100);
        goto L27
    }
}
