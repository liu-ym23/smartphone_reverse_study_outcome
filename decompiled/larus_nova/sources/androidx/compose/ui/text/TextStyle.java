package androidx.compose.ui.text;

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
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b]\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 ¤\u00012\u00020\u0001:\u0002¤\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nB×\u0001\b\u0017\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+¢\u0006\u0004\b\b\u0010,Bï\u0001\b\u0017\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.¢\u0006\u0004\b\b\u0010/B\u0087\u0002\b\u0017\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103¢\u0006\u0004\b\b\u00104B\u009f\u0002\b\u0017\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b\b\u00109B\u0097\u0002\b\u0016\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u000201\u0012\b\b\u0002\u00102\u001a\u000203\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b\b\u0010:B¡\u0002\b\u0016\u0012\b\u0010;\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010=\u001a\u00020>\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u000201\u0012\b\b\u0002\u00102\u001a\u000203\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b\b\u0010?B©\u0002\b\u0017\u0012\b\u0010;\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010=\u001a\u00020>\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b\b\u0010@J\b\u0010G\u001a\u00020\u0003H\u0007J\b\u0010H\u001a\u00020\u0005H\u0007J\u0014\u0010I\u001a\u00020\u00002\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0000H\u0007J\u009d\u0002\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0004\bK\u0010LJ¥\u0002\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0004\bM\u0010NJ\u0010\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0003H\u0007J\u0010\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0005H\u0007J\u0011\u0010O\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0087\u0002J\u0011\u0010O\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0005H\u0087\u0002J\u0011\u0010O\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0003H\u0087\u0002JÝ\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0004\bQ\u0010RJõ\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0004\bS\u0010TJ\u008d\u0002\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0004\bU\u0010VJ¥\u0002\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0004\bW\u0010XJ\u009b\u0002\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\bY\u0010ZJ¯\u0002\u0010P\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010=\u001a\u00020>2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0004\b[\u0010\\J¥\u0002\u0010P\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010=\u001a\u00020>2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b]\u0010^J\u0015\u0010\u009b\u0001\u001a\u00030\u009c\u00012\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010\u009d\u0001\u001a\u00030\u009c\u00012\u0006\u0010J\u001a\u00020\u0000J\u0010\u0010\u009e\u0001\u001a\u00030\u009c\u00012\u0006\u0010J\u001a\u00020\u0000J\n\u0010\u009f\u0001\u001a\u00030 \u0001H\u0016J\u0010\u0010¡\u0001\u001a\u00030 \u0001H\u0000¢\u0006\u0003\b¢\u0001J\t\u0010£\u0001\u001a\u00020\u0018H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010;\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0011\u0010=\u001a\u00020>8F¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\be\u0010bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0011\u0010\u0019\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bp\u0010bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0011\u0010 \u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bw\u0010bR\u0013\u0010!\u001a\u0004\u0018\u00010\"8F¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0013\u0010#\u001a\u0004\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0013\u00105\u001a\u0004\u0018\u0001068F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR!\u0010\u0080\u0001\u001a\u0004\u0018\u00010&8GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0012\u0010'\u001a\u00020(8F¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010\u007fR!\u0010\u0086\u0001\u001a\u0004\u0018\u00010(8GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0087\u0001\u0010\u0082\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0012\u0010)\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010bR\u0015\u0010*\u001a\u0004\u0018\u00010+8F¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0015\u0010-\u001a\u0004\u0018\u00010.8F¢\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0012\u00102\u001a\u0002038F¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010\u007fR!\u0010\u0090\u0001\u001a\u0004\u0018\u0001038GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0091\u0001\u0010\u0082\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0012\u00100\u001a\u0002018F¢\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010\u007fR!\u0010\u0095\u0001\u001a\u0004\u0018\u0001018GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0096\u0001\u0010\u0082\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0015\u00107\u001a\u0004\u0018\u0001088F¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001¨\u0006¥\u0001"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "platformStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "<init>", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformTextStyle;)V", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroidx/compose/ui/graphics/Shadow;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSpanStyle$ui_text", "()Landroidx/compose/ui/text/SpanStyle;", "getParagraphStyle$ui_text", "()Landroidx/compose/ui/text/ParagraphStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", "toSpanStyle", "toParagraphStyle", "merge", "other", "merge-dA7vx0o", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "merge-Z1GrekI", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "plus", "copy", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "copy-NOaFTUo", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/TextStyle;", "copy-CXVQc50", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/TextStyle;", "copy-v2rsoow", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-p1EtxEg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-aIRg9q4", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-Ns73l9s", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "()J", "getAlpha", "()F", "getFontSize-XSAIIZE", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getLetterSpacing-XSAIIZE", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getBackground-0d7_KjU", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getTextAlign-e0LSkKk", "()I", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "()V", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDirection-s_7X-co", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getLineHeight-XSAIIZE", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getHyphens-vmbZdU8", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "getLineBreak-rAG3T2k", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "equals", "", "hasSameLayoutAffectingAttributes", "hasSameDrawAffectingAttributes", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text", "toString", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextStyle {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final TextStyle Default = null;
    private final ParagraphStyle paragraphStyle;
    private final PlatformTextStyle platformStyle;
    private final SpanStyle spanStyle;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextStyle$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        public final TextStyle getDefault() {
            return TextStyle.access$getDefault$cp();
        }
    }

    public /* synthetic */ TextStyle(long r100, long r101, FontWeight r102, FontStyle r103, FontSynthesis r104, FontFamily r105, String r106, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, DrawStyle r117, int r210, int r211, long r212, TextIndent r213, PlatformTextStyle r214, LineHeightStyle r215, int r216, int r217, TextMotion r218, DefaultConstructorMarker r310) {
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ TextStyle(long r100, long r101, FontWeight r102, FontStyle r103, FontSynthesis r104, FontFamily r105, String r106, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, DrawStyle r117, TextAlign r210, TextDirection r211, long r212, TextIndent r213, PlatformTextStyle r214, LineHeightStyle r215, LineBreak r216, Hyphens r217, TextMotion r218, DefaultConstructorMarker r310) {
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like TextMotion are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long r100, long r101, FontWeight r102, FontStyle r103, FontSynthesis r104, FontFamily r105, String r106, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, TextAlign r117, TextDirection r210, long r211, TextIndent r212, PlatformTextStyle r213, LineHeightStyle r214, LineBreak r215, Hyphens r216, DefaultConstructorMarker r217) {
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long r100, long r101, FontWeight r102, FontStyle r103, FontSynthesis r104, FontFamily r105, String r106, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, TextAlign r117, TextDirection r210, long r211, TextIndent r212, PlatformTextStyle r213, LineHeightStyle r214, DefaultConstructorMarker r215) {
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long r100, long r101, FontWeight r102, FontStyle r103, FontSynthesis r104, FontFamily r105, String r106, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, TextAlign r117, TextDirection r210, long r211, TextIndent r212, DefaultConstructorMarker r213) {
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212);
    }

    public /* synthetic */ TextStyle(Brush r100, float r101, long r102, FontWeight r103, FontStyle r104, FontSynthesis r105, FontFamily r106, String r107, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, DrawStyle r117, int r210, int r211, long r212, TextIndent r213, PlatformTextStyle r214, LineHeightStyle r215, int r216, int r217, TextMotion r218, DefaultConstructorMarker r310) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ TextStyle(Brush r100, float r101, long r102, FontWeight r103, FontStyle r104, FontSynthesis r105, FontFamily r106, String r107, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, DrawStyle r117, TextAlign r210, TextDirection r211, long r212, TextIndent r213, PlatformTextStyle r214, LineHeightStyle r215, LineBreak r216, Hyphens r217, TextMotion r218, DefaultConstructorMarker r310) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getHyphens-EaSxIns$annotations, reason: not valid java name */
    public static /* synthetic */ void m7013getHyphensEaSxIns$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getLineBreak-LgCVezo$annotations, reason: not valid java name */
    public static /* synthetic */ void m7014getLineBreakLgCVezo$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getTextAlign-buA522U$annotations, reason: not valid java name */
    public static /* synthetic */ void m7015getTextAlignbuA522U$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getTextDirection-mmuk1to$annotations, reason: not valid java name */
    public static /* synthetic */ void m7016getTextDirectionmmuk1to$annotations() {
    }

    static {
        Companion = new Companion(null);
        Default = new TextStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777215, null);
    }

    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m7026getBackground0d7_KjU() {
        return this.spanStyle.m6937getBackground0d7_KjU();
    }

    /* JADX INFO: renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m7027getBaselineShift5SSeXJ0() {
        return this.spanStyle.m6938getBaselineShift5SSeXJ0();
    }

    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m7028getColor0d7_KjU() {
        return this.spanStyle.m6939getColor0d7_KjU();
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

    /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m7029getFontSizeXSAIIZE() {
        return this.spanStyle.m6940getFontSizeXSAIIZE();
    }

    /* JADX INFO: renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m7030getFontStyle4Lr2A7w() {
        return this.spanStyle.m6941getFontStyle4Lr2A7w();
    }

    /* JADX INFO: renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m7031getFontSynthesisZQGJjVo() {
        return this.spanStyle.m6942getFontSynthesisZQGJjVo();
    }

    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    /* JADX INFO: renamed from: getHyphens-vmbZdU8, reason: not valid java name */
    public final int m7033getHyphensvmbZdU8() {
        return this.paragraphStyle.m6898getHyphensvmbZdU8();
    }

    /* JADX INFO: renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m7034getLetterSpacingXSAIIZE() {
        return this.spanStyle.m6943getLetterSpacingXSAIIZE();
    }

    /* JADX INFO: renamed from: getLineBreak-rAG3T2k, reason: not valid java name */
    public final int m7036getLineBreakrAG3T2k() {
        return this.paragraphStyle.m6900getLineBreakrAG3T2k();
    }

    /* JADX INFO: renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m7037getLineHeightXSAIIZE() {
        return this.paragraphStyle.m6901getLineHeightXSAIIZE();
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    /* JADX INFO: renamed from: getTextAlign-e0LSkKk, reason: not valid java name */
    public final int m7039getTextAligne0LSkKk() {
        return this.paragraphStyle.m6903getTextAligne0LSkKk();
    }

    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    /* JADX INFO: renamed from: getTextDirection-s_7X-co, reason: not valid java name */
    public final int m7041getTextDirections_7Xco() {
        return this.paragraphStyle.m6905getTextDirections_7Xco();
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

    public int hashCode() {
        int r100 = ((this.spanStyle.hashCode() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle r101 = this.platformStyle;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text() {
        int r100 = ((this.spanStyle.hashCodeLayoutAffectingAttributes$ui_text() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle r101 = this.platformStyle;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "TextStyle(color=" + Color.m4835toStringimpl(m7028getColor0d7_KjU()) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + TextUnit.m7749toStringimpl(m7029getFontSizeXSAIIZE()) + ", fontWeight=" + getFontWeight() + ", fontStyle=" + m7030getFontStyle4Lr2A7w() + ", fontSynthesis=" + m7031getFontSynthesisZQGJjVo() + ", fontFamily=" + getFontFamily() + ", fontFeatureSettings=" + getFontFeatureSettings() + ", letterSpacing=" + TextUnit.m7749toStringimpl(m7034getLetterSpacingXSAIIZE()) + ", baselineShift=" + m7027getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + getTextGeometricTransform() + ", localeList=" + getLocaleList() + ", background=" + Color.m4835toStringimpl(m7026getBackground0d7_KjU()) + ", textDecoration=" + getTextDecoration() + ", shadow=" + getShadow() + ", drawStyle=" + getDrawStyle() + ", textAlign=" + TextAlign.m7416toStringimpl(m7039getTextAligne0LSkKk()) + ", textDirection=" + TextDirection.m7430toStringimpl(m7041getTextDirections_7Xco()) + ", lineHeight=" + TextUnit.m7749toStringimpl(m7037getLineHeightXSAIIZE()) + ", textIndent=" + getTextIndent() + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + getLineHeightStyle() + ", lineBreak=" + LineBreak.m7330toStringimpl(m7036getLineBreakrAG3T2k()) + ", hyphens=" + Hyphens.m7314toStringimpl(m7033getHyphensvmbZdU8()) + ", textMotion=" + getTextMotion() + ')';
    }

    /* JADX INFO: renamed from: getHyphens-EaSxIns, reason: not valid java name */
    public final Hyphens m7032getHyphensEaSxIns() {
        return Hyphens.m7309boximpl(m7033getHyphensvmbZdU8());
    }

    /* JADX INFO: renamed from: getLineBreak-LgCVezo, reason: not valid java name */
    public final LineBreak m7035getLineBreakLgCVezo() {
        return LineBreak.m7319boximpl(m7036getLineBreakrAG3T2k());
    }

    /* JADX INFO: renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final TextAlign m7038getTextAlignbuA522U() {
        return TextAlign.m7411boximpl(m7039getTextAligne0LSkKk());
    }

    /* JADX INFO: renamed from: getTextDirection-mmuk1to, reason: not valid java name */
    public final TextDirection m7040getTextDirectionmmuk1to() {
        return TextDirection.m7425boximpl(m7041getTextDirections_7Xco());
    }

    public static final /* synthetic */ TextStyle access$getDefault$cp() {
        return Default;
    }

    public final ParagraphStyle getParagraphStyle$ui_text() {
        return this.paragraphStyle;
    }

    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final SpanStyle getSpanStyle$ui_text() {
        return this.spanStyle;
    }

    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextStyle) == true) goto L8;
        return false;
    L8:
        TextStyle r101 = (TextStyle) r100;
        if (Intrinsics.areEqual(this.spanStyle, r101.spanStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.paragraphStyle, r101.paragraphStyle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.platformStyle, r101.platformStyle) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean hasSameDrawAffectingAttributes(TextStyle r100) {
        if (this != r100) goto L4;
    L7:
        return true;
    L4:
        if (this.spanStyle.hasSameNonLayoutAttributes$ui_text(r100.spanStyle) == true) goto L7;
        return false;
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle r100) {
        if (this != r100) goto L4;
    L9:
        return true;
    L4:
        if (Intrinsics.areEqual(this.paragraphStyle, r100.paragraphStyle) == true) goto L6;
    L8:
        return false;
    L6:
        if (this.spanStyle.hasSameLayoutAffectingAttributes$ui_text(r100.spanStyle) == false) goto L8;
        goto L8
    }

    public final TextStyle merge(TextStyle r100) {
        if (r100 != null) goto L4;
    L8:
        return this;
    L4:
        if (Intrinsics.areEqual(r100, Default) == true) goto L8;
        return new TextStyle(toSpanStyle().merge(r100.toSpanStyle()), toParagraphStyle().merge(r100.toParagraphStyle()));
    }

    public final TextStyle plus(ParagraphStyle r100) {
        return merge(r100);
    }

    public final TextStyle merge(ParagraphStyle r100) {
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(r100));
    }

    public final TextStyle plus(SpanStyle r100) {
        return merge(r100);
    }

    public final TextStyle merge(SpanStyle r100) {
        return new TextStyle(toSpanStyle().merge(r100), toParagraphStyle());
    }

    public final TextStyle plus(TextStyle r100) {
        return merge(r100);
    }

    public TextStyle(SpanStyle r100, ParagraphStyle r101) {
        this(r100, r101, TextStyleKt.access$createPlatformTextStyleInternal(r100.getPlatformStyle(), r101.getPlatformStyle()));
    }

    public TextStyle(SpanStyle r100, ParagraphStyle r101, PlatformTextStyle r102) {
        this.spanStyle = r100;
        this.paragraphStyle = r101;
        this.platformStyle = r102;
    }

    public static /* synthetic */ TextStyle merge$default(TextStyle r100, TextStyle r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.merge(r101);
    }

    public /* synthetic */ TextStyle(SpanStyle r100, ParagraphStyle r101, PlatformTextStyle r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }

    private TextStyle(long r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r214, FontFamily r310, String r311, long r312, BaselineShift r313, TextGeometricTransform r314, LocaleList r315, long r316, TextDecoration r317, Shadow r410, TextAlign r411, TextDirection r412, long r413, TextIndent r414) {
        SpanStyle r100 = new SpanStyle(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r410, null, null, null);
        if (r411 == null) goto L5;
        int r101 = r411.m7417unboximpl();
    L6:
        if (r412 == null) goto L8;
        int r102 = r412.m7431unboximpl();
    L9:
        int r215 = r101;
        int r216 = r102;
        this(r100, new ParagraphStyle(r215, r216, r413, r414, null, null, LineBreak.Companion.m7339getUnspecifiedrAG3T2k(), Hyphens.Companion.m7318getUnspecifiedvmbZdU8(), null, null), null);
        return;
    L8:
        r102 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L9
    L5:
        r101 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-HL5avdY, reason: not valid java name */
    public final /* synthetic */ TextStyle m7020copyHL5avdY(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r318, long r410, TextDecoration r411, Shadow r412, TextAlign r413, TextDirection r414, long r415, TextIndent r416) {
        if (Color.m4828equalsimpl0(r210, this.spanStyle.m6939getColor0d7_KjU()) == false) goto L5;
        TextForegroundStyle r100 = this.spanStyle.getTextForegroundStyle$ui_text();
    L6:
        SpanStyle r110 = new SpanStyle(r100, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, this.spanStyle.getPlatformStyle(), this.spanStyle.getDrawStyle(), null);
        if (r413 == null) goto L9;
        int r101 = r413.m7417unboximpl();
    L10:
        if (r414 == null) goto L12;
        int r102 = r414.m7431unboximpl();
    L13:
        int r212 = r101;
        int r213 = r102;
        return new TextStyle(r110, new ParagraphStyle(r212, r213, r415, r416, this.paragraphStyle.getPlatformStyle(), getLineHeightStyle(), m7036getLineBreakrAG3T2k(), m7033getHyphensvmbZdU8(), getTextMotion(), null), this.platformStyle);
    L12:
        r102 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L13
    L9:
        r101 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L10
    L5:
        r100 = TextForegroundStyle.Companion.m7439from8_81llA(r210);
        goto L6
    }

    public /* synthetic */ TextStyle(long r210, long r211, FontWeight r212, FontStyle r310, FontSynthesis r311, FontFamily r312, String r313, long r314, BaselineShift r315, TextGeometricTransform r316, LocaleList r317, long r318, TextDecoration r410, Shadow r411, TextAlign r412, TextDirection r413, long r414, TextIndent r415, int r416, DefaultConstructorMarker r417) {
        if ((r416 & 1) == 0) goto L5;
        long r100 = Color.Companion.m4863getUnspecified0d7_KjU();
    L7:
        if ((r416 & 2) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r416 & 4) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r416 & 8) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r416 & 16) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r416 & 32) == 0) goto L25;
        FontFamily r105 = null;
    L27:
        if ((r416 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r416 & 128) == 0) goto L33;
        long r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r416 & 256) == 0) goto L37;
        BaselineShift r112 = null;
    L39:
        if ((r416 & 512) == 0) goto L41;
        TextGeometricTransform r113 = null;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        LocaleList r114 = null;
    L47:
        if ((r416 & 2048) == 0) goto L49;
        long r115 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r416 & 4096) == 0) goto L53;
        TextDecoration r106 = null;
    L54:
        TextDecoration r116 = r106;
        if ((r416 & 8192) == 0) goto L57;
        Shadow r107 = null;
    L58:
        Shadow r117 = r107;
        if ((r416 & 16384) == 0) goto L61;
        TextAlign r108 = null;
    L63:
        if ((r416 & 32768) == 0) goto L65;
        TextDirection r213 = null;
    L67:
        if ((r416 & 65536) == 0) goto L69;
        long r214 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L71:
        if ((r416 & 131072) == 0) goto L73;
        TextIndent r109 = null;
    L74:
        long r215 = r100;
        long r216 = r101;
        FontWeight r319 = r102;
        FontStyle r320 = r103;
        FontSynthesis r321 = r104;
        FontFamily r322 = r105;
        String r323 = r110;
        long r324 = r111;
        BaselineShift r325 = r112;
        TextGeometricTransform r326 = r113;
        LocaleList r327 = r114;
        long r418 = r115;
        TextAlign r419 = r108;
        TextDirection r420 = r213;
        long r421 = r214;
        TextIndent r422 = r109;
        this(r215, r216, r319, r320, r321, r322, r323, r324, r325, r326, r327, r418, r116, r117, r419, r420, r421, r422, null);
        return;
    L73:
        r109 = r415;
        goto L74
    L69:
        r214 = r414;
        goto L71
    L65:
        r213 = r413;
        goto L67
    L61:
        r108 = r412;
        goto L63
    L57:
        r107 = r411;
        goto L58
    L53:
        r106 = r410;
        goto L54
    L49:
        r115 = r318;
        goto L51
    L45:
        r114 = r317;
        goto L47
    L41:
        r113 = r316;
        goto L43
    L37:
        r112 = r315;
        goto L39
    L33:
        r111 = r314;
        goto L35
    L29:
        r110 = r313;
        goto L31
    L25:
        r105 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-NOaFTUo, reason: not valid java name */
    public final /* synthetic */ TextStyle m7021copyNOaFTUo(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r410, long r411, TextDecoration r412, Shadow r413, TextAlign r414, TextDirection r415, long r416, TextIndent r417, PlatformTextStyle r510, LineHeightStyle r511) {
        if (Color.m4828equalsimpl0(r210, this.spanStyle.m6939getColor0d7_KjU()) == false) goto L5;
        TextForegroundStyle r100 = this.spanStyle.getTextForegroundStyle$ui_text();
    L6:
        TextForegroundStyle r101 = r100;
        PlatformParagraphStyle r102 = null;
        if (r510 == null) goto L9;
        PlatformSpanStyle r212 = r510.getSpanStyle();
    L10:
        SpanStyle r110 = new SpanStyle(r101, r211, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r212, this.spanStyle.getDrawStyle(), null);
        if (r414 == null) goto L13;
        int r103 = r414.m7417unboximpl();
    L14:
        if (r415 == null) goto L16;
        int r104 = r415.m7431unboximpl();
    L17:
        if (r510 == null) goto L20;
        r102 = r510.getParagraphStyle();
    L20:
        return new TextStyle(r110, new ParagraphStyle(r103, r104, r416, r417, r102, r511, m7036getLineBreakrAG3T2k(), m7033getHyphensvmbZdU8(), getTextMotion(), null), r510);
    L16:
        r104 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L17
    L13:
        r103 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L14
    L9:
        r212 = null;
        goto L10
    L5:
        r100 = TextForegroundStyle.Companion.m7439from8_81llA(r210);
        goto L6
    }

    private TextStyle(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r318, long r410, TextDecoration r411, Shadow r412, TextAlign r413, TextDirection r414, long r415, TextIndent r416, PlatformTextStyle r417, LineHeightStyle r510) {
        PlatformParagraphStyle r212 = null;
        if (r417 == null) goto L5;
        PlatformSpanStyle r213 = r417.getSpanStyle();
    L6:
        SpanStyle r110 = new SpanStyle(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r213, null, null);
        if (r413 == null) goto L9;
        int r100 = r413.m7417unboximpl();
    L10:
        if (r414 == null) goto L12;
        int r101 = r414.m7431unboximpl();
    L13:
        if (r417 == null) goto L15;
        r212 = r417.getParagraphStyle();
    L15:
        this(r110, new ParagraphStyle(r100, r101, r415, r416, r212, r510, LineBreak.Companion.m7339getUnspecifiedrAG3T2k(), Hyphens.Companion.m7318getUnspecifiedvmbZdU8(), null, null), r417);
        return;
    L12:
        r101 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L13
    L9:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L10
    L5:
        r213 = null;
        goto L6
    }

    /* JADX INFO: renamed from: copy-HL5avdY$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m7007copyHL5avdY$default(TextStyle r110, long r111, long r210, FontWeight r211, FontStyle r212, FontSynthesis r213, FontFamily r214, String r215, long r216, BaselineShift r310, TextGeometricTransform r311, LocaleList r312, long r313, TextDecoration r314, Shadow r315, TextAlign r316, TextDirection r317, long r318, TextIndent r410, int r411, Object r412) {
        if ((r411 & 1) == 0) goto L5;
        long r100 = r110.spanStyle.m6939getColor0d7_KjU();
    L7:
        if ((r411 & 2) == 0) goto L9;
        long r101 = r110.spanStyle.m6940getFontSizeXSAIIZE();
    L11:
        if ((r411 & 4) == 0) goto L13;
        FontWeight r102 = r110.spanStyle.getFontWeight();
    L15:
        if ((r411 & 8) == 0) goto L17;
        FontStyle r103 = r110.spanStyle.m6941getFontStyle4Lr2A7w();
    L19:
        if ((r411 & 16) == 0) goto L21;
        FontSynthesis r104 = r110.spanStyle.m6942getFontSynthesisZQGJjVo();
    L23:
        if ((r411 & 32) == 0) goto L25;
        FontFamily r105 = r110.spanStyle.getFontFamily();
    L27:
        if ((r411 & 64) == 0) goto L29;
        String r112 = r110.spanStyle.getFontFeatureSettings();
    L31:
        if ((r411 & 128) == 0) goto L33;
        long r113 = r110.spanStyle.m6943getLetterSpacingXSAIIZE();
    L35:
        if ((r411 & 256) == 0) goto L37;
        BaselineShift r114 = r110.spanStyle.m6938getBaselineShift5SSeXJ0();
    L39:
        if ((r411 & 512) == 0) goto L41;
        TextGeometricTransform r115 = r110.spanStyle.getTextGeometricTransform();
    L43:
        if ((r411 & 1024) == 0) goto L45;
        LocaleList r116 = r110.spanStyle.getLocaleList();
    L46:
        LocaleList r319 = r116;
        if ((r411 & 2048) == 0) goto L49;
        long r117 = r110.spanStyle.m6937getBackground0d7_KjU();
    L50:
        long r320 = r117;
        if ((r411 & 4096) == 0) goto L53;
        TextDecoration r118 = r110.spanStyle.getTextDecoration();
    L54:
        TextDecoration r321 = r118;
        if ((r411 & 8192) == 0) goto L57;
        Shadow r119 = r110.spanStyle.getShadow();
    L58:
        Shadow r322 = r119;
        if ((r411 & 16384) == 0) goto L61;
        TextAlign r120 = TextAlign.m7411boximpl(r110.paragraphStyle.m6903getTextAligne0LSkKk());
    L62:
        TextAlign r323 = r120;
        if ((r411 & 32768) == 0) goto L65;
        TextDirection r121 = TextDirection.m7425boximpl(r110.paragraphStyle.m6905getTextDirections_7Xco());
    L66:
        TextDirection r324 = r121;
        if ((r411 & 65536) == 0) goto L69;
        long r122 = r110.paragraphStyle.m6901getLineHeightXSAIIZE();
    L71:
        if ((r411 & 131072) == 0) goto L73;
        TextIndent r106 = r110.paragraphStyle.getTextIndent();
    L75:
        return r110.m7020copyHL5avdY(r100, r101, r102, r103, r104, r105, r112, r113, r114, r115, r319, r320, r321, r322, r323, r324, r122, r106);
    L73:
        r106 = r410;
        goto L75
    L69:
        r122 = r318;
        goto L71
    L65:
        r121 = r317;
        goto L66
    L61:
        r120 = r316;
        goto L62
    L57:
        r119 = r315;
        goto L58
    L53:
        r118 = r314;
        goto L54
    L49:
        r117 = r313;
        goto L50
    L45:
        r116 = r312;
        goto L46
    L41:
        r115 = r311;
        goto L43
    L37:
        r114 = r310;
        goto L39
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public /* synthetic */ TextStyle(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r410, long r411, TextDecoration r412, Shadow r413, TextAlign r414, TextDirection r415, long r416, TextIndent r417, PlatformTextStyle r510, LineHeightStyle r511, int r512, DefaultConstructorMarker r513) {
        if ((r512 & 1) == 0) goto L5;
        long r100 = Color.Companion.m4863getUnspecified0d7_KjU();
    L7:
        if ((r512 & 2) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r512 & 4) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r512 & 8) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r512 & 16) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r512 & 32) == 0) goto L25;
        FontFamily r105 = null;
    L27:
        if ((r512 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r512 & 128) == 0) goto L33;
        long r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r512 & 256) == 0) goto L37;
        BaselineShift r112 = null;
    L39:
        if ((r512 & 512) == 0) goto L41;
        TextGeometricTransform r113 = null;
    L43:
        if ((r512 & 1024) == 0) goto L45;
        LocaleList r114 = null;
    L47:
        if ((r512 & 2048) == 0) goto L49;
        long r115 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r512 & 4096) == 0) goto L53;
        TextDecoration r106 = null;
    L54:
        TextDecoration r116 = r106;
        if ((r512 & 8192) == 0) goto L57;
        Shadow r107 = null;
    L58:
        Shadow r117 = r107;
        if ((r512 & 16384) == 0) goto L61;
        TextAlign r108 = null;
    L63:
        if ((r512 & 32768) == 0) goto L65;
        TextDirection r212 = null;
    L67:
        if ((r512 & 65536) == 0) goto L69;
        long r213 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L71:
        if ((r512 & 131072) == 0) goto L73;
        TextIndent r214 = null;
    L75:
        if ((r512 & 262144) == 0) goto L77;
        PlatformTextStyle r215 = null;
    L79:
        if ((r512 & 524288) == 0) goto L81;
        LineHeightStyle r109 = null;
    L82:
        long r216 = r100;
        long r318 = r101;
        FontWeight r319 = r102;
        FontStyle r320 = r103;
        FontSynthesis r321 = r104;
        FontFamily r322 = r105;
        String r323 = r110;
        long r324 = r111;
        BaselineShift r325 = r112;
        TextGeometricTransform r418 = r113;
        LocaleList r419 = r114;
        long r420 = r115;
        TextAlign r421 = r108;
        TextDirection r422 = r212;
        long r423 = r213;
        TextIndent r514 = r214;
        PlatformTextStyle r515 = r215;
        LineHeightStyle r516 = r109;
        this(r216, r318, r319, r320, r321, r322, r323, r324, r325, r418, r419, r420, r116, r117, r421, r422, r423, r514, r515, r516, null);
        return;
    L81:
        r109 = r511;
        goto L82
    L77:
        r215 = r510;
        goto L79
    L73:
        r214 = r417;
        goto L75
    L69:
        r213 = r416;
        goto L71
    L65:
        r212 = r415;
        goto L67
    L61:
        r108 = r414;
        goto L63
    L57:
        r107 = r413;
        goto L58
    L53:
        r106 = r412;
        goto L54
    L49:
        r115 = r411;
        goto L51
    L45:
        r114 = r410;
        goto L47
    L41:
        r113 = r317;
        goto L43
    L37:
        r112 = r316;
        goto L39
    L33:
        r111 = r315;
        goto L35
    L29:
        r110 = r314;
        goto L31
    L25:
        r105 = r313;
        goto L27
    L21:
        r104 = r312;
        goto L23
    L17:
        r103 = r311;
        goto L19
    L13:
        r102 = r310;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, and TextMotion are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-CXVQc50, reason: not valid java name */
    public final /* synthetic */ TextStyle m7019copyCXVQc50(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r410, long r411, TextDecoration r412, Shadow r413, TextAlign r414, TextDirection r415, long r416, TextIndent r417, PlatformTextStyle r510, LineHeightStyle r511, LineBreak r512, Hyphens r513) {
        if (Color.m4828equalsimpl0(r210, this.spanStyle.m6939getColor0d7_KjU()) == false) goto L5;
        TextForegroundStyle r100 = this.spanStyle.getTextForegroundStyle$ui_text();
    L6:
        TextForegroundStyle r101 = r100;
        PlatformParagraphStyle r102 = null;
        if (r510 == null) goto L9;
        PlatformSpanStyle r212 = r510.getSpanStyle();
    L10:
        SpanStyle r110 = new SpanStyle(r101, r211, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r212, getDrawStyle(), null);
        if (r414 == null) goto L13;
        int r103 = r414.m7417unboximpl();
    L14:
        if (r415 == null) goto L16;
        int r104 = r415.m7431unboximpl();
    L17:
        if (r510 == null) goto L19;
        r102 = r510.getParagraphStyle();
    L19:
        if (r512 == null) goto L21;
        int r105 = r512.m7331unboximpl();
    L22:
        if (r513 == null) goto L24;
        int r106 = r513.m7315unboximpl();
    L26:
        return new TextStyle(r110, new ParagraphStyle(r103, r104, r416, r417, r102, r511, r105, r106, getTextMotion(), null), r510);
    L24:
        r106 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L26
    L21:
        r105 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L22
    L16:
        r104 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L17
    L13:
        r103 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L14
    L9:
        r212 = null;
        goto L10
    L5:
        r100 = TextForegroundStyle.Companion.m7439from8_81llA(r210);
        goto L6
    }

    private TextStyle(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r410, long r411, TextDecoration r412, Shadow r413, TextAlign r414, TextDirection r415, long r416, TextIndent r417, PlatformTextStyle r510, LineHeightStyle r511, LineBreak r512, Hyphens r513) {
        PlatformParagraphStyle r212 = null;
        if (r510 == null) goto L5;
        PlatformSpanStyle r213 = r510.getSpanStyle();
    L6:
        SpanStyle r110 = new SpanStyle(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r213, null, 32768, null);
        if (r414 == null) goto L9;
        int r100 = r414.m7417unboximpl();
    L10:
        if (r415 == null) goto L12;
        int r101 = r415.m7431unboximpl();
    L13:
        if (r510 == null) goto L15;
        r212 = r510.getParagraphStyle();
    L15:
        if (r512 == null) goto L17;
        int r102 = r512.m7331unboximpl();
    L18:
        if (r513 == null) goto L20;
        int r103 = r513.m7315unboximpl();
    L21:
        this(r110, new ParagraphStyle(r100, r101, r416, r417, r212, r511, r102, r103, null, 256, null), r510);
        return;
    L20:
        r103 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L21
    L17:
        r102 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L18
    L12:
        r101 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L13
    L9:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L10
    L5:
        r213 = null;
        goto L6
    }

    /* JADX INFO: renamed from: copy-NOaFTUo$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m7008copyNOaFTUo$default(TextStyle r110, long r111, long r210, FontWeight r211, FontStyle r212, FontSynthesis r213, FontFamily r214, String r215, long r216, BaselineShift r310, TextGeometricTransform r311, LocaleList r312, long r313, TextDecoration r314, Shadow r315, TextAlign r316, TextDirection r317, long r318, TextIndent r410, PlatformTextStyle r411, LineHeightStyle r412, int r413, Object r414) {
        if ((r413 & 1) == 0) goto L5;
        long r100 = r110.spanStyle.m6939getColor0d7_KjU();
    L7:
        if ((r413 & 2) == 0) goto L9;
        long r101 = r110.spanStyle.m6940getFontSizeXSAIIZE();
    L11:
        if ((r413 & 4) == 0) goto L13;
        FontWeight r102 = r110.spanStyle.getFontWeight();
    L15:
        if ((r413 & 8) == 0) goto L17;
        FontStyle r103 = r110.spanStyle.m6941getFontStyle4Lr2A7w();
    L19:
        if ((r413 & 16) == 0) goto L21;
        FontSynthesis r104 = r110.spanStyle.m6942getFontSynthesisZQGJjVo();
    L23:
        if ((r413 & 32) == 0) goto L25;
        FontFamily r105 = r110.spanStyle.getFontFamily();
    L27:
        if ((r413 & 64) == 0) goto L29;
        String r112 = r110.spanStyle.getFontFeatureSettings();
    L31:
        if ((r413 & 128) == 0) goto L33;
        long r113 = r110.spanStyle.m6943getLetterSpacingXSAIIZE();
    L35:
        if ((r413 & 256) == 0) goto L37;
        BaselineShift r114 = r110.spanStyle.m6938getBaselineShift5SSeXJ0();
    L39:
        if ((r413 & 512) == 0) goto L41;
        TextGeometricTransform r115 = r110.spanStyle.getTextGeometricTransform();
    L43:
        if ((r413 & 1024) == 0) goto L45;
        LocaleList r116 = r110.spanStyle.getLocaleList();
    L46:
        LocaleList r319 = r116;
        if ((r413 & 2048) == 0) goto L49;
        long r117 = r110.spanStyle.m6937getBackground0d7_KjU();
    L50:
        long r320 = r117;
        if ((r413 & 4096) == 0) goto L53;
        TextDecoration r118 = r110.spanStyle.getTextDecoration();
    L54:
        TextDecoration r321 = r118;
        if ((r413 & 8192) == 0) goto L57;
        Shadow r119 = r110.spanStyle.getShadow();
    L58:
        Shadow r322 = r119;
        if ((r413 & 16384) == 0) goto L61;
        TextAlign r120 = TextAlign.m7411boximpl(r110.paragraphStyle.m6903getTextAligne0LSkKk());
    L62:
        TextAlign r323 = r120;
        if ((r413 & 32768) == 0) goto L65;
        TextDirection r121 = TextDirection.m7425boximpl(r110.paragraphStyle.m6905getTextDirections_7Xco());
    L66:
        TextDirection r324 = r121;
        if ((r413 & 65536) == 0) goto L69;
        long r122 = r110.paragraphStyle.m6901getLineHeightXSAIIZE();
    L70:
        long r325 = r122;
        if ((r413 & 131072) == 0) goto L73;
        TextIndent r123 = r110.paragraphStyle.getTextIndent();
    L74:
        TextIndent r415 = r123;
        if ((r413 & 262144) == 0) goto L77;
        PlatformTextStyle r124 = r110.platformStyle;
    L79:
        if ((r413 & 524288) == 0) goto L81;
        LineHeightStyle r106 = r110.paragraphStyle.getLineHeightStyle();
    L83:
        return r110.m7021copyNOaFTUo(r100, r101, r102, r103, r104, r105, r112, r113, r114, r115, r319, r320, r321, r322, r323, r324, r325, r415, r124, r106);
    L81:
        r106 = r412;
        goto L83
    L77:
        r124 = r411;
        goto L79
    L73:
        r123 = r410;
        goto L74
    L69:
        r122 = r318;
        goto L70
    L65:
        r121 = r317;
        goto L66
    L61:
        r120 = r316;
        goto L62
    L57:
        r119 = r315;
        goto L58
    L53:
        r118 = r314;
        goto L54
    L49:
        r117 = r313;
        goto L50
    L45:
        r116 = r312;
        goto L46
    L41:
        r115 = r311;
        goto L43
    L37:
        r114 = r310;
        goto L39
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public /* synthetic */ TextStyle(long r210, long r310, FontWeight r311, FontStyle r312, FontSynthesis r313, FontFamily r314, String r315, long r316, BaselineShift r410, TextGeometricTransform r411, LocaleList r412, long r413, TextDecoration r414, Shadow r415, TextAlign r416, TextDirection r417, long r418, TextIndent r510, PlatformTextStyle r511, LineHeightStyle r512, LineBreak r513, Hyphens r514, int r515, DefaultConstructorMarker r516) {
        if ((r515 & 1) == 0) goto L5;
        long r100 = Color.Companion.m4863getUnspecified0d7_KjU();
    L7:
        if ((r515 & 2) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r515 & 4) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r515 & 8) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r515 & 16) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r515 & 32) == 0) goto L25;
        FontFamily r105 = null;
    L27:
        if ((r515 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r515 & 128) == 0) goto L33;
        long r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r515 & 256) == 0) goto L37;
        BaselineShift r112 = null;
    L39:
        if ((r515 & 512) == 0) goto L41;
        TextGeometricTransform r113 = null;
    L43:
        if ((r515 & 1024) == 0) goto L45;
        LocaleList r114 = null;
    L47:
        if ((r515 & 2048) == 0) goto L49;
        long r115 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r515 & 4096) == 0) goto L53;
        TextDecoration r106 = null;
    L54:
        TextDecoration r116 = r106;
        if ((r515 & 8192) == 0) goto L57;
        Shadow r107 = null;
    L58:
        Shadow r117 = r107;
        if ((r515 & 16384) == 0) goto L61;
        TextAlign r108 = null;
    L63:
        if ((r515 & 32768) == 0) goto L65;
        TextDirection r211 = null;
    L67:
        if ((r515 & 65536) == 0) goto L69;
        long r212 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L71:
        if ((r515 & 131072) == 0) goto L73;
        TextIndent r213 = null;
    L75:
        if ((r515 & 262144) == 0) goto L77;
        PlatformTextStyle r214 = null;
    L79:
        if ((r515 & 524288) == 0) goto L81;
        LineHeightStyle r215 = null;
    L83:
        if ((r515 & 1048576) == 0) goto L85;
        LineBreak r216 = null;
    L87:
        if ((r515 & 2097152) == 0) goto L89;
        Hyphens r109 = null;
    L90:
        long r317 = r100;
        long r318 = r101;
        FontWeight r319 = r102;
        FontStyle r320 = r103;
        FontSynthesis r321 = r104;
        FontFamily r322 = r105;
        String r323 = r110;
        long r324 = r111;
        BaselineShift r419 = r112;
        TextGeometricTransform r420 = r113;
        LocaleList r421 = r114;
        long r422 = r115;
        TextAlign r423 = r108;
        TextDirection r424 = r211;
        long r517 = r212;
        TextIndent r518 = r213;
        PlatformTextStyle r519 = r214;
        LineHeightStyle r520 = r215;
        LineBreak r521 = r216;
        Hyphens r522 = r109;
        this(r317, r318, r319, r320, r321, r322, r323, r324, r419, r420, r421, r422, r116, r117, r423, r424, r517, r518, r519, r520, r521, r522, null);
        return;
    L89:
        r109 = r514;
        goto L90
    L85:
        r216 = r513;
        goto L87
    L81:
        r215 = r512;
        goto L83
    L77:
        r214 = r511;
        goto L79
    L73:
        r213 = r510;
        goto L75
    L69:
        r212 = r418;
        goto L71
    L65:
        r211 = r417;
        goto L67
    L61:
        r108 = r416;
        goto L63
    L57:
        r107 = r415;
        goto L58
    L53:
        r106 = r414;
        goto L54
    L49:
        r115 = r413;
        goto L51
    L45:
        r114 = r412;
        goto L47
    L41:
        r113 = r411;
        goto L43
    L37:
        r112 = r410;
        goto L39
    L33:
        r111 = r316;
        goto L35
    L29:
        r110 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    /* JADX INFO: renamed from: copy-p1EtxEg, reason: not valid java name */
    public final TextStyle m7024copyp1EtxEg(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r410, long r411, TextDecoration r412, Shadow r413, DrawStyle r414, int r415, int r416, long r417, TextIndent r510, PlatformTextStyle r511, LineHeightStyle r512, int r513, int r514, TextMotion r515) {
        if (Color.m4828equalsimpl0(r210, this.spanStyle.m6939getColor0d7_KjU()) == false) goto L5;
        TextForegroundStyle r100 = this.spanStyle.getTextForegroundStyle$ui_text();
    L6:
        TextForegroundStyle r101 = r100;
        PlatformParagraphStyle r102 = null;
        if (r511 == null) goto L9;
        PlatformSpanStyle r212 = r511.getSpanStyle();
    L10:
        SpanStyle r110 = new SpanStyle(r101, r211, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r212, r414, null);
        if (r511 == null) goto L14;
        r102 = r511.getParagraphStyle();
    L14:
        return new TextStyle(r110, new ParagraphStyle(r415, r416, r417, r510, r102, r512, r513, r514, r515, null), r511);
    L9:
        r212 = null;
        goto L10
    L5:
        r100 = TextForegroundStyle.Companion.m7439from8_81llA(r210);
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* JADX INFO: renamed from: copy-v2rsoow, reason: not valid java name */
    public final /* synthetic */ TextStyle m7025copyv2rsoow(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r410, long r411, TextDecoration r412, Shadow r413, DrawStyle r414, TextAlign r415, TextDirection r416, long r417, TextIndent r510, PlatformTextStyle r511, LineHeightStyle r512, LineBreak r513, Hyphens r514, TextMotion r515) {
        if (Color.m4828equalsimpl0(r210, this.spanStyle.m6939getColor0d7_KjU()) == false) goto L5;
        TextForegroundStyle r100 = this.spanStyle.getTextForegroundStyle$ui_text();
    L6:
        TextForegroundStyle r101 = r100;
        PlatformParagraphStyle r102 = null;
        if (r511 == null) goto L9;
        PlatformSpanStyle r212 = r511.getSpanStyle();
    L10:
        SpanStyle r110 = new SpanStyle(r101, r211, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r212, r414, null);
        if (r415 == null) goto L13;
        int r103 = r415.m7417unboximpl();
    L14:
        if (r416 == null) goto L16;
        int r104 = r416.m7431unboximpl();
    L17:
        if (r511 == null) goto L19;
        r102 = r511.getParagraphStyle();
    L19:
        if (r513 == null) goto L21;
        int r105 = r513.m7331unboximpl();
    L22:
        if (r514 == null) goto L24;
        int r106 = r514.m7315unboximpl();
    L26:
        return new TextStyle(r110, new ParagraphStyle(r103, r104, r417, r510, r102, r512, r105, r106, r515, null), r511);
    L24:
        r106 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L26
    L21:
        r105 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L22
    L16:
        r104 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L17
    L13:
        r103 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L14
    L9:
        r212 = null;
        goto L10
    L5:
        r100 = TextForegroundStyle.Companion.m7439from8_81llA(r210);
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "merge that takes nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* JADX INFO: renamed from: merge-Z1GrekI, reason: not valid java name */
    public final /* synthetic */ TextStyle m7042mergeZ1GrekI(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r318, long r410, TextDecoration r411, Shadow r412, DrawStyle r413, TextAlign r414, TextDirection r415, long r416, TextIndent r417, LineHeightStyle r510, LineBreak r511, Hyphens r512, PlatformTextStyle r513, TextMotion r514) {
        SpanStyle r100 = this.spanStyle;
        PlatformParagraphStyle r212 = null;
        if (r513 == null) goto L5;
        PlatformSpanStyle r213 = r513.getSpanStyle();
    L6:
        SpanStyle r101 = SpanStyleKt.m6944fastMergedSHsh3o(r100, r210, null, Float.NaN, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r213, r413);
        ParagraphStyle r102 = this.paragraphStyle;
        if (r414 == null) goto L9;
        int r103 = r414.m7417unboximpl();
    L10:
        if (r415 == null) goto L12;
        int r104 = r415.m7431unboximpl();
    L13:
        if (r513 == null) goto L15;
        r212 = r513.getParagraphStyle();
    L15:
        if (r511 == null) goto L17;
        int r105 = r511.m7331unboximpl();
    L18:
        if (r512 == null) goto L20;
        int r106 = r512.m7315unboximpl();
    L21:
        ParagraphStyle r107 = ParagraphStyleKt.m6906fastMergej5T8yCg(r102, r103, r104, r416, r417, r212, r510, r105, r106, r514);
        if (this.spanStyle != r101) goto L27;
        if (this.paragraphStyle != r107) goto L27;
        return this;
    L27:
        return new TextStyle(r101, r107);
    L20:
        r106 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L21
    L17:
        r105 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L18
    L12:
        r104 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L13
    L9:
        r103 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L10
    L5:
        r213 = null;
        goto L6
    }

    /* JADX INFO: renamed from: merge-dA7vx0o, reason: not valid java name */
    public final TextStyle m7043mergedA7vx0o(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r318, long r410, TextDecoration r411, Shadow r412, DrawStyle r413, int r414, int r415, long r416, TextIndent r417, LineHeightStyle r510, int r511, int r512, PlatformTextStyle r513, TextMotion r514) {
        SpanStyle r100 = this.spanStyle;
        PlatformParagraphStyle r212 = null;
        if (r513 == null) goto L5;
        PlatformSpanStyle r213 = r513.getSpanStyle();
    L6:
        SpanStyle r101 = SpanStyleKt.m6944fastMergedSHsh3o(r100, r210, null, Float.NaN, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r213, r413);
        ParagraphStyle r102 = this.paragraphStyle;
        if (r513 == null) goto L9;
        r212 = r513.getParagraphStyle();
    L9:
        ParagraphStyle r103 = ParagraphStyleKt.m6906fastMergej5T8yCg(r102, r414, r415, r416, r417, r212, r510, r511, r512, r514);
        if (this.spanStyle != r101) goto L15;
        if (this.paragraphStyle != r103) goto L15;
        return this;
    L15:
        return new TextStyle(r101, r103);
    L5:
        r213 = null;
        goto L6
    }

    private TextStyle(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r318, long r410, TextDecoration r411, Shadow r412, DrawStyle r413, TextAlign r414, TextDirection r415, long r416, TextIndent r417, PlatformTextStyle r510, LineHeightStyle r511, LineBreak r512, Hyphens r513, TextMotion r514) {
        PlatformParagraphStyle r212 = null;
        if (r510 == null) goto L5;
        PlatformSpanStyle r213 = r510.getSpanStyle();
    L6:
        SpanStyle r110 = new SpanStyle(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r213, r413, null);
        if (r414 == null) goto L9;
        int r100 = r414.m7417unboximpl();
    L10:
        if (r415 == null) goto L12;
        int r101 = r415.m7431unboximpl();
    L13:
        if (r510 == null) goto L15;
        r212 = r510.getParagraphStyle();
    L15:
        if (r512 == null) goto L17;
        int r102 = r512.m7331unboximpl();
    L18:
        if (r513 == null) goto L20;
        int r103 = r513.m7315unboximpl();
    L21:
        this(r110, new ParagraphStyle(r100, r101, r416, r417, r212, r511, r102, r103, r514, null), r510);
        return;
    L20:
        r103 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L21
    L17:
        r102 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L18
    L12:
        r101 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L13
    L9:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L10
    L5:
        r213 = null;
        goto L6
    }

    private TextStyle(long r210, long r211, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r318, long r410, TextDecoration r411, Shadow r412, DrawStyle r413, int r414, int r415, long r416, TextIndent r417, PlatformTextStyle r510, LineHeightStyle r511, int r512, int r513, TextMotion r514) {
        PlatformParagraphStyle r212 = null;
        if (r510 == null) goto L5;
        PlatformSpanStyle r213 = r510.getSpanStyle();
    L6:
        SpanStyle r110 = new SpanStyle(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r213, r413, null);
        if (r510 == null) goto L9;
        r212 = r510.getParagraphStyle();
    L9:
        this(r110, new ParagraphStyle(r414, r415, r416, r417, r212, r511, r512, r513, r514, null), r510);
        return;
    L5:
        r213 = null;
        goto L6
    }

    private TextStyle(Brush r210, float r211, long r212, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r318, long r410, TextDecoration r411, Shadow r412, DrawStyle r413, TextAlign r414, TextDirection r415, long r416, TextIndent r417, PlatformTextStyle r510, LineHeightStyle r511, LineBreak r512, Hyphens r513, TextMotion r514) {
        PlatformParagraphStyle r213 = null;
        if (r510 == null) goto L5;
        PlatformSpanStyle r214 = r510.getSpanStyle();
    L6:
        SpanStyle r110 = new SpanStyle(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r214, r413, null);
        if (r414 == null) goto L9;
        int r100 = r414.m7417unboximpl();
    L10:
        if (r415 == null) goto L12;
        int r101 = r415.m7431unboximpl();
    L13:
        if (r510 == null) goto L15;
        r213 = r510.getParagraphStyle();
    L15:
        if (r512 == null) goto L17;
        int r102 = r512.m7331unboximpl();
    L18:
        if (r513 == null) goto L20;
        int r103 = r513.m7315unboximpl();
    L21:
        this(r110, new ParagraphStyle(r100, r101, r416, r417, r213, r511, r102, r103, r514, null), r510);
        return;
    L20:
        r103 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L21
    L17:
        r102 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L18
    L12:
        r101 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L13
    L9:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L10
    L5:
        r214 = null;
        goto L6
    }

    /* JADX INFO: renamed from: copy-CXVQc50$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m7006copyCXVQc50$default(TextStyle r110, long r111, long r210, FontWeight r211, FontStyle r212, FontSynthesis r213, FontFamily r214, String r215, long r216, BaselineShift r310, TextGeometricTransform r311, LocaleList r312, long r313, TextDecoration r314, Shadow r315, TextAlign r316, TextDirection r317, long r318, TextIndent r410, PlatformTextStyle r411, LineHeightStyle r412, LineBreak r413, Hyphens r414, int r415, Object r416) {
        if ((r415 & 1) == 0) goto L5;
        long r100 = r110.spanStyle.m6939getColor0d7_KjU();
    L7:
        if ((r415 & 2) == 0) goto L9;
        long r101 = r110.spanStyle.m6940getFontSizeXSAIIZE();
    L11:
        if ((r415 & 4) == 0) goto L13;
        FontWeight r102 = r110.spanStyle.getFontWeight();
    L15:
        if ((r415 & 8) == 0) goto L17;
        FontStyle r103 = r110.spanStyle.m6941getFontStyle4Lr2A7w();
    L19:
        if ((r415 & 16) == 0) goto L21;
        FontSynthesis r104 = r110.spanStyle.m6942getFontSynthesisZQGJjVo();
    L23:
        if ((r415 & 32) == 0) goto L25;
        FontFamily r105 = r110.spanStyle.getFontFamily();
    L27:
        if ((r415 & 64) == 0) goto L29;
        String r112 = r110.spanStyle.getFontFeatureSettings();
    L31:
        if ((r415 & 128) == 0) goto L33;
        long r113 = r110.spanStyle.m6943getLetterSpacingXSAIIZE();
    L35:
        if ((r415 & 256) == 0) goto L37;
        BaselineShift r114 = r110.spanStyle.m6938getBaselineShift5SSeXJ0();
    L39:
        if ((r415 & 512) == 0) goto L41;
        TextGeometricTransform r115 = r110.spanStyle.getTextGeometricTransform();
    L43:
        if ((r415 & 1024) == 0) goto L45;
        LocaleList r116 = r110.spanStyle.getLocaleList();
    L46:
        LocaleList r319 = r116;
        if ((r415 & 2048) == 0) goto L49;
        long r117 = r110.spanStyle.m6937getBackground0d7_KjU();
    L50:
        long r320 = r117;
        if ((r415 & 4096) == 0) goto L53;
        TextDecoration r118 = r110.spanStyle.getTextDecoration();
    L54:
        TextDecoration r321 = r118;
        if ((r415 & 8192) == 0) goto L57;
        Shadow r119 = r110.spanStyle.getShadow();
    L58:
        Shadow r322 = r119;
        if ((r415 & 16384) == 0) goto L61;
        TextAlign r120 = TextAlign.m7411boximpl(r110.paragraphStyle.m6903getTextAligne0LSkKk());
    L62:
        TextAlign r323 = r120;
        if ((r415 & 32768) == 0) goto L65;
        TextDirection r121 = TextDirection.m7425boximpl(r110.paragraphStyle.m6905getTextDirections_7Xco());
    L66:
        TextDirection r324 = r121;
        if ((r415 & 65536) == 0) goto L69;
        long r122 = r110.paragraphStyle.m6901getLineHeightXSAIIZE();
    L70:
        long r325 = r122;
        if ((r415 & 131072) == 0) goto L73;
        TextIndent r123 = r110.paragraphStyle.getTextIndent();
    L74:
        TextIndent r417 = r123;
        if ((r415 & 262144) == 0) goto L77;
        PlatformTextStyle r124 = r110.platformStyle;
    L78:
        PlatformTextStyle r418 = r124;
        if ((r415 & 524288) == 0) goto L81;
        LineHeightStyle r125 = r110.paragraphStyle.getLineHeightStyle();
    L82:
        LineHeightStyle r419 = r125;
        if ((r415 & 1048576) == 0) goto L85;
        LineBreak r126 = LineBreak.m7319boximpl(r110.paragraphStyle.m6900getLineBreakrAG3T2k());
    L87:
        if ((r415 & 2097152) == 0) goto L89;
        Hyphens r106 = Hyphens.m7309boximpl(r110.paragraphStyle.m6898getHyphensvmbZdU8());
    L91:
        return r110.m7019copyCXVQc50(r100, r101, r102, r103, r104, r105, r112, r113, r114, r115, r319, r320, r321, r322, r323, r324, r325, r417, r418, r419, r126, r106);
    L89:
        r106 = r414;
        goto L91
    L85:
        r126 = r413;
        goto L87
    L81:
        r125 = r412;
        goto L82
    L77:
        r124 = r411;
        goto L78
    L73:
        r123 = r410;
        goto L74
    L69:
        r122 = r318;
        goto L70
    L65:
        r121 = r317;
        goto L66
    L61:
        r120 = r316;
        goto L62
    L57:
        r119 = r315;
        goto L58
    L53:
        r118 = r314;
        goto L54
    L49:
        r117 = r313;
        goto L50
    L45:
        r116 = r312;
        goto L46
    L41:
        r115 = r311;
        goto L43
    L37:
        r114 = r310;
        goto L39
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: copy-Ns73l9s, reason: not valid java name */
    public final TextStyle m7022copyNs73l9s(Brush r210, float r211, long r212, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r410, long r411, TextDecoration r412, Shadow r413, DrawStyle r414, int r415, int r416, long r417, TextIndent r510, PlatformTextStyle r511, LineHeightStyle r512, int r513, int r514, TextMotion r515) {
        PlatformParagraphStyle r213 = null;
        if (r511 == null) goto L5;
        PlatformSpanStyle r214 = r511.getSpanStyle();
    L6:
        SpanStyle r110 = new SpanStyle(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r214, r414, null);
        if (r511 == null) goto L10;
        r213 = r511.getParagraphStyle();
    L10:
        return new TextStyle(r110, new ParagraphStyle(r415, r416, r417, r510, r213, r512, r513, r514, r515, null), r511);
    L5:
        r214 = null;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* JADX INFO: renamed from: copy-aIRg9q4, reason: not valid java name */
    public final /* synthetic */ TextStyle m7023copyaIRg9q4(Brush r210, float r211, long r212, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r410, long r411, TextDecoration r412, Shadow r413, DrawStyle r414, TextAlign r415, TextDirection r416, long r417, TextIndent r510, PlatformTextStyle r511, LineHeightStyle r512, LineBreak r513, Hyphens r514, TextMotion r515) {
        PlatformParagraphStyle r213 = null;
        if (r511 == null) goto L5;
        PlatformSpanStyle r214 = r511.getSpanStyle();
    L6:
        SpanStyle r110 = new SpanStyle(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r214, r414, null);
        if (r415 == null) goto L9;
        int r100 = r415.m7417unboximpl();
    L10:
        if (r416 == null) goto L12;
        int r101 = r416.m7431unboximpl();
    L13:
        if (r511 == null) goto L15;
        r213 = r511.getParagraphStyle();
    L15:
        if (r513 == null) goto L17;
        int r102 = r513.m7331unboximpl();
    L18:
        if (r514 == null) goto L20;
        int r103 = r514.m7315unboximpl();
    L22:
        return new TextStyle(r110, new ParagraphStyle(r100, r101, r417, r510, r213, r512, r102, r103, r515, null), r511);
    L20:
        r103 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L22
    L17:
        r102 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L18
    L12:
        r101 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L13
    L9:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L10
    L5:
        r214 = null;
        goto L6
    }

    private TextStyle(Brush r210, float r211, long r212, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r318, long r410, TextDecoration r411, Shadow r412, DrawStyle r413, int r414, int r415, long r416, TextIndent r417, PlatformTextStyle r510, LineHeightStyle r511, int r512, int r513, TextMotion r514) {
        PlatformParagraphStyle r213 = null;
        if (r510 == null) goto L5;
        PlatformSpanStyle r214 = r510.getSpanStyle();
    L6:
        SpanStyle r110 = new SpanStyle(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r214, r413, null);
        if (r510 == null) goto L9;
        r213 = r510.getParagraphStyle();
    L9:
        this(r110, new ParagraphStyle(r414, r415, r416, r417, r213, r511, r512, r513, r514, null), r510);
        return;
    L5:
        r214 = null;
        goto L6
    }

    public /* synthetic */ TextStyle(long r310, long r311, FontWeight r312, FontStyle r313, FontSynthesis r314, FontFamily r315, String r316, long r410, BaselineShift r411, TextGeometricTransform r412, LocaleList r413, long r414, TextDecoration r415, Shadow r416, DrawStyle r417, int r510, int r511, long r512, TextIndent r513, PlatformTextStyle r514, LineHeightStyle r515, int r516, int r517, TextMotion r518, int r610, DefaultConstructorMarker r611) {
        if ((r610 & 1) == 0) goto L5;
        long r100 = Color.Companion.m4863getUnspecified0d7_KjU();
    L7:
        if ((r610 & 2) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r610 & 4) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r610 & 8) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r610 & 16) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r610 & 32) == 0) goto L25;
        FontFamily r105 = null;
    L27:
        if ((r610 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r610 & 128) == 0) goto L33;
        long r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r610 & 256) == 0) goto L37;
        BaselineShift r112 = null;
    L39:
        if ((r610 & 512) == 0) goto L41;
        TextGeometricTransform r113 = null;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        LocaleList r114 = null;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        long r115 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r610 & 4096) == 0) goto L53;
        TextDecoration r106 = null;
    L54:
        TextDecoration r116 = r106;
        if ((r610 & 8192) == 0) goto L57;
        Shadow r107 = null;
    L58:
        Shadow r117 = r107;
        if ((r610 & 16384) == 0) goto L61;
        DrawStyle r108 = null;
    L63:
        if ((r610 & 32768) == 0) goto L65;
        int r210 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
    L67:
        if ((r610 & 65536) == 0) goto L69;
        int r211 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
    L71:
        if ((r610 & 131072) == 0) goto L73;
        long r212 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L75:
        if ((r610 & 262144) == 0) goto L77;
        TextIndent r213 = null;
    L79:
        if ((r610 & 524288) == 0) goto L81;
        PlatformTextStyle r214 = null;
    L83:
        if ((r610 & 1048576) == 0) goto L85;
        LineHeightStyle r215 = null;
    L87:
        if ((r610 & 2097152) == 0) goto L89;
        int r216 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
    L91:
        if ((r610 & 4194304) == 0) goto L93;
        int r217 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
    L95:
        if ((r610 & 8388608) == 0) goto L97;
        TextMotion r109 = null;
    L98:
        long r317 = r100;
        long r318 = r101;
        FontWeight r319 = r102;
        FontStyle r320 = r103;
        FontSynthesis r321 = r104;
        FontFamily r322 = r105;
        String r418 = r110;
        long r419 = r111;
        BaselineShift r420 = r112;
        TextGeometricTransform r421 = r113;
        LocaleList r422 = r114;
        long r423 = r115;
        DrawStyle r519 = r108;
        int r520 = r210;
        int r521 = r211;
        long r522 = r212;
        TextIndent r523 = r213;
        PlatformTextStyle r524 = r214;
        LineHeightStyle r525 = r215;
        int r526 = r216;
        int r527 = r217;
        TextMotion r612 = r109;
        this(r317, r318, r319, r320, r321, r322, r418, r419, r420, r421, r422, r423, r116, r117, r519, r520, r521, r522, r523, r524, r525, r526, r527, r612, null);
        return;
    L97:
        r109 = r518;
        goto L98
    L93:
        r217 = r517;
        goto L95
    L89:
        r216 = r516;
        goto L91
    L85:
        r215 = r515;
        goto L87
    L81:
        r214 = r514;
        goto L83
    L77:
        r213 = r513;
        goto L79
    L73:
        r212 = r512;
        goto L75
    L69:
        r211 = r511;
        goto L71
    L65:
        r210 = r510;
        goto L67
    L61:
        r108 = r417;
        goto L63
    L57:
        r107 = r416;
        goto L58
    L53:
        r106 = r415;
        goto L54
    L49:
        r115 = r414;
        goto L51
    L45:
        r114 = r413;
        goto L47
    L41:
        r113 = r412;
        goto L43
    L37:
        r112 = r411;
        goto L39
    L33:
        r111 = r410;
        goto L35
    L29:
        r110 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }

    public /* synthetic */ TextStyle(long r310, long r311, FontWeight r312, FontStyle r313, FontSynthesis r314, FontFamily r315, String r316, long r410, BaselineShift r411, TextGeometricTransform r412, LocaleList r413, long r414, TextDecoration r415, Shadow r416, DrawStyle r417, TextAlign r510, TextDirection r511, long r512, TextIndent r513, PlatformTextStyle r514, LineHeightStyle r515, LineBreak r516, Hyphens r517, TextMotion r518, int r610, DefaultConstructorMarker r611) {
        if ((r610 & 1) == 0) goto L5;
        long r100 = Color.Companion.m4863getUnspecified0d7_KjU();
    L7:
        if ((r610 & 2) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r610 & 4) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r610 & 8) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r610 & 16) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r610 & 32) == 0) goto L25;
        FontFamily r105 = null;
    L27:
        if ((r610 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r610 & 128) == 0) goto L33;
        long r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r610 & 256) == 0) goto L37;
        BaselineShift r112 = null;
    L39:
        if ((r610 & 512) == 0) goto L41;
        TextGeometricTransform r113 = null;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        LocaleList r114 = null;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        long r115 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r610 & 4096) == 0) goto L53;
        TextDecoration r106 = null;
    L54:
        TextDecoration r116 = r106;
        if ((r610 & 8192) == 0) goto L57;
        Shadow r107 = null;
    L58:
        Shadow r117 = r107;
        if ((r610 & 16384) == 0) goto L61;
        DrawStyle r108 = null;
    L63:
        if ((r610 & 32768) == 0) goto L65;
        TextAlign r210 = null;
    L67:
        if ((r610 & 65536) == 0) goto L69;
        TextDirection r211 = null;
    L71:
        if ((r610 & 131072) == 0) goto L73;
        long r212 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L75:
        if ((r610 & 262144) == 0) goto L77;
        TextIndent r213 = null;
    L79:
        if ((r610 & 524288) == 0) goto L81;
        PlatformTextStyle r214 = null;
    L83:
        if ((r610 & 1048576) == 0) goto L85;
        LineHeightStyle r215 = null;
    L87:
        if ((r610 & 2097152) == 0) goto L89;
        LineBreak r216 = null;
    L91:
        if ((r610 & 4194304) == 0) goto L93;
        Hyphens r217 = null;
    L95:
        if ((r610 & 8388608) == 0) goto L97;
        TextMotion r109 = null;
    L98:
        long r317 = r100;
        long r318 = r101;
        FontWeight r319 = r102;
        FontStyle r320 = r103;
        FontSynthesis r321 = r104;
        FontFamily r322 = r105;
        String r418 = r110;
        long r419 = r111;
        BaselineShift r420 = r112;
        TextGeometricTransform r421 = r113;
        LocaleList r422 = r114;
        long r423 = r115;
        DrawStyle r519 = r108;
        TextAlign r520 = r210;
        TextDirection r521 = r211;
        long r522 = r212;
        TextIndent r523 = r213;
        PlatformTextStyle r524 = r214;
        LineHeightStyle r525 = r215;
        LineBreak r526 = r216;
        Hyphens r527 = r217;
        TextMotion r612 = r109;
        this(r317, r318, r319, r320, r321, r322, r418, r419, r420, r421, r422, r423, r116, r117, r519, r520, r521, r522, r523, r524, r525, r526, r527, r612, null);
        return;
    L97:
        r109 = r518;
        goto L98
    L93:
        r217 = r517;
        goto L95
    L89:
        r216 = r516;
        goto L91
    L85:
        r215 = r515;
        goto L87
    L81:
        r214 = r514;
        goto L83
    L77:
        r213 = r513;
        goto L79
    L73:
        r212 = r512;
        goto L75
    L69:
        r211 = r511;
        goto L71
    L65:
        r210 = r510;
        goto L67
    L61:
        r108 = r417;
        goto L63
    L57:
        r107 = r416;
        goto L58
    L53:
        r106 = r415;
        goto L54
    L49:
        r115 = r414;
        goto L51
    L45:
        r114 = r413;
        goto L47
    L41:
        r113 = r412;
        goto L43
    L37:
        r112 = r411;
        goto L39
    L33:
        r111 = r410;
        goto L35
    L29:
        r110 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }

    public /* synthetic */ TextStyle(Brush r310, float r311, long r312, FontWeight r313, FontStyle r314, FontSynthesis r410, FontFamily r411, String r412, long r413, BaselineShift r414, TextGeometricTransform r415, LocaleList r416, long r417, TextDecoration r510, Shadow r511, DrawStyle r512, int r513, int r514, long r515, TextIndent r516, PlatformTextStyle r517, LineHeightStyle r518, int r610, int r611, TextMotion r612, int r613, DefaultConstructorMarker r614) {
        if ((r613 & 2) == 0) goto L5;
        float r100 = Float.NaN;
    L7:
        if ((r613 & 4) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r613 & 8) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r613 & 16) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r613 & 32) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r613 & 64) == 0) goto L25;
        FontFamily r110 = null;
    L27:
        if ((r613 & 128) == 0) goto L29;
        String r111 = null;
    L31:
        if ((r613 & 256) == 0) goto L33;
        long r112 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r613 & 512) == 0) goto L37;
        BaselineShift r113 = null;
    L39:
        if ((r613 & 1024) == 0) goto L41;
        TextGeometricTransform r114 = null;
    L43:
        if ((r613 & 2048) == 0) goto L45;
        LocaleList r115 = null;
    L47:
        if ((r613 & 4096) == 0) goto L49;
        long r116 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r613 & 8192) == 0) goto L53;
        TextDecoration r117 = null;
    L55:
        if ((r613 & 16384) == 0) goto L57;
        Shadow r210 = null;
    L59:
        if ((32768 & r613) == 0) goto L61;
        DrawStyle r211 = null;
    L63:
        if ((65536 & r613) == 0) goto L65;
        int r212 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
    L67:
        if ((131072 & r613) == 0) goto L69;
        int r213 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
    L71:
        if ((262144 & r613) == 0) goto L73;
        long r214 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L75:
        if ((524288 & r613) == 0) goto L77;
        TextIndent r215 = null;
    L79:
        if ((1048576 & r613) == 0) goto L81;
        PlatformTextStyle r216 = null;
    L83:
        if ((2097152 & r613) == 0) goto L85;
        LineHeightStyle r217 = null;
    L87:
        if ((4194304 & r613) == 0) goto L89;
        int r218 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
    L91:
        if ((8388608 & r613) == 0) goto L93;
        int r315 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
    L95:
        if ((r613 & 16777216) == 0) goto L97;
        TextMotion r316 = null;
    L98:
        this(r310, r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218, r315, r316, null);
        return;
    L97:
        r316 = r612;
        goto L98
    L93:
        r315 = r611;
        goto L95
    L89:
        r218 = r610;
        goto L91
    L85:
        r217 = r518;
        goto L87
    L81:
        r216 = r517;
        goto L83
    L77:
        r215 = r516;
        goto L79
    L73:
        r214 = r515;
        goto L75
    L69:
        r213 = r514;
        goto L71
    L65:
        r212 = r513;
        goto L67
    L61:
        r211 = r512;
        goto L63
    L57:
        r210 = r511;
        goto L59
    L53:
        r117 = r510;
        goto L55
    L49:
        r116 = r417;
        goto L51
    L45:
        r115 = r416;
        goto L47
    L41:
        r114 = r415;
        goto L43
    L37:
        r113 = r414;
        goto L39
    L33:
        r112 = r413;
        goto L35
    L29:
        r111 = r412;
        goto L31
    L25:
        r110 = r411;
        goto L27
    L21:
        r104 = r410;
        goto L23
    L17:
        r103 = r314;
        goto L19
    L13:
        r102 = r313;
        goto L15
    L9:
        r101 = r312;
        goto L11
    L5:
        r100 = r311;
        goto L7
    }

    /* JADX INFO: renamed from: copy-p1EtxEg$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m7011copyp1EtxEg$default(TextStyle r110, long r111, long r210, FontWeight r211, FontStyle r212, FontSynthesis r213, FontFamily r214, String r215, long r216, BaselineShift r310, TextGeometricTransform r311, LocaleList r312, long r313, TextDecoration r314, Shadow r315, DrawStyle r316, int r317, int r318, long r410, TextIndent r411, PlatformTextStyle r412, LineHeightStyle r413, int r414, int r415, TextMotion r416, int r417, Object r418) {
        if ((r417 & 1) == 0) goto L5;
        long r100 = r110.spanStyle.m6939getColor0d7_KjU();
    L7:
        if ((r417 & 2) == 0) goto L9;
        long r101 = r110.spanStyle.m6940getFontSizeXSAIIZE();
    L11:
        if ((r417 & 4) == 0) goto L13;
        FontWeight r102 = r110.spanStyle.getFontWeight();
    L15:
        if ((r417 & 8) == 0) goto L17;
        FontStyle r103 = r110.spanStyle.m6941getFontStyle4Lr2A7w();
    L19:
        if ((r417 & 16) == 0) goto L21;
        FontSynthesis r104 = r110.spanStyle.m6942getFontSynthesisZQGJjVo();
    L23:
        if ((r417 & 32) == 0) goto L25;
        FontFamily r105 = r110.spanStyle.getFontFamily();
    L27:
        if ((r417 & 64) == 0) goto L29;
        String r112 = r110.spanStyle.getFontFeatureSettings();
    L31:
        if ((r417 & 128) == 0) goto L33;
        long r113 = r110.spanStyle.m6943getLetterSpacingXSAIIZE();
    L35:
        if ((r417 & 256) == 0) goto L37;
        BaselineShift r114 = r110.spanStyle.m6938getBaselineShift5SSeXJ0();
    L39:
        if ((r417 & 512) == 0) goto L41;
        TextGeometricTransform r115 = r110.spanStyle.getTextGeometricTransform();
    L43:
        if ((r417 & 1024) == 0) goto L45;
        LocaleList r116 = r110.spanStyle.getLocaleList();
    L46:
        LocaleList r319 = r116;
        if ((r417 & 2048) == 0) goto L49;
        long r117 = r110.spanStyle.m6937getBackground0d7_KjU();
    L50:
        long r320 = r117;
        if ((r417 & 4096) == 0) goto L53;
        TextDecoration r118 = r110.spanStyle.getTextDecoration();
    L54:
        TextDecoration r321 = r118;
        if ((r417 & 8192) == 0) goto L57;
        Shadow r119 = r110.spanStyle.getShadow();
    L58:
        Shadow r322 = r119;
        if ((r417 & 16384) == 0) goto L61;
        DrawStyle r120 = r110.spanStyle.getDrawStyle();
    L62:
        DrawStyle r323 = r120;
        if ((r417 & 32768) == 0) goto L65;
        int r121 = r110.paragraphStyle.m6903getTextAligne0LSkKk();
    L66:
        int r324 = r121;
        if ((r417 & 65536) == 0) goto L69;
        int r122 = r110.paragraphStyle.m6905getTextDirections_7Xco();
    L70:
        int r325 = r122;
        if ((r417 & 131072) == 0) goto L73;
        long r123 = r110.paragraphStyle.m6901getLineHeightXSAIIZE();
    L74:
        long r419 = r123;
        if ((r417 & 262144) == 0) goto L77;
        TextIndent r124 = r110.paragraphStyle.getTextIndent();
    L78:
        TextIndent r420 = r124;
        if ((r417 & 524288) == 0) goto L81;
        PlatformTextStyle r125 = r110.platformStyle;
    L82:
        PlatformTextStyle r421 = r125;
        if ((r417 & 1048576) == 0) goto L85;
        LineHeightStyle r126 = r110.paragraphStyle.getLineHeightStyle();
    L86:
        LineHeightStyle r422 = r126;
        if ((r417 & 2097152) == 0) goto L89;
        int r127 = r110.paragraphStyle.m6900getLineBreakrAG3T2k();
    L90:
        int r423 = r127;
        if ((r417 & 4194304) == 0) goto L93;
        int r128 = r110.paragraphStyle.m6898getHyphensvmbZdU8();
    L95:
        if ((r417 & 8388608) == 0) goto L97;
        TextMotion r106 = r110.paragraphStyle.getTextMotion();
    L99:
        return r110.m7024copyp1EtxEg(r100, r101, r102, r103, r104, r105, r112, r113, r114, r115, r319, r320, r321, r322, r323, r324, r325, r419, r420, r421, r422, r423, r128, r106);
    L97:
        r106 = r416;
        goto L99
    L93:
        r128 = r415;
        goto L95
    L89:
        r127 = r414;
        goto L90
    L85:
        r126 = r413;
        goto L86
    L81:
        r125 = r412;
        goto L82
    L77:
        r124 = r411;
        goto L78
    L73:
        r123 = r410;
        goto L74
    L69:
        r122 = r318;
        goto L70
    L65:
        r121 = r317;
        goto L66
    L61:
        r120 = r316;
        goto L62
    L57:
        r119 = r315;
        goto L58
    L53:
        r118 = r314;
        goto L54
    L49:
        r117 = r313;
        goto L50
    L45:
        r116 = r312;
        goto L46
    L41:
        r115 = r311;
        goto L43
    L37:
        r114 = r310;
        goto L39
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: copy-v2rsoow$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m7012copyv2rsoow$default(TextStyle r110, long r111, long r210, FontWeight r211, FontStyle r212, FontSynthesis r213, FontFamily r214, String r215, long r216, BaselineShift r310, TextGeometricTransform r311, LocaleList r312, long r313, TextDecoration r314, Shadow r315, DrawStyle r316, TextAlign r317, TextDirection r318, long r410, TextIndent r411, PlatformTextStyle r412, LineHeightStyle r413, LineBreak r414, Hyphens r415, TextMotion r416, int r417, Object r418) {
        if ((r417 & 1) == 0) goto L5;
        long r100 = r110.spanStyle.m6939getColor0d7_KjU();
    L7:
        if ((r417 & 2) == 0) goto L9;
        long r101 = r110.spanStyle.m6940getFontSizeXSAIIZE();
    L11:
        if ((r417 & 4) == 0) goto L13;
        FontWeight r102 = r110.spanStyle.getFontWeight();
    L15:
        if ((r417 & 8) == 0) goto L17;
        FontStyle r103 = r110.spanStyle.m6941getFontStyle4Lr2A7w();
    L19:
        if ((r417 & 16) == 0) goto L21;
        FontSynthesis r104 = r110.spanStyle.m6942getFontSynthesisZQGJjVo();
    L23:
        if ((r417 & 32) == 0) goto L25;
        FontFamily r105 = r110.spanStyle.getFontFamily();
    L27:
        if ((r417 & 64) == 0) goto L29;
        String r112 = r110.spanStyle.getFontFeatureSettings();
    L31:
        if ((r417 & 128) == 0) goto L33;
        long r113 = r110.spanStyle.m6943getLetterSpacingXSAIIZE();
    L35:
        if ((r417 & 256) == 0) goto L37;
        BaselineShift r114 = r110.spanStyle.m6938getBaselineShift5SSeXJ0();
    L39:
        if ((r417 & 512) == 0) goto L41;
        TextGeometricTransform r115 = r110.spanStyle.getTextGeometricTransform();
    L43:
        if ((r417 & 1024) == 0) goto L45;
        LocaleList r116 = r110.spanStyle.getLocaleList();
    L46:
        LocaleList r319 = r116;
        if ((r417 & 2048) == 0) goto L49;
        long r117 = r110.spanStyle.m6937getBackground0d7_KjU();
    L50:
        long r320 = r117;
        if ((r417 & 4096) == 0) goto L53;
        TextDecoration r118 = r110.spanStyle.getTextDecoration();
    L54:
        TextDecoration r321 = r118;
        if ((r417 & 8192) == 0) goto L57;
        Shadow r119 = r110.spanStyle.getShadow();
    L58:
        Shadow r322 = r119;
        if ((r417 & 16384) == 0) goto L61;
        DrawStyle r120 = r110.spanStyle.getDrawStyle();
    L62:
        DrawStyle r323 = r120;
        if ((r417 & 32768) == 0) goto L65;
        TextAlign r121 = TextAlign.m7411boximpl(r110.paragraphStyle.m6903getTextAligne0LSkKk());
    L66:
        TextAlign r324 = r121;
        if ((r417 & 65536) == 0) goto L69;
        TextDirection r122 = TextDirection.m7425boximpl(r110.paragraphStyle.m6905getTextDirections_7Xco());
    L70:
        TextDirection r325 = r122;
        if ((r417 & 131072) == 0) goto L73;
        long r123 = r110.paragraphStyle.m6901getLineHeightXSAIIZE();
    L74:
        long r419 = r123;
        if ((r417 & 262144) == 0) goto L77;
        TextIndent r124 = r110.paragraphStyle.getTextIndent();
    L78:
        TextIndent r420 = r124;
        if ((r417 & 524288) == 0) goto L81;
        PlatformTextStyle r125 = r110.platformStyle;
    L82:
        PlatformTextStyle r421 = r125;
        if ((r417 & 1048576) == 0) goto L85;
        LineHeightStyle r126 = r110.paragraphStyle.getLineHeightStyle();
    L86:
        LineHeightStyle r422 = r126;
        if ((r417 & 2097152) == 0) goto L89;
        LineBreak r127 = LineBreak.m7319boximpl(r110.paragraphStyle.m6900getLineBreakrAG3T2k());
    L90:
        LineBreak r423 = r127;
        if ((r417 & 4194304) == 0) goto L93;
        Hyphens r128 = Hyphens.m7309boximpl(r110.paragraphStyle.m6898getHyphensvmbZdU8());
    L95:
        if ((r417 & 8388608) == 0) goto L97;
        TextMotion r106 = r110.paragraphStyle.getTextMotion();
    L99:
        return r110.m7025copyv2rsoow(r100, r101, r102, r103, r104, r105, r112, r113, r114, r115, r319, r320, r321, r322, r323, r324, r325, r419, r420, r421, r422, r423, r128, r106);
    L97:
        r106 = r416;
        goto L99
    L93:
        r128 = r415;
        goto L95
    L89:
        r127 = r414;
        goto L90
    L85:
        r126 = r413;
        goto L86
    L81:
        r125 = r412;
        goto L82
    L77:
        r124 = r411;
        goto L78
    L73:
        r123 = r410;
        goto L74
    L69:
        r122 = r318;
        goto L70
    L65:
        r121 = r317;
        goto L66
    L61:
        r120 = r316;
        goto L62
    L57:
        r119 = r315;
        goto L58
    L53:
        r118 = r314;
        goto L54
    L49:
        r117 = r313;
        goto L50
    L45:
        r116 = r312;
        goto L46
    L41:
        r115 = r311;
        goto L43
    L37:
        r114 = r310;
        goto L39
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: merge-Z1GrekI$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m7017mergeZ1GrekI$default(TextStyle r210, long r211, long r310, FontWeight r311, FontStyle r312, FontSynthesis r313, FontFamily r314, String r315, long r316, BaselineShift r410, TextGeometricTransform r411, LocaleList r412, long r413, TextDecoration r414, Shadow r415, DrawStyle r416, TextAlign r417, TextDirection r418, long r510, TextIndent r511, LineHeightStyle r512, LineBreak r513, Hyphens r514, PlatformTextStyle r515, TextMotion r516, int r517, Object r518) {
        if ((r517 & 1) == 0) goto L5;
        long r100 = Color.Companion.m4863getUnspecified0d7_KjU();
    L7:
        if ((r517 & 2) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r517 & 4) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r517 & 8) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r517 & 16) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r517 & 32) == 0) goto L25;
        FontFamily r105 = null;
    L27:
        if ((r517 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r517 & 128) == 0) goto L33;
        long r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r517 & 256) == 0) goto L37;
        BaselineShift r112 = null;
    L39:
        if ((r517 & 512) == 0) goto L41;
        TextGeometricTransform r113 = null;
    L43:
        if ((r517 & 1024) == 0) goto L45;
        LocaleList r114 = null;
    L47:
        if ((r517 & 2048) == 0) goto L49;
        long r115 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r517 & 4096) == 0) goto L53;
        TextDecoration r106 = null;
    L54:
        TextDecoration r419 = r106;
        if ((r517 & 8192) == 0) goto L57;
        Shadow r107 = null;
    L58:
        Shadow r420 = r107;
        if ((r517 & 16384) == 0) goto L61;
        DrawStyle r108 = null;
    L63:
        if ((r517 & 32768) == 0) goto L65;
        TextAlign r116 = null;
    L67:
        if ((r517 & 65536) == 0) goto L69;
        TextDirection r117 = null;
    L71:
        if ((r517 & 131072) == 0) goto L73;
        long r212 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L75:
        if ((r517 & 262144) == 0) goto L77;
        TextIndent r213 = null;
    L79:
        if ((r517 & 524288) == 0) goto L81;
        LineHeightStyle r214 = null;
    L83:
        if ((r517 & 1048576) == 0) goto L85;
        LineBreak r215 = null;
    L87:
        if ((r517 & 2097152) == 0) goto L89;
        Hyphens r216 = null;
    L91:
        if ((r517 & 4194304) == 0) goto L93;
        PlatformTextStyle r217 = null;
    L95:
        if ((r517 & 8388608) == 0) goto L97;
        TextMotion r109 = null;
    L99:
        return r210.m7042mergeZ1GrekI(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r419, r420, r108, r116, r117, r212, r213, r214, r215, r216, r217, r109);
    L97:
        r109 = r516;
        goto L99
    L93:
        r217 = r515;
        goto L95
    L89:
        r216 = r514;
        goto L91
    L85:
        r215 = r513;
        goto L87
    L81:
        r214 = r512;
        goto L83
    L77:
        r213 = r511;
        goto L79
    L73:
        r212 = r510;
        goto L75
    L69:
        r117 = r418;
        goto L71
    L65:
        r116 = r417;
        goto L67
    L61:
        r108 = r416;
        goto L63
    L57:
        r107 = r415;
        goto L58
    L53:
        r106 = r414;
        goto L54
    L49:
        r115 = r413;
        goto L51
    L45:
        r114 = r412;
        goto L47
    L41:
        r113 = r411;
        goto L43
    L37:
        r112 = r410;
        goto L39
    L33:
        r111 = r316;
        goto L35
    L29:
        r110 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    /* JADX INFO: renamed from: merge-dA7vx0o$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m7018mergedA7vx0o$default(TextStyle r210, long r211, long r310, FontWeight r311, FontStyle r312, FontSynthesis r313, FontFamily r314, String r315, long r316, BaselineShift r410, TextGeometricTransform r411, LocaleList r412, long r413, TextDecoration r414, Shadow r415, DrawStyle r416, int r417, int r418, long r510, TextIndent r511, LineHeightStyle r512, int r513, int r514, PlatformTextStyle r515, TextMotion r516, int r517, Object r518) {
        if ((r517 & 1) == 0) goto L5;
        long r100 = Color.Companion.m4863getUnspecified0d7_KjU();
    L7:
        if ((r517 & 2) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r517 & 4) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r517 & 8) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r517 & 16) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r517 & 32) == 0) goto L25;
        FontFamily r105 = null;
    L27:
        if ((r517 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r517 & 128) == 0) goto L33;
        long r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r517 & 256) == 0) goto L37;
        BaselineShift r112 = null;
    L39:
        if ((r517 & 512) == 0) goto L41;
        TextGeometricTransform r113 = null;
    L43:
        if ((r517 & 1024) == 0) goto L45;
        LocaleList r114 = null;
    L47:
        if ((r517 & 2048) == 0) goto L49;
        long r115 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r517 & 4096) == 0) goto L53;
        TextDecoration r106 = null;
    L54:
        TextDecoration r419 = r106;
        if ((r517 & 8192) == 0) goto L57;
        Shadow r107 = null;
    L58:
        Shadow r420 = r107;
        if ((r517 & 16384) == 0) goto L61;
        DrawStyle r108 = null;
    L63:
        if ((r517 & 32768) == 0) goto L65;
        int r116 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
    L67:
        if ((r517 & 65536) == 0) goto L69;
        int r117 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
    L71:
        if ((r517 & 131072) == 0) goto L73;
        long r212 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L75:
        if ((r517 & 262144) == 0) goto L77;
        TextIndent r213 = null;
    L79:
        if ((r517 & 524288) == 0) goto L81;
        LineHeightStyle r214 = null;
    L83:
        if ((r517 & 1048576) == 0) goto L85;
        int r215 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
    L87:
        if ((r517 & 2097152) == 0) goto L89;
        int r216 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
    L91:
        if ((r517 & 4194304) == 0) goto L93;
        PlatformTextStyle r217 = null;
    L95:
        if ((r517 & 8388608) == 0) goto L97;
        TextMotion r109 = null;
    L99:
        return r210.m7043mergedA7vx0o(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r419, r420, r108, r116, r117, r212, r213, r214, r215, r216, r217, r109);
    L97:
        r109 = r516;
        goto L99
    L93:
        r217 = r515;
        goto L95
    L89:
        r216 = r514;
        goto L91
    L85:
        r215 = r513;
        goto L87
    L81:
        r214 = r512;
        goto L83
    L77:
        r213 = r511;
        goto L79
    L73:
        r212 = r510;
        goto L75
    L69:
        r117 = r418;
        goto L71
    L65:
        r116 = r417;
        goto L67
    L61:
        r108 = r416;
        goto L63
    L57:
        r107 = r415;
        goto L58
    L53:
        r106 = r414;
        goto L54
    L49:
        r115 = r413;
        goto L51
    L45:
        r114 = r412;
        goto L47
    L41:
        r113 = r411;
        goto L43
    L37:
        r112 = r410;
        goto L39
    L33:
        r111 = r316;
        goto L35
    L29:
        r110 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public /* synthetic */ TextStyle(Brush r310, float r311, long r312, FontWeight r313, FontStyle r314, FontSynthesis r410, FontFamily r411, String r412, long r413, BaselineShift r414, TextGeometricTransform r415, LocaleList r416, long r417, TextDecoration r510, Shadow r511, DrawStyle r512, TextAlign r513, TextDirection r514, long r515, TextIndent r516, PlatformTextStyle r517, LineHeightStyle r518, LineBreak r610, Hyphens r611, TextMotion r612, int r613, DefaultConstructorMarker r614) {
        if ((r613 & 2) == 0) goto L5;
        float r100 = Float.NaN;
    L7:
        if ((r613 & 4) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r613 & 8) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r613 & 16) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r613 & 32) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r613 & 64) == 0) goto L25;
        FontFamily r110 = null;
    L27:
        if ((r613 & 128) == 0) goto L29;
        String r111 = null;
    L31:
        if ((r613 & 256) == 0) goto L33;
        long r112 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r613 & 512) == 0) goto L37;
        BaselineShift r113 = null;
    L39:
        if ((r613 & 1024) == 0) goto L41;
        TextGeometricTransform r114 = null;
    L43:
        if ((r613 & 2048) == 0) goto L45;
        LocaleList r115 = null;
    L47:
        if ((r613 & 4096) == 0) goto L49;
        long r116 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r613 & 8192) == 0) goto L53;
        TextDecoration r117 = null;
    L55:
        if ((r613 & 16384) == 0) goto L57;
        Shadow r210 = null;
    L59:
        if ((32768 & r613) == 0) goto L61;
        DrawStyle r211 = null;
    L63:
        if ((65536 & r613) == 0) goto L65;
        TextAlign r212 = null;
    L67:
        if ((131072 & r613) == 0) goto L69;
        TextDirection r213 = null;
    L71:
        if ((262144 & r613) == 0) goto L73;
        long r214 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L75:
        if ((524288 & r613) == 0) goto L77;
        TextIndent r215 = null;
    L79:
        if ((1048576 & r613) == 0) goto L81;
        PlatformTextStyle r216 = null;
    L83:
        if ((2097152 & r613) == 0) goto L85;
        LineHeightStyle r217 = null;
    L87:
        if ((4194304 & r613) == 0) goto L89;
        LineBreak r218 = null;
    L91:
        if ((8388608 & r613) == 0) goto L93;
        Hyphens r315 = null;
    L95:
        if ((r613 & 16777216) == 0) goto L97;
        TextMotion r316 = null;
    L98:
        this(r310, r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218, r315, r316, null);
        return;
    L97:
        r316 = r612;
        goto L98
    L93:
        r315 = r611;
        goto L95
    L89:
        r218 = r610;
        goto L91
    L85:
        r217 = r518;
        goto L87
    L81:
        r216 = r517;
        goto L83
    L77:
        r215 = r516;
        goto L79
    L73:
        r214 = r515;
        goto L75
    L69:
        r213 = r514;
        goto L71
    L65:
        r212 = r513;
        goto L67
    L61:
        r211 = r512;
        goto L63
    L57:
        r210 = r511;
        goto L59
    L53:
        r117 = r510;
        goto L55
    L49:
        r116 = r417;
        goto L51
    L45:
        r115 = r416;
        goto L47
    L41:
        r114 = r415;
        goto L43
    L37:
        r113 = r414;
        goto L39
    L33:
        r112 = r413;
        goto L35
    L29:
        r111 = r412;
        goto L31
    L25:
        r110 = r411;
        goto L27
    L21:
        r104 = r410;
        goto L23
    L17:
        r103 = r314;
        goto L19
    L13:
        r102 = r313;
        goto L15
    L9:
        r101 = r312;
        goto L11
    L5:
        r100 = r311;
        goto L7
    }

    /* JADX INFO: renamed from: copy-Ns73l9s$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m7009copyNs73l9s$default(TextStyle r210, Brush r310, float r311, long r312, FontWeight r313, FontStyle r314, FontSynthesis r315, FontFamily r316, String r317, long r318, BaselineShift r410, TextGeometricTransform r411, LocaleList r412, long r413, TextDecoration r414, Shadow r415, DrawStyle r416, int r417, int r510, long r511, TextIndent r512, PlatformTextStyle r513, LineHeightStyle r514, int r515, int r516, TextMotion r517, int r518, Object r610) {
        if ((r518 & 2) == 0) goto L5;
        float r100 = r210.spanStyle.getAlpha();
    L7:
        if ((r518 & 4) == 0) goto L9;
        long r101 = r210.spanStyle.m6940getFontSizeXSAIIZE();
    L11:
        if ((r518 & 8) == 0) goto L13;
        FontWeight r102 = r210.spanStyle.getFontWeight();
    L15:
        if ((r518 & 16) == 0) goto L17;
        FontStyle r103 = r210.spanStyle.m6941getFontStyle4Lr2A7w();
    L19:
        if ((r518 & 32) == 0) goto L21;
        FontSynthesis r104 = r210.spanStyle.m6942getFontSynthesisZQGJjVo();
    L23:
        if ((r518 & 64) == 0) goto L25;
        FontFamily r105 = r210.spanStyle.getFontFamily();
    L27:
        if ((r518 & 128) == 0) goto L29;
        String r106 = r210.spanStyle.getFontFeatureSettings();
    L31:
        if ((r518 & 256) == 0) goto L33;
        long r110 = r210.spanStyle.m6943getLetterSpacingXSAIIZE();
    L35:
        if ((r518 & 512) == 0) goto L37;
        BaselineShift r111 = r210.spanStyle.m6938getBaselineShift5SSeXJ0();
    L39:
        if ((r518 & 1024) == 0) goto L41;
        TextGeometricTransform r112 = r210.spanStyle.getTextGeometricTransform();
    L43:
        if ((r518 & 2048) == 0) goto L45;
        LocaleList r113 = r210.spanStyle.getLocaleList();
    L47:
        if ((r518 & 4096) == 0) goto L49;
        long r114 = r210.spanStyle.m6937getBackground0d7_KjU();
    L50:
        long r115 = r114;
        if ((r518 & 8192) == 0) goto L53;
        TextDecoration r116 = r210.spanStyle.getTextDecoration();
    L54:
        TextDecoration r611 = r116;
        if ((r518 & 16384) == 0) goto L57;
        Shadow r117 = r210.spanStyle.getShadow();
    L59:
        if ((r518 & 32768) == 0) goto L61;
        DrawStyle r118 = r210.spanStyle.getDrawStyle();
    L63:
        if ((r518 & 65536) == 0) goto L65;
        int r119 = r210.paragraphStyle.m6903getTextAligne0LSkKk();
    L67:
        if ((r518 & 131072) == 0) goto L69;
        int r120 = r210.paragraphStyle.m6905getTextDirections_7Xco();
    L71:
        if ((r518 & 262144) == 0) goto L73;
        long r211 = r210.paragraphStyle.m6901getLineHeightXSAIIZE();
    L75:
        if ((524288 & r518) == 0) goto L77;
        TextIndent r121 = r210.paragraphStyle.getTextIndent();
    L79:
        if ((r518 & 1048576) == 0) goto L81;
        PlatformTextStyle r122 = r210.platformStyle;
    L83:
        if ((r518 & 2097152) == 0) goto L85;
        LineHeightStyle r123 = r210.paragraphStyle.getLineHeightStyle();
    L87:
        if ((r518 & 4194304) == 0) goto L89;
        int r124 = r210.paragraphStyle.m6900getLineBreakrAG3T2k();
    L91:
        if ((r518 & 8388608) == 0) goto L93;
        int r125 = r210.paragraphStyle.m6898getHyphensvmbZdU8();
    L95:
        if ((r518 & 16777216) == 0) goto L97;
        TextMotion r107 = r210.paragraphStyle.getTextMotion();
    L99:
        return r210.m7022copyNs73l9s(r310, r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r115, r611, r117, r118, r119, r120, r211, r121, r122, r123, r124, r125, r107);
    L97:
        r107 = r517;
        goto L99
    L93:
        r125 = r516;
        goto L95
    L89:
        r124 = r515;
        goto L91
    L85:
        r123 = r514;
        goto L87
    L81:
        r122 = r513;
        goto L83
    L77:
        r121 = r512;
        goto L79
    L73:
        r211 = r511;
        goto L75
    L69:
        r120 = r510;
        goto L71
    L65:
        r119 = r417;
        goto L67
    L61:
        r118 = r416;
        goto L63
    L57:
        r117 = r415;
        goto L59
    L53:
        r116 = r414;
        goto L54
    L49:
        r114 = r413;
        goto L50
    L45:
        r113 = r412;
        goto L47
    L41:
        r112 = r411;
        goto L43
    L37:
        r111 = r410;
        goto L39
    L33:
        r110 = r318;
        goto L35
    L29:
        r106 = r317;
        goto L31
    L25:
        r105 = r316;
        goto L27
    L21:
        r104 = r315;
        goto L23
    L17:
        r103 = r314;
        goto L19
    L13:
        r102 = r313;
        goto L15
    L9:
        r101 = r312;
        goto L11
    L5:
        r100 = r311;
        goto L7
    }

    /* JADX INFO: renamed from: copy-aIRg9q4$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m7010copyaIRg9q4$default(TextStyle r210, Brush r310, float r311, long r312, FontWeight r313, FontStyle r314, FontSynthesis r315, FontFamily r316, String r317, long r318, BaselineShift r410, TextGeometricTransform r411, LocaleList r412, long r413, TextDecoration r414, Shadow r415, DrawStyle r416, TextAlign r417, TextDirection r510, long r511, TextIndent r512, PlatformTextStyle r513, LineHeightStyle r514, LineBreak r515, Hyphens r516, TextMotion r517, int r518, Object r610) {
        if ((r518 & 2) == 0) goto L5;
        float r100 = r210.spanStyle.getAlpha();
    L7:
        if ((r518 & 4) == 0) goto L9;
        long r101 = r210.spanStyle.m6940getFontSizeXSAIIZE();
    L11:
        if ((r518 & 8) == 0) goto L13;
        FontWeight r102 = r210.spanStyle.getFontWeight();
    L15:
        if ((r518 & 16) == 0) goto L17;
        FontStyle r103 = r210.spanStyle.m6941getFontStyle4Lr2A7w();
    L19:
        if ((r518 & 32) == 0) goto L21;
        FontSynthesis r104 = r210.spanStyle.m6942getFontSynthesisZQGJjVo();
    L23:
        if ((r518 & 64) == 0) goto L25;
        FontFamily r105 = r210.spanStyle.getFontFamily();
    L27:
        if ((r518 & 128) == 0) goto L29;
        String r106 = r210.spanStyle.getFontFeatureSettings();
    L31:
        if ((r518 & 256) == 0) goto L33;
        long r110 = r210.spanStyle.m6943getLetterSpacingXSAIIZE();
    L35:
        if ((r518 & 512) == 0) goto L37;
        BaselineShift r111 = r210.spanStyle.m6938getBaselineShift5SSeXJ0();
    L39:
        if ((r518 & 1024) == 0) goto L41;
        TextGeometricTransform r112 = r210.spanStyle.getTextGeometricTransform();
    L43:
        if ((r518 & 2048) == 0) goto L45;
        LocaleList r113 = r210.spanStyle.getLocaleList();
    L47:
        if ((r518 & 4096) == 0) goto L49;
        long r114 = r210.spanStyle.m6937getBackground0d7_KjU();
    L50:
        long r115 = r114;
        if ((r518 & 8192) == 0) goto L53;
        TextDecoration r116 = r210.spanStyle.getTextDecoration();
    L54:
        TextDecoration r611 = r116;
        if ((r518 & 16384) == 0) goto L57;
        Shadow r117 = r210.spanStyle.getShadow();
    L59:
        if ((r518 & 32768) == 0) goto L61;
        DrawStyle r118 = r210.spanStyle.getDrawStyle();
    L63:
        if ((r518 & 65536) == 0) goto L65;
        TextAlign r119 = TextAlign.m7411boximpl(r210.paragraphStyle.m6903getTextAligne0LSkKk());
    L67:
        if ((r518 & 131072) == 0) goto L69;
        TextDirection r120 = TextDirection.m7425boximpl(r210.paragraphStyle.m6905getTextDirections_7Xco());
    L71:
        if ((r518 & 262144) == 0) goto L73;
        long r211 = r210.paragraphStyle.m6901getLineHeightXSAIIZE();
    L75:
        if ((524288 & r518) == 0) goto L77;
        TextIndent r121 = r210.paragraphStyle.getTextIndent();
    L79:
        if ((r518 & 1048576) == 0) goto L81;
        PlatformTextStyle r122 = r210.platformStyle;
    L83:
        if ((r518 & 2097152) == 0) goto L85;
        LineHeightStyle r123 = r210.paragraphStyle.getLineHeightStyle();
    L87:
        if ((r518 & 4194304) == 0) goto L89;
        LineBreak r124 = LineBreak.m7319boximpl(r210.paragraphStyle.m6900getLineBreakrAG3T2k());
    L91:
        if ((r518 & 8388608) == 0) goto L93;
        Hyphens r125 = Hyphens.m7309boximpl(r210.paragraphStyle.m6898getHyphensvmbZdU8());
    L95:
        if ((r518 & 16777216) == 0) goto L97;
        TextMotion r107 = r210.paragraphStyle.getTextMotion();
    L99:
        return r210.m7023copyaIRg9q4(r310, r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r115, r611, r117, r118, r119, r120, r211, r121, r122, r123, r124, r125, r107);
    L97:
        r107 = r517;
        goto L99
    L93:
        r125 = r516;
        goto L95
    L89:
        r124 = r515;
        goto L91
    L85:
        r123 = r514;
        goto L87
    L81:
        r122 = r513;
        goto L83
    L77:
        r121 = r512;
        goto L79
    L73:
        r211 = r511;
        goto L75
    L69:
        r120 = r510;
        goto L71
    L65:
        r119 = r417;
        goto L67
    L61:
        r118 = r416;
        goto L63
    L57:
        r117 = r415;
        goto L59
    L53:
        r116 = r414;
        goto L54
    L49:
        r114 = r413;
        goto L50
    L45:
        r113 = r412;
        goto L47
    L41:
        r112 = r411;
        goto L43
    L37:
        r111 = r410;
        goto L39
    L33:
        r110 = r318;
        goto L35
    L29:
        r106 = r317;
        goto L31
    L25:
        r105 = r316;
        goto L27
    L21:
        r104 = r315;
        goto L23
    L17:
        r103 = r314;
        goto L19
    L13:
        r102 = r313;
        goto L15
    L9:
        r101 = r312;
        goto L11
    L5:
        r100 = r311;
        goto L7
    }
}
