package com.bytedance.android.annie.param;

import android.os.Bundle;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends c7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILatchService.e f39693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f39694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f39695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x8.b f39696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s7.c f39697e;

    public a() {
        this(null, null, null, 31);
    }

    public a(b7.b r100, Bundle r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r102 = null;
    L11:
        super(r100, r101, r102);
        this.f39693a = null;
        this.f39694b = null;
        this.f39696d = new x8.b(getUuid());
        if (r101 == null) goto L15;
        r101.putString("annie_uuid_key", getUuid());
    L15:
        if (AnnieConfigSettingKeys.ANNIE_OPEN_MULTI_WINDOW.a().booleanValue() == false) goto L17;
        s7.c r104 = new s7.a(this);
    L18:
        this.f39697e = r104;
        return;
    L17:
        r104 = new s7.b();
        goto L18
    }
}
