package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.d9;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001 B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/KtvDressSyncData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/message/IKtvDressSyncData;", "()V", "_singerId", "", "get_singerId", "()J", "set_singerId", "(J)V", "_singerOpenId", "", "get_singerOpenId", "()Ljava/lang/String;", "set_singerOpenId", "(Ljava/lang/String;)V", "dressInfo", "Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", "getDressInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", "setDressInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;)V", "value", "singerIdString", "getSingerIdString", "setSingerIdString", "songId", "getSongId", "()Ljava/lang/Long;", "setSongId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvDressSyncData extends FlexModelBase<IKtvDressSyncData> implements IKtvDressSyncData, h {
    public static final Companion Companion = null;
    public static final String SYNC_KEY = "KtvDressSyncData";

    @SerializedName("singer_id")
    protected long _singerId;

    @SerializedName("singer_open_id")
    protected String _singerOpenId;

    @SerializedName("dress_info")
    protected MidiSkinDressInfo dressInfo;

    @SerializedName("song_id")
    protected Long songId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/KtvDressSyncData$Companion;", "", "()V", "SYNC_KEY", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KtvDressSyncData() {
        super(IKtvDressSyncData.class);
        this.songId = 0L;
        this._singerOpenId = "";
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IKtvDressSyncData
    public String getSingerIdString() {
        return d9.c(Long.valueOf(this._singerId), this._singerOpenId);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IKtvDressSyncData
    public /* bridge */ /* synthetic */ IMidiSkinDressInfo getDressInfo() {
        return getDressInfo();
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IKtvDressSyncData
    public Long getSongId() {
        return this.songId;
    }

    public final long get_singerId() {
        return this._singerId;
    }

    public final String get_singerOpenId() {
        return this._singerOpenId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IKtvDressSyncData
    public MidiSkinDressInfo getDressInfo() {
        return this.dressInfo;
    }

    public KtvDressSyncData(g r100) {
        super(IKtvDressSyncData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.dressInfo = new MidiSkinDressInfo(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.songId = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._singerId = r100.j();
        goto L3
    L12:
        if (r102 != 5000) goto L13;
        this._singerOpenId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if (this.songId != null) goto L22;
        this.songId = 0L;
    L22:
        if (this._singerOpenId != null) goto L40;
        this._singerOpenId = "";
        return;
    }

    public void setDressInfo(MidiSkinDressInfo r100) {
        this.dressInfo = r100;
    }

    public void setSingerIdString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        d9.b(r100, new KtvDressSyncData$singerIdString$1(this), new KtvDressSyncData$singerIdString$2(this));
    }

    public void setSongId(Long r100) {
        this.songId = r100;
    }

    public final void set_singerId(long r100) {
        this._singerId = r100;
    }

    public final void set_singerOpenId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this._singerOpenId = r100;
    }
}
