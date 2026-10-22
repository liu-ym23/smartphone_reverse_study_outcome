package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\"\u0010\u0016\u001a\u00020\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/a;", "Lvh7/c;", "", "isRandomEmoji", "", "getType", "()I", "setType", "(I)V", "getType$annotations", "()V", "type", "getStatus", "setStatus", "getStatus$annotations", "status", "", "getRandomNum", "()J", "setRandomNum", "(J)V", "getRandomNum$annotations", "randomNum", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {
    public static final C1236a Companion = null;
    public static final int CustomizedRandomEmojiStatus_Display = 2;
    public static final int CustomizedRandomEmojiStatus_Hidden = 1;
    public static final int CustomizedRandomEmojiTYPE_CLOCK = 2;
    public static final int CustomizedRandomEmojiTYPE_NUMBER = 1;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.emoji.model.a$a, reason: collision with other inner class name */
    public static final class C1236a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C1236a f79372a = null;

        public C1236a() {
        }

        static {
            f79372a = new C1236a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = C1236a.f79372a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "random_num")
    long getRandomNum();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "type")
    int getType();

    boolean isRandomEmoji();

    @FieldName(name = "random_num#setter")
    void setRandomNum(long r100);

    @FieldName(name = "status#setter")
    void setStatus(int r100);

    @FieldName(name = "type#setter")
    void setType(int r100);
}
