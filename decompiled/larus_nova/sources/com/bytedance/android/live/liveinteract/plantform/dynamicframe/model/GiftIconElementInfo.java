package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import tf0.d;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/GiftIconElementInfo;", "Ltf0/d;", "", a.KEY_SCORE, "Ljava/lang/String;", "h", "()Ljava/lang/String;", "", "targetScore", "J", "getTargetScore", "()J", "iconUrl", "getIconUrl", "backgroundColor", "getBackgroundColor", "", "styleType", "I", "getStyleType", "()I", "Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "quickInteract", "Lcom/bytedance/android/live/liveinteract/plantform/model/l;", ce.f26391f, "()Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "setQuickInteract", "(Lcom/bytedance/android/live/liveinteract/plantform/model/l;)V", "StyleType", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftIconElementInfo extends d {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("quick_interact")
    private l quickInteract;

    @SerializedName(a.KEY_SCORE)
    private final String score;

    @SerializedName(MapMonitorConst.STYLE_TYPE)
    private final int styleType;

    @SerializedName("target_score")
    private final long targetScore;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/GiftIconElementInfo$StyleType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface StyleType {
        public static final a Companion = null;
        public static final int STYLE_TYPE_GUEST_BATTLE = 1;
        public static final int STYLE_TYPE_NORMAL = 0;
        public static final int STYLE_TYPE_NO_ICON = 3;
        public static final int STYLE_TYPE_ORDER_SONG_AVATAR = 4;
        public static final int STYLE_TYPE_STAR_WISH = 2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f77074a = null;

            public a() {
            }

            static {
                f77074a = new a();
            }
        }

        static {
            Companion = a.f77074a;
        }
    }

    @Override // tf0.d
    public final String toString() {
        return super.toString() + ", score = " + this.score + ", iconUrl = " + this.iconUrl + ", backgroundColor = " + this.backgroundColor + ", styleType = " + this.styleType;
    }

    public final l g() {
        return this.quickInteract;
    }

    public final String h() {
        return this.score;
    }

    @Override // tf0.d
    public final boolean e(d r100) {
        if (super.e(r100) == true) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        if (r100 != null) goto L10;
        return false;
    L10:
        if ((!Intrinsics.areEqual(GiftIconElementInfo.class, r100.getClass())) == true) goto L80;
        GiftIconElementInfo r101 = (GiftIconElementInfo) r100;
        l r102 = this.quickInteract;
        String r103 = null;
        if (r102 == null) goto L17;
        IBaseUser r104 = r102.getSendGiftUser();
        if (r104 == null) goto L17;
        String r105 = r104.getIdString();
    L18:
        l r106 = r101.quickInteract;
        if (r106 == null) goto L23;
        IBaseUser r107 = r106.getSendGiftUser();
        if (r107 == null) goto L23;
        String r108 = r107.getIdString();
    L25:
        if (Intrinsics.areEqual(r105, r108) == false) goto L56;
        l r109 = this.quickInteract;
        if (r109 == null) goto L29;
        Long r110 = Long.valueOf(r109.getInteractCarouselDuration());
    L30:
        l r111 = r101.quickInteract;
        if (r111 == null) goto L33;
        Long r112 = Long.valueOf(r111.getInteractCarouselDuration());
    L35:
        if (Intrinsics.areEqual(r110, r112) == false) goto L56;
        l r113 = this.quickInteract;
        if (r113 == null) goto L39;
        CharSequence r114 = r113.getInteractContent();
    L40:
        l r115 = r101.quickInteract;
        if (r115 == null) goto L43;
        CharSequence r116 = r115.getInteractContent();
    L45:
        if (Intrinsics.areEqual(r114, r116) == false) goto L56;
        l r117 = this.quickInteract;
        if (r117 == null) goto L49;
        String r118 = r117.getToUsedID();
    L50:
        l r119 = r101.quickInteract;
        if (r119 == null) goto L54;
        r103 = r119.getToUsedID();
    L54:
        if (Intrinsics.areEqual(r118, r103) == false) goto L56;
        boolean r120 = true;
    L58:
        if (Intrinsics.areEqual(this.score, r101.score) == true) goto L60;
        return false;
    L60:
        if (this.targetScore == r101.targetScore) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L66;
        return false;
    L66:
        if (this.styleType == r101.styleType) goto L68;
        return false;
    L68:
        if (this.targetScore != r101.targetScore) goto L78;
        if (r120 == false) goto L79;
        return true;
    L79:
        return false;
    L78:
        return false;
    L49:
        r118 = null;
        goto L50
    L43:
        r116 = null;
        goto L45
    L39:
        r114 = null;
        goto L40
    L33:
        r112 = null;
        goto L35
    L29:
        r110 = null;
    L56:
        r120 = false;
    L23:
        r108 = null;
    L17:
        r105 = null;
        goto L18
    L80:
        return false;
    }
}
