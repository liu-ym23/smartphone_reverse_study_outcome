package com.bytedance.android.livesdk.livecommerce.skin.model;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.skin.ECLiveSkinUtil;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB+\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0017\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006HÆ\u0003J-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0005HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBackgroundElement;", "Ljava/io/Serializable;", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", "component1", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinColors;", "component2", "image", "color", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", "getImage", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", "Ljava/util/List;", "getColor", "()Ljava/util/List;", "<init>", "(Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;Ljava/util/List;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinBackgroundElement implements Serializable {
    public static final a Companion = null;

    @SerializedName("color")
    private final List<String> color;

    @SerializedName("image")
    private final ECLiveSkinImageElement image;

    public static final class a {
        public a() {
        }

        public static Drawable a(ECLiveSkinBackgroundElement r110, Context r111, List r112, ECDraweeView r113) {
            Intrinsics.checkNotNullParameter(r110, "$this$convertToDrawable");
            GradientDrawable r100 = null;
            ECLiveSkinImageElement r101 = r110.getImage();     // Catch: Exception -> L120
            boolean r102 = true;
            if (r101 == null) goto L65;
            if (r111 == null) goto L68;
            String r103 = r101.getResourceName();     // Catch: Exception -> L120
            if (r103 != null) goto L10;
        L48:
            String r114 = r101.getUrl();     // Catch: Exception -> L120
            if (r114 != null) goto L51;
        L62:
            if (r113 == null) goto L64;
            r113.setVisibility(8);     // Catch: Exception -> L120
        L64:
            Unit r115 = Unit.INSTANCE;     // Catch: Exception -> L120
            goto L68
        L51:
            if (r114.length() <= 0) goto L53;
            boolean r104 = true;
        L54:
            if (r104 == false) goto L56;
            String r105 = r114;
        L57:
            if (r105 == null) goto L62;
            if (r113 == null) goto L68;
            r113.setVisibility(0);     // Catch: Exception -> L120
            h0.e(r113, r105, null, null, null, 120);     // Catch: Exception -> L120
            return new ColorDrawable(0);
        L56:
            r105 = null;
            goto L57
        L53:
            r104 = false;
            goto L54
        L10:
            if (r103.length() <= 0) goto L12;
            boolean r106 = true;
        L13:
            if (r106 == true) goto L16;
            r103 = null;
        L16:
            if (r103 == null) goto L48;
            ECLiveSkinUtil.f152968l.getClass();     // Catch: Exception -> L120
            Integer r107 = ECLiveSkinUtil.b(r103);     // Catch: Exception -> L120
            if (r107 == null) goto L48;
            r107.intValue();     // Catch: Exception -> L120
            int r116 = r107.intValue();     // Catch: Exception -> L120
            Lazy r117 = UtilityKotlinExtentionsKt.f153056a;     // Catch: Exception -> L120
            Intrinsics.checkNotNullParameter(r111, "$this$getDrawableCompat");     // Catch: Exception -> L120
            Drawable r118 = th.a.b(r111, r116);     // Catch: Exception -> L120
            if ((r118 instanceof BitmapDrawable) == true) goto L22;
            Drawable r119 = null;
        L23:
            BitmapDrawable r120 = (BitmapDrawable) r119;     // Catch: Exception -> L120
            if (r120 == null) goto L26;
            r120.setGravity(17);     // Catch: Exception -> L120
        L26:
            List<String> r121 = r101.getTintColor();     // Catch: Exception -> L120
            if (r121 == null) goto L47;
            String r122 = (String) CollectionsKt.firstOrNull(r121);     // Catch: Exception -> L120
            if (r122 == null) goto L47;
            if (r122.length() > 0) goto L34;
            r102 = false;
        L34:
            if (r102 == true) goto L37;
            r122 = null;
        L37:
            if (r122 == null) goto L47;
            Integer r123 = s.b(r122);     // Catch: Exception -> L120
            if (r123 == null) goto L47;
            int r124 = r123.intValue();     // Catch: Exception -> L120
            if ((r118 instanceof BitmapDrawable) == true) goto L43;
            Drawable r125 = null;
        L44:
            BitmapDrawable r126 = (BitmapDrawable) r125;     // Catch: Exception -> L120
            if (r126 == null) goto L47;
            r126.setColorFilter(r124, PorterDuff.Mode.DST);     // Catch: Exception -> L120
            goto L47
        L43:
            r125 = r118;
        L47:
            return r118;
        L22:
            r119 = r118;
            goto L23
        L12:
            r106 = false;
        L68:
            List<String> r127 = r110.getColor();     // Catch: Exception -> L120
            if (r127 != null) goto L71;
        L122:
            return null;
        L71:
            if ((!r127.isEmpty()) == true) goto L74;
            r127 = null;
        L74:
            if (r127 == null) goto L122;
            ArrayList r128 = new ArrayList();     // Catch: Exception -> L120
            Iterator<T> r129 = r127.iterator();     // Catch: Exception -> L120
        L77:
            if (r129.hasNext() == false) goto L82;
            Integer r130 = s.b((String) r129.next());     // Catch: Exception -> L120
            if (r130 == null) goto L77;
            r128.add(Integer.valueOf(r130.intValue()));     // Catch: Exception -> L120
            goto L77
        L82:
            if (r128.size() <= 0) goto L84;
            boolean r131 = true;
        L85:
            if (r131 == false) goto L87;
            ArrayList r132 = r128;
        L88:
            if (r132 == null) goto L122;
            if (r132.size() <= 1) goto L103;
            GradientDrawable r133 = new GradientDrawable();     // Catch: Exception -> L120
            r133.setColors(CollectionsKt.toIntArray(r128));     // Catch: Exception -> L120
            r133.setGradientType(0);     // Catch: Exception -> L120
            r133.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Exception -> L120
            if (r112 == null) goto L131;
            List r134 = r112;     // Catch: Exception -> L120
            ArrayList r135 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));     // Catch: Exception -> L120
            Iterator r136 = r134.iterator();     // Catch: Exception -> L120
        L95:
            if (r136.hasNext() == false) goto L98;
            r135.add(Float.valueOf(UtilityKotlinExtentionsKt.c(Float.valueOf(((Number) r136.next()).intValue()))));     // Catch: Exception -> L120
            goto L95
        L98:
            if (r135.size() != 4) goto L100;
            r133.setCornerRadii(CollectionsKt.toFloatArray(r135));     // Catch: Exception -> L120
            return r133;
        L100:
            Float r137 = (Float) CollectionsKt.firstOrNull(r135);     // Catch: Exception -> L120
            if (r137 == null) goto L133;
            r133.setCornerRadius(r137.floatValue());     // Catch: Exception -> L120
            return r133;
        L133:
            return r133;
        L131:
            return r133;
        L103:
            Integer r138 = (Integer) CollectionsKt.firstOrNull(r132);     // Catch: Exception -> L120
            if (r138 == null) goto L119;
            int r139 = r138.intValue();     // Catch: Exception -> L120
            GradientDrawable r140 = new GradientDrawable();     // Catch: Exception -> L120
            r140.setColor(r139);     // Catch: Exception -> L120
            if (r112 == null) goto L117;
            List r141 = r112;     // Catch: Exception -> L120
            ArrayList r142 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r141, 10));     // Catch: Exception -> L120
            Iterator r143 = r141.iterator();     // Catch: Exception -> L120
        L109:
            if (r143.hasNext() == false) goto L112;
            r142.add(Float.valueOf(UtilityKotlinExtentionsKt.c(Float.valueOf(((Number) r143.next()).intValue()))));     // Catch: Exception -> L120
            goto L109
        L112:
            if (r142.size() != 4) goto L114;
            r140.setCornerRadii(CollectionsKt.toFloatArray(r142));     // Catch: Exception -> L120
            goto L117
        L114:
            Float r144 = (Float) CollectionsKt.firstOrNull(r142);     // Catch: Exception -> L120
            if (r144 == null) goto L117;
            r140.setCornerRadius(r144.floatValue());     // Catch: Exception -> L120
        L117:
            r100 = r140;
        L119:
            return r100;
        L87:
            r132 = null;
            goto L88
        L84:
            r131 = false;
            goto L85
        L65:
            if (r113 == null) goto L67;
            r113.setVisibility(8);     // Catch: Exception -> L120
        L67:
            Unit r145 = Unit.INSTANCE;     // Catch: Exception -> L120
        L120:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L122
        }

        public static /* synthetic */ Drawable b(a r100, ECLiveSkinBackgroundElement r101, Context r102, ECDraweeView r103, int r104) {
            if ((r104 & 4) == 0) goto L5;
            r103 = null;
        L5:
            r100.getClass();
            return a(r101, r102, null, r103);
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECLiveSkinBackgroundElement() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinBackgroundElement copy$default(ECLiveSkinBackgroundElement r100, ECLiveSkinImageElement r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.image;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.color;
    L9:
        return r100.copy(r101, r102);
    }

    public final ECLiveSkinImageElement component1() {
        return this.image;
    }

    public final List<String> component2() {
        return this.color;
    }

    public final ECLiveSkinBackgroundElement copy(ECLiveSkinImageElement r100, List<String> r101) {
        return new ECLiveSkinBackgroundElement(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECLiveSkinBackgroundElement) == false) goto L10;
        ECLiveSkinBackgroundElement r101 = (ECLiveSkinBackgroundElement) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        ECLiveSkinImageElement r100 = this.image;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.color;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECLiveSkinBackgroundElement(image=" + this.image + ", color=" + this.color + ")";
    }

    public final List<String> getColor() {
        return this.color;
    }

    public final ECLiveSkinImageElement getImage() {
        return this.image;
    }

    public ECLiveSkinBackgroundElement(ECLiveSkinImageElement r100, List<String> r101) {
        this.image = r100;
        this.color = r101;
    }

    public /* synthetic */ ECLiveSkinBackgroundElement(ECLiveSkinImageElement r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
