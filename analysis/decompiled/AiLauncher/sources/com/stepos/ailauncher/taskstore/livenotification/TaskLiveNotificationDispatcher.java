package com.stepos.ailauncher.taskstore.livenotification;

import Ua.C1060i;
import Ua.L0;
import Z8.C1173v;
import Z8.C1174w;
import Z8.X;
import Z8.Y;
import android.content.Context;
import android.os.Trace;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.C1935i0;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.agentframework.chatcore.session.list.SessionChatActivitySnapshot;
import com.stepos.agentframework.chatcore.session.list.SessionChatPhase;
import com.stepos.agentframework.chatcore.session.list.SessionListItem;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.C2706l;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.chat.wake.C3172w;
import com.stepos.ailauncher.common.utils.NetworkPhase;
import com.stepos.ailauncher.common.utils.NetworkStateMonitor;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.database.TaskStoreDatabase;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import t6.C5517e;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u001e\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\rH\u0082@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@¢\u0006\u0004\b \u0010\u001fJ*\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0!2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@¢\u0006\u0004\b#\u0010$J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@¢\u0006\u0004\b%\u0010\u001fJ\u0017\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b&\u0010\u0007J\u0017\u0010'\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b'\u0010(J!\u0010+\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b-\u0010,J+\u00100\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0!H\u0002¢\u0006\u0004\b0\u00101J3\u00104\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0!2\u0006\u00103\u001a\u00020)H\u0002¢\u0006\u0004\b4\u00105J\u001b\u00107\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b7\u0010\nJ\u0017\u00108\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b8\u00109J\u0019\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u001d\u0010>\u001a\u00020\u00102\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b>\u0010?J\u001d\u0010A\u001a\u00020\u00102\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\bA\u0010?J\u001f\u0010D\u001a\u00020)2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0010H\u0002¢\u0006\u0004\bH\u0010\u0003J\u0017\u0010I\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\bI\u0010(J\u0017\u0010J\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\bJ\u00109J\u0017\u0010K\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\bK\u00109J#\u0010L\u001a\u00020\u00102\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0!H\u0002¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\u00020.2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010N\u001a\u00020.H\u0002¢\u0006\u0004\bO\u0010PJ/\u0010T\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020.2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020)H\u0002¢\u0006\u0004\bT\u0010UJ\u001b\u0010W\u001a\u00020Q*\u00020.2\u0006\u0010V\u001a\u00020QH\u0002¢\u0006\u0004\bW\u0010XJ-\u0010[\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010Z\u001a\u00020)H\u0002¢\u0006\u0004\b[\u0010\\J-\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\u0010H\u0002¢\u0006\u0004\b_\u0010\u0003J\u0017\u0010`\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b`\u00109J\u000f\u0010a\u001a\u00020\u0010H\u0002¢\u0006\u0004\ba\u0010\u0003J'\u0010b\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\bb\u0010cJ)\u0010f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u0005H\u0002¢\u0006\u0004\bf\u0010gJ!\u0010j\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u00052\b\u0010i\u001a\u0004\u0018\u00010hH\u0002¢\u0006\u0004\bj\u0010kJ-\u0010m\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bm\u0010nJ\u001d\u0010o\u001a\u00020)2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\bo\u0010pJ\u001d\u0010r\u001a\u00020\u00102\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\br\u0010\u0015J\u0015\u0010s\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002¢\u0006\u0004\bs\u0010\nJ\u0015\u0010u\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\u000b¢\u0006\u0004\bu\u0010(J-\u0010w\u001a\u0004\u0018\u00010\u00052\u0006\u0010t\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bw\u0010xJ\u0017\u0010y\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0004\by\u00109J#\u0010{\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\u000b2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050z¢\u0006\u0004\b{\u0010|J#\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050zH\u0000¢\u0006\u0004\b}\u0010~J\u0015\u0010\u007f\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u007f\u00109J \u0010\u0080\u0001\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020\u0005¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J \u0010\u0082\u0001\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020\u0005¢\u0006\u0006\b\u0082\u0001\u0010\u0081\u0001J\u000f\u0010\u0083\u0001\u001a\u00020\u0010¢\u0006\u0005\b\u0083\u0001\u0010\u0003J\u000f\u0010\u0084\u0001\u001a\u00020\u0010¢\u0006\u0005\b\u0084\u0001\u0010\u0003J\u000f\u0010\u0085\u0001\u001a\u00020\u0010¢\u0006\u0005\b\u0085\u0001\u0010\u0003J \u0010\u0086\u0001\u001a\u00020)2\u0006\u0010t\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J8\u0010\u008a\u0001\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u00052\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0005¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J8\u0010\u008c\u0001\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u00052\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0005¢\u0006\u0006\b\u008c\u0001\u0010\u008b\u0001J#\u0010\u008e\u0001\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0005¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J-\u0010\u0090\u0001\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0005¢\u0006\u0005\b\u0090\u0001\u0010nR\u0017\u0010\u0091\u0001\u001a\u00020\u00058\u0002X\u0082T¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R$\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020h0\u00048\u0000X\u0080\u0004¢\u0006\u000f\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0005\b\u0095\u0001\u0010\u0007R\u0017\u0010\u0096\u0001\u001a\u00020:8\u0002X\u0082T¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0017\u0010\u0098\u0001\u001a\u00020:8\u0002X\u0082T¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0097\u0001R\u001d\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020h0\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0094\u0001R\u001d\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u0094\u0001R\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010\u009f\u0001R\u001c\u0010¡\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010\u009f\u0001R\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010\u009f\u0001R\u0019\u0010£\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u008a\u0001R\u0019\u0010¤\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010\u008a\u0001R\u0019\u0010¥\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010\u008a\u0001R\u0019\u0010¦\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010\u008a\u0001R5\u0010©\u0001\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0§\u0001j\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.`¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R)\u0010\u00ad\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000e0«\u0001j\t\u0012\u0004\u0012\u00020\u000e`¬\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R)\u0010±\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00050¯\u0001j\t\u0012\u0004\u0012\u00020\u0005`°\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001f\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R'\u0010µ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u001f\u0010·\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010\u0094\u0001R\u001f\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010\u0094\u0001R%\u0010¹\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010¶\u0001R5\u0010º\u0001\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050§\u0001j\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010ª\u0001R5\u0010»\u0001\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020:0§\u0001j\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020:`¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010ª\u0001R5\u0010¼\u0001\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050§\u0001j\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010ª\u0001R5\u0010½\u0001\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020Q0§\u0001j\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020Q`¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010ª\u0001R)\u0010¾\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00050¯\u0001j\t\u0012\u0004\u0012\u00020\u0005`°\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010²\u0001R7\u0010À\u0001\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030¿\u00010§\u0001j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030¿\u0001`¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010ª\u0001R7\u0010Á\u0001\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u009d\u00010§\u0001j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u009d\u0001`¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010ª\u0001R7\u0010Â\u0001\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u009d\u00010§\u0001j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u009d\u0001`¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010ª\u0001R\u001f\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010\u0094\u0001¨\u0006Ä\u0001"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/TaskLiveNotificationDispatcher;", "", "<init>", "()V", "", "", "i0", "()Ljava/util/Set;", "sessionId", "J0", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "appContext", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "roots", "LY8/t;", "c0", "(Landroid/content/Context;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "cards", "X0", "(Ljava/util/List;)V", "LUa/M;", "s", "s0", "(Landroid/content/Context;LUa/M;)V", "w0", "t0", "u0", "Lcom/stepos/agentframework/chatcore/session/list/b;", "o0", "(Le9/c;)Ljava/lang/Object;", "m0", "", "Lcom/stepos/ailauncher/taskstore/livenotification/q;", "n0", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "l0", "j0", "W0", "(Landroid/content/Context;)V", "", "reuseAggregate", "M0", "(Landroid/content/Context;Z)V", "O0", "Lcom/stepos/ailauncher/taskstore/livenotification/r;", "cached", "R", "(Landroid/content/Context;Ljava/util/Map;)V", "states", "handleRemoved", "Q", "(Landroid/content/Context;Ljava/util/Map;Z)V", "explicit", "T0", "b1", "(Ljava/lang/String;)Z", "", "P", "(Ljava/lang/String;)Ljava/lang/Long;", "sessionIds", "X", "(Ljava/util/Set;)V", AlipayXuiIsland.REASON_ENDED, ExifInterface.LONGITUDE_WEST, "left", "right", "V0", "(Ljava/lang/String;Ljava/lang/String;)Z", "p0", "(Ljava/lang/String;)V", "g1", ExifInterface.GPS_DIRECTION_TRUE, "e0", "g0", "f1", "(Ljava/util/Map;)V", VoiceWakeupReceiver.EXTRA_STATE, "j1", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/livenotification/r;)Lcom/stepos/ailauncher/taskstore/livenotification/r;", "Lcom/stepos/ailauncher/common/utils/NetworkPhase;", "networkPhase", "isInitial", "L0", "(Landroid/content/Context;Lcom/stepos/ailauncher/taskstore/livenotification/r;Lcom/stepos/ailauncher/common/utils/NetworkPhase;Z)V", "current", "a0", "(Lcom/stepos/ailauncher/taskstore/livenotification/r;Lcom/stepos/ailauncher/common/utils/NetworkPhase;)Lcom/stepos/ailauncher/common/utils/NetworkPhase;", "ids", "markDismissed", "U", "(Landroid/content/Context;Ljava/util/Set;Z)V", "r0", "(Ljava/util/Set;Ljava/util/Set;)Ljava/util/Set;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "d1", "K0", ExifInterface.LATITUDE_SOUTH, "(LUa/M;Landroid/content/Context;Ljava/lang/String;)V", "phaseName", "source", "R0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "phase", "h0", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;)Z", "taskId", "H0", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "i1", "(Ljava/util/Set;)Z", "persistCards", "G0", "h1", "context", "f0", "liveId", "e1", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "F0", "", "C0", "(Landroid/content/Context;Ljava/util/Collection;)V", "b0", "(Ljava/util/Collection;)Ljava/util/Set;", SdCardDbCreator.FIELD_LASTLOC_ID, "D0", "(Landroid/content/Context;Ljava/lang/String;)V", "E0", "S0", "B0", "y0", "z0", "(Landroid/content/Context;Ljava/lang/String;)Z", "aliasSessionId", "requestId", "Z", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "A0", "status", "q0", "(Ljava/lang/String;Ljava/lang/String;)V", "x0", "TAG", "Ljava/lang/String;", "INITIAL_SKIP_PHASES", "Ljava/util/Set;", "getINITIAL_SKIP_PHASES$taskstore_release", "RISK_AFTERGLOW_WINDOW_MS", "J", "RISK_TRANSITION_DELAY_MS", "TERMINAL_PHASES", "EXCLUDED_TASK_TYPES", "scope", "LUa/M;", "Lkotlinx/coroutines/g;", "observeJob", "Lkotlinx/coroutines/g;", "chatJob", "networkJob", "foregroundJob", "suppressingIslandPush", "foregroundRecomputePosted", "recomputing", "pendingFullRecompute", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "lastStates", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastCards", "Ljava/util/ArrayList;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "askUserCardSyncInFlight", "Ljava/util/HashSet;", "lastSessions", "Ljava/util/List;", "lastAggregatedStates", "Ljava/util/Map;", "lastContentSessionIds", "lastArtifactSessionIds", "lastPersistedChat", "dismissedSessions", "alipayOwnedSessions", "alipayLiveToChat", "lastNetworkPhases", "afterTakeoverSessions", "Lcom/stepos/ailauncher/taskstore/livenotification/n;", "riskAfterglows", "riskAfterglowJobs", "riskTransitionJobs", "cancelledIslandKeys", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher {
    private static final Set<String> EXCLUDED_TASK_TYPES;
    private static final Set<SessionActivityState> INITIAL_SKIP_PHASES;
    public static final TaskLiveNotificationDispatcher INSTANCE = new TaskLiveNotificationDispatcher();
    private static final long RISK_AFTERGLOW_WINDOW_MS = 30000;
    private static final long RISK_TRANSITION_DELAY_MS = 2000;
    private static final String TAG = "TaskLiveNotificationDispatcher";
    private static final Set<SessionActivityState> TERMINAL_PHASES;
    private static final HashSet<String> afterTakeoverSessions;
    private static final HashMap<String, String> alipayLiveToChat;
    private static final HashMap<String, Long> alipayOwnedSessions;
    private static final HashSet<String> askUserCardSyncInFlight;
    private static Set<String> cancelledIslandKeys;
    private static volatile kotlinx.coroutines.g chatJob;
    private static final HashMap<String, String> dismissedSessions;
    private static volatile kotlinx.coroutines.g foregroundJob;
    private static volatile boolean foregroundRecomputePosted;
    private static Map<String, SessionLiveState> lastAggregatedStates;
    private static Set<String> lastArtifactSessionIds;
    private static final ArrayList<TaskInfoCard> lastCards;
    private static Set<String> lastContentSessionIds;
    private static final HashMap<String, NetworkPhase> lastNetworkPhases;
    private static Map<String, SessionChatActivity> lastPersistedChat;
    private static List<SessionListItem> lastSessions;
    private static final HashMap<String, SessionLiveState> lastStates;
    private static volatile kotlinx.coroutines.g networkJob;
    private static volatile kotlinx.coroutines.g observeJob;
    private static boolean pendingFullRecompute;
    private static boolean recomputing;
    private static final HashMap<String, kotlinx.coroutines.g> riskAfterglowJobs;
    private static final HashMap<String, RiskAfterglow> riskAfterglows;
    private static final HashMap<String, kotlinx.coroutines.g> riskTransitionJobs;
    private static volatile Ua.M scope;
    private static volatile boolean suppressingIslandPush;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SessionActivityState.values().length];
            try {
                iArr[SessionActivityState.WAITING_FOR_USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionActivityState.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        SessionActivityState sessionActivityState = SessionActivityState.FAILED;
        SessionActivityState sessionActivityState2 = SessionActivityState.COMPLETED_UNREAD;
        INITIAL_SKIP_PHASES = Y.j(sessionActivityState, sessionActivityState2);
        TERMINAL_PHASES = Y.j(sessionActivityState2, sessionActivityState);
        EXCLUDED_TASK_TYPES = Y.j(C5517e.RECORDER_TASK_TYPE, C5517e.VOICE_SUMMARY_TASK_TYPE, C5517e.VOICE_ALWAYS_ON_TASK_TYPE, O5.c.ALIPAY_XUI);
        lastStates = new HashMap<>();
        lastCards = new ArrayList<>();
        askUserCardSyncInFlight = new HashSet<>();
        lastSessions = C1173v.m();
        lastContentSessionIds = Y.e();
        lastArtifactSessionIds = Y.e();
        lastPersistedChat = kotlin.collections.a.i();
        dismissedSessions = new HashMap<>();
        alipayOwnedSessions = new HashMap<>();
        alipayLiveToChat = new HashMap<>();
        lastNetworkPhases = new HashMap<>();
        afterTakeoverSessions = new HashSet<>();
        riskAfterglows = new HashMap<>();
        riskAfterglowJobs = new HashMap<>();
        riskTransitionJobs = new HashMap<>();
        cancelledIslandKeys = Y.e();
    }

    public static /* synthetic */ void I0(TaskLiveNotificationDispatcher taskLiveNotificationDispatcher, Context context, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        taskLiveNotificationDispatcher.H0(context, str, str2);
    }

    public static /* synthetic */ void N0(TaskLiveNotificationDispatcher taskLiveNotificationDispatcher, Context context, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        taskLiveNotificationDispatcher.M0(context, z10);
    }

    public static final CharSequence P0(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        return card.getTaskId() + ServerSentEventKt.COLON + A6.c.INSTANCE.c(card) + ServerSentEventKt.COLON + card.getStatus() + ServerSentEventKt.COLON + card.getUpdatedAt();
    }

    public static final CharSequence Q0(Map.Entry entry) {
        kotlin.jvm.internal.p.i(entry, "<destruct>");
        String str = (String) entry.getKey();
        SessionLiveState sessionLiveState = (SessionLiveState) entry.getValue();
        return str + "=" + sessionLiveState.getCategory() + "/" + sessionLiveState.getPhase() + ":updatedAt=" + sessionLiveState.getUpdatedAt() + ":title='" + sessionLiveState.getTitle() + "'";
    }

    public static final boolean U0(Map.Entry entry) {
        kotlin.jvm.internal.p.i(entry, "<destruct>");
        return !La.H.x0((String) entry.getKey()) && ((SessionChatActivitySnapshot) entry.getValue()).getPhase() == SessionChatPhase.REPLYING;
    }

    public static final boolean Y(String str, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return C3723k.INSTANCE.f(it, str) || INSTANCE.V0(it, str);
    }

    public static final String Y0(List<TaskInfoCard> list) {
        return Z8.F.A0(list, null, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.H
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskLiveNotificationDispatcher.Z0((TaskInfoCard) obj);
            }
        }, 31, null);
    }

    public static final CharSequence Z0(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        return card.getTaskId() + ServerSentEventKt.COLON + card.getStatus() + ":dismissed=" + card.getNotificationDismissedStatus() + ":updatedAt=" + card.getUpdatedAt();
    }

    public static final boolean c1(String str, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return C3723k.INSTANCE.f(it, str) || INSTANCE.V0(it, str);
    }

    public static final CharSequence d0(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        return "taskId=" + card.getTaskId() + " sessionKey=" + A6.c.INSTANCE.c(card) + " status=" + card.getStatus() + " updatedAt=" + card.getUpdatedAt();
    }

    public static final boolean k0(SessionHandler sessionHandler, String id) {
        SessionHandler sessionHandlerE;
        kotlin.jvm.internal.p.i(id, "id");
        return (sessionHandler != null && sessionHandler.i2(id)) || ((sessionHandlerE = C2706l.INSTANCE.a().e(id)) != null && sessionHandlerE.i2(id));
    }

    public static final void v0(String str, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        INSTANCE.y0();
    }

    public final void A0(Context context, String sessionId, String aliasSessionId, String requestId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(aliasSessionId, "aliasSessionId");
        Context applicationContext = context.getApplicationContext();
        Ua.M m10 = scope;
        if (m10 == null) {
            x.INSTANCE.m(new String[]{sessionId, aliasSessionId}, requestId);
            Log.w(TAG, "onRiskDismissed: dispatcher not started, risk removed without transition delay sessionId=" + sessionId);
            return;
        }
        boolean zG = x.INSTANCE.g(sessionId, aliasSessionId);
        HashMap<String, kotlinx.coroutines.g> map = riskTransitionJobs;
        kotlinx.coroutines.g gVarRemove = map.remove(sessionId);
        if (gVarRemove != null) {
            kotlinx.coroutines.g.Y0(gVarRemove, null, 1, null);
        }
        map.put(sessionId, C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$onRiskDismissed$1(zG, sessionId, m10, applicationContext, aliasSessionId, requestId, null), 3, null));
        Log.i(TAG, "risk transition scheduled sessionId=" + sessionId + " delay=2000ms");
    }

    public final void B0() {
        Ua.M m10 = scope;
        if (m10 == null) {
            return;
        }
        C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$onSessionSummaryUpdated$1(null), 3, null);
    }

    public final void C0(Context context, Collection<String> sessionIds) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        Collection<String> collection = sessionIds;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(La.H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listG0 = Z8.F.g0(arrayList2);
        if (listG0.isEmpty()) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Ua.M m10 = scope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$onSessionsForgotten$1(listG0, applicationContext, null), 3, null);
            return;
        }
        Set<String> setB0 = b0(listG0);
        kotlin.jvm.internal.p.f(applicationContext);
        U(applicationContext, setB0, false);
        Log.d(TAG, "onSessionsForgotten: dispatcher not started, cancelled directly ids=" + setB0);
    }

    public final void D0(Context context, String taskId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Ua.M m10 = scope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$onTaskCardGone$1(context.getApplicationContext(), taskId, null), 3, null);
            return;
        }
        Log.d(TAG, "onTaskCardGone ignored: dispatcher not started taskId=" + taskId);
    }

    public final void E0(Context context, String taskId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Ua.M m10 = scope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$onTaskDismissedByServer$1(taskId, context.getApplicationContext(), null), 3, null);
            return;
        }
        Log.d(TAG, "onTaskDismissedByServer ignored: dispatcher not started taskId=" + taskId);
    }

    public final boolean F0(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return b1(sessionId);
    }

    public final void G0(List<TaskInfoCard> persistCards) {
        Ua.M m10 = scope;
        if (m10 == null) {
            return;
        }
        C1060i.d(m10, Ua.Y.b(), null, new TaskLiveNotificationDispatcher$persistFailedDismissedCards$1(persistCards, null), 2, null);
    }

    public final void H0(Context appContext, String sessionId, String taskId) {
        Ua.M m10 = scope;
        if (m10 == null) {
            return;
        }
        C1060i.d(m10, Ua.Y.c().getImmediate(), null, new TaskLiveNotificationDispatcher$persistFailedSessionViewed$1(taskId, sessionId, appContext, null), 2, null);
    }

    public final String J0(String sessionId) {
        Object next;
        HashMap<String, SessionLiveState> map = lastStates;
        if (map.containsKey(sessionId)) {
            return sessionId;
        }
        Set<String> setKeySet = map.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        Iterator<T> it = setKeySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String str = (String) next;
            C3723k c3723k = C3723k.INSTANCE;
            kotlin.jvm.internal.p.f(str);
            if (c3723k.f(str, sessionId)) {
                break;
            }
        }
        return (String) next;
    }

    public final void K0() {
        Set<String> setKeySet = riskAfterglows.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (d1((String) obj)) {
                arrayList.add(obj);
            }
        }
        for (String str : arrayList) {
            riskAfterglows.remove(str);
            kotlinx.coroutines.g gVarRemove = riskAfterglowJobs.remove(str);
            if (gVarRemove != null) {
                kotlinx.coroutines.g.Y0(gVarRemove, null, 1, null);
            }
            Log.d(TAG, "risk afterglow pruned sessionId=" + str);
        }
    }

    public final void L0(Context appContext, SessionLiveState state, NetworkPhase networkPhase, boolean isInitial) {
        Object objB;
        Log.i(TAG, "push_attempt sessionId=" + state.getSessionId() + " category=" + state.getCategory() + " phase=" + state.getPhase() + " isInitial=" + isInitial + " networkPhase=" + networkPhase + " title='" + state.getTitle() + "' dynamic='" + state.getDynamicText() + "' updatedAt=" + state.getUpdatedAt());
        try {
            Result.Companion companion = Result.INSTANCE;
            A.INSTANCE.k(appContext, state, networkPhase);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            Log.i(TAG, "push_success sessionId=" + state.getSessionId() + " category=" + state.getCategory() + " phase=" + state.getPhase() + " updatedAt=" + state.getUpdatedAt());
            lastStates.put(state.getSessionId(), state);
            lastNetworkPhases.put(state.getSessionId(), networkPhase);
            dismissedSessions.remove(state.getSessionId());
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "showSessionCard failed sessionId=" + state.getSessionId(), thE);
        }
    }

    public final void M0(Context appContext, boolean reuseAggregate) {
        if (recomputing) {
            pendingFullRecompute = true;
            return;
        }
        recomputing = true;
        while (true) {
            try {
                pendingFullRecompute = false;
                O0(appContext, reuseAggregate);
                if (!pendingFullRecompute) {
                    return;
                } else {
                    reuseAggregate = false;
                }
            } finally {
                recomputing = false;
            }
        }
    }

    public final void O0(Context appContext, boolean reuseAggregate) {
        Trace.beginSection("TaskLiveNotif.recompute");
        try {
            boolean z10 = suppressingIslandPush;
            String str = TAG;
            if (z10) {
                Log.d(TAG, "skip recompute: island cancel in progress");
                return;
            }
            if (reuseAggregate) {
                Map<String, SessionLiveState> map = lastAggregatedStates;
                if (map != null) {
                    R(appContext, map);
                    return;
                }
                T(appContext);
                Ua.M m10 = scope;
                if (m10 == null) {
                    return;
                }
                C1060i.d(m10, Ua.Y.c(), null, new TaskLiveNotificationDispatcher$recomputeUnlocked$1(appContext, null), 2, null);
                return;
            }
            K0();
            g1();
            ArrayList<TaskInfoCard> arrayList = lastCards;
            TaskStoreModule taskStoreModule = TaskStoreModule.INSTANCE;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (!taskStoreModule.z((TaskInfoCard) obj)) {
                    arrayList2.add(obj);
                }
            }
            Set<String> setI0 = i0();
            Map<String, SessionChatActivity> mapB = N.b(SessionActivityTracker.INSTANCE.e().getValue(), setI0, N.h(arrayList2));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, SessionChatActivity> entry : mapB.entrySet()) {
                if (!TaskStoreModule.INSTANCE.w(entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map<String, SessionChatActivity> mapD = N.d(linkedHashMap, lastPersistedChat);
            Set<String> setJ0 = j0();
            String strA0 = Z8.F.A0(arrayList2, null, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.C
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return TaskLiveNotificationDispatcher.P0((TaskInfoCard) obj2);
                }
            }, 31, null);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(Z8.Q.e(mapD.size()));
            for (Object obj2 : mapD.entrySet()) {
                Object key = ((Map.Entry) obj2).getKey();
                SessionChatActivity sessionChatActivity = (SessionChatActivity) ((Map.Entry) obj2).getValue();
                linkedHashMap2.put(key, sessionChatActivity.getPhase() + ServerSentEventKt.COLON + sessionChatActivity.getUpdatedAt() + ":user=" + sessionChatActivity.getLastUserMessageAt());
                str = str;
            }
            String str2 = str;
            com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
            Log.i(str2, "aggregate inputs cards=" + strA0 + " chat=" + linkedHashMap2 + " active=" + setJ0 + " liveStateIds=" + setI0 + " fgKeys=" + vVar.g().getValue() + " pageFg=" + vVar.d().getValue() + " bodyFg=" + vVar.j());
            Map<String, SessionLiveState> mapC = C3732u.INSTANCE.c(arrayList2, lastSessions, mapD, y.INSTANCE.c(), lastContentSessionIds, lastArtifactSessionIds, x.q(x.INSTANCE, 0L, 1, null), riskAfterglows, setJ0);
            Set setB = X.b();
            setB.addAll(setI0);
            setB.addAll(mapD.keySet());
            setB.addAll(vVar.g().getValue());
            Set set = setB;
            A6.c cVar = A6.c.INSTANCE;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String strC = cVar.c((TaskInfoCard) it.next());
                if (strC != null) {
                    set.add(strC);
                }
            }
            Set setA = X.a(setB);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<String, SessionLiveState> entry2 : mapC.entrySet()) {
                if (setA.contains(entry2.getKey())) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            Log.i(str2, "aggregate output=" + Z8.F.A0(linkedHashMap3.entrySet(), null, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.D
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj3) {
                    return TaskLiveNotificationDispatcher.Q0((Map.Entry) obj3);
                }
            }, 31, null));
            lastAggregatedStates = mapC;
            Q(appContext, mapC, true);
        } finally {
            Trace.endSection();
        }
    }

    public final Long P(String sessionId) {
        Object next;
        HashMap<String, Long> map = alipayOwnedSessions;
        Long l10 = map.get(sessionId);
        if (l10 != null) {
            return Long.valueOf(l10.longValue());
        }
        Set<Map.Entry<String, Long>> setEntrySet = map.entrySet();
        kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
        Iterator<T> it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            TaskLiveNotificationDispatcher taskLiveNotificationDispatcher = INSTANCE;
            Object key = ((Map.Entry) next).getKey();
            kotlin.jvm.internal.p.h(key, "<get-key>(...)");
            if (taskLiveNotificationDispatcher.V0((String) key, sessionId)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (Long) entry.getValue();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q(android.content.Context r30, java.util.Map<java.lang.String, com.stepos.ailauncher.taskstore.livenotification.SessionLiveState> r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 1591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.Q(android.content.Context, java.util.Map, boolean):void");
    }

    public final void R(Context appContext, Map<String, SessionLiveState> cached) {
        String strC;
        Trace.beginSection("TaskLiveNotif.applyFg");
        try {
            Set setB = X.b();
            setB.addAll(INSTANCE.i0());
            setB.addAll(com.stepos.ailauncher.common.utils.v.INSTANCE.g().getValue());
            for (Map.Entry<String, SessionChatActivitySnapshot> entry : SessionActivityTracker.INSTANCE.e().getValue().entrySet()) {
                String key = entry.getKey();
                SessionChatActivitySnapshot value = entry.getValue();
                if (!La.H.x0(key) && (value.getPhase() == SessionChatPhase.REPLYING || value.getPhase() == SessionChatPhase.WAITING)) {
                    setB.add(key);
                }
            }
            for (TaskInfoCard taskInfoCard : lastCards) {
                if (!taskInfoCard.getStatus().isTerminal() && (strC = A6.c.INSTANCE.c(taskInfoCard)) != null) {
                    if (La.H.x0(strC)) {
                        strC = null;
                    }
                    if (strC != null) {
                        setB.add(strC);
                    }
                }
            }
            Set setA = X.a(setB);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, SessionLiveState> entry2 : cached.entrySet()) {
                if (setA.contains(entry2.getKey())) {
                    linkedHashMap.put(entry2.getKey(), entry2.getValue());
                }
            }
            Q(appContext, linkedHashMap, false);
        } finally {
            Trace.endSection();
        }
    }

    public final String R0(String sessionId, String phaseName, String source) {
        String strPut = dismissedSessions.put(sessionId, phaseName);
        Log.i(TAG, "rememberDismissed sessionId=" + sessionId + " phase=" + phaseName + " previous=" + strPut + " source=" + source);
        return strPut;
    }

    public final void S(Ua.M s10, Context appContext, String sessionId) {
        if (d1(sessionId)) {
            return;
        }
        SessionLiveState sessionLiveState = lastStates.get(sessionId);
        if (sessionLiveState != null) {
            if (sessionLiveState.getRiskRequestId() == null) {
                sessionLiveState = null;
            }
            if (sessionLiveState != null) {
                riskAfterglows.put(sessionId, new RiskAfterglow(sessionLiveState.getTitle(), System.currentTimeMillis()));
                HashMap<String, kotlinx.coroutines.g> map = riskAfterglowJobs;
                kotlinx.coroutines.g gVarRemove = map.remove(sessionId);
                if (gVarRemove != null) {
                    kotlinx.coroutines.g.Y0(gVarRemove, null, 1, null);
                }
                map.put(sessionId, C1060i.d(s10, null, null, new TaskLiveNotificationDispatcher$armRiskAfterglow$1(sessionId, appContext, null), 3, null));
                Log.i(TAG, "risk afterglow armed sessionId=" + sessionId + " title='" + sessionLiveState.getTitle() + "' window=30000ms");
                return;
            }
        }
        Log.d(TAG, "risk afterglow skipped: risk was not the island carrier sessionId=" + sessionId);
    }

    public final void S0() {
        Ua.M m10 = scope;
        if (m10 == null) {
            V();
        } else {
            C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$reset$1(null), 3, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.T(android.content.Context):void");
    }

    public final String T0(String explicit) {
        Object next;
        Iterator it = SequencesKt___SequencesKt.F(Z8.T.D(SessionActivityTracker.INSTANCE.e().getValue()), new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.J
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TaskLiveNotificationDispatcher.U0((Map.Entry) obj));
            }
        }).iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long lastUserMessageAt = ((SessionChatActivitySnapshot) ((Map.Entry) next).getValue()).getLastUserMessageAt();
                do {
                    Object next2 = it.next();
                    long lastUserMessageAt2 = ((SessionChatActivitySnapshot) ((Map.Entry) next2).getValue()).getLastUserMessageAt();
                    if (lastUserMessageAt < lastUserMessageAt2) {
                        next = next2;
                        lastUserMessageAt = lastUserMessageAt2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        return N.j(explicit, com.stepos.ailauncher.common.utils.v.INSTANCE.i().getValue(), C3172w.INSTANCE.h(), lastStates, entry != null ? (String) entry.getKey() : null);
    }

    public final void U(Context appContext, Set<String> ids, boolean markDismissed) {
        SessionActivityState phase;
        suppressingIslandPush = true;
        try {
            X(ids);
            Set<String> setC = A.INSTANCE.c(appContext, ids, true);
            W(setC);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.addAll(ids);
            linkedHashSet.addAll(setC);
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            linkedHashSet2.addAll(linkedHashSet);
            for (Object obj : INSTANCE.i0()) {
                String str = (String) obj;
                if (!linkedHashSet.isEmpty()) {
                    Iterator it = linkedHashSet.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (C3723k.INSTANCE.f((String) it.next(), str)) {
                                linkedHashSet2.add(obj);
                                break;
                            }
                        }
                    }
                }
            }
            for (Object obj2 : SessionActivityTracker.INSTANCE.e().getValue().keySet()) {
                String str2 = (String) obj2;
                if (!linkedHashSet.isEmpty()) {
                    Iterator it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        if (C3723k.INSTANCE.f((String) it2.next(), str2)) {
                            break;
                        }
                    }
                }
                Set<String> set = setC;
                if (!(set instanceof Collection) || !set.isEmpty()) {
                    Iterator<T> it3 = set.iterator();
                    while (it3.hasNext()) {
                        if (C3723k.INSTANCE.f((String) it3.next(), str2)) {
                            linkedHashSet2.add(obj2);
                            break;
                        }
                    }
                }
            }
            for (Object obj3 : T.INSTANCE.G()) {
                String str3 = (String) obj3;
                if (!linkedHashSet.isEmpty()) {
                    Iterator it4 = linkedHashSet.iterator();
                    while (it4.hasNext()) {
                        if (C3723k.INSTANCE.f((String) it4.next(), str3)) {
                            break;
                        }
                    }
                }
                if (setC.contains(str3)) {
                    linkedHashSet2.add(obj3);
                }
            }
            if (linkedHashSet2.isEmpty()) {
                suppressingIslandPush = false;
                return;
            }
            Log.d(TAG, "cancelLiveSessions: cancel island only, skip session tombstone ids=" + ids + " ended=" + setC + " all=" + linkedHashSet2 + " markDismissed=" + markDismissed);
            Iterator it5 = linkedHashSet2.iterator();
            kotlin.jvm.internal.p.h(it5, "iterator(...)");
            while (it5.hasNext()) {
                Object next = it5.next();
                kotlin.jvm.internal.p.h(next, "next(...)");
                String str4 = (String) next;
                if (markDismissed) {
                    SessionLiveState sessionLiveState = lastStates.get(str4);
                    if (sessionLiveState != null && (phase = sessionLiveState.getPhase()) != null) {
                        INSTANCE.R0(str4, phase.name(), "cancel_live_sessions");
                    }
                } else {
                    dismissedSessions.remove(str4);
                }
                lastStates.remove(str4);
                lastNetworkPhases.remove(str4);
            }
            Iterator it6 = linkedHashSet2.iterator();
            kotlin.jvm.internal.p.h(it6, "iterator(...)");
            while (it6.hasNext()) {
                Object next2 = it6.next();
                kotlin.jvm.internal.p.h(next2, "next(...)");
                String str5 = (String) next2;
                SessionActivityTracker.INSTANCE.a(str5);
                x.n(x.INSTANCE, new String[]{str5}, null, 2, null);
                riskAfterglows.remove(str5);
                kotlinx.coroutines.g gVarRemove = riskAfterglowJobs.remove(str5);
                if (gVarRemove != null) {
                    kotlinx.coroutines.g.Y0(gVarRemove, null, 1, null);
                }
                kotlinx.coroutines.g gVarRemove2 = riskTransitionJobs.remove(str5);
                if (gVarRemove2 != null) {
                    kotlinx.coroutines.g.Y0(gVarRemove2, null, 1, null);
                }
            }
            suppressingIslandPush = false;
        } catch (Throwable th) {
            suppressingIslandPush = false;
            throw th;
        }
    }

    public final void V() {
        lastStates.clear();
        lastNetworkPhases.clear();
        lastCards.clear();
        lastSessions = C1173v.m();
        lastAggregatedStates = null;
        foregroundRecomputePosted = false;
        lastContentSessionIds = Y.e();
        lastArtifactSessionIds = Y.e();
        lastPersistedChat = kotlin.collections.a.i();
        dismissedSessions.clear();
        alipayOwnedSessions.clear();
        alipayLiveToChat.clear();
        cancelledIslandKeys = Y.e();
        Collection<kotlinx.coroutines.g> collectionValues = riskAfterglowJobs.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        for (kotlinx.coroutines.g gVar : collectionValues) {
            kotlin.jvm.internal.p.f(gVar);
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        riskAfterglowJobs.clear();
        riskAfterglows.clear();
        Collection<kotlinx.coroutines.g> collectionValues2 = riskTransitionJobs.values();
        kotlin.jvm.internal.p.h(collectionValues2, "<get-values>(...)");
        for (kotlinx.coroutines.g gVar2 : collectionValues2) {
            kotlin.jvm.internal.p.f(gVar2);
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        riskTransitionJobs.clear();
        x.INSTANCE.a();
        z.INSTANCE.b();
        afterTakeoverSessions.clear();
        Log.d(TAG, "bookkeeping reset");
    }

    public final boolean V0(String left, String right) {
        return C3723k.INSTANCE.f(left, right);
    }

    public final void W(Set<String> ended) {
        for (String str : ended) {
            if (La.D.X(str, O5.c.ALIPAY_XUI, false, 2, null)) {
                com.stepos.ailauncher.foundation.appui.card.provider.alipay.E.c(com.stepos.ailauncher.foundation.appui.card.provider.alipay.E.INSTANCE, null, str, 1, null);
                alipayLiveToChat.remove(str);
            }
        }
    }

    public final void W0(Context appContext) {
        Ua.M m10 = scope;
        if (m10 == null || foregroundRecomputePosted) {
            return;
        }
        foregroundRecomputePosted = true;
        C1060i.d(m10, Ua.Y.c(), null, new TaskLiveNotificationDispatcher$scheduleForegroundRecompute$1(appContext, null), 2, null);
    }

    public final void X(Set<String> sessionIds) {
        if (sessionIds.isEmpty()) {
            return;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Map.Entry<String, String>> it = alipayLiveToChat.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            kotlin.jvm.internal.p.h(next, "next(...)");
            Map.Entry<String, String> entry = next;
            String key = entry.getKey();
            kotlin.jvm.internal.p.h(key, "component1(...)");
            String str = key;
            String value = entry.getValue();
            kotlin.jvm.internal.p.h(value, "component2(...)");
            String str2 = value;
            Set<String> set = sessionIds;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                for (String str3 : set) {
                    if (C3723k.INSTANCE.f(str3, str2) || INSTANCE.V0(str3, str2)) {
                        linkedHashSet.add(str);
                        it.remove();
                        break;
                    }
                }
            }
        }
        for (final String str4 : sessionIds) {
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.E.c(com.stepos.ailauncher.foundation.appui.card.provider.alipay.E.INSTANCE, str4, null, 2, null);
            Set<String> setKeySet = alipayOwnedSessions.keySet();
            kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
            Z8.A.J(setKeySet, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.I
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(TaskLiveNotificationDispatcher.Y(str4, (String) obj));
                }
            });
        }
        Iterator it2 = linkedHashSet.iterator();
        kotlin.jvm.internal.p.h(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next2 = it2.next();
            kotlin.jvm.internal.p.h(next2, "next(...)");
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.E.c(com.stepos.ailauncher.foundation.appui.card.provider.alipay.E.INSTANCE, null, (String) next2, 1, null);
        }
    }

    public final void X0(List<TaskInfoCard> cards) {
        A6.c cVar = A6.c.INSTANCE;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : cards) {
            String strC = cVar.c((TaskInfoCard) obj);
            Object arrayList = linkedHashMap.get(strC);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strC, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (str != null && !La.H.x0(str)) {
                HashMap<String, String> map = dismissedSessions;
                if (map.containsKey(str)) {
                    String str2 = map.get(str);
                    Log.i(TAG, "seedDismissedFromCards skip-existing sessionId=" + str + " existing=" + ((Object) str2) + " cards=" + Y0(list));
                } else {
                    List list2 = list;
                    ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((TaskInfoCard) it.next()).getNotificationDismissedStatus());
                    }
                    String str3 = (String) Z8.F.Z0(Z8.F.g0(arrayList2));
                    if (str3 != null) {
                        if (La.H.x0(str3)) {
                            str3 = null;
                        }
                        if (str3 != null) {
                            TaskLiveNotificationDispatcher taskLiveNotificationDispatcher = INSTANCE;
                            String upperCase = str3.toUpperCase(Locale.ROOT);
                            kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
                            String strH1 = taskLiveNotificationDispatcher.h1(upperCase);
                            if (strH1 != null) {
                                dismissedSessions.put(str, strH1);
                                Log.i(TAG, "seedDismissedFromCards sessionId=" + str + " phase=" + strH1 + " cards=" + Y0(list));
                            }
                        }
                    }
                }
            }
        }
    }

    public final void Z(Context context, String sessionId, String aliasSessionId, String requestId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(aliasSessionId, "aliasSessionId");
        x.INSTANCE.m(new String[]{sessionId, aliasSessionId}, requestId);
        Ua.M m10 = scope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$dismissRiskWithoutAfterglow$1(sessionId, requestId, context.getApplicationContext(), null), 3, null);
            return;
        }
        riskAfterglows.remove(sessionId);
        kotlinx.coroutines.g gVarRemove = riskAfterglowJobs.remove(sessionId);
        if (gVarRemove != null) {
            kotlinx.coroutines.g.Y0(gVarRemove, null, 1, null);
        }
        kotlinx.coroutines.g gVarRemove2 = riskTransitionJobs.remove(sessionId);
        if (gVarRemove2 != null) {
            kotlinx.coroutines.g.Y0(gVarRemove2, null, 1, null);
        }
        Log.w(TAG, "dismissRiskWithoutAfterglow: dispatcher not started sessionId=" + sessionId);
    }

    public final NetworkPhase a0(SessionLiveState sessionLiveState, NetworkPhase networkPhase) {
        return sessionLiveState.getRiskRequestId() != null ? NetworkPhase.AVAILABLE : (sessionLiveState.getPhase() == SessionActivityState.COMPLETED_UNREAD || sessionLiveState.getPhase() == SessionActivityState.FAILED) ? NetworkPhase.AVAILABLE : networkPhase;
    }

    public final boolean a1(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (La.H.x0(sessionId)) {
            return false;
        }
        Set setJ = Y.j(sessionId, ConversationSessionIds.INSTANCE.m(sessionId));
        ArrayList<TaskInfoCard> arrayList = lastCards;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (Z8.F.f0(setJ, A6.c.INSTANCE.c((TaskInfoCard) obj))) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            return false;
        }
        if (arrayList2.isEmpty()) {
            return true;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            if (!((TaskInfoCard) it.next()).getStatus().isTerminal()) {
                return false;
            }
        }
        return true;
    }

    public final Set<String> b0(Collection<String> sessionIds) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        Collection<String> collection = sessionIds;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(La.H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listG0 = Z8.F.g0(arrayList2);
        if (listG0.isEmpty()) {
            return Y.e();
        }
        Set<String> setR1 = Z8.F.r1(listG0);
        ArrayList<TaskInfoCard> arrayList3 = lastCards;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (C3723k.INSTANCE.b((TaskInfoCard) obj2, setR1)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            Z8.A.E(arrayList5, C3723k.INSTANCE.a((TaskInfoCard) it2.next()));
        }
        Set setB = X.b();
        setB.addAll(INSTANCE.i0());
        setB.addAll(new HashSet(lastNetworkPhases.keySet()));
        List<SessionListItem> list = lastSessions;
        ArrayList arrayList6 = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            arrayList6.add(((SessionListItem) it3.next()).getSessionId());
        }
        setB.addAll(arrayList6);
        setB.addAll(lastContentSessionIds);
        setB.addAll(lastArtifactSessionIds);
        setB.addAll(cancelledIslandKeys);
        Set<String> setKeySet = dismissedSessions.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        setB.addAll(setKeySet);
        Set<String> setKeySet2 = riskAfterglows.keySet();
        kotlin.jvm.internal.p.h(setKeySet2, "<get-keys>(...)");
        setB.addAll(setKeySet2);
        setB.addAll(T.INSTANCE.G());
        setB.addAll(SessionActivityTracker.INSTANCE.e().getValue().keySet());
        setB.addAll(x.INSTANCE.d().getValue());
        return C3723k.INSTANCE.e(listG0, arrayList5, X.a(setB));
    }

    public final boolean b1(final String sessionId) {
        Long lP = P(sessionId);
        if (lP == null) {
            return false;
        }
        long jLongValue = lP.longValue();
        SessionChatActivitySnapshot sessionChatActivitySnapshot = SessionActivityTracker.INSTANCE.e().getValue().get(sessionId);
        if ((sessionChatActivitySnapshot != null ? sessionChatActivitySnapshot.getLastUserMessageAt() : 0L) <= jLongValue) {
            return true;
        }
        Set<String> setKeySet = alipayOwnedSessions.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        Z8.A.J(setKeySet, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TaskLiveNotificationDispatcher.c1(sessionId, (String) obj));
            }
        });
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c0(android.content.Context r21, java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoCard> r22, e9.InterfaceC4014c<? super Y8.t> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.c0(android.content.Context, java.util.List, e9.c):java.lang.Object");
    }

    public final boolean d1(String sessionId) {
        SessionChatPhase phase;
        if (a1(sessionId)) {
            Log.d(TAG, "risk afterglow skipped: session tasks already terminal sessionId=" + sessionId);
            return true;
        }
        SessionLiveState sessionLiveState = lastStates.get(sessionId);
        SessionChatPhase phase2 = null;
        SessionActivityState phase3 = sessionLiveState != null ? sessionLiveState.getPhase() : null;
        if (Z8.F.f0(TERMINAL_PHASES, phase3)) {
            Log.d(TAG, "risk afterglow skipped: last island phase already terminal sessionId=" + sessionId + " phase=" + phase3);
            return true;
        }
        String strM = ConversationSessionIds.INSTANCE.m(sessionId);
        Map<String, SessionChatActivitySnapshot> value = SessionActivityTracker.INSTANCE.e().getValue();
        SessionChatActivitySnapshot sessionChatActivitySnapshot = value.get(sessionId);
        if (sessionChatActivitySnapshot == null || (phase = sessionChatActivitySnapshot.getPhase()) == null) {
            SessionChatActivitySnapshot sessionChatActivitySnapshot2 = value.get(strM);
            if (sessionChatActivitySnapshot2 != null) {
                phase2 = sessionChatActivitySnapshot2.getPhase();
            }
        } else {
            phase2 = phase;
        }
        if (phase2 != SessionChatPhase.REPLIED && phase2 != SessionChatPhase.FAILED) {
            return false;
        }
        Log.d(TAG, "risk afterglow skipped: chat already ended sessionId=" + sessionId + " phase=" + phase2);
        return true;
    }

    public final boolean e0(String sessionId) {
        return x.c(x.INSTANCE, new String[]{sessionId, ConversationSessionIds.INSTANCE.m(sessionId)}, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String e1(android.content.Context r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.e1(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public final void f0(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (scope != null) {
            return;
        }
        synchronized (this) {
            if (scope != null) {
                return;
            }
            if (TaskStoreDatabase.INSTANCE.i()) {
                Log.w(TAG, "dispatcher skip: task store unavailable (disk)");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            Ua.M mA = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
            scope = mA;
            T t10 = T.INSTANCE;
            kotlin.jvm.internal.p.f(applicationContext);
            t10.p(applicationContext);
            observeJob = C1060i.d(mA, null, null, new TaskLiveNotificationDispatcher$init$1$1(applicationContext, null), 3, null);
            Log.d(TAG, "dispatcher started, observing notifiable root cards");
            TaskLiveNotificationDispatcher taskLiveNotificationDispatcher = INSTANCE;
            taskLiveNotificationDispatcher.s0(applicationContext, mA);
            taskLiveNotificationDispatcher.w0(applicationContext, mA);
            taskLiveNotificationDispatcher.t0(applicationContext, mA);
            taskLiveNotificationDispatcher.u0();
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void f1(Map<String, SessionLiveState> states) {
        for (Map.Entry<String, SessionLiveState> entry : states.entrySet()) {
            String key = entry.getKey();
            SessionLiveState value = entry.getValue();
            SessionActivityState phase = value.getPhase();
            int i10 = phase == null ? -1 : a.$EnumSwitchMapping$0[phase.ordinal()];
            if (i10 == 1) {
                afterTakeoverSessions.add(key);
            } else if (i10 != 2) {
                afterTakeoverSessions.remove(key);
            } else if (value.getRiskAfterglow()) {
                afterTakeoverSessions.add(key);
            }
        }
        afterTakeoverSessions.retainAll(states.keySet());
    }

    public final boolean g0(String sessionId) {
        com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
        if (!vVar.k()) {
            return false;
        }
        String strM = ConversationSessionIds.INSTANCE.m(sessionId);
        if (!vVar.m(sessionId) && !vVar.m(strM)) {
            if (vVar.p(sessionId)) {
                return true;
            }
            if (!kotlin.jvm.internal.p.d(strM, sessionId) && vVar.p(strM)) {
                return true;
            }
        }
        return false;
    }

    public final void g1() {
        Object next;
        TaskInfoStatus taskInfoStatusA;
        Ua.M m10 = scope;
        if (m10 == null) {
            return;
        }
        Map mapM = N.m(SessionActivityTracker.INSTANCE.e().getValue());
        ArrayList<TaskInfoCard> arrayList = lastCards;
        A6.c cVar = A6.c.INSTANCE;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : arrayList) {
            String strC = cVar.c((TaskInfoCard) obj);
            Object arrayList2 = linkedHashMap.get(strC);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(strC, arrayList2);
            }
            ((List) arrayList2).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (str != null && !La.H.x0(str)) {
                SessionChatActivity sessionChatActivity = (SessionChatActivity) mapM.get(str);
                boolean z10 = (sessionChatActivity != null ? sessionChatActivity.getPhase() : null) == SessionActivityState.WAITING_FOR_USER;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : list) {
                    if (!((TaskInfoCard) obj2).getStatus().isTerminal()) {
                        arrayList3.add(obj2);
                    }
                }
                Iterator it = arrayList3.iterator();
                if (it.hasNext()) {
                    next = it.next();
                    if (it.hasNext()) {
                        long updatedAt = ((TaskInfoCard) next).getUpdatedAt();
                        do {
                            Object next2 = it.next();
                            long updatedAt2 = ((TaskInfoCard) next2).getUpdatedAt();
                            if (updatedAt < updatedAt2) {
                                next = next2;
                                updatedAt = updatedAt2;
                            }
                        } while (it.hasNext());
                    }
                } else {
                    next = null;
                }
                TaskInfoCard taskInfoCard = (TaskInfoCard) next;
                if (taskInfoCard != null && (taskInfoStatusA = A6.a.INSTANCE.a(taskInfoCard, z10)) != null && askUserCardSyncInFlight.add(taskInfoCard.getTaskId())) {
                    C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$syncAskUserWaitingOnCards$2$1(taskInfoCard, taskInfoStatusA, null), 3, null);
                }
            }
        }
    }

    public final boolean h0(String sessionId, SessionActivityState phase) {
        String strName;
        Object next;
        if (phase != null && (strName = phase.name()) != null) {
            HashMap<String, String> map = dismissedSessions;
            String str = map.get(sessionId);
            if (kotlin.jvm.internal.p.d(str, strName)) {
                Log.i(TAG, "userDismissed exact sessionId=" + sessionId + " phase=" + strName + " dismissed=" + str + " all=" + kotlin.collections.a.A(map));
                return true;
            }
            Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
            kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
            Iterator<T> it = setEntrySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Map.Entry entry = (Map.Entry) next;
                kotlin.jvm.internal.p.f(entry);
                Object key = entry.getKey();
                kotlin.jvm.internal.p.h(key, "component1(...)");
                String str2 = (String) key;
                Object value = entry.getValue();
                kotlin.jvm.internal.p.h(value, "component2(...)");
                if (kotlin.jvm.internal.p.d((String) value, strName) && C3723k.INSTANCE.f(str2, sessionId)) {
                    break;
                }
            }
            Map.Entry entry2 = (Map.Entry) next;
            if (entry2 != null) {
                Log.i(TAG, "userDismissed alias sessionId=" + sessionId + " phase=" + strName + " matchedId=" + entry2.getKey() + " dismissed=" + entry2.getValue() + " all=" + kotlin.collections.a.A(dismissedSessions));
                return true;
            }
        }
        return false;
    }

    public final String h1(String str) {
        switch (str.hashCode()) {
            case -1429540080:
                if (str.equals("SKIPPED")) {
                    return null;
                }
                return "RUNNING";
            case -1031784143:
                if (str.equals("CANCELLED")) {
                    return null;
                }
                return "RUNNING";
            case 35394935:
                return str.equals("PENDING") ? "WAITING_FOR_USER" : "RUNNING";
            case 1383663147:
                return !str.equals("COMPLETED") ? "RUNNING" : "COMPLETED_UNREAD";
            case 1834295853:
                return !str.equals("WAITING") ? "RUNNING" : "WAITING_FOR_USER";
            case 2066319421:
                return !str.equals("FAILED") ? "RUNNING" : "FAILED";
            default:
                return "RUNNING";
        }
    }

    public final Set<String> i0() {
        return N.l(lastStates);
    }

    public final boolean i1(Set<String> ids) {
        if (ids.isEmpty()) {
            return false;
        }
        Map<String, SessionChatActivitySnapshot> value = SessionActivityTracker.INSTANCE.e().getValue();
        if (value.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, SessionChatActivitySnapshot> entry : value.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().getPhase() == SessionChatPhase.FAILED) {
                if (ids.contains(key)) {
                    return true;
                }
                Set<String> set = ids;
                if (!(set instanceof Collection) || !set.isEmpty()) {
                    Iterator<T> it = set.iterator();
                    while (it.hasNext()) {
                        if (C3723k.INSTANCE.f((String) it.next(), key)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final Set<String> j0() {
        final SessionHandler sessionHandlerT = AgentConfig.INSTANCE.a().getSessionHandler();
        ArrayList<TaskInfoCard> arrayList = lastCards;
        A6.c cVar = A6.c.INSTANCE;
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(cVar.c((TaskInfoCard) it.next()));
        }
        return N.i(sessionHandlerT != null || C2706l.INSTANCE.a().j() > 0, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TaskLiveNotificationDispatcher.k0(sessionHandlerT, (String) obj));
            }
        }, N.c(arrayList2, i0(), N.e(SessionActivityTracker.INSTANCE.e().getValue())));
    }

    public final SessionLiveState j1(String sessionId, SessionLiveState state) {
        return (state.getPhase() == SessionActivityState.RUNNING && state.getCategory() == SessionLiveCategory.TASK && afterTakeoverSessions.contains(sessionId) && !state.getContinueTaskAfterTakeover()) ? state.a((8190 & 1) != 0 ? state.sessionId : null, (8190 & 2) != 0 ? state.category : null, (8190 & 4) != 0 ? state.title : null, (8190 & 8) != 0 ? state.phase : null, (8190 & 16) != 0 ? state.dynamicText : null, (8190 & 32) != 0 ? state.iconRes : null, (8190 & 64) != 0 ? state.updatedAt : 0L, (8190 & 128) != 0 ? state.riskRequestId : null, (8190 & 256) != 0 ? state.riskButtons : null, (8190 & 512) != 0 ? state.riskBody : null, (8190 & 1024) != 0 ? state.riskLevel : null, (8190 & 2048) != 0 ? state.riskAfterglow : false, (8190 & 4096) != 0 ? state.continueTaskAfterTakeover : true) : state;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l0(e9.InterfaceC4014c<? super java.util.Set<java.lang.String>> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.l0(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m0(e9.InterfaceC4014c<? super java.util.Set<java.lang.String>> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.m0(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n0(java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoCard> r9, e9.InterfaceC4014c<? super java.util.Map<java.lang.String, com.stepos.ailauncher.taskstore.livenotification.SessionChatActivity>> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.n0(java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o0(e9.InterfaceC4014c<? super java.util.List<com.stepos.agentframework.chatcore.session.list.SessionListItem>> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$loadSessions$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$loadSessions$1 r0 = (com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$loadSessions$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$loadSessions$1 r0 = new com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$loadSessions$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher r4 = (com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher) r4
            kotlin.C4849c.b(r5)     // Catch: java.lang.Throwable -> L59
            goto L4e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            kotlin.Result$a r5 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L59
            com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStore r5 = com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStore.INSTANCE     // Catch: java.lang.Throwable -> L59
            java.lang.Object r4 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L59
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L59
            r4 = 0
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L59
            r0.label = r3     // Catch: java.lang.Throwable -> L59
            java.lang.Object r5 = r5.a(r0)     // Catch: java.lang.Throwable -> L59
            if (r5 != r1) goto L4e
            return r1
        L4e:
            com.stepos.agentframework.chatcore.session.list.c r5 = (com.stepos.agentframework.chatcore.session.list.SessionListSnapshot) r5     // Catch: java.lang.Throwable -> L59
            java.util.List r4 = r5.a()     // Catch: java.lang.Throwable -> L59
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L59
            goto L64
        L59:
            r4 = move-exception
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.C4849c.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L64:
            java.lang.Throwable r5 = kotlin.Result.e(r4)
            if (r5 == 0) goto L71
            java.lang.String r0 = "TaskLiveNotificationDispatcher"
            java.lang.String r1 = "load session list failed"
            android.util.Log.w(r0, r1, r5)
        L71:
            java.util.List r5 = Z8.C1173v.m()
            boolean r0 = kotlin.Result.g(r4)
            if (r0 == 0) goto L7c
            r4 = r5
        L7c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.o0(e9.c):java.lang.Object");
    }

    public final void p0(String sessionId) {
        Ua.M m10 = scope;
        if (m10 == null) {
            return;
        }
        C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$markForegroundSessionTasksRead$1(sessionId, null), 3, null);
    }

    public final void q0(String sessionId, String status) {
        String strH1;
        Ua.M m10;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (status != null) {
            String upperCase = status.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
            if (upperCase == null || (strH1 = h1(upperCase)) == null || (m10 = scope) == null) {
                return;
            }
            C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$markSessionDismissed$1(sessionId, strH1, null), 3, null);
        }
    }

    public final Set<String> r0(Set<String> set, Set<String> set2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            String str = (String) obj;
            Set<String> set3 = set2;
            if (!(set3 instanceof Collection) || !set3.isEmpty()) {
                Iterator<T> it = set3.iterator();
                while (it.hasNext()) {
                    if (C3723k.INSTANCE.f((String) it.next(), str)) {
                        break;
                    }
                }
            }
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public final void s0(Context appContext, Ua.M s10) {
        kotlinx.coroutines.g gVar = chatJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        chatJob = C1060i.d(s10, null, null, new TaskLiveNotificationDispatcher$observeChatActivity$1(appContext, null), 3, null);
        Log.d(TAG, "observing chat session activity");
    }

    public final void t0(Context appContext, Ua.M s10) {
        kotlinx.coroutines.g gVar = foregroundJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        foregroundJob = C1060i.d(s10, null, null, new TaskLiveNotificationDispatcher$observeForegroundSession$1(appContext, null), 3, null);
        Log.d(TAG, "observing foreground chat session");
    }

    public final void u0() {
        C1935i0.INSTANCE.b(this, new C1935i0.a() { // from class: com.stepos.ailauncher.taskstore.livenotification.B
            @Override // com.stepos.agentframework.chatcore.session.C1935i0.a
            public final void a(String str, String str2) {
                TaskLiveNotificationDispatcher.v0(str, str2);
            }
        });
        Log.d(TAG, "observing local session title fixes");
    }

    public final void w0(Context appContext, Ua.M s10) {
        kotlinx.coroutines.g gVar = networkJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        networkJob = C1060i.d(s10, null, null, new TaskLiveNotificationDispatcher$observeNetworkPhase$1(appContext, null), 3, null);
        Log.d(TAG, "observing network phase, current=" + NetworkStateMonitor.e().getValue());
    }

    public final void x0(Context context, String sessionId, String taskId) {
        kotlin.jvm.internal.p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        H0(applicationContext, sessionId, taskId);
    }

    public final void y0() {
        Ua.M m10 = scope;
        if (m10 == null) {
            return;
        }
        C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$onLocalSessionTitleChanged$1(null), 3, null);
    }

    public final boolean z0(Context context, String sessionId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        Ua.M m10 = scope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new TaskLiveNotificationDispatcher$onRiskChanged$1(sessionId, context.getApplicationContext(), null), 3, null);
            return true;
        }
        Log.w(TAG, "onRiskChanged ignored: dispatcher not started sessionId=" + sessionId);
        return false;
    }
}
