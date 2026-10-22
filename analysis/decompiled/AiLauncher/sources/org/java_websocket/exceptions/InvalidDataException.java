package org.java_websocket.exceptions;

/* loaded from: classes5.dex */
public class InvalidDataException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f37835a;

    public InvalidDataException(int i10) {
        this.f37835a = i10;
    }

    public int a() {
        return this.f37835a;
    }

    public InvalidDataException(int i10, String str) {
        super(str);
        this.f37835a = i10;
    }

    public InvalidDataException(int i10, Throwable th) {
        super(th);
        this.f37835a = i10;
    }
}
