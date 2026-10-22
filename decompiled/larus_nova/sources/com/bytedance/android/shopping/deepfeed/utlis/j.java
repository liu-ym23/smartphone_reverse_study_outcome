package com.bytedance.android.shopping.deepfeed.utlis;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import com.android.ttcjpaysdk.base.utils.CJFontServiceUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f173985a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f173986b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f173987c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f173988a;

        public a(Typeface r100) {
            this.f173988a = r100;
        }
    }

    static {
        f173985a = new ConcurrentHashMap();
        f173986b = SetsKt.setOf(new String[]{"douyin_number_abc_medium.otf", "douyin_number_abc_bold.otf", "douyin_number_abc_condensed_medium.otf", "douyin_number_abc_extra_bold.otf", "douyin_number_abc_extra_condensed_medium.otf", CJFontServiceUtils.DOUYIN_SANS_BOLD_FONT});
        f173987c = SetsKt.setOf(CJFontServiceUtils.DOUYIN_SANS_BOLD_FONT);
    }

    public static String a(long r100) {
        String r101 = "";
        if (r100 <= 0) goto L17;
        long r102 = 10000;
        if (r100 >= r102) goto L11;
        r101 = String.valueOf(r100);     // Catch: Exception -> L8
    L20:
        goto L17
    L11:
        if (r100 >= 100000) goto L14;
        r101 = StringsKt.replace$default(String.format("%.1f万", Arrays.copyOf(new Object[]{Double.valueOf(((double) ((int) ((r100 / 10000.0f) * 10))) / 10.0d)}, 1)), ".0万", "万", false, 4, null);     // Catch: Exception -> L8
        goto L20
    L14:
        if (r100 > Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST) goto L16;
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L8
        r103.append((int) (r100 / r102));     // Catch: Exception -> L8
        r103.append(19975);     // Catch: Exception -> L8
        r101 = r103.toString();     // Catch: Exception -> L8
        goto L20
    L16:
        r101 = "90万+";
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r101;
    L17:
        return r101;
    }

    public static int b(String r110) {
        List<String> r111 = new Regex(",").split(r110.substring(5, r110.length() - 1), 0);
        if (r111.isEmpty() == true) goto L13;
        ListIterator<String> r100 = r111.listIterator(r111.size());
    L6:
        if (r100.hasPrevious() == false) goto L13;
        if (r100.previous().length() != 0) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L6;
        List r112 = CollectionsKt.take(r111, r100.nextIndex() + 1);
    L14:
        Object[] r113 = r112.toArray(new String[0]);
        if (r113 == null) goto L101;
        String[] r114 = (String[]) r113;
        String r102 = r114[0];     // Catch: NumberFormatException -> L102
        int r103 = r102.length() - 1;     // Catch: NumberFormatException -> L102
        int r104 = 0;
        boolean r105 = false;
    L19:
        if (r104 > r103) goto L34;
        if (r105 == true) goto L22;
        int r106 = r104;
    L24:
        if (Intrinsics.compare(r102.charAt(r106), 32) > 0) goto L26;
        boolean r107 = true;
    L27:
        if (r105 == false) goto L28;
        if (r107 == false) goto L34;
        r103 = r103 - 1;     // Catch: NumberFormatException -> L102
        goto L19
    L28:
        if (r107 == false) goto L29;
        r104 = r104 + 1;     // Catch: NumberFormatException -> L102
        goto L19
    L29:
        r105 = true;
        goto L19
    L26:
        r107 = false;
        goto L27
    L22:
        r106 = r103;
    L34:
        int r108 = CastIntegerProtector.parseInt(r102.subSequence(r104, r103 + 1).toString());     // Catch: NumberFormatException -> L102
        String r109 = r114[1];     // Catch: NumberFormatException -> L102
        int r115 = r109.length() - 1;     // Catch: NumberFormatException -> L102
        int r116 = 0;
        boolean r117 = false;
    L35:
        if (r116 > r115) goto L50;
        if (r117 == true) goto L38;
        int r118 = r116;
    L40:
        if (Intrinsics.compare(r109.charAt(r118), 32) > 0) goto L42;
        boolean r119 = true;
    L43:
        if (r117 == false) goto L44;
        if (r119 == false) goto L50;
        r115 = r115 - 1;     // Catch: NumberFormatException -> L102
        goto L35
    L44:
        if (r119 == false) goto L45;
        r116 = r116 + 1;     // Catch: NumberFormatException -> L102
        goto L35
    L45:
        r117 = true;
        goto L35
    L42:
        r119 = false;
        goto L43
    L38:
        r118 = r115;
    L50:
        int r120 = CastIntegerProtector.parseInt(r109.subSequence(r116, r115 + 1).toString());     // Catch: NumberFormatException -> L102
        String r121 = r114[2];     // Catch: NumberFormatException -> L102
        int r122 = r121.length() - 1;     // Catch: NumberFormatException -> L102
        int r123 = 0;
        boolean r124 = false;
    L51:
        if (r123 > r122) goto L66;
        if (r124 == true) goto L54;
        int r125 = r123;
    L56:
        if (Intrinsics.compare(r121.charAt(r125), 32) > 0) goto L58;
        boolean r126 = true;
    L59:
        if (r124 == false) goto L60;
        if (r126 == false) goto L66;
        r122 = r122 - 1;     // Catch: NumberFormatException -> L102
        goto L51
    L60:
        if (r126 == false) goto L61;
        r123 = r123 + 1;     // Catch: NumberFormatException -> L102
        goto L51
    L61:
        r124 = true;
        goto L51
    L58:
        r126 = false;
        goto L59
    L54:
        r125 = r122;
    L66:
        int r127 = CastIntegerProtector.parseInt(r121.subSequence(r123, r122 + 1).toString());     // Catch: NumberFormatException -> L102
        String r128 = r114[3];     // Catch: NumberFormatException -> L102
        int r129 = r128.length() - 1;     // Catch: NumberFormatException -> L102
        int r130 = 0;
        boolean r131 = false;
    L67:
        if (r130 > r129) goto L82;
        if (r131 == true) goto L70;
        int r132 = r130;
    L72:
        if (Intrinsics.compare(r128.charAt(r132), 32) > 0) goto L74;
        boolean r133 = true;
    L75:
        if (r131 == false) goto L76;
        if (r133 == false) goto L82;
        r129 = r129 - 1;     // Catch: NumberFormatException -> L102
        goto L67
    L76:
        if (r133 == false) goto L77;
        r130 = r130 + 1;     // Catch: NumberFormatException -> L102
        goto L67
    L77:
        r131 = true;
        goto L67
    L74:
        r133 = false;
        goto L75
    L70:
        r132 = r129;
    L82:
        float r134 = CastFloatProtector.parseFloat(r128.subSequence(r130, r129 + 1).toString());     // Catch: NumberFormatException -> L102
        if (r108 < 0) goto L99;
        if (255 < r108) goto L99;
        if (r120 < 0) goto L99;
        if (255 < r120) goto L99;
        if (r127 < 0) goto L99;
        if (255 < r127) goto L99;
        if (0.0f > r134) goto L99;
        if (r134 > 1.0f) goto L99;
        return Color.argb((int) (r134 * 255), r108, r120, r127);
    L99:
        return 0;
    L101:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L10:
        r101 = false;
    L13:
        r112 = CollectionsKt.emptyList();
        goto L14
    }

    public static Integer d(String r100) {
        if (r100 != null) goto L23;
        return null;
    L23:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L20
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == false) goto L15;
        Intrinsics.checkNotNullParameter(r100, "colorStr");     // Catch: Throwable -> L20
        if (r100.length() != 9) goto L13;
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == false) goto L13;
        r100 = "#" + r100.substring(7, 9) + r100.substring(1, 7);     // Catch: Throwable -> L20
    L13:
        return Integer.valueOf(Color.parseColor(r100));
    L15:
        if (StringsKt.startsWith$default(r100, "rgba", false, 2, null) == true) goto L17;
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        return null;
    L17:
        return Integer.valueOf(b(r100));
    L20:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public static Typeface c(String r100, Context r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, LynxResourceModule.FONT_TYPE);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = r100.hashCode();
        if (r103 == (-981614931)) goto L11;
        if (r103 == 1866312093) goto L8;
    L13:
        String r104 = r100;
    L14:
        Typeface r105 = null;
        if (f173986b.contains(r104) == true) goto L17;
        return null;
    L17:
        String r106 = "fonts/".concat(r104);
        a r107 = f173985a.get(r106);
        if (r107 == null) goto L20;
        Typeface r108 = r107.f173988a;
    L21:
        if (r108 == null) goto L23;
    L30:
        if (r108 == null) goto L40;
        f173985a.put(r106, new a(r108));
        if (r102 != null) goto L35;
        return r108;
    L35:
        if (Build.VERSION.SDK_INT < 28) goto L40;
        if (r108.getWeight() == r102.intValue()) goto L40;
        return Typeface.create(r108, r102.intValue(), r108.isItalic());
    L40:
        return r108;
    L23:
        if (f173987c.contains(r100) == false) goto L41;
        r108 = com.bytedance.android.ec.sdk.helper.i.f48124a.a(r101, r100);
        goto L30
    L41:
        r105 = Typeface.createFromAsset(r101.getAssets(), r106);     // Catch: Exception -> L27
    L29:
        r108 = r105;
    L27:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L29
    L20:
        r108 = null;
        goto L21
    L8:
        if (r100.equals("DouyinNumberABC-Medium") == false) goto L13;
        r104 = "douyin_number_abc_medium.otf";
        goto L14
    L11:
        if (r100.equals("DouyinNumberABC-Bold") == false) goto L13;
        r104 = "douyin_number_abc_bold.otf";
        goto L14
    }
}
