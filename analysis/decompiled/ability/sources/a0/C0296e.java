package a0;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;

/* renamed from: a0.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0296e extends AbstractC0292a {
    @Override // w0.AbstractC2080a
    public final void j() {
        if (this.g) {
            if (!this.b || this.h) {
                String topActivityClassName = ActivityLifeObserver.getInstance().getTopActivityClassName();
                if (TextUtils.isEmpty(topActivityClassName)) {
                    topActivityClassName = "null";
                }
                L0.d.f925a.b(new A.a(8, this, topActivityClassName));
            }
        }
    }
}
