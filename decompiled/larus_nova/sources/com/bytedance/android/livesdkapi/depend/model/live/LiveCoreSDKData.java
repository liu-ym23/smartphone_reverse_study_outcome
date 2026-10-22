package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002:\u000b\u001b\u001c\u001d\u001e\u001f !\"#$%B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData;", "Ljava/io/Serializable;", "()V", "pullData", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PullData;", "pushData", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PushData;", "getPushData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PushData;", "setPushData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PushData;)V", "size", "", "getSize", "()Ljava/lang/String;", "setSize", "(Ljava/lang/String;)V", "getDefaultQuality", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$Quality;", "getPullData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPullData;", "getQualityList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "getQualityStrategy", "CameraHorizontalPosition", "Clip", "Display", "Extension", "GameABParams", "Options", "PlayInfo", "PullData", "PushData", "Quality", "ResolutionParams", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCoreSDKData extends FlexModelBase<ILiveCoreSDKData> implements ILiveCoreSDKData, h {

    @SerializedName("pull_data")
    public PullData pullData;

    @SerializedName("push_data")
    protected PushData pushData;

    @SerializedName("size")
    protected String size;

    @ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData.PullData.CameraHorizontalPosition")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0005\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001e\u0010\u0017\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$CameraHorizontalPosition;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$ICameraHorizontalPosition;", "Ljava/io/Serializable;", "()V", "anchor", "", "getAnchor", "()I", "setAnchor", "(I)V", "h", "", "getH", "()F", "setH", "(F)V", "w", "getW", "setW", "x", "getX", "setX", "y", "getY", "setY", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CameraHorizontalPosition extends FlexModelBase<ILiveCoreSDKData.ICameraHorizontalPosition> implements ILiveCoreSDKData.ICameraHorizontalPosition, h {

        @SerializedName("anchor")
        protected int anchor;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @SerializedName("h")
        protected float f162585h;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @SerializedName("w")
        protected float f162586w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        protected float f162587x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        protected float f162588y;

        public CameraHorizontalPosition() {
            super(ILiveCoreSDKData.ICameraHorizontalPosition.class);
            this.anchor = 2;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.ICameraHorizontalPosition
        public int getAnchor() {
            return this.anchor;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.ICameraHorizontalPosition
        public float getH() {
            return this.f162585h;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.ICameraHorizontalPosition
        public float getW() {
            return this.f162586w;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.ICameraHorizontalPosition
        public float getX() {
            return this.f162587x;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.ICameraHorizontalPosition
        public float getY() {
            return this.f162588y;
        }

        public CameraHorizontalPosition(g r100) {
            super(ILiveCoreSDKData.ICameraHorizontalPosition.class);
            boolean r101 = false;
            setThreadSafe(false);
            long r102 = r100.c();
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L20;
            g.a r104 = decodeExtensionFields(r103, r100);
            if (r103 != 1) goto L7;
            this.anchor = r100.i();
            r101 = r101 | true;
            goto L3
        L7:
            if (r103 != 2) goto L9;
            this.f162587x = Float.intBitsToFloat(r100.g());
            goto L3
        L9:
            if (r103 != 3) goto L11;
            this.f162588y = Float.intBitsToFloat(r100.g());
            goto L3
        L11:
            if (r103 != 4) goto L13;
            this.f162586w = Float.intBitsToFloat(r100.g());
            goto L3
        L13:
            if (r103 != 5) goto L14;
            this.f162585h = Float.intBitsToFloat(r100.g());
            goto L3
        L14:
            am3.h.d(r104, r100);
            goto L3
        L20:
            r100.d(r102);
            setThreadSafe(true);
            if ((r101 & true) == true) goto L42;
            this.anchor = 2;
            return;
        }

        public void setAnchor(int r100) {
            this.anchor = r100;
        }

        public void setH(float r100) {
            this.f162585h = r100;
        }

        public void setW(float r100) {
            this.f162586w = r100;
        }

        public void setX(float r100) {
            this.f162587x = r100;
        }

        public void setY(float r100) {
            this.f162588y = r100;
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData.PullData.Clip")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0005\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001e\u0010\u0011\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$Clip;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IClip;", "Ljava/io/Serializable;", "()V", "h", "", "getH", "()F", "setH", "(F)V", "w", "getW", "setW", "x", "getX", "setX", "y", "getY", "setY", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Clip extends FlexModelBase<IClip> implements IClip, h {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @SerializedName("h")
        protected float f162589h;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @SerializedName("w")
        protected float f162590w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        protected float f162591x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        protected float f162592y;

        public Clip() {
            super(IClip.class);
            this.f162590w = 3.0f;
            this.f162589h = 4.0f;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IClip
        public float getH() {
            return this.f162589h;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IClip
        public float getW() {
            return this.f162590w;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IClip
        public float getX() {
            return this.f162591x;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IClip
        public float getY() {
            return this.f162592y;
        }

        public Clip(g r100) {
            super(IClip.class);
            int r101 = 0;
            setThreadSafe(false);
            long r102 = r100.c();
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L17;
            g.a r104 = decodeExtensionFields(r103, r100);
            if (r103 != 1) goto L7;
            this.f162591x = Float.intBitsToFloat(r100.g());
            goto L3
        L7:
            if (r103 != 2) goto L9;
            this.f162592y = Float.intBitsToFloat(r100.g());
            goto L3
        L9:
            if (r103 != 3) goto L11;
            this.f162590w = Float.intBitsToFloat(r100.g());
            r101 = r101 | 1;
            goto L3
        L11:
            if (r103 != 4) goto L12;
            this.f162589h = Float.intBitsToFloat(r100.g());
            r101 = r101 | 2;
            goto L3
        L12:
            am3.h.d(r104, r100);
            goto L3
        L17:
            r100.d(r102);
            setThreadSafe(true);
            if ((r101 & 1) != 0) goto L21;
            this.f162590w = 3.0f;
        L21:
            if ((r101 & 2) != 0) goto L39;
            this.f162589h = 4.0f;
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IClip
        public void setH(float r100) {
            this.f162589h = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IClip
        public void setW(float r100) {
            this.f162590w = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IClip
        public void setX(float r100) {
            this.f162591x = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IClip
        public void setY(float r100) {
            this.f162592y = r100;
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData.PullData.Display")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$Display;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IDisplay;", "Ljava/io/Serializable;", "()V", "scaleHeight", "", "scaleWidth", "getScaleHeight", "getScaleWidth", "toString", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Display extends FlexModelBase<ILiveCoreSDKData.IDisplay> implements ILiveCoreSDKData.IDisplay, h {

        @SerializedName("scale_height")
        public int scaleHeight;

        @SerializedName("scale_width")
        public int scaleWidth;

        public Display() {
            super(ILiveCoreSDKData.IDisplay.class);
        }

        public String toString() {
            return "Display{scaleWidth=" + this.scaleWidth + ", scaleHeight=" + this.scaleHeight + '}';
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IDisplayEx
        public int getScaleHeight() {
            return this.scaleHeight;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IDisplayEx
        public int getScaleWidth() {
            return this.scaleWidth;
        }

        public Display(g r100) {
            super(ILiveCoreSDKData.IDisplay.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.scaleWidth = (int) r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.scaleHeight = (int) r100.j();
            goto L3
        L9:
            am3.h.d(r103, r100);
            goto L3
        L12:
            r100.d(r101);
            setThreadSafe(true);
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData.PullData.Extension")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001e\u0010 \u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010#\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R \u0010&\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR\u001e\u0010)\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R \u0010,\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R \u00105\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$Extension;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;", "Ljava/io/Serializable;", "()V", "cameraClip", "Lcom/bytedance/android/livesdkapi/depend/model/live/IClip;", "getCameraClip", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IClip;", "setCameraClip", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IClip;)V", "cameraClipCustom", "getCameraClipCustom", "setCameraClipCustom", "cameraHidden", "", "getCameraHidden", "()I", "setCameraHidden", "(I)V", "cameraHorizontalHidden", "getCameraHorizontalHidden", "setCameraHorizontalHidden", "cameraHorizontalPosition", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$ICameraHorizontalPosition;", "getCameraHorizontalPosition", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$ICameraHorizontalPosition;", "setCameraHorizontalPosition", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$ICameraHorizontalPosition;)V", "cameraHorizontalType", "getCameraHorizontalType", "setCameraHorizontalType", "cameraVerticalType", "getCameraVerticalType", "setCameraVerticalType", "displayMode", "getDisplayMode", "setDisplayMode", "gameClip", "getGameClip", "setGameClip", "gameHidden", "getGameHidden", "setGameHidden", "gameRoomIdStr", "", "getGameRoomIdStr", "()Ljava/lang/String;", "setGameRoomIdStr", "(Ljava/lang/String;)V", "layout", "getLayout", "setLayout", "multiViewData", "getMultiViewData", "setMultiViewData", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Extension extends FlexModelBase<IExtension> implements IExtension, h {

        @SerializedName("camera_clip")
        protected IClip cameraClip;

        @SerializedName("camera_clip_custom")
        protected IClip cameraClipCustom;

        @SerializedName("camera_hidden")
        protected int cameraHidden;

        @SerializedName("camera_horizontal_hidden")
        protected int cameraHorizontalHidden;

        @SerializedName("camera_horizontal_position")
        protected ILiveCoreSDKData.ICameraHorizontalPosition cameraHorizontalPosition;

        @SerializedName("camera_horizontal_type")
        protected int cameraHorizontalType;

        @SerializedName("camera_vertical_type")
        protected int cameraVerticalType;

        @SerializedName("display_mode")
        protected int displayMode;

        @SerializedName("game_clip")
        protected IClip gameClip;

        @SerializedName("game_hidden")
        protected int gameHidden;

        @SerializedName("game_room_id")
        protected String gameRoomIdStr;

        @SerializedName("layout")
        protected int layout;

        @SerializedName("multi_view_data")
        protected String multiViewData;

        public Extension() {
            super(IExtension.class);
            this.gameRoomIdStr = "";
            this.multiViewData = "";
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public IClip getCameraClip() {
            return this.cameraClip;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public IClip getCameraClipCustom() {
            return this.cameraClipCustom;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public int getCameraHidden() {
            return this.cameraHidden;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public int getCameraHorizontalHidden() {
            return this.cameraHorizontalHidden;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public ILiveCoreSDKData.ICameraHorizontalPosition getCameraHorizontalPosition() {
            return this.cameraHorizontalPosition;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public int getCameraHorizontalType() {
            return this.cameraHorizontalType;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public int getCameraVerticalType() {
            return this.cameraVerticalType;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public int getDisplayMode() {
            return this.displayMode;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public IClip getGameClip() {
            return this.gameClip;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public int getGameHidden() {
            return this.gameHidden;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public String getGameRoomIdStr() {
            return this.gameRoomIdStr;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public int getLayout() {
            return this.layout;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public String getMultiViewData() {
            return this.multiViewData;
        }

        /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.android.livesdkapi.depend.model.live.IClip, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData$ICameraHorizontalPosition, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdkapi.depend.model.live.IClip, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdkapi.depend.model.live.IClip, java.lang.Object] */
        public Extension(g r100) {
            super(IExtension.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            g.a r103 = decodeExtensionFields(r102, r100);
            switch(r102) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L7;
                case 5: goto L7;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L10;
                case 14: goto L9;
                case 15: goto L8;
                default: goto L7;
            };
        L8:
            this.multiViewData = am3.h.c(r100);
            goto L3
        L9:
            this.cameraHorizontalType = r100.i();
            goto L3
        L10:
            this.cameraHorizontalHidden = r100.i();
            goto L3
        L11:
            this.cameraHorizontalPosition = f.a(r100, ILiveCoreSDKData.ICameraHorizontalPosition.class);
            goto L3
        L12:
            this.cameraVerticalType = r100.i();
            goto L3
        L13:
            this.cameraClipCustom = f.a(r100, IClip.class);
            goto L3
        L14:
            this.layout = r100.i();
            goto L3
        L15:
            this.gameRoomIdStr = am3.h.c(r100);
            goto L3
        L16:
            this.gameHidden = r100.i();
            goto L3
        L17:
            this.displayMode = r100.i();
            goto L3
        L18:
            this.cameraHidden = r100.i();
            goto L3
        L19:
            this.cameraClip = f.a(r100, IClip.class);
            goto L3
        L20:
            this.gameClip = f.a(r100, IClip.class);
            goto L3
        L7:
            am3.h.d(r103, r100);
            goto L3
        L21:
            r100.d(r101);
            setThreadSafe(true);
            if (this.gameRoomIdStr != null) goto L25;
            this.gameRoomIdStr = "";
        L25:
            if (this.multiViewData != null) goto L58;
            this.multiViewData = "";
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setCameraClip(IClip r100) {
            this.cameraClip = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setCameraClipCustom(IClip r100) {
            this.cameraClipCustom = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setCameraHidden(int r100) {
            this.cameraHidden = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setCameraHorizontalHidden(int r100) {
            this.cameraHorizontalHidden = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setCameraHorizontalPosition(ILiveCoreSDKData.ICameraHorizontalPosition r100) {
            this.cameraHorizontalPosition = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setCameraHorizontalType(int r100) {
            this.cameraHorizontalType = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setCameraVerticalType(int r100) {
            this.cameraVerticalType = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setDisplayMode(int r100) {
            this.displayMode = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setGameClip(IClip r100) {
            this.gameClip = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setGameHidden(int r100) {
            this.gameHidden = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setGameRoomIdStr(String r100) {
            this.gameRoomIdStr = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setLayout(int r100) {
            this.layout = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IExtension
        public void setMultiViewData(String r100) {
            this.multiViewData = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$GameABParams;", "Ljava/io/Serializable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IGameABParams;", "()V", "defaultResolution", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$GameABParams$PushBase;", "getDefaultResolution", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$GameABParams$PushBase;", "setDefaultResolution", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$GameABParams$PushBase;)V", PlayerResolution.SDKKEY.HD, "getHd", "setHd", PlayerResolution.SDKKEY.LD, "getLd", "setLd", PlayerResolution.SDKKEY.SD, "getSd", "setSd", PlayerResolution.SDKKEY.UHD, "getUhd", "setUhd", "PushBase", "ResolutionParams", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GameABParams implements Serializable, ILiveCoreSDKData.IGameABParams {

        @SerializedName("default")
        private PushBase defaultResolution;

        /* JADX INFO: renamed from: hd, reason: collision with root package name */
        @SerializedName(PlayerResolution.SDKKEY.HD)
        private PushBase f162593hd;

        /* JADX INFO: renamed from: ld, reason: collision with root package name */
        @SerializedName(PlayerResolution.SDKKEY.LD)
        private PushBase f162594ld;

        /* JADX INFO: renamed from: sd, reason: collision with root package name */
        @SerializedName(PlayerResolution.SDKKEY.SD)
        private PushBase f162595sd;

        @SerializedName(PlayerResolution.SDKKEY.UHD)
        private PushBase uhd;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$GameABParams$PushBase;", "Ljava/io/Serializable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IGameABParams$IPushBase;", "()V", "params", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$GameABParams$ResolutionParams;", "getParams", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$GameABParams$ResolutionParams;", "setParams", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$GameABParams$ResolutionParams;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class PushBase implements Serializable, ILiveCoreSDKData.IGameABParams.IPushBase {

            @SerializedName("PushBase")
            private ResolutionParams params;

            public PushBase() {
            }

            @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams.IPushBase
            public /* bridge */ /* synthetic */ ILiveCoreSDKData.IGameABParams.IResolutionParams getParams() {
                return getParams();
            }

            @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams.IPushBase
            public ResolutionParams getParams() {
                return this.params;
            }

            public void setParams(ResolutionParams r100) {
                this.params = r100;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$GameABParams$ResolutionParams;", "Ljava/io/Serializable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IGameABParams$IResolutionParams;", "()V", "defaultBitrate", "", "getDefaultBitrate", "()I", "setDefaultBitrate", "(I)V", "fps", "getFps", "setFps", "gopSec", "getGopSec", "setGopSec", "height", "getHeight", "setHeight", "maxBitrate", "getMaxBitrate", "setMaxBitrate", "minBitrate", "getMinBitrate", "setMinBitrate", "width", "getWidth", "setWidth", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ResolutionParams implements Serializable, ILiveCoreSDKData.IGameABParams.IResolutionParams {

            @SerializedName("defaultBitrate")
            private int defaultBitrate;

            @SerializedName("fps")
            private int fps;

            @SerializedName("gopSec")
            private int gopSec;

            @SerializedName("height")
            private int height;

            @SerializedName("maxBitrate")
            private int maxBitrate;

            @SerializedName("minBitrate")
            private int minBitrate;

            @SerializedName("width")
            private int width;

            public ResolutionParams() {
            }

            @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams.IResolutionParams
            public int getDefaultBitrate() {
                return this.defaultBitrate;
            }

            @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams.IResolutionParams
            public int getFps() {
                return this.fps;
            }

            @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams.IResolutionParams
            public int getGopSec() {
                return this.gopSec;
            }

            @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams.IResolutionParams
            public int getHeight() {
                return this.height;
            }

            @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams.IResolutionParams
            public int getMaxBitrate() {
                return this.maxBitrate;
            }

            @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams.IResolutionParams
            public int getMinBitrate() {
                return this.minBitrate;
            }

            @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams.IResolutionParams
            public int getWidth() {
                return this.width;
            }

            public void setDefaultBitrate(int r100) {
                this.defaultBitrate = r100;
            }

            public void setFps(int r100) {
                this.fps = r100;
            }

            public void setGopSec(int r100) {
                this.gopSec = r100;
            }

            public void setHeight(int r100) {
                this.height = r100;
            }

            public void setMaxBitrate(int r100) {
                this.maxBitrate = r100;
            }

            public void setMinBitrate(int r100) {
                this.minBitrate = r100;
            }

            public void setWidth(int r100) {
                this.width = r100;
            }
        }

        public GameABParams() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams
        public /* bridge */ /* synthetic */ ILiveCoreSDKData.IGameABParams.IPushBase getDefaultResolution() {
            return getDefaultResolution();
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams
        public /* bridge */ /* synthetic */ ILiveCoreSDKData.IGameABParams.IPushBase getHd() {
            return getHd();
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams
        public /* bridge */ /* synthetic */ ILiveCoreSDKData.IGameABParams.IPushBase getLd() {
            return getLd();
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams
        public /* bridge */ /* synthetic */ ILiveCoreSDKData.IGameABParams.IPushBase getSd() {
            return getSd();
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams
        public /* bridge */ /* synthetic */ ILiveCoreSDKData.IGameABParams.IPushBase getUhd() {
            return getUhd();
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams
        public PushBase getDefaultResolution() {
            return this.defaultResolution;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams
        public PushBase getHd() {
            return this.f162593hd;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams
        public PushBase getLd() {
            return this.f162594ld;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams
        public PushBase getSd() {
            return this.f162595sd;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData.IGameABParams
        public PushBase getUhd() {
            return this.uhd;
        }

        public void setDefaultResolution(PushBase r100) {
            this.defaultResolution = r100;
        }

        public void setHd(PushBase r100) {
            this.f162593hd = r100;
        }

        public void setLd(PushBase r100) {
            this.f162594ld = r100;
        }

        public void setSd(PushBase r100) {
            this.f162595sd = r100;
        }

        public void setUhd(PushBase r100) {
            this.uhd = r100;
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData.PullData.Options")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$Options;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IOptions;", "Ljava/io/Serializable;", "()V", "defaultQuality", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "getDefaultQuality", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "setDefaultQuality", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;)V", "qualityList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$Quality;", "getQualityList", "()Ljava/util/List;", "setQualityList", "(Ljava/util/List;)V", "qualityStrategy", "", "getQualityStrategy", "()Ljava/lang/String;", "setQualityStrategy", "(Ljava/lang/String;)V", "vPassDefault", "", "getVPassDefault", "()Z", "setVPassDefault", "(Z)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Options extends FlexModelBase<IOptions> implements IOptions, h {

        @SerializedName("default_quality")
        protected IQuality defaultQuality;

        @SerializedName("qualities")
        protected List<Quality> qualityList;

        @SerializedName("quality_strategy")
        protected String qualityStrategy;

        @SerializedName("vpass_default")
        protected boolean vPassDefault;

        public Options() {
            super(IOptions.class);
            this.defaultQuality = new Quality();
            this.qualityList = new ArrayList();
            this.qualityStrategy = "";
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IOptions
        public IQuality getDefaultQuality() {
            return this.defaultQuality;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IOptions
        public List<Quality> getQualityList() {
            return this.qualityList;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IOptions
        public String getQualityStrategy() {
            return this.qualityStrategy;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IOptions
        public boolean getVPassDefault() {
            return this.vPassDefault;
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdkapi.depend.model.live.IQuality, java.lang.Object] */
        public Options(g r100) {
            super(IOptions.class);
            this.qualityList = new ArrayList();
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.defaultQuality = f.a(r100, IQuality.class);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.qualityList.add(new Quality(r100));
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.vPassDefault = am3.h.a(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.qualityStrategy = am3.h.c(r100);
            goto L3
        L13:
            am3.h.d(r103, r100);
            goto L3
        L18:
            r100.d(r101);
            setThreadSafe(true);
            if (this.defaultQuality != null) goto L22;
            this.defaultQuality = new Quality();
        L22:
            if (this.qualityList.isEmpty() == false) goto L25;
            this.qualityList = new ArrayList();
        L25:
            if (this.qualityStrategy != null) goto L43;
            this.qualityStrategy = "";
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IOptions
        public void setDefaultQuality(IQuality r100) {
            this.defaultQuality = r100;
        }

        public void setQualityList(List<Quality> r100) {
            this.qualityList = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IOptions
        public void setQualityStrategy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.qualityStrategy = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IOptions
        public void setVPassDefault(boolean r100) {
            this.vPassDefault = r100;
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData.PullData.PlayInfo")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PlayInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPlayInfo;", "Ljava/io/Serializable;", "()V", "qualitySdkKey", "", "getQualitySdkKey", "()Ljava/lang/String;", "setQualitySdkKey", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PlayInfo extends FlexModelBase<IPlayInfo> implements IPlayInfo, h {

        @SerializedName("quality_name")
        protected String qualitySdkKey;

        @SerializedName("url")
        protected String url;

        public PlayInfo() {
            super(IPlayInfo.class);
        }

        public PlayInfo(g r100) {
            super(IPlayInfo.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.url = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.qualitySdkKey = am3.h.c(r100);
            goto L3
        L9:
            am3.h.d(r103, r100);
            goto L3
        L12:
            r100.d(r101);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPlayInfo
        public String getQualitySdkKey() {
            return this.qualitySdkKey;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPlayInfo
        public String getUrl() {
            return this.url;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPlayInfo
        public void setQualitySdkKey(String r100) {
            this.qualitySdkKey = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPlayInfo
        public void setUrl(String r100) {
            this.url = r100;
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData.PullData")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u00106\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0002\u00107R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR,\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010!8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010,\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R \u00102\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u0010\tR\u0012\u00105\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PullData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPullData;", "()V", "codec", "", "getCodec", "()Ljava/lang/String;", "setCodec", "(Ljava/lang/String;)V", "display", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IDisplay;", "getDisplay", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IDisplay;", "setDisplay", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IDisplay;)V", "extension", "Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;", "getExtension", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;", "setExtension", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;)V", "flv", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PlayInfo;", "getFlv", "()Ljava/util/List;", "setFlv", "(Ljava/util/List;)V", TTVideoEngineInterface.FORMAT_TYPE_HLS, "getHls", "setHls", "hlsDataUnencrypted", "", "getHlsDataUnencrypted", "()Ljava/util/Map;", "setHlsDataUnencrypted", "(Ljava/util/Map;)V", "kind", "", "getKind", "()I", "setKind", "(I)V", "options", "Lcom/bytedance/android/livesdkapi/depend/model/live/IOptions;", "getOptions", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IOptions;", "setOptions", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IOptions;)V", "streamData", "getStreamData", "setStreamData", "version", "getVersion", "()Ljava/lang/Integer;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PullData extends FlexModelBase<IPullData> implements IPullData, h {

        @SerializedName("codec")
        protected String codec;

        @SerializedName("display")
        protected ILiveCoreSDKData.IDisplay display;

        @SerializedName("extension")
        protected IExtension extension;

        @SerializedName("Flv")
        protected List<PlayInfo> flv;

        @SerializedName("Hls")
        protected List<PlayInfo> hls;

        @SerializedName("hls_data_unencrypted")
        protected Map<String, String> hlsDataUnencrypted;

        @SerializedName("kind")
        protected int kind;

        @SerializedName("options")
        protected IOptions options;

        @SerializedName(MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
        protected String streamData;

        @SerializedName("version")
        public int version;

        public PullData() {
            super(IPullData.class);
            this.options = new Options();
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullDataEx
        public Integer getVersion() {
            return Integer.valueOf(this.version);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public String getCodec() {
            return this.codec;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public ILiveCoreSDKData.IDisplay getDisplay() {
            return this.display;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public IExtension getExtension() {
            return this.extension;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public List<PlayInfo> getFlv() {
            return this.flv;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public List<PlayInfo> getHls() {
            return this.hls;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public Map<String, String> getHlsDataUnencrypted() {
            return this.hlsDataUnencrypted;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public int getKind() {
            return this.kind;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public IOptions getOptions() {
            return this.options;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public String getStreamData() {
            return this.streamData;
        }

        /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.android.livesdkapi.depend.model.live.IExtension, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v17, types: [com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData$IDisplay, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdkapi.depend.model.live.IOptions, java.lang.Object] */
        public PullData(g r110) {
            super(IPullData.class);
            this.hlsDataUnencrypted = new HashMap();
            this.hls = new ArrayList();
            this.flv = new ArrayList();
            setThreadSafe(false);
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L35;
            g.a r102 = decodeExtensionFields(r101, r110);
            switch(r101) {
                case 1: goto L34;
                case 2: goto L33;
                case 3: goto L32;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                default: goto L7;
            };
        L8:
            this.display = f.a(r110, ILiveCoreSDKData.IDisplay.class);
            goto L3
        L9:
            this.codec = am3.h.c(r110);
            goto L3
        L10:
            List<PlayInfo> r103 = this.flv;
            PlayInfo r104 = new PlayInfo(r110);
        L12:
            r103.add(r104);
            goto L3
        L11:
            r103 = this.hls;
            r104 = new PlayInfo(r110);
            goto L12
        L13:
            this.extension = f.a(r110, IExtension.class);
            goto L3
        L14:
            this.kind = r110.i();
            goto L3
        L15:
            long r105 = r110.c();
            String r106 = null;
            String r107 = null;
        L16:
            int r108 = r110.f();
            if (r108 == (-1)) goto L24;
            if (r108 != 1) goto L20;
            r106 = am3.h.c(r110);
            goto L16
        L20:
            if (r108 != 2) goto L21;
            r107 = am3.h.c(r110);
            goto L16
        L21:
            am3.h.e(r110);
            goto L16
        L24:
            r110.d(r105);
            Map<String, String> r109 = this.hlsDataUnencrypted;
            if (r106 == null) goto L31;
            if (r107 == null) goto L29;
            r109.put(r106, r107);
            goto L3
        L29:
            throw new IllegalStateException("Value must not be null");
        L31:
            throw new IllegalStateException("Key must not be null");
        L32:
            this.version = (int) r110.j();
            goto L3
        L33:
            this.options = f.a(r110, IOptions.class);
            goto L3
        L34:
            this.streamData = am3.h.c(r110);
            goto L3
        L7:
            am3.h.d(r102, r110);
            goto L3
        L35:
            r110.d(r100);
            setThreadSafe(true);
            if (this.options != null) goto L73;
            this.options = new Options();
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public void setCodec(String r100) {
            this.codec = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public void setDisplay(ILiveCoreSDKData.IDisplay r100) {
            this.display = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public void setExtension(IExtension r100) {
            this.extension = r100;
        }

        public void setFlv(List<PlayInfo> r100) {
            this.flv = r100;
        }

        public void setHls(List<PlayInfo> r100) {
            this.hls = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public void setHlsDataUnencrypted(Map<String, String> r100) {
            this.hlsDataUnencrypted = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public void setKind(int r100) {
            this.kind = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public void setOptions(IOptions r100) {
            this.options = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPullData
        public void setStreamData(String r100) {
            this.streamData = r100;
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData.PushData")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PushData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPushData;", "()V", "preSchedule", "", "getPreSchedule", "()Z", "setPreSchedule", "(Z)V", "pushStreamLevel", "", "getPushStreamLevel", "()I", "setPushStreamLevel", "(I)V", "resolutionParams", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IResolutionParams;", "getResolutionParams", "()Ljava/util/Map;", "setResolutionParams", "(Ljava/util/Map;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PushData extends FlexModelBase<IPushData> implements IPushData, h {

        @SerializedName("pre_schedule")
        protected boolean preSchedule;

        @SerializedName("push_stream_level")
        protected int pushStreamLevel;

        @SerializedName("resolution_params")
        protected Map<String, ? extends IResolutionParams> resolutionParams;

        public PushData() {
            super(IPushData.class);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPushData
        public boolean getPreSchedule() {
            return this.preSchedule;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPushData
        public int getPushStreamLevel() {
            return this.pushStreamLevel;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPushData
        public Map<String, IResolutionParams> getResolutionParams() {
            return this.resolutionParams;
        }

        public PushData(g r110) {
            super(IPushData.class);
            this.resolutionParams = new HashMap();
            setThreadSafe(false);
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L29;
            g.a r102 = decodeExtensionFields(r101, r110);
            if (r101 != 1) goto L7;
            long r103 = r110.c();
            String r104 = null;
            Object r105 = null;
        L14:
            int r106 = r110.f();
            if (r106 == (-1)) goto L21;
            if (r106 != 1) goto L17;
            r104 = am3.h.c(r110);
            goto L14
        L17:
            if (r106 != 2) goto L18;
            r105 = f.a(r110, IResolutionParams.class);
            goto L14
        L18:
            am3.h.e(r110);
            goto L14
        L21:
            r110.d(r103);
            Map<String, ? extends IResolutionParams> r107 = this.resolutionParams;
            if (r104 == null) goto L28;
            if (r105 == null) goto L26;
            r107.put(r104, r105);
            goto L3
        L26:
            throw new IllegalStateException("Value must not be null");
        L28:
            throw new IllegalStateException("Key must not be null");
        L7:
            if (r101 != 2) goto L9;
            this.pushStreamLevel = r110.i();
            goto L3
        L9:
            if (r101 != 3) goto L10;
            this.preSchedule = am3.h.a(r110);
            goto L3
        L10:
            am3.h.d(r102, r110);
            goto L3
        L29:
            r110.d(r100);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPushData
        public void setPreSchedule(boolean r100) {
            this.preSchedule = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPushData
        public void setPushStreamLevel(int r100) {
            this.pushStreamLevel = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPushData
        public void setResolutionParams(Map<String, ? extends IResolutionParams> r100) {
            this.resolutionParams = r100;
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData.PullData.Options.Quality")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u000e\u0010#\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u0007R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\u001e\u0010\u0019\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR\u0012\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\r¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$Quality;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "()V", "disable", "", "enable", "", "encodeFormat", "", "getEncodeFormat", "()Ljava/lang/String;", "setEncodeFormat", "(Ljava/lang/String;)V", "fps", "getFps", "()I", "setFps", "(I)V", "level", "getLevel", "setLevel", "name", "getName", "setName", "resolution", "getResolution", "setResolution", "sdkKey", "subName", "getSubName", "setSubName", "getDisable", "getSdkKey", "isEnable", "setEnable", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Quality extends FlexModelBase<IQuality> implements IQuality, h {

        @SerializedName("disable")
        public int disable;
        public boolean enable;

        @SerializedName("v_codec")
        protected String encodeFormat;

        @SerializedName("fps")
        protected int fps;

        @SerializedName("level")
        protected int level;

        @SerializedName("name")
        protected String name;

        @SerializedName("resolution")
        protected String resolution;

        @SerializedName("sdk_key")
        public String sdkKey;

        @SerializedName("additional_content")
        protected String subName;

        public Quality() {
            super(IQuality.class);
            this.enable = true;
            this.name = "";
            this.subName = "";
            this.sdkKey = "";
            this.resolution = "";
            this.encodeFormat = "";
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseQuality
        public int getDisable() {
            return this.disable;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public String getEncodeFormat() {
            return this.encodeFormat;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public int getFps() {
            return this.fps;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public int getLevel() {
            return this.level;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public String getName() {
            return this.name;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public String getResolution() {
            return this.resolution;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseQuality
        public String getSdkKey() {
            return this.sdkKey;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public String getSubName() {
            return this.subName;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQualityKt
        public boolean isEnable() {
            return this.enable;
        }

        public Quality(g r100) {
            super(IQuality.class);
            this.enable = true;
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L16;
            g.a r103 = decodeExtensionFields(r102, r100);
            switch(r102) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L7;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            this.disable = r100.i();
            goto L3
        L9:
            this.fps = r100.i();
            goto L3
        L10:
            this.subName = am3.h.c(r100);
            goto L3
        L11:
            this.level = r100.i();
            goto L3
        L12:
            this.resolution = am3.h.c(r100);
            goto L3
        L13:
            this.encodeFormat = am3.h.c(r100);
            goto L3
        L14:
            this.sdkKey = am3.h.c(r100);
            goto L3
        L15:
            this.name = am3.h.c(r100);
            goto L3
        L7:
            am3.h.d(r103, r100);
            goto L3
        L16:
            r100.d(r101);
            setThreadSafe(true);
            if (this.name != null) goto L20;
            this.name = "";
        L20:
            if (this.subName != null) goto L23;
            this.subName = "";
        L23:
            if (this.sdkKey != null) goto L26;
            this.sdkKey = "";
        L26:
            if (this.resolution != null) goto L29;
            this.resolution = "";
        L29:
            if (this.encodeFormat != null) goto L52;
            this.encodeFormat = "";
            return;
        }

        public final void setEnable(boolean r100) {
            this.enable = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public void setEncodeFormat(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.encodeFormat = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public void setFps(int r100) {
            this.fps = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public void setLevel(int r100) {
            this.level = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public void setName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.name = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public void setResolution(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.resolution = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IQuality
        public void setSubName(String r100) {
            this.subName = r100;
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.LiveCoreSDKData.PushData.ResolutionParams")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0005\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001e\u0010\u0011\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001e\u0010\u0014\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001e\u0010\u0017\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001e\u0010\u001a\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$ResolutionParams;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IResolutionParams;", "Ljava/io/Serializable;", "()V", "defaultBitrate", "", "getDefaultBitrate", "()I", "setDefaultBitrate", "(I)V", "fps", "getFps", "setFps", "gopSec", "getGopSec", "setGopSec", "height", "getHeight", "setHeight", "maxBitrate", "getMaxBitrate", "setMaxBitrate", "minBitrate", "getMinBitrate", "setMinBitrate", "width", "getWidth", "setWidth", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ResolutionParams extends FlexModelBase<IResolutionParams> implements IResolutionParams, h {

        @IgnoreProtoFieldCheck
        @SerializedName("default_bitrate")
        protected int defaultBitrate;

        @SerializedName("fps")
        protected int fps;

        @IgnoreProtoFieldCheck
        @SerializedName("gopSec")
        private int gopSec;

        @SerializedName("height")
        protected int height;

        @SerializedName("max_bitrate")
        protected int maxBitrate;

        @SerializedName("min_bitrate")
        protected int minBitrate;

        @SerializedName("width")
        protected int width;

        public ResolutionParams() {
            super(IResolutionParams.class);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public int getDefaultBitrate() {
            return this.defaultBitrate;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public int getFps() {
            return this.fps;
        }

        public final int getGopSec() {
            return this.gopSec;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public int getHeight() {
            return this.height;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public int getMaxBitrate() {
            return this.maxBitrate;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public int getMinBitrate() {
            return this.minBitrate;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public int getWidth() {
            return this.width;
        }

        public ResolutionParams(g r100) {
            super(IResolutionParams.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L14;
            g.a r103 = decodeExtensionFields(r102, r100);
            switch(r102) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                default: goto L7;
            };
        L8:
            this.fps = (int) r100.j();
            goto L3
        L9:
            this.maxBitrate = (int) r100.j();
            goto L3
        L10:
            this.minBitrate = (int) r100.j();
            goto L3
        L11:
            this.defaultBitrate = (int) r100.j();
            goto L3
        L12:
            this.height = (int) r100.j();
            goto L3
        L13:
            this.width = (int) r100.j();
            goto L3
        L7:
            am3.h.d(r103, r100);
            goto L3
        L14:
            r100.d(r101);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public void setDefaultBitrate(int r100) {
            this.defaultBitrate = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public void setFps(int r100) {
            this.fps = r100;
        }

        public final void setGopSec(int r100) {
            this.gopSec = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public void setHeight(int r100) {
            this.height = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public void setMaxBitrate(int r100) {
            this.maxBitrate = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public void setMinBitrate(int r100) {
            this.minBitrate = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IResolutionParams
        public void setWidth(int r100) {
            this.width = r100;
        }
    }

    public LiveCoreSDKData() {
        super(ILiveCoreSDKData.class);
    }

    public LiveCoreSDKData(g r100) {
        super(ILiveCoreSDKData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.pullData = new PullData(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.pushData = new PushData(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.size = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKDataEx
    public Quality getDefaultQuality() {
        PullData r100 = this.pullData;
        if (r100 == null) goto L12;
        Intrinsics.checkNotNull(r100);
        if (r100.getOptions() == null) goto L12;
        PullData r101 = this.pullData;
        Intrinsics.checkNotNull(r101);
        IOptions r102 = r101.getOptions();
        Intrinsics.checkNotNull(r102);
        IQuality r103 = r102.getDefaultQuality();
        if (r103 == null) goto L11;
        return (Quality) r103;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData.Quality");
    L12:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKDataEx
    public List<IQuality> getQualityList() {
        PullData r100 = this.pullData;
        if (r100 == null) goto L8;
        Intrinsics.checkNotNull(r100);
        if (r100.getOptions() == null) goto L8;
        PullData r101 = this.pullData;
        Intrinsics.checkNotNull(r101);
        IOptions r102 = r101.getOptions();
        Intrinsics.checkNotNull(r102);
        return r102.getQualityList();
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKDataEx
    public String getQualityStrategy() {
        PullData r100 = this.pullData;
        if (r100 == null) goto L8;
        Intrinsics.checkNotNull(r100);
        if (r100.getOptions() == null) goto L8;
        PullData r101 = this.pullData;
        Intrinsics.checkNotNull(r101);
        IOptions r102 = r101.getOptions();
        Intrinsics.checkNotNull(r102);
        return r102.getQualityStrategy();
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData
    public /* bridge */ /* synthetic */ IPushData getPushData() {
        return getPushData();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKDataEx
    public IPullData getPullData() {
        return this.pullData;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData
    public String getSize() {
        return this.size;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKDataEx
    public /* bridge */ /* synthetic */ IQuality getDefaultQuality() {
        return getDefaultQuality();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData
    public PushData getPushData() {
        return this.pushData;
    }

    public void setPushData(PushData r100) {
        this.pushData = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData
    public void setSize(String r100) {
        this.size = r100;
    }
}
