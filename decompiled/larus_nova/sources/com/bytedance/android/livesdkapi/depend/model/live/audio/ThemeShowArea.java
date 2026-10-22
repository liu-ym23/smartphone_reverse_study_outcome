package com.bytedance.android.livesdkapi.depend.model.live.audio;

import am3.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.ShowArea")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0003:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0004J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001e\u0010\u0011\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/ThemeShowArea;", "Landroid/os/Parcelable;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "()V", "h", "", "getH", "()J", "setH", "(J)V", "w", "getW", "setW", "x", "getX", "setX", "y", "getY", "setY", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ThemeShowArea extends FlexModelBase<IThemeShowArea> implements Parcelable, IThemeShowArea, h {
    public static final Parcelable.Creator<ThemeShowArea> CREATOR = null;
    public static final Companion Companion = null;
    public static final int MAGNIFICATION = 100000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("h")
    protected long f162611h;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @SerializedName("w")
    protected long f162612w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    protected long f162613x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    protected long f162614y;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/ThemeShowArea$Companion;", "", "()V", "MAGNIFICATION", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static class Creator implements Parcelable.Creator<ThemeShowArea> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ThemeShowArea createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            if (r100.readInt() != 0) goto L7;
            return null;
        L7:
            return new ThemeShowArea();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ThemeShowArea[] newArray(int r100) {
            return new ThemeShowArea[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ThemeShowArea createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ThemeShowArea[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        Companion = new Companion(null);
        CREATOR = new Creator();
    }

    public ThemeShowArea() {
        super(IThemeShowArea.class);
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

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea, com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    public long getH() {
        return this.f162611h;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea, com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    public long getW() {
        return this.f162612w;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea, com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    public long getX() {
        return this.f162613x;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea, com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    public long getY() {
        return this.f162614y;
    }

    public ThemeShowArea(g r100) {
        super(IThemeShowArea.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.f162613x = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.f162614y = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.f162611h = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.f162612w = r100.j();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setH(long r100) {
        this.f162611h = r100;
    }

    public void setW(long r100) {
        this.f162612w = r100;
    }

    public void setX(long r100) {
        this.f162613x = r100;
    }

    public void setY(long r100) {
        this.f162614y = r100;
    }
}
