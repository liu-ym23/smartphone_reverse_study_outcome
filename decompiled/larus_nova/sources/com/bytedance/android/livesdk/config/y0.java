package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/y0;", "", "", "enable", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setEnable", "(I)V", "", "Lcom/bytedance/android/livesdk/config/y0$a;", "list", "Ljava/util/List;", "b", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y0 {

    @SerializedName("enable")
    private int enable;

    @SerializedName("list")
    private List<a> list;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/config/y0$a;", "", "", "key", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "", "level", "I", "b", "()I", "f", "(I)V", "trigger_time", "d", com.amap.api.col.s.ce.f26391f, "", InvRouter.SCENES, "Ljava/util/List;", "c", "()Ljava/util/List;", "setScenes", "(Ljava/util/List;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("key")
        private String key;

        @SerializedName("level")
        private int level;

        @SerializedName(InvRouter.SCENES)
        private List<Integer> scenes;

        @SerializedName("trigger_time")
        private int trigger_time;

        public final void f() {
            this.level = 1;
        }

        public final void g() {
            this.trigger_time = 0;
        }

        public final void e() {
            Intrinsics.checkNotNullParameter("atmosphere", "<set-?>");
            this.key = "atmosphere";
        }

        public a() {
            this.key = "";
        }

        public final String a() {
            return this.key;
        }

        public final int b() {
            return this.level;
        }

        public final List<Integer> c() {
            return this.scenes;
        }

        public final int d() {
            return this.trigger_time;
        }

        public a(int r100) {
            Intrinsics.checkNotNullParameter("background", "key");
            this();
            this.key = "background";
            this.level = 1;
            this.trigger_time = 1;
        }
    }

    public y0() {
        this.enable = 1;
    }

    public final int a() {
        return this.enable;
    }

    public final List<a> b() {
        return this.list;
    }
}
