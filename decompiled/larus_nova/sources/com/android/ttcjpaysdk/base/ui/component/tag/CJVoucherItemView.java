package com.android.ttcjpaysdk.base.ui.component.tag;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.bytedance.caijing.sdk.infra.base.api.fresco.FrescoGifService;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002#$B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nJ\u0017\u0010\u001c\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherItemView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "animFlag", "voucherMsgInfo", "Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherItemView$CJVoucherItemInfo;", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherItemView$CJVoucherItemInfo;)V", "getAnimFlag", "()I", "flLeft", "Landroid/widget/FrameLayout;", "ivLeft", "Landroid/widget/ImageView;", "tvLeft", "Landroid/widget/TextView;", "tvRight", "getVoucherMsgInfo", "()Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherItemView$CJVoucherItemInfo;", "setVoucherMsgInfo", "(Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherItemView$CJVoucherItemInfo;)V", "bindData", "", "updateVoucherMsgInfo", "initLeftImageData", "defaultLeftImg", "(Ljava/lang/Integer;)V", "loadImage", "view", "imageUrl", "", "CJVoucherItemInfo", "TagShowType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJVoucherItemView extends LinearLayout {
    private final int animFlag;
    private FrameLayout flLeft;
    private ImageView ivLeft;
    private TextView tvLeft;
    private TextView tvRight;
    private CJVoucherItemInfo voucherMsgInfo;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherItemView$CJVoucherItemInfo;", "", "left_msg", "", "left_img", "Landroid/graphics/Bitmap;", "left_img_url", "right_msg", "tag_show_type", "(Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLeft_img", "()Landroid/graphics/Bitmap;", "getLeft_img_url", "()Ljava/lang/String;", "getLeft_msg", "getRight_msg", "getTag_show_type", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJVoucherItemInfo {
        private final Bitmap left_img;
        private final String left_img_url;
        private final String left_msg;
        private final String right_msg;
        private final String tag_show_type;

        public CJVoucherItemInfo() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ CJVoucherItemInfo copy$default(CJVoucherItemInfo r100, String r101, Bitmap r102, String r103, String r104, String r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.left_msg;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.left_img;
        L8:
            Bitmap r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.left_img_url;
        L11:
            String r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.right_msg;
        L14:
            String r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.tag_show_type;
        L17:
            String r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final String component1() {
            return this.left_msg;
        }

        public final Bitmap component2() {
            return this.left_img;
        }

        public final String component3() {
            return this.left_img_url;
        }

        public final String component4() {
            return this.right_msg;
        }

        public final String component5() {
            return this.tag_show_type;
        }

        public final CJVoucherItemInfo copy(String r100, Bitmap r101, String r110, String r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, "left_msg");
            Intrinsics.checkNotNullParameter(r110, "left_img_url");
            Intrinsics.checkNotNullParameter(r111, "right_msg");
            Intrinsics.checkNotNullParameter(r112, "tag_show_type");
            return new CJVoucherItemInfo(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CJVoucherItemInfo) == true) goto L8;
            return false;
        L8:
            CJVoucherItemInfo r101 = (CJVoucherItemInfo) r100;
            if (Intrinsics.areEqual(this.left_msg, r101.left_msg) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.left_img, r101.left_img) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.left_img_url, r101.left_img_url) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.right_msg, r101.right_msg) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.tag_show_type, r101.tag_show_type) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r100 = this.left_msg.hashCode() * 31;
            Bitmap r101 = this.left_img;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((((r100 + r102) * 31) + this.left_img_url.hashCode()) * 31) + this.right_msg.hashCode()) * 31) + this.tag_show_type.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "CJVoucherItemInfo(left_msg=" + this.left_msg + ", left_img=" + this.left_img + ", left_img_url=" + this.left_img_url + ", right_msg=" + this.right_msg + ", tag_show_type=" + this.tag_show_type + ')';
        }

        public final Bitmap getLeft_img() {
            return this.left_img;
        }

        public final String getLeft_img_url() {
            return this.left_img_url;
        }

        public final String getLeft_msg() {
            return this.left_msg;
        }

        public final String getRight_msg() {
            return this.right_msg;
        }

        public final String getTag_show_type() {
            return this.tag_show_type;
        }

        public CJVoucherItemInfo(String r100, Bitmap r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "left_msg");
            Intrinsics.checkNotNullParameter(r102, "left_img_url");
            Intrinsics.checkNotNullParameter(r103, "right_msg");
            Intrinsics.checkNotNullParameter(r104, "tag_show_type");
            this.left_msg = r100;
            this.left_img = r101;
            this.left_img_url = r102;
            this.right_msg = r103;
            this.tag_show_type = r104;
        }

        public /* synthetic */ CJVoucherItemInfo(String r100, Bitmap r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L5;
            String r112 = "";
        L7:
            if ((r110 & 2) == 0) goto L9;
            r101 = null;
        L9:
            Bitmap r105 = r101;
            if ((r110 & 4) == 0) goto L12;
            String r106 = "";
        L14:
            if ((r110 & 8) == 0) goto L16;
            String r107 = "";
        L18:
            if ((r110 & 16) == 0) goto L20;
            String r113 = "";
        L21:
            this(r112, r105, r106, r107, r113);
            return;
        L20:
            r113 = r104;
            goto L21
        L16:
            r107 = r103;
            goto L18
        L12:
            r106 = r102;
            goto L14
        L5:
            r112 = r100;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherItemView$TagShowType;", "", "typeStr", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeStr", "()Ljava/lang/String;", "PLATFORM", "PLATFORM_ENHANCE", "CHANNEL", "PURE_MSG", "RETAIN_VOUCHER_PLATFORM", "RETAIN_VOUCHER_ENHANCE", CardAdapter.TEXT, "BRAND", "BRANDV2", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TagShowType extends Enum<TagShowType> {
        private static final /* synthetic */ TagShowType[] $VALUES = null;
        public static final TagShowType BRAND = null;
        public static final TagShowType BRANDV2 = null;
        public static final TagShowType CHANNEL = null;
        public static final TagShowType PLATFORM = null;
        public static final TagShowType PLATFORM_ENHANCE = null;
        public static final TagShowType PURE_MSG = null;
        public static final TagShowType RETAIN_VOUCHER_ENHANCE = null;
        public static final TagShowType RETAIN_VOUCHER_PLATFORM = null;
        public static final TagShowType TEXT = null;
        private final String typeStr;

        private static final /* synthetic */ TagShowType[] $values() {
            return new TagShowType[]{PLATFORM, PLATFORM_ENHANCE, CHANNEL, PURE_MSG, RETAIN_VOUCHER_PLATFORM, RETAIN_VOUCHER_ENHANCE, TEXT, BRAND, BRANDV2};
        }

        public static TagShowType valueOf(String r100) {
            return (TagShowType) a.a(TagShowType.class, r100);
        }

        public static TagShowType[] values() {
            return (TagShowType[]) $VALUES.clone();
        }

        static {
            PLATFORM = new TagShowType("PLATFORM", 0, "platform");
            PLATFORM_ENHANCE = new TagShowType("PLATFORM_ENHANCE", 1, "platform_enhance");
            CHANNEL = new TagShowType("CHANNEL", 2, "channel");
            PURE_MSG = new TagShowType("PURE_MSG", 3, "pure_msg");
            RETAIN_VOUCHER_PLATFORM = new TagShowType("RETAIN_VOUCHER_PLATFORM", 4, "retain_voucher_platform");
            RETAIN_VOUCHER_ENHANCE = new TagShowType("RETAIN_VOUCHER_ENHANCE", 5, "retain_voucher_enhance");
            TEXT = new TagShowType(CardAdapter.TEXT, 6, "text");
            BRAND = new TagShowType("BRAND", 7, "brand");
            BRANDV2 = new TagShowType("BRANDV2", 8, "brand_v2");
            $VALUES = $values();
        }

        public final String getTypeStr() {
            return this.typeStr;
        }

        private TagShowType(String r100, int r101, String r102) {
            super(r100, r101);
            this.typeStr = r102;
        }
    }

    public CJVoucherItemView(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r110, null, 0, 0, null, 30, null);
    }

    public CJVoucherItemView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r110, r111, 0, 0, null, 28, null);
    }

    public CJVoucherItemView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r110, r111, r112, 0, null, 24, null);
    }

    public CJVoucherItemView(Context r110, AttributeSet r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r110, r111, r112, r113, null, 16, null);
    }

    public final int getAnimFlag() {
        return this.animFlag;
    }

    public final CJVoucherItemInfo getVoucherMsgInfo() {
        return this.voucherMsgInfo;
    }

    public final void bindData(CJVoucherItemInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "updateVoucherMsgInfo");
        this.voucherMsgInfo = r100;
        String r101 = r100.getTag_show_type();
        if (Intrinsics.areEqual(r101, TagShowType.PLATFORM.getTypeStr()) == false) goto L21;
        FrameLayout r102 = this.flLeft;
        if (r102 == null) goto L7;
        r102.setBackgroundResource(R.drawable.cj_ic_voucher_left);
    L7:
        TextView r103 = this.tvLeft;
        if (r103 == null) goto L10;
        CJPayViewExtensionsKt.viewGone(r103);
    L10:
        initLeftImageData(Integer.valueOf(R.drawable.cj_ic_voucher_platform_logo));
        TextView r104 = this.tvRight;
        if (r104 == null) goto L13;
        CJPayViewExtensionsKt.viewVisible(r104);
    L13:
        TextView r105 = this.tvRight;
        if (r105 == null) goto L16;
        r105.setBackgroundResource(R.drawable.cj_ic_voucher_right);
    L16:
        TextView r106 = this.tvRight;
        if (r106 == null) goto L197;
        r106.setText(r100.getRight_msg());
        return;
    L197:
        return;
    L21:
        if (Intrinsics.areEqual(r101, TagShowType.PLATFORM_ENHANCE.getTypeStr()) == false) goto L42;
        FrameLayout r107 = this.flLeft;
        if (r107 == null) goto L25;
        r107.setBackgroundResource(R.drawable.cj_ic_voucher_platform_enhance_left);
    L25:
        TextView r108 = this.tvLeft;
        if (r108 == null) goto L28;
        CJPayViewExtensionsKt.viewGone(r108);
    L28:
        initLeftImageData(Integer.valueOf(R.drawable.cj_ic_voucher_platform_enhance_logo));
        TextView r109 = this.tvRight;
        if (r109 == null) goto L31;
        CJPayViewExtensionsKt.viewVisible(r109);
    L31:
        TextView r110 = this.tvRight;
        if (r110 == null) goto L34;
        r110.setBackgroundResource(R.drawable.cj_ic_voucher_platform_enhance_right);
    L34:
        TextView r111 = this.tvRight;
        if (r111 == null) goto L37;
        r111.setTextColor(ContextCompat.getColor(getContext(), R.color.cj_pay_color_gold_F9CFAC));
    L37:
        TextView r112 = this.tvRight;
        if (r112 == null) goto L198;
        r112.setText(r100.getRight_msg());
        return;
    L198:
        return;
    L42:
        if (Intrinsics.areEqual(r101, TagShowType.RETAIN_VOUCHER_ENHANCE.getTypeStr()) == false) goto L63;
        FrameLayout r113 = this.flLeft;
        if (r113 == null) goto L46;
        r113.setBackgroundResource(R.drawable.cj_ic_voucher_platform_enhance_left);
    L46:
        TextView r114 = this.tvLeft;
        if (r114 == null) goto L49;
        CJPayViewExtensionsKt.viewGone(r114);
    L49:
        initLeftImageData(Integer.valueOf(R.drawable.cj_ic_voucher_exclusive_enhance_logo));
        TextView r115 = this.tvRight;
        if (r115 == null) goto L52;
        CJPayViewExtensionsKt.viewVisible(r115);
    L52:
        TextView r116 = this.tvRight;
        if (r116 == null) goto L55;
        r116.setBackgroundResource(R.drawable.cj_ic_voucher_platform_enhance_right);
    L55:
        TextView r117 = this.tvRight;
        if (r117 == null) goto L58;
        r117.setTextColor(ContextCompat.getColor(getContext(), R.color.cj_pay_color_gold_F9CFAC));
    L58:
        TextView r118 = this.tvRight;
        if (r118 == null) goto L199;
        r118.setText(r100.getRight_msg());
        return;
    L199:
        return;
    L63:
        if (Intrinsics.areEqual(r101, TagShowType.CHANNEL.getTypeStr()) == false) goto L65;
        boolean r119 = true;
    L66:
        if (r119 == false) goto L88;
        FrameLayout r120 = this.flLeft;
        if (r120 == null) goto L70;
        r120.setBackgroundResource(R.drawable.cj_ic_voucher_left);
    L70:
        ImageView r121 = this.ivLeft;
        if (r121 == null) goto L73;
        CJPayViewExtensionsKt.viewGone(r121);
    L73:
        TextView r122 = this.tvLeft;
        if (r122 == null) goto L77;
        r122.setText(r100.getLeft_msg());
    L77:
        TextView r123 = this.tvRight;
        if (r123 == null) goto L80;
        CJPayViewExtensionsKt.viewVisible(r123);
    L80:
        TextView r124 = this.tvRight;
        if (r124 == null) goto L83;
        r124.setBackgroundResource(R.drawable.cj_ic_voucher_right);
    L83:
        TextView r125 = this.tvRight;
        if (r125 == null) goto L200;
        r125.setText(r100.getRight_msg());
        return;
    L200:
        return;
    L88:
        if (Intrinsics.areEqual(r101, TagShowType.PURE_MSG.getTypeStr()) == false) goto L109;
        FrameLayout r126 = this.flLeft;
        if (r126 == null) goto L92;
        CJPayViewExtensionsKt.viewGone(r126);
    L92:
        ImageView r127 = this.ivLeft;
        if (r127 == null) goto L95;
        CJPayViewExtensionsKt.viewGone(r127);
    L95:
        TextView r128 = this.tvLeft;
        if (r128 == null) goto L98;
        CJPayViewExtensionsKt.viewGone(r128);
    L98:
        TextView r129 = this.tvRight;
        if (r129 == null) goto L101;
        CJPayViewExtensionsKt.setMargins$default(r129, 0, 0, 0, 0, 15, null);
    L101:
        TextView r130 = this.tvRight;
        if (r130 == null) goto L104;
        r130.setBackgroundResource(R.drawable.cj_pay_bg_r3_stroke_red_fe2c55);
    L104:
        TextView r131 = this.tvRight;
        if (r131 == null) goto L201;
        r131.setText(r100.getRight_msg());
        return;
    L201:
        return;
    L109:
        if (Intrinsics.areEqual(r101, TagShowType.RETAIN_VOUCHER_PLATFORM.getTypeStr()) == false) goto L126;
        FrameLayout r132 = this.flLeft;
        if (r132 == null) goto L113;
        r132.setBackgroundResource(R.drawable.cj_ic_voucher_left);
    L113:
        TextView r133 = this.tvLeft;
        if (r133 == null) goto L116;
        CJPayViewExtensionsKt.viewGone(r133);
    L116:
        initLeftImageData(Integer.valueOf(R.drawable.cj_ic_voucher_exclusive_logo));
        TextView r134 = this.tvRight;
        if (r134 == null) goto L119;
        CJPayViewExtensionsKt.viewVisible(r134);
    L119:
        TextView r135 = this.tvRight;
        if (r135 == null) goto L122;
        r135.setBackgroundResource(R.drawable.cj_ic_voucher_right);
    L122:
        TextView r136 = this.tvRight;
        if (r136 == null) goto L202;
        r136.setText(r100.getRight_msg());
        return;
    L202:
        return;
    L126:
        ViewGroup.LayoutParams r137 = null;
        if (Intrinsics.areEqual(r101, TagShowType.BRAND.getTypeStr()) == false) goto L158;
        FrameLayout r138 = this.flLeft;
        if (r138 == null) goto L131;
        r138.setBackgroundResource(R.drawable.cj_ic_voucher_left);
    L131:
        TextView r139 = this.tvLeft;
        if (r139 == null) goto L134;
        CJPayViewExtensionsKt.viewGone(r139);
    L134:
        initLeftImageData(Integer.valueOf(R.drawable.cj_ic_voucher_platform_enhance_logo));
        ImageView r140 = this.ivLeft;
        if (r140 == null) goto L137;
        ViewGroup.LayoutParams r141 = r140.getLayoutParams();
    L138:
        if (r141 == null) goto L141;
        r141.width = CJPayBasicExtensionKt.dp(55);
    L141:
        ImageView r142 = this.ivLeft;
        if (r142 == null) goto L144;
        r137 = r142.getLayoutParams();
    L144:
        if (r137 == null) goto L147;
        r137.height = CJPayBasicExtensionKt.dp(11);
    L147:
        TextView r143 = this.tvRight;
        if (r143 == null) goto L150;
        CJPayViewExtensionsKt.viewVisible(r143);
    L150:
        TextView r144 = this.tvRight;
        if (r144 == null) goto L153;
        r144.setBackgroundResource(R.drawable.cj_ic_voucher_right);
    L153:
        TextView r145 = this.tvRight;
        if (r145 == null) goto L203;
        r145.setText(r100.getRight_msg());
        return;
    L203:
        return;
    L137:
        r141 = null;
        goto L138
    L158:
        if (Intrinsics.areEqual(r101, TagShowType.BRANDV2.getTypeStr()) == false) goto L196;
        FrameLayout r146 = this.flLeft;
        if (r146 == null) goto L162;
        r146.setBackgroundResource(R.drawable.cj_ic_voucher_left);
    L162:
        TextView r147 = this.tvLeft;
        if (r147 == null) goto L165;
        CJPayViewExtensionsKt.viewGone(r147);
    L165:
        initLeftImageData(Integer.valueOf(R.drawable.cj_pay_bg_tag_icon_new_customer));
        ImageView r148 = this.ivLeft;
        if (r148 == null) goto L168;
        ViewGroup.LayoutParams r149 = r148.getLayoutParams();
    L169:
        if (r149 == null) goto L172;
        r149.width = CJPayBasicExtensionKt.dp(44);
    L172:
        ImageView r150 = this.ivLeft;
        if (r150 == null) goto L175;
        r137 = r150.getLayoutParams();
    L175:
        if (r137 == null) goto L178;
        r137.height = CJPayBasicExtensionKt.dp(11);
    L178:
        TextView r151 = this.tvRight;
        if (r151 == null) goto L181;
        CJPayViewExtensionsKt.viewVisible(r151);
    L181:
        TextView r152 = this.tvRight;
        if (r152 == null) goto L184;
        r152.setBackgroundResource(R.drawable.cj_ic_voucher_right);
    L184:
        TextView r153 = this.tvRight;
        if (r153 == null) goto L204;
        r153.setText(r100.getRight_msg());
        return;
    L204:
        return;
    L168:
        r149 = null;
        goto L169
    L196:
        return;
    L65:
        r119 = Intrinsics.areEqual(r101, TagShowType.TEXT.getTypeStr());
        goto L66
    }

    public final void initLeftImageData(Integer r100) {
        CJVoucherItemInfo r101 = this.voucherMsgInfo;
        String r102 = null;
        Bitmap r103 = null;
        if (r101 == null) goto L5;
        Bitmap r104 = r101.getLeft_img();
    L6:
        if (r104 == null) goto L13;
        ImageView r105 = this.ivLeft;
        if (r105 == null) goto L35;
        CJVoucherItemInfo r106 = this.voucherMsgInfo;
        if (r106 == null) goto L12;
        r103 = r106.getLeft_img();
    L12:
        r105.setImageBitmap(r103);
        return;
    L35:
        return;
    L13:
        CJVoucherItemInfo r107 = this.voucherMsgInfo;
        if (r107 == null) goto L16;
        String r108 = r107.getLeft_img_url();
    L17:
        if (r108 != null) goto L19;
    L22:
        boolean r109 = true;
    L23:
        if (r109 == true) goto L28;
        ImageView r110 = this.ivLeft;
        Intrinsics.checkNotNull(r110);
        CJVoucherItemInfo r111 = this.voucherMsgInfo;
        if (r111 == null) goto L27;
        r102 = r111.getLeft_img_url();
    L27:
        Intrinsics.checkNotNull(r102);
        loadImage(r110, r102);
        return;
    L28:
        if (r100 != null) goto L30;
        return;
    L30:
        if (r100.intValue() == 0) goto L39;
        ImageView r112 = this.ivLeft;
        if (r112 == null) goto L40;
        r112.setImageResource(r100.intValue());
        return;
    L40:
        return;
    L39:
        return;
    L19:
        if (r108.length() == 0) goto L22;
        r109 = false;
        goto L23
    L16:
        r108 = null;
        goto L17
    L5:
        r104 = null;
        goto L6
    }

    public final void setVoucherMsgInfo(CJVoucherItemInfo r100) {
        this.voucherMsgInfo = r100;
    }

    public final void loadImage(ImageView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "imageUrl");
        ve4.a.f554342a.getClass();
        FrescoGifService r102 = (FrescoGifService) ve4.a.a(FrescoGifService.class);
        if (r102 == null) goto L5;
        r102.loadImage(r100, r101, new AnonymousClass1());
    L5:
        CJPayViewExtensionsKt.viewVisible(r100);
    }

    public static /* synthetic */ void initLeftImageData$default(CJVoucherItemView r100, Integer r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.initLeftImageData(r101);
    }

    public CJVoucherItemView(Context r100, AttributeSet r101, int r102, int r103, CJVoucherItemInfo r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.animFlag = r103;
        this.voucherMsgInfo = r104;
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_layout_std_ui_voucher_item, this, true);
        this.flLeft = (FrameLayout) findViewById(R.id.cj_pay_layout_std_ui_voucher_left_container);
        this.tvLeft = (TextView) findViewById(R.id.cj_pay_layout_std_ui_voucher_left_text);
        this.ivLeft = (ImageView) findViewById(R.id.cj_pay_layout_std_ui_voucher_left_img);
        this.tvRight = (TextView) findViewById(R.id.cj_pay_layout_std_ui_voucher_right_text);
        CJVoucherItemInfo r105 = this.voucherMsgInfo;
        Intrinsics.checkNotNull(r105);
        bindData(r105);
    }

    public /* synthetic */ CJVoucherItemView(Context r100, AttributeSet r101, int r110, int r111, CJVoucherItemInfo r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        AttributeSet r102 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r113 & 8) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r113 & 16) == 0) goto L17;
        CJVoucherItemInfo r105 = null;
    L18:
        this(r100, r102, r103, r104, r105);
        return;
    L17:
        r105 = r112;
        goto L18
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
