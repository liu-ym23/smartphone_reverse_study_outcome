package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.net.MailTo;
import androidx.core.util.PatternsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes17.dex */
public final class LinkifyCompat {
    private static final Comparator<LinkSpec> COMPARATOR = null;
    private static final String[] EMPTY_STRING = null;

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static boolean addLinks(Spannable r100, Pattern r101, String r102, String[] r103, Linkify.MatchFilter r104, Linkify.TransformFilter r105) {
            return Linkify.addLinks(r100, r101, r102, r103, r104, r105);
        }

        public static void addLinks(TextView r100, Pattern r101, String r102, String[] r103, Linkify.MatchFilter r104, Linkify.TransformFilter r105) {
            Linkify.addLinks(r100, r101, r102, r103, r104, r105);
        }
    }

    public static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        public LinkSpec() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    static {
        EMPTY_STRING = new String[0];
        COMPARATOR = new a();
    }

    private LinkifyCompat() {
    }

    public static /* synthetic */ int a(LinkSpec r100, LinkSpec r101) {
        return lambda$static$0(r100, r101);
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        return true;
    L5:
        return false;
    }

    private static void addLinkMovementMethod(TextView r100) {
        if ((r100.getMovementMethod() instanceof LinkMovementMethod) == false) goto L5;
        return;
    L5:
        if (r100.getLinksClickable() == false) goto L9;
        r100.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    private static String findAddress(String r100) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return WebView.findAddress(r100);
    L7:
        return FindAddress.findAddress(r100);
    }

    public static boolean addLinks(Spannable r110, int r111) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r110, r111);
    L7:
        if (r111 != 0) goto L9;
        return false;
    L9:
        URLSpan[] r100 = (URLSpan[]) r110.getSpans(0, r110.length(), URLSpan.class);
        int r101 = r100.length - 1;
    L10:
        if (r101 < 0) goto L13;
        r110.removeSpan(r100[r101]);
        r101 = r101 - 1;
        goto L10
    L13:
        if ((r111 & 4) == 0) goto L15;
        Linkify.addLinks(r110, 4);
    L15:
        ArrayList r102 = new ArrayList();
        if ((r111 & 1) == 0) goto L19;
        gatherLinks(r102, r110, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
    L19:
        if ((r111 & 2) == 0) goto L22;
        gatherLinks(r102, r110, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, null, null);
    L22:
        if ((r111 & 8) == 0) goto L24;
        gatherMapLinks(r102, r110);
    L24:
        pruneOverlaps(r102, r110);
        if (r102.size() != 0) goto L27;
        return false;
    L27:
        Iterator r112 = r102.iterator();
    L29:
        if (r112.hasNext() == false) goto L33;
        LinkSpec r103 = (LinkSpec) r112.next();
        if (r103.frameworkAddedSpan != null) goto L29;
        applyLink(r103.url, r103.start, r103.end, r110);
        goto L29
    L33:
        return true;
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> r100, Spannable r101) {
        String r102 = r101.toString();
        int r103 = 0;
    L15:
        String r104 = findAddress(r102);     // Catch: UnsupportedOperationException -> L14
        if (r104 == null) goto L25;
        int r105 = r102.indexOf(r104);     // Catch: UnsupportedOperationException -> L14
        if (r105 < 0) goto L12;
        LinkSpec r106 = new LinkSpec();     // Catch: UnsupportedOperationException -> L14
        int r107 = r104.length() + r105;     // Catch: UnsupportedOperationException -> L14
        r106.start = r105 + r103;     // Catch: UnsupportedOperationException -> L14
        r103 = r103 + r107;     // Catch: UnsupportedOperationException -> L14
        r106.end = r103;     // Catch: UnsupportedOperationException -> L14
        r102 = r102.substring(r107);     // Catch: UnsupportedOperationException -> L14
        r106.url = "geo:0,0?q=" + URLEncoder.encode(r104, "UTF-8");     // Catch: UnsupportedOperationException -> L14
        r100.add(r106);     // Catch: UnsupportedOperationException -> L14
    L12:
        return;
    L25:
        return;
    }

    private static /* synthetic */ int lambda$static$0(LinkSpec r100, LinkSpec r101) {
        int r102 = r100.start;
        int r103 = r101.start;
        if (r102 >= r103) goto L6;
        return -1;
    L6:
        if (r102 <= r103) goto L10;
        return 1;
    L10:
        return Integer.compare(r101.end, r100.end);
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> r110, Spannable r111) {
        int r100 = 0;
        URLSpan[] r101 = (URLSpan[]) r111.getSpans(0, r111.length(), URLSpan.class);
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        URLSpan r104 = r101[r103];
        LinkSpec r105 = new LinkSpec();
        r105.frameworkAddedSpan = r104;
        r105.start = r111.getSpanStart(r104);
        r105.end = r111.getSpanEnd(r104);
        r110.add(r105);
        r103 = r103 + 1;
        goto L3
    L5:
        Collections.sort(r110, COMPARATOR);
        int r106 = r110.size();
    L7:
        if (r100 >= (r106 - 1)) goto L28;
        LinkSpec r107 = (LinkSpec) ListProtector.get(r110, r100);
        int r108 = r100 + 1;
        LinkSpec r109 = (LinkSpec) ListProtector.get(r110, r108);
        int r112 = r107.start;
        int r113 = r109.start;
        if (r112 > r113) goto L27;
        int r114 = r107.end;
        if (r114 <= r113) goto L27;
        int r115 = r109.end;
        if (r115 > r114) goto L16;
    L14:
        int r116 = r108;
    L22:
        if (r116 == (-1)) goto L27;
        Object r117 = ((LinkSpec) ListProtector.get(r110, r116)).frameworkAddedSpan;
        if (r117 == null) goto L26;
        r111.removeSpan(r117);
    L26:
        ListProtector.remove(r110, r116);
        r106 = r106 - 1;
        goto L7
    L16:
        if ((r114 - r112) > (r115 - r113)) goto L14;
        if ((r114 - r112) >= (r115 - r113)) goto L21;
        r116 = r100;
        goto L22
    L21:
        r116 = -1;
    L27:
        r100 = r108;
        goto L7
    }

    public static boolean addLinks(TextView r100, int r101) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r100, r101);
    L7:
        if (r101 != 0) goto L9;
        return false;
    L9:
        CharSequence r102 = r100.getText();
        if ((r102 instanceof Spannable) == true) goto L12;
        SpannableString r103 = SpannableString.valueOf(r102);
        if (addLinks(r103, r101) == false) goto L19;
        addLinkMovementMethod(r100);
        r100.setText(r103);
        return true;
    L19:
        return false;
    L12:
        if (addLinks((Spannable) r102, r101) == false) goto L19;
        addLinkMovementMethod(r100);
        return true;
    }

    public static boolean addLinks(Spannable r100, Pattern r101, String r102) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r100, r101, r102);
    L7:
        return addLinks(r100, r101, r102, null, null, null);
    }

    public static void addLinks(TextView r100, Pattern r101, String r102) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Linkify.addLinks(r100, r101, r102);
        return;
    L6:
        addLinks(r100, r101, r102, null, null, null);
    }

    private static void applyLink(String r100, int r101, int r102, Spannable r103) {
        r103.setSpan(new URLSpan(r100), r101, r102, 33);
    }

    private static String makeUrl(String r100, String[] r101, Matcher r110, Linkify.TransformFilter r111) {
        if (r111 == null) goto L4;
        r100 = r111.transformUrl(r110, r100);
    L4:
        int r112 = r101.length;
        int r102 = 0;
    L5:
        if (r102 >= r112) goto L12;
        String r103 = r101[r102];
        if (r100.regionMatches(true, 0, r103, 0, r103.length()) == true) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        boolean r104 = true;
        if (r100.regionMatches(false, 0, r103, 0, r103.length()) == true) goto L13;
        r100 = r103 + r100.substring(r103.length());
    L13:
        if (r104 == false) goto L15;
        return r100;
    L15:
        if (r101.length > 0) goto L17;
        return r100;
    L17:
        return r101[0] + r100;
    L12:
        r104 = false;
        goto L13
    }

    public static boolean addLinks(Spannable r100, Pattern r101, String r102, Linkify.MatchFilter r103, Linkify.TransformFilter r110) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r100, r101, r102, r103, r110);
    L7:
        return addLinks(r100, r101, r102, null, r103, r110);
    }

    public static void addLinks(TextView r100, Pattern r101, String r102, Linkify.MatchFilter r110, Linkify.TransformFilter r111) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Linkify.addLinks(r100, r101, r102, r110, r111);
        return;
    L6:
        addLinks(r100, r101, r102, null, r110, r111);
    }

    public static boolean addLinks(Spannable r100, Pattern r101, String r102, String[] r103, Linkify.MatchFilter r110, Linkify.TransformFilter r111) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Api24Impl.addLinks(r100, r101, r102, r103, r110, r111);
    L7:
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        if (r103 != null) goto L12;
    L13:
        r103 = EMPTY_STRING;
    L14:
        String[] r104 = new String[r103.length + 1];
        r104[0] = r102.toLowerCase(Locale.ROOT);
        int r105 = 0;
    L16:
        if (r105 >= r103.length) goto L22;
        String r106 = r103[r105];
        r105 = r105 + 1;
        if (r106 != null) goto L20;
        String r107 = "";
    L21:
        r104[r105] = r107;
        goto L16
    L20:
        r107 = r106.toLowerCase(Locale.ROOT);
        goto L21
    L22:
        Matcher r108 = r101.matcher(r100);
        boolean r109 = false;
    L24:
        if (r108.find() == false) goto L32;
        int r112 = r108.start();
        int r113 = r108.end();
        String r114 = r108.group(0);
        if (r110 == null) goto L28;
        boolean r115 = r110.acceptMatch(r100, r112, r113);
    L29:
        if (r115 == false) goto L24;
        if (r114 == null) goto L24;
        applyLink(makeUrl(r114, r104, r108, r111), r112, r113, r100);
        r109 = true;
        goto L24
    L28:
        r115 = true;
        goto L29
    L32:
        return r109;
    L12:
        if (r103.length >= 1) goto L14;
        goto L13
    }

    private static void gatherLinks(ArrayList<LinkSpec> r100, Spannable r101, Pattern r102, String[] r103, Linkify.MatchFilter r104, Linkify.TransformFilter r105) {
        Matcher r106 = r102.matcher(r101);
    L4:
        if (r106.find() == false) goto L11;
        int r107 = r106.start();
        int r108 = r106.end();
        String r109 = r106.group(0);
        if (r104 == null) goto L9;
        if (r104.acceptMatch(r101, r107, r108) == false) goto L4;
    L9:
        if (r109 == null) goto L4;
        LinkSpec r110 = new LinkSpec();
        r110.url = makeUrl(r109, r103, r106, r105);
        r110.start = r107;
        r110.end = r108;
        r100.add(r110);
        goto L4
    }

    public static void addLinks(TextView r100, Pattern r101, String r102, String[] r110, Linkify.MatchFilter r111, Linkify.TransformFilter r112) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Api24Impl.addLinks(r100, r101, r102, r110, r111, r112);
        return;
    L6:
        SpannableString r103 = SpannableString.valueOf(r100.getText());
        if (addLinks(r103, r101, r102, r110, r111, r112) == false) goto L10;
        r100.setText(r103);
        addLinkMovementMethod(r100);
        return;
    }
}
