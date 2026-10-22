package androidx.compose.ui;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00132\u00020\u0001:\u0003\u0011\u0012\u0013J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ5\u0010\t\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ\u001c\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\rH&J\u001c\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\rH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "foldIn", "R", "initial", WikiFolderPushPlugin.OPT, "Lkotlin/Function2;", "Landroidx/compose/ui/Modifier$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "any", "", "predicate", "Lkotlin/Function1;", "all", "then", "other", "Element", "Node", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Modifier {
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: androidx.compose.ui.Modifier$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Companion r100 = Modifier.Companion;
        }

        public static Modifier $default$then(Modifier r100, Modifier r101) {
            if (r101 != Modifier.Companion) goto L6;
            return r100;
        L6:
            return new CombinedModifier(r100, r101);
        }

        public static /* synthetic */ Modifier access$then$jd(Modifier r100, Modifier r101) {
            return $default$then(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00052\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00050\bH\u0016¢\u0006\u0002\u0010\nJ5\u0010\u000b\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00052\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\bH\u0016¢\u0006\u0002\u0010\nJ\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\u0011\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0096\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/Modifier$Companion;", "Landroidx/compose/ui/Modifier;", "<init>", "()V", "foldIn", "R", "initial", WikiFolderPushPlugin.OPT, "Lkotlin/Function2;", "Landroidx/compose/ui/Modifier$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "any", "", "predicate", "Lkotlin/Function1;", "all", "then", "other", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements Modifier {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        @Override // androidx.compose.ui.Modifier
        public boolean all(Function1<? super Element, Boolean> r100) {
            return true;
        }

        @Override // androidx.compose.ui.Modifier
        public boolean any(Function1<? super Element, Boolean> r100) {
            return false;
        }

        @Override // androidx.compose.ui.Modifier
        public <R> R foldIn(R r100, Function2<? super R, ? super Element, ? extends R> r101) {
            return r100;
        }

        @Override // androidx.compose.ui.Modifier
        public <R> R foldOut(R r100, Function2<? super Element, ? super R, ? extends R> r101) {
            return r100;
        }

        @Override // androidx.compose.ui.Modifier
        public Modifier then(Modifier r100) {
            return r100;
        }

        public String toString() {
            return "Modifier";
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Modifier then(Modifier r100, Modifier r101) {
            return CC.access$then$jd(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007J5\u0010\b\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\fH\u0016J\u001c\u0010\r\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/Modifier;", "foldIn", "R", "initial", WikiFolderPushPlugin.OPT, "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "any", "", "predicate", "Lkotlin/Function1;", "all", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Element extends Modifier {

        /* JADX INFO: renamed from: androidx.compose.ui.Modifier$Element$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$all(Element r100, Function1 r101) {
                return ((Boolean) r101.invoke(r100)).booleanValue();
            }

            public static boolean $default$any(Element r100, Function1 r101) {
                return ((Boolean) r101.invoke(r100)).booleanValue();
            }

            public static /* synthetic */ boolean access$all$jd(Element r100, Function1 r101) {
                return $default$all(r100, r101);
            }

            public static /* synthetic */ boolean access$any$jd(Element r100, Function1 r101) {
                return $default$any(r100, r101);
            }

            public static /* synthetic */ Modifier access$then$jd(Element r100, Modifier r101) {
                return CC.$default$then(r100, r101);
            }

            public static Object $default$foldIn(Element r100, Object r101, Function2 r102) {
                return r102.invoke(r101, r100);
            }

            public static Object $default$foldOut(Element r100, Object r101, Function2 r102) {
                return r102.invoke(r100, r101);
            }

            public static /* synthetic */ Object access$foldIn$jd(Element r100, Object r101, Function2 r102) {
                return $default$foldIn(r100, r101, r102);
            }

            public static /* synthetic */ Object access$foldOut$jd(Element r100, Object r101, Function2 r102) {
                return $default$foldOut(r100, r101, r102);
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            public static boolean all(Element r100, Function1<? super Element, Boolean> r101) {
                return CC.access$all$jd(r100, r101);
            }

            public static boolean any(Element r100, Function1<? super Element, Boolean> r101) {
                return CC.access$any$jd(r100, r101);
            }

            public static Modifier then(Element r100, Modifier r101) {
                return CC.access$then$jd(r100, r101);
            }

            public static <R> R foldIn(Element r100, R r101, Function2<? super R, ? super Element, ? extends R> r102) {
                return (R) CC.access$foldIn$jd(r100, r101, r102);
            }

            public static <R> R foldOut(Element r100, R r101, Function2<? super Element, ? super R, ? extends R> r102) {
                return (R) CC.access$foldOut$jd(r100, r101, r102);
            }
        }

        @Override // androidx.compose.ui.Modifier
        boolean all(Function1<? super Element, Boolean> r100);

        @Override // androidx.compose.ui.Modifier
        boolean any(Function1<? super Element, Boolean> r100);

        @Override // androidx.compose.ui.Modifier
        <R> R foldIn(R r100, Function2<? super R, ? super Element, ? extends R> r101);

        @Override // androidx.compose.ui.Modifier
        <R> R foldOut(R r100, Function2<? super Element, ? super R, ? extends R> r101);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010>\u001a\u0002052\b\u0010%\u001a\u0004\u0018\u00010$H\u0010¢\u0006\u0002\b?J\u001c\u0010@\u001a\u00020)2\n\u0010A\u001a\u0006\u0012\u0002\b\u00030BH\u0080\b¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u000205H\u0010¢\u0006\u0002\bFJ\r\u0010G\u001a\u000205H\u0010¢\u0006\u0002\bHJ\r\u0010I\u001a\u000205H\u0010¢\u0006\u0002\bJJ\r\u0010K\u001a\u000205H\u0010¢\u0006\u0002\bLJ\r\u0010M\u001a\u000205H\u0010¢\u0006\u0002\bNJ\b\u0010O\u001a\u000205H\u0016J\b\u0010P\u001a\u000205H\u0016J\b\u0010Q\u001a\u000205H\u0016J\u0014\u0010R\u001a\u0002052\f\u0010S\u001a\b\u0012\u0004\u0012\u00020504J\u0015\u0010T\u001a\u0002052\u0006\u0010U\u001a\u00020\u0000H\u0010¢\u0006\u0002\bVR$\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000@BX\u0086\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u0004\u001a\u0004\u0018\u00010$@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u000e\u00101\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020)@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u001a\u0010;\u001a\u00020)8VX\u0096\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0003\u001a\u0004\b=\u0010+¨\u0006W"}, d2 = {"Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "<init>", "()V", "value", "node", "getNode$annotations", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "kindSet", "", "getKindSet$ui_release", "()I", "setKindSet$ui_release", "(I)V", "aggregateChildKindSet", "getAggregateChildKindSet$ui_release", "setAggregateChildKindSet$ui_release", "parent", "getParent$ui_release", "setParent$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "getChild$ui_release", "setChild$ui_release", "ownerScope", "Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "getOwnerScope$ui_release", "()Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "setOwnerScope$ui_release", "(Landroidx/compose/ui/node/ObserverNodeOwnerScope;)V", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "getCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "insertedNodeAwaitingAttachForInvalidation", "", "getInsertedNodeAwaitingAttachForInvalidation$ui_release", "()Z", "setInsertedNodeAwaitingAttachForInvalidation$ui_release", "(Z)V", "updatedNodeAwaitingAttachForInvalidation", "getUpdatedNodeAwaitingAttachForInvalidation$ui_release", "setUpdatedNodeAwaitingAttachForInvalidation$ui_release", "onAttachRunExpected", "onDetachRunExpected", "detachedListener", "Lkotlin/Function0;", "", "getDetachedListener$ui_release", "()Lkotlin/jvm/functions/Function0;", "setDetachedListener$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isAttached", "shouldAutoInvalidate", "getShouldAutoInvalidate$annotations", "getShouldAutoInvalidate", "updateCoordinator", "updateCoordinator$ui_release", "isKind", "kind", "Landroidx/compose/ui/node/NodeKind;", "isKind-H91voCI$ui_release", "(I)Z", "markAsAttached", "markAsAttached$ui_release", "runAttachLifecycle", "runAttachLifecycle$ui_release", "runDetachLifecycle", "runDetachLifecycle$ui_release", "markAsDetached", "markAsDetached$ui_release", BasicTestActionHandler.TEST_ACTION_RESET, "reset$ui_release", "onAttach", "onDetach", "onReset", "sideEffect", "effect", "setAsDelegateTo", "owner", "setAsDelegateTo$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Node implements DelegatableNode {
        public static final int $stable = 8;
        private int aggregateChildKindSet;
        private Node child;
        private NodeCoordinator coordinator;
        private Function0<Unit> detachedListener;
        private boolean insertedNodeAwaitingAttachForInvalidation;
        private boolean isAttached;
        private int kindSet;
        private Node node;
        private boolean onAttachRunExpected;
        private boolean onDetachRunExpected;
        private ObserverNodeOwnerScope ownerScope;
        private Node parent;
        private CoroutineScope scope;
        private boolean updatedNodeAwaitingAttachForInvalidation;

        public static /* synthetic */ void getNode$annotations() {
        }

        public static /* synthetic */ void getShouldAutoInvalidate$annotations() {
        }

        public boolean getShouldAutoInvalidate() {
            return true;
        }

        public void onAttach() {
        }

        @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
        public /* synthetic */ void onDensityChange() {
            DelegatableNode.CC.$default$onDensityChange(this);
        }

        public void onDetach() {
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public /* synthetic */ void onLayoutDirectionChange() {
            DelegatableNode.CC.$default$onLayoutDirectionChange(this);
        }

        public void onReset() {
        }

        public final CoroutineScope getCoroutineScope() {
            CoroutineScope r100 = this.scope;
            if (r100 != null) goto L6;
            CoroutineScope r101 = CoroutineScopeKt.CoroutineScope(DelegatableNodeKt.requireOwner(this).getCoroutineContext().plus(JobKt.Job((Job) DelegatableNodeKt.requireOwner(this).getCoroutineContext().get(Job.Key))));
            this.scope = r101;
            return r101;
        L6:
            return r100;
        }

        public void markAsAttached$ui_release() {
            if ((!this.isAttached) == true) goto L6;
            InlineClassHelperKt.throwIllegalStateException("node attached multiple times");
        L6:
            if (this.coordinator == null) goto L8;
            boolean r100 = true;
        L9:
            if (r100 == true) goto L11;
            InlineClassHelperKt.throwIllegalStateException("attach invoked on a node without a coordinator");
        L11:
            this.isAttached = true;
            this.onAttachRunExpected = true;
            return;
        L8:
            r100 = false;
            goto L9
        }

        public void markAsDetached$ui_release() {
            if (this.isAttached == true) goto L6;
            InlineClassHelperKt.throwIllegalStateException("Cannot detach a node that is not attached");
        L6:
            if ((!this.onAttachRunExpected) == true) goto L9;
            InlineClassHelperKt.throwIllegalStateException("Must run runAttachLifecycle() before markAsDetached()");
        L9:
            if ((!this.onDetachRunExpected) == true) goto L11;
            InlineClassHelperKt.throwIllegalStateException("Must run runDetachLifecycle() before markAsDetached()");
        L11:
            this.isAttached = false;
            CoroutineScope r100 = this.scope;
            if (r100 == null) goto L15;
            CoroutineScopeKt.cancel(r100, new ModifierNodeDetachedCancellationException());
            this.scope = null;
            return;
        }

        public void reset$ui_release() {
            if (this.isAttached == true) goto L5;
            InlineClassHelperKt.throwIllegalStateException("reset() called on an unattached node");
        L5:
            onReset();
        }

        public void runAttachLifecycle$ui_release() {
            if (this.isAttached == true) goto L6;
            InlineClassHelperKt.throwIllegalStateException("Must run markAsAttached() prior to runAttachLifecycle");
        L6:
            if (this.onAttachRunExpected == true) goto L8;
            InlineClassHelperKt.throwIllegalStateException("Must run runAttachLifecycle() only once after markAsAttached()");
        L8:
            this.onAttachRunExpected = false;
            onAttach();
            this.onDetachRunExpected = true;
        }

        public void runDetachLifecycle$ui_release() {
            if (this.isAttached == true) goto L6;
            InlineClassHelperKt.throwIllegalStateException("node detached multiple times");
        L6:
            if (this.coordinator == null) goto L8;
            boolean r100 = true;
        L9:
            if (r100 == true) goto L12;
            InlineClassHelperKt.throwIllegalStateException("detach invoked on a node without a coordinator");
        L12:
            if (this.onDetachRunExpected == true) goto L14;
            InlineClassHelperKt.throwIllegalStateException("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
        L14:
            this.onDetachRunExpected = false;
            Function0<Unit> r101 = this.detachedListener;
            if (r101 == null) goto L17;
            r101.invoke();
        L17:
            onDetach();
            return;
        L8:
            r100 = false;
            goto L9
        }

        public Node() {
            this.node = this;
            this.aggregateChildKindSet = -1;
        }

        public final int getAggregateChildKindSet$ui_release() {
            return this.aggregateChildKindSet;
        }

        public final Node getChild$ui_release() {
            return this.child;
        }

        public final NodeCoordinator getCoordinator$ui_release() {
            return this.coordinator;
        }

        public final Function0<Unit> getDetachedListener$ui_release() {
            return this.detachedListener;
        }

        public final boolean getInsertedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.insertedNodeAwaitingAttachForInvalidation;
        }

        public final int getKindSet$ui_release() {
            return this.kindSet;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final Node getNode() {
            return this.node;
        }

        public final ObserverNodeOwnerScope getOwnerScope$ui_release() {
            return this.ownerScope;
        }

        public final Node getParent$ui_release() {
            return this.parent;
        }

        public final boolean getUpdatedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.updatedNodeAwaitingAttachForInvalidation;
        }

        public final boolean isAttached() {
            return this.isAttached;
        }

        /* JADX INFO: renamed from: isKind-H91voCI$ui_release, reason: not valid java name */
        public final boolean m4317isKindH91voCI$ui_release(int r100) {
            if ((r100 & getKindSet$ui_release()) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final void setAggregateChildKindSet$ui_release(int r100) {
            this.aggregateChildKindSet = r100;
        }

        public void setAsDelegateTo$ui_release(Node r100) {
            this.node = r100;
        }

        public final void setChild$ui_release(Node r100) {
            this.child = r100;
        }

        public final void setDetachedListener$ui_release(Function0<Unit> r100) {
            this.detachedListener = r100;
        }

        public final void setInsertedNodeAwaitingAttachForInvalidation$ui_release(boolean r100) {
            this.insertedNodeAwaitingAttachForInvalidation = r100;
        }

        public final void setKindSet$ui_release(int r100) {
            this.kindSet = r100;
        }

        public final void setOwnerScope$ui_release(ObserverNodeOwnerScope r100) {
            this.ownerScope = r100;
        }

        public final void setParent$ui_release(Node r100) {
            this.parent = r100;
        }

        public final void setUpdatedNodeAwaitingAttachForInvalidation$ui_release(boolean r100) {
            this.updatedNodeAwaitingAttachForInvalidation = r100;
        }

        public final void sideEffect(Function0<Unit> r100) {
            DelegatableNodeKt.requireOwner(this).registerOnEndApplyChangesListener(r100);
        }

        public void updateCoordinator$ui_release(NodeCoordinator r100) {
            this.coordinator = r100;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean all(Function1<? super Element, Boolean> r100);

    boolean any(Function1<? super Element, Boolean> r100);

    <R> R foldIn(R r100, Function2<? super R, ? super Element, ? extends R> r101);

    <R> R foldOut(R r100, Function2<? super Element, ? super R, ? extends R> r101);

    Modifier then(Modifier r100);
}
