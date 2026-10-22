package com.bytedance.ai.model.objects;

import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/model/objects/PermissionDetail;", "", "<init>", "()V", SocialConstants.PARAM_APP_DESC, "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "apis", "", "getApis", "()Ljava/util/List;", "setApis", "(Ljava/util/List;)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionDetail {
    private List<String> apis;
    private String desc;

    public PermissionDetail() {
        this.desc = "";
        this.apis = new ArrayList();
    }

    public final List<String> getApis() {
        return this.apis;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setApis(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.apis = r100;
    }

    public final void setDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.desc = r100;
    }
}
