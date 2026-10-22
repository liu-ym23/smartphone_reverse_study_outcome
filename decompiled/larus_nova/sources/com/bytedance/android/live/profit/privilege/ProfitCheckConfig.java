package com.bytedance.android.live.profit.privilege;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/b;", "", "Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig$a;", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "Ljava/util/List;", "getConfigs", "()Ljava/util/List;", "", "needReport", "Z", "getNeedReport", "()Z", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProfitCheckConfig extends FlexModelBase<b> implements b, h {

    @SerializedName(FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY)
    protected List<a> configs;

    @SerializedName("need_report")
    protected boolean needReport;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig$a;", "", "", "profitType", "J", "b", "()J", "duration", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "reportType", "c", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a implements h {

        @SerializedName("duration")
        protected long duration;

        @SerializedName("profit_type")
        protected long profitType;

        @SerializedName("report_type")
        protected long reportType;

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.privilege.ProfitCheckConfig$a$a, reason: collision with other inner class name */
        public static final class C1350a {
        }

        static {
        }

        public a() {
        }

        public final long a() {
            return this.duration;
        }

        public final long b() {
            return this.profitType;
        }

        public final long c() {
            return this.reportType;
        }

        public a(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.profitType = r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.duration = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.reportType = r100.j();
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    public ProfitCheckConfig() {
        super(b.class);
        this.configs = CollectionsKt.emptyList();
    }

    public final List<a> getConfigs() {
        return this.configs;
    }

    public final boolean getNeedReport() {
        return this.needReport;
    }

    public ProfitCheckConfig(g r100) {
        super(b.class);
        this.configs = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.needReport = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.configs.add(new a(r100));
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this.configs.isEmpty() == false) goto L25;
        this.configs = CollectionsKt.emptyList();
        return;
    }
}
