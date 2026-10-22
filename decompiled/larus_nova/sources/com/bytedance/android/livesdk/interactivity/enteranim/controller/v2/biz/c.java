package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/enteranim/controller/v2/biz/c;", "", "", "forAnchor", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "", "Lcom/bytedance/android/livesdk/interactivity/enteranim/controller/v2/biz/m;", InvRouter.SCENES, "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("forAnchor")
    private final Integer forAnchor;

    @SerializedName(InvRouter.SCENES)
    private final List<m> scenes;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final Integer a() {
        return this.forAnchor;
    }

    public final List<m> b() {
        return this.scenes;
    }
}
