package com.obric.oui.material;

import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.oui.color.j0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Keep
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\bp\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\tJ-\u0010\u000f\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0012\u001a\u00020\u00072\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0012\u0010\u0010J!\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0013\u0010\tJ!\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\tJ9\u0010\u0016\u001a\u00020\u00072\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u00150\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0016\u0010\u0010J?\u0010\u0017\u001a\u00020\u00072$\u0010\u000e\u001a \u0012\u0004\u0012\u00020\f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00150\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0017\u0010\u0010J'\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0011\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u001b\u0010\u001aJ#\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0019\u0010\u001dJ)\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001b\u0010\u001eJ\u0019\u0010!\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b$\u0010%J'\u0010'\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00112\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011H\u0007¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020\r*\u00020\rH\u0002¢\u0006\u0004\b)\u0010%J\u0013\u0010*\u001a\u00020\r*\u00020\rH\u0002¢\u0006\u0004\b*\u0010%J)\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0000¢\u0006\u0004\b+\u0010\u001eR\u0014\u0010-\u001a\u00020\u001f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u001f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010.R'\u00105\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R-\u00108\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0011008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R3\u0010;\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u0015008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u00104R9\u0010>\u001a \u0012\u0004\u0012\u00020\f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u0015008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00102\u001a\u0004\b=\u00104R\u0014\u0010?\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010@R\u0014\u0010B\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bB\u0010@R\u0014\u0010C\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010ER&\u0010G\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bI\u0010@R\u0014\u0010J\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u0010@R\u0014\u0010K\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010@R\u0014\u0010L\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bL\u0010@R\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010ER\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bN\u0010ER&\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010HR\u0014\u0010P\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010@R\u0014\u0010Q\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010@R\u0014\u0010R\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bR\u0010@R\u0014\u0010S\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bS\u0010@R\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010ER\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bU\u0010ER&\u0010V\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010HR\u0014\u0010W\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bW\u0010@R\u0014\u0010X\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bX\u0010@R \u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bY\u0010HR\u0014\u0010Z\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bZ\u0010@R\u0014\u0010[\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b[\u0010@R\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\\\u0010ER\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b]\u0010ER&\u0010^\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b^\u0010HR\u0014\u0010_\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b_\u0010@R\u0014\u0010`\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b`\u0010@R\u0014\u0010a\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u0010@R\u0014\u0010b\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bb\u0010@R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bc\u0010ER\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bd\u0010ER&\u0010e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\be\u0010HR\u0014\u0010f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bf\u0010@R\u0014\u0010g\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bg\u0010@R\u0014\u0010h\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bh\u0010@R\u0014\u0010i\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bi\u0010@R\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bj\u0010ER\u001a\u0010k\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bk\u0010ER&\u0010l\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bl\u0010HR\u0014\u0010m\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bm\u0010@R\u0014\u0010n\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bn\u0010@R\u0014\u0010o\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bo\u0010@R\u0014\u0010p\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bp\u0010@R\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bq\u0010ER\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\br\u0010ER&\u0010s\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bs\u0010HR\u0014\u0010t\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bt\u0010@R\u0014\u0010u\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bu\u0010@R\u0014\u0010v\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bv\u0010@R\u0014\u0010w\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bw\u0010@R\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bx\u0010ER\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\by\u0010ER&\u0010z\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bz\u0010HR\u001a\u0010{\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b{\u0010@\u0012\u0004\b|\u0010\u0003R\u001a\u0010}\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b}\u0010@\u0012\u0004\b~\u0010\u0003R\u001b\u0010\u007f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\r\n\u0004\b\u007f\u0010@\u0012\u0005\b\u0080\u0001\u0010\u0003R\u001d\u0010\u0081\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010@\u0012\u0005\b\u0082\u0001\u0010\u0003R#\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010E\u0012\u0005\b\u0084\u0001\u0010\u0003R#\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010E\u0012\u0005\b\u0086\u0001\u0010\u0003R/\u0010\u0087\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010H\u0012\u0005\b\u0088\u0001\u0010\u0003R\u0016\u0010\u0089\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010@R\u0016\u0010\u008a\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010@R\u0016\u0010\u008b\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010@R\u0016\u0010\u008c\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010@R\u001c\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010ER\u001c\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010ER(\u0010\u008f\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010HR\u0016\u0010\u0090\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010@R\u0016\u0010\u0091\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010@R\u0016\u0010\u0092\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010@R\u0016\u0010\u0093\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010@R\u001c\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010ER\u001c\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010ER(\u0010\u0096\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00158\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010HR\u0016\u0010\u0097\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010@R\u0016\u0010\u0098\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010@R\"\u0010\u0099\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u00158\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010HR\u0016\u0010\u009a\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010@R\u0016\u0010\u009b\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010@R\"\u0010\u009c\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u00158\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010HR\u0016\u0010\u009d\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010@R\u0016\u0010\u009e\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010@R\"\u0010\u009f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u00158\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010H¨\u0006 \u0001"}, d2 = {"Lcom/obric/oui/material/MaterialToken;", "", "<init>", "()V", "customTokenOwner", "", "overrideExisting", "", "register", "(Ljava/lang/Object;Z)V", "registerSet", "", "", "Lcom/obric/oui/material/b;", "customTokens", "registerTokens", "(Ljava/util/Map;Z)V", "", "registerTokenSets", "registerProvider", "registerSetProvider", "Lkotlin/Function1;", "registerProviderTokens", "registerSetProviderTokens", "name", "parse", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;", "parseSet", "isLight", "(Ljava/lang/String;Z)Lcom/obric/oui/material/b;", "(Ljava/lang/String;Z)[Lcom/obric/oui/material/b;", "", "requiredApiLevel", "isApiCompatible", "(I)Z", "config", "compatibleConfig", "(Lcom/obric/oui/material/b;)Lcom/obric/oui/material/b;", "configs", "compatibleConfigArray", "([Lcom/obric/oui/material/b;)[Lcom/obric/oui/material/b;", "toLegacyCompatibleConfig", "toApi3CompatibleConfig", "resolveTokenForBuilder$OUI_standardRelease", "resolveTokenForBuilder", "MATERIAL_TOKEN_API_LEVEL", "I", "MIN_SUPPORTED_MATERIAL_API_LEVEL", "Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "tokens", "tokenSets$delegate", "getTokenSets", "tokenSets", "providers$delegate", "getProviders", "providers", "setProviders$delegate", "getSetProviders", "setProviders", "OUI_Bg_Floating_Frost_Light", "Lcom/obric/oui/material/b;", "OUI_Bg_Floating_Frost_Dark", "OUI_Bg_Floating_Fluid_Light", "OUI_Bg_Floating_Fluid_Dark", "OUI_Bg_Floating_Light", "[Lcom/obric/oui/material/b;", "OUI_Bg_Floating_Dark", "OUI_Bg_Floating", "Lkotlin/jvm/functions/Function1;", "OUI_Bg_Floating_OnImage_Frost_Light", "OUI_Bg_Floating_OnImage_Frost_Dark", "OUI_Bg_Floating_OnImage_Fluid_Light", "OUI_Bg_Floating_OnImage_Fluid_Dark", "OUI_Bg_Floating_OnImage_Light", "OUI_Bg_Floating_OnImage_Dark", "OUI_Bg_Floating_OnImage", "OUI_Bg_Floating_Fill_Frost_Light", "OUI_Bg_Floating_Fill_Frost_Dark", "OUI_Bg_Floating_Fill_Fluid_Light", "OUI_Bg_Floating_Fill_Fluid_Dark", "OUI_Bg_Floating_Fill_Light", "OUI_Bg_Floating_Fill_Dark", "OUI_Bg_Floating_Fill", "OUI_Bg_Popup_Frost_Light", "OUI_Bg_Popup_Frost_Dark", "OUI_Bg_Popup_Frost", "OUI_Bg_Popup_Fluid_Light", "OUI_Bg_Popup_Fluid_Dark", "OUI_Bg_Popup_Light", "OUI_Bg_Popup_Dark", "OUI_Bg_Popup", "OUI_Bg_Popup_OnImage_Frost_Light", "OUI_Bg_Popup_OnImage_Frost_Dark", "OUI_Bg_Popup_OnImage_Fluid_Light", "OUI_Bg_Popup_OnImage_Fluid_Dark", "OUI_Bg_Popup_OnImage_Light", "OUI_Bg_Popup_OnImage_Dark", "OUI_Bg_Popup_OnImage", "OUI_Bg_Popup_Overlay_Frost_Light", "OUI_Bg_Popup_Overlay_Frost_Dark", "OUI_Bg_Popup_Overlay_Fluid_Light", "OUI_Bg_Popup_Overlay_Fluid_Dark", "OUI_Bg_Popup_Overlay_Light", "OUI_Bg_Popup_Overlay_Dark", "OUI_Bg_Popup_Overlay", "OUI_Bg_Modal_Frost_Light", "OUI_Bg_Modal_Frost_Dark", "OUI_Bg_Modal_Fluid_Light", "OUI_Bg_Modal_Fluid_Dark", "OUI_Bg_Modal_Light", "OUI_Bg_Modal_Dark", "OUI_Bg_Modal", "OUI_Bg_Floating_Overlay_Frost_Light", "OUI_Bg_Floating_Overlay_Frost_Dark", "OUI_Bg_Floating_Overlay_Fluid_Light", "OUI_Bg_Floating_Overlay_Fluid_Dark", "OUI_Bg_Floating_Overlay_Light", "OUI_Bg_Floating_Overlay_Dark", "OUI_Bg_Floating_Overlay", "OUI_Bg_Overlay_Search_Frost_Light", "getOUI_Bg_Overlay_Search_Frost_Light$annotations", "OUI_Bg_Overlay_Search_Frost_Dark", "getOUI_Bg_Overlay_Search_Frost_Dark$annotations", "OUI_Bg_Overlay_Search_Fluid_Light", "getOUI_Bg_Overlay_Search_Fluid_Light$annotations", "OUI_Bg_Overlay_Search_Fluid_Dark", "getOUI_Bg_Overlay_Search_Fluid_Dark$annotations", "OUI_Bg_Overlay_Search_Light", "getOUI_Bg_Overlay_Search_Light$annotations", "OUI_Bg_Overlay_Search_Dark", "getOUI_Bg_Overlay_Search_Dark$annotations", "OUI_Bg_Overlay_Search", "getOUI_Bg_Overlay_Search$annotations", "OUI_Bg_Floating_Frost_Tinted_Light", "OUI_Bg_Floating_Frost_Tinted_Dark", "OUI_Bg_Floating_Fluid_Tinted_Light", "OUI_Bg_Floating_Fluid_Tinted_Dark", "OUI_Bg_Floating_Tinted_Light", "OUI_Bg_Floating_Tinted_Dark", "OUI_Bg_Floating_Tinted", "OUI_Bg_Floating_Frost_Blue_Light", "OUI_Bg_Floating_Frost_Blue_Dark", "OUI_Bg_Floating_Fluid_Blue_Light", "OUI_Bg_Floating_Fluid_Blue_Dark", "OUI_Bg_Floating_Blue_Light", "OUI_Bg_Floating_Blue_Dark", "OUI_Bg_Floating_Blue", "OUI_Text_Primary_Light", "OUI_Text_Primary_Dark", "OUI_Text_Primary", "OUI_Text_Secondary_Light", "OUI_Text_Secondary_Dark", "OUI_Text_Secondary", "OUI_Text_Tertiary_Light", "OUI_Text_Tertiary_Dark", "OUI_Text_Tertiary", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialToken {

    @NotNull
    public static final MaterialToken INSTANCE = null;
    public static final int MATERIAL_TOKEN_API_LEVEL = 4;
    public static final int MIN_SUPPORTED_MATERIAL_API_LEVEL = 1;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Floating = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Floating_Blue = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_Blue_Dark = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_Blue_Light = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_Dark = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Floating_Fill = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_Fill_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Fill_Fluid_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Fill_Fluid_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Fill_Frost_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Fill_Frost_Light = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_Fill_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Fluid_Blue_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Fluid_Blue_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Fluid_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Fluid_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Fluid_Tinted_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Fluid_Tinted_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Frost_Blue_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Frost_Blue_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Frost_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Frost_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Frost_Tinted_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Frost_Tinted_Light = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Floating_OnImage = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_OnImage_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_OnImage_Fluid_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_OnImage_Fluid_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_OnImage_Frost_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_OnImage_Frost_Light = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_OnImage_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Floating_Overlay = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_Overlay_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Overlay_Fluid_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Overlay_Fluid_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Overlay_Frost_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Floating_Overlay_Frost_Light = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_Overlay_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Floating_Tinted = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_Tinted_Dark = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Floating_Tinted_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Modal = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Modal_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Modal_Fluid_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Modal_Fluid_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Modal_Frost_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Modal_Frost_Light = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Modal_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Overlay_Search = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Overlay_Search_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Overlay_Search_Fluid_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Overlay_Search_Fluid_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Overlay_Search_Frost_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Overlay_Search_Frost_Light = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Overlay_Search_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Popup = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Popup_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_Fluid_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_Fluid_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b> OUI_Bg_Popup_Frost = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_Frost_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_Frost_Light = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Popup_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Popup_OnImage = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Popup_OnImage_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_OnImage_Fluid_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_OnImage_Fluid_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_OnImage_Frost_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_OnImage_Frost_Light = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Popup_OnImage_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b[]> OUI_Bg_Popup_Overlay = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Popup_Overlay_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_Overlay_Fluid_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_Overlay_Fluid_Light = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_Overlay_Frost_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Bg_Popup_Overlay_Frost_Light = null;

    @JvmField
    @NotNull
    public static final b[] OUI_Bg_Popup_Overlay_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b> OUI_Text_Primary = null;

    @JvmField
    @NotNull
    public static final b OUI_Text_Primary_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Text_Primary_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b> OUI_Text_Secondary = null;

    @JvmField
    @NotNull
    public static final b OUI_Text_Secondary_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Text_Secondary_Light = null;

    @JvmField
    @NotNull
    public static final Function1<Boolean, b> OUI_Text_Tertiary = null;

    @JvmField
    @NotNull
    public static final b OUI_Text_Tertiary_Dark = null;

    @JvmField
    @NotNull
    public static final b OUI_Text_Tertiary_Light = null;

    @NotNull
    private static final Lazy providers$delegate = null;

    @NotNull
    private static final Lazy setProviders$delegate = null;

    @NotNull
    private static final Lazy tokenSets$delegate = null;

    @NotNull
    private static final Lazy tokens$delegate = null;

    /* JADX INFO: renamed from: com.obric.oui.material.MaterialToken$compatibleConfigArray$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<b, b> {
        public AnonymousClass1(Object r10) {
            super(1, r10, MaterialToken.class, "compatibleConfig", "compatibleConfig(Lcom/obric/oui/material/MaterialConfig;)Lcom/obric/oui/material/MaterialConfig;", 0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final b invoke2(@Nullable b r10) {
            return MaterialToken.compatibleConfig(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ b invoke(b r10) {
            return invoke2(r10);
        }
    }

    static {
        INSTANCE = new MaterialToken();
        tokens$delegate = kotlin.b.b(MaterialToken$tokens$2.INSTANCE);
        tokenSets$delegate = kotlin.b.b(MaterialToken$tokenSets$2.INSTANCE);
        providers$delegate = kotlin.b.b(MaterialToken$providers$2.INSTANCE);
        setProviders$delegate = kotlin.b.b(MaterialToken$setProviders$2.INSTANCE);
        d r10 = h.f15238a;
        kotlin.jvm.internal.q.f(r10, "OUI_Bg_Floating_Frost_Light");
        OUI_Bg_Floating_Frost_Light = e.b(r10);
        d r11 = h.f15240b;
        kotlin.jvm.internal.q.f(r11, "OUI_Bg_Floating_Frost_Dark");
        OUI_Bg_Floating_Frost_Dark = e.b(r11);
        d r12 = h.f15242c;
        kotlin.jvm.internal.q.f(r12, "OUI_Bg_Floating_Fluid_Light");
        OUI_Bg_Floating_Fluid_Light = e.b(r12);
        d r13 = h.f15244d;
        kotlin.jvm.internal.q.f(r13, "OUI_Bg_Floating_Fluid_Dark");
        OUI_Bg_Floating_Fluid_Dark = e.b(r13);
        d[] r14 = h.f15246e;
        kotlin.jvm.internal.q.f(r14, "OUI_Bg_Floating_Light");
        OUI_Bg_Floating_Light = e.e(r14);
        d[] r15 = h.f15248f;
        kotlin.jvm.internal.q.f(r15, "OUI_Bg_Floating_Dark");
        OUI_Bg_Floating_Dark = e.e(r15);
        OUI_Bg_Floating = MaterialToken$OUI_Bg_Floating$1.INSTANCE;
        d r16 = h.f15250g;
        kotlin.jvm.internal.q.f(r16, "OUI_Bg_Floating_OnImage_Frost_Light");
        OUI_Bg_Floating_OnImage_Frost_Light = e.b(r16);
        d r17 = h.f15252h;
        kotlin.jvm.internal.q.f(r17, "OUI_Bg_Floating_OnImage_Frost_Dark");
        OUI_Bg_Floating_OnImage_Frost_Dark = e.b(r17);
        d r18 = h.f15254i;
        kotlin.jvm.internal.q.f(r18, "OUI_Bg_Floating_OnImage_Fluid_Light");
        OUI_Bg_Floating_OnImage_Fluid_Light = e.b(r18);
        d r19 = h.f15256j;
        kotlin.jvm.internal.q.f(r19, "OUI_Bg_Floating_OnImage_Fluid_Dark");
        OUI_Bg_Floating_OnImage_Fluid_Dark = e.b(r19);
        d[] r20 = h.f15258k;
        kotlin.jvm.internal.q.f(r20, "OUI_Bg_Floating_OnImage_Light");
        OUI_Bg_Floating_OnImage_Light = e.e(r20);
        d[] r21 = h.f15260l;
        kotlin.jvm.internal.q.f(r21, "OUI_Bg_Floating_OnImage_Dark");
        OUI_Bg_Floating_OnImage_Dark = e.e(r21);
        OUI_Bg_Floating_OnImage = MaterialToken$OUI_Bg_Floating_OnImage$1.INSTANCE;
        d r22 = h.f15262m;
        kotlin.jvm.internal.q.f(r22, "OUI_Bg_Floating_Fill_Frost_Light");
        OUI_Bg_Floating_Fill_Frost_Light = e.b(r22);
        d r23 = h.f15264n;
        kotlin.jvm.internal.q.f(r23, "OUI_Bg_Floating_Fill_Frost_Dark");
        OUI_Bg_Floating_Fill_Frost_Dark = e.b(r23);
        d r24 = h.f15266o;
        kotlin.jvm.internal.q.f(r24, "OUI_Bg_Floating_Fill_Fluid_Light");
        OUI_Bg_Floating_Fill_Fluid_Light = e.b(r24);
        d r25 = h.f15268p;
        kotlin.jvm.internal.q.f(r25, "OUI_Bg_Floating_Fill_Fluid_Dark");
        OUI_Bg_Floating_Fill_Fluid_Dark = e.b(r25);
        d[] r26 = h.f15270q;
        kotlin.jvm.internal.q.f(r26, "OUI_Bg_Floating_Fill_Light");
        OUI_Bg_Floating_Fill_Light = e.e(r26);
        d[] r27 = h.f15272r;
        kotlin.jvm.internal.q.f(r27, "OUI_Bg_Floating_Fill_Dark");
        OUI_Bg_Floating_Fill_Dark = e.e(r27);
        OUI_Bg_Floating_Fill = MaterialToken$OUI_Bg_Floating_Fill$1.INSTANCE;
        d r28 = h.f15274s;
        kotlin.jvm.internal.q.f(r28, "OUI_Bg_Popup_Frost_Light");
        OUI_Bg_Popup_Frost_Light = e.b(r28);
        d r29 = h.f15276t;
        kotlin.jvm.internal.q.f(r29, "OUI_Bg_Popup_Frost_Dark");
        OUI_Bg_Popup_Frost_Dark = e.b(r29);
        OUI_Bg_Popup_Frost = MaterialToken$OUI_Bg_Popup_Frost$1.INSTANCE;
        d r30 = h.f15278u;
        kotlin.jvm.internal.q.f(r30, "OUI_Bg_Popup_Fluid_Light");
        OUI_Bg_Popup_Fluid_Light = e.b(r30);
        d r31 = h.f15279v;
        kotlin.jvm.internal.q.f(r31, "OUI_Bg_Popup_Fluid_Dark");
        OUI_Bg_Popup_Fluid_Dark = e.b(r31);
        d[] r32 = h.f15280w;
        kotlin.jvm.internal.q.f(r32, "OUI_Bg_Popup_Light");
        OUI_Bg_Popup_Light = e.e(r32);
        d[] r33 = h.f15281x;
        kotlin.jvm.internal.q.f(r33, "OUI_Bg_Popup_Dark");
        OUI_Bg_Popup_Dark = e.e(r33);
        OUI_Bg_Popup = MaterialToken$OUI_Bg_Popup$1.INSTANCE;
        d r34 = h.f15282y;
        kotlin.jvm.internal.q.f(r34, "OUI_Bg_Popup_OnImage_Frost_Light");
        OUI_Bg_Popup_OnImage_Frost_Light = e.b(r34);
        d r35 = h.f15283z;
        kotlin.jvm.internal.q.f(r35, "OUI_Bg_Popup_OnImage_Frost_Dark");
        OUI_Bg_Popup_OnImage_Frost_Dark = e.b(r35);
        d r36 = h.A;
        kotlin.jvm.internal.q.f(r36, "OUI_Bg_Popup_OnImage_Fluid_Light");
        OUI_Bg_Popup_OnImage_Fluid_Light = e.b(r36);
        d r37 = h.B;
        kotlin.jvm.internal.q.f(r37, "OUI_Bg_Popup_OnImage_Fluid_Dark");
        OUI_Bg_Popup_OnImage_Fluid_Dark = e.b(r37);
        d[] r38 = h.C;
        kotlin.jvm.internal.q.f(r38, "OUI_Bg_Popup_OnImage_Light");
        OUI_Bg_Popup_OnImage_Light = e.e(r38);
        d[] r39 = h.D;
        kotlin.jvm.internal.q.f(r39, "OUI_Bg_Popup_OnImage_Dark");
        OUI_Bg_Popup_OnImage_Dark = e.e(r39);
        OUI_Bg_Popup_OnImage = MaterialToken$OUI_Bg_Popup_OnImage$1.INSTANCE;
        d r40 = h.W;
        kotlin.jvm.internal.q.f(r40, "OUI_Bg_Popup_Overlay_Frost_Light");
        OUI_Bg_Popup_Overlay_Frost_Light = e.b(r40);
        d r41 = h.X;
        kotlin.jvm.internal.q.f(r41, "OUI_Bg_Popup_Overlay_Frost_Dark");
        OUI_Bg_Popup_Overlay_Frost_Dark = e.b(r41);
        d r42 = h.Y;
        kotlin.jvm.internal.q.f(r42, "OUI_Bg_Popup_Overlay_Fluid_Light");
        OUI_Bg_Popup_Overlay_Fluid_Light = e.b(r42);
        d r43 = h.Z;
        kotlin.jvm.internal.q.f(r43, "OUI_Bg_Popup_Overlay_Fluid_Dark");
        OUI_Bg_Popup_Overlay_Fluid_Dark = e.b(r43);
        d[] r44 = h.f15239a0;
        kotlin.jvm.internal.q.f(r44, "OUI_Bg_Popup_Overlay_Light");
        OUI_Bg_Popup_Overlay_Light = e.e(r44);
        d[] r45 = h.f15241b0;
        kotlin.jvm.internal.q.f(r45, "OUI_Bg_Popup_Overlay_Dark");
        OUI_Bg_Popup_Overlay_Dark = e.e(r45);
        OUI_Bg_Popup_Overlay = MaterialToken$OUI_Bg_Popup_Overlay$1.INSTANCE;
        d r46 = h.E;
        kotlin.jvm.internal.q.f(r46, "OUI_Bg_Modal_Frost_Light");
        OUI_Bg_Modal_Frost_Light = e.b(r46);
        d r47 = h.F;
        kotlin.jvm.internal.q.f(r47, "OUI_Bg_Modal_Frost_Dark");
        OUI_Bg_Modal_Frost_Dark = e.b(r47);
        d r48 = h.G;
        kotlin.jvm.internal.q.f(r48, "OUI_Bg_Modal_Fluid_Light");
        OUI_Bg_Modal_Fluid_Light = e.b(r48);
        d r49 = h.H;
        kotlin.jvm.internal.q.f(r49, "OUI_Bg_Modal_Fluid_Dark");
        OUI_Bg_Modal_Fluid_Dark = e.b(r49);
        d[] r50 = h.I;
        kotlin.jvm.internal.q.f(r50, "OUI_Bg_Modal_Light");
        OUI_Bg_Modal_Light = e.e(r50);
        d[] r51 = h.f15237J;
        kotlin.jvm.internal.q.f(r51, "OUI_Bg_Modal_Dark");
        OUI_Bg_Modal_Dark = e.e(r51);
        OUI_Bg_Modal = MaterialToken$OUI_Bg_Modal$1.INSTANCE;
        d r52 = h.K;
        kotlin.jvm.internal.q.f(r52, "OUI_Bg_Floating_Overlay_Frost_Light");
        OUI_Bg_Floating_Overlay_Frost_Light = e.b(r52);
        d r53 = h.L;
        kotlin.jvm.internal.q.f(r53, "OUI_Bg_Floating_Overlay_Frost_Dark");
        OUI_Bg_Floating_Overlay_Frost_Dark = e.b(r53);
        d r54 = h.M;
        kotlin.jvm.internal.q.f(r54, "OUI_Bg_Floating_Overlay_Fluid_Light");
        OUI_Bg_Floating_Overlay_Fluid_Light = e.b(r54);
        d r55 = h.N;
        kotlin.jvm.internal.q.f(r55, "OUI_Bg_Floating_Overlay_Fluid_Dark");
        OUI_Bg_Floating_Overlay_Fluid_Dark = e.b(r55);
        d[] r56 = h.O;
        kotlin.jvm.internal.q.f(r56, "OUI_Bg_Floating_Overlay_Light");
        OUI_Bg_Floating_Overlay_Light = e.e(r56);
        d[] r57 = h.P;
        kotlin.jvm.internal.q.f(r57, "OUI_Bg_Floating_Overlay_Dark");
        OUI_Bg_Floating_Overlay_Dark = e.e(r57);
        OUI_Bg_Floating_Overlay = MaterialToken$OUI_Bg_Floating_Overlay$1.INSTANCE;
        d r58 = h.Q;
        kotlin.jvm.internal.q.f(r58, "OUI_Bg_Overlay_Search_Frost_Light");
        OUI_Bg_Overlay_Search_Frost_Light = e.b(r58);
        d r59 = h.R;
        kotlin.jvm.internal.q.f(r59, "OUI_Bg_Overlay_Search_Frost_Dark");
        OUI_Bg_Overlay_Search_Frost_Dark = e.b(r59);
        d r60 = h.S;
        kotlin.jvm.internal.q.f(r60, "OUI_Bg_Overlay_Search_Fluid_Light");
        OUI_Bg_Overlay_Search_Fluid_Light = e.b(r60);
        d r61 = h.T;
        kotlin.jvm.internal.q.f(r61, "OUI_Bg_Overlay_Search_Fluid_Dark");
        OUI_Bg_Overlay_Search_Fluid_Dark = e.b(r61);
        d[] r62 = h.U;
        kotlin.jvm.internal.q.f(r62, "OUI_Bg_Overlay_Search_Light");
        OUI_Bg_Overlay_Search_Light = e.e(r62);
        d[] r63 = h.V;
        kotlin.jvm.internal.q.f(r63, "OUI_Bg_Overlay_Search_Dark");
        OUI_Bg_Overlay_Search_Dark = e.e(r63);
        OUI_Bg_Overlay_Search = MaterialToken$OUI_Bg_Overlay_Search$1.INSTANCE;
        d r64 = h.f15243c0;
        kotlin.jvm.internal.q.f(r64, "OUI_Bg_Floating_Frost_Tinted_Light");
        OUI_Bg_Floating_Frost_Tinted_Light = e.b(r64);
        d r65 = h.f15245d0;
        kotlin.jvm.internal.q.f(r65, "OUI_Bg_Floating_Frost_Tinted_Dark");
        OUI_Bg_Floating_Frost_Tinted_Dark = e.b(r65);
        d r66 = h.f15247e0;
        kotlin.jvm.internal.q.f(r66, "OUI_Bg_Floating_Fluid_Tinted_Light");
        OUI_Bg_Floating_Fluid_Tinted_Light = e.b(r66);
        d r67 = h.f15249f0;
        kotlin.jvm.internal.q.f(r67, "OUI_Bg_Floating_Fluid_Tinted_Dark");
        OUI_Bg_Floating_Fluid_Tinted_Dark = e.b(r67);
        d[] r68 = h.f15251g0;
        kotlin.jvm.internal.q.f(r68, "OUI_Bg_Floating_Tinted_Light");
        OUI_Bg_Floating_Tinted_Light = e.e(r68);
        d[] r69 = h.f15253h0;
        kotlin.jvm.internal.q.f(r69, "OUI_Bg_Floating_Tinted_Dark");
        OUI_Bg_Floating_Tinted_Dark = e.e(r69);
        OUI_Bg_Floating_Tinted = MaterialToken$OUI_Bg_Floating_Tinted$1.INSTANCE;
        d r70 = h.f15255i0;
        kotlin.jvm.internal.q.f(r70, "OUI_Bg_Floating_Frost_Blue_Light");
        OUI_Bg_Floating_Frost_Blue_Light = e.b(r70);
        d r71 = h.f15257j0;
        kotlin.jvm.internal.q.f(r71, "OUI_Bg_Floating_Frost_Blue_Dark");
        OUI_Bg_Floating_Frost_Blue_Dark = e.b(r71);
        d r72 = h.f15259k0;
        kotlin.jvm.internal.q.f(r72, "OUI_Bg_Floating_Fluid_Blue_Light");
        OUI_Bg_Floating_Fluid_Blue_Light = e.b(r72);
        d r73 = h.f15261l0;
        kotlin.jvm.internal.q.f(r73, "OUI_Bg_Floating_Fluid_Blue_Dark");
        OUI_Bg_Floating_Fluid_Blue_Dark = e.b(r73);
        d[] r74 = h.f15263m0;
        kotlin.jvm.internal.q.f(r74, "OUI_Bg_Floating_Blue_Light");
        OUI_Bg_Floating_Blue_Light = e.e(r74);
        d[] r75 = h.f15265n0;
        kotlin.jvm.internal.q.f(r75, "OUI_Bg_Floating_Blue_Dark");
        OUI_Bg_Floating_Blue_Dark = e.e(r75);
        OUI_Bg_Floating_Blue = MaterialToken$OUI_Bg_Floating_Blue$1.INSTANCE;
        d r76 = h.f15267o0;
        kotlin.jvm.internal.q.f(r76, "OUI_Text_Primary_Light");
        OUI_Text_Primary_Light = e.b(r76);
        d r77 = h.f15269p0;
        kotlin.jvm.internal.q.f(r77, "OUI_Text_Primary_Dark");
        OUI_Text_Primary_Dark = e.b(r77);
        OUI_Text_Primary = MaterialToken$OUI_Text_Primary$1.INSTANCE;
        d r78 = h.f15271q0;
        kotlin.jvm.internal.q.f(r78, "OUI_Text_Secondary_Light");
        OUI_Text_Secondary_Light = e.b(r78);
        d r79 = h.f15273r0;
        kotlin.jvm.internal.q.f(r79, "OUI_Text_Secondary_Dark");
        OUI_Text_Secondary_Dark = e.b(r79);
        OUI_Text_Secondary = MaterialToken$OUI_Text_Secondary$1.INSTANCE;
        d r80 = h.f15275s0;
        kotlin.jvm.internal.q.f(r80, "OUI_Text_Tertiary_Light");
        OUI_Text_Tertiary_Light = e.b(r80);
        d r81 = h.f15277t0;
        kotlin.jvm.internal.q.f(r81, "OUI_Text_Tertiary_Dark");
        OUI_Text_Tertiary_Dark = e.b(r81);
        OUI_Text_Tertiary = MaterialToken$OUI_Text_Tertiary$1.INSTANCE;
    }

    private MaterialToken() {
    }

    @JvmStatic
    @Nullable
    public static final b compatibleConfig(@Nullable b r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = OMaterialHelper.g();
        if (r11 >= 1) goto L9;
        return null;
    L9:
        if (r11 < 4) goto L12;
        return r10.a();
    L12:
        if (r11 < 3) goto L15;
        return INSTANCE.toApi3CompatibleConfig(r10);
    L15:
        return INSTANCE.toLegacyCompatibleConfig(r10);
    }

    @JvmStatic
    @Nullable
    public static final b[] compatibleConfigArray(@Nullable b[] r10) {
        Object[] r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        boolean r12 = true;
        if (OMaterialHelper.g() >= 1) goto L8;
        return null;
    L8:
        AnonymousClass1 r13 = new AnonymousClass1(INSTANCE);
        ArrayList r14 = new ArrayList();
        int r15 = r10.length;
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L14;
        b r17 = r13.invoke(r10[r16]);
        if (r17 == null) goto L13;
        r14.add(r17);
    L13:
        r16 = r16 + 1;
        goto L9
    L14:
        Object[] r18 = r14.toArray(new b[0]);
        if (r18 == null) goto L25;
        if (((b[]) r18).length == 0) goto L20;
        r12 = false;
    L20:
        if (r12 == true) goto L23;
        r11 = r18;
    L23:
        return (b[]) r11;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Dark instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Dark$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Fluid_Dark instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Fluid_Dark$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Fluid_Light instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Fluid_Light$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Frost_Dark instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Frost_Dark$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Frost_Light instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Frost_Light$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Light instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Light$annotations() {
    }

    private final ConcurrentHashMap<String, Function1<Boolean, b>> getProviders() {
        return (ConcurrentHashMap) providers$delegate.getValue();
    }

    private final ConcurrentHashMap<String, Function1<Boolean, b[]>> getSetProviders() {
        return (ConcurrentHashMap) setProviders$delegate.getValue();
    }

    private final ConcurrentHashMap<String, b[]> getTokenSets() {
        return (ConcurrentHashMap) tokenSets$delegate.getValue();
    }

    private final ConcurrentHashMap<String, b> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    @JvmStatic
    public static final boolean isApiCompatible(int r10) {
        if (OMaterialHelper.g() < r10) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ boolean isApiCompatible$default(int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = 4;
    L6:
        return isApiCompatible(r10);
    }

    @JvmStatic
    @Nullable
    public static final Function1<Boolean, b> parse(@Nullable String r10) {
        final Function1 r11 = (Function1) q.d(r10, INSTANCE.getProviders());
        if (r11 != null) goto L7;
        return null;
    L7:
        return new C04451(r11);
    }

    @JvmStatic
    @Nullable
    public static final Function1<Boolean, b[]> parseSet(@Nullable String r10) {
        final Function1 r11 = (Function1) q.d(r10, INSTANCE.getSetProviders());
        if (r11 != null) goto L7;
        return null;
    L7:
        return new C04461(r11);
    }

    @JvmStatic
    public static final void register(@NotNull Object r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "customTokenOwner");
        q.e(INSTANCE.getTokens(), r10, b.class, r11);
    }

    public static /* synthetic */ void register$default(Object r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        register(r10, r11);
    }

    @JvmStatic
    public static final void registerProvider(@NotNull Object r11, boolean r12) {
        kotlin.jvm.internal.q.g(r11, "customTokenOwner");
        p r10 = p.f15302a;
        ConcurrentHashMap<String, Function1<Boolean, b>> r13 = INSTANCE.getProviders();
        LinkedHashMap r14 = new LinkedHashMap();
        Field[] r15 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L11
        kotlin.jvm.internal.q.f(r15, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r16 = r15.length;     // Catch: Exception -> L11
        int r17 = 0;
    L4:
        if (r17 >= r16) goto L13;
        Field r18 = r15[r17];     // Catch: Exception -> L11
        r17 = r17 + 1;     // Catch: Exception -> L11
        if (Function1.class.isAssignableFrom(r18.getType()) == false) goto L4;
        r18.setAccessible(true);     // Catch: Exception -> L11
        Object r19 = r18.get(r11);     // Catch: Exception -> L11
        if (y.k(r19, 1) == false) goto L4;
        String r20 = r18.getName();     // Catch: Exception -> L11
        kotlin.jvm.internal.q.f(r20, "field.name");     // Catch: Exception -> L11
        Locale r21 = Locale.ROOT;     // Catch: Exception -> L11
        kotlin.jvm.internal.q.f(r21, "ROOT");     // Catch: Exception -> L11
        String r22 = r20.toLowerCase(r21);     // Catch: Exception -> L11
        kotlin.jvm.internal.q.f(r22, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        kotlin.jvm.internal.q.f(r19, CommonKey.KEY_VALUE);     // Catch: Exception -> L11
        r14.put(r22, r19);     // Catch: Exception -> L11
    L13:
        r10.c(r13, r14, r12);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", kotlin.jvm.internal.q.p("Failed to parse tokens from ", r11.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerProvider$default(Object r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        registerProvider(r10, r11);
    }

    @JvmStatic
    public static final void registerProviderTokens(@NotNull Map<String, ? extends Function1<? super Boolean, b>> r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "customTokens");
        p.f15302a.c(INSTANCE.getProviders(), r10, r11);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        registerProviderTokens(r10, r11);
    }

    @JvmStatic
    public static final void registerSet(@NotNull Object r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "customTokenOwner");
        q.e(INSTANCE.getTokenSets(), r10, b[].class, r11);
    }

    public static /* synthetic */ void registerSet$default(Object r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        registerSet(r10, r11);
    }

    @JvmStatic
    public static final void registerSetProvider(@NotNull Object r11, boolean r12) {
        kotlin.jvm.internal.q.g(r11, "customTokenOwner");
        p r10 = p.f15302a;
        ConcurrentHashMap<String, Function1<Boolean, b[]>> r13 = INSTANCE.getSetProviders();
        LinkedHashMap r14 = new LinkedHashMap();
        Field[] r15 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L11
        kotlin.jvm.internal.q.f(r15, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r16 = r15.length;     // Catch: Exception -> L11
        int r17 = 0;
    L4:
        if (r17 >= r16) goto L13;
        Field r18 = r15[r17];     // Catch: Exception -> L11
        r17 = r17 + 1;     // Catch: Exception -> L11
        if (Function1.class.isAssignableFrom(r18.getType()) == false) goto L4;
        r18.setAccessible(true);     // Catch: Exception -> L11
        Object r19 = r18.get(r11);     // Catch: Exception -> L11
        if (y.k(r19, 1) == false) goto L4;
        String r20 = r18.getName();     // Catch: Exception -> L11
        kotlin.jvm.internal.q.f(r20, "field.name");     // Catch: Exception -> L11
        Locale r21 = Locale.ROOT;     // Catch: Exception -> L11
        kotlin.jvm.internal.q.f(r21, "ROOT");     // Catch: Exception -> L11
        String r22 = r20.toLowerCase(r21);     // Catch: Exception -> L11
        kotlin.jvm.internal.q.f(r22, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        kotlin.jvm.internal.q.f(r19, CommonKey.KEY_VALUE);     // Catch: Exception -> L11
        r14.put(r22, r19);     // Catch: Exception -> L11
    L13:
        r10.c(r13, r14, r12);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", kotlin.jvm.internal.q.p("Failed to parse tokens from ", r11.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerSetProvider$default(Object r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        registerSetProvider(r10, r11);
    }

    @JvmStatic
    public static final void registerSetProviderTokens(@NotNull Map<String, ? extends Function1<? super Boolean, b[]>> r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "customTokens");
        p.f15302a.c(INSTANCE.getSetProviders(), r10, r11);
    }

    public static /* synthetic */ void registerSetProviderTokens$default(Map r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        registerSetProviderTokens(r10, r11);
    }

    @JvmStatic
    public static final void registerTokenSets(@NotNull Map<String, b[]> r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "customTokens");
        q.f(INSTANCE.getTokenSets(), r10, r11);
    }

    public static /* synthetic */ void registerTokenSets$default(Map r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        registerTokenSets(r10, r11);
    }

    @JvmStatic
    public static final void registerTokens(@NotNull Map<String, b> r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "customTokens");
        q.f(INSTANCE.getTokens(), r10, r11);
    }

    public static /* synthetic */ void registerTokens$default(Map r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        registerTokens(r10, r11);
    }

    private final b toApi3CompatibleConfig(b r10) {
        return r10.a();
    }

    private final b toLegacyCompatibleConfig(b r10) {
        b r11 = r10.a();
        com.obric.oui.color.a[] r12 = r11.b();
        if (r12 != null) goto L8;
        ld.a r13 = r11.c();
        if (r13 != null) goto L7;
        r12 = null;
        goto L8
    L7:
        r12 = r13.c();
    L8:
        r11.l(r12);
        r11.m(null);
        j0 r14 = r11.j();
        if (r14 != null) goto L14;
        ld.c r15 = r11.k();
        if (r15 != null) goto L13;
        r14 = null;
        goto L14
    L13:
        r14 = r15.c();
    L14:
        r11.s(r14);
        r11.t(null);
        r11.q(null);
        r11.p(null);
        return r11;
    }

    @Nullable
    public final b[] resolveTokenForBuilder$OUI_standardRelease(@Nullable String r10, boolean r11) {
        p r12 = p.f15302a;
        b[] r13 = (b[]) r12.a(r10, getTokenSets());
        String r14 = "_dark";
        if (r13 != null) goto L9;
        if (r11 == false) goto L6;
        Object r15 = "_light";
    L7:
        r13 = (b[]) r12.a(kotlin.jvm.internal.q.p(r10, r15), getTokenSets());
        goto L9
    L6:
        r15 = "_dark";
    L9:
        if (r13 == null) goto L19;
        ArrayList r16 = new ArrayList(r13.length);
        int r17 = r13.length;
        int r18 = 0;
    L11:
        if (r18 >= r17) goto L13;
        r16.add(r13[r18].a());
        r18 = r18 + 1;
        goto L11
    L13:
        Object[] r19 = r16.toArray(new b[0]);
        if (r19 == null) goto L18;
        return (b[]) r19;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L19:
        Function1 r20 = (Function1) r12.a(r10, getSetProviders());
        if (r20 != null) goto L35;
        b r21 = (b) r12.a(r10, getTokens());
        if (r21 != null) goto L26;
        if (r11 == false) goto L25;
        r14 = "_light";
    L25:
        r21 = (b) r12.a(kotlin.jvm.internal.q.p(r10, r14), getTokens());
    L26:
        if (r21 != null) goto L28;
        Function1 r22 = (Function1) r12.a(r10, getProviders());
        if (r22 != null) goto L34;
        return null;
    L34:
        return new b[]{((b) r22.invoke(Boolean.valueOf(r11))).a()};
    L28:
        return new b[]{r21.a()};
    L35:
        Object[] r23 = (Object[]) r20.invoke(Boolean.valueOf(r11));
        ArrayList r24 = new ArrayList(r23.length);
        int r25 = r23.length;
        int r26 = 0;
    L36:
        if (r26 >= r25) goto L38;
        r24.add(((b) r23[r26]).a());
        r26 = r26 + 1;
        goto L36
    L38:
        Object[] r27 = r24.toArray(new b[0]);
        if (r27 == null) goto L43;
        return (b[]) r27;
    L43:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @JvmStatic
    @Nullable
    public static final b parse(@Nullable String r10, boolean r11) {
        MaterialToken r12 = INSTANCE;
        b r13 = (b) q.d(r10, r12.getTokens());
        if (r13 != null) goto L9;
        if (r11 == false) goto L6;
        String r14 = "_light";
    L7:
        r13 = (b) q.d(kotlin.jvm.internal.q.p(r10, r14), r12.getTokens());
        goto L9
    L6:
        r14 = "_dark";
    L9:
        return compatibleConfig(r13);
    }

    @JvmStatic
    @Nullable
    public static final b[] parseSet(@Nullable String r10, boolean r11) {
        MaterialToken r12 = INSTANCE;
        b[] r13 = (b[]) q.d(r10, r12.getTokenSets());
        if (r13 != null) goto L8;
        if (r11 == false) goto L6;
        String r14 = "_light";
    L7:
        r13 = (b[]) q.d(kotlin.jvm.internal.q.p(r10, r14), r12.getTokenSets());
        goto L8
    L6:
        r14 = "_dark";
    L8:
        if (r13 != null) goto L13;
        b r15 = parse(r10, r11);
        if (r15 == null) goto L13;
        r13 = new b[]{r15};
    L13:
        return compatibleConfigArray(r13);
    }
}
