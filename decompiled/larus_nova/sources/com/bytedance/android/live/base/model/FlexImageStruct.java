package com.bytedance.android.live.base.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.im.FlexImageStruct")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002:\u0001 B\u0011\b\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dB\t\b\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016J\u001a\u0010\u000f\u001a\u00020\t2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016R \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R,\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/base/model/FlexImageStruct;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/i;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "", "", "getUrlList", "urlList", "setUrlList", "getUri", "Ljava/util/List;", "uri", "Ljava/lang/String;", "", "", "flexSetting", "getFlexSetting", "()Ljava/util/List;", "setFlexSetting", "(Ljava/util/List;)V", "in", "<init>", "(Landroid/os/Parcel;)V", "()V", "Companion", "b", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FlexImageStruct extends FlexModelBase<py.i> implements Parcelable, py.i, vh7.h {
    public static final Parcelable.Creator<FlexImageStruct> CREATOR = null;
    public static final b Companion = null;

    @SerializedName("flex_setting")
    protected List<Long> flexSetting;

    @SerializedName("uri")
    public String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    public List<String> urlList;

    public static final class a implements Parcelable.Creator<FlexImageStruct> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FlexImageStruct createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new FlexImageStruct(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final FlexImageStruct[] newArray(int r100) {
            return new FlexImageStruct[r100];
        }
    }

    public static final class b {
        public b() {
        }
    }

    public FlexImageStruct() {
        super(py.i.class);
    }

    public FlexImageStruct(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "in");
        super(py.i.class);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public final List<Long> getFlexSetting() {
        return this.flexSetting;
    }

    @Override // py.i
    public String getUri() {
        return this.uri;
    }

    @Override // py.i
    public List<String> getUrlList() {
        return this.urlList;
    }

    public FlexImageStruct(am3.g r100) {
        super(py.i.class);
        this.urlList = new ArrayList();
        this.flexSetting = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 == 1) goto L14;
        if (r102 != 2) goto L10;
        this.uri = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        List r104 = this.flexSetting;
        Comparable r105 = Long.valueOf(r100.j());
    L15:
        r104.add(r105);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r104 = this.urlList;
        r105 = am3.h.c(r100);
        goto L15
    L16:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setFlexSetting(List<Long> r100) {
        this.flexSetting = r100;
    }

    @Override // py.i
    public void setUrlList(List<String> r100) {
        this.urlList = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeStringList(this.urlList);
        r100.writeString(this.uri);
        r100.writeList(this.flexSetting);
    }
}
