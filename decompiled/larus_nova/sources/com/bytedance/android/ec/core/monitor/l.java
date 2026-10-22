package com.bytedance.android.ec.core.monitor;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45163a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f45164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f45165b;

        public a() {
            throw null;
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "checkRule");
            List<String> r102 = CollectionsKt.listOf(r101);
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "checkRules");
            this.f45164a = r100;
            this.f45165b = r102;
        }
    }

    static {
    }

    public static boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "checkRule");
        int r102 = r101.hashCode();
        if (r102 == (-1276666629)) goto L27;
        if (r102 == (-850029332)) goto L18;
        if (r102 == 1612879795) goto L10;
    L35:
        return true;
    L10:
        if (r101.equals("is_json_string") == false) goto L35;
        if (cg4.a.a(r100) == false) goto L41;
        new JSONObject(r100);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return false;
    L41:
        return false;
    L18:
        if (r101.equals("valid_number") == false) goto L35;
        if (r100 == null) goto L43;
        if (CastLongProtector.parseLong(r100) > 0) goto L35;
        return false;
    L24:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return false;
    L43:
        return false;
    L27:
        if (r101.equals("presence") == false) goto L35;
        if (r100 != null) goto L30;
    L33:
        boolean r103 = true;
    L34:
        if (r103 == false) goto L35;
        return false;
    L30:
        if (r100.length() == 0) goto L33;
        r103 = false;
        goto L34
    }

    public static void a(String r110, String r111, String r112, List r113) {
        Intrinsics.checkNotNullParameter(r110, "schema");
        Intrinsics.checkNotNullParameter(r112, "destPage");
        Intrinsics.checkNotNullParameter(r113, "checkParams");
        Uri r100 = UriProtector.parse(r110);
        Iterator r114 = r113.iterator();
    L4:
        if (r114.hasNext() == false) goto L11;
        a r101 = (a) r114.next();
        String r102 = UriProtector.getQueryParameter(r100, r101.f45164a);
        Iterator<T> r103 = r101.f45165b.iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        String r104 = (String) r103.next();
        if (c(r102, r104) == true) goto L7;
        int r105 = d.f45144a;
        d.c(r111, r112, r110, r101.f45164a, r104, null, 32);
        goto L7
    }

    public static void b(String r100, String r101, JSONObject r102, List r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "checkParams");
        Uri r104 = UriProtector.parse(r100);
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L11;
        a r106 = (a) r105.next();
        String r107 = UriProtector.getQueryParameter(r104, r106.f45164a);
        Iterator<T> r108 = r106.f45165b.iterator();
    L7:
        if (r108.hasNext() == false) goto L4;
        String r109 = (String) r108.next();
        if (c(r107, r109) == true) goto L7;
        int r110 = d.f45144a;
        d.d(r106.f45164a, r109, null, r101, r102);
        goto L7
    }
}
