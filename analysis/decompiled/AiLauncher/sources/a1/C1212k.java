package a1;

import io.ktor.sse.ServerSentEventKt;
import java.util.Arrays;

/* renamed from: a1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1212k {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f7861a = {48, 49, 53, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f7862b = {48, 49, 48, 0};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f7863c = {48, 48, 57, 0};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f7864d = {48, 48, 53, 0};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f7865e = {48, 48, 49, 0};

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f7866f = {48, 48, 49, 0};

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f7867g = {48, 48, 50, 0};

    public static String a(byte[] bArr) {
        return (Arrays.equals(bArr, f7865e) || Arrays.equals(bArr, f7864d)) ? ServerSentEventKt.COLON : "!";
    }
}
