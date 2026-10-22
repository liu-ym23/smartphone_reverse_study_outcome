package com.stepos.ailauncher.foundation.appui.card.provider.weather;

import La.H;
import N5.d;
import N5.j;
import N5.k;
import N5.v;
import Q5.WeatherCity;
import Q5.WeatherDaily;
import Q5.WeatherHourly;
import Q5.WeatherLifeIndex;
import Q5.WeatherRealtime;
import Q5.WeatherRegion;
import Q5.f;
import Q5.h;
import Q5.l;
import Z8.A;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardModel;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001\u000fB\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010\u001a\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u001f\u0010 J%\u0010%\u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b%\u0010&J!\u0010)\u001a\u0004\u0018\u00010\u00032\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011H\u0002¢\u0006\u0004\b)\u0010*J7\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010-\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b/\u00100J#\u00103\u001a\u0002022\b\u00101\u001a\u0004\u0018\u00010\u00032\b\u0010-\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u0002062\u0006\u00105\u001a\u00020\u0014H\u0002¢\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u0004\u0018\u00010\u00032\b\u00109\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b:\u0010;J1\u0010@\u001a\u0004\u0018\u00010\u00032\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<2\u0006\u0010?\u001a\u00020\u0003H\u0002¢\u0006\u0004\b@\u0010AR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010B¨\u0006D"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/WeatherCardProvider;", "LN5/v;", "Lkotlin/Function0;", "", "currentDateProvider", "<init>", "(Lp9/a;)V", "LN5/i;", "envelope", "LN5/n;", Const.INTENT_KEY_PKGNAME, "(LN5/i;)LN5/n;", "Landroid/content/Context;", "context", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LN5/d;", "", "raw", "", "LQ5/e;", WeatherCardProvider.KEY_DAILY, "LQ5/g;", WeatherCardProvider.KEY_HOURLY, WeatherCardProvider.KEY_START_DATE, WeatherCardProvider.KEY_END_DATE, "l", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)I", "n", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "LQ5/i;", "k", "(Ljava/util/List;)LQ5/i;", "LQ5/k;", WeatherCardProvider.KEY_REGION, "LQ5/d;", "city", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LQ5/k;LQ5/d;)Ljava/lang/String;", WeatherCardProvider.KEY_CARD_TYPE, "dayCount", "f", "(II)Ljava/lang/String;", "LQ5/j;", "realtime", WeatherCardProvider.KEY_QUERY_TIME, "Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/a$c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;LQ5/j;Ljava/lang/String;)Ljava/util/List;", "itemDate", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;)Z", "item", "Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/a$b;", "e", "(LQ5/e;)Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/a$b;", "pop", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Integer;)Ljava/lang/String;", "", "", "data", "key", "m", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "Lp9/a;", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WeatherCardProvider implements v {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String KEY_CARD_TYPE = "cardType";

    @Deprecated
    public static final String KEY_CITY = "city";

    @Deprecated
    public static final String KEY_DAILY = "daily";

    @Deprecated
    public static final String KEY_END_DATE = "endDate";

    @Deprecated
    public static final String KEY_HOURLY = "hourly";

    @Deprecated
    public static final String KEY_QUERY_TIME = "queryTime";

    @Deprecated
    public static final String KEY_REALTIME = "realtime";

    @Deprecated
    public static final String KEY_REGION = "region";

    @Deprecated
    public static final String KEY_START_DATE = "startDate";

    @Deprecated
    public static final String LABEL_NOW = "现在";

    @Deprecated
    public static final int MINUTES_PER_HOUR = 60;
    private final InterfaceC5063a<String> currentDateProvider;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/WeatherCardProvider$a;", "", "<init>", "()V", "", "KEY_CITY", "Ljava/lang/String;", "KEY_REGION", "KEY_REALTIME", "KEY_DAILY", "KEY_HOURLY", "KEY_CARD_TYPE", "KEY_START_DATE", "KEY_END_DATE", "KEY_QUERY_TIME", "LABEL_NOW", "", "MINUTES_PER_HOUR", "I", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    public WeatherCardProvider(InterfaceC5063a<String> currentDateProvider) {
        p.i(currentDateProvider, "currentDateProvider");
        this.currentDateProvider = currentDateProvider;
    }

    public static final String d() {
        return LocalDate.now(ZoneId.systemDefault()).toString();
    }

    @Override // N5.v
    public d a(Context context) {
        p.i(context, "context");
        return new b(context, null, 0, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0514 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c9 A[Catch: Exception -> 0x01ce, TRY_LEAVE, TryCatch #1 {Exception -> 0x01ce, blocks: (B:76:0x01bd, B:78:0x01c9), top: B:260:0x01bd }] */
    @Override // N5.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public N5.n b(N5.CardEnvelope r64) {
        /*
            Method dump skipped, instructions count: 1393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider.b(N5.i):N5.n");
    }

    public final WeatherCardModel.DailyItem e(WeatherDaily item) {
        String strD = j.INSTANCE.d(item.getWeek());
        l lVar = l.INSTANCE;
        return new WeatherCardModel.DailyItem(strD, lVar.a(item.getDate(), item.getFullDate()), h.INSTANCE.c(item.getWeatherDay(), false), i(item.getPop()), lVar.h(item.getWeatherDay()), lVar.d(item.getTempLow(), item.getTempHigh()));
    }

    public final String f(int cardType, int dayCount) {
        if (cardType == 2) {
            Integer numValueOf = Integer.valueOf(dayCount);
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                return "未来" + numValueOf.intValue() + "天";
            }
        }
        return null;
    }

    public final List<WeatherCardModel.HourlyItem> g(List<WeatherHourly> hourly, WeatherRealtime realtime, String queryTime) {
        Iterator<WeatherHourly> it = hourly.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (p.d(it.next().getIsStart(), Boolean.TRUE)) {
                break;
            }
            i10++;
        }
        Integer numValueOf = Integer.valueOf(i10);
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        List<WeatherHourly> listH0 = F.h0(hourly, numValueOf != null ? numValueOf.intValue() : 0);
        ArrayList arrayList = new ArrayList(C1174w.x(listH0, 10));
        for (WeatherHourly weatherHourly : listH0) {
            String strD = j(weatherHourly.getDate(), queryTime) ? LABEL_NOW : j.INSTANCE.d(weatherHourly.getHour());
            h hVar = h.INSTANCE;
            String weather = weatherHourly.getWeather();
            f fVar = f.INSTANCE;
            String weather2 = weatherHourly.getWeather();
            String sunrise = realtime != null ? realtime.getSunrise() : null;
            String sunset = realtime != null ? realtime.getSunset() : null;
            String date = weatherHourly.getDate();
            if (date == null) {
                date = weatherHourly.getHour();
            }
            int iC = hVar.c(weather, fVar.b(weather2, sunrise, sunset, date));
            String strI = i(weatherHourly.getPop());
            String strD2 = j.INSTANCE.d(weatherHourly.getTemp());
            arrayList.add(new WeatherCardModel.HourlyItem(strD, iC, strI, strD2 != null ? strD2 + "°" : null));
        }
        return arrayList;
    }

    public final String h(WeatherRegion region, WeatherCity city) {
        j jVar = j.INSTANCE;
        String strD = jVar.d(region != null ? region.getArea() : null);
        if (strD != null) {
            return strD;
        }
        String strD2 = jVar.d(region != null ? region.getCity() : null);
        if (strD2 == null) {
            return jVar.d(city != null ? city.getName() : null);
        }
        return strD2;
    }

    public final String i(Integer pop) {
        if (pop == null) {
            return null;
        }
        if (pop.intValue() <= 0) {
            pop = null;
        }
        if (pop == null) {
            return null;
        }
        return pop.intValue() + "%";
    }

    public final boolean j(String itemDate, String queryTime) {
        String strA;
        Integer numC;
        f fVar = f.INSTANCE;
        String strA2 = fVar.a(itemDate);
        if (strA2 != null && (strA = fVar.a(queryTime)) != null && p.d(strA2, strA) && (numC = fVar.c(itemDate)) != null) {
            int iIntValue = numC.intValue();
            Integer numC2 = fVar.c(queryTime);
            if (numC2 != null && iIntValue / 60 == numC2.intValue() / 60) {
                return true;
            }
        }
        return false;
    }

    public final WeatherLifeIndex k(List<WeatherDaily> daily) {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = daily.iterator();
        while (it.hasNext()) {
            List<WeatherLifeIndex> listD = ((WeatherDaily) it.next()).d();
            if (listD == null) {
                listD = C1173v.m();
            }
            A.E(arrayList, listD);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (j.INSTANCE.d(((WeatherLifeIndex) obj).getRemind()) != null) {
                arrayList2.add(obj);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (p.d(((WeatherLifeIndex) next).getType(), l.TYPE_ULTRAVIOLET)) {
                break;
            }
        }
        WeatherLifeIndex weatherLifeIndex = (WeatherLifeIndex) next;
        return weatherLifeIndex == null ? (WeatherLifeIndex) F.s0(arrayList2) : weatherLifeIndex;
    }

    public final int l(Integer raw, List<WeatherDaily> daily, List<WeatherHourly> hourly, String startDate, String endDate) {
        if ((raw != null && raw.intValue() == 1) || ((raw != null && raw.intValue() == 2) || (raw != null && raw.intValue() == 3))) {
            return raw.intValue();
        }
        if (hourly.isEmpty()) {
            return (startDate == null || endDate == null) ? daily.size() > 1 ? 2 : 1 : startDate.compareTo(endDate) < 0 ? 2 : 1;
        }
        return 3;
    }

    public final String m(Map<String, ? extends Object> data, String key) {
        JsonElement jsonElement;
        Object objB;
        String strD;
        JsonObject jsonObjectC = k.INSTANCE.c(data);
        if (jsonObjectC == null || (jsonElement = jsonObjectC.get(key)) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(jsonElement.getAsString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null || (strD = j.INSTANCE.d(str)) == null) {
            return null;
        }
        return H.D1(strD).toString();
    }

    public final List<WeatherDaily> n(List<WeatherDaily> daily, String startDate, String endDate) {
        String string;
        if (startDate == null && endDate == null) {
            return daily;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : daily) {
            String strD = j.INSTANCE.d(((WeatherDaily) obj).getFullDate());
            if (strD != null && (string = H.D1(strD).toString()) != null) {
                if (startDate == null || string.compareTo(startDate) >= 0) {
                    if (endDate == null || string.compareTo(endDate) <= 0) {
                    }
                }
            }
            arrayList.add(obj);
        }
        if (!arrayList.isEmpty()) {
            daily = arrayList;
        }
        return daily;
    }

    public /* synthetic */ WeatherCardProvider(InterfaceC5063a interfaceC5063a, int i10, i iVar) {
        this((i10 & 1) != 0 ? new InterfaceC5063a() { // from class: Q5.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WeatherCardProvider.d();
            }
        } : interfaceC5063a);
    }
}
