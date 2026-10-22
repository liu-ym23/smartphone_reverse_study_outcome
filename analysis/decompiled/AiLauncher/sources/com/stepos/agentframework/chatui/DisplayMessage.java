package com.stepos.agentframework.chatui;

import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.audit.RunBlockedEvent;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.deepbinder.core.constant.Constants;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.AskUserConversation;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import u4.m;
import v9.C5685n;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\bW\b\u0086\b\u0018\u0000  \u00012\u00020\u0001:\u0001;BÃ\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0010\u0012\b\b\u0002\u0010%\u001a\u00020\f\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010'\u001a\u00020\u0014\u0012\b\b\u0002\u0010(\u001a\u00020\u0014\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\b\b\u0002\u0010*\u001a\u00020\u0017¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\nH\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00172\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00172\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b4\u00103J\r\u00105\u001a\u00020\u0017¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\f¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0017¢\u0006\u0004\b9\u00106J\r\u0010:\u001a\u00020\u0017¢\u0006\u0004\b:\u00106J\u000f\u0010;\u001a\u00020\u0014H\u0016¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u0017¢\u0006\u0004\b=\u00106J\r\u0010>\u001a\u00020\u0014¢\u0006\u0004\b>\u0010<J\u0015\u0010@\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0000¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020\u0017¢\u0006\u0004\bB\u00106J\u0017\u0010D\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0000H\u0000¢\u0006\u0004\bD\u0010AJÌ\u0002\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00102\b\b\u0002\u0010%\u001a\u00020\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020\u00142\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\b\b\u0002\u0010*\u001a\u00020\u0017HÆ\u0001¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\bI\u0010<J\u001a\u0010L\u001a\u00020\u00172\b\u0010K\u001a\u0004\u0018\u00010JHÖ\u0003¢\u0006\u0004\bL\u0010MR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010N\u001a\u0004\bO\u0010H\"\u0004\bP\u0010QR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010N\u001a\u0004\bR\u0010H\"\u0004\bS\u0010QR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010N\u001a\u0004\bT\u0010H\"\u0004\bU\u0010QR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010N\u001a\u0004\bV\u0010H\"\u0004\bW\u0010QR\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010N\u001a\u0004\bX\u0010H\"\u0004\bY\u0010QR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010N\u001a\u0004\bZ\u0010H\"\u0004\b[\u0010QR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00102\u001a\u0004\ba\u00108\"\u0004\bb\u0010cR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\\\u001a\u0004\bi\u0010^\"\u0004\bj\u0010`R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010D\u001a\u0004\bp\u0010<\"\u0004\bq\u0010rR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010N\u001a\u0004\bs\u0010H\"\u0004\bt\u0010QR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010u\u001a\u0004\bv\u00106\"\u0004\bu\u0010wR\"\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010D\u001a\u0004\bx\u0010<\"\u0004\by\u0010rR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010N\u001a\u0004\bz\u0010H\"\u0004\b{\u0010QR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010N\u001a\u0004\b|\u0010H\"\u0004\b}\u0010QR%\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b\u001d\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R'\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u001f\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R&\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b \u0010N\u001a\u0005\b\u0088\u0001\u0010H\"\u0005\b\u0089\u0001\u0010QR)\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\"\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R,\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b$\u0010\\\u001a\u0005\b\u008f\u0001\u0010^\"\u0005\b\u0090\u0001\u0010`R$\u0010%\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b%\u00102\u001a\u0005\b\u0091\u0001\u00108\"\u0005\b\u0092\u0001\u0010cR)\u0010&\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b&\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R$\u0010'\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b'\u0010D\u001a\u0005\b\u0098\u0001\u0010<\"\u0005\b\u0099\u0001\u0010rR$\u0010(\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b(\u0010D\u001a\u0005\b\u009a\u0001\u0010<\"\u0005\b\u009b\u0001\u0010rR,\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b)\u0010\\\u001a\u0005\b\u009c\u0001\u0010^\"\u0005\b\u009d\u0001\u0010`R$\u0010*\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b*\u0010u\u001a\u0005\b\u009e\u0001\u00106\"\u0005\b\u009f\u0001\u0010w¨\u0006¡\u0001"}, d2 = {"Lcom/stepos/agentframework/chatui/N1;", "Lcom/stepos/agentframework/chatui/r1;", "", "messageId", "pairId", DidiCardProvider.KEY_TRACE_ID, "sessionId", "requestSessionId", "agentId", "", "Lcom/stepos/agentframework/chatui/J1;", "message", "", "time", "Lcom/stepos/agentframework/chatcore/session/AgentRole;", BundleContentBridge.KEY_ROLE, "", "suggestions", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "status", "", "likeStatus", "viewSpliteId", "", "needActionBarShow", "errorCode", "errorMessage", "serverItemId", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "hint", "Lcom/stepos/agentframework/chatui/SendState;", "sendState", "approvalRequestId", "LK6/d;", "askUserConversation", "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "processingStartAtMs", "processingDurationMs", "variantIndex", "variantCount", "uiActions", "releaseHeldCards", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLcom/stepos/agentframework/chatcore/session/AgentRole;Ljava/util/List;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;ILjava/lang/String;ZILjava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/ChatHintType;Lcom/stepos/agentframework/chatui/SendState;Ljava/lang/String;LK6/d;Ljava/util/List;JLjava/lang/Long;IILjava/util/List;Z)V", "part", "K", "(Lcom/stepos/agentframework/chatui/J1;)Z", "Lcom/stepos/agentframework/chatui/P1;", "tool", "J", "(Lcom/stepos/agentframework/chatui/P1;)Z", "N", "F", "()Z", "M", "()J", "c", "G", Const.INTENT_KEY_APIKEY, "()I", "O", "L", "existing", "P", "(Lcom/stepos/agentframework/chatui/N1;)Z", "H", Constants.PARAM_REPLY, "I", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLcom/stepos/agentframework/chatcore/session/AgentRole;Ljava/util/List;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;ILjava/lang/String;ZILjava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/ChatHintType;Lcom/stepos/agentframework/chatui/SendState;Ljava/lang/String;LK6/d;Ljava/util/List;JLjava/lang/Long;IILjava/util/List;Z)Lcom/stepos/agentframework/chatui/N1;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "n", "Y", "(Ljava/lang/String;)V", "p", "a0", "B", "n0", "w", "i0", "t", "e0", "f", "Q", "Ljava/util/List;", "m", "()Ljava/util/List;", "X", "(Ljava/util/List;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "m0", "(J)V", "Lcom/stepos/agentframework/chatcore/session/AgentRole;", "u", "()Lcom/stepos/agentframework/chatcore/session/AgentRole;", "f0", "(Lcom/stepos/agentframework/chatcore/session/AgentRole;)V", "z", "l0", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "y", "()Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "k0", "(Lcom/stepos/agentframework/chatcore/session/EReplyStatus;)V", "l", ExifInterface.LONGITUDE_WEST, "(I)V", "getViewSpliteId", "r0", "Z", "o", "(Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, ExifInterface.GPS_DIRECTION_TRUE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "U", "getServerItemId", "h0", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "k", "()Lcom/stepos/agentframework/chatcore/session/ChatHintType;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcom/stepos/agentframework/chatcore/session/ChatHintType;)V", "Lcom/stepos/agentframework/chatui/SendState;", "v", "()Lcom/stepos/agentframework/chatui/SendState;", "g0", "(Lcom/stepos/agentframework/chatui/SendState;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "R", "LK6/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()LK6/d;", ExifInterface.LATITUDE_SOUTH, "(LK6/d;)V", "x", "j0", "r", "c0", "Ljava/lang/Long;", "q", "()Ljava/lang/Long;", "b0", "(Ljava/lang/Long;)V", ExifInterface.LONGITUDE_EAST, "q0", "D", "p0", "C", "o0", "s", "d0", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.N1, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class DisplayMessage extends AbstractC2044r1 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String agentId;
    private String approvalRequestId;
    private AskUserConversation askUserConversation;
    private int errorCode;
    private String errorMessage;
    private ChatHintType hint;
    private int likeStatus;
    private List<DisplayChatMessage> message;
    private String messageId;
    private boolean needActionBarShow;
    private String pairId;
    private Long processingDurationMs;
    private long processingStartAtMs;
    private boolean releaseHeldCards;
    private String requestSessionId;
    private AgentRole role;
    private SendState sendState;
    private String serverItemId;
    private String sessionId;
    private List<ReferenceSource> sources;
    private EReplyStatus status;
    private List<String> suggestions;
    private long time;
    private String traceId;
    private List<String> uiActions;
    private int variantCount;
    private int variantIndex;
    private String viewSpliteId;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002¢\u0006\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatui/N1$a;", "", "<init>", "()V", "Lw4/c;", "msg", "Lcom/stepos/agentframework/chatui/N1;", Const.INTENT_KEY_UMID, "(Lw4/c;)Lcom/stepos/agentframework/chatui/N1;", "", "messages", "", "e", "(Ljava/util/List;)Ljava/util/List;", "message", "", "", "failedPairIds", "lastUser", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lw4/c;Ljava/util/Set;Lw4/c;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw4/c;)Z", "k", "l", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.N1$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final boolean f(ChatMessage it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.getRole() == AgentRole.USER && it.getSendFailed();
        }

        public static final String g(ChatMessage it) {
            kotlin.jvm.internal.p.i(it, "it");
            String pairId = it.getPairId();
            return pairId.length() == 0 ? it.getMessageId() : pairId;
        }

        public static final boolean h(String it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.length() > 0;
        }

        public final DisplayMessage d(ChatMessage msg) {
            kotlin.jvm.internal.p.i(msg, "msg");
            q4.j.INSTANCE.d(msg.i());
            DisplayMessage displayMessage = new DisplayMessage(null, null, null, null, null, null, null, 0L, null, null, null, 0, null, false, 0, null, null, null, null, null, null, null, 0L, null, 0, 0, null, false, 268435455, null);
            displayMessage.Y(msg.getMessageId());
            displayMessage.i0(msg.getSessionId());
            displayMessage.e0(msg.getRequestSessionId());
            displayMessage.Q(msg.getAgentId());
            List<AgentMessage> listI = msg.i();
            ArrayList arrayList = new ArrayList(C1174w.x(listI, 10));
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                arrayList.add(DisplayChatMessage.INSTANCE.a((AgentMessage) it.next()));
            }
            List<DisplayChatMessage> listP1 = Z8.F.p1(arrayList);
            C2047s1.INSTANCE.a(listP1);
            displayMessage.X(listP1);
            displayMessage.m0(msg.getTime());
            displayMessage.f0(msg.getRole());
            displayMessage.l0(msg.u());
            displayMessage.k0(msg.getStatus());
            displayMessage.r0(msg.getViewSpliteId());
            displayMessage.W(msg.getIsLike());
            displayMessage.h0(msg.getServerItemId());
            displayMessage.a0(msg.getPairId());
            displayMessage.n0(msg.getTraceId());
            displayMessage.U(msg.getErrorMessage());
            displayMessage.T(msg.getErrorCode());
            boolean z10 = false;
            List<ReferenceSource> list = null;
            if (!La.D.X(msg.getMessageId(), RunBlockedEvent.AUDIT_BLOCKED_REPLY_PREFIX, false, 2, null) && !La.D.X(msg.getMessageId(), RunBlockedEvent.PRIVACY_BLOCKED_REPLY_PREFIX, false, 2, null)) {
                z10 = true;
            }
            displayMessage.Z(z10);
            displayMessage.V(msg.getHint());
            displayMessage.g0(msg.getSendFailed() ? SendState.FAILED : SendState.SENT);
            displayMessage.R(msg.getApprovalRequestId());
            displayMessage.S(msg.getAskUserConversation());
            List<ReferenceSource> listS = msg.s();
            if (listS != null && !listS.isEmpty()) {
                list = listS;
            }
            displayMessage.j0(list);
            displayMessage.c0(msg.getProcessingStartAtMs());
            displayMessage.b0(msg.getProcessingDurationMs());
            displayMessage.q0(msg.getVariantIndex());
            displayMessage.p0(msg.getVariantCount());
            displayMessage.o0(msg.x());
            return displayMessage;
        }

        public final List<DisplayMessage> e(List<ChatMessage> messages) {
            ChatMessage chatMessagePrevious;
            kotlin.jvm.internal.p.i(messages, "messages");
            List<ChatMessage> listL = l(messages);
            HashSet hashSetC0 = SequencesKt___SequencesKt.c0(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.F(Z8.F.d0(listL), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.K1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(DisplayMessage.Companion.f((ChatMessage) obj));
                }
            }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.L1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DisplayMessage.Companion.g((ChatMessage) obj);
                }
            }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.M1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(DisplayMessage.Companion.h((String) obj));
                }
            }));
            ListIterator<ChatMessage> listIterator = listL.listIterator(listL.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    chatMessagePrevious = null;
                    break;
                }
                chatMessagePrevious = listIterator.previous();
                if (chatMessagePrevious.getRole() == AgentRole.USER) {
                    break;
                }
            }
            ChatMessage chatMessage = chatMessagePrevious;
            ArrayList arrayList = new ArrayList();
            for (ChatMessage chatMessage2 : listL) {
                Companion companion = DisplayMessage.INSTANCE;
                if (!companion.i(chatMessage2) && !companion.k(chatMessage2) && !companion.j(chatMessage2, hashSetC0, chatMessage)) {
                    arrayList.add(companion.d(chatMessage2));
                }
            }
            return arrayList;
        }

        public final boolean i(ChatMessage message) {
            if (message.getRole() == AgentRole.ASSISTANT && message.getStatus() == EReplyStatus.CANCELED) {
                return (message.getHint() == ChatHintType.NONE || message.getHint() == ChatHintType.TIMEOUT || message.getHint() == ChatHintType.AGENT_OFFLINE) && com.stepos.agentframework.chatcore.session.K.e(message);
            }
            return false;
        }

        public final boolean j(ChatMessage message, Set<String> failedPairIds, ChatMessage lastUser) {
            if (message.getRole() != AgentRole.ASSISTANT || message.getStatus() != EReplyStatus.START || !com.stepos.agentframework.chatcore.session.K.e(message)) {
                return false;
            }
            String pairId = message.getPairId();
            if (pairId.length() <= 0 || !failedPairIds.contains(pairId)) {
                return lastUser != null && lastUser.getSendFailed() && message.getTime() >= lastUser.getTime();
            }
            return true;
        }

        public final boolean k(ChatMessage message) {
            return message.getRole() == AgentRole.ASSISTANT && message.getStatus() == EReplyStatus.CANCELED && message.getHint() == ChatHintType.STOPPED && com.stepos.agentframework.chatcore.session.K.e(message);
        }

        public final List<ChatMessage> l(List<ChatMessage> messages) {
            if (messages.size() < 2) {
                return messages;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (ChatMessage chatMessage : messages) {
                String pairId = chatMessage.getPairId();
                if (pairId.length() == 0) {
                    pairId = chatMessage.getMessageId();
                }
                Object arrayList = linkedHashMap.get(pairId);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(pairId, arrayList);
                }
                ((List) arrayList).add(chatMessage);
            }
            ArrayList arrayList2 = new ArrayList(messages.size());
            Collection<List> collectionValues = linkedHashMap.values();
            kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
            for (List list : collectionValues) {
                if (list.size() == 1) {
                    arrayList2.add(list.get(0));
                } else {
                    kotlin.jvm.internal.p.f(list);
                    List list2 = list;
                    for (Object obj : list2) {
                        if (((ChatMessage) obj).getRole() == AgentRole.USER) {
                            arrayList2.add(obj);
                        }
                    }
                    for (Object obj2 : list2) {
                        if (((ChatMessage) obj2).getRole() != AgentRole.USER) {
                            arrayList2.add(obj2);
                        }
                    }
                }
            }
            return arrayList2;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.N1$b */
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentMessageType.values().length];
            try {
                iArr[AgentMessageType.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentMessageType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentMessageType.IMAGE_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AgentMessageType.FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AgentMessageType.THINKING_TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AgentMessageType.TOOL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AgentMessageType.INQUIRY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DisplayMessage() {
        this(null, null, null, null, null, null, null, 0L, null, null, null, 0, null, false, 0, null, null, null, null, null, null, null, 0L, null, 0, 0, null, false, 268435455, null);
    }

    public static /* synthetic */ DisplayMessage e(DisplayMessage displayMessage, String str, String str2, String str3, String str4, String str5, String str6, List list, long j10, AgentRole agentRole, List list2, EReplyStatus eReplyStatus, int i10, String str7, boolean z10, int i11, String str8, String str9, ChatHintType chatHintType, SendState sendState, String str10, AskUserConversation askUserConversation, List list3, long j11, Long l10, int i12, int i13, List list4, boolean z11, int i14, Object obj) {
        boolean z12;
        List list5;
        String str11 = (i14 & 1) != 0 ? displayMessage.messageId : str;
        String str12 = (i14 & 2) != 0 ? displayMessage.pairId : str2;
        String str13 = (i14 & 4) != 0 ? displayMessage.traceId : str3;
        String str14 = (i14 & 8) != 0 ? displayMessage.sessionId : str4;
        String str15 = (i14 & 16) != 0 ? displayMessage.requestSessionId : str5;
        String str16 = (i14 & 32) != 0 ? displayMessage.agentId : str6;
        List list6 = (i14 & 64) != 0 ? displayMessage.message : list;
        long j12 = (i14 & 128) != 0 ? displayMessage.time : j10;
        AgentRole agentRole2 = (i14 & 256) != 0 ? displayMessage.role : agentRole;
        List list7 = (i14 & 512) != 0 ? displayMessage.suggestions : list2;
        EReplyStatus eReplyStatus2 = (i14 & 1024) != 0 ? displayMessage.status : eReplyStatus;
        int i15 = (i14 & 2048) != 0 ? displayMessage.likeStatus : i10;
        String str17 = (i14 & 4096) != 0 ? displayMessage.viewSpliteId : str7;
        String str18 = str11;
        boolean z13 = (i14 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? displayMessage.needActionBarShow : z10;
        int i16 = (i14 & 16384) != 0 ? displayMessage.errorCode : i11;
        String str19 = (i14 & 32768) != 0 ? displayMessage.errorMessage : str8;
        String str20 = (i14 & 65536) != 0 ? displayMessage.serverItemId : str9;
        ChatHintType chatHintType2 = (i14 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? displayMessage.hint : chatHintType;
        SendState sendState2 = (i14 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? displayMessage.sendState : sendState;
        String str21 = (i14 & 524288) != 0 ? displayMessage.approvalRequestId : str10;
        AskUserConversation askUserConversation2 = (i14 & 1048576) != 0 ? displayMessage.askUserConversation : askUserConversation;
        List list8 = (i14 & 2097152) != 0 ? displayMessage.sources : list3;
        int i17 = i16;
        long j13 = (i14 & 4194304) != 0 ? displayMessage.processingStartAtMs : j11;
        Long l11 = (i14 & 8388608) != 0 ? displayMessage.processingDurationMs : l10;
        int i18 = (i14 & 16777216) != 0 ? displayMessage.variantIndex : i12;
        Long l12 = l11;
        int i19 = (i14 & Const.FLAG_MUTABLE) != 0 ? displayMessage.variantCount : i13;
        List list9 = (i14 & 67108864) != 0 ? displayMessage.uiActions : list4;
        if ((i14 & 134217728) != 0) {
            list5 = list9;
            z12 = displayMessage.releaseHeldCards;
        } else {
            z12 = z11;
            list5 = list9;
        }
        return displayMessage.d(str18, str12, str13, str14, str15, str16, list6, j12, agentRole2, list7, eReplyStatus2, i15, str17, z13, i17, str19, str20, chatHintType2, sendState2, str21, askUserConversation2, list8, j13, l12, i18, i19, list5, z12);
    }

    /* renamed from: A, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: B, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final List<String> C() {
        return this.uiActions;
    }

    /* renamed from: D, reason: from getter */
    public final int getVariantCount() {
        return this.variantCount;
    }

    /* renamed from: E, reason: from getter */
    public final int getVariantIndex() {
        return this.variantIndex;
    }

    public final boolean F() {
        List<DisplayTool> listF;
        if (this.role != AgentRole.ASSISTANT) {
            return false;
        }
        if (this.processingStartAtMs > 0 || this.status == EReplyStatus.TOOL_EXECUTING) {
            return true;
        }
        List<DisplayChatMessage> list = this.message;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (DisplayChatMessage j12 : list) {
            if (j12.getType() == AgentMessageType.TOOL && (listF = j12.f()) != null && !listF.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean G() {
        return kotlin.p.INSTANCE.a(this.variantCount);
    }

    public final boolean H() {
        List<DisplayTool> listF;
        if (this.message.isEmpty()) {
            return true;
        }
        if (this.message.size() == 1) {
            DisplayChatMessage j12 = this.message.get(0);
            if (j12.getType() == AgentMessageType.TEXT && j12.getDeepThinkText().length() == 0 && j12.getContent().h().length() == 0 && ((listF = j12.f()) == null || listF.isEmpty())) {
                return true;
            }
        }
        return false;
    }

    public final boolean I(DisplayMessage reply) {
        kotlin.jvm.internal.p.i(reply, "reply");
        AgentRole agentRole = this.role;
        AgentRole agentRole2 = AgentRole.ASSISTANT;
        if (agentRole != agentRole2 || reply.role != agentRole2 || La.H.x0(this.messageId) || La.H.x0(reply.messageId) || kotlin.jvm.internal.p.d(this.messageId, reply.messageId) || La.H.x0(this.sessionId) || !kotlin.jvm.internal.p.d(this.sessionId, reply.sessionId) || La.H.x0(this.pairId) || !kotlin.jvm.internal.p.d(this.pairId, reply.pairId) || this.variantIndex != reply.variantIndex || this.variantCount != reply.variantCount) {
            return false;
        }
        if ((!La.H.x0(this.traceId) && !La.H.x0(reply.traceId) && !kotlin.jvm.internal.p.d(this.traceId, reply.traceId)) || this.status != EReplyStatus.START || !H()) {
            return false;
        }
        String str = this.approvalRequestId;
        if ((str != null && !La.H.x0(str)) || this.askUserConversation != null || this.hint != ChatHintType.NONE || this.errorCode != 0 || this.errorMessage.length() != 0) {
            return false;
        }
        List<String> list = this.suggestions;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        List<ReferenceSource> list2 = this.sources;
        if ((list2 != null && !list2.isEmpty()) || this.processingStartAtMs != 0) {
            return false;
        }
        List<DisplayChatMessage> list3 = this.message;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (!(((DisplayChatMessage) it.next()).getContent() instanceof m.TextMessage)) {
                    return false;
                }
            }
        }
        return (reply.status == EReplyStatus.START && reply.H()) ? false : true;
    }

    public final boolean J(DisplayTool tool) {
        AppUIData appUIDataC = tool.getAppUIData();
        return appUIDataC != null && appUIDataC.getUiType() == AppUIData.INSTANCE.c();
    }

    public final boolean K(DisplayChatMessage part) {
        int i10 = b.$EnumSwitchMapping$0[part.getType().ordinal()];
        if (i10 == 1) {
            return part.getContent().h().length() == 0;
        }
        if (i10 == 5) {
            return part.getDeepThinkText().length() == 0;
        }
        if (i10 != 6) {
            return false;
        }
        List<DisplayTool> listF = part.f();
        List<DisplayTool> list = listF;
        if (list != null && !list.isEmpty()) {
            List<DisplayTool> list2 = listF;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (DisplayTool p12 : list2) {
                    if ((!p12.k() && !J(p12)) || N(p12)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final int L() {
        int length = 0;
        for (DisplayChatMessage j12 : this.message) {
            length += j12.getType() == AgentMessageType.TEXT ? j12.getContent().h().length() : 0;
        }
        return length;
    }

    public final long M() {
        if (this.status.isTerminal() || !F()) {
            return 0L;
        }
        long j10 = this.processingStartAtMs;
        return j10 > 0 ? j10 : C5685n.g(this.time, 0L);
    }

    public final boolean N(DisplayTool tool) {
        AppUIData appUIDataC = tool.getAppUIData();
        return (appUIDataC == null || appUIDataC.isFixed() || appUIDataC.getUiType() == AppUIData.INSTANCE.c()) ? false : true;
    }

    public final boolean O() {
        if (this.role != AgentRole.ASSISTANT || this.status != EReplyStatus.COMPLETED || this.errorCode != 0 || this.errorMessage.length() > 0) {
            return false;
        }
        String str = this.approvalRequestId;
        if ((str != null && !La.H.x0(str)) || this.askUserConversation != null) {
            return false;
        }
        List<String> list = this.suggestions;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        List<ReferenceSource> list2 = this.sources;
        if ((list2 != null && !list2.isEmpty()) || this.hint != ChatHintType.NONE) {
            return false;
        }
        if (this.message.isEmpty()) {
            return true;
        }
        List<DisplayChatMessage> list3 = this.message;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            return true;
        }
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            if (!K((DisplayChatMessage) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean P(DisplayMessage existing) {
        kotlin.jvm.internal.p.i(existing, "existing");
        AgentRole agentRole = this.role;
        AgentRole agentRole2 = AgentRole.ASSISTANT;
        if (agentRole != agentRole2 || existing.role != agentRole2 || existing.L() <= L()) {
            return false;
        }
        List<DisplayChatMessage> list = existing.message;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((DisplayChatMessage) obj).getType() == AgentMessageType.TEXT) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        List<DisplayChatMessage> list2 = this.message;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
        int i10 = 0;
        for (DisplayChatMessage j12 : list2) {
            if (j12.getType() == AgentMessageType.TEXT && i10 < arrayList.size()) {
                j12 = (DisplayChatMessage) arrayList.get(i10);
                i10++;
            }
            arrayList2.add(j12);
        }
        List<DisplayChatMessage> listP1 = Z8.F.p1(arrayList2);
        if (i10 == 0) {
            List<DisplayChatMessage> list3 = listP1;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                listP1.addAll(0, arrayList);
            } else {
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    if (((DisplayChatMessage) it.next()).getType() == AgentMessageType.TEXT) {
                        break;
                    }
                }
                listP1.addAll(0, arrayList);
            }
        }
        this.message = listP1;
        return true;
    }

    public final void Q(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.agentId = str;
    }

    public final void R(String str) {
        this.approvalRequestId = str;
    }

    public final void S(AskUserConversation askUserConversation) {
        this.askUserConversation = askUserConversation;
    }

    public final void T(int i10) {
        this.errorCode = i10;
    }

    public final void U(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.errorMessage = str;
    }

    public final void V(ChatHintType chatHintType) {
        kotlin.jvm.internal.p.i(chatHintType, "<set-?>");
        this.hint = chatHintType;
    }

    public final void W(int i10) {
        this.likeStatus = i10;
    }

    public final void X(List<DisplayChatMessage> list) {
        kotlin.jvm.internal.p.i(list, "<set-?>");
        this.message = list;
    }

    public final void Y(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.messageId = str;
    }

    public final void Z(boolean z10) {
        this.needActionBarShow = z10;
    }

    @Override // com.stepos.agentframework.chatui.S1
    public int a() {
        AgentRole agentRole = this.role;
        if (agentRole == AgentRole.ASSISTANT || agentRole != AgentRole.USER) {
            return 0;
        }
        int i10 = b.$EnumSwitchMapping$0[this.message.get(0).getType().ordinal()];
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2 && i10 != 3) {
                return i10 != 4 ? 0 : 3;
            }
        }
        return i11;
    }

    public final void a0(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.pairId = str;
    }

    public final void b0(Long l10) {
        this.processingDurationMs = l10;
    }

    public final boolean c() {
        List<String> list = this.uiActions;
        return list != null && list.contains("regenerate");
    }

    public final void c0(long j10) {
        this.processingStartAtMs = j10;
    }

    public final DisplayMessage d(String messageId, String pairId, String traceId, String sessionId, String requestSessionId, String agentId, List<DisplayChatMessage> message, long time, AgentRole role, List<String> suggestions, EReplyStatus status, int likeStatus, String viewSpliteId, boolean needActionBarShow, int errorCode, String errorMessage, String serverItemId, ChatHintType hint, SendState sendState, String approvalRequestId, AskUserConversation askUserConversation, List<ReferenceSource> sources, long processingStartAtMs, Long processingDurationMs, int variantIndex, int variantCount, List<String> uiActions, boolean releaseHeldCards) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(pairId, "pairId");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(requestSessionId, "requestSessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(role, "role");
        kotlin.jvm.internal.p.i(status, "status");
        kotlin.jvm.internal.p.i(viewSpliteId, "viewSpliteId");
        kotlin.jvm.internal.p.i(errorMessage, "errorMessage");
        kotlin.jvm.internal.p.i(serverItemId, "serverItemId");
        kotlin.jvm.internal.p.i(hint, "hint");
        kotlin.jvm.internal.p.i(sendState, "sendState");
        return new DisplayMessage(messageId, pairId, traceId, sessionId, requestSessionId, agentId, message, time, role, suggestions, status, likeStatus, viewSpliteId, needActionBarShow, errorCode, errorMessage, serverItemId, hint, sendState, approvalRequestId, askUserConversation, sources, processingStartAtMs, processingDurationMs, variantIndex, variantCount, uiActions, releaseHeldCards);
    }

    public final void d0(boolean z10) {
        this.releaseHeldCards = z10;
    }

    public final void e0(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.requestSessionId = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplayMessage)) {
            return false;
        }
        DisplayMessage displayMessage = (DisplayMessage) other;
        return kotlin.jvm.internal.p.d(this.messageId, displayMessage.messageId) && kotlin.jvm.internal.p.d(this.pairId, displayMessage.pairId) && kotlin.jvm.internal.p.d(this.traceId, displayMessage.traceId) && kotlin.jvm.internal.p.d(this.sessionId, displayMessage.sessionId) && kotlin.jvm.internal.p.d(this.requestSessionId, displayMessage.requestSessionId) && kotlin.jvm.internal.p.d(this.agentId, displayMessage.agentId) && kotlin.jvm.internal.p.d(this.message, displayMessage.message) && this.time == displayMessage.time && this.role == displayMessage.role && kotlin.jvm.internal.p.d(this.suggestions, displayMessage.suggestions) && this.status == displayMessage.status && this.likeStatus == displayMessage.likeStatus && kotlin.jvm.internal.p.d(this.viewSpliteId, displayMessage.viewSpliteId) && this.needActionBarShow == displayMessage.needActionBarShow && this.errorCode == displayMessage.errorCode && kotlin.jvm.internal.p.d(this.errorMessage, displayMessage.errorMessage) && kotlin.jvm.internal.p.d(this.serverItemId, displayMessage.serverItemId) && this.hint == displayMessage.hint && this.sendState == displayMessage.sendState && kotlin.jvm.internal.p.d(this.approvalRequestId, displayMessage.approvalRequestId) && kotlin.jvm.internal.p.d(this.askUserConversation, displayMessage.askUserConversation) && kotlin.jvm.internal.p.d(this.sources, displayMessage.sources) && this.processingStartAtMs == displayMessage.processingStartAtMs && kotlin.jvm.internal.p.d(this.processingDurationMs, displayMessage.processingDurationMs) && this.variantIndex == displayMessage.variantIndex && this.variantCount == displayMessage.variantCount && kotlin.jvm.internal.p.d(this.uiActions, displayMessage.uiActions) && this.releaseHeldCards == displayMessage.releaseHeldCards;
    }

    /* renamed from: f, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    public final void f0(AgentRole agentRole) {
        kotlin.jvm.internal.p.i(agentRole, "<set-?>");
        this.role = agentRole;
    }

    /* renamed from: g, reason: from getter */
    public final String getApprovalRequestId() {
        return this.approvalRequestId;
    }

    public final void g0(SendState sendState) {
        kotlin.jvm.internal.p.i(sendState, "<set-?>");
        this.sendState = sendState;
    }

    /* renamed from: h, reason: from getter */
    public final AskUserConversation getAskUserConversation() {
        return this.askUserConversation;
    }

    public final void h0(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.serverItemId = str;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.messageId.hashCode() * 31) + this.pairId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.requestSessionId.hashCode()) * 31) + this.agentId.hashCode()) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.time)) * 31) + this.role.hashCode()) * 31;
        List<String> list = this.suggestions;
        int iHashCode2 = (((((((((((((((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.status.hashCode()) * 31) + Integer.hashCode(this.likeStatus)) * 31) + this.viewSpliteId.hashCode()) * 31) + Boolean.hashCode(this.needActionBarShow)) * 31) + Integer.hashCode(this.errorCode)) * 31) + this.errorMessage.hashCode()) * 31) + this.serverItemId.hashCode()) * 31) + this.hint.hashCode()) * 31) + this.sendState.hashCode()) * 31;
        String str = this.approvalRequestId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        AskUserConversation askUserConversation = this.askUserConversation;
        int iHashCode4 = (iHashCode3 + (askUserConversation == null ? 0 : askUserConversation.hashCode())) * 31;
        List<ReferenceSource> list2 = this.sources;
        int iHashCode5 = (((iHashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31) + Long.hashCode(this.processingStartAtMs)) * 31;
        Long l10 = this.processingDurationMs;
        int iHashCode6 = (((((iHashCode5 + (l10 == null ? 0 : l10.hashCode())) * 31) + Integer.hashCode(this.variantIndex)) * 31) + Integer.hashCode(this.variantCount)) * 31;
        List<String> list3 = this.uiActions;
        return ((iHashCode6 + (list3 != null ? list3.hashCode() : 0)) * 31) + Boolean.hashCode(this.releaseHeldCards);
    }

    /* renamed from: i, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void i0(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.sessionId = str;
    }

    /* renamed from: j, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void j0(List<ReferenceSource> list) {
        this.sources = list;
    }

    /* renamed from: k, reason: from getter */
    public final ChatHintType getHint() {
        return this.hint;
    }

    public final void k0(EReplyStatus eReplyStatus) {
        kotlin.jvm.internal.p.i(eReplyStatus, "<set-?>");
        this.status = eReplyStatus;
    }

    /* renamed from: l, reason: from getter */
    public final int getLikeStatus() {
        return this.likeStatus;
    }

    public final void l0(List<String> list) {
        this.suggestions = list;
    }

    public final List<DisplayChatMessage> m() {
        return this.message;
    }

    public final void m0(long j10) {
        this.time = j10;
    }

    /* renamed from: n, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    public final void n0(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.traceId = str;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getNeedActionBarShow() {
        return this.needActionBarShow;
    }

    public final void o0(List<String> list) {
        this.uiActions = list;
    }

    /* renamed from: p, reason: from getter */
    public final String getPairId() {
        return this.pairId;
    }

    public final void p0(int i10) {
        this.variantCount = i10;
    }

    /* renamed from: q, reason: from getter */
    public final Long getProcessingDurationMs() {
        return this.processingDurationMs;
    }

    public final void q0(int i10) {
        this.variantIndex = i10;
    }

    /* renamed from: r, reason: from getter */
    public final long getProcessingStartAtMs() {
        return this.processingStartAtMs;
    }

    public final void r0(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.viewSpliteId = str;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getReleaseHeldCards() {
        return this.releaseHeldCards;
    }

    /* renamed from: t, reason: from getter */
    public final String getRequestSessionId() {
        return this.requestSessionId;
    }

    public String toString() {
        return "DisplayMessage(messageId=" + this.messageId + ", pairId=" + this.pairId + ", traceId=" + this.traceId + ", sessionId=" + this.sessionId + ", requestSessionId=" + this.requestSessionId + ", agentId=" + this.agentId + ", message=" + this.message + ", time=" + this.time + ", role=" + this.role + ", suggestions=" + this.suggestions + ", status=" + this.status + ", likeStatus=" + this.likeStatus + ", viewSpliteId=" + this.viewSpliteId + ", needActionBarShow=" + this.needActionBarShow + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", serverItemId=" + this.serverItemId + ", hint=" + this.hint + ", sendState=" + this.sendState + ", approvalRequestId=" + this.approvalRequestId + ", askUserConversation=" + this.askUserConversation + ", sources=" + this.sources + ", processingStartAtMs=" + this.processingStartAtMs + ", processingDurationMs=" + this.processingDurationMs + ", variantIndex=" + this.variantIndex + ", variantCount=" + this.variantCount + ", uiActions=" + this.uiActions + ", releaseHeldCards=" + this.releaseHeldCards + ")";
    }

    /* renamed from: u, reason: from getter */
    public final AgentRole getRole() {
        return this.role;
    }

    /* renamed from: v, reason: from getter */
    public final SendState getSendState() {
        return this.sendState;
    }

    /* renamed from: w, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final List<ReferenceSource> x() {
        return this.sources;
    }

    /* renamed from: y, reason: from getter */
    public final EReplyStatus getStatus() {
        return this.status;
    }

    public final List<String> z() {
        return this.suggestions;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayMessage(String messageId, String pairId, String traceId, String sessionId, String requestSessionId, String agentId, List<DisplayChatMessage> message, long j10, AgentRole role, List<String> list, EReplyStatus status, int i10, String viewSpliteId, boolean z10, int i11, String errorMessage, String serverItemId, ChatHintType hint, SendState sendState, String str, AskUserConversation askUserConversation, List<ReferenceSource> list2, long j11, Long l10, int i12, int i13, List<String> list3, boolean z11) {
        super(0, 1, null);
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(pairId, "pairId");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(requestSessionId, "requestSessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(role, "role");
        kotlin.jvm.internal.p.i(status, "status");
        kotlin.jvm.internal.p.i(viewSpliteId, "viewSpliteId");
        kotlin.jvm.internal.p.i(errorMessage, "errorMessage");
        kotlin.jvm.internal.p.i(serverItemId, "serverItemId");
        kotlin.jvm.internal.p.i(hint, "hint");
        kotlin.jvm.internal.p.i(sendState, "sendState");
        this.messageId = messageId;
        this.pairId = pairId;
        this.traceId = traceId;
        this.sessionId = sessionId;
        this.requestSessionId = requestSessionId;
        this.agentId = agentId;
        this.message = message;
        this.time = j10;
        this.role = role;
        this.suggestions = list;
        this.status = status;
        this.likeStatus = i10;
        this.viewSpliteId = viewSpliteId;
        this.needActionBarShow = z10;
        this.errorCode = i11;
        this.errorMessage = errorMessage;
        this.serverItemId = serverItemId;
        this.hint = hint;
        this.sendState = sendState;
        this.approvalRequestId = str;
        this.askUserConversation = askUserConversation;
        this.sources = list2;
        this.processingStartAtMs = j11;
        this.processingDurationMs = l10;
        this.variantIndex = i12;
        this.variantCount = i13;
        this.uiActions = list3;
        this.releaseHeldCards = z11;
    }

    public /* synthetic */ DisplayMessage(String str, String str2, String str3, String str4, String str5, String str6, List list, long j10, AgentRole agentRole, List list2, EReplyStatus eReplyStatus, int i10, String str7, boolean z10, int i11, String str8, String str9, ChatHintType chatHintType, SendState sendState, String str10, AskUserConversation askUserConversation, List list3, long j11, Long l10, int i12, int i13, List list4, boolean z11, int i14, kotlin.jvm.internal.i iVar) {
        this((i14 & 1) != 0 ? "" : str, (i14 & 2) != 0 ? "" : str2, (i14 & 4) != 0 ? "" : str3, (i14 & 8) != 0 ? "" : str4, (i14 & 16) != 0 ? "" : str5, (i14 & 32) != 0 ? "" : str6, (i14 & 64) != 0 ? new ArrayList() : list, (i14 & 128) != 0 ? 0L : j10, (i14 & 256) != 0 ? AgentRole.USER : agentRole, (i14 & 512) != 0 ? null : list2, (i14 & 1024) != 0 ? EReplyStatus.START : eReplyStatus, (i14 & 2048) != 0 ? 0 : i10, (i14 & 4096) != 0 ? "" : str7, (i14 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? true : z10, (i14 & 16384) != 0 ? 0 : i11, (i14 & 32768) != 0 ? "" : str8, (i14 & 65536) == 0 ? str9 : "", (i14 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? ChatHintType.NONE : chatHintType, (i14 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? SendState.SENT : sendState, (i14 & 524288) != 0 ? null : str10, (i14 & 1048576) != 0 ? null : askUserConversation, (i14 & 2097152) != 0 ? null : list3, (i14 & 4194304) != 0 ? 0L : j11, (i14 & 8388608) != 0 ? null : l10, (i14 & 16777216) != 0 ? 0 : i12, (i14 & Const.FLAG_MUTABLE) == 0 ? i13 : 1, (i14 & 67108864) != 0 ? null : list4, (i14 & 134217728) != 0 ? false : z11);
    }
}
