package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B§\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(Bñ\u0001\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b'\u0010)Jø\u0002\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+J´\u0002\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104R\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u00102\u001a\u0004\b5\u00104R\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u00102\u001a\u0004\b6\u00104R\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u00102\u001a\u0004\b7\u00104R\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b8\u00104R\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u00102\u001a\u0004\b9\u00104R\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b:\u00104R\u001d\u0010\n\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u00102\u001a\u0004\b;\u00104R\u001d\u0010\u000b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u00102\u001a\u0004\b<\u00104R\u001d\u0010\f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\f\u00102\u001a\u0004\b=\u00104R\u001d\u0010\r\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u00102\u001a\u0004\b>\u00104R\u001d\u0010\u000e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u00102\u001a\u0004\b?\u00104R\u001d\u0010\u000f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000f\u00102\u001a\u0004\b@\u00104R\u001d\u0010\u0010\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0010\u00102\u001a\u0004\bA\u00104R\u001d\u0010\u0011\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u00102\u001a\u0004\bB\u00104R\u001d\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0012\u00102\u001a\u0004\bC\u00104R\u001d\u0010\u0013\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u00102\u001a\u0004\bD\u00104R\u001d\u0010\u0014\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0014\u00102\u001a\u0004\bE\u00104R\u001d\u0010\u0015\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0015\u00102\u001a\u0004\bF\u00104R\u001d\u0010\u0016\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0016\u00102\u001a\u0004\bG\u00104R\u001d\u0010\u0017\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0017\u00102\u001a\u0004\bH\u00104R\u001d\u0010\u0018\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\bI\u00104R\u001d\u0010\u0019\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\bJ\u00104R\u001d\u0010\u001a\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\bK\u00104R\u001d\u0010\u001b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\bL\u00104R\u001d\u0010\u001c\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\bM\u00104R\u001d\u0010\u001d\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\bN\u00104R\u001d\u0010\u001e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\bO\u00104R\u001d\u0010\u001f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\bP\u00104R\u001d\u0010 \u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b \u00102\u001a\u0004\bQ\u00104R\u001d\u0010!\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b!\u00102\u001a\u0004\bR\u00104R\u001d\u0010\"\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\"\u00102\u001a\u0004\bS\u00104R\u001d\u0010#\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b#\u00102\u001a\u0004\bT\u00104R\u001d\u0010$\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b$\u00102\u001a\u0004\bU\u00104R\u001d\u0010%\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b%\u00102\u001a\u0004\bV\u00104R\u001d\u0010&\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b&\u00102\u001a\u0004\bW\u00104R$\u0010Y\u001a\u0004\u0018\u00010X8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R$\u0010_\u001a\u0004\u0018\u00010X8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b_\u0010Z\u001a\u0004\b`\u0010\\\"\u0004\ba\u0010^R$\u0010b\u001a\u0004\u0018\u00010X8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bb\u0010Z\u001a\u0004\bc\u0010\\\"\u0004\bd\u0010^R$\u0010e\u001a\u0004\u0018\u00010X8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\be\u0010Z\u001a\u0004\bf\u0010\\\"\u0004\bg\u0010^R$\u0010h\u001a\u0004\u0018\u00010X8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bh\u0010Z\u001a\u0004\bi\u0010\\\"\u0004\bj\u0010^R$\u0010l\u001a\u0004\u0018\u00010k8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR$\u0010r\u001a\u0004\u0018\u00010k8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\br\u0010m\u001a\u0004\bs\u0010o\"\u0004\bt\u0010qR$\u0010u\u001a\u0004\u0018\u00010k8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bu\u0010m\u001a\u0004\bv\u0010o\"\u0004\bw\u0010qR$\u0010y\u001a\u0004\u0018\u00010x8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R&\u0010\u007f\u001a\u0004\u0018\u00010x8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010z\u001a\u0005\b\u0080\u0001\u0010|\"\u0005\b\u0081\u0001\u0010~R(\u0010\u0082\u0001\u001a\u0004\u0018\u00010x8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010z\u001a\u0005\b\u0083\u0001\u0010|\"\u0005\b\u0084\u0001\u0010~R(\u0010\u0085\u0001\u001a\u0004\u0018\u00010x8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010z\u001a\u0005\b\u0086\u0001\u0010|\"\u0005\b\u0087\u0001\u0010~R,\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R,\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u008a\u0001\u001a\u0006\b\u0090\u0001\u0010\u008c\u0001\"\u0006\b\u0091\u0001\u0010\u008e\u0001R,\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u008a\u0001\u001a\u0006\b\u0093\u0001\u0010\u008c\u0001\"\u0006\b\u0094\u0001\u0010\u008e\u0001R4\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b\u0096\u0001\u0010\u0097\u0001\u0012\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R4\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b\u009e\u0001\u0010\u0097\u0001\u0012\u0006\b¡\u0001\u0010\u009d\u0001\u001a\u0006\b\u009f\u0001\u0010\u0099\u0001\"\u0006\b \u0001\u0010\u009b\u0001R4\u0010¢\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b¢\u0001\u0010\u0097\u0001\u0012\u0006\b¥\u0001\u0010\u009d\u0001\u001a\u0006\b£\u0001\u0010\u0099\u0001\"\u0006\b¤\u0001\u0010\u009b\u0001R4\u0010¦\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b¦\u0001\u0010\u0097\u0001\u0012\u0006\b©\u0001\u0010\u009d\u0001\u001a\u0006\b§\u0001\u0010\u0099\u0001\"\u0006\b¨\u0001\u0010\u009b\u0001R,\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R4\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b²\u0001\u0010³\u0001\u0012\u0006\b¸\u0001\u0010\u009d\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R,\u0010º\u0001\u001a\u0005\u0018\u00010¹\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R,\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R,\u0010Ç\u0001\u001a\u0005\u0018\u00010¹\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÇ\u0001\u0010»\u0001\u001a\u0006\bÈ\u0001\u0010½\u0001\"\u0006\bÉ\u0001\u0010¿\u0001R,\u0010Ê\u0001\u001a\u0005\u0018\u00010À\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Â\u0001\u001a\u0006\bË\u0001\u0010Ä\u0001\"\u0006\bÌ\u0001\u0010Æ\u0001R,\u0010Í\u0001\u001a\u0005\u0018\u00010¹\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÍ\u0001\u0010»\u0001\u001a\u0006\bÎ\u0001\u0010½\u0001\"\u0006\bÏ\u0001\u0010¿\u0001R,\u0010Ð\u0001\u001a\u0005\u0018\u00010À\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010Â\u0001\u001a\u0006\bÑ\u0001\u0010Ä\u0001\"\u0006\bÒ\u0001\u0010Æ\u0001R,\u0010Ó\u0001\u001a\u0005\u0018\u00010¹\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÓ\u0001\u0010»\u0001\u001a\u0006\bÔ\u0001\u0010½\u0001\"\u0006\bÕ\u0001\u0010¿\u0001R,\u0010Ö\u0001\u001a\u0005\u0018\u00010À\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÖ\u0001\u0010Â\u0001\u001a\u0006\b×\u0001\u0010Ä\u0001\"\u0006\bØ\u0001\u0010Æ\u0001R,\u0010Ú\u0001\u001a\u0005\u0018\u00010Ù\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÚ\u0001\u0010Û\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R,\u0010á\u0001\u001a\u0005\u0018\u00010à\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001\"\u0006\bå\u0001\u0010æ\u0001R,\u0010è\u0001\u001a\u0005\u0018\u00010ç\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bè\u0001\u0010é\u0001\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R,\u0010ï\u0001\u001a\u0005\u0018\u00010î\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bï\u0001\u0010ð\u0001\u001a\u0006\bñ\u0001\u0010ò\u0001\"\u0006\bó\u0001\u0010ô\u0001R,\u0010ö\u0001\u001a\u0005\u0018\u00010õ\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bö\u0001\u0010÷\u0001\u001a\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R4\u0010ý\u0001\u001a\u0005\u0018\u00010ü\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\bý\u0001\u0010þ\u0001\u0012\u0006\b\u0083\u0002\u0010\u009d\u0001\u001a\u0006\bÿ\u0001\u0010\u0080\u0002\"\u0006\b\u0081\u0002\u0010\u0082\u0002R,\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u0084\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0085\u0002\u0010\u0086\u0002\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002\"\u0006\b\u0089\u0002\u0010\u008a\u0002R,\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u008b\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008c\u0002\u0010\u008d\u0002\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002\"\u0006\b\u0090\u0002\u0010\u0091\u0002R,\u0010\u0093\u0002\u001a\u0005\u0018\u00010\u0092\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0093\u0002\u0010\u0094\u0002\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002\"\u0006\b\u0097\u0002\u0010\u0098\u0002R,\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0092\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0099\u0002\u0010\u0094\u0002\u001a\u0006\b\u009a\u0002\u0010\u0096\u0002\"\u0006\b\u009b\u0002\u0010\u0098\u0002R4\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009c\u00028\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b\u009d\u0002\u0010\u009e\u0002\u0012\u0006\b£\u0002\u0010\u009d\u0001\u001a\u0006\b\u009f\u0002\u0010 \u0002\"\u0006\b¡\u0002\u0010¢\u0002R4\u0010¥\u0002\u001a\u0005\u0018\u00010¤\u00028\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b¥\u0002\u0010¦\u0002\u0012\u0006\b«\u0002\u0010\u009d\u0001\u001a\u0006\b§\u0002\u0010¨\u0002\"\u0006\b©\u0002\u0010ª\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¬\u0002"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "", "Landroidx/compose/ui/graphics/Color;", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceDim", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", AppAgent.CONSTRUCT, "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/e;)V", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/e;)V", "copy-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "copy", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "", "toString", "()Ljava/lang/String;", "J", "getPrimary-0d7_KjU", "()J", "getOnPrimary-0d7_KjU", "getPrimaryContainer-0d7_KjU", "getOnPrimaryContainer-0d7_KjU", "getInversePrimary-0d7_KjU", "getSecondary-0d7_KjU", "getOnSecondary-0d7_KjU", "getSecondaryContainer-0d7_KjU", "getOnSecondaryContainer-0d7_KjU", "getTertiary-0d7_KjU", "getOnTertiary-0d7_KjU", "getTertiaryContainer-0d7_KjU", "getOnTertiaryContainer-0d7_KjU", "getBackground-0d7_KjU", "getOnBackground-0d7_KjU", "getSurface-0d7_KjU", "getOnSurface-0d7_KjU", "getSurfaceVariant-0d7_KjU", "getOnSurfaceVariant-0d7_KjU", "getSurfaceTint-0d7_KjU", "getInverseSurface-0d7_KjU", "getInverseOnSurface-0d7_KjU", "getError-0d7_KjU", "getOnError-0d7_KjU", "getErrorContainer-0d7_KjU", "getOnErrorContainer-0d7_KjU", "getOutline-0d7_KjU", "getOutlineVariant-0d7_KjU", "getScrim-0d7_KjU", "getSurfaceBright-0d7_KjU", "getSurfaceDim-0d7_KjU", "getSurfaceContainer-0d7_KjU", "getSurfaceContainerHigh-0d7_KjU", "getSurfaceContainerHighest-0d7_KjU", "getSurfaceContainerLow-0d7_KjU", "getSurfaceContainerLowest-0d7_KjU", "Landroidx/compose/material3/ButtonColors;", "defaultButtonColorsCached", "Landroidx/compose/material3/ButtonColors;", "getDefaultButtonColorsCached$material3_release", "()Landroidx/compose/material3/ButtonColors;", "setDefaultButtonColorsCached$material3_release", "(Landroidx/compose/material3/ButtonColors;)V", "defaultElevatedButtonColorsCached", "getDefaultElevatedButtonColorsCached$material3_release", "setDefaultElevatedButtonColorsCached$material3_release", "defaultFilledTonalButtonColorsCached", "getDefaultFilledTonalButtonColorsCached$material3_release", "setDefaultFilledTonalButtonColorsCached$material3_release", "defaultOutlinedButtonColorsCached", "getDefaultOutlinedButtonColorsCached$material3_release", "setDefaultOutlinedButtonColorsCached$material3_release", "defaultTextButtonColorsCached", "getDefaultTextButtonColorsCached$material3_release", "setDefaultTextButtonColorsCached$material3_release", "Landroidx/compose/material3/CardColors;", "defaultCardColorsCached", "Landroidx/compose/material3/CardColors;", "getDefaultCardColorsCached$material3_release", "()Landroidx/compose/material3/CardColors;", "setDefaultCardColorsCached$material3_release", "(Landroidx/compose/material3/CardColors;)V", "defaultElevatedCardColorsCached", "getDefaultElevatedCardColorsCached$material3_release", "setDefaultElevatedCardColorsCached$material3_release", "defaultOutlinedCardColorsCached", "getDefaultOutlinedCardColorsCached$material3_release", "setDefaultOutlinedCardColorsCached$material3_release", "Landroidx/compose/material3/ChipColors;", "defaultAssistChipColorsCached", "Landroidx/compose/material3/ChipColors;", "getDefaultAssistChipColorsCached$material3_release", "()Landroidx/compose/material3/ChipColors;", "setDefaultAssistChipColorsCached$material3_release", "(Landroidx/compose/material3/ChipColors;)V", "defaultElevatedAssistChipColorsCached", "getDefaultElevatedAssistChipColorsCached$material3_release", "setDefaultElevatedAssistChipColorsCached$material3_release", "defaultSuggestionChipColorsCached", "getDefaultSuggestionChipColorsCached$material3_release", "setDefaultSuggestionChipColorsCached$material3_release", "defaultElevatedSuggestionChipColorsCached", "getDefaultElevatedSuggestionChipColorsCached$material3_release", "setDefaultElevatedSuggestionChipColorsCached$material3_release", "Landroidx/compose/material3/SelectableChipColors;", "defaultFilterChipColorsCached", "Landroidx/compose/material3/SelectableChipColors;", "getDefaultFilterChipColorsCached$material3_release", "()Landroidx/compose/material3/SelectableChipColors;", "setDefaultFilterChipColorsCached$material3_release", "(Landroidx/compose/material3/SelectableChipColors;)V", "defaultElevatedFilterChipColorsCached", "getDefaultElevatedFilterChipColorsCached$material3_release", "setDefaultElevatedFilterChipColorsCached$material3_release", "defaultInputChipColorsCached", "getDefaultInputChipColorsCached$material3_release", "setDefaultInputChipColorsCached$material3_release", "Landroidx/compose/material3/TopAppBarColors;", "defaultTopAppBarColorsCached", "Landroidx/compose/material3/TopAppBarColors;", "getDefaultTopAppBarColorsCached$material3_release", "()Landroidx/compose/material3/TopAppBarColors;", "setDefaultTopAppBarColorsCached$material3_release", "(Landroidx/compose/material3/TopAppBarColors;)V", "getDefaultTopAppBarColorsCached$material3_release$annotations", "()V", "defaultCenterAlignedTopAppBarColorsCached", "getDefaultCenterAlignedTopAppBarColorsCached$material3_release", "setDefaultCenterAlignedTopAppBarColorsCached$material3_release", "getDefaultCenterAlignedTopAppBarColorsCached$material3_release$annotations", "defaultMediumTopAppBarColorsCached", "getDefaultMediumTopAppBarColorsCached$material3_release", "setDefaultMediumTopAppBarColorsCached$material3_release", "getDefaultMediumTopAppBarColorsCached$material3_release$annotations", "defaultLargeTopAppBarColorsCached", "getDefaultLargeTopAppBarColorsCached$material3_release", "setDefaultLargeTopAppBarColorsCached$material3_release", "getDefaultLargeTopAppBarColorsCached$material3_release$annotations", "Landroidx/compose/material3/CheckboxColors;", "defaultCheckboxColorsCached", "Landroidx/compose/material3/CheckboxColors;", "getDefaultCheckboxColorsCached$material3_release", "()Landroidx/compose/material3/CheckboxColors;", "setDefaultCheckboxColorsCached$material3_release", "(Landroidx/compose/material3/CheckboxColors;)V", "Landroidx/compose/material3/DatePickerColors;", "defaultDatePickerColorsCached", "Landroidx/compose/material3/DatePickerColors;", "getDefaultDatePickerColorsCached$material3_release", "()Landroidx/compose/material3/DatePickerColors;", "setDefaultDatePickerColorsCached$material3_release", "(Landroidx/compose/material3/DatePickerColors;)V", "getDefaultDatePickerColorsCached$material3_release$annotations", "Landroidx/compose/material3/IconButtonColors;", "defaultIconButtonColorsCached", "Landroidx/compose/material3/IconButtonColors;", "getDefaultIconButtonColorsCached$material3_release", "()Landroidx/compose/material3/IconButtonColors;", "setDefaultIconButtonColorsCached$material3_release", "(Landroidx/compose/material3/IconButtonColors;)V", "Landroidx/compose/material3/IconToggleButtonColors;", "defaultIconToggleButtonColorsCached", "Landroidx/compose/material3/IconToggleButtonColors;", "getDefaultIconToggleButtonColorsCached$material3_release", "()Landroidx/compose/material3/IconToggleButtonColors;", "setDefaultIconToggleButtonColorsCached$material3_release", "(Landroidx/compose/material3/IconToggleButtonColors;)V", "defaultFilledIconButtonColorsCached", "getDefaultFilledIconButtonColorsCached$material3_release", "setDefaultFilledIconButtonColorsCached$material3_release", "defaultFilledIconToggleButtonColorsCached", "getDefaultFilledIconToggleButtonColorsCached$material3_release", "setDefaultFilledIconToggleButtonColorsCached$material3_release", "defaultFilledTonalIconButtonColorsCached", "getDefaultFilledTonalIconButtonColorsCached$material3_release", "setDefaultFilledTonalIconButtonColorsCached$material3_release", "defaultFilledTonalIconToggleButtonColorsCached", "getDefaultFilledTonalIconToggleButtonColorsCached$material3_release", "setDefaultFilledTonalIconToggleButtonColorsCached$material3_release", "defaultOutlinedIconButtonColorsCached", "getDefaultOutlinedIconButtonColorsCached$material3_release", "setDefaultOutlinedIconButtonColorsCached$material3_release", "defaultOutlinedIconToggleButtonColorsCached", "getDefaultOutlinedIconToggleButtonColorsCached$material3_release", "setDefaultOutlinedIconToggleButtonColorsCached$material3_release", "Landroidx/compose/material3/MenuItemColors;", "defaultMenuItemColorsCached", "Landroidx/compose/material3/MenuItemColors;", "getDefaultMenuItemColorsCached$material3_release", "()Landroidx/compose/material3/MenuItemColors;", "setDefaultMenuItemColorsCached$material3_release", "(Landroidx/compose/material3/MenuItemColors;)V", "Landroidx/compose/material3/NavigationBarItemColors;", "defaultNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationBarItemColors;", "getDefaultNavigationBarItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationBarItemColors;", "setDefaultNavigationBarItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationBarItemColors;)V", "Landroidx/compose/material3/NavigationRailItemColors;", "defaultNavigationRailItemColorsCached", "Landroidx/compose/material3/NavigationRailItemColors;", "getDefaultNavigationRailItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationRailItemColors;", "setDefaultNavigationRailItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationRailItemColors;)V", "Landroidx/compose/material3/NavigationItemColors;", "defaultExpressiveNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationItemColors;", "getDefaultExpressiveNavigationBarItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationItemColors;", "setDefaultExpressiveNavigationBarItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationItemColors;)V", "Landroidx/compose/material3/RadioButtonColors;", "defaultRadioButtonColorsCached", "Landroidx/compose/material3/RadioButtonColors;", "getDefaultRadioButtonColorsCached$material3_release", "()Landroidx/compose/material3/RadioButtonColors;", "setDefaultRadioButtonColorsCached$material3_release", "(Landroidx/compose/material3/RadioButtonColors;)V", "Landroidx/compose/material3/SegmentedButtonColors;", "defaultSegmentedButtonColorsCached", "Landroidx/compose/material3/SegmentedButtonColors;", "getDefaultSegmentedButtonColorsCached$material3_release", "()Landroidx/compose/material3/SegmentedButtonColors;", "setDefaultSegmentedButtonColorsCached$material3_release", "(Landroidx/compose/material3/SegmentedButtonColors;)V", "getDefaultSegmentedButtonColorsCached$material3_release$annotations", "Landroidx/compose/material3/SliderColors;", "defaultSliderColorsCached", "Landroidx/compose/material3/SliderColors;", "getDefaultSliderColorsCached$material3_release", "()Landroidx/compose/material3/SliderColors;", "setDefaultSliderColorsCached$material3_release", "(Landroidx/compose/material3/SliderColors;)V", "Landroidx/compose/material3/SwitchColors;", "defaultSwitchColorsCached", "Landroidx/compose/material3/SwitchColors;", "getDefaultSwitchColorsCached$material3_release", "()Landroidx/compose/material3/SwitchColors;", "setDefaultSwitchColorsCached$material3_release", "(Landroidx/compose/material3/SwitchColors;)V", "Landroidx/compose/material3/TextFieldColors;", "defaultOutlinedTextFieldColorsCached", "Landroidx/compose/material3/TextFieldColors;", "getDefaultOutlinedTextFieldColorsCached$material3_release", "()Landroidx/compose/material3/TextFieldColors;", "setDefaultOutlinedTextFieldColorsCached$material3_release", "(Landroidx/compose/material3/TextFieldColors;)V", "defaultTextFieldColorsCached", "getDefaultTextFieldColorsCached$material3_release", "setDefaultTextFieldColorsCached$material3_release", "Landroidx/compose/material3/TimePickerColors;", "defaultTimePickerColorsCached", "Landroidx/compose/material3/TimePickerColors;", "getDefaultTimePickerColorsCached$material3_release", "()Landroidx/compose/material3/TimePickerColors;", "setDefaultTimePickerColorsCached$material3_release", "(Landroidx/compose/material3/TimePickerColors;)V", "getDefaultTimePickerColorsCached$material3_release$annotations", "Landroidx/compose/material3/RichTooltipColors;", "defaultRichTooltipColorsCached", "Landroidx/compose/material3/RichTooltipColors;", "getDefaultRichTooltipColorsCached$material3_release", "()Landroidx/compose/material3/RichTooltipColors;", "setDefaultRichTooltipColorsCached$material3_release", "(Landroidx/compose/material3/RichTooltipColors;)V", "getDefaultRichTooltipColorsCached$material3_release$annotations", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorScheme {
    public static final int $stable = 0;
    private final long background;
    private ChipColors defaultAssistChipColorsCached;
    private ButtonColors defaultButtonColorsCached;
    private CardColors defaultCardColorsCached;
    private TopAppBarColors defaultCenterAlignedTopAppBarColorsCached;
    private CheckboxColors defaultCheckboxColorsCached;
    private DatePickerColors defaultDatePickerColorsCached;
    private ChipColors defaultElevatedAssistChipColorsCached;
    private ButtonColors defaultElevatedButtonColorsCached;
    private CardColors defaultElevatedCardColorsCached;
    private SelectableChipColors defaultElevatedFilterChipColorsCached;
    private ChipColors defaultElevatedSuggestionChipColorsCached;
    private NavigationItemColors defaultExpressiveNavigationBarItemColorsCached;
    private IconButtonColors defaultFilledIconButtonColorsCached;
    private IconToggleButtonColors defaultFilledIconToggleButtonColorsCached;
    private ButtonColors defaultFilledTonalButtonColorsCached;
    private IconButtonColors defaultFilledTonalIconButtonColorsCached;
    private IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached;
    private SelectableChipColors defaultFilterChipColorsCached;
    private IconButtonColors defaultIconButtonColorsCached;
    private IconToggleButtonColors defaultIconToggleButtonColorsCached;
    private SelectableChipColors defaultInputChipColorsCached;
    private TopAppBarColors defaultLargeTopAppBarColorsCached;
    private TopAppBarColors defaultMediumTopAppBarColorsCached;
    private MenuItemColors defaultMenuItemColorsCached;
    private NavigationBarItemColors defaultNavigationBarItemColorsCached;
    private NavigationRailItemColors defaultNavigationRailItemColorsCached;
    private ButtonColors defaultOutlinedButtonColorsCached;
    private CardColors defaultOutlinedCardColorsCached;
    private IconButtonColors defaultOutlinedIconButtonColorsCached;
    private IconToggleButtonColors defaultOutlinedIconToggleButtonColorsCached;
    private TextFieldColors defaultOutlinedTextFieldColorsCached;
    private RadioButtonColors defaultRadioButtonColorsCached;
    private RichTooltipColors defaultRichTooltipColorsCached;
    private SegmentedButtonColors defaultSegmentedButtonColorsCached;
    private SliderColors defaultSliderColorsCached;
    private ChipColors defaultSuggestionChipColorsCached;
    private SwitchColors defaultSwitchColorsCached;
    private ButtonColors defaultTextButtonColorsCached;
    private TextFieldColors defaultTextFieldColorsCached;
    private TimePickerColors defaultTimePickerColorsCached;
    private TopAppBarColors defaultTopAppBarColorsCached;
    private final long error;
    private final long errorContainer;
    private final long inverseOnSurface;
    private final long inversePrimary;
    private final long inverseSurface;
    private final long onBackground;
    private final long onError;
    private final long onErrorContainer;
    private final long onPrimary;
    private final long onPrimaryContainer;
    private final long onSecondary;
    private final long onSecondaryContainer;
    private final long onSurface;
    private final long onSurfaceVariant;
    private final long onTertiary;
    private final long onTertiaryContainer;
    private final long outline;
    private final long outlineVariant;
    private final long primary;
    private final long primaryContainer;
    private final long scrim;
    private final long secondary;
    private final long secondaryContainer;
    private final long surface;
    private final long surfaceBright;
    private final long surfaceContainer;
    private final long surfaceContainerHigh;
    private final long surfaceContainerHighest;
    private final long surfaceContainerLow;
    private final long surfaceContainerLowest;
    private final long surfaceDim;
    private final long surfaceTint;
    private final long surfaceVariant;
    private final long tertiary;
    private final long tertiaryContainer;

    public /* synthetic */ ColorScheme(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, e eVar) {
        this(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42, j43);
    }

    /* renamed from: copy-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1633copyCXl9yA$default(ColorScheme colorScheme, long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, int i, int i6, Object obj) {
        long j44;
        long j45;
        long j46;
        long j47;
        long j48;
        long j49;
        long j50;
        long j51;
        long j52;
        long j53;
        long j54;
        long j55;
        long j56;
        long j57;
        long j58;
        long j59;
        long j60;
        long j61;
        long j62;
        long j63;
        long j64;
        long j65;
        long j66;
        long j67;
        long j68;
        long j69;
        long j70;
        long j71;
        long j72;
        long j73;
        ColorScheme colorScheme2;
        long j74;
        long j75;
        long j76;
        long j77;
        long j78;
        long j79 = (i & 1) != 0 ? colorScheme.primary : j5;
        long j80 = (i & 2) != 0 ? colorScheme.onPrimary : j6;
        long j81 = (i & 4) != 0 ? colorScheme.primaryContainer : j10;
        long j82 = (i & 8) != 0 ? colorScheme.onPrimaryContainer : j11;
        long j83 = (i & 16) != 0 ? colorScheme.inversePrimary : j12;
        long j84 = (i & 32) != 0 ? colorScheme.secondary : j13;
        long j85 = (i & 64) != 0 ? colorScheme.onSecondary : j14;
        long j86 = j79;
        long j87 = (i & 128) != 0 ? colorScheme.secondaryContainer : j15;
        long j88 = (i & 256) != 0 ? colorScheme.onSecondaryContainer : j16;
        long j89 = (i & 512) != 0 ? colorScheme.tertiary : j17;
        long j90 = (i & 1024) != 0 ? colorScheme.onTertiary : j18;
        long j91 = (i & 2048) != 0 ? colorScheme.tertiaryContainer : j19;
        long j92 = (i & 4096) != 0 ? colorScheme.onTertiaryContainer : j20;
        long j93 = (i & 8192) != 0 ? colorScheme.background : j21;
        long j94 = (i & 16384) != 0 ? colorScheme.onBackground : j22;
        long j95 = (i & 32768) != 0 ? colorScheme.surface : j23;
        long j96 = (i & 65536) != 0 ? colorScheme.onSurface : j24;
        long j97 = (i & 131072) != 0 ? colorScheme.surfaceVariant : j25;
        long j98 = (i & 262144) != 0 ? colorScheme.onSurfaceVariant : j26;
        long j99 = (i & 524288) != 0 ? colorScheme.surfaceTint : j27;
        long j100 = (i & 1048576) != 0 ? colorScheme.inverseSurface : j28;
        long j101 = (i & 2097152) != 0 ? colorScheme.inverseOnSurface : j29;
        long j102 = (i & 4194304) != 0 ? colorScheme.error : j30;
        long j103 = (i & 8388608) != 0 ? colorScheme.onError : j31;
        long j104 = (i & 16777216) != 0 ? colorScheme.errorContainer : j32;
        long j105 = (i & 33554432) != 0 ? colorScheme.onErrorContainer : j33;
        long j106 = (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? colorScheme.outline : j34;
        long j107 = (i & 134217728) != 0 ? colorScheme.outlineVariant : j35;
        long j108 = (i & 268435456) != 0 ? colorScheme.scrim : j36;
        long j109 = (i & 536870912) != 0 ? colorScheme.surfaceBright : j37;
        long j110 = (i & BasicMeasure.EXACTLY) != 0 ? colorScheme.surfaceDim : j38;
        long j111 = (i & Integer.MIN_VALUE) != 0 ? colorScheme.surfaceContainer : j39;
        long j112 = (i6 & 1) != 0 ? colorScheme.surfaceContainerHigh : j40;
        long j113 = (i6 & 2) != 0 ? colorScheme.surfaceContainerHighest : j41;
        long j114 = (i6 & 4) != 0 ? colorScheme.surfaceContainerLow : j42;
        if ((i6 & 8) != 0) {
            j45 = j114;
            j44 = colorScheme.surfaceContainerLowest;
            j47 = j108;
            j48 = j109;
            j49 = j110;
            j50 = j111;
            j51 = j112;
            j52 = j113;
            j54 = j101;
            j55 = j102;
            j56 = j103;
            j57 = j104;
            j58 = j105;
            j59 = j106;
            j46 = j107;
            j61 = j94;
            j62 = j95;
            j63 = j96;
            j64 = j97;
            j65 = j98;
            j66 = j99;
            j53 = j100;
            j68 = j87;
            j69 = j88;
            j70 = j89;
            j71 = j90;
            j72 = j91;
            j73 = j92;
            j60 = j93;
            colorScheme2 = colorScheme;
            j74 = j80;
            j75 = j81;
            j76 = j82;
            j77 = j83;
            j78 = j84;
            j67 = j85;
        } else {
            j44 = j43;
            j45 = j114;
            j46 = j107;
            j47 = j108;
            j48 = j109;
            j49 = j110;
            j50 = j111;
            j51 = j112;
            j52 = j113;
            j53 = j100;
            j54 = j101;
            j55 = j102;
            j56 = j103;
            j57 = j104;
            j58 = j105;
            j59 = j106;
            j60 = j93;
            j61 = j94;
            j62 = j95;
            j63 = j96;
            j64 = j97;
            j65 = j98;
            j66 = j99;
            j67 = j85;
            j68 = j87;
            j69 = j88;
            j70 = j89;
            j71 = j90;
            j72 = j91;
            j73 = j92;
            colorScheme2 = colorScheme;
            j74 = j80;
            j75 = j81;
            j76 = j82;
            j77 = j83;
            j78 = j84;
        }
        return colorScheme2.m1635copyCXl9yA(j86, j74, j75, j76, j77, j78, j67, j68, j69, j70, j71, j72, j73, j60, j61, j62, j63, j64, j65, j66, j53, j54, j55, j56, j57, j58, j59, j46, j47, j48, j49, j50, j51, j52, j45, j44);
    }

    /* renamed from: copy-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1634copyG1PFcw$default(ColorScheme colorScheme, long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, Object obj) {
        long j37;
        long j38;
        long j39;
        long j40;
        long j41;
        long j42;
        long j43;
        long j44;
        long j45;
        long j46;
        long j47;
        long j48;
        long j49;
        long j50;
        long j51;
        long j52;
        long j53;
        long j54;
        long j55;
        long j56;
        long j57;
        long j58;
        long j59;
        ColorScheme colorScheme2;
        long j60;
        long j61;
        long j62;
        long j63;
        long j64;
        long j65 = (i & 1) != 0 ? colorScheme.primary : j5;
        long j66 = (i & 2) != 0 ? colorScheme.onPrimary : j6;
        long j67 = (i & 4) != 0 ? colorScheme.primaryContainer : j10;
        long j68 = (i & 8) != 0 ? colorScheme.onPrimaryContainer : j11;
        long j69 = (i & 16) != 0 ? colorScheme.inversePrimary : j12;
        long j70 = (i & 32) != 0 ? colorScheme.secondary : j13;
        long j71 = (i & 64) != 0 ? colorScheme.onSecondary : j14;
        long j72 = j65;
        long j73 = (i & 128) != 0 ? colorScheme.secondaryContainer : j15;
        long j74 = (i & 256) != 0 ? colorScheme.onSecondaryContainer : j16;
        long j75 = (i & 512) != 0 ? colorScheme.tertiary : j17;
        long j76 = (i & 1024) != 0 ? colorScheme.onTertiary : j18;
        long j77 = (i & 2048) != 0 ? colorScheme.tertiaryContainer : j19;
        long j78 = (i & 4096) != 0 ? colorScheme.onTertiaryContainer : j20;
        long j79 = (i & 8192) != 0 ? colorScheme.background : j21;
        long j80 = (i & 16384) != 0 ? colorScheme.onBackground : j22;
        long j81 = (i & 32768) != 0 ? colorScheme.surface : j23;
        long j82 = (i & 65536) != 0 ? colorScheme.onSurface : j24;
        long j83 = (i & 131072) != 0 ? colorScheme.surfaceVariant : j25;
        long j84 = (i & 262144) != 0 ? colorScheme.onSurfaceVariant : j26;
        long j85 = (i & 524288) != 0 ? colorScheme.surfaceTint : j27;
        long j86 = (i & 1048576) != 0 ? colorScheme.inverseSurface : j28;
        long j87 = (i & 2097152) != 0 ? colorScheme.inverseOnSurface : j29;
        long j88 = (i & 4194304) != 0 ? colorScheme.error : j30;
        long j89 = (i & 8388608) != 0 ? colorScheme.onError : j31;
        long j90 = (i & 16777216) != 0 ? colorScheme.errorContainer : j32;
        long j91 = (i & 33554432) != 0 ? colorScheme.onErrorContainer : j33;
        long j92 = (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? colorScheme.outline : j34;
        long j93 = (i & 134217728) != 0 ? colorScheme.outlineVariant : j35;
        if ((i & 268435456) != 0) {
            j38 = j93;
            j37 = colorScheme.scrim;
            j40 = j87;
            j41 = j88;
            j42 = j89;
            j43 = j90;
            j44 = j91;
            j45 = j92;
            j47 = j80;
            j48 = j81;
            j49 = j82;
            j50 = j83;
            j51 = j84;
            j52 = j85;
            j39 = j86;
            j54 = j73;
            j55 = j74;
            j56 = j75;
            j57 = j76;
            j58 = j77;
            j59 = j78;
            j46 = j79;
            colorScheme2 = colorScheme;
            j60 = j66;
            j61 = j67;
            j62 = j68;
            j63 = j69;
            j64 = j70;
            j53 = j71;
        } else {
            j37 = j36;
            j38 = j93;
            j39 = j86;
            j40 = j87;
            j41 = j88;
            j42 = j89;
            j43 = j90;
            j44 = j91;
            j45 = j92;
            j46 = j79;
            j47 = j80;
            j48 = j81;
            j49 = j82;
            j50 = j83;
            j51 = j84;
            j52 = j85;
            j53 = j71;
            j54 = j73;
            j55 = j74;
            j56 = j75;
            j57 = j76;
            j58 = j77;
            j59 = j78;
            colorScheme2 = colorScheme;
            j60 = j66;
            j61 = j67;
            j62 = j68;
            j63 = j69;
            j64 = j70;
        }
        return colorScheme2.m1636copyG1PFcw(j72, j60, j61, j62, j63, j64, j53, j54, j55, j56, j57, j58, j59, j46, j47, j48, j49, j50, j51, j52, j39, j40, j41, j42, j43, j44, j45, j38, j37);
    }

    public static /* synthetic */ void getDefaultCenterAlignedTopAppBarColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultDatePickerColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultLargeTopAppBarColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultMediumTopAppBarColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultRichTooltipColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultSegmentedButtonColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultTimePickerColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultTopAppBarColorsCached$material3_release$annotations() {
    }

    /* renamed from: copy-C-Xl9yA, reason: not valid java name */
    public final ColorScheme m1635copyCXl9yA(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim, long surfaceBright, long surfaceDim, long surfaceContainer, long surfaceContainerHigh, long surfaceContainerHighest, long surfaceContainerLow, long surfaceContainerLowest) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, surfaceBright, surfaceDim, surfaceContainer, surfaceContainerHigh, surfaceContainerHighest, surfaceContainerLow, surfaceContainerLowest, null);
    }

    @C7.c
    /* renamed from: copy-G1PFc-w, reason: not valid java name */
    public final /* synthetic */ ColorScheme m1636copyG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return m1633copyCXl9yA$default(this, primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 15, null);
    }

    /* renamed from: getBackground-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackground() {
        return this.background;
    }

    /* renamed from: getDefaultAssistChipColorsCached$material3_release, reason: from getter */
    public final ChipColors getDefaultAssistChipColorsCached() {
        return this.defaultAssistChipColorsCached;
    }

    /* renamed from: getDefaultButtonColorsCached$material3_release, reason: from getter */
    public final ButtonColors getDefaultButtonColorsCached() {
        return this.defaultButtonColorsCached;
    }

    /* renamed from: getDefaultCardColorsCached$material3_release, reason: from getter */
    public final CardColors getDefaultCardColorsCached() {
        return this.defaultCardColorsCached;
    }

    /* renamed from: getDefaultCenterAlignedTopAppBarColorsCached$material3_release, reason: from getter */
    public final TopAppBarColors getDefaultCenterAlignedTopAppBarColorsCached() {
        return this.defaultCenterAlignedTopAppBarColorsCached;
    }

    /* renamed from: getDefaultCheckboxColorsCached$material3_release, reason: from getter */
    public final CheckboxColors getDefaultCheckboxColorsCached() {
        return this.defaultCheckboxColorsCached;
    }

    /* renamed from: getDefaultDatePickerColorsCached$material3_release, reason: from getter */
    public final DatePickerColors getDefaultDatePickerColorsCached() {
        return this.defaultDatePickerColorsCached;
    }

    /* renamed from: getDefaultElevatedAssistChipColorsCached$material3_release, reason: from getter */
    public final ChipColors getDefaultElevatedAssistChipColorsCached() {
        return this.defaultElevatedAssistChipColorsCached;
    }

    /* renamed from: getDefaultElevatedButtonColorsCached$material3_release, reason: from getter */
    public final ButtonColors getDefaultElevatedButtonColorsCached() {
        return this.defaultElevatedButtonColorsCached;
    }

    /* renamed from: getDefaultElevatedCardColorsCached$material3_release, reason: from getter */
    public final CardColors getDefaultElevatedCardColorsCached() {
        return this.defaultElevatedCardColorsCached;
    }

    /* renamed from: getDefaultElevatedFilterChipColorsCached$material3_release, reason: from getter */
    public final SelectableChipColors getDefaultElevatedFilterChipColorsCached() {
        return this.defaultElevatedFilterChipColorsCached;
    }

    /* renamed from: getDefaultElevatedSuggestionChipColorsCached$material3_release, reason: from getter */
    public final ChipColors getDefaultElevatedSuggestionChipColorsCached() {
        return this.defaultElevatedSuggestionChipColorsCached;
    }

    /* renamed from: getDefaultExpressiveNavigationBarItemColorsCached$material3_release, reason: from getter */
    public final NavigationItemColors getDefaultExpressiveNavigationBarItemColorsCached() {
        return this.defaultExpressiveNavigationBarItemColorsCached;
    }

    /* renamed from: getDefaultFilledIconButtonColorsCached$material3_release, reason: from getter */
    public final IconButtonColors getDefaultFilledIconButtonColorsCached() {
        return this.defaultFilledIconButtonColorsCached;
    }

    /* renamed from: getDefaultFilledIconToggleButtonColorsCached$material3_release, reason: from getter */
    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColorsCached() {
        return this.defaultFilledIconToggleButtonColorsCached;
    }

    /* renamed from: getDefaultFilledTonalButtonColorsCached$material3_release, reason: from getter */
    public final ButtonColors getDefaultFilledTonalButtonColorsCached() {
        return this.defaultFilledTonalButtonColorsCached;
    }

    /* renamed from: getDefaultFilledTonalIconButtonColorsCached$material3_release, reason: from getter */
    public final IconButtonColors getDefaultFilledTonalIconButtonColorsCached() {
        return this.defaultFilledTonalIconButtonColorsCached;
    }

    /* renamed from: getDefaultFilledTonalIconToggleButtonColorsCached$material3_release, reason: from getter */
    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColorsCached() {
        return this.defaultFilledTonalIconToggleButtonColorsCached;
    }

    /* renamed from: getDefaultFilterChipColorsCached$material3_release, reason: from getter */
    public final SelectableChipColors getDefaultFilterChipColorsCached() {
        return this.defaultFilterChipColorsCached;
    }

    /* renamed from: getDefaultIconButtonColorsCached$material3_release, reason: from getter */
    public final IconButtonColors getDefaultIconButtonColorsCached() {
        return this.defaultIconButtonColorsCached;
    }

    /* renamed from: getDefaultIconToggleButtonColorsCached$material3_release, reason: from getter */
    public final IconToggleButtonColors getDefaultIconToggleButtonColorsCached() {
        return this.defaultIconToggleButtonColorsCached;
    }

    /* renamed from: getDefaultInputChipColorsCached$material3_release, reason: from getter */
    public final SelectableChipColors getDefaultInputChipColorsCached() {
        return this.defaultInputChipColorsCached;
    }

    /* renamed from: getDefaultLargeTopAppBarColorsCached$material3_release, reason: from getter */
    public final TopAppBarColors getDefaultLargeTopAppBarColorsCached() {
        return this.defaultLargeTopAppBarColorsCached;
    }

    /* renamed from: getDefaultMediumTopAppBarColorsCached$material3_release, reason: from getter */
    public final TopAppBarColors getDefaultMediumTopAppBarColorsCached() {
        return this.defaultMediumTopAppBarColorsCached;
    }

    /* renamed from: getDefaultMenuItemColorsCached$material3_release, reason: from getter */
    public final MenuItemColors getDefaultMenuItemColorsCached() {
        return this.defaultMenuItemColorsCached;
    }

    /* renamed from: getDefaultNavigationBarItemColorsCached$material3_release, reason: from getter */
    public final NavigationBarItemColors getDefaultNavigationBarItemColorsCached() {
        return this.defaultNavigationBarItemColorsCached;
    }

    /* renamed from: getDefaultNavigationRailItemColorsCached$material3_release, reason: from getter */
    public final NavigationRailItemColors getDefaultNavigationRailItemColorsCached() {
        return this.defaultNavigationRailItemColorsCached;
    }

    /* renamed from: getDefaultOutlinedButtonColorsCached$material3_release, reason: from getter */
    public final ButtonColors getDefaultOutlinedButtonColorsCached() {
        return this.defaultOutlinedButtonColorsCached;
    }

    /* renamed from: getDefaultOutlinedCardColorsCached$material3_release, reason: from getter */
    public final CardColors getDefaultOutlinedCardColorsCached() {
        return this.defaultOutlinedCardColorsCached;
    }

    /* renamed from: getDefaultOutlinedIconButtonColorsCached$material3_release, reason: from getter */
    public final IconButtonColors getDefaultOutlinedIconButtonColorsCached() {
        return this.defaultOutlinedIconButtonColorsCached;
    }

    /* renamed from: getDefaultOutlinedIconToggleButtonColorsCached$material3_release, reason: from getter */
    public final IconToggleButtonColors getDefaultOutlinedIconToggleButtonColorsCached() {
        return this.defaultOutlinedIconToggleButtonColorsCached;
    }

    /* renamed from: getDefaultOutlinedTextFieldColorsCached$material3_release, reason: from getter */
    public final TextFieldColors getDefaultOutlinedTextFieldColorsCached() {
        return this.defaultOutlinedTextFieldColorsCached;
    }

    /* renamed from: getDefaultRadioButtonColorsCached$material3_release, reason: from getter */
    public final RadioButtonColors getDefaultRadioButtonColorsCached() {
        return this.defaultRadioButtonColorsCached;
    }

    /* renamed from: getDefaultRichTooltipColorsCached$material3_release, reason: from getter */
    public final RichTooltipColors getDefaultRichTooltipColorsCached() {
        return this.defaultRichTooltipColorsCached;
    }

    /* renamed from: getDefaultSegmentedButtonColorsCached$material3_release, reason: from getter */
    public final SegmentedButtonColors getDefaultSegmentedButtonColorsCached() {
        return this.defaultSegmentedButtonColorsCached;
    }

    /* renamed from: getDefaultSliderColorsCached$material3_release, reason: from getter */
    public final SliderColors getDefaultSliderColorsCached() {
        return this.defaultSliderColorsCached;
    }

    /* renamed from: getDefaultSuggestionChipColorsCached$material3_release, reason: from getter */
    public final ChipColors getDefaultSuggestionChipColorsCached() {
        return this.defaultSuggestionChipColorsCached;
    }

    /* renamed from: getDefaultSwitchColorsCached$material3_release, reason: from getter */
    public final SwitchColors getDefaultSwitchColorsCached() {
        return this.defaultSwitchColorsCached;
    }

    /* renamed from: getDefaultTextButtonColorsCached$material3_release, reason: from getter */
    public final ButtonColors getDefaultTextButtonColorsCached() {
        return this.defaultTextButtonColorsCached;
    }

    /* renamed from: getDefaultTextFieldColorsCached$material3_release, reason: from getter */
    public final TextFieldColors getDefaultTextFieldColorsCached() {
        return this.defaultTextFieldColorsCached;
    }

    /* renamed from: getDefaultTimePickerColorsCached$material3_release, reason: from getter */
    public final TimePickerColors getDefaultTimePickerColorsCached() {
        return this.defaultTimePickerColorsCached;
    }

    /* renamed from: getDefaultTopAppBarColorsCached$material3_release, reason: from getter */
    public final TopAppBarColors getDefaultTopAppBarColorsCached() {
        return this.defaultTopAppBarColorsCached;
    }

    /* renamed from: getError-0d7_KjU, reason: not valid java name and from getter */
    public final long getError() {
        return this.error;
    }

    /* renamed from: getErrorContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getErrorContainer() {
        return this.errorContainer;
    }

    /* renamed from: getInverseOnSurface-0d7_KjU, reason: not valid java name and from getter */
    public final long getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    /* renamed from: getInversePrimary-0d7_KjU, reason: not valid java name and from getter */
    public final long getInversePrimary() {
        return this.inversePrimary;
    }

    /* renamed from: getInverseSurface-0d7_KjU, reason: not valid java name and from getter */
    public final long getInverseSurface() {
        return this.inverseSurface;
    }

    /* renamed from: getOnBackground-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnBackground() {
        return this.onBackground;
    }

    /* renamed from: getOnError-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnError() {
        return this.onError;
    }

    /* renamed from: getOnErrorContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnErrorContainer() {
        return this.onErrorContainer;
    }

    /* renamed from: getOnPrimary-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnPrimary() {
        return this.onPrimary;
    }

    /* renamed from: getOnPrimaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    /* renamed from: getOnSecondary-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSecondary() {
        return this.onSecondary;
    }

    /* renamed from: getOnSecondaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    /* renamed from: getOnSurface-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSurface() {
        return this.onSurface;
    }

    /* renamed from: getOnSurfaceVariant-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    /* renamed from: getOnTertiary-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnTertiary() {
        return this.onTertiary;
    }

    /* renamed from: getOnTertiaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    /* renamed from: getOutline-0d7_KjU, reason: not valid java name and from getter */
    public final long getOutline() {
        return this.outline;
    }

    /* renamed from: getOutlineVariant-0d7_KjU, reason: not valid java name and from getter */
    public final long getOutlineVariant() {
        return this.outlineVariant;
    }

    /* renamed from: getPrimary-0d7_KjU, reason: not valid java name and from getter */
    public final long getPrimary() {
        return this.primary;
    }

    /* renamed from: getPrimaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getPrimaryContainer() {
        return this.primaryContainer;
    }

    /* renamed from: getScrim-0d7_KjU, reason: not valid java name and from getter */
    public final long getScrim() {
        return this.scrim;
    }

    /* renamed from: getSecondary-0d7_KjU, reason: not valid java name and from getter */
    public final long getSecondary() {
        return this.secondary;
    }

    /* renamed from: getSecondaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getSecondaryContainer() {
        return this.secondaryContainer;
    }

    /* renamed from: getSurface-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurface() {
        return this.surface;
    }

    /* renamed from: getSurfaceBright-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceBright() {
        return this.surfaceBright;
    }

    /* renamed from: getSurfaceContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceContainer() {
        return this.surfaceContainer;
    }

    /* renamed from: getSurfaceContainerHigh-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceContainerHigh() {
        return this.surfaceContainerHigh;
    }

    /* renamed from: getSurfaceContainerHighest-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceContainerHighest() {
        return this.surfaceContainerHighest;
    }

    /* renamed from: getSurfaceContainerLow-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceContainerLow() {
        return this.surfaceContainerLow;
    }

    /* renamed from: getSurfaceContainerLowest-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceContainerLowest() {
        return this.surfaceContainerLowest;
    }

    /* renamed from: getSurfaceDim-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceDim() {
        return this.surfaceDim;
    }

    /* renamed from: getSurfaceTint-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceTint() {
        return this.surfaceTint;
    }

    /* renamed from: getSurfaceVariant-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceVariant() {
        return this.surfaceVariant;
    }

    /* renamed from: getTertiary-0d7_KjU, reason: not valid java name and from getter */
    public final long getTertiary() {
        return this.tertiary;
    }

    /* renamed from: getTertiaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    public final void setDefaultAssistChipColorsCached$material3_release(ChipColors chipColors) {
        this.defaultAssistChipColorsCached = chipColors;
    }

    public final void setDefaultButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultButtonColorsCached = buttonColors;
    }

    public final void setDefaultCardColorsCached$material3_release(CardColors cardColors) {
        this.defaultCardColorsCached = cardColors;
    }

    public final void setDefaultCenterAlignedTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultCenterAlignedTopAppBarColorsCached = topAppBarColors;
    }

    public final void setDefaultCheckboxColorsCached$material3_release(CheckboxColors checkboxColors) {
        this.defaultCheckboxColorsCached = checkboxColors;
    }

    public final void setDefaultDatePickerColorsCached$material3_release(DatePickerColors datePickerColors) {
        this.defaultDatePickerColorsCached = datePickerColors;
    }

    public final void setDefaultElevatedAssistChipColorsCached$material3_release(ChipColors chipColors) {
        this.defaultElevatedAssistChipColorsCached = chipColors;
    }

    public final void setDefaultElevatedButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultElevatedButtonColorsCached = buttonColors;
    }

    public final void setDefaultElevatedCardColorsCached$material3_release(CardColors cardColors) {
        this.defaultElevatedCardColorsCached = cardColors;
    }

    public final void setDefaultElevatedFilterChipColorsCached$material3_release(SelectableChipColors selectableChipColors) {
        this.defaultElevatedFilterChipColorsCached = selectableChipColors;
    }

    public final void setDefaultElevatedSuggestionChipColorsCached$material3_release(ChipColors chipColors) {
        this.defaultElevatedSuggestionChipColorsCached = chipColors;
    }

    public final void setDefaultExpressiveNavigationBarItemColorsCached$material3_release(NavigationItemColors navigationItemColors) {
        this.defaultExpressiveNavigationBarItemColorsCached = navigationItemColors;
    }

    public final void setDefaultFilledIconButtonColorsCached$material3_release(IconButtonColors iconButtonColors) {
        this.defaultFilledIconButtonColorsCached = iconButtonColors;
    }

    public final void setDefaultFilledIconToggleButtonColorsCached$material3_release(IconToggleButtonColors iconToggleButtonColors) {
        this.defaultFilledIconToggleButtonColorsCached = iconToggleButtonColors;
    }

    public final void setDefaultFilledTonalButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultFilledTonalButtonColorsCached = buttonColors;
    }

    public final void setDefaultFilledTonalIconButtonColorsCached$material3_release(IconButtonColors iconButtonColors) {
        this.defaultFilledTonalIconButtonColorsCached = iconButtonColors;
    }

    public final void setDefaultFilledTonalIconToggleButtonColorsCached$material3_release(IconToggleButtonColors iconToggleButtonColors) {
        this.defaultFilledTonalIconToggleButtonColorsCached = iconToggleButtonColors;
    }

    public final void setDefaultFilterChipColorsCached$material3_release(SelectableChipColors selectableChipColors) {
        this.defaultFilterChipColorsCached = selectableChipColors;
    }

    public final void setDefaultIconButtonColorsCached$material3_release(IconButtonColors iconButtonColors) {
        this.defaultIconButtonColorsCached = iconButtonColors;
    }

    public final void setDefaultIconToggleButtonColorsCached$material3_release(IconToggleButtonColors iconToggleButtonColors) {
        this.defaultIconToggleButtonColorsCached = iconToggleButtonColors;
    }

    public final void setDefaultInputChipColorsCached$material3_release(SelectableChipColors selectableChipColors) {
        this.defaultInputChipColorsCached = selectableChipColors;
    }

    public final void setDefaultLargeTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultLargeTopAppBarColorsCached = topAppBarColors;
    }

    public final void setDefaultMediumTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultMediumTopAppBarColorsCached = topAppBarColors;
    }

    public final void setDefaultMenuItemColorsCached$material3_release(MenuItemColors menuItemColors) {
        this.defaultMenuItemColorsCached = menuItemColors;
    }

    public final void setDefaultNavigationBarItemColorsCached$material3_release(NavigationBarItemColors navigationBarItemColors) {
        this.defaultNavigationBarItemColorsCached = navigationBarItemColors;
    }

    public final void setDefaultNavigationRailItemColorsCached$material3_release(NavigationRailItemColors navigationRailItemColors) {
        this.defaultNavigationRailItemColorsCached = navigationRailItemColors;
    }

    public final void setDefaultOutlinedButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultOutlinedButtonColorsCached = buttonColors;
    }

    public final void setDefaultOutlinedCardColorsCached$material3_release(CardColors cardColors) {
        this.defaultOutlinedCardColorsCached = cardColors;
    }

    public final void setDefaultOutlinedIconButtonColorsCached$material3_release(IconButtonColors iconButtonColors) {
        this.defaultOutlinedIconButtonColorsCached = iconButtonColors;
    }

    public final void setDefaultOutlinedIconToggleButtonColorsCached$material3_release(IconToggleButtonColors iconToggleButtonColors) {
        this.defaultOutlinedIconToggleButtonColorsCached = iconToggleButtonColors;
    }

    public final void setDefaultOutlinedTextFieldColorsCached$material3_release(TextFieldColors textFieldColors) {
        this.defaultOutlinedTextFieldColorsCached = textFieldColors;
    }

    public final void setDefaultRadioButtonColorsCached$material3_release(RadioButtonColors radioButtonColors) {
        this.defaultRadioButtonColorsCached = radioButtonColors;
    }

    public final void setDefaultRichTooltipColorsCached$material3_release(RichTooltipColors richTooltipColors) {
        this.defaultRichTooltipColorsCached = richTooltipColors;
    }

    public final void setDefaultSegmentedButtonColorsCached$material3_release(SegmentedButtonColors segmentedButtonColors) {
        this.defaultSegmentedButtonColorsCached = segmentedButtonColors;
    }

    public final void setDefaultSliderColorsCached$material3_release(SliderColors sliderColors) {
        this.defaultSliderColorsCached = sliderColors;
    }

    public final void setDefaultSuggestionChipColorsCached$material3_release(ChipColors chipColors) {
        this.defaultSuggestionChipColorsCached = chipColors;
    }

    public final void setDefaultSwitchColorsCached$material3_release(SwitchColors switchColors) {
        this.defaultSwitchColorsCached = switchColors;
    }

    public final void setDefaultTextButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultTextButtonColorsCached = buttonColors;
    }

    public final void setDefaultTextFieldColorsCached$material3_release(TextFieldColors textFieldColors) {
        this.defaultTextFieldColorsCached = textFieldColors;
    }

    public final void setDefaultTimePickerColorsCached$material3_release(TimePickerColors timePickerColors) {
        this.defaultTimePickerColorsCached = timePickerColors;
    }

    public final void setDefaultTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultTopAppBarColorsCached = topAppBarColors;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColorScheme(primary=");
        androidx.compose.foundation.b.z(this.primary, "onPrimary=", sb);
        androidx.compose.foundation.b.z(this.onPrimary, "primaryContainer=", sb);
        androidx.compose.foundation.b.z(this.primaryContainer, "onPrimaryContainer=", sb);
        androidx.compose.foundation.b.z(this.onPrimaryContainer, "inversePrimary=", sb);
        androidx.compose.foundation.b.z(this.inversePrimary, "secondary=", sb);
        androidx.compose.foundation.b.z(this.secondary, "onSecondary=", sb);
        androidx.compose.foundation.b.z(this.onSecondary, "secondaryContainer=", sb);
        androidx.compose.foundation.b.z(this.secondaryContainer, "onSecondaryContainer=", sb);
        androidx.compose.foundation.b.z(this.onSecondaryContainer, "tertiary=", sb);
        androidx.compose.foundation.b.z(this.tertiary, "onTertiary=", sb);
        androidx.compose.foundation.b.z(this.onTertiary, "tertiaryContainer=", sb);
        androidx.compose.foundation.b.z(this.tertiaryContainer, "onTertiaryContainer=", sb);
        androidx.compose.foundation.b.z(this.onTertiaryContainer, "background=", sb);
        androidx.compose.foundation.b.z(this.background, "onBackground=", sb);
        androidx.compose.foundation.b.z(this.onBackground, "surface=", sb);
        androidx.compose.foundation.b.z(this.surface, "onSurface=", sb);
        androidx.compose.foundation.b.z(this.onSurface, "surfaceVariant=", sb);
        androidx.compose.foundation.b.z(this.surfaceVariant, "onSurfaceVariant=", sb);
        androidx.compose.foundation.b.z(this.onSurfaceVariant, "surfaceTint=", sb);
        androidx.compose.foundation.b.z(this.surfaceTint, "inverseSurface=", sb);
        androidx.compose.foundation.b.z(this.inverseSurface, "inverseOnSurface=", sb);
        androidx.compose.foundation.b.z(this.inverseOnSurface, "error=", sb);
        androidx.compose.foundation.b.z(this.error, "onError=", sb);
        androidx.compose.foundation.b.z(this.onError, "errorContainer=", sb);
        androidx.compose.foundation.b.z(this.errorContainer, "onErrorContainer=", sb);
        androidx.compose.foundation.b.z(this.onErrorContainer, "outline=", sb);
        androidx.compose.foundation.b.z(this.outline, "outlineVariant=", sb);
        androidx.compose.foundation.b.z(this.outlineVariant, "scrim=", sb);
        androidx.compose.foundation.b.z(this.scrim, "surfaceBright=", sb);
        androidx.compose.foundation.b.z(this.surfaceBright, "surfaceDim=", sb);
        androidx.compose.foundation.b.z(this.surfaceDim, "surfaceContainer=", sb);
        androidx.compose.foundation.b.z(this.surfaceContainer, "surfaceContainerHigh=", sb);
        androidx.compose.foundation.b.z(this.surfaceContainerHigh, "surfaceContainerHighest=", sb);
        androidx.compose.foundation.b.z(this.surfaceContainerHighest, "surfaceContainerLow=", sb);
        androidx.compose.foundation.b.z(this.surfaceContainerLow, "surfaceContainerLowest=", sb);
        sb.append((Object) Color.m4147toStringimpl(this.surfaceContainerLowest));
        sb.append(')');
        return sb.toString();
    }

    @C7.c
    public /* synthetic */ ColorScheme(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, e eVar) {
        this(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36);
    }

    private ColorScheme(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43) {
        this.primary = j5;
        this.onPrimary = j6;
        this.primaryContainer = j10;
        this.onPrimaryContainer = j11;
        this.inversePrimary = j12;
        this.secondary = j13;
        this.onSecondary = j14;
        this.secondaryContainer = j15;
        this.onSecondaryContainer = j16;
        this.tertiary = j17;
        this.onTertiary = j18;
        this.tertiaryContainer = j19;
        this.onTertiaryContainer = j20;
        this.background = j21;
        this.onBackground = j22;
        this.surface = j23;
        this.onSurface = j24;
        this.surfaceVariant = j25;
        this.onSurfaceVariant = j26;
        this.surfaceTint = j27;
        this.inverseSurface = j28;
        this.inverseOnSurface = j29;
        this.error = j30;
        this.onError = j31;
        this.errorContainer = j32;
        this.onErrorContainer = j33;
        this.outline = j34;
        this.outlineVariant = j35;
        this.scrim = j36;
        this.surfaceBright = j37;
        this.surfaceDim = j38;
        this.surfaceContainer = j39;
        this.surfaceContainerHigh = j40;
        this.surfaceContainerHighest = j41;
        this.surfaceContainerLow = j42;
        this.surfaceContainerLowest = j43;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ColorScheme(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        Color.Companion companion = Color.INSTANCE;
        this(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), null);
    }
}
