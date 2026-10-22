package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eR\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/x0;", "Lvh7/c;", "", "getBattleResultType", "()I", "getBattleResultType$annotations", "()V", "battleResultType", "", "getConsecutiveCount", "()J", "getConsecutiveCount$annotations", "consecutiveCount", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface x0 extends vh7.c<x0> {
    public static final a Companion = null;
    public static final int DRAW = 3;
    public static final int LOSE = 2;
    public static final int UNDEFINED = 0;
    public static final int WIN = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147104a = null;

        public a() {
        }

        static {
            f147104a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f147104a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_result_type")
    int getBattleResultType();

    @FieldName(name = "consecutive_count")
    long getConsecutiveCount();
}
