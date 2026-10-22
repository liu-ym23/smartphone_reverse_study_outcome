package a36;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static /* synthetic */ String b(Uri r100) {
        return a(r100, "default_bid");
    }

    public static final String d(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.buildUpon().clearQuery().toString();
    }

    public static final Long f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L12;
        return null;
    L12:
        return Long.valueOf(CastLongProtector.parseLong(r100));
    L14:
        return null;
    L5:
        r101 = false;
        goto L7
    }

    public static final String a(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "bid");
        if (Intrinsics.areEqual(r100.getScheme(), "http") == true) goto L13;
        if (Intrinsics.areEqual(r100.getScheme(), "https") == true) goto L13;
        String r102 = e(r100, "a_surl");
        if (r102 != null) goto L14;
        String r103 = e(r100, "surl");
        if (r103 == null) goto L16;
        return r103;
    L16:
        return e(r100, "url");
    L14:
        return r102;
    L13:
        return r100.toString();
    }

    public static final String e(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        return UriProtector.getQueryParameter(r100, r101);
    L5:
        return null;
    }

    public static final void c(JSONObject r100, JSONObject r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L11;
        Iterator<String> r103 = r101.keys();
    L6:
        if (r103.hasNext() == false) goto L18;
        String r104 = r103.next();
        if (r100.has(r104) == false) goto L10;
        if (r102 == false) goto L6;
    L10:
        r100.put(r104, r101.get(r104));
        goto L6
    L18:
        return;
    }
}
