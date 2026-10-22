package C;

import android.content.res.Resources;
import java.util.Objects;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f267a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f268b;

    public m(Resources resources, Resources.Theme theme) {
        this.f267a = resources;
        this.f268b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f267a.equals(mVar.f267a) && Objects.equals(this.f268b, mVar.f268b);
    }

    public final int hashCode() {
        return Objects.hash(this.f267a, this.f268b);
    }
}
