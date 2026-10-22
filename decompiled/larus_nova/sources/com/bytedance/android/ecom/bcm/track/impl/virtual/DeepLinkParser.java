package com.bytedance.android.ecom.bcm.track.impl.virtual;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.ecom.bcm.track.impl.setting.c;
import com.bytedance.mt.protector.impl.UriProtector;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class DeepLinkParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f51161a = 0;

    static {
    }

    public static BcmParams a(final String r110) {
        ALogger.f41996d.b("VirtualNodeManager", false, new DeepLinkParser$parseBcmParamsFromLink$1(r110));
        if (r110 == null) goto L34;
        List<c> r100 = VirtualNodeSetting.a().a();
        final LinkedHashMap r101 = new LinkedHashMap();
        Iterator<c> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L32;
        c r103 = r102.next();
        Iterator<String> r104 = r103.b().iterator();
    L9:
        if (r104.hasNext() == false) goto L29;
        List r105 = StringsKt.split$default(r104.next(), new String[]{"."}, false, 0, 6, null);
        Object r106 = UriProtector.getQueryParameter(UriProtector.parse(r110), (String) CollectionsKt.first(r105));     // Catch: Exception -> L13
    L14:
        if (r106 == null) goto L27;
        Iterator r107 = CollectionsKt.slice(r105, RangesKt.until(1, r105.size())).iterator();
    L17:
        if (r107.hasNext() == false) goto L27;
        String r108 = (String) r107.next();
        Object r111 = new JSONObject(String.valueOf(r106)).opt(r108);     // Catch: Exception -> L21
        boolean r112 = false;
    L22:
        if (r112 == false) goto L26;
        r106 = new JSONObject(URLDecoder.decode(String.valueOf(r106), "UTF-8")).opt(r108);     // Catch: Exception -> L25
    L25:
        r106 = null;
        goto L17
    L26:
        r106 = r111;
    L21:
        r111 = null;
        r112 = true;
    L27:
        if (r106 == null) goto L9;
    L30:
        if (r106 == null) goto L6;
        r101.put(r103.a(), r106);
    L13:
        r106 = null;
        goto L14
    L29:
        r106 = null;
        goto L30
    L32:
        ALogger.f41996d.b("VirtualNodeManager", false, new DeepLinkParser$parseBcmParamsFromLink$2(r101));
        BcmParams.Companion.getClass();
        return BcmParams.a.d(r101);
    L34:
        return null;
    }
}
