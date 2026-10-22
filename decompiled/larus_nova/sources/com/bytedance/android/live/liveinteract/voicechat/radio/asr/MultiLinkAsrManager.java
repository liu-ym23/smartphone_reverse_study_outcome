package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import android.content.Context;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkAsrManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f80483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f80484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f80485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f80486d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/radio/asr/MultiLinkAsrManager$a;", "", "", "appId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "appToken", "b", "e", "cluster", "c", "f", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("appId")
        private String appId;

        @SerializedName("appToken")
        private String appToken;

        @SerializedName("cluster")
        private String cluster;

        public a() {
        }

        public final String a() {
            return this.appId;
        }

        public final String b() {
            return this.appToken;
        }

        public final String c() {
            return this.cluster;
        }

        public final void d(String r100) {
            this.appId = r100;
        }

        public final void e(String r100) {
            this.appToken = r100;
        }

        public final void f(String r100) {
            this.cluster = r100;
        }
    }

    public MultiLinkAsrManager(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f80486d = r100;
        this.f80483a = "asrStateChange";
        this.f80485c = LazyKt.lazy(new MultiLinkAsrManager$transferStartRunnable$2(this));
    }

    public static final void a(MultiLinkAsrManager r100, AsrStateChangeEvent.Type r101, String r102, IJsBridgeManager r103) {
        if (r103 == null) goto L4;
        String r104 = r100.f80483a;
        AsrStateChangeEvent r105 = new AsrStateChangeEvent();
        r105.b(r101);
        r105.a(r102);
        Unit r106 = Unit.INSTANCE;
        r103.sendJsEvent(r104, r105.c());
        return;
    L4:
        r100.getClass();
    }
}
