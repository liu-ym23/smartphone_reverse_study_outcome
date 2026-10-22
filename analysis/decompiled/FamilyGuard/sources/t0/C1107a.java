package t0;

import java.lang.reflect.Type;
import q0.C0946I;
import q0.U;
import springfox.documentation.spring.web.json.Json;

/* renamed from: t0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1107a implements U {

    /* renamed from: a, reason: collision with root package name */
    public static final C1107a f22316a = new C1107a();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        c0946i.y().write(((Json) obj).value());
    }
}
