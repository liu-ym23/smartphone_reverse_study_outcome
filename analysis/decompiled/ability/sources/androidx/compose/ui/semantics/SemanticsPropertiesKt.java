package androidx.compose.ui.semantics;

import C7.c;
import C7.d;
import C7.r;
import H4.o;
import S7.a;
import S7.k;
import S7.n;
import Z7.t;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.b;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.exifinterface.media.ExifInterface;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.m;

@Metadata(d1 = {"\u0000è\u0001\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0007\u001aD\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u001e\b\b\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bH\u0080\b¢\u0006\u0004\b\u0006\u0010\n\u001a4\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u0005\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0082\b¢\u0006\u0004\b\u000e\u0010\u0007\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u00020\u0010*\u00020\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0012\u001a\u0011\u0010\u0015\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0012\u001a\u0011\u0010\u0016\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0012\u001a\u0011\u0010\u0017\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0012\u001a\u0011\u0010\u0018\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0012\u001a\u0019\u0010\u001a\u001a\u00020\u0010*\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a%\u0010 \u001a\u00020\u0010*\u00020\u000f2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c¢\u0006\u0004\b \u0010!\u001a\u0011\u0010\"\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\"\u0010\u0012\u001a9\u0010'\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u001a\u0010&\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c¢\u0006\u0004\b'\u0010(\u001a-\u0010*\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\b*\u0010+\u001a-\u0010,\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\b,\u0010+\u001a9\u0010.\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\u0004\b.\u0010/\u001a5\u00102\u001a\u00020\u0010*\u00020\u000f2\"\u0010&\u001a\u001e\b\u0001\u0012\u0004\u0012\u000200\u0012\n\u0012\b\u0012\u0004\u0012\u00020001\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\b¢\u0006\u0004\b2\u00103\u001a1\u00104\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f0\u001c¢\u0006\u0004\b4\u0010(\u001a3\u00106\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c¢\u0006\u0004\b6\u0010(\u001a3\u00107\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c¢\u0006\u0004\b7\u0010(\u001a3\u00108\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c¢\u0006\u0004\b8\u0010(\u001a3\u00109\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c¢\u0006\u0004\b9\u0010(\u001a3\u0010:\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c¢\u0006\u0004\b:\u0010(\u001a-\u0010;\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\b;\u0010+\u001a3\u0010<\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c¢\u0006\u0004\b<\u0010(\u001a5\u0010A\u001a\u00020\u0010*\u00020\u000f2\u0006\u0010>\u001a\u00020=2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\b?\u0010@\u001a/\u0010B\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)H\u0007¢\u0006\u0004\bB\u0010+\u001a?\u0010D\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032 \u0010&\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010C¢\u0006\u0004\bD\u0010E\u001a-\u0010F\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bF\u0010+\u001a-\u0010G\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bG\u0010+\u001a-\u0010H\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bH\u0010+\u001a-\u0010I\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bI\u0010+\u001a-\u0010J\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bJ\u0010+\u001a-\u0010K\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bK\u0010+\u001a-\u0010L\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bL\u0010+\u001a-\u0010M\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bM\u0010+\u001a-\u0010N\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bN\u0010+\u001a-\u0010O\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bO\u0010+\u001a-\u0010P\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)¢\u0006\u0004\bP\u0010+\u001a-\u0010Q\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0)¢\u0006\u0004\bQ\u0010+\"(\u0010V\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010R\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010\u001b\"/\u0010\\\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010W\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bX\u0010T\"\u0004\bY\u0010\u001b*\u0004\bZ\u0010[\"/\u0010c\u001a\u00020]*\u00020\u000f2\u0006\u0010W\u001a\u00020]8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a*\u0004\bb\u0010[\"/\u0010g\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010W\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bd\u0010T\"\u0004\be\u0010\u001b*\u0004\bf\u0010[\"/\u0010n\u001a\u00020h*\u00020\u000f2\u0006\u0010W\u001a\u00020h8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bi\u0010j\"\u0004\bk\u0010l*\u0004\bm\u0010[\"/\u0010t\u001a\u00020\f*\u00020\u000f2\u0006\u0010W\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r*\u0004\bs\u0010[\"5\u0010u\u001a\u00020\f*\u00020\u000f2\u0006\u0010W\u001a\u00020\f8F@FX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\bw\u0010\u0012\u001a\u0004\bu\u0010p\"\u0004\bv\u0010r*\u0004\bx\u0010[\"/\u0010y\u001a\u00020\f*\u00020\u000f2\u0006\u0010W\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\by\u0010p\"\u0004\bz\u0010r*\u0004\b{\u0010[\"/\u0010|\u001a\u00020\f*\u00020\u000f2\u0006\u0010W\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b|\u0010p\"\u0004\b}\u0010r*\u0004\b~\u0010[\"5\u0010\u0085\u0001\u001a\u00020\u007f*\u00020\u000f2\u0006\u0010W\u001a\u00020\u007f8F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001*\u0005\b\u0084\u0001\u0010[\"7\u0010\u008c\u0001\u001a\u00030\u0086\u0001*\u00020\u000f2\u0007\u0010W\u001a\u00030\u0086\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001*\u0005\b\u008b\u0001\u0010[\"5\u0010\u0092\u0001\u001a\u00020-*\u00020\u000f2\u0006\u0010W\u001a\u00020-8F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001*\u0005\b\u0091\u0001\u0010[\"7\u0010\u0099\u0001\u001a\u00030\u0093\u0001*\u00020\u000f2\u0007\u0010W\u001a\u00030\u0093\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001*\u0005\b\u0098\u0001\u0010[\"7\u0010\u009d\u0001\u001a\u00030\u0093\u0001*\u00020\u000f2\u0007\u0010W\u001a\u00030\u0093\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u009a\u0001\u0010\u0095\u0001\"\u0006\b\u009b\u0001\u0010\u0097\u0001*\u0005\b\u009c\u0001\u0010[\"5\u0010¢\u0001\u001a\u00030\u009e\u0001*\u00020\u000f2\u0007\u0010W\u001a\u00030\u009e\u00018F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\b\u009f\u0001\u0010j\"\u0005\b \u0001\u0010l*\u0005\b¡\u0001\u0010[\"3\u0010¦\u0001\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010W\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\b£\u0001\u0010T\"\u0005\b¤\u0001\u0010\u001b*\u0005\b¥\u0001\u0010[\",\u0010ª\u0001\u001a\u000205*\u00020\u000f2\u0006\u0010R\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0005\b8\u0010©\u0001\"4\u0010\u00ad\u0001\u001a\u000205*\u00020\u000f2\u0006\u0010W\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0016\u001a\u0006\b«\u0001\u0010¨\u0001\"\u0005\b9\u0010©\u0001*\u0005\b¬\u0001\u0010[\"3\u0010®\u0001\u001a\u00020\f*\u00020\u000f2\u0006\u0010W\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\b®\u0001\u0010p\"\u0005\b¯\u0001\u0010r*\u0005\b°\u0001\u0010[\"5\u0010´\u0001\u001a\u000205*\u00020\u000f2\u0006\u0010W\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b±\u0001\u0010¨\u0001\"\u0006\b²\u0001\u0010©\u0001*\u0005\b³\u0001\u0010[\"5\u0010¸\u0001\u001a\u000205*\u00020\u000f2\u0006\u0010W\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\bµ\u0001\u0010¨\u0001\"\u0006\b¶\u0001\u0010©\u0001*\u0005\b·\u0001\u0010[\"7\u0010¿\u0001\u001a\u00030¹\u0001*\u00020\u000f2\u0007\u0010W\u001a\u00030¹\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001*\u0005\b¾\u0001\u0010[\":\u0010Ä\u0001\u001a\u00020=*\u00020\u000f2\u0006\u0010W\u001a\u00020=8G@GX\u0087\u008e\u0002¢\u0006\u001c\u0012\u0005\bÂ\u0001\u0010\u0012\u001a\u0005\bÀ\u0001\u0010j\"\u0005\bÁ\u0001\u0010l*\u0005\bÃ\u0001\u0010[\"3\u0010È\u0001\u001a\u00020\f*\u00020\u000f2\u0006\u0010W\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\bÅ\u0001\u0010p\"\u0005\bÆ\u0001\u0010r*\u0005\bÇ\u0001\u0010[\"7\u0010Ï\u0001\u001a\u00030É\u0001*\u00020\u000f2\u0007\u0010W\u001a\u00030É\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001*\u0005\bÎ\u0001\u0010[\"7\u0010Ö\u0001\u001a\u00030Ð\u0001*\u00020\u000f2\u0007\u0010W\u001a\u00030Ð\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001*\u0005\bÕ\u0001\u0010[\"7\u0010Ý\u0001\u001a\u00030×\u0001*\u00020\u000f2\u0007\u0010W\u001a\u00030×\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001*\u0005\bÜ\u0001\u0010[\"3\u0010Þ\u0001\u001a\u00020\f*\u00020\u000f2\u0006\u0010W\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\bÞ\u0001\u0010p\"\u0005\bß\u0001\u0010r*\u0005\bà\u0001\u0010[\"3\u0010ä\u0001\u001a\u00020\u001e*\u00020\u000f2\u0006\u0010W\u001a\u00020\u001e8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\bá\u0001\u0010j\"\u0005\bâ\u0001\u0010l*\u0005\bã\u0001\u0010[\"7\u0010ë\u0001\u001a\u00030å\u0001*\u00020\u000f2\u0007\u0010W\u001a\u00030å\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\bæ\u0001\u0010ç\u0001\"\u0006\bè\u0001\u0010é\u0001*\u0005\bê\u0001\u0010[\"E\u0010ó\u0001\u001a\n\u0012\u0005\u0012\u00030í\u00010ì\u0001*\u00020\u000f2\u000e\u0010W\u001a\n\u0012\u0005\u0012\u00030í\u00010ì\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\bî\u0001\u0010ï\u0001\"\u0006\bð\u0001\u0010ñ\u0001*\u0005\bò\u0001\u0010[¨\u0006ô\u0001"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "throwSemanticsGetNotSupported", "()Ljava/lang/Object;", "", HintConstants.AUTOFILL_HINT_NAME, "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "AccessibilityKey", "(Ljava/lang/String;)Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function2;", "mergePolicy", "(Ljava/lang/String;LS7/n;)Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "LC7/d;", "", "Landroidx/compose/ui/semantics/AccessibilityAction;", "ActionPropertyKey", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "LC7/r;", "heading", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "disabled", "invisibleToUser", "hideFromAccessibility", "popup", "dialog", HintConstants.AUTOFILL_HINT_PASSWORD, "description", "error", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "Lkotlin/Function1;", "", "", "mapping", "indexForKey", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;LS7/k;)V", "selectableGroup", "label", "", "Landroidx/compose/ui/text/TextLayoutResult;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "getTextLayoutResult", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;LS7/k;)V", "Lkotlin/Function0;", "onClick", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;LS7/a;)V", "onLongClick", "", "scrollBy", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;LS7/n;)V", "Landroidx/compose/ui/geometry/Offset;", "LH7/c;", "scrollByOffset", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;LS7/n;)V", "scrollToIndex", "Landroidx/compose/ui/text/AnnotatedString;", "onAutofillText", "setProgress", RequestInfo.FUNCTION_SET_TEXT, "setTextSubstitution", "showTextSubstitution", "clearTextSubstitution", "insertTextAtCursor", "Landroidx/compose/ui/text/input/ImeAction;", "imeActionType", "onImeAction-9UiTYpY", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;ILjava/lang/String;LS7/a;)V", "onImeAction", "performImeAction", "Lkotlin/Function3;", "setSelection", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;LS7/o;)V", "copyText", "cutText", "pasteText", "expand", "collapse", "dismiss", "requestFocus", "pageUp", "pageDown", "pageLeft", "pageRight", "getScrollViewportLength", "value", "getContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setContentDescription", "contentDescription", "<set-?>", "getStateDescription", "setStateDescription", "getStateDescription$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "stateDescription", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "getProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "setProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ProgressBarRangeInfo;)V", "getProgressBarRangeInfo$delegate", "progressBarRangeInfo", "getPaneTitle", "setPaneTitle", "getPaneTitle$delegate", "paneTitle", "Landroidx/compose/ui/semantics/LiveRegionMode;", "getLiveRegion", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", "setLiveRegion-hR3wRGc", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;I)V", "getLiveRegion$delegate", "liveRegion", "getFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "getFocused$delegate", "focused", "isContainer", "setContainer", "isContainer$annotations", "isContainer$delegate", "isTraversalGroup", "setTraversalGroup", "isTraversalGroup$delegate", "isSensitiveData", "setSensitiveData", "isSensitiveData$delegate", "Landroidx/compose/ui/autofill/ContentType;", "getContentType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", "setContentType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/autofill/ContentType;)V", "getContentType$delegate", "contentType", "Landroidx/compose/ui/autofill/ContentDataType;", "getContentDataType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentDataType;", "setContentDataType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/autofill/ContentDataType;)V", "getContentDataType$delegate", "contentDataType", "getTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", "setTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;F)V", "getTraversalIndex$delegate", "traversalIndex", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "getHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "getHorizontalScrollAxisRange$delegate", "horizontalScrollAxisRange", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "getVerticalScrollAxisRange$delegate", "verticalScrollAxisRange", "Landroidx/compose/ui/semantics/Role;", "getRole", "setRole-kuIjeqM", "getRole$delegate", "role", "getTestTag", "setTestTag", "getTestTag$delegate", "testTag", "getText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/text/AnnotatedString;)V", "text", "getTextSubstitution", "getTextSubstitution$delegate", "textSubstitution", "isShowingTextSubstitution", "setShowingTextSubstitution", "isShowingTextSubstitution$delegate", "getInputText", "setInputText", "getInputText$delegate", "inputText", "getEditableText", "setEditableText", "getEditableText$delegate", "editableText", "Landroidx/compose/ui/text/TextRange;", "getTextSelectionRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", "setTextSelectionRange-FDrldGo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;J)V", "getTextSelectionRange$delegate", "textSelectionRange", "getImeAction", "setImeAction-4L7nppU", "getImeAction$annotations", "getImeAction$delegate", "imeAction", "getSelected", "setSelected", "getSelected$delegate", "selected", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", "setCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionInfo;)V", "getCollectionInfo$delegate", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "getCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", "setCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionItemInfo;)V", "getCollectionItemInfo$delegate", "collectionItemInfo", "Landroidx/compose/ui/state/ToggleableState;", "getToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", "setToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/state/ToggleableState;)V", "getToggleableState$delegate", "toggleableState", "isEditable", "setEditable", "isEditable$delegate", "getMaxTextLength", "setMaxTextLength", "getMaxTextLength$delegate", "maxTextLength", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/graphics/Shape;)V", "getShape$delegate", "shape", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "getCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", "setCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/util/List;)V", "getCustomActions$delegate", "customActions", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsPropertiesKt {
    static final /* synthetic */ t[] $$delegatedProperties;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"LC7/d;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/semantics/AccessibilityAction;", "parentValue", "childValue", "invoke", "(Landroidx/compose/ui/semantics/AccessibilityAction;Landroidx/compose/ui/semantics/AccessibilityAction;)Landroidx/compose/ui/semantics/AccessibilityAction;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.ui.semantics.SemanticsPropertiesKt$ActionPropertyKey$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements n {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // S7.n
        public final AccessibilityAction<T> invoke(AccessibilityAction<T> accessibilityAction, AccessibilityAction<T> accessibilityAction2) {
            String label;
            d action;
            if (accessibilityAction == 0 || (label = accessibilityAction.getLabel()) == null) {
                label = accessibilityAction2.getLabel();
            }
            if (accessibilityAction == 0 || (action = accessibilityAction.getAction()) == null) {
                action = accessibilityAction2.getAction();
            }
            return new AccessibilityAction<>(label, action);
        }
    }

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1);
        kotlin.jvm.internal.n nVar = m.f4928a;
        $$delegatedProperties = new t[]{nVar.e(mutablePropertyReference1Impl), b.i(SemanticsPropertiesKt.class, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1, nVar), b.i(SemanticsPropertiesKt.class, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1, nVar), b.i(SemanticsPropertiesKt.class, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, nVar), b.i(SemanticsPropertiesKt.class, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, nVar), b.i(SemanticsPropertiesKt.class, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, nVar), b.i(SemanticsPropertiesKt.class, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, nVar), b.i(SemanticsPropertiesKt.class, "isSensitiveData", "isSensitiveData(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, nVar), b.i(SemanticsPropertiesKt.class, "contentType", "getContentType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", 1, nVar), b.i(SemanticsPropertiesKt.class, "contentDataType", "getContentDataType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentDataType;", 1, nVar), b.i(SemanticsPropertiesKt.class, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1, nVar), b.i(SemanticsPropertiesKt.class, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1, nVar), b.i(SemanticsPropertiesKt.class, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1, nVar), b.i(SemanticsPropertiesKt.class, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, nVar), b.i(SemanticsPropertiesKt.class, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1, nVar), b.i(SemanticsPropertiesKt.class, "textSubstitution", "getTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1, nVar), b.i(SemanticsPropertiesKt.class, "isShowingTextSubstitution", "isShowingTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, nVar), b.i(SemanticsPropertiesKt.class, "inputText", "getInputText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1, nVar), b.i(SemanticsPropertiesKt.class, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1, nVar), b.i(SemanticsPropertiesKt.class, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1, nVar), b.i(SemanticsPropertiesKt.class, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, nVar), b.i(SemanticsPropertiesKt.class, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, nVar), b.i(SemanticsPropertiesKt.class, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1, nVar), b.i(SemanticsPropertiesKt.class, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1, nVar), b.i(SemanticsPropertiesKt.class, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1, nVar), b.i(SemanticsPropertiesKt.class, "isEditable", "isEditable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, nVar), b.i(SemanticsPropertiesKt.class, "maxTextLength", "getMaxTextLength(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, nVar), b.i(SemanticsPropertiesKt.class, "shape", "getShape(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/graphics/Shape;", 1, nVar), b.i(SemanticsPropertiesKt.class, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1, nVar)};
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        semanticsProperties.getStateDescription();
        semanticsProperties.getProgressBarRangeInfo();
        semanticsProperties.getPaneTitle();
        semanticsProperties.getLiveRegion();
        semanticsProperties.getFocused();
        semanticsProperties.getIsContainer();
        semanticsProperties.getIsTraversalGroup();
        semanticsProperties.getIsSensitiveData();
        semanticsProperties.getContentType();
        semanticsProperties.getContentDataType();
        semanticsProperties.getTraversalIndex();
        semanticsProperties.getHorizontalScrollAxisRange();
        semanticsProperties.getVerticalScrollAxisRange();
        semanticsProperties.getRole();
        semanticsProperties.getTestTag();
        semanticsProperties.getTextSubstitution();
        semanticsProperties.getIsShowingTextSubstitution();
        semanticsProperties.getInputText();
        semanticsProperties.getEditableText();
        semanticsProperties.getTextSelectionRange();
        semanticsProperties.getImeAction();
        semanticsProperties.getSelected();
        semanticsProperties.getCollectionInfo();
        semanticsProperties.getCollectionItemInfo();
        semanticsProperties.getToggleableState();
        semanticsProperties.getIsEditable();
        semanticsProperties.getMaxTextLength();
        semanticsProperties.getShape();
        SemanticsActions.INSTANCE.getCustomActions();
    }

    public static final <T> SemanticsPropertyKey<T> AccessibilityKey(String str) {
        return new SemanticsPropertyKey<>(str, true);
    }

    private static final <T extends d> SemanticsPropertyKey<AccessibilityAction<T>> ActionPropertyKey(String str) {
        return new SemanticsPropertyKey<>(str, true, AnonymousClass1.INSTANCE, null, 8, null);
    }

    public static final void clearTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getClearTextSubstitution(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void clearTextSubstitution$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        clearTextSubstitution(semanticsPropertyReceiver, str, aVar);
    }

    public static final void collapse(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCollapse(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void collapse$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        collapse(semanticsPropertyReceiver, str, aVar);
    }

    public static final void copyText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCopyText(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void copyText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        copyText(semanticsPropertyReceiver, str, aVar);
    }

    public static final void cutText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCutText(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void cutText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        cutText(semanticsPropertyReceiver, str, aVar);
    }

    public static final void dialog(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIsDialog(), r.f317a);
    }

    public static final void disabled(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getDisabled(), r.f317a);
    }

    public static final void dismiss(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getDismiss(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void dismiss$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        dismiss(semanticsPropertyReceiver, str, aVar);
    }

    public static final void error(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getError(), str);
    }

    public static final void expand(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getExpand(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void expand$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        expand(semanticsPropertyReceiver, str, aVar);
    }

    public static final CollectionInfo getCollectionInfo(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getCollectionInfo().getValue(semanticsPropertyReceiver, $$delegatedProperties[22]);
    }

    public static final CollectionItemInfo getCollectionItemInfo(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getCollectionItemInfo().getValue(semanticsPropertyReceiver, $$delegatedProperties[23]);
    }

    public static final ContentDataType getContentDataType(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getContentDataType().getValue(semanticsPropertyReceiver, $$delegatedProperties[9]);
    }

    public static final String getContentDescription(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return (String) throwSemanticsGetNotSupported();
    }

    public static final ContentType getContentType(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getContentType().getValue(semanticsPropertyReceiver, $$delegatedProperties[8]);
    }

    public static final List<CustomAccessibilityAction> getCustomActions(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsActions.INSTANCE.getCustomActions().getValue(semanticsPropertyReceiver, $$delegatedProperties[28]);
    }

    public static final AnnotatedString getEditableText(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getEditableText().getValue(semanticsPropertyReceiver, $$delegatedProperties[18]);
    }

    public static final boolean getFocused(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getFocused().getValue(semanticsPropertyReceiver, $$delegatedProperties[4]).booleanValue();
    }

    public static final ScrollAxisRange getHorizontalScrollAxisRange(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().getValue(semanticsPropertyReceiver, $$delegatedProperties[11]);
    }

    @c
    public static final int getImeAction(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getImeAction().getValue(semanticsPropertyReceiver, $$delegatedProperties[20]).getValue();
    }

    @c
    public static /* synthetic */ void getImeAction$annotations(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    public static final AnnotatedString getInputText(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getInputText().getValue(semanticsPropertyReceiver, $$delegatedProperties[17]);
    }

    public static final int getLiveRegion(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getLiveRegion().getValue(semanticsPropertyReceiver, $$delegatedProperties[3]).getValue();
    }

    public static final int getMaxTextLength(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getMaxTextLength().getValue(semanticsPropertyReceiver, $$delegatedProperties[26]).intValue();
    }

    public static final String getPaneTitle(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getPaneTitle().getValue(semanticsPropertyReceiver, $$delegatedProperties[2]);
    }

    public static final ProgressBarRangeInfo getProgressBarRangeInfo(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getProgressBarRangeInfo().getValue(semanticsPropertyReceiver, $$delegatedProperties[1]);
    }

    public static final int getRole(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getRole().getValue(semanticsPropertyReceiver, $$delegatedProperties[13]).getValue();
    }

    public static final void getScrollViewportLength(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, final a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getGetScrollViewportLength(), new AccessibilityAction(str, new k() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt.getScrollViewportLength.1
            {
                super(1);
            }

            @Override // S7.k
            public final Boolean invoke(List<Float> list) {
                boolean z10;
                Float f = (Float) aVar.invoke();
                if (f == null) {
                    z10 = false;
                } else {
                    list.add(f);
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        }));
    }

    public static /* synthetic */ void getScrollViewportLength$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        getScrollViewportLength(semanticsPropertyReceiver, str, aVar);
    }

    public static final boolean getSelected(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getSelected().getValue(semanticsPropertyReceiver, $$delegatedProperties[21]).booleanValue();
    }

    public static final Shape getShape(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getShape().getValue(semanticsPropertyReceiver, $$delegatedProperties[27]);
    }

    public static final String getStateDescription(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getStateDescription().getValue(semanticsPropertyReceiver, $$delegatedProperties[0]);
    }

    public static final String getTestTag(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getTestTag().getValue(semanticsPropertyReceiver, $$delegatedProperties[14]);
    }

    public static final AnnotatedString getText(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return (AnnotatedString) throwSemanticsGetNotSupported();
    }

    public static final void getTextLayoutResult(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getGetTextLayoutResult(), new AccessibilityAction(str, kVar));
    }

    public static /* synthetic */ void getTextLayoutResult$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        getTextLayoutResult(semanticsPropertyReceiver, str, kVar);
    }

    public static final long getTextSelectionRange(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getTextSelectionRange().getValue(semanticsPropertyReceiver, $$delegatedProperties[19]).getPackedValue();
    }

    public static final AnnotatedString getTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getTextSubstitution().getValue(semanticsPropertyReceiver, $$delegatedProperties[15]);
    }

    public static final ToggleableState getToggleableState(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getToggleableState().getValue(semanticsPropertyReceiver, $$delegatedProperties[24]);
    }

    public static final float getTraversalIndex(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getTraversalIndex().getValue(semanticsPropertyReceiver, $$delegatedProperties[10]).floatValue();
    }

    public static final ScrollAxisRange getVerticalScrollAxisRange(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().getValue(semanticsPropertyReceiver, $$delegatedProperties[12]);
    }

    public static final void heading(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getHeading(), r.f317a);
    }

    public static final void hideFromAccessibility(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getHideFromAccessibility(), r.f317a);
    }

    public static final void indexForKey(SemanticsPropertyReceiver semanticsPropertyReceiver, k kVar) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIndexForKey(), kVar);
    }

    public static final void insertTextAtCursor(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getInsertTextAtCursor(), new AccessibilityAction(str, kVar));
    }

    public static /* synthetic */ void insertTextAtCursor$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        insertTextAtCursor(semanticsPropertyReceiver, str, kVar);
    }

    @c
    public static final void invisibleToUser(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getInvisibleToUser(), r.f317a);
    }

    public static final boolean isContainer(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getIsContainer().getValue(semanticsPropertyReceiver, $$delegatedProperties[5]).booleanValue();
    }

    @c
    public static /* synthetic */ void isContainer$annotations(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    public static final boolean isEditable(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getIsEditable().getValue(semanticsPropertyReceiver, $$delegatedProperties[25]).booleanValue();
    }

    public static final boolean isSensitiveData(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getIsSensitiveData().getValue(semanticsPropertyReceiver, $$delegatedProperties[7]).booleanValue();
    }

    public static final boolean isShowingTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().getValue(semanticsPropertyReceiver, $$delegatedProperties[16]).booleanValue();
    }

    public static final boolean isTraversalGroup(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getIsTraversalGroup().getValue(semanticsPropertyReceiver, $$delegatedProperties[6]).booleanValue();
    }

    public static final void onAutofillText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnAutofillText(), new AccessibilityAction(str, kVar));
    }

    public static /* synthetic */ void onAutofillText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onAutofillText(semanticsPropertyReceiver, str, kVar);
    }

    public static final void onClick(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnClick(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void onClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onClick(semanticsPropertyReceiver, str, aVar);
    }

    /* renamed from: onImeAction-9UiTYpY, reason: not valid java name */
    public static final void m6096onImeAction9UiTYpY(SemanticsPropertyReceiver semanticsPropertyReceiver, int i, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getImeAction(), ImeAction.m6474boximpl(i));
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnImeAction(), new AccessibilityAction(str, aVar));
    }

    /* renamed from: onImeAction-9UiTYpY$default, reason: not valid java name */
    public static /* synthetic */ void m6097onImeAction9UiTYpY$default(SemanticsPropertyReceiver semanticsPropertyReceiver, int i, String str, a aVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str = null;
        }
        m6096onImeAction9UiTYpY(semanticsPropertyReceiver, i, str, aVar);
    }

    public static final void onLongClick(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnLongClick(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void onLongClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onLongClick(semanticsPropertyReceiver, str, aVar);
    }

    public static final void pageDown(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPageDown(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void pageDown$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageDown(semanticsPropertyReceiver, str, aVar);
    }

    public static final void pageLeft(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPageLeft(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void pageLeft$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageLeft(semanticsPropertyReceiver, str, aVar);
    }

    public static final void pageRight(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPageRight(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void pageRight$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageRight(semanticsPropertyReceiver, str, aVar);
    }

    public static final void pageUp(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPageUp(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void pageUp$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageUp(semanticsPropertyReceiver, str, aVar);
    }

    public static final void password(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getPassword(), r.f317a);
    }

    public static final void pasteText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPasteText(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void pasteText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pasteText(semanticsPropertyReceiver, str, aVar);
    }

    @c
    public static final void performImeAction(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnImeAction(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void performImeAction$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        performImeAction(semanticsPropertyReceiver, str, aVar);
    }

    public static final void popup(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIsPopup(), r.f317a);
    }

    public static final void requestFocus(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getRequestFocus(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void requestFocus$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        requestFocus(semanticsPropertyReceiver, str, aVar);
    }

    public static final void scrollBy(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, n nVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollBy(), new AccessibilityAction(str, nVar));
    }

    public static /* synthetic */ void scrollBy$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, n nVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        scrollBy(semanticsPropertyReceiver, str, nVar);
    }

    public static final void scrollByOffset(SemanticsPropertyReceiver semanticsPropertyReceiver, n nVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollByOffset(), nVar);
    }

    public static final void scrollToIndex(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollToIndex(), new AccessibilityAction(str, kVar));
    }

    public static /* synthetic */ void scrollToIndex$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        scrollToIndex(semanticsPropertyReceiver, str, kVar);
    }

    public static final void selectableGroup(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getSelectableGroup(), r.f317a);
    }

    public static final void setCollectionInfo(SemanticsPropertyReceiver semanticsPropertyReceiver, CollectionInfo collectionInfo) {
        SemanticsProperties.INSTANCE.getCollectionInfo().setValue(semanticsPropertyReceiver, $$delegatedProperties[22], collectionInfo);
    }

    public static final void setCollectionItemInfo(SemanticsPropertyReceiver semanticsPropertyReceiver, CollectionItemInfo collectionItemInfo) {
        SemanticsProperties.INSTANCE.getCollectionItemInfo().setValue(semanticsPropertyReceiver, $$delegatedProperties[23], collectionItemInfo);
    }

    public static final void setContainer(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        SemanticsProperties.INSTANCE.getIsContainer().setValue(semanticsPropertyReceiver, $$delegatedProperties[5], Boolean.valueOf(z10));
    }

    public static final void setContentDataType(SemanticsPropertyReceiver semanticsPropertyReceiver, ContentDataType contentDataType) {
        SemanticsProperties.INSTANCE.getContentDataType().setValue(semanticsPropertyReceiver, $$delegatedProperties[9], contentDataType);
    }

    public static final void setContentDescription(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getContentDescription(), o.M(str));
    }

    public static final void setContentType(SemanticsPropertyReceiver semanticsPropertyReceiver, ContentType contentType) {
        SemanticsProperties.INSTANCE.getContentType().setValue(semanticsPropertyReceiver, $$delegatedProperties[8], contentType);
    }

    public static final void setCustomActions(SemanticsPropertyReceiver semanticsPropertyReceiver, List<CustomAccessibilityAction> list) {
        SemanticsActions.INSTANCE.getCustomActions().setValue(semanticsPropertyReceiver, $$delegatedProperties[28], list);
    }

    public static final void setEditable(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        SemanticsProperties.INSTANCE.getIsEditable().setValue(semanticsPropertyReceiver, $$delegatedProperties[25], Boolean.valueOf(z10));
    }

    public static final void setEditableText(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        SemanticsProperties.INSTANCE.getEditableText().setValue(semanticsPropertyReceiver, $$delegatedProperties[18], annotatedString);
    }

    public static final void setFocused(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        SemanticsProperties.INSTANCE.getFocused().setValue(semanticsPropertyReceiver, $$delegatedProperties[4], Boolean.valueOf(z10));
    }

    public static final void setHorizontalScrollAxisRange(SemanticsPropertyReceiver semanticsPropertyReceiver, ScrollAxisRange scrollAxisRange) {
        SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().setValue(semanticsPropertyReceiver, $$delegatedProperties[11], scrollAxisRange);
    }

    @c
    /* renamed from: setImeAction-4L7nppU, reason: not valid java name */
    public static final void m6098setImeAction4L7nppU(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getImeAction().setValue(semanticsPropertyReceiver, $$delegatedProperties[20], ImeAction.m6474boximpl(i));
    }

    public static final void setInputText(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        SemanticsProperties.INSTANCE.getInputText().setValue(semanticsPropertyReceiver, $$delegatedProperties[17], annotatedString);
    }

    /* renamed from: setLiveRegion-hR3wRGc, reason: not valid java name */
    public static final void m6099setLiveRegionhR3wRGc(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getLiveRegion().setValue(semanticsPropertyReceiver, $$delegatedProperties[3], LiveRegionMode.m6065boximpl(i));
    }

    public static final void setMaxTextLength(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getMaxTextLength().setValue(semanticsPropertyReceiver, $$delegatedProperties[26], Integer.valueOf(i));
    }

    public static final void setPaneTitle(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsProperties.INSTANCE.getPaneTitle().setValue(semanticsPropertyReceiver, $$delegatedProperties[2], str);
    }

    public static final void setProgress(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetProgress(), new AccessibilityAction(str, kVar));
    }

    public static /* synthetic */ void setProgress$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setProgress(semanticsPropertyReceiver, str, kVar);
    }

    public static final void setProgressBarRangeInfo(SemanticsPropertyReceiver semanticsPropertyReceiver, ProgressBarRangeInfo progressBarRangeInfo) {
        SemanticsProperties.INSTANCE.getProgressBarRangeInfo().setValue(semanticsPropertyReceiver, $$delegatedProperties[1], progressBarRangeInfo);
    }

    /* renamed from: setRole-kuIjeqM, reason: not valid java name */
    public static final void m6100setRolekuIjeqM(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getRole().setValue(semanticsPropertyReceiver, $$delegatedProperties[13], Role.m6074boximpl(i));
    }

    public static final void setSelected(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        SemanticsProperties.INSTANCE.getSelected().setValue(semanticsPropertyReceiver, $$delegatedProperties[21], Boolean.valueOf(z10));
    }

    public static final void setSelection(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, S7.o oVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetSelection(), new AccessibilityAction(str, oVar));
    }

    public static /* synthetic */ void setSelection$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, S7.o oVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setSelection(semanticsPropertyReceiver, str, oVar);
    }

    public static final void setSensitiveData(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        SemanticsProperties.INSTANCE.getIsSensitiveData().setValue(semanticsPropertyReceiver, $$delegatedProperties[7], Boolean.valueOf(z10));
    }

    public static final void setShape(SemanticsPropertyReceiver semanticsPropertyReceiver, Shape shape) {
        SemanticsProperties.INSTANCE.getShape().setValue(semanticsPropertyReceiver, $$delegatedProperties[27], shape);
    }

    public static final void setShowingTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().setValue(semanticsPropertyReceiver, $$delegatedProperties[16], Boolean.valueOf(z10));
    }

    public static final void setStateDescription(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsProperties.INSTANCE.getStateDescription().setValue(semanticsPropertyReceiver, $$delegatedProperties[0], str);
    }

    public static final void setTestTag(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsProperties.INSTANCE.getTestTag().setValue(semanticsPropertyReceiver, $$delegatedProperties[14], str);
    }

    public static final void setText(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getText(), o.M(annotatedString));
    }

    public static /* synthetic */ void setText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setText(semanticsPropertyReceiver, str, kVar);
    }

    /* renamed from: setTextSelectionRange-FDrldGo, reason: not valid java name */
    public static final void m6101setTextSelectionRangeFDrldGo(SemanticsPropertyReceiver semanticsPropertyReceiver, long j5) {
        SemanticsProperties.INSTANCE.getTextSelectionRange().setValue(semanticsPropertyReceiver, $$delegatedProperties[19], TextRange.m6299boximpl(j5));
    }

    public static final void setTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        SemanticsProperties.INSTANCE.getTextSubstitution().setValue(semanticsPropertyReceiver, $$delegatedProperties[15], annotatedString);
    }

    public static /* synthetic */ void setTextSubstitution$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setTextSubstitution(semanticsPropertyReceiver, str, kVar);
    }

    public static final void setToggleableState(SemanticsPropertyReceiver semanticsPropertyReceiver, ToggleableState toggleableState) {
        SemanticsProperties.INSTANCE.getToggleableState().setValue(semanticsPropertyReceiver, $$delegatedProperties[24], toggleableState);
    }

    public static final void setTraversalGroup(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        SemanticsProperties.INSTANCE.getIsTraversalGroup().setValue(semanticsPropertyReceiver, $$delegatedProperties[6], Boolean.valueOf(z10));
    }

    public static final void setTraversalIndex(SemanticsPropertyReceiver semanticsPropertyReceiver, float f) {
        SemanticsProperties.INSTANCE.getTraversalIndex().setValue(semanticsPropertyReceiver, $$delegatedProperties[10], Float.valueOf(f));
    }

    public static final void setVerticalScrollAxisRange(SemanticsPropertyReceiver semanticsPropertyReceiver, ScrollAxisRange scrollAxisRange) {
        SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().setValue(semanticsPropertyReceiver, $$delegatedProperties[12], scrollAxisRange);
    }

    public static final void showTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getShowTextSubstitution(), new AccessibilityAction(str, kVar));
    }

    public static /* synthetic */ void showTextSubstitution$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        showTextSubstitution(semanticsPropertyReceiver, str, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T throwSemanticsGetNotSupported() {
        throw new UnsupportedOperationException("You cannot retrieve a semantics property directly - use one of the SemanticsConfiguration.getOr* methods instead");
    }

    public static final <T> SemanticsPropertyKey<T> AccessibilityKey(String str, n nVar) {
        return new SemanticsPropertyKey<>(str, true, nVar, null, 8, null);
    }

    public static final void setText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetText(), new AccessibilityAction(str, kVar));
    }

    public static final void setTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, k kVar) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetTextSubstitution(), new AccessibilityAction(str, kVar));
    }
}
