package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends BaseDispatchAction {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7491o;

    static {
    }

    public f() {
        this.f7491o = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean e(JSONObject r10, String r11, long r12) {
        ArrayList r13 = new ArrayList();
        r13.add(0, Boolean.FALSE);
        boolean r14 = s(r10, r13, r11, r12);
        this.f7491o = ((Boolean) r13.get(0)).booleanValue();
        return r14;
    }

    public abstract BaseDispatchAction.DispatchResultEnum q(String r10, List r11);

    public abstract int r();

    public abstract boolean s(JSONObject r10, List r11, String r12, long r13);

    public boolean t() {
        return this.f7491o;
    }

    public BaseDispatchAction.DispatchResultEnum u(u4.c r10, String r11, List r12, List r13) {
        if (f(r10) == true) goto L5;
    L15:
        r12.set(0, r11);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        BaseDispatchAction.DispatchResultEnum r14 = q(r11, r12);
        u4.a r15 = new u4.a();
        if (r14 == BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE) goto L13;
        r15.f24854d = true;
        r15.f24852b = c();
        r15.f24853c = b();
        r15.f24855e = r();
        r15.f24851a = d();
        if (r14 != BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT) goto L12;
        r15.f24857g = (String) r12.get(0);
        r15.f24856f = t();
    L12:
        r10.d(this.f7468l);
    L13:
        r13.add(r15);
        return r14;
    }
}
