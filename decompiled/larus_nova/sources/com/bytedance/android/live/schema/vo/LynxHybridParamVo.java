package com.bytedance.android.live.schema.vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/schema/vo/LynxHybridParamVo;", "Landroid/os/Parcelable;", "", "fallbackSchema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setFallbackSchema", "(Ljava/lang/String;)V", "", "lynxThreadStrategy", "I", "c", "()I", "setLynxThreadStrategy", "(I)V", "", "isEnableLynxBg", "Z", "d", "()Z", "setEnableLynxBg", "(Z)V", "abandonCoordinate", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAbandonCoordinate", "isSlideCenter", "e", "setSlideCenter", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxHybridParamVo implements Parcelable {
    public static final Parcelable.Creator<LynxHybridParamVo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f100535a;

    @SerializedName(AppConstants.ARG_ABANDON_COORDINATE)
    private boolean abandonCoordinate;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseHybridParamVo f100536b;

    @SerializedName("fallback_url")
    private String fallbackSchema;

    @SerializedName("enable_lynx_bg")
    private boolean isEnableLynxBg;

    @SerializedName(AppConstants.BUNDLE_IS_SLIDE_CENTER)
    private boolean isSlideCenter;

    @SerializedName("lynx_thread")
    private int lynxThreadStrategy;

    public static class a implements Parcelable.Creator<LynxHybridParamVo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LynxHybridParamVo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            String r100 = r110.readString();
            int r101 = r110.readInt();
            if (r110.readInt() == 0) goto L5;
            boolean r102 = true;
        L6:
            int r103 = r110.readInt();
            if (r110.readInt() == 0) goto L9;
            boolean r104 = true;
        L11:
            if (r110.readInt() == 0) goto L13;
            boolean r105 = true;
        L15:
            if (r110.readInt() == 0) goto L17;
            BaseHybridParamVo r111 = BaseHybridParamVo.CREATOR.createFromParcel(r110);
        L19:
            return new LynxHybridParamVo(r100, r101, r102, r103, r104, r105, r111);
        L17:
            r111 = null;
            goto L19
        L13:
            r105 = false;
            goto L15
        L9:
            r104 = false;
            goto L11
        L5:
            r102 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final LynxHybridParamVo[] newArray(int r100) {
            return new LynxHybridParamVo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public LynxHybridParamVo() {
        this(null, 0, false, false, false, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.fallbackSchema);
        r100.writeInt(this.lynxThreadStrategy);
        r100.writeInt(this.isEnableLynxBg ? 1 : 0);
        r100.writeInt(this.f100535a);
        r100.writeInt(this.abandonCoordinate ? 1 : 0);
        r100.writeInt(this.isSlideCenter ? 1 : 0);
        BaseHybridParamVo r102 = this.f100536b;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r102.writeToParcel(r100, 0);
        return;
    L5:
        r100.writeInt(0);
    }

    public final String toString() {
        return "LynxHybridParamVo(fallbackSchema=" + this.fallbackSchema + ", lynxThreadStrategy=" + this.lynxThreadStrategy + ", isEnableLynxBg=" + this.isEnableLynxBg + ", presetWidth=" + this.f100535a + ", commonHybridParam=" + this.f100536b;
    }

    public final boolean a() {
        return this.abandonCoordinate;
    }

    public final String b() {
        return this.fallbackSchema;
    }

    public final int c() {
        return this.lynxThreadStrategy;
    }

    public final boolean d() {
        return this.isEnableLynxBg;
    }

    public final boolean e() {
        return this.isSlideCenter;
    }

    public /* synthetic */ LynxHybridParamVo(String r100, int r110, boolean r111, boolean r112, boolean r113, BaseHybridParamVo r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        r100 = "";
    L5:
        String r101 = r100;
        if ((r115 & 2) == 0) goto L8;
        int r102 = 0;
    L10:
        if ((r115 & 4) == 0) goto L12;
        boolean r103 = false;
    L14:
        if ((r115 & 16) == 0) goto L16;
        boolean r104 = false;
    L18:
        if ((r115 & 32) == 0) goto L20;
        boolean r105 = false;
    L22:
        if ((r115 & 64) == 0) goto L24;
        r114 = null;
    L24:
        this(r101, r102, r103, 0, r104, r105, r114);
        return;
    L20:
        r105 = r113;
        goto L22
    L16:
        r104 = r112;
        goto L18
    L12:
        r103 = r111;
        goto L14
    L8:
        r102 = r110;
        goto L10
    }

    public LynxHybridParamVo(String r100, int r101, boolean r102, int r103, boolean r104, boolean r105, BaseHybridParamVo r106) {
        this.fallbackSchema = r100;
        this.lynxThreadStrategy = r101;
        this.isEnableLynxBg = r102;
        this.f100535a = r103;
        this.abandonCoordinate = r104;
        this.isSlideCenter = r105;
        this.f100536b = r106;
    }
}
