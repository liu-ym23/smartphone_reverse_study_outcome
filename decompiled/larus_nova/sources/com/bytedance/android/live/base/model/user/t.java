package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006RB\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/user/t;", "Lvh7/c;", "Lpy/h;", "getData", "()Lpy/h;", "setData", "(Lpy/h;)V", "getData$annotations", "()V", "data", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getPreferData", "()Ljava/util/Map;", "setPreferData", "(Ljava/util/Map;)V", "getPreferData$annotations", "preferData", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface t extends vh7.c<t> {
    public static final a Companion = null;
    public static final int OTHER_ROOM = 1;
    public static final int PERSONAL_PROFILE = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f58951a = null;

        public a() {
        }

        static {
            f58951a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f58951a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "data")
    py.h getData();

    @FieldName(name = "prefer_data")
    Map<Integer, py.h> getPreferData();

    @FieldName(name = "data#setter")
    void setData(py.h r100);

    @FieldName(name = "prefer_data#setter")
    void setPreferData(Map<Integer, ? extends py.h> r100);
}
