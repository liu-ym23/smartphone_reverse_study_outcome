package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.CustomConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ICustomConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/d4;", "", "Lcom/bytedance/android/livesdk/link/model/c9;", "<set-?>", "scoreElements$delegate", "Ljava/lang/Object;", "getScoreElements", "()Ljava/util/List;", "setScoreElements", "(Ljava/util/List;)V", "scoreElements", "", "name$delegate", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "name", "", "duration$delegate", "getDuration", "()J", "setDuration", "(J)V", "duration", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ICustomConfigFlexImpl extends FlexModelBase<d4> implements d4, vh7.h {

    @SerializedName("duration")
    protected long _$$duration;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("score_elements")
    protected List<? extends c9> _$$scoreElements;

    public ICustomConfigFlexImpl() {
        super(d4.class);
        this._$$name = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.d4
    public final long getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.livesdk.link.model.d4
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.link.model.d4
    public final List<c9> getScoreElements() {
        return this._$$scoreElements;
    }

    public ICustomConfigFlexImpl(am3.g r100) {
        super(d4.class);
        this._$$scoreElements = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$scoreElements.add(vh7.f.a(r100, c9.class));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$name = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$duration = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$name != null) goto L31;
        this._$$name = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.d4
    public final void setDuration(long r100) {
        this._$$duration = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.d4
    public final void setName(String r100) {
        this._$$name = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.d4
    public final void setScoreElements(List<? extends c9> r100) {
        this._$$scoreElements = r100;
    }
}
