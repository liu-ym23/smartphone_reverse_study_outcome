package com.bytedance.android.livesdk.interactivity.api.comment.data;

import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentScene;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/data/InputDraftType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Default", "Channel", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputDraftType extends Enum<InputDraftType> {
    public static final InputDraftType Channel = null;
    public static final a Companion = null;
    public static final InputDraftType Default = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputDraftType[] f133032a = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final InputDraftType getType(CommentFlowContext r100) {
            if (r100 != null) goto L4;
        L6:
            boolean r101 = false;
        L7:
            if (r101 == false) goto L10;
            return InputDraftType.Channel;
        L10:
            return InputDraftType.Default;
        L4:
            if (r100.f133050c != CommentScene.ChatChannel) goto L6;
            r101 = true;
            goto L7
        }
    }

    static {
        InputDraftType r100 = new InputDraftType("Default", 0);
        Default = r100;
        InputDraftType r101 = new InputDraftType("Channel", 1);
        Channel = r101;
        f133032a = new InputDraftType[]{r100, r101};
        Companion = new a();
    }

    @JvmStatic
    public static final InputDraftType getType(CommentFlowContext r100) {
        return Companion.getType(r100);
    }

    public static InputDraftType valueOf(String r100) {
        return (InputDraftType) r27.a.a(InputDraftType.class, r100);
    }

    public static InputDraftType[] values() {
        return (InputDraftType[]) f133032a.clone();
    }

    @JvmStatic
    public static final long getSceneId(CommentFlowContext r100) {
        Companion.getClass();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f133059l;
    }

    public InputDraftType(String r100, int r101) {
        super(r100, r101);
    }
}
