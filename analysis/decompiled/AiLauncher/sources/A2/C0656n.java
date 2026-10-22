package A2;

import j3.InterfaceC4766d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: A2.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0656n {

    /* renamed from: a, reason: collision with root package name */
    public final Map f798a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f799b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4766d f800c;

    public C0656n(Map map, Map map2, InterfaceC4766d interfaceC4766d) {
        this.f798a = map;
        this.f799b = map2;
        this.f800c = interfaceC4766d;
    }

    public final byte[] a(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new C0638k(byteArrayOutputStream, this.f798a, this.f799b, this.f800c).h(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
