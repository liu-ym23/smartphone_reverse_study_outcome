package com.android.contacts.datepicker;

import com.android.contacts.lunar.LunarCalendar;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatePickerUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lcom/android/contacts/datepicker/DatePickerUtils;", "", "()V", "seemsUnsetYear", "", "year", "", "type", "Lcom/android/contacts/datepicker/DatePickerUtils$DatePickerType;", "DatePickerType", "OnDateSetListener", "OnLunarDateSetListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatePickerUtils {
    public static final DatePickerUtils INSTANCE = null;

    /* JADX INFO: compiled from: DatePickerUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/contacts/datepicker/DatePickerUtils$DatePickerType;", "", "(Ljava/lang/String;I)V", "EVENT", "BIRTHDAY", "BIRTHDAY_LUNAR", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum DatePickerType extends Enum<DatePickerType> {
        private static final /* synthetic */ DatePickerType[] $VALUES = null;
        public static final DatePickerType BIRTHDAY = null;
        public static final DatePickerType BIRTHDAY_LUNAR = null;
        public static final DatePickerType EVENT = null;

        private static final /* synthetic */ DatePickerType[] $values() {
            return new DatePickerType[]{EVENT, BIRTHDAY, BIRTHDAY_LUNAR};
        }

        public static DatePickerType valueOf(String r1) {
            return (DatePickerType) Enum.valueOf(DatePickerType.class, r1);
        }

        public static DatePickerType[] values() {
            return (DatePickerType[]) $VALUES.clone();
        }

        private DatePickerType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            EVENT = new DatePickerType("EVENT", 0);
            BIRTHDAY = new DatePickerType("BIRTHDAY", 1);
            BIRTHDAY_LUNAR = new DatePickerType("BIRTHDAY_LUNAR", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: DatePickerUtils.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/android/contacts/datepicker/DatePickerUtils$OnDateSetListener;", "", "onDateSet", "", "year", "", "monthOfYear", "dayOfMonth", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnDateSetListener {
        void onDateSet(int r1, int r2, int r3);
    }

    /* JADX INFO: compiled from: DatePickerUtils.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/contacts/datepicker/DatePickerUtils$OnLunarDateSetListener;", "", "onDateSet", "", "lc", "Lcom/android/contacts/lunar/LunarCalendar;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnLunarDateSetListener {
        void onDateSet(LunarCalendar r1);
    }

    static {
        INSTANCE = new DatePickerUtils();
    }

    private DatePickerUtils() {
    }

    @JvmStatic
    public static final boolean seemsUnsetYear(int r3, DatePickerType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        if (r4 == DatePickerType.BIRTHDAY) goto L5;
        return false;
    L5:
        if (r3 >= 1800) goto L7;
        return true;
    L7:
        Calendar r5 = Calendar.getInstance(Locale.getDefault());
        r5.clear();
        r5.setTimeInMillis(System.currentTimeMillis());
        if (r3 <= r5.get(1)) goto L12;
        return true;
    L12:
        return false;
    }
}
