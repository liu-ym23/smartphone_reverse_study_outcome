package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/p5;", "", "", "enable", "Z", "b", "()Z", "", "", "foldScreenList", "Ljava/util/List;", "c", "()Ljava/util/List;", "digHoleList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p5 {

    @SerializedName("dig_hole_device_list")
    private final List<String> digHoleList;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("fold_screen_device_list")
    private final List<String> foldScreenList;

    public p5() {
        this(null);
    }

    public final List<String> a() {
        return this.digHoleList;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<String> c() {
        return this.foldScreenList;
    }

    public p5(Object r100) {
        List<String> r101 = CollectionsKt.listOf("PEUM00");
        ArrayList r102 = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, "foldScreenList");
        Intrinsics.checkNotNullParameter(r102, "digHoleList");
        this.enable = true;
        this.foldScreenList = r101;
        this.digHoleList = r102;
    }
}
