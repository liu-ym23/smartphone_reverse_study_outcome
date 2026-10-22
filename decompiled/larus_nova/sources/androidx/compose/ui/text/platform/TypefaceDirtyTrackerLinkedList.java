package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;", "", "resolveResult", "Landroidx/compose/runtime/State;", TeaEventTrack.ACTION_DRAMA_NEXT, "<init>", "(Landroidx/compose/runtime/State;Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;)V", "initial", "getInitial", "()Ljava/lang/Object;", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "isStaleResolvedFont", "", "()Z", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TypefaceDirtyTrackerLinkedList {
    private final Object initial;
    private final TypefaceDirtyTrackerLinkedList next;
    private final State<Object> resolveResult;

    public final Typeface getTypeface() {
        Object r100 = this.initial;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) r100;
    }

    public final boolean isStaleResolvedFont() {
        if (this.resolveResult.getValue() != this.initial) goto L10;
        TypefaceDirtyTrackerLinkedList r100 = this.next;
        if (r100 != null) goto L7;
    L9:
        return false;
    L7:
        if (r100.isStaleResolvedFont() == false) goto L9;
    L10:
        return true;
    }

    public final Object getInitial() {
        return this.initial;
    }

    public TypefaceDirtyTrackerLinkedList(State<? extends Object> r100, TypefaceDirtyTrackerLinkedList r101) {
        this.resolveResult = r100;
        this.next = r101;
        this.initial = r100.getValue();
    }

    public /* synthetic */ TypefaceDirtyTrackerLinkedList(State r100, TypefaceDirtyTrackerLinkedList r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
