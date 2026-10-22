package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Immutable
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\bI\b\u0007\u0018\u0000 ¬\u00012\u00020\u0001:\u0002¬\u0001B%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nB×\u0001\b\u0017\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b\b\u0010,Bï\u0001\b\u0017\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b\b\u0010/B\u0087\u0002\b\u0017\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b\b\u00104B\u009f\u0002\b\u0017\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b\b\u00109B\u0097\u0002\b\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u00101\u001a\u000200\u0012\b\b\u0002\u00103\u001a\u000202\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b\b\u0010:B¡\u0002\b\u0016\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010>\u001a\u00020=\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u00101\u001a\u000200\u0012\b\b\u0002\u00103\u001a\u000202\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b\b\u0010?B©\u0002\b\u0017\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010>\u001a\u00020=\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b\b\u0010@J\u000f\u0010A\u001a\u00020\u0002H\u0007¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0004H\u0007¢\u0006\u0004\bC\u0010DJ\u001b\u0010F\u001a\u00020\u00002\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\bF\u0010GJ\u009d\u0002\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00103\u001a\u0002022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00108\u001a\u0004\u0018\u000107H\u0007¢\u0006\u0004\bH\u0010IJ¥\u0002\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00103\u001a\u0004\u0018\u0001022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00108\u001a\u0004\u0018\u000107H\u0007¢\u0006\u0004\bJ\u0010KJ\u0017\u0010F\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0002H\u0007¢\u0006\u0004\bF\u0010LJ\u0017\u0010F\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0004H\u0007¢\u0006\u0004\bF\u0010MJ\u0018\u0010N\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\bN\u0010GJ\u0018\u0010N\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\bN\u0010MJ\u0018\u0010N\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0002H\u0087\u0002¢\u0006\u0004\bN\u0010LJÝ\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\bO\u0010PJõ\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0004\bR\u0010SJ\u008d\u0002\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00103\u001a\u0004\u0018\u000102H\u0007¢\u0006\u0004\bT\u0010UJ¥\u0002\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00103\u001a\u0004\u0018\u0001022\n\b\u0002\u00108\u001a\u0004\u0018\u000107H\u0007¢\u0006\u0004\bV\u0010WJ\u009b\u0002\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00103\u001a\u0002022\n\b\u0002\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\bX\u0010YJ¯\u0002\u0010Q\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00103\u001a\u0004\u0018\u0001022\n\b\u0002\u00108\u001a\u0004\u0018\u000107H\u0007¢\u0006\u0004\bZ\u0010[J¥\u0002\u0010Q\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00103\u001a\u0002022\n\b\u0002\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b\\\u0010]J\u001a\u0010_\u001a\u00020^2\b\u0010E\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b_\u0010`J\u0015\u0010a\u001a\u00020^2\u0006\u0010E\u001a\u00020\u0000¢\u0006\u0004\ba\u0010bJ\u0015\u0010c\u001a\u00020^2\u0006\u0010E\u001a\u00020\u0000¢\u0006\u0004\bc\u0010bJ\u000f\u0010e\u001a\u00020dH\u0016¢\u0006\u0004\be\u0010fJ\u000f\u0010h\u001a\u00020dH\u0000¢\u0006\u0004\bg\u0010fJ\u000f\u0010i\u001a\u00020\u0017H\u0016¢\u0006\u0004\bi\u0010jR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010k\u001a\u0004\bl\u0010BR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010m\u001a\u0004\bn\u0010DR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010o\u001a\u0004\bp\u0010qR\u0013\u0010<\u001a\u0004\u0018\u00010;8F¢\u0006\u0006\u001a\u0004\br\u0010sR\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0011\u0010>\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\bv\u0010wR\u0011\u0010\u000e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bx\u0010uR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\by\u0010zR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b}\u0010~R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010jR\u0012\u0010\u0019\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010uR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001a8F¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001c8F¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u001e8F¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0012\u0010 \u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010uR\u0015\u0010\"\u001a\u0004\u0018\u00010!8F¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0015\u0010$\u001a\u0004\u0018\u00010#8F¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0015\u00106\u001a\u0004\u0018\u0001058F¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0012\u0010&\u001a\u00020%8F¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010fR!\u0010\u0095\u0001\u001a\u0004\u0018\u00010%8GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0012\u0010(\u001a\u00020'8F¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010fR!\u0010\u009a\u0001\u001a\u0004\u0018\u00010'8GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0099\u0001\u0010\u0094\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0012\u0010)\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010uR\u0015\u0010+\u001a\u0004\u0018\u00010*8F¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0015\u0010.\u001a\u0004\u0018\u00010-8F¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0012\u00103\u001a\u0002028F¢\u0006\u0007\u001a\u0005\b \u0001\u0010fR!\u0010¤\u0001\u001a\u0004\u0018\u0001028GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b£\u0001\u0010\u0094\u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R\u0012\u00101\u001a\u0002008F¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010fR!\u0010©\u0001\u001a\u0004\u0018\u0001008GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b¨\u0001\u0010\u0094\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R\u0015\u00108\u001a\u0004\u0018\u0001078F¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001¨\u0006\u00ad\u0001"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "", "Landroidx/compose/ui/text/SpanStyle;", "spanStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "paragraphStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "platformStyle", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformTextStyle;)V", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/unit/TextUnit;", "fontSize", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", "", "fontFeatureSettings", "letterSpacing", "Landroidx/compose/ui/text/style/BaselineShift;", "baselineShift", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textGeometricTransform", "Landroidx/compose/ui/text/intl/LocaleList;", "localeList", "background", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "Landroidx/compose/ui/graphics/Shadow;", "shadow", "Landroidx/compose/ui/text/style/TextAlign;", "textAlign", "Landroidx/compose/ui/text/style/TextDirection;", "textDirection", "lineHeight", "Landroidx/compose/ui/text/style/TextIndent;", "textIndent", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineHeightStyle", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/text/style/LineBreak;", "lineBreak", "Landroidx/compose/ui/text/style/Hyphens;", "hyphens", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "Landroidx/compose/ui/text/style/TextMotion;", "textMotion", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/e;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/graphics/Brush;", "brush", "", "alpha", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/e;)V", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/e;)V", "toSpanStyle", "()Landroidx/compose/ui/text/SpanStyle;", "toParagraphStyle", "()Landroidx/compose/ui/text/ParagraphStyle;", "other", "merge", "(Landroidx/compose/ui/text/TextStyle;)Landroidx/compose/ui/text/TextStyle;", "merge-dA7vx0o", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "merge-Z1GrekI", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "(Landroidx/compose/ui/text/SpanStyle;)Landroidx/compose/ui/text/TextStyle;", "(Landroidx/compose/ui/text/ParagraphStyle;)Landroidx/compose/ui/text/TextStyle;", "plus", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "copy", "copy-NOaFTUo", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/TextStyle;", "copy-CXVQc50", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/TextStyle;", "copy-v2rsoow", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-p1EtxEg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-aIRg9q4", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-Ns73l9s", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "", "equals", "(Ljava/lang/Object;)Z", "hasSameLayoutAffectingAttributes", "(Landroidx/compose/ui/text/TextStyle;)Z", "hasSameDrawAffectingAttributes", "", "hashCode", "()I", "hashCodeLayoutAffectingAttributes$ui_text", "hashCodeLayoutAffectingAttributes", "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/text/SpanStyle;", "getSpanStyle$ui_text", "Landroidx/compose/ui/text/ParagraphStyle;", "getParagraphStyle$ui_text", "Landroidx/compose/ui/text/PlatformTextStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "()J", "getAlpha", "()F", "getFontSize-XSAIIZE", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "getLetterSpacing-XSAIIZE", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getBackground-0d7_KjU", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getTextAlign-e0LSkKk", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextAlign-buA522U$annotations", "()V", "deprecated_boxing_textAlign", "getTextDirection-s_7X-co", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getTextDirection-mmuk1to$annotations", "deprecated_boxing_textDirection", "getLineHeight-XSAIIZE", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getHyphens-vmbZdU8", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "getHyphens-EaSxIns$annotations", "deprecated_boxing_hyphens", "getLineBreak-rAG3T2k", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "getLineBreak-LgCVezo$annotations", "deprecated_boxing_lineBreak", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextStyle {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextStyle Default = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, ViewCompat.MEASURED_SIZE_MASK, (e) null);
    private final ParagraphStyle paragraphStyle;
    private final PlatformTextStyle platformStyle;
    private final SpanStyle spanStyle;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextStyle$Companion;", "", AppAgent.CONSTRUCT, "()V", "Default", "Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @Stable
        public static /* synthetic */ void getDefault$annotations() {
        }

        public final TextStyle getDefault() {
            return TextStyle.Default;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i6, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, int i11, TextMotion textMotion, e eVar) {
        this(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j10, baselineShift, textGeometricTransform, localeList, j11, textDecoration, shadow, drawStyle, i, i6, j12, textIndent, platformTextStyle, lineHeightStyle, i10, i11, textMotion);
    }

    /* renamed from: copy-CXVQc50$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m6319copyCXVQc50$default(TextStyle textStyle, long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i, Object obj) {
        Hyphens hyphensM6619boximpl;
        LineBreak lineBreak2;
        long jM6252getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m6252getColor0d7_KjU() : j5;
        long fontSize = (i & 2) != 0 ? textStyle.spanStyle.getFontSize() : j6;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long letterSpacing = (i & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : j10;
        BaselineShift baselineShift2 = (i & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j13 = jM6252getColor0d7_KjU;
        long background = (i & 2048) != 0 ? textStyle.spanStyle.getBackground() : j11;
        TextDecoration background2 = (i & 4096) != 0 ? textStyle.spanStyle.getBackground() : textDecoration;
        Shadow shadow2 = (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration2 = background2;
        TextAlign textAlignM6721boximpl = (i & 16384) != 0 ? TextAlign.m6721boximpl(textStyle.paragraphStyle.getTextAlign()) : textAlign;
        TextDirection textDirectionM6735boximpl = (i & 32768) != 0 ? TextDirection.m6735boximpl(textStyle.paragraphStyle.getTextDirection()) : textDirection;
        long jM6214getLineHeightXSAIIZE = (i & 65536) != 0 ? textStyle.paragraphStyle.getLineHeight() : j12;
        TextIndent textIndent2 = (i & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 262144) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 524288) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        LineBreak lineBreakM6629boximpl = (i & 1048576) != 0 ? LineBreak.m6629boximpl(textStyle.paragraphStyle.getLineBreak()) : lineBreak;
        if ((i & 2097152) != 0) {
            lineBreak2 = lineBreakM6629boximpl;
            hyphensM6619boximpl = Hyphens.m6619boximpl(textStyle.paragraphStyle.getHyphens());
        } else {
            hyphensM6619boximpl = hyphens;
            lineBreak2 = lineBreakM6629boximpl;
        }
        return textStyle.m6332copyCXVQc50(j13, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, background, textDecoration2, shadow2, textAlignM6721boximpl, textDirectionM6735boximpl, jM6214getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreak2, hyphensM6619boximpl);
    }

    /* renamed from: copy-HL5avdY$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m6320copyHL5avdY$default(TextStyle textStyle, long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, int i, Object obj) {
        long jM6252getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m6252getColor0d7_KjU() : j5;
        return textStyle.m6333copyHL5avdY(jM6252getColor0d7_KjU, (i & 2) != 0 ? textStyle.spanStyle.getFontSize() : j6, (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight, (i & 8) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle, (i & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis, (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily, (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str, (i & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : j10, (i & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift, (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform, (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList, (i & 2048) != 0 ? textStyle.spanStyle.getBackground() : j11, (i & 4096) != 0 ? textStyle.spanStyle.getBackground() : textDecoration, (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow, (i & 16384) != 0 ? TextAlign.m6721boximpl(textStyle.paragraphStyle.getTextAlign()) : textAlign, (i & 32768) != 0 ? TextDirection.m6735boximpl(textStyle.paragraphStyle.getTextDirection()) : textDirection, (i & 65536) != 0 ? textStyle.paragraphStyle.getLineHeight() : j12, (i & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent);
    }

    /* renamed from: copy-NOaFTUo$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m6321copyNOaFTUo$default(TextStyle textStyle, long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i, Object obj) {
        LineHeightStyle lineHeightStyle2;
        PlatformTextStyle platformTextStyle2;
        long jM6252getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m6252getColor0d7_KjU() : j5;
        long fontSize = (i & 2) != 0 ? textStyle.spanStyle.getFontSize() : j6;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long letterSpacing = (i & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : j10;
        BaselineShift baselineShift2 = (i & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j13 = jM6252getColor0d7_KjU;
        long background = (i & 2048) != 0 ? textStyle.spanStyle.getBackground() : j11;
        TextDecoration background2 = (i & 4096) != 0 ? textStyle.spanStyle.getBackground() : textDecoration;
        Shadow shadow2 = (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration2 = background2;
        TextAlign textAlignM6721boximpl = (i & 16384) != 0 ? TextAlign.m6721boximpl(textStyle.paragraphStyle.getTextAlign()) : textAlign;
        TextDirection textDirectionM6735boximpl = (i & 32768) != 0 ? TextDirection.m6735boximpl(textStyle.paragraphStyle.getTextDirection()) : textDirection;
        long jM6214getLineHeightXSAIIZE = (i & 65536) != 0 ? textStyle.paragraphStyle.getLineHeight() : j12;
        TextIndent textIndent2 = (i & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle3 = (i & 262144) != 0 ? textStyle.platformStyle : platformTextStyle;
        if ((i & 524288) != 0) {
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = textStyle.paragraphStyle.getLineHeightStyle();
        } else {
            lineHeightStyle2 = lineHeightStyle;
            platformTextStyle2 = platformTextStyle3;
        }
        return textStyle.m6334copyNOaFTUo(j13, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, background, textDecoration2, shadow2, textAlignM6721boximpl, textDirectionM6735boximpl, jM6214getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2);
    }

    /* renamed from: copy-Ns73l9s$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m6322copyNs73l9s$default(TextStyle textStyle, Brush brush, float f, long j5, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j6, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j10, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i6, long j11, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, int i11, TextMotion textMotion, int i12, Object obj) {
        TextMotion textMotion2;
        int i13;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        int i14;
        int i15;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        LineHeightStyle lineHeightStyle2;
        Shadow shadow2;
        long j12;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        FontSynthesis fontSynthesis2;
        String str2;
        long j13;
        BaselineShift baselineShift2;
        TextGeometricTransform textGeometricTransform2;
        LocaleList localeList2;
        long j14;
        long j15;
        Brush brush2;
        float f7;
        int i16;
        TextStyle textStyle2;
        FontFamily fontFamily2;
        float alpha = (i12 & 2) != 0 ? textStyle.spanStyle.getAlpha() : f;
        long fontSize = (i12 & 4) != 0 ? textStyle.spanStyle.getFontSize() : j5;
        FontWeight fontWeight3 = (i12 & 8) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyle3 = (i12 & 16) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesis3 = (i12 & 32) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily3 = (i12 & 64) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i12 & 128) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long letterSpacing = (i12 & 256) != 0 ? textStyle.spanStyle.getLetterSpacing() : j6;
        BaselineShift baselineShift3 = (i12 & 512) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform3 = (i12 & 1024) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList3 = (i12 & 2048) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long background = (i12 & 4096) != 0 ? textStyle.spanStyle.getBackground() : j10;
        float f9 = alpha;
        TextDecoration background2 = (i12 & 8192) != 0 ? textStyle.spanStyle.getBackground() : textDecoration;
        Shadow shadow3 = (i12 & 16384) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        DrawStyle drawStyle3 = (i12 & 32768) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        int iM6216getTextAligne0LSkKk = (i12 & 65536) != 0 ? textStyle.paragraphStyle.getTextAlign() : i;
        int iM6218getTextDirections_7Xco = (i12 & 131072) != 0 ? textStyle.paragraphStyle.getTextDirection() : i6;
        long jM6214getLineHeightXSAIIZE = (i12 & 262144) != 0 ? textStyle.paragraphStyle.getLineHeight() : j11;
        TextIndent textIndent3 = (i12 & 524288) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle3 = (i12 & 1048576) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle3 = (i12 & 2097152) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        int iM6213getLineBreakrAG3T2k = (i12 & 4194304) != 0 ? textStyle.paragraphStyle.getLineBreak() : i10;
        int iM6211getHyphensvmbZdU8 = (i12 & 8388608) != 0 ? textStyle.paragraphStyle.getHyphens() : i11;
        if ((i12 & 16777216) != 0) {
            i13 = iM6211getHyphensvmbZdU8;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
            textDecoration2 = background2;
            drawStyle2 = drawStyle3;
            i14 = iM6216getTextAligne0LSkKk;
            i15 = iM6218getTextDirections_7Xco;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            i16 = iM6213getLineBreakrAG3T2k;
            shadow2 = shadow3;
            j12 = fontSize;
            fontWeight2 = fontWeight3;
            fontStyle2 = fontStyle3;
            fontSynthesis2 = fontSynthesis3;
            fontFamily2 = fontFamily3;
            str2 = fontFeatureSettings;
            j13 = letterSpacing;
            baselineShift2 = baselineShift3;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j14 = background;
            j15 = jM6214getLineHeightXSAIIZE;
            brush2 = brush;
            f7 = f9;
            textStyle2 = textStyle;
        } else {
            textMotion2 = textMotion;
            i13 = iM6211getHyphensvmbZdU8;
            textDecoration2 = background2;
            drawStyle2 = drawStyle3;
            i14 = iM6216getTextAligne0LSkKk;
            i15 = iM6218getTextDirections_7Xco;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            shadow2 = shadow3;
            j12 = fontSize;
            fontWeight2 = fontWeight3;
            fontStyle2 = fontStyle3;
            fontSynthesis2 = fontSynthesis3;
            str2 = fontFeatureSettings;
            j13 = letterSpacing;
            baselineShift2 = baselineShift3;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j14 = background;
            j15 = jM6214getLineHeightXSAIIZE;
            brush2 = brush;
            f7 = f9;
            i16 = iM6213getLineBreakrAG3T2k;
            textStyle2 = textStyle;
            fontFamily2 = fontFamily3;
        }
        return textStyle2.m6335copyNs73l9s(brush2, f7, j12, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j13, baselineShift2, textGeometricTransform2, localeList2, j14, textDecoration2, shadow2, drawStyle2, i14, i15, j15, textIndent2, platformTextStyle2, lineHeightStyle2, i16, i13, textMotion2);
    }

    /* renamed from: copy-aIRg9q4$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m6323copyaIRg9q4$default(TextStyle textStyle, Brush brush, float f, long j5, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j6, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j10, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j11, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        TextMotion textMotion2;
        Hyphens hyphens2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        TextAlign textAlign2;
        TextDirection textDirection2;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        LineHeightStyle lineHeightStyle2;
        Shadow shadow2;
        long j12;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        FontSynthesis fontSynthesis2;
        String str2;
        long j13;
        BaselineShift baselineShift2;
        TextGeometricTransform textGeometricTransform2;
        LocaleList localeList2;
        long j14;
        long j15;
        Brush brush2;
        float f7;
        LineBreak lineBreak2;
        TextStyle textStyle2;
        FontFamily fontFamily2;
        float alpha = (i & 2) != 0 ? textStyle.spanStyle.getAlpha() : f;
        long fontSize = (i & 4) != 0 ? textStyle.spanStyle.getFontSize() : j5;
        FontWeight fontWeight3 = (i & 8) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyle3 = (i & 16) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesis3 = (i & 32) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily3 = (i & 64) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 128) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long letterSpacing = (i & 256) != 0 ? textStyle.spanStyle.getLetterSpacing() : j6;
        BaselineShift baselineShift3 = (i & 512) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform3 = (i & 1024) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList3 = (i & 2048) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long background = (i & 4096) != 0 ? textStyle.spanStyle.getBackground() : j10;
        float f9 = alpha;
        TextDecoration background2 = (i & 8192) != 0 ? textStyle.spanStyle.getBackground() : textDecoration;
        Shadow shadow3 = (i & 16384) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        DrawStyle drawStyle3 = (i & 32768) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        TextAlign textAlignM6721boximpl = (i & 65536) != 0 ? TextAlign.m6721boximpl(textStyle.paragraphStyle.getTextAlign()) : textAlign;
        TextDirection textDirectionM6735boximpl = (i & 131072) != 0 ? TextDirection.m6735boximpl(textStyle.paragraphStyle.getTextDirection()) : textDirection;
        long jM6214getLineHeightXSAIIZE = (i & 262144) != 0 ? textStyle.paragraphStyle.getLineHeight() : j11;
        TextIndent textIndent3 = (i & 524288) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle3 = (i & 1048576) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle3 = (i & 2097152) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        LineBreak lineBreakM6629boximpl = (i & 4194304) != 0 ? LineBreak.m6629boximpl(textStyle.paragraphStyle.getLineBreak()) : lineBreak;
        Hyphens hyphensM6619boximpl = (i & 8388608) != 0 ? Hyphens.m6619boximpl(textStyle.paragraphStyle.getHyphens()) : hyphens;
        if ((i & 16777216) != 0) {
            hyphens2 = hyphensM6619boximpl;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
            textDecoration2 = background2;
            drawStyle2 = drawStyle3;
            textAlign2 = textAlignM6721boximpl;
            textDirection2 = textDirectionM6735boximpl;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            lineBreak2 = lineBreakM6629boximpl;
            shadow2 = shadow3;
            j12 = fontSize;
            fontWeight2 = fontWeight3;
            fontStyle2 = fontStyle3;
            fontSynthesis2 = fontSynthesis3;
            fontFamily2 = fontFamily3;
            str2 = fontFeatureSettings;
            j13 = letterSpacing;
            baselineShift2 = baselineShift3;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j14 = background;
            j15 = jM6214getLineHeightXSAIIZE;
            brush2 = brush;
            f7 = f9;
            textStyle2 = textStyle;
        } else {
            textMotion2 = textMotion;
            hyphens2 = hyphensM6619boximpl;
            textDecoration2 = background2;
            drawStyle2 = drawStyle3;
            textAlign2 = textAlignM6721boximpl;
            textDirection2 = textDirectionM6735boximpl;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            shadow2 = shadow3;
            j12 = fontSize;
            fontWeight2 = fontWeight3;
            fontStyle2 = fontStyle3;
            fontSynthesis2 = fontSynthesis3;
            str2 = fontFeatureSettings;
            j13 = letterSpacing;
            baselineShift2 = baselineShift3;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j14 = background;
            j15 = jM6214getLineHeightXSAIIZE;
            brush2 = brush;
            f7 = f9;
            lineBreak2 = lineBreakM6629boximpl;
            textStyle2 = textStyle;
            fontFamily2 = fontFamily3;
        }
        return textStyle2.m6336copyaIRg9q4(brush2, f7, j12, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j13, baselineShift2, textGeometricTransform2, localeList2, j14, textDecoration2, shadow2, drawStyle2, textAlign2, textDirection2, j15, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreak2, hyphens2, textMotion2);
    }

    /* renamed from: copy-p1EtxEg$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m6324copyp1EtxEg$default(TextStyle textStyle, long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i6, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, int i11, TextMotion textMotion, int i12, Object obj) {
        TextMotion textMotion2;
        int i13;
        long jM6252getColor0d7_KjU = (i12 & 1) != 0 ? textStyle.spanStyle.m6252getColor0d7_KjU() : j5;
        long fontSize = (i12 & 2) != 0 ? textStyle.spanStyle.getFontSize() : j6;
        FontWeight fontWeight2 = (i12 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyle2 = (i12 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesis2 = (i12 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily2 = (i12 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i12 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long letterSpacing = (i12 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : j10;
        BaselineShift baselineShift2 = (i12 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i12 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i12 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j13 = jM6252getColor0d7_KjU;
        long background = (i12 & 2048) != 0 ? textStyle.spanStyle.getBackground() : j11;
        TextDecoration background2 = (i12 & 4096) != 0 ? textStyle.spanStyle.getBackground() : textDecoration;
        Shadow shadow2 = (i12 & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration2 = background2;
        DrawStyle drawStyle2 = (i12 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        int iM6216getTextAligne0LSkKk = (i12 & 32768) != 0 ? textStyle.paragraphStyle.getTextAlign() : i;
        int iM6218getTextDirections_7Xco = (i12 & 65536) != 0 ? textStyle.paragraphStyle.getTextDirection() : i6;
        long jM6214getLineHeightXSAIIZE = (i12 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : j12;
        TextIndent textIndent2 = (i12 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i12 & 524288) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i12 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        int iM6213getLineBreakrAG3T2k = (i12 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : i10;
        int iM6211getHyphensvmbZdU8 = (i12 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : i11;
        if ((i12 & 8388608) != 0) {
            i13 = iM6211getHyphensvmbZdU8;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
        } else {
            textMotion2 = textMotion;
            i13 = iM6211getHyphensvmbZdU8;
        }
        return textStyle.m6337copyp1EtxEg(j13, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, background, textDecoration2, shadow2, drawStyle2, iM6216getTextAligne0LSkKk, iM6218getTextDirections_7Xco, jM6214getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, iM6213getLineBreakrAG3T2k, i13, textMotion2);
    }

    /* renamed from: copy-v2rsoow$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m6325copyv2rsoow$default(TextStyle textStyle, long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        TextMotion textMotion2;
        Hyphens hyphens2;
        long jM6252getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m6252getColor0d7_KjU() : j5;
        long fontSize = (i & 2) != 0 ? textStyle.spanStyle.getFontSize() : j6;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long letterSpacing = (i & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : j10;
        BaselineShift baselineShift2 = (i & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j13 = jM6252getColor0d7_KjU;
        long background = (i & 2048) != 0 ? textStyle.spanStyle.getBackground() : j11;
        TextDecoration background2 = (i & 4096) != 0 ? textStyle.spanStyle.getBackground() : textDecoration;
        Shadow shadow2 = (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration2 = background2;
        DrawStyle drawStyle2 = (i & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        TextAlign textAlignM6721boximpl = (i & 32768) != 0 ? TextAlign.m6721boximpl(textStyle.paragraphStyle.getTextAlign()) : textAlign;
        TextDirection textDirectionM6735boximpl = (i & 65536) != 0 ? TextDirection.m6735boximpl(textStyle.paragraphStyle.getTextDirection()) : textDirection;
        long jM6214getLineHeightXSAIIZE = (i & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : j12;
        TextIndent textIndent2 = (i & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 524288) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        LineBreak lineBreakM6629boximpl = (i & 2097152) != 0 ? LineBreak.m6629boximpl(textStyle.paragraphStyle.getLineBreak()) : lineBreak;
        Hyphens hyphensM6619boximpl = (i & 4194304) != 0 ? Hyphens.m6619boximpl(textStyle.paragraphStyle.getHyphens()) : hyphens;
        if ((i & 8388608) != 0) {
            hyphens2 = hyphensM6619boximpl;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
        } else {
            textMotion2 = textMotion;
            hyphens2 = hyphensM6619boximpl;
        }
        return textStyle.m6338copyv2rsoow(j13, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, background, textDecoration2, shadow2, drawStyle2, textAlignM6721boximpl, textDirectionM6735boximpl, jM6214getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreakM6629boximpl, hyphens2, textMotion2);
    }

    @C7.c
    /* renamed from: getHyphens-EaSxIns$annotations, reason: not valid java name */
    public static /* synthetic */ void m6326getHyphensEaSxIns$annotations() {
    }

    @C7.c
    /* renamed from: getLineBreak-LgCVezo$annotations, reason: not valid java name */
    public static /* synthetic */ void m6327getLineBreakLgCVezo$annotations() {
    }

    @C7.c
    /* renamed from: getTextAlign-buA522U$annotations, reason: not valid java name */
    public static /* synthetic */ void m6328getTextAlignbuA522U$annotations() {
    }

    @C7.c
    /* renamed from: getTextDirection-mmuk1to$annotations, reason: not valid java name */
    public static /* synthetic */ void m6329getTextDirectionmmuk1to$annotations() {
    }

    public static /* synthetic */ TextStyle merge$default(TextStyle textStyle, TextStyle textStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            textStyle2 = null;
        }
        return textStyle.merge(textStyle2);
    }

    @C7.c
    /* renamed from: copy-CXVQc50, reason: not valid java name */
    public final /* synthetic */ TextStyle m6332copyCXVQc50(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        return new TextStyle(new SpanStyle(Color.m4140equalsimpl0(color, this.spanStyle.m6252getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m6749from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, getDrawStyle(), (e) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8(), getTextMotion(), (e) null), platformStyle);
    }

    @C7.c
    /* renamed from: copy-HL5avdY, reason: not valid java name */
    public final /* synthetic */ TextStyle m6333copyHL5avdY(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent) {
        return new TextStyle(new SpanStyle(Color.m4140equalsimpl0(color, this.spanStyle.m6252getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m6749from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, this.spanStyle.getPlatformStyle(), this.spanStyle.getDrawStyle(), (e) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco(), lineHeight, textIndent, this.paragraphStyle.getPlatformStyle(), getLineHeightStyle(), m6349getLineBreakrAG3T2k(), m6346getHyphensvmbZdU8(), getTextMotion(), (e) null), this.platformStyle);
    }

    @C7.c
    /* renamed from: copy-NOaFTUo, reason: not valid java name */
    public final /* synthetic */ TextStyle m6334copyNOaFTUo(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle) {
        return new TextStyle(new SpanStyle(Color.m4140equalsimpl0(color, this.spanStyle.m6252getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m6749from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, this.spanStyle.getDrawStyle(), (e) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, m6349getLineBreakrAG3T2k(), m6346getHyphensvmbZdU8(), getTextMotion(), (e) null), platformStyle);
    }

    /* renamed from: copy-Ns73l9s, reason: not valid java name */
    public final TextStyle m6335copyNs73l9s(Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(brush, alpha, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle, (e) null), new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion, (e) null), platformStyle);
    }

    @C7.c
    /* renamed from: copy-aIRg9q4, reason: not valid java name */
    public final /* synthetic */ TextStyle m6336copyaIRg9q4(Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(brush, alpha, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle, (e) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8(), textMotion, (e) null), platformStyle);
    }

    /* renamed from: copy-p1EtxEg, reason: not valid java name */
    public final TextStyle m6337copyp1EtxEg(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(Color.m4140equalsimpl0(color, this.spanStyle.m6252getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m6749from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle, (e) null), new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion, (e) null), platformStyle);
    }

    @C7.c
    /* renamed from: copy-v2rsoow, reason: not valid java name */
    public final /* synthetic */ TextStyle m6338copyv2rsoow(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(Color.m4140equalsimpl0(color, this.spanStyle.m6252getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m6749from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle, (e) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8(), textMotion, (e) null), platformStyle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) other;
        return k.b(this.spanStyle, textStyle.spanStyle) && k.b(this.paragraphStyle, textStyle.paragraphStyle) && k.b(this.platformStyle, textStyle.platformStyle);
    }

    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m6339getBackground0d7_KjU() {
        return this.spanStyle.getBackground();
    }

    /* renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m6340getBaselineShift5SSeXJ0() {
        return this.spanStyle.getBaselineShift();
    }

    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m6341getColor0d7_KjU() {
        return this.spanStyle.m6252getColor0d7_KjU();
    }

    public final DrawStyle getDrawStyle() {
        return this.spanStyle.getDrawStyle();
    }

    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    /* renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m6342getFontSizeXSAIIZE() {
        return this.spanStyle.getFontSize();
    }

    /* renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m6343getFontStyle4Lr2A7w() {
        return this.spanStyle.getFontStyle();
    }

    /* renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m6344getFontSynthesisZQGJjVo() {
        return this.spanStyle.getFontSynthesis();
    }

    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    /* renamed from: getHyphens-EaSxIns, reason: not valid java name */
    public final Hyphens m6345getHyphensEaSxIns() {
        return Hyphens.m6619boximpl(m6346getHyphensvmbZdU8());
    }

    /* renamed from: getHyphens-vmbZdU8, reason: not valid java name */
    public final int m6346getHyphensvmbZdU8() {
        return this.paragraphStyle.getHyphens();
    }

    /* renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m6347getLetterSpacingXSAIIZE() {
        return this.spanStyle.getLetterSpacing();
    }

    /* renamed from: getLineBreak-LgCVezo, reason: not valid java name */
    public final LineBreak m6348getLineBreakLgCVezo() {
        return LineBreak.m6629boximpl(m6349getLineBreakrAG3T2k());
    }

    /* renamed from: getLineBreak-rAG3T2k, reason: not valid java name */
    public final int m6349getLineBreakrAG3T2k() {
        return this.paragraphStyle.getLineBreak();
    }

    /* renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m6350getLineHeightXSAIIZE() {
        return this.paragraphStyle.getLineHeight();
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    /* renamed from: getParagraphStyle$ui_text, reason: from getter */
    public final ParagraphStyle getParagraphStyle() {
        return this.paragraphStyle;
    }

    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    /* renamed from: getSpanStyle$ui_text, reason: from getter */
    public final SpanStyle getSpanStyle() {
        return this.spanStyle;
    }

    /* renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final TextAlign m6351getTextAlignbuA522U() {
        return TextAlign.m6721boximpl(m6352getTextAligne0LSkKk());
    }

    /* renamed from: getTextAlign-e0LSkKk, reason: not valid java name */
    public final int m6352getTextAligne0LSkKk() {
        return this.paragraphStyle.getTextAlign();
    }

    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getBackground();
    }

    /* renamed from: getTextDirection-mmuk1to, reason: not valid java name */
    public final TextDirection m6353getTextDirectionmmuk1to() {
        return TextDirection.m6735boximpl(m6354getTextDirections_7Xco());
    }

    /* renamed from: getTextDirection-s_7X-co, reason: not valid java name */
    public final int m6354getTextDirections_7Xco() {
        return this.paragraphStyle.getTextDirection();
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    public final TextMotion getTextMotion() {
        return this.paragraphStyle.getTextMotion();
    }

    public final boolean hasSameDrawAffectingAttributes(TextStyle other) {
        return this == other || this.spanStyle.hasSameNonLayoutAttributes$ui_text(other.spanStyle);
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle other) {
        if (this != other) {
            return k.b(this.paragraphStyle, other.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text(other.spanStyle);
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = (this.paragraphStyle.hashCode() + (this.spanStyle.hashCode() * 31)) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return iHashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text() {
        int iHashCode = (this.paragraphStyle.hashCode() + (this.spanStyle.hashCodeLayoutAffectingAttributes$ui_text() * 31)) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return iHashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    @Stable
    public final TextStyle merge(TextStyle other) {
        return (other == null || other.equals(Default)) ? this : new TextStyle(toSpanStyle().merge(other.toSpanStyle()), toParagraphStyle().merge(other.toParagraphStyle()));
    }

    @Stable
    @C7.c
    /* renamed from: merge-Z1GrekI, reason: not valid java name */
    public final /* synthetic */ TextStyle m6355mergeZ1GrekI(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, PlatformTextStyle platformStyle, TextMotion textMotion) {
        SpanStyle spanStyleM6257fastMergedSHsh3o = SpanStyleKt.m6257fastMergedSHsh3o(this.spanStyle, color, null, Float.NaN, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle);
        ParagraphStyle paragraphStyleM6219fastMergej5T8yCg = ParagraphStyleKt.m6219fastMergej5T8yCg(this.paragraphStyle, textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8(), textMotion);
        return (this.spanStyle == spanStyleM6257fastMergedSHsh3o && this.paragraphStyle == paragraphStyleM6219fastMergej5T8yCg) ? this : new TextStyle(spanStyleM6257fastMergedSHsh3o, paragraphStyleM6219fastMergej5T8yCg);
    }

    @Stable
    /* renamed from: merge-dA7vx0o, reason: not valid java name */
    public final TextStyle m6356mergedA7vx0o(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, PlatformTextStyle platformStyle, TextMotion textMotion) {
        SpanStyle spanStyleM6257fastMergedSHsh3o = SpanStyleKt.m6257fastMergedSHsh3o(this.spanStyle, color, null, Float.NaN, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle);
        ParagraphStyle paragraphStyleM6219fastMergej5T8yCg = ParagraphStyleKt.m6219fastMergej5T8yCg(this.paragraphStyle, textAlign, textDirection, lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion);
        return (this.spanStyle == spanStyleM6257fastMergedSHsh3o && this.paragraphStyle == paragraphStyleM6219fastMergej5T8yCg) ? this : new TextStyle(spanStyleM6257fastMergedSHsh3o, paragraphStyleM6219fastMergej5T8yCg);
    }

    @Stable
    public final TextStyle plus(TextStyle other) {
        return merge(other);
    }

    @Stable
    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    @Stable
    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    public String toString() {
        return "TextStyle(color=" + ((Object) Color.m4147toStringimpl(m6341getColor0d7_KjU())) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + ((Object) TextUnit.m7045toStringimpl(m6342getFontSizeXSAIIZE())) + ", fontWeight=" + getFontWeight() + ", fontStyle=" + m6343getFontStyle4Lr2A7w() + ", fontSynthesis=" + m6344getFontSynthesisZQGJjVo() + ", fontFamily=" + getFontFamily() + ", fontFeatureSettings=" + getFontFeatureSettings() + ", letterSpacing=" + ((Object) TextUnit.m7045toStringimpl(m6347getLetterSpacingXSAIIZE())) + ", baselineShift=" + m6340getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + getTextGeometricTransform() + ", localeList=" + getLocaleList() + ", background=" + ((Object) Color.m4147toStringimpl(m6339getBackground0d7_KjU())) + ", textDecoration=" + getTextDecoration() + ", shadow=" + getShadow() + ", drawStyle=" + getDrawStyle() + ", textAlign=" + ((Object) TextAlign.m6726toStringimpl(m6352getTextAligne0LSkKk())) + ", textDirection=" + ((Object) TextDirection.m6740toStringimpl(m6354getTextDirections_7Xco())) + ", lineHeight=" + ((Object) TextUnit.m7045toStringimpl(m6350getLineHeightXSAIIZE())) + ", textIndent=" + getTextIndent() + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + getLineHeightStyle() + ", lineBreak=" + ((Object) LineBreak.m6640toStringimpl(m6349getLineBreakrAG3T2k())) + ", hyphens=" + ((Object) Hyphens.m6624toStringimpl(m6346getHyphensvmbZdU8())) + ", textMotion=" + getTextMotion() + ')';
    }

    @C7.c
    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, e eVar) {
        this(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j10, baselineShift, textGeometricTransform, localeList, j11, textDecoration, shadow, drawStyle, textAlign, textDirection, j12, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    @Stable
    public final TextStyle plus(ParagraphStyle other) {
        return merge(other);
    }

    @C7.c
    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, e eVar) {
        this(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j10, baselineShift, textGeometricTransform, localeList, j11, textDecoration, shadow, textAlign, textDirection, j12, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens);
    }

    @Stable
    public final TextStyle plus(SpanStyle other) {
        return merge(other);
    }

    @C7.c
    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, e eVar) {
        this(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j10, baselineShift, textGeometricTransform, localeList, j11, textDecoration, shadow, textAlign, textDirection, j12, textIndent, platformTextStyle, lineHeightStyle);
    }

    @C7.c
    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, e eVar) {
        this(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j10, baselineShift, textGeometricTransform, localeList, j11, textDecoration, shadow, textAlign, textDirection, j12, textIndent);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j5, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j6, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j10, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i6, long j11, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, int i11, TextMotion textMotion, e eVar) {
        this(brush, f, j5, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j6, baselineShift, textGeometricTransform, localeList, j10, textDecoration, shadow, drawStyle, i, i6, j11, textIndent, platformTextStyle, lineHeightStyle, i10, i11, textMotion);
    }

    @C7.c
    public /* synthetic */ TextStyle(Brush brush, float f, long j5, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j6, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j10, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j11, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, e eVar) {
        this(brush, f, j5, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j6, baselineShift, textGeometricTransform, localeList, j10, textDecoration, shadow, drawStyle, textAlign, textDirection, j11, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    @Stable
    public final TextStyle merge(SpanStyle other) {
        return new TextStyle(toSpanStyle().merge(other), toParagraphStyle());
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle) {
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformTextStyle;
    }

    @Stable
    public final TextStyle merge(ParagraphStyle other) {
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(other));
    }

    public /* synthetic */ TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle, int i, e eVar) {
        this(spanStyle, paragraphStyle, (i & 4) != 0 ? null : platformTextStyle);
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        this(spanStyle, paragraphStyle, TextStyleKt.createPlatformTextStyleInternal(spanStyle.getPlatformStyle(), paragraphStyle.getPlatformStyle()));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, int i, e eVar) {
        long jM4175getUnspecified0d7_KjU = (i & 1) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j5;
        long jM7049getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j6;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long jM7049getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j10;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long jM4175getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j11;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j13 = jM4175getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        TextAlign textAlign2 = (i & 16384) != 0 ? null : textAlign;
        TextDirection textDirection2 = (i & 32768) != 0 ? null : textDirection;
        long jM7049getUnspecifiedXSAIIZE3 = (i & 65536) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j12;
        long j14 = jM7049getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j15 = jM7049getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j16 = jM4175getUnspecified0d7_KjU2;
        this(j13, j14, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j15, baselineShift3, textGeometricTransform3, localeList3, j16, textDecoration3, shadow2, textAlign2, textDirection2, jM7049getUnspecifiedXSAIIZE3, (i & 131072) != 0 ? null : textIndent, null);
    }

    private TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent) {
        SpanStyle spanStyle = new SpanStyle(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j10, baselineShift, textGeometricTransform, localeList, j11, textDecoration, shadow, (PlatformSpanStyle) null, (DrawStyle) null, (e) null);
        this(spanStyle, new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco(), j12, textIndent, (PlatformParagraphStyle) null, (LineHeightStyle) null, LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k(), Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8(), (TextMotion) null, (e) null), null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i, e eVar) {
        long jM4175getUnspecified0d7_KjU = (i & 1) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j5;
        long jM7049getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j6;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long jM7049getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j10;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long jM4175getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j11;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j13 = jM4175getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        TextAlign textAlign2 = (i & 16384) != 0 ? null : textAlign;
        TextDirection textDirection2 = (i & 32768) != 0 ? null : textDirection;
        long jM7049getUnspecifiedXSAIIZE3 = (i & 65536) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j12;
        TextIndent textIndent2 = (i & 131072) != 0 ? null : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 262144) != 0 ? null : platformTextStyle;
        long j14 = jM7049getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j15 = jM7049getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j16 = jM4175getUnspecified0d7_KjU2;
        this(j13, j14, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j15, baselineShift3, textGeometricTransform3, localeList3, j16, textDecoration3, shadow2, textAlign2, textDirection2, jM7049getUnspecifiedXSAIIZE3, textIndent2, platformTextStyle2, (i & 524288) != 0 ? null : lineHeightStyle, null);
    }

    private TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle) {
        this(new SpanStyle(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j10, baselineShift, textGeometricTransform, localeList, j11, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (DrawStyle) null, (e) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco(), j12, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k(), Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8(), (TextMotion) null, (e) null), platformTextStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i, e eVar) {
        long jM4175getUnspecified0d7_KjU = (i & 1) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j5;
        long jM7049getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j6;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long jM7049getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j10;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long jM4175getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j11;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j13 = jM4175getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        TextAlign textAlign2 = (i & 16384) != 0 ? null : textAlign;
        TextDirection textDirection2 = (i & 32768) != 0 ? null : textDirection;
        long jM7049getUnspecifiedXSAIIZE3 = (i & 65536) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j12;
        TextIndent textIndent2 = (i & 131072) != 0 ? null : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 262144) != 0 ? null : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 524288) != 0 ? null : lineHeightStyle;
        LineBreak lineBreak2 = (i & 1048576) != 0 ? null : lineBreak;
        long j14 = jM7049getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j15 = jM7049getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j16 = jM4175getUnspecified0d7_KjU2;
        this(j13, j14, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j15, baselineShift3, textGeometricTransform3, localeList3, j16, textDecoration3, shadow2, textAlign2, textDirection2, jM7049getUnspecifiedXSAIIZE3, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreak2, (i & 2097152) != 0 ? null : hyphens, null);
    }

    private TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        SpanStyle spanStyle = new SpanStyle(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j10, baselineShift, textGeometricTransform, localeList, j11, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (DrawStyle) null, 32768, (e) null);
        int value = textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk();
        int value2 = textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco();
        PlatformParagraphStyle paragraphStyle = platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null;
        this(spanStyle, new ParagraphStyle(value, value2, j12, textIndent, paragraphStyle, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8(), (TextMotion) null, 256, (e) null), platformTextStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, e eVar) {
        long jM4175getUnspecified0d7_KjU = (i & 1) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j5;
        long jM7049getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j6;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long jM7049getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j10;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long jM4175getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j11;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j13 = jM4175getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        DrawStyle drawStyle2 = (i & 16384) != 0 ? null : drawStyle;
        TextAlign textAlign2 = (i & 32768) != 0 ? null : textAlign;
        TextDirection textDirection2 = (i & 65536) != 0 ? null : textDirection;
        long jM7049getUnspecifiedXSAIIZE3 = (i & 131072) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j12;
        TextIndent textIndent2 = (i & 262144) != 0 ? null : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 524288) != 0 ? null : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 1048576) != 0 ? null : lineHeightStyle;
        LineBreak lineBreak2 = (i & 2097152) != 0 ? null : lineBreak;
        Hyphens hyphens2 = (i & 4194304) != 0 ? null : hyphens;
        long j14 = jM7049getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j15 = jM7049getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j16 = jM4175getUnspecified0d7_KjU2;
        this(j13, j14, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j15, baselineShift3, textGeometricTransform3, localeList3, j16, textDecoration3, shadow2, drawStyle2, textAlign2, textDirection2, jM7049getUnspecifiedXSAIIZE3, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreak2, hyphens2, (i & 8388608) != 0 ? null : textMotion, (e) null);
    }

    private TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this(new SpanStyle(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j10, baselineShift, textGeometricTransform, localeList, j11, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (e) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco(), j12, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8(), textMotion, (e) null), platformTextStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i6, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, int i11, TextMotion textMotion, int i12, e eVar) {
        long jM4175getUnspecified0d7_KjU = (i12 & 1) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j5;
        long jM7049getUnspecifiedXSAIIZE = (i12 & 2) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j6;
        FontWeight fontWeight2 = (i12 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i12 & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i12 & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i12 & 32) != 0 ? null : fontFamily;
        String str2 = (i12 & 64) != 0 ? null : str;
        long jM7049getUnspecifiedXSAIIZE2 = (i12 & 128) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j10;
        BaselineShift baselineShift2 = (i12 & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i12 & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i12 & 1024) != 0 ? null : localeList;
        long jM4175getUnspecified0d7_KjU2 = (i12 & 2048) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j11;
        TextDecoration textDecoration2 = (i12 & 4096) != 0 ? null : textDecoration;
        long j13 = jM4175getUnspecified0d7_KjU;
        Shadow shadow2 = (i12 & 8192) != 0 ? null : shadow;
        DrawStyle drawStyle2 = (i12 & 16384) != 0 ? null : drawStyle;
        int iM6734getUnspecifiede0LSkKk = (i12 & 32768) != 0 ? TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk() : i;
        int iM6747getUnspecifieds_7Xco = (i12 & 65536) != 0 ? TextDirection.INSTANCE.m6747getUnspecifieds_7Xco() : i6;
        long jM7049getUnspecifiedXSAIIZE3 = (i12 & 131072) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j12;
        TextIndent textIndent2 = (i12 & 262144) != 0 ? null : textIndent;
        PlatformTextStyle platformTextStyle2 = (i12 & 524288) != 0 ? null : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i12 & 1048576) != 0 ? null : lineHeightStyle;
        int iM6649getUnspecifiedrAG3T2k = (i12 & 2097152) != 0 ? LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k() : i10;
        int iM6628getUnspecifiedvmbZdU8 = (i12 & 4194304) != 0 ? Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8() : i11;
        long j14 = jM7049getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j15 = jM7049getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j16 = jM4175getUnspecified0d7_KjU2;
        this(j13, j14, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j15, baselineShift3, textGeometricTransform3, localeList3, j16, textDecoration3, shadow2, drawStyle2, iM6734getUnspecifiede0LSkKk, iM6747getUnspecifieds_7Xco, jM7049getUnspecifiedXSAIIZE3, textIndent2, platformTextStyle2, lineHeightStyle2, iM6649getUnspecifiedrAG3T2k, iM6628getUnspecifiedvmbZdU8, (i12 & 8388608) != 0 ? null : textMotion, (e) null);
    }

    private TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j10, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j11, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i6, long j12, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, int i11, TextMotion textMotion) {
        this(new SpanStyle(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j10, baselineShift, textGeometricTransform, localeList, j11, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (e) null), new ParagraphStyle(i, i6, j12, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i10, i11, textMotion, (e) null), platformTextStyle);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j5, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j6, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j10, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i6, long j11, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, int i11, TextMotion textMotion, int i12, e eVar) {
        this(brush, (i12 & 2) != 0 ? Float.NaN : f, (i12 & 4) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j5, (i12 & 8) != 0 ? null : fontWeight, (i12 & 16) != 0 ? null : fontStyle, (i12 & 32) != 0 ? null : fontSynthesis, (i12 & 64) != 0 ? null : fontFamily, (i12 & 128) != 0 ? null : str, (i12 & 256) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j6, (i12 & 512) != 0 ? null : baselineShift, (i12 & 1024) != 0 ? null : textGeometricTransform, (i12 & 2048) != 0 ? null : localeList, (i12 & 4096) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j10, (i12 & 8192) != 0 ? null : textDecoration, (i12 & 16384) != 0 ? null : shadow, (32768 & i12) != 0 ? null : drawStyle, (65536 & i12) != 0 ? TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk() : i, (131072 & i12) != 0 ? TextDirection.INSTANCE.m6747getUnspecifieds_7Xco() : i6, (262144 & i12) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j11, (524288 & i12) != 0 ? null : textIndent, (1048576 & i12) != 0 ? null : platformTextStyle, (2097152 & i12) != 0 ? null : lineHeightStyle, (4194304 & i12) != 0 ? LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k() : i10, (8388608 & i12) != 0 ? Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8() : i11, (i12 & 16777216) != 0 ? null : textMotion, (e) null);
    }

    private TextStyle(Brush brush, float f, long j5, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j6, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j10, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i6, long j11, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, int i11, TextMotion textMotion) {
        this(new SpanStyle(brush, f, j5, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j6, baselineShift, textGeometricTransform, localeList, j10, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (e) null), new ParagraphStyle(i, i6, j11, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i10, i11, textMotion, (e) null), platformTextStyle);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j5, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j6, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j10, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j11, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, e eVar) {
        this(brush, (i & 2) != 0 ? Float.NaN : f, (i & 4) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j5, (i & 8) != 0 ? null : fontWeight, (i & 16) != 0 ? null : fontStyle, (i & 32) != 0 ? null : fontSynthesis, (i & 64) != 0 ? null : fontFamily, (i & 128) != 0 ? null : str, (i & 256) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j6, (i & 512) != 0 ? null : baselineShift, (i & 1024) != 0 ? null : textGeometricTransform, (i & 2048) != 0 ? null : localeList, (i & 4096) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j10, (i & 8192) != 0 ? null : textDecoration, (i & 16384) != 0 ? null : shadow, (32768 & i) != 0 ? null : drawStyle, (65536 & i) != 0 ? null : textAlign, (131072 & i) != 0 ? null : textDirection, (262144 & i) != 0 ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : j11, (524288 & i) != 0 ? null : textIndent, (1048576 & i) != 0 ? null : platformTextStyle, (2097152 & i) != 0 ? null : lineHeightStyle, (4194304 & i) != 0 ? null : lineBreak, (8388608 & i) != 0 ? null : hyphens, (i & 16777216) != 0 ? null : textMotion, (e) null);
    }

    private TextStyle(Brush brush, float f, long j5, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j6, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j10, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j11, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this(new SpanStyle(brush, f, j5, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j6, baselineShift, textGeometricTransform, localeList, j10, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (e) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6734getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6747getUnspecifieds_7Xco(), j11, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8(), textMotion, (e) null), platformTextStyle);
    }
}
