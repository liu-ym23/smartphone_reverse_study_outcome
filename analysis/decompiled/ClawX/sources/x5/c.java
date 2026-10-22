package x5;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements w5.i {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f6284a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6285b;

    /* renamed from: c, reason: collision with root package name */
    public final p5.p f6286c;

    public c(CharSequence input, int i8, p5.p pVar) {
        kotlin.jvm.internal.p.e(input, "input");
        this.f6284a = input;
        this.f6285b = i8;
        this.f6286c = pVar;
    }

    @Override // w5.i
    public final Iterator iterator() {
        return new b(this);
    }
}
