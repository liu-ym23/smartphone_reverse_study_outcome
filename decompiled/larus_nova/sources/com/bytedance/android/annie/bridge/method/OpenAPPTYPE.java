package com.bytedance.android.annie.bridge.method;

import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/OpenAPPTYPE;", "", "WEIXIN", Constants.SOURCE_QQ, "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum OpenAPPTYPE extends Enum<OpenAPPTYPE> {
    public static final OpenAPPTYPE QQ = null;
    public static final OpenAPPTYPE WEIXIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenAPPTYPE[] f38466a = null;

    public static OpenAPPTYPE valueOf(String r100) {
        return (OpenAPPTYPE) r27.a.a(OpenAPPTYPE.class, r100);
    }

    public static OpenAPPTYPE[] values() {
        return (OpenAPPTYPE[]) f38466a.clone();
    }

    static {
        OpenAPPTYPE r100 = new OpenAPPTYPE("WEIXIN", 0);
        WEIXIN = r100;
        OpenAPPTYPE r101 = new OpenAPPTYPE(Constants.SOURCE_QQ, 1);
        QQ = r101;
        f38466a = new OpenAPPTYPE[]{r100, r101};
    }

    public OpenAPPTYPE(String r100, int r101) {
        super(r100, r101);
    }
}
