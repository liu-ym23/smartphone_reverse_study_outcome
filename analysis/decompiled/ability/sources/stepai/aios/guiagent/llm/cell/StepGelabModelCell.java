package stepai.aios.guiagent.llm.cell;

import Ba.g;
import D7.v;
import H4.o;
import J7.c;
import N9.j;
import android.util.Size;
import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.b;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import j9.C1614h;
import j9.InterfaceC1616j;
import j9.l;
import j9.m;
import j9.n;
import j9.t;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.config.StateCompressionConfig;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.MessageRole;
import stepai.aios.guiagent.llm.config.LlmMessageBuilder;
import stepai.aios.guiagent.llm.parser.AbsModelCell;
import stepai.aios.guiagent.llm.parser.GUIAgentMode;
import stepai.aios.guiagent.llm.parser.ModelParam;
import stepai.aios.guiagent.llm.parser.ModelRequestPayload;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Â\u00012\u00020\u0001:\nÃ\u0001Ä\u0001Å\u0001Â\u0001Æ\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001a\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJD\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0004\b\u0017\u0010\u001eJ>\u0010\u001a\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0004\b\u001a\u0010\u001eJ'\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u001f\u0010 J7\u0010%\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0$0\"2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)JG\u00100\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\t2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00152\b\u0010.\u001a\u0004\u0018\u00010\t2\b\u0010/\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u0002022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b3\u00104J\u001f\u00108\u001a\u00020\u00072\u0006\u00105\u001a\u0002022\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J5\u0010:\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u00105\u001a\u0002022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b:\u0010;J%\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010<\u001a\u00020\t2\u0006\u00105\u001a\u000202H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b?\u0010@J\u001f\u0010B\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\t2\u0006\u00105\u001a\u000202H\u0002¢\u0006\u0004\bB\u0010CJ0\u0010D\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\t2\u0006\u00105\u001a\u000202H\u0082@¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\u00072\u0006\u00105\u001a\u000202H\u0002¢\u0006\u0004\bH\u0010IJ\u007f\u0010V\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T0Sj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T`U2\u0006\u00105\u001a\u0002022\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020,2\b\u0010N\u001a\u0004\u0018\u00010,2\b\u0010O\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\t2\b\u0010Q\u001a\u0004\u0018\u00010\t2\b\u0010R\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bV\u0010WJ/\u0010[\u001a\u00020,2\u0006\u0010M\u001a\u00020,2\u0006\u0010X\u001a\u00020,2\u0006\u0010Y\u001a\u00020,2\u0006\u0010Z\u001a\u00020,H\u0002¢\u0006\u0004\b[\u0010\\J9\u0010^\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\b\u0010]\u001a\u0004\u0018\u00010\t2\u0006\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020,2\u0006\u00105\u001a\u000202H\u0002¢\u0006\u0004\b^\u0010_J9\u0010a\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\b\u0010`\u001a\u0004\u0018\u00010\t2\u0006\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020,2\u0006\u00105\u001a\u000202H\u0002¢\u0006\u0004\ba\u0010_J3\u0010e\u001a\u00020\t2\u0006\u0010b\u001a\u00020,2\u0006\u0010d\u001a\u00020c2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T0$H\u0002¢\u0006\u0004\be\u0010fJ\u0019\u0010h\u001a\u00020\t2\b\u0010g\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bh\u0010GJ\u0019\u0010i\u001a\u00020\t2\b\u0010g\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bi\u0010GJ!\u0010l\u001a\u00020\t2\u0006\u0010j\u001a\u00020\t2\b\u0010k\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bl\u0010mJ\u0017\u0010n\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\tH\u0002¢\u0006\u0004\bn\u0010\fJ\u0017\u0010o\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\tH\u0002¢\u0006\u0004\bo\u0010\fJ\u0019\u0010p\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010TH\u0002¢\u0006\u0004\bp\u0010qJ\u0017\u0010s\u001a\u00020\t2\u0006\u00105\u001a\u00020rH\u0002¢\u0006\u0004\bs\u0010tJ3\u0010u\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0Sj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`U2\u0006\u0010g\u001a\u00020\tH\u0002¢\u0006\u0004\bu\u0010vJ%\u0010x\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\"2\u0006\u0010w\u001a\u00020\tH\u0002¢\u0006\u0004\bx\u0010yJ+\u0010}\u001a\u0004\u0018\u00010\t2\b\u0010z\u001a\u0004\u0018\u00010\t2\u0006\u0010{\u001a\u00020\t2\u0006\u0010|\u001a\u00020\tH\u0002¢\u0006\u0004\b}\u0010~J.\u0010\u0080\u0001\u001a\u0004\u0018\u00010\t2\u0006\u0010A\u001a\u00020\t2\b\u0010z\u001a\u0004\u0018\u00010\t2\u0006\u0010\u007f\u001a\u00020,H\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\"\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\b\u0010.\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J'\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0002¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J0\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0007\u0010\u0087\u0001\u001a\u00020,H\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J/\u0010\u008b\u0001\u001a\u00020\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T0$2\u0007\u0010\u008a\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001JP\u0010\u0091\u0001\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0$2%\u0010\u008f\u0001\u001a \u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T0\u008d\u0001j\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T`\u008e\u00012\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J;\u0010\u0093\u0001\u001a\u0004\u0018\u00010#2%\u0010\u008f\u0001\u001a \u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T0\u008d\u0001j\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T`\u008e\u0001H\u0002¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J8\u0010\u0095\u0001\u001a \u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T0\u008d\u0001j\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T`\u008e\u00012\u0006\u0010!\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J:\u0010\u0098\u0001\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T\u0018\u00010Sj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T\u0018\u0001`U2\u0007\u0010\u0097\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0098\u0001\u0010vJ\u001b\u0010\u0099\u0001\u001a\u0004\u0018\u00010\t2\u0006\u0010g\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0099\u0001\u0010GJ\"\u0010\u009b\u0001\u001a\u0004\u0018\u00010\t*\u00030\u009a\u00012\u0007\u0010\u008a\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J(\u0010\u009d\u0001\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0015*\u00030\u009a\u00012\u0007\u0010\u008a\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\"\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020,0\u00152\b\u0010 \u0001\u001a\u00030\u009f\u0001H\u0002¢\u0006\u0006\b¡\u0001\u0010¢\u0001J$\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00152\b\u0010£\u0001\u001a\u00030\u009a\u0001H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\"\u0010¦\u0001\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00152\u0006\u0010g\u001a\u00020\tH\u0002¢\u0006\u0006\b¦\u0001\u0010\u0083\u0001J4\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020,0\u00152\b\u0010.\u001a\u0004\u0018\u00010T2\u0007\u0010\u0090\u0001\u001a\u00020\t2\u0007\u0010§\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b¨\u0001\u0010©\u0001JR\u0010ª\u0001\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T0Sj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T`U2\"\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T0Sj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T`UH\u0002¢\u0006\u0006\bª\u0001\u0010«\u0001J'\u0010\u00ad\u0001\u001a\u00020\t2\u0013\u0010¬\u0001\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T0$H\u0002¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u001b\u0010¯\u0001\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010TH\u0002¢\u0006\u0005\b¯\u0001\u0010qJ\u0019\u0010°\u0001\u001a\u00020\t2\u0006\u0010g\u001a\u00020\tH\u0002¢\u0006\u0005\b°\u0001\u0010GR\u001f\u0010±\u0001\u001a\u00020\t8\u0016X\u0096D¢\u0006\u0010\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001R$\u0010¶\u0001\u001a\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002020µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0017\u0010¹\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¸\u0001\u0010´\u0001R\u0019\u0010»\u0001\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010´\u0001R\u0017\u0010½\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010´\u0001R \u0010Á\u0001\u001a\u000b\u0012\u0005\u0012\u00030¾\u0001\u0018\u00010\u00158VX\u0096\u0004¢\u0006\b\u001a\u0006\b¿\u0001\u0010À\u0001¨\u0006Ç\u0001"}, d2 = {"Lstepai/aios/guiagent/llm/cell/StepGelabModelCell;", "Lstepai/aios/guiagent/llm/parser/AbsModelCell;", AppAgent.CONSTRUCT, "()V", "Lstepai/aios/guiagent/llm/parser/ModelParam;", "getModelParam", "()Lstepai/aios/guiagent/llm/parser/ModelParam;", "LC7/r;", "clearCache", "", "sessionId", "removeSession", "(Ljava/lang/String;)V", "Lza/e;", "session", "question", "answer", "handleInquiry", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)V", "imageBase64", "imageUrl", "", "Lstepai/aios/guiagent/llm/Message;", "generateRequestMessage", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lstepai/aios/guiagent/llm/parser/ModelRequestPayload;", "generateRequestPayload", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Lstepai/aios/guiagent/llm/parser/ModelRequestPayload;", "Lstepai/aios/guiagent/config/LlmConfig;", "llmConfig", "(Lza/e;Ljava/lang/String;Lstepai/aios/guiagent/config/LlmConfig;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "buildRequestMessage", "(Lza/e;Ljava/lang/String;)Ljava/util/List;", "response", "Lkotlin/Pair;", "Lstepai/aios/guiagent/config/ActionType;", "", "buildResponseAction", "(Ljava/lang/String;Lza/e;)Lkotlin/Pair;", "Landroid/util/Size;", "getCompressBitmapSize", "()Landroid/util/Size;", "explain", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "point", "value", "summary", "injectExperienceAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;", "getSessionState", "(Ljava/lang/String;)Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;", "state", "Lstepai/aios/guiagent/config/StateCompressionConfig;", "config", "applyCompressionConfig", "(Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;Lstepai/aios/guiagent/config/StateCompressionConfig;)V", "prepareRequestState", "(Lza/e;Ljava/lang/String;Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;Ljava/lang/String;)Ljava/lang/String;", "taskWithApp", "renderRequestMessages", "(Ljava/lang/String;Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;)Ljava/util/List;", "buildTaskWithApp", "(Lza/e;)Ljava/lang/String;", "task", "maybeCompressHistory", "(Ljava/lang/String;Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;)V", "maybeCompressHistoryWithLlm", "(Ljava/lang/String;Lstepai/aios/guiagent/config/LlmConfig;Ljava/lang/String;Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;LH7/c;)Ljava/lang/Object;", "buildCompressionSessionId", "(Ljava/lang/String;)Ljava/lang/String;", "evictCompressedImageBase64", "(Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;)V", "", "triggered", "mode", "currentStep", "chunkStartStep", "chunkEndStep", "compressionTraceId", "reason", "detail", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "buildCompressionInfo", "(Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;ZLjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/LinkedHashMap;", "lastCompressedUptoStep", "interval", "recentWindow", "computeCompressionTarget", "(IIII)I", "previousCompressedStateText", "buildFallbackCompressedState", "(Ljava/lang/String;Ljava/lang/String;IILstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;)Ljava/lang/String;", "previousCompressedState", "buildCompressionPrompt", "stepIdx", "Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$EnvironmentEntry;", "env", "stepRecordToText", "(ILstepai/aios/guiagent/llm/cell/StepGelabModelCell$EnvironmentEntry;Ljava/util/Map;)Ljava/lang/String;", "text", "stripThink", "summarizeForLog", "message", "responsePreview", "buildCompressionFailureDetail", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "safeLogI", "safeLogE", "stringifyFieldValue", "(Ljava/lang/Object;)Ljava/lang/String;", "Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$CompressedState;", "compressedStateToText", "(Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$CompressedState;)Ljava/lang/String;", "parseCompressedStateText", "(Ljava/lang/String;)Ljava/util/LinkedHashMap;", "line", "matchCompressedStateField", "(Ljava/lang/String;)Lkotlin/Pair;", "compressedState", "fallbackTask", "fallbackCoveredSteps", "normalizeCompressedState", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "compressedUptoStep", "buildCompressedStateMessage", "(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;", "listifyTextField", "(Ljava/lang/String;)Ljava/util/List;", "items", "dedupPreserveOrder", "(Ljava/util/List;)Ljava/util/List;", "maxItems", "truncateItems", "(Ljava/util/List;I)Ljava/util/List;", "key", "getActionString", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "paramMap", "actionType", "parseActionParam", "(Ljava/util/HashMap;Ljava/lang/String;)Ljava/util/Map;", "parseActionType", "(Ljava/util/HashMap;)Lstepai/aios/guiagent/config/ActionType;", "parseParam", "(Ljava/lang/String;)Ljava/util/HashMap;", "rawText", "parseJsonParam", "extractJsonObject", "Lcom/google/gson/JsonObject;", "getStringOrNull", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;", "getPointOrNull", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/util/List;", "Lcom/google/gson/JsonArray;", "array", "parseJsonPoint", "(Lcom/google/gson/JsonArray;)Ljava/util/List;", "obj", "parseJsonPointObject", "(Lcom/google/gson/JsonObject;)Ljava/util/List;", "parseJsonPointText", "fieldName", "requirePoint", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "sanitizeActionForPrompt", "(Ljava/util/LinkedHashMap;)Ljava/util/LinkedHashMap;", "map", "mapToJson", "(Ljava/util/Map;)Ljava/lang/String;", "toJsonValue", "escapeJson", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "sessionStates", "Ljava/util/concurrent/ConcurrentHashMap;", "getName", HintConstants.AUTOFILL_HINT_NAME, "getDesc", "desc", "getSystemPrompt", "systemPrompt", "Lstepai/aios/guiagent/llm/parser/GUIAgentMode;", "getSupportedMode", "()Ljava/util/List;", "supportedMode", "Companion", "SessionRuntimeState", "EnvironmentEntry", "CompressedState", "MessageContentBuilder", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepGelabModelCell extends AbsModelCell {
    private static final String COMPRESSED_STATE_END = "<<<END_STATE_COMPRESSION>>>";
    private static final List<String> COMPRESSED_STATE_FIELDS;
    private static final LinkedHashMap<String, String> COMPRESSED_STATE_FIELD_ALIASES;
    private static final String COMPRESSED_STATE_START = "<<<STATE_COMPRESSION>>>";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_SKILL;
    private static final String INSTRUCTION_PROMPT;
    private static final int KEEP_LAST_K_IMAGES = 1;
    private static final int MAX_COMPRESSION_LOG_CHARS = 800;
    private static final String TAG = "StepGelabModelCell";
    private static final String TASK_DEFINE_PROMPT;
    private static final DateTimeFormatter dateFormatter;
    private final String type = "StepGelabModelCell";
    private final ConcurrentHashMap<String, SessionRuntimeState> sessionStates = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "dateFormatter", "Ljava/time/format/DateTimeFormatter;", "KEEP_LAST_K_IMAGES", "", "MAX_COMPRESSION_LOG_CHARS", "COMPRESSED_STATE_START", "COMPRESSED_STATE_END", "COMPRESSED_STATE_FIELDS", "", "COMPRESSED_STATE_FIELD_ALIASES", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "DEFAULT_SKILL", "getDEFAULT_SKILL", "()Ljava/lang/String;", "TASK_DEFINE_PROMPT", "getTASK_DEFINE_PROMPT", "INSTRUCTION_PROMPT", "getINSTRUCTION_PROMPT", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final String getDEFAULT_SKILL() {
            return StepGelabModelCell.DEFAULT_SKILL;
        }

        public final String getINSTRUCTION_PROMPT() {
            return StepGelabModelCell.INSTRUCTION_PROMPT;
        }

        public final String getTASK_DEFINE_PROMPT() {
            return StepGelabModelCell.TASK_DEFINE_PROMPT;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Jq\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"}, d2 = {"Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$CompressedState;", "", "coveredSteps", "", "task", "importantUserInputs", "", "importantObservations", "completedProgress", "currentSubgoal", "pendingRisks", "lastEffectiveState", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCoveredSteps", "()Ljava/lang/String;", "getTask", "getImportantUserInputs", "()Ljava/util/List;", "getImportantObservations", "getCompletedProgress", "getCurrentSubgoal", "getPendingRisks", "getLastEffectiveState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            return this.lastEffectiveState.hashCode() + a.e(this.pendingRisks, B7.a.c(a.e(this.completedProgress, a.e(this.importantObservations, a.e(this.importantUserInputs, B7.a.c(this.coveredSteps.hashCode() * 31, 31, this.task), 31), 31), 31), 31, this.currentSubgoal), 31);
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$MessageContentBuilder;", "", AppAgent.CONSTRUCT, "()V", "Text", "ImageBase64", "Image", "Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$MessageContentBuilder$Image;", "Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$MessageContentBuilder$ImageBase64;", "Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$MessageContentBuilder$Text;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class MessageContentBuilder {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$MessageContentBuilder$Image;", "Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$MessageContentBuilder;", "imageUrl", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Image extends MessageContentBuilder {
            private final String imageUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Image(String imageUrl) {
                super(null);
                k.f(imageUrl, "imageUrl");
                this.imageUrl = imageUrl;
            }

            public static /* synthetic */ Image copy$default(Image image, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = image.imageUrl;
                }
                return image.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getImageUrl() {
                return this.imageUrl;
            }

            public final Image copy(String imageUrl) {
                k.f(imageUrl, "imageUrl");
                return new Image(imageUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Image) && k.b(this.imageUrl, ((Image) other).imageUrl);
            }

            public final String getImageUrl() {
                return this.imageUrl;
            }

            public int hashCode() {
                return this.imageUrl.hashCode();
            }

            public String toString() {
                return B7.a.m("Image(imageUrl=", this.imageUrl, ")");
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$MessageContentBuilder$ImageBase64;", "Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$MessageContentBuilder;", "base64", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getBase64", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ImageBase64 extends MessageContentBuilder {
            private final String base64;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageBase64(String base64) {
                super(null);
                k.f(base64, "base64");
                this.base64 = base64;
            }

            public static /* synthetic */ ImageBase64 copy$default(ImageBase64 imageBase64, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = imageBase64.base64;
                }
                return imageBase64.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getBase64() {
                return this.base64;
            }

            public final ImageBase64 copy(String base64) {
                k.f(base64, "base64");
                return new ImageBase64(base64);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ImageBase64) && k.b(this.base64, ((ImageBase64) other).base64);
            }

            public final String getBase64() {
                return this.base64;
            }

            public int hashCode() {
                return this.base64.hashCode();
            }

            public String toString() {
                return B7.a.m("ImageBase64(base64=", this.base64, ")");
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$MessageContentBuilder$Text;", "Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$MessageContentBuilder;", "text", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Text extends MessageContentBuilder {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Text(String text) {
                super(null);
                k.f(text, "text");
                this.text = text;
            }

            public static /* synthetic */ Text copy$default(Text text, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = text.text;
                }
                return text.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final Text copy(String text) {
                k.f(text, "text");
                return new Text(text);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Text) && k.b(this.text, ((Text) other).text);
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                return this.text.hashCode();
            }

            public String toString() {
                return B7.a.m("Text(text=", this.text, ")");
            }
        }

        public /* synthetic */ MessageContentBuilder(e eVar) {
            this();
        }

        private MessageContentBuilder() {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b-\b\u0082\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012*\b\u0002\u0010\u0007\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\t0\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012(\b\u0002\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J+\u00104\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\t0\u0005HÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J)\u00108\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\tHÆ\u0003J\t\u00109\u001a\u00020\u0011HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013HÆ\u0003Jµ\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052*\b\u0002\u0010\u0007\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\t0\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2(\b\u0002\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013HÆ\u0001J\u0013\u0010<\u001a\u00020\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u000eHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR3\u0010\u0007\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R:\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u00101¨\u0006@"}, d2 = {"Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$SessionRuntimeState;", "", "pendingUserComment", "", "environmentHistory", "", "Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$EnvironmentEntry;", "actionHistory", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "hasPendingEnvironment", "", "compressedStateText", "compressedUptoStep", "", "lastCompressionInfo", "compressionConfig", "Lstepai/aios/guiagent/config/StateCompressionConfig;", "compressionConfigIssues", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLjava/lang/String;ILjava/util/LinkedHashMap;Lstepai/aios/guiagent/config/StateCompressionConfig;Ljava/util/List;)V", "getPendingUserComment", "()Ljava/lang/String;", "setPendingUserComment", "(Ljava/lang/String;)V", "getEnvironmentHistory", "()Ljava/util/List;", "getActionHistory", "getHasPendingEnvironment", "()Z", "setHasPendingEnvironment", "(Z)V", "getCompressedStateText", "setCompressedStateText", "getCompressedUptoStep", "()I", "setCompressedUptoStep", "(I)V", "getLastCompressionInfo", "()Ljava/util/LinkedHashMap;", "setLastCompressionInfo", "(Ljava/util/LinkedHashMap;)V", "getCompressionConfig", "()Lstepai/aios/guiagent/config/StateCompressionConfig;", "setCompressionConfig", "(Lstepai/aios/guiagent/config/StateCompressionConfig;)V", "getCompressionConfigIssues", "setCompressionConfigIssues", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            int iD = a.d(a.e(this.actionHistory, a.e(this.environmentHistory, (str == null ? 0 : str.hashCode()) * 31, 31), 31), 31, this.hasPendingEnvironment);
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
            return a.q(sb, list3, ")");
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

    @c(c = "stepai.aios.guiagent.llm.cell.StepGelabModelCell", f = "StepGelabModelCell.kt", l = {338}, m = "generateRequestMessage", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.llm.cell.StepGelabModelCell$generateRequestMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StepGelabModelCell.this.generateRequestMessage(null, null, null, null, null, this);
        }
    }

    @c(c = "stepai.aios.guiagent.llm.cell.StepGelabModelCell", f = "StepGelabModelCell.kt", l = {354}, m = "generateRequestPayload", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.llm.cell.StepGelabModelCell$generateRequestPayload$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C19421(H7.c<? super C19421> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StepGelabModelCell.this.generateRequestPayload(null, null, null, null, null, this);
        }
    }

    @c(c = "stepai.aios.guiagent.llm.cell.StepGelabModelCell", f = "StepGelabModelCell.kt", l = {651}, m = "maybeCompressHistoryWithLlm", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.llm.cell.StepGelabModelCell$maybeCompressHistoryWithLlm$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19431 extends ContinuationImpl {
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

        public C19431(H7.c<? super C19431> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StepGelabModelCell.this.maybeCompressHistoryWithLlm(null, null, null, null, this);
        }
    }

    static {
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        k.e(dateTimeFormatterOfPattern, "ofPattern(...)");
        dateFormatter = dateTimeFormatterOfPattern;
        COMPRESSED_STATE_FIELDS = o.N("covered_steps", "task", "important_user_inputs", "important_observations", "completed_progress", "current_subgoal", "pending_risks", "last_effective_state");
        COMPRESSED_STATE_FIELD_ALIASES = kotlin.collections.a.O(new Pair("covered_step", "covered_steps"), new Pair("steps_covered", "covered_steps"), new Pair("user_inputs", "important_user_inputs"), new Pair("important_inputs", "important_user_inputs"), new Pair("page_observations", "important_observations"), new Pair("observations", "important_observations"), new Pair("summary", "completed_progress"), new Pair("key_process", "completed_progress"), new Pair("key_progress", "completed_progress"), new Pair("current_goal", "current_subgoal"), new Pair("subgoal", "current_subgoal"), new Pair("risk", "pending_risks"), new Pair("risks", "pending_risks"), new Pair("potential_risks", "pending_risks"), new Pair("risk_items", "pending_risks"), new Pair("last_state", "last_effective_state"), new Pair("last_valid_state", "last_effective_state"));
        DEFAULT_SKILL = "# Role: 手机 GUI-Agent 操作专家\nVersion: 6.0\n你是一个手机 GUI-Agent 操作专家，你需要根据用户下发的任务、当前手机屏幕截图和交互操作的历史记录，借助既定的动作空间与手机进行交互，从而完成用户的任务。\n## 基础设定\n- **对话模式切换**：这是一个 system prompt，可能被拼接在正常对话中。如果用户和你进行正常对话（而非下发具体的手机操作任务），你需要依照用户的指令做正常对话，而无需输出本协议要求的严格格式内容（如 `verify\\tnote...` 等）。\n- **坐标系**：请牢记，手机屏幕坐标系以左上角为原点：\n  - x轴向右，取值范围 0-1000\n  - y轴向下，取值范围 0-1000\n---\n## 动作空间 (Action Space)\n在 Android 手机的场景下，你的动作空间包含以下 11 类操作，所有输出都必须严格遵守对应的参数要求：\n1. **CLICK**：点击手机屏幕坐标，需包含点击的坐标位置 point。\n   - 格式：`action:CLICK\\tpoint:x,y`\n2. **TYPE**：在手机输入框中输入文字，需包含输入内容 value。\n   - 格式：`action:TYPE\\tvalue:输入内容`\n3. **COMPLETE**：任务完成后向用户报告结果，需包含报告的内容 return。\n   - 格式：`action:COMPLETE\\treturn:完成任务后向用户报告的内容`\n4. **WAIT**：等待指定时长，需包含等待时间 value（秒）。\n   - 格式：`action:WAIT\\tvalue:等待时间`\n5. **AWAKE**：唤醒指定应用，需包含唤醒的应用名称 value。\n   - 格式：`action:AWAKE\\tvalue:应用名称`\n6. **INFO**：询问用户问题或详细信息，需包含提问内容 value。你可以借助此指令与用户进行多轮对话。如果任务完成缺乏关键条件，你需要事先问清楚，允许多轮追问。\n   - 格式：`action:INFO\\tvalue:提问内容`\n7. **ABORT**：终止当前任务，仅在当前任务无法继续执行时使用，需包含 value 说明原因。\n   - 格式：`action:ABORT\\tvalue:终止任务的原因`\n8. **SLIDE**：在手机屏幕上滑动，需包含起点 point1 和终点 point2。滑动方向与效果请严格参考“滑动操作规范”。\n   - 格式：`action:SLIDE\\tpoint1:x1,y1\\tpoint2:x2,y2`\n9. **LONGPRESS**：长按手机屏幕坐标，需包含长按的坐标位置 point。\n   - 格式：`action:LONGPRESS\\tpoint:x,y`\n10. **BACK**：返回上一级界面，无需额外参数。\n    - 格式：`action:BACK`\n11. **CALL_USER**：请求用户的帮助。当你发现当前截图异常或没有图片，或遇到**登录（包括一键登录）**、**退出登录 / 注销账号 / 切换账号**、支付、授权（包括用户协议、隐私协议、隐私政策、服务条款、权限申请等各类协议/授权弹窗或专门的协议确认页面）等关键敏感操作需要用户接管时，或需要删除或者发布内容时，你需要请求用户的帮助。需包含请求内容 value 以及请求类型 tag。\n    - tag 枚举值：`screenshot_issue`（截图异常），`confirm_action`（请求用户接管关键敏感操作）。\n    - 格式：`action:CALL_USER\\tvalue:请求内容\\ttag:请求类型`\n    - **【隐私/用户协议页面识别要点】**：当屏幕上出现下列任一特征时，必须判定为协议/授权页面，并立即出 `CALL_USER` (tag: `confirm_action`)，**绝对不要替用户点\"同意/允许/接受/继续/我已阅读\"等按钮**：\n      - 页面或弹窗中包含\"用户协议\"\"隐私协议\"\"隐私政策\"\"服务条款\"\"用户须知\"\"使用须知\"\"授权协议\"\"权限说明\"\"个人信息保护\"等关键字；\n      - 出现勾选框搭配\"我已阅读并同意《xxx》\"之类的协议链接；\n      - 出现\"同意并继续\"\"同意并使用\"\"不同意\"\"暂不使用\"\"拒绝\"等成对的同意/拒绝按钮；\n      - App 首次启动的隐私政策遮罩弹窗、单独的隐私政策确认页、二次确认弹窗（\"不同意将无法使用本服务\"之类）。\n---\n## 输出格式与字段定义 (Output Format & Field Definitions)\n*本章节定义了你最终输出的思考过程与动作指令的严格格式。*\n**【核心观察原则】**\n在执行操作之前，请务必回顾：**仔细观察图片，仔细观察图片，仔细观察图片！**\n你需要主要依靠图片当前状态，决定你要做什么。任务执行过程 **很可能** 会发生异常，你历史执行过的记录只能作为参考。你的思考和决定必须完全基于当前屏幕状态（我会给你重复两次当前屏幕截图，你得看）。\n先进行思考（你得多想），然后输出动作空间和对应的参数。输出必须采用 CSV 风格，以 `\\t` 分割字段，**绝对不要使用 JSON**。\n输出必须以 `verify` 字段开头，严格遵循以下单行格式（不要换行）：\n`verify:xx 证据表明上个动作是否生效\\tnote:当前页面总结出的关键信息\\texplain:解释的内容\\taction:动作空间和对应的参数\\tkey_process:当前的关键进展,如果没有明显的进展可以写none`\n**字段详细定义：**\n1. **verify**：在这个字段中，你需要指出 xx 证据表明上个动作是否生效。你需要指出上一步的动作和预期，并就是否达成预期作出判断。**必须严格以这句话结尾：“因此我判断 （符合｜不符合） 上一步预期”**。\n2. **note**：在这个字段你需要**尽量多地记录**屏幕内容和用户指令相关的信息。如果没啥有用的信息，就写 `none`。**如果用户要求你做文字、信息提取、加工类任务，或你的子任务涉及到这类功能，必须在 note 中完整抄写所有相关的文字。note 字段的作用是记录，不限篇幅。** 这个字段非常重要，后续的操作可能需要依赖这个字段的信息来进行决策。注意：只记录当前页面中收集到的关键信息，不得遗漏，不必重复历史重要信息（这个字段在系统底层会一直保留）。\n3. **explain**：在动作格式中，使用 explain 描述你要和什么元素交互。**必须唯一指代，不能模糊。** **【强调】当触发 CLICK 动作时，explain 只能说“点击xxx”，描述必须绝对简短。**\n4. **action**：根据前文定义的动作空间，输出具体的动作和参数（如 `action:CLICK\\tpoint:500,500`）。\n5. **key_process**：对于一个长程任务（通常由多个子任务组成），你必须在每次 action 的 key_process 字段中记录当前已经取得的关键进展。必须明确确认当前已经完成的子任务（例如：“子任务1：打开App-已完成；子任务2：搜索特定商品-已完成；子任务3：确认商品价格信息-进行中”）。这有助于你保持对全局任务的掌控，避免迷失方向。**如果没有明显的进展，可以写 `none`。**\n---\n## 行动原则 (Action Principles)\n*本章节定义了你作为 Agent 必须绝对遵守的底层逻辑、安全红线与核心机制。*\n### 1. 【最高优先级】安全边界、指令遵循与诚实原则\n- **安全第一**：绝对禁止给用户直接下单支付。遇到支付、登录等关键敏感操作，必须使用 `CALL_USER` (tag: `confirm_action`) 请求用户接管。绝对禁止直接删除任何东西。遇到删除等关键敏感操作，必须使用 `CALL_USER` (tag: `confirm_action`) 请求用户接管。**绝对禁止擅自退出登录、注销账号、切换账号。遇到退出登录 / 注销账号 / 切换账号（含点击\"退出登录\"\"退出\"\"注销\"\"切换账号\"及其二次确认弹窗）时，必须使用 `CALL_USER` (tag: `confirm_action`) 交给用户确认，绝对不要替用户点击确认按钮。**\n- **协议/隐私授权由用户决定**：遇到\"用户协议、隐私协议、隐私政策、服务条款、权限申请\"等任意形式的协议/授权确认页面或弹窗，**绝对不要代替用户点击\"同意/允许/接受/继续/我已阅读\"或勾选协议复选框**，必须立即使用 `CALL_USER` (tag: `confirm_action`) 把决定权交给用户。即使\"不同意将无法继续使用\"也必须由用户本人决定。\n- **指令优先**：严格遵循用户的指令。如果有多轮对话，优先遵守最后一轮的指令。\n- **诚实原则**：你必须诚实。用户的任务可能是完不成的。**完不成是完全可接受的答案**。如果经过合理尝试确认无法完成，必须使用 `ABORT` 诚实地报告失败结果并终止任务，绝不伪造操作或结果。\n### 2. 【异常处理】防死循环与降级机制\n- **图片缺失或空白页面处理**：如果你发现**没有收到图片**，或识别到当前屏幕截图是空白的（纯白、纯黑或加载失败），必须立即使用 `CALL_USER` (tag: `screenshot_issue`) 求助，严禁盲目操作。**系统可能因为无法截图或工程错误导致没传图片给你。你需要在检查到没传图片时立刻报告。在这种情况下历史状态是不可信的，如果没看到图，绝对不能依靠历史状态做决策。**\n- **打破循环与放弃子任务**：如果发现历史记录中存在重复、循环的动作（包括重复 `CLICK` 或重复 `SLIDE` 或重复 `AWAKE` 或重复 `CALL_USER`）且超过3次，**允许放弃当前子任务**。**【重要】一旦决定放弃某个子任务，在后续的执行过程中必须直接跳过该子任务，绝对禁止重新尝试。**\n- **滑动限制**：连续 `SLIDE` 达到 5 次后，必须作出决定或使用 `CALL_USER` 询问用户。**绝对禁止连续 `SLIDE` 超过 6 次**。\n- **全局降级链路**：如果多次操作没生效 -> 尝试使用 `BACK` 指令 -> 如果多次 `BACK` 依然没生效 -> 使用 `ABORT` 终止任务，并在 value 中详细说明原因。\n---\n## 通用操作指南 (General Operation Guidelines)\n*本章节定义了在处理常见 GUI 交互场景（如启动、搜索、输入、导航）时的具体操作规范与技巧。*\n### 1. App 启动与任务流转\n- **强制使用 AWAKE**：启动 App 时，**必须且仅能**使用 `AWAKE` 指令。严禁尝试通过图像识别去寻找并 `CLICK` 桌面上的 App 图标。\n- **初始截屏是 黑屏时请使用 AWAKE**: 当一个新的任务的第一张截图是**黑屏**时， 请根据任务描述，使用 `AWAKE` 打开app，**当且仅当第一张截图是黑屏时使用**。\n- **Native App 优先**：指定了 App 名称的任务，优先打开对应的原生 App。只有在多次尝试 `AWAKE` 失败，或明确确认未安装时，才允许降级使用浏览器搜索。\n- **状态重置**：在 APP 内部执行任务时，如果某个子任务已经执行完毕，请尽量操作返回到该 APP 的首页/主界面，然后再开始执行下一个子任务。\n### 2. 输入框交互与清理（适用于所有 App）\n- **输入前聚焦检查（不依赖键盘弹起）**：当前运行环境下，点击输入框后**通常不会弹出软键盘/输入法**。因此**绝对不要把\"键盘是否弹起\"当作能否输入、或上一步点击是否生效的判断依据**。想输入文字时，先用 `CLICK` 点击目标输入框使其获得焦点，**下一步即可直接 `TYPE`，无需等待键盘出现，也不要因为没看到键盘就反复重试点击**。\n- **点击输入框是否成功的判断（无输入法场景）**：不要靠\"键盘是否弹起\"来判断，应综合以下任一证据来判断输入框已被激活/获得焦点：输入框内出现闪烁的光标、输入框边框高亮或变色、占位提示文字（placeholder）变化或消失、输入框区域呈选中/激活态、或页面因聚焦发生的其它变化（如底部出现确认/发送条）。出现上述任一迹象即视为点击成功，可直接进行 `TYPE`。\n  - **看不出聚焦迹象时的降级**：若点击后从截图上**看不出任何聚焦迹象**，也不要纠结于等待键盘——可直接尝试一次 `TYPE`，再在下一步依据输入框中是否出现你输入的文字来判断是否真正生效；若仍无文字，再考虑重新点击输入框或换用其它输入入口。\n- **TYPE 原则与输入框清理**：在准备使用 `TYPE` 输入文字前，注意输入框内可能有预定义内容，请按以下原则处理：\n  - **需要用户登录、支付、下单输入时，请直接出`CALL_USER`, 不要出TYPE**。\n  - **直接 TYPE（预定义推荐词）**：输入框、搜索框中可能有 App 预定义的搜索推荐词（通常是灰色的字，一般在第一次激活搜索框时出现）。此时无需清理，直接使用 `TYPE` 即可覆盖。\n  - **尝试清理（历史关键词）**：如果是上一次搜索留下的历史关键词（通常是实色字），则需要尝试清空搜索框，并严格 follow 以下降级规则：\n    - **仔细检查输入框右侧图标**：如果是“相机”标志，点击会进入拍照相关动作，请勿误触；**只有明确看见“X”标志，才是清空输入框的按钮**。\n    - **退格键清理**：仅当屏幕上确实存在**可见键盘**时，才可尝试多次 `CLICK` 键盘上的退格键（删除键）来清空。**注意：本环境点击输入框通常不弹键盘，若没有可见键盘则无法使用退格键清理，应直接改用 `TYPE` 覆盖输入。**\n    - **【严格限制】无论采用何种清空方式（点X或点退格），绝对不要重复操作超过 3 次。** 重复达到 3 次后，必须触发降级处理：不再纠结于清空输入框，直接尝试使用 `TYPE` 打字输入覆盖。\n### 3. 搜索与筛选策略\n- **搜索优先**：如果不确定下一步该如何操作，或者不清楚目标元素的位置，**首先应该尝试使用搜索功能**。\n- **利用搜索建议**：在搜索框输入内容后，通常会出现下拉的推荐/联想选项。**请优先考虑直接 `CLICK` 这些推荐选项以快速到达目标**，这通常比强行点击键盘上的搜索键更有效。\n- **【重点】搜索降级与免责**：\n  - **你不为 App 的搜索引擎能力负责。** 并非所有的筛选条件或初始搜索关键词都是有用的。\n  - 如果尝试了一次没找到筛选条件，或使用初始关键词没找到目标，**必须同意降级**：寻找搜索入口并使用更直接的搜索关键词做搜索。\n  - 如果查找结果不存在（例如页面显示无结果），**直接使用 `COMPLETE` 或 `ABORT` 报告结果即可**，不要反复纠结于无效的搜索。\n### 4. 导航与返回 (BACK)\n- 如果页面左上方有可见的返回按钮（如“<”或返回箭头），则**应该优先使用 `CLICK` 点击该返回按钮**。\n- 否则，可以考虑使用 `BACK` 动作做快速返回。\n- 注意：`BACK` 动作不一定被 App 支持。如果发现 `BACK` 不生效，**考虑使用 `SLIDE` 从屏幕最左滑动到屏幕最右**（例如起点 x=0，终点 x=800）来尝试侧滑回退。\n### 5. 滑动操作规范 (SLIDE)\n当需要使用 `SLIDE` 动作浏览页面时，请严格遵守以下 4 个方向的物理规律与描述规范：\n1. **向下（从上到下）滑动**：坐标 y 轴从小到大。会导致屏幕上方的内容被拉下来显示。**统一描述为：“从上到下滑动，显示上一屏幕内容”。**\n2. **向上（从下到上）滑动**：坐标 y 轴从大到小。会导致屏幕下方的内容被拉上来显示。**统一描述为：“从下到上滑动，显示下一屏幕内容”。**\n3. **向右（从左到右）滑动**：坐标 x 轴从小到大。会导致屏幕左侧的内容被拉出来显示（常用于侧滑返回或查看上一页）。**统一描述为：“从左到右滑动，显示左侧/上一页内容”。**\n4. **向左（从右到左）滑动**：坐标 x 轴从大到小。会导致屏幕右侧的内容被拉出来显示（常用于轮播图或查看下一页）。**统一描述为：“从右到左滑动，显示右侧/下一页内容”。**\n---\n## 特定 App 操作指南 (App-Specific Guidelines)\n*本章节定义了在特定 App 中执行任务时，需遵循的专属交互逻辑与注意事项。*\n### 1. 社交媒体平台通用规则 (抖音、小红书、微博)\n- **置顶帖与最新帖的严格区分**：请务必注意，**“置顶帖”和“最近/最新发布的帖子”不是一回事**。\n  - 创作者通常会将历史的高赞或重要内容固定在主页最上方，这些帖子会带有明确的“置顶”标签，但它们往往不是最新发布的内容。\n  - **操作要求**：当用户要求你查看某人的“最新”或“最近”发布的帖子/视频时，**必须仔细检查并跳过所有带有“置顶”标记的内容**，去寻找按时间线排序的第一篇常规帖子进行点击和浏览。\n### 2. 小红书 (Xiaohongshu) 专属指南\n当用户需要你浏览、总结小红书帖子的内容时，必须严格遵循以下步骤：\n- **判断帖子类型**：首先观察并判断当前是视频帖还是图文帖。\n  - **视频帖**：点击查看视频详情或简介内容。\n  - **图文帖**：检查是否包含多张图片（通常有页面指示器，如底部的小圆点或页码）。\n- **图文帖浏览顺序（先图后文）**：\n  1. **先看图**：如果有多张图片，**必须首先滑动屏幕（从右向左滑动，即 `SLIDE` 起点在右，终点在左）浏览完所有的图片**。\n  2. **后看文**：图片全部浏览完毕后，**其次再向下滑动屏幕**（即 `SLIDE` 起点在下，终点在上）查看下方所有的文字描述内容。\n- **详细记录**：在整个浏览过程中，**必须在 `note` 字段中尽可能详细地记录**你所看到的图片关键信息和文字内容，确保最终能够输出高质量的总结。\n### 3. 地图类软件 (高德地图、百度地图等) 专属指南\n- **输入框快捷清理与覆盖**：对于地图软件的输入框，只要使用 `CLICK` 点击到希望清除的文字，通常就能够直接选中对应文字。\n  - **操作要求**：当文字处于选中状态时，无需去寻找“X”按钮或使用退格键，你可以直接使用 `TYPE` 打字，新输入的文字会自动实现对原有选中文字的覆盖。\n### 4. 阶跃AI 专属指南\n- **没有\"一键删除全部聊天历史\"的功能**：阶跃AI **不提供**直接删除所有聊天历史的入口，只能对聊天列表中的会话**逐一删除**。当用户要求\"删除所有 / 清空聊天历史\"时，**绝对不要假设存在批量删除入口**，必须先使用 `INFO` 向用户确认是否需要**逐一删除**，得到用户明确同意后再按下面的流程逐条处理。\n- **删除单条聊天历史的操作流程**：\n  1. **进入左侧聊天列表**：首先打开/进入左侧的聊天列表。\n  2. **长按指定聊天**：在列表中找到目标会话，使用 `LONGPRESS` 长按该条聊天。\n  3. **弹出菜单后交给用户接管，不要自己点删除**：长按后会弹出包含\"删除\"的菜单。**此时严禁自己 `CLICK`\"删除\"**，必须立即使用 `CALL_USER` (tag: `confirm_action`) **弹出接管**，把\"删除\"这一步交给用户本人点击确认。\n- **【重点·必须接管】删除聊天记录是删除类敏感操作，必须弹出接管**：只要走到\"删除聊天记录\"这一步（无论是点击菜单里的\"删除\"，还是删除的二次确认弹窗），都**必须**遵循最高优先级安全边界，出 `CALL_USER` (tag: `confirm_action`) **弹出接管**由用户操作，**绝对禁止**由你替用户点击\"删除\"\"确认\"\"移除\"等任何执行删除的按钮。\n---\n## 重要\n*** 遇到登录、退出登录/注销账号/切换账号、支付、下单、发布、删除、授权（包括用户协议、隐私协议、隐私政策、服务条款等任何协议确认页面或弹窗）等敏感操作时，请一定要出`CALL_USER`，不要擅自操作，更不要替用户勾选\"同意\"或点击\"同意/允许/继续/退出/删除\"按钮***。\n*** 遇到登录、退出登录/注销账号/切换账号、支付、下单、发布、删除、授权（包括用户协议、隐私协议、隐私政策、服务条款等任何协议确认页面或弹窗）等敏感操作时，请一定要出`CALL_USER`，不要擅自操作，更不要替用户勾选\"同意\"或点击\"同意/允许/继续/退出/删除\"按钮***。\n*** 遇到登录、退出登录/注销账号/切换账号、支付、下单、发布、删除、授权（包括用户协议、隐私协议、隐私政策、服务条款等任何协议确认页面或弹窗）等敏感操作时，请一定要出`CALL_USER`，不要擅自操作，更不要替用户勾选\"同意\"或点击\"同意/允许/继续/退出/删除\"按钮***。";
        TASK_DEFINE_PROMPT = "\n## 现状\n### 1. 用户给你的任务：\n%s\n\n### 2. 当前时间是：\n%s\n";
        INSTRUCTION_PROMPT = "explain 字段要尽量简短。10个字以内。\n\n输出结构为：\nverify:xx 证据表明上个动作是否生效\tnote:当前页面总结出的关键信息\texplain:解释的内容\taction:动作空间和对应的参数\tkey_process:当前的关键进展,如果没有明显的进展可以写none\n\n思考结束后，以verify字段开头，说明上一步操作是否生效。每个字段用\t做分隔。输出csv 风格以\t 分割字段的action，不要使用json。";
    }

    private final void applyCompressionConfig(SessionRuntimeState state, StateCompressionConfig config) {
        state.setCompressionConfigIssues(config.validationIssues());
        state.setCompressionConfig(config.sanitized());
    }

    private final String buildCompressedStateMessage(String task, String compressedState, int compressedUptoStep) {
        String strNormalizeCompressedState = normalizeCompressedState(compressedState, task, compressedUptoStep > 0 ? B7.a.h(compressedUptoStep, "1-") : "none");
        if (strNormalizeCompressedState == null) {
            return null;
        }
        return B7.a.m("以下是对更早历史状态的一轮压缩结果。它保留了更早步骤中的关键用户输入、页面信息、关键进展和风险点。若其与当前截图冲突，始终以当前截图为准。\n", strNormalizeCompressedState, "\n以上压缩内容只出现这一轮，不要要求系统再次展开旧历史。");
    }

    private final String buildCompressionFailureDetail(String message, String responsePreview) {
        return B7.a.n("message=", summarizeForLog(message), " response_preview=", summarizeForLog(responsePreview));
    }

    private final LinkedHashMap<String, Object> buildCompressionInfo(SessionRuntimeState state, boolean triggered, String mode, int currentStep, Integer chunkStartStep, Integer chunkEndStep, String compressionTraceId, String reason, String detail) {
        return kotlin.collections.a.O(new Pair("triggered", Boolean.valueOf(triggered)), new Pair("mode", mode), new Pair("reason", reason == null ? "none" : reason), new Pair("detail", detail == null ? "none" : detail), new Pair("enabled", Boolean.valueOf(state.getCompressionConfig().getEnabled())), new Pair("configValid", Boolean.valueOf(state.getCompressionConfigIssues().isEmpty())), new Pair("configIssues", state.getCompressionConfigIssues().isEmpty() ? "none" : v.I0(state.getCompressionConfigIssues(), ",", null, null, null, 62)), new Pair("interval", Integer.valueOf(state.getCompressionConfig().getInterval())), new Pair("recentWindow", Integer.valueOf(state.getCompressionConfig().getRecentWindow())), new Pair("maxFieldItems", Integer.valueOf(state.getCompressionConfig().getMaxFieldItems())), new Pair("currentStep", Integer.valueOf(currentStep)), new Pair("chunkStartStep", Integer.valueOf(chunkStartStep != null ? chunkStartStep.intValue() : 0)), new Pair("chunkEndStep", Integer.valueOf(chunkEndStep != null ? chunkEndStep.intValue() : 0)), new Pair("compressionTraceId", compressionTraceId != null ? compressionTraceId : "none"), new Pair("compressedUptoStep", Integer.valueOf(state.getCompressedUptoStep())), new Pair("rawHistoryStartStep", Integer.valueOf(state.getCompressedUptoStep() + 1)), new Pair("rawHistoryEndStep", Integer.valueOf(state.getEnvironmentHistory().size())));
    }

    public static /* synthetic */ LinkedHashMap buildCompressionInfo$default(StepGelabModelCell stepGelabModelCell, SessionRuntimeState sessionRuntimeState, boolean z10, String str, int i, Integer num, Integer num2, String str2, String str3, String str4, int i6, Object obj) {
        return stepGelabModelCell.buildCompressionInfo(sessionRuntimeState, z10, str, i, num, num2, (i6 & 64) != 0 ? null : str2, str3, str4);
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
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(chunkEndStep, "\n你是一个 GUI Agent 历史状态压缩器。你的任务不是预测动作，而是把较早历史压缩成一段结构化状态，供后续 parser 继续使用。\n\n压缩要求：\n1. 你只能输出一个压缩块，不要输出额外解释，不要输出 JSON，不要输出动作指令。\n2. 必须保留关键的原始输入信息：用户任务、用户补充回复、关键页面观察、关键进展、当前子目标、风险点、最后有效状态。\n3. 字段必须清晰、稳定，严格使用下面模板，缺失内容写 `- none` 或 `none`。\n4. 你需要把旧的压缩状态和本轮新增步骤合并成一份新的压缩状态。\n5. 输出中必须保留开始和结束标记，确保系统后续可以稳定解析。\n\n请严格输出以下格式：\n<<<STATE_COMPRESSION>>>\ncovered_steps: 1-", "\ntask: ", task, "\nimportant_user_inputs:\n- ...\nimportant_observations:\n- ...\ncompleted_progress:\n- ...\ncurrent_subgoal:\n...\npending_risks:\n- ...\nlast_effective_state:\n...\n<<<END_STATE_COMPRESSION>>>\n\n以下是已有压缩状态：\n");
        b.B(sbK, str, "\n\n以下是本轮需要新增压缩的原始步骤（第", chunkStartStep, "步到第");
        sbK.append(chunkEndStep);
        sbK.append("步）：\n");
        sbK.append(string2);
        sbK.append("\n        ");
        return n.R(sbK.toString());
    }

    private final String buildCompressionSessionId(String sessionId) {
        return sessionId;
    }

    private final String buildFallbackCompressedState(String task, String previousCompressedStateText, int chunkStartStep, int chunkEndStep, SessionRuntimeState state) {
        Object objA;
        LinkedHashMap linkedHashMap;
        String str;
        String strC;
        String str2;
        String str3;
        Map<String, ? extends Object> map;
        String str4;
        String strC2;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
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
        if (linkedHashMap != null && (str10 = (String) linkedHashMap.get("important_user_inputs")) != null) {
            arrayList.addAll(listifyTextField(str10));
        }
        if (linkedHashMap != null && (str9 = (String) linkedHashMap.get("important_observations")) != null) {
            arrayList2.addAll(listifyTextField(str9));
        }
        if (linkedHashMap != null && (str8 = (String) linkedHashMap.get("completed_progress")) != null) {
            arrayList3.addAll(listifyTextField(str8));
        }
        if (linkedHashMap != null && (str7 = (String) linkedHashMap.get("pending_risks")) != null) {
            arrayList4.addAll(listifyTextField(str7));
        }
        String string = (linkedHashMap == null || (str6 = (String) linkedHashMap.get("current_subgoal")) == null) ? null : m.R0(str6).toString();
        String str11 = "";
        if (string == null) {
            string = "";
        }
        if (m.s0(string)) {
            string = "none";
        }
        String string2 = (linkedHashMap == null || (str5 = (String) linkedHashMap.get("last_effective_state")) == null) ? null : m.R0(str5).toString();
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
                    str3 = str11;
                } else {
                    String userComment = environmentEntry.getUserComment();
                    String string3 = userComment != null ? m.R0(userComment).toString() : null;
                    if (string3 == null) {
                        string3 = str11;
                    }
                    str = string2;
                    String str12 = string;
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
                        str4 = str2;
                        strC2 = str12;
                    } else {
                        strC2 = androidx.constraintlayout.core.dsl.a.c(i, "step ", ": ", actionString3);
                        str4 = strC2;
                    }
                    String actionString4 = getActionString(map, "verify");
                    str3 = str11;
                    String str13 = strC;
                    if (m.h0(actionString4, "不符合", false)) {
                        arrayList4.add("step " + i + ": " + actionString4);
                    }
                    String actionString5 = getActionString(map, GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION);
                    String str14 = strC2;
                    String str15 = str4;
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
                    strC = str13;
                    string = str14;
                    str2 = str15;
                }
                if (i == chunkEndStep) {
                    break;
                }
                i++;
                string2 = str;
                str11 = str3;
            }
        } else {
            str = string2;
            strC = "none";
            str2 = strC;
        }
        return compressedStateToText(new CompressedState(B7.a.h(chunkEndStep, "1-"), task, truncateItems(arrayList, state.getCompressionConfig().getMaxFieldItems()), truncateItems(arrayList2, state.getCompressionConfig().getMaxFieldItems()), truncateItems(arrayList3, state.getCompressionConfig().getMaxFieldItems()), !k.b(string, "none") ? string : str2, truncateItems(arrayList4, state.getCompressionConfig().getMaxFieldItems()), !k.b(strC, "none") ? strC : !k.b(str2, "none") ? str2 : str));
    }

    private final String buildTaskWithApp(za.e session) {
        String str = session.c;
        String str2 = session.b;
        return (str == null || m.s0(str)) ? str2 : B7.a.B(str2, "\n\n指定App：", session.c);
    }

    private final String compressedStateToText(CompressedState state) {
        LinkedHashMap linkedHashMapO = kotlin.collections.a.O(new Pair("covered_steps", state.getCoveredSteps()), new Pair("task", state.getTask()), new Pair("important_user_inputs", state.getImportantUserInputs().isEmpty() ? o.M("- none") : state.getImportantUserInputs()), new Pair("important_observations", state.getImportantObservations().isEmpty() ? o.M("- none") : state.getImportantObservations()), new Pair("completed_progress", state.getCompletedProgress().isEmpty() ? o.M("- none") : state.getCompletedProgress()), new Pair("current_subgoal", state.getCurrentSubgoal()), new Pair("pending_risks", state.getPendingRisks().isEmpty() ? o.M("- none") : state.getPendingRisks()), new Pair("last_effective_state", state.getLastEffectiveState()));
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

    private final String escapeJson(String text) {
        return t.c0(t.c0(t.c0(t.c0(t.c0(text, "\\", "\\\\"), "\"", "\\\""), "\n", "\\n"), "\r", "\\r"), "\t", "\\t");
    }

    private final void evictCompressedImageBase64(SessionRuntimeState state) {
        int compressedUptoStep = state.getCompressedUptoStep();
        for (int i = 0; i < compressedUptoStep; i++) {
            EnvironmentEntry environmentEntry = (EnvironmentEntry) v.D0(i, state.getEnvironmentHistory());
            if (environmentEntry != null && environmentEntry.getImageBase64() != null) {
                state.getEnvironmentHistory().set(i, EnvironmentEntry.copy$default(environmentEntry, null, null, null, 6, null));
            }
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

    private final String getActionString(Map<String, ? extends Object> action, String key) {
        String string;
        Object obj = action.get(key);
        String string2 = (obj == null || (string = obj.toString()) == null) ? null : m.R0(string).toString();
        if (string2 == null) {
            string2 = "";
        }
        return string2.length() == 0 ? "none" : string2;
    }

    private final List<Integer> getPointOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        if (jsonElement.isJsonArray()) {
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            k.e(asJsonArray, "getAsJsonArray(...)");
            return parseJsonPoint(asJsonArray);
        }
        if (jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            k.e(asJsonObject, "getAsJsonObject(...)");
            return parseJsonPointObject(asJsonObject);
        }
        if (!jsonElement.isJsonPrimitive()) {
            return null;
        }
        String asString = jsonElement.getAsString();
        k.e(asString, "getAsString(...)");
        return parseJsonPointText(asString);
    }

    private final SessionRuntimeState getSessionState(String sessionId) {
        SessionRuntimeState sessionRuntimeStateComputeIfAbsent = this.sessionStates.computeIfAbsent(sessionId, new g(new m5.a(20), 8));
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

    private final String getStringOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.isJsonPrimitive() ? jsonElement.getAsString() : jsonElement.toString();
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

    private final String mapToJson(Map<String, ? extends Object> map) {
        StringBuilder sb = new StringBuilder("{");
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (i > 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(escapeJson((String) entry.getKey()));
            sb.append("\":");
            sb.append(toJsonValue(entry.getValue()));
            i = i6;
        }
        sb.append("}");
        return sb.toString();
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
        evictCompressedImageBase64(state);
        state.setLastCompressionInfo(buildCompressionInfo$default(this, state, true, "fallback", size, Integer.valueOf(compressedUptoStep), Integer.valueOf(iComputeCompressionTarget), null, null, null, 64, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01e4 A[Catch: all -> 0x01eb, TryCatch #3 {all -> 0x01eb, blocks: (B:42:0x01ce, B:44:0x01e4, B:49:0x01f4, B:51:0x0205, B:56:0x0225, B:58:0x022b, B:60:0x0232, B:62:0x023c, B:63:0x0244, B:64:0x024e, B:55:0x0221, B:65:0x024f, B:66:0x0282, B:48:0x01ef, B:52:0x020d), top: B:122:0x01ce, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ef A[Catch: all -> 0x01eb, TryCatch #3 {all -> 0x01eb, blocks: (B:42:0x01ce, B:44:0x01e4, B:49:0x01f4, B:51:0x0205, B:56:0x0225, B:58:0x022b, B:60:0x0232, B:62:0x023c, B:63:0x0244, B:64:0x024e, B:55:0x0221, B:65:0x024f, B:66:0x0282, B:48:0x01ef, B:52:0x020d), top: B:122:0x01ce, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0205 A[Catch: all -> 0x01eb, TRY_LEAVE, TryCatch #3 {all -> 0x01eb, blocks: (B:42:0x01ce, B:44:0x01e4, B:49:0x01f4, B:51:0x0205, B:56:0x0225, B:58:0x022b, B:60:0x0232, B:62:0x023c, B:63:0x0244, B:64:0x024e, B:55:0x0221, B:65:0x024f, B:66:0x0282, B:48:0x01ef, B:52:0x020d), top: B:122:0x01ce, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024f A[Catch: all -> 0x01eb, TryCatch #3 {all -> 0x01eb, blocks: (B:42:0x01ce, B:44:0x01e4, B:49:0x01f4, B:51:0x0205, B:56:0x0225, B:58:0x022b, B:60:0x0232, B:62:0x023c, B:63:0x0244, B:64:0x024e, B:55:0x0221, B:65:0x024f, B:66:0x0282, B:48:0x01ef, B:52:0x020d), top: B:122:0x01ce, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x032b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object maybeCompressHistoryWithLlm(java.lang.String r31, stepai.aios.guiagent.config.LlmConfig r32, java.lang.String r33, stepai.aios.guiagent.llm.cell.StepGelabModelCell.SessionRuntimeState r34, H7.c<? super C7.r> r35) {
        /*
            Method dump skipped, instructions count: 893
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.StepGelabModelCell.maybeCompressHistoryWithLlm(java.lang.String, stepai.aios.guiagent.config.LlmConfig, java.lang.String, stepai.aios.guiagent.llm.cell.StepGelabModelCell$SessionRuntimeState, H7.c):java.lang.Object");
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
        String str3 = compressedStateText.get("task");
        if (str3 == null) {
            str3 = "";
        }
        if (m.s0(str3)) {
            str3 = str;
        }
        String str4 = str3.length() == 0 ? "none" : str3;
        String str5 = compressedStateText.get("covered_steps");
        if (str5 == null) {
            str5 = "";
        }
        String str6 = m.s0(str5) ? str2 : str5;
        if (str6.length() == 0) {
            str6 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        String str7 = str6;
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
        return compressedStateToText(new CompressedState(str7, str4, listListifyTextField, listListifyTextField2, listListifyTextField3, str9, listListifyTextField4, m.s0(str11) ? "none" : str11));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0269, code lost:
    
        if (r0.equals("HOME") != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0272, code lost:
    
        if (r0.equals("BACK") != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
    
        if (r0.equals("CALLUSER") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0279, code lost:
    
        if (r0.equals("LONGPRESS") != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x027b, code lost:
    
        r13 = requirePoint(r14.get("point"), r0, "point");
        r1.put("x", java.lang.String.valueOf(r13.get(0).intValue()));
        r1.put("y", java.lang.String.valueOf(r13.get(1).intValue()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02a9, code lost:
    
        if (r0.equals("LONGPRESS") == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02ab, code lost:
    
        r1.put(androidx.constraintlayout.core.motion.utils.TypedValues.TransitionType.S_DURATION, "1000");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
    
        if (r0.equals("TAKEOVER") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
    
        r13 = r14.get("value");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
    
        if ((r13 instanceof java.lang.String) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        r13 = (java.lang.String) r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0084, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        if (r13 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008b, code lost:
    
        if (j9.m.s0(r13) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        r1.put("message", r13);
        r15 = r14.get("tag");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
    
        if ((r15 instanceof java.lang.String) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
    
        r15 = (java.lang.String) r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009d, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
    
        if (r15 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a4, code lost:
    
        if (j9.m.s0(r15) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a8, code lost:
    
        r1.put("tag", r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b4, code lost:
    
        throw new java.lang.IllegalArgumentException("[CALL_USER] value is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0125, code lost:
    
        if (r0.equals("CLICK") != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
    
        if (r0.equals("CALL_USER") != false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x032f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.Map<java.lang.String, java.lang.String> parseActionParam(java.util.HashMap<java.lang.String, java.lang.Object> r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.StepGelabModelCell.parseActionParam(java.util.HashMap, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        if (r2.equals("CALL_USER") == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        if (r2.equals("CALLUSER") == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (r2.equals("TAKEOVER") == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        return stepai.aios.guiagent.config.ActionType.TAKEOVER;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
    
        if (r2.equals("SLIDE") == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00de, code lost:
    
        if (r2.equals("SCROLL") == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e3, code lost:
    
        return stepai.aios.guiagent.config.ActionType.SWIPE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final stepai.aios.guiagent.config.ActionType parseActionType(java.util.HashMap<java.lang.String, java.lang.Object> r3) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.StepGelabModelCell.parseActionType(java.util.HashMap):stepai.aios.guiagent.config.ActionType");
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

    private final LinkedHashMap<String, Object> parseJsonParam(String rawText) {
        String strExtractJsonObject;
        Object objA;
        JsonElement string;
        String string2 = m.R0(rawText).toString();
        if (string2.length() != 0 && (strExtractJsonObject = extractJsonObject(m.R0(m.z0(m.y0("```", m.y0("```JSON", m.y0("```json", string2))), "```")).toString())) != null) {
            try {
                string = JsonParser.parseString(strExtractJsonObject);
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            if (string.isJsonObject()) {
                JsonObject asJsonObject = string.getAsJsonObject();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str : o.N(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "summary", "key_process", "explain", "value", "return", "tag", "note", "verify", "direction")) {
                    k.c(asJsonObject);
                    String stringOrNull = getStringOrNull(asJsonObject, str);
                    String string3 = stringOrNull != null ? m.R0(stringOrNull).toString() : null;
                    if (string3 != null && string3.length() != 0) {
                        linkedHashMap.put(str, string3);
                    }
                }
                for (String str2 : o.N("point", "point1", "point2")) {
                    k.c(asJsonObject);
                    List<Integer> pointOrNull = getPointOrNull(asJsonObject, str2);
                    if (pointOrNull != null) {
                        linkedHashMap.put(str2, pointOrNull);
                    }
                }
                boolean zContainsKey = linkedHashMap.containsKey(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION);
                objA = linkedHashMap;
                if (!zContainsKey) {
                    objA = null;
                }
                return (LinkedHashMap) (objA instanceof Result.Failure ? null : objA);
            }
        }
        return null;
    }

    private final List<Integer> parseJsonPoint(JsonArray array) {
        if (array.size() >= 2) {
            return o.N(Integer.valueOf(array.get(0).getAsInt()), Integer.valueOf(array.get(1).getAsInt()));
        }
        throw new IllegalArgumentException("Expected point array with at least 2 items");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<java.lang.Integer> parseJsonPointObject(com.google.gson.JsonObject r4) {
        /*
            r3 = this;
            java.lang.String r3 = "x"
            com.google.gson.JsonElement r3 = r4.get(r3)
            r0 = 0
            if (r3 == 0) goto L18
            boolean r1 = r3.isJsonNull()
            if (r1 != 0) goto L10
            goto L11
        L10:
            r3 = r0
        L11:
            if (r3 == 0) goto L18
            int r3 = r3.getAsInt()
            goto L2e
        L18:
            java.lang.String r3 = "left"
            com.google.gson.JsonElement r3 = r4.get(r3)
            if (r3 == 0) goto L6c
            boolean r1 = r3.isJsonNull()
            if (r1 != 0) goto L27
            goto L28
        L27:
            r3 = r0
        L28:
            if (r3 == 0) goto L6c
            int r3 = r3.getAsInt()
        L2e:
            java.lang.String r1 = "y"
            com.google.gson.JsonElement r1 = r4.get(r1)
            if (r1 == 0) goto L45
            boolean r2 = r1.isJsonNull()
            if (r2 != 0) goto L3d
            goto L3e
        L3d:
            r1 = r0
        L3e:
            if (r1 == 0) goto L45
            int r4 = r1.getAsInt()
            goto L5b
        L45:
            java.lang.String r1 = "top"
            com.google.gson.JsonElement r4 = r4.get(r1)
            if (r4 == 0) goto L6c
            boolean r1 = r4.isJsonNull()
            if (r1 != 0) goto L54
            goto L55
        L54:
            r4 = r0
        L55:
            if (r4 == 0) goto L6c
            int r4 = r4.getAsInt()
        L5b:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Integer[] r3 = new java.lang.Integer[]{r3, r4}
            java.util.List r3 = H4.o.N(r3)
            return r3
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.StepGelabModelCell.parseJsonPointObject(com.google.gson.JsonObject):java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<Integer> parseJsonPointText(String text) {
        List listO0 = kotlin.sequences.a.o0(kotlin.sequences.a.m0(Regex.c(new Regex("-?\\d+"), text), new m5.a(18)));
        if (listO0.size() >= 2) {
            return o.N(listO0.get(0), listO0.get(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int parseJsonPointText$lambda$0(InterfaceC1616j it) {
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
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.StepGelabModelCell.parseParam(java.lang.String):java.util.HashMap");
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

    public static /* synthetic */ String prepareRequestState$default(StepGelabModelCell stepGelabModelCell, za.e eVar, String str, SessionRuntimeState sessionRuntimeState, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return stepGelabModelCell.prepareRequestState(eVar, str, sessionRuntimeState, str2);
    }

    private final List<Message> renderRequestMessages(String taskWithApp, SessionRuntimeState state) {
        String str;
        Object imageBase64;
        String str2 = LocalDateTime.now().format(dateFormatter);
        ArrayList<MessageContentBuilder> arrayList = new ArrayList();
        arrayList.add(new MessageContentBuilder.Text(String.format(TASK_DEFINE_PROMPT, Arrays.copyOf(new Object[]{taskWithApp, str2}, 2)).concat("\n\n以下是你之前的操作历史回顾：")));
        String strBuildCompressedStateMessage = buildCompressedStateMessage(taskWithApp, state.getCompressedStateText(), state.getCompressedUptoStep());
        if (strBuildCompressedStateMessage != null) {
            arrayList.add(new MessageContentBuilder.Text(strBuildCompressedStateMessage));
            arrayList.add(new MessageContentBuilder.Text(a.i(state.getCompressedUptoStep() + 1, "下面保留的是压缩之后仍需逐步回顾的原始步骤，起始于原始第", "步。请把压缩内容和这些原始步骤一起用于决策。")));
        }
        int compressedUptoStep = state.getCompressedUptoStep();
        List listW0 = v.w0(state.getEnvironmentHistory(), compressedUptoStep);
        int i = 0;
        for (Object obj : listW0) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            EnvironmentEntry environmentEntry = (EnvironmentEntry) obj;
            int i10 = compressedUptoStep + i;
            LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap) v.D0(i10, state.getActionHistory());
            LinkedHashMap<String, Object> linkedHashMapSanitizeActionForPrompt = linkedHashMap != null ? sanitizeActionForPrompt(linkedHashMap) : null;
            int i11 = i10 + 1;
            String userComment = environmentEntry.getUserComment();
            String string = userComment != null ? m.R0(userComment).toString() : null;
            if (string == null) {
                string = "";
            }
            arrayList.add(new MessageContentBuilder.Text("这是第" + i11 + "步的环境信息：\n" + (string.length() > 0 ? B7.a.m("用户回复说：\n---------\n", string, "\n---------\n用户回复结束\n\n") : "") + (i >= listW0.size() + (-1) ? a.i(i11, "根据协议，第", "步有截图：\n") : a.i(i11, "根据协议，第", "步截图不展示\n\n"))));
            if (i == listW0.size() - 1) {
                arrayList.add(new MessageContentBuilder.Text(a.i(i11, "<-------------------从这里开始是最近原始第", "步起的环境信息，务必仔细描述图片，仔细描述图片，仔细描述图片，看图操作看图操作看图操作------------------->\n\n")));
            }
            if (i >= listW0.size() - 1) {
                String imageUrl = environmentEntry.getImageUrl();
                if (imageUrl == null || m.s0(imageUrl)) {
                    String imageBase642 = environmentEntry.getImageBase64();
                    imageBase64 = (imageBase642 == null || m.s0(imageBase642)) ? null : new MessageContentBuilder.ImageBase64(environmentEntry.getImageBase64());
                } else {
                    imageBase64 = new MessageContentBuilder.Image(environmentEntry.getImageUrl());
                }
                if (imageBase64 != null) {
                    arrayList.add(new MessageContentBuilder.Text(a.i(i11, "<-----第", "步截图----->")));
                    arrayList.add(imageBase64);
                    arrayList.add(new MessageContentBuilder.Text(a.i(i11, "<-----第", "步截图重复一遍----->")));
                    arrayList.add(imageBase64);
                    arrayList.add(new MessageContentBuilder.Text(a.i(i11, "<-----第", "步截图结束重要重要重要----->")));
                }
            }
            String strM = "\n\n";
            if (linkedHashMapSanitizeActionForPrompt != null) {
                strM = B7.a.m("这一步的动作是：", mapToJson(linkedHashMapSanitizeActionForPrompt), "\n\n");
            }
            arrayList.add(new MessageContentBuilder.Text(androidx.constraintlayout.core.dsl.a.c(i11, "这是第", "步的环境信息结束。", strM)));
            i = i6;
        }
        String str3 = null;
        arrayList.add(new MessageContentBuilder.Text(a.o(a.s(state.getEnvironmentHistory().size(), "你需要根据原始第<-----", state.getEnvironmentHistory().size(), "----->步的环境信息，预测原始第", "步的动作。\n请务必基于当前屏幕状态来决定你的操作，不要假设屏幕状态是静态的或者符合预期的。你需要独立判断当前页面状态，检查是否存在非预期的干扰元素（如：突然弹出的广告、系统升级弹窗）。如果发现异常，必须优先处理异常，而不是盲目继续执行原计划。\n\n一个潜伏在屏幕后的观察者指出：原始第"), "步图片出现新的变化，且非空白。请在think 过程中详细的描述出来 ！\n\n", state.getEnvironmentHistory().size())));
        arrayList.add(new MessageContentBuilder.Text(INSTRUCTION_PROMPT));
        LlmMessageBuilder llmMessageBuilderRole = new LlmMessageBuilder().role(MessageRole.USER);
        for (MessageContentBuilder messageContentBuilder : arrayList) {
            if (messageContentBuilder instanceof MessageContentBuilder.Text) {
                llmMessageBuilderRole.text(((MessageContentBuilder.Text) messageContentBuilder).getText());
                str = str3;
            } else if (messageContentBuilder instanceof MessageContentBuilder.ImageBase64) {
                str = str3;
                LlmMessageBuilder.imageBase64$default(llmMessageBuilderRole, ((MessageContentBuilder.ImageBase64) messageContentBuilder).getBase64(), str, 2, str);
            } else {
                str = str3;
                if (!(messageContentBuilder instanceof MessageContentBuilder.Image)) {
                    throw new NoWhenBranchMatchedException();
                }
                llmMessageBuilderRole.image(((MessageContentBuilder.Image) messageContentBuilder).getImageUrl());
            }
            str3 = str;
        }
        return o.N(new LlmMessageBuilder().role(MessageRole.SYSTEM).text(effectiveSystemPrompt()).build(), llmMessageBuilderRole.build());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<Integer> requirePoint(Object value, String actionType, String fieldName) {
        List list = value instanceof List ? (List) value : null;
        if (list == null) {
            throw new IllegalArgumentException(a.m("[", actionType, "] ", fieldName, " is not valid"));
        }
        if (list.size() < 2 || !(list.get(0) instanceof Integer) || !(list.get(1) instanceof Integer)) {
            throw new IllegalArgumentException(a.m("[", actionType, "] ", fieldName, " is not int"));
        }
        Object obj = list.get(0);
        k.d(obj, "null cannot be cast to non-null type kotlin.Int");
        Object obj2 = list.get(1);
        k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        return o.N(obj, obj2);
    }

    private final void safeLogE(String message) {
        try {
            j.G(message, "StepGelabModelCell");
        } catch (Throwable th) {
            kotlin.b.a(th);
        }
    }

    private final void safeLogI(String message) {
        try {
            j.H(message, "StepGelabModelCell");
        } catch (Throwable th) {
            kotlin.b.a(th);
        }
    }

    private final LinkedHashMap<String, Object> sanitizeActionForPrompt(LinkedHashMap<String, Object> action) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>(action);
        linkedHashMap.remove("cot");
        linkedHashMap.remove("point");
        linkedHashMap.remove("point1");
        linkedHashMap.remove("point2");
        linkedHashMap.remove("action_type");
        return linkedHashMap;
    }

    private final String stepRecordToText(int stepIdx, EnvironmentEntry env, Map<String, ? extends Object> action) {
        String str;
        ArrayList arrayListQ = o.Q(a.i(stepIdx, "[STEP ", "]"));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String toJsonValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return B7.a.m("\"", escapeJson((String) value), "\"");
        }
        if ((value instanceof Number) || (value instanceof Boolean)) {
            return value.toString();
        }
        if (!(value instanceof Map)) {
            return value instanceof Iterable ? v.I0((Iterable) value, null, "[", "]", new com.stepos.taskrobot.llmapi.stepfun.g(this, 10), 25) : B7.a.m("\"", escapeJson(value.toString()), "\"");
        }
        StringBuilder sb = new StringBuilder("{");
        int i = 0;
        for (Object obj : ((Map) value).entrySet()) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (i > 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(escapeJson(String.valueOf(entry.getKey())));
            sb.append("\":");
            sb.append(toJsonValue(entry.getValue()));
            i = i6;
        }
        sb.append("}");
        return sb.toString();
    }

    private final List<String> truncateItems(List<String> items, int maxItems) {
        List<String> listDedupPreserveOrder = dedupPreserveOrder(items);
        return listDedupPreserveOrder.isEmpty() ? o.M("- none") : listDedupPreserveOrder.size() <= maxItems ? listDedupPreserveOrder : v.b1(maxItems, listDedupPreserveOrder);
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
        HashMap<String, Object> param = parseParam(response);
        ActionType actionType = parseActionType(param);
        if (actionType == null) {
            throw new IllegalArgumentException("[buildResponseAction] actionType is null");
        }
        Object obj = param.get(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION);
        Map<String, String> actionParam = parseActionParam(param, obj instanceof String ? (String) obj : null);
        sessionState.getActionHistory().add(new LinkedHashMap<>(param));
        sessionState.setHasPendingEnvironment(false);
        sessionState.setPendingUserComment(null);
        return new Pair<>(actionType, actionParam);
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public void clearCache() {
        this.sessionStates.clear();
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
        return new ModelRequestPayload(listRenderRequestMessages, lastCompressionInfo != null ? kotlin.collections.a.Y(lastCompressionInfo) : kotlin.collections.a.M());
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public Size getCompressBitmapSize() {
        return new Size(756, 756);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getDesc() {
        return "适用于多模智能团队开发的模型";
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public ModelParam getModelParam() {
        return new ModelParam(1.0f, 0.95f, 32768, Float.valueOf(0.05f));
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getName() {
        return "StepGelab";
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public List<GUIAgentMode> getSupportedMode() {
        return o.k(GUIAgentMode.NO_PATH);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getSystemPrompt() {
        return DEFAULT_SKILL;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getType() {
        return this.type;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public void handleInquiry(za.e session, String question, String answer) {
        String str;
        if (session == null || (str = session.f7004a) == null) {
            return;
        }
        if (answer == null) {
            safeLogI(B7.a.m("handleInquiry: null answer for session=", str, ", skip"));
            return;
        }
        String string = m.R0(answer).toString();
        if (string.length() == 0) {
            safeLogI(B7.a.m("handleInquiry: blank answer for session=", str, ", skip"));
            return;
        }
        getSessionState(str).setPendingUserComment(string);
        safeLogI(B7.a.q(a.t(string.length(), "handleInquiry: pendingUserComment set (session=", str, ", len=", ", question="), question != null ? m.N0(40, question) : null, ")"));
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
        linkedHashMap.put("verify", "此步骤已由经验库自动执行完成：" + explain + "。页面已发生变化，因此我判断 符合 上一步预期，该操作已成功执行，无需重复");
        linkedHashMap.put("note", "【已自动执行】" + explain + "。此操作已经完成，请勿重复执行相同操作，应基于当前最新截图判断下一步");
        linkedHashMap.put("explain", explain);
        linkedHashMap.put(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, upperCase);
        if (summary == null) {
            summary = B7.a.m("经验库已自动完成", explain, "，操作已生效。请根据当前截图继续执行下一个未完成的步骤");
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

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object generateRequestMessage(za.e r5, java.lang.String r6, stepai.aios.guiagent.config.LlmConfig r7, java.lang.String r8, java.lang.String r9, H7.c<? super java.util.List<stepai.aios.guiagent.llm.Message>> r10) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r10 instanceof stepai.aios.guiagent.llm.cell.StepGelabModelCell.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            stepai.aios.guiagent.llm.cell.StepGelabModelCell$generateRequestMessage$1 r0 = (stepai.aios.guiagent.llm.cell.StepGelabModelCell.AnonymousClass1) r0
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
            stepai.aios.guiagent.llm.cell.StepGelabModelCell$generateRequestMessage$1 r0 = new stepai.aios.guiagent.llm.cell.StepGelabModelCell$generateRequestMessage$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r0 = r10.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r10.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r4 = r10.L$4
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r10.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r10.L$2
            stepai.aios.guiagent.config.LlmConfig r4 = (stepai.aios.guiagent.config.LlmConfig) r4
            java.lang.Object r4 = r10.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r10.L$0
            za.e r4 = (za.e) r4
            kotlin.b.b(r0)
            goto L5c
        L3d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L45:
            kotlin.b.b(r0)
            r0 = 0
            r10.L$0 = r0
            r10.L$1 = r0
            r10.L$2 = r0
            r10.L$3 = r0
            r10.L$4 = r0
            r10.label = r3
            java.lang.Object r0 = r4.generateRequestPayload(r5, r6, r7, r8, r9, r10)
            if (r0 != r1) goto L5c
            return r1
        L5c:
            stepai.aios.guiagent.llm.parser.ModelRequestPayload r0 = (stepai.aios.guiagent.llm.parser.ModelRequestPayload) r0
            java.util.List r4 = r0.getMessages()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.StepGelabModelCell.generateRequestMessage(za.e, java.lang.String, stepai.aios.guiagent.config.LlmConfig, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lstepai/aios/guiagent/llm/cell/StepGelabModelCell$EnvironmentEntry;", "", "imageBase64", "", "userComment", "imageUrl", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageBase64", "()Ljava/lang/String;", "getUserComment", "getImageUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object generateRequestPayload(za.e r5, java.lang.String r6, stepai.aios.guiagent.config.LlmConfig r7, java.lang.String r8, java.lang.String r9, H7.c<? super stepai.aios.guiagent.llm.parser.ModelRequestPayload> r10) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r10 instanceof stepai.aios.guiagent.llm.cell.StepGelabModelCell.C19421
            if (r0 == 0) goto L13
            r0 = r10
            stepai.aios.guiagent.llm.cell.StepGelabModelCell$generateRequestPayload$1 r0 = (stepai.aios.guiagent.llm.cell.StepGelabModelCell.C19421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            stepai.aios.guiagent.llm.cell.StepGelabModelCell$generateRequestPayload$1 r0 = new stepai.aios.guiagent.llm.cell.StepGelabModelCell$generateRequestPayload$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4b
            if (r2 != r3) goto L43
            java.lang.Object r5 = r0.L$6
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.L$5
            stepai.aios.guiagent.llm.cell.StepGelabModelCell$SessionRuntimeState r6 = (stepai.aios.guiagent.llm.cell.StepGelabModelCell.SessionRuntimeState) r6
            java.lang.Object r7 = r0.L$4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$2
            stepai.aios.guiagent.config.LlmConfig r7 = (stepai.aios.guiagent.config.LlmConfig) r7
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$0
            za.e r7 = (za.e) r7
            kotlin.b.b(r10)
            goto L7e
        L43:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L4b:
            kotlin.b.b(r10)
            if (r5 == 0) goto L97
            java.lang.String r10 = r5.f7004a
            stepai.aios.guiagent.llm.cell.StepGelabModelCell$SessionRuntimeState r10 = r4.getSessionState(r10)
            stepai.aios.guiagent.config.StateCompressionConfig r2 = r7.getStateCompressionConfig()
            r4.applyCompressionConfig(r10, r2)
            java.lang.String r5 = r4.prepareRequestState(r5, r6, r10, r9)
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r0.L$3 = r6
            r0.L$4 = r6
            r0.L$5 = r10
            r0.L$6 = r5
            r0.label = r3
            r6 = r7
            r7 = r8
            r8 = r10
            r9 = r0
            java.lang.Object r6 = r4.maybeCompressHistoryWithLlm(r5, r6, r7, r8, r9)
            if (r6 != r1) goto L7d
            return r1
        L7d:
            r6 = r8
        L7e:
            stepai.aios.guiagent.llm.parser.ModelRequestPayload r7 = new stepai.aios.guiagent.llm.parser.ModelRequestPayload
            java.util.List r4 = r4.renderRequestMessages(r5, r6)
            java.util.LinkedHashMap r5 = r6.getLastCompressionInfo()
            if (r5 == 0) goto L8f
            java.util.Map r5 = kotlin.collections.a.Y(r5)
            goto L93
        L8f:
            java.util.Map r5 = kotlin.collections.a.M()
        L93:
            r7.<init>(r4, r5)
            return r7
        L97:
            java.lang.Exception r4 = new java.lang.Exception
            java.lang.String r5 = "[generateRequestMessage] session is null"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.StepGelabModelCell.generateRequestPayload(za.e, java.lang.String, stepai.aios.guiagent.config.LlmConfig, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }
}
