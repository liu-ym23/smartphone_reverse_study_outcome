package com.obric.autogui.util.doubao.settings;

import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: FlowSettingFallbackRepoImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autogui.common.a.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f31521a;

    public a() {
        this(0, 1, null);
    }

    public a(long r1) {
        this.f31521a = r1;
    }

    public /* synthetic */ a(long r1, int r3, h r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }

    @Override // com.obric.autogui.common.a.a.a
    public long getVersion() {
        return this.f31521a;
    }

    @Override // com.obric.autogui.common.a.a.a
    public String getStringCfg(String r3) {
        o.e(r3, "key");
        c.a(c.f31526a, false, 1, null);
        return null;
    }

    @Override // com.obric.autogui.common.a.a.a
    public boolean getBooleanCfg(String r3, boolean r4) {
        o.e(r3, "key");
        c.a(c.f31526a, false, 1, null);
        return r4;
    }

    @Override // com.obric.autogui.common.a.a.a
    public int getIntCfg(String r3, int r4) {
        o.e(r3, "key");
        c.a(c.f31526a, false, 1, null);
        return r4;
    }

    @Override // com.obric.autogui.common.a.a.a
    public long getLongCfg(String r3, long r4) {
        o.e(r3, "key");
        c.a(c.f31526a, false, 1, null);
        return r4;
    }

    @Override // com.obric.autogui.common.a.a.a
    public List<?> getListCfg(String r3) {
        o.e(r3, "key");
        c.a(c.f31526a, false, 1, null);
        return null;
    }
}
