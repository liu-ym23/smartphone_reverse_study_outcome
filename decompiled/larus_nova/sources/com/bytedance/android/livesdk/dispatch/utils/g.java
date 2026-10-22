package com.bytedance.android.livesdk.dispatch.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f122283a = 0;

    public static final class a {
        public static Map a(Uri r110) {
            HashMap r100 = new HashMap();
            if (r110 != null) goto L5;
            return r100;
        L5:
            String r101 = r110.getEncodedQuery();
            if (r101 != null) goto L8;
        L37:
            return r100;
        L8:
            if (r101.length() != 0) goto L10;
            boolean r111 = true;
        L11:
            if (r111 == true) goto L37;
            Object[] r112 = StringsKt.split$default(r101, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
            if (r112 == null) goto L36;
            String[] r113 = (String[]) r112;
            int r102 = r113.length;
            int r103 = 0;
        L16:
            if (r103 >= r102) goto L34;
            Object[] r104 = StringsKt.split$default(r113[r103], new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null).toArray(new String[0]);
            if (r104 == null) goto L33;
            String[] r105 = (String[]) r104;
            StringBuilder r106 = new StringBuilder();
            if (r105.length != 2) goto L22;
            String r107 = r105[0];
            r106.append(r105[1]);
        L24:
            if (r105.length <= 2) goto L29;
            r107 = r105[0];
            int r114 = r105.length;
            int r115 = 1;
        L26:
            if (r115 >= r114) goto L29;
            r106.append(r105[r115]);
            r106.append(ContainerUtils.KEY_VALUE_DELIMITER);
            r115 = r115 + 1;
        L29:
            if (TextUtils.isEmpty(r107) == true) goto L31;
            r100.put(r107, Uri.decode(r106.toString()));
        L31:
            r103 = r103 + 1;
            goto L16
        L22:
            r107 = "";
            goto L24
        L33:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L34:
            return r100;
        L36:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L10:
            r111 = false;
            goto L11
        }
    }

    static {
    }
}
