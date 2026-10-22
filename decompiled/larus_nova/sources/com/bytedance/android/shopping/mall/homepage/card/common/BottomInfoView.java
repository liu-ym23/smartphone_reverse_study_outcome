package com.bytedance.android.shopping.mall.homepage.card.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.homepage.card.BigFontAdapter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CommonColorStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CusTextStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$ModuleDesc;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Product;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$User;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ProductStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.TextBaseUIParams;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.mall.homepage.card.live.AdTagView;
import com.bytedance.android.shopping.mall.homepage.card.live.LiveCardModel;
import com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.forest.utils.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttm.player.MediaPlayer;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import yj.i;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001#B\u0013\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001d\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001fB%\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001b\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u001b\u0010\u000f\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0014¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/BottomInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "hexColor", "", "setHotIconViewColorAndAlpha", "themeColor", "setContainerColor", "", "scale", "setViewScaleSize", "f", "Lkotlin/Lazy;", "getNameSize", "()F", "nameSize", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "nameView", RXScreenCaptureService.KEY_INDEX, "getRecReasonView", "recReasonView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BottomInfoView extends ConstraintLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f177428p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CommonModel$ModuleDesc f177429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommonModel$ModuleDesc f177430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CommonModel$ModuleDesc f177431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommonModel$LayoutStyle f177432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f177433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f177434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SimpleDraweeView f177435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f177436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f177437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SimpleDraweeView f177438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SimpleDraweeView f177439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f177440l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HotTextContainerView f177441m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ReturnRewardBtn f177442n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AdTagView f177443o;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/BottomInfoView$Companion$ElementStyle;", "", "avatarDesc", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;", "hotDesc", "hotIcon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "returnRewardDesc", "coinIconLayout", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;)V", "getAvatarDesc", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;", "getCoinIconLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "getHotDesc", "getHotIcon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "getReturnRewardDesc", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ElementStyle {
            private final CommonModel$ModuleDesc avatarDesc;
            private final CommonModel$LayoutStyle coinIconLayout;
            private final CommonModel$ModuleDesc hotDesc;
            private final CommonModel$CommonColorStyle hotIcon;
            private final CommonModel$ModuleDesc returnRewardDesc;

            public ElementStyle() {
                this(null, null, null, null, null, 31, null);
            }

            public static /* synthetic */ ElementStyle copy$default(ElementStyle r100, CommonModel$ModuleDesc r101, CommonModel$ModuleDesc r102, CommonModel$CommonColorStyle r103, CommonModel$ModuleDesc r104, CommonModel$LayoutStyle r105, int r106, Object r110) {
                if ((r106 & 1) == 0) goto L6;
                r101 = r100.avatarDesc;
            L6:
                if ((r106 & 2) == 0) goto L8;
                r102 = r100.hotDesc;
            L8:
                CommonModel$ModuleDesc r111 = r102;
                if ((r106 & 4) == 0) goto L11;
                r103 = r100.hotIcon;
            L11:
                CommonModel$CommonColorStyle r107 = r103;
                if ((r106 & 8) == 0) goto L14;
                r104 = r100.returnRewardDesc;
            L14:
                CommonModel$ModuleDesc r108 = r104;
                if ((r106 & 16) == 0) goto L17;
                r105 = r100.coinIconLayout;
            L17:
                CommonModel$ModuleDesc r109 = r101;
                return r100.copy(r109, r111, r107, r108, r105);
            }

            public final CommonModel$ModuleDesc component1() {
                return this.avatarDesc;
            }

            public final CommonModel$ModuleDesc component2() {
                return this.hotDesc;
            }

            public final CommonModel$CommonColorStyle component3() {
                return this.hotIcon;
            }

            public final CommonModel$ModuleDesc component4() {
                return this.returnRewardDesc;
            }

            public final CommonModel$LayoutStyle component5() {
                return this.coinIconLayout;
            }

            public final ElementStyle copy(CommonModel$ModuleDesc r100, CommonModel$ModuleDesc r101, CommonModel$CommonColorStyle r110, CommonModel$ModuleDesc r111, CommonModel$LayoutStyle r112) {
                return new ElementStyle(r100, r101, r110, r111, r112);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof ElementStyle) == false) goto L16;
                ElementStyle r101 = (ElementStyle) r100;
                if (Intrinsics.areEqual(this.avatarDesc, r101.avatarDesc) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.hotDesc, r101.hotDesc) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.hotIcon, r101.hotIcon) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.returnRewardDesc, r101.returnRewardDesc) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.coinIconLayout, r101.coinIconLayout) == true) goto L25;
                return false;
            L25:
                return true;
            L16:
                return false;
            }

            public int hashCode() {
                CommonModel$ModuleDesc r100 = this.avatarDesc;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                CommonModel$ModuleDesc r104 = this.hotDesc;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                CommonModel$CommonColorStyle r107 = this.hotIcon;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                CommonModel$ModuleDesc r110 = this.returnRewardDesc;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                CommonModel$LayoutStyle r113 = this.coinIconLayout;
                if (r113 == null) goto L22;
                r101 = r113.hashCode();
            L22:
                return r112 + r101;
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "ElementStyle(avatarDesc=" + this.avatarDesc + ", hotDesc=" + this.hotDesc + ", hotIcon=" + this.hotIcon + ", returnRewardDesc=" + this.returnRewardDesc + ", coinIconLayout=" + this.coinIconLayout + ")";
            }

            public final CommonModel$ModuleDesc getAvatarDesc() {
                return this.avatarDesc;
            }

            public final CommonModel$LayoutStyle getCoinIconLayout() {
                return this.coinIconLayout;
            }

            public final CommonModel$ModuleDesc getHotDesc() {
                return this.hotDesc;
            }

            public final CommonModel$CommonColorStyle getHotIcon() {
                return this.hotIcon;
            }

            public final CommonModel$ModuleDesc getReturnRewardDesc() {
                return this.returnRewardDesc;
            }

            public ElementStyle(CommonModel$ModuleDesc r100, CommonModel$ModuleDesc r101, CommonModel$CommonColorStyle r102, CommonModel$ModuleDesc r103, CommonModel$LayoutStyle r104) {
                this.avatarDesc = r100;
                this.hotDesc = r101;
                this.hotIcon = r102;
                this.returnRewardDesc = r103;
                this.coinIconLayout = r104;
            }

            public /* synthetic */ ElementStyle(CommonModel$ModuleDesc r100, CommonModel$ModuleDesc r101, CommonModel$CommonColorStyle r102, CommonModel$ModuleDesc r103, CommonModel$LayoutStyle r104, int r110, DefaultConstructorMarker r111) {
                if ((r110 & 1) == 0) goto L5;
                CommonModel$ModuleDesc r112 = null;
            L7:
                if ((r110 & 2) == 0) goto L9;
                CommonModel$ModuleDesc r105 = null;
            L11:
                if ((r110 & 4) == 0) goto L13;
                CommonModel$CommonColorStyle r106 = null;
            L15:
                if ((r110 & 8) == 0) goto L17;
                CommonModel$ModuleDesc r107 = null;
            L19:
                if ((r110 & 16) == 0) goto L21;
                CommonModel$LayoutStyle r113 = null;
            L22:
                this(r112, r105, r106, r107, r113);
                return;
            L21:
                r113 = r104;
                goto L22
            L17:
                r107 = r103;
                goto L19
            L13:
                r106 = r102;
                goto L15
            L9:
                r105 = r101;
                goto L11
            L5:
                r112 = r100;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/BottomInfoView$Companion$Experiment;", "", "enlargeCover", "", "enableDarkModel", "coinLabelStyle", "", "showPeopleNewIcon", "(ZZIZ)V", "getCoinLabelStyle", "()I", "getEnableDarkModel", "()Z", "getEnlargeCover", "getShowPeopleNewIcon", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Experiment {
            private final int coinLabelStyle;
            private final boolean enableDarkModel;
            private final boolean enlargeCover;
            private final boolean showPeopleNewIcon;

            public Experiment() {
                this(false, false, 0, false, 15, null);
            }

            public static /* synthetic */ Experiment copy$default(Experiment r100, boolean r101, boolean r102, int r103, boolean r104, int r105, Object r106) {
                if ((r105 & 1) == 0) goto L6;
                r101 = r100.enlargeCover;
            L6:
                if ((r105 & 2) == 0) goto L9;
                r102 = r100.enableDarkModel;
            L9:
                if ((r105 & 4) == 0) goto L12;
                r103 = r100.coinLabelStyle;
            L12:
                if ((r105 & 8) == 0) goto L15;
                r104 = r100.showPeopleNewIcon;
            L15:
                return r100.copy(r101, r102, r103, r104);
            }

            public final boolean component1() {
                return this.enlargeCover;
            }

            public final boolean component2() {
                return this.enableDarkModel;
            }

            public final int component3() {
                return this.coinLabelStyle;
            }

            public final boolean component4() {
                return this.showPeopleNewIcon;
            }

            public final Experiment copy(boolean r100, boolean r101, int r102, boolean r103) {
                return new Experiment(r100, r101, r102, r103);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Experiment) == false) goto L14;
                Experiment r101 = (Experiment) r100;
                if (this.enlargeCover == r101.enlargeCover) goto L8;
                return false;
            L8:
                if (this.enableDarkModel == r101.enableDarkModel) goto L10;
                return false;
            L10:
                if (this.coinLabelStyle == r101.coinLabelStyle) goto L12;
                return false;
            L12:
                if (this.showPeopleNewIcon == r101.showPeopleNewIcon) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r0v9 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v4 */
            /* JADX WARN: Type inference failed for: r2v5 */
            public int hashCode() {
                boolean r100 = this.enlargeCover;
                ?? r101 = 1;
                ?? r102 = r100;
                if (r100 == false) goto L5;
                r102 = 1;
            L5:
                int r103 = r102 * 31;
                boolean r104 = this.enableDarkModel;
                ?? r105 = r104;
                if (r104 == false) goto L8;
                r105 = 1;
            L8:
                int r106 = (((r103 + r105) * 31) + this.coinLabelStyle) * 31;
                boolean r107 = this.showPeopleNewIcon;
                if (r107 == true) goto L13;
                r101 = r107;
            L13:
                return r106 + r101;
            }

            public String toString() {
                return "Experiment(enlargeCover=" + this.enlargeCover + ", enableDarkModel=" + this.enableDarkModel + ", coinLabelStyle=" + this.coinLabelStyle + ", showPeopleNewIcon=" + this.showPeopleNewIcon + ")";
            }

            public final int getCoinLabelStyle() {
                return this.coinLabelStyle;
            }

            public final boolean getEnableDarkModel() {
                return this.enableDarkModel;
            }

            public final boolean getEnlargeCover() {
                return this.enlargeCover;
            }

            public final boolean getShowPeopleNewIcon() {
                return this.showPeopleNewIcon;
            }

            public Experiment(boolean r100, boolean r101, int r102, boolean r103) {
                this.enlargeCover = r100;
                this.enableDarkModel = r101;
                this.coinLabelStyle = r102;
                this.showPeopleNewIcon = r103;
            }

            public /* synthetic */ Experiment(boolean r100, boolean r101, int r102, boolean r103, int r104, DefaultConstructorMarker r105) {
                if ((r104 & 1) == 0) goto L6;
                r100 = false;
            L6:
                if ((r104 & 2) == 0) goto L9;
                r101 = false;
            L9:
                if ((r104 & 4) == 0) goto L12;
                r102 = 0;
            L12:
                if ((r104 & 8) == 0) goto L14;
                r103 = false;
            L14:
                this(r100, r101, r102, r103);
            }
        }
    }

    static {
    }

    private final float getNameSize() {
        return ((Number) this.f177434f.getValue()).floatValue();
    }

    private final TextView getRecReasonView() {
        return (TextView) this.f177437i.getValue();
    }

    public void R5() {
        Lazy r100 = HybridAppInfoService.f47530a;
        if (HybridAppInfoService.i() == false) goto L5;
        this.f177436h.setTextColor(ColorProtector.parseColor("#333333"));
        setHotIconViewColorAndAlpha("#73161823");
        this.f177440l.setTextColor(ColorProtector.parseColor("#73161823"));
        this.f177441m.a("#99161823");
        return;
    L5:
        this.f177436h.setTextColor(ColorProtector.parseColor("#3E3E3E"));
        setHotIconViewColorAndAlpha("#57161823");
        this.f177440l.setTextColor(ColorProtector.parseColor("#57161823"));
        this.f177441m.a("#57161823");
    }

    public final void T5() {
        Lazy r100 = BigFontAdapter.f170278a;
        BigFontAdapter.e(this.f177435g, 6);
        BigFontAdapter.d(this.f177436h);
        BigFontAdapter.e(this.f177438j, 6);
        BigFontAdapter.d(this.f177440l);
        ReturnRewardBtn r101 = this.f177442n;
        r101.getClass();
        BigFontAdapter.d(r101.f177500c);
    }

    public final TextView getNameView() {
        return this.f177436h;
    }

    public BottomInfoView(Context r110) {
        super(r110);
        this.f177433e = 1.0f;
        this.f177434f = LazyKt.lazy(BottomInfoView$nameSize$2.INSTANCE);
        SimpleDraweeView r111 = new SimpleDraweeView(getContext());
        r111.setId(ViewCompat.generateViewId());
        RoundingParams r100 = RoundingParams.fromCornersRadius(5.0f);
        r100.setRoundAsCircle(true);
        r111.getHierarchy().setRoundingParams(r100);
        r111.getHierarchy().setOverlayImage(new ColorDrawable(ColorProtector.parseColor("#0D000000")));
        Unit r101 = Unit.INSTANCE;
        this.f177435g = r111;
        TextView r102 = new TextView(getContext());
        r102.setId(ViewCompat.generateViewId());
        ToolsKt.b(r102);
        r102.setIncludeFontPadding(false);
        r102.setMaxLines(1);
        r102.setTextSize(1, getNameSize());
        r102.setGravity(GravityCompat.START);
        this.f177436h = r102;
        this.f177437i = LazyKt.lazy(new BottomInfoView$recReasonView$2(this));
        SimpleDraweeView r103 = new SimpleDraweeView(getContext());
        r103.setId(ViewCompat.generateViewId());
        r103.setImageResource(R.drawable.shopping_homepage_live_hot_6x);
        this.f177438j = r103;
        SimpleDraweeView r104 = new SimpleDraweeView(getContext());
        r104.setId(ViewCompat.generateViewId());
        this.f177439k = r104;
        TextView r105 = new TextView(getContext());
        r105.setId(ViewCompat.generateViewId());
        r105.setTextSize(1, 11.0f);
        this.f177440l = r105;
        Context r106 = getContext();
        AttributeSet r107 = null;
        int r108 = 6;
        HotTextContainerView r109 = new HotTextContainerView(r106, r107, r108, 0);
        r109.setId(ViewCompat.generateViewId());
        this.f177441m = r109;
        ReturnRewardBtn r112 = new ReturnRewardBtn(getContext(), null);
        r112.setId(ViewCompat.generateViewId());
        r112.setRadius(UIUtils.dip2Px(r112.getContext(), 4.0f));
        this.f177442n = r112;
        AdTagView r113 = new AdTagView(getContext());
        r113.setId(ViewCompat.generateViewId());
        r113.setVisibility(8);
        this.f177443o = r113;
        ConstraintLayout.LayoutParams r114 = new ConstraintLayout.LayoutParams(0, b0.c(26));
        r114.leftToLeft = 0;
        r114.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r114).topMargin = b0.c(8);
        r114.topToBottom = r111.getId();
        addView(r112, r114);
        ConstraintLayout.LayoutParams r115 = new ConstraintLayout.LayoutParams(b0.c(16), b0.c(16));
        r115.leftToLeft = 0;
        r115.topToTop = 0;
        r115.rightToLeft = r102.getId();
        ((ViewGroup.MarginLayoutParams) r115).rightMargin = b0.c(4);
        addView(r111, r115);
        ConstraintLayout.LayoutParams r116 = new ConstraintLayout.LayoutParams(-2, -2);
        r116.topToTop = r111.getId();
        r116.bottomToBottom = r111.getId();
        r116.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r116).topMargin = b0.c(1);
        addView(r109, r116);
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(-2, -2);
        r117.topToTop = r111.getId();
        r117.bottomToBottom = r111.getId();
        r117.rightToRight = 0;
        addView(r105, r117);
        ConstraintLayout.LayoutParams r118 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r118.topToTop = r111.getId();
        r118.bottomToBottom = r111.getId();
        r118.rightToLeft = r109.getId();
        r118.leftToRight = r113.getId();
        ((ViewGroup.MarginLayoutParams) r118).rightMargin = b0.c(3);
        ((ViewGroup.MarginLayoutParams) r118).leftMargin = b0.c(6);
        b0.e(this);
        addView(r104, r118);
        ConstraintLayout.LayoutParams r119 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r119.topToTop = r111.getId();
        r119.bottomToBottom = r111.getId();
        r119.rightToLeft = r105.getId();
        ((ViewGroup.MarginLayoutParams) r119).rightMargin = b0.c(3);
        r119.leftToRight = r113.getId();
        ((ViewGroup.MarginLayoutParams) r119).leftMargin = b0.c(4);
        b0.e(this);
        addView(r103, r119);
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(-2, -2);
        r120.topToTop = r111.getId();
        r120.bottomToBottom = r111.getId();
        r120.rightToLeft = r103.getId();
        r120.leftToRight = r102.getId();
        ((ViewGroup.MarginLayoutParams) r120).leftMargin = b0.c(4);
        addView(r113, r120);
        ConstraintLayout.LayoutParams r121 = new ConstraintLayout.LayoutParams(0, -2);
        r121.leftToRight = r111.getId();
        r121.topToTop = r111.getId();
        r121.bottomToBottom = r111.getId();
        r121.rightToLeft = r113.getId();
        addView(r102, r121);
        TextView r122 = getRecReasonView();
        ConstraintLayout.LayoutParams r123 = new ConstraintLayout.LayoutParams(-2, -2);
        r123.topToTop = r111.getId();
        r123.bottomToBottom = r111.getId();
        r123.rightToRight = 0;
        addView(r122, r123);
    }

    public static Pair S5(String r100) {
        if (r100 == null) goto L6;
        String r101 = r100.substring(1, 3);
        return new Pair(Integer.valueOf(ColorProtector.parseColor("#" + r100.substring(3))), Float.valueOf(CastIntegerProtector.parseInt(r101, CharsKt.checkRadix(16)) / 255.0f));
    L6:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final void setHotIconViewColorAndAlpha(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == false) goto L19;
    L11:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return;
    L7:
        if (r100.length() != 9) goto L9;
        Pair r101 = S5(r100);     // Catch: Exception -> L11
        this.f177438j.setColorFilter(((Number) r101.getFirst()).intValue());     // Catch: Exception -> L11
        this.f177438j.setAlpha(((Number) r101.getSecond()).floatValue());     // Catch: Exception -> L11
    L14:
        return;
    L9:
        this.f177438j.setColorFilter(Color.parseColor(r100));     // Catch: Exception -> L11
        this.f177438j.setAlpha(1.0f);     // Catch: Exception -> L11
        goto L14
    }

    public final void V5(boolean r100) {
        if (r100 == false) goto L10;
        ViewGroup.LayoutParams r101 = this.f177443o.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == true) goto L6;
        r101 = null;
    L6:
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        if (r102 == null) goto L9;
        r102.rightToLeft = this.f177438j.getId();
    L9:
        b0.e(this.f177439k);
        b0.e(this.f177441m);
        this.f177438j.setVisibility(0);
        this.f177440l.setVisibility(0);
        return;
    L10:
        this.f177438j.setVisibility(8);
        this.f177440l.setVisibility(8);
    }

    public final void Y5(boolean r100) {
        if (r100 == false) goto L10;
        b0.n(this.f177439k);
        b0.n(this.f177441m);
        ViewGroup.LayoutParams r101 = this.f177443o.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == true) goto L6;
        r101 = null;
    L6:
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        if (r102 == null) goto L9;
        r102.rightToLeft = this.f177439k.getId();
    L9:
        b0.e(this.f177438j);
        b0.e(this.f177440l);
        return;
    L10:
        b0.e(this.f177439k);
        b0.e(this.f177441m);
    }

    public final void setContainerColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "themeColor");
        this.f177442n.setRewardLayoutBackground(r100);
    }

    public final void setViewScaleSize(float r110) {
        this.f177433e = r110;
        SimpleDraweeView r100 = this.f177435g;
        CommonModel$ModuleDesc r101 = this.f177429a;
        if (r101 == null) goto L5;
        CommonModel$LayoutStyle r102 = r101.getLayoutStyle();
    L6:
        ToolsKt.A(r100, r110, r102, Integer.valueOf(b0.c(16)), Integer.valueOf(b0.c(16)), null, null, Integer.valueOf(b0.c(4)), null, false, null, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        TextView r103 = this.f177436h;
        CommonModel$ModuleDesc r104 = this.f177429a;
        if (r104 == null) goto L12;
        CommonModel$CusTextStyle r105 = r104.getTextStyle();
        if (r105 == null) goto L12;
        Number r106 = r105.getFontSize();
        if (r106 == null) goto L12;
    L13:
        r103.setTextSize(1, r106.intValue() * r110);
        SimpleDraweeView r107 = this.f177438j;
        CommonModel$ModuleDesc r108 = this.f177430b;
        if (r108 == null) goto L16;
        CommonModel$LayoutStyle r109 = r108.getLayoutStyle();
    L17:
        ToolsKt.A(r107, r110, r109, Integer.valueOf(b0.c(12)), Integer.valueOf(b0.c(12)), Integer.valueOf(b0.c(4)), null, Integer.valueOf(b0.c(3)), null, false, null, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW);
        TextView r111 = this.f177440l;
        CommonModel$ModuleDesc r112 = this.f177430b;
        if (r112 == null) goto L24;
        CommonModel$CusTextStyle r113 = r112.getTextStyle();
        if (r113 == null) goto L24;
        Integer r114 = r113.getFontSize();
        if (r114 == null) goto L24;
        int r115 = r114.intValue();
    L25:
        r111.setTextSize(1, r115 * r110);
        ReturnRewardBtn r116 = this.f177442n;
        CommonModel$ModuleDesc r117 = this.f177431c;
        if (r117 == null) goto L28;
        CommonModel$LayoutStyle r118 = r117.getLayoutStyle();
    L29:
        ToolsKt.A(r116, r110, r118, null, Integer.valueOf(b0.c(26)), null, Integer.valueOf(b0.c(8)), null, null, false, null, 980);
        HotTextContainerView r119 = this.f177441m;
        r119.f177466a.setTextSize(1, 10 * r110);
        r119.f177467b.setTextSize(1, 8 * r110);
        r119.f177468c.setTextSize(1, 11 * r110);
        CommonModel$ModuleDesc r120 = this.f177431c;
        if (r120 == null) goto L36;
        CommonModel$LayoutStyle r121 = r120.getLayoutStyle();
        if (r121 == null) goto L36;
        Double r122 = r121.getRadius();
        if (r122 == null) goto L36;
        float r123 = (float) r122.doubleValue();
    L37:
        this.f177442n.setRadius(b0.c(Float.valueOf(r123)) * r110);
        this.f177442n.setViewScale(r110);
        return;
    L36:
        r123 = 4.0f;
        goto L37
    L28:
        r118 = null;
    L24:
        r115 = 11;
        goto L25
    L16:
        r109 = null;
    L12:
        r106 = Float.valueOf(getNameSize());
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public BottomInfoView(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.f177433e = 1.0f;
        this.f177434f = LazyKt.lazy(BottomInfoView$nameSize$2.INSTANCE);
        SimpleDraweeView r112 = new SimpleDraweeView(getContext());
        r112.setId(ViewCompat.generateViewId());
        RoundingParams r113 = RoundingParams.fromCornersRadius(5.0f);
        r113.setRoundAsCircle(true);
        r112.getHierarchy().setRoundingParams(r113);
        r112.getHierarchy().setOverlayImage(new ColorDrawable(ColorProtector.parseColor("#0D000000")));
        Unit r114 = Unit.INSTANCE;
        this.f177435g = r112;
        TextView r115 = new TextView(getContext());
        r115.setId(ViewCompat.generateViewId());
        ToolsKt.b(r115);
        r115.setIncludeFontPadding(false);
        r115.setMaxLines(1);
        r115.setTextSize(1, getNameSize());
        r115.setGravity(GravityCompat.START);
        this.f177436h = r115;
        this.f177437i = LazyKt.lazy(new BottomInfoView$recReasonView$2(this));
        SimpleDraweeView r100 = new SimpleDraweeView(getContext());
        r100.setId(ViewCompat.generateViewId());
        r100.setImageResource(R.drawable.shopping_homepage_live_hot_6x);
        this.f177438j = r100;
        SimpleDraweeView r101 = new SimpleDraweeView(getContext());
        r101.setId(ViewCompat.generateViewId());
        this.f177439k = r101;
        TextView r102 = new TextView(getContext());
        r102.setId(ViewCompat.generateViewId());
        r102.setTextSize(1, 11.0f);
        this.f177440l = r102;
        Context r103 = getContext();
        AttributeSet r104 = null;
        int r105 = 6;
        HotTextContainerView r106 = new HotTextContainerView(r103, r104, r105, 0);
        r106.setId(ViewCompat.generateViewId());
        this.f177441m = r106;
        ReturnRewardBtn r107 = new ReturnRewardBtn(getContext(), null);
        r107.setId(ViewCompat.generateViewId());
        r107.setRadius(UIUtils.dip2Px(r107.getContext(), 4.0f));
        this.f177442n = r107;
        AdTagView r108 = new AdTagView(getContext());
        r108.setId(ViewCompat.generateViewId());
        r108.setVisibility(8);
        this.f177443o = r108;
        ConstraintLayout.LayoutParams r116 = new ConstraintLayout.LayoutParams(0, b0.c(26));
        r116.leftToLeft = 0;
        r116.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r116).topMargin = b0.c(8);
        r116.topToBottom = r112.getId();
        addView(r107, r116);
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(b0.c(16), b0.c(16));
        r109.leftToLeft = 0;
        r109.topToTop = 0;
        r109.rightToLeft = r115.getId();
        ((ViewGroup.MarginLayoutParams) r109).rightMargin = b0.c(4);
        addView(r112, r109);
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(-2, -2);
        r117.topToTop = r112.getId();
        r117.bottomToBottom = r112.getId();
        r117.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r117).topMargin = b0.c(1);
        addView(r106, r117);
        ConstraintLayout.LayoutParams r118 = new ConstraintLayout.LayoutParams(-2, -2);
        r118.topToTop = r112.getId();
        r118.bottomToBottom = r112.getId();
        r118.rightToRight = 0;
        addView(r102, r118);
        ConstraintLayout.LayoutParams r119 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r119.topToTop = r112.getId();
        r119.bottomToBottom = r112.getId();
        r119.rightToLeft = r106.getId();
        r119.leftToRight = r108.getId();
        ((ViewGroup.MarginLayoutParams) r119).rightMargin = b0.c(3);
        ((ViewGroup.MarginLayoutParams) r119).leftMargin = b0.c(6);
        b0.e(this);
        addView(r101, r119);
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r120.topToTop = r112.getId();
        r120.bottomToBottom = r112.getId();
        r120.rightToLeft = r102.getId();
        ((ViewGroup.MarginLayoutParams) r120).rightMargin = b0.c(3);
        r120.leftToRight = r108.getId();
        ((ViewGroup.MarginLayoutParams) r120).leftMargin = b0.c(4);
        b0.e(this);
        addView(r100, r120);
        ConstraintLayout.LayoutParams r121 = new ConstraintLayout.LayoutParams(-2, -2);
        r121.topToTop = r112.getId();
        r121.bottomToBottom = r112.getId();
        r121.rightToLeft = r100.getId();
        r121.leftToRight = r115.getId();
        ((ViewGroup.MarginLayoutParams) r121).leftMargin = b0.c(4);
        addView(r108, r121);
        ConstraintLayout.LayoutParams r122 = new ConstraintLayout.LayoutParams(0, -2);
        r122.leftToRight = r112.getId();
        r122.topToTop = r112.getId();
        r122.bottomToBottom = r112.getId();
        r122.rightToLeft = r108.getId();
        addView(r115, r122);
        TextView r123 = getRecReasonView();
        ConstraintLayout.LayoutParams r124 = new ConstraintLayout.LayoutParams(-2, -2);
        r124.topToTop = r112.getId();
        r124.bottomToBottom = r112.getId();
        r124.rightToRight = 0;
        addView(r123, r124);
    }

    public BottomInfoView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f177433e = 1.0f;
        this.f177434f = LazyKt.lazy(BottomInfoView$nameSize$2.INSTANCE);
        SimpleDraweeView r113 = new SimpleDraweeView(getContext());
        r113.setId(ViewCompat.generateViewId());
        RoundingParams r114 = RoundingParams.fromCornersRadius(5.0f);
        r114.setRoundAsCircle(true);
        r113.getHierarchy().setRoundingParams(r114);
        r113.getHierarchy().setOverlayImage(new ColorDrawable(ColorProtector.parseColor("#0D000000")));
        Unit r115 = Unit.INSTANCE;
        this.f177435g = r113;
        TextView r116 = new TextView(getContext());
        r116.setId(ViewCompat.generateViewId());
        ToolsKt.b(r116);
        r116.setIncludeFontPadding(false);
        r116.setMaxLines(1);
        r116.setTextSize(1, getNameSize());
        r116.setGravity(GravityCompat.START);
        this.f177436h = r116;
        this.f177437i = LazyKt.lazy(new BottomInfoView$recReasonView$2(this));
        SimpleDraweeView r100 = new SimpleDraweeView(getContext());
        r100.setId(ViewCompat.generateViewId());
        r100.setImageResource(R.drawable.shopping_homepage_live_hot_6x);
        this.f177438j = r100;
        SimpleDraweeView r101 = new SimpleDraweeView(getContext());
        r101.setId(ViewCompat.generateViewId());
        this.f177439k = r101;
        TextView r102 = new TextView(getContext());
        r102.setId(ViewCompat.generateViewId());
        r102.setTextSize(1, 11.0f);
        this.f177440l = r102;
        Context r103 = getContext();
        AttributeSet r104 = null;
        int r105 = 6;
        HotTextContainerView r106 = new HotTextContainerView(r103, r104, r105, 0);
        r106.setId(ViewCompat.generateViewId());
        this.f177441m = r106;
        ReturnRewardBtn r107 = new ReturnRewardBtn(getContext(), null);
        r107.setId(ViewCompat.generateViewId());
        r107.setRadius(UIUtils.dip2Px(r107.getContext(), 4.0f));
        this.f177442n = r107;
        AdTagView r108 = new AdTagView(getContext());
        r108.setId(ViewCompat.generateViewId());
        r108.setVisibility(8);
        this.f177443o = r108;
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(0, b0.c(26));
        r109.leftToLeft = 0;
        r109.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r109).topMargin = b0.c(8);
        r109.topToBottom = r113.getId();
        addView(r107, r109);
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(b0.c(16), b0.c(16));
        r117.leftToLeft = 0;
        r117.topToTop = 0;
        r117.rightToLeft = r116.getId();
        ((ViewGroup.MarginLayoutParams) r117).rightMargin = b0.c(4);
        addView(r113, r117);
        ConstraintLayout.LayoutParams r118 = new ConstraintLayout.LayoutParams(-2, -2);
        r118.topToTop = r113.getId();
        r118.bottomToBottom = r113.getId();
        r118.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r118).topMargin = b0.c(1);
        addView(r106, r118);
        ConstraintLayout.LayoutParams r119 = new ConstraintLayout.LayoutParams(-2, -2);
        r119.topToTop = r113.getId();
        r119.bottomToBottom = r113.getId();
        r119.rightToRight = 0;
        addView(r102, r119);
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r120.topToTop = r113.getId();
        r120.bottomToBottom = r113.getId();
        r120.rightToLeft = r106.getId();
        r120.leftToRight = r108.getId();
        ((ViewGroup.MarginLayoutParams) r120).rightMargin = b0.c(3);
        ((ViewGroup.MarginLayoutParams) r120).leftMargin = b0.c(6);
        b0.e(this);
        addView(r101, r120);
        ConstraintLayout.LayoutParams r121 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r121.topToTop = r113.getId();
        r121.bottomToBottom = r113.getId();
        r121.rightToLeft = r102.getId();
        ((ViewGroup.MarginLayoutParams) r121).rightMargin = b0.c(3);
        r121.leftToRight = r108.getId();
        ((ViewGroup.MarginLayoutParams) r121).leftMargin = b0.c(4);
        b0.e(this);
        addView(r100, r121);
        ConstraintLayout.LayoutParams r122 = new ConstraintLayout.LayoutParams(-2, -2);
        r122.topToTop = r113.getId();
        r122.bottomToBottom = r113.getId();
        r122.rightToLeft = r100.getId();
        r122.leftToRight = r116.getId();
        ((ViewGroup.MarginLayoutParams) r122).leftMargin = b0.c(4);
        addView(r108, r122);
        ConstraintLayout.LayoutParams r123 = new ConstraintLayout.LayoutParams(0, -2);
        r123.leftToRight = r113.getId();
        r123.topToTop = r113.getId();
        r123.bottomToBottom = r113.getId();
        r123.rightToLeft = r108.getId();
        addView(r116, r123);
        TextView r124 = getRecReasonView();
        ConstraintLayout.LayoutParams r125 = new ConstraintLayout.LayoutParams(-2, -2);
        r125.topToTop = r113.getId();
        r125.bottomToBottom = r113.getId();
        r125.rightToRight = 0;
        addView(r124, r125);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void U5(CommonModel$Product r410, CommonModel$User r411, final LiveCardModel.Live r412, boolean r413, Companion.Experiment r510, Companion.ElementStyle r511, a r512) {
        Intrinsics.checkNotNullParameter(r410, "product");
        Intrinsics.checkNotNullParameter(r411, "user");
        Intrinsics.checkNotNullParameter(r510, "experiment");
        Intrinsics.checkNotNullParameter(r511, "elementStyle");
        R5();
        this.f177429a = r511.getAvatarDesc();
        this.f177430b = r511.getHotDesc();
        this.f177431c = r511.getReturnRewardDesc();
        this.f177432d = r511.getCoinIconLayout();
        this.f177435g.setImageURI(r411.getAvatar());
        this.f177436h.setText(r411.getNickname());
        if (r410.isReturnRewardContainerVisible() == false) goto L43;
        this.f177442n.setVisibility(0);
        ReturnRewardBtn r100 = this.f177442n;
        String r101 = r410.getRewardText();
        CommonModel$ModuleDesc r102 = this.f177431c;
        if (r102 == null) goto L7;
        CommonModel$CusTextStyle r103 = r102.getTextStyle();
    L8:
        CommonModel$LayoutStyle r110 = this.f177432d;
        CommonData.MarketingData r104 = r410.getMarketingData();
        if (r104 == null) goto L11;
        String r105 = r104.getReturnRewardIcon();
    L12:
        int r111 = r510.getCoinLabelStyle();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "rewardDes");
        if (h.a(r105) == false) goto L15;
        b0.n(r100.f177502e);
        r100.f177502e.setImageURI(r105);
    L16:
        ProductTextView r106 = r100.f177500c;
        if (r103 == null) goto L20;
        String r112 = r103.getColor();
        if (r112 == null) goto L20;
    L21:
        String r210 = r112;
        if (r103 == null) goto L26;
        Integer r113 = r103.getFontWeight();
        if (r113 == null) goto L26;
        int r114 = r113.intValue();
    L27:
        Integer r211 = Integer.valueOf(r114);
        if (r111 <= 0) goto L30;
        String r212 = "DouyinNumberABC-Medium";
    L31:
        r106.y(new TextBaseUIParams(r101, new ProductStyle(null, null, r210, null, r211, null, r212, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, 2031531, null)));
        if (r103 != null) goto L232;
    L42:
        r100.f177504g = r103;
        r100.f177505h = r110;
        r100.setViewScale(r100.f177503f);
        int r107 = 8;
    L44:
        if (r413 == false) goto L46;
        this.f177443o.setVisibility(0);
    L49:
        ?? r108 = 1;
    L50:
        IHybridHostService r109 = com.bytedance.android.ec.hybrid.a.h();
        if (r109 == null) goto L57;
        i r115 = r109.getIHybridHostAppInfo();
        if (r115 == null) goto L57;
        if (r115.isNightMode() != r108) goto L57;
        boolean r116 = true;
    L58:
        CommonModel$ModuleDesc r117 = r511.getAvatarDesc();
        if (r117 == null) goto L70;
        CommonModel$CusTextStyle r118 = r117.getTextStyle();
        if (r118 == null) goto L70;
        if (r510.getEnableDarkModel() == false) goto L66;
        if (r116 == false) goto L66;
        String r119 = r118.getColorDark();
    L68:
        if (h.a(r119) == false) goto L70;
        this.f177436h.setTextColor(ColorProtector.parseColor(r119));
    L66:
        r119 = r118.getColor();
    L70:
        Function0<Result<? extends Unit>> r120 = new BottomInfoView$handleHot$useNewHotIcon$1(this, r412);
        if (r510.getEnlargeCover() == false) goto L73;
        String r121 = CustomHeaderConfig.COLOR_LIGHT;
    L74:
        int r122 = h.f244547a;
        if (r412 == null) goto L77;
        String r123 = r412.getNewHotDesc();
    L79:
        if (h.a(r123) == false) goto L91;
        if (r412 == null) goto L82;
        String r124 = r412.getNewHotIcon();
    L84:
        if (h.a(r124) == false) goto L91;
        Y5(r108);
        if (r412 == null) goto L90;
        String r125 = r412.getNewHotDesc();
        if (r125 == null) goto L90;
        HotTextContainerView r126 = this.f177441m;
        r126.getClass();
        Intrinsics.checkNotNullParameter(r125, "t");
        r126.f177468c.setText(r125);
        this.f177441m.a(r121);
    L90:
        r120.invoke();
        String r127 = null;
    L153:
        if (r512 == null) goto L189;
        String r128 = r512.f177506a;
        String r129 = r512.f177507b;
        if (r128 != null) goto L158;
    L161:
        boolean r130 = true;
    L162:
        if (r130 == true) goto L188;
        if (r129 != null) goto L165;
    L168:
        boolean r131 = true;
    L169:
        if (r131 == true) goto L188;
        CommonModel$CommonColorStyle r132 = r511.getHotIcon();
        if (r132 == null) goto L181;
        String r133 = r132.getColorLight();
        if (r133 == null) goto L181;
        if (r133.length() <= 0) goto L178;
        boolean r134 = true;
    L179:
        if (r134 == false) goto L181;
    L182:
        this.f177438j.setImageURI(UriProtector.parse(r129));
        this.f177440l.setText(r128);
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L185
        this.f177440l.setTextColor(Color.parseColor(r133));     // Catch: Throwable -> L185
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L185
    L187:
        b0.n(this.f177438j);
        b0.n(this.f177440l);
    L185:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L187
    L178:
        r134 = false;
    L181:
        r133 = CustomHeaderConfig.COLOR_LIGHT;
        goto L182
    L165:
        if (r129.length() == 0) goto L168;
        r131 = false;
    L188:
        b0.e(this.f177438j);
        b0.e(this.f177440l);
        goto L189
    L158:
        if (r128.length() == 0) goto L161;
        r130 = false;
    L189:
        int r137 = h.f244547a;
        if (r412 == null) goto L192;
        String r138 = r412.getRecReason();
    L194:
        if (h.a(r138) == false) goto L212;
        this.f177438j.setVisibility(8);
        this.f177440l.setVisibility(8);
        ViewGroup.LayoutParams r139 = getRecReasonView().getLayoutParams();
        if (r139 == null) goto L211;
        ConstraintLayout.LayoutParams r140 = (ConstraintLayout.LayoutParams) r139;
        ViewGroup.LayoutParams r141 = this.f177436h.getLayoutParams();
        if (r141 == null) goto L209;
        ConstraintLayout.LayoutParams r142 = (ConstraintLayout.LayoutParams) r141;
        r140.leftToRight = this.f177436h.getId();
        r142.rightToLeft = getRecReasonView().getId();
        if (r510.getEnlargeCover() == false) goto L202;
        getRecReasonView().setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        ((ViewGroup.MarginLayoutParams) r140).leftMargin = b0.c(4);
    L203:
        this.f177436h.setLayoutParams(r142);
        TextView r143 = getRecReasonView();
        if (r412 == null) goto L206;
        String r144 = r412.getRecReason();
    L207:
        r143.setText(r144);
        getRecReasonView().setVisibility(0);
    L215:
        ToolsKt.A(this.f177435g, 0.0f, null, null, null, null, 0, null, null, false, null, 991);
        if (r510.getEnlargeCover() == false) goto L222;
        GenericDraweeHierarchy r145 = this.f177435g.getHierarchy();
        if (r145 == null) goto L227;
        RoundingParams r146 = r145.getRoundingParams();
        if (r146 == null) goto L227;
        r146.setBorder(ColorProtector.parseColor("#33FFFFFF"), 2.0f);
    L227:
        setViewScaleSize(this.f177433e);
        return;
    L222:
        GenericDraweeHierarchy r147 = this.f177435g.getHierarchy();
        if (r147 == null) goto L227;
        RoundingParams r148 = r147.getRoundingParams();
        if (r148 == null) goto L227;
        r148.setBorder(0, 0.0f);
        goto L227
    L206:
        r144 = r127;
        goto L207
    L202:
        getRecReasonView().setTextColor(ColorProtector.parseColor("#A17254"));
        ((ViewGroup.MarginLayoutParams) r140).leftMargin = b0.c(8);
        goto L203
    L209:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L211:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L212:
        ViewGroup.LayoutParams r149 = this.f177436h.getLayoutParams();
        if (r149 == null) goto L230;
        ConstraintLayout.LayoutParams r150 = (ConstraintLayout.LayoutParams) r149;
        r150.rightToLeft = this.f177443o.getId();
        this.f177436h.setLayoutParams(r150);
        getRecReasonView().setVisibility(8);
        goto L215
    L230:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L192:
        r138 = r127;
        goto L194
    L82:
        r124 = null;
    L91:
        if (r412 == null) goto L93;
        String r151 = r412.getHotNum();
    L94:
        if (r151 == null) goto L96;
        Integer r152 = StringsKt.toIntOrNull(r151);
    L97:
        if (r152 != null) goto L99;
    L108:
        r127 = null;
        String r153 = "";
    L110:
        if (r153.length() != 0) goto L112;
        boolean r154 = true;
    L113:
        if (r154 == false) goto L115;
        V5(false);
        Y5(false);
        goto L153
    L115:
        if (r412 == null) goto L117;
        String r155 = r412.getNewHotIcon();
    L119:
        if (h.a(r155) == false) goto L129;
        if (r412 == null) goto L130;
        String r156 = r412.getNewHotIcon();
        if (r156 == null) goto L130;
        if (r156.length() <= 0) goto L126;
        boolean r157 = true;
    L127:
        if (r157 == false) goto L130;
        this.f177438j.setImageURI(UriProtector.parse(r156));
        goto L130
    L126:
        r157 = false;
    L130:
        V5(r108);
        this.f177440l.setText(r153);
        CommonModel$ModuleDesc r158 = r511.getHotDesc();
        if (r158 == null) goto L140;
        CommonModel$CusTextStyle r159 = r158.getTextStyle();
        if (r159 == null) goto L140;
        if (r510.getEnableDarkModel() == false) goto L138;
        if (r116 == false) goto L138;
        String r160 = r159.getColorDark();
    L139:
        ToolsKt.w(this.f177440l, r160);
    L138:
        r160 = r159.getColor();
    L140:
        CommonModel$CommonColorStyle r161 = r511.getHotIcon();
        if (r161 == null) goto L151;
        if (r510.getEnableDarkModel() == false) goto L146;
        if (r116 == false) goto L146;
        String r162 = r161.getColorDark();
    L148:
        if (h.a(r162) == false) goto L151;
        setHotIconViewColorAndAlpha(r162);
    L146:
        r162 = r161.getColorLight();
    L151:
        if (r510.getShowPeopleNewIcon() == false) goto L153;
        this.f177438j.setImageResource(R.drawable.shopping_homepage_live_people_icon);
        goto L153
    L129:
        this.f177438j.setImageResource(R.drawable.shopping_homepage_live_hot_6x);
        goto L130
    L117:
        r155 = r127;
        goto L119
    L112:
        r154 = false;
        goto L113
    L99:
        if (r152.intValue() == 0) goto L108;
        if (r152.intValue() >= 10000) goto L104;
        r153 = String.valueOf(r152.intValue());
        r127 = null;
        goto L110
    L104:
        DecimalFormat r163 = new DecimalFormat();
        r163.setMaximumFractionDigits(r108);
        r163.setGroupingSize(0);
        r163.setRoundingMode(RoundingMode.FLOOR);
        String r164 = r163.format(((double) r152.intValue()) / 10000.0d);
        r127 = null;
        if (StringsKt.endsWith$default(r164, ".0", false, 2, null) == false) goto L107;
        r164 = r164.substring(0, r164.length() - 2);
    L107:
        r153 = r164 + 19975;
        goto L110
    L96:
        r152 = null;
        goto L97
    L93:
        r151 = null;
        goto L94
    L77:
        r123 = null;
        goto L79
    L73:
        r121 = "#73161823";
    L57:
        r116 = false;
        goto L58
    L46:
        this.f177443o.setVisibility(r107);
        if (r412 != null) goto L49;
        r108 = 1;
        ToolsKt.A(this.f177436h, 0.0f, null, null, null, null, null, 0, null, false, null, 959);
        goto L50
    L232:
        String r165 = r103.getBackgroundColor();     // Catch: Exception -> L40
        if (r165 != null) goto L36;
    L231:
        goto L42
    L36:
        if (h.a(r103.getBackgroundColorTo()) == false) goto L38;
        b0.j(r100.f177501d, new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(r165), Color.parseColor(r103.getBackgroundColorTo())}));     // Catch: Exception -> L40
        goto L231
    L38:
        r100.f177501d.setBackgroundColor(Color.parseColor(r165));     // Catch: Exception -> L40
    L40:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        goto L42
    L30:
        r212 = null;
    L26:
        r114 = 400;
    L20:
        r112 = "#FFFFFFFF";
        goto L21
    L15:
        b0.e(r100.f177502e);
        goto L16
    L11:
        r105 = null;
        goto L12
    L7:
        r103 = null;
        goto L8
    L43:
        r107 = 8;
        this.f177442n.setVisibility(8);
        goto L44
    }
}
