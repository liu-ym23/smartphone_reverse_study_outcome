package com.bytedance.apm.battery.hook;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public interface IHookService {
    String getInterfaceName();

    void invoke(Object r10, Method r11, Object[] r12);
}
