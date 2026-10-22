package android.view;

import U0.b;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import g1.C4091b;
import g1.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\tB\u001f\b\u0016\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/F;", "", "", "", "initialState", "<init>", "(Ljava/util/Map;)V", "()V", "Lg1/e$b;", Const.INTENT_KEY_APIKEY, "()Lg1/e$b;", "", "Ljava/util/Map;", "liveDatas", "LU0/b;", Const.INTENT_KEY_PKGNAME, "LU0/b;", "impl", "c", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class F {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Object> liveDatas;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public b impl;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\t\u001a\u00020\b2\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u000e\u0010\u0007\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/F$a;", "", "<init>", "()V", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "restoredState", "defaultState", "Landroidx/lifecycle/F;", Const.INTENT_KEY_APIKEY, "(Landroid/os/Bundle;Landroid/os/Bundle;)Landroidx/lifecycle/F;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.lifecycle.F$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final F a(Bundle restoredState, Bundle defaultState) {
            if (restoredState == null) {
                restoredState = defaultState;
            }
            if (restoredState == null) {
                return new F();
            }
            ClassLoader classLoader = F.class.getClassLoader();
            p.f(classLoader);
            restoredState.setClassLoader(classLoader);
            return new F(C4091b.g(C4091b.a(restoredState)));
        }

        public Companion() {
        }
    }

    public F(Map<String, ? extends Object> initialState) {
        p.i(initialState, "initialState");
        this.liveDatas = new LinkedHashMap();
        this.impl = new b(initialState);
    }

    public final e.b a() {
        return this.impl.getSavedStateProvider();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public F() {
        this.liveDatas = new LinkedHashMap();
        this.impl = new b(null, 1, 0 == true ? 1 : 0);
    }
}
