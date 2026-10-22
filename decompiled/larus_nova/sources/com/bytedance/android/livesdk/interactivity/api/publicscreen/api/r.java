package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.byted.cast.linkcommon.cybergarage.upnp.IconList;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/r;", "", "", "Lpy/k;", IconList.ELEM_NAME, "Ljava/util/List;", "", "", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/s;", "iconMap", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r implements vh7.h {

    @SerializedName("icons")
    public List<py.k> iconList;

    @SerializedName("component_related_icons")
    protected Map<Long, s> iconMap;

    public r() {
    }

    public final Map<Long, s> a() {
        return this.iconMap;
    }

    public r(am3.g r110) {
        this.iconList = new ArrayList();
        this.iconMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        if (r101 != 1) goto L8;
        this.iconList.add((py.k) vh7.f.a(r110, py.k.class));
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r102 = r110.c();
        Long r103 = null;
        s r104 = null;
    L11:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = Long.valueOf(r110.j());
        goto L11
    L14:
        if (r105 != 2) goto L15;
        r104 = new s(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r102);
        Map<Long, s> r106 = this.iconMap;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r110);
        goto L3
    L27:
        r110.d(r100);
    }
}
