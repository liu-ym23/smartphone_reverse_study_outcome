package com.bytedance.android.livesdk.sharedpref;

import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.depend.prefs.PropertyCache;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> extends Property<T> {
    public e() {
        super("live_solo_ktv_template_last_select", "", "");
    }

    public final T a() {
        return (T) super.getValue();
    }

    @Override // com.bytedance.android.livesdkapi.depend.prefs.Property
    public final T getValue() {
        T r100 = (T) f.b(this);
        if (r100 != null) goto L6;
        T r101 = (T) PropertyCache.getValue(this);
        f.d(this, r101);
        return r101;
    L6:
        return r100;
    }

    public final void b(T r100) {
        super.setValue(r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.prefs.Property
    public final void setValue(T r100) {
        f.d(this, r100);
    }

    public e(String r100, Class<T> r101) {
        super(r100, r101);
    }

    public e(String r100, T r101) {
        super(r100, r101);
    }

    public e(String r100, Type r101, T r102) {
        super(r100, r101, r102);
    }
}
