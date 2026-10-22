package pa;

import ia.C1571a;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* renamed from: pa.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1793a {

    /* renamed from: a, reason: collision with root package name */
    public static final CharsetDecoder f5570a = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT);
    public static final C1571a b = new C1571a();
}
