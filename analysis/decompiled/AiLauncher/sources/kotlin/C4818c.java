package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import j8.InterfaceC4782h;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m8.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lk8/c;", "", "<init>", "()V", "", "name", "Lj8/h;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lj8/h;", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: k8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4818c {

    /* renamed from: a, reason: collision with root package name */
    public static final C4818c f34638a = new C4818c();

    public final InterfaceC4782h a(String name) {
        p.i(name, "name");
        if (System.getProperty("kotlin-logging-to-android-native") != null) {
            return new C4817b(name);
        }
        k kVar = k.f37189a;
        return kVar.b(kVar.a(name));
    }
}
