package com.bytedance.android.live.multilink.layoutconfig.model;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.qqmusic.third.api.contract.Keys;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u00002\u00020\u0001:\u000bS\u0005\u0018\u0010TUVW&-PB\u0007¢\u0006\u0004\bR\u0010\nR(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\u0004\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR(\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u000f\u0010\u0004\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R*\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u00104\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\"\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0004\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\"\u0010F\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\"\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0004\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\"\u0010L\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\"\u0010O\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\b¨\u0006X"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel;", "", "", "adjustBase", "I", "b", "()I", "r", "(I)V", "getAdjustBase$annotations", "()V", "scale", ce.f26395j, "y", "getScale$annotations", "align", "d", "s", "getAlign$annotations", "", "", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$a;", "adjustMap", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "setAdjustMap", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "uiContainer", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "p", "()Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", ExifInterface.LONGITUDE_EAST, "(Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;)V", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$b;", "canvasParams", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$b;", "e", "()Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$b;", "t", "(Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$b;)V", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$d;", "contentParams", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$d;", "f", "()Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$d;", "u", "(Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$d;)V", "", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$e;", "regionList", "Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/List;", "x", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$f;", "seatList", "l", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "scene", ce.f26396k, MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "uiLayout", "q", FaceService.girlLabel, Keys.API_EVENT_KEY_PLAY_MODE, "h", "w", "spatialId", "o", "D", "seiVersion", OfficeSDKRequestTag.KEY_NEW_USER, "C", "seiSubScene", "m", "B", "orientation", ce.f26391f, BaseSwitches.V, "<init>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LayoutAdjustBase", "LayoutAlign", "LayoutOrientation", "LayoutScale", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LayoutConfigModel {

    @SerializedName("adjust_base")
    private int adjustBase;

    @SerializedName("adjust_map")
    private Map<String, a> adjustMap;

    @SerializedName("align")
    private int align;

    @SerializedName("canvas")
    private b canvasParams;

    @SerializedName("content")
    private d contentParams;

    @SerializedName("orientation")
    private int orientation;

    @SerializedName(FastStartLiveConfig.PLAY_MODE)
    private int playMode;

    @SerializedName("regions")
    private List<e> regionList;

    @SerializedName("scale")
    private int scale;

    @SerializedName("scene")
    private int scene;

    @SerializedName("seats")
    private List<f> seatList;

    @SerializedName(ILiveRoomPlayFragmentConstant.FEED_LIVE_ENTER_SEI_SUB_SCENE)
    private int seiSubScene;

    @SerializedName("sei_ver")
    private int seiVersion;

    @SerializedName("spatial_id")
    private int spatialId;

    @SerializedName("ui_container")
    private g uiContainer;

    @SerializedName("ui_layout")
    private int uiLayout;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$LayoutAdjustBase;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LayoutAdjustBase {
        public static final int CANVAS = 1;
        public static final int CONTENT = 0;
        public static final a Companion = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f83567a = null;

            public a() {
            }

            static {
                f83567a = new a();
            }
        }

        static {
            Companion = a.f83567a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$LayoutAlign;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LayoutAlign {
        public static final int CENTER = 5;
        public static final int CENTER_BOTTOM = 2;
        public static final int CENTER_TOP = 8;
        public static final a Companion = null;
        public static final int LEFT_BOTTOM = 1;
        public static final int LEFT_CENTER = 4;
        public static final int LEFT_TOP = 7;
        public static final int RIGHT_BOTTOM = 3;
        public static final int RIGHT_CENTER = 6;
        public static final int RIGHT_TOP = 9;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f83568a = null;

            public a() {
            }

            static {
                f83568a = new a();
            }
        }

        static {
            Companion = a.f83568a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$LayoutOrientation;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LayoutOrientation {
        public static final int COMMON = 0;
        public static final a Companion = null;
        public static final int HORIZONTAL = 2;
        public static final int VERTICAL = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f83569a = null;

            public a() {
            }

            static {
                f83569a = new a();
            }
        }

        static {
            Companion = a.f83569a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$LayoutScale;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LayoutScale {
        public static final int ASPECT_FILL = 2;
        public static final int ASPECT_FIT = 1;
        public static final a Companion = null;
        public static final int FILL = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f83570a = null;

            public a() {
            }

            static {
                f83570a = new a();
            }
        }

        static {
            Companion = a.f83570a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$a;", "", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "uiContainer", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "b", "()Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "setUiContainer", "(Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;)V", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("ui_container")
        private g uiContainer;

        public a() {
        }

        public final a a() {
            a r100 = new a();
            g r101 = this.uiContainer;
            if (r101 == null) goto L5;
            g r102 = r101.a();
        L6:
            r100.uiContainer = r102;
            return r100;
        L5:
            r102 = null;
            goto L6
        }

        public final g b() {
            return this.uiContainer;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$b;", "", "", "width", "I", "d", "()I", ce.f26391f, "(I)V", "height", "c", "f", "", "backgroundColor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("background_color")
        private String backgroundColor;

        @SerializedName("h")
        private int height;

        @SerializedName("w")
        private int width;

        public final b a() {
            b r100 = new b();
            r100.width = this.width;
            r100.height = this.height;
            r100.backgroundColor = this.backgroundColor;
            return r100;
        }

        public b() {
            this.backgroundColor = "#322542";
        }

        public final String b() {
            return this.backgroundColor;
        }

        public final int c() {
            return this.height;
        }

        public final int d() {
            return this.width;
        }

        public final void e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.backgroundColor = r100;
        }

        public final void f(int r100) {
            this.height = r100;
        }

        public final void g(int r100) {
            this.width = r100;
        }
    }

    public static final class c {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$d;", "", "", "x", "D", "d", "()D", "h", "(D)V", "y", "e", RXScreenCaptureService.KEY_INDEX, "", "width", "I", "c", "()I", ce.f26391f, "(I)V", "height", "b", "f", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d {

        @SerializedName("h")
        private int height;

        @SerializedName("w")
        private int width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        private double f83571x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        private double f83572y;

        public d() {
        }

        public final d a() {
            d r100 = new d();
            r100.f83571x = this.f83571x;
            r100.f83572y = this.f83572y;
            r100.width = this.width;
            r100.height = this.height;
            return r100;
        }

        public final int b() {
            return this.height;
        }

        public final int c() {
            return this.width;
        }

        public final double d() {
            return this.f83571x;
        }

        public final double e() {
            return this.f83572y;
        }

        public final void f(int r100) {
            this.height = r100;
        }

        public final void g(int r100) {
            this.width = r100;
        }

        public final void h(double r100) {
            this.f83571x = r100;
        }

        public final void i(double r100) {
            this.f83572y = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$e;", "", "", "zOrder", "I", ce.f26391f, "()I", "m", "(I)V", "position", "c", RXScreenCaptureService.KEY_INDEX, "", "x", "D", "e", "()D", ce.f26396k, "(D)V", "y", "f", "l", "width", "d", ce.f26395j, "height", "b", "h", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e {

        @SerializedName("h")
        private double height;

        @SerializedName("p")
        private int position;

        @SerializedName("w")
        private double width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        private double f83573x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        private double f83574y;

        @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
        private int zOrder;

        public e() {
        }

        public final e a() {
            e r100 = new e();
            r100.zOrder = this.zOrder;
            r100.position = this.position;
            r100.f83573x = this.f83573x;
            r100.f83574y = this.f83574y;
            r100.width = this.width;
            r100.height = this.height;
            return r100;
        }

        public final String toString() {
            return "{zOrder = " + this.zOrder + ", position = " + this.position + ", region = [" + this.f83573x + ", " + this.f83574y + ", " + this.width + ", " + this.height + "]}";
        }

        public final double b() {
            return this.height;
        }

        public final int c() {
            return this.position;
        }

        public final double d() {
            return this.width;
        }

        public final double e() {
            return this.f83573x;
        }

        public final double f() {
            return this.f83574y;
        }

        public final int g() {
            return this.zOrder;
        }

        public final void h(double r100) {
            this.height = r100;
        }

        public final void i(int r100) {
            this.position = r100;
        }

        public final void j(double r100) {
            this.width = r100;
        }

        public final void k(double r100) {
            this.f83573x = r100;
        }

        public final void l(double r100) {
            this.f83574y = r100;
        }

        public final void m(int r100) {
            this.zOrder = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$f;", "", "", "zOrder", "I", ce.f26391f, "()I", "m", "(I)V", "position", "c", RXScreenCaptureService.KEY_INDEX, "", "x", "D", "e", "()D", ce.f26396k, "(D)V", "y", "f", "l", "width", "d", ce.f26395j, "height", "b", "h", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f {

        @SerializedName("h")
        private double height;

        @SerializedName("p")
        private int position;

        @SerializedName("w")
        private double width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        private double f83575x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        private double f83576y;

        @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
        private int zOrder;

        public f() {
        }

        public final f a() {
            f r100 = new f();
            r100.zOrder = this.zOrder;
            r100.position = this.position;
            r100.f83575x = this.f83575x;
            r100.f83576y = this.f83576y;
            r100.width = this.width;
            r100.height = this.height;
            return r100;
        }

        public final double b() {
            return this.height;
        }

        public final int c() {
            return this.position;
        }

        public final double d() {
            return this.width;
        }

        public final double e() {
            return this.f83575x;
        }

        public final double f() {
            return this.f83576y;
        }

        public final int g() {
            return this.zOrder;
        }

        public final void h(double r100) {
            this.height = r100;
        }

        public final void i(int r100) {
            this.position = r100;
        }

        public final void j(double r100) {
            this.width = r100;
        }

        public final void k(double r100) {
            this.f83575x = r100;
        }

        public final void l(double r100) {
            this.f83576y = r100;
        }

        public final void m(int r100) {
            this.zOrder = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "", "", "topDp", "I", "e", "()I", RXScreenCaptureService.KEY_INDEX, "(I)V", "leftDp", "c", ce.f26391f, "bottomDp", "b", "f", "rightDp", "d", "h", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class g {

        @SerializedName("bottom")
        private int bottomDp;

        @SerializedName("left")
        private int leftDp;

        @SerializedName("right")
        private int rightDp;

        @SerializedName("top")
        private int topDp;

        public g() {
        }

        public final g a() {
            g r100 = new g();
            r100.topDp = this.topDp;
            r100.rightDp = this.rightDp;
            r100.bottomDp = this.bottomDp;
            r100.leftDp = this.leftDp;
            return r100;
        }

        public final String toString() {
            return "[" + this.leftDp + ", " + this.topDp + ", " + this.rightDp + ", " + this.bottomDp + ']';
        }

        public final int b() {
            return this.bottomDp;
        }

        public final int c() {
            return this.leftDp;
        }

        public final int d() {
            return this.rightDp;
        }

        public final int e() {
            return this.topDp;
        }

        public final void f(int r100) {
            this.bottomDp = r100;
        }

        public final void g(int r100) {
            this.leftDp = r100;
        }

        public final void h(int r100) {
            this.rightDp = r100;
        }

        public final void i(int r100) {
            this.topDp = r100;
        }
    }

    static {
    }

    public final void r() {
        this.adjustBase = 0;
    }

    public final LayoutConfigModel a() {
        LayoutConfigModel r100 = new LayoutConfigModel();
        r100.scene = this.scene;
        r100.uiLayout = this.uiLayout;
        r100.playMode = this.playMode;
        r100.seiVersion = this.seiVersion;
        r100.spatialId = this.spatialId;
        r100.seiSubScene = this.seiSubScene;
        r100.orientation = this.orientation;
        Map<String, a> r101 = this.adjustMap;
        LinkedHashMap r102 = new LinkedHashMap();
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, a>> r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, a> r104 = r103.next();
        r102.put(r104.getKey(), r104.getValue().a());
    L8:
        r100.adjustMap = r102;
        r100.adjustBase = this.adjustBase;
        r100.scale = this.scale;
        r100.align = this.align;
        g r105 = this.uiContainer;
        d r106 = null;
        if (r105 == null) goto L11;
        g r107 = r105.a();
    L12:
        r100.uiContainer = r107;
        b r108 = this.canvasParams;
        if (r108 == null) goto L15;
        b r109 = r108.a();
    L16:
        r100.canvasParams = r109;
        d r110 = this.contentParams;
        if (r110 == null) goto L19;
        r106 = r110.a();
    L19:
        r100.contentParams = r106;
        List<e> r111 = this.regionList;
        ArrayList r112 = new ArrayList();
        int r113 = 0;
        if (r111 == null) goto L25;
        int r114 = r111.size();
        int r115 = 0;
    L23:
        if (r115 >= r114) goto L25;
        r112.add(((e) ListProtector.get(r111, r115)).a());
        r115 = r115 + 1;
    L25:
        r100.regionList = r112;
        List<f> r116 = this.seatList;
        ArrayList r117 = new ArrayList();
        if (r116 == null) goto L31;
        int r118 = r116.size();
    L29:
        if (r113 >= r118) goto L31;
        r117.add(((f) ListProtector.get(r116, r113)).a());
        r113 = r113 + 1;
    L31:
        r100.seatList = r117;
        return r100;
    L15:
        r109 = null;
        goto L16
    L11:
        r107 = null;
        goto L12
    }

    public LayoutConfigModel() {
        this.scale = 1;
        this.align = 8;
        this.spatialId = -1;
    }

    public final String toString() {
        return GsonProtectorUtils.toJson(GsonHelper.get(), this).toString();
    }

    public final int b() {
        return this.adjustBase;
    }

    public final Map<String, a> c() {
        return this.adjustMap;
    }

    public final int d() {
        return this.align;
    }

    public final b e() {
        return this.canvasParams;
    }

    public final d f() {
        return this.contentParams;
    }

    public final int g() {
        return this.orientation;
    }

    public final int h() {
        return this.playMode;
    }

    public final List<e> i() {
        return this.regionList;
    }

    public final int j() {
        return this.scale;
    }

    public final int k() {
        return this.scene;
    }

    public final List<f> l() {
        return this.seatList;
    }

    public final int m() {
        return this.seiSubScene;
    }

    public final int n() {
        return this.seiVersion;
    }

    public final int o() {
        return this.spatialId;
    }

    public final g p() {
        return this.uiContainer;
    }

    public final int q() {
        return this.uiLayout;
    }

    public final void A(List<f> r100) {
        this.seatList = r100;
    }

    public final void B(int r100) {
        this.seiSubScene = r100;
    }

    public final void C(int r100) {
        this.seiVersion = r100;
    }

    public final void D(int r100) {
        this.spatialId = r100;
    }

    public final void E(g r100) {
        this.uiContainer = r100;
    }

    public final void F(int r100) {
        this.uiLayout = r100;
    }

    public final void s(int r100) {
        this.align = r100;
    }

    public final void t(b r100) {
        this.canvasParams = r100;
    }

    public final void u(d r100) {
        this.contentParams = r100;
    }

    public final void v(int r100) {
        this.orientation = r100;
    }

    public final void w(int r100) {
        this.playMode = r100;
    }

    public final void x(List<e> r100) {
        this.regionList = r100;
    }

    public final void y(int r100) {
        this.scale = r100;
    }

    public final void z(int r100) {
        this.scene = r100;
    }
}
