package com.stepos.minor;

import T1.d;
import T1.e;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class Minor {
    public static final int BIRTH_TYPE_AGE = 1;
    public static final int BIRTH_TYPE_AGE_MAX = 17;
    public static final int BIRTH_TYPE_AGE_MIN = 1;
    public static final int BIRTH_TYPE_DATE = 0;
    public static final int BIRTH_TYPE_RANGE = 2;
    public static final String COLUMN_AGE_RANGE = "age_range";
    public static final String COLUMN_BIRTHDAY_AGE = "birthdayAge";
    public static final String COLUMN_BIRTHDAY_DATE = "birthdayDate";
    public static final String COLUMN_BIRTHDAY_DATE_LUNAR = "birthdayDateLunar";
    public static final String COLUMN_BIRTHDAY_RANGE = "birthdayRange";
    public static final String COLUMN_BIRTHDAY_TYPE = "birthType";
    public static final String COLUMN_ICON = "icon";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_STATE = "state";
    public static final int DEFAULT_AGE = 16;
    public static final int DEFAULT_RANGE = 4;
    public static final int ID_NONE = -1;
    public static final int STATE_ACTIVATED = 2;
    public static final int STATE_NONE = 0;
    public static final int STATE_SELECTED = 1;
    public static final String TABLE_NAME = "minor";
    private int ageRange;
    private int birthType;
    private int birthdayAge;
    private long birthdayDate;
    private int birthdayDateLunar;
    private int birthdayRange;
    private byte[] icon;
    private long id;
    private String name;
    private int state;
    private static final String[] LUNAR_MONTHS = {"正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "冬月", "腊月"};
    private static final String[] LUNAR_DAYS = {"初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十"};

    public Minor() {
        this.birthdayAge = 16;
        this.birthdayRange = 4;
        this.state = 0;
        this.ageRange = 4;
    }

    private static int ageToAgeRange(int i5) {
        if (i5 < 3) {
            return 1;
        }
        if (i5 < 8) {
            return 2;
        }
        if (i5 < 12) {
            return 3;
        }
        if (i5 < 16) {
            return 4;
        }
        return i5 < 18 ? 5 : 0;
    }

    public String getAgeDesc(Context context) throws Resources.NotFoundException {
        int i5 = this.birthType;
        if (i5 == 1) {
            return this.birthdayAge + context.getString(R.string.mm_age_suffix);
        }
        if (i5 != 2) {
            return d.b(this.birthdayDate, isBirthdayDateLunar()) + context.getString(R.string.mm_age_suffix);
        }
        String[] stringArray = context.getResources().getStringArray(R.array.birth_ranges);
        int iMin = this.birthdayRange - 1;
        if (iMin < 0 || iMin >= stringArray.length) {
            iMin = Math.min(Math.max(3, 0), stringArray.length - 1);
        }
        return stringArray[iMin] + context.getString(R.string.mm_age_suffix);
    }

    public int getAgeRange() {
        return this.ageRange;
    }

    public String getBirthDateDesc(Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.birthdayDate);
        int i5 = calendar.get(1);
        int i6 = calendar.get(2);
        int i7 = calendar.get(5);
        if (this.birthType != 0 || this.birthdayDate <= 0) {
            return BuildConfig.FLAVOR;
        }
        if (!isBirthdayDateLunar()) {
            return String.format(context.getString(R.string.mm_birth_date_format), Integer.valueOf(i5), Integer.valueOf(i6 + 1), Integer.valueOf(i7));
        }
        if (!e.a()) {
            return String.format(context.getString(R.string.mm_birth_date_format_lunar), Integer.valueOf(i5), Integer.valueOf(i6 + 1), Integer.valueOf(i7));
        }
        int[] iArrF = N1.e.f(i5, i6 + 1, i7);
        return iArrF[0] + "年" + LUNAR_MONTHS[iArrF[1] - 1] + LUNAR_DAYS[iArrF[2] - 1];
    }

    public int getBirthType() {
        return this.birthType;
    }

    public int getBirthdayAge() {
        return this.birthdayAge;
    }

    public long getBirthdayDate() {
        return this.birthdayDate;
    }

    public int getBirthdayDateLunar() {
        return this.birthdayDateLunar;
    }

    public int getBirthdayRange() {
        return this.birthdayRange;
    }

    public byte[] getIcon() {
        return this.icon;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getState() {
        return this.state;
    }

    public boolean isActivated() {
        return this.state == 2;
    }

    public boolean isBirthdayDateLunar() {
        return this.birthdayDateLunar == 1;
    }

    public boolean isSelected() {
        return this.state == 1;
    }

    public void setAgeRange(int i5) {
        this.ageRange = i5;
    }

    public void setBirthType(int i5) {
        this.birthType = i5;
        if (i5 == 0) {
            this.ageRange = ageToAgeRange(d.b(this.birthdayDate, isBirthdayDateLunar()));
        } else if (i5 == 1) {
            this.ageRange = ageToAgeRange(this.birthdayAge);
        } else if (i5 == 2) {
            this.ageRange = this.birthdayRange;
        }
    }

    public void setBirthdayAge(int i5) {
        this.birthdayAge = i5;
        this.ageRange = ageToAgeRange(i5);
    }

    public void setBirthdayDate(long j5) {
        this.birthdayDate = j5;
        this.ageRange = ageToAgeRange(d.b(j5, isBirthdayDateLunar()));
    }

    public void setBirthdayDateLunar(int i5) {
        this.birthdayDateLunar = i5;
        this.ageRange = ageToAgeRange(d.b(this.birthdayDate, isBirthdayDateLunar()));
    }

    public void setBirthdayRange(int i5) {
        this.birthdayRange = i5;
        this.ageRange = i5;
    }

    public void setIcon(byte[] bArr) {
        this.icon = bArr;
    }

    public boolean setIconFromUri(Context context, Uri uri) throws IOException {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
            while (true) {
                int i5 = inputStreamOpenInputStream.read(bArr);
                if (i5 == -1) {
                    this.icon = byteArrayOutputStream.toByteArray();
                    inputStreamOpenInputStream.close();
                    byteArrayOutputStream.close();
                    return true;
                }
                byteArrayOutputStream.write(bArr, 0, i5);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public void setId(long j5) {
        this.id = j5;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setState(int i5) {
        this.state = i5;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, getName());
        contentValues.put(COLUMN_ICON, getIcon());
        contentValues.put(COLUMN_BIRTHDAY_TYPE, Integer.valueOf(getBirthType()));
        contentValues.put(COLUMN_BIRTHDAY_DATE, Long.valueOf(getBirthdayDate()));
        contentValues.put(COLUMN_BIRTHDAY_DATE_LUNAR, Integer.valueOf(getBirthdayDateLunar()));
        contentValues.put(COLUMN_BIRTHDAY_AGE, Integer.valueOf(getBirthdayAge()));
        contentValues.put(COLUMN_BIRTHDAY_RANGE, Integer.valueOf(getBirthdayRange()));
        contentValues.put("state", Integer.valueOf(getState()));
        contentValues.put(COLUMN_AGE_RANGE, Integer.valueOf(getAgeRange()));
        return contentValues;
    }

    public String toString() {
        return "MinorRole{id=" + this.id + ", name='" + this.name + "', birthType=" + this.birthType + ", birthdayDate=" + this.birthdayDate + ", birthdayDateLunar=" + this.birthdayDateLunar + ", birthdayAge=" + this.birthdayAge + ", birthdayRange=" + this.birthdayRange + ", state=" + this.state + '}';
    }

    public Minor(long j5, String str, int i5, long j6, int i6, int i7, int i8, int i9) {
        this.state = 0;
        this.id = j5;
        this.name = str;
        this.birthType = i5;
        this.birthdayDate = j6;
        this.birthdayDateLunar = i6;
        this.birthdayAge = i7;
        this.birthdayRange = i8;
        this.ageRange = i9;
    }

    public Minor(ContentValues contentValues) {
        this.birthdayAge = 16;
        this.birthdayRange = 4;
        this.state = 0;
        this.ageRange = 4;
        this.name = contentValues.getAsString(COLUMN_NAME);
        this.icon = contentValues.getAsByteArray(COLUMN_ICON);
        this.birthType = contentValues.getAsInteger(COLUMN_BIRTHDAY_TYPE).intValue();
        this.birthdayDate = contentValues.getAsLong(COLUMN_BIRTHDAY_DATE).longValue();
        this.birthdayDateLunar = contentValues.getAsInteger(COLUMN_BIRTHDAY_DATE_LUNAR).intValue();
        this.birthdayAge = contentValues.getAsInteger(COLUMN_BIRTHDAY_AGE).intValue();
        this.birthdayRange = contentValues.getAsInteger(COLUMN_BIRTHDAY_RANGE).intValue();
        this.state = contentValues.getAsInteger("state").intValue();
        this.ageRange = contentValues.getAsInteger(COLUMN_AGE_RANGE).intValue();
    }
}
