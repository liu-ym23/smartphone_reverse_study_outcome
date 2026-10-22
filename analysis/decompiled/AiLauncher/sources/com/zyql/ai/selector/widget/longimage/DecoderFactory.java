package com.zyql.ai.selector.widget.longimage;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException;
}
