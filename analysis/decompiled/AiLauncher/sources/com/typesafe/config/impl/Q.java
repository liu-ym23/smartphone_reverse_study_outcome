package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;

/* loaded from: classes4.dex */
public class Q {

    /* renamed from: a, reason: collision with root package name */
    public final TokenType f31783a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31784b;

    /* renamed from: c, reason: collision with root package name */
    public final b8.k f31785c;

    /* renamed from: d, reason: collision with root package name */
    public final String f31786d;

    public Q(TokenType tokenType, b8.k kVar) {
        this(tokenType, kVar, null);
    }

    public static Q c(TokenType tokenType, String str, String str2) {
        return new Q(tokenType, null, str2, str);
    }

    public boolean a(Object obj) {
        return obj instanceof Q;
    }

    public final int b() {
        b8.k kVar = this.f31785c;
        if (kVar != null) {
            return kVar.a();
        }
        return -1;
    }

    public final b8.k d() {
        b8.k kVar = this.f31785c;
        if (kVar != null) {
            return kVar;
        }
        throw new ConfigException.BugOrBroken("tried to get origin from token that doesn't have one: " + this);
    }

    public String e() {
        return this.f31786d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Q) && a(obj) && this.f31783a == ((Q) obj).f31783a;
    }

    public int hashCode() {
        return this.f31783a.hashCode();
    }

    public String toString() {
        String str = this.f31784b;
        return str != null ? str : this.f31783a.name();
    }

    public Q(TokenType tokenType, b8.k kVar, String str) {
        this(tokenType, kVar, str, null);
    }

    public Q(TokenType tokenType, b8.k kVar, String str, String str2) {
        this.f31783a = tokenType;
        this.f31785c = kVar;
        this.f31784b = str2;
        this.f31786d = str;
    }
}
