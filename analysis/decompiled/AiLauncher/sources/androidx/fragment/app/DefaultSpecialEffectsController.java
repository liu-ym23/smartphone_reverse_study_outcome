package androidx.fragment.app;

import Z8.C1174w;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.C1380s;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import b.C1423c;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\b%&'\f()*+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ9\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001e\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010#\u001a\u00020\u000b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0 2\u0006\u0010\"\u001a\u00020\u001bH\u0002¢\u0006\u0004\b#\u0010$¨\u0006,"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController;", "Landroidx/fragment/app/SpecialEffectsController;", "Landroid/view/ViewGroup;", "container", "<init>", "(Landroid/view/ViewGroup;)V", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operations", "", "isPop", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/util/List;Z)V", "K", "(Ljava/util/List;)V", "Landroidx/fragment/app/DefaultSpecialEffectsController$b;", "animationInfos", "F", "Landroidx/fragment/app/DefaultSpecialEffectsController$g;", "transitionInfos", "firstOut", "lastIn", "H", "(Ljava/util/List;ZLandroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/SpecialEffectsController$Operation;)V", "Landroidx/collection/a;", "", "Landroid/view/View;", "", "names", "J", "(Landroidx/collection/a;Ljava/util/Collection;)V", "", "namedViews", "view", "I", "(Ljava/util/Map;Landroid/view/View;)V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "e", "f", "TransitionEffect", Const.INTENT_KEY_BACKGROUND_COMMAND, "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0002\u0018\u00002\u00020\u0001Bß\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e\u0012\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010\u001f\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 J=\u0010%\u001a\u00020#2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0004\b%\u0010&J/\u0010)\u001a\u00020#2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010(\u001a\u00020\rH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020#2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b1\u0010,J\u0017\u00102\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b2\u0010,R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b1\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b/\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b+\u00106\u001a\u0004\b9\u00108R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER'\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0006¢\u0006\f\n\u0004\bF\u0010C\u001a\u0004\bG\u0010ER#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR'\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e8\u0006¢\u0006\f\n\u0004\bL\u0010C\u001a\u0004\bM\u0010ER'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e8\u0006¢\u0006\f\n\u0004\bN\u0010C\u001a\u0004\bO\u0010ER#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u00118\u0006¢\u0006\f\n\u0004\b)\u0010I\u001a\u0004\bP\u0010KR#\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u00118\u0006¢\u0006\f\n\u0004\b\u001f\u0010I\u001a\u0004\bQ\u0010KR\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\b\u0019\u0010TR\u001d\u0010\\\u001a\u00020U8\u0006¢\u0006\u0012\n\u0004\bV\u0010W\u0012\u0004\bZ\u0010[\u001a\u0004\bX\u0010YR$\u0010a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010?\u001a\u0004\b^\u0010A\"\u0004\b_\u0010`R\"\u0010e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010S\u001a\u0004\bb\u0010T\"\u0004\bc\u0010dR\u0014\u0010g\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010TR\u0011\u0010i\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bh\u0010T¨\u0006j"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect;", "Landroidx/fragment/app/SpecialEffectsController$b;", "", "Landroidx/fragment/app/DefaultSpecialEffectsController$g;", "transitionInfos", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "firstOut", "lastIn", "Landroidx/fragment/app/N;", "transitionImpl", "", "sharedElementTransition", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "sharedElementFirstOutViews", "sharedElementLastInViews", "Landroidx/collection/a;", "", "sharedElementNameMapping", "enteringNames", "exitingNames", "firstOutViews", "lastInViews", "", "isPop", "<init>", "(Ljava/util/List;Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/N;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/collection/a;Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/collection/a;Landroidx/collection/a;Z)V", "Landroid/view/ViewGroup;", "container", "Lkotlin/Pair;", "o", "(Landroid/view/ViewGroup;Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/SpecialEffectsController$Operation;)Lkotlin/Pair;", "enteringViews", "Lkotlin/Function0;", "LY8/t;", "executeTransition", "B", "(Ljava/util/ArrayList;Landroid/view/ViewGroup;Lp9/a;)V", "transitioningViews", "view", "n", "(Ljava/util/ArrayList;Landroid/view/View;)V", "f", "(Landroid/view/ViewGroup;)V", "Lb/c;", "backEvent", "e", "(Lb/c;Landroid/view/ViewGroup;)V", Const.INTENT_KEY_UMID, "c", "Ljava/util/List;", "w", "()Ljava/util/List;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "t", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "u", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/fragment/app/N;", "v", "()Landroidx/fragment/app/N;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/Object;", "getSharedElementTransition", "()Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/ArrayList;", "getSharedElementFirstOutViews", "()Ljava/util/ArrayList;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "getSharedElementLastInViews", "k", "Landroidx/collection/a;", "getSharedElementNameMapping", "()Landroidx/collection/a;", "l", "getEnteringNames", "m", "getExitingNames", "getFirstOutViews", "getLastInViews", "p", "Z", "()Z", "Lx0/d;", "q", "Lx0/d;", "getTransitionSignal", "()Lx0/d;", "getTransitionSignal$annotations", "()V", "transitionSignal", "r", "s", "C", "(Ljava/lang/Object;)V", "controller", "getNoControllerReturned", "D", "(Z)V", "noControllerReturned", Const.INTENT_KEY_PKGNAME, "isSeekingSupported", "x", "transitioning", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TransitionEffect extends SpecialEffectsController.b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final List<g> transitionInfos;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final SpecialEffectsController.Operation firstOut;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final SpecialEffectsController.Operation lastIn;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final N transitionImpl;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final Object sharedElementTransition;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public final ArrayList<View> sharedElementFirstOutViews;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public final ArrayList<View> sharedElementLastInViews;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final androidx.collection.a<String, String> sharedElementNameMapping;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public final ArrayList<String> enteringNames;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        public final ArrayList<String> exitingNames;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        public final androidx.collection.a<String, View> firstOutViews;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        public final androidx.collection.a<String, View> lastInViews;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        public final boolean isPop;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        public final x0.d transitionSignal;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        public Object controller;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        public boolean noControllerReturned;

        public TransitionEffect(List<g> transitionInfos, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, N transitionImpl, Object obj, ArrayList<View> sharedElementFirstOutViews, ArrayList<View> sharedElementLastInViews, androidx.collection.a<String, String> sharedElementNameMapping, ArrayList<String> enteringNames, ArrayList<String> exitingNames, androidx.collection.a<String, View> firstOutViews, androidx.collection.a<String, View> lastInViews, boolean z10) {
            kotlin.jvm.internal.p.i(transitionInfos, "transitionInfos");
            kotlin.jvm.internal.p.i(transitionImpl, "transitionImpl");
            kotlin.jvm.internal.p.i(sharedElementFirstOutViews, "sharedElementFirstOutViews");
            kotlin.jvm.internal.p.i(sharedElementLastInViews, "sharedElementLastInViews");
            kotlin.jvm.internal.p.i(sharedElementNameMapping, "sharedElementNameMapping");
            kotlin.jvm.internal.p.i(enteringNames, "enteringNames");
            kotlin.jvm.internal.p.i(exitingNames, "exitingNames");
            kotlin.jvm.internal.p.i(firstOutViews, "firstOutViews");
            kotlin.jvm.internal.p.i(lastInViews, "lastInViews");
            this.transitionInfos = transitionInfos;
            this.firstOut = operation;
            this.lastIn = operation2;
            this.transitionImpl = transitionImpl;
            this.sharedElementTransition = obj;
            this.sharedElementFirstOutViews = sharedElementFirstOutViews;
            this.sharedElementLastInViews = sharedElementLastInViews;
            this.sharedElementNameMapping = sharedElementNameMapping;
            this.enteringNames = enteringNames;
            this.exitingNames = exitingNames;
            this.firstOutViews = firstOutViews;
            this.lastInViews = lastInViews;
            this.isPop = z10;
            this.transitionSignal = new x0.d();
        }

        public static final void A(SpecialEffectsController.Operation operation, TransitionEffect this$0) {
            kotlin.jvm.internal.p.i(operation, "$operation");
            kotlin.jvm.internal.p.i(this$0, "this$0");
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.e(this$0);
        }

        public static final void p(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, TransitionEffect this$0) {
            kotlin.jvm.internal.p.i(this$0, "this$0");
            L.a(operation.getFragment(), operation2.getFragment(), this$0.isPop, this$0.lastInViews, false);
        }

        public static final void q(N impl, View view, Rect lastInEpicenterRect) {
            kotlin.jvm.internal.p.i(impl, "$impl");
            kotlin.jvm.internal.p.i(lastInEpicenterRect, "$lastInEpicenterRect");
            impl.k(view, lastInEpicenterRect);
        }

        public static final void r(ArrayList transitioningViews) {
            kotlin.jvm.internal.p.i(transitioningViews, "$transitioningViews");
            L.e(transitioningViews, 4);
        }

        public static final void y(SpecialEffectsController.Operation operation, TransitionEffect this$0) {
            kotlin.jvm.internal.p.i(operation, "$operation");
            kotlin.jvm.internal.p.i(this$0, "this$0");
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.e(this$0);
        }

        public static final void z(Ref$ObjectRef seekCancelLambda) {
            kotlin.jvm.internal.p.i(seekCancelLambda, "$seekCancelLambda");
            InterfaceC5063a interfaceC5063a = (InterfaceC5063a) seekCancelLambda.f34820a;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }

        public final void B(ArrayList<View> enteringViews, ViewGroup container, InterfaceC5063a<Y8.t> executeTransition) {
            L.e(enteringViews, 4);
            ArrayList<String> arrayListQ = this.transitionImpl.q(this.sharedElementLastInViews);
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
                Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
                Iterator<View> it = this.sharedElementFirstOutViews.iterator();
                while (it.hasNext()) {
                    View sharedElementFirstOutViews = it.next();
                    kotlin.jvm.internal.p.h(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                    View view = sharedElementFirstOutViews;
                    Log.v("FragmentManager", "View: " + view + " Name: " + androidx.core.view.N.D(view));
                }
                Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
                Iterator<View> it2 = this.sharedElementLastInViews.iterator();
                while (it2.hasNext()) {
                    View sharedElementLastInViews = it2.next();
                    kotlin.jvm.internal.p.h(sharedElementLastInViews, "sharedElementLastInViews");
                    View view2 = sharedElementLastInViews;
                    Log.v("FragmentManager", "View: " + view2 + " Name: " + androidx.core.view.N.D(view2));
                }
            }
            executeTransition.invoke();
            this.transitionImpl.y(container, this.sharedElementFirstOutViews, this.sharedElementLastInViews, arrayListQ, this.sharedElementNameMapping);
            L.e(enteringViews, 0);
            this.transitionImpl.A(this.sharedElementTransition, this.sharedElementFirstOutViews, this.sharedElementLastInViews);
        }

        public final void C(Object obj) {
            this.controller = obj;
        }

        public final void D(boolean z10) {
            this.noControllerReturned = z10;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        /* renamed from: b */
        public boolean getIsSeekingSupported() {
            if (!this.transitionImpl.m()) {
                return false;
            }
            List<g> list = this.transitionInfos;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (g gVar : list) {
                    if (gVar.getTransition() == null || !this.transitionImpl.n(gVar.getTransition())) {
                        return false;
                    }
                }
            }
            Object obj = this.sharedElementTransition;
            return obj == null || this.transitionImpl.n(obj);
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.p.i(container, "container");
            this.transitionSignal.a();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void d(final ViewGroup container) {
            kotlin.jvm.internal.p.i(container, "container");
            if (!container.isLaidOut() || this.noControllerReturned) {
                for (g gVar : this.transitionInfos) {
                    SpecialEffectsController.Operation operation = gVar.getOperation();
                    if (FragmentManager.N0(2)) {
                        if (this.noControllerReturned) {
                            Log.v("FragmentManager", "SpecialEffectsController: TransitionSeekController was not created. Completing operation " + operation);
                        } else {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Completing operation " + operation);
                        }
                    }
                    gVar.getOperation().e(this);
                }
                this.noControllerReturned = false;
                return;
            }
            Object obj = this.controller;
            if (obj != null) {
                N n10 = this.transitionImpl;
                kotlin.jvm.internal.p.f(obj);
                n10.c(obj);
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "Ending execution of operations from " + this.firstOut + " to " + this.lastIn);
                    return;
                }
                return;
            }
            Pair<ArrayList<View>, Object> pairO = o(container, this.lastIn, this.firstOut);
            ArrayList<View> arrayListA = pairO.a();
            final Object objB = pairO.b();
            List<g> list = this.transitionInfos;
            ArrayList<SpecialEffectsController.Operation> arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((g) it.next()).getOperation());
            }
            for (final SpecialEffectsController.Operation operation2 : arrayList) {
                this.transitionImpl.w(operation2.getFragment(), objB, this.transitionSignal, new Runnable() { // from class: androidx.fragment.app.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultSpecialEffectsController.TransitionEffect.y(operation2, this);
                    }
                });
            }
            B(arrayListA, container, new InterfaceC5063a<Y8.t>() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onCommit$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // p9.InterfaceC5063a
                public /* bridge */ /* synthetic */ Y8.t invoke() {
                    invoke2();
                    return Y8.t.f7040a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.f13831a.getTransitionImpl().e(container, objB);
                }
            });
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Completed executing operations from " + this.firstOut + " to " + this.lastIn);
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void e(C1423c backEvent, ViewGroup container) {
            kotlin.jvm.internal.p.i(backEvent, "backEvent");
            kotlin.jvm.internal.p.i(container, "container");
            Object obj = this.controller;
            if (obj != null) {
                this.transitionImpl.t(obj, backEvent.getProgress());
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void f(final ViewGroup container) {
            kotlin.jvm.internal.p.i(container, "container");
            if (!container.isLaidOut()) {
                Iterator<T> it = this.transitionInfos.iterator();
                while (it.hasNext()) {
                    SpecialEffectsController.Operation operation = ((g) it.next()).getOperation();
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Skipping onStart for operation " + operation);
                    }
                }
                return;
            }
            if (x() && this.sharedElementTransition != null && !getIsSeekingSupported()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + this.sharedElementTransition + " between " + this.firstOut + " and " + this.lastIn + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (getIsSeekingSupported() && x()) {
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Pair<ArrayList<View>, Object> pairO = o(container, this.lastIn, this.firstOut);
                ArrayList<View> arrayListA = pairO.a();
                final Object objB = pairO.b();
                List<g> list = this.transitionInfos;
                ArrayList<SpecialEffectsController.Operation> arrayList = new ArrayList(C1174w.x(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((g) it2.next()).getOperation());
                }
                for (final SpecialEffectsController.Operation operation2 : arrayList) {
                    this.transitionImpl.x(operation2.getFragment(), objB, this.transitionSignal, new Runnable() { // from class: androidx.fragment.app.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            DefaultSpecialEffectsController.TransitionEffect.z(ref$ObjectRef);
                        }
                    }, new Runnable() { // from class: androidx.fragment.app.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            DefaultSpecialEffectsController.TransitionEffect.A(operation2, this);
                        }
                    });
                }
                B(arrayListA, container, new InterfaceC5063a<Y8.t>() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4

                    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
                    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends Lambda implements InterfaceC5063a<Y8.t> {

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect f13838a;

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ Object f13839b;

                        /* renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ ViewGroup f13840c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(DefaultSpecialEffectsController.TransitionEffect transitionEffect, Object obj, ViewGroup viewGroup) {
                            super(0);
                            this.f13838a = transitionEffect;
                            this.f13839b = obj;
                            this.f13840c = viewGroup;
                        }

                        public static final void c(DefaultSpecialEffectsController.TransitionEffect this$0, ViewGroup container) {
                            kotlin.jvm.internal.p.i(this$0, "this$0");
                            kotlin.jvm.internal.p.i(container, "$container");
                            Iterator<T> it = this$0.w().iterator();
                            while (it.hasNext()) {
                                SpecialEffectsController.Operation operation = ((DefaultSpecialEffectsController.g) it.next()).getOperation();
                                View view = operation.getFragment().getView();
                                if (view != null) {
                                    operation.getFinalState().applyState(view, container);
                                }
                            }
                        }

                        public static final void d(DefaultSpecialEffectsController.TransitionEffect this$0) {
                            kotlin.jvm.internal.p.i(this$0, "this$0");
                            if (FragmentManager.N0(2)) {
                                Log.v("FragmentManager", "Transition for all operations has completed");
                            }
                            Iterator<T> it = this$0.w().iterator();
                            while (it.hasNext()) {
                                ((DefaultSpecialEffectsController.g) it.next()).getOperation().e(this$0);
                            }
                        }

                        @Override // p9.InterfaceC5063a
                        public /* bridge */ /* synthetic */ Y8.t invoke() {
                            invoke2();
                            return Y8.t.f7040a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            List<DefaultSpecialEffectsController.g> listW = this.f13838a.w();
                            if (!(listW instanceof Collection) || !listW.isEmpty()) {
                                Iterator<T> it = listW.iterator();
                                while (it.hasNext()) {
                                    if (!((DefaultSpecialEffectsController.g) it.next()).getOperation().getIsSeeking()) {
                                        if (FragmentManager.N0(2)) {
                                            Log.v("FragmentManager", "Completing animating immediately");
                                        }
                                        x0.d dVar = new x0.d();
                                        N transitionImpl = this.f13838a.getTransitionImpl();
                                        Fragment fragment = this.f13838a.w().get(0).getOperation().getFragment();
                                        Object obj = this.f13839b;
                                        final DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.f13838a;
                                        transitionImpl.w(fragment, obj, dVar, 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0067: INVOKE 
                                              (r1v7 'transitionImpl' androidx.fragment.app.N)
                                              (r2v6 'fragment' androidx.fragment.app.Fragment)
                                              (r3v2 'obj' java.lang.Object)
                                              (r0v5 'dVar' x0.d)
                                              (wrap:java.lang.Runnable:0x0064: CONSTRUCTOR (r5v1 'transitionEffect' androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect A[DONT_INLINE]) A[MD:(androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect):void (m), WRAPPED] call: androidx.fragment.app.k.<init>(androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect):void type: CONSTRUCTOR)
                                             VIRTUAL call: androidx.fragment.app.N.w(androidx.fragment.app.Fragment, java.lang.Object, x0.d, java.lang.Runnable):void A[MD:(androidx.fragment.app.Fragment, java.lang.Object, x0.d, java.lang.Runnable):void (m)] in method: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4.1.invoke():void, file: classes.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
                                            	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                            	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.fragment.app.k, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 35 more
                                            */
                                        /*
                                            this = this;
                                            androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r0 = r5.f13838a
                                            java.util.List r0 = r0.w()
                                            java.lang.Iterable r0 = (java.lang.Iterable) r0
                                            boolean r1 = r0 instanceof java.util.Collection
                                            java.lang.String r2 = "FragmentManager"
                                            r3 = 2
                                            if (r1 == 0) goto L19
                                            r1 = r0
                                            java.util.Collection r1 = (java.util.Collection) r1
                                            boolean r1 = r1.isEmpty()
                                            if (r1 == 0) goto L19
                                            goto L6e
                                        L19:
                                            java.util.Iterator r0 = r0.iterator()
                                        L1d:
                                            boolean r1 = r0.hasNext()
                                            if (r1 == 0) goto L6e
                                            java.lang.Object r1 = r0.next()
                                            androidx.fragment.app.DefaultSpecialEffectsController$g r1 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r1
                                            androidx.fragment.app.SpecialEffectsController$Operation r1 = r1.getOperation()
                                            boolean r1 = r1.getIsSeeking()
                                            if (r1 != 0) goto L1d
                                            boolean r0 = androidx.fragment.app.FragmentManager.N0(r3)
                                            if (r0 == 0) goto L3e
                                            java.lang.String r0 = "Completing animating immediately"
                                            android.util.Log.v(r2, r0)
                                        L3e:
                                            x0.d r0 = new x0.d
                                            r0.<init>()
                                            androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r1 = r5.f13838a
                                            androidx.fragment.app.N r1 = r1.getTransitionImpl()
                                            androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r2 = r5.f13838a
                                            java.util.List r2 = r2.w()
                                            r3 = 0
                                            java.lang.Object r2 = r2.get(r3)
                                            androidx.fragment.app.DefaultSpecialEffectsController$g r2 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r2
                                            androidx.fragment.app.SpecialEffectsController$Operation r2 = r2.getOperation()
                                            androidx.fragment.app.Fragment r2 = r2.getFragment()
                                            java.lang.Object r3 = r5.f13839b
                                            androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r5 = r5.f13838a
                                            androidx.fragment.app.k r4 = new androidx.fragment.app.k
                                            r4.<init>(r5)
                                            r1.w(r2, r3, r0, r4)
                                            r0.a()
                                            return
                                        L6e:
                                            boolean r0 = androidx.fragment.app.FragmentManager.N0(r3)
                                            if (r0 == 0) goto L79
                                            java.lang.String r0 = "Animating to start"
                                            android.util.Log.v(r2, r0)
                                        L79:
                                            androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r0 = r5.f13838a
                                            androidx.fragment.app.N r0 = r0.getTransitionImpl()
                                            androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r1 = r5.f13838a
                                            java.lang.Object r1 = r1.getController()
                                            kotlin.jvm.internal.p.f(r1)
                                            androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r2 = r5.f13838a
                                            android.view.ViewGroup r5 = r5.f13840c
                                            androidx.fragment.app.j r3 = new androidx.fragment.app.j
                                            r3.<init>(r2, r5)
                                            r0.d(r1, r3)
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4.AnonymousClass1.invoke2():void");
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // p9.InterfaceC5063a
                                public /* bridge */ /* synthetic */ Y8.t invoke() {
                                    invoke2();
                                    return Y8.t.f7040a;
                                }

                                /* JADX WARN: Type inference failed for: r3v2, types: [T, androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$1] */
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    if (FragmentManager.N0(2)) {
                                        Log.v("FragmentManager", "Attempting to create TransitionSeekController");
                                    }
                                    DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.f13834a;
                                    transitionEffect.C(transitionEffect.getTransitionImpl().j(container, objB));
                                    if (this.f13834a.getController() == null) {
                                        if (FragmentManager.N0(2)) {
                                            Log.v("FragmentManager", "TransitionSeekController was not created.");
                                        }
                                        this.f13834a.D(true);
                                        return;
                                    }
                                    ref$ObjectRef.f34820a = new AnonymousClass1(this.f13834a, objB, container);
                                    if (FragmentManager.N0(2)) {
                                        Log.v("FragmentManager", "Started executing operations from " + this.f13834a.getFirstOut() + " to " + this.f13834a.getLastIn());
                                    }
                                }
                            });
                        }
                    }

                    public final void n(ArrayList<View> transitioningViews, View view) {
                        if (!(view instanceof ViewGroup)) {
                            if (transitioningViews.contains(view)) {
                                return;
                            }
                            transitioningViews.add(view);
                            return;
                        }
                        ViewGroup viewGroup = (ViewGroup) view;
                        if (androidx.core.view.P.a(viewGroup)) {
                            if (transitioningViews.contains(view)) {
                                return;
                            }
                            transitioningViews.add(view);
                            return;
                        }
                        int childCount = viewGroup.getChildCount();
                        for (int i10 = 0; i10 < childCount; i10++) {
                            View child = viewGroup.getChildAt(i10);
                            if (child.getVisibility() == 0) {
                                kotlin.jvm.internal.p.h(child, "child");
                                n(transitioningViews, child);
                            }
                        }
                    }

                    public final Pair<ArrayList<View>, Object> o(ViewGroup container, SpecialEffectsController.Operation lastIn, final SpecialEffectsController.Operation firstOut) {
                        final SpecialEffectsController.Operation operation = lastIn;
                        View view = new View(container.getContext());
                        final Rect rect = new Rect();
                        Iterator<g> it = this.transitionInfos.iterator();
                        boolean z10 = false;
                        View view2 = null;
                        while (it.hasNext()) {
                            if (it.next().g() && firstOut != null && operation != null && !this.sharedElementNameMapping.isEmpty() && this.sharedElementTransition != null) {
                                L.a(operation.getFragment(), firstOut.getFragment(), this.isPop, this.firstOutViews, true);
                                androidx.core.view.D.a(container, new Runnable() { // from class: androidx.fragment.app.g
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        DefaultSpecialEffectsController.TransitionEffect.p(operation, firstOut, this);
                                    }
                                });
                                this.sharedElementFirstOutViews.addAll(this.firstOutViews.values());
                                if (!this.exitingNames.isEmpty()) {
                                    String str = this.exitingNames.get(0);
                                    kotlin.jvm.internal.p.h(str, "exitingNames[0]");
                                    view2 = this.firstOutViews.get(str);
                                    this.transitionImpl.v(this.sharedElementTransition, view2);
                                }
                                this.sharedElementLastInViews.addAll(this.lastInViews.values());
                                if (!this.enteringNames.isEmpty()) {
                                    String str2 = this.enteringNames.get(0);
                                    kotlin.jvm.internal.p.h(str2, "enteringNames[0]");
                                    final View view3 = this.lastInViews.get(str2);
                                    if (view3 != null) {
                                        final N n10 = this.transitionImpl;
                                        androidx.core.view.D.a(container, new Runnable() { // from class: androidx.fragment.app.h
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                DefaultSpecialEffectsController.TransitionEffect.q(n10, view3, rect);
                                            }
                                        });
                                        z10 = true;
                                    }
                                }
                                this.transitionImpl.z(this.sharedElementTransition, view, this.sharedElementFirstOutViews);
                                N n11 = this.transitionImpl;
                                Object obj = this.sharedElementTransition;
                                n11.s(obj, null, null, null, null, obj, this.sharedElementLastInViews);
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator<g> it2 = this.transitionInfos.iterator();
                        Object objP = null;
                        Object objP2 = null;
                        while (it2.hasNext()) {
                            g next = it2.next();
                            SpecialEffectsController.Operation operation2 = next.getOperation();
                            boolean z11 = z10;
                            Object objH = this.transitionImpl.h(next.getTransition());
                            if (objH != null) {
                                final ArrayList<View> arrayList2 = new ArrayList<>();
                                Iterator<g> it3 = it2;
                                View view4 = operation2.getFragment().mView;
                                kotlin.jvm.internal.p.h(view4, "operation.fragment.mView");
                                n(arrayList2, view4);
                                if (this.sharedElementTransition != null && (operation2 == firstOut || operation2 == operation)) {
                                    if (operation2 == firstOut) {
                                        arrayList2.removeAll(Z8.F.r1(this.sharedElementFirstOutViews));
                                    } else {
                                        arrayList2.removeAll(Z8.F.r1(this.sharedElementLastInViews));
                                    }
                                }
                                if (arrayList2.isEmpty()) {
                                    this.transitionImpl.a(objH, view);
                                } else {
                                    this.transitionImpl.b(objH, arrayList2);
                                    this.transitionImpl.s(objH, objH, arrayList2, null, null, null, null);
                                    if (operation2.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                        operation2.q(false);
                                        ArrayList<View> arrayList3 = new ArrayList<>(arrayList2);
                                        arrayList3.remove(operation2.getFragment().mView);
                                        this.transitionImpl.r(objH, operation2.getFragment().mView, arrayList3);
                                        androidx.core.view.D.a(container, new Runnable() { // from class: androidx.fragment.app.i
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                DefaultSpecialEffectsController.TransitionEffect.r(arrayList2);
                                            }
                                        });
                                    }
                                }
                                if (operation2.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                                    arrayList.addAll(arrayList2);
                                    if (z11) {
                                        this.transitionImpl.u(objH, rect);
                                    }
                                    if (FragmentManager.N0(2)) {
                                        Log.v("FragmentManager", "Entering Transition: " + objH);
                                        Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                                        Iterator<View> it4 = arrayList2.iterator();
                                        while (it4.hasNext()) {
                                            View transitioningViews = it4.next();
                                            kotlin.jvm.internal.p.h(transitioningViews, "transitioningViews");
                                            Log.v("FragmentManager", "View: " + transitioningViews);
                                        }
                                    }
                                } else {
                                    this.transitionImpl.v(objH, view2);
                                    if (FragmentManager.N0(2)) {
                                        Log.v("FragmentManager", "Exiting Transition: " + objH);
                                        Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                                        Iterator<View> it5 = arrayList2.iterator();
                                        while (it5.hasNext()) {
                                            View transitioningViews2 = it5.next();
                                            kotlin.jvm.internal.p.h(transitioningViews2, "transitioningViews");
                                            Log.v("FragmentManager", "View: " + transitioningViews2);
                                        }
                                    }
                                }
                                if (next.getIsOverlapAllowed()) {
                                    objP = this.transitionImpl.p(objP, objH, null);
                                } else {
                                    objP2 = this.transitionImpl.p(objP2, objH, null);
                                }
                                operation = lastIn;
                                z10 = z11;
                                it2 = it3;
                            } else {
                                operation = lastIn;
                                z10 = z11;
                            }
                        }
                        Object objO = this.transitionImpl.o(objP, objP2, this.sharedElementTransition);
                        if (FragmentManager.N0(2)) {
                            Log.v("FragmentManager", "Final merged transition: " + objO + " for container " + container);
                        }
                        return new Pair<>(arrayList, objO);
                    }

                    /* renamed from: s, reason: from getter */
                    public final Object getController() {
                        return this.controller;
                    }

                    /* renamed from: t, reason: from getter */
                    public final SpecialEffectsController.Operation getFirstOut() {
                        return this.firstOut;
                    }

                    /* renamed from: u, reason: from getter */
                    public final SpecialEffectsController.Operation getLastIn() {
                        return this.lastIn;
                    }

                    /* renamed from: v, reason: from getter */
                    public final N getTransitionImpl() {
                        return this.transitionImpl;
                    }

                    public final List<g> w() {
                        return this.transitionInfos;
                    }

                    public final boolean x() {
                        List<g> list = this.transitionInfos;
                        if ((list instanceof Collection) && list.isEmpty()) {
                            return true;
                        }
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            if (!((g) it.next()).getOperation().getFragment().mTransitioning) {
                                return false;
                            }
                        }
                        return true;
                    }
                }

                @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$a;", "Landroidx/fragment/app/SpecialEffectsController$b;", "Landroidx/fragment/app/DefaultSpecialEffectsController$b;", "animationInfo", "<init>", "(Landroidx/fragment/app/DefaultSpecialEffectsController$b;)V", "Landroid/view/ViewGroup;", "container", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/view/ViewGroup;)V", "c", "Landroidx/fragment/app/DefaultSpecialEffectsController$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/fragment/app/DefaultSpecialEffectsController$b;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class a extends SpecialEffectsController.b {

                    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                    public final b animationInfo;

                    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"androidx/fragment/app/DefaultSpecialEffectsController$a$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "LY8/t;", "onAnimationStart", "(Landroid/view/animation/Animation;)V", "onAnimationEnd", "onAnimationRepeat", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$a$a, reason: collision with other inner class name */
                    public static final class AnimationAnimationListenerC0171a implements Animation.AnimationListener {

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ SpecialEffectsController.Operation f13842a;

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ ViewGroup f13843b;

                        /* renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ View f13844c;

                        /* renamed from: d, reason: collision with root package name */
                        public final /* synthetic */ a f13845d;

                        public AnimationAnimationListenerC0171a(SpecialEffectsController.Operation operation, ViewGroup viewGroup, View view, a aVar) {
                            this.f13842a = operation;
                            this.f13843b = viewGroup;
                            this.f13844c = view;
                            this.f13845d = aVar;
                        }

                        public static final void b(ViewGroup container, View view, a this$0) {
                            kotlin.jvm.internal.p.i(container, "$container");
                            kotlin.jvm.internal.p.i(this$0, "this$0");
                            container.endViewTransition(view);
                            this$0.getAnimationInfo().getOperation().e(this$0);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            kotlin.jvm.internal.p.i(animation, "animation");
                            final ViewGroup viewGroup = this.f13843b;
                            final View view = this.f13844c;
                            final a aVar = this.f13845d;
                            viewGroup.post(new Runnable() { // from class: androidx.fragment.app.c
                                @Override // java.lang.Runnable
                                public final void run() {
                                    DefaultSpecialEffectsController.a.AnimationAnimationListenerC0171a.b(viewGroup, view, aVar);
                                }
                            });
                            if (FragmentManager.N0(2)) {
                                Log.v("FragmentManager", "Animation from operation " + this.f13842a + " has ended.");
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                            kotlin.jvm.internal.p.i(animation, "animation");
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            kotlin.jvm.internal.p.i(animation, "animation");
                            if (FragmentManager.N0(2)) {
                                Log.v("FragmentManager", "Animation from operation " + this.f13842a + " has reached onAnimationStart.");
                            }
                        }
                    }

                    public a(b animationInfo) {
                        kotlin.jvm.internal.p.i(animationInfo, "animationInfo");
                        this.animationInfo = animationInfo;
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.b
                    public void c(ViewGroup container) {
                        kotlin.jvm.internal.p.i(container, "container");
                        SpecialEffectsController.Operation operation = this.animationInfo.getOperation();
                        View view = operation.getFragment().mView;
                        view.clearAnimation();
                        container.endViewTransition(view);
                        this.animationInfo.getOperation().e(this);
                        if (FragmentManager.N0(2)) {
                            Log.v("FragmentManager", "Animation from operation " + operation + " has been cancelled.");
                        }
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.b
                    public void d(ViewGroup container) throws Resources.NotFoundException {
                        kotlin.jvm.internal.p.i(container, "container");
                        if (this.animationInfo.b()) {
                            this.animationInfo.getOperation().e(this);
                            return;
                        }
                        Context context = container.getContext();
                        SpecialEffectsController.Operation operation = this.animationInfo.getOperation();
                        View view = operation.getFragment().mView;
                        b bVar = this.animationInfo;
                        kotlin.jvm.internal.p.h(context, "context");
                        C1380s.a aVarC = bVar.c(context);
                        if (aVarC == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        Animation animation = aVarC.f14119a;
                        if (animation == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        if (operation.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                            view.startAnimation(animation);
                            this.animationInfo.getOperation().e(this);
                            return;
                        }
                        container.startViewTransition(view);
                        C1380s.b bVar2 = new C1380s.b(animation, container, view);
                        bVar2.setAnimationListener(new AnimationAnimationListenerC0171a(operation, container, view, this));
                        view.startAnimation(bVar2);
                        if (FragmentManager.N0(2)) {
                            Log.v("FragmentManager", "Animation from operation " + operation + " has started.");
                        }
                    }

                    /* renamed from: h, reason: from getter */
                    public final b getAnimationInfo() {
                        return this.animationInfo;
                    }
                }

                @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$b;", "Landroidx/fragment/app/DefaultSpecialEffectsController$f;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "", "isPop", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Z)V", "Landroid/content/Context;", "context", "Landroidx/fragment/app/s$a;", "c", "(Landroid/content/Context;)Landroidx/fragment/app/s$a;", Const.INTENT_KEY_PKGNAME, "Z", "isAnimLoaded", Const.INTENT_KEY_UMID, "Landroidx/fragment/app/s$a;", "animation", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class b extends f {

                    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
                    public final boolean isPop;

                    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
                    public boolean isAnimLoaded;

                    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                    public C1380s.a animation;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public b(SpecialEffectsController.Operation operation, boolean z10) {
                        super(operation);
                        kotlin.jvm.internal.p.i(operation, "operation");
                        this.isPop = z10;
                    }

                    public final C1380s.a c(Context context) throws Resources.NotFoundException {
                        kotlin.jvm.internal.p.i(context, "context");
                        if (this.isAnimLoaded) {
                            return this.animation;
                        }
                        C1380s.a aVarB = C1380s.b(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.isPop);
                        this.animation = aVarB;
                        this.isAnimLoaded = true;
                        return aVarB;
                    }
                }

                @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$c;", "Landroidx/fragment/app/SpecialEffectsController$b;", "Landroidx/fragment/app/DefaultSpecialEffectsController$b;", "animatorInfo", "<init>", "(Landroidx/fragment/app/DefaultSpecialEffectsController$b;)V", "Landroid/view/ViewGroup;", "container", "LY8/t;", "f", "(Landroid/view/ViewGroup;)V", "Lb/c;", "backEvent", "e", "(Lb/c;Landroid/view/ViewGroup;)V", Const.INTENT_KEY_UMID, "c", "Landroidx/fragment/app/DefaultSpecialEffectsController$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/fragment/app/DefaultSpecialEffectsController$b;", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "getAnimator", "()Landroid/animation/AnimatorSet;", "setAnimator", "(Landroid/animation/AnimatorSet;)V", "animator", "", Const.INTENT_KEY_PKGNAME, "()Z", "isSeekingSupported", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class c extends SpecialEffectsController.b {

                    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                    public final b animatorInfo;

                    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
                    public AnimatorSet animator;

                    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/fragment/app/DefaultSpecialEffectsController$c$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "anim", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                    public static final class a extends AnimatorListenerAdapter {

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ ViewGroup f13851a;

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ View f13852b;

                        /* renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ boolean f13853c;

                        /* renamed from: d, reason: collision with root package name */
                        public final /* synthetic */ SpecialEffectsController.Operation f13854d;

                        /* renamed from: e, reason: collision with root package name */
                        public final /* synthetic */ c f13855e;

                        public a(ViewGroup viewGroup, View view, boolean z10, SpecialEffectsController.Operation operation, c cVar) {
                            this.f13851a = viewGroup;
                            this.f13852b = view;
                            this.f13853c = z10;
                            this.f13854d = operation;
                            this.f13855e = cVar;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator anim) {
                            kotlin.jvm.internal.p.i(anim, "anim");
                            this.f13851a.endViewTransition(this.f13852b);
                            if (this.f13853c || this.f13854d.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                SpecialEffectsController.Operation.State finalState = this.f13854d.getFinalState();
                                View viewToAnimate = this.f13852b;
                                kotlin.jvm.internal.p.h(viewToAnimate, "viewToAnimate");
                                finalState.applyState(viewToAnimate, this.f13851a);
                            }
                            this.f13855e.getAnimatorInfo().getOperation().e(this.f13855e);
                            if (FragmentManager.N0(2)) {
                                Log.v("FragmentManager", "Animator from operation " + this.f13854d + " has ended.");
                            }
                        }
                    }

                    public c(b animatorInfo) {
                        kotlin.jvm.internal.p.i(animatorInfo, "animatorInfo");
                        this.animatorInfo = animatorInfo;
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.b
                    /* renamed from: b */
                    public boolean getIsSeekingSupported() {
                        return true;
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.b
                    public void c(ViewGroup container) {
                        kotlin.jvm.internal.p.i(container, "container");
                        AnimatorSet animatorSet = this.animator;
                        if (animatorSet == null) {
                            this.animatorInfo.getOperation().e(this);
                            return;
                        }
                        SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
                        if (operation.getIsSeeking()) {
                            e.f13857a.a(animatorSet);
                        } else {
                            animatorSet.end();
                        }
                        if (FragmentManager.N0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Animator from operation ");
                            sb2.append(operation);
                            sb2.append(" has been canceled");
                            sb2.append(operation.getIsSeeking() ? " with seeking." : ".");
                            sb2.append(' ');
                            Log.v("FragmentManager", sb2.toString());
                        }
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.b
                    public void d(ViewGroup container) {
                        kotlin.jvm.internal.p.i(container, "container");
                        SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
                        AnimatorSet animatorSet = this.animator;
                        if (animatorSet == null) {
                            this.animatorInfo.getOperation().e(this);
                            return;
                        }
                        animatorSet.start();
                        if (FragmentManager.N0(2)) {
                            Log.v("FragmentManager", "Animator from operation " + operation + " has started.");
                        }
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.b
                    public void e(C1423c backEvent, ViewGroup container) {
                        kotlin.jvm.internal.p.i(backEvent, "backEvent");
                        kotlin.jvm.internal.p.i(container, "container");
                        SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
                        AnimatorSet animatorSet = this.animator;
                        if (animatorSet == null) {
                            this.animatorInfo.getOperation().e(this);
                            return;
                        }
                        if (operation.getFragment().mTransitioning) {
                            if (FragmentManager.N0(2)) {
                                Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + operation);
                            }
                            long jA = d.f13856a.a(animatorSet);
                            long progress = (long) (backEvent.getProgress() * jA);
                            if (progress == 0) {
                                progress = 1;
                            }
                            if (progress == jA) {
                                progress = jA - 1;
                            }
                            if (FragmentManager.N0(2)) {
                                Log.v("FragmentManager", "Setting currentPlayTime to " + progress + " for Animator " + animatorSet + " on operation " + operation);
                            }
                            e.f13857a.b(animatorSet, progress);
                        }
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.b
                    public void f(ViewGroup container) throws Resources.NotFoundException {
                        c cVar;
                        kotlin.jvm.internal.p.i(container, "container");
                        if (this.animatorInfo.b()) {
                            return;
                        }
                        Context context = container.getContext();
                        b bVar = this.animatorInfo;
                        kotlin.jvm.internal.p.h(context, "context");
                        C1380s.a aVarC = bVar.c(context);
                        this.animator = aVarC != null ? aVarC.f14120b : null;
                        SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
                        Fragment fragment = operation.getFragment();
                        boolean z10 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                        View view = fragment.mView;
                        container.startViewTransition(view);
                        AnimatorSet animatorSet = this.animator;
                        if (animatorSet != null) {
                            cVar = this;
                            animatorSet.addListener(new a(container, view, z10, operation, cVar));
                        } else {
                            cVar = this;
                        }
                        AnimatorSet animatorSet2 = cVar.animator;
                        if (animatorSet2 != null) {
                            animatorSet2.setTarget(view);
                        }
                    }

                    /* renamed from: h, reason: from getter */
                    public final b getAnimatorInfo() {
                        return this.animatorInfo;
                    }
                }

                @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$d;", "", "<init>", "()V", "Landroid/animation/AnimatorSet;", "animatorSet", "", Const.INTENT_KEY_APIKEY, "(Landroid/animation/AnimatorSet;)J", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class d {

                    /* renamed from: a, reason: collision with root package name */
                    public static final d f13856a = new d();

                    public final long a(AnimatorSet animatorSet) {
                        kotlin.jvm.internal.p.i(animatorSet, "animatorSet");
                        return animatorSet.getTotalDuration();
                    }
                }

                @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$e;", "", "<init>", "()V", "Landroid/animation/AnimatorSet;", "animatorSet", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/animation/AnimatorSet;)V", "", "time", Const.INTENT_KEY_PKGNAME, "(Landroid/animation/AnimatorSet;J)V", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class e {

                    /* renamed from: a, reason: collision with root package name */
                    public static final e f13857a = new e();

                    public final void a(AnimatorSet animatorSet) {
                        kotlin.jvm.internal.p.i(animatorSet, "animatorSet");
                        animatorSet.reverse();
                    }

                    public final void b(AnimatorSet animatorSet, long time) {
                        kotlin.jvm.internal.p.i(animatorSet, "animatorSet");
                        animatorSet.setCurrentPlayTime(time);
                    }
                }

                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$f;", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation;)V", Const.INTENT_KEY_APIKEY, "Landroidx/fragment/app/SpecialEffectsController$Operation;", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "", Const.INTENT_KEY_PKGNAME, "()Z", "isVisibilityUnchanged", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static class f {

                    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
                    public final SpecialEffectsController.Operation operation;

                    public f(SpecialEffectsController.Operation operation) {
                        kotlin.jvm.internal.p.i(operation, "operation");
                        this.operation = operation;
                    }

                    /* renamed from: a, reason: from getter */
                    public final SpecialEffectsController.Operation getOperation() {
                        return this.operation;
                    }

                    public final boolean b() {
                        View view = this.operation.getFragment().mView;
                        SpecialEffectsController.Operation.State stateA = view != null ? SpecialEffectsController.Operation.State.INSTANCE.a(view) : null;
                        SpecialEffectsController.Operation.State finalState = this.operation.getFinalState();
                        if (stateA == finalState) {
                            return true;
                        }
                        SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
                        return (stateA == state || finalState == state) ? false : true;
                    }
                }

                @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\nR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$g;", "Landroidx/fragment/app/DefaultSpecialEffectsController$f;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "", "isPop", "providesSharedElementTransition", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation;ZZ)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "", "transition", "Landroidx/fragment/app/N;", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;)Landroidx/fragment/app/N;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "c", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "isOverlapAllowed", "e", "sharedElementTransition", "()Landroidx/fragment/app/N;", "handlingImpl", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class g extends f {

                    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
                    public final Object transition;

                    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
                    public final boolean isOverlapAllowed;

                    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                    public final Object sharedElementTransition;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public g(SpecialEffectsController.Operation operation, boolean z10, boolean z11) {
                        Object returnTransition;
                        super(operation);
                        kotlin.jvm.internal.p.i(operation, "operation");
                        SpecialEffectsController.Operation.State finalState = operation.getFinalState();
                        SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
                        if (finalState == state) {
                            Fragment fragment = operation.getFragment();
                            returnTransition = z10 ? fragment.getReenterTransition() : fragment.getEnterTransition();
                        } else {
                            Fragment fragment2 = operation.getFragment();
                            returnTransition = z10 ? fragment2.getReturnTransition() : fragment2.getExitTransition();
                        }
                        this.transition = returnTransition;
                        this.isOverlapAllowed = operation.getFinalState() == state ? z10 ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap() : true;
                        this.sharedElementTransition = z11 ? z10 ? operation.getFragment().getSharedElementReturnTransition() : operation.getFragment().getSharedElementEnterTransition() : null;
                    }

                    public final N c() {
                        N nD = d(this.transition);
                        N nD2 = d(this.sharedElementTransition);
                        if (nD == null || nD2 == null || nD == nD2) {
                            return nD == null ? nD2 : nD;
                        }
                        throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.transition + " which uses a different Transition  type than its shared element transition " + this.sharedElementTransition).toString());
                    }

                    public final N d(Object transition) {
                        if (transition == null) {
                            return null;
                        }
                        N n10 = L.PLATFORM_IMPL;
                        if (n10 != null && n10.g(transition)) {
                            return n10;
                        }
                        N n11 = L.SUPPORT_IMPL;
                        if (n11 != null && n11.g(transition)) {
                            return n11;
                        }
                        throw new IllegalArgumentException("Transition " + transition + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
                    }

                    /* renamed from: e, reason: from getter */
                    public final Object getSharedElementTransition() {
                        return this.sharedElementTransition;
                    }

                    /* renamed from: f, reason: from getter */
                    public final Object getTransition() {
                        return this.transition;
                    }

                    public final boolean g() {
                        return this.sharedElementTransition != null;
                    }

                    /* renamed from: h, reason: from getter */
                    public final boolean getIsOverlapAllowed() {
                        return this.isOverlapAllowed;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public DefaultSpecialEffectsController(ViewGroup container) {
                    super(container);
                    kotlin.jvm.internal.p.i(container, "container");
                }

                public static final void G(DefaultSpecialEffectsController this$0, SpecialEffectsController.Operation operation) {
                    kotlin.jvm.internal.p.i(this$0, "this$0");
                    kotlin.jvm.internal.p.i(operation, "$operation");
                    this$0.c(operation);
                }

                @SuppressLint({"NewApi", "PrereleaseSdkCoreDependency"})
                public final void F(List<b> animationInfos) throws Resources.NotFoundException {
                    ArrayList<b> arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it = animationInfos.iterator();
                    while (it.hasNext()) {
                        Z8.A.E(arrayList2, ((b) it.next()).getOperation().f());
                    }
                    boolean zIsEmpty = arrayList2.isEmpty();
                    boolean z10 = false;
                    for (b bVar : animationInfos) {
                        Context context = getContainer().getContext();
                        SpecialEffectsController.Operation operation = bVar.getOperation();
                        kotlin.jvm.internal.p.h(context, "context");
                        C1380s.a aVarC = bVar.c(context);
                        if (aVarC != null) {
                            if (aVarC.f14120b == null) {
                                arrayList.add(bVar);
                            } else {
                                Fragment fragment = operation.getFragment();
                                if (operation.f().isEmpty()) {
                                    if (operation.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                        operation.q(false);
                                    }
                                    operation.b(new c(bVar));
                                    z10 = true;
                                } else if (FragmentManager.N0(2)) {
                                    Log.v("FragmentManager", "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                                }
                            }
                        }
                    }
                    for (b bVar2 : arrayList) {
                        SpecialEffectsController.Operation operation2 = bVar2.getOperation();
                        Fragment fragment2 = operation2.getFragment();
                        if (zIsEmpty) {
                            if (!z10) {
                                operation2.b(new a(bVar2));
                            } else if (FragmentManager.N0(2)) {
                                Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                            }
                        } else if (FragmentManager.N0(2)) {
                            Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                        }
                    }
                }

                public final void H(List<g> transitionInfos, boolean isPop, SpecialEffectsController.Operation firstOut, SpecialEffectsController.Operation lastIn) {
                    ArrayList arrayList;
                    N n10;
                    ArrayList arrayList2;
                    ArrayList arrayList3;
                    Iterator it;
                    Object obj;
                    int i10;
                    String strB;
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj2 : transitionInfos) {
                        if (!((g) obj2).b()) {
                            arrayList4.add(obj2);
                        }
                    }
                    ArrayList<g> arrayList5 = new ArrayList();
                    for (Object obj3 : arrayList4) {
                        if (((g) obj3).c() != null) {
                            arrayList5.add(obj3);
                        }
                    }
                    Object obj4 = null;
                    N n11 = null;
                    for (g gVar : arrayList5) {
                        N nC = gVar.c();
                        if (n11 != null && nC != n11) {
                            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + gVar.getOperation().getFragment() + " returned Transition " + gVar.getTransition() + " which uses a different Transition type than other Fragments.").toString());
                        }
                        n11 = nC;
                    }
                    if (n11 == null) {
                        return;
                    }
                    ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = new ArrayList();
                    androidx.collection.a aVar = new androidx.collection.a();
                    ArrayList<String> arrayList8 = new ArrayList<>();
                    ArrayList<String> arrayList9 = new ArrayList<>();
                    androidx.collection.a<String, View> aVar2 = new androidx.collection.a<>();
                    androidx.collection.a<String, View> aVar3 = new androidx.collection.a<>();
                    Iterator it2 = arrayList5.iterator();
                    while (it2.hasNext()) {
                        g gVar2 = (g) it2.next();
                        if (!gVar2.g() || firstOut == null || lastIn == null) {
                            arrayList = arrayList5;
                            n10 = n11;
                            arrayList2 = arrayList6;
                            arrayList3 = arrayList7;
                            it = it2;
                        } else {
                            Object objB = n11.B(n11.h(gVar2.getSharedElementTransition()));
                            arrayList9 = lastIn.getFragment().getSharedElementSourceNames();
                            kotlin.jvm.internal.p.h(arrayList9, "lastIn.fragment.sharedElementSourceNames");
                            ArrayList<String> sharedElementSourceNames = firstOut.getFragment().getSharedElementSourceNames();
                            kotlin.jvm.internal.p.h(sharedElementSourceNames, "firstOut.fragment.sharedElementSourceNames");
                            ArrayList<String> sharedElementTargetNames = firstOut.getFragment().getSharedElementTargetNames();
                            kotlin.jvm.internal.p.h(sharedElementTargetNames, "firstOut.fragment.sharedElementTargetNames");
                            int size = sharedElementTargetNames.size();
                            arrayList = arrayList5;
                            n10 = n11;
                            int i11 = 0;
                            while (i11 < size) {
                                ArrayList arrayList10 = arrayList6;
                                int iIndexOf = arrayList9.indexOf(sharedElementTargetNames.get(i11));
                                if (iIndexOf != -1) {
                                    arrayList9.set(iIndexOf, sharedElementSourceNames.get(i11));
                                }
                                i11++;
                                arrayList6 = arrayList10;
                            }
                            arrayList2 = arrayList6;
                            arrayList8 = lastIn.getFragment().getSharedElementTargetNames();
                            kotlin.jvm.internal.p.h(arrayList8, "lastIn.fragment.sharedElementTargetNames");
                            Pair pairA = !isPop ? Y8.j.a(firstOut.getFragment().getExitTransitionCallback(), lastIn.getFragment().getEnterTransitionCallback()) : Y8.j.a(firstOut.getFragment().getEnterTransitionCallback(), lastIn.getFragment().getExitTransitionCallback());
                            androidx.core.app.s sVar = (androidx.core.app.s) pairA.a();
                            androidx.core.app.s sVar2 = (androidx.core.app.s) pairA.b();
                            int size2 = arrayList9.size();
                            int i12 = 0;
                            while (true) {
                                arrayList3 = arrayList7;
                                if (i12 >= size2) {
                                    break;
                                }
                                Iterator it3 = it2;
                                String str = arrayList9.get(i12);
                                kotlin.jvm.internal.p.h(str, "exitingNames[i]");
                                String str2 = arrayList8.get(i12);
                                kotlin.jvm.internal.p.h(str2, "enteringNames[i]");
                                aVar.put(str, str2);
                                i12++;
                                arrayList7 = arrayList3;
                                it2 = it3;
                            }
                            it = it2;
                            int i13 = 2;
                            if (FragmentManager.N0(2)) {
                                Log.v("FragmentManager", ">>> entering view names <<<");
                                Iterator<String> it4 = arrayList8.iterator();
                                while (true) {
                                    i10 = i13;
                                    if (!it4.hasNext()) {
                                        break;
                                    }
                                    Iterator<String> it5 = it4;
                                    Log.v("FragmentManager", "Name: " + it4.next());
                                    objB = objB;
                                    i13 = i10;
                                    it4 = it5;
                                }
                                obj = objB;
                                Log.v("FragmentManager", ">>> exiting view names <<<");
                                for (Iterator<String> it6 = arrayList9.iterator(); it6.hasNext(); it6 = it6) {
                                    Log.v("FragmentManager", "Name: " + it6.next());
                                }
                            } else {
                                obj = objB;
                                i10 = 2;
                            }
                            View view = firstOut.getFragment().mView;
                            kotlin.jvm.internal.p.h(view, "firstOut.fragment.mView");
                            I(aVar2, view);
                            aVar2.retainAll(arrayList9);
                            if (sVar != null) {
                                if (FragmentManager.N0(i10)) {
                                    Log.v("FragmentManager", "Executing exit callback for operation " + firstOut);
                                }
                                sVar.d(arrayList9, aVar2);
                                int size3 = arrayList9.size() - 1;
                                if (size3 >= 0) {
                                    while (true) {
                                        int i14 = size3 - 1;
                                        String str3 = arrayList9.get(size3);
                                        kotlin.jvm.internal.p.h(str3, "exitingNames[i]");
                                        String str4 = str3;
                                        View view2 = aVar2.get(str4);
                                        if (view2 == null) {
                                            aVar.remove(str4);
                                        } else if (!kotlin.jvm.internal.p.d(str4, androidx.core.view.N.D(view2))) {
                                            aVar.put(androidx.core.view.N.D(view2), (String) aVar.remove(str4));
                                        }
                                        if (i14 < 0) {
                                            break;
                                        } else {
                                            size3 = i14;
                                        }
                                    }
                                }
                            } else {
                                aVar.retainAll(aVar2.keySet());
                            }
                            View view3 = lastIn.getFragment().mView;
                            kotlin.jvm.internal.p.h(view3, "lastIn.fragment.mView");
                            I(aVar3, view3);
                            aVar3.retainAll(arrayList8);
                            aVar3.retainAll(aVar.values());
                            if (sVar2 != null) {
                                if (FragmentManager.N0(i10)) {
                                    Log.v("FragmentManager", "Executing enter callback for operation " + lastIn);
                                }
                                sVar2.d(arrayList8, aVar3);
                                int size4 = arrayList8.size() - 1;
                                if (size4 >= 0) {
                                    while (true) {
                                        int i15 = size4 - 1;
                                        String str5 = arrayList8.get(size4);
                                        kotlin.jvm.internal.p.h(str5, "enteringNames[i]");
                                        String str6 = str5;
                                        View view4 = aVar3.get(str6);
                                        if (view4 == null) {
                                            String strB2 = L.b(aVar, str6);
                                            if (strB2 != null) {
                                                aVar.remove(strB2);
                                            }
                                        } else if (!kotlin.jvm.internal.p.d(str6, androidx.core.view.N.D(view4)) && (strB = L.b(aVar, str6)) != null) {
                                            aVar.put(strB, androidx.core.view.N.D(view4));
                                        }
                                        if (i15 < 0) {
                                            break;
                                        } else {
                                            size4 = i15;
                                        }
                                    }
                                }
                            } else {
                                L.d(aVar, aVar3);
                            }
                            Collection<String> collectionKeySet = aVar.keySet();
                            kotlin.jvm.internal.p.h(collectionKeySet, "sharedElementNameMapping.keys");
                            J(aVar2, collectionKeySet);
                            Collection<String> collectionValues = aVar.values();
                            kotlin.jvm.internal.p.h(collectionValues, "sharedElementNameMapping.values");
                            J(aVar3, collectionValues);
                            if (aVar.isEmpty()) {
                                Log.i("FragmentManager", "Ignoring shared elements transition " + obj + " between " + firstOut + " and " + lastIn + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
                                arrayList2.clear();
                                arrayList3.clear();
                                arrayList5 = arrayList;
                                n11 = n10;
                                arrayList6 = arrayList2;
                                arrayList7 = arrayList3;
                                it2 = it;
                                obj4 = null;
                            } else {
                                obj4 = obj;
                            }
                        }
                        arrayList5 = arrayList;
                        n11 = n10;
                        arrayList6 = arrayList2;
                        arrayList7 = arrayList3;
                        it2 = it;
                    }
                    ArrayList arrayList11 = arrayList5;
                    N n12 = n11;
                    ArrayList arrayList12 = arrayList6;
                    ArrayList arrayList13 = arrayList7;
                    if (obj4 == null) {
                        if (arrayList11.isEmpty()) {
                            return;
                        }
                        Iterator it7 = arrayList11.iterator();
                        while (it7.hasNext()) {
                            if (((g) it7.next()).getTransition() == null) {
                            }
                        }
                        return;
                    }
                    TransitionEffect transitionEffect = new TransitionEffect(arrayList11, firstOut, lastIn, n12, obj4, arrayList12, arrayList13, aVar, arrayList8, arrayList9, aVar2, aVar3, isPop);
                    Iterator it8 = arrayList11.iterator();
                    while (it8.hasNext()) {
                        ((g) it8.next()).getOperation().b(transitionEffect);
                    }
                }

                public final void I(Map<String, View> namedViews, View view) {
                    String strD = androidx.core.view.N.D(view);
                    if (strD != null) {
                        namedViews.put(strD, view);
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i10 = 0; i10 < childCount; i10++) {
                            View child = viewGroup.getChildAt(i10);
                            if (child.getVisibility() == 0) {
                                kotlin.jvm.internal.p.h(child, "child");
                                I(namedViews, child);
                            }
                        }
                    }
                }

                public final void J(androidx.collection.a<String, View> aVar, final Collection<String> collection) {
                    Set<Map.Entry<String, View>> entries = aVar.entrySet();
                    kotlin.jvm.internal.p.h(entries, "entries");
                    Z8.A.P(entries, new InterfaceC5074l<Map.Entry<String, View>, Boolean>() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$retainMatchingViews$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // p9.InterfaceC5074l
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public final Boolean invoke(Map.Entry<String, View> entry) {
                            kotlin.jvm.internal.p.i(entry, "entry");
                            return Boolean.valueOf(Z8.F.f0(collection, androidx.core.view.N.D(entry.getValue())));
                        }
                    });
                }

                public final void K(List<? extends SpecialEffectsController.Operation> operations) {
                    Fragment fragment = ((SpecialEffectsController.Operation) Z8.F.C0(operations)).getFragment();
                    for (SpecialEffectsController.Operation operation : operations) {
                        operation.getFragment().mAnimationInfo.f13884c = fragment.mAnimationInfo.f13884c;
                        operation.getFragment().mAnimationInfo.f13885d = fragment.mAnimationInfo.f13885d;
                        operation.getFragment().mAnimationInfo.f13886e = fragment.mAnimationInfo.f13886e;
                        operation.getFragment().mAnimationInfo.f13887f = fragment.mAnimationInfo.f13887f;
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:31:0x00c7  */
                @Override // androidx.fragment.app.SpecialEffectsController
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void d(java.util.List<? extends androidx.fragment.app.SpecialEffectsController.Operation> r11, boolean r12) throws android.content.res.Resources.NotFoundException {
                    /*
                        r10 = this;
                        java.lang.String r0 = "operations"
                        kotlin.jvm.internal.p.i(r11, r0)
                        r0 = 2
                        boolean r1 = androidx.fragment.app.FragmentManager.N0(r0)
                        java.lang.String r2 = "FragmentManager"
                        if (r1 == 0) goto L13
                        java.lang.String r1 = "Collecting Effects"
                        android.util.Log.v(r2, r1)
                    L13:
                        r1 = r11
                        java.lang.Iterable r1 = (java.lang.Iterable) r1
                        java.util.Iterator r1 = r1.iterator()
                    L1a:
                        boolean r3 = r1.hasNext()
                        r4 = 0
                        java.lang.String r5 = "operation.fragment.mView"
                        if (r3 == 0) goto L44
                        java.lang.Object r3 = r1.next()
                        r6 = r3
                        androidx.fragment.app.SpecialEffectsController$Operation r6 = (androidx.fragment.app.SpecialEffectsController.Operation) r6
                        androidx.fragment.app.SpecialEffectsController$Operation$State$a r7 = androidx.fragment.app.SpecialEffectsController.Operation.State.INSTANCE
                        androidx.fragment.app.Fragment r8 = r6.getFragment()
                        android.view.View r8 = r8.mView
                        kotlin.jvm.internal.p.h(r8, r5)
                        androidx.fragment.app.SpecialEffectsController$Operation$State r7 = r7.a(r8)
                        androidx.fragment.app.SpecialEffectsController$Operation$State r8 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
                        if (r7 != r8) goto L1a
                        androidx.fragment.app.SpecialEffectsController$Operation$State r6 = r6.getFinalState()
                        if (r6 == r8) goto L1a
                        goto L45
                    L44:
                        r3 = r4
                    L45:
                        androidx.fragment.app.SpecialEffectsController$Operation r3 = (androidx.fragment.app.SpecialEffectsController.Operation) r3
                        int r1 = r11.size()
                        java.util.ListIterator r1 = r11.listIterator(r1)
                    L4f:
                        boolean r6 = r1.hasPrevious()
                        if (r6 == 0) goto L76
                        java.lang.Object r6 = r1.previous()
                        r7 = r6
                        androidx.fragment.app.SpecialEffectsController$Operation r7 = (androidx.fragment.app.SpecialEffectsController.Operation) r7
                        androidx.fragment.app.SpecialEffectsController$Operation$State$a r8 = androidx.fragment.app.SpecialEffectsController.Operation.State.INSTANCE
                        androidx.fragment.app.Fragment r9 = r7.getFragment()
                        android.view.View r9 = r9.mView
                        kotlin.jvm.internal.p.h(r9, r5)
                        androidx.fragment.app.SpecialEffectsController$Operation$State r8 = r8.a(r9)
                        androidx.fragment.app.SpecialEffectsController$Operation$State r9 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
                        if (r8 == r9) goto L4f
                        androidx.fragment.app.SpecialEffectsController$Operation$State r7 = r7.getFinalState()
                        if (r7 != r9) goto L4f
                        r4 = r6
                    L76:
                        androidx.fragment.app.SpecialEffectsController$Operation r4 = (androidx.fragment.app.SpecialEffectsController.Operation) r4
                        boolean r0 = androidx.fragment.app.FragmentManager.N0(r0)
                        if (r0 == 0) goto L9a
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "Executing operations from "
                        r0.append(r1)
                        r0.append(r3)
                        java.lang.String r1 = " to "
                        r0.append(r1)
                        r0.append(r4)
                        java.lang.String r0 = r0.toString()
                        android.util.Log.v(r2, r0)
                    L9a:
                        java.util.ArrayList r0 = new java.util.ArrayList
                        r0.<init>()
                        java.util.ArrayList r1 = new java.util.ArrayList
                        r1.<init>()
                        r10.K(r11)
                        java.util.Iterator r11 = r11.iterator()
                    Lab:
                        boolean r2 = r11.hasNext()
                        if (r2 == 0) goto Ldb
                        java.lang.Object r2 = r11.next()
                        androidx.fragment.app.SpecialEffectsController$Operation r2 = (androidx.fragment.app.SpecialEffectsController.Operation) r2
                        androidx.fragment.app.DefaultSpecialEffectsController$b r5 = new androidx.fragment.app.DefaultSpecialEffectsController$b
                        r5.<init>(r2, r12)
                        r0.add(r5)
                        androidx.fragment.app.DefaultSpecialEffectsController$g r5 = new androidx.fragment.app.DefaultSpecialEffectsController$g
                        r6 = 0
                        r7 = 1
                        if (r12 == 0) goto Lc9
                        if (r2 != r3) goto Lcc
                    Lc7:
                        r6 = r7
                        goto Lcc
                    Lc9:
                        if (r2 != r4) goto Lcc
                        goto Lc7
                    Lcc:
                        r5.<init>(r2, r12, r6)
                        r1.add(r5)
                        androidx.fragment.app.b r5 = new androidx.fragment.app.b
                        r5.<init>()
                        r2.a(r5)
                        goto Lab
                    Ldb:
                        r10.H(r1, r12, r3, r4)
                        r10.F(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.d(java.util.List, boolean):void");
                }
            }
