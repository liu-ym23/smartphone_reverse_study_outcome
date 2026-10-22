package com.baidu.naviapi.open;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.base.TimeUtils;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class StringUtils {
    private static final String HTML_DIST = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
    private static final String HTML_DIST_NO_DECIMAL = "<font color=\"#ffffff\">%.0f</font><font color=\"#b5b7b6\">%s</font>";
    private static final String HTML_DIST_TIME = "<font color=\"#b5b7b6\">剩:</font>%s&nbsp;&nbsp;%s";
    private static final String HTML_DIST_WITH_DECIMAL = "<font color=\"#ffffff\">%.1f</font><font color=\"#b5b7b6\">%s</font>";
    private static final String HTML_TIME_HOUR = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
    private static final String HTML_TIME_HOUR_MINUTE = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font><font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
    private static final String HTML_TIME_MINUTE = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
    private static final String LESS_ONE_MINUTE = "少于1分钟";
    private static final int SECOND_OF_DAY = 86400;
    private static final int SECOND_OF_HOUR = 3600;
    private static final int SECOND_OF_MINUTE = 60;
    public static final int TIME_EN_UNIT = -1;
    public static final int TIME_ZH_UNIT = 2;
    private static final String[] UNIT_DIST_ARRAY = null;
    private static final String UNIT_MINUTE = "分";
    private static final String[] UNIT_TIME_ARRAY = null;
    private static final String[] UNIT_TIME_ARRAY_2 = null;
    private static DecimalFormat distanceDf;

    public static final enum UnitLangEnum extends Enum<UnitLangEnum> {
        private static final /* synthetic */ UnitLangEnum[] $VALUES = null;
        public static final UnitLangEnum EN = null;
        public static final UnitLangEnum ZH = null;
        private int nUnit;

        static {
            UnitLangEnum r100 = new UnitLangEnum("EN", 0, 0);
            EN = r100;
            UnitLangEnum r101 = new UnitLangEnum("ZH", 1, 2);
            ZH = r101;
            $VALUES = new UnitLangEnum[]{r100, r101};
        }

        public static UnitLangEnum[] values() {
            return (UnitLangEnum[]) $VALUES.clone();
        }

        public int getnUnit() {
            return this.nUnit;
        }

        public static UnitLangEnum valueOf(String r100) {
            return (UnitLangEnum) a.a(UnitLangEnum.class, r100);
        }

        public void setnUnit(int r100) {
            this.nUnit = r100;
        }

        private UnitLangEnum(String r100, int r101, int r102) {
            super(r100, r101);
            this.nUnit = r102;
        }
    }

    static {
        UNIT_DIST_ARRAY = new String[]{"m", "km", "米", "公里"};
        UNIT_TIME_ARRAY = new String[]{"m", "h", "分钟", "小时"};
        UNIT_TIME_ARRAY_2 = new String[]{"m", "h", "d", "分钟", "小时", "天"};
    }

    public StringUtils() {
    }

    public static void createDir(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L9;
        r101.mkdirs();
        return;
    }

    public static String doubleNumberToChineseWord(int r100) {
        int r101 = r100 % 100;
        if (r101 >= 10) goto L7;
        return singleNumberToChineseWord(r101);
    L7:
        if (r101 != 10) goto L9;
        return "十";
    L9:
        StringBuffer r102 = new StringBuffer();
        if (r101 < 20) goto L12;
        r102.append(singleNumberToChineseWord(r101 / 10));
    L12:
        r102.append("十");
        int r103 = r101 % 10;
        if (r103 == 0) goto L16;
        r102.append(singleNumberToChineseWord(r103));
    L16:
        return r102.toString();
    }

    public static String formatDistanceToStringZHUnit(int r110) {
        int r100 = UnitLangEnum.ZH.getnUnit();
        if (r110 < 1000) goto L16;
        int r101 = r110 / 1000;
        if (r101 < 100) goto L8;
        return String.format("%d%s", new Object[]{Integer.valueOf(r101), UNIT_DIST_ARRAY[r100 + 1]});
    L8:
        if ((r110 % 1000) >= 100) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        String r103 = "#";
    L18:
        return String.format("%s%s", new Object[]{new DecimalFormat(r103).format(((double) r110) / 1000.0d), UNIT_DIST_ARRAY[r100 + 1]});
    L13:
        r103 = "#.#";
        goto L18
    L10:
        r102 = false;
        goto L11
    L16:
        return String.format("%d%s", new Object[]{Integer.valueOf(r110), UNIT_DIST_ARRAY[r100]});
    }

    public static String getFormatTime(long r100) {
        if (r100 >= 60) goto L6;
        return "小于1分钟";
    L6:
        long r101 = r100 / TimeUtils.SECONDS_PER_HOUR;
        long r102 = (r100 % TimeUtils.SECONDS_PER_HOUR) / 60;
        if ((r100 % 60) < 30) goto L10;
        r102 = r102 + 1;
    L10:
        if (r102 <= 59) goto L12;
        r101 = r101 + 1;
        r102 = 0;
    L12:
        String r103 = "";
        if (r101 >= 1) goto L15;
        String r104 = "";
    L17:
        if (r102 < 1) goto L25;
        StringBuilder r105 = new StringBuilder();
        r105.append(r102);
        if (r101 >= 1) goto L22;
        String r110 = "分钟";
    L23:
        r105.append(r110);
        r103 = r105.toString();
        goto L25
    L22:
        r110 = UNIT_MINUTE;
    L25:
        return String.format("%s%s", new Object[]{r104, r103});
    L15:
        r104 = r101 + "小时";
        goto L17
    }

    public static String getFormatTime2(long r100) {
        if (r100 >= 60) goto L6;
        return "<1分钟";
    L6:
        long r101 = r100 / TimeUtils.SECONDS_PER_HOUR;
        long r102 = (r100 % TimeUtils.SECONDS_PER_HOUR) / 60;
        if ((r100 % 60) < 30) goto L10;
        r102 = r102 + 1;
    L10:
        if (r102 <= 59) goto L12;
        r101 = r101 + 1;
        r102 = 0;
    L12:
        String r103 = "";
        if (r101 >= 1) goto L15;
        String r104 = "";
    L17:
        if (r102 < 1) goto L25;
        StringBuilder r105 = new StringBuilder();
        r105.append(r102);
        if (r101 >= 1) goto L22;
        String r110 = "分钟";
    L23:
        r105.append(r110);
        r103 = r105.toString();
        goto L25
    L22:
        r110 = UNIT_MINUTE;
    L25:
        return String.format("%s%s", new Object[]{r104, r103});
    L15:
        r104 = r101 + "小时";
        goto L17
    }

    public static boolean isEmpty(String r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isNotEmpty(String r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.length() == 0) goto L10;
        return true;
    L10:
        return false;
    }

    public static String singleNumberToChineseWord(int r100) {
        switch((r100 % 10)) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "九";
    L6:
        return "八";
    L7:
        return "七";
    L8:
        return "六";
    L9:
        return "五";
    L10:
        return "四";
    L11:
        return "三";
    L12:
        return "二";
    L13:
        return "一";
    L14:
        return "零";
    }

    public static String[] formatDistance(int r100, UnitLangEnum r101) {
        String[] r102 = new String[2];
        int r103 = r101.getnUnit();
        if (r100 >= 1000) goto L5;
        r102[0] = String.format("%d", new Object[]{Integer.valueOf(r100)});
        r102[1] = UNIT_DIST_ARRAY[r103 + 0];
    L13:
        return r102;
    L5:
        if ((r100 % 1000) != 0) goto L7;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        r102[0] = String.format("%.0f", new Object[]{Double.valueOf(((double) r100) / 1000.0d)});
        r102[1] = UNIT_DIST_ARRAY[r103 + 1];
        goto L13
    L11:
        r102[0] = String.format("%.1f", new Object[]{Double.valueOf(((double) r100) / 1000.0d)});
        r102[1] = UNIT_DIST_ARRAY[r103 + 1];
        goto L13
    L7:
        r104 = false;
        goto L9
    }

    public static String formatDistanceToString(int r100, UnitLangEnum r101) {
        StringBuffer r102 = new StringBuffer();
        formatDistance(r100, r101, r102);
        return r102.toString();
    }

    public static void formatHtmlDistance(int r100, StringBuffer r110) {
        if (r100 >= 1000) goto L5;
        if (r110 == null) goto L22;
        r110.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[]{Integer.valueOf(r100), UNIT_DIST_ARRAY[0]}));
        return;
    L22:
        return;
    L5:
        if ((r100 % 1000) != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        String r102 = HTML_DIST_NO_DECIMAL;
    L11:
        if (r110 == null) goto L19;
        int r103 = r100 / 1000;
        if (r103 < 100) goto L15;
        r110.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[]{Integer.valueOf(r103), UNIT_DIST_ARRAY[1]}));
        return;
    L15:
        r110.append(String.format(r102, new Object[]{Double.valueOf(((double) r100) / 1000.0d), UNIT_DIST_ARRAY[1]}));
        return;
    L19:
        return;
    L10:
        r102 = HTML_DIST_WITH_DECIMAL;
        goto L11
    L7:
        r101 = false;
        goto L8
    }

    public static void formatHtmlTime(int r100, StringBuffer r101) {
        if (r100 < 3600) goto L9;
        int r102 = r100 / 3600;
        int r103 = (r100 / 60) % 60;
        if (r101 == null) goto L16;
        if (r103 <= 0) goto L8;
        String[] r104 = UNIT_TIME_ARRAY;
        r101.append(String.format(HTML_TIME_HOUR_MINUTE, new Object[]{Integer.valueOf(r102), r104[1], Integer.valueOf(r103), r104[0]}));
        return;
    L8:
        r101.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[]{Integer.valueOf(r102), UNIT_TIME_ARRAY[1]}));
        return;
    L16:
        return;
    L9:
        int r105 = r100 / 60;
        if (r100 >= 60) goto L13;
        if (r101 == null) goto L19;
        r101.append(LESS_ONE_MINUTE);
        return;
    L19:
        return;
    L13:
        if (r101 == null) goto L21;
        r101.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[]{Integer.valueOf(r105), UNIT_TIME_ARRAY[0]}));
        return;
    }

    public static String[] formatTime(int r100, UnitLangEnum r101) {
        String[] r102 = new String[2];
        int r103 = r101.getnUnit();
        if (r100 < 3600) goto L6;
        int r104 = r100 % 3600;
        r102[0] = String.format("%.1f", new Object[]{Double.valueOf(((double) r100) / 1000.0d)});
        r102[1] = UNIT_TIME_ARRAY[r103 + 1];
    L9:
        return r102;
    L6:
        if (r100 >= 60) goto L8;
        r102[1] = LESS_ONE_MINUTE;
        goto L9
    L8:
        r102[0] = String.format("%d", new Object[]{Integer.valueOf(r100)});
        r102[1] = UNIT_TIME_ARRAY[r103 + 0];
        goto L9
    }

    public static String formatTime2(int r100, int r101) {
        StringBuffer r102 = new StringBuffer();
        formatTime2(r100, r101, r102);
        return r102.toString();
    }

    public static int formatZeroInt(int r100, int r101) {
        if (r101 != 0) goto L5;
        return 0;
    L5:
        int r102 = r100 / r101;
        int r103 = r102 + 1;
        if ((((double) r102) + 0.5d) < r103) goto L9;
        r102 = r103;
    L9:
        return r102 * r101;
    }

    public static String formatDistance(int r100, StringBuffer r101) {
        int r102 = 1;
        if (r100 >= 1000) goto L5;
        if (r101 == null) goto L18;
        r101.append(String.format("%d", new Object[]{Integer.valueOf(r100)}));
    L18:
        r102 = 0;
    L20:
        return UNIT_DIST_ARRAY[0 + r102];
    L5:
        if ((r100 % 1000) != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        String r104 = "%.0f";
    L11:
        if (r101 == null) goto L20;
        int r105 = r100 / 1000;
        if (r105 < 100) goto L15;
        r101.append(String.format("%d", new Object[]{Integer.valueOf(r105)}));
        goto L20
    L15:
        r101.append(String.format(r104, new Object[]{Double.valueOf(((double) r100) / 1000.0d)}));
        goto L20
    L10:
        r104 = "%.1f";
        goto L11
    L7:
        r103 = false;
        goto L8
    }

    public static void formatDistAndTime(int r100, int r101, StringBuffer r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        StringBuffer r103 = new StringBuffer();
        StringBuffer r104 = new StringBuffer();
        formatHtmlDistance(r100, r103);
        formatHtmlTime(r101, r104);
        r102.append(String.format(HTML_DIST_TIME, new Object[]{r103, r104}));
    }

    public static void formatDistance(int r100, UnitLangEnum r101, StringBuffer r110) {
        int r102 = r101.getnUnit();
        if (r100 < 1000) goto L15;
        if (r110 == null) goto L18;
        int r103 = r100 / 1000;
        if (r103 < 100) goto L9;
        r110.append(String.format("%d%s", new Object[]{Integer.valueOf(r103), UNIT_DIST_ARRAY[r102 + 1]}));
        return;
    L9:
        if ((r100 % 1000) >= 100) goto L11;
        r110.append(String.format("%.0f%s", new Object[]{Double.valueOf(((double) r100) / 1000.0d), UNIT_DIST_ARRAY[r102 + 1]}));
        return;
    L11:
        String r104 = String.format("%.1f", new Object[]{Double.valueOf(((double) r100) / 1000.0d)});
        if (r104.contains(".0") == false) goto L14;
        r104 = r104.replace(".0", "");
    L14:
        r110.append(r104);
        r110.append(UNIT_DIST_ARRAY[r102 + 1]);
        return;
    L18:
        return;
    L15:
        if (r110 == null) goto L22;
        r110.append(String.format("%d%s", new Object[]{Integer.valueOf(r100), UNIT_DIST_ARRAY[r102 + 0]}));
        return;
    }

    public static void formatDistanceV2(int r100, UnitLangEnum r110, StringBuffer r111) {
        int r112 = r110.getnUnit();
        if (r100 < 1000) goto L15;
        if (r111 == null) goto L18;
        int r101 = r100 / 1000;
        if (r101 < 100) goto L9;
        r111.append(String.format("%d%s", new Object[]{Integer.valueOf(r101), UNIT_DIST_ARRAY[r112 + 1]}));
        return;
    L9:
        if (r101 < 10) goto L12;
        r111.append(String.format("%.0f%s", new Object[]{Double.valueOf(((double) r100) / 1000.0d), UNIT_DIST_ARRAY[r112 + 1]}));
        return;
    L12:
        if (distanceDf != null) goto L14;
        DecimalFormat r102 = new DecimalFormat("#.#");
        distanceDf = r102;
        r102.setRoundingMode(RoundingMode.HALF_UP);
    L14:
        r111.append(String.format("%s%s", new Object[]{distanceDf.format(((double) r100) / 1000.0d), UNIT_DIST_ARRAY[r112 + 1]}));
        return;
    L18:
        return;
    L15:
        if (r111 == null) goto L22;
        r111.append(String.format("%d%s", new Object[]{Integer.valueOf(r100), UNIT_DIST_ARRAY[r112 + 0]}));
        return;
    }

    public static void formatTime(int r100, UnitLangEnum r101, StringBuffer r110) {
        int r102 = r101.getnUnit();
        if (r100 < 3600) goto L8;
        int r103 = r100 % 3600;
        if (r110 == null) goto L14;
        r110.append(String.format("%.0f%s", new Object[]{Double.valueOf(((double) r100) / 3600.0d), UNIT_TIME_ARRAY[r102 + 1]}));
        return;
    L14:
        return;
    L8:
        if (r100 >= 60) goto L11;
        if (r110 == null) goto L16;
        r110.append(LESS_ONE_MINUTE);
        return;
    L16:
        return;
    L11:
        if (r110 == null) goto L18;
        r110.append(String.format("%d%s", new Object[]{Integer.valueOf(r100 / 60), UNIT_TIME_ARRAY[r102 + 0]}));
        return;
    }

    public static void formatTime2(int r100, int r101, StringBuffer r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (r100 >= 60) goto L6;
        r102.append(LESS_ONE_MINUTE);
        return;
    L6:
        int r103 = (r100 / 3600) % 24;
        int r104 = (r100 / 60) % 60;
        if (r100 >= 3600) goto L10;
        r102.append(r104);
        r102.append(UNIT_TIME_ARRAY_2[r101 + 1]);
        return;
    L10:
        if (r100 >= 86400) goto L14;
        r102.append(r103);
        r102.append(UNIT_TIME_ARRAY_2[r101 + 2]);
        if (r104 <= 0) goto L21;
        r102.append(r104);
        r102.append(UNIT_MINUTE);
        return;
    L21:
        return;
    L14:
        r102.append(r100 / 86400);
        String[] r105 = UNIT_TIME_ARRAY_2;
        r102.append(r105[r101 + 3]);
        if (r103 <= 0) goto L23;
        r102.append(r103);
        r102.append(r105[r101 + 2]);
        return;
    }

    public static String customedFormatTime(int r100, String r101, String r102, String r103) {
        StringBuffer r104 = new StringBuffer();
        if (r100 >= 60) goto L5;
        r104.append(LESS_ONE_MINUTE);
    L23:
        return r104.toString();
    L5:
        if (r101 != null) goto L7;
        r101 = UNIT_TIME_ARRAY_2[5];
    L7:
        if (r102 != null) goto L9;
        r102 = UNIT_TIME_ARRAY_2[4];
    L9:
        if (r103 != null) goto L11;
        r103 = UNIT_TIME_ARRAY_2[3];
    L11:
        int r105 = (r100 / 3600) % 24;
        int r106 = (r100 / 60) % 60;
        if (r100 >= 3600) goto L15;
        r104.append(r106);
        r104.append(r103);
        goto L23
    L15:
        if (r100 >= 86400) goto L19;
        r104.append(r105);
        r104.append(r102);
        if (r106 <= 0) goto L23;
        r104.append(r106);
        r104.append(r103);
        goto L23
    L19:
        r104.append(r100 / 86400);
        r104.append(r101);
        if (r105 <= 0) goto L23;
        r104.append(r105);
        r104.append(r102);
        goto L23
    }

    public static double lineDistance(double r100, double r101, double r102, double r103) {
        double r104 = r102 - r100;
        double r105 = r103 - r101;
        return Math.sqrt((r104 * r104) + (r105 * r105));
    }

    public static int isNavStartEndPointInvalid(int r110, int r111, int r112, int r113, int r114, int r115) {
        if (r112 != r114) goto L6;
        if (r113 != r115) goto L6;
        return 1;
    L6:
        double r100 = r110;
        double r116 = r111;
        if (lineDistance(r100, r116, r114, r115) <= 50.0d) goto L11;
        return 2;
    L11:
        if (lineDistance(r100, r116, r112, r113) >= 100.0d) goto L14;
        return 3;
    L14:
        return 0;
    }
}
