package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.User.AnchorInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/base/model/user/AnchorInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/b;", "", "o", "", "equals", "", "hashCode", "", "level", "J", "getLevel", "()J", "setLevel", "(J)V", "type", "getType", "setType", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorInfo extends FlexModelBase<py.b> implements py.b, vh7.h {
    public static final a Companion = null;

    @SerializedName("level")
    protected long level;

    @IgnoreProtoFieldCheck
    @SerializedName("type")
    private long type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AnchorInfo() {
        super(py.b.class);
    }

    public int hashCode() {
        int r100 = ((int) (getLevel() ^ (getLevel() >>> 32))) * 31;
        long r101 = this.type;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    @Override // py.b
    public long getLevel() {
        return this.level;
    }

    public final long getType() {
        return this.type;
    }

    public AnchorInfo(am3.g r100) {
        super(py.b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.level = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L16:
        return false;
    L8:
        if ((!Intrinsics.areEqual(AnchorInfo.class, r100.getClass())) == true) goto L16;
        AnchorInfo r101 = (AnchorInfo) r100;
        if (getLevel() == r101.getLevel()) goto L14;
    L12:
        return false;
    L14:
        if (this.type != r101.type) goto L12;
        return true;
    }

    @Override // py.b
    public void setLevel(long r100) {
        this.level = r100;
    }

    public final void setType(long r100) {
        this.type = r100;
    }
}
