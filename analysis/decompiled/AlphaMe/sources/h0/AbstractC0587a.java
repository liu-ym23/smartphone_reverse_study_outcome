package h0;

import k0.InterfaceC0674b;
import kotlin.jvm.JvmField;

/* renamed from: h0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0587a {

    @JvmField
    public final int endVersion;

    @JvmField
    public final int startVersion;

    public AbstractC0587a(int i4, int i5) {
        this.startVersion = i4;
        this.endVersion = i5;
    }

    public abstract void migrate(InterfaceC0674b interfaceC0674b);
}
