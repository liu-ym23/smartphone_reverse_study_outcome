package D;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import o1.C4996a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"LD/y;", "", "<init>", "()V", "", "label", "Ljava/lang/Runnable;", "block", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/Runnable;)V", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: D.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0787y {

    /* renamed from: a, reason: collision with root package name */
    public static final C0787y f2195a = new C0787y();

    public static final void a(String label, Runnable block) {
        kotlin.jvm.internal.p.i(label, "label");
        kotlin.jvm.internal.p.i(block, "block");
        C4996a.a("CX:" + label);
        try {
            block.run();
            Y8.t tVar = Y8.t.f7040a;
        } finally {
            C4996a.b();
        }
    }
}
