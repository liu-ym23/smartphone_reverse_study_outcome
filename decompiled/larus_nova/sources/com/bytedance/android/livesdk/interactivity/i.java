package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class i implements IService {
    public static final a Companion = null;
    private static i impl;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public i() {
    }

    public py.k getAvatarForRoomIntroMessage(b4 r100) {
        Intrinsics.checkNotNullParameter(r100, "roomIntroMessage");
        return null;
    }

    public String getCommentTip(DataCenter r100) {
        return null;
    }

    public static final /* synthetic */ i access$getImpl$cp() {
        return impl;
    }

    public static final /* synthetic */ void access$setImpl$cp(i r100) {
        impl = r100;
    }
}
