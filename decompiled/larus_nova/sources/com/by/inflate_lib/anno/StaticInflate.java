package com.by.inflate_lib.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes39.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface StaticInflate {
    String[] layouts();
}
