package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/eh1;", "", "", "showStrategy", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setShowStrategy", "(Ljava/lang/String;)V", "", "relativeGroup", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setRelativeGroup", "(Ljava/util/List;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class eh1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f120127a = 0;

    @SerializedName("relative_group")
    private List<? extends List<String>> relativeGroup;

    @SerializedName("show_strategy")
    private String showStrategy;

    public static final class a {
    }

    static {
    }

    public eh1() {
    }

    public final List<List<String>> a() {
        return this.relativeGroup;
    }

    public final String b() {
        return this.showStrategy;
    }
}
