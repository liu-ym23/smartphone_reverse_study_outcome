package com.stepos.agentbus.generated;

import La.H;
import La.K;
import M5.e;
import O6.l;
import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Wa.j;
import Xa.k;
import Xa.u;
import Y8.t;
import Z8.Q;
import a4.BffLinkStatus;
import a4.ChannelReadyEvent;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentbus.generated.c;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.core.ability.AbilityType;
import com.stepos.core.ability.converter.BundleContentBridge;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import eb.f;
import f9.C4063a;
import io.ktor.http.ContentDisposition;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000 \u008d\u00012\u00020\u0001:\u0003ac_B¯\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010 \u001a\u00020\u00122\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010\u001cJ;\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010#2\u0006\u0010%\u001a\u00020\u0002H\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0012H\u0002¢\u0006\u0004\b*\u0010\u001cJ\u0010\u0010,\u001a\u00020+H\u0082@¢\u0006\u0004\b,\u0010)J\u0018\u0010.\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b.\u0010/J\u0019\u00101\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u0002042\u0006\u00103\u001a\u00020\u0010H\u0002¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0002H\u0082@¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0012¢\u0006\u0004\b:\u0010\u001cJ\r\u0010;\u001a\u00020\u0012¢\u0006\u0004\b;\u0010\u001cJ\u001a\u0010=\u001a\u00020+2\b\b\u0002\u0010<\u001a\u00020\nH\u0086@¢\u0006\u0004\b=\u0010>J0\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00022\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010#H\u0086@¢\u0006\u0004\b@\u0010AJ0\u0010C\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00022\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010#H\u0086@¢\u0006\u0004\bC\u0010AJ\u0018\u0010D\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0002H\u0086@¢\u0006\u0004\bD\u00109J\r\u0010E\u001a\u00020\u0002¢\u0006\u0004\bE\u0010\u001aJ$\u0010F\u001a\u0004\u0018\u00010\u00102\u0006\u0010%\u001a\u00020\u00022\b\b\u0002\u0010<\u001a\u00020\nH\u0086@¢\u0006\u0004\bF\u0010GJ:\u0010I\u001a\u00020H2\u0006\u0010?\u001a\u00020\u00022\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010#2\b\b\u0002\u0010<\u001a\u00020\nH\u0086@¢\u0006\u0004\bI\u0010JJ\u0015\u0010L\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u0002¢\u0006\u0004\bL\u0010MJ#\u0010O\u001a\u00020\u00022\u0014\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010#¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\u00012\b\u0010Q\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bR\u0010SJ#\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010#2\u0006\u00103\u001a\u00020\u0010¢\u0006\u0004\bT\u0010UJ\u0019\u0010V\u001a\u0004\u0018\u00010\u00012\b\u0010Q\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bV\u0010SJ5\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000Z\"\u0004\b\u0000\u0010L2\u0006\u0010X\u001a\u00020W2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b[\u0010\\J\u001b\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00020Z2\u0006\u0010X\u001a\u00020W¢\u0006\u0004\b]\u0010^R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010`R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010`R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010`R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010`R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010jR0\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010bR\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010bR\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010hR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010x\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010|\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001d\u0010\u0087\u0001\u001a\t\u0012\u0004\u0012\u00020+0\u0085\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bK\u0010\u0086\u0001R\u001e\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0086\u0001R#\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u008a\u00018\u0006¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0017\u0010\u0090\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010jR\u0018\u0010\u0094\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0016\u0010\u0096\u0001\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010{R\u001d\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u0097\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bE\u0010\u0098\u0001R\u0017\u0010\u009a\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010hR6\u0010 \u0001\u001a\u0011\u0012\u0005\u0012\u00030\u009b\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b]\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0005\b\u009f\u0001\u0010!R*\u0010¤\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00100¢\u00010¡\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b[\u0010£\u0001R\u001d\u0010¥\u0001\u001a\t\u0012\u0004\u0012\u0002040\u0085\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b=\u0010\u0086\u0001R\u001d\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u0002040\u0085\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bF\u0010\u0086\u0001R\u001d\u0010§\u0001\u001a\t\u0012\u0004\u0012\u0002040\u0085\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0019\u0010\u0086\u0001R\u001d\u0010¨\u0001\u001a\t\u0012\u0004\u0012\u0002040\u0085\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b,\u0010\u0086\u0001R\u001e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u0002040\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010\u0086\u0001R\u001f\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u00030«\u00010\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u0086\u0001R\"\u0010¯\u0001\u001a\t\u0012\u0004\u0012\u0002040\u008a\u00018\u0006¢\u0006\u000f\n\u0005\bj\u0010\u008c\u0001\u001a\u0006\b®\u0001\u0010\u008e\u0001R\"\u0010±\u0001\u001a\t\u0012\u0004\u0012\u0002040\u008a\u00018\u0006¢\u0006\u000f\n\u0005\bh\u0010\u008c\u0001\u001a\u0006\b°\u0001\u0010\u008e\u0001R#\u0010´\u0001\u001a\t\u0012\u0004\u0012\u0002040\u008a\u00018\u0006¢\u0006\u0010\n\u0006\b²\u0001\u0010\u008c\u0001\u001a\u0006\b³\u0001\u0010\u008e\u0001R\"\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u0002040\u008a\u00018\u0006¢\u0006\u000f\n\u0005\b.\u0010\u008c\u0001\u001a\u0006\bµ\u0001\u0010\u008e\u0001R#\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u0002040\u008a\u00018\u0006¢\u0006\u0010\n\u0006\b·\u0001\u0010\u008c\u0001\u001a\u0006\b·\u0001\u0010\u008e\u0001R$\u0010»\u0001\u001a\n\u0012\u0005\u0012\u00030«\u00010\u008a\u00018\u0006¢\u0006\u0010\n\u0006\b¹\u0001\u0010\u008c\u0001\u001a\u0006\bº\u0001\u0010\u008e\u0001R#\u0010¼\u0001\u001a\t\u0012\u0004\u0012\u00020+0\u008a\u00018\u0006¢\u0006\u0010\n\u0006\b\u009d\u0001\u0010\u008c\u0001\u001a\u0006\b¹\u0001\u0010\u008e\u0001R\u0014\u0010¿\u0001\u001a\u00020+8F¢\u0006\b\u001a\u0006\b½\u0001\u0010¾\u0001¨\u0006À\u0001"}, d2 = {"Lcom/stepos/agentbus/generated/AgentBusBindingBase;", "", "", "socketName", "Lkotlin/Function0;", "clientIdProvider", "displayName", "version", BundleContentBridge.KEY_ROLE, "reqIdPrefix", "", "reconnectDelayMs", "", "protocolMin", "protocolMax", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "Le9/c;", "LY8/t;", "dispatchEvent", "clientExtra", "connectParamsExtra", "idleTimeoutMs", "<init>", "(Ljava/lang/String;Lp9/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILp9/p;Lp9/a;Lp9/a;J)V", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/String;", "k0", "()V", "Lkotlin/Function1;", "Lcom/stepos/agentbus/generated/AgentBusBindingBase$b;", "block", "X", "(Lp9/l;)V", ExifInterface.LONGITUDE_WEST, "", "params", "frameId", "R", "(Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;", "b0", "(Le9/c;)Ljava/lang/Object;", "Y", "", "F", "frame", "L", "(Lorg/json/JSONObject;Le9/c;)Ljava/lang/Object;", "payload", "z", "(Lorg/json/JSONObject;)V", "obj", "Lcom/stepos/agentbus/generated/c;", "Z", "(Lorg/json/JSONObject;)Lcom/stepos/agentbus/generated/c;", "json", "l0", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "g0", "h0", "timeoutMs", "C", "(JLe9/c;)Ljava/lang/Object;", "method", "f0", "(Ljava/lang/String;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "event", "e0", "p0", "y", "D", "(Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "La4/v;", "a0", "(Ljava/lang/String;Ljava/util/Map;JLe9/c;)Ljava/lang/Object;", "s", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/String;", C3081a.FOCUS_MAP_NAME, "i0", "(Ljava/util/Map;)Ljava/lang/String;", "v", "j0", "(Ljava/lang/Object;)Ljava/lang/Object;", "U", "(Lorg/json/JSONObject;)Ljava/util/Map;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lorg/json/JSONArray;", "arr", e.FAIL_PARSE, "", "B", "(Lorg/json/JSONArray;Lp9/l;)Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lorg/json/JSONArray;)Ljava/util/List;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Lp9/a;", "c", Const.INTENT_KEY_UMID, "e", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lp9/p;", "k", "l", "m", "LUa/M;", "n", "LUa/M;", "scope", "Lkotlinx/coroutines/g;", "o", "Lkotlinx/coroutines/g;", "serveJob", "Ljava/util/concurrent/atomic/AtomicLong;", "p", "Ljava/util/concurrent/atomic/AtomicLong;", c.a.COL_SEQ, "Ljava/io/DataOutputStream;", "q", "Ljava/io/DataOutputStream;", "outputStream", "Leb/a;", "r", "Leb/a;", "writeMutex", "LXa/k;", "LXa/k;", "connectedFlow", "t", "mutableStatus", "LXa/t;", "u", "LXa/t;", "P", "()LXa/t;", "status", "pendingOutboxDepth", "Ljava/util/concurrent/atomic/AtomicInteger;", "w", "Ljava/util/concurrent/atomic/AtomicInteger;", "pendingInboxDepth", "x", "reconnectAttemptsCounter", "LWa/g;", "LWa/g;", "reconnectSignal", "lastActivityMs", "La4/q;", "Lp9/l;", "O", "()Lp9/l;", "setOnChannelReady", "onChannelReady", "Ljava/util/concurrent/ConcurrentHashMap;", "LUa/u;", "Ljava/util/concurrent/ConcurrentHashMap;", "pendingResponses", "mutableServiceHealth", "mutableChatHealth", "mutableToolsHealth", "mutableUpstreamHealth", "G", "mutableBffHealth", "La4/o;", "H", "mutableBffLinkState", "getServiceHealth", "serviceHealth", "getChatHealth", "chatHealth", "K", "getToolsHealth", "toolsHealth", "Q", "upstreamHealth", "M", "bffHealth", "N", "getBffLinkState", "bffLinkState", "connected", ExifInterface.LATITUDE_SOUTH, "()Z", "isConnected", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public class AgentBusBindingBase {

    /* renamed from: P, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5074l<? super ChannelReadyEvent, t> onChannelReady;

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<String, InterfaceC1083u<JSONObject>> pendingResponses;

    /* renamed from: C, reason: collision with root package name and from kotlin metadata */
    public final k<com.stepos.agentbus.generated.c> mutableServiceHealth;

    /* renamed from: D, reason: collision with root package name and from kotlin metadata */
    public final k<com.stepos.agentbus.generated.c> mutableChatHealth;

    /* renamed from: E, reason: collision with root package name and from kotlin metadata */
    public final k<com.stepos.agentbus.generated.c> mutableToolsHealth;

    /* renamed from: F, reason: collision with root package name and from kotlin metadata */
    public final k<com.stepos.agentbus.generated.c> mutableUpstreamHealth;

    /* renamed from: G, reason: collision with root package name and from kotlin metadata */
    public final k<com.stepos.agentbus.generated.c> mutableBffHealth;

    /* renamed from: H, reason: collision with root package name and from kotlin metadata */
    public final k<BffLinkStatus> mutableBffLinkState;

    /* renamed from: I, reason: collision with root package name and from kotlin metadata */
    public final Xa.t<com.stepos.agentbus.generated.c> serviceHealth;

    /* renamed from: J, reason: collision with root package name and from kotlin metadata */
    public final Xa.t<com.stepos.agentbus.generated.c> chatHealth;

    /* renamed from: K, reason: collision with root package name and from kotlin metadata */
    public final Xa.t<com.stepos.agentbus.generated.c> toolsHealth;

    /* renamed from: L, reason: collision with root package name and from kotlin metadata */
    public final Xa.t<com.stepos.agentbus.generated.c> upstreamHealth;

    /* renamed from: M, reason: collision with root package name and from kotlin metadata */
    public final Xa.t<com.stepos.agentbus.generated.c> bffHealth;

    /* renamed from: N, reason: collision with root package name and from kotlin metadata */
    public final Xa.t<BffLinkStatus> bffLinkState;

    /* renamed from: O, reason: collision with root package name and from kotlin metadata */
    public final Xa.t<Boolean> connected;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String socketName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<String> clientIdProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String displayName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String version;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String role;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String reqIdPrefix;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final long reconnectDelayMs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final int protocolMin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final int protocolMax;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final p<JSONObject, InterfaceC4014c<? super t>, Object> dispatchEvent;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<String> clientExtra;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<String> connectParamsExtra;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final long idleTimeoutMs;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public M scope;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public g serveJob;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final AtomicLong seq;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public volatile DataOutputStream outputStream;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4021a writeMutex;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final k<Boolean> connectedFlow;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final k<ConnectionStatus> mutableStatus;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public final Xa.t<ConnectionStatus> status;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public volatile int pendingOutboxDepth;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public final AtomicInteger pendingInboxDepth;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final AtomicLong reconnectAttemptsCounter;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final Wa.g<t> reconnectSignal;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public volatile long lastActivityMs;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentbus/generated/AgentBusBindingBase$a;", "", "<init>", "()V", "", "data", "", Const.INTENT_KEY_APIKEY, "([B)J", "", "TAG", "Ljava/lang/String;", "", "MAX_INBOUND_FRAME_BYTES", "I", "INBOUND_QUEUE_CAPACITY", "INBOUND_ENQUEUE_TIMEOUT_MS", "J", "FRAME_DEDUP_CAPACITY", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final long a(byte[] data) {
            kotlin.jvm.internal.p.i(data, "data");
            long j10 = -3750763034362895579L;
            for (byte b10 : data) {
                j10 = (j10 ^ (b10 & 255)) * 1099511628211L;
            }
            return j10;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJh\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0015R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b-\u0010+\u001a\u0004\b.\u0010\u0015R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010\u001f¨\u00061"}, d2 = {"Lcom/stepos/agentbus/generated/AgentBusBindingBase$b;", "", "", "connected", "", "lastConnectedAtMs", "lastDisconnectAtMs", "reconnectAttempts", "", "negotiatedProtocol", "outboxDepth", "inboxDepth", "lastWriteAtMs", "<init>", "(ZLjava/lang/Long;Ljava/lang/Long;JLjava/lang/Integer;IILjava/lang/Long;)V", Const.INTENT_KEY_APIKEY, "(ZLjava/lang/Long;Ljava/lang/Long;JLjava/lang/Integer;IILjava/lang/Long;)Lcom/stepos/agentbus/generated/AgentBusBindingBase$b;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getConnected", "()Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Long;", "getLastConnectedAtMs", "()Ljava/lang/Long;", "c", "getLastDisconnectAtMs", Const.INTENT_KEY_UMID, "J", "getReconnectAttempts", "()J", "e", "Ljava/lang/Integer;", "getNegotiatedProtocol", "()Ljava/lang/Integer;", "f", "I", "getOutboxDepth", Const.INTENT_KEY_BACKGROUND_COMMAND, "getInboxDepth", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "getLastWriteAtMs", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$b, reason: from toString */
    public static final /* data */ class ConnectionStatus {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean connected;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long lastConnectedAtMs;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long lastDisconnectAtMs;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final long reconnectAttempts;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final Integer negotiatedProtocol;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final int outboxDepth;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final int inboxDepth;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long lastWriteAtMs;

        public ConnectionStatus() {
            this(false, null, null, 0L, null, 0, 0, null, 255, null);
        }

        public static /* synthetic */ ConnectionStatus b(ConnectionStatus connectionStatus, boolean z10, Long l10, Long l11, long j10, Integer num, int i10, int i11, Long l12, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                z10 = connectionStatus.connected;
            }
            if ((i12 & 2) != 0) {
                l10 = connectionStatus.lastConnectedAtMs;
            }
            if ((i12 & 4) != 0) {
                l11 = connectionStatus.lastDisconnectAtMs;
            }
            if ((i12 & 8) != 0) {
                j10 = connectionStatus.reconnectAttempts;
            }
            if ((i12 & 16) != 0) {
                num = connectionStatus.negotiatedProtocol;
            }
            if ((i12 & 32) != 0) {
                i10 = connectionStatus.outboxDepth;
            }
            if ((i12 & 64) != 0) {
                i11 = connectionStatus.inboxDepth;
            }
            if ((i12 & 128) != 0) {
                l12 = connectionStatus.lastWriteAtMs;
            }
            long j11 = j10;
            Long l13 = l11;
            return connectionStatus.a(z10, l10, l13, j11, num, i10, i11, l12);
        }

        public final ConnectionStatus a(boolean connected, Long lastConnectedAtMs, Long lastDisconnectAtMs, long reconnectAttempts, Integer negotiatedProtocol, int outboxDepth, int inboxDepth, Long lastWriteAtMs) {
            return new ConnectionStatus(connected, lastConnectedAtMs, lastDisconnectAtMs, reconnectAttempts, negotiatedProtocol, outboxDepth, inboxDepth, lastWriteAtMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectionStatus)) {
                return false;
            }
            ConnectionStatus connectionStatus = (ConnectionStatus) other;
            return this.connected == connectionStatus.connected && kotlin.jvm.internal.p.d(this.lastConnectedAtMs, connectionStatus.lastConnectedAtMs) && kotlin.jvm.internal.p.d(this.lastDisconnectAtMs, connectionStatus.lastDisconnectAtMs) && this.reconnectAttempts == connectionStatus.reconnectAttempts && kotlin.jvm.internal.p.d(this.negotiatedProtocol, connectionStatus.negotiatedProtocol) && this.outboxDepth == connectionStatus.outboxDepth && this.inboxDepth == connectionStatus.inboxDepth && kotlin.jvm.internal.p.d(this.lastWriteAtMs, connectionStatus.lastWriteAtMs);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.connected) * 31;
            Long l10 = this.lastConnectedAtMs;
            int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
            Long l11 = this.lastDisconnectAtMs;
            int iHashCode3 = (((iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31) + Long.hashCode(this.reconnectAttempts)) * 31;
            Integer num = this.negotiatedProtocol;
            int iHashCode4 = (((((iHashCode3 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.outboxDepth)) * 31) + Integer.hashCode(this.inboxDepth)) * 31;
            Long l12 = this.lastWriteAtMs;
            return iHashCode4 + (l12 != null ? l12.hashCode() : 0);
        }

        public String toString() {
            return "ConnectionStatus(connected=" + this.connected + ", lastConnectedAtMs=" + this.lastConnectedAtMs + ", lastDisconnectAtMs=" + this.lastDisconnectAtMs + ", reconnectAttempts=" + this.reconnectAttempts + ", negotiatedProtocol=" + this.negotiatedProtocol + ", outboxDepth=" + this.outboxDepth + ", inboxDepth=" + this.inboxDepth + ", lastWriteAtMs=" + this.lastWriteAtMs + ")";
        }

        public ConnectionStatus(boolean z10, Long l10, Long l11, long j10, Integer num, int i10, int i11, Long l12) {
            this.connected = z10;
            this.lastConnectedAtMs = l10;
            this.lastDisconnectAtMs = l11;
            this.reconnectAttempts = j10;
            this.negotiatedProtocol = num;
            this.outboxDepth = i10;
            this.inboxDepth = i11;
            this.lastWriteAtMs = l12;
        }

        public /* synthetic */ ConnectionStatus(boolean z10, Long l10, Long l11, long j10, Integer num, int i10, int i11, Long l12, int i12, i iVar) {
            this((i12 & 1) != 0 ? false : z10, (i12 & 2) != 0 ? null : l10, (i12 & 4) != 0 ? null : l11, (i12 & 8) != 0 ? 0L : j10, (i12 & 16) != 0 ? null : num, (i12 & 32) != 0 ? 0 : i10, (i12 & 64) != 0 ? 0 : i11, (i12 & 128) != 0 ? null : l12);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentbus/generated/AgentBusBindingBase$c;", "", "", "capacity", "<init>", "(I)V", "", "hash", "", Const.INTENT_KEY_APIKEY, "(J)Z", "I", "", Const.INTENT_KEY_PKGNAME, "[J", DidiCardProvider.KEY_ORDER, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "c", "Ljava/util/HashSet;", "seen", Const.INTENT_KEY_UMID, "next", "e", ContentDisposition.Parameters.Size, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int capacity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final long[] order;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final HashSet<Long> seen;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public int next;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public int size;

        public c(int i10) {
            this.capacity = i10;
            this.order = new long[i10];
            this.seen = new HashSet<>(i10 * 2);
        }

        public final boolean a(long hash) {
            if (!this.seen.add(Long.valueOf(hash))) {
                return false;
            }
            int i10 = this.size;
            if (i10 == this.capacity) {
                this.seen.remove(Long.valueOf(this.order[this.next]));
            } else {
                this.size = i10 + 1;
            }
            long[] jArr = this.order;
            int i11 = this.next;
            jArr[i11] = hash;
            this.next = (i11 + 1) % this.capacity;
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AgentBusBindingBase(String socketName, InterfaceC5063a<String> clientIdProvider, String displayName, String version, String role, String reqIdPrefix, long j10, int i10, int i11, p<? super JSONObject, ? super InterfaceC4014c<? super t>, ? extends Object> dispatchEvent, InterfaceC5063a<String> interfaceC5063a, InterfaceC5063a<String> interfaceC5063a2, long j11) {
        kotlin.jvm.internal.p.i(socketName, "socketName");
        kotlin.jvm.internal.p.i(clientIdProvider, "clientIdProvider");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(version, "version");
        kotlin.jvm.internal.p.i(role, "role");
        kotlin.jvm.internal.p.i(reqIdPrefix, "reqIdPrefix");
        kotlin.jvm.internal.p.i(dispatchEvent, "dispatchEvent");
        this.socketName = socketName;
        this.clientIdProvider = clientIdProvider;
        this.displayName = displayName;
        this.version = version;
        this.role = role;
        this.reqIdPrefix = reqIdPrefix;
        this.reconnectDelayMs = j10;
        this.protocolMin = i10;
        this.protocolMax = i11;
        this.dispatchEvent = dispatchEvent;
        this.clientExtra = interfaceC5063a;
        this.connectParamsExtra = interfaceC5063a2;
        this.idleTimeoutMs = j11;
        this.scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
        this.seq = new AtomicLong(0L);
        this.writeMutex = f.b(false, 1, null);
        k<Boolean> kVarA = u.a(Boolean.FALSE);
        this.connectedFlow = kVarA;
        k<ConnectionStatus> kVarA2 = u.a(new ConnectionStatus(false, null, null, 0L, null, 0, 0, null, 255, null));
        this.mutableStatus = kVarA2;
        this.status = kVarA2;
        this.pendingInboxDepth = new AtomicInteger(0);
        this.reconnectAttemptsCounter = new AtomicLong(0L);
        this.reconnectSignal = j.b(-1, null, null, 6, null);
        this.lastActivityMs = System.currentTimeMillis();
        this.pendingResponses = new ConcurrentHashMap<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        RetryHint retryHint = RetryHint.Auto;
        k<com.stepos.agentbus.generated.c> kVarA3 = u.a(new c.Unavailable("agentbus disconnected", jCurrentTimeMillis, retryHint));
        this.mutableServiceHealth = kVarA3;
        k<com.stepos.agentbus.generated.c> kVarA4 = u.a(new c.Available(null, 1, null));
        this.mutableChatHealth = kVarA4;
        k<com.stepos.agentbus.generated.c> kVarA5 = u.a(new c.Available(null, 1, null));
        this.mutableToolsHealth = kVarA5;
        k<com.stepos.agentbus.generated.c> kVarA6 = u.a(new c.Unavailable("agentbus disconnected", System.currentTimeMillis(), retryHint));
        this.mutableUpstreamHealth = kVarA6;
        k<com.stepos.agentbus.generated.c> kVarA7 = u.a(new c.Unavailable("agentbus disconnected", System.currentTimeMillis(), retryHint));
        this.mutableBffHealth = kVarA7;
        k<BffLinkStatus> kVarA8 = u.a(new BffLinkStatus(false, false, 3, null));
        this.mutableBffLinkState = kVarA8;
        this.serviceHealth = kVarA3;
        this.chatHealth = kVarA4;
        this.toolsHealth = kVarA5;
        this.upstreamHealth = kVarA6;
        this.bffHealth = kVarA7;
        this.bffLinkState = kVarA8;
        W();
        this.connected = kVarA;
    }

    public static final ConnectionStatus G(ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.p.i(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.b(mutateStatus, true, Long.valueOf(System.currentTimeMillis()), null, 0L, null, 0, 0, null, 252, null);
    }

    public static final ConnectionStatus H(int i10, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.p.i(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.b(mutateStatus, false, null, null, 0L, Integer.valueOf(i10), 0, 0, null, 239, null);
    }

    public static final ConnectionStatus I(AgentBusBindingBase agentBusBindingBase, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.p.i(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.b(mutateStatus, false, null, null, 0L, null, 0, agentBusBindingBase.pendingInboxDepth.incrementAndGet(), null, 191, null);
    }

    public static final ConnectionStatus J(AgentBusBindingBase agentBusBindingBase, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.p.i(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.b(mutateStatus, false, null, null, 0L, null, 0, C5685n.f(agentBusBindingBase.pendingInboxDepth.decrementAndGet(), 0), null, 191, null);
    }

    public static final ConnectionStatus K(ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.p.i(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.b(mutateStatus, false, null, null, 0L, null, 0, 0, null, 191, null);
    }

    public static final ConnectionStatus c0(ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.p.i(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.b(mutateStatus, false, null, Long.valueOf(System.currentTimeMillis()), 0L, null, 0, 0, null, 250, null);
    }

    public static final ConnectionStatus d0(AgentBusBindingBase agentBusBindingBase, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.p.i(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.b(mutateStatus, false, null, null, agentBusBindingBase.reconnectAttemptsCounter.get(), null, 0, 0, null, 247, null);
    }

    public static final ConnectionStatus m0(AgentBusBindingBase agentBusBindingBase, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.p.i(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.b(mutateStatus, false, null, null, 0L, null, agentBusBindingBase.pendingOutboxDepth, 0, null, 223, null);
    }

    public static final ConnectionStatus n0(AgentBusBindingBase agentBusBindingBase, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.p.i(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.b(mutateStatus, false, null, null, 0L, null, agentBusBindingBase.pendingOutboxDepth, 0, null, 223, null);
    }

    public static final ConnectionStatus o0(ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.p.i(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.b(mutateStatus, false, null, null, 0L, null, 0, 0, Long.valueOf(System.currentTimeMillis()), 127, null);
    }

    public final List<String> A(JSONArray arr) {
        kotlin.jvm.internal.p.i(arr, "arr");
        ArrayList arrayList = new ArrayList(arr.length());
        int length = arr.length();
        for (int i10 = 0; i10 < length; i10++) {
            String strOptString = arr.optString(i10);
            kotlin.jvm.internal.p.f(strOptString);
            if (strOptString.length() > 0) {
                arrayList.add(strOptString);
            }
        }
        return arrayList;
    }

    public final <T> List<T> B(JSONArray arr, InterfaceC5074l<? super JSONObject, ? extends T> parse) {
        kotlin.jvm.internal.p.i(arr, "arr");
        kotlin.jvm.internal.p.i(parse, "parse");
        ArrayList arrayList = new ArrayList(arr.length());
        int length = arr.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObjectOptJSONObject = arr.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(parse.invoke(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(long r5, e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$1 r0 = (com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$1) r0
            int r1 = r0.f22199d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22199d = r1
            goto L18
        L13:
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$1 r0 = new com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f22197b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f22199d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r7)
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$2 r7 = new com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$2
            r2 = 0
            r7.<init>(r4, r2)
            r0.f22196a = r5
            r0.f22199d = r3
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.e(r5, r7, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 == 0) goto L4e
            boolean r4 = r7.booleanValue()
            goto L4f
        L4e:
            r4 = 0
        L4f:
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.C(long, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(java.lang.String r6, long r7, e9.InterfaceC4014c<? super org.json.JSONObject> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$1 r0 = (com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$1) r0
            int r1 = r0.f22209f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22209f = r1
            goto L18
        L13:
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$1 r0 = new com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f22207d
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f22209f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.f22205b
            Ua.u r6 = (Ua.InterfaceC1083u) r6
            java.lang.Object r6 = r0.f22204a
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L32
            goto L62
        L32:
            r7 = move-exception
            goto L72
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.C4849c.b(r9)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, Ua.u<org.json.JSONObject>> r9 = r5.pendingResponses
            java.lang.Object r9 = r9.get(r6)
            Ua.u r9 = (Ua.InterfaceC1083u) r9
            if (r9 != 0) goto L4a
            return r4
        L4a:
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$2 r2 = new com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$2     // Catch: java.lang.Throwable -> L32
            r2.<init>(r9, r4)     // Catch: java.lang.Throwable -> L32
            r0.f22204a = r6     // Catch: java.lang.Throwable -> L32
            java.lang.Object r9 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L32
            r0.f22205b = r9     // Catch: java.lang.Throwable -> L32
            r0.f22206c = r7     // Catch: java.lang.Throwable -> L32
            r0.f22209f = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r9 = kotlinx.coroutines.TimeoutKt.e(r7, r2, r0)     // Catch: java.lang.Throwable -> L32
            if (r9 != r1) goto L62
            return r1
        L62:
            org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch: java.lang.Throwable -> L32
            java.util.concurrent.ConcurrentHashMap<java.lang.String, Ua.u<org.json.JSONObject>> r5 = r5.pendingResponses
            java.lang.Object r5 = r5.remove(r6)
            Ua.u r5 = (Ua.InterfaceC1083u) r5
            if (r5 == 0) goto L71
            kotlinx.coroutines.g.Y0(r5, r4, r3, r4)
        L71:
            return r9
        L72:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, Ua.u<org.json.JSONObject>> r5 = r5.pendingResponses
            java.lang.Object r5 = r5.remove(r6)
            Ua.u r5 = (Ua.InterfaceC1083u) r5
            if (r5 == 0) goto L7f
            kotlinx.coroutines.g.Y0(r5, r4, r3, r4)
        L7f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.D(java.lang.String, long, e9.c):java.lang.Object");
    }

    public final String E() {
        return this.clientIdProvider.invoke();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x00e9: MOVE (r4 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:25:0x00e8 */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x00ea: MOVE (r10 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:25:0x00e8 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x00eb: MOVE (r12 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:25:0x00e8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x0561 -> B:77:0x033f). Please report as a decompilation issue!!! */
    public final java.lang.Object F(e9.InterfaceC4014c<? super java.lang.Boolean> r28) {
        /*
            Method dump skipped, instructions count: 1642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.F(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(org.json.JSONObject r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.L(org.json.JSONObject, e9.c):java.lang.Object");
    }

    public final Xa.t<com.stepos.agentbus.generated.c> M() {
        return this.bffHealth;
    }

    public final Xa.t<Boolean> N() {
        return this.connected;
    }

    public final InterfaceC5074l<ChannelReadyEvent, t> O() {
        return this.onChannelReady;
    }

    public final Xa.t<ConnectionStatus> P() {
        return this.status;
    }

    public final Xa.t<com.stepos.agentbus.generated.c> Q() {
        return this.upstreamHealth;
    }

    public final Map<String, Object> R(Map<String, ? extends Object> params, String frameId) {
        if (params.containsKey("_meta")) {
            return params;
        }
        return kotlin.collections.a.s(params, Y8.j.a("_meta", Q.f(Y8.j.a("trace", kotlin.collections.a.m(Y8.j.a(DidiCardProvider.KEY_TRACE_ID, "tr-" + frameId), Y8.j.a("spanId", "sp-1"))))));
    }

    public final boolean S() {
        return this.connectedFlow.getValue().booleanValue();
    }

    public final String T(String s10) {
        kotlin.jvm.internal.p.i(s10, "s");
        String string = new JSONObject().put("v", s10).toString();
        kotlin.jvm.internal.p.f(string);
        String strSubstring = string.substring(H.t0(string, ':', 0, false, 6, null) + 1, H.A0(string, '}', 0, false, 6, null));
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final Map<String, Object> U(JSONObject obj) {
        kotlin.jvm.internal.p.i(obj, "obj");
        HashMap map = new HashMap(obj.length());
        Iterator<String> itKeys = obj.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, V(obj.opt(next)));
        }
        return map;
    }

    public final Object V(Object v10) {
        if (v10 == null || kotlin.jvm.internal.p.d(v10, JSONObject.NULL)) {
            return null;
        }
        if (v10 instanceof JSONObject) {
            return U((JSONObject) v10);
        }
        if (!(v10 instanceof JSONArray)) {
            return v10;
        }
        JSONArray jSONArray = (JSONArray) v10;
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(V(jSONArray.opt(i10)));
        }
        return arrayList;
    }

    public final void W() {
        C1060i.d(this.scope, null, null, new AgentBusBindingBase$launchHealthObserver$1(this, null), 3, null);
    }

    public final void X(InterfaceC5074l<? super ConnectionStatus, ConnectionStatus> block) {
        k<ConnectionStatus> kVar = this.mutableStatus;
        kVar.setValue(block.invoke(kVar.getValue()));
    }

    public final void Y() {
    }

    public final com.stepos.agentbus.generated.c Z(JSONObject obj) {
        String strOptString = obj.optString("status");
        long jOptLong = obj.optLong("sinceMs", System.currentTimeMillis());
        String strOptString2 = obj.optString("reason");
        if (strOptString2.length() == 0) {
            strOptString2 = "";
        }
        String strOptString3 = obj.optString("retryHint", "auto");
        RetryHint retryHint = kotlin.jvm.internal.p.d(strOptString3, "user_action") ? RetryHint.UserAction : kotlin.jvm.internal.p.d(strOptString3, "permanent") ? RetryHint.Permanent : RetryHint.Auto;
        if (kotlin.jvm.internal.p.d(strOptString, "available")) {
            kotlin.jvm.internal.p.f(strOptString2);
            if (strOptString2.length() <= 0) {
                strOptString2 = null;
            }
            return new c.Available(strOptString2);
        }
        if (kotlin.jvm.internal.p.d(strOptString, "degraded")) {
            kotlin.jvm.internal.p.f(strOptString2);
            return new c.Degraded(strOptString2, jOptLong);
        }
        kotlin.jvm.internal.p.f(strOptString2);
        return new c.Unavailable(strOptString2, jOptLong, retryHint);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a0(java.lang.String r6, java.util.Map<java.lang.String, ? extends java.lang.Object> r7, long r8, e9.InterfaceC4014c<? super a4.InvokeResult> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.a0(java.lang.String, java.util.Map, long, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0175, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0170 -> B:53:0x0171). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b0(e9.InterfaceC4014c<? super Y8.t> r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.b0(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e0(java.lang.String r10, java.util.Map<java.lang.String, ? extends java.lang.Object> r11, e9.InterfaceC4014c<? super java.lang.String> r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.stepos.agentbus.generated.AgentBusBindingBase$sendEvent$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.agentbus.generated.AgentBusBindingBase$sendEvent$1 r0 = (com.stepos.agentbus.generated.AgentBusBindingBase$sendEvent$1) r0
            int r1 = r0.f22292h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22292h = r1
            goto L18
        L13:
            com.stepos.agentbus.generated.AgentBusBindingBase$sendEvent$1 r0 = new com.stepos.agentbus.generated.AgentBusBindingBase$sendEvent$1
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.f22290f
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f22292h
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r9 = r0.f22289e
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.f22288d
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r9 = r0.f22287c
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.f22286b
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r10 = r0.f22285a
            java.lang.String r10 = (java.lang.String) r10
            kotlin.C4849c.b(r12)
            return r9
        L3d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L45:
            kotlin.C4849c.b(r12)
            java.util.concurrent.atomic.AtomicLong r12 = r9.seq
            long r4 = r12.incrementAndGet()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r2 = "evt-"
            r12.append(r2)
            r12.append(r4)
            java.lang.String r12 = r12.toString()
            java.util.Map r2 = r9.R(r11, r12)
            java.lang.String r4 = r9.T(r12)
            java.lang.String r5 = r9.T(r10)
            java.lang.String r6 = r9.i0(r2)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "{\"type\":\"event\",\"id\":"
            r7.append(r8)
            r7.append(r4)
            java.lang.String r4 = ",\"event\":"
            r7.append(r4)
            r7.append(r5)
            java.lang.String r4 = ",\"payload\":"
            r7.append(r4)
            r7.append(r6)
            java.lang.String r4 = "}"
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            java.lang.Object r10 = g9.h.a(r10)
            r0.f22285a = r10
            java.lang.Object r10 = g9.h.a(r11)
            r0.f22286b = r10
            r0.f22287c = r12
            java.lang.Object r10 = g9.h.a(r2)
            r0.f22288d = r10
            java.lang.Object r10 = g9.h.a(r4)
            r0.f22289e = r10
            r0.f22292h = r3
            java.lang.Object r9 = r9.l0(r4, r0)
            if (r9 != r1) goto Lb8
            return r1
        Lb8:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.e0(java.lang.String, java.util.Map, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f0(java.lang.String r11, java.util.Map<java.lang.String, ? extends java.lang.Object> r12, e9.InterfaceC4014c<? super java.lang.String> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stepos.agentbus.generated.AgentBusBindingBase$sendReq$1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.agentbus.generated.AgentBusBindingBase$sendReq$1 r0 = (com.stepos.agentbus.generated.AgentBusBindingBase$sendReq$1) r0
            int r1 = r0.f22301i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22301i = r1
            goto L18
        L13:
            com.stepos.agentbus.generated.AgentBusBindingBase$sendReq$1 r0 = new com.stepos.agentbus.generated.AgentBusBindingBase$sendReq$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f22299g
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f22301i
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r10 = r0.f22298f
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.f22297e
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r10 = r0.f22296d
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r0.f22295c
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r0.f22294b
            java.util.Map r11 = (java.util.Map) r11
            java.lang.Object r11 = r0.f22293a
            java.lang.String r11 = (java.lang.String) r11
            kotlin.C4849c.b(r13)
            return r10
        L41:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L49:
            kotlin.C4849c.b(r13)
            java.util.UUID r13 = java.util.UUID.randomUUID()
            java.lang.String r13 = r13.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.p.h(r13, r2)
            r2 = 16
            java.lang.String r13 = La.K.R1(r13, r2)
            java.lang.String r2 = r10.reqIdPrefix
            java.util.concurrent.atomic.AtomicLong r4 = r10.seq
            long r4 = r4.incrementAndGet()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r13)
            java.lang.String r2 = "-"
            r6.append(r2)
            r6.append(r4)
            java.lang.String r2 = r6.toString()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, Ua.u<org.json.JSONObject>> r4 = r10.pendingResponses
            r5 = 0
            Ua.u r5 = Ua.C1087w.c(r5, r3, r5)
            r4.put(r2, r5)
            java.util.Map r4 = r10.R(r12, r2)
            java.lang.String r5 = r10.T(r2)
            java.lang.String r6 = r10.T(r11)
            java.lang.String r7 = r10.i0(r4)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "{\"type\":\"req\",\"id\":"
            r8.append(r9)
            r8.append(r5)
            java.lang.String r5 = ",\"method\":"
            r8.append(r5)
            r8.append(r6)
            java.lang.String r5 = ",\"params\":"
            r8.append(r5)
            r8.append(r7)
            java.lang.String r5 = "}"
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            java.lang.Object r11 = g9.h.a(r11)
            r0.f22293a = r11
            java.lang.Object r11 = g9.h.a(r12)
            r0.f22294b = r11
            java.lang.Object r11 = g9.h.a(r13)
            r0.f22295c = r11
            r0.f22296d = r2
            java.lang.Object r11 = g9.h.a(r4)
            r0.f22297e = r11
            java.lang.Object r11 = g9.h.a(r5)
            r0.f22298f = r11
            r0.f22301i = r3
            java.lang.Object r10 = r10.l0(r5, r0)
            if (r10 != r1) goto Le7
            return r1
        Le7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.f0(java.lang.String, java.util.Map, e9.c):java.lang.Object");
    }

    public final void g0() {
        g gVar = this.serveJob;
        if (gVar == null || !gVar.b()) {
            g gVar2 = this.serveJob;
            if (gVar2 != null && gVar2.g()) {
                this.serveJob = null;
            }
            g gVar3 = (g) this.scope.getCoroutineContext().get(g.INSTANCE);
            if (gVar3 == null || !gVar3.b()) {
                this.scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
                W();
            }
            this.serveJob = C1060i.d(this.scope, null, null, new AgentBusBindingBase$start$1(this, null), 3, null);
        }
    }

    public final void h0() {
        g gVar = this.serveJob;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        this.serveJob = null;
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
    }

    public final String i0(Map<String, ? extends Object> map) {
        kotlin.jvm.internal.p.i(map, "map");
        return j0(map).toString();
    }

    public final Object j0(Object v10) throws JSONException {
        if (v10 == null) {
            Object NULL = JSONObject.NULL;
            kotlin.jvm.internal.p.h(NULL, "NULL");
            return NULL;
        }
        if (v10 instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) v10).entrySet()) {
                jSONObject.put(String.valueOf(entry.getKey()), j0(entry.getValue()));
            }
            return jSONObject;
        }
        if (v10 instanceof List) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((List) v10).iterator();
            while (it.hasNext()) {
                jSONArray.put(j0(it.next()));
            }
            return jSONArray;
        }
        if (!(v10 instanceof Object[])) {
            if (!(v10 instanceof Set)) {
                return v10;
            }
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = ((Set) v10).iterator();
            while (it2.hasNext()) {
                jSONArray2.put(j0(it2.next()));
            }
            return jSONArray2;
        }
        JSONArray jSONArray3 = new JSONArray();
        for (Object obj : (Object[]) v10) {
            jSONArray3.put(j0(obj));
        }
        return jSONArray3;
    }

    public final void k0() {
        this.lastActivityMs = System.currentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l0(java.lang.String r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.l0(java.lang.String, e9.c):java.lang.Object");
    }

    public final Object p0(String str, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objL0 = l0(str, interfaceC4014c);
        return objL0 == C4063a.g() ? objL0 : t.f7040a;
    }

    public final String y() {
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        String strR1 = K.R1(string, 16);
        String str = this.reqIdPrefix + strR1 + l.DATE_SEPARATOR + this.seq.incrementAndGet();
        this.pendingResponses.put(str, C1087w.c(null, 1, null));
        return str;
    }

    public final void z(JSONObject payload) {
        JSONObject jSONObjectOptJSONObject;
        if (payload == null || (jSONObjectOptJSONObject = payload.optJSONObject("resources")) == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("service");
        if (jSONObjectOptJSONObject2 != null) {
            this.mutableServiceHealth.setValue(Z(jSONObjectOptJSONObject2));
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(AbilityType.CHAT);
        if (jSONObjectOptJSONObject3 != null) {
            this.mutableChatHealth.setValue(Z(jSONObjectOptJSONObject3));
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("tools");
        if (jSONObjectOptJSONObject4 != null) {
            this.mutableToolsHealth.setValue(Z(jSONObjectOptJSONObject4));
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("upstream");
        if (jSONObjectOptJSONObject5 != null) {
            this.mutableUpstreamHealth.setValue(Z(jSONObjectOptJSONObject5));
        }
        JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject.optJSONObject("bff");
        if (jSONObjectOptJSONObject6 != null) {
            this.mutableBffHealth.setValue(Z(jSONObjectOptJSONObject6));
            this.mutableBffLinkState.setValue(new BffLinkStatus(jSONObjectOptJSONObject6.optBoolean("wsConnected", false), jSONObjectOptJSONObject6.optBoolean("authed", false)));
        }
    }

    public /* synthetic */ AgentBusBindingBase(String str, InterfaceC5063a interfaceC5063a, String str2, String str3, String str4, String str5, long j10, int i10, int i11, p pVar, InterfaceC5063a interfaceC5063a2, InterfaceC5063a interfaceC5063a3, long j11, int i12, i iVar) {
        this(str, interfaceC5063a, str2, str3, str4, (i12 & 32) != 0 ? "as-" : str5, (i12 & 64) != 0 ? 1000L : j10, (i12 & 128) != 0 ? 3 : i10, (i12 & 256) != 0 ? 3 : i11, pVar, (i12 & 1024) != 0 ? null : interfaceC5063a2, (i12 & 2048) != 0 ? null : interfaceC5063a3, (i12 & 4096) != 0 ? 0L : j11);
    }
}
