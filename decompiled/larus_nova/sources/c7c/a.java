package c7c;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.dtf.face.api.IDTFacade;
import com.ss.android.lark.time.format.common.c;
import com.ss.android.lark.time.format.entity.DataRepresentation;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DisplayPattern f22678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LengthType f22679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DatePreciseness f22680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TimePreciseness f22681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataRepresentation f22682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f22683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f22684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f22685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f22687k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Locale f22688l;

    public a() {
        this(null, null, null, null, null, false, false, false, false, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f22677a, r101.f22677a) == true) goto L12;
        return false;
    L12:
        if (this.f22678b == r101.f22678b) goto L15;
        return false;
    L15:
        if (this.f22679c == r101.f22679c) goto L18;
        return false;
    L18:
        if (this.f22680d == r101.f22680d) goto L21;
        return false;
    L21:
        if (this.f22681e == r101.f22681e) goto L24;
        return false;
    L24:
        if (this.f22682f == r101.f22682f) goto L27;
        return false;
    L27:
        if (this.f22683g == r101.f22683g) goto L30;
        return false;
    L30:
        if (this.f22684h == r101.f22684h) goto L33;
        return false;
    L33:
        if (this.f22685i == r101.f22685i) goto L36;
        return false;
    L36:
        if (this.f22686j == r101.f22686j) goto L39;
        return false;
    L39:
        if (this.f22687k == r101.f22687k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f22677a.hashCode() * 31) + this.f22678b.hashCode()) * 31) + this.f22679c.hashCode()) * 31) + this.f22680d.hashCode()) * 31) + this.f22681e.hashCode()) * 31) + this.f22682f.hashCode()) * 31;
        int r101 = 1231;
        if (this.f22683g == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f22684h == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f22685i == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f22686j == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f22687k == true) goto L23;
        r101 = 1237;
    L23:
        return r109 + r101;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "Options(timezone=" + this.f22677a + ", displayPattern=" + this.f22678b + ", lengthType=" + this.f22679c + ", datePreciseness=" + this.f22680d + ", timePreciseness=" + this.f22681e + ", dataRepresentation=" + this.f22682f + ", isShowTimezone=" + this.f22683g + ", isTwelveHour=" + this.f22684h + ", isTruncatingZeroTail=" + this.f22685i + ", isTimeOptimize=" + this.f22686j + ", formatSameDay=" + this.f22687k + ')';
    }

    public final void a(DatePreciseness r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f22680d = r100;
    }

    public final void b(DisplayPattern r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f22678b = r100;
    }

    public final void c(LengthType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f22679c = r100;
    }

    public final void d(TimePreciseness r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f22681e = r100;
    }

    public a(String r110, DisplayPattern r111, LengthType r112, DatePreciseness r210, boolean r211, Locale r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r213 & 2) == 0) goto L9;
        DisplayPattern r101 = DisplayPattern.ABSOLUTE;
    L11:
        if ((r213 & 4) == 0) goto L13;
        LengthType r102 = LengthType.LONG;
    L15:
        if ((r213 & 8) == 0) goto L17;
        DatePreciseness r103 = DatePreciseness.DAY;
    L18:
        Locale r113 = null;
        if ((r213 & 16) == 0) goto L21;
        TimePreciseness r104 = TimePreciseness.MINUTE;
    L23:
        if ((r213 & 32) == 0) goto L25;
        DataRepresentation r105 = DataRepresentation.ASIAN;
    L27:
        if ((r213 & 512) == 0) goto L29;
        boolean r114 = false;
    L31:
        if ((r213 & 2048) == 0) goto L33;
        Locale r106 = null;
    L34:
        Intrinsics.checkNotNullParameter(r100, "timezone");
        Intrinsics.checkNotNullParameter(r101, "displayPattern");
        Intrinsics.checkNotNullParameter(r102, "lengthType");
        Intrinsics.checkNotNullParameter(r103, "datePreciseness");
        Intrinsics.checkNotNullParameter(r104, "timePreciseness");
        Intrinsics.checkNotNullParameter(r105, "dataRepresentation");
        this(r100, r101, r102, r103, r104, r105, false, false, false, r114, false);
        int r107 = c.f441323a;
        if (r106 == null) goto L90;
        Locale r108 = new Locale("en", "US");
        if (TextUtils.isEmpty(r106.getCountry()) == true) goto L40;
        String r109 = r106.getLanguage() + '_' + r106.getCountry();
    L41:
        Intrinsics.checkNotNull(r109);
        if (StringsKt.startsWith$default(r109, "zh", false, 2, null) == false) goto L48;
        if (TextUtils.isEmpty(r106.getCountry()) == true) goto L46;
        r113 = new Locale("zh", r106.getCountry());
        goto L90
    L46:
        r113 = new Locale("zh", "CN");
        goto L90
    L48:
        if (StringsKt.startsWith$default(r109, IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_JA, false, 2, null) == false) goto L51;
        r113 = new Locale(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_JA, "JP");
        goto L90
    L51:
        if (StringsKt.startsWith$default(r109, "in", false, 2, null) == false) goto L53;
    L89:
        r113 = new Locale("id", "ID");
        goto L90
    L53:
        if (StringsKt.startsWith$default(r109, "id", false, 2, null) == true) goto L89;
        if (StringsKt.startsWith$default(r109, "de", false, 2, null) == false) goto L59;
        r113 = new Locale("de", "DE");
        goto L90
    L59:
        if (StringsKt.startsWith$default(r109, "en", false, 2, null) == false) goto L62;
        r113 = new Locale("en", "US");
        goto L90
    L62:
        if (StringsKt.startsWith$default(r109, "es", false, 2, null) == false) goto L65;
        r113 = new Locale("es", "ES");
        goto L90
    L65:
        if (StringsKt.startsWith$default(r109, "fr", false, 2, null) == false) goto L68;
        r113 = new Locale("fr", "FR");
        goto L90
    L68:
        if (StringsKt.startsWith$default(r109, "it", false, 2, null) == false) goto L71;
        r113 = new Locale("it", "IT");
        goto L90
    L71:
        if (StringsKt.startsWith$default(r109, GXTemplateKey.GAIAX_PT, false, 2, null) == false) goto L74;
        r113 = new Locale(GXTemplateKey.GAIAX_PT, "BR");
        goto L90
    L74:
        if (StringsKt.startsWith$default(r109, "vi", false, 2, null) == false) goto L77;
        r113 = new Locale("vi", "VN");
        goto L90
    L77:
        if (StringsKt.startsWith$default(r109, "ru", false, 2, null) == false) goto L80;
        r113 = new Locale("ru", "RU");
        goto L90
    L80:
        if (StringsKt.startsWith$default(r109, "hi", false, 2, null) == false) goto L83;
        r113 = new Locale("hi", "IN");
        goto L90
    L83:
        if (StringsKt.startsWith$default(r109, "th", false, 2, null) == false) goto L86;
        r113 = new Locale("th", "TH");
        goto L90
    L86:
        if (StringsKt.startsWith$default(r109, IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_KO, false, 2, null) == false) goto L91;
        r113 = new Locale(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_KO, "KR");
    L91:
        this.f22688l = r108;
        return;
    L40:
        r109 = r106.getLanguage();
    L90:
        r108 = r113;
        goto L91
    L33:
        r106 = r212;
        goto L34
    L29:
        r114 = r211;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r210;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public /* synthetic */ a(String r110, DisplayPattern r111, LengthType r112, DatePreciseness r113, TimePreciseness r114, boolean r210, boolean r211, boolean r212, boolean r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r214 & 2) == 0) goto L9;
        DisplayPattern r101 = DisplayPattern.ABSOLUTE;
    L11:
        if ((r214 & 4) == 0) goto L13;
        LengthType r102 = LengthType.LONG;
    L15:
        if ((r214 & 8) == 0) goto L17;
        DatePreciseness r103 = DatePreciseness.DAY;
    L19:
        if ((r214 & 16) == 0) goto L21;
        TimePreciseness r104 = TimePreciseness.MINUTE;
    L23:
        if ((r214 & 32) == 0) goto L25;
        DataRepresentation r105 = DataRepresentation.ASIAN;
    L26:
        DataRepresentation r106 = r105;
        if ((r214 & 64) == 0) goto L29;
        boolean r107 = false;
    L31:
        if ((r214 & 128) == 0) goto L33;
        boolean r115 = false;
    L35:
        if ((r214 & 256) == 0) goto L37;
        boolean r116 = false;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r117 = false;
    L42:
        this(r100, r101, r102, r103, r104, r106, r107, r115, r116, r117, false);
        return;
    L41:
        r117 = r213;
        goto L42
    L37:
        r116 = r212;
        goto L39
    L33:
        r115 = r211;
        goto L35
    L29:
        r107 = r210;
        goto L31
    L25:
        r105 = null;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public a(String r100, DisplayPattern r101, LengthType r102, DatePreciseness r103, TimePreciseness r104, DataRepresentation r105, boolean r106, boolean r107, boolean r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "timezone");
        Intrinsics.checkNotNullParameter(r101, "displayPattern");
        Intrinsics.checkNotNullParameter(r102, "lengthType");
        Intrinsics.checkNotNullParameter(r103, "datePreciseness");
        Intrinsics.checkNotNullParameter(r104, "timePreciseness");
        Intrinsics.checkNotNullParameter(r105, "dataRepresentation");
        this.f22677a = r100;
        this.f22678b = r101;
        this.f22679c = r102;
        this.f22680d = r103;
        this.f22681e = r104;
        this.f22682f = r105;
        this.f22683g = r106;
        this.f22684h = r107;
        this.f22685i = r110;
        this.f22686j = r111;
        this.f22687k = r112;
    }
}
