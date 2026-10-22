package com.bytedance.android.live.revlink.impl.settings.opt.model;

import a51.c;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/opt/model/RevLinkJankOptConfigSerializableObjectImpl;", "La51/c;", "", "seiOpt", "Z", "a9", "()Z", "multiSeiOpt", "B6", "pkMvpListOpt", "e7", "pkMvpListOptV2", "getPkMvpListOptV2", "multiAnchorTitleOpt", "t5", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkJankOptConfigSerializableObjectImpl implements c {

    @SerializedName("multi_anchor_title_opt")
    private final boolean multiAnchorTitleOpt;

    @SerializedName("multi_sei_opt")
    private final boolean multiSeiOpt;

    @SerializedName("pk_mvp_list_opt")
    private final boolean pkMvpListOpt;

    @SerializedName("pk_mvp_list_opt_v2")
    private final boolean pkMvpListOptV2;

    @SerializedName("sei_opt")
    private final boolean seiOpt;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/opt/model/RevLinkJankOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevLinkJankOptConfigSerializableObjectImpl.class);
        }
    }

    public RevLinkJankOptConfigSerializableObjectImpl() {
        this.seiOpt = false;
        this.multiSeiOpt = false;
        this.pkMvpListOpt = false;
        this.pkMvpListOptV2 = false;
        this.multiAnchorTitleOpt = false;
    }

    @Override // a51.c
    public final boolean B6() {
        return this.multiSeiOpt;
    }

    @Override // a51.c
    public final boolean a9() {
        return this.seiOpt;
    }

    @Override // a51.c
    public final boolean e7() {
        return this.pkMvpListOpt;
    }

    @Override // a51.c
    public final boolean t5() {
        return this.multiAnchorTitleOpt;
    }
}
