package com.stepos.alphame.awareness;

import android.text.TextUtils;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.suggest.AppSuggestStorable;
import io.reactivex.annotations.SchedulerSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AwarenessDataItem extends DataItem {
    public static final String PERMISSION_SPLITTER = " ";
    public static final String USERID_SPLITTER = ":";
    private String data1;
    private String data2;
    private long date;
    private int id;
    private int scene;
    private int state;

    @NotProguard
    public void fill(int i4, int i5, int i6, String str, String str2, long j4) {
        this.id = i4;
        this.scene = i5;
        this.state = i6;
        this.data1 = str;
        this.data2 = str2;
        this.date = j4;
    }

    public String getData1() {
        return this.data1;
    }

    public String getData2() {
        return this.data2;
    }

    public long getDate() {
        return this.date;
    }

    public int getId() {
        return this.id;
    }

    public String getPkgNameWithUserId() {
        if (getScene() != 3) {
            return null;
        }
        String data1 = getData1();
        if (TextUtils.isEmpty(getData2()) || !getData2().contains(PERMISSION_SPLITTER)) {
            return data1;
        }
        int state = getState();
        if (state > 10000 || state == 1000) {
            state /= ComplexPt.TEN_THOUSAND;
        }
        if (state <= 0) {
            return data1;
        }
        return data1 + USERID_SPLITTER + state;
    }

    public int getScene() {
        return this.scene;
    }

    public int getState() {
        return this.state;
    }

    public void setData1(String str) {
        this.data1 = str;
    }

    public void setData2(String str) {
        this.data2 = str;
    }

    public void setDate(long j4) {
        this.date = j4;
    }

    public void setScene(int i4) {
        this.scene = i4;
    }

    public void setState(int i4) {
        this.state = i4;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0019. Please report as an issue. */
    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        str = "DISCONNECTED";
        String str7 = "pkgName";
        String strValueOf = "";
        String str8 = "data2";
        switch (this.scene) {
            case 0:
                int i4 = this.state;
                str2 = i4 == 1 ? "STILL" : i4 == 2 ? "SLOWLY_WALK" : i4 == 3 ? "WALK" : i4 == 4 ? "RUN" : "UNKNOWN";
                str3 = "MovingState";
                str7 = "data1";
                break;
            case 1:
                int i5 = this.state;
                if (i5 == 1) {
                    str = "CONNECTED";
                } else if (i5 != 0) {
                    str = i5 == 2 ? "CHANGED" : "OFF";
                }
                str4 = "WifiState";
                str7 = "ssid";
                str8 = "bssid";
                str2 = str;
                str3 = str4;
                break;
            case 2:
                int i6 = this.state;
                str4 = "Location";
                str7 = "coord";
                str8 = "address";
                str5 = i6 == 1 ? "bl-connected" : i6 == 2 ? "bl-disconnected" : i6 == 3 ? "wifi-changed" : i6 == 4 ? "wifi-connected" : i6 == 5 ? "wifi-disconnected" : i6 == 7 ? "moved" : i6 == 6 ? "wakeup" : i6 == 8 ? "retry" : i6 == 9 ? "third-app" : i6 == 10 ? "FROM_COUNTRY_SETTING_CHANGED" : i6 == 11 ? "FROM_PASSIVE_PROVIDER" : i6 == 12 ? "FROM_SUGGEST_DATA" : "unknown";
                str2 = str5;
                str3 = str4;
                break;
            case 3:
                strValueOf = String.valueOf(this.state);
                str3 = "App";
                str2 = strValueOf;
                break;
            case 4:
                str = this.state == 1 ? "CONNECTED" : "DISCONNECTED";
                str4 = "Bluetooth";
                str7 = "name";
                str2 = str;
                str3 = str4;
                break;
            case 5:
                int i7 = this.state;
                str6 = "System";
                if (i7 == 0) {
                    strValueOf = "boot";
                } else if (i7 == 1) {
                    strValueOf = "log";
                } else if (i7 == 2) {
                    strValueOf = "daily";
                } else if (i7 == 3) {
                    strValueOf = "step";
                } else if (i7 == 4) {
                    strValueOf = AppSuggestStorable.COLUMN_WIFI;
                }
                str3 = str6;
                str2 = strValueOf;
                str7 = "data1";
                break;
            case 6:
                int i8 = this.state;
                str6 = "Charging";
                if (i8 == 0) {
                    strValueOf = SchedulerSupport.NONE;
                } else if (i8 == 1) {
                    strValueOf = "ac";
                } else if (i8 == 2) {
                    strValueOf = "usb";
                } else if (i8 == 4) {
                    strValueOf = "wireless";
                }
                str3 = str6;
                str2 = strValueOf;
                str7 = "data1";
                break;
            case 7:
                int i9 = this.state;
                str6 = "Headset";
                if (i9 == 1) {
                    strValueOf = "plugin";
                } else if (i9 == 0) {
                    strValueOf = "plugout";
                }
                str3 = str6;
                str2 = strValueOf;
                str7 = "data1";
                break;
            case 8:
                str4 = "Notifications";
                str5 = "null";
                str2 = str5;
                str3 = str4;
                break;
            case 9:
                int i10 = this.state;
                if (i10 == 1) {
                    strValueOf = "permitted";
                } else if (i10 == 0) {
                    strValueOf = "denied";
                } else if (i10 == 2) {
                    strValueOf = "public";
                }
                str3 = "PermissionCheck";
                str2 = strValueOf;
                break;
            default:
                str3 = "";
                str2 = str3;
                str7 = "data1";
                break;
        }
        return String.format("[id=%s scene=%s state=%s " + str7 + "=%s " + str8 + "=%s date=%s]", Integer.valueOf(this.id), str3, str2, this.data1, this.data2, simpleDateFormat.format(new Date(this.date)));
    }

    public void fill(int i4, int i5, String str, String str2, long j4) {
        this.scene = i4;
        this.state = i5;
        this.data1 = str;
        this.data2 = str2;
        this.date = j4;
    }

    public void fill(int i4, int i5, long j4) {
        this.scene = i4;
        this.state = i5;
        this.date = j4;
    }
}
