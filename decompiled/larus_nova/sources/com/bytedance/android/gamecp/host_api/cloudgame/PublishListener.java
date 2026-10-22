package com.bytedance.android.gamecp.host_api.cloudgame;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000 \b2\u00020\u0001:\u0001\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/cloudgame/PublishListener;", "Ljava/io/Serializable;", "", "result", "", "onFinish", "progress", "onProgress", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PublishListener extends Serializable {
    public static final a Companion = null;
    public static final int RESULT_CANCEL = 2;
    public static final int RESULT_FAILED = 1;
    public static final int RESULT_SUCCESS = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f57361a = null;

        public a() {
        }

        static {
            f57361a = new a();
        }
    }

    static {
        Companion = a.f57361a;
    }

    void onFinish(int r100);

    void onProgress(int r100);
}
