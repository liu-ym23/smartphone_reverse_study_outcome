package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;

/* JADX INFO: loaded from: classes45.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f70112a = 0;

    public static final class a {
        public static String a() {
            return KtvCommonConfigParams.a() + File.separator + "musicPack";
        }
    }

    static {
    }

    public v() {
    }

    public abstract String a(KtvMusic r100);

    public abstract String b(KtvMusic r100);

    public abstract String c(KtvMusic r100);

    public abstract String getType();
}
