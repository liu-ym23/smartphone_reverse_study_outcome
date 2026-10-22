package com.bytedance.android.gamecp.host_api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.GameImage")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0017\u0018\u0000 12\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b/\u00100J\u0012\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005HÖ\u0001R,\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R$\u0010(\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010+\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R$\u0010.\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'¨\u00063"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/ImageModel;", "Lcom/bytedance/android/gamecp/host_api/model/IImageModel;", "", "", "getUrlList", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "urls", "Ljava/util/List;", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "uri", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "", "_width", "J", "_height", "_rotation", "", "isLoaded", "Z", "()Z", "setLoaded", "(Z)V", "value", "getWidth", "()I", "setWidth", "(I)V", "width", "getHeight", "setHeight", "height", "getRotation", "setRotation", "rotation", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ImageModel implements IImageModel, vh7.h {
    public static final Parcelable.Creator<ImageModel> CREATOR = null;
    public static final a Companion = null;

    @SerializedName("height")
    protected long _height;

    @IgnoreProtoFieldCheck
    @SerializedName("rotation")
    protected long _rotation;

    @SerializedName("width")
    protected long _width;
    private boolean isLoaded;

    @SerializedName("uri")
    protected String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    protected List<String> urls;

    public static final class a {
        public a() {
        }
    }

    public static class b implements Parcelable.Creator<ImageModel> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImageModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            if (r100.readInt() != 0) goto L7;
            return null;
        L7:
            return new ImageModel();
        }

        @Override // android.os.Parcelable.Creator
        public final ImageModel[] newArray(int r100) {
            return new ImageModel[r100];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public ImageModel() {
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

    public final int getHeight() {
        return (int) this._height;
    }

    public final int getRotation() {
        return (int) this._rotation;
    }

    public final int getWidth() {
        return (int) this._width;
    }

    public final String getUri() {
        return this.uri;
    }

    public List<String> getUrlList() {
        return this.urls;
    }

    public final List<String> getUrls() {
        return this.urls;
    }

    public final boolean isLoaded() {
        return this.isLoaded;
    }

    public ImageModel(am3.g r100) {
        this.urls = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.urls.add(am3.h.c(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.uri = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._height = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._width = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._rotation = r100.j();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setHeight(int r100) {
        this._height = r100;
    }

    public final void setLoaded(boolean r100) {
        this.isLoaded = r100;
    }

    public final void setRotation(int r100) {
        this._rotation = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setUrls(List<String> r100) {
        this.urls = r100;
    }

    public final void setWidth(int r100) {
        this._width = r100;
    }
}
