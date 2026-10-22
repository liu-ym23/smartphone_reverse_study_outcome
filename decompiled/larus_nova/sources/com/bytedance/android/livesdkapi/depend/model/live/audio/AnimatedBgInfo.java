package com.bytedance.android.livesdkapi.depend.model.live.audio;

import am3.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0003B\u0007¢\u0006\u0004\b \u0010!J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004HÖ\u0001R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/AnimatedBgInfo;", "Landroid/os/Parcelable;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAnimatedBgInfo;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "themeShowArea", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "getThemeShowArea", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "setThemeShowArea", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;)V", "Lpy/k;", "animatedBg", "Lpy/k;", "getAnimatedBg", "()Lpy/k;", "setAnimatedBg", "(Lpy/k;)V", "", "fileFormat", "Ljava/lang/String;", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnimatedBgInfo extends FlexModelBase<IAnimatedBgInfo> implements Parcelable, IAnimatedBgInfo, h {
    public static final Parcelable.Creator<AnimatedBgInfo> CREATOR = null;

    @SerializedName("animatedBg")
    protected k animatedBg;

    @SerializedName("fileFormat")
    protected String fileFormat;

    @SerializedName("showArea")
    protected IThemeShowArea themeShowArea;

    @Metadata(k = 3, mv = {1, 5, 1})
    public static class Creator implements Parcelable.Creator<AnimatedBgInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AnimatedBgInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            if (r100.readInt() != 0) goto L7;
            return null;
        L7:
            return new AnimatedBgInfo();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AnimatedBgInfo[] newArray(int r100) {
            return new AnimatedBgInfo[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AnimatedBgInfo createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AnimatedBgInfo[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public AnimatedBgInfo() {
        super(IAnimatedBgInfo.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea, java.lang.Object] */
    public AnimatedBgInfo(g r100) {
        super(IAnimatedBgInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.themeShowArea = f.a(r100, IThemeShowArea.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.fileFormat = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.animatedBg = f.a(r100, k.class);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(1);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo, com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfoDef
    public k getAnimatedBg() {
        return this.animatedBg;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo, com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfoDef
    public String getFileFormat() {
        return this.fileFormat;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo, com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfoDef
    public IThemeShowArea getThemeShowArea() {
        return this.themeShowArea;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo, com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfoDef
    public void setAnimatedBg(k r100) {
        this.animatedBg = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo, com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfoDef
    public void setFileFormat(String r100) {
        this.fileFormat = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo, com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfoDef
    public void setThemeShowArea(IThemeShowArea r100) {
        this.themeShowArea = r100;
    }
}
