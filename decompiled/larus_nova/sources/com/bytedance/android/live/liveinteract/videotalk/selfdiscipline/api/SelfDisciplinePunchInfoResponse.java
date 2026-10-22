package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.api;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.o0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fR*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/api/SelfDisciplinePunchInfoResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/o0;", "", "Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/api/PunchInfo;", "punchInfos", "Ljava/util/List;", "getPunchInfos", "()Ljava/util/List;", "setPunchInfos", "(Ljava/util/List;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplinePunchInfoResponse extends FlexModelBase<o0> implements o0, h {

    @SerializedName("puch_infos")
    protected List<PunchInfo> punchInfos;

    public SelfDisciplinePunchInfoResponse() {
        super(o0.class);
    }

    public SelfDisciplinePunchInfoResponse(g r100) {
        super(o0.class);
        this.punchInfos = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.punchInfos.add(new PunchInfo(r100));
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.o0
    public List<PunchInfo> getPunchInfos() {
        return this.punchInfos;
    }

    public void setPunchInfos(List<PunchInfo> r100) {
        this.punchInfos = r100;
    }
}
