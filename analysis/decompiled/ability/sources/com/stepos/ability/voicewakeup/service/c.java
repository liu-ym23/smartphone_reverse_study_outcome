package com.stepos.ability.voicewakeup.service;

import D7.v;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/* loaded from: classes3.dex */
public final class c implements WakeupEngine {

    /* renamed from: a, reason: collision with root package name */
    public final F4.d f3324a;

    public c(Context context) {
        this.f3324a = new F4.d(context);
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEngine
    public final boolean attachModule() {
        return this.f3324a.a();
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEngine
    public final Set getLoadedWordIds() {
        Set setKeySet = this.f3324a.f546r.keySet();
        kotlin.jvm.internal.k.e(setKeySet, "<get-keys>(...)");
        return v.j1(setKeySet);
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEngine
    public final int getMaxSoundModels() {
        return this.f3324a.p;
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEngine
    public final boolean isSupportConcurrency() {
        return this.f3324a.o;
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x01cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.stepos.ability.voicewakeup.service.WakeupEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int loadAndStart(java.lang.String r19, java.lang.String r20, int[] r21, int r22, int r23, java.lang.String r24, int r25, byte[] r26, S7.k r27) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.InstantiationException, java.io.IOException, java.lang.SecurityException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException, java.lang.NegativeArraySizeException {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.service.c.loadAndStart(java.lang.String, java.lang.String, int[], int, int, java.lang.String, int, byte[], S7.k):int");
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEngine
    public final void release() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        F4.d dVar = this.f3324a;
        Set setKeySet = dVar.f546r.keySet();
        kotlin.jvm.internal.k.e(setKeySet, "<get-keys>(...)");
        for (String str : v.f1(setKeySet)) {
            try {
                kotlin.jvm.internal.k.c(str);
                dVar.g(str);
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
        try {
            Object obj = dVar.l;
            if (obj != null) {
                dVar.d().getMethod("detach", null).invoke(obj, null);
            }
        } catch (Exception unused) {
        }
        dVar.l = null;
        dVar.m = null;
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEngine
    public final int restart(String wordId) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.k.f(wordId, "wordId");
        F4.d dVar = this.f3324a;
        dVar.getClass();
        F4.c cVar = (F4.c) dVar.f546r.get(wordId);
        if (cVar == null || dVar.l == null) {
            return Integer.MIN_VALUE;
        }
        try {
            Object objInvoke = dVar.d().getMethod("startRecognition", Integer.TYPE, (Class) dVar.i.getF4884a()).invoke(dVar.l, Integer.valueOf(cVar.f542a), cVar.b);
            kotlin.jvm.internal.k.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) objInvoke).intValue();
        } catch (Exception e) {
            Log.e("SimpleWakeupSession", "restart wordId=" + wordId + " exception", e);
            return Integer.MIN_VALUE;
        }
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEngine
    public final void setOnResourcesAvailable(S7.a cb) {
        kotlin.jvm.internal.k.f(cb, "cb");
        F4.d dVar = this.f3324a;
        dVar.getClass();
        dVar.f548t = cb;
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEngine
    public final void setOnServiceDied(S7.a cb) {
        kotlin.jvm.internal.k.f(cb, "cb");
        F4.d dVar = this.f3324a;
        dVar.getClass();
        dVar.u = cb;
    }
}
