package androidx.compose.ui.text;

import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 D2\u00020\u0001:\u0005@ABCDB)\b\u0000\u0012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB=\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u0003\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u0003¢\u0006\u0004\b\b\u0010\u000eB)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\b\u0010\u000fJ\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bH\u0096\u0002J\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001bH\u0016J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0011\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0000H\u0087\u0002J*\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bJ\u001e\u0010.\u001a\u00020/2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bJ\"\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bJ\"\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00040\u00032\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bJ$\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00040\u00032\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bH\u0007J\"\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u00040\u00032\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bJ\u0016\u00106\u001a\u00020/2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bJ\u0013\u00107\u001a\u00020/2\b\u0010)\u001a\u0004\u0018\u000108H\u0096\u0002J\b\u00109\u001a\u00020\u001bH\u0016J\b\u0010:\u001a\u00020\u0007H\u0016J\u000e\u0010;\u001a\u00020/2\u0006\u0010)\u001a\u00020\u0000J*\u0010<\u001a\u00020\u00002\"\u0010=\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040>J0\u0010?\u001a\u00020\u00002(\u0010=\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u00030>R$\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\"\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006E"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString;", "", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "text", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "spanStyles", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/util/List;)V", "getAnnotations$ui_text", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "spanStylesOrNull", "getSpanStylesOrNull$ui_text", "getSpanStyles", "paragraphStylesOrNull", "getParagraphStylesOrNull$ui_text", "getParagraphStyles", "length", "", "getLength", "()I", MonitorConstants.CONNECT_TYPE_GET, "", "index", "subSequence", "startIndex", "endIndex", FilterData.FilterOptionItem.Type.RANGE, "Landroidx/compose/ui/text/TextRange;", "subSequence-5zc-tL8", "(J)Landroidx/compose/ui/text/AnnotatedString;", "plus", "other", "getStringAnnotations", "tag", "start", "end", "hasStringAnnotations", "", "getTtsAnnotations", "Landroidx/compose/ui/text/TtsAnnotation;", "getUrlAnnotations", "Landroidx/compose/ui/text/UrlAnnotation;", "getLinkAnnotations", "Landroidx/compose/ui/text/LinkAnnotation;", "hasLinkAnnotations", "equals", "", "hashCode", "toString", "hasEqualAnnotations", "mapAnnotations", "transform", "Lkotlin/Function1;", "flatMapAnnotations", "Range", "Builder", "Annotation", "ExhaustiveAnnotation", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnnotatedString implements CharSequence {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<AnnotatedString, ?> Saver = null;
    private final List<Range<? extends Annotation>> annotations;
    private final List<Range<ParagraphStyle>> paragraphStylesOrNull;
    private final List<Range<SpanStyle>> spanStylesOrNull;
    private final String text;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\b\u0002\u0003\u0004\u0005\u0006\u0007\b\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Annotation;", "", "Landroidx/compose/ui/text/AnnotatedString$ExhaustiveAnnotation;", "Landroidx/compose/ui/text/Bullet;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/ui/text/ParagraphStyle;", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/StringAnnotation;", "Landroidx/compose/ui/text/TtsAnnotation;", "Landroidx/compose/ui/text/UrlAnnotation;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Annotation {
    }

    @Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002UVB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bJ\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\b\u0017J\u0012\u0010\u0017\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010\u0017\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\nJ\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J&\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J \u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\u001e\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u0010,\u001a\u00020\u00182\u0006\u0010/\u001a\u0002002\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J-\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b6\u00107J\u000e\u00108\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!J\u000e\u00108\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\"J\u000e\u00109\u001a\u00020\u00042\u0006\u00102\u001a\u000203JD\u0010<\u001a\u0002H=\"\b\b\u0000\u0010=*\u00020\u00112\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00102\u001a\u0002032\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u0002H=0?¢\u0006\u0002\b@¢\u0006\u0004\bA\u0010BJ>\u0010C\u001a\u0002H=\"\b\b\u0000\u0010=*\u00020\u0011*\u00020;2\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H=0?¢\u0006\u0002\b@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bJ\u000e\u0010F\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+H\u0007J\u000e\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020\u0018J\u000e\u0010K\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u0004J\u0006\u0010M\u001a\u00020\nJ1\u0010N\u001a\u00020\u00182\"\u0010O\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130P\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130P0?H\u0000¢\u0006\u0002\bQJ7\u0010R\u001a\u00020\u00182(\u0010O\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130P\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130P0S0?H\u0000¢\u0006\u0002\bTR\u0012\u0010\u0007\u001a\u00060\fj\u0002`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "capacity", "", "<init>", "(I)V", "text", "", "(Ljava/lang/String;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "styleStack", "", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "", "annotations", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "length", "getLength", "()I", "append", "", "deprecated_append_returning_void", "char", "", "", "start", "end", "addStyle", "style", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/ParagraphStyle;", "addStringAnnotation", "tag", "annotation", "addTtsAnnotation", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "addUrlAnnotation", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "addLink", "url", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "clickable", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "addBullet", "bullet", "Landroidx/compose/ui/text/Bullet;", "indentation", "Landroidx/compose/ui/unit/TextUnit;", "addBullet-r9BaKPg", "(Landroidx/compose/ui/text/Bullet;JII)V", "pushStyle", "pushBullet", "bulletScope", "Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;", "withBulletList", "R", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "withBulletList-o2QH7mI", "(JLandroidx/compose/ui/text/Bullet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withBulletListItem", "(Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;Landroidx/compose/ui/text/Bullet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "pushStringAnnotation", "pushTtsAnnotation", "pushUrlAnnotation", "pushLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "pop", "index", "toAnnotatedString", "mapAnnotations", "transform", "Landroidx/compose/ui/text/AnnotatedString$Range;", "mapAnnotations$ui_text", "flatMapAnnotations", "", "flatMapAnnotations$ui_text", "MutableRange", "BulletScope", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder implements Appendable {
        public static final int $stable = 8;
        private final List<MutableRange<? extends Annotation>> annotations;
        private final BulletScope bulletScope;
        private final List<MutableRange<? extends Object>> styleStack;
        private final StringBuilder text;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;", "", "builder", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString$Builder;)V", "getBuilder$ui_text", "()Landroidx/compose/ui/text/AnnotatedString$Builder;", "bulletListSettingStack", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/text/Bullet;", "getBulletListSettingStack$ui_text", "()Ljava/util/List;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class BulletScope {
            public static final int $stable = 8;
            private final Builder builder;
            private final List<Pair<TextUnit, Bullet>> bulletListSettingStack;

            public final Builder getBuilder$ui_text() {
                return this.builder;
            }

            public final List<Pair<TextUnit, Bullet>> getBulletListSettingStack$ui_text() {
                return this.bulletListSettingStack;
            }

            public BulletScope(Builder r100) {
                this.builder = r100;
                this.bulletListSettingStack = new ArrayList();
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u0000 &*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001&B+\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0005J0\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J<\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", ExifInterface.GPS_DIRECTION_TRUE, "", MapController.ITEM_LAYER_TAG, "start", "", "end", "tag", "", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "()I", "getEnd", "setEnd", "(I)V", "getTag", "()Ljava/lang/String;", "toRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "defaultEnd", "R", "transform", "Lkotlin/Function1;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "equals", "", "other", "hashCode", "toString", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MutableRange<T> {
            public static final Companion Companion = null;
            private int end;
            private final T item;
            private final int start;
            private final String tag;

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange$Companion;", "", "<init>", "()V", "fromRange", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", ExifInterface.GPS_DIRECTION_TRUE, FilterData.FilterOptionItem.Type.RANGE, "Landroidx/compose/ui/text/AnnotatedString$Range;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                    this();
                }

                public final <T> MutableRange<T> fromRange(Range<T> r100) {
                    return new MutableRange(r100.getItem(), r100.getStart(), r100.getEnd(), r100.getTag());
                }
            }

            static {
                Companion = new Companion(null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MutableRange copy$default(MutableRange r100, Object r101, int r102, int r103, String r104, int r105, Object r106) {
                if ((r105 & 1) == 0) goto L6;
                r101 = r100.item;
            L6:
                if ((r105 & 2) == 0) goto L9;
                r102 = r100.start;
            L9:
                if ((r105 & 4) == 0) goto L12;
                r103 = r100.end;
            L12:
                if ((r105 & 8) == 0) goto L15;
                r104 = r100.tag;
            L15:
                return r100.copy(r101, r102, r103, r104);
            }

            public final T component1() {
                return this.item;
            }

            public final int component2() {
                return this.start;
            }

            public final int component3() {
                return this.end;
            }

            public final String component4() {
                return this.tag;
            }

            public final MutableRange<T> copy(T r100, int r101, int r102, String r103) {
                return new MutableRange(r100, r101, r102, r103);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof MutableRange) == true) goto L8;
                return false;
            L8:
                MutableRange r101 = (MutableRange) r100;
                if (Intrinsics.areEqual(this.item, r101.item) == true) goto L12;
                return false;
            L12:
                if (this.start == r101.start) goto L15;
                return false;
            L15:
                if (this.end == r101.end) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                T r100 = this.item;
                if (r100 != null) goto L5;
                int r101 = 0;
            L7:
                return (((((r101 * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
            L5:
                r101 = r100.hashCode();
                goto L7
            }

            public String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
            }

            public final int getEnd() {
                return this.end;
            }

            public final T getItem() {
                return this.item;
            }

            public final int getStart() {
                return this.start;
            }

            public final String getTag() {
                return this.tag;
            }

            public final void setEnd(int r100) {
                this.end = r100;
            }

            public final Range<T> toRange(int r100) {
                int r101 = this.end;
                if (r101 == Integer.MIN_VALUE) goto L6;
                r100 = r101;
            L6:
                if (r100 == Integer.MIN_VALUE) goto L8;
                boolean r102 = true;
            L9:
                if (r102 == true) goto L12;
                InlineClassHelperKt.throwIllegalStateException("Item.end should be set first");
            L12:
                return new Range(this.item, this.start, r100, this.tag);
            L8:
                r102 = false;
                goto L9
            }

            public final <R> Range<R> toRange(Function1<? super T, ? extends R> r100, int r101) {
                int r102 = this.end;
                if (r102 == Integer.MIN_VALUE) goto L6;
                r101 = r102;
            L6:
                if (r101 == Integer.MIN_VALUE) goto L8;
                boolean r103 = true;
            L9:
                if (r103 == true) goto L12;
                InlineClassHelperKt.throwIllegalStateException("Item.end should be set first");
            L12:
                return new Range(r100.invoke(this.item), this.start, r101, this.tag);
            L8:
                r103 = false;
                goto L9
            }

            public MutableRange(T r100, int r101, int r102, String r103) {
                this.item = r100;
                this.start = r101;
                this.end = r102;
                this.tag = r103;
            }

            public static /* synthetic */ Range toRange$default(MutableRange r100, int r101, int r102, Object r103) {
                if ((r102 & 1) == 0) goto L6;
                r101 = Integer.MIN_VALUE;
            L6:
                return r100.toRange(r101);
            }

            public static /* synthetic */ Range toRange$default(MutableRange r100, Function1 r101, int r102, int r103, Object r104) {
                if ((r103 & 2) == 0) goto L6;
                r102 = Integer.MIN_VALUE;
            L6:
                return r100.toRange(r101, r102);
            }

            public /* synthetic */ MutableRange(Object r100, int r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
                if ((r104 & 4) == 0) goto L6;
                r102 = Integer.MIN_VALUE;
            L6:
                if ((r104 & 8) == 0) goto L8;
                r103 = "";
            L8:
                this(r100, r101, r102, r103);
            }
        }

        public Builder() {
            int r100 = 0;
            this(r100, 1, null);
        }

        public final int getLength() {
            return this.text.length();
        }

        public final void pop() {
            if ((!this.styleStack.isEmpty()) == true) goto L5;
            InlineClassHelperKt.throwIllegalStateException("Nothing to pop.");
        L5:
            List<MutableRange<? extends Object>> r100 = this.styleStack;
            ((MutableRange) ListProtector.remove(r100, r100.size() - 1)).setEnd(this.text.length());
        }

        public final AnnotatedString toAnnotatedString() {
            String r100 = this.text.toString();
            List<MutableRange<? extends Annotation>> r101 = this.annotations;
            ArrayList r102 = new ArrayList(r101.size());
            int r103 = r101.size();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L6;
            r102.add(((MutableRange) ListProtector.get(r101, r104)).toRange(this.text.length()));
            r104 = r104 + 1;
            goto L3
        L6:
            return new AnnotatedString(r100, r102);
        }

        public Builder(int r100) {
            this.text = new StringBuilder(r100);
            this.styleStack = new ArrayList();
            this.annotations = new ArrayList();
            this.bulletScope = new BulletScope(this);
        }

        public final void append(AnnotatedString r110) {
            int r100 = this.text.length();
            this.text.append(r110.getText());
            List<Range<? extends Annotation>> r111 = r110.getAnnotations$ui_text();
            if (r111 == null) goto L7;
            int r101 = r111.size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            Range r103 = (Range) ListProtector.get(r111, r102);
            this.annotations.add(new MutableRange(r103.getItem(), r103.getStart() + r100, r103.getEnd() + r100, r103.getTag()));
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        public final void flatMapAnnotations$ui_text(Function1<? super Range<? extends Annotation>, ? extends List<? extends Range<? extends Annotation>>> r110) {
            List<MutableRange<? extends Annotation>> r100 = this.annotations;
            ArrayList r101 = new ArrayList(r100.size());
            int r102 = r100.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            List<? extends Range<? extends Annotation>> r104 = r110.invoke(MutableRange.toRange$default((MutableRange) ListProtector.get(r100, r103), 0, 1, null));
            ArrayList r105 = new ArrayList(r104.size());
            int r106 = r104.size();
            int r107 = 0;
        L5:
            if (r107 >= r106) goto L7;
            Range r108 = (Range) ListProtector.get(r104, r107);
            r105.add(MutableRange.Companion.fromRange(r108));
            r107 = r107 + 1;
            goto L5
        L7:
            CollectionsKt.addAll(r101, r105);
            r103 = r103 + 1;
            goto L3
        L8:
            this.annotations.clear();
            this.annotations.addAll(r101);
        }

        public final void mapAnnotations$ui_text(Function1<? super Range<? extends Annotation>, ? extends Range<? extends Annotation>> r100) {
            int r101 = this.annotations.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            Range<? extends Annotation> r103 = r100.invoke(MutableRange.toRange$default((MutableRange) ListProtector.get(this.annotations, r102), 0, 1, null));
            ListProtector.set(this.annotations, r102, MutableRange.Companion.fromRange(r103));
            r102 = r102 + 1;
            goto L3
        }

        public final void pop(int r100) {
            if (r100 >= this.styleStack.size()) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L9;
            InlineClassHelperKt.throwIllegalStateException(r100 + " should be less than " + this.styleStack.size());
        L9:
            if ((this.styleStack.size() - 1) < r100) goto L11;
            pop();
            goto L9
        L11:
            return;
        L5:
            r101 = false;
            goto L6
        }

        public final int pushBullet(Bullet r100) {
            MutableRange<? extends Annotation> r101 = new MutableRange(r100, this.text.length(), 0, null, 12, null);
            this.styleStack.add(r101);
            this.annotations.add(r101);
            return this.styleStack.size() - 1;
        }

        public final int pushLink(LinkAnnotation r100) {
            MutableRange<? extends Annotation> r101 = new MutableRange(r100, this.text.length(), 0, null, 12, null);
            this.styleStack.add(r101);
            this.annotations.add(r101);
            return this.styleStack.size() - 1;
        }

        public final int pushStyle(ParagraphStyle r100) {
            MutableRange<? extends Annotation> r101 = new MutableRange(r100, this.text.length(), 0, null, 12, null);
            this.styleStack.add(r101);
            this.annotations.add(r101);
            return this.styleStack.size() - 1;
        }

        public final int pushTtsAnnotation(TtsAnnotation r100) {
            MutableRange<? extends Annotation> r101 = new MutableRange(r100, this.text.length(), 0, null, 12, null);
            this.styleStack.add(r101);
            this.annotations.add(r101);
            return this.styleStack.size() - 1;
        }

        @Deprecated(message = "Use LinkAnnotation API for links instead", replaceWith = @ReplaceWith(expression = "pushLink(, start, end)", imports = {}))
        public final int pushUrlAnnotation(UrlAnnotation r100) {
            MutableRange<? extends Annotation> r101 = new MutableRange(r100, this.text.length(), 0, null, 12, null);
            this.styleStack.add(r101);
            this.annotations.add(r101);
            return this.styleStack.size() - 1;
        }

        public Builder(AnnotatedString r100) {
            int r101 = 0;
            this(r101, 1, null);
            append(r100);
        }

        @Override // java.lang.Appendable
        public Builder append(CharSequence r100) {
            if ((r100 instanceof AnnotatedString) == false) goto L5;
            append((AnnotatedString) r100);
        L6:
            return this;
        L5:
            this.text.append(r100);
            goto L6
        }

        public final int pushStyle(SpanStyle r100) {
            MutableRange<? extends Annotation> r101 = new MutableRange(r100, this.text.length(), 0, null, 12, null);
            this.styleStack.add(r101);
            this.annotations.add(r101);
            return this.styleStack.size() - 1;
        }

        public Builder(String r100) {
            int r101 = 0;
            this(r101, 1, null);
            append(r100);
        }

        @Override // java.lang.Appendable
        public Builder append(char r100) {
            this.text.append(r100);
            return this;
        }

        public final void append(String r100) {
            this.text.append(r100);
        }

        @Override // java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(char r100) {
            return append(r100);
        }

        @Override // java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r100) {
            return append(r100);
        }

        @Override // java.lang.Appendable
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by the append(Char) method that returns an Appendable. This method must be kept around for binary compatibility.")
        public final /* synthetic */ void append(char r100) {
            append(r100);
        }

        public final int pushStringAnnotation(String r100, String r110) {
            MutableRange<? extends Annotation> r101 = new MutableRange(StringAnnotation.m6946boximpl(StringAnnotation.m6947constructorimpl(r110)), this.text.length(), 0, r100, 4, null);
            this.styleStack.add(r101);
            this.annotations.add(r101);
            return this.styleStack.size() - 1;
        }

        public /* synthetic */ Builder(int r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = 16;
        L5:
            this(r100);
        }

        public final void addBullet(Bullet r110, int r111, int r112) {
            this.annotations.add(new MutableRange(r110, r111, r112, null, 8, null));
        }

        public final void addLink(LinkAnnotation.Clickable r110, int r111, int r112) {
            this.annotations.add(new MutableRange(r110, r111, r112, null, 8, null));
        }

        public final void addStyle(ParagraphStyle r110, int r111, int r112) {
            this.annotations.add(new MutableRange(r110, r111, r112, null, 8, null));
        }

        public final void addTtsAnnotation(TtsAnnotation r110, int r111, int r112) {
            this.annotations.add(new MutableRange(r110, r111, r112, null, 8, null));
        }

        @Deprecated(message = "Use LinkAnnotation API for links instead", replaceWith = @ReplaceWith(expression = "addLink(, start, end)", imports = {}))
        public final void addUrlAnnotation(UrlAnnotation r110, int r111, int r112) {
            this.annotations.add(new MutableRange(r110, r111, r112, null, 8, null));
        }

        public final void append(AnnotatedString r110, int r111, int r112) {
            int r100 = this.text.length();
            this.text.append(r110.getText(), r111, r112);
            List r113 = AnnotatedStringKt.getLocalAnnotations$default(r110, r111, r112, null, 4, null);
            if (r113 == null) goto L7;
            int r114 = r113.size();
            int r115 = 0;
        L5:
            if (r115 >= r114) goto L9;
            Range r101 = (Range) ListProtector.get(r113, r115);
            this.annotations.add(new MutableRange(r101.getItem(), r101.getStart() + r100, r101.getEnd() + r100, r101.getTag()));
            r115 = r115 + 1;
            goto L5
        L9:
            return;
        }

        /* JADX INFO: renamed from: withBulletList-o2QH7mI, reason: not valid java name */
        public final <R> R m6836withBulletListo2QH7mI(long r210, Bullet r211, Function1<? super BulletScope, ? extends R> r212) {
            Pair r100 = (Pair) CollectionsKt.lastOrNull(this.bulletScope.getBulletListSettingStack$ui_text());
            if (r100 == null) goto L13;
            long r101 = ((TextUnit) r100.getFirst()).m7751unboximpl();
            if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(r101), TextUnit.m7741getTypeUIouoOA(r210)) == true) goto L7;
            InlineClassHelperKt.throwIllegalStateException("Indentation unit types of nested bullet lists must match. Current " + TextUnit.m7749toStringimpl(r101) + " and previous is " + TextUnit.m7749toStringimpl(r210));
        L7:
            long r102 = TextUnit.m7741getTypeUIouoOA(r210);
            TextUnitType.Companion r103 = TextUnitType.Companion;
            if (TextUnitType.m7770equalsimpl0(r102, r103.m7775getSpUIouoOA()) == false) goto L11;
            long r104 = TextUnitKt.getSp(TextUnit.m7742getValueimpl(r210) + TextUnit.m7742getValueimpl(r101));
        L14:
            int r105 = pushStyle(new ParagraphStyle(0, 0, 0, new TextIndent(r104, r104, null), null, null, 0, 0, null, 503, null));
            this.bulletScope.getBulletListSettingStack$ui_text().add(new Pair(TextUnit.m7732boximpl(r104), r211));
            R r106 = r212.invoke(this.bulletScope);     // Catch: Throwable -> L21
            if ((!this.bulletScope.getBulletListSettingStack$ui_text().isEmpty()) == false) goto L19;
            ListProtector.remove(this.bulletScope.getBulletListSettingStack$ui_text(), CollectionsKt.getLastIndex(this.bulletScope.getBulletListSettingStack$ui_text()));
        L19:
            pop(r105);
            return r106;
        L21:
            th = move-exception;
            if ((!this.bulletScope.getBulletListSettingStack$ui_text().isEmpty()) == false) goto L25;
            ListProtector.remove(this.bulletScope.getBulletListSettingStack$ui_text(), CollectionsKt.getLastIndex(this.bulletScope.getBulletListSettingStack$ui_text()));
        L25:
            pop(r105);
            throw th;
        L11:
            if (TextUnitType.m7770equalsimpl0(r102, r103.m7774getEmUIouoOA()) == false) goto L13;
            r104 = TextUnitKt.getEm(TextUnit.m7742getValueimpl(r210) + TextUnit.m7742getValueimpl(r101));
        L13:
            r104 = r210;
            goto L14
        }

        public final <R> R withBulletListItem(BulletScope r210, Bullet r211, Function1<? super Builder, ? extends R> r212) {
            Pair r100 = (Pair) CollectionsKt.lastOrNull(r210.getBulletListSettingStack$ui_text());
            if (r100 == null) goto L5;
            long r101 = ((TextUnit) r100.getFirst()).m7751unboximpl();
        L6:
            long r102 = r101;
            if (r211 != null) goto L12;
            if (r100 == null) goto L11;
            Bullet r103 = (Bullet) r100.getSecond();
            if (r103 == null) goto L11;
        L13:
            int r104 = r210.getBuilder$ui_text().pushStyle(new ParagraphStyle(0, 0, 0, new TextIndent(r102, r102, null), null, null, 0, 0, null, 503, null));
            int r105 = r210.getBuilder$ui_text().pushBullet(r103);
            R r106 = r212.invoke(r210.getBuilder$ui_text());     // Catch: Throwable -> L17
            r210.getBuilder$ui_text().pop(r105);
            r210.getBuilder$ui_text().pop(r104);
            return r106;
        L17:
            th = move-exception;
            r210.getBuilder$ui_text().pop(r105);
            r210.getBuilder$ui_text().pop(r104);
            throw th;
        L11:
            r103 = Bullet.Companion.getDefault();
            goto L13
        L12:
            r103 = r211;
            goto L13
        L5:
            r101 = Bullet.Companion.m6842getDefaultIndentationXSAIIZE();
            goto L6
        }

        public final void addLink(LinkAnnotation.Url r110, int r111, int r112) {
            this.annotations.add(new MutableRange(r110, r111, r112, null, 8, null));
        }

        public final void addStyle(SpanStyle r110, int r111, int r112) {
            this.annotations.add(new MutableRange(r110, r111, r112, null, 8, null));
        }

        @Override // java.lang.Appendable
        public Builder append(CharSequence r100, int r101, int r102) {
            if ((r100 instanceof AnnotatedString) == false) goto L5;
            append((AnnotatedString) r100, r101, r102);
        L6:
            return this;
        L5:
            this.text.append(r100, r101, r102);
            goto L6
        }

        @Override // java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r100, int r101, int r102) {
            return append(r100, r101, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: addBullet-r9BaKPg, reason: not valid java name */
        public final void m6835addBulletr9BaKPg(Bullet r110, long r111, int r210, int r211) {
            Object[] r112 = 0 == true ? 1 : 0;
            ParagraphStyle r113 = new ParagraphStyle(0, 0, 0, new TextIndent(r111, r111, null), null, null, 0, 0, r112, 503, null);
            this.annotations.add(new MutableRange(r113, r210, r211, null, 8, 0 == true ? 1 : 0));
            this.annotations.add(new MutableRange(r110, r210, r211, null, 8, null));
        }

        public final void addStringAnnotation(String r100, String r101, int r102, int r103) {
            this.annotations.add(new MutableRange(StringAnnotation.m6946boximpl(StringAnnotation.m6947constructorimpl(r101)), r102, r103, r100));
        }

        /* JADX INFO: renamed from: withBulletList-o2QH7mI$default, reason: not valid java name */
        public static /* synthetic */ Object m6834withBulletListo2QH7mI$default(Builder r100, long r101, Bullet r102, Function1 r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = Bullet.Companion.m6842getDefaultIndentationXSAIIZE();
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = Bullet.Companion.getDefault();
        L9:
            return r100.m6836withBulletListo2QH7mI(r101, r102, r103);
        }

        public static /* synthetic */ Object withBulletListItem$default(Builder r100, BulletScope r101, Bullet r102, Function1 r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r102 = null;
        L6:
            return r100.withBulletListItem(r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/AnnotatedString;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Saver<AnnotatedString, ?> getSaver() {
            return AnnotatedString.access$getSaver$cp();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$ExhaustiveAnnotation;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "<init>", "()V", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExhaustiveAnnotation implements Annotation {
        public ExhaustiveAnnotation() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u000bJ\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J<\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Range;", ExifInterface.GPS_DIRECTION_TRUE, "", MapController.ITEM_LAYER_TAG, "start", "", "end", "tag", "", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "(Ljava/lang/Object;II)V", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "()I", "getEnd", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Range;", "equals", "", "other", "hashCode", "toString", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Range<T> {
        public static final int $stable = 0;
        private final int end;
        private final T item;
        private final int start;
        private final String tag;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Range copy$default(Range r100, Object r101, int r102, int r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.item;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.start;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.end;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.tag;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final T component1() {
            return this.item;
        }

        public final int component2() {
            return this.start;
        }

        public final int component3() {
            return this.end;
        }

        public final String component4() {
            return this.tag;
        }

        public final Range<T> copy(T r100, int r101, int r102, String r103) {
            return new Range(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Range) == true) goto L8;
            return false;
        L8:
            Range r101 = (Range) r100;
            if (Intrinsics.areEqual(this.item, r101.item) == true) goto L12;
            return false;
        L12:
            if (this.start == r101.start) goto L15;
            return false;
        L15:
            if (this.end == r101.end) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            T r100 = this.item;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (((((r101 * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
        }

        public final int getEnd() {
            return this.end;
        }

        public final T getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        public final String getTag() {
            return this.tag;
        }

        public Range(T r100, int r101, int r102) {
            this(r100, r101, r102, "");
        }

        public Range(T r100, int r101, int r102, String r103) {
            this.item = r100;
            this.start = r101;
            this.end = r102;
            this.tag = r103;
            if (r101 > r102) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == true) goto L9;
            InlineClassHelperKt.throwIllegalArgumentException("Reversed range is not supported");
            return;
        L9:
            return;
        L5:
            r104 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
        Saver = SaversKt.getAnnotatedStringSaver();
    }

    public int getLength() {
        return this.text.length();
    }

    public final List<Range<ParagraphStyle>> getParagraphStyles() {
        List<Range<ParagraphStyle>> r100 = this.paragraphStylesOrNull;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<Range<SpanStyle>> getSpanStyles() {
        List<Range<SpanStyle>> r100 = this.spanStylesOrNull;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public int hashCode() {
        int r100 = this.text.hashCode() * 31;
        List<Range<? extends Annotation>> r101 = this.annotations;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    public final List<Range<? extends Annotation>> getAnnotations$ui_text() {
        return this.annotations;
    }

    public final List<Range<ParagraphStyle>> getParagraphStylesOrNull$ui_text() {
        return this.paragraphStylesOrNull;
    }

    public final List<Range<SpanStyle>> getSpanStylesOrNull$ui_text() {
        return this.spanStylesOrNull;
    }

    public final String getText() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int r100) {
        return get(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AnnotatedString) == true) goto L8;
        return false;
    L8:
        AnnotatedString r101 = (AnnotatedString) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.annotations, r101.annotations) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final AnnotatedString flatMapAnnotations(Function1<? super Range<? extends Annotation>, ? extends List<? extends Range<? extends Annotation>>> r100) {
        Builder r101 = new Builder(this);
        r101.flatMapAnnotations$ui_text(r100);
        return r101.toAnnotatedString();
    }

    public char get(int r100) {
        return this.text.charAt(r100);
    }

    public final boolean hasEqualAnnotations(AnnotatedString r100) {
        return Intrinsics.areEqual(this.annotations, r100.annotations);
    }

    public final AnnotatedString mapAnnotations(Function1<? super Range<? extends Annotation>, ? extends Range<? extends Annotation>> r100) {
        Builder r101 = new Builder(this);
        r101.mapAnnotations$ui_text(r100);
        return r101.toAnnotatedString();
    }

    public final AnnotatedString plus(AnnotatedString r100) {
        Builder r101 = new Builder(this);
        r101.append(r100);
        return r101.toAnnotatedString();
    }

    /* JADX INFO: renamed from: subSequence-5zc-tL8, reason: not valid java name */
    public final AnnotatedString m6833subSequence5zctL8(long r100) {
        return subSequence(TextRange.m6996getMinimpl(r100), TextRange.m6995getMaximpl(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedString(List<? extends Range<? extends Annotation>> r100, String r110) {
        this.annotations = r100;
        this.text = r110;
        List r101 = null;
        if (r100 == 0) goto L17;
        int r102 = r100.size();
        ArrayList r103 = null;
        ArrayList r104 = null;
        int r105 = 0;
    L5:
        if (r105 >= r102) goto L18;
        Range<SpanStyle> r106 = (Range) ListProtector.get(r100, r105);
        if ((r106.getItem() instanceof SpanStyle) == false) goto L12;
        if (r103 != null) goto L10;
        r103 = new ArrayList();
    L10:
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>");
        r103.add(r106);
    L16:
        r105 = r105 + 1;
        goto L5
    L12:
        if ((r106.getItem() instanceof ParagraphStyle) == false) goto L16;
        if (r104 != null) goto L15;
        r104 = new ArrayList();
    L15:
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>");
        r104.add(r106);
    L18:
        this.spanStylesOrNull = r103;
        this.paragraphStylesOrNull = r104;
        if (r104 == null) goto L21;
        r101 = CollectionsKt.sortedWith(r104, new AnnotatedString$special$$inlined$sortedBy$1());
    L21:
        List r107 = r101;
        if (r107 != null) goto L24;
    L27:
        boolean r108 = true;
    L28:
        if (r108 == true) goto L47;
        MutableIntList r109 = IntListKt.mutableIntListOf(((Range) CollectionsKt.first(r101)).getEnd());
        int r111 = r101.size();
        int r112 = 1;
    L30:
        if (r112 >= r111) goto L57;
        Range r113 = (Range) ListProtector.get(r101, r112);
    L33:
        if (r109._size == 0) goto L35;
        boolean r114 = true;
    L36:
        if (r114 == false) goto L46;
        int r115 = r109.last();
        if (r113.getStart() < r115) goto L41;
        r109.removeAt(r109._size - 1);
        goto L33
    L41:
        if (r113.getEnd() > r115) goto L43;
        boolean r116 = true;
    L44:
        if (r116 == true) goto L46;
        InlineClassHelperKt.throwIllegalArgumentException("Paragraph overlap not allowed, end " + r113.getEnd() + " should be less than or equal to " + r115);
        goto L46
    L43:
        r116 = false;
    L46:
        r109.add(r113.getEnd());
        r112 = r112 + 1;
        goto L30
    L35:
        r114 = false;
        goto L36
    L57:
        return;
    L47:
        return;
    L24:
        if (r107.isEmpty() == true) goto L27;
        r108 = false;
        goto L28
    L17:
        r103 = null;
        r104 = null;
        goto L18
    }

    public final List<Range<LinkAnnotation>> getLinkAnnotations(int r100, int r110) {
        List<Range<? extends Annotation>> r101 = this.annotations;
        if (r101 == null) goto L15;
        List r102 = new ArrayList(r101.size());
        int r103 = r101.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L16;
        Object r105 = ListProtector.get(r101, r104);
        Range r106 = (Range) r105;
        if ((r106.getItem() instanceof LinkAnnotation) == true) goto L9;
    L11:
        boolean r107 = false;
    L12:
        if (r107 == false) goto L14;
        r102.add(r105);
    L14:
        r104 = r104 + 1;
        goto L5
    L9:
        if (AnnotatedStringKt.intersect(r100, r110, r106.getStart(), r106.getEnd()) == false) goto L11;
        r107 = true;
    L16:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return r102;
    L15:
        r102 = CollectionsKt.emptyList();
        goto L16
    }

    public final List<Range<String>> getStringAnnotations(int r100, int r110) {
        List<Range<? extends Annotation>> r101 = this.annotations;
        if (r101 == null) goto L16;
        ArrayList r102 = new ArrayList(r101.size());
        int r103 = r101.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L20;
        Range r105 = (Range) ListProtector.get(r101, r104);
        if ((r105.getItem() instanceof StringAnnotation) == true) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == false) goto L14;
        r102.add(StringAnnotationKt.unbox(r105));
    L14:
        r104 = r104 + 1;
        goto L5
    L9:
        if (AnnotatedStringKt.intersect(r100, r110, r105.getStart(), r105.getEnd()) == false) goto L11;
        r106 = true;
        goto L12
    L20:
        return r102;
    L16:
        return CollectionsKt.emptyList();
    }

    public final List<Range<TtsAnnotation>> getTtsAnnotations(int r100, int r110) {
        List<Range<? extends Annotation>> r101 = this.annotations;
        if (r101 == null) goto L15;
        List r102 = new ArrayList(r101.size());
        int r103 = r101.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L16;
        Object r105 = ListProtector.get(r101, r104);
        Range r106 = (Range) r105;
        if ((r106.getItem() instanceof TtsAnnotation) == true) goto L9;
    L11:
        boolean r107 = false;
    L12:
        if (r107 == false) goto L14;
        r102.add(r105);
    L14:
        r104 = r104 + 1;
        goto L5
    L9:
        if (AnnotatedStringKt.intersect(r100, r110, r106.getStart(), r106.getEnd()) == false) goto L11;
        r107 = true;
    L16:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return r102;
    L15:
        r102 = CollectionsKt.emptyList();
        goto L16
    }

    @Deprecated(message = "Use LinkAnnotation API instead", replaceWith = @ReplaceWith(expression = "getLinkAnnotations(start, end)", imports = {}))
    public final List<Range<UrlAnnotation>> getUrlAnnotations(int r100, int r110) {
        List<Range<? extends Annotation>> r101 = this.annotations;
        if (r101 == null) goto L15;
        List r102 = new ArrayList(r101.size());
        int r103 = r101.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L16;
        Object r105 = ListProtector.get(r101, r104);
        Range r106 = (Range) r105;
        if ((r106.getItem() instanceof UrlAnnotation) == true) goto L9;
    L11:
        boolean r107 = false;
    L12:
        if (r107 == false) goto L14;
        r102.add(r105);
    L14:
        r104 = r104 + 1;
        goto L5
    L9:
        if (AnnotatedStringKt.intersect(r100, r110, r106.getStart(), r106.getEnd()) == false) goto L11;
        r107 = true;
    L16:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return r102;
    L15:
        r102 = CollectionsKt.emptyList();
        goto L16
    }

    public final boolean hasLinkAnnotations(int r100, int r101) {
        List<Range<? extends Annotation>> r102 = this.annotations;
        if (r102 == null) goto L15;
        int r103 = r102.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L19;
        Range r105 = (Range) ListProtector.get(r102, r104);
        if ((r105.getItem() instanceof LinkAnnotation) == true) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == true) goto L13;
        r104 = r104 + 1;
        goto L5
    L13:
        return true;
    L9:
        if (AnnotatedStringKt.intersect(r100, r101, r105.getStart(), r105.getEnd()) == false) goto L11;
        r106 = true;
        goto L12
    L19:
        return false;
    L15:
        return false;
    }

    @Override // java.lang.CharSequence
    public AnnotatedString subSequence(int r100, int r101) {
        if (r100 > r101) goto L4;
        boolean r102 = true;
    L5:
        if (r102 == true) goto L7;
        InlineClassHelperKt.throwIllegalArgumentException("start (" + r100 + ") should be less or equal to end (" + r101 + ')');
    L7:
        if (r100 != 0) goto L12;
        if (r101 != this.text.length()) goto L12;
        return this;
    L12:
        return new AnnotatedString(AnnotatedStringKt.access$filterRanges(this.annotations, r100, r101), this.text.substring(r100, r101));
    L4:
        r102 = false;
        goto L5
    }

    public AnnotatedString(String r100, List<? extends Range<? extends Annotation>> r101) {
        List<? extends Range<? extends Annotation>> r102 = r101;
        if (r102.isEmpty() == false) goto L5;
        r102 = null;
    L5:
        this(r102, r100);
    }

    @Override // java.lang.CharSequence
    public /* bridge */ /* synthetic */ CharSequence subSequence(int r100, int r101) {
        return subSequence(r100, r101);
    }

    public AnnotatedString(String r100, List<Range<SpanStyle>> r101, List<Range<ParagraphStyle>> r102) {
        this(AnnotatedStringKt.access$constructAnnotationsFromSpansAndParagraphs(r101, r102), r100);
    }

    public final List<Range<String>> getStringAnnotations(String r100, int r110, int r111) {
        List<Range<? extends Annotation>> r101 = this.annotations;
        if (r101 == null) goto L18;
        ArrayList r102 = new ArrayList(r101.size());
        int r103 = r101.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L22;
        Range r105 = (Range) ListProtector.get(r101, r104);
        if ((r105.getItem() instanceof StringAnnotation) == true) goto L9;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == false) goto L16;
        r102.add(StringAnnotationKt.unbox(r105));
    L16:
        r104 = r104 + 1;
        goto L5
    L9:
        if (Intrinsics.areEqual(r100, r105.getTag()) == false) goto L13;
        if (AnnotatedStringKt.intersect(r110, r111, r105.getStart(), r105.getEnd()) == false) goto L13;
        r106 = true;
        goto L14
    L22:
        return r102;
    L18:
        return CollectionsKt.emptyList();
    }

    public final boolean hasStringAnnotations(String r100, int r101, int r110) {
        List<Range<? extends Annotation>> r102 = this.annotations;
        if (r102 == null) goto L17;
        int r103 = r102.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L21;
        Range r105 = (Range) ListProtector.get(r102, r104);
        if ((r105.getItem() instanceof StringAnnotation) == true) goto L9;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == true) goto L15;
        r104 = r104 + 1;
        goto L5
    L15:
        return true;
    L9:
        if (Intrinsics.areEqual(r100, r105.getTag()) == false) goto L13;
        if (AnnotatedStringKt.intersect(r101, r110, r105.getStart(), r105.getEnd()) == false) goto L13;
        r106 = true;
        goto L14
    L21:
        return false;
    L17:
        return false;
    }

    public /* synthetic */ AnnotatedString(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        this(r100, r101);
    }

    public /* synthetic */ AnnotatedString(String r100, List r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        this(r100, r101, r102);
    }
}
