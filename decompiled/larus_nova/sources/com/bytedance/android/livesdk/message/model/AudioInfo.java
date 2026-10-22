package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\nR\"\u0010\u001d\u001a\u00020\u001c8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u001c8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R$\u0010&\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\n¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/AudioInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/m6;", "", "toString", "mUrl", "Ljava/lang/String;", "getMUrl", "()Ljava/lang/String;", "setMUrl", "(Ljava/lang/String;)V", "", "mSongPattern", "I", "getMSongPattern", "()I", "setMSongPattern", "(I)V", "", "mAudioId", "J", "getMAudioId", "()J", "setMAudioId", "(J)V", "audioIdStr", "getAudioIdStr", "setAudioIdStr", "", "volumeLufs", "D", "getVolumeLufs", "()D", "setVolumeLufs", "(D)V", "volumePeak", "getVolumePeak", "setVolumePeak", "fileHash", "getFileHash", "setFileHash", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioInfo extends FlexModelBase<m6> implements m6, vh7.h {

    @SerializedName("audio_id_str")
    protected String audioIdStr;

    @SerializedName(BarrageMaskInfo.KEY_MASK_FILE_HASH)
    protected String fileHash;

    @SerializedName("audio_id")
    protected long mAudioId;

    @SerializedName("song_patten")
    protected int mSongPattern;

    @SerializedName("url")
    protected String mUrl;

    @SerializedName("volume_lufs")
    protected double volumeLufs;

    @SerializedName("volume_peak")
    protected double volumePeak;

    public AudioInfo() {
        super(m6.class);
        this.mUrl = "";
        this.mSongPattern = 2;
        this.audioIdStr = "";
        this.fileHash = "";
    }

    public String toString() {
        return "url=" + getMUrl() + ",audio_id=" + getMAudioId();
    }

    @Override // com.bytedance.android.livesdk.message.model.m6
    public String getAudioIdStr() {
        return this.audioIdStr;
    }

    @Override // com.bytedance.android.livesdk.message.model.m6
    public String getFileHash() {
        return this.fileHash;
    }

    @Override // com.bytedance.android.livesdk.message.model.m6
    public long getMAudioId() {
        return this.mAudioId;
    }

    @Override // com.bytedance.android.livesdk.message.model.m6
    public int getMSongPattern() {
        return this.mSongPattern;
    }

    @Override // com.bytedance.android.livesdk.message.model.m6
    public String getMUrl() {
        return this.mUrl;
    }

    @Override // com.bytedance.android.livesdk.message.model.m6
    public double getVolumeLufs() {
        return this.volumeLufs;
    }

    @Override // com.bytedance.android.livesdk.message.model.m6
    public double getVolumePeak() {
        return this.volumePeak;
    }

    public AudioInfo(am3.g r100) {
        super(m6.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L26;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this.mUrl = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.mSongPattern = (int) r100.j();
        r101 = r101 | true;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.mAudioId = r100.j();
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.volumeLufs = Double.longBitsToDouble(r100.h());
        goto L3
    L13:
        if (r103 != 5) goto L15;
        this.volumePeak = Double.longBitsToDouble(r100.h());
        goto L3
    L15:
        if (r103 != 9) goto L17;
        this.fileHash = am3.h.c(r100);
        goto L3
    L17:
        if (r103 != 10) goto L18;
        this.audioIdStr = am3.h.c(r100);
        goto L3
    L18:
        am3.h.d(r104, r100);
        goto L3
    L26:
        r100.d(r102);
        setThreadSafe(true);
        if (this.mUrl != null) goto L30;
        this.mUrl = "";
    L30:
        if ((r101 & true) == true) goto L33;
        this.mSongPattern = 2;
    L33:
        if (this.audioIdStr != null) goto L36;
        this.audioIdStr = "";
    L36:
        if (this.fileHash != null) goto L63;
        this.fileHash = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.message.model.m6
    public void setAudioIdStr(String r100) {
        this.audioIdStr = r100;
    }

    public void setFileHash(String r100) {
        this.fileHash = r100;
    }

    public void setMAudioId(long r100) {
        this.mAudioId = r100;
    }

    public void setMSongPattern(int r100) {
        this.mSongPattern = r100;
    }

    public void setMUrl(String r100) {
        this.mUrl = r100;
    }

    public void setVolumeLufs(double r100) {
        this.volumeLufs = r100;
    }

    public void setVolumePeak(double r100) {
        this.volumePeak = r100;
    }
}
