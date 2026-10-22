package android.text.util;

import android.content.Context;
import android.os.BuildExt;
import android.os.StepOSCtsUtils;
import android.text.Spannable;
import android.text.util.Linkify;
import android.util.Log;
import android.util.Patterns;
import android.util.StepOSDateTimeUrlHelper;
import android.util.StepOSPatterns;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class StepOSLinkifyExtImpl implements IStepOSLinkifyExt {
    private static final String BAIDU_LOCATION = "http://api.map.baidu.com/marker?location=";
    private static final int CHARS_MAX_LENGTH = 128;
    private static final boolean IS_INTERNATIONAL = BuildExt.isProductInternational();
    private static final String TAG = "StepOSLinkifyExtImpl";

    public void onAttach(Linkify host) {
    }

    public void afterWebUrlsGathered(Spannable text, ArrayList<LinkSpec> links) {
        String raw = text.toString();
        Iterator<LinkSpec> it = links.iterator();
        while (it.hasNext()) {
            LinkSpec link = it.next();
            checkBracketsPairs(raw, link);
        }
    }

    public void optimizeWebLinks(Spannable text, int mask, ArrayList<LinkSpec> links) {
        String wwwPrefix;
        if ((mask & 4096) == 0) {
            return;
        }
        String wwwPrefix2 = "www.";
        Linkify.gatherLinks(links, text, StepOSPatterns.WEB_URL_EX, new String[]{"http://", "https://", "rtsp://", "ftp://"}, Linkify.sUrlMatchFilter, null);
        String raw = text.toString();
        Iterator<LinkSpec> it = links.iterator();
        while (it.hasNext()) {
            LinkSpec link = it.next();
            String linkedText = raw.substring(link.start, link.end).toLowerCase();
            if (linkedText.contains("www.") && !linkedText.startsWith("www.") && !linkedText.startsWith("http://") && !linkedText.startsWith("https://") && !linkedText.startsWith("rtsp://") && !linkedText.startsWith("ftp://")) {
                link.start += linkedText.indexOf("www.");
                link.url = link.url.substring(0, link.url.indexOf("://") + 3) + raw.substring(link.start, link.end);
            } else if (linkedText.contains("wap.") && !linkedText.startsWith("wap.") && !linkedText.startsWith("http://") && !linkedText.startsWith("https://") && !linkedText.startsWith("rtsp://") && !linkedText.startsWith("ftp://")) {
                link.start += linkedText.indexOf("wap.");
                link.url = link.url.substring(0, link.url.indexOf("://") + 3) + raw.substring(link.start, link.end);
            }
            int position = linkedText.lastIndexOf(".");
            if (position < 0 || position >= linkedText.length() - 1) {
                wwwPrefix = wwwPrefix2;
            } else if (linkedText.startsWith(BAIDU_LOCATION)) {
                wwwPrefix = wwwPrefix2;
            } else {
                char[] chars = linkedText.substring(position + 1).toCharArray();
                int i = 0;
                while (i < chars.length && chars[i] < 128) {
                    i++;
                }
                if (i >= chars.length) {
                    wwwPrefix = wwwPrefix2;
                } else {
                    link.end -= chars.length - i;
                    wwwPrefix = wwwPrefix2;
                    link.url = link.url.substring(0, link.url.length() - (chars.length - i));
                }
            }
            checkBracketsPairs(raw, link);
            wwwPrefix2 = wwwPrefix;
        }
    }

    public void gatherDateTimeLinks(Spannable text, int mask, ArrayList<LinkSpec> links) {
        if (!IS_INTERNATIONAL && (mask & 16) != 0) {
            Linkify.gatherLinks(links, text, StepOSDateTimeUrlHelper.DATE_TIME_PATTERN, new String[]{"datetime:"}, StepOSDateTimeUrlHelper.sDateTimeMatchFilter, StepOSDateTimeUrlHelper.sDateTimeTransformFilter);
        }
    }

    public void gatherPhoneNumberLinks(Spannable text, Context context, ArrayList<LinkSpec> links) {
        if (!IS_INTERNATIONAL && !StepOSCtsUtils.isCtsRunning()) {
            Linkify.gatherLinks(links, text, StepOSPatterns.PHONE, new String[]{"tel:"}, StepOSPhoneNumberMatchFilter.INSTANCE, Linkify.sPhoneNumberTransformFilter);
        } else {
            Linkify.gatherTelLinks(links, text, context);
        }
    }

    public void gatherEmailLinks(Spannable text, ArrayList<LinkSpec> links) {
        if (!IS_INTERNATIONAL && !StepOSCtsUtils.isCtsRunning()) {
            Linkify.gatherLinks(links, text, Patterns.EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        } else {
            Linkify.gatherLinks(links, text, Patterns.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
    }

    public int compareOverlapTieBreaker(LinkSpec a, LinkSpec b) {
        if (a.start == b.start && a.end == b.end && a.url != null && b.url != null) {
            String schemaA = a.url.split(StepOSDateTimeUrlHelper.COLON_STRING)[0];
            String schemaB = b.url.split(StepOSDateTimeUrlHelper.COLON_STRING)[0];
            if ("datetime".equalsIgnoreCase(schemaA) && "tel".equalsIgnoreCase(schemaB)) {
                return -1;
            }
            if ("tel".equalsIgnoreCase(schemaA) && "datetime".equalsIgnoreCase(schemaB)) {
                return 1;
            }
        }
        return 0;
    }

    private static void checkBracketsPairs(String rawStr, LinkSpec link) {
        int end = link.end - link.start;
        if (end <= 0) {
            return;
        }
        String matchStr = rawStr.substring(link.start, link.end);
        if (matchStr.charAt(end - 1) != ')') {
            return;
        }
        int bracketsCount = 0;
        for (int i = 0; i < end; i++) {
            if (matchStr.charAt(i) == ')') {
                bracketsCount++;
            } else if (matchStr.charAt(i) == '(') {
                bracketsCount--;
            }
        }
        if (bracketsCount > 0) {
            link.end -= bracketsCount;
            link.url = link.url.substring(0, link.url.length() - bracketsCount);
        }
    }

    private static final class StepOSPhoneNumberMatchFilter implements Linkify.MatchFilter {
        static final StepOSPhoneNumberMatchFilter INSTANCE = new StepOSPhoneNumberMatchFilter();

        private StepOSPhoneNumberMatchFilter() {
        }

        @Override // android.text.util.Linkify.MatchFilter
        public boolean acceptMatch(CharSequence s, int start, int end) {
            int pre2;
            int next = end + 1;
            try {
            } catch (Exception e) {
                Log.w(StepOSLinkifyExtImpl.TAG, "Phone number match filter error", e);
            }
            if (next < s.length() && '.' == s.charAt(end) && Character.isDigit(s.charAt(next))) {
                return false;
            }
            int pre1 = start - 1;
            if (pre1 >= 0) {
                if (' ' != s.charAt(pre1)) {
                    if ('$' != s.charAt(pre1) && 65509 != s.charAt(pre1)) {
                        if ('.' == s.charAt(pre1) && pre1 - 1 >= 0 && Character.isDigit(s.charAt(pre2))) {
                            return false;
                        }
                    }
                    return false;
                }
                int pre22 = pre1 - 1;
                if (pre22 >= 0 && ('$' == s.charAt(pre22) || 65509 == s.charAt(pre22))) {
                    return false;
                }
            }
            int digitCount = 0;
            for (int i = start; i < end; i++) {
                if (Character.isDigit(s.charAt(i)) && (digitCount = digitCount + 1) >= Linkify.getPhoneNumberMinimumDigits()) {
                    return true;
                }
            }
            return false;
        }
    }
}
