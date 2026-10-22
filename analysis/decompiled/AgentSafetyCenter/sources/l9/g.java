package l9;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7782c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f7783f;

    @Override // xb.l
    public final Object invoke(Object obj) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i = this.f7782c;
        boolean z10 = this.f7783f;
        switch (i) {
            case 0:
                Context context = (Context) obj;
                context.getClass();
                eb.a aVar = new eb.a(a.h(context));
                aVar.setChecked(z10);
                aVar.setEnabled(true);
                aVar.setClickable(false);
                aVar.setFocusable(false);
                aVar.setFocusableInTouchMode(false);
                return aVar;
            default:
                eb.a aVar2 = (eb.a) obj;
                aVar2.getClass();
                aVar2.setEnabled(true);
                aVar2.setClickable(false);
                aVar2.setFocusable(false);
                if (aVar2.isChecked() != z10) {
                    aVar2.setOnCheckedChangeListener(null);
                    aVar2.setChecked(z10);
                }
                return v.f6774a;
        }
    }
}
