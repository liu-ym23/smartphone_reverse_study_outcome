package androidx.compose.ui.text;

import D7.A;
import D7.v;
import H4.o;
import N9.j;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Immutable
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u0000 L2\u00020\u0001:\u0005MNOPLB)\b\u0000\u0012\u0016\u0010\u0005\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB=\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u0002\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u0002¢\u0006\u0004\b\b\u0010\u000eB)\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\b\u0010\u000fJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010¢\u0006\u0004\b#\u0010$J%\u0010&\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010¢\u0006\u0004\b&\u0010'J)\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010¢\u0006\u0004\b#\u0010(J)\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00030\u00022\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010¢\u0006\u0004\b*\u0010(J+\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00030\u00022\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010H\u0007¢\u0006\u0004\b,\u0010(J)\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00030\u00022\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010¢\u0006\u0004\b.\u0010(J\u001d\u0010/\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010¢\u0006\u0004\b/\u00100J\u001a\u00102\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u000101H\u0096\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0010H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u0000¢\u0006\u0004\b8\u00109J1\u0010<\u001a\u00020\u00002\"\u0010;\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030:¢\u0006\u0004\b<\u0010=J7\u0010>\u001a\u00020\u00002(\u0010;\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00020:¢\u0006\u0004\b>\u0010=R*\u0010\u0005\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0018\u00010\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010B\u001a\u0004\bC\u00107R(\u0010D\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0003\u0018\u00010\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bE\u0010AR(\u0010F\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0003\u0018\u00010\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010?\u001a\u0004\bG\u0010AR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u00028F¢\u0006\u0006\u001a\u0004\bH\u0010AR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u00028F¢\u0006\u0006\u001a\u0004\bI\u0010AR\u0014\u0010K\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u00105¨\u0006Q"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString;", "", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "annotations", "", "text", AppAgent.CONSTRUCT, "(Ljava/util/List;Ljava/lang/String;)V", "Landroidx/compose/ui/text/SpanStyle;", "spanStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "paragraphStyles", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/util/List;)V", "", "index", "", "get", "(I)C", "startIndex", "endIndex", "subSequence", "(II)Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/TextRange;", "range", "subSequence-5zc-tL8", "(J)Landroidx/compose/ui/text/AnnotatedString;", "other", "plus", "(Landroidx/compose/ui/text/AnnotatedString;)Landroidx/compose/ui/text/AnnotatedString;", "tag", "start", "end", "getStringAnnotations", "(Ljava/lang/String;II)Ljava/util/List;", "", "hasStringAnnotations", "(Ljava/lang/String;II)Z", "(II)Ljava/util/List;", "Landroidx/compose/ui/text/TtsAnnotation;", "getTtsAnnotations", "Landroidx/compose/ui/text/UrlAnnotation;", "getUrlAnnotations", "Landroidx/compose/ui/text/LinkAnnotation;", "getLinkAnnotations", "hasLinkAnnotations", "(II)Z", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "hasEqualAnnotations", "(Landroidx/compose/ui/text/AnnotatedString;)Z", "Lkotlin/Function1;", "transform", "mapAnnotations", "(LS7/k;)Landroidx/compose/ui/text/AnnotatedString;", "flatMapAnnotations", "Ljava/util/List;", "getAnnotations$ui_text", "()Ljava/util/List;", "Ljava/lang/String;", "getText", "spanStylesOrNull", "getSpanStylesOrNull$ui_text", "paragraphStylesOrNull", "getParagraphStylesOrNull$ui_text", "getSpanStyles", "getParagraphStyles", "getLength", "length", "Companion", "Range", "Builder", "Annotation", "ExhaustiveAnnotation", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnotatedString implements CharSequence {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<AnnotatedString, ?> Saver = SaversKt.getAnnotatedStringSaver();
    private final List<Range<? extends Annotation>> annotations;
    private final List<Range<ParagraphStyle>> paragraphStylesOrNull;
    private final List<Range<SpanStyle>> spanStylesOrNull;
    private final String text;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\b\u0002\u0003\u0004\u0005\u0006\u0007\b\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Annotation;", "", "Landroidx/compose/ui/text/AnnotatedString$ExhaustiveAnnotation;", "Landroidx/compose/ui/text/Bullet;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/ui/text/ParagraphStyle;", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/StringAnnotation;", "Landroidx/compose/ui/text/TtsAnnotation;", "Landroidx/compose/ui/text/UrlAnnotation;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Annotation {
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002noB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\r\u0010\u0010J\u0019\u0010\r\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\r\u0010\u0013J)\u0010\r\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0016J\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\r\u0010\u0017J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000bJ%\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u0018J%\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001eJ-\u0010!\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"J%\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&J'\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0007¢\u0006\u0004\b)\u0010*J%\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b-\u0010.J%\u0010-\u001a\u00020\f2\u0006\u00100\u001a\u00020/2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b-\u00101J%\u00104\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b4\u00105J-\u00104\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u00107\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b:\u0010;J\u0015\u0010:\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001d¢\u0006\u0004\b:\u0010<J\u0015\u0010=\u001a\u00020\u00032\u0006\u00103\u001a\u000202¢\u0006\u0004\b=\u0010>J?\u0010F\u001a\u00028\u0000\"\b\b\u0000\u0010@*\u00020?2\b\b\u0002\u00107\u001a\u0002062\b\b\u0002\u00103\u001a\u0002022\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\bD\u0010EJ;\u0010G\u001a\u00028\u0000\"\b\b\u0000\u0010@*\u00020?*\u00020B2\n\b\u0002\u00103\u001a\u0004\u0018\u0001022\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\bG\u0010HJ\u001d\u0010I\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0004\bI\u0010JJ\u0015\u0010K\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\bM\u0010NJ\u0015\u0010Q\u001a\u00020\u00032\u0006\u0010P\u001a\u00020O¢\u0006\u0004\bQ\u0010RJ\r\u0010S\u001a\u00020\f¢\u0006\u0004\bS\u0010TJ\u0015\u0010S\u001a\u00020\f2\u0006\u0010U\u001a\u00020\u0003¢\u0006\u0004\bS\u0010\u0006J\r\u0010V\u001a\u00020\n¢\u0006\u0004\bV\u0010WJ3\u0010]\u001a\u00020\f2\"\u0010Z\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020Y0X\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020Y0X0AH\u0000¢\u0006\u0004\b[\u0010\\J9\u0010`\u001a\u00020\f2(\u0010Z\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020Y0X\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020Y0X0^0AH\u0000¢\u0006\u0004\b_\u0010\\R\u0018\u0010\b\u001a\u00060aj\u0002`b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010cR\"\u0010f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020?0e0d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\"\u0010h\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020Y0e0d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010gR\u0014\u0010i\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0011\u0010m\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bk\u0010l¨\u0006p"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "capacity", AppAgent.CONSTRUCT, "(I)V", "", "text", "(Ljava/lang/String;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "LC7/r;", "append", "", "char", "(C)V", "deprecated_append_returning_void", "", "(Ljava/lang/CharSequence;)Landroidx/compose/ui/text/AnnotatedString$Builder;", "start", "end", "(Ljava/lang/CharSequence;II)Landroidx/compose/ui/text/AnnotatedString$Builder;", "(C)Landroidx/compose/ui/text/AnnotatedString$Builder;", "(Landroidx/compose/ui/text/AnnotatedString;II)V", "Landroidx/compose/ui/text/SpanStyle;", "style", "addStyle", "(Landroidx/compose/ui/text/SpanStyle;II)V", "Landroidx/compose/ui/text/ParagraphStyle;", "(Landroidx/compose/ui/text/ParagraphStyle;II)V", "tag", "annotation", "addStringAnnotation", "(Ljava/lang/String;Ljava/lang/String;II)V", "Landroidx/compose/ui/text/TtsAnnotation;", "ttsAnnotation", "addTtsAnnotation", "(Landroidx/compose/ui/text/TtsAnnotation;II)V", "Landroidx/compose/ui/text/UrlAnnotation;", "urlAnnotation", "addUrlAnnotation", "(Landroidx/compose/ui/text/UrlAnnotation;II)V", "Landroidx/compose/ui/text/LinkAnnotation$Url;", BffConstant.Type.Url, "addLink", "(Landroidx/compose/ui/text/LinkAnnotation$Url;II)V", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "clickable", "(Landroidx/compose/ui/text/LinkAnnotation$Clickable;II)V", "Landroidx/compose/ui/text/Bullet;", "bullet", "addBullet", "(Landroidx/compose/ui/text/Bullet;II)V", "Landroidx/compose/ui/unit/TextUnit;", "indentation", "addBullet-r9BaKPg", "(Landroidx/compose/ui/text/Bullet;JII)V", "pushStyle", "(Landroidx/compose/ui/text/SpanStyle;)I", "(Landroidx/compose/ui/text/ParagraphStyle;)I", "pushBullet", "(Landroidx/compose/ui/text/Bullet;)I", "", "R", "Lkotlin/Function1;", "Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;", "block", "withBulletList-o2QH7mI", "(JLandroidx/compose/ui/text/Bullet;LS7/k;)Ljava/lang/Object;", "withBulletList", "withBulletListItem", "(Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;Landroidx/compose/ui/text/Bullet;LS7/k;)Ljava/lang/Object;", "pushStringAnnotation", "(Ljava/lang/String;Ljava/lang/String;)I", "pushTtsAnnotation", "(Landroidx/compose/ui/text/TtsAnnotation;)I", "pushUrlAnnotation", "(Landroidx/compose/ui/text/UrlAnnotation;)I", "Landroidx/compose/ui/text/LinkAnnotation;", "link", "pushLink", "(Landroidx/compose/ui/text/LinkAnnotation;)I", "pop", "()V", "index", "toAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "transform", "mapAnnotations$ui_text", "(LS7/k;)V", "mapAnnotations", "", "flatMapAnnotations$ui_text", "flatMapAnnotations", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "styleStack", "Ljava/util/List;", "annotations", "bulletScope", "Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;", "getLength", "()I", "length", "MutableRange", "BulletScope", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder implements Appendable {
        public static final int $stable = 8;
        private final List<MutableRange<? extends Annotation>> annotations;
        private final BulletScope bulletScope;
        private final List<MutableRange<? extends Object>> styleStack;
        private final StringBuilder text;

        @StabilityInferred(parameters = 0)
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;", "", "builder", "Landroidx/compose/ui/text/AnnotatedString$Builder;", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/AnnotatedString$Builder;)V", "getBuilder$ui_text", "()Landroidx/compose/ui/text/AnnotatedString$Builder;", "bulletListSettingStack", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/text/Bullet;", "getBulletListSettingStack$ui_text", "()Ljava/util/List;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class BulletScope {
            public static final int $stable = 8;
            private final Builder builder;
            private final List<Pair<TextUnit, Bullet>> bulletListSettingStack = new ArrayList();

            public BulletScope(Builder builder) {
                this.builder = builder;
            }

            /* renamed from: getBuilder$ui_text, reason: from getter */
            public final Builder getBuilder() {
                return this.builder;
            }

            public final List<Pair<TextUnit, Bullet>> getBulletListSettingStack$ui_text() {
                return this.bulletListSettingStack;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u0000 +*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001+B+\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f\"\u0004\b\u0001\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u0012J\u0010\u0010\u0013\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J>\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0019J\u0010\u0010\u001d\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0016J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u0016R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010$\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010(R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010\u0019¨\u0006,"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "item", "", "start", "end", "", "tag", AppAgent.CONSTRUCT, "(Ljava/lang/Object;IILjava/lang/String;)V", "defaultEnd", "Landroidx/compose/ui/text/AnnotatedString$Range;", "toRange", "(I)Landroidx/compose/ui/text/AnnotatedString$Range;", "R", "Lkotlin/Function1;", "transform", "(LS7/k;I)Landroidx/compose/ui/text/AnnotatedString$Range;", "component1", "()Ljava/lang/Object;", "component2", "()I", "component3", "component4", "()Ljava/lang/String;", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getItem", "I", "getStart", "getEnd", "setEnd", "(I)V", "Ljava/lang/String;", "getTag", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class MutableRange<T> {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private int end;
            private final T item;
            private final int start;
            private final String tag;

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange$Companion;", "", AppAgent.CONSTRUCT, "()V", "fromRange", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", ExifInterface.GPS_DIRECTION_TRUE, "range", "Landroidx/compose/ui/text/AnnotatedString$Range;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(e eVar) {
                    this();
                }

                public final <T> MutableRange<T> fromRange(Range<T> range) {
                    return new MutableRange<>(range.getItem(), range.getStart(), range.getEnd(), range.getTag());
                }

                private Companion() {
                }
            }

            public MutableRange(T t9, int i, int i6, String str) {
                this.item = t9;
                this.start = i;
                this.end = i6;
                this.tag = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MutableRange copy$default(MutableRange mutableRange, Object obj, int i, int i6, String str, int i10, Object obj2) {
                if ((i10 & 1) != 0) {
                    obj = mutableRange.item;
                }
                if ((i10 & 2) != 0) {
                    i = mutableRange.start;
                }
                if ((i10 & 4) != 0) {
                    i6 = mutableRange.end;
                }
                if ((i10 & 8) != 0) {
                    str = mutableRange.tag;
                }
                return mutableRange.copy(obj, i, i6, str);
            }

            public static /* synthetic */ Range toRange$default(MutableRange mutableRange, int i, int i6, Object obj) {
                if ((i6 & 1) != 0) {
                    i = Integer.MIN_VALUE;
                }
                return mutableRange.toRange(i);
            }

            public final T component1() {
                return this.item;
            }

            /* renamed from: component2, reason: from getter */
            public final int getStart() {
                return this.start;
            }

            /* renamed from: component3, reason: from getter */
            public final int getEnd() {
                return this.end;
            }

            /* renamed from: component4, reason: from getter */
            public final String getTag() {
                return this.tag;
            }

            public final MutableRange<T> copy(T item, int start, int end, String tag) {
                return new MutableRange<>(item, start, end, tag);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) other;
                return k.b(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && k.b(this.tag, mutableRange.tag);
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

            public int hashCode() {
                T t9 = this.item;
                return this.tag.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.end, androidx.constraintlayout.core.dsl.a.a(this.start, (t9 == null ? 0 : t9.hashCode()) * 31, 31), 31);
            }

            public final void setEnd(int i) {
                this.end = i;
            }

            public final Range<T> toRange(int defaultEnd) {
                int i = this.end;
                if (i != Integer.MIN_VALUE) {
                    defaultEnd = i;
                }
                if (!(defaultEnd != Integer.MIN_VALUE)) {
                    InlineClassHelperKt.throwIllegalStateException("Item.end should be set first");
                }
                return new Range<>(this.item, this.start, defaultEnd, this.tag);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("MutableRange(item=");
                sb.append(this.item);
                sb.append(", start=");
                sb.append(this.start);
                sb.append(", end=");
                sb.append(this.end);
                sb.append(", tag=");
                return B7.a.g(')', this.tag, sb);
            }

            public static /* synthetic */ Range toRange$default(MutableRange mutableRange, S7.k kVar, int i, int i6, Object obj) {
                if ((i6 & 2) != 0) {
                    i = Integer.MIN_VALUE;
                }
                return mutableRange.toRange(kVar, i);
            }

            public final <R> Range<R> toRange(S7.k transform, int defaultEnd) {
                int i = this.end;
                if (i != Integer.MIN_VALUE) {
                    defaultEnd = i;
                }
                if (!(defaultEnd != Integer.MIN_VALUE)) {
                    InlineClassHelperKt.throwIllegalStateException("Item.end should be set first");
                }
                return new Range<>(transform.invoke(this.item), this.start, defaultEnd, this.tag);
            }

            public /* synthetic */ MutableRange(Object obj, int i, int i6, String str, int i10, e eVar) {
                this(obj, i, (i10 & 4) != 0 ? Integer.MIN_VALUE : i6, (i10 & 8) != 0 ? "" : str);
            }
        }

        public Builder() {
            this(0, 1, null);
        }

        /* renamed from: withBulletList-o2QH7mI$default, reason: not valid java name */
        public static /* synthetic */ Object m6147withBulletListo2QH7mI$default(Builder builder, long j5, Bullet bullet, S7.k kVar, int i, Object obj) {
            if ((i & 1) != 0) {
                j5 = Bullet.INSTANCE.m6155getDefaultIndentationXSAIIZE();
            }
            if ((i & 2) != 0) {
                bullet = Bullet.INSTANCE.getDefault();
            }
            return builder.m6149withBulletListo2QH7mI(j5, bullet, kVar);
        }

        public static /* synthetic */ Object withBulletListItem$default(Builder builder, BulletScope bulletScope, Bullet bullet, S7.k kVar, int i, Object obj) {
            if ((i & 1) != 0) {
                bullet = null;
            }
            return builder.withBulletListItem(bulletScope, bullet, kVar);
        }

        public final void addBullet(Bullet bullet, int start, int end) {
            this.annotations.add(new MutableRange<>(bullet, start, end, null, 8, null));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: addBullet-r9BaKPg, reason: not valid java name */
        public final void m6148addBulletr9BaKPg(Bullet bullet, long indentation, int start, int end) {
            Object[] objArr = 0 == true ? 1 : 0;
            this.annotations.add(new MutableRange<>(new ParagraphStyle(0, 0, 0L, new TextIndent(indentation, indentation, null), (PlatformParagraphStyle) objArr, (LineHeightStyle) null, 0, 0, (TextMotion) null, 503, (e) null), start, end, null, 8, 0 == true ? 1 : 0));
            this.annotations.add(new MutableRange<>(bullet, start, end, 0 == true ? 1 : 0, 8, null));
        }

        public final void addLink(LinkAnnotation.Url url, int start, int end) {
            this.annotations.add(new MutableRange<>(url, start, end, null, 8, null));
        }

        public final void addStringAnnotation(String tag, String annotation, int start, int end) {
            this.annotations.add(new MutableRange<>(StringAnnotation.m6259boximpl(StringAnnotation.m6260constructorimpl(annotation)), start, end, tag));
        }

        public final void addStyle(SpanStyle style, int start, int end) {
            this.annotations.add(new MutableRange<>(style, start, end, null, 8, null));
        }

        public final void addTtsAnnotation(TtsAnnotation ttsAnnotation, int start, int end) {
            this.annotations.add(new MutableRange<>(ttsAnnotation, start, end, null, 8, null));
        }

        @C7.c
        @ExperimentalTextApi
        public final void addUrlAnnotation(UrlAnnotation urlAnnotation, int start, int end) {
            this.annotations.add(new MutableRange<>(urlAnnotation, start, end, null, 8, null));
        }

        public final void flatMapAnnotations$ui_text(S7.k transform) {
            List<MutableRange<? extends Annotation>> list = this.annotations;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List list2 = (List) transform.invoke(MutableRange.toRange$default(list.get(i), 0, 1, null));
                ArrayList arrayList2 = new ArrayList(list2.size());
                int size2 = list2.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    arrayList2.add(MutableRange.INSTANCE.fromRange((Range) list2.get(i6)));
                }
                A.e0(arrayList2, arrayList);
            }
            this.annotations.clear();
            this.annotations.addAll(arrayList);
        }

        public final int getLength() {
            return this.text.length();
        }

        public final void mapAnnotations$ui_text(S7.k transform) {
            int size = this.annotations.size();
            for (int i = 0; i < size; i++) {
                this.annotations.set(i, MutableRange.INSTANCE.fromRange((Range) transform.invoke(MutableRange.toRange$default(this.annotations.get(i), 0, 1, null))));
            }
        }

        public final void pop() {
            if (this.styleStack.isEmpty()) {
                InlineClassHelperKt.throwIllegalStateException("Nothing to pop.");
            }
            this.styleStack.remove(r0.size() - 1).setEnd(this.text.length());
        }

        public final int pushBullet(Bullet bullet) {
            MutableRange<? extends Annotation> mutableRange = new MutableRange<>(bullet, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushLink(LinkAnnotation link) {
            MutableRange<? extends Annotation> mutableRange = new MutableRange<>(link, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushStringAnnotation(String tag, String annotation) {
            MutableRange<? extends Annotation> mutableRange = new MutableRange<>(StringAnnotation.m6259boximpl(StringAnnotation.m6260constructorimpl(annotation)), this.text.length(), 0, tag, 4, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushStyle(SpanStyle style) {
            MutableRange<? extends Annotation> mutableRange = new MutableRange<>(style, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushTtsAnnotation(TtsAnnotation ttsAnnotation) {
            MutableRange<? extends Annotation> mutableRange = new MutableRange<>(ttsAnnotation, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @C7.c
        @ExperimentalTextApi
        public final int pushUrlAnnotation(UrlAnnotation urlAnnotation) {
            MutableRange<? extends Annotation> mutableRange = new MutableRange<>(urlAnnotation, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final AnnotatedString toAnnotatedString() {
            String string = this.text.toString();
            List<MutableRange<? extends Annotation>> list = this.annotations;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(list.get(i).toRange(this.text.length()));
            }
            return new AnnotatedString(string, arrayList);
        }

        /* renamed from: withBulletList-o2QH7mI, reason: not valid java name */
        public final <R> R m6149withBulletListo2QH7mI(long indentation, Bullet bullet, S7.k block) {
            long j5;
            long em;
            Pair pair = (Pair) v.L0(this.bulletScope.getBulletListSettingStack$ui_text());
            if (pair != null) {
                long packedValue = ((TextUnit) pair.f4886a).getPackedValue();
                if (!TextUnitType.m7066equalsimpl0(TextUnit.m7037getTypeUIouoOA(packedValue), TextUnit.m7037getTypeUIouoOA(indentation))) {
                    InlineClassHelperKt.throwIllegalStateException("Indentation unit types of nested bullet lists must match. Current " + ((Object) TextUnit.m7045toStringimpl(packedValue)) + " and previous is " + ((Object) TextUnit.m7045toStringimpl(indentation)));
                }
                long jM7037getTypeUIouoOA = TextUnit.m7037getTypeUIouoOA(indentation);
                TextUnitType.Companion companion = TextUnitType.INSTANCE;
                if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA())) {
                    em = TextUnitKt.getSp(TextUnit.m7038getValueimpl(packedValue) + TextUnit.m7038getValueimpl(indentation));
                } else if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7070getEmUIouoOA())) {
                    em = TextUnitKt.getEm(TextUnit.m7038getValueimpl(packedValue) + TextUnit.m7038getValueimpl(indentation));
                } else {
                    em = indentation;
                }
                j5 = em;
            } else {
                j5 = indentation;
            }
            int iPushStyle = pushStyle(new ParagraphStyle(0, 0, 0L, new TextIndent(j5, j5, null), null, null, 0, 0, null, 503, (e) null));
            this.bulletScope.getBulletListSettingStack$ui_text().add(new Pair<>(TextUnit.m7028boximpl(j5), bullet));
            try {
                return (R) block.invoke(this.bulletScope);
            } finally {
                if (!this.bulletScope.getBulletListSettingStack$ui_text().isEmpty()) {
                    this.bulletScope.getBulletListSettingStack$ui_text().remove(o.H(this.bulletScope.getBulletListSettingStack$ui_text()));
                }
                pop(iPushStyle);
            }
        }

        public final <R> R withBulletListItem(BulletScope bulletScope, Bullet bullet, S7.k kVar) {
            Bullet bullet2;
            Pair pair = (Pair) v.L0(bulletScope.getBulletListSettingStack$ui_text());
            long packedValue = pair != null ? ((TextUnit) pair.f4886a).getPackedValue() : Bullet.INSTANCE.m6155getDefaultIndentationXSAIIZE();
            if (bullet != null) {
                bullet2 = bullet;
            } else if (pair == null || (bullet2 = (Bullet) pair.b) == null) {
                bullet2 = Bullet.INSTANCE.getDefault();
            }
            int iPushStyle = bulletScope.getBuilder().pushStyle(new ParagraphStyle(0, 0, 0L, new TextIndent(packedValue, packedValue, null), (PlatformParagraphStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 503, (e) null));
            int iPushBullet = bulletScope.getBuilder().pushBullet(bullet2);
            try {
                return (R) kVar.invoke(bulletScope.getBuilder());
            } finally {
                bulletScope.getBuilder().pop(iPushBullet);
                bulletScope.getBuilder().pop(iPushStyle);
            }
        }

        public Builder(int i) {
            this.text = new StringBuilder(i);
            this.styleStack = new ArrayList();
            this.annotations = new ArrayList();
            this.bulletScope = new BulletScope(this);
        }

        public final void addLink(LinkAnnotation.Clickable clickable, int start, int end) {
            this.annotations.add(new MutableRange<>(clickable, start, end, null, 8, null));
        }

        public final void addStyle(ParagraphStyle style, int start, int end) {
            this.annotations.add(new MutableRange<>(style, start, end, null, 8, null));
        }

        public final void append(String text) {
            this.text.append(text);
        }

        public final void pop(int index) {
            if (!(index < this.styleStack.size())) {
                InlineClassHelperKt.throwIllegalStateException(index + " should be less than " + this.styleStack.size());
            }
            while (this.styleStack.size() - 1 >= index) {
                pop();
            }
        }

        public final int pushStyle(ParagraphStyle style) {
            MutableRange<? extends Annotation> mutableRange = new MutableRange<>(style, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @Override // java.lang.Appendable
        public Builder append(CharSequence text) {
            if (text instanceof AnnotatedString) {
                append((AnnotatedString) text);
                return this;
            }
            this.text.append(text);
            return this;
        }

        public /* synthetic */ Builder(int i, int i6, e eVar) {
            this((i6 & 1) != 0 ? 16 : i);
        }

        public Builder(String str) {
            this(0, 1, null);
            append(str);
        }

        @Override // java.lang.Appendable
        public Builder append(CharSequence text, int start, int end) {
            if (text instanceof AnnotatedString) {
                append((AnnotatedString) text, start, end);
                return this;
            }
            this.text.append(text, start, end);
            return this;
        }

        public Builder(AnnotatedString annotatedString) {
            this(0, 1, null);
            append(annotatedString);
        }

        @Override // java.lang.Appendable
        public Builder append(char c) {
            this.text.append(c);
            return this;
        }

        public final void append(AnnotatedString text) {
            int length = this.text.length();
            this.text.append(text.getText());
            List<Range<? extends Annotation>> annotations$ui_text = text.getAnnotations$ui_text();
            if (annotations$ui_text != null) {
                int size = annotations$ui_text.size();
                for (int i = 0; i < size; i++) {
                    Range<? extends Annotation> range = annotations$ui_text.get(i);
                    this.annotations.add(new MutableRange<>(range.getItem(), range.getStart() + length, range.getEnd() + length, range.getTag()));
                }
            }
        }

        public final void append(AnnotatedString text, int start, int end) {
            int length = this.text.length();
            this.text.append((CharSequence) text.getText(), start, end);
            List localAnnotations$default = AnnotatedStringKt.getLocalAnnotations$default(text, start, end, null, 4, null);
            if (localAnnotations$default != null) {
                int size = localAnnotations$default.size();
                for (int i = 0; i < size; i++) {
                    Range range = (Range) localAnnotations$default.get(i);
                    this.annotations.add(new MutableRange<>(range.getItem(), range.getStart() + length, range.getEnd() + length, range.getTag()));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Companion;", "", AppAgent.CONSTRUCT, "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/AnnotatedString;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Saver<AnnotatedString, ?> getSaver() {
            return AnnotatedString.Saver;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$ExhaustiveAnnotation;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", AppAgent.CONSTRUCT, "()V", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExhaustiveAnnotation implements Annotation {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedString(List<? extends Range<? extends Annotation>> list, String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.annotations = list;
        this.text = str;
        if (list != 0) {
            int size = list.size();
            arrayList = null;
            arrayList2 = null;
            for (int i = 0; i < size; i++) {
                Range<SpanStyle> range = (Range) list.get(i);
                if (range.getItem() instanceof SpanStyle) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(range);
                } else if (range.getItem() instanceof ParagraphStyle) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(range);
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        this.spanStylesOrNull = arrayList;
        this.paragraphStylesOrNull = arrayList2;
        List listZ0 = arrayList2 != null ? v.Z0(arrayList2, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t9, T t10) {
                return j.m(Integer.valueOf(((AnnotatedString.Range) t9).getStart()), Integer.valueOf(((AnnotatedString.Range) t10).getStart()));
            }
        }) : null;
        List list2 = listZ0;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        MutableIntList mutableIntListMutableIntListOf = IntListKt.mutableIntListOf(((Range) v.A0(listZ0)).getEnd());
        int size2 = listZ0.size();
        for (int i6 = 1; i6 < size2; i6++) {
            Range range2 = (Range) listZ0.get(i6);
            while (true) {
                if (mutableIntListMutableIntListOf._size == 0) {
                    break;
                }
                int iLast = mutableIntListMutableIntListOf.last();
                if (range2.getStart() >= iLast) {
                    mutableIntListMutableIntListOf.removeAt(mutableIntListMutableIntListOf._size - 1);
                } else if (!(range2.getEnd() <= iLast)) {
                    InlineClassHelperKt.throwIllegalArgumentException("Paragraph overlap not allowed, end " + range2.getEnd() + " should be less than or equal to " + iLast);
                }
            }
            mutableIntListMutableIntListOf.add(range2.getEnd());
        }
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) other;
        return k.b(this.text, annotatedString.text) && k.b(this.annotations, annotatedString.annotations);
    }

    public final AnnotatedString flatMapAnnotations(S7.k transform) {
        Builder builder = new Builder(this);
        builder.flatMapAnnotations$ui_text(transform);
        return builder.toAnnotatedString();
    }

    public char get(int index) {
        return this.text.charAt(index);
    }

    public final List<Range<? extends Annotation>> getAnnotations$ui_text() {
        return this.annotations;
    }

    public int getLength() {
        return this.text.length();
    }

    public final List<Range<LinkAnnotation>> getLinkAnnotations(int start, int end) {
        List arrayList;
        List<Range<? extends Annotation>> list = this.annotations;
        if (list != null) {
            arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Annotation> range = list.get(i);
                Range<? extends Annotation> range2 = range;
                if ((range2.getItem() instanceof LinkAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    arrayList.add(range);
                }
            }
        } else {
            arrayList = EmptyList.f4893a;
        }
        k.d(arrayList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return arrayList;
    }

    public final List<Range<ParagraphStyle>> getParagraphStyles() {
        List<Range<ParagraphStyle>> list = this.paragraphStylesOrNull;
        return list == null ? EmptyList.f4893a : list;
    }

    public final List<Range<ParagraphStyle>> getParagraphStylesOrNull$ui_text() {
        return this.paragraphStylesOrNull;
    }

    public final List<Range<SpanStyle>> getSpanStyles() {
        List<Range<SpanStyle>> list = this.spanStylesOrNull;
        return list == null ? EmptyList.f4893a : list;
    }

    public final List<Range<SpanStyle>> getSpanStylesOrNull$ui_text() {
        return this.spanStylesOrNull;
    }

    public final List<Range<String>> getStringAnnotations(String tag, int start, int end) {
        List<Range<? extends Annotation>> list = this.annotations;
        if (list == null) {
            return EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Range<? extends Annotation> range = list.get(i);
            if ((range.getItem() instanceof StringAnnotation) && k.b(tag, range.getTag()) && AnnotatedStringKt.intersect(start, end, range.getStart(), range.getEnd())) {
                arrayList.add(StringAnnotationKt.unbox(range));
            }
        }
        return arrayList;
    }

    public final String getText() {
        return this.text;
    }

    public final List<Range<TtsAnnotation>> getTtsAnnotations(int start, int end) {
        List arrayList;
        List<Range<? extends Annotation>> list = this.annotations;
        if (list != null) {
            arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Annotation> range = list.get(i);
                Range<? extends Annotation> range2 = range;
                if ((range2.getItem() instanceof TtsAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    arrayList.add(range);
                }
            }
        } else {
            arrayList = EmptyList.f4893a;
        }
        k.d(arrayList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return arrayList;
    }

    @C7.c
    @ExperimentalTextApi
    public final List<Range<UrlAnnotation>> getUrlAnnotations(int start, int end) {
        List arrayList;
        List<Range<? extends Annotation>> list = this.annotations;
        if (list != null) {
            arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Annotation> range = list.get(i);
                Range<? extends Annotation> range2 = range;
                if ((range2.getItem() instanceof UrlAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    arrayList.add(range);
                }
            }
        } else {
            arrayList = EmptyList.f4893a;
        }
        k.d(arrayList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return arrayList;
    }

    public final boolean hasEqualAnnotations(AnnotatedString other) {
        return k.b(this.annotations, other.annotations);
    }

    public final boolean hasLinkAnnotations(int start, int end) {
        List<Range<? extends Annotation>> list = this.annotations;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Annotation> range = list.get(i);
                if ((range.getItem() instanceof LinkAnnotation) && AnnotatedStringKt.intersect(start, end, range.getStart(), range.getEnd())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean hasStringAnnotations(String tag, int start, int end) {
        List<Range<? extends Annotation>> list = this.annotations;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Annotation> range = list.get(i);
                if ((range.getItem() instanceof StringAnnotation) && k.b(tag, range.getTag()) && AnnotatedStringKt.intersect(start, end, range.getStart(), range.getEnd())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        List<Range<? extends Annotation>> list = this.annotations;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final AnnotatedString mapAnnotations(S7.k transform) {
        Builder builder = new Builder(this);
        builder.mapAnnotations$ui_text(transform);
        return builder.toAnnotatedString();
    }

    @Stable
    public final AnnotatedString plus(AnnotatedString other) {
        Builder builder = new Builder(this);
        builder.append(other);
        return builder.toAnnotatedString();
    }

    /* renamed from: subSequence-5zc-tL8, reason: not valid java name */
    public final AnnotatedString m6146subSequence5zctL8(long range) {
        return subSequence(TextRange.m6309getMinimpl(range), TextRange.m6308getMaximpl(range));
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    public AnnotatedString subSequence(int startIndex, int endIndex) {
        if (!(startIndex <= endIndex)) {
            InlineClassHelperKt.throwIllegalArgumentException("start (" + startIndex + ") should be less or equal to end (" + endIndex + ')');
        }
        if (startIndex == 0 && endIndex == this.text.length()) {
            return this;
        }
        String strSubstring = this.text.substring(startIndex, endIndex);
        k.e(strSubstring, "substring(...)");
        return new AnnotatedString((List<? extends Range<? extends Annotation>>) AnnotatedStringKt.filterRanges(this.annotations, startIndex, endIndex), strSubstring);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u000bJ\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J<\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Range;", ExifInterface.GPS_DIRECTION_TRUE, "", "item", "start", "", "end", "tag", "", AppAgent.CONSTRUCT, "(Ljava/lang/Object;IILjava/lang/String;)V", "(Ljava/lang/Object;II)V", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "()I", "getEnd", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Range;", "equals", "", "other", "hashCode", "toString", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Immutable
    public static final /* data */ class Range<T> {
        public static final int $stable = 0;
        private final int end;
        private final T item;
        private final int start;
        private final String tag;

        public Range(T t9, int i, int i6, String str) {
            this.item = t9;
            this.start = i;
            this.end = i6;
            this.tag = str;
            if (i <= i6) {
                return;
            }
            InlineClassHelperKt.throwIllegalArgumentException("Reversed range is not supported");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Range copy$default(Range range, Object obj, int i, int i6, String str, int i10, Object obj2) {
            if ((i10 & 1) != 0) {
                obj = range.item;
            }
            if ((i10 & 2) != 0) {
                i = range.start;
            }
            if ((i10 & 4) != 0) {
                i6 = range.end;
            }
            if ((i10 & 8) != 0) {
                str = range.tag;
            }
            return range.copy(obj, i, i6, str);
        }

        public final T component1() {
            return this.item;
        }

        /* renamed from: component2, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: component3, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        public final Range<T> copy(T item, int start, int end, String tag) {
            return new Range<>(item, start, end, tag);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Range)) {
                return false;
            }
            Range range = (Range) other;
            return k.b(this.item, range.item) && this.start == range.start && this.end == range.end && k.b(this.tag, range.tag);
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

        public int hashCode() {
            T t9 = this.item;
            return this.tag.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.end, androidx.constraintlayout.core.dsl.a.a(this.start, (t9 == null ? 0 : t9.hashCode()) * 31, 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Range(item=");
            sb.append(this.item);
            sb.append(", start=");
            sb.append(this.start);
            sb.append(", end=");
            sb.append(this.end);
            sb.append(", tag=");
            return B7.a.g(')', this.tag, sb);
        }

        public Range(T t9, int i, int i6) {
            this(t9, i, i6, "");
        }
    }

    public final List<Range<String>> getStringAnnotations(int start, int end) {
        List<Range<? extends Annotation>> list = this.annotations;
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Annotation> range = list.get(i);
                if ((range.getItem() instanceof StringAnnotation) && AnnotatedStringKt.intersect(start, end, range.getStart(), range.getEnd())) {
                    arrayList.add(StringAnnotationKt.unbox(range));
                }
            }
            return arrayList;
        }
        return EmptyList.f4893a;
    }

    public AnnotatedString(String str, List list, int i, e eVar) {
        this(str, (List<? extends Range<? extends Annotation>>) ((i & 2) != 0 ? EmptyList.f4893a : list));
    }

    public AnnotatedString(String str, List list, List list2, int i, e eVar) {
        this(str, (i & 2) != 0 ? EmptyList.f4893a : list, (i & 4) != 0 ? EmptyList.f4893a : list2);
    }

    public AnnotatedString(String str, List<Range<SpanStyle>> list, List<Range<ParagraphStyle>> list2) {
        this((List<? extends Range<? extends Annotation>>) AnnotatedStringKt.constructAnnotationsFromSpansAndParagraphs(list, list2), str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AnnotatedString(String str, List<? extends Range<? extends Annotation>> list) {
        List<? extends Range<? extends Annotation>> list2 = list;
        this(list2.isEmpty() ? null : list2, str);
    }
}
