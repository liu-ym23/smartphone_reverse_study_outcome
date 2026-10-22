package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ViewMatcher implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final ViewMatcher f4528a = new ViewMatcher();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Multi extends ViewMatcher implements Serializable {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Single extends ViewMatcher {
    }

    public static ViewMatcher a(Class<?>[] clsArr) {
        int length;
        if (clsArr == null || (length = clsArr.length) == 0) {
            return f4528a;
        }
        if (length != 1) {
            return new Multi();
        }
        Class<?> cls = clsArr[0];
        return new Single();
    }
}
