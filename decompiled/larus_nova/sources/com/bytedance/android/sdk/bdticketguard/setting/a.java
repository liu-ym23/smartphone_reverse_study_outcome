package com.bytedance.android.sdk.bdticketguard.setting;

import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> extends d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile C2502a f163985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f163986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f163987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<JSONObject> f163988d;

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.setting.a$a, reason: collision with other inner class name */
    public static final class C2502a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2502a f163989a = null;

        public C2502a() {
        }

        static {
            f163989a = new C2502a();
        }
    }

    public abstract T b(JSONObject r100, String r101, T r102);

    @Override // com.bytedance.android.sdk.bdticketguard.setting.d
    public final T a() {
        JSONObject r100 = this.f163988d.invoke();
        if (this.f163985a != C2502a.f163989a) goto L5;
        T r101 = this.f163987c;
    L7:
        return b(r100, this.f163986b, r101);
    L5:
        r101 = (T) this.f163985a;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, T r101, Function0<? extends JSONObject> r102) {
        this.f163986b = r100;
        this.f163987c = r101;
        this.f163988d = r102;
        this.f163985a = C2502a.f163989a;
    }
}
