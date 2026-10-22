package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/android/live/broadcastgame/opengame/cloud/CloudConstant$Method", "", "Lcom/bytedance/android/live/broadcastgame/opengame/cloud/CloudConstant$Method;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CloudConstant$Method extends Enum<CloudConstant$Method> {
    public static final a Companion = null;
    public static final CloudConstant$Method DELETE = null;
    public static final CloudConstant$Method GET = null;
    public static final CloudConstant$Method HEAD = null;
    public static final CloudConstant$Method OPTIONS = null;
    public static final CloudConstant$Method POST = null;
    public static final CloudConstant$Method PUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloudConstant$Method[] f59796a = null;

    public static final class a {
        public a() {
        }
    }

    static {
        CloudConstant$Method r100 = new CloudConstant$Method("GET", 0);
        GET = r100;
        CloudConstant$Method r101 = new CloudConstant$Method("POST", 1);
        POST = r101;
        CloudConstant$Method r102 = new CloudConstant$Method("PUT", 2);
        PUT = r102;
        CloudConstant$Method r103 = new CloudConstant$Method("DELETE", 3);
        DELETE = r103;
        CloudConstant$Method r104 = new CloudConstant$Method("HEAD", 4);
        HEAD = r104;
        CloudConstant$Method r105 = new CloudConstant$Method("OPTIONS", 5);
        OPTIONS = r105;
        f59796a = new CloudConstant$Method[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static CloudConstant$Method valueOf(String r100) {
        return (CloudConstant$Method) r27.a.a(CloudConstant$Method.class, r100);
    }

    public static CloudConstant$Method[] values() {
        return (CloudConstant$Method[]) f59796a.clone();
    }

    public CloudConstant$Method(String r100, int r101) {
        super(r100, r101);
    }
}
