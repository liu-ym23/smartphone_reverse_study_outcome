package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.core.utils.s1;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001:\u0006>?\f\u0013@:B\u0007¢\u0006\u0004\b<\u0010=R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010$\u001a\u00020#8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u0010-\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\"\u00100\u001a\u00020#8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\"\u00103\u001a\u00020#8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b3\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R\"\u00106\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\"\u00109\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010%\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "Ltf0/j;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$f;", "uiContainer", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$f;", "t", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$f;", ExifInterface.LONGITUDE_EAST, "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$f;)V", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$a;", "canvasParams", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$a;", "c", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$a;", "u", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$a;)V", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$c;", "contentParams", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$c;", "d", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$c;", BaseSwitches.V, "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$c;)V", "", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$d;", "regionList", "Ljava/util/List;", "h", "()Ljava/util/List;", "y", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$e;", "seatList", ce.f26396k, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "scene", "I", ce.f26395j, "()I", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "(I)V", "uiLayout", "getUiLayout", FaceService.girlLabel, Keys.API_EVENT_KEY_PLAY_MODE, ce.f26391f, "x", "spatialId", OfficeSDKRequestTag.KEY_NEW_USER, "D", "seiVersion", "m", "C", "seiSubScene", "l", "B", "orientation", "f", "w", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "e", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m implements tf0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f75839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f75840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f75841c;

    @SerializedName("canvas")
    private a canvasParams;

    @SerializedName("content")
    private c contentParams;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public pn0.f f75842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Integer> f75843e;

    @SerializedName("orientation")
    private int orientation;

    @SerializedName(FastStartLiveConfig.PLAY_MODE)
    private int playMode;

    @SerializedName("regions")
    private List<d> regionList;

    @SerializedName("scene")
    private int scene;

    @SerializedName("seats")
    private List<e> seatList;

    @SerializedName(ILiveRoomPlayFragmentConstant.FEED_LIVE_ENTER_SEI_SUB_SCENE)
    private int seiSubScene;

    @SerializedName("sei_ver")
    private int seiVersion;

    @SerializedName("spatial_id")
    private int spatialId;

    @SerializedName("ui_container")
    private f uiContainer;

    @SerializedName("ui_layout")
    private int uiLayout;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\u0004\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0004\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$a;", "", "", "width", "I", "f", "()I", ce.f26396k, "(I)V", "height", "d", RXScreenCaptureService.KEY_INDEX, "scale", "e", ce.f26395j, "getScale$annotations", "()V", "align", "b", ce.f26391f, "getAlign$annotations", "", "backgroundColor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "<init>", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("align")
        private int align;

        @SerializedName("background_color")
        private String backgroundColor;

        @SerializedName("h")
        private int height;

        @SerializedName("scale")
        private int scale;

        @SerializedName("w")
        private int width;

        public final a a() {
            a r100 = new a();
            r100.width = this.width;
            r100.height = this.height;
            r100.scale = this.scale;
            r100.align = this.align;
            return r100;
        }

        public a() {
            this.scale = 1;
            this.align = 8;
            this.backgroundColor = "#322542";
        }

        public final int b() {
            return this.align;
        }

        public final String c() {
            return this.backgroundColor;
        }

        public final int d() {
            return this.height;
        }

        public final int e() {
            return this.scale;
        }

        public final int f() {
            return this.width;
        }

        public final void g(int r100) {
            this.align = r100;
        }

        public final void h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.backgroundColor = r100;
        }

        public final void i(int r100) {
            this.height = r100;
        }

        public final void j(int r100) {
            this.scale = r100;
        }

        public final void k(int r100) {
            this.width = r100;
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$c;", "", "", "x", "I", "d", "()I", "h", "(I)V", "y", "e", RXScreenCaptureService.KEY_INDEX, "width", "c", ce.f26391f, "height", "b", "f", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c {

        @SerializedName("h")
        private int height;

        @SerializedName("w")
        private int width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        private int f75844x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        private int f75845y;

        public c() {
        }

        public final c a() {
            c r100 = new c();
            r100.f75844x = this.f75844x;
            r100.f75845y = this.f75845y;
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

        public final int d() {
            return this.f75844x;
        }

        public final int e() {
            return this.f75845y;
        }

        public final void f(int r100) {
            this.height = r100;
        }

        public final void g(int r100) {
            this.width = r100;
        }

        public final void h(int r100) {
            this.f75844x = r100;
        }

        public final void i(int r100) {
            this.f75845y = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$d;", "", "", "zOrder", "I", ce.f26391f, "()I", "m", "(I)V", "position", "c", RXScreenCaptureService.KEY_INDEX, "", "x", "D", "e", "()D", ce.f26396k, "(D)V", "y", "f", "l", "width", "d", ce.f26395j, "height", "b", "h", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d {

        @SerializedName("h")
        private double height;

        @SerializedName("p")
        private int position;

        @SerializedName("w")
        private double width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        private double f75846x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        private double f75847y;

        @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
        private int zOrder;

        public d() {
        }

        public final d a() {
            d r100 = new d();
            r100.zOrder = this.zOrder;
            r100.position = this.position;
            r100.f75846x = this.f75846x;
            r100.f75847y = this.f75847y;
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
            return this.f75846x;
        }

        public final double f() {
            return this.f75847y;
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
            this.f75846x = r100;
        }

        public final void l(double r100) {
            this.f75847y = r100;
        }

        public final void m(int r100) {
            this.zOrder = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$e;", "", "", "zOrder", "I", ce.f26391f, "()I", "m", "(I)V", "position", "c", RXScreenCaptureService.KEY_INDEX, "", "x", "D", "e", "()D", ce.f26396k, "(D)V", "y", "f", "l", "width", "d", ce.f26395j, "height", "b", "h", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e {

        @SerializedName("h")
        private double height;

        @SerializedName("p")
        private int position;

        @SerializedName("w")
        private double width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        private double f75848x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        private double f75849y;

        @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
        private int zOrder;

        public e() {
        }

        public final e a() {
            e r100 = new e();
            r100.zOrder = this.zOrder;
            r100.position = this.position;
            r100.f75848x = this.f75848x;
            r100.f75849y = this.f75849y;
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
            return this.f75848x;
        }

        public final double f() {
            return this.f75849y;
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
            this.f75848x = r100;
        }

        public final void l(double r100) {
            this.f75849y = r100;
        }

        public final void m(int r100) {
            this.zOrder = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$f;", "", "", "topDp", "I", "e", "()I", RXScreenCaptureService.KEY_INDEX, "(I)V", "leftDp", "c", ce.f26391f, "bottomDp", "b", "f", "rightDp", "d", "h", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f {

        @SerializedName("bottom")
        private int bottomDp;

        @SerializedName("left")
        private int leftDp;

        @SerializedName("right")
        private int rightDp;

        @SerializedName("top")
        private int topDp;

        public f() {
        }

        public final f a() {
            f r100 = new f();
            r100.topDp = this.topDp;
            r100.rightDp = this.rightDp;
            r100.bottomDp = this.bottomDp;
            r100.leftDp = this.leftDp;
            return r100;
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

    @Override // tf0.j
    public final String a() {
        return "linkWindowLayoutConfig: (scene=" + this.scene + ",uiLayout=" + this.uiLayout + ",seiVer=" + this.seiVersion + ')';
    }

    public final m b() {
        m r100 = new m();
        r100.scene = this.scene;
        r100.uiLayout = this.uiLayout;
        r100.seiVersion = this.seiVersion;
        r100.spatialId = this.spatialId;
        f r101 = this.uiContainer;
        c r102 = null;
        if (r101 == null) goto L5;
        f r103 = r101.a();
    L6:
        r100.uiContainer = r103;
        a r104 = this.canvasParams;
        if (r104 == null) goto L9;
        a r105 = r104.a();
    L10:
        r100.canvasParams = r105;
        c r106 = this.contentParams;
        if (r106 == null) goto L13;
        r102 = r106.a();
    L13:
        r100.contentParams = r102;
        List<d> r107 = this.regionList;
        ArrayList r108 = new ArrayList();
        int r109 = 0;
        if (r107 == null) goto L19;
        int r110 = r107.size();
        int r111 = 0;
    L17:
        if (r111 >= r110) goto L19;
        r108.add(((d) ListProtector.get(r107, r111)).a());
        r111 = r111 + 1;
    L19:
        r100.regionList = r108;
        List<e> r112 = this.seatList;
        ArrayList r113 = new ArrayList();
        if (r112 == null) goto L25;
        int r114 = r112.size();
    L23:
        if (r109 >= r114) goto L25;
        r113.add(((e) ListProtector.get(r112, r109)).a());
        r109 = r109 + 1;
    L25:
        r100.seatList = r113;
        r100.f75839a = this.f75839a;
        r100.f75840b = this.f75840b;
        r100.f75842d = this.f75842d;
        return r100;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final String toString() {
        return GsonProtectorUtils.toJson(l97.a.f508113a, this);
    }

    public m() {
        this.spatialId = -1;
        this.f75839a = true;
    }

    public final a c() {
        return this.canvasParams;
    }

    public final c d() {
        return this.contentParams;
    }

    public final int e() {
        return this.orientation;
    }

    public final int f() {
        return this.orientation;
    }

    public final int g() {
        return this.playMode;
    }

    @Override // tf0.j
    public final int getUiLayout() {
        return this.uiLayout;
    }

    public final List<d> h() {
        return this.regionList;
    }

    public final List<Object> i() {
        return this.regionList;
    }

    public final int j() {
        return this.scene;
    }

    public final List<e> k() {
        return this.seatList;
    }

    public final int l() {
        return this.seiSubScene;
    }

    public final int m() {
        return this.seiVersion;
    }

    public final int n() {
        return this.spatialId;
    }

    public final f t() {
        return this.uiContainer;
    }

    public final void A(List<e> r100) {
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

    public final void E(f r100) {
        this.uiContainer = r100;
    }

    public final void F(int r100) {
        this.uiLayout = r100;
    }

    public final int o(int r100) {
        b03.a r101 = b03.a.f16857a;
        float r102 = r100 / s1.w();
        f r103 = this.uiContainer;
        if (r103 == null) goto L5;
        int r104 = r103.b();
    L7:
        return (int) (r102 * b03.c.b(r104));
    L5:
        r104 = 0;
        goto L7
    }

    public final int p(int r100) {
        b03.a r101 = b03.a.f16857a;
        float r102 = r100 / s1.w();
        f r103 = this.uiContainer;
        if (r103 == null) goto L5;
        int r104 = r103.d();
    L7:
        return (int) (r102 * b03.c.b(r104));
    L5:
        r104 = 0;
        goto L7
    }

    public final int q(int r100) {
        f r101 = this.uiContainer;
        if (r101 == null) goto L5;
        int r102 = r101.e();
    L6:
        int r103 = b03.c.b(r102);
        if (((Boolean) vm2.i.L.getValue(null, vm2.i.f556291a[36])).booleanValue() == true) goto L9;
    L12:
        b03.a r104 = b03.a.f16857a;
        return (int) ((r100 / s1.w()) * r103);
    L9:
        if (this.f75839a == true) goto L12;
        if (r103 <= 0) goto L12;
        b03.a r105 = b03.a.f16857a;
        r103 = r103 + s1.A();
        goto L12
    L5:
        r102 = 0;
        goto L6
    }

    public final int r(int r100) {
        f r101 = this.uiContainer;
        if (r101 == null) goto L5;
        int r102 = r101.e();
    L6:
        int r103 = b03.c.b(r102);
        b03.a r104 = b03.a.f16857a;
        return (int) ((r100 / s1.w()) * r103);
    L5:
        r102 = 0;
        goto L6
    }

    public final void u(a r100) {
        this.canvasParams = r100;
    }

    public final void v(c r100) {
        this.contentParams = r100;
    }

    public final void w(int r100) {
        this.orientation = r100;
    }

    public final void x(int r100) {
        this.playMode = r100;
    }

    public final void y(List<d> r100) {
        this.regionList = r100;
    }

    public final void z(int r100) {
        this.scene = r100;
    }

    public final float s(int r100, int r101) {
        float r102 = r100;
        c r103 = this.contentParams;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        float r104 = r103.c();
        c r105 = this.contentParams;
        Intrinsics.checkNotNull(r105);
        float r106 = r104 / r105.b();
    L6:
        float r107 = r102 / r106;
        b03.a r108 = b03.a.f16857a;
        float r109 = ((s1.w() - q(r101)) - o(r101)) * (r101 / s1.w());
        a r110 = this.canvasParams;
        if (r110 == null) goto L36;
        if (r110.e() != 2) goto L36;
        yz0.g r111 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        if (r111 == null) goto L13;
        boolean r112 = r111.isAnchor();
    L15:
        if (((Boolean) vm2.i.M.getValue(null, vm2.i.f556291a[37])).booleanValue() == false) goto L37;
        if (r112 == false) goto L18;
    L21:
        int r113 = this.uiLayout;
        if (r113 != 1) goto L24;
    L29:
        c r114 = this.contentParams;
        if (r114 == null) goto L37;
        float r115 = r102 / r109;
        Intrinsics.checkNotNull(r114);
        float r116 = r114.c();
        c r117 = this.contentParams;
        Intrinsics.checkNotNull(r117);
        if (r115 <= (r116 / r117.b())) goto L37;
        return r107;
    L24:
        if (r113 == 6) goto L29;
        if (r113 == 9) goto L29;
        if (r113 != 112) goto L37;
    L18:
        if (b03.a.b() == true) goto L21;
        if (b03.a.a() == true) goto L21;
    L37:
        return r109;
    L13:
        r112 = false;
    L36:
        return Math.min(r107, r109);
    L5:
        r106 = 1.0f;
        goto L6
    }
}
