package com.bytedance.android.ec.model.response;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\f\rB\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/model/response/RitTagUI;", "Ljava/io/Serializable;", "background", "Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIBackground;", "uiItems", "", "Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem;", "(Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIBackground;Ljava/util/List;)V", "getBackground", "()Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIBackground;", "getUiItems", "()Ljava/util/List;", "RitTagUIBackground", "RitTagUIItem", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class RitTagUI implements Serializable {

    @SerializedName("background")
    private final RitTagUIBackground background;

    @SerializedName("ui_items")
    private final List<RitTagUIItem> uiItems;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\r\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\r\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\r\u0010\u0017\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\r\u0010\u0018\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIBackground;", "Ljava/io/Serializable;", "bgColor", "", "borderColor", "height", "", "radius", "", GXTemplateKey.FLEXBOX_PADDING, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;[F[F)V", "getBgColor", "()Ljava/lang/String;", "getBorderColor", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRadius", "()[F", "bottomPadding", "", "()Ljava/lang/Float;", "leftPadding", "rightPadding", "topPadding", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class RitTagUIBackground implements Serializable {

        @SerializedName("bg_color")
        private final String bgColor;

        @SerializedName("border_color")
        private final String borderColor;

        @SerializedName("height")
        private final Integer height;

        @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
        private final float[] padding;

        @SerializedName("radius")
        private final float[] radius;

        public final Float bottomPadding() {
            float[] r100 = this.padding;
            if (r100 != null) goto L7;
            return null;
        L7:
            return ArraysKt.getOrNull(r100, 2);
        }

        public final Float leftPadding() {
            float[] r100 = this.padding;
            if (r100 != null) goto L7;
            return null;
        L7:
            return ArraysKt.getOrNull(r100, 3);
        }

        public final Float rightPadding() {
            float[] r100 = this.padding;
            if (r100 != null) goto L7;
            return null;
        L7:
            return ArraysKt.getOrNull(r100, 1);
        }

        public final Float topPadding() {
            float[] r100 = this.padding;
            if (r100 != null) goto L7;
            return null;
        L7:
            return ArraysKt.getOrNull(r100, 0);
        }

        public final String getBgColor() {
            return this.bgColor;
        }

        public final String getBorderColor() {
            return this.borderColor;
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final float[] getRadius() {
            return this.radius;
        }

        public RitTagUIBackground(String r100, String r101, Integer r102, float[] r103, float[] r104) {
            this.bgColor = r100;
            this.borderColor = r101;
            this.height = r102;
            this.radius = r103;
            this.padding = r104;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem;", "Ljava/io/Serializable;", "itemType", "Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$UIItemType;", "radius", "", "text", "Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$TextItem;", "split", "Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$SplitItem;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "(Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$UIItemType;[FLcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$TextItem;Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$SplitItem;Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getItemType", "()Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$UIItemType;", "getRadius", "()[F", "getSplit", "()Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$SplitItem;", "getText", "()Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$TextItem;", "FontWeight", "SplitItem", "TextItem", "UIItemType", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class RitTagUIItem implements Serializable {

        @SerializedName("image")
        private final ECUrlModel image;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
        private final UIItemType itemType;

        @SerializedName("radius")
        private final float[] radius;

        @SerializedName("splitor")
        private final SplitItem split;

        @SerializedName("text")
        private final TextItem text;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$FontWeight;", "", "REGULAR", "BOLD", "ec-model_release"}, k = 1, mv = {1, 4, 3})
        public static final enum FontWeight extends Enum<FontWeight> {

            @SerializedName("1")
            public static final FontWeight BOLD = null;

            @SerializedName("0")
            public static final FontWeight REGULAR = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ FontWeight[] f47920a = null;

            static {
                FontWeight r100 = new FontWeight("REGULAR", 0);
                REGULAR = r100;
                FontWeight r101 = new FontWeight("BOLD", 1);
                BOLD = r101;
                f47920a = new FontWeight[]{r100, r101};
            }

            public static FontWeight valueOf(String r100) {
                return (FontWeight) r27.a.a(FontWeight.class, r100);
            }

            public static FontWeight[] values() {
                return (FontWeight[]) f47920a.clone();
            }

            public FontWeight(String r100, int r101) {
                super(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$SplitItem;", "Ljava/io/Serializable;", "splitStyle", "Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$SplitItem$SplitStyle;", "color", "", "(Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$SplitItem$SplitStyle;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getSplitStyle", "()Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$SplitItem$SplitStyle;", "SplitStyle", "ec-model_release"}, k = 1, mv = {1, 4, 3})
        public static final class SplitItem implements Serializable {

            @SerializedName("color")
            private final String color;

            @SerializedName("splitor_style")
            private final SplitStyle splitStyle;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$SplitItem$SplitStyle;", "", UserProfileEvent.POSITION_NONE, "STROKE", "DASH", "DOT", "ec-model_release"}, k = 1, mv = {1, 4, 3})
            public static final enum SplitStyle extends Enum<SplitStyle> {

                @SerializedName("2")
                public static final SplitStyle DASH = null;

                @SerializedName("3")
                public static final SplitStyle DOT = null;

                @SerializedName("0")
                public static final SplitStyle NONE = null;

                @SerializedName("1")
                public static final SplitStyle STROKE = null;

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ SplitStyle[] f47921a = null;

                static {
                    SplitStyle r100 = new SplitStyle(UserProfileEvent.POSITION_NONE, 0);
                    NONE = r100;
                    SplitStyle r101 = new SplitStyle("STROKE", 1);
                    STROKE = r101;
                    SplitStyle r102 = new SplitStyle("DASH", 2);
                    DASH = r102;
                    SplitStyle r103 = new SplitStyle("DOT", 3);
                    DOT = r103;
                    f47921a = new SplitStyle[]{r100, r101, r102, r103};
                }

                public static SplitStyle valueOf(String r100) {
                    return (SplitStyle) r27.a.a(SplitStyle.class, r100);
                }

                public static SplitStyle[] values() {
                    return (SplitStyle[]) f47921a.clone();
                }

                public SplitStyle(String r100, int r101) {
                    super(r100, r101);
                }
            }

            public final String getColor() {
                return this.color;
            }

            public final SplitStyle getSplitStyle() {
                return this.splitStyle;
            }

            public SplitItem(SplitStyle r100, String r101) {
                Intrinsics.checkNotNullParameter(r101, "color");
                this.splitStyle = r100;
                this.color = r101;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\r\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$TextItem;", "Ljava/io/Serializable;", "text", "", "textBgColor", "textBorderColor", "textColor", GXTemplateKey.FLEXBOX_PADDING, "", "weight", "Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$FontWeight;", "fontSize", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[FLcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$FontWeight;Ljava/lang/Integer;)V", "getFontSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "()Ljava/lang/String;", "getTextBgColor", "getTextBorderColor", "getTextColor", "getWeight", "()Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$FontWeight;", "leftPadding", "", "()Ljava/lang/Float;", "rightPadding", "ec-model_release"}, k = 1, mv = {1, 4, 3})
        public static final class TextItem implements Serializable {

            @SerializedName("font_size")
            private final Integer fontSize;

            @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
            private final float[] padding;

            @SerializedName("text")
            private final String text;

            @SerializedName("text_bg_color")
            private final String textBgColor;

            @SerializedName("text_border_color")
            private final String textBorderColor;

            @SerializedName("text_color")
            private final String textColor;

            @SerializedName("weight")
            private final FontWeight weight;

            public final Float leftPadding() {
                float[] r100 = this.padding;
                if (r100 != null) goto L7;
                return null;
            L7:
                return ArraysKt.getOrNull(r100, 3);
            }

            public final Float rightPadding() {
                float[] r100 = this.padding;
                if (r100 != null) goto L7;
                return null;
            L7:
                return ArraysKt.getOrNull(r100, 1);
            }

            public final Integer getFontSize() {
                return this.fontSize;
            }

            public final String getText() {
                return this.text;
            }

            public final String getTextBgColor() {
                return this.textBgColor;
            }

            public final String getTextBorderColor() {
                return this.textBorderColor;
            }

            public final String getTextColor() {
                return this.textColor;
            }

            public final FontWeight getWeight() {
                return this.weight;
            }

            public TextItem(String r100, String r101, String r102, String r103, float[] r104, FontWeight r105, Integer r106) {
                this.text = r100;
                this.textBgColor = r101;
                this.textBorderColor = r102;
                this.textColor = r103;
                this.padding = r104;
                this.weight = r105;
                this.fontSize = r106;
            }

            public /* synthetic */ TextItem(String r110, String r111, String r112, String r113, float[] r114, FontWeight r115, Integer r116, int r117, DefaultConstructorMarker r118) {
                if ((r117 & 64) == 0) goto L5;
                Integer r100 = null;
            L6:
                this(r110, r111, r112, r113, r114, r115, r100);
                return;
            L5:
                r100 = r116;
                goto L6
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/model/response/RitTagUI$RitTagUIItem$UIItemType;", "", CardAdapter.TEXT, "IMAGE", "SPLIT", "ec-model_release"}, k = 1, mv = {1, 4, 3})
        public static final enum UIItemType extends Enum<UIItemType> {

            @SerializedName("1")
            public static final UIItemType IMAGE = null;

            @SerializedName("2")
            public static final UIItemType SPLIT = null;

            @SerializedName("0")
            public static final UIItemType TEXT = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ UIItemType[] f47922a = null;

            static {
                UIItemType r100 = new UIItemType(CardAdapter.TEXT, 0);
                TEXT = r100;
                UIItemType r101 = new UIItemType("IMAGE", 1);
                IMAGE = r101;
                UIItemType r102 = new UIItemType("SPLIT", 2);
                SPLIT = r102;
                f47922a = new UIItemType[]{r100, r101, r102};
            }

            public static UIItemType valueOf(String r100) {
                return (UIItemType) r27.a.a(UIItemType.class, r100);
            }

            public static UIItemType[] values() {
                return (UIItemType[]) f47922a.clone();
            }

            public UIItemType(String r100, int r101) {
                super(r100, r101);
            }
        }

        public final ECUrlModel getImage() {
            return this.image;
        }

        public final UIItemType getItemType() {
            return this.itemType;
        }

        public final float[] getRadius() {
            return this.radius;
        }

        public final SplitItem getSplit() {
            return this.split;
        }

        public final TextItem getText() {
            return this.text;
        }

        public RitTagUIItem(UIItemType r100, float[] r101, TextItem r102, SplitItem r103, ECUrlModel r104) {
            this.itemType = r100;
            this.radius = r101;
            this.text = r102;
            this.split = r103;
            this.image = r104;
        }
    }

    public final RitTagUIBackground getBackground() {
        return this.background;
    }

    public final List<RitTagUIItem> getUiItems() {
        return this.uiItems;
    }

    public RitTagUI(RitTagUIBackground r100, List<RitTagUIItem> r101) {
        this.background = r100;
        this.uiItems = r101;
    }
}
