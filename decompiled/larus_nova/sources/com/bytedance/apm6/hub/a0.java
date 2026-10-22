package com.bytedance.apm6.hub;

import android.content.Context;
import com.bytedance.services.apm.api.IHttpService;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 implements du3.b {
    public a0() {
    }

    @Override // du3.b
    public void c() {
    }

    @Override // du3.b
    public JSONObject d() {
        return null;
    }

    @Override // du3.b
    public Map<String, String> e() {
        return null;
    }

    public ru3.a f() {
        return null;
    }

    public abstract it3.a g();

    @Override // du3.b
    public abstract /* synthetic */ Context getContext();

    public abstract ff7.d h();

    public abstract IHttpService i();

    public iu3.b j() {
        return null;
    }

    public mt3.j l() {
        return null;
    }

    public ku3.b k() {
        return new gu3.h();
    }
}
