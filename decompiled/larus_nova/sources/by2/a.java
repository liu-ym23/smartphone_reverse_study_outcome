package by2;

import com.bytedance.android.livesdk.chatroom.model.SyncStreamResponseData;
import com.bytedance.android.livesdk.chatroom.model.s1;
import com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder;
import com.bytedance.tools.kcp.modelx.runtime.internal.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends ModelExtensionInfoHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f21387f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0376a f21388g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f21389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f21390e;

    /* JADX INFO: renamed from: by2.a$a, reason: collision with other inner class name */
    public static final class C0376a extends ModelExtensionInfoHolder.CompanionBase {
        @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder.CompanionBase
        public final ModelExtensionInfoHolder a() {
            return a.f21387f;
        }

        public C0376a(int r100) {
        }
    }

    static {
        f21388g = new C0376a(0);
        f21387f = new a();
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, Class<?>> c() {
        HashMap r100 = new HashMap(2);
        r100.put(s1.class, SyncStreamResponseData.class);
        return r100;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, List<d>> d() {
        return new HashMap(1);
    }

    public a() {
        HashSet r100 = new HashSet(2);
        r100.add(s1.class);
        Unit r101 = Unit.INSTANCE;
        this.f21389d = r100;
        this.f21390e = new HashSet(1);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> a() {
        return this.f21390e;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> b() {
        return this.f21389d;
    }
}
