package com.bytedance.android.live.schema.vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\tR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/schema/vo/WebHybridParamVo;", "Landroid/os/Parcelable;", "", AppConstants.BUNDLE_REFERER, "Ljava/lang/String;", "getReferer", "()Ljava/lang/String;", "setReferer", "(Ljava/lang/String;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WebHybridParamVo implements Parcelable {
    public static final Parcelable.Creator<WebHybridParamVo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f100550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f100551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f100552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f100553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f100554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f100555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f100556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BaseHybridParamVo f100557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f100558i;

    @SerializedName(AppConstants.BUNDLE_REFERER)
    private String referer;

    public static final class a {
    }

    public static class b implements Parcelable.Creator<WebHybridParamVo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final WebHybridParamVo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            int r100 = r110.readInt();
            if (r110.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r102 = true;
        L11:
            if (r110.readInt() == 0) goto L13;
            boolean r103 = true;
        L14:
            String r104 = r110.readString();
            if (r110.readInt() == 0) goto L17;
            boolean r105 = true;
        L19:
            if (r110.readInt() == 0) goto L21;
            boolean r111 = true;
        L22:
            String r112 = r110.readString();
            if (r110.readInt() == 0) goto L25;
            BaseHybridParamVo r106 = BaseHybridParamVo.CREATOR.createFromParcel(r110);
        L26:
            BaseHybridParamVo r113 = r106;
            if (r110.readInt() == 0) goto L29;
            boolean r114 = true;
        L31:
            return new WebHybridParamVo(r100, r101, r102, r103, r104, r105, r111, r112, r113, r114);
        L29:
            r114 = false;
            goto L31
        L25:
            r106 = null;
            goto L26
        L21:
            r111 = false;
            goto L22
        L17:
            r105 = false;
            goto L19
        L13:
            r103 = false;
            goto L14
        L9:
            r102 = false;
            goto L11
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final WebHybridParamVo[] newArray(int r100) {
            return new WebHybridParamVo[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f100550a);
        r100.writeInt(this.f100551b ? 1 : 0);
        r100.writeInt(this.f100552c ? 1 : 0);
        r100.writeInt(this.f100553d ? 1 : 0);
        r100.writeString(this.f100554e);
        r100.writeInt(this.f100555f ? 1 : 0);
        r100.writeInt(this.f100556g ? 1 : 0);
        r100.writeString(this.referer);
        BaseHybridParamVo r102 = this.f100557h;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r102.writeToParcel(r100, 0);
    L6:
        r100.writeInt(this.f100558i ? 1 : 0);
        return;
    L5:
        r100.writeInt(0);
        goto L6
    }

    public final String toString() {
        return "WebHybridParamVo(saleShowStatus=" + this.f100550a + ", noHardwareAccelerated=" + this.f100551b + ", enableAppCache=" + this.f100552c + ", useReceivedTitle=" + this.f100553d + ", headStr=" + this.f100554e + ", loadNoCache=" + this.f100555f + ", OfflineEnable=" + this.f100556g + ", referer=" + this.referer + ", commonHybridParam=" + this.f100557h + ')';
    }

    public WebHybridParamVo(int r100, boolean r101, boolean r102, boolean r103, String r104, boolean r105, boolean r106, String r107, BaseHybridParamVo r108, boolean r110) {
        this.f100550a = r100;
        this.f100551b = r101;
        this.f100552c = r102;
        this.f100553d = r103;
        this.f100554e = r104;
        this.f100555f = r105;
        this.f100556g = r106;
        this.referer = r107;
        this.f100557h = r108;
        this.f100558i = r110;
    }
}
