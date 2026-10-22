package l2;

import android.database.Cursor;
import l2.B;

/* loaded from: classes2.dex */
public final /* synthetic */ class u implements B.b {

    /* renamed from: a, reason: collision with root package name */
    public static final u f36935a = new u();

    public static B.b a() {
        return f36935a;
    }

    @Override // l2.B.b
    public Object apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
