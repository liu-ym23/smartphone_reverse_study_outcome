package com.baidu.xclient.gdid.jni;

import ch.qos.logback.classic.net.SyslogAppender;
import com.baidu.xclient.gdid.j.f;

/* loaded from: classes.dex */
public class Native {

    /* renamed from: a, reason: collision with root package name */
    public static String f9553a = "";

    static {
        try {
            System.loadLibrary("tiny_magic");
        } catch (Throwable th) {
            f9553a = f.b(th).replaceAll(SyslogAppender.DEFAULT_STACKTRACE_PATTERN, ";").replaceAll("\n", ";");
            throw th;
        }
    }

    public String a() {
        return f9553a;
    }

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] acn(byte[] bArr, byte[] bArr2);

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native byte[] dcn(byte[] bArr, byte[] bArr2);

    public native Object jnictl(int i4, Object obj, Object obj2, Object obj3);
}
