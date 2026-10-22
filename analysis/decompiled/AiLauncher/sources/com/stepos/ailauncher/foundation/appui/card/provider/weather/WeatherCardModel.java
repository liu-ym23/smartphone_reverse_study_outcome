package com.stepos.ailauncher.foundation.appui.card.provider.weather;

import N5.n;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0080\b\u0018\u0000 02\u00020\u0001:\u0003\"* B£\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\f\u001a\u00020\u0004\u0012\b\b\u0003\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0019R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b#\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b$\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b%\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b&\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b'\u0010\u0017R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b(\u0010\u0017R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b)\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b*\u0010\u0019R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b+\u0010\u0017R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010.R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b/\u0010.¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/a;", "LN5/n;", "", "cardId", "", WeatherCardProvider.KEY_CARD_TYPE, "locationText", "dayLabel", "tempText", "tempRangeText", "conditionText", "metaText", "iconRes", "backgroundRes", "lifeIndexTip", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/a$c;", "hourlyItems", "Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/a$b;", "dailyItems", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "I", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "f", "m", "l", Const.INTENT_KEY_UMID, "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "e", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.weather.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class WeatherCardModel extends n {
    public static final int CARD_TYPE_HOURLY = 3;
    public static final int CARD_TYPE_MULTI_DAY = 2;
    public static final int CARD_TYPE_SINGLE_DAY = 1;
    private final int backgroundRes;
    private final String cardId;
    private final int cardType;
    private final String conditionText;
    private final List<DailyItem> dailyItems;
    private final String dayLabel;
    private final List<HourlyItem> hourlyItems;
    private final int iconRes;
    private final String lifeIndexTip;
    private final String locationText;
    private final String metaText;
    private final String tempRangeText;
    private final String tempText;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001a\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001b\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/a$b;", "", "", "weekLabel", "dateLabel", "", "iconRes", "popText", "conditionText", "tempRangeText", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", Const.INTENT_KEY_PKGNAME, "I", "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "e", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.weather.a$b, reason: from toString */
    public static final /* data */ class DailyItem {
        private final String conditionText;
        private final String dateLabel;
        private final int iconRes;
        private final String popText;
        private final String tempRangeText;
        private final String weekLabel;

        public DailyItem() {
            this(null, null, 0, null, null, null, 63, null);
        }

        /* renamed from: a, reason: from getter */
        public final String getConditionText() {
            return this.conditionText;
        }

        /* renamed from: b, reason: from getter */
        public final String getDateLabel() {
            return this.dateLabel;
        }

        /* renamed from: c, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        /* renamed from: d, reason: from getter */
        public final String getPopText() {
            return this.popText;
        }

        /* renamed from: e, reason: from getter */
        public final String getTempRangeText() {
            return this.tempRangeText;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DailyItem)) {
                return false;
            }
            DailyItem dailyItem = (DailyItem) other;
            return p.d(this.weekLabel, dailyItem.weekLabel) && p.d(this.dateLabel, dailyItem.dateLabel) && this.iconRes == dailyItem.iconRes && p.d(this.popText, dailyItem.popText) && p.d(this.conditionText, dailyItem.conditionText) && p.d(this.tempRangeText, dailyItem.tempRangeText);
        }

        /* renamed from: f, reason: from getter */
        public final String getWeekLabel() {
            return this.weekLabel;
        }

        public int hashCode() {
            String str = this.weekLabel;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.dateLabel;
            int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.iconRes)) * 31;
            String str3 = this.popText;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.conditionText;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.tempRangeText;
            return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "DailyItem(weekLabel=" + this.weekLabel + ", dateLabel=" + this.dateLabel + ", iconRes=" + this.iconRes + ", popText=" + this.popText + ", conditionText=" + this.conditionText + ", tempRangeText=" + this.tempRangeText + ")";
        }

        public DailyItem(String str, String str2, int i10, String str3, String str4, String str5) {
            this.weekLabel = str;
            this.dateLabel = str2;
            this.iconRes = i10;
            this.popText = str3;
            this.conditionText = str4;
            this.tempRangeText = str5;
        }

        public /* synthetic */ DailyItem(String str, String str2, int i10, String str3, String str4, String str5, int i11, i iVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/a$c;", "", "", "timeLabel", "", "iconRes", "popText", "tempText", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "I", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.weather.a$c, reason: from toString */
    public static final /* data */ class HourlyItem {
        private final int iconRes;
        private final String popText;
        private final String tempText;
        private final String timeLabel;

        public HourlyItem() {
            this(null, 0, null, null, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        /* renamed from: b, reason: from getter */
        public final String getPopText() {
            return this.popText;
        }

        /* renamed from: c, reason: from getter */
        public final String getTempText() {
            return this.tempText;
        }

        /* renamed from: d, reason: from getter */
        public final String getTimeLabel() {
            return this.timeLabel;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HourlyItem)) {
                return false;
            }
            HourlyItem hourlyItem = (HourlyItem) other;
            return p.d(this.timeLabel, hourlyItem.timeLabel) && this.iconRes == hourlyItem.iconRes && p.d(this.popText, hourlyItem.popText) && p.d(this.tempText, hourlyItem.tempText);
        }

        public int hashCode() {
            String str = this.timeLabel;
            int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.iconRes)) * 31;
            String str2 = this.popText;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.tempText;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "HourlyItem(timeLabel=" + this.timeLabel + ", iconRes=" + this.iconRes + ", popText=" + this.popText + ", tempText=" + this.tempText + ")";
        }

        public HourlyItem(String str, int i10, String str2, String str3) {
            this.timeLabel = str;
            this.iconRes = i10;
            this.popText = str2;
            this.tempText = str3;
        }

        public /* synthetic */ HourlyItem(String str, int i10, String str2, String str3, int i11, i iVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3);
        }
    }

    public WeatherCardModel() {
        this(null, 0, null, null, null, null, null, null, 0, 0, null, null, null, 8191, null);
    }

    @Override // N5.n
    /* renamed from: a, reason: from getter */
    public String getCardId() {
        return this.cardId;
    }

    /* renamed from: b, reason: from getter */
    public final int getBackgroundRes() {
        return this.backgroundRes;
    }

    /* renamed from: c, reason: from getter */
    public final int getCardType() {
        return this.cardType;
    }

    /* renamed from: d, reason: from getter */
    public final String getConditionText() {
        return this.conditionText;
    }

    public final List<DailyItem> e() {
        return this.dailyItems;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeatherCardModel)) {
            return false;
        }
        WeatherCardModel weatherCardModel = (WeatherCardModel) other;
        return p.d(this.cardId, weatherCardModel.cardId) && this.cardType == weatherCardModel.cardType && p.d(this.locationText, weatherCardModel.locationText) && p.d(this.dayLabel, weatherCardModel.dayLabel) && p.d(this.tempText, weatherCardModel.tempText) && p.d(this.tempRangeText, weatherCardModel.tempRangeText) && p.d(this.conditionText, weatherCardModel.conditionText) && p.d(this.metaText, weatherCardModel.metaText) && this.iconRes == weatherCardModel.iconRes && this.backgroundRes == weatherCardModel.backgroundRes && p.d(this.lifeIndexTip, weatherCardModel.lifeIndexTip) && p.d(this.hourlyItems, weatherCardModel.hourlyItems) && p.d(this.dailyItems, weatherCardModel.dailyItems);
    }

    /* renamed from: f, reason: from getter */
    public final String getDayLabel() {
        return this.dayLabel;
    }

    public final List<HourlyItem> g() {
        return this.hourlyItems;
    }

    /* renamed from: h, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    public int hashCode() {
        int iHashCode = ((this.cardId.hashCode() * 31) + Integer.hashCode(this.cardType)) * 31;
        String str = this.locationText;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.dayLabel;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tempText;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.tempRangeText;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.conditionText;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.metaText;
        int iHashCode7 = (((((iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + Integer.hashCode(this.iconRes)) * 31) + Integer.hashCode(this.backgroundRes)) * 31;
        String str7 = this.lifeIndexTip;
        return ((((iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.hourlyItems.hashCode()) * 31) + this.dailyItems.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final String getLifeIndexTip() {
        return this.lifeIndexTip;
    }

    /* renamed from: j, reason: from getter */
    public final String getLocationText() {
        return this.locationText;
    }

    /* renamed from: k, reason: from getter */
    public final String getMetaText() {
        return this.metaText;
    }

    /* renamed from: l, reason: from getter */
    public final String getTempRangeText() {
        return this.tempRangeText;
    }

    /* renamed from: m, reason: from getter */
    public final String getTempText() {
        return this.tempText;
    }

    public String toString() {
        return "WeatherCardModel(cardId=" + this.cardId + ", cardType=" + this.cardType + ", locationText=" + this.locationText + ", dayLabel=" + this.dayLabel + ", tempText=" + this.tempText + ", tempRangeText=" + this.tempRangeText + ", conditionText=" + this.conditionText + ", metaText=" + this.metaText + ", iconRes=" + this.iconRes + ", backgroundRes=" + this.backgroundRes + ", lifeIndexTip=" + this.lifeIndexTip + ", hourlyItems=" + this.hourlyItems + ", dailyItems=" + this.dailyItems + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherCardModel(String cardId, int i10, String str, String str2, String str3, String str4, String str5, String str6, int i11, int i12, String str7, List<HourlyItem> hourlyItems, List<DailyItem> dailyItems) {
        super(cardId);
        p.i(cardId, "cardId");
        p.i(hourlyItems, "hourlyItems");
        p.i(dailyItems, "dailyItems");
        this.cardId = cardId;
        this.cardType = i10;
        this.locationText = str;
        this.dayLabel = str2;
        this.tempText = str3;
        this.tempRangeText = str4;
        this.conditionText = str5;
        this.metaText = str6;
        this.iconRes = i11;
        this.backgroundRes = i12;
        this.lifeIndexTip = str7;
        this.hourlyItems = hourlyItems;
        this.dailyItems = dailyItems;
    }

    public /* synthetic */ WeatherCardModel(String str, int i10, String str2, String str3, String str4, String str5, String str6, String str7, int i11, int i12, String str8, List list, List list2, int i13, i iVar) {
        this((i13 & 1) != 0 ? "" : str, (i13 & 2) != 0 ? 1 : i10, (i13 & 4) != 0 ? null : str2, (i13 & 8) != 0 ? null : str3, (i13 & 16) != 0 ? null : str4, (i13 & 32) != 0 ? null : str5, (i13 & 64) != 0 ? null : str6, (i13 & 128) != 0 ? null : str7, (i13 & 256) != 0 ? 0 : i11, (i13 & 512) == 0 ? i12 : 0, (i13 & 1024) == 0 ? str8 : null, (i13 & 2048) != 0 ? C1173v.m() : list, (i13 & 4096) != 0 ? C1173v.m() : list2);
    }
}
