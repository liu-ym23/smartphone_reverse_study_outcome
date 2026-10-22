package c4;

import a4.y;
import android.text.Editable;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f2189a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f2190b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f2191c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f2191c;
        if (cls == null) {
            return super.newEditable(charSequence);
        }
        y yVar = new y(charSequence);
        yVar.f215f = new ArrayList();
        yVar.f214c = cls;
        VarHandle.storeStoreFence();
        return yVar;
    }
}
