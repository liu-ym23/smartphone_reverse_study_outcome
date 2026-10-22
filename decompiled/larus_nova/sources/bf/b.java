package bf;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18807a = 0;

    static {
    }

    public static String a(String r100, String r101) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        String r102 = r100.concat(r101);
        boolean r103 = false;
        if (StringsKt.endsWith$default(r102, HTTP.URL_DEFAULT, false, 2, null) == false) goto L13;
        if (r102.length() <= 1) goto L13;
        r102 = r102.substring(0, r102.length() - 1);
    L13:
        if (r102.length() <= 0) goto L15;
        r103 = true;
    L15:
        if (r103 == true) goto L17;
        return null;
    L17:
        return r102;
    }
}
