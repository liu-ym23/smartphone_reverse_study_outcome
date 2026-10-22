package p0;

import android.text.Editable;
import androidx.emoji2.text.y;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f4642a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f4643b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f4644c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f4644c;
        return cls != null ? new y(cls, charSequence) : super.newEditable(charSequence);
    }
}
