package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/j0;", "", "", "Lcom/bytedance/android/livesdk/interactivity/api/settings/config/p0;", "list", "Ljava/util/List;", "b", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "", "level", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "c", "(I)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133763a = 0;

    @SerializedName("default_level")
    private int level;

    @SerializedName("list")
    private List<p0> list;

    public static final class a {
        @JvmStatic
        public static j0 a() {
            j0 r100 = new j0();
            r100.c();
            r100.d(CollectionsKt.listOf(new p0[]{new p0(4, 700, 2, 1, 550), new p0(3, 700, 2, 1, 750), new p0(2, 1000, 2, 1, 550), new p0(1, 1000, 2, 1, 750), new p0(0, 1000, 1, 1, 750)}));
            return r100;
        }
    }

    static {
    }

    public final void c() {
        this.level = 2;
    }

    public j0() {
        this.list = new ArrayList();
        this.level = 2;
    }

    public final int a() {
        return this.level;
    }

    public final List<p0> b() {
        return this.list;
    }

    public final void d(List<p0> r100) {
        this.list = r100;
    }
}
