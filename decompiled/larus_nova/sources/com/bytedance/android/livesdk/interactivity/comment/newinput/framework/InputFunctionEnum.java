package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bj\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionEnum;", "", "", "mark", "I", "getMark", "()I", "", "priority", "J", "getPriority", "()J", "setPriority", "(J)V", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionType;", "type", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionType;", "getType", "()Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionType;", "setType", "(Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionType;)V", "", "logValue", "Ljava/lang/String;", "getLogValue", "()Ljava/lang/String;", "setLogValue", "(Ljava/lang/String;)V", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ChatInputCarrier_UnKnown", "ChatInputCarrier_Fold", "ChatInputCarrier_Emoji", "ChatInputCarrier_Audio", "ChatInputCarrier_Share", "ChatInputCarrier_Video", "ChatInputCarrier_FastChat", "ChatInputCarrier_CustomerService", "ChatInputCarrier_AI", "ChatInputCarrier_Mention", "ChatInputCarrier_Highlight", "ChatInputCarrier_Interest", "ChatInputCarrier_Truth", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputFunctionEnum extends Enum<InputFunctionEnum> {
    public static final InputFunctionEnum ChatInputCarrier_AI = null;
    public static final InputFunctionEnum ChatInputCarrier_Audio = null;
    public static final InputFunctionEnum ChatInputCarrier_CustomerService = null;
    public static final InputFunctionEnum ChatInputCarrier_Emoji = null;
    public static final InputFunctionEnum ChatInputCarrier_FastChat = null;
    public static final InputFunctionEnum ChatInputCarrier_Fold = null;
    public static final InputFunctionEnum ChatInputCarrier_Highlight = null;
    public static final InputFunctionEnum ChatInputCarrier_Interest = null;
    public static final InputFunctionEnum ChatInputCarrier_Mention = null;
    public static final InputFunctionEnum ChatInputCarrier_Share = null;
    public static final InputFunctionEnum ChatInputCarrier_Truth = null;
    public static final InputFunctionEnum ChatInputCarrier_UnKnown = null;
    public static final InputFunctionEnum ChatInputCarrier_Video = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputFunctionEnum[] f135428a = null;
    private String desc;
    private String logValue;
    private final int mark;
    private long priority;
    private InputFunctionType type;

    public static final class a {
        public a() {
        }
    }

    public static InputFunctionEnum valueOf(String r100) {
        return (InputFunctionEnum) r27.a.a(InputFunctionEnum.class, r100);
    }

    public static InputFunctionEnum[] values() {
        return (InputFunctionEnum[]) f135428a.clone();
    }

    static {
        InputFunctionType r210 = InputFunctionType.Common;
        InputFunctionEnum r110 = new InputFunctionEnum("ChatInputCarrier_UnKnown", 0, 0, 0, r210, "unknown", PlayerResolution.NAME.UNKNOWN);
        ChatInputCarrier_UnKnown = r110;
        InputFunctionEnum r100 = new InputFunctionEnum("ChatInputCarrier_Fold", 1, 10000, 100000, InputFunctionType.Function, "fold", "展开");
        ChatInputCarrier_Fold = r100;
        InputFunctionEnum r101 = new InputFunctionEnum("ChatInputCarrier_Emoji", 2, 1, 600, r210, "emoji", "表情");
        ChatInputCarrier_Emoji = r101;
        InputFunctionEnum r102 = new InputFunctionEnum("ChatInputCarrier_Audio", 3, 2, 500, r210, "audio", "语音功能");
        ChatInputCarrier_Audio = r102;
        InputFunctionEnum r103 = new InputFunctionEnum("ChatInputCarrier_Share", 4, 3, 400, r210, "collection", "互动分享");
        ChatInputCarrier_Share = r103;
        InputFunctionEnum r104 = new InputFunctionEnum("ChatInputCarrier_Video", 5, 4, 300, r210, "video_share", "视频");
        ChatInputCarrier_Video = r104;
        InputFunctionType r105 = InputFunctionType.Special;
        InputFunctionEnum r106 = new InputFunctionEnum("ChatInputCarrier_FastChat", 6, 5, 200, r105, "common_comment", "快捷评论");
        ChatInputCarrier_FastChat = r106;
        InputFunctionEnum r107 = new InputFunctionEnum("ChatInputCarrier_CustomerService", 7, 6, 100, r105, "custom_service", "客服");
        ChatInputCarrier_CustomerService = r107;
        InputFunctionEnum r108 = new InputFunctionEnum("ChatInputCarrier_AI", 8, 7, 250, r105, "ai_qa", "AI互动入口");
        ChatInputCarrier_AI = r108;
        InputFunctionEnum r109 = new InputFunctionEnum("ChatInputCarrier_Mention", 9, 8, 700, r210, "mention", "At他人");
        ChatInputCarrier_Mention = r109;
        InputFunctionEnum r111 = new InputFunctionEnum("ChatInputCarrier_Highlight", 10, 9, 300, r105, "comment_highlight", "标记高光");
        ChatInputCarrier_Highlight = r111;
        InputFunctionType r112 = InputFunctionType.More;
        InputFunctionEnum r113 = new InputFunctionEnum("ChatInputCarrier_Interest", 11, 1000, 0, r112, "interest_card", "分享兴趣");
        ChatInputCarrier_Interest = r113;
        InputFunctionEnum r114 = new InputFunctionEnum("ChatInputCarrier_Truth", 12, 1001, 0, r112, "truth_question", "真心话");
        ChatInputCarrier_Truth = r114;
        f135428a = new InputFunctionEnum[]{r110, r100, r101, r102, r103, r104, r106, r107, r108, r109, r111, r113, r114};
        Companion = new a();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getLogValue() {
        return this.logValue;
    }

    public final int getMark() {
        return this.mark;
    }

    public final long getPriority() {
        return this.priority;
    }

    public final InputFunctionType getType() {
        return this.type;
    }

    public final void setDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.desc = r100;
    }

    public final void setLogValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logValue = r100;
    }

    public final void setPriority(long r100) {
        this.priority = r100;
    }

    public final void setType(InputFunctionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public InputFunctionEnum(String r100, int r101, int r102, long r103, InputFunctionType r104, String r105, String r106) {
        super(r100, r101);
        this.mark = r102;
        this.priority = r103;
        this.type = r104;
        this.logValue = r105;
        this.desc = r106;
    }
}
