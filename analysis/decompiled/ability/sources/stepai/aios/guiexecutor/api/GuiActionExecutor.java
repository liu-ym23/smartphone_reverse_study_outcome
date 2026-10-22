package stepai.aios.guiexecutor.api;

import H7.c;
import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.capability.model.WindowStateInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import stepai.aios.guiagent.config.Action;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J:\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0004\b\u000b\u0010\fJ>\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0004\b\u0013\u0010\u0014JB\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00162\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0004\b\u0018\u0010\u0019JT\u0010\u001e\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00162\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00162\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0004\b\u001e\u0010\u001fJ,\u0010\"\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0004\b\"\u0010#¨\u0006$À\u0006\u0003"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiActionExecutor;", "", "Landroid/content/Context;", "context", "", "packageName", "", WindowStateInfo.KEY_DISPLAY_ID, "Lstepai/aios/guiagent/config/Action;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lkotlin/Result;", "openApp-yxL6bBk", "(Landroid/content/Context;Ljava/lang/String;ILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "openApp", "", "x", "y", "", RequestInfo.FUNCTION_LONG_CLICK, RequestInfo.FUNCTION_CLICK, "(FFZILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "text", "Lkotlin/Pair;", "coordinates", "input", "(Ljava/lang/String;Lkotlin/Pair;ILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "startPoint", "endPoint", "", TypedValues.TransitionType.S_DURATION, RequestInfo.FUNCTION_SWIPE, "(Lkotlin/Pair;Lkotlin/Pair;JILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiexecutor/api/SystemNavigationAction;", "systemNavigationAction", "systemNavigation", "(Lstepai/aios/guiexecutor/api/SystemNavigationAction;ILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface GuiActionExecutor {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object click$default(GuiActionExecutor guiActionExecutor, float f, float f7, boolean z10, int i, Action action, c cVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: click");
        }
        if ((i6 & 4) != 0) {
            z10 = false;
        }
        if ((i6 & 8) != 0) {
            i = 0;
        }
        return guiActionExecutor.click(f, f7, z10, i, action, cVar);
    }

    static /* synthetic */ Object input$default(GuiActionExecutor guiActionExecutor, String str, Pair pair, int i, Action action, c cVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: input");
        }
        if ((i6 & 4) != 0) {
            i = 0;
        }
        return guiActionExecutor.input(str, pair, i, action, cVar);
    }

    /* renamed from: openApp-yxL6bBk$default, reason: not valid java name */
    static /* synthetic */ Object m7367openAppyxL6bBk$default(GuiActionExecutor guiActionExecutor, Context context, String str, int i, Action action, c cVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openApp-yxL6bBk");
        }
        if ((i6 & 4) != 0) {
            i = 0;
        }
        return guiActionExecutor.mo7351openAppyxL6bBk(context, str, i, action, cVar);
    }

    static /* synthetic */ Object swipe$default(GuiActionExecutor guiActionExecutor, Pair pair, Pair pair2, long j5, int i, Action action, c cVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: swipe");
        }
        if ((i6 & 8) != 0) {
            i = 0;
        }
        return guiActionExecutor.swipe(pair, pair2, j5, i, action, cVar);
    }

    static /* synthetic */ Object systemNavigation$default(GuiActionExecutor guiActionExecutor, SystemNavigationAction systemNavigationAction, int i, Action action, c cVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: systemNavigation");
        }
        if ((i6 & 2) != 0) {
            i = 0;
        }
        return guiActionExecutor.systemNavigation(systemNavigationAction, i, action, cVar);
    }

    Object click(float f, float f7, boolean z10, int i, Action action, c<? super Boolean> cVar);

    Object input(String str, Pair<Integer, Integer> pair, int i, Action action, c<? super Boolean> cVar);

    /* renamed from: openApp-yxL6bBk */
    Object mo7351openAppyxL6bBk(Context context, String str, int i, Action action, c<? super Result<String>> cVar);

    Object swipe(Pair<Integer, Integer> pair, Pair<Integer, Integer> pair2, long j5, int i, Action action, c<? super Boolean> cVar);

    Object systemNavigation(SystemNavigationAction systemNavigationAction, int i, Action action, c<? super Boolean> cVar);
}
