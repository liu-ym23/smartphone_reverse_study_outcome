package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.im.LinkmicBattleFinishExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fR'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleFinishExtraFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/z4;", "", "", "", "followLeadMap$delegate", "Ljava/lang/Object;", "getFollowLeadMap", "()Ljava/util/Map;", "followLeadMap", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkMicBattleFinishExtraFlexImpl extends FlexModelBase<z4> implements z4, vh7.h {

    @SerializedName("is_follow_lead")
    protected Map<String, Boolean> _$$followLeadMap;

    public ILinkMicBattleFinishExtraFlexImpl() {
        super(z4.class);
        this._$$followLeadMap = $defaultValue_followLeadMap$();
    }

    public ILinkMicBattleFinishExtraFlexImpl(am3.g r110) {
        super(z4.class);
        this._$$followLeadMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L25;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L7;
        long r103 = r110.c();
        String r104 = null;
        Boolean r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L17;
        if (r106 != 1) goto L13;
        r104 = am3.h.c(r110);
        goto L9
    L13:
        if (r106 != 2) goto L14;
        r105 = Boolean.valueOf(am3.h.a(r110));
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r103);
        Map<String, Boolean> r107 = this._$$followLeadMap;
        if (r104 == null) goto L24;
        if (r105 == null) goto L22;
        r107.put(r104, r105);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r102, r110);
        goto L3
    L25:
        r110.d(r100);
        setThreadSafe(true);
        if (this._$$followLeadMap != null) goto L46;
        this._$$followLeadMap = $defaultValue_followLeadMap$();
        return;
    }

    public final Map<String, Boolean> $defaultValue_followLeadMap$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.link.model.z4
    public final Map<String, Boolean> getFollowLeadMap() {
        return this._$$followLeadMap;
    }
}
