package com.stepos.deepbinder.service.api;

import f.a;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public interface ServiceInterceptor {
    Object afterMethodInvoke(Method method, Object obj);

    boolean beforeMethodInvoke(Method method);
}
