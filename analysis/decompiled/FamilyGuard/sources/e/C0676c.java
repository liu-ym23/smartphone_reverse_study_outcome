package e;

import android.content.Context;
import android.content.Intent;
import d.C0640a;
import j4.g;
import j4.k;

/* renamed from: e.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0676c extends AbstractC0674a<Intent, C0640a> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16632a = new a(null);

    /* renamed from: e.c$a */
    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    @Override // e.AbstractC0674a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent intent) {
        k.g(context, "context");
        k.g(intent, "input");
        return intent;
    }

    @Override // e.AbstractC0674a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0640a c(int i5, Intent intent) {
        return new C0640a(i5, intent);
    }
}
