package com.a.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.function.Predicate;

/* JADX INFO: compiled from: Predicates.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static <T> Predicate<T> a(Predicate<T> r2) {
        return ((Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.aiagent.plugin")).negate();
    }
}
