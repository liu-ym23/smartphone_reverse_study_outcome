package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0001H\u0000¨\u0006\u0004"}, d2 = {"unbox", "Landroidx/compose/ui/text/AnnotatedString$Range;", "", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StringAnnotationKt {
    public static final AnnotatedString.Range<String> unbox(AnnotatedString.Range<? extends AnnotatedString.Annotation> r100) {
        AnnotatedString.Annotation r101 = r100.getItem();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.ui.text.StringAnnotation");
        return new AnnotatedString.Range(((StringAnnotation) r101).m6952unboximpl(), r100.getStart(), r100.getEnd(), r100.getTag());
    }
}
