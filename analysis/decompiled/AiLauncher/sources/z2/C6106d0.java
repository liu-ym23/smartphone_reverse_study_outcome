package z2;

import j3.InterfaceC4766d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: z2.d0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6106d0 {

    /* renamed from: a, reason: collision with root package name */
    public final Map f44982a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f44983b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4766d f44984c;

    public C6106d0(Map map, Map map2, InterfaceC4766d interfaceC4766d) {
        this.f44982a = map;
        this.f44983b = map2;
        this.f44984c = interfaceC4766d;
    }

    public final byte[] a(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new C6076a0(byteArrayOutputStream, this.f44982a, this.f44983b, this.f44984c).h(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
