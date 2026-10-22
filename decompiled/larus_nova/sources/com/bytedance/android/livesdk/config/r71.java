package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/config/r71;", "", "", "enable", "Z", "b", "()Z", "", "", "paramsList", "Ljava/util/List;", "d", "()Ljava/util/List;", "setParamsList", "(Ljava/util/List;)V", "", "doubleReport", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setDoubleReport", "(I)V", "maxSessionRange", "c", "setMaxSessionRange", "useThread", "e", "setUseThread", "(Z)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f121109a = null;

    @SerializedName("double_report")
    private int doubleReport;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("max_session_range")
    private int maxSessionRange;

    @SerializedName("params_list")
    private List<String> paramsList;

    @SerializedName("use_thread")
    private boolean useThread;

    public static final class a {
    }

    static {
        f121109a = CollectionsKt.mutableListOf(new String[]{"video_id", ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, "is_other_channel", "is_ecom_room", com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, "is_sale", "is_life"});
    }

    public r71() {
        this.paramsList = new ArrayList();
        this.doubleReport = 3;
        this.maxSessionRange = -1;
        this.useThread = true;
    }

    public final int a() {
        return this.doubleReport;
    }

    public final boolean b() {
        return this.enable;
    }

    public final int c() {
        return this.maxSessionRange;
    }

    public final List<String> d() {
        return this.paramsList;
    }

    public final boolean e() {
        return this.useThread;
    }
}
