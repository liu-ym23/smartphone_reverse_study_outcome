package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BorderInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0003\u0018\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBorderInfo;", "", "()V", "borderType", "", "getBorderType", "()J", "setBorderType", "(J)V", "duration", "getDuration", "setDuration", "dynamicBorderInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBorderInfo$DynamicBorderInfo;", "getDynamicBorderInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBorderInfo$DynamicBorderInfo;", "setDynamicBorderInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBorderInfo$DynamicBorderInfo;)V", "staticBorderInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBorderInfo$StaticBorderInfo;", "getStaticBorderInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBorderInfo$StaticBorderInfo;", "setStaticBorderInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBorderInfo$StaticBorderInfo;)V", "Companion", "DynamicBorderInfo", "StaticBorderInfo", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomBorderInfo implements h {
    public static final long BORDER_TYPE_DYNAMIC_BORDER = 2;
    public static final long BORDER_TYPE_STATIC_BORDER = 1;
    public static final long BORDER_TYPE_UNDEFINED = 0;
    public static final Companion Companion = null;

    @SerializedName("border_type")
    protected long borderType;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("dynamic_border")
    protected DynamicBorderInfo dynamicBorderInfo;

    @SerializedName("static_border")
    protected StaticBorderInfo staticBorderInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBorderInfo$Companion;", "", "()V", "BORDER_TYPE_DYNAMIC_BORDER", "", "BORDER_TYPE_STATIC_BORDER", "BORDER_TYPE_UNDEFINED", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @ProtoMessage("webcast.data.DynamicBorderInfo")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBorderInfo$DynamicBorderInfo;", "", "()V", "assetId", "", "getAssetId", "()J", "setAssetId", "(J)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DynamicBorderInfo implements h {

        @SerializedName("id")
        protected long assetId;

        public DynamicBorderInfo() {
        }

        public final long getAssetId() {
            return this.assetId;
        }

        public DynamicBorderInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.assetId = r100.j();
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }

        public final void setAssetId(long r100) {
            this.assetId = r100;
        }
    }

    @ProtoMessage("webcast.data.StaticBorderInfo")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBorderInfo$StaticBorderInfo;", "", "()V", "bottom", "Lcom/bytedance/android/live/base/model/ImageModel;", "getBottom", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setBottom", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "left", "getLeft", "setLeft", "right", "getRight", "setRight", "top", "getTop", "setTop", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StaticBorderInfo implements h {

        @SerializedName("bottom")
        protected ImageModel bottom;

        @SerializedName("left")
        protected ImageModel left;

        @SerializedName("right")
        protected ImageModel right;

        @SerializedName("top")
        protected ImageModel top;

        public StaticBorderInfo() {
        }

        public StaticBorderInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.top = x.a(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.bottom = x.a(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.left = x.a(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.right = x.a(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }

        public final ImageModel getBottom() {
            return this.bottom;
        }

        public final ImageModel getLeft() {
            return this.left;
        }

        public final ImageModel getRight() {
            return this.right;
        }

        public final ImageModel getTop() {
            return this.top;
        }

        public final void setBottom(ImageModel r100) {
            this.bottom = r100;
        }

        public final void setLeft(ImageModel r100) {
            this.left = r100;
        }

        public final void setRight(ImageModel r100) {
            this.right = r100;
        }

        public final void setTop(ImageModel r100) {
            this.top = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RoomBorderInfo() {
        this.staticBorderInfo = new StaticBorderInfo();
        this.dynamicBorderInfo = new DynamicBorderInfo();
    }

    public final long getBorderType() {
        return this.borderType;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final DynamicBorderInfo getDynamicBorderInfo() {
        return this.dynamicBorderInfo;
    }

    public final StaticBorderInfo getStaticBorderInfo() {
        return this.staticBorderInfo;
    }

    public RoomBorderInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.borderType = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.staticBorderInfo = new StaticBorderInfo(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.dynamicBorderInfo = new DynamicBorderInfo(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.duration = r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.staticBorderInfo != null) goto L22;
        this.staticBorderInfo = new StaticBorderInfo();
    L22:
        if (this.dynamicBorderInfo != null) goto L40;
        this.dynamicBorderInfo = new DynamicBorderInfo();
        return;
    }

    public final void setBorderType(long r100) {
        this.borderType = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setDynamicBorderInfo(DynamicBorderInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dynamicBorderInfo = r100;
    }

    public final void setStaticBorderInfo(StaticBorderInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.staticBorderInfo = r100;
    }
}
