package com.bytedance.ai.applet.components.page;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.applet.render.core.RenderType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedance/ai/applet/components/page/RenderUrlData;", "Landroid/os/Parcelable;", "renderType", "Lcom/bytedance/ai/applet/render/core/RenderType;", "transStatusBar", "", "hideNavBar", "url", "", "queryItems", "", "<init>", "(Lcom/bytedance/ai/applet/render/core/RenderType;ZZLjava/lang/String;Ljava/util/Map;)V", "getRenderType", "()Lcom/bytedance/ai/applet/render/core/RenderType;", "getTransStatusBar", "()Z", "getHideNavBar", "getUrl", "()Ljava/lang/String;", "getQueryItems", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderUrlData implements Parcelable {
    public static final Parcelable.Creator<RenderUrlData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RenderType f34550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f34551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f34553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f34554e;

    public static final class a implements Parcelable.Creator<RenderUrlData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RenderUrlData createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            RenderType r100 = RenderType.valueOf(r110.readString());
            int r101 = 0;
            if (r110.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r103 = true;
        L10:
            String r104 = r110.readString();
            int r105 = r110.readInt();
            LinkedHashMap r106 = new LinkedHashMap(r105);
        L11:
            if (r101 == r105) goto L14;
            r106.put(r110.readString(), r110.readString());
            r101 = r101 + 1;
            goto L11
        L14:
            return new RenderUrlData(r100, r102, r103, r104, r106);
        L9:
            r103 = false;
            goto L10
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final RenderUrlData[] newArray(int r100) {
            return new RenderUrlData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RenderUrlData) == true) goto L8;
        return false;
    L8:
        RenderUrlData r101 = (RenderUrlData) r100;
        if (this.f34550a == r101.f34550a) goto L12;
        return false;
    L12:
        if (this.f34551b == r101.f34551b) goto L15;
        return false;
    L15:
        if (this.f34552c == r101.f34552c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34553d, r101.f34553d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f34554e, r101.f34554e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f34550a.hashCode() * 31;
        int r101 = 1231;
        if (this.f34551b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f34552c == true) goto L11;
        r101 = 1237;
    L11:
        return ((((r103 + r101) * 31) + this.f34553d.hashCode()) * 31) + this.f34554e.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "RenderUrlData(renderType=" + this.f34550a + ", transStatusBar=" + this.f34551b + ", hideNavBar=" + this.f34552c + ", url=" + this.f34553d + ", queryItems=" + this.f34554e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f34550a.name());
        r100.writeInt(this.f34551b ? 1 : 0);
        r100.writeInt(this.f34552c ? 1 : 0);
        r100.writeString(this.f34553d);
        Map<String, String> r102 = this.f34554e;
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, String> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeString(r104.getValue());
        goto L4
    }

    public RenderUrlData(RenderType r100, boolean r101, boolean r102, String r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "renderType");
        Intrinsics.checkNotNullParameter(r103, "url");
        Intrinsics.checkNotNullParameter(r104, "queryItems");
        this.f34550a = r100;
        this.f34551b = r101;
        this.f34552c = r102;
        this.f34553d = r103;
        this.f34554e = r104;
    }
}
