package com.bytedance.android.sdk.bdticketguard.setting;

import android.os.Build;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseTicketGuardSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Function1<JSONObject, Unit>> f163982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile JSONObject f163983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<? extends JSONObject> f163984c;

    public final JSONObject a() {
        Function0<? extends JSONObject> r100 = this.f163984c;
        if (r100 == null) goto L6;
        e(r100.invoke());
    L6:
        return this.f163983b;
    }

    public BaseTicketGuardSettings() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Set<Function1<JSONObject, Unit>> r100 = ConcurrentHashMap.newKeySet();
    L6:
        this.f163982a = r100;
        return;
    L5:
        r100 = Collections.newSetFromMap(new ConcurrentHashMap());
        goto L6
    }

    public final void e(JSONObject r100) {
        if (this.f163983b == r100) goto L8;
        this.f163983b = r100;
        Iterator<T> r101 = this.f163982a.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((Function1) r101.next()).invoke(r100);
        goto L6
    L10:
        return;
    }

    public final m<Boolean> b(String r100, boolean r101) {
        return new m(new e(r100, r101, new BaseTicketGuardSettings$ticketSettingBoolean$1(this)));
    }

    public final m<Long> c(String r100, long r101) {
        return new m(new g(r100, r101, new BaseTicketGuardSettings$ticketSettingLong$1(this)));
    }

    public final m<String> d(String r100, String r101) {
        return new m(new i(r100, r101, new BaseTicketGuardSettings$ticketSettingString$1(this)));
    }
}
