package com.bytedance.android.ec.model.response;

import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/model/response/d;", "", "Lcom/bytedance/android/ec/model/response/j0;", "press", "Lcom/bytedance/android/ec/model/response/j0;", "b", "()Lcom/bytedance/android/ec/model/response/j0;", "setPress", "(Lcom/bytedance/android/ec/model/response/j0;)V", GestureAction.longPress, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setLongPress", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("long_press_action")
    private j0 longPress;

    @SerializedName("press_action")
    private j0 press;

    public d() {
    }

    public final j0 a() {
        return this.longPress;
    }

    public final j0 b() {
        return this.press;
    }
}
