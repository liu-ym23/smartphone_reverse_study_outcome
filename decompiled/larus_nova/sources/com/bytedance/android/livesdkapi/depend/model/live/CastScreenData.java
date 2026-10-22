package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.CastScreenData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR \u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/CastScreenData;", "", "()V", "allowDeviceList", "", "", "getAllowDeviceList", "()Ljava/util/List;", "setAllowDeviceList", "(Ljava/util/List;)V", "forceCastOnly", "", "getForceCastOnly", "()Ljava/lang/Integer;", "setForceCastOnly", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "permission", "Lcom/bytedance/android/livesdkapi/depend/model/live/CastOttPermission;", "getPermission", "()Lcom/bytedance/android/livesdkapi/depend/model/live/CastOttPermission;", "setPermission", "(Lcom/bytedance/android/livesdkapi/depend/model/live/CastOttPermission;)V", b.C, "getSdkVersion", "setSdkVersion", "xsgShowTips", "", "getXsgShowTips", "()Ljava/lang/String;", "setXsgShowTips", "(Ljava/lang/String;)V", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CastScreenData implements h {
    public static final Companion Companion = null;
    public static final long DEVICE_UNKNOWN = 0;
    public static final long DEVICE_XIGUA_TV = 1;

    @SerializedName("allow_list")
    protected List<Long> allowDeviceList;

    @SerializedName("force_cast_only")
    protected Integer forceCastOnly;

    @SerializedName("permission")
    protected CastOttPermission permission;

    @SerializedName("sdk_version")
    protected Integer sdkVersion;

    @SerializedName("show_text")
    protected String xsgShowTips;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/CastScreenData$Companion;", "", "()V", "DEVICE_UNKNOWN", "", "DEVICE_XIGUA_TV", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public CastScreenData() {
        this.xsgShowTips = "";
        this.allowDeviceList = CollectionsKt.emptyList();
        this.sdkVersion = 0;
        this.forceCastOnly = 0;
    }

    public final List<Long> getAllowDeviceList() {
        return this.allowDeviceList;
    }

    public final Integer getForceCastOnly() {
        return this.forceCastOnly;
    }

    public final CastOttPermission getPermission() {
        return this.permission;
    }

    public final Integer getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getXsgShowTips() {
        return this.xsgShowTips;
    }

    public CastScreenData(g r100) {
        this.allowDeviceList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.xsgShowTips = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.allowDeviceList.add(Long.valueOf(r100.j()));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.sdkVersion = Integer.valueOf(r100.i());
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.permission = new CastOttPermission(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.forceCastOnly = Integer.valueOf(r100.i());
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.xsgShowTips != null) goto L25;
        this.xsgShowTips = "";
    L25:
        if (this.allowDeviceList.isEmpty() == false) goto L28;
        this.allowDeviceList = CollectionsKt.emptyList();
    L28:
        if (this.sdkVersion != null) goto L31;
        this.sdkVersion = 0;
    L31:
        if (this.forceCastOnly != null) goto L52;
        this.forceCastOnly = 0;
        return;
    }

    public final void setAllowDeviceList(List<Long> r100) {
        this.allowDeviceList = r100;
    }

    public final void setForceCastOnly(Integer r100) {
        this.forceCastOnly = r100;
    }

    public final void setPermission(CastOttPermission r100) {
        this.permission = r100;
    }

    public final void setSdkVersion(Integer r100) {
        this.sdkVersion = r100;
    }

    public final void setXsgShowTips(String r100) {
        this.xsgShowTips = r100;
    }
}
