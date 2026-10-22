package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.InteractionData")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0012\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData;", "", "", "full", "Z", "", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$InteractionContent;", "contents", "Ljava/util/List;", "<init>", "()V", "Companion", "BizActionMeta", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ElementAvatar", "ElementBlank", "ElementImage", "ElementImageBubble", "ElementLoopText", "ElementText", "InteractionAvatar", "InteractionContent", "InteractionContentCheck", "InteractionElement", "JumpActionMeta", "ListAction", "ListTopInteractionRow", "MessageProduct", "ProductCover", "UrlImage", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2InteractionData {
    public static final a Companion = null;
    public static final int ELEMENT_TYPE_AVATARS = 1;
    public static final int ELEMENT_TYPE_AVATAR_V2 = 23;
    public static final int ELEMENT_TYPE_BLANK = 3;
    public static final int ELEMENT_TYPE_BLANK_V2 = 21;
    public static final int ELEMENT_TYPE_BLOCK_GROUP = 25;
    public static final int ELEMENT_TYPE_COUNT_DOWN_V2 = 22;
    public static final int ELEMENT_TYPE_ICON_V2 = 24;
    public static final int ELEMENT_TYPE_LOOP_TEXT = 29;
    public static final int ELEMENT_TYPE_PRICE = 28;
    public static final int ELEMENT_TYPE_RICH_TEXT = 27;
    public static final int ELEMENT_TYPE_TEXT = 2;
    public static final int ELEMENT_TYPE_TEXT_V2 = 20;
    public static final int ELEMENT_TYPE_UNKNOWN = 0;

    @SerializedName("contents")
    public List<InteractionContent> contents;

    @SerializedName("full")
    public boolean full;

    @ProtoMessage("live.BizActionMeta")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$BizActionMeta;", "", "()V", "actionName", "", "actionParam", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BizActionMeta {

        @SerializedName("action_name")
        public String actionName;

        @SerializedName("action_param")
        public String actionParam;

        public BizActionMeta() {
        }
    }

    @ProtoMessage("live.ElementAvatar")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementAvatar;", "", "()V", "image", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$UrlImage;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementAvatar {

        @SerializedName("avatar")
        public UrlImage image;

        public ElementAvatar() {
        }
    }

    @ProtoMessage("live.ElementBlank")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementBlank;", "", "()V", "width", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementBlank {

        @SerializedName("width")
        public int width;

        public ElementBlank() {
        }
    }

    @ProtoMessage("live.ElementImage")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementImage;", "", "()V", "bubble", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementImageBubble;", "image", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$UrlImage;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementImage {

        @SerializedName("bubble")
        public ElementImageBubble bubble;

        @SerializedName("image")
        public UrlImage image;

        public ElementImage() {
        }
    }

    @ProtoMessage("live.ElementImageBubble")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementImageBubble;", "", "()V", "backgroundColor", "", "borderColor", "borderRadius", "", "color", "fontSize", "height", "horizontalPadding", "text", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementImageBubble {

        @SerializedName("background_color")
        public String backgroundColor;

        @SerializedName("border_color")
        public String borderColor;

        @SerializedName("border_radius")
        public long borderRadius;

        @SerializedName("color")
        public String color;

        @SerializedName("font_size")
        public long fontSize;

        @SerializedName("height")
        public long height;

        @SerializedName("horizontal_padding")
        public long horizontalPadding;

        @SerializedName("text")
        public String text;

        public ElementImageBubble() {
        }
    }

    @ProtoMessage("live.ElementLoopText")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementLoopText;", "", "()V", "animGap", "", CommodityText.BOLD, "", "loopText", "", "", "textColor", "textSize", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementLoopText {

        @SerializedName("anim_gap")
        public long animGap;

        @SerializedName(CommodityText.BOLD)
        public boolean bold;

        @SerializedName("texts")
        public List<String> loopText;

        @SerializedName("color")
        public String textColor;

        @SerializedName("size")
        public int textSize;

        public ElementLoopText() {
            this.textSize = 12;
            this.animGap = 200;
        }
    }

    @ProtoMessage("live.ElementText")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementText;", "", "()V", CommodityText.BOLD, "", "color", "", "ellipsis", "image", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$UrlImage;", "maxWidth", "", "size", "Ljava/lang/Long;", "text", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementText {

        @SerializedName(CommodityText.BOLD)
        public boolean bold;

        @SerializedName("color")
        public String color;

        @SerializedName("ellipsis")
        public boolean ellipsis;

        @SerializedName("background")
        public UrlImage image;

        @SerializedName(TextureRenderKeys.KEY_IS_MAX_WIDTH)
        public long maxWidth;

        @SerializedName("size")
        public Long size;

        @SerializedName("text")
        public String text;

        public ElementText() {
        }
    }

    @ProtoMessage("live.InteractionAvatar")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$InteractionAvatar;", "", "()V", "height", "", "urlList", "", "", "width", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InteractionAvatar {

        @SerializedName("height")
        public int height;

        @SerializedName(ScoreTags.STAR_URL_LIST)
        public List<String> urlList;

        @SerializedName("width")
        public int width;

        public InteractionAvatar() {
        }
    }

    @ProtoMessage("live.InteractionContent")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$InteractionContent;", "", "()V", "action", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ListAction;", "bgColors", "", "", "check", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$InteractionContentCheck;", "content", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$InteractionElement;", "eventParam", "", "loopCount", "", "priority", "product", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$MessageProduct;", "rows", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ListTopInteractionRow;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InteractionContent {

        @SerializedName("action")
        public ListAction action;

        @SerializedName("bg_colors")
        public List<String> bgColors;

        @SerializedName("check")
        public InteractionContentCheck check;

        @SerializedName("content")
        public List<InteractionElement> content;

        @SerializedName("event_param")
        public Map<String, String> eventParam;

        @SerializedName("loop_count")
        public int loopCount;

        @SerializedName("priority")
        public int priority;

        @SerializedName("product")
        public MessageProduct product;

        @SerializedName("rows")
        public List<ListTopInteractionRow> rows;

        public InteractionContent() {
        }
    }

    @ProtoMessage("live.InteractionContentCheck")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$InteractionContentCheck;", "", "()V", "index", "", "product_id", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InteractionContentCheck {

        @SerializedName("index")
        public int index;

        @SerializedName("product_id")
        public long product_id;

        public InteractionContentCheck() {
        }
    }

    @ProtoMessage("live.InteractionElement")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$InteractionElement;", "", "()V", "avatars", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$InteractionAvatar;", "blankWidth", "", "elementAvatar", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementAvatar;", "elementBlank", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementBlank;", "elementImage", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementImage;", "elementLoopText", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementLoopText;", "elementTextV2", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ElementText;", "elementType", "text", "", "textColor", "textSize", "Ljava/lang/Integer;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InteractionElement {

        @SerializedName("avatars")
        public InteractionAvatar avatars;

        @SerializedName("blank_width")
        public int blankWidth;

        @SerializedName("avatars_v2")
        public ElementAvatar elementAvatar;

        @SerializedName("blank_v2")
        public ElementBlank elementBlank;

        @SerializedName("image_v2")
        public ElementImage elementImage;

        @SerializedName("loop_text")
        public ElementLoopText elementLoopText;

        @SerializedName("text_v2")
        public ElementText elementTextV2;

        @SerializedName("element_type")
        public int elementType;

        @SerializedName("text")
        public String text;

        @SerializedName("text_color")
        public String textColor;

        @SerializedName("text_size")
        public Integer textSize;

        public InteractionElement() {
        }
    }

    @ProtoMessage("live.JumpActionMeta")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$JumpActionMeta;", "", "()V", "appendParamsType", "", "Ljava/lang/Long;", "url", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class JumpActionMeta {

        @SerializedName("append_params_type")
        public Long appendParamsType;

        @SerializedName("url")
        public String url;

        public JumpActionMeta() {
        }
    }

    @ProtoMessage("live.ListAction")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ListAction;", "", "()V", ReportConstant.COMMON_ACTION_TYPE, "", "Ljava/lang/Long;", "bizAction", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$BizActionMeta;", "jumpAction", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$JumpActionMeta;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ListAction {

        @SerializedName("action_type")
        public Long actionType;

        @SerializedName("biz_action")
        public BizActionMeta bizAction;

        @SerializedName("jump_action")
        public JumpActionMeta jumpAction;

        public ListAction() {
        }
    }

    @ProtoMessage("live.ListTopInteractionRow")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ListTopInteractionRow;", "", "()V", "content", "", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$InteractionElement;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ListTopInteractionRow {

        @SerializedName("content")
        public List<InteractionElement> content;

        public ListTopInteractionRow() {
        }
    }

    @ProtoMessage("live.MessageProduct")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$MessageProduct;", "", "()V", "cover", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ProductCover;", "index", "", "showIndex", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MessageProduct {

        @SerializedName("cover")
        public ProductCover cover;

        @SerializedName("index")
        public int index;

        @SerializedName("show_index")
        public boolean showIndex;

        public MessageProduct() {
        }
    }

    @ProtoMessage("live.ProductCover")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$ProductCover;", "", "()V", "height", "", "urlList", "", "", "width", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ProductCover {

        @SerializedName("height")
        public int height;

        @SerializedName(ScoreTags.STAR_URL_LIST)
        public List<String> urlList;

        @SerializedName("width")
        public int width;

        public ProductCover() {
        }
    }

    @ProtoMessage("live.UrlImage")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData$UrlImage;", "", "()V", "height", "", "urlList", "", "", "width", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UrlImage {

        @SerializedName("height")
        public int height;

        @SerializedName(ScoreTags.STAR_URL_LIST)
        public List<String> urlList;

        @SerializedName("width")
        public int width;

        public UrlImage() {
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECV2InteractionData() {
    }
}
