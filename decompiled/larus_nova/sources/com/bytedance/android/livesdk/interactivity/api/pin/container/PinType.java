package com.bytedance.android.livesdk.interactivity.api.pin.container;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/pin/container/PinType;", "", "", "toString", "", "dataType", "I", "getDataType", "()I", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", CancelRetainContactInfoFunctions.All, "Unknown", "Answer", "Comment", "Video", "MicroApp", "Im", "CommonPictureText", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PinType extends Enum<PinType> {
    public static final PinType All = null;
    public static final PinType Answer = null;
    public static final PinType Comment = null;
    public static final PinType CommonPictureText = null;
    public static final PinType Im = null;
    public static final PinType MicroApp = null;
    public static final PinType Unknown = null;
    public static final PinType Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PinType[] f133355a = null;
    private final int dataType;
    private final String desc;

    public static PinType valueOf(String r100) {
        return (PinType) a.a(PinType.class, r100);
    }

    public static PinType[] values() {
        return (PinType[]) f133355a.clone();
    }

    static {
        PinType r100 = new PinType(CancelRetainContactInfoFunctions.All, 0, -1, "all");
        All = r100;
        PinType r101 = new PinType("Unknown", 1, 0, "unknown");
        Unknown = r101;
        PinType r102 = new PinType("Answer", 2, 3, "answer");
        Answer = r102;
        PinType r103 = new PinType("Comment", 3, 4, "comment");
        Comment = r103;
        PinType r104 = new PinType("Video", 4, 5, "video");
        Video = r104;
        PinType r105 = new PinType("MicroApp", 5, 6, AppbrandHostConstants.Micro_Host.HOST_APPBRAND);
        MicroApp = r105;
        PinType r106 = new PinType("Im", 6, 7, "im");
        Im = r106;
        PinType r107 = new PinType("CommonPictureText", 7, 8, "common_picture_text");
        CommonPictureText = r107;
        f133355a = new PinType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final String getDesc() {
        return this.desc;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.desc;
    }

    public PinType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.dataType = r102;
        this.desc = r103;
    }
}
