package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/fk1;", "", "", "anchorRegionMixRatio", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "c", "(F)V", "Lcom/bytedance/android/livesdk/config/a0;", "anchorPreviewPremixRect", "Lcom/bytedance/android/livesdk/config/a0;", "getAnchorPreviewPremixRect", "()Lcom/bytedance/android/livesdk/config/a0;", "b", "(Lcom/bytedance/android/livesdk/config/a0;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class fk1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f120212a = 0;

    @SerializedName("anchor_preview_premix_rect")
    private a0 anchorPreviewPremixRect;

    @SerializedName("anchor_region_mix_ratio")
    private float anchorRegionMixRatio;

    public static final class a {
        public static HashMap a() {
            HashMap r100 = new HashMap();
            fk1 r101 = new fk1();
            r101.c(0.82f);
            a0 r102 = new a0();
            r102.b();
            r102.c(0.2f);
            r102.a();
            Unit r103 = Unit.INSTANCE;
            r101.b(r102);
            r100.put(7, r101);
            fk1 r104 = new fk1();
            r104.c(0.75f);
            a0 r105 = new a0();
            r105.b();
            r105.c(0.06f);
            r105.a();
            r104.b(r105);
            r100.put(1, r104);
            fk1 r106 = new fk1();
            r106.c(1.0f);
            a0 r107 = new a0();
            r107.b();
            r107.c(0.06f);
            r107.a();
            r106.b(r107);
            r100.put(3, r106);
            return r100;
        }
    }

    static {
    }

    public fk1() {
        this.anchorRegionMixRatio = 1.0f;
        this.anchorPreviewPremixRect = new a0();
    }

    public final float a() {
        return this.anchorRegionMixRatio;
    }

    public final void b(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorPreviewPremixRect = r100;
    }

    public final void c(float r100) {
        this.anchorRegionMixRatio = r100;
    }
}
