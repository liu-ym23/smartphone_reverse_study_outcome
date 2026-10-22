package b39;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f17390a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f17391b = null;

    public d() {
    }

    static {
        f17390a = new String[]{"flow/home", "flow/chat", "flow/webview", "flow/profile", "flow/profile_edit", "flow/chat_setting", "flow/notice_page_dispatch", "flow/notice_page", "flow/create_bot", "flow/global_search", "flow/app_setting", "flow/video_feed", "webview", "chat_page", "discover", "privacy_info"};
        f17391b = CollectionsKt.listOf(new String[]{"flow/webview", "webview", "webview_native_nav", "flow/commerce_credit_web"});
    }

    public static String a(Uri r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getSchemeSpecificPart();
    L6:
        if (r101 == null) goto L10;
        List r102 = StringsKt.split$default(r101, new String[]{"?"}, false, 0, 6, null);
        if (r102 == null) goto L10;
        String r103 = (String) CollectionsKt.first(r102);
    L11:
        boolean r104 = false;
        if (r103 != null) goto L14;
    L16:
        if (r104 == true) goto L18;
        return null;
    L18:
        return r103.substring(2);
    L14:
        if (StringsKt.startsWith$default(r103, "//", false, 2, null) != true) goto L16;
        r104 = true;
    L10:
        r103 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    public static boolean b(final Context r100, Uri r101, List r102, List r103, final boolean r110, boolean r111) {
        String r104 = a(r101);
        if (CollectionsKt.contains(r102, r104) == false) goto L6;
        FLogger.f375446a.w("DeeplinkGate", "router in blockList: " + r104);
        b.b(r101);
        return false;
    L6:
        FLogger r105 = FLogger.f375446a;
        r105.d("DeeplinkGate", "router check pass: " + r101 + " |" + r110);
        if (r111 == true) goto L9;
    L32:
        Set<String> r106 = UriProtector.getQueryParameterNames(r101);
        Intrinsics.checkNotNull(r106);
        Set<String> r107 = r106;
        if ((r107 instanceof Collection) == true) goto L35;
    L37:
        Iterator<T> r112 = r107.iterator();
    L39:
        if (r112.hasNext() == false) goto L48;
        String r108 = (String) r112.next();
        if (r103 != null) goto L43;
    L45:
        boolean r109 = false;
    L46:
        if (r109 == false) goto L39;
        boolean r113 = false;
    L49:
        if (r113 == false) goto L51;
        final Uri r114 = r101;
    L63:
        final boolean r115 = Intrinsics.areEqual(UriProtector.getQueryParameter(r101, "no_anim"), "1");
        new Handler(Looper.getMainLooper()).post(new c(r114, r100, r110, r115));
        b.c(r101);
        return true;
    L51:
        Uri.Builder r116 = r101.buildUpon().clearQuery();
        Iterator<T> r117 = r107.iterator();
    L53:
        if (r117.hasNext() == false) goto L62;
        String r118 = (String) r117.next();
        if (r103 != null) goto L57;
    L59:
        boolean r119 = false;
    L60:
        if (r119 == true) goto L53;
        r116.appendQueryParameter(r118, UriProtector.getQueryParameter(r101, r118));
        goto L53
    L57:
        if (r103.contains(r118) != true) goto L59;
        r119 = true;
        goto L60
    L62:
        r114 = r116.build();
        goto L63
    L43:
        if (r103.contains(r108) != true) goto L45;
        r109 = true;
    L48:
        r113 = true;
        goto L49
    L35:
        if (r107.isEmpty() == false) goto L37;
    L9:
        if (CollectionsKt.contains(f17391b, a(r101)) == false) goto L28;
        String r120 = UriProtector.getQueryParameter(r101, "link_url");
        if (r120 != null) goto L13;
    L16:
        boolean r121 = true;
    L17:
        if (r121 == false) goto L19;
        r120 = UriProtector.getQueryParameter(r101, "url");
    L19:
        if (r120 != null) goto L21;
    L24:
        boolean r122 = true;
    L25:
        if (r122 == false) goto L27;
        boolean r123 = false;
    L29:
        if (r123 == true) goto L32;
        r105.w("DeeplinkGate", "router check query invalid: " + r101);
        b.b(r101);
        return false;
    L27:
        r123 = StringsKt.startsWith$default(r120, "http", false, 2, null);
        goto L29
    L21:
        if (r120.length() == 0) goto L24;
        r122 = false;
        goto L25
    L13:
        if (r120.length() == 0) goto L16;
        r121 = false;
        goto L17
    L28:
        r123 = true;
        goto L29
    }
}
