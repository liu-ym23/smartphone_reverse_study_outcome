package com.bytedance.android.livesdk.dispatch.utils;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f122278a = 0;

    static {
    }

    public static HashMap a(String r100) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        JSONObject r102 = new JSONObject(URLDecoder.decode(r100, XML.CHARSET_UTF8));
        Intrinsics.checkNotNullParameter(r102, "$this$toMap");
        HashMap r103 = new HashMap();
        Iterator<String> r104 = r102.keys();
    L11:
        if (r104.hasNext() == false) goto L13;
        String r105 = r104.next();
        r103.put(r105, r102.get(r105).toString());
        goto L11
    L13:
        return r103;
    L8:
        return new HashMap();
    L5:
        r101 = false;
        goto L6
    }
}
