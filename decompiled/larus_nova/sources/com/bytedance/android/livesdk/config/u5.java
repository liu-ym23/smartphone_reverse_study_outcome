package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.crash.SourceType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/u5;", "", "", "", "needChangeUiLayout", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setNeedChangeUiLayout", "(Ljava/util/List;)V", "", "", "targetFunctionType", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setTargetFunctionType", "(Ljava/util/Map;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f121346a = 0;

    @SerializedName("need_change_uilayout")
    private List<Integer> needChangeUiLayout;

    @SerializedName("target_function_type")
    private Map<String, String> targetFunctionType;

    public static final class a {
        public static u5 a() {
            ArrayList r100 = CollectionsKt.arrayListOf(new Integer[]{0, 1, 2, 5, 7, 21, 22});
            u5 r101 = new u5();
            List<Integer> r102 = r101.a();
            if (r102 == null) goto L5;
            r102.addAll(r100);
        L5:
            Map<String, String> r103 = r101.b();
            if (r103 == null) goto L8;
            r103.put("8_*", "radio");
        L8:
            Map<String, String> r104 = r101.b();
            if (r104 == null) goto L11;
            r104.put("12_*", "party");
        L11:
            Map<String, String> r105 = r101.b();
            if (r105 == null) goto L14;
            r105.put("13_*", "ktv");
        L14:
            Map<String, String> r106 = r101.b();
            if (r106 == null) goto L17;
            r106.put("5_21", "radio");
        L17:
            Map<String, String> r107 = r101.b();
            if (r107 == null) goto L20;
            r107.put("5_22", "party");
        L20:
            Map<String, String> r108 = r101.b();
            if (r108 == null) goto L23;
            r108.put("9_*", "ktv");
        L23:
            Map<String, String> r109 = r101.b();
            if (r109 == null) goto L26;
            r109.put("4_*", SourceType.DEFAULT);
        L26:
            return r101;
        }
    }

    static {
    }

    public u5() {
        this.needChangeUiLayout = new ArrayList();
        this.targetFunctionType = new HashMap();
    }

    public final List<Integer> a() {
        return this.needChangeUiLayout;
    }

    public final Map<String, String> b() {
        return this.targetFunctionType;
    }
}
