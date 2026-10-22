package com.stepos.ailauncher.task.space;

import Ua.C1060i;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import android.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.C1398p;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.Z;
import androidx.core.view.a0;
import androidx.dynamicanimation.animation.e;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.R5;
import com.stepos.ailauncher.sheet.SheetSpring;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u000e*\u0001U\u0018\u0000 `2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$JG\u0010-\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060)2\b\b\u0002\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J_\u00109\u001a\u0002082\u0006\u0010\u0005\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040/2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0016\b\u0002\u00106\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0006\u0018\u0001052\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010)H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u000201H\u0002¢\u0006\u0004\b;\u0010<J!\u0010?\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0004\b?\u0010@J\u001d\u0010B\u001a\u00020+2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060)H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0006H\u0016¢\u0006\u0004\bD\u0010\u0003R\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010IR\u0016\u0010M\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010IR\u0016\u0010N\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010KR\u0016\u0010O\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010KR\u0016\u0010P\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010KR\u0014\u0010Q\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010RR\u0014\u0010T\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010RR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Z\u001a\u00020E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010]\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010_\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\\¨\u0006b"}, d2 = {"Lcom/stepos/ailauncher/task/space/MemoryFileEditFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "LY8/t;", "m0", "(Landroid/view/View;)V", "", "tabType", "S0", "(Ljava/lang/String;)Ljava/lang/String;", "l0", "r0", "k0", "U0", "", "count", "T0", "(I)V", "V0", "q0", "Lcom/stepos/ailauncher/task/space/AmooMemoryDetailFragment;", "i0", "()Lcom/stepos/ailauncher/task/space/AmooMemoryDetailFragment;", "savedMemoryId", "content", "o0", "(Ljava/lang/String;Ljava/lang/String;)V", LinkHeader.Parameters.Anchor, "M0", "K0", "p0", "Landroid/app/Dialog;", "h0", "()Landroid/app/Dialog;", "title", "message", "positiveText", "negativeText", "Lkotlin/Function0;", "onPositive", "", "animated", "w0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/a;Z)V", "Landroidx/dynamicanimation/animation/f;", "property", "", "finalValue", "Lcom/stepos/ailauncher/sheet/g0;", "spring", "Lkotlin/Function1;", "onUpdate", "onEnd", "Landroidx/dynamicanimation/animation/i;", "O0", "(Landroid/view/View;Landroidx/dynamicanimation/animation/f;FLcom/stepos/ailauncher/sheet/g0;Lp9/l;Lp9/a;)Landroidx/dynamicanimation/animation/i;", "g0", "()F", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "proceed", "l", "(Lp9/a;)Z", "onDestroyView", "Lr6/g;", "_binding", "Lr6/g;", "originalContent", "Ljava/lang/String;", "hasUnsavedChanges", "Z", "memoryId", "memoryName", "isSaving", "isDeleting", "wasExceedingLimit", "cardPositionSpring", "Lcom/stepos/ailauncher/sheet/g0;", "cardFadeSpring", "cardExitFadeSpring", "com/stepos/ailauncher/task/space/MemoryFileEditFragment$c", "scrimDimProperty", "Lcom/stepos/ailauncher/task/space/MemoryFileEditFragment$c;", "j0", "()Lr6/g;", "binding", "n0", "()Z", "isNewMemory", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MemoryFileEditFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_CONTENT = "content";
    private static final String ARG_MEMORY_ID = "memory_id";
    private static final String ARG_MEMORY_IDS = "memory_ids";
    private static final String ARG_MEMORY_NAME = "memory_name";
    private static final String ARG_TAB_TYPE = "tab_type";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_CHAR_COUNT = 500;
    private static final String TAG = "AILauncher-MemoryFileEdit";
    private r6.g _binding;
    private final SheetSpring cardExitFadeSpring;
    private final SheetSpring cardFadeSpring;
    private final SheetSpring cardPositionSpring;
    private boolean hasUnsavedChanges;
    private boolean isDeleting;
    private boolean isSaving;
    private String memoryId;
    private String memoryName;
    private String originalContent;
    private final c scrimDimProperty;
    private boolean wasExceedingLimit;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/task/space/MemoryFileEditFragment$a;", "", "<init>", "()V", "", "tabType", "content", "memoryId", "memoryName", "", "memoryIds", "Lcom/stepos/ailauncher/task/space/MemoryFileEditFragment;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/stepos/ailauncher/task/space/MemoryFileEditFragment;", "TAG", "Ljava/lang/String;", "", "MAX_CHAR_COUNT", "I", "ARG_TAB_TYPE", "ARG_CONTENT", "ARG_MEMORY_ID", "ARG_MEMORY_IDS", "ARG_MEMORY_NAME", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.MemoryFileEditFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MemoryFileEditFragment b(Companion companion, String str, String str2, String str3, String str4, List list, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str3 = "";
            }
            if ((i10 & 8) != 0) {
                str4 = "";
            }
            if ((i10 & 16) != 0) {
                list = C1173v.m();
            }
            return companion.a(str, str2, str3, str4, list);
        }

        public final MemoryFileEditFragment a(String tabType, String content, String memoryId, String memoryName, List<String> memoryIds) {
            kotlin.jvm.internal.p.i(tabType, "tabType");
            kotlin.jvm.internal.p.i(content, "content");
            kotlin.jvm.internal.p.i(memoryId, "memoryId");
            kotlin.jvm.internal.p.i(memoryName, "memoryName");
            kotlin.jvm.internal.p.i(memoryIds, "memoryIds");
            List<String> list = memoryIds;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(La.H.D1((String) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            List listG0 = Z8.F.g0(arrayList2);
            if (listG0.isEmpty()) {
                List listE = C1172u.e(memoryId);
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : listE) {
                    if (!La.H.x0((String) obj2)) {
                        arrayList3.add(obj2);
                    }
                }
                listG0 = arrayList3;
            }
            MemoryFileEditFragment memoryFileEditFragment = new MemoryFileEditFragment();
            memoryFileEditFragment.setArguments(x0.c.a(Y8.j.a(MemoryFileEditFragment.ARG_TAB_TYPE, tabType), Y8.j.a("content", content), Y8.j.a(MemoryFileEditFragment.ARG_MEMORY_ID, memoryId), Y8.j.a(MemoryFileEditFragment.ARG_MEMORY_NAME, memoryName), Y8.j.a(MemoryFileEditFragment.ARG_MEMORY_IDS, new ArrayList(listG0))));
            return memoryFileEditFragment;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/task/space/MemoryFileEditFragment$b", "Landroidx/core/view/Z$b;", "Landroidx/core/view/a0;", "insets", "", "Landroidx/core/view/Z;", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", "animation", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/core/view/Z;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends Z.b {
        final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(1);
            this.$view = view;
        }

        @Override // androidx.core.view.Z.b
        public void b(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            super.b(animation);
            if ((animation.d() & a0.o.b()) != 0 && MemoryFileEditFragment.this.isAdded()) {
                androidx.core.view.N.e0(this.$view);
            }
        }

        @Override // androidx.core.view.Z.b
        public androidx.core.view.a0 d(androidx.core.view.a0 insets, List<androidx.core.view.Z> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            return insets;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/task/space/MemoryFileEditFragment$c", "Landroidx/dynamicanimation/animation/f;", "Landroid/view/View;", "view", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)F", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;F)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends androidx.dynamicanimation.animation.f<View> {
        public c() {
            super("scrimDim");
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            kotlin.jvm.internal.p.i(view, "view");
            return (view.getBackground() != null ? r0.getAlpha() : 255) / 255.0f;
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float value) {
            kotlin.jvm.internal.p.i(view, "view");
            Drawable background = view.getBackground();
            if (background != null) {
                background.setAlpha((int) (C5685n.m(value, 0.0f, 1.0f) * 255.0f));
            }
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/task/space/MemoryFileEditFragment$d", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            MemoryFileEditFragment.this.hasUnsavedChanges = !kotlin.jvm.internal.p.d(s10 != null ? s10.toString() : null, MemoryFileEditFragment.this.originalContent);
            MemoryFileEditFragment.this.T0(s10 != null ? s10.length() : 0);
            MemoryFileEditFragment.this.U0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    public MemoryFileEditFragment() {
        super(R$layout.fragment_memory_file_edit);
        this.originalContent = "";
        this.memoryId = "";
        this.memoryName = "";
        this.cardPositionSpring = new SheetSpring(322.27f, 0.8f);
        this.cardFadeSpring = SheetSpring.Companion.b(SheetSpring.INSTANCE, 400.0f, 40.0f, 0.0f, 4, null);
        this.cardExitFadeSpring = new SheetSpring(439.0f, 0.9f);
        this.scrimDimProperty = new c();
    }

    public static final void A0(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void B0(Dialog dialog, InterfaceC5063a interfaceC5063a, View view) {
        dialog.dismiss();
        interfaceC5063a.invoke();
    }

    public static final void C0(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void D0(View view) {
    }

    public static final androidx.core.view.a0 E0(View v10, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(insets, "insets");
        v10.setPadding(v10.getPaddingLeft(), v10.getPaddingTop(), v10.getPaddingRight(), insets.f(a0.o.g()).f41980d);
        return insets;
    }

    public static final void F0(Ref$BooleanRef ref$BooleanRef, MemoryFileEditFragment memoryFileEditFragment, View view, View view2, Dialog dialog, View view3) {
        x0(ref$BooleanRef, memoryFileEditFragment, view, view2, dialog, null);
    }

    public static final boolean G0(Ref$BooleanRef ref$BooleanRef, MemoryFileEditFragment memoryFileEditFragment, View view, View view2, Dialog dialog, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            x0(ref$BooleanRef, memoryFileEditFragment, view, view2, dialog, null);
        }
        return true;
    }

    public static final void H0(final InterfaceC5063a interfaceC5063a, Ref$BooleanRef ref$BooleanRef, MemoryFileEditFragment memoryFileEditFragment, View view, View view2, Dialog dialog, View view3) {
        x0(ref$BooleanRef, memoryFileEditFragment, view, view2, dialog, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.N
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MemoryFileEditFragment.I0(interfaceC5063a);
            }
        });
    }

    public static final Y8.t I0(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final void J0(Ref$BooleanRef ref$BooleanRef, MemoryFileEditFragment memoryFileEditFragment, View view, View view2, Dialog dialog, View view3) {
        x0(ref$BooleanRef, memoryFileEditFragment, view, view2, dialog, null);
    }

    public static final Y8.t L0(MemoryFileEditFragment memoryFileEditFragment) {
        memoryFileEditFragment.p0();
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void N0(Ref$ObjectRef ref$ObjectRef, MemoryFileEditFragment memoryFileEditFragment, View view) {
        PopupWindow popupWindow;
        T t10 = ref$ObjectRef.f34820a;
        if (t10 == 0) {
            kotlin.jvm.internal.p.A("popup");
            popupWindow = null;
        } else {
            popupWindow = (PopupWindow) t10;
        }
        popupWindow.dismiss();
        memoryFileEditFragment.K0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ androidx.dynamicanimation.animation.i P0(MemoryFileEditFragment memoryFileEditFragment, View view, androidx.dynamicanimation.animation.f fVar, float f10, SheetSpring sheetSpring, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            interfaceC5074l = null;
        }
        if ((i10 & 32) != 0) {
            interfaceC5063a = null;
        }
        return memoryFileEditFragment.O0(view, fVar, f10, sheetSpring, interfaceC5074l, interfaceC5063a);
    }

    public static final void Q0(InterfaceC5074l interfaceC5074l, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        interfaceC5074l.invoke(Float.valueOf(f10));
    }

    public static final void R0(InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        interfaceC5063a.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0() {
        Editable text = j0().etContent.getText();
        boolean z10 = false;
        int length = text != null ? text.length() : 0;
        boolean z11 = length > 500;
        boolean z12 = length == 0;
        if (this.hasUnsavedChanges && !this.isSaving && !z11 && !z12) {
            z10 = true;
        }
        j0().btnSave.setEnabled(z10);
        j0().btnSave.setAlpha(z10 ? 1.0f : 0.4f);
    }

    private final void k0() {
        LinearLayout linearLayoutB;
        View currentFocus;
        r6.g gVar = this._binding;
        if (gVar == null || (linearLayoutB = gVar.b()) == null) {
            return;
        }
        androidx.fragment.app.r activity = getActivity();
        if (activity == null || (currentFocus = activity.getCurrentFocus()) == null) {
            currentFocus = linearLayoutB;
        }
        currentFocus.clearFocus();
        androidx.core.view.b0 b0VarG = androidx.core.view.N.G(linearLayoutB);
        if (b0VarG != null) {
            b0VarG.a(a0.o.b());
        }
    }

    private final void q0() {
        String string = La.H.D1(j0().etContent.getText().toString()).toString();
        if (string.length() == 0 || this.isSaving || this.isDeleting) {
            return;
        }
        com.stepos.ailauncher.common.utils.I i10 = com.stepos.ailauncher.common.utils.I.INSTANCE;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        if (!i10.b(contextRequireContext)) {
            Toast.makeText(requireContext(), R$string.memory_save_no_network, 0).show();
            return;
        }
        this.isSaving = true;
        U0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new MemoryFileEditFragment$saveContent$1(string, this, null), 3, null);
    }

    private final void r0() {
        j0().btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.K
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoryFileEditFragment.s0(this.f28817a, view);
            }
        });
        j0().btnMore.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.V
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoryFileEditFragment.u0(this.f28886a, view);
            }
        });
        j0().btnSave.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.W
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoryFileEditFragment.v0(this.f28894a, view);
            }
        });
        j0().etContent.addTextChangedListener(new d());
    }

    public static final void s0(final MemoryFileEditFragment memoryFileEditFragment, View view) {
        memoryFileEditFragment.k0();
        if (memoryFileEditFragment.l(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.T
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MemoryFileEditFragment.t0(this.f28874a);
            }
        })) {
            return;
        }
        memoryFileEditFragment.x();
    }

    public static final Y8.t t0(MemoryFileEditFragment memoryFileEditFragment) {
        memoryFileEditFragment.x();
        return Y8.t.f7040a;
    }

    public static final void u0(MemoryFileEditFragment memoryFileEditFragment, View view) {
        kotlin.jvm.internal.p.f(view);
        memoryFileEditFragment.M0(view);
    }

    public static final void v0(MemoryFileEditFragment memoryFileEditFragment, View view) {
        memoryFileEditFragment.q0();
    }

    public static final void x0(Ref$BooleanRef ref$BooleanRef, final MemoryFileEditFragment memoryFileEditFragment, View view, View view2, final Dialog dialog, InterfaceC5063a<Y8.t> interfaceC5063a) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        e.s TRANSLATION_Y = androidx.dynamicanimation.animation.e.f13691o;
        kotlin.jvm.internal.p.h(TRANSLATION_Y, "TRANSLATION_Y");
        P0(memoryFileEditFragment, view, TRANSLATION_Y, memoryFileEditFragment.g0(), memoryFileEditFragment.cardPositionSpring, null, null, 48, null);
        P0(memoryFileEditFragment, view2, memoryFileEditFragment.scrimDimProperty, 0.0f, memoryFileEditFragment.cardExitFadeSpring, null, null, 48, null);
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        P0(memoryFileEditFragment, view, ALPHA, 0.0f, memoryFileEditFragment.cardExitFadeSpring, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.O
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MemoryFileEditFragment.y0(this.f28849a, dialog);
            }
        }, 16, null);
    }

    public static final Y8.t y0(MemoryFileEditFragment memoryFileEditFragment, Dialog dialog) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            dialog.dismiss();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "dismiss dialog failed", thE, false, 8, null);
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void z0(MemoryFileEditFragment memoryFileEditFragment, String str, String str2, String str3, String str4, InterfaceC5063a interfaceC5063a, boolean z10, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            z10 = false;
        }
        memoryFileEditFragment.w0(str, str2, str3, str4, interfaceC5063a, z10);
    }

    public final void K0() {
        String string = getString(R$string.memory_delete_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.memory_delete_message);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.memory_delete_confirm_message);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        String string4 = getString(R$string.repair_dialog_cancel);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        w0(string, string2, string3, string4, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.U
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MemoryFileEditFragment.L0(this.f28881a);
            }
        }, true);
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [T, android.widget.PopupWindow] */
    public final void M0(View anchor) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        int i10 = R$layout.popup_memory_edit_menu;
        View rootView = anchor.getRootView();
        View viewInflate = layoutInflaterFrom.inflate(i10, rootView instanceof ViewGroup ? (ViewGroup) rootView : null, false);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.S
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoryFileEditFragment.N0(ref$ObjectRef, this, view);
            }
        });
        kotlin.jvm.internal.p.f(viewInflate);
        ref$ObjectRef.f34820a = R5.i(anchor, viewInflate, 16.0f, 8.0f, false, false, false, null, 240, null);
    }

    public final androidx.dynamicanimation.animation.i O0(View view, androidx.dynamicanimation.animation.f<View> property, float finalValue, SheetSpring spring, final InterfaceC5074l<? super Float, Y8.t> onUpdate, final InterfaceC5063a<Y8.t> onEnd) {
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(view, property);
        iVar.B(com.stepos.ailauncher.sheet.h0.d(spring, finalValue));
        if (property != androidx.dynamicanimation.animation.e.f13691o) {
            iVar.o(0.00390625f);
        }
        if (onUpdate != null) {
            iVar.c(new e.r() { // from class: com.stepos.ailauncher.task.space.P
                @Override // androidx.dynamicanimation.animation.e.r
                public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                    MemoryFileEditFragment.Q0(onUpdate, eVar, f10, f11);
                }
            });
        }
        if (onEnd != null) {
            iVar.b(new e.q() { // from class: com.stepos.ailauncher.task.space.Q
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                    MemoryFileEditFragment.R0(onEnd, eVar, z10, f10, f11);
                }
            });
        }
        iVar.t();
        return iVar;
    }

    public final String S0(String tabType) {
        int iHashCode = tabType.hashCode();
        if (iHashCode == -1035284522) {
            if (!tabType.equals("communication")) {
                return "";
            }
            String string = getString(R$string.amoo_memory_communication);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }
        if (iHashCode == 3347770) {
            if (!tabType.equals("memo")) {
                return "";
            }
            String string2 = getString(R$string.amoo_memory_memo);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            return string2;
        }
        if (iHashCode != 1619363722 || !tabType.equals("about_me")) {
            return "";
        }
        String string3 = getString(R$string.amoo_memory_about_me);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        return string3;
    }

    @SuppressLint({"SetTextI18n"})
    public final void T0(int count) {
        j0().tvCharCount.setText(count + "/500");
        boolean z10 = count > 500;
        j0().tvCharCount.setTextColor(z10 ? -42713 : 1308622847);
        if (z10 && !this.wasExceedingLimit) {
            V0();
        }
        this.wasExceedingLimit = z10;
    }

    public final void V0() {
        Vibrator defaultVibrator;
        VibratorManager vibratorManager = (VibratorManager) requireContext().getSystemService(VibratorManager.class);
        if (vibratorManager == null || (defaultVibrator = vibratorManager.getDefaultVibrator()) == null) {
            return;
        }
        defaultVibrator.vibrate(VibrationEffect.createWaveform(new long[]{0, 40, 40, 40}, -1));
    }

    public final float g0() {
        return getResources().getDisplayMetrics().widthPixels * 0.34013605f;
    }

    public final Dialog h0() {
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        Dialog dialog = new Dialog(contextRequireContext);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        FrameLayout frameLayout = new FrameLayout(contextRequireContext);
        int i10 = (int) (48 * frameLayout.getResources().getDisplayMetrics().density);
        ProgressBar progressBar = new ProgressBar(contextRequireContext);
        progressBar.setLayoutParams(new FrameLayout.LayoutParams(i10, i10, 17));
        frameLayout.addView(progressBar);
        dialog.setContentView(frameLayout);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -1);
        }
        return dialog;
    }

    public final AmooMemoryDetailFragment i0() {
        com.stepos.ailauncher.sheet.nav.h hVarU = u();
        Fragment fragmentU = hVarU != null ? hVarU.u(AmooMemoryDetailFragment.NAV_TAG) : null;
        if (fragmentU instanceof AmooMemoryDetailFragment) {
            return (AmooMemoryDetailFragment) fragmentU;
        }
        return null;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    public final r6.g j0() {
        r6.g gVar = this._binding;
        kotlin.jvm.internal.p.f(gVar);
        return gVar;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean l(InterfaceC5063a<Y8.t> proceed) {
        kotlin.jvm.internal.p.i(proceed, "proceed");
        if (!this.hasUnsavedChanges) {
            return false;
        }
        String string = getString(R$string.file_edit_discard_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.file_edit_discard_message);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.file_edit_discard_positive);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        String string4 = getString(R$string.file_edit_discard_negative);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        z0(this, string, string2, string3, string4, proceed, false, 32, null);
        return true;
    }

    public final String l0(String tabType) {
        int iHashCode = tabType.hashCode();
        if (iHashCode == -1035284522) {
            if (!tabType.equals("communication")) {
                return "";
            }
            String string = getString(R$string.memory_hint_communication);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }
        if (iHashCode == 3347770) {
            if (!tabType.equals("memo")) {
                return "";
            }
            String string2 = getString(R$string.memory_hint_memo);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            return string2;
        }
        if (iHashCode != 1619363722 || !tabType.equals("about_me")) {
            return "";
        }
        String string3 = getString(R$string.memory_hint_about_me);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        return string3;
    }

    public final void m0(View view) {
        androidx.core.view.N.E0(view, new b(view));
    }

    public final boolean n0() {
        return this.memoryId.length() == 0;
    }

    public final void o0(String savedMemoryId, String content) {
        AmooMemoryDetailFragment amooMemoryDetailFragmentI0 = i0();
        if (!n0() || amooMemoryDetailFragmentI0 == null) {
            if (amooMemoryDetailFragmentI0 != null) {
                amooMemoryDetailFragmentI0.Y(savedMemoryId, content);
            }
            if (amooMemoryDetailFragmentI0 != null) {
                amooMemoryDetailFragmentI0.Q();
            }
        } else {
            String string = getString(R$string.memory_time_just_now);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            amooMemoryDetailFragmentI0.H(new MemoryItem(content, string, savedMemoryId, this.memoryName, false, 0L, null, 112, null));
        }
        x();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        View view = getView();
        if (view != null) {
            androidx.core.view.N.E0(view, null);
        }
        super.onDestroyView();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        String string2;
        String string3;
        String string4;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this._binding = r6.g.a(view);
        Bundle arguments = getArguments();
        String str = "";
        if (arguments == null || (string = arguments.getString(ARG_TAB_TYPE)) == null) {
            string = "";
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string2 = arguments2.getString("content")) == null) {
            string2 = "";
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string3 = arguments3.getString(ARG_MEMORY_ID)) == null) {
            string3 = "";
        }
        this.memoryId = string3;
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (string4 = arguments4.getString(ARG_MEMORY_NAME)) != null) {
            str = string4;
        }
        this.memoryName = str;
        j0().tvTitle.setText(S0(string));
        this.originalContent = string2;
        j0().etContent.setText(string2);
        j0().etContent.setHint(l0(string));
        j0().btnMore.setVisibility(n0() ? 8 : 0);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        ImageView btnBack = j0().btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        ImageView btnMore = j0().btnMore;
        kotlin.jvm.internal.p.h(btnMore, "btnMore");
        C2773b6.p(c2773b6, new View[]{btnBack, btnMore}, null, false, 6, null);
        r0();
        U0();
        T0(string2.length());
        m0(view);
    }

    public final void p0() {
        Bundle arguments;
        String string;
        if (this.isDeleting || this.isSaving || (arguments = getArguments()) == null || (string = arguments.getString(ARG_TAB_TYPE)) == null) {
            return;
        }
        this.isDeleting = true;
        AmooMemoryDetailFragment amooMemoryDetailFragmentI0 = i0();
        if (amooMemoryDetailFragmentI0 != null) {
            amooMemoryDetailFragmentI0.J();
        }
        Dialog dialogH0 = h0();
        dialogH0.show();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new MemoryFileEditFragment$performDelete$1(this, string, dialogH0, null), 3, null);
    }

    public final void w0(String title, String message, String positiveText, String negativeText, final InterfaceC5063a<Y8.t> onPositive, boolean animated) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R$layout.dialog_confirm);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -1);
            if (animated) {
                window.addFlags(768);
                window.clearFlags(201326592);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarContrastEnforced(false);
                window.setNavigationBarContrastEnforced(false);
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
                androidx.core.view.Y.b(window, false);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.setFitInsetsTypes(0);
                window.setAttributes(attributes);
                window.setWindowAnimations(0);
            } else {
                WindowManager.LayoutParams attributes2 = window.getAttributes();
                attributes2.setFitInsetsTypes(WindowInsets.Type.systemBars());
                window.setAttributes(attributes2);
            }
        }
        ((TextView) dialog.findViewById(R$id.tv_dialog_title)).setText(title);
        ((TextView) dialog.findViewById(R$id.tv_dialog_message)).setText(message);
        TextView textView = (TextView) dialog.findViewById(R$id.btn_positive);
        textView.setText(positiveText);
        TextView textView2 = (TextView) dialog.findViewById(R$id.btn_negative);
        textView2.setText(negativeText);
        final View viewFindViewById = dialog.findViewById(R$id.fl_overlay);
        final View viewFindViewById2 = dialog.findViewById(R$id.ll_card);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.X
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemoryFileEditFragment.D0(view);
                }
            });
        }
        if (!animated || viewFindViewById == null || viewFindViewById2 == null) {
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.d0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MemoryFileEditFragment.A0(dialog, view);
                    }
                });
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.L
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemoryFileEditFragment.B0(dialog, onPositive, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemoryFileEditFragment.C0(dialog, view);
                }
            });
            dialog.show();
            return;
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        androidx.core.view.N.u0(viewFindViewById, new androidx.core.view.A() { // from class: com.stepos.ailauncher.task.space.Y
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return MemoryFileEditFragment.E0(view, a0Var);
            }
        });
        viewFindViewById2.setTranslationY(g0());
        viewFindViewById2.setAlpha(0.0f);
        Drawable background = viewFindViewById.getBackground();
        if (background != null) {
            background.setAlpha(0);
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.Z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoryFileEditFragment.F0(ref$BooleanRef, this, viewFindViewById2, viewFindViewById, dialog, view);
            }
        });
        dialog.setCancelable(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.stepos.ailauncher.task.space.a0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return MemoryFileEditFragment.G0(ref$BooleanRef, this, viewFindViewById2, viewFindViewById, dialog, dialogInterface, i10, keyEvent);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoryFileEditFragment.H0(onPositive, ref$BooleanRef, this, viewFindViewById2, viewFindViewById, dialog, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoryFileEditFragment.J0(ref$BooleanRef, this, viewFindViewById2, viewFindViewById, dialog, view);
            }
        });
        dialog.show();
        e.s TRANSLATION_Y = androidx.dynamicanimation.animation.e.f13691o;
        kotlin.jvm.internal.p.h(TRANSLATION_Y, "TRANSLATION_Y");
        P0(this, viewFindViewById2, TRANSLATION_Y, 0.0f, this.cardPositionSpring, null, null, 48, null);
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        P0(this, viewFindViewById2, ALPHA, 1.0f, this.cardFadeSpring, null, null, 48, null);
        P0(this, viewFindViewById, this.scrimDimProperty, 1.0f, this.cardFadeSpring, null, null, 48, null);
    }
}
