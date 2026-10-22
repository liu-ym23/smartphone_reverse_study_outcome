package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/InspectableValue;", "", "inspectableElements", "Lkotlin/sequences/Sequence;", "Landroidx/compose/ui/platform/ValueElement;", "getInspectableElements", "()Lkotlin/sequences/Sequence;", "nameFallback", "", "getNameFallback", "()Ljava/lang/String;", "valueOverride", "getValueOverride", "()Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface InspectableValue {

    /* JADX INFO: renamed from: androidx.compose.ui.platform.InspectableValue$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getNameFallback(InspectableValue r100) {
            return null;
        }

        public static Object $default$getValueOverride(InspectableValue r100) {
            return null;
        }

        public static Sequence $default$getInspectableElements(InspectableValue r100) {
            return SequencesKt.emptySequence();
        }

        public static /* synthetic */ Sequence access$getInspectableElements$jd(InspectableValue r100) {
            return $default$getInspectableElements(r100);
        }

        public static /* synthetic */ String access$getNameFallback$jd(InspectableValue r100) {
            return $default$getNameFallback(r100);
        }

        public static /* synthetic */ Object access$getValueOverride$jd(InspectableValue r100) {
            return $default$getValueOverride(r100);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Sequence<ValueElement> getInspectableElements(InspectableValue r100) {
            return CC.access$getInspectableElements$jd(r100);
        }

        public static String getNameFallback(InspectableValue r100) {
            return CC.access$getNameFallback$jd(r100);
        }

        public static Object getValueOverride(InspectableValue r100) {
            return CC.access$getValueOverride$jd(r100);
        }
    }

    Sequence<ValueElement> getInspectableElements();

    String getNameFallback();

    Object getValueOverride();
}
