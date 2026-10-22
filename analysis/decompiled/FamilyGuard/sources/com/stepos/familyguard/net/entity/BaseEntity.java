package com.stepos.familyguard.net.entity;

import m0.InterfaceC0854b;

/* loaded from: classes.dex */
public class BaseEntity<T> {

    @InterfaceC0854b(alternateNames = {"status", "errCode", "errorCode"})
    public int code;

    @InterfaceC0854b(alternateNames = {"msg", "errorMsg", "error"})
    public String message;

    @InterfaceC0854b(alternateNames = {"data", "result"})
    public T value;
}
