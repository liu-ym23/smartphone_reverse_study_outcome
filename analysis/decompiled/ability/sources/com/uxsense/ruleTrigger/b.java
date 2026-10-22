package com.uxsense.ruleTrigger;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ApexTriggerManager f4208a;

    public /* synthetic */ b(ApexTriggerManager apexTriggerManager) {
        this.f4208a = apexTriggerManager;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.f4208a.restoreExistingProcesses();
    }
}
