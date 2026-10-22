package org.java_websocket.exceptions;

/* loaded from: classes5.dex */
public class IncompleteHandshakeException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final int f37834a;

    public IncompleteHandshakeException(int i10) {
        this.f37834a = i10;
    }

    public int a() {
        return this.f37834a;
    }

    public IncompleteHandshakeException() {
        this.f37834a = 0;
    }
}
