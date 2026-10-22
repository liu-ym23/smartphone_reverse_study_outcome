package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/a51;", "", "", "name", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, FaceService.girlLabel, "c", "()F", "setMax", "(F)V", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "d", "setMin", "url", "f", "setUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a51 {

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
    private float max;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
    private float min;

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public static final class a {
    }

    static {
    }

    public a51() {
        float r100 = 0.0f;
        String r101 = null;
        this(r101, r100, r100, 15);
    }

    @JvmStatic
    public static final List<a51> a() {
        ArrayList r100 = new ArrayList();
        StringBuilder r101 = new StringBuilder("https://");
        LiveCommonConstants r102 = LiveCommonConstants.INSTANCE;
        r101.append(r102.getObjectTosPath());
        r101.append("/obj/live-android/ttlive_ktv_score_rating_sss.webp");
        r100.add(new a51("sss", 1.0f, 0.95f, r101.toString()));
        r100.add(new a51("ss", 0.95f, 0.9f, "https://" + r102.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_ss.webp"));
        r100.add(new a51("s", 0.9f, 0.85f, "https://" + r102.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_s.webp"));
        r100.add(new a51(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, 0.85f, 0.7f, "https://" + r102.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_a.webp"));
        r100.add(new a51("b", 0.7f, 0.5f, "https://" + r102.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_b.webp"));
        r100.add(new a51("c", 0.5f, 0.3f, "https://" + r102.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_c.webp"));
        r100.add(new a51("d", 0.3f, 0.0f, "https://" + r102.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_d.webp"));
        return r100;
    }

    @JvmStatic
    public static final List<a51> b() {
        ArrayList r100 = new ArrayList();
        float r101 = 95.0f;
        int r102 = 8;
        r100.add(new a51("perfect", 100.0f, r101, r102));
        float r103 = 80.0f;
        r100.add(new a51("great", r101, r103, r102));
        r100.add(new a51("good", r103, 60.0f, r102));
        return r100;
    }

    public final float c() {
        return this.max;
    }

    public final float d() {
        return this.min;
    }

    public final String e() {
        return this.name;
    }

    public final String f() {
        return this.url;
    }

    public /* synthetic */ a51(String r100, float r101, float r102, int r103) {
        String r104 = "";
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0.0f;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = 0.0f;
    L12:
        if ((r103 & 8) != 0) goto L15;
        r104 = null;
    L15:
        this(r100, r101, r102, r104);
    }

    public a51(String r100, float r101, float r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r103, "url");
        this.name = r100;
        this.max = r101;
        this.min = r102;
        this.url = r103;
    }
}
