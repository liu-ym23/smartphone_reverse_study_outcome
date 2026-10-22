package com.bytedance.android.annie.bridge.method.abs;

import com.bytedance.android.annie.bridge.method.util.EnumJsonAdapter;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel;", "", "", "schema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", "c", "()Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", "setStrategy", "(Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;)V", "", "expiredTime", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setExpiredTime", "(Ljava/lang/Integer;)V", "<init>", "()V", "Strategy", "StrategyAdapter", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class PrerenderParamModel {

    @SerializedName("expiredTime")
    private Integer expiredTime;

    @SerializedName("schema")
    private String schema;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    @JsonAdapter(StrategyAdapter.class)
    private Strategy strategy;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", "", "", "toString", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Immediately", "Onidle", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Strategy extends Enum<Strategy> {
        public static final a Companion = null;
        public static final Strategy Immediately = null;
        public static final Strategy Onidle = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Strategy[] f38527a = null;

        public static final class a {
            public a() {
            }
        }

        public static Strategy valueOf(String r100) {
            return (Strategy) r27.a.a(Strategy.class, r100);
        }

        public static Strategy[] values() {
            return (Strategy[]) f38527a.clone();
        }

        static {
            Strategy r100 = new Strategy("Immediately", 0);
            Immediately = r100;
            Strategy r101 = new Strategy("Onidle", 1);
            Onidle = r101;
            f38527a = new Strategy[]{r100, r101};
            Companion = new a();
        }

        @Override // java.lang.Enum
        public String toString() {
            if (this != Immediately) goto L6;
            return "immediately";
        L6:
            if (this != Onidle) goto L8;
            return "onidle";
        L8:
            return "";
        }

        public Strategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$StrategyAdapter;", "Lcom/bytedance/android/annie/bridge/method/util/EnumJsonAdapter;", "Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class StrategyAdapter extends EnumJsonAdapter<Strategy> {
        public StrategyAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            if (r100.peek() != JsonToken.NULL) goto L7;
            r100.nextNull();
            return null;
        L7:
            String r101 = r100.nextString();
            Strategy.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            if (StringsKt.equals(r101, "immediately", true) == false) goto L11;
            return Strategy.Immediately;
        L11:
            if (StringsKt.equals(r101, "onidle", true) == true) goto L13;
            return null;
        L13:
            return Strategy.Onidle;
        }
    }

    public PrerenderParamModel() {
        this.strategy = Strategy.Onidle;
        this.expiredTime = 10;
    }

    public final Integer a() {
        return this.expiredTime;
    }

    public final String b() {
        return this.schema;
    }

    public final Strategy c() {
        return this.strategy;
    }
}
