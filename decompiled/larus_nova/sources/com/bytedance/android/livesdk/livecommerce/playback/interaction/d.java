package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/d;", "", "", "type", "I", "getType", "()I", "", "Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/f;", SlcElement.KEY_ELEMENTS, "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName(SlcElement.KEY_ELEMENTS)
    private final List<f> elements;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_INTERACTION_TYPE)
    private final int type;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.elements, r101.elements) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.type * 31;
        List<f> r101 = this.elements;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "InteractionContent(type=" + this.type + ", elements=" + this.elements + ")";
    }

    public d() {
        this.type = 0;
        this.elements = null;
    }

    public final List<f> a() {
        return this.elements;
    }

    public final int getType() {
        return this.type;
    }
}
