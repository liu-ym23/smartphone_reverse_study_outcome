package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.dialog;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/dialog/VSDanmakuInputDialogFromName;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public @interface VSDanmakuInputDialogFromName {
    public static final a Companion = null;
    public static final String FROM_VS_DANMU_LANDSCAPE = "send_barrage";
    public static final String FROM_VS_DANMU_PORTRAIT = "send_barrage";
    public static final String FROM_VS_UNKNOWN = "unknown";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f109092a = null;

        public a() {
        }

        static {
            f109092a = new a();
        }
    }

    static {
        Companion = a.f109092a;
    }
}
