package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\f\u0010\rRv\u0010\u0006\u001aV\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0002j*\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/h8;", "", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/livesdk/config/h8$b;", "Lkotlin/collections/HashMap;", "layoutConfigMap", "Ljava/util/HashMap;", "getLayoutConfigMap", "()Ljava/util/HashMap;", "setLayoutConfigMap", "(Ljava/util/HashMap;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h8 {

    @SerializedName("layout_config_map")
    private HashMap<Integer, HashMap<Integer, b>> layoutConfigMap;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/h8$b;", "", "Lcom/bytedance/android/livesdk/config/h8$b$a;", "canvas", "Lcom/bytedance/android/livesdk/config/h8$b$a;", "getCanvas", "()Lcom/bytedance/android/livesdk/config/h8$b$a;", "setCanvas", "(Lcom/bytedance/android/livesdk/config/h8$b$a;)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/config/h8$b$c;", "Lkotlin/collections/ArrayList;", "slots", "Ljava/util/ArrayList;", "getSlots", "()Ljava/util/ArrayList;", "setSlots", "(Ljava/util/ArrayList;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("canvas")
        private a canvas;

        @SerializedName("slots")
        private ArrayList<c> slots;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/h8$b$a;", "", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a {

            @SerializedName("height")
            private int height;

            @SerializedName("width")
            private int width;

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.config.h8$b$b, reason: collision with other inner class name */
        public static final class C1767b {
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/config/h8$b$c;", "", "", "p", "I", "getP", "()I", "setP", "(I)V", "", "x", FaceService.girlLabel, "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "w", "getW", "setW", "h", "getH", "setH", "", "need_UI", "Z", "getNeed_UI", "()Z", "setNeed_UI", "(Z)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class c {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            @SerializedName("h")
            private float f120347h;

            @SerializedName("need_UI")
            private boolean need_UI;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            @SerializedName("p")
            private int f120348p;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            @SerializedName("w")
            private float f120349w;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            @SerializedName("x")
            private float f120350x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            @SerializedName("y")
            private float f120351y;

            public c() {
            }
        }

        static {
        }

        public b() {
            this.canvas = new a();
            this.slots = new ArrayList();
        }
    }

    static {
    }

    public h8() {
        this.layoutConfigMap = new HashMap();
    }
}
