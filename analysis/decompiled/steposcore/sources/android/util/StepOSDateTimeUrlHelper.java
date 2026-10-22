package android.util;

import android.os.SystemProperties;
import android.text.util.Linkify;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class StepOSDateTimeUrlHelper {
    public static final String ALL_DAY_EVENT = "1";
    public static final String APRIL_PATTERN = "[a|A][p][r][i][l]|[A][P][R][I][L]|[A|a][p][r]";
    public static final String AUGUST_PATTERN = "[a|A][u][g][u][s][t]|[A][U][G][U][S][T]|[A|a][u][g]";
    public static final String BACKSLASH_STRING = "/";
    public static final String BANG_UNICODE = "傍";
    public static final String BAN_UNICODE = "半";
    public static final String CHEN_UNICODE = "晨";
    public static final String CN_ONE_TO_FIVE = "[一|壹|二|三|四|五]";
    public static final String CN_ONE_TO_NINE = "[一|壹|二|三|四|五|六|七|八|九]";
    public static final String CN_ONE_TO_TEN = "[一|壹|二|三|四|五|六|七|八|九|十]";
    public static final String CN_ONE_TO_TWO = "[一|壹|二]";
    public static final String CN_ZERO_TO_FOUR = "[零|一|壹|二|三|四]";
    public static final String CN_ZERO_TO_TEN = "[零|一|壹|二|三|四|五|六|七|八|九|十]";
    public static final String COLON_STRING = ":";
    public static final String COLON_UNICODE = "：";
    public static final String COMMA_CN_STRING = "，";
    public static final String COMMA_STRING = ",";
    public static final String COMMA_UNICODE = "，";
    public static final String DA_UNICODE = "大";
    public static final String DECEMBER_PATTERN = "[d|D][e][c][e][m][b][e][r]|[D][E][C][E][M][B][E][R]|[D|d][e][c]";
    public static final String DIAN_UNICODE = "点";
    public static final String DIAN_UNICODE_TW = "點";
    public static final char EHIGE_CHAR = 20843;
    public static final String EHIGE_UNICODE = "八";
    public static final String EVENT_TYPE_STRING = "+";
    public static final String FEBRUARY_PATTERN = "[f|F][e][b][r][u][a][r][y]|[F][E][B][R][U][A][R][Y]|[F|f][e][b]";
    public static final String FEN_UNICODE = "分";
    public static final char FIVE_CHAR = 20116;
    public static final String FIVE_UNICODE = "五";
    public static final String FORMAT_H_M = "HH:mm";
    public static final String FORMAT_H_M_S = "HH:mm:ss";
    public static final String FORMAT_Y_M_D = "yyyy/MM/dd";
    public static final String FORMAT_Y_M_D_2 = "yyyy-MM-dd";
    public static final String FORMAT_Y_M_D_H_M_1 = "yyyy/MM/dd HH:mm";
    public static final String FORMAT_Y_M_D_H_M_2 = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_Y_M_D_NO_SEPARATOR = "yyyyMMdd";
    public static final char FOUR_CHAR = 22235;
    public static final String FOUR_UNICODE = "四";
    public static final String HOU_UNICODE = "后";
    public static final String HOU_UNICODE_TW = "後";
    public static final String JANUARY_PATTERN = "[j|J][a][n][u][a][r][y]|[J][A][N][U][A][R][Y]|[J|j][a][n]";
    public static final String JIN_UNICODE = "今";
    public static final String JULY_PATTERN = "[j|J][u][l][y]|[J][U][L][Y]|[J|j][u][l]";
    public static final String JUNE_PATTERN = "[j|J][u][n][e]|[J][U][N][E]|[J|j][u][n]";
    public static final String KE_UNICODE = "刻";
    public static final String LING_UNICODE = "凌";
    public static final String MARCH_PATTERN = "[m|M][a][r][c][h]|[M][A][R][C][H]|[M|m][a][r]";
    public static final String MAY_PATTERN = "[m|M][a][y]|[M][A][Y]|[M|m][a][y]";
    public static final String MIAO_UNICODE = "秒";
    public static final String MING_UNICODE = "明";
    public static final String NIAN_UNICODE = "年";
    public static final char NINE_CHAR = 20061;
    public static final String NINE_UNICODE = "九";
    public static final String NOVEMBER_PATTERN = "[n|N][o][v][e][m][b][e][r]|[N][O][V][E][M][B][E][R]|[N|n][o][v]";
    public static final int NUM_0 = 0;
    public static final int NUM_1 = 1;
    public static final int NUM_10 = 10;
    public static final int NUM_100 = 100;
    public static final int NUM_11 = 11;
    public static final int NUM_12 = 12;
    public static final int NUM_13 = 13;
    public static final int NUM_15 = 15;
    public static final int NUM_16 = 16;
    public static final int NUM_1900 = 1900;
    public static final int NUM_2 = 2;
    public static final int NUM_20 = 20;
    public static final int NUM_21 = 21;
    public static final int NUM_23 = 23;
    public static final int NUM_28 = 28;
    public static final int NUM_29 = 29;
    public static final int NUM_3 = 3;
    public static final int NUM_30 = 30;
    public static final int NUM_31 = 31;
    public static final int NUM_4 = 4;
    public static final int NUM_400 = 400;
    public static final int NUM_5 = 5;
    public static final int NUM_59 = 59;
    public static final int NUM_6 = 6;
    public static final int NUM_7 = 7;
    public static final int NUM_8 = 8;
    public static final int NUM_9 = 9;
    public static final int NUM_NEGATIVE_1 = -1;
    public static final String OCTOBER_PATTERN = "[o|O][c][t][o][b][e][r]|[O][C][T][O][B][E][R]|[O|o][c][t]";
    public static final char ONE_CHAR = 19968;
    public static final char ONE_CHAR_TW = 22777;
    public static final long ONE_DAY = 86400000;
    public static final String ONE_UNICODE = "一";
    public static final String ONE_UNICODE_TW = "壹";
    public static final String QI_UNICODE = "期";
    public static final char RI_CHAR = 26085;
    public static final String RI_UNICODE = "日";
    public static final String SEPTEMBER_PATTERN = "[s|S][e][p][t][e][m][b][e][r]|[S][E][P][T][E][M][B][E][R]|[S|s][e][p]|[S|s][e][p][t]";
    public static final char SEVEN_CHAR = 19971;
    public static final String SEVEN_UNICODE = "七";
    public static final String SHANG_UNICODE = "上";
    public static final char SIX_CHAR = 20845;
    public static final String SIX_UNICODE = "六";
    public static final String SPACE_STRING = " ";
    public static final String START_TIME_EVENT = "2";
    private static final String TAG = "StepOSDateTimeUrlHelper";
    public static final char TEN_CHAR = 21313;
    public static final String TEN_UNICODE = "十";
    public static final char THREE_CHAR = 19977;
    public static final String THREE_UNICODE = "三";
    public static final char TIAN_CHAR = 22825;
    public static final String TIAN_UNICODE = "天";
    public static final String TIME_TO_TIME_EVENT = "3";
    public static final String TIME_TO_TIME_STRING = "-";
    public static final char TWO_CHAR = 20108;
    public static final String TWO_UNICODE = "二";
    public static final String UNKNOW_EVENT = "-1";
    public static final String URL_TIME_STRING = "=";
    public static final String WAN_UNICODE = "晚";
    public static final String WU_UNICODE = "午";
    public static final String XIA_UNICODE = "下";
    public static final String XING_UNICODE = "星";
    public static final String YUE_UNICODE = "月";
    public static final String ZAO_UNICODE = "早";
    public static final char ZERO_CHAR = 38646;
    public static final String ZERO_UNICODE = "零";
    public static final String ZHONG_UNICODE = "中";
    public static final String ZHOU_UNICODE = "周";
    public static final String CN_ZERO_TO_NINE = "[零|一|壹|二|三|四|五|六|七|八|九]";
    public static final Pattern CN_NUMBER = Pattern.compile(CN_ZERO_TO_NINE);
    public static final String JANUARY = "jan";
    public static final String FEBRUARY = "feb";
    public static final String MARCH = "mar";
    public static final String APRIL = "apr";
    public static final String MAY = "may";
    public static final String JUNE = "jun";
    public static final String JULY = "jul";
    public static final String AUGUST = "aug";
    public static final String SEPTEMBER = "sep";
    public static final String OCTOBER = "oct";
    public static final String NOVEMBER = "nov";
    public static final String DECEMBER = "dec";
    public static final String[] MONTH_STRINGS = {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
    public static final Pattern PATTERN_Y_M_D = Pattern.compile("((([1-9][0-9][0-9][0-9])[\\/-]([0-9][0-9]|[0-9])[\\/-]?([0-9][0-9]|[0-9])))");
    public static final Pattern PATTERN_Y_M_D_CN = Pattern.compile("(((([1-9][0-9][0-9][0-9])|([一|壹|二|三|四|五|六|七|八|九][零|一|壹|二|三|四|五|六|七|八|九]{3}))([年])(([0-9][0-9]|[0-9])|(十[一|壹|二]?)|([一|壹|二|三|四|五|六|七|八|九]))([月])(([0-9][0-9]|[0-9])|([一|壹|二|三|四|五|六|七|八|九]?十[一|壹|二|三|四|五|六|七|八|九]?)|([一|壹|二|三|四|五|六|七|八|九]))([日]?)))");
    public static final Pattern PATTERN_M_D_Y_EN = Pattern.compile("(([j|J][a][n][u][a][r][y]|[J][A][N][U][A][R][Y]|[J|j][a][n]|[f|F][e][b][r][u][a][r][y]|[F][E][B][R][U][A][R][Y]|[F|f][e][b]|[m|M][a][r][c][h]|[M][A][R][C][H]|[M|m][a][r]|[a|A][p][r][i][l]|[A][P][R][I][L]|[A|a][p][r]|[m|M][a][y]|[M][A][Y]|[M|m][a][y]|[j|J][u][n][e]|[J][U][N][E]|[J|j][u][n]|[j|J][u][l][y]|[J][U][L][Y]|[J|j][u][l]|[a|A][u][g][u][s][t]|[A][U][G][U][S][T]|[A|a][u][g]|[s|S][e][p][t][e][m][b][e][r]|[S][E][P][T][E][M][B][E][R]|[S|s][e][p]|[S|s][e][p][t]|[o|O][c][t][o][b][e][r]|[O][C][T][O][B][E][R]|[O|o][c][t]|[n|N][o][v][e][m][b][e][r]|[N][O][V][E][M][B][E][R]|[N|n][o][v]|[d|D][e][c][e][m][b][e][r]|[D][E][C][E][M][B][E][R]|[D|d][e][c])\\s+([0-9][0-9]|[0-9])([\\,|，])(\\s?)([1-9][0-9][0-9][0-9]))");
    public static final Pattern PATTERN_M_D_EN = Pattern.compile("(([j|J][a][n][u][a][r][y]|[J][A][N][U][A][R][Y]|[J|j][a][n]|[f|F][e][b][r][u][a][r][y]|[F][E][B][R][U][A][R][Y]|[F|f][e][b]|[m|M][a][r][c][h]|[M][A][R][C][H]|[M|m][a][r]|[a|A][p][r][i][l]|[A][P][R][I][L]|[A|a][p][r]|[m|M][a][y]|[M][A][Y]|[M|m][a][y]|[j|J][u][n][e]|[J][U][N][E]|[J|j][u][n]|[j|J][u][l][y]|[J][U][L][Y]|[J|j][u][l]|[a|A][u][g][u][s][t]|[A][U][G][U][S][T]|[A|a][u][g]|[s|S][e][p][t][e][m][b][e][r]|[S][E][P][T][E][M][B][E][R]|[S|s][e][p]|[S|s][e][p][t]|[o|O][c][t][o][b][e][r]|[O][C][T][O][B][E][R]|[O|o][c][t]|[n|N][o][v][e][m][b][e][r]|[N][O][V][E][M][B][E][R]|[N|n][o][v]|[d|D][e][c][e][m][b][e][r]|[D][E][C][E][M][B][E][R]|[D|d][e][c])\\s+([0-9][0-9]|[0-9]))");
    public static final Pattern PATTERN_M_D_CN = Pattern.compile("((([0-9][0-9]|[0-9])([月])([0-9][0-9]|[0-9])([日])))");
    public static final Pattern PATTERN_M_D_ALL_CN = Pattern.compile("((([十][一|壹|二|三|四|五|六|七|八|九])|([一|壹|二|三|四|五|六|七|八|九|十]))([月])(([二|三][十])|([二|三][十][一|壹|二|三|四|五|六|七|八|九])|([十][一|壹|二|三|四|五|六|七|八|九])|([一|壹|二|三|四|五|六|七|八|九|十]))([日]))");
    public static final Pattern PATTERN_Y_M_D_H_M = Pattern.compile("((([1-9][0-9][0-9][0-9])[\\/-]([0-9][0-9]|[0-9])[\\/-]([0-9][0-9]|[0-9])\\u0020+([0-2][0-9]|[0-9])([\\:|：])([0-5][0-9])))");
    public static final Pattern PATTERN_TIME_TO_TIME = Pattern.compile("((([0-2][0-9]|[0-9])([\\:|：])([0-5][0-9])\\-([0-2][0-9]|[0-9])([\\:|：])([0-5][0-9])))");
    public static final Pattern PATTERN_TIAN_WU_CN = Pattern.compile("(([大][后]|[大][後]|[今]|[明]|[后]|[後])[天]([上|中|下][午]|[晚][上]|[早][上]))");
    public static final Pattern PATTERN_DAY_WU_CN = Pattern.compile("(([周]|[星][期])([一|壹|二|三|四|五|六|七|日|天])([上|中|下][午]|[晚][上]|[早][上]))");
    public static final Pattern PATTERN_NEXT_DAY_OF_WEEK = Pattern.compile("(([下])([周]|[星][期])([一|壹|二|三|四|五|六|七|日|天]))");
    public static final Pattern PATTERN_TIME = Pattern.compile("((([0-2][0-9]|[0-9])|(二十[一|壹|二|三|四|五|六|七|八|九]?)|(十[一|壹|二|三|四|五|六|七|八|九]?)|([零|一|壹|二|三|四|五|六|七|八|九]))([\\:|：|点|點])(([0-5][0-9])|([一|壹|二|三|四|五]?十[一|壹|二|三|四|五|六|七|八|九]?)|([零|一|壹|二|三|四|五|六|七|八|九])))分?");
    public static final Pattern PATTERN_WU_TIME = Pattern.compile("((([凌][晨])([0-4]|[零|一|壹|二|三|四])([点|點])(半|([0-3]|[一|壹|二|三])刻)?)|(([中][午])(([1][1]|[1][2]|[1]|[2])|(([十][一])|([十][壹])|([十][二])|([一|壹|二])))([点|點]))|(([傍][晚])([五|六|七]|[5|6|7])([点|點])(半|([0-3]|[一|壹|二|三])刻)?)|(([上][午]|[早][上])(([0-9]|[1][0]|[1][1]|[1][2])|([零|一|壹|二|三|四|五|六|七|八|九|十])|([十][一]|[十][壹]|[十][二]))([点|點])(半|([0-3]|[一|壹|二|三])刻)?)|(([下][午])(([1-6]|[1][2])|([零|一|壹|二|三|四|五|六])|([十][二]))([点|點])(半|([0-3]|[一|壹|二|三])刻)?)|(([晚][上])(([6-9]|[1][0]|[1][1])|([六|七|八|九|十])|([十][一]|[十][壹]))([点|點])(半|([0-3]|[一|壹|二|三])刻)?))");
    public static final Pattern DATE_TIME_PATTERN = Pattern.compile("(" + PATTERN_Y_M_D_H_M + "|" + PATTERN_Y_M_D + "|" + PATTERN_TIME_TO_TIME + "|" + PATTERN_TIAN_WU_CN + "|" + PATTERN_DAY_WU_CN + "|" + PATTERN_Y_M_D_CN + "|" + PATTERN_M_D_CN + "|" + PATTERN_TIME + "|" + PATTERN_M_D_ALL_CN + "|" + PATTERN_M_D_Y_EN + "|" + PATTERN_M_D_EN + "|" + PATTERN_NEXT_DAY_OF_WEEK + "|" + PATTERN_WU_TIME + ")");
    public static final Linkify.TransformFilter sDateTimeTransformFilter = new Linkify.TransformFilter() { // from class: android.util.StepOSDateTimeUrlHelper.1
        @Override // android.text.util.Linkify.TransformFilter
        public final String transformUrl(Matcher match, String url) {
            String matchingRegion = match.group();
            return StepOSDateTimeUrlHelper.parserDateTime(matchingRegion);
        }
    };
    public static final Linkify.MatchFilter sDateTimeMatchFilter = new Linkify.MatchFilter() { // from class: android.util.StepOSDateTimeUrlHelper.2
        @Override // android.text.util.Linkify.MatchFilter
        public final boolean acceptMatch(CharSequence s, int start, int end) {
            SimpleDateFormat sdf;
            String matchingRegion = s.subSequence(start, end).toString();
            new Date();
            if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_Y_M_D_H_M, matchingRegion)) {
                try {
                    if (StepOSDateTimeUrlHelper.validateDate(matchingRegion.substring(0, matchingRegion.indexOf(" "))) && StepOSDateTimeUrlHelper.validateTime(matchingRegion.substring(matchingRegion.indexOf(" ") + 1, matchingRegion.length()))) {
                        if (matchingRegion.contains(StepOSDateTimeUrlHelper.BACKSLASH_STRING)) {
                            sdf = new SimpleDateFormat(StepOSDateTimeUrlHelper.FORMAT_Y_M_D_H_M_1);
                        } else {
                            sdf = new SimpleDateFormat(StepOSDateTimeUrlHelper.FORMAT_Y_M_D_H_M_2);
                        }
                        Date date = sdf.parse(matchingRegion);
                        if (StepOSDateTimeUrlHelper.isFutureTime(date)) {
                            return true;
                        }
                    }
                    return false;
                } catch (ParseException e) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_Y_M_D, matchingRegion)) {
                try {
                    if (!StepOSDateTimeUrlHelper.validateDate(matchingRegion)) {
                        return false;
                    }
                    SimpleDateFormat sdf2 = null;
                    if (matchingRegion.indexOf(StepOSDateTimeUrlHelper.BACKSLASH_STRING) != -1) {
                        sdf2 = new SimpleDateFormat(StepOSDateTimeUrlHelper.FORMAT_Y_M_D);
                    } else if (matchingRegion.indexOf(StepOSDateTimeUrlHelper.TIME_TO_TIME_STRING) != -1) {
                        sdf2 = new SimpleDateFormat(StepOSDateTimeUrlHelper.FORMAT_Y_M_D_2);
                    }
                    Date date2 = sdf2.parse(matchingRegion);
                    if (!StepOSDateTimeUrlHelper.isGYChinaTelecom()) {
                        if (StepOSDateTimeUrlHelper.isTodayOrFuture(date2)) {
                        }
                    }
                    return true;
                } catch (ParseException e2) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e2.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_TIME_TO_TIME, matchingRegion)) {
                try {
                    Date[] dates = StepOSDateTimeUrlHelper.createTimeToTimeDates(matchingRegion);
                    if (dates != null && dates[0].getTime() < dates[1].getTime()) {
                        if (StepOSDateTimeUrlHelper.isFutureTime(dates[0])) {
                            return true;
                        }
                    }
                } catch (Exception e3) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e3.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_TIAN_WU_CN, matchingRegion)) {
                try {
                    if (StepOSDateTimeUrlHelper.isFutureTime(StepOSDateTimeUrlHelper.createDateByTianWu(matchingRegion)[0])) {
                        return true;
                    }
                } catch (Exception e4) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e4.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_Y_M_D_CN, matchingRegion)) {
                try {
                    String matchingRegion2 = StepOSDateTimeUrlHelper.switchFormat(matchingRegion);
                    if (!StepOSDateTimeUrlHelper.validateDate(matchingRegion2)) {
                        return false;
                    }
                    SimpleDateFormat sdf3 = new SimpleDateFormat(StepOSDateTimeUrlHelper.FORMAT_Y_M_D);
                    Date date3 = sdf3.parse(matchingRegion2);
                    if (!StepOSDateTimeUrlHelper.isGYChinaTelecom()) {
                        if (StepOSDateTimeUrlHelper.isTodayOrFuture(date3)) {
                        }
                    }
                    return true;
                } catch (ParseException e5) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e5.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_M_D_CN, matchingRegion)) {
                try {
                    String matchingRegion3 = StepOSDateTimeUrlHelper.switchFormatNoYear(matchingRegion);
                    if (!StepOSDateTimeUrlHelper.validateDate(matchingRegion3)) {
                        return false;
                    }
                    SimpleDateFormat sdf4 = new SimpleDateFormat(StepOSDateTimeUrlHelper.FORMAT_Y_M_D);
                    Date date4 = sdf4.parse(matchingRegion3);
                    if (!StepOSDateTimeUrlHelper.isGYChinaTelecom()) {
                        if (StepOSDateTimeUrlHelper.isTodayOrFuture(date4)) {
                        }
                    }
                    return true;
                } catch (ParseException e6) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e6.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_M_D_ALL_CN, matchingRegion)) {
                try {
                    String matchingRegion4 = StepOSDateTimeUrlHelper.switchFormatNoYear(StepOSDateTimeUrlHelper.changeCNToNum(matchingRegion));
                    if (!StepOSDateTimeUrlHelper.validateDate(matchingRegion4)) {
                        return false;
                    }
                    SimpleDateFormat sdf5 = new SimpleDateFormat(StepOSDateTimeUrlHelper.FORMAT_Y_M_D);
                    Date date5 = sdf5.parse(matchingRegion4);
                    if (StepOSDateTimeUrlHelper.isTodayOrFuture(date5)) {
                        return true;
                    }
                } catch (ParseException e7) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e7.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_TIME, matchingRegion)) {
                if (!StepOSDateTimeUrlHelper.validateTime(matchingRegion)) {
                    return false;
                }
                Date date6 = StepOSDateTimeUrlHelper.createTimePointDates(matchingRegion);
                if (StepOSDateTimeUrlHelper.isFutureTime(date6)) {
                    return true;
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_DAY_WU_CN, matchingRegion)) {
                try {
                    Date[] dates2 = StepOSDateTimeUrlHelper.createDateByDayWu(matchingRegion);
                    if (dates2 != null && dates2[0].getTime() < dates2[1].getTime()) {
                        if (StepOSDateTimeUrlHelper.isFutureTime(dates2[0])) {
                            return true;
                        }
                    }
                } catch (Exception e8) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e8.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_NEXT_DAY_OF_WEEK, matchingRegion)) {
                try {
                    Date date7 = StepOSDateTimeUrlHelper.createDateByNextDayOfWeek(matchingRegion);
                    if (date7 == null) {
                        return false;
                    }
                    if (StepOSDateTimeUrlHelper.isTodayOrFuture(date7)) {
                        return true;
                    }
                } catch (Exception e9) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e9.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_M_D_Y_EN, matchingRegion)) {
                try {
                    Date date8 = StepOSDateTimeUrlHelper.createDateByEN_M_D_Y(matchingRegion);
                    if (date8 == null) {
                        return false;
                    }
                    if (StepOSDateTimeUrlHelper.isTodayOrFuture(date8)) {
                        return true;
                    }
                } catch (Exception e10) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e10.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_M_D_EN, matchingRegion)) {
                try {
                    Date date9 = StepOSDateTimeUrlHelper.createDateByEN_M_D(matchingRegion);
                    if (date9 == null) {
                        return false;
                    }
                    if (StepOSDateTimeUrlHelper.isTodayOrFuture(date9)) {
                        return true;
                    }
                } catch (Exception e11) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e11.getMessage());
                }
            } else if (StepOSDateTimeUrlHelper.match(StepOSDateTimeUrlHelper.PATTERN_WU_TIME, matchingRegion)) {
                try {
                    Date date10 = StepOSDateTimeUrlHelper.createDateByCN_Wu_Dian(matchingRegion);
                    if (date10 == null) {
                        return false;
                    }
                    if (StepOSDateTimeUrlHelper.isFutureTime(date10)) {
                        return true;
                    }
                } catch (Exception e12) {
                    Log.d(StepOSDateTimeUrlHelper.TAG, e12.getMessage());
                }
            }
            return false;
        }
    };

    public static boolean validateDate(String str) throws NumberFormatException {
        int first;
        int second;
        if (str.contains(BACKSLASH_STRING)) {
            first = str.indexOf(BACKSLASH_STRING);
            second = str.lastIndexOf(BACKSLASH_STRING);
        } else {
            first = str.indexOf(TIME_TO_TIME_STRING);
            second = str.lastIndexOf(TIME_TO_TIME_STRING);
        }
        if (first == second) {
            Log.d(TAG, "Input String must has / or -");
            return false;
        }
        String year = str.substring(0, first);
        String month = str.substring(first + 1, second);
        String day = str.substring(second + 1, str.length());
        int maxDays = 31;
        Log.d(TAG, year + BACKSLASH_STRING + month + BACKSLASH_STRING + day);
        if (!isNumber(year) || !isNumber(month) || !isNumber(day)) {
            Log.d(TAG, "Input String error");
            return false;
        }
        if (year.length() < 4) {
            Log.d(TAG, "Input year num < 4");
            return false;
        }
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        if (m > 12 || m < 1) {
            Log.d(TAG, "the month must 1 to 12");
            return false;
        }
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxDays = 30;
        } else if (m == 2) {
            if (y % 4 > 0) {
                maxDays = 28;
            } else if (y % 100 == 0 && y % NUM_400 > 0) {
                maxDays = 28;
            } else {
                maxDays = 29;
            }
        }
        if (d >= 1 && d <= maxDays) {
            return true;
        }
        Log.d(TAG, "the day is error");
        return false;
    }

    public static boolean validateTime(String str) throws NumberFormatException {
        int s;
        if (str.contains(DIAN_UNICODE) || str.contains(DIAN_UNICODE_TW)) {
            str = cnTimeTransform(str);
        }
        int first = str.indexOf(COLON_STRING);
        if (first == -1) {
            Log.d(TAG, "Input String must has : ");
            return false;
        }
        String[] times = str.split(COLON_STRING);
        String hour = times[0];
        String min = times[1];
        String second = null;
        if (times.length == 3) {
            second = times[2];
        }
        Log.d(TAG, hour + COLON_STRING + min);
        if (!isNumber(hour) || !isNumber(min)) {
            Log.d(TAG, "Input String error");
            return false;
        }
        if (second != null && (!isNumber(second) || (s = Integer.parseInt(second)) > 59 || s < 0)) {
            return false;
        }
        int h = Integer.parseInt(hour);
        int m = Integer.parseInt(min);
        if (m > 59 || m < 0) {
            Log.d(TAG, "the min must 0 to 59");
            return false;
        }
        if (h >= 0 && h <= 23) {
            return true;
        }
        Log.d(TAG, "the hour is error");
        return false;
    }

    private static boolean isNumber(String value) throws NumberFormatException {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String parserDateTime(String matchingRegion) {
        SimpleDateFormat sdf;
        SimpleDateFormat sdf2;
        new Date();
        if (match(PATTERN_Y_M_D_H_M, matchingRegion)) {
            try {
                if (matchingRegion.contains(BACKSLASH_STRING)) {
                    sdf2 = new SimpleDateFormat(FORMAT_Y_M_D_H_M_1);
                } else {
                    sdf2 = new SimpleDateFormat(FORMAT_Y_M_D_H_M_2);
                }
                Date date = sdf2.parse(matchingRegion);
                return matchingRegion + URL_TIME_STRING + date.getTime() + EVENT_TYPE_STRING + "2";
            } catch (ParseException e) {
                Log.d(TAG, e.getMessage());
            }
        } else if (match(PATTERN_Y_M_D, matchingRegion)) {
            try {
                if (matchingRegion.indexOf(BACKSLASH_STRING) != -1) {
                    sdf = new SimpleDateFormat(FORMAT_Y_M_D);
                } else if (matchingRegion.indexOf(TIME_TO_TIME_STRING) != -1) {
                    sdf = new SimpleDateFormat(FORMAT_Y_M_D_2);
                } else {
                    sdf = new SimpleDateFormat(FORMAT_Y_M_D_NO_SEPARATOR);
                }
                Date date2 = sdf.parse(matchingRegion);
                return matchingRegion + URL_TIME_STRING + date2.getTime() + EVENT_TYPE_STRING + "1";
            } catch (ParseException e2) {
                Log.d(TAG, e2.getMessage());
            }
        } else if (match(PATTERN_TIME_TO_TIME, matchingRegion)) {
            try {
                Date[] dates = createTimeToTimeDates(matchingRegion);
                if (dates == null) {
                    return matchingRegion;
                }
                return matchingRegion + URL_TIME_STRING + dates[0].getTime() + TIME_TO_TIME_STRING + dates[1].getTime() + EVENT_TYPE_STRING + "3";
            } catch (Exception e3) {
                Log.d(TAG, e3.getMessage());
            }
        } else if (match(PATTERN_TIAN_WU_CN, matchingRegion)) {
            try {
                Date[] dates2 = createDateByTianWu(matchingRegion);
                return matchingRegion + URL_TIME_STRING + dates2[0].getTime() + TIME_TO_TIME_STRING + dates2[1].getTime() + EVENT_TYPE_STRING + "3";
            } catch (Exception e4) {
                Log.d(TAG, e4.getMessage());
            }
        } else if (match(PATTERN_Y_M_D_CN, matchingRegion)) {
            try {
                SimpleDateFormat sdf3 = new SimpleDateFormat(FORMAT_Y_M_D);
                Date date3 = sdf3.parse(switchFormat(matchingRegion));
                return matchingRegion + URL_TIME_STRING + date3.getTime() + EVENT_TYPE_STRING + "1";
            } catch (ParseException e5) {
                Log.d(TAG, e5.getMessage());
            }
        } else if (match(PATTERN_M_D_CN, matchingRegion)) {
            try {
                SimpleDateFormat sdf4 = new SimpleDateFormat(FORMAT_Y_M_D);
                Date date4 = sdf4.parse(switchFormatNoYear(matchingRegion));
                return matchingRegion + URL_TIME_STRING + date4.getTime() + EVENT_TYPE_STRING + "1";
            } catch (ParseException e6) {
                Log.d(TAG, e6.getMessage());
            }
        } else if (match(PATTERN_M_D_ALL_CN, matchingRegion)) {
            try {
                String temp = changeCNToNum(matchingRegion);
                SimpleDateFormat sdf5 = new SimpleDateFormat(FORMAT_Y_M_D);
                Date date5 = sdf5.parse(switchFormatNoYear(temp));
                return matchingRegion + URL_TIME_STRING + date5.getTime() + EVENT_TYPE_STRING + "1";
            } catch (ParseException e7) {
                Log.d(TAG, e7.getMessage());
            }
        } else {
            if (match(PATTERN_TIME, matchingRegion)) {
                Date date6 = createTimePointDates(matchingRegion);
                return matchingRegion + URL_TIME_STRING + date6.getTime() + EVENT_TYPE_STRING + "2";
            }
            if (match(PATTERN_DAY_WU_CN, matchingRegion)) {
                try {
                    Date[] dates3 = createDateByDayWu(matchingRegion);
                    return matchingRegion + URL_TIME_STRING + dates3[0].getTime() + TIME_TO_TIME_STRING + dates3[1].getTime() + EVENT_TYPE_STRING + "3";
                } catch (Exception e8) {
                    Log.d(TAG, e8.getMessage());
                }
            } else if (match(PATTERN_NEXT_DAY_OF_WEEK, matchingRegion)) {
                try {
                    Date date7 = createDateByNextDayOfWeek(matchingRegion);
                    return matchingRegion + URL_TIME_STRING + date7.getTime() + EVENT_TYPE_STRING + "1";
                } catch (Exception e9) {
                    Log.d(TAG, e9.getMessage());
                }
            } else if (match(PATTERN_M_D_Y_EN, matchingRegion)) {
                try {
                    Date date8 = createDateByEN_M_D_Y(matchingRegion);
                    return matchingRegion + URL_TIME_STRING + date8.getTime() + EVENT_TYPE_STRING + "1";
                } catch (Exception e10) {
                    Log.d(TAG, e10.getMessage());
                }
            } else if (match(PATTERN_M_D_EN, matchingRegion)) {
                try {
                    Date date9 = createDateByEN_M_D(matchingRegion);
                    return matchingRegion + URL_TIME_STRING + date9.getTime() + EVENT_TYPE_STRING + "1";
                } catch (Exception e11) {
                    Log.d(TAG, e11.getMessage());
                }
            } else if (match(PATTERN_WU_TIME, matchingRegion)) {
                try {
                    Date date10 = createDateByCN_Wu_Dian(matchingRegion);
                    return matchingRegion + URL_TIME_STRING + date10.getTime() + EVENT_TYPE_STRING + "2";
                } catch (Exception e12) {
                    Log.d(TAG, e12.getMessage());
                }
            }
        }
        return matchingRegion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean match(Pattern pattern, String value) {
        Matcher match = pattern.matcher(value);
        return match.matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isFutureTime(Date date) {
        Date now = new Date();
        if (now.getTime() >= date.getTime()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTodayOrFuture(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar target = Calendar.getInstance();
        target.setTime(date);
        clearTimeOfDay(now);
        clearTimeOfDay(target);
        return !target.before(now);
    }

    private static void clearTimeOfDay(Calendar cal) {
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isGYChinaTelecom() {
        return SystemProperties.getBoolean("ro.vendor.stepos.build.isgy", false) && SystemProperties.get("ro.vendor.customize.isp", "").equals("chinatelecom");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String changeCNToNum(String date) {
        int N = date.length();
        int[] temp = new int[N];
        int yue = -1;
        int ri = -1;
        StringBuffer newDate = new StringBuffer();
        for (int i = 0; i < N; i++) {
            char c = date.charAt(i);
            if (isCNDigit(c)) {
                temp[i] = changeNum(c);
            } else {
                temp[i] = -1;
                if (yue == -1) {
                    yue = i;
                } else {
                    ri = i;
                }
            }
        }
        if (yue == 1) {
            int month = temp[0];
            newDate.append(month + BACKSLASH_STRING);
        } else if (yue == 2) {
            int month2 = temp[0] + temp[1];
            newDate.append(month2 + BACKSLASH_STRING);
        }
        if (ri - yue == 2) {
            int day = temp[yue + 1];
            newDate.append(day);
        } else if (ri - yue == 3) {
            if (temp[yue + 1] == 10) {
                int day2 = temp[yue + 1] + temp[yue + 2];
                newDate.append(day2);
            } else {
                int day3 = temp[yue + 1] * temp[yue + 2];
                newDate.append(day3);
            }
        } else if (ri - yue == 4) {
            int day4 = (temp[yue + 1] * temp[yue + 2]) + temp[yue + 3];
            newDate.append(day4);
        }
        return newDate.toString();
    }

    private static int changeNum(char charAt) {
        switch (charAt) {
            case 19968:
                return 1;
            case 19971:
                return 7;
            case 19977:
                return 3;
            case 20061:
                return 9;
            case 20108:
                return 2;
            case 20116:
                return 5;
            case 20843:
                return 8;
            case 20845:
                return 6;
            case 21313:
                return 10;
            case 22235:
                return 4;
            case 22777:
                return 1;
            default:
                return 0;
        }
    }

    private static boolean isCNDigit(char charAt) {
        if (charAt == 38646 || charAt == 19968 || charAt == 22777 || charAt == 20108 || charAt == 19977 || charAt == 22235 || charAt == 20116 || charAt == 20845 || charAt == 19971 || charAt == 20843 || charAt == 20061 || charAt == 21313) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String switchFormat(String date) {
        StringBuffer newDate = new StringBuffer();
        for (int i = 0; i < date.length(); i++) {
            char c = date.charAt(i);
            if (Character.isDigit(c)) {
                newDate.append(c);
            } else if (isCNDigit(c)) {
                if (c == 21313) {
                    if (isCNDigit(date.charAt(i - 1))) {
                        if (i >= date.length() - 1 || !isCNDigit(date.charAt(i + 1))) {
                            c = ZERO_CHAR;
                            newDate.append(changeNum(c));
                        }
                    } else if (i == date.length() - 1 || (i < date.length() - 1 && !isCNDigit(date.charAt(i + 1)))) {
                        newDate.append("10");
                    } else {
                        c = ONE_CHAR;
                        newDate.append(changeNum(c));
                    }
                } else {
                    newDate.append(changeNum(c));
                }
            } else if (i != date.length() - 1) {
                newDate.append(BACKSLASH_STRING);
            }
        }
        return newDate.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String switchFormatNoYear(String date) {
        Date now = new Date();
        StringBuffer newDate = new StringBuffer((now.getYear() + NUM_1900) + BACKSLASH_STRING);
        for (int i = 0; i < date.length(); i++) {
            if (Character.isDigit(date.charAt(i))) {
                newDate.append(date.charAt(i));
            } else if (i != date.length() - 1) {
                newDate.append(BACKSLASH_STRING);
            }
        }
        return newDate.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Date[] createTimeToTimeDates(String matchingRegion) {
        String startTime = matchingRegion.substring(0, matchingRegion.indexOf(TIME_TO_TIME_STRING));
        String endTime = matchingRegion.substring(matchingRegion.indexOf(TIME_TO_TIME_STRING) + 1, matchingRegion.length());
        if (!validateTime(startTime) || !validateTime(endTime)) {
            return null;
        }
        Date startDate = new Date();
        startDate.setHours(Integer.parseInt(startTime.subSequence(0, startTime.indexOf(COLON_STRING)).toString()));
        startDate.setMinutes(Integer.parseInt(startTime.subSequence(startTime.indexOf(COLON_STRING) + 1, startTime.length()).toString()));
        Date endDate = new Date();
        endDate.setHours(Integer.parseInt(endTime.subSequence(0, endTime.indexOf(COLON_STRING)).toString()));
        endDate.setMinutes(Integer.parseInt(endTime.subSequence(endTime.indexOf(COLON_STRING) + 1, endTime.length()).toString()));
        Date[] value = {startDate, endDate};
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Date createTimePointDates(String matchingRegion) {
        Date startDate = new Date();
        String timeStr = cnTimeTransform(matchingRegion);
        String[] timeStrs = timeStr.split(COLON_STRING);
        if (timeStrs.length >= 2) {
            startDate.setHours(Integer.parseInt(timeStrs[0]));
            startDate.setMinutes(Integer.parseInt(timeStrs[1]));
            if (timeStrs.length == 3) {
                startDate.setSeconds(Integer.parseInt(timeStrs[2]));
            } else {
                startDate.setSeconds(0);
            }
        }
        return startDate;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String cnTimeTransform(java.lang.String r4) {
        /*
            java.lang.String r0 = "点"
            boolean r1 = r4.contains(r0)
            java.lang.String r2 = ":"
            if (r1 == 0) goto Le
            java.lang.String r4 = r4.replace(r0, r2)
        Le:
            java.lang.String r0 = "點"
            boolean r1 = r4.contains(r0)
            if (r1 == 0) goto L1a
            java.lang.String r4 = r4.replace(r0, r2)
        L1a:
            java.lang.String r0 = "分"
            boolean r1 = r4.contains(r0)
            if (r1 == 0) goto L26
            java.lang.String r4 = r4.replace(r0, r2)
        L26:
            java.lang.String r0 = "秒"
            boolean r1 = r4.contains(r0)
            if (r1 == 0) goto L34
            java.lang.String r1 = ""
            java.lang.String r4 = r4.replace(r0, r1)
        L34:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
        L3a:
            int r2 = r4.length()
            if (r1 >= r2) goto L87
            char r2 = r4.charAt(r1)
            r3 = 21313(0x5341, float:2.9866E-41)
            if (r2 != r3) goto L73
            if (r1 <= 0) goto L71
            int r3 = r1 + (-1)
            char r3 = r4.charAt(r3)
            boolean r3 = isCNDigit(r3)
            if (r3 == 0) goto L71
            int r3 = r4.length()
            int r3 = r3 + (-1)
            if (r1 >= r3) goto L6e
            int r3 = r1 + 1
            char r3 = r4.charAt(r3)
            boolean r3 = isCNDigit(r3)
            if (r3 == 0) goto L6b
            goto L84
        L6b:
            r2 = 48
            goto L73
        L6e:
            r2 = 48
            goto L73
        L71:
            r2 = 49
        L73:
            boolean r3 = isCNDigit(r2)
            if (r3 == 0) goto L81
            int r3 = changeNum(r2)
            r0.append(r3)
            goto L84
        L81:
            r0.append(r2)
        L84:
            int r1 = r1 + 1
            goto L3a
        L87:
            java.lang.String r1 = r0.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.util.StepOSDateTimeUrlHelper.cnTimeTransform(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Date[] createDateByTianWu(String matchingRegion) {
        String day = null;
        String wu = null;
        Date startDate = new Date();
        Date endDate = new Date();
        boolean hasDa = false;
        int N = matchingRegion.length();
        if (N == 5) {
            hasDa = true;
            day = matchingRegion.substring(1, 2);
            wu = matchingRegion.substring(3, 4);
        } else if (N == 4) {
            day = matchingRegion.substring(0, 1);
            wu = matchingRegion.substring(2, 3);
        }
        if (match(Pattern.compile(SHANG_UNICODE), wu) || match(Pattern.compile(ZAO_UNICODE), wu)) {
            startDate.setHours(8);
            startDate.setMinutes(0);
            endDate.setHours(9);
            endDate.setMinutes(0);
        } else if (match(Pattern.compile(ZHONG_UNICODE), wu)) {
            startDate.setHours(12);
            startDate.setMinutes(0);
            endDate.setHours(13);
            endDate.setMinutes(0);
        } else if (match(Pattern.compile(XIA_UNICODE), wu)) {
            startDate.setHours(15);
            startDate.setMinutes(0);
            endDate.setHours(16);
            endDate.setMinutes(0);
        } else if (match(Pattern.compile(WAN_UNICODE), wu)) {
            startDate.setHours(20);
            startDate.setMinutes(0);
            endDate.setHours(21);
            endDate.setMinutes(0);
        }
        if (hasDa) {
            startDate.setDate(startDate.getDate() + 3);
            endDate.setDate(endDate.getDate() + 3);
        } else if (!match(Pattern.compile(JIN_UNICODE), day)) {
            if (match(Pattern.compile(MING_UNICODE), day)) {
                startDate.setDate(startDate.getDate() + 1);
                endDate.setDate(endDate.getDate() + 1);
            } else if (match(Pattern.compile(HOU_UNICODE), day) || match(Pattern.compile(HOU_UNICODE_TW), day)) {
                startDate.setDate(startDate.getDate() + 2);
                endDate.setDate(endDate.getDate() + 2);
            }
        }
        Date[] value = {startDate, endDate};
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Date[] createDateByDayWu(String matchingRegion) {
        String day = null;
        String wu = null;
        Date startDate = new Date();
        Date endDate = new Date();
        int N = matchingRegion.length();
        if (N == 5) {
            day = matchingRegion.substring(2, 3);
            wu = matchingRegion.substring(3, 4);
        } else if (N == 4) {
            day = matchingRegion.substring(1, 2);
            wu = matchingRegion.substring(2, 3);
        }
        if (match(Pattern.compile(SHANG_UNICODE), wu) || match(Pattern.compile(ZAO_UNICODE), wu)) {
            startDate.setHours(8);
            startDate.setMinutes(0);
            endDate.setHours(9);
            endDate.setMinutes(0);
        } else if (match(Pattern.compile(ZHONG_UNICODE), wu)) {
            startDate.setHours(12);
            startDate.setMinutes(0);
            endDate.setHours(13);
            endDate.setMinutes(0);
        } else if (match(Pattern.compile(XIA_UNICODE), wu)) {
            startDate.setHours(15);
            startDate.setMinutes(0);
            endDate.setHours(16);
            endDate.setMinutes(0);
        } else if (match(Pattern.compile(WAN_UNICODE), wu)) {
            startDate.setHours(20);
            startDate.setMinutes(0);
            endDate.setHours(21);
            endDate.setMinutes(0);
        }
        int today = getWeekOfDate(startDate);
        int tagerDay = getTagerDay(day.charAt(0));
        if (today != tagerDay) {
            if (today < tagerDay) {
                startDate.setDate(startDate.getDate() + (tagerDay - today));
                endDate.setDate(endDate.getDate() + (tagerDay - today));
            } else {
                startDate.setDate(startDate.getDate() + (7 - today) + tagerDay);
                endDate.setDate(endDate.getDate() + (7 - today) + tagerDay);
            }
        }
        Date[] value = {startDate, endDate};
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Date createDateByNextDayOfWeek(String matchingRegion) {
        Date startDate = new Date();
        String day = matchingRegion.substring(matchingRegion.length() - 1);
        int today = getWeekOfDate(startDate);
        int tagerDay = getTagerDay(day.charAt(0));
        if (today < tagerDay) {
            startDate.setDate(startDate.getDate() + (tagerDay - today) + 7);
        } else if (today > tagerDay) {
            startDate.setDate(startDate.getDate() + (7 - today) + tagerDay);
        } else {
            startDate.setDate(startDate.getDate() + 7);
        }
        return startDate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Date createDateByEN_M_D_Y(String matchingRegion) throws ParseException {
        String mon = matchingRegion.substring(0, matchingRegion.toString().indexOf(" "));
        String day = matchingRegion.substring(matchingRegion.toString().indexOf(" ") + 1, Math.max(matchingRegion.toString().indexOf("，"), matchingRegion.toString().indexOf(COMMA_STRING)));
        String year = matchingRegion.substring(Math.max(matchingRegion.toString().indexOf("，"), matchingRegion.toString().indexOf(COMMA_STRING)) + 1, matchingRegion.length()).trim();
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_Y_M_D);
        String temp = year + BACKSLASH_STRING + getMonByEn(mon) + BACKSLASH_STRING + day;
        if (!validateDate(temp)) {
            return null;
        }
        return sdf.parse(temp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Date createDateByCN_Wu_Dian(String matchingRegion) throws NumberFormatException {
        int timeEnd;
        String wu = matchingRegion.substring(0, 2);
        int minutes = 0;
        int banIndex = matchingRegion.indexOf(BAN_UNICODE);
        int keIndex = matchingRegion.indexOf(KE_UNICODE);
        if (banIndex != -1) {
            minutes = 30;
            timeEnd = banIndex - 1;
        } else if (keIndex != -1) {
            int keNum = getTimeStringToTimeNum(matchingRegion.substring(keIndex - 1, keIndex));
            minutes = keNum * 15;
            timeEnd = keIndex - 2;
        } else {
            timeEnd = matchingRegion.length() - 1;
        }
        String timeString = matchingRegion.substring(2, timeEnd);
        int timeNum = getTimeStringToTimeNum(timeString);
        Date startDate = new Date();
        if (wu.contains(XIA_UNICODE) || wu.contains(WAN_UNICODE) || wu.contains(BANG_UNICODE)) {
            if (timeNum < 12) {
                timeNum += 12;
            }
        } else if (match(Pattern.compile(ZHONG_UNICODE), wu) && timeNum < 11) {
            timeNum += 12;
        }
        startDate.setHours(timeNum);
        startDate.setMinutes(minutes);
        startDate.setSeconds(0);
        return startDate;
    }

    private static int getTimeStringToTimeNum(String timeString) throws NumberFormatException {
        if (timeString == null) {
            return -1;
        }
        if (timeString.length() == 1) {
            if (isNumber(timeString)) {
                int num = Integer.parseInt(timeString);
                return num;
            }
            int num2 = changeNum(timeString.charAt(0));
            return num2;
        }
        if (isNumber(timeString)) {
            int num3 = Integer.parseInt(timeString);
            return num3;
        }
        int num4 = changeNum(timeString.charAt(1)) + 10;
        return num4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Date createDateByEN_M_D(String matchingRegion) throws ParseException {
        String mon = matchingRegion.substring(0, matchingRegion.toString().indexOf(" ")).trim();
        String day = matchingRegion.substring(matchingRegion.toString().indexOf(" ") + 1, matchingRegion.length()).trim();
        Date now = new Date();
        StringBuffer year = new StringBuffer((now.getYear() + NUM_1900) + BACKSLASH_STRING);
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_Y_M_D);
        String temp = year.toString() + getMonByEn(mon) + BACKSLASH_STRING + day;
        if (!validateDate(temp)) {
            return null;
        }
        return sdf.parse(temp);
    }

    private static int getMonByEn(String monEn) {
        for (int i = 0; i < MONTH_STRINGS.length; i++) {
            if (monEn.toLowerCase().startsWith(MONTH_STRINGS[i])) {
                int monNum = i + 1;
                return monNum;
            }
        }
        return 1;
    }

    private static int getTagerDay(char day) {
        switch (day) {
            case 19968:
                return 2;
            case 19977:
                return 4;
            case 20108:
                return 3;
            case 20116:
                return 6;
            case 20845:
                return 7;
            case 22235:
                return 5;
            case 22777:
                return 2;
            case 22825:
                return 1;
            case 26085:
                return 1;
            default:
                return 0;
        }
    }

    public static int getWeekOfDate(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(7);
        if (w < 0) {
            return 0;
        }
        return w;
    }
}
