package com.stepos.ability.voicewakeup.service;

import C7.r;
import D7.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3326a;
    public final /* synthetic */ WakeupEngine b;

    public /* synthetic */ e(WakeupEngine wakeupEngine, int i) {
        this.f3326a = i;
        this.b = wakeupEngine;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f3326a;
        r rVar = r.f317a;
        WakeupEngine wakeupEngine = this.b;
        switch (i) {
            case 0:
                l lVar = l.f3333a;
                l.o(false, new e(wakeupEngine, 2));
                break;
            case 1:
                l lVar2 = l.f3333a;
                l.o(false, new e(wakeupEngine, 3));
                break;
            case 2:
                if (l.m == wakeupEngine) {
                    HashMap map = l.f3336r;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : map.entrySet()) {
                        if (((Boolean) entry.getValue()).booleanValue()) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    Iterator it = v.f1(linkedHashMap.keySet()).iterator();
                    while (it.hasNext()) {
                        l.f3333a.n(wakeupEngine, (String) it.next());
                    }
                    break;
                }
                break;
            default:
                l lVar3 = l.f3333a;
                l.j(wakeupEngine, "serviceDied");
                break;
        }
        return rVar;
    }
}
