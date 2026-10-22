package a10;

import com.bytedance.android.live.broadcast.xplay.XplayMessageDeserializer;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(XplayMessageDeserializer.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"La10/d;", "", "", "action", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "ts", "J", "getTs", "()J", "setTs", "(J)V", "La10/e;", ContainerPosition.BODY, "La10/e;", "b", "()La10/e;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d {

    @SerializedName("action")
    private final String action;

    @SerializedName(ContainerPosition.BODY)
    private final e body;

    /* JADX INFO: renamed from: ts, reason: collision with root package name */
    @SerializedName("ts")
    private long f1363ts;

    public d() {
        this(null, null, 7);
    }

    public final String a() {
        return this.action;
    }

    public final e b() {
        return this.body;
    }

    public d(String r100, e r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "action");
        this.action = r100;
        this.f1363ts = 0;
        this.body = r101;
    }
}
