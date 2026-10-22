package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.bytedance.ee.bear.bitable.app.model.ThemeType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/FontWeight;", "", "weight", "", "<init>", "(I)V", "getWeight", "()I", "compareTo", "other", "equals", "", "", "hashCode", "toString", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FontWeight implements Comparable<FontWeight> {
    public static final int $stable = 0;
    private static final FontWeight Black = null;
    private static final FontWeight Bold = null;
    public static final Companion Companion = null;
    private static final FontWeight ExtraBold = null;
    private static final FontWeight ExtraLight = null;
    private static final FontWeight Light = null;
    private static final FontWeight Medium = null;
    private static final FontWeight Normal = null;
    private static final FontWeight SemiBold = null;
    private static final FontWeight Thin = null;
    private static final FontWeight W100 = null;
    private static final FontWeight W200 = null;
    private static final FontWeight W300 = null;
    private static final FontWeight W400 = null;
    private static final FontWeight W500 = null;
    private static final FontWeight W600 = null;
    private static final FontWeight W700 = null;
    private static final FontWeight W800 = null;
    private static final FontWeight W900 = null;
    private static final List<FontWeight> values = null;
    private final int weight;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\bR\u001c\u0010!\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\bR\u001c\u0010$\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\bR\u001c\u0010'\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\bR\u001c\u0010*\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\bR\u001c\u0010-\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0003\u001a\u0004\b/\u0010\bR\u001c\u00100\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0003\u001a\u0004\b2\u0010\bR\u001c\u00103\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u0003\u001a\u0004\b5\u0010\bR\u001c\u00106\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u0010\bR\u001c\u00109\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u0003\u001a\u0004\b;\u0010\bR\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00050=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?¨\u0006@"}, d2 = {"Landroidx/compose/ui/text/font/FontWeight$Companion;", "", "<init>", "()V", "W100", "Landroidx/compose/ui/text/font/FontWeight;", "getW100$annotations", "getW100", "()Landroidx/compose/ui/text/font/FontWeight;", "W200", "getW200$annotations", "getW200", "W300", "getW300$annotations", "getW300", "W400", "getW400$annotations", "getW400", "W500", "getW500$annotations", "getW500", "W600", "getW600$annotations", "getW600", "W700", "getW700$annotations", "getW700", "W800", "getW800$annotations", "getW800", "W900", "getW900$annotations", "getW900", "Thin", "getThin$annotations", "getThin", "ExtraLight", "getExtraLight$annotations", "getExtraLight", ThemeType.DEFAULT_THEME_SYSTEM_TYPE, "getLight$annotations", "getLight", "Normal", "getNormal$annotations", "getNormal", "Medium", "getMedium$annotations", "getMedium", "SemiBold", "getSemiBold$annotations", "getSemiBold", "Bold", "getBold$annotations", "getBold", "ExtraBold", "getExtraBold$annotations", "getExtraBold", "Black", "getBlack$annotations", "getBlack", "values", "", "getValues$ui_text", "()Ljava/util/List;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getBlack$annotations() {
        }

        public static /* synthetic */ void getBold$annotations() {
        }

        public static /* synthetic */ void getExtraBold$annotations() {
        }

        public static /* synthetic */ void getExtraLight$annotations() {
        }

        public static /* synthetic */ void getLight$annotations() {
        }

        public static /* synthetic */ void getMedium$annotations() {
        }

        public static /* synthetic */ void getNormal$annotations() {
        }

        public static /* synthetic */ void getSemiBold$annotations() {
        }

        public static /* synthetic */ void getThin$annotations() {
        }

        public static /* synthetic */ void getW100$annotations() {
        }

        public static /* synthetic */ void getW200$annotations() {
        }

        public static /* synthetic */ void getW300$annotations() {
        }

        public static /* synthetic */ void getW400$annotations() {
        }

        public static /* synthetic */ void getW500$annotations() {
        }

        public static /* synthetic */ void getW600$annotations() {
        }

        public static /* synthetic */ void getW700$annotations() {
        }

        public static /* synthetic */ void getW800$annotations() {
        }

        public static /* synthetic */ void getW900$annotations() {
        }

        public final FontWeight getBlack() {
            return FontWeight.access$getBlack$cp();
        }

        public final FontWeight getBold() {
            return FontWeight.access$getBold$cp();
        }

        public final FontWeight getExtraBold() {
            return FontWeight.access$getExtraBold$cp();
        }

        public final FontWeight getExtraLight() {
            return FontWeight.access$getExtraLight$cp();
        }

        public final FontWeight getLight() {
            return FontWeight.access$getLight$cp();
        }

        public final FontWeight getMedium() {
            return FontWeight.access$getMedium$cp();
        }

        public final FontWeight getNormal() {
            return FontWeight.access$getNormal$cp();
        }

        public final FontWeight getSemiBold() {
            return FontWeight.access$getSemiBold$cp();
        }

        public final FontWeight getThin() {
            return FontWeight.access$getThin$cp();
        }

        public final List<FontWeight> getValues$ui_text() {
            return FontWeight.access$getValues$cp();
        }

        public final FontWeight getW100() {
            return FontWeight.access$getW100$cp();
        }

        public final FontWeight getW200() {
            return FontWeight.access$getW200$cp();
        }

        public final FontWeight getW300() {
            return FontWeight.access$getW300$cp();
        }

        public final FontWeight getW400() {
            return FontWeight.access$getW400$cp();
        }

        public final FontWeight getW500() {
            return FontWeight.access$getW500$cp();
        }

        public final FontWeight getW600() {
            return FontWeight.access$getW600$cp();
        }

        public final FontWeight getW700() {
            return FontWeight.access$getW700$cp();
        }

        public final FontWeight getW800() {
            return FontWeight.access$getW800$cp();
        }

        public final FontWeight getW900() {
            return FontWeight.access$getW900$cp();
        }
    }

    static {
        Companion = new Companion(null);
        FontWeight r100 = new FontWeight(100);
        W100 = r100;
        FontWeight r101 = new FontWeight(200);
        W200 = r101;
        FontWeight r102 = new FontWeight(300);
        W300 = r102;
        FontWeight r103 = new FontWeight(400);
        W400 = r103;
        FontWeight r104 = new FontWeight(500);
        W500 = r104;
        FontWeight r105 = new FontWeight(600);
        W600 = r105;
        FontWeight r106 = new FontWeight(700);
        W700 = r106;
        FontWeight r107 = new FontWeight(800);
        W800 = r107;
        FontWeight r108 = new FontWeight(900);
        W900 = r108;
        Thin = r100;
        ExtraLight = r101;
        Light = r102;
        Normal = r103;
        Medium = r104;
        SemiBold = r105;
        Bold = r106;
        ExtraBold = r107;
        Black = r108;
        values = CollectionsKt.listOf(new FontWeight[]{r100, r101, r102, r103, r104, r105, r106, r107, r108});
    }

    public String toString() {
        return "FontWeight(weight=" + this.weight + ')';
    }

    public static final /* synthetic */ FontWeight access$getBlack$cp() {
        return Black;
    }

    public static final /* synthetic */ FontWeight access$getBold$cp() {
        return Bold;
    }

    public static final /* synthetic */ FontWeight access$getExtraBold$cp() {
        return ExtraBold;
    }

    public static final /* synthetic */ FontWeight access$getExtraLight$cp() {
        return ExtraLight;
    }

    public static final /* synthetic */ FontWeight access$getLight$cp() {
        return Light;
    }

    public static final /* synthetic */ FontWeight access$getMedium$cp() {
        return Medium;
    }

    public static final /* synthetic */ FontWeight access$getNormal$cp() {
        return Normal;
    }

    public static final /* synthetic */ FontWeight access$getSemiBold$cp() {
        return SemiBold;
    }

    public static final /* synthetic */ FontWeight access$getThin$cp() {
        return Thin;
    }

    public static final /* synthetic */ List access$getValues$cp() {
        return values;
    }

    public static final /* synthetic */ FontWeight access$getW100$cp() {
        return W100;
    }

    public static final /* synthetic */ FontWeight access$getW200$cp() {
        return W200;
    }

    public static final /* synthetic */ FontWeight access$getW300$cp() {
        return W300;
    }

    public static final /* synthetic */ FontWeight access$getW400$cp() {
        return W400;
    }

    public static final /* synthetic */ FontWeight access$getW500$cp() {
        return W500;
    }

    public static final /* synthetic */ FontWeight access$getW600$cp() {
        return W600;
    }

    public static final /* synthetic */ FontWeight access$getW700$cp() {
        return W700;
    }

    public static final /* synthetic */ FontWeight access$getW800$cp() {
        return W800;
    }

    public static final /* synthetic */ FontWeight access$getW900$cp() {
        return W900;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return this.weight;
    }

    public FontWeight(int r100) {
        this.weight = r100;
        boolean r101 = false;
        if (1 <= r100) goto L5;
    L7:
        if (r101 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("Font weight can be in range [1, 1000]. Current value: " + r100);
        return;
    L10:
        return;
    L5:
        if (r100 >= 1001) goto L7;
        r101 = true;
        goto L7
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FontWeight r100) {
        return Intrinsics.compare(this.weight, r100.weight);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FontWeight) == true) goto L9;
        return false;
    L9:
        if (this.weight == ((FontWeight) r100).weight) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FontWeight r100) {
        return compareTo2(r100);
    }
}
