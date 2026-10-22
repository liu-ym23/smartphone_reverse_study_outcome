package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.TwoDimensionalFocusSearchKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 02\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JM\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0012j\b\u0012\u0004\u0012\u00020\u0006`\u0013H\u0002¢\u0006\u0004\b\u0010\u0010\u0015JC\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0012j\b\u0012\u0004\u0012\u00020\u0006`\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u001aJK\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0012j\b\u0012\u0004\u0012\u00020\u0006`\u00132\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ;\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0012j\b\u0012\u0004\u0012\u00020\u0006`\u00132\u0006\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010 J;\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0012j\b\u0012\u0004\u0012\u00020\u0006`\u00132\u0006\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010%J'\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\rJ'\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b&\u0010\u0011R\u0014\u0010'\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0012j\b\u0012\u0004\u0012\u00020\u0006`\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/ViewGroup;", "root", "Landroid/view/View;", "focused", "getEffectiveRoot", "(Landroid/view/ViewGroup;Landroid/view/View;)Landroid/view/ViewGroup;", "", "direction", "findNextUserSpecifiedFocus", "(Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;", "Landroid/graphics/Rect;", "focusedRect", "findNextFocus", "(Landroid/view/ViewGroup;Landroid/graphics/Rect;I)Landroid/view/View;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "focusables", "(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;ILjava/util/ArrayList;)Landroid/view/View;", "findNextFocusInRelativeDirection", "(Ljava/util/ArrayList;Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;", "LC7/r;", "setFocusBottomRight", "(Landroid/view/ViewGroup;Landroid/graphics/Rect;)V", "setFocusTopLeft", "findNextFocusInAbsoluteDirection", "(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;Ljava/util/ArrayList;I)Landroid/view/View;", "count", "getNextFocusable", "(Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;", "getPreviousFocusable", "id", "", "isValidId", "(I)Z", "findNextFocusFromRect", "cachedFocusedRect", "Landroid/graphics/Rect;", "bestCandidateRect", "otherRect", "Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator;", "userSpecifiedFocusComparator", "Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator;", "tmpList", "Ljava/util/ArrayList;", "Companion", "UserSpecifiedFocusComparator", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusFinderCompat {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final FocusFinderCompat$Companion$FocusFinderThreadLocal$1 FocusFinderThreadLocal = new ThreadLocal<FocusFinderCompat>() { // from class: androidx.compose.ui.platform.FocusFinderCompat$Companion$FocusFinderThreadLocal$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public FocusFinderCompat initialValue() {
            return new FocusFinderCompat();
        }
    };
    private final Rect cachedFocusedRect = new Rect();
    private final Rect bestCandidateRect = new Rect();
    private final Rect otherRect = new Rect();
    private final UserSpecifiedFocusComparator userSpecifiedFocusComparator = new UserSpecifiedFocusComparator(new UserSpecifiedFocusComparator.NextFocusGetter() { // from class: androidx.compose.ui.platform.j
        @Override // androidx.compose.ui.platform.FocusFinderCompat.UserSpecifiedFocusComparator.NextFocusGetter
        public final View get(View view, View view2) {
            return FocusFinderCompat.userSpecifiedFocusComparator$lambda$0(this.f1892a, view, view2);
        }
    });
    private final ArrayList<View> tmpList = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat$Companion;", "", AppAgent.CONSTRUCT, "()V", "FocusFinderThreadLocal", "androidx/compose/ui/platform/FocusFinderCompat$Companion$FocusFinderThreadLocal$1", "Landroidx/compose/ui/platform/FocusFinderCompat$Companion$FocusFinderThreadLocal$1;", "instance", "Landroidx/compose/ui/platform/FocusFinderCompat;", "getInstance", "()Landroidx/compose/ui/platform/FocusFinderCompat;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final FocusFinderCompat getInstance() {
            FocusFinderCompat focusFinderCompat = FocusFinderCompat.FocusFinderThreadLocal.get();
            kotlin.jvm.internal.k.c(focusFinderCompat);
            return focusFinderCompat;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0003:\u0001%B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000f\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000bj\b\u0012\u0004\u0012\u00020\u0002`\f2\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001cR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010$¨\u0006&"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator;", "Ljava/util/Comparator;", "Landroid/view/View;", "Lkotlin/Comparator;", "Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;", "mNextFocusGetter", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;)V", "LC7/r;", "recycle", "()V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "focusables", "root", "setFocusables", "(Ljava/util/ArrayList;Landroid/view/View;)V", "head", "setHeadOfChain", "(Landroid/view/View;)V", "first", "second", "", "compare", "(Landroid/view/View;Landroid/view/View;)I", "Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;", "Landroidx/collection/MutableScatterMap;", "nextFoci", "Landroidx/collection/MutableScatterMap;", "Landroidx/collection/MutableScatterSet;", "isConnectedTo", "Landroidx/collection/MutableScatterSet;", "headsOfChains", "Landroidx/collection/MutableObjectIntMap;", "originalOrdinal", "Landroidx/collection/MutableObjectIntMap;", "Landroid/view/View;", "NextFocusGetter", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UserSpecifiedFocusComparator implements Comparator<View> {
        private final NextFocusGetter mNextFocusGetter;
        private View root;
        private final MutableScatterMap<View, View> nextFoci = ScatterMapKt.mutableScatterMapOf();
        private final MutableScatterSet<View> isConnectedTo = ScatterSetKt.mutableScatterSetOf();
        private final MutableScatterMap<View, View> headsOfChains = ScatterMapKt.mutableScatterMapOf();
        private final MutableObjectIntMap<View> originalOrdinal = ObjectIntMapKt.mutableObjectIntMapOf();

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;", "", "get", "Landroid/view/View;", "root", "view", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public interface NextFocusGetter {
            View get(View root, View view);
        }

        public UserSpecifiedFocusComparator(NextFocusGetter nextFocusGetter) {
            this.mNextFocusGetter = nextFocusGetter;
        }

        public final void recycle() {
            this.root = null;
            this.headsOfChains.clear();
            this.isConnectedTo.clear();
            this.originalOrdinal.clear();
            this.nextFoci.clear();
        }

        public final void setFocusables(ArrayList<View> focusables, View root) {
            this.root = root;
            int size = focusables.size();
            for (int i = 0; i < size; i++) {
                this.originalOrdinal.set(focusables.get(i), i);
            }
            int size2 = focusables.size() - 1;
            if (size2 >= 0) {
                while (true) {
                    int i6 = size2 - 1;
                    View view = focusables.get(size2);
                    View view2 = this.mNextFocusGetter.get(root, view);
                    if (view2 != null && this.originalOrdinal.containsKey(view2)) {
                        this.nextFoci.set(view, view2);
                        this.isConnectedTo.add(view2);
                    }
                    if (i6 < 0) {
                        break;
                    } else {
                        size2 = i6;
                    }
                }
            }
            int size3 = focusables.size() - 1;
            if (size3 < 0) {
                return;
            }
            while (true) {
                int i10 = size3 - 1;
                View view3 = focusables.get(size3);
                if (this.nextFoci.get(view3) != null && !this.isConnectedTo.contains(view3)) {
                    setHeadOfChain(view3);
                }
                if (i10 < 0) {
                    return;
                } else {
                    size3 = i10;
                }
            }
        }

        public final void setHeadOfChain(View head) {
            View view = head;
            while (head != null) {
                View view2 = this.headsOfChains.get(head);
                if (view2 != null) {
                    if (view2 == view) {
                        return;
                    }
                    head = view;
                    view = view2;
                }
                this.headsOfChains.set(head, view);
                head = this.nextFoci.get(head);
            }
        }

        @Override // java.util.Comparator
        public int compare(View first, View second) {
            if (first == second) {
                return 0;
            }
            if (first == null) {
                return -1;
            }
            if (second == null) {
                return 1;
            }
            View view = this.headsOfChains.get(first);
            View view2 = this.headsOfChains.get(second);
            if (view == view2 && view != null) {
                if (first == view) {
                    return -1;
                }
                return (second == view || this.nextFoci.get(first) == null) ? 1 : -1;
            }
            if (view != null) {
                first = view;
            }
            if (view2 != null) {
                second = view2;
            }
            if (view == null && view2 == null) {
                return 0;
            }
            return this.originalOrdinal.get(first) < this.originalOrdinal.get(second) ? -1 : 1;
        }
    }

    private final View findNextFocusInAbsoluteDirection(ViewGroup root, View focused, Rect focusedRect, ArrayList<View> focusables, int direction) {
        this.bestCandidateRect.set(focusedRect);
        if (direction == 17) {
            this.bestCandidateRect.offset(focusedRect.width() + 1, 0);
        } else if (direction == 33) {
            this.bestCandidateRect.offset(0, focusedRect.height() + 1);
        } else if (direction == 66) {
            this.bestCandidateRect.offset((-focusedRect.width()) - 1, 0);
        } else if (direction == 130) {
            this.bestCandidateRect.offset(0, (-focusedRect.height()) - 1);
        }
        int size = focusables.size();
        View view = null;
        for (int i = 0; i < size; i++) {
            View view2 = focusables.get(i);
            if (!kotlin.jvm.internal.k.b(view2, focused) && !kotlin.jvm.internal.k.b(view2, root)) {
                view2.getFocusedRect(this.otherRect);
                root.offsetDescendantRectToMyCoords(view2, this.otherRect);
                androidx.compose.ui.geometry.Rect composeRect = RectHelper_androidKt.toComposeRect(this.otherRect);
                androidx.compose.ui.geometry.Rect composeRect2 = RectHelper_androidKt.toComposeRect(this.bestCandidateRect);
                androidx.compose.ui.geometry.Rect composeRect3 = RectHelper_androidKt.toComposeRect(focusedRect);
                FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
                if (TwoDimensionalFocusSearchKt.m3843isBetterCandidateI7lrPNg(composeRect, composeRect2, composeRect3, focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m3779getNextdhqQ8s())) {
                    this.bestCandidateRect.set(this.otherRect);
                    view = view2;
                }
            }
        }
        return view;
    }

    @SuppressLint({"AsCollectionCall"})
    private final View findNextFocusInRelativeDirection(ArrayList<View> focusables, ViewGroup root, View focused, int direction) {
        ArrayList<View> arrayList;
        try {
            this.userSpecifiedFocusComparator.setFocusables(focusables, root);
            Collections.sort(focusables, this.userSpecifiedFocusComparator);
            this.userSpecifiedFocusComparator.recycle();
            int size = focusables.size();
            View previousFocusable = null;
            if (size < 2) {
                return null;
            }
            if (direction == 1) {
                arrayList = focusables;
                previousFocusable = getPreviousFocusable(focused, arrayList, size);
            } else if (direction == 2) {
                arrayList = focusables;
                previousFocusable = getNextFocusable(focused, arrayList, size);
            } else if (direction == 17 || direction == 33 || direction == 66 || direction == 130) {
                arrayList = focusables;
                previousFocusable = findNextFocusInAbsoluteDirection(root, focused, this.cachedFocusedRect, arrayList, direction);
            } else {
                arrayList = focusables;
            }
            return previousFocusable == null ? arrayList.get(size - 1) : previousFocusable;
        } catch (Throwable th) {
            this.userSpecifiedFocusComparator.recycle();
            throw th;
        }
    }

    private final View findNextUserSpecifiedFocus(ViewGroup root, View focused, int direction) {
        View viewFindUserSetNextFocus = FocusFinderCompat_androidKt.findUserSetNextFocus(focused, root, direction);
        boolean z10 = true;
        View viewFindUserSetNextFocus2 = viewFindUserSetNextFocus;
        while (viewFindUserSetNextFocus != null) {
            if (viewFindUserSetNextFocus.isFocusable() && viewFindUserSetNextFocus.getVisibility() == 0 && (!viewFindUserSetNextFocus.isInTouchMode() || viewFindUserSetNextFocus.isFocusableInTouchMode())) {
                return viewFindUserSetNextFocus;
            }
            viewFindUserSetNextFocus = FocusFinderCompat_androidKt.findUserSetNextFocus(viewFindUserSetNextFocus, root, direction);
            boolean z11 = !z10;
            if (!z10) {
                viewFindUserSetNextFocus2 = viewFindUserSetNextFocus2 != null ? FocusFinderCompat_androidKt.findUserSetNextFocus(viewFindUserSetNextFocus2, root, direction) : null;
                if (viewFindUserSetNextFocus2 == viewFindUserSetNextFocus) {
                    break;
                }
            }
            z10 = z11;
        }
        return null;
    }

    private final ViewGroup getEffectiveRoot(ViewGroup root, View focused) {
        if (focused != null && focused != root) {
            ViewParent parent = focused.getParent();
            ViewGroup viewGroup = null;
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    break;
                }
                if (parent == root) {
                    if (viewGroup == null) {
                        break;
                    }
                    return viewGroup;
                }
                ViewGroup viewGroup2 = (ViewGroup) parent;
                if (viewGroup2.getTouchscreenBlocksFocus() && focused.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
                    viewGroup = viewGroup2;
                }
                parent = viewGroup2.getParent();
            }
        }
        return root;
    }

    private final View getNextFocusable(View focused, ArrayList<View> focusables, int count) {
        int iLastIndexOf;
        int i;
        if (count < 2) {
            return null;
        }
        return (focused == null || (iLastIndexOf = focusables.lastIndexOf(focused)) < 0 || (i = iLastIndexOf + 1) >= count) ? focusables.get(0) : focusables.get(i);
    }

    private final View getPreviousFocusable(View focused, ArrayList<View> focusables, int count) {
        int iIndexOf;
        if (count < 2) {
            return null;
        }
        return (focused == null || (iIndexOf = focusables.indexOf(focused)) <= 0) ? focusables.get(count - 1) : focusables.get(iIndexOf - 1);
    }

    private final boolean isValidId(int id) {
        return (id == 0 || id == -1) ? false : true;
    }

    private final void setFocusBottomRight(ViewGroup root, Rect focusedRect) {
        int height = root.getHeight() + root.getScrollY();
        int width = root.getWidth() + root.getScrollX();
        focusedRect.set(width, height, width, height);
    }

    private final void setFocusTopLeft(ViewGroup root, Rect focusedRect) {
        int scrollY = root.getScrollY();
        int scrollX = root.getScrollX();
        focusedRect.set(scrollX, scrollY, scrollX, scrollY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View userSpecifiedFocusComparator$lambda$0(FocusFinderCompat focusFinderCompat, View view, View view2) {
        if (focusFinderCompat.isValidId(view2.getNextFocusForwardId())) {
            return FocusFinderCompat_androidKt.findUserSetNextFocus(view2, view, 2);
        }
        return null;
    }

    public final View findNextFocus(ViewGroup root, View focused, int direction) {
        ViewGroup effectiveRoot = getEffectiveRoot(root, focused);
        View viewFindNextUserSpecifiedFocus = findNextUserSpecifiedFocus(effectiveRoot, focused, direction);
        if (viewFindNextUserSpecifiedFocus != null) {
            return viewFindNextUserSpecifiedFocus;
        }
        ArrayList<View> arrayList = this.tmpList;
        try {
            arrayList.clear();
            FocusFinderCompat_androidKt.addFocusableViews(effectiveRoot, (ArrayList<View>) arrayList, direction);
            if (!arrayList.isEmpty()) {
                viewFindNextUserSpecifiedFocus = findNextFocus(effectiveRoot, focused, null, direction, arrayList);
            }
            arrayList.clear();
            return viewFindNextUserSpecifiedFocus;
        } catch (Throwable th) {
            arrayList.clear();
            throw th;
        }
    }

    public final View findNextFocusFromRect(ViewGroup root, Rect focusedRect, int direction) {
        this.cachedFocusedRect.set(focusedRect);
        return findNextFocus(root, this.cachedFocusedRect, direction);
    }

    private final View findNextFocus(ViewGroup root, Rect focusedRect, int direction) {
        ViewGroup effectiveRoot = getEffectiveRoot(root, null);
        ArrayList<View> arrayList = this.tmpList;
        try {
            arrayList.clear();
            FocusFinderCompat_androidKt.addFocusableViews(effectiveRoot, (ArrayList<View>) arrayList, direction);
            if (arrayList.isEmpty()) {
                arrayList.clear();
                return null;
            }
            View viewFindNextFocus = findNextFocus(effectiveRoot, null, focusedRect, direction, arrayList);
            arrayList.clear();
            return viewFindNextFocus;
        } catch (Throwable th) {
            arrayList.clear();
            throw th;
        }
    }

    private final View findNextFocus(ViewGroup root, View focused, Rect focusedRect, int direction, ArrayList<View> focusables) {
        Rect rect = this.cachedFocusedRect;
        if (focused != null) {
            focused.getFocusedRect(rect);
            root.offsetDescendantRectToMyCoords(focused, rect);
        } else if (focusedRect != null) {
            rect.set(focusedRect);
        } else if (direction != 1) {
            if (direction != 2) {
                if (direction == 17 || direction == 33) {
                    setFocusBottomRight(root, rect);
                } else if (direction == 66 || direction == 130) {
                    setFocusTopLeft(root, rect);
                }
            } else if (root.getLayoutDirection() == 1) {
                setFocusBottomRight(root, rect);
            } else {
                setFocusTopLeft(root, rect);
            }
        } else if (root.getLayoutDirection() == 1) {
            setFocusTopLeft(root, rect);
        } else {
            setFocusBottomRight(root, rect);
        }
        if (direction == 1 || direction == 2) {
            return findNextFocusInRelativeDirection(focusables, root, focused, direction);
        }
        if (direction != 17 && direction != 33 && direction != 66 && direction != 130) {
            throw new IllegalArgumentException(B7.a.h(direction, "Unknown direction: "));
        }
        return findNextFocusInAbsoluteDirection(root, focused, rect, focusables, direction);
    }
}
