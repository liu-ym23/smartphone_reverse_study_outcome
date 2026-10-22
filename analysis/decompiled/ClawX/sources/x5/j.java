package x5;

import java.util.List;
import java.util.regex.Matcher;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Matcher f6297a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f6298b;

    /* renamed from: c, reason: collision with root package name */
    public final i f6299c;
    public h d;

    public j(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.p.e(input, "input");
        this.f6297a = matcher;
        this.f6298b = input;
        this.f6299c = new i(this);
    }

    public final List a() {
        if (this.d == null) {
            this.d = new h(this);
        }
        h hVar = this.d;
        kotlin.jvm.internal.p.b(hVar);
        return hVar;
    }
}
