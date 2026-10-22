package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.R$id;
import b.C1423c;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.download.ModelFlowMeta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0014\b \u0018\u0000 42\u00020\u0001:\u0004=A IB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u0019J\r\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\r¢\u0006\u0004\b\"\u0010\u0019J%\u0010%\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0#2\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0#H\u0010¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\r¢\u0006\u0004\b-\u0010\u0019J\u0019\u00100\u001a\u0004\u0018\u00010\u001e2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00102\u001a\u0004\u0018\u00010\u001e2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b2\u00101J'\u00104\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u00105J\u001d\u00108\u001a\u00020\u00142\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001e06H\u0002¢\u0006\u0004\b8\u00109J\u001d\u0010:\u001a\u00020\u00142\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001e06H\u0002¢\u0006\u0004\b:\u00109J\u000f\u0010;\u001a\u00020\rH\u0002¢\u0006\u0004\b;\u0010\u0019J\u001d\u0010<\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0#H\u0002¢\u0006\u0004\b<\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001e068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001e068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010BR\u0016\u0010F\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010ER\u0016\u0010G\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010ER\u0016\u0010H\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010E¨\u0006J"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController;", "", "Landroid/view/ViewGroup;", "container", "<init>", "(Landroid/view/ViewGroup;)V", "Landroidx/fragment/app/I;", "fragmentStateManager", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "s", "(Landroidx/fragment/app/I;)Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/I;)V", "m", "(Landroidx/fragment/app/I;)V", "k", "l", "", "isPop", "D", "(Z)V", "z", "()V", "y", "()Z", "r", "n", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "c", "(Landroidx/fragment/app/SpecialEffectsController$Operation;)V", "q", "", "operations", Const.INTENT_KEY_UMID, "(Ljava/util/List;Z)V", "e", "(Ljava/util/List;)V", "Lb/c;", "backEvent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lb/c;)V", "f", "Landroidx/fragment/app/Fragment;", "fragment", "o", "(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/SpecialEffectsController$Operation;", "p", "lifecycleImpact", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/I;)V", "", "newPendingOperations", "x", "(Ljava/util/List;)Z", "w", "C", "B", Const.INTENT_KEY_APIKEY, "Landroid/view/ViewGroup;", "t", "()Landroid/view/ViewGroup;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "pendingOperations", "runningOperations", "Z", "runningNonSeekableTransition", "operationDirectionIsPop", "isContainerPostponed", "Operation", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ViewGroup container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<Operation> pendingOperations;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final List<Operation> runningOperations;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean runningNonSeekableTransition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean operationDirectionIsPop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean isContainerPostponed;

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001:\u0002FGB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0011¢\u0006\u0004\b\u001f\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010.R$\u00105\u001a\u0002002\u0006\u00101\u001a\u0002008\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b3\u00104R$\u00108\u001a\u0002002\u0006\u00101\u001a\u0002008\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R*\u0010<\u001a\u0002002\u0006\u00101\u001a\u0002008\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u0010;R$\u0010>\u001a\u0002002\u0006\u00101\u001a\u0002008\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u00102\u001a\u0004\b=\u00104R\"\u0010A\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u00102\u001a\u0004\b?\u00104\"\u0004\b@\u0010;R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00180-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010.R \u0010E\u001a\b\u0012\u0004\u0012\u00020\u00180C8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b6\u0010D¨\u0006H"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation;", "", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "lifecycleImpact", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/Fragment;)V", "", "toString", "()Ljava/lang/String;", "Landroid/view/ViewGroup;", "container", "LY8/t;", "c", "(Landroid/view/ViewGroup;)V", "o", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "Ljava/lang/Runnable;", "listener", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Runnable;)V", "Landroidx/fragment/app/SpecialEffectsController$b;", "effect", Const.INTENT_KEY_PKGNAME, "(Landroidx/fragment/app/SpecialEffectsController$b;)V", "e", "p", "()V", Const.INTENT_KEY_UMID, "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "setFinalState", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;)V", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "setLifecycleImpact", "(Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "Landroidx/fragment/app/Fragment;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/fragment/app/Fragment;", "", "Ljava/util/List;", "completionListeners", "", "<set-?>", "Z", "k", "()Z", "isCanceled", "f", "l", "isComplete", "m", "r", "(Z)V", "isSeeking", "n", "isStarted", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "q", "isAwaitingContainerChanges", "_effects", "", "()Ljava/util/List;", "effects", "LifecycleImpact", "State", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class Operation {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public State finalState;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public LifecycleImpact lifecycleImpact;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final Fragment fragment;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final List<Runnable> completionListeners;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public boolean isCanceled;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public boolean isComplete;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public boolean isSeeking;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public boolean isStarted;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public boolean isAwaitingContainerChanges;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public final List<b> _effects;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final List<b> effects;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "ADDING", "REMOVING", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", "<init>", "(Ljava/lang/String;I)V", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "container", "LY8/t;", "applyState", "(Landroid/view/View;Landroid/view/ViewGroup;)V", "Companion", Const.INTENT_KEY_APIKEY, "REMOVED", "VISIBLE", "GONE", "INVISIBLE", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;


            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State$a;", "", "<init>", "()V", "Landroid/view/View;", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", "visibility", Const.INTENT_KEY_PKGNAME, "(I)Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* renamed from: androidx.fragment.app.SpecialEffectsController$Operation$State$a, reason: from kotlin metadata */
            public static final class Companion {
                public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                    this();
                }

                public final State a(View view) {
                    kotlin.jvm.internal.p.i(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? State.INVISIBLE : b(view.getVisibility());
                }

                public final State b(int visibility) {
                    if (visibility == 0) {
                        return State.VISIBLE;
                    }
                    if (visibility == 4) {
                        return State.INVISIBLE;
                    }
                    if (visibility == 8) {
                        return State.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + visibility);
                }

                public Companion() {
                }
            }

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class b {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f14076a;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f14076a = iArr;
                }
            }

            public static final State from(int i10) {
                return INSTANCE.b(i10);
            }

            public final void applyState(View view, ViewGroup container) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(container, "container");
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Calling apply state");
                }
                int i10 = b.f14076a[ordinal()];
                if (i10 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (FragmentManager.N0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i10 == 2) {
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (FragmentManager.N0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + container);
                        }
                        container.addView(view);
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i10 == 3) {
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f14077a;

            static {
                int[] iArr = new int[LifecycleImpact.values().length];
                try {
                    iArr[LifecycleImpact.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LifecycleImpact.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LifecycleImpact.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f14077a = iArr;
            }
        }

        public Operation(State finalState, LifecycleImpact lifecycleImpact, Fragment fragment) {
            kotlin.jvm.internal.p.i(finalState, "finalState");
            kotlin.jvm.internal.p.i(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.p.i(fragment, "fragment");
            this.finalState = finalState;
            this.lifecycleImpact = lifecycleImpact;
            this.fragment = fragment;
            this.completionListeners = new ArrayList();
            this.isAwaitingContainerChanges = true;
            ArrayList arrayList = new ArrayList();
            this._effects = arrayList;
            this.effects = arrayList;
        }

        public final void a(Runnable listener) {
            kotlin.jvm.internal.p.i(listener, "listener");
            this.completionListeners.add(listener);
        }

        public final void b(b effect) {
            kotlin.jvm.internal.p.i(effect, "effect");
            this._effects.add(effect);
        }

        public final void c(ViewGroup container) {
            kotlin.jvm.internal.p.i(container, "container");
            this.isStarted = false;
            if (this.isCanceled) {
                return;
            }
            this.isCanceled = true;
            if (this._effects.isEmpty()) {
                d();
                return;
            }
            Iterator it = Z8.F.m1(this.effects).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(container);
            }
        }

        public void d() {
            this.isStarted = false;
            if (this.isComplete) {
                return;
            }
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.isComplete = true;
            Iterator<T> it = this.completionListeners.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void e(b effect) {
            kotlin.jvm.internal.p.i(effect, "effect");
            if (this._effects.remove(effect) && this._effects.isEmpty()) {
                d();
            }
        }

        public final List<b> f() {
            return this.effects;
        }

        /* renamed from: g, reason: from getter */
        public final State getFinalState() {
            return this.finalState;
        }

        /* renamed from: h, reason: from getter */
        public final Fragment getFragment() {
            return this.fragment;
        }

        /* renamed from: i, reason: from getter */
        public final LifecycleImpact getLifecycleImpact() {
            return this.lifecycleImpact;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getIsAwaitingContainerChanges() {
            return this.isAwaitingContainerChanges;
        }

        /* renamed from: k, reason: from getter */
        public final boolean getIsCanceled() {
            return this.isCanceled;
        }

        /* renamed from: l, reason: from getter */
        public final boolean getIsComplete() {
            return this.isComplete;
        }

        /* renamed from: m, reason: from getter */
        public final boolean getIsSeeking() {
            return this.isSeeking;
        }

        /* renamed from: n, reason: from getter */
        public final boolean getIsStarted() {
            return this.isStarted;
        }

        public final void o(State finalState, LifecycleImpact lifecycleImpact) {
            kotlin.jvm.internal.p.i(finalState, "finalState");
            kotlin.jvm.internal.p.i(lifecycleImpact, "lifecycleImpact");
            int i10 = a.f14077a[lifecycleImpact.ordinal()];
            if (i10 == 1) {
                if (this.finalState == State.REMOVED) {
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.lifecycleImpact + " to ADDING.");
                    }
                    this.finalState = State.VISIBLE;
                    this.lifecycleImpact = LifecycleImpact.ADDING;
                    this.isAwaitingContainerChanges = true;
                    return;
                }
                return;
            }
            if (i10 == 2) {
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = " + this.finalState + " -> REMOVED. mLifecycleImpact  = " + this.lifecycleImpact + " to REMOVING.");
                }
                this.finalState = State.REMOVED;
                this.lifecycleImpact = LifecycleImpact.REMOVING;
                this.isAwaitingContainerChanges = true;
                return;
            }
            if (i10 == 3 && this.finalState != State.REMOVED) {
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = " + this.finalState + " -> " + finalState + '.');
                }
                this.finalState = finalState;
            }
        }

        public void p() {
            this.isStarted = true;
        }

        public final void q(boolean z10) {
            this.isAwaitingContainerChanges = z10;
        }

        public final void r(boolean z10) {
            this.isSeeking = z10;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.finalState + " lifecycleImpact = " + this.lifecycleImpact + " fragment = " + this.fragment + '}';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$a;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "container", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/SpecialEffectsController;", Const.INTENT_KEY_APIKEY, "(Landroid/view/ViewGroup;Landroidx/fragment/app/FragmentManager;)Landroidx/fragment/app/SpecialEffectsController;", "Landroidx/fragment/app/T;", "factory", Const.INTENT_KEY_PKGNAME, "(Landroid/view/ViewGroup;Landroidx/fragment/app/T;)Landroidx/fragment/app/SpecialEffectsController;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.fragment.app.SpecialEffectsController$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final SpecialEffectsController a(ViewGroup container, FragmentManager fragmentManager) {
            kotlin.jvm.internal.p.i(container, "container");
            kotlin.jvm.internal.p.i(fragmentManager, "fragmentManager");
            T tF0 = fragmentManager.F0();
            kotlin.jvm.internal.p.h(tF0, "fragmentManager.specialEffectsControllerFactory");
            return b(container, tF0);
        }

        public final SpecialEffectsController b(ViewGroup container, T factory) {
            kotlin.jvm.internal.p.i(container, "container");
            kotlin.jvm.internal.p.i(factory, "factory");
            int i10 = R$id.special_effects_controller_view_tag;
            Object tag = container.getTag(i10);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            SpecialEffectsController specialEffectsControllerA = factory.a(container);
            kotlin.jvm.internal.p.h(specialEffectsControllerA, "factory.createController(container)");
            container.setTag(i10, specialEffectsControllerA);
            return specialEffectsControllerA;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bR\u001a\u0010\u0015\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012¨\u0006\u0018"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$b;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "container", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/ViewGroup;)V", "f", "Lb/c;", "backEvent", "e", "(Lb/c;Landroid/view/ViewGroup;)V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "c", "", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "isSeekingSupported", "isStarted", "isCancelled", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final boolean isSeekingSupported;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public boolean isStarted;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public boolean isCancelled;

        public final void a(ViewGroup container) {
            kotlin.jvm.internal.p.i(container, "container");
            if (!this.isCancelled) {
                c(container);
            }
            this.isCancelled = true;
        }

        /* renamed from: b, reason: from getter */
        public boolean getIsSeekingSupported() {
            return this.isSeekingSupported;
        }

        public void c(ViewGroup container) {
            kotlin.jvm.internal.p.i(container, "container");
        }

        public void d(ViewGroup container) {
            kotlin.jvm.internal.p.i(container, "container");
        }

        public void e(C1423c backEvent, ViewGroup container) {
            kotlin.jvm.internal.p.i(backEvent, "backEvent");
            kotlin.jvm.internal.p.i(container, "container");
        }

        public void f(ViewGroup container) {
            kotlin.jvm.internal.p.i(container, "container");
        }

        public final void g(ViewGroup container) {
            kotlin.jvm.internal.p.i(container, "container");
            if (!this.isStarted) {
                f(container);
            }
            this.isStarted = true;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0010¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$c;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "lifecycleImpact", "Landroidx/fragment/app/I;", "fragmentStateManager", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/I;)V", "LY8/t;", "p", "()V", Const.INTENT_KEY_UMID, "l", "Landroidx/fragment/app/I;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c extends Operation {

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public final I fragmentStateManager;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(Operation.State finalState, Operation.LifecycleImpact lifecycleImpact, I fragmentStateManager) {
            kotlin.jvm.internal.p.i(finalState, "finalState");
            kotlin.jvm.internal.p.i(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.p.i(fragmentStateManager, "fragmentStateManager");
            Fragment fragmentK = fragmentStateManager.k();
            kotlin.jvm.internal.p.h(fragmentK, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, fragmentK);
            this.fragmentStateManager = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void d() {
            super.d();
            getFragment().mTransitioning = false;
            this.fragmentStateManager.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void p() {
            if (getIsStarted()) {
                return;
            }
            super.p();
            if (getLifecycleImpact() != Operation.LifecycleImpact.ADDING) {
                if (getLifecycleImpact() == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragmentK = this.fragmentStateManager.k();
                    kotlin.jvm.internal.p.h(fragmentK, "fragmentStateManager.fragment");
                    View viewRequireView = fragmentK.requireView();
                    kotlin.jvm.internal.p.h(viewRequireView, "fragment.requireView()");
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + fragmentK);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentK2 = this.fragmentStateManager.k();
            kotlin.jvm.internal.p.h(fragmentK2, "fragmentStateManager.fragment");
            View viewFindFocus = fragmentK2.mView.findFocus();
            if (viewFindFocus != null) {
                fragmentK2.setFocusedView(viewFindFocus);
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK2);
                }
            }
            View viewRequireView2 = getFragment().requireView();
            kotlin.jvm.internal.p.h(viewRequireView2, "this.fragment.requireView()");
            if (viewRequireView2.getParent() == null) {
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "Adding fragment " + fragmentK2 + " view " + viewRequireView2 + " to container in onStart");
                }
                this.fragmentStateManager.b();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "Making view " + viewRequireView2 + " INVISIBLE in onStart");
                }
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(fragmentK2.getPostOnViewCreatedAlpha());
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Setting view alpha to " + fragmentK2.getPostOnViewCreatedAlpha() + " in onStart");
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14082a;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[Operation.LifecycleImpact.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f14082a = iArr;
        }
    }

    public SpecialEffectsController(ViewGroup container) {
        kotlin.jvm.internal.p.i(container, "container");
        this.container = container;
        this.pendingOperations = new ArrayList();
        this.runningOperations = new ArrayList();
    }

    public static final void h(SpecialEffectsController this$0, c operation) {
        kotlin.jvm.internal.p.i(this$0, "this$0");
        kotlin.jvm.internal.p.i(operation, "$operation");
        if (this$0.pendingOperations.contains(operation)) {
            Operation.State finalState = operation.getFinalState();
            View view = operation.getFragment().mView;
            kotlin.jvm.internal.p.h(view, "operation.fragment.mView");
            finalState.applyState(view, this$0.container);
        }
    }

    public static final void i(SpecialEffectsController this$0, c operation) {
        kotlin.jvm.internal.p.i(this$0, "this$0");
        kotlin.jvm.internal.p.i(operation, "$operation");
        this$0.pendingOperations.remove(operation);
        this$0.runningOperations.remove(operation);
    }

    public static final SpecialEffectsController u(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return INSTANCE.a(viewGroup, fragmentManager);
    }

    public static final SpecialEffectsController v(ViewGroup viewGroup, T t10) {
        return INSTANCE.b(viewGroup, t10);
    }

    public final void A(C1423c backEvent) {
        kotlin.jvm.internal.p.i(backEvent, "backEvent");
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.getProgress());
        }
        List<Operation> list = this.runningOperations;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Z8.A.E(arrayList, ((Operation) it.next()).f());
        }
        List listM1 = Z8.F.m1(Z8.F.r1(arrayList));
        int size = listM1.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) listM1.get(i10)).e(backEvent, this.container);
        }
    }

    public final void B(List<Operation> operations) {
        int size = operations.size();
        for (int i10 = 0; i10 < size; i10++) {
            operations.get(i10).p();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            Z8.A.E(arrayList, ((Operation) it.next()).f());
        }
        List listM1 = Z8.F.m1(Z8.F.r1(arrayList));
        int size2 = listM1.size();
        for (int i11 = 0; i11 < size2; i11++) {
            ((b) listM1.get(i11)).g(this.container);
        }
    }

    public final void C() {
        for (Operation operation : this.pendingOperations) {
            if (operation.getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                View viewRequireView = operation.getFragment().requireView();
                kotlin.jvm.internal.p.h(viewRequireView, "fragment.requireView()");
                operation.o(Operation.State.INSTANCE.b(viewRequireView.getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public final void D(boolean isPop) {
        this.operationDirectionIsPop = isPop;
    }

    public final void c(Operation operation) {
        kotlin.jvm.internal.p.i(operation, "operation");
        if (operation.getIsAwaitingContainerChanges()) {
            Operation.State finalState = operation.getFinalState();
            View viewRequireView = operation.getFragment().requireView();
            kotlin.jvm.internal.p.h(viewRequireView, "operation.fragment.requireView()");
            finalState.applyState(viewRequireView, this.container);
            operation.q(false);
        }
    }

    public abstract void d(List<Operation> operations, boolean isPop);

    public void e(List<Operation> operations) {
        kotlin.jvm.internal.p.i(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            Z8.A.E(arrayList, ((Operation) it.next()).f());
        }
        List listM1 = Z8.F.m1(Z8.F.r1(arrayList));
        int size = listM1.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) listM1.get(i10)).d(this.container);
        }
        int size2 = operations.size();
        for (int i11 = 0; i11 < size2; i11++) {
            c(operations.get(i11));
        }
        List listM12 = Z8.F.m1(operations);
        int size3 = listM12.size();
        for (int i12 = 0; i12 < size3; i12++) {
            Operation operation = (Operation) listM12.get(i12);
            if (operation.f().isEmpty()) {
                operation.d();
            }
        }
    }

    public final void f() {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        B(this.runningOperations);
        e(this.runningOperations);
    }

    public final void g(Operation.State finalState, Operation.LifecycleImpact lifecycleImpact, I fragmentStateManager) {
        synchronized (this.pendingOperations) {
            try {
                Fragment fragmentK = fragmentStateManager.k();
                kotlin.jvm.internal.p.h(fragmentK, "fragmentStateManager.fragment");
                Operation operationO = o(fragmentK);
                if (operationO == null) {
                    if (fragmentStateManager.k().mTransitioning || fragmentStateManager.k().mRemoving) {
                        Fragment fragmentK2 = fragmentStateManager.k();
                        kotlin.jvm.internal.p.h(fragmentK2, "fragmentStateManager.fragment");
                        operationO = p(fragmentK2);
                    } else {
                        operationO = null;
                    }
                }
                if (operationO != null) {
                    operationO.o(finalState, lifecycleImpact);
                    return;
                }
                final c cVar = new c(finalState, lifecycleImpact, fragmentStateManager);
                this.pendingOperations.add(cVar);
                cVar.a(new Runnable() { // from class: androidx.fragment.app.Q
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpecialEffectsController.h(this.f14054a, cVar);
                    }
                });
                cVar.a(new Runnable() { // from class: androidx.fragment.app.S
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpecialEffectsController.i(this.f14056a, cVar);
                    }
                });
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(Operation.State finalState, I fragmentStateManager) {
        kotlin.jvm.internal.p.i(finalState, "finalState");
        kotlin.jvm.internal.p.i(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        g(finalState, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public final void k(I fragmentStateManager) {
        kotlin.jvm.internal.p.i(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        g(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void l(I fragmentStateManager) {
        kotlin.jvm.internal.p.i(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        g(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public final void m(I fragmentStateManager) {
        kotlin.jvm.internal.p.i(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        g(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void n() {
        boolean z10;
        if (this.isContainerPostponed) {
            return;
        }
        if (!this.container.isAttachedToWindow()) {
            q();
            this.operationDirectionIsPop = false;
            return;
        }
        synchronized (this.pendingOperations) {
            try {
                List<Operation> listP1 = Z8.F.p1(this.runningOperations);
                this.runningOperations.clear();
                Iterator it = listP1.iterator();
                while (true) {
                    z10 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Operation operation = (Operation) it.next();
                    if (this.pendingOperations.isEmpty() || !operation.getFragment().mTransitioning) {
                        z10 = false;
                    }
                    operation.r(z10);
                }
                for (Operation operation2 : listP1) {
                    if (this.runningNonSeekableTransition) {
                        if (FragmentManager.N0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Completing non-seekable operation " + operation2);
                        }
                        operation2.d();
                    } else {
                        if (FragmentManager.N0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation2);
                        }
                        operation2.c(this.container);
                    }
                    this.runningNonSeekableTransition = false;
                    if (!operation2.getIsComplete()) {
                        this.runningOperations.add(operation2);
                    }
                }
                if (!this.pendingOperations.isEmpty()) {
                    C();
                    List<Operation> listP12 = Z8.F.p1(this.pendingOperations);
                    if (listP12.isEmpty()) {
                        return;
                    }
                    this.pendingOperations.clear();
                    this.runningOperations.addAll(listP12);
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    d(listP12, this.operationDirectionIsPop);
                    boolean zW = w(listP12);
                    boolean zX = x(listP12);
                    if (!zX || zW) {
                        z10 = false;
                    }
                    this.runningNonSeekableTransition = z10;
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Operation seekable = " + zW + " \ntransition = " + zX);
                    }
                    if (!zX) {
                        B(listP12);
                        e(listP12);
                    } else if (zW) {
                        B(listP12);
                        int size = listP12.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            c(listP12.get(i10));
                        }
                    }
                    this.operationDirectionIsPop = false;
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Operation o(Fragment fragment) {
        Object next;
        Iterator<T> it = this.pendingOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (kotlin.jvm.internal.p.d(operation.getFragment(), fragment) && !operation.getIsCanceled()) {
                break;
            }
        }
        return (Operation) next;
    }

    public final Operation p(Fragment fragment) {
        Object next;
        Iterator<T> it = this.runningOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (kotlin.jvm.internal.p.d(operation.getFragment(), fragment) && !operation.getIsCanceled()) {
                break;
            }
        }
        return (Operation) next;
    }

    public final void q() {
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.container.isAttachedToWindow();
        synchronized (this.pendingOperations) {
            try {
                C();
                B(this.pendingOperations);
                List<Operation> listP1 = Z8.F.p1(this.runningOperations);
                Iterator it = listP1.iterator();
                while (it.hasNext()) {
                    ((Operation) it.next()).r(false);
                }
                for (Operation operation : listP1) {
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.container + " is not attached to window. ") + "Cancelling running operation " + operation);
                    }
                    operation.c(this.container);
                }
                List<Operation> listP12 = Z8.F.p1(this.pendingOperations);
                Iterator it2 = listP12.iterator();
                while (it2.hasNext()) {
                    ((Operation) it2.next()).r(false);
                }
                for (Operation operation2 : listP12) {
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.container + " is not attached to window. ") + "Cancelling pending operation " + operation2);
                    }
                    operation2.c(this.container);
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.isContainerPostponed) {
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.isContainerPostponed = false;
            n();
        }
    }

    public final Operation.LifecycleImpact s(I fragmentStateManager) {
        kotlin.jvm.internal.p.i(fragmentStateManager, "fragmentStateManager");
        Fragment fragmentK = fragmentStateManager.k();
        kotlin.jvm.internal.p.h(fragmentK, "fragmentStateManager.fragment");
        Operation operationO = o(fragmentK);
        Operation.LifecycleImpact lifecycleImpact = operationO != null ? operationO.getLifecycleImpact() : null;
        Operation operationP = p(fragmentK);
        Operation.LifecycleImpact lifecycleImpact2 = operationP != null ? operationP.getLifecycleImpact() : null;
        int i10 = lifecycleImpact == null ? -1 : d.f14082a[lifecycleImpact.ordinal()];
        return (i10 == -1 || i10 == 1) ? lifecycleImpact2 : lifecycleImpact;
    }

    /* renamed from: t, reason: from getter */
    public final ViewGroup getContainer() {
        return this.container;
    }

    public final boolean w(List<Operation> newPendingOperations) {
        boolean z10;
        List<Operation> list = newPendingOperations;
        loop0: while (true) {
            z10 = true;
            for (Operation operation : list) {
                if (!operation.f().isEmpty()) {
                    List<b> listF = operation.f();
                    if (!(listF instanceof Collection) || !listF.isEmpty()) {
                        Iterator<T> it = listF.iterator();
                        while (it.hasNext()) {
                            if (!((b) it.next()).getIsSeekingSupported()) {
                                break;
                            }
                        }
                    }
                }
                z10 = false;
            }
            break loop0;
        }
        if (z10) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                Z8.A.E(arrayList, ((Operation) it2.next()).f());
            }
            if (!arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean x(List<Operation> newPendingOperations) {
        Iterator<T> it = newPendingOperations.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            if (!((Operation) it.next()).getFragment().mTransitioning) {
                z10 = false;
            }
        }
        return z10;
    }

    public final boolean y() {
        return !this.pendingOperations.isEmpty();
    }

    public final void z() {
        Operation operationPrevious;
        synchronized (this.pendingOperations) {
            try {
                C();
                List<Operation> list = this.pendingOperations;
                ListIterator<Operation> listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        operationPrevious = null;
                        break;
                    }
                    operationPrevious = listIterator.previous();
                    Operation operation = operationPrevious;
                    Operation.State.Companion companion = Operation.State.INSTANCE;
                    View view = operation.getFragment().mView;
                    kotlin.jvm.internal.p.h(view, "operation.fragment.mView");
                    Operation.State stateA = companion.a(view);
                    Operation.State finalState = operation.getFinalState();
                    Operation.State state = Operation.State.VISIBLE;
                    if (finalState == state && stateA != state) {
                        break;
                    }
                }
                Operation operation2 = operationPrevious;
                Fragment fragment = operation2 != null ? operation2.getFragment() : null;
                this.isContainerPostponed = fragment != null ? fragment.isPostponed() : false;
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
