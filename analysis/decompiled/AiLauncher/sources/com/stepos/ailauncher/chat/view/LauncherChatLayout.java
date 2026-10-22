package com.stepos.ailauncher.chat.view;

import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.view.ChatRecycleView;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import v9.C5680i;
import v9.C5685n;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ú\u00012\u00020\u0001:\u0002û\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\u00172\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\u000fJ\u0011\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u0017H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\"H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0017H\u0002¢\u0006\u0004\b,\u0010'J\u0017\u0010-\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0017H\u0002¢\u0006\u0004\b-\u0010'J\u000f\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010\u000fJ\u000f\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b/\u0010\u000fJ+\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\b\u0018\u0001022\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000bH\u0002¢\u0006\u0004\b6\u0010\u000fJ\u000f\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0004\b7\u0010\u000fJ\u0017\u0010:\u001a\u00020\u00142\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J!\u0010>\u001a\u0004\u0018\u00010<2\u0006\u00109\u001a\u0002082\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?J\u0015\u0010A\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020<¢\u0006\u0004\bA\u0010BJ\u0015\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u0017¢\u0006\u0004\bD\u0010'J\u000f\u0010E\u001a\u00020\u0017H\u0016¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\u000b¢\u0006\u0004\bG\u0010\u000fJ\r\u0010H\u001a\u00020\u0017¢\u0006\u0004\bH\u0010FJ\r\u0010I\u001a\u00020\u000b¢\u0006\u0004\bI\u0010\u000fJ\u0019\u0010K\u001a\u00020\u000b2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bK\u0010\u001cJ\u001d\u0010L\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\bL\u0010\rJ'\u0010M\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\bM\u0010NJ\u001f\u0010Q\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\u0017H\u0016¢\u0006\u0004\bQ\u0010RJ\u001f\u0010T\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\t2\u0006\u0010S\u001a\u00020\u0014H\u0016¢\u0006\u0004\bT\u0010UJ\r\u0010V\u001a\u00020\u000b¢\u0006\u0004\bV\u0010\u000fJ\r\u0010W\u001a\u00020\u000b¢\u0006\u0004\bW\u0010\u000fJ\r\u0010X\u001a\u00020\u000b¢\u0006\u0004\bX\u0010\u000fJ\r\u0010Y\u001a\u00020\u000b¢\u0006\u0004\bY\u0010\u000fJ\u0015\u0010\\\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020Z¢\u0006\u0004\b\\\u0010]J\u0015\u0010`\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020^¢\u0006\u0004\b`\u0010aJ\r\u0010b\u001a\u00020\u000b¢\u0006\u0004\bb\u0010\u000fJ\u0015\u0010d\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020\u0017¢\u0006\u0004\bd\u0010'J\r\u0010e\u001a\u00020\u000b¢\u0006\u0004\be\u0010\u000fJ\r\u0010f\u001a\u00020\u000b¢\u0006\u0004\bf\u0010\u000fJ\r\u0010g\u001a\u00020\u000b¢\u0006\u0004\bg\u0010\u000fJ\u001f\u0010j\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u00172\b\b\u0002\u0010i\u001a\u00020\u0017¢\u0006\u0004\bj\u0010kJ\u0015\u0010l\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u0017¢\u0006\u0004\bl\u0010'J\u000f\u0010m\u001a\u0004\u0018\u00010\"¢\u0006\u0004\bm\u0010$J/\u0010r\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\"2\u0006\u0010o\u001a\u00020\"2\u0006\u0010p\u001a\u00020\"2\u0006\u0010q\u001a\u00020\"H\u0014¢\u0006\u0004\br\u0010sJ\r\u0010t\u001a\u00020\u000b¢\u0006\u0004\bt\u0010\u000fJ\r\u0010u\u001a\u00020\u0017¢\u0006\u0004\bu\u0010FJ\u001d\u0010w\u001a\u00020\u000b2\u0006\u0010v\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u0017¢\u0006\u0004\bw\u0010xJ\u0017\u0010z\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u0017H\u0014¢\u0006\u0004\bz\u0010'J\u0017\u0010{\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u0017H\u0014¢\u0006\u0004\b{\u0010'J\u000f\u0010|\u001a\u00020\u000bH\u0014¢\u0006\u0004\b|\u0010\u000fJ \u0010\u007f\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020^2\u0006\u0010~\u001a\u00020\"H\u0014¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0011\u0010\u0081\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b\u0081\u0001\u0010\u000fJ\u0019\u0010\u0082\u0001\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0005\b\u0082\u0001\u0010\u001cJ\u0011\u0010\u0083\u0001\u001a\u00020\u000bH\u0014¢\u0006\u0005\b\u0083\u0001\u0010\u000fJ\u0018\u0010\u0085\u0001\u001a\u00020\u000b2\u0007\u0010\u0084\u0001\u001a\u00020\u0017¢\u0006\u0005\b\u0085\u0001\u0010'J\u000f\u0010\u0086\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u0086\u0001\u0010\u000fJ\u000f\u0010\u0087\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u0087\u0001\u0010\u000fJ\u0011\u0010\u0088\u0001\u001a\u00020\u000bH\u0014¢\u0006\u0005\b\u0088\u0001\u0010\u000fJ#\u0010\u008a\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u00020\"2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J#\u0010\u008c\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u00020\"2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0006\b\u008c\u0001\u0010\u008b\u0001J\u001a\u0010\u008e\u0001\u001a\u00020\u000b2\u0007\u0010\u008d\u0001\u001a\u00020\u0014H\u0016¢\u0006\u0005\b\u008e\u0001\u0010\u001cJ#\u0010\u008f\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u00020\"2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u008b\u0001J#\u0010\u0090\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u00020\"2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0006\b\u0090\u0001\u0010\u008b\u0001J#\u0010\u0091\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u00020\"2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0006\b\u0091\u0001\u0010\u008b\u0001J\u0011\u0010\u0092\u0001\u001a\u00020\u000bH\u0014¢\u0006\u0005\b\u0092\u0001\u0010\u000fJ#\u0010\u0093\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u00020\"2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0006\b\u0093\u0001\u0010\u008b\u0001J#\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u00020\"2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0006\b\u0094\u0001\u0010\u008b\u0001RF\u0010\u0096\u0001\u001a\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0095\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010\u009e\u0001\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0019\u0010 \u0001\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010\u009f\u0001R\u0019\u0010¡\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u0019\u0010£\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¢\u0001R\u0019\u0010¤\u0001\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010\u009f\u0001R\u0018\u0010¦\u0001\u001a\u00030¥\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001RP\u0010©\u0001\u001a)\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\b\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0017\u0018\u00010¨\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001RR\u0010°\u0001\u001a+\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0017\u0018\u00010¯\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R\u001b\u0010¶\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010¢\u0001R\u001b\u0010·\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¢\u0001R\u001b\u0010¸\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0018\u0010º\u0001\u001a\u00030¥\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010§\u0001R\u001b\u0010»\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¹\u0001R\u0019\u0010¼\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010\u009d\u0001R>\u0010¾\u0001\u001a\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010½\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¾\u0001\u0010¿\u0001\u001a\u0006\bÀ\u0001\u0010Á\u0001\"\u0006\bÂ\u0001\u0010Ã\u0001R8\u0010Ä\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010½\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010¿\u0001\u001a\u0006\bÅ\u0001\u0010Á\u0001\"\u0006\bÆ\u0001\u0010Ã\u0001R\u0016\u0010Ç\u0001\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÇ\u0001\u0010TR\u0018\u0010È\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÈ\u0001\u0010TR\u001b\u0010É\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010¢\u0001R\u001c\u0010Ê\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010§\u0001R:\u0010Ë\u0001\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010½\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bË\u0001\u0010¿\u0001\u001a\u0006\bÌ\u0001\u0010Á\u0001\"\u0006\bÍ\u0001\u0010Ã\u0001R'\u0010Î\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÎ\u0001\u0010\u009d\u0001\u001a\u0005\bÏ\u0001\u0010F\"\u0005\bÐ\u0001\u0010'R\u001b\u0010Ñ\u0001\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0016\u0010Ó\u0001\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÓ\u0001\u0010TR\u0019\u0010Ô\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010\u009d\u0001R\u0019\u0010Õ\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010\u009d\u0001R\u0019\u0010Ö\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010\u009d\u0001R\u0019\u0010×\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010\u009d\u0001R\u0017\u0010Ø\u0001\u001a\u00020<8\u0002X\u0082D¢\u0006\b\n\u0006\bØ\u0001\u0010\u009f\u0001R\u0019\u0010Ù\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010\u009d\u0001R\u0019\u0010Ú\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010\u009d\u0001R\u0019\u0010Û\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010\u009d\u0001R\u0018\u0010Ü\u0001\u001a\u00030¥\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÜ\u0001\u0010§\u0001R\u0018\u0010Ý\u0001\u001a\u00030¥\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÝ\u0001\u0010§\u0001R\u0018\u0010Þ\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÞ\u0001\u0010TR\u0019\u0010ß\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010\u009d\u0001R\u0018\u0010à\u0001\u001a\u00030¥\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0001\u0010§\u0001R\u0018\u0010â\u0001\u001a\u00030á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u0016\u0010ä\u0001\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bä\u0001\u0010TR\u0019\u0010å\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010\u009d\u0001R2\u0010ç\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010æ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bç\u0001\u0010è\u0001\u001a\u0006\bé\u0001\u0010ê\u0001\"\u0006\bë\u0001\u0010ì\u0001R\u001c\u0010î\u0001\u001a\u0005\u0018\u00010í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R\u0019\u0010ð\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010\u009d\u0001R\u0018\u0010ñ\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bñ\u0001\u0010TR\u0019\u0010ò\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010\u009d\u0001R\u0019\u0010ó\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010\u009d\u0001R\u0016\u0010õ\u0001\u001a\u00020\u00178TX\u0094\u0004¢\u0006\u0007\u001a\u0005\bô\u0001\u0010FR\u0016\u0010÷\u0001\u001a\u00020\u00178TX\u0094\u0004¢\u0006\u0007\u001a\u0005\bö\u0001\u0010FR\u0016\u0010ù\u0001\u001a\u00020\u00178TX\u0094\u0004¢\u0006\u0007\u001a\u0005\bø\u0001\u0010F¨\u0006ü\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "Lcom/stepos/agentframework/chatui/AgentChatLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Lw4/c;", "messages", "LY8/t;", "f8", "(Ljava/util/List;)V", "Z8", "()V", "c8", "Lw4/e;", "title", "", "", "U8", "(Lw4/e;Ljava/util/List;)Ljava/util/Set;", "", "e8", "(Ljava/util/List;)Z", "sessionId", "A8", "(Ljava/lang/String;)V", "msg", "l8", "(Lw4/c;)V", "i8", "a9", "", "b8", "()Ljava/lang/Integer;", "force", "U7", "(Z)V", "reservePx", "W7", "(I)V", "showing", "Y7", "p8", "R8", "x8", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "Lkotlin/Pair;", "Lcom/stepos/ailauncher/chat/view/S;", "G8", "(Lcom/stepos/agentframework/chatcore/intent/e;)Lkotlin/Pair;", "n8", "u8", "Lcom/stepos/agentframework/chatui/N1;", "item", "z8", "(Lcom/stepos/agentframework/chatui/N1;)Ljava/lang/String;", "", "actionTime", "T7", "(Lcom/stepos/agentframework/chatui/N1;J)Ljava/lang/Long;", "sentAtMs", "X7", "(J)V", "managed", "setKeyboardScrollManagedExternally", "v", "()Z", "b9", "w8", "d8", "expectedSessionId", "Z7", "setMessages", "F", "(Lw4/e;Ljava/util/List;)V", "message", "playTts", "n", "(Lw4/c;Z)V", "oldMessageId", "I", "(Lw4/c;Ljava/lang/String;)V", "M8", "L8", "T8", "S8", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "input", "X8", "(Lcom/stepos/ailauncher/chat/view/BaseInputView;)V", "Landroid/view/View;", "slot", "q8", "(Landroid/view/View;)V", "e9", "lifted", "setScrollToBottomLiftedForFloatingCard", "c9", "d9", "I8", "freeze", "allowTallOverlap", "r8", "(ZZ)V", "s8", "y8", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "H8", "v8", "imeBottomPx", "C8", "(IZ)V", "visible", "y5", "w5", "x5", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "O", "m", "onAttachedToWindow", "crossWindow", "setScrollToBottomBlurCrossWindow", "J8", "O8", "onDetachedFromWindow", "position", "z", "(ILcom/stepos/agentframework/chatui/N1;)V", "t", "messageId", "K", "Q", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "D", "v5", "P", Const.INTENT_KEY_UMID, "Lkotlin/Function2;", "onCurrentConversationChanged", "Lp9/p;", "getOnCurrentConversationChanged", "()Lp9/p;", "setOnCurrentConversationChanged", "(Lp9/p;)V", "keyboardScrollManagedExternally", "Z", "externalReplyAutoTtsSentAtMs", "J", "externalReplyAutoTtsDeadlineElapsedMs", "externalReplyTargetPairId", "Ljava/lang/String;", "externalReplyTerminalMessageId", "externalReplyTerminalObservedElapsedMs", "Ljava/lang/Runnable;", "externalReplyAutoTtsPoll", "Ljava/lang/Runnable;", "Lkotlin/Function4;", "onAskUserInquiry", "Lp9/r;", "getOnAskUserInquiry", "()Lp9/r;", "setOnAskUserInquiry", "(Lp9/r;)V", "Lkotlin/Function5;", "onToolApproval", "Lp9/s;", "getOnToolApproval", "()Lp9/s;", "setOnToolApproval", "(Lp9/s;)V", "lastFiredInquiryId", "lastFiredApprovalId", "lastAskUserCandidate", "Lw4/c;", "recheckWhenShownRunnable", "lastApprovalCandidate", "skipNextHistoryAskUser", "Lkotlin/Function1;", "onMessagesApplied", "Lp9/l;", "getOnMessagesApplied", "()Lp9/l;", "setOnMessagesApplied", "(Lp9/l;)V", "onSessionKeyVisible", "getOnSessionKeyVisible", "setOnSessionKeyVisible", "imeReserveShrinkTolerancePx", "sessionSwitchGeneration", "pendingSwitchSessionId", "switchGuardTimeoutRunnable", "onSessionSwitchGuardTimeout", "getOnSessionSwitchGuardTimeout", "setOnSessionSwitchGuardTimeout", "ignoreEmptySetMessages", "getIgnoreEmptySetMessages", "setIgnoreEmptySetMessages", "overlayHeightSlot", "Landroid/view/View;", "overlayReserveFloorPx", "overlayReserveFrozenForIme", "overlayReserveFrozenForFloatingCard", "overlayReserveFrozenForSheetEnter", "overlayReserveAllowTallOverlap", "overlayImeFallbackDelayMs", "pinLatestMessageForIme", "imeFrameCorrectionPosted", "imeFrameCorrectionPending", "imeFrameCorrectionRunnable", "overlayImeFallbackRunnable", "pendingOverlayReservePx", "overlayReserveSyncPosted", "overlayReserveSyncRunnable", "Landroid/view/View$OnLayoutChangeListener;", "overlayHeightListener", "Landroid/view/View$OnLayoutChangeListener;", "scrollToBottomBaseBottomMarginPx", "scrollToBottomLifted", "Lkotlin/Function0;", "onOverlayGeometryChanged", "Lp9/a;", "getOnOverlayGeometryChanged", "()Lp9/a;", "setOnOverlayGeometryChanged", "(Lp9/a;)V", "Ly7/E;", "scrollToBottomBlurHandle", "Ly7/E;", "scrollToBottomBlurCrossWindow", "scrollToBottomBlurGeneration", "scrollToBottomBlurDetachWatcherInstalled", "scrollToBottomDetachHooked", "getAutoScrollToBottomOnKeyboardShow", "autoScrollToBottomOnKeyboardShow", "getDeferBottomReconcileDuringKeyboard", "deferBottomReconcileDuringKeyboard", "getObserveKeyboardVisibilityFromInsets", "observeKeyboardVisibilityFromInsets", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherChatLayout extends AgentChatLayout {
    public static final String ASK_USER_TOOL_NAME = "ask_user";
    private static final long EXTERNAL_REPLY_TTS_CLOCK_SKEW_MS = 3000;
    private static final long EXTERNAL_REPLY_TTS_POLL_MS = 1000;
    private static final long EXTERNAL_REPLY_TTS_SETTLE_MS = 1000;
    private static final long EXTERNAL_REPLY_TTS_TIMEOUT_MS = 180000;
    private static final float IME_RESERVE_SHRINK_TOLERANCE_DP = 40.0f;
    private static final long RECHECK_WHEN_SHOWN_DELAY_MS = 400;
    private static final float SCROLL_TO_BOTTOM_FLOAT_CARD_MARGIN_DP = 32.0f;
    public static final long SESSION_SWITCH_GUARD_TIMEOUT_MS = 3000;
    private long externalReplyAutoTtsDeadlineElapsedMs;
    private final Runnable externalReplyAutoTtsPoll;
    private long externalReplyAutoTtsSentAtMs;
    private String externalReplyTargetPairId;
    private String externalReplyTerminalMessageId;
    private long externalReplyTerminalObservedElapsedMs;
    private boolean ignoreEmptySetMessages;
    private boolean imeFrameCorrectionPending;
    private boolean imeFrameCorrectionPosted;
    private final Runnable imeFrameCorrectionRunnable;
    private final int imeReserveShrinkTolerancePx;
    private boolean keyboardScrollManagedExternally;
    private ChatMessage lastApprovalCandidate;
    private ChatMessage lastAskUserCandidate;
    private String lastFiredApprovalId;
    private String lastFiredInquiryId;
    private p9.r<? super String, ? super String, ? super List<AskUserInquiry>, ? super String, Boolean> onAskUserInquiry;
    private p9.p<? super w4.e, ? super List<ChatMessage>, Y8.t> onCurrentConversationChanged;
    private InterfaceC5074l<? super List<ChatMessage>, Y8.t> onMessagesApplied;
    private InterfaceC5063a<Y8.t> onOverlayGeometryChanged;
    private InterfaceC5074l<? super String, Y8.t> onSessionKeyVisible;
    private InterfaceC5074l<? super String, Y8.t> onSessionSwitchGuardTimeout;
    private p9.s<? super String, ? super String, ? super String, ? super String, ? super String, Boolean> onToolApproval;
    private final View.OnLayoutChangeListener overlayHeightListener;
    private View overlayHeightSlot;
    private final long overlayImeFallbackDelayMs;
    private final Runnable overlayImeFallbackRunnable;
    private boolean overlayReserveAllowTallOverlap;
    private final int overlayReserveFloorPx;
    private boolean overlayReserveFrozenForFloatingCard;
    private boolean overlayReserveFrozenForIme;
    private boolean overlayReserveFrozenForSheetEnter;
    private boolean overlayReserveSyncPosted;
    private final Runnable overlayReserveSyncRunnable;
    private int pendingOverlayReservePx;
    private String pendingSwitchSessionId;
    private boolean pinLatestMessageForIme;
    private final Runnable recheckWhenShownRunnable;
    private final int scrollToBottomBaseBottomMarginPx;
    private boolean scrollToBottomBlurCrossWindow;
    private boolean scrollToBottomBlurDetachWatcherInstalled;
    private int scrollToBottomBlurGeneration;
    private y7.E scrollToBottomBlurHandle;
    private boolean scrollToBottomDetachHooked;
    private boolean scrollToBottomLifted;
    private int sessionSwitchGeneration;
    private boolean skipNextHistoryAskUser;
    private Runnable switchGuardTimeoutRunnable;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/view/LauncherChatLayout$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            LauncherChatLayout.this.O8();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/view/LauncherChatLayout$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            LauncherChatLayout.this.O8();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherChatLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(attrs, "attrs");
        this.externalReplyTargetPairId = "";
        this.externalReplyTerminalMessageId = "";
        this.externalReplyAutoTtsPoll = new Runnable() { // from class: com.stepos.ailauncher.chat.view.O6
            @Override // java.lang.Runnable
            public final void run() {
                LauncherChatLayout.o8(this.f25912a);
            }
        };
        this.recheckWhenShownRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.view.P6
            @Override // java.lang.Runnable
            public final void run() {
                LauncherChatLayout.N8(this.f25924a);
            }
        };
        this.imeReserveShrinkTolerancePx = (int) (getResources().getDisplayMetrics().density * 40.0f);
        int paddingBottom = getPaddingBottom();
        this.overlayReserveFloorPx = paddingBottom;
        this.overlayImeFallbackDelayMs = 420L;
        this.imeFrameCorrectionRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.view.Q6
            @Override // java.lang.Runnable
            public final void run() {
                LauncherChatLayout.t8(this.f25937a);
            }
        };
        this.overlayImeFallbackRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.view.R6
            @Override // java.lang.Runnable
            public final void run() {
                LauncherChatLayout.E8(this.f25944a);
            }
        };
        this.pendingOverlayReservePx = paddingBottom;
        this.overlayReserveSyncRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.view.S6
            @Override // java.lang.Runnable
            public final void run() {
                LauncherChatLayout.F8(this.f25955a);
            }
        };
        this.overlayHeightListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.view.T6
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                LauncherChatLayout.D8(this.f25977a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        ViewGroup.LayoutParams layoutParams = getBtnScrollToBottom().getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        this.scrollToBottomBaseBottomMarginPx = marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0;
    }

    public static final void B8(LauncherChatLayout launcherChatLayout) {
        if (launcherChatLayout.isAttachedToWindow()) {
            Context context = launcherChatLayout.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            if (X6.b(context) == null) {
                com.stepos.ailauncher.container.m0 m0Var = com.stepos.ailauncher.container.m0.INSTANCE;
                if (m0Var.h()) {
                    m0Var.j();
                }
            }
        }
    }

    public static final void D8(LauncherChatLayout launcherChatLayout, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 == i14 && i11 == i15 && i12 == i16 && i13 == i17) {
            return;
        }
        launcherChatLayout.a9();
    }

    public static final void E8(LauncherChatLayout launcherChatLayout) {
        if (launcherChatLayout.overlayReserveFrozenForIme) {
            launcherChatLayout.p8(launcherChatLayout.getIsKeyboardVisible());
        }
    }

    public static final void F8(LauncherChatLayout launcherChatLayout) {
        launcherChatLayout.overlayReserveSyncPosted = false;
        if (launcherChatLayout.isAttachedToWindow()) {
            V7(launcherChatLayout, false, 1, null);
        }
    }

    public static final void K8(int i10, LauncherChatLayout launcherChatLayout) {
        if (i10 == launcherChatLayout.scrollToBottomBlurGeneration && launcherChatLayout.isAttachedToWindow()) {
            B7 b72 = B7.INSTANCE;
            b72.d(launcherChatLayout.scrollToBottomBlurHandle);
            launcherChatLayout.scrollToBottomBlurHandle = b72.b(launcherChatLayout.getBtnScrollToBottom(), launcherChatLayout.scrollToBottomBlurCrossWindow);
            launcherChatLayout.u8();
        }
    }

    public static final void N8(LauncherChatLayout launcherChatLayout) {
        if (launcherChatLayout.isShown()) {
            launcherChatLayout.M8();
            launcherChatLayout.L8();
        }
    }

    public static final void P8(LauncherChatLayout launcherChatLayout) {
        InterfaceC5074l<? super List<ChatMessage>, Y8.t> interfaceC5074l;
        if (launcherChatLayout.getAdapter().getItemCount() != 0 || (interfaceC5074l = launcherChatLayout.onMessagesApplied) == null) {
            return;
        }
        interfaceC5074l.invoke(C1173v.m());
    }

    public static final void Q8(LauncherChatLayout launcherChatLayout, ChatMessage chatMessage) {
        launcherChatLayout.l8(chatMessage);
        launcherChatLayout.i8(chatMessage);
    }

    public static final void S7(LauncherChatLayout launcherChatLayout, ChatMessage chatMessage) {
        launcherChatLayout.l8(chatMessage);
        launcherChatLayout.i8(chatMessage);
    }

    public static /* synthetic */ void V7(LauncherChatLayout launcherChatLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        launcherChatLayout.U7(z10);
    }

    public static final String V8(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getSessionId();
    }

    public static final boolean W8(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.length() > 0;
    }

    public static final void Y8(BaseInputView baseInputView, LauncherChatLayout launcherChatLayout) {
        if (baseInputView.U6()) {
            return;
        }
        BaseInputView.k6(baseInputView, false, false, 2, null);
        launcherChatLayout.T8();
        launcherChatLayout.S8();
        launcherChatLayout.M8();
        launcherChatLayout.L8();
    }

    public static final void a8(int i10, LauncherChatLayout launcherChatLayout) {
        if (i10 != launcherChatLayout.sessionSwitchGeneration) {
            return;
        }
        String str = launcherChatLayout.pendingSwitchSessionId;
        C4148a.u("LauncherChatLayout", "session switch guard timeout, force release generation=" + i10 + " expected=" + str, false, 4, null);
        launcherChatLayout.sessionSwitchGeneration = 0;
        launcherChatLayout.pendingSwitchSessionId = null;
        launcherChatLayout.switchGuardTimeoutRunnable = null;
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = launcherChatLayout.onSessionSwitchGuardTimeout;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(str);
        }
    }

    public static final boolean g8(long j10, ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getRole() == AgentRole.USER && it.getPairId().length() > 0 && it.getTime() >= j10 - 3000;
    }

    public static final boolean h8(ChatMessage chatMessage, ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getRole() == AgentRole.ASSISTANT && kotlin.jvm.internal.p.d(it.getPairId(), chatMessage.getPairId()) && it.getTime() >= chatMessage.getTime() - 3000;
    }

    public static final boolean j8(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getType() == AgentMessageType.TEXT;
    }

    public static final String k8(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return La.H.D1(it.getContent().h()).toString();
    }

    public static final Ka.j m8(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        List<AgentTool> listG = it.g();
        if (listG == null) {
            listG = C1173v.m();
        }
        return Z8.F.d0(listG);
    }

    public static final void o8(LauncherChatLayout launcherChatLayout) {
        if (launcherChatLayout.externalReplyAutoTtsSentAtMs == 0) {
            return;
        }
        if (launcherChatLayout.isAttachedToWindow()) {
            launcherChatLayout.Y5(false);
        } else {
            launcherChatLayout.Z8();
        }
    }

    public static final void t8(LauncherChatLayout launcherChatLayout) {
        launcherChatLayout.imeFrameCorrectionPosted = false;
        if (launcherChatLayout.imeFrameCorrectionPending) {
            launcherChatLayout.imeFrameCorrectionPending = false;
            if (launcherChatLayout.overlayReserveFrozenForIme && launcherChatLayout.pinLatestMessageForIme) {
                launcherChatLayout.x8();
            }
        }
    }

    public final void A8(String sessionId) {
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l;
        if (sessionId.length() == 0 || (interfaceC5074l = this.onSessionKeyVisible) == null) {
            return;
        }
        interfaceC5074l.invoke(sessionId);
    }

    public final void C8(int imeBottomPx, boolean showing) {
        if (this.keyboardScrollManagedExternally && this.overlayReserveFrozenForIme && this.pinLatestMessageForIme) {
            R8();
        }
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatui.U1
    public void D(int position, DisplayMessage item) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(item, "item");
        String str = item.getLikeStatus() == 2 ? "cancel" : "add";
        long jCurrentTimeMillis = System.currentTimeMillis();
        ChatTracker.INSTANCE.n(item.getSessionId(), item.getSessionId(), item.getMessageId(), "dislike", str, Long.valueOf(jCurrentTimeMillis), T7(item, jCurrentTimeMillis));
        super.D(position, item);
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatcore.InterfaceC1848c
    public void F(w4.e title, List<ChatMessage> messages) {
        kotlin.jvm.internal.p.i(messages, "messages");
        String str = this.pendingSwitchSessionId;
        Set<String> setU8 = U8(title, messages);
        if (this.sessionSwitchGeneration != 0 && str != null && str.length() != 0 && !setU8.isEmpty() && !setU8.contains(str)) {
            C4148a.u("LauncherChatLayout", "drop stale conversation callback: expected=" + str + " callbackIds=" + setU8, false, 4, null);
            return;
        }
        boolean z10 = this.skipNextHistoryAskUser;
        d8();
        this.lastFiredInquiryId = null;
        this.lastFiredApprovalId = null;
        super.F(title, messages);
        C4148a.d("LauncherChatLayout", "onChangeToConversation messages size:" + messages.size(), false, 4, null);
        p9.p<? super w4.e, ? super List<ChatMessage>, Y8.t> pVar = this.onCurrentConversationChanged;
        if (pVar != null) {
            pVar.invoke(title, messages);
        }
        if (z10) {
            this.skipNextHistoryAskUser = false;
        }
    }

    public final Pair<String, List<AskUserInquiry>> G8(AgentTool tool) {
        Object objB;
        Object objB2;
        String parameter;
        JSONArray jSONArrayOptJSONArray;
        AskUserInquiry askUserInquiry;
        String result;
        try {
            Result.Companion companion = Result.INSTANCE;
            result = tool.getResult();
            if (La.H.x0(result)) {
                result = null;
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (result == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(result);
        if (!jSONObject.optBoolean("ok", false)) {
            return null;
        }
        String strOptString = jSONObject.optString("inquiryId");
        kotlin.jvm.internal.p.f(strOptString);
        if (La.H.x0(strOptString)) {
            strOptString = null;
        }
        objB = Result.b(strOptString);
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            return null;
        }
        try {
            parameter = tool.getParameter();
            if (La.H.x0(parameter)) {
                parameter = null;
            }
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (parameter == null || (jSONArrayOptJSONArray = new JSONObject(parameter).optJSONArray("inquiries")) == null) {
            return null;
        }
        C5680i c5680iS = C5685n.s(0, jSONArrayOptJSONArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(((Z8.M) it).nextInt());
            if (jSONObjectOptJSONObject == null) {
                askUserInquiry = null;
            } else {
                String strOptString2 = jSONObjectOptJSONObject.optString("question");
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("choices");
                if (jSONArrayOptJSONArray2 != null) {
                    C5680i c5680iS2 = C5685n.s(0, jSONArrayOptJSONArray2.length());
                    ArrayList arrayList2 = new ArrayList(C1174w.x(c5680iS2, 10));
                    Iterator<Integer> it2 = c5680iS2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(jSONArrayOptJSONArray2.optString(((Z8.M) it2).nextInt()));
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : arrayList2) {
                        String str2 = (String) obj;
                        kotlin.jvm.internal.p.f(str2);
                        if (str2.length() > 0) {
                            arrayList3.add(obj);
                        }
                    }
                    kotlin.jvm.internal.p.f(strOptString2);
                    if (!La.H.x0(strOptString2) && !arrayList3.isEmpty()) {
                        askUserInquiry = new AskUserInquiry(strOptString2, arrayList3);
                    }
                }
                askUserInquiry = null;
            }
            if (askUserInquiry != null) {
                arrayList.add(askUserInquiry);
            }
        }
        objB2 = Result.b(arrayList);
        if (Result.g(objB2)) {
            objB2 = null;
        }
        List listM = (List) objB2;
        if (listM == null) {
            listM = C1173v.m();
        }
        if (listM.isEmpty()) {
            return null;
        }
        return Y8.j.a(str, listM);
    }

    public final void H8() {
        if (L4()) {
            H6("half:pin-prompt");
        }
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatcore.InterfaceC1848c
    public void I(final ChatMessage message, String oldMessageId) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(oldMessageId, "oldMessageId");
        super.I(message, oldMessageId);
        A8(message.getSessionId());
        if (message.getRole() == AgentRole.ASSISTANT) {
            post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.J6
                @Override // java.lang.Runnable
                public final void run() {
                    LauncherChatLayout.Q8(this.f25840a, message);
                }
            });
        }
    }

    public final void I8() {
        setAutomaticBottomScrollPaused(true);
        getAdapter().q0();
        d9();
        n6();
    }

    public final void J8() {
        final int i10 = this.scrollToBottomBlurGeneration + 1;
        this.scrollToBottomBlurGeneration = i10;
        getBtnScrollToBottom().post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.D6
            @Override // java.lang.Runnable
            public final void run() {
                LauncherChatLayout.K8(i10, this);
            }
        });
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatcore.InterfaceC1848c
    public void K(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        super.K(messageId);
        if (getEmptyShowEnable()) {
            return;
        }
        getMessageList().post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.K6
            @Override // java.lang.Runnable
            public final void run() {
                LauncherChatLayout.P8(this.f25859a);
            }
        });
    }

    public final void L8() {
        ChatMessage chatMessage = this.lastApprovalCandidate;
        if (chatMessage != null) {
            i8(chatMessage);
        }
    }

    public final void M8() {
        ChatMessage chatMessage = this.lastAskUserCandidate;
        if (chatMessage != null) {
            l8(chatMessage);
        }
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatcore.InterfaceC1848c
    public void O() {
        d8();
        super.O();
        p9.p<? super w4.e, ? super List<ChatMessage>, Y8.t> pVar = this.onCurrentConversationChanged;
        if (pVar != null) {
            pVar.invoke(null, C1173v.m());
        }
    }

    public final void O8() {
        this.scrollToBottomBlurGeneration++;
        B7.INSTANCE.d(this.scrollToBottomBlurHandle);
        this.scrollToBottomBlurHandle = null;
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatui.U1
    public void P(int position, DisplayMessage item) {
        kotlin.jvm.internal.p.i(item, "item");
        ChatTracker.INSTANCE.g(item.getSessionId(), item.getPairId(), item.getMessageId(), "open");
        super.P(position, item);
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatui.U1
    public void Q(int position, DisplayMessage item) {
        kotlin.jvm.internal.p.i(item, "item");
        ChatTracker.INSTANCE.h(item.getSessionId(), item.getSessionId(), item.getMessageId(), z8(item), "regenerate");
        super.Q(position, item);
    }

    public final void R8() {
        this.imeFrameCorrectionPending = true;
        if (this.imeFrameCorrectionPosted || !isAttachedToWindow()) {
            return;
        }
        this.imeFrameCorrectionPosted = true;
        getMessageList().postOnAnimation(this.imeFrameCorrectionRunnable);
    }

    public final void S8() {
        this.lastFiredApprovalId = null;
    }

    public final Long T7(DisplayMessage item, long actionTime) {
        if (item.getTime() <= 0) {
            return null;
        }
        Long lValueOf = Long.valueOf(actionTime - item.getTime());
        if (lValueOf.longValue() >= 0) {
            return lValueOf;
        }
        return null;
    }

    public final void T8() {
        this.lastFiredInquiryId = null;
    }

    public final void U7(boolean force) {
        if (this.overlayReserveFrozenForSheetEnter || this.overlayReserveFrozenForFloatingCard) {
            return;
        }
        if (force || !getAutomaticBottomScrollPaused() || getMessageList().getPaddingBottom() <= 0) {
            Integer numB8 = b8();
            if (numB8 != null) {
                this.pendingOverlayReservePx = numB8.intValue();
            }
            if (!this.overlayReserveFrozenForIme || force) {
                if (isShown() || force) {
                    int i10 = this.pendingOverlayReservePx;
                    if (getIsKeyboardVisible() && i10 < getMessageList().getPaddingBottom() && getMessageList().getPaddingBottom() - i10 <= this.imeReserveShrinkTolerancePx) {
                        this.pendingOverlayReservePx = getMessageList().getPaddingBottom();
                        C4148a.d("LauncherChatLayout", "skip shrinking overlay reserve while ime shown current=" + getMessageList().getPaddingBottom() + " measured=" + i10, false, 4, null);
                        InterfaceC5063a<Y8.t> interfaceC5063a = this.onOverlayGeometryChanged;
                        if (interfaceC5063a != null) {
                            interfaceC5063a.invoke();
                            return;
                        }
                        return;
                    }
                    boolean z10 = getMessageList().getPaddingBottom() != i10;
                    boolean z11 = getPaddingBottom() != 0;
                    if (z10) {
                        ChatRecycleView messageList = getMessageList();
                        messageList.setPadding(messageList.getPaddingLeft(), messageList.getPaddingTop(), messageList.getPaddingRight(), i10);
                        n6();
                        r5("overlay:reserve");
                    }
                    if (z11) {
                        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), 0);
                    }
                    W7(i10);
                    InterfaceC5063a<Y8.t> interfaceC5063a2 = this.onOverlayGeometryChanged;
                    if (interfaceC5063a2 != null) {
                        interfaceC5063a2.invoke();
                    }
                    if ((z10 || z11) && L4() && !this.overlayReserveFrozenForIme) {
                        H6("overlay:reserve");
                    }
                }
            }
        }
    }

    public final Set<String> U8(w4.e title, List<ChatMessage> messages) {
        String sessionId;
        Set setB = Z8.X.b();
        if (title != null && (sessionId = title.getSessionId()) != null) {
            if (sessionId.length() <= 0) {
                sessionId = null;
            }
            if (sessionId != null) {
                setB.add(sessionId);
            }
        }
        Iterator it = SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(Z8.F.d0(messages), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.M6
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return LauncherChatLayout.V8((ChatMessage) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.N6
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(LauncherChatLayout.W8((String) obj));
            }
        }).iterator();
        while (it.hasNext()) {
            setB.add((String) it.next());
        }
        return Z8.X.a(setB);
    }

    public final void W7(int reservePx) {
        if (this.scrollToBottomLifted) {
            return;
        }
        AgentChatLayout.Z6(this, 0, 0, 0, 0, 0, this.scrollToBottomBaseBottomMarginPx + reservePx, 0, 0, 0, null, 991, null);
    }

    public final void X7(long sentAtMs) {
        if (sentAtMs <= 0) {
            return;
        }
        this.externalReplyAutoTtsSentAtMs = sentAtMs;
        this.externalReplyAutoTtsDeadlineElapsedMs = SystemClock.elapsedRealtime() + 180000;
        this.externalReplyTargetPairId = "";
        this.externalReplyTerminalMessageId = "";
        this.externalReplyTerminalObservedElapsedMs = 0L;
        removeCallbacks(this.externalReplyAutoTtsPoll);
        Z8();
    }

    public final void X8(final BaseInputView input) {
        kotlin.jvm.internal.p.i(input, "input");
        if (input.U6()) {
            return;
        }
        input.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.U6
            @Override // java.lang.Runnable
            public final void run() {
                LauncherChatLayout.Y8(input, this);
            }
        });
    }

    public final void Y7(boolean showing) {
        if (this.keyboardScrollManagedExternally) {
            if (!this.overlayReserveFrozenForIme) {
                boolean z10 = L4() || P4();
                this.pinLatestMessageForIme = z10;
                this.overlayReserveFrozenForIme = true;
                C4148a.k("LauncherChatLayout", "ime transaction start showing=" + showing + " pinLatest=" + z10 + " following=" + L4(), false, 4, null);
                if (showing) {
                    U7(true);
                }
            }
            removeCallbacks(this.overlayImeFallbackRunnable);
            postDelayed(this.overlayImeFallbackRunnable, this.overlayImeFallbackDelayMs);
        }
    }

    public final void Z7(String expectedSessionId) {
        final int i10 = this.sessionSwitchGeneration + 1;
        this.sessionSwitchGeneration = i10;
        this.pendingSwitchSessionId = expectedSessionId;
        C4148a.d("LauncherChatLayout", "beginSessionSwitch generation=" + i10 + " expected=" + expectedSessionId, false, 4, null);
        Runnable runnable = this.switchGuardTimeoutRunnable;
        if (runnable != null) {
            getBtnScrollToBottom().removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.chat.view.V6
            @Override // java.lang.Runnable
            public final void run() {
                LauncherChatLayout.a8(i10, this);
            }
        };
        this.switchGuardTimeoutRunnable = runnable2;
        getBtnScrollToBottom().postDelayed(runnable2, 3000L);
    }

    public final void Z8() {
        removeCallbacks(this.externalReplyAutoTtsPoll);
        postDelayed(this.externalReplyAutoTtsPoll, 1000L);
    }

    public final void a9() {
        if (this.overlayReserveFrozenForSheetEnter || this.overlayReserveFrozenForFloatingCard) {
            return;
        }
        if (!getAutomaticBottomScrollPaused() || getMessageList().getPaddingBottom() <= 0) {
            Integer numB8 = b8();
            if (numB8 != null) {
                this.pendingOverlayReservePx = numB8.intValue();
            }
            if (this.overlayReserveFrozenForIme || this.overlayReserveSyncPosted || !isAttachedToWindow()) {
                return;
            }
            this.overlayReserveSyncPosted = true;
            postOnAnimation(this.overlayReserveSyncRunnable);
        }
    }

    public final Integer b8() {
        View view = this.overlayHeightSlot;
        if (view == null) {
            return null;
        }
        if (view.getVisibility() != 0 || view.getAlpha() <= 0.0f) {
            return Integer.valueOf(this.overlayReserveFloorPx);
        }
        if (!isAttachedToWindow() || !view.isAttachedToWindow() || view.getWidth() <= 0 || view.getHeight() <= 0 || getWidth() <= 0 || getHeight() <= 0) {
            return null;
        }
        return Integer.valueOf(C2774b7.a(this, view, this.overlayReserveFloorPx, this.overlayReserveAllowTallOverlap));
    }

    public final void b9() {
        this.skipNextHistoryAskUser = true;
    }

    public final void c8() {
        removeCallbacks(this.externalReplyAutoTtsPoll);
        this.externalReplyAutoTtsSentAtMs = 0L;
        this.externalReplyAutoTtsDeadlineElapsedMs = 0L;
        this.externalReplyTargetPairId = "";
        this.externalReplyTerminalMessageId = "";
        this.externalReplyTerminalObservedElapsedMs = 0L;
    }

    public final void c9() {
        a9();
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatui.U1
    public void d(int position, DisplayMessage item) {
        kotlin.jvm.internal.p.i(item, "item");
        ChatTracker.INSTANCE.g(item.getSessionId(), item.getPairId(), item.getMessageId(), "close");
        super.d(position, item);
    }

    public final void d8() {
        Runnable runnable = this.switchGuardTimeoutRunnable;
        if (runnable != null) {
            getBtnScrollToBottom().removeCallbacks(runnable);
        }
        this.switchGuardTimeoutRunnable = null;
        this.sessionSwitchGeneration = 0;
        this.pendingSwitchSessionId = null;
    }

    public final void d9() {
        U7(true);
    }

    public final boolean e8(List<ChatMessage> messages) {
        if (!this.skipNextHistoryAskUser) {
            return false;
        }
        if (messages.isEmpty()) {
            return true;
        }
        this.skipNextHistoryAskUser = false;
        return true;
    }

    public final void e9() {
        View view = this.overlayHeightSlot;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.overlayHeightListener);
        }
        this.overlayHeightSlot = null;
        this.pendingOverlayReservePx = this.overlayReserveFloorPx;
        this.overlayReserveFrozenForIme = false;
        this.overlayReserveFrozenForFloatingCard = false;
        this.overlayReserveFrozenForSheetEnter = false;
        this.overlayReserveAllowTallOverlap = false;
        this.pinLatestMessageForIme = false;
        this.imeFrameCorrectionPending = false;
        removeCallbacks(this.imeFrameCorrectionRunnable);
        this.imeFrameCorrectionPosted = false;
        removeCallbacks(this.overlayImeFallbackRunnable);
        removeCallbacks(this.overlayReserveSyncRunnable);
        this.overlayReserveSyncPosted = false;
        if (getMessageList().getPaddingBottom() != 0) {
            ChatRecycleView messageList = getMessageList();
            messageList.setPadding(messageList.getPaddingLeft(), messageList.getPaddingTop(), messageList.getPaddingRight(), 0);
        }
        int paddingBottom = getPaddingBottom();
        int i10 = this.overlayReserveFloorPx;
        if (paddingBottom != i10) {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), i10);
        }
        setScrollToBottomLiftedForFloatingCard(false);
        AgentChatLayout.Z6(this, 0, 0, 0, 0, 0, this.scrollToBottomBaseBottomMarginPx, 0, 0, 0, null, 991, null);
    }

    public final void f8(List<ChatMessage> messages) {
        Object next;
        final ChatMessage chatMessage;
        Object next2;
        Object next3;
        final long j10 = this.externalReplyAutoTtsSentAtMs;
        if (j10 == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime >= this.externalReplyAutoTtsDeadlineElapsedMs) {
            C4148a.u("LauncherChatLayout", "external reply TTS timed out", false, 4, null);
            c8();
            return;
        }
        if (this.externalReplyTargetPairId.length() == 0) {
            Iterator it = SequencesKt___SequencesKt.F(Z8.F.d0(messages), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.W6
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(LauncherChatLayout.g8(j10, (ChatMessage) obj));
                }
            }).iterator();
            if (it.hasNext()) {
                next3 = it.next();
                if (it.hasNext()) {
                    long time = ((ChatMessage) next3).getTime();
                    do {
                        Object next4 = it.next();
                        long time2 = ((ChatMessage) next4).getTime();
                        if (time < time2) {
                            next3 = next4;
                            time = time2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next3 = null;
            }
            chatMessage = (ChatMessage) next3;
            if (chatMessage != null) {
                this.externalReplyTargetPairId = chatMessage.getPairId();
            } else {
                chatMessage = null;
            }
        } else {
            Iterator<T> it2 = messages.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                ChatMessage chatMessage2 = (ChatMessage) next;
                if (chatMessage2.getRole() == AgentRole.USER && kotlin.jvm.internal.p.d(chatMessage2.getPairId(), this.externalReplyTargetPairId)) {
                    break;
                }
            }
            chatMessage = (ChatMessage) next;
        }
        if (chatMessage == null) {
            Z8();
            return;
        }
        Iterator it3 = SequencesKt___SequencesKt.F(Z8.F.d0(messages), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.E6
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(LauncherChatLayout.h8(chatMessage, (ChatMessage) obj));
            }
        }).iterator();
        if (it3.hasNext()) {
            next2 = it3.next();
            if (it3.hasNext()) {
                long time3 = ((ChatMessage) next2).getTime();
                do {
                    Object next5 = it3.next();
                    long time4 = ((ChatMessage) next5).getTime();
                    if (time3 < time4) {
                        next2 = next5;
                        time3 = time4;
                    }
                } while (it3.hasNext());
            }
        } else {
            next2 = null;
        }
        ChatMessage chatMessage3 = (ChatMessage) next2;
        if (chatMessage3 == null || !chatMessage3.getStatus().isTerminal()) {
            this.externalReplyTerminalMessageId = "";
            this.externalReplyTerminalObservedElapsedMs = 0L;
            Z8();
            return;
        }
        if (chatMessage3.getStatus() != EReplyStatus.COMPLETED) {
            Z8();
            return;
        }
        List<AgentMessage> listI = chatMessage3.i();
        if (!(listI instanceof Collection) || !listI.isEmpty()) {
            for (AgentMessage agentMessage : listI) {
                if (agentMessage.getType() == AgentMessageType.TEXT && !La.H.x0(agentMessage.getContent().h())) {
                    if (!kotlin.jvm.internal.p.d(this.externalReplyTerminalMessageId, chatMessage3.getMessageId())) {
                        this.externalReplyTerminalMessageId = chatMessage3.getMessageId();
                        this.externalReplyTerminalObservedElapsedMs = jElapsedRealtime;
                        Z8();
                        return;
                    } else {
                        if (jElapsedRealtime - this.externalReplyTerminalObservedElapsedMs < 1000) {
                            Z8();
                            return;
                        }
                        if (!J5(chatMessage3)) {
                            Z8();
                            return;
                        }
                        C4148a.k("LauncherChatLayout", "external reply auto TTS started messageId=" + chatMessage3.getMessageId(), false, 4, null);
                        c8();
                        return;
                    }
                }
            }
        }
        Z8();
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout
    public boolean getAutoScrollToBottomOnKeyboardShow() {
        return !this.keyboardScrollManagedExternally;
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout
    /* renamed from: getDeferBottomReconcileDuringKeyboard, reason: from getter */
    public boolean getKeyboardScrollManagedExternally() {
        return this.keyboardScrollManagedExternally;
    }

    public final boolean getIgnoreEmptySetMessages() {
        return this.ignoreEmptySetMessages;
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout
    public boolean getObserveKeyboardVisibilityFromInsets() {
        return !this.keyboardScrollManagedExternally;
    }

    public final p9.r<String, String, List<AskUserInquiry>, String, Boolean> getOnAskUserInquiry() {
        return this.onAskUserInquiry;
    }

    public final p9.p<w4.e, List<ChatMessage>, Y8.t> getOnCurrentConversationChanged() {
        return this.onCurrentConversationChanged;
    }

    public final InterfaceC5074l<List<ChatMessage>, Y8.t> getOnMessagesApplied() {
        return this.onMessagesApplied;
    }

    public final InterfaceC5063a<Y8.t> getOnOverlayGeometryChanged() {
        return this.onOverlayGeometryChanged;
    }

    public final InterfaceC5074l<String, Y8.t> getOnSessionKeyVisible() {
        return this.onSessionKeyVisible;
    }

    public final InterfaceC5074l<String, Y8.t> getOnSessionSwitchGuardTimeout() {
        return this.onSessionSwitchGuardTimeout;
    }

    public final p9.s<String, String, String, String, String, Boolean> getOnToolApproval() {
        return this.onToolApproval;
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatui.U1
    public void i(int position, DisplayMessage item) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(item, "item");
        String str = item.getLikeStatus() == 1 ? "cancel" : "add";
        long jCurrentTimeMillis = System.currentTimeMillis();
        ChatTracker.INSTANCE.n(item.getSessionId(), item.getSessionId(), item.getMessageId(), "like", str, Long.valueOf(jCurrentTimeMillis), T7(item, jCurrentTimeMillis));
        super.i(position, item);
    }

    public final void i8(ChatMessage msg) {
        Object next;
        Object next2;
        String approvalRequestId;
        String approvalRequestId2;
        if (msg.getRole() != AgentRole.ASSISTANT) {
            return;
        }
        this.lastApprovalCandidate = msg;
        if (this.onToolApproval == null) {
            return;
        }
        if (!isShown()) {
            removeCallbacks(this.recheckWhenShownRunnable);
            postDelayed(this.recheckWhenShownRunnable, 400L);
            return;
        }
        Iterator<T> it = getAdapter().G().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            com.stepos.agentframework.chatui.S1 s12 = (com.stepos.agentframework.chatui.S1) next;
            if ((s12 instanceof DisplayMessage) && !La.D.X(((DisplayMessage) s12).getMessageId(), "task-", false, 2, null)) {
                break;
            }
        }
        DisplayMessage displayMessage = next instanceof DisplayMessage ? (DisplayMessage) next : null;
        if (displayMessage != null && !kotlin.jvm.internal.p.d(displayMessage.getMessageId(), msg.getMessageId()) && (((approvalRequestId = msg.getApprovalRequestId()) == null || La.H.x0(approvalRequestId)) && !displayMessage.H() && ((approvalRequestId2 = displayMessage.getApprovalRequestId()) == null || La.H.x0(approvalRequestId2)))) {
            C4148a.k("LauncherChatLayout", "detectApproval skip latest mismatch latest=" + displayMessage.getMessageId() + " candidate=" + msg.getMessageId(), false, 4, null);
            return;
        }
        if (msg.getAskUserConversation() != null) {
            return;
        }
        List<AgentMessage> listI = msg.i();
        if (!(listI instanceof Collection) || !listI.isEmpty()) {
            Iterator<T> it2 = listI.iterator();
            while (it2.hasNext()) {
                List<AgentTool> listG = ((AgentMessage) it2.next()).g();
                if (listG == null) {
                    listG = C1173v.m();
                }
                List<AgentTool> list = listG;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it3 = list.iterator();
                    while (it3.hasNext()) {
                        if (kotlin.jvm.internal.p.d(((AgentTool) it3.next()).getName(), ASK_USER_TOOL_NAME)) {
                            return;
                        }
                    }
                }
            }
        }
        String approvalRequestId3 = msg.getApprovalRequestId();
        if (approvalRequestId3 != null) {
            String str = !La.H.x0(approvalRequestId3) ? approvalRequestId3 : null;
            if (str == null || kotlin.jvm.internal.p.d(str, this.lastFiredApprovalId)) {
                return;
            }
            this.lastFiredApprovalId = str;
            String string = getContext().getString(R$string.approval_request_title);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            Iterator it4 = SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.F(Z8.F.d0(msg.i()), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.G6
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(LauncherChatLayout.j8((AgentMessage) obj));
                }
            }), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.H6
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return LauncherChatLayout.k8((AgentMessage) obj);
                }
            }).iterator();
            while (true) {
                if (!it4.hasNext()) {
                    next2 = null;
                    break;
                } else {
                    next2 = it4.next();
                    if (((String) next2).length() > 0) {
                        break;
                    }
                }
            }
            String str2 = (String) next2;
            String str3 = (str2 == null || kotlin.jvm.internal.p.d(str2, string)) ? null : str2;
            C4148a.k("LauncherChatLayout", "detectApproval fire requestId=" + str + " sid=" + msg.getSessionId() + " messageId=" + msg.getMessageId(), false, 4, null);
            p9.s<? super String, ? super String, ? super String, ? super String, ? super String, Boolean> sVar = this.onToolApproval;
            if ((sVar == null || !sVar.invoke(msg.getSessionId(), str, msg.getMessageId(), string, str3).booleanValue()) && kotlin.jvm.internal.p.d(this.lastFiredApprovalId, str)) {
                this.lastFiredApprovalId = null;
            }
        }
    }

    public final void l8(ChatMessage msg) {
        Object next;
        Pair<String, List<AskUserInquiry>> pairG8;
        if (msg.getRole() != AgentRole.ASSISTANT) {
            return;
        }
        this.lastAskUserCandidate = msg;
        if (this.onAskUserInquiry == null) {
            return;
        }
        if (!isShown()) {
            removeCallbacks(this.recheckWhenShownRunnable);
            postDelayed(this.recheckWhenShownRunnable, 400L);
            return;
        }
        removeCallbacks(this.recheckWhenShownRunnable);
        Iterator<T> it = getAdapter().G().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            com.stepos.agentframework.chatui.S1 s12 = (com.stepos.agentframework.chatui.S1) next;
            if ((s12 instanceof DisplayMessage) && !La.D.X(((DisplayMessage) s12).getMessageId(), "task-", false, 2, null)) {
                break;
            }
        }
        DisplayMessage displayMessage = next instanceof DisplayMessage ? (DisplayMessage) next : null;
        String messageId = displayMessage != null ? displayMessage.getMessageId() : null;
        if (messageId == null || kotlin.jvm.internal.p.d(messageId, msg.getMessageId())) {
            Object obj = null;
            for (Object obj2 : SequencesKt___SequencesKt.L(Z8.F.d0(msg.i()), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.I6
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj3) {
                    return LauncherChatLayout.m8((AgentMessage) obj3);
                }
            })) {
                if (kotlin.jvm.internal.p.d(((AgentTool) obj2).getName(), ASK_USER_TOOL_NAME)) {
                    obj = obj2;
                }
            }
            AgentTool agentTool = (AgentTool) obj;
            if (agentTool == null || (pairG8 = G8(agentTool)) == null) {
                return;
            }
            String strA = pairG8.a();
            List<AskUserInquiry> listB = pairG8.b();
            if (com.stepos.agentframework.chatcore.session.K.c(msg, strA) || kotlin.jvm.internal.p.d(strA, this.lastFiredInquiryId)) {
                return;
            }
            this.lastFiredInquiryId = strA;
            C4148a.k("LauncherChatLayout", "detectAskUser fire inquiryId=" + strA + " questions=" + listB.size() + " sid=" + msg.getSessionId(), false, 4, null);
            p9.r<? super String, ? super String, ? super List<AskUserInquiry>, ? super String, Boolean> rVar = this.onAskUserInquiry;
            if ((rVar == null || !rVar.invoke(msg.getSessionId(), strA, listB, msg.getMessageId()).booleanValue()) && kotlin.jvm.internal.p.d(this.lastFiredInquiryId, strA)) {
                this.lastFiredInquiryId = null;
            }
        }
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatcore.InterfaceC1848c
    public void m(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        d8();
        super.m(sessionId);
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatcore.InterfaceC1848c
    public void n(final ChatMessage message, boolean playTts) {
        kotlin.jvm.internal.p.i(message, "message");
        super.n(message, playTts);
        A8(message.getSessionId());
        post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.F6
            @Override // java.lang.Runnable
            public final void run() {
                LauncherChatLayout.S7(this.f25774a, message);
            }
        });
    }

    public final void n8() {
        if (this.scrollToBottomDetachHooked) {
            return;
        }
        this.scrollToBottomDetachHooked = true;
        getBtnScrollToBottom().addOnAttachStateChangeListener(new b());
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a9();
        n8();
        J8();
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.recheckWhenShownRunnable);
        c8();
        this.overlayReserveFrozenForIme = false;
        this.overlayReserveFrozenForFloatingCard = false;
        this.overlayReserveAllowTallOverlap = false;
        this.pinLatestMessageForIme = false;
        this.imeFrameCorrectionPending = false;
        removeCallbacks(this.imeFrameCorrectionRunnable);
        this.imeFrameCorrectionPosted = false;
        removeCallbacks(this.overlayImeFallbackRunnable);
        removeCallbacks(this.overlayReserveSyncRunnable);
        this.overlayReserveSyncPosted = false;
        O8();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        if (h10 == oldh || h10 <= 0 || oldh <= 0 || this.overlayHeightSlot == null || this.overlayReserveAllowTallOverlap || getMessageList().getPaddingBottom() <= h10 / 2) {
            return;
        }
        C4148a.k("LauncherChatLayout", "overlay reserve stale after resize " + oldh + "->" + h10 + " pad=" + getMessageList().getPaddingBottom() + "; remeasure", false, 4, null);
        U7(true);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (changedView == this && visibility == 0) {
            a9();
        }
    }

    public final void p8(boolean showing) {
        if (this.overlayReserveFrozenForIme) {
            this.overlayReserveFrozenForIme = false;
            removeCallbacks(this.overlayImeFallbackRunnable);
            a9();
            if (!showing) {
                this.pinLatestMessageForIme = false;
            }
            C4148a.k("LauncherChatLayout", "ime transaction finish showing=" + showing + " pinLatest=" + this.pinLatestMessageForIme, false, 4, null);
        }
    }

    public final void q8(View slot) {
        kotlin.jvm.internal.p.i(slot, "slot");
        if (this.overlayHeightSlot != slot) {
            e9();
            this.overlayHeightSlot = slot;
            slot.addOnLayoutChangeListener(this.overlayHeightListener);
        }
        a9();
    }

    public final void r8(boolean freeze, boolean allowTallOverlap) {
        boolean z10 = !freeze && allowTallOverlap;
        boolean z11 = (this.overlayReserveFrozenForFloatingCard == freeze && this.overlayReserveAllowTallOverlap == z10) ? false : true;
        this.overlayReserveAllowTallOverlap = z10;
        this.overlayReserveFrozenForFloatingCard = freeze;
        if (z11) {
            if (!freeze) {
                a9();
                return;
            }
            Integer numValueOf = Integer.valueOf(getMessageList().getPaddingBottom());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf == null) {
                numValueOf = b8();
            }
            if (numValueOf != null) {
                this.pendingOverlayReservePx = numValueOf.intValue();
            }
        }
    }

    public final void s8(boolean freeze) {
        if (this.overlayReserveFrozenForSheetEnter == freeze) {
            return;
        }
        this.overlayReserveFrozenForSheetEnter = freeze;
        if (!freeze) {
            d9();
            return;
        }
        if (getMessageList().getPaddingBottom() > 0) {
            this.pendingOverlayReservePx = getMessageList().getPaddingBottom();
            return;
        }
        this.pendingOverlayReservePx = this.overlayReserveFloorPx;
        ChatRecycleView messageList = getMessageList();
        messageList.setPadding(messageList.getPaddingLeft(), messageList.getPaddingTop(), messageList.getPaddingRight(), this.overlayReserveFloorPx);
        W7(this.overlayReserveFloorPx);
    }

    public final void setIgnoreEmptySetMessages(boolean z10) {
        this.ignoreEmptySetMessages = z10;
    }

    public final void setKeyboardScrollManagedExternally(boolean managed) {
        this.keyboardScrollManagedExternally = managed;
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatcore.InterfaceC1848c
    public void setMessages(List<ChatMessage> messages) {
        kotlin.jvm.internal.p.i(messages, "messages");
        ChatMessage chatMessage = null;
        if (this.sessionSwitchGeneration != 0) {
            C4148a.d("LauncherChatLayout", "setMessages dropped during session switch: " + messages.size() + " msgs, generation=" + this.sessionSwitchGeneration, false, 4, null);
            return;
        }
        if (messages.isEmpty() && this.ignoreEmptySetMessages && !getAdapter().G().isEmpty()) {
            C4148a.k("LauncherChatLayout", "setMessages empty ignored: handoff adapter already has items", false, 4, null);
            return;
        }
        super.setMessages(messages);
        f8(messages);
        InterfaceC5074l<? super List<ChatMessage>, Y8.t> interfaceC5074l = this.onMessagesApplied;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(messages);
        }
        if (e8(messages)) {
            C4148a.d("LauncherChatLayout", "setMessages skip history ask_user detect, size=" + messages.size(), false, 4, null);
            return;
        }
        ListIterator<ChatMessage> listIterator = messages.listIterator(messages.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            ChatMessage chatMessagePrevious = listIterator.previous();
            if (!La.D.X(chatMessagePrevious.getMessageId(), "task-", false, 2, null)) {
                chatMessage = chatMessagePrevious;
                break;
            }
        }
        ChatMessage chatMessage2 = chatMessage;
        if (chatMessage2 != null) {
            l8(chatMessage2);
            i8(chatMessage2);
        }
    }

    public final void setOnAskUserInquiry(p9.r<? super String, ? super String, ? super List<AskUserInquiry>, ? super String, Boolean> rVar) {
        this.onAskUserInquiry = rVar;
    }

    public final void setOnCurrentConversationChanged(p9.p<? super w4.e, ? super List<ChatMessage>, Y8.t> pVar) {
        this.onCurrentConversationChanged = pVar;
    }

    public final void setOnMessagesApplied(InterfaceC5074l<? super List<ChatMessage>, Y8.t> interfaceC5074l) {
        this.onMessagesApplied = interfaceC5074l;
    }

    public final void setOnOverlayGeometryChanged(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onOverlayGeometryChanged = interfaceC5063a;
    }

    public final void setOnSessionKeyVisible(InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        this.onSessionKeyVisible = interfaceC5074l;
    }

    public final void setOnSessionSwitchGuardTimeout(InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        this.onSessionSwitchGuardTimeout = interfaceC5074l;
    }

    public final void setOnToolApproval(p9.s<? super String, ? super String, ? super String, ? super String, ? super String, Boolean> sVar) {
        this.onToolApproval = sVar;
    }

    public final void setScrollToBottomBlurCrossWindow(boolean crossWindow) {
        this.scrollToBottomBlurCrossWindow = crossWindow;
    }

    public final void setScrollToBottomLiftedForFloatingCard(boolean lifted) {
        if (this.scrollToBottomLifted == lifted) {
            return;
        }
        this.scrollToBottomLifted = lifted;
        AgentChatLayout.Z6(this, 0, 0, 0, 0, 0, lifted ? (int) (getResources().getDisplayMetrics().density * SCROLL_TO_BOTTOM_FLOAT_CARD_MARGIN_DP) : this.scrollToBottomBaseBottomMarginPx + this.pendingOverlayReservePx, 0, 0, 0, null, 991, null);
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatui.U1
    public void t(int position, DisplayMessage item) {
        kotlin.jvm.internal.p.i(item, "item");
        ChatTracker.INSTANCE.h(item.getSessionId(), item.getSessionId(), item.getMessageId(), z8(item), ChatTracker.CLICK_DELETE);
        super.t(position, item);
    }

    public final void u8() {
        if (this.scrollToBottomBlurDetachWatcherInstalled) {
            return;
        }
        this.scrollToBottomBlurDetachWatcherInstalled = true;
        getBtnScrollToBottom().addOnAttachStateChangeListener(new c());
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatui.U1
    public boolean v() {
        return this.onToolApproval != null;
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout
    public void v5() {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (X6.b(context) == null && com.stepos.ailauncher.container.m0.INSTANCE.h()) {
            post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.L6
                @Override // java.lang.Runnable
                public final void run() {
                    LauncherChatLayout.B8(this.f25867a);
                }
            });
        }
    }

    public final boolean v8() {
        return L4() || P4() || getMessageList().m();
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout
    public void w5(boolean visible) {
        super.w5(visible);
        p8(visible);
    }

    public final boolean w8() {
        return this.sessionSwitchGeneration != 0;
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout
    public void x5() {
        super.x5();
        if (L4()) {
            H6("keyboard:end");
        }
    }

    public final void x8() {
        if (!getAutomaticBottomScrollPaused() && isAttachedToWindow() && isShown() && this.pinLatestMessageForIme && L4() && getAdapter().getItemCount() != 0 && getMessageList().getAdapter() == getAdapter() && getMessageList().isLaidOut() && !getMessageList().isComputingLayout()) {
            RecyclerView.LayoutManager layoutManager = getMessageList().getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager == null) {
                return;
            }
            View viewFindViewByPosition = linearLayoutManager.findViewByPosition(0);
            if (viewFindViewByPosition == null) {
                linearLayoutManager.scrollToPositionWithOffset(0, 0);
                return;
            }
            int decoratedBottom = linearLayoutManager.getDecoratedBottom(viewFindViewByPosition) - (getMessageList().getHeight() - getMessageList().getPaddingBottom());
            if (Math.abs(decoratedBottom) > 1) {
                if (!getIsKeyboardVisible() || decoratedBottom >= 0) {
                    getMessageList().scrollBy(0, decoratedBottom);
                }
            }
        }
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout
    public void y5(boolean visible) {
        super.y5(visible);
        Y7(visible);
    }

    public final Integer y8() {
        return b8();
    }

    @Override // com.stepos.agentframework.chatui.AgentChatLayout, com.stepos.agentframework.chatui.U1
    public void z(int position, DisplayMessage item) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(item, "item");
        ChatTracker.INSTANCE.h(item.getSessionId(), item.getSessionId(), item.getMessageId(), z8(item), ChatTracker.CLICK_COPY);
        super.z(position, item);
    }

    public final String z8(DisplayMessage item) {
        return item.getRole() == AgentRole.USER ? ChatTracker.SOURCE_USER_MESSAGE : ChatTracker.SOURCE_ASSISTANT_MESSAGE;
    }
}
