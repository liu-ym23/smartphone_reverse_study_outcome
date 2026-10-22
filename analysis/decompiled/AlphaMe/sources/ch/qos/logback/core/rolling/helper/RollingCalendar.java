package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class RollingCalendar extends GregorianCalendar {
    static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");
    private static final long serialVersionUID = -5937537740925066161L;
    PeriodicityType periodicityType;

    /* renamed from: ch.qos.logback.core.rolling.helper.RollingCalendar$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType;

        static {
            int[] iArr = new int[PeriodicityType.values().length];
            $SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType = iArr;
            try {
                iArr[PeriodicityType.TOP_OF_MILLISECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType[PeriodicityType.TOP_OF_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType[PeriodicityType.TOP_OF_MINUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType[PeriodicityType.TOP_OF_HOUR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType[PeriodicityType.HALF_DAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType[PeriodicityType.TOP_OF_DAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType[PeriodicityType.TOP_OF_WEEK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType[PeriodicityType.TOP_OF_MONTH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public RollingCalendar() {
        this.periodicityType = PeriodicityType.ERRONEOUS;
    }

    public static int diffInMonths(long j4, long j5) {
        if (j4 > j5) {
            throw new IllegalArgumentException("startTime cannot be larger than endTime");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j5);
        return ((calendar2.get(1) - calendar.get(1)) * 12) + (calendar2.get(2) - calendar.get(2));
    }

    private void setPeriodicityType(PeriodicityType periodicityType) {
        this.periodicityType = periodicityType;
    }

    public PeriodicityType computePeriodicityType(String str) {
        RollingCalendar rollingCalendar = new RollingCalendar(GMT_TIMEZONE, Locale.getDefault());
        Date date = new Date(0L);
        if (str != null) {
            for (PeriodicityType periodicityType : PeriodicityType.VALID_ORDERED_LIST) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
                simpleDateFormat.setTimeZone(GMT_TIMEZONE);
                String str2 = simpleDateFormat.format(date);
                rollingCalendar.setPeriodicityType(periodicityType);
                String str3 = simpleDateFormat.format(new Date(rollingCalendar.getNextTriggeringMillis(date)));
                if (str2 != null && str3 != null && !str2.equals(str3)) {
                    return periodicityType;
                }
            }
        }
        return PeriodicityType.ERRONEOUS;
    }

    public Date getNextTriggeringDate(Date date) {
        return getRelativeDate(date, 1);
    }

    public long getNextTriggeringMillis(Date date) {
        return getNextTriggeringDate(date).getTime();
    }

    public PeriodicityType getPeriodicityType() {
        return this.periodicityType;
    }

    public Date getRelativeDate(Date date, int i4) {
        setTime(date);
        switch (AnonymousClass1.$SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType[this.periodicityType.ordinal()]) {
            case 1:
                add(14, i4);
                break;
            case 2:
                set(14, 0);
                add(13, i4);
                break;
            case 3:
                set(13, 0);
                set(14, 0);
                add(12, i4);
                break;
            case 4:
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(11, i4);
                break;
            case 5:
            default:
                throw new IllegalStateException("Unknown periodicity type.");
            case 6:
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(5, i4);
                break;
            case 7:
                set(7, getFirstDayOfWeek());
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(3, i4);
                break;
            case 8:
                set(5, 1);
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(2, i4);
                break;
        }
        return getTime();
    }

    public void init(String str) {
        this.periodicityType = computePeriodicityType(str);
    }

    public long periodsElapsed(long j4, long j5) {
        int iDiffInMonths;
        if (j4 > j5) {
            throw new IllegalArgumentException("Start cannot come before end");
        }
        long j6 = j5 - j4;
        switch (AnonymousClass1.$SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType[this.periodicityType.ordinal()]) {
            case 1:
                return j6;
            case 2:
                return j6 / 1000;
            case 3:
                return j6 / 60000;
            case 4:
                iDiffInMonths = ((int) j6) / CoreConstants.MILLIS_IN_ONE_HOUR;
                break;
            case 5:
            default:
                throw new IllegalStateException("Unknown periodicity type.");
            case 6:
                return j6 / 86400000;
            case 7:
                return j6 / 604800000;
            case 8:
                iDiffInMonths = diffInMonths(j4, j5);
                break;
        }
        return iDiffInMonths;
    }

    public void printPeriodicity(ContextAwareBase contextAwareBase) {
        switch (AnonymousClass1.$SwitchMap$ch$qos$logback$core$rolling$helper$PeriodicityType[this.periodicityType.ordinal()]) {
            case 1:
                contextAwareBase.addInfo("Roll-over every millisecond.");
                break;
            case 2:
                contextAwareBase.addInfo("Roll-over every second.");
                break;
            case 3:
                contextAwareBase.addInfo("Roll-over every minute.");
                break;
            case 4:
                contextAwareBase.addInfo("Roll-over at the top of every hour.");
                break;
            case 5:
                contextAwareBase.addInfo("Roll-over at midday and midnight.");
                break;
            case 6:
                contextAwareBase.addInfo("Roll-over at midnight.");
                break;
            case 7:
                contextAwareBase.addInfo("Rollover at the start of week.");
                break;
            case 8:
                contextAwareBase.addInfo("Rollover at start of every month.");
                break;
            default:
                contextAwareBase.addInfo("Unknown periodicity.");
                break;
        }
    }

    public RollingCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
        this.periodicityType = PeriodicityType.ERRONEOUS;
    }
}
