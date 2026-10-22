package N5;

import La.D;
import La.H;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.travel.HotelPrice;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0007J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0007¨\u0006\u001d"}, d2 = {"LN5/j;", "", "<init>", "()V", "", "raw", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", "", "amount", "currency", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Double;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Double;)Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/i;", "price", "", "nights", "f", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/i;Ljava/lang/Integer;)Ljava/lang/Double;", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "e", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_PKGNAME, "(D)Ljava/lang/String;", "c", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    public static final j INSTANCE = new j();

    public final String a(Double amount) {
        return amount == null ? "" : b(amount.doubleValue());
    }

    public final String b(double amount) {
        if (amount % 1.0d == 0.0d) {
            return String.valueOf((long) amount);
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(amount)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public final String c(String raw) {
        String str;
        String str2;
        String strI1;
        String strI12;
        String strD = d(raw);
        if (strD == null) {
            return null;
        }
        List listB1 = H.b1(H.D1(strD).toString(), new String[]{O6.l.DATE_SEPARATOR, ".", "/"}, false, 0, 6, null);
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
        if (str == null || (strI1 = H.I1(str, '0')) == null) {
            return strD;
        }
        if (strI1.length() == 0) {
            strI1 = "0";
        }
        if (str2 == null || (strI12 = H.I1(str2, '0')) == null) {
            return strD;
        }
        return strI1 + "月" + (strI12.length() != 0 ? strI12 : "0") + "日";
    }

    public final String d(String raw) {
        if (raw == null || H.x0(raw) || D.L(raw, "null", true)) {
            return null;
        }
        return raw;
    }

    public final String e(String start, String end) {
        String strC = c(start);
        String strC2 = c(end);
        if (strC == null && strC2 == null) {
            return "";
        }
        if (strC == null || strC2 == null) {
            return strC == null ? strC2 == null ? "" : strC2 : strC;
        }
        return strC + " - " + strC2;
    }

    public final Double f(HotelPrice price, Integer nights) {
        Double amount;
        if (price == null || (amount = price.getAmount()) == null) {
            return null;
        }
        return (!kotlin.jvm.internal.p.d(price.getPriceUnit(), "per_night") || nights == null || nights.intValue() <= 0) ? amount : Double.valueOf(amount.doubleValue() * nights.intValue());
    }

    public final String g(Double amount, String currency) {
        if (amount == null) {
            return "";
        }
        return h(currency) + b(amount.doubleValue());
    }

    public final String h(String currency) {
        String upperCase;
        String strD;
        String strD2 = d(currency);
        if (strD2 != null) {
            upperCase = strD2.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        return (kotlin.jvm.internal.p.d(upperCase, "CNY") || kotlin.jvm.internal.p.d(upperCase, "RMB") || upperCase == null || (strD = d(currency)) == null) ? "¥" : strD;
    }
}
