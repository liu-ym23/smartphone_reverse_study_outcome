package c;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1679a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f1680b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1681c;

    /* renamed from: d, reason: collision with root package name */
    public final transient LinkedHashMap f1682d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f1683e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f1684f;

    public h() {
        new LinkedHashMap();
        this.f1681c = new ArrayList();
        this.f1682d = new LinkedHashMap();
        this.f1683e = new LinkedHashMap();
        this.f1684f = new Bundle();
    }

    public final boolean a(int i2, int i10, Intent intent) {
        String str = (String) this.f1679a.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        if (this.f1682d.get(str) != null) {
            throw new ClassCastException();
        }
        this.f1683e.remove(str);
        this.f1684f.putParcelable(str, new g.b(intent, i10));
        return true;
    }
}
