package a1b;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$LarkletConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends z0b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1403a = 0;

    /* JADX INFO: renamed from: a1b.a$a, reason: collision with other inner class name */
    public static final class C0003a {
    }

    public final class b extends AbsChameleonHandler<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1404a;

        public b() {
            this.f1404a = LKAPIModules.App.GetLarkletConfig.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f1404a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            r100.success(new IApp$LarkletConfig(new ArrayList(), ""));
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    public a() {
    }
}
