package bu;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GamePlayInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lbu/a;", "", "", "type", "Ljava/lang/Long;", "platformReceiveCondition", "", "platformReceiveParam", "Ljava/lang/String;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("platform_receive_condition")
    public Long platformReceiveCondition;

    @SerializedName("platform_receive_param")
    public String platformReceiveParam;

    @SerializedName("type")
    public Long type;

    public a() {
        this.type = 0L;
        this.platformReceiveCondition = 0L;
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.type = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.platformReceiveCondition = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.platformReceiveParam = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.type != null) goto L19;
        this.type = 0L;
    L19:
        if (this.platformReceiveCondition != null) goto L34;
        this.platformReceiveCondition = 0L;
        return;
    }
}
