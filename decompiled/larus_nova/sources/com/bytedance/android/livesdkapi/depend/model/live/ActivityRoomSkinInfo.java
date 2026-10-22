package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ActivityRoomSkinInfo;", "", "", "", "Lpy/k;", "verticalImages", "Ljava/util/Map;", "getVerticalImages", "()Ljava/util/Map;", "setVerticalImages", "(Ljava/util/Map;)V", "horizontalImages", "getHorizontalImages", "setHorizontalImages", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ActivityRoomSkinInfo implements h {

    @SerializedName("horizontal_screen")
    protected Map<Integer, k> horizontalImages;

    @SerializedName("vertical_screen")
    protected Map<Integer, k> verticalImages;

    public ActivityRoomSkinInfo() {
    }

    public final Map<Integer, k> getHorizontalImages() {
        return this.horizontalImages;
    }

    public final Map<Integer, k> getVerticalImages() {
        return this.verticalImages;
    }

    public ActivityRoomSkinInfo(g r110) {
        this.verticalImages = new HashMap();
        this.horizontalImages = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L41;
        Integer r102 = null;
        if (r101 == 1) goto L25;
        if (r101 != 2) goto L8;
        long r103 = r110.c();
        Object r104 = null;
    L10:
        int r111 = r110.f();
        if (r111 == (-1)) goto L17;
        if (r111 != 1) goto L13;
        r102 = Integer.valueOf(r110.i());
        goto L10
    L13:
        if (r111 != 2) goto L14;
        r104 = f.a(r110, k.class);
        goto L10
    L14:
        am3.h.e(r110);
        goto L10
    L17:
        r110.d(r103);
        Map r105 = this.horizontalImages;
        if (r102 == null) goto L24;
        if (r104 == null) goto L22;
    L36:
        r105.put(r102, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L8:
        am3.h.e(r110);
        goto L3
    L25:
        long r106 = r110.c();
        r104 = null;
    L26:
        int r112 = r110.f();
        if (r112 == (-1)) goto L33;
        if (r112 != 1) goto L29;
        r102 = Integer.valueOf(r110.i());
        goto L26
    L29:
        if (r112 != 2) goto L30;
        r104 = f.a(r110, k.class);
        goto L26
    L30:
        am3.h.e(r110);
        goto L26
    L33:
        r110.d(r106);
        r105 = this.verticalImages;
        if (r102 == null) goto L40;
        if (r104 != null) goto L36;
        throw new IllegalStateException("Value must not be null");
    L40:
        throw new IllegalStateException("Key must not be null");
    L41:
        r110.d(r100);
    }

    public final void setHorizontalImages(Map<Integer, k> r100) {
        this.horizontalImages = r100;
    }

    public final void setVerticalImages(Map<Integer, k> r100) {
        this.verticalImages = r100;
    }
}
