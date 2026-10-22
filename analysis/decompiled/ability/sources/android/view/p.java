package android.view;

import S7.k;
import android.content.res.Resources;
import android.view.SystemBarStyle;
import androidx.appfunctions.AppFunctionSearchSpec;
import androidx.compose.runtime.snapshots.GlobalSnapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.MultiParagraphKt;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.Savers_androidKt;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1680a;

    public /* synthetic */ p(int i) {
        this.f1680a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1680a) {
            case 0:
                return Boolean.valueOf(SystemBarStyle.Companion.dark$lambda$1((Resources) obj));
            case 1:
                return Boolean.valueOf(SystemBarStyle.Companion.auto$lambda$0((Resources) obj));
            case 2:
                return AppFunctionSearchSpec.getOrQueryExpression$lambda$0((String) obj);
            case 3:
                return GlobalSnapshot._init_$lambda$2(obj);
            case 4:
                return SnapshotKt.emptyLambda$lambda$1((SnapshotIdSet) obj);
            case 5:
                return Boolean.valueOf(AnnotatedStringKt.substringWithoutParagraphStyles$lambda$10((AnnotatedString.Annotation) obj));
            case 6:
                return MultiParagraphKt.findParagraphByIndex$lambda$3$lambda$2((ParagraphInfo) obj);
            case 7:
                return SaversKt.TextLinkStylesSaver$lambda$26(obj);
            case 8:
                return SaversKt.AnnotatedStringSaver$lambda$6(obj);
            case 9:
                return SaversKt.TextDecorationSaver$lambda$28(obj);
            case 10:
                return SaversKt.TextGeometricTransformSaver$lambda$30(obj);
            case 11:
                return SaversKt.TextIndentSaver$lambda$32(obj);
            case 12:
                return SaversKt.FontWeightSaver$lambda$34(obj);
            case 13:
                return SaversKt.BaselineShiftSaver$lambda$36(obj);
            case 14:
                return SaversKt.TextRangeSaver$lambda$38(obj);
            case 15:
                return SaversKt.ShadowSaver$lambda$40(obj);
            case 16:
                return SaversKt.TextUnitSaver$lambda$42(obj);
            case 17:
                return SaversKt.LinkSaver$lambda$18(obj);
            case 18:
                return SaversKt.OffsetSaver$lambda$44(obj);
            case 19:
                return SaversKt.LocaleListSaver$lambda$48(obj);
            case 20:
                return SaversKt.AnnotationRangeListSaver$lambda$10(obj);
            case 21:
                return SaversKt.LocaleSaver$lambda$50(obj);
            case 22:
                return SaversKt.LineHeightStyleSaver$lambda$52(obj);
            case 23:
                return SaversKt.AnnotationRangeSaver$lambda$12(obj);
            case 24:
                return SaversKt.VerbatimTtsAnnotationSaver$lambda$14(obj);
            case 25:
                return SaversKt.UrlAnnotationSaver$lambda$16(obj);
            case 26:
                return SaversKt.ClickableSaver$lambda$20(obj);
            case 27:
                return SaversKt.ParagraphStyleSaver$lambda$22(obj);
            case 28:
                return SaversKt.SpanStyleSaver$lambda$24(obj);
            default:
                return Savers_androidKt.PlatformParagraphStyleSaver$lambda$1(obj);
        }
    }
}
