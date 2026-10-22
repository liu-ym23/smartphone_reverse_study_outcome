package kotlinx.coroutines;

import Ka.m;
import Ua.AbstractC1088w0;
import Ua.B0;
import Ua.C0;
import Ua.C1051d0;
import Ua.C1072o;
import Ua.C1075p0;
import Ua.C1079s;
import Ua.C1080s0;
import Ua.C1082t0;
import Ua.C1086v0;
import Ua.C1091z;
import Ua.E0;
import Ua.F0;
import Ua.G0;
import Ua.InterfaceC1045a0;
import Ua.InterfaceC1077q0;
import Ua.InterfaceC1081t;
import Ua.N;
import Ua.r;
import Ua.x0;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import cb.j;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.g;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n¼\u0001½\u0001 \u0001¾\u0001¿\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\u0014*\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b$\u0010!J\u0019\u0010&\u001a\u00020%2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020(H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0014H\u0082@¢\u0006\u0004\b0\u00101J%\u00105\u001a\u00020\u00142\n\u00103\u001a\u0006\u0012\u0002\b\u0003022\b\u00104\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b;\u00108J\u0019\u0010<\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\t\u001a\u00020\u0017H\u0002¢\u0006\u0004\b<\u0010=J\u001f\u0010>\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b>\u0010?J%\u0010@\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b@\u0010AJ#\u0010B\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bB\u0010CJ*\u0010F\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010E\u001a\u00020D2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0082\u0010¢\u0006\u0004\bF\u0010GJ)\u0010I\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010H\u001a\u00020D2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bI\u0010JJ\u0015\u0010L\u001a\u0004\u0018\u00010D*\u00020KH\u0002¢\u0006\u0004\bL\u0010MJ\u0019\u0010O\u001a\u00020N2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bO\u0010PJ\u0012\u0010Q\u001a\u0004\u0018\u00010\nH\u0082@¢\u0006\u0004\bQ\u00101J%\u0010R\u001a\u00020\u00142\n\u00103\u001a\u0006\u0012\u0002\b\u0003022\b\u00104\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bR\u00106J%\u0010T\u001a\u0004\u0018\u00010\n2\b\u00104\u001a\u0004\u0018\u00010\n2\b\u0010S\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bT\u0010AJ\u0019\u0010V\u001a\u00020\u00142\b\u0010U\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\bV\u0010WJ\r\u0010X\u001a\u00020\u0004¢\u0006\u0004\bX\u0010/J\u000f\u0010Y\u001a\u00020\u0014H\u0014¢\u0006\u0004\bY\u0010ZJ\u0011\u0010]\u001a\u00060[j\u0002`\\¢\u0006\u0004\b]\u0010^J#\u0010`\u001a\u00060[j\u0002`\\*\u00020\u000f2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010NH\u0004¢\u0006\u0004\b`\u0010aJ'\u0010f\u001a\u00020e2\u0018\u0010d\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00140bj\u0002`c¢\u0006\u0004\bf\u0010gJ7\u0010j\u001a\u00020e2\u0006\u0010h\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u00042\u0018\u0010d\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00140bj\u0002`c¢\u0006\u0004\bj\u0010kJ\u001f\u0010m\u001a\u00020e2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010l\u001a\u00020+H\u0000¢\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001a\u00020\u0014H\u0086@¢\u0006\u0004\bo\u00101J\u0017\u0010p\u001a\u00020\u00142\u0006\u0010l\u001a\u00020+H\u0000¢\u0006\u0004\bp\u0010-J\u001f\u0010q\u001a\u00020\u00142\u000e\u0010\u001f\u001a\n\u0018\u00010[j\u0004\u0018\u0001`\\H\u0016¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020NH\u0014¢\u0006\u0004\bs\u0010tJ\u0017\u0010u\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\bu\u0010vJ\u0015\u0010x\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u0003¢\u0006\u0004\bx\u0010yJ\u0017\u0010z\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\bz\u0010#J\u0017\u0010{\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b{\u0010#J\u0019\u0010|\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b|\u0010}J\u0013\u0010~\u001a\u00060[j\u0002`\\H\u0016¢\u0006\u0004\b~\u0010^J\u0019\u0010\u007f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b\u007f\u0010}J\u001d\u0010\u0080\u0001\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0005\b\u0080\u0001\u00108J\u0019\u0010\u0082\u0001\u001a\u00030\u0081\u00012\u0006\u0010E\u001a\u00020\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001a\u0010\u0085\u0001\u001a\u00020\u00142\u0007\u0010\u0084\u0001\u001a\u00020\u000fH\u0010¢\u0006\u0005\b\u0085\u0001\u0010vJ\u001b\u0010\u0086\u0001\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0005\b\u0086\u0001\u0010vJ\u001a\u0010\u0087\u0001\u001a\u00020\u00042\u0007\u0010\u0084\u0001\u001a\u00020\u000fH\u0014¢\u0006\u0005\b\u0087\u0001\u0010#J\u001c\u0010\u0088\u0001\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001c\u0010\u008a\u0001\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0006\b\u008a\u0001\u0010\u0089\u0001J\u0011\u0010\u008b\u0001\u001a\u00020NH\u0016¢\u0006\u0005\b\u008b\u0001\u0010tJ\u0011\u0010\u008c\u0001\u001a\u00020NH\u0007¢\u0006\u0005\b\u008c\u0001\u0010tJ\u0011\u0010\u008d\u0001\u001a\u00020NH\u0010¢\u0006\u0005\b\u008d\u0001\u0010tJ\u0014\u0010\u008e\u0001\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0014\u0010\u0090\u0001\u001a\u0004\u0018\u00010\nH\u0084@¢\u0006\u0005\b\u0090\u0001\u00101R\u001e\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010:R\u0019\u0010\u0096\u0001\u001a\u0007\u0012\u0002\b\u00030\u0093\u00018F¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R0\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0081\u00012\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0081\u00018@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0018\u0010U\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010\u008f\u0001R\u0016\u0010¡\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010/R\u0013\u0010£\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010/R\u0013\u0010¤\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010/R\u001c\u0010©\u0001\u001a\u00030¥\u00018F¢\u0006\u000f\u0012\u0005\b¨\u0001\u0010Z\u001a\u0006\b¦\u0001\u0010§\u0001R\u0016\u0010«\u0001\u001a\u00020\u00048PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bª\u0001\u0010/R\u001b\u0010¯\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010¬\u00018F¢\u0006\b\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u0016\u0010±\u0001\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b°\u0001\u0010/R\u0016\u0010³\u0001\u001a\u00020\u00048PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010/R#\u0010¸\u0001\u001a\u0007\u0012\u0002\b\u00030´\u00018DX\u0084\u0004¢\u0006\u000f\u0012\u0005\b·\u0001\u0010Z\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0015\u0010º\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0¹\u00018\u0002X\u0082\u0004R\u0016\u0010»\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0081\u00010¹\u00018\u0002X\u0082\u0004¨\u0006À\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/g;", "LUa/t;", "LUa/E0;", "", "active", "<init>", "(Z)V", "Lkotlinx/coroutines/JobSupport$c;", VoiceWakeupReceiver.EXTRA_STATE, "", "proposedUpdate", "R", "(Lkotlinx/coroutines/JobSupport$c;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "U", "(Lkotlinx/coroutines/JobSupport$c;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "LY8/t;", "B", "(Ljava/lang/Throwable;Ljava/util/List;)V", "LUa/q0;", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "M0", "(LUa/q0;Ljava/lang/Object;)Z", "O", "(LUa/q0;Ljava/lang/Object;)V", "LUa/B0;", "list", "cause", "t0", "(LUa/B0;Ljava/lang/Throwable;)V", "L", "(Ljava/lang/Throwable;)Z", "u0", "", "G0", "(Ljava/lang/Object;)I", "LUa/d0;", "A0", "(LUa/d0;)V", "LUa/w0;", "B0", "(LUa/w0;)V", "m0", "()Z", "n0", "(Le9/c;)Ljava/lang/Object;", "Lcb/j;", M5.c.ACTION_SELECT, "ignoredParam", "C0", "(Lcb/j;Ljava/lang/Object;)V", "K", "(Ljava/lang/Object;)Ljava/lang/Object;", "Q", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "o0", "Z", "(LUa/q0;)LUa/B0;", "O0", "(LUa/q0;Ljava/lang/Throwable;)Z", "P0", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Q0", "(LUa/q0;Ljava/lang/Object;)Ljava/lang/Object;", "LUa/s;", "child", "S0", "(Lkotlinx/coroutines/JobSupport$c;LUa/s;Ljava/lang/Object;)Z", "lastChild", "P", "(Lkotlinx/coroutines/JobSupport$c;LUa/s;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "s0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)LUa/s;", "", "H0", "(Ljava/lang/Object;)Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "w0", "result", "v0", "parent", "i0", "(Lkotlinx/coroutines/g;)V", "start", "z0", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "G", "()Ljava/util/concurrent/CancellationException;", "message", "J0", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "LUa/a0;", "J", "(Lp9/l;)LUa/a0;", "onCancelling", "invokeImmediately", "I0", "(ZZLp9/l;)LUa/a0;", "node", "j0", "(ZLUa/w0;)LUa/a0;", "T0", "E0", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/concurrent/CancellationException;)V", "M", "()Ljava/lang/String;", "I", "(Ljava/lang/Throwable;)V", "parentJob", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(LUa/E0;)V", "N", "F", "H", "(Ljava/lang/Object;)Z", "k0", "p0", "q0", "LUa/r;", "N0", "(LUa/t;)LUa/r;", "exception", "h0", "x0", "g0", "y0", "(Ljava/lang/Object;)V", "C", "toString", "L0", "r0", ExifInterface.LATITUDE_SOUTH, "()Ljava/lang/Object;", "D", ExifInterface.GPS_DIRECTION_TRUE, "exceptionOrNull", "Lkotlin/coroutines/d$c;", "getKey", "()Lkotlin/coroutines/d$c;", "key", UxipConstants.f30680s, "b0", "()LUa/r;", "F0", "(LUa/r;)V", "parentHandle", "a0", "()Lkotlinx/coroutines/g;", "c0", Const.INTENT_KEY_PKGNAME, "isActive", Const.INTENT_KEY_BACKGROUND_COMMAND, "isCompleted", "isCancelled", "Lcb/d;", "R0", "()Lcb/d;", "getOnJoin$annotations", "onJoin", "Y", "onCancelComplete", "LKa/j;", "getChildren", "()LKa/j;", "children", "l0", "isScopedCoroutine", ExifInterface.LONGITUDE_WEST, "handlesException", "Lcb/f;", "X", "()Lcb/f;", "getOnAwaitInternal$annotations", "onAwaitInternal", "LOa/e;", "_state", "_parentHandle", "e", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class JobSupport implements g, InterfaceC1081t, E0 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36232a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36233b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/JobSupport$a;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/c;", "Le9/c;", "delegate", "Lkotlinx/coroutines/JobSupport;", "job", "<init>", "(Le9/c;Lkotlinx/coroutines/JobSupport;)V", "Lkotlinx/coroutines/g;", "parent", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/coroutines/g;)Ljava/lang/Throwable;", "", "O", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lkotlinx/coroutines/JobSupport;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> extends kotlinx.coroutines.c<T> {

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public final JobSupport job;

        public a(InterfaceC4014c<? super T> interfaceC4014c, JobSupport jobSupport) {
            super(interfaceC4014c, 1);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.c
        public Throwable A(g parent) {
            Throwable thE;
            Object objC0 = this.job.c0();
            return (!(objC0 instanceof c) || (thE = ((c) objC0).e()) == null) ? objC0 instanceof C1091z ? ((C1091z) objC0).cause : parent.G() : thE;
        }

        @Override // kotlinx.coroutines.c
        public String O() {
            return "AwaitContinuation";
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/JobSupport$b;", "LUa/w0;", "Lkotlinx/coroutines/JobSupport;", "parent", "Lkotlinx/coroutines/JobSupport$c;", VoiceWakeupReceiver.EXTRA_STATE, "LUa/s;", "child", "", "proposedUpdate", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$c;LUa/s;Ljava/lang/Object;)V", "", "cause", "LY8/t;", "v", "(Ljava/lang/Throwable;)V", "e", "Lkotlinx/coroutines/JobSupport;", "f", "Lkotlinx/coroutines/JobSupport$c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LUa/s;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/Object;", "", "u", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AbstractC1088w0 {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final JobSupport parent;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final c state;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final C1079s child;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final Object proposedUpdate;

        public b(JobSupport jobSupport, c cVar, C1079s c1079s, Object obj) {
            this.parent = jobSupport;
            this.state = cVar;
            this.child = c1079s;
            this.proposedUpdate = obj;
        }

        @Override // Ua.AbstractC1088w0
        public boolean u() {
            return false;
        }

        @Override // Ua.AbstractC1088w0
        public void v(Throwable cause) {
            this.parent.P(this.state, this.child, this.proposedUpdate);
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r2\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0017j\b\u0012\u0004\u0012\u00020\b`\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\u0013R\u0011\u0010'\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010 R\u0011\u0010)\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b(\u0010 R\u0014\u0010+\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010 R(\u00100\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000b\u00102\u001a\u0002018\u0002X\u0082\u0004R\u0013\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b038\u0002X\u0082\u0004R\u0013\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001038\u0002X\u0082\u0004¨\u00066"}, d2 = {"Lkotlinx/coroutines/JobSupport$c;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "LUa/q0;", "LUa/B0;", "list", "", "isCompleting", "", "rootCause", "<init>", "(LUa/B0;ZLjava/lang/Throwable;)V", "proposedException", "", "l", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "()Ljava/util/ArrayList;", "LUa/B0;", "getList", "()LUa/B0;", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "m", "(Z)V", "e", "()Ljava/lang/Throwable;", "o", "k", "isSealed", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "isCancelling", Const.INTENT_KEY_PKGNAME, "isActive", Const.INTENT_KEY_UMID, "()Ljava/lang/Object;", "n", "(Ljava/lang/Object;)V", "exceptionsHolder", "LOa/a;", "_isCompleting", "LOa/e;", "_rootCause", "_exceptionsHolder", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC1077q0 {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f36239b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f36240c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f36241d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final B0 list;

        public c(B0 b02, boolean z10, Throwable th) {
            this.list = b02;
            this._isCompleting$volatile = z10 ? 1 : 0;
            this._rootCause$volatile = th;
        }

        public final void a(Throwable exception) {
            Throwable thE = e();
            if (thE == null) {
                o(exception);
                return;
            }
            if (exception == thE) {
                return;
            }
            Object objD = d();
            if (objD == null) {
                n(exception);
                return;
            }
            if (objD instanceof Throwable) {
                if (exception == objD) {
                    return;
                }
                ArrayList<Throwable> arrayListC = c();
                arrayListC.add(objD);
                arrayListC.add(exception);
                n(arrayListC);
                return;
            }
            if (objD instanceof ArrayList) {
                ((ArrayList) objD).add(exception);
                return;
            }
            throw new IllegalStateException(("State is " + objD).toString());
        }

        @Override // Ua.InterfaceC1077q0
        /* renamed from: b */
        public boolean getIsActive() {
            return e() == null;
        }

        public final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        public final Object d() {
            return f36241d.get(this);
        }

        public final Throwable e() {
            return (Throwable) f36240c.get(this);
        }

        @Override // Ua.InterfaceC1077q0
        public B0 getList() {
            return this.list;
        }

        public final boolean i() {
            return e() != null;
        }

        public final boolean j() {
            return f36239b.get(this) == 1;
        }

        public final boolean k() {
            return d() == x0.f6406e;
        }

        public final List<Throwable> l(Throwable proposedException) {
            ArrayList<Throwable> arrayListC;
            Object objD = d();
            if (objD == null) {
                arrayListC = c();
            } else if (objD instanceof Throwable) {
                ArrayList<Throwable> arrayListC2 = c();
                arrayListC2.add(objD);
                arrayListC = arrayListC2;
            } else {
                if (!(objD instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objD).toString());
                }
                arrayListC = (ArrayList) objD;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListC.add(0, thE);
            }
            if (proposedException != null && !p.d(proposedException, thE)) {
                arrayListC.add(proposedException);
            }
            n(x0.f6406e);
            return arrayListC;
        }

        public final void m(boolean z10) {
            f36239b.set(this, z10 ? 1 : 0);
        }

        public final void n(Object obj) {
            f36241d.set(this, obj);
        }

        public final void o(Throwable th) {
            f36240c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + i() + ", completing=" + j() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + getList() + ']';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/JobSupport$d;", "LUa/w0;", "Lcb/j;", M5.c.ACTION_SELECT, "<init>", "(Lkotlinx/coroutines/JobSupport;Lcb/j;)V", "", "cause", "LY8/t;", "v", "(Ljava/lang/Throwable;)V", "e", "Lcb/j;", "", "u", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class d extends AbstractC1088w0 {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final j<?> select;

        public d(j<?> jVar) {
            this.select = jVar;
        }

        @Override // Ua.AbstractC1088w0
        public boolean u() {
            return false;
        }

        @Override // Ua.AbstractC1088w0
        public void v(Throwable cause) {
            Object objC0 = JobSupport.this.c0();
            if (!(objC0 instanceof C1091z)) {
                objC0 = x0.h(objC0);
            }
            this.select.f(JobSupport.this, objC0);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/JobSupport$e;", "LUa/w0;", "Lcb/j;", M5.c.ACTION_SELECT, "<init>", "(Lkotlinx/coroutines/JobSupport;Lcb/j;)V", "", "cause", "LY8/t;", "v", "(Ljava/lang/Throwable;)V", "e", "Lcb/j;", "", "u", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class e extends AbstractC1088w0 {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final j<?> select;

        public e(j<?> jVar) {
            this.select = jVar;
        }

        @Override // Ua.AbstractC1088w0
        public boolean u() {
            return false;
        }

        @Override // Ua.AbstractC1088w0
        public void v(Throwable cause) {
            this.select.f(JobSupport.this, t.f7040a);
        }
    }

    public JobSupport(boolean z10) {
        this._state$volatile = z10 ? x0.f6408g : x0.f6407f;
    }

    public static /* synthetic */ CancellationException K0(JobSupport jobSupport, Throwable th, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return jobSupport.J0(th, str);
    }

    @Override // Ua.InterfaceC1081t
    public final void A(E0 parentJob) throws Throwable {
        H(parentJob);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [Ua.p0] */
    public final void A0(C1051d0 state) {
        B0 b02 = new B0();
        if (!state.getIsActive()) {
            b02 = new C1075p0(b02);
        }
        f36232a.compareAndSet(this, state, b02);
    }

    public final void B(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(exceptions.size()));
        for (Throwable th : exceptions) {
            if (th != rootCause && th != rootCause && !(th instanceof CancellationException) && setNewSetFromMap.add(th)) {
                Y8.d.a(rootCause, th);
            }
        }
    }

    public final void B0(AbstractC1088w0 state) {
        state.d(new B0());
        f36232a.compareAndSet(this, state, state.k());
    }

    public void C(Object state) {
    }

    public final void C0(j<?> select, Object ignoredParam) {
        if (m0()) {
            select.e(JobKt__JobKt.q(this, false, new e(select), 1, null));
        } else {
            select.d(t.f7040a);
        }
    }

    public final Object D(InterfaceC4014c<Object> interfaceC4014c) throws Throwable {
        Object objC0;
        do {
            objC0 = c0();
            if (!(objC0 instanceof InterfaceC1077q0)) {
                if (objC0 instanceof C1091z) {
                    throw ((C1091z) objC0).cause;
                }
                return x0.h(objC0);
            }
        } while (G0(objC0) < 0);
        return E(interfaceC4014c);
    }

    public final Object E(InterfaceC4014c<Object> interfaceC4014c) {
        a aVar = new a(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), this);
        aVar.I();
        C1072o.a(aVar, JobKt__JobKt.q(this, false, new F0(aVar), 1, null));
        Object objC = aVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }

    public final void E0(AbstractC1088w0 node) {
        Object objC0;
        do {
            objC0 = c0();
            if (!(objC0 instanceof AbstractC1088w0)) {
                if (!(objC0 instanceof InterfaceC1077q0) || ((InterfaceC1077q0) objC0).getList() == null) {
                    return;
                }
                node.q();
                return;
            }
            if (objC0 != node) {
                return;
            }
        } while (!f36232a.compareAndSet(this, objC0, x0.f6408g));
    }

    public final boolean F(Throwable cause) {
        return H(cause);
    }

    public final void F0(r rVar) {
        f36233b.set(this, rVar);
    }

    @Override // kotlinx.coroutines.g
    public final CancellationException G() {
        Object objC0 = c0();
        if (!(objC0 instanceof c)) {
            if (objC0 instanceof InterfaceC1077q0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objC0 instanceof C1091z) {
                return K0(this, ((C1091z) objC0).cause, null, 1, null);
            }
            return new JobCancellationException(N.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((c) objC0).e();
        if (thE != null) {
            CancellationException cancellationExceptionJ0 = J0(thE, N.a(this) + " is cancelling");
            if (cancellationExceptionJ0 != null) {
                return cancellationExceptionJ0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final int G0(Object state) {
        if (state instanceof C1051d0) {
            if (((C1051d0) state).getIsActive()) {
                return 0;
            }
            if (!f36232a.compareAndSet(this, state, x0.f6408g)) {
                return -1;
            }
            z0();
            return 1;
        }
        if (!(state instanceof C1075p0)) {
            return 0;
        }
        if (!f36232a.compareAndSet(this, state, ((C1075p0) state).getList())) {
            return -1;
        }
        z0();
        return 1;
    }

    public final boolean H(Object cause) throws Throwable {
        Object objO0 = x0.f6402a;
        if (Y() && (objO0 = K(cause)) == x0.f6403b) {
            return true;
        }
        if (objO0 == x0.f6402a) {
            objO0 = o0(cause);
        }
        if (objO0 == x0.f6402a || objO0 == x0.f6403b) {
            return true;
        }
        if (objO0 == x0.f6405d) {
            return false;
        }
        C(objO0);
        return true;
    }

    public final String H0(Object state) {
        if (!(state instanceof c)) {
            return state instanceof InterfaceC1077q0 ? ((InterfaceC1077q0) state).getIsActive() ? "Active" : "New" : state instanceof C1091z ? "Cancelled" : "Completed";
        }
        c cVar = (c) state;
        return cVar.i() ? "Cancelling" : cVar.j() ? "Completing" : "Active";
    }

    public void I(Throwable cause) throws Throwable {
        H(cause);
    }

    @Override // kotlinx.coroutines.g
    public final InterfaceC1045a0 I0(boolean onCancelling, boolean invokeImmediately, InterfaceC5074l<? super Throwable, t> handler) {
        return j0(invokeImmediately, onCancelling ? new C1080s0(handler) : new C1082t0(handler));
    }

    @Override // kotlinx.coroutines.g
    public final InterfaceC1045a0 J(InterfaceC5074l<? super Throwable, t> handler) {
        return j0(true, new C1082t0(handler));
    }

    public final CancellationException J0(Throwable th, String str) {
        CancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = M();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    public final Object K(Object cause) {
        Object objP0;
        do {
            Object objC0 = c0();
            if (!(objC0 instanceof InterfaceC1077q0) || ((objC0 instanceof c) && ((c) objC0).j())) {
                return x0.f6402a;
            }
            objP0 = P0(objC0, new C1091z(Q(cause), false, 2, null));
        } while (objP0 == x0.f6404c);
        return objP0;
    }

    public final boolean L(Throwable cause) {
        if (l0()) {
            return true;
        }
        boolean z10 = cause instanceof CancellationException;
        r rVarB0 = b0();
        return (rVarB0 == null || rVarB0 == C0.f6325a) ? z10 : rVarB0.e(cause) || z10;
    }

    public final String L0() {
        return r0() + '{' + H0(c0()) + '}';
    }

    public String M() {
        return "Job was cancelled";
    }

    public final boolean M0(InterfaceC1077q0 state, Object update) throws Throwable {
        if (!f36232a.compareAndSet(this, state, x0.g(update))) {
            return false;
        }
        x0(null);
        y0(update);
        O(state, update);
        return true;
    }

    public boolean N(Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        return H(cause) && getHandlesException();
    }

    @Override // kotlinx.coroutines.g
    public final r N0(InterfaceC1081t child) {
        C1079s c1079s = new C1079s(child);
        c1079s.w(this);
        while (true) {
            Object objC0 = c0();
            if (objC0 instanceof C1051d0) {
                C1051d0 c1051d0 = (C1051d0) objC0;
                if (!c1051d0.getIsActive()) {
                    A0(c1051d0);
                } else if (f36232a.compareAndSet(this, objC0, c1079s)) {
                    return c1079s;
                }
            } else {
                if (!(objC0 instanceof InterfaceC1077q0)) {
                    Object objC02 = c0();
                    C1091z c1091z = objC02 instanceof C1091z ? (C1091z) objC02 : null;
                    c1079s.v(c1091z != null ? c1091z.cause : null);
                    return C0.f6325a;
                }
                B0 list = ((InterfaceC1077q0) objC0).getList();
                if (list != null) {
                    if (!list.a(c1079s, 7)) {
                        boolean zA = list.a(c1079s, 3);
                        Object objC03 = c0();
                        if (objC03 instanceof c) {
                            thE = ((c) objC03).e();
                        } else {
                            C1091z c1091z2 = objC03 instanceof C1091z ? (C1091z) objC03 : null;
                            if (c1091z2 != null) {
                                thE = c1091z2.cause;
                            }
                        }
                        c1079s.v(thE);
                        if (!zA) {
                            return C0.f6325a;
                        }
                    }
                    return c1079s;
                }
                p.g(objC0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                B0((AbstractC1088w0) objC0);
            }
        }
    }

    public final void O(InterfaceC1077q0 state, Object update) throws Throwable {
        r rVarB0 = b0();
        if (rVarB0 != null) {
            rVarB0.dispose();
            F0(C0.f6325a);
        }
        C1091z c1091z = update instanceof C1091z ? (C1091z) update : null;
        Throwable th = c1091z != null ? c1091z.cause : null;
        if (!(state instanceof AbstractC1088w0)) {
            B0 list = state.getList();
            if (list != null) {
                u0(list, th);
                return;
            }
            return;
        }
        try {
            ((AbstractC1088w0) state).v(th);
        } catch (Throwable th2) {
            h0(new CompletionHandlerException("Exception in completion handler " + state + " for " + this, th2));
        }
    }

    public final boolean O0(InterfaceC1077q0 state, Throwable rootCause) throws Throwable {
        B0 b0Z = Z(state);
        if (b0Z == null) {
            return false;
        }
        if (!f36232a.compareAndSet(this, state, new c(b0Z, false, rootCause))) {
            return false;
        }
        t0(b0Z, rootCause);
        return true;
    }

    public final void P(c state, C1079s lastChild, Object proposedUpdate) {
        C1079s c1079sS0 = s0(lastChild);
        if (c1079sS0 == null || !S0(state, c1079sS0, proposedUpdate)) {
            state.getList().f(2);
            C1079s c1079sS02 = s0(lastChild);
            if (c1079sS02 == null || !S0(state, c1079sS02, proposedUpdate)) {
                C(R(state, proposedUpdate));
            }
        }
    }

    public final Object P0(Object state, Object proposedUpdate) {
        return !(state instanceof InterfaceC1077q0) ? x0.f6402a : ((!(state instanceof C1051d0) && !(state instanceof AbstractC1088w0)) || (state instanceof C1079s) || (proposedUpdate instanceof C1091z)) ? Q0((InterfaceC1077q0) state, proposedUpdate) : M0((InterfaceC1077q0) state, proposedUpdate) ? proposedUpdate : x0.f6404c;
    }

    public final Throwable Q(Object cause) {
        if (cause == null ? true : cause instanceof Throwable) {
            Throwable th = (Throwable) cause;
            return th == null ? new JobCancellationException(M(), null, this) : th;
        }
        p.g(cause, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((E0) cause).k0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final Object Q0(InterfaceC1077q0 state, Object proposedUpdate) throws Throwable {
        B0 b0Z = Z(state);
        if (b0Z == null) {
            return x0.f6404c;
        }
        c cVar = state instanceof c ? (c) state : null;
        if (cVar == null) {
            cVar = new c(b0Z, false, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (cVar) {
            if (cVar.j()) {
                return x0.f6402a;
            }
            cVar.m(true);
            if (cVar != state && !f36232a.compareAndSet(this, state, cVar)) {
                return x0.f6404c;
            }
            boolean zI = cVar.i();
            C1091z c1091z = proposedUpdate instanceof C1091z ? (C1091z) proposedUpdate : null;
            if (c1091z != null) {
                cVar.a(c1091z.cause);
            }
            ?? E10 = zI ? 0 : cVar.e();
            ref$ObjectRef.f34820a = E10;
            t tVar = t.f7040a;
            if (E10 != 0) {
                t0(b0Z, E10);
            }
            C1079s c1079sS0 = s0(b0Z);
            if (c1079sS0 != null && S0(cVar, c1079sS0, proposedUpdate)) {
                return x0.f6403b;
            }
            b0Z.f(2);
            C1079s c1079sS02 = s0(b0Z);
            return (c1079sS02 == null || !S0(cVar, c1079sS02, proposedUpdate)) ? R(cVar, proposedUpdate) : x0.f6403b;
        }
    }

    public final Object R(c state, Object proposedUpdate) throws Throwable {
        boolean zI;
        Throwable thU;
        C1091z c1091z = proposedUpdate instanceof C1091z ? (C1091z) proposedUpdate : null;
        Throwable th = c1091z != null ? c1091z.cause : null;
        synchronized (state) {
            zI = state.i();
            List<Throwable> listL = state.l(th);
            thU = U(state, listL);
            if (thU != null) {
                B(thU, listL);
            }
        }
        if (thU != null && thU != th) {
            proposedUpdate = new C1091z(thU, false, 2, null);
        }
        if (thU != null && (L(thU) || g0(thU))) {
            p.g(proposedUpdate, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((C1091z) proposedUpdate).c();
        }
        if (!zI) {
            x0(thU);
        }
        y0(proposedUpdate);
        f36232a.compareAndSet(this, state, x0.g(proposedUpdate));
        O(state, proposedUpdate);
        return proposedUpdate;
    }

    @Override // kotlinx.coroutines.g
    public final cb.d R0() {
        JobSupport$onJoin$1 jobSupport$onJoin$1 = JobSupport$onJoin$1.f36260a;
        p.g(jobSupport$onJoin$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new cb.e(this, (q) z.g(jobSupport$onJoin$1, 3), null, 4, null);
    }

    public final Object S() throws Throwable {
        Object objC0 = c0();
        if (objC0 instanceof InterfaceC1077q0) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (objC0 instanceof C1091z) {
            throw ((C1091z) objC0).cause;
        }
        return x0.h(objC0);
    }

    public final boolean S0(c state, C1079s child, Object proposedUpdate) {
        while (C1086v0.p(child.childJob, false, new b(this, state, child, proposedUpdate)) == C0.f6325a) {
            child = s0(child);
            if (child == null) {
                return false;
            }
        }
        return true;
    }

    public final Throwable T(Object obj) {
        C1091z c1091z = obj instanceof C1091z ? (C1091z) obj : null;
        if (c1091z != null) {
            return c1091z.cause;
        }
        return null;
    }

    @Override // kotlinx.coroutines.g
    public final Object T0(InterfaceC4014c<? super t> interfaceC4014c) {
        if (m0()) {
            Object objN0 = n0(interfaceC4014c);
            return objN0 == C4063a.g() ? objN0 : t.f7040a;
        }
        C1086v0.m(interfaceC4014c.getContext());
        return t.f7040a;
    }

    public final Throwable U(c state, List<? extends Throwable> exceptions) {
        Object next;
        Object obj = null;
        if (exceptions.isEmpty()) {
            if (state.i()) {
                return new JobCancellationException(M(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list = exceptions;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = exceptions.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    /* renamed from: W */
    public boolean getHandlesException() {
        return true;
    }

    public final cb.f<?> X() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.f36258a;
        p.g(jobSupport$onAwaitInternal$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        q qVar = (q) z.g(jobSupport$onAwaitInternal$1, 3);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.f36259a;
        p.g(jobSupport$onAwaitInternal$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new cb.g(this, qVar, (q) z.g(jobSupport$onAwaitInternal$2, 3), null, 8, null);
    }

    public boolean Y() {
        return false;
    }

    public final B0 Z(InterfaceC1077q0 state) {
        B0 list = state.getList();
        if (list != null) {
            return list;
        }
        if (state instanceof C1051d0) {
            return new B0();
        }
        if (state instanceof AbstractC1088w0) {
            B0((AbstractC1088w0) state);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + state).toString());
    }

    public g a0() {
        r rVarB0 = b0();
        if (rVarB0 != null) {
            return rVarB0.getParent();
        }
        return null;
    }

    @Override // kotlinx.coroutines.g
    public boolean b() {
        Object objC0 = c0();
        return (objC0 instanceof InterfaceC1077q0) && ((InterfaceC1077q0) objC0).getIsActive();
    }

    public final r b0() {
        return (r) f36233b.get(this);
    }

    public final Object c0() {
        return f36232a.get(this);
    }

    @Override // kotlin.coroutines.d
    public /* bridge */ <R> R fold(R r10, p9.p<? super R, ? super d.b, ? extends R> pVar) {
        return (R) g.a.b(this, r10, pVar);
    }

    @Override // kotlinx.coroutines.g
    public final boolean g() {
        return !(c0() instanceof InterfaceC1077q0);
    }

    public boolean g0(Throwable exception) {
        return false;
    }

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    public /* bridge */ <E extends d.b> E get(d.c<E> cVar) {
        return (E) g.a.c(this, cVar);
    }

    @Override // kotlinx.coroutines.g
    public final Ka.j<g> getChildren() {
        return m.b(new JobSupport$children$1(this, null));
    }

    @Override // kotlin.coroutines.d.b
    public final d.c<?> getKey() {
        return g.INSTANCE;
    }

    public void h0(Throwable exception) throws Throwable {
        throw exception;
    }

    @Override // kotlinx.coroutines.g, Wa.r
    public void i(CancellationException cause) throws Throwable {
        if (cause == null) {
            cause = new JobCancellationException(M(), null, this);
        }
        I(cause);
    }

    public final void i0(g parent) {
        if (parent == null) {
            F0(C0.f6325a);
            return;
        }
        parent.start();
        r rVarN0 = parent.N0(this);
        F0(rVarN0);
        if (g()) {
            rVarN0.dispose();
            F0(C0.f6325a);
        }
    }

    @Override // kotlinx.coroutines.g
    public final boolean isCancelled() {
        Object objC0 = c0();
        if (objC0 instanceof C1091z) {
            return true;
        }
        return (objC0 instanceof c) && ((c) objC0).i();
    }

    public final InterfaceC1045a0 j0(boolean invokeImmediately, AbstractC1088w0 node) {
        boolean z10;
        boolean zA;
        node.w(this);
        while (true) {
            Object objC0 = c0();
            z10 = true;
            if (!(objC0 instanceof C1051d0)) {
                if (!(objC0 instanceof InterfaceC1077q0)) {
                    z10 = false;
                    break;
                }
                InterfaceC1077q0 interfaceC1077q0 = (InterfaceC1077q0) objC0;
                B0 list = interfaceC1077q0.getList();
                if (list == null) {
                    p.g(objC0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    B0((AbstractC1088w0) objC0);
                } else {
                    if (node.u()) {
                        c cVar = interfaceC1077q0 instanceof c ? (c) interfaceC1077q0 : null;
                        Throwable thE = cVar != null ? cVar.e() : null;
                        if (thE != null) {
                            if (invokeImmediately) {
                                node.v(thE);
                            }
                            return C0.f6325a;
                        }
                        zA = list.a(node, 5);
                    } else {
                        zA = list.a(node, 1);
                    }
                    if (zA) {
                        break;
                    }
                }
            } else {
                C1051d0 c1051d0 = (C1051d0) objC0;
                if (!c1051d0.getIsActive()) {
                    A0(c1051d0);
                } else if (f36232a.compareAndSet(this, objC0, node)) {
                    break;
                }
            }
        }
        if (z10) {
            return node;
        }
        if (invokeImmediately) {
            Object objC02 = c0();
            C1091z c1091z = objC02 instanceof C1091z ? (C1091z) objC02 : null;
            node.v(c1091z != null ? c1091z.cause : null);
        }
        return C0.f6325a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // Ua.E0
    public CancellationException k0() {
        CancellationException cancellationExceptionE;
        Object objC0 = c0();
        if (objC0 instanceof c) {
            cancellationExceptionE = ((c) objC0).e();
        } else if (objC0 instanceof C1091z) {
            cancellationExceptionE = ((C1091z) objC0).cause;
        } else {
            if (objC0 instanceof InterfaceC1077q0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objC0).toString());
            }
            cancellationExceptionE = null;
        }
        CancellationException cancellationException = cancellationExceptionE instanceof CancellationException ? cancellationExceptionE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + H0(objC0), cancellationExceptionE, this);
    }

    public boolean l0() {
        return false;
    }

    public final boolean m0() {
        Object objC0;
        do {
            objC0 = c0();
            if (!(objC0 instanceof InterfaceC1077q0)) {
                return false;
            }
        } while (G0(objC0) < 0);
        return true;
    }

    @Override // kotlin.coroutines.d
    public /* bridge */ kotlin.coroutines.d minusKey(d.c<?> cVar) {
        return g.a.e(this, cVar);
    }

    public final Object n0(InterfaceC4014c<? super t> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        C1072o.a(cVar, JobKt__JobKt.q(this, false, new G0(cVar), 1, null));
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC == C4063a.g() ? objC : t.f7040a;
    }

    public final Object o0(Object cause) throws Throwable {
        Throwable thQ = null;
        while (true) {
            Object objC0 = c0();
            if (objC0 instanceof c) {
                synchronized (objC0) {
                    if (((c) objC0).k()) {
                        return x0.f6405d;
                    }
                    boolean zI = ((c) objC0).i();
                    if (cause != null || !zI) {
                        if (thQ == null) {
                            thQ = Q(cause);
                        }
                        ((c) objC0).a(thQ);
                    }
                    Throwable thE = zI ? null : ((c) objC0).e();
                    if (thE != null) {
                        t0(((c) objC0).getList(), thE);
                    }
                    return x0.f6402a;
                }
            }
            if (!(objC0 instanceof InterfaceC1077q0)) {
                return x0.f6405d;
            }
            if (thQ == null) {
                thQ = Q(cause);
            }
            InterfaceC1077q0 interfaceC1077q0 = (InterfaceC1077q0) objC0;
            if (!interfaceC1077q0.getIsActive()) {
                Object objP0 = P0(objC0, new C1091z(thQ, false, 2, null));
                if (objP0 == x0.f6402a) {
                    throw new IllegalStateException(("Cannot happen in " + objC0).toString());
                }
                if (objP0 != x0.f6404c) {
                    return objP0;
                }
            } else if (O0(interfaceC1077q0, thQ)) {
                return x0.f6402a;
            }
        }
    }

    public final boolean p0(Object proposedUpdate) {
        Object objP0;
        do {
            objP0 = P0(c0(), proposedUpdate);
            if (objP0 == x0.f6402a) {
                return false;
            }
            if (objP0 == x0.f6403b) {
                return true;
            }
        } while (objP0 == x0.f6404c);
        C(objP0);
        return true;
    }

    @Override // kotlin.coroutines.d
    public /* bridge */ kotlin.coroutines.d plus(kotlin.coroutines.d dVar) {
        return g.a.f(this, dVar);
    }

    public final Object q0(Object proposedUpdate) {
        Object objP0;
        do {
            objP0 = P0(c0(), proposedUpdate);
            if (objP0 == x0.f6402a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, T(proposedUpdate));
            }
        } while (objP0 == x0.f6404c);
        return objP0;
    }

    public String r0() {
        return N.a(this);
    }

    public final C1079s s0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.p()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.l();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.k();
            if (!lockFreeLinkedListNode.p()) {
                if (lockFreeLinkedListNode instanceof C1079s) {
                    return (C1079s) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof B0) {
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.g
    public final boolean start() {
        int iG0;
        do {
            iG0 = G0(c0());
            if (iG0 == 0) {
                return false;
            }
        } while (iG0 != 1);
        return true;
    }

    public final void t0(B0 list, Throwable cause) throws Throwable {
        x0(cause);
        list.f(4);
        Object objJ = list.j();
        p.g(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeK = (LockFreeLinkedListNode) objJ; !p.d(lockFreeLinkedListNodeK, list); lockFreeLinkedListNodeK = lockFreeLinkedListNodeK.k()) {
            if ((lockFreeLinkedListNodeK instanceof AbstractC1088w0) && ((AbstractC1088w0) lockFreeLinkedListNodeK).u()) {
                try {
                    ((AbstractC1088w0) lockFreeLinkedListNodeK).v(cause);
                } catch (Throwable th) {
                    if (completionHandlerException != null) {
                        Y8.d.a(completionHandlerException, th);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNodeK + " for " + this, th);
                        t tVar = t.f7040a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            h0(completionHandlerException);
        }
        L(cause);
    }

    public String toString() {
        return L0() + '@' + N.b(this);
    }

    public final void u0(B0 b02, Throwable th) throws Throwable {
        b02.f(1);
        Object objJ = b02.j();
        p.g(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeK = (LockFreeLinkedListNode) objJ; !p.d(lockFreeLinkedListNodeK, b02); lockFreeLinkedListNodeK = lockFreeLinkedListNodeK.k()) {
            if (lockFreeLinkedListNodeK instanceof AbstractC1088w0) {
                try {
                    ((AbstractC1088w0) lockFreeLinkedListNodeK).v(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        Y8.d.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNodeK + " for " + this, th2);
                        t tVar = t.f7040a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            h0(completionHandlerException);
        }
    }

    public final Object v0(Object ignoredParam, Object result) throws Throwable {
        if (result instanceof C1091z) {
            throw ((C1091z) result).cause;
        }
        return result;
    }

    public final void w0(j<?> select, Object ignoredParam) {
        Object objC0;
        do {
            objC0 = c0();
            if (!(objC0 instanceof InterfaceC1077q0)) {
                if (!(objC0 instanceof C1091z)) {
                    objC0 = x0.h(objC0);
                }
                select.d(objC0);
                return;
            }
        } while (G0(objC0) < 0);
        select.e(JobKt__JobKt.q(this, false, new d(select), 1, null));
    }

    public void x0(Throwable cause) {
    }

    public void y0(Object state) {
    }

    public void z0() {
    }
}
