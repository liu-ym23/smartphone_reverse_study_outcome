package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/PaidLinkmicExplainCardInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/i1;", "", "numOfLink", "J", "getNumOfLink", "()J", "setNumOfLink", "(J)V", "", "avgGrade", FaceService.girlLabel, "getAvgGrade", "()F", "setAvgGrade", "(F)V", "Lcom/bytedance/android/livesdk/chatroom/model/interact/j1;", "tag", "Lcom/bytedance/android/livesdk/chatroom/model/interact/j1;", "getTag", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/j1;", "setTag", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/j1;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidLinkmicExplainCardInfo extends FlexModelBase<i1> implements i1, vh7.h {

    @SerializedName("avg_grade")
    protected float avgGrade;

    @SerializedName("num_of_link")
    protected long numOfLink;

    @SerializedName("tag")
    protected j1 tag;

    public PaidLinkmicExplainCardInfo() {
        super(i1.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.i1
    public float getAvgGrade() {
        return this.avgGrade;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.i1
    public long getNumOfLink() {
        return this.numOfLink;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.i1
    public j1 getTag() {
        return this.tag;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.chatroom.model.interact.j1, java.lang.Object] */
    public PaidLinkmicExplainCardInfo(am3.g r100) {
        super(i1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.numOfLink = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.avgGrade = Float.intBitsToFloat(r100.g());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.tag = vh7.f.a(r100, j1.class);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setAvgGrade(float r100) {
        this.avgGrade = r100;
    }

    public void setNumOfLink(long r100) {
        this.numOfLink = r100;
    }

    public void setTag(j1 r100) {
        this.tag = r100;
    }
}
