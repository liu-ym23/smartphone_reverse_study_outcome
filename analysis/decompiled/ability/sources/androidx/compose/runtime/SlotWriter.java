package androidx.compose.runtime;

import D7.q;
import D7.v;
import S7.n;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0001\u0018\u0000 \u0087\u00022\u00020\u0001:\u0002\u0087\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\nJ\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\nJ\u001d\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u000fJ\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0017\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\fJ\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0006¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b-\u0010,J\r\u0010.\u001a\u00020\u001e¢\u0006\u0004\b.\u0010\"J\u0015\u00101\u001a\u00020\u001e2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u001d\u00104\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00062\u0006\u0010#\u001a\u00020/¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u001e¢\u0006\u0004\b6\u0010\"J\u0017\u00107\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b7\u0010,J\u001f\u00107\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b7\u0010'J\u0017\u00108\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b8\u0010,J\u0017\u00109\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b9\u0010,J$\u00109\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0004\b9\u0010:J\u001d\u0010;\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b;\u0010<J)\u00109\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b9\u0010=J\u0017\u0010?\u001a\u0004\u0018\u00010\u00012\u0006\u0010>\u001a\u00020\u0006¢\u0006\u0004\b?\u0010\u000fJ\u000f\u0010@\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b@\u0010AJ\u001f\u0010B\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bB\u0010CJ\u001f\u0010B\u001a\u0004\u0018\u00010\u00012\u0006\u0010D\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bB\u0010EJ<\u0010H\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u001a\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001e0FH\u0086\b¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0006H\u0000¢\u0006\u0004\bJ\u0010\fJ\u0017\u0010M\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0006H\u0000¢\u0006\u0004\bL\u0010\fJ\u0017\u0010O\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0006H\u0000¢\u0006\u0004\bN\u0010\fJ\u0015\u0010P\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\bP\u0010\fJ\u0015\u0010R\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020\u0006¢\u0006\u0004\bR\u0010*J\u0015\u0010S\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\bS\u0010TJ\r\u0010U\u001a\u00020\u001e¢\u0006\u0004\bU\u0010\"J\r\u0010V\u001a\u00020\u001e¢\u0006\u0004\bV\u0010\"J\r\u0010W\u001a\u00020\u001e¢\u0006\u0004\bW\u0010\"J\r\u0010X\u001a\u00020\u001e¢\u0006\u0004\bX\u0010\"J\u0015\u0010X\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\bX\u0010*J\u001f\u0010X\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00062\b\u0010Y\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bX\u0010ZJ\u001f\u0010\\\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00062\b\u0010[\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\\\u0010ZJ)\u0010\\\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00062\b\u0010[\u001a\u0004\u0018\u00010\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\\\u0010]J)\u0010_\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00062\b\u0010[\u001a\u0004\u0018\u00010\u00012\b\u0010^\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b_\u0010]J\u001f\u0010_\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00062\b\u0010^\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b_\u0010ZJ\r\u0010`\u001a\u00020\u0006¢\u0006\u0004\b`\u0010aJ\u0015\u0010b\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bb\u0010*J\u0015\u0010b\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\bb\u0010TJ\r\u0010c\u001a\u00020\u0006¢\u0006\u0004\bc\u0010aJ\r\u0010d\u001a\u00020\b¢\u0006\u0004\bd\u0010eJ\u0015\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010f¢\u0006\u0004\bg\u0010hJ4\u0010i\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00062\u001a\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001e0FH\u0086\b¢\u0006\u0004\bi\u0010jJ@\u0010n\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00062\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0k2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0kH\u0086\b¢\u0006\u0004\bn\u0010oJ1\u0010p\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00062\u001a\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001e0F¢\u0006\u0004\bp\u0010jJ\u0015\u0010r\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020\u0006¢\u0006\u0004\br\u0010*J+\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00180t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010q\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u0000¢\u0006\u0004\bu\u0010vJ-\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00180t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010w\u001a\u00020\b¢\u0006\u0004\bx\u0010yJ\r\u0010z\u001a\u00020\u001e¢\u0006\u0004\bz\u0010\"J+\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00180t2\u0006\u0010q\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b{\u0010|J\u0017\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010}J\u0017\u0010~\u001a\u00020\u001e2\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b~\u0010*J\u0015\u0010\u007f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u007f\u0010\u001cJ\u0012\u0010\u0080\u0001\u001a\u00020/H\u0016¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001d\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0006\u0010\u0014\u001a\u00020\u0006H\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u0006H\u0000¢\u0006\u0005\b\u0086\u0001\u0010}J\u0010\u0010\u0088\u0001\u001a\u00020/¢\u0006\u0006\b\u0088\u0001\u0010\u0081\u0001J\u0011\u0010\u008a\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0005\b\u0089\u0001\u0010\"J\u0011\u0010\u008c\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0005\b\u008b\u0001\u0010\"J\u001d\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0005\b\u008d\u0001\u0010%J'\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0006\u0010\u001b\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J4\u0010X\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00062\b\u0010[\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\b2\b\u0010^\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0005\bX\u0010\u0090\u0001J\u0019\u0010\u0091\u0001\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0091\u0001\u0010\nJ\u0019\u0010\u0092\u0001\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0092\u0001\u0010\nJ\u0011\u0010\u0093\u0001\u001a\u00020\u001eH\u0002¢\u0006\u0005\b\u0093\u0001\u0010\"J\u0019\u0010\u0094\u0001\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0094\u0001\u0010*J#\u0010\u0098\u0001\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00062\u0007\u00109\u001a\u00030\u0095\u0001H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0019\u0010\u0099\u0001\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0099\u0001\u0010\nJ\u0011\u0010\u009a\u0001\u001a\u00020\u001eH\u0002¢\u0006\u0005\b\u009a\u0001\u0010\"J\u0011\u0010\u009b\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u009b\u0001\u0010aJ+\u0010\u009d\u0001\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0007\u0010\u009c\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0019\u0010\u009f\u0001\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u009f\u0001\u0010*J\"\u0010 \u0001\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0011\u0010¢\u0001\u001a\u00020\u001eH\u0002¢\u0006\u0005\b¢\u0001\u0010\"J\u001a\u0010¤\u0001\u001a\u00020\u001e2\u0007\u0010£\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b¤\u0001\u0010*J#\u0010¥\u0001\u001a\u00020\u001e2\u0007\u0010£\u0001\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0006\b¥\u0001\u0010¡\u0001J#\u0010¨\u0001\u001a\u00020\b2\u0007\u0010¦\u0001\u001a\u00020\u00062\u0007\u0010§\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b¨\u0001\u0010\u0016J,\u0010©\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u00062\u0007\u0010§\u0001\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0006\b©\u0001\u0010\u009e\u0001J#\u0010ª\u0001\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0005\bª\u0001\u0010ZJ$\u0010\u00ad\u0001\u001a\u00020\u001e2\u0007\u0010«\u0001\u001a\u00020\u00062\u0007\u0010¬\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\b\u00ad\u0001\u0010¡\u0001JQ\u0010²\u0001\u001a\u00020\b2\u0007\u0010®\u0001\u001a\u00020\u00062\u0007\u0010£\u0001\u001a\u00020\u00062+\u0010±\u0001\u001a&\u0012\u0004\u0012\u00020\u0018\u0012\u0005\u0012\u00030\u0082\u0001\u0018\u00010¯\u0001j\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0005\u0012\u00030\u0082\u0001\u0018\u0001`°\u0001H\u0002¢\u0006\u0006\b²\u0001\u0010³\u0001J-\u0010¶\u0001\u001a\u00020\u001e2\u0007\u0010´\u0001\u001a\u00020\u00062\u0007\u0010µ\u0001\u001a\u00020\u00062\u0007\u0010£\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\b¶\u0001\u0010\u009e\u0001J$\u0010¹\u0001\u001a\u00020\u001e*\b0·\u0001j\u0003`¸\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u0019\u0010»\u0001\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0005\b»\u0001\u0010\fJ\u001a\u0010½\u0001\u001a\u00020\u00062\u0007\u0010¼\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b½\u0001\u0010\fJ\u001d\u0010\u001b\u001a\u00020\u0006*\u00030¾\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u001b\u0010¿\u0001J\u0019\u0010¼\u0001\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0005\b¼\u0001\u0010\fJ \u0010¼\u0001\u001a\u00020\u0006*\u00030¾\u00012\u0007\u0010À\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\b¼\u0001\u0010¿\u0001J\u001e\u0010>\u001a\u00020\u0006*\u00030¾\u00012\u0007\u0010À\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b>\u0010¿\u0001J)\u0010Á\u0001\u001a\u00020\u001e*\u00030¾\u00012\u0007\u0010À\u0001\u001a\u00020\u00062\u0007\u0010¼\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J \u0010Ã\u0001\u001a\u00020\u0006*\u00030¾\u00012\u0007\u0010À\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\bÃ\u0001\u0010¿\u0001J \u0010Ä\u0001\u001a\u00020\u0006*\u00030¾\u00012\u0007\u0010À\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\bÄ\u0001\u0010¿\u0001J\u001d\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060t*\u00030¾\u0001H\u0002¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u0018\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060tH\u0002¢\u0006\u0006\bÇ\u0001\u0010È\u0001J5\u0010Ë\u0001\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0007\u0010®\u0001\u001a\u00020\u00062\u0007\u0010É\u0001\u001a\u00020\u00062\u0007\u0010Ê\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\bË\u0001\u0010Ì\u0001J,\u0010Í\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0007\u0010É\u0001\u001a\u00020\u00062\u0007\u0010Ê\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\"\u0010Ï\u0001\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0007\u0010®\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\bÏ\u0001\u0010<J\u0019\u0010Ð\u0001\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0005\bÐ\u0001\u0010\fR\u001d\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b\u0003\u0010Ñ\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001R\u001a\u0010Ô\u0001\u001a\u00030¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\"\u0010×\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ö\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R+\u0010Û\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00180Ù\u0001j\t\u0012\u0004\u0012\u00020\u0018`Ú\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R=\u0010±\u0001\u001a&\u0012\u0004\u0012\u00020\u0018\u0012\u0005\u0012\u00030\u0082\u0001\u0018\u00010¯\u0001j\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0005\u0012\u00030\u0082\u0001\u0018\u0001`°\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010Ý\u0001R#\u0010à\u0001\u001a\f\u0012\u0005\u0012\u00030ß\u0001\u0018\u00010Þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u0019\u0010â\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u0019\u0010ä\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010ã\u0001R\u0019\u0010å\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010ã\u0001R\u0019\u0010æ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ã\u0001R\u0019\u0010ç\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010ã\u0001R\u0019\u0010è\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010ã\u0001R\u0019\u0010é\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010ã\u0001R\u0019\u0010ê\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010ã\u0001R\u0017\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000b\u0010ã\u0001R\u0018\u0010ì\u0001\u001a\u00030ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u0018\u0010î\u0001\u001a\u00030ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bî\u0001\u0010í\u0001R\u0018\u0010ï\u0001\u001a\u00030ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bï\u0001\u0010í\u0001R+\u0010ñ\u0001\u001a\u0014\u0012\r\u0012\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010ð\u0001\u0018\u00010Þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0001\u0010á\u0001R(\u0010ò\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\bò\u0001\u0010ã\u0001\u001a\u0005\bó\u0001\u0010aR(\u0010ô\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\bô\u0001\u0010ã\u0001\u001a\u0005\bõ\u0001\u0010aR&\u0010\u001b\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\u001b\u0010ã\u0001\u001a\u0005\bö\u0001\u0010aR(\u0010÷\u0001\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\b÷\u0001\u0010ø\u0001\u001a\u0005\bù\u0001\u0010eR\u001c\u0010ú\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R\u0013\u0010ü\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\bü\u0001\u0010eR\u0013\u0010þ\u0001\u001a\u00020\u00068F¢\u0006\u0007\u001a\u0005\bý\u0001\u0010aR\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010eR\u0013\u0010\u0080\u0002\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\bÿ\u0001\u0010eR\u0013\u0010\u0082\u0002\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\b\u0081\u0002\u0010eR\u0016\u0010£\u0001\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0002\u0010aR\u0016\u0010\u0085\u0002\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0002\u0010aR\u0016\u0010Ê\u0001\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0002\u0010a¨\u0006\u0088\u0002"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "Landroidx/compose/runtime/SlotTable;", "table", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/SlotTable;)V", "", "index", "", "isNode", "(I)Z", "nodeCount", "(I)I", "groupKey", "groupObjectKey", "(I)Ljava/lang/Object;", "groupSize", "groupAux", "indexInParent", "indexInCurrentGroup", "group", "indexInGroup", "(II)Z", "node", "Landroidx/compose/runtime/Anchor;", "anchor", "(Landroidx/compose/runtime/Anchor;)Ljava/lang/Object;", "parent", "(Landroidx/compose/runtime/Anchor;)I", "normalClose", "LC7/r;", "close", "(Z)V", "reset", "()V", "value", "update", "(Ljava/lang/Object;)Ljava/lang/Object;", "appendSlot", "(Landroidx/compose/runtime/Anchor;Ljava/lang/Object;)V", "count", "trimTailSlots", "(I)V", "updateAux", "(Ljava/lang/Object;)V", "insertAux", "updateToTableMaps", "", "sourceInformation", "recordGroupSourceInformation", "(Ljava/lang/String;)V", "key", "recordGrouplessCallSourceInformationStart", "(ILjava/lang/String;)V", "recordGrouplessCallSourceInformationEnd", "updateNode", "updateParentNode", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "slotIndexOfGroupSlotIndex", "(II)I", "(IILjava/lang/Object;)Ljava/lang/Object;", "slotIndex", "clear", "skip", "()Ljava/lang/Object;", "slot", "(Landroidx/compose/runtime/Anchor;I)Ljava/lang/Object;", "groupIndex", "(II)Ljava/lang/Object;", "Lkotlin/Function2;", "block", "forEachTailSlot", "(IILS7/n;)V", "slotsStartIndex$runtime", "slotsStartIndex", "slotsEndIndex$runtime", "slotsEndIndex", "slotsEndAllIndex$runtime", "slotsEndAllIndex", "groupSlotIndex", "amount", "advanceBy", "seek", "(Landroidx/compose/runtime/Anchor;)V", "skipToGroupEnd", "beginInsert", "endInsert", "startGroup", "dataKey", "(ILjava/lang/Object;)V", "objectKey", "startNode", "(ILjava/lang/Object;Ljava/lang/Object;)V", "aux", "startData", "endGroup", "()I", "ensureStarted", "skipGroup", "removeGroup", "()Z", "", "groupSlots", "()Ljava/util/Iterator;", "forAllData", "(ILS7/n;)V", "Lkotlin/Function1;", "enter", "exit", "traverseGroupAndChildren", "(ILS7/k;LS7/k;)V", "forAllDataInRememberOrder", TypedValues.CycleType.S_WAVE_OFFSET, "moveGroup", "writer", "", "moveTo", "(Landroidx/compose/runtime/Anchor;ILandroidx/compose/runtime/SlotWriter;)Ljava/util/List;", "removeSourceGroup", "moveFrom", "(Landroidx/compose/runtime/SlotTable;IZ)Ljava/util/List;", "bashCurrentGroup", "moveIntoGroupFrom", "(ILandroidx/compose/runtime/SlotTable;I)Ljava/util/List;", "(I)Landroidx/compose/runtime/Anchor;", "markGroup", "anchorIndex", "toString", "()Ljava/lang/String;", "Landroidx/compose/runtime/GroupSourceInformation;", "sourceInformationOf$runtime", "(I)Landroidx/compose/runtime/GroupSourceInformation;", "sourceInformationOf", "tryAnchor$runtime", "tryAnchor", "toDebugString", "verifyDataAnchors$runtime", "verifyDataAnchors", "verifyParentAnchors$runtime", "verifyParentAnchors", "rawUpdate", "groupSourceInformationFor", "(ILjava/lang/String;)Landroidx/compose/runtime/GroupSourceInformation;", "(ILjava/lang/Object;ZLjava/lang/Object;)V", "containsGroupMark", "containsAnyGroupMarks", "recalculateMarks", "updateContainsMark", "Landroidx/compose/runtime/PrioritySet;", "updateContainsMarkNow-XpTMRCE", "(ILandroidx/collection/MutableIntList;)V", "updateContainsMarkNow", "childContainsAnyMarks", "saveCurrentGroupEnd", "restoreCurrentGroupEnd", "firstChild", "fixParentAnchorsFor", "(III)V", "moveGroupGapTo", "moveSlotGapTo", "(II)V", "clearSlotGap", "size", "insertGroups", "insertSlots", "start", "len", "removeGroups", "removeSlots", "updateNodeOfGroup", "previousGapStart", "newGapStart", "updateAnchors", "gapStart", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sourceInformationMap", "removeAnchors", "(IILjava/util/HashMap;)Z", "originalLocation", "newLocation", "moveAnchors", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "groupAsString", "(Ljava/lang/StringBuilder;I)V", "groupIndexToAddress", "dataIndex", "dataIndexToDataAddress", "", "([II)I", "address", "updateDataIndex", "([III)V", "nodeIndex", "auxIndex", "dataIndexes", "([I)Ljava/util/List;", "keys", "()Ljava/util/List;", "gapLen", "capacity", "dataIndexToDataAnchor", "(IIII)I", "dataAnchorToDataIndex", "(III)I", "parentIndexToAnchor", "parentAnchorToIndex", "Landroidx/compose/runtime/SlotTable;", "getTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "groups", "[I", "", "slots", "[Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "anchors", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "groupGapStart", "I", "groupGapLen", "currentSlot", "currentSlotEnd", "slotsGapStart", "slotsGapLen", "slotsGapOwner", "insertCount", "Landroidx/compose/runtime/IntStack;", "startStack", "Landroidx/compose/runtime/IntStack;", "endStack", "nodeCountStack", "Landroidx/collection/MutableObjectList;", "deferredSlotWrites", "currentGroup", "getCurrentGroup", "currentGroupEnd", "getCurrentGroupEnd", "getParent", "closed", "Z", "getClosed", "pendingRecalculateMarks", "Landroidx/collection/MutableIntList;", "isGroupEnd", "getSlotsSize", "slotsSize", "getCollectingSourceInformation", "collectingSourceInformation", "getCollectingCalledInformation", "collectingCalledInformation", "getSize$runtime", "getCurrentGroupSlotIndex", "currentGroupSlotIndex", "getCapacity", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotWriter {
    private ArrayList<Anchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private MutableIntObjectMap<MutableObjectList<Object>> deferredSlotWrites;
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private MutableIntList pendingRecalculateMarks;
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final SlotTable table;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final IntStack startStack = new IntStack();
    private final IntStack endStack = new IntStack();
    private final IntStack nodeCountStack = new IntStack();
    private int parent = -1;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", AppAgent.CONSTRUCT, "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final List<Anchor> moveGroup(SlotWriter fromWriter, int fromIndex, SlotWriter toWriter, boolean updateFromCursor, boolean updateToCursor, boolean removeSourceGroup) {
            boolean zRemoveGroups;
            EmptyList emptyList;
            int iGroupSize = fromWriter.groupSize(fromIndex);
            int i = fromIndex + iGroupSize;
            int iDataIndex = fromWriter.dataIndex(fromIndex);
            int iDataIndex2 = fromWriter.dataIndex(i);
            int i6 = iDataIndex2 - iDataIndex;
            boolean zContainsAnyGroupMarks = fromWriter.containsAnyGroupMarks(fromIndex);
            toWriter.insertGroups(iGroupSize);
            toWriter.insertSlots(i6, toWriter.getCurrentGroup());
            if (fromWriter.groupGapStart < i) {
                fromWriter.moveGroupGapTo(i);
            }
            if (fromWriter.slotsGapStart < iDataIndex2) {
                fromWriter.moveSlotGapTo(iDataIndex2, i);
            }
            int[] iArr = toWriter.groups;
            int currentGroup = toWriter.getCurrentGroup();
            int i10 = currentGroup * 5;
            q.R(i10, fromIndex * 5, fromWriter.groups, iArr, i * 5);
            Object[] objArr = toWriter.slots;
            int i11 = toWriter.currentSlot;
            System.arraycopy(fromWriter.slots, iDataIndex, objArr, i11, i6);
            int parent = toWriter.getParent();
            iArr[i10 + 2] = parent;
            int i12 = currentGroup - fromIndex;
            int i13 = currentGroup + iGroupSize;
            int iDataIndex3 = i11 - toWriter.dataIndex(iArr, currentGroup);
            int i14 = toWriter.slotsGapOwner;
            int i15 = toWriter.slotsGapLen;
            int length = objArr.length;
            int i16 = i14;
            int i17 = currentGroup;
            while (true) {
                zRemoveGroups = false;
                if (i17 >= i13) {
                    break;
                }
                if (i17 != currentGroup) {
                    int i18 = (i17 * 5) + 2;
                    iArr[i18] = iArr[i18] + i12;
                }
                int[] iArr2 = iArr;
                int i19 = currentGroup;
                iArr2[(i17 * 5) + 4] = toWriter.dataIndexToDataAnchor(toWriter.dataIndex(iArr, i17) + iDataIndex3, i16 >= i17 ? toWriter.slotsGapStart : 0, i15, length);
                if (i17 == i16) {
                    i16++;
                }
                i17++;
                currentGroup = i19;
                iArr = iArr2;
            }
            int[] iArr3 = iArr;
            toWriter.slotsGapOwner = i16;
            int iLocationOf = SlotTableKt.locationOf(fromWriter.anchors, fromIndex, fromWriter.getSize$runtime());
            int iLocationOf2 = SlotTableKt.locationOf(fromWriter.anchors, i, fromWriter.getSize$runtime());
            if (iLocationOf < iLocationOf2) {
                ArrayList arrayList = fromWriter.anchors;
                ArrayList arrayList2 = new ArrayList(iLocationOf2 - iLocationOf);
                for (int i20 = iLocationOf; i20 < iLocationOf2; i20++) {
                    Anchor anchor = (Anchor) arrayList.get(i20);
                    anchor.setLocation$runtime(anchor.getLocation() + i12);
                    arrayList2.add(anchor);
                }
                toWriter.anchors.addAll(SlotTableKt.locationOf(toWriter.anchors, toWriter.getCurrentGroup(), toWriter.getSize$runtime()), arrayList2);
                arrayList.subList(iLocationOf, iLocationOf2).clear();
                emptyList = arrayList2;
            } else {
                emptyList = EmptyList.f4893a;
            }
            EmptyList emptyList2 = emptyList;
            if (!emptyList2.isEmpty()) {
                HashMap map = fromWriter.sourceInformationMap;
                HashMap map2 = toWriter.sourceInformationMap;
                if (map != null && map2 != null) {
                    int size = emptyList2.size();
                    for (int i21 = 0; i21 < size; i21++) {
                        Anchor anchor2 = (Anchor) emptyList.get(i21);
                        GroupSourceInformation groupSourceInformation = (GroupSourceInformation) map.get(anchor2);
                        if (groupSourceInformation != null) {
                            map.remove(anchor2);
                            map2.put(anchor2, groupSourceInformation);
                        }
                    }
                }
            }
            int parent2 = toWriter.getParent();
            GroupSourceInformation groupSourceInformationSourceInformationOf$runtime = toWriter.sourceInformationOf$runtime(parent);
            if (groupSourceInformationSourceInformationOf$runtime != null) {
                int iGroupSize2 = parent2 + 1;
                int currentGroup2 = toWriter.getCurrentGroup();
                int i22 = -1;
                while (iGroupSize2 < currentGroup2) {
                    i22 = iGroupSize2;
                    iGroupSize2 = SlotTableKt.groupSize(toWriter.groups, iGroupSize2) + iGroupSize2;
                }
                groupSourceInformationSourceInformationOf$runtime.addGroupAfter(toWriter, i22, currentGroup2);
            }
            int iParent = fromWriter.parent(fromIndex);
            if (removeSourceGroup) {
                if (updateFromCursor) {
                    boolean z10 = iParent >= 0;
                    if (z10) {
                        fromWriter.startGroup();
                        fromWriter.advanceBy(iParent - fromWriter.getCurrentGroup());
                        fromWriter.startGroup();
                    }
                    fromWriter.advanceBy(fromIndex - fromWriter.getCurrentGroup());
                    boolean zRemoveGroup = fromWriter.removeGroup();
                    if (z10) {
                        fromWriter.skipToGroupEnd();
                        fromWriter.endGroup();
                        fromWriter.skipToGroupEnd();
                        fromWriter.endGroup();
                    }
                    zRemoveGroups = zRemoveGroup;
                } else {
                    zRemoveGroups = fromWriter.removeGroups(fromIndex, iGroupSize);
                    fromWriter.removeSlots(iDataIndex, i6, fromIndex - 1);
                }
            }
            if (zRemoveGroups) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }
            int i23 = toWriter.nodeCount;
            int i24 = iArr3[i10 + 1];
            toWriter.nodeCount = i23 + ((1073741824 & i24) == 0 ? i24 & RectListKt.Lower26Bits : 1);
            if (updateToCursor) {
                toWriter.currentGroup = i13;
                toWriter.currentSlot = i11 + i6;
            }
            if (zContainsAnyGroupMarks) {
                toWriter.updateContainsMark(parent);
            }
            return emptyList;
        }

        public static /* synthetic */ List moveGroup$default(Companion companion, SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z10, boolean z11, boolean z12, int i6, Object obj) {
            if ((i6 & 32) != 0) {
                z12 = true;
            }
            return companion.moveGroup(slotWriter, i, slotWriter2, z10, z11, z12);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"androidx/compose/runtime/SlotWriter$groupSlots$1", "", "", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", "next", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.SlotWriter$groupSlots$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Object>, T7.a {
        final /* synthetic */ int $end;
        private int current;
        final /* synthetic */ SlotWriter this$0;

        public AnonymousClass1(int i, int i6, SlotWriter slotWriter) {
            this.$end = i6;
            this.this$0 = slotWriter;
            this.current = i;
        }

        public final int getCurrent() {
            return this.current;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current < this.$end;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                return null;
            }
            Object[] objArr = this.this$0.slots;
            SlotWriter slotWriter = this.this$0;
            int i = this.current;
            this.current = i + 1;
            return objArr[slotWriter.dataIndexToDataAddress(i)];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setCurrent(int i) {
            this.current = i;
        }
    }

    public SlotWriter(SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        this.slots = slotTable.getSlots();
        this.anchors = slotTable.getAnchors$runtime();
        this.sourceInformationMap = slotTable.getSourceInformationMap$runtime();
        this.calledByMap = slotTable.getCalledByMap$runtime();
        this.groupGapStart = slotTable.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - slotTable.getGroupsSize();
        this.slotsGapStart = slotTable.getSlotsSize();
        this.slotsGapLen = this.slots.length - slotTable.getSlotsSize();
        this.slotsGapOwner = slotTable.getGroupsSize();
        this.currentGroupEnd = slotTable.getGroupsSize();
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i);
    }

    private final int auxIndex(int[] iArr, int i) {
        return Integer.bitCount(iArr[(i * 5) + 1] >> 29) + dataIndex(iArr, i);
    }

    private final boolean childContainsAnyMarks(int group) {
        int iGroupSize = group + 1;
        int iGroupSize2 = groupSize(group) + group;
        while (iGroupSize < iGroupSize2) {
            if ((this.groups[(groupIndexToAddress(iGroupSize) * 5) + 1] & 201326592) != 0) {
                return true;
            }
            iGroupSize += groupSize(iGroupSize);
        }
        return false;
    }

    private final void clearSlotGap() {
        int i = this.slotsGapStart;
        q.f0(null, i, this.slots, this.slotsGapLen + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int group) {
        return group >= 0 && (this.groups[(groupIndexToAddress(group) * 5) + 1] & 201326592) != 0;
    }

    private final boolean containsGroupMark(int group) {
        return group >= 0 && (this.groups[(groupIndexToAddress(group) * 5) + 1] & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0;
    }

    private final int dataAnchorToDataIndex(int anchor, int gapLen, int capacity) {
        return anchor < 0 ? (capacity - gapLen) + anchor + 1 : anchor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int index) {
        return dataIndex(this.groups, groupIndexToAddress(index));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAddress(int dataIndex) {
        return (this.slotsGapLen * (dataIndex < this.slotsGapStart ? 0 : 1)) + dataIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int index, int gapStart, int gapLen, int capacity) {
        return index > gapStart ? -(((capacity - gapLen) - index) + 1) : index;
    }

    private final List<Integer> dataIndexes(int[] iArr) {
        List listDataAnchors$default = SlotTableKt.dataAnchors$default(this.groups, 0, 1, null);
        ArrayList arrayListQ0 = v.Q0(v.X0(AbstractC1451a.X(this.groupGapStart + this.groupGapLen, iArr.length / 5), listDataAnchors$default), v.X0(AbstractC1451a.X(0, this.groupGapStart), listDataAnchors$default));
        ArrayList arrayList = new ArrayList(arrayListQ0.size());
        int size = arrayListQ0.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(dataAnchorToDataIndex(((Number) arrayListQ0.get(i)).intValue(), this.slotsGapLen, this.slots.length)));
        }
        return arrayList;
    }

    private final void fixParentAnchorsFor(int parent, int endGroup, int firstChild) {
        int iParentIndexToAnchor = parentIndexToAnchor(parent, this.groupGapStart);
        while (firstChild < endGroup) {
            this.groups[(groupIndexToAddress(firstChild) * 5) + 2] = iParentIndexToAnchor;
            int iGroupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(firstChild)) + firstChild;
            fixParentAnchorsFor(firstChild, iGroupSize, firstChild + 1);
            firstChild = iGroupSize;
        }
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    private final int getCurrentGroupSlotIndex() {
        return groupSlotIndex(this.parent);
    }

    private final void groupAsString(StringBuilder sb, int i) {
        int iGroupIndexToAddress = groupIndexToAddress(i);
        sb.append("Group(");
        if (i < 10) {
            sb.append(' ');
        }
        if (i < 100) {
            sb.append(' ');
        }
        if (i < 1000) {
            sb.append(' ');
        }
        sb.append(i);
        if (iGroupIndexToAddress != i) {
            sb.append("(");
            sb.append(iGroupIndexToAddress);
            sb.append(")");
        }
        sb.append('#');
        sb.append(SlotTableKt.groupSize(this.groups, iGroupIndexToAddress));
        sb.append('^');
        int i6 = iGroupIndexToAddress * 5;
        int i10 = i6 + 2;
        sb.append(parentAnchorToIndex(this.groups[i10]));
        sb.append(": key=");
        sb.append(this.groups[i6]);
        sb.append(", nodes=");
        int i11 = i6 + 1;
        sb.append(this.groups[i11] & RectListKt.Lower26Bits);
        sb.append(", dataAnchor=");
        sb.append(this.groups[i6 + 4]);
        sb.append(", parentAnchor=");
        sb.append(this.groups[i10]);
        if ((this.groups[i11] & BasicMeasure.EXACTLY) != 0) {
            sb.append(", node=" + SlotTableKt.summarize(String.valueOf(this.slots[dataIndexToDataAddress(nodeIndex(this.groups, iGroupIndexToAddress))]), 10));
        }
        int iSlotIndex = slotIndex(this.groups, iGroupIndexToAddress);
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1));
        if (iDataIndex > iSlotIndex) {
            sb.append(", [");
            for (int i12 = iSlotIndex; i12 < iDataIndex; i12++) {
                if (i12 != iSlotIndex) {
                    sb.append(", ");
                }
                sb.append(SlotTableKt.summarize(String.valueOf(this.slots[dataIndexToDataAddress(i12)]), 10));
            }
            sb.append(']');
        }
        sb.append(")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int groupIndexToAddress(int index) {
        return (this.groupGapLen * (index < this.groupGapStart ? 0 : 1)) + index;
    }

    private final GroupSourceInformation groupSourceInformationFor(int parent, String sourceInformation) {
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        if (map == null) {
            return null;
        }
        Anchor anchor = anchor(parent);
        GroupSourceInformation groupSourceInformation = map.get(anchor);
        if (groupSourceInformation == null) {
            groupSourceInformation = new GroupSourceInformation(0, sourceInformation, 0);
            if (sourceInformation == null) {
                int iGroupSize = parent + 1;
                int i = this.currentGroup;
                while (iGroupSize < i) {
                    groupSourceInformation.reportGroup(this, iGroupSize);
                    iGroupSize += SlotTableKt.groupSize(this.groups, iGroupSize);
                }
            }
            map.put(anchor, groupSourceInformation);
        }
        return groupSourceInformation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertGroups(int size) {
        if (size > 0) {
            int i = this.currentGroup;
            moveGroupGapTo(i);
            int i6 = this.groupGapStart;
            int i10 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i11 = length - i10;
            if (i10 < size) {
                int iMax = Math.max(Math.max(length * 2, i11 + size), 32);
                int[] iArr2 = new int[iMax * 5];
                int i12 = iMax - i11;
                q.R(0, 0, iArr, iArr2, i6 * 5);
                q.R((i6 + i12) * 5, (i10 + i6) * 5, iArr, iArr2, length * 5);
                this.groups = iArr2;
                i10 = i12;
            }
            int i13 = this.currentGroupEnd;
            if (i13 >= i6) {
                this.currentGroupEnd = i13 + size;
            }
            int i14 = i6 + size;
            this.groupGapStart = i14;
            this.groupGapLen = i10 - size;
            int iDataIndexToDataAnchor = dataIndexToDataAnchor(i11 > 0 ? dataIndex(i + size) : 0, this.slotsGapOwner >= i6 ? this.slotsGapStart : 0, this.slotsGapLen, this.slots.length);
            for (int i15 = i6; i15 < i14; i15++) {
                this.groups[(i15 * 5) + 4] = iDataIndexToDataAnchor;
            }
            int i16 = this.slotsGapOwner;
            if (i16 >= i6) {
                this.slotsGapOwner = i16 + size;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertSlots(int size, int group) {
        if (size > 0) {
            moveSlotGapTo(this.currentSlot, group);
            int i = this.slotsGapStart;
            int i6 = this.slotsGapLen;
            if (i6 < size) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i10 = length - i6;
                int iMax = Math.max(Math.max(length * 2, i10 + size), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i11 = 0; i11 < iMax; i11++) {
                    objArr2[i11] = null;
                }
                int i12 = iMax - i10;
                int i13 = i6 + i;
                System.arraycopy(objArr, 0, objArr2, 0, i);
                System.arraycopy(objArr, i13, objArr2, i + i12, length - i13);
                this.slots = objArr2;
                i6 = i12;
            }
            int i14 = this.currentSlotEnd;
            if (i14 >= i) {
                this.currentSlotEnd = i14 + size;
            }
            this.slotsGapStart = i + size;
            this.slotsGapLen = i6 - size;
        }
    }

    private final List<Integer> keys() {
        List listKeys$default = SlotTableKt.keys$default(this.groups, 0, 1, null);
        ArrayList arrayList = new ArrayList(listKeys$default.size());
        int size = listKeys$default.size();
        for (int i = 0; i < size; i++) {
            Object obj = listKeys$default.get(i);
            ((Number) obj).intValue();
            int i6 = this.groupGapStart;
            if (i < i6 || i >= i6 + this.groupGapLen) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = slotWriter.parent;
        }
        slotWriter.markGroup(i);
    }

    private final void moveAnchors(int originalLocation, int newLocation, int size) {
        Anchor anchor;
        int iAnchorIndex;
        int i = size + originalLocation;
        int size$runtime = getSize$runtime();
        int iLocationOf = SlotTableKt.locationOf(this.anchors, originalLocation, size$runtime);
        ArrayList arrayList = new ArrayList();
        if (iLocationOf >= 0) {
            while (iLocationOf < this.anchors.size() && (iAnchorIndex = anchorIndex((anchor = this.anchors.get(iLocationOf)))) >= originalLocation && iAnchorIndex < i) {
                arrayList.add(anchor);
                this.anchors.remove(iLocationOf);
            }
        }
        int i6 = newLocation - originalLocation;
        int size2 = arrayList.size();
        for (int i10 = 0; i10 < size2; i10++) {
            Anchor anchor2 = (Anchor) arrayList.get(i10);
            int iAnchorIndex2 = anchorIndex(anchor2) + i6;
            if (iAnchorIndex2 >= this.groupGapStart) {
                anchor2.setLocation$runtime(-(size$runtime - iAnchorIndex2));
            } else {
                anchor2.setLocation$runtime(iAnchorIndex2);
            }
            this.anchors.add(SlotTableKt.locationOf(this.anchors, iAnchorIndex2, size$runtime), anchor2);
        }
    }

    public static /* synthetic */ List moveFrom$default(SlotWriter slotWriter, SlotTable slotTable, int i, boolean z10, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z10 = true;
        }
        return slotWriter.moveFrom(slotTable, i, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveGroupGapTo(int index) {
        int i = this.groupGapLen;
        int i6 = this.groupGapStart;
        if (i6 != index) {
            if (!this.anchors.isEmpty()) {
                updateAnchors(i6, index);
            }
            if (i > 0) {
                int[] iArr = this.groups;
                int i10 = index * 5;
                int i11 = i * 5;
                int i12 = i6 * 5;
                if (index < i6) {
                    q.R(i11 + i10, i10, iArr, iArr, i12);
                } else {
                    q.R(i12, i12 + i11, iArr, iArr, i10 + i11);
                }
            }
            if (index < i6) {
                i6 = index + i;
            }
            int capacity = getCapacity();
            if (i6 >= capacity) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            while (i6 < capacity) {
                int i13 = (i6 * 5) + 2;
                int i14 = this.groups[i13];
                int iParentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(i14), index);
                if (iParentIndexToAnchor != i14) {
                    this.groups[i13] = iParentIndexToAnchor;
                }
                i6++;
                if (i6 == index) {
                    i6 += i;
                }
            }
        }
        this.groupGapStart = index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveSlotGapTo(int index, int group) {
        int i = this.slotsGapLen;
        int i6 = this.slotsGapStart;
        int i10 = this.slotsGapOwner;
        if (i6 != index) {
            Object[] objArr = this.slots;
            if (index < i6) {
                System.arraycopy(objArr, index, objArr, index + i, i6 - index);
            } else {
                int i11 = i6 + i;
                System.arraycopy(objArr, i11, objArr, i6, (index + i) - i11);
            }
        }
        int iMin = Math.min(group + 1, getSize$runtime());
        if (i10 != iMin) {
            int length = this.slots.length - i;
            if (iMin < i10) {
                int iGroupIndexToAddress = groupIndexToAddress(iMin);
                int iGroupIndexToAddress2 = groupIndexToAddress(i10);
                int i12 = this.groupGapStart;
                while (iGroupIndexToAddress < iGroupIndexToAddress2) {
                    int i13 = (iGroupIndexToAddress * 5) + 4;
                    int i14 = this.groups[i13];
                    if (!(i14 >= 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
                    }
                    this.groups[i13] = -((length - i14) + 1);
                    iGroupIndexToAddress++;
                    if (iGroupIndexToAddress == i12) {
                        iGroupIndexToAddress += this.groupGapLen;
                    }
                }
            } else {
                int iGroupIndexToAddress3 = groupIndexToAddress(i10);
                int iGroupIndexToAddress4 = groupIndexToAddress(iMin);
                while (iGroupIndexToAddress3 < iGroupIndexToAddress4) {
                    int i15 = (iGroupIndexToAddress3 * 5) + 4;
                    int i16 = this.groups[i15];
                    if (!(i16 < 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
                    }
                    this.groups[i15] = i16 + length + 1;
                    iGroupIndexToAddress3++;
                    if (iGroupIndexToAddress3 == this.groupGapStart) {
                        iGroupIndexToAddress3 += this.groupGapLen;
                    }
                }
            }
            this.slotsGapOwner = iMin;
        }
        this.slotsGapStart = index;
    }

    private final int nodeIndex(int[] iArr, int i) {
        return dataIndex(iArr, i);
    }

    private final int parentAnchorToIndex(int index) {
        return index > -2 ? index : (getSize$runtime() + index) - (-2);
    }

    private final int parentIndexToAnchor(int index, int gapStart) {
        return index < gapStart ? index : -((getSize$runtime() - index) + 2);
    }

    private final Object rawUpdate(Object value) {
        Object objSkip = skip();
        set(value);
        return objSkip;
    }

    private final void recalculateMarks() {
        MutableIntList mutableIntList = this.pendingRecalculateMarks;
        if (mutableIntList != null) {
            while (PrioritySet.m3441isNotEmptyimpl(mutableIntList)) {
                m3455updateContainsMarkNowXpTMRCE(PrioritySet.m3443takeMaximpl(mutableIntList), mutableIntList);
            }
        }
    }

    private final boolean removeAnchors(int gapStart, int size, HashMap<Anchor, GroupSourceInformation> sourceInformationMap) {
        int i = size + gapStart;
        int iLocationOf = SlotTableKt.locationOf(this.anchors, i, getCapacity() - this.groupGapLen);
        if (iLocationOf >= this.anchors.size()) {
            iLocationOf--;
        }
        int i6 = iLocationOf + 1;
        int i10 = 0;
        while (iLocationOf >= 0) {
            Anchor anchor = this.anchors.get(iLocationOf);
            int iAnchorIndex = anchorIndex(anchor);
            if (iAnchorIndex < gapStart) {
                break;
            }
            if (iAnchorIndex < i) {
                anchor.setLocation$runtime(Integer.MIN_VALUE);
                if (sourceInformationMap != null) {
                    sourceInformationMap.remove(anchor);
                }
                if (i10 == 0) {
                    i10 = iLocationOf + 1;
                }
                i6 = iLocationOf;
            }
            iLocationOf--;
        }
        boolean z10 = i6 < i10;
        if (z10) {
            this.anchors.subList(i6, i10).clear();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeGroups(int start, int len) {
        if (len > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(start);
            zRemoveAnchors = arrayList.isEmpty() ? false : removeAnchors(start, len, this.sourceInformationMap);
            this.groupGapStart = start;
            this.groupGapLen += len;
            int i = this.slotsGapOwner;
            if (i > start) {
                this.slotsGapOwner = Math.max(start, i - len);
            }
            int i6 = this.currentGroupEnd;
            if (i6 >= this.groupGapStart) {
                this.currentGroupEnd = i6 - len;
            }
            int i10 = this.parent;
            if (containsGroupMark(i10)) {
                updateContainsMark(i10);
            }
        }
        return zRemoveAnchors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSlots(int start, int len, int group) {
        if (len > 0) {
            int i = this.slotsGapLen;
            int i6 = start + len;
            moveSlotGapTo(i6, group);
            this.slotsGapStart = start;
            this.slotsGapLen = i + len;
            q.f0(null, start, this.slots, i6);
            int i10 = this.currentSlotEnd;
            if (i10 >= start) {
                this.currentSlotEnd = i10 - len;
            }
        }
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int slotIndex(int[] iArr, int i) {
        return i >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.slotAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    private final void updateAnchors(int previousGapStart, int newGapStart) {
        Anchor anchor;
        int location$runtime;
        Anchor anchor2;
        int location$runtime2;
        int i;
        int capacity = getCapacity() - this.groupGapLen;
        if (previousGapStart >= newGapStart) {
            for (int iLocationOf = SlotTableKt.locationOf(this.anchors, newGapStart, capacity); iLocationOf < this.anchors.size() && (location$runtime = (anchor = this.anchors.get(iLocationOf)).getLocation()) >= 0; iLocationOf++) {
                anchor.setLocation$runtime(-(capacity - location$runtime));
            }
            return;
        }
        for (int iLocationOf2 = SlotTableKt.locationOf(this.anchors, previousGapStart, capacity); iLocationOf2 < this.anchors.size() && (location$runtime2 = (anchor2 = this.anchors.get(iLocationOf2)).getLocation()) < 0 && (i = location$runtime2 + capacity) < newGapStart; iLocationOf2++) {
            anchor2.setLocation$runtime(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContainsMark(int group) {
        if (group >= 0) {
            MutableIntList mutableIntListM3436constructorimpl$default = this.pendingRecalculateMarks;
            if (mutableIntListM3436constructorimpl$default == null) {
                mutableIntListM3436constructorimpl$default = PrioritySet.m3436constructorimpl$default(null, 1, null);
                this.pendingRecalculateMarks = mutableIntListM3436constructorimpl$default;
            }
            PrioritySet.m3433addimpl(mutableIntListM3436constructorimpl$default, group);
        }
    }

    /* renamed from: updateContainsMarkNow-XpTMRCE, reason: not valid java name */
    private final void m3455updateContainsMarkNowXpTMRCE(int group, MutableIntList set) {
        int iGroupIndexToAddress = groupIndexToAddress(group);
        boolean zChildContainsAnyMarks = childContainsAnyMarks(group);
        int[] iArr = this.groups;
        if (((iArr[(iGroupIndexToAddress * 5) + 1] & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0) != zChildContainsAnyMarks) {
            SlotTableKt.updateContainsMark(iArr, iGroupIndexToAddress, zChildContainsAnyMarks);
            int iParent = parent(group);
            if (iParent >= 0) {
                PrioritySet.m3433addimpl(set, iParent);
            }
        }
    }

    private final void updateDataIndex(int[] iArr, int i, int i6) {
        iArr[(i * 5) + 4] = dataIndexToDataAnchor(i6, this.slotsGapStart, this.slotsGapLen, this.slots.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateNodeOfGroup(int r5, java.lang.Object r6) {
        /*
            r4 = this;
            int r0 = r4.groupIndexToAddress(r5)
            int[] r1 = r4.groups
            int r2 = r1.length
            if (r0 >= r2) goto L15
            int r2 = r0 * 5
            r3 = 1
            int r2 = r2 + r3
            r1 = r1[r2]
            r2 = 1073741824(0x40000000, float:2.0)
            r1 = r1 & r2
            if (r1 == 0) goto L15
            goto L16
        L15:
            r3 = 0
        L16:
            if (r3 != 0) goto L2e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Updating the node of a group at "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = " that was not created with as a node group"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            androidx.compose.runtime.ComposerKt.composeImmediateRuntimeError(r5)
        L2e:
            java.lang.Object[] r5 = r4.slots
            int[] r1 = r4.groups
            int r0 = r4.nodeIndex(r1, r0)
            int r4 = r4.dataIndexToDataAddress(r0)
            r5[r4] = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.updateNodeOfGroup(int, java.lang.Object):void");
    }

    public final void advanceBy(int amount) {
        boolean z10 = false;
        if (!(amount >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
        }
        if (!(this.insertCount <= 0)) {
            PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
        }
        if (amount == 0) {
            return;
        }
        int i = this.currentGroup + amount;
        if (i >= this.parent && i <= this.currentGroupEnd) {
            z10 = true;
        }
        if (!z10) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')');
        }
        this.currentGroup = i;
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i));
        this.currentSlot = iDataIndex;
        this.currentSlotEnd = iDataIndex;
    }

    public final Anchor anchor(int index) {
        ArrayList<Anchor> arrayList = this.anchors;
        int iSearch = SlotTableKt.search(arrayList, index, getSize$runtime());
        if (iSearch >= 0) {
            return arrayList.get(iSearch);
        }
        if (index > this.groupGapStart) {
            index = -(getSize$runtime() - index);
        }
        Anchor anchor = new Anchor(index);
        arrayList.add(-(iSearch + 1), anchor);
        return anchor;
    }

    public final int anchorIndex(Anchor anchor) {
        int location$runtime = anchor.getLocation();
        return location$runtime < 0 ? getSize$runtime() + location$runtime : location$runtime;
    }

    public final void appendSlot(Anchor anchor, Object value) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
        }
        int i = this.currentSlot;
        int i6 = this.currentSlotEnd;
        int iAnchorIndex = anchorIndex(anchor);
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(iAnchorIndex + 1));
        this.currentSlot = iDataIndex;
        this.currentSlotEnd = iDataIndex;
        insertSlots(1, iAnchorIndex);
        if (i >= iDataIndex) {
            i++;
            i6++;
        }
        this.slots[iDataIndex] = value;
        this.currentSlot = i;
        this.currentSlotEnd = i6;
    }

    public final void bashCurrentGroup() {
        SlotTableKt.updateGroupKey(this.groups, this.currentGroup, -3);
    }

    public final void beginInsert() {
        int i = this.insertCount;
        this.insertCount = i + 1;
        if (i == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final Object clear(int slotIndex) {
        int iDataIndexToDataAddress = dataIndexToDataAddress(slotIndex);
        Object[] objArr = this.slots;
        Object obj = objArr[iDataIndexToDataAddress];
        objArr[iDataIndexToDataAddress] = Composer.INSTANCE.getEmpty();
        return obj;
    }

    public final void close(boolean normalClose) {
        this.closed = true;
        if (normalClose && this.startStack.tos == 0) {
            moveGroupGapTo(getSize$runtime());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            clearSlotGap();
            recalculateMarks();
        }
        this.table.close$runtime(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap, this.calledByMap);
    }

    public final int endGroup() {
        MutableObjectList<Object> mutableObjectList;
        boolean z10 = this.insertCount > 0;
        int i = this.currentGroup;
        int i6 = this.currentGroupEnd;
        int i10 = this.parent;
        int iGroupIndexToAddress = groupIndexToAddress(i10);
        int i11 = this.nodeCount;
        int i12 = i - i10;
        int i13 = (iGroupIndexToAddress * 5) + 1;
        boolean z11 = (this.groups[i13] & BasicMeasure.EXACTLY) != 0;
        if (z10) {
            MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
            if (mutableIntObjectMap != null && (mutableObjectList = mutableIntObjectMap.get(i10)) != null) {
                Object[] objArr = mutableObjectList.content;
                int i14 = mutableObjectList._size;
                for (int i15 = 0; i15 < i14; i15++) {
                    rawUpdate(objArr[i15]);
                }
                mutableIntObjectMap.remove(i10);
            }
            SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress, i12);
            SlotTableKt.updateNodeCount(this.groups, iGroupIndexToAddress, i11);
            this.nodeCount = this.nodeCountStack.pop() + (z11 ? 1 : i11);
            int iParent = parent(this.groups, i10);
            this.parent = iParent;
            int size$runtime = iParent < 0 ? getSize$runtime() : groupIndexToAddress(iParent + 1);
            int iDataIndex = size$runtime >= 0 ? dataIndex(this.groups, size$runtime) : 0;
            this.currentSlot = iDataIndex;
            this.currentSlotEnd = iDataIndex;
            return i11;
        }
        if (!(i == i6)) {
            ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
        }
        int iGroupSize = SlotTableKt.groupSize(this.groups, iGroupIndexToAddress);
        int[] iArr = this.groups;
        int i16 = iArr[i13] & RectListKt.Lower26Bits;
        SlotTableKt.updateGroupSize(iArr, iGroupIndexToAddress, i12);
        SlotTableKt.updateNodeCount(this.groups, iGroupIndexToAddress, i11);
        int iPop = this.startStack.pop();
        restoreCurrentGroupEnd();
        this.parent = iPop;
        int iParent2 = parent(this.groups, i10);
        int iPop2 = this.nodeCountStack.pop();
        this.nodeCount = iPop2;
        if (iParent2 == iPop) {
            this.nodeCount = iPop2 + (z11 ? 0 : i11 - i16);
            return i11;
        }
        int i17 = i12 - iGroupSize;
        int i18 = z11 ? 0 : i11 - i16;
        if (i17 != 0 || i18 != 0) {
            while (iParent2 != 0 && iParent2 != iPop && (i18 != 0 || i17 != 0)) {
                int iGroupIndexToAddress2 = groupIndexToAddress(iParent2);
                if (i17 != 0) {
                    SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress2, SlotTableKt.groupSize(this.groups, iGroupIndexToAddress2) + i17);
                }
                if (i18 != 0) {
                    int[] iArr2 = this.groups;
                    SlotTableKt.updateNodeCount(iArr2, iGroupIndexToAddress2, (iArr2[(iGroupIndexToAddress2 * 5) + 1] & RectListKt.Lower26Bits) + i18);
                }
                int[] iArr3 = this.groups;
                if ((iArr3[(iGroupIndexToAddress2 * 5) + 1] & BasicMeasure.EXACTLY) != 0) {
                    i18 = 0;
                }
                iParent2 = parent(iArr3, iParent2);
            }
        }
        this.nodeCount += i18;
        return i11;
    }

    public final void endInsert() {
        if (!(this.insertCount > 0)) {
            PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
        }
        int i = this.insertCount - 1;
        this.insertCount = i;
        if (i == 0) {
            if (!(this.nodeCountStack.tos == this.startStack.tos)) {
                ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
            }
            restoreCurrentGroupEnd();
        }
    }

    public final void ensureStarted(int index) {
        boolean z10 = false;
        if (!(this.insertCount <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
        }
        int i = this.parent;
        if (i != index) {
            if (index >= i && index < this.currentGroupEnd) {
                z10 = true;
            }
            if (!z10) {
                ComposerKt.composeImmediateRuntimeError("Started group at " + index + " must be a subgroup of the group at " + i);
            }
            int i6 = this.currentGroup;
            int i10 = this.currentSlot;
            int i11 = this.currentSlotEnd;
            this.currentGroup = index;
            startGroup();
            this.currentGroup = i6;
            this.currentSlot = i10;
            this.currentSlotEnd = i11;
        }
    }

    public final void forAllData(int group, n block) {
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(groupSize(getCurrentGroup()) + getCurrentGroup()));
        for (int iDataIndex2 = dataIndex(this.groups, groupIndexToAddress(group)); iDataIndex2 < iDataIndex; iDataIndex2++) {
            block.invoke(Integer.valueOf(iDataIndex2), this.slots[dataIndexToDataAddress(iDataIndex2)]);
        }
    }

    public final void forAllDataInRememberOrder(int group, n block) {
        int i;
        int i6;
        Anchor after;
        n nVar = block;
        int iParent = parent(group);
        int size$runtime = getSize$runtime();
        int iGroupSize = groupSize(group) + group;
        kotlin.jvm.internal.e eVar = null;
        int i10 = group;
        MutableIntSet mutableIntSetMutableIntSetOf = null;
        MutableIntList mutableIntList = null;
        while (i10 < iGroupSize) {
            int iDataIndex = dataIndex(i10);
            int i11 = i10 + 1;
            int iDataIndex2 = dataIndex(i11);
            while (true) {
                i = 0;
                if (iDataIndex >= iDataIndex2) {
                    break;
                }
                Object obj = this.slots[dataIndexToDataAddress(iDataIndex)];
                if ((obj instanceof RememberObserverHolder) && (after = ((RememberObserverHolder) obj).getAfter()) != null && after.getValid()) {
                    int iAnchorIndex = anchorIndex(after);
                    if (mutableIntSetMutableIntSetOf == null) {
                        mutableIntSetMutableIntSetOf = IntSetKt.mutableIntSetOf();
                    }
                    if (mutableIntList == null) {
                        mutableIntList = new MutableIntList(i, 1, eVar);
                    }
                    mutableIntSetMutableIntSetOf.add(iAnchorIndex);
                    mutableIntList.add(iAnchorIndex);
                    mutableIntList.add(iDataIndex);
                } else {
                    nVar.invoke(Integer.valueOf(iDataIndex), obj);
                }
                iDataIndex++;
            }
            int iParent2 = i11 < size$runtime ? parent(i11) : -1;
            if (iParent2 != i10) {
                while (true) {
                    if (mutableIntList == null || mutableIntSetMutableIntSetOf == null || !mutableIntSetMutableIntSetOf.remove(i10)) {
                        i6 = size$runtime;
                    } else {
                        int i12 = mutableIntList._size;
                        int i13 = i12 / 2;
                        int i14 = i;
                        int i15 = i14;
                        while (i15 < i13) {
                            int i16 = i15 * 2;
                            int i17 = size$runtime;
                            int i18 = mutableIntList.get(i16);
                            if (i18 == i10) {
                                int i19 = mutableIntList.get(i16 + 1);
                                nVar.invoke(Integer.valueOf(i19), this.slots[dataIndexToDataAddress(i19)]);
                            } else if (i16 != i14) {
                                int i20 = i14 + 1;
                                mutableIntList.set(i14, i18);
                                i14 += 2;
                                mutableIntList.set(i20, mutableIntList.get(i16 + 1));
                            } else {
                                i14 += 2;
                            }
                            i15++;
                            nVar = block;
                            size$runtime = i17;
                        }
                        i6 = size$runtime;
                        if (i14 != i12) {
                            mutableIntList.removeRange(i14, i12);
                        }
                    }
                    if (i10 == group || iParent == iParent2) {
                        break;
                    }
                    i10 = iParent;
                    size$runtime = i6;
                    i = 0;
                    iParent = parent(iParent);
                    nVar = block;
                }
            } else {
                i6 = size$runtime;
            }
            nVar = block;
            iParent = iParent2;
            i10 = i11;
            size$runtime = i6;
            eVar = null;
        }
    }

    public final void forEachTailSlot(int groupIndex, int count, n block) {
        int iSlotsStartIndex$runtime = slotsStartIndex$runtime(groupIndex);
        int iSlotsEndIndex$runtime = slotsEndIndex$runtime(groupIndex);
        for (int iMax = Math.max(iSlotsStartIndex$runtime, iSlotsEndIndex$runtime - count); iMax < iSlotsEndIndex$runtime; iMax++) {
            block.invoke(Integer.valueOf(iMax), this.slots[dataIndexToDataAddress(iMax)]);
        }
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final boolean getCollectingCalledInformation() {
        return this.calledByMap != null;
    }

    public final boolean getCollectingSourceInformation() {
        return this.sourceInformationMap != null;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize$runtime() {
        return getCapacity() - this.groupGapLen;
    }

    public final int getSlotsSize() {
        return this.slots.length - this.slotsGapLen;
    }

    /* renamed from: getTable$runtime, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    public final Object groupAux(int index) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        return (iArr[(iGroupIndexToAddress * 5) + 1] & 268435456) != 0 ? this.slots[auxIndex(iArr, iGroupIndexToAddress)] : Composer.INSTANCE.getEmpty();
    }

    public final int groupKey(int index) {
        return this.groups[groupIndexToAddress(index) * 5];
    }

    public final Object groupObjectKey(int index) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        if ((iArr[(iGroupIndexToAddress * 5) + 1] & 536870912) != 0) {
            return this.slots[SlotTableKt.objectKeyIndex(iArr, iGroupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int index) {
        return SlotTableKt.groupSize(this.groups, groupIndexToAddress(index));
    }

    public final int groupSlotIndex(int group) {
        MutableObjectList<Object> mutableObjectList;
        int iSlotsStartIndex$runtime = this.currentSlot - slotsStartIndex$runtime(group);
        MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
        return iSlotsStartIndex$runtime + ((mutableIntObjectMap == null || (mutableObjectList = mutableIntObjectMap.get(group)) == null) ? 0 : mutableObjectList.getSize());
    }

    public final Iterator<Object> groupSlots() {
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i = this.currentGroup;
        return new AnonymousClass1(iDataIndex, dataIndex(iArr, groupIndexToAddress(groupSize(i) + i)), this);
    }

    public final boolean indexInCurrentGroup(int index) {
        return indexInGroup(index, this.currentGroup);
    }

    public final boolean indexInGroup(int index, int group) {
        int iIndexOf;
        int capacity;
        if (group == this.parent) {
            capacity = this.currentGroupEnd;
        } else if (group <= this.startStack.peekOr(0) && (iIndexOf = this.startStack.indexOf(group)) >= 0) {
            capacity = (getCapacity() - this.groupGapLen) - this.endStack.peek(iIndexOf);
        } else {
            int iGroupSize = groupSize(group);
            capacity = iGroupSize + group;
        }
        return index > group && index < capacity;
    }

    public final boolean indexInParent(int index) {
        int i = this.parent;
        if (index <= i || index >= this.currentGroupEnd) {
            return i == 0 && index == 0;
        }
        return true;
    }

    public final void insertAux(Object value) {
        if (!(this.insertCount >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot insert auxiliary data when not inserting");
        }
        int i = this.parent;
        int iGroupIndexToAddress = groupIndexToAddress(i);
        if ((this.groups[(iGroupIndexToAddress * 5) + 1] & 268435456) != 0) {
            ComposerKt.composeImmediateRuntimeError("Group already has auxiliary data");
        }
        insertSlots(1, i);
        int iAuxIndex = auxIndex(this.groups, iGroupIndexToAddress);
        int iDataIndexToDataAddress = dataIndexToDataAddress(iAuxIndex);
        int i6 = this.currentSlot;
        if (i6 > iAuxIndex) {
            int i10 = i6 - iAuxIndex;
            if (!(i10 < 3)) {
                PreconditionsKt.throwIllegalStateException("Moving more than two slot not supported");
            }
            if (i10 > 1) {
                Object[] objArr = this.slots;
                objArr[iDataIndexToDataAddress + 2] = objArr[iDataIndexToDataAddress + 1];
            }
            Object[] objArr2 = this.slots;
            objArr2[iDataIndexToDataAddress + 1] = objArr2[iDataIndexToDataAddress];
        }
        SlotTableKt.addAux(this.groups, iGroupIndexToAddress);
        this.slots[iDataIndexToDataAddress] = value;
        this.currentSlot++;
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final boolean isNode() {
        int i = this.currentGroup;
        return i < this.currentGroupEnd && (this.groups[(groupIndexToAddress(i) * 5) + 1] & BasicMeasure.EXACTLY) != 0;
    }

    public final void markGroup(int group) {
        int iGroupIndexToAddress = groupIndexToAddress(group);
        int[] iArr = this.groups;
        int i = (iGroupIndexToAddress * 5) + 1;
        if ((iArr[i] & 134217728) != 0) {
            return;
        }
        SlotTableKt.updateMark(iArr, iGroupIndexToAddress, true);
        if ((this.groups[i] & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0) {
            return;
        }
        updateContainsMark(parent(group));
    }

    public final List<Anchor> moveFrom(SlotTable table, int index, boolean removeSourceGroup) {
        if (!(this.insertCount > 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        if (index != 0 || this.currentGroup != 0 || this.table.getGroupsSize() != 0 || SlotTableKt.groupSize(table.getGroups(), index) != table.getGroupsSize()) {
            SlotWriter slotWriterOpenWriter = table.openWriter();
            try {
                List<Anchor> listMoveGroup = INSTANCE.moveGroup(slotWriterOpenWriter, index, this, true, true, removeSourceGroup);
                slotWriterOpenWriter.close(true);
                return listMoveGroup;
            } catch (Throwable th) {
                slotWriterOpenWriter.close(false);
                throw th;
            }
        }
        int[] iArr = this.groups;
        Object[] objArr = this.slots;
        ArrayList<Anchor> arrayList = this.anchors;
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
        int[] groups = table.getGroups();
        int groupsSize = table.getGroupsSize();
        Object[] slots = table.getSlots();
        int slotsSize = table.getSlotsSize();
        HashMap<Anchor, GroupSourceInformation> sourceInformationMap$runtime = table.getSourceInformationMap$runtime();
        MutableIntObjectMap<MutableIntSet> calledByMap$runtime = table.getCalledByMap$runtime();
        this.groups = groups;
        this.slots = slots;
        this.anchors = table.getAnchors$runtime();
        this.groupGapStart = groupsSize;
        this.groupGapLen = (groups.length / 5) - groupsSize;
        this.slotsGapStart = slotsSize;
        this.slotsGapLen = slots.length - slotsSize;
        this.slotsGapOwner = groupsSize;
        this.sourceInformationMap = sourceInformationMap$runtime;
        this.calledByMap = calledByMap$runtime;
        table.setTo$runtime(iArr, 0, objArr, 0, arrayList, map, mutableIntObjectMap);
        return this.anchors;
    }

    public final void moveGroup(int offset) {
        if (this.insertCount != 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
        }
        if (offset < 0) {
            ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
        }
        if (offset == 0) {
            return;
        }
        int i = this.currentGroup;
        int i6 = this.parent;
        int i10 = this.currentGroupEnd;
        int iGroupSize = i;
        for (int i11 = offset; i11 > 0; i11--) {
            iGroupSize += SlotTableKt.groupSize(this.groups, groupIndexToAddress(iGroupSize));
            if (iGroupSize > i10) {
                ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
            }
        }
        int iGroupSize2 = SlotTableKt.groupSize(this.groups, groupIndexToAddress(iGroupSize));
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int iDataIndex2 = dataIndex(this.groups, groupIndexToAddress(iGroupSize));
        int i12 = iGroupSize + iGroupSize2;
        int iDataIndex3 = dataIndex(this.groups, groupIndexToAddress(i12));
        int i13 = iDataIndex3 - iDataIndex2;
        insertSlots(i13, Math.max(this.currentGroup - 1, 0));
        insertGroups(iGroupSize2);
        int[] iArr = this.groups;
        int iGroupIndexToAddress = groupIndexToAddress(i12) * 5;
        q.R(groupIndexToAddress(i) * 5, iGroupIndexToAddress, iArr, iArr, (iGroupSize2 * 5) + iGroupIndexToAddress);
        if (i13 > 0) {
            Object[] objArr = this.slots;
            int iDataIndexToDataAddress = dataIndexToDataAddress(iDataIndex2 + i13);
            System.arraycopy(objArr, iDataIndexToDataAddress, objArr, iDataIndex, dataIndexToDataAddress(iDataIndex3 + i13) - iDataIndexToDataAddress);
        }
        int i14 = iDataIndex2 + i13;
        int i15 = i14 - iDataIndex;
        int i16 = this.slotsGapStart;
        int i17 = this.slotsGapLen;
        int length = this.slots.length;
        int i18 = this.slotsGapOwner;
        int i19 = i + iGroupSize2;
        int i20 = i;
        while (i20 < i19) {
            int iGroupIndexToAddress2 = groupIndexToAddress(i20);
            int i21 = i15;
            int iDataIndex4 = dataIndex(iArr, iGroupIndexToAddress2) - i21;
            int i22 = i16;
            if (i18 < iGroupIndexToAddress2) {
                i16 = 0;
            }
            updateDataIndex(iArr, iGroupIndexToAddress2, dataIndexToDataAnchor(iDataIndex4, i16, i17, length));
            i20++;
            i16 = i22;
            i15 = i21;
        }
        moveAnchors(i12, i, iGroupSize2);
        if (removeGroups(i12, iGroupSize2)) {
            ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
        }
        fixParentAnchorsFor(i6, this.currentGroupEnd, i);
        if (i13 > 0) {
            removeSlots(i14, i13, i12 - 1);
        }
    }

    public final List<Anchor> moveIntoGroupFrom(int offset, SlotTable table, int index) {
        if (!(this.insertCount <= 0 && groupSize(this.currentGroup + offset) == 1)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int i = this.currentGroup;
        int i6 = this.currentSlot;
        int i10 = this.currentSlotEnd;
        advanceBy(offset);
        startGroup();
        beginInsert();
        SlotWriter slotWriterOpenWriter = table.openWriter();
        try {
            List<Anchor> listMoveGroup$default = Companion.moveGroup$default(INSTANCE, slotWriterOpenWriter, index, this, false, true, false, 32, null);
            slotWriterOpenWriter.close(true);
            endInsert();
            endGroup();
            this.currentGroup = i;
            this.currentSlot = i6;
            this.currentSlotEnd = i10;
            return listMoveGroup$default;
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    public final List<Anchor> moveTo(Anchor anchor, int offset, SlotWriter writer) {
        if (!(writer.insertCount > 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        if (!anchor.getValid()) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int iAnchorIndex = anchorIndex(anchor) + offset;
        int i = this.currentGroup;
        if (!(i <= iAnchorIndex && iAnchorIndex < this.currentGroupEnd)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int iParent = parent(iAnchorIndex);
        int iGroupSize = groupSize(iAnchorIndex);
        int iNodeCount = isNode(iAnchorIndex) ? 1 : nodeCount(iAnchorIndex);
        List<Anchor> listMoveGroup$default = Companion.moveGroup$default(INSTANCE, this, iAnchorIndex, writer, false, false, false, 32, null);
        updateContainsMark(iParent);
        boolean z10 = iNodeCount > 0;
        while (iParent >= i) {
            int iGroupIndexToAddress = groupIndexToAddress(iParent);
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, iGroupIndexToAddress, SlotTableKt.groupSize(iArr, iGroupIndexToAddress) - iGroupSize);
            if (z10) {
                int[] iArr2 = this.groups;
                int i6 = iArr2[(iGroupIndexToAddress * 5) + 1];
                if ((1073741824 & i6) != 0) {
                    z10 = false;
                } else {
                    SlotTableKt.updateNodeCount(iArr2, iGroupIndexToAddress, (i6 & RectListKt.Lower26Bits) - iNodeCount);
                }
            }
            iParent = parent(iParent);
        }
        if (z10) {
            if (!(this.nodeCount >= iNodeCount)) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            this.nodeCount -= iNodeCount;
        }
        return listMoveGroup$default;
    }

    public final Object node(int index) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        if ((iArr[(iGroupIndexToAddress * 5) + 1] & BasicMeasure.EXACTLY) != 0) {
            return this.slots[dataIndexToDataAddress(nodeIndex(iArr, iGroupIndexToAddress))];
        }
        return null;
    }

    public final int nodeCount(int index) {
        return this.groups[(groupIndexToAddress(index) * 5) + 1] & RectListKt.Lower26Bits;
    }

    public final int parent(int index) {
        return parent(this.groups, index);
    }

    public final void recordGroupSourceInformation(String sourceInformation) {
        if (this.insertCount > 0) {
            groupSourceInformationFor(this.parent, sourceInformation);
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        GroupSourceInformation groupSourceInformationGroupSourceInformationFor;
        if (this.insertCount <= 0 || (groupSourceInformationGroupSourceInformationFor = groupSourceInformationFor(this.parent, null)) == null) {
            return;
        }
        groupSourceInformationGroupSourceInformationFor.endGrouplessCall(getCurrentGroupSlotIndex());
    }

    public final void recordGrouplessCallSourceInformationStart(int key, String value) {
        if (this.insertCount > 0) {
            MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
            if (mutableIntObjectMap != null) {
                SlotTableKt.add(mutableIntObjectMap, key, groupKey(this.parent));
            }
            GroupSourceInformation groupSourceInformationGroupSourceInformationFor = groupSourceInformationFor(this.parent, null);
            if (groupSourceInformationGroupSourceInformationFor != null) {
                groupSourceInformationGroupSourceInformationFor.startGrouplessCall(key, value, getCurrentGroupSlotIndex());
            }
        }
    }

    public final boolean removeGroup() {
        Anchor anchorTryAnchor$runtime;
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
        }
        int i = this.currentGroup;
        int i6 = this.currentSlot;
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i));
        int iSkipGroup = skipGroup();
        GroupSourceInformation groupSourceInformationSourceInformationOf$runtime = sourceInformationOf$runtime(this.parent);
        if (groupSourceInformationSourceInformationOf$runtime != null && (anchorTryAnchor$runtime = tryAnchor$runtime(i)) != null) {
            groupSourceInformationSourceInformationOf$runtime.removeAnchor(anchorTryAnchor$runtime);
        }
        MutableIntList mutableIntList = this.pendingRecalculateMarks;
        if (mutableIntList != null) {
            while (PrioritySet.m3441isNotEmptyimpl(mutableIntList) && PrioritySet.m3442peekimpl(mutableIntList) >= i) {
                PrioritySet.m3443takeMaximpl(mutableIntList);
            }
        }
        boolean zRemoveGroups = removeGroups(i, this.currentGroup - i);
        removeSlots(iDataIndex, this.currentSlot - iDataIndex, i - 1);
        this.currentGroup = i;
        this.currentSlot = i6;
        this.nodeCount -= iSkipGroup;
        return zRemoveGroups;
    }

    public final void reset() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
        }
        recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
    }

    public final void seek(Anchor anchor) {
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void set(Object value) {
        if (!(this.currentSlot <= this.currentSlotEnd)) {
            ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
        }
        this.slots[dataIndexToDataAddress(this.currentSlot - 1)] = value;
    }

    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        return objArr[dataIndexToDataAddress(i)];
    }

    public final int skipGroup() {
        int iGroupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int iGroupSize = SlotTableKt.groupSize(this.groups, iGroupIndexToAddress) + this.currentGroup;
        this.currentGroup = iGroupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(iGroupSize));
        int i = this.groups[(iGroupIndexToAddress * 5) + 1];
        if ((1073741824 & i) != 0) {
            return 1;
        }
        return i & RectListKt.Lower26Bits;
    }

    public final void skipToGroupEnd() {
        int i = this.currentGroupEnd;
        this.currentGroup = i;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i));
    }

    public final Object slot(Anchor anchor, int index) {
        return slot(anchorIndex(anchor), index);
    }

    public final int slotIndexOfGroupSlotIndex(int group, int index) {
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(group));
        int i = iSlotIndex + index;
        if (!(i >= iSlotIndex && i < dataIndex(this.groups, groupIndexToAddress(group + 1)))) {
            ComposerKt.composeImmediateRuntimeError("Write to an invalid slot index " + index + " for group " + group);
        }
        return i;
    }

    public final int slotsEndAllIndex$runtime(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupSize(groupIndex) + groupIndex));
    }

    public final int slotsEndIndex$runtime(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
    }

    public final int slotsStartIndex$runtime(int groupIndex) {
        return slotIndex(this.groups, groupIndexToAddress(groupIndex));
    }

    public final GroupSourceInformation sourceInformationOf$runtime(int group) {
        Anchor anchorTryAnchor$runtime;
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        if (map == null || (anchorTryAnchor$runtime = tryAnchor$runtime(group)) == null) {
            return null;
        }
        return map.get(anchorTryAnchor$runtime);
    }

    public final void startData(int key, Object objectKey, Object aux) {
        startGroup(key, objectKey, false, aux);
    }

    public final void startGroup() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
        }
        Composer.Companion companion = Composer.INSTANCE;
        startGroup(0, companion.getEmpty(), false, companion.getEmpty());
    }

    public final void startNode(int key, Object objectKey) {
        startGroup(key, objectKey, true, Composer.INSTANCE.getEmpty());
    }

    public final String toDebugString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        sb.append('\n');
        sb.append("  parent:    " + this.parent);
        sb.append('\n');
        sb.append("  current:   " + this.currentGroup);
        sb.append('\n');
        sb.append("  group gap: " + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + '(' + this.groupGapLen + ')');
        sb.append('\n');
        sb.append("  slots gap: " + this.slotsGapStart + '-' + (this.slotsGapStart + this.slotsGapLen) + '(' + this.slotsGapLen + ')');
        sb.append('\n');
        StringBuilder sb2 = new StringBuilder("  gap owner: ");
        sb2.append(this.slotsGapOwner);
        sb.append(sb2.toString());
        sb.append('\n');
        int size$runtime = getSize$runtime();
        for (int i = 0; i < size$runtime; i++) {
            groupAsString(sb, i);
            sb.append('\n');
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    public final void traverseGroupAndChildren(int group, S7.k enter, S7.k exit) {
        int iParent = parent(group);
        int size$runtime = getSize$runtime();
        int iGroupSize = groupSize(group) + group;
        int i = group;
        while (i < iGroupSize) {
            enter.invoke(Integer.valueOf(i));
            int i6 = i + 1;
            int iParent2 = i6 < size$runtime ? parent(i6) : -1;
            if (iParent2 != i) {
                while (true) {
                    exit.invoke(Integer.valueOf(i));
                    if (i == group || iParent == iParent2) {
                        break;
                    }
                    i = iParent;
                    iParent = parent(iParent);
                }
            }
            i = i6;
            iParent = iParent2;
        }
    }

    public final void trimTailSlots(int count) {
        if (!(count > 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int i = this.parent;
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1)) - count;
        if (!(iDataIndex >= iSlotIndex)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        removeSlots(iDataIndex, count, i);
        int i6 = this.currentSlot;
        if (i6 >= iSlotIndex) {
            this.currentSlot = i6 - count;
        }
    }

    public final Anchor tryAnchor$runtime(int group) {
        if (group < 0 || group >= getSize$runtime()) {
            return null;
        }
        return SlotTableKt.find(this.anchors, group, getSize$runtime());
    }

    public final Object update(Object value) {
        if (this.insertCount <= 0 || this.currentSlot == this.slotsGapStart) {
            return rawUpdate(value);
        }
        MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
        kotlin.jvm.internal.e eVar = null;
        int i = 1;
        int i6 = 0;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap<>(i6, i, eVar);
        }
        this.deferredSlotWrites = mutableIntObjectMap;
        int i10 = this.parent;
        MutableObjectList<Object> mutableObjectList = mutableIntObjectMap.get(i10);
        if (mutableObjectList == null) {
            mutableObjectList = new MutableObjectList<>(i6, i, eVar);
            mutableIntObjectMap.set(i10, mutableObjectList);
        }
        mutableObjectList.add(value);
        return Composer.INSTANCE.getEmpty();
    }

    public final void updateAux(Object value) {
        int iGroupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (!((this.groups[(iGroupIndexToAddress * 5) + 1] & 268435456) != 0)) {
            ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
        }
        this.slots[dataIndexToDataAddress(auxIndex(this.groups, iGroupIndexToAddress))] = value;
    }

    public final void updateNode(Object value) {
        updateNodeOfGroup(this.currentGroup, value);
    }

    public final void updateParentNode(Object value) {
        updateNodeOfGroup(this.parent, value);
    }

    public final void updateToTableMaps() {
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime();
        this.calledByMap = this.table.getCalledByMap$runtime();
    }

    public final void verifyDataAnchors$runtime() {
        int i = this.slotsGapOwner;
        int length = this.slots.length - this.slotsGapLen;
        int size$runtime = getSize$runtime();
        int i6 = 0;
        int i10 = 0;
        boolean z10 = false;
        while (i6 < size$runtime) {
            int iGroupIndexToAddress = groupIndexToAddress(i6);
            int[] iArr = this.groups;
            int i11 = iArr[(iGroupIndexToAddress * 5) + 4];
            int iDataIndex = dataIndex(iArr, iGroupIndexToAddress);
            if (!(iDataIndex >= i10)) {
                StringBuilder sbS = androidx.appfunctions.metadata.a.s(i6, "Data index out of order at ", i10, ", previous = ", ", current = ");
                sbS.append(iDataIndex);
                PreconditionsKt.throwIllegalStateException(sbS.toString());
            }
            if (!(iDataIndex <= length)) {
                PreconditionsKt.throwIllegalStateException("Data index, " + iDataIndex + ", out of bound at " + i6);
            }
            if (i11 < 0 && !z10) {
                if (!(i == i6)) {
                    PreconditionsKt.throwIllegalStateException("Expected the slot gap owner to be " + i + " found gap at " + i6);
                }
                z10 = true;
            }
            i6++;
            i10 = iDataIndex;
        }
    }

    public final void verifyParentAnchors$runtime() {
        int i = this.groupGapStart;
        int i6 = this.groupGapLen;
        int capacity = getCapacity();
        int i10 = 0;
        while (true) {
            if (i10 >= i) {
                break;
            }
            if (!(this.groups[(i10 * 5) + 2] > -2)) {
                PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + i10);
            }
            i10++;
        }
        for (int i11 = i6 + i; i11 < capacity; i11++) {
            int i12 = this.groups[(i11 * 5) + 2];
            if (parentAnchorToIndex(i12) < i) {
                if (!(i12 > -2)) {
                    PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + i11);
                }
            } else if (!(i12 <= -2)) {
                PreconditionsKt.throwIllegalStateException("Expected an end relative anchor at " + i11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i) {
        return i >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(iArr[(i * 5) + 4], this.slotsGapLen, this.slots.length);
    }

    public final int parent(Anchor anchor) {
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    public final Object slot(int groupIndex, int index) {
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(groupIndex));
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
        int i = index + iSlotIndex;
        if (iSlotIndex > i || i >= iDataIndex) {
            return Composer.INSTANCE.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(i)];
    }

    public final void startData(int key, Object aux) {
        startGroup(key, Composer.INSTANCE.getEmpty(), false, aux);
    }

    public final void startNode(int key, Object objectKey, Object node) {
        startGroup(key, objectKey, true, node);
    }

    public final void updateNode(Anchor anchor, Object value) {
        updateNodeOfGroup(anchor.toIndexFor(this), value);
    }

    private final int parent(int[] iArr, int i) {
        return parentAnchorToIndex(iArr[(groupIndexToAddress(i) * 5) + 2]);
    }

    public final boolean isNode(int index) {
        return (this.groups[(groupIndexToAddress(index) * 5) + 1] & BasicMeasure.EXACTLY) != 0;
    }

    public final Object set(int index, Object value) {
        return set(getCurrentGroup(), index, value);
    }

    public final void startGroup(int key) {
        Composer.Companion companion = Composer.INSTANCE;
        startGroup(key, companion.getEmpty(), false, companion.getEmpty());
    }

    public final Object node(Anchor anchor) {
        return node(anchor.toIndexFor(this));
    }

    public final Object set(int group, int index, Object value) {
        int iDataIndexToDataAddress = dataIndexToDataAddress(slotIndexOfGroupSlotIndex(group, index));
        Object[] objArr = this.slots;
        Object obj = objArr[iDataIndexToDataAddress];
        objArr[iDataIndexToDataAddress] = value;
        return obj;
    }

    public final void startGroup(int key, Object dataKey) {
        startGroup(key, dataKey, false, Composer.INSTANCE.getEmpty());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    private final void startGroup(int key, Object objectKey, boolean isNode, Object aux) {
        int iGroupSize;
        GroupSourceInformation groupSourceInformationSourceInformationOf$runtime;
        int i = this.parent;
        Object[] objArr = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (objArr != false) {
            int i6 = this.currentGroup;
            int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i6));
            insertGroups(1);
            this.currentSlot = iDataIndex;
            this.currentSlotEnd = iDataIndex;
            int iGroupIndexToAddress = groupIndexToAddress(i6);
            Composer.Companion companion = Composer.INSTANCE;
            ?? r12 = objectKey != companion.getEmpty() ? 1 : 0;
            ?? r13 = (isNode || aux == companion.getEmpty()) ? 0 : 1;
            int iDataIndexToDataAnchor = dataIndexToDataAnchor(iDataIndex, this.slotsGapStart, this.slotsGapLen, this.slots.length);
            if (iDataIndexToDataAnchor >= 0 && this.slotsGapOwner < i6) {
                iDataIndexToDataAnchor = -(((this.slots.length - this.slotsGapLen) - iDataIndexToDataAnchor) + 1);
            }
            SlotTableKt.initGroup(this.groups, iGroupIndexToAddress, key, isNode, r12, r13, this.parent, iDataIndexToDataAnchor);
            int i10 = (isNode ? 1 : 0) + r12 + r13;
            if (i10 > 0) {
                insertSlots(i10, i6);
                Object[] objArr2 = this.slots;
                int i11 = this.currentSlot;
                if (isNode) {
                    objArr2[i11] = aux;
                    i11++;
                }
                if (r12 != 0) {
                    objArr2[i11] = objectKey;
                    i11++;
                }
                if (r13 != 0) {
                    objArr2[i11] = aux;
                    i11++;
                }
                this.currentSlot = i11;
            }
            this.nodeCount = 0;
            iGroupSize = i6 + 1;
            this.parent = i6;
            this.currentGroup = iGroupSize;
            if (i >= 0 && (groupSourceInformationSourceInformationOf$runtime = sourceInformationOf$runtime(i)) != null) {
                groupSourceInformationSourceInformationOf$runtime.reportGroup(this, i6);
            }
        } else {
            this.startStack.push(i);
            saveCurrentGroupEnd();
            int i12 = this.currentGroup;
            int iGroupIndexToAddress2 = groupIndexToAddress(i12);
            if (!kotlin.jvm.internal.k.b(aux, Composer.INSTANCE.getEmpty())) {
                if (isNode) {
                    updateNode(aux);
                } else {
                    updateAux(aux);
                }
            }
            this.currentSlot = slotIndex(this.groups, iGroupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            int[] iArr = this.groups;
            this.nodeCount = iArr[(iGroupIndexToAddress2 * 5) + 1] & RectListKt.Lower26Bits;
            this.parent = i12;
            this.currentGroup = i12 + 1;
            iGroupSize = i12 + SlotTableKt.groupSize(iArr, iGroupIndexToAddress2);
        }
        this.currentGroupEnd = iGroupSize;
    }

    public final void ensureStarted(Anchor anchor) {
        ensureStarted(anchor.toIndexFor(this));
    }
}
