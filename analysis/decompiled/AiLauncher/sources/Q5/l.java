package Q5;

import La.D;
import La.H;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u0007J#\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\u0017J-\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"LQ5/l;", "", "<init>", "()V", "", "raw", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "humidity", "quality", "c", "(Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "low", "high", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "date", "fullDate", Const.INTENT_KEY_APIKEY, "", "e", "(Ljava/lang/String;)Z", "f", "type", "level", "remind", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "META_SEPARATOR", "Ljava/lang/String;", "TYPE_ULTRAVIOLET", "UV_KEYWORD", "", "NIGHT_SUFFIXES", "Ljava/util/List;", "DAY_SUFFIXES", "", "QUALITY_COMPLETIONS", "Ljava/util/Map;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l {
    private static final List<String> DAY_SUFFIXES;
    public static final l INSTANCE = new l();
    private static final String META_SEPARATOR = "   ";
    private static final List<String> NIGHT_SUFFIXES;
    private static final Map<String, String> QUALITY_COMPLETIONS;
    public static final String TYPE_ULTRAVIOLET = "ULTRAVIOLET_LIVE_INDEX";
    private static final String UV_KEYWORD = "紫外线";

    static {
        List<String> listP = C1173v.p("（夜间）", "(夜间)");
        NIGHT_SUFFIXES = listP;
        DAY_SUFFIXES = F.S0(listP, C1173v.p("（白天）", "(白天)"));
        QUALITY_COMPLETIONS = kotlin.collections.a.m(Y8.j.a("轻度", "轻度污染"), Y8.j.a("中度", "中度污染"), Y8.j.a("重度", "重度污染"), Y8.j.a("严重", "严重污染"));
    }

    public final String a(String date, String fullDate) {
        String str;
        String str2;
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(date);
        if (strD == null && (strD = jVar.d(fullDate)) == null) {
            return null;
        }
        List listB1 = H.b1(H.D1(strD).toString(), new String[]{O6.l.DATE_SEPARATOR, "/", "."}, false, 0, 6, null);
        if (listB1.size() >= 3) {
            str = (String) listB1.get(listB1.size() - 2);
            str2 = (String) F.C0(listB1);
        } else {
            if (listB1.size() != 2) {
                return strD;
            }
            str = (String) listB1.get(0);
            str2 = (String) listB1.get(1);
        }
        String strI1 = H.I1(str, '0');
        if (strI1.length() == 0) {
            return strD;
        }
        String strI12 = H.I1(str2, '0');
        if (strI12.length() == 0) {
            return strD;
        }
        return strI1 + "月" + strI12 + "日";
    }

    public final String b(String type, String level, String remind) {
        String strD;
        N5.j jVar = N5.j.INSTANCE;
        String strD2 = jVar.d(remind);
        if (strD2 == null) {
            return null;
        }
        if (!p.d(jVar.d(type), TYPE_ULTRAVIOLET) || (strD = jVar.d(level)) == null || H.g0(strD, UV_KEYWORD, false, 2, null) || H.g0(strD2, UV_KEYWORD, false, 2, null)) {
            return strD2;
        }
        return strD + "紫外线，" + strD2;
    }

    public final String c(Integer humidity, String quality) {
        ArrayList arrayList = new ArrayList();
        if (humidity != null) {
            int iIntValue = humidity.intValue();
            if (iIntValue < 0 || iIntValue >= 101) {
                humidity = null;
            }
            if (humidity != null) {
                arrayList.add("湿度 " + humidity.intValue() + "%");
            }
        }
        String strG = g(quality);
        if (strG != null) {
            arrayList.add("空气质量" + strG);
        }
        ArrayList arrayList2 = !arrayList.isEmpty() ? arrayList : null;
        if (arrayList2 != null) {
            return F.A0(arrayList2, META_SEPARATOR, null, null, 0, null, null, 62, null);
        }
        return null;
    }

    public final String d(String low, String high) {
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(low);
        String string = strD != null ? H.D1(strD).toString() : null;
        String strD2 = jVar.d(high);
        String string2 = strD2 != null ? H.D1(strD2).toString() : null;
        if (string == null || string2 == null) {
            return string == null ? string2 : string;
        }
        return string + "～" + string2;
    }

    public final boolean e(String raw) {
        String string;
        String strD = N5.j.INSTANCE.d(raw);
        if (strD != null && (string = H.D1(strD).toString()) != null) {
            List<String> list = DAY_SUFFIXES;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (D.K(string, (String) it.next(), false, 2, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean f(String raw) {
        String string;
        String strD = N5.j.INSTANCE.d(raw);
        if (strD != null && (string = H.D1(strD).toString()) != null) {
            List<String> list = NIGHT_SUFFIXES;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (D.K(string, (String) it.next(), false, 2, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String g(String raw) {
        String string;
        String strD = N5.j.INSTANCE.d(raw);
        if (strD == null || (string = H.D1(strD).toString()) == null) {
            return null;
        }
        String str = QUALITY_COMPLETIONS.get(string);
        return str == null ? string : str;
    }

    public final String h(String raw) {
        String strD = N5.j.INSTANCE.d(raw);
        if (strD == null) {
            return null;
        }
        String string = H.D1(strD).toString();
        Iterator<T> it = DAY_SUFFIXES.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (D.K(string, str, false, 2, null)) {
                String string2 = H.D1(H.T0(string, str)).toString();
                String str2 = string2.length() > 0 ? string2 : null;
                if (str2 == null) {
                    break;
                }
                return str2;
            }
        }
        return string;
    }
}
