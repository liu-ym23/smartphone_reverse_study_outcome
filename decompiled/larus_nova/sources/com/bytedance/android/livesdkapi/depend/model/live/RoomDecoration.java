package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.Decoration")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002tuB\u0007\b\u0016¢\u0006\u0002\u0010\u0003J\u000e\u0010r\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u001aJ\u000e\u0010s\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0011\u0010\"\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0011\u0010#\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b$\u0010!R\u0011\u0010%\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b%\u0010!R\u0011\u0010&\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b&\u0010!R,\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020(8\u0006@GX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0003\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R \u00102\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R&\u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R&\u0010<\u001a\u00020(2\u0006\u0010'\u001a\u00020(8\u0006@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010,\"\u0004\b>\u0010.R&\u0010?\u001a\u00020(2\u0006\u0010'\u001a\u00020(8\u0006@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010,\"\u0004\bA\u0010.R\u001a\u0010B\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bD\u0010\u0003R6\u0010F\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u001a2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u001a8\u0006@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001c\"\u0004\bH\u0010\u001eR\u001e\u0010I\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010,\"\u0004\bK\u0010.R$\u0010L\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bM\u0010\u0003\u001a\u0004\bN\u0010,\"\u0004\bO\u0010.R \u0010P\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0007\"\u0004\bR\u0010\tR \u0010S\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bT\u0010\u0003R \u0010U\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001e\u0010[\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010,\"\u0004\b]\u0010.R\u001e\u0010^\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010,\"\u0004\b`\u0010.R\u0011\u0010a\u001a\u00020E8F¢\u0006\u0006\u001a\u0004\bb\u0010cR\u001e\u0010d\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010,\"\u0004\bf\u0010.R \u0010g\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bh\u0010\u0003R\u001e\u0010i\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010,\"\u0004\bk\u0010.R&\u0010l\u001a\u00020(2\u0006\u0010'\u001a\u00020(8\u0006@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010,\"\u0004\bn\u0010.R&\u0010o\u001a\u00020(2\u0006\u0010'\u001a\u00020(8\u0006@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010,\"\u0004\bq\u0010.¨\u0006v"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomDecoration;", "()V", "auditTextColor", "", "getAuditTextColor", "()Ljava/lang/String;", "setAuditTextColor", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "id", "", "getId", "()J", "setId", "(J)V", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "inputRect", "", "getInputRect", "()Ljava/util/List;", "setInputRect", "(Ljava/util/List;)V", "isComposeSticker", "", "()Z", "isCustomFont", "isLegacyTimeDecoration", "isReserveDecoration", "isTextSticker", "isTimeDecoration", "<set-?>", "", "kind", "getKind$annotations", "getKind", "()I", "setKind", "(I)V", "maxLength", "getMaxLength", "setMaxLength", "ninePatchImage", "getNinePatchImage", "setNinePatchImage", LiveEndPageData.TAG_RESERVATION, "Lcom/bytedance/android/livesdkapi/depend/model/live/Reservation;", "getReservation$annotations", "getReservation", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Reservation;", "setReservation", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Reservation;)V", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "selectedComposeOption", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration$TextComposeOption;", "getSelectedComposeOption$annotations", "", "sit_rect", "getSit_rect", "setSit_rect", "status", "getStatus", "setStatus", "subType", "getSubType$annotations", "getSubType", "setSubType", "textColor", "getTextColor", "setTextColor", "textComposeOptions", "getTextComposeOptions$annotations", "textFontConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/DecorationFontConfig;", "getTextFontConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/DecorationFontConfig;", "setTextFontConfig", "(Lcom/bytedance/android/livesdkapi/depend/model/live/DecorationFontConfig;)V", "textImageAdjustableEndPosition", "getTextImageAdjustableEndPosition", "setTextImageAdjustableEndPosition", "textImageAdjustableStartPosition", "getTextImageAdjustableStartPosition", "setTextImageAdjustableStartPosition", "textMinWidth", "getTextMinWidth", "()D", "textSize", "getTextSize", "setTextSize", "textSpecialEffects", "getTextSpecialEffects$annotations", "type", "getType", "setType", "x", "getX", "setX", "y", "getY", "setY", "getTextComposeOptions", "getTextSpecialEffects", "Companion", "TextComposeOption", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomDecoration extends FlexModelBase<IRoomDecoration> implements IRoomDecoration, h {
    public static final Companion Companion = null;
    public static final int SUB_TYPE_NORMAL = 0;
    public static final int SUB_TYPE_RESERVE = 2;
    public static final int SUB_TYPE_TIME = 1;
    public static final int SUB_TYPE_TOPIC = 3;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_TEXT = 1;

    @SerializedName("audit_text_color")
    protected String auditTextColor;

    @SerializedName("content")
    protected String content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f162600id;

    @SerializedName("image")
    protected ImageModel image;

    @SerializedName("input_rect")
    protected List<Long> inputRect;

    @IgnoreProtoFieldCheck
    @SerializedName("kind")
    protected int kind;

    @SerializedName("max_length")
    protected int maxLength;

    @SerializedName("nine_patch_image")
    protected ImageModel ninePatchImage;

    @SerializedName(LiveEndPageData.TAG_RESERVATION)
    protected Reservation reservation;

    @SerializedName("h")
    protected int screenHeight;

    @SerializedName("w")
    protected int screenWidth;

    @IgnoreProtoFieldCheck
    @IgnoreProtoDecode
    public TextComposeOption selectedComposeOption;

    @IgnoreProtoFieldCheck
    @SerializedName("sit_rect")
    private List<Double> sit_rect;

    @SerializedName("status")
    protected int status;

    @IgnoreProtoFieldCheck
    @SerializedName("sub_type")
    protected int subType;

    @SerializedName("text_color")
    protected String textColor;

    @IgnoreProtoFieldCheck
    @SerializedName("tag")
    public List<TextComposeOption> textComposeOptions;

    @SerializedName("text_font_config")
    protected DecorationFontConfig textFontConfig;

    @SerializedName("text_image_adjustable_end_position")
    protected int textImageAdjustableEndPosition;

    @SerializedName("text_image_adjustable_start_position")
    protected int textImageAdjustableStartPosition;

    @SerializedName("text_size")
    protected int textSize;

    @SerializedName("text_special_effects")
    public List<Long> textSpecialEffects;

    @SerializedName("type")
    protected int type;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    protected int f162601x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    protected int f162602y;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration$Companion;", "", "()V", "SUB_TYPE_NORMAL", "", "SUB_TYPE_RESERVE", "SUB_TYPE_TIME", "SUB_TYPE_TOPIC", "TYPE_IMAGE", "TYPE_TEXT", "copy", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "decoration", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final RoomDecoration copy(RoomDecoration r100) {
            Intrinsics.checkNotNullParameter(r100, "decoration");
            RoomDecoration r101 = new RoomDecoration();
            r101.setImage(r100.getImage());
            r101.setTextColor(r100.getTextColor());
            r101.setTextSize(r100.getTextSize());
            r101.setContent(r100.getContent());
            r101.setMaxLength(r100.getMaxLength());
            r101.setInputRect(r100.getInputRect());
            r101.setType(r100.getType());
            r101.setId(r100.getId());
            r101.setX(r100.getX());
            r101.setY(r100.getY());
            r101.setScreenWidth(r100.getScreenWidth());
            r101.setScreenHeight(r100.getScreenHeight());
            r101.setStatus(r100.getStatus());
            r101.setNinePatchImage(r100.getNinePatchImage());
            r101.setTextFontConfig(r100.getTextFontConfig());
            r101.setAuditTextColor(r100.getAuditTextColor());
            r101.setSubType(r100.getSubType());
            r101.setReservation(r100.getReservation());
            r101.selectedComposeOption = r100.selectedComposeOption;
            r101.textSpecialEffects = r100.textSpecialEffects;
            return r101;
        }
    }

    @ProtoMessage("webcast.api.room.Tag")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration$TextComposeOption;", "", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "customText", "getCustomText", "setCustomText", "isCustomEdit", "", "()Z", "isTimeText", "title", "getTitle", d.f25925o, "type", "", "getType", "()I", "setType", "(I)V", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TextComposeOption implements h {
        public static final Companion Companion = null;
        public static final int TYPE_CUSTOM_EDIT = 2;
        public static final int TYPE_TIME = 1;

        @SerializedName("content")
        protected String content;
        private String customText;

        @SerializedName("title")
        protected String title;

        @SerializedName("type")
        protected int type;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration$TextComposeOption$Companion;", "", "()V", "TYPE_CUSTOM_EDIT", "", "TYPE_TIME", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public TextComposeOption() {
        }

        public final boolean isCustomEdit() {
            if (this.type != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isTimeText() {
            if (this.type == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getCustomText() {
            return this.customText;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getType() {
            return this.type;
        }

        public TextComposeOption(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.title = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.content = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.type = (int) r100.j();
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }

        public final void setContent(String r100) {
            this.content = r100;
        }

        public final void setCustomText(String r100) {
            this.customText = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }

        public final void setType(int r100) {
            this.type = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getKind$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getReservation$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getSelectedComposeOption$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getSubType$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getTextComposeOptions$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getTextSpecialEffects$annotations() {
    }

    public RoomDecoration() {
        super(IRoomDecoration.class);
        this.f162601x = -1;
        this.f162602y = -1;
    }

    public final double getTextMinWidth() {
        return (((double) Math.abs(this.textImageAdjustableEndPosition - this.textImageAdjustableStartPosition)) * 1.0d) / ((double) 2);
    }

    public final boolean isComposeSticker() {
        List<TextComposeOption> r100 = this.textComposeOptions;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        if (r100.size() <= 0) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean isCustomFont() {
        DecorationFontConfig r100 = this.textFontConfig;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        if (r100.getDownloadUrl() == null) goto L9;
        DecorationFontConfig r101 = this.textFontConfig;
        Intrinsics.checkNotNull(r101);
        if (r101.getStatus() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isLegacyTimeDecoration() {
        if (this.type == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.subType != 1) goto L7;
        return true;
    }

    public final boolean isReserveDecoration() {
        if (this.type == 1) goto L5;
    L9:
        return false;
    L5:
        if (this.subType != 2) goto L9;
        if (this.reservation == null) goto L9;
        return true;
    }

    public final boolean isTextSticker() {
        if (this.type == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isTimeDecoration() {
        if (isLegacyTimeDecoration() == true) goto L10;
        TextComposeOption r100 = this.selectedComposeOption;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        if (r100.isTimeText() == true) goto L10;
    L9:
        return false;
    L10:
        return true;
    }

    public final String getAuditTextColor() {
        return this.auditTextColor;
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomDecoration
    public long getId() {
        return this.f162600id;
    }

    public final ImageModel getImage() {
        return this.image;
    }

    public final List<Long> getInputRect() {
        return this.inputRect;
    }

    public final int getKind() {
        return this.kind;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public final ImageModel getNinePatchImage() {
        return this.ninePatchImage;
    }

    public final Reservation getReservation() {
        return this.reservation;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final List<Double> getSit_rect() {
        return this.sit_rect;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final List<TextComposeOption> getTextComposeOptions() {
        return this.textComposeOptions;
    }

    public final DecorationFontConfig getTextFontConfig() {
        return this.textFontConfig;
    }

    public final int getTextImageAdjustableEndPosition() {
        return this.textImageAdjustableEndPosition;
    }

    public final int getTextImageAdjustableStartPosition() {
        return this.textImageAdjustableStartPosition;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final List<Long> getTextSpecialEffects() {
        return this.textSpecialEffects;
    }

    public final int getType() {
        return this.type;
    }

    public final int getX() {
        return this.f162601x;
    }

    public final int getY() {
        return this.f162602y;
    }

    public RoomDecoration(g r100) {
        super(IRoomDecoration.class);
        this.inputRect = new ArrayList();
        this.textSpecialEffects = new ArrayList();
        int r101 = 0;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L31;
        g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L13;
            case 18: goto L12;
            case 19: goto L11;
            case 20: goto L10;
            case 21: goto L9;
            case 22: goto L8;
            default: goto L7;
        };
    L8:
        this.auditTextColor = am3.h.c(r100);
        goto L3
    L9:
        this.textFontConfig = new DecorationFontConfig(r100);
        goto L3
    L10:
        this.textImageAdjustableEndPosition = (int) r100.j();
        goto L3
    L11:
        this.textImageAdjustableStartPosition = (int) r100.j();
        goto L3
    L12:
        List<Long> r105 = this.textSpecialEffects;
    L27:
        r105.add(Long.valueOf(r100.j()));
        goto L3
    L13:
        this.ninePatchImage = x.a(r100);
        goto L3
    L14:
        this.reservation = new Reservation(r100);
        goto L3
    L15:
        this.subType = (int) r100.j();
        goto L3
    L16:
        this.kind = (int) r100.j();
        goto L3
    L17:
        this.f162602y = (int) r100.j();
        r101 = r101 | 2;
        goto L3
    L18:
        this.screenWidth = (int) r100.j();
        goto L3
    L19:
        this.f162601x = (int) r100.j();
        r101 = r101 | 1;
        goto L3
    L20:
        this.screenHeight = (int) r100.j();
        goto L3
    L21:
        this.status = (int) r100.j();
        goto L3
    L22:
        this.maxLength = (int) r100.j();
        goto L3
    L23:
        this.content = am3.h.c(r100);
        goto L3
    L24:
        this.textColor = am3.h.c(r100);
        goto L3
    L25:
        this.textSize = (int) r100.j();
        goto L3
    L26:
        r105 = this.inputRect;
        goto L27
    L28:
        this.type = (int) r100.j();
        goto L3
    L29:
        this.image = x.a(r100);
        goto L3
    L30:
        this.f162600id = r100.j();
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L31:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & 1) != 0) goto L35;
        this.f162601x = -1;
    L35:
        if ((r101 & 2) != 0) goto L85;
        this.f162602y = -1;
        return;
    }

    public final void setAuditTextColor(String r100) {
        this.auditTextColor = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomDecoration
    public void setId(long r100) {
        this.f162600id = r100;
    }

    public final void setImage(ImageModel r100) {
        this.image = r100;
    }

    public final void setInputRect(List<Long> r100) {
        this.inputRect = r100;
    }

    @SerializedName("kind")
    public final void setKind(int r100) {
        this.kind = r100;
    }

    public final void setMaxLength(int r100) {
        this.maxLength = r100;
    }

    public final void setNinePatchImage(ImageModel r100) {
        this.ninePatchImage = r100;
    }

    public final void setReservation(Reservation r100) {
        this.reservation = r100;
    }

    @SerializedName("h")
    public final void setScreenHeight(int r100) {
        this.screenHeight = r100;
    }

    @SerializedName("w")
    public final void setScreenWidth(int r100) {
        this.screenWidth = r100;
    }

    @SerializedName("sit_rect")
    public final void setSit_rect(List<Double> r100) {
        this.sit_rect = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setSubType(int r100) {
        this.subType = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public final void setTextFontConfig(DecorationFontConfig r100) {
        this.textFontConfig = r100;
    }

    public final void setTextImageAdjustableEndPosition(int r100) {
        this.textImageAdjustableEndPosition = r100;
    }

    public final void setTextImageAdjustableStartPosition(int r100) {
        this.textImageAdjustableStartPosition = r100;
    }

    public final void setTextSize(int r100) {
        this.textSize = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    @SerializedName("x")
    public final void setX(int r100) {
        this.f162601x = r100;
    }

    @SerializedName("y")
    public final void setY(int r100) {
        this.f162602y = r100;
    }
}
