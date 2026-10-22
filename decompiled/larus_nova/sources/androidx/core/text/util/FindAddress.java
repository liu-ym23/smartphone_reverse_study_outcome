package androidx.core.text.util;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes17.dex */
class FindAddress {
    private static final String HOUSE_COMPONENT = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
    private static final String HOUSE_END = "(?=[,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String HOUSE_POST_DELIM = ",\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String HOUSE_PRE_DELIM = ":,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int MAX_ADDRESS_LINES = 5;
    private static final int MAX_ADDRESS_WORDS = 14;
    private static final int MAX_LOCATION_NAME_DISTANCE = 5;
    private static final int MIN_ADDRESS_WORDS = 4;
    private static final String NL = "\n\u000b\f\r\u0085\u2028\u2029";
    private static final String SP = "\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000";
    private static final String WORD_DELIM = ",*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String WORD_END = "(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String WS = "\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int kMaxAddressNameWordLength = 25;
    private static final Pattern sHouseNumberRe = null;
    private static final Pattern sLocationNameRe = null;
    private static final Pattern sStateRe = null;
    private static final ZipRange[] sStateZipCodeRanges = null;
    private static final Pattern sSuffixedNumberRe = null;
    private static final Pattern sWordRe = null;
    private static final Pattern sZipCodeRe = null;

    public static class ZipRange {
        int mException1;
        int mException2;
        int mHigh;
        int mLow;

        public boolean matches(String r100) {
            int r101 = CastIntegerProtector.parseInt(r100.substring(0, 2));
            if (this.mLow > r101) goto L7;
            if (r101 > this.mHigh) goto L7;
        L10:
            return true;
        L7:
            if (r101 == this.mException1) goto L10;
            if (r101 == this.mException2) goto L10;
            return false;
        }

        public ZipRange(int r100, int r101, int r102, int r103) {
            this.mLow = r100;
            this.mHigh = r101;
            this.mException1 = r102;
            this.mException2 = r103;
        }
    }

    static {
        sStateZipCodeRanges = new ZipRange[]{new ZipRange(99, 99, -1, -1), new ZipRange(35, 36, -1, -1), new ZipRange(71, 72, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(85, 86, -1, -1), new ZipRange(90, 96, -1, -1), new ZipRange(80, 81, -1, -1), new ZipRange(6, 6, -1, -1), new ZipRange(20, 20, -1, -1), new ZipRange(19, 19, -1, -1), new ZipRange(32, 34, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(30, 31, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(50, 52, -1, -1), new ZipRange(83, 83, -1, -1), new ZipRange(60, 62, -1, -1), new ZipRange(46, 47, -1, -1), new ZipRange(66, 67, 73, -1), new ZipRange(40, 42, -1, -1), new ZipRange(70, 71, -1, -1), new ZipRange(1, 2, -1, -1), new ZipRange(20, 21, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(48, 49, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(63, 65, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(38, 39, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(27, 28, -1, -1), new ZipRange(58, 58, -1, -1), new ZipRange(68, 69, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(7, 8, -1, -1), new ZipRange(87, 88, 86, -1), new ZipRange(88, 89, 96, -1), new ZipRange(10, 14, 0, 6), new ZipRange(43, 45, -1, -1), new ZipRange(73, 74, -1, -1), new ZipRange(97, 97, -1, -1), new ZipRange(15, 19, -1, -1), new ZipRange(6, 6, 0, 9), new ZipRange(96, 96, -1, -1), new ZipRange(2, 2, -1, -1), new ZipRange(29, 29, -1, -1), new ZipRange(57, 57, -1, -1), new ZipRange(37, 38, -1, -1), new ZipRange(75, 79, 87, 88), new ZipRange(84, 84, -1, -1), new ZipRange(22, 24, 20, -1), new ZipRange(6, 9, -1, -1), new ZipRange(5, 5, -1, -1), new ZipRange(98, 99, -1, -1), new ZipRange(53, 54, -1, -1), new ZipRange(24, 26, -1, -1), new ZipRange(82, 83, -1, -1)};
        sWordRe = PatternProtector.compile("[^,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]+(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sHouseNumberRe = PatternProtector.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sStateRe = PatternProtector.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+of[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+states[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+of[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+mariana[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+carolina)|(nd|north[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+dakota)|(ne|nebraska)|(nh|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+hampshire)|(nj|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+jersey)|(nm|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+mexico)|(nv|nevada)|(ny|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+rico)|(pw|palau)|(ri|rhode[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+island)|(sc|south[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+carolina)|(sd|south[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+virginia)|(wy|wyoming))(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sLocationNameRe = PatternProtector.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sSuffixedNumberRe = PatternProtector.compile("([0-9]+)(st|nd|rd|th)", 2);
        sZipCodeRe = PatternProtector.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
    }

    private FindAddress() {
    }

    private static boolean checkHouseNumber(String r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= r100.length()) goto L10;
        if (Character.isDigit(r100.charAt(r101)) == false) goto L8;
        r102 = r102 + 1;
    L8:
        r101 = r101 + 1;
        goto L4
    L10:
        if (r102 <= 5) goto L12;
        return false;
    L12:
        Matcher r103 = sSuffixedNumberRe.matcher(r100);
        if (r103.find() == false) goto L42;
        int r104 = CastIntegerProtector.parseInt(r103.group(1));
        if (r104 != 0) goto L17;
        return false;
    L17:
        String r105 = r103.group(2).toLowerCase(Locale.getDefault());
        int r106 = r104 % 10;
        String r107 = "th";
        if (r106 == 1) goto L37;
        if (r106 == 2) goto L31;
        if (r106 == 3) goto L25;
        return r105.equals("th");
    L25:
        if ((r104 % 100) == 13) goto L29;
        r107 = "rd";
    L29:
        return r105.equals(r107);
    L31:
        if ((r104 % 100) == 12) goto L35;
        r107 = "nd";
    L35:
        return r105.equals(r107);
    L37:
        if ((r104 % 100) == 11) goto L41;
        r107 = Segment.JsonKey.START;
    L41:
        return r105.equals(r107);
    L42:
        return true;
    }

    public static String findAddress(String r100) {
        Matcher r101 = sHouseNumberRe.matcher(r100);
        int r102 = 0;
    L4:
        if (r101.find(r102) == false) goto L13;
        if (checkHouseNumber(r101.group(0)) == true) goto L7;
        r102 = r101.end();
        goto L4
    L7:
        int r103 = r101.start();
        int r104 = attemptMatch(r100, r101);
        if (r104 > 0) goto L10;
        r102 = -r104;
        goto L4
    L10:
        return r100.substring(r103, r104);
    L13:
        return null;
    }

    public static boolean isValidLocationName(String r100) {
        return sLocationNameRe.matcher(r100).matches();
    }

    public static boolean isValidZipCode(String r100) {
        return sZipCodeRe.matcher(r100).matches();
    }

    private static int attemptMatch(String r110, MatchResult r111) {
        int r112 = r111.end();
        Matcher r100 = sWordRe.matcher(r110);
        String r101 = "";
        int r102 = 1;
        int r103 = 1;
        boolean r104 = true;
        boolean r105 = false;
        int r106 = -1;
        int r113 = -1;
    L4:
        if (r112 >= r110.length()) goto L58;
        if (r100.find(r112) == false) goto L7;
        if ((r100.end() - r100.start()) > 25) goto L12;
    L14:
        if (r112 >= r100.start()) goto L20;
        int r114 = r112 + 1;
        if (NL.indexOf(r110.charAt(r112)) == (-1)) goto L18;
        r102 = r102 + 1;
    L18:
        r112 = r114;
        goto L14
    L20:
        if (r102 > 5) goto L58;
        r103 = r103 + 1;
        if (r103 > 14) goto L58;
        if (matchHouseNumber(r110, r112) == null) goto L34;
        if (r104 == false) goto L31;
        if (r102 <= 1) goto L31;
        return -r112;
    L31:
        if (r106 != (-1)) goto L57;
        r106 = r112;
    L57:
        r101 = r100.group(0);
        r112 = r100.end();
        goto L4
    L34:
        if (isValidLocationName(r100.group(0)) == false) goto L36;
        r104 = false;
        r105 = true;
        goto L57
    L36:
        if (r103 != 5) goto L39;
        if (r105 == true) goto L39;
        r112 = r100.end();
    L39:
        if (r105 == true) goto L41;
    L56:
        r104 = false;
        goto L57
    L41:
        if (r103 <= 4) goto L56;
        MatchResult r115 = matchState(r110, r112);
        if (r115 == null) goto L56;
        if (r101.equals("et") == true) goto L47;
    L49:
        Matcher r107 = sWordRe.matcher(r110);
        if (r107.find(r115.end()) == true) goto L52;
        r113 = r115.end();
        goto L56
    L52:
        if (isValidZipCode(r107.group(0), r115) == false) goto L56;
        return r107.end();
    L47:
        if (r115.group(0).equals("al") == false) goto L49;
        r112 = r115.end();
        goto L58
    L12:
        int r116 = r100.end();
    L9:
        return -r116;
    L7:
        r116 = r110.length();
    L58:
        if (r113 <= 0) goto L60;
        return r113;
    L60:
        if (r106 > 0) goto L64;
        r106 = r112;
    L64:
        return -r106;
    }

    private static boolean isValidZipCode(String r100, MatchResult r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        int r102 = r101.groupCount();
    L6:
        if (r102 <= 0) goto L12;
        int r103 = r102 - 1;
        if (r101.group(r102) != null) goto L9;
        r102 = r103;
        goto L6
    L9:
        r102 = r103;
    L12:
        if (sZipCodeRe.matcher(r100).matches() == true) goto L14;
        return false;
    L14:
        if (sStateZipCodeRanges[r102].matches(r100) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public static MatchResult matchHouseNumber(String r100, int r101) {
        if (r101 > 0) goto L5;
    L7:
        Matcher r102 = sHouseNumberRe.matcher(r100).region(r101, r100.length());
        if (r102.lookingAt() == false) goto L12;
        MatchResult r103 = r102.toMatchResult();
        if (checkHouseNumber(r103.group(0)) == false) goto L12;
        return r103;
    L12:
        return null;
    L5:
        if (HOUSE_PRE_DELIM.indexOf(r100.charAt(r101 - 1)) != (-1)) goto L7;
        return null;
    }

    public static MatchResult matchState(String r100, int r101) {
        if (r101 > 0) goto L5;
    L7:
        Matcher r102 = sStateRe.matcher(r100).region(r101, r100.length());
        if (r102.lookingAt() == true) goto L10;
        return null;
    L10:
        return r102.toMatchResult();
    L5:
        if (WORD_DELIM.indexOf(r100.charAt(r101 - 1)) != (-1)) goto L7;
        return null;
    }

    public static boolean isValidZipCode(String r100, String r101) {
        return isValidZipCode(r100, matchState(r101, 0));
    }
}
