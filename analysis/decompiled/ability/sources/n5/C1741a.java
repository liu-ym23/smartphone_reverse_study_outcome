package n5;

import F9.E;
import F9.F;
import M0.h;
import T9.b;
import android.os.SystemClock;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import f6.AbstractC1439d;
import j9.t;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import okhttp3.logging.HttpLoggingInterceptor$Level;
import s6.f;
import stepai.aios.guiagent.llm.cell.config.ModelCatalog;
import stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor;

/* renamed from: n5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C1741a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5349a;

    public /* synthetic */ C1741a(int i) {
        this.f5349a = i;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f5349a) {
            case 0:
                return MethodWrapper.pool$lambda$5();
            case 1:
                return ParameterWrapper.pool$lambda$6();
            case 2:
                return ServiceWrapper.pool$lambda$6();
            case 3:
                return Long.valueOf(SystemClock.elapsedRealtime());
            case 4:
                b bVar = new b(new h(9));
                bVar.b = HttpLoggingInterceptor$Level.c;
                E eA = ((F) AbstractC1439d.f4442a.getF4884a()).a();
                eA.a(bVar);
                eA.c(60L, TimeUnit.SECONDS);
                return new F(eA);
            case 5:
                return f.f5991a;
            case 6:
                return new com.stepos.taskrobot.taskmemory.b();
            case 7:
                return AccessibleGuiActionExecutor.accessibilityActionExecutor_delegate$lambda$0();
            case 8:
                String string = UUID.randomUUID().toString();
                k.e(string, "toString(...)");
                return t.c0(string, "-", "");
            case 9:
                return ModelCatalog.ITEMS$lambda$0();
            case 10:
                return ModelCatalog.inferModelCellFactoryByModelId$lambda$1();
            case 11:
                return ModelCatalog.inferModelCellFactoryByModelId$lambda$2();
            case 12:
                return ModelCatalog.inferModelCellFactoryByModelId$lambda$3();
            case 13:
                return ModelCatalog.inferModelCellFactoryByModelId$lambda$4();
            case 14:
                return ModelCatalog.inferModelCellFactoryByModelId$lambda$5();
            case 15:
                return ModelCatalog.inferModelCellFactoryByModelId$lambda$6();
            case 16:
                return ModelCatalog.inferModelCellFactoryByModelId$lambda$7();
            case 17:
                return ModelCatalog.inferModelCellFactoryByModelId$lambda$8();
            case 18:
                return ModelCatalog.inferModelCellFactoryByModelId$lambda$9();
            case 19:
                return ModelCatalog.ITEMS$lambda$1();
            case 20:
                return ModelCatalog.ITEMS$lambda$2();
            case 21:
                return ModelCatalog.ITEMS$lambda$3();
            case 22:
                return ModelCatalog.ITEMS$lambda$4();
            case 23:
                return ModelCatalog.ITEMS$lambda$5();
            case 24:
                return ModelCatalog.ITEMS$lambda$6();
            case 25:
                return ModelCatalog.ITEMS$lambda$7();
            case 26:
                return ModelCatalog.ITEMS$lambda$8();
            default:
                return ModelCatalog.ITEMS$lambda$9();
        }
    }
}
