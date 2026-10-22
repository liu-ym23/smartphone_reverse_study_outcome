package com.bytedance.android.format.model;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayType;", "", "", "type", "I", "getType", "()I", "", "semanticName", "Ljava/lang/String;", "getSemanticName", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", OuterPayLoginWrapper.LOGIN_STYLE_V1, "V2", "V3", "V4", "V5", "VideoInteract", "V7", "V8", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FormatLivePlayType extends Enum<FormatLivePlayType> {
    public static final a Companion = null;
    public static final FormatLivePlayType UNKNOWN = null;
    public static final FormatLivePlayType V1 = null;
    public static final FormatLivePlayType V2 = null;
    public static final FormatLivePlayType V3 = null;
    public static final FormatLivePlayType V4 = null;
    public static final FormatLivePlayType V5 = null;
    public static final FormatLivePlayType V7 = null;
    public static final FormatLivePlayType V8 = null;
    public static final FormatLivePlayType VideoInteract = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FormatLivePlayType[] f51334a = null;
    private final String semanticName;
    private final int type;

    public static FormatLivePlayType valueOf(String r100) {
        return (FormatLivePlayType) r27.a.a(FormatLivePlayType.class, r100);
    }

    public static FormatLivePlayType[] values() {
        return (FormatLivePlayType[]) f51334a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.format.model.FormatLivePlayType$a] */
    static {
        FormatLivePlayType r100 = new FormatLivePlayType("UNKNOWN", 0, 0, "unknown");
        UNKNOWN = r100;
        FormatLivePlayType r101 = new FormatLivePlayType(OuterPayLoginWrapper.LOGIN_STYLE_V1, 1, 1, "stream");
        V1 = r101;
        FormatLivePlayType r102 = new FormatLivePlayType("V2", 2, 2, "slice");
        V2 = r102;
        FormatLivePlayType r103 = new FormatLivePlayType("V3", 3, 3, "virtual");
        V3 = r103;
        FormatLivePlayType r104 = new FormatLivePlayType("V4", 4, 4, "production");
        V4 = r104;
        FormatLivePlayType r105 = new FormatLivePlayType("V5", 5, 5, "interactive_script");
        V5 = r105;
        FormatLivePlayType r106 = new FormatLivePlayType("VideoInteract", 6, 6, "interact_video");
        VideoInteract = r106;
        FormatLivePlayType r107 = new FormatLivePlayType("V7", 7, 7, "avatar_open");
        V7 = r107;
        FormatLivePlayType r108 = new FormatLivePlayType("V8", 8, 8, "biz_ad");
        V8 = r108;
        f51334a = new FormatLivePlayType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        Companion = new a();
    }

    public final String getSemanticName() {
        return this.semanticName;
    }

    public final int getType() {
        return this.type;
    }

    public FormatLivePlayType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.type = r102;
        this.semanticName = r103;
    }
}
