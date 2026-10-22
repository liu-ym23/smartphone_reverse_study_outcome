package com.bytedance.android.gamecp.business.gamedetail.component.floating;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f54338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f54339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54341e;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f54337a, r101.f54337a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54338b, r101.f54338b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54339c, r101.f54339c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54340d, r101.f54340d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54341e, r101.f54341e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 55;
    }

    public final int hashCode() {
        String r100 = this.f54337a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        h r104 = this.f54338b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f54339c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f54340d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f54341e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FloatingWindowProps(ID=" + this.f54337a + ", commonParams=" + this.f54338b + ", style=" + this.f54339c + ", text=" + this.f54340d + ", icon=" + this.f54341e + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54337a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, h r101, JSONObject r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54337a = r100;
        this.f54338b = r101;
        this.f54339c = r102;
        this.f54340d = r103;
        this.f54341e = r104;
    }
}
