package z0;

import android.app.Activity;
import androidx.autofill.HintConstants;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: z0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2153a extends WeakReference {

    /* renamed from: a, reason: collision with root package name */
    public final String f6925a;
    public final String b;
    public final long c;
    public final WeakReference d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2153a(Activity activity, String str, String str2, ReferenceQueue referenceQueue) {
        super(activity, referenceQueue);
        a(activity, "referent");
        a(referenceQueue, "referenceQueue");
        a(str, "key");
        this.f6925a = str;
        a(str2, HintConstants.AUTOFILL_HINT_NAME);
        this.b = str2;
        this.c = System.currentTimeMillis();
        this.d = new WeakReference(new Object());
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str.concat(" must not be null"));
        }
    }
}
