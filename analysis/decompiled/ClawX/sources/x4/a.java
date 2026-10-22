package x4;

import java.nio.charset.MalformedInputException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends MalformedInputException {

    /* renamed from: a, reason: collision with root package name */
    public final String f6275a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String message) {
        super(0);
        p.e(message, "message");
        this.f6275a = message;
    }

    @Override // java.nio.charset.MalformedInputException, java.lang.Throwable
    public final String getMessage() {
        return this.f6275a;
    }
}
