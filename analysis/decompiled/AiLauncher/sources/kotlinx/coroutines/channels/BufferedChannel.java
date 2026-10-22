package kotlinx.coroutines.channels;

import M5.c;
import Ua.C1072o;
import Ua.InterfaceC1066l;
import Ua.U0;
import Wa.WaiterEB;
import Wa.g;
import Wa.i;
import Wa.k;
import Y8.t;
import Za.A;
import Za.AbstractC1183c;
import Za.B;
import Za.C1182b;
import Za.C1190j;
import Za.v;
import Za.z;
import androidx.exifinterface.media.ExifInterface;
import cb.j;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.f;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import p9.InterfaceC5074l;
import p9.q;
import w9.InterfaceC5748g;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0003:©\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\b\u0002\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H\u0082@¢\u0006\u0004\b\f\u0010\rJ6\u0010\u0013\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\u00020\u0006*\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010 \u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!JG\u0010\"\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0011H\u0003¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b'\u0010%J\u001b\u0010(\u001a\u00020\u001e*\u00020\u001c2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b(\u0010)J.\u0010+\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b+\u0010,J)\u0010-\u001a\u00020\u0006*\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b-\u0010\u0017J\u001d\u0010.\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002¢\u0006\u0004\b.\u0010/J4\u00101\u001a\b\u0012\u0004\u0012\u00028\u0000002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b1\u0010,J#\u00102\u001a\u00020\u00062\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000\u0018H\u0002¢\u0006\u0004\b2\u0010/J9\u00103\u001a\u0004\u0018\u00010\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b3\u00104J9\u00105\u001a\u0004\u0018\u00010\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b5\u00104J)\u00106\u001a\u00020\u001e*\u00020\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u00109J-\u0010;\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0011H\u0002¢\u0006\u0004\b;\u0010<J-\u0010=\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0011H\u0002¢\u0006\u0004\b=\u0010<J\u0019\u0010?\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0011H\u0002¢\u0006\u0004\b?\u0010@J%\u0010D\u001a\u00020\u00062\n\u0010B\u001a\u0006\u0012\u0002\b\u00030A2\b\u0010C\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020\u00062\n\u0010B\u001a\u0006\u0012\u0002\b\u00030AH\u0002¢\u0006\u0004\bF\u0010GJ%\u0010I\u001a\u0004\u0018\u00010\u001c2\b\u0010C\u001a\u0004\u0018\u00010\u001c2\b\u0010H\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bI\u0010JJ%\u0010K\u001a\u0004\u0018\u00010\u001c2\b\u0010C\u001a\u0004\u0018\u00010\u001c2\b\u0010H\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bK\u0010JJ\u000f\u0010L\u001a\u00020\u0006H\u0002¢\u0006\u0004\bL\u00109J\u000f\u0010M\u001a\u00020\u0006H\u0002¢\u0006\u0004\bM\u00109J\u000f\u0010N\u001a\u00020\u0006H\u0002¢\u0006\u0004\bN\u00109J\u000f\u0010O\u001a\u00020\u0006H\u0002¢\u0006\u0004\bO\u00109J\u000f\u0010P\u001a\u00020\u0006H\u0002¢\u0006\u0004\bP\u00109J\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010Q\u001a\u00020\u0011H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0011H\u0002¢\u0006\u0004\bT\u0010@J\u0015\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bU\u0010VJ\u001d\u0010X\u001a\u00020\u00112\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bX\u0010YJ\u001d\u0010Z\u001a\u00020\u00062\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bZ\u0010[J%\u0010]\u001a\u00020\u00062\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\\\u001a\u00020\u0011H\u0002¢\u0006\u0004\b]\u0010^J\u0013\u0010_\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\b_\u0010`J\u0013\u0010a\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\ba\u0010`J\u001b\u0010c\u001a\u00020\u0006*\u00020\u00152\u0006\u0010b\u001a\u00020\u001eH\u0002¢\u0006\u0004\bc\u0010dJ\u001f\u0010g\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020\u00112\u0006\u0010f\u001a\u00020\u001eH\u0002¢\u0006\u0004\bg\u0010hJ-\u0010j\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010i\u001a\u00020\u0011H\u0002¢\u0006\u0004\bj\u0010<J-\u0010m\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010k\u001a\u00020\u00112\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bm\u0010nJ-\u0010o\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010k\u001a\u00020\u00112\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bo\u0010nJ5\u0010q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010k\u001a\u00020\u00112\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010p\u001a\u00020\u0011H\u0002¢\u0006\u0004\bq\u0010rJ%\u0010s\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u00112\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bs\u0010tJ\u0017\u0010v\u001a\u00020\u00062\u0006\u0010u\u001a\u00020\u0011H\u0002¢\u0006\u0004\bv\u0010@J\u0017\u0010w\u001a\u00020\u00062\u0006\u0010u\u001a\u00020\u0011H\u0002¢\u0006\u0004\bw\u0010@JG\u0010{\u001a \u0012\u0004\u0012\u00020y\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000000\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u00060x*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007H\u0002¢\u0006\u0004\b{\u0010|J.\u0010\u007f\u001a\u00020\u00062\u0006\u0010}\u001a\u00020y2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u0000002\u0006\u0010~\u001a\u00020zH\u0002¢\u0006\u0005\b\u007f\u0010\u0080\u0001JO\u0010\u0082\u0001\u001a\u001d\u0012\u0004\u0012\u00020y\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u00060\u0081\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00072\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001JC\u0010\u0084\u0001\u001a\u001a\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u00060x*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007H\u0002¢\u0006\u0005\b\u0084\u0001\u0010|J*\u0010\u0085\u0001\u001a\u00020\u00062\u0006\u0010}\u001a\u00020y2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010~\u001a\u00020zH\u0002¢\u0006\u0006\b\u0085\u0001\u0010\u0080\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H\u0096@¢\u0006\u0005\b\u0086\u0001\u0010\rJ \u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u0006002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u008a\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u008a\u0001\u00109J\u0011\u0010\u008b\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u008b\u0001\u00109J\u0013\u0010\u008c\u0001\u001a\u00028\u0000H\u0096@¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0019\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0096@¢\u0006\u0006\b\u008e\u0001\u0010\u008d\u0001J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0016¢\u0006\u0005\b\u0012\u0010\u008f\u0001J\u001a\u0010\u0091\u0001\u001a\u00020\u00062\u0007\u0010\u0090\u0001\u001a\u00020\u0011H\u0004¢\u0006\u0005\b\u0091\u0001\u0010@J\u0019\u0010\u0092\u0001\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u0011H\u0000¢\u0006\u0005\b\u0092\u0001\u0010@J\u001a\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0093\u0001H\u0096\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0011\u0010\u0096\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u0096\u0001\u00109J\u001c\u0010\u0097\u0001\u001a\u00020\u001e2\b\u0010}\u001a\u0004\u0018\u00010yH\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\"\u0010\u009b\u0001\u001a\u00020\u00062\u0010\u0010}\u001a\f\u0018\u00010\u0099\u0001j\u0005\u0018\u0001`\u009a\u0001¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u001c\u0010\u009d\u0001\u001a\u00020\u001e2\b\u0010}\u001a\u0004\u0018\u00010yH\u0010¢\u0006\u0006\b\u009d\u0001\u0010\u0098\u0001J%\u0010\u009f\u0001\u001a\u00020\u001e2\b\u0010}\u001a\u0004\u0018\u00010y2\u0007\u0010\u009e\u0001\u001a\u00020\u001eH\u0014¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J)\u0010¢\u0001\u001a\u00020\u00062\u0015\u0010¡\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010y\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0012\u0010¤\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0013\u0010§\u0001\u001a\u00030¦\u0001H\u0016¢\u0006\u0006\b§\u0001\u0010¨\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R/\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00078\u0000X\u0081\u0004¢\u0006\u0007\n\u0005\b:\u0010«\u0001Rc\u0010°\u0001\u001aG\u0012\b\u0012\u0006\u0012\u0002\b\u00030A\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020y\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u00060\u0081\u0001\u0018\u00010\u0081\u0001j\u0005\u0018\u0001`¬\u00018\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\b\u00ad\u0001\u0010®\u0001\u0012\u0005\b¯\u0001\u00109R\u0017\u0010³\u0001\u001a\u00020\u00118BX\u0082\u0004¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001R\u0017\u0010µ\u0001\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\b\u001a\u0006\b´\u0001\u0010¥\u0001R\u0017\u0010¸\u0001\u001a\u00020y8BX\u0082\u0004¢\u0006\b\u001a\u0006\b¶\u0001\u0010·\u0001R\u001a\u0010º\u0001\u001a\u00020\u001e*\u00020\u00118BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010%R\u001a\u0010¼\u0001\u001a\u00020\u001e*\u00020\u00118BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b»\u0001\u0010%R\u0016\u0010\\\u001a\u00020\u00118@X\u0080\u0004¢\u0006\b\u001a\u0006\b½\u0001\u0010²\u0001R\u0017\u0010¿\u0001\u001a\u00020\u00118@X\u0080\u0004¢\u0006\b\u001a\u0006\b¾\u0001\u0010²\u0001R%\u0010Ä\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000À\u00018VX\u0096\u0004¢\u0006\u000f\u0012\u0005\bÃ\u0001\u00109\u001a\u0006\bÁ\u0001\u0010Â\u0001R*\u0010Æ\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000À\u00018VX\u0096\u0004¢\u0006\u000e\u0012\u0005\bÅ\u0001\u00109\u001a\u0005\b*\u0010Â\u0001R\u0019\u0010È\u0001\u001a\u0004\u0018\u00010y8DX\u0084\u0004¢\u0006\b\u001a\u0006\bÇ\u0001\u0010·\u0001R\u0017\u0010Ê\u0001\u001a\u00020y8DX\u0084\u0004¢\u0006\b\u001a\u0006\bÉ\u0001\u0010·\u0001R\u0017\u0010Ì\u0001\u001a\u00020\u001e8TX\u0094\u0004¢\u0006\b\u001a\u0006\bË\u0001\u0010¥\u0001R\u001e\u0010Í\u0001\u001a\u00020\u001e8VX\u0097\u0004¢\u0006\u000f\u0012\u0005\bÎ\u0001\u00109\u001a\u0006\bÍ\u0001\u0010¥\u0001R\u001d\u0010f\u001a\u00020\u001e8VX\u0097\u0004¢\u0006\u000f\u0012\u0005\bÐ\u0001\u00109\u001a\u0006\bÏ\u0001\u0010¥\u0001R\u001e\u0010Ñ\u0001\u001a\u00020\u001e8VX\u0097\u0004¢\u0006\u000f\u0012\u0005\bÒ\u0001\u00109\u001a\u0006\bÑ\u0001\u0010¥\u0001R\r\u0010Ô\u0001\u001a\u00030Ó\u00018\u0002X\u0082\u0004R\r\u0010Õ\u0001\u001a\u00030Ó\u00018\u0002X\u0082\u0004R\r\u0010Ö\u0001\u001a\u00030Ó\u00018\u0002X\u0082\u0004R\r\u0010×\u0001\u001a\u00030Ó\u00018\u0002X\u0082\u0004R\u0019\u0010Ù\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0Ø\u00018\u0002X\u0082\u0004R\u0019\u0010Ú\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0Ø\u00018\u0002X\u0082\u0004R\u0019\u0010Û\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0Ø\u00018\u0002X\u0082\u0004R\u0015\u0010Ü\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0Ø\u00018\u0002X\u0082\u0004R\u0015\u0010Ý\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0Ø\u00018\u0002X\u0082\u0004¨\u0006Þ\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", ExifInterface.LONGITUDE_EAST, "LWa/g;", "", "capacity", "Lkotlin/Function1;", "LY8/t;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILp9/l;)V", "element", "L0", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "LWa/k;", "segment", "index", "", "s", "f1", "(LWa/k;ILjava/lang/Object;JLe9/c;)Ljava/lang/Object;", "LUa/U0;", "S0", "(LUa/U0;LWa/k;I)V", "LUa/l;", "cont", "M0", "(Ljava/lang/Object;LUa/l;)V", "", "waiter", "", AlipayXuiIsland.REASON_CLOSED, "n1", "(LWa/k;ILjava/lang/Object;JLjava/lang/Object;Z)I", "o1", "curSendersAndCloseStatus", "g1", "(J)Z", "curSenders", "N", "h1", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "r", "Y0", "(LWa/k;IJLe9/c;)Ljava/lang/Object;", "R0", "J0", "(LUa/l;)V", "Lkotlinx/coroutines/channels/a;", "X0", "I0", "l1", "(LWa/k;IJLjava/lang/Object;)Ljava/lang/Object;", "m1", "i1", "(Ljava/lang/Object;LWa/k;I)Z", ExifInterface.LONGITUDE_WEST, "()V", Const.INTENT_KEY_PKGNAME, "j1", "(LWa/k;IJ)Z", "k1", "nAttempts", "q0", "(J)V", "Lcb/j;", c.ACTION_SELECT, "ignoredParam", "Z0", "(Lcb/j;Ljava/lang/Object;)V", "K0", "(Lcb/j;)V", "selectResult", "T0", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "U0", "s0", "D0", "C0", "B0", "U", "sendersCur", ExifInterface.GPS_DIRECTION_TRUE, "(J)LWa/k;", ExifInterface.LATITUDE_SOUTH, "Q", "()LWa/k;", "lastSegment", "A0", "(LWa/k;)J", SdCardDbCreator.FIELD_LASTLOC_ID, "(LWa/k;)V", "sendersCounter", "P", "(LWa/k;J)V", "b1", "(LUa/U0;)V", "c1", "receiver", "d1", "(LUa/U0;Z)V", "sendersAndCloseStatusCur", "isClosedForReceive", "u0", "(JZ)Z", "globalIndex", "t0", "id", "startFrom", "Z", "(JLWa/k;)LWa/k;", "Y", "currentBufferEndCounter", "X", "(JLWa/k;J)LWa/k;", "E0", "(JLWa/k;)V", UxipConstants.f30680s, "q1", "p1", "Lkotlin/reflect/KFunction3;", "", "Lkotlin/coroutines/d;", "M", "(Lp9/l;)Lw9/g;", "cause", "context", "F0", "(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/d;)V", "Lkotlin/Function3;", "J", "(Lp9/l;Ljava/lang/Object;)Lp9/q;", "K", "G0", "send", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "O0", "N0", "receive", "(Le9/c;)Ljava/lang/Object;", "u", "()Ljava/lang/Object;", "globalCellIndex", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "r1", "LWa/i;", "iterator", "()LWa/i;", "H0", "close", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/concurrent/CancellationException;)V", "O", "cancel", "R", "(Ljava/lang/Throwable;Z)Z", "handler", "invokeOnClose", "(Lp9/l;)V", "p0", "()Z", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "I", "Lp9/l;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "c", "Lp9/q;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "onUndeliveredElementReceiveCancellationConstructor", "b0", "()J", "bufferEndCounter", "z0", "isRendezvousOrUnlimited", "g0", "()Ljava/lang/Throwable;", "receiveException", "x0", "isClosedForSend0", "w0", "isClosedForReceive0", "n0", "j0", "receiversCounter", "Lcb/f;", "p", "()Lcb/f;", "getOnReceive$annotations", "onReceive", "getOnReceiveCatching$annotations", "onReceiveCatching", "d0", "closeCause", "k0", "sendException", "y0", "isConflatedDropOldest", "isClosedForSend", "isClosedForSend$annotations", "v0", "isClosedForReceive$annotations", "isEmpty", "isEmpty$annotations", "LOa/d;", "sendersAndCloseStatus", "receivers", "bufferEnd", "completedExpandBuffersAndPauseFlag", "LOa/e;", "sendSegment", "receiveSegment", "bufferEndSegment", "_closeCause", "closeHandler", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class BufferedChannel<E> implements g<E> {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f36274d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f36275e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f36276f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f36277g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36278h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36279i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36280j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36281k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36282l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int capacity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<E, t> onUndeliveredElement;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final q<j<?>, Object, Object, q<Throwable, Object, d, t>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096B¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J.\u0010\u001b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0082@¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0015R\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$a;", "LWa/i;", "LUa/U0;", "<init>", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "LZa/z;", "segment", "", "index", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LZa/z;I)V", "next", "()Ljava/lang/Object;", "element", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Object;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()V", "f", "()Z", "LWa/k;", "", "r", "e", "(LWa/k;IJLe9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "Ljava/lang/Object;", "receiveResult", "Lkotlinx/coroutines/c;", Const.INTENT_KEY_PKGNAME, "Lkotlinx/coroutines/c;", "continuation", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a implements i<E>, U0 {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public Object receiveResult = BufferedChannelKt.f36332p;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public kotlinx.coroutines.c<? super Boolean> continuation;

        public a() {
        }

        @Override // Wa.i
        public Object a(InterfaceC4014c<? super Boolean> interfaceC4014c) throws Throwable {
            k<E> kVarY;
            boolean zF = true;
            if (this.receiveResult == BufferedChannelKt.f36332p || this.receiveResult == BufferedChannelKt.z()) {
                BufferedChannel<E> bufferedChannel = BufferedChannel.this;
                k<E> kVar = (k) BufferedChannel.h0().get(bufferedChannel);
                while (true) {
                    if (bufferedChannel.v0()) {
                        zF = f();
                        break;
                    }
                    long andIncrement = BufferedChannel.i0().getAndIncrement(bufferedChannel);
                    int i10 = BufferedChannelKt.f36318b;
                    long j10 = andIncrement / i10;
                    int i11 = (int) (andIncrement % i10);
                    if (kVar.id != j10) {
                        kVarY = bufferedChannel.Y(j10, kVar);
                        if (kVarY == null) {
                            continue;
                        }
                    } else {
                        kVarY = kVar;
                    }
                    Object objL1 = bufferedChannel.l1(kVarY, i11, andIncrement, null);
                    if (objL1 == BufferedChannelKt.f36329m) {
                        throw new IllegalStateException("unreachable");
                    }
                    if (objL1 == BufferedChannelKt.f36331o) {
                        if (andIncrement < bufferedChannel.n0()) {
                            kVarY.b();
                        }
                        kVar = kVarY;
                    } else {
                        if (objL1 == BufferedChannelKt.f36330n) {
                            return e(kVarY, i11, andIncrement, interfaceC4014c);
                        }
                        kVarY.b();
                        this.receiveResult = objL1;
                    }
                }
            }
            return C4109a.a(zF);
        }

        public final Object e(k<E> kVar, int i10, long j10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            Boolean boolA;
            k kVar2;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            kotlinx.coroutines.c cVarB = C1072o.b(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c));
            try {
                this.continuation = cVarB;
                Object objL1 = bufferedChannel.l1(kVar, i10, j10, this);
                if (objL1 == BufferedChannelKt.f36329m) {
                    bufferedChannel.R0(this, kVar, i10);
                } else {
                    q qVarJ = null;
                    if (objL1 == BufferedChannelKt.f36331o) {
                        if (j10 < bufferedChannel.n0()) {
                            kVar.b();
                        }
                        k kVar3 = (k) BufferedChannel.h0().get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.v0()) {
                                g();
                                break;
                            }
                            long andIncrement = BufferedChannel.i0().getAndIncrement(bufferedChannel);
                            int i11 = BufferedChannelKt.f36318b;
                            long j11 = andIncrement / i11;
                            int i12 = (int) (andIncrement % i11);
                            if (kVar3.id != j11) {
                                k kVarY = bufferedChannel.Y(j11, kVar3);
                                if (kVarY != null) {
                                    kVar2 = kVarY;
                                }
                            } else {
                                kVar2 = kVar3;
                            }
                            Object objL12 = bufferedChannel.l1(kVar2, i12, andIncrement, this);
                            k kVar4 = kVar2;
                            if (objL12 == BufferedChannelKt.f36329m) {
                                bufferedChannel.R0(this, kVar4, i12);
                                break;
                            }
                            if (objL12 == BufferedChannelKt.f36331o) {
                                if (andIncrement < bufferedChannel.n0()) {
                                    kVar4.b();
                                }
                                kVar3 = kVar4;
                            } else {
                                if (objL12 == BufferedChannelKt.f36330n) {
                                    throw new IllegalStateException("unexpected");
                                }
                                kVar4.b();
                                this.receiveResult = objL12;
                                this.continuation = null;
                                boolA = C4109a.a(true);
                                InterfaceC5074l<E, t> interfaceC5074l = bufferedChannel.onUndeliveredElement;
                                if (interfaceC5074l != null) {
                                    qVarJ = bufferedChannel.J(interfaceC5074l, objL12);
                                }
                            }
                        }
                    } else {
                        kVar.b();
                        this.receiveResult = objL1;
                        this.continuation = null;
                        boolA = C4109a.a(true);
                        InterfaceC5074l<E, t> interfaceC5074l2 = bufferedChannel.onUndeliveredElement;
                        if (interfaceC5074l2 != null) {
                            qVarJ = bufferedChannel.J(interfaceC5074l2, objL1);
                        }
                    }
                    cVarB.w(boolA, qVarJ);
                }
                Object objC = cVarB.C();
                if (objC == C4063a.g()) {
                    f.c(interfaceC4014c);
                }
                return objC;
            } catch (Throwable th) {
                cVarB.Q();
                throw th;
            }
        }

        public final boolean f() throws Throwable {
            this.receiveResult = BufferedChannelKt.z();
            Throwable thD0 = BufferedChannel.this.d0();
            if (thD0 == null) {
                return false;
            }
            throw B.a(thD0);
        }

        public final void g() {
            kotlinx.coroutines.c<? super Boolean> cVar = this.continuation;
            p.f(cVar);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.z();
            Throwable thD0 = BufferedChannel.this.d0();
            if (thD0 == null) {
                Result.Companion companion = Result.INSTANCE;
                cVar.resumeWith(Result.b(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cVar.resumeWith(Result.b(C4849c.a(thD0)));
            }
        }

        @Override // Ua.U0
        public void h(z<?> segment, int index) {
            kotlinx.coroutines.c<? super Boolean> cVar = this.continuation;
            if (cVar != null) {
                cVar.h(segment, index);
            }
        }

        public final boolean i(E element) {
            kotlinx.coroutines.c<? super Boolean> cVar = this.continuation;
            p.f(cVar);
            this.continuation = null;
            this.receiveResult = element;
            Boolean bool = Boolean.TRUE;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            InterfaceC5074l<E, t> interfaceC5074l = bufferedChannel.onUndeliveredElement;
            return BufferedChannelKt.B(cVar, bool, interfaceC5074l != null ? bufferedChannel.J(interfaceC5074l, element) : null);
        }

        public final void j() {
            kotlinx.coroutines.c<? super Boolean> cVar = this.continuation;
            p.f(cVar);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.z();
            Throwable thD0 = BufferedChannel.this.d0();
            if (thD0 == null) {
                Result.Companion companion = Result.INSTANCE;
                cVar.resumeWith(Result.b(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cVar.resumeWith(Result.b(C4849c.a(thD0)));
            }
        }

        @Override // Wa.i
        public E next() throws Throwable {
            E e10 = (E) this.receiveResult;
            if (e10 == BufferedChannelKt.f36332p) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.receiveResult = BufferedChannelKt.f36332p;
            if (e10 != BufferedChannelKt.z()) {
                return e10;
            }
            throw B.a(BufferedChannel.this.g0());
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$b;", "LUa/U0;", "LZa/z;", "segment", "", "index", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LZa/z;I)V", "LUa/l;", "", Const.INTENT_KEY_PKGNAME, "LUa/l;", Const.INTENT_KEY_APIKEY, "()LUa/l;", "cont", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements U0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.c<Boolean> f36289a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC1066l<Boolean> cont;

        public final InterfaceC1066l<Boolean> a() {
            return this.cont;
        }

        @Override // Ua.U0
        public void h(z<?> segment, int index) {
            this.f36289a.h(segment, index);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int i10, InterfaceC5074l<? super E, t> interfaceC5074l) {
        this.capacity = i10;
        this.onUndeliveredElement = interfaceC5074l;
        if (i10 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i10 + ", should be >=0").toString());
        }
        this.bufferEnd$volatile = BufferedChannelKt.A(i10);
        this.completedExpandBuffersAndPauseFlag$volatile = b0();
        k kVar = new k(0L, null, this, 3);
        this.sendSegment$volatile = kVar;
        this.receiveSegment$volatile = kVar;
        if (z0()) {
            kVar = BufferedChannelKt.f36317a;
            p.g(kVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = kVar;
        this.onUndeliveredElementReceiveCancellationConstructor = interfaceC5074l != 0 ? new q() { // from class: Wa.d
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BufferedChannel.P0(this.f6784a, (cb.j) obj, obj2, obj3);
            }
        } : null;
        this._closeCause$volatile = BufferedChannelKt.f36335s;
    }

    public static final t L(InterfaceC5074l interfaceC5074l, Object obj, Throwable th, Object obj2, d dVar) {
        v.a(interfaceC5074l, obj, dVar);
        return t.f7040a;
    }

    public static final q P0(final BufferedChannel bufferedChannel, final j jVar, Object obj, final Object obj2) {
        return new q() { // from class: Wa.f
            @Override // p9.q
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return BufferedChannel.Q0(obj2, bufferedChannel, jVar, (Throwable) obj3, obj4, (kotlin.coroutines.d) obj5);
            }
        };
    }

    public static final t Q0(Object obj, BufferedChannel bufferedChannel, j jVar, Throwable th, Object obj2, d dVar) {
        if (obj != BufferedChannelKt.z()) {
            v.a(bufferedChannel.onUndeliveredElement, obj, jVar.getContext());
        }
        return t.f7040a;
    }

    public static /* synthetic */ <E> Object V0(BufferedChannel<E> bufferedChannel, InterfaceC4014c<? super E> interfaceC4014c) throws Throwable {
        k<E> kVar;
        k<E> kVar2 = (k) h0().get(bufferedChannel);
        while (!bufferedChannel.v0()) {
            long andIncrement = i0().getAndIncrement(bufferedChannel);
            int i10 = BufferedChannelKt.f36318b;
            long j10 = andIncrement / i10;
            int i11 = (int) (andIncrement % i10);
            if (kVar2.id != j10) {
                k<E> kVarY = bufferedChannel.Y(j10, kVar2);
                if (kVarY == null) {
                    continue;
                } else {
                    kVar = kVarY;
                }
            } else {
                kVar = kVar2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            Object objL1 = bufferedChannel2.l1(kVar, i11, andIncrement, null);
            if (objL1 == BufferedChannelKt.f36329m) {
                throw new IllegalStateException("unexpected");
            }
            if (objL1 != BufferedChannelKt.f36331o) {
                if (objL1 == BufferedChannelKt.f36330n) {
                    return bufferedChannel2.Y0(kVar, i11, andIncrement, interfaceC4014c);
                }
                kVar.b();
                return objL1;
            }
            if (andIncrement < bufferedChannel2.n0()) {
                kVar.b();
            }
            bufferedChannel = bufferedChannel2;
            kVar2 = kVar;
        }
        throw B.a(bufferedChannel.g0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <E> java.lang.Object W0(kotlinx.coroutines.channels.BufferedChannel<E> r13, e9.InterfaceC4014c<? super kotlinx.coroutines.channels.a<? extends E>> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.W0(kotlinx.coroutines.channels.BufferedChannel, e9.c):java.lang.Object");
    }

    public static /* synthetic */ <E> Object e1(BufferedChannel<E> bufferedChannel, E e10, InterfaceC4014c<? super t> interfaceC4014c) {
        k<E> kVar;
        k<E> kVar2 = (k) l0().get(bufferedChannel);
        while (true) {
            long andIncrement = m0().getAndIncrement(bufferedChannel);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zX0 = bufferedChannel.x0(andIncrement);
            int i10 = BufferedChannelKt.f36318b;
            long j11 = j10 / i10;
            int i11 = (int) (j10 % i10);
            if (kVar2.id != j11) {
                k<E> kVarZ = bufferedChannel.Z(j11, kVar2);
                if (kVarZ != null) {
                    kVar = kVarZ;
                } else if (zX0) {
                    Object objL0 = bufferedChannel.L0(e10, interfaceC4014c);
                    if (objL0 == C4063a.g()) {
                        return objL0;
                    }
                }
            } else {
                kVar = kVar2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            E e11 = e10;
            int iN1 = bufferedChannel2.n1(kVar, i11, e11, j10, null, zX0);
            if (iN1 == 0) {
                kVar.b();
                break;
            }
            if (iN1 == 1) {
                break;
            }
            if (iN1 != 2) {
                if (iN1 == 3) {
                    Object objF1 = bufferedChannel2.f1(kVar, i11, e11, j10, interfaceC4014c);
                    if (objF1 == C4063a.g()) {
                        return objF1;
                    }
                } else if (iN1 != 4) {
                    if (iN1 == 5) {
                        kVar.b();
                    }
                    bufferedChannel = bufferedChannel2;
                    kVar2 = kVar;
                    e10 = e11;
                } else {
                    if (j10 < bufferedChannel2.j0()) {
                        kVar.b();
                    }
                    Object objL02 = bufferedChannel2.L0(e11, interfaceC4014c);
                    if (objL02 == C4063a.g()) {
                        return objL02;
                    }
                }
            } else if (zX0) {
                kVar.t();
                Object objL03 = bufferedChannel2.L0(e11, interfaceC4014c);
                if (objL03 == C4063a.g()) {
                    return objL03;
                }
            }
        }
        return t.f7040a;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater h0() {
        return f36279i;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater i0() {
        return f36275e;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater l0() {
        return f36278h;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater m0() {
        return f36274d;
    }

    public static /* synthetic */ void r0(BufferedChannel bufferedChannel, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i10 & 1) != 0) {
            j10 = 1;
        }
        bufferedChannel.q0(j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (Wa.k) r8.h();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long A0(Wa.k<E> r8) {
        /*
            r7 = this;
        L0:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.f36318b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.id
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f36318b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.j0()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.B(r0)
            if (r1 == 0) goto L2c
            Za.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.k()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            Za.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.f36320d
            if (r1 != r2) goto L39
            return r3
        L2c:
            Za.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r1 = r8.v(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.t()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            Za.c r8 = r8.h()
            Wa.k r8 = (Wa.k) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.A0(Wa.k):long");
    }

    public final void B0() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f36274d;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) != 0) {
                return;
            }
            BufferedChannel<E> bufferedChannel = this;
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j10, BufferedChannelKt.w(1152921504606846975L & j10, 1))) {
                return;
            } else {
                this = bufferedChannel;
            }
        }
    }

    public final void C0() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f36274d;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            BufferedChannel<E> bufferedChannel = this;
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j10, BufferedChannelKt.w(1152921504606846975L & j10, 3))) {
                return;
            } else {
                this = bufferedChannel;
            }
        }
    }

    public final void D0() {
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f36274d;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 >> 60);
            if (i10 == 0) {
                jW = BufferedChannelKt.w(1152921504606846975L & j10, 2);
            } else if (i10 != 1) {
                return;
            } else {
                jW = BufferedChannelKt.w(1152921504606846975L & j10, 3);
            }
            BufferedChannel<E> bufferedChannel = this;
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j10, jW)) {
                return;
            } else {
                this = bufferedChannel;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E0(long r5, Wa.k<E> r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.id
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            Za.c r0 = r7.f()
            Wa.k r0 = (Wa.k) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.k()
            if (r5 == 0) goto L22
            Za.c r5 = r7.f()
            Wa.k r5 = (Wa.k) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = c0()
        L26:
            java.lang.Object r6 = r5.get(r4)
            Za.z r6 = (Za.z) r6
            long r0 = r6.id
            long r2 = r7.id
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L35
            return
        L35:
            boolean r0 = r7.u()
            if (r0 != 0) goto L3c
            goto L11
        L3c:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4c
            boolean r4 = r6.p()
            if (r4 == 0) goto L4b
            r6.n()
        L4b:
            return
        L4c:
            boolean r6 = r7.p()
            if (r6 == 0) goto L26
            r7.n()
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.E0(long, Wa.k):void");
    }

    public final void F0(Throwable cause, Object element, d context) {
        InterfaceC5074l<E, t> interfaceC5074l = this.onUndeliveredElement;
        p.f(interfaceC5074l);
        Object objF = kotlinx.coroutines.channels.a.f(element);
        p.f(objF);
        v.a(interfaceC5074l, objF, context);
    }

    public final void G0(Throwable cause, E element, d context) {
        InterfaceC5074l<E, t> interfaceC5074l = this.onUndeliveredElement;
        p.f(interfaceC5074l);
        v.a(interfaceC5074l, element, context);
    }

    public void H0() {
    }

    public final void I0(InterfaceC1066l<? super kotlinx.coroutines.channels.a<? extends E>> cont) {
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.b(kotlinx.coroutines.channels.a.b(kotlinx.coroutines.channels.a.INSTANCE.a(d0()))));
    }

    public final q<Throwable, Object, d, t> J(final InterfaceC5074l<? super E, t> interfaceC5074l, final E e10) {
        return new q() { // from class: Wa.e
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BufferedChannel.L(interfaceC5074l, e10, (Throwable) obj, obj2, (kotlin.coroutines.d) obj3);
            }
        };
    }

    public final void J0(InterfaceC1066l<? super E> cont) {
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.b(C4849c.a(g0())));
    }

    public final InterfaceC5748g<t> K(InterfaceC5074l<? super E, t> interfaceC5074l) {
        return new BufferedChannel$bindCancellationFun$2(this);
    }

    public final void K0(j<?> select) {
        select.d(BufferedChannelKt.z());
    }

    public final Object L0(E e10, InterfaceC4014c<? super t> interfaceC4014c) {
        UndeliveredElementException undeliveredElementExceptionC;
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        InterfaceC5074l<E, t> interfaceC5074l = this.onUndeliveredElement;
        if (interfaceC5074l == null || (undeliveredElementExceptionC = v.c(interfaceC5074l, e10, null, 2, null)) == null) {
            Throwable thK0 = k0();
            Result.Companion companion = Result.INSTANCE;
            cVar.resumeWith(Result.b(C4849c.a(thK0)));
        } else {
            Y8.d.a(undeliveredElementExceptionC, k0());
            Result.Companion companion2 = Result.INSTANCE;
            cVar.resumeWith(Result.b(C4849c.a(undeliveredElementExceptionC)));
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            f.c(interfaceC4014c);
        }
        return objC == C4063a.g() ? objC : t.f7040a;
    }

    public final InterfaceC5748g<t> M(InterfaceC5074l<? super E, t> interfaceC5074l) {
        return new BufferedChannel$bindCancellationFunResult$1(this);
    }

    public final void M0(E element, InterfaceC1066l<? super t> cont) {
        InterfaceC5074l<E, t> interfaceC5074l = this.onUndeliveredElement;
        if (interfaceC5074l != null) {
            v.a(interfaceC5074l, element, cont.getContext());
        }
        Throwable thK0 = k0();
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.b(C4849c.a(thK0)));
    }

    public final boolean N(long curSenders) {
        return curSenders < b0() || curSenders < j0() + ((long) this.capacity);
    }

    public void N0() {
    }

    public boolean O(Throwable cause) {
        if (cause == null) {
            cause = new CancellationException("Channel was cancelled");
        }
        return R(cause, true);
    }

    public void O0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P(k<E> lastSegment, long sendersCounter) {
        Object objB = C1190j.b(null, 1, null);
        loop0: while (lastSegment != null) {
            for (int i10 = BufferedChannelKt.f36318b - 1; -1 < i10; i10--) {
                if ((lastSegment.id * BufferedChannelKt.f36318b) + i10 < sendersCounter) {
                    break loop0;
                }
                while (true) {
                    Object objB2 = lastSegment.B(i10);
                    if (objB2 != null && objB2 != BufferedChannelKt.f36321e) {
                        if (!(objB2 instanceof WaiterEB)) {
                            if (!(objB2 instanceof U0)) {
                                break;
                            }
                            if (lastSegment.v(i10, objB2, BufferedChannelKt.z())) {
                                objB = C1190j.c(objB, objB2);
                                lastSegment.C(i10, true);
                                break;
                            }
                        } else {
                            if (lastSegment.v(i10, objB2, BufferedChannelKt.z())) {
                                objB = C1190j.c(objB, ((WaiterEB) objB2).waiter);
                                lastSegment.C(i10, true);
                                break;
                            }
                        }
                    } else {
                        if (lastSegment.v(i10, objB2, BufferedChannelKt.z())) {
                            lastSegment.t();
                            break;
                        }
                    }
                }
            }
            lastSegment = (k) lastSegment.h();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                b1((U0) objB);
                return;
            }
            p.g(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                b1((U0) arrayList.get(size));
            }
        }
    }

    public final k<E> Q() {
        Object obj = f36280j.get(this);
        k kVar = (k) f36278h.get(this);
        if (kVar.id > ((k) obj).id) {
            obj = kVar;
        }
        k kVar2 = (k) f36279i.get(this);
        if (kVar2.id > ((k) obj).id) {
            obj = kVar2;
        }
        return (k) C1182b.b((AbstractC1183c) obj);
    }

    public boolean R(Throwable cause, boolean cancel) {
        if (cancel) {
            B0();
        }
        boolean zCompareAndSet = f36281k.compareAndSet(this, BufferedChannelKt.f36335s, cause);
        if (cancel) {
            C0();
        } else {
            D0();
        }
        U();
        H0();
        if (zCompareAndSet) {
            s0();
        }
        return zCompareAndSet;
    }

    public final void R0(U0 u02, k<E> kVar, int i10) {
        O0();
        u02.h(kVar, i10);
    }

    public final void S(long sendersCur) {
        a1(T(sendersCur));
    }

    public final void S0(U0 u02, k<E> kVar, int i10) {
        u02.h(kVar, i10 + BufferedChannelKt.f36318b);
    }

    public final k<E> T(long sendersCur) {
        k<E> kVarQ = Q();
        if (y0()) {
            long jA0 = A0(kVarQ);
            if (jA0 != -1) {
                V(jA0);
            }
        }
        P(kVarQ, sendersCur);
        return kVarQ;
    }

    public final Object T0(Object ignoredParam, Object selectResult) throws Throwable {
        if (selectResult != BufferedChannelKt.z()) {
            return selectResult;
        }
        throw g0();
    }

    public final void U() {
        isClosedForSend();
    }

    public final Object U0(Object ignoredParam, Object selectResult) {
        return kotlinx.coroutines.channels.a.b(selectResult == BufferedChannelKt.z() ? kotlinx.coroutines.channels.a.INSTANCE.a(d0()) : kotlinx.coroutines.channels.a.INSTANCE.c(selectResult));
    }

    public final void V(long globalCellIndex) {
        k<E> kVar;
        UndeliveredElementException undeliveredElementExceptionC;
        k<E> kVar2 = (k) f36279i.get(this);
        while (true) {
            long j10 = f36275e.get(this);
            if (globalCellIndex < Math.max(this.capacity + j10, this.b0())) {
                return;
            }
            BufferedChannel<E> bufferedChannel = this;
            if (f36275e.compareAndSet(bufferedChannel, j10, 1 + j10)) {
                int i10 = BufferedChannelKt.f36318b;
                long j11 = j10 / i10;
                int i11 = (int) (j10 % i10);
                if (kVar2.id != j11) {
                    k<E> kVarY = bufferedChannel.Y(j11, kVar2);
                    if (kVarY != null) {
                        kVar = kVarY;
                    }
                } else {
                    kVar = kVar2;
                }
                Object objL1 = bufferedChannel.l1(kVar, i11, j10, null);
                if (objL1 != BufferedChannelKt.f36331o) {
                    kVar.b();
                    InterfaceC5074l<E, t> interfaceC5074l = bufferedChannel.onUndeliveredElement;
                    if (interfaceC5074l != null && (undeliveredElementExceptionC = v.c(interfaceC5074l, objL1, null, 2, null)) != null) {
                        throw undeliveredElementExceptionC;
                    }
                } else if (j10 < bufferedChannel.n0()) {
                    kVar.b();
                }
                this = bufferedChannel;
                kVar2 = kVar;
            }
            this = bufferedChannel;
        }
    }

    public final void W() {
        BufferedChannel<E> bufferedChannel;
        if (z0()) {
            return;
        }
        k<E> kVar = (k) f36280j.get(this);
        while (true) {
            long andIncrement = f36276f.getAndIncrement(this);
            int i10 = BufferedChannelKt.f36318b;
            long j10 = andIncrement / i10;
            if (this.n0() <= andIncrement) {
                if (kVar.id < j10 && kVar.f() != 0) {
                    this.E0(j10, kVar);
                }
                r0(this, 0L, 1, null);
                return;
            }
            if (kVar.id != j10) {
                bufferedChannel = this;
                k<E> kVarX = bufferedChannel.X(j10, kVar, andIncrement);
                if (kVarX == null) {
                    continue;
                    this = bufferedChannel;
                } else {
                    kVar = kVarX;
                }
            } else {
                bufferedChannel = this;
            }
            if (bufferedChannel.j1(kVar, (int) (andIncrement % i10), andIncrement)) {
                r0(bufferedChannel, 0L, 1, null);
                return;
            } else {
                r0(bufferedChannel, 0L, 1, null);
                this = bufferedChannel;
            }
        }
    }

    public final k<E> X(long id, k<E> startFrom, long currentBufferEndCounter) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36280j;
        p9.p pVar = (p9.p) BufferedChannelKt.y();
        loop0: while (true) {
            objC = C1182b.c(startFrom, id, pVar);
            if (!A.c(objC)) {
                z zVarB = A.b(objC);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.id >= zVarB.id) {
                        break loop0;
                    }
                    if (!zVarB.u()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, zVar, zVarB)) {
                        if (zVar.p()) {
                            zVar.n();
                        }
                    } else if (zVarB.p()) {
                        zVarB.n();
                    }
                }
            } else {
                break;
            }
        }
        if (A.c(objC)) {
            U();
            E0(id, startFrom);
            r0(this, 0L, 1, null);
            return null;
        }
        k<E> kVar = (k) A.b(objC);
        if (kVar.id <= id) {
            return kVar;
        }
        long j10 = kVar.id;
        int i10 = BufferedChannelKt.f36318b;
        if (f36276f.compareAndSet(this, currentBufferEndCounter + 1, j10 * i10)) {
            q0((kVar.id * i10) - currentBufferEndCounter);
        } else {
            r0(this, 0L, 1, null);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X0(Wa.k<E> r11, int r12, long r13, e9.InterfaceC4014c<? super kotlinx.coroutines.channels.a<? extends E>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.X0(Wa.k, int, long, e9.c):java.lang.Object");
    }

    public final k<E> Y(long id, k<E> startFrom) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36279i;
        p9.p pVar = (p9.p) BufferedChannelKt.y();
        loop0: while (true) {
            objC = C1182b.c(startFrom, id, pVar);
            if (!A.c(objC)) {
                z zVarB = A.b(objC);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.id >= zVarB.id) {
                        break loop0;
                    }
                    if (!zVarB.u()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, zVar, zVarB)) {
                        if (zVar.p()) {
                            zVar.n();
                        }
                    } else if (zVarB.p()) {
                        zVarB.n();
                    }
                }
            } else {
                break;
            }
        }
        if (A.c(objC)) {
            U();
            if (startFrom.id * BufferedChannelKt.f36318b < n0()) {
                startFrom.b();
            }
            return null;
        }
        k<E> kVar = (k) A.b(objC);
        if (!z0() && id <= b0() / BufferedChannelKt.f36318b) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f36280j;
            while (true) {
                z zVar2 = (z) atomicReferenceFieldUpdater2.get(this);
                if (zVar2.id >= kVar.id || !kVar.u()) {
                    break;
                }
                if (atomicReferenceFieldUpdater2.compareAndSet(this, zVar2, kVar)) {
                    if (zVar2.p()) {
                        zVar2.n();
                    }
                } else if (kVar.p()) {
                    kVar.n();
                }
            }
        }
        long j10 = kVar.id;
        if (j10 <= id) {
            return kVar;
        }
        int i10 = BufferedChannelKt.f36318b;
        p1(j10 * i10);
        if (kVar.id * i10 < n0()) {
            kVar.b();
        }
        return null;
    }

    public final Object Y0(k<E> kVar, int i10, long j10, InterfaceC4014c<? super E> interfaceC4014c) {
        q qVar;
        k kVar2;
        kotlinx.coroutines.c cVarB = C1072o.b(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c));
        try {
            Object objL1 = l1(kVar, i10, j10, cVarB);
            if (objL1 == BufferedChannelKt.f36329m) {
                R0(cVarB, kVar, i10);
            } else {
                if (objL1 == BufferedChannelKt.f36331o) {
                    if (j10 < n0()) {
                        kVar.b();
                    }
                    k kVar3 = (k) h0().get(this);
                    while (true) {
                        if (v0()) {
                            J0(cVarB);
                            break;
                        }
                        long andIncrement = i0().getAndIncrement(this);
                        int i11 = BufferedChannelKt.f36318b;
                        long j11 = andIncrement / i11;
                        int i12 = (int) (andIncrement % i11);
                        if (kVar3.id != j11) {
                            k kVarY = Y(j11, kVar3);
                            if (kVarY != null) {
                                kVar2 = kVarY;
                            }
                        } else {
                            kVar2 = kVar3;
                        }
                        objL1 = l1(kVar2, i12, andIncrement, cVarB);
                        k kVar4 = kVar2;
                        if (objL1 == BufferedChannelKt.f36329m) {
                            kotlinx.coroutines.c cVar = cVarB != null ? cVarB : null;
                            if (cVar != null) {
                                R0(cVar, kVar4, i12);
                            }
                        } else if (objL1 == BufferedChannelKt.f36331o) {
                            if (andIncrement < n0()) {
                                kVar4.b();
                            }
                            kVar3 = kVar4;
                        } else {
                            if (objL1 == BufferedChannelKt.f36330n) {
                                throw new IllegalStateException("unexpected");
                            }
                            kVar4.b();
                            InterfaceC5074l<E, t> interfaceC5074l = this.onUndeliveredElement;
                            qVar = (q) (interfaceC5074l != null ? K(interfaceC5074l) : null);
                        }
                    }
                } else {
                    kVar.b();
                    InterfaceC5074l<E, t> interfaceC5074l2 = this.onUndeliveredElement;
                    qVar = (q) (interfaceC5074l2 != null ? K(interfaceC5074l2) : null);
                }
                cVarB.w(objL1, qVar);
            }
            Object objC = cVarB.C();
            if (objC == C4063a.g()) {
                f.c(interfaceC4014c);
            }
            return objC;
        } catch (Throwable th) {
            cVarB.Q();
            throw th;
        }
    }

    public final k<E> Z(long id, k<E> startFrom) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36278h;
        p9.p pVar = (p9.p) BufferedChannelKt.y();
        loop0: while (true) {
            objC = C1182b.c(startFrom, id, pVar);
            if (!A.c(objC)) {
                z zVarB = A.b(objC);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.id >= zVarB.id) {
                        break loop0;
                    }
                    if (!zVarB.u()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, zVar, zVarB)) {
                        if (zVar.p()) {
                            zVar.n();
                        }
                    } else if (zVarB.p()) {
                        zVarB.n();
                    }
                }
            } else {
                break;
            }
        }
        if (A.c(objC)) {
            U();
            if (startFrom.id * BufferedChannelKt.f36318b < j0()) {
                startFrom.b();
            }
            return null;
        }
        k<E> kVar = (k) A.b(objC);
        long j10 = kVar.id;
        if (j10 <= id) {
            return kVar;
        }
        int i10 = BufferedChannelKt.f36318b;
        q1(j10 * i10);
        if (kVar.id * i10 < j0()) {
            kVar.b();
        }
        return null;
    }

    public final void Z0(j<?> select, Object ignoredParam) {
        k kVar;
        k kVar2 = (k) h0().get(this);
        while (!this.v0()) {
            long andIncrement = i0().getAndIncrement(this);
            int i10 = BufferedChannelKt.f36318b;
            long j10 = andIncrement / i10;
            int i11 = (int) (andIncrement % i10);
            if (kVar2.id != j10) {
                k kVarY = this.Y(j10, kVar2);
                if (kVarY == null) {
                    continue;
                } else {
                    kVar = kVarY;
                }
            } else {
                kVar = kVar2;
            }
            BufferedChannel<E> bufferedChannel = this;
            j<?> jVar = select;
            Object objL1 = bufferedChannel.l1(kVar, i11, andIncrement, jVar);
            kVar2 = kVar;
            if (objL1 == BufferedChannelKt.f36329m) {
                U0 u02 = jVar instanceof U0 ? (U0) jVar : null;
                if (u02 != null) {
                    bufferedChannel.R0(u02, kVar2, i11);
                    return;
                }
                return;
            }
            if (objL1 != BufferedChannelKt.f36331o) {
                if (objL1 == BufferedChannelKt.f36330n) {
                    throw new IllegalStateException("unexpected");
                }
                kVar2.b();
                jVar.d(objL1);
                return;
            }
            if (andIncrement < bufferedChannel.n0()) {
                kVar2.b();
            }
            this = bufferedChannel;
            select = jVar;
        }
        this.K0(select);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (Wa.k) r12.h();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a1(Wa.k<E> r12) {
        /*
            r11 = this;
            p9.l<E, Y8.t> r0 = r11.onUndeliveredElement
            r1 = 0
            r2 = 1
            java.lang.Object r3 = Za.C1190j.b(r1, r2, r1)
        L8:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.f36318b
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb3
            long r6 = r12.id
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.f36318b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L16:
            java.lang.Object r8 = r12.B(r4)
            Za.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r8 == r9) goto Lbb
            Za.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.f36320d
            if (r8 != r9) goto L48
            long r9 = r11.j0()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            Za.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.v(r4, r8, r9)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L40
            java.lang.Object r5 = r12.A(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = Za.v.b(r0, r5, r1)
        L40:
            r12.w(r4)
            r12.t()
            goto Laf
        L48:
            Za.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.k()
            if (r8 == r9) goto La2
            if (r8 != 0) goto L51
            goto La2
        L51:
            boolean r9 = r8 instanceof Ua.U0
            if (r9 != 0) goto L6e
            boolean r9 = r8 instanceof Wa.WaiterEB
            if (r9 == 0) goto L5a
            goto L6e
        L5a:
            Za.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r8 == r9) goto Lbb
            Za.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r8 != r9) goto L67
            goto Lbb
        L67:
            Za.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r8 == r9) goto L16
            goto Laf
        L6e:
            long r9 = r11.j0()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            boolean r9 = r8 instanceof Wa.WaiterEB
            if (r9 == 0) goto L80
            r9 = r8
            Wa.t r9 = (Wa.WaiterEB) r9
            Ua.U0 r9 = r9.waiter
            goto L83
        L80:
            r9 = r8
            Ua.U0 r9 = (Ua.U0) r9
        L83:
            Za.C r10 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.v(r4, r8, r10)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L97
            java.lang.Object r5 = r12.A(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = Za.v.b(r0, r5, r1)
        L97:
            java.lang.Object r3 = Za.C1190j.c(r3, r9)
            r12.w(r4)
            r12.t()
            goto Laf
        La2:
            Za.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.v(r4, r8, r9)
            if (r8 == 0) goto L16
            r12.t()
        Laf:
            int r4 = r4 + (-1)
            goto Lb
        Lb3:
            Za.c r12 = r12.h()
            Wa.k r12 = (Wa.k) r12
            if (r12 != 0) goto L8
        Lbb:
            if (r3 == 0) goto Le1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto Lc7
            Ua.U0 r3 = (Ua.U0) r3
            r11.c1(r3)
            goto Le1
        Lc7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>"
            kotlin.jvm.internal.p.g(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        Ld3:
            if (r5 >= r12) goto Le1
            java.lang.Object r0 = r3.get(r12)
            Ua.U0 r0 = (Ua.U0) r0
            r11.c1(r0)
            int r12 = r12 + (-1)
            goto Ld3
        Le1:
            if (r1 != 0) goto Le4
            return
        Le4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.a1(Wa.k):void");
    }

    public final long b0() {
        return f36276f.get(this);
    }

    public final void b1(U0 u02) {
        d1(u02, true);
    }

    public final void c1(U0 u02) {
        d1(u02, false);
    }

    @Override // Wa.s
    public boolean close(Throwable cause) {
        return R(cause, false);
    }

    public final Throwable d0() {
        return (Throwable) f36281k.get(this);
    }

    public final void d1(U0 u02, boolean z10) {
        if (u02 instanceof b) {
            InterfaceC1066l<Boolean> interfaceC1066lA = ((b) u02).a();
            Result.Companion companion = Result.INSTANCE;
            interfaceC1066lA.resumeWith(Result.b(Boolean.FALSE));
            return;
        }
        if (u02 instanceof InterfaceC1066l) {
            InterfaceC4014c interfaceC4014c = (InterfaceC4014c) u02;
            Result.Companion companion2 = Result.INSTANCE;
            interfaceC4014c.resumeWith(Result.b(C4849c.a(z10 ? g0() : k0())));
        } else if (u02 instanceof Wa.q) {
            kotlinx.coroutines.c<kotlinx.coroutines.channels.a<? extends E>> cVar = ((Wa.q) u02).cont;
            Result.Companion companion3 = Result.INSTANCE;
            cVar.resumeWith(Result.b(kotlinx.coroutines.channels.a.b(kotlinx.coroutines.channels.a.INSTANCE.a(d0()))));
        } else if (u02 instanceof a) {
            ((a) u02).j();
        } else {
            if (u02 instanceof j) {
                ((j) u02).f(this, BufferedChannelKt.z());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + u02).toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0104 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f1(Wa.k<E> r16, int r17, E r18, long r19, e9.InterfaceC4014c<? super Y8.t> r21) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.f1(Wa.k, int, java.lang.Object, long, e9.c):java.lang.Object");
    }

    public final Throwable g0() {
        Throwable thD0 = d0();
        return thD0 == null ? new ClosedReceiveChannelException("Channel was closed") : thD0;
    }

    public final boolean g1(long curSendersAndCloseStatus) {
        if (x0(curSendersAndCloseStatus)) {
            return false;
        }
        return !N(curSendersAndCloseStatus & 1152921504606846975L);
    }

    public final boolean h1(Object obj, E e10) {
        if (obj instanceof j) {
            return ((j) obj).f(this, e10);
        }
        if (obj instanceof Wa.q) {
            p.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            kotlinx.coroutines.c<kotlinx.coroutines.channels.a<? extends E>> cVar = ((Wa.q) obj).cont;
            kotlinx.coroutines.channels.a aVarB = kotlinx.coroutines.channels.a.b(kotlinx.coroutines.channels.a.INSTANCE.c(e10));
            InterfaceC5074l<E, t> interfaceC5074l = this.onUndeliveredElement;
            return BufferedChannelKt.B(cVar, aVarB, (q) (interfaceC5074l != null ? M(interfaceC5074l) : null));
        }
        if (obj instanceof a) {
            p.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(e10);
        }
        if (obj instanceof InterfaceC1066l) {
            p.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            InterfaceC1066l interfaceC1066l = (InterfaceC1066l) obj;
            InterfaceC5074l<E, t> interfaceC5074l2 = this.onUndeliveredElement;
            return BufferedChannelKt.B(interfaceC1066l, e10, (q) (interfaceC5074l2 != null ? K(interfaceC5074l2) : null));
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    @Override // Wa.r
    public final void i(CancellationException cause) {
        O(cause);
    }

    public final boolean i1(Object obj, k<E> kVar, int i10) {
        if (obj instanceof InterfaceC1066l) {
            p.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.C((InterfaceC1066l) obj, t.f7040a, null, 2, null);
        }
        if (obj instanceof j) {
            p.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailedResultX = ((SelectImplementation) obj).x(this, t.f7040a);
            if (trySelectDetailedResultX == TrySelectDetailedResult.REREGISTER) {
                kVar.w(i10);
            }
            return trySelectDetailedResultX == TrySelectDetailedResult.SUCCESSFUL;
        }
        if (obj instanceof b) {
            return BufferedChannelKt.C(((b) obj).a(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    @Override // Wa.s
    public void invokeOnClose(InterfaceC5074l<? super Throwable, t> handler) {
        if (f36282l.compareAndSet(this, null, handler)) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36282l;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != BufferedChannelKt.f36333q) {
                if (obj == BufferedChannelKt.f36334r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!f36282l.compareAndSet(this, BufferedChannelKt.f36333q, BufferedChannelKt.f36334r));
        handler.invoke(d0());
    }

    @Override // Wa.s
    public boolean isClosedForSend() {
        return x0(f36274d.get(this));
    }

    @Override // Wa.r
    public boolean isEmpty() {
        if (v0() || p0()) {
            return false;
        }
        return !v0();
    }

    @Override // Wa.r
    public i<E> iterator() {
        return new a();
    }

    public final long j0() {
        return f36275e.get(this);
    }

    public final boolean j1(k<E> segment, int index, long b10) {
        Object objB = segment.B(index);
        if (!(objB instanceof U0) || b10 < f36275e.get(this) || !segment.v(index, objB, BufferedChannelKt.f36323g)) {
            return k1(segment, index, b10);
        }
        if (i1(objB, segment, index)) {
            segment.F(index, BufferedChannelKt.f36320d);
            return true;
        }
        segment.F(index, BufferedChannelKt.f36326j);
        segment.C(index, false);
        return false;
    }

    public final Throwable k0() {
        Throwable thD0 = d0();
        return thD0 == null ? new ClosedSendChannelException("Channel was closed") : thD0;
    }

    public final boolean k1(k<E> segment, int index, long b10) {
        while (true) {
            Object objB = segment.B(index);
            if (objB instanceof U0) {
                if (b10 < f36275e.get(this)) {
                    if (segment.v(index, objB, new WaiterEB((U0) objB))) {
                        return true;
                    }
                } else if (segment.v(index, objB, BufferedChannelKt.f36323g)) {
                    if (i1(objB, segment, index)) {
                        segment.F(index, BufferedChannelKt.f36320d);
                        return true;
                    }
                    segment.F(index, BufferedChannelKt.f36326j);
                    segment.C(index, false);
                    return false;
                }
            } else {
                if (objB == BufferedChannelKt.f36326j) {
                    return false;
                }
                if (objB == null) {
                    if (segment.v(index, objB, BufferedChannelKt.f36321e)) {
                        return true;
                    }
                } else {
                    if (objB == BufferedChannelKt.f36320d || objB == BufferedChannelKt.f36324h || objB == BufferedChannelKt.f36325i || objB == BufferedChannelKt.f36327k || objB == BufferedChannelKt.z()) {
                        return true;
                    }
                    if (objB != BufferedChannelKt.f36322f) {
                        throw new IllegalStateException(("Unexpected cell state: " + objB).toString());
                    }
                }
            }
        }
    }

    public final Object l1(k<E> segment, int index, long r10, Object waiter) {
        Object objB = segment.B(index);
        if (objB == null) {
            if (r10 >= (f36274d.get(this) & 1152921504606846975L)) {
                if (waiter == null) {
                    return BufferedChannelKt.f36330n;
                }
                if (segment.v(index, objB, waiter)) {
                    W();
                    return BufferedChannelKt.f36329m;
                }
            }
        } else if (objB == BufferedChannelKt.f36320d && segment.v(index, objB, BufferedChannelKt.f36325i)) {
            W();
            return segment.D(index);
        }
        return m1(segment, index, r10, waiter);
    }

    public final Object m1(k<E> segment, int index, long r10, Object waiter) {
        while (true) {
            Object objB = segment.B(index);
            if (objB == null || objB == BufferedChannelKt.f36321e) {
                if (r10 < (f36274d.get(this) & 1152921504606846975L)) {
                    if (segment.v(index, objB, BufferedChannelKt.f36324h)) {
                        W();
                        return BufferedChannelKt.f36331o;
                    }
                } else {
                    if (waiter == null) {
                        return BufferedChannelKt.f36330n;
                    }
                    if (segment.v(index, objB, waiter)) {
                        W();
                        return BufferedChannelKt.f36329m;
                    }
                }
            } else {
                if (objB != BufferedChannelKt.f36320d) {
                    if (objB != BufferedChannelKt.f36326j && objB != BufferedChannelKt.f36324h) {
                        if (objB == BufferedChannelKt.z()) {
                            W();
                            return BufferedChannelKt.f36331o;
                        }
                        if (objB != BufferedChannelKt.f36323g && segment.v(index, objB, BufferedChannelKt.f36322f)) {
                            boolean z10 = objB instanceof WaiterEB;
                            if (z10) {
                                objB = ((WaiterEB) objB).waiter;
                            }
                            if (i1(objB, segment, index)) {
                                segment.F(index, BufferedChannelKt.f36325i);
                                W();
                                return segment.D(index);
                            }
                            segment.F(index, BufferedChannelKt.f36326j);
                            segment.C(index, false);
                            if (z10) {
                                W();
                            }
                            return BufferedChannelKt.f36331o;
                        }
                    }
                    return BufferedChannelKt.f36331o;
                }
                if (segment.v(index, objB, BufferedChannelKt.f36325i)) {
                    W();
                    return segment.D(index);
                }
            }
        }
    }

    public final long n0() {
        return f36274d.get(this) & 1152921504606846975L;
    }

    public final int n1(k<E> segment, int index, E element, long s10, Object waiter, boolean closed) {
        segment.G(index, element);
        if (closed) {
            return o1(segment, index, element, s10, waiter, closed);
        }
        Object objB = segment.B(index);
        if (objB == null) {
            if (N(s10)) {
                if (segment.v(index, null, BufferedChannelKt.f36320d)) {
                    return 1;
                }
            } else {
                if (waiter == null) {
                    return 3;
                }
                if (segment.v(index, null, waiter)) {
                    return 2;
                }
            }
        } else if (objB instanceof U0) {
            segment.w(index);
            if (h1(objB, element)) {
                segment.F(index, BufferedChannelKt.f36325i);
                N0();
                return 0;
            }
            if (segment.x(index, BufferedChannelKt.f36327k) == BufferedChannelKt.f36327k) {
                return 5;
            }
            segment.C(index, true);
            return 5;
        }
        return o1(segment, index, element, s10, waiter, closed);
    }

    public final int o1(k<E> segment, int index, E element, long s10, Object waiter, boolean closed) {
        while (true) {
            Object objB = segment.B(index);
            if (objB == null) {
                if (!N(s10) || closed) {
                    if (closed) {
                        if (segment.v(index, null, BufferedChannelKt.f36326j)) {
                            segment.C(index, false);
                            return 4;
                        }
                    } else {
                        if (waiter == null) {
                            return 3;
                        }
                        if (segment.v(index, null, waiter)) {
                            return 2;
                        }
                    }
                } else if (segment.v(index, null, BufferedChannelKt.f36320d)) {
                    return 1;
                }
            } else {
                if (objB != BufferedChannelKt.f36321e) {
                    if (objB == BufferedChannelKt.f36327k) {
                        segment.w(index);
                        return 5;
                    }
                    if (objB == BufferedChannelKt.f36324h) {
                        segment.w(index);
                        return 5;
                    }
                    if (objB == BufferedChannelKt.z()) {
                        segment.w(index);
                        U();
                        return 4;
                    }
                    segment.w(index);
                    if (objB instanceof WaiterEB) {
                        objB = ((WaiterEB) objB).waiter;
                    }
                    if (h1(objB, element)) {
                        segment.F(index, BufferedChannelKt.f36325i);
                        N0();
                        return 0;
                    }
                    if (segment.x(index, BufferedChannelKt.f36327k) != BufferedChannelKt.f36327k) {
                        segment.C(index, true);
                    }
                    return 5;
                }
                if (segment.v(index, objB, BufferedChannelKt.f36320d)) {
                    return 1;
                }
            }
        }
    }

    @Override // Wa.r
    public cb.f<E> p() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.f36291a;
        p.g(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        q qVar = (q) kotlin.jvm.internal.z.g(bufferedChannel$onReceive$1, 3);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.f36292a;
        p.g(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new cb.g(this, qVar, (q) kotlin.jvm.internal.z.g(bufferedChannel$onReceive$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public final boolean p0() {
        while (true) {
            k<E> kVarY = (k) f36279i.get(this);
            long jJ0 = j0();
            if (n0() <= jJ0) {
                return false;
            }
            int i10 = BufferedChannelKt.f36318b;
            long j10 = jJ0 / i10;
            if (kVarY.id == j10 || (kVarY = Y(j10, kVarY)) != null) {
                kVarY.b();
                if (t0(kVarY, (int) (jJ0 % i10), jJ0)) {
                    return true;
                }
                f36275e.compareAndSet(this, jJ0, 1 + jJ0);
            } else if (((k) f36279i.get(this)).id < j10) {
                return false;
            }
        }
    }

    public final void p1(long value) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f36275e;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if (j10 >= value) {
                return;
            }
            BufferedChannel<E> bufferedChannel = this;
            long j11 = value;
            if (f36275e.compareAndSet(bufferedChannel, j10, j11)) {
                return;
            }
            this = bufferedChannel;
            value = j11;
        }
    }

    public final void q0(long nAttempts) {
        if ((f36277g.addAndGet(this, nAttempts) & 4611686018427387904L) != 0) {
            while ((f36277g.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final void q1(long value) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f36274d;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            long j11 = 1152921504606846975L & j10;
            if (j11 >= value) {
                return;
            }
            BufferedChannel<E> bufferedChannel = this;
            if (f36274d.compareAndSet(bufferedChannel, j10, BufferedChannelKt.w(j11, (int) (j10 >> 60)))) {
                return;
            } else {
                this = bufferedChannel;
            }
        }
    }

    @Override // Wa.r
    public cb.f<kotlinx.coroutines.channels.a<E>> r() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.f36293a;
        p.g(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        q qVar = (q) kotlin.jvm.internal.z.g(bufferedChannel$onReceiveCatching$1, 3);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.f36294a;
        p.g(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new cb.g(this, qVar, (q) kotlin.jvm.internal.z.g(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public final void r1(long globalIndex) {
        BufferedChannel<E> bufferedChannel = this;
        if (bufferedChannel.z0()) {
            return;
        }
        while (bufferedChannel.b0() <= globalIndex) {
            bufferedChannel = this;
        }
        int i10 = BufferedChannelKt.f36319c;
        for (int i11 = 0; i11 < i10; i11++) {
            long jB0 = bufferedChannel.b0();
            if (jB0 == (4611686018427387903L & f36277g.get(bufferedChannel)) && jB0 == bufferedChannel.b0()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f36277g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(bufferedChannel);
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j10, BufferedChannelKt.v(j10 & 4611686018427387903L, true))) {
                break;
            } else {
                bufferedChannel = this;
            }
        }
        while (true) {
            long jB02 = bufferedChannel.b0();
            long j11 = f36277g.get(bufferedChannel);
            long j12 = j11 & 4611686018427387903L;
            boolean z10 = (4611686018427387904L & j11) != 0;
            if (jB02 == j12 && jB02 == bufferedChannel.b0()) {
                break;
            }
            if (z10) {
                bufferedChannel = this;
            } else {
                bufferedChannel = this;
                f36277g.compareAndSet(bufferedChannel, j11, BufferedChannelKt.v(j12, true));
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f36277g;
        while (true) {
            long j13 = atomicLongFieldUpdater2.get(bufferedChannel);
            boolean zCompareAndSet = atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j13, BufferedChannelKt.v(j13 & 4611686018427387903L, false));
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
            if (zCompareAndSet) {
                return;
            }
            atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
            bufferedChannel = this;
        }
    }

    @Override // Wa.r
    public Object receive(InterfaceC4014c<? super E> interfaceC4014c) {
        return V0(this, interfaceC4014c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Wa.r
    public Object s() {
        k kVarY;
        long j10 = f36275e.get(this);
        long j11 = f36274d.get(this);
        if (w0(j11)) {
            return kotlinx.coroutines.channels.a.INSTANCE.a(d0());
        }
        if (j10 >= (j11 & 1152921504606846975L)) {
            return kotlinx.coroutines.channels.a.INSTANCE.b();
        }
        Object obj = BufferedChannelKt.f36327k;
        k kVar = (k) h0().get(this);
        while (!this.v0()) {
            long andIncrement = i0().getAndIncrement(this);
            int i10 = BufferedChannelKt.f36318b;
            long j12 = andIncrement / i10;
            int i11 = (int) (andIncrement % i10);
            if (kVar.id != j12) {
                kVarY = this.Y(j12, kVar);
                if (kVarY == null) {
                    continue;
                }
            } else {
                kVarY = kVar;
            }
            BufferedChannel<E> bufferedChannel = this;
            Object objL1 = bufferedChannel.l1(kVarY, i11, andIncrement, obj);
            kVar = kVarY;
            if (objL1 == BufferedChannelKt.f36329m) {
                U0 u02 = obj instanceof U0 ? (U0) obj : null;
                if (u02 != null) {
                    bufferedChannel.R0(u02, kVar, i11);
                }
                bufferedChannel.r1(andIncrement);
                kVar.t();
                return kotlinx.coroutines.channels.a.INSTANCE.b();
            }
            if (objL1 != BufferedChannelKt.f36331o) {
                if (objL1 == BufferedChannelKt.f36330n) {
                    throw new IllegalStateException("unexpected");
                }
                kVar.b();
                return kotlinx.coroutines.channels.a.INSTANCE.c(objL1);
            }
            if (andIncrement < bufferedChannel.n0()) {
                kVar.b();
            }
            this = bufferedChannel;
        }
        return kotlinx.coroutines.channels.a.INSTANCE.a(this.d0());
    }

    public final void s0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36282l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, obj == null ? BufferedChannelKt.f36333q : BufferedChannelKt.f36334r));
        if (obj == null) {
            return;
        }
        ((InterfaceC5074l) obj).invoke(d0());
    }

    @Override // Wa.s
    public Object send(E e10, InterfaceC4014c<? super t> interfaceC4014c) {
        return e1(this, e10, interfaceC4014c);
    }

    public final boolean t0(k<E> segment, int index, long globalIndex) {
        Object objB;
        do {
            objB = segment.B(index);
            if (objB != null && objB != BufferedChannelKt.f36321e) {
                if (objB == BufferedChannelKt.f36320d) {
                    return true;
                }
                if (objB == BufferedChannelKt.f36326j || objB == BufferedChannelKt.z() || objB == BufferedChannelKt.f36325i || objB == BufferedChannelKt.f36324h) {
                    return false;
                }
                if (objB == BufferedChannelKt.f36323g) {
                    return true;
                }
                return objB != BufferedChannelKt.f36322f && globalIndex == j0();
            }
        } while (!segment.v(index, objB, BufferedChannelKt.f36324h));
        W();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x01de, code lost:
    
        r3 = (Wa.k) r3.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e5, code lost:
    
        if (r3 != null) goto L97;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    @Override // Wa.s
    /* renamed from: trySend-JP2dKIU */
    public Object mo0trySendJP2dKIU(E element) {
        E e10;
        int i10;
        k kVar;
        BufferedChannel<E> bufferedChannel;
        if (g1(f36274d.get(this))) {
            return kotlinx.coroutines.channels.a.INSTANCE.b();
        }
        Object obj = BufferedChannelKt.f36326j;
        k kVar2 = (k) l0().get(this);
        while (true) {
            long andIncrement = m0().getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zX0 = this.x0(andIncrement);
            int i11 = BufferedChannelKt.f36318b;
            long j11 = j10 / i11;
            int i12 = (int) (j10 % i11);
            if (kVar2.id != j11) {
                k kVarZ = this.Z(j11, kVar2);
                if (kVarZ != null) {
                    i10 = i12;
                    kVar = kVarZ;
                    bufferedChannel = this;
                    e10 = element;
                } else if (zX0) {
                    return kotlinx.coroutines.channels.a.INSTANCE.a(this.k0());
                }
            } else {
                e10 = element;
                i10 = i12;
                kVar = kVar2;
                bufferedChannel = this;
            }
            int iN1 = bufferedChannel.n1(kVar, i10, e10, j10, obj, zX0);
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            kVar2 = kVar;
            if (iN1 == 0) {
                kVar2.b();
                return kotlinx.coroutines.channels.a.INSTANCE.c(t.f7040a);
            }
            if (iN1 == 1) {
                return kotlinx.coroutines.channels.a.INSTANCE.c(t.f7040a);
            }
            if (iN1 == 2) {
                if (zX0) {
                    kVar2.t();
                    return kotlinx.coroutines.channels.a.INSTANCE.a(bufferedChannel2.k0());
                }
                U0 u02 = obj instanceof U0 ? (U0) obj : null;
                if (u02 != null) {
                    bufferedChannel2.S0(u02, kVar2, i10);
                }
                kVar2.t();
                return kotlinx.coroutines.channels.a.INSTANCE.b();
            }
            if (iN1 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iN1 == 4) {
                if (j10 < bufferedChannel2.j0()) {
                    kVar2.b();
                }
                return kotlinx.coroutines.channels.a.INSTANCE.a(bufferedChannel2.k0());
            }
            if (iN1 == 5) {
                kVar2.b();
            }
            this = bufferedChannel2;
            element = e10;
        }
    }

    @Override // Wa.r
    public Object u(InterfaceC4014c<? super kotlinx.coroutines.channels.a<? extends E>> interfaceC4014c) {
        return W0(this, interfaceC4014c);
    }

    public final boolean u0(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        int i10 = (int) (sendersAndCloseStatusCur >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            T(sendersAndCloseStatusCur & 1152921504606846975L);
            return (isClosedForReceive && p0()) ? false : true;
        }
        if (i10 == 3) {
            S(sendersAndCloseStatusCur & 1152921504606846975L);
            return true;
        }
        throw new IllegalStateException(("unexpected close status: " + i10).toString());
    }

    public boolean v0() {
        return w0(f36274d.get(this));
    }

    public final boolean w0(long j10) {
        return u0(j10, true);
    }

    public final boolean x0(long j10) {
        return u0(j10, false);
    }

    public boolean y0() {
        return false;
    }

    public final boolean z0() {
        long jB0 = b0();
        return jB0 == 0 || jB0 == Long.MAX_VALUE;
    }
}
