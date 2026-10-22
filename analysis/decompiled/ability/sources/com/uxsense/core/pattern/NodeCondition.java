package com.uxsense.core.pattern;

import A9.d;
import B9.C0177d;
import B9.C0180g;
import B9.C0198z;
import B9.F;
import B9.d0;
import B9.h0;
import C7.f;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u0000 \u0096\u00012\u00020\u0001:\u0004\u0097\u0001\u0096\u0001B\u0081\u0003\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'B×\u0002\b\u0010\u0012\u0006\u0010(\u001a\u00020\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\r\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\"\u001a\u0004\u0018\u00010\r\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b&\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010-J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010-J\u0012\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b/\u0010-J\u0018\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b0\u00101J\u0012\u00102\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b2\u0010-J\u0012\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b3\u0010-J\u0012\u00104\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b4\u0010-J\u0012\u00105\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b5\u0010-J\u0012\u00106\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b6\u0010-J\u0012\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b7\u00108J\u0012\u00109\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b9\u0010-J\u0012\u0010:\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b:\u0010-J\u0012\u0010;\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b;\u0010<J\u0012\u0010=\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b=\u0010<J\u0012\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b>\u0010<J\u0012\u0010?\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b?\u0010<J\u0012\u0010@\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b@\u0010AJ\u0012\u0010B\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\bB\u0010AJ\u0012\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\bC\u00108J\u0012\u0010D\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\bD\u00108J\u0012\u0010E\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\bE\u00108J\u0012\u0010F\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\bF\u00108J\u0012\u0010G\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\bG\u00108J\u0012\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\bH\u00108J\u0012\u0010I\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\bI\u00108J\u0012\u0010J\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\bJ\u0010<J\u0012\u0010K\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\bK\u0010<J\u0012\u0010L\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\bL\u00108J\u0012\u0010M\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\bM\u0010<J\u0012\u0010N\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\bN\u0010<J\u0012\u0010O\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bO\u0010-J\u008a\u0003\u0010P\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bR\u0010-J\u0010\u0010S\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\bS\u0010TJ\u001a\u0010V\u001a\u00020\r2\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bV\u0010WJ'\u0010`\u001a\u00020]2\u0006\u0010X\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\\\u001a\u00020[H\u0001¢\u0006\u0004\b^\u0010_R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010a\u001a\u0004\bb\u0010-R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010a\u001a\u0004\bc\u0010-R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010a\u001a\u0004\bd\u0010-R\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010e\u001a\u0004\bf\u00101R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010a\u001a\u0004\bg\u0010-R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010a\u001a\u0004\bh\u0010-R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010a\u001a\u0004\bi\u0010-R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010a\u001a\u0004\bj\u0010-R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010a\u001a\u0004\bk\u0010-R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010l\u001a\u0004\bm\u00108R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010a\u001a\u0004\bn\u0010-R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010a\u001a\u0004\bo\u0010-R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010p\u001a\u0004\bq\u0010<R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010p\u001a\u0004\br\u0010<R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0014\u0010p\u001a\u0004\bs\u0010<R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0015\u0010p\u001a\u0004\bt\u0010<R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010u\u001a\u0004\bv\u0010AR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010u\u001a\u0004\bw\u0010AR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u0019\u0010l\u001a\u0004\bx\u00108R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u001a\u0010l\u001a\u0004\by\u00108R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u001b\u0010l\u001a\u0004\bz\u00108R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u001c\u0010l\u001a\u0004\b{\u00108R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u001d\u0010l\u001a\u0004\b|\u00108R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u001e\u0010l\u001a\u0004\b}\u00108R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u001f\u0010l\u001a\u0004\b~\u00108R\u0019\u0010 \u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b \u0010p\u001a\u0004\b\u007f\u0010<R\u001a\u0010!\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\r\n\u0004\b!\u0010p\u001a\u0005\b\u0080\u0001\u0010<R\u001a\u0010\"\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\r\n\u0004\b\"\u0010l\u001a\u0005\b\u0081\u0001\u00108R\u001a\u0010#\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\r\n\u0004\b#\u0010p\u001a\u0005\b\u0082\u0001\u0010<R\u001a\u0010$\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\r\n\u0004\b$\u0010p\u001a\u0005\b\u0083\u0001\u0010<R\u001a\u0010%\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\r\n\u0004\b%\u0010a\u001a\u0005\b\u0084\u0001\u0010-R4\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0000@\u0000X\u0081\u000e¢\u0006 \n\u0006\b\u0086\u0001\u0010\u0087\u0001\u0012\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R4\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0000@\u0000X\u0081\u000e¢\u0006 \n\u0006\b\u008e\u0001\u0010\u0087\u0001\u0012\u0006\b\u0091\u0001\u0010\u008d\u0001\u001a\u0006\b\u008f\u0001\u0010\u0089\u0001\"\u0006\b\u0090\u0001\u0010\u008b\u0001R4\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0000@\u0000X\u0081\u000e¢\u0006 \n\u0006\b\u0092\u0001\u0010\u0087\u0001\u0012\u0006\b\u0095\u0001\u0010\u008d\u0001\u001a\u0006\b\u0093\u0001\u0010\u0089\u0001\"\u0006\b\u0094\u0001\u0010\u008b\u0001¨\u0006\u0098\u0001"}, d2 = {"Lcom/uxsense/core/pattern/NodeCondition;", "", "", "className", "classNameContains", "classNameRegex", "", "classNameIn", "viewId", "viewIdRegex", "text", "textContains", "textRegex", "", "textNotEmpty", "description", "descriptionContains", "", "minWidth", "maxWidth", "minHeight", "maxHeight", "", "widthHeightRatioMin", "widthHeightRatioMax", "touchable", "clickable", "longClickable", "checkable", "checked", "horizontalScrollable", "verticalScrollable", "minChildCount", "maxChildCount", "hasChildren", "minProgress", "maxProgress", "customPredicate", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;LB9/d0;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/util/List;", "component5", "component6", "component7", "component8", "component9", "component10", "()Ljava/lang/Boolean;", "component11", "component12", "component13", "()Ljava/lang/Integer;", "component14", "component15", "component16", "component17", "()Ljava/lang/Float;", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/uxsense/core/pattern/NodeCondition;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/core/pattern/NodeCondition;LA9/d;Lz9/g;)V", "write$Self", "Ljava/lang/String;", "getClassName", "getClassNameContains", "getClassNameRegex", "Ljava/util/List;", "getClassNameIn", "getViewId", "getViewIdRegex", "getText", "getTextContains", "getTextRegex", "Ljava/lang/Boolean;", "getTextNotEmpty", "getDescription", "getDescriptionContains", "Ljava/lang/Integer;", "getMinWidth", "getMaxWidth", "getMinHeight", "getMaxHeight", "Ljava/lang/Float;", "getWidthHeightRatioMin", "getWidthHeightRatioMax", "getTouchable", "getClickable", "getLongClickable", "getCheckable", "getChecked", "getHorizontalScrollable", "getVerticalScrollable", "getMinChildCount", "getMaxChildCount", "getHasChildren", "getMinProgress", "getMaxProgress", "getCustomPredicate", "Lkotlin/text/Regex;", "classNameRegexCache", "Lkotlin/text/Regex;", "getClassNameRegexCache$uxsense_release", "()Lkotlin/text/Regex;", "setClassNameRegexCache$uxsense_release", "(Lkotlin/text/Regex;)V", "getClassNameRegexCache$uxsense_release$annotations", "()V", "viewIdRegexCache", "getViewIdRegexCache$uxsense_release", "setViewIdRegexCache$uxsense_release", "getViewIdRegexCache$uxsense_release$annotations", "textRegexCache", "getTextRegexCache$uxsense_release", "setTextRegexCache$uxsense_release", "getTextRegexCache$uxsense_release$annotations", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NodeCondition {
    private final Boolean checkable;
    private final Boolean checked;
    private final String className;
    private final String classNameContains;
    private final List<String> classNameIn;
    private final String classNameRegex;
    private Regex classNameRegexCache;
    private final Boolean clickable;
    private final String customPredicate;
    private final String description;
    private final String descriptionContains;
    private final Boolean hasChildren;
    private final Boolean horizontalScrollable;
    private final Boolean longClickable;
    private final Integer maxChildCount;
    private final Integer maxHeight;
    private final Integer maxProgress;
    private final Integer maxWidth;
    private final Integer minChildCount;
    private final Integer minHeight;
    private final Integer minProgress;
    private final Integer minWidth;
    private final String text;
    private final String textContains;
    private final Boolean textNotEmpty;
    private final String textRegex;
    private Regex textRegexCache;
    private final Boolean touchable;
    private final Boolean verticalScrollable;
    private final String viewId;
    private final String viewIdRegex;
    private Regex viewIdRegexCache;
    private final Float widthHeightRatioMax;
    private final Float widthHeightRatioMin;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final f[] $childSerializers = {null, null, null, kotlin.a.b(LazyThreadSafetyMode.b, new a(3)), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/pattern/NodeCondition$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/pattern/NodeCondition;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return NodeCondition$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public NodeCondition() {
        this((String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Float) null, (Float) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, Integer.MAX_VALUE, (e) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return new C0177d(h0.f242a);
    }

    public static /* synthetic */ NodeCondition copy$default(NodeCondition nodeCondition, String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10, Integer num, Integer num2, Integer num3, Integer num4, Float f, Float f7, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Integer num5, Integer num6, Boolean bool9, Integer num7, Integer num8, String str11, int i, Object obj) {
        String str12;
        Integer num9;
        String str13 = (i & 1) != 0 ? nodeCondition.className : str;
        String str14 = (i & 2) != 0 ? nodeCondition.classNameContains : str2;
        String str15 = (i & 4) != 0 ? nodeCondition.classNameRegex : str3;
        List list2 = (i & 8) != 0 ? nodeCondition.classNameIn : list;
        String str16 = (i & 16) != 0 ? nodeCondition.viewId : str4;
        String str17 = (i & 32) != 0 ? nodeCondition.viewIdRegex : str5;
        String str18 = (i & 64) != 0 ? nodeCondition.text : str6;
        String str19 = (i & 128) != 0 ? nodeCondition.textContains : str7;
        String str20 = (i & 256) != 0 ? nodeCondition.textRegex : str8;
        Boolean bool10 = (i & 512) != 0 ? nodeCondition.textNotEmpty : bool;
        String str21 = (i & 1024) != 0 ? nodeCondition.description : str9;
        String str22 = (i & 2048) != 0 ? nodeCondition.descriptionContains : str10;
        Integer num10 = (i & 4096) != 0 ? nodeCondition.minWidth : num;
        Integer num11 = (i & 8192) != 0 ? nodeCondition.maxWidth : num2;
        String str23 = str13;
        Integer num12 = (i & 16384) != 0 ? nodeCondition.minHeight : num3;
        Integer num13 = (i & 32768) != 0 ? nodeCondition.maxHeight : num4;
        Float f9 = (i & 65536) != 0 ? nodeCondition.widthHeightRatioMin : f;
        Float f10 = (i & 131072) != 0 ? nodeCondition.widthHeightRatioMax : f7;
        Boolean bool11 = (i & 262144) != 0 ? nodeCondition.touchable : bool2;
        Boolean bool12 = (i & 524288) != 0 ? nodeCondition.clickable : bool3;
        Boolean bool13 = (i & 1048576) != 0 ? nodeCondition.longClickable : bool4;
        Boolean bool14 = (i & 2097152) != 0 ? nodeCondition.checkable : bool5;
        Boolean bool15 = (i & 4194304) != 0 ? nodeCondition.checked : bool6;
        Boolean bool16 = (i & 8388608) != 0 ? nodeCondition.horizontalScrollable : bool7;
        Boolean bool17 = (i & 16777216) != 0 ? nodeCondition.verticalScrollable : bool8;
        Integer num14 = (i & 33554432) != 0 ? nodeCondition.minChildCount : num5;
        Integer num15 = (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? nodeCondition.maxChildCount : num6;
        Boolean bool18 = (i & 134217728) != 0 ? nodeCondition.hasChildren : bool9;
        Integer num16 = (i & 268435456) != 0 ? nodeCondition.minProgress : num7;
        Integer num17 = (i & 536870912) != 0 ? nodeCondition.maxProgress : num8;
        if ((i & BasicMeasure.EXACTLY) != 0) {
            num9 = num17;
            str12 = nodeCondition.customPredicate;
        } else {
            str12 = str11;
            num9 = num17;
        }
        return nodeCondition.copy(str23, str14, str15, list2, str16, str17, str18, str19, str20, bool10, str21, str22, num10, num11, num12, num13, f9, f10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, num14, num15, bool18, num16, num9, str12);
    }

    public static /* synthetic */ void getClassNameRegexCache$uxsense_release$annotations() {
    }

    public static /* synthetic */ void getTextRegexCache$uxsense_release$annotations() {
    }

    public static /* synthetic */ void getViewIdRegexCache$uxsense_release$annotations() {
    }

    public static final /* synthetic */ void write$Self$uxsense_release(NodeCondition self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.className != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, h0.f242a, self.className);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.classNameContains != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, h0.f242a, self.classNameContains);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.classNameRegex != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, h0.f242a, self.classNameRegex);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.classNameIn != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (x9.f) fVarArr[3].getF4884a(), self.classNameIn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.viewId != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, h0.f242a, self.viewId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.viewIdRegex != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, h0.f242a, self.viewIdRegex);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, h0.f242a, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.textContains != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, h0.f242a, self.textContains);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.textRegex != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, h0.f242a, self.textRegex);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.textNotEmpty != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, C0180g.f239a, self.textNotEmpty);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, h0.f242a, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.descriptionContains != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, h0.f242a, self.descriptionContains);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.minWidth != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, F.f218a, self.minWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.maxWidth != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, F.f218a, self.maxWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.minHeight != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, F.f218a, self.minHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.maxHeight != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, F.f218a, self.maxHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.widthHeightRatioMin != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, C0198z.f264a, self.widthHeightRatioMin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.widthHeightRatioMax != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, C0198z.f264a, self.widthHeightRatioMax);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.touchable != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, C0180g.f239a, self.touchable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.clickable != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, C0180g.f239a, self.clickable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.longClickable != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, C0180g.f239a, self.longClickable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.checkable != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, C0180g.f239a, self.checkable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.checked != null) {
            output.encodeNullableSerializableElement(serialDesc, 22, C0180g.f239a, self.checked);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.horizontalScrollable != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, C0180g.f239a, self.horizontalScrollable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.verticalScrollable != null) {
            output.encodeNullableSerializableElement(serialDesc, 24, C0180g.f239a, self.verticalScrollable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || self.minChildCount != null) {
            output.encodeNullableSerializableElement(serialDesc, 25, F.f218a, self.minChildCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.maxChildCount != null) {
            output.encodeNullableSerializableElement(serialDesc, 26, F.f218a, self.maxChildCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.hasChildren != null) {
            output.encodeNullableSerializableElement(serialDesc, 27, C0180g.f239a, self.hasChildren);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || self.minProgress != null) {
            output.encodeNullableSerializableElement(serialDesc, 28, F.f218a, self.minProgress);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.maxProgress != null) {
            output.encodeNullableSerializableElement(serialDesc, 29, F.f218a, self.maxProgress);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 30) && self.customPredicate == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 30, h0.f242a, self.customPredicate);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getTextNotEmpty() {
        return this.textNotEmpty;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component12, reason: from getter */
    public final String getDescriptionContains() {
        return this.descriptionContains;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getMinWidth() {
        return this.minWidth;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getMaxWidth() {
        return this.maxWidth;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getMinHeight() {
        return this.minHeight;
    }

    /* renamed from: component16, reason: from getter */
    public final Integer getMaxHeight() {
        return this.maxHeight;
    }

    /* renamed from: component17, reason: from getter */
    public final Float getWidthHeightRatioMin() {
        return this.widthHeightRatioMin;
    }

    /* renamed from: component18, reason: from getter */
    public final Float getWidthHeightRatioMax() {
        return this.widthHeightRatioMax;
    }

    /* renamed from: component19, reason: from getter */
    public final Boolean getTouchable() {
        return this.touchable;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClassNameContains() {
        return this.classNameContains;
    }

    /* renamed from: component20, reason: from getter */
    public final Boolean getClickable() {
        return this.clickable;
    }

    /* renamed from: component21, reason: from getter */
    public final Boolean getLongClickable() {
        return this.longClickable;
    }

    /* renamed from: component22, reason: from getter */
    public final Boolean getCheckable() {
        return this.checkable;
    }

    /* renamed from: component23, reason: from getter */
    public final Boolean getChecked() {
        return this.checked;
    }

    /* renamed from: component24, reason: from getter */
    public final Boolean getHorizontalScrollable() {
        return this.horizontalScrollable;
    }

    /* renamed from: component25, reason: from getter */
    public final Boolean getVerticalScrollable() {
        return this.verticalScrollable;
    }

    /* renamed from: component26, reason: from getter */
    public final Integer getMinChildCount() {
        return this.minChildCount;
    }

    /* renamed from: component27, reason: from getter */
    public final Integer getMaxChildCount() {
        return this.maxChildCount;
    }

    /* renamed from: component28, reason: from getter */
    public final Boolean getHasChildren() {
        return this.hasChildren;
    }

    /* renamed from: component29, reason: from getter */
    public final Integer getMinProgress() {
        return this.minProgress;
    }

    /* renamed from: component3, reason: from getter */
    public final String getClassNameRegex() {
        return this.classNameRegex;
    }

    /* renamed from: component30, reason: from getter */
    public final Integer getMaxProgress() {
        return this.maxProgress;
    }

    /* renamed from: component31, reason: from getter */
    public final String getCustomPredicate() {
        return this.customPredicate;
    }

    public final List<String> component4() {
        return this.classNameIn;
    }

    /* renamed from: component5, reason: from getter */
    public final String getViewId() {
        return this.viewId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getViewIdRegex() {
        return this.viewIdRegex;
    }

    /* renamed from: component7, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTextContains() {
        return this.textContains;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTextRegex() {
        return this.textRegex;
    }

    public final NodeCondition copy(String className, String classNameContains, String classNameRegex, List<String> classNameIn, String viewId, String viewIdRegex, String text, String textContains, String textRegex, Boolean textNotEmpty, String description, String descriptionContains, Integer minWidth, Integer maxWidth, Integer minHeight, Integer maxHeight, Float widthHeightRatioMin, Float widthHeightRatioMax, Boolean touchable, Boolean clickable, Boolean longClickable, Boolean checkable, Boolean checked, Boolean horizontalScrollable, Boolean verticalScrollable, Integer minChildCount, Integer maxChildCount, Boolean hasChildren, Integer minProgress, Integer maxProgress, String customPredicate) {
        return new NodeCondition(className, classNameContains, classNameRegex, classNameIn, viewId, viewIdRegex, text, textContains, textRegex, textNotEmpty, description, descriptionContains, minWidth, maxWidth, minHeight, maxHeight, widthHeightRatioMin, widthHeightRatioMax, touchable, clickable, longClickable, checkable, checked, horizontalScrollable, verticalScrollable, minChildCount, maxChildCount, hasChildren, minProgress, maxProgress, customPredicate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NodeCondition)) {
            return false;
        }
        NodeCondition nodeCondition = (NodeCondition) other;
        return k.b(this.className, nodeCondition.className) && k.b(this.classNameContains, nodeCondition.classNameContains) && k.b(this.classNameRegex, nodeCondition.classNameRegex) && k.b(this.classNameIn, nodeCondition.classNameIn) && k.b(this.viewId, nodeCondition.viewId) && k.b(this.viewIdRegex, nodeCondition.viewIdRegex) && k.b(this.text, nodeCondition.text) && k.b(this.textContains, nodeCondition.textContains) && k.b(this.textRegex, nodeCondition.textRegex) && k.b(this.textNotEmpty, nodeCondition.textNotEmpty) && k.b(this.description, nodeCondition.description) && k.b(this.descriptionContains, nodeCondition.descriptionContains) && k.b(this.minWidth, nodeCondition.minWidth) && k.b(this.maxWidth, nodeCondition.maxWidth) && k.b(this.minHeight, nodeCondition.minHeight) && k.b(this.maxHeight, nodeCondition.maxHeight) && k.b(this.widthHeightRatioMin, nodeCondition.widthHeightRatioMin) && k.b(this.widthHeightRatioMax, nodeCondition.widthHeightRatioMax) && k.b(this.touchable, nodeCondition.touchable) && k.b(this.clickable, nodeCondition.clickable) && k.b(this.longClickable, nodeCondition.longClickable) && k.b(this.checkable, nodeCondition.checkable) && k.b(this.checked, nodeCondition.checked) && k.b(this.horizontalScrollable, nodeCondition.horizontalScrollable) && k.b(this.verticalScrollable, nodeCondition.verticalScrollable) && k.b(this.minChildCount, nodeCondition.minChildCount) && k.b(this.maxChildCount, nodeCondition.maxChildCount) && k.b(this.hasChildren, nodeCondition.hasChildren) && k.b(this.minProgress, nodeCondition.minProgress) && k.b(this.maxProgress, nodeCondition.maxProgress) && k.b(this.customPredicate, nodeCondition.customPredicate);
    }

    public final Boolean getCheckable() {
        return this.checkable;
    }

    public final Boolean getChecked() {
        return this.checked;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getClassNameContains() {
        return this.classNameContains;
    }

    public final List<String> getClassNameIn() {
        return this.classNameIn;
    }

    public final String getClassNameRegex() {
        return this.classNameRegex;
    }

    /* renamed from: getClassNameRegexCache$uxsense_release, reason: from getter */
    public final Regex getClassNameRegexCache() {
        return this.classNameRegexCache;
    }

    public final Boolean getClickable() {
        return this.clickable;
    }

    public final String getCustomPredicate() {
        return this.customPredicate;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDescriptionContains() {
        return this.descriptionContains;
    }

    public final Boolean getHasChildren() {
        return this.hasChildren;
    }

    public final Boolean getHorizontalScrollable() {
        return this.horizontalScrollable;
    }

    public final Boolean getLongClickable() {
        return this.longClickable;
    }

    public final Integer getMaxChildCount() {
        return this.maxChildCount;
    }

    public final Integer getMaxHeight() {
        return this.maxHeight;
    }

    public final Integer getMaxProgress() {
        return this.maxProgress;
    }

    public final Integer getMaxWidth() {
        return this.maxWidth;
    }

    public final Integer getMinChildCount() {
        return this.minChildCount;
    }

    public final Integer getMinHeight() {
        return this.minHeight;
    }

    public final Integer getMinProgress() {
        return this.minProgress;
    }

    public final Integer getMinWidth() {
        return this.minWidth;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextContains() {
        return this.textContains;
    }

    public final Boolean getTextNotEmpty() {
        return this.textNotEmpty;
    }

    public final String getTextRegex() {
        return this.textRegex;
    }

    /* renamed from: getTextRegexCache$uxsense_release, reason: from getter */
    public final Regex getTextRegexCache() {
        return this.textRegexCache;
    }

    public final Boolean getTouchable() {
        return this.touchable;
    }

    public final Boolean getVerticalScrollable() {
        return this.verticalScrollable;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final String getViewIdRegex() {
        return this.viewIdRegex;
    }

    /* renamed from: getViewIdRegexCache$uxsense_release, reason: from getter */
    public final Regex getViewIdRegexCache() {
        return this.viewIdRegexCache;
    }

    public final Float getWidthHeightRatioMax() {
        return this.widthHeightRatioMax;
    }

    public final Float getWidthHeightRatioMin() {
        return this.widthHeightRatioMin;
    }

    public int hashCode() {
        String str = this.className;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.classNameContains;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.classNameRegex;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.classNameIn;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.viewId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.viewIdRegex;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.text;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.textContains;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.textRegex;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool = this.textNotEmpty;
        int iHashCode10 = (iHashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str9 = this.description;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.descriptionContains;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num = this.minWidth;
        int iHashCode13 = (iHashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.maxWidth;
        int iHashCode14 = (iHashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.minHeight;
        int iHashCode15 = (iHashCode14 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.maxHeight;
        int iHashCode16 = (iHashCode15 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Float f = this.widthHeightRatioMin;
        int iHashCode17 = (iHashCode16 + (f == null ? 0 : f.hashCode())) * 31;
        Float f7 = this.widthHeightRatioMax;
        int iHashCode18 = (iHashCode17 + (f7 == null ? 0 : f7.hashCode())) * 31;
        Boolean bool2 = this.touchable;
        int iHashCode19 = (iHashCode18 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.clickable;
        int iHashCode20 = (iHashCode19 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.longClickable;
        int iHashCode21 = (iHashCode20 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.checkable;
        int iHashCode22 = (iHashCode21 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.checked;
        int iHashCode23 = (iHashCode22 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.horizontalScrollable;
        int iHashCode24 = (iHashCode23 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.verticalScrollable;
        int iHashCode25 = (iHashCode24 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Integer num5 = this.minChildCount;
        int iHashCode26 = (iHashCode25 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.maxChildCount;
        int iHashCode27 = (iHashCode26 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Boolean bool9 = this.hasChildren;
        int iHashCode28 = (iHashCode27 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        Integer num7 = this.minProgress;
        int iHashCode29 = (iHashCode28 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.maxProgress;
        int iHashCode30 = (iHashCode29 + (num8 == null ? 0 : num8.hashCode())) * 31;
        String str11 = this.customPredicate;
        return iHashCode30 + (str11 != null ? str11.hashCode() : 0);
    }

    public final void setClassNameRegexCache$uxsense_release(Regex regex) {
        this.classNameRegexCache = regex;
    }

    public final void setTextRegexCache$uxsense_release(Regex regex) {
        this.textRegexCache = regex;
    }

    public final void setViewIdRegexCache$uxsense_release(Regex regex) {
        this.viewIdRegexCache = regex;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NodeCondition(className=");
        sb.append(this.className);
        sb.append(", classNameContains=");
        sb.append(this.classNameContains);
        sb.append(", classNameRegex=");
        sb.append(this.classNameRegex);
        sb.append(", classNameIn=");
        sb.append(this.classNameIn);
        sb.append(", viewId=");
        sb.append(this.viewId);
        sb.append(", viewIdRegex=");
        sb.append(this.viewIdRegex);
        sb.append(", text=");
        sb.append(this.text);
        sb.append(", textContains=");
        sb.append(this.textContains);
        sb.append(", textRegex=");
        sb.append(this.textRegex);
        sb.append(", textNotEmpty=");
        sb.append(this.textNotEmpty);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", descriptionContains=");
        sb.append(this.descriptionContains);
        sb.append(", minWidth=");
        sb.append(this.minWidth);
        sb.append(", maxWidth=");
        sb.append(this.maxWidth);
        sb.append(", minHeight=");
        sb.append(this.minHeight);
        sb.append(", maxHeight=");
        sb.append(this.maxHeight);
        sb.append(", widthHeightRatioMin=");
        sb.append(this.widthHeightRatioMin);
        sb.append(", widthHeightRatioMax=");
        sb.append(this.widthHeightRatioMax);
        sb.append(", touchable=");
        sb.append(this.touchable);
        sb.append(", clickable=");
        sb.append(this.clickable);
        sb.append(", longClickable=");
        sb.append(this.longClickable);
        sb.append(", checkable=");
        sb.append(this.checkable);
        sb.append(", checked=");
        sb.append(this.checked);
        sb.append(", horizontalScrollable=");
        sb.append(this.horizontalScrollable);
        sb.append(", verticalScrollable=");
        sb.append(this.verticalScrollable);
        sb.append(", minChildCount=");
        sb.append(this.minChildCount);
        sb.append(", maxChildCount=");
        sb.append(this.maxChildCount);
        sb.append(", hasChildren=");
        sb.append(this.hasChildren);
        sb.append(", minProgress=");
        sb.append(this.minProgress);
        sb.append(", maxProgress=");
        sb.append(this.maxProgress);
        sb.append(", customPredicate=");
        return B7.a.g(')', this.customPredicate, sb);
    }

    public /* synthetic */ NodeCondition(int i, String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10, Integer num, Integer num2, Integer num3, Integer num4, Float f, Float f7, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Integer num5, Integer num6, Boolean bool9, Integer num7, Integer num8, String str11, d0 d0Var) {
        if ((i & 1) == 0) {
            this.className = null;
        } else {
            this.className = str;
        }
        if ((i & 2) == 0) {
            this.classNameContains = null;
        } else {
            this.classNameContains = str2;
        }
        if ((i & 4) == 0) {
            this.classNameRegex = null;
        } else {
            this.classNameRegex = str3;
        }
        if ((i & 8) == 0) {
            this.classNameIn = null;
        } else {
            this.classNameIn = list;
        }
        if ((i & 16) == 0) {
            this.viewId = null;
        } else {
            this.viewId = str4;
        }
        if ((i & 32) == 0) {
            this.viewIdRegex = null;
        } else {
            this.viewIdRegex = str5;
        }
        if ((i & 64) == 0) {
            this.text = null;
        } else {
            this.text = str6;
        }
        if ((i & 128) == 0) {
            this.textContains = null;
        } else {
            this.textContains = str7;
        }
        if ((i & 256) == 0) {
            this.textRegex = null;
        } else {
            this.textRegex = str8;
        }
        if ((i & 512) == 0) {
            this.textNotEmpty = null;
        } else {
            this.textNotEmpty = bool;
        }
        if ((i & 1024) == 0) {
            this.description = null;
        } else {
            this.description = str9;
        }
        if ((i & 2048) == 0) {
            this.descriptionContains = null;
        } else {
            this.descriptionContains = str10;
        }
        if ((i & 4096) == 0) {
            this.minWidth = null;
        } else {
            this.minWidth = num;
        }
        if ((i & 8192) == 0) {
            this.maxWidth = null;
        } else {
            this.maxWidth = num2;
        }
        if ((i & 16384) == 0) {
            this.minHeight = null;
        } else {
            this.minHeight = num3;
        }
        if ((32768 & i) == 0) {
            this.maxHeight = null;
        } else {
            this.maxHeight = num4;
        }
        if ((65536 & i) == 0) {
            this.widthHeightRatioMin = null;
        } else {
            this.widthHeightRatioMin = f;
        }
        if ((131072 & i) == 0) {
            this.widthHeightRatioMax = null;
        } else {
            this.widthHeightRatioMax = f7;
        }
        if ((262144 & i) == 0) {
            this.touchable = null;
        } else {
            this.touchable = bool2;
        }
        if ((524288 & i) == 0) {
            this.clickable = null;
        } else {
            this.clickable = bool3;
        }
        if ((1048576 & i) == 0) {
            this.longClickable = null;
        } else {
            this.longClickable = bool4;
        }
        if ((2097152 & i) == 0) {
            this.checkable = null;
        } else {
            this.checkable = bool5;
        }
        if ((4194304 & i) == 0) {
            this.checked = null;
        } else {
            this.checked = bool6;
        }
        if ((8388608 & i) == 0) {
            this.horizontalScrollable = null;
        } else {
            this.horizontalScrollable = bool7;
        }
        if ((16777216 & i) == 0) {
            this.verticalScrollable = null;
        } else {
            this.verticalScrollable = bool8;
        }
        if ((33554432 & i) == 0) {
            this.minChildCount = null;
        } else {
            this.minChildCount = num5;
        }
        if ((67108864 & i) == 0) {
            this.maxChildCount = null;
        } else {
            this.maxChildCount = num6;
        }
        if ((134217728 & i) == 0) {
            this.hasChildren = null;
        } else {
            this.hasChildren = bool9;
        }
        if ((268435456 & i) == 0) {
            this.minProgress = null;
        } else {
            this.minProgress = num7;
        }
        if ((536870912 & i) == 0) {
            this.maxProgress = null;
        } else {
            this.maxProgress = num8;
        }
        if ((i & BasicMeasure.EXACTLY) == 0) {
            this.customPredicate = null;
        } else {
            this.customPredicate = str11;
        }
        this.classNameRegexCache = null;
        this.viewIdRegexCache = null;
        this.textRegexCache = null;
    }

    public NodeCondition(String str, String str2, String str3, List<String> list, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10, Integer num, Integer num2, Integer num3, Integer num4, Float f, Float f7, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Integer num5, Integer num6, Boolean bool9, Integer num7, Integer num8, String str11) {
        this.className = str;
        this.classNameContains = str2;
        this.classNameRegex = str3;
        this.classNameIn = list;
        this.viewId = str4;
        this.viewIdRegex = str5;
        this.text = str6;
        this.textContains = str7;
        this.textRegex = str8;
        this.textNotEmpty = bool;
        this.description = str9;
        this.descriptionContains = str10;
        this.minWidth = num;
        this.maxWidth = num2;
        this.minHeight = num3;
        this.maxHeight = num4;
        this.widthHeightRatioMin = f;
        this.widthHeightRatioMax = f7;
        this.touchable = bool2;
        this.clickable = bool3;
        this.longClickable = bool4;
        this.checkable = bool5;
        this.checked = bool6;
        this.horizontalScrollable = bool7;
        this.verticalScrollable = bool8;
        this.minChildCount = num5;
        this.maxChildCount = num6;
        this.hasChildren = bool9;
        this.minProgress = num7;
        this.maxProgress = num8;
        this.customPredicate = str11;
    }

    public /* synthetic */ NodeCondition(String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10, Integer num, Integer num2, Integer num3, Integer num4, Float f, Float f7, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Integer num5, Integer num6, Boolean bool9, Integer num7, Integer num8, String str11, int i, e eVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : num, (i & 8192) != 0 ? null : num2, (i & 16384) != 0 ? null : num3, (i & 32768) != 0 ? null : num4, (i & 65536) != 0 ? null : f, (i & 131072) != 0 ? null : f7, (i & 262144) != 0 ? null : bool2, (i & 524288) != 0 ? null : bool3, (i & 1048576) != 0 ? null : bool4, (i & 2097152) != 0 ? null : bool5, (i & 4194304) != 0 ? null : bool6, (i & 8388608) != 0 ? null : bool7, (i & 16777216) != 0 ? null : bool8, (i & 33554432) != 0 ? null : num5, (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? null : num6, (i & 134217728) != 0 ? null : bool9, (i & 268435456) != 0 ? null : num7, (i & 536870912) != 0 ? null : num8, (i & BasicMeasure.EXACTLY) != 0 ? null : str11);
    }
}
