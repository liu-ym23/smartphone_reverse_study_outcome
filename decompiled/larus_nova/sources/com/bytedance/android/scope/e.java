package com.bytedance.android.scope;

import java.util.Collection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
public interface e {
    <T> void a(KClass<T> r100, Collection<? super T> r101);

    <T> T b(KClass<T> r100);

    <T> T d(Object r100);
}
