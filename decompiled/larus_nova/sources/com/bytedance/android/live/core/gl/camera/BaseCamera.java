package com.bytedance.android.live.core.gl.camera;

import com.bytedance.android.live.core.gl.primitive.Align;
import com.bytedance.android.live.core.gl.primitive.e;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public abstract class BaseCamera {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f64799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f64800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f64801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f64802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f64803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f64804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f64805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Align f64806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f64807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f64808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ClampType f64809k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/gl/camera/BaseCamera$ClampType;", "", UserProfileEvent.POSITION_NONE, "HORIZONTAL", "VERTICAL", "INNER_BORDER", "OUTER_BORDER", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ClampType extends Enum<ClampType> {
        public static final ClampType HORIZONTAL = null;
        public static final ClampType INNER_BORDER = null;
        public static final ClampType NONE = null;
        public static final ClampType OUTER_BORDER = null;
        public static final ClampType VERTICAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ClampType[] f64810a = null;

        static {
            ClampType r100 = new ClampType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            ClampType r101 = new ClampType("HORIZONTAL", 1);
            HORIZONTAL = r101;
            ClampType r102 = new ClampType("VERTICAL", 2);
            VERTICAL = r102;
            ClampType r103 = new ClampType("INNER_BORDER", 3);
            INNER_BORDER = r103;
            ClampType r104 = new ClampType("OUTER_BORDER", 4);
            OUTER_BORDER = r104;
            f64810a = new ClampType[]{r100, r101, r102, r103, r104};
        }

        public static ClampType valueOf(String r100) {
            return (ClampType) a.a(ClampType.class, r100);
        }

        public static ClampType[] values() {
            return (ClampType[]) f64810a.clone();
        }

        public ClampType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract void a();

    public BaseCamera() {
        this.f64799a = new int[4];
        this.f64800b = new float[16];
        this.f64801c = new float[16];
        this.f64802d = new e(0.0f, 0.0f, 10.0f);
        this.f64803e = new e(0.0f, 0.0f, 0.0f);
        this.f64804f = new e(0.0f, 1.0f, 0.0f);
        this.f64805g = 1.0f;
        this.f64806h = Align.CENTER;
        this.f64807i = 10.0f;
        this.f64809k = ClampType.NONE;
    }
}
