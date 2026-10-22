package com.bytedance.android.livesdk.multilink.base.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rRv\u0010\u0006\u001aV\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0002j*\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/q0;", "", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/livesdk/multilink/base/model/q0$a;", "Lkotlin/collections/HashMap;", "layoutConfigMap", "Ljava/util/HashMap;", "getLayoutConfigMap", "()Ljava/util/HashMap;", "setLayoutConfigMap", "(Ljava/util/HashMap;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class q0 {

    @SerializedName("layout_config_map")
    private HashMap<Integer, HashMap<Integer, a>> layoutConfigMap;

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003\u0013\u0014\u0015R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/q0$a;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/multilink/base/model/q0$a$a;", "getCanvas", "()Lcom/bytedance/android/livesdk/multilink/base/model/q0$a$a;", "setCanvas", "(Lcom/bytedance/android/livesdk/multilink/base/model/q0$a$a;)V", "getCanvas$annotations", "()V", "canvas", "", "Lcom/bytedance/android/livesdk/multilink/base/model/q0$a$d;", "getSlots", "()Ljava/util/List;", "setSlots", "(Ljava/util/List;)V", "getSlots$annotations", "slots", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "d", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface a extends vh7.c<a> {
        public static final b Companion = null;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.multilink.base.model.q0$a$a, reason: collision with other inner class name */
        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/q0$a$a;", "Lvh7/c;", "", "getWidth", "()I", "setWidth", "(I)V", "getWidth$annotations", "()V", "width", "getHeight", "setHeight", "getHeight$annotations", "height", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
        public interface InterfaceC2370a extends vh7.c<InterfaceC2370a> {

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.multilink.base.model.q0$a$a$a, reason: collision with other inner class name */
            @JsonAdapter(FlexModelJsonAdapter.class)
            @Metadata(k = 3, mv = {1, 5, 1})
            public static final class C2371a {
            }

            @Override // vh7.c
            /* synthetic */ vh7.e castTo(Class r100);

            @Override // vh7.c
            /* synthetic */ vh7.e castToOrNull(Class r100);

            @FieldName(name = "height")
            int getHeight();

            @FieldName(name = "width")
            int getWidth();

            @FieldName(name = "height#setter")
            void setHeight(int r100);

            @FieldName(name = "width#setter")
            void setWidth(int r100);
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ b f153987a = null;

            public b() {
            }

            static {
                f153987a = new b();
            }
        }

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class c {
        }

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006R\"\u0010\u0011\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0005\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u0007\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010 \u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\u0010\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\"\u0010'\u001a\u00020!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\u0010\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/q0$a$d;", "Lvh7/c;", "", "canvasWidth", "", "getX", "(Ljava/lang/Integer;)F", "getW", "canvasHeight", "getY", "getH", "getP", "()I", "setP", "(I)V", "getP$annotations", "()V", "p", "", "()D", "setX", "(D)V", "getX$annotations", "x", "setY", "getY$annotations", "y", "setW", "getW$annotations", "w", "setH", "getH$annotations", "h", "", "getNeed_UI", "()Z", "setNeed_UI", "(Z)V", "getNeed_UI$annotations", "need_UI", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
        public interface d extends vh7.c<d> {

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.multilink.base.model.q0$a$d$a, reason: collision with other inner class name */
            @JsonAdapter(FlexModelJsonAdapter.class)
            @Metadata(k = 3, mv = {1, 5, 1})
            public static final class C2372a {
            }

            @Override // vh7.c
            /* synthetic */ vh7.e castTo(Class r100);

            @Override // vh7.c
            /* synthetic */ vh7.e castToOrNull(Class r100);

            @FieldName(name = "h")
            double getH();

            float getH(Integer r100);

            @FieldName(name = "need_UI")
            boolean getNeed_UI();

            @FieldName(name = "p")
            int getP();

            @FieldName(name = "w")
            double getW();

            float getW(Integer r100);

            @FieldName(name = "x")
            double getX();

            float getX(Integer r100);

            @FieldName(name = "y")
            double getY();

            float getY(Integer r100);

            @FieldName(name = "h#setter")
            void setH(double r100);

            @FieldName(name = "need_UI#setter")
            void setNeed_UI(boolean r100);

            @FieldName(name = "p#setter")
            void setP(int r100);

            @FieldName(name = "w#setter")
            void setW(double r100);

            @FieldName(name = "x#setter")
            void setX(double r100);

            @FieldName(name = "y#setter")
            void setY(double r100);
        }

        static {
            Companion = b.f153987a;
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "canvas")
        InterfaceC2370a getCanvas();

        @FieldName(name = "slots")
        List<d> getSlots();

        @FieldName(name = "canvas#setter")
        void setCanvas(InterfaceC2370a r100);

        @FieldName(name = "slots#setter")
        void setSlots(List<d> r100);
    }

    public q0() {
        this.layoutConfigMap = new HashMap();
    }
}
