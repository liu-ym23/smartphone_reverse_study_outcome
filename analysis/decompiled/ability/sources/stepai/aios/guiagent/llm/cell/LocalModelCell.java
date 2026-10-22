package stepai.aios.guiagent.llm.cell;

import Ba.g;
import D7.v;
import H4.o;
import J7.c;
import N9.j;
import android.util.Size;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import j9.C1614h;
import j9.InterfaceC1616j;
import j9.l;
import j9.m;
import j9.n;
import j9.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.config.StateCompressionConfig;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.MessageRole;
import stepai.aios.guiagent.llm.config.LlmMessageBuilder;
import stepai.aios.guiagent.llm.parser.AbsModelCell;
import stepai.aios.guiagent.llm.parser.GUIAgentMode;
import stepai.aios.guiagent.llm.parser.ModelParam;
import stepai.aios.guiagent.llm.parser.ModelRequestPayload;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 ½\u00012\u00020\u0001:\b¾\u0001¿\u0001À\u0001½\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0014\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJD\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0004\b\u001a\u0010!J>\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0004\b\u001d\u0010!J'\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\"\u0010#J+\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b&\u0010'J7\u0010,\u001a\u001a\u0012\u0004\u0012\u00020*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0+0)2\u0006\u0010(\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b,\u0010-JG\u00104\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\f2\b\u0010/\u001a\u0004\u0018\u00010\f2\u000e\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u00182\b\u00102\u001a\u0004\u0018\u00010\f2\b\u00103\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u0002062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010<\u001a\u00020\n2\u0006\u00109\u001a\u0002062\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b<\u0010=J5\u0010>\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u00109\u001a\u0002062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b>\u0010?J%\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010@\u001a\u00020\f2\u0006\u00109\u001a\u000206H\u0002¢\u0006\u0004\bA\u0010BJ'\u0010F\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\fH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\f2\u0006\u00109\u001a\u000206H\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\f2\u0006\u0010J\u001a\u00020\fH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\bM\u0010NJ\u001f\u0010O\u001a\u00020\n2\u0006\u0010C\u001a\u00020\f2\u0006\u00109\u001a\u000206H\u0002¢\u0006\u0004\bO\u0010PJ0\u0010Q\u001a\u00020\n2\u0006\u0010C\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\f2\u0006\u00109\u001a\u000206H\u0082@¢\u0006\u0004\bQ\u0010RJ\u007f\u0010_\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]0\\j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]`^2\u0006\u00109\u001a\u0002062\u0006\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020\f2\u0006\u0010V\u001a\u0002002\b\u0010W\u001a\u0004\u0018\u0001002\b\u0010X\u001a\u0004\u0018\u0001002\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\f2\b\u0010Z\u001a\u0004\u0018\u00010\f2\b\u0010[\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b_\u0010`J/\u0010d\u001a\u0002002\u0006\u0010V\u001a\u0002002\u0006\u0010a\u001a\u0002002\u0006\u0010b\u001a\u0002002\u0006\u0010c\u001a\u000200H\u0002¢\u0006\u0004\bd\u0010eJ9\u0010g\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f2\b\u0010f\u001a\u0004\u0018\u00010\f2\u0006\u0010W\u001a\u0002002\u0006\u0010X\u001a\u0002002\u0006\u00109\u001a\u000206H\u0002¢\u0006\u0004\bg\u0010hJ9\u0010j\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f2\b\u0010i\u001a\u0004\u0018\u00010\f2\u0006\u0010W\u001a\u0002002\u0006\u0010X\u001a\u0002002\u0006\u00109\u001a\u000206H\u0002¢\u0006\u0004\bj\u0010hJ3\u0010n\u001a\u00020\f2\u0006\u0010k\u001a\u0002002\u0006\u0010m\u001a\u00020l2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]0+H\u0002¢\u0006\u0004\bn\u0010oJ\u0017\u0010q\u001a\u00020\f2\u0006\u00109\u001a\u00020pH\u0002¢\u0006\u0004\bq\u0010rJ3\u0010t\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\\j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`^2\u0006\u0010s\u001a\u00020\fH\u0002¢\u0006\u0004\bt\u0010uJ%\u0010w\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010)2\u0006\u0010v\u001a\u00020\fH\u0002¢\u0006\u0004\bw\u0010xJ+\u0010|\u001a\u0004\u0018\u00010\f2\b\u0010y\u001a\u0004\u0018\u00010\f2\u0006\u0010z\u001a\u00020\f2\u0006\u0010{\u001a\u00020\fH\u0002¢\u0006\u0004\b|\u0010GJ4\u0010\u007f\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]0}j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]`~2\u0006\u0010(\u001a\u00020\fH\u0002¢\u0006\u0005\b\u007f\u0010\u0080\u0001J:\u0010\u0082\u0001\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]\u0018\u00010\\j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]\u0018\u0001`^2\u0007\u0010\u0081\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0082\u0001\u0010uJ!\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0007\u0010\u0083\u0001\u001a\u00020\fH\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\f2\u0006\u00102\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0086\u0001\u0010LJ\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\f2\u0006\u0010s\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0087\u0001\u0010LJ9\u0010\u0089\u0001\u001a\u0004\u0018\u00010*2#\u0010\u0088\u0001\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]0}j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]`~H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001JS\u0010\u008b\u0001\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]0}j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]`~2#\u0010\u0088\u0001\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]0}j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]`~H\u0002¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001JN\u0010\u008e\u0001\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0+2#\u0010\u0088\u0001\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]0}j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]`~2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J4\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u0002000\u00182\b\u00102\u001a\u0004\u0018\u00010]2\u0007\u0010\u008d\u0001\u001a\u00020\f2\u0007\u0010\u0090\u0001\u001a\u00020\fH\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001b\u0010\u0093\u0001\u001a\u00020\f2\b\u0010s\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0005\b\u0093\u0001\u0010LJ\u001b\u0010\u0094\u0001\u001a\u00020\f2\b\u0010s\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0005\b\u0094\u0001\u0010LJ&\u0010\u0097\u0001\u001a\u00020\f2\u0007\u0010\u0095\u0001\u001a\u00020\f2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001a\u0010\u0099\u0001\u001a\u00020\n2\u0007\u0010\u0095\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0099\u0001\u0010\u000fJ\u001a\u0010\u009a\u0001\u001a\u00020\n2\u0007\u0010\u0095\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u009a\u0001\u0010\u000fJ\u001c\u0010\u009b\u0001\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\"\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\b\u00102\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u0085\u0001J'\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\r\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0002¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J0\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\r\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0007\u0010¡\u0001\u001a\u000200H\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J/\u0010¥\u0001\u001a\u00020\f2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020]0+2\u0007\u0010¤\u0001\u001a\u00020\fH\u0002¢\u0006\u0006\b¥\u0001\u0010¦\u0001R\u001f\u0010§\u0001\u001a\u00020\f8\u0016X\u0096D¢\u0006\u0010\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001R\u001f\u0010«\u0001\u001a\u00020\f8\u0016X\u0096D¢\u0006\u0010\n\u0006\b«\u0001\u0010¨\u0001\u001a\u0006\b¬\u0001\u0010ª\u0001R\u001f\u0010\u00ad\u0001\u001a\u00020\f8\u0016X\u0096D¢\u0006\u0010\n\u0006\b\u00ad\u0001\u0010¨\u0001\u001a\u0006\b®\u0001\u0010ª\u0001R&\u0010°\u0001\u001a\t\u0012\u0005\u0012\u00030¯\u00010\u00188\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001R\u001f\u0010´\u0001\u001a\u00020S8\u0014X\u0094D¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R$\u0010¹\u0001\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002060¸\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u0017\u0010¼\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b»\u0001\u0010ª\u0001¨\u0006Á\u0001"}, d2 = {"Lstepai/aios/guiagent/llm/cell/LocalModelCell;", "Lstepai/aios/guiagent/llm/parser/AbsModelCell;", AppAgent.CONSTRUCT, "()V", "Lstepai/aios/guiagent/llm/parser/ModelParam;", "getModelParam", "()Lstepai/aios/guiagent/llm/parser/ModelParam;", "Landroid/util/Size;", "getCompressBitmapSize", "()Landroid/util/Size;", "LC7/r;", "clearCache", "", "sessionId", "removeSession", "(Ljava/lang/String;)V", "Lza/e;", "session", "question", "answer", "handleInquiry", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)V", "imageBase64", "imageUrl", "", "Lstepai/aios/guiagent/llm/Message;", "generateRequestMessage", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lstepai/aios/guiagent/llm/parser/ModelRequestPayload;", "generateRequestPayload", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Lstepai/aios/guiagent/llm/parser/ModelRequestPayload;", "Lstepai/aios/guiagent/config/LlmConfig;", "llmConfig", "(Lza/e;Ljava/lang/String;Lstepai/aios/guiagent/config/LlmConfig;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "buildRequestMessage", "(Lza/e;Ljava/lang/String;)Ljava/util/List;", "Lstepai/aios/guiagent/llm/config/LlmMessageBuilder;", "builder", "appendImageContent", "(Lstepai/aios/guiagent/llm/config/LlmMessageBuilder;Ljava/lang/String;Ljava/lang/String;)V", "response", "Lkotlin/Pair;", "Lstepai/aios/guiagent/config/ActionType;", "", "buildResponseAction", "(Ljava/lang/String;Lza/e;)Lkotlin/Pair;", "explain", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "point", "value", "summary", "injectExperienceAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Lstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;", "getSessionState", "(Ljava/lang/String;)Lstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;", "state", "Lstepai/aios/guiagent/config/StateCompressionConfig;", "config", "applyCompressionConfig", "(Lstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;Lstepai/aios/guiagent/config/StateCompressionConfig;)V", "prepareRequestState", "(Lza/e;Ljava/lang/String;Lstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;Ljava/lang/String;)Ljava/lang/String;", "taskWithApp", "renderRequestMessages", "(Ljava/lang/String;Lstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;)Ljava/util/List;", "task", "summaryHistory", "userComment", "buildStatusPrompt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "buildSummaryHistory", "(Lstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;)Ljava/lang/String;", "compressedText", "extractCompressedSummary", "(Ljava/lang/String;)Ljava/lang/String;", "buildTaskWithApp", "(Lza/e;)Ljava/lang/String;", "maybeCompressHistory", "(Ljava/lang/String;Lstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;)V", "maybeCompressHistoryWithLlm", "(Ljava/lang/String;Lstepai/aios/guiagent/config/LlmConfig;Ljava/lang/String;Lstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;LH7/c;)Ljava/lang/Object;", "", "triggered", "mode", "currentStep", "chunkStartStep", "chunkEndStep", "compressionTraceId", "reason", "detail", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "buildCompressionInfo", "(Lstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;ZLjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/LinkedHashMap;", "lastCompressedUptoStep", "interval", "recentWindow", "computeCompressionTarget", "(IIII)I", "previousCompressedStateText", "buildFallbackCompressedState", "(Ljava/lang/String;Ljava/lang/String;IILstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;)Ljava/lang/String;", "previousCompressedState", "buildCompressionPrompt", "stepIdx", "Lstepai/aios/guiagent/llm/cell/LocalModelCell$EnvironmentEntry;", "env", "stepRecordToText", "(ILstepai/aios/guiagent/llm/cell/LocalModelCell$EnvironmentEntry;Ljava/util/Map;)Ljava/lang/String;", "Lstepai/aios/guiagent/llm/cell/LocalModelCell$CompressedState;", "compressedStateToText", "(Lstepai/aios/guiagent/llm/cell/LocalModelCell$CompressedState;)Ljava/lang/String;", "text", "parseCompressedStateText", "(Ljava/lang/String;)Ljava/util/LinkedHashMap;", "line", "matchCompressedStateField", "(Ljava/lang/String;)Lkotlin/Pair;", "compressedState", "fallbackTask", "fallbackCoveredSteps", "normalizeCompressedState", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "parseParam", "(Ljava/lang/String;)Ljava/util/HashMap;", "rawText", "parseJsonParam", "body", "splitTopLevelJsonFields", "(Ljava/lang/String;)Ljava/util/List;", "unquoteJsonScalar", "extractJsonObject", "paramMap", "parseActionType", "(Ljava/util/HashMap;)Lstepai/aios/guiagent/config/ActionType;", "transformLocalAction", "(Ljava/util/HashMap;)Ljava/util/HashMap;", "actionType", "parseActionParam", "(Ljava/util/HashMap;Ljava/lang/String;)Ljava/util/Map;", "fieldName", "requirePoint", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "stripThink", "summarizeForLog", "message", "responsePreview", "buildCompressionFailureDetail", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "safeLogI", "safeLogE", "stringifyFieldValue", "(Ljava/lang/Object;)Ljava/lang/String;", "listifyTextField", "items", "dedupPreserveOrder", "(Ljava/util/List;)Ljava/util/List;", "maxItems", "truncateItems", "(Ljava/util/List;I)Ljava/util/List;", "key", "getActionString", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", HintConstants.AUTOFILL_HINT_NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "desc", "getDesc", "type", "getType", "Lstepai/aios/guiagent/llm/parser/GUIAgentMode;", "supportedMode", "Ljava/util/List;", "getSupportedMode", "()Ljava/util/List;", "userImageBeforeText", "Z", "getUserImageBeforeText", "()Z", "Ljava/util/concurrent/ConcurrentHashMap;", "sessionStates", "Ljava/util/concurrent/ConcurrentHashMap;", "getSystemPrompt", "systemPrompt", "Companion", "SessionRuntimeState", "EnvironmentEntry", "CompressedState", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public class LocalModelCell extends AbsModelCell {
    private static final String COMPRESSED_STATE_END = "<<<END_STATE_COMPRESSION>>>";
    private static final String COMPRESSED_STATE_START = "<<<STATE_COMPRESSION>>>";
    private static final int MAX_COMPRESSION_LOG_CHARS = 800;
    private static final String TAG = "LocalModelCell";
    private final boolean userImageBeforeText;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> COMPRESSED_STATE_FIELDS = o.N("covered_steps", "task", "important_user_inputs", "important_observations", "completed_progress", "current_subgoal", "pending_risks", "last_effective_state");
    private static final LinkedHashMap<String, String> COMPRESSED_STATE_FIELD_ALIASES = a.O(new Pair("covered_step", "covered_steps"), new Pair("steps_covered", "covered_steps"), new Pair("user_inputs", "important_user_inputs"), new Pair("important_inputs", "important_user_inputs"), new Pair("page_observations", "important_observations"), new Pair("observations", "important_observations"), new Pair("summary", "completed_progress"), new Pair("key_process", "completed_progress"), new Pair("key_progress", "completed_progress"), new Pair("current_goal", "current_subgoal"), new Pair("subgoal", "current_subgoal"), new Pair("risk", "pending_risks"), new Pair("risks", "pending_risks"), new Pair("potential_risks", "pending_risks"), new Pair("risk_items", "pending_risks"), new Pair("last_state", "last_effective_state"), new Pair("last_valid_state", "last_effective_state"));
    private static final String DEFAULT_SKILL = "你是一个手机 GUI-Agent 操作专家，你需要根据用户下发的任务、手机屏幕截图和交互操作的历史记录，借助既定的动作空间与手机进行交互，从而完成用户的任务。\n请牢记，手机屏幕坐标系以左上角为原点，x轴向右，y轴向下，取值范围均为 0-1000。\n# 行动原则：\n1. 你需要明确记录自己上一次的action，如果是滑动，不能超过5次。\n2. 你需要严格遵循用户的指令，如果你和用户进行过对话，需要更遵守最后一轮的指令\n# Action Space:\n在 Android 手机的场景下，你的动作空间包含以下9类操作，所有输出都必须遵守对应的参数要求：\n1. CLICK：点击手机屏幕坐标，需包含点击的坐标位置 point。\n例如：action:CLICK\\tpoint:x,y\n2. TYPE：在手机输入框中输入文字，需包含输入内容 value、输入框的位置 point。\n例如：action:TYPE\\tvalue:输入内容\\tpoint:x,y\n3. COMPLETE：任务完成后向用户报告结果，需包含报告的内容 value。\n例如：action:COMPLETE\\treturn:完成任务后向用户报告的内容\n4. WAIT：等待指定时长，需包含等待时间 value（秒）。\n例如：action:WAIT\\tvalue:等待时间\n5. AWAKE：唤醒指定应用，需包含唤醒的应用名称 value。\n例如：action:AWAKE\\tvalue:应用名称\n6. INFO：询问用户问题或详细信息，需包含提问内容 value。\n例如：action:INFO\\tvalue:提问内容\n7. ABORT：终止当前任务，仅在当前任务无法继续执行时使用，需包含 value 说明原因。\n例如：action:ABORT\\tvalue:终止任务的原因\n8. SLIDE：在手机屏幕上滑动，滑动的方向不限，需包含起点 point1 和终点 point2。\n例如：action:SLIDE\\tpoint1:x1,y1\\tpoint2:x2,y2\n9. LONGPRESS：长按手机屏幕坐标，需包含长按的坐标位置 point。\n例如：action:LONGPRESS\\tpoint:x,y";
    private final String name = "Local-VLM";
    private final String desc = "端侧视觉语言模型";
    private final String type = "LocalModelCell";
    private final List<GUIAgentMode> supportedMode = o.M(GUIAgentMode.NO_PATH);
    private final ConcurrentHashMap<String, SessionRuntimeState> sessionStates = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\rj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lstepai/aios/guiagent/llm/cell/LocalModelCell$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "MAX_COMPRESSION_LOG_CHARS", "", "COMPRESSED_STATE_START", "COMPRESSED_STATE_END", "COMPRESSED_STATE_FIELDS", "", "COMPRESSED_STATE_FIELD_ALIASES", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "DEFAULT_SKILL", "getDEFAULT_SKILL", "()Ljava/lang/String;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final String getDEFAULT_SKILL() {
            return LocalModelCell.DEFAULT_SKILL;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Jq\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"}, d2 = {"Lstepai/aios/guiagent/llm/cell/LocalModelCell$CompressedState;", "", "coveredSteps", "", "task", "importantUserInputs", "", "importantObservations", "completedProgress", "currentSubgoal", "pendingRisks", "lastEffectiveState", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCoveredSteps", "()Ljava/lang/String;", "getTask", "getImportantUserInputs", "()Ljava/util/List;", "getImportantObservations", "getCompletedProgress", "getCurrentSubgoal", "getPendingRisks", "getLastEffectiveState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CompressedState {
        private final List<String> completedProgress;
        private final String coveredSteps;
        private final String currentSubgoal;
        private final List<String> importantObservations;
        private final List<String> importantUserInputs;
        private final String lastEffectiveState;
        private final List<String> pendingRisks;
        private final String task;

        public CompressedState(String coveredSteps, String task, List<String> importantUserInputs, List<String> importantObservations, List<String> completedProgress, String currentSubgoal, List<String> pendingRisks, String lastEffectiveState) {
            k.f(coveredSteps, "coveredSteps");
            k.f(task, "task");
            k.f(importantUserInputs, "importantUserInputs");
            k.f(importantObservations, "importantObservations");
            k.f(completedProgress, "completedProgress");
            k.f(currentSubgoal, "currentSubgoal");
            k.f(pendingRisks, "pendingRisks");
            k.f(lastEffectiveState, "lastEffectiveState");
            this.coveredSteps = coveredSteps;
            this.task = task;
            this.importantUserInputs = importantUserInputs;
            this.importantObservations = importantObservations;
            this.completedProgress = completedProgress;
            this.currentSubgoal = currentSubgoal;
            this.pendingRisks = pendingRisks;
            this.lastEffectiveState = lastEffectiveState;
        }

        public static /* synthetic */ CompressedState copy$default(CompressedState compressedState, String str, String str2, List list, List list2, List list3, String str3, List list4, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = compressedState.coveredSteps;
            }
            if ((i & 2) != 0) {
                str2 = compressedState.task;
            }
            if ((i & 4) != 0) {
                list = compressedState.importantUserInputs;
            }
            if ((i & 8) != 0) {
                list2 = compressedState.importantObservations;
            }
            if ((i & 16) != 0) {
                list3 = compressedState.completedProgress;
            }
            if ((i & 32) != 0) {
                str3 = compressedState.currentSubgoal;
            }
            if ((i & 64) != 0) {
                list4 = compressedState.pendingRisks;
            }
            if ((i & 128) != 0) {
                str4 = compressedState.lastEffectiveState;
            }
            List list5 = list4;
            String str5 = str4;
            List list6 = list3;
            String str6 = str3;
            return compressedState.copy(str, str2, list, list2, list6, str6, list5, str5);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCoveredSteps() {
            return this.coveredSteps;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTask() {
            return this.task;
        }

        public final List<String> component3() {
            return this.importantUserInputs;
        }

        public final List<String> component4() {
            return this.importantObservations;
        }

        public final List<String> component5() {
            return this.completedProgress;
        }

        /* renamed from: component6, reason: from getter */
        public final String getCurrentSubgoal() {
            return this.currentSubgoal;
        }

        public final List<String> component7() {
            return this.pendingRisks;
        }

        /* renamed from: component8, reason: from getter */
        public final String getLastEffectiveState() {
            return this.lastEffectiveState;
        }

        public final CompressedState copy(String coveredSteps, String task, List<String> importantUserInputs, List<String> importantObservations, List<String> completedProgress, String currentSubgoal, List<String> pendingRisks, String lastEffectiveState) {
            k.f(coveredSteps, "coveredSteps");
            k.f(task, "task");
            k.f(importantUserInputs, "importantUserInputs");
            k.f(importantObservations, "importantObservations");
            k.f(completedProgress, "completedProgress");
            k.f(currentSubgoal, "currentSubgoal");
            k.f(pendingRisks, "pendingRisks");
            k.f(lastEffectiveState, "lastEffectiveState");
            return new CompressedState(coveredSteps, task, importantUserInputs, importantObservations, completedProgress, currentSubgoal, pendingRisks, lastEffectiveState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CompressedState)) {
                return false;
            }
            CompressedState compressedState = (CompressedState) other;
            return k.b(this.coveredSteps, compressedState.coveredSteps) && k.b(this.task, compressedState.task) && k.b(this.importantUserInputs, compressedState.importantUserInputs) && k.b(this.importantObservations, compressedState.importantObservations) && k.b(this.completedProgress, compressedState.completedProgress) && k.b(this.currentSubgoal, compressedState.currentSubgoal) && k.b(this.pendingRisks, compressedState.pendingRisks) && k.b(this.lastEffectiveState, compressedState.lastEffectiveState);
        }

        public final List<String> getCompletedProgress() {
            return this.completedProgress;
        }

        public final String getCoveredSteps() {
            return this.coveredSteps;
        }

        public final String getCurrentSubgoal() {
            return this.currentSubgoal;
        }

        public final List<String> getImportantObservations() {
            return this.importantObservations;
        }

        public final List<String> getImportantUserInputs() {
            return this.importantUserInputs;
        }

        public final String getLastEffectiveState() {
            return this.lastEffectiveState;
        }

        public final List<String> getPendingRisks() {
            return this.pendingRisks;
        }

        public final String getTask() {
            return this.task;
        }

        public int hashCode() {
            return this.lastEffectiveState.hashCode() + androidx.appfunctions.metadata.a.e(this.pendingRisks, B7.a.c(androidx.appfunctions.metadata.a.e(this.completedProgress, androidx.appfunctions.metadata.a.e(this.importantObservations, androidx.appfunctions.metadata.a.e(this.importantUserInputs, B7.a.c(this.coveredSteps.hashCode() * 31, 31, this.task), 31), 31), 31), 31, this.currentSubgoal), 31);
        }

        public String toString() {
            String str = this.coveredSteps;
            String str2 = this.task;
            List<String> list = this.importantUserInputs;
            List<String> list2 = this.importantObservations;
            List<String> list3 = this.completedProgress;
            String str3 = this.currentSubgoal;
            List<String> list4 = this.pendingRisks;
            String str4 = this.lastEffectiveState;
            StringBuilder sbW = B7.a.w("CompressedState(coveredSteps=", str, ", task=", str2, ", importantUserInputs=");
            sbW.append(list);
            sbW.append(", importantObservations=");
            sbW.append(list2);
            sbW.append(", completedProgress=");
            sbW.append(list3);
            sbW.append(", currentSubgoal=");
            sbW.append(str3);
            sbW.append(", pendingRisks=");
            sbW.append(list4);
            sbW.append(", lastEffectiveState=");
            sbW.append(str4);
            sbW.append(")");
            return sbW.toString();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b-\b\u0082\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012*\b\u0002\u0010\u0007\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\t0\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012(\b\u0002\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J+\u00104\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\t0\u0005HÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J)\u00108\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\tHÆ\u0003J\t\u00109\u001a\u00020\u0011HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013HÆ\u0003Jµ\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052*\b\u0002\u0010\u0007\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\t0\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2(\b\u0002\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013HÆ\u0001J\u0013\u0010<\u001a\u00020\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u000eHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR3\u0010\u0007\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R:\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u00101¨\u0006@"}, d2 = {"Lstepai/aios/guiagent/llm/cell/LocalModelCell$SessionRuntimeState;", "", "pendingUserComment", "", "environmentHistory", "", "Lstepai/aios/guiagent/llm/cell/LocalModelCell$EnvironmentEntry;", "actionHistory", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "hasPendingEnvironment", "", "compressedStateText", "compressedUptoStep", "", "lastCompressionInfo", "compressionConfig", "Lstepai/aios/guiagent/config/StateCompressionConfig;", "compressionConfigIssues", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLjava/lang/String;ILjava/util/LinkedHashMap;Lstepai/aios/guiagent/config/StateCompressionConfig;Ljava/util/List;)V", "getPendingUserComment", "()Ljava/lang/String;", "setPendingUserComment", "(Ljava/lang/String;)V", "getEnvironmentHistory", "()Ljava/util/List;", "getActionHistory", "getHasPendingEnvironment", "()Z", "setHasPendingEnvironment", "(Z)V", "getCompressedStateText", "setCompressedStateText", "getCompressedUptoStep", "()I", "setCompressedUptoStep", "(I)V", "getLastCompressionInfo", "()Ljava/util/LinkedHashMap;", "setLastCompressionInfo", "(Ljava/util/LinkedHashMap;)V", "getCompressionConfig", "()Lstepai/aios/guiagent/config/StateCompressionConfig;", "setCompressionConfig", "(Lstepai/aios/guiagent/config/StateCompressionConfig;)V", "getCompressionConfigIssues", "setCompressionConfigIssues", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SessionRuntimeState {
        private final List<LinkedHashMap<String, Object>> actionHistory;
        private String compressedStateText;
        private int compressedUptoStep;
        private StateCompressionConfig compressionConfig;
        private List<String> compressionConfigIssues;
        private final List<EnvironmentEntry> environmentHistory;
        private boolean hasPendingEnvironment;
        private LinkedHashMap<String, Object> lastCompressionInfo;
        private String pendingUserComment;

        public SessionRuntimeState() {
            this(null, null, null, false, null, 0, null, null, null, 511, null);
        }

        public static /* synthetic */ SessionRuntimeState copy$default(SessionRuntimeState sessionRuntimeState, String str, List list, List list2, boolean z10, String str2, int i, LinkedHashMap linkedHashMap, StateCompressionConfig stateCompressionConfig, List list3, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = sessionRuntimeState.pendingUserComment;
            }
            if ((i6 & 2) != 0) {
                list = sessionRuntimeState.environmentHistory;
            }
            if ((i6 & 4) != 0) {
                list2 = sessionRuntimeState.actionHistory;
            }
            if ((i6 & 8) != 0) {
                z10 = sessionRuntimeState.hasPendingEnvironment;
            }
            if ((i6 & 16) != 0) {
                str2 = sessionRuntimeState.compressedStateText;
            }
            if ((i6 & 32) != 0) {
                i = sessionRuntimeState.compressedUptoStep;
            }
            if ((i6 & 64) != 0) {
                linkedHashMap = sessionRuntimeState.lastCompressionInfo;
            }
            if ((i6 & 128) != 0) {
                stateCompressionConfig = sessionRuntimeState.compressionConfig;
            }
            if ((i6 & 256) != 0) {
                list3 = sessionRuntimeState.compressionConfigIssues;
            }
            StateCompressionConfig stateCompressionConfig2 = stateCompressionConfig;
            List list4 = list3;
            int i10 = i;
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            String str3 = str2;
            List list5 = list2;
            return sessionRuntimeState.copy(str, list, list5, z10, str3, i10, linkedHashMap2, stateCompressionConfig2, list4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPendingUserComment() {
            return this.pendingUserComment;
        }

        public final List<EnvironmentEntry> component2() {
            return this.environmentHistory;
        }

        public final List<LinkedHashMap<String, Object>> component3() {
            return this.actionHistory;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getHasPendingEnvironment() {
            return this.hasPendingEnvironment;
        }

        /* renamed from: component5, reason: from getter */
        public final String getCompressedStateText() {
            return this.compressedStateText;
        }

        /* renamed from: component6, reason: from getter */
        public final int getCompressedUptoStep() {
            return this.compressedUptoStep;
        }

        public final LinkedHashMap<String, Object> component7() {
            return this.lastCompressionInfo;
        }

        /* renamed from: component8, reason: from getter */
        public final StateCompressionConfig getCompressionConfig() {
            return this.compressionConfig;
        }

        public final List<String> component9() {
            return this.compressionConfigIssues;
        }

        public final SessionRuntimeState copy(String pendingUserComment, List<EnvironmentEntry> environmentHistory, List<LinkedHashMap<String, Object>> actionHistory, boolean hasPendingEnvironment, String compressedStateText, int compressedUptoStep, LinkedHashMap<String, Object> lastCompressionInfo, StateCompressionConfig compressionConfig, List<String> compressionConfigIssues) {
            k.f(environmentHistory, "environmentHistory");
            k.f(actionHistory, "actionHistory");
            k.f(compressionConfig, "compressionConfig");
            k.f(compressionConfigIssues, "compressionConfigIssues");
            return new SessionRuntimeState(pendingUserComment, environmentHistory, actionHistory, hasPendingEnvironment, compressedStateText, compressedUptoStep, lastCompressionInfo, compressionConfig, compressionConfigIssues);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionRuntimeState)) {
                return false;
            }
            SessionRuntimeState sessionRuntimeState = (SessionRuntimeState) other;
            return k.b(this.pendingUserComment, sessionRuntimeState.pendingUserComment) && k.b(this.environmentHistory, sessionRuntimeState.environmentHistory) && k.b(this.actionHistory, sessionRuntimeState.actionHistory) && this.hasPendingEnvironment == sessionRuntimeState.hasPendingEnvironment && k.b(this.compressedStateText, sessionRuntimeState.compressedStateText) && this.compressedUptoStep == sessionRuntimeState.compressedUptoStep && k.b(this.lastCompressionInfo, sessionRuntimeState.lastCompressionInfo) && k.b(this.compressionConfig, sessionRuntimeState.compressionConfig) && k.b(this.compressionConfigIssues, sessionRuntimeState.compressionConfigIssues);
        }

        public final List<LinkedHashMap<String, Object>> getActionHistory() {
            return this.actionHistory;
        }

        public final String getCompressedStateText() {
            return this.compressedStateText;
        }

        public final int getCompressedUptoStep() {
            return this.compressedUptoStep;
        }

        public final StateCompressionConfig getCompressionConfig() {
            return this.compressionConfig;
        }

        public final List<String> getCompressionConfigIssues() {
            return this.compressionConfigIssues;
        }

        public final List<EnvironmentEntry> getEnvironmentHistory() {
            return this.environmentHistory;
        }

        public final boolean getHasPendingEnvironment() {
            return this.hasPendingEnvironment;
        }

        public final LinkedHashMap<String, Object> getLastCompressionInfo() {
            return this.lastCompressionInfo;
        }

        public final String getPendingUserComment() {
            return this.pendingUserComment;
        }

        public int hashCode() {
            String str = this.pendingUserComment;
            int iD = androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.e(this.actionHistory, androidx.appfunctions.metadata.a.e(this.environmentHistory, (str == null ? 0 : str.hashCode()) * 31, 31), 31), 31, this.hasPendingEnvironment);
            String str2 = this.compressedStateText;
            int iA = androidx.constraintlayout.core.dsl.a.a(this.compressedUptoStep, (iD + (str2 == null ? 0 : str2.hashCode())) * 31, 31);
            LinkedHashMap<String, Object> linkedHashMap = this.lastCompressionInfo;
            return this.compressionConfigIssues.hashCode() + ((this.compressionConfig.hashCode() + ((iA + (linkedHashMap != null ? linkedHashMap.hashCode() : 0)) * 31)) * 31);
        }

        public final void setCompressedStateText(String str) {
            this.compressedStateText = str;
        }

        public final void setCompressedUptoStep(int i) {
            this.compressedUptoStep = i;
        }

        public final void setCompressionConfig(StateCompressionConfig stateCompressionConfig) {
            k.f(stateCompressionConfig, "<set-?>");
            this.compressionConfig = stateCompressionConfig;
        }

        public final void setCompressionConfigIssues(List<String> list) {
            k.f(list, "<set-?>");
            this.compressionConfigIssues = list;
        }

        public final void setHasPendingEnvironment(boolean z10) {
            this.hasPendingEnvironment = z10;
        }

        public final void setLastCompressionInfo(LinkedHashMap<String, Object> linkedHashMap) {
            this.lastCompressionInfo = linkedHashMap;
        }

        public final void setPendingUserComment(String str) {
            this.pendingUserComment = str;
        }

        public String toString() {
            String str = this.pendingUserComment;
            List<EnvironmentEntry> list = this.environmentHistory;
            List<LinkedHashMap<String, Object>> list2 = this.actionHistory;
            boolean z10 = this.hasPendingEnvironment;
            String str2 = this.compressedStateText;
            int i = this.compressedUptoStep;
            LinkedHashMap<String, Object> linkedHashMap = this.lastCompressionInfo;
            StateCompressionConfig stateCompressionConfig = this.compressionConfig;
            List<String> list3 = this.compressionConfigIssues;
            StringBuilder sb = new StringBuilder("SessionRuntimeState(pendingUserComment=");
            sb.append(str);
            sb.append(", environmentHistory=");
            sb.append(list);
            sb.append(", actionHistory=");
            sb.append(list2);
            sb.append(", hasPendingEnvironment=");
            sb.append(z10);
            sb.append(", compressedStateText=");
            b.B(sb, str2, ", compressedUptoStep=", i, ", lastCompressionInfo=");
            sb.append(linkedHashMap);
            sb.append(", compressionConfig=");
            sb.append(stateCompressionConfig);
            sb.append(", compressionConfigIssues=");
            return androidx.appfunctions.metadata.a.q(sb, list3, ")");
        }

        public SessionRuntimeState(String str, List<EnvironmentEntry> environmentHistory, List<LinkedHashMap<String, Object>> actionHistory, boolean z10, String str2, int i, LinkedHashMap<String, Object> linkedHashMap, StateCompressionConfig compressionConfig, List<String> compressionConfigIssues) {
            k.f(environmentHistory, "environmentHistory");
            k.f(actionHistory, "actionHistory");
            k.f(compressionConfig, "compressionConfig");
            k.f(compressionConfigIssues, "compressionConfigIssues");
            this.pendingUserComment = str;
            this.environmentHistory = environmentHistory;
            this.actionHistory = actionHistory;
            this.hasPendingEnvironment = z10;
            this.compressedStateText = str2;
            this.compressedUptoStep = i;
            this.lastCompressionInfo = linkedHashMap;
            this.compressionConfig = compressionConfig;
            this.compressionConfigIssues = compressionConfigIssues;
        }

        public SessionRuntimeState(String str, List list, List list2, boolean z10, String str2, int i, LinkedHashMap linkedHashMap, StateCompressionConfig stateCompressionConfig, List list3, int i6, e eVar) {
            this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? new ArrayList() : list, (i6 & 4) != 0 ? new ArrayList() : list2, (i6 & 8) != 0 ? false : z10, (i6 & 16) != 0 ? null : str2, (i6 & 32) == 0 ? i : 0, (i6 & 64) == 0 ? linkedHashMap : null, (i6 & 128) != 0 ? new StateCompressionConfig(false, 0, 0, 0, 15, null) : stateCompressionConfig, (i6 & 256) != 0 ? EmptyList.f4893a : list3);
        }
    }

    @c(c = "stepai.aios.guiagent.llm.cell.LocalModelCell", f = "LocalModelCell.kt", l = {200}, m = "generateRequestMessage$suspendImpl", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.llm.cell.LocalModelCell$generateRequestMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalModelCell.generateRequestMessage$suspendImpl(LocalModelCell.this, (za.e) null, (String) null, (LlmConfig) null, (String) null, (String) null, (H7.c<? super List<Message>>) this);
        }
    }

    @c(c = "stepai.aios.guiagent.llm.cell.LocalModelCell", f = "LocalModelCell.kt", l = {216}, m = "generateRequestPayload$suspendImpl", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.llm.cell.LocalModelCell$generateRequestPayload$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C19401(H7.c<? super C19401> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalModelCell.generateRequestPayload$suspendImpl(LocalModelCell.this, (za.e) null, (String) null, (LlmConfig) null, (String) null, (String) null, (H7.c<? super ModelRequestPayload>) this);
        }
    }

    @c(c = "stepai.aios.guiagent.llm.cell.LocalModelCell", f = "LocalModelCell.kt", l = {475}, m = "maybeCompressHistoryWithLlm", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.llm.cell.LocalModelCell$maybeCompressHistoryWithLlm$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19411 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C19411(H7.c<? super C19411> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalModelCell.this.maybeCompressHistoryWithLlm(null, null, null, null, this);
        }
    }

    private final void applyCompressionConfig(SessionRuntimeState state, StateCompressionConfig config) {
        state.setCompressionConfigIssues(config.validationIssues());
        state.setCompressionConfig(config.sanitized());
    }

    private final String buildCompressionFailureDetail(String message, String responsePreview) {
        return B7.a.n("message=", summarizeForLog(message), " response_preview=", summarizeForLog(responsePreview));
    }

    private final LinkedHashMap<String, Object> buildCompressionInfo(SessionRuntimeState state, boolean triggered, String mode, int currentStep, Integer chunkStartStep, Integer chunkEndStep, String compressionTraceId, String reason, String detail) {
        return a.O(new Pair("triggered", Boolean.valueOf(triggered)), new Pair("mode", mode), new Pair("reason", reason == null ? "none" : reason), new Pair("detail", detail == null ? "none" : detail), new Pair("enabled", Boolean.valueOf(state.getCompressionConfig().getEnabled())), new Pair("configValid", Boolean.valueOf(state.getCompressionConfigIssues().isEmpty())), new Pair("configIssues", state.getCompressionConfigIssues().isEmpty() ? "none" : v.I0(state.getCompressionConfigIssues(), ",", null, null, null, 62)), new Pair("interval", Integer.valueOf(state.getCompressionConfig().getInterval())), new Pair("recentWindow", Integer.valueOf(state.getCompressionConfig().getRecentWindow())), new Pair("maxFieldItems", Integer.valueOf(state.getCompressionConfig().getMaxFieldItems())), new Pair("currentStep", Integer.valueOf(currentStep)), new Pair("chunkStartStep", Integer.valueOf(chunkStartStep != null ? chunkStartStep.intValue() : 0)), new Pair("chunkEndStep", Integer.valueOf(chunkEndStep != null ? chunkEndStep.intValue() : 0)), new Pair("compressionTraceId", compressionTraceId != null ? compressionTraceId : "none"), new Pair("compressedUptoStep", Integer.valueOf(state.getCompressedUptoStep())), new Pair("rawHistoryStartStep", Integer.valueOf(state.getCompressedUptoStep() + 1)), new Pair("rawHistoryEndStep", Integer.valueOf(state.getEnvironmentHistory().size())));
    }

    public static /* synthetic */ LinkedHashMap buildCompressionInfo$default(LocalModelCell localModelCell, SessionRuntimeState sessionRuntimeState, boolean z10, String str, int i, Integer num, Integer num2, String str2, String str3, String str4, int i6, Object obj) {
        if (obj == null) {
            return localModelCell.buildCompressionInfo(sessionRuntimeState, z10, str, i, num, num2, (i6 & 64) != 0 ? null : str2, str3, str4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildCompressionInfo");
    }

    private final String buildCompressionPrompt(String task, String previousCompressedState, int chunkStartStep, int chunkEndStep, SessionRuntimeState state) {
        LinkedHashMap linkedHashMap;
        String str = null;
        String string = previousCompressedState != null ? m.R0(previousCompressedState).toString() : null;
        if (string != null && string.length() != 0) {
            str = string;
        }
        if (str == null) {
            str = "none";
        }
        StringBuilder sb = new StringBuilder();
        if (chunkStartStep <= chunkEndStep) {
            int i = chunkStartStep;
            while (true) {
                int i6 = i - 1;
                EnvironmentEntry environmentEntry = (EnvironmentEntry) v.D0(i6, state.getEnvironmentHistory());
                if (environmentEntry != null && (linkedHashMap = (LinkedHashMap) v.D0(i6, state.getActionHistory())) != null) {
                    if (sb.length() > 0) {
                        sb.append("\n\n");
                    }
                    sb.append(stepRecordToText(i, environmentEntry, linkedHashMap));
                }
                if (i == chunkEndStep) {
                    break;
                }
                i++;
            }
        }
        String string2 = sb.toString();
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(chunkEndStep, "\n你是一个 GUI Agent 历史状态压缩器。你的任务不是预测动作，而是把较早历史压缩成一段结构化状态，供后续 parser 继续使用。\n\n请严格输出以下格式：\n<<<STATE_COMPRESSION>>>\ncovered_steps: 1-", "\ntask: ", task, "\nimportant_user_inputs:\n- ...\nimportant_observations:\n- ...\ncompleted_progress:\n- ...\ncurrent_subgoal:\n...\npending_risks:\n- ...\nlast_effective_state:\n...\n<<<END_STATE_COMPRESSION>>>\n\n以下是已有压缩状态：\n");
        b.B(sbK, str, "\n\n以下是本轮需要新增压缩的原始步骤（第", chunkStartStep, "步到第");
        sbK.append(chunkEndStep);
        sbK.append("步）：\n");
        sbK.append(string2);
        sbK.append("\n        ");
        return n.R(sbK.toString());
    }

    private final String buildFallbackCompressedState(String task, String previousCompressedStateText, int chunkStartStep, int chunkEndStep, SessionRuntimeState state) {
        Object objA;
        LinkedHashMap linkedHashMap;
        String str;
        String strC;
        String str2;
        String str3;
        String str4;
        String str5;
        Map<String, ? extends Object> map;
        String str6;
        String strC2;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        if (previousCompressedStateText != null) {
            try {
                objA = parseCompressedStateText(previousCompressedStateText);
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            linkedHashMap = (LinkedHashMap) objA;
        } else {
            linkedHashMap = null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (linkedHashMap != null && (str12 = (String) linkedHashMap.get("important_user_inputs")) != null) {
            arrayList.addAll(listifyTextField(str12));
        }
        if (linkedHashMap != null && (str11 = (String) linkedHashMap.get("important_observations")) != null) {
            arrayList2.addAll(listifyTextField(str11));
        }
        if (linkedHashMap != null && (str10 = (String) linkedHashMap.get("completed_progress")) != null) {
            arrayList3.addAll(listifyTextField(str10));
        }
        if (linkedHashMap != null && (str9 = (String) linkedHashMap.get("pending_risks")) != null) {
            arrayList4.addAll(listifyTextField(str9));
        }
        String string = (linkedHashMap == null || (str8 = (String) linkedHashMap.get("current_subgoal")) == null) ? null : m.R0(str8).toString();
        String str13 = "";
        if (string == null) {
            string = "";
        }
        if (m.s0(string)) {
            string = "none";
        }
        String string2 = (linkedHashMap == null || (str7 = (String) linkedHashMap.get("last_effective_state")) == null) ? null : m.R0(str7).toString();
        if (string2 == null) {
            string2 = "";
        }
        if (m.s0(string2)) {
            string2 = "none";
        }
        int i = chunkStartStep;
        if (i <= chunkEndStep) {
            strC = "none";
            str2 = strC;
            while (true) {
                int i6 = i - 1;
                EnvironmentEntry environmentEntry = (EnvironmentEntry) v.D0(i6, state.getEnvironmentHistory());
                if (environmentEntry == null || (map = (LinkedHashMap) v.D0(i6, state.getActionHistory())) == null) {
                    str = string2;
                    str5 = str13;
                } else {
                    String userComment = environmentEntry.getUserComment();
                    String string3 = userComment != null ? m.R0(userComment).toString() : null;
                    if (string3 == null) {
                        string3 = str13;
                    }
                    str = string2;
                    String str14 = string;
                    if (string3.length() > 0) {
                        arrayList.add("step " + i + ": " + string3);
                    }
                    String actionString = getActionString(map, "note");
                    if (!k.b(actionString, "none")) {
                        arrayList2.add("step " + i + ": " + actionString);
                        strC = androidx.constraintlayout.core.dsl.a.c(i, "step ", ": ", actionString);
                    }
                    String actionString2 = getActionString(map, "key_process");
                    if (k.b(actionString2, "none")) {
                        actionString2 = null;
                    }
                    if (actionString2 == null) {
                        actionString2 = getActionString(map, "summary");
                    }
                    if (!k.b(actionString2, "none")) {
                        arrayList3.add("step " + i + ": " + actionString2);
                    }
                    String actionString3 = getActionString(map, "explain");
                    if (k.b(actionString3, "none")) {
                        str6 = str2;
                        strC2 = str14;
                    } else {
                        strC2 = androidx.constraintlayout.core.dsl.a.c(i, "step ", ": ", actionString3);
                        str6 = strC2;
                    }
                    String actionString4 = getActionString(map, "verify");
                    str5 = str13;
                    String str15 = strC;
                    if (m.h0(actionString4, "不符合", false)) {
                        arrayList4.add("step " + i + ": " + actionString4);
                    }
                    String actionString5 = getActionString(map, GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION);
                    String str16 = strC2;
                    String str17 = str6;
                    if (o.N("INFO", "ABORT", "CALL_USER", "CALLUSER", "TAKEOVER").contains(actionString5)) {
                        String actionString6 = getActionString(map, "value");
                        if (k.b(actionString6, "none")) {
                            actionString6 = null;
                        }
                        if (actionString6 == null) {
                            actionString6 = getActionString(map, "return");
                        }
                        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(i, "step ", ": action=", actionString5, ", detail=");
                        sbK.append(actionString6);
                        arrayList4.add(sbK.toString());
                    }
                    strC = str15;
                    string = str16;
                    str2 = str17;
                }
                if (i == chunkEndStep) {
                    break;
                }
                i++;
                string2 = str;
                str13 = str5;
            }
        } else {
            str = string2;
            strC = "none";
            str2 = strC;
        }
        String strH = B7.a.h(chunkEndStep, "1-");
        List<String> listTruncateItems = truncateItems(arrayList, state.getCompressionConfig().getMaxFieldItems());
        List<String> listTruncateItems2 = truncateItems(arrayList2, state.getCompressionConfig().getMaxFieldItems());
        List<String> listTruncateItems3 = truncateItems(arrayList3, state.getCompressionConfig().getMaxFieldItems());
        String str18 = !k.b(string, "none") ? string : str2;
        List<String> listTruncateItems4 = truncateItems(arrayList4, state.getCompressionConfig().getMaxFieldItems());
        if (!k.b(strC, "none")) {
            str3 = task;
            str4 = strC;
        } else if (k.b(str2, "none")) {
            str3 = task;
            str4 = str;
        } else {
            str3 = task;
            str4 = str2;
        }
        return compressedStateToText(new CompressedState(strH, str3, listTruncateItems, listTruncateItems2, listTruncateItems3, str18, listTruncateItems4, str4));
    }

    private final String buildStatusPrompt(String task, String summaryHistory, String userComment) {
        if (m.R0(summaryHistory).toString().length() <= 0) {
            summaryHistory = "暂无历史操作";
        } else if (userComment.length() > 0) {
            summaryHistory = androidx.appfunctions.metadata.a.l(summaryHistory, userComment);
        }
        return n.R("\n已知用户指令为：" + B7.a.B(task, userComment.length() > 0 ? B7.a.m("\n\n", userComment, "\n\n") : "", "\n") + "\n已知已经执行过的历史动作如下：" + summaryHistory + "\n当前手机屏幕截图如下：\n\n在执行操作之前，请务必回顾你的历史操作记录和限定的动作空间，先进行思考和解释然后输出动作空间和对应的参数：\n1. 思考（THINK）：在 <THINK> 和 </THINK> 标签之间。\n2. 解释（explain）：在动作格式中，使用 explain: 开头，简要说明当前动作的目的和执行方式。\n在执行完操作后，请输出执行完当前步骤后的新历史总结。\n输出格式示例：\n<THINK> 思考的内容 </THINK>\nexplain:解释的内容\taction:动作空间和对应的参数\tsummary:执行完当前步骤后的新历史总结\n        ");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048 A[PHI: r2
      0x0048: PHI (r2v3 java.lang.String) = (r2v2 java.lang.String), (r2v6 java.lang.String) binds: [B:9:0x0028, B:14:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String buildSummaryHistory(stepai.aios.guiagent.llm.cell.LocalModelCell.SessionRuntimeState r7) {
        /*
            r6 = this;
            java.util.List r0 = r7.getActionHistory()
            java.lang.Object r0 = D7.v.L0(r0)
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0
            java.lang.String r1 = ""
            if (r0 != 0) goto Lf
            return r1
        Lf:
            java.util.List r7 = r7.getActionHistory()
            int r7 = r7.size()
            java.lang.String r2 = "summary"
            java.lang.String r2 = r6.getActionString(r0, r2)
            java.lang.String r3 = "none"
            boolean r4 = kotlin.jvm.internal.k.b(r2, r3)
            r5 = 0
            if (r4 != 0) goto L27
            goto L28
        L27:
            r2 = r5
        L28:
            if (r2 != 0) goto L48
            java.lang.String r2 = "key_process"
            java.lang.String r2 = r6.getActionString(r0, r2)
            boolean r4 = kotlin.jvm.internal.k.b(r2, r3)
            if (r4 != 0) goto L37
            goto L38
        L37:
            r2 = r5
        L38:
            if (r2 != 0) goto L48
            java.lang.String r2 = "explain"
            java.lang.String r6 = r6.getActionString(r0, r2)
            boolean r0 = kotlin.jvm.internal.k.b(r6, r3)
            if (r0 != 0) goto L49
            r5 = r6
            goto L49
        L48:
            r5 = r2
        L49:
            if (r5 == 0) goto L5b
            boolean r6 = j9.m.s0(r5)
            if (r6 == 0) goto L52
            goto L5b
        L52:
            java.lang.String r6 = "第"
            java.lang.String r0 = "步："
            java.lang.String r6 = androidx.constraintlayout.core.dsl.a.c(r7, r6, r0, r5)
            return r6
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.LocalModelCell.buildSummaryHistory(stepai.aios.guiagent.llm.cell.LocalModelCell$SessionRuntimeState):java.lang.String");
    }

    private final String buildTaskWithApp(za.e session) {
        String str = session.c;
        String str2 = session.b;
        return (str == null || m.s0(str)) ? str2 : B7.a.B(str2, "，指定App：", session.c);
    }

    private final String compressedStateToText(CompressedState state) {
        LinkedHashMap linkedHashMapO = a.O(new Pair("covered_steps", state.getCoveredSteps()), new Pair("task", state.getTask()), new Pair("important_user_inputs", state.getImportantUserInputs().isEmpty() ? o.M("- none") : state.getImportantUserInputs()), new Pair("important_observations", state.getImportantObservations().isEmpty() ? o.M("- none") : state.getImportantObservations()), new Pair("completed_progress", state.getCompletedProgress().isEmpty() ? o.M("- none") : state.getCompletedProgress()), new Pair("current_subgoal", state.getCurrentSubgoal()), new Pair("pending_risks", state.getPendingRisks().isEmpty() ? o.M("- none") : state.getPendingRisks()), new Pair("last_effective_state", state.getLastEffectiveState()));
        ArrayList arrayListQ = o.Q(COMPRESSED_STATE_START);
        for (String str : COMPRESSED_STATE_FIELDS) {
            String strStringifyFieldValue = stringifyFieldValue(linkedHashMapO.get(str));
            if (m.h0(strStringifyFieldValue, "\n", false)) {
                arrayListQ.add(str + ":");
                arrayListQ.addAll(m.w0(strStringifyFieldValue));
            } else {
                arrayListQ.add(str + ": " + strStringifyFieldValue);
            }
        }
        arrayListQ.add(COMPRESSED_STATE_END);
        return v.I0(arrayListQ, "\n", null, null, null, 62);
    }

    private final int computeCompressionTarget(int currentStep, int lastCompressedUptoStep, int interval, int recentWindow) {
        int i;
        int i6 = currentStep - recentWindow;
        if (i6 >= interval && (i = (i6 / interval) * interval) > lastCompressedUptoStep) {
            return i;
        }
        return 0;
    }

    private final List<String> dedupPreserveOrder(List<String> items) {
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            String string = m.R0((String) it.next()).toString();
            if (string.length() != 0 && linkedHashSet.add(string)) {
                arrayList.add(string);
            }
        }
        return arrayList;
    }

    private final String extractCompressedSummary(String compressedText) {
        try {
            LinkedHashMap<String, String> compressedStateText = parseCompressedStateText(compressedText);
            String str = compressedStateText.get("completed_progress");
            String string = str != null ? m.R0(str).toString() : null;
            if (string == null) {
                string = "";
            }
            String str2 = compressedStateText.get("current_subgoal");
            String string2 = str2 != null ? m.R0(str2).toString() : null;
            if (string2 == null) {
                string2 = "";
            }
            ArrayList arrayList = new ArrayList();
            if (!m.s0(string) && !string.equals("none") && !string.equals("- none")) {
                List<String> listListifyTextField = listifyTextField(string);
                if (!listListifyTextField.isEmpty()) {
                    arrayList.add(v.I0(listListifyTextField, "; ", null, null, null, 62));
                }
            }
            if (!m.s0(string2) && !string2.equals("none")) {
                arrayList.add("当前子目标: ".concat(string2));
            }
            return v.I0(arrayList, "。", null, null, null, 62);
        } catch (Exception unused) {
            return "";
        }
    }

    private final String extractJsonObject(String text) {
        int iP0 = m.p0(text, '{', 0, 6);
        int iV0 = m.v0(text, '}', 0, 6);
        if (iP0 < 0 || iV0 <= iP0) {
            return null;
        }
        String strSubstring = text.substring(iP0, iV0 + 1);
        k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object generateRequestMessage$suspendImpl(stepai.aios.guiagent.llm.cell.LocalModelCell r4, za.e r5, java.lang.String r6, stepai.aios.guiagent.config.LlmConfig r7, java.lang.String r8, java.lang.String r9, H7.c<? super java.util.List<stepai.aios.guiagent.llm.Message>> r10) {
        /*
            boolean r0 = r10 instanceof stepai.aios.guiagent.llm.cell.LocalModelCell.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            stepai.aios.guiagent.llm.cell.LocalModelCell$generateRequestMessage$1 r0 = (stepai.aios.guiagent.llm.cell.LocalModelCell.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r10 = r0
            goto L1a
        L14:
            stepai.aios.guiagent.llm.cell.LocalModelCell$generateRequestMessage$1 r0 = new stepai.aios.guiagent.llm.cell.LocalModelCell$generateRequestMessage$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r0 = r10.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r10.label
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r4 = r10.L$5
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r10.L$4
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r10.L$3
            stepai.aios.guiagent.config.LlmConfig r4 = (stepai.aios.guiagent.config.LlmConfig) r4
            java.lang.Object r4 = r10.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r10.L$1
            za.e r4 = (za.e) r4
            java.lang.Object r4 = r10.L$0
            stepai.aios.guiagent.llm.cell.LocalModelCell r4 = (stepai.aios.guiagent.llm.cell.LocalModelCell) r4
            kotlin.b.b(r0)
            goto L62
        L41:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L49:
            kotlin.b.b(r0)
            r0 = 0
            r10.L$0 = r0
            r10.L$1 = r0
            r10.L$2 = r0
            r10.L$3 = r0
            r10.L$4 = r0
            r10.L$5 = r0
            r10.label = r3
            java.lang.Object r0 = r4.generateRequestPayload(r5, r6, r7, r8, r9, r10)
            if (r0 != r1) goto L62
            return r1
        L62:
            stepai.aios.guiagent.llm.parser.ModelRequestPayload r0 = (stepai.aios.guiagent.llm.parser.ModelRequestPayload) r0
            java.util.List r4 = r0.getMessages()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.LocalModelCell.generateRequestMessage$suspendImpl(stepai.aios.guiagent.llm.cell.LocalModelCell, za.e, java.lang.String, stepai.aios.guiagent.config.LlmConfig, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object generateRequestPayload$suspendImpl(stepai.aios.guiagent.llm.cell.LocalModelCell r4, za.e r5, java.lang.String r6, stepai.aios.guiagent.config.LlmConfig r7, java.lang.String r8, java.lang.String r9, H7.c<? super stepai.aios.guiagent.llm.parser.ModelRequestPayload> r10) throws java.lang.Exception {
        /*
            boolean r0 = r10 instanceof stepai.aios.guiagent.llm.cell.LocalModelCell.C19401
            if (r0 == 0) goto L13
            r0 = r10
            stepai.aios.guiagent.llm.cell.LocalModelCell$generateRequestPayload$1 r0 = (stepai.aios.guiagent.llm.cell.LocalModelCell.C19401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            stepai.aios.guiagent.llm.cell.LocalModelCell$generateRequestPayload$1 r0 = new stepai.aios.guiagent.llm.cell.LocalModelCell$generateRequestPayload$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L52
            if (r2 != r3) goto L4a
            java.lang.Object r4 = r0.L$7
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.L$6
            stepai.aios.guiagent.llm.cell.LocalModelCell$SessionRuntimeState r5 = (stepai.aios.guiagent.llm.cell.LocalModelCell.SessionRuntimeState) r5
            java.lang.Object r6 = r0.L$5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$4
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$3
            stepai.aios.guiagent.config.LlmConfig r6 = (stepai.aios.guiagent.config.LlmConfig) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$1
            za.e r6 = (za.e) r6
            java.lang.Object r6 = r0.L$0
            stepai.aios.guiagent.llm.cell.LocalModelCell r6 = (stepai.aios.guiagent.llm.cell.LocalModelCell) r6
            kotlin.b.b(r10)
            r8 = r5
            r5 = r4
            r4 = r6
            goto L86
        L4a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L52:
            kotlin.b.b(r10)
            if (r5 == 0) goto L9f
            java.lang.String r10 = r5.f7004a
            stepai.aios.guiagent.llm.cell.LocalModelCell$SessionRuntimeState r10 = r4.getSessionState(r10)
            stepai.aios.guiagent.config.StateCompressionConfig r2 = r7.getStateCompressionConfig()
            r4.applyCompressionConfig(r10, r2)
            java.lang.String r5 = r4.prepareRequestState(r5, r6, r10, r9)
            r0.L$0 = r4
            r6 = 0
            r0.L$1 = r6
            r0.L$2 = r6
            r0.L$3 = r6
            r0.L$4 = r6
            r0.L$5 = r6
            r0.L$6 = r10
            r0.L$7 = r5
            r0.label = r3
            r6 = r7
            r7 = r8
            r8 = r10
            r9 = r0
            java.lang.Object r6 = r4.maybeCompressHistoryWithLlm(r5, r6, r7, r8, r9)
            if (r6 != r1) goto L86
            return r1
        L86:
            stepai.aios.guiagent.llm.parser.ModelRequestPayload r6 = new stepai.aios.guiagent.llm.parser.ModelRequestPayload
            java.util.List r4 = r4.renderRequestMessages(r5, r8)
            java.util.LinkedHashMap r5 = r8.getLastCompressionInfo()
            if (r5 == 0) goto L97
            java.util.Map r5 = kotlin.collections.a.Y(r5)
            goto L9b
        L97:
            java.util.Map r5 = kotlin.collections.a.M()
        L9b:
            r6.<init>(r4, r5)
            return r6
        L9f:
            java.lang.Exception r4 = new java.lang.Exception
            java.lang.String r5 = "[generateRequestMessage] session is null"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.LocalModelCell.generateRequestPayload$suspendImpl(stepai.aios.guiagent.llm.cell.LocalModelCell, za.e, java.lang.String, stepai.aios.guiagent.config.LlmConfig, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    private final String getActionString(Map<String, ? extends Object> action, String key) {
        String string;
        Object obj = action.get(key);
        String string2 = (obj == null || (string = obj.toString()) == null) ? null : m.R0(string).toString();
        if (string2 == null) {
            string2 = "";
        }
        return string2.length() == 0 ? "none" : string2;
    }

    private final SessionRuntimeState getSessionState(String sessionId) {
        SessionRuntimeState sessionRuntimeStateComputeIfAbsent = this.sessionStates.computeIfAbsent(sessionId, new g(new m5.a(17), 7));
        k.e(sessionRuntimeStateComputeIfAbsent, "computeIfAbsent(...)");
        return sessionRuntimeStateComputeIfAbsent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionRuntimeState getSessionState$lambda$0(String it) {
        k.f(it, "it");
        return new SessionRuntimeState(null, null, null, false, null, 0, null, null, null, 511, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionRuntimeState getSessionState$lambda$1(S7.k kVar, Object obj) {
        return (SessionRuntimeState) kVar.invoke(obj);
    }

    private final List<String> listifyTextField(String value) {
        String string = value != null ? m.R0(value).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0 || string.equals("none")) {
            return EmptyList.f4893a;
        }
        List listW0 = m.w0(string);
        ArrayList arrayList = new ArrayList();
        Iterator it = listW0.iterator();
        while (it.hasNext()) {
            String string2 = m.R0(m.y0("- ", m.R0((String) it.next()).toString())).toString();
            if (string2.length() == 0 || k.b(string2, "none")) {
                string2 = null;
            }
            if (string2 != null) {
                arrayList.add(string2);
            }
        }
        return arrayList;
    }

    private final Pair<String, String> matchCompressedStateField(String line) {
        for (String str : COMPRESSED_STATE_FIELDS) {
            if (t.e0(line, str + ":", false)) {
                return new Pair<>(str, str);
            }
        }
        for (Map.Entry<String, String> entry : COMPRESSED_STATE_FIELD_ALIASES.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (t.e0(line, key + ":", false)) {
                return new Pair<>(key, value);
            }
        }
        return null;
    }

    private final void maybeCompressHistory(String task, SessionRuntimeState state) {
        int size = state.getEnvironmentHistory().size();
        if (!state.getCompressionConfig().getEnabled()) {
            state.setLastCompressionInfo(buildCompressionInfo$default(this, state, false, "disabled", size, null, null, null, "compression_disabled", null, 64, null));
            return;
        }
        int iComputeCompressionTarget = computeCompressionTarget(size, state.getCompressedUptoStep(), state.getCompressionConfig().getInterval(), state.getCompressionConfig().getRecentWindow());
        if (iComputeCompressionTarget <= 0) {
            state.setLastCompressionInfo(buildCompressionInfo$default(this, state, false, "skipped", size, null, null, null, "insufficient_or_already_compressed_history", null, 64, null));
            return;
        }
        int compressedUptoStep = state.getCompressedUptoStep() + 1;
        state.setCompressedStateText(buildFallbackCompressedState(task, state.getCompressedStateText(), compressedUptoStep, iComputeCompressionTarget, state));
        state.setCompressedUptoStep(iComputeCompressionTarget);
        state.setLastCompressionInfo(buildCompressionInfo$default(this, state, true, "fallback", size, Integer.valueOf(compressedUptoStep), Integer.valueOf(iComputeCompressionTarget), null, null, null, 64, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01e3 A[Catch: all -> 0x01ea, TryCatch #1 {all -> 0x01ea, blocks: (B:39:0x01cd, B:41:0x01e3, B:46:0x01f2, B:48:0x0203, B:53:0x0223, B:55:0x0229, B:57:0x0233, B:59:0x023d, B:60:0x0245, B:61:0x024f, B:52:0x021f, B:62:0x0250, B:63:0x0283, B:45:0x01ed, B:49:0x020b), top: B:113:0x01cd, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01ed A[Catch: all -> 0x01ea, TryCatch #1 {all -> 0x01ea, blocks: (B:39:0x01cd, B:41:0x01e3, B:46:0x01f2, B:48:0x0203, B:53:0x0223, B:55:0x0229, B:57:0x0233, B:59:0x023d, B:60:0x0245, B:61:0x024f, B:52:0x021f, B:62:0x0250, B:63:0x0283, B:45:0x01ed, B:49:0x020b), top: B:113:0x01cd, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0203 A[Catch: all -> 0x01ea, TRY_LEAVE, TryCatch #1 {all -> 0x01ea, blocks: (B:39:0x01cd, B:41:0x01e3, B:46:0x01f2, B:48:0x0203, B:53:0x0223, B:55:0x0229, B:57:0x0233, B:59:0x023d, B:60:0x0245, B:61:0x024f, B:52:0x021f, B:62:0x0250, B:63:0x0283, B:45:0x01ed, B:49:0x020b), top: B:113:0x01cd, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0250 A[Catch: all -> 0x01ea, TryCatch #1 {all -> 0x01ea, blocks: (B:39:0x01cd, B:41:0x01e3, B:46:0x01f2, B:48:0x0203, B:53:0x0223, B:55:0x0229, B:57:0x0233, B:59:0x023d, B:60:0x0245, B:61:0x024f, B:52:0x021f, B:62:0x0250, B:63:0x0283, B:45:0x01ed, B:49:0x020b), top: B:113:0x01cd, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x033e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object maybeCompressHistoryWithLlm(java.lang.String r31, stepai.aios.guiagent.config.LlmConfig r32, java.lang.String r33, stepai.aios.guiagent.llm.cell.LocalModelCell.SessionRuntimeState r34, H7.c<? super C7.r> r35) {
        /*
            Method dump skipped, instructions count: 884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.LocalModelCell.maybeCompressHistoryWithLlm(java.lang.String, stepai.aios.guiagent.config.LlmConfig, java.lang.String, stepai.aios.guiagent.llm.cell.LocalModelCell$SessionRuntimeState, H7.c):java.lang.Object");
    }

    private final String normalizeCompressedState(String compressedState, String fallbackTask, String fallbackCoveredSteps) {
        String str;
        String str2;
        String string = compressedState != null ? m.R0(compressedState).toString() : null;
        String strCompressedStateToText = string == null ? "" : string;
        if (strCompressedStateToText.length() == 0) {
            return null;
        }
        if (m.h0(strCompressedStateToText, COMPRESSED_STATE_START, false) && m.h0(strCompressedStateToText, COMPRESSED_STATE_END, false)) {
            str = fallbackTask;
            str2 = fallbackCoveredSteps;
        } else {
            EmptyList emptyList = EmptyList.f4893a;
            str = fallbackTask;
            str2 = fallbackCoveredSteps;
            strCompressedStateToText = compressedStateToText(new CompressedState(str2, str, emptyList, o.M(strCompressedStateToText), emptyList, "none", emptyList, strCompressedStateToText));
        }
        LinkedHashMap<String, String> compressedStateText = parseCompressedStateText(strCompressedStateToText);
        String str3 = compressedStateText.get("covered_steps");
        if (str3 == null) {
            str3 = "";
        }
        String str4 = m.s0(str3) ? str2 : str3;
        if (str4.length() == 0) {
            str4 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        String str5 = str4;
        String str6 = compressedStateText.get("task");
        if (str6 == null) {
            str6 = "";
        }
        if (m.s0(str6)) {
            str6 = str;
        }
        String str7 = str6.length() == 0 ? "none" : str6;
        List<String> listListifyTextField = listifyTextField(compressedStateText.get("important_user_inputs"));
        List<String> listListifyTextField2 = listifyTextField(compressedStateText.get("important_observations"));
        List<String> listListifyTextField3 = listifyTextField(compressedStateText.get("completed_progress"));
        String str8 = compressedStateText.get("current_subgoal");
        if (str8 == null) {
            str8 = "";
        }
        String str9 = m.s0(str8) ? "none" : str8;
        List<String> listListifyTextField4 = listifyTextField(compressedStateText.get("pending_risks"));
        String str10 = compressedStateText.get("last_effective_state");
        String str11 = str10 != null ? str10 : "";
        return compressedStateToText(new CompressedState(str5, str7, listListifyTextField, listListifyTextField2, listListifyTextField3, str9, listListifyTextField4, m.s0(str11) ? "none" : str11));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x019f, code lost:
    
        if (r3.equals("TYPE") != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01a1, code lost:
    
        r0 = r18.get("value");
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01a7, code lost:
    
        if ((r0 instanceof java.lang.String) == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01a9, code lost:
    
        r0 = (java.lang.String) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01ac, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01ae, code lost:
    
        if (r0 == null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01b0, code lost:
    
        r4.put("text", j9.t.c0(j9.t.c0(j9.t.c0(j9.t.c0(r0, "\\n", "\n"), "\\'", "'"), "\\\"", "\""), "\\\\", "\\"));
        r0 = r18.get("point");
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x004a, code lost:
    
        if (r3.equals("CALL_USER") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01d9, code lost:
    
        if ((r0 instanceof java.util.List) == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01db, code lost:
    
        r0 = (java.util.List) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01de, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01e0, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01e3, code lost:
    
        if (r2 == null) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01e9, code lost:
    
        if (r2.isEmpty() == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01f2, code lost:
    
        if (r0.size() < 2) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01fa, code lost:
    
        if ((r0.get(0) instanceof java.lang.Integer) == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0203, code lost:
    
        if ((r0.get(1) instanceof java.lang.Integer) == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0205, code lost:
    
        r4.put("x", java.lang.String.valueOf(r0.get(0)));
        r4.put("y", java.lang.String.valueOf(r0.get(1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0224, code lost:
    
        throw new java.lang.IllegalArgumentException("[TYPE] value is not valid");
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
    
        if (r3.equals("CALLUSER") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0255, code lost:
    
        if (r3.equals("HOME") != false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x025f, code lost:
    
        if (r3.equals("BACK") != false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0267, code lost:
    
        if (r3.equals("LONGPRESS") != false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0269, code lost:
    
        r0 = requirePoint(r18.get("point"), r3, "point");
        r4.put("x", java.lang.String.valueOf(r0.get(0).intValue()));
        r4.put("y", java.lang.String.valueOf(r0.get(1).intValue()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0298, code lost:
    
        if (r3.equals("LONGPRESS") == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x029a, code lost:
    
        r4.put(androidx.constraintlayout.core.motion.utils.TypedValues.TransitionType.S_DURATION, "1000");
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02a6, code lost:
    
        if (r3.equals("SCROLL") != false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02a8, code lost:
    
        r2 = requirePoint(r18.get("point1"), "SLIDE", "point1");
        r0 = requirePoint(r18.get("point2"), "SLIDE", "point2");
        r4.put("x1", java.lang.String.valueOf(r2.get(0).intValue()));
        r4.put("y1", java.lang.String.valueOf(r2.get(1).intValue()));
        r4.put("x2", java.lang.String.valueOf(r0.get(0).intValue()));
        r4.put("y2", java.lang.String.valueOf(r0.get(1).intValue()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0311, code lost:
    
        if (r3.equals("PRESS_BACK") != false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        if (r3.equals("TAKEOVER") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
    
        r0 = r18.get("value");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
    
        if ((r0 instanceof java.lang.String) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        r0 = (java.lang.String) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
    
        if (r0 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0097, code lost:
    
        if (j9.m.s0(r0) != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0099, code lost:
    
        r4.put("message", r0);
        r2 = r18.get("tag");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a4, code lost:
    
        if ((r2 instanceof java.lang.String) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
    
        r2 = (java.lang.String) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a9, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ab, code lost:
    
        if (r2 == null) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b1, code lost:
    
        if (j9.m.s0(r2) == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b5, code lost:
    
        r4.put("tag", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c1, code lost:
    
        throw new java.lang.IllegalArgumentException("[CALL_USER] value is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c8, code lost:
    
        if (r3.equals("SWIPE") != false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d0, code lost:
    
        if (r3.equals("SLIDE") != false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00da, code lost:
    
        if (r3.equals("INPUT") != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e4, code lost:
    
        if (r3.equals("CLICK") != false) goto L147;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x042a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.Map<java.lang.String, java.lang.String> parseActionParam(java.util.HashMap<java.lang.String, java.lang.Object> r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 1188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.LocalModelCell.parseActionParam(java.util.HashMap, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        if (r2.equals("CALL_USER") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        if (r2.equals("CALLUSER") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006a, code lost:
    
        if (r2.equals("TAKEOVER") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0070, code lost:
    
        return stepai.aios.guiagent.config.ActionType.TAKEOVER;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
    
        if (r2.equals("SWIPE") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0081, code lost:
    
        if (r2.equals("SLIDE") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
    
        if (r2.equals("INPUT") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
    
        if (r2.equals("TYPE") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00cc, code lost:
    
        return stepai.aios.guiagent.config.ActionType.TYPE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00eb, code lost:
    
        if (r2.equals("BACK") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0100, code lost:
    
        if (r2.equals("SCROLL") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0105, code lost:
    
        return stepai.aios.guiagent.config.ActionType.SWIPE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x010c, code lost:
    
        if (r2.equals("PRESS_BACK") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0111, code lost:
    
        return stepai.aios.guiagent.config.ActionType.BACK;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final stepai.aios.guiagent.config.ActionType parseActionType(java.util.HashMap<java.lang.String, java.lang.Object> r3) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.LocalModelCell.parseActionType(java.util.HashMap):stepai.aios.guiagent.config.ActionType");
    }

    private final LinkedHashMap<String, String> parseCompressedStateText(String text) {
        String string = m.R0(text).toString();
        if (!m.h0(string, COMPRESSED_STATE_START, false) || !m.h0(string, COMPRESSED_STATE_END, false)) {
            throw new IllegalArgumentException("compressed state should contain boundary markers");
        }
        String string2 = m.R0(m.L0(m.H0(string, COMPRESSED_STATE_START, string), COMPRESSED_STATE_END)).toString();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ArrayList arrayList = new ArrayList();
        k.f(string2, "<this>");
        C1614h c1614h = new C1614h(string2);
        while (c1614h.hasNext()) {
            String string3 = m.R0((String) c1614h.next()).toString();
            if (string3.length() != 0) {
                Pair<String, String> pairMatchCompressedStateField = matchCompressedStateField(string3);
                if (pairMatchCompressedStateField != null) {
                    parseCompressedStateText$flushCurrentField(ref$ObjectRef, linkedHashMap, arrayList);
                    ref$ObjectRef.f4920a = pairMatchCompressedStateField.b;
                    String string4 = m.R0(m.H0(string3, pairMatchCompressedStateField.f4886a + ":", string3)).toString();
                    if (string4.length() > 0) {
                        arrayList.add(string4);
                    }
                } else if (ref$ObjectRef.f4920a != null) {
                    arrayList.add(string3);
                }
            }
        }
        parseCompressedStateText$flushCurrentField(ref$ObjectRef, linkedHashMap, arrayList);
        List<String> list = COMPRESSED_STATE_FIELDS;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!linkedHashMap.containsKey((String) obj)) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            return new LinkedHashMap<>(linkedHashMap);
        }
        throw new IllegalArgumentException(("compressed state missing fields: " + arrayList2).toString());
    }

    private static final void parseCompressedStateText$flushCurrentField(Ref$ObjectRef<String> ref$ObjectRef, LinkedHashMap<String, String> linkedHashMap, List<String> list) {
        String str = (String) ref$ObjectRef.f4920a;
        if (str == null) {
            return;
        }
        String string = m.R0(v.I0(list, "\n", null, null, null, 62)).toString();
        if (string.length() == 0) {
            string = "none";
        }
        linkedHashMap.put(str, string);
        ref$ObjectRef.f4920a = null;
        list.clear();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x019c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0156 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0051 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.LinkedHashMap<java.lang.String, java.lang.Object> parseJsonParam(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.LocalModelCell.parseJsonParam(java.lang.String):java.util.LinkedHashMap");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int parseJsonParam$lambda$0$0(InterfaceC1616j it) {
        k.f(it, "it");
        return Integer.parseInt(((l) it).c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.HashMap<java.lang.String, java.lang.Object> parseParam(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.LocalModelCell.parseParam(java.lang.String):java.util.HashMap");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int parseParam$lambda$3(InterfaceC1616j it) {
        k.f(it, "it");
        return Integer.parseInt(((l) it).c());
    }

    private final String prepareRequestState(za.e session, String imageBase64, SessionRuntimeState state, String imageUrl) {
        EnvironmentEntry environmentEntry = new EnvironmentEntry(imageBase64, state.getPendingUserComment(), imageUrl);
        if (!state.getHasPendingEnvironment() || state.getEnvironmentHistory().isEmpty()) {
            state.getEnvironmentHistory().add(environmentEntry);
            state.setHasPendingEnvironment(true);
        } else {
            state.getEnvironmentHistory().set(o.H(state.getEnvironmentHistory()), environmentEntry);
        }
        return buildTaskWithApp(session);
    }

    public static /* synthetic */ String prepareRequestState$default(LocalModelCell localModelCell, za.e eVar, String str, SessionRuntimeState sessionRuntimeState, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepareRequestState");
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return localModelCell.prepareRequestState(eVar, str, sessionRuntimeState, str2);
    }

    private final List<Message> renderRequestMessages(String taskWithApp, SessionRuntimeState state) {
        EnvironmentEntry environmentEntry = (EnvironmentEntry) v.L0(state.getEnvironmentHistory());
        String strBuildSummaryHistory = buildSummaryHistory(state);
        String pendingUserComment = state.getPendingUserComment();
        if (pendingUserComment == null) {
            pendingUserComment = "";
        }
        String strBuildStatusPrompt = buildStatusPrompt(taskWithApp, strBuildSummaryHistory, pendingUserComment);
        LlmMessageBuilder llmMessageBuilderRole = new LlmMessageBuilder().role(MessageRole.USER);
        if (getUserImageBeforeText()) {
            appendImageContent(llmMessageBuilderRole, environmentEntry != null ? environmentEntry.getImageBase64() : null, environmentEntry != null ? environmentEntry.getImageUrl() : null);
            llmMessageBuilderRole.text(strBuildStatusPrompt);
        } else {
            llmMessageBuilderRole.text(strBuildStatusPrompt);
            appendImageContent(llmMessageBuilderRole, environmentEntry != null ? environmentEntry.getImageBase64() : null, environmentEntry != null ? environmentEntry.getImageUrl() : null);
        }
        return o.N(new LlmMessageBuilder().role(MessageRole.SYSTEM).text(effectiveSystemPrompt()).build(), llmMessageBuilderRole.build());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<Integer> requirePoint(Object value, String actionType, String fieldName) {
        List list = value instanceof List ? (List) value : null;
        if (list == null) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.m("[", actionType, "] ", fieldName, " is not valid"));
        }
        if (list.size() < 2 || !(list.get(0) instanceof Integer) || !(list.get(1) instanceof Integer)) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.m("[", actionType, "] ", fieldName, " is not int"));
        }
        Object obj = list.get(0);
        k.d(obj, "null cannot be cast to non-null type kotlin.Int");
        Object obj2 = list.get(1);
        k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        return o.N(obj, obj2);
    }

    private final void safeLogE(String message) {
        try {
            j.G(message, "LocalModelCell");
        } catch (Throwable th) {
            kotlin.b.a(th);
        }
    }

    private final void safeLogI(String message) {
        try {
            j.H(message, "LocalModelCell");
        } catch (Throwable th) {
            kotlin.b.a(th);
        }
    }

    private final List<String> splitTopLevelJsonFields(String body) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        int i11 = 0;
        int i12 = 0;
        while (i < body.length()) {
            char cCharAt = body.charAt(i);
            int i13 = i10 + 1;
            if (z10) {
                z10 = false;
            } else if (cCharAt == '\\' && z11) {
                z10 = true;
            } else if (cCharAt == '\"') {
                z11 = !z11;
            } else if (!z11 && cCharAt == '[') {
                i11++;
            } else if (!z11 && cCharAt == ']') {
                i11--;
            } else if (!z11 && cCharAt == '{') {
                i12++;
            } else if (!z11 && cCharAt == '}') {
                i12--;
            } else if (!z11 && cCharAt == ',' && i11 == 0 && i12 == 0) {
                String strSubstring = body.substring(i6, i10);
                k.e(strSubstring, "substring(...)");
                arrayList.add(m.R0(strSubstring).toString());
                i6 = i13;
            }
            i++;
            i10 = i13;
        }
        String strSubstring2 = body.substring(i6);
        k.e(strSubstring2, "substring(...)");
        String string = m.R0(strSubstring2).toString();
        if (string.length() > 0) {
            arrayList.add(string);
        }
        return arrayList;
    }

    private final String stepRecordToText(int stepIdx, EnvironmentEntry env, Map<String, ? extends Object> action) {
        String str;
        ArrayList arrayListQ = o.Q(androidx.appfunctions.metadata.a.i(stepIdx, "[STEP ", "]"));
        String userComment = env.getUserComment();
        String string = userComment != null ? m.R0(userComment).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            string = "none";
        }
        arrayListQ.add("user_comment: " + ((Object) string));
        String imageUrl = env.getImageUrl();
        if (imageUrl == null || m.s0(imageUrl)) {
            String imageBase64 = env.getImageBase64();
            str = (imageBase64 == null || m.s0(imageBase64)) ? "none" : "inline_base64_image";
        } else {
            str = "uploaded_url";
        }
        arrayListQ.add("image_reference: ".concat(str));
        arrayListQ.add("action: " + getActionString(action, GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION));
        arrayListQ.add("verify: " + getActionString(action, "verify"));
        arrayListQ.add("note: " + getActionString(action, "note"));
        arrayListQ.add("explain: " + getActionString(action, "explain"));
        String actionString = getActionString(action, "key_process");
        String actionString2 = k.b(actionString, "none") ? null : actionString;
        if (actionString2 == null) {
            actionString2 = getActionString(action, "summary");
        }
        arrayListQ.add("key_process: " + actionString2);
        if (action.containsKey("value")) {
            arrayListQ.add("value: " + getActionString(action, "value"));
        }
        if (action.containsKey("return")) {
            arrayListQ.add("return: " + getActionString(action, "return"));
        }
        arrayListQ.add("[/STEP " + stepIdx + "]");
        return v.I0(arrayListQ, "\n", null, null, null, 62);
    }

    private final String stringifyFieldValue(Object value) {
        String string;
        if (value != null) {
            if (value instanceof String) {
                String string2 = m.R0((String) value).toString();
                if (string2.length() != 0) {
                    return string2;
                }
            } else {
                if (value instanceof List) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((Iterable) value).iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        String string3 = (next == null || (string = next.toString()) == null) ? null : m.R0(string).toString();
                        if (string3 == null) {
                            string3 = "";
                        }
                        String strConcat = string3.length() != 0 ? t.e0(string3, "- ", false) ? string3 : "- ".concat(string3) : null;
                        if (strConcat != null) {
                            arrayList.add(strConcat);
                        }
                    }
                    return arrayList.isEmpty() ? "- none" : v.I0(arrayList, "\n", null, null, null, 62);
                }
                String string4 = m.R0(value.toString()).toString();
                if (string4.length() != 0) {
                    return string4;
                }
            }
        }
        return "none";
    }

    private final String stripThink(String text) {
        String string = text != null ? m.R0(t.c0(t.c0(text, "<THINK>", "<think>"), "</THINK>", "</think>")).toString() : null;
        if (string == null) {
            string = "";
        }
        return !m.h0(string, "</think>", false) ? string : m.R0(m.H0(string, "</think>", string)).toString();
    }

    private final String summarizeForLog(String text) {
        String string = text != null ? m.R0(text).toString() : null;
        if (string == null) {
            string = "";
        }
        String strF = new Regex("\\s+").f(string, " ");
        return strF.length() == 0 ? "none" : strF.length() <= MAX_COMPRESSION_LOG_CHARS ? strF : m.N0(MAX_COMPRESSION_LOG_CHARS, strF).concat("...(truncated)");
    }

    private final HashMap<String, Object> transformLocalAction(HashMap<String, Object> paramMap) {
        Object obj = paramMap.get("action_type");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            Object obj2 = paramMap.get(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION);
            str = obj2 instanceof String ? (String) obj2 : null;
            if (str == null) {
                throw new IllegalArgumentException("[transformLocalAction] action is null");
            }
        }
        if (str.equalsIgnoreCase("INFO")) {
            str = "CALL_USER";
        }
        HashMap<String, Object> map = new HashMap<>(paramMap);
        map.put("action_type", str);
        map.put(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, str);
        if (paramMap.containsKey("point")) {
            Object obj3 = paramMap.get("point");
            k.c(obj3);
            map.put("coordinates", obj3);
        }
        if (paramMap.containsKey("value")) {
            Object obj4 = paramMap.get("value");
            k.c(obj4);
            map.put("text", obj4);
        }
        if (paramMap.containsKey("is_keyboard") && !map.containsKey("keyboard_exists")) {
            Object obj5 = paramMap.get("is_keyboard");
            k.c(obj5);
            map.put("keyboard_exists", obj5);
        }
        if (str.equalsIgnoreCase("WAIT")) {
            Object obj6 = paramMap.get("value");
            if (obj6 != null) {
                map.put(TypedValues.TransitionType.S_DURATION, obj6);
            }
            Object obj7 = paramMap.get("explain");
            String str2 = obj7 instanceof String ? (String) obj7 : null;
            if (str2 != null && m.h0(str2, "功能类", false)) {
                map.put("is_auto_close", Boolean.TRUE);
            }
            if (!map.containsKey("close_reasons")) {
                map.put("close_reasons", "[]");
            }
        }
        return map;
    }

    private final List<String> truncateItems(List<String> items, int maxItems) {
        List<String> listDedupPreserveOrder = dedupPreserveOrder(items);
        return listDedupPreserveOrder.isEmpty() ? o.M("- none") : listDedupPreserveOrder.size() <= maxItems ? listDedupPreserveOrder : v.b1(maxItems, listDedupPreserveOrder);
    }

    private final String unquoteJsonScalar(String value) {
        String string = m.R0(value).toString();
        if (string.length() >= 2) {
            if (string.length() == 0) {
                throw new NoSuchElementException("Char sequence is empty.");
            }
            if (string.charAt(0) == '\"' && m.t0(string) == '\"') {
                String strSubstring = string.substring(1, string.length() - 1);
                k.e(strSubstring, "substring(...)");
                return t.c0(t.c0(t.c0(t.c0(t.c0(strSubstring, "\\n", "\n"), "\\r", "\r"), "\\t", "\t"), "\\\"", "\""), "\\\\", "\\");
            }
        }
        return string;
    }

    public void appendImageContent(LlmMessageBuilder builder, String imageBase64, String imageUrl) {
        k.f(builder, "builder");
        if (imageBase64 != null && !m.s0(imageBase64)) {
            LlmMessageBuilder.imageBase64$default(builder, imageBase64, null, 2, null);
        } else {
            if (imageUrl == null || m.s0(imageUrl)) {
                return;
            }
            builder.image(imageUrl);
        }
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public List<Message> buildRequestMessage(za.e session, String imageBase64) {
        k.f(session, "session");
        SessionRuntimeState sessionState = getSessionState(session.f7004a);
        applyCompressionConfig(sessionState, new StateCompressionConfig(false, 0, 0, 0, 15, null));
        String strPrepareRequestState$default = prepareRequestState$default(this, session, imageBase64, sessionState, null, 8, null);
        maybeCompressHistory(strPrepareRequestState$default, sessionState);
        return renderRequestMessages(strPrepareRequestState$default, sessionState);
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public Pair<ActionType, Map<String, String>> buildResponseAction(String response, za.e session) {
        k.f(response, "response");
        k.f(session, "session");
        SessionRuntimeState sessionState = getSessionState(session.f7004a);
        HashMap<String, Object> mapTransformLocalAction = transformLocalAction(parseParam(response));
        ActionType actionType = parseActionType(mapTransformLocalAction);
        if (actionType == null) {
            throw new IllegalArgumentException("[buildResponseAction] actionType is null");
        }
        Object obj = mapTransformLocalAction.get(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION);
        Map<String, String> actionParam = parseActionParam(mapTransformLocalAction, obj instanceof String ? (String) obj : null);
        sessionState.getActionHistory().add(new LinkedHashMap<>(mapTransformLocalAction));
        sessionState.setHasPendingEnvironment(false);
        sessionState.setPendingUserComment(null);
        return new Pair<>(actionType, actionParam);
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public void clearCache() {
        this.sessionStates.clear();
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public Object generateRequestMessage(za.e eVar, String str, LlmConfig llmConfig, String str2, String str3, H7.c<? super List<Message>> cVar) {
        return generateRequestMessage$suspendImpl(this, eVar, str, llmConfig, str2, str3, cVar);
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public Object generateRequestPayload(za.e eVar, String str, LlmConfig llmConfig, String str2, String str3, H7.c<? super ModelRequestPayload> cVar) {
        return generateRequestPayload$suspendImpl(this, eVar, str, llmConfig, str2, str3, cVar);
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public Size getCompressBitmapSize() {
        return new Size(448, 1080);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getDesc() {
        return this.desc;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public ModelParam getModelParam() {
        return new ModelParam(0.1f, 0.95f, 256, Float.valueOf(0.0f));
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getName() {
        return this.name;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public List<GUIAgentMode> getSupportedMode() {
        return this.supportedMode;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getSystemPrompt() {
        return DEFAULT_SKILL;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getType() {
        return this.type;
    }

    public boolean getUserImageBeforeText() {
        return this.userImageBeforeText;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public void handleInquiry(za.e session, String question, String answer) {
        String str;
        if (session == null || (str = session.f7004a) == null) {
            return;
        }
        getSessionState(str).setPendingUserComment(answer);
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public void injectExperienceAction(String explain, String action, List<Integer> point, String value, String summary) {
        String upperCase;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (explain == null) {
            explain = action == null ? "未知操作" : action;
        }
        if (action != null) {
            upperCase = action.toUpperCase(Locale.ROOT);
            k.e(upperCase, "toUpperCase(...)");
        } else {
            upperCase = "CLICK";
        }
        linkedHashMap.put("verify", "此步骤已由经验库自动执行完成：" + explain + "。因此我判断 符合 上一步预期");
        linkedHashMap.put("note", "【已自动执行】" + explain + "。此操作已经完成，请勿重复执行");
        linkedHashMap.put("explain", explain);
        linkedHashMap.put(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, upperCase);
        if (summary == null) {
            summary = "经验库已自动完成".concat(explain);
        }
        linkedHashMap.put("summary", summary);
        if (value != null && !m.s0(value)) {
            linkedHashMap.put("value", value);
        }
        Collection<SessionRuntimeState> collectionValues = this.sessionStates.values();
        k.e(collectionValues, "<get-values>(...)");
        for (SessionRuntimeState sessionRuntimeState : collectionValues) {
            sessionRuntimeState.getEnvironmentHistory().add(new EnvironmentEntry(null, null, null, 4, null));
            sessionRuntimeState.getActionHistory().add(new LinkedHashMap<>(linkedHashMap));
            sessionRuntimeState.setHasPendingEnvironment(false);
        }
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public void removeSession(String sessionId) {
        k.f(sessionId, "sessionId");
        this.sessionStates.remove(sessionId);
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public List<Message> generateRequestMessage(za.e session, String imageBase64, String imageUrl) {
        return generateRequestPayload(session, imageBase64, imageUrl).getMessages();
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public ModelRequestPayload generateRequestPayload(za.e session, String imageBase64, String imageUrl) throws Exception {
        if (session == null) {
            throw new Exception("[generateRequestMessage] session is null");
        }
        SessionRuntimeState sessionState = getSessionState(session.f7004a);
        applyCompressionConfig(sessionState, new StateCompressionConfig(false, 0, 0, 0, 15, null));
        String strPrepareRequestState = prepareRequestState(session, imageBase64, sessionState, imageUrl);
        maybeCompressHistory(strPrepareRequestState, sessionState);
        List<Message> listRenderRequestMessages = renderRequestMessages(strPrepareRequestState, sessionState);
        LinkedHashMap<String, Object> lastCompressionInfo = sessionState.getLastCompressionInfo();
        return new ModelRequestPayload(listRenderRequestMessages, lastCompressionInfo != null ? a.Y(lastCompressionInfo) : a.M());
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lstepai/aios/guiagent/llm/cell/LocalModelCell$EnvironmentEntry;", "", "imageBase64", "", "userComment", "imageUrl", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageBase64", "()Ljava/lang/String;", "getUserComment", "getImageUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EnvironmentEntry {
        private final String imageBase64;
        private final String imageUrl;
        private final String userComment;

        public EnvironmentEntry(String str, String str2, String str3) {
            this.imageBase64 = str;
            this.userComment = str2;
            this.imageUrl = str3;
        }

        public static /* synthetic */ EnvironmentEntry copy$default(EnvironmentEntry environmentEntry, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = environmentEntry.imageBase64;
            }
            if ((i & 2) != 0) {
                str2 = environmentEntry.userComment;
            }
            if ((i & 4) != 0) {
                str3 = environmentEntry.imageUrl;
            }
            return environmentEntry.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getImageBase64() {
            return this.imageBase64;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUserComment() {
            return this.userComment;
        }

        /* renamed from: component3, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final EnvironmentEntry copy(String imageBase64, String userComment, String imageUrl) {
            return new EnvironmentEntry(imageBase64, userComment, imageUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EnvironmentEntry)) {
                return false;
            }
            EnvironmentEntry environmentEntry = (EnvironmentEntry) other;
            return k.b(this.imageBase64, environmentEntry.imageBase64) && k.b(this.userComment, environmentEntry.userComment) && k.b(this.imageUrl, environmentEntry.imageUrl);
        }

        public final String getImageBase64() {
            return this.imageBase64;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getUserComment() {
            return this.userComment;
        }

        public int hashCode() {
            String str = this.imageBase64;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.userComment;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.imageUrl;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            String str = this.imageBase64;
            String str2 = this.userComment;
            return B7.a.q(B7.a.w("EnvironmentEntry(imageBase64=", str, ", userComment=", str2, ", imageUrl="), this.imageUrl, ")");
        }

        public /* synthetic */ EnvironmentEntry(String str, String str2, String str3, int i, e eVar) {
            this(str, str2, (i & 4) != 0 ? null : str3);
        }
    }
}
